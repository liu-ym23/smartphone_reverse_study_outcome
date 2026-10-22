package com.bytedance.android.live.revlink.impl.multianchor.ui;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f94796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f94797b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (this.f94796a == r101.f94796a) goto L8;
        return false;
    L8:
        if (this.f94797b == r101.f94797b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.f94796a * 31) + this.f94797b;
    }

    public final String toString() {
        return "FixParam(wholeHeight=" + this.f94796a + ", redBlueBarHeight=" + this.f94797b + ")";
    }

    public c(int r100, int r101) {
        this.f94796a = r100;
        this.f94797b = r101;
    }
}
