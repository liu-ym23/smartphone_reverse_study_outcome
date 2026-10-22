package com.google.android.material.textfield;

import D7.N;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import c3.AbstractC0873c;
import com.stepos.ability.R;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class q {

    /* renamed from: A, reason: collision with root package name */
    public ColorStateList f2685A;

    /* renamed from: B, reason: collision with root package name */
    public Typeface f2686B;

    /* renamed from: a, reason: collision with root package name */
    public final int f2687a;
    public final int b;
    public final int c;
    public final TimeInterpolator d;
    public final TimeInterpolator e;
    public final TimeInterpolator f;
    public final Context g;
    public final TextInputLayout h;
    public LinearLayout i;

    /* renamed from: j, reason: collision with root package name */
    public int f2688j;
    public FrameLayout k;
    public AnimatorSet l;
    public final float m;
    public int n;
    public int o;
    public CharSequence p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2689q;

    /* renamed from: r, reason: collision with root package name */
    public AppCompatTextView f2690r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f2691s;

    /* renamed from: t, reason: collision with root package name */
    public int f2692t;
    public int u;

    /* renamed from: v, reason: collision with root package name */
    public ColorStateList f2693v;

    /* renamed from: w, reason: collision with root package name */
    public CharSequence f2694w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f2695x;
    public AppCompatTextView y;

    /* renamed from: z, reason: collision with root package name */
    public int f2696z;

    public q(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.g = context;
        this.h = textInputLayout;
        this.m = context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
        this.f2687a = N.N(context, R.attr.motionDurationShort4, 217);
        this.b = N.N(context, R.attr.motionDurationMedium4, 167);
        this.c = N.N(context, R.attr.motionDurationShort4, 167);
        this.d = N.O(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, Q2.a.d);
        LinearInterpolator linearInterpolator = Q2.a.f1097a;
        this.e = N.O(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, linearInterpolator);
        this.f = N.O(context, R.attr.motionEasingLinearInterpolator, linearInterpolator);
    }

    public final void a(AppCompatTextView appCompatTextView, int i) {
        if (this.i == null && this.k == null) {
            Context context = this.g;
            LinearLayout linearLayout = new LinearLayout(context);
            this.i = linearLayout;
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.i;
            TextInputLayout textInputLayout = this.h;
            textInputLayout.addView(linearLayout2, -1, -2);
            this.k = new FrameLayout(context);
            this.i.addView(this.k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (textInputLayout.getEditText() != null) {
                b();
            }
        }
        if (i == 0 || i == 1) {
            this.k.setVisibility(0);
            this.k.addView(appCompatTextView);
        } else {
            this.i.addView(appCompatTextView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.i.setVisibility(0);
        this.f2688j++;
    }

    public final void b() {
        if (this.i != null) {
            TextInputLayout textInputLayout = this.h;
            if (textInputLayout.getEditText() != null) {
                EditText editText = textInputLayout.getEditText();
                Context context = this.g;
                boolean zD = AbstractC0873c.d(context);
                LinearLayout linearLayout = this.i;
                int paddingStart = editText.getPaddingStart();
                if (zD) {
                    paddingStart = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top);
                if (zD) {
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_top);
                }
                int paddingEnd = editText.getPaddingEnd();
                if (zD) {
                    paddingEnd = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                linearLayout.setPaddingRelative(paddingStart, dimensionPixelSize, paddingEnd, 0);
            }
        }
    }

    public final void c() {
        AnimatorSet animatorSet = this.l;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public final void d(ArrayList arrayList, boolean z10, AppCompatTextView appCompatTextView, int i, int i6, int i10) {
        if (appCompatTextView == null || !z10) {
            return;
        }
        if (i == i10 || i == i6) {
            boolean z11 = i10 == i;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(appCompatTextView, (Property<AppCompatTextView, Float>) View.ALPHA, z11 ? 1.0f : 0.0f);
            int i11 = this.c;
            objectAnimatorOfFloat.setDuration(z11 ? this.b : i11);
            objectAnimatorOfFloat.setInterpolator(z11 ? this.e : this.f);
            if (i == i10 && i6 != 0) {
                objectAnimatorOfFloat.setStartDelay(i11);
            }
            arrayList.add(objectAnimatorOfFloat);
            if (i10 != i || i6 == 0) {
                return;
            }
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(appCompatTextView, (Property<AppCompatTextView, Float>) View.TRANSLATION_Y, -this.m, 0.0f);
            objectAnimatorOfFloat2.setDuration(this.f2687a);
            objectAnimatorOfFloat2.setInterpolator(this.d);
            objectAnimatorOfFloat2.setStartDelay(i11);
            arrayList.add(objectAnimatorOfFloat2);
        }
    }

    public final TextView e(int i) {
        if (i == 1) {
            return this.f2690r;
        }
        if (i != 2) {
            return null;
        }
        return this.y;
    }

    public final void f() {
        this.p = null;
        c();
        if (this.n == 1) {
            if (!this.f2695x || TextUtils.isEmpty(this.f2694w)) {
                this.o = 0;
            } else {
                this.o = 2;
            }
        }
        i(this.n, this.o, h(this.f2690r, ""));
    }

    public final void g(AppCompatTextView appCompatTextView, int i) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.i;
        if (linearLayout == null) {
            return;
        }
        if ((i == 0 || i == 1) && (frameLayout = this.k) != null) {
            frameLayout.removeView(appCompatTextView);
        } else {
            linearLayout.removeView(appCompatTextView);
        }
        int i6 = this.f2688j - 1;
        this.f2688j = i6;
        LinearLayout linearLayout2 = this.i;
        if (i6 == 0) {
            linearLayout2.setVisibility(8);
        }
    }

    public final boolean h(AppCompatTextView appCompatTextView, CharSequence charSequence) {
        TextInputLayout textInputLayout = this.h;
        if (textInputLayout.isLaidOut() && textInputLayout.isEnabled()) {
            return (this.o == this.n && appCompatTextView != null && TextUtils.equals(appCompatTextView.getText(), charSequence)) ? false : true;
        }
        return false;
    }

    public final void i(int i, int i6, boolean z10) {
        TextView textViewE;
        TextView textViewE2;
        q qVar = this;
        if (i == i6) {
            return;
        }
        if (z10) {
            AnimatorSet animatorSet = new AnimatorSet();
            qVar.l = animatorSet;
            ArrayList arrayList = new ArrayList();
            qVar.d(arrayList, qVar.f2695x, qVar.y, 2, i, i6);
            qVar.d(arrayList, qVar.f2689q, qVar.f2690r, 1, i, i6);
            int size = arrayList.size();
            long jMax = 0;
            for (int i10 = 0; i10 < size; i10++) {
                Animator animator = (Animator) arrayList.get(i10);
                jMax = Math.max(jMax, animator.getDuration() + animator.getStartDelay());
            }
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 0);
            valueAnimatorOfInt.setDuration(jMax);
            arrayList.add(0, valueAnimatorOfInt);
            animatorSet.playTogether(arrayList);
            o oVar = new o(this, i6, e(i), i, qVar.e(i6));
            qVar = this;
            animatorSet.addListener(oVar);
            animatorSet.start();
        } else if (i != i6) {
            if (i6 != 0 && (textViewE2 = qVar.e(i6)) != null) {
                textViewE2.setVisibility(0);
                textViewE2.setAlpha(1.0f);
            }
            if (i != 0 && (textViewE = e(i)) != null) {
                textViewE.setVisibility(4);
                if (i == 1) {
                    textViewE.setText((CharSequence) null);
                }
            }
            qVar.n = i6;
        }
        TextInputLayout textInputLayout = qVar.h;
        textInputLayout.t();
        textInputLayout.w(z10, false);
        textInputLayout.z();
    }
}
