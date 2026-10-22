package com.bytedance.android.ec.hybrid.ui;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f47693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f47694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f47695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f47696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f47697e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f47698f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f47699g;

    public d() {
        this(0, 0, 0, 0, 0, 0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L20;
        d r101 = (d) r100;
        if (this.f47693a == r101.f47693a) goto L8;
        return false;
    L8:
        if (this.f47694b == r101.f47694b) goto L10;
        return false;
    L10:
        if (this.f47695c == r101.f47695c) goto L12;
        return false;
    L12:
        if (this.f47696d == r101.f47696d) goto L14;
        return false;
    L14:
        if (this.f47697e == r101.f47697e) goto L16;
        return false;
    L16:
        if (this.f47698f == r101.f47698f) goto L18;
        return false;
    L18:
        if (this.f47699g == r101.f47699g) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r100 = ((((((this.f47693a * 31) + this.f47694b) * 31) + this.f47695c) * 31) + this.f47696d) * 31;
        long r101 = this.f47697e;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f47698f;
        return ((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f47699g;
    }

    public final String toString() {
        return "ECMarqueeStyleUIData(width=" + this.f47693a + ", height=" + this.f47694b + ", xPosition=" + this.f47695c + ", yPosition=" + this.f47696d + ", alphaDuration=" + this.f47697e + ", marqueeDuration=" + this.f47698f + ", positionType=" + this.f47699g + ")";
    }

    public d(int r100, int r101, int r102, int r103, long r104, long r105, int r106) {
        this.f47693a = r100;
        this.f47694b = r101;
        this.f47695c = r102;
        this.f47696d = r103;
        this.f47697e = r104;
        this.f47698f = r105;
        this.f47699g = r106;
    }
}
