package com.bytedance.android.live.broadcastgame.api.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f59358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f59359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f59360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InteractID f59361d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i0) == false) goto L12;
        i0 r101 = (i0) r100;
        if (Intrinsics.areEqual(this.f59359b, r101.f59359b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f59360c, r101.f59360c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f59361d, r101.f59361d) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f59359b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f59360c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        InteractID r107 = this.f59361d;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OpenPlatformAppInfo(appId=" + this.f59359b + ", appName=" + this.f59360c + ", appType=" + this.f59361d + ")";
    }

    public i0(String r100, String r101, InteractID r102) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r101, "appName");
        Intrinsics.checkNotNullParameter(r102, "appType");
        this.f59359b = r100;
        this.f59360c = r101;
        this.f59361d = r102;
        this.f59358a = "";
    }
}
