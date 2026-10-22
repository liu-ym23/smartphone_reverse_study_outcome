package com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ak6.g f133505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f133506b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L10;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f133505a, r101.f133505a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f133506b, r101.f133506b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        ak6.g r100 = this.f133505a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        i r104 = this.f133506b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PreRendDataV2(rendResult=" + this.f133505a + ", rendExtraInfo=" + this.f133506b + ")";
    }

    public d(ak6.g r100, i r101) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        this.f133505a = r100;
        this.f133506b = r101;
    }
}
