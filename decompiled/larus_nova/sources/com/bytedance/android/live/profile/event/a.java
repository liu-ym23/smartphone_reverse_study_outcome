package com.bytedance.android.live.profile.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SpreadStateType f86022a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f86022a, ((a) r100).f86022a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        SpreadStateType r100 = this.f86022a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "InfoSpreadState(spreadStateType=" + this.f86022a + ")";
    }

    public a(SpreadStateType r100) {
        Intrinsics.checkNotNullParameter(r100, "spreadStateType");
        this.f86022a = r100;
    }
}
