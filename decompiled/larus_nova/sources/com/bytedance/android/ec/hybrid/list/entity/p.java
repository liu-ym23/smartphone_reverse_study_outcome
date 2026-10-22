package com.bytedance.android.ec.hybrid.list.entity;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f47148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f47149c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L12;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f47147a, r101.f47147a) == true) goto L8;
        return false;
    L8:
        if (this.f47148b == r101.f47148b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f47149c, r101.f47149c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f47147a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f47148b) * 31;
        Integer r104 = this.f47149c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MallSaasPreloadViewParams(schema=" + this.f47147a + ", preloadNum=" + this.f47148b + ", presetWidth=" + this.f47149c + ")";
    }

    public p(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        this.f47147a = r100;
        this.f47148b = r101;
        this.f47149c = null;
    }
}
