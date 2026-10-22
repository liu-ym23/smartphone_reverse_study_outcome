package com.bytedance.android.shopping.store.slicecard.view;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f186359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f186360b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f186359a, r101.f186359a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f186360b, r101.f186360b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        i r100 = this.f186359a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        i r104 = this.f186360b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BrandAuthText(normalSuffix=" + this.f186359a + ", foldedSuffix=" + this.f186360b + ")";
    }

    public a(i r100, i r101) {
        this.f186359a = r100;
        this.f186360b = r101;
    }
}
