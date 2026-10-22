package com.google.android.material.textfield;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.widget.z0;
import com.stepos.aiengine.R;
import com.stepos.backend.onnx.SmsParseCpuModel;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c extends l {

    /* renamed from: e, reason: collision with root package name */
    public final int f5235e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5236f;

    /* renamed from: g, reason: collision with root package name */
    public final TimeInterpolator f5237g;
    public final TimeInterpolator h;

    /* renamed from: i, reason: collision with root package name */
    public EditText f5238i;

    /* renamed from: j, reason: collision with root package name */
    public final com.google.android.material.datepicker.k f5239j;

    /* renamed from: k, reason: collision with root package name */
    public final a f5240k;

    /* renamed from: l, reason: collision with root package name */
    public AnimatorSet f5241l;

    /* renamed from: m, reason: collision with root package name */
    public ValueAnimator f5242m;

    public c(k kVar) {
        super(kVar);
        this.f5239j = new com.google.android.material.datepicker.k(this, 1);
        this.f5240k = new a(this, 0);
        this.f5235e = u4.j.c(kVar.getContext(), R.attr.motionDurationShort3, 100);
        this.f5236f = u4.j.c(kVar.getContext(), R.attr.motionDurationShort3, SmsParseCpuModel.MAX_SEQ_LEN);
        this.f5237g = u4.j.d(kVar.getContext(), R.attr.motionEasingLinearInterpolator, l4.a.f10220a);
        this.h = u4.j.d(kVar.getContext(), R.attr.motionEasingEmphasizedInterpolator, l4.a.f10223d);
    }

    @Override // com.google.android.material.textfield.l
    public final void a() {
        if (this.f5287b.f5272s != null) {
            return;
        }
        s(t());
    }

    @Override // com.google.android.material.textfield.l
    public final int c() {
        return R.string.clear_text_end_icon_content_description;
    }

    @Override // com.google.android.material.textfield.l
    public final int d() {
        return R.drawable.mtrl_ic_cancel;
    }

    @Override // com.google.android.material.textfield.l
    public final View.OnFocusChangeListener e() {
        return this.f5240k;
    }

    @Override // com.google.android.material.textfield.l
    public final View.OnClickListener f() {
        return this.f5239j;
    }

    @Override // com.google.android.material.textfield.l
    public final View.OnFocusChangeListener g() {
        return this.f5240k;
    }

    @Override // com.google.android.material.textfield.l
    public final void l(EditText editText) {
        this.f5238i = editText;
        this.f5286a.setEndIconVisible(t());
    }

    @Override // com.google.android.material.textfield.l
    public final void o(boolean z) {
        if (this.f5287b.f5272s == null) {
            return;
        }
        s(z);
    }

    @Override // com.google.android.material.textfield.l
    public final void q() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        valueAnimatorOfFloat.setInterpolator(this.h);
        valueAnimatorOfFloat.setDuration(this.f5236f);
        int i10 = 1;
        valueAnimatorOfFloat.addUpdateListener(new b(this, 1));
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.f5237g;
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        int i11 = this.f5235e;
        valueAnimatorOfFloat2.setDuration(i11);
        valueAnimatorOfFloat2.addUpdateListener(new b(this, 0));
        AnimatorSet animatorSet = new AnimatorSet();
        this.f5241l = animatorSet;
        animatorSet.playTogether(valueAnimatorOfFloat, valueAnimatorOfFloat2);
        this.f5241l.addListener(new com.google.android.material.bottomappbar.a(this, i10));
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        valueAnimatorOfFloat3.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat3.setDuration(i11);
        valueAnimatorOfFloat3.addUpdateListener(new b(this, 0));
        this.f5242m = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.addListener(new com.google.android.material.appbar.h(this, i10));
    }

    @Override // com.google.android.material.textfield.l
    public final void r() {
        EditText editText = this.f5238i;
        if (editText != null) {
            editText.post(new z0(this, 8));
        }
    }

    public final void s(boolean z) {
        boolean z3 = this.f5287b.d() == z;
        if (z && !this.f5241l.isRunning()) {
            this.f5242m.cancel();
            this.f5241l.start();
            if (z3) {
                this.f5241l.end();
                return;
            }
            return;
        }
        if (z) {
            return;
        }
        this.f5241l.cancel();
        this.f5242m.start();
        if (z3) {
            this.f5242m.end();
        }
    }

    public final boolean t() {
        EditText editText = this.f5238i;
        if (editText != null) {
            return (editText.hasFocus() || this.f5289d.hasFocus()) && this.f5238i.getText().length() > 0;
        }
        return false;
    }
}
