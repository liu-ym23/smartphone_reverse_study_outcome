package com.stepos.alphame.app;

import com.stepos.alphame.NotProguard;
import com.stepos.alphame.data.DataItem;
import com.stepos.alphame.utils.Utils;

/* loaded from: classes.dex */
public class AppClickDataItem extends DataItem {
    private int mClick;
    private int mDay;
    private String mPackageName;

    @NotProguard
    public void fill(String str) {
        fill(str, Utils.currentDay(), 1);
    }

    public int getClick() {
        return this.mClick;
    }

    public int getDay() {
        return this.mDay;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public void setClick(int i4) {
        this.mClick = i4;
    }

    public void setPackageName(String str) {
        this.mPackageName = str;
    }

    public String toString() {
        return String.format("[pkgName=%s day=%d click=%d]", this.mPackageName, Integer.valueOf(this.mDay), Integer.valueOf(this.mClick));
    }

    @NotProguard
    public void fill(String str, int i4, int i5) {
        this.mPackageName = str;
        this.mDay = i4;
        this.mClick = i5;
    }
}
