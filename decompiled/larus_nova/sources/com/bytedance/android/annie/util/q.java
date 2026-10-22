package com.bytedance.android.annie.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f40072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f40073b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (this.f40072a == r101.f40072a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f40073b, r101.f40073b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.f40072a == false) goto L5;
        int r100 = 1231;
    L7:
        return (r100 * 31) + this.f40073b.hashCode();
    L5:
        r100 = 1237;
        goto L7
    }

    public final String toString() {
        return "Response(isSucceed=" + this.f40072a + ", message=" + this.f40073b + ')';
    }

    public q(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "message");
        this.f40072a = r100;
        this.f40073b = r101;
    }
}
