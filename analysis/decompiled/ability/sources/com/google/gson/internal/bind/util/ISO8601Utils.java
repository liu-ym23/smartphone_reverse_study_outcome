package com.google.gson.internal.bind.util;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public class ISO8601Utils {
    private static final String UTC_ID = "UTC";
    private static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);

    private ISO8601Utils() {
    }

    private static boolean checkOffset(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    public static String format(Date date) {
        return format(date, false, TIMEZONE_UTC);
    }

    private static int indexOfNonDigit(String str, int i) {
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt < '0' || cCharAt > '9') {
                return i;
            }
            i++;
        }
        return str.length();
    }

    private static void padInt(StringBuilder sb, int i, int i6) {
        String string = Integer.toString(i);
        for (int length = i6 - string.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(string);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00e5 A[Catch: IllegalArgumentException | IndexOutOfBoundsException -> 0x0056, TryCatch #0 {IllegalArgumentException | IndexOutOfBoundsException -> 0x0056, blocks: (B:3:0x000c, B:5:0x001f, B:6:0x0021, B:8:0x002d, B:9:0x002f, B:11:0x003f, B:13:0x0045, B:19:0x005f, B:21:0x006f, B:22:0x0071, B:24:0x007d, B:25:0x0080, B:27:0x0086, B:31:0x0090, B:36:0x00a0, B:38:0x00a8, B:50:0x00df, B:52:0x00e5, B:54:0x00eb, B:80:0x017c, B:60:0x00fc, B:61:0x0112, B:62:0x0113, B:66:0x0123, B:68:0x0130, B:71:0x0139, B:73:0x014b, B:76:0x015a, B:77:0x0177, B:79:0x017a, B:65:0x011f, B:82:0x01ae, B:83:0x01b5, B:43:0x00c2, B:44:0x00c5), top: B:94:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01ae A[Catch: IllegalArgumentException | IndexOutOfBoundsException -> 0x0056, TryCatch #0 {IllegalArgumentException | IndexOutOfBoundsException -> 0x0056, blocks: (B:3:0x000c, B:5:0x001f, B:6:0x0021, B:8:0x002d, B:9:0x002f, B:11:0x003f, B:13:0x0045, B:19:0x005f, B:21:0x006f, B:22:0x0071, B:24:0x007d, B:25:0x0080, B:27:0x0086, B:31:0x0090, B:36:0x00a0, B:38:0x00a8, B:50:0x00df, B:52:0x00e5, B:54:0x00eb, B:80:0x017c, B:60:0x00fc, B:61:0x0112, B:62:0x0113, B:66:0x0123, B:68:0x0130, B:71:0x0139, B:73:0x014b, B:76:0x015a, B:77:0x0177, B:79:0x017a, B:65:0x011f, B:82:0x01ae, B:83:0x01b5, B:43:0x00c2, B:44:0x00c5), top: B:94:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Date parse(java.lang.String r19, java.text.ParsePosition r20) throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 510
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.util.ISO8601Utils.parse(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static int parseInt(String str, int i, int i6) throws NumberFormatException {
        int i10;
        int i11;
        if (i < 0 || i6 > str.length() || i > i6) {
            throw new NumberFormatException(str);
        }
        if (i < i6) {
            i11 = i + 1;
            int iDigit = Character.digit(str.charAt(i), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i6));
            }
            i10 = -iDigit;
        } else {
            i10 = 0;
            i11 = i;
        }
        while (i11 < i6) {
            int i12 = i11 + 1;
            int iDigit2 = Character.digit(str.charAt(i11), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i, i6));
            }
            i10 = (i10 * 10) - iDigit2;
            i11 = i12;
        }
        return -i10;
    }

    public static String format(Date date, boolean z10) {
        return format(date, z10, TIMEZONE_UTC);
    }

    public static String format(Date date, boolean z10, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(19 + (z10 ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        padInt(sb, gregorianCalendar.get(1), 4);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append('-');
        padInt(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        padInt(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        padInt(sb, gregorianCalendar.get(13), 2);
        if (z10) {
            sb.append('.');
            padInt(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i = offset / 60000;
            int iAbs = Math.abs(i / 60);
            int iAbs2 = Math.abs(i % 60);
            sb.append(offset >= 0 ? '+' : '-');
            padInt(sb, iAbs, 2);
            sb.append(':');
            padInt(sb, iAbs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }
}
