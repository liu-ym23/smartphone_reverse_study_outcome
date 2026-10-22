package com.stepos.common.drawble;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.google.android.material.button.a;
import com.stepos.common.animator.b;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class SurroundShaderDrawable extends Drawable {
    private static final String TAG = "ShaderGlowDrawable";
    private b mAnimator;
    private final Paint mPaint = new Paint();

    public SurroundShaderDrawable() {
        b.d dVar = new b.d();
        dVar.h = 1;
        this.mAnimator = new b(dVar);
    }

    private void updateStateFromTypedArray(TypedArray typedArray) {
        int color = typedArray.getColor(6, -1);
        int resourceId = typedArray.getResourceId(1, -1);
        String[] stringArray = resourceId != -1 ? typedArray.getResources().getStringArray(resourceId) : null;
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(5, 0);
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(2, 0);
        int integer = typedArray.getInteger(4, 20);
        boolean z = typedArray.getBoolean(3, false);
        int i10 = typedArray.getInt(0, 1);
        a aVar = new a(this);
        b.d dVar = new b.d();
        dVar.f6461c = z;
        dVar.f6459a = integer / 100.0f;
        dVar.f6460b = color;
        dVar.f6462d = dimensionPixelOffset;
        dVar.f6463e = dimensionPixelOffset2;
        dVar.f6464f = stringArray;
        dVar.h = i10;
        dVar.f6465g = aVar;
        this.mAnimator = new b(dVar);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.mPaint.getShader() != null) {
            canvas.drawPaint(this.mPaint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        int[] iArr = g8.a.f9085l;
        TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        updateStateFromTypedArray(typedArrayObtainAttributes);
        typedArrayObtainAttributes.recycle();
    }

    public boolean isShaderAnimRunning() {
        ValueAnimator valueAnimator = this.mAnimator.f6452c;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mAnimator.f6450a.setFloatUniform("size", rect.width(), rect.height());
    }

    public void releaseShaderAnimation() {
        b bVar = this.mAnimator;
        ValueAnimator valueAnimator = bVar.f6452c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ObjectAnimator objectAnimator = bVar.f6453d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.mPaint.setShader(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.mPaint.setAlpha(i10);
    }

    public void setAnimType(int i10) {
        b bVar = this.mAnimator;
        bVar.f6454e.h = i10;
        ValueAnimator valueAnimator = bVar.f6452c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ObjectAnimator objectAnimator = bVar.f6453d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        if (i10 == 0) {
            bVar.b();
        } else {
            bVar.a();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setColors(String[] strArr) {
        b bVar = this.mAnimator;
        bVar.f6454e.f6464f = strArr;
        int[] iArr = new int[strArr.length];
        for (int i10 = 0; i10 < strArr.length; i10++) {
            iArr[i10] = Color.parseColor(strArr[i10]);
        }
        bVar.c(iArr);
    }

    public void setCornerRadius(float f8) {
        this.mAnimator.f6450a.setFloatUniform("radius", f8);
    }

    public void setGlowInner(boolean z) {
        this.mAnimator.f6450a.setFloatUniform("inner", z ? 1.0f : -1.0f);
    }

    public void setIntensity(float f8) {
        this.mAnimator.f6450a.setFloatUniform("glowIntensity", f8);
    }

    public void setShaderRadius(int i10) {
        this.mAnimator.f6450a.setFloatUniform("glowRadius", i10);
    }

    public void setSize(float f8, float f9) {
        this.mAnimator.f6450a.setFloatUniform("size", f8, f9);
    }

    public void setSolidColor(int i10) {
        this.mAnimator.f6450a.setColorUniform("rectColor", i10);
    }

    public void startShaderAnimation() {
        this.mAnimator.d();
        this.mPaint.setShader(this.mAnimator.f6450a);
    }
}
