package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
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
import com.stepos.aiengine.R;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class n {
    public ColorStateList A;
    public Typeface B;

    /* renamed from: a, reason: collision with root package name */
    public final int f5290a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5291b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5292c;

    /* renamed from: d, reason: collision with root package name */
    public final TimeInterpolator f5293d;

    /* renamed from: e, reason: collision with root package name */
    public final TimeInterpolator f5294e;

    /* renamed from: f, reason: collision with root package name */
    public final TimeInterpolator f5295f;

    /* renamed from: g, reason: collision with root package name */
    public final Context f5296g;
    public final TextInputLayout h;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f5297i;

    /* renamed from: j, reason: collision with root package name */
    public int f5298j;

    /* renamed from: k, reason: collision with root package name */
    public FrameLayout f5299k;

    /* renamed from: l, reason: collision with root package name */
    public AnimatorSet f5300l;

    /* renamed from: m, reason: collision with root package name */
    public final float f5301m;

    /* renamed from: n, reason: collision with root package name */
    public int f5302n;

    /* renamed from: o, reason: collision with root package name */
    public int f5303o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f5304p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f5305q;
    public AppCompatTextView r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f5306s;

    /* renamed from: t, reason: collision with root package name */
    public int f5307t;

    /* renamed from: u, reason: collision with root package name */
    public int f5308u;

    /* renamed from: v, reason: collision with root package name */
    public ColorStateList f5309v;

    /* renamed from: w, reason: collision with root package name */
    public CharSequence f5310w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f5311x;

    /* renamed from: y, reason: collision with root package name */
    public AppCompatTextView f5312y;
    public int z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f5313a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f5314b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f5315c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TextView f5316d;

        public a(int i10, TextView textView, int i11, TextView textView2) {
            this.f5313a = i10;
            this.f5314b = textView;
            this.f5315c = i11;
            this.f5316d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            AppCompatTextView appCompatTextView;
            int i10 = this.f5313a;
            n nVar = n.this;
            nVar.f5302n = i10;
            nVar.f5300l = null;
            TextView textView = this.f5314b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f5315c == 1 && (appCompatTextView = nVar.r) != null) {
                    appCompatTextView.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f5316d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                textView2.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator animator) {
            TextView textView = this.f5316d;
            if (textView != null) {
                textView.setVisibility(0);
                textView.setAlpha(0.0f);
            }
        }
    }

    public n(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f5296g = context;
        this.h = textInputLayout;
        this.f5301m = context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
        this.f5290a = u4.j.c(context, R.attr.motionDurationShort4, 217);
        this.f5291b = u4.j.c(context, R.attr.motionDurationMedium4, 167);
        this.f5292c = u4.j.c(context, R.attr.motionDurationShort4, 167);
        this.f5293d = u4.j.d(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, l4.a.f10223d);
        LinearInterpolator linearInterpolator = l4.a.f10220a;
        this.f5294e = u4.j.d(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, linearInterpolator);
        this.f5295f = u4.j.d(context, R.attr.motionEasingLinearInterpolator, linearInterpolator);
    }

    public final void a(AppCompatTextView appCompatTextView, int i10) {
        if (this.f5297i == null && this.f5299k == null) {
            Context context = this.f5296g;
            LinearLayout linearLayout = new LinearLayout(context);
            this.f5297i = linearLayout;
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.f5297i;
            TextInputLayout textInputLayout = this.h;
            textInputLayout.addView(linearLayout2, -1, -2);
            this.f5299k = new FrameLayout(context);
            this.f5297i.addView(this.f5299k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (textInputLayout.getEditText() != null) {
                b();
            }
        }
        if (i10 == 0 || i10 == 1) {
            this.f5299k.setVisibility(0);
            this.f5299k.addView(appCompatTextView);
        } else {
            this.f5297i.addView(appCompatTextView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f5297i.setVisibility(0);
        this.f5298j++;
    }

    public final void b() {
        if (this.f5297i != null) {
            TextInputLayout textInputLayout = this.h;
            if (textInputLayout.getEditText() != null) {
                EditText editText = textInputLayout.getEditText();
                Context context = this.f5296g;
                boolean zD = w4.c.d(context);
                LinearLayout linearLayout = this.f5297i;
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
        AnimatorSet animatorSet = this.f5300l;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public final void d(ArrayList arrayList, boolean z, AppCompatTextView appCompatTextView, int i10, int i11, int i12) {
        if (appCompatTextView == null || !z) {
            return;
        }
        if (i10 == i12 || i10 == i11) {
            boolean z3 = i12 == i10;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(appCompatTextView, (Property<AppCompatTextView, Float>) View.ALPHA, z3 ? 1.0f : 0.0f);
            int i13 = this.f5292c;
            objectAnimatorOfFloat.setDuration(z3 ? this.f5291b : i13);
            objectAnimatorOfFloat.setInterpolator(z3 ? this.f5294e : this.f5295f);
            if (i10 == i12 && i11 != 0) {
                objectAnimatorOfFloat.setStartDelay(i13);
            }
            arrayList.add(objectAnimatorOfFloat);
            if (i12 != i10 || i11 == 0) {
                return;
            }
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(appCompatTextView, (Property<AppCompatTextView, Float>) View.TRANSLATION_Y, -this.f5301m, 0.0f);
            objectAnimatorOfFloat2.setDuration(this.f5290a);
            objectAnimatorOfFloat2.setInterpolator(this.f5293d);
            objectAnimatorOfFloat2.setStartDelay(i13);
            arrayList.add(objectAnimatorOfFloat2);
        }
    }

    public final TextView e(int i10) {
        if (i10 == 1) {
            return this.r;
        }
        if (i10 != 2) {
            return null;
        }
        return this.f5312y;
    }

    public final void f() {
        this.f5304p = null;
        c();
        if (this.f5302n == 1) {
            if (!this.f5311x || TextUtils.isEmpty(this.f5310w)) {
                this.f5303o = 0;
            } else {
                this.f5303o = 2;
            }
        }
        i(this.f5302n, this.f5303o, h(this.r, ""));
    }

    public final void g(AppCompatTextView appCompatTextView, int i10) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.f5297i;
        if (linearLayout == null) {
            return;
        }
        if ((i10 == 0 || i10 == 1) && (frameLayout = this.f5299k) != null) {
            frameLayout.removeView(appCompatTextView);
        } else {
            linearLayout.removeView(appCompatTextView);
        }
        int i11 = this.f5298j - 1;
        this.f5298j = i11;
        LinearLayout linearLayout2 = this.f5297i;
        if (i11 == 0) {
            linearLayout2.setVisibility(8);
        }
    }

    public final boolean h(AppCompatTextView appCompatTextView, CharSequence charSequence) {
        TextInputLayout textInputLayout = this.h;
        if (textInputLayout.isLaidOut() && textInputLayout.isEnabled()) {
            return (this.f5303o == this.f5302n && appCompatTextView != null && TextUtils.equals(appCompatTextView.getText(), charSequence)) ? false : true;
        }
        return false;
    }

    public final void i(int i10, int i11, boolean z) {
        TextView textViewE;
        TextView textViewE2;
        n nVar = this;
        if (i10 == i11) {
            return;
        }
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            nVar.f5300l = animatorSet;
            ArrayList arrayList = new ArrayList();
            nVar.d(arrayList, nVar.f5311x, nVar.f5312y, 2, i10, i11);
            nVar.d(arrayList, nVar.f5305q, nVar.r, 1, i10, i11);
            int size = arrayList.size();
            long jMax = 0;
            for (int i12 = 0; i12 < size; i12++) {
                Animator animator = (Animator) arrayList.get(i12);
                jMax = Math.max(jMax, animator.getDuration() + animator.getStartDelay());
            }
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 0);
            valueAnimatorOfInt.setDuration(jMax);
            arrayList.add(0, valueAnimatorOfInt);
            animatorSet.playTogether(arrayList);
            a aVar = new a(i11, e(i10), i10, nVar.e(i11));
            nVar = this;
            animatorSet.addListener(aVar);
            animatorSet.start();
        } else if (i10 != i11) {
            if (i11 != 0 && (textViewE2 = nVar.e(i11)) != null) {
                textViewE2.setVisibility(0);
                textViewE2.setAlpha(1.0f);
            }
            if (i10 != 0 && (textViewE = e(i10)) != null) {
                textViewE.setVisibility(4);
                if (i10 == 1) {
                    textViewE.setText((CharSequence) null);
                }
            }
            nVar.f5302n = i11;
        }
        TextInputLayout textInputLayout = nVar.h;
        textInputLayout.t();
        textInputLayout.w(z, false);
        textInputLayout.z();
    }
}
