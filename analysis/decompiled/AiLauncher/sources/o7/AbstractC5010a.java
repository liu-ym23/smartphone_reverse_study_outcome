package o7;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: o7.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC5010a extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public boolean f37467a = false;

    public abstract void a(Animator animator);

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f37467a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (this.f37467a) {
            return;
        }
        a(animator);
    }
}
