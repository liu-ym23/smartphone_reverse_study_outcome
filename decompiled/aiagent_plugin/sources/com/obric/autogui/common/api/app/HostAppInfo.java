package com.obric.autogui.common.api.app;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: HostAppInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class HostAppInfo {
    private final boolean isDebugBuild;
    private final String packageName;
    private final int versionCode;
    private final String versionName;

    public static /* synthetic */ HostAppInfo copy$default(HostAppInfo r0, String r1, String r2, int r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.packageName;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.versionName;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.versionCode;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.isDebugBuild;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.packageName;
    }

    public final String component2() {
        return this.versionName;
    }

    public final int component3() {
        return this.versionCode;
    }

    public final boolean component4() {
        return this.isDebugBuild;
    }

    public final HostAppInfo copy(String r1, String r2, int r3, boolean r4) {
        o.e(r1, "packageName");
        o.e(r2, "versionName");
        return new HostAppInfo(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, HostAppInfo.class) == true) goto L8;
        return false;
    L8:
        HostAppInfo r6 = (HostAppInfo) ZeusTransformUtils.preCheckCast(r5, HostAppInfo.class, "com.obric.aiagent.plugin");
        if (o.a(this.packageName, r6.packageName) == true) goto L12;
        return false;
    L12:
        if (o.a(this.versionName, r6.versionName) == true) goto L15;
        return false;
    L15:
        if (this.versionCode == r6.versionCode) goto L18;
        return false;
    L18:
        if (this.isDebugBuild == r6.isDebugBuild) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.packageName.hashCode() * 31) + this.versionName.hashCode()) * 31) + Integer.hashCode(this.versionCode)) * 31) + Boolean.hashCode(this.isDebugBuild);
    }

    public String toString() {
        return "HostAppInfo(packageName=" + this.packageName + ", versionName=" + this.versionName + ", versionCode=" + this.versionCode + ", isDebugBuild=" + this.isDebugBuild + ')';
    }

    public HostAppInfo(String r2, String r3, int r4, boolean r5) {
        o.e(r2, "packageName");
        o.e(r3, "versionName");
        this.packageName = r2;
        this.versionName = r3;
        this.versionCode = r4;
        this.isDebugBuild = r5;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final int getVersionCode() {
        return this.versionCode;
    }

    public final boolean isDebugBuild() {
        return this.isDebugBuild;
    }
}
