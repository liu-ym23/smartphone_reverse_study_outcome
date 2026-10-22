package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import android.graphics.drawable.Animatable;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.AnimationListener;

/* JADX INFO: loaded from: classes10.dex */
public final class e1 implements AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g1 f146570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Animatable f146571b;

    @Override // com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
    }

    @Override // com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationRepeat(AnimatedDrawable2 r100) {
    }

    @Override // com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationReset(AnimatedDrawable2 r100) {
    }

    @Override // com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStart(AnimatedDrawable2 r100) {
    }

    @Override // com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStop(AnimatedDrawable2 r100) {
        this.f146570a.f146576a.invoke();
    }

    public e1(g1 r100, Animatable r101) {
        this.f146570a = r100;
        this.f146571b = r101;
    }
}
