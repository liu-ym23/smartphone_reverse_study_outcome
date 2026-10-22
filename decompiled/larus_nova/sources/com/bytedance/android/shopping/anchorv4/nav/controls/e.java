package com.bytedance.android.shopping.anchorv4.nav.controls;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f167136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f167137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f167138c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L12;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f167136a, r101.f167136a) == true) goto L8;
        return false;
    L8:
        if (this.f167137b == r101.f167137b) goto L10;
        return false;
    L10:
        if (this.f167138c == r101.f167138c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public final int hashCode() {
        String r100 = this.f167136a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        int r102 = r101 * 31;
        boolean r103 = this.f167137b;
        ?? r104 = 1;
        ?? r105 = r103;
        if (r103 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r102 + r105) * 31;
        boolean r107 = this.f167138c;
        if (r107 == true) goto L14;
        r104 = r107;
    L14:
        return r106 + r104;
    L5:
        r101 = 0;
        goto L6
    }

    public final String toString() {
        return "Record(productId=" + this.f167136a + ", clicked=" + this.f167137b + ", animated=" + this.f167138c + ")";
    }

    public e(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "productId");
        this.f167136a = r100;
        this.f167137b = r101;
        this.f167138c = r102;
    }
}
