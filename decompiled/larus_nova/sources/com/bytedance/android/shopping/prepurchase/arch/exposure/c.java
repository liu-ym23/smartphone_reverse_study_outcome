package com.bytedance.android.shopping.prepurchase.arch.exposure;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f180887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f180888b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (this.f180887a == r101.f180887a) goto L8;
        return false;
    L8:
        if (this.f180888b == r101.f180888b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.f180887a * 31) + this.f180888b;
    }

    public final String toString() {
        return "ExposureInfo(totalArea=" + this.f180887a + ", impressionArea=" + this.f180888b + ")";
    }

    public c(int r100, int r101) {
        this.f180887a = r100;
        this.f180888b = r101;
    }
}
