package com.stepos.common.widget.numberwheel;

import E6.b;
import G6.a;
import V4.s;
import a5.l;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.stepos.ability.R;

/* loaded from: classes3.dex */
public class NumberWheelView extends View {

    /* renamed from: a, reason: collision with root package name */
    public final SpringAnimation f3809a;
    public final Paint b;
    public final Camera c;
    public float d;
    public int e;
    public int f;
    public final Paint g;
    public final Paint h;
    public final BlurMaskFilter[] i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f3810j;
    public int k;

    public NumberWheelView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = 0.0f;
        this.f3810j = true;
        this.k = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, s.i);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, l.b(context, 60.0d));
        int color = typedArrayObtainStyledAttributes.getColor(0, ContextCompat.getColor(context, R.color.fd_sys_color_on_surface_default));
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setTextSize(dimensionPixelSize);
        this.b.setTextAlign(Paint.Align.CENTER);
        this.b.setColor(color);
        this.c = new Camera();
        this.g = new Paint(this.b);
        this.h = new Paint(this.b);
        BlurMaskFilter[] blurMaskFilterArr = new BlurMaskFilter[40];
        this.i = blurMaskFilterArr;
        blurMaskFilterArr[0] = null;
        int i = 1;
        while (true) {
            BlurMaskFilter[] blurMaskFilterArr2 = this.i;
            if (i >= blurMaskFilterArr2.length) {
                setLayerType(1, this.b);
                SpringAnimation spring = new SpringAnimation(new FloatValueHolder()).setSpring(new SpringForce().setDampingRatio(0.65f).setStiffness(250.0f));
                this.f3809a = spring;
                spring.addUpdateListener(new b(this, 2));
                this.f3809a.addEndListener(new a(this, 1));
                return;
            }
            blurMaskFilterArr2[i] = new BlurMaskFilter(i, BlurMaskFilter.Blur.NORMAL);
            i++;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.k == 2) {
            return;
        }
        float f = this.d / 90.0f;
        float f7 = 1.0f - f;
        this.g.setAlpha((int) (f7 * 255.0f));
        BlurMaskFilter[] blurMaskFilterArr = this.i;
        int length = (int) (blurMaskFilterArr.length * f);
        if (length < blurMaskFilterArr.length && length >= 0) {
            this.g.setMaskFilter(blurMaskFilterArr[length]);
        }
        canvas.save();
        this.c.save();
        float f9 = this.d;
        boolean z10 = this.f3810j;
        if (f9 <= 90.0f) {
            if (z10) {
                this.c.rotateX(f9);
                canvas.translate(this.e, this.f - this.d);
            } else {
                this.c.rotateX(-f9);
                canvas.translate(this.e, this.f + this.d);
            }
            this.c.applyToCanvas(canvas);
            canvas.drawText(String.valueOf(0), 0.0f, this.f / 2.0f, this.g);
        }
        this.c.restore();
        canvas.restore();
        if (this.k == 1) {
            return;
        }
        this.h.setAlpha((int) (f * 255.0f));
        BlurMaskFilter[] blurMaskFilterArr2 = this.i;
        int length2 = (int) (f7 * blurMaskFilterArr2.length);
        if (length2 >= 0 && length2 < blurMaskFilterArr2.length) {
            this.h.setMaskFilter(blurMaskFilterArr2[length2]);
        }
        canvas.save();
        this.c.save();
        if (z10) {
            this.c.rotateX(((this.d / 90.0f) * 90.0f) - 90.0f);
            canvas.translate(this.e, (90.0f - this.d) + this.f);
        } else {
            this.c.rotateX(90.0f - ((this.d / 90.0f) * 90.0f));
            canvas.translate(this.e, this.f - (90.0f - this.d));
        }
        this.c.applyToCanvas(canvas);
        canvas.drawText(String.valueOf(0), 0.0f, this.f / 2.0f, this.h);
        this.c.restore();
        canvas.restore();
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i6) {
        super.onMeasure(i, i6);
        float fMeasureText = this.b.measureText(String.valueOf(9));
        Paint.FontMetrics fontMetrics = this.b.getFontMetrics();
        float f = fontMetrics.descent - fontMetrics.ascent;
        float fMax = Math.max(fMeasureText, getSuggestedMinimumWidth());
        float fMax2 = Math.max(f, getSuggestedMinimumHeight());
        if (this.k != 0) {
            setMeasuredDimension((int) ((1.0f - Math.min(this.d / 90.0f, 1.0f)) * fMax), (int) fMax2);
        } else {
            setMeasuredDimension((int) fMax, l.b(getContext(), 30.0d) + ((int) fMax2));
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i6, int i10, int i11) {
        super.onSizeChanged(i, i6, i10, i11);
        this.e = i / 2;
        this.f = i6 / 2;
    }

    public void setTextColor(@ColorInt int i) {
        this.b.setColor(i);
        this.g.setColor(i);
        this.h.setColor(i);
        invalidate();
    }

    public void setTextSize(int i) {
        float f = i;
        this.b.setTextSize(f);
        this.g.setTextSize(f);
        this.h.setTextSize(f);
        requestLayout();
    }

    public void setTypeface(Typeface typeface) {
        this.b.setTypeface(typeface);
        this.g.setTypeface(typeface);
        this.h.setTypeface(typeface);
        requestLayout();
    }
}
