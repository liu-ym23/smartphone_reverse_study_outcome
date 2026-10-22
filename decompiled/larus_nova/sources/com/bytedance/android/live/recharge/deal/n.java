package com.bytedance.android.live.recharge.deal;

/* JADX INFO: loaded from: classes47.dex */
public final class n extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f89726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f89727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f89728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f89729e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f89730f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f89731g;

    @Override // com.bytedance.android.live.recharge.deal.f
    public final long b() {
        return 0;
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final int h() {
        return 0;
    }

    public final int hashCode() {
        return (((this.f89729e * 31) + this.f89730f) * 31) + this.f89731g;
    }

    public final String toString() {
        return "ExchangeCustomDeal(diamondCount=" + this.f89729e + ", cashAmount=" + this.f89730f + ", goldAmount=" + this.f89731g + ")";
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final String d() {
        return this.f89727c;
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final int e() {
        return this.f89729e;
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final String f() {
        return this.f89728d;
    }

    @Override // com.bytedance.android.live.recharge.deal.f
    public final long g() {
        return this.f89726b;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L12;
        n r101 = (n) r100;
        if (this.f89729e == r101.f89729e) goto L8;
        return false;
    L8:
        if (this.f89730f == r101.f89730f) goto L10;
        return false;
    L10:
        if (this.f89731g == r101.f89731g) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public n(int r100, int r101, int r102) {
        this.f89729e = r100;
        this.f89730f = r101;
        this.f89731g = r102;
        this.f89726b = ((long) r100) * 10;
        this.f89727c = "";
        this.f89728d = "";
    }
}
