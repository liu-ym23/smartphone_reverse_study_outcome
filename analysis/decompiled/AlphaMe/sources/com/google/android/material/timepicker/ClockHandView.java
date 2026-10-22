package com.google.android.material.timepicker;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Nullable;
import com.stepos.alphame.R;
import com.stepos.alphame.utils.Property;
import java.util.ArrayList;
import java.util.Iterator;
import m1.AbstractC0769a;
import n1.AbstractC0775a;

/* loaded from: classes.dex */
class ClockHandView extends View {

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f11141n = 0;

    /* renamed from: a, reason: collision with root package name */
    public final ValueAnimator f11142a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11143b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f11144c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11145d;

    /* renamed from: e, reason: collision with root package name */
    public final float f11146e;

    /* renamed from: f, reason: collision with root package name */
    public final Paint f11147f;

    /* renamed from: g, reason: collision with root package name */
    public final RectF f11148g;

    /* renamed from: h, reason: collision with root package name */
    public final int f11149h;

    /* renamed from: i, reason: collision with root package name */
    public float f11150i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f11151j;

    /* renamed from: k, reason: collision with root package name */
    public double f11152k;

    /* renamed from: l, reason: collision with root package name */
    public int f11153l;

    /* renamed from: m, reason: collision with root package name */
    public int f11154m;

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f11142a = valueAnimator;
        this.f11144c = new ArrayList();
        Paint paint = new Paint();
        this.f11147f = paint;
        this.f11148g = new RectF();
        this.f11154m = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0769a.f13541g, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        com.stepos.statsrpk.c.L(context, R.attr.motionDurationLong2, 200);
        com.stepos.statsrpk.c.M(context, R.attr.motionEasingEmphasizedInterpolator, AbstractC0775a.f13651b);
        this.f11153l = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f11145d = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f11149h = getResources().getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.f11146e = r5.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        b(Property.DEFAULT_FLOAT_VALUE);
        ViewConfiguration.get(context).getScaledTouchSlop();
        setImportantForAccessibility(2);
        typedArrayObtainStyledAttributes.recycle();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.timepicker.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                int i4 = ClockHandView.f11141n;
                ClockHandView clockHandView = this.f11164a;
                clockHandView.getClass();
                clockHandView.c(((Float) valueAnimator2.getAnimatedValue()).floatValue());
            }
        });
        valueAnimator.addListener(new e());
    }

    public final int a(int i4) {
        int i5 = this.f11153l;
        return i4 == 2 ? Math.round(i5 * 0.66f) : i5;
    }

    public final void b(float f4) {
        this.f11142a.cancel();
        c(f4);
    }

    public final void c(float f4) {
        float f5 = f4 % 360.0f;
        this.f11150i = f5;
        this.f11152k = Math.toRadians(f5 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float fA = a(this.f11154m);
        float fCos = (((float) Math.cos(this.f11152k)) * fA) + width;
        float fSin = (fA * ((float) Math.sin(this.f11152k))) + height;
        float f6 = this.f11145d;
        this.f11148g.set(fCos - f6, fSin - f6, fCos + f6, fSin + f6);
        Iterator it = this.f11144c.iterator();
        while (it.hasNext()) {
            ClockFaceView clockFaceView = (ClockFaceView) ((f) it.next());
            if (Math.abs(clockFaceView.f11134I - f5) > 0.001f) {
                clockFaceView.f11134I = f5;
                clockFaceView.j();
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f4 = width;
        float fA = a(this.f11154m);
        float fCos = (((float) Math.cos(this.f11152k)) * fA) + f4;
        float f5 = height;
        float fSin = (fA * ((float) Math.sin(this.f11152k))) + f5;
        Paint paint = this.f11147f;
        paint.setStrokeWidth(Property.DEFAULT_FLOAT_VALUE);
        canvas.drawCircle(fCos, fSin, this.f11145d, paint);
        double dSin = Math.sin(this.f11152k);
        paint.setStrokeWidth(this.f11149h);
        canvas.drawLine(f4, f5, width + ((int) (Math.cos(this.f11152k) * d)), height + ((int) (d * dSin)), paint);
        canvas.drawCircle(f4, f5, this.f11146e, paint);
    }

    @Override // android.view.View
    public final void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        if (this.f11142a.isRunning()) {
            return;
        }
        b(this.f11150i);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z4;
        boolean z5;
        int actionMasked = motionEvent.getActionMasked();
        float x4 = motionEvent.getX();
        float y4 = motionEvent.getY();
        boolean z6 = false;
        if (actionMasked == 0) {
            this.f11151j = false;
            z4 = true;
            z5 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            z5 = this.f11151j;
            if (this.f11143b) {
                this.f11154m = ((float) Math.hypot((double) (x4 - ((float) (getWidth() / 2))), (double) (y4 - ((float) (getHeight() / 2))))) <= ((float) a(2)) + TypedValue.applyDimension(1, (float) 12, getContext().getResources().getDisplayMetrics()) ? 2 : 1;
            }
            z4 = false;
        } else {
            z5 = false;
            z4 = false;
        }
        boolean z7 = this.f11151j;
        int degrees = (int) Math.toDegrees(Math.atan2(y4 - (getHeight() / 2), x4 - (getWidth() / 2)));
        int i4 = degrees + 90;
        if (i4 < 0) {
            i4 = degrees + 450;
        }
        float f4 = i4;
        boolean z8 = this.f11150i != f4;
        if (z4 && z8) {
            z6 = true;
        } else if (z8 || z5) {
            b(f4);
            z6 = true;
        }
        this.f11151j = z7 | z6;
        return true;
    }
}
