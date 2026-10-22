package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f180939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ti.j f180940b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L10;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f180939a, r101.f180939a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f180940b, r101.f180940b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f180939a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ti.j r104 = this.f180940b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "Holder(eventName=" + this.f180939a + ", subscriber=" + this.f180940b + ")";
    }

    public f(String r100, LynxAbilityImpl$registerLynxHandler$1.a r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "subscriber");
        this.f180939a = r100;
        this.f180940b = r101;
    }
}
