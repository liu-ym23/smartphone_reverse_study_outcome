package com.fasterxml.jackson.databind.util;

import androidx.activity.b;
import com.fasterxml.jackson.core.JsonFactory;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Deprecated
/* loaded from: classes.dex */
public class ISO8601Utils {
    protected static final int DEF_8601_LEN = 29;
    private static final TimeZone TIMEZONE_Z = TimeZone.getTimeZone("UTC");

    private static boolean checkOffset(String str, int i, char c9) {
        return i < str.length() && str.charAt(i) == c9;
    }

    public static String format(Date date, boolean z10, TimeZone timeZone, Locale locale) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, locale);
        gregorianCalendar.setTime(date);
        StringBuilder sb2 = new StringBuilder(30);
        sb2.append(String.format("%04d-%02d-%02dT%02d:%02d:%02d", Integer.valueOf(gregorianCalendar.get(1)), Integer.valueOf(gregorianCalendar.get(2) + 1), Integer.valueOf(gregorianCalendar.get(5)), Integer.valueOf(gregorianCalendar.get(11)), Integer.valueOf(gregorianCalendar.get(12)), Integer.valueOf(gregorianCalendar.get(13))));
        if (z10) {
            sb2.append(String.format(".%03d", Integer.valueOf(gregorianCalendar.get(14))));
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i = offset / 60000;
            sb2.append(String.format("%c%02d:%02d", Character.valueOf(offset < 0 ? '-' : '+'), Integer.valueOf(Math.abs(i / 60)), Integer.valueOf(Math.abs(i % 60))));
        } else {
            sb2.append('Z');
        }
        return sb2.toString();
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

    public static Date parse(String str, ParsePosition parsePosition) throws ParseException {
        int i;
        int i3;
        int i10;
        int i11;
        int i12;
        int length;
        TimeZone timeZone;
        char cCharAt;
        Objects.requireNonNull(str);
        try {
            int index = parsePosition.getIndex();
            int i13 = index + 4;
            int i14 = parseInt(str, index, i13);
            if (checkOffset(str, i13, '-')) {
                i13 = index + 5;
            }
            int i15 = i13 + 2;
            int i16 = parseInt(str, i13, i15);
            if (checkOffset(str, i15, '-')) {
                i15 = i13 + 3;
            }
            int i17 = i15 + 2;
            int i18 = parseInt(str, i15, i17);
            boolean zCheckOffset = checkOffset(str, i17, 'T');
            if (!zCheckOffset && str.length() <= i17) {
                GregorianCalendar gregorianCalendar = new GregorianCalendar(i14, i16 - 1, i18);
                parsePosition.setIndex(i17);
                return gregorianCalendar.getTime();
            }
            if (zCheckOffset) {
                int i19 = i15 + 5;
                int i20 = parseInt(str, i15 + 3, i19);
                if (checkOffset(str, i19, ':')) {
                    i19 = i15 + 6;
                }
                int i21 = i19 + 2;
                int i22 = parseInt(str, i19, i21);
                if (checkOffset(str, i21, ':')) {
                    i21 = i19 + 3;
                }
                if (str.length() <= i21 || (cCharAt = str.charAt(i21)) == 'Z' || cCharAt == '+' || cCharAt == '-') {
                    i17 = i21;
                    i3 = i20;
                    i10 = i22;
                    i11 = 0;
                    i12 = 0;
                } else {
                    int i23 = i21 + 2;
                    i12 = parseInt(str, i21, i23);
                    if (i12 > 59 && i12 < 63) {
                        i12 = 59;
                    }
                    if (checkOffset(str, i23, '.')) {
                        int i24 = i21 + 3;
                        int iIndexOfNonDigit = indexOfNonDigit(str, i21 + 4);
                        int iMin = Math.min(iIndexOfNonDigit, i21 + 6);
                        int i25 = parseInt(str, i24, iMin);
                        int i26 = iMin - i24;
                        if (i26 == 1) {
                            i25 *= 100;
                        } else if (i26 == 2) {
                            i25 *= 10;
                        }
                        i3 = i20;
                        i17 = iIndexOfNonDigit;
                        i10 = i22;
                        i11 = i25;
                    } else {
                        i3 = i20;
                        i17 = i23;
                        i10 = i22;
                        i11 = 0;
                    }
                }
                i = 1;
            } else {
                i = 1;
                i3 = 0;
                i10 = 0;
                i11 = 0;
                i12 = 0;
            }
            if (str.length() <= i17) {
                throw new IllegalArgumentException("No time zone indicator");
            }
            char cCharAt2 = str.charAt(i17);
            if (cCharAt2 == 'Z') {
                timeZone = TIMEZONE_Z;
                length = i17 + 1;
            } else {
                if (cCharAt2 != '+' && cCharAt2 != '-') {
                    throw new IndexOutOfBoundsException("Invalid time zone indicator '" + cCharAt2 + "'");
                }
                String strSubstring = str.substring(i17);
                length = i17 + strSubstring.length();
                if ("+0000".equals(strSubstring) || "+00:00".equals(strSubstring)) {
                    timeZone = TIMEZONE_Z;
                } else {
                    String strConcat = "GMT".concat(strSubstring);
                    TimeZone timeZone2 = TimeZone.getTimeZone(strConcat);
                    String id2 = timeZone2.getID();
                    if (!id2.equals(strConcat) && !id2.replace(":", "").equals(strConcat)) {
                        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + strConcat + " given, resolves to " + timeZone2.getID());
                    }
                    timeZone = timeZone2;
                }
            }
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(timeZone);
            gregorianCalendar2.setLenient(false);
            int i27 = i;
            gregorianCalendar2.set(i27, i14);
            gregorianCalendar2.set(2, i16 - i27);
            gregorianCalendar2.set(5, i18);
            gregorianCalendar2.set(11, i3);
            gregorianCalendar2.set(12, i10);
            gregorianCalendar2.set(13, i12);
            gregorianCalendar2.set(14, i11);
            parsePosition.setIndex(length);
            return gregorianCalendar2.getTime();
        } catch (Exception e10) {
            String str2 = "\"" + str + JsonFactory.DEFAULT_QUOTE_CHAR;
            String message = e10.getMessage();
            if (message == null || message.isEmpty()) {
                message = "(" + e10.getClass().getName() + ")";
            }
            ParseException parseException = new ParseException(b.j("Failed to parse date ", str2, ": ", message), parsePosition.getIndex());
            parseException.initCause(e10);
            throw parseException;
        }
    }

    private static int parseInt(String str, int i, int i3) {
        int i10;
        int i11;
        if (i < 0 || i3 > str.length() || i > i3) {
            throw new NumberFormatException(str);
        }
        if (i < i3) {
            i11 = i + 1;
            int iDigit = Character.digit(str.charAt(i), 10);
            if (iDigit < 0) {
                throw new NumberFormatException("Invalid number: ".concat(str.substring(i, i3)));
            }
            i10 = -iDigit;
        } else {
            i10 = 0;
            i11 = i;
        }
        while (i11 < i3) {
            int i12 = i11 + 1;
            int iDigit2 = Character.digit(str.charAt(i11), 10);
            if (iDigit2 < 0) {
                throw new NumberFormatException("Invalid number: ".concat(str.substring(i, i3)));
            }
            i10 = (i10 * 10) - iDigit2;
            i11 = i12;
        }
        return -i10;
    }

    public static String format(Date date, boolean z10) {
        return format(date, z10, TIMEZONE_Z);
    }

    @Deprecated
    public static String format(Date date, boolean z10, TimeZone timeZone) {
        return format(date, z10, timeZone, Locale.US);
    }

    public static String format(Date date) {
        return format(date, false, TIMEZONE_Z);
    }
}
