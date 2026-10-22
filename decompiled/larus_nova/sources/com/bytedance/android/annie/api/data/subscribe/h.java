package com.bytedance.android.annie.api.data.subscribe;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f38410a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof h) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f38410a, ((h) r100).f38410a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        T r100 = this.f38410a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "NullableData(data=" + this.f38410a + ')';
    }

    public h(T r100) {
        this.f38410a = r100;
    }
}
