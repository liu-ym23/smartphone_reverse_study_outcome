package com.obric.capabilitykit.common;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class AppActionInfo {
    private final String action;
    private final String appName;
    private final String packageName;

    public AppActionInfo(String r2, String r3, String r4) {
        d.h.b.o.e(r2, "packageName");
        d.h.b.o.e(r3, "appName");
        d.h.b.o.e(r4, "action");
        this.packageName = r2;
        this.appName = r3;
        this.action = r4;
    }

    public static /* synthetic */ AppActionInfo copy$default(AppActionInfo r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.packageName;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.appName;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.action;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.packageName;
    }

    public final String component2() {
        return this.appName;
    }

    public final String component3() {
        return this.action;
    }

    public final AppActionInfo copy(String r1, String r2, String r3) {
        d.h.b.o.e(r1, "packageName");
        d.h.b.o.e(r2, "appName");
        d.h.b.o.e(r3, "action");
        return new AppActionInfo(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, AppActionInfo.class) == true) goto L8;
        return false;
    L8:
        AppActionInfo r6 = (AppActionInfo) ZeusTransformUtils.preCheckCast(r5, AppActionInfo.class, "com.obric.aiagent.plugin");
        if (d.h.b.o.a(this.packageName, r6.packageName) == true) goto L12;
        return false;
    L12:
        if (d.h.b.o.a(this.appName, r6.appName) == true) goto L15;
        return false;
    L15:
        if (d.h.b.o.a(this.action, r6.action) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return (((this.packageName.hashCode() * 31) + this.appName.hashCode()) * 31) + this.action.hashCode();
    }

    public String toString() {
        return "AppActionInfo(packageName=" + this.packageName + ", appName=" + this.appName + ", action=" + this.action + ')';
    }
}
