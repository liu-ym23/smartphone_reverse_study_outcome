package com.bytedance.android.shopping.store.shopfeed.presenter;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.shopping.store.shopfeed.list.ShopFeedListSnapHelper;
import com.bytedance.android.shopping.store.shopfeed.list.ShopMomentFlowListAdapter;
import com.bytedance.android.shopping.store.shopfeed.list.ShopMomentFlowLynxCardView;
import com.bytedance.android.shopping.store.shopfeed.viewmodel.ECShopFeedViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ECShopMomentFlowListPresenter extends QPresenter {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f186277m = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f186278e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f186279f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f186280g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ShopMomentFlowLynxCardView f186281h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ShopMomentFlowLynxCardView f186282i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ShopMomentFlowLynxCardView f186283j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ECShopMomentFlowListPresenter$onScrollListener$1 f186284k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Fragment f186285l;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r2v7, types: [com.bytedance.android.shopping.store.shopfeed.presenter.ECShopMomentFlowListPresenter$onScrollListener$1] */
    public ECShopMomentFlowListPresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f186285l = r100;
        this.f186278e = LazyKt.lazy(new ECShopMomentFlowListPresenter$viewModel$2(this));
        this.f186279f = LazyKt.lazy(new ECShopMomentFlowListPresenter$snapHelper$2(this));
        this.f186280g = LazyKt.lazy(new ECShopMomentFlowListPresenter$listAdapter$2(this));
        this.f186284k = new ECShopMomentFlowListPresenter$onScrollListener$1(this);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        RecyclerView r101 = (RecyclerView) com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(R.id.shop_feed_shop_list_rv));
        if (r101 == null) goto L5;
        int r102 = k.f186313a;
        k.a(r101, u().c(), "ECShopMomentFlowListPresenter", this.f186284k, (ShopMomentFlowListAdapter) this.f186280g.getValue(), (ShopFeedListSnapHelper) this.f186279f.getValue(), null);
    L5:
        LiveData<PagedList<com.bytedance.android.shopping.store.shopfeed.list.a>> r103 = ((ECShopFeedViewModel) this.f186278e.getValue()).getCardList();
        if (r103 == null) goto L9;
        r103.observe(ECQuickUtilKt.a(u()), new h(this));
        return;
    }
}
