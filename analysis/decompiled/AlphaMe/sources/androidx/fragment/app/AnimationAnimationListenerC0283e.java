package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;

/* renamed from: androidx.fragment.app.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class AnimationAnimationListenerC0283e implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q0 f3731a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f3732b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f3733c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0288j f3734d;

    public AnimationAnimationListenerC0283e(View view, ViewGroup viewGroup, C0288j c0288j, q0 q0Var) {
        this.f3731a = q0Var;
        this.f3732b = viewGroup;
        this.f3733c = view;
        this.f3734d = c0288j;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.f3732b.post(new RunnableC0282d(0, this));
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Animation from operation " + this.f3731a + " has ended.");
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "Animation from operation " + this.f3731a + " has reached onAnimationStart.");
        }
    }
}
