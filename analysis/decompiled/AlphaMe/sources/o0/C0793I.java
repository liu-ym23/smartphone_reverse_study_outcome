package o0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.stepos.alphame.R;

/* renamed from: o0.I, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0793I extends AnimatorListenerAdapter implements q {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f13683a;

    /* renamed from: b, reason: collision with root package name */
    public final View f13684b;

    /* renamed from: c, reason: collision with root package name */
    public final View f13685c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13686d = true;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0801g f13687e;

    public C0793I(C0801g c0801g, ViewGroup viewGroup, View view, View view2) {
        this.f13687e = c0801g;
        this.f13683a = viewGroup;
        this.f13684b = view;
        this.f13685c = view2;
    }

    @Override // o0.q
    public final void a() {
    }

    @Override // o0.q
    public final void b() {
    }

    @Override // o0.q
    public final void d(s sVar) {
        if (this.f13686d) {
            g();
        }
    }

    @Override // o0.q
    public final void e(s sVar) {
    }

    @Override // o0.q
    public final void f(s sVar) {
        sVar.y(this);
    }

    public final void g() {
        this.f13685c.setTag(R.id.save_overlay_view, null);
        this.f13683a.getOverlay().remove(this.f13684b);
        this.f13686d = false;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z4) {
        if (z4) {
            return;
        }
        g();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        this.f13683a.getOverlay().remove(this.f13684b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        View view = this.f13684b;
        if (view.getParent() == null) {
            this.f13683a.getOverlay().add(view);
        } else {
            this.f13687e.cancel();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator, boolean z4) {
        if (z4) {
            View view = this.f13685c;
            View view2 = this.f13684b;
            view.setTag(R.id.save_overlay_view, view2);
            this.f13683a.getOverlay().add(view2);
            this.f13686d = true;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        g();
    }
}
