package com.bytedance.android.shopping.prepurchase.business.pdp;

import com.bytedance.android.shopping.anchorv4.params.AnchorV4Param;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class e implements com.bytedance.android.shopping.prepurchase.arch.container.state.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnchorV4Param f181848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f181849b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L10;
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f181848a, r101.f181848a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f181849b, r101.f181849b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        AnchorV4Param r100 = this.f181848a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        a r104 = this.f181849b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PdpGlobalState(inputParam=" + this.f181848a + ", containerState=" + this.f181849b + ")";
    }

    public e(AnchorV4Param r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "inputParam");
        Intrinsics.checkNotNullParameter(r101, "containerState");
        this.f181848a = r100;
        this.f181849b = r101;
    }
}
