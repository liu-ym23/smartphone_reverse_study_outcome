package E1;

import java.util.TimeZone;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final TimeZone f1312a = TimeZone.getTimeZone("UTC");

    private static boolean a(String str, int i5, char c6) {
        return i5 < str.length() && str.charAt(i5) == c6;
    }

    private static int b(String str, int i5) {
        while (i5 < str.length()) {
            char cCharAt = str.charAt(i5);
            if (cCharAt < '0' || cCharAt > '9') {
                return i5;
            }
            i5++;
        }
        return str.length();
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00d8 A[Catch: IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x004a, TryCatch #0 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x004a, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0036, B:13:0x003c, B:19:0x0054, B:21:0x0064, B:22:0x0066, B:24:0x0072, B:25:0x0075, B:27:0x007b, B:31:0x0085, B:36:0x0095, B:38:0x009d, B:49:0x00d2, B:51:0x00d8, B:53:0x00de, B:77:0x018b, B:57:0x00e8, B:58:0x0103, B:59:0x0104, B:63:0x0120, B:65:0x012d, B:68:0x0136, B:70:0x0155, B:73:0x0164, B:74:0x0186, B:76:0x0189, B:62:0x010f, B:79:0x01bc, B:80:0x01c3, B:42:0x00b5, B:43:0x00b8), top: B:91:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01bc A[Catch: IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x004a, TryCatch #0 {IndexOutOfBoundsException | NumberFormatException | IllegalArgumentException -> 0x004a, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0036, B:13:0x003c, B:19:0x0054, B:21:0x0064, B:22:0x0066, B:24:0x0072, B:25:0x0075, B:27:0x007b, B:31:0x0085, B:36:0x0095, B:38:0x009d, B:49:0x00d2, B:51:0x00d8, B:53:0x00de, B:77:0x018b, B:57:0x00e8, B:58:0x0103, B:59:0x0104, B:63:0x0120, B:65:0x012d, B:68:0x0136, B:70:0x0155, B:73:0x0164, B:74:0x0186, B:76:0x0189, B:62:0x010f, B:79:0x01bc, B:80:0x01c3, B:42:0x00b5, B:43:0x00b8), top: B:91:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Date c(java.lang.String r18, java.text.ParsePosition r19) throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 556
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: E1.a.c(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static int d(String str, int i5, int i6) {
        int i7;
        int i8;
        if (i5 < 0 || i6 > str.length() || i5 > i6) {
            throw new NumberFormatException(str);
        }
        if (i5 < i6) {
            i8 = i5 + 1;
            int iDigit = Character.digit(str.charAt(i5), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i5, i6));
            }
            i7 = -iDigit;
        } else {
            i7 = 0;
            i8 = i5;
        }
        while (i8 < i6) {
            int i9 = i8 + 1;
            int iDigit2 = Character.digit(str.charAt(i8), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i5, i6));
            }
            i7 = (i7 * 10) - iDigit2;
            i8 = i9;
        }
        return -i7;
    }
}
