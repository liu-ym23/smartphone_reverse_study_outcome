package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class u {

    public static class a extends AnimatorListenerAdapter implements Transition.TransitionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f5092a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f5093b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f5094c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f5095d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int[] f5096e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public float f5097f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float f5098g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final float f5099h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final float f5100i;

        public a(View r10, View r11, int r12, int r13, float r14, float r15) {
            this.f5093b = r10;
            this.f5092a = r11;
            this.f5094c = r12 - Math.round(r10.getTranslationX());
            this.f5095d = r13 - Math.round(r10.getTranslationY());
            this.f5099h = r14;
            this.f5100i = r15;
            int r16 = R$id.transition_position;
            int[] r17 = (int[]) r11.getTag(r16);
            this.f5096e = r17;
            if (r17 == null) goto L6;
            r11.setTag(r16, null);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r10) {
            if (this.f5096e != null) goto L5;
            this.f5096e = new int[2];
        L5:
            this.f5096e[0] = Math.round(this.f5094c + this.f5093b.getTranslationX());
            this.f5096e[1] = Math.round(this.f5095d + this.f5093b.getTranslationY());
            this.f5092a.setTag(R$id.transition_position, this.f5096e);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator r10) {
            this.f5097f = this.f5093b.getTranslationX();
            this.f5098g = this.f5093b.getTranslationY();
            this.f5093b.setTranslationX(this.f5099h);
            this.f5093b.setTranslationY(this.f5100i);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator r10) {
            this.f5093b.setTranslationX(this.f5097f);
            this.f5093b.setTranslationY(this.f5098g);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition r10) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition r10) {
            this.f5093b.setTranslationX(this.f5099h);
            this.f5093b.setTranslationY(this.f5100i);
            r10.removeListener(this);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition r10) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition r10) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition r10) {
        }
    }

    public static Animator a(View r13, s r14, int r15, int r16, float r17, float r18, float r19, float r20, TimeInterpolator r21, Transition r22) {
        float r10 = r13.getTranslationX();
        float r11 = r13.getTranslationY();
        int[] r12 = (int[]) r14.f5086b.getTag(R$id.transition_position);
        if (r12 == null) goto L5;
        float r23 = (r12[0] - r15) + r10;
        float r24 = (r12[1] - r16) + r11;
    L6:
        int r25 = Math.round(r23 - r10) + r15;
        int r110 = r16 + Math.round(r24 - r11);
        r13.setTranslationX(r23);
        r13.setTranslationY(r24);
        if (r23 == r19) goto L9;
    L12:
        ObjectAnimator r26 = ObjectAnimator.ofPropertyValuesHolder(r13, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{r23, r19}), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{r24, r20})});
        a r27 = new a(r13, r14.f5086b, r25, r110, r10, r11);
        r22.addListener(r27);
        r26.addListener(r27);
        AnimatorUtils.a(r26, r27);
        r26.setInterpolator(r21);
        return r26;
    L9:
        if (r24 != r20) goto L12;
        return null;
    L5:
        r23 = r17;
        r24 = r18;
        goto L6
    }
}
