package com.bytedance.android.ec.core.arch.state;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class j<A, B, C, D, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f43879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f43880b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C f43881c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final D f43882d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final E f43883e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L16;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f43879a, r101.f43879a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f43880b, r101.f43880b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f43881c, r101.f43881c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f43882d, r101.f43882d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f43883e, r101.f43883e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        A r100 = this.f43879a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        B r104 = this.f43880b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        C r107 = this.f43881c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        D r110 = this.f43882d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        E r113 = this.f43883e;
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
        return "StateTuple5(a=" + this.f43879a + ", b=" + this.f43880b + ", c=" + this.f43881c + ", d=" + this.f43882d + ", e=" + this.f43883e + ")";
    }

    public j(A r100, B r101, C r102, D r103, E r104) {
        this.f43879a = r100;
        this.f43880b = r101;
        this.f43881c = r102;
        this.f43882d = r103;
        this.f43883e = r104;
    }
}
