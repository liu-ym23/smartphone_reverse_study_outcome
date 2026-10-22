package com.bytedance.android.live.core.utils.rxutils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class y<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f66382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f66383b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof y) == false) goto L10;
        y r101 = (y) r100;
        if (Intrinsics.areEqual(this.f66382a, r101.f66382a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f66383b, r101.f66383b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        T r100 = this.f66382a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        T r104 = this.f66383b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "WithLastInfo(last=" + this.f66382a + ", new=" + this.f66383b + ")";
    }

    public y(T r100, T r101) {
        this.f66382a = r100;
        this.f66383b = r101;
    }
}
