package com.bytedance.android.gamecp.common.ui.actionsheet;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f56964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f56965b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.f56964a == r101.f56964a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f56965b, r101.f56965b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f56964a * 31;
        String r101 = this.f56965b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "ActionItem(id=" + this.f56964a + ", name=" + this.f56965b + ")";
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        this.f56964a = 0;
        this.f56965b = r100;
    }
}
