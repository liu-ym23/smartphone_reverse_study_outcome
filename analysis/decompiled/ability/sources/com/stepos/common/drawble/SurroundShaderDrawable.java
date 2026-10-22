package com.stepos.common.drawble;

import B5.a;
import V4.s;
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
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.stepos.common.animator.c;
import com.stepos.common.animator.d;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RequiresApi(api = 33)
/* loaded from: classes3.dex */
public class SurroundShaderDrawable extends Drawable {
    private static final String TAG = "ShaderGlowDrawable";
    private d mAnimator;
    private final Paint mPaint = new Paint();

    public SurroundShaderDrawable() {
        c cVar = new c();
        cVar.h = 1;
        this.mAnimator = new d(cVar);
    }

    private void updateStateFromTypedArray(TypedArray typedArray) {
        int color = typedArray.getColor(6, -1);
        int resourceId = typedArray.getResourceId(1, -1);
        String[] stringArray = resourceId != -1 ? typedArray.getResources().getStringArray(resourceId) : null;
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(5, 0);
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(2, 0);
        int integer = typedArray.getInteger(4, 20);
        boolean z10 = typedArray.getBoolean(3, false);
        int i = typedArray.getInt(0, 1);
        a aVar = new a(this, 19);
        c cVar = new c();
        cVar.c = z10;
        cVar.f3561a = integer / 100.0f;
        cVar.b = color;
        cVar.d = dimensionPixelOffset;
        cVar.e = dimensionPixelOffset2;
        cVar.f = stringArray;
        cVar.h = i;
        cVar.g = aVar;
        this.mAnimator = new d(cVar);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.mPaint.getShader() != null) {
            canvas.drawPaint(this.mPaint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        int[] iArr = s.l;
        TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        updateStateFromTypedArray(typedArrayObtainAttributes);
        typedArrayObtainAttributes.recycle();
    }

    public boolean isShaderAnimRunning() {
        ValueAnimator valueAnimator = this.mAnimator.c;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.mAnimator.f3562a.setFloatUniform("size", rect.width(), rect.height());
    }

    public void releaseShaderAnimation() {
        d dVar = this.mAnimator;
        ValueAnimator valueAnimator = dVar.c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ObjectAnimator objectAnimator = dVar.d;
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
        dVar.e.h = i;
        ValueAnimator valueAnimator = dVar.c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ObjectAnimator objectAnimator = dVar.d;
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

    public void setColors(@NonNull String[] strArr) {
        d dVar = this.mAnimator;
        dVar.e.f = strArr;
        int[] iArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            iArr[i] = Color.parseColor(strArr[i]);
        }
        dVar.c(iArr);
    }

    public void setCornerRadius(float f) {
        this.mAnimator.f3562a.setFloatUniform("radius", f);
    }

    public void setGlowInner(boolean z10) {
        this.mAnimator.f3562a.setFloatUniform("inner", z10 ? 1.0f : -1.0f);
    }

    public void setIntensity(float f) {
        this.mAnimator.f3562a.setFloatUniform("glowIntensity", f);
    }

    public void setShaderRadius(int i) {
        this.mAnimator.f3562a.setFloatUniform("glowRadius", i);
    }

    public void setSize(float f, float f7) {
        this.mAnimator.f3562a.setFloatUniform("size", f, f7);
    }

    public void setSolidColor(@ColorInt int i) {
        this.mAnimator.f3562a.setColorUniform("rectColor", i);
    }

    public void startShaderAnimation() {
        this.mAnimator.d();
        this.mPaint.setShader(this.mAnimator.f3562a);
    }
}
