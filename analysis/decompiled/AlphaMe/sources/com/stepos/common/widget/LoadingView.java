package com.stepos.common.widget;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.LinearInterpolator;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import com.stepos.common.drawble.CircularAnimatedDrawable;
import i2.AbstractC0620a;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class LoadingView extends View {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f11690a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f11691b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f11692c;

    /* renamed from: d, reason: collision with root package name */
    public ObjectAnimator f11693d;

    /* renamed from: e, reason: collision with root package name */
    public float f11694e;

    /* renamed from: f, reason: collision with root package name */
    public float f11695f;

    /* renamed from: g, reason: collision with root package name */
    public final RectF f11696g;

    /* renamed from: h, reason: collision with root package name */
    public final float f11697h;

    /* renamed from: i, reason: collision with root package name */
    public final float f11698i;

    /* renamed from: j, reason: collision with root package name */
    public final float f11699j;

    /* renamed from: k, reason: collision with root package name */
    public final float f11700k;

    /* renamed from: l, reason: collision with root package name */
    public int f11701l;

    /* renamed from: m, reason: collision with root package name */
    public int f11702m;

    /* renamed from: n, reason: collision with root package name */
    public int f11703n;

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.StepOSCommon_LoadingViewStyle);
        this.f11690a = null;
        this.f11691b = null;
        this.f11692c = null;
        this.f11693d = null;
        this.f11696g = null;
        this.f11703n = 1;
        Paint paint = new Paint(1);
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(36.0f);
        int iF = m2.o.f(R.attr.colorPrimary, context);
        this.f11702m = context.getResources().getColor(iF == 0 ? R.color.fd_sys_color_primary_blue : iF);
        int iF2 = m2.o.f(R.attr.colorPrimaryContainer, context);
        this.f11701l = context.getResources().getColor(iF2 == 0 ? R.color.fd_sys_color_primary_container_blue : iF2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0620a.f13026h, R.attr.StepOSCommon_LoadingStyle, 0);
        float dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(5, 24);
        this.f11697h = dimensionPixelOffset;
        float dimensionPixelOffset2 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(7, 10);
        this.f11698i = dimensionPixelOffset2;
        this.f11701l = typedArrayObtainStyledAttributes.getColor(1, this.f11701l);
        this.f11702m = typedArrayObtainStyledAttributes.getColor(3, this.f11702m);
        this.f11703n = typedArrayObtainStyledAttributes.getInt(6, 1);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint2 = new Paint(1);
        this.f11690a = paint2;
        paint2.setAntiAlias(true);
        paint2.setColor(this.f11702m);
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        Paint paint3 = new Paint(paint2);
        this.f11692c = paint3;
        paint3.setStyle(Paint.Style.FILL);
        Paint paint4 = new Paint(1);
        this.f11691b = paint4;
        paint4.setAntiAlias(true);
        paint4.setColor(this.f11701l);
        paint4.setStyle(style);
        float f4 = 0;
        float f5 = dimensionPixelOffset2 - f4;
        paint2.setStrokeWidth(f5);
        paint4.setStrokeWidth(f5);
        this.f11699j = getX() + getPaddingLeft() + dimensionPixelOffset + f4 + dimensionPixelOffset2;
        this.f11700k = getY() + getPaddingTop() + dimensionPixelOffset + f4 + dimensionPixelOffset2;
        RectF rectF = new RectF();
        this.f11696g = rectF;
        float f6 = this.f11699j;
        float f7 = dimensionPixelOffset2 / 2.0f;
        rectF.left = ((f6 - dimensionPixelOffset) - f4) - f7;
        float f8 = this.f11700k;
        rectF.top = ((f8 - dimensionPixelOffset) - f4) - f7;
        rectF.right = f6 + dimensionPixelOffset + f4 + f7;
        rectF.bottom = f8 + dimensionPixelOffset + f4 + f7;
    }

    public final void a() {
        ObjectAnimator objectAnimator = this.f11693d;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            this.f11703n = 1;
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe(CircularAnimatedDrawable.START_ANGLE_PROPERTY, Keyframe.ofFloat(Property.DEFAULT_FLOAT_VALUE, -90.0f), Keyframe.ofFloat(0.5f, 330.0f), Keyframe.ofFloat(1.0f, 630.0f)), PropertyValuesHolder.ofFloat(CircularAnimatedDrawable.SWEEP_ANGLE_PROPERTY, Property.DEFAULT_FLOAT_VALUE, -144.0f, Property.DEFAULT_FLOAT_VALUE));
            objectAnimatorOfPropertyValuesHolder.setDuration(1760L);
            objectAnimatorOfPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            objectAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
            this.f11693d = objectAnimatorOfPropertyValuesHolder;
            objectAnimatorOfPropertyValuesHolder.start();
        }
    }

    public int getBarBackgroundColor() {
        return this.f11701l;
    }

    public int getBarColor() {
        return this.f11702m;
    }

    public float getStartAngle() {
        return this.f11694e;
    }

    public float getSweepAngle() {
        return this.f11695f;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.f11693d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f11693d = null;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float width = getWidth() / 2;
        float f4 = this.f11697h;
        float f5 = this.f11698i;
        canvas.translate((width - f4) - f5, ((getHeight() / 2) - f4) - f5);
        int i4 = this.f11702m;
        int i5 = this.f11701l;
        Paint paint = this.f11691b;
        if (i4 == i5) {
            paint.setAlpha(26);
        }
        if (this.f11703n != 1) {
            super.onDraw(canvas);
            return;
        }
        canvas.drawArc(this.f11696g, -90.0f, 360.0f, false, paint);
        RectF rectF = this.f11696g;
        float f6 = this.f11694e;
        float f7 = this.f11695f;
        Paint paint2 = this.f11690a;
        canvas.drawArc(rectF, f6, f7, false, paint2);
        float fWidth = this.f11696g.width() / 2.0f;
        float fHeight = this.f11696g.height() / 2.0f;
        float strokeWidth = paint2.getStrokeWidth() / 2.0f;
        float fCos = this.f11696g.right - (((float) (1.0d - Math.cos(Math.toRadians(this.f11694e)))) * fWidth);
        float fSin = this.f11696g.bottom - (((float) (1.0d - Math.sin(Math.toRadians(this.f11694e)))) * fHeight);
        Paint paint3 = this.f11692c;
        canvas.drawCircle(fCos, fSin, strokeWidth, paint3);
        canvas.drawCircle(this.f11696g.right - (fWidth * ((float) (1.0d - Math.cos(Math.toRadians(this.f11695f + this.f11694e))))), this.f11696g.bottom - (fHeight * ((float) (1.0d - Math.sin(Math.toRadians(this.f11695f + this.f11694e))))), strokeWidth, paint3);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(LoadingView.class.getName());
    }

    @Override // android.view.View
    public final void onMeasure(int i4, int i5) {
        int i6 = (int) ((this.f11697h + this.f11698i + 2.0f) * 2.0f);
        setMeasuredDimension(View.resolveSizeAndState(getPaddingRight() + getPaddingLeft() + i6, i4, 0), View.resolveSizeAndState(getPaddingBottom() + getPaddingTop() + i6, i5, 0));
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i4) {
        super.onVisibilityChanged(view, i4);
        if (1 != this.f11703n) {
            return;
        }
        if (i4 == 0) {
            if (isShown()) {
                a();
            }
        } else {
            ObjectAnimator objectAnimator = this.f11693d;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                this.f11693d = null;
            }
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        if (1 != this.f11703n) {
            return;
        }
        if (i4 == 0) {
            if (isShown()) {
                a();
            }
        } else {
            ObjectAnimator objectAnimator = this.f11693d;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                this.f11693d = null;
            }
        }
    }

    public void setBarBackgroundColor(int i4) {
        Paint paint = this.f11691b;
        if (paint == null || paint.getColor() == i4) {
            return;
        }
        paint.setColor(i4);
        this.f11701l = i4;
        postInvalidate();
    }

    public void setBarColor(int i4) {
        Paint paint = this.f11690a;
        if (paint == null || paint.getColor() == i4) {
            return;
        }
        paint.setColor(i4);
        this.f11692c.setColor(i4);
        this.f11702m = i4;
        postInvalidate();
    }

    public void setStartAngle(float f4) {
        this.f11694e = f4;
        invalidate();
    }

    public void setSweepAngle(float f4) {
        this.f11695f = f4;
        invalidate();
    }

    @Override // android.view.View
    public void setVisibility(int i4) {
        ObjectAnimator objectAnimator;
        super.setVisibility(i4);
        if (i4 == 0) {
            a();
        } else if ((i4 == 4 || i4 == 8) && (objectAnimator = this.f11693d) != null) {
            objectAnimator.cancel();
            this.f11693d = null;
        }
    }
}
