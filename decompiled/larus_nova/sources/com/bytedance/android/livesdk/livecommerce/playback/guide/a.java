package com.bytedance.android.livesdk.livecommerce.playback.guide;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.ec.core.widget.d;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f149875g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ LottieAnimationView f149876h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ FrameLayout f149877i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ ExplainPlaybackGuidePresenter f149878j;

    @Override // com.bytedance.android.ec.core.widget.d
    public final void a(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        ExplainPlaybackGuidePresenter.d0(this.f149878j);
        this.f149876h.removeAllUpdateListeners();
        this.f149875g.removeView(this.f149877i);
    }

    public a(ViewGroup r100, LottieAnimationView r101, FrameLayout r102, ExplainPlaybackGuidePresenter r103) {
        this.f149875g = r100;
        this.f149876h = r101;
        this.f149877i = r102;
        this.f149878j = r103;
        super(null, null, 3);
    }
}
