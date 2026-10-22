package com.bytedance.android.shopping.prepurchase.arch.exposure;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f180908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f180909b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L10;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f180908a, r101.f180908a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f180909b, r101.f180909b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f180908a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f180909b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ViewItem(viewId=" + this.f180908a + ", childViewId=" + this.f180909b + ")";
    }

    public l(String r100) {
        Intrinsics.checkNotNullParameter(r100, "viewId");
        Intrinsics.checkNotNullParameter("", "childViewId");
        this.f180908a = r100;
        this.f180909b = "";
    }
}
