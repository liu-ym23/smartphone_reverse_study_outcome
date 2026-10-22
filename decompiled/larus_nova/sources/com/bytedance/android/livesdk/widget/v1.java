package com.bytedance.android.livesdk.widget;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f162211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f162212b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v1) == false) goto L10;
        v1 r101 = (v1) r100;
        if (this.f162211a == r101.f162211a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f162212b, r101.f162212b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f162211a * 31;
        String r101 = this.f162212b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "LiveUserPredictInfo(predictTime=" + this.f162211a + ", predictType=" + this.f162212b + ")";
    }

    public v1(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "predictType");
        this.f162211a = r100;
        this.f162212b = r101;
    }
}
