package com.bytedance.android.live.broadcast.api.model;

/* JADX INFO: loaded from: classes45.dex */
public final class y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f59046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f59047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f59048c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof y1) == false) goto L12;
        y1 r101 = (y1) r100;
        if (Float.compare(this.f59046a, r101.f59046a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f59047b, r101.f59047b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f59048c, r101.f59048c) == 0) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((Float.floatToIntBits(this.f59046a) * 31) + Float.floatToIntBits(this.f59047b)) * 31) + Float.floatToIntBits(this.f59048c);
    }

    public final String toString() {
        return "ZoomModel(frontRatio=" + this.f59046a + ", backRatio=" + this.f59047b + ", updateValue=" + this.f59048c + ")";
    }

    public /* synthetic */ y1() {
        this(1.0f);
    }

    public y1(float r100) {
        this.f59046a = 1.0f;
        this.f59047b = 1.0f;
        this.f59048c = r100;
    }
}
