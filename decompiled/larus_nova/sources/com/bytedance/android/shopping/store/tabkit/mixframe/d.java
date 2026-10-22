package com.bytedance.android.shopping.store.tabkit.mixframe;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.kiwi.presenter.QIPresenter;
import com.ss.android.ugc.aweme.kiwi.ui.QUIModule;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends QUIModule {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final View f186787l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Fragment f186788m;

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final QIPresenter h() {
        return new MixFrameLoadMorePresenter(this.f186788m);
    }

    public d(View r100, Fragment r101) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        super(-1, null);
        this.f186787l = r100;
        this.f186788m = r101;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.ui.QUIModule
    public final View f(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return this.f186787l;
    }
}
