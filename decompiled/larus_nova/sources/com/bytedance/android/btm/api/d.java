package com.bytedance.android.btm.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f41967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f41968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f41969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f41970d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f41971e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f41972f;

    public d() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L18;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f41967a, r101.f41967a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f41968b, r101.f41968b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f41969c, r101.f41969c) == true) goto L12;
        return false;
    L12:
        if (this.f41970d == r101.f41970d) goto L14;
        return false;
    L14:
        if (this.f41971e == r101.f41971e) goto L16;
        return false;
    L16:
        if (this.f41972f == r101.f41972f) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public final int hashCode() {
        Class<?> r100 = this.f41967a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f41968b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f41969c;
        if (r107 == null) goto L13;
        r101 = r107.hashCode();
    L13:
        int r108 = (r106 + r101) * 31;
        boolean r109 = this.f41970d;
        ?? r110 = 1;
        ?? r111 = r109;
        if (r109 == false) goto L16;
        r111 = 1;
    L16:
        int r112 = (r108 + r111) * 31;
        boolean r113 = this.f41971e;
        ?? r114 = r113;
        if (r113 == false) goto L19;
        r114 = 1;
    L19:
        int r115 = (r112 + r114) * 31;
        boolean r116 = this.f41972f;
        if (r116 == true) goto L24;
        r110 = r116;
    L24:
        return r115 + r110;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BtmPageClass(clazz=" + this.f41967a + ", clazzName=" + this.f41968b + ", btm=" + this.f41969c + ", auto=" + this.f41970d + ", singleton=" + this.f41971e + ", reuse=" + this.f41972f + ")";
    }

    public d(Class r100, String r101, String r102, boolean r103, boolean r104) {
        this.f41967a = r100;
        this.f41968b = r101;
        this.f41969c = r102;
        this.f41970d = r103;
        this.f41971e = r104;
        this.f41972f = false;
    }
}
