package com.bytedance.android.livesdk.player;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class a0<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f155151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public B f155152b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a0) == false) goto L10;
        a0 r101 = (a0) r100;
        if (Intrinsics.areEqual(this.f155151a, r101.f155151a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f155152b, r101.f155152b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        A r100 = this.f155151a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        B r104 = this.f155152b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MutablePair(first=" + this.f155151a + ", second=" + this.f155152b + ")";
    }

    public a0(A r100, B r101) {
        this.f155151a = r100;
        this.f155152b = r101;
    }
}
