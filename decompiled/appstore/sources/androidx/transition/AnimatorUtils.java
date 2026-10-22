package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
public abstract class AnimatorUtils {

    public interface AnimatorPauseListenerCompat {
        void onAnimationPause(Animator r10);

        void onAnimationResume(Animator r10);
    }

    public static void a(Animator r10, AnimatorListenerAdapter r11) {
        r10.addPauseListener(r11);
    }

    public static void b(Animator r10) {
        r10.pause();
    }

    public static void c(Animator r10) {
        r10.resume();
    }
}
