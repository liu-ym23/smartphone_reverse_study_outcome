package v0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5801a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f5802b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ViewPropertyAnimator f5803c;
    public final /* synthetic */ g d;

    public /* synthetic */ c(g gVar, Object obj, ViewPropertyAnimator viewPropertyAnimator, View view, int i8) {
        this.f5801a = i8;
        this.d = gVar;
        this.f5803c = viewPropertyAnimator;
        this.f5802b = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f5801a) {
            case 1:
                this.f5802b.setAlpha(1.0f);
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f5801a) {
            case 0:
                this.f5803c.setListener(null);
                this.f5802b.setAlpha(1.0f);
                g gVar = this.d;
                gVar.a(null);
                gVar.f5825q.remove((Object) null);
                gVar.f();
                break;
            case 1:
                this.f5803c.setListener(null);
                g gVar2 = this.d;
                gVar2.a(null);
                gVar2.f5823o.remove((Object) null);
                gVar2.f();
                break;
            case 2:
                this.f5803c.setListener(null);
                View view = this.f5802b;
                view.setAlpha(1.0f);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
                g gVar3 = this.d;
                gVar3.a(null);
                gVar3.f5826r.remove((Object) null);
                gVar3.f();
                break;
            default:
                this.f5803c.setListener(null);
                View view2 = this.f5802b;
                view2.setAlpha(1.0f);
                view2.setTranslationX(0.0f);
                view2.setTranslationY(0.0f);
                g gVar4 = this.d;
                gVar4.a(null);
                gVar4.f5826r.remove((Object) null);
                gVar4.f();
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f5801a) {
            case 0:
                this.d.getClass();
                break;
            case 1:
                this.d.getClass();
                break;
            case 2:
                this.d.getClass();
                break;
            default:
                this.d.getClass();
                break;
        }
    }

    public c(g gVar, n0 n0Var, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.f5801a = 1;
        this.d = gVar;
        this.f5802b = view;
        this.f5803c = viewPropertyAnimator;
    }
}
