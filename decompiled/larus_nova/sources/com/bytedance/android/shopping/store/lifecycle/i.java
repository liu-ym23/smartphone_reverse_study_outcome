package com.bytedance.android.shopping.store.lifecycle;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f185484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f185485b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L10;
        i r101 = (i) r100;
        if (this.f185484a == r101.f185484a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f185485b, r101.f185485b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f185484a * 31;
        String r101 = this.f185485b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "StoreAction(tabType=" + this.f185484a + ", eventName=" + this.f185485b + ")";
    }

    public i(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "eventName");
        this.f185484a = r100;
        this.f185485b = r101;
    }
}
