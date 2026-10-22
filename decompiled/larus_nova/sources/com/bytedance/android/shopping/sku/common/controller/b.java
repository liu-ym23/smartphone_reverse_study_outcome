package com.bytedance.android.shopping.sku.common.controller;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f182630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f182631b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (this.f182630a == r101.f182630a) goto L8;
        return false;
    L8:
        if (this.f182631b == r101.f182631b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r100 = this.f182630a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        long r102 = this.f182631b;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "SkuBigPicModeData(isBigPicMode=" + this.f182630a + ", timestamp=" + this.f182631b + ")";
    }

    public b(boolean r100, long r101) {
        this.f182630a = r100;
        this.f182631b = r101;
    }
}
