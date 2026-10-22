package com.bytedance.android.shopping.store.restore;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.ec.store.repository.vo.h f185792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.ec.store.repository.vo.g f185793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, com.bytedance.android.ec.store.repository.vo.h> f185794c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L12;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f185792a, r101.f185792a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f185793b, r101.f185793b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f185794c, r101.f185794c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.ec.store.repository.vo.h r100 = this.f185792a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        com.bytedance.android.ec.store.repository.vo.g r104 = this.f185793b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, com.bytedance.android.ec.store.repository.vo.h> r107 = this.f185794c;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "MiddleCouponState(middleCouponFilterVO=" + this.f185792a + ", cachedCouponPanelInfo=" + this.f185793b + ", cachedCouponMapData=" + this.f185794c + ")";
    }

    public g(com.bytedance.android.ec.store.repository.vo.h r100, com.bytedance.android.ec.store.repository.vo.g r101, Map<String, com.bytedance.android.ec.store.repository.vo.h> r102) {
        this.f185792a = r100;
        this.f185793b = r101;
        this.f185794c = r102;
    }
}
