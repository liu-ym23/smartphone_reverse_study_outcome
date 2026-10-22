package com.bytedance.android.livesdk.interactivity.api.publicscreen.viewpager;

/* JADX INFO: loaded from: classes9.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f133712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f133713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f133714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f133715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f133716e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L16;
        j r101 = (j) r100;
        if (this.f133712a == r101.f133712a) goto L8;
        return false;
    L8:
        if (this.f133713b == r101.f133713b) goto L10;
        return false;
    L10:
        if (this.f133714c == r101.f133714c) goto L12;
        return false;
    L12:
        if (this.f133715d == r101.f133715d) goto L14;
        return false;
    L14:
        if (this.f133716e == r101.f133716e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public final int hashCode() {
        long r100 = this.f133712a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f133713b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        boolean r104 = this.f133714c;
        ?? r105 = r104;
        if (r104 == false) goto L5;
        r105 = 1;
    L5:
        long r106 = this.f133715d;
        int r107 = (((r103 + r105) * 31) + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f133716e;
        return r107 + ((int) (r108 ^ (r108 >>> 32)));
    }

    public final String toString() {
        return "RedDotTrigger(channelId=" + this.f133712a + ", createType=" + this.f133713b + ", isOwner=" + this.f133714c + ", subCreateType=" + this.f133715d + ", createAppId=" + this.f133716e + ")";
    }

    public j(long r100, long r101, boolean r102, long r103, long r104) {
        this.f133712a = r100;
        this.f133713b = r101;
        this.f133714c = r102;
        this.f133715d = r103;
        this.f133716e = r104;
    }
}
