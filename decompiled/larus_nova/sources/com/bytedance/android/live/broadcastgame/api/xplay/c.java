package com.bytedance.android.live.broadcastgame.api.xplay;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f59477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f59478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f59479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f59480d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L14;
        c r101 = (c) r100;
        if (this.f59477a == r101.f59477a) goto L8;
        return false;
    L8:
        if (this.f59478b == r101.f59478b) goto L10;
        return false;
    L10:
        if (Float.compare(this.f59479c, r101.f59479c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f59480d, r101.f59480d) == 0) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f59477a * 31) + this.f59478b) * 31) + Float.floatToIntBits(this.f59479c)) * 31) + Float.floatToIntBits(this.f59480d);
    }

    public final String toString() {
        return "CustomLittleWindowPos(playWidth=" + this.f59477a + ", playHeight=" + this.f59478b + ", x=" + this.f59479c + ", y=" + this.f59480d + ")";
    }

    public c(int r100, int r101, float r102, float r103) {
        this.f59477a = r100;
        this.f59478b = r101;
        this.f59479c = r102;
        this.f59480d = r103;
    }
}
