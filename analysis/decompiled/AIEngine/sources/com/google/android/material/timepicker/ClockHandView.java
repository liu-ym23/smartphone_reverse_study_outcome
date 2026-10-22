package com.google.android.material.timepicker;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import com.stepos.aiengine.R;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
class ClockHandView extends View {

    /* renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f5351y = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f5352a;

    /* renamed from: b, reason: collision with root package name */
    public final TimeInterpolator f5353b;

    /* renamed from: c, reason: collision with root package name */
    public final ValueAnimator f5354c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f5355d;

    /* renamed from: e, reason: collision with root package name */
    public float f5356e;
    public float h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f5357j;

    /* renamed from: k, reason: collision with root package name */
    public final int f5358k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5359l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f5360m;

    /* renamed from: n, reason: collision with root package name */
    public final int f5361n;

    /* renamed from: o, reason: collision with root package name */
    public final float f5362o;

    /* renamed from: p, reason: collision with root package name */
    public final Paint f5363p;

    /* renamed from: q, reason: collision with root package name */
    public final RectF f5364q;
    public final int r;

    /* renamed from: s, reason: collision with root package name */
    public float f5365s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f5366t;

    /* renamed from: u, reason: collision with root package name */
    public j f5367u;

    /* renamed from: v, reason: collision with root package name */
    public double f5368v;

    /* renamed from: w, reason: collision with root package name */
    public int f5369w;

    /* renamed from: x, reason: collision with root package name */
    public int f5370x;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
        void a(float f8, boolean z);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.f5354c = valueAnimator;
        this.f5360m = new ArrayList();
        Paint paint = new Paint();
        this.f5363p = paint;
        this.f5364q = new RectF();
        this.f5370x = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k4.a.f9903g, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        this.f5352a = u4.j.c(context, R.attr.motionDurationLong2, 200);
        this.f5353b = u4.j.d(context, R.attr.motionEasingEmphasizedInterpolator, l4.a.f10221b);
        this.f5369w = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f5361n = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.r = getResources().getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.f5362o = r5.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        c(0.0f, false);
        this.f5358k = ViewConfiguration.get(context).getScaledTouchSlop();
        setImportantForAccessibility(2);
        typedArrayObtainStyledAttributes.recycle();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.timepicker.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                int i10 = ClockHandView.f5351y;
                ClockHandView clockHandView = this.f5384a;
                clockHandView.getClass();
                clockHandView.d(((Float) valueAnimator2.getAnimatedValue()).floatValue(), true);
            }
        });
        valueAnimator.addListener(new e());
    }

    public final int a(float f8, float f9) {
        int degrees = (int) Math.toDegrees(Math.atan2(f9 - (getHeight() / 2), f8 - (getWidth() / 2)));
        int i10 = degrees + 90;
        return i10 < 0 ? degrees + 450 : i10;
    }

    public final int b(int i10) {
        int i11 = this.f5369w;
        return i10 == 2 ? Math.round(i11 * 0.66f) : i11;
    }

    public final void c(float f8, boolean z) {
        ValueAnimator valueAnimator = this.f5354c;
        valueAnimator.cancel();
        if (!z) {
            d(f8, false);
            return;
        }
        float f9 = this.f5365s;
        if (Math.abs(f9 - f8) > 180.0f) {
            if (f9 > 180.0f && f8 < 180.0f) {
                f8 += 360.0f;
            }
            if (f9 < 180.0f && f8 > 180.0f) {
                f9 += 360.0f;
            }
        }
        Pair pair = new Pair(Float.valueOf(f9), Float.valueOf(f8));
        valueAnimator.setFloatValues(((Float) pair.first).floatValue(), ((Float) pair.second).floatValue());
        valueAnimator.setDuration(this.f5352a);
        valueAnimator.setInterpolator(this.f5353b);
        valueAnimator.start();
    }

    public final void d(float f8, boolean z) {
        float f9 = f8 % 360.0f;
        this.f5365s = f9;
        this.f5368v = Math.toRadians(f9 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float fB = b(this.f5370x);
        float fCos = (((float) Math.cos(this.f5368v)) * fB) + width;
        float fSin = (fB * ((float) Math.sin(this.f5368v))) + height;
        float f10 = this.f5361n;
        this.f5364q.set(fCos - f10, fSin - f10, fCos + f10, fSin + f10);
        ArrayList arrayList = this.f5360m;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((a) obj).a(f9, z);
        }
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f8 = width;
        float fB = b(this.f5370x);
        float fCos = (((float) Math.cos(this.f5368v)) * fB) + f8;
        float f9 = height;
        float fSin = (fB * ((float) Math.sin(this.f5368v))) + f9;
        Paint paint = this.f5363p;
        paint.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.f5361n, paint);
        double dSin = Math.sin(this.f5368v);
        paint.setStrokeWidth(this.r);
        canvas.drawLine(f8, f9, width + ((int) (Math.cos(this.f5368v) * d)), height + ((int) (d * dSin)), paint);
        canvas.drawCircle(f8, f9, this.f5362o, paint);
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i10, int i11, int i12, int i13) {
        super.onLayout(z, i10, i11, i12, i13);
        if (this.f5354c.isRunning()) {
            return;
        }
        c(this.f5365s, false);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z3;
        boolean z10;
        boolean z11;
        j jVar;
        int actionMasked = motionEvent.getActionMasked();
        float x3 = motionEvent.getX();
        float y3 = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 2) {
                int i10 = (int) (x3 - this.f5356e);
                int i11 = (int) (y3 - this.h);
                this.f5357j = (i11 * i11) + (i10 * i10) > this.f5358k;
                z10 = this.f5366t;
                z3 = actionMasked == 1;
                if (this.f5359l) {
                    this.f5370x = ((float) Math.hypot((double) (x3 - ((float) (getWidth() / 2))), (double) (y3 - ((float) (getHeight() / 2))))) > ((float) b(2)) + TypedValue.applyDimension(1, (float) 12, getContext().getResources().getDisplayMetrics()) ? 1 : 2;
                }
                z = false;
            } else {
                z3 = false;
                z = false;
                z10 = false;
            }
        } else {
            this.f5356e = x3;
            this.h = y3;
            this.f5357j = true;
            this.f5366t = false;
            z = true;
            z3 = false;
            z10 = false;
        }
        boolean z12 = this.f5366t;
        float fA = a(x3, y3);
        boolean z13 = this.f5365s != fA;
        if (z && z13) {
            z11 = true;
        } else if (z13 || z10) {
            c(fA, z3 && this.f5355d);
            z11 = true;
        } else {
            z11 = false;
        }
        boolean z14 = z11 | z12;
        this.f5366t = z14;
        if (z14 && z3 && (jVar = this.f5367u) != null) {
            TimeModel timeModel = jVar.f5394b;
            TimePickerView timePickerView = jVar.f5393a;
            float fA2 = a(x3, y3);
            boolean z15 = this.f5357j;
            jVar.f5397e = true;
            int i12 = timeModel.minute;
            int i13 = timeModel.hour;
            if (timeModel.selection == 10) {
                timePickerView.f5376v.c(jVar.f5396d, false);
                AccessibilityManager accessibilityManager = (AccessibilityManager) timePickerView.getContext().getSystemService(AccessibilityManager.class);
                if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
                    jVar.b(12, true);
                }
            } else {
                int iRound = Math.round(fA2);
                if (!z15) {
                    timeModel.setMinute(((iRound + 15) / 30) * 5);
                    jVar.f5395c = timeModel.minute * 6;
                }
                timePickerView.f5376v.c(jVar.f5395c, z15);
            }
            jVar.f5397e = false;
            jVar.c();
            if (timeModel.minute != i12 || timeModel.hour != i13) {
                timePickerView.performHapticFeedback(4);
            }
        }
        return true;
    }
}
