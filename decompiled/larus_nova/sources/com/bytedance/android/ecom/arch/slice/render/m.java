package com.bytedance.android.ecom.arch.slice.render;

/* JADX INFO: loaded from: classes44.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f50680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f50681b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L10;
        m r101 = (m) r100;
        if (this.f50680a == r101.f50680a) goto L8;
        return false;
    L8:
        if (this.f50681b == r101.f50681b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.f50680a * 31) + this.f50681b;
    }

    public final String toString() {
        return "SlcSize(width=" + this.f50680a + ", height=" + this.f50681b + ")";
    }

    public m(int r100, int r101) {
        this.f50680a = r100;
        this.f50681b = r101;
    }
}
