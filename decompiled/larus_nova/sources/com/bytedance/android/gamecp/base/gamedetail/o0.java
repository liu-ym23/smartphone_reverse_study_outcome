package com.bytedance.android.gamecp.base.gamedetail;

/* JADX INFO: loaded from: classes44.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f51645a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f51646b;

    public o0() {
        int r100 = 0;
        this(r100, 3, r100);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o0) == false) goto L10;
        o0 r101 = (o0) r100;
        if (this.f51645a == r101.f51645a) goto L8;
        return false;
    L8:
        if (this.f51646b == r101.f51646b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.f51645a * 31) + this.f51646b;
    }

    public final String toString() {
        return "GameTabUIStyle(tabContentHeight=" + this.f51645a + ", alphaViewHeight=" + this.f51646b + ")";
    }

    public o0(int r100, int r101) {
        this.f51645a = r100;
        this.f51646b = r101;
    }

    public /* synthetic */ o0(int r100, int r101, int r102) {
        if ((r101 & 2) == 0) goto L5;
        r100 = 0;
    L5:
        this(0, r100);
    }
}
