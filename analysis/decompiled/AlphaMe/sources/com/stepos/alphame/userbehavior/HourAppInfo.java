package com.stepos.alphame.userbehavior;

import B0.g;

/* loaded from: classes.dex */
public class HourAppInfo {
    int notifications;
    String pkgName;
    long totalUsedTime;

    public HourAppInfo(String str, int i4, long j4) {
        this.pkgName = str;
        this.notifications = i4;
        this.totalUsedTime = j4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.pkgName);
        sb.append("=(");
        sb.append(this.notifications);
        sb.append(",");
        return g.p(sb, this.totalUsedTime, ")");
    }
}
