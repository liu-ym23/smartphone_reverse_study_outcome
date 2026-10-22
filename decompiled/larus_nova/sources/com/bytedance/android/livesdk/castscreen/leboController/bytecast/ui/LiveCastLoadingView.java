package com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastLoadingView;
import com.bytedance.android.livesdk.chatroom.ui.LiveDoubleColorBallAnimationView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class LiveCastLoadingView implements ILiveCastLoadingView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f104562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f104563b;

    @Override // com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastLoadingView
    public final View getView() {
        return (LiveDoubleColorBallAnimationView) this.f104562a.getValue();
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastLoadingView
    public final boolean isAnimating() {
        return ((LiveDoubleColorBallAnimationView) this.f104562a.getValue()).a();
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastLoadingView
    public final void startAnimation() {
        ((LiveDoubleColorBallAnimationView) this.f104562a.getValue()).b();
    }

    @Override // com.bytedance.android.livehostapi.business.castscreen.interfaces.ILiveCastLoadingView
    public final void stopAnimation() {
        ((LiveDoubleColorBallAnimationView) this.f104562a.getValue()).c();
    }

    public LiveCastLoadingView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f104563b = r100;
        this.f104562a = LazyKt.lazy(new LiveCastLoadingView$view$2(this));
    }
}
