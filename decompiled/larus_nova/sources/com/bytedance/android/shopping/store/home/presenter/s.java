package com.bytedance.android.shopping.store.home.presenter;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.store.home.frame.container.ShopContainerType;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class s extends ECShopBasePresenter {
    public static final /* synthetic */ int E = 0;
    public final float A;
    public int B;
    public int C;
    public final a D;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ViewGroup f184387u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ECDraweeView f184388v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f184389w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f184390x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public View f184391y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public SimpleDraweeView f184392z;

    public static final class a implements vi3.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f184393a;

        public a(s r100) {
            this.f184393a = r100;
        }

        @Override // vi3.a
        public final void a(ShopContainerType r100, vi3.c r101) {
            Intrinsics.checkNotNullParameter(r100, "shopContainerType");
            Intrinsics.checkNotNullParameter(r101, "containerConfig");
            if (r100 != ShopContainerType.SHOP_TOPBAR_CONTAINER) goto L6;
            s r102 = this.f184393a;
            r102.B = r101.a();
        L8:
            s r103 = this.f184393a;
            View r104 = r103.f184390x;
            if (r104 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("promotionTopBarBackgroundWrapperWithoutTips");
        L11:
            s.q0(r104, r103.B);
            int r105 = r103.B + r103.C;
            SimpleDraweeView r106 = r103.f184392z;
            if (r106 != null) goto L14;
            Intrinsics.throwUninitializedPropertyAccessException("promotionTopBarBackgroundView");
        L14:
            s.q0(r106, r105);
            View r107 = r103.f184391y;
            if (r107 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("promotionTopBarBackgroundWithoutTipsMask");
        L17:
            s.q0(r107, r105);
            return;
        L6:
            if (r100 != ShopContainerType.SHOP_INFO_CONTAINER) goto L8;
            s r108 = this.f184393a;
            r108.C = r101.a();
            goto L8
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s f184394a;

        public b(s r100) {
            this.f184394a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            if (((com.bytedance.android.shopping.store.home.entity.n) r110).d() == false) goto L5;
            this.f184394a.y().setVisibility(8);
            return;
        L5:
            s r111 = this.f184394a;
            View r100 = r111.o0();
            r111.f184387u = (ViewGroup) r111.w().b(R.id.ec_store_background_wrapper).f();
            r111.f184388v = (ECDraweeView) r111.w().b(R.id.ec_store_background).f();
            r111.f184389w = r111.w().b(R.id.ec_store_background_bottom_to_top_gradient).f();
            r111.f184392z = (SimpleDraweeView) r100.findViewById(R.id.ec_store_top_bar_promotion_background_without_tips);
            r111.f184391y = r100.findViewById(R.id.ec_store_top_bar_promotion_background_without_tips_mask);
            r111.f184390x = r100.findViewById(R.id.ec_store_top_bar_promotion_background_wrapper_without_tips);
            s r112 = this.f184394a;
            ECUrlModel r101 = r112.c0();
            if (r101 == null) goto L12;
            SimpleDraweeView r102 = r112.f184392z;
            if (r102 != null) goto L10;
            Intrinsics.throwUninitializedPropertyAccessException("promotionTopBarBackgroundView");
        L10:
            ECShopBasePresenter.Y(r112, r102, r101);
        L12:
            if (r101 == null) goto L17;
            ECDraweeView r103 = r112.f184388v;
            if (r103 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("background");
        L16:
            ECShopBasePresenter.Y(r112, r103, r101);
        L17:
            if (r101 == null) goto L19;
            com.bytedance.android.ec.core.utils.p1 r104 = com.bytedance.android.ec.core.utils.p1.f45668d;
            String r105 = r101.getFirstUrl();
            ECShopBackgroundV2Presenter$bindBackgroundImg$3$1 r106 = ECShopBackgroundV2Presenter$bindBackgroundImg$3$1.INSTANCE;
            r104.getClass();
            com.bytedance.android.ec.core.utils.p1.f(r105, r106);
        L19:
            GradientDrawable r107 = new GradientDrawable();
            qc3.a.f(r107, r112.T().getBackgroundColorArray());
            qc3.a.g(r107, GradientDrawable.Orientation.RIGHT_LEFT);
            View r108 = r112.f184391y;
            if (r108 != null) goto L22;
            Intrinsics.throwUninitializedPropertyAccessException("promotionTopBarBackgroundWithoutTipsMask");
        L22:
            qc3.a.e(r108, r107);
            ViewGroup r109 = r112.f184387u;
            if (r109 != null) goto L25;
            Intrinsics.throwUninitializedPropertyAccessException("backgroundWrapper");
        L25:
            qc3.a.e(r109, r107);
            View r113 = r112.f184389w;
            if (r113 != null) goto L28;
            Intrinsics.throwUninitializedPropertyAccessException("bottomToTopGradient");
        L28:
            GradientDrawable r114 = new GradientDrawable();
            qc3.a.f(r114, new int[]{16119545, (int) 4294309625L});
            qc3.a.g(r114, GradientDrawable.Orientation.TOP_BOTTOM);
            Unit r115 = Unit.INSTANCE;
            qc3.a.e(r113, r114);
            if (r101 == null) goto L43;
            View r116 = r112.f184389w;
            if (r116 != null) goto L33;
            Intrinsics.throwUninitializedPropertyAccessException("bottomToTopGradient");
        L33:
            r116.setVisibility(4);
            ECDraweeView r117 = r112.f184388v;
            if (r117 != null) goto L36;
            Intrinsics.throwUninitializedPropertyAccessException("background");
        L36:
            r117.setVisibility(0);
            SimpleDraweeView r118 = r112.f184392z;
            if (r118 != null) goto L39;
            Intrinsics.throwUninitializedPropertyAccessException("promotionTopBarBackgroundView");
        L39:
            r118.setVisibility(0);
            View r119 = r112.f184391y;
            if (r119 != null) goto L42;
            Intrinsics.throwUninitializedPropertyAccessException("promotionTopBarBackgroundWithoutTipsMask");
        L42:
            r119.setVisibility(8);
        L43:
            ECStoreViewModel.registerContainerSizeChangeListener$default(this.f184394a.T(), ShopContainerType.SHOP_TOPBAR_CONTAINER, this.f184394a.D, false, 4, null);
            ECStoreViewModel.registerContainerSizeChangeListener$default(this.f184394a.T(), ShopContainerType.SHOP_INFO_CONTAINER, this.f184394a.D, false, 4, null);
            this.f184394a.T().getCollapseFactor().a(this.f184394a.W(), new t(this), false);
        }
    }

    public s(Fragment r100) {
        super(r100);
        this.A = 0.5f;
        this.D = new a(this);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        T().getHeaderArea().a(W(), new b(this), false);
    }

    public static void q0(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$changeHeight");
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
        if (r102 != null) goto L5;
    L6:
        ViewGroup.LayoutParams r103 = r100.getLayoutParams();
        if (r103 == null) goto L9;
        r103.height = r101;
    L9:
        r100.requestLayout();
        return;
    L5:
        if (r102.height != r101) goto L6;
    }
}
