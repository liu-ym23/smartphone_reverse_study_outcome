package com.stepos.common.drawble;

import H1.m;
import I1.b;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class SurroundShaderDrawable extends Drawable {
    private static final String TAG = "ShaderGlowDrawable";
    private final Paint mPaint = new Paint();
    private b mAnimator = new b.d().a();

    private void updateStateFromTypedArray(TypedArray typedArray) {
        int color = typedArray.getColor(m.f2659s4, -1);
        int resourceId = typedArray.getResourceId(m.f2629n4, -1);
        String[] stringArray = resourceId != -1 ? typedArray.getResources().getStringArray(resourceId) : null;
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(m.f2653r4, 0);
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(m.f2635o4, 0);
        int integer = typedArray.getInteger(m.f2647q4, 20);
        this.mAnimator = new b.d().g(typedArray.getBoolean(m.f2641p4, false)).h(integer / 100.0f).i(color).f(dimensionPixelOffset).e(dimensionPixelOffset2).d(stringArray).b(typedArray.getInt(m.f2623m4, 1)).c(new b.e() { // from class: com.stepos.common.drawble.a
            @Override // I1.b.e
            public final void a() {
                this.f13599a.invalidateSelf();
            }
        }).a();
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
        TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, m.f2617l4) : theme.obtainStyledAttributes(attributeSet, m.f2617l4, 0, 0);
        updateStateFromTypedArray(typedArrayObtainAttributes);
        typedArrayObtainAttributes.recycle();
    }

    public boolean isShaderAnimRunning() {
        return this.mAnimator.h();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mAnimator.r(rect.width(), rect.height());
    }

    public void releaseShaderAnimation() {
        this.mAnimator.i();
        this.mPaint.setShader(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i5) {
        this.mPaint.setAlpha(i5);
    }

    public void setAnimType(int i5) {
        this.mAnimator.j(i5);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setColors(String[] strArr) {
        this.mAnimator.k(strArr);
    }

    public void setCornerRadius(float f5) {
        this.mAnimator.n(f5);
    }

    public void setGlowInner(boolean z5) {
        this.mAnimator.o(z5);
    }

    public void setIntensity(float f5) {
        this.mAnimator.p(f5);
    }

    public void setShaderRadius(int i5) {
        this.mAnimator.q(i5);
    }

    public void setSize(float f5, float f6) {
        this.mAnimator.r(f5, f6);
    }

    public void setSolidColor(int i5) {
        this.mAnimator.s(i5);
    }

    public void startShaderAnimation() {
        this.mAnimator.t();
        this.mPaint.setShader(this.mAnimator.e());
    }
}
