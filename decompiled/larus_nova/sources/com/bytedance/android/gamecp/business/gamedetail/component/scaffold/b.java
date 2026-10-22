package com.bytedance.android.gamecp.business.gamedetail.component.scaffold;

import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.ies.sve_core.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f55004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f55005b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (this.f55004a == r101.f55004a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f55005b, r101.f55005b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f55004a * 31;
        d0 r101 = this.f55005b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "BottomConvertBarProps(style=" + this.f55004a + ", bottomConvertBarProps=" + this.f55005b + ")";
    }

    public b(d0 r100) {
        this.f55004a = 1;
        this.f55005b = r100;
    }
}
