package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.H;

/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {

    /* renamed from: r, reason: collision with root package name */
    private static final int f9866r = ViewConfiguration.getTapTimeout();

    /* renamed from: c, reason: collision with root package name */
    final View f9869c;

    /* renamed from: d, reason: collision with root package name */
    private Runnable f9870d;

    /* renamed from: g, reason: collision with root package name */
    private int f9873g;

    /* renamed from: h, reason: collision with root package name */
    private int f9874h;

    /* renamed from: l, reason: collision with root package name */
    private boolean f9878l;

    /* renamed from: m, reason: collision with root package name */
    boolean f9879m;

    /* renamed from: n, reason: collision with root package name */
    boolean f9880n;

    /* renamed from: o, reason: collision with root package name */
    boolean f9881o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f9882p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f9883q;

    /* renamed from: a, reason: collision with root package name */
    final C0124a f9867a = new C0124a();

    /* renamed from: b, reason: collision with root package name */
    private final Interpolator f9868b = new AccelerateInterpolator();

    /* renamed from: e, reason: collision with root package name */
    private float[] f9871e = {0.0f, 0.0f};

    /* renamed from: f, reason: collision with root package name */
    private float[] f9872f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: i, reason: collision with root package name */
    private float[] f9875i = {0.0f, 0.0f};

    /* renamed from: j, reason: collision with root package name */
    private float[] f9876j = {0.0f, 0.0f};

    /* renamed from: k, reason: collision with root package name */
    private float[] f9877k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: androidx.core.widget.a$a, reason: collision with other inner class name */
    private static class C0124a {

        /* renamed from: a, reason: collision with root package name */
        private int f9884a;

        /* renamed from: b, reason: collision with root package name */
        private int f9885b;

        /* renamed from: c, reason: collision with root package name */
        private float f9886c;

        /* renamed from: d, reason: collision with root package name */
        private float f9887d;

        /* renamed from: j, reason: collision with root package name */
        private float f9893j;

        /* renamed from: k, reason: collision with root package name */
        private int f9894k;

        /* renamed from: e, reason: collision with root package name */
        private long f9888e = Long.MIN_VALUE;

        /* renamed from: i, reason: collision with root package name */
        private long f9892i = -1;

        /* renamed from: f, reason: collision with root package name */
        private long f9889f = 0;

        /* renamed from: g, reason: collision with root package name */
        private int f9890g = 0;

        /* renamed from: h, reason: collision with root package name */
        private int f9891h = 0;

        C0124a() {
        }

        private float e(long j5) {
            if (j5 < this.f9888e) {
                return 0.0f;
            }
            long j6 = this.f9892i;
            if (j6 < 0 || j5 < j6) {
                return a.e((j5 - r0) / this.f9884a, 0.0f, 1.0f) * 0.5f;
            }
            float f5 = this.f9893j;
            return (1.0f - f5) + (f5 * a.e((j5 - j6) / this.f9894k, 0.0f, 1.0f));
        }

        private float g(float f5) {
            return ((-4.0f) * f5 * f5) + (f5 * 4.0f);
        }

        public void a() {
            if (this.f9889f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float fG = g(e(jCurrentAnimationTimeMillis));
            long j5 = jCurrentAnimationTimeMillis - this.f9889f;
            this.f9889f = jCurrentAnimationTimeMillis;
            float f5 = j5 * fG;
            this.f9890g = (int) (this.f9886c * f5);
            this.f9891h = (int) (f5 * this.f9887d);
        }

        public int b() {
            return this.f9890g;
        }

        public int c() {
            return this.f9891h;
        }

        public int d() {
            float f5 = this.f9886c;
            return (int) (f5 / Math.abs(f5));
        }

        public int f() {
            float f5 = this.f9887d;
            return (int) (f5 / Math.abs(f5));
        }

        public boolean h() {
            return this.f9892i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f9892i + ((long) this.f9894k);
        }

        public void i() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f9894k = a.f((int) (jCurrentAnimationTimeMillis - this.f9888e), 0, this.f9885b);
            this.f9893j = e(jCurrentAnimationTimeMillis);
            this.f9892i = jCurrentAnimationTimeMillis;
        }

        public void j(int i5) {
            this.f9885b = i5;
        }

        public void k(int i5) {
            this.f9884a = i5;
        }

        public void l(float f5, float f6) {
            this.f9886c = f5;
            this.f9887d = f6;
        }

        public void m() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f9888e = jCurrentAnimationTimeMillis;
            this.f9892i = -1L;
            this.f9889f = jCurrentAnimationTimeMillis;
            this.f9893j = 0.5f;
            this.f9890g = 0;
            this.f9891h = 0;
        }
    }

    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.f9881o) {
                if (aVar.f9879m) {
                    aVar.f9879m = false;
                    aVar.f9867a.m();
                }
                C0124a c0124a = a.this.f9867a;
                if (c0124a.h() || !a.this.u()) {
                    a.this.f9881o = false;
                    return;
                }
                a aVar2 = a.this;
                if (aVar2.f9880n) {
                    aVar2.f9880n = false;
                    aVar2.c();
                }
                c0124a.a();
                a.this.j(c0124a.b(), c0124a.c());
                H.b0(a.this.f9869c, this);
            }
        }
    }

    public a(View view) {
        this.f9869c = view;
        float f5 = Resources.getSystem().getDisplayMetrics().density;
        float f6 = (int) ((1575.0f * f5) + 0.5f);
        o(f6, f6);
        float f7 = (int) ((f5 * 315.0f) + 0.5f);
        p(f7, f7);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f9866r);
        r(500);
        q(500);
    }

    private float d(int i5, float f5, float f6, float f7) {
        float fH = h(this.f9871e[i5], f6, this.f9872f[i5], f5);
        if (fH == 0.0f) {
            return 0.0f;
        }
        float f8 = this.f9875i[i5];
        float f9 = this.f9876j[i5];
        float f10 = this.f9877k[i5];
        float f11 = f8 * f7;
        return fH > 0.0f ? e(fH * f11, f9, f10) : -e((-fH) * f11, f9, f10);
    }

    static float e(float f5, float f6, float f7) {
        return f5 > f7 ? f7 : f5 < f6 ? f6 : f5;
    }

    static int f(int i5, int i6, int i7) {
        return i5 > i7 ? i7 : i5 < i6 ? i6 : i5;
    }

    private float g(float f5, float f6) {
        if (f6 == 0.0f) {
            return 0.0f;
        }
        int i5 = this.f9873g;
        if (i5 == 0 || i5 == 1) {
            if (f5 < f6) {
                if (f5 >= 0.0f) {
                    return 1.0f - (f5 / f6);
                }
                if (this.f9881o && i5 == 1) {
                    return 1.0f;
                }
            }
        } else if (i5 == 2 && f5 < 0.0f) {
            return f5 / (-f6);
        }
        return 0.0f;
    }

    private float h(float f5, float f6, float f7, float f8) {
        float interpolation;
        float fE = e(f5 * f6, 0.0f, f7);
        float fG = g(f6 - f8, fE) - g(f8, fE);
        if (fG < 0.0f) {
            interpolation = -this.f9868b.getInterpolation(-fG);
        } else {
            if (fG <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f9868b.getInterpolation(fG);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    private void i() {
        if (this.f9879m) {
            this.f9881o = false;
        } else {
            this.f9867a.i();
        }
    }

    private void v() {
        int i5;
        if (this.f9870d == null) {
            this.f9870d = new b();
        }
        this.f9881o = true;
        this.f9879m = true;
        if (this.f9878l || (i5 = this.f9874h) <= 0) {
            this.f9870d.run();
        } else {
            H.c0(this.f9869c, this.f9870d, i5);
        }
        this.f9878l = true;
    }

    public abstract boolean a(int i5);

    public abstract boolean b(int i5);

    void c() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f9869c.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    public abstract void j(int i5, int i6);

    public a k(int i5) {
        this.f9874h = i5;
        return this;
    }

    public a l(int i5) {
        this.f9873g = i5;
        return this;
    }

    public a m(boolean z5) {
        if (this.f9882p && !z5) {
            i();
        }
        this.f9882p = z5;
        return this;
    }

    public a n(float f5, float f6) {
        float[] fArr = this.f9872f;
        fArr[0] = f5;
        fArr[1] = f6;
        return this;
    }

    public a o(float f5, float f6) {
        float[] fArr = this.f9877k;
        fArr[0] = f5 / 1000.0f;
        fArr[1] = f6 / 1000.0f;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f9882p
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.i()
            goto L58
        L1a:
            r5.f9880n = r2
            r5.f9878l = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f9869c
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f9869c
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            androidx.core.widget.a$a r7 = r5.f9867a
            r7.l(r0, r6)
            boolean r6 = r5.f9881o
            if (r6 != 0) goto L58
            boolean r6 = r5.u()
            if (r6 == 0) goto L58
            r5.v()
        L58:
            boolean r6 = r5.f9883q
            if (r6 == 0) goto L61
            boolean r5 = r5.f9881o
            if (r5 == 0) goto L61
            return r2
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public a p(float f5, float f6) {
        float[] fArr = this.f9876j;
        fArr[0] = f5 / 1000.0f;
        fArr[1] = f6 / 1000.0f;
        return this;
    }

    public a q(int i5) {
        this.f9867a.j(i5);
        return this;
    }

    public a r(int i5) {
        this.f9867a.k(i5);
        return this;
    }

    public a s(float f5, float f6) {
        float[] fArr = this.f9871e;
        fArr[0] = f5;
        fArr[1] = f6;
        return this;
    }

    public a t(float f5, float f6) {
        float[] fArr = this.f9875i;
        fArr[0] = f5 / 1000.0f;
        fArr[1] = f6 / 1000.0f;
        return this;
    }

    boolean u() {
        C0124a c0124a = this.f9867a;
        int iF = c0124a.f();
        int iD = c0124a.d();
        if (iF == 0 || !b(iF)) {
            return iD != 0 && a(iD);
        }
        return true;
    }
}
