package com.stepos.common.drawble;

import B0.g;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.stepos.alphame.utils.Property;

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
    private final PointF offset = new PointF(Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE);
    private float mStartAngle = 90.0f;
    private float mSweepAngle = Property.DEFAULT_FLOAT_VALUE;

    public CircularProgressDrawable(int i4, int i5, int i6) {
        this.mSize = i4;
        this.mStrokeWidth = i5;
        this.mStrokeColor = i6;
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
            float f4 = this.mStrokeWidth / 2.0f;
            this.mRectF = new RectF(f4, f4, getSize() - f4, getSize() - f4);
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
            canvas.translate(((getSize() / 2) + bounds.left) - (this.mCenterIcon.getIntrinsicWidth() / 2), ((getSize() / 2) + bounds.top) - (this.mCenterIcon.getIntrinsicHeight() / 2));
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
            int i4 = this.mStrokeWidth;
            int i5 = (int) (size / 3.1f);
            int i6 = (int) (size2 * 0.12d);
            this.mIconPaint.setStrokeWidth(i4);
            int i7 = bounds.left;
            int i8 = size2 / 2;
            int i9 = i6 / 2;
            int i10 = i4 / 2;
            int i11 = bounds.top;
            int i12 = size / 2;
            int i13 = i5 / 2;
            canvas.drawLine(((i7 + i8) - i9) - i10, ((i11 + i12) - i13) + i10, g.e(i7, i8, i9, i10), ((i11 + i12) + i13) - i10, this.mIconPaint);
            int i14 = bounds.left;
            int i15 = bounds.top;
            canvas.drawLine(i14 + i8 + i9 + i10, ((i15 + i12) - i13) + i10, i14 + i8 + i9 + i10, ((i15 + i12) + i13) - i10, this.mIconPaint);
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
    public void setAlpha(int i4) {
    }

    public void setCenterIcon(Drawable drawable) {
        this.mCenterIcon = drawable;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setIndicatorColor(int i4) {
        createPaint();
        this.mStrokeColor = i4;
        this.mPaint.setColor(i4);
    }

    public void setOffset(float f4, float f5) {
        this.offset.set(f4, f5);
    }

    public void setShowCenterIcon(boolean z4) {
        this.mShouldIcon = z4;
    }

    public void setStartAngle(float f4) {
        this.mStartAngle = f4;
    }

    public void setStrokeWidth(int i4) {
        if (i4 <= 0 || this.mStrokeWidth == i4) {
            return;
        }
        this.mStrokeWidth = i4;
        RectF rectF = this.mRectF;
        if (rectF != null) {
            float f4 = i4 / 2;
            rectF.set(f4, f4, getSize() - r5, getSize() - r5);
        }
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setStrokeWidth(this.mStrokeWidth);
        }
    }

    public void setSweepAngle(float f4) {
        this.mSweepAngle = f4;
    }
}
