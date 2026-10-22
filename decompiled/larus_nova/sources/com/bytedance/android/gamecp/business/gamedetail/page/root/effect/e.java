package com.bytedance.android.gamecp.business.gamedetail.page.root.effect;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class e implements com.bytedance.ies.sve_core.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f55509a;

    public e() {
        this(0);
    }

    @Override // com.bytedance.ies.sve_core.i
    public final boolean a() {
        return true;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f55509a, ((e) r100).f55509a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.f55509a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "DetailShowIntent(nothing=" + this.f55509a + ")";
    }

    public e(int r100) {
        this.f55509a = 0;
    }
}
