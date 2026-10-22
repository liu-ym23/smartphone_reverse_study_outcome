package a1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b0 extends AnimatorListenerAdapter implements m {

    /* renamed from: a, reason: collision with root package name */
    public final View f2a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewGroup f4c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f6f = false;
    public final boolean d = true;

    public b0(View view, int i8) {
        this.f2a = view;
        this.f3b = i8;
        this.f4c = (ViewGroup) view.getParent();
        g(true);
    }

    @Override // a1.m
    public final void b() {
        g(false);
        if (this.f6f) {
            return;
        }
        b bVar = y.f78a;
        this.f2a.setTransitionVisibility(this.f3b);
    }

    @Override // a1.m
    public final void d() {
        g(true);
        if (this.f6f) {
            return;
        }
        b bVar = y.f78a;
        this.f2a.setTransitionVisibility(0);
    }

    @Override // a1.m
    public final void f(o oVar) {
        oVar.x(this);
    }

    public final void g(boolean z) {
        ViewGroup viewGroup;
        if (!this.d || this.f5e == z || (viewGroup = this.f4c) == null) {
            return;
        }
        this.f5e = z;
        x.b(viewGroup, z);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f6f = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (!this.f6f) {
            b bVar = y.f78a;
            this.f2a.setTransitionVisibility(this.f3b);
            ViewGroup viewGroup = this.f4c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        g(false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator, boolean z) {
        if (z) {
            b bVar = y.f78a;
            this.f2a.setTransitionVisibility(0);
            ViewGroup viewGroup = this.f4c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z) {
        if (z) {
            return;
        }
        if (!this.f6f) {
            b bVar = y.f78a;
            this.f2a.setTransitionVisibility(this.f3b);
            ViewGroup viewGroup = this.f4c;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        g(false);
    }

    @Override // a1.m
    public final void c(o oVar) {
    }

    @Override // a1.m
    public final void e(o oVar) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }
}
