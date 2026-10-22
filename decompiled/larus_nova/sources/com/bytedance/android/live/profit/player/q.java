package com.bytedance.android.live.profit.player;

/* JADX INFO: loaded from: classes47.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f88355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f88356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f88357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f88358d;

    public q() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == false) goto L14;
        q r101 = (q) r100;
        if (this.f88355a == r101.f88355a) goto L8;
        return false;
    L8:
        if (this.f88356b == r101.f88356b) goto L10;
        return false;
    L10:
        if (this.f88357c == r101.f88357c) goto L12;
        return false;
    L12:
        if (this.f88358d == r101.f88358d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f88355a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f88356b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f88357c;
        return ((r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31) + this.f88358d;
    }

    public final String toString() {
        return "PlayMetrics(playStartTs=" + this.f88355a + ", lynxInitEndTs=" + this.f88356b + ", lynxLoadedTs=" + this.f88357c + ", playTimes=" + this.f88358d + ")";
    }

    public q(int r100) {
        this.f88355a = 0;
        this.f88356b = 0;
        this.f88357c = 0;
        this.f88358d = 1;
    }
}
