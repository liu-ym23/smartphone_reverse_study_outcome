package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class l2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f131629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f131630b;

    public l2() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l2) == false) goto L10;
        l2 r101 = (l2) r100;
        if (Intrinsics.areEqual(this.f131629a, r101.f131629a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f131630b, r101.f131630b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.f131629a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f131630b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "GiftShowInfo(showTimes=" + this.f131629a + ", showTimesInFirstScreen=" + this.f131630b + ")";
    }

    public l2(int r100) {
        this.f131629a = null;
        this.f131630b = null;
    }
}
