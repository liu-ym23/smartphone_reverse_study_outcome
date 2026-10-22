package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.stepos.aiengine.R;
import h1.g;
import y4.g;
import y4.j;
import y4.n;
import y4.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final MaterialButton f4774a;

    /* renamed from: b, reason: collision with root package name */
    public j f4775b;

    /* renamed from: c, reason: collision with root package name */
    public p f4776c;

    /* renamed from: d, reason: collision with root package name */
    public g f4777d;

    /* renamed from: e, reason: collision with root package name */
    public g.d f4778e;

    /* renamed from: f, reason: collision with root package name */
    public int f4779f;

    /* renamed from: g, reason: collision with root package name */
    public int f4780g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f4781i;

    /* renamed from: j, reason: collision with root package name */
    public int f4782j;

    /* renamed from: k, reason: collision with root package name */
    public int f4783k;

    /* renamed from: l, reason: collision with root package name */
    public PorterDuff.Mode f4784l;

    /* renamed from: m, reason: collision with root package name */
    public ColorStateList f4785m;

    /* renamed from: n, reason: collision with root package name */
    public ColorStateList f4786n;

    /* renamed from: o, reason: collision with root package name */
    public ColorStateList f4787o;

    /* renamed from: p, reason: collision with root package name */
    public y4.g f4788p;

    /* renamed from: t, reason: collision with root package name */
    public boolean f4791t;

    /* renamed from: v, reason: collision with root package name */
    public RippleDrawable f4793v;

    /* renamed from: w, reason: collision with root package name */
    public int f4794w;

    /* renamed from: q, reason: collision with root package name */
    public boolean f4789q = false;
    public boolean r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f4790s = false;

    /* renamed from: u, reason: collision with root package name */
    public boolean f4792u = true;

    public d(MaterialButton materialButton, j jVar) {
        this.f4774a = materialButton;
        this.f4775b = jVar;
    }

    public final y4.g a(boolean z) {
        RippleDrawable rippleDrawable = this.f4793v;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (y4.g) ((LayerDrawable) ((InsetDrawable) this.f4793v.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
    }

    public final void b(int i10, int i11) {
        MaterialButton materialButton = this.f4774a;
        int paddingStart = materialButton.getPaddingStart();
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = materialButton.getPaddingEnd();
        int paddingBottom = materialButton.getPaddingBottom();
        int i12 = this.h;
        int i13 = this.f4781i;
        this.f4781i = i11;
        this.h = i10;
        if (!this.r) {
            c();
        }
        materialButton.setPaddingRelative(paddingStart, (paddingTop + i10) - i12, paddingEnd, (paddingBottom + i11) - i13);
    }

    public final void c() {
        y4.g gVar = new y4.g(this.f4775b);
        p pVar = this.f4776c;
        if (pVar != null) {
            gVar.o(pVar);
        }
        h1.g gVar2 = this.f4777d;
        if (gVar2 != null) {
            gVar.l(gVar2);
        }
        g.d dVar = this.f4778e;
        if (dVar != null) {
            gVar.F = dVar;
        }
        MaterialButton materialButton = this.f4774a;
        gVar.k(materialButton.getContext());
        gVar.setTintList(this.f4785m);
        PorterDuff.Mode mode = this.f4784l;
        if (mode != null) {
            gVar.setTintMode(mode);
        }
        float f8 = this.f4783k;
        ColorStateList colorStateList = this.f4786n;
        gVar.f14023b.f14053k = f8;
        gVar.invalidateSelf();
        g.c cVar = gVar.f14023b;
        if (cVar.f14048e != colorStateList) {
            cVar.f14048e = colorStateList;
            gVar.onStateChange(gVar.getState());
        }
        y4.g gVar3 = new y4.g(this.f4775b);
        p pVar2 = this.f4776c;
        if (pVar2 != null) {
            gVar3.o(pVar2);
        }
        h1.g gVar4 = this.f4777d;
        if (gVar4 != null) {
            gVar3.l(gVar4);
        }
        gVar3.setTint(0);
        float f9 = this.f4783k;
        int iS = this.f4789q ? jd.b.s(R.attr.colorSurface, materialButton) : 0;
        gVar3.f14023b.f14053k = f9;
        gVar3.invalidateSelf();
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(iS);
        g.c cVar2 = gVar3.f14023b;
        if (cVar2.f14048e != colorStateListValueOf) {
            cVar2.f14048e = colorStateListValueOf;
            gVar3.onStateChange(gVar3.getState());
        }
        y4.g gVar5 = new y4.g(this.f4775b);
        this.f4788p = gVar5;
        p pVar3 = this.f4776c;
        if (pVar3 != null) {
            gVar5.o(pVar3);
        }
        h1.g gVar6 = this.f4777d;
        if (gVar6 != null) {
            this.f4788p.l(gVar6);
        }
        this.f4788p.setTint(-1);
        ColorStateList colorStateListValueOf2 = this.f4787o;
        if (colorStateListValueOf2 == null) {
            colorStateListValueOf2 = ColorStateList.valueOf(0);
        }
        RippleDrawable rippleDrawable = new RippleDrawable(colorStateListValueOf2, new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{gVar3, gVar}), this.f4779f, this.h, this.f4780g, this.f4781i), this.f4788p);
        this.f4793v = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        y4.g gVarA = a(false);
        if (gVarA != null) {
            gVarA.m(this.f4794w);
            gVarA.setState(materialButton.getDrawableState());
        }
    }

    public final void d() {
        y4.g gVarA = a(false);
        if (gVarA != null) {
            p pVar = this.f4776c;
            if (pVar != null) {
                gVarA.o(pVar);
            } else {
                gVarA.setShapeAppearanceModel(this.f4775b);
            }
            h1.g gVar = this.f4777d;
            if (gVar != null) {
                gVarA.l(gVar);
            }
        }
        y4.g gVarA2 = a(true);
        if (gVarA2 != null) {
            p pVar2 = this.f4776c;
            if (pVar2 != null) {
                gVarA2.o(pVar2);
            } else {
                gVarA2.setShapeAppearanceModel(this.f4775b);
            }
            h1.g gVar2 = this.f4777d;
            if (gVar2 != null) {
                gVarA2.l(gVar2);
            }
        }
        RippleDrawable rippleDrawable = this.f4793v;
        n nVar = (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 1) ? null : this.f4793v.getNumberOfLayers() > 2 ? (n) this.f4793v.getDrawable(2) : (n) this.f4793v.getDrawable(1);
        if (nVar != null) {
            nVar.setShapeAppearanceModel(this.f4775b);
            if (nVar instanceof y4.g) {
                y4.g gVar3 = (y4.g) nVar;
                p pVar3 = this.f4776c;
                if (pVar3 != null) {
                    gVar3.o(pVar3);
                }
                h1.g gVar4 = this.f4777d;
                if (gVar4 != null) {
                    gVar3.l(gVar4);
                }
            }
        }
    }

    public final void e() {
        y4.g gVarA = a(false);
        y4.g gVarA2 = a(true);
        if (gVarA != null) {
            float f8 = this.f4783k;
            ColorStateList colorStateList = this.f4786n;
            gVarA.f14023b.f14053k = f8;
            gVarA.invalidateSelf();
            g.c cVar = gVarA.f14023b;
            if (cVar.f14048e != colorStateList) {
                cVar.f14048e = colorStateList;
                gVarA.onStateChange(gVarA.getState());
            }
            if (gVarA2 != null) {
                float f9 = this.f4783k;
                int iS = this.f4789q ? jd.b.s(R.attr.colorSurface, this.f4774a) : 0;
                gVarA2.f14023b.f14053k = f9;
                gVarA2.invalidateSelf();
                ColorStateList colorStateListValueOf = ColorStateList.valueOf(iS);
                g.c cVar2 = gVarA2.f14023b;
                if (cVar2.f14048e != colorStateListValueOf) {
                    cVar2.f14048e = colorStateListValueOf;
                    gVarA2.onStateChange(gVarA2.getState());
                }
            }
        }
    }
}
