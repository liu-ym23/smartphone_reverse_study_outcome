package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.helper;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f127418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f127419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f127420c;

    public i() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L12;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f127418a, r101.f127418a) == true) goto L8;
        return false;
    L8:
        if (this.f127419b == r101.f127419b) goto L10;
        return false;
    L10:
        if (this.f127420c == r101.f127420c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f127418a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.f127419b;
        return (((r101 * 31) + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.f127420c;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "GiftExposureAnimFreqData(frequencyKey=" + this.f127418a + ", lastDate=" + this.f127419b + ", openTimes=" + this.f127420c + ")";
    }

    public i(int r100) {
        Intrinsics.checkNotNullParameter("", "frequencyKey");
        this.f127418a = "";
        this.f127419b = 0;
        this.f127420c = 0;
    }
}
