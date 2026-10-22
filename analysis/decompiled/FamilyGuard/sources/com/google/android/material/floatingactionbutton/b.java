package com.google.android.material.floatingactionbutton;

import a1.C0409b;
import a1.C0414g;
import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import b1.C0553a;
import b1.C0554b;
import b1.f;
import b1.g;
import b1.h;
import java.util.ArrayList;
import r1.C0994a;
import s1.InterfaceC1048b;
import t1.C1115h;
import t1.C1116i;
import t1.l;
import t1.o;

/* loaded from: classes.dex */
class b {

    /* renamed from: B, reason: collision with root package name */
    static final TimeInterpolator f12855B = C0553a.f11785c;

    /* renamed from: C, reason: collision with root package name */
    private static final int f12856C = C0409b.f6736w;

    /* renamed from: D, reason: collision with root package name */
    private static final int f12857D = C0409b.f6696F;

    /* renamed from: E, reason: collision with root package name */
    private static final int f12858E = C0409b.f6737x;

    /* renamed from: F, reason: collision with root package name */
    private static final int f12859F = C0409b.f6694D;

    /* renamed from: G, reason: collision with root package name */
    static final int[] f12860G = {R.attr.state_pressed, R.attr.state_enabled};

    /* renamed from: H, reason: collision with root package name */
    static final int[] f12861H = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};

    /* renamed from: I, reason: collision with root package name */
    static final int[] f12862I = {R.attr.state_focused, R.attr.state_enabled};

    /* renamed from: J, reason: collision with root package name */
    static final int[] f12863J = {R.attr.state_hovered, R.attr.state_enabled};

    /* renamed from: K, reason: collision with root package name */
    static final int[] f12864K = {R.attr.state_enabled};

    /* renamed from: L, reason: collision with root package name */
    static final int[] f12865L = new int[0];

    /* renamed from: A, reason: collision with root package name */
    private ViewTreeObserver.OnPreDrawListener f12866A;

    /* renamed from: a, reason: collision with root package name */
    l f12867a;

    /* renamed from: b, reason: collision with root package name */
    C1115h f12868b;

    /* renamed from: c, reason: collision with root package name */
    Drawable f12869c;

    /* renamed from: d, reason: collision with root package name */
    Drawable f12870d;

    /* renamed from: e, reason: collision with root package name */
    boolean f12871e;

    /* renamed from: g, reason: collision with root package name */
    float f12873g;

    /* renamed from: h, reason: collision with root package name */
    float f12874h;

    /* renamed from: i, reason: collision with root package name */
    float f12875i;

    /* renamed from: j, reason: collision with root package name */
    int f12876j;

    /* renamed from: k, reason: collision with root package name */
    private StateListAnimator f12877k;

    /* renamed from: l, reason: collision with root package name */
    private Animator f12878l;

    /* renamed from: m, reason: collision with root package name */
    private h f12879m;

    /* renamed from: n, reason: collision with root package name */
    private h f12880n;

    /* renamed from: p, reason: collision with root package name */
    private int f12882p;

    /* renamed from: r, reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f12884r;

    /* renamed from: s, reason: collision with root package name */
    private ArrayList<Animator.AnimatorListener> f12885s;

    /* renamed from: t, reason: collision with root package name */
    private ArrayList<d> f12886t;

    /* renamed from: u, reason: collision with root package name */
    final FloatingActionButton f12887u;

    /* renamed from: v, reason: collision with root package name */
    final InterfaceC1048b f12888v;

    /* renamed from: f, reason: collision with root package name */
    boolean f12872f = true;

    /* renamed from: o, reason: collision with root package name */
    private float f12881o = 1.0f;

    /* renamed from: q, reason: collision with root package name */
    private int f12883q = 0;

    /* renamed from: w, reason: collision with root package name */
    private final Rect f12889w = new Rect();

    /* renamed from: x, reason: collision with root package name */
    private final RectF f12890x = new RectF();

    /* renamed from: y, reason: collision with root package name */
    private final RectF f12891y = new RectF();

    /* renamed from: z, reason: collision with root package name */
    private final Matrix f12892z = new Matrix();

    class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f12893a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f12894b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ e f12895c;

        a(boolean z5, e eVar) {
            this.f12894b = z5;
            this.f12895c = eVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f12893a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.f12883q = 0;
            b.this.f12878l = null;
            if (this.f12893a) {
                return;
            }
            FloatingActionButton floatingActionButton = b.this.f12887u;
            boolean z5 = this.f12894b;
            floatingActionButton.b(z5 ? 8 : 4, z5);
            e eVar = this.f12895c;
            if (eVar != null) {
                eVar.b();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.f12887u.b(0, this.f12894b);
            b.this.f12883q = 1;
            b.this.f12878l = animator;
            this.f12893a = false;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.b$b, reason: collision with other inner class name */
    class C0167b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f12897a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f12898b;

        C0167b(boolean z5, e eVar) {
            this.f12897a = z5;
            this.f12898b = eVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.f12883q = 0;
            b.this.f12878l = null;
            e eVar = this.f12898b;
            if (eVar != null) {
                eVar.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.f12887u.b(0, this.f12897a);
            b.this.f12883q = 2;
            b.this.f12878l = animator;
        }
    }

    class c extends g {
        c() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f5, Matrix matrix, Matrix matrix2) {
            b.this.f12881o = f5;
            return super.evaluate(f5, matrix, matrix2);
        }
    }

    interface d {
        void a();

        void b();
    }

    interface e {
        void a();

        void b();
    }

    b(FloatingActionButton floatingActionButton, InterfaceC1048b interfaceC1048b) {
        this.f12887u = floatingActionButton;
        this.f12888v = interfaceC1048b;
    }

    private boolean V() {
        return this.f12887u.isLaidOut() && !this.f12887u.isInEditMode();
    }

    public static /* synthetic */ void a(b bVar, float f5, float f6, float f7, float f8, float f9, float f10, float f11, Matrix matrix, ValueAnimator valueAnimator) {
        bVar.getClass();
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        bVar.f12887u.setAlpha(C0553a.b(f5, f6, 0.0f, 0.2f, fFloatValue));
        bVar.f12887u.setScaleX(C0553a.a(f7, f8, fFloatValue));
        bVar.f12887u.setScaleY(C0553a.a(f9, f8, fFloatValue));
        bVar.f12881o = C0553a.a(f10, f11, fFloatValue);
        bVar.h(C0553a.a(f10, f11, fFloatValue), matrix);
        bVar.f12887u.setImageMatrix(matrix);
    }

    private void a0(ObjectAnimator objectAnimator) {
    }

    private void h(float f5, Matrix matrix) {
        matrix.reset();
        if (this.f12887u.getDrawable() == null || this.f12882p == 0) {
            return;
        }
        RectF rectF = this.f12890x;
        RectF rectF2 = this.f12891y;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i5 = this.f12882p;
        rectF2.set(0.0f, 0.0f, i5, i5);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i6 = this.f12882p;
        matrix.postScale(f5, f5, i6 / 2.0f, i6 / 2.0f);
    }

    private AnimatorSet i(h hVar, float f5, float f6, float f7) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f12887u, (Property<FloatingActionButton, Float>) View.ALPHA, f5);
        hVar.e("opacity").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f12887u, (Property<FloatingActionButton, Float>) View.SCALE_X, f6);
        hVar.e("scale").a(objectAnimatorOfFloat2);
        a0(objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f12887u, (Property<FloatingActionButton, Float>) View.SCALE_Y, f6);
        hVar.e("scale").a(objectAnimatorOfFloat3);
        a0(objectAnimatorOfFloat3);
        arrayList.add(objectAnimatorOfFloat3);
        h(f7, this.f12892z);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.f12887u, new f(), new c(), new Matrix(this.f12892z));
        hVar.e("iconScale").a(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        C0554b.a(animatorSet, arrayList);
        return animatorSet;
    }

    private AnimatorSet j(final float f5, final float f6, final float f7, int i5, int i6) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        final float alpha = this.f12887u.getAlpha();
        final float scaleX = this.f12887u.getScaleX();
        final float scaleY = this.f12887u.getScaleY();
        final float f8 = this.f12881o;
        final Matrix matrix = new Matrix(this.f12892z);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.floatingactionbutton.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                b.a(this.f12846a, alpha, f5, scaleX, f6, scaleY, f8, f7, matrix, valueAnimator);
            }
        });
        arrayList.add(valueAnimatorOfFloat);
        C0554b.a(animatorSet, arrayList);
        animatorSet.setDuration(o1.e.f(this.f12887u.getContext(), i5, this.f12887u.getContext().getResources().getInteger(C0414g.f6865b)));
        animatorSet.setInterpolator(o1.e.g(this.f12887u.getContext(), i6, C0553a.f11784b));
        return animatorSet;
    }

    private StateListAnimator k(float f5, float f6, float f7) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(f12860G, l(f5, f7));
        stateListAnimator.addState(f12861H, l(f5, f6));
        stateListAnimator.addState(f12862I, l(f5, f6));
        stateListAnimator.addState(f12863J, l(f5, f6));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.f12887u, "elevation", f5).setDuration(0L));
        arrayList.add(ObjectAnimator.ofFloat(this.f12887u, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(f12855B);
        stateListAnimator.addState(f12864K, animatorSet);
        stateListAnimator.addState(f12865L, l(0.0f, 0.0f));
        return stateListAnimator;
    }

    private Animator l(float f5, float f6) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f12887u, "elevation", f5).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f12887u, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f6).setDuration(100L));
        animatorSet.setInterpolator(f12855B);
        return animatorSet;
    }

    void A() {
        C1115h c1115h = this.f12868b;
        if (c1115h != null) {
            C1116i.f(this.f12887u, c1115h);
        }
    }

    void B() {
        Y();
    }

    void C() {
        ViewTreeObserver viewTreeObserver = this.f12887u.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.f12866A;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.f12866A = null;
        }
    }

    void D(float f5, float f6, float f7) {
        if (this.f12887u.getStateListAnimator() == this.f12877k) {
            StateListAnimator stateListAnimatorK = k(f5, f6, f7);
            this.f12877k = stateListAnimatorK;
            this.f12887u.setStateListAnimator(stateListAnimatorK);
        }
        if (U()) {
            Y();
        }
    }

    void E(Rect rect) {
        D.h.f(this.f12870d, "Didn't initialize content background");
        if (!U()) {
            this.f12888v.g(this.f12870d);
        } else {
            this.f12888v.g(new InsetDrawable(this.f12870d, rect.left, rect.top, rect.right, rect.bottom));
        }
    }

    void F() {
        ArrayList<d> arrayList = this.f12886t;
        if (arrayList != null) {
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                d dVar = arrayList.get(i5);
                i5++;
                dVar.b();
            }
        }
    }

    void G() {
        ArrayList<d> arrayList = this.f12886t;
        if (arrayList != null) {
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                d dVar = arrayList.get(i5);
                i5++;
                dVar.a();
            }
        }
    }

    void H(ColorStateList colorStateList) {
        C1115h c1115h = this.f12868b;
        if (c1115h != null) {
            c1115h.setTintList(colorStateList);
        }
    }

    void I(PorterDuff.Mode mode) {
        C1115h c1115h = this.f12868b;
        if (c1115h != null) {
            c1115h.setTintMode(mode);
        }
    }

    final void J(float f5) {
        if (this.f12873g != f5) {
            this.f12873g = f5;
            D(f5, this.f12874h, this.f12875i);
        }
    }

    void K(boolean z5) {
        this.f12871e = z5;
    }

    final void L(h hVar) {
        this.f12880n = hVar;
    }

    final void M(float f5) {
        if (this.f12874h != f5) {
            this.f12874h = f5;
            D(this.f12873g, f5, this.f12875i);
        }
    }

    final void N(float f5) {
        this.f12881o = f5;
        Matrix matrix = this.f12892z;
        h(f5, matrix);
        this.f12887u.setImageMatrix(matrix);
    }

    final void O(int i5) {
        if (this.f12882p != i5) {
            this.f12882p = i5;
            X();
        }
    }

    final void P(float f5) {
        if (this.f12875i != f5) {
            this.f12875i = f5;
            D(this.f12873g, this.f12874h, f5);
        }
    }

    void Q(ColorStateList colorStateList) {
        Drawable drawable = this.f12869c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(C0994a.a(colorStateList));
        } else if (drawable != null) {
            drawable.setTintList(C0994a.a(colorStateList));
        }
    }

    void R(boolean z5) {
        this.f12872f = z5;
        Y();
    }

    final void S(l lVar) {
        this.f12867a = lVar;
        C1115h c1115h = this.f12868b;
        if (c1115h != null) {
            c1115h.setShapeAppearanceModel(lVar);
        }
        Object obj = this.f12869c;
        if (obj instanceof o) {
            ((o) obj).setShapeAppearanceModel(lVar);
        }
    }

    final void T(h hVar) {
        this.f12879m = hVar;
    }

    boolean U() {
        return this.f12888v.b() || x();
    }

    void W(e eVar, boolean z5) {
        b bVar;
        AnimatorSet animatorSetJ;
        if (z()) {
            return;
        }
        Animator animator = this.f12878l;
        if (animator != null) {
            animator.cancel();
        }
        int i5 = 0;
        boolean z6 = this.f12879m == null;
        if (!V()) {
            this.f12887u.b(0, z5);
            this.f12887u.setAlpha(1.0f);
            this.f12887u.setScaleY(1.0f);
            this.f12887u.setScaleX(1.0f);
            N(1.0f);
            if (eVar != null) {
                eVar.a();
                return;
            }
            return;
        }
        if (this.f12887u.getVisibility() != 0) {
            this.f12887u.setAlpha(0.0f);
            this.f12887u.setScaleY(z6 ? 0.4f : 0.0f);
            this.f12887u.setScaleX(z6 ? 0.4f : 0.0f);
            N(z6 ? 0.4f : 0.0f);
        }
        h hVar = this.f12879m;
        if (hVar != null) {
            animatorSetJ = i(hVar, 1.0f, 1.0f, 1.0f);
            bVar = this;
        } else {
            bVar = this;
            animatorSetJ = bVar.j(1.0f, 1.0f, 1.0f, f12856C, f12857D);
        }
        animatorSetJ.addListener(bVar.new C0167b(z5, eVar));
        ArrayList<Animator.AnimatorListener> arrayList = bVar.f12884r;
        if (arrayList != null) {
            int size = arrayList.size();
            while (i5 < size) {
                Animator.AnimatorListener animatorListener = arrayList.get(i5);
                i5++;
                animatorSetJ.addListener(animatorListener);
            }
        }
        animatorSetJ.start();
    }

    final void X() {
        N(this.f12881o);
    }

    final void Y() {
        Rect rect = this.f12889w;
        r(rect);
        E(rect);
        this.f12888v.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void Z(float f5) {
        C1115h c1115h = this.f12868b;
        if (c1115h != null) {
            c1115h.f0(f5);
        }
    }

    public void e(Animator.AnimatorListener animatorListener) {
        if (this.f12885s == null) {
            this.f12885s = new ArrayList<>();
        }
        this.f12885s.add(animatorListener);
    }

    void f(Animator.AnimatorListener animatorListener) {
        if (this.f12884r == null) {
            this.f12884r = new ArrayList<>();
        }
        this.f12884r.add(animatorListener);
    }

    void g(d dVar) {
        if (this.f12886t == null) {
            this.f12886t = new ArrayList<>();
        }
        this.f12886t.add(dVar);
    }

    final Drawable m() {
        return this.f12870d;
    }

    float n() {
        return this.f12887u.getElevation();
    }

    boolean o() {
        return this.f12871e;
    }

    final h p() {
        return this.f12880n;
    }

    float q() {
        return this.f12874h;
    }

    void r(Rect rect) {
        if (this.f12888v.b()) {
            int iV = v();
            int iMax = Math.max(iV, (int) Math.ceil(this.f12872f ? n() + this.f12875i : 0.0f));
            int iMax2 = Math.max(iV, (int) Math.ceil(r1 * 1.5f));
            rect.set(iMax, iMax2, iMax, iMax2);
            return;
        }
        if (!x()) {
            rect.set(0, 0, 0, 0);
        } else {
            int sizeDimension = (this.f12876j - this.f12887u.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    float s() {
        return this.f12875i;
    }

    final l t() {
        return this.f12867a;
    }

    final h u() {
        return this.f12879m;
    }

    int v() {
        if (this.f12871e) {
            return Math.max((this.f12876j - this.f12887u.getSizeDimension()) / 2, 0);
        }
        return 0;
    }

    void w(e eVar, boolean z5) {
        b bVar;
        AnimatorSet animatorSetJ;
        if (y()) {
            return;
        }
        Animator animator = this.f12878l;
        if (animator != null) {
            animator.cancel();
        }
        if (!V()) {
            this.f12887u.b(z5 ? 8 : 4, z5);
            if (eVar != null) {
                eVar.b();
                return;
            }
            return;
        }
        h hVar = this.f12880n;
        if (hVar != null) {
            animatorSetJ = i(hVar, 0.0f, 0.0f, 0.0f);
            bVar = this;
        } else {
            bVar = this;
            animatorSetJ = bVar.j(0.0f, 0.4f, 0.4f, f12858E, f12859F);
        }
        animatorSetJ.addListener(bVar.new a(z5, eVar));
        ArrayList<Animator.AnimatorListener> arrayList = bVar.f12885s;
        if (arrayList != null) {
            int size = arrayList.size();
            int i5 = 0;
            while (i5 < size) {
                Animator.AnimatorListener animatorListener = arrayList.get(i5);
                i5++;
                animatorSetJ.addListener(animatorListener);
            }
        }
        animatorSetJ.start();
    }

    final boolean x() {
        return this.f12871e && this.f12887u.getSizeDimension() < this.f12876j;
    }

    boolean y() {
        return this.f12887u.getVisibility() == 0 ? this.f12883q == 1 : this.f12883q != 2;
    }

    boolean z() {
        return this.f12887u.getVisibility() != 0 ? this.f12883q == 2 : this.f12883q != 1;
    }
}
