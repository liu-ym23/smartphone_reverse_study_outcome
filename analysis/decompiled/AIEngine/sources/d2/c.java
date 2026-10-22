package d2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import com.stepos.aiengine.R;
import d2.i;
import d2.r;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends v {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends AnimatorListenerAdapter implements i.d {

        /* renamed from: a, reason: collision with root package name */
        public final View f8272a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f8273b = false;

        public a(View view) {
            this.f8272a = view;
        }

        @Override // d2.i.d
        public final void b() {
            float transitionAlpha;
            View view = this.f8272a;
            if (view.getVisibility() == 0) {
                r.a aVar = r.f8328a;
                transitionAlpha = view.getTransitionAlpha();
            } else {
                transitionAlpha = 0.0f;
            }
            view.setTag(R.id.transition_pause_alpha, Float.valueOf(transitionAlpha));
        }

        @Override // d2.i.d
        public final void d() {
            this.f8272a.setTag(R.id.transition_pause_alpha, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            r.a aVar = r.f8328a;
            this.f8272a.setTransitionAlpha(1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            View view = this.f8272a;
            if (view.hasOverlappingRendering() && view.getLayerType() == 0) {
                this.f8273b = true;
                view.setLayerType(2, null);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator, boolean z) {
            boolean z3 = this.f8273b;
            View view = this.f8272a;
            if (z3) {
                view.setLayerType(0, null);
            }
            if (z) {
                return;
            }
            r.a aVar = r.f8328a;
            view.setTransitionAlpha(1.0f);
        }

        @Override // d2.i.d
        public final void a(i iVar) {
        }

        @Override // d2.i.d
        public final void c(i iVar) {
        }

        @Override // d2.i.d
        public final void e(i iVar) {
        }

        @Override // d2.i.d
        public final void g(i iVar) {
        }
    }

    public c(int i10) {
        this.E = i10;
    }

    public static float N(p pVar, float f8) {
        Float f9;
        return (pVar == null || (f9 = (Float) pVar.f8325a.get("android:fade:transitionAlpha")) == null) ? f8 : f9.floatValue();
    }

    public final ObjectAnimator M(View view, float f8, float f9) {
        if (f8 == f9) {
            return null;
        }
        r.a aVar = r.f8328a;
        view.setTransitionAlpha(f8);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, r.f8328a, f9);
        a aVar2 = new a(view);
        objectAnimatorOfFloat.addListener(aVar2);
        p().b(aVar2);
        return objectAnimatorOfFloat;
    }

    @Override // d2.i
    public final void h(p pVar) {
        v.J(pVar);
        View view = pVar.f8326b;
        Float fValueOf = (Float) view.getTag(R.id.transition_pause_alpha);
        if (fValueOf == null) {
            if (view.getVisibility() == 0) {
                r.a aVar = r.f8328a;
                fValueOf = Float.valueOf(view.getTransitionAlpha());
            } else {
                fValueOf = Float.valueOf(0.0f);
            }
        }
        pVar.f8325a.put("android:fade:transitionAlpha", fValueOf);
    }
}
