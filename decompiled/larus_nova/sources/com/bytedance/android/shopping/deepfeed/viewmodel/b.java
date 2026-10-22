package com.bytedance.android.shopping.deepfeed.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f173992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f173993b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (this.f173992a == r101.f173992a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f173993b, r101.f173993b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f173992a * 31;
        String r101 = this.f173993b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "DeepFeedCouponWaistEnterStatus(position=" + this.f173992a + ", productId=" + this.f173993b + ")";
    }

    public b(int r100, String r101) {
        this.f173992a = r100;
        this.f173993b = r101;
    }
}
