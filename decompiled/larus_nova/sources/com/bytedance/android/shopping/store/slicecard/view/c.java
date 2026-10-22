package com.bytedance.android.shopping.store.slicecard.view;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f186362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f186363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f186364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f186365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.shopping.store.slicecard.view.a f186366e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f186367f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f186368g;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L20;
        c r101 = (c) r100;
        if (this.f186362a == r101.f186362a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f186363b, r101.f186363b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f186364c, r101.f186364c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f186365d, r101.f186365d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f186366e, r101.f186366e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f186367f, r101.f186367f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f186368g, r101.f186368g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f186362a * 31;
        i r101 = this.f186363b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        i r105 = this.f186364c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        i r108 = this.f186365d;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        com.bytedance.android.shopping.store.slicecard.view.a r111 = this.f186366e;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.f186367f;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        Integer r117 = this.f186368g;
        if (r117 == null) goto L26;
        r102 = r117.hashCode();
    L26:
        return r116 + r102;
    L21:
        r115 = 0;
        goto L22
    L17:
        r112 = 0;
        goto L18
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
        return "ECShopTrustFloatBarVO(identityType=" + this.f186362a + ", leadingItem=" + this.f186363b + ", trailingItem=" + this.f186364c + ", brandNames=" + this.f186365d + ", authText=" + this.f186366e + ", contentHeightPx=" + this.f186367f + ", horizonPaddingPx=" + this.f186368g + ")";
    }

    public c(int r100, i r101, i r102, i r103, com.bytedance.android.shopping.store.slicecard.view.a r104, Integer r105, Integer r106) {
        this.f186362a = r100;
        this.f186363b = r101;
        this.f186364c = r102;
        this.f186365d = r103;
        this.f186366e = r104;
        this.f186367f = r105;
        this.f186368g = r106;
    }
}
