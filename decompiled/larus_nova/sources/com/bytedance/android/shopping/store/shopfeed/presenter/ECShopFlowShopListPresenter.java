package com.bytedance.android.shopping.store.shopfeed.presenter;

import android.view.View;
import androidx.camera.video.AudioStats;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.bytedance.android.shopping.store.shopfeed.ShopFeedParam;
import com.bytedance.android.shopping.store.shopfeed.list.ShopFeedListAdapter;
import com.bytedance.android.shopping.store.shopfeed.list.ShopFeedListSnapHelper;
import com.bytedance.android.shopping.store.shopfeed.list.ShopFlowLynxCardView;
import com.bytedance.android.shopping.store.shopfeed.viewmodel.ECShopFeedViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class ECShopFlowShopListPresenter extends QPresenter {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f186248k = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f186249e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f186250f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f186251g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f186252h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ECShopFlowShopListPresenter$onScrollListener$1 f186253i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Fragment f186254j;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.android.shopping.store.shopfeed.presenter.ECShopFlowShopListPresenter$onScrollListener$1] */
    public ECShopFlowShopListPresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f186254j = r100;
        this.f186249e = LazyKt.lazy(new ECShopFlowShopListPresenter$viewModel$2(this));
        this.f186250f = LazyKt.lazy(new ECShopFlowShopListPresenter$snapHelper$2(this));
        this.f186251g = LazyKt.lazy(new ECShopFlowShopListPresenter$listAdapter$2(this));
        this.f186252h = LazyKt.lazy(ECShopFlowShopListPresenter$itemDecoration$2.INSTANCE);
        this.f186253i = new ECShopFlowShopListPresenter$onScrollListener$1(this);
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        RecyclerView r101 = (RecyclerView) com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(R.id.shop_feed_shop_list_rv));
        if (r101 == null) goto L5;
        int r102 = k.f186313a;
        k.a(r101, u().c(), "ECShopFeedShopListPresenter", this.f186253i, (ShopFeedListAdapter) this.f186251g.getValue(), (ShopFeedListSnapHelper) this.f186250f.getValue(), (ECShopFlowShopListPresenter$itemDecoration$2.AnonymousClass1) this.f186252h.getValue());
    L5:
        LiveData<PagedList<com.bytedance.android.shopping.store.shopfeed.list.a>> r103 = ((ECShopFeedViewModel) this.f186249e.getValue()).getCardList();
        if (r103 == null) goto L8;
        r103.observe(ECQuickUtilKt.a(u()), new c(this));
    L8:
        ShopFeedParam r104 = ((ECShopFeedViewModel) this.f186249e.getValue()).getShopFeedParam();
        if (r104 == null) goto L11;
        Integer r105 = r104.getTabType();
    L12:
        int r106 = TabEnum.SHOP_INNER_FLOW_PAGE.getType();
        if (r105 != null) goto L16;
        return;
    L16:
        if (r105.intValue() != r106) goto L19;
        w().b(R.id.shop_feed_back_button).f().setVisibility(8);
        return;
    L19:
        return;
    L11:
        r105 = null;
        goto L12
    }

    public static double E(View r100, RecyclerView r101) {
        return RangesKt.coerceAtMost(RangesKt.coerceAtLeast(((double) (RangesKt.coerceAtMost(r100.getBottom(), r101.getHeight()) - RangesKt.coerceAtLeast(r100.getTop(), 0))) / ((double) r100.getHeight()), AudioStats.AUDIO_AMPLITUDE_NONE), 1.0d);
    }

    public static final void D(ECShopFlowShopListPresenter r110, ShopFlowLynxCardView r111, RecyclerView r112, String r113) {
        r110.getClass();
        Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L24
        double r100 = E(r111, r112);     // Catch: Throwable -> L24
        boolean r115 = false;
        if (r100 > 0) goto L7;
    L22:
        JSONObject r116 = new JSONObject();     // Catch: Throwable -> L24
        r116.put("show_percent", r100);     // Catch: Throwable -> L24
        r116.put(com.bytedance.android.ec.core.event.a.KEY_SCROLL_DIRECTION, r113);     // Catch: Throwable -> L24
        Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L24
        r111.c("ecom.shop_flow.card_scroll", r116);     // Catch: Throwable -> L24
        r111.setShowPercent(r100);     // Catch: Throwable -> L24
        return;
    L7:
        if (r100 >= 1) goto L22;
        if (r100 > 0.5d) goto L12;
        boolean r101 = true;
    L14:
        if (r111.getShowPercent() > 0.5d) goto L16;
        r115 = true;
    L16:
        if (r101 == false) goto L18;
        if (r115 == true) goto L18;
    L20:
        JSONObject r118 = new JSONObject();     // Catch: Throwable -> L24
        r118.put("show_percent", r100);     // Catch: Throwable -> L24
        r118.put(com.bytedance.android.ec.core.event.a.KEY_SCROLL_DIRECTION, r113);     // Catch: Throwable -> L24
        Unit r119 = Unit.INSTANCE;     // Catch: Throwable -> L24
        r111.c("ecom.shop_flow.card_scroll", r118);     // Catch: Throwable -> L24
    L21:
        r111.setShowPercent(r100);     // Catch: Throwable -> L24
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L24
        return;
    L18:
        if (r101 == true) goto L21;
        if (r115 == false) goto L21;
    L12:
        r101 = false;
    L24:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }
}
