package com.stepos.common.animator;

import H1.m;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;
import t1.C1115h;
import t1.k;
import t1.l;

/* loaded from: classes.dex */
public class ImmersiveListItemDrawable extends StepOSPressAnimationDrawable {

    /* renamed from: J, reason: collision with root package name */
    private static int f13556J = 16;

    /* renamed from: F, reason: collision with root package name */
    private C1115h f13557F;

    /* renamed from: H, reason: collision with root package name */
    private int f13559H;

    /* renamed from: G, reason: collision with root package name */
    private int f13558G = 3;

    /* renamed from: I, reason: collision with root package name */
    private int f13560I = -1;

    @Override // com.stepos.common.animator.StepOSPressAnimationDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f13557F.draw(canvas);
        super.draw(canvas);
    }

    @Override // com.stepos.common.animator.StepOSPressAnimationDrawable, android.graphics.drawable.StateListDrawable, android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, m.f2483Q1);
        int i5 = m.f2501T1;
        if (typedArrayObtainAttributes.hasValue(i5)) {
            this.f13558G = typedArrayObtainAttributes.getInt(i5, 3);
        }
        int i6 = m.f2489R1;
        if (typedArrayObtainAttributes.hasValue(i6)) {
            this.f13559H = typedArrayObtainAttributes.getDimensionPixelSize(i6, f13556J);
        }
        TypedValue typedValue = new TypedValue();
        int i7 = m.f2495S1;
        if (typedArrayObtainAttributes.hasValue(i7) && typedArrayObtainAttributes.getValue(i7, typedValue)) {
            int i8 = typedValue.type;
            if (i8 == 2) {
                if (theme != null) {
                    theme.resolveAttribute(typedValue.data, typedValue, true);
                    this.f13560I = typedValue.data;
                }
            } else if (i8 >= 28 && i8 <= 31) {
                this.f13560I = typedValue.data;
            }
        }
        typedArrayObtainAttributes.recycle();
        l.b bVarR = l.a().r(new k());
        int i9 = this.f13558G;
        if (i9 == 3) {
            bVarR.o(h());
        } else if (i9 == 0) {
            bVarR.C(h()).G(h());
        } else if (i9 == 1) {
            bVarR.o(0.0f);
        } else if (i9 == 2) {
            bVarR.u(h()).y(h());
        }
        l lVarM = bVarR.m();
        C1115h c1115h = new C1115h(lVarM);
        this.f13557F = c1115h;
        c1115h.setTint(this.f13560I);
        g().setShapeAppearanceModel(lVarM);
    }

    @Override // com.stepos.common.animator.StepOSPressAnimationDrawable, android.graphics.drawable.Drawable
    public boolean isProjected() {
        return false;
    }

    @Override // com.stepos.common.animator.StepOSPressAnimationDrawable
    public boolean o() {
        return true;
    }

    @Override // com.stepos.common.animator.StepOSPressAnimationDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f13557F.setBounds(new Rect(getBounds().left + this.f13559H, getBounds().top, getBounds().right - this.f13559H, getBounds().bottom));
        this.f13568c -= this.f13559H * 2;
    }
}
