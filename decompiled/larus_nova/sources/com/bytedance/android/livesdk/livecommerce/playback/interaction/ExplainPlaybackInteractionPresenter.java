package com.bytedance.android.livesdk.livecommerce.playback.interaction;

import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes10.dex */
public final class ExplainPlaybackInteractionPresenter extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f149890f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public InteractionAutoRecycleView f149891g;

    public ExplainPlaybackInteractionPresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f149890f = LazyKt.lazy(new ExplainPlaybackInteractionPresenter$viewModel$2(this));
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        if (ECLiveABUtils.INSTANCE.getECOM_ENABLE_REPLAY_INTERACTION() == true) goto L5;
        return;
    L5:
        Z().g(0);
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-1, UtilityKotlinExtentionsKt.d(80));
        r101.leftMargin = UtilityKotlinExtentionsKt.d(12);
        r101.rightMargin = UtilityKotlinExtentionsKt.d(80);
        r101.bottomMargin = UtilityKotlinExtentionsKt.d(8);
        this.f149891g = new InteractionAutoRecycleView(Y().c());
        View r102 = a0();
        if ((r102 instanceof FrameLayout) == true) goto L8;
        r102 = null;
    L8:
        FrameLayout r103 = (FrameLayout) r102;
        if (r103 == null) goto L11;
        r103.addView(this.f149891g, r101);
    L11:
        com.bytedance.android.ec.core.arch.state.c.a((ExplainPlaybackViewModel) this.f149890f.getValue(), Y().e(), ExplainPlaybackInteractionPresenter$onBind$1.INSTANCE, new ExplainPlaybackInteractionPresenter$onBind$2(this));
        com.bytedance.android.ec.core.arch.event.c.c((ExplainPlaybackViewModel) this.f149890f.getValue(), Y().e(), Reflection.getOrCreateKotlinClass(com.bytedance.android.livesdk.livecommerce.playback.main.a.b.class), new ExplainPlaybackInteractionPresenter$onBind$3(this));
    }
}
