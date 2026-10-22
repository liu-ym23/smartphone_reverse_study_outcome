package com.bytedance.android.live.incentive.exchange;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f69350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f69351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f69352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f69353d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f69354e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f69355f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L18;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f69350a, r101.f69350a) == true) goto L8;
        return false;
    L8:
        if (this.f69351b == r101.f69351b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f69352c, r101.f69352c) == true) goto L12;
        return false;
    L12:
        if (this.f69353d == r101.f69353d) goto L14;
        return false;
    L14:
        if (this.f69354e == r101.f69354e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f69355f, r101.f69355f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f69350a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f69351b) * 31;
        String r104 = this.f69352c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((((r103 + r105) * 31) + this.f69353d) * 31) + this.f69354e) * 31;
        String r107 = this.f69355f;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "IncomeExchangeResult(exchangeSessionId=" + this.f69350a + ", status=" + this.f69351b + ", exchangeType=" + this.f69352c + ", addedDiamonds=" + this.f69353d + ", errorCode=" + this.f69354e + ", errorMsg=" + this.f69355f + ")";
    }

    public f(String r100, int r101, String r102, int r103, int r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "exchangeSessionId");
        Intrinsics.checkNotNullParameter(r102, "exchangeType");
        Intrinsics.checkNotNullParameter(r105, "errorMsg");
        this.f69350a = r100;
        this.f69351b = r101;
        this.f69352c = r102;
        this.f69353d = r103;
        this.f69354e = r104;
        this.f69355f = r105;
    }
}
