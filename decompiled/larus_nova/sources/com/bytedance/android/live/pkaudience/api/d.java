package com.bytedance.android.live.pkaudience.api;

/* JADX INFO: loaded from: classes46.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f85422a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f85423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f85424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f85425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f85426e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L16;
        d r101 = (d) r100;
        if (this.f85422a == r101.f85422a) goto L8;
        return false;
    L8:
        if (this.f85423b == r101.f85423b) goto L10;
        return false;
    L10:
        if (this.f85424c == r101.f85424c) goto L12;
        return false;
    L12:
        if (this.f85425d == r101.f85425d) goto L14;
        return false;
    L14:
        if (this.f85426e == r101.f85426e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    public final int hashCode() {
        boolean r100 = this.f85422a;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        long r103 = this.f85423b;
        int r104 = ((r102 * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
        long r105 = this.f85424c;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        boolean r107 = this.f85425d;
        if (r107 == true) goto L9;
        r101 = r107;
    L9:
        int r108 = (r106 + r101) * 31;
        long r109 = this.f85426e;
        return r108 + ((int) (r109 ^ (r109 >>> 32)));
    }

    public final String toString() {
        return "PkAudienceLogData(hasAudienceJoin4Pk=" + this.f85422a + ", hasAudienceOnlineTime4Pk=" + this.f85423b + ", hasAudienceOnlineTime=" + this.f85424c + ", hasAudienceJoin4Penalty=" + this.f85425d + ", hasAudienceOnlineTime4Penalty=" + this.f85426e + ")";
    }

    public d(boolean r100, long r101, long r102, boolean r103, long r104) {
        this.f85422a = r100;
        this.f85423b = r101;
        this.f85424c = r102;
        this.f85425d = r103;
        this.f85426e = r104;
    }
}
