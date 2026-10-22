package com.bytedance.android.live.core.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class q1<A, B, C, D> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f66261a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f66262b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C f66263c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final D f66264d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q1) == false) goto L14;
        q1 r101 = (q1) r100;
        if (Intrinsics.areEqual(this.f66261a, r101.f66261a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f66262b, r101.f66262b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f66263c, r101.f66263c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f66264d, r101.f66264d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        A r100 = this.f66261a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        B r104 = this.f66262b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        C r107 = this.f66263c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        D r110 = this.f66264d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "(" + this.f66261a + ", " + this.f66262b + ", " + this.f66263c + ", " + this.f66264d + ')';
    }

    public q1(A r100, B r101, C r102, D r103) {
        this.f66261a = r100;
        this.f66262b = r101;
        this.f66263c = r102;
        this.f66264d = r103;
    }
}
