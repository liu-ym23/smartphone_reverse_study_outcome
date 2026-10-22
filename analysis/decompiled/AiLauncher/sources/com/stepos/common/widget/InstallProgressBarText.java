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
import com.stepos.common.R$dimen;
import com.stepos.common.R$styleable;
import java.util.Locale;

/* loaded from: classes3.dex */
public class InstallProgressBarText extends View {
    private ObjectAnimator mObjectAnimator;
    private Paint mPaint;
    private float mProgress;
    private int mRealWidth;
    private String mText;
    private Rect mTextBound;
    private int mTextCenterX;
    private int mTextChangeColor;
    private int mTextOriginColor;
    private int mTextSize;
    private int mTextStartX;
    private int mTextWidth;

    public InstallProgressBarText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTextStartX = 0;
        this.mTextCenterX = 0;
        this.mTextSize = getResources().getDimensionPixelOffset(R$dimen.online_theme_download_install_font_size);
        this.mTextOriginColor = -16777216;
        this.mTextChangeColor = -1;
        this.mTextBound = new Rect();
        this.mText = null;
        f(context, attributeSet);
    }

    public final void a(Canvas canvas) {
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) != 1) {
            int i10 = this.mTextChangeColor;
            int i11 = this.mTextStartX;
            c(canvas, i10, i11, (int) (i11 + (this.mProgress * this.mRealWidth)));
        } else {
            int i12 = this.mTextChangeColor;
            int i13 = this.mTextStartX;
            int i14 = this.mRealWidth;
            c(canvas, i12, i13 + i14, (int) ((i13 + i14) - (this.mProgress * i14)));
        }
    }

    public final void b(Canvas canvas) {
        if (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1) {
            c(canvas, this.mTextOriginColor, (int) ((r1 + r2) - (this.mProgress * this.mRealWidth)), this.mTextStartX);
            return;
        }
        int i10 = this.mTextOriginColor;
        int i11 = this.mTextStartX;
        float f10 = this.mProgress;
        int i12 = this.mRealWidth;
        c(canvas, i10, (int) (i11 + (f10 * i12)), i11 + i12);
    }

    public final void c(Canvas canvas, int i10, int i11, int i12) {
        this.mPaint.setColor(i10);
        canvas.save();
        canvas.clipRect(i11, 0, i12, getMeasuredHeight());
        Paint.FontMetricsInt fontMetricsInt = this.mPaint.getFontMetricsInt();
        int measuredHeight = getMeasuredHeight() - fontMetricsInt.bottom;
        int i13 = fontMetricsInt.top;
        canvas.drawText(this.mText, this.mTextCenterX, ((measuredHeight + i13) / 2) - i13, this.mPaint);
        canvas.restore();
    }

    public final ObjectAnimator d(float f10) {
        float f11 = this.mProgress;
        return f10 < f11 ? ObjectAnimator.ofFloat(this, "Progress", 0.0f, f10).setDuration(500L) : ObjectAnimator.ofFloat(this, "Progress", f11, f10).setDuration(500L);
    }

    public TypedArray e(Context context, AttributeSet attributeSet, int[] iArr) {
        return context.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public final void f(Context context, AttributeSet attributeSet) {
        this.mPaint = new Paint(1);
        this.mPaint.setTypeface(Typeface.create("sans-serif-medium", 0));
        g(context, attributeSet);
    }

    public final void g(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayE = e(context, attributeSet, R$styleable.InstallProgressBarText);
        if (typedArrayE == null) {
            return;
        }
        this.mText = typedArrayE.getString(R$styleable.InstallProgressBarText_mcText);
        this.mTextSize = typedArrayE.getDimensionPixelSize(R$styleable.InstallProgressBarText_mcProgressTextSize, this.mTextSize);
        this.mTextOriginColor = typedArrayE.getColor(R$styleable.InstallProgressBarText_mcTextOriginColor, this.mTextOriginColor);
        this.mTextChangeColor = typedArrayE.getColor(R$styleable.InstallProgressBarText_mcTextChangeColor, this.mTextChangeColor);
        this.mProgress = typedArrayE.getFloat(R$styleable.InstallProgressBarText_mcTextProgress, 0.0f);
        typedArrayE.recycle();
    }

    public float getProgress() {
        return this.mProgress;
    }

    public String getText() {
        return this.mText;
    }

    public int getTextChangeColor() {
        return this.mTextChangeColor;
    }

    public int getTextOriginColor() {
        return this.mTextOriginColor;
    }

    public int getTextSize() {
        return this.mTextSize;
    }

    public final int h(int i10) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int iHeight = (mode == Integer.MIN_VALUE || mode == 0) ? this.mTextBound.height() * 2 : mode != 1073741824 ? 0 : size;
        if (mode == Integer.MIN_VALUE) {
            iHeight = Math.min(iHeight, size);
        }
        return iHeight + getPaddingTop() + getPaddingBottom();
    }

    public final void i() {
        this.mTextWidth = (int) this.mPaint.measureText(this.mText);
        Paint paint = this.mPaint;
        String str = this.mText;
        paint.getTextBounds(str, 0, str.length(), this.mTextBound);
    }

    public final int j(int i10) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int iMin = (mode == Integer.MIN_VALUE || mode == 0) ? this.mTextWidth : mode != 1073741824 ? 0 : size;
        if (mode == Integer.MIN_VALUE) {
            iMin = Math.min(iMin, size);
        }
        return iMin + getPaddingLeft() + getPaddingRight();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
        b(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        i();
        this.mPaint.setTextSize(this.mTextSize);
        setMeasuredDimension(j(i10), h(i11));
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        this.mRealWidth = measuredWidth;
        this.mTextCenterX = (measuredWidth / 2) - (this.mTextWidth / 2);
        invalidate();
    }

    public synchronized void setAnimProgress(float f10) {
        ObjectAnimator objectAnimatorD = d(f10);
        this.mObjectAnimator = objectAnimatorD;
        objectAnimatorD.start();
    }

    public void setProgress(float f10) {
        this.mProgress = f10;
        invalidate();
    }

    public void setText(String str) {
        this.mText = str;
        requestLayout();
        invalidate();
    }

    public void setTextChangeColor(int i10) {
        this.mTextChangeColor = i10;
        invalidate();
    }

    public void setTextOriginColor(int i10) {
        this.mTextOriginColor = i10;
        invalidate();
    }

    public void setTextSize(int i10) {
        this.mTextSize = i10;
        requestLayout();
        invalidate();
    }
}
