package com.bytedance.android.latch.prefetch.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class f0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f58479a;

    public interface a {
        String getDataType();
    }

    public f0() {
        throw null;
    }

    public final int hashCode() {
        T r100 = this.f58479a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f0(Object r100) {
        this.f58479a = r100;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof f0) == false) goto L5;
        f0 r101 = (f0) r100;
    L6:
        if (r101 != null) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(r100.getClass(), getClass()) == true) goto L11;
        return false;
    L11:
        return Intrinsics.areEqual(this.f58479a, ((f0) r100).f58479a);
    L5:
        r101 = null;
        goto L6
    }
}
