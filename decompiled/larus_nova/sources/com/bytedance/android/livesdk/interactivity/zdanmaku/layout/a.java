package com.bytedance.android.livesdk.interactivity.zdanmaku.layout;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f141648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f141649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f141650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f141651d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f141652e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f141653f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f141654g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L18;
        a r101 = (a) r100;
        if (this.f141649b == r101.f141649b) goto L8;
        return false;
    L8:
        if (this.f141650c == r101.f141650c) goto L10;
        return false;
    L10:
        if (this.f141651d == r101.f141651d) goto L12;
        return false;
    L12:
        if (this.f141652e == r101.f141652e) goto L14;
        return false;
    L14:
        if (this.f141653f == r101.f141653f) goto L16;
        return false;
    L16:
        if (Float.compare(this.f141654g, r101.f141654g) == 0) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        return (((((((((this.f141649b * 31) + this.f141650c) * 31) + this.f141651d) * 31) + this.f141652e) * 31) + this.f141653f) * 31) + Float.floatToIntBits(this.f141654g);
    }

    public final String toString() {
        return "DanmakuConfig(displayWidth=" + this.f141649b + ", displayHeight=" + this.f141650c + ", lineHeight=" + this.f141651d + ", lineSpacing=" + this.f141652e + ", duration=" + this.f141653f + ", speed=" + this.f141654g + ")";
    }

    public a(int r100, int r101, int r102, int r103, int r104, float r105) {
        this.f141649b = r100;
        this.f141650c = r101;
        this.f141651d = r102;
        this.f141652e = r103;
        this.f141653f = r104;
        this.f141654g = r105;
        this.f141648a = (r101 - r103) / (r102 + r103);
    }
}
