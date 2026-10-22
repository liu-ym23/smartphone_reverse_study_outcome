package com.stepos.common.drawble;

import a1.g;
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
import b.b;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import q9.a;
import r9.c;
import r9.d;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class SurroundShaderDrawable extends Drawable {
    private static final String TAG = "ShaderGlowDrawable";
    private final Paint mPaint = new Paint();
    private d mAnimator = new g(27).q();

    private void updateStateFromTypedArray(TypedArray typedArray) {
        int color = typedArray.getColor(6, -1);
        int i = 1;
        int resourceId = typedArray.getResourceId(1, -1);
        String[] stringArray = resourceId != -1 ? typedArray.getResources().getStringArray(resourceId) : null;
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(5, 0);
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(2, 0);
        int integer = typedArray.getInteger(4, 20);
        boolean z10 = typedArray.getBoolean(3, false);
        int i3 = typedArray.getInt(0, 1);
        b bVar = new b(i);
        bVar.f1685f = this;
        VarHandle.storeStoreFence();
        g gVar = new g(27);
        c cVar = (c) gVar.f19f;
        cVar.f10488c = z10;
        cVar.f10486a = integer / 100.0f;
        cVar.f10487b = color;
        cVar.f10489d = dimensionPixelOffset;
        cVar.f10490e = dimensionPixelOffset2;
        cVar.f10491f = stringArray;
        cVar.f10493h = i3;
        cVar.f10492g = bVar;
        this.mAnimator = gVar.q();
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
        int[] iArr = a.f10203f;
        TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        updateStateFromTypedArray(typedArrayObtainAttributes);
        typedArrayObtainAttributes.recycle();
    }

    public boolean isShaderAnimRunning() {
        ValueAnimator valueAnimator = this.mAnimator.f10496c;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mAnimator.f10494a.setFloatUniform("size", rect.width(), rect.height());
    }

    public void releaseShaderAnimation() {
        d dVar = this.mAnimator;
        ValueAnimator valueAnimator = dVar.f10496c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ObjectAnimator objectAnimator = dVar.f10497d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.mPaint.setShader(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mPaint.setAlpha(i);
    }

    public void setAnimType(int i) {
        d dVar = this.mAnimator;
        dVar.f10498e.f10493h = i;
        ValueAnimator valueAnimator = dVar.f10496c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ObjectAnimator objectAnimator = dVar.f10497d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        if (i == 0) {
            dVar.b();
        } else {
            dVar.a();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setColors(String[] strArr) {
        d dVar = this.mAnimator;
        dVar.f10498e.f10491f = strArr;
        int[] iArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            iArr[i] = Color.parseColor(strArr[i]);
        }
        dVar.c(iArr);
    }

    public void setCornerRadius(float f5) {
        this.mAnimator.f10494a.setFloatUniform("radius", f5);
    }

    public void setGlowInner(boolean z10) {
        this.mAnimator.f10494a.setFloatUniform("inner", z10 ? 1.0f : -1.0f);
    }

    public void setIntensity(float f5) {
        this.mAnimator.f10494a.setFloatUniform("glowIntensity", f5);
    }

    public void setShaderRadius(int i) {
        this.mAnimator.f10494a.setFloatUniform("glowRadius", i);
    }

    public void setSize(float f5, float f10) {
        this.mAnimator.f10494a.setFloatUniform("size", f5, f10);
    }

    public void setSolidColor(int i) {
        this.mAnimator.f10494a.setColorUniform("rectColor", i);
    }

    public void startShaderAnimation() {
        this.mAnimator.d();
        this.mPaint.setShader(this.mAnimator.f10494a);
    }
}
