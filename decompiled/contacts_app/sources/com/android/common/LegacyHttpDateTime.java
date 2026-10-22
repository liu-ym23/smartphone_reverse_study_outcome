package com.android.common;

import android.text.format.Time;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import obric.util.CalendarUtils;

/* JADX INFO: loaded from: classes.dex */
final class LegacyHttpDateTime {
    private static final Pattern HTTP_DATE_ANSIC_PATTERN = null;
    private static final String HTTP_DATE_ANSIC_REGEXP = "[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})";
    private static final Pattern HTTP_DATE_RFC_PATTERN = null;
    private static final String HTTP_DATE_RFC_REGEXP = "([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])";

    private static class TimeOfDay {
        int hour;
        int minute;
        int second;

        TimeOfDay(int r1, int r2, int r3) {
            this.hour = r1;
            this.minute = r2;
            this.second = r3;
        }
    }

    LegacyHttpDateTime() {
    }

    static {
        HTTP_DATE_RFC_PATTERN = Pattern.compile(HTTP_DATE_RFC_REGEXP);
        HTTP_DATE_ANSIC_PATTERN = Pattern.compile(HTTP_DATE_ANSIC_REGEXP);
    }

    public static long parse(String r14) throws IllegalArgumentException {
        Matcher r0 = HTTP_DATE_RFC_PATTERN.matcher(r14);
        if (r0.find() == false) goto L5;
        int r15 = getDate(r0.group(1));
        int r1 = getMonth(r0.group(2));
        int r3 = getYear(r0.group(3));
        TimeOfDay r2 = getTime(r0.group(4));
    L9:
        if (r3 < 2038) goto L11;
        int r11 = 0;
        int r12 = 2038;
        int r10 = 1;
    L12:
        Time r16 = new Time("UTC");
        r16.set(r2.second, r2.minute, r2.hour, r10, r11, r12);
        return r16.toMillis(false);
    L11:
        r10 = r15;
        r11 = r1;
        r12 = r3;
        goto L12
    L5:
        Matcher r17 = HTTP_DATE_ANSIC_PATTERN.matcher(r14);
        if (r17.find() == false) goto L15;
        r1 = getMonth(r17.group(1));
        int r4 = getDate(r17.group(2));
        TimeOfDay r5 = getTime(r17.group(3));
        r3 = getYear(r17.group(4));
        r15 = r4;
        r2 = r5;
        goto L9
    L15:
        throw new IllegalArgumentException();
    }

    private static int getDate(String r3) {
        if (r3.length() != 2) goto L7;
        return ((r3.charAt(0) - '0') * 10) + (r3.charAt(1) - '0');
    L7:
        return r3.charAt(0) - '0';
    }

    private static int getMonth(String r5) {
        int r1 = ((Character.toLowerCase(r5.charAt(0)) + Character.toLowerCase(r5.charAt(1))) + Character.toLowerCase(r5.charAt(2))) - 291;
        if (r1 != 9) goto L5;
        return 11;
    L5:
        if (r1 != 10) goto L7;
        return 1;
    L7:
        if (r1 != 22) goto L9;
        return 0;
    L9:
        if (r1 != 26) goto L11;
        return 7;
    L11:
        if (r1 != 29) goto L13;
        return 2;
    L13:
        if (r1 != 32) goto L15;
        return 3;
    L15:
        if (r1 != 40) goto L17;
        return 6;
    L17:
        if (r1 != 42) goto L19;
        return 5;
    L19:
        if (r1 == 48) goto L27;
        switch(r1) {
            case 35: goto L41;
            case 36: goto L25;
            case 37: goto L23;
            default: goto L22;
        };
    L23:
        return 8;
    L25:
        return 4;
    L41:
        return 9;
    L22:
        throw new IllegalArgumentException();
    L27:
        return 10;
    }

    private static int getYear(String r6) {
        if (r6.length() != 2) goto L11;
        int r0 = ((r6.charAt(0) - '0') * 10) + (r6.charAt(1) - '0');
        if (r0 < 70) goto L9;
        return r0 + 1900;
    L9:
        return r0 + 2000;
    L11:
        if (r6.length() != 3) goto L15;
        return ((((r6.charAt(0) - '0') * 100) + ((r6.charAt(1) - '0') * 10)) + (r6.charAt(2) - '0')) + 1900;
    L15:
        if (r6.length() == 4) goto L17;
        return CalendarUtils.MIN_CALENDAR_YEAR;
    L17:
        return ((((r6.charAt(0) - '0') * 1000) + ((r6.charAt(1) - '0') * 100)) + ((r6.charAt(2) - '0') * 10)) + (r6.charAt(3) - '0');
    }

    private static TimeOfDay getTime(String r5) {
        int r0 = r5.charAt(0) - '0';
        if (r5.charAt(1) == ':') goto L5;
        r0 = (r0 * 10) + (r5.charAt(1) - '0');
        int r2 = 2;
    L6:
        int r3 = r2 + 1;
        int r4 = r3 + 1;
        int r6 = (r4 + 1) + 1;
        return new TimeOfDay(r0, ((r5.charAt(r3) - '0') * 10) + (r5.charAt(r4) - '0'), ((r5.charAt(r6) - '0') * 10) + (r5.charAt(r6 + 1) - '0'));
    L5:
        r2 = 1;
        goto L6
    }
}
