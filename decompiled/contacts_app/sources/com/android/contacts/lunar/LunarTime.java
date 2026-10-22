package com.android.contacts.lunar;

import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public class LunarTime implements Cloneable {
    public int day;
    int hour;
    public boolean isLeapMonth;
    int minute;
    public int month;
    int second;
    public TimeZone timeZone;
    public int year;

    public LunarTime() {
        this.year = 1900;
        this.month = 1;
        this.day = 1;
        this.timeZone = TimeZone.getDefault();
    }

    public Object clone() {
        return (LunarTime) super.clone();
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public boolean switchToLeapMonth() {
        if (SolarToLunar.leapMonth(this.year) == this.month) goto L5;
        return false;
    L5:
        if (this.isLeapMonth == true) goto L10;
        this.isLeapMonth = true;
        return true;
    L10:
        return false;
    }

    public String toString() {
        return "LunarTime[" + this.year + "-" + this.month + "-" + this.day + "]";
    }
}
