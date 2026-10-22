package com.bytedance.android.shopping.feed.event;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f174968a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof y) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f174968a, ((y) r100).f174968a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f174968a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "CloseProductFeedPageEvent(closeMethod=" + this.f174968a + ")";
    }

    public y(String r100) {
        Intrinsics.checkNotNullParameter(r100, "closeMethod");
        this.f174968a = r100;
    }
}
