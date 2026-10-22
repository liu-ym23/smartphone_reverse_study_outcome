package com.bytedance.android.live.revlink.impl.multianchor.ui;

/* JADX INFO: loaded from: classes47.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f94798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f94799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f94800c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L12;
        e r101 = (e) r100;
        if (this.f94798a == r101.f94798a) goto L8;
        return false;
    L8:
        if (this.f94799b == r101.f94799b) goto L10;
        return false;
    L10:
        if (this.f94800c == r101.f94800c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        return (((this.f94798a * 31) + this.f94799b) * 31) + this.f94800c;
    }

    public final String toString() {
        return "FloatOffsetFromBaseLine(wholeHeight=" + this.f94798a + ", redBlueBarHeight=" + this.f94799b + ", floatDistanceFromBase=" + this.f94800c + ")";
    }

    public e(int r100, int r101, int r102) {
        this.f94798a = r100;
        this.f94799b = r101;
        this.f94800c = r102;
    }
}
