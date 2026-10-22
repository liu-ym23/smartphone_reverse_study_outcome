package com.bytedance.android.shopping.store.search.presenter;

import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.store.common.uiext.ExtensionsKt;
import com.bytedance.android.ec.store.search.history.HistoryBanner;
import com.bytedance.android.ec.store.search.history.HistoryChip;
import com.bytedance.android.ec.store.search.history.HistoryView;
import com.bytedance.android.shopping.store.home.presenter.ShopSearchBasePresenter;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\u0004\u001a\u00020\u0002H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/store/search/presenter/ShopSearchHistoryPresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ShopSearchBasePresenter;", "", "onResume", "onPause", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopSearchHistoryPresenter extends ShopSearchBasePresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public HistoryView f186012f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public HistoryBanner f186013g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f186014h;

    public static final class a implements HistoryView.c {
        public a() {
        }

        @Override // com.bytedance.android.ec.store.search.history.HistoryView.c
        public final HistoryChip.WrapCard a(HistoryChip r100) {
            Intrinsics.checkNotNullParameter(r100, "chip");
            if (ECShopABSettings.getEC_SHOP_SEARCH_GUIDE_STYLE() == 0) goto L16;
            HistoryChip.Style r101 = r100.getStyle();
            HistoryChip.Style r102 = HistoryChip.Style.TEXT;
            if (r101 != r102) goto L9;
            int r103 = ((k1.l() - (ExtensionsKt.a(16) * 2)) - ExtensionsKt.a(16)) / 2;
            TextView r104 = r100.getContentTv();
            if (r104 == null) goto L9;
            r104.setPadding(ExtensionsKt.a(10), ExtensionsKt.a(6), ExtensionsKt.a(10), ExtensionsKt.a(6));
            r104.setTextColor((int) 3205896227L);
            r104.setMaxWidth(r103);
        L9:
            HistoryChip.WrapCard r105 = new HistoryChip.WrapCard(r100.getContext(), r100, false);
            if (r100.getStyle() != r102) goto L12;
            FrameLayout.LayoutParams r106 = new FrameLayout.LayoutParams(-2, -2);
        L13:
            r106.gravity = 17;
            r105.addView(r100, r106);
            r105.setElevation(0.0f);
            r105.setCardBackgroundColor(219551779);
            r105.getViewTreeObserver().addOnGlobalLayoutListener(new b(r105));
            return r105;
        L12:
            r106 = new FrameLayout.LayoutParams(ExtensionsKt.a(22), ExtensionsKt.a(22));
            goto L13
        L16:
            return HistoryChip.c(r100);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        HistoryBanner r100 = this.f186013g;
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        HistoryView r100 = this.f186012f;
        if (r100 == null) goto L5;
        r100.removeAllViews();
        r100.f48547b = null;
        r100.f48549d = 3;
        r100.f48548c = false;
    L5:
        HistoryBanner r101 = this.f186013g;
        if (r101 == null) goto L9;
        r101.setVisibility(8);
        return;
    }

    public ShopSearchHistoryPresenter() {
        this.f186014h = new a();
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void A(QModel r100) {
        HistoryView r101 = (HistoryView) w().b(R.id.commerce_store_search_history_view).f();
        this.f186012f = r101;
        r101.setHistoryChipInitializer(this.f186014h);
        this.f186013g = (HistoryBanner) w().b(R.id.commerce_store_search_history_banner).f();
        if (ECShopABSettings.getEC_SHOP_SEARCH_GUIDE_STYLE() == 0) goto L7;
        HistoryBanner r102 = this.f186013g;
        if (r102 == null) goto L10;
        r102.setDeleteIcon(R.drawable.shopping_ic_store_v3_history_banner_delete_v2);
    L10:
        HistoryBanner r103 = this.f186013g;
        if (r103 == null) goto L13;
        r103.setActionPerformListener(new c(this));
    L13:
        HistoryView r104 = this.f186012f;
        if (r104 == null) goto L16;
        r104.setActionListener(new g(this));
    L16:
        E().doEventAction("search_history", new Pair[]{TuplesKt.to("action_type", "show"), TuplesKt.to("enter_from", "search_store")});
        ECQuickUtilKt.a(u()).getLifecycle().addObserver(this);
        E().getPostKeyword().a(ECQuickUtilKt.a(u()), new d(this), false);
        E().getStoreSearchHistories().b(ECQuickUtilKt.a(u()), new e(this));
        E().getHistoryEditing().b(ECQuickUtilKt.a(u()), new f(this));
        return;
    L7:
        HistoryBanner r105 = this.f186013g;
        if (r105 == null) goto L10;
        r105.setDeleteIcon(R.drawable.shopping_ic_store_v3_history_banner_delete);
        goto L10
    }
}
