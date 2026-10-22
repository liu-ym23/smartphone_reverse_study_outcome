package h5;

import java.util.TimeZone;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final TimeZone f9294a = TimeZone.getTimeZone("UTC");

    public static boolean a(char c9, int i10, String str) {
        return i10 < str.length() && str.charAt(i10) == c9;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00f4 A[Catch: IllegalArgumentException | IndexOutOfBoundsException -> 0x004e, TRY_LEAVE, TryCatch #0 {IllegalArgumentException | IndexOutOfBoundsException -> 0x004e, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0037, B:13:0x003d, B:19:0x0058, B:21:0x0068, B:22:0x006a, B:24:0x0076, B:25:0x0079, B:27:0x007f, B:31:0x0089, B:36:0x0099, B:38:0x00a1, B:39:0x00a5, B:41:0x00ab, B:46:0x00b8, B:49:0x00c3, B:60:0x00ee, B:62:0x00f4, B:88:0x01a6, B:88:0x01a6, B:70:0x0106, B:70:0x0106, B:71:0x0121, B:71:0x0121, B:72:0x0122, B:72:0x0122, B:76:0x013f, B:76:0x013f, B:78:0x014c, B:78:0x014c, B:81:0x0155, B:81:0x0155, B:83:0x0174, B:83:0x0174, B:86:0x0183, B:86:0x0183, B:87:0x01a5, B:87:0x01a5, B:75:0x012e, B:75:0x012e, B:90:0x01d7, B:90:0x01d7, B:91:0x01de, B:91:0x01de, B:53:0x00d3, B:54:0x00d6, B:48:0x00bf), top: B:102:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01d7 A[Catch: IllegalArgumentException | IndexOutOfBoundsException -> 0x004e, IllegalArgumentException | IndexOutOfBoundsException -> 0x004e, TryCatch #0 {IllegalArgumentException | IndexOutOfBoundsException -> 0x004e, blocks: (B:3:0x0004, B:5:0x0017, B:6:0x0019, B:8:0x0025, B:9:0x0027, B:11:0x0037, B:13:0x003d, B:19:0x0058, B:21:0x0068, B:22:0x006a, B:24:0x0076, B:25:0x0079, B:27:0x007f, B:31:0x0089, B:36:0x0099, B:38:0x00a1, B:39:0x00a5, B:41:0x00ab, B:46:0x00b8, B:49:0x00c3, B:60:0x00ee, B:62:0x00f4, B:88:0x01a6, B:88:0x01a6, B:70:0x0106, B:70:0x0106, B:71:0x0121, B:71:0x0121, B:72:0x0122, B:72:0x0122, B:76:0x013f, B:76:0x013f, B:78:0x014c, B:78:0x014c, B:81:0x0155, B:81:0x0155, B:83:0x0174, B:83:0x0174, B:86:0x0183, B:86:0x0183, B:87:0x01a5, B:87:0x01a5, B:75:0x012e, B:75:0x012e, B:90:0x01d7, B:90:0x01d7, B:91:0x01de, B:91:0x01de, B:53:0x00d3, B:54:0x00d6, B:48:0x00bf), top: B:102:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Date b(java.lang.String r17, java.text.ParsePosition r18) throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 562
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h5.a.b(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    public static int c(int i10, int i11, String str) {
        int i12;
        int i13;
        if (i10 < 0 || i11 > str.length() || i10 > i11) {
            throw new NumberFormatException(str);
        }
        if (i10 < i11) {
            i13 = i10 + 1;
            int iDigit = Character.digit(str.charAt(i10), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i10, i11));
            }
            i12 = -iDigit;
        } else {
            i12 = 0;
            i13 = i10;
        }
        while (i13 < i11) {
            int i14 = i13 + 1;
            int iDigit2 = Character.digit(str.charAt(i13), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i10, i11));
            }
            i12 = (i12 * 10) - iDigit2;
            i13 = i14;
        }
        return -i12;
    }
}
