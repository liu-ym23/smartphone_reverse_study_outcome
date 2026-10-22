package com.bytedance.android.shopping.orderlist.list.tab;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f180366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f180367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f180368c;

    public /* synthetic */ a() {
        this(null, 0, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L12;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f180366a, r101.f180366a) == true) goto L8;
        return false;
    L8:
        if (this.f180367b == r101.f180367b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f180368c, r101.f180368c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.f180366a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f180367b) * 31;
        String r104 = this.f180368c;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "OrderListTabParams(bizTabId=" + this.f180366a + ", tabId=" + this.f180367b + ", tabMode=" + this.f180368c + ")";
    }

    public a(Integer r100, int r101, String r102) {
        this.f180366a = r100;
        this.f180367b = r101;
        this.f180368c = r102;
    }
}
