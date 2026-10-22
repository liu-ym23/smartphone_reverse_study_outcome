package com.bytedance.android.livesdk.ktvimpl.base.sei;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f143341a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f143342b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u) == false) goto L10;
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f143341a, r101.f143341a) == true) goto L8;
        return false;
    L8:
        if (this.f143342b == r101.f143342b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f143341a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        long r102 = this.f143342b;
        return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "SeiInfo(seiData=" + this.f143341a + ", createTime=" + this.f143342b + ")";
    }

    public u(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "seiData");
        this.f143341a = r100;
        this.f143342b = r101;
    }
}
