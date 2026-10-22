package com.stepos.common.widget;

import android.animation.Animator;
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
import com.stepos.common.drawble.CircularAnimatedDrawable;

/* loaded from: classes.dex */
public class LoadingView extends View {

    /* renamed from: a, reason: collision with root package name */
    private Paint f14024a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f14025b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f14026c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f14027d;

    /* renamed from: e, reason: collision with root package name */
    private Context f14028e;

    /* renamed from: f, reason: collision with root package name */
    private Animator f14029f;

    /* renamed from: g, reason: collision with root package name */
    private float f14030g;

    /* renamed from: h, reason: collision with root package name */
    private float f14031h;

    /* renamed from: i, reason: collision with root package name */
    private final long f14032i;

    /* renamed from: j, reason: collision with root package name */
    private RectF f14033j;

    /* renamed from: k, reason: collision with root package name */
    private int f14034k;

    /* renamed from: l, reason: collision with root package name */
    private float f14035l;

    /* renamed from: m, reason: collision with root package name */
    private float f14036m;

    /* renamed from: n, reason: collision with root package name */
    private float f14037n;

    /* renamed from: o, reason: collision with root package name */
    private float f14038o;

    /* renamed from: p, reason: collision with root package name */
    private int f14039p;

    /* renamed from: q, reason: collision with root package name */
    private int f14040q;

    /* renamed from: r, reason: collision with root package name */
    private int f14041r;

    public LoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, H1.c.f2058e);
    }

    private Animator a() {
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this, PropertyValuesHolder.ofKeyframe(CircularAnimatedDrawable.START_ANGLE_PROPERTY, Keyframe.ofFloat(0.0f, -90.0f), Keyframe.ofFloat(0.5f, 330.0f), Keyframe.ofFloat(1.0f, 630.0f)), PropertyValuesHolder.ofFloat(CircularAnimatedDrawable.SWEEP_ANGLE_PROPERTY, 0.0f, -144.0f, 0.0f));
        objectAnimatorOfPropertyValuesHolder.setDuration(1760L);
        objectAnimatorOfPropertyValuesHolder.setInterpolator(new LinearInterpolator());
        objectAnimatorOfPropertyValuesHolder.setRepeatCount(-1);
        return objectAnimatorOfPropertyValuesHolder;
    }

    private void b(Canvas canvas) {
        canvas.drawArc(this.f14033j, -90.0f, 360.0f, false, this.f14026c);
        canvas.drawArc(this.f14033j, this.f14030g, this.f14031h, false, this.f14025b);
        float fWidth = this.f14033j.width() / 2.0f;
        float fHeight = this.f14033j.height() / 2.0f;
        float strokeWidth = this.f14025b.getStrokeWidth() / 2.0f;
        canvas.drawCircle(this.f14033j.right - (((float) (1.0d - Math.cos(Math.toRadians(this.f14030g)))) * fWidth), this.f14033j.bottom - (((float) (1.0d - Math.sin(Math.toRadians(this.f14030g)))) * fHeight), strokeWidth, this.f14027d);
        canvas.drawCircle(this.f14033j.right - (fWidth * ((float) (1.0d - Math.cos(Math.toRadians(this.f14031h + this.f14030g))))), this.f14033j.bottom - (fHeight * ((float) (1.0d - Math.sin(Math.toRadians(this.f14031h + this.f14030g))))), strokeWidth, this.f14027d);
    }

    private void c() {
        this.f14037n = getX() + getPaddingLeft() + this.f14035l + (this.f14034k * 2) + this.f14036m;
        this.f14038o = getY() + getPaddingTop() + this.f14035l + (this.f14034k * 2) + this.f14036m;
        RectF rectF = new RectF();
        this.f14033j = rectF;
        float f5 = this.f14037n;
        float f6 = this.f14035l;
        int i5 = this.f14034k;
        float f7 = this.f14036m;
        rectF.left = ((f5 - f6) - (i5 / 2)) - (f7 / 2.0f);
        float f8 = this.f14038o;
        rectF.top = ((f8 - f6) - (i5 / 2)) - (f7 / 2.0f);
        rectF.right = f5 + f6 + (i5 / 2) + (f7 / 2.0f);
        rectF.bottom = f8 + f6 + (i5 / 2) + (f7 / 2.0f);
    }

    private void e() {
        Animator animator = this.f14029f;
        if (animator == null || !animator.isRunning()) {
            this.f14041r = 1;
            Animator animatorA = a();
            this.f14029f = animatorA;
            animatorA.start();
        }
    }

    public void d() {
        e();
    }

    public void f() {
        Animator animator = this.f14029f;
        if (animator != null) {
            animator.cancel();
            this.f14029f = null;
        }
    }

    public int getBarBackgroundColor() {
        return this.f14039p;
    }

    public int getBarColor() {
        return this.f14040q;
    }

    public float getStartAngle() {
        return this.f14030g;
    }

    public float getSweepAngle() {
        return this.f14031h;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Animator animator = this.f14029f;
        if (animator != null) {
            animator.cancel();
            this.f14029f = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.translate(((getWidth() / 2) - this.f14035l) - this.f14036m, ((getHeight() / 2) - this.f14035l) - this.f14036m);
        if (this.f14040q == this.f14039p) {
            this.f14026c.setAlpha(26);
        }
        if (this.f14041r == 1) {
            b(canvas);
        } else {
            super.onDraw(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(LoadingView.class.getName());
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        int i7 = (int) ((this.f14035l + this.f14036m + 2.0f) * 2.0f);
        setMeasuredDimension(View.resolveSizeAndState(getPaddingLeft() + getPaddingRight() + i7, i5, 0), View.resolveSizeAndState(i7 + getPaddingTop() + getPaddingBottom(), i6, 0));
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i5) {
        super.onVisibilityChanged(view, i5);
        if (1 != this.f14041r) {
            return;
        }
        if (i5 == 0) {
            if (isShown()) {
                e();
            }
        } else {
            Animator animator = this.f14029f;
            if (animator != null) {
                animator.cancel();
                this.f14029f = null;
            }
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i5) {
        super.onWindowVisibilityChanged(i5);
        if (1 != this.f14041r) {
            return;
        }
        if (i5 == 0) {
            if (isShown()) {
                e();
            }
        } else {
            Animator animator = this.f14029f;
            if (animator != null) {
                animator.cancel();
                this.f14029f = null;
            }
        }
    }

    public void setBarBackgroundColor(int i5) {
        Paint paint = this.f14026c;
        if (paint == null || paint.getColor() == i5) {
            return;
        }
        this.f14026c.setColor(i5);
        this.f14039p = i5;
        postInvalidate();
    }

    public void setBarColor(int i5) {
        Paint paint = this.f14025b;
        if (paint == null || paint.getColor() == i5) {
            return;
        }
        this.f14025b.setColor(i5);
        this.f14027d.setColor(i5);
        this.f14040q = i5;
        postInvalidate();
    }

    public void setStartAngle(float f5) {
        this.f14030g = f5;
        invalidate();
    }

    public void setSweepAngle(float f5) {
        this.f14031h = f5;
        invalidate();
    }

    @Override // android.view.View
    public void setVisibility(int i5) {
        Animator animator;
        super.setVisibility(i5);
        if (i5 == 0) {
            e();
        } else if ((i5 == 4 || i5 == 8) && (animator = this.f14029f) != null) {
            animator.cancel();
            this.f14029f = null;
        }
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f14024a = null;
        this.f14025b = null;
        this.f14026c = null;
        this.f14027d = null;
        this.f14029f = null;
        this.f14032i = 1760L;
        this.f14033j = null;
        this.f14034k = 0;
        this.f14041r = 1;
        this.f14028e = context;
        Paint paint = new Paint(1);
        this.f14024a = paint;
        paint.setAntiAlias(true);
        this.f14024a.setColor(-1);
        this.f14024a.setAntiAlias(true);
        this.f14024a.setTextAlign(Paint.Align.CENTER);
        this.f14024a.setTextSize(36.0f);
        int iD = N1.i.d(H1.c.f2066m, context);
        this.f14040q = context.getResources().getColor(iD == 0 ? H1.e.f2084f : iD);
        int iD2 = N1.i.d(H1.c.f2067n, context);
        this.f14039p = context.getResources().getColor(iD2 == 0 ? H1.e.f2085g : iD2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, H1.m.f2687x2, H1.c.f2057d, 0);
        this.f14035l = typedArrayObtainStyledAttributes.getDimensionPixelOffset(H1.m.f2388A2, 24);
        this.f14036m = typedArrayObtainStyledAttributes.getDimensionPixelOffset(H1.m.f2400C2, 10);
        this.f14039p = typedArrayObtainStyledAttributes.getColor(H1.m.f2693y2, this.f14039p);
        this.f14040q = typedArrayObtainStyledAttributes.getColor(H1.m.f2699z2, this.f14040q);
        this.f14041r = typedArrayObtainStyledAttributes.getInt(H1.m.f2394B2, 1);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint2 = new Paint(1);
        this.f14025b = paint2;
        paint2.setAntiAlias(true);
        this.f14025b.setColor(this.f14040q);
        Paint paint3 = this.f14025b;
        Paint.Style style = Paint.Style.STROKE;
        paint3.setStyle(style);
        Paint paint4 = new Paint(this.f14025b);
        this.f14027d = paint4;
        paint4.setStyle(Paint.Style.FILL);
        Paint paint5 = new Paint(1);
        this.f14026c = paint5;
        paint5.setAntiAlias(true);
        this.f14026c.setColor(this.f14039p);
        this.f14026c.setStyle(style);
        this.f14025b.setStrokeWidth(this.f14036m - this.f14034k);
        this.f14026c.setStrokeWidth(this.f14036m - this.f14034k);
        c();
    }
}
