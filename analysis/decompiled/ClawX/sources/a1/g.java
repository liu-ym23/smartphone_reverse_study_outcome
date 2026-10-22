package a1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.stepos.stepclaw.R;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g extends AnimatorListenerAdapter implements m {

    /* renamed from: a, reason: collision with root package name */
    public final View f24a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f25b = false;

    public g(View view) {
        this.f24a = view;
    }

    @Override // a1.m
    public final void b() {
        float transitionAlpha;
        View view = this.f24a;
        if (view.getVisibility() == 0) {
            b bVar = y.f78a;
            transitionAlpha = view.getTransitionAlpha();
        } else {
            transitionAlpha = 0.0f;
        }
        view.setTag(R.id.transition_pause_alpha, Float.valueOf(transitionAlpha));
    }

    @Override // a1.m
    public final void d() {
        this.f24a.setTag(R.id.transition_pause_alpha, null);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        b bVar = y.f78a;
        this.f24a.setTransitionAlpha(1.0f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        onAnimationEnd(animator, false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        View view = this.f24a;
        if (view.hasOverlappingRendering() && view.getLayerType() == 0) {
            this.f25b = true;
            view.setLayerType(2, null);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z) {
        boolean z2 = this.f25b;
        View view = this.f24a;
        if (z2) {
            view.setLayerType(0, null);
        }
        if (z) {
            return;
        }
        b bVar = y.f78a;
        view.setTransitionAlpha(1.0f);
    }

    @Override // a1.m
    public final void a(o oVar) {
    }

    @Override // a1.m
    public final void c(o oVar) {
    }

    @Override // a1.m
    public final void e(o oVar) {
    }

    @Override // a1.m
    public final void f(o oVar) {
    }
}
