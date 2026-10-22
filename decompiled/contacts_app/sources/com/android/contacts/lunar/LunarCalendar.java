package com.android.contacts.lunar;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.GlobalProxyLancet;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class LunarCalendar {
    public static final SimpleDateFormat FULL_DATE_FORMAT = null;
    public static final SimpleDateFormat NO_YEAR_DATE_FORMAT = null;
    public static final int TYPE_BIRTHDAY_LUNAR = 4;
    public final String[] EARTH_BRANCHES;
    public final String[] HEAVENLY_STEMS;
    public final String LEAP_PREFIX;
    public final String[] LUNAR_DAY;
    public final String[] LUNAR_MONTH;
    protected LunarTime mLunarTime;
    private boolean mNoYear;

    public void clear() {
    }

    public int getActualMinimum(int r1) {
        return 1;
    }

    public LunarCalendar() {
        this(Locale.getDefault());
    }

    public LunarCalendar(Locale r32) {
        this.LUNAR_DAY = new String[]{"初一", "初二", "初三", "初四", "初五", "初六", "初七", "初八", "初九", "初十", "十一", "十二", "十三", "十四", "十五", "十六", "十七", "十八", "十九", "二十", "廿一", "廿二", "廿三", "廿四", "廿五", "廿六", "廿七", "廿八", "廿九", "三十"};
        this.LUNAR_MONTH = new String[]{"正月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "冬月", "腊月"};
        this.HEAVENLY_STEMS = new String[]{"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};
        this.EARTH_BRANCHES = new String[]{"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};
        this.LEAP_PREFIX = "闰";
        this.mNoYear = false;
        LunarTime r1 = new LunarTime();
        this.mLunarTime = r1;
        r1.timeZone = Calendar.getInstance(r32).getTimeZone();
    }

    public String[] getMonthDisplayValues(int r8) {
        int r0 = r8 - 1;
        if (r0 < 0) goto L14;
        if (r0 >= 12) goto L14;
        String[] r1 = new String[13];
        int r2 = 0;
        int r3 = 0;
    L7:
        if (r2 >= 13) goto L12;
        if (r8 != r2) goto L10;
        r1[r2] = "闰" + this.LUNAR_MONTH[r3 - 1];
    L11:
        r2 = r2 + 1;
        goto L7
    L10:
        r1[r2] = this.LUNAR_MONTH[r3];
        r3 = r3 + 1;
        goto L11
    L12:
        return r1;
    L14:
        return this.LUNAR_MONTH;
    }

    public boolean isNoYear() {
        return this.mNoYear;
    }

    public void setNoYear() {
        this.mLunarTime.year = 4;
        this.mNoYear = true;
    }

    public void setLunarTime(LunarTime r2) {
        LunarTime r3 = (LunarTime) r2.clone();
        this.mLunarTime = r3;
        if (r3.year != 4) goto L6;
        this.mNoYear = true;
        return;
    }

    public void setTimeInMillis(long r1) {
        this.mLunarTime = SolarToLunar.getLunar(r1);
    }

    public int getActualMaximum(int r2) {
        if (r2 == 2) goto L19;
        if (r2 == 5) goto L9;
        return 0;
    L9:
        if (isNoYear() == false) goto L13;
        return 30;
    L13:
        if (this.mLunarTime.isLeapMonth == false) goto L17;
        return SolarToLunar.leapDays(this.mLunarTime.year);
    L17:
        return SolarToLunar.monthDays(this.mLunarTime.year, this.mLunarTime.month);
    L19:
        return SolarToLunar.yearMonths(this.mLunarTime.year);
    }

    public long getTimeInMillis() {
        Calendar r2 = SolarToLunar.getSolarCalendar(this.mLunarTime);
        if (r2 != null) goto L7;
        return -1;
    L7:
        return r2.getTimeInMillis();
    }

    public Calendar getSolarCalendar() {
        return SolarToLunar.getSolarCalendar(this.mLunarTime);
    }

    public void set(int r2, int r3) {
        if (r2 != 1) goto L5;
        setYear(r3);
        return;
    L5:
        if (r2 != 2) goto L7;
        setMonthIndex(r3);
        return;
    L7:
        if (r2 != 5) goto L15;
        this.mLunarTime.day = r3;
        return;
    }

    private void setYear(int r2) {
        if (r2 == 4) goto L7;
        if (r2 == 0) goto L7;
        this.mNoYear = false;
    L8:
        this.mLunarTime.year = r2;
        return;
    L7:
        this.mNoYear = true;
        goto L8
    }

    private int getYearIndex() {
        if (this.mNoYear == false) goto L7;
        return 4;
    L7:
        return this.mLunarTime.year;
    }

    public int get(int r2) {
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L13;
        if (r2 == 5) goto L11;
        return -1;
    L11:
        return this.mLunarTime.day;
    L13:
        return getMonthIndex();
    L15:
        return getYearIndex();
    }

    public LunarTime getLunarTime() {
        return this.mLunarTime;
    }

    public boolean after(LunarCalendar r3) {
        if (getTimeInMillis() <= r3.getTimeInMillis()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean before(LunarCalendar r3) {
        if (getTimeInMillis() >= r3.getTimeInMillis()) goto L5;
        return true;
    L5:
        return false;
    }

    public void set(int r1, int r2, int r3) {
        setYear(r1);
        setMonthIndex(r2);
        this.mLunarTime.day = r3;
    }

    private void setMonthIndex(int r4) {
        int r0 = SolarToLunar.leapMonth(this.mLunarTime.year);
        this.mLunarTime.isLeapMonth = false;
        if (r0 <= 0) goto L9;
        if (r4 <= r0) goto L8;
        this.mLunarTime.month = r4 - 1;
        if (r4 != (r0 + 1)) goto L11;
        this.mLunarTime.switchToLeapMonth();
        return;
    L11:
        return;
    L8:
        this.mLunarTime.month = r4;
        return;
    L9:
        this.mLunarTime.month = r4;
    }

    private int getMonthIndex() {
        int r0 = SolarToLunar.leapMonth(this.mLunarTime.year);
        if (this.mNoYear == true) goto L14;
        if (r0 == 0) goto L14;
        if (r0 != this.mLunarTime.month) goto L10;
        return this.mLunarTime.month + (this.mLunarTime.isLeapMonth ? 1 : 0);
    L10:
        if (r0 >= this.mLunarTime.month) goto L17;
        return this.mLunarTime.month + 1;
    L17:
        return this.mLunarTime.month;
    L14:
        return this.mLunarTime.month;
    }

    public String[] getDisplayedValues(int r2) {
        if (r2 == 2) goto L11;
        if (r2 == 5) goto L9;
        return null;
    L9:
        return this.LUNAR_DAY;
    L11:
        return getMonthDisplayValues(SolarToLunar.leapMonth(this.mLunarTime.year));
    }

    public String getString() {
    L8:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d("LunarCalendar", "getString", e);
        return "";
    L3:
        if (this.mNoYear == false) goto L7;
        return getDisplayedValues(2)[getMonthIndex() - 1] + this.LUNAR_DAY[this.mLunarTime.day - 1];
    L7:
        return getChineseEraYear(this.mLunarTime.year) + "年" + getDisplayedValues(2)[getMonthIndex() - 1] + this.LUNAR_DAY[this.mLunarTime.day - 1];
    }

    public String getSavingString() {
        if (this.mNoYear == false) goto L11;
        StringBuilder r0 = new StringBuilder();
        if (this.mLunarTime.month >= 10) goto L7;
        r0.append('0');
    L7:
        r0.append(this.mLunarTime.month).append('-');
        if (this.mLunarTime.day >= 10) goto L10;
        r0.append('0');
    L10:
        r0.append(this.mLunarTime.day);
        return r0.toString();
    L11:
        Calendar r5 = getSolarCalendar();
        if (r5 != null) goto L17;
        return null;
    L17:
        return FULL_DATE_FORMAT.format(r5.getTime());
    }

    public String getChineseEraYear(int r4) {
        int r5 = (r4 - 4) % 60;
        StringBuilder r0 = new StringBuilder();
        String[] r1 = this.HEAVENLY_STEMS;
        StringBuilder r2 = r0.append(r1[r5 % r1.length]);
        String[] r3 = this.EARTH_BRANCHES;
        return r2.append(r3[r5 % r3.length]).toString();
    }

    static {
        NO_YEAR_DATE_FORMAT = new SimpleDateFormat("MM-dd", Locale.US);
        FULL_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
    }

    public static String getLunarDisplayStringFromLunarDateString(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
        return "";
    L5:
        LunarCalendar r3 = parseLunarDate(r2);
        if (r3 != null) goto L9;
        return "";
    L9:
        return r3.getString();
    }

    public static LunarCalendar parseLunarDate(String r6) {
        LunarCalendar r0 = new LunarCalendar();
        if (r6.contains(ExifInterface.GPS_DIRECTION_TRUE) == false) goto L5;
        r6 = r6.substring(0, r6.indexOf(ExifInterface.GPS_DIRECTION_TRUE));
    L5:
        String[] r7 = r6.split("-");
    L13:
        e = move-exception;
        e.printStackTrace();
        return null;
    L7:
        if (3 != r7.length) goto L10;
        int r1 = Integer.valueOf(r7[0]).intValue();     // Catch: Exception -> L13
        int r3 = Integer.valueOf(r7[1]).intValue();     // Catch: Exception -> L13
        int r8 = Integer.valueOf(r7[2]).intValue();     // Catch: Exception -> L13
        Calendar r2 = Calendar.getInstance(Locale.getDefault());     // Catch: Exception -> L13
        r2.set(r1, r3 - 1, r8);     // Catch: Exception -> L13
        r0.setTimeInMillis(r2.getTimeInMillis());     // Catch: Exception -> L13
    L12:
        return r0;
    L10:
        if (2 != r7.length) goto L12;
        r0.set(4, Integer.valueOf(r7[0]).intValue(), Integer.valueOf(r7[1]).intValue());     // Catch: Exception -> L13
        r0.setNoYear();     // Catch: Exception -> L13
        goto L12
    }

    private static Date parseDateForLunar(String r2, SimpleDateFormat r3) {
        ParsePosition r0 = new ParsePosition(0);
        monitor-enter(r3);
        r0.setIndex(0);     // Catch: Throwable -> L11
        Date r1 = r3.parse(r2, r0);     // Catch: Throwable -> L11
        if (r0.getIndex() != r2.length()) goto L8;
        monitor-exit(r3);     // Catch: Throwable -> L11
        return r1;
    L8:
        monitor-exit(r3);     // Catch: Throwable -> L11
        return null;
    L11:
        th = move-exception;
        throw th;
    }

    public static String getLunarData(String r4) {
        boolean r1 = false;
        ParsePosition r0 = new ParsePosition(0);
        Date r2 = FULL_DATE_FORMAT.parse(r4, r0);
        if (r2 != null) goto L5;
        r0.setIndex(0);
        r2 = NO_YEAR_DATE_FORMAT.parse(r4, r0);
        r1 = true;
    L5:
        if (r2 == null) goto L13;
        Calendar r5 = Calendar.getInstance(Locale.getDefault());
        int r3 = r5.get(1);
        r5.setTime(r2);
        if (r1 == false) goto L12;
        Calendar r6 = Calendar.getInstance(Locale.getDefault());
        r5.set(1, r3);
    L10:
        if (r5.after(r6) == false) goto L12;
        r3 = r3 - 1;
        r5.set(1, r3);
    L12:
        LunarTime r7 = SolarToLunar.getLunar(r5);
        LunarCalendar r8 = new LunarCalendar();
        r8.setLunarTime(r7);
        return r8.getSavingString();
    L13:
        return null;
    }
}
