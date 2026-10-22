package com.android.contacts.lunar;

import android.support.v4.media.session.PlaybackStateCompat;
import com.bytedance.common.utility.date.DateDef;
import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class SolarToLunar {
    private static final long[] lunarInfo = null;
    private static final Calendar sBaseTime = null;
    private static final Calendar sTempCalendar = null;

    public SolarToLunar() {
    }

    static {
        lunarInfo = new long[]{19416, 19168, 42352, 21717, 53856, 55632, 91476, 22176, 39632, 21970, 19168, 42422, 42192, 53840, 119381, 46400, 54944, 44450, 38320, 84343, 18800, 42160, 46261, 27216, 27968, 109396, 11104, 38256, 21234, 18800, 25958, 54432, 59984, 28309, 23248, 11104, 100067, 37600, 116951, 51536, 54432, 120998, 46416, 22176, 107956, 9680, 37584, 53938, 43344, 46423, 27808, 46416, 86869, 19872, 42448, 83315, 21200, 43432, 59728, 27296, 44710, 43856, 19296, 43748, 42352, 21088, 62051, 55632, 23383, 22176, 38608, 19925, 19152, 42192, 54484, 53840, 54616, 46400, 46496, 103846, 38320, 18864, 43380, 42160, 45690, 27216, 27968, 44870, 43872, 38256, 19189, 18800, 25776, 29859, 59984, 27480, 23232, 43872, 38613, 37600, 51552, 55636, 54432, 55888, 30034, 22176, 43959, 9680, 37584, 51893, 43344, 46240, 47780, 44368, 21977, 19360, 42416, 86390, 21168, 43312, 31060, 27296, 44368, 23378, 19296, 42726, 42208, 53856, 60005, 54576, 23200, 30371, 38608, 19195, 19152, 42192, 118966, 53840, 54560, 56645, 46496, 22224, 21938, 18864, 42359, 42160, 43600, 111189, 27936, 44448, 84835, 37744, 18936, 18800, 25776, 92326, 59984, 27424, 108228, 43744, 41696, 53987, 51552, 54615, 54432, 55888, 23893, 22176, 42704, 21972, 21200, 43448, 43344, 46240, 46758, 44368, 21920, 43940, 42416, 21168, 45683, 26928, 29495, 27296, 44368, 84821, 19296, 42352, 21732, 53600, 59752, 54560, 55968, 92838, 22224, 19168, 43476, 41680, 53584, 62034, 54560};
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(0);
        r0.set(1900, 0, 31, 0, 0, 0);
        sBaseTime = r0;
        Calendar r1 = Calendar.getInstance();
        sTempCalendar = r1;
        r1.setTimeInMillis(0);
    }

    public static long getBaseTimeMillis(TimeZone r8) {
        Calendar r7 = sBaseTime;
        switchToTimeZone(r7, r8);
        r7.set(1900, 0, 31, 0, 0, 0);
        return getCalendarMillis(r7);
    }

    private static boolean switchToTimeZone(Calendar r1, TimeZone r2) {
        if (r2 != null) goto L5;
        r2 = TimeZone.getDefault();
    L5:
        if (r1.getTimeZone().equals(r2) == true) goto L8;
        r1.setTimeZone(r2);
        return true;
    L8:
        return false;
    }

    private static Calendar getTempTime(TimeZone r1) {
        Calendar r0 = sTempCalendar;
        switchToTimeZone(r0, r1);
        return r0;
    }

    private static final int yearDays(int r6) {
        int r0 = 348;
        int r1 = 32768;
    L4:
        if (r1 <= 8) goto L10;
        if ((lunarInfo[r6 - 1900] & ((long) r1)) == 0) goto L8;
        r0 = r0 + 1;
    L8:
        r1 = r1 >> 1;
        goto L4
    L10:
        return r0 + leapDays(r6);
    }

    public static final int leapDays(int r4) {
        if (leapMonth(r4) != 0) goto L5;
        return 0;
    L5:
        if ((lunarInfo[r4 - 1900] & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) == 0) goto L8;
        return 30;
    L8:
        return 29;
    }

    public static final int leapMonth(int r4) {
        if (r4 >= 1900) goto L5;
        return 0;
    L5:
        return (int) (lunarInfo[r4 - 1900] & 15);
    }

    public static boolean isLeapYear(int r0) {
        if (leapMonth(r0) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final int monthDays(int r2, int r3) {
        if ((((long) (65536 >> r3)) & lunarInfo[r2 - 1900]) != 0) goto L6;
        return 29;
    L6:
        return 30;
    }

    public static final int yearMonths(int r0) {
        if (isLeapYear(r0) == false) goto L6;
        return 13;
    L6:
        return 12;
    }

    public static LunarTime getLunar(Calendar r8) {
        return getLunar(r8.get(1), r8.get(2) + 1, r8.get(5), r8.get(10), r8.get(12), r8.get(13), r8.getTimeZone());
    }

    public static LunarTime getLunar(long r8) {
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r8);
        return getLunar(r0.get(1), r0.get(2) + 1, r0.get(5), r0.get(10), r0.get(12), r0.get(13), TimeZone.getTimeZone("UTC"));
    }

    public static LunarTime getLunar(int r7, int r8, int r9, TimeZone r10) {
        return getLunar(r7, r8, r9, 0, 0, 0, r10);
    }

    public static LunarTime getLunar(int r10, int r11, int r12, int r13, int r14, int r15, TimeZone r16) {
        Calendar r8 = getTempTime(null);
        r8.set(r10, r11 - 1, r12, 0, 0, 0);
        int r0 = (int) ((getCalendarMillis(r8) - getBaseTimeMillis(null)) / 86400000);
        boolean r1 = false;
        int r2 = 1900;
        int r3 = 0;
    L4:
        if (r2 >= 2050) goto L7;
        if (r0 <= 0) goto L7;
        r3 = yearDays(r2);
        r0 = r0 - r3;
        r2 = r2 + 1;
    L7:
        if (r0 >= 0) goto L9;
        r0 = r0 + r3;
        r2 = r2 - 1;
    L9:
        int r4 = leapMonth(r2);
        boolean r5 = false;
        int r6 = 0;
        int r7 = 1;
    L11:
        if (r7 >= 13) goto L25;
        if (r0 <= 0) goto L25;
        if (r4 > 0) goto L15;
    L18:
        r6 = monthDays(r2, r7);
    L19:
        r0 = r0 - r6;
        if (r5 == false) goto L24;
        if (r7 != (r4 + 1)) goto L24;
        r5 = false;
    L24:
        r7 = r7 + 1;
        goto L11
    L15:
        if (r7 != (r4 + 1)) goto L18;
        if (r5 == true) goto L18;
        r7 = r7 - 1;
        r6 = leapDays(r2);
        r5 = true;
    L25:
        if (r0 != 0) goto L32;
        if (r4 <= 0) goto L32;
        if (r7 != (r4 + 1)) goto L32;
        if (r5 == true) goto L33;
        r7 = r7 - 1;
        r1 = true;
    L33:
        if (r0 >= 0) goto L35;
        r0 = r0 + r6;
        r7 = r7 - 1;
    L35:
        LunarTime r9 = new LunarTime();
        r9.year = r2;
        r9.month = r7;
        r9.day = r0 + 1;
        r9.hour = r13;
        r9.minute = r14;
        r9.second = r15;
        r9.isLeapMonth = r1;
        r9.timeZone = r16;
        return r9;
    L32:
        r1 = r5;
        goto L33
    }

    public static long getCalendarMillis(Calendar r2, boolean r3) {
        if (r3 == false) goto L6;
        return r2.getTimeInMillis() + ((long) r2.get(16));
    L6:
        return r2.getTimeInMillis();
    }

    public static long getCalendarMillis(Calendar r2) {
        return getCalendarMillis(r2, true);
    }

    public static Calendar getSolarCalendar(LunarTime r8) {
        Calendar r0 = Calendar.getInstance(TimeZone.getTimeZone(r8.timeZone.getID()));
        int r1 = 0;
        int r2 = 1900;
    L4:
        if (r2 >= r8.year) goto L6;
        r1 = r1 + yearDays(r2);
        r2 = r2 + 1;
        goto L4
    L6:
        int r3 = leapMonth(r8.year);
        int r4 = 1;
    L8:
        if (r4 >= r8.month) goto L14;
        if (r3 <= 0) goto L12;
        if (r3 != r4) goto L12;
        r1 = r1 + leapDays(r8.year);
    L12:
        r1 = r1 + monthDays(r8.year, r4);
        r4 = r4 + 1;
        goto L8
    L14:
        if (r8.isLeapMonth == false) goto L20;
        if (r3 != r8.month) goto L18;
        r1 = r1 + monthDays(r8.year, r8.month);
        goto L20
    L18:
        return null;
    L20:
        if (r8.isLeapMonth == false) goto L22;
        int r5 = leapDays(r8.year);
    L24:
        if (r8.day > 0) goto L26;
    L29:
        return null;
    L26:
        if (r8.day > r5) goto L29;
        r0.setTimeInMillis((((getBaseTimeMillis(r8.timeZone) + (((long) (r1 + (r8.day - 1))) * 86400000)) + (((long) r8.hour) * DateDef.HOUR)) + (((long) (r8.minute + 8)) * 60000)) + (((long) r8.second) * 1000));
        return r0;
    L22:
        r5 = monthDays(r8.year, r8.month);
        goto L24
    }
}
