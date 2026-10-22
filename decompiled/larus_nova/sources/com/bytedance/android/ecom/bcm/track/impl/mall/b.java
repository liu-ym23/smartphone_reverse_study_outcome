package com.bytedance.android.ecom.bcm.track.impl.mall;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kc.a.C6534a f51084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f51085b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L10;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f51084a, r101.f51084a) == true) goto L8;
        return false;
    L8:
        if (this.f51085b == r101.f51085b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        kc.a.C6534a r100 = this.f51084a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.f51085b;
    L5:
        r101 = 0;
        goto L7
    }

    public final String toString() {
        return "ItemWrapped(item=" + this.f51084a + ", length=" + this.f51085b + ")";
    }

    public b(kc.a.C6534a r100, int r101) {
        this.f51084a = r100;
        this.f51085b = r101;
    }
}
