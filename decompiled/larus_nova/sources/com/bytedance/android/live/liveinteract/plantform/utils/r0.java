package com.bytedance.android.live.liveinteract.plantform.utils;

/* JADX INFO: loaded from: classes46.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f77532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f77533b;

    public r0() {
        this(0, 0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r0) == false) goto L10;
        r0 r101 = (r0) r100;
        if (this.f77532a == r101.f77532a) goto L8;
        return false;
    L8:
        if (this.f77533b == r101.f77533b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.f77532a * 31) + this.f77533b;
    }

    public final String toString() {
        return "SwitchSceneSourceMapKey(scene=" + this.f77532a + ", layout=" + this.f77533b + ")";
    }

    public r0(int r100, int r101) {
        this.f77532a = r100;
        this.f77533b = r101;
    }
}
