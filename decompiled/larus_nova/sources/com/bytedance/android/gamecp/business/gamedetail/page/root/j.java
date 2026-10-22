package com.bytedance.android.gamecp.business.gamedetail.page.root;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class j implements com.bytedance.ies.sve_core.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f55535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Float f55536b;

    public static final class a {
    }

    static {
    }

    public j() {
        this(2, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L10;
        j r101 = (j) r100;
        if (this.f55535a == r101.f55535a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f55536b, r101.f55536b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f55535a * 31;
        Float r101 = this.f55536b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "DetailDragBarProps(dragBarStyle=" + this.f55535a + ", dialogSlideOffset=" + this.f55536b + ")";
    }

    public j(int r100, Float r101) {
        this.f55535a = r100;
        this.f55536b = r101;
    }
}
