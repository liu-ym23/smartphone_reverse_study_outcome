package com.bytedance.android.gamecp.business.patch;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f56232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f56233b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f56234c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L12;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f56232a, r101.f56232a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f56233b, r101.f56233b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f56234c, r101.f56234c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f56232a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f56233b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f56234c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "md5:" + this.f56232a + ", version:" + this.f56233b + ", hostVersionCode:" + this.f56234c;
    }

    public g(String r100, String r101, Long r102) {
        this.f56232a = r100;
        this.f56233b = r101;
        this.f56234c = r102;
    }
}
