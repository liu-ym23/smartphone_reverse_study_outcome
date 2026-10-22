package com.google.android.material.textfield;

import a1.C0409b;
import a1.C0412e;
import a1.C0416i;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import b1.C0553a;

/* loaded from: classes.dex */
class f extends s {

    /* renamed from: e, reason: collision with root package name */
    private final int f13308e;

    /* renamed from: f, reason: collision with root package name */
    private final int f13309f;

    /* renamed from: g, reason: collision with root package name */
    private final TimeInterpolator f13310g;

    /* renamed from: h, reason: collision with root package name */
    private final TimeInterpolator f13311h;

    /* renamed from: i, reason: collision with root package name */
    private EditText f13312i;

    /* renamed from: j, reason: collision with root package name */
    private final View.OnClickListener f13313j;

    /* renamed from: k, reason: collision with root package name */
    private final View.OnFocusChangeListener f13314k;

    /* renamed from: l, reason: collision with root package name */
    private AnimatorSet f13315l;

    /* renamed from: m, reason: collision with root package name */
    private ValueAnimator f13316m;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            f.this.f13374b.a0(true);
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            f.this.f13374b.a0(false);
        }
    }

    f(r rVar) {
        super(rVar);
        this.f13313j = new View.OnClickListener() { // from class: com.google.android.material.textfield.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.v(this.f13303a, view);
            }
        };
        this.f13314k = new View.OnFocusChangeListener() { // from class: com.google.android.material.textfield.b
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z5) {
                f fVar = this.f13304a;
                fVar.A(fVar.E());
            }
        };
        Context context = rVar.getContext();
        int i5 = C0409b.f6692B;
        this.f13308e = o1.e.f(context, i5, 100);
        this.f13309f = o1.e.f(rVar.getContext(), i5, 150);
        this.f13310g = o1.e.g(rVar.getContext(), C0409b.f6697G, C0553a.f11783a);
        this.f13311h = o1.e.g(rVar.getContext(), C0409b.f6696F, C0553a.f11786d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(boolean z5) {
        boolean z6 = this.f13374b.F() == z5;
        if (z5 && !this.f13315l.isRunning()) {
            this.f13316m.cancel();
            this.f13315l.start();
            if (z6) {
                this.f13315l.end();
                return;
            }
            return;
        }
        if (z5) {
            return;
        }
        this.f13315l.cancel();
        this.f13316m.start();
        if (z6) {
            this.f13316m.end();
        }
    }

    private ValueAnimator B(float... fArr) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.setInterpolator(this.f13310g);
        valueAnimatorOfFloat.setDuration(this.f13308e);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.x(this.f13305a, valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    private ValueAnimator C() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(this.f13311h);
        valueAnimatorOfFloat.setDuration(this.f13309f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.textfield.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.y(this.f13307a, valueAnimator);
            }
        });
        return valueAnimatorOfFloat;
    }

    private void D() {
        ValueAnimator valueAnimatorC = C();
        ValueAnimator valueAnimatorB = B(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f13315l = animatorSet;
        animatorSet.playTogether(valueAnimatorC, valueAnimatorB);
        this.f13315l.addListener(new a());
        ValueAnimator valueAnimatorB2 = B(1.0f, 0.0f);
        this.f13316m = valueAnimatorB2;
        valueAnimatorB2.addListener(new b());
    }

    private boolean E() {
        EditText editText = this.f13312i;
        if (editText != null) {
            return (editText.hasFocus() || this.f13376d.hasFocus()) && this.f13312i.getText().length() > 0;
        }
        return false;
    }

    public static /* synthetic */ void v(f fVar, View view) {
        EditText editText = fVar.f13312i;
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
        fVar.f13376d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    public static /* synthetic */ void y(f fVar, ValueAnimator valueAnimator) {
        fVar.getClass();
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        fVar.f13376d.setScaleX(fFloatValue);
        fVar.f13376d.setScaleY(fFloatValue);
    }

    @Override // com.google.android.material.textfield.s
    void a(Editable editable) {
        if (this.f13374b.w() != null) {
            return;
        }
        A(E());
    }

    @Override // com.google.android.material.textfield.s
    int c() {
        return C0416i.f6889e;
    }

    @Override // com.google.android.material.textfield.s
    int d() {
        return C0412e.f6816j;
    }

    @Override // com.google.android.material.textfield.s
    View.OnFocusChangeListener e() {
        return this.f13314k;
    }

    @Override // com.google.android.material.textfield.s
    View.OnClickListener f() {
        return this.f13313j;
    }

    @Override // com.google.android.material.textfield.s
    View.OnFocusChangeListener g() {
        return this.f13314k;
    }

    @Override // com.google.android.material.textfield.s
    public void n(EditText editText) {
        this.f13312i = editText;
        this.f13373a.setEndIconVisible(E());
    }

    @Override // com.google.android.material.textfield.s
    void q(boolean z5) {
        if (this.f13374b.w() == null) {
            return;
        }
        A(z5);
    }

    @Override // com.google.android.material.textfield.s
    void s() {
        D();
    }

    @Override // com.google.android.material.textfield.s
    void u() {
        EditText editText = this.f13312i;
        if (editText != null) {
            editText.post(new Runnable() { // from class: com.google.android.material.textfield.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13306a.A(true);
                }
            });
        }
    }
}
