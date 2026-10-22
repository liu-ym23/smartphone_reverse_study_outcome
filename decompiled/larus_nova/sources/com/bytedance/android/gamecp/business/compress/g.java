package com.bytedance.android.gamecp.business.compress;

import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class g implements Comparable<g> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.download.b f52288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cw.c f52289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f52290c;

    public final int hashCode() {
        Object[] r100 = new Object[2];
        com.bytedance.android.gamecp.business.download.b r101 = this.f52288a;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.f52538g;
    L6:
        r100[0] = r103;
        if (r101 == null) goto L9;
        r102 = r101.f52534c;
    L9:
        r100[1] = r102;
        return Objects.hash(r100);
    L5:
        r103 = null;
        goto L6
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("AirCompressTask downloadUrl = ");
        com.bytedance.android.gamecp.business.download.b r101 = this.f52288a;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.f52538g;
    L6:
        r100.append(r103);
        r100.append(", fileName = ");
        com.bytedance.android.gamecp.business.download.b r104 = this.f52288a;
        if (r104 == null) goto L9;
        r102 = r104.f52534c;
    L9:
        r100.append(r102);
        r100.append(", restoreFrom = ");
        r100.append(this.f52290c);
        return r100.toString();
    L5:
        r103 = null;
        goto L6
    }

    @Override // java.lang.Comparable
    public final int compareTo(g r100) {
        g r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "other");
        return r101.f52290c - this.f52290c;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof g) == false) goto L36;
        com.bytedance.android.gamecp.business.download.b r101 = this.f52288a;
        String r102 = null;
        if (r101 == null) goto L7;
        String r103 = r101.f52538g;
    L8:
        boolean r104 = true;
        if (r103 != null) goto L11;
    L14:
        boolean r105 = true;
    L15:
        if (r105 == true) goto L36;
        g r106 = (g) r100;
        com.bytedance.android.gamecp.business.download.b r107 = r106.f52288a;
        if (r107 == null) goto L19;
        String r108 = r107.f52538g;
    L20:
        if (r108 != null) goto L22;
    L25:
        if (r104 == true) goto L36;
        com.bytedance.android.gamecp.business.download.b r109 = this.f52288a;
        if (r109 == null) goto L30;
        String r110 = r109.f52538g;
    L31:
        com.bytedance.android.gamecp.business.download.b r111 = r106.f52288a;
        if (r111 == null) goto L35;
        r102 = r111.f52538g;
    L35:
        return Intrinsics.areEqual(r110, r102);
    L30:
        r110 = null;
        goto L31
    L22:
        if (r108.length() == 0) goto L25;
        r104 = false;
        goto L25
    L19:
        r108 = null;
        goto L20
    L11:
        if (r103.length() == 0) goto L14;
        r105 = false;
        goto L15
    L7:
        r103 = null;
    L36:
        return false;
    }

    public g(com.bytedance.android.gamecp.business.download.b r100, cw.c r101, int r102) {
        this.f52288a = r100;
        this.f52289b = r101;
        this.f52290c = r102;
    }
}
