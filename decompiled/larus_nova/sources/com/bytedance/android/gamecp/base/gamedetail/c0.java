package com.bytedance.android.gamecp.base.gamedetail;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ItemViewLayoutStyle f51563a;

    public c0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c0) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f51563a, ((c0) r100).f51563a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        ItemViewLayoutStyle r100 = this.f51563a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "DetailItemLayoutStyle(layoutStyle=" + this.f51563a + ")";
    }

    public c0(ItemViewLayoutStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "layoutStyle");
        this.f51563a = r100;
    }

    public /* synthetic */ c0(int r100) {
        this(ItemViewLayoutStyle.Normal);
    }
}
