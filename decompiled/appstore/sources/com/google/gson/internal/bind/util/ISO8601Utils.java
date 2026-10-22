package com.google.gson.internal.bind.util;

import com.bytedanceos.common.ad.common.AdConstant;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.http.message.TokenParser;

/* JADX INFO: loaded from: classes3.dex */
public class ISO8601Utils {
    private static final TimeZone TIMEZONE_UTC = null;
    private static final String UTC_ID = "UTC";

    static {
        TIMEZONE_UTC = TimeZone.getTimeZone(UTC_ID);
    }

    public ISO8601Utils() {
    }

    private static boolean checkOffset(String r10, int r11, char r12) {
        if (r11 < r10.length()) goto L5;
    L7:
        return false;
    L5:
        if (r10.charAt(r11) != r12) goto L7;
        return true;
    }

    public static String format(Date r10) {
        return format(r10, false, TIMEZONE_UTC);
    }

    private static int indexOfNonDigit(String r10, int r11) {
    L3:
        if (r11 >= r10.length()) goto L12;
        char r12 = r10.charAt(r11);
        if (r12 < '0') goto L10;
        if (r12 > '9') goto L10;
        r11 = r11 + 1;
    L10:
        return r11;
    L12:
        return r10.length();
    }

    private static void padInt(StringBuilder r10, int r11, int r12) {
        String r13 = Integer.toString(r11);
        int r14 = r12 - r13.length();
    L3:
        if (r14 <= 0) goto L5;
        r10.append('0');
        r14 = r14 - 1;
        goto L3
    L5:
        r10.append(r13);
    }

    public static Date parse(String r19, ParsePosition r20) throws ParseException {
        int r10 = r20.getIndex();     // Catch: Throwable -> L15
        int r11 = r10 + 4;     // Catch: Throwable -> L15
        int r12 = parseInt(r19, r10, r11);     // Catch: Throwable -> L15
        if (checkOffset(r19, r11, '-') == false) goto L6;
        r11 = r10 + 5;     // Catch: Throwable -> L15
    L6:
        int r13 = r11 + 2;     // Catch: Throwable -> L15
        int r14 = parseInt(r19, r11, r13);     // Catch: Throwable -> L15
        if (checkOffset(r19, r13, '-') == false) goto L9;
        r13 = r11 + 3;     // Catch: Throwable -> L15
    L9:
        int r15 = r13 + 2;     // Catch: Throwable -> L15
        int r16 = parseInt(r19, r13, r15);     // Catch: Throwable -> L15
        boolean r17 = checkOffset(r19, r15, 'T');     // Catch: Throwable -> L15
        if (r17 == true) goto L18;
        if (r19.length() > r15) goto L18;
        GregorianCalendar r18 = new GregorianCalendar(r12, r14 - 1, r16);     // Catch: Throwable -> L15
        r20.setIndex(r15);     // Catch: Throwable -> L15
        return r18.getTime();
    L18:
        if (r17 == false) goto L47;
        int r21 = r13 + 5;     // Catch: Throwable -> L15
        int r22 = parseInt(r19, r13 + 3, r21);     // Catch: Throwable -> L15
        if (checkOffset(r19, r21, ':') == false) goto L22;
        r21 = r13 + 6;     // Catch: Throwable -> L15
    L22:
        int r23 = r21 + 2;     // Catch: Throwable -> L15
        int r110 = parseInt(r19, r21, r23);     // Catch: Throwable -> L15
        if (checkOffset(r19, r23, ':') == false) goto L26;
        r23 = r21 + 3;     // Catch: Throwable -> L15
    L26:
        if (r19.length() <= r23) goto L46;
        char r24 = r19.charAt(r23);     // Catch: Throwable -> L15
        if (r24 == 'Z') goto L46;
        if (r24 == '+') goto L46;
        if (r24 == '-') goto L46;
        int r25 = r23 + 2;     // Catch: Throwable -> L15
        int r111 = parseInt(r19, r23, r25);     // Catch: Throwable -> L15
        if (r111 <= 59) goto L37;
        if (r111 >= 63) goto L37;
        r111 = 59;
    L37:
        if (checkOffset(r19, r25, '.') == false) goto L45;
        int r26 = r23 + 3;     // Catch: Throwable -> L15
        int r112 = indexOfNonDigit(r19, r23 + 4);     // Catch: Throwable -> L15
        int r27 = Math.min(r112, r23 + 6);     // Catch: Throwable -> L15
        int r113 = parseInt(r19, r26, r27);     // Catch: Throwable -> L15
        int r28 = r27 - r26;     // Catch: Throwable -> L15
        if (r28 == 1) goto L43;
        if (r28 != 2) goto L44;
        r113 = r113 * 10;     // Catch: Throwable -> L15
    L44:
        int r29 = r22;
        r15 = r112;
        int r30 = r110;
        int r114 = r113;
    L49:
        if (r19.length() <= r15) goto L79;
        char r115 = r19.charAt(r15);     // Catch: Throwable -> L15
        if (r115 != 'Z') goto L53;
        TimeZone r31 = TIMEZONE_UTC;     // Catch: Throwable -> L15
        int r32 = r15 + 1;     // Catch: Throwable -> L15
    L76:
        GregorianCalendar r33 = new GregorianCalendar(r31);     // Catch: Throwable -> L15
        r33.setLenient(false);     // Catch: Throwable -> L15
        r33.set(1, r12);     // Catch: Throwable -> L15
        r33.set(2, r14 - 1);     // Catch: Throwable -> L15
        r33.set(5, r16);     // Catch: Throwable -> L15
        r33.set(11, r29);     // Catch: Throwable -> L15
        r33.set(12, r30);     // Catch: Throwable -> L15
        r33.set(13, r111);     // Catch: Throwable -> L15
        r33.set(14, r114);     // Catch: Throwable -> L15
        r20.setIndex(r32);     // Catch: Throwable -> L15
        return r33.getTime();
    L53:
        if (r115 == '+') goto L58;
        if (r115 == '-') goto L58;
        throw new IndexOutOfBoundsException("Invalid time zone indicator '" + r115 + "'");     // Catch: Throwable -> L15
    L58:
        String r34 = r19.substring(r15);     // Catch: Throwable -> L15
        if (r34.length() >= 5) goto L62;
        r34 = r34 + AdConstant.OperatorCode.CHINA_TELECOM;     // Catch: Throwable -> L15
    L62:
        r32 = r15 + r34.length();     // Catch: Throwable -> L15
        if ("+0000".equals(r34) == false) goto L65;
    L75:
        r31 = TIMEZONE_UTC;     // Catch: Throwable -> L15
        goto L76
    L65:
        if ("+00:00".equals(r34) == true) goto L75;
        String r35 = "GMT" + r34;     // Catch: Throwable -> L15
        TimeZone r116 = TimeZone.getTimeZone(r35);     // Catch: Throwable -> L15
        String r117 = r116.getID();     // Catch: Throwable -> L15
        if (r117.equals(r35) == false) goto L70;
    L74:
        r31 = r116;
        goto L76
    L70:
        if (r117.replace(":", "").equals(r35) == true) goto L74;
        throw new IndexOutOfBoundsException("Mismatching time zone indicator: " + r35 + " given, resolves to " + r116.getID());     // Catch: Throwable -> L15
    L79:
        throw new IllegalArgumentException("No time zone indicator");     // Catch: Throwable -> L15
    L43:
        r113 = r113 * 100;     // Catch: Throwable -> L15
        goto L44
    L45:
        r29 = r22;
        r15 = r25;
        r30 = r110;
        r114 = 0;
    L46:
        r30 = r110;
        r114 = 0;
        r111 = 0;
        r15 = r23;
        r29 = r22;
        goto L49
    L47:
        r29 = 0;
        r30 = 0;
        r114 = 0;
        r111 = 0;
    L15:
        e = move-exception;
        if (r19 != null) goto L82;
        String r36 = null;
    L83:
        String r37 = e.getMessage();
        if (r37 != null) goto L86;
    L87:
        r37 = "(" + e.getClass().getName() + ")";
    L88:
        ParseException r38 = new ParseException("Failed to parse date [" + r36 + "]: " + r37, r20.getIndex());
        r38.initCause(e);
        throw r38;
    L86:
        if (r37.isEmpty() == false) goto L88;
    L82:
        r36 = TokenParser.DQUOTE + r19 + TokenParser.DQUOTE;
        goto L83
    }

    private static int parseInt(String r10, int r11, int r12) throws NumberFormatException {
        if (r11 < 0) goto L23;
        if (r12 > r10.length()) goto L23;
        if (r11 > r12) goto L23;
        if (r11 >= r12) goto L13;
        int r13 = r11 + 1;
        int r14 = Character.digit(r10.charAt(r11), 10);
        if (r14 < 0) goto L12;
        int r15 = -r14;
    L14:
        if (r13 >= r12) goto L21;
        int r16 = r13 + 1;
        int r17 = Character.digit(r10.charAt(r13), 10);
        if (r17 < 0) goto L19;
        r15 = (r15 * 10) - r17;
        r13 = r16;
        goto L14
    L19:
        throw new NumberFormatException("Invalid number: " + r10.substring(r11, r12));
    L21:
        return -r15;
    L12:
        throw new NumberFormatException("Invalid number: " + r10.substring(r11, r12));
    L13:
        r15 = 0;
        r13 = r11;
    L23:
        throw new NumberFormatException(r10);
    }

    public static String format(Date r10, boolean r11) {
        return format(r10, r11, TIMEZONE_UTC);
    }

    public static String format(Date r10, boolean r11, TimeZone r12) {
        GregorianCalendar r13 = new GregorianCalendar(r12, Locale.US);
        r13.setTime(r10);
        if (r11 == false) goto L5;
        int r14 = 4;
    L6:
        int r15 = 19 + r14;
        if (r12.getRawOffset() != 0) goto L9;
        int r16 = 1;
    L10:
        StringBuilder r17 = new StringBuilder(r15 + r16);
        padInt(r17, r13.get(1), 4);
        char r18 = '-';
        r17.append('-');
        padInt(r17, r13.get(2) + 1, 2);
        r17.append('-');
        padInt(r17, r13.get(5), 2);
        r17.append('T');
        padInt(r17, r13.get(11), 2);
        r17.append(':');
        padInt(r17, r13.get(12), 2);
        r17.append(':');
        padInt(r17, r13.get(13), 2);
        if (r11 == false) goto L13;
        r17.append('.');
        padInt(r17, r13.get(14), 3);
    L13:
        int r19 = r12.getOffset(r13.getTimeInMillis());
        if (r19 == 0) goto L20;
        int r20 = r19 / 60000;
        int r21 = Math.abs(r20 / 60);
        int r22 = Math.abs(r20 % 60);
        if (r19 < 0) goto L19;
        r18 = '+';
    L19:
        r17.append(r18);
        padInt(r17, r21, 2);
        r17.append(':');
        padInt(r17, r22, 2);
    L22:
        return r17.toString();
    L20:
        r17.append('Z');
        goto L22
    L9:
        r16 = 6;
        goto L10
    L5:
        r14 = 0;
        goto L6
    }
}
