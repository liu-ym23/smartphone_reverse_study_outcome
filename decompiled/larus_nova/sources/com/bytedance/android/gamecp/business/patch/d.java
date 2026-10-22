package com.bytedance.android.gamecp.business.patch;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f56221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f56222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f56223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f56224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f56225e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f56226f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L18;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f56221a, r101.f56221a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f56222b, r101.f56222b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f56223c, r101.f56223c) == true) goto L12;
        return false;
    L12:
        if (this.f56224d == r101.f56224d) goto L14;
        return false;
    L14:
        if (this.f56225e == r101.f56225e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f56226f, r101.f56226f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    public final int hashCode() {
        String r100 = this.f56221a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f56222b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f56223c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + this.f56224d) * 31;
        boolean r110 = this.f56225e;
        ?? r111 = r110;
        if (r110 == false) goto L17;
        r111 = 1;
    L17:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f56226f;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        return r112 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "Md5Info(packageName=" + this.f56221a + ", md5=" + this.f56222b + ", versionName=" + this.f56223c + ", versionCode=" + this.f56224d + ", isSuccess=" + this.f56225e + ", errorMessage=" + this.f56226f + ")";
    }

    public d(String r100, String r101, String r102, int r103, boolean r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "packageName");
        this.f56221a = r100;
        this.f56222b = r101;
        this.f56223c = r102;
        this.f56224d = r103;
        this.f56225e = r104;
        this.f56226f = r105;
    }
}
