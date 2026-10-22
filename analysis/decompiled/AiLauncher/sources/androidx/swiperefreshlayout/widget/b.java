package androidx.swiperefreshlayout.widget;

import B0.h;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* loaded from: classes.dex */
public class b extends Drawable implements Animatable {

    /* renamed from: g, reason: collision with root package name */
    public static final Interpolator f15024g = new LinearInterpolator();

    /* renamed from: h, reason: collision with root package name */
    public static final Interpolator f15025h = new T0.b();

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f15026i = {-16777216};

    /* renamed from: a, reason: collision with root package name */
    public final c f15027a;

    /* renamed from: b, reason: collision with root package name */
    public float f15028b;

    /* renamed from: c, reason: collision with root package name */
    public Resources f15029c;

    /* renamed from: d, reason: collision with root package name */
    public Animator f15030d;

    /* renamed from: e, reason: collision with root package name */
    public float f15031e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15032f;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f15033a;

        public a(c cVar) {
            this.f15033a = cVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            b.this.n(fFloatValue, this.f15033a);
            b.this.b(fFloatValue, this.f15033a, false);
            b.this.invalidateSelf();
        }
    }

    /* renamed from: androidx.swiperefreshlayout.widget.b$b, reason: collision with other inner class name */
    public class C0184b implements Animator.AnimatorListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f15035a;

        public C0184b(c cVar) {
            this.f15035a = cVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            b.this.b(1.0f, this.f15035a, true);
            this.f15035a.A();
            this.f15035a.l();
            b bVar = b.this;
            if (!bVar.f15032f) {
                bVar.f15031e += 1.0f;
                return;
            }
            bVar.f15032f = false;
            animator.cancel();
            animator.setDuration(1332L);
            animator.start();
            this.f15035a.x(false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            b.this.f15031e = 0.0f;
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final RectF f15037a = new RectF();

        /* renamed from: b, reason: collision with root package name */
        public final Paint f15038b;

        /* renamed from: c, reason: collision with root package name */
        public final Paint f15039c;

        /* renamed from: d, reason: collision with root package name */
        public final Paint f15040d;

        /* renamed from: e, reason: collision with root package name */
        public float f15041e;

        /* renamed from: f, reason: collision with root package name */
        public float f15042f;

        /* renamed from: g, reason: collision with root package name */
        public float f15043g;

        /* renamed from: h, reason: collision with root package name */
        public float f15044h;

        /* renamed from: i, reason: collision with root package name */
        public int[] f15045i;

        /* renamed from: j, reason: collision with root package name */
        public int f15046j;

        /* renamed from: k, reason: collision with root package name */
        public float f15047k;

        /* renamed from: l, reason: collision with root package name */
        public float f15048l;

        /* renamed from: m, reason: collision with root package name */
        public float f15049m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f15050n;

        /* renamed from: o, reason: collision with root package name */
        public Path f15051o;

        /* renamed from: p, reason: collision with root package name */
        public float f15052p;

        /* renamed from: q, reason: collision with root package name */
        public float f15053q;

        /* renamed from: r, reason: collision with root package name */
        public int f15054r;

        /* renamed from: s, reason: collision with root package name */
        public int f15055s;

        /* renamed from: t, reason: collision with root package name */
        public int f15056t;

        /* renamed from: u, reason: collision with root package name */
        public int f15057u;

        public c() {
            Paint paint = new Paint();
            this.f15038b = paint;
            Paint paint2 = new Paint();
            this.f15039c = paint2;
            Paint paint3 = new Paint();
            this.f15040d = paint3;
            this.f15041e = 0.0f;
            this.f15042f = 0.0f;
            this.f15043g = 0.0f;
            this.f15044h = 5.0f;
            this.f15052p = 1.0f;
            this.f15056t = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        public void A() {
            this.f15047k = this.f15041e;
            this.f15048l = this.f15042f;
            this.f15049m = this.f15043g;
        }

        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f15037a;
            float f10 = this.f15053q;
            float fMin = (this.f15044h / 2.0f) + f10;
            if (f10 <= 0.0f) {
                fMin = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.f15054r * this.f15052p) / 2.0f, this.f15044h / 2.0f);
            }
            rectF.set(rect.centerX() - fMin, rect.centerY() - fMin, rect.centerX() + fMin, rect.centerY() + fMin);
            float f11 = this.f15041e;
            float f12 = this.f15043g;
            float f13 = (f11 + f12) * 360.0f;
            float f14 = ((this.f15042f + f12) * 360.0f) - f13;
            this.f15038b.setColor(this.f15057u);
            this.f15038b.setAlpha(this.f15056t);
            float f15 = this.f15044h / 2.0f;
            rectF.inset(f15, f15);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f15040d);
            float f16 = -f15;
            rectF.inset(f16, f16);
            canvas.drawArc(rectF, f13, f14, false, this.f15038b);
            b(canvas, f13, f14, rectF);
        }

        public void b(Canvas canvas, float f10, float f11, RectF rectF) {
            if (this.f15050n) {
                Path path = this.f15051o;
                if (path == null) {
                    Path path2 = new Path();
                    this.f15051o = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float fMin = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f12 = (this.f15054r * this.f15052p) / 2.0f;
                this.f15051o.moveTo(0.0f, 0.0f);
                this.f15051o.lineTo(this.f15054r * this.f15052p, 0.0f);
                Path path3 = this.f15051o;
                float f13 = this.f15054r;
                float f14 = this.f15052p;
                path3.lineTo((f13 * f14) / 2.0f, this.f15055s * f14);
                this.f15051o.offset((fMin + rectF.centerX()) - f12, rectF.centerY() + (this.f15044h / 2.0f));
                this.f15051o.close();
                this.f15039c.setColor(this.f15057u);
                this.f15039c.setAlpha(this.f15056t);
                canvas.save();
                canvas.rotate(f10 + f11, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.f15051o, this.f15039c);
                canvas.restore();
            }
        }

        public int c() {
            return this.f15056t;
        }

        public float d() {
            return this.f15042f;
        }

        public int e() {
            return this.f15045i[f()];
        }

        public int f() {
            return (this.f15046j + 1) % this.f15045i.length;
        }

        public float g() {
            return this.f15041e;
        }

        public int h() {
            return this.f15045i[this.f15046j];
        }

        public float i() {
            return this.f15048l;
        }

        public float j() {
            return this.f15049m;
        }

        public float k() {
            return this.f15047k;
        }

        public void l() {
            t(f());
        }

        public void m() {
            this.f15047k = 0.0f;
            this.f15048l = 0.0f;
            this.f15049m = 0.0f;
            y(0.0f);
            v(0.0f);
            w(0.0f);
        }

        public void n(int i10) {
            this.f15056t = i10;
        }

        public void o(float f10, float f11) {
            this.f15054r = (int) f10;
            this.f15055s = (int) f11;
        }

        public void p(float f10) {
            if (f10 != this.f15052p) {
                this.f15052p = f10;
            }
        }

        public void q(float f10) {
            this.f15053q = f10;
        }

        public void r(int i10) {
            this.f15057u = i10;
        }

        public void s(ColorFilter colorFilter) {
            this.f15038b.setColorFilter(colorFilter);
        }

        public void t(int i10) {
            this.f15046j = i10;
            this.f15057u = this.f15045i[i10];
        }

        public void u(int[] iArr) {
            this.f15045i = iArr;
            t(0);
        }

        public void v(float f10) {
            this.f15042f = f10;
        }

        public void w(float f10) {
            this.f15043g = f10;
        }

        public void x(boolean z10) {
            if (this.f15050n != z10) {
                this.f15050n = z10;
            }
        }

        public void y(float f10) {
            this.f15041e = f10;
        }

        public void z(float f10) {
            this.f15044h = f10;
            this.f15038b.setStrokeWidth(f10);
        }
    }

    public b(Context context) {
        this.f15029c = ((Context) h.f(context)).getResources();
        c cVar = new c();
        this.f15027a = cVar;
        cVar.u(f15026i);
        k(2.5f);
        m();
    }

    public final void a(float f10, c cVar) {
        n(f10, cVar);
        float fFloor = (float) (Math.floor(cVar.j() / 0.8f) + 1.0d);
        cVar.y(cVar.k() + (((cVar.i() - 0.01f) - cVar.k()) * f10));
        cVar.v(cVar.i());
        cVar.w(cVar.j() + ((fFloor - cVar.j()) * f10));
    }

    public void b(float f10, c cVar, boolean z10) {
        float interpolation;
        float interpolation2;
        if (this.f15032f) {
            a(f10, cVar);
            return;
        }
        if (f10 != 1.0f || z10) {
            float fJ = cVar.j();
            if (f10 < 0.5f) {
                interpolation = cVar.k();
                interpolation2 = (f15025h.getInterpolation(f10 / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float fK = cVar.k() + 0.79f;
                interpolation = fK - (((1.0f - f15025h.getInterpolation((f10 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                interpolation2 = fK;
            }
            float f11 = fJ + (0.20999998f * f10);
            float f12 = (f10 + this.f15031e) * 216.0f;
            cVar.y(interpolation);
            cVar.v(interpolation2);
            cVar.w(f11);
            h(f12);
        }
    }

    public final int c(float f10, int i10, int i11) {
        return ((((i10 >> 24) & 255) + ((int) ((((i11 >> 24) & 255) - r5) * f10))) << 24) | ((((i10 >> 16) & 255) + ((int) ((((i11 >> 16) & 255) - r0) * f10))) << 16) | ((((i10 >> 8) & 255) + ((int) ((((i11 >> 8) & 255) - r1) * f10))) << 8) | ((i10 & 255) + ((int) (f10 * ((i11 & 255) - r7))));
    }

    public void d(boolean z10) {
        this.f15027a.x(z10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f15028b, bounds.exactCenterX(), bounds.exactCenterY());
        this.f15027a.a(canvas, bounds);
        canvas.restore();
    }

    public void e(float f10) {
        this.f15027a.p(f10);
        invalidateSelf();
    }

    public void f(int... iArr) {
        this.f15027a.u(iArr);
        this.f15027a.t(0);
        invalidateSelf();
    }

    public void g(float f10) {
        this.f15027a.w(f10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f15027a.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final void h(float f10) {
        this.f15028b = f10;
    }

    public final void i(float f10, float f11, float f12, float f13) {
        c cVar = this.f15027a;
        float f14 = this.f15029c.getDisplayMetrics().density;
        cVar.z(f11 * f14);
        cVar.q(f10 * f14);
        cVar.t(0);
        cVar.o(f12 * f14, f13 * f14);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f15030d.isRunning();
    }

    public void j(float f10, float f11) {
        this.f15027a.y(f10);
        this.f15027a.v(f11);
        invalidateSelf();
    }

    public void k(float f10) {
        this.f15027a.z(f10);
        invalidateSelf();
    }

    public void l(int i10) {
        if (i10 == 0) {
            i(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            i(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public final void m() {
        c cVar = this.f15027a;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new a(cVar));
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setRepeatMode(1);
        valueAnimatorOfFloat.setInterpolator(f15024g);
        valueAnimatorOfFloat.addListener(new C0184b(cVar));
        this.f15030d = valueAnimatorOfFloat;
    }

    public void n(float f10, c cVar) {
        if (f10 > 0.75f) {
            cVar.r(c((f10 - 0.75f) / 0.25f, cVar.h(), cVar.e()));
        } else {
            cVar.r(cVar.h());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f15027a.n(i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f15027a.s(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f15030d.cancel();
        this.f15027a.A();
        if (this.f15027a.d() != this.f15027a.g()) {
            this.f15032f = true;
            this.f15030d.setDuration(666L);
            this.f15030d.start();
        } else {
            this.f15027a.t(0);
            this.f15027a.m();
            this.f15030d.setDuration(1332L);
            this.f15030d.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f15030d.cancel();
        h(0.0f);
        this.f15027a.x(false);
        this.f15027a.t(0);
        this.f15027a.m();
        invalidateSelf();
    }
}
