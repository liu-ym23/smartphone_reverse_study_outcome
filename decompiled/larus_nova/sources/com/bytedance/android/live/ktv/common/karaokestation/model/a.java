package com.bytedance.android.live.ktv.common.karaokestation.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OrderSongRequiredConfig f69495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f69496b;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f69495a, r101.f69495a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f69496b, r101.f69496b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        OrderSongRequiredConfig r100 = this.f69495a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        u r104 = this.f69496b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "CommonOrderSongConfig(requiredConfig=" + this.f69495a + ", optionalConfig=" + this.f69496b + ")";
    }

    public /* synthetic */ a(int r210) {
        this(new OrderSongRequiredConfig(0), new u(null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, 65535));
    }

    public a(OrderSongRequiredConfig r100, u r101) {
        Intrinsics.checkNotNullParameter(r100, "requiredConfig");
        Intrinsics.checkNotNullParameter(r101, "optionalConfig");
        this.f69495a = r100;
        this.f69496b = r101;
    }
}
