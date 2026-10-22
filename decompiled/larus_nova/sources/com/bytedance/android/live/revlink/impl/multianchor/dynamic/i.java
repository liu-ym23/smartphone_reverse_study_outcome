package com.bytedance.android.live.revlink.impl.multianchor.dynamic;

/* JADX INFO: loaded from: classes47.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f94082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f94083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f94084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f94085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f94086e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L16;
        i r101 = (i) r100;
        if (this.f94082a == r101.f94082a) goto L8;
        return false;
    L8:
        if (this.f94083b == r101.f94083b) goto L10;
        return false;
    L10:
        if (this.f94084c == r101.f94084c) goto L12;
        return false;
    L12:
        if (this.f94085d == r101.f94085d) goto L14;
        return false;
    L14:
        if (this.f94086e == r101.f94086e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        return (((((((this.f94082a * 31) + this.f94083b) * 31) + this.f94084c) * 31) + this.f94085d) * 31) + this.f94086e;
    }

    public final String toString() {
        return "LynxLayout(widthPx=" + this.f94082a + ", heightPx=" + this.f94083b + ", leftMarginPx=" + this.f94084c + ", topMarginPx=" + this.f94085d + ", zOrder=" + this.f94086e + ")";
    }

    public /* synthetic */ i(int r100, int r101, int r102, int r110) {
        this(r100, r101, r102, r110, 0);
    }

    public i(int r100, int r101, int r102, int r103, int r104) {
        this.f94082a = r100;
        this.f94083b = r101;
        this.f94084c = r102;
        this.f94085d = r103;
        this.f94086e = r104;
    }
}
