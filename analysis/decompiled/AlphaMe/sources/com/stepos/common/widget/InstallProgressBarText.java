package com.stepos.common.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import i2.AbstractC0620a;
import java.util.Locale;

/* loaded from: classes.dex */
public class InstallProgressBarText extends View {

    /* renamed from: a, reason: collision with root package name */
    public int f11651a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f11652b;

    /* renamed from: c, reason: collision with root package name */
    public int f11653c;

    /* renamed from: d, reason: collision with root package name */
    public int f11654d;

    /* renamed from: e, reason: collision with root package name */
    public int f11655e;

    /* renamed from: f, reason: collision with root package name */
    public final Rect f11656f;

    /* renamed from: g, reason: collision with root package name */
    public String f11657g;

    /* renamed from: h, reason: collision with root package name */
    public int f11658h;

    /* renamed from: i, reason: collision with root package name */
    public int f11659i;

    /* renamed from: j, reason: collision with root package name */
    public float f11660j;

    public InstallProgressBarText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11651a = 0;
        this.f11653c = getResources().getDimensionPixelOffset(R.dimen.online_theme_download_install_font_size);
        this.f11654d = -16777216;
        this.f11655e = -1;
        this.f11656f = new Rect();
        this.f11657g = null;
        this.f11652b = new Paint(1);
        this.f11652b.setTypeface(Typeface.create("sans-serif-medium", 0));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0620a.f13025g, 0, 0);
        if (typedArrayObtainStyledAttributes == null) {
            return;
        }
        this.f11657g = typedArrayObtainStyledAttributes.getString(1);
        this.f11653c = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, this.f11653c);
        this.f11654d = typedArrayObtainStyledAttributes.getColor(3, this.f11654d);
        this.f11655e = typedArrayObtainStyledAttributes.getColor(2, this.f11655e);
        this.f11660j = typedArrayObtainStyledAttributes.getFloat(4, Property.DEFAULT_FLOAT_VALUE);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void a(Canvas canvas, int i4, int i5, int i6) {
        this.f11652b.setColor(i4);
        canvas.save();
        canvas.clipRect(i5, 0, i6, getMeasuredHeight());
        Paint.FontMetricsInt fontMetricsInt = this.f11652b.getFontMetricsInt();
        int measuredHeight = getMeasuredHeight() - fontMetricsInt.bottom;
        int i7 = fontMetricsInt.top;
        canvas.drawText(this.f11657g, this.f11651a, ((measuredHeight + i7) / 2) - i7, this.f11652b);
        canvas.restore();
    }

    public float getProgress() {
        return this.f11660j;
    }

    public String getText() {
        return this.f11657g;
    }

    public int getTextChangeColor() {
        return this.f11655e;
    }

    public int getTextOriginColor() {
        return this.f11654d;
    }

    public int getTextSize() {
        return this.f11653c;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            int i4 = this.f11655e;
            int i5 = this.f11659i;
            float f4 = i5;
            a(canvas, i4, i5, (int) (f4 - (this.f11660j * f4)));
        } else {
            a(canvas, this.f11655e, 0, (int) ((this.f11660j * this.f11659i) + 0));
        }
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            int i6 = this.f11654d;
            float f5 = this.f11659i;
            a(canvas, i6, (int) (f5 - (this.f11660j * f5)), 0);
        } else {
            int i7 = this.f11654d;
            float f6 = this.f11660j;
            int i8 = this.f11659i;
            a(canvas, i7, (int) ((f6 * i8) + 0), i8);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        this.f11658h = (int) this.f11652b.measureText(this.f11657g);
        Paint paint = this.f11652b;
        String str = this.f11657g;
        int length = str.length();
        int iHeight = 0;
        Rect rect = this.f11656f;
        paint.getTextBounds(str, 0, length, rect);
        this.f11652b.setTextSize(this.f11653c);
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        int iMin = (mode == Integer.MIN_VALUE || mode == 0) ? this.f11658h : mode != 1073741824 ? 0 : size;
        if (mode == Integer.MIN_VALUE) {
            iMin = Math.min(iMin, size);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft() + iMin;
        int mode2 = View.MeasureSpec.getMode(i5);
        int size2 = View.MeasureSpec.getSize(i5);
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            iHeight = rect.height() * 2;
        } else if (mode2 == 1073741824) {
            iHeight = size2;
        }
        if (mode2 == Integer.MIN_VALUE) {
            iHeight = Math.min(iHeight, size2);
        }
        setMeasuredDimension(paddingRight, getPaddingBottom() + getPaddingTop() + iHeight);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        this.f11659i = measuredWidth;
        this.f11651a = (measuredWidth / 2) - (this.f11658h / 2);
        invalidate();
    }

    public synchronized void setAnimProgress(float f4) {
        float f5 = this.f11660j;
        (f4 < f5 ? ObjectAnimator.ofFloat(this, "Progress", Property.DEFAULT_FLOAT_VALUE, f4).setDuration(500L) : ObjectAnimator.ofFloat(this, "Progress", f5, f4).setDuration(500L)).start();
    }

    public void setProgress(float f4) {
        this.f11660j = f4;
        invalidate();
    }

    public void setText(String str) {
        this.f11657g = str;
        requestLayout();
        invalidate();
    }

    public void setTextChangeColor(int i4) {
        this.f11655e = i4;
        invalidate();
    }

    public void setTextOriginColor(int i4) {
        this.f11654d = i4;
        invalidate();
    }

    public void setTextSize(int i4) {
        this.f11653c = i4;
        requestLayout();
        invalidate();
    }
}
