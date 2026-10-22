package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes17.dex */
class TranslationAnimationCreator {

    public static class TransitionPositionListener extends AnimatorListenerAdapter {
        private final View mMovingView;
        private float mPausedX;
        private float mPausedY;
        private final int mStartX;
        private final int mStartY;
        private final float mTerminalX;
        private final float mTerminalY;
        private int[] mTransitionPosition;
        private final View mViewInHierarchy;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r100) {
            if (this.mTransitionPosition != null) goto L5;
            this.mTransitionPosition = new int[2];
        L5:
            this.mTransitionPosition[0] = Math.round(this.mStartX + this.mMovingView.getTranslationX());
            this.mTransitionPosition[1] = Math.round(this.mStartY + this.mMovingView.getTranslationY());
            this.mViewInHierarchy.setTag(R.id.transition_position, this.mTransitionPosition);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r100) {
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator r100) {
            this.mPausedX = this.mMovingView.getTranslationX();
            this.mPausedY = this.mMovingView.getTranslationY();
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator r100) {
            this.mMovingView.setTranslationX(this.mPausedX);
            this.mMovingView.setTranslationY(this.mPausedY);
        }

        public TransitionPositionListener(View r100, View r101, int r102, int r103, float r104, float r105) {
            this.mMovingView = r100;
            this.mViewInHierarchy = r101;
            this.mStartX = r102 - Math.round(r100.getTranslationX());
            this.mStartY = r103 - Math.round(r100.getTranslationY());
            this.mTerminalX = r104;
            this.mTerminalY = r105;
            int[] r106 = (int[]) r101.getTag(R.id.transition_position);
            this.mTransitionPosition = r106;
            if (r106 == null) goto L6;
            r101.setTag(R.id.transition_position, null);
            return;
        }
    }

    private TranslationAnimationCreator() {
    }

    public static Animator createAnimation(View r110, TransitionValues r111, int r112, int r113, float r114, float r115, float r210, float r211, TimeInterpolator r212) {
        float r100 = r110.getTranslationX();
        float r101 = r110.getTranslationY();
        int[] r102 = (int[]) r111.view.getTag(R.id.transition_position);
        if (r102 == null) goto L5;
        float r103 = (r102[0] - r112) + r100;
        float r104 = (r102[1] - r113) + r101;
    L6:
        int r105 = r112 + Math.round(r103 - r100);
        int r106 = r113 + Math.round(r104 - r101);
        r110.setTranslationX(r103);
        r110.setTranslationY(r104);
        if (r103 == r210) goto L9;
    L12:
        ObjectAnimator r107 = ObjectAnimator.ofPropertyValuesHolder(r110, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{r103, r210}), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{r104, r211})});
        TransitionPositionListener r108 = new TransitionPositionListener(r110, r111.view, r105, r106, r100, r101);
        r107.addListener(r108);
        AnimatorUtils.addPauseListener(r107, r108);
        r107.setInterpolator(r212);
        return r107;
    L9:
        if (r104 != r211) goto L12;
        return null;
    L5:
        r103 = r114;
        r104 = r115;
        goto L6
    }
}
