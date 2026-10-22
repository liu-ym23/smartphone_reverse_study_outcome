package com.bytedance.android.livesdk.gift.platform.core.scope.service;

/* JADX INFO: loaded from: classes9.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f131719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f131720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f131721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f131722d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f131723e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s0) == false) goto L16;
        s0 r101 = (s0) r100;
        if (this.f131719a == r101.f131719a) goto L8;
        return false;
    L8:
        if (this.f131720b == r101.f131720b) goto L10;
        return false;
    L10:
        if (this.f131721c == r101.f131721c) goto L12;
        return false;
    L12:
        if (this.f131722d == r101.f131722d) goto L14;
        return false;
    L14:
        if (this.f131723e == r101.f131723e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f131719a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f131720b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f131721c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f131722d;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f131723e;
        return r107 + ((int) (r108 ^ (r108 >>> 32)));
    }

    public final String toString() {
        return "GiftEventTime(openDialog=" + this.f131719a + ", giftPreview=" + this.f131720b + ", giftDoubleClick=" + this.f131721c + ", sendGift=" + this.f131722d + ", giftShow=" + this.f131723e + ")";
    }

    public s0() {
        this.f131719a = 0;
        this.f131720b = 0;
        this.f131721c = 0;
        this.f131722d = 0;
        this.f131723e = 0;
    }
}
