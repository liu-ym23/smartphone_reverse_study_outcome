package com.bytedance.android.shopping.store.viewmodel;

import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f187023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECStoreTabAreaVO f187024b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L10;
        k r101 = (k) r100;
        if (this.f187023a == r101.f187023a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f187024b, r101.f187024b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f187023a * 31;
        ECStoreTabAreaVO r101 = this.f187024b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "TabDataWrapper(statusCode=" + this.f187023a + ", tabAreaVO=" + this.f187024b + ")";
    }

    public k(int r100, ECStoreTabAreaVO r101) {
        this.f187023a = r100;
        this.f187024b = r101;
    }
}
