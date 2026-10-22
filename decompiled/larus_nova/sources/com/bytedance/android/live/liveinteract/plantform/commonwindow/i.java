package com.bytedance.android.live.liveinteract.plantform.commonwindow;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f75661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f75662b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L10;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f75661a, r101.f75661a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f75662b, r101.f75662b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        m r100 = this.f75661a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f75662b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GetLayoutConfigResponse(layoutConfig=" + this.f75661a + ", step=" + this.f75662b + ")";
    }

    public i(m r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "layoutConfig");
        Intrinsics.checkNotNullParameter(r101, "step");
        this.f75661a = r100;
        this.f75662b = r101;
    }
}
