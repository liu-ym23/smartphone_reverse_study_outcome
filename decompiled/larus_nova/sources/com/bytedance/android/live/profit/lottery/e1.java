package com.bytedance.android.live.profit.lottery;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f88062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f88063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f88064c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e1) == false) goto L12;
        e1 r101 = (e1) r100;
        if (this.f88062a == r101.f88062a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f88063b, r101.f88063b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f88064c, r101.f88064c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        long r100 = this.f88062a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        List<String> r102 = this.f88063b;
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.hashCode();
    L6:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f88064c;
        if (r106 == null) goto L10;
        r103 = r106.hashCode();
    L10:
        return r105 + r103;
    L5:
        r104 = 0;
        goto L6
    }

    public final String toString() {
        return "LotteryNewDrawResult(lotteryId=" + this.f88062a + ", luckyUserIds=" + this.f88063b + ", extra=" + this.f88064c + ")";
    }

    public e1(long r100, List<String> r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "luckyUserIds");
        Intrinsics.checkNotNullParameter(r102, "extra");
        this.f88062a = r100;
        this.f88063b = r101;
        this.f88064c = r102;
    }
}
