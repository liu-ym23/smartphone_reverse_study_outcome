package com.bytedance.android.gamecp.business.gamedetail.component.scaffold;

import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.ies.sve_core.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f55006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f55007b;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (this.f55006a == r101.f55006a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f55007b, r101.f55007b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f55006a * 31;
        d0 r101 = this.f55007b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "BottomFloatingProps(style=" + this.f55006a + ", bottomFloatingProps=" + this.f55007b + ")";
    }

    public c(d0 r100) {
        this.f55006a = 1;
        this.f55007b = r100;
    }
}
