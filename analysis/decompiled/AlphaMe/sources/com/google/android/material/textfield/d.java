package com.google.android.material.textfield;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.datepicker.ViewOnFocusChangeListenerC0430i;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import n1.AbstractC0775a;

/* loaded from: classes.dex */
public final class d extends o {

    /* renamed from: e, reason: collision with root package name */
    public final int f11002e;

    /* renamed from: f, reason: collision with root package name */
    public final int f11003f;

    /* renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f11004g;

    /* renamed from: h, reason: collision with root package name */
    public final TimeInterpolator f11005h;

    /* renamed from: i, reason: collision with root package name */
    public EditText f11006i;

    /* renamed from: j, reason: collision with root package name */
    public final ViewOnClickListenerC0435a f11007j;

    /* renamed from: k, reason: collision with root package name */
    public final ViewOnFocusChangeListenerC0430i f11008k;

    /* renamed from: l, reason: collision with root package name */
    public AnimatorSet f11009l;

    /* renamed from: m, reason: collision with root package name */
    public ValueAnimator f11010m;

    public d(n nVar) {
        super(nVar);
        this.f11007j = new ViewOnClickListenerC0435a(0, this);
        this.f11008k = new ViewOnFocusChangeListenerC0430i(1, this);
        this.f11002e = com.stepos.statsrpk.c.L(nVar.getContext(), R.attr.motionDurationShort3, 100);
        this.f11003f = com.stepos.statsrpk.c.L(nVar.getContext(), R.attr.motionDurationShort3, 150);
        this.f11004g = com.stepos.statsrpk.c.M(nVar.getContext(), R.attr.motionEasingLinearInterpolator, AbstractC0775a.f13650a);
        this.f11005h = com.stepos.statsrpk.c.M(nVar.getContext(), R.attr.motionEasingEmphasizedInterpolator, AbstractC0775a.f13653d);
    }

    @Override // com.google.android.material.textfield.o
    public final void a() {
        if (this.f11058b.f11050p != null) {
            return;
        }
        t(u());
    }

    @Override // com.google.android.material.textfield.o
    public final int c() {
        return R.string.clear_text_end_icon_content_description;
    }

    @Override // com.google.android.material.textfield.o
    public final int d() {
        return R.drawable.mtrl_ic_cancel;
    }

    @Override // com.google.android.material.textfield.o
    public final View.OnFocusChangeListener e() {
        return this.f11008k;
    }

    @Override // com.google.android.material.textfield.o
    public final View.OnClickListener f() {
        return this.f11007j;
    }

    @Override // com.google.android.material.textfield.o
    public final View.OnFocusChangeListener g() {
        return this.f11008k;
    }

    @Override // com.google.android.material.textfield.o
    public final void m(EditText editText) {
        this.f11006i = editText;
        this.f11057a.setEndIconVisible(u());
    }

    @Override // com.google.android.material.textfield.o
    public final void p(boolean z4) {
        if (this.f11058b.f11050p == null) {
            return;
        }
        t(z4);
    }

    @Override // com.google.android.material.textfield.o
    public final void r() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(this.f11005h);
        valueAnimatorOfFloat.setDuration(this.f11003f);
        valueAnimatorOfFloat.addUpdateListener(new b(this, 1));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(Property.DEFAULT_FLOAT_VALUE, 1.0f);
        TimeInterpolator timeInterpolator = this.f11004g;
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        int i4 = this.f11002e;
        valueAnimatorOfFloat2.setDuration(i4);
        valueAnimatorOfFloat2.addUpdateListener(new b(this, 0));
        AnimatorSet animatorSet = new AnimatorSet();
        this.f11009l = animatorSet;
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.f11009l.addListener(new c(this, 0));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, Property.DEFAULT_FLOAT_VALUE);
        valueAnimatorOfFloat3.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat3.setDuration(i4);
        valueAnimatorOfFloat3.addUpdateListener(new b(this, 0));
        this.f11010m = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.addListener(new c(this, 1));
    }

    @Override // com.google.android.material.textfield.o
    public final void s() {
        EditText editText = this.f11006i;
        if (editText != null) {
            editText.post(new androidx.activity.d(14, this));
        }
    }

    public final void t(boolean z4) {
        boolean z5 = this.f11058b.d() == z4;
        if (z4 && !this.f11009l.isRunning()) {
            this.f11010m.cancel();
            this.f11009l.start();
            if (z5) {
                this.f11009l.end();
                return;
            }
            return;
        }
        if (z4) {
            return;
        }
        this.f11009l.cancel();
        this.f11010m.start();
        if (z5) {
            this.f11010m.end();
        }
    }

    public final boolean u() {
        EditText editText = this.f11006i;
        return editText != null && (editText.hasFocus() || this.f11060d.hasFocus()) && this.f11006i.getText().length() > 0;
    }
}
