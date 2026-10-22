package com.bytedance.android.live.profit.lottery;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f88194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f88195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f88196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f88197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f88198e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f88199f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<Integer> f88200g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f88201h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f88202i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f88203j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final c f88204k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t) == false) goto L28;
        t r101 = (t) r100;
        if (this.f88194a == r101.f88194a) goto L8;
        return false;
    L8:
        if (this.f88195b == r101.f88195b) goto L10;
        return false;
    L10:
        if (this.f88196c == r101.f88196c) goto L12;
        return false;
    L12:
        if (this.f88197d == r101.f88197d) goto L14;
        return false;
    L14:
        if (this.f88198e == r101.f88198e) goto L16;
        return false;
    L16:
        if (this.f88199f == r101.f88199f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f88200g, r101.f88200g) == true) goto L20;
        return false;
    L20:
        if (this.f88201h == r101.f88201h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f88202i, r101.f88202i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f88203j, r101.f88203j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f88204k, r101.f88204k) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    public final int hashCode() {
        long r100 = this.f88194a;
        int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f88195b) * 31;
        long r102 = this.f88196c;
        int r103 = (((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f88197d) * 31;
        long r104 = this.f88198e;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        long r106 = this.f88199f;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        List<Integer> r108 = this.f88200g;
        int r109 = 0;
        if (r108 == null) goto L5;
        int r110 = r108.hashCode();
    L6:
        int r111 = (r107 + r110) * 31;
        boolean r112 = this.f88201h;
        ?? r113 = r112;
        if (r112 == false) goto L9;
        r113 = 1;
    L9:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f88202i;
        if (r115 == null) goto L12;
        int r116 = r115.hashCode();
    L13:
        int r117 = (r114 + r116) * 31;
        String r118 = this.f88203j;
        if (r118 == null) goto L16;
        int r119 = r118.hashCode();
    L17:
        int r120 = (r117 + r119) * 31;
        c r121 = this.f88204k;
        if (r121 == null) goto L21;
        r109 = r121.hashCode();
    L21:
        return r120 + r109;
    L16:
        r119 = 0;
        goto L17
    L12:
        r116 = 0;
        goto L13
    L5:
        r110 = 0;
        goto L6
    }

    public final String toString() {
        return "LocalLotteryInfo(lotteryId=" + this.f88194a + ", status=" + this.f88195b + ", localDrawTime=" + this.f88196c + ", prizeType=" + this.f88197d + ", prizeCount=" + this.f88198e + ", maxRandomDelayDurationByMs=" + this.f88199f + ", conditionTypes=" + this.f88200g + ", useNewDrawInteraction=" + this.f88201h + ", serverBizData=" + this.f88202i + ", uiConfig=" + this.f88203j + ", extra=" + this.f88204k + ")";
    }

    public t(long r100, int r101, long r102, int r110, long r111, long r112, List<Integer> r113, boolean r114, String r115, String r116, c r117) {
        Intrinsics.checkNotNullParameter(r113, "conditionTypes");
        this.f88194a = r100;
        this.f88195b = r101;
        this.f88196c = r102;
        this.f88197d = r110;
        this.f88198e = r111;
        this.f88199f = r112;
        this.f88200g = r113;
        this.f88201h = r114;
        this.f88202i = r115;
        this.f88203j = r116;
        this.f88204k = r117;
    }
}
