package com.bytedance.android.gamecp.business.gamedetail.page.root;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class s0 implements com.bytedance.ies.sve_core.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f55585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p0 f55586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f55587c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s0) == false) goto L12;
        s0 r101 = (s0) r100;
        if (this.f55585a == r101.f55585a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f55586b, r101.f55586b) == true) goto L10;
        return false;
    L10:
        if (this.f55587c == r101.f55587c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        int r100 = this.f55585a * 31;
        p0 r101 = this.f55586b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L6:
        int r103 = (r100 + r102) * 31;
        boolean r104 = this.f55587c;
        ?? r105 = r104;
        if (r104 == false) goto L10;
        r105 = 1;
    L10:
        return r103 + r105;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "StatusBarProps(titleBarStyle=" + this.f55585a + ", outerRVScrollData=" + this.f55586b + ", fromGameDetailDismiss=" + this.f55587c + ")";
    }

    public s0(int r100) {
        p0 r101 = new p0(0);
        Intrinsics.checkNotNullParameter(r101, "outerRVScrollData");
        this.f55585a = r100;
        this.f55586b = r101;
        this.f55587c = false;
    }
}
