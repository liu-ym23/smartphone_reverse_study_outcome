package com.bytedance.android.gamecp.common.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f57273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f57274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f57275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f57276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f57277e;

    public r0() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r0) == false) goto L16;
        r0 r101 = (r0) r100;
        if (Intrinsics.areEqual(this.f57273a, r101.f57273a) == true) goto L8;
        return false;
    L8:
        if (this.f57274b == r101.f57274b) goto L10;
        return false;
    L10:
        if (this.f57275c == r101.f57275c) goto L12;
        return false;
    L12:
        if (this.f57276d == r101.f57276d) goto L14;
        return false;
    L14:
        if (this.f57277e == r101.f57277e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public final int hashCode() {
        String r100 = this.f57273a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f57274b;
        ?? r104 = r103;
        if (r103 == false) goto L9;
        r104 = 1;
    L9:
        int r105 = (((r102 + r104) * 31) + this.f57275c) * 31;
        long r106 = this.f57276d;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        long r108 = this.f57277e;
        return r107 + ((int) (r108 ^ (r108 >>> 32)));
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "PkgInstallDTO(pkgName=" + this.f57273a + ", isInstalled=" + this.f57274b + ", versionCode=" + this.f57275c + ", createTime=" + this.f57276d + ", installTime=" + this.f57277e + ")";
    }

    public /* synthetic */ r0(int r100) {
        this("", false, Integer.MIN_VALUE, 0, 0);
    }

    public r0(String r100, boolean r101, int r102, long r103, long r104) {
        Intrinsics.checkNotNullParameter(r100, "pkgName");
        this.f57273a = r100;
        this.f57274b = r101;
        this.f57275c = r102;
        this.f57276d = r103;
        this.f57277e = r104;
    }
}
