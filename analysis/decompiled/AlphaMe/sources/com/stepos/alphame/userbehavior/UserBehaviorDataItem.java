package com.stepos.alphame.userbehavior;

import com.stepos.alphame.NotProguard;
import com.stepos.alphame.data.DataItem;
import com.stepos.alphame.utils.StringUtil;

/* loaded from: classes.dex */
public class UserBehaviorDataItem extends DataItem {
    String appDetails;
    long date;
    String hoursDetails;
    int id;
    int notifications;
    int screenOnCount;
    long topUsedTime;
    long totalUsedTime;

    @NotProguard
    public void fill(int i4, long j4, long j5, long j6, int i5, int i6, String str, String str2) {
        this.id = i4;
        this.screenOnCount = i5;
        this.notifications = i6;
        this.date = j4;
        this.totalUsedTime = j5;
        this.topUsedTime = j6;
        this.appDetails = str;
        this.hoursDetails = str2;
    }

    public String toSimpleString() {
        return "date：" + StringUtil.formatDateFull(this.date) + ", totalUsed：" + StringUtil.formatTimeMill(this.totalUsedTime) + ", topUsed：" + StringUtil.formatTimeMill(this.topUsedTime) + ", screenOnCount：" + this.screenOnCount;
    }

    public String toString() {
        return "date：" + StringUtil.formatDateFull(this.date) + ", totalUsed：" + StringUtil.formatTimeMill(this.totalUsedTime) + ", topUsed：" + StringUtil.formatTimeMill(this.topUsedTime) + ", screenOnCount：" + this.screenOnCount + ", appDetails: " + this.appDetails + ", hourDetails: " + this.hoursDetails;
    }
}
