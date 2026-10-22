package com.bytedance.android.shopping.store.home.presenter;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.store.home.entity.ECShopBrandHeaderStyleDto;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes14.dex */
public final class ECShopBackgroundPresenterBrand extends ECShopBasePresenter {
    public static final /* synthetic */ int G = 0;
    public ECDraweeView A;
    public ViewGroup B;
    public View C;
    public int D;
    public int E;
    public int F;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f183888u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f183889v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f183890w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f183891x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Lazy f183892y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Lazy f183893z;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopBackgroundPresenterBrand f183894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f183895b;

        public a(ECShopBackgroundPresenterBrand r100, View r101) {
            this.f183894a = r100;
            this.f183895b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            com.bytedance.android.shopping.store.home.entity.n r100 = (com.bytedance.android.shopping.store.home.entity.n) r110;
            if (r100 == null) goto L111;
            Boolean r101 = null;
            if (r100.d() == false) goto L83;
            View r102 = com.bytedance.android.ec.store.product.presenter.utils.f.a(this.f183894a.w().b(R.id.ec_store_background_container));
            if (r102 == null) goto L10;
            r102.setVisibility(0);
        L10:
            ECDraweeView r103 = (ECDraweeView) this.f183894a.f183888u.getValue();
            if (r103 == null) goto L17;
            ECShopBrandHeaderStyleDto r104 = r100.f183756j;
            if (r104 == null) goto L15;
            ECUrlModel r105 = r104.getHeaderBackgroundImg();
        L16:
            com.bytedance.android.ec.core.imagex.h0.d(r103, r105, this.f183894a.T().getImageCallerContext(), null, null, null, null, 120);
            r103.setVisibility(0);
            goto L17
        L15:
            r105 = null;
        L17:
            this.f183894a.y().post(new k(this));
            ECShopBrandHeaderStyleDto r106 = r100.f183756j;
            if (r106 == null) goto L20;
            Boolean r107 = r106.getNeedHeaderBackgroundMask();
        L22:
            if (Intrinsics.areEqual(r107, Boolean.TRUE) == false) goto L24;
            ECShopBackgroundPresenterBrand r108 = this.f183894a;
            ECShopBackgroundPresenterBrand.r0(r108, r108.t0(), 0.0f);
            this.f183894a.T().getUpglideFactor().a(this.f183894a.W(), new l(this), false);
        L24:
            ECShopBackgroundPresenterBrand r109 = this.f183894a;
            ECDraweeView r111 = r109.u0();
            ECShopBrandHeaderStyleDto r112 = r100.f183756j;
            if (r112 == null) goto L27;
            ECUrlModel r113 = r112.getHeaderBackgroundMaskImage();
        L28:
            if (r113 == null) goto L30;
            String r114 = r113.getFirstUrl();
        L31:
            if (r111 == null) goto L43;
            if (r114 != null) goto L35;
        L38:
            boolean r115 = true;
        L39:
            if (r115 == true) goto L43;
            com.bytedance.android.ec.core.imagex.h0.d(r111, r113, r109.T().getImageCallerContext(), null, null, null, null, 120);
            r111.setAlpha(1.0f);
            r111.setVisibility(0);
            boolean r116 = true;
        L48:
            r109.f183891x = r116;
            ECShopBackgroundPresenterBrand r117 = this.f183894a;
            ECDraweeView r118 = r117.u0();
            Float r119 = this.f183894a.T().getUpglideFactor().getValue();
            if (r119 == null) goto L51;
            float r120 = r119.floatValue();
        L52:
            ECShopBackgroundPresenterBrand.s0(r117, r118, r120);
            this.f183894a.T().getUpglideFactor().a(this.f183894a.W(), new m(this), false);
            this.f183894a.T().getSlideDistance().a(this.f183894a.W(), new n(this), false);
            if (this.f183894a.T().isCroppedStyle() == false) goto L96;
            View r121 = com.bytedance.android.ec.store.product.presenter.utils.f.a(this.f183894a.w().b(R.id.ec_store_background_container));
            if (r121 == null) goto L57;
            r121.setBackgroundColor(0);
        L57:
            this.f183894a.A = (ECDraweeView) this.f183895b.findViewById(R.id.ec_store_topbar_background);
            this.f183894a.B = (ViewGroup) this.f183895b.findViewById(R.id.ec_store_topbar_background_wrapper);
            this.f183894a.C = this.f183895b.findViewById(R.id.ec_store_topbar_background_mask);
            ((ViewGroup) this.f183895b.findViewById(R.id.ec_store_coordinator_layout)).setPadding(0, 0, 0, 0);
            ECDraweeView r122 = this.f183894a.A;
            if (r122 != null) goto L60;
            Intrinsics.throwUninitializedPropertyAccessException("topBarBackgroundView");
        L60:
            ECShopBrandHeaderStyleDto r123 = r100.f183756j;
            if (r123 == null) goto L63;
            ECUrlModel r124 = r123.getHeaderBackgroundImg();
        L64:
            com.bytedance.android.ec.core.imagex.h0.d(r122, r124, this.f183894a.T().getImageCallerContext(), null, null, null, null, 120);
            ViewGroup r125 = this.f183894a.B;
            if (r125 != null) goto L67;
            Intrinsics.throwUninitializedPropertyAccessException("topBarBackgroundViewWrapper");
        L67:
            this.f183894a.getClass();
            wg.a.d(r125, com.bytedance.android.ec.core.utils.k1.p() + com.bytedance.android.shopping.extensions.b.b(44));
            r125.setVisibility(0);
            ECDraweeView r126 = (ECDraweeView) this.f183894a.f183888u.getValue();
            if (r126 == null) goto L70;
            this.f183894a.getClass();
            com.bytedance.android.ec.core.utils.d2.d(r126, 0, -(com.bytedance.android.ec.core.utils.k1.p() + com.bytedance.android.shopping.extensions.b.b(44)), 0, 0);
        L70:
            View r127 = this.f183894a.t0();
            if (r127 == null) goto L73;
            this.f183894a.getClass();
            com.bytedance.android.ec.core.utils.d2.d(r127, 0, -(com.bytedance.android.ec.core.utils.k1.p() + com.bytedance.android.shopping.extensions.b.b(44)), 0, 0);
        L73:
            ViewGroup r128 = this.f183894a.v0();
            if (r128 == null) goto L76;
            ViewExtensionsKt.g(r128, 20.0f, 20.0f, 0.0f, 0.0f);
        L76:
            com.bytedance.android.ec.core.utils.n1.f45660i.getClass();
            float r129 = (com.bytedance.android.ec.core.utils.n1.a.c() - com.bytedance.android.ec.core.utils.n1.a.b()) - com.bytedance.android.ec.core.utils.k1.g();
            ViewGroup r130 = this.f183894a.v0();
            if (r130 == null) goto L79;
            r130.setY(r129);
        L79:
            this.f183894a.T().getSlideDistance().a(this.f183894a.W(), new o(this, r129), false);
            ECShopBackgroundPresenterBrand r131 = this.f183894a;
            View r132 = r131.C;
            if (r132 != null) goto L82;
            Intrinsics.throwUninitializedPropertyAccessException("topbarBackgroundMask");
        L82:
            ECShopBackgroundPresenterBrand.r0(r131, r132, 0.0f);
            this.f183894a.T().getCollapseFactor().a(this.f183894a.W(), new p(this), false);
            this.f183894a.T().getUpglideFactor().a(this.f183894a.W(), new q(this), false);
            goto L96
        L63:
            r124 = null;
        L96:
            ECShopBrandHeaderStyleDto r133 = r100.f183756j;
            if (r133 == null) goto L100;
            r101 = r133.getNeedHeaderBackgroundMask();
        L100:
            if (Intrinsics.areEqual(r101, Boolean.TRUE) == false) goto L104;
            View r134 = this.f183894a.t0();
            if (r134 == null) goto L108;
            r134.setVisibility(0);
            return;
        L108:
            return;
        L104:
            View r135 = this.f183894a.t0();
            if (r135 == null) goto L110;
            r135.setVisibility(8);
            return;
        L110:
            return;
        L51:
            r120 = 0.0f;
            goto L52
        L35:
            if (r114.length() == 0) goto L38;
            r115 = false;
        L43:
            if (r111 == null) goto L45;
            r111.setController(null);
        L45:
            if (r111 == null) goto L47;
            r111.setVisibility(8);
        L47:
            r116 = false;
            goto L48
        L30:
            r114 = null;
            goto L31
        L27:
            r113 = null;
            goto L28
        L20:
            r107 = null;
            goto L22
        L83:
            View r136 = com.bytedance.android.ec.store.product.presenter.utils.f.a(this.f183894a.w().b(R.id.ec_store_background_container));
            if (r136 == null) goto L86;
            r136.setVisibility(8);
        L86:
            ECDraweeView r137 = (ECDraweeView) this.f183894a.f183888u.getValue();
            if (r137 == null) goto L89;
            r137.setVisibility(8);
        L89:
            View r138 = this.f183894a.t0();
            if (r138 == null) goto L92;
            r138.setVisibility(8);
        L92:
            ECDraweeView r139 = this.f183894a.u0();
            if (r139 == null) goto L95;
            r139.setVisibility(8);
        L95:
            this.f183894a.f183891x = false;
            goto L96
        }
    }

    public final View t0() {
        return (View) this.f183889v.getValue();
    }

    public final ECDraweeView u0() {
        return (ECDraweeView) this.f183890w.getValue();
    }

    public final ViewGroup v0() {
        return (ViewGroup) this.f183892y.getValue();
    }

    public ECShopBackgroundPresenterBrand(Fragment r100) {
        super(r100);
        this.f183888u = LazyKt.lazy(new ECShopBackgroundPresenterBrand$background$2(this));
        this.f183889v = LazyKt.lazy(new ECShopBackgroundPresenterBrand$backgroundMask$2(this));
        this.f183890w = LazyKt.lazy(new ECShopBackgroundPresenterBrand$backgroundMaskImage$2(this));
        this.f183892y = LazyKt.lazy(new ECShopBackgroundPresenterBrand$backgroundWrapper$2(this));
        this.f183893z = LazyKt.lazy(new ECShopBackgroundPresenterBrand$backgroundBottomGradient$2(this));
    }

    public static final void q0(ECShopBackgroundPresenterBrand r100) {
        ECDraweeView r101 = (ECDraweeView) r100.f183888u.getValue();
        if (r101 == null) goto L19;
        Integer r102 = Integer.valueOf(r101.getMeasuredHeight());
        if (r102.intValue() <= 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L11;
        r102 = null;
    L11:
        if (r102 == null) goto L20;
        int r104 = r102.intValue();
        View r105 = r100.t0();
        if (r105 == null) goto L15;
        wg.a.d(r105, r104);
    L15:
        ECDraweeView r106 = r100.u0();
        if (r106 == null) goto L21;
        wg.a.d(r106, r104);
        return;
    L21:
        return;
    L20:
        return;
    L7:
        r103 = false;
        goto L8
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        View r101 = o0();
        T().getHeaderArea().a(W(), new a(this, r101), false);
    }

    public static final void r0(ECShopBackgroundPresenterBrand r100, View r101, float r102) {
        r100.getClass();
        if (r101 == null) goto L7;
        int r103 = (int) (51 + (102 * r102));
        GradientDrawable r104 = new GradientDrawable();
        r104.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        r104.setColors(new int[]{(r103 << 24) | 0, (int) 3254779904L, (int) 4278190080L});
        r104.setGradientCenter(0.5f, 0.5f);
        r104.setGradientType(0);
        r104.setShape(0);
        Intrinsics.checkNotNullParameter(r101, "$this$setBackgroundCompat");
        r101.setBackground(r104);
        return;
    }

    public static final void s0(ECShopBackgroundPresenterBrand r100, ECDraweeView r101, float r102) {
        if (r100.f183891x == false) goto L12;
        if (r101 == null) goto L13;
        float r103 = RangesKt.coerceIn(1.0f - RangesKt.coerceIn(r102, 0.0f, 1.0f), 0.0f, 1.0f);
        r101.setAlpha(r103);
        if (r103 > 0.01f) goto L9;
        int r104 = 8;
    L10:
        r101.setVisibility(r104);
        return;
    L9:
        r104 = 0;
        goto L10
    L13:
        return;
    }
}
