package com.bytedance.android.livesdk.livecommerce.playback.banner;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.arch.state.c;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ExplainPlaybackTopBannerPresenter extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f149791f;

    public ExplainPlaybackTopBannerPresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f149791f = LazyKt.lazy(new ExplainPlaybackTopBannerPresenter$viewModel$2(this));
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        c.a((ExplainPlaybackViewModel) this.f149791f.getValue(), Y().e(), ExplainPlaybackTopBannerPresenter$onBind$1.INSTANCE, new ExplainPlaybackTopBannerPresenter$onBind$2(this));
    }
}
