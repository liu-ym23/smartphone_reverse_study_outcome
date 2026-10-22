package com.obric.autogui.common.api.platform.system;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: LocationInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class POILocationInfo {
    private final String company;
    private final String home;
    private final boolean isSucceeded;
    private final long refreshedAt;

    public static /* synthetic */ POILocationInfo copy$default(POILocationInfo r3, boolean r4, String r5, String r6, long r7, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.isSucceeded;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.home;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.company;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.refreshedAt;
    L14:
        boolean r8 = r4;
        return r3.copy(r8, r11, r0, r7);
    }

    public final boolean component1() {
        return this.isSucceeded;
    }

    public final String component2() {
        return this.home;
    }

    public final String component3() {
        return this.company;
    }

    public final long component4() {
        return this.refreshedAt;
    }

    public final POILocationInfo copy(boolean r7, String r8, String r9, long r10) {
        o.e(r8, "home");
        o.e(r9, "company");
        return new POILocationInfo(r7, r8, r9, r10);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, POILocationInfo.class) == true) goto L8;
        return false;
    L8:
        POILocationInfo r8 = (POILocationInfo) ZeusTransformUtils.preCheckCast(r7, POILocationInfo.class, "com.obric.aiagent.plugin");
        if (this.isSucceeded == r8.isSucceeded) goto L12;
        return false;
    L12:
        if (o.a(this.home, r8.home) == true) goto L15;
        return false;
    L15:
        if (o.a(this.company, r8.company) == true) goto L18;
        return false;
    L18:
        if (this.refreshedAt == r8.refreshedAt) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.isSucceeded) * 31) + this.home.hashCode()) * 31) + this.company.hashCode()) * 31) + Long.hashCode(this.refreshedAt);
    }

    public String toString() {
        return "POILocationInfo(isSucceeded=" + this.isSucceeded + ", home=" + this.home + ", company=" + this.company + ", refreshedAt=" + this.refreshedAt + ')';
    }

    public POILocationInfo(boolean r2, String r3, String r4, long r5) {
        o.e(r3, "home");
        o.e(r4, "company");
        this.isSucceeded = r2;
        this.home = r3;
        this.company = r4;
        this.refreshedAt = r5;
    }

    public final boolean isSucceeded() {
        return this.isSucceeded;
    }

    public final String getHome() {
        return this.home;
    }

    public final String getCompany() {
        return this.company;
    }

    public final long getRefreshedAt() {
        return this.refreshedAt;
    }
}
