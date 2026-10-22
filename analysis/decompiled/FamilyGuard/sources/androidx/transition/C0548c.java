package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.k;

/* renamed from: androidx.transition.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0548c extends E {

    /* renamed from: androidx.transition.c$a */
    private static class a extends AnimatorListenerAdapter implements k.f {

        /* renamed from: a, reason: collision with root package name */
        private final View f11396a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f11397b = false;

        a(View view) {
            this.f11396a = view;
        }

        @Override // androidx.transition.k.f
        public void a(k kVar) {
        }

        @Override // androidx.transition.k.f
        public void b(k kVar) {
            this.f11396a.setTag(h.f11420d, Float.valueOf(this.f11396a.getVisibility() == 0 ? y.b(this.f11396a) : 0.0f));
        }

        @Override // androidx.transition.k.f
        public void d(k kVar) {
        }

        @Override // androidx.transition.k.f
        public void e(k kVar) {
        }

        @Override // androidx.transition.k.f
        public void f(k kVar, boolean z5) {
        }

        @Override // androidx.transition.k.f
        public void g(k kVar) {
            this.f11396a.setTag(h.f11420d, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            y.e(this.f11396a, 1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f11396a.hasOverlappingRendering() && this.f11396a.getLayerType() == 0) {
                this.f11397b = true;
                this.f11396a.setLayerType(2, null);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z5) {
            if (this.f11397b) {
                this.f11396a.setLayerType(0, null);
            }
            if (z5) {
                return;
            }
            y.e(this.f11396a, 1.0f);
            y.a(this.f11396a);
        }
    }

    public C0548c(int i5) {
        q0(i5);
    }

    private Animator r0(View view, float f5, float f6) {
        if (f5 == f6) {
            return null;
        }
        y.e(view, f5);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, y.f11500b, f6);
        a aVar = new a(view);
        objectAnimatorOfFloat.addListener(aVar);
        C().b(aVar);
        return objectAnimatorOfFloat;
    }

    private static float s0(v vVar, float f5) {
        Float f6;
        return (vVar == null || (f6 = (Float) vVar.f11492a.get("android:fade:transitionAlpha")) == null) ? f5 : f6.floatValue();
    }

    @Override // androidx.transition.E, androidx.transition.k
    public void l(v vVar) {
        super.l(vVar);
        Float fValueOf = (Float) vVar.f11493b.getTag(h.f11420d);
        if (fValueOf == null) {
            fValueOf = vVar.f11493b.getVisibility() == 0 ? Float.valueOf(y.b(vVar.f11493b)) : Float.valueOf(0.0f);
        }
        vVar.f11492a.put("android:fade:transitionAlpha", fValueOf);
    }

    @Override // androidx.transition.E
    public Animator m0(ViewGroup viewGroup, View view, v vVar, v vVar2) {
        y.c(view);
        return r0(view, s0(vVar, 0.0f), 1.0f);
    }

    @Override // androidx.transition.E
    public Animator o0(ViewGroup viewGroup, View view, v vVar, v vVar2) {
        y.c(view);
        Animator animatorR0 = r0(view, s0(vVar, 1.0f), 0.0f);
        if (animatorR0 == null) {
            y.e(view, s0(vVar2, 1.0f));
        }
        return animatorR0;
    }

    public C0548c() {
    }
}
