package com.bytedance.android.shopping.feed.widget;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d63.l f176076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rd3.a f176077b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof v) == false) goto L10;
        v r101 = (v) r100;
        if (Intrinsics.areEqual(this.f176076a, r101.f176076a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f176077b, r101.f176077b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        d63.l r100 = this.f176076a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        rd3.a r104 = this.f176077b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ProductFeedHeaderVO(headerBanner=" + this.f176076a + ", anchorInflowFeedItem=" + this.f176077b + ")";
    }

    public v(d63.l r100, rd3.a r101) {
        Intrinsics.checkNotNullParameter(r100, "headerBanner");
        this.f176076a = r100;
        this.f176077b = r101;
    }
}
