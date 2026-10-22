package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class he1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f120368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f120369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f120370c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof he1) == false) goto L12;
        he1 r101 = (he1) r100;
        if (this.f120368a == r101.f120368a) goto L8;
        return false;
    L8:
        if (this.f120369b == r101.f120369b) goto L10;
        return false;
    L10:
        if (this.f120370c == r101.f120370c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f120368a;
        return (((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f120369b) * 31) + this.f120370c;
    }

    public final String toString() {
        return "PlayerTipsFilterConfig(showTimestamp=" + this.f120368a + ", showTimes=" + this.f120369b + ", closeTimes=" + this.f120370c + ")";
    }

    public he1() {
        this(0, 0, 0);
    }

    public he1(long r100, int r101, int r102) {
        this.f120368a = r100;
        this.f120369b = r101;
        this.f120370c = r102;
    }
}
