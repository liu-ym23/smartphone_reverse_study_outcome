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
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.app.f;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.stepos.common.animator.c;
import com.stepos.common.animator.d;
import i2.AbstractC0620a;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RequiresApi(api = 33)
/* loaded from: classes.dex */
public class SurroundShaderDrawable extends Drawable {
    private static final String TAG = "ShaderGlowDrawable";
    private d mAnimator;
    private final Paint mPaint = new Paint();

    public SurroundShaderDrawable() {
        c cVar = new c();
        cVar.f11283h = 1;
        this.mAnimator = new d(cVar);
    }

    private void updateStateFromTypedArray(TypedArray typedArray) {
        int color = typedArray.getColor(6, -1);
        int resourceId = typedArray.getResourceId(1, -1);
        String[] stringArray = resourceId != -1 ? typedArray.getResources().getStringArray(resourceId) : null;
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(5, 0);
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(2, 0);
        int integer = typedArray.getInteger(4, 20);
        boolean z4 = typedArray.getBoolean(3, false);
        int i4 = typedArray.getInt(0, 1);
        f fVar = new f(this);
        c cVar = new c();
        cVar.f11278c = z4;
        cVar.f11276a = integer / 100.0f;
        cVar.f11277b = color;
        cVar.f11279d = dimensionPixelOffset;
        cVar.f11280e = dimensionPixelOffset2;
        cVar.f11281f = stringArray;
        cVar.f11283h = i4;
        cVar.f11282g = fVar;
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
        int[] iArr = AbstractC0620a.f13030l;
        TypedArray typedArrayObtainAttributes = theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
        updateStateFromTypedArray(typedArrayObtainAttributes);
        typedArrayObtainAttributes.recycle();
    }

    public boolean isShaderAnimRunning() {
        ValueAnimator valueAnimator = this.mAnimator.f11286c;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        this.mAnimator.f11284a.setFloatUniform(MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE, rect.width(), rect.height());
    }

    public void releaseShaderAnimation() {
        d dVar = this.mAnimator;
        ValueAnimator valueAnimator = dVar.f11286c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ObjectAnimator objectAnimator = dVar.f11287d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.mPaint.setShader(null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        this.mPaint.setAlpha(i4);
    }

    public void setAnimType(int i4) {
        d dVar = this.mAnimator;
        dVar.f11288e.f11283h = i4;
        ValueAnimator valueAnimator = dVar.f11286c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ObjectAnimator objectAnimator = dVar.f11287d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        if (i4 == 0) {
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
        dVar.f11288e.f11281f = strArr;
        int[] iArr = new int[strArr.length];
        for (int i4 = 0; i4 < strArr.length; i4++) {
            iArr[i4] = Color.parseColor(strArr[i4]);
        }
        dVar.c(iArr);
    }

    public void setCornerRadius(float f4) {
        this.mAnimator.f11284a.setFloatUniform("radius", f4);
    }

    public void setGlowInner(boolean z4) {
        this.mAnimator.f11284a.setFloatUniform("inner", z4 ? 1.0f : -1.0f);
    }

    public void setIntensity(float f4) {
        this.mAnimator.f11284a.setFloatUniform("glowIntensity", f4);
    }

    public void setShaderRadius(int i4) {
        this.mAnimator.f11284a.setFloatUniform("glowRadius", i4);
    }

    public void setSize(float f4, float f5) {
        this.mAnimator.f11284a.setFloatUniform(MapBundleKey.OfflineMapKey.OFFLINE_TOTAL_SIZE, f4, f5);
    }

    public void setSolidColor(@ColorInt int i4) {
        this.mAnimator.f11284a.setColorUniform("rectColor", i4);
    }

    public void startShaderAnimation() {
        this.mAnimator.d();
        this.mPaint.setShader(this.mAnimator.f11284a);
    }
}
