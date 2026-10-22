package com.bytedance.android.shopping.orderlist.list.slice.elements.tab;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f180316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f180317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f180318c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k f180319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<g> f180320e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f180321f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f180322g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L20;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f180316a, r101.f180316a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f180317b, r101.f180317b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f180318c, r101.f180318c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f180319d, r101.f180319d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f180320e, r101.f180320e) == true) goto L16;
        return false;
    L16:
        if (this.f180321f == r101.f180321f) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f180322g, r101.f180322g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        l r100 = this.f180316a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        l r104 = this.f180317b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        l r107 = this.f180318c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        k r110 = this.f180319d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<g> r113 = this.f180320e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (((r112 + r114) * 31) + this.f180321f) * 31;
        a r116 = this.f180322g;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
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
        return "OrderListTabInfo(badgeStyle=" + this.f180316a + ", normalButtonStyle=" + this.f180317b + ", selectedButtonStyle=" + this.f180318c + ", indicatorStyle=" + this.f180319d + ", tabItemList=" + this.f180320e + ", spaceWidth=" + this.f180321f + ", adaptiveGap=" + this.f180322g + ")";
    }

    public f(l r100, l r101, l r102, k r103, List<g> r104, int r105, a r106) {
        Intrinsics.checkNotNullParameter(r100, "badgeStyle");
        Intrinsics.checkNotNullParameter(r101, "normalButtonStyle");
        Intrinsics.checkNotNullParameter(r102, "selectedButtonStyle");
        Intrinsics.checkNotNullParameter(r103, "indicatorStyle");
        Intrinsics.checkNotNullParameter(r104, "tabItemList");
        this.f180316a = r100;
        this.f180317b = r101;
        this.f180318c = r102;
        this.f180319d = r103;
        this.f180320e = r104;
        this.f180321f = r105;
        this.f180322g = r106;
    }
}
