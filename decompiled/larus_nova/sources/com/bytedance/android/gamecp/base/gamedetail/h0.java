package com.bytedance.android.gamecp.base.gamedetail;

/* JADX INFO: loaded from: classes44.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f51583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f51584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f51585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f51586d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f51587e;

    public h0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h0) == false) goto L16;
        h0 r101 = (h0) r100;
        if (this.f51583a == r101.f51583a) goto L8;
        return false;
    L8:
        if (this.f51584b == r101.f51584b) goto L10;
        return false;
    L10:
        if (this.f51585c == r101.f51585c) goto L12;
        return false;
    L12:
        if (this.f51586d == r101.f51586d) goto L14;
        return false;
    L14:
        if (this.f51587e == r101.f51587e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f51583a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f51584b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f51585c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f51586d;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f51587e;
        return r107 + ((int) (r108 ^ (r108 >>> 32)));
    }

    public final String toString() {
        return "FmpWidgetTraceBean(createPropsTime=" + this.f51583a + ", createWidgetTime=" + this.f51584b + ", inflateTime=" + this.f51585c + ", mountTime=" + this.f51586d + ", updateTime=" + this.f51587e + ")";
    }

    public h0(int r100) {
        this.f51583a = 0;
        this.f51584b = 0;
        this.f51585c = 0;
        this.f51586d = 0;
        this.f51587e = 0;
    }
}
