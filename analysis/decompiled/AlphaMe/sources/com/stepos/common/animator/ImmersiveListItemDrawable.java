package com.stepos.common.animator;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.stepos.alphame.utils.Property;
import i2.AbstractC0620a;
import java.lang.reflect.InvocationTargetException;
import org.xmlpull.v1.XmlPullParser;
import y1.C0987a;

/* loaded from: classes.dex */
public class ImmersiveListItemDrawable extends StepOSPressAnimationDrawable {

    /* renamed from: D, reason: collision with root package name */
    public y1.j f11234D;

    /* renamed from: F, reason: collision with root package name */
    public int f11236F;

    /* renamed from: E, reason: collision with root package name */
    public int f11235E = 3;

    /* renamed from: G, reason: collision with root package name */
    public int f11237G = -1;

    @Override // com.stepos.common.animator.StepOSPressAnimationDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        this.f11234D.draw(canvas);
        super.draw(canvas);
    }

    @Override // com.stepos.common.animator.StepOSPressAnimationDrawable, android.graphics.drawable.StateListDrawable, android.graphics.drawable.Drawable
    public final void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, AbstractC0620a.f13024f);
        if (typedArrayObtainAttributes.hasValue(2)) {
            this.f11235E = typedArrayObtainAttributes.getInt(2, 3);
        }
        if (typedArrayObtainAttributes.hasValue(0)) {
            this.f11236F = typedArrayObtainAttributes.getDimensionPixelSize(0, 16);
        }
        TypedValue typedValue = new TypedValue();
        if (typedArrayObtainAttributes.hasValue(1) && typedArrayObtainAttributes.getValue(1, typedValue)) {
            int i4 = typedValue.type;
            if (i4 == 2) {
                if (theme != null) {
                    theme.resolveAttribute(typedValue.data, typedValue, true);
                    this.f11237G = typedValue.data;
                }
            } else if (i4 >= 28 && i4 <= 31) {
                this.f11237G = typedValue.data;
            }
        }
        typedArrayObtainAttributes.recycle();
        y1.m mVar = new y1.m();
        mVar.d(new y1.l());
        int i5 = this.f11235E;
        if (i5 == 3) {
            mVar.c(this.f11255o);
        } else if (i5 == 0) {
            int i6 = this.f11255o;
            mVar.f16264e = new C0987a(i6);
            mVar.f16265f = new C0987a(i6);
        } else if (i5 == 1) {
            mVar.c(Property.DEFAULT_FLOAT_VALUE);
        } else if (i5 == 2) {
            int i7 = this.f11255o;
            mVar.f16267h = new C0987a(i7);
            mVar.f16266g = new C0987a(i7);
        }
        y1.n nVarA = mVar.a();
        y1.j jVar = new y1.j(nVarA);
        this.f11234D = jVar;
        jVar.setTint(this.f11237G);
        this.f11241a.setShapeAppearanceModel(nVarA);
    }

    @Override // com.stepos.common.animator.StepOSPressAnimationDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f11234D.setBounds(new Rect(getBounds().left + this.f11236F, getBounds().top, getBounds().right - this.f11236F, getBounds().bottom));
        this.f11243c -= this.f11236F * 2;
    }
}
