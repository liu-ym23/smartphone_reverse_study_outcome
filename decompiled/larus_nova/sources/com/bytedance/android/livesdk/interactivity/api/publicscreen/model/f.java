package com.bytedance.android.livesdk.interactivity.api.publicscreen.model;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f133488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f133489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f133490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f133491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f133492e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f133493f;

    public f() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L18;
        f r101 = (f) r100;
        if (this.f133488a == r101.f133488a) goto L8;
        return false;
    L8:
        if (this.f133489b == r101.f133489b) goto L10;
        return false;
    L10:
        if (Float.compare(this.f133490c, r101.f133490c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f133491d, r101.f133491d) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.f133492e, r101.f133492e) == 0) goto L16;
        return false;
    L16:
        if (Float.compare(this.f133493f, r101.f133493f) == 0) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        return (((((((((this.f133488a * 31) + this.f133489b) * 31) + Float.floatToIntBits(this.f133490c)) * 31) + Float.floatToIntBits(this.f133491d)) * 31) + Float.floatToIntBits(this.f133492e)) * 31) + Float.floatToIntBits(this.f133493f);
    }

    public final String toString() {
        return "PublicScreenWaitMessageState(size=" + this.f133488a + ", commentSize=" + this.f133489b + ", commentHotRate=" + this.f133490c + ", commentFansRate=" + this.f133491d + ", commentLongRate=" + this.f133492e + ", commentMeanLength=" + this.f133493f + ")";
    }

    public /* synthetic */ f(int r100) {
        this(0, 0, 0.0f, 0.0f, 0.0f, 0.0f);
    }

    public f(int r100, int r101, float r102, float r103, float r104, float r105) {
        this.f133488a = r100;
        this.f133489b = r101;
        this.f133490c = r102;
        this.f133491d = r103;
        this.f133492e = r104;
        this.f133493f = r105;
    }
}
