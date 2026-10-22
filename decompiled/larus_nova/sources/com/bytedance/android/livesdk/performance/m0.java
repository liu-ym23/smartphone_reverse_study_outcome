package com.bytedance.android.livesdk.performance;

/* JADX INFO: loaded from: classes11.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f154685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f154686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f154687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f154688d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m0) == false) goto L14;
        m0 r101 = (m0) r100;
        if (this.f154685a == r101.f154685a) goto L8;
        return false;
    L8:
        if (this.f154686b == r101.f154686b) goto L10;
        return false;
    L10:
        if (this.f154687c == r101.f154687c) goto L12;
        return false;
    L12:
        if (this.f154688d == r101.f154688d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r100 = ((((this.f154685a * 31) + this.f154686b) * 31) + this.f154687c) * 31;
        long r101 = this.f154688d;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "NetworkParams(tRtt=" + this.f154685a + ", hRtt=" + this.f154686b + ", delta=" + this.f154687c + ", time=" + this.f154688d + ")";
    }

    public m0(int r100, int r101, int r102, long r103) {
        this.f154685a = r100;
        this.f154686b = r101;
        this.f154687c = r102;
        this.f154688d = r103;
    }
}
