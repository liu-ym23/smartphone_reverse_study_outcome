package com.bytedance.android.livesdk.gift.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class q2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f126406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final py.k f126407b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q2) == false) goto L10;
        q2 r101 = (q2) r100;
        if (Intrinsics.areEqual(this.f126406a, r101.f126406a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f126407b, r101.f126407b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f126406a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        py.k r104 = this.f126407b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ImageAssetInfo(placeHolderKey=" + this.f126406a + ", mixImage=" + this.f126407b + ")";
    }

    public q2(String r100, py.k r101) {
        Intrinsics.checkNotNullParameter(r100, "placeHolderKey");
        this.f126406a = r100;
        this.f126407b = r101;
    }
}
