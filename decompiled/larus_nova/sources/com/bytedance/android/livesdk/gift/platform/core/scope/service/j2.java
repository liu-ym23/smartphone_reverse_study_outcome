package com.bytedance.android.livesdk.gift.platform.core.scope.service;

/* JADX INFO: loaded from: classes9.dex */
public final class j2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f131609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f131610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f131611c;

    public j2() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j2) == false) goto L12;
        j2 r101 = (j2) r100;
        if (this.f131609a == r101.f131609a) goto L8;
        return false;
    L8:
        if (this.f131610b == r101.f131610b) goto L10;
        return false;
    L10:
        if (this.f131611c == r101.f131611c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f131609a * 31;
        long r101 = this.f131610b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f131611c;
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    }

    public final String toString() {
        return "GiftSendDetail(sendTimes=" + this.f131609a + ", sendCount=" + this.f131610b + ", sendDiamond=" + this.f131611c + ")";
    }

    public j2(int r100) {
        this.f131609a = 0;
        this.f131610b = 0;
        this.f131611c = 0;
    }
}
