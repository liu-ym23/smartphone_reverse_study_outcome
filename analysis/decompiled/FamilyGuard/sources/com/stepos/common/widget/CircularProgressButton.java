package com.stepos.common.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.StateSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.TextView;
import com.stepos.common.drawble.CircularAnimatedDrawable;
import com.stepos.common.drawble.CircularProgressDrawable;
import com.stepos.common.drawble.StrokeGradientDrawable;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class CircularProgressButton extends Button {

    /* renamed from: i0, reason: collision with root package name */
    private static int f13774i0 = 800;

    /* renamed from: A, reason: collision with root package name */
    private Drawable f13775A;

    /* renamed from: B, reason: collision with root package name */
    private boolean f13776B;

    /* renamed from: C, reason: collision with root package name */
    private boolean f13777C;

    /* renamed from: D, reason: collision with root package name */
    private i f13778D;

    /* renamed from: E, reason: collision with root package name */
    private ColorStateList f13779E;

    /* renamed from: F, reason: collision with root package name */
    private ColorStateList f13780F;

    /* renamed from: G, reason: collision with root package name */
    private ColorStateList f13781G;

    /* renamed from: H, reason: collision with root package name */
    private ColorStateList f13782H;

    /* renamed from: I, reason: collision with root package name */
    private ColorStateList f13783I;

    /* renamed from: J, reason: collision with root package name */
    private ColorStateList f13784J;

    /* renamed from: K, reason: collision with root package name */
    private boolean f13785K;

    /* renamed from: L, reason: collision with root package name */
    private boolean f13786L;

    /* renamed from: M, reason: collision with root package name */
    private boolean f13787M;

    /* renamed from: Q, reason: collision with root package name */
    private int f13788Q;

    /* renamed from: R, reason: collision with root package name */
    private int f13789R;

    /* renamed from: S, reason: collision with root package name */
    private boolean f13790S;

    /* renamed from: T, reason: collision with root package name */
    private boolean f13791T;

    /* renamed from: U, reason: collision with root package name */
    private int f13792U;

    /* renamed from: V, reason: collision with root package name */
    private int f13793V;

    /* renamed from: W, reason: collision with root package name */
    private int f13794W;

    /* renamed from: a, reason: collision with root package name */
    private StrokeGradientDrawable f13795a;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f13796a0;

    /* renamed from: b, reason: collision with root package name */
    private CircularAnimatedDrawable f13797b;

    /* renamed from: b0, reason: collision with root package name */
    private ValueAnimator f13798b0;

    /* renamed from: c, reason: collision with root package name */
    private CircularProgressDrawable f13799c;

    /* renamed from: c0, reason: collision with root package name */
    private int f13800c0;

    /* renamed from: d, reason: collision with root package name */
    private ColorStateList f13801d;

    /* renamed from: d0, reason: collision with root package name */
    private boolean f13802d0;

    /* renamed from: e, reason: collision with root package name */
    private ColorStateList f13803e;

    /* renamed from: e0, reason: collision with root package name */
    private j f13804e0;

    /* renamed from: f, reason: collision with root package name */
    private ColorStateList f13805f;

    /* renamed from: f0, reason: collision with root package name */
    private j f13806f0;

    /* renamed from: g, reason: collision with root package name */
    private StateListDrawable f13807g;

    /* renamed from: g0, reason: collision with root package name */
    private j f13808g0;

    /* renamed from: h, reason: collision with root package name */
    private StateListDrawable f13809h;

    /* renamed from: h0, reason: collision with root package name */
    private j f13810h0;

    /* renamed from: i, reason: collision with root package name */
    private StateListDrawable f13811i;

    /* renamed from: j, reason: collision with root package name */
    private StateListDrawable f13812j;

    /* renamed from: k, reason: collision with root package name */
    private StateListDrawable f13813k;

    /* renamed from: l, reason: collision with root package name */
    private l f13814l;

    /* renamed from: m, reason: collision with root package name */
    private String f13815m;

    /* renamed from: n, reason: collision with root package name */
    private String f13816n;

    /* renamed from: o, reason: collision with root package name */
    private String f13817o;

    /* renamed from: p, reason: collision with root package name */
    private String f13818p;

    /* renamed from: q, reason: collision with root package name */
    private int f13819q;

    /* renamed from: r, reason: collision with root package name */
    private int f13820r;

    /* renamed from: s, reason: collision with root package name */
    private int f13821s;

    /* renamed from: t, reason: collision with root package name */
    private int f13822t;

    /* renamed from: u, reason: collision with root package name */
    private int f13823u;

    /* renamed from: v, reason: collision with root package name */
    private int f13824v;

    /* renamed from: w, reason: collision with root package name */
    private int f13825w;

    /* renamed from: x, reason: collision with root package name */
    private float f13826x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f13827y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f13828z;

    class a implements j {
        a() {
        }

        @Override // com.stepos.common.widget.CircularProgressButton.j
        public void a() {
            CircularProgressButton.this.f13796a0 = false;
            CircularProgressButton.this.setClickable(true);
            CircularProgressButton.this.setText((CharSequence) null);
            CircularProgressButton.this.requestLayout();
        }
    }

    class b implements j {
        b() {
        }

        @Override // com.stepos.common.widget.CircularProgressButton.j
        public void a() throws Resources.NotFoundException {
            if (CircularProgressButton.this.f13822t != 0) {
                CircularProgressButton.this.setText((CharSequence) null);
                CircularProgressButton circularProgressButton = CircularProgressButton.this;
                circularProgressButton.setIcon(circularProgressButton.f13822t);
            } else {
                CircularProgressButton circularProgressButton2 = CircularProgressButton.this;
                circularProgressButton2.setText(circularProgressButton2.f13816n);
            }
            CircularProgressButton.this.a0();
            CircularProgressButton.this.f13796a0 = false;
            CircularProgressButton.this.setClickable(true);
            CircularProgressButton circularProgressButton3 = CircularProgressButton.this;
            circularProgressButton3.setTextColor(circularProgressButton3.f13780F);
        }
    }

    class c implements j {
        c() {
        }

        @Override // com.stepos.common.widget.CircularProgressButton.j
        public void a() {
            CircularProgressButton.this.W();
            CircularProgressButton circularProgressButton = CircularProgressButton.this;
            circularProgressButton.setText(circularProgressButton.f13815m);
            CircularProgressButton.this.a0();
            CircularProgressButton.this.f13796a0 = false;
            CircularProgressButton.this.setClickable(true);
            CircularProgressButton circularProgressButton2 = CircularProgressButton.this;
            circularProgressButton2.setTextColor(circularProgressButton2.f13779E);
        }
    }

    class d implements j {
        d() {
        }

        @Override // com.stepos.common.widget.CircularProgressButton.j
        public void a() throws Resources.NotFoundException {
            if (CircularProgressButton.this.f13823u != 0) {
                CircularProgressButton.this.setText((CharSequence) null);
                CircularProgressButton circularProgressButton = CircularProgressButton.this;
                circularProgressButton.setIcon(circularProgressButton.f13823u);
            } else {
                CircularProgressButton circularProgressButton2 = CircularProgressButton.this;
                circularProgressButton2.setWidth(circularProgressButton2.F(circularProgressButton2.getPaint(), CircularProgressButton.this.f13817o) + CircularProgressButton.this.getCompoundPaddingRight() + CircularProgressButton.this.getCompoundPaddingLeft());
                CircularProgressButton circularProgressButton3 = CircularProgressButton.this;
                circularProgressButton3.setText(circularProgressButton3.f13817o);
                CircularProgressButton.this.f13790S = false;
                CircularProgressButton.this.f13791T = true;
            }
        }
    }

    class e implements j {
        e() {
        }

        @Override // com.stepos.common.widget.CircularProgressButton.j
        public void a() throws Resources.NotFoundException {
            if (CircularProgressButton.this.f13823u != 0) {
                CircularProgressButton.this.setText((CharSequence) null);
                CircularProgressButton circularProgressButton = CircularProgressButton.this;
                circularProgressButton.setIcon(circularProgressButton.f13823u);
            } else {
                CircularProgressButton circularProgressButton2 = CircularProgressButton.this;
                circularProgressButton2.setText(circularProgressButton2.f13817o);
            }
            CircularProgressButton.this.f13796a0 = false;
            CircularProgressButton.this.setClickable(true);
            CircularProgressButton circularProgressButton3 = CircularProgressButton.this;
            circularProgressButton3.setTextColor(circularProgressButton3.f13781G);
        }
    }

    class f implements j {
        f() {
        }

        @Override // com.stepos.common.widget.CircularProgressButton.j
        public void a() {
            CircularProgressButton.this.W();
            CircularProgressButton circularProgressButton = CircularProgressButton.this;
            circularProgressButton.setText(circularProgressButton.f13815m);
            CircularProgressButton.this.a0();
            CircularProgressButton.this.f13796a0 = false;
            CircularProgressButton.this.setClickable(true);
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CircularProgressButton.this.invalidate();
        }
    }

    class h implements ValueAnimator.AnimatorUpdateListener {
        h() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CircularProgressButton.this.f13800c0 = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            CircularProgressButton.this.invalidate();
        }
    }

    class i {

        /* renamed from: a, reason: collision with root package name */
        private j f13837a;

        /* renamed from: b, reason: collision with root package name */
        private int f13838b;

        /* renamed from: c, reason: collision with root package name */
        private int f13839c;

        /* renamed from: d, reason: collision with root package name */
        private int f13840d;

        /* renamed from: e, reason: collision with root package name */
        private int f13841e;

        /* renamed from: f, reason: collision with root package name */
        private int f13842f;

        /* renamed from: g, reason: collision with root package name */
        private int f13843g;

        /* renamed from: h, reason: collision with root package name */
        private int f13844h;

        /* renamed from: i, reason: collision with root package name */
        private float f13845i;

        /* renamed from: j, reason: collision with root package name */
        private float f13846j;

        /* renamed from: k, reason: collision with root package name */
        private int f13847k;

        /* renamed from: l, reason: collision with root package name */
        private int f13848l;

        /* renamed from: m, reason: collision with root package name */
        private float f13849m;

        /* renamed from: n, reason: collision with root package name */
        private TextView f13850n;

        /* renamed from: o, reason: collision with root package name */
        private StrokeGradientDrawable f13851o;

        /* renamed from: p, reason: collision with root package name */
        private AnimatorSet f13852p;

        class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ GradientDrawable f13854a;

            a(GradientDrawable gradientDrawable) {
                this.f13854a = gradientDrawable;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int iIntValue;
                int i5;
                float animatedFraction;
                Integer num = (Integer) valueAnimator.getAnimatedValue();
                if (i.this.f13839c > i.this.f13840d) {
                    iIntValue = (i.this.f13839c - num.intValue()) / 2;
                    i5 = i.this.f13839c - iIntValue;
                    animatedFraction = i.this.f13849m * valueAnimator.getAnimatedFraction();
                } else {
                    iIntValue = (i.this.f13840d - num.intValue()) / 2;
                    i5 = i.this.f13840d - iIntValue;
                    animatedFraction = i.this.f13849m - (i.this.f13849m * valueAnimator.getAnimatedFraction());
                }
                int i6 = (int) animatedFraction;
                this.f13854a.setBounds(iIntValue + i6, i6, (i5 - i6) - 1, (i.this.f13850n.getHeight() - i6) - 1);
                CircularProgressButton.this.invalidate();
            }
        }

        class b implements Animator.AnimatorListener {
            b() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (i.this.f13837a != null) {
                    i.this.f13837a.a();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        class c implements Animator.AnimatorListener {
            c() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (i.this.f13837a != null) {
                    i.this.f13837a.a();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        public i(TextView textView, StrokeGradientDrawable strokeGradientDrawable) {
            this.f13850n = textView;
            this.f13851o = strokeGradientDrawable;
        }

        public void f() {
            this.f13852p.end();
            this.f13852p.removeAllListeners();
        }

        public void g() {
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this.f13851o.getGradientDrawable(), "color", this.f13841e, this.f13842f);
            objectAnimatorOfInt.setEvaluator(new ArgbEvaluator());
            ObjectAnimator objectAnimatorOfInt2 = ObjectAnimator.ofInt(this.f13851o, "strokeColor", this.f13843g, this.f13844h);
            objectAnimatorOfInt2.setEvaluator(new ArgbEvaluator());
            AnimatorSet animatorSet = new AnimatorSet();
            this.f13852p = animatorSet;
            animatorSet.setInterpolator(CircularProgressButton.this.getInterpolator());
            this.f13852p.setDuration(this.f13838b);
            this.f13852p.playTogether(objectAnimatorOfInt, objectAnimatorOfInt2);
            this.f13852p.addListener(new c());
            this.f13852p.start();
        }

        public void h(int i5) {
            this.f13838b = i5;
        }

        public void i(int i5) {
            this.f13841e = i5;
        }

        public void j(float f5) {
            this.f13845i = f5;
        }

        public void k(int i5) {
            this.f13843g = i5;
        }

        public void l(int i5) {
            this.f13847k = i5;
        }

        public void m(int i5) {
            this.f13839c = i5;
        }

        public void n(j jVar) {
            this.f13837a = jVar;
        }

        public void o(float f5) {
            this.f13849m = f5;
        }

        public void p(int i5) {
            this.f13842f = i5;
        }

        public void q(float f5) {
            this.f13846j = f5;
        }

        public void r(int i5) {
            this.f13844h = i5;
        }

        public void s(int i5) {
            this.f13848l = i5;
        }

        public void t(int i5) {
            this.f13840d = i5;
        }

        public void u() {
            ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.f13839c, this.f13840d);
            GradientDrawable gradientDrawable = this.f13851o.getGradientDrawable();
            valueAnimatorOfInt.addUpdateListener(new a(gradientDrawable));
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(gradientDrawable, "color", this.f13841e, this.f13842f);
            objectAnimatorOfInt.setEvaluator(new ArgbEvaluator());
            ObjectAnimator objectAnimatorOfInt2 = ObjectAnimator.ofInt(this.f13851o, "strokeColor", this.f13843g, this.f13844h);
            objectAnimatorOfInt2.setEvaluator(new ArgbEvaluator());
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(gradientDrawable, "cornerRadius", this.f13845i, this.f13846j);
            ObjectAnimator objectAnimatorOfInt3 = ObjectAnimator.ofInt(this.f13851o, "strokeWidth", this.f13847k, this.f13848l);
            AnimatorSet animatorSet = new AnimatorSet();
            this.f13852p = animatorSet;
            animatorSet.setInterpolator(CircularProgressButton.this.getInterpolator());
            this.f13852p.setDuration(this.f13838b);
            this.f13852p.playTogether(valueAnimatorOfInt, objectAnimatorOfInt, objectAnimatorOfInt2, objectAnimatorOfFloat, objectAnimatorOfInt3);
            this.f13852p.addListener(new b());
            this.f13852p.start();
        }
    }

    interface j {
        void a();
    }

    static class k extends View.BaseSavedState {
        public static final Parcelable.Creator<k> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        private boolean f13858a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f13859b;

        /* renamed from: c, reason: collision with root package name */
        private int f13860c;

        class a implements Parcelable.Creator<k> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public k createFromParcel(Parcel parcel) {
                return new k(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public k[] newArray(int i5) {
                return new k[i5];
            }
        }

        /* synthetic */ k(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.f13860c);
            parcel.writeInt(this.f13858a ? 1 : 0);
            parcel.writeInt(this.f13859b ? 1 : 0);
        }

        public k(Parcelable parcelable) {
            super(parcelable);
        }

        private k(Parcel parcel) {
            super(parcel);
            this.f13860c = parcel.readInt();
            this.f13858a = parcel.readInt() == 1;
            this.f13859b = parcel.readInt() == 1;
        }
    }

    public enum l {
        PROGRESS,
        IDLE,
        COMPLETE,
        ERROR
    }

    public CircularProgressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, H1.c.f2054a);
    }

    private int B(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{-16842910}, 0);
    }

    private int C(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{R.attr.state_focused}, 0);
    }

    private int D(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{R.attr.state_enabled}, 0);
    }

    private int E(ColorStateList colorStateList) {
        return colorStateList.getColorForState(new int[]{R.attr.state_pressed}, 0);
    }

    private void H(Context context, AttributeSet attributeSet, int i5) {
        I(context, attributeSet, i5);
        this.f13793V = 100;
        this.f13814l = l.IDLE;
        setText(this.f13815m);
        a0();
        L();
        J();
        M();
        K();
        this.f13813k = this.f13807g;
        setBackgroundCompat(null);
        new I1.f().e(this, false);
    }

    private void I(Context context, AttributeSet attributeSet, int i5) {
        TypedArray typedArrayG = G(context, attributeSet, H1.m.f2469O, i5);
        if (typedArrayG == null) {
            return;
        }
        int dimensionPixelSize = typedArrayG.getDimensionPixelSize(H1.m.f2563d0, (int) getContext().getResources().getDimension(H1.f.f2139e));
        this.f13824v = dimensionPixelSize;
        this.f13792U = dimensionPixelSize;
        this.f13815m = typedArrayG.getString(H1.m.f2601j0);
        this.f13816n = typedArrayG.getString(H1.m.f2589h0);
        this.f13817o = typedArrayG.getString(H1.m.f2595i0);
        this.f13818p = typedArrayG.getString(H1.m.f2607k0);
        this.f13822t = typedArrayG.getResourceId(H1.m.f2505U, 0);
        this.f13823u = typedArrayG.getResourceId(H1.m.f2511V, 0);
        this.f13826x = typedArrayG.getDimension(H1.m.f2499T, 0.0f);
        this.f13825w = typedArrayG.getDimensionPixelSize(H1.m.f2517W, 0);
        int i6 = H1.m.f2535Z;
        int i7 = H1.e.f2091m;
        int resourceId = typedArrayG.getResourceId(i6, i7);
        this.f13801d = getResources().getColorStateList(resourceId);
        this.f13782H = getResources().getColorStateList(typedArrayG.getResourceId(H1.m.f2556c0, resourceId));
        int resourceId2 = typedArrayG.getResourceId(H1.m.f2523X, H1.e.f2090l);
        this.f13803e = getResources().getColorStateList(resourceId2);
        this.f13783I = getResources().getColorStateList(typedArrayG.getResourceId(H1.m.f2542a0, resourceId2));
        int resourceId3 = typedArrayG.getResourceId(H1.m.f2529Y, i7);
        this.f13805f = getResources().getColorStateList(resourceId3);
        this.f13784J = getResources().getColorStateList(typedArrayG.getResourceId(H1.m.f2549b0, resourceId3));
        this.f13819q = typedArrayG.getColor(H1.m.f2493S, A(H1.e.f2092n));
        this.f13820r = typedArrayG.getColor(H1.m.f2481Q, A(i7));
        this.f13821s = typedArrayG.getColor(H1.m.f2487R, A(H1.e.f2089k));
        ColorStateList colorStateList = typedArrayG.getColorStateList(H1.m.f2577f0);
        this.f13781G = colorStateList;
        if (colorStateList == null) {
            this.f13781G = getTextColors();
        }
        ColorStateList colorStateList2 = typedArrayG.getColorStateList(H1.m.f2583g0);
        this.f13779E = colorStateList2;
        if (colorStateList2 == null) {
            this.f13779E = getTextColors();
        }
        ColorStateList colorStateList3 = typedArrayG.getColorStateList(H1.m.f2570e0);
        this.f13780F = colorStateList3;
        if (colorStateList3 == null) {
            this.f13780F = getTextColors();
        }
        this.f13787M = typedArrayG.getBoolean(H1.m.f2475P, true);
        typedArrayG.recycle();
    }

    private void J() {
        StrokeGradientDrawable strokeGradientDrawableS = s(E(this.f13803e), E(this.f13783I));
        if (this.f13809h == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f13809h = stateListDrawable;
            stateListDrawable.setCallback(this);
        }
        this.f13809h.addState(new int[]{R.attr.state_pressed}, strokeGradientDrawableS.getGradientDrawable());
        this.f13809h.addState(StateSet.WILD_CARD, this.f13795a.getGradientDrawable());
        this.f13809h.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
    }

    private void K() {
        StrokeGradientDrawable strokeGradientDrawableS = s(E(this.f13805f), E(this.f13784J));
        if (this.f13811i == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f13811i = stateListDrawable;
            stateListDrawable.setCallback(this);
        }
        this.f13811i.addState(new int[]{R.attr.state_pressed}, strokeGradientDrawableS.getGradientDrawable());
        this.f13811i.addState(StateSet.WILD_CARD, this.f13795a.getGradientDrawable());
        this.f13811i.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
    }

    private void L() {
        int iD = D(this.f13801d);
        int iE = E(this.f13801d);
        int iC = C(this.f13801d);
        int iB = B(this.f13801d);
        int iD2 = D(this.f13782H);
        int iE2 = E(this.f13782H);
        int iC2 = C(this.f13782H);
        int iB2 = B(this.f13782H);
        if (this.f13795a == null) {
            this.f13795a = s(iD, iD2);
        }
        StrokeGradientDrawable strokeGradientDrawableS = s(iB, iB2);
        StrokeGradientDrawable strokeGradientDrawableS2 = s(iC, iC2);
        StrokeGradientDrawable strokeGradientDrawableS3 = s(iE, iE2);
        if (this.f13807g == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f13807g = stateListDrawable;
            stateListDrawable.setCallback(this);
        }
        this.f13807g.addState(new int[]{R.attr.state_pressed}, strokeGradientDrawableS3.getGradientDrawable());
        this.f13807g.addState(new int[]{R.attr.state_focused}, strokeGradientDrawableS2.getGradientDrawable());
        this.f13807g.addState(new int[]{-16842910}, strokeGradientDrawableS.getGradientDrawable());
        this.f13807g.addState(StateSet.WILD_CARD, this.f13795a.getGradientDrawable());
        this.f13807g.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
    }

    private void M() {
        if (this.f13812j == null) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.f13812j = stateListDrawable;
            stateListDrawable.setCallback(this);
        }
        this.f13812j.addState(StateSet.WILD_CARD, this.f13795a.getGradientDrawable());
        int iAbs = (Math.abs(getWidth() - getHeight()) / 2) + this.f13825w;
        int width = getWidth() - iAbs;
        int i5 = this.f13825w;
        this.f13812j.setBounds(iAbs, i5, width - i5, getHeight() - this.f13825w);
    }

    private void N() {
        i iVarT = t();
        iVarT.i(D(this.f13803e));
        iVarT.p(D(this.f13801d));
        iVarT.k(D(this.f13783I));
        iVarT.r(D(this.f13782H));
        iVarT.n(this.f13808g0);
        setState(l.IDLE);
        this.f13813k = this.f13807g;
        iVarT.u();
    }

    private void O() {
        i iVarT = t();
        iVarT.i(D(this.f13805f));
        iVarT.p(D(this.f13801d));
        iVarT.k(D(this.f13784J));
        iVarT.r(D(this.f13782H));
        iVarT.n(this.f13808g0);
        setState(l.IDLE);
        this.f13813k = this.f13807g;
        iVarT.u();
    }

    private void P() {
        i iVarT = t();
        iVarT.i(D(this.f13801d));
        iVarT.k(D(this.f13782H));
        iVarT.p(D(this.f13803e));
        iVarT.r(D(this.f13783I));
        iVarT.n(this.f13806f0);
        setState(l.COMPLETE);
        this.f13813k = this.f13809h;
        iVarT.u();
    }

    private void Q() {
        i iVarT = t();
        iVarT.i(D(this.f13801d));
        iVarT.p(D(this.f13805f));
        iVarT.k(D(this.f13782H));
        iVarT.r(D(this.f13784J));
        iVarT.n(this.f13810h0);
        setState(l.ERROR);
        this.f13813k = this.f13811i;
        iVarT.u();
    }

    private void R() {
        i iVarU = u(getHeight(), this.f13826x, getHeight(), getWidth());
        iVarU.i(this.f13819q);
        iVarU.k(this.f13820r);
        iVarU.r(D(this.f13783I));
        iVarU.p(D(this.f13803e));
        iVarU.l(this.f13792U);
        iVarU.s(this.f13824v);
        iVarU.n(this.f13806f0);
        setState(l.COMPLETE);
        this.f13813k = this.f13809h;
        iVarU.u();
    }

    private void S() {
        i iVarU = u(getHeight(), this.f13826x, getHeight(), getWidth());
        iVarU.i(this.f13819q);
        iVarU.p(D(this.f13805f));
        iVarU.k(this.f13820r);
        iVarU.r(D(this.f13784J));
        iVarU.l(this.f13792U);
        iVarU.s(this.f13824v);
        iVarU.n(this.f13810h0);
        setState(l.ERROR);
        this.f13813k = this.f13811i;
        iVarU.u();
    }

    private void T() {
        i iVarU = u(getHeight(), this.f13826x, getHeight(), getWidth());
        iVarU.i(this.f13819q);
        iVarU.p(D(this.f13801d));
        iVarU.k(this.f13820r);
        iVarU.r(D(this.f13782H));
        iVarU.l(this.f13792U);
        iVarU.s(this.f13824v);
        iVarU.n(new f());
        setState(l.IDLE);
        this.f13813k = this.f13807g;
        iVarU.u();
    }

    private void U() {
        if (this.f13789R == 0) {
            this.f13789R = getWidth();
        }
        if (!this.f13790S || this.f13791T) {
            this.f13788Q = F(getPaint(), this.f13817o) + getCompoundPaddingLeft() + getCompoundPaddingRight();
        } else {
            this.f13788Q = getWidth();
        }
        setWidth(this.f13788Q);
        setText(this.f13818p);
        a0();
        i iVarU = u(this.f13826x, getHeight(), this.f13788Q, getHeight());
        iVarU.i(D(this.f13801d));
        iVarU.p(this.f13819q);
        iVarU.k(D(this.f13782H));
        iVarU.r(this.f13821s);
        iVarU.l(this.f13824v);
        iVarU.s(this.f13792U);
        iVarU.n(this.f13804e0);
        setState(l.PROGRESS);
        this.f13813k = this.f13812j;
        iVarU.u();
    }

    private Rect V() {
        if (!this.f13796a0) {
            return null;
        }
        Rect rect = new Rect();
        rect.set(this.f13795a.getGradientDrawable().getBounds());
        return rect;
    }

    private void X(Rect rect) {
        if (!this.f13796a0 || rect == null) {
            return;
        }
        this.f13795a.getGradientDrawable().setBounds(rect);
    }

    private void Y(l lVar, Drawable drawable) {
        if (drawable == null) {
            return;
        }
        if (lVar != l.PROGRESS) {
            drawable.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
            return;
        }
        int iAbs = (Math.abs(getWidth() - getHeight()) / 2) + this.f13825w;
        int width = getWidth() - iAbs;
        int i5 = this.f13825w;
        drawable.setBounds(iAbs, i5, width - i5, getHeight() - this.f13825w);
    }

    private void Z(Drawable drawable, int[] iArr) {
        if (drawable == null) {
            return;
        }
        drawable.setState(iArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float a0() {
        setEllipsize(TextUtils.TruncateAt.END);
        setMaxLines(1);
        if (!this.f13787M || getText() == null) {
            return 0.0f;
        }
        float F5 = F(getPaint(), getText().toString());
        int iA = (int) N1.i.a(12.0f, getContext());
        if ((iA * 2) + F5 < ((int) N1.i.a(90.0f, getContext()))) {
            setPadding(iA, 0, iA, 0);
            return F5;
        }
        int iA2 = (int) N1.i.a(8.0f, getContext());
        setPadding(iA2, 0, iA2, 0);
        return F5;
    }

    private void e0() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.f13800c0, this.f13794W);
        this.f13798b0 = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(f13774i0);
        this.f13798b0.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f13798b0.addUpdateListener(new h());
        this.f13798b0.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Interpolator getInterpolator() {
        return new PathInterpolator(0.2f, 0.38f, 0.1f, 1.0f);
    }

    private void q() {
        ValueAnimator valueAnimator = this.f13798b0;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f13798b0.removeAllUpdateListeners();
            this.f13798b0.removeAllListeners();
        }
    }

    private void r(l lVar, boolean z5) {
        int i5;
        if (z5 || lVar != this.f13814l) {
            p();
            int iD = D(this.f13801d);
            int iD2 = D(this.f13801d);
            ColorStateList textColors = getTextColors();
            int iOrdinal = lVar.ordinal();
            String str = BuildConfig.FLAVOR;
            if (iOrdinal == 0) {
                iD = this.f13819q;
                iD2 = this.f13821s;
                setState(l.PROGRESS);
                this.f13813k = this.f13812j;
            } else if (iOrdinal == 1) {
                iD = D(this.f13801d);
                iD2 = D(this.f13782H);
                str = this.f13815m;
                setState(l.IDLE);
                textColors = this.f13779E;
                this.f13813k = this.f13807g;
            } else if (iOrdinal == 2) {
                iD = D(this.f13803e);
                iD2 = D(this.f13783I);
                str = this.f13816n;
                setState(l.COMPLETE);
                textColors = this.f13780F;
                this.f13813k = this.f13809h;
            } else if (iOrdinal == 3) {
                iD = D(this.f13805f);
                iD2 = D(this.f13784J);
                str = this.f13817o;
                setState(l.ERROR);
                textColors = this.f13781G;
                this.f13813k = this.f13811i;
            }
            GradientDrawable gradientDrawable = this.f13795a.getGradientDrawable();
            if (lVar == l.PROGRESS) {
                int iAbs = (Math.abs(getWidth() - getHeight()) / 2) + this.f13825w;
                int width = getWidth() - iAbs;
                int i6 = this.f13825w;
                gradientDrawable.setBounds(iAbs, i6, width - i6, getHeight() - this.f13825w);
                i5 = this.f13792U;
            } else {
                i5 = this.f13824v;
                gradientDrawable.setBounds(0, 0, getRight() - getLeft(), getBottom() - getTop());
            }
            gradientDrawable.setColor(iD);
            this.f13795a.setStrokeWidth(i5);
            this.f13795a.setStrokeColor(iD2);
            setText(str);
            setTextColor(textColors);
            post(new g());
        }
    }

    private StrokeGradientDrawable s(int i5, int i6) {
        GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(H1.g.f2187c).mutate();
        gradientDrawable.setColor(i5);
        gradientDrawable.setCornerRadius(this.f13826x);
        StrokeGradientDrawable strokeGradientDrawable = new StrokeGradientDrawable(gradientDrawable);
        strokeGradientDrawable.setStrokeColor(i6);
        return strokeGradientDrawable;
    }

    private void setBackgroundFromState(l lVar) {
        int iOrdinal = lVar.ordinal();
        if (iOrdinal == 0) {
            this.f13813k = this.f13812j;
            return;
        }
        if (iOrdinal == 1) {
            this.f13813k = this.f13807g;
        } else if (iOrdinal == 2) {
            this.f13813k = this.f13809h;
        } else {
            if (iOrdinal != 3) {
                return;
            }
            this.f13813k = this.f13811i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setIcon(int i5) throws Resources.NotFoundException {
        Drawable drawable = getResources().getDrawable(i5);
        if (drawable != null) {
            int width = (getWidth() / 2) - (drawable.getIntrinsicWidth() / 2);
            setCompoundDrawablesWithIntrinsicBounds(i5, 0, 0, 0);
            setPadding(width, 0, 0, 0);
        }
    }

    private void setState(l lVar) {
        if (this.f13814l != lVar) {
            this.f13814l = lVar;
        }
    }

    private void setTextForState(l lVar) {
        int iOrdinal = lVar.ordinal();
        if (iOrdinal == 1) {
            setText(this.f13815m);
            a0();
        } else if (iOrdinal == 2) {
            setText(this.f13816n);
            a0();
        } else {
            if (iOrdinal != 3) {
                return;
            }
            setText(this.f13817o);
            a0();
        }
    }

    private i t() {
        this.f13796a0 = true;
        setClickable(false);
        i iVar = new i(this, this.f13795a);
        this.f13778D = iVar;
        iVar.j(this.f13826x);
        this.f13778D.q(this.f13826x);
        this.f13778D.m(getWidth());
        this.f13778D.t(getWidth());
        if (this.f13828z || !this.f13777C) {
            this.f13778D.h(1);
        } else {
            this.f13778D.h(240);
        }
        this.f13828z = false;
        return this.f13778D;
    }

    private i u(float f5, float f6, int i5, int i6) {
        this.f13796a0 = true;
        setClickable(false);
        i iVar = new i(this, this.f13795a);
        this.f13778D = iVar;
        iVar.j(f5);
        this.f13778D.q(f6);
        this.f13778D.o(this.f13825w);
        this.f13778D.m(i5);
        this.f13778D.t(i6);
        if (this.f13828z || !this.f13777C) {
            this.f13778D.h(1);
        } else {
            this.f13778D.h(240);
        }
        this.f13828z = false;
        return this.f13778D;
    }

    private void v() {
        i iVar = new i(this, this.f13795a);
        this.f13778D = iVar;
        iVar.i(this.f13819q);
        this.f13778D.p(D(this.f13805f));
        this.f13778D.k(this.f13820r);
        this.f13778D.r(D(this.f13784J));
        this.f13778D.n(new d());
        setState(l.ERROR);
        this.f13813k = this.f13811i;
        this.f13778D.g();
    }

    private void w(Canvas canvas) {
        CircularAnimatedDrawable circularAnimatedDrawable = this.f13797b;
        if (circularAnimatedDrawable != null) {
            circularAnimatedDrawable.setAllowLoading(true);
            this.f13797b.draw(canvas);
            return;
        }
        int width = (getWidth() - getHeight()) / 2;
        this.f13797b = new CircularAnimatedDrawable(this.f13820r, this.f13792U);
        int i5 = this.f13825w + width;
        int width2 = (getWidth() - width) - this.f13825w;
        int height = getHeight();
        int i6 = this.f13825w;
        this.f13797b.setBounds(i5, i6, width2, height - i6);
        this.f13797b.setCallback(this);
        this.f13797b.start();
    }

    private void x(Canvas canvas) {
        if (this.f13799c == null) {
            int width = (getWidth() - getHeight()) / 2;
            this.f13799c = new CircularProgressDrawable(getHeight() - (this.f13825w * 2), this.f13792U, this.f13820r);
            int i5 = width + this.f13825w;
            int i6 = this.f13825w;
            this.f13799c.setOffset(((getWidth() - getHeight()) / 2.0f) + i6, i6);
            CircularProgressDrawable circularProgressDrawable = this.f13799c;
            int i7 = this.f13825w;
            circularProgressDrawable.setBounds(i5, i7, i5, i7);
        }
        if (this.f13776B) {
            this.f13776B = false;
            this.f13799c.setCenterIcon(this.f13775A);
            if (this.f13775A == null) {
                this.f13799c.setShowCenterIcon(this.f13785K);
            }
        }
        this.f13799c.setStartAngle(-90.0f);
        this.f13799c.setSweepAngle((360.0f / this.f13793V) * this.f13800c0);
        this.f13799c.draw(canvas);
    }

    private void y(Drawable drawable, Canvas canvas) {
        if (drawable != null) {
            drawable.draw(canvas);
        }
    }

    private void z() {
        Y(l.IDLE, this.f13807g);
        Y(l.COMPLETE, this.f13809h);
        Y(l.ERROR, this.f13811i);
        Y(this.f13814l, this.f13795a.getGradientDrawable());
    }

    protected int A(int i5) {
        return getResources().getColor(i5);
    }

    public int F(Paint paint, String str) {
        TransformationMethod transformationMethod = getTransformationMethod();
        if (transformationMethod != null) {
            str = transformationMethod.getTransformation(str, this).toString();
        }
        return (int) paint.measureText(str);
    }

    protected TypedArray G(Context context, AttributeSet attributeSet, int[] iArr, int i5) {
        return context.obtainStyledAttributes(attributeSet, iArr, i5, 0);
    }

    protected void W() {
        setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        setPadding(0, 0, 0, 0);
    }

    public void b0(int i5, boolean z5) {
        this.f13794W = i5;
        this.f13777C = z5;
        if (this.f13796a0 || getWidth() == 0) {
            return;
        }
        int i6 = this.f13794W;
        if (i6 >= this.f13793V) {
            l lVar = this.f13814l;
            if (lVar == l.PROGRESS) {
                R();
                return;
            } else {
                if (lVar == l.IDLE) {
                    P();
                    return;
                }
                return;
            }
        }
        if (i6 > 0) {
            l lVar2 = this.f13814l;
            if (lVar2 == l.IDLE || lVar2 == l.ERROR) {
                U();
                return;
            }
            if (lVar2 == l.PROGRESS) {
                q();
                if (z5) {
                    e0();
                    return;
                } else {
                    this.f13800c0 = this.f13794W;
                    invalidate();
                    return;
                }
            }
            return;
        }
        if (i6 == -1) {
            l lVar3 = this.f13814l;
            if (lVar3 == l.PROGRESS) {
                S();
                return;
            } else {
                if (lVar3 == l.IDLE) {
                    Q();
                    return;
                }
                return;
            }
        }
        if (i6 == 0) {
            l lVar4 = this.f13814l;
            if (lVar4 == l.COMPLETE) {
                N();
            } else if (lVar4 == l.PROGRESS) {
                T();
            } else if (lVar4 == l.ERROR) {
                O();
            }
        }
    }

    public void c0(int i5, boolean z5) {
        if (this.f13814l == l.PROGRESS) {
            this.f13794W = i5;
            q();
            if (z5) {
                e0();
            } else {
                this.f13800c0 = this.f13794W;
                invalidate();
            }
        }
    }

    public void d0(l lVar, boolean z5, boolean z6) {
        if (lVar == this.f13814l) {
            return;
        }
        this.f13777C = z5;
        if (!z5) {
            r(lVar, false);
            return;
        }
        if (this.f13796a0 || getWidth() == 0) {
            if (!this.f13802d0 || lVar != l.COMPLETE) {
                return;
            } else {
                p();
            }
        }
        int iOrdinal = lVar.ordinal();
        if (iOrdinal == 0) {
            if (this.f13814l != l.PROGRESS) {
                U();
                return;
            }
            return;
        }
        if (iOrdinal == 1) {
            int iOrdinal2 = this.f13814l.ordinal();
            if (iOrdinal2 == 0) {
                T();
                return;
            } else if (iOrdinal2 == 2) {
                N();
                return;
            } else {
                if (iOrdinal2 != 3) {
                    return;
                }
                O();
                return;
            }
        }
        if (iOrdinal == 2) {
            int iOrdinal3 = this.f13814l.ordinal();
            if (iOrdinal3 == 0) {
                R();
                return;
            } else {
                if (iOrdinal3 != 1) {
                    return;
                }
                P();
                return;
            }
        }
        if (iOrdinal != 3) {
            return;
        }
        int iOrdinal4 = this.f13814l.ordinal();
        if (iOrdinal4 != 0) {
            if (iOrdinal4 != 1) {
                return;
            }
            Q();
        } else if (F(getPaint(), this.f13817o) + getCompoundPaddingRight() + getCompoundPaddingLeft() <= this.f13789R || this.f13817o == null) {
            S();
        } else {
            v();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f13786L || !this.f13796a0) {
            this.f13786L = false;
            z();
        }
        if (this.f13796a0 && isPressed()) {
            super.draw(canvas);
            return;
        }
        if (this.f13813k != null) {
            if ((getScrollX() | getScrollY()) == 0) {
                int iOrdinal = this.f13814l.ordinal();
                if (iOrdinal == 0) {
                    y(this.f13812j, canvas);
                } else if (iOrdinal == 1) {
                    y(this.f13807g, canvas);
                } else if (iOrdinal == 2) {
                    y(this.f13809h, canvas);
                } else if (iOrdinal == 3) {
                    y(this.f13811i, canvas);
                }
            } else {
                canvas.translate(getScrollX(), getScrollY());
                this.f13813k.draw(canvas);
                canvas.translate(-getScrollX(), -getScrollY());
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        Rect rectV = V();
        Z(this.f13807g, getDrawableState());
        Z(this.f13809h, getDrawableState());
        Z(this.f13811i, getDrawableState());
        Z(this.f13812j, getDrawableState());
        X(rectV);
        super.drawableStateChanged();
    }

    public String getCompleteText() {
        return this.f13816n;
    }

    public String getErrorText() {
        return this.f13817o;
    }

    public String getIdleText() {
        return this.f13815m;
    }

    public int getProgress() {
        return this.f13794W;
    }

    public l getState() {
        return this.f13814l;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        p();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f13814l != l.PROGRESS || this.f13796a0) {
            CircularAnimatedDrawable circularAnimatedDrawable = this.f13797b;
            if (circularAnimatedDrawable != null) {
                circularAnimatedDrawable.setAllowLoading(false);
                return;
            }
            return;
        }
        if (this.f13827y) {
            w(canvas);
        } else {
            x(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(CircularProgressButton.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
        if (z5) {
            d0(this.f13814l, false, false);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof k)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        k kVar = (k) parcelable;
        this.f13794W = kVar.f13860c;
        this.f13827y = kVar.f13858a;
        this.f13828z = kVar.f13859b;
        super.onRestoreInstanceState(kVar.getSuperState());
        setProgress(this.f13794W);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        k kVar = new k(super.onSaveInstanceState());
        kVar.f13860c = this.f13794W;
        kVar.f13858a = this.f13827y;
        kVar.f13859b = true;
        return kVar;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        this.f13797b = null;
        this.f13799c = null;
        this.f13776B = true;
        this.f13786L = true;
    }

    public void p() {
        i iVar = this.f13778D;
        if (iVar != null) {
            iVar.f();
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i5) {
        this.f13795a.getGradientDrawable().setColor(i5);
    }

    public void setBackgroundCompat(Drawable drawable) {
        setBackground(drawable);
    }

    public void setCanSkipAnim(boolean z5) {
        this.f13802d0 = z5;
    }

    public void setCompleteText(String str) {
        this.f13816n = str;
    }

    public void setErrorText(String str) {
        this.f13817o = str;
    }

    public void setIdleText(String str) {
        this.f13815m = str;
    }

    public void setIndeterminateProgressMode(boolean z5) {
        this.f13827y = z5;
    }

    public void setIndicatorBackgroundColor(int i5) {
        if (this.f13821s != i5) {
            this.f13821s = i5;
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z5) {
        if (z5 && this.f13796a0) {
            return;
        }
        super.setPressed(z5);
    }

    @Deprecated
    public void setProgress(int i5) {
        b0(i5, true);
    }

    public void setProgressCenterIcon(Drawable drawable) {
        this.f13775A = drawable;
        this.f13776B = true;
    }

    public void setProgressForState(int i5) {
        c0(i5, false);
    }

    public void setProgressIndicatorColor(int i5) {
        this.f13820r = i5;
        this.f13797b = null;
        this.f13799c = null;
    }

    public void setProgressStrokeWidth(int i5) {
        M();
        if (i5 <= 0 || this.f13792U == i5) {
            return;
        }
        this.f13792U = i5;
        CircularAnimatedDrawable circularAnimatedDrawable = this.f13797b;
        if (circularAnimatedDrawable != null) {
            circularAnimatedDrawable.setStrokeWidth(i5);
        }
        CircularProgressDrawable circularProgressDrawable = this.f13799c;
        if (circularProgressDrawable != null) {
            circularProgressDrawable.setStrokeWidth(i5);
        }
    }

    public void setShowCenterIcon(boolean z5) {
        this.f13785K = z5;
        this.f13776B = true;
    }

    public void setStrokeColor(int i5) {
        this.f13795a.setStrokeColor(i5);
    }

    @Override // android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f13797b || drawable == this.f13812j || drawable == this.f13807g || drawable == this.f13811i || drawable == this.f13809h || super.verifyDrawable(drawable);
    }

    public CircularProgressButton(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f13777C = true;
        this.f13785K = false;
        this.f13786L = false;
        this.f13787M = true;
        this.f13789R = 0;
        this.f13790S = true;
        this.f13794W = 0;
        this.f13804e0 = new a();
        this.f13806f0 = new b();
        this.f13808g0 = new c();
        this.f13810h0 = new e();
        H(context, attributeSet, i5);
    }
}
