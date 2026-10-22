package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
class AnimatorUtils {

    interface AnimatorPauseListenerCompat {
        void onAnimationPause(Animator r1);

        void onAnimationResume(Animator r1);
    }

    static void addPauseListener(Animator r0, AnimatorListenerAdapter r1) {
        r0.addPauseListener(r1);
    }

    static void pause(Animator r0) {
        r0.pause();
    }

    static void resume(Animator r0) {
        r0.resume();
    }

    private AnimatorUtils() {
    }
}
