package com.bytedance.android.livesdk.livecommerce.playback.header;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.arch.lifecycle.g;
import com.bytedance.android.ec.core.arch.state.c;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ExplainPlaybackHeaderPresenter extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f149884f;

    public final ExplainPlaybackViewModel d0() {
        return (ExplainPlaybackViewModel) this.f149884f.getValue();
    }

    public ExplainPlaybackHeaderPresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f149884f = LazyKt.lazy(new ExplainPlaybackHeaderPresenter$viewModel$2(this));
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        c.a(d0(), g.a(Y()), ExplainPlaybackHeaderPresenter$onBind$1.INSTANCE, new ExplainPlaybackHeaderPresenter$onBind$2(this));
        c.a(d0(), g.a(Y()), ExplainPlaybackHeaderPresenter$onBind$3.INSTANCE, new ExplainPlaybackHeaderPresenter$onBind$4(this));
        c.a(d0(), g.a(Y()), ExplainPlaybackHeaderPresenter$observeTopRight$1.INSTANCE, new ExplainPlaybackHeaderPresenter$observeTopRight$2(this));
    }
}
