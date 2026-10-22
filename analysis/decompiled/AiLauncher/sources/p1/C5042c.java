package p1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.R$id;
import p1.j;

/* renamed from: p1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C5042c extends G {

    /* renamed from: p1.c$a */
    public static class a extends AnimatorListenerAdapter implements j.h {

        /* renamed from: a, reason: collision with root package name */
        public final View f38114a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f38115b = false;

        public a(View view) {
            this.f38114a = view;
        }

        @Override // p1.j.h
        public void c(j jVar) {
        }

        @Override // p1.j.h
        public void e(j jVar) {
        }

        @Override // p1.j.h
        public void f(j jVar) {
        }

        @Override // p1.j.h
        public void i(j jVar) {
            this.f38114a.setTag(R$id.transition_pause_alpha, Float.valueOf(this.f38114a.getVisibility() == 0 ? C5038A.b(this.f38114a) : 0.0f));
        }

        @Override // p1.j.h
        public void k(j jVar) {
            this.f38114a.setTag(R$id.transition_pause_alpha, null);
        }

        @Override // p1.j.h
        public void l(j jVar, boolean z10) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            C5038A.e(this.f38114a, 1.0f);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f38114a.hasOverlappingRendering() && this.f38114a.getLayerType() == 0) {
                this.f38115b = true;
                this.f38114a.setLayerType(2, null);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z10) {
            if (this.f38115b) {
                this.f38114a.setLayerType(0, null);
            }
            if (z10) {
                return;
            }
            C5038A.e(this.f38114a, 1.0f);
            C5038A.a(this.f38114a);
        }
    }

    public C5042c(int i10) {
        A0(i10);
    }

    public static float C0(w wVar, float f10) {
        Float f11;
        return (wVar == null || (f11 = (Float) wVar.f38221a.get("android:fade:transitionAlpha")) == null) ? f10 : f11.floatValue();
    }

    public final Animator B0(View view, float f10, float f11) {
        if (f10 == f11) {
            return null;
        }
        C5038A.e(view, f10);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, C5038A.f38060b, f11);
        a aVar = new a(view);
        objectAnimatorOfFloat.addListener(aVar);
        F().f(aVar);
        return objectAnimatorOfFloat;
    }

    @Override // p1.j
    public boolean S() {
        return true;
    }

    @Override // p1.G, p1.j
    public void p(w wVar) {
        super.p(wVar);
        Float fValueOf = (Float) wVar.f38222b.getTag(R$id.transition_pause_alpha);
        if (fValueOf == null) {
            fValueOf = wVar.f38222b.getVisibility() == 0 ? Float.valueOf(C5038A.b(wVar.f38222b)) : Float.valueOf(0.0f);
        }
        wVar.f38221a.put("android:fade:transitionAlpha", fValueOf);
    }

    @Override // p1.G
    public Animator w0(ViewGroup viewGroup, View view, w wVar, w wVar2) {
        C5038A.c(view);
        return B0(view, C0(wVar, 0.0f), 1.0f);
    }

    @Override // p1.G
    public Animator y0(ViewGroup viewGroup, View view, w wVar, w wVar2) {
        C5038A.c(view);
        Animator animatorB0 = B0(view, C0(wVar, 1.0f), 0.0f);
        if (animatorB0 == null) {
            C5038A.e(view, C0(wVar2, 1.0f));
        }
        return animatorB0;
    }

    public C5042c() {
    }
}
