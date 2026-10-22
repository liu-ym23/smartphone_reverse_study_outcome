package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f2802r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0021a f2803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Interpolator f2804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f2805c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f2806d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f2807e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float[] f2808f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2809g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f2810h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float[] f2811i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float[] f2812j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float[] f2813k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f2814l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2815m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f2816n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2817o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2818p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f2819q;

    /* JADX INFO: renamed from: androidx.core.widget.a$a, reason: collision with other inner class name */
    public static class C0021a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2821b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f2822c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f2823d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f2824e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f2825f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f2826g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f2827h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f2828i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f2829j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f2830k;

        public C0021a() {
            this.f2824e = Long.MIN_VALUE;
            this.f2828i = -1;
            this.f2825f = 0;
            this.f2826g = 0;
            this.f2827h = 0;
        }

        public void a() {
            if (this.f2825f == 0) goto L7;
            long r10 = AnimationUtils.currentAnimationTimeMillis();
            float r11 = g(e(r10));
            long r12 = r10 - this.f2825f;
            this.f2825f = r10;
            float r13 = r12 * r11;
            this.f2826g = (int) (this.f2822c * r13);
            this.f2827h = (int) (r13 * this.f2823d);
            return;
        L7:
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
        }

        public int b() {
            return this.f2826g;
        }

        public int c() {
            return this.f2827h;
        }

        public int d() {
            float r10 = this.f2822c;
            return (int) (r10 / Math.abs(r10));
        }

        public final float e(long r10) {
            long r11 = this.f2824e;
            if (r10 >= r11) goto L5;
            return 0.0f;
        L5:
            long r12 = this.f2828i;
            if (r12 < 0) goto L13;
            if (r10 < r12) goto L13;
            float r13 = this.f2829j;
            return (1.0f - r13) + (r13 * a.e((r10 - r12) / this.f2830k, 0.0f, 1.0f));
        L13:
            return a.e((r10 - r11) / this.f2820a, 0.0f, 1.0f) * 0.5f;
        }

        public int f() {
            float r10 = this.f2823d;
            return (int) (r10 / Math.abs(r10));
        }

        public final float g(float r10) {
            return (((-4.0f) * r10) * r10) + (r10 * 4.0f);
        }

        public boolean h() {
            if (this.f2828i > 0) goto L5;
        L7:
            return false;
        L5:
            if (AnimationUtils.currentAnimationTimeMillis() <= (this.f2828i + ((long) this.f2830k))) goto L7;
            return true;
        }

        public void i() {
            long r10 = AnimationUtils.currentAnimationTimeMillis();
            this.f2830k = a.f((int) (r10 - this.f2824e), 0, this.f2821b);
            this.f2829j = e(r10);
            this.f2828i = r10;
        }

        public void j(int r10) {
            this.f2821b = r10;
        }

        public void k(int r10) {
            this.f2820a = r10;
        }

        public void l(float r10, float r11) {
            this.f2822c = r10;
            this.f2823d = r11;
        }

        public void m() {
            long r10 = AnimationUtils.currentAnimationTimeMillis();
            this.f2824e = r10;
            this.f2828i = -1;
            this.f2825f = r10;
            this.f2829j = 0.5f;
            this.f2826g = 0;
            this.f2827h = 0;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f2831a;

        public b(a r10) {
            this.f2831a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            a r10 = this.f2831a;
            if (r10.f2817o == true) goto L6;
            return;
        L6:
            if (r10.f2815m == false) goto L8;
            r10.f2815m = false;
            r10.f2803a.m();
        L8:
            C0021a r11 = this.f2831a.f2803a;
            if (r11.h() == false) goto L11;
        L18:
            this.f2831a.f2817o = false;
            return;
        L11:
            if (this.f2831a.u() == false) goto L18;
            a r12 = this.f2831a;
            if (r12.f2816n == false) goto L16;
            r12.f2816n = false;
            r12.c();
        L16:
            r11.a();
            int r13 = r11.b();
            int r14 = r11.c();
            this.f2831a.j(r13, r14);
            ViewCompat.h0(this.f2831a.f2805c, this);
        }
    }

    static {
        f2802r = ViewConfiguration.getTapTimeout();
    }

    public a(View r10) {
        this.f2803a = new C0021a();
        this.f2804b = new AccelerateInterpolator();
        this.f2807e = new float[]{0.0f, 0.0f};
        this.f2808f = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.f2811i = new float[]{0.0f, 0.0f};
        this.f2812j = new float[]{0.0f, 0.0f};
        this.f2813k = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.f2805c = r10;
        float r11 = Resources.getSystem().getDisplayMetrics().density;
        float r12 = (int) ((1575.0f * r11) + 0.5f);
        o(r12, r12);
        float r13 = (int) ((r11 * 315.0f) + 0.5f);
        p(r13, r13);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f2802r);
        r(500);
        q(500);
    }

    public static float e(float r10, float r11, float r12) {
        if (r10 <= r12) goto L6;
        return r12;
    L6:
        if (r10 >= r11) goto L8;
        return r11;
    L8:
        return r10;
    }

    public static int f(int r10, int r11, int r12) {
        if (r10 <= r12) goto L4;
        return r12;
    L4:
        if (r10 >= r11) goto L6;
        return r11;
    L6:
        return r10;
    }

    public abstract boolean a(int r10);

    public abstract boolean b(int r10);

    public void c() {
        long r10 = SystemClock.uptimeMillis();
        MotionEvent r11 = MotionEvent.obtain(r10, r10, 3, 0.0f, 0.0f, 0);
        this.f2805c.onTouchEvent(r11);
        r11.recycle();
    }

    public final float d(int r10, float r11, float r12, float r13) {
        float r14 = h(this.f2807e[r10], r12, this.f2808f[r10], r11);
        if (r14 != 0.0f) goto L5;
        return 0.0f;
    L5:
        float r15 = this.f2811i[r10];
        float r16 = this.f2812j[r10];
        float r17 = this.f2813k[r10];
        float r18 = r15 * r13;
        if (r14 <= 0.0f) goto L10;
        return e(r14 * r18, r16, r17);
    L10:
        return -e((-r14) * r18, r16, r17);
    }

    public final float g(float r10, float r11) {
        if (r11 != 0.0f) goto L5;
        return 0.0f;
    L5:
        int r12 = this.f2809g;
        if (r12 == 0) goto L16;
        if (r12 == 1) goto L16;
        if (r12 == 2) goto L12;
    L25:
        return 0.0f;
    L12:
        if (r10 >= 0.0f) goto L25;
        return r10 / (-r11);
    L16:
        if (r10 >= r11) goto L25;
        if (r10 < 0.0f) goto L22;
        return 1.0f - (r10 / r11);
    L22:
        if (this.f2817o == false) goto L25;
        if (r12 != 1) goto L25;
        return 1.0f;
    }

    public final float h(float r10, float r11, float r12, float r13) {
        float r14 = e(r10 * r11, 0.0f, r12);
        float r15 = g(r13, r14);
        float r16 = g(r11 - r13, r14) - r15;
        if (r16 >= 0.0f) goto L6;
        float r17 = -this.f2804b.getInterpolation(-r16);
    L9:
        return e(r17, -1.0f, 1.0f);
    L6:
        if (r16 <= 0.0f) goto L10;
        r17 = this.f2804b.getInterpolation(r16);
        goto L9
    L10:
        return 0.0f;
    }

    public final void i() {
        if (this.f2815m == false) goto L5;
        this.f2817o = false;
        return;
    L5:
        this.f2803a.i();
    }

    public abstract void j(int r10, int r11);

    public a k(int r10) {
        this.f2810h = r10;
        return this;
    }

    public a l(int r10) {
        this.f2809g = r10;
        return this;
    }

    public a m(boolean r10) {
        if (this.f2818p == false) goto L6;
        if (r10 == true) goto L6;
        i();
    L6:
        this.f2818p = r10;
        return this;
    }

    public a n(float r10, float r11) {
        float[] r12 = this.f2808f;
        r12[0] = r10;
        r12[1] = r11;
        return this;
    }

    public a o(float r10, float r11) {
        float[] r12 = this.f2813k;
        r12[0] = r10 / 1000.0f;
        r12[1] = r11 / 1000.0f;
        return this;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r10, MotionEvent r11) {
        if (this.f2818p == true) goto L5;
        return false;
    L5:
        int r12 = r11.getActionMasked();
        if (r12 == 0) goto L14;
        if (r12 != 1) goto L9;
    L13:
        i();
    L21:
        if (this.f2819q == true) goto L23;
        return false;
    L23:
        if (this.f2817o == true) goto L25;
        return false;
    L25:
        return true;
    L9:
        if (r12 != 2) goto L11;
    L15:
        this.f2803a.l(d(0, r11.getX(), r10.getWidth(), this.f2805c.getWidth()), d(1, r11.getY(), r10.getHeight(), this.f2805c.getHeight()));
        if (this.f2817o == true) goto L21;
        if (u() == false) goto L21;
        v();
        goto L21
    L11:
        if (r12 == 3) goto L13;
    L14:
        this.f2816n = true;
        this.f2814l = false;
        goto L15
    }

    public a p(float r10, float r11) {
        float[] r12 = this.f2812j;
        r12[0] = r10 / 1000.0f;
        r12[1] = r11 / 1000.0f;
        return this;
    }

    public a q(int r10) {
        this.f2803a.j(r10);
        return this;
    }

    public a r(int r10) {
        this.f2803a.k(r10);
        return this;
    }

    public a s(float r10, float r11) {
        float[] r12 = this.f2807e;
        r12[0] = r10;
        r12[1] = r11;
        return this;
    }

    public a t(float r10, float r11) {
        float[] r12 = this.f2811i;
        r12[0] = r10 / 1000.0f;
        r12[1] = r11 / 1000.0f;
        return this;
    }

    public boolean u() {
        C0021a r10 = this.f2803a;
        int r11 = r10.f();
        int r12 = r10.d();
        if (r11 != 0) goto L5;
    L6:
        if (r12 != 0) goto L8;
    L10:
        return false;
    L8:
        if (a(r12) == false) goto L10;
    L9:
        return true;
    L5:
        if (b(r11) == true) goto L9;
        goto L6
    }

    public final void v() {
        if (this.f2806d != null) goto L5;
        this.f2806d = new b(this);
    L5:
        this.f2817o = true;
        this.f2815m = true;
        if (this.f2814l == true) goto L10;
        int r10 = this.f2810h;
        if (r10 <= 0) goto L10;
        ViewCompat.i0(this.f2805c, this.f2806d, r10);
    L11:
        this.f2814l = true;
        return;
    L10:
        this.f2806d.run();
        goto L11
    }
}
