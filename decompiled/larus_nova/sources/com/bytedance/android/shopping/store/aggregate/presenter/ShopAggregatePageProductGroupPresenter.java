package com.bytedance.android.shopping.store.aggregate.presenter;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.store.status.DefaultStoreTadLoadingStatusView;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.bytedance.android.shopping.store.aggregate.AggregatePageTypes;
import com.bytedance.android.shopping.store.aggregate.ShopAggregateProductListFragment;
import com.bytedance.android.shopping.store.aggregate.viewmodel.ShopAggregatePageProductViewModel;
import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductListPresenter;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.google.gson.Gson;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/store/aggregate/presenter/ShopAggregatePageProductGroupPresenter;", "Lcom/ss/android/ugc/aweme/kiwi/presenter/QFragmentPresenter;", "Landroidx/lifecycle/LifecycleObserver;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopAggregatePageProductGroupPresenter extends QFragmentPresenter implements LifecycleObserver {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f183436f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f183437g;

    public final ShopAggregatePageProductViewModel d0() {
        return (ShopAggregatePageProductViewModel) this.f183436f.getValue();
    }

    public ShopAggregatePageProductGroupPresenter(final ShopAggregateProductListFragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f183436f = LazyKt.lazy(new ShopAggregatePageProductGroupPresenter$viewModel$2(this, r100));
    }

    /* JADX WARN: Type inference failed for: r1v8, types: [T, android.view.View] */
    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r110) {
        Context r100 = th.a.e(Y().c(), true);
        final ViewGroup r101 = (ViewGroup) Z().b(R.id.undertake_product_list_status).f();
        List r111 = null;
        LazyStatusView r102 = new LazyStatusView(r100, null);
        r101.addView(r102);
        int r103 = 0;
        r102.setCreators(MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.store.status.b.a.f48651a, new com.bytedance.android.ec.store.status.c(new ShopAggregatePageProductGroupPresenter$initOptStatusView$1(this, r101), null, 6)), TuplesKt.to(com.bytedance.android.ec.store.status.b.C0841b.f48652a, new com.bytedance.android.ec.store.status.c(new ShopAggregatePageProductGroupPresenter$initOptStatusView$2(this, r101), null, 6))}));
        r102.a(new DefaultStoreTadLoadingStatusView(r100).a());
        Ref.ObjectRef r104 = new Ref.ObjectRef();
        r104.element = Z().b(R.id.undertake_rv_product_list).f();
        d0().getLoadStatus().b(ECQuickUtilKt.a(Y()), new i(this, r101, r102, r100, r104));
        String r105 = d0().getStoreParam().getTagData();
        if (r105 != null) goto L23;
    L8:
        if (r111 == null) goto L16;
        if (Intrinsics.areEqual(d0().getStoreParam().getPageType(), AggregatePageTypes.FULL_DISCOUNT.getType()) == false) goto L16;
        if (r111.size() <= 1) goto L16;
        wg.a.f(Z().b(R.id.store_sort_bar).f(), 0, 0, 0, 0);
    L16:
        if (Intrinsics.areEqual(d0().getStoreParam().getPageType(), AggregatePageTypes.CLASSIFICATION.getType()) == true) goto L18;
        return;
    L18:
        if (d0().getStoreParam().getShowCategoryTab() == true) goto L21;
        r103 = 16;
    L21:
        RelativeLayout r112 = (RelativeLayout) Z().b(R.id.rl_all_product_area).f();
        int r106 = ECShopHybridProductListPresenter.O;
        GradientDrawable r107 = ECShopHybridProductListPresenter.a.a(r103);
        Intrinsics.checkNotNullParameter(r112, "$this$setBackgroundCompat");
        r112.setBackground(r107);
        return;
    L23:
        r111 = (List) new Gson().fromJson(r105, new h().getType());     // Catch: Exception -> L7
        goto L8
    }
}
