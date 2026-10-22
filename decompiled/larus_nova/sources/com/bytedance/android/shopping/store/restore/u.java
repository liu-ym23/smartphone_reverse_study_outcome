package com.bytedance.android.shopping.store.restore;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f185850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f185851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f185852c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f185853d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f185854e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u) == false) goto L16;
        u r101 = (u) r100;
        if (Intrinsics.areEqual(this.f185850a, r101.f185850a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f185851b, r101.f185851b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f185852c, r101.f185852c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f185853d, r101.f185853d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f185854e, r101.f185854e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.f185850a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f185851b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f185852c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f185853d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f185854e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
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
        return "ShopPageUiState(selectedTabId=" + this.f185850a + ", selectedRootIndex=" + this.f185851b + ", selectedSubIndex=" + this.f185852c + ", croppedState=" + this.f185853d + ", headerState=" + this.f185854e + ")";
    }

    public u(Integer r100, Integer r101, Integer r102, Integer r103, Integer r104) {
        this.f185850a = r100;
        this.f185851b = r101;
        this.f185852c = r102;
        this.f185853d = r103;
        this.f185854e = r104;
    }
}
