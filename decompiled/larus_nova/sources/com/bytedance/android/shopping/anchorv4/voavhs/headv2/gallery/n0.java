package com.bytedance.android.shopping.anchorv4.voavhs.headv2.gallery;

/* JADX INFO: loaded from: classes13.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f169348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f169349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f169350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f169351d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n0) == false) goto L14;
        n0 r101 = (n0) r100;
        if (Float.compare(this.f169348a, r101.f169348a) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f169349b, r101.f169349b) == 0) goto L10;
        return false;
    L10:
        if (Float.compare(this.f169350c, r101.f169350c) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.f169351d, r101.f169351d) == 0) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((Float.floatToIntBits(this.f169348a) * 31) + Float.floatToIntBits(this.f169349b)) * 31) + Float.floatToIntBits(this.f169350c)) * 31) + Float.floatToIntBits(this.f169351d);
    }

    public final String toString() {
        return "MarginModel(top=" + this.f169348a + ", bottom=" + this.f169349b + ", left=" + this.f169350c + ", right=" + this.f169351d + ")";
    }

    public n0(float r100, float r101, float r102, float r103) {
        this.f169348a = r100;
        this.f169349b = r101;
        this.f169350c = r102;
        this.f169351d = r103;
    }
}
