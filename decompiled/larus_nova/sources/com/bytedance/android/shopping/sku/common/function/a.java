package com.bytedance.android.shopping.sku.common.function;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f182718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f182719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f182720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f182721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f182722e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L16;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f182718a, r101.f182718a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f182719b, r101.f182719b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f182720c, r101.f182720c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f182721d, r101.f182721d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f182722e, r101.f182722e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f182718a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f182719b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f182720c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f182721d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, Object> r113 = this.f182722e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CalCurSkuIdResult(nextSkuId=" + this.f182718a + ", nextSpecsContent=" + this.f182719b + ", nextPicSpecItemId=" + this.f182720c + ", nextHeadImg=" + this.f182721d + ", nextSpecItemsState=" + this.f182722e + ")";
    }

    public a(String r100, String r101, String r102, String r103, Map<String, ? extends Object> r104) {
        Intrinsics.checkNotNullParameter(r100, "nextSkuId");
        Intrinsics.checkNotNullParameter(r101, "nextSpecsContent");
        Intrinsics.checkNotNullParameter(r102, "nextPicSpecItemId");
        Intrinsics.checkNotNullParameter(r103, "nextHeadImg");
        Intrinsics.checkNotNullParameter(r104, "nextSpecItemsState");
        this.f182718a = r100;
        this.f182719b = r101;
        this.f182720c = r102;
        this.f182721d = r103;
        this.f182722e = r104;
    }
}
