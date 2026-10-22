package com.stepos.common.drawble;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes3.dex */
public class CircularProgressDrawable extends Drawable {
    private Drawable mCenterIcon;
    private RectF mDrawRectF;
    private Paint mIconPaint;
    private Paint mPaint;
    private RectF mRectF;
    private int mSize;
    private int mStrokeColor;
    private int mStrokeWidth;
    private boolean mShouldIcon = false;
    private final PointF offset = new PointF(0.0f, 0.0f);
    private float mStartAngle = 90.0f;
    private float mSweepAngle = 0.0f;

    public CircularProgressDrawable(int i10, int i11, int i12) {
        this.mSize = i10;
        this.mStrokeWidth = i11;
        this.mStrokeColor = i12;
    }

    private Paint createPaint() {
        if (this.mPaint == null) {
            Paint paint = new Paint();
            this.mPaint = paint;
            paint.setAntiAlias(true);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.mStrokeWidth + 1);
            this.mPaint.setColor(this.mStrokeColor);
            this.mPaint.setStrokeCap(Paint.Cap.ROUND);
            this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        }
        return this.mPaint;
    }

    private RectF getRect() {
        if (this.mRectF == null) {
            float f10 = this.mStrokeWidth / 2.0f;
            this.mRectF = new RectF(f10, f10, getSize() - f10, getSize() - f10);
        }
        return this.mRectF;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (this.mDrawRectF == null) {
            this.mDrawRectF = new RectF();
        }
        this.mDrawRectF.set(getRect());
        RectF rectF = this.mDrawRectF;
        PointF pointF = this.offset;
        rectF.offset(pointF.x, pointF.y);
        canvas.drawArc(this.mDrawRectF, this.mStartAngle, this.mSweepAngle, false, createPaint());
        if (this.mCenterIcon != null) {
            canvas.save();
            Drawable drawable = this.mCenterIcon;
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.mCenterIcon.getIntrinsicHeight());
            canvas.translate((bounds.left + (getSize() / 2)) - (this.mCenterIcon.getIntrinsicWidth() / 2), (bounds.top + (getSize() / 2)) - (this.mCenterIcon.getIntrinsicHeight() / 2));
            this.mCenterIcon.draw(canvas);
            canvas.restore();
            return;
        }
        if (this.mShouldIcon) {
            if (this.mIconPaint == null) {
                Paint paint = new Paint();
                this.mIconPaint = paint;
                paint.setStrokeCap(Paint.Cap.ROUND);
                this.mIconPaint.setColor(this.mStrokeColor);
                this.mIconPaint.setAntiAlias(true);
            }
            int size = getSize();
            int size2 = getSize();
            int i10 = this.mStrokeWidth;
            this.mIconPaint.setStrokeWidth(i10);
            int i11 = bounds.left;
            int i12 = size2 / 2;
            int i13 = ((int) (size2 * 0.12d)) / 2;
            int i14 = i10 / 2;
            int i15 = bounds.top;
            int i16 = size / 2;
            int i17 = ((int) (size / 3.1f)) / 2;
            canvas.drawLine(((i11 + i12) - i13) - i14, ((i15 + i16) - i17) + i14, ((i11 + i12) - i13) - i14, ((i15 + i16) + i17) - i14, this.mIconPaint);
            int i18 = bounds.left;
            int i19 = bounds.top;
            canvas.drawLine(i18 + i12 + i13 + i14, ((i19 + i16) - i17) + i14, i18 + i12 + i13 + i14, ((i19 + i16) + i17) - i14, this.mIconPaint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 1;
    }

    public int getSize() {
        return this.mSize;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
    }

    public void setCenterIcon(Drawable drawable) {
        this.mCenterIcon = drawable;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setIndicatorColor(int i10) {
        createPaint();
        this.mStrokeColor = i10;
        this.mPaint.setColor(i10);
    }

    public void setOffset(float f10, float f11) {
        this.offset.set(f10, f11);
    }

    public void setShowCenterIcon(boolean z10) {
        this.mShouldIcon = z10;
    }

    public void setStartAngle(float f10) {
        this.mStartAngle = f10;
    }

    public void setStrokeWidth(int i10) {
        if (i10 <= 0 || this.mStrokeWidth == i10) {
            return;
        }
        this.mStrokeWidth = i10;
        RectF rectF = this.mRectF;
        if (rectF != null) {
            float f10 = i10 / 2;
            rectF.set(f10, f10, getSize() - r5, getSize() - r5);
        }
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setStrokeWidth(this.mStrokeWidth);
        }
    }

    public void setSweepAngle(float f10) {
        this.mSweepAngle = f10;
    }
}
