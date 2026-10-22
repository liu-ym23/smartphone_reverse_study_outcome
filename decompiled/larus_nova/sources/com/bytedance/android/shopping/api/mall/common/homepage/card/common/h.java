package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import android.graphics.drawable.Animatable;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;

/* JADX INFO: loaded from: classes13.dex */
public final class h extends BaseAnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Animatable f170313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f170314b;

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationRepeat(AnimatedDrawable2 r100) {
        this.f170313a.stop();
        b0.e(this.f170314b.f170315a);
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStop(AnimatedDrawable2 r100) {
        b0.e(this.f170314b.f170315a);
    }

    public h(Animatable r100, i r101) {
        this.f170313a = r100;
        this.f170314b = r101;
    }
}
