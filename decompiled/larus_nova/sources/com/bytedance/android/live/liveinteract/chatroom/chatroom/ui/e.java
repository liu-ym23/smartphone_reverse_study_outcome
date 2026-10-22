package com.bytedance.android.live.liveinteract.chatroom.chatroom.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.model.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class e implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkSucAnimationView f72459a;

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

    public e(LinkSucAnimationView r100) {
        this.f72459a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        LinkSucAnimationView r101 = this.f72459a;
        int r102 = LinkSucAnimationView.f72383j;
        r101.getClass();
        ALogger.i("LinkSucAnimationView", "startUserNameAnimation, viewDetached=" + r101.f72391h + ", guestName=" + r101.f72385b);
        if (r101.f72391h == false) goto L5;
    L19:
        Function0<Unit> r103 = r101.f72390g;
        if (r103 == null) goto L22;
        r103.invoke();
    L22:
        LinkSucAnimationView.a r104 = r101.f72389f;
        if (r104 == null) goto L27;
        r104.h();
        return;
    L27:
        return;
    L5:
        if (r101.f72385b == null) goto L19;
        String r105 = r101.f72387d;
        if (r105 != null) goto L10;
    L13:
        boolean r106 = true;
    L14:
        if (r106 == true) goto L18;
        TextView r107 = r101.f72385b;
        if (r107 == null) goto L18;
        m.a r108 = m.f77236q0;
        String r109 = r101.f72387d;
        r108.getClass();
        r107.setText(m.a.a(r109));
    L18:
        TextView r110 = r101.f72385b;
        Intrinsics.checkNotNull(r110);
        ObjectAnimator r111 = ObjectAnimator.ofFloat(r110, "alpha", new float[]{0.1f, 1.0f});
        TextView r112 = r101.f72385b;
        Intrinsics.checkNotNull(r112);
        ObjectAnimator r113 = ObjectAnimator.ofFloat(r112, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{-10.0f, 0.0f});
        AnimatorSet r114 = new AnimatorSet();
        r114.playTogether(new Animator[]{r111, r113});
        r114.setDuration(200);
        r114.start();
        return;
    L10:
        if (r105.length() == 0) goto L13;
        r106 = false;
        goto L14
    }
}
