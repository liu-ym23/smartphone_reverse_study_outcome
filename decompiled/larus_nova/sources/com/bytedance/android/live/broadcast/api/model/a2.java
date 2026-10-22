package com.bytedance.android.live.broadcast.api.model;

/* JADX INFO: loaded from: classes45.dex */
public final class a2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f59026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f59027b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a2) == false) goto L10;
        a2 r101 = (a2) r100;
        if (Float.compare(this.f59026a, r101.f59026a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f59027b, r101.f59027b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f59026a) * 31) + Float.floatToIntBits(this.f59027b);
    }

    public final String toString() {
        return "ZoomRange(upper=" + this.f59026a + ", lower=" + this.f59027b + ")";
    }

    public a2(float r100, float r101) {
        this.f59026a = r100;
        this.f59027b = r101;
    }
}
