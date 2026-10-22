package com.bytedance.android.shopping.anchorv4.voavhs.blur;

/* JADX INFO: loaded from: classes13.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f168038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f168039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f168040c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f168041d;

    public d() {
        this(0, 0, 0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L14;
        d r101 = (d) r100;
        if (this.f168038a == r101.f168038a) goto L8;
        return false;
    L8:
        if (this.f168039b == r101.f168039b) goto L10;
        return false;
    L10:
        if (this.f168040c == r101.f168040c) goto L12;
        return false;
    L12:
        if (this.f168041d == r101.f168041d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f168038a * 31) + this.f168039b) * 31) + this.f168040c) * 31) + this.f168041d;
    }

    public final String toString() {
        return "BlurCropInsets(left=" + this.f168038a + ", top=" + this.f168039b + ", right=" + this.f168040c + ", bottom=" + this.f168041d + ")";
    }

    public d(int r100, int r101, int r102, int r103) {
        this.f168038a = r100;
        this.f168039b = r101;
        this.f168040c = r102;
        this.f168041d = r103;
    }
}
