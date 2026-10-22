package com.bytedance.android.gamecp.business.gamedetail.component.layoutcomponent.collist;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f54425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f54426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f54427c;

    public c() {
        this(false, null, 0, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L12;
        c r101 = (c) r100;
        if (this.f54425a == r101.f54425a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f54426b, r101.f54426b) == true) goto L10;
        return false;
    L10:
        if (this.f54427c == r101.f54427c) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r100 = this.f54425a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.f54426b;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return ((r102 + r104) * 31) + this.f54427c;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "ColListStyle(skipDrawDecoration=" + this.f54425a + ", backgroundColor=" + this.f54426b + ", itemSpace=" + this.f54427c + ")";
    }

    public c(boolean r100, String r101, int r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "#FFFFFFFF";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 0;
    L11:
        Intrinsics.checkNotNullParameter(r101, "backgroundColor");
        this.f54425a = r100;
        this.f54426b = r101;
        this.f54427c = r102;
    }
}
