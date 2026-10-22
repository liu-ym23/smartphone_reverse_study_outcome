package com.stepos.common.widget;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.LinearInterpolator;
import com.stepos.agentsafetycenter.R;
import com.stepos.common.drawble.CircularAnimatedDrawable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class LoadingView extends View {

    /* renamed from: c, reason: collision with root package name */
    public final Paint f2609c;

    /* renamed from: f, reason: collision with root package name */
    public final Paint f2610f;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f2611g;

    /* renamed from: h, reason: collision with root package name */
    public ObjectAnimator f2612h;
    public float i;

    /* renamed from: j, reason: collision with root package name */
    public float f2613j;

    /* renamed from: k, reason: collision with root package name */
    public RectF f2614k;

    /* renamed from: l, reason: collision with root package name */
    public final float f2615l;

    /* renamed from: m, reason: collision with root package name */
    public final float f2616m;

    /* renamed from: n, reason: collision with root package name */
    public float f2617n;

    /* renamed from: o, reason: collision with root package name */
    public float f2618o;

    /* renamed from: p, reason: collision with root package name */
    public int f2619p;

    /* renamed from: q, reason: collision with root package name */
    public int f2620q;

    /* renamed from: r, reason: collision with root package name */
    public int f2621r;

    public LoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2609c = null;
        this.f2610f = null;
        this.f2611g = null;
        this.f2612h = null;
        this.f2614k = null;
        this.f2621r = 1;
        Paint paint = new Paint(1);
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setAntiAlias(true);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(36.0f);
        int iJ = t1.e.j(R.attr.colorPrimary, context);
        this.f2620q = context.getResources().getColor(iJ == 0 ? R.color.fd_sys_color_primary_blue : iJ);
        int iJ2 = t1.e.j(R.attr.colorPrimaryContainer, context);
        this.f2619p = context.getResources().getColor(iJ2 == 0 ? R.color.fd_sys_color_primary_container_blue : iJ2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, q9.a.f10202e, R.attr.StepOSCommon_LoadingStyle, 0);
        this.f2615l = typedArrayObtainStyledAttributes.getDimensionPixelOffset(5, 24);
        float dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(7, 10);
        this.f2616m = dimensionPixelOffset;
        this.f2619p = typedArrayObtainStyledAttributes.getColor(1, this.f2619p);
        this.f2620q = typedArrayObtainStyledAttributes.getColor(3, this.f2620q);
        this.f2621r = typedArrayObtainStyledAttributes.getInt(6, 1);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint2 = new Paint(1);
        this.f2609c = paint2;
        paint2.setAntiAlias(true);
        paint2.setColor(this.f2620q);
        Paint.Style style = Paint.Style.STROKE;
        paint2.setStyle(style);
        Paint paint3 = new Paint(paint2);
        this.f2611g = paint3;
        paint3.setStyle(Paint.Style.FILL);
        Paint paint4 = new Paint(1);
        this.f2610f = paint4;
        paint4.setAntiAlias(true);
        paint4.setColor(this.f2619p);
        paint4.setStyle(style);
        float f5 = dimensionPixelOffset - 0;
        paint2.setStrokeWidth(f5);
        paint4.setStrokeWidth(f5);
        a();
    }

    public final void a() {
        float x6 = getX() + getPaddingLeft();
        float f5 = this.f2615l;
        float f10 = 0;
        float f11 = this.f2616m;
        this.f2617n = x6 + f5 + f10 + f11;
        this.f2618o = getY() + getPaddingTop() + f5 + f10 + f11;
        RectF rectF = new RectF();
        this.f2614k = rectF;
        float f12 = this.f2617n;
        float f13 = 0;
        float f14 = f11 / 2.0f;
        rectF.left = ((f12 - f5) - f13) - f14;
        float f15 = this.f2618o;
        rectF.top = ((f15 - f5) - f13) - f14;
        rectF.right = f12 + f5 + f13 + f14;
        rectF.bottom = f15 + f5 + f13 + f14;
    }

    public final void b() {
        ObjectAnimator objectAnimator = this.f2612h;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            this.f2621r = 1;
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe(CircularAnimatedDrawable.START_ANGLE_PROPERTY, Keyframe.ofFloat(0.0f, -90.0f), Keyframe.ofFloat(0.5f, 330.0f), Keyframe.ofFloat(1.0f, 630.0f)), PropertyValuesHolder.ofFloat(CircularAnimatedDrawable.SWEEP_ANGLE_PROPERTY, 0.0f, -144.0f, 0.0f));
            objectAnimatorOfPropertyValuesHolder.setDuration(1760L);
            objectAnimatorOfPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            objectAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
            this.f2612h = objectAnimatorOfPropertyValuesHolder;
            objectAnimatorOfPropertyValuesHolder.start();
        }
    }

    public int getBarBackgroundColor() {
        return this.f2619p;
    }

    public int getBarColor() {
        return this.f2620q;
    }

    public float getStartAngle() {
        return this.i;
    }

    public float getSweepAngle() {
        return this.f2613j;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ObjectAnimator objectAnimator = this.f2612h;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.f2612h = null;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float width = getWidth() / 2;
        float f5 = this.f2615l;
        float f10 = this.f2616m;
        canvas.translate((width - f5) - f10, ((getHeight() / 2) - f5) - f10);
        int i = this.f2620q;
        int i3 = this.f2619p;
        Paint paint = this.f2610f;
        if (i == i3) {
            paint.setAlpha(26);
        }
        if (this.f2621r != 1) {
            super.onDraw(canvas);
            return;
        }
        canvas.drawArc(this.f2614k, -90.0f, 360.0f, false, paint);
        RectF rectF = this.f2614k;
        float f11 = this.i;
        float f12 = this.f2613j;
        Paint paint2 = this.f2609c;
        canvas.drawArc(rectF, f11, f12, false, paint2);
        float fWidth = this.f2614k.width() / 2.0f;
        float fHeight = this.f2614k.height() / 2.0f;
        float strokeWidth = paint2.getStrokeWidth() / 2.0f;
        float fCos = this.f2614k.right - (((float) (1.0d - Math.cos(Math.toRadians(this.i)))) * fWidth);
        float fSin = this.f2614k.bottom - (((float) (1.0d - Math.sin(Math.toRadians(this.i)))) * fHeight);
        Paint paint3 = this.f2611g;
        canvas.drawCircle(fCos, fSin, strokeWidth, paint3);
        canvas.drawCircle(this.f2614k.right - (fWidth * ((float) (1.0d - Math.cos(Math.toRadians(this.f2613j + this.i))))), this.f2614k.bottom - (fHeight * ((float) (1.0d - Math.sin(Math.toRadians(this.f2613j + this.i))))), strokeWidth, paint3);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(LoadingView.class.getName());
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i3) {
        int i10 = (int) ((this.f2615l + this.f2616m + 2.0f) * 2.0f);
        setMeasuredDimension(View.resolveSizeAndState(getPaddingRight() + getPaddingLeft() + i10, i, 0), View.resolveSizeAndState(getPaddingBottom() + getPaddingTop() + i10, i3, 0));
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (1 != this.f2621r) {
            return;
        }
        if (i == 0) {
            if (isShown()) {
                b();
            }
        } else {
            ObjectAnimator objectAnimator = this.f2612h;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                this.f2612h = null;
            }
        }
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (1 != this.f2621r) {
            return;
        }
        if (i == 0) {
            if (isShown()) {
                b();
            }
        } else {
            ObjectAnimator objectAnimator = this.f2612h;
            if (objectAnimator != null) {
                objectAnimator.cancel();
                this.f2612h = null;
            }
        }
    }

    public void setBarBackgroundColor(int i) {
        Paint paint = this.f2610f;
        if (paint == null || paint.getColor() == i) {
            return;
        }
        paint.setColor(i);
        this.f2619p = i;
        postInvalidate();
    }

    public void setBarColor(int i) {
        Paint paint = this.f2609c;
        if (paint == null || paint.getColor() == i) {
            return;
        }
        paint.setColor(i);
        this.f2611g.setColor(i);
        this.f2620q = i;
        postInvalidate();
    }

    public void setStartAngle(float f5) {
        this.i = f5;
        invalidate();
    }

    public void setSweepAngle(float f5) {
        this.f2613j = f5;
        invalidate();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        ObjectAnimator objectAnimator;
        super.setVisibility(i);
        if (i == 0) {
            b();
        } else if ((i == 4 || i == 8) && (objectAnimator = this.f2612h) != null) {
            objectAnimator.cancel();
            this.f2612h = null;
        }
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.StepOSCommon_LoadingViewStyle);
    }

    public LoadingView(Context context) {
        this(context, null);
    }

    public LoadingView(Context context, float f5, float f10) {
        this(context, null);
        this.f2615l = f5;
        this.f2616m = f10;
        a();
    }
}
