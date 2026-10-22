package com.bytedance.android.ec.common.impl.sku.utils;

/* JADX INFO: loaded from: classes43.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f43362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f43363b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L10;
        l r101 = (l) r100;
        if (this.f43362a == r101.f43362a) goto L8;
        return false;
    L8:
        if (this.f43363b == r101.f43363b) goto L16;
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
        boolean r100 = this.f43362a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        long r102 = this.f43363b;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    }

    public final String toString() {
        return "SkuBigPicModeData(isBigPicMode=" + this.f43362a + ", timestamp=" + this.f43363b + ")";
    }

    public l(boolean r100, long r101) {
        this.f43362a = r100;
        this.f43363b = r101;
    }
}
