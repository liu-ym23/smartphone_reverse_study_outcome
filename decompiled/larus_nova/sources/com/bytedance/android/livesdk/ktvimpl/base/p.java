package com.bytedance.android.livesdk.ktvimpl.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f143278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f143279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f143280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f143281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f143282e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f143283f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f143284g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f143285h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f143286i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f143287j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f143288k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f143289l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f143290m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f143291n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f143292o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f143293p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f143294q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f143295r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f143296s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f143297t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f143298u;

    public static final class a {
    }

    static {
    }

    public p() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L48;
        p r101 = (p) r100;
        if (Float.compare(this.f143278a, r101.f143278a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f143279b, r101.f143279b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f143280c, r101.f143280c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f143281d, r101.f143281d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.f143282e, r101.f143282e) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.f143283f, r101.f143283f) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.f143284g, r101.f143284g) == 0) goto L20;
        return false;
    L20:
        if (Float.compare(this.f143285h, r101.f143285h) == 0) goto L22;
        return false;
    L22:
        if (Float.compare(this.f143286i, r101.f143286i) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.f143287j, r101.f143287j) == 0) goto L26;
        return false;
    L26:
        if (Float.compare(this.f143288k, r101.f143288k) == 0) goto L28;
        return false;
    L28:
        if (this.f143289l == r101.f143289l) goto L30;
        return false;
    L30:
        if (this.f143290m == r101.f143290m) goto L32;
        return false;
    L32:
        if (Float.compare(this.f143291n, r101.f143291n) == 0) goto L34;
        return false;
    L34:
        if (Float.compare(this.f143292o, r101.f143292o) == 0) goto L36;
        return false;
    L36:
        if (Float.compare(this.f143293p, r101.f143293p) == 0) goto L38;
        return false;
    L38:
        if (Float.compare(this.f143294q, r101.f143294q) == 0) goto L40;
        return false;
    L40:
        if (Float.compare(this.f143295r, r101.f143295r) == 0) goto L42;
        return false;
    L42:
        if (Float.compare(this.f143296s, r101.f143296s) == 0) goto L44;
        return false;
    L44:
        if (Float.compare(this.f143297t, r101.f143297t) == 0) goto L46;
        return false;
    L46:
        if (Float.compare(this.f143298u, r101.f143298u) == 0) goto L73;
        return false;
    L73:
        return true;
    L48:
        return false;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((((((((((Float.floatToIntBits(this.f143278a) * 31) + Float.floatToIntBits(this.f143279b)) * 31) + Float.floatToIntBits(this.f143280c)) * 31) + Float.floatToIntBits(this.f143281d)) * 31) + Float.floatToIntBits(this.f143282e)) * 31) + Float.floatToIntBits(this.f143283f)) * 31) + Float.floatToIntBits(this.f143284g)) * 31) + Float.floatToIntBits(this.f143285h)) * 31) + Float.floatToIntBits(this.f143286i)) * 31) + Float.floatToIntBits(this.f143287j)) * 31) + Float.floatToIntBits(this.f143288k)) * 31) + this.f143289l) * 31;
        long r101 = this.f143290m;
        return ((((((((((((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + Float.floatToIntBits(this.f143291n)) * 31) + Float.floatToIntBits(this.f143292o)) * 31) + Float.floatToIntBits(this.f143293p)) * 31) + Float.floatToIntBits(this.f143294q)) * 31) + Float.floatToIntBits(this.f143295r)) * 31) + Float.floatToIntBits(this.f143296s)) * 31) + Float.floatToIntBits(this.f143297t)) * 31) + Float.floatToIntBits(this.f143298u);
    }

    public final String toString() {
        return "RealTimeInfoModel(pitchSentenceScore=" + this.f143278a + ", pitchSongScore=" + this.f143279b + ", userPitch1=" + this.f143280c + ", userPitch2=" + this.f143281d + ", reserved4=" + this.f143282e + ", reserved5=" + this.f143283f + ", reserved6=" + this.f143284g + ", refPitch1=" + this.f143285h + ", refPitch2=" + this.f143286i + ", reserved9=" + this.f143287j + ", reserved10=" + this.f143288k + ", sentenceId=" + this.f143289l + ", currentPositionMs=" + this.f143290m + ", emotionSentenceScore=" + this.f143291n + ", emotionSongScore=" + this.f143292o + ", rhythmSentenceScore=" + this.f143293p + ", rhythmSongScore=" + this.f143294q + ", breathSentenceScore=" + this.f143295r + ", breathSongScore=" + this.f143296s + ", vibratoSentenceScore=" + this.f143297t + ", vibratoSongScore=" + this.f143298u + ')';
    }

    public p(int r100) {
        this.f143278a = 0.0f;
        this.f143279b = 0.0f;
        this.f143280c = 0.0f;
        this.f143281d = 0.0f;
        this.f143282e = 0.0f;
        this.f143283f = 0.0f;
        this.f143284g = 0.0f;
        this.f143285h = 0.0f;
        this.f143286i = 0.0f;
        this.f143287j = 0.0f;
        this.f143288k = 0.0f;
        this.f143289l = 0;
        this.f143290m = 0;
        this.f143291n = 0.0f;
        this.f143292o = 0.0f;
        this.f143293p = 0.0f;
        this.f143294q = 0.0f;
        this.f143295r = 0.0f;
        this.f143296s = 0.0f;
        this.f143297t = 0.0f;
        this.f143298u = 0.0f;
    }

    public final void a(double[] r100) {
        Intrinsics.checkNotNullParameter(r100, "scoreInfo");
        this.f143278a = (float) r100[0];
        this.f143279b = (float) r100[1];
        this.f143280c = (float) r100[2];
        this.f143281d = (float) r100[3];
        this.f143282e = (float) r100[4];
        this.f143283f = (float) r100[5];
        this.f143284g = (float) r100[6];
        this.f143285h = (float) r100[7];
        this.f143286i = (float) r100[8];
        this.f143287j = (float) r100[9];
        this.f143288k = (float) r100[10];
        this.f143289l = (int) r100[11];
        this.f143290m = (long) r100[12];
        this.f143291n = (float) r100[13];
        this.f143292o = (float) r100[14];
        this.f143293p = (float) r100[15];
        this.f143294q = (float) r100[16];
        this.f143295r = (float) r100[17];
        this.f143296s = (float) r100[18];
        this.f143297t = (float) r100[19];
        this.f143298u = (float) r100[20];
    }
}
