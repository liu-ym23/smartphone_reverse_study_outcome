package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.send.presenter;

import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class j implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SendDanmuMsgPresenter f109139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f109140b;

    public j(SendDanmuMsgPresenter r100, boolean r101) {
        this.f109139a = r100;
        this.f109140b = r101;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        if (r100.getAnimatedFraction() != 1.0f) goto L9;
        View r101 = this.f109139a.f109115m;
        if (r101 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("btnSend");
    L7:
        UtilityKotlinExtentionsKt.k(r101, this.f109140b);
        return;
    }
}
