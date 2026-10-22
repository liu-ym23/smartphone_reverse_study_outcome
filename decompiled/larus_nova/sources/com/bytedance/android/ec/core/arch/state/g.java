package com.bytedance.android.ec.core.arch.state;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class g<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f43870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f43871b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L10;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f43870a, r101.f43870a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f43871b, r101.f43871b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        A r100 = this.f43870a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        B r104 = this.f43871b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "StateTuple2(a=" + this.f43870a + ", b=" + this.f43871b + ")";
    }

    public g(A r100, B r101) {
        this.f43870a = r100;
        this.f43871b = r101;
    }
}
