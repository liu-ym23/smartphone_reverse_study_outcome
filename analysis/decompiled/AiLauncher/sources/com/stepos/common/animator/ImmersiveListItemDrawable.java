package com.stepos.common.animator;

import Z2.h;
import Z2.k;
import Z2.l;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.stepos.common.R$styleable;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public class ImmersiveListItemDrawable extends StepOSPressAnimationDrawable {
    private static int DEFAULT_IMMERSIVE_PADDING = 16;
    private int mImmersiveItemPadding;
    private h mSolid;
    private int mImmersiveType = 3;
    private int mSolidColor = -1;

    @Override // com.stepos.common.animator.StepOSPressAnimationDrawable, android.graphics.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.mSolid.draw(canvas);
        super.draw(canvas);
    }

    @Override // com.stepos.common.animator.StepOSPressAnimationDrawable, android.graphics.drawable.StateListDrawable, android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, R$styleable.ImmersiveListItemDrawable);
        int i10 = R$styleable.ImmersiveListItemDrawable_immersiveType;
        if (typedArrayObtainAttributes.hasValue(i10)) {
            this.mImmersiveType = typedArrayObtainAttributes.getInt(i10, 3);
        }
        int i11 = R$styleable.ImmersiveListItemDrawable_immersiveItemPadding;
        if (typedArrayObtainAttributes.hasValue(i11)) {
            this.mImmersiveItemPadding = typedArrayObtainAttributes.getDimensionPixelSize(i11, DEFAULT_IMMERSIVE_PADDING);
        }
        TypedValue typedValue = new TypedValue();
        int i12 = R$styleable.ImmersiveListItemDrawable_immersiveSolidColor;
        if (typedArrayObtainAttributes.hasValue(i12) && typedArrayObtainAttributes.getValue(i12, typedValue)) {
            int i13 = typedValue.type;
            if (i13 == 2) {
                if (theme != null) {
                    theme.resolveAttribute(typedValue.data, typedValue, true);
                    this.mSolidColor = typedValue.data;
                }
            } else if (i13 >= 28 && i13 <= 31) {
                this.mSolidColor = typedValue.data;
            }
        }
        typedArrayObtainAttributes.recycle();
        l.b bVarR = l.a().r(new k());
        int i14 = this.mImmersiveType;
        if (i14 == 3) {
            bVarR.o(h());
        } else if (i14 == 0) {
            bVarR.C(h()).G(h());
        } else if (i14 == 1) {
            bVarR.o(0.0f);
        } else if (i14 == 2) {
            bVarR.u(h()).y(h());
        }
        l lVarM = bVarR.m();
        h hVar = new h(lVarM);
        this.mSolid = hVar;
        hVar.setTint(this.mSolidColor);
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
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mSolid.setBounds(new Rect(getBounds().left + this.mImmersiveItemPadding, getBounds().top, getBounds().right - this.mImmersiveItemPadding, getBounds().bottom));
        this.mShapeDrawableWidth -= this.mImmersiveItemPadding * 2;
    }
}
