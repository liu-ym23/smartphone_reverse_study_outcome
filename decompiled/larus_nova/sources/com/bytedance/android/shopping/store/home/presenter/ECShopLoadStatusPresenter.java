package com.bytedance.android.shopping.store.home.presenter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.bytedance.android.shopping.store.home.entity.ECStoreTabAreaVO;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ECShopLoadStatusPresenter extends ECShopBasePresenter {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f183973u = 0;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECShopLoadStatusPresenter f183974a;

        public a(ECShopLoadStatusPresenter r100) {
            this.f183974a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L5;
            this.f183974a.s0();
            return;
        L5:
            Activity r101 = com.bytedance.android.ec.core.utils.l0.b(this.f183974a.u().c());
            if (r101 == null) goto L20;
            View r102 = ECShopLoadStatusPresenter.q0(r101.getWindow());
            if ((r102 instanceof ViewGroup) == true) goto L11;
            r102 = null;
        L11:
            ViewGroup r103 = (ViewGroup) r102;
            if (r103 == null) goto L21;
            View r104 = r103.findViewById(R.id.ec_store_closing_status_view_container);
            if (r104 == null) goto L19;
            r103.removeView(r104);
            return;
        L19:
            return;
        L21:
            return;
        }
    }

    public final void s0() {
        Activity r100 = com.bytedance.android.ec.core.utils.l0.b(u().c());
        if (r100 != null) goto L5;
        return;
    L5:
        View r101 = q0(r100.getWindow());
        ColorDrawable r102 = null;
        if ((r101 instanceof ViewGroup) == true) goto L8;
        r101 = null;
    L8:
        ViewGroup r103 = (ViewGroup) r101;
        if (r103 != null) goto L12;
        return;
    L12:
        if (r100.findViewById(R.id.ec_store_closing_status_view_container) == null) goto L14;
        return;
    L14:
        boolean r104 = U();
        FrameLayout r105 = new FrameLayout(r100);
        if (r104 == true) goto L18;
        r102 = new ColorDrawable(-1);
    L18:
        int r106 = qc3.a.f532459a;
        Intrinsics.checkNotNullParameter(r105, "$this$setBackgroundCompat");
        r105.setBackground(r102);
        if (r104 == false) goto L21;
        int r107 = ((Number) this.f183904q.getValue()).intValue();
    L22:
        r105.setPadding(0, r107, 0, 0);
        r105.setId(R.id.ec_store_closing_status_view_container);
        t0(r105, r104).b(com.bytedance.android.ec.store.status.b.c.f48653a);
        r103.addView(r105, -1, -1);
        return;
    L21:
        r107 = 0;
        goto L22
    }

    public ECShopLoadStatusPresenter(Fragment r100) {
        super(r100);
    }

    public static View q0(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r110) {
        if (Intrinsics.areEqual(T().getStoreClosingStatus().getValue(), Boolean.TRUE) == false) goto L5;
        s0();
    L5:
        T().getStoreClosingStatus().a(W(), new a(this), false);
        boolean r111 = U();
        ViewGroup r100 = (ViewGroup) w().b(R.id.ec_store_status_view_container).f();
        if (r111 == false) goto L8;
        Drawable r101 = null;
    L9:
        int r102 = qc3.a.f532459a;
        Intrinsics.checkNotNullParameter(r100, "$this$setBackgroundCompat");
        r100.setBackground(r101);
        if (r111 == false) goto L12;
        int r103 = ((Number) this.f183904q.getValue()).intValue();
    L13:
        r100.setPadding(0, r103, 0, 0);
        LazyStatusView r112 = t0(r100, r111);
        com.bytedance.android.ec.store.status.b r104 = com.bytedance.android.ec.store.status.b.c.f48653a;
        r112.b(r104);
        T().getRestoreCoverVisible().a(W(), new b1(this, r100, r112), false);
        T().getLoadStatus().a(W(), new c1(this, r112, r100), false);
        T().getTabArea().a(W(), new d1(this, r100), false);
        final Context r113 = th.a.e(u().c(), true);
        ViewGroup r105 = (ViewGroup) w().b(R.id.ec_store_tab_status_view).f();
        r105.setVisibility(0);
        final LazyStatusView r106 = new LazyStatusView(r113, null);
        r106.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r105.addView(r106);
        r106.setCreators(MapsKt.mapOf(new Pair[]{TuplesKt.to(r104, new com.bytedance.android.ec.store.status.c(new ECShopLoadStatusPresenter$mayInitOptTabStatusView$1(this, r113), null, 6)), TuplesKt.to(com.bytedance.android.ec.store.status.b.C0841b.f48652a, new com.bytedance.android.ec.store.status.c(new ECShopLoadStatusPresenter$mayInitOptTabStatusView$2(this, r106), null, 6))}));
        ViewGroup r114 = (ViewGroup) w().b(R.id.ec_store_root_tab_bar_container).f();
        Context r107 = th.a.e(u().c(), true);
        int r108 = r0(r107);
        int r109 = e0();
        ShoppingAsyncInflater.f45268e.getClass();
        View r115 = ShoppingAsyncInflater.a.a(r107).aU(R.layout.ec_store_layout_loading_root_tab_bar, null, false);
        FrameLayout.LayoutParams r116 = new FrameLayout.LayoutParams(r108, r109);
        r116.gravity = 80;
        Unit r117 = Unit.INSTANCE;
        r115.setLayoutParams(r116);
        r114.addView(r115);
        r106.b(r104);
        v0(r114, r115, T().getTabLoadStatus().getValue());
        T().getLoadStatus().a(W(), new e1(this, r114, r115), false);
        T().getHeaderArea().a(W(), new f1(this, r114, r115), false);
        T().getTabLoadStatus().a(W(), new g1(this, r114, r115, r106), false);
        return;
    L12:
        r103 = 0;
        goto L13
    L8:
        r101 = new ColorDrawable(-1);
        goto L9
    }

    public final int r0(Context r100) {
        Point r101 = com.bytedance.android.ec.core.utils.l0.f(r100);
        if (r101 == null) goto L5;
        int r102 = r101.x;
    L7:
        if (T().getStoreParam().isSplitMode() == false) goto L9;
        r102 = r102 / 2;
    L9:
        if (r102 > 0) goto L13;
        return -1;
    L13:
        return r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final void u0(int r100) {
        View r101 = w().b(R.id.ec_store_coordinator_layout).f();
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if ((r102 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r102 = null;
    L5:
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        if (r103 != null) goto L8;
        return;
    L8:
        if (r103.bottomMargin == r100) goto L12;
        r103.bottomMargin = r100;
        r101.requestLayout();
        return;
    }

    public final LazyStatusView t0(ViewGroup r100, boolean r101) {
        final LazyStatusView r102 = new LazyStatusView(th.a.e(u().c(), true), null);
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-2, -2);
        r103.gravity = 17;
        Unit r104 = Unit.INSTANCE;
        r102.setLayoutParams(r103);
        if (r101 == false) goto L5;
        ColorDrawable r105 = new ColorDrawable(-1);
        int r106 = qc3.a.f532459a;
        Intrinsics.checkNotNullParameter(r102, "$this$setBackgroundCompat");
        r102.setBackground(r105);
        qc3.a.i(r102, 12.0f, 12.0f);
    L5:
        r100.addView(r102);
        r102.setCreators(MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.store.status.b.c.f48653a, new com.bytedance.android.ec.store.status.c(new ECShopLoadStatusPresenter$tryAddLoadStatusViewToContainer$1(this), new ECShopLoadStatusPresenter$tryAddLoadStatusViewToContainer$2(this), 4)), TuplesKt.to(com.bytedance.android.ec.store.status.b.C0841b.f48652a, new com.bytedance.android.ec.store.status.c(new ECShopLoadStatusPresenter$tryAddLoadStatusViewToContainer$3(this, r102), null, 6))}));
        return r102;
    }

    public final void v0(ViewGroup r100, View r101, LoadStatus r102) {
        boolean r103 = true;
        int r104 = 0;
        if (T().getLoadStatus().getValue() != LoadStatus.InitializeSuccess) goto L5;
    L7:
        boolean r105 = false;
    L8:
        if (r105 == true) goto L10;
    L18:
        r101.setVisibility(8);
        if (T().getHeaderArea().getValue() != null) goto L21;
    L25:
        boolean r106 = false;
    L26:
        if (r106 == false) goto L28;
        r100.setVisibility(8);
        u0(0);
        return;
    L28:
        ECStoreTabAreaVO r107 = T().getTabArea().getValue();
        if (r107 == null) goto L31;
        List<uj3.j> r108 = r107.f183634b;
    L32:
        if (r108 != null) goto L34;
    L35:
        com.bytedance.android.shopping.store.home.entity.n r109 = T().getHeaderArea().getValue();
        if (r109 != null) goto L38;
    L40:
        if (r108 == null) goto L42;
        int r110 = r108.size();
    L43:
        if (r110 <= 1) goto L45;
    L49:
        if (r103 == false) goto L55;
        r100.setVisibility(0);
        if (U() == true) goto L54;
        r104 = e0();
    L54:
        u0(r104);
        return;
    L55:
        r100.setVisibility(8);
        u0(0);
        return;
    L45:
        if (Intrinsics.areEqual(T().isBrandShop().getValue(), Boolean.TRUE) == false) goto L47;
    L48:
        r103 = false;
        goto L49
    L47:
        if (T().isMiddleTabFramework() == false) goto L49;
    L42:
        r110 = 0;
        goto L43
    L38:
        if (r109.c() != true) goto L40;
    L34:
        if (r108.isEmpty() == true) goto L48;
    L31:
        r108 = null;
        goto L32
    L21:
        if (r102 != LoadStatus.Initialize) goto L23;
    L24:
        r106 = true;
        goto L26
    L23:
        if (r102 != LoadStatus.InitializeError) goto L25;
    L10:
        if (r102 != LoadStatus.Initialize) goto L12;
    L13:
        r100.setVisibility(0);
        if (U() == false) goto L16;
        int r111 = 0;
    L17:
        u0(r111);
        r101.setVisibility(0);
        return;
    L16:
        r111 = e0();
        goto L17
    L12:
        if (r102 != LoadStatus.InitializeError) goto L18;
    L5:
        if (T().getHeaderArea().getValue() != null) goto L7;
        r105 = true;
        goto L8
    }
}
