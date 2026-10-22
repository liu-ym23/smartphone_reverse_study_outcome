package com.bytedance.android.ec.hybrid.list.holder;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f47205a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f47206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f47207c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L12;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f47205a, r101.f47205a) == true) goto L8;
        return false;
    L8:
        if (this.f47206b == r101.f47206b) goto L10;
        return false;
    L10:
        if (this.f47207c == r101.f47207c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public final int hashCode() {
        String r100 = this.f47205a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f47206b;
        ?? r104 = r103;
        if (r103 == false) goto L9;
        r104 = 1;
    L9:
        int r105 = (r102 + r104) * 31;
        long r106 = this.f47207c;
        return r105 + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "PreloadStatus(scheme=" + this.f47205a + ", isNativeCard=" + this.f47206b + ", duration=" + this.f47207c + ")";
    }

    public e(String r100, boolean r101, long r102) {
        this.f47205a = r100;
        this.f47206b = r101;
        this.f47207c = r102;
    }
}
