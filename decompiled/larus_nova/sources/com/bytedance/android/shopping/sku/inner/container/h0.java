package com.bytedance.android.shopping.sku.inner.container;

import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f182847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ph3.a f182848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ProductSelectPoiInfo f182849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile p f182850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ul.f f182851e;

    public h0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h0) == false) goto L16;
        h0 r101 = (h0) r100;
        if (Intrinsics.areEqual(this.f182847a, r101.f182847a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f182848b, r101.f182848b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f182849c, r101.f182849c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f182850d, r101.f182850d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f182851e, r101.f182851e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f182847a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ph3.a r104 = this.f182848b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ProductSelectPoiInfo r107 = this.f182849c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        p r110 = this.f182850d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        ul.f r113 = this.f182851e;
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
        return "SkuYataStaticState(couponId=" + this.f182847a + ", cartInfo=" + this.f182848b + ", poiInfo=" + this.f182849c + ", clickAfterUplink=" + this.f182850d + ", skuPageState=" + this.f182851e + ")";
    }

    public h0(int r100) {
        ul.f r101 = new ul.f();
        Intrinsics.checkNotNullParameter(r101, "skuPageState");
        this.f182847a = null;
        this.f182848b = null;
        this.f182849c = null;
        this.f182850d = null;
        this.f182851e = r101;
    }
}
