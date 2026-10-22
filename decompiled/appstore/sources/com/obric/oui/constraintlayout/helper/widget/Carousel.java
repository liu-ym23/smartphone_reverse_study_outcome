package com.obric.oui.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.obric.oui.constraintlayout.motion.widget.MotionHelper;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import com.obric.oui.constraintlayout.motion.widget.o;
import com.obric.oui.constraintlayout.widget.R$styleable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public class Carousel extends MotionHelper {
    public int A;
    public int B;
    public float C;
    public int D;
    public int E;
    public int F;
    public Runnable G;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Adapter f13484n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList f13485o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f13486p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f13487q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public MotionLayout f13488r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f13489s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f13490t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f13491u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f13492v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f13493w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f13494x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f13495y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f13496z;

    public interface Adapter {
        int count();

        void onNewItem(int r10);

        void populate(View r10, int r11);
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Carousel f13497a;

        /* JADX INFO: renamed from: com.obric.oui.constraintlayout.helper.widget.Carousel$a$a, reason: collision with other inner class name */
        public class RunnableC0194a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ float f13498a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f13499b;

            public RunnableC0194a(a r10, float r11) {
                this.f13499b = r10;
                this.f13498a = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                Carousel.v(this.f13499b.f13497a).z0(5, 1.0f, this.f13498a);
            }
        }

        public a(Carousel r10) {
            this.f13497a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Carousel.v(this.f13497a).setProgress(0.0f);
            Carousel.w(this.f13497a);
            Carousel.y(this.f13497a).onNewItem(Carousel.x(this.f13497a));
            float r10 = Carousel.v(this.f13497a).getVelocity();
            if (Carousel.z(this.f13497a) == 2) goto L5;
            return;
        L5:
            if (r10 > Carousel.A(this.f13497a)) goto L7;
            return;
        L7:
            if (Carousel.x(this.f13497a) >= (Carousel.y(this.f13497a).count() - 1)) goto L22;
            float r11 = r10 * Carousel.B(this.f13497a);
            if (Carousel.x(this.f13497a) != 0) goto L14;
            if (Carousel.C(this.f13497a) <= Carousel.x(this.f13497a)) goto L14;
            return;
        L14:
            if (Carousel.x(this.f13497a) == (Carousel.y(this.f13497a).count() - 1)) goto L16;
        L18:
            Carousel.v(this.f13497a).post(new RunnableC0194a(this, r11));
            return;
        L16:
            if (Carousel.C(this.f13497a) >= Carousel.x(this.f13497a)) goto L18;
            return;
        }
    }

    public Carousel(Context r10) {
        super(r10);
        this.f13484n = null;
        this.f13485o = new ArrayList();
        this.f13486p = 0;
        this.f13487q = 0;
        this.f13489s = -1;
        this.f13490t = false;
        this.f13491u = -1;
        this.f13492v = -1;
        this.f13493w = -1;
        this.f13494x = -1;
        this.f13495y = 0.9f;
        this.f13496z = 0;
        this.A = 4;
        this.B = 1;
        this.C = 2.0f;
        this.D = -1;
        this.E = 200;
        this.F = -1;
        this.G = new a(this);
    }

    public static /* synthetic */ float A(Carousel r10) {
        return r10.C;
    }

    public static /* synthetic */ float B(Carousel r10) {
        return r10.f13495y;
    }

    public static /* synthetic */ int C(Carousel r10) {
        return r10.f13486p;
    }

    public static /* synthetic */ void u(Carousel r10) {
        r10.F();
    }

    public static /* synthetic */ MotionLayout v(Carousel r10) {
        return r10.f13488r;
    }

    public static /* synthetic */ void w(Carousel r10) {
        r10.G();
    }

    public static /* synthetic */ int x(Carousel r10) {
        return r10.f13487q;
    }

    public static /* synthetic */ Adapter y(Carousel r10) {
        return r10.f13484n;
    }

    public static /* synthetic */ int z(Carousel r10) {
        return r10.B;
    }

    public final boolean D(int r10, boolean r11) {
        if (r10 != (-1)) goto L5;
        return false;
    L5:
        MotionLayout r12 = this.f13488r;
        if (r12 != null) goto L8;
        return false;
    L8:
        o.b r13 = r12.l0(r10);
        if (r13 != null) goto L12;
        return false;
    L12:
        if (r11 != r13.C()) goto L14;
        return false;
    L14:
        r13.F(r11);
        return true;
    }

    public final void E(Context r10, AttributeSet r11) {
        if (r11 == null) goto L50;
        TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.Carousel);
        int r13 = r12.getIndexCount();
        int r14 = 0;
    L4:
        if (r14 >= r13) goto L36;
        int r15 = r12.getIndex(r14);
        if (r15 != R$styleable.Carousel_carousel_firstView) goto L9;
        this.f13489s = r12.getResourceId(r15, this.f13489s);
    L35:
        r14 = r14 + 1;
        goto L4
    L9:
        if (r15 != R$styleable.Carousel_carousel_backwardTransition) goto L12;
        this.f13491u = r12.getResourceId(r15, this.f13491u);
        goto L35
    L12:
        if (r15 != R$styleable.Carousel_carousel_forwardTransition) goto L15;
        this.f13492v = r12.getResourceId(r15, this.f13492v);
        goto L35
    L15:
        if (r15 != R$styleable.Carousel_carousel_emptyViewsBehavior) goto L18;
        this.A = r12.getInt(r15, this.A);
        goto L35
    L18:
        if (r15 != R$styleable.Carousel_carousel_previousState) goto L21;
        this.f13493w = r12.getResourceId(r15, this.f13493w);
        goto L35
    L21:
        if (r15 != R$styleable.Carousel_carousel_nextState) goto L24;
        this.f13494x = r12.getResourceId(r15, this.f13494x);
        goto L35
    L24:
        if (r15 != R$styleable.Carousel_carousel_touchUp_dampeningFactor) goto L27;
        this.f13495y = r12.getFloat(r15, this.f13495y);
        goto L35
    L27:
        if (r15 != R$styleable.Carousel_carousel_touchUpMode) goto L30;
        this.B = r12.getInt(r15, this.B);
        goto L35
    L30:
        if (r15 != R$styleable.Carousel_carousel_touchUp_velocityThreshold) goto L33;
        this.C = r12.getFloat(r15, this.C);
        goto L35
    L33:
        if (r15 != R$styleable.Carousel_carousel_infinite) goto L35;
        this.f13490t = r12.getBoolean(r15, this.f13490t);
        goto L35
    L36:
        r12.recycle();
        return;
    }

    public final /* synthetic */ void F() {
        this.f13488r.setTransitionDuration(this.E);
        if (this.D >= this.f13487q) goto L5;
        this.f13488r.E0(this.f13493w, this.E);
        return;
    L5:
        this.f13488r.E0(this.f13494x, this.E);
    }

    public final void G() {
        Adapter r10 = this.f13484n;
        if (r10 != null) goto L6;
        return;
    L6:
        if (this.f13488r != null) goto L9;
        return;
    L9:
        if (r10.count() != 0) goto L11;
        return;
    L11:
        int r11 = this.f13485o.size();
        int r12 = 0;
    L12:
        if (r12 >= r11) goto L46;
        View r13 = (View) this.f13485o.get(r12);
        int r14 = (this.f13487q + r12) - this.f13496z;
        if (this.f13490t == true) goto L16;
        if (r14 >= 0) goto L42;
        I(r13, this.A);
    L45:
        r12 = r12 + 1;
        goto L12
    L42:
        if (r14 < this.f13484n.count()) goto L44;
        I(r13, this.A);
        goto L45
    L44:
        I(r13, 0);
        this.f13484n.populate(r13, r14);
        goto L45
    L16:
        if (r14 >= 0) goto L26;
        int r15 = this.A;
        if (r15 == 4) goto L20;
        I(r13, r15);
    L22:
        if ((r14 % this.f13484n.count()) != 0) goto L24;
        this.f13484n.populate(r13, 0);
        goto L45
    L24:
        Adapter r16 = this.f13484n;
        r16.populate(r13, r16.count() + (r14 % this.f13484n.count()));
        goto L45
    L20:
        I(r13, 0);
        goto L22
    L26:
        if (r14 >= this.f13484n.count()) goto L28;
        I(r13, 0);
        this.f13484n.populate(r13, r14);
        goto L45
    L28:
        if (r14 != this.f13484n.count()) goto L31;
        r14 = 0;
    L33:
        int r17 = this.A;
        if (r17 == 4) goto L36;
        I(r13, r17);
    L37:
        this.f13484n.populate(r13, r14);
        goto L45
    L36:
        I(r13, 0);
        goto L37
    L31:
        if (r14 <= this.f13484n.count()) goto L33;
        r14 = r14 % this.f13484n.count();
        goto L33
    L46:
        int r18 = this.D;
        if (r18 == (-1)) goto L52;
        if (r18 == this.f13487q) goto L52;
        this.f13488r.post(new xc.a(this));
    L55:
        if (this.f13491u != (-1)) goto L57;
    L71:
        Log.w("Carousel", "No backward or forward transitions defined for Carousel!");
        return;
    L57:
        if (this.f13492v == (-1)) goto L71;
        if (this.f13490t == false) goto L62;
        return;
    L62:
        int r19 = this.f13484n.count();
        if (this.f13487q != 0) goto L65;
        D(this.f13491u, false);
    L67:
        if (this.f13487q != (r19 - 1)) goto L69;
        D(this.f13492v, false);
        return;
    L69:
        D(this.f13492v, true);
        this.f13488r.setTransition(this.f13492v);
        return;
    L65:
        D(this.f13491u, true);
        this.f13488r.setTransition(this.f13491u);
    L52:
        if (r18 != this.f13487q) goto L55;
        this.D = -1;
        goto L55
    }

    public final boolean H(int r10, View r11, int r12) {
        com.obric.oui.constraintlayout.widget.a r13 = this.f13488r.j0(r10);
        if (r13 != null) goto L5;
        return false;
    L5:
        com.obric.oui.constraintlayout.widget.a.C0195a r14 = r13.u(r11.getId());
        if (r14 != null) goto L8;
        return false;
    L8:
        r14.f14174c.f14254c = 1;
        r11.setVisibility(r12);
        return true;
    }

    public final boolean I(View r10, int r11) {
        MotionLayout r12 = this.f13488r;
        int r13 = 0;
        if (r12 != null) goto L5;
        return false;
    L5:
        int[] r14 = r12.getConstraintSetIds();
        boolean r15 = false;
    L7:
        if (r13 >= r14.length) goto L9;
        r15 = r15 | H(r14[r13], r10, r11);
        r13 = r13 + 1;
        goto L7
    L9:
        return r15;
    }

    public int getCount() {
        Adapter r10 = this.f13484n;
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.count();
    }

    public int getCurrentIndex() {
        return this.f13487q;
    }

    @Override // com.obric.oui.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((getParent() instanceof MotionLayout) == false) goto L24;
        MotionLayout r10 = (MotionLayout) getParent();
        this.f13485o.clear();
        int r11 = 0;
    L6:
        if (r11 >= this.f14052b) goto L11;
        int r12 = this.f14051a[r11];
        View r13 = r10.j(r12);
        if (this.f13489s != r12) goto L10;
        this.f13496z = r11;
    L10:
        this.f13485o.add(r13);
        r11 = r11 + 1;
        goto L6
    L11:
        this.f13488r = r10;
        if (this.B != 2) goto L19;
        o.b r14 = r10.l0(this.f13492v);
        if (r14 == null) goto L16;
        r14.H(5);
    L16:
        o.b r15 = this.f13488r.l0(this.f13491u);
        if (r15 == null) goto L19;
        r15.H(5);
    L19:
        G();
        return;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f13485o.clear();
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionHelper, com.obric.oui.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionChange(MotionLayout r10, int r11, int r12, float r13) {
        this.F = r11;
    }

    @Override // com.obric.oui.constraintlayout.motion.widget.MotionHelper, com.obric.oui.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionCompleted(MotionLayout r10, int r11) {
        int r12 = this.f13487q;
        this.f13486p = r12;
        if (r11 != this.f13494x) goto L6;
        this.f13487q = r12 + 1;
    L9:
        if (this.f13490t == false) goto L17;
        if (this.f13487q < this.f13484n.count()) goto L14;
        this.f13487q = 0;
    L14:
        if (this.f13487q >= 0) goto L23;
        this.f13487q = this.f13484n.count() - 1;
    L23:
        if (this.f13486p == this.f13487q) goto L26;
        this.f13488r.post(this.G);
        return;
    L26:
        return;
    L17:
        if (this.f13487q < this.f13484n.count()) goto L20;
        this.f13487q = this.f13484n.count() - 1;
    L20:
        if (this.f13487q >= 0) goto L23;
        this.f13487q = 0;
        goto L23
    L6:
        if (r11 != this.f13493w) goto L9;
        this.f13487q = r12 - 1;
        goto L9
    }

    public void setAdapter(Adapter r10) {
        this.f13484n = r10;
    }

    public void setInfinite(boolean r10) {
        this.f13490t = r10;
    }

    public Carousel(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f13484n = null;
        this.f13485o = new ArrayList();
        this.f13486p = 0;
        this.f13487q = 0;
        this.f13489s = -1;
        this.f13490t = false;
        this.f13491u = -1;
        this.f13492v = -1;
        this.f13493w = -1;
        this.f13494x = -1;
        this.f13495y = 0.9f;
        this.f13496z = 0;
        this.A = 4;
        this.B = 1;
        this.C = 2.0f;
        this.D = -1;
        this.E = 200;
        this.F = -1;
        this.G = new a(this);
        E(r10, r11);
    }

    public Carousel(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        this.f13484n = null;
        this.f13485o = new ArrayList();
        this.f13486p = 0;
        this.f13487q = 0;
        this.f13489s = -1;
        this.f13490t = false;
        this.f13491u = -1;
        this.f13492v = -1;
        this.f13493w = -1;
        this.f13494x = -1;
        this.f13495y = 0.9f;
        this.f13496z = 0;
        this.A = 4;
        this.B = 1;
        this.C = 2.0f;
        this.D = -1;
        this.E = 200;
        this.F = -1;
        this.G = new a(this);
        E(r10, r11);
    }
}
