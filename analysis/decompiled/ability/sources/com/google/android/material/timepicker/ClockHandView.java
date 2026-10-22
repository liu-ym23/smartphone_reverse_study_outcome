package com.google.android.material.timepicker;

import D7.N;
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
import com.stepos.ability.R;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
class ClockHandView extends View {
    public static final /* synthetic */ int n = 0;

    /* renamed from: a, reason: collision with root package name */
    public final ValueAnimator f2707a;
    public boolean b;
    public final ArrayList c;
    public final int d;
    public final float e;
    public final Paint f;
    public final RectF g;
    public final int h;
    public float i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2708j;
    public double k;
    public int l;
    public int m;

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f2707a = valueAnimator;
        this.c = new ArrayList();
        Paint paint = new Paint();
        this.f = paint;
        this.g = new RectF();
        this.m = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, P2.a.g, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        N.N(context, R.attr.motionDurationLong2, 200);
        N.O(context, R.attr.motionEasingEmphasizedInterpolator, Q2.a.b);
        this.l = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.d = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.h = getResources().getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.e = r5.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        b(0.0f);
        ViewConfiguration.get(context).getScaledTouchSlop();
        setImportantForAccessibility(2);
        typedArrayObtainStyledAttributes.recycle();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.timepicker.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                int i = ClockHandView.n;
                this.f2713a.c(((Float) valueAnimator2.getAnimatedValue()).floatValue());
            }
        });
        valueAnimator.addListener(new e());
    }

    public final int a(int i) {
        int i6 = this.l;
        return i == 2 ? Math.round(i6 * 0.66f) : i6;
    }

    public final void b(float f) {
        this.f2707a.cancel();
        c(f);
    }

    public final void c(float f) {
        float f7 = f % 360.0f;
        this.i = f7;
        this.k = Math.toRadians(f7 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float fA = a(this.m);
        float fCos = (((float) Math.cos(this.k)) * fA) + width;
        float fSin = (fA * ((float) Math.sin(this.k))) + height;
        float f9 = this.d;
        this.g.set(fCos - f9, fSin - f9, fCos + f9, fSin + f9);
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ClockFaceView clockFaceView = (ClockFaceView) ((f) it.next());
            if (Math.abs(clockFaceView.f2705q - f7) > 0.001f) {
                clockFaceView.f2705q = f7;
                clockFaceView.b();
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f = width;
        float fA = a(this.m);
        float fCos = (((float) Math.cos(this.k)) * fA) + f;
        float f7 = height;
        float fSin = (fA * ((float) Math.sin(this.k))) + f7;
        Paint paint = this.f;
        paint.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.d, paint);
        double dSin = Math.sin(this.k);
        paint.setStrokeWidth(this.h);
        canvas.drawLine(f, f7, width + ((int) (Math.cos(this.k) * d)), height + ((int) (d * dSin)), paint);
        canvas.drawCircle(f, f7, this.e, paint);
    }

    @Override // android.view.View
    public final void onLayout(boolean z10, int i, int i6, int i10, int i11) {
        super.onLayout(z10, i, i6, i10, i11);
        if (this.f2707a.isRunning()) {
            return;
        }
        b(this.i);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        boolean z11;
        int actionMasked = motionEvent.getActionMasked();
        float x10 = motionEvent.getX();
        float y = motionEvent.getY();
        boolean z12 = false;
        if (actionMasked == 0) {
            this.f2708j = false;
            z10 = true;
            z11 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            z11 = this.f2708j;
            if (this.b) {
                this.m = ((float) Math.hypot((double) (x10 - ((float) (getWidth() / 2))), (double) (y - ((float) (getHeight() / 2))))) <= ((float) a(2)) + TypedValue.applyDimension(1, (float) 12, getContext().getResources().getDisplayMetrics()) ? 2 : 1;
            }
            z10 = false;
        } else {
            z11 = false;
            z10 = false;
        }
        boolean z13 = this.f2708j;
        int degrees = (int) Math.toDegrees(Math.atan2(y - (getHeight() / 2), x10 - (getWidth() / 2)));
        int i = degrees + 90;
        if (i < 0) {
            i = degrees + 450;
        }
        float f = i;
        boolean z14 = this.i != f;
        if (z10 && z14) {
            z12 = true;
        } else if (z14 || z11) {
            b(f);
            z12 = true;
        }
        this.f2708j = z13 | z12;
        return true;
    }
}
