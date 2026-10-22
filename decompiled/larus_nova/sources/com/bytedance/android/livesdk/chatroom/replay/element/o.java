package com.bytedance.android.livesdk.chatroom.replay.element;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.uicomponent.popover.PopLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PopLayout f108562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f108563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AnimatorSet f108564c;

    public static final class a extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f108565a;

        public a(o r100) {
            this.f108565a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100);
            o r101 = this.f108565a;
            if (r101.f108563b == true) goto L6;
            r101.f108562a.setVisibility(8);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationStart(r100);
            o r101 = this.f108565a;
            if (r101.f108563b == false) goto L6;
            r101.f108562a.setVisibility(0);
            return;
        }
    }

    public o(PopLayout r100, boolean r101, AnimatorSet r102) {
        this.f108562a = r100;
        this.f108563b = r101;
        this.f108564c = r102;
    }

    public final void a() {
        int r100 = (int) this.f108562a.getX();
        this.f108562a.setPivotY((int) (this.f108562a.getY() + this.f108562a.getBubbleOffset()));
        this.f108562a.setPivotX(r100);
        PopLayout r101 = this.f108562a;
        float[] r102 = new float[2];
        boolean r103 = this.f108563b;
        float r104 = 1.0f;
        if (r103 == false) goto L5;
        float r105 = 0.0f;
    L6:
        r102[0] = r105;
        if (r103 == false) goto L9;
        float r106 = 1.0f;
    L10:
        r102[1] = r106;
        ObjectAnimator r107 = ObjectAnimator.ofFloat(r101, LiveDegradeFpsAnimator.SCALE_X, r102);
        long r108 = 200;
        r107.setDuration(200);
        PopLayout r109 = this.f108562a;
        float[] r110 = new float[2];
        boolean r111 = this.f108563b;
        if (r111 == false) goto L13;
        float r112 = 0.0f;
    L14:
        r110[0] = r112;
        if (r111 == true) goto L18;
        r104 = 0.0f;
    L18:
        r110[1] = r104;
        ObjectAnimator r113 = ObjectAnimator.ofFloat(r109, LiveDegradeFpsAnimator.SCALE_Y, r110);
        r113.setDuration(200);
        ObjectAnimator r114 = ObjectAnimator.ofFloat(this.f108562a, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f});
        long r115 = 500;
        if (this.f108563b == false) goto L21;
        long r116 = 500;
    L22:
        r114.setDuration(r116);
        ObjectAnimator r117 = ObjectAnimator.ofFloat(this.f108562a, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f});
        if (this.f108563b == false) goto L25;
        long r118 = 500;
    L26:
        r117.setDuration(r118);
        ObjectAnimator r119 = ObjectAnimator.ofFloat(this.f108562a, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f});
        if (this.f108563b == false) goto L29;
        r108 = 500;
    L29:
        r119.setDuration(r108);
        ObjectAnimator r120 = ObjectAnimator.ofFloat(this.f108562a, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f});
        if (this.f108563b == true) goto L33;
        r115 = 200;
    L33:
        r120.setDuration(r115);
        ObjectAnimator r121 = ObjectAnimator.ofFloat(this.f108562a, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, 10.0f});
        if (this.f108563b == false) goto L36;
        long r122 = 200;
    L37:
        r121.setDuration(r122);
        ObjectAnimator r123 = ObjectAnimator.ofFloat(this.f108562a, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, -10.0f});
        if (this.f108563b == false) goto L40;
        long r124 = 200;
    L41:
        r123.setDuration(r124);
        ObjectAnimator r125 = ObjectAnimator.ofFloat(this.f108562a, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, -10.0f});
        if (this.f108563b == false) goto L44;
        long r126 = 200;
    L45:
        r125.setDuration(r126);
        ObjectAnimator r127 = ObjectAnimator.ofFloat(this.f108562a, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{0.0f, 10.0f});
        if (this.f108563b == false) goto L48;
        long r128 = 200;
    L49:
        r127.setDuration(r128);
        this.f108562a.setVisibility(0);
        if (this.f108563b == false) goto L58;
        r127.setInterpolator(new om3.d());
        r119.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet.Builder r129 = this.f108564c.play(r107);
        if (r129 == null) goto L65;
        AnimatorSet.Builder r130 = r129.with(r113);
        if (r130 == null) goto L65;
        AnimatorSet.Builder r131 = r130.with(r127);
        if (r131 == null) goto L65;
        r131.before(r119);
    L65:
        this.f108564c.addListener(new a(this));
        this.f108564c.start();
        return;
    L58:
        r119.setInterpolator(new om3.b());
        r127.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet.Builder r132 = this.f108564c.play(r107);
        if (r132 == null) goto L65;
        AnimatorSet.Builder r133 = r132.with(r113);
        if (r133 == null) goto L65;
        AnimatorSet.Builder r134 = r133.with(r119);
        if (r134 == null) goto L65;
        r134.after(r127);
        goto L65
    L48:
        r128 = 150;
        goto L49
    L44:
        r126 = 150;
        goto L45
    L40:
        r124 = 150;
        goto L41
    L36:
        r122 = 150;
        goto L37
    L25:
        r118 = 200;
        goto L26
    L21:
        r116 = 200;
        goto L22
    L13:
        r112 = 1.0f;
        goto L14
    L9:
        r106 = 0.0f;
        goto L10
    L5:
        r105 = 1.0f;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
