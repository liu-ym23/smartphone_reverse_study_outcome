package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import androidx.core.app.f;
import com.stepos.alphame.R;
import f1.AbstractC0557a;
import y1.B;
import y1.h;
import y1.j;
import y1.n;
import y1.y;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final MaterialButton f10518a;

    /* renamed from: b, reason: collision with root package name */
    public n f10519b;

    /* renamed from: c, reason: collision with root package name */
    public B f10520c;

    /* renamed from: d, reason: collision with root package name */
    public W.n f10521d;

    /* renamed from: e, reason: collision with root package name */
    public f f10522e;

    /* renamed from: f, reason: collision with root package name */
    public int f10523f;

    /* renamed from: g, reason: collision with root package name */
    public int f10524g;

    /* renamed from: h, reason: collision with root package name */
    public int f10525h;

    /* renamed from: i, reason: collision with root package name */
    public int f10526i;

    /* renamed from: j, reason: collision with root package name */
    public int f10527j;

    /* renamed from: k, reason: collision with root package name */
    public int f10528k;

    /* renamed from: l, reason: collision with root package name */
    public PorterDuff.Mode f10529l;

    /* renamed from: m, reason: collision with root package name */
    public ColorStateList f10530m;

    /* renamed from: n, reason: collision with root package name */
    public ColorStateList f10531n;

    /* renamed from: o, reason: collision with root package name */
    public ColorStateList f10532o;

    /* renamed from: p, reason: collision with root package name */
    public j f10533p;

    /* renamed from: t, reason: collision with root package name */
    public boolean f10537t;

    /* renamed from: v, reason: collision with root package name */
    public RippleDrawable f10539v;

    /* renamed from: w, reason: collision with root package name */
    public int f10540w;

    /* renamed from: q, reason: collision with root package name */
    public boolean f10534q = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f10535r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f10536s = false;

    /* renamed from: u, reason: collision with root package name */
    public boolean f10538u = true;

    public e(MaterialButton materialButton, n nVar) {
        this.f10518a = materialButton;
        this.f10519b = nVar;
    }

    public final j a(boolean z4) {
        RippleDrawable rippleDrawable = this.f10539v;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (j) ((LayerDrawable) ((InsetDrawable) this.f10539v.getDrawable(0)).getDrawable()).getDrawable(!z4 ? 1 : 0);
    }

    public final void b(int i4, int i5) {
        MaterialButton materialButton = this.f10518a;
        int paddingStart = materialButton.getPaddingStart();
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = materialButton.getPaddingEnd();
        int paddingBottom = materialButton.getPaddingBottom();
        int i6 = this.f10525h;
        int i7 = this.f10526i;
        this.f10526i = i5;
        this.f10525h = i4;
        if (!this.f10535r) {
            c();
        }
        materialButton.setPaddingRelative(paddingStart, (paddingTop + i4) - i6, paddingEnd, (paddingBottom + i5) - i7);
    }

    public final void c() {
        j jVar = new j(this.f10519b);
        B b4 = this.f10520c;
        if (b4 != null) {
            jVar.p(b4);
        }
        W.n nVar = this.f10521d;
        if (nVar != null) {
            jVar.m(nVar);
        }
        f fVar = this.f10522e;
        if (fVar != null) {
            jVar.f16232E = fVar;
        }
        MaterialButton materialButton = this.f10518a;
        jVar.l(materialButton.getContext());
        jVar.setTintList(this.f10530m);
        PorterDuff.Mode mode = this.f10529l;
        if (mode != null) {
            jVar.setTintMode(mode);
        }
        float f4 = this.f10528k;
        ColorStateList colorStateList = this.f10531n;
        jVar.f16234b.f16214l = f4;
        jVar.invalidateSelf();
        h hVar = jVar.f16234b;
        if (hVar.f16207e != colorStateList) {
            hVar.f16207e = colorStateList;
            jVar.onStateChange(jVar.getState());
        }
        j jVar2 = new j(this.f10519b);
        B b5 = this.f10520c;
        if (b5 != null) {
            jVar2.p(b5);
        }
        W.n nVar2 = this.f10521d;
        if (nVar2 != null) {
            jVar2.m(nVar2);
        }
        jVar2.setTint(0);
        float f5 = this.f10528k;
        int iX = this.f10534q ? AbstractC0557a.x(R.attr.colorSurface, materialButton) : 0;
        jVar2.f16234b.f16214l = f5;
        jVar2.invalidateSelf();
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(iX);
        h hVar2 = jVar2.f16234b;
        if (hVar2.f16207e != colorStateListValueOf) {
            hVar2.f16207e = colorStateListValueOf;
            jVar2.onStateChange(jVar2.getState());
        }
        j jVar3 = new j(this.f10519b);
        this.f10533p = jVar3;
        B b6 = this.f10520c;
        if (b6 != null) {
            jVar3.p(b6);
        }
        W.n nVar3 = this.f10521d;
        if (nVar3 != null) {
            this.f10533p.m(nVar3);
        }
        this.f10533p.setTint(-1);
        ColorStateList colorStateListValueOf2 = this.f10532o;
        if (colorStateListValueOf2 == null) {
            colorStateListValueOf2 = ColorStateList.valueOf(0);
        }
        RippleDrawable rippleDrawable = new RippleDrawable(colorStateListValueOf2, new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{jVar2, jVar}), this.f10523f, this.f10525h, this.f10524g, this.f10526i), this.f10533p);
        this.f10539v = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        j jVarA = a(false);
        if (jVarA != null) {
            jVarA.n(this.f10540w);
            jVarA.setState(materialButton.getDrawableState());
        }
    }

    public final void d() {
        j jVarA = a(false);
        if (jVarA != null) {
            B b4 = this.f10520c;
            if (b4 != null) {
                jVarA.p(b4);
            } else {
                jVarA.setShapeAppearanceModel(this.f10519b);
            }
            W.n nVar = this.f10521d;
            if (nVar != null) {
                jVarA.m(nVar);
            }
        }
        j jVarA2 = a(true);
        if (jVarA2 != null) {
            B b5 = this.f10520c;
            if (b5 != null) {
                jVarA2.p(b5);
            } else {
                jVarA2.setShapeAppearanceModel(this.f10519b);
            }
            W.n nVar2 = this.f10521d;
            if (nVar2 != null) {
                jVarA2.m(nVar2);
            }
        }
        RippleDrawable rippleDrawable = this.f10539v;
        y yVar = (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 1) ? null : this.f10539v.getNumberOfLayers() > 2 ? (y) this.f10539v.getDrawable(2) : (y) this.f10539v.getDrawable(1);
        if (yVar != null) {
            yVar.setShapeAppearanceModel(this.f10519b);
            if (yVar instanceof j) {
                j jVar = (j) yVar;
                B b6 = this.f10520c;
                if (b6 != null) {
                    jVar.p(b6);
                }
                W.n nVar3 = this.f10521d;
                if (nVar3 != null) {
                    jVar.m(nVar3);
                }
            }
        }
    }

    public final void e() {
        j jVarA = a(false);
        j jVarA2 = a(true);
        if (jVarA != null) {
            float f4 = this.f10528k;
            ColorStateList colorStateList = this.f10531n;
            jVarA.f16234b.f16214l = f4;
            jVarA.invalidateSelf();
            h hVar = jVarA.f16234b;
            if (hVar.f16207e != colorStateList) {
                hVar.f16207e = colorStateList;
                jVarA.onStateChange(jVarA.getState());
            }
            if (jVarA2 != null) {
                float f5 = this.f10528k;
                int iX = this.f10534q ? AbstractC0557a.x(R.attr.colorSurface, this.f10518a) : 0;
                jVarA2.f16234b.f16214l = f5;
                jVarA2.invalidateSelf();
                ColorStateList colorStateListValueOf = ColorStateList.valueOf(iX);
                h hVar2 = jVarA2.f16234b;
                if (hVar2.f16207e != colorStateListValueOf) {
                    hVar2.f16207e = colorStateListValueOf;
                    jVarA2.onStateChange(jVarA2.getState());
                }
            }
        }
    }
}
