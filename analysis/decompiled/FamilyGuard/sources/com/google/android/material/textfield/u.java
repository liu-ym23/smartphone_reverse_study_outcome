package com.google.android.material.textfield;

import a1.C0409b;
import a1.C0411d;
import a1.C0413f;
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
import androidx.appcompat.widget.D;
import b1.C0553a;
import b1.C0554b;
import java.util.ArrayList;
import java.util.List;
import org.libpag.BuildConfig;
import q1.C0981c;

/* loaded from: classes.dex */
final class u {

    /* renamed from: A, reason: collision with root package name */
    private ColorStateList f13377A;

    /* renamed from: B, reason: collision with root package name */
    private Typeface f13378B;

    /* renamed from: a, reason: collision with root package name */
    private final int f13379a;

    /* renamed from: b, reason: collision with root package name */
    private final int f13380b;

    /* renamed from: c, reason: collision with root package name */
    private final int f13381c;

    /* renamed from: d, reason: collision with root package name */
    private final TimeInterpolator f13382d;

    /* renamed from: e, reason: collision with root package name */
    private final TimeInterpolator f13383e;

    /* renamed from: f, reason: collision with root package name */
    private final TimeInterpolator f13384f;

    /* renamed from: g, reason: collision with root package name */
    private final Context f13385g;

    /* renamed from: h, reason: collision with root package name */
    private final TextInputLayout f13386h;

    /* renamed from: i, reason: collision with root package name */
    private LinearLayout f13387i;

    /* renamed from: j, reason: collision with root package name */
    private int f13388j;

    /* renamed from: k, reason: collision with root package name */
    private FrameLayout f13389k;

    /* renamed from: l, reason: collision with root package name */
    private Animator f13390l;

    /* renamed from: m, reason: collision with root package name */
    private final float f13391m;

    /* renamed from: n, reason: collision with root package name */
    private int f13392n;

    /* renamed from: o, reason: collision with root package name */
    private int f13393o;

    /* renamed from: p, reason: collision with root package name */
    private CharSequence f13394p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f13395q;

    /* renamed from: r, reason: collision with root package name */
    private TextView f13396r;

    /* renamed from: s, reason: collision with root package name */
    private CharSequence f13397s;

    /* renamed from: t, reason: collision with root package name */
    private int f13398t;

    /* renamed from: u, reason: collision with root package name */
    private int f13399u;

    /* renamed from: v, reason: collision with root package name */
    private ColorStateList f13400v;

    /* renamed from: w, reason: collision with root package name */
    private CharSequence f13401w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f13402x;

    /* renamed from: y, reason: collision with root package name */
    private TextView f13403y;

    /* renamed from: z, reason: collision with root package name */
    private int f13404z;

    class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f13405a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ TextView f13406b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f13407c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TextView f13408d;

        a(int i5, TextView textView, int i6, TextView textView2) {
            this.f13405a = i5;
            this.f13406b = textView;
            this.f13407c = i6;
            this.f13408d = textView2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            u.this.f13392n = this.f13405a;
            u.this.f13390l = null;
            TextView textView = this.f13406b;
            if (textView != null) {
                textView.setVisibility(4);
                if (this.f13407c == 1 && u.this.f13396r != null) {
                    u.this.f13396r.setText((CharSequence) null);
                }
            }
            TextView textView2 = this.f13408d;
            if (textView2 != null) {
                textView2.setTranslationY(0.0f);
                this.f13408d.setAlpha(1.0f);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            TextView textView = this.f13408d;
            if (textView != null) {
                textView.setVisibility(0);
                this.f13408d.setAlpha(0.0f);
            }
        }
    }

    class b extends View.AccessibilityDelegate {
        b() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            EditText editText = u.this.f13386h.getEditText();
            if (editText != null) {
                accessibilityNodeInfo.setLabeledBy(editText);
            }
        }
    }

    public u(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.f13385g = context;
        this.f13386h = textInputLayout;
        this.f13391m = context.getResources().getDimensionPixelSize(C0411d.f6786h);
        int i5 = C0409b.f6693C;
        this.f13379a = o1.e.f(context, i5, 217);
        this.f13380b = o1.e.f(context, C0409b.f6739z, 167);
        this.f13381c = o1.e.f(context, i5, 167);
        int i6 = C0409b.f6695E;
        this.f13382d = o1.e.g(context, i6, C0553a.f11786d);
        TimeInterpolator timeInterpolator = C0553a.f11783a;
        this.f13383e = o1.e.g(context, i6, timeInterpolator);
        this.f13384f = o1.e.g(context, C0409b.f6697G, timeInterpolator);
    }

    private void D(int i5, int i6) {
        TextView textViewM;
        TextView textViewM2;
        if (i5 == i6) {
            return;
        }
        if (i6 != 0 && (textViewM2 = m(i6)) != null) {
            textViewM2.setVisibility(0);
            textViewM2.setAlpha(1.0f);
        }
        if (i5 != 0 && (textViewM = m(i5)) != null) {
            textViewM.setVisibility(4);
            if (i5 == 1) {
                textViewM.setText((CharSequence) null);
            }
        }
        this.f13392n = i6;
    }

    private void M(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void O(ViewGroup viewGroup, int i5) {
        if (i5 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    private boolean P(TextView textView, CharSequence charSequence) {
        if (this.f13386h.isLaidOut() && this.f13386h.isEnabled()) {
            return (this.f13393o == this.f13392n && textView != null && TextUtils.equals(textView.getText(), charSequence)) ? false : true;
        }
        return false;
    }

    private void S(int i5, int i6, boolean z5) {
        u uVar;
        if (i5 == i6) {
            return;
        }
        if (z5) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f13390l = animatorSet;
            ArrayList arrayList = new ArrayList();
            uVar = this;
            uVar.i(arrayList, this.f13402x, this.f13403y, 2, i5, i6);
            uVar.i(arrayList, uVar.f13395q, uVar.f13396r, 1, i5, i6);
            C0554b.a(animatorSet, arrayList);
            animatorSet.addListener(uVar.new a(i6, uVar.m(i5), i5, uVar.m(i6)));
            animatorSet.start();
        } else {
            uVar = this;
            uVar.D(i5, i6);
        }
        uVar.f13386h.q0();
        uVar.f13386h.w0(z5);
        uVar.f13386h.C0();
    }

    private boolean g() {
        return (this.f13387i == null || this.f13386h.getEditText() == null) ? false : true;
    }

    private void i(List<Animator> list, boolean z5, TextView textView, int i5, int i6, int i7) {
        if (textView == null || !z5) {
            return;
        }
        if (i5 == i7 || i5 == i6) {
            ObjectAnimator objectAnimatorJ = j(textView, i7 == i5);
            if (i5 == i7 && i6 != 0) {
                objectAnimatorJ.setStartDelay(this.f13381c);
            }
            list.add(objectAnimatorJ);
            if (i7 != i5 || i6 == 0) {
                return;
            }
            ObjectAnimator objectAnimatorK = k(textView);
            objectAnimatorK.setStartDelay(this.f13381c);
            list.add(objectAnimatorK);
        }
    }

    private ObjectAnimator j(TextView textView, boolean z5) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z5 ? 1.0f : 0.0f);
        objectAnimatorOfFloat.setDuration(z5 ? this.f13380b : this.f13381c);
        objectAnimatorOfFloat.setInterpolator(z5 ? this.f13383e : this.f13384f);
        return objectAnimatorOfFloat;
    }

    private ObjectAnimator k(TextView textView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f13391m, 0.0f);
        objectAnimatorOfFloat.setDuration(this.f13379a);
        objectAnimatorOfFloat.setInterpolator(this.f13382d);
        return objectAnimatorOfFloat;
    }

    private TextView m(int i5) {
        if (i5 == 1) {
            return this.f13396r;
        }
        if (i5 != 2) {
            return null;
        }
        return this.f13403y;
    }

    private int v(boolean z5, int i5, int i6) {
        return z5 ? this.f13385g.getResources().getDimensionPixelSize(i5) : i6;
    }

    private boolean y(int i5) {
        return (i5 != 1 || this.f13396r == null || TextUtils.isEmpty(this.f13394p)) ? false : true;
    }

    boolean A() {
        return this.f13395q;
    }

    boolean B() {
        return this.f13402x;
    }

    void C(TextView textView, int i5) {
        FrameLayout frameLayout;
        if (this.f13387i == null) {
            return;
        }
        if (!z(i5) || (frameLayout = this.f13389k) == null) {
            this.f13387i.removeView(textView);
        } else {
            frameLayout.removeView(textView);
        }
        int i6 = this.f13388j - 1;
        this.f13388j = i6;
        O(this.f13387i, i6);
    }

    void E(int i5) {
        this.f13398t = i5;
        TextView textView = this.f13396r;
        if (textView != null) {
            textView.setAccessibilityLiveRegion(i5);
        }
    }

    void F(CharSequence charSequence) {
        this.f13397s = charSequence;
        TextView textView = this.f13396r;
        if (textView != null) {
            textView.setContentDescription(charSequence);
        }
    }

    void G(boolean z5) {
        if (this.f13395q == z5) {
            return;
        }
        h();
        if (z5) {
            D d6 = new D(this.f13385g);
            this.f13396r = d6;
            d6.setId(C0413f.f6831N);
            this.f13396r.setTextAlignment(5);
            Typeface typeface = this.f13378B;
            if (typeface != null) {
                this.f13396r.setTypeface(typeface);
            }
            H(this.f13399u);
            I(this.f13400v);
            F(this.f13397s);
            E(this.f13398t);
            this.f13396r.setVisibility(4);
            e(this.f13396r, 0);
        } else {
            w();
            C(this.f13396r, 0);
            this.f13396r = null;
            this.f13386h.q0();
            this.f13386h.C0();
        }
        this.f13395q = z5;
    }

    void H(int i5) {
        this.f13399u = i5;
        TextView textView = this.f13396r;
        if (textView != null) {
            this.f13386h.c0(textView, i5);
        }
    }

    void I(ColorStateList colorStateList) {
        this.f13400v = colorStateList;
        TextView textView = this.f13396r;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    void J(int i5) {
        this.f13404z = i5;
        TextView textView = this.f13403y;
        if (textView != null) {
            androidx.core.widget.i.m(textView, i5);
        }
    }

    void K(boolean z5) {
        if (this.f13402x == z5) {
            return;
        }
        h();
        if (z5) {
            D d6 = new D(this.f13385g);
            this.f13403y = d6;
            d6.setId(C0413f.f6832O);
            this.f13403y.setTextAlignment(5);
            Typeface typeface = this.f13378B;
            if (typeface != null) {
                this.f13403y.setTypeface(typeface);
            }
            this.f13403y.setVisibility(4);
            this.f13403y.setAccessibilityLiveRegion(1);
            J(this.f13404z);
            L(this.f13377A);
            e(this.f13403y, 1);
            this.f13403y.setAccessibilityDelegate(new b());
        } else {
            x();
            C(this.f13403y, 1);
            this.f13403y = null;
            this.f13386h.q0();
            this.f13386h.C0();
        }
        this.f13402x = z5;
    }

    void L(ColorStateList colorStateList) {
        this.f13377A = colorStateList;
        TextView textView = this.f13403y;
        if (textView == null || colorStateList == null) {
            return;
        }
        textView.setTextColor(colorStateList);
    }

    void N(Typeface typeface) {
        if (typeface != this.f13378B) {
            this.f13378B = typeface;
            M(this.f13396r, typeface);
            M(this.f13403y, typeface);
        }
    }

    void Q(CharSequence charSequence) {
        h();
        this.f13394p = charSequence;
        this.f13396r.setText(charSequence);
        int i5 = this.f13392n;
        if (i5 != 1) {
            this.f13393o = 1;
        }
        S(i5, this.f13393o, P(this.f13396r, charSequence));
    }

    void R(CharSequence charSequence) {
        h();
        this.f13401w = charSequence;
        this.f13403y.setText(charSequence);
        int i5 = this.f13392n;
        if (i5 != 2) {
            this.f13393o = 2;
        }
        S(i5, this.f13393o, P(this.f13403y, charSequence));
    }

    void e(TextView textView, int i5) {
        if (this.f13387i == null && this.f13389k == null) {
            LinearLayout linearLayout = new LinearLayout(this.f13385g);
            this.f13387i = linearLayout;
            linearLayout.setOrientation(0);
            this.f13386h.addView(this.f13387i, -1, -2);
            this.f13389k = new FrameLayout(this.f13385g);
            this.f13387i.addView(this.f13389k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (this.f13386h.getEditText() != null) {
                f();
            }
        }
        if (z(i5)) {
            this.f13389k.setVisibility(0);
            this.f13389k.addView(textView);
        } else {
            this.f13387i.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f13387i.setVisibility(0);
        this.f13388j++;
    }

    void f() {
        if (g()) {
            EditText editText = this.f13386h.getEditText();
            boolean zG = C0981c.g(this.f13385g);
            LinearLayout linearLayout = this.f13387i;
            int i5 = C0411d.f6755J;
            linearLayout.setPaddingRelative(v(zG, i5, editText.getPaddingStart()), v(zG, C0411d.f6756K, this.f13385g.getResources().getDimensionPixelSize(C0411d.f6754I)), v(zG, i5, editText.getPaddingEnd()), 0);
        }
    }

    void h() {
        Animator animator = this.f13390l;
        if (animator != null) {
            animator.cancel();
        }
    }

    boolean l() {
        return y(this.f13393o);
    }

    int n() {
        return this.f13398t;
    }

    CharSequence o() {
        return this.f13397s;
    }

    CharSequence p() {
        return this.f13394p;
    }

    int q() {
        TextView textView = this.f13396r;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    ColorStateList r() {
        TextView textView = this.f13396r;
        if (textView != null) {
            return textView.getTextColors();
        }
        return null;
    }

    CharSequence s() {
        return this.f13401w;
    }

    View t() {
        return this.f13403y;
    }

    int u() {
        TextView textView = this.f13403y;
        if (textView != null) {
            return textView.getCurrentTextColor();
        }
        return -1;
    }

    void w() {
        this.f13394p = null;
        h();
        if (this.f13392n == 1) {
            if (!this.f13402x || TextUtils.isEmpty(this.f13401w)) {
                this.f13393o = 0;
            } else {
                this.f13393o = 2;
            }
        }
        S(this.f13392n, this.f13393o, P(this.f13396r, BuildConfig.FLAVOR));
    }

    void x() {
        h();
        int i5 = this.f13392n;
        if (i5 == 2) {
            this.f13393o = 0;
        }
        S(i5, this.f13393o, P(this.f13403y, BuildConfig.FLAVOR));
    }

    boolean z(int i5) {
        return i5 == 0 || i5 == 1;
    }
}
