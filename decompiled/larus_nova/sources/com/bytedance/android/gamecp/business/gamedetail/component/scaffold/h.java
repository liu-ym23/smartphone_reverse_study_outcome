package com.bytedance.android.gamecp.business.gamedetail.component.scaffold;

import com.bytedance.android.gamecp.base.gamedetail.a1;
import com.bytedance.android.gamecp.base.gamedetail.n0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n0 f55018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a1 f55019b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L10;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f55018a, r101.f55018a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f55019b, r101.f55019b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        n0 r100 = this.f55018a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        a1 r104 = this.f55019b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ScaffoldUIStyle(tabUIStyle=" + this.f55018a + ", titleBarStyle=" + this.f55019b + ")";
    }

    public h(n0 r100, a1 r101) {
        Intrinsics.checkNotNullParameter(r100, "tabUIStyle");
        Intrinsics.checkNotNullParameter(r101, "titleBarStyle");
        this.f55018a = r100;
        this.f55019b = r101;
    }
}
