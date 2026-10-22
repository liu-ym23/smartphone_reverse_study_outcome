package com.bytedance.android.live.profit.lottery;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f88100a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f88101b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f88102c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f88103d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f88104e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f88105f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f88106g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ParticipateStatus f88107h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h1) == false) goto L22;
        h1 r101 = (h1) r100;
        if (this.f88100a == r101.f88100a) goto L8;
        return false;
    L8:
        if (this.f88101b == r101.f88101b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f88102c, r101.f88102c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f88103d, r101.f88103d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f88104e, r101.f88104e) == true) goto L16;
        return false;
    L16:
        if (this.f88105f == r101.f88105f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f88106g, r101.f88106g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f88107h, r101.f88107h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    public final int hashCode() {
        long r100 = this.f88100a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f88101b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        String r104 = this.f88102c;
        int r105 = 0;
        if (r104 == null) goto L5;
        int r106 = r104.hashCode();
    L6:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f88103d;
        if (r108 == null) goto L9;
        int r109 = r108.hashCode();
    L10:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f88104e;
        if (r111 == null) goto L13;
        int r112 = r111.hashCode();
    L14:
        int r113 = (r110 + r112) * 31;
        boolean r114 = this.f88105f;
        ?? r115 = r114;
        if (r114 == false) goto L17;
        r115 = 1;
    L17:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f88106g;
        if (r117 == null) goto L20;
        int r118 = r117.hashCode();
    L21:
        int r119 = (r116 + r118) * 31;
        ParticipateStatus r120 = this.f88107h;
        if (r120 == null) goto L25;
        r105 = r120.hashCode();
    L25:
        return r119 + r105;
    L20:
        r118 = 0;
        goto L21
    L13:
        r112 = 0;
        goto L14
    L9:
        r109 = 0;
        goto L10
    L5:
        r106 = 0;
        goto L6
    }

    public final String toString() {
        return "LotteryRefreshInfo(lotteryId=" + this.f88100a + ", lotteryType=" + this.f88101b + ", icon=" + this.f88102c + ", title=" + this.f88103d + ", schema=" + this.f88104e + ", isAnchor=" + this.f88105f + ", toast=" + this.f88106g + ", chooseLotteryStatus=" + this.f88107h + ")";
    }

    public h1(long r100, long r101, String r102, String r103, String r104, boolean r105, String r106, ParticipateStatus r110) {
        this.f88100a = r100;
        this.f88101b = r101;
        this.f88102c = r102;
        this.f88103d = r103;
        this.f88104e = r104;
        this.f88105f = r105;
        this.f88106g = r106;
        this.f88107h = r110;
    }
}
