package com.bytedance.android.live.revlink.impl.multianchor.utils;

/* JADX INFO: loaded from: classes47.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f94949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f94950b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L10;
        o r101 = (o) r100;
        if (this.f94949a == r101.f94949a) goto L8;
        return false;
    L8:
        if (this.f94950b == r101.f94950b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.f94949a * 31) + this.f94950b;
    }

    public final String toString() {
        return "LinkTypeParams(matchType=" + this.f94949a + ", inviteType=" + this.f94950b + ")";
    }

    public o(int r100, int r101) {
        this.f94949a = r100;
        this.f94950b = r101;
    }
}
