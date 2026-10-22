package com.bytedance.android.gamecp.base.gamedetail;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s0 f51661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s0 f51662b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u0) == false) goto L10;
        u0 r101 = (u0) r100;
        if (Intrinsics.areEqual(this.f51661a, r101.f51661a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f51662b, r101.f51662b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        s0 r100 = this.f51661a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        s0 r104 = this.f51662b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "NewBottomDetailDownloadViewPcStyle(supportStyle=" + this.f51661a + ", checkQualifiedPcStyle=" + this.f51662b + ")";
    }

    public u0(b1 r100, b1 r101) {
        Intrinsics.checkNotNullParameter(r100, "supportStyle");
        this.f51661a = r100;
        this.f51662b = r101;
    }
}
