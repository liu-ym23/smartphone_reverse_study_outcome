package com.bytedance.android.gamecp.business.gamedetail.component.orderbutton;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f54878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f54879c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f54880d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f54881e;

    public p() {
        this(null, null, false, false, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L16;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f54877a, r101.f54877a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f54878b, r101.f54878b) == true) goto L10;
        return false;
    L10:
        if (this.f54879c == r101.f54879c) goto L12;
        return false;
    L12:
        if (this.f54880d == r101.f54880d) goto L14;
        return false;
    L14:
        if (this.f54881e == r101.f54881e) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public final int hashCode() {
        String r100 = this.f54877a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f54878b;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (r103 + r101) * 31;
        boolean r106 = this.f54879c;
        ?? r107 = 1;
        ?? r108 = r106;
        if (r106 == false) goto L12;
        r108 = 1;
    L12:
        int r109 = (((r105 + r108) * 31) + this.f54880d) * 31;
        boolean r110 = this.f54881e;
        if (r110 == true) goto L17;
        r107 = r110;
    L17:
        return r109 + r107;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OrderEvent(gameId=" + this.f54877a + ", anchorId=" + this.f54878b + ", isReserve=" + this.f54879c + ", reserveStatus=" + this.f54880d + ", isFromDetail=" + this.f54881e + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public p(String r100, String r101, boolean r102, boolean r103, int r104) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = false;
    L12:
        if ((r104 & 8) == 0) goto L14;
        ?? r105 = r102;
    L16:
        if ((r104 & 16) == 0) goto L18;
        r103 = false;
    L18:
        Intrinsics.checkNotNullParameter(r100, "gameId");
        Intrinsics.checkNotNullParameter(r101, "anchorId");
        this.f54877a = r100;
        this.f54878b = r101;
        this.f54879c = r102;
        this.f54880d = r105;
        this.f54881e = r103;
        return;
    L14:
        r105 = 0;
        goto L16
    }
}
