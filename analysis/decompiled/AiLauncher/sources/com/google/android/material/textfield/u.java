package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class u {

    /* renamed from: A, reason: collision with root package name */
    public ColorStateList f21644A;

    /* renamed from: B, reason: collision with root package name */
    public Typeface f21645B;

    /* renamed from: a, reason: collision with root package name */
    public final int f21646a;

    /* renamed from: b, reason: collision with root package name */
    public final int f21647b;

    /* renamed from: c, reason: collision with root package name */
    public final int f21648c;

    /* renamed from: d, reason: collision with root package name */
    public final TimeInterpolator f21649d;

    /* renamed from: e, reason: collision with root package name */
    public final TimeInterpolator f21650e;

    /* renamed from: f, reason: collision with root package name */
    public final TimeInterpolator f21651f;

    /* renamed from: g, reason: collision with root package name */
    public final Context f21652g;

    /* renamed from: h, reason: collision with root package name */
    public final TextInputLayout f21653h;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f21654i;

    /* renamed from: j, reason: collision with root package name */
    public int f21655j;

    /* renamed from: k, reason: collision with root package name */
    public FrameLayout f21656k;

    /* renamed from: l, reason: collision with root package name */
    public Animator f21657l;

    /* renamed from: m, reason: collision with root package name */
    public final float f21658m;

    /* renamed from: n, reason: collision with root package name */
    public int f21659n;

    /* renamed from: o, reason: collision with root package name */
    public int f21660o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f21661p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f21662q;

    /* renamed from: r, reason: collision with root package name */
    public TextView f21663r;

    /* renamed from: s, reason: collision with root package name */
    public CharSequence f21664s;

    /* renamed from: t, reason: collision with root package name */
    public int f21665t;

    /* renamed from: u, reason: collision with root package name */
    public int f21666u;

    /* renamed from: v, reason: collision with root package name */
    public ColorStateList f21667v;

    /* renamed from: w, reason: collision with root package name */
    public CharSequence f21668w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f21669x;

    /* renamed from: y, reason: collision with root package name */
    public TextView f21670y;

    /* renamed from: z, reason: collision with root package name */
    public int f21671z;

    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21672a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f21673b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f21674c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TextView f21675d;

        public a(int i10, TextView textView, int i11, TextView textView2) {
            this.f21672a = i10;
            this.f21673b = textView;
            this.f21674c = i11;
            this.f21675d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            u.this.f21659n = this.f21672a;
            u.this.f21657l = null;
            TextView textView = this.f21673b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f21674c == 1 && u.this.f21663r != null) {
                    u.this.f21663r.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f21675d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f21675d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f21675d;
            if (textView != null) {
                textView.setVisibility(0);
                this.f21675d.setAlpha(0.0f);
            }
        }
    }

    public class b extends View.AccessibilityDelegate {
        public b() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            EditText editText = u.this.f21653h.getEditText();
            if (editText != null) {
                accessibilityNodeInfo.setLabeledBy(editText);
            }
        }
    }

    public u(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f21652g = context;
        this.f21653h = textInputLayout;
        this.f21658m = context.getResources().getDimensionPixelSize(R$dimen.design_textinput_caption_translate_y);
        int i10 = R$attr.motionDurationShort4;
        this.f21646a = T2.h.f(context, i10, 217);
        this.f21647b = T2.h.f(context, R$attr.motionDurationMedium4, 167);
        this.f21648c = T2.h.f(context, i10, 167);
        int i11 = R$attr.motionEasingEmphasizedDecelerateInterpolator;
        this.f21649d = T2.h.g(context, i11, E2.a.f2342d);
        TimeInterpolator timeInterpolator = E2.a.f2339a;
        this.f21650e = T2.h.g(context, i11, timeInterpolator);
        this.f21651f = T2.h.g(context, R$attr.motionEasingLinearInterpolator, timeInterpolator);
    }

    public boolean A() {
        return this.f21662q;
    }

    public boolean B() {
        return this.f21669x;
    }

    public void C(TextView textView, int i10) {
        FrameLayout frameLayout;
        if (this.f21654i == null) {
            return;
        }
        if (!z(i10) || (frameLayout = this.f21656k) == null) {
            this.f21654i.removeView(textView);
        } else {
            frameLayout.removeView(textView);
        }
        int i11 = this.f21655j - 1;
        this.f21655j = i11;
        O(this.f21654i, i11);
    }

    public final void D(int i10, int i11) {
        TextView textViewM;
        TextView textViewM2;
        if (i10 == i11) {
            return;
        }
        if (i11 != 0 && (textViewM2 = m(i11)) != null) {
            textViewM2.setVisibility(0);
            textViewM2.setAlpha(1.0f);
        }
        if (i10 != 0 && (textViewM = m(i10)) != null) {
            textViewM.setVisibility(4);
            if (i10 == 1) {
                textViewM.setText((CharSequence) null);
            }
        }
        this.f21659n = i11;
    }

    public void E(int i10) {
        this.f21665t = i10;
        TextView textView = this.f21663r;
        if (textView != null) {
            textView.setAccessibilityLiveRegion(i10);
        }
    }

    public void F(CharSequence charSequence) {
        this.f21664s = charSequence;
        TextView textView = this.f21663r;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    public void G(boolean z10) {
        if (this.f21662q == z10) {
            return;
        }
        h();
        if (z10) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f21652g);
            this.f21663r = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_error);
            this.f21663r.setTextAlignment(5);
            Typeface typeface = this.f21645B;
            if (typeface != null) {
                this.f21663r.setTypeface(typeface);
            }
            H(this.f21666u);
            I(this.f21667v);
            F(this.f21664s);
            E(this.f21665t);
            this.f21663r.setVisibility(4);
            e(this.f21663r, 0);
        } else {
            w();
            C(this.f21663r, 0);
            this.f21663r = null;
            this.f21653h.q0();
            this.f21653h.C0();
        }
        this.f21662q = z10;
    }

    public void H(int i10) {
        this.f21666u = i10;
        TextView textView = this.f21663r;
        if (textView != null) {
            this.f21653h.c0(textView, i10);
        }
    }

    public void I(ColorStateList colorStateList) {
        this.f21667v = colorStateList;
        TextView textView = this.f21663r;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public void J(int i10) {
        this.f21671z = i10;
        TextView textView = this.f21670y;
        if (textView != null) {
            androidx.core.widget.i.m(textView, i10);
        }
    }

    public void K(boolean z10) {
        if (this.f21669x == z10) {
            return;
        }
        h();
        if (z10) {
            AppCompatTextView appCompatTextView = new AppCompatTextView(this.f21652g);
            this.f21670y = appCompatTextView;
            appCompatTextView.setId(R$id.textinput_helper_text);
            this.f21670y.setTextAlignment(5);
            Typeface typeface = this.f21645B;
            if (typeface != null) {
                this.f21670y.setTypeface(typeface);
            }
            this.f21670y.setVisibility(4);
            this.f21670y.setAccessibilityLiveRegion(1);
            J(this.f21671z);
            L(this.f21644A);
            e(this.f21670y, 1);
            this.f21670y.setAccessibilityDelegate(new b());
        } else {
            x();
            C(this.f21670y, 1);
            this.f21670y = null;
            this.f21653h.q0();
            this.f21653h.C0();
        }
        this.f21669x = z10;
    }

    public void L(ColorStateList colorStateList) {
        this.f21644A = colorStateList;
        TextView textView = this.f21670y;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    public final void M(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    public void N(Typeface typeface) {
        if (typeface != this.f21645B) {
            this.f21645B = typeface;
            M(this.f21663r, typeface);
            M(this.f21670y, typeface);
        }
    }

    public final void O(ViewGroup viewGroup, int i10) {
        if (i10 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    public final boolean P(TextView textView, CharSequence charSequence) {
        if (this.f21653h.isLaidOut() && this.f21653h.isEnabled()) {
            return (this.f21660o == this.f21659n && textView != null && TextUtils.equals(textView.getText(), charSequence)) ? false : true;
        }
        return false;
    }

    public void Q(CharSequence charSequence) {
        h();
        this.f21661p = charSequence;
        this.f21663r.setText(charSequence);
        int i10 = this.f21659n;
        if (i10 != 1) {
            this.f21660o = 1;
        }
        S(i10, this.f21660o, P(this.f21663r, charSequence));
    }

    public void R(CharSequence charSequence) {
        h();
        this.f21668w = charSequence;
        this.f21670y.setText(charSequence);
        int i10 = this.f21659n;
        if (i10 != 2) {
            this.f21660o = 2;
        }
        S(i10, this.f21660o, P(this.f21670y, charSequence));
    }

    public final void S(int i10, int i11, boolean z10) {
        u uVar;
        if (i10 == i11) {
            return;
        }
        if (z10) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f21657l = animatorSet;
            ArrayList arrayList = new ArrayList();
            uVar = this;
            uVar.i(arrayList, this.f21669x, this.f21670y, 2, i10, i11);
            uVar.i(arrayList, uVar.f21662q, uVar.f21663r, 1, i10, i11);
            E2.b.a(animatorSet, arrayList);
            animatorSet.addListener(uVar.new a(i11, uVar.m(i10), i10, uVar.m(i11)));
            animatorSet.start();
        } else {
            uVar = this;
            uVar.D(i10, i11);
        }
        uVar.f21653h.q0();
        uVar.f21653h.w0(z10);
        uVar.f21653h.C0();
    }

    public void e(TextView textView, int i10) {
        if (this.f21654i == null && this.f21656k == null) {
            LinearLayout linearLayout = new LinearLayout(this.f21652g);
            this.f21654i = linearLayout;
            linearLayout.setOrientation(0);
            this.f21653h.addView(this.f21654i, -1, -2);
            this.f21656k = new FrameLayout(this.f21652g);
            this.f21654i.addView(this.f21656k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f21653h.getEditText() != null) {
                f();
            }
        }
        if (z(i10)) {
            this.f21656k.setVisibility(0);
            this.f21656k.addView(textView);
        } else {
            this.f21654i.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f21654i.setVisibility(0);
        this.f21655j++;
    }

    public void f() {
        if (g()) {
            EditText editText = this.f21653h.getEditText();
            boolean zH = W2.c.h(this.f21652g);
            LinearLayout linearLayout = this.f21654i;
            int i10 = R$dimen.material_helper_text_font_1_3_padding_horizontal;
            linearLayout.setPaddingRelative(v(zH, i10, editText.getPaddingStart()), v(zH, R$dimen.material_helper_text_font_1_3_padding_top, this.f21652g.getResources().getDimensionPixelSize(R$dimen.material_helper_text_default_padding_top)), v(zH, i10, editText.getPaddingEnd()), 0);
        }
    }

    public final boolean g() {
        return (this.f21654i == null || this.f21653h.getEditText() == null) ? false : true;
    }

    public void h() {
        Animator animator = this.f21657l;
        if (animator != null) {
            animator.cancel();
        }
    }

    public final void i(List<Animator> list, boolean z10, TextView textView, int i10, int i11, int i12) {
        if (textView == null || !z10) {
            return;
        }
        if (i10 == i12 || i10 == i11) {
            ObjectAnimator objectAnimatorJ = j(textView, i12 == i10);
            if (i10 == i12 && i11 != 0) {
                objectAnimatorJ.setStartDelay(this.f21648c);
            }
            list.add(objectAnimatorJ);
            if (i12 != i10 || i11 == 0) {
                return;
            }
            ObjectAnimator objectAnimatorK = k(textView);
            objectAnimatorK.setStartDelay(this.f21648c);
            list.add(objectAnimatorK);
        }
    }

    public final ObjectAnimator j(TextView textView, boolean z10) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z10 ? 1.0f : 0.0f);
        objectAnimatorOfFloat.setDuration(z10 ? this.f21647b : this.f21648c);
        objectAnimatorOfFloat.setInterpolator(z10 ? this.f21650e : this.f21651f);
        return objectAnimatorOfFloat;
    }

    public final ObjectAnimator k(TextView textView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f21658m, 0.0f);
        objectAnimatorOfFloat.setDuration(this.f21646a);
        objectAnimatorOfFloat.setInterpolator(this.f21649d);
        return objectAnimatorOfFloat;
    }

    public boolean l() {
        return y(this.f21660o);
    }

    public final TextView m(int i10) {
        if (i10 == 1) {
            return this.f21663r;
        }
        if (i10 != 2) {
            return null;
        }
        return this.f21670y;
    }

    public int n() {
        return this.f21665t;
    }

    public CharSequence o() {
        return this.f21664s;
    }

    public CharSequence p() {
        return this.f21661p;
    }

    public int q() {
        TextView textView = this.f21663r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public ColorStateList r() {
        TextView textView = this.f21663r;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    public CharSequence s() {
        return this.f21668w;
    }

    public View t() {
        return this.f21670y;
    }

    public int u() {
        TextView textView = this.f21670y;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    public final int v(boolean z10, int i10, int i11) {
        return z10 ? this.f21652g.getResources().getDimensionPixelSize(i10) : i11;
    }

    public void w() {
        this.f21661p = null;
        h();
        if (this.f21659n == 1) {
            if (!this.f21669x || TextUtils.isEmpty(this.f21668w)) {
                this.f21660o = 0;
            } else {
                this.f21660o = 2;
            }
        }
        S(this.f21659n, this.f21660o, P(this.f21663r, ""));
    }

    public void x() {
        h();
        int i10 = this.f21659n;
        if (i10 == 2) {
            this.f21660o = 0;
        }
        S(i10, this.f21660o, P(this.f21670y, ""));
    }

    public final boolean y(int i10) {
        return (i10 != 1 || this.f21663r == null || TextUtils.isEmpty(this.f21661p)) ? false : true;
    }

    public boolean z(int i10) {
        return i10 == 0 || i10 == 1;
    }
}
