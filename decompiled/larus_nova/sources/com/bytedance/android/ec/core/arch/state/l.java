package com.bytedance.android.ec.core.arch.state;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class l<A, B, C, D, E, F, G> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f43890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f43891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C f43892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final D f43893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final E f43894e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final F f43895f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final G f43896g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L20;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f43890a, r101.f43890a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f43891b, r101.f43891b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f43892c, r101.f43892c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f43893d, r101.f43893d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f43894e, r101.f43894e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f43895f, r101.f43895f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f43896g, r101.f43896g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        A r100 = this.f43890a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        B r104 = this.f43891b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        C r107 = this.f43892c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        D r110 = this.f43893d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        E r113 = this.f43894e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        F r116 = this.f43895f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        G r119 = this.f43896g;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
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
        return "StateTuple7(a=" + this.f43890a + ", b=" + this.f43891b + ", c=" + this.f43892c + ", d=" + this.f43893d + ", e=" + this.f43894e + ", f=" + this.f43895f + ", g=" + this.f43896g + ")";
    }

    public l(A r100, B r101, C r102, D r103, E r104, F r105, G r106) {
        this.f43890a = r100;
        this.f43891b = r101;
        this.f43892c = r102;
        this.f43893d = r103;
        this.f43894e = r104;
        this.f43895f = r105;
        this.f43896g = r106;
    }
}
