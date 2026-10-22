package com.bytedance.android.shopping.store.shopfeed.presenter;

import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.store.shopping.paging.LoadStatus;
import com.bytedance.android.ec.store.status.LazyStatusView;
import com.bytedance.android.shopping.store.shopfeed.ShopFeedParam;
import com.bytedance.android.shopping.store.shopfeed.viewmodel.ECShopFeedViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public class BaseShopFeedStatusPresenter extends QPresenter {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f186241i = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f186242e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameLayout f186243f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f186244g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Fragment f186245h;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseShopFeedStatusPresenter f186246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f186247b;

        public b(BaseShopFeedStatusPresenter r100, Map r101) {
            this.f186246a = r100;
            this.f186247b = r101;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r110) {
            LoadStatus r111 = (LoadStatus) r110;
            long r100 = System.currentTimeMillis();
            Long r101 = this.f186246a.F().getRouterStartTime();
            if (r101 == null) goto L5;
            long r102 = r101.longValue();
        L6:
            long r103 = r100 - r102;
            if (r111 == null) goto L16;
            int r112 = com.bytedance.android.shopping.store.shopfeed.presenter.b.f186305a[r111.ordinal()];
            if (r112 == 1) goto L32;
            if (r112 != 2) goto L13;
            FrameLayout r113 = this.f186246a.f186243f;
            if (r113 == null) goto L31;
            r113.setVisibility(8);
        L31:
            this.f186246a.F().doAnyEventAction("shop_feed_show_first_lynx_card", this.f186247b, new Pair[]{TuplesKt.to("status", "success"), TuplesKt.to(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(r103))});
            return;
        L13:
            if (r112 != 3) goto L15;
            FrameLayout r114 = this.f186246a.f186243f;
            if (r114 == null) goto L27;
            r114.setVisibility(0);
        L27:
            this.f186246a.E().b(com.bytedance.android.ec.store.status.b.C0841b.f48652a);
            this.f186246a.F().doAnyEventAction("shop_feed_show_first_lynx_card", this.f186247b, new Pair[]{TuplesKt.to("status", "error"), TuplesKt.to(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(r103))});
            return;
        L15:
            if (r112 != 4) goto L16;
            FrameLayout r115 = this.f186246a.f186243f;
            if (r115 == null) goto L23;
            r115.setVisibility(0);
        L23:
            this.f186246a.E().b(com.bytedance.android.ec.store.status.b.a.f48651a);
            this.f186246a.F().doAnyEventAction("shop_feed_show_first_lynx_card", this.f186247b, new Pair[]{TuplesKt.to("status", "empty"), TuplesKt.to(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(r103))});
            return;
        L32:
            FrameLayout r116 = this.f186246a.f186243f;
            if (r116 == null) goto L35;
            r116.setVisibility(0);
        L35:
            this.f186246a.E().b(com.bytedance.android.ec.store.status.b.c.f48653a);
            return;
        L16:
            FrameLayout r117 = this.f186246a.f186243f;
            if (r117 == null) goto L19;
            r117.setVisibility(8);
        L19:
            this.f186246a.F().doAnyEventAction("shop_feed_show_first_lynx_card", this.f186247b, new Pair[]{TuplesKt.to("status", "undefined"), TuplesKt.to(HiAnalyticsConstant.BI_KEY_COST_TIME, Long.valueOf(r103))});
            return;
        L5:
            r102 = 0;
            goto L6
        }
    }

    static {
    }

    public final LazyStatusView E() {
        return (LazyStatusView) this.f186244g.getValue();
    }

    public final ECShopFeedViewModel F() {
        return (ECShopFeedViewModel) this.f186242e.getValue();
    }

    public BaseShopFeedStatusPresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f186245h = r100;
        this.f186242e = LazyKt.lazy(new BaseShopFeedStatusPresenter$viewModel$2(this));
        this.f186244g = LazyKt.lazy(new BaseShopFeedStatusPresenter$statusView$2(this));
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public void A(QModel r100) {
        FrameLayout r101 = (FrameLayout) com.bytedance.android.ec.store.product.presenter.utils.f.a(w().b(R.id.shop_feed_status_container));
        Integer r102 = null;
        if (r101 == null) goto L5;
        r101.addView(E());
        Unit r103 = Unit.INSTANCE;
    L6:
        this.f186243f = r101;
        E().setCreators(MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.store.status.b.C0841b.f48652a, new com.bytedance.android.ec.store.status.c(new BaseShopFeedStatusPresenter$onBind$2(this), null, 6)), TuplesKt.to(com.bytedance.android.ec.store.status.b.a.f48651a, new com.bytedance.android.ec.store.status.c(new BaseShopFeedStatusPresenter$onBind$3(this), null, 6)), TuplesKt.to(com.bytedance.android.ec.store.status.b.c.f48653a, new com.bytedance.android.ec.store.status.c(new BaseShopFeedStatusPresenter$onBind$4(this), null, 6))}));
        ShopFeedParam r104 = F().getShopFeedParam();
        if (r104 == null) goto L9;
        r102 = r104.getTabType();
    L9:
        F().getLoadStatus().b(ECQuickUtilKt.a(u()), new b(this, MapsKt.mapOf(TuplesKt.to("tab_type", r102))));
        return;
    L5:
        r101 = null;
        goto L6
    }

    public View D(LazyStatusView r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        return th.a.c(u().c(), R.layout.ec_shop_feed_status_loading, r100, false);
    }
}
