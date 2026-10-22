package com.bytedance.android.livesdk.livecommerce.playback.tip;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.arch.lifecycle.g;
import com.bytedance.android.ec.core.arch.state.c;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ExplainPlaybackTipPresenter extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ExplainPlaybackViewModel f149972f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final bk2.b f149973g;

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void c0() {
        this.f149973g.clearDisposable();
    }

    public ExplainPlaybackTipPresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f149973g = new bk2.b();
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        ExplainPlaybackViewModel r101 = (ExplainPlaybackViewModel) Y().g(ExplainPlaybackViewModel.class);
        this.f149972f = r101;
        if (r101 == null) goto L6;
        c.a(r101, g.a(Y()), ExplainPlaybackTipPresenter$onBind$1.INSTANCE, new ExplainPlaybackTipPresenter$onBind$2(this));
        return;
    }
}
