package com.bytedance.android.ec.core.arch.state;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class i<A, B, C, D> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f43875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f43876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C f43877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final D f43878d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L14;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f43875a, r101.f43875a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f43876b, r101.f43876b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f43877c, r101.f43877c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f43878d, r101.f43878d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        A r100 = this.f43875a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        B r104 = this.f43876b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        C r107 = this.f43877c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        D r110 = this.f43878d;
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
        return "StateTuple4(a=" + this.f43875a + ", b=" + this.f43876b + ", c=" + this.f43877c + ", d=" + this.f43878d + ")";
    }

    public i(A r100, B r101, C r102, D r103) {
        this.f43875a = r100;
        this.f43876b = r101;
        this.f43877c = r102;
        this.f43878d = r103;
    }
}
