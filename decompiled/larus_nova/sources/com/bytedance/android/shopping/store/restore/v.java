package com.bytedance.android.shopping.store.restore;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Boolean f185855a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f185855a, ((v) r100).f185855a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f185855a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "StoreSignState(headerAreaStartScrollTag=" + this.f185855a + ")";
    }

    public v(Boolean r100) {
        this.f185855a = r100;
    }
}
