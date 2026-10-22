package com.bytedance.android.live.profit.profitCheck;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f88478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f88479b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f88478a, r101.f88478a) == true) goto L8;
        return false;
    L8:
        if (this.f88479b == r101.f88479b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f88478a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.f88479b;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "ProfitType(eventName=" + this.f88478a + ", profitType=" + this.f88479b + ")";
    }

    public d(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.f88478a = r100;
        this.f88479b = r101;
    }
}
