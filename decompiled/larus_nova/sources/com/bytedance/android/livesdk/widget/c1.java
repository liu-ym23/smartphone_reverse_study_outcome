package com.bytedance.android.livesdk.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: classes11.dex */
public final class c1 implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveGuidePageTetris.c f161482a;

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation r100) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation r100) {
    }

    public c1(LiveGuidePageTetris.c r100) {
        this.f161482a = r100;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation r100) {
        int r101 = LiveGuidePageTetris.f160979w;
        ALogger.d("LiveGuidePage", "animation end");
        LiveGuidePageTetris.V(this.f161482a.f160989a).setVisibility(8);
        LiveGuidePageTetris r102 = this.f161482a.f160989a;
        View r103 = r102.f160986u;
        ViewGroup.LayoutParams r104 = null;
        if (r103 == null) goto L5;
        ViewGroup.LayoutParams r105 = r103.getLayoutParams();
    L7:
        if ((r105 instanceof FrameLayout.LayoutParams) == false) goto L10;
        r104 = r105;
    L10:
        FrameLayout.LayoutParams r106 = (FrameLayout.LayoutParams) r104;
        if (r106 != null) goto L13;
    L17:
        LiveGuidePageViewModel r107 = this.f161482a.f160989a.f160981p;
        if (r107 == null) goto L21;
        r107.onGuideGone();
        return;
    L21:
        return;
    L13:
        if (r106.gravity == 17) goto L17;
        r106.topMargin = 0;
        r106.gravity = 17;
        View r108 = r102.f160986u;
        if (r108 == null) goto L17;
        r108.setLayoutParams(r106);
        goto L17
    L5:
        r105 = null;
        goto L7
    }
}
