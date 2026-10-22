package com.bytedance.android.live.broadcast.api.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a2 f59053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a2 f59054b;

    public z1() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof z1) == false) goto L10;
        z1 r101 = (z1) r100;
        if (Intrinsics.areEqual(this.f59053a, r101.f59053a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f59054b, r101.f59054b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        a2 r100 = this.f59053a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        a2 r104 = this.f59054b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ZoomPair(front=" + this.f59053a + ", back=" + this.f59054b + ")";
    }

    public z1(int r100) {
        this.f59053a = null;
        this.f59054b = null;
    }
}
