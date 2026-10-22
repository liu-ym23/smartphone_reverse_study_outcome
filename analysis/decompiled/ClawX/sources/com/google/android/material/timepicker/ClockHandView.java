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
import com.stepos.stepclaw.R;
import java.util.ArrayList;
import k4.v;
import org.bouncycastle.asn1.x509.DisplayText;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
class ClockHandView extends View {

    /* renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f1403o = 0;

    /* renamed from: a, reason: collision with root package name */
    public final ValueAnimator f1404a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1405b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f1406c;
    public final int d;

    /* renamed from: e, reason: collision with root package name */
    public final float f1407e;

    /* renamed from: f, reason: collision with root package name */
    public final Paint f1408f;

    /* renamed from: g, reason: collision with root package name */
    public final RectF f1409g;

    /* renamed from: h, reason: collision with root package name */
    public final int f1410h;

    /* renamed from: j, reason: collision with root package name */
    public float f1411j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1412k;

    /* renamed from: l, reason: collision with root package name */
    public double f1413l;

    /* renamed from: m, reason: collision with root package name */
    public int f1414m;

    /* renamed from: n, reason: collision with root package name */
    public int f1415n;

    public ClockHandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f1404a = valueAnimator;
        this.f1406c = new ArrayList();
        Paint paint = new Paint();
        this.f1408f = paint;
        this.f1409g = new RectF();
        this.f1415n = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d1.a.f1763e, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        v.g0(context, R.attr.motionDurationLong2, DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE);
        v.h0(context, R.attr.motionEasingEmphasizedInterpolator, e1.a.f2340b);
        this.f1414m = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.d = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.f1410h = getResources().getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.f1407e = r5.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
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
                int i8 = ClockHandView.f1403o;
                this.f1420a.c(((Float) valueAnimator2.getAnimatedValue()).floatValue());
            }
        });
        valueAnimator.addListener(new e());
    }

    public final int a(int i8) {
        int i9 = this.f1414m;
        return i8 == 2 ? Math.round(i9 * 0.66f) : i9;
    }

    public final void b(float f3) {
        this.f1404a.cancel();
        c(f3);
    }

    public final void c(float f3) {
        float f7 = f3 % 360.0f;
        this.f1411j = f7;
        this.f1413l = Math.toRadians(f7 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float fA = a(this.f1415n);
        float fCos = (((float) Math.cos(this.f1413l)) * fA) + width;
        float fSin = (fA * ((float) Math.sin(this.f1413l))) + height;
        float f9 = this.d;
        this.f1409g.set(fCos - f9, fSin - f9, fCos + f9, fSin + f9);
        ArrayList arrayList = this.f1406c;
        int size = arrayList.size();
        int i8 = 0;
        while (i8 < size) {
            Object obj = arrayList.get(i8);
            i8++;
            ClockFaceView clockFaceView = (ClockFaceView) ((f) obj);
            if (Math.abs(clockFaceView.J - f7) > 0.001f) {
                clockFaceView.J = f7;
                clockFaceView.n();
            }
        }
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f3 = width;
        float fA = a(this.f1415n);
        float fCos = (((float) Math.cos(this.f1413l)) * fA) + f3;
        float f7 = height;
        float fSin = (fA * ((float) Math.sin(this.f1413l))) + f7;
        Paint paint = this.f1408f;
        paint.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.d, paint);
        double dSin = Math.sin(this.f1413l);
        paint.setStrokeWidth(this.f1410h);
        canvas.drawLine(f3, f7, width + ((int) (Math.cos(this.f1413l) * d)), height + ((int) (d * dSin)), paint);
        canvas.drawCircle(f3, f7, this.f1407e, paint);
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i8, int i9, int i10, int i11) {
        super.onLayout(z, i8, i9, i10, i11);
        if (this.f1404a.isRunning()) {
            return;
        }
        b(this.f1411j);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        int actionMasked = motionEvent.getActionMasked();
        float x7 = motionEvent.getX();
        float y = motionEvent.getY();
        boolean z8 = false;
        if (actionMasked == 0) {
            this.f1412k = false;
            z = true;
            z2 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            z2 = this.f1412k;
            if (this.f1405b) {
                this.f1415n = ((float) Math.hypot((double) (x7 - ((float) (getWidth() / 2))), (double) (y - ((float) (getHeight() / 2))))) <= ((float) a(2)) + TypedValue.applyDimension(1, (float) 12, getContext().getResources().getDisplayMetrics()) ? 2 : 1;
            }
            z = false;
        } else {
            z2 = false;
            z = false;
        }
        boolean z9 = this.f1412k;
        int degrees = (int) Math.toDegrees(Math.atan2(y - (getHeight() / 2), x7 - (getWidth() / 2)));
        int i8 = degrees + 90;
        if (i8 < 0) {
            i8 = degrees + 450;
        }
        float f3 = i8;
        boolean z10 = this.f1411j != f3;
        if (z && z10) {
            z8 = true;
        } else if (z10 || z2) {
            b(f3);
            z8 = true;
        }
        this.f1412k = z9 | z8;
        return true;
    }
}
