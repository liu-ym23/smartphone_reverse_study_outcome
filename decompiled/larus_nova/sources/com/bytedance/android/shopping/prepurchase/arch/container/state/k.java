package com.bytedance.android.shopping.prepurchase.arch.container.state;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class k<A> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f180843a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof k) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f180843a, ((k) r100).f180843a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        A r100 = this.f180843a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "Tuple1(a=" + this.f180843a + ")";
    }

    public k(A r100) {
        this.f180843a = r100;
    }
}
