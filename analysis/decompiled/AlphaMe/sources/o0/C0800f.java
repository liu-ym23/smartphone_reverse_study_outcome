package o0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.appcompat.widget.T0;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;

/* renamed from: o0.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0800f extends AnimatorListenerAdapter implements q {

    /* renamed from: a, reason: collision with root package name */
    public final View f13709a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13710b = false;

    public C0800f(View view) {
        this.f13709a = view;
    }

    @Override // o0.q
    public final void a() {
        float transitionAlpha;
        View view = this.f13709a;
        if (view.getVisibility() == 0) {
            T0 t02 = AbstractC0787C.f13676a;
            transitionAlpha = view.getTransitionAlpha();
        } else {
            transitionAlpha = Property.DEFAULT_FLOAT_VALUE;
        }
        view.setTag(R.id.transition_pause_alpha, Float.valueOf(transitionAlpha));
    }

    @Override // o0.q
    public final void b() {
        this.f13709a.setTag(R.id.transition_pause_alpha, null);
    }

    @Override // o0.q
    public final void c(s sVar) {
    }

    @Override // o0.q
    public final void d(s sVar) {
    }

    @Override // o0.q
    public final void e(s sVar) {
    }

    @Override // o0.q
    public final void f(s sVar) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        T0 t02 = AbstractC0787C.f13676a;
        this.f13709a.setTransitionAlpha(1.0f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        onAnimationEnd(animator, false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        View view = this.f13709a;
        if (view.hasOverlappingRendering() && view.getLayerType() == 0) {
            this.f13710b = true;
            view.setLayerType(2, null);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z4) {
        boolean z5 = this.f13710b;
        View view = this.f13709a;
        if (z5) {
            view.setLayerType(0, null);
        }
        if (z4) {
            return;
        }
        T0 t02 = AbstractC0787C.f13676a;
        view.setTransitionAlpha(1.0f);
    }
}
