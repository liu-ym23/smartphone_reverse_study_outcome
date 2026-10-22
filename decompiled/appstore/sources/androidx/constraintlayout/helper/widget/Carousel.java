package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.o;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R$styleable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class Carousel extends MotionHelper {
    public int A;
    public int B;
    public float C;
    public int D;
    public int E;
    public int F;
    public Runnable G;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Adapter f1666n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ArrayList f1667o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1668p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1669q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public MotionLayout f1670r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1671s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f1672t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f1673u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1674v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f1675w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1676x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f1677y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f1678z;

    public interface Adapter {
        int count();

        void onNewItem(int r10);

        void populate(View r10, int r11);
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Carousel f1679a;

        /* JADX INFO: renamed from: androidx.constraintlayout.helper.widget.Carousel$a$a, reason: collision with other inner class name */
        public class RunnableC0010a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ float f1680a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f1681b;

            public RunnableC0010a(a r10, float r11) {
                this.f1681b = r10;
                this.f1680a = r11;
            }

            @Override // java.lang.Runnable
            public void run() {
                Carousel.v(this.f1681b.f1679a).h0(5, 1.0f, this.f1680a);
            }
        }

        public a(Carousel r10) {
            this.f1679a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            Carousel.v(this.f1679a).setProgress(0.0f);
            Carousel.w(this.f1679a);
            Carousel.y(this.f1679a).onNewItem(Carousel.x(this.f1679a));
            float r10 = Carousel.v(this.f1679a).getVelocity();
            if (Carousel.z(this.f1679a) == 2) goto L5;
            return;
        L5:
            if (r10 > Carousel.A(this.f1679a)) goto L7;
            return;
        L7:
            if (Carousel.x(this.f1679a) >= (Carousel.y(this.f1679a).count() - 1)) goto L22;
            float r11 = r10 * Carousel.B(this.f1679a);
            if (Carousel.x(this.f1679a) != 0) goto L14;
            if (Carousel.C(this.f1679a) <= Carousel.x(this.f1679a)) goto L14;
            return;
        L14:
            if (Carousel.x(this.f1679a) == (Carousel.y(this.f1679a).count() - 1)) goto L16;
        L18:
            Carousel.v(this.f1679a).post(new RunnableC0010a(this, r11));
            return;
        L16:
            if (Carousel.C(this.f1679a) >= Carousel.x(this.f1679a)) goto L18;
            return;
        }
    }

    public Carousel(Context r10) {
        super(r10);
        this.f1666n = null;
        this.f1667o = new ArrayList();
        this.f1668p = 0;
        this.f1669q = 0;
        this.f1671s = -1;
        this.f1672t = false;
        this.f1673u = -1;
        this.f1674v = -1;
        this.f1675w = -1;
        this.f1676x = -1;
        this.f1677y = 0.9f;
        this.f1678z = 0;
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
        return r10.f1677y;
    }

    public static /* synthetic */ int C(Carousel r10) {
        return r10.f1668p;
    }

    public static /* synthetic */ void u(Carousel r10) {
        r10.F();
    }

    public static /* synthetic */ MotionLayout v(Carousel r10) {
        return r10.f1670r;
    }

    public static /* synthetic */ void w(Carousel r10) {
        r10.G();
    }

    public static /* synthetic */ int x(Carousel r10) {
        return r10.f1669q;
    }

    public static /* synthetic */ Adapter y(Carousel r10) {
        return r10.f1666n;
    }

    public static /* synthetic */ int z(Carousel r10) {
        return r10.B;
    }

    public final boolean D(int r10, boolean r11) {
        if (r10 != (-1)) goto L5;
        return false;
    L5:
        MotionLayout r12 = this.f1670r;
        if (r12 != null) goto L8;
        return false;
    L8:
        o.b r13 = r12.T(r10);
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
        this.f1671s = r12.getResourceId(r15, this.f1671s);
    L35:
        r14 = r14 + 1;
        goto L4
    L9:
        if (r15 != R$styleable.Carousel_carousel_backwardTransition) goto L12;
        this.f1673u = r12.getResourceId(r15, this.f1673u);
        goto L35
    L12:
        if (r15 != R$styleable.Carousel_carousel_forwardTransition) goto L15;
        this.f1674v = r12.getResourceId(r15, this.f1674v);
        goto L35
    L15:
        if (r15 != R$styleable.Carousel_carousel_emptyViewsBehavior) goto L18;
        this.A = r12.getInt(r15, this.A);
        goto L35
    L18:
        if (r15 != R$styleable.Carousel_carousel_previousState) goto L21;
        this.f1675w = r12.getResourceId(r15, this.f1675w);
        goto L35
    L21:
        if (r15 != R$styleable.Carousel_carousel_nextState) goto L24;
        this.f1676x = r12.getResourceId(r15, this.f1676x);
        goto L35
    L24:
        if (r15 != R$styleable.Carousel_carousel_touchUp_dampeningFactor) goto L27;
        this.f1677y = r12.getFloat(r15, this.f1677y);
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
        this.f1672t = r12.getBoolean(r15, this.f1672t);
        goto L35
    L36:
        r12.recycle();
        return;
    }

    public final /* synthetic */ void F() {
        this.f1670r.setTransitionDuration(this.E);
        if (this.D >= this.f1669q) goto L5;
        this.f1670r.m0(this.f1675w, this.E);
        return;
    L5:
        this.f1670r.m0(this.f1676x, this.E);
    }

    public final void G() {
        Adapter r10 = this.f1666n;
        if (r10 != null) goto L6;
        return;
    L6:
        if (this.f1670r != null) goto L9;
        return;
    L9:
        if (r10.count() != 0) goto L11;
        return;
    L11:
        int r11 = this.f1667o.size();
        int r12 = 0;
    L12:
        if (r12 >= r11) goto L46;
        View r13 = (View) this.f1667o.get(r12);
        int r14 = (this.f1669q + r12) - this.f1678z;
        if (this.f1672t == true) goto L16;
        if (r14 >= 0) goto L42;
        I(r13, this.A);
    L45:
        r12 = r12 + 1;
        goto L12
    L42:
        if (r14 < this.f1666n.count()) goto L44;
        I(r13, this.A);
        goto L45
    L44:
        I(r13, 0);
        this.f1666n.populate(r13, r14);
        goto L45
    L16:
        if (r14 >= 0) goto L26;
        int r15 = this.A;
        if (r15 == 4) goto L20;
        I(r13, r15);
    L22:
        if ((r14 % this.f1666n.count()) != 0) goto L24;
        this.f1666n.populate(r13, 0);
        goto L45
    L24:
        Adapter r16 = this.f1666n;
        r16.populate(r13, r16.count() + (r14 % this.f1666n.count()));
        goto L45
    L20:
        I(r13, 0);
        goto L22
    L26:
        if (r14 >= this.f1666n.count()) goto L28;
        I(r13, 0);
        this.f1666n.populate(r13, r14);
        goto L45
    L28:
        if (r14 != this.f1666n.count()) goto L31;
        r14 = 0;
    L33:
        int r17 = this.A;
        if (r17 == 4) goto L36;
        I(r13, r17);
    L37:
        this.f1666n.populate(r13, r14);
        goto L45
    L36:
        I(r13, 0);
        goto L37
    L31:
        if (r14 <= this.f1666n.count()) goto L33;
        r14 = r14 % this.f1666n.count();
        goto L33
    L46:
        int r18 = this.D;
        if (r18 == (-1)) goto L52;
        if (r18 == this.f1669q) goto L52;
        this.f1670r.post(new l.a(this));
    L55:
        if (this.f1673u != (-1)) goto L57;
    L71:
        Log.w("Carousel", "No backward or forward transitions defined for Carousel!");
        return;
    L57:
        if (this.f1674v == (-1)) goto L71;
        if (this.f1672t == false) goto L62;
        return;
    L62:
        int r19 = this.f1666n.count();
        if (this.f1669q != 0) goto L65;
        D(this.f1673u, false);
    L67:
        if (this.f1669q != (r19 - 1)) goto L69;
        D(this.f1674v, false);
        return;
    L69:
        D(this.f1674v, true);
        this.f1670r.setTransition(this.f1674v);
        return;
    L65:
        D(this.f1673u, true);
        this.f1670r.setTransition(this.f1673u);
    L52:
        if (r18 != this.f1669q) goto L55;
        this.D = -1;
        goto L55
    }

    public final boolean H(int r10, View r11, int r12) {
        ConstraintSet r13 = this.f1670r.R(r10);
        if (r13 != null) goto L5;
        return false;
    L5:
        ConstraintSet.a r14 = r13.B(r11.getId());
        if (r14 != null) goto L8;
        return false;
    L8:
        r14.f2275c.f2355c = 1;
        r11.setVisibility(r12);
        return true;
    }

    public final boolean I(View r10, int r11) {
        MotionLayout r12 = this.f1670r;
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
        Adapter r10 = this.f1666n;
        if (r10 != null) goto L5;
        return 0;
    L5:
        return r10.count();
    }

    public int getCurrentIndex() {
        return this.f1669q;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if ((getParent() instanceof MotionLayout) == false) goto L24;
        MotionLayout r10 = (MotionLayout) getParent();
        int r11 = 0;
    L6:
        if (r11 >= this.f2178b) goto L11;
        int r12 = this.f2177a[r11];
        View r13 = r10.getViewById(r12);
        if (this.f1671s != r12) goto L10;
        this.f1678z = r11;
    L10:
        this.f1667o.add(r13);
        r11 = r11 + 1;
        goto L6
    L11:
        this.f1670r = r10;
        if (this.B != 2) goto L19;
        o.b r14 = r10.T(this.f1674v);
        if (r14 == null) goto L16;
        r14.H(5);
    L16:
        o.b r15 = this.f1670r.T(this.f1673u);
        if (r15 == null) goto L19;
        r15.H(5);
    L19:
        G();
        return;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionChange(MotionLayout r10, int r11, int r12, float r13) {
        this.F = r11;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionCompleted(MotionLayout r10, int r11) {
        int r12 = this.f1669q;
        this.f1668p = r12;
        if (r11 != this.f1676x) goto L6;
        this.f1669q = r12 + 1;
    L9:
        if (this.f1672t == false) goto L17;
        if (this.f1669q < this.f1666n.count()) goto L14;
        this.f1669q = 0;
    L14:
        if (this.f1669q >= 0) goto L23;
        this.f1669q = this.f1666n.count() - 1;
    L23:
        if (this.f1668p == this.f1669q) goto L26;
        this.f1670r.post(this.G);
        return;
    L26:
        return;
    L17:
        if (this.f1669q < this.f1666n.count()) goto L20;
        this.f1669q = this.f1666n.count() - 1;
    L20:
        if (this.f1669q >= 0) goto L23;
        this.f1669q = 0;
        goto L23
    L6:
        if (r11 != this.f1675w) goto L9;
        this.f1669q = r12 - 1;
        goto L9
    }

    public void setAdapter(Adapter r10) {
        this.f1666n = r10;
    }

    public Carousel(Context r10, AttributeSet r11) {
        super(r10, r11);
        this.f1666n = null;
        this.f1667o = new ArrayList();
        this.f1668p = 0;
        this.f1669q = 0;
        this.f1671s = -1;
        this.f1672t = false;
        this.f1673u = -1;
        this.f1674v = -1;
        this.f1675w = -1;
        this.f1676x = -1;
        this.f1677y = 0.9f;
        this.f1678z = 0;
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
        this.f1666n = null;
        this.f1667o = new ArrayList();
        this.f1668p = 0;
        this.f1669q = 0;
        this.f1671s = -1;
        this.f1672t = false;
        this.f1673u = -1;
        this.f1674v = -1;
        this.f1675w = -1;
        this.f1676x = -1;
        this.f1677y = 0.9f;
        this.f1678z = 0;
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
