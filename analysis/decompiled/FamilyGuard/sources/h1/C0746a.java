package h1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import h1.InterfaceC0748c;

/* renamed from: h1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0746a {

    /* renamed from: h1.a$a, reason: collision with other inner class name */
    class C0216a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC0748c f17584a;

        C0216a(InterfaceC0748c interfaceC0748c) {
            this.f17584a = interfaceC0748c;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f17584a.b();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f17584a.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Animator a(InterfaceC0748c interfaceC0748c, float f5, float f6, float f7) {
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(interfaceC0748c, (Property<InterfaceC0748c, V>) InterfaceC0748c.C0217c.f17587a, (TypeEvaluator) InterfaceC0748c.b.f17585b, (Object[]) new InterfaceC0748c.e[]{new InterfaceC0748c.e(f5, f6, f7)});
        InterfaceC0748c.e revealInfo = interfaceC0748c.getRevealInfo();
        if (revealInfo == null) {
            throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal((View) interfaceC0748c, (int) f5, (int) f6, revealInfo.f17591c, f7);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfObject, animatorCreateCircularReveal);
        return animatorSet;
    }

    public static Animator.AnimatorListener b(InterfaceC0748c interfaceC0748c) {
        return new C0216a(interfaceC0748c);
    }
}
