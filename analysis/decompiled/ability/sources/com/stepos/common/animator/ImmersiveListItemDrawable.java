package com.stepos.common.animator;

import V4.s;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import e3.C1412a;
import e3.o;
import e3.p;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes3.dex */
public class ImmersiveListItemDrawable extends StepOSPressAnimationDrawable {

    /* renamed from: D, reason: collision with root package name */
    public e3.k f3543D;

    /* renamed from: F, reason: collision with root package name */
    public int f3544F;
    public int E = 3;

    /* renamed from: G, reason: collision with root package name */
    public int f3545G = -1;

    @Override // com.stepos.common.animator.StepOSPressAnimationDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        this.f3543D.draw(canvas);
        super.draw(canvas);
    }

    @Override // com.stepos.common.animator.StepOSPressAnimationDrawable, android.graphics.drawable.StateListDrawable, android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, s.f);
        if (typedArrayObtainAttributes.hasValue(2)) {
            this.E = typedArrayObtainAttributes.getInt(2, 3);
        }
        if (typedArrayObtainAttributes.hasValue(0)) {
            this.f3544F = typedArrayObtainAttributes.getDimensionPixelSize(0, 16);
        }
        TypedValue typedValue = new TypedValue();
        if (typedArrayObtainAttributes.hasValue(1) && typedArrayObtainAttributes.getValue(1, typedValue)) {
            int i = typedValue.type;
            if (i == 2) {
                if (theme != null) {
                    theme.resolveAttribute(typedValue.data, typedValue, true);
                    this.f3545G = typedValue.data;
                }
            } else if (i >= 28 && i <= 31) {
                this.f3545G = typedValue.data;
            }
        }
        typedArrayObtainAttributes.recycle();
        o oVar = new o();
        e3.n nVar = new e3.n();
        oVar.f4367a = nVar;
        o.b(nVar);
        oVar.b = nVar;
        o.b(nVar);
        oVar.c = nVar;
        o.b(nVar);
        oVar.d = nVar;
        o.b(nVar);
        int i6 = this.E;
        if (i6 == 3) {
            oVar.c(this.o);
        } else if (i6 == 0) {
            int i10 = this.o;
            oVar.e = new C1412a(i10);
            oVar.f = new C1412a(i10);
        } else if (i6 == 1) {
            oVar.c(0.0f);
        } else if (i6 == 2) {
            int i11 = this.o;
            oVar.h = new C1412a(i11);
            oVar.g = new C1412a(i11);
        }
        p pVarA = oVar.a();
        e3.k kVar = new e3.k(pVarA);
        this.f3543D = kVar;
        kVar.setTint(this.f3545G);
        this.f3549a.setShapeAppearanceModel(pVarA);
    }

    @Override // com.stepos.common.animator.StepOSPressAnimationDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f3543D.setBounds(new Rect(getBounds().left + this.f3544F, getBounds().top, getBounds().right - this.f3544F, getBounds().bottom));
        this.c -= this.f3544F * 2;
    }
}
