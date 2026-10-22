package com.google.android.material.textfield;

import D7.N;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.datepicker.ViewOnFocusChangeListenerC0907j;
import com.google.android.material.internal.CheckableImageButton;
import com.stepos.ability.R;

/* loaded from: classes3.dex */
public final class c extends n {
    public final int e;
    public final int f;
    public final TimeInterpolator g;
    public final TimeInterpolator h;
    public EditText i;

    /* renamed from: j, reason: collision with root package name */
    public final A6.b f2663j;
    public final ViewOnFocusChangeListenerC0907j k;
    public AnimatorSet l;
    public ValueAnimator m;

    public c(m mVar) {
        super(mVar);
        this.f2663j = new A6.b(this, 4);
        this.k = new ViewOnFocusChangeListenerC0907j(this, 1);
        this.e = N.N(mVar.getContext(), R.attr.motionDurationShort3, 100);
        this.f = N.N(mVar.getContext(), R.attr.motionDurationShort3, 150);
        this.g = N.O(mVar.getContext(), R.attr.motionEasingLinearInterpolator, Q2.a.f1097a);
        this.h = N.O(mVar.getContext(), R.attr.motionEasingEmphasizedInterpolator, Q2.a.d);
    }

    @Override // com.google.android.material.textfield.n
    public final void a() {
        if (this.b.p != null) {
            return;
        }
        t(u());
    }

    @Override // com.google.android.material.textfield.n
    public final int c() {
        return R.string.clear_text_end_icon_content_description;
    }

    @Override // com.google.android.material.textfield.n
    public final int d() {
        return R.drawable.mtrl_ic_cancel;
    }

    @Override // com.google.android.material.textfield.n
    public final View.OnFocusChangeListener e() {
        return this.k;
    }

    @Override // com.google.android.material.textfield.n
    public final View.OnClickListener f() {
        return this.f2663j;
    }

    @Override // com.google.android.material.textfield.n
    public final View.OnFocusChangeListener g() {
        return this.k;
    }

    @Override // com.google.android.material.textfield.n
    public final void m(EditText editText) {
        this.i = editText;
        this.f2682a.setEndIconVisible(u());
    }

    @Override // com.google.android.material.textfield.n
    public final void p(boolean z10) {
        if (this.b.p == null) {
            return;
        }
        t(z10);
    }

    @Override // com.google.android.material.textfield.n
    public final void r() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(this.h);
        valueAnimatorOfFloat.setDuration(this.f);
        final int i = 1;
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.textfield.a
            public final /* synthetic */ c b;

            {
                this.b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i6 = i;
                c cVar = this.b;
                cVar.getClass();
                switch (i6) {
                    case 0:
                        cVar.d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = cVar.d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.g;
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        int i6 = this.e;
        valueAnimatorOfFloat2.setDuration(i6);
        final int i10 = 0;
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.textfield.a
            public final /* synthetic */ c b;

            {
                this.b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i62 = i10;
                c cVar = this.b;
                cVar.getClass();
                switch (i62) {
                    case 0:
                        cVar.d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = cVar.d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        this.l = animatorSet;
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.l.addListener(new b(this, i10));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat3.setDuration(i6);
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.google.android.material.textfield.a
            public final /* synthetic */ c b;

            {
                this.b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                int i62 = i10;
                c cVar = this.b;
                cVar.getClass();
                switch (i62) {
                    case 0:
                        cVar.d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        break;
                    default:
                        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                        CheckableImageButton checkableImageButton = cVar.d;
                        checkableImageButton.setScaleX(fFloatValue);
                        checkableImageButton.setScaleY(fFloatValue);
                        break;
                }
            }
        });
        this.m = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.addListener(new b(this, i));
    }

    @Override // com.google.android.material.textfield.n
    public final void s() {
        EditText editText = this.i;
        if (editText != null) {
            editText.post(new D6.b(this, 19));
        }
    }

    public final void t(boolean z10) {
        boolean z11 = this.b.d() == z10;
        if (z10 && !this.l.isRunning()) {
            this.m.cancel();
            this.l.start();
            if (z11) {
                this.l.end();
                return;
            }
            return;
        }
        if (z10) {
            return;
        }
        this.l.cancel();
        this.m.start();
        if (z11) {
            this.m.end();
        }
    }

    public final boolean u() {
        EditText editText = this.i;
        if (editText != null) {
            return (editText.hasFocus() || this.d.hasFocus()) && this.i.getText().length() > 0;
        }
        return false;
    }
}
