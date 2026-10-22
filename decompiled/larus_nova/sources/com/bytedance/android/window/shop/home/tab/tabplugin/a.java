package com.bytedance.android.window.shop.home.tab.tabplugin;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f188930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f188931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f188932c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f188933d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L14;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f188930a, r101.f188930a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f188931b, r101.f188931b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f188932c, r101.f188932c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f188933d, r101.f188933d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f188930a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f188931b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f188932c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.f188933d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "AnchorParams(secAuthorId=" + this.f188930a + ", categoryId=" + this.f188931b + ", subCategoryId=" + this.f188932c + ", sortType=" + this.f188933d + ")";
    }

    public a(String r100, String r101, String r102, Long r103) {
        Intrinsics.checkNotNullParameter(r100, "secAuthorId");
        this.f188930a = r100;
        this.f188931b = r101;
        this.f188932c = r102;
        this.f188933d = r103;
    }
}
