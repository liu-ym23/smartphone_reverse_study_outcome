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
import com.stepos.ability.R;
import com.stepos.common.drawble.CircularAnimatedDrawable;

@SuppressLint({"NewApi"})
/* loaded from: classes3.dex */
public class LoadingView extends View {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f3722a;
    public final Paint b;
    public final Paint c;
    public ObjectAnimator d;
    public float e;
    public float f;
    public final RectF g;
    public final float h;
    public final float i;

    /* renamed from: j, reason: collision with root package name */
    public final float f3723j;
    public final float k;
    public int l;
    public int m;
    public int n;

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.StepOSCommon_LoadingViewStyle);
        this.f3722a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.g = null;
        this.n = 1;
        Paint paint = new Paint(1);
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(36.0f);
        int iE = a5.l.e(R.attr.colorPrimary, context);
        this.m = context.getResources().getColor(iE == 0 ? R.color.fd_sys_color_primary_blue : iE);
        int iE2 = a5.l.e(R.attr.colorPrimaryContainer, context);
        this.l = context.getResources().getColor(iE2 == 0 ? R.color.fd_sys_color_primary_container_blue : iE2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, V4.s.h, R.attr.StepOSCommon_LoadingStyle, 0);
        float dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(5, 24);
        this.h = dimensionPixelOffset;
        float dimensionPixelOffset2 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(7, 10);
        this.i = dimensionPixelOffset2;
        this.l = typedArrayObtainStyledAttributes.getColor(1, this.l);
        this.m = typedArrayObtainStyledAttributes.getColor(3, this.m);
        this.n = typedArrayObtainStyledAttributes.getInt(6, 1);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint2 = new Paint(1);
        this.f3722a = paint2;
        paint2.setAntiAlias(true);
        paint2.setColor(this.m);
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        Paint paint3 = new Paint(paint2);
        this.c = paint3;
        paint3.setStyle(Paint.Style.FILL);
        Paint paint4 = new Paint(1);
        this.b = paint4;
        paint4.setAntiAlias(true);
        paint4.setColor(this.l);
        paint4.setStyle(style);
        float f = 0;
        float f7 = dimensionPixelOffset2 - f;
        paint2.setStrokeWidth(f7);
        paint4.setStrokeWidth(f7);
        this.f3723j = getX() + getPaddingLeft() + dimensionPixelOffset + f + dimensionPixelOffset2;
        this.k = getY() + getPaddingTop() + dimensionPixelOffset + f + dimensionPixelOffset2;
        RectF rectF = new RectF();
        this.g = rectF;
        float f9 = this.f3723j;
        float f10 = dimensionPixelOffset2 / 2.0f;
        rectF.left = ((f9 - dimensionPixelOffset) - f) - f10;
        float f11 = this.k;
        rectF.top = ((f11 - dimensionPixelOffset) - f) - f10;
        rectF.right = f9 + dimensionPixelOffset + f + f10;
        rectF.bottom = f11 + dimensionPixelOffset + f + f10;
    }

    public final void a() {
        ObjectAnimator objectAnimator = this.d;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            this.n = 1;
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe(CircularAnimatedDrawable.START_ANGLE_PROPERTY, Keyframe.ofFloat(0.0f, -90.0f), Keyframe.ofFloat(0.5f, 330.0f), Keyframe.ofFloat(1.0f, 630.0f)), PropertyValuesHolder.ofFloat(CircularAnimatedDrawable.SWEEP_ANGLE_PROPERTY, 0.0f, -144.0f, 0.0f));
            objectAnimatorOfPropertyValuesHolder.setDuration(1760L);
            objectAnimatorOfPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            objectAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
            this.d = objectAnimatorOfPropertyValuesHolder;
            objectAnimatorOfPropertyValuesHolder.start();
        }
    }

    public int getBarBackgroundColor() {
        return this.l;
    }

    public int getBarColor() {
        return this.m;
    }

    public float getStartAngle() {
        return this.e;
    }

    public float getSweepAngle() {
        return this.f;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.d = null;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float width = getWidth() / 2;
        float f = this.h;
        float f7 = this.i;
        canvas.translate((width - f) - f7, ((getHeight() / 2) - f) - f7);
        int i = this.m;
        int i6 = this.l;
        Paint paint = this.b;
        if (i == i6) {
            paint.setAlpha(26);
        }
        if (this.n != 1) {
            super.onDraw(canvas);
            return;
        }
        canvas.drawArc(this.g, -90.0f, 360.0f, false, paint);
        float f9 = this.e;
        float f10 = this.f;
        RectF rectF = this.g;
        Paint paint2 = this.f3722a;
        canvas.drawArc(rectF, f9, f10, false, paint2);
        float fWidth = this.g.width() / 2.0f;
        float fHeight = this.g.height() / 2.0f;
        float strokeWidth = paint2.getStrokeWidth() / 2.0f;
        float fCos = this.g.right - (((float) (1.0d - Math.cos(Math.toRadians(this.e)))) * fWidth);
        float fSin = this.g.bottom - (((float) (1.0d - Math.sin(Math.toRadians(this.e)))) * fHeight);
        Paint paint3 = this.c;
        canvas.drawCircle(fCos, fSin, strokeWidth, paint3);
        canvas.drawCircle(this.g.right - (fWidth * ((float) (1.0d - Math.cos(Math.toRadians(this.f + this.e))))), this.g.bottom - (fHeight * ((float) (1.0d - Math.sin(Math.toRadians(this.f + this.e))))), strokeWidth, paint3);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(LoadingView.class.getName());
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i6) {
        int i10 = (int) ((this.h + this.i + 2.0f) * 2.0f);
        setMeasuredDimension(View.resolveSizeAndState(getPaddingRight() + getPaddingLeft() + i10, i, 0), View.resolveSizeAndState(getPaddingBottom() + getPaddingTop() + i10, i6, 0));
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (1 != this.n) {
            return;
        }
        if (i == 0) {
            if (isShown()) {
                a();
            }
        } else {
            ObjectAnimator objectAnimator = this.d;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                this.d = null;
            }
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (1 != this.n) {
            return;
        }
        if (i == 0) {
            if (isShown()) {
                a();
            }
        } else {
            ObjectAnimator objectAnimator = this.d;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                this.d = null;
            }
        }
    }

    public void setBarBackgroundColor(int i) {
        Paint paint = this.b;
        if (paint == null || paint.getColor() == i) {
            return;
        }
        paint.setColor(i);
        this.l = i;
        postInvalidate();
    }

    public void setBarColor(int i) {
        Paint paint = this.f3722a;
        if (paint == null || paint.getColor() == i) {
            return;
        }
        paint.setColor(i);
        this.c.setColor(i);
        this.m = i;
        postInvalidate();
    }

    public void setStartAngle(float f) {
        this.e = f;
        invalidate();
    }

    public void setSweepAngle(float f) {
        this.f = f;
        invalidate();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        ObjectAnimator objectAnimator;
        super.setVisibility(i);
        if (i == 0) {
            a();
        } else if ((i == 4 || i == 8) && (objectAnimator = this.d) != null) {
            objectAnimator.cancel();
            this.d = null;
        }
    }
}
