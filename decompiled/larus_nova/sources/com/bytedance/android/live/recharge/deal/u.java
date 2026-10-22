package com.bytedance.android.live.recharge.deal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class u extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f89764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f89765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f89766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f89767e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f89768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f89769g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f89770h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f89771i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f89772j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f89773k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f89774l;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    public final int hashCode() {
        long r100 = this.f89764b;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f89765c;
        int r103 = (((((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f89766d) * 31) + this.f89767e) * 31;
        String r104 = this.f89768f;
        int r105 = 0;
        if (r104 == null) goto L5;
        int r106 = r104.hashCode();
    L6:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f89769g;
        if (r108 == null) goto L9;
        int r109 = r108.hashCode();
    L10:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.f89770h;
        ?? r112 = r111;
        if (r111 == false) goto L13;
        r112 = 1;
    L13:
        int r113 = (((((r110 + r112) * 31) + this.f89771i) * 31) + this.f89772j) * 31;
        String r114 = this.f89773k;
        if (r114 == null) goto L17;
        r105 = r114.hashCode();
    L17:
        return ((r113 + r105) * 31) + this.f89774l;
    L9:
        r109 = 0;
        goto L10
    L5:
        r106 = 0;
        goto L6
    }

    public final String toString() {
        return "RegularDeal(dealId=" + this.f89764b + ", price=" + this.f89765c + ", diamondCount=" + this.f89766d + ", rewardDiamondCount=" + this.f89767e + ", description=" + this.f89768f + ", iapProductId=" + this.f89769g + ", isServerCustomized=" + this.f89770h + ", discountPrice=" + this.f89771i + ", exchangePrice=" + this.f89772j + ", diamondSignInfo=" + this.f89773k + ", describeType=" + this.f89774l + ")";
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final long b() {
        return this.f89764b;
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final String d() {
        return this.f89768f;
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final int e() {
        return this.f89766d;
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final String f() {
        return this.f89769g;
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final long g() {
        return this.f89765c;
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final int h() {
        return this.f89767e;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u) == false) goto L28;
        u r101 = (u) r100;
        if (this.f89764b == r101.f89764b) goto L8;
        return false;
    L8:
        if (this.f89765c == r101.f89765c) goto L10;
        return false;
    L10:
        if (this.f89766d == r101.f89766d) goto L12;
        return false;
    L12:
        if (this.f89767e == r101.f89767e) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f89768f, r101.f89768f) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f89769g, r101.f89769g) == true) goto L18;
        return false;
    L18:
        if (this.f89770h == r101.f89770h) goto L20;
        return false;
    L20:
        if (this.f89771i == r101.f89771i) goto L22;
        return false;
    L22:
        if (this.f89772j == r101.f89772j) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f89773k, r101.f89773k) == true) goto L26;
        return false;
    L26:
        if (this.f89774l == r101.f89774l) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public u(long r100, long r101, int r102, int r103, String r104, String r105, boolean r110, int r111, int r112, String r113, int r114) {
        Intrinsics.checkNotNullParameter(r104, "description");
        Intrinsics.checkNotNullParameter(r105, "iapProductId");
        Intrinsics.checkNotNullParameter(r113, "diamondSignInfo");
        this.f89764b = r100;
        this.f89765c = r101;
        this.f89766d = r102;
        this.f89767e = r103;
        this.f89768f = r104;
        this.f89769g = r105;
        this.f89770h = r110;
        this.f89771i = r111;
        this.f89772j = r112;
        this.f89773k = r113;
        this.f89774l = r114;
    }
}
