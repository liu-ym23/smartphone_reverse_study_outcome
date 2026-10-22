package v0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5807a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5808b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5809c;
    public final /* synthetic */ View d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f5810e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f5811f;

    public d(w1.r rVar, int i8, TextView textView, int i9, TextView textView2) {
        this.f5811f = rVar;
        this.f5808b = i8;
        this.d = textView;
        this.f5809c = i9;
        this.f5810e = textView2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f5807a) {
            case 0:
                int i8 = this.f5808b;
                View view = this.d;
                if (i8 != 0) {
                    view.setTranslationX(0.0f);
                }
                if (this.f5809c != 0) {
                    view.setTranslationY(0.0f);
                    break;
                }
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        g.g0 g0Var;
        switch (this.f5807a) {
            case 0:
                ((ViewPropertyAnimator) this.f5810e).setListener(null);
                g gVar = (g) this.f5811f;
                gVar.a(null);
                gVar.f5824p.remove((Object) null);
                gVar.f();
                break;
            default:
                TextView textView = (TextView) this.f5810e;
                w1.r rVar = (w1.r) this.f5811f;
                rVar.f6155n = this.f5808b;
                rVar.f6153l = null;
                TextView textView2 = (TextView) this.d;
                if (textView2 != null) {
                    textView2.setVisibility(4);
                    if (this.f5809c == 1 && (g0Var = rVar.f6159r) != null) {
                        g0Var.setText((CharSequence) null);
                    }
                }
                if (textView != null) {
                    textView.setTranslationY(0.0f);
                    textView.setAlpha(1.0f);
                    break;
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f5807a) {
            case 0:
                ((g) this.f5811f).getClass();
                break;
            default:
                TextView textView = (TextView) this.f5810e;
                if (textView != null) {
                    textView.setVisibility(0);
                    textView.setAlpha(0.0f);
                    break;
                }
                break;
        }
    }

    public d(g gVar, n0 n0Var, int i8, View view, int i9, ViewPropertyAnimator viewPropertyAnimator) {
        this.f5811f = gVar;
        this.f5808b = i8;
        this.d = view;
        this.f5809c = i9;
        this.f5810e = viewPropertyAnimator;
    }
}
