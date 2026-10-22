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
import com.stepos.aiengine.R;
import java.util.Locale;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class InstallProgressBarText extends View {

    /* renamed from: a, reason: collision with root package name */
    public int f6925a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f6926b;

    /* renamed from: c, reason: collision with root package name */
    public int f6927c;

    /* renamed from: d, reason: collision with root package name */
    public int f6928d;

    /* renamed from: e, reason: collision with root package name */
    public int f6929e;
    public final Rect h;

    /* renamed from: j, reason: collision with root package name */
    public String f6930j;

    /* renamed from: k, reason: collision with root package name */
    public int f6931k;

    /* renamed from: l, reason: collision with root package name */
    public int f6932l;

    /* renamed from: m, reason: collision with root package name */
    public float f6933m;

    public InstallProgressBarText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6925a = 0;
        this.f6927c = getResources().getDimensionPixelOffset(R.dimen.online_theme_download_install_font_size);
        this.f6928d = -16777216;
        this.f6929e = -1;
        this.h = new Rect();
        this.f6930j = null;
        this.f6926b = new Paint(1);
        this.f6926b.setTypeface(Typeface.create("sans-serif-medium", 0));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g8.a.f9081g, 0, 0);
        if (typedArrayObtainStyledAttributes == null) {
            return;
        }
        this.f6930j = typedArrayObtainStyledAttributes.getString(1);
        this.f6927c = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, this.f6927c);
        this.f6928d = typedArrayObtainStyledAttributes.getColor(3, this.f6928d);
        this.f6929e = typedArrayObtainStyledAttributes.getColor(2, this.f6929e);
        this.f6933m = typedArrayObtainStyledAttributes.getFloat(4, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void a(Canvas canvas, int i10, int i11, int i12) {
        this.f6926b.setColor(i10);
        canvas.save();
        canvas.clipRect(i11, 0, i12, getMeasuredHeight());
        Paint.FontMetricsInt fontMetricsInt = this.f6926b.getFontMetricsInt();
        int measuredHeight = getMeasuredHeight() - fontMetricsInt.bottom;
        int i13 = fontMetricsInt.top;
        canvas.drawText(this.f6930j, this.f6925a, ((measuredHeight + i13) / 2) - i13, this.f6926b);
        canvas.restore();
    }

    public float getProgress() {
        return this.f6933m;
    }

    public String getText() {
        return this.f6930j;
    }

    public int getTextChangeColor() {
        return this.f6929e;
    }

    public int getTextOriginColor() {
        return this.f6928d;
    }

    public int getTextSize() {
        return this.f6927c;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            int i10 = this.f6929e;
            int i11 = this.f6932l;
            float f8 = i11;
            a(canvas, i10, i11, (int) (f8 - (this.f6933m * f8)));
        } else {
            a(canvas, this.f6929e, 0, (int) ((this.f6933m * this.f6932l) + 0));
        }
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            int i12 = this.f6928d;
            float f9 = this.f6932l;
            a(canvas, i12, (int) (f9 - (this.f6933m * f9)), 0);
        } else {
            int i13 = this.f6928d;
            float f10 = this.f6933m;
            int i14 = this.f6932l;
            a(canvas, i13, (int) ((f10 * i14) + 0), i14);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        this.f6931k = (int) this.f6926b.measureText(this.f6930j);
        String str = this.f6930j;
        int length = str.length();
        Paint paint = this.f6926b;
        int iHeight = 0;
        Rect rect = this.h;
        paint.getTextBounds(str, 0, length, rect);
        this.f6926b.setTextSize(this.f6927c);
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int iMin = (mode == Integer.MIN_VALUE || mode == 0) ? this.f6931k : mode != 1073741824 ? 0 : size;
        if (mode == Integer.MIN_VALUE) {
            iMin = Math.min(iMin, size);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft() + iMin;
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
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
        this.f6932l = measuredWidth;
        this.f6925a = (measuredWidth / 2) - (this.f6931k / 2);
        invalidate();
    }

    public synchronized void setAnimProgress(float f8) {
        float f9 = this.f6933m;
        (f8 < f9 ? ObjectAnimator.ofFloat(this, "Progress", 0.0f, f8).setDuration(500L) : ObjectAnimator.ofFloat(this, "Progress", f9, f8).setDuration(500L)).start();
    }

    public void setProgress(float f8) {
        this.f6933m = f8;
        invalidate();
    }

    public void setText(String str) {
        this.f6930j = str;
        requestLayout();
        invalidate();
    }

    public void setTextChangeColor(int i10) {
        this.f6929e = i10;
        invalidate();
    }

    public void setTextOriginColor(int i10) {
        this.f6928d = i10;
        invalidate();
    }

    public void setTextSize(int i10) {
        this.f6927c = i10;
        requestLayout();
        invalidate();
    }
}
