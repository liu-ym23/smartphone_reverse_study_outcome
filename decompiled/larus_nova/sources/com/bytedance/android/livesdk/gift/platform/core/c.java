package com.bytedance.android.livesdk.gift.platform.core;

/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f130472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f130473b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (this.f130472a == r101.f130472a) goto L8;
        return false;
    L8:
        if (this.f130473b == r101.f130473b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f130472a;
        return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f130473b;
    }

    public final String toString() {
        return "BuffLevelInfo(giftId=" + this.f130472a + ", buffLevel=" + this.f130473b + ")";
    }

    public c(long r100, int r101) {
        this.f130472a = r100;
        this.f130473b = r101;
    }
}
