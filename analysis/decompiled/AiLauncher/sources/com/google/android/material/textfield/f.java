package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R$attr;
import com.google.android.material.R$drawable;
import com.google.android.material.R$string;
import com.stepos.ailauncher.chat.wake.circle.F;

/* loaded from: classes2.dex */
public class f extends s {

    /* renamed from: e, reason: collision with root package name */
    public final int f21575e;

    /* renamed from: f, reason: collision with root package name */
    public final int f21576f;

    /* renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f21577g;

    /* renamed from: h, reason: collision with root package name */
    public final TimeInterpolator f21578h;

    /* renamed from: i, reason: collision with root package name */
    public EditText f21579i;

    /* renamed from: j, reason: collision with root package name */
    public final View.OnClickListener f21580j;

    /* renamed from: k, reason: collision with root package name */
    public final View.OnFocusChangeListener f21581k;

    /* renamed from: l, reason: collision with root package name */
    public AnimatorSet f21582l;

    /* renamed from: m, reason: collision with root package name */
    public ValueAnimator f21583m;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f.this.f21641b.a0(true);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.f21641b.a0(false);
        }
    }

    public f(r rVar) {
        super(rVar);
        this.f21580j = new View.OnClickListener() { // from class: com.google.android.material.textfield.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.v(this.f21570a, view);
            }
        };
        this.f21581k = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.b
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                f fVar = this.f21571a;
                fVar.A(fVar.E());
            }
        };
        Context context = rVar.getContext();
        int i10 = R$attr.motionDurationShort3;
        this.f21575e = T2.h.f(context, i10, 100);
        this.f21576f = T2.h.f(rVar.getContext(), i10, F.GESTURE_HEIGHT_DP);
        this.f21577g = T2.h.g(rVar.getContext(), R$attr.motionEasingLinearInterpolator, E2.a.f2339a);
        this.f21578h = T2.h.g(rVar.getContext(), R$attr.motionEasingEmphasizedInterpolator, E2.a.f2342d);
    }

    public static /* synthetic */ void v(f fVar, View view) {
        EditText editText = fVar.f21579i;
        if (editText == null) {
            return;
        }
        Editable text = editText.getText();
        if (text != null) {
            text.clear();
        }
        fVar.r();
    }

    public static /* synthetic */ void x(f fVar, ValueAnimator valueAnimator) {
        fVar.getClass();
        fVar.f21643d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static /* synthetic */ void y(f fVar, ValueAnimator valueAnimator) {
        fVar.getClass();
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        fVar.f21643d.setScaleX(fFloatValue);
        fVar.f21643d.setScaleY(fFloatValue);
    }

    public final void A(boolean z10) {
        boolean z11 = this.f21641b.F() == z10;
        if (z10 && !this.f21582l.isRunning()) {
            this.f21583m.cancel();
            this.f21582l.start();
            if (z11) {
                this.f21582l.end();
                return;
            }
            return;
        }
        if (z10) {
            return;
        }
        this.f21582l.cancel();
        this.f21583m.start();
        if (z11) {
            this.f21583m.end();
        }
    }

    public final ValueAnimator B(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f21577g);
        valueAnimatorOfFloat.setDuration(this.f21575e);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.x(this.f21572a, valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    public final ValueAnimator C() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(this.f21578h);
        valueAnimatorOfFloat.setDuration(this.f21576f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.y(this.f21574a, valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    public final void D() {
        ValueAnimator valueAnimatorC = C();
        ValueAnimator valueAnimatorB = B(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f21582l = animatorSet;
        animatorSet.playTogether(valueAnimatorC, valueAnimatorB);
        this.f21582l.addListener(new a());
        ValueAnimator valueAnimatorB2 = B(1.0f, 0.0f);
        this.f21583m = valueAnimatorB2;
        valueAnimatorB2.addListener(new b());
    }

    public final boolean E() {
        EditText editText = this.f21579i;
        if (editText != null) {
            return (editText.hasFocus() || this.f21643d.hasFocus()) && this.f21579i.getText().length() > 0;
        }
        return false;
    }

    @Override // com.google.android.material.textfield.s
    public void a(Editable editable) {
        if (this.f21641b.w() != null) {
            return;
        }
        A(E());
    }

    @Override // com.google.android.material.textfield.s
    public int c() {
        return R$string.clear_text_end_icon_content_description;
    }

    @Override // com.google.android.material.textfield.s
    public int d() {
        return R$drawable.mtrl_ic_cancel;
    }

    @Override // com.google.android.material.textfield.s
    public View.OnFocusChangeListener e() {
        return this.f21581k;
    }

    @Override // com.google.android.material.textfield.s
    public View.OnClickListener f() {
        return this.f21580j;
    }

    @Override // com.google.android.material.textfield.s
    public View.OnFocusChangeListener g() {
        return this.f21581k;
    }

    @Override // com.google.android.material.textfield.s
    public void n(EditText editText) {
        this.f21579i = editText;
        this.f21640a.setEndIconVisible(E());
    }

    @Override // com.google.android.material.textfield.s
    public void q(boolean z10) {
        if (this.f21641b.w() == null) {
            return;
        }
        A(z10);
    }

    @Override // com.google.android.material.textfield.s
    public void s() {
        D();
    }

    @Override // com.google.android.material.textfield.s
    public void u() {
        EditText editText = this.f21579i;
        if (editText != null) {
            editText.post(new Runnable() { // from class: com.google.android.material.textfield.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f21573a.A(true);
                }
            });
        }
    }
}
