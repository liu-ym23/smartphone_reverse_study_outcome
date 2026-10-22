package com.bytedance.android.livesdk.livecommerce.playback.guide;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.arch.lifecycle.g;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ExplainPlaybackGuidePresenter extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ExplainPlaybackViewModel f149874f;

    public ExplainPlaybackGuidePresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
    }

    public static final void d0(ExplainPlaybackGuidePresenter r100) {
        r100.getClass();
        bj2.a.b("ExplainPlaybackGuidePresenter", "hideBigProductCard");
        int r101 = com.bytedance.android.livesdk.livecommerce.playback.utils.a.f149979a;
        q.f48131a.c("ec_commerce_playback_live_guide_show", true);
        ExplainPlaybackViewModel r102 = r100.f149874f;
        if (r102 == null) goto L6;
        com.bytedance.android.ec.core.arch.event.c.d(r102, new com.bytedance.android.livesdk.livecommerce.playback.main.a.k());
        return;
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        ExplainPlaybackViewModel r101 = (ExplainPlaybackViewModel) Y().g(ExplainPlaybackViewModel.class);
        this.f149874f = r101;
        if (r101 == null) goto L6;
        com.bytedance.android.ec.core.arch.state.c.a(r101, g.a(Y()), ExplainPlaybackGuidePresenter$onBind$1.INSTANCE, new ExplainPlaybackGuidePresenter$onBind$2(this));
        return;
    }
}
