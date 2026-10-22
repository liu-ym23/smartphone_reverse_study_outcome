package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;

/* JADX INFO: loaded from: classes47.dex */
public final class s extends BaseAnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f87550a;

    public s(t r100) {
        this.f87550a = r100;
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStop(AnimatedDrawable2 r100) {
        this.f87550a.f87551a.f87498q.setVisibility(8);
    }
}
