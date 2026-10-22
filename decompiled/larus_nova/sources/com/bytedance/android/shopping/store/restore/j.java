package com.bytedance.android.shopping.store.restore;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.ec.hybrid.list.entity.k f185810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f185811b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L10;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f185810a, r101.f185810a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f185811b, r101.f185811b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.ec.hybrid.list.entity.k r100 = this.f185810a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        f r104 = this.f185811b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ProductTabListData(listData=" + this.f185810a + ", scrollState=" + this.f185811b + ")";
    }

    public j(com.bytedance.android.ec.hybrid.list.entity.k r100, f r101) {
        this.f185810a = r100;
        this.f185811b = r101;
    }
}
