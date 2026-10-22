package com.bytedance.android.livesdk.chatroom.replay.castscreen.bytecast;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastLoadingView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class ReplayCastLoadingView implements ILiveCastLoadingView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f108221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f108222b;

    @Override // com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastLoadingView
    public final View getView() {
        return (LiveDoubleColorBallAnimationView) this.f108221a.getValue();
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastLoadingView
    public final boolean isAnimating() {
        return ((LiveDoubleColorBallAnimationView) this.f108221a.getValue()).a();
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastLoadingView
    public final void startAnimation() {
        ((LiveDoubleColorBallAnimationView) this.f108221a.getValue()).b();
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastLoadingView
    public final void stopAnimation() {
        ((LiveDoubleColorBallAnimationView) this.f108221a.getValue()).c();
    }

    public ReplayCastLoadingView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f108222b = r100;
        this.f108221a = LazyKt.lazy(new ReplayCastLoadingView$view$2(this));
    }
}
