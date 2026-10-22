package com.bytedance.android.gamecp.business.gamedetail.page.root.effect;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class j implements com.bytedance.ies.sve_core.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55517a;

    @Override // com.bytedance.ies.sve_core.i
    public final boolean a() {
        return true;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f55517a, ((j) r100).f55517a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f55517a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "TabShowIntent(tabId=" + this.f55517a + ")";
    }

    public j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tabId");
        this.f55517a = r100;
    }
}
