package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class Fade extends Visibility {

    public class a extends o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f4977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Fade f4978b;

        public a(Fade r10, View r11) {
            this.f4978b = r10;
            this.f4977a = r11;
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition r10) {
            y.h(this.f4977a, 1.0f);
            y.a(this.f4977a);
            r10.removeListener(this);
        }
    }

    public static class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f4979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f4980b;

        public b(View r10) {
            this.f4980b = false;
            this.f4979a = r10;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r10) {
            y.h(this.f4979a, 1.0f);
            if (this.f4980b == false) goto L6;
            this.f4979a.setLayerType(0, null);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r10) {
            if (ViewCompat.P(this.f4979a) == true) goto L5;
            return;
        L5:
            if (this.f4979a.getLayerType() != 0) goto L9;
            this.f4980b = true;
            this.f4979a.setLayerType(2, null);
            return;
        }
    }

    public Fade(int r10) {
        setMode(r10);
    }

    public static float u(s r10, float r11) {
        if (r10 == null) goto L7;
        Float r12 = (Float) r10.f5085a.get("android:fade:transitionAlpha");
        if (r12 != null) goto L6;
        return r11;
    L6:
        return r12.floatValue();
    L7:
        return r11;
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(s r10) {
        super.captureStartValues(r10);
        r10.f5085a.put("android:fade:transitionAlpha", Float.valueOf(y.c(r10.f5086b)));
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup r10, View r11, s r12, s r13) {
        float r14 = 0.0f;
        float r15 = u(r12, 0.0f);
        if (r15 == 1.0f) goto L7;
        r14 = r15;
    L7:
        return t(r11, r14, 1.0f);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup r10, View r11, s r12, s r13) {
        y.e(r11);
        return t(r11, u(r12, 1.0f), 0.0f);
    }

    public final Animator t(View r10, float r11, float r12) {
        if (r11 != r12) goto L6;
        return null;
    L6:
        y.h(r10, r11);
        ObjectAnimator r13 = ObjectAnimator.ofFloat(r10, y.f5104b, new float[]{r12});
        r13.addListener(new b(r10));
        addListener(new a(this, r10));
        return r13;
    }

    @SuppressLint({"RestrictedApi"})
    public Fade(@NonNull Context r10, @NonNull AttributeSet r11) {
        super(r10, r11);
        TypedArray r12 = r10.obtainStyledAttributes(r11, Styleable.f4999f);
        setMode(n.g.c(r12, (XmlResourceParser) r11, "fadingMode", 0, getMode()));
        r12.recycle();
    }
}
