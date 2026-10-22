package com.bytedance.android.live.profile.seeselftransition;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f86176a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bitmap f86177b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L10;
        k r101 = (k) r100;
        if (this.f86176a == r101.f86176a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f86177b, r101.f86177b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f86176a * 31;
        Bitmap r101 = this.f86177b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "TransitionDialogInfo(transitionType=" + this.f86176a + ", srcBitmap=" + this.f86177b + ")";
    }

    public k(int r100, Bitmap r101) {
        Intrinsics.checkNotNullParameter(r101, "srcBitmap");
        this.f86176a = r100;
        this.f86177b = r101;
    }
}
