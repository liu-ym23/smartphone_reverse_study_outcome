package com.bytedance.android.gamecp.business.gamedetail.view;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f55948b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t) == false) goto L10;
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.f55947a, r101.f55947a) == true) goto L8;
        return false;
    L8:
        if (Float.compare(this.f55948b, r101.f55948b) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f55947a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + Float.floatToIntBits(this.f55948b);
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "TextItem(text=" + this.f55947a + ", width=" + this.f55948b + ")";
    }

    public t(String r100, float r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f55947a = r100;
        this.f55948b = r101;
    }
}
