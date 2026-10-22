package com.bytedance.android.shopping.store.search.presenter;

import androidx.fragment.app.Fragment;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.core.monitor.MonitorScenes;
import com.bytedance.android.ec.core.monitor.RecyclerViewPerformanceMonitor;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.store.product.holder.LayoutTypes;
import com.bytedance.android.ec.store.repository.vo.StoreV2ProductItemVO;
import com.bytedance.android.ec.store.search.recyclerview.WrapContentStaggeredGridLayoutManager;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.shopping.store.search.recyclerview.ShopSearchResultAdapter;
import com.bytedance.android.shopping.store.search.viewmodel.ShopSearchFragmentProductViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ShopSearchResultProductListPresenter extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ShopSearchFragmentProductViewModel f186043f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ShopSearchResultAdapter f186044g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f186045h;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShopSearchResultProductListPresenter f186046a;

        public a(ShopSearchResultProductListPresenter r100) {
            this.f186046a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            rg.a r101 = (rg.a) r100;
            ShopSearchResultAdapter r102 = this.f186046a.f186044g;
            if (r102 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        L5:
            r102.submitList(null);
        }
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShopSearchResultProductListPresenter f186047a;

        public b(ShopSearchResultProductListPresenter r100) {
            this.f186047a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            PagedList<T> r101 = (PagedList) r100;
            ShopSearchResultAdapter r102 = this.f186047a.f186044g;
            if (r102 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        L5:
            r102.submitList(r101);
        }
    }

    public static final class c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f186048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ShopSearchResultProductListPresenter f186049b;

        public c(RecyclerView r100, ShopSearchResultProductListPresenter r101) {
            this.f186048a = r100;
            this.f186049b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            LoadStatus r101 = (LoadStatus) r100;
            LoadStatus r102 = LoadStatus.InitializeSuccess;
            if (r101 != r102) goto L5;
            this.f186048a.postDelayed(new q(this), 1000);
        L5:
            if (r101 != r102) goto L7;
        L8:
            ShopSearchResultProductListPresenter r103 = this.f186049b;
            if (r103.f186045h == true) goto L16;
            int r104 = com.bytedance.android.ec.store.utils.h.f48668a;
            ShopSearchFragmentProductViewModel r105 = r103.f186043f;
            if (r105 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        L13:
            com.bytedance.android.ec.store.utils.h.d(z1.g(r105.getSearchParam().getEntranceInfo()), "othershow", "shop", ShopSearchResultProductListPresenter.e0(this.f186049b).getAdParams(), "search_ad");
            this.f186049b.f186045h = true;
            return;
        L16:
            return;
        L7:
            if (r101 == LoadStatus.InitializeEmpty) goto L8;
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShopSearchResultProductListPresenter f186050a;

        public d(ShopSearchResultProductListPresenter r100) {
            this.f186050a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (((rg.a) r100) != null) goto L6;
            return;
        L6:
            if (ShopSearchResultProductListPresenter.e0(this.f186050a).isPlayingVideo() == true) goto L9;
            ShopSearchResultProductListPresenter.d0(this.f186050a);
            return;
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShopSearchResultProductListPresenter f186051a;

        public e(ShopSearchResultProductListPresenter r100) {
            this.f186051a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            rg.a r101 = (rg.a) r100;
            if (r101 != null) goto L6;
            return;
        L6:
            if (((Boolean) r101.f537663b).booleanValue() == false) goto L8;
            ShopSearchResultProductListPresenter.d0(this.f186051a);
            return;
        L8:
            ShopSearchResultProductListPresenter.e0(this.f186051a).setPlayingVideo(false);
            boolean r102 = ECServiceManager.f42805a;
            s83.f r103 = ((s83.g) ECServiceManager.c(s83.g.class)).p();
            if (r103 == null) goto L13;
            r103.n(ShopSearchResultProductListPresenter.e0(this.f186051a).getSessionId());
            return;
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShopSearchResultProductListPresenter f186052a;

        public f(ShopSearchResultProductListPresenter r100) {
            this.f186052a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            LayoutTypes r101 = (LayoutTypes) r100;
            RecyclerView.LayoutManager r102 = ((RecyclerView) this.f186052a.Z().b(R.id.rv_product_list).f()).getLayoutManager();
            if (r102 == null) goto L9;
            int[] r103 = ((WrapContentStaggeredGridLayoutManager) r102).findFirstVisibleItemPositions(null);
            if (r103 == null) goto L10;
            int r104 = r103[0];
            this.f186052a.h0(r104);
            return;
        L10:
            return;
        L9:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.store.search.recyclerview.WrapContentStaggeredGridLayoutManager");
        }
    }

    public ShopSearchResultProductListPresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
    }

    public static final void d0(ShopSearchResultProductListPresenter r110) {
        ShopSearchFragmentProductViewModel r100 = r110.f186043f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r100.setPlayingVideo(false);
        RecyclerView r101 = (RecyclerView) r110.Z().b(R.id.rv_product_list).f();
        ShopSearchFragmentProductViewModel r102 = r110.f186043f;
        if (r102 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L8:
        PagedList<en.b> r103 = r102.getProducts().getValue();
        if (r103 == null) goto L11;
        int r104 = r103.size();
    L13:
        if (r104 >= 1) goto L15;
        return;
    L15:
        if (r101.getVisibility() != 0) goto L104;
        int[] r105 = new int[2];
        RecyclerView.LayoutManager r106 = ((RecyclerView) r110.Z().b(R.id.rv_product_list).f()).getLayoutManager();
        if ((r106 instanceof StaggeredGridLayoutManager) == true) goto L20;
        r106 = null;
    L20:
        StaggeredGridLayoutManager r107 = (StaggeredGridLayoutManager) r106;
        if (r107 == null) goto L23;
        r107.findFirstCompletelyVisibleItemPositions(r105);
    L23:
        Intrinsics.checkNotNullParameter(r105, "$this$getMinOrNull");
        int r108 = r105[0];
        int r109 = ArraysKt.getLastIndex(r105);
        if (1 > r109) goto L31;
        int r111 = 1;
    L26:
        int r112 = r105[r111];
        if (r108 <= r112) goto L29;
        r108 = r112;
    L29:
        if (r111 == r109) goto L31;
        r111 = r111 + 1;
    L31:
        Integer r113 = Integer.valueOf(r108);
        if (r113 != null) goto L40;
        RecyclerView.LayoutManager r114 = ((RecyclerView) r110.Z().b(R.id.rv_product_list).f()).getLayoutManager();
        if ((r114 instanceof LinearLayoutManager) == true) goto L36;
        r114 = null;
    L36:
        LinearLayoutManager r115 = (LinearLayoutManager) r114;
        if (r115 == null) goto L39;
        r113 = Integer.valueOf(r115.findFirstCompletelyVisibleItemPosition());
        goto L40
    L39:
        r113 = null;
    L40:
        int r116 = -1;
        if (r113 == null) goto L43;
        int r117 = r113.intValue();
    L44:
        Integer r118 = Integer.valueOf(r117);
        int r119 = r118.intValue();
        if (r119 < 0) goto L49;
        if (r104 <= r119) goto L49;
        boolean r120 = true;
    L50:
        if (r120 == true) goto L53;
        r118 = null;
    L53:
        int[] r121 = new int[2];
        RecyclerView.LayoutManager r122 = ((RecyclerView) r110.Z().b(R.id.rv_product_list).f()).getLayoutManager();
        if ((r122 instanceof StaggeredGridLayoutManager) == true) goto L56;
        r122 = null;
    L56:
        StaggeredGridLayoutManager r123 = (StaggeredGridLayoutManager) r122;
        if (r123 == null) goto L59;
        r123.findLastCompletelyVisibleItemPositions(r121);
    L59:
        Intrinsics.checkNotNullParameter(r121, "$this$getMaxOrNull");
        int r124 = r121[0];
        int r125 = ArraysKt.getLastIndex(r121);
        if (1 > r125) goto L67;
        int r126 = 1;
    L62:
        int r127 = r121[r126];
        if (r124 >= r127) goto L65;
        r124 = r127;
    L65:
        if (r126 == r125) goto L67;
        r126 = r126 + 1;
    L67:
        Integer r128 = Integer.valueOf(r124);
        if (r128 != null) goto L76;
        RecyclerView.LayoutManager r129 = ((RecyclerView) r110.Z().b(R.id.rv_product_list).f()).getLayoutManager();
        if ((r129 instanceof LinearLayoutManager) == true) goto L72;
        r129 = null;
    L72:
        LinearLayoutManager r130 = (LinearLayoutManager) r129;
        if (r130 == null) goto L75;
        r128 = Integer.valueOf(r130.findLastCompletelyVisibleItemPosition());
        goto L76
    L75:
        r128 = null;
    L76:
        if (r128 == null) goto L78;
        r116 = r128.intValue();
    L78:
        if (r118 == null) goto L101;
        int r131 = r118.intValue();
        if (r131 > r116) goto L102;
    L81:
        ShopSearchFragmentProductViewModel r132 = r110.f186043f;
        if (r132 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L84:
        PagedList<en.b> r133 = r132.getProducts().getValue();
        if (r133 == null) goto L94;
        en.b r134 = r133.get(r131);
        if (r134 == null) goto L94;
        if ((r134 instanceof en.a) == true) goto L92;
        r134 = null;
    L92:
        if (r134 == null) goto L94;
        ((en.a) r134).f473138b.f48437q.g(new StoreV2ProductItemVO.b(1));
        return;
    L94:
        if (r131 == r116) goto L105;
        r131 = r131 + 1;
        goto L81
    L105:
        return;
    L102:
        return;
    L101:
        return;
    L49:
        r120 = false;
        goto L50
    L43:
        r117 = -1;
        goto L44
    L104:
        return;
    L11:
        r104 = 0;
        goto L13
    }

    public static final /* synthetic */ ShopSearchFragmentProductViewModel e0(ShopSearchResultProductListPresenter r100) {
        ShopSearchFragmentProductViewModel r101 = r100.f186043f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r101;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        this.f186043f = (ShopSearchFragmentProductViewModel) Y().g(ShopSearchFragmentProductViewModel.class);
        h0(0);
        ShopSearchFragmentProductViewModel r101 = this.f186043f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        r101.getLayoutType().a(ECQuickUtilKt.a(Y()), new f(this), false);
    }

    public final void h0(int r100) {
        Fragment r101 = Y().f450890a;
        if (r101 == null) goto L51;
        final RecyclerView r102 = (RecyclerView) Z().b(R.id.rv_product_list).f();
        r102.setLayoutManager(new WrapContentStaggeredGridLayoutManager());
        RecyclerView.ItemAnimator r103 = r102.getItemAnimator();
        if (r103 == null) goto L7;
        r103.setAddDuration(0);
    L7:
        RecyclerView.ItemAnimator r104 = r102.getItemAnimator();
        if (r104 == null) goto L10;
        r104.setChangeDuration(0);
    L10:
        RecyclerView.ItemAnimator r105 = r102.getItemAnimator();
        if (r105 == null) goto L13;
        r105.setMoveDuration(0);
    L13:
        RecyclerView.ItemAnimator r106 = r102.getItemAnimator();
        if (r106 == null) goto L16;
        r106.setRemoveDuration(0);
    L16:
        RecyclerView.ItemAnimator r107 = r102.getItemAnimator();
        if ((r107 instanceof SimpleItemAnimator) == true) goto L19;
        r107 = null;
    L19:
        SimpleItemAnimator r108 = (SimpleItemAnimator) r107;
        if (r108 == null) goto L22;
        r108.setSupportsChangeAnimations(false);
    L22:
        ShopSearchFragmentProductViewModel r109 = this.f186043f;
        if (r109 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L25:
        LayoutTypes r110 = r109.getLayoutType().getValue();
        if (r110 != null) goto L28;
        r110 = LayoutTypes.RECYCLER_VIEW_ITEM_DOUBLE;
    L28:
        ShopSearchResultAdapter r111 = new ShopSearchResultAdapter(r101, r110);
        if (true == r111.f48195a) goto L31;
        r111.f48195a = true;
    L31:
        r111.registerAdapterDataObserver(new ShopSearchResultProductListPresenter$initRecyclerView$$inlined$let$lambda$1(r102, this));
        Unit r112 = Unit.INSTANCE;
        this.f186044g = r111;
        r102.setAdapter(r111);
        int r113 = com.bytedance.android.ec.store.widget.d.f48997a;
        ShopSearchFragmentProductViewModel r114 = this.f186043f;
        if (r114 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L34:
        com.bytedance.android.ec.store.widget.d.b(r102, r100, r114.getLayoutType().getValue());
        r102.addOnScrollListener(new RecyclerViewPerformanceMonitor(MonitorScenes.EC_SHOP_PRODUCTS));
        r102.addOnScrollListener(new ShopSearchResultProductListPresenter$initRecyclerView$$inlined$let$lambda$2(this));
        ShopSearchFragmentProductViewModel r115 = this.f186043f;
        if (r115 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L37:
        r115.getRefreshAction().a(ECQuickUtilKt.a(Y()), new a(this), false);
        ShopSearchFragmentProductViewModel r116 = this.f186043f;
        if (r116 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L40:
        r116.getProducts().observe(ECQuickUtilKt.a(Y()), new b(this));
        ShopSearchFragmentProductViewModel r117 = this.f186043f;
        if (r117 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L43:
        r117.getLoadStatus().b(ECQuickUtilKt.a(Y()), new c(r102, this));
        ShopSearchFragmentProductViewModel r118 = this.f186043f;
        if (r118 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L46:
        r118.getUpdateVideoDataAction().a(ECQuickUtilKt.a(Y()), new d(this), false);
        ShopSearchFragmentProductViewModel r119 = this.f186043f;
        if (r119 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L49:
        r119.getPlayVideoAction().a(ECQuickUtilKt.a(Y()), new e(this), false);
        return;
    }
}
