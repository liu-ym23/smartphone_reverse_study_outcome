package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends BaseAnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveSendGiftAnimationView.b f126738a;

    public a(LiveSendGiftAnimationView.b r100) {
        this.f126738a = r100;
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStart(AnimatedDrawable2 r100) {
        LiveSendGiftAnimationView.e(this.f126738a.f126725a, false);
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStop(AnimatedDrawable2 r100) {
        LiveSendGiftAnimationView.e(this.f126738a.f126725a, true);
    }
}
