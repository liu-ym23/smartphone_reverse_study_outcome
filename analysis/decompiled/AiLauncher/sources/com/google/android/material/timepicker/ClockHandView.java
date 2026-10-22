package com.google.android.material.timepicker;

import T2.h;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.u;
import com.stepos.launcher.assistant.slidepanel.MinusOneTransitionSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
class ClockHandView extends View {

    /* renamed from: a, reason: collision with root package name */
    public final int f21727a;

    /* renamed from: b, reason: collision with root package name */
    public final TimeInterpolator f21728b;

    /* renamed from: c, reason: collision with root package name */
    public final ValueAnimator f21729c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f21730d;

    /* renamed from: e, reason: collision with root package name */
    public float f21731e;

    /* renamed from: f, reason: collision with root package name */
    public float f21732f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f21733g;

    /* renamed from: h, reason: collision with root package name */
    public final int f21734h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f21735i;

    /* renamed from: j, reason: collision with root package name */
    public final List<b> f21736j;

    /* renamed from: k, reason: collision with root package name */
    public final int f21737k;

    /* renamed from: l, reason: collision with root package name */
    public final float f21738l;

    /* renamed from: m, reason: collision with root package name */
    public final Paint f21739m;

    /* renamed from: n, reason: collision with root package name */
    public final RectF f21740n;

    /* renamed from: o, reason: collision with root package name */
    public final int f21741o;

    /* renamed from: p, reason: collision with root package name */
    public float f21742p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f21743q;

    /* renamed from: r, reason: collision with root package name */
    public double f21744r;

    /* renamed from: s, reason: collision with root package name */
    public int f21745s;

    /* renamed from: t, reason: collision with root package name */
    public int f21746t;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    public interface b {
        void b(float f10, boolean z10);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialClockStyle);
    }

    public static /* synthetic */ void a(ClockHandView clockHandView, ValueAnimator valueAnimator) {
        clockHandView.getClass();
        clockHandView.p(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
    }

    public void b(b bVar) {
        this.f21736j.add(bVar);
    }

    public final void c(float f10, float f11) {
        this.f21746t = S2.a.b((float) (getWidth() / 2), (float) (getHeight() / 2), f10, f11) > ((float) h(2)) + u.c(getContext(), 12) ? 1 : 2;
    }

    public final void d(Canvas canvas) {
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f10 = width;
        float fH = h(this.f21746t);
        float fCos = (((float) Math.cos(this.f21744r)) * fH) + f10;
        float f11 = height;
        float fSin = (fH * ((float) Math.sin(this.f21744r))) + f11;
        this.f21739m.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.f21737k, this.f21739m);
        double dSin = Math.sin(this.f21744r);
        double dCos = Math.cos(this.f21744r);
        this.f21739m.setStrokeWidth(this.f21741o);
        canvas.drawLine(f10, f11, width + ((int) (dCos * d)), height + ((int) (d * dSin)), this.f21739m);
        canvas.drawCircle(f10, f11, this.f21738l, this.f21739m);
    }

    public RectF e() {
        return this.f21740n;
    }

    public final int f(float f10, float f11) {
        int degrees = (int) Math.toDegrees(Math.atan2(f11 - (getHeight() / 2), f10 - (getWidth() / 2)));
        int i10 = degrees + 90;
        return i10 < 0 ? degrees + MinusOneTransitionSpec.OVERLAY_CLOSE_DURATION_MS : i10;
    }

    public float g() {
        return this.f21742p;
    }

    public final int h(int i10) {
        int i11 = this.f21745s;
        return i10 == 2 ? Math.round(i11 * 0.66f) : i11;
    }

    public int i() {
        return this.f21737k;
    }

    public final Pair<Float, Float> j(float f10) {
        float fG = g();
        if (Math.abs(fG - f10) > 180.0f) {
            if (fG > 180.0f && f10 < 180.0f) {
                f10 += 360.0f;
            }
            if (fG < 180.0f && f10 > 180.0f) {
                fG += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(fG), Float.valueOf(f10));
    }

    public final boolean k(float f10, float f11, boolean z10, boolean z11, boolean z12) {
        float f12 = f(f10, f11);
        boolean z13 = false;
        boolean z14 = g() != f12;
        if (z11 && z14) {
            return true;
        }
        if (!z14 && !z10) {
            return false;
        }
        if (z12 && this.f21730d) {
            z13 = true;
        }
        o(f12, z13);
        return true;
    }

    public final void l() {
        this.f21729c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.timepicker.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ClockHandView.a(this.f21758a, valueAnimator);
            }
        });
        this.f21729c.addListener(new a());
    }

    public void m(int i10) {
        this.f21745s = i10;
        invalidate();
    }

    public void n(float f10) {
        o(f10, false);
    }

    public void o(float f10, boolean z10) {
        this.f21729c.cancel();
        if (!z10) {
            p(f10, false);
            return;
        }
        Pair<Float, Float> pairJ = j(f10);
        this.f21729c.setFloatValues(((Float) pairJ.first).floatValue(), ((Float) pairJ.second).floatValue());
        this.f21729c.setDuration(this.f21727a);
        this.f21729c.setInterpolator(this.f21728b);
        this.f21729c.start();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.f21729c.isRunning()) {
            return;
        }
        n(g());
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        boolean z11;
        boolean z12;
        int actionMasked = motionEvent.getActionMasked();
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (actionMasked == 0) {
            this.f21731e = x10;
            this.f21732f = y10;
            this.f21733g = true;
            this.f21743q = false;
            z10 = true;
            z11 = false;
            z12 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            int i10 = (int) (x10 - this.f21731e);
            int i11 = (int) (y10 - this.f21732f);
            this.f21733g = (i10 * i10) + (i11 * i11) > this.f21734h;
            z11 = this.f21743q;
            boolean z13 = actionMasked == 1;
            if (this.f21735i) {
                c(x10, y10);
            }
            z12 = z13;
            z10 = false;
        } else {
            z11 = false;
            z10 = false;
            z12 = false;
        }
        this.f21743q = k(x10, y10, z11, z10, z12) | this.f21743q;
        return true;
    }

    public final void p(float f10, boolean z10) {
        float f11 = f10 % 360.0f;
        this.f21742p = f11;
        this.f21744r = Math.toRadians(f11 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float fH = h(this.f21746t);
        float fCos = width + (((float) Math.cos(this.f21744r)) * fH);
        float fSin = height + (fH * ((float) Math.sin(this.f21744r)));
        RectF rectF = this.f21740n;
        int i10 = this.f21737k;
        rectF.set(fCos - i10, fSin - i10, fCos + i10, fSin + i10);
        Iterator<b> it = this.f21736j.iterator();
        while (it.hasNext()) {
            it.next().b(f11, z10);
        }
        invalidate();
    }

    public void q(boolean z10) {
        if (this.f21735i && !z10) {
            this.f21746t = 1;
        }
        this.f21735i = z10;
        invalidate();
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f21729c = new ValueAnimator();
        this.f21736j = new ArrayList();
        Paint paint = new Paint();
        this.f21739m = paint;
        this.f21740n = new RectF();
        this.f21746t = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClockHandView, i10, R$style.Widget_MaterialComponents_TimePicker_Clock);
        this.f21727a = h.f(context, R$attr.motionDurationLong2, 200);
        this.f21728b = h.g(context, R$attr.motionEasingEmphasizedInterpolator, E2.a.f2340b);
        this.f21745s = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ClockHandView_materialCircleRadius, 0);
        this.f21737k = typedArrayObtainStyledAttributes.getDimensionPixelSize(R$styleable.ClockHandView_selectorSize, 0);
        this.f21741o = getResources().getDimensionPixelSize(R$dimen.material_clock_hand_stroke_width);
        this.f21738l = r7.getDimensionPixelSize(R$dimen.material_clock_hand_center_dot_radius);
        int color = typedArrayObtainStyledAttributes.getColor(R$styleable.ClockHandView_clockHandColor, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        n(0.0f);
        this.f21734h = ViewConfiguration.get(context).getScaledTouchSlop();
        setImportantForAccessibility(2);
        typedArrayObtainStyledAttributes.recycle();
        l();
    }
}
