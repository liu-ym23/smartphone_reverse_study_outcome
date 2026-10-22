package com.google.android.material.button;

import Z2.h;
import Z2.l;
import Z2.o;
import Z2.s;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.dynamicanimation.animation.j;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.u;

/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final MaterialButton f20508a;

    /* renamed from: b, reason: collision with root package name */
    public l f20509b;

    /* renamed from: c, reason: collision with root package name */
    public s f20510c;

    /* renamed from: d, reason: collision with root package name */
    public j f20511d;

    /* renamed from: e, reason: collision with root package name */
    public h.d f20512e;

    /* renamed from: f, reason: collision with root package name */
    public int f20513f;

    /* renamed from: g, reason: collision with root package name */
    public int f20514g;

    /* renamed from: h, reason: collision with root package name */
    public int f20515h;

    /* renamed from: i, reason: collision with root package name */
    public int f20516i;

    /* renamed from: j, reason: collision with root package name */
    public int f20517j;

    /* renamed from: k, reason: collision with root package name */
    public int f20518k;

    /* renamed from: l, reason: collision with root package name */
    public PorterDuff.Mode f20519l;

    /* renamed from: m, reason: collision with root package name */
    public ColorStateList f20520m;

    /* renamed from: n, reason: collision with root package name */
    public ColorStateList f20521n;

    /* renamed from: o, reason: collision with root package name */
    public ColorStateList f20522o;

    /* renamed from: p, reason: collision with root package name */
    public Drawable f20523p;

    /* renamed from: t, reason: collision with root package name */
    public boolean f20527t;

    /* renamed from: v, reason: collision with root package name */
    public LayerDrawable f20529v;

    /* renamed from: w, reason: collision with root package name */
    public int f20530w;

    /* renamed from: q, reason: collision with root package name */
    public boolean f20524q = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f20525r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f20526s = false;

    /* renamed from: u, reason: collision with root package name */
    public boolean f20528u = true;

    public e(MaterialButton materialButton, l lVar) {
        this.f20508a = materialButton;
        this.f20509b = lVar;
    }

    public void A(int i10) {
        L(this.f20515h, i10);
    }

    public void B(int i10) {
        L(i10, this.f20516i);
    }

    public void C(ColorStateList colorStateList) {
        if (this.f20522o != colorStateList) {
            this.f20522o = colorStateList;
            if (this.f20508a.getBackground() instanceof RippleDrawable) {
                ((RippleDrawable) this.f20508a.getBackground()).setColor(X2.a.d(colorStateList));
            }
        }
    }

    public void D(l lVar) {
        this.f20509b = lVar;
        this.f20510c = null;
        N();
    }

    public void E(boolean z10) {
        this.f20524q = z10;
        O();
    }

    public void F(s sVar) {
        this.f20510c = sVar;
        N();
    }

    public void G(ColorStateList colorStateList) {
        if (this.f20521n != colorStateList) {
            this.f20521n = colorStateList;
            O();
        }
    }

    public void H(int i10) {
        if (this.f20518k != i10) {
            this.f20518k = i10;
            O();
        }
    }

    public void I(ColorStateList colorStateList) {
        if (this.f20520m != colorStateList) {
            this.f20520m = colorStateList;
            if (g() != null) {
                g().setTintList(this.f20520m);
            }
        }
    }

    public void J(PorterDuff.Mode mode) {
        if (this.f20519l != mode) {
            this.f20519l = mode;
            if (g() == null || this.f20519l == null) {
                return;
            }
            g().setTintMode(this.f20519l);
        }
    }

    public void K(boolean z10) {
        this.f20528u = z10;
    }

    public final void L(int i10, int i11) {
        int paddingStart = this.f20508a.getPaddingStart();
        int paddingTop = this.f20508a.getPaddingTop();
        int paddingEnd = this.f20508a.getPaddingEnd();
        int paddingBottom = this.f20508a.getPaddingBottom();
        int i12 = this.f20515h;
        int i13 = this.f20516i;
        this.f20516i = i11;
        this.f20515h = i10;
        if (!this.f20525r) {
            M();
        }
        this.f20508a.setPaddingRelative(paddingStart, (paddingTop + i10) - i12, paddingEnd, (paddingBottom + i11) - i13);
    }

    public final void M() {
        this.f20508a.setInternalBackground(a());
        h hVarG = g();
        if (hVarG != null) {
            hVarG.f0(this.f20530w);
            hVarG.setState(this.f20508a.getDrawableState());
        }
    }

    public final void N() {
        h hVarG = g();
        if (hVarG != null) {
            s sVar = this.f20510c;
            if (sVar != null) {
                hVarG.l0(sVar);
            } else {
                hVarG.setShapeAppearanceModel(this.f20509b);
            }
            j jVar = this.f20511d;
            if (jVar != null) {
                hVarG.e0(jVar);
            }
        }
        h hVarP = p();
        if (hVarP != null) {
            s sVar2 = this.f20510c;
            if (sVar2 != null) {
                hVarP.l0(sVar2);
            } else {
                hVarP.setShapeAppearanceModel(this.f20509b);
            }
            j jVar2 = this.f20511d;
            if (jVar2 != null) {
                hVarP.e0(jVar2);
            }
        }
        o oVarF = f();
        if (oVarF != null) {
            oVarF.setShapeAppearanceModel(this.f20509b);
            if (oVarF instanceof h) {
                h hVar = (h) oVarF;
                s sVar3 = this.f20510c;
                if (sVar3 != null) {
                    hVar.l0(sVar3);
                }
                j jVar3 = this.f20511d;
                if (jVar3 != null) {
                    hVar.e0(jVar3);
                }
            }
        }
    }

    public final void O() {
        h hVarG = g();
        h hVarP = p();
        if (hVarG != null) {
            hVarG.n0(this.f20518k, this.f20521n);
            if (hVarP != null) {
                hVarP.m0(this.f20518k, this.f20524q ? M2.a.d(this.f20508a, R$attr.colorSurface) : 0);
            }
        }
    }

    public final InsetDrawable P(Drawable drawable) {
        return new InsetDrawable(drawable, this.f20513f, this.f20515h, this.f20514g, this.f20516i);
    }

    public final Drawable a() {
        h hVar = new h(this.f20509b);
        s sVar = this.f20510c;
        if (sVar != null) {
            hVar.l0(sVar);
        }
        j jVar = this.f20511d;
        if (jVar != null) {
            hVar.e0(jVar);
        }
        h.d dVar = this.f20512e;
        if (dVar != null) {
            hVar.i0(dVar);
        }
        hVar.U(this.f20508a.getContext());
        hVar.setTintList(this.f20520m);
        PorterDuff.Mode mode = this.f20519l;
        if (mode != null) {
            hVar.setTintMode(mode);
        }
        hVar.n0(this.f20518k, this.f20521n);
        h hVar2 = new h(this.f20509b);
        s sVar2 = this.f20510c;
        if (sVar2 != null) {
            hVar2.l0(sVar2);
        }
        j jVar2 = this.f20511d;
        if (jVar2 != null) {
            hVar2.e0(jVar2);
        }
        hVar2.setTint(0);
        hVar2.m0(this.f20518k, this.f20524q ? M2.a.d(this.f20508a, R$attr.colorSurface) : 0);
        h hVar3 = new h(this.f20509b);
        this.f20523p = hVar3;
        s sVar3 = this.f20510c;
        if (sVar3 != null) {
            hVar3.l0(sVar3);
        }
        j jVar3 = this.f20511d;
        if (jVar3 != null) {
            ((h) this.f20523p).e0(jVar3);
        }
        this.f20523p.setTint(-1);
        RippleDrawable rippleDrawable = new RippleDrawable(X2.a.d(this.f20522o), P(new LayerDrawable(new Drawable[]{hVar2, hVar})), this.f20523p);
        this.f20529v = rippleDrawable;
        return rippleDrawable;
    }

    public int b() {
        return this.f20517j;
    }

    public j c() {
        return this.f20511d;
    }

    public int d() {
        return this.f20516i;
    }

    public int e() {
        return this.f20515h;
    }

    public o f() {
        LayerDrawable layerDrawable = this.f20529v;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return this.f20529v.getNumberOfLayers() > 2 ? (o) this.f20529v.getDrawable(2) : (o) this.f20529v.getDrawable(1);
    }

    public h g() {
        return h(false);
    }

    public final h h(boolean z10) {
        LayerDrawable layerDrawable = this.f20529v;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (h) ((LayerDrawable) ((InsetDrawable) this.f20529v.getDrawable(0)).getDrawable()).getDrawable(!z10 ? 1 : 0);
    }

    public ColorStateList i() {
        return this.f20522o;
    }

    public l j() {
        return this.f20509b;
    }

    public s k() {
        return this.f20510c;
    }

    public ColorStateList l() {
        return this.f20521n;
    }

    public int m() {
        return this.f20518k;
    }

    public ColorStateList n() {
        return this.f20520m;
    }

    public PorterDuff.Mode o() {
        return this.f20519l;
    }

    public final h p() {
        return h(true);
    }

    public boolean q() {
        return this.f20525r;
    }

    public boolean r() {
        return this.f20527t;
    }

    public boolean s() {
        return this.f20528u;
    }

    public void t(TypedArray typedArray) {
        this.f20513f = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetLeft, 0);
        this.f20514g = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetRight, 0);
        this.f20515h = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetTop, 0);
        this.f20516i = typedArray.getDimensionPixelOffset(R$styleable.MaterialButton_android_insetBottom, 0);
        int i10 = R$styleable.MaterialButton_cornerRadius;
        if (typedArray.hasValue(i10)) {
            int dimensionPixelSize = typedArray.getDimensionPixelSize(i10, -1);
            this.f20517j = dimensionPixelSize;
            D(this.f20509b.x(dimensionPixelSize));
            this.f20526s = true;
        }
        this.f20518k = typedArray.getDimensionPixelSize(R$styleable.MaterialButton_strokeWidth, 0);
        this.f20519l = u.i(typedArray.getInt(R$styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f20520m = W2.c.a(this.f20508a.getContext(), typedArray, R$styleable.MaterialButton_backgroundTint);
        this.f20521n = W2.c.a(this.f20508a.getContext(), typedArray, R$styleable.MaterialButton_strokeColor);
        this.f20522o = W2.c.a(this.f20508a.getContext(), typedArray, R$styleable.MaterialButton_rippleColor);
        this.f20527t = typedArray.getBoolean(R$styleable.MaterialButton_android_checkable, false);
        this.f20530w = typedArray.getDimensionPixelSize(R$styleable.MaterialButton_elevation, 0);
        this.f20528u = typedArray.getBoolean(R$styleable.MaterialButton_toggleCheckedStateOnClick, true);
        int paddingStart = this.f20508a.getPaddingStart();
        int paddingTop = this.f20508a.getPaddingTop();
        int paddingEnd = this.f20508a.getPaddingEnd();
        int paddingBottom = this.f20508a.getPaddingBottom();
        if (typedArray.hasValue(R$styleable.MaterialButton_android_background)) {
            v();
        } else {
            M();
        }
        this.f20508a.setPaddingRelative(paddingStart + this.f20513f, paddingTop + this.f20515h, paddingEnd + this.f20514g, paddingBottom + this.f20516i);
    }

    public void u(int i10) {
        if (g() != null) {
            g().setTint(i10);
        }
    }

    public void v() {
        this.f20525r = true;
        this.f20508a.setSupportBackgroundTintList(this.f20520m);
        this.f20508a.setSupportBackgroundTintMode(this.f20519l);
    }

    public void w(boolean z10) {
        this.f20527t = z10;
    }

    public void x(int i10) {
        if (this.f20526s && this.f20517j == i10) {
            return;
        }
        this.f20517j = i10;
        this.f20526s = true;
        D(this.f20509b.x(i10));
    }

    public void y(h.d dVar) {
        this.f20512e = dVar;
        h hVarG = g();
        if (hVarG != null) {
            hVarG.i0(dVar);
        }
    }

    public void z(j jVar) {
        this.f20511d = jVar;
        if (this.f20510c != null) {
            N();
        }
    }
}
