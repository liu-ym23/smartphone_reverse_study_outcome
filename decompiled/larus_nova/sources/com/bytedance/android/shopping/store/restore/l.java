package com.bytedance.android.shopping.store.restore;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f185812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f185813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f185814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f185815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f185816e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L16;
        l r101 = (l) r100;
        if (this.f185812a == r101.f185812a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f185813b, r101.f185813b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f185814c, r101.f185814c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f185815d, r101.f185815d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f185816e, r101.f185816e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f185812a * 31;
        i r101 = this.f185813b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        f r105 = this.f185814c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        h r108 = this.f185815d;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        g r111 = this.f185816e;
        if (r111 == null) goto L18;
        r102 = r111.hashCode();
    L18:
        return r110 + r102;
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "ProductTabState(tabId=" + this.f185812a + ", request=" + this.f185813b + ", scroll=" + this.f185814c + ", filterSort=" + this.f185815d + ", middleCoupon=" + this.f185816e + ")";
    }

    public l(int r100, i r101, f r102, h r103, g r104) {
        this.f185812a = r100;
        this.f185813b = r101;
        this.f185814c = r102;
        this.f185815d = r103;
        this.f185816e = r104;
    }
}
