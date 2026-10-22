package com.bytedance.android.livesdk.livecommerce.livereplay.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class b implements com.bytedance.android.ec.core.arch.state.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f149377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final oi2.c f149378b;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (this.f149377a == r101.f149377a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f149378b, r101.f149378b) == true) goto L16;
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
        boolean r100 = this.f149377a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        oi2.c r103 = this.f149378b;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "ECScrollProductCardState(isFold=" + this.f149377a + ", select=" + this.f149378b + ")";
    }

    public /* synthetic */ b(int r100) {
        this(false, new oi2.c(0));
    }

    public b(boolean r100, oi2.c r101) {
        Intrinsics.checkNotNullParameter(r101, "select");
        this.f149377a = r100;
        this.f149378b = r101;
    }

    public static b a(b r100, boolean r101, oi2.c r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f149377a;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = r100.f149378b;
    L8:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "select");
        return new b(r101, r102);
    }
}
