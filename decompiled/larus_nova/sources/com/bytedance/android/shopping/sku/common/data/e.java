package com.bytedance.android.shopping.sku.common.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f182676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f182677b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f182678c;

    public e() {
        this(null, null, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L12;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f182676a, r101.f182676a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f182677b, r101.f182677b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f182678c, r101.f182678c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f182676a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f182677b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f182678c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SkuCommonCacheNextData(nextSkuId=" + this.f182676a + ", nextCount=" + this.f182677b + ", nextIsBigMode=" + this.f182678c + ")";
    }

    public e(String r100, Integer r101, Boolean r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this.f182676a = r100;
        this.f182677b = r101;
        this.f182678c = r102;
    }
}
