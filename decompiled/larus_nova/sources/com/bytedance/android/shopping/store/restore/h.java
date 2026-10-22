package com.bytedance.android.shopping.store.restore;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ej3.f f185795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.bytedance.android.ec.store.repository.vo.r> f185796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.ec.store.repository.vo.n f185797c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f185798d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<com.bytedance.android.ec.store.repository.dto.c> f185799e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<com.bytedance.android.ec.store.repository.dto.c> f185800f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == false) goto L18;
        h r101 = (h) r100;
        if (Intrinsics.areEqual(this.f185795a, r101.f185795a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f185796b, r101.f185796b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f185797c, r101.f185797c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f185798d, r101.f185798d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f185799e, r101.f185799e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f185800f, r101.f185800f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        ej3.f r100 = this.f185795a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<com.bytedance.android.ec.store.repository.vo.r> r104 = this.f185796b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        com.bytedance.android.ec.store.repository.vo.n r107 = this.f185797c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.f185798d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<com.bytedance.android.ec.store.repository.dto.c> r113 = this.f185799e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<com.bytedance.android.ec.store.repository.dto.c> r116 = this.f185800f;
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
        return "ProductFilterSortState(sortsVO=" + this.f185795a + ", sortTypes=" + this.f185796b + ", discountButton=" + this.f185797c + ", bigSaleMoveToTop=" + this.f185798d + ", selectButtons=" + this.f185799e + ", filterSelectButtons=" + this.f185800f + ")";
    }

    public h(ej3.f r100, List<com.bytedance.android.ec.store.repository.vo.r> r101, com.bytedance.android.ec.store.repository.vo.n r102, Boolean r103, List<com.bytedance.android.ec.store.repository.dto.c> r104, List<com.bytedance.android.ec.store.repository.dto.c> r105) {
        this.f185795a = r100;
        this.f185796b = r101;
        this.f185797c = r102;
        this.f185798d = r103;
        this.f185799e = r104;
        this.f185800f = r105;
    }
}
