package com.bytedance.android.livesdk.livecommerce.saascoupon.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements com.bytedance.android.ec.core.arch.state.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f152944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f152945b;

    public b() {
        boolean r100 = false;
        this(r100, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (this.f152944a == r101.f152944a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f152945b, r101.f152945b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r100 = this.f152944a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.f152945b;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "SaasCouponLoginState(isLogin=" + this.f152944a + ", descInside=" + this.f152945b + ")";
    }

    public /* synthetic */ b(boolean r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r101 & 2) == 0) goto L8;
        String r102 = "";
    L9:
        this(r100, r102);
        return;
    L8:
        r102 = null;
        goto L9
    }

    public b(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "descInside");
        this.f152944a = r100;
        this.f152945b = r101;
    }
}
