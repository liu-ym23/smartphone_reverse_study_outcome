package com.bytedance.android.live.recharge.trace.session;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f90400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f90401b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f90400a, r101.f90400a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f90401b, r101.f90401b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f90400a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f90401b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SessionEventSpec(group=" + this.f90400a + ", name=" + this.f90401b + ")";
    }

    public c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "group");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.f90400a = r100;
        this.f90401b = r101;
    }
}
