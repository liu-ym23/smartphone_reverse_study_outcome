package com.bytedance.android.sdk.bdticketguard.utils;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f164079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f164080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f164081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f164082d;

    public a() {
        this(0, 0, false, null, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L25:
        return true;
    L5:
        if ((r100 instanceof a) == false) goto L24;
        a r101 = (a) r100;
        if (this.f164079a != r101.f164079a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L24;
        if (this.f164080b != r101.f164080b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L24;
        if (this.f164081c != r101.f164081c) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L24;
        if (Intrinsics.areEqual(this.f164082d, r101.f164082d) == false) goto L24;
    L19:
        r104 = false;
        goto L20
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    public final int hashCode() {
        long r100 = this.f164079a;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.f164080b;
        int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
        boolean r104 = this.f164081c;
        ?? r105 = r104;
        if (r104 == false) goto L5;
        r105 = 1;
    L5:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f164082d;
        if (r107 == null) goto L8;
        int r108 = r107.hashCode();
    L10:
        return r106 + r108;
    L8:
        r108 = 0;
        goto L10
    }

    public final String toString() {
        return "MemInfo(totalMiB=" + this.f164079a + ", availableMiB=" + this.f164080b + ", isLowMemory=" + this.f164081c + ", errorMsg=" + this.f164082d + ")";
    }

    public a(long r100, long r101, boolean r102, String r103, int r110) {
        if ((r110 & 1) == 0) goto L6;
        r100 = -1;
    L6:
        if ((r110 & 2) == 0) goto L9;
        r101 = -1;
    L9:
        if ((r110 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r110 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this.f164079a = r100;
        this.f164080b = r101;
        this.f164081c = r102;
        this.f164082d = r103;
    }
}
