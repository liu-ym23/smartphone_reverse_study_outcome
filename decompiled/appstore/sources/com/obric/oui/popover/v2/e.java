package com.obric.oui.popover.v2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import com.obric.common.oui.R$id;
import com.obric.oui.animation.easy.ViewPropertySpringAnimator;
import com.obric.oui.animation.engine.DynamicAnimation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f16319a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f16320b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.obric.oui.animation.engine.a f16321c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f16322a;

        public a(float r10) {
            this.f16322a = r10;
        }

        public final float a() {
            return this.f16322a;
        }

        public final void b(float r10) {
            this.f16322a = r10;
        }
    }

    public static final class b extends com.obric.oui.animation.engine.a {
        public b() {
            super("v");
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ float a(Object r10) {
            return c((View) r10);
        }

        @Override // com.obric.oui.animation.engine.a
        public /* bridge */ /* synthetic */ void b(Object r10, float r11) {
            d((View) r10, r11);
        }

        public float c(View r10) {
            if (r10 == null) goto L20;
            Object r11 = r10.getTag(e.f16319a.c());
            if (r11 == null) goto L21;
            td.c r12 = td.c.f24796a;
            Float r13 = null;
            if ((r11 instanceof a) == true) goto L12;
            r11 = null;
        L12:
            a r14 = (a) r11;
            if (r14 == null) goto L16;
            r13 = Float.valueOf(r14.a());
        L16:
            if (r13 != null) goto L19;
            return 0.0f;
        L19:
            return r13.floatValue();
        L21:
            return 0.0f;
        L20:
            return 0.0f;
        }

        public void d(View r10, float r11) {
            if (r10 == null) goto L16;
            Object r12 = r10.getTag(e.f16319a.c());
            if (r12 == null) goto L17;
            td.c r13 = td.c.f24796a;
            if ((r12 instanceof a) == true) goto L11;
            r12 = null;
        L11:
            a r14 = (a) r12;
            if (r14 == null) goto L18;
            r14.b(r11);
            return;
        L18:
            return;
        L17:
            return;
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f16323a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f16324b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef f16325c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function0 f16326d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function0 f16327e;

        public c(boolean r10, ViewGroup r11, Ref$ObjectRef r12, Function0 r13, Function0 r14) {
            this.f16323a = r10;
            this.f16324b = r11;
            this.f16325c = r12;
            this.f16326d = r13;
            this.f16327e = r14;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            q.g(r10, "animation");
            super.onAnimationCancel(r10);
            this.f16324b.setLayerType(0, null);
            ViewPropertySpringAnimator r11 = (ViewPropertySpringAnimator) this.f16325c.element;
            if (r11 == null) goto L7;
            r11.h();
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            q.g(r10, "animation");
            super.onAnimationEnd(r10);
            this.f16324b.setLayerType(0, null);
            if (this.f16323a == true) goto L5;
            this.f16324b.setVisibility(8);
        L5:
            Function0 r11 = this.f16327e;
            if (r11 == null) goto L10;
            r11.invoke();
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            q.g(r10, "animation");
            super.onAnimationStart(r10);
            if (this.f16323a == false) goto L5;
            this.f16324b.setLayerType(2, null);
        L5:
            ViewPropertySpringAnimator r11 = (ViewPropertySpringAnimator) this.f16325c.element;
            if (r11 == null) goto L10;
            r11.q();
        L10:
            if (this.f16323a == false) goto L17;
            Function0 r12 = this.f16326d;
            if (r12 == null) goto L15;
            r12.invoke();
        L15:
            this.f16324b.setVisibility(0);
            return;
        }
    }

    static {
        f16319a = new e();
        f16320b = R$id.o_popover_anim_p;
        f16321c = new b();
    }

    public e() {
    }

    public static /* synthetic */ void a(ViewGroup r10, float r11, float r12, float r13, float r14, View r15, float r16, float r17, DynamicAnimation r18, float r19, float r110) {
        e(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110);
    }

    public static /* synthetic */ void b(ViewGroup r10, float r11, float r12, float r13, float r14, float r15, float r16, DynamicAnimation r17, float r18, float r19) {
        g(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    public static final void e(ViewGroup r10, float r11, float r12, float r13, float r14, View r15, float r16, float r17, DynamicAnimation r18, float r19, float r110) {
        q.g(r10, "$view");
        td.c r20 = td.c.f24796a;
        Object r21 = r10.getTag(f16320b);
        if (r21 != null) goto L6;
    L4:
        r21 = null;
    L8:
        if (((a) r21) == null) goto L11;
        float r22 = td.b.b(r19, r11, r12);
        float r23 = r13 + ((r14 - r13) * r22);
        r10.setScaleX(r23);
        r10.setScaleY(r23);
        r15.setAlpha(r16 + ((r17 - r16) * r22));
        return;
    L11:
        return;
    L6:
        if ((r21 instanceof a) == false) goto L4;
        goto L4
    }

    public static final void g(ViewGroup r10, float r11, float r12, float r13, float r14, float r15, float r16, DynamicAnimation r17, float r18, float r19) {
        q.g(r10, "$view");
        td.c r20 = td.c.f24796a;
        Object r21 = r10.getTag(f16320b);
        if (r21 != null) goto L6;
    L4:
        r21 = null;
    L8:
        if (((a) r21) == null) goto L11;
        float r22 = td.b.b(r18, r11, r12);
        float r23 = r13 + ((r14 - r13) * r22);
        r10.setScaleX(r23);
        r10.setScaleY(r23);
        r10.setTranslationY(r15 + ((r16 - r15) * r22));
        return;
    L11:
        return;
    L6:
        if ((r21 instanceof a) == false) goto L4;
        goto L4
    }

    public final int c() {
        return f16320b;
    }

    public final void d(OPopoverBase r16, boolean r17, final float r18, final float r19) {
        q.g(r16, "popover");
        final ViewGroup r10 = r16.getPopoverWindowFrame();
        final View r11 = r16.getPopoverBubbleLayout().getChildAt(0);
        if (r17 == false) goto L5;
        float r12 = 0.8f;
    L7:
        if (r17 == false) goto L9;
        float r13 = 0.0f;
    L10:
        if (r17 == false) goto L12;
        float r14 = 10000.0f;
    L13:
        final float r15 = r10.getScaleX();
        final float r110 = r11.getAlpha();
        ViewPropertySpringAnimator r20 = ViewPropertySpringAnimator.f(com.obric.oui.animation.easy.b.a(r10).j(r12).k(439.0f), f16321c, r14, null, 4, null);
        final float r21 = r13;
        final float r22 = r14;
        r20.setUpdateListener(new com.obric.oui.popover.v2.c(r10, r21, r22, r15, r19, r11, r110, r18));
        r20.q();
        return;
    L12:
        r14 = 0.0f;
        goto L13
    L9:
        r13 = 10000.0f;
        goto L10
    L5:
        r12 = 1.0f;
        goto L7
    }

    /* JADX WARN: Type inference failed for: r11v3, types: [T, com.obric.oui.animation.easy.ViewPropertySpringAnimator] */
    public final AnimatorSet f(final ViewGroup r18, boolean r19, int r20, float r21, float r22, boolean r23, Animator r24, Function0 r25, Function0 r26) {
        int r10 = 1;
        q.g(r18, "view");
        r18.setPivotX(r21);
        r18.setPivotY(r22);
        r18.setVisibility(0);
        AnimatorSet r11 = new AnimatorSet();
        Ref$ObjectRef r12 = new Ref$ObjectRef();
        if (r24 == null) goto L5;
        r11.play(r24);
    L48:
        r11.addListener(new c(r23, r18, r12, r25, r26));
        r11.start();
        return r11;
    L5:
        PathInterpolator r13 = new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f);
        final float r14 = 0.0f;
        if (r23 == false) goto L8;
        float r15 = 0.0f;
    L9:
        if (r23 == false) goto L11;
        float r16 = 1.0f;
    L13:
        if (r18.getAlpha() != 0.0f) goto L16;
    L19:
        ObjectAnimator r17 = ObjectAnimator.ofFloat(r18, "alpha", new float[]{r15, r16});
        r17.setInterpolator(r13);
        r17.setDuration(100);
        r11.play(r17);
        if (r23 == false) goto L22;
        final float r27 = 0.2f;
    L23:
        if (r23 == false) goto L25;
        final float r28 = 1.0f;
    L27:
        if (r20 != 48) goto L31;
        r10 = -1;
    L31:
        if (r23 == false) goto L33;
        float r29 = -tc.f.u(r18, 10);
    L34:
        float r30 = r10;
        final float r31 = r29 * r30;
        if (r23 == false) goto L37;
        float r32 = 0.0f;
    L38:
        final float r33 = r32 * r30;
        if (r23 == false) goto L41;
        final float r34 = 0.0f;
    L42:
        if (r23 == false) goto L45;
        r14 = 10000.0f;
    L45:
        if (com.obric.oui.animation.easy.b.a(r18).l() == true) goto L47;
        r18.setScaleX(r27);
        r18.setScaleY(r27);
        r18.setTranslationY(r31);
        r18.setTag(f16320b, new a(r34));
    L47:
        ?? r110 = ViewPropertySpringAnimator.f(com.obric.oui.animation.easy.b.a(r18).j(0.85f).k(632.0f), f16321c, r14, null, 4, null);
        r110.setUpdateListener(new d(r18, r34, r14, r27, r28, r31, r33));
        r12.element = r110;
        goto L48
    L41:
        r34 = 10000.0f;
        goto L42
    L37:
        r32 = -tc.f.u(r18, 10);
        goto L38
    L33:
        r29 = 0.0f;
        goto L34
    L25:
        r28 = 0.2f;
        goto L27
    L22:
        r27 = 1.0f;
        goto L23
    L16:
        if (r18.getAlpha() == 1.0f) goto L19;
        r15 = r18.getAlpha();
        goto L19
    L11:
        r16 = 0.0f;
        goto L13
    L8:
        r15 = 1.0f;
        goto L9
    }
}
