package com.bytedance.android.live.profit.fansclub;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f87274a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final py.k f87275b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f87274a, r101.f87274a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f87275b, r101.f87275b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f87274a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        py.k r104 = this.f87275b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "FansClubBadge(title=" + this.f87274a + ", icon=" + this.f87275b + ")";
    }

    public a(String r100, py.k r101) {
        Intrinsics.checkNotNullParameter(r100, "title");
        Intrinsics.checkNotNullParameter(r101, "icon");
        this.f87274a = r100;
        this.f87275b = r101;
    }

    public static a a(a r100, py.k r101) {
        String r102 = r100.f87274a;
        Intrinsics.checkNotNullParameter(r102, "title");
        Intrinsics.checkNotNullParameter(r101, "icon");
        return new a(r102, r101);
    }
}
