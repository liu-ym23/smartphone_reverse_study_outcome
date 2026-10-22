package com.bytedance.android.shopping.widget.buybutton;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f187272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<l> f187273b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f187272a, r101.f187272a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f187273b, r101.f187273b) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f187272a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<l> r104 = this.f187273b;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "BuyButtonVO(productName=" + this.f187272a + ", singleButtonVOList=" + this.f187273b + ")";
    }

    public a() {
        this(null, CollectionsKt.emptyList());
    }

    public a(String r100, List<l> r101) {
        Intrinsics.checkNotNullParameter(r101, "singleButtonVOList");
        this.f187272a = r100;
        this.f187273b = r101;
    }
}
