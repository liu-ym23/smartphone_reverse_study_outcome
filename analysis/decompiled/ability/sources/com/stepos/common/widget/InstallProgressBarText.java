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
import androidx.core.view.ViewCompat;
import com.stepos.ability.R;
import java.util.Locale;

/* loaded from: classes3.dex */
public class InstallProgressBarText extends View {

    /* renamed from: a, reason: collision with root package name */
    public int f3716a;
    public final Paint b;
    public int c;
    public int d;
    public int e;
    public final Rect f;
    public String g;
    public int h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public float f3717j;

    public InstallProgressBarText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3716a = 0;
        this.c = getResources().getDimensionPixelOffset(R.dimen.online_theme_download_install_font_size);
        this.d = ViewCompat.MEASURED_STATE_MASK;
        this.e = -1;
        this.f = new Rect();
        this.g = null;
        this.b = new Paint(1);
        this.b.setTypeface(Typeface.create("sans-serif-medium", 0));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V4.s.g, 0, 0);
        if (typedArrayObtainStyledAttributes == null) {
            return;
        }
        this.g = typedArrayObtainStyledAttributes.getString(1);
        this.c = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, this.c);
        this.d = typedArrayObtainStyledAttributes.getColor(3, this.d);
        this.e = typedArrayObtainStyledAttributes.getColor(2, this.e);
        this.f3717j = typedArrayObtainStyledAttributes.getFloat(4, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void a(Canvas canvas, int i, int i6, int i10) {
        this.b.setColor(i);
        canvas.save();
        canvas.clipRect(i6, 0, i10, getMeasuredHeight());
        Paint.FontMetricsInt fontMetricsInt = this.b.getFontMetricsInt();
        int measuredHeight = getMeasuredHeight() - fontMetricsInt.bottom;
        int i11 = fontMetricsInt.top;
        canvas.drawText(this.g, this.f3716a, ((measuredHeight + i11) / 2) - i11, this.b);
        canvas.restore();
    }

    public float getProgress() {
        return this.f3717j;
    }

    public String getText() {
        return this.g;
    }

    public int getTextChangeColor() {
        return this.e;
    }

    public int getTextOriginColor() {
        return this.d;
    }

    public int getTextSize() {
        return this.c;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            int i = this.e;
            int i6 = this.i;
            float f = i6;
            a(canvas, i, i6, (int) (f - (this.f3717j * f)));
        } else {
            a(canvas, this.e, 0, (int) ((this.f3717j * this.i) + 0));
        }
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            int i10 = this.d;
            float f7 = this.i;
            a(canvas, i10, (int) (f7 - (this.f3717j * f7)), 0);
        } else {
            int i11 = this.d;
            float f9 = this.f3717j;
            int i12 = this.i;
            a(canvas, i11, (int) ((f9 * i12) + 0), i12);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i6) {
        this.h = (int) this.b.measureText(this.g);
        String str = this.g;
        int length = str.length();
        Paint paint = this.b;
        int iHeight = 0;
        Rect rect = this.f;
        paint.getTextBounds(str, 0, length, rect);
        this.b.setTextSize(this.c);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int iMin = (mode == Integer.MIN_VALUE || mode == 0) ? this.h : mode != 1073741824 ? 0 : size;
        if (mode == Integer.MIN_VALUE) {
            iMin = Math.min(iMin, size);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft() + iMin;
        int mode2 = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i6);
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
        this.i = measuredWidth;
        this.f3716a = (measuredWidth / 2) - (this.h / 2);
        invalidate();
    }

    public synchronized void setAnimProgress(float f) {
        float f7 = this.f3717j;
        (f < f7 ? ObjectAnimator.ofFloat(this, "Progress", 0.0f, f).setDuration(500L) : ObjectAnimator.ofFloat(this, "Progress", f7, f).setDuration(500L)).start();
    }

    public void setProgress(float f) {
        this.f3717j = f;
        invalidate();
    }

    public void setText(String str) {
        this.g = str;
        requestLayout();
        invalidate();
    }

    public void setTextChangeColor(int i) {
        this.e = i;
        invalidate();
    }

    public void setTextOriginColor(int i) {
        this.d = i;
        invalidate();
    }

    public void setTextSize(int i) {
        this.c = i;
        requestLayout();
        invalidate();
    }
}
