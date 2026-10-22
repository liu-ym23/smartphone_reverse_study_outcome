package com.bytedance.android.live.broadcastgame.opengame.behavior;

import android.graphics.drawable.Animatable;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class r extends BaseAnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f59784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f59785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Animatable f59786c;

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStart(AnimatedDrawable2 r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable2");
        this.f59785b.f59788b.invoke();
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationStop(AnimatedDrawable2 r100) {
        Intrinsics.checkNotNullParameter(r100, "drawable2");
        this.f59785b.f59789c.invoke();
    }

    public r(s r100, Animatable r101) {
        this.f59785b = r100;
        this.f59786c = r101;
        this.f59784a = -1;
    }

    @Override // com.facebook.fresco.animation.drawable.BaseAnimationListener, com.facebook.fresco.animation.drawable.AnimationListener
    public final void onAnimationFrame(AnimatedDrawable2 r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "drawable2");
        if (r101 < this.f59784a) goto L5;
    L8:
        this.f59785b.f59791e.invoke(Integer.valueOf(r101), Integer.valueOf(r100.getFrameCount()));
        this.f59784a = r101;
        return;
    L5:
        if (this.f59785b.f59790d == false) goto L7;
        ((AnimatedDrawable2) this.f59786c).jumpToFrame(r100.getFrameCount() - 1);
    L7:
        this.f59786c.stop();
        goto L8
    }
}
