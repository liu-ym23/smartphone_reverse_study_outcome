package com.bytedance.android.gamecp.business.gamedetail.page.root;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements com.bytedance.ies.sve_core.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.gamecp.base.gamedetail.d0 f55478a;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f55478a, ((c) r100).f55478a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        com.bytedance.android.gamecp.base.gamedetail.d0 r100 = this.f55478a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "AudienceGameDetailCenterPropsState(contentProp=" + this.f55478a + ")";
    }

    public c(com.bytedance.android.gamecp.business.gamedetail.component.layoutcomponent.collist.a r100) {
        this.f55478a = r100;
    }
}
