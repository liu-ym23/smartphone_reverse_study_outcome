package com.bytedance.android.live.broadcastgame.xplay;

/* JADX INFO: loaded from: classes45.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f62186a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f62187b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L10;
        j r101 = (j) r100;
        if (this.f62186a == r101.f62186a) goto L8;
        return false;
    L8:
        if (this.f62187b == r101.f62187b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.f62186a * 31) + this.f62187b;
    }

    public final String toString() {
        return "Size(width=" + this.f62186a + ", height=" + this.f62187b + ")";
    }

    public j(int r100, int r101) {
        this.f62186a = r100;
        this.f62187b = r101;
    }
}
