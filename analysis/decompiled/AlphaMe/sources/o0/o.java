package o0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* loaded from: classes.dex */
public final class o extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f13726a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f13727b;

    public /* synthetic */ o(Object obj, q.f fVar) {
        this.f13727b = obj;
        this.f13726a = fVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ((q.f) this.f13726a).remove(animator);
        ((s) this.f13727b).f13756n.remove(animator);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        ((s) this.f13727b).f13756n.add(animator);
    }
}
