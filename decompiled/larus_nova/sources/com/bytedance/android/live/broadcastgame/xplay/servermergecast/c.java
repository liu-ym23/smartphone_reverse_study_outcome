package com.bytedance.android.live.broadcastgame.xplay.servermergecast;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f62405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f62406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f62407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f62408d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f62409e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f62410f;

    public c() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L18;
        c r101 = (c) r100;
        if (Float.compare(this.f62405a, r101.f62405a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f62406b, r101.f62406b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f62407c, r101.f62407c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f62408d, r101.f62408d) == 0) goto L14;
        return false;
    L14:
        if (this.f62409e == r101.f62409e) goto L16;
        return false;
    L16:
        if (this.f62410f == r101.f62410f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        int r100 = ((((((((Float.floatToIntBits(this.f62405a) * 31) + Float.floatToIntBits(this.f62406b)) * 31) + Float.floatToIntBits(this.f62407c)) * 31) + Float.floatToIntBits(this.f62408d)) * 31) + this.f62409e) * 31;
        long r101 = this.f62410f;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "LittleWindowMixerParams(left=" + this.f62405a + ", top=" + this.f62406b + ", right=" + this.f62407c + ", bottom=" + this.f62408d + ", zOrder=" + this.f62409e + ", flags=" + this.f62410f + ")";
    }

    public /* synthetic */ c(int r100) {
        this(0.0f, 0.0f, 1.0f, 1.0f, 0, 1);
    }

    public c(float r100, float r101, float r102, float r103, int r104, long r105) {
        this.f62405a = r100;
        this.f62406b = r101;
        this.f62407c = r102;
        this.f62408d = r103;
        this.f62409e = r104;
        this.f62410f = r105;
    }
}
