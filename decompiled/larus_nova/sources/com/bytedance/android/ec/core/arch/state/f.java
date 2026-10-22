package com.bytedance.android.ec.core.arch.state;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class f<A> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final A f43869a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f43869a, ((f) r100).f43869a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        A r100 = this.f43869a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "StateTuple1(a=" + this.f43869a + ")";
    }

    public f(A r100) {
        this.f43869a = r100;
    }
}
