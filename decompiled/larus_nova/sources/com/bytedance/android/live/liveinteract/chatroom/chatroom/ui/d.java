package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.log.ALogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkSucAnimationView f72458a;

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

    public d(LinkSucAnimationView r100) {
        this.f72458a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        LinkSucAnimationView r101 = this.f72458a;
        int r102 = LinkSucAnimationView.f72383j;
        r101.getClass();
        ALogger.i("LinkSucAnimationView", "prepareMatchAnimation2, viewDetached=" + r101.f72391h + ", guestName=" + r101.f72385b);
        if (r101.f72391h == true) goto L8;
        TextView r103 = r101.f72385b;
        if (r103 == null) goto L8;
        Intrinsics.checkNotNull(r103);
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r103, "alpha", new float[]{0.0f, 1.0f});
        TextView r105 = r101.f72385b;
        Intrinsics.checkNotNull(r105);
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r105, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{-20.0f, 0.0f});
        AnimatorSet r107 = new AnimatorSet();
        r107.playTogether(new Animator[]{r104, r106});
        r107.setDuration(100);
        r107.start();
        return;
    L8:
        Function0<Unit> r108 = r101.f72390g;
        if (r108 == null) goto L11;
        r108.invoke();
    L11:
        LinkSucAnimationView.a r109 = r101.f72389f;
        if (r109 == null) goto L16;
        r109.h();
        return;
    }
}
