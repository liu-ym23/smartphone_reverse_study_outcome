package com.google.android.material.timepicker;

import a1.C0409b;
import a1.C0411d;
import a1.C0417j;
import a1.C0418k;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
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
import b1.C0553a;
import com.google.android.material.internal.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n1.C0873a;

/* loaded from: classes.dex */
class ClockHandView extends View {

    /* renamed from: a, reason: collision with root package name */
    private final int f13460a;

    /* renamed from: b, reason: collision with root package name */
    private final TimeInterpolator f13461b;

    /* renamed from: c, reason: collision with root package name */
    private final ValueAnimator f13462c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f13463d;

    /* renamed from: e, reason: collision with root package name */
    private float f13464e;

    /* renamed from: f, reason: collision with root package name */
    private float f13465f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f13466g;

    /* renamed from: h, reason: collision with root package name */
    private final int f13467h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f13468i;

    /* renamed from: j, reason: collision with root package name */
    private final List<b> f13469j;

    /* renamed from: k, reason: collision with root package name */
    private final int f13470k;

    /* renamed from: l, reason: collision with root package name */
    private final float f13471l;

    /* renamed from: m, reason: collision with root package name */
    private final Paint f13472m;

    /* renamed from: n, reason: collision with root package name */
    private final RectF f13473n;

    /* renamed from: o, reason: collision with root package name */
    private final int f13474o;

    /* renamed from: p, reason: collision with root package name */
    private float f13475p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f13476q;

    /* renamed from: r, reason: collision with root package name */
    private double f13477r;

    /* renamed from: s, reason: collision with root package name */
    private int f13478s;

    /* renamed from: t, reason: collision with root package name */
    private int f13479t;

    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    public interface b {
        void a(float f5, boolean z5);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0409b.f6731r);
    }

    public static /* synthetic */ void a(ClockHandView clockHandView, ValueAnimator valueAnimator) {
        clockHandView.getClass();
        clockHandView.p(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
    }

    private void c(float f5, float f6) {
        this.f13479t = C0873a.b((float) (getWidth() / 2), (float) (getHeight() / 2), f5, f6) > ((float) h(2)) + r.c(getContext(), 12) ? 1 : 2;
    }

    private void d(Canvas canvas) {
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f5 = width;
        float fH = h(this.f13479t);
        float fCos = (((float) Math.cos(this.f13477r)) * fH) + f5;
        float f6 = height;
        float fSin = (fH * ((float) Math.sin(this.f13477r))) + f6;
        this.f13472m.setStrokeWidth(0.0f);
        canvas.drawCircle(fCos, fSin, this.f13470k, this.f13472m);
        double dSin = Math.sin(this.f13477r);
        double dCos = Math.cos(this.f13477r);
        this.f13472m.setStrokeWidth(this.f13474o);
        canvas.drawLine(f5, f6, width + ((int) (dCos * d)), height + ((int) (d * dSin)), this.f13472m);
        canvas.drawCircle(f5, f6, this.f13471l, this.f13472m);
    }

    private int f(float f5, float f6) {
        int degrees = (int) Math.toDegrees(Math.atan2(f6 - (getHeight() / 2), f5 - (getWidth() / 2)));
        int i5 = degrees + 90;
        return i5 < 0 ? degrees + 450 : i5;
    }

    private int h(int i5) {
        int i6 = this.f13478s;
        return i5 == 2 ? Math.round(i6 * 0.66f) : i6;
    }

    private Pair<Float, Float> j(float f5) {
        float fG = g();
        if (Math.abs(fG - f5) > 180.0f) {
            if (fG > 180.0f && f5 < 180.0f) {
                f5 += 360.0f;
            }
            if (fG < 180.0f && f5 > 180.0f) {
                fG += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(fG), Float.valueOf(f5));
    }

    private boolean k(float f5, float f6, boolean z5, boolean z6, boolean z7) {
        float f7 = f(f5, f6);
        boolean z8 = false;
        boolean z9 = g() != f7;
        if (z6 && z9) {
            return true;
        }
        if (!z9 && !z5) {
            return false;
        }
        if (z7 && this.f13463d) {
            z8 = true;
        }
        o(f7, z8);
        return true;
    }

    private void l() {
        this.f13462c.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.timepicker.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ClockHandView.a(this.f13491a, valueAnimator);
            }
        });
        this.f13462c.addListener(new a());
    }

    private void p(float f5, boolean z5) {
        float f6 = f5 % 360.0f;
        this.f13475p = f6;
        this.f13477r = Math.toRadians(f6 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float fH = h(this.f13479t);
        float fCos = width + (((float) Math.cos(this.f13477r)) * fH);
        float fSin = height + (fH * ((float) Math.sin(this.f13477r)));
        RectF rectF = this.f13473n;
        int i5 = this.f13470k;
        rectF.set(fCos - i5, fSin - i5, fCos + i5, fSin + i5);
        Iterator<b> it = this.f13469j.iterator();
        while (it.hasNext()) {
            it.next().a(f6, z5);
        }
        invalidate();
    }

    public void b(b bVar) {
        this.f13469j.add(bVar);
    }

    public RectF e() {
        return this.f13473n;
    }

    public float g() {
        return this.f13475p;
    }

    public int i() {
        return this.f13470k;
    }

    public void m(int i5) {
        this.f13478s = i5;
        invalidate();
    }

    public void n(float f5) {
        o(f5, false);
    }

    public void o(float f5, boolean z5) {
        this.f13462c.cancel();
        if (!z5) {
            p(f5, false);
            return;
        }
        Pair<Float, Float> pairJ = j(f5);
        this.f13462c.setFloatValues(((Float) pairJ.first).floatValue(), ((Float) pairJ.second).floatValue());
        this.f13462c.setDuration(this.f13460a);
        this.f13462c.setInterpolator(this.f13461b);
        this.f13462c.start();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        d(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
        if (this.f13462c.isRunning()) {
            return;
        }
        n(g());
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z5;
        boolean z6;
        boolean z7;
        int actionMasked = motionEvent.getActionMasked();
        float x5 = motionEvent.getX();
        float y5 = motionEvent.getY();
        if (actionMasked == 0) {
            this.f13464e = x5;
            this.f13465f = y5;
            this.f13466g = true;
            this.f13476q = false;
            z5 = true;
            z6 = false;
            z7 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            int i5 = (int) (x5 - this.f13464e);
            int i6 = (int) (y5 - this.f13465f);
            this.f13466g = (i5 * i5) + (i6 * i6) > this.f13467h;
            z6 = this.f13476q;
            boolean z8 = actionMasked == 1;
            if (this.f13468i) {
                c(x5, y5);
            }
            z7 = z8;
            z5 = false;
        } else {
            z6 = false;
            z5 = false;
            z7 = false;
        }
        this.f13476q = k(x5, y5, z6, z5, z7) | this.f13476q;
        return true;
    }

    void q(boolean z5) {
        if (this.f13468i && !z5) {
            this.f13479t = 1;
        }
        this.f13468i = z5;
        invalidate();
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f13462c = new ValueAnimator();
        this.f13469j = new ArrayList();
        Paint paint = new Paint();
        this.f13472m = paint;
        this.f13473n = new RectF();
        this.f13479t = 1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0418k.f7020O0, i5, C0417j.f6933x);
        this.f13460a = o1.e.f(context, C0409b.f6736w, 200);
        this.f13461b = o1.e.g(context, C0409b.f6696F, C0553a.f11784b);
        this.f13478s = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0418k.f7032Q0, 0);
        this.f13470k = typedArrayObtainStyledAttributes.getDimensionPixelSize(C0418k.f7038R0, 0);
        this.f13474o = getResources().getDimensionPixelSize(C0411d.f6806z);
        this.f13471l = r7.getDimensionPixelSize(C0411d.f6804x);
        int color = typedArrayObtainStyledAttributes.getColor(C0418k.f7026P0, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        n(0.0f);
        this.f13467h = ViewConfiguration.get(context).getScaledTouchSlop();
        setImportantForAccessibility(2);
        typedArrayObtainStyledAttributes.recycle();
        l();
    }
}
