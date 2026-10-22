package com.bytedance.android.live.broadcastgame.opengame.openapi;

/* JADX INFO: loaded from: classes45.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f60530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f60531b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L10;
        p r101 = (p) r100;
        if (this.f60530a == r101.f60530a) goto L8;
        return false;
    L8:
        if (this.f60531b == r101.f60531b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.f60530a * 31) + this.f60531b;
    }

    public final String toString() {
        return "FrequencyLimit(maxTimes=" + this.f60530a + ", unitTime=" + this.f60531b + ")";
    }

    public p(int r100, int r101) {
        this.f60530a = r100;
        this.f60531b = r101;
    }
}
