package com.bytedance.android.shopping.orderlist.list.tab;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f180369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f180370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f180371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f180372d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Integer> f180373e;

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L16;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f180369a, r101.f180369a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f180370b, r101.f180370b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f180371c, r101.f180371c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f180372d, r101.f180372d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f180373e, r101.f180373e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f180369a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f180370b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f180371c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.f180372d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<Integer> r113 = this.f180373e;
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
        return "OrderListYataGlobalTabState(tabMode=" + this.f180369a + ", currentBizTabId=" + this.f180370b + ", currentTabId=" + this.f180371c + ", currentSubTabId=" + this.f180372d + ", tabIdList=" + this.f180373e + ")";
    }

    public /* synthetic */ b(int r100) {
        this(null, null, null, null, CollectionsKt.emptyList());
    }

    public b(String r100, Integer r101, Integer r102, Integer r103, List<Integer> r104) {
        Intrinsics.checkNotNullParameter(r104, "tabIdList");
        this.f180369a = r100;
        this.f180370b = r101;
        this.f180371c = r102;
        this.f180372d = r103;
        this.f180373e = r104;
    }
}
