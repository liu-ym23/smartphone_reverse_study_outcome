package com.bytedance.android.live.profit.fansclub.widget.entrance.data;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f87415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f87416b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L10;
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f87415a, r101.f87415a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f87416b, r101.f87416b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f87415a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f87416b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "TipContent(textLine1=" + this.f87415a + ", textLine2=" + this.f87416b + ")";
    }

    public k(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "textLine1");
        Intrinsics.checkNotNullParameter(r101, "textLine2");
        this.f87415a = r100;
        this.f87416b = r101;
    }
}
