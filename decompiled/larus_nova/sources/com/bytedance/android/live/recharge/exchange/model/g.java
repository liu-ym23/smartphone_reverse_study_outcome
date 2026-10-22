package com.bytedance.android.live.recharge.exchange.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f89859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f89860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f89861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f89862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f89863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.live.recharge.platform.business.model.exchange.b f89864f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final zv0.e f89865g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L20;
        g r101 = (g) r100;
        if (this.f89859a == r101.f89859a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f89860b, r101.f89860b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f89861c, r101.f89861c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f89862d, r101.f89862d) == true) goto L14;
        return false;
    L14:
        if (this.f89863e == r101.f89863e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f89864f, r101.f89864f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f89865g, r101.f89865g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f89859a * 31;
        Throwable r101 = this.f89860b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.f89861c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f89862d;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        long r110 = this.f89863e;
        int r111 = (((r107 + r109) * 31) + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        com.bytedance.android.live.recharge.platform.business.model.exchange.b r112 = this.f89864f;
        if (r112 == null) goto L17;
        int r113 = r112.hashCode();
    L18:
        int r114 = (r111 + r113) * 31;
        zv0.e r115 = this.f89865g;
        if (r115 == null) goto L22;
        r102 = r115.hashCode();
    L22:
        return r114 + r102;
    L17:
        r113 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "StateBean(status=" + this.f89859a + ", message=" + this.f89860b + ", rebateCoin=" + this.f89861c + ", rebateMessage=" + this.f89862d + ", diamond=" + this.f89863e + ", exchangeMarketData=" + this.f89864f + ", listener=" + this.f89865g + ")";
    }

    public g(int r100, Throwable r101, Integer r102, String r103, long r104, zv0.e r105, int r110) {
        if ((r110 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r110 & 4) == 0) goto L9;
        r102 = 0;
    L9:
        if ((r110 & 8) == 0) goto L12;
        r103 = null;
    L12:
        if ((r110 & 16) == 0) goto L15;
        r104 = 0;
    L15:
        if ((r110 & 64) == 0) goto L17;
        r105 = null;
    L17:
        this.f89859a = r100;
        this.f89860b = r101;
        this.f89861c = r102;
        this.f89862d = r103;
        this.f89863e = r104;
        this.f89864f = null;
        this.f89865g = r105;
    }
}
