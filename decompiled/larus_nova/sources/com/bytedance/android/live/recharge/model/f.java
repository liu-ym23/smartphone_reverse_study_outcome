package com.bytedance.android.live.recharge.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f90030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f90031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f90032c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L12;
        f r101 = (f) r100;
        if (this.f90030a == r101.f90030a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f90031b, r101.f90031b) == true) goto L10;
        return false;
    L10:
        if (this.f90032c == r101.f90032c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f90030a * 31;
        String r101 = this.f90031b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return ((r100 + r102) * 31) + this.f90032c;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "RechargeOtherParams(needAccount=" + this.f90030a + ", enoughCallback=" + this.f90031b + ", rechargeSource=" + this.f90032c + ")";
    }

    public f(int r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "enoughCallback");
        this.f90030a = r100;
        this.f90031b = r101;
        this.f90032c = r102;
    }
}
