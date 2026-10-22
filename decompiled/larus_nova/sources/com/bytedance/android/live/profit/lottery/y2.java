package com.bytedance.android.live.profit.lottery;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class y2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f88251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f88252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f88253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f88254d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f88255e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f88256f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f88257g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f88258h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f88259i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f88260j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f88261k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f88262l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f88263m;

    public y2() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof y2) == false) goto L32;
        y2 r101 = (y2) r100;
        if (this.f88251a == r101.f88251a) goto L8;
        return false;
    L8:
        if (this.f88252b == r101.f88252b) goto L10;
        return false;
    L10:
        if (this.f88253c == r101.f88253c) goto L12;
        return false;
    L12:
        if (this.f88254d == r101.f88254d) goto L14;
        return false;
    L14:
        if (this.f88255e == r101.f88255e) goto L16;
        return false;
    L16:
        if (this.f88256f == r101.f88256f) goto L18;
        return false;
    L18:
        if (this.f88257g == r101.f88257g) goto L20;
        return false;
    L20:
        if (this.f88258h == r101.f88258h) goto L22;
        return false;
    L22:
        if (this.f88259i == r101.f88259i) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f88260j, r101.f88260j) == true) goto L26;
        return false;
    L26:
        if (this.f88261k == r101.f88261k) goto L28;
        return false;
    L28:
        if (this.f88262l == r101.f88262l) goto L30;
        return false;
    L30:
        if (this.f88263m == r101.f88263m) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r1v20, types: [int] */
    public final int hashCode() {
        long r100 = this.f88251a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f88252b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f88253c;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f88254d;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f88255e;
        int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
        long r110 = this.f88256f;
        int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
        long r112 = this.f88257g;
        int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
        long r114 = this.f88258h;
        int r115 = (r113 + ((int) (r114 ^ (r114 >>> 32)))) * 31;
        long r116 = this.f88259i;
        int r117 = (r115 + ((int) (r116 ^ (r116 >>> 32)))) * 31;
        String r118 = this.f88260j;
        if (r118 == null) goto L5;
        int r119 = r118.hashCode();
    L6:
        int r120 = (r117 + r119) * 31;
        boolean r121 = this.f88261k;
        ?? r122 = r121;
        if (r121 == false) goto L9;
        r122 = 1;
    L9:
        long r123 = this.f88262l;
        int r124 = (((r120 + r122) * 31) + ((int) (r123 ^ (r123 >>> 32)))) * 31;
        long r125 = this.f88263m;
        return r124 + ((int) (r125 ^ (r125 >>> 32)));
    L5:
        r119 = 0;
        goto L6
    }

    public final String toString() {
        return "LotteryTempStatusInfo(lotteryId=" + this.f88251a + ", lotteryType=" + this.f88252b + ", luckyCount=" + this.f88253c + ", prizeCount=" + this.f88254d + ", candidateTotalCount=" + this.f88255e + ", lastSurgeTimeStamp=" + this.f88256f + ", startTime=" + this.f88257g + ", drawTime=" + this.f88258h + ", enabledDilatation=" + this.f88259i + ", dilatationConfigDetail=" + this.f88260j + ", dilatationNow=" + this.f88261k + ", prizeCountBeforeDilatation=" + this.f88262l + ", luckyCountBeforeDilatation=" + this.f88263m + ")";
    }

    public /* synthetic */ y2(int r210) {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, "", false, 0, 0);
    }

    public y2(long r100, long r101, long r102, long r110, long r111, long r112, long r113, long r114, long r210, String r211, boolean r212, long r213, long r214) {
        Intrinsics.checkNotNullParameter(r211, "dilatationConfigDetail");
        this.f88251a = r100;
        this.f88252b = r101;
        this.f88253c = r102;
        this.f88254d = r110;
        this.f88255e = r111;
        this.f88256f = r112;
        this.f88257g = r113;
        this.f88258h = r114;
        this.f88259i = r210;
        this.f88260j = r211;
        this.f88261k = r212;
        this.f88262l = r213;
        this.f88263m = r214;
    }
}
