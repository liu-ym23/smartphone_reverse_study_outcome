package com.bytedance.android.window.shop.innerflow.presenter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.window.base.shop.SpacesItemDecoration;
import com.bytedance.android.ec.window.base.utils.playable.controller.playcontrol.WindowPlayControlStrategy;
import com.bytedance.android.window.shop.holder.footer.FooterStatus;
import com.bytedance.android.window.shop.innerflow.ECWindowInnerFlowActivity;
import com.bytedance.android.window.shop.innerflow.ECWindowInnerFlowViewModel;
import com.bytedance.android.window.shop.innerflow.widget.ECWindowInnerFlowAdapter;
import com.bytedance.android.window.shop.innerflow.widget.ECWindowInnerFlowRecyclerView;
import com.bytedance.android.window.shop.widget.WindowStatusView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QContext;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0005\u0006B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/window/shop/innerflow/presenter/ECWindowInnerFlowListPresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QPresenter;", "Landroidx/lifecycle/LifecycleEventObserver;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECWindowInnerFlowListPresenter extends QPresenter implements LifecycleEventObserver {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f189161n = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f189162e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f189163f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f189164g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public WindowStatusView f189165h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f189166i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f189167j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f189168k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.android.ec.window.base.utils.playable.controller.b f189169l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ECWindowInnerFlowListPresenter$scrollListener$1 f189170m;

    public static final class a {
    }

    public final class b implements com.bytedance.android.window.shop.innerflow.repo.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECWindowInnerFlowListPresenter f189172a;

        @Override // com.bytedance.android.window.shop.innerflow.repo.d
        public final void a() {
            ECWindowInnerFlowListPresenter r100 = this.f189172a;
            int r101 = ECWindowInnerFlowListPresenter.f189161n;
            if (r100.D().getBasicItemCount() != 0) goto L8;
            WindowStatusView r102 = this.f189172a.f189165h;
            if (r102 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
        L7:
            r102.setVisibility(0);
            r102.setECStatus(2);
        L12:
            ECWindowInnerFlowListPresenter r103 = this.f189172a;
            r103.f189164g = false;
            r103.f189163f = true;
            r103.D().z2(FooterStatus.NO_MORE);
            return;
        L8:
            WindowStatusView r104 = this.f189172a.f189165h;
            if (r104 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
        L11:
            r104.b();
            goto L12
        }

        @Override // com.bytedance.android.window.shop.innerflow.repo.d
        public final void onError() {
            Intrinsics.checkNotNullParameter("", "msg");
            ECWindowInnerFlowListPresenter r100 = this.f189172a;
            int r101 = ECWindowInnerFlowListPresenter.f189161n;
            if (r100.D().getBasicItemCount() != 0) goto L8;
            WindowStatusView r102 = this.f189172a.f189165h;
            if (r102 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
        L7:
            r102.setVisibility(0);
            r102.setECStatus(2);
        L12:
            this.f189172a.f189164g = false;
            return;
        L8:
            WindowStatusView r103 = this.f189172a.f189165h;
            if (r103 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
        L11:
            r103.b();
            goto L12
        }

        public b(ECWindowInnerFlowListPresenter r100) {
            this.f189172a = r100;
        }

        @Override // com.bytedance.android.window.shop.innerflow.repo.d
        public final void b(List<? extends vp3.b> r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            WindowStatusView r101 = this.f189172a.f189165h;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("statusView");
        L5:
            r101.b();
            ECWindowInnerFlowListPresenter r102 = this.f189172a;
            r102.f189164g = false;
            ECWindowInnerFlowAdapter r103 = r102.D();
            monitor-enter(r103);
            Intrinsics.checkNotNullParameter(r100, "innerFlowList");     // Catch: Throwable -> L13
            int r104 = ((ArrayList) r103.f189219c).size();     // Catch: Throwable -> L13
            ArrayList r105 = (ArrayList) r103.f189219c;     // Catch: Throwable -> L13
            r105.addAll(r100);     // Catch: Throwable -> L13
            if (r104 != 0) goto L10;
            r103.notifyDataSetChanged();     // Catch: Throwable -> L13
        L11:
            monitor-exit(r103);
            return;
        L10:
            r103.notifyItemRangeInserted(r104, r100.size());     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            throw th;
        }
    }

    static {
    }

    public final ECWindowInnerFlowAdapter D() {
        return (ECWindowInnerFlowAdapter) this.f189166i.getValue();
    }

    public final ECWindowInnerFlowRecyclerView E() {
        return (ECWindowInnerFlowRecyclerView) this.f189162e.getValue();
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        com.bytedance.android.ec.window.base.utils.playable.controller.b r100 = this.f189169l;
        if (r100 == null) goto L5;
        r100.f49741e.c();
    L5:
        QContext r101 = u();
        ComponentActivity r102 = l0.c(r101.c());
        if ((r102 instanceof ECWindowInnerFlowActivity) == true) goto L8;
        r102 = null;
    L8:
        ComponentActivity r103 = (ECWindowInnerFlowActivity) r102;
        if (r103 != null) goto L11;
        r103 = r101.a();
    L11:
        ((ECWindowInnerFlowActivity) r103).getLifecycle().removeObserver(this);
    }

    public final void F() {
        ((ECWindowInnerFlowViewModel) this.f189167j.getValue()).loadMore(this.f189168k);
        this.f189164g = true;
        D().z2(FooterStatus.LOADING);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.bytedance.android.window.shop.innerflow.presenter.ECWindowInnerFlowListPresenter$scrollListener$1] */
    public ECWindowInnerFlowListPresenter() {
        this.f189162e = LazyKt.lazy(new ECWindowInnerFlowListPresenter$recyclerView$2(this));
        this.f189166i = LazyKt.lazy(new ECWindowInnerFlowListPresenter$adapter$2(this));
        this.f189167j = LazyKt.lazy(new ECWindowInnerFlowListPresenter$viewModel$2(this));
        this.f189168k = new b(this);
        this.f189170m = new ECWindowInnerFlowListPresenter$scrollListener$1(this);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        this.f189165h = (WindowStatusView) y().findViewById(R.id.ec_shop_inner_flow_status_view);
        ShoppingAsyncInflater.a r101 = ShoppingAsyncInflater.f45268e;
        Context r102 = u().c();
        r101.getClass();
        ShoppingAsyncInflater r103 = ShoppingAsyncInflater.a.a(r102);
        WindowStatusView r104 = this.f189165h;
        if (r104 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L5:
        View r105 = com.bytedance.android.ec.opt.asyncInflate.c.a(r103, R.layout.ec_window_shopping_layout_store_v2_default, r104, 4);
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        if (r106 == null) goto L33;
        ((FrameLayout.LayoutParams) r106).gravity = 17;
        if (((ECWindowInnerFlowViewModel) ECQuickUtilKt.c(u(), ECWindowInnerFlowViewModel.class)).getInnerFlowParam().f189041c != 0) goto L10;
        boolean r107 = true;
    L11:
        if (r107 == false) goto L13;
        int r108 = R.layout.ec_shop_layout_inner_flow_product_struct_view;
    L14:
        LayoutInflater r109 = LayoutInflater.from(u().c());
        WindowStatusView r110 = this.f189165h;
        if (r110 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L17:
        View r111 = r109.inflate(r108, r110, false);
        WindowStatusView r112 = this.f189165h;
        if (r112 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L20:
        r112.c(r111, r105, true);
        ((TextView) r105.findViewById(R.id.store_v2_tv_refresh)).setOnClickListener(new com.bytedance.android.window.shop.innerflow.presenter.b(this));
        WindowStatusView r113 = this.f189165h;
        if (r113 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("statusView");
    L23:
        r113.setVisibility(0);
        r113.setECStatus(0);
        E().setLayoutManager(new LinearLayoutManager(u().c()));
        E().setAdapter(D());
        int r114 = com.bytedance.android.shopping.extensions.b.b(12);
        E().addItemDecoration(new SpacesItemDecoration(r114, r114, r114));
        ComponentActivity r115 = null;
        com.bytedance.android.ec.window.base.utils.playable.controller.b r116 = new com.bytedance.android.ec.window.base.utils.playable.controller.b(new vp.a(), new wp.a(E()), null, WindowPlayControlStrategy.ORDER_FIRST);
        ECWindowInnerFlowRecyclerView r117 = E();
        Intrinsics.checkNotNullParameter(r117, "recyclerView");
        r116.f49737a = r117;
        r117.addOnScrollListener(r116.f49740d);
        Unit r118 = Unit.INSTANCE;
        this.f189169l = r116;
        E().addOnScrollListener(this.f189170m);
        F();
        QContext r119 = u();
        ComponentActivity r120 = l0.c(r119.c());
        if ((r120 instanceof ECWindowInnerFlowActivity) == false) goto L27;
        r115 = r120;
    L27:
        ComponentActivity r121 = (ECWindowInnerFlowActivity) r115;
        if (r121 != null) goto L30;
        r121 = r119.a();
    L30:
        ((ECWindowInnerFlowActivity) r121).getLifecycle().addObserver(this);
        return;
    L13:
        r108 = R.layout.ec_shop_layout_inner_flow_video_struct_view;
        goto L14
    L10:
        r107 = false;
        goto L11
    L33:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        int r102 = com.bytedance.android.window.shop.innerflow.presenter.a.f189179a[r101.ordinal()];
        if (r102 != 1) goto L5;
        com.bytedance.android.ec.window.base.utils.playable.controller.b r103 = this.f189169l;
        if (r103 == null) goto L16;
        r103.f49741e.b();
        return;
    L16:
        return;
    L5:
        if (r102 != 2) goto L17;
        com.bytedance.android.ec.window.base.utils.playable.controller.b r104 = this.f189169l;
        if (r104 == null) goto L14;
        r104.f49741e.d();
        return;
    L14:
        return;
    }
}
