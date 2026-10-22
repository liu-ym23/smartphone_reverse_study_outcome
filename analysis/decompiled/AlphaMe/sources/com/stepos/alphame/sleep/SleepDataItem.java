package com.stepos.alphame.sleep;

import B0.g;
import com.stepos.alphame.NotProguard;
import com.stepos.alphame.data.DataItem;

/* loaded from: classes.dex */
public class SleepDataItem extends DataItem {
    public int day;
    public String locationX;
    public String locationY;
    public int sleepTime;
    public int wakeUpTime;
    public int week;

    @NotProguard
    public void fill(int i4, int i5, int i6, int i7, String str, String str2) {
        this.week = i4;
        this.day = i5;
        this.sleepTime = i6;
        this.wakeUpTime = i7;
        this.locationX = str;
        this.locationY = str2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SleepDataItem{week=");
        sb.append(this.week);
        sb.append(", day=");
        sb.append(this.day);
        sb.append(", sleepTime=");
        sb.append(this.sleepTime);
        sb.append(", wakeUpTime=");
        sb.append(this.wakeUpTime);
        sb.append(", locationX='");
        sb.append(this.locationX);
        sb.append("', locationY='");
        return g.r(sb, this.locationY, "'}");
    }
}
