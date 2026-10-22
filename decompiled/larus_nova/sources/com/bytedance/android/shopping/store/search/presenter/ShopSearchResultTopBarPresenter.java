package com.bytedance.android.shopping.store.search.presenter;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.d2;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.store.search.activity.ECShopSearchActivity;
import com.bytedance.android.shopping.store.search.router.ECShopSearchParam;
import com.bytedance.android.shopping.store.search.viewmodel.ShopSearchResultViewModel;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class ShopSearchResultTopBarPresenter extends QPresenter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f186056e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Fragment f186057f;

    public final ShopSearchResultViewModel F() {
        return (ShopSearchResultViewModel) this.f186056e.getValue();
    }

    public ShopSearchResultTopBarPresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f186057f = r100;
        this.f186056e = LazyKt.lazy(new ShopSearchResultTopBarPresenter$viewModel$2(this));
    }

    public static final void D(ShopSearchResultTopBarPresenter r100) {
        r100.F().getSearchParam().setSearchKeyword("");
        Intent r101 = new Intent(r100.u().c(), ECShopSearchActivity.class);
        ECShopSearchParam r102 = r100.F().getSearchParam();
        if (r102 == null) goto L9;
        r101.putExtra("search_param", r102);
        ContextCompat.startActivity(r100.u().c(), r101, null);
        Activity r103 = com.bytedance.android.ec.core.utils.l0.b(r100.u().c());
        if (r103 == null) goto L10;
        r103.finish();
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type java.io.Serializable");
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r110) {
        ((ImageView) y().findViewById(R.id.commerce_store_search_result_back)).setOnClickListener(new r(this));
        if (F().getSearchParam().isSplitMode() == false) goto L13;
        View r111 = y().findViewById(R.id.commerce_store_search_top_bar_container);
        if (r111 == null) goto L7;
        d2.d(r111, 0, ExtensionsKt.getDp(8), 0, ExtensionsKt.getDp(8));
    L7:
        View r112 = y().findViewById(R.id.commerce_store_search_title_bg);
        if (r112 == null) goto L10;
        d2.d(r112, 0, 0, ExtensionsKt.getDp(8), 0);
    L10:
        View r113 = y().findViewById(R.id.commerce_store_search_result_back);
        if (r113 == null) goto L13;
        d2.d(r113, ExtensionsKt.getDp(7), 0, ExtensionsKt.getDp(0), 0);
    L13:
        View r114 = y().findViewById(R.id.ec_store_fold_close_btn);
        if (F().getSearchParam().isSplitMode() == false) goto L16;
        ExtensionsKt.visible(r114);
        r114.setOnClickListener(new s(this));
    L16:
        View r115 = y().findViewById(R.id.commerce_store_search_close);
        r115.setVisibility(8);
        r115.setOnClickListener(new t(this));
        View r116 = y().findViewById(R.id.commerce_store_search_camera);
        Lazy r100 = ECAppInfoService.f48110a;
        if (we.a.f559330a == true) goto L19;
        r116.setVisibility(0);
        F().doAnyEventActionWithBtm("a1.b7881.c59185.d28713", PageFinder.via(r116), "photo_search_icon_show", MapsKt.mapOf(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, F().getSearchParam().getEntranceInfo()), TuplesKt.to("current_page", "shop_search_page")}), new Pair[0]);
    L20:
        r116.setOnClickListener(new u(r116, this));
        TextView r117 = (TextView) y().findViewById(R.id.commerce_store_search_input);
        r117.setText(F().getSearchParam().getSearchKeyword());
        F().getData().putExtra("sug_enter_type", 1);
        r117.setOnClickListener(new v(this));
        View r118 = y().findViewById(R.id.status_bar);
        if (r118 == null) goto L24;
        int r101 = com.bytedance.android.ec.core.utils.j.f45614a;
        com.bytedance.android.ec.core.utils.j.a.a(r118);
        return;
    L24:
        return;
    L19:
        r116.setVisibility(8);
        goto L20
    }

    public static final void E(ShopSearchResultTopBarPresenter r100, int r101) {
        r100.F().setMToNewPage(false);
        r100.F().getData().putExtra("sug_gap_time", SystemClock.elapsedRealtime() - r100.F().getMRecordTime());
        Activity r102 = com.bytedance.android.ec.core.utils.l0.b(r100.u().c());
        if (r102 == null) goto L5;
        r102.setResult(r101, r100.F().getData());
    L5:
        Activity r103 = com.bytedance.android.ec.core.utils.l0.b(r100.u().c());
        if (r103 == null) goto L9;
        r103.finish();
        return;
    }
}
