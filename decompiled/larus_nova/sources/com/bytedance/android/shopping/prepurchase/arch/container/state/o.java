package com.bytedance.android.shopping.prepurchase.arch.container.state;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class o<A, B, C, D, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f180853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f180854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C f180855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final D f180856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final E f180857e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L16;
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f180853a, r101.f180853a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f180854b, r101.f180854b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f180855c, r101.f180855c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f180856d, r101.f180856d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f180857e, r101.f180857e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        A r100 = this.f180853a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        B r104 = this.f180854b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        C r107 = this.f180855c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        D r110 = this.f180856d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        E r113 = this.f180857e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "Tuple5(a=" + this.f180853a + ", b=" + this.f180854b + ", c=" + this.f180855c + ", d=" + this.f180856d + ", e=" + this.f180857e + ")";
    }

    public o(A r100, B r101, C r102, D r103, E r104) {
        this.f180853a = r100;
        this.f180854b = r101;
        this.f180855c = r102;
        this.f180856d = r103;
        this.f180857e = r104;
    }
}
