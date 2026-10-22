package com.google.android.material.floatingactionbutton;

import E2.f;
import E2.g;
import Z2.h;
import Z2.i;
import Z2.l;
import Z2.o;
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
import com.google.android.material.R$attr;
import com.google.android.material.R$integer;
import com.stepos.launcher.assistant.slidepanel.ConstConfig;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: B, reason: collision with root package name */
    public static final TimeInterpolator f20912B = E2.a.f2341c;

    /* renamed from: C, reason: collision with root package name */
    public static final int f20913C = R$attr.motionDurationLong2;

    /* renamed from: D, reason: collision with root package name */
    public static final int f20914D = R$attr.motionEasingEmphasizedInterpolator;

    /* renamed from: E, reason: collision with root package name */
    public static final int f20915E = R$attr.motionDurationMedium1;

    /* renamed from: F, reason: collision with root package name */
    public static final int f20916F = R$attr.motionEasingEmphasizedAccelerateInterpolator;

    /* renamed from: G, reason: collision with root package name */
    public static final int[] f20917G = {R.attr.state_pressed, R.attr.state_enabled};

    /* renamed from: H, reason: collision with root package name */
    public static final int[] f20918H = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};

    /* renamed from: I, reason: collision with root package name */
    public static final int[] f20919I = {R.attr.state_focused, R.attr.state_enabled};

    /* renamed from: J, reason: collision with root package name */
    public static final int[] f20920J = {R.attr.state_hovered, R.attr.state_enabled};

    /* renamed from: K, reason: collision with root package name */
    public static final int[] f20921K = {R.attr.state_enabled};

    /* renamed from: L, reason: collision with root package name */
    public static final int[] f20922L = new int[0];

    /* renamed from: A, reason: collision with root package name */
    public ViewTreeObserver.OnPreDrawListener f20923A;

    /* renamed from: a, reason: collision with root package name */
    public l f20924a;

    /* renamed from: b, reason: collision with root package name */
    public h f20925b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f20926c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f20927d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f20928e;

    /* renamed from: g, reason: collision with root package name */
    public float f20930g;

    /* renamed from: h, reason: collision with root package name */
    public float f20931h;

    /* renamed from: i, reason: collision with root package name */
    public float f20932i;

    /* renamed from: j, reason: collision with root package name */
    public int f20933j;

    /* renamed from: k, reason: collision with root package name */
    public StateListAnimator f20934k;

    /* renamed from: l, reason: collision with root package name */
    public Animator f20935l;

    /* renamed from: m, reason: collision with root package name */
    public E2.h f20936m;

    /* renamed from: n, reason: collision with root package name */
    public E2.h f20937n;

    /* renamed from: p, reason: collision with root package name */
    public int f20939p;

    /* renamed from: r, reason: collision with root package name */
    public ArrayList<Animator.AnimatorListener> f20941r;

    /* renamed from: s, reason: collision with root package name */
    public ArrayList<Animator.AnimatorListener> f20942s;

    /* renamed from: t, reason: collision with root package name */
    public ArrayList<d> f20943t;

    /* renamed from: u, reason: collision with root package name */
    public final FloatingActionButton f20944u;

    /* renamed from: v, reason: collision with root package name */
    public final Y2.b f20945v;

    /* renamed from: f, reason: collision with root package name */
    public boolean f20929f = true;

    /* renamed from: o, reason: collision with root package name */
    public float f20938o = 1.0f;

    /* renamed from: q, reason: collision with root package name */
    public int f20940q = 0;

    /* renamed from: w, reason: collision with root package name */
    public final Rect f20946w = new Rect();

    /* renamed from: x, reason: collision with root package name */
    public final RectF f20947x = new RectF();

    /* renamed from: y, reason: collision with root package name */
    public final RectF f20948y = new RectF();

    /* renamed from: z, reason: collision with root package name */
    public final Matrix f20949z = new Matrix();

    /* renamed from: com.google.android.material.floatingactionbutton.a$a, reason: collision with other inner class name */
    public class C0233a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f20950a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f20951b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f20952c;

        public C0233a(boolean z10, e eVar) {
            this.f20951b = z10;
            this.f20952c = eVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f20950a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f20940q = 0;
            a.this.f20935l = null;
            if (this.f20950a) {
                return;
            }
            FloatingActionButton floatingActionButton = a.this.f20944u;
            boolean z10 = this.f20951b;
            floatingActionButton.b(z10 ? 8 : 4, z10);
            e eVar = this.f20952c;
            if (eVar != null) {
                eVar.b();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f20944u.b(0, this.f20951b);
            a.this.f20940q = 1;
            a.this.f20935l = animator;
            this.f20950a = false;
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f20954a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f20955b;

        public b(boolean z10, e eVar) {
            this.f20954a = z10;
            this.f20955b = eVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f20940q = 0;
            a.this.f20935l = null;
            e eVar = this.f20955b;
            if (eVar != null) {
                eVar.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.f20944u.b(0, this.f20954a);
            a.this.f20940q = 2;
            a.this.f20935l = animator;
        }
    }

    public class c extends g {
        public c() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f10, Matrix matrix, Matrix matrix2) {
            a.this.f20938o = f10;
            return super.evaluate(f10, matrix, matrix2);
        }
    }

    public interface d {
        void a();

        void b();
    }

    public interface e {
        void a();

        void b();
    }

    public a(FloatingActionButton floatingActionButton, Y2.b bVar) {
        this.f20944u = floatingActionButton;
        this.f20945v = bVar;
    }

    public static /* synthetic */ void a(a aVar, float f10, float f11, float f12, float f13, float f14, float f15, float f16, Matrix matrix, ValueAnimator valueAnimator) {
        aVar.getClass();
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        aVar.f20944u.setAlpha(E2.a.b(f10, f11, 0.0f, 0.2f, fFloatValue));
        aVar.f20944u.setScaleX(E2.a.a(f12, f13, fFloatValue));
        aVar.f20944u.setScaleY(E2.a.a(f14, f13, fFloatValue));
        aVar.f20938o = E2.a.a(f15, f16, fFloatValue);
        aVar.h(E2.a.a(f15, f16, fFloatValue), matrix);
        aVar.f20944u.setImageMatrix(matrix);
    }

    public void A() {
        h hVar = this.f20925b;
        if (hVar != null) {
            i.f(this.f20944u, hVar);
        }
    }

    public void B() {
        Y();
    }

    public void C() {
        ViewTreeObserver viewTreeObserver = this.f20944u.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.f20923A;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.f20923A = null;
        }
    }

    public void D(float f10, float f11, float f12) {
        if (this.f20944u.getStateListAnimator() == this.f20934k) {
            StateListAnimator stateListAnimatorK = k(f10, f11, f12);
            this.f20934k = stateListAnimatorK;
            this.f20944u.setStateListAnimator(stateListAnimatorK);
        }
        if (U()) {
            Y();
        }
    }

    public void E(Rect rect) {
        B0.h.g(this.f20927d, "Didn't initialize content background");
        if (!U()) {
            this.f20945v.b(this.f20927d);
        } else {
            this.f20945v.b(new InsetDrawable(this.f20927d, rect.left, rect.top, rect.right, rect.bottom));
        }
    }

    public void F() {
        ArrayList<d> arrayList = this.f20943t;
        if (arrayList != null) {
            Iterator<d> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    public void G() {
        ArrayList<d> arrayList = this.f20943t;
        if (arrayList != null) {
            Iterator<d> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public void H(ColorStateList colorStateList) {
        h hVar = this.f20925b;
        if (hVar != null) {
            hVar.setTintList(colorStateList);
        }
    }

    public void I(PorterDuff.Mode mode) {
        h hVar = this.f20925b;
        if (hVar != null) {
            hVar.setTintMode(mode);
        }
    }

    public final void J(float f10) {
        if (this.f20930g != f10) {
            this.f20930g = f10;
            D(f10, this.f20931h, this.f20932i);
        }
    }

    public void K(boolean z10) {
        this.f20928e = z10;
    }

    public final void L(E2.h hVar) {
        this.f20937n = hVar;
    }

    public final void M(float f10) {
        if (this.f20931h != f10) {
            this.f20931h = f10;
            D(this.f20930g, f10, this.f20932i);
        }
    }

    public final void N(float f10) {
        this.f20938o = f10;
        Matrix matrix = this.f20949z;
        h(f10, matrix);
        this.f20944u.setImageMatrix(matrix);
    }

    public final void O(int i10) {
        if (this.f20939p != i10) {
            this.f20939p = i10;
            X();
        }
    }

    public final void P(float f10) {
        if (this.f20932i != f10) {
            this.f20932i = f10;
            D(this.f20930g, this.f20931h, f10);
        }
    }

    public void Q(ColorStateList colorStateList) {
        Drawable drawable = this.f20926c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(X2.a.d(colorStateList));
        } else if (drawable != null) {
            drawable.setTintList(X2.a.d(colorStateList));
        }
    }

    public void R(boolean z10) {
        this.f20929f = z10;
        Y();
    }

    public final void S(l lVar) {
        this.f20924a = lVar;
        h hVar = this.f20925b;
        if (hVar != null) {
            hVar.setShapeAppearanceModel(lVar);
        }
        Object obj = this.f20926c;
        if (obj instanceof o) {
            ((o) obj).setShapeAppearanceModel(lVar);
        }
    }

    public final void T(E2.h hVar) {
        this.f20936m = hVar;
    }

    public boolean U() {
        return this.f20945v.c() || x();
    }

    public final boolean V() {
        return this.f20944u.isLaidOut() && !this.f20944u.isInEditMode();
    }

    public void W(e eVar, boolean z10) {
        if (z()) {
            return;
        }
        Animator animator = this.f20935l;
        if (animator != null) {
            animator.cancel();
        }
        boolean z11 = this.f20936m == null;
        if (!V()) {
            this.f20944u.b(0, z10);
            this.f20944u.setAlpha(1.0f);
            this.f20944u.setScaleY(1.0f);
            this.f20944u.setScaleX(1.0f);
            N(1.0f);
            if (eVar != null) {
                eVar.a();
                return;
            }
            return;
        }
        if (this.f20944u.getVisibility() != 0) {
            this.f20944u.setAlpha(0.0f);
            this.f20944u.setScaleY(z11 ? 0.4f : 0.0f);
            this.f20944u.setScaleX(z11 ? 0.4f : 0.0f);
            N(z11 ? 0.4f : 0.0f);
        }
        E2.h hVar = this.f20936m;
        AnimatorSet animatorSetI = hVar != null ? i(hVar, 1.0f, 1.0f, 1.0f) : j(1.0f, 1.0f, 1.0f, f20913C, f20914D);
        animatorSetI.addListener(new b(z10, eVar));
        ArrayList<Animator.AnimatorListener> arrayList = this.f20941r;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetI.addListener(it.next());
            }
        }
        animatorSetI.start();
    }

    public final void X() {
        N(this.f20938o);
    }

    public final void Y() {
        Rect rect = this.f20946w;
        r(rect);
        E(rect);
        this.f20945v.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void Z(float f10) {
        h hVar = this.f20925b;
        if (hVar != null) {
            hVar.f0(f10);
        }
    }

    public final void a0(ObjectAnimator objectAnimator) {
    }

    public void e(Animator.AnimatorListener animatorListener) {
        if (this.f20942s == null) {
            this.f20942s = new ArrayList<>();
        }
        this.f20942s.add(animatorListener);
    }

    public void f(Animator.AnimatorListener animatorListener) {
        if (this.f20941r == null) {
            this.f20941r = new ArrayList<>();
        }
        this.f20941r.add(animatorListener);
    }

    public void g(d dVar) {
        if (this.f20943t == null) {
            this.f20943t = new ArrayList<>();
        }
        this.f20943t.add(dVar);
    }

    public final void h(float f10, Matrix matrix) {
        matrix.reset();
        if (this.f20944u.getDrawable() == null || this.f20939p == 0) {
            return;
        }
        RectF rectF = this.f20947x;
        RectF rectF2 = this.f20948y;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i10 = this.f20939p;
        rectF2.set(0.0f, 0.0f, i10, i10);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i11 = this.f20939p;
        matrix.postScale(f10, f10, i11 / 2.0f, i11 / 2.0f);
    }

    public final AnimatorSet i(E2.h hVar, float f10, float f11, float f12) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f20944u, (Property<FloatingActionButton, Float>) View.ALPHA, f10);
        hVar.e("opacity").a(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f20944u, (Property<FloatingActionButton, Float>) View.SCALE_X, f11);
        hVar.e(ConstConfig.KEY_VIEW_SCALE_PROPERTY).a(objectAnimatorOfFloat2);
        a0(objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f20944u, (Property<FloatingActionButton, Float>) View.SCALE_Y, f11);
        hVar.e(ConstConfig.KEY_VIEW_SCALE_PROPERTY).a(objectAnimatorOfFloat3);
        a0(objectAnimatorOfFloat3);
        arrayList.add(objectAnimatorOfFloat3);
        h(f12, this.f20949z);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.f20944u, new f(), new c(), new Matrix(this.f20949z));
        hVar.e("iconScale").a(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        E2.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    public final AnimatorSet j(final float f10, final float f11, final float f12, int i10, int i11) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        final float alpha = this.f20944u.getAlpha();
        final float scaleX = this.f20944u.getScaleX();
        final float scaleY = this.f20944u.getScaleY();
        final float f13 = this.f20938o;
        final Matrix matrix = new Matrix(this.f20949z);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: R2.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                com.google.android.material.floatingactionbutton.a.a(this.f5523a, alpha, f10, scaleX, f11, scaleY, f13, f12, matrix, valueAnimator);
            }
        });
        arrayList.add(valueAnimatorOfFloat);
        E2.b.a(animatorSet, arrayList);
        animatorSet.setDuration(T2.h.f(this.f20944u.getContext(), i10, this.f20944u.getContext().getResources().getInteger(R$integer.material_motion_duration_long_1)));
        animatorSet.setInterpolator(T2.h.g(this.f20944u.getContext(), i11, E2.a.f2340b));
        return animatorSet;
    }

    public final StateListAnimator k(float f10, float f11, float f12) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(f20917G, l(f10, f12));
        stateListAnimator.addState(f20918H, l(f10, f11));
        stateListAnimator.addState(f20919I, l(f10, f11));
        stateListAnimator.addState(f20920J, l(f10, f11));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.f20944u, "elevation", f10).setDuration(0L));
        arrayList.add(ObjectAnimator.ofFloat(this.f20944u, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(f20912B);
        stateListAnimator.addState(f20921K, animatorSet);
        stateListAnimator.addState(f20922L, l(0.0f, 0.0f));
        return stateListAnimator;
    }

    public final Animator l(float f10, float f11) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f20944u, "elevation", f10).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f20944u, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f11).setDuration(100L));
        animatorSet.setInterpolator(f20912B);
        return animatorSet;
    }

    public final Drawable m() {
        return this.f20927d;
    }

    public float n() {
        return this.f20944u.getElevation();
    }

    public boolean o() {
        return this.f20928e;
    }

    public final E2.h p() {
        return this.f20937n;
    }

    public float q() {
        return this.f20931h;
    }

    public void r(Rect rect) {
        if (this.f20945v.c()) {
            int iV = v();
            int iMax = Math.max(iV, (int) Math.ceil(this.f20929f ? n() + this.f20932i : 0.0f));
            int iMax2 = Math.max(iV, (int) Math.ceil(r1 * 1.5f));
            rect.set(iMax, iMax2, iMax, iMax2);
            return;
        }
        if (!x()) {
            rect.set(0, 0, 0, 0);
        } else {
            int sizeDimension = (this.f20933j - this.f20944u.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    public float s() {
        return this.f20932i;
    }

    public final l t() {
        return this.f20924a;
    }

    public final E2.h u() {
        return this.f20936m;
    }

    public int v() {
        if (this.f20928e) {
            return Math.max((this.f20933j - this.f20944u.getSizeDimension()) / 2, 0);
        }
        return 0;
    }

    public void w(e eVar, boolean z10) {
        a aVar;
        AnimatorSet animatorSetJ;
        if (y()) {
            return;
        }
        Animator animator = this.f20935l;
        if (animator != null) {
            animator.cancel();
        }
        if (!V()) {
            this.f20944u.b(z10 ? 8 : 4, z10);
            if (eVar != null) {
                eVar.b();
                return;
            }
            return;
        }
        E2.h hVar = this.f20937n;
        if (hVar != null) {
            animatorSetJ = i(hVar, 0.0f, 0.0f, 0.0f);
            aVar = this;
        } else {
            aVar = this;
            animatorSetJ = aVar.j(0.0f, 0.4f, 0.4f, f20915E, f20916F);
        }
        animatorSetJ.addListener(aVar.new C0233a(z10, eVar));
        ArrayList<Animator.AnimatorListener> arrayList = aVar.f20942s;
        if (arrayList != null) {
            Iterator<Animator.AnimatorListener> it = arrayList.iterator();
            while (it.hasNext()) {
                animatorSetJ.addListener(it.next());
            }
        }
        animatorSetJ.start();
    }

    public final boolean x() {
        return this.f20928e && this.f20944u.getSizeDimension() < this.f20933j;
    }

    public boolean y() {
        return this.f20944u.getVisibility() == 0 ? this.f20940q == 1 : this.f20940q != 2;
    }

    public boolean z() {
        return this.f20944u.getVisibility() != 0 ? this.f20940q == 2 : this.f20940q != 1;
    }
}
