package com.bytedance.android.ec.core.arch.state;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class k<A, B, C, D, E, F> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f43884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final B f43885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C f43886c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final D f43887d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final E f43888e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final F f43889f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == false) goto L18;
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.f43884a, r101.f43884a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f43885b, r101.f43885b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f43886c, r101.f43886c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f43887d, r101.f43887d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f43888e, r101.f43888e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f43889f, r101.f43889f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        A r100 = this.f43884a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        B r104 = this.f43885b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        C r107 = this.f43886c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        D r110 = this.f43887d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        E r113 = this.f43888e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        F r116 = this.f43889f;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
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
        return "StateTuple6(a=" + this.f43884a + ", b=" + this.f43885b + ", c=" + this.f43886c + ", d=" + this.f43887d + ", e=" + this.f43888e + ", f=" + this.f43889f + ")";
    }

    public k(A r100, B r101, C r102, D r103, E r104, F r105) {
        this.f43884a = r100;
        this.f43885b = r101;
        this.f43886c = r102;
        this.f43887d = r103;
        this.f43888e = r104;
        this.f43889f = r105;
    }
}
