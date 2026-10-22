package com.bytedance.android.ecom.arch.slice.expr;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f50062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f50063b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f50064c;

    public c() {
        this(null, null, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f50062a, r101.f50062a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f50063b, r101.f50063b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f50064c, r101.f50064c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f50062a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Throwable r104 = this.f50063b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f50064c;
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
        return "SlcExprErrorInfo(expr=" + this.f50062a + ", throwable=" + this.f50063b + ", code=" + this.f50064c + ")";
    }

    public c(String r100, Throwable r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this.f50062a = r100;
        this.f50063b = r101;
        this.f50064c = null;
    }
}
