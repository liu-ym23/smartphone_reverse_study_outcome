package com.bytedance.android.ec.core.arch.state;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class h<A, B, C> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f43872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f43873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C f43874c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L12;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f43872a, r101.f43872a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f43873b, r101.f43873b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f43874c, r101.f43874c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        A r100 = this.f43872a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        B r104 = this.f43873b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        C r107 = this.f43874c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "StateTuple3(a=" + this.f43872a + ", b=" + this.f43873b + ", c=" + this.f43874c + ")";
    }

    public h(A r100, B r101, C r102) {
        this.f43872a = r100;
        this.f43873b = r101;
        this.f43874c = r102;
    }
}
