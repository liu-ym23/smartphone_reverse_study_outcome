package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: androidx.fragment.app.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0281c extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f3715a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f3716b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f3717c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ q0 f3718d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0288j f3719e;

    public C0281c(ViewGroup viewGroup, View view, boolean z4, q0 q0Var, C0288j c0288j) {
        this.f3715a = viewGroup;
        this.f3716b = view;
        this.f3717c = z4;
        this.f3718d = q0Var;
        this.f3719e = c0288j;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ViewGroup viewGroup = this.f3715a;
        View view = this.f3716b;
        viewGroup.endViewTransition(view);
        boolean z4 = this.f3717c;
        q0 q0Var = this.f3718d;
        if (z4) {
            B0.g.a(q0Var.f3801a, view);
        }
        this.f3719e.a();
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Animator from operation " + q0Var + " has ended.");
        }
    }
}
