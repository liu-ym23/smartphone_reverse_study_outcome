package K;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* loaded from: classes.dex */
public final class d0 extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f954a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f955b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f956c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f957d;

    public /* synthetic */ d0(int i4, Object obj, Object obj2, Object obj3) {
        this.f954a = i4;
        this.f957d = obj;
        this.f956c = obj2;
        this.f955b = obj3;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        switch (this.f954a) {
            case 0:
                ((f0) this.f956c).onAnimationCancel();
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        int i4 = this.f954a;
        Object obj = this.f955b;
        Object obj2 = this.f956c;
        switch (i4) {
            case 0:
                ((f0) obj2).c((View) obj);
                break;
            default:
                ((n0) obj2).f993a.g0(1.0f);
                k0.g0((View) obj);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f954a) {
            case 0:
                ((f0) this.f956c).d((View) this.f955b);
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
