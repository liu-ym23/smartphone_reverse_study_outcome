package o0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.T0;

/* renamed from: o0.H, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0792H extends AnimatorListenerAdapter implements q {

    /* renamed from: a, reason: collision with root package name */
    public final View f13677a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13678b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewGroup f13679c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13681e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f13682f = false;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f13680d = true;

    public C0792H(View view, int i4) {
        this.f13677a = view;
        this.f13678b = i4;
        this.f13679c = (ViewGroup) view.getParent();
        g(true);
    }

    @Override // o0.q
    public final void a() {
        g(false);
        if (this.f13682f) {
            return;
        }
        T0 t02 = AbstractC0787C.f13676a;
        this.f13677a.setTransitionVisibility(this.f13678b);
    }

    @Override // o0.q
    public final void b() {
        g(true);
        if (this.f13682f) {
            return;
        }
        T0 t02 = AbstractC0787C.f13676a;
        this.f13677a.setTransitionVisibility(0);
    }

    @Override // o0.q
    public final void d(s sVar) {
    }

    @Override // o0.q
    public final void e(s sVar) {
    }

    @Override // o0.q
    public final void f(s sVar) {
        sVar.y(this);
    }

    public final void g(boolean z4) {
        ViewGroup viewGroup;
        if (!this.f13680d || this.f13681e == z4 || (viewGroup = this.f13679c) == null) {
            return;
        }
        this.f13681e = z4;
        AbstractC0786B.b(viewGroup, z4);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f13682f = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z4) {
        if (z4) {
            return;
        }
        if (!this.f13682f) {
            T0 t02 = AbstractC0787C.f13676a;
            this.f13677a.setTransitionVisibility(this.f13678b);
            ViewGroup viewGroup = this.f13679c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        g(false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator, boolean z4) {
        if (z4) {
            T0 t02 = AbstractC0787C.f13676a;
            this.f13677a.setTransitionVisibility(0);
            ViewGroup viewGroup = this.f13679c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (!this.f13682f) {
            T0 t02 = AbstractC0787C.f13676a;
            this.f13677a.setTransitionVisibility(this.f13678b);
            ViewGroup viewGroup = this.f13679c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        g(false);
    }
}
