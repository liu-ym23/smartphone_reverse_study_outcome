package com.bytedanceos.ui.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.View;
import com.bytedanceos.oui.resource.R$id;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10250a = null;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final Animator a(View r16, TransitionValues r17, int r18, int r19, float r20, float r21, float r22, float r23, TimeInterpolator r24, Transition r25) {
            q.g(r16, "view");
            q.g(r17, "values");
            q.g(r24, "interpolator");
            q.g(r25, "transition");
            float r10 = r16.getTranslationX();
            float r11 = r16.getTranslationY();
            Object r12 = r17.view.getTag(R$id.transitionPosition);
            if ((r12 instanceof int[]) == false) goto L5;
            int[] r13 = (int[]) r12;
        L6:
            if (r13 == null) goto L8;
            float r14 = (r13[0] - r18) + r10;
            float r15 = (r13[1] - r19) + r11;
        L9:
            int r110 = r18 + yf.b.b(r14 - r10);
            int r111 = r19 + yf.b.b(r15 - r11);
            r16.setTranslationX(r14);
            r16.setTranslationY(r15);
            if (r14 == r22) goto L12;
        L14:
            Path r112 = new Path();
            r112.moveTo(r14, r15);
            r112.lineTo(r22, r23);
            ObjectAnimator r26 = ObjectAnimator.ofFloat(r16, View.TRANSLATION_X, View.TRANSLATION_Y, r112);
            View r27 = r17.view;
            q.f(r27, "view");
            C0137b r28 = new C0137b(r16, r27, r110, r111, r10, r11);
            r25.addListener(r28);
            r26.addListener(r28);
            r26.addPauseListener(r28);
            r26.setInterpolator(r24);
            return r26;
        L12:
            if (r15 != r23) goto L14;
            return null;
        L8:
            r14 = r20;
            r15 = r21;
            goto L9
        L5:
            r13 = null;
            goto L6
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: com.bytedanceos.ui.transition.b$b, reason: collision with other inner class name */
    public static final class C0137b extends AnimatorListenerAdapter implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f10251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f10252b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f10253c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f10254d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f10255e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final float f10256f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int[] f10257g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public float f10258h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public float f10259i;

        public C0137b(View r10, View r11, int r12, int r13, float r14, float r15) {
            q.g(r10, "mMovingView");
            q.g(r11, "mViewInHierarchy");
            this.f10251a = r10;
            this.f10252b = r11;
            this.f10253c = r12;
            this.f10254d = r13;
            this.f10255e = r14;
            this.f10256f = r15;
            int r16 = R$id.transitionPosition;
            Object r17 = r11.getTag(r16);
            if ((r17 instanceof int[]) == false) goto L5;
            int[] r18 = (int[]) r17;
        L6:
            this.f10257g = r18;
            if (r18 == null) goto L10;
            r11.setTag(r16, null);
            return;
        L10:
            return;
        L5:
            r18 = null;
            goto L6
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            q.g(r10, "animation");
            int[] r11 = this.f10257g;
            if (r11 != null) goto L5;
            r11 = new int[2];
        L5:
            this.f10257g = r11;
            q.d(r11);
            r11[0] = yf.b.b(this.f10253c + this.f10251a.getTranslationX());
            int[] r12 = this.f10257g;
            q.d(r12);
            r12[1] = yf.b.b(this.f10254d + this.f10251a.getTranslationY());
            this.f10252b.setTag(R$id.transitionPosition, this.f10257g);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            q.g(r10, "animator");
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator r10) {
            q.g(r10, "animator");
            this.f10258h = this.f10251a.getTranslationX();
            this.f10259i = this.f10251a.getTranslationY();
            this.f10251a.setTranslationX(this.f10255e);
            this.f10251a.setTranslationY(this.f10256f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator r10) {
            q.g(r10, "animator");
            this.f10251a.setTranslationX(this.f10258h);
            this.f10251a.setTranslationY(this.f10259i);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition r10) {
            q.g(r10, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition r10) {
            q.g(r10, "transition");
            this.f10251a.setTranslationX(this.f10255e);
            this.f10251a.setTranslationY(this.f10256f);
            r10.removeListener(this);
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionPause(Transition r10) {
            q.g(r10, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionResume(Transition r10) {
            q.g(r10, "transition");
        }

        @Override // android.transition.Transition.TransitionListener
        public void onTransitionStart(Transition r10) {
            q.g(r10, "transition");
        }
    }

    static {
        f10250a = new a(null);
    }
}
