package com.stepos.alphame.activityclick;

import B0.g;
import com.stepos.alphame.NotProguard;
import com.stepos.alphame.data.DataItem;
import com.stepos.alphame.utils.Utils;
import s.AbstractC0831a;

/* loaded from: classes.dex */
public class ActivityClickDataItem extends DataItem {
    private String activityName;
    private String clickCount;
    private int cloneId;
    private int currentMode;
    private Long lastClickTime;
    private String pkgName;
    private Long totalClickCount;

    @NotProguard
    public ActivityClickDataItem() {
    }

    @NotProguard
    public void fill(String str, String str2, int i4, int i5) {
        this.pkgName = str;
        this.activityName = str2;
        this.lastClickTime = Long.valueOf(System.currentTimeMillis());
        this.currentMode = i4;
        this.cloneId = i5;
    }

    public String getActivityName() {
        return this.activityName;
    }

    public String getClickCount() {
        return this.clickCount;
    }

    public int getCloneId() {
        return this.cloneId;
    }

    public int getCurrentMode() {
        return this.currentMode;
    }

    public Long getLastClickTime() {
        return this.lastClickTime;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public Long getTotalClickCount() {
        return this.totalClickCount;
    }

    public void setActivityName(String str) {
        this.activityName = str;
    }

    public void setClickCount(String str) {
        this.clickCount = str;
    }

    public void setCloneId(int i4) {
        this.cloneId = i4;
    }

    public void setCurrentMode(int i4) {
        this.currentMode = i4;
    }

    public void setLastClickTime(Long l4) {
        this.lastClickTime = l4;
    }

    public void setPkgName(String str) {
        this.pkgName = str;
    }

    public void setTotalClickCount(Long l4) {
        this.totalClickCount = l4;
    }

    public String toString() {
        String str = this.pkgName;
        String str2 = this.activityName;
        String str3 = this.clickCount;
        Long l4 = this.totalClickCount;
        String strPrintDay = Utils.printDay(this.lastClickTime.longValue());
        int i4 = this.currentMode;
        int i5 = this.cloneId;
        StringBuilder sbX = g.x("[pkgName=", str, " activityName=", str2, " clickCount=");
        sbX.append(str3);
        sbX.append(" totalClickCount=");
        sbX.append(l4);
        sbX.append(" lastClickTime=");
        sbX.append(strPrintDay);
        sbX.append(" currentMode=");
        sbX.append(i4);
        sbX.append(" cloneId=");
        return AbstractC0831a.d(sbX, i5, "]");
    }

    @NotProguard
    public ActivityClickDataItem(String str, String str2, int i4, String str3) {
        this.pkgName = str;
        this.activityName = str2;
        this.lastClickTime = Long.valueOf(System.currentTimeMillis());
        this.currentMode = i4;
        this.cloneId = Integer.parseInt(str3);
    }

    @NotProguard
    public void fill(String str, String str2, String str3, Long l4, Long l5, int i4, int i5) {
        this.pkgName = str;
        this.activityName = str2;
        this.clickCount = str3;
        this.totalClickCount = l4;
        this.lastClickTime = l5;
        this.currentMode = i4;
        this.cloneId = i5;
    }

    @NotProguard
    public ActivityClickDataItem(String str, String str2, String str3, Long l4, Long l5, int i4, int i5) {
        this.pkgName = str;
        this.activityName = str2;
        this.clickCount = str3;
        this.totalClickCount = l4;
        this.lastClickTime = l5;
        this.currentMode = i4;
        this.cloneId = i5;
    }
}
