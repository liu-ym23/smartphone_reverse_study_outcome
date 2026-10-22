package com.bytedance.android.shopping.feed.fragment.head;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.feed.fragment.ProductFeedContentFragment;
import com.bytedance.android.shopping.feed.view.CouponView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnchorV3Param f175082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f175083b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f175084c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CouponView f175085d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ProductFeedContentFragment f175086e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f175087f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == false) goto L20;
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f175082a, r101.f175082a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f175083b, r101.f175083b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f175084c, r101.f175084c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f175085d, r101.f175085d) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f175086e, r101.f175086e) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f175087f, r101.f175087f) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public final int hashCode() {
        AnchorV3Param r100 = this.f175082a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        FrameLayout r104 = this.f175083b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Context r107 = this.f175084c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + 0) * 31;
        CouponView r110 = this.f175085d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        ProductFeedContentFragment r113 = this.f175086e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        View r116 = this.f175087f;
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
        return "TopBarData(anchorV3Param=" + this.f175082a + ", container=" + this.f175083b + ", context=" + this.f175084c + ", searchDataCenter=null, bottomCouponView=" + this.f175085d + ", contentFragment=" + this.f175086e + ", touchOutFeedView=" + this.f175087f + ")";
    }

    public final Context getContext() {
        return this.f175084c;
    }

    public g(AnchorV3Param r100, FrameLayout r101, Context r102, CouponView r103, ProductFeedContentFragment r104, View r105) {
        Intrinsics.checkNotNullParameter(r100, "anchorV3Param");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        this.f175082a = r100;
        this.f175083b = r101;
        this.f175084c = r102;
        this.f175085d = r103;
        this.f175086e = r104;
        this.f175087f = r105;
    }
}
