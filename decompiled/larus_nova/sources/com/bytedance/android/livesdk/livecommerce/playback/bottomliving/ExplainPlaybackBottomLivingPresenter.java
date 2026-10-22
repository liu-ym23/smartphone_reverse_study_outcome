package com.bytedance.android.livesdk.livecommerce.playback.bottomliving;

import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.ec.core.arch.lifecycle.g;
import com.bytedance.android.ec.core.arch.state.c;
import com.bytedance.android.livesdk.livecommerce.playback.main.ExplainPlaybackViewModel;
import com.bytedance.android.livesdk.livecommerce.playback.video.ExplainPlaybackVideoViewModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class ExplainPlaybackBottomLivingPresenter extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public FrameLayout f149803f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ExplainPlaybackVideoViewModel f149804g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f149805h;

    public ExplainPlaybackBottomLivingPresenter(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f149805h = LazyKt.lazy(new ExplainPlaybackBottomLivingPresenter$viewModel$2(this));
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        this.f149804g = (ExplainPlaybackVideoViewModel) Y().g(ExplainPlaybackVideoViewModel.class);
        this.f149803f = (FrameLayout) Z().b(R.id.commerce_playback_show_living_room_bottom_container).f();
        final TextView r101 = (TextView) Z().b(R.id.ec_commerce_playback_show_living_room_bottom).f();
        LottieAnimationView r102 = (LottieAnimationView) Z().b(R.id.explaining_douyin).f();
        r102.setVisibility(0);
        r102.setAnimation("ec_live_explain_lottie.json");
        r102.setRepeatCount(-1);
        r102.playAnimation();
        final FrameLayout r103 = this.f149803f;
        if (r103 == null) goto L6;
        r103.setVisibility(0);
        c.a((ExplainPlaybackViewModel) this.f149805h.getValue(), g.a(Y()), ExplainPlaybackBottomLivingPresenter$onBind$1$1.INSTANCE, new ExplainPlaybackBottomLivingPresenter$onBind$$inlined$let$lambda$1(r103, this, r101));
        return;
    }
}
