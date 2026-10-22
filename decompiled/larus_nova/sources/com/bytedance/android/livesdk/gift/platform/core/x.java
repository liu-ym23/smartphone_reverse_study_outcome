package com.bytedance.android.livesdk.gift.platform.core;

/* JADX INFO: loaded from: classes9.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f132090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f132091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f132092c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x) == false) goto L12;
        x r101 = (x) r100;
        if (Float.compare(this.f132090a, r101.f132090a) == 0) goto L8;
        return false;
    L8:
        if (Double.compare(this.f132091b, r101.f132091b) == 0) goto L10;
        return false;
    L10:
        if (Double.compare(this.f132092c, r101.f132092c) == 0) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = Float.floatToIntBits(this.f132090a) * 31;
        long r101 = Double.doubleToLongBits(this.f132091b);
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = Double.doubleToLongBits(this.f132092c);
        return r102 + ((int) (r103 ^ (r103 >>> 32)));
    }

    public final String toString() {
        return "HotRoomInfo(temperature=" + this.f132090a + ", UIFps=" + this.f132091b + ", UpStreamFps=" + this.f132092c + ")";
    }

    public x(float r100, double r101, double r102) {
        this.f132090a = r100;
        this.f132091b = r101;
        this.f132092c = r102;
    }
}
