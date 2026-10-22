package com.bytedance.android.gamecp.business.gamedetail.page.root;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements com.bytedance.ies.sve_core.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.gamecp.business.dynamiccommon.widget.a f55518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.gamecp.base.gamedetail.d0 f55519b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L10;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f55518a, r101.f55518a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f55519b, r101.f55519b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.gamecp.business.dynamiccommon.widget.a r100 = this.f55518a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        com.bytedance.android.gamecp.base.gamedetail.d0 r104 = this.f55519b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AudienceGameDetailPageProps(loading=" + this.f55518a + ", props=" + this.f55519b + ")";
    }

    public f(com.bytedance.android.gamecp.business.dynamiccommon.widget.a r100, com.bytedance.android.gamecp.base.gamedetail.d0 r101) {
        Intrinsics.checkNotNullParameter(r100, "loading");
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_PROPS);
        this.f55518a = r100;
        this.f55519b = r101;
    }
}
