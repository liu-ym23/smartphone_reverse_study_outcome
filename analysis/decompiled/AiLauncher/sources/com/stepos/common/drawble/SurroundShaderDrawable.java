package com.stepos.common.drawble;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.stepos.common.R$styleable;
import com.stepos.common.animator.b;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes3.dex */
public class SurroundShaderDrawable extends Drawable {
    private static final String TAG = "ShaderGlowDrawable";
    private final Paint mPaint = new Paint();
    private b mAnimator = new b.d().a();

    private void updateStateFromTypedArray(TypedArray typedArray) {
        int color = typedArray.getColor(R$styleable.ShaderGlowStyle_shaderGlowSolidColor, -1);
        int resourceId = typedArray.getResourceId(R$styleable.ShaderGlowStyle_shaderGlowColors, -1);
        String[] stringArray = resourceId != -1 ? typedArray.getResources().getStringArray(resourceId) : null;
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(R$styleable.ShaderGlowStyle_shaderGlowRadius, 0);
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(R$styleable.ShaderGlowStyle_shaderGlowCornerRadius, 0);
        int integer = typedArray.getInteger(R$styleable.ShaderGlowStyle_shaderGlowIntensity, 20);
        this.mAnimator = new b.d().g(typedArray.getBoolean(R$styleable.ShaderGlowStyle_shaderGlowInner, false)).h(integer / 100.0f).i(color).f(dimensionPixelOffset).e(dimensionPixelOffset2).d(stringArray).b(typedArray.getInt(R$styleable.ShaderGlowStyle_shaderGlowAnimType, 1)).c(new b.e() { // from class: com.stepos.common.drawble.a
            @Override // com.stepos.common.animator.b.e
            public final void a() {
                this.f29509a.invalidateSelf();
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
        TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, R$styleable.ShaderGlowStyle) : theme.obtainStyledAttributes(attributeSet, R$styleable.ShaderGlowStyle, 0, 0);
        updateStateFromTypedArray(typedArrayObtainAttributes);
        typedArrayObtainAttributes.recycle();
    }

    public boolean isShaderAnimRunning() {
        return this.mAnimator.h();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mAnimator.r(rect.width(), rect.height());
    }

    public void releaseShaderAnimation() {
        this.mAnimator.i();
        this.mPaint.setShader(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.mPaint.setAlpha(i10);
    }

    public void setAnimType(int i10) {
        this.mAnimator.j(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setColors(String[] strArr) {
        this.mAnimator.k(strArr);
    }

    public void setCornerRadius(float f10) {
        this.mAnimator.n(f10);
    }

    public void setGlowInner(boolean z10) {
        this.mAnimator.o(z10);
    }

    public void setIntensity(float f10) {
        this.mAnimator.p(f10);
    }

    public void setShaderRadius(int i10) {
        this.mAnimator.q(i10);
    }

    public void setSize(float f10, float f11) {
        this.mAnimator.r(f10, f11);
    }

    public void setSolidColor(int i10) {
        this.mAnimator.s(i10);
    }

    public void startShaderAnimation() {
        this.mAnimator.t();
        this.mPaint.setShader(this.mAnimator.e());
    }
}
