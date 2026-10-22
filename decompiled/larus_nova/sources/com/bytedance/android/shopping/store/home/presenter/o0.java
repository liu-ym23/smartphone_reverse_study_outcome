package com.bytedance.android.shopping.store.home.presenter;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.store.home.frame.container.ShopContainerType;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class o0 extends ECShopBasePresenter {
    public final b A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f184248u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f184249v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f184250w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public View f184251x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public SimpleDraweeView f184252y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f184253z;

    public static final class a {
    }

    public static final class b implements vi3.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o0 f184254a;

        public b(o0 r100) {
            this.f184254a = r100;
        }

        @Override // vi3.a
        public final void a(ShopContainerType r100, vi3.c r101) {
            Intrinsics.checkNotNullParameter(r100, "shopContainerType");
            Intrinsics.checkNotNullParameter(r101, "containerConfig");
            if (r100 != ShopContainerType.SHOP_INFO_CONTAINER) goto L27;
            o0 r102 = this.f184254a;
            int r103 = r101.a();
            if (r103 > 0) goto L7;
            r102.getClass();
            return;
        L7:
            if (r103 == r102.f184253z) goto L30;
            r102.f184253z = r103;
            r102.s0();
            View r104 = r102.f184250w;
            if (r104 == null) goto L14;
            ViewGroup.LayoutParams r105 = r104.getLayoutParams();
            if (r105 == null) goto L14;
            r105.height = r102.n0();
        L14:
            SimpleDraweeView r106 = r102.f184252y;
            if (r106 == null) goto L19;
            ViewGroup.LayoutParams r107 = r106.getLayoutParams();
            if (r107 == null) goto L19;
            r107.height = r102.n0();
        L19:
            View r108 = r102.f184249v;
            if (r108 == null) goto L28;
            ViewGroup.LayoutParams r109 = r108.getLayoutParams();
            if (r109 == null) goto L24;
            r109.height = r103;
        L24:
            r108.requestLayout();
            return;
        L28:
            return;
        L30:
            return;
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o0 f184255a;

        public c(o0 r100) {
            this.f184255a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            com.bytedance.android.shopping.store.home.entity.n r101 = (com.bytedance.android.shopping.store.home.entity.n) r100;
            if (r101 != null) goto L6;
            return;
        L6:
            if (r101.d() == false) goto L9;
            this.f184255a.y().setVisibility(8);
            return;
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o0 f184256a;

        public d(o0 r100) {
            this.f184256a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Float r101 = (Float) r100;
            o0.q0(this.f184256a);
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o0 f184257a;

        public e(o0 r100) {
            this.f184257a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Pair r101 = (Pair) r100;
            o0.q0(this.f184257a);
        }
    }

    static {
    }

    public final void s0() {
        if (this.f184253z > 0) goto L5;
        return;
    L5:
        float r100 = 1.0f - a0(0.5f);
        float r101 = h0();
        int r102 = (int) (r101 - (r100 * r101));
        View r103 = this.f184249v;
        if (r103 == null) goto L8;
        r103.setPadding(0, r102, 0, 0);
    L8:
        View r104 = this.f184248u;
        if (r104 == null) goto L13;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L13;
        r105.height = this.f184253z - r102;
    L13:
        View r106 = this.f184251x;
        if (r106 == null) goto L18;
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        if (r107 == null) goto L18;
        r107.height = this.f184253z - r102;
    L18:
        View r108 = this.f184249v;
        if (r108 == null) goto L22;
        r108.requestLayout();
        return;
    }

    public o0(Fragment r100) {
        super(r100);
        this.A = new b(this);
    }

    public static final void q0(o0 r100) {
        float r101 = r100.Z();
        boolean r102 = r100.p0();
        if (r101 < 0) goto L48;
        float r103 = (1.0f - r101) * 12.0f;
        if (r100.U() == false) goto L49;
        View r104 = r100.f184248u;
        if (r104 == null) goto L11;
        qc3.a.i(r104, r103, r103);
    L11:
        View r105 = r100.f184251x;
        if (r105 == null) goto L14;
        r105.setVisibility(0);
    L14:
        if (r102 == false) goto L19;
        Integer r106 = r100.T().getBigSalePicFinalColor().getValue();
        if (r106 == null) goto L18;
        int r107 = r106.intValue();
        r100.r0(r103, 16777215 & r107, r107);
    L20:
        r100.s0();
        if (r102 == false) goto L38;
        ECUrlModel r108 = r100.c0();
        if (r108 != null) goto L25;
    L35:
        View r109 = r100.f184250w;
        if (r109 == null) goto L45;
        r109.setVisibility(8);
        return;
    L45:
        return;
    L25:
        if (r101 >= 1.0f) goto L29;
        SimpleDraweeView r110 = r100.f184252y;
        if (r110 == null) goto L32;
        r110.setVisibility(0);
    L32:
        SimpleDraweeView r111 = r100.f184252y;
        if (r111 == null) goto L35;
        ECShopBasePresenter.Y(r100, r111, r108);
        goto L35
    L29:
        SimpleDraweeView r112 = r100.f184252y;
        if (r112 == null) goto L32;
        r112.setVisibility(8);
        goto L32
    L38:
        View r113 = r100.f184250w;
        if (r113 == null) goto L41;
        r113.setVisibility(0);
    L41:
        View r114 = r100.f184250w;
        if (r114 == null) goto L47;
        GradientDrawable r115 = new GradientDrawable();
        qc3.a.f(r115, r100.T().getBackgroundColorArray());
        Unit r116 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r114, "$this$setBackgroundCompat");
        r114.setBackground(r115);
        return;
    L47:
        return;
    L18:
        r100.T().getBigSalePicFinalColor().a(r100.W(), new p0(r100, r103), false);
        goto L20
    L19:
        r100.r0(r103, 16119545, (int) 4294309625L);
        goto L20
    L49:
        return;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r110) {
        T().getHeaderArea().a(W(), new c(this), false);
        this.f184248u = y();
        ViewParent r111 = y().getParent();
        if ((r111 instanceof ViewGroup) == true) goto L5;
        r111 = null;
    L5:
        this.f184249v = (ViewGroup) r111;
        this.f184250w = w().b(R.id.ec_store_collapsing_layout_promotion_background_mask).f();
        this.f184251x = w().b(R.id.ec_store_collapsing_layout_promotion_background_gradient).f();
        this.f184252y = (SimpleDraweeView) w().b(R.id.ec_store_collapsing_layout_promotion_background).f();
        ECStoreViewModel.registerContainerSizeChangeListener$default(T(), ShopContainerType.SHOP_INFO_CONTAINER, this.A, false, 4, null);
        T().getCollapseFactor().a(W(), new d(this), false);
        T().getSelectedTabLocation().d(W(), new e(this));
    }

    public final void r0(float r100, int r101, int r102) {
        View r103 = this.f184251x;
        if (r103 == null) goto L6;
        GradientDrawable r104 = new GradientDrawable();
        qc3.a.f(r104, new int[]{r101, r102});
        r104.setCornerRadii(qc3.a.b(r100, r100, 0.0f, 0.0f));
        Unit r105 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r103, "$this$setBackgroundCompat");
        r103.setBackground(r104);
        return;
    }
}
