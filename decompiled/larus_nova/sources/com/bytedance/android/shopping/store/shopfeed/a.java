package com.bytedance.android.shopping.store.shopfeed;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.android.shopping.store.shopfeed.presenter.ECShopFlowShopListPresenter;
import com.bytedance.android.shopping.store.shopfeed.presenter.ECShopFlowTopBarPresenter;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.presenter.QGroupPresenter;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class a extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f186155l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Fragment f186156m;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        QGroupPresenter r100 = new QGroupPresenter();
        r100.a(new ECShopFlowTopBarPresenter(this.f186156m));
        r100.a(new ECShopFlowShopListPresenter(this.f186156m));
        r100.a(new b(this.f186156m));
        return r100;
    }

    public a(View r100, Fragment r101) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        super(0);
        this.f186155l = r100;
        this.f186156m = r101;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f186155l;
    }
}
