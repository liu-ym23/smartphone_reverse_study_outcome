package com.stepos.common.drawble;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
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

    public CircularProgressDrawable(int i5, int i6, int i7) {
        this.mSize = i5;
        this.mStrokeWidth = i6;
        this.mStrokeColor = i7;
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
            float f5 = this.mStrokeWidth / 2.0f;
            this.mRectF = new RectF(f5, f5, getSize() - f5, getSize() - f5);
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
            int i5 = this.mStrokeWidth;
            this.mIconPaint.setStrokeWidth(i5);
            int i6 = bounds.left;
            int i7 = size2 / 2;
            int i8 = ((int) (size2 * 0.12d)) / 2;
            int i9 = i5 / 2;
            int i10 = bounds.top;
            int i11 = size / 2;
            int i12 = ((int) (size / 3.1f)) / 2;
            canvas.drawLine(((i6 + i7) - i8) - i9, ((i10 + i11) - i12) + i9, ((i6 + i7) - i8) - i9, ((i10 + i11) + i12) - i9, this.mIconPaint);
            int i13 = bounds.left;
            int i14 = bounds.top;
            canvas.drawLine(i13 + i7 + i8 + i9, ((i14 + i11) - i12) + i9, i13 + i7 + i8 + i9, ((i14 + i11) + i12) - i9, this.mIconPaint);
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
    public void setAlpha(int i5) {
    }

    public void setCenterIcon(Drawable drawable) {
        this.mCenterIcon = drawable;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setIndicatorColor(int i5) {
        createPaint();
        this.mStrokeColor = i5;
        this.mPaint.setColor(i5);
    }

    public void setOffset(float f5, float f6) {
        this.offset.set(f5, f6);
    }

    public void setShowCenterIcon(boolean z5) {
        this.mShouldIcon = z5;
    }

    public void setStartAngle(float f5) {
        this.mStartAngle = f5;
    }

    public void setStrokeWidth(int i5) {
        if (i5 <= 0 || this.mStrokeWidth == i5) {
            return;
        }
        this.mStrokeWidth = i5;
        RectF rectF = this.mRectF;
        if (rectF != null) {
            float f5 = i5 / 2;
            rectF.set(f5, f5, getSize() - r5, getSize() - r5);
        }
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setStrokeWidth(this.mStrokeWidth);
        }
    }

    public void setSweepAngle(float f5) {
        this.mSweepAngle = f5;
    }
}
