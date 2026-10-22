package com.bytedance.android.livesdk.gift.platform.core;

/* JADX INFO: loaded from: classes9.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f130691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f130692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f130693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f130694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f130695e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L16;
        i r101 = (i) r100;
        if (this.f130691a == r101.f130691a) goto L8;
        return false;
    L8:
        if (this.f130692b == r101.f130692b) goto L10;
        return false;
    L10:
        if (this.f130693c == r101.f130693c) goto L12;
        return false;
    L12:
        if (this.f130694d == r101.f130694d) goto L14;
        return false;
    L14:
        if (this.f130695e == r101.f130695e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f130691a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f130692b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f130693c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f130694d;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f130695e;
        return r107 + ((int) (r108 ^ (r108 >>> 32)));
    }

    public final String toString() {
        return "GiftEventTime(openDialog=" + this.f130691a + ", giftPreview=" + this.f130692b + ", giftDoubleClick=" + this.f130693c + ", sendGift=" + this.f130694d + ", giftShow=" + this.f130695e + ")";
    }

    public i(long r100, long r101, long r102, long r103, long r104) {
        this.f130691a = r100;
        this.f130692b = r101;
        this.f130693c = r102;
        this.f130694d = r103;
        this.f130695e = r104;
    }

    public static i a(i r110, long r111, long r112, long r113, long r210, int r211) {
        if ((r211 & 1) == 0) goto L5;
        long r100 = r110.f130691a;
    L6:
        long r101 = r100;
        if ((r211 & 2) == 0) goto L9;
        long r102 = r110.f130692b;
    L11:
        if ((r211 & 4) == 0) goto L13;
        long r103 = r110.f130693c;
    L15:
        if ((r211 & 8) == 0) goto L17;
        long r114 = r110.f130694d;
    L19:
        if ((r211 & 16) == 0) goto L21;
        long r115 = r110.f130695e;
    L23:
        return new i(r101, r102, r103, r114, r115);
    L21:
        r115 = r210;
        goto L23
    L17:
        r114 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r100 = 0;
        goto L6
    }
}
