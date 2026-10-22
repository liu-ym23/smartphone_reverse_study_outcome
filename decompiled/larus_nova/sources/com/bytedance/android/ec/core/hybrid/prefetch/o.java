package com.bytedance.android.ec.core.hybrid.prefetch;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f44252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f44253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f44254c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L12;
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f44252a, r101.f44252a) == true) goto L8;
        return false;
    L8:
        if (this.f44253b == r101.f44253b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f44254c, r101.f44254c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f44252a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f44253b) * 31;
        String r104 = this.f44254c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "NativePrefetchResult(data=" + this.f44252a + ", status=" + this.f44253b + ", errorMessage=" + this.f44254c + ")";
    }

    public o(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f44252a = r100;
        this.f44253b = r101;
        this.f44254c = r102;
    }
}
