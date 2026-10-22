package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.dynamicanimation.animation.SpringForce;
import com.stepos.ability.R;
import e3.C1409C;
import e3.InterfaceC1407A;
import e3.InterfaceC1420i;
import e3.k;
import e3.p;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final MaterialButton f2368a;
    public p b;
    public C1409C c;
    public SpringForce d;
    public InterfaceC1420i e;
    public int f;
    public int g;
    public int h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f2369j;
    public int k;
    public PorterDuff.Mode l;
    public ColorStateList m;
    public ColorStateList n;
    public ColorStateList o;
    public k p;

    /* renamed from: t, reason: collision with root package name */
    public boolean f2373t;

    /* renamed from: v, reason: collision with root package name */
    public RippleDrawable f2374v;

    /* renamed from: w, reason: collision with root package name */
    public int f2375w;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2370q = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f2371r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f2372s = false;
    public boolean u = true;

    public e(MaterialButton materialButton, p pVar) {
        this.f2368a = materialButton;
        this.b = pVar;
    }

    public final k a(boolean z10) {
        RippleDrawable rippleDrawable = this.f2374v;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (k) ((LayerDrawable) ((InsetDrawable) this.f2374v.getDrawable(0)).getDrawable()).getDrawable(!z10 ? 1 : 0);
    }

    public final void b(int i, int i6) {
        MaterialButton materialButton = this.f2368a;
        int paddingStart = materialButton.getPaddingStart();
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = materialButton.getPaddingEnd();
        int paddingBottom = materialButton.getPaddingBottom();
        int i10 = this.h;
        int i11 = this.i;
        this.i = i6;
        this.h = i;
        if (!this.f2371r) {
            c();
        }
        materialButton.setPaddingRelative(paddingStart, (paddingTop + i) - i10, paddingEnd, (paddingBottom + i6) - i11);
    }

    public final void c() {
        k kVar = new k(this.b);
        C1409C c1409c = this.c;
        if (c1409c != null) {
            kVar.u(c1409c);
        }
        SpringForce springForce = this.d;
        if (springForce != null) {
            kVar.o(springForce);
        }
        InterfaceC1420i interfaceC1420i = this.e;
        if (interfaceC1420i != null) {
            kVar.E = interfaceC1420i;
        }
        MaterialButton materialButton = this.f2368a;
        kVar.m(materialButton.getContext());
        kVar.setTintList(this.m);
        PorterDuff.Mode mode = this.l;
        if (mode != null) {
            kVar.setTintMode(mode);
        }
        float f = this.k;
        ColorStateList colorStateList = this.n;
        kVar.b.k = f;
        kVar.invalidateSelf();
        kVar.v(colorStateList);
        k kVar2 = new k(this.b);
        C1409C c1409c2 = this.c;
        if (c1409c2 != null) {
            kVar2.u(c1409c2);
        }
        SpringForce springForce2 = this.d;
        if (springForce2 != null) {
            kVar2.o(springForce2);
        }
        kVar2.setTint(0);
        float f7 = this.k;
        int iA = this.f2370q ? W2.a.a(R.attr.colorSurface, materialButton) : 0;
        kVar2.b.k = f7;
        kVar2.invalidateSelf();
        kVar2.v(ColorStateList.valueOf(iA));
        k kVar3 = new k(this.b);
        this.p = kVar3;
        C1409C c1409c3 = this.c;
        if (c1409c3 != null) {
            kVar3.u(c1409c3);
        }
        SpringForce springForce3 = this.d;
        if (springForce3 != null) {
            this.p.o(springForce3);
        }
        this.p.setTint(-1);
        ColorStateList colorStateListValueOf = this.o;
        if (colorStateListValueOf == null) {
            colorStateListValueOf = ColorStateList.valueOf(0);
        }
        RippleDrawable rippleDrawable = new RippleDrawable(colorStateListValueOf, new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{kVar2, kVar}), this.f, this.h, this.g, this.i), this.p);
        this.f2374v = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        k kVarA = a(false);
        if (kVarA != null) {
            kVarA.p(this.f2375w);
            kVarA.setState(materialButton.getDrawableState());
        }
    }

    public final void d() {
        k kVarA = a(false);
        if (kVarA != null) {
            C1409C c1409c = this.c;
            if (c1409c != null) {
                kVarA.u(c1409c);
            } else {
                kVarA.setShapeAppearanceModel(this.b);
            }
            SpringForce springForce = this.d;
            if (springForce != null) {
                kVarA.o(springForce);
            }
        }
        k kVarA2 = a(true);
        if (kVarA2 != null) {
            C1409C c1409c2 = this.c;
            if (c1409c2 != null) {
                kVarA2.u(c1409c2);
            } else {
                kVarA2.setShapeAppearanceModel(this.b);
            }
            SpringForce springForce2 = this.d;
            if (springForce2 != null) {
                kVarA2.o(springForce2);
            }
        }
        RippleDrawable rippleDrawable = this.f2374v;
        InterfaceC1407A interfaceC1407A = (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 1) ? null : this.f2374v.getNumberOfLayers() > 2 ? (InterfaceC1407A) this.f2374v.getDrawable(2) : (InterfaceC1407A) this.f2374v.getDrawable(1);
        if (interfaceC1407A != null) {
            interfaceC1407A.setShapeAppearanceModel(this.b);
            if (interfaceC1407A instanceof k) {
                k kVar = (k) interfaceC1407A;
                C1409C c1409c3 = this.c;
                if (c1409c3 != null) {
                    kVar.u(c1409c3);
                }
                SpringForce springForce3 = this.d;
                if (springForce3 != null) {
                    kVar.o(springForce3);
                }
            }
        }
    }

    public final void e() {
        k kVarA = a(false);
        k kVarA2 = a(true);
        if (kVarA != null) {
            float f = this.k;
            ColorStateList colorStateList = this.n;
            kVarA.b.k = f;
            kVarA.invalidateSelf();
            kVarA.v(colorStateList);
            if (kVarA2 != null) {
                float f7 = this.k;
                int iA = this.f2370q ? W2.a.a(R.attr.colorSurface, this.f2368a) : 0;
                kVarA2.b.k = f7;
                kVarA2.invalidateSelf();
                kVarA2.v(ColorStateList.valueOf(iA));
            }
        }
    }
}
