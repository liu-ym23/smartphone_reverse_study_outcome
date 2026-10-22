package com.bytedance.android.livesdk.gift.platform.core.scope.service;

/* JADX INFO: loaded from: classes9.dex */
public final class y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f131844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f131845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f131846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f131847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f131848e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f131849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f131850g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f131851h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f131852i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f131853j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f131854k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f131855l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f131856m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f131857n;

    public y1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof y1) == false) goto L34;
        y1 r101 = (y1) r100;
        if (Float.compare(this.f131844a, r101.f131844a) == 0) goto L8;
        return false;
    L8:
        if (this.f131845b == r101.f131845b) goto L10;
        return false;
    L10:
        if (Double.compare(this.f131846c, r101.f131846c) == 0) goto L12;
        return false;
    L12:
        if (this.f131847d == r101.f131847d) goto L14;
        return false;
    L14:
        if (Float.compare(this.f131848e, r101.f131848e) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.f131849f, r101.f131849f) == 0) goto L18;
        return false;
    L18:
        if (this.f131850g == r101.f131850g) goto L20;
        return false;
    L20:
        if (Float.compare(this.f131851h, r101.f131851h) == 0) goto L22;
        return false;
    L22:
        if (Float.compare(this.f131852i, r101.f131852i) == 0) goto L24;
        return false;
    L24:
        if (this.f131853j == r101.f131853j) goto L26;
        return false;
    L26:
        if (Float.compare(this.f131854k, r101.f131854k) == 0) goto L28;
        return false;
    L28:
        if (Float.compare(this.f131855l, r101.f131855l) == 0) goto L30;
        return false;
    L30:
        if (this.f131856m == r101.f131856m) goto L32;
        return false;
    L32:
        if (Float.compare(this.f131857n, r101.f131857n) == 0) goto L52;
        return false;
    L52:
        return true;
    L34:
        return false;
    }

    public final int hashCode() {
        int r100 = Float.floatToIntBits(this.f131844a) * 31;
        long r101 = this.f131845b;
        int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
        long r103 = Double.doubleToLongBits(this.f131846c);
        int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f131847d;
        int r106 = (((((r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31) + Float.floatToIntBits(this.f131848e)) * 31) + Float.floatToIntBits(this.f131849f)) * 31;
        long r107 = this.f131850g;
        int r108 = (((((r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31) + Float.floatToIntBits(this.f131851h)) * 31) + Float.floatToIntBits(this.f131852i)) * 31;
        long r109 = this.f131853j;
        int r110 = (((((r108 + ((int) (r109 ^ (r109 >>> 32)))) * 31) + Float.floatToIntBits(this.f131854k)) * 31) + Float.floatToIntBits(this.f131855l)) * 31;
        long r111 = this.f131856m;
        return ((r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31) + Float.floatToIntBits(this.f131857n);
    }

    public final String toString() {
        return "GiftPanelPerformanceData(fps=" + this.f131844a + ", monitorDuration=" + this.f131845b + ", stallUIRate=" + this.f131846c + ", stallUICount=" + this.f131847d + ", stallUIDuration=" + this.f131848e + ", minorDropRate=" + this.f131849f + ", minorDropCount=" + this.f131850g + ", minorDropDuration=" + this.f131851h + ", mediumDropRate=" + this.f131852i + ", mediumDropCount=" + this.f131853j + ", mediumDropDuration=" + this.f131854k + ", criticalDropRate=" + this.f131855l + ", criticalDropCount=" + this.f131856m + ", criticalDropDuration=" + this.f131857n + ")";
    }

    public y1(int r100) {
        this.f131844a = -1.0f;
        this.f131845b = -1;
        this.f131846c = -1.0d;
        this.f131847d = -1;
        this.f131848e = -1.0f;
        this.f131849f = -1.0f;
        this.f131850g = -1;
        this.f131851h = -1.0f;
        this.f131852i = -1.0f;
        this.f131853j = -1;
        this.f131854k = -1.0f;
        this.f131855l = -1.0f;
        this.f131856m = -1;
        this.f131857n = -1.0f;
    }
}
