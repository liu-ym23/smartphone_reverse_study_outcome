package com.stepos.common.animator;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;
import y4.i;
import y4.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ImmersiveListItemDrawable extends StepOSPressAnimationDrawable {
    public y4.g G;
    public int I;
    public int H = 3;
    public int J = -1;

    @Override // com.stepos.common.animator.StepOSPressAnimationDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        this.G.draw(canvas);
        super.draw(canvas);
    }

    @Override // com.stepos.common.animator.StepOSPressAnimationDrawable, android.graphics.drawable.StateListDrawable, android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, g8.a.f9080f);
        if (typedArrayObtainAttributes.hasValue(2)) {
            this.H = typedArrayObtainAttributes.getInt(2, 3);
        }
        if (typedArrayObtainAttributes.hasValue(0)) {
            this.I = typedArrayObtainAttributes.getDimensionPixelSize(0, 16);
        }
        TypedValue typedValue = new TypedValue();
        if (typedArrayObtainAttributes.hasValue(1) && typedArrayObtainAttributes.getValue(1, typedValue)) {
            int i10 = typedValue.type;
            if (i10 == 2) {
                if (theme != null) {
                    theme.resolveAttribute(typedValue.data, typedValue, true);
                    this.J = typedValue.data;
                }
            } else if (i10 >= 28 && i10 <= 31) {
                this.J = typedValue.data;
            }
        }
        typedArrayObtainAttributes.recycle();
        j.a aVar = new j.a();
        i iVar = new i();
        aVar.f14073a = iVar;
        aVar.f14074b = iVar;
        aVar.f14075c = iVar;
        aVar.f14076d = iVar;
        int i11 = this.H;
        if (i11 == 3) {
            aVar.b(this.r);
        } else if (i11 == 0) {
            aVar.e(this.r);
            aVar.f(this.r);
        } else if (i11 == 1) {
            aVar.b(0.0f);
        } else if (i11 == 2) {
            aVar.c(this.r);
            aVar.d(this.r);
        }
        j jVarA = aVar.a();
        y4.g gVar = new y4.g(jVarA);
        this.G = gVar;
        gVar.setTint(this.J);
        this.f6424a.setShapeAppearanceModel(jVarA);
    }

    @Override // com.stepos.common.animator.StepOSPressAnimationDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.G.setBounds(new Rect(getBounds().left + this.I, getBounds().top, getBounds().right - this.I, getBounds().bottom));
        this.f6426c -= this.I * 2;
    }
}
