package com.bytedance.android.ec.core.hybrid.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f44335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f44336b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == false) goto L10;
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f44335a, r101.f44335a) == true) goto L8;
        return false;
    L8:
        if (this.f44336b == r101.f44336b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f44335a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.f44336b;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "PrefetchData(data=" + this.f44335a + ", status=" + this.f44336b + ")";
    }

    public q(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f44335a = r100;
        this.f44336b = r101;
    }
}
