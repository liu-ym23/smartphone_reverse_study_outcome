package com.bytedance.android.livesdk.livecommerce.intro.manager;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class BottomRightAnim$showLinkedAnimation$1$animRequest$1 implements com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f148322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Integer> f148323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BottomRightAnim$showLinkedAnimation$1 f148324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f148325d;

    public static final class a extends qh2.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ BottomRightAnim$showLinkedAnimation$1$animRequest$1 f148326d;

        @Override // qh2.a, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationEnd(r100);
            this.f148326d.f148324c.$onAnimEnd.invoke();
        }

        @Override // qh2.a, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationStart(r100);
            BottomRightAnim$showLinkedAnimation$1$animRequest$1 r101 = this.f148326d;
            if (r101.f148322a == true) goto L6;
            r101.f148322a = true;
            r101.f148324c.$onAnimStart.invoke();
            return;
        }

        public a(Function3 r100, Function0 r101, BottomRightAnim$showLinkedAnimation$1$animRequest$1 r102) {
            this.f148326d = r102;
            super(r100, r101, 1);
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomRightAnim$showLinkedAnimation$1$animRequest$1 f148327a;

        public b(BottomRightAnim$showLinkedAnimation$1$animRequest$1 r100) {
            this.f148327a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Object r101 = r100.getAnimatedValue();
            if ((r101 instanceof Float) == true) goto L5;
            r101 = null;
        L5:
            Float r102 = (Float) r101;
            if (r102 == null) goto L11;
            float r103 = r102.floatValue();
            Function3 r104 = this.f148327a.f148324c.$animatorCallback;
            if (r104 == null) goto L12;
            Unit r105 = (Unit) r104.invoke(110, Integer.valueOf((int) (r103 * this.f148327a.f148324c.$view.getHeight())), Float.valueOf(r100.getAnimatedFraction()));
            return;
        L12:
            return;
        }
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g
    public final void c(int r100) {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g
    public final void a() {
        View r100 = this.f148324c.$view;
        PathInterpolator r101 = new PathInterpolator(0.4f, 0.0f, 0.2f, 1.0f);
        ObjectAnimator r102 = ObjectAnimator.ofFloat(this.f148324c.$view, View.SCALE_X, new float[]{0.05f, 1.0f});
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this.f148324c.$view, View.SCALE_Y, new float[]{0.05f, 1.0f});
        r102.setDuration(450);
        r103.setDuration(450);
        r102.setInterpolator(r101);
        r103.setInterpolator(r101);
        r103.addListener(new a(this.f148324c.$animatorCallback, this.f148323b, this));
        r103.addUpdateListener(new b(this));
        ObjectAnimator r104 = ObjectAnimator.ofFloat(this.f148324c.$view, View.ALPHA, new float[]{0.0f, 1.0f});
        r104.setDuration(50);
        r104.setInterpolator(new LinearInterpolator());
        r104.setStartDelay(17);
        AnimatorSet r105 = new AnimatorSet();
        r100.setScaleX(0.05f);
        r100.setScaleY(0.05f);
        r100.setAlpha(0.0f);
        r100.setPivotX(BottomRightAnim.b(BottomRightAnim.f148302a, this.f148324c.$contextController, r100.getWidth()));
        r100.setPivotY(this.f148325d);
        r105.playTogether(new Animator[]{r102, r103, r104});
        r105.start();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g
    public final void b() {
        if (this.f148322a == true) goto L6;
        this.f148322a = true;
        this.f148324c.$onAnimStart.invoke();
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.anim.g
    public final void onCanceled() {
        a();
    }

    public BottomRightAnim$showLinkedAnimation$1$animRequest$1(BottomRightAnim$showLinkedAnimation$1 r100, int r101) {
        this.f148324c = r100;
        this.f148325d = r101;
        this.f148323b = new BottomRightAnim$showLinkedAnimation$1$animRequest$1$getViewHeight$1(this);
    }
}
