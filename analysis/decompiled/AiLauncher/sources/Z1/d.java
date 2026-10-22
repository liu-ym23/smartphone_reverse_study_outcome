package Z1;

import com.ethlo.time.Field;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

/* loaded from: classes.dex */
public class d {
    public static void a(String str, int i10, int i11) {
        if (i10 == 0) {
            throw new DateTimeParseException(String.format("Must have at least 1 fraction digit: %s", str), str, i11);
        }
        if (i10 > 9) {
            throw new DateTimeParseException(String.format("Maximum supported number of fraction digits in second is 9, got %d: %s", Integer.valueOf(i10), str), str, i11);
        }
    }

    public static void b(Field field, String str, int i10, char c10) {
        if (i10 >= str.length()) {
            throw c(field, str, i10);
        }
        if (str.charAt(i10) != c10) {
            throw new DateTimeParseException(String.format("Expected character %s at position %d, found %s: %s", Character.valueOf(c10), Integer.valueOf(i10 + 1), Character.valueOf(str.charAt(i10)), str), str, i10);
        }
    }

    public static DateTimeParseException c(Field field, String str, int i10) {
        throw new DateTimeParseException(String.format("Unexpected end of input, missing field %s: %s", field.name(), str), str, i10);
    }

    public static DateTimeParseException d(String str, int i10, char... cArr) {
        throw new DateTimeParseException(String.format("Expected character %s at position %d, found %s: %s", Arrays.toString(cArr), Integer.valueOf(i10 + 1), Character.valueOf(str.charAt(i10)), str), str, i10);
    }

    public static DateTimeParseException e(String str, int i10) {
        throw new DateTimeParseException(String.format("Unexpected end of input: %s", str), str, i10);
    }
}
