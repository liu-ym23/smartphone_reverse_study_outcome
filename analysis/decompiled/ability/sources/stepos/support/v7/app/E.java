package stepos.support.v7.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.Log;

/* loaded from: classes4.dex */
public final class E extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6215a;
    public final /* synthetic */ F b;

    public /* synthetic */ E(F f, int i) {
        this.f6215a = i;
        this.b = f;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f6215a) {
            case 1:
                super.onAnimationEnd(animator);
                F f = this.b;
                f.d.r();
                f.d.overridePendingTransition(0, 0);
                f.f = null;
                I.a().getClass();
                I.f6219a = null;
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f6215a) {
            case 0:
                if (!this.b.a()) {
                    I.a().getClass();
                    break;
                }
                break;
            default:
                if (!this.b.a()) {
                    Log.d("popup_stack", " top stack start exit Anim, try to call bottom stack do stackExit ");
                    I.a().getClass();
                    Log.e("popup_stack", "  call bottom stack do stackExit , but state error, return ");
                    break;
                }
                break;
        }
    }
}
