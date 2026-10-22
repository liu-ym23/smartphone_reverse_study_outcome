package a1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.stepos.stepclaw.R;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c0 extends AnimatorListenerAdapter implements m {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f7a;

    /* renamed from: b, reason: collision with root package name */
    public final View f8b;

    /* renamed from: c, reason: collision with root package name */
    public final View f9c;
    public boolean d = true;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ h f10e;

    public c0(h hVar, ViewGroup viewGroup, View view, View view2) {
        this.f10e = hVar;
        this.f7a = viewGroup;
        this.f8b = view;
        this.f9c = view2;
    }

    @Override // a1.m
    public final void c(o oVar) {
        if (this.d) {
            g();
        }
    }

    @Override // a1.m
    public final void f(o oVar) {
        oVar.x(this);
    }

    public final void g() {
        this.f9c.setTag(R.id.save_overlay_view, null);
        this.f7a.getOverlay().remove(this.f8b);
        this.d = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        g();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        this.f7a.getOverlay().remove(this.f8b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        View view = this.f8b;
        if (view.getParent() == null) {
            this.f7a.getOverlay().add(view);
        } else {
            this.f10e.c();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator, boolean z) {
        if (z) {
            View view = this.f9c;
            View view2 = this.f8b;
            view.setTag(R.id.save_overlay_view, view2);
            this.f7a.getOverlay().add(view2);
            this.d = true;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z) {
        if (z) {
            return;
        }
        g();
    }

    @Override // a1.m
    public final void b() {
    }

    @Override // a1.m
    public final void d() {
    }

    @Override // a1.m
    public final void e(o oVar) {
    }
}
