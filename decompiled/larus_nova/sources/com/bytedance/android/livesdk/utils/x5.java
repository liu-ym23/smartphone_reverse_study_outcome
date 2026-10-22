package com.bytedance.android.livesdk.utils;

/* JADX INFO: loaded from: classes11.dex */
public final class x5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f159214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f159215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f159216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f159217d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x5) == false) goto L14;
        x5 r101 = (x5) r100;
        if (this.f159214a == r101.f159214a) goto L8;
        return false;
    L8:
        if (this.f159215b == r101.f159215b) goto L10;
        return false;
    L10:
        if (this.f159216c == r101.f159216c) goto L12;
        return false;
    L12:
        if (this.f159217d == r101.f159217d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.f159214a * 31) + this.f159215b) * 31) + this.f159216c) * 31) + this.f159217d;
    }

    public final String toString() {
        return "SafeArea(left=" + this.f159214a + ", top=" + this.f159215b + ", right=" + this.f159216c + ", bottom=" + this.f159217d + ")";
    }

    public x5(int r100, int r101, int r102, int r103) {
        this.f159214a = r100;
        this.f159215b = r101;
        this.f159216c = r102;
        this.f159217d = r103;
    }
}
