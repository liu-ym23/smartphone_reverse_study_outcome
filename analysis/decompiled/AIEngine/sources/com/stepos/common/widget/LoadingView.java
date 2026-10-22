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
import com.stepos.aiengine.R;
import com.stepos.common.drawble.CircularAnimatedDrawable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class LoadingView extends View {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f6936a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f6937b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f6938c;

    /* renamed from: d, reason: collision with root package name */
    public ObjectAnimator f6939d;

    /* renamed from: e, reason: collision with root package name */
    public float f6940e;
    public float h;

    /* renamed from: j, reason: collision with root package name */
    public final RectF f6941j;

    /* renamed from: k, reason: collision with root package name */
    public final float f6942k;

    /* renamed from: l, reason: collision with root package name */
    public final float f6943l;

    /* renamed from: m, reason: collision with root package name */
    public final float f6944m;

    /* renamed from: n, reason: collision with root package name */
    public final float f6945n;

    /* renamed from: o, reason: collision with root package name */
    public int f6946o;

    /* renamed from: p, reason: collision with root package name */
    public int f6947p;

    /* renamed from: q, reason: collision with root package name */
    public int f6948q;

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.StepOSCommon_LoadingViewStyle);
        this.f6936a = null;
        this.f6937b = null;
        this.f6938c = null;
        this.f6939d = null;
        this.f6941j = null;
        this.f6948q = 1;
        Paint paint = new Paint(1);
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(36.0f);
        int iB = l8.f.b(R.attr.colorPrimary, context);
        this.f6947p = context.getResources().getColor(iB == 0 ? R.color.fd_sys_color_primary_blue : iB);
        int iB2 = l8.f.b(R.attr.colorPrimaryContainer, context);
        this.f6946o = context.getResources().getColor(iB2 == 0 ? R.color.fd_sys_color_primary_container_blue : iB2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g8.a.h, R.attr.StepOSCommon_LoadingStyle, 0);
        float dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(5, 24);
        this.f6942k = dimensionPixelOffset;
        float dimensionPixelOffset2 = typedArrayObtainStyledAttributes.getDimensionPixelOffset(7, 10);
        this.f6943l = dimensionPixelOffset2;
        this.f6946o = typedArrayObtainStyledAttributes.getColor(1, this.f6946o);
        this.f6947p = typedArrayObtainStyledAttributes.getColor(3, this.f6947p);
        this.f6948q = typedArrayObtainStyledAttributes.getInt(6, 1);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint2 = new Paint(1);
        this.f6936a = paint2;
        paint2.setAntiAlias(true);
        paint2.setColor(this.f6947p);
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        Paint paint3 = new Paint(paint2);
        this.f6938c = paint3;
        paint3.setStyle(Paint.Style.FILL);
        Paint paint4 = new Paint(1);
        this.f6937b = paint4;
        paint4.setAntiAlias(true);
        paint4.setColor(this.f6946o);
        paint4.setStyle(style);
        float f8 = 0;
        float f9 = dimensionPixelOffset2 - f8;
        paint2.setStrokeWidth(f9);
        paint4.setStrokeWidth(f9);
        this.f6944m = getX() + getPaddingLeft() + dimensionPixelOffset + f8 + dimensionPixelOffset2;
        this.f6945n = getY() + getPaddingTop() + dimensionPixelOffset + f8 + dimensionPixelOffset2;
        RectF rectF = new RectF();
        this.f6941j = rectF;
        float f10 = this.f6944m;
        float f11 = dimensionPixelOffset2 / 2.0f;
        rectF.left = ((f10 - dimensionPixelOffset) - f8) - f11;
        float f12 = this.f6945n;
        rectF.top = ((f12 - dimensionPixelOffset) - f8) - f11;
        rectF.right = f10 + dimensionPixelOffset + f8 + f11;
        rectF.bottom = f12 + dimensionPixelOffset + f8 + f11;
    }

    public final void a() {
        ObjectAnimator objectAnimator = this.f6939d;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            this.f6948q = 1;
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe(CircularAnimatedDrawable.START_ANGLE_PROPERTY, Keyframe.ofFloat(0.0f, -90.0f), Keyframe.ofFloat(0.5f, 330.0f), Keyframe.ofFloat(1.0f, 630.0f)), PropertyValuesHolder.ofFloat(CircularAnimatedDrawable.SWEEP_ANGLE_PROPERTY, 0.0f, -144.0f, 0.0f));
            objectAnimatorOfPropertyValuesHolder.setDuration(1760L);
            objectAnimatorOfPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            objectAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
            this.f6939d = objectAnimatorOfPropertyValuesHolder;
            objectAnimatorOfPropertyValuesHolder.start();
        }
    }

    public int getBarBackgroundColor() {
        return this.f6946o;
    }

    public int getBarColor() {
        return this.f6947p;
    }

    public float getStartAngle() {
        return this.f6940e;
    }

    public float getSweepAngle() {
        return this.h;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.f6939d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f6939d = null;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float width = getWidth() / 2;
        float f8 = this.f6942k;
        float f9 = this.f6943l;
        canvas.translate((width - f8) - f9, ((getHeight() / 2) - f8) - f9);
        int i10 = this.f6947p;
        int i11 = this.f6946o;
        Paint paint = this.f6937b;
        if (i10 == i11) {
            paint.setAlpha(26);
        }
        if (this.f6948q != 1) {
            super.onDraw(canvas);
            return;
        }
        canvas.drawArc(this.f6941j, -90.0f, 360.0f, false, paint);
        float f10 = this.f6940e;
        float f11 = this.h;
        RectF rectF = this.f6941j;
        Paint paint2 = this.f6936a;
        canvas.drawArc(rectF, f10, f11, false, paint2);
        float fWidth = this.f6941j.width() / 2.0f;
        float fHeight = this.f6941j.height() / 2.0f;
        float strokeWidth = paint2.getStrokeWidth() / 2.0f;
        float fCos = this.f6941j.right - (((float) (1.0d - Math.cos(Math.toRadians(this.f6940e)))) * fWidth);
        float fSin = this.f6941j.bottom - (((float) (1.0d - Math.sin(Math.toRadians(this.f6940e)))) * fHeight);
        Paint paint3 = this.f6938c;
        canvas.drawCircle(fCos, fSin, strokeWidth, paint3);
        canvas.drawCircle(this.f6941j.right - (fWidth * ((float) (1.0d - Math.cos(Math.toRadians(this.h + this.f6940e))))), this.f6941j.bottom - (fHeight * ((float) (1.0d - Math.sin(Math.toRadians(this.h + this.f6940e))))), strokeWidth, paint3);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(LoadingView.class.getName());
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        int i12 = (int) ((this.f6942k + this.f6943l + 2.0f) * 2.0f);
        setMeasuredDimension(View.resolveSizeAndState(getPaddingRight() + getPaddingLeft() + i12, i10, 0), View.resolveSizeAndState(getPaddingBottom() + getPaddingTop() + i12, i11, 0));
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (1 != this.f6948q) {
            return;
        }
        if (i10 == 0) {
            if (isShown()) {
                a();
            }
        } else {
            ObjectAnimator objectAnimator = this.f6939d;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                this.f6939d = null;
            }
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        if (1 != this.f6948q) {
            return;
        }
        if (i10 == 0) {
            if (isShown()) {
                a();
            }
        } else {
            ObjectAnimator objectAnimator = this.f6939d;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                this.f6939d = null;
            }
        }
    }

    public void setBarBackgroundColor(int i10) {
        Paint paint = this.f6937b;
        if (paint == null || paint.getColor() == i10) {
            return;
        }
        paint.setColor(i10);
        this.f6946o = i10;
        postInvalidate();
    }

    public void setBarColor(int i10) {
        Paint paint = this.f6936a;
        if (paint == null || paint.getColor() == i10) {
            return;
        }
        paint.setColor(i10);
        this.f6938c.setColor(i10);
        this.f6947p = i10;
        postInvalidate();
    }

    public void setStartAngle(float f8) {
        this.f6940e = f8;
        invalidate();
    }

    public void setSweepAngle(float f8) {
        this.h = f8;
        invalidate();
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        ObjectAnimator objectAnimator;
        super.setVisibility(i10);
        if (i10 == 0) {
            a();
        } else if ((i10 == 4 || i10 == 8) && (objectAnimator = this.f6939d) != null) {
            objectAnimator.cancel();
            this.f6939d = null;
        }
    }
}
