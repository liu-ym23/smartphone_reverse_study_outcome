package com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel;

import bl2.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements com.bytedance.android.ec.core.arch.state.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f152946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f152947b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L10;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f152946a, r101.f152946a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f152947b, r101.f152947b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        e r100 = this.f152946a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        b r104 = this.f152947b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "SaasCouponState(newcomerTicketModel=" + this.f152946a + ", loginState=" + this.f152947b + ")";
    }

    public c(e r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "newcomerTicketModel");
        Intrinsics.checkNotNullParameter(r101, "loginState");
        this.f152946a = r100;
        this.f152947b = r101;
    }
}
