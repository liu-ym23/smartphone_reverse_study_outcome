package com.bytedance.android.live.matchroom;

import android.animation.Animator;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class l implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f82899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f82900b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        boolean r101 = MatchRoomLandScapeAnimUtil.f82832a;
        MatchRoomLandScapeAnimUtil.f82836e.removeListener(this);
        if (this.f82899a == true) goto L5;
        return;
    L5:
        View r102 = this.f82900b;
        if (r102 == null) goto L24;
        ViewParent r103 = r102.getParent();
        if ((r103 instanceof FrameLayout) == true) goto L10;
        r103 = null;
    L10:
        FrameLayout r104 = (FrameLayout) r103;
        if (r104 == null) goto L25;
        float r105 = r104.getWidth();
        float r106 = r104.getHeight();
        ALogger.i("MatchRoomAnimUtil", "doDialogHideAnim$onAnimationEnd(), parentWidth is " + r105 + ", parentHeight is " + r106);
        float r107 = (float) 2;
        float r108 = r105 / r107;
        if (Math.abs(r102.getPivotX() - r108) <= 1.0f) goto L15;
    L16:
        ALogger.i("MatchRoomAnimUtil", "doDialogHideAnim$onAnimationEnd(), pivotX and pivotY are set to half of parent size.");
        r102.setPivotX(r108);
        r102.setPivotY(r106 / r107);
    L17:
        float r109 = 0;
        if (Math.abs(r102.getTranslationX() - r109) <= 1.0f) goto L21;
        ALogger.i("MatchRoomAnimUtil", "doDialogHideAnim$onAnimationEnd(), translationX is set to 0.");
        r102.setTranslationX(0.0f);
    L21:
        if (Math.abs(r102.getTranslationY() - r109) <= 1.0f) goto L26;
        ALogger.i("MatchRoomAnimUtil", "doDialogHideAnim$onAnimationEnd(), translationY is set to 0.");
        r102.setTranslationY(0.0f);
        return;
    L26:
        return;
    L15:
        if (Math.abs(r102.getPivotY() - (r106 / r107)) <= 1.0f) goto L17;
    L25:
        return;
    }

    public l(boolean r100, View r101) {
        this.f82899a = r100;
        this.f82900b = r101;
    }
}
