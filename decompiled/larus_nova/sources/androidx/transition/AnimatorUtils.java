package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes17.dex */
class AnimatorUtils {

    public interface AnimatorPauseListenerCompat {
        void onAnimationPause(Animator r100);

        void onAnimationResume(Animator r100);
    }

    private AnimatorUtils() {
    }

    public static void pause(Animator r100) {
        r100.pause();
    }

    public static void resume(Animator r100) {
        r100.resume();
    }

    public static void addPauseListener(Animator r100, AnimatorListenerAdapter r101) {
        r100.addPauseListener(r101);
    }
}
