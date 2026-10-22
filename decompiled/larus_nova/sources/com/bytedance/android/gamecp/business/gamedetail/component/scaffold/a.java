package com.bytedance.android.gamecp.business.gamedetail.component.scaffold;

import com.bytedance.android.gamecp.base.gamedetail.d0;
import com.bytedance.ies.sve_core.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f55002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f55003b;

    /* JADX INFO: renamed from: com.bytedance.android.gamecp.business.gamedetail.component.scaffold.a$a, reason: collision with other inner class name */
    public static final class C0893a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.f55002a == r101.f55002a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f55003b, r101.f55003b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f55002a * 31;
        d0 r101 = this.f55003b;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "AudienceGameTitleBarPropsV2(style=" + this.f55002a + ", titleBarContentProps=" + this.f55003b + ")";
    }

    public a(int r100, d0 r101) {
        this.f55002a = r100;
        this.f55003b = r101;
    }
}
