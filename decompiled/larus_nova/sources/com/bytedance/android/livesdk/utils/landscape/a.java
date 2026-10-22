package com.bytedance.android.livesdk.utils.landscape;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f159061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f159062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f159063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f159064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f159065e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f159066f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f159067g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f159068h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f159069i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f159070j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f159071k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L28;
        a r101 = (a) r100;
        if (this.f159061a == r101.f159061a) goto L8;
        return false;
    L8:
        if (Double.compare(this.f159062b, r101.f159062b) == 0) goto L10;
        return false;
    L10:
        if (this.f159063c == r101.f159063c) goto L12;
        return false;
    L12:
        if (this.f159064d == r101.f159064d) goto L14;
        return false;
    L14:
        if (this.f159065e == r101.f159065e) goto L16;
        return false;
    L16:
        if (this.f159066f == r101.f159066f) goto L18;
        return false;
    L18:
        if (this.f159067g == r101.f159067g) goto L20;
        return false;
    L20:
        if (this.f159068h == r101.f159068h) goto L22;
        return false;
    L22:
        if (this.f159069i == r101.f159069i) goto L24;
        return false;
    L24:
        if (Float.compare(this.f159070j, r101.f159070j) == 0) goto L26;
        return false;
    L26:
        if (this.f159071k == r101.f159071k) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f159061a * 31;
        long r101 = Double.doubleToLongBits(this.f159062b);
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = this.f159063c;
        return ((((((((((((((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f159064d) * 31) + this.f159065e) * 31) + this.f159066f) * 31) + this.f159067g) * 31) + this.f159068h) * 31) + this.f159069i) * 31) + Float.floatToIntBits(this.f159070j)) * 31) + this.f159071k;
    }

    public final String toString() {
        return "FluencyInfo(dropXCount=" + this.f159061a + ", uiFps=" + this.f159062b + ", duration=" + this.f159063c + ", allFrames=" + this.f159064d + ", dropMax=" + this.f159065e + ", level1=" + this.f159066f + ", level2=" + this.f159067g + ", level3=" + this.f159068h + ", level4=" + this.f159069i + ", blockDuration=" + this.f159070j + ", orientation=" + this.f159071k + ")";
    }

    public a(int r100, double r101, long r102, int r103, int r104, int r105, int r106, int r110, int r111, float r112, int r113) {
        this.f159061a = r100;
        this.f159062b = r101;
        this.f159063c = r102;
        this.f159064d = r103;
        this.f159065e = r104;
        this.f159066f = r105;
        this.f159067g = r106;
        this.f159068h = r110;
        this.f159069i = r111;
        this.f159070j = r112;
        this.f159071k = r113;
    }
}
