package com.bytedance.android.livesdk.livecommerce.playback.subtitle;

import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.core.arch.state.c;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes10.dex */
public final class ExplainPlaybackSubTitlePresenter extends QFragmentPresenter {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f149969g = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f149970f;

    public static final class a {
    }

    static {
    }

    public final ExplainPlaybackViewModel d0() {
        return (ExplainPlaybackViewModel) this.f149970f.getValue();
    }

    public ExplainPlaybackSubTitlePresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f149970f = LazyKt.lazy(new ExplainPlaybackSubTitlePresenter$viewModel$2(this));
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        if (d0().canEnableSubTitle() == true) goto L5;
        return;
    L5:
        c.a(d0(), Y().e(), ExplainPlaybackSubTitlePresenter$onBind$1.INSTANCE, new ExplainPlaybackSubTitlePresenter$onBind$2(this));
        com.bytedance.android.ec.core.arch.event.c.c(d0(), Y().e(), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.playback.main.a.m.class), new ExplainPlaybackSubTitlePresenter$onBind$3(this));
        com.bytedance.android.ec.core.arch.event.c.c(d0(), Y().e(), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.playback.main.a.b.class), new ExplainPlaybackSubTitlePresenter$onBind$4(this));
    }
}
