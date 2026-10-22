package com.byted.cast.linkcommon.cybergarage.http;

import java.util.Calendar;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes28.dex */
public class Date {
    private static final String[] MONTH_STRING = null;
    private static final String[] WEEK_STRING = null;
    private Calendar cal;

    static {
        MONTH_STRING = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        WEEK_STRING = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    }

    public static final Date getInstance() {
        return new Date(Calendar.getInstance(TimeZone.getTimeZone("GMT")));
    }

    public static final Date getLocalInstance() {
        return new Date(Calendar.getInstance());
    }

    public String getDateString() {
        Calendar r100 = getCalendar();
        return toWeekString(r100.get(7)) + ", " + toTimeString(r100.get(5)) + " " + toMonthString(r100.get(2)) + " " + Integer.toString(r100.get(1)) + " " + toTimeString(r100.get(11)) + ":" + toTimeString(r100.get(12)) + ":" + toTimeString(r100.get(13)) + " GMT";
    }

    public int getHour() {
        return getCalendar().get(11);
    }

    public int getMinute() {
        return getCalendar().get(12);
    }

    public int getSecond() {
        return getCalendar().get(13);
    }

    public String getTimeString() {
        Calendar r100 = getCalendar();
        StringBuilder r101 = new StringBuilder();
        r101.append(toDateString(r100.get(11)));
        if ((r100.get(13) % 2) != 0) goto L5;
        String r102 = ":";
    L6:
        r101.append(r102);
        r101.append(toDateString(r100.get(12)));
        return r101.toString();
    L5:
        r102 = " ";
        goto L6
    }

    public Calendar getCalendar() {
        return this.cal;
    }

    public Date(Calendar r100) {
        this.cal = r100;
    }

    public static final String toDateString(int r100) {
        if (r100 >= 10) goto L7;
        return "0" + Integer.toString(r100);
    L7:
        return Integer.toString(r100);
    }

    public static final String toMonthString(int r100) {
        int r101 = r100 + 0;
        if (r101 >= 0) goto L5;
        return "";
    L5:
        if (r101 < 12) goto L7;
        return "";
    L7:
        return MONTH_STRING[r101];
    }

    public static final String toTimeString(int r100) {
        if (r100 >= 10) goto L5;
        String r101 = "0";
    L7:
        return r101 + Integer.toString(r100);
    L5:
        r101 = "";
        goto L7
    }

    public static final String toWeekString(int r100) {
        int r101 = r100 - 1;
        if (r101 >= 0) goto L5;
        return "";
    L5:
        if (r101 < 7) goto L7;
        return "";
    L7:
        return WEEK_STRING[r101];
    }
}
