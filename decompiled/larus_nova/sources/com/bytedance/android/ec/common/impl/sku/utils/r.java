package com.bytedance.android.ec.common.impl.sku.utils;

/* JADX INFO: loaded from: classes43.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f43372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f43373b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == false) goto L10;
        r r101 = (r) r100;
        if (this.f43372a == r101.f43372a) goto L8;
        return false;
    L8:
        if (this.f43373b == r101.f43373b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f43372a * 31;
        long r101 = this.f43373b;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "SkuTradeModeData(selectIndex=" + this.f43372a + ", timestamp=" + this.f43373b + ")";
    }

    public r(int r100, long r101) {
        this.f43372a = r100;
        this.f43373b = r101;
    }
}
