package com.bytedance.android.live.openplatform.impl.minigameaudience.toolbar;

import android.graphics.drawable.Animatable;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f extends BaseAnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f85346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f85347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Animatable f85348c;

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStart(AnimatedDrawable2 r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable2");
        this.f85347b.f85350b.invoke();
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStop(AnimatedDrawable2 r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable2");
        this.f85347b.f85351c.invoke();
    }

    public f(g r100, Animatable r101) {
        this.f85347b = r100;
        this.f85348c = r101;
        this.f85346a = -1;
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "drawable2");
        if (r101 < this.f85346a) goto L5;
    L8:
        this.f85347b.f85353e.invoke(Integer.valueOf(r101), Integer.valueOf(r100.getFrameCount()));
        this.f85346a = r101;
        return;
    L5:
        if (this.f85347b.f85352d == false) goto L7;
        ((AnimatedDrawable2) this.f85348c).jumpToFrame(r100.getFrameCount() - 1);
    L7:
        this.f85348c.stop();
        goto L8
    }
}
