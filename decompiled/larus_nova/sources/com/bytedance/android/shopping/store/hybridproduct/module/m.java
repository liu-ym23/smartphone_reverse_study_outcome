package com.bytedance.android.shopping.store.hybridproduct.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.hybridproduct.presenter.ECShopRecommendDividerLinePresenter;
import com.bytedance.android.shopping.store.recommend.widget.ShopRecommendDividerView;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class m extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Fragment f185147l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ShopRecommendDividerView f185148m;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new ECShopRecommendDividerLinePresenter(this.f185147l, this.f185148m);
    }

    public m(Fragment r100, ShopRecommendDividerView r101) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "dividerView");
        super(-1, null);
        this.f185147l = r100;
        this.f185148m = r101;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f185148m;
    }
}
