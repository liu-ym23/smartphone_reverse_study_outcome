package com.bytedance.android.shopping.orderlist.common.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f179958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f179959b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f179958a, r101.f179958a) == true) goto L8;
        return false;
    L8:
        if (this.f179959b == r101.f179959b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public final int hashCode() {
        Boolean r100 = this.f179958a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f179959b;
        ?? r104 = r103;
        if (r103 == false) goto L10;
        r104 = 1;
    L10:
        return r102 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "OrderAppletPageInfo(isInApplet=" + this.f179958a + ", isInFirstAppletPage=" + this.f179959b + ")";
    }

    public b(Boolean r100, boolean r101) {
        this.f179958a = r100;
        this.f179959b = r101;
    }
}
