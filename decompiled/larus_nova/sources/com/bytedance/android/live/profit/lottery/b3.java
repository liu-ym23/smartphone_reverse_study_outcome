package com.bytedance.android.live.profit.lottery;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f88045a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f88046b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f88047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f88048d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f88049e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f88050f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f88051g;

    public b3() {
        this(null, null, null, null, null, null, 127);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b3) == false) goto L20;
        b3 r101 = (b3) r100;
        if (Intrinsics.areEqual(this.f88045a, r101.f88045a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f88046b, r101.f88046b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f88047c, r101.f88047c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f88048d, r101.f88048d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f88049e, r101.f88049e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f88050f, r101.f88050f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f88051g, r101.f88051g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f88045a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f88046b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f88047c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f88048d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f88049e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f88050f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f88051g;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LotteryUriConfig(anchorLotteryCreateUri=" + this.f88045a + ", anchorLotteryDetailUri=" + this.f88046b + ", anchorLotteryResultlUri=" + this.f88047c + ", audienceLotteryWaitUri=" + this.f88048d + ", audienceLotteryResultUri=" + this.f88049e + ", lotteryAudienceResultWin=" + this.f88050f + ", lotteryAudienceResultFail=" + this.f88051g + ")";
    }

    public b3(String r100, String r101, String r102, String r103, String r104, String r105, int r110) {
        if ((r110 & 1) == 0) goto L5;
        String r106 = "";
    L7:
        if ((r110 & 2) == 0) goto L10;
        r100 = "";
    L10:
        if ((r110 & 4) == 0) goto L13;
        r101 = "";
    L13:
        if ((r110 & 8) == 0) goto L16;
        r102 = "";
    L16:
        if ((r110 & 16) == 0) goto L19;
        r103 = "";
    L19:
        if ((r110 & 32) == 0) goto L22;
        r104 = "";
    L22:
        if ((r110 & 64) == 0) goto L24;
        r105 = "";
    L24:
        Intrinsics.checkNotNullParameter(r106, "anchorLotteryCreateUri");
        Intrinsics.checkNotNullParameter(r100, "anchorLotteryDetailUri");
        Intrinsics.checkNotNullParameter(r101, "anchorLotteryResultlUri");
        Intrinsics.checkNotNullParameter(r102, "audienceLotteryWaitUri");
        Intrinsics.checkNotNullParameter(r103, "audienceLotteryResultUri");
        Intrinsics.checkNotNullParameter(r104, "lotteryAudienceResultWin");
        Intrinsics.checkNotNullParameter(r105, "lotteryAudienceResultFail");
        this.f88045a = r106;
        this.f88046b = r100;
        this.f88047c = r101;
        this.f88048d = r102;
        this.f88049e = r103;
        this.f88050f = r104;
        this.f88051g = r105;
        return;
    L5:
        r106 = null;
        goto L7
    }
}
