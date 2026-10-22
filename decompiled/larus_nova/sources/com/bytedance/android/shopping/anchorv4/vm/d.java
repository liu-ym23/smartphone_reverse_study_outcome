package com.bytedance.android.shopping.anchorv4.vm;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f167734a;

    public d() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f167734a, ((d) r100).f167734a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f167734a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "LastPageState(auctionStatus=" + this.f167734a + ")";
    }

    public d(Long r100) {
        this.f167734a = r100;
    }
}
