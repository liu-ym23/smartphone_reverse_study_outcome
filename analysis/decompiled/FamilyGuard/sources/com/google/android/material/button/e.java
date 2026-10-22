package com.google.android.material.button;

import P.j;
import a1.C0409b;
import a1.C0418k;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.google.android.material.internal.r;
import j1.C0777a;
import q1.C0981c;
import r1.C0994a;
import t1.C1115h;
import t1.l;
import t1.o;
import t1.q;

/* loaded from: classes.dex */
class e {

    /* renamed from: a, reason: collision with root package name */
    private final MaterialButton f12445a;

    /* renamed from: b, reason: collision with root package name */
    private l f12446b;

    /* renamed from: c, reason: collision with root package name */
    private q f12447c;

    /* renamed from: d, reason: collision with root package name */
    private j f12448d;

    /* renamed from: e, reason: collision with root package name */
    private C1115h.d f12449e;

    /* renamed from: f, reason: collision with root package name */
    private int f12450f;

    /* renamed from: g, reason: collision with root package name */
    private int f12451g;

    /* renamed from: h, reason: collision with root package name */
    private int f12452h;

    /* renamed from: i, reason: collision with root package name */
    private int f12453i;

    /* renamed from: j, reason: collision with root package name */
    private int f12454j;

    /* renamed from: k, reason: collision with root package name */
    private int f12455k;

    /* renamed from: l, reason: collision with root package name */
    private PorterDuff.Mode f12456l;

    /* renamed from: m, reason: collision with root package name */
    private ColorStateList f12457m;

    /* renamed from: n, reason: collision with root package name */
    private ColorStateList f12458n;

    /* renamed from: o, reason: collision with root package name */
    private ColorStateList f12459o;

    /* renamed from: p, reason: collision with root package name */
    private Drawable f12460p;

    /* renamed from: t, reason: collision with root package name */
    private boolean f12464t;

    /* renamed from: v, reason: collision with root package name */
    private LayerDrawable f12466v;

    /* renamed from: w, reason: collision with root package name */
    private int f12467w;

    /* renamed from: q, reason: collision with root package name */
    private boolean f12461q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f12462r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f12463s = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f12465u = true;

    e(MaterialButton materialButton, l lVar) {
        this.f12445a = materialButton;
        this.f12446b = lVar;
    }

    private void L(int i5, int i6) {
        int paddingStart = this.f12445a.getPaddingStart();
        int paddingTop = this.f12445a.getPaddingTop();
        int paddingEnd = this.f12445a.getPaddingEnd();
        int paddingBottom = this.f12445a.getPaddingBottom();
        int i7 = this.f12452h;
        int i8 = this.f12453i;
        this.f12453i = i6;
        this.f12452h = i5;
        if (!this.f12462r) {
            M();
        }
        this.f12445a.setPaddingRelative(paddingStart, (paddingTop + i5) - i7, paddingEnd, (paddingBottom + i6) - i8);
    }

    private void M() {
        this.f12445a.setInternalBackground(a());
        C1115h c1115hG = g();
        if (c1115hG != null) {
            c1115hG.f0(this.f12467w);
            c1115hG.setState(this.f12445a.getDrawableState());
        }
    }

    private void N() {
        C1115h c1115hG = g();
        if (c1115hG != null) {
            q qVar = this.f12447c;
            if (qVar != null) {
                c1115hG.l0(qVar);
            } else {
                c1115hG.setShapeAppearanceModel(this.f12446b);
            }
            j jVar = this.f12448d;
            if (jVar != null) {
                c1115hG.e0(jVar);
            }
        }
        C1115h c1115hP = p();
        if (c1115hP != null) {
            q qVar2 = this.f12447c;
            if (qVar2 != null) {
                c1115hP.l0(qVar2);
            } else {
                c1115hP.setShapeAppearanceModel(this.f12446b);
            }
            j jVar2 = this.f12448d;
            if (jVar2 != null) {
                c1115hP.e0(jVar2);
            }
        }
        o oVarF = f();
        if (oVarF != null) {
            oVarF.setShapeAppearanceModel(this.f12446b);
            if (oVarF instanceof C1115h) {
                C1115h c1115h = (C1115h) oVarF;
                q qVar3 = this.f12447c;
                if (qVar3 != null) {
                    c1115h.l0(qVar3);
                }
                j jVar3 = this.f12448d;
                if (jVar3 != null) {
                    c1115h.e0(jVar3);
                }
            }
        }
    }

    private void O() {
        C1115h c1115hG = g();
        C1115h c1115hP = p();
        if (c1115hG != null) {
            c1115hG.n0(this.f12455k, this.f12458n);
            if (c1115hP != null) {
                c1115hP.m0(this.f12455k, this.f12461q ? C0777a.d(this.f12445a, C0409b.f6720g) : 0);
            }
        }
    }

    private InsetDrawable P(Drawable drawable) {
        return new InsetDrawable(drawable, this.f12450f, this.f12452h, this.f12451g, this.f12453i);
    }

    private Drawable a() {
        C1115h c1115h = new C1115h(this.f12446b);
        q qVar = this.f12447c;
        if (qVar != null) {
            c1115h.l0(qVar);
        }
        j jVar = this.f12448d;
        if (jVar != null) {
            c1115h.e0(jVar);
        }
        C1115h.d dVar = this.f12449e;
        if (dVar != null) {
            c1115h.i0(dVar);
        }
        c1115h.U(this.f12445a.getContext());
        c1115h.setTintList(this.f12457m);
        PorterDuff.Mode mode = this.f12456l;
        if (mode != null) {
            c1115h.setTintMode(mode);
        }
        c1115h.n0(this.f12455k, this.f12458n);
        C1115h c1115h2 = new C1115h(this.f12446b);
        q qVar2 = this.f12447c;
        if (qVar2 != null) {
            c1115h2.l0(qVar2);
        }
        j jVar2 = this.f12448d;
        if (jVar2 != null) {
            c1115h2.e0(jVar2);
        }
        c1115h2.setTint(0);
        c1115h2.m0(this.f12455k, this.f12461q ? C0777a.d(this.f12445a, C0409b.f6720g) : 0);
        C1115h c1115h3 = new C1115h(this.f12446b);
        this.f12460p = c1115h3;
        q qVar3 = this.f12447c;
        if (qVar3 != null) {
            c1115h3.l0(qVar3);
        }
        j jVar3 = this.f12448d;
        if (jVar3 != null) {
            ((C1115h) this.f12460p).e0(jVar3);
        }
        this.f12460p.setTint(-1);
        RippleDrawable rippleDrawable = new RippleDrawable(C0994a.a(this.f12459o), P(new LayerDrawable(new Drawable[]{c1115h2, c1115h})), this.f12460p);
        this.f12466v = rippleDrawable;
        return rippleDrawable;
    }

    private C1115h h(boolean z5) {
        LayerDrawable layerDrawable = this.f12466v;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (C1115h) ((LayerDrawable) ((InsetDrawable) this.f12466v.getDrawable(0)).getDrawable()).getDrawable(!z5 ? 1 : 0);
    }

    private C1115h p() {
        return h(true);
    }

    public void A(int i5) {
        L(this.f12452h, i5);
    }

    public void B(int i5) {
        L(i5, this.f12453i);
    }

    void C(ColorStateList colorStateList) {
        if (this.f12459o != colorStateList) {
            this.f12459o = colorStateList;
            if (this.f12445a.getBackground() instanceof RippleDrawable) {
                ((RippleDrawable) this.f12445a.getBackground()).setColor(C0994a.a(colorStateList));
            }
        }
    }

    void D(l lVar) {
        this.f12446b = lVar;
        this.f12447c = null;
        N();
    }

    void E(boolean z5) {
        this.f12461q = z5;
        O();
    }

    void F(q qVar) {
        this.f12447c = qVar;
        N();
    }

    void G(ColorStateList colorStateList) {
        if (this.f12458n != colorStateList) {
            this.f12458n = colorStateList;
            O();
        }
    }

    void H(int i5) {
        if (this.f12455k != i5) {
            this.f12455k = i5;
            O();
        }
    }

    void I(ColorStateList colorStateList) {
        if (this.f12457m != colorStateList) {
            this.f12457m = colorStateList;
            if (g() != null) {
                g().setTintList(this.f12457m);
            }
        }
    }

    void J(PorterDuff.Mode mode) {
        if (this.f12456l != mode) {
            this.f12456l = mode;
            if (g() == null || this.f12456l == null) {
                return;
            }
            g().setTintMode(this.f12456l);
        }
    }

    void K(boolean z5) {
        this.f12465u = z5;
    }

    int b() {
        return this.f12454j;
    }

    j c() {
        return this.f12448d;
    }

    public int d() {
        return this.f12453i;
    }

    public int e() {
        return this.f12452h;
    }

    public o f() {
        LayerDrawable layerDrawable = this.f12466v;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.f12466v.getNumberOfLayers() > 2 ? (o) this.f12466v.getDrawable(2) : (o) this.f12466v.getDrawable(1);
    }

    C1115h g() {
        return h(false);
    }

    ColorStateList i() {
        return this.f12459o;
    }

    l j() {
        return this.f12446b;
    }

    q k() {
        return this.f12447c;
    }

    ColorStateList l() {
        return this.f12458n;
    }

    int m() {
        return this.f12455k;
    }

    ColorStateList n() {
        return this.f12457m;
    }

    PorterDuff.Mode o() {
        return this.f12456l;
    }

    boolean q() {
        return this.f12462r;
    }

    boolean r() {
        return this.f12464t;
    }

    boolean s() {
        return this.f12465u;
    }

    void t(TypedArray typedArray) {
        this.f12450f = typedArray.getDimensionPixelOffset(C0418k.f7033Q1, 0);
        this.f12451g = typedArray.getDimensionPixelOffset(C0418k.f7039R1, 0);
        this.f12452h = typedArray.getDimensionPixelOffset(C0418k.f7045S1, 0);
        this.f12453i = typedArray.getDimensionPixelOffset(C0418k.f7051T1, 0);
        int i5 = C0418k.f7075X1;
        if (typedArray.hasValue(i5)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i5, -1);
            this.f12454j = dimensionPixelSize;
            D(this.f12446b.x(dimensionPixelSize));
            this.f12463s = true;
        }
        this.f12455k = typedArray.getDimensionPixelSize(C0418k.f7153j2, 0);
        this.f12456l = r.h(typedArray.getInt(C0418k.f7069W1, -1), PorterDuff.Mode.SRC_IN);
        this.f12457m = C0981c.a(this.f12445a.getContext(), typedArray, C0418k.f7063V1);
        this.f12458n = C0981c.a(this.f12445a.getContext(), typedArray, C0418k.f7147i2);
        this.f12459o = C0981c.a(this.f12445a.getContext(), typedArray, C0418k.f7135g2);
        this.f12464t = typedArray.getBoolean(C0418k.f7057U1, false);
        this.f12467w = typedArray.getDimensionPixelSize(C0418k.f7081Y1, 0);
        this.f12465u = typedArray.getBoolean(C0418k.f7159k2, true);
        int paddingStart = this.f12445a.getPaddingStart();
        int paddingTop = this.f12445a.getPaddingTop();
        int paddingEnd = this.f12445a.getPaddingEnd();
        int paddingBottom = this.f12445a.getPaddingBottom();
        if (typedArray.hasValue(C0418k.f7021O1)) {
            v();
        } else {
            M();
        }
        this.f12445a.setPaddingRelative(paddingStart + this.f12450f, paddingTop + this.f12452h, paddingEnd + this.f12451g, paddingBottom + this.f12453i);
    }

    void u(int i5) {
        if (g() != null) {
            g().setTint(i5);
        }
    }

    void v() {
        this.f12462r = true;
        this.f12445a.setSupportBackgroundTintList(this.f12457m);
        this.f12445a.setSupportBackgroundTintMode(this.f12456l);
    }

    void w(boolean z5) {
        this.f12464t = z5;
    }

    void x(int i5) {
        if (this.f12463s && this.f12454j == i5) {
            return;
        }
        this.f12454j = i5;
        this.f12463s = true;
        D(this.f12446b.x(i5));
    }

    void y(C1115h.d dVar) {
        this.f12449e = dVar;
        C1115h c1115hG = g();
        if (c1115hG != null) {
            c1115hG.i0(dVar);
        }
    }

    void z(j jVar) {
        this.f12448d = jVar;
        if (this.f12447c != null) {
            N();
        }
    }
}
