package com.bytedance.android.livesdk.interactivity.service.monitor;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f140933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f140934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f140935c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f140933a, r101.f140933a) == true) goto L8;
        return false;
    L8:
        if (this.f140934b == r101.f140934b) goto L10;
        return false;
    L10:
        if (this.f140935c == r101.f140935c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f140933a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.f140934b;
        int r103 = ((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        long r104 = this.f140935c;
        return r103 + ((int) (r104 ^ (r104 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "AvgIndicator(indicatorName=" + this.f140933a + ", numerator=" + this.f140934b + ", denominator=" + this.f140935c + ")";
    }

    public a(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "indicatorName");
        this.f140933a = r100;
        this.f140934b = r101;
        this.f140935c = 1;
    }
}
