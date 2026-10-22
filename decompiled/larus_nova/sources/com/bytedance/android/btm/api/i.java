package com.bytedance.android.btm.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f41991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f41992b;

    public i() {
        this(null, null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L10;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f41991a, r101.f41991a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f41992b, r101.f41992b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Class<?> r100 = this.f41991a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f41992b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "HybridContainerClass(clazz=" + this.f41991a + ", clazzName=" + this.f41992b + ")";
    }

    public i(Class r100, String r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = "";
    L8:
        this.f41991a = r100;
        this.f41992b = r101;
    }
}
