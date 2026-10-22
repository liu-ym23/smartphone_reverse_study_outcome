package com.bytedance.android.shopping.prepurchase.arch.container.intf;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f180801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f180802b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L10;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.f180801a, r101.f180801a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f180802b, r101.f180802b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        k r100 = this.f180801a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        T r104 = this.f180802b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ResponseState(state=" + this.f180801a + ", response=" + this.f180802b + ")";
    }

    public l(k r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f180801a = r100;
        this.f180802b = r101;
    }

    public static l a(l r100, k r101, T r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f180801a;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = r100.f180802b;
    L8:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "state");
        return new l(r101, r102);
    }
}
