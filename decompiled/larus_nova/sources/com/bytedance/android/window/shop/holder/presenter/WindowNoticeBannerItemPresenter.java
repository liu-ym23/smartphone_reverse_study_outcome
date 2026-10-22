package com.bytedance.android.window.shop.holder.presenter;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.window.shop.repository.tab.entity.k0;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class WindowNoticeBannerItemPresenter extends ECWindowHolderBaseFragmentPresenter {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f188105i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public k0 f188106j;

    public WindowNoticeBannerItemPresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f188105i = LazyKt.lazy(new WindowNoticeBannerItemPresenter$reportEventHelper$2(this));
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        if (r100 == null) goto L10;
        k0 r101 = (k0) r100;
        this.f188106j = r101;
        Unit r102 = (Unit) this.f188105i.getValue();
        View r103 = a0();
        if (r103 == null) goto L8;
        ((bp.a) r103).getTextView().setText(r101.f189593j);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.ec.window.base.recommend.widget.WindowRecommendBannerNoticeView");
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.window.shop.repository.tab.entity.WindowSyncNoticeBannerVO");
    }
}
