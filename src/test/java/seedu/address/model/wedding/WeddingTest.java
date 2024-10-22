package seedu.address.model.wedding;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import seedu.address.model.person.PersonId;

import java.util.ArrayList;
import java.util.List;

public class WeddingTest {
    PersonId[] ids = {new PersonId()};
    List<PersonId> assignees = List.of(ids);
    Wedding wedding = new Wedding("Name", "Date", assignees);
    Wedding otherWedding = new Wedding("Other", "Date");

    @Test
    public void isSameWedding_sameObject_true() {
        boolean result = wedding.isSameWedding(wedding);
        assertTrue(result);
    }

    @Test
    public void isSameWedding_diffObject_false() {
        boolean result = wedding.isSameWedding(otherWedding);
        assertFalse(result);
    }

    @Test
    public void equals() {
        //same object
        assertTrue(wedding.equals(wedding));

        //different name
        assertFalse(wedding.equals(otherWedding));

        //null
        assertFalse(wedding.equals(null));

        //different type
        assertFalse(wedding.equals(5));

        //different object, same name, date and assignees
        Wedding equalWedding = new Wedding("Name", "Date", assignees);
        assertTrue(wedding.equals(equalWedding));

        //different object, different name, same date and assignees
        Wedding diffName = new Wedding("Diff", "Date", assignees);
        assertFalse(wedding.equals(diffName));

        //different object, same name, different date, same assignees
        Wedding diffDate = new Wedding("Name", "diffDate", assignees);
        assertFalse(wedding.equals(diffDate));

        //different object, same name, same date, different assignees
        Wedding diffAssignees = new Wedding("Name", "Date");
        assertFalse(wedding.equals(diffAssignees));
    }
}
