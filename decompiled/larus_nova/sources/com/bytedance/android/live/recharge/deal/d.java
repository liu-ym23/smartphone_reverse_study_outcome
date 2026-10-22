package com.bytedance.android.live.recharge.deal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f89706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f89707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f89708d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f89709e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f89710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f89711g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f89712h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f89713i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f89714j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f89715k;

    @Override // com.bytedance.android.live.recharge.deal.f
    public final int e() {
        return (int) (this.f89713i * this.f89707c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r1v18, types: [int] */
    public final int hashCode() {
        long r100 = this.f89706b;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f89707c;
        int r103 = (((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f89708d) * 31;
        String r104 = this.f89709e;
        int r105 = 0;
        if (r104 == null) goto L5;
        int r106 = r104.hashCode();
    L6:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f89710f;
        if (r108 == null) goto L9;
        int r109 = r108.hashCode();
    L10:
        long r110 = this.f89711g;
        int r111 = (((r107 + r109) * 31) + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = this.f89712h;
        int r113 = (((r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31) + Float.floatToIntBits(this.f89713i)) * 31;
        String r114 = this.f89714j;
        if (r114 == null) goto L13;
        r105 = r114.hashCode();
    L13:
        int r115 = (r113 + r105) * 31;
        boolean r116 = this.f89715k;
        ?? r117 = r116;
        if (r116 == false) goto L17;
        r117 = 1;
    L17:
        return r115 + r117;
    L9:
        r109 = 0;
        goto L10
    L5:
        r106 = 0;
        goto L6
    }

    public final String toString() {
        return "CustomDeal(dealId=" + this.f89706b + ", price=" + this.f89707c + ", rewardDiamondCount=" + this.f89708d + ", description=" + this.f89709e + ", iapProductId=" + this.f89710f + ", priceMin=" + this.f89711g + ", priceMax=" + this.f89712h + ", diamondCountRate=" + this.f89713i + ", couponId=" + this.f89714j + ", isUserCustomized=" + this.f89715k + ")";
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final long b() {
        return this.f89706b;
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final String d() {
        return this.f89709e;
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final String f() {
        return this.f89710f;
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final long g() {
        return this.f89707c;
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final int h() {
        return this.f89708d;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L26;
        d r101 = (d) r100;
        if (this.f89706b == r101.f89706b) goto L8;
        return false;
    L8:
        if (this.f89707c == r101.f89707c) goto L10;
        return false;
    L10:
        if (this.f89708d == r101.f89708d) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f89709e, r101.f89709e) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f89710f, r101.f89710f) == true) goto L16;
        return false;
    L16:
        if (this.f89711g == r101.f89711g) goto L18;
        return false;
    L18:
        if (this.f89712h == r101.f89712h) goto L20;
        return false;
    L20:
        if (Float.compare(this.f89713i, r101.f89713i) == 0) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f89714j, r101.f89714j) == true) goto L24;
        return false;
    L24:
        if (this.f89715k == r101.f89715k) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public static d j(d r210, long r211, boolean r212, int r213) {
        long r100 = 0;
        if ((r213 & 1) == 0) goto L5;
        long r101 = r210.f89706b;
    L7:
        if ((r213 & 2) == 0) goto L9;
        long r110 = r210.f89707c;
    L11:
        if ((r213 & 4) == 0) goto L13;
        int r111 = r210.f89708d;
    L15:
        if ((r213 & 8) == 0) goto L17;
        String r112 = r210.f89709e;
    L19:
        if ((r213 & 16) == 0) goto L21;
        String r113 = r210.f89710f;
    L23:
        if ((r213 & 32) == 0) goto L25;
        long r114 = r210.f89711g;
    L27:
        if ((r213 & 64) == 0) goto L29;
        r100 = r210.f89712h;
    L29:
        long r115 = r100;
        if ((r213 & 128) == 0) goto L32;
        float r116 = r210.f89713i;
    L34:
        if ((r213 & 256) == 0) goto L36;
        String r102 = r210.f89714j;
    L38:
        if ((r213 & 512) == 0) goto L40;
        boolean r214 = r210.f89715k;
    L41:
        r210.getClass();
        Intrinsics.checkNotNullParameter(r112, "description");
        Intrinsics.checkNotNullParameter(r113, "iapProductId");
        Intrinsics.checkNotNullParameter(r102, "couponId");
        return new d(r101, r110, r111, r112, r113, r114, r115, r116, r102, r214);
    L40:
        r214 = r212;
        goto L41
    L36:
        r102 = null;
        goto L38
    L32:
        r116 = 0.0f;
        goto L34
    L25:
        r114 = 0;
        goto L27
    L21:
        r113 = null;
        goto L23
    L17:
        r112 = null;
        goto L19
    L13:
        r111 = 0;
        goto L15
    L9:
        r110 = r211;
        goto L11
    L5:
        r101 = 0;
        goto L7
    }

    public d(long r100, long r101, int r102, String r103, String r104, long r105, long r110, float r111, String r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r103, "description");
        Intrinsics.checkNotNullParameter(r104, "iapProductId");
        Intrinsics.checkNotNullParameter(r112, "couponId");
        this.f89706b = r100;
        this.f89707c = r101;
        this.f89708d = r102;
        this.f89709e = r103;
        this.f89710f = r104;
        this.f89711g = r105;
        this.f89712h = r110;
        this.f89713i = r111;
        this.f89714j = r112;
        this.f89715k = r113;
    }
}
