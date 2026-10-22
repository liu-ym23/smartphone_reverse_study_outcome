package Y1;

import X1.d;
import X1.e;
import Z1.f;
import com.ethlo.time.Field;
import io.ktor.util.date.GMTDateParser;
import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;
import java.util.Arrays;

/* loaded from: classes.dex */
public class b implements X1.b {

    /* renamed from: a, reason: collision with root package name */
    public static final X1.b f6989a = new b();

    public static void a(int i10, String str, d dVar) {
        int i11 = i10 + 10;
        if (dVar.c(str.charAt(i11))) {
            return;
        }
        int length = dVar.a().length;
        char[] cArrA = dVar.a();
        throw new DateTimeParseException(String.format("Expected character %s at position %d, found %s: %s", length > 1 ? Arrays.toString(cArrA) : Character.toString(cArrA[0]), Integer.valueOf(i10 + 11), Character.valueOf(str.charAt(i11)), str), str, i11);
    }

    public static void b(int i10, d dVar, String str, int i11) {
        int i12;
        if (dVar.d() && i10 == 0 && str.length() > (i12 = i11 + 1)) {
            throw new DateTimeParseException(String.format("Trailing junk data after position %d: %s", Integer.valueOf(i11 + 2), str), str, i12);
        }
    }

    public static X1.a c(int i10, d dVar, int i11, int i12, int i13, int i14, int i15, String str) {
        char cCharAt;
        int i16 = i10 + 20;
        int i17 = 0;
        int i18 = 0;
        while (i16 < str.length() && (cCharAt = str.charAt(i16)) >= '0' && cCharAt <= '9') {
            i18++;
            i17 = (i17 * 10) + (cCharAt - '0');
            i16++;
        }
        Z1.d.a(str, i18, (i16 - 1) + i10);
        int i19 = i17;
        for (int i20 = i18; i20 < 9; i20++) {
            i19 *= 10;
        }
        e eVarN = n(i10, dVar, str, i16);
        return new X1.a(Field.NANO, i11, i12, i13, i14, i15, m(i10, str), i19, eVarN, i18, (i16 + (eVarN != null ? eVarN.c() : 0)) - i10);
    }

    public static X1.a d(int i10, int i11, int i12, int i13, int i14, int i15, String str, e eVar) {
        int iM = m(i10, str);
        Field field = Field.SECOND;
        return new X1.a(field, i11, i12, i13, i14, i15, iM, 0, eVar, 0, field.getRequiredLength() + (eVar != null ? eVar.c() : 0));
    }

    public static X1.a e(int i10, d dVar, String str, int i11, int i12, int i13, int i14, int i15) {
        int i16 = i10 + 16;
        char cCharAt = str.charAt(i16);
        if (cCharAt != '+' && cCharAt != '-') {
            if (cCharAt == ':') {
                return f(i10, dVar, i11, i12, i13, i14, i15, str);
            }
            if (cCharAt != 'Z' && cCharAt != 'z') {
                throw Z1.d.d(str, i16, ':', 'Z', GMTDateParser.ZONE, '+', '-');
            }
        }
        e eVarN = n(i10, dVar, str, i16);
        Field field = Field.MINUTE;
        return new X1.a(field, i11, i12, i13, i14, i15, 0, 0, eVarN, 0, field.getRequiredLength() + (eVarN != null ? eVarN.c() : 0));
    }

    public static X1.a f(int i10, d dVar, int i11, int i12, int i13, int i14, int i15, String str) {
        int length = str.length() - i10;
        if (length <= 19) {
            if (length != 19) {
                throw Z1.d.e(str, i10 + 16);
            }
            return new X1.a(Field.SECOND, i11, i12, i13, i14, i15, m(i10, str), 0, null, 0, length);
        }
        int i16 = i10 + 19;
        char cCharAt = str.charAt(i16);
        if (dVar.e(cCharAt)) {
            return c(i10, dVar, i11, i12, i13, i14, i15, str);
        }
        if (cCharAt == 'Z' || cCharAt == 'z') {
            return d(i10, i11, i12, i13, i14, i15, str, e.f6846c);
        }
        if (cCharAt == '+' || cCharAt == '-') {
            return d(i10, i11, i12, i13, i14, i15, str, n(i10, dVar, str, i16));
        }
        throw Z1.d.d(str, i16, Z1.a.a(dVar.b(), new char[]{'Z', GMTDateParser.ZONE, '+', '-'}));
    }

    public static OffsetDateTime g(String str, int i10) {
        X1.a aVarJ = j(str, d.f6842e, i10);
        if (aVarJ.k(Field.SECOND)) {
            return aVarJ.n();
        }
        Field fieldF = aVarJ.f();
        throw new DateTimeParseException(String.format("Unexpected end of input, missing field %s: %s", Field.values()[fieldF.ordinal() + 1], str), str, fieldF.getRequiredLength());
    }

    public static int h(String str, int i10) {
        return f.d(str, i10 + 8, i10 + 10);
    }

    public static int i(String str, int i10) {
        return f.d(str, i10 + 11, i10 + 13);
    }

    public static X1.a j(String str, d dVar, int i10) {
        int iP = p(str, i10);
        int iO = o(str, i10);
        if (4 == iP) {
            return new X1.a(Field.YEAR, iO, 0, 0, 0, 0, 0, 0, null, 0, iP);
        }
        Field field = Field.MONTH;
        Z1.d.b(field, str, i10 + 4, '-');
        int iL = l(str, i10);
        if (7 == iP) {
            return new X1.a(field, iO, iL, 0, 0, 0, 0, 0, null, 0, iP);
        }
        Field field2 = Field.DAY;
        Z1.d.b(field2, str, i10 + 7, '-');
        int iH = h(str, i10);
        if (10 == iP) {
            return new X1.a(field2, iO, iL, iH, 0, 0, 0, 0, null, 0, iP);
        }
        a(i10, str, dVar);
        int i11 = i(str, i10);
        Field field3 = Field.MINUTE;
        Z1.d.b(field3, str, i10 + 13, ':');
        int iK = k(str, i10);
        return iP == 16 ? new X1.a(field3, iO, iL, iH, i11, iK, 0, 0, null, 0, 16) : e(i10, dVar, str, iO, iL, iH, i11, iK);
    }

    public static int k(String str, int i10) {
        return f.d(str, i10 + 14, i10 + 16);
    }

    public static int l(String str, int i10) {
        return f.d(str, i10 + 5, i10 + 7);
    }

    public static int m(int i10, String str) {
        return f.d(str, i10 + 17, i10 + 19);
    }

    public static e n(int i10, d dVar, String str, int i11) {
        if (i11 >= str.length()) {
            return null;
        }
        int length = str.length() - i11;
        char cCharAt = str.charAt(i11);
        if (cCharAt == 'Z' || cCharAt == 'z') {
            b(i10, dVar, str, i11);
            return e.f6846c;
        }
        char cCharAt2 = str.charAt(i11);
        if (cCharAt2 != '+' && cCharAt2 != '-') {
            Z1.d.d(str, i11, 'Z', GMTDateParser.ZONE, '+', '-');
        }
        if (length < 6) {
            throw new DateTimeParseException(String.format("Invalid timezone offset: %s", str), str, i11);
        }
        int iD = f.d(str, i11 + 1, i11 + 3);
        int iD2 = f.d(str, i11 + 4, i11 + 6);
        if (cCharAt2 == '-') {
            iD = -iD;
            iD2 = -iD2;
            if (iD == 0 && iD2 == 0) {
                throw new DateTimeParseException("Unknown 'Local Offset Convention' date-time not allowed", str, i11);
            }
        }
        b(i10, dVar, str, i11 + 5);
        return e.e(iD, iD2);
    }

    public static int o(String str, int i10) {
        return f.d(str, i10, i10 + 4);
    }

    public static int p(String str, int i10) {
        if (str == null) {
            throw new NullPointerException("text cannot be null");
        }
        int length = str.length() - i10;
        if (length < 0) {
            throw new IndexOutOfBoundsException(String.format("offset is %d which is equal to or larger than the input length of %d", Integer.valueOf(i10), Integer.valueOf(str.length())));
        }
        if (i10 >= 0) {
            return length;
        }
        throw new IndexOutOfBoundsException(String.format("offset cannot be negative, was %d", Integer.valueOf(i10)));
    }
}
