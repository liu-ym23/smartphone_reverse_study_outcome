package com.bytedance.android.live.broadcastgame.xplay.screendetect;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f62360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f62361b;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (this.f62360a == r101.f62360a) goto L8;
        return false;
    L8:
        if (this.f62361b == r101.f62361b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.f62360a * 31) + this.f62361b;
    }

    public final String toString() {
        return "Pixel(pixel=" + this.f62360a + ", times=" + this.f62361b + ")";
    }

    public b(int r100) {
        this.f62360a = 0;
        this.f62361b = 0;
    }
}
