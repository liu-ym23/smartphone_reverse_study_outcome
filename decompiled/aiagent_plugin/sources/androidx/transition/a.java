package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: compiled from: AnimatorUtils.java */
/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: androidx.transition.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AnimatorUtils.java */
    interface InterfaceC0077a {
        void onAnimationPause(Animator r1);

        void onAnimationResume(Animator r1);
    }

    static void a(Animator r2, AnimatorListenerAdapter r3) {
        if (Build.VERSION.SDK_INT < 19) goto L6;
        r2.addPauseListener(r3);
        return;
    }

    static void a(Animator r6) {
        if (Build.VERSION.SDK_INT < 19) goto L5;
        r6.pause();
        return;
    L5:
        ArrayList<Animator.AnimatorListener> r0 = r6.getListeners();
        if (r0 == null) goto L17;
        int r1 = 0;
        int r2 = r0.size();
    L8:
        if (r1 >= r2) goto L18;
        Animator.AnimatorListener r3 = (Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r0.get(r1), Animator.AnimatorListener.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, InterfaceC0077a.class) == false) goto L12;
        ((InterfaceC0077a) ZeusTransformUtils.preCheckCast(r3, InterfaceC0077a.class, "com.obric.aiagent.plugin")).onAnimationPause(r6);
    L12:
        r1 = r1 + 1;
        goto L8
    L18:
        return;
    }

    static void b(Animator r6) {
        if (Build.VERSION.SDK_INT < 19) goto L5;
        r6.resume();
        return;
    L5:
        ArrayList<Animator.AnimatorListener> r0 = r6.getListeners();
        if (r0 == null) goto L17;
        int r1 = 0;
        int r2 = r0.size();
    L8:
        if (r1 >= r2) goto L18;
        Animator.AnimatorListener r3 = (Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r0.get(r1), Animator.AnimatorListener.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, InterfaceC0077a.class) == false) goto L12;
        ((InterfaceC0077a) ZeusTransformUtils.preCheckCast(r3, InterfaceC0077a.class, "com.obric.aiagent.plugin")).onAnimationResume(r6);
    L12:
        r1 = r1 + 1;
        goto L8
    L18:
        return;
    }
}
