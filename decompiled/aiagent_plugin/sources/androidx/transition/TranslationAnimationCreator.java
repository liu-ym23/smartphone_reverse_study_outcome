package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
class TranslationAnimationCreator {

    private static class TransitionPositionListener extends AnimatorListenerAdapter implements s.d {
        private final View mMovingView;
        private float mPausedX;
        private float mPausedY;
        private final int mStartX;
        private final int mStartY;
        private final float mTerminalX;
        private final float mTerminalY;
        private int[] mTransitionPosition;
        private final View mViewInHierarchy;

        @Override // androidx.transition.s.d
        public void onTransitionCancel(s r1) {
        }

        @Override // androidx.transition.s.d
        public void onTransitionPause(s r1) {
        }

        @Override // androidx.transition.s.d
        public void onTransitionResume(s r1) {
        }

        @Override // androidx.transition.s.d
        public void onTransitionStart(s r1) {
        }

        TransitionPositionListener(View r3, View r4, int r5, int r6, float r7, float r8) {
            this.mMovingView = r3;
            this.mViewInHierarchy = r4;
            this.mStartX = r5 - Math.round(r3.getTranslationX());
            this.mStartY = r6 - Math.round(r3.getTranslationY());
            this.mTerminalX = r7;
            this.mTerminalY = r8;
            int[] r9 = (int[]) ZeusTransformUtils.preCheckCast((int[]) ZeusTransformUtils.preCheckCast(r4.getTag(ZeusTransformUtils.mapRes(R.id.transition_position, DbHelper.COL_ID, "transition_position")), int[].class, "com.obric.aiagent.plugin"), int[].class, "com.obric.aiagent.plugin");
            this.mTransitionPosition = r9;
            if (r9 == null) goto L6;
            r4.setTag(ZeusTransformUtils.mapRes(R.id.transition_position, DbHelper.COL_ID, "transition_position"), null);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r4) {
            if (this.mTransitionPosition != null) goto L5;
            this.mTransitionPosition = new int[2];
        L5:
            this.mTransitionPosition[0] = Math.round(this.mStartX + this.mMovingView.getTranslationX());
            this.mTransitionPosition[1] = Math.round(this.mStartY + this.mMovingView.getTranslationY());
            this.mViewInHierarchy.setTag(ZeusTransformUtils.mapRes(R.id.transition_position, DbHelper.COL_ID, "transition_position"), this.mTransitionPosition);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator r2) {
            this.mPausedX = this.mMovingView.getTranslationX();
            this.mPausedY = this.mMovingView.getTranslationY();
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator r2) {
            this.mMovingView.setTranslationX(this.mPausedX);
            this.mMovingView.setTranslationY(this.mPausedY);
        }

        @Override // androidx.transition.s.d
        public void onTransitionEnd(s r3) {
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
            r3.b(this);
        }
    }
}
