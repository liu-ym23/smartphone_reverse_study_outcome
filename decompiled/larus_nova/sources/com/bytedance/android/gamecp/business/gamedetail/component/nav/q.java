package com.bytedance.android.gamecp.business.gamedetail.component.nav;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f54686a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof q) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f54686a, ((q) r100).f54686a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f54686a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "ScrollToNavEvent(targetNav=" + this.f54686a + ")";
    }

    public q() {
        Intrinsics.checkNotNullParameter("tab_comment", "targetNav");
        this.f54686a = "tab_comment";
    }
}
