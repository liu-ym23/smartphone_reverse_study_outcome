package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
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
import androidx.appcompat.widget.C0200f0;
import com.stepos.alphame.R;
import java.util.ArrayList;
import n1.AbstractC0775a;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: A, reason: collision with root package name */
    public ColorStateList f11067A;

    /* renamed from: B, reason: collision with root package name */
    public Typeface f11068B;

    /* renamed from: a, reason: collision with root package name */
    public final int f11069a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11070b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11071c;

    /* renamed from: d, reason: collision with root package name */
    public final TimeInterpolator f11072d;

    /* renamed from: e, reason: collision with root package name */
    public final TimeInterpolator f11073e;

    /* renamed from: f, reason: collision with root package name */
    public final TimeInterpolator f11074f;

    /* renamed from: g, reason: collision with root package name */
    public final Context f11075g;

    /* renamed from: h, reason: collision with root package name */
    public final TextInputLayout f11076h;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f11077i;

    /* renamed from: j, reason: collision with root package name */
    public int f11078j;

    /* renamed from: k, reason: collision with root package name */
    public FrameLayout f11079k;

    /* renamed from: l, reason: collision with root package name */
    public Animator f11080l;

    /* renamed from: m, reason: collision with root package name */
    public final float f11081m;

    /* renamed from: n, reason: collision with root package name */
    public int f11082n;

    /* renamed from: o, reason: collision with root package name */
    public int f11083o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f11084p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f11085q;

    /* renamed from: r, reason: collision with root package name */
    public C0200f0 f11086r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f11087s;

    /* renamed from: t, reason: collision with root package name */
    public int f11088t;

    /* renamed from: u, reason: collision with root package name */
    public int f11089u;

    /* renamed from: v, reason: collision with root package name */
    public ColorStateList f11090v;

    /* renamed from: w, reason: collision with root package name */
    public CharSequence f11091w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f11092x;

    /* renamed from: y, reason: collision with root package name */
    public C0200f0 f11093y;

    /* renamed from: z, reason: collision with root package name */
    public int f11094z;

    public r(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f11075g = context;
        this.f11076h = textInputLayout;
        this.f11081m = context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
        this.f11069a = com.stepos.statsrpk.c.L(context, R.attr.motionDurationShort4, 217);
        this.f11070b = com.stepos.statsrpk.c.L(context, R.attr.motionDurationMedium4, 167);
        this.f11071c = com.stepos.statsrpk.c.L(context, R.attr.motionDurationShort4, 167);
        this.f11072d = com.stepos.statsrpk.c.M(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, AbstractC0775a.f13653d);
        LinearInterpolator linearInterpolator = AbstractC0775a.f13650a;
        this.f11073e = com.stepos.statsrpk.c.M(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, linearInterpolator);
        this.f11074f = com.stepos.statsrpk.c.M(context, R.attr.motionEasingLinearInterpolator, linearInterpolator);
    }

    public final void a(TextView textView, int i4) {
        if (this.f11077i == null && this.f11079k == null) {
            Context context = this.f11075g;
            LinearLayout linearLayout = new LinearLayout(context);
            this.f11077i = linearLayout;
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.f11077i;
            TextInputLayout textInputLayout = this.f11076h;
            textInputLayout.addView(linearLayout2, -1, -2);
            this.f11079k = new FrameLayout(context);
            this.f11077i.addView(this.f11079k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (textInputLayout.getEditText() != null) {
                b();
            }
        }
        if (i4 == 0 || i4 == 1) {
            this.f11079k.setVisibility(0);
            this.f11079k.addView(textView);
        } else {
            this.f11077i.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f11077i.setVisibility(0);
        this.f11078j++;
    }

    public final void b() {
        if (this.f11077i != null) {
            TextInputLayout textInputLayout = this.f11076h;
            if (textInputLayout.getEditText() != null) {
                EditText editText = textInputLayout.getEditText();
                Context context = this.f11075g;
                boolean zQ = B0.f.Q(context);
                LinearLayout linearLayout = this.f11077i;
                int paddingStart = editText.getPaddingStart();
                if (zQ) {
                    paddingStart = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top);
                if (zQ) {
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_top);
                }
                int paddingEnd = editText.getPaddingEnd();
                if (zQ) {
                    paddingEnd = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                linearLayout.setPaddingRelative(paddingStart, dimensionPixelSize, paddingEnd, 0);
            }
        }
    }

    public final void c() {
        Animator animator = this.f11080l;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void d(ArrayList arrayList, boolean z4, TextView textView, int i4, int i5, int i6) {
        if (textView == null || !z4) {
            return;
        }
        if (i4 == i6 || i4 == i5) {
            boolean z5 = i6 == i4;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z5 ? 1.0f : 0.0f);
            int i7 = this.f11071c;
            objectAnimatorOfFloat.setDuration(z5 ? this.f11070b : i7);
            objectAnimatorOfFloat.setInterpolator(z5 ? this.f11073e : this.f11074f);
            if (i4 == i6 && i5 != 0) {
                objectAnimatorOfFloat.setStartDelay(i7);
            }
            arrayList.add(objectAnimatorOfFloat);
            if (i6 != i4 || i5 == 0) {
                return;
            }
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f11081m, com.stepos.alphame.utils.Property.DEFAULT_FLOAT_VALUE);
            objectAnimatorOfFloat2.setDuration(this.f11069a);
            objectAnimatorOfFloat2.setInterpolator(this.f11072d);
            objectAnimatorOfFloat2.setStartDelay(i7);
            arrayList.add(objectAnimatorOfFloat2);
        }
    }

    public final TextView e(int i4) {
        if (i4 == 1) {
            return this.f11086r;
        }
        if (i4 != 2) {
            return null;
        }
        return this.f11093y;
    }

    public final void f() {
        this.f11084p = null;
        c();
        if (this.f11082n == 1) {
            if (!this.f11092x || TextUtils.isEmpty(this.f11091w)) {
                this.f11083o = 0;
            } else {
                this.f11083o = 2;
            }
        }
        i(this.f11082n, this.f11083o, h(this.f11086r, ""));
    }

    public final void g(TextView textView, int i4) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.f11077i;
        if (linearLayout == null) {
            return;
        }
        if ((i4 == 0 || i4 == 1) && (frameLayout = this.f11079k) != null) {
            frameLayout.removeView(textView);
        } else {
            linearLayout.removeView(textView);
        }
        int i5 = this.f11078j - 1;
        this.f11078j = i5;
        LinearLayout linearLayout2 = this.f11077i;
        if (i5 == 0) {
            linearLayout2.setVisibility(8);
        }
    }

    public final boolean h(TextView textView, CharSequence charSequence) {
        TextInputLayout textInputLayout = this.f11076h;
        return textInputLayout.isLaidOut() && textInputLayout.isEnabled() && !(this.f11083o == this.f11082n && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    public final void i(int i4, int i5, boolean z4) {
        TextView textViewE;
        TextView textViewE2;
        if (i4 == i5) {
            return;
        }
        if (z4) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f11080l = animatorSet;
            ArrayList arrayList = new ArrayList();
            d(arrayList, this.f11092x, this.f11093y, 2, i4, i5);
            d(arrayList, this.f11085q, this.f11086r, 1, i4, i5);
            B0.f.f0(animatorSet, arrayList);
            animatorSet.addListener(new p(this, i5, e(i4), i4, e(i5)));
            animatorSet.start();
        } else if (i4 != i5) {
            if (i5 != 0 && (textViewE2 = e(i5)) != null) {
                textViewE2.setVisibility(0);
                textViewE2.setAlpha(1.0f);
            }
            if (i4 != 0 && (textViewE = e(i4)) != null) {
                textViewE.setVisibility(4);
                if (i4 == 1) {
                    textViewE.setText((CharSequence) null);
                }
            }
            this.f11082n = i5;
        }
        TextInputLayout textInputLayout = this.f11076h;
        textInputLayout.t();
        textInputLayout.w(z4, false);
        textInputLayout.z();
    }
}
