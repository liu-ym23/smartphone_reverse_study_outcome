package com.bytedance.android.anniex.detect;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f40655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f40656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f40657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f40658d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f40659e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f40660f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f40661g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f40662h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f40663i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f40664j;

    public d() {
        this(false, false, false, 1500, 500, 360.0f, 0.9f, 500, 500, ((long) 60) * 1000);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.f40655a == r101.f40655a) goto L12;
        return false;
    L12:
        if (this.f40656b == r101.f40656b) goto L15;
        return false;
    L15:
        if (this.f40657c == r101.f40657c) goto L18;
        return false;
    L18:
        if (this.f40658d == r101.f40658d) goto L21;
        return false;
    L21:
        if (this.f40659e == r101.f40659e) goto L24;
        return false;
    L24:
        if (Float.compare(this.f40660f, r101.f40660f) == 0) goto L27;
        return false;
    L27:
        if (Float.compare(this.f40661g, r101.f40661g) == 0) goto L30;
        return false;
    L30:
        if (this.f40662h == r101.f40662h) goto L33;
        return false;
    L33:
        if (this.f40663i == r101.f40663i) goto L36;
        return false;
    L36:
        if (this.f40664j == r101.f40664j) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f40655a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f40656b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f40657c == true) goto L14;
        r100 = 1237;
    L14:
        int r105 = (r104 + r100) * 31;
        long r106 = this.f40658d;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f40659e;
        int r109 = (((((r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31) + Float.floatToIntBits(this.f40660f)) * 31) + Float.floatToIntBits(this.f40661g)) * 31;
        long r110 = this.f40662h;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = this.f40663i;
        int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        long r114 = this.f40664j;
        return r113 + ((int) (r114 ^ (r114 >>> 32)));
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "BlankDetectorConfig(isCheckEnable=" + this.f40655a + ", isPureBlankCheckEnable=" + this.f40656b + ", isPartialBlankCheckEnable=" + this.f40657c + ", checkTimeoutMs=" + this.f40658d + ", snapShotTimeoutMs=" + this.f40659e + ", snapShotMaxQuality=" + this.f40660f + ", pureColorCheckThreshold=" + this.f40661g + ", pureColorCheckTimeoutMs=" + this.f40662h + ", partialBlankCheckTimeoutMs=" + this.f40663i + ", detectFrequencyInternal=" + this.f40664j + ')';
    }

    public d(boolean r100, boolean r101, boolean r102, long r103, long r104, float r105, float r106, long r110, long r111, long r112) {
        this.f40655a = r100;
        this.f40656b = r101;
        this.f40657c = r102;
        this.f40658d = r103;
        this.f40659e = r104;
        this.f40660f = r105;
        this.f40661g = r106;
        this.f40662h = r110;
        this.f40663i = r111;
        this.f40664j = r112;
    }
}
