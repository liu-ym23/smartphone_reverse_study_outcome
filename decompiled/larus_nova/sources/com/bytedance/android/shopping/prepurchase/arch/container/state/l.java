package com.bytedance.android.shopping.prepurchase.arch.container.state;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class l<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f180844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f180845b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L10;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f180844a, r101.f180844a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f180845b, r101.f180845b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        A r100 = this.f180844a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        B r104 = this.f180845b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "Tuple2(a=" + this.f180844a + ", b=" + this.f180845b + ")";
    }

    public l(A r100, B r101) {
        this.f180844a = r100;
        this.f180845b = r101;
    }
}
