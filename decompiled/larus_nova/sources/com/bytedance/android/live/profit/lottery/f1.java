package com.bytedance.android.live.profit.lottery;

/* JADX INFO: loaded from: classes47.dex */
public final class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f88068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f88069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f88070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f88071d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f1) == false) goto L14;
        f1 r101 = (f1) r100;
        if (this.f88068a == r101.f88068a) goto L8;
        return false;
    L8:
        if (this.f88069b == r101.f88069b) goto L10;
        return false;
    L10:
        if (this.f88070c == r101.f88070c) goto L12;
        return false;
    L12:
        if (this.f88071d == r101.f88071d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public final int hashCode() {
        long r100 = this.f88068a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f88069b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        boolean r104 = this.f88070c;
        ?? r105 = r104;
        if (r104 == false) goto L5;
        r105 = 1;
    L5:
        long r106 = this.f88071d;
        return ((r103 + r105) * 31) + ((int) (r106 ^ (r106 >>> 32)));
    }

    public final String toString() {
        return "LotteryParticipateSuccessInfo(lotteryId=" + this.f88068a + ", candidateUid=" + this.f88069b + ", isParticipated=" + this.f88070c + ", version=" + this.f88071d + ")";
    }

    public f1(long r100, long r101, boolean r102, long r103) {
        this.f88068a = r100;
        this.f88069b = r101;
        this.f88070c = r102;
        this.f88071d = r103;
    }
}
