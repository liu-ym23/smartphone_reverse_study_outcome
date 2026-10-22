package com.bytedance.android.live.profile.ui.util;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f86951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f86952b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L10;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f86951a, r101.f86951a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f86952b, r101.f86952b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        f r100 = this.f86951a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        f r104 = this.f86952b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "LoadInfo(shop=" + this.f86951a + ", honourWall=" + this.f86952b + ")";
    }

    public j(f r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, "shop");
        Intrinsics.checkNotNullParameter(r101, "honourWall");
        this.f86951a = r100;
        this.f86952b = r101;
    }
}
