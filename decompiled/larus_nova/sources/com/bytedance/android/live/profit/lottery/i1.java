package com.bytedance.android.live.profit.lottery;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f88112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f88113b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i1) == false) goto L10;
        i1 r101 = (i1) r100;
        if (Intrinsics.areEqual(this.f88112a, r101.f88112a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f88113b, r101.f88113b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f88112a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f88113b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LotteryRejectInfo(rulePageScheme=" + this.f88112a + ", reason=" + this.f88113b + ")";
    }

    public i1(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "rulePageScheme");
        Intrinsics.checkNotNullParameter(r101, "reason");
        this.f88112a = r100;
        this.f88113b = r101;
    }
}
