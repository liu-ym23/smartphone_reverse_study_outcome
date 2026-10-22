package a5;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private int f7288a;

    /* renamed from: b, reason: collision with root package name */
    private final b f7289b;

    /* renamed from: c, reason: collision with root package name */
    private final b f7290c;

    /* renamed from: d, reason: collision with root package name */
    private Interpolator f7291d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f7292e;

    /* renamed from: f, reason: collision with root package name */
    private Class f7293f;

    /* renamed from: g, reason: collision with root package name */
    private Method f7294g;

    static class b {

        /* renamed from: s, reason: collision with root package name */
        private static float f7295s = (float) (Math.log(0.78d) / Math.log(0.9d));

        /* renamed from: t, reason: collision with root package name */
        private static final float[] f7296t = new float[101];

        /* renamed from: u, reason: collision with root package name */
        private static final float[] f7297u = new float[101];

        /* renamed from: a, reason: collision with root package name */
        private Context f7298a;

        /* renamed from: b, reason: collision with root package name */
        private int f7299b;

        /* renamed from: c, reason: collision with root package name */
        private int f7300c;

        /* renamed from: d, reason: collision with root package name */
        private int f7301d;

        /* renamed from: e, reason: collision with root package name */
        private int f7302e;

        /* renamed from: f, reason: collision with root package name */
        private float f7303f;

        /* renamed from: g, reason: collision with root package name */
        private float f7304g;

        /* renamed from: h, reason: collision with root package name */
        private long f7305h;

        /* renamed from: i, reason: collision with root package name */
        private int f7306i;

        /* renamed from: j, reason: collision with root package name */
        private int f7307j;

        /* renamed from: k, reason: collision with root package name */
        private int f7308k;

        /* renamed from: m, reason: collision with root package name */
        private int f7310m;

        /* renamed from: p, reason: collision with root package name */
        private float f7313p;

        /* renamed from: q, reason: collision with root package name */
        private final c f7314q;

        /* renamed from: r, reason: collision with root package name */
        private int f7315r;

        /* renamed from: n, reason: collision with root package name */
        private float f7311n = ViewConfiguration.getScrollFriction();

        /* renamed from: o, reason: collision with root package name */
        private int f7312o = 0;

        /* renamed from: l, reason: collision with root package name */
        private boolean f7309l = true;

        static {
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15 = 0.0f;
            int i5 = 0;
            float f16 = 0.0f;
            while (true) {
                float f17 = 1.0f;
                if (i5 >= 100) {
                    float[] fArr = f7296t;
                    f7297u[100] = 1.0f;
                    fArr[100] = 1.0f;
                    return;
                }
                float f18 = i5 / 100.0f;
                float f19 = 1.0f;
                while (true) {
                    f5 = ((f19 - f15) / 2.0f) + f15;
                    f6 = f17 - f5;
                    f7 = f5 * 3.0f * f6;
                    f8 = f5 * f5 * f5;
                    float f20 = (((f6 * 0.175f) + (f5 * 0.35000002f)) * f7) + f8;
                    f9 = f17;
                    f10 = f18;
                    if (Math.abs(f20 - f18) < 1.0E-5d) {
                        break;
                    }
                    if (f20 > f10) {
                        f19 = f5;
                    } else {
                        f15 = f5;
                    }
                    f17 = f9;
                    f18 = f10;
                }
                f7296t[i5] = (f7 * ((f6 * 0.5f) + f5)) + f8;
                float f21 = f9;
                while (true) {
                    f11 = ((f21 - f16) / 2.0f) + f16;
                    f12 = f9 - f11;
                    f13 = f11 * 3.0f * f12;
                    f14 = f11 * f11 * f11;
                    float f22 = (((f12 * 0.5f) + f11) * f13) + f14;
                    if (Math.abs(f22 - f10) < 1.0E-5d) {
                        break;
                    } else if (f22 > f10) {
                        f21 = f11;
                    } else {
                        f16 = f11;
                    }
                }
                f7297u[i5] = (f13 * ((f12 * 0.175f) + (f11 * 0.35000002f))) + f14;
                i5++;
            }
        }

        b(Context context, boolean z5) {
            this.f7298a = context;
            this.f7313p = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
            this.f7314q = new c(context, z5);
        }

        private void f(int i5, int i6, int i7) {
            if (this.f7314q.J()) {
                this.f7306i = this.f7314q.p(this.f7302e, i5, i6, i7);
                return;
            }
            float fAbs = Math.abs((i7 - i5) / (i6 - i5));
            int i8 = (int) (fAbs * 100.0f);
            if (i8 < 100) {
                float f5 = i8 / 100.0f;
                int i9 = i8 + 1;
                float[] fArr = f7297u;
                float f6 = fArr[i8];
                this.f7306i = (int) (this.f7306i * (f6 + (((fAbs - f5) / ((i9 / 100.0f) - f5)) * (fArr[i9] - f6))));
            }
        }

        private void i(int i5, int i6, int i7) {
            if (this.f7314q.J()) {
                this.f7299b = i5;
                this.f7300c = i5;
                this.f7302e = i7;
                this.f7315r = i6;
                return;
            }
            float f5 = (-i7) / this.f7304g;
            float f6 = i7;
            float fSqrt = (float) Math.sqrt((((((f6 * f6) / 2.0f) / Math.abs(r1)) + Math.abs(i6 - i5)) * 2.0d) / Math.abs(this.f7304g));
            this.f7305h -= (int) ((fSqrt - f5) * 1000.0f);
            this.f7299b = i6;
            this.f7300c = i6;
            this.f7302e = (int) ((-this.f7304g) * fSqrt);
        }

        private static float k(int i5) {
            return i5 > 0 ? -2000.0f : 2000.0f;
        }

        private double l(int i5) {
            return Math.log((Math.abs(i5) * 0.35f) / (this.f7311n * this.f7313p));
        }

        private double m(int i5) {
            if (this.f7314q.J()) {
                return this.f7314q.x(i5);
            }
            double dL = l(i5);
            float f5 = f7295s;
            return this.f7311n * this.f7313p * Math.exp((f5 / (f5 - 1.0d)) * dL);
        }

        private int n(int i5) {
            return this.f7314q.J() ? this.f7314q.z(i5) : (int) (Math.exp(l(i5) / (f7295s - 1.0d)) * 1000.0d);
        }

        private void o() {
            this.f7314q.q("onEdgeReached, mVelocity=" + this.f7302e + ", over=" + this.f7310m);
            if (!this.f7314q.J()) {
                int i5 = this.f7302e;
                float f5 = i5 * i5;
                float fAbs = f5 / (Math.abs(this.f7304g) * 2.0f);
                float fSignum = Math.signum(this.f7302e);
                int i6 = this.f7310m;
                if (fAbs > i6) {
                    this.f7304g = ((-fSignum) * f5) / (i6 * 2.0f);
                    fAbs = i6;
                }
                this.f7310m = (int) fAbs;
                this.f7312o = 2;
                int i7 = this.f7299b;
                int i8 = this.f7302e;
                if (i8 <= 0) {
                    fAbs = -fAbs;
                }
                this.f7301d = i7 + ((int) fAbs);
                this.f7306i = -((int) ((i8 * 1000.0f) / this.f7304g));
                return;
            }
            if (Math.abs(this.f7302e) > this.f7314q.v()) {
                this.f7314q.q("onEdgeReached, limitedVelocity=" + this.f7314q.v());
                this.f7302e = (int) (Math.signum((float) this.f7302e) * ((float) this.f7314q.v()));
            }
            this.f7314q.B();
            if (this.f7310m <= 0) {
                this.f7310m = 0;
                this.f7312o = 2;
                this.f7301d = this.f7299b;
                this.f7306i = 0;
            } else {
                double dR = this.f7314q.r();
                c.a aVarI = this.f7314q.I(0.0d, this.f7302e, dR, 0.0d);
                float fAbs2 = Math.abs(aVarI.f7327a);
                int i9 = this.f7310m;
                if (fAbs2 > i9) {
                    double dW = this.f7314q.w(i9, this.f7302e);
                    this.f7314q.q("onEdgeReached, wantOver=" + aVarI.f7327a + ", resetNaturalFreq=" + dW);
                    this.f7314q.F(dW);
                    dR = this.f7314q.r();
                    aVarI = this.f7314q.I(0.0d, (double) this.f7302e, dR, 0.0d);
                }
                this.f7310m = (int) aVarI.f7327a;
                this.f7312o = 2;
                this.f7301d = (int) (this.f7299b + aVarI.f7327a);
                this.f7306i = (int) dR;
            }
            this.f7314q.q("onEdgeReached, over=" + this.f7310m + ", final=" + this.f7301d + ", duration=" + this.f7306i);
        }

        private int p(long j5) {
            return (int) Math.round(this.f7310m * (Math.pow(((j5 * 1.0f) / this.f7306i) - 1.0f, 5.0d) + 1.0d));
        }

        private void r(int i5, int i6, int i7, int i8) {
            this.f7314q.q("startAfterEdge, start=" + i5 + ", min=" + i6 + ", max=" + i7 + ", velocity=" + i8);
            if (i5 > i6 && i5 < i7) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.f7309l = true;
                return;
            }
            boolean z5 = i5 > i7;
            int i9 = z5 ? i7 : i6;
            if ((i5 - i9) * i8 >= 0) {
                s(i5, i9, i8);
            } else if (m(i8) > Math.abs(r2)) {
                j(i5, i8, z5 ? i6 : i5, z5 ? i5 : i7, this.f7310m);
            } else {
                t(i5, i9, i8);
            }
        }

        private void s(int i5, int i6, int i7) {
            this.f7314q.q("startBounceAfterEdge, start=" + i5 + ", end=" + i6 + ", velocity=" + i7);
            this.f7304g = k(i7 == 0 ? i5 - i6 : i7);
            i(i5, i6, i7);
            o();
        }

        private void t(int i5, int i6, int i7) {
            this.f7314q.q("startSpringBack, start=" + i5 + ", end=" + i6 + ", velocity=" + i7);
            if (!this.f7314q.J()) {
                this.f7309l = false;
                this.f7312o = 1;
                this.f7299b = i5;
                this.f7300c = i5;
                this.f7301d = i6;
                int i8 = i5 - i6;
                this.f7304g = k(i8);
                this.f7302e = -i8;
                this.f7310m = Math.abs(i8);
                this.f7306i = (int) (Math.sqrt((i8 * (-2.0d)) / this.f7304g) * 1000.0d);
                return;
            }
            this.f7309l = false;
            this.f7312o = 1;
            this.f7299b = i5;
            this.f7300c = i5;
            this.f7301d = i6;
            int i9 = i5 - i6;
            this.f7304g = k(i9);
            this.f7302e = -i9;
            this.f7310m = Math.abs(i9);
            this.f7314q.C();
            this.f7306i = (int) this.f7314q.s(i5, 0.0d, i6);
        }

        boolean g() {
            int i5 = this.f7312o;
            if (i5 != 0) {
                if (i5 == 1) {
                    return false;
                }
                if (i5 == 2) {
                    this.f7305h += this.f7306i;
                    t(this.f7301d, this.f7315r, 0);
                }
            } else {
                if (this.f7306i >= this.f7307j) {
                    return false;
                }
                int i6 = this.f7301d;
                this.f7299b = i6;
                this.f7300c = i6;
                this.f7315r = i6;
                int i7 = (int) this.f7303f;
                this.f7302e = i7;
                this.f7304g = k(i7);
                this.f7305h += this.f7306i;
                o();
            }
            u();
            return true;
        }

        void h() {
            this.f7314q.q("finish, ");
            this.f7300c = this.f7301d;
            this.f7309l = true;
        }

        void j(int i5, int i6, int i7, int i8, int i9) {
            double dM;
            this.f7314q.q("fling, start=" + i5 + ", velocity=" + i6 + ", min=" + i7 + ", max=" + i8 + ", over=" + i9);
            this.f7310m = i9;
            this.f7309l = false;
            this.f7302e = i6;
            this.f7303f = (float) i6;
            this.f7307j = 0;
            this.f7306i = 0;
            this.f7305h = AnimationUtils.currentAnimationTimeMillis();
            this.f7299b = i5;
            this.f7300c = i5;
            if (i5 > i8 || i5 < i7) {
                r(i5, i7, i8, i6);
                return;
            }
            this.f7312o = 0;
            if (i6 != 0) {
                int iN = n(i6);
                this.f7307j = iN;
                this.f7306i = iN;
                dM = m(i6);
            } else {
                dM = 0.0d;
            }
            int iSignum = (int) (dM * Math.signum(r0));
            this.f7308k = iSignum;
            int i10 = i5 + iSignum;
            this.f7301d = i10;
            if (i10 < i7) {
                f(this.f7299b, i10, i7);
                this.f7301d = i7;
            }
            int i11 = this.f7301d;
            if (i11 > i8) {
                f(this.f7299b, i11, i8);
                this.f7301d = i8;
            }
        }

        boolean q(int i5, int i6, int i7) {
            this.f7309l = true;
            this.f7301d = i5;
            this.f7299b = i5;
            this.f7300c = i5;
            this.f7302e = 0;
            this.f7305h = AnimationUtils.currentAnimationTimeMillis();
            this.f7306i = 0;
            if (i5 < i6) {
                t(i5, i6, 0);
            } else if (i5 > i7) {
                t(i5, i7, 0);
            }
            return !this.f7309l;
        }

        boolean u() {
            float f5;
            float f6;
            float fU;
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f7305h;
            if (jCurrentAnimationTimeMillis == 0) {
                return this.f7306i > 0;
            }
            if (jCurrentAnimationTimeMillis > this.f7306i) {
                return false;
            }
            double dP = 0.0d;
            if (!this.f7314q.J()) {
                int i5 = this.f7312o;
                if (i5 == 0) {
                    int i6 = this.f7307j;
                    float f7 = jCurrentAnimationTimeMillis / i6;
                    int i7 = (int) (f7 * 100.0f);
                    if (i7 < 100) {
                        float f8 = i7 / 100.0f;
                        int i8 = i7 + 1;
                        float[] fArr = f7296t;
                        float f9 = fArr[i7];
                        f6 = (fArr[i8] - f9) / ((i8 / 100.0f) - f8);
                        f5 = f9 + ((f7 - f8) * f6);
                    } else {
                        f5 = 1.0f;
                        f6 = 0.0f;
                    }
                    int i9 = this.f7308k;
                    dP = f5 * i9;
                    this.f7303f = ((f6 * i9) / i6) * 1000.0f;
                } else if (i5 == 1) {
                    float f10 = jCurrentAnimationTimeMillis / this.f7306i;
                    float fSignum = Math.signum(this.f7302e);
                    this.f7303f = fSignum * this.f7310m * 6.0f * ((-f10) + (f10 * f10));
                    dP = p(jCurrentAnimationTimeMillis) * fSignum;
                } else if (i5 == 2) {
                    float f11 = jCurrentAnimationTimeMillis / 1000.0f;
                    int i10 = this.f7302e;
                    float f12 = this.f7304g;
                    this.f7303f = i10 + (f12 * f11);
                    dP = (i10 * f11) + (((f12 * f11) * f11) / 2.0f);
                }
                this.f7300c = this.f7299b + ((int) Math.round(dP));
                return true;
            }
            int i11 = this.f7312o;
            if (i11 != 0) {
                if (i11 == 1) {
                    c.a aVarI = this.f7314q.I(0.0d, 0.0d, jCurrentAnimationTimeMillis, this.f7301d - this.f7299b);
                    dP = aVarI.f7327a;
                    this.f7303f = aVarI.f7328b;
                } else if (i11 == 2) {
                    c.a aVarI2 = this.f7314q.I(0.0d, this.f7302e, jCurrentAnimationTimeMillis, 0.0d);
                    this.f7303f = aVarI2.f7328b;
                    fU = aVarI2.f7327a;
                }
                this.f7300c = this.f7299b + ((int) Math.round(dP));
                this.f7314q.K("CurrentPosition=" + this.f7300c);
                this.f7314q.K("CurrVelocity=" + this.f7303f);
                return true;
            }
            this.f7303f = this.f7314q.t(this.f7302e, jCurrentAnimationTimeMillis);
            fU = this.f7314q.u(this.f7302e, jCurrentAnimationTimeMillis);
            dP = fU;
            this.f7300c = this.f7299b + ((int) Math.round(dP));
            this.f7314q.K("CurrentPosition=" + this.f7300c);
            this.f7314q.K("CurrVelocity=" + this.f7303f);
            return true;
        }

        void v(float f5) {
            this.f7300c = this.f7299b + Math.round(f5 * (this.f7301d - r0));
        }
    }

    private static class c {

        /* renamed from: a, reason: collision with root package name */
        private Context f7316a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f7317b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f7318c;

        /* renamed from: d, reason: collision with root package name */
        private float f7319d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f7320e;

        /* renamed from: f, reason: collision with root package name */
        private float f7321f;

        /* renamed from: g, reason: collision with root package name */
        private float f7322g;

        /* renamed from: h, reason: collision with root package name */
        private double f7323h;

        /* renamed from: i, reason: collision with root package name */
        private final float f7324i;

        /* renamed from: j, reason: collision with root package name */
        private final float f7325j;

        /* renamed from: k, reason: collision with root package name */
        private final int f7326k;

        private static class a {

            /* renamed from: a, reason: collision with root package name */
            private final float f7327a;

            /* renamed from: b, reason: collision with root package name */
            private final float f7328b;

            private a(float f5, float f6) {
                this.f7327a = f5;
                this.f7328b = f6;
            }
        }

        private float A() {
            return this.f7319d * 0.75f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void B() {
            G(this.f7324i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C() {
            G(this.f7325j);
        }

        private void E(float f5) {
            this.f7319d = f5;
            H(f5 * 0.75f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void F(double d6) {
            this.f7323h = d6;
        }

        private void G(float f5) {
            if (f5 <= 0.0f) {
                throw new IllegalArgumentException("Spring stiffness constant must be positive.");
            }
            this.f7323h = Math.sqrt(f5);
        }

        private void H(float f5) {
            this.f7322g = f5 * 62.5f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a I(double d6, double d7, double d8, double d9) {
            double d10 = d8 / 1000.0d;
            double d11 = d6 - d9;
            double d12 = this.f7323h;
            double d13 = d7 + (d12 * d11);
            double d14 = d11 + (d13 * d10);
            double dPow = Math.pow(2.718281828459045d, (-d12) * d10) * d14;
            double dPow2 = d14 * Math.pow(2.718281828459045d, (-this.f7323h) * d10);
            double d15 = this.f7323h;
            return new a((float) (dPow + d9), (float) ((dPow2 * (-d15)) + (d13 * Math.pow(2.718281828459045d, (-d15) * d10))));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean J() {
            return this.f7318c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void K(String str) {
            if (this.f7320e) {
                if (this.f7317b) {
                    Log.v("OverScroller-Y", str);
                } else {
                    Log.v("OverScroller-X", str);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int p(int i5, int i6, int i7, int i8) {
            float fAbs = Math.abs(i5);
            return y(fAbs, (Math.abs(i8 - i6) * this.f7321f) + fAbs);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q(String str) {
            if (this.f7317b) {
                Log.d("OverScroller-Y", str);
            } else {
                Log.d("OverScroller-X", str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public double r() {
            return 1000.0d / this.f7323h;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public double s(double d6, double d7, double d8) {
            double d9 = d6 - d8;
            return Math.max(Math.log((Math.abs(d9) * 2.0d) / this.f7319d) / this.f7323h, (Math.log((Math.abs(d7 + (this.f7323h * d9)) * 4.0d) / ((this.f7323h * 2.718281828459045d) * this.f7319d)) * 2.0d) / this.f7323h) * 1000.0d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float t(int i5, long j5) {
            return (float) (i5 * Math.exp((j5 / 1000.0f) * this.f7321f));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public float u(int i5, long j5) {
            float fT = t(i5, j5);
            float f5 = this.f7321f;
            return (fT / f5) - (i5 / f5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public double w(double d6, double d7) {
            return Math.abs(d7) / (d6 * 2.718281828459045d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public double x(int i5) {
            return (this.f7322g / this.f7321f) - (Math.abs(i5) / this.f7321f);
        }

        private int y(float f5, float f6) {
            return (int) ((Math.log(f6 / f5) * 1000.0d) / this.f7321f);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int z(int i5) {
            return y(Math.abs(i5), this.f7322g);
        }

        public void D(float f5) {
            this.f7321f = f5 * (-4.2f);
        }

        public int v() {
            return this.f7326k;
        }

        private c(Context context, boolean z5) {
            this.f7319d = 1.0f;
            this.f7321f = -4.2f;
            this.f7323h = Math.sqrt(102.0d);
            this.f7316a = context;
            this.f7317b = z5;
            H(A());
            this.f7318c = Settings.Global.getInt(context.getContentResolver(), "over_scroller_optimizer_enable", 1) == 1;
            this.f7320e = Settings.Global.getInt(context.getContentResolver(), "over_scroller_verbose_enable", 0) == 1;
            E(Settings.Global.getFloat(context.getContentResolver(), "over_scroller_min_change", 0.5f));
            D(Settings.Global.getFloat(context.getContentResolver(), "over_scroller_friction", 2.0f) / 4.2f);
            this.f7324i = Settings.Global.getFloat(context.getContentResolver(), "over_scroller_ballistic_stiffness", 102.0f);
            this.f7325j = Settings.Global.getFloat(context.getContentResolver(), "over_scroller_cubic_stiffness", 163.0f);
            this.f7326k = Settings.Global.getInt(this.f7316a.getContentResolver(), "over_scroller_max_velocity", 7000);
        }
    }

    /* renamed from: a5.d$d, reason: collision with other inner class name */
    static class InterpolatorC0100d implements Interpolator {

        /* renamed from: a, reason: collision with root package name */
        private static final float f7329a;

        /* renamed from: b, reason: collision with root package name */
        private static final float f7330b;

        static {
            float fA = 1.0f / a(1.0f);
            f7329a = fA;
            f7330b = 1.0f - (fA * a(1.0f));
        }

        InterpolatorC0100d() {
        }

        private static float a(float f5) {
            float f6 = f5 * 8.0f;
            return f6 < 1.0f ? f6 - (1.0f - ((float) Math.exp(-f6))) : ((1.0f - ((float) Math.exp(1.0f - f6))) * 0.63212055f) + 0.36787945f;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f5) {
            float fA = f7329a * a(f5);
            return fA > 0.0f ? fA + f7330b : fA;
        }
    }

    public d(Context context) {
        this(context, null);
    }

    private void a(int i5) throws IllegalAccessException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        try {
            if (this.f7293f == null || this.f7294g == null) {
                Class<?> cls = Class.forName("android.util.BoostFramework$ScrollOptimizer");
                this.f7293f = cls;
                this.f7294g = cls.getMethod("setFlingFlag", Integer.TYPE);
            }
            Method method = this.f7294g;
            if (method != null) {
                method.setAccessible(true);
                this.f7294g.invoke(null, Integer.valueOf(i5));
            }
        } catch (ClassNotFoundException e6) {
            e6.printStackTrace();
        } catch (IllegalAccessException e7) {
            e7.printStackTrace();
        } catch (IllegalArgumentException e8) {
            e8.printStackTrace();
        } catch (NoSuchMethodException e9) {
            e9.printStackTrace();
        } catch (InvocationTargetException e10) {
            if (e10.getTargetException() != null) {
                e10.getTargetException().printStackTrace();
            }
        }
    }

    public void b() throws IllegalAccessException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        a(0);
        this.f7289b.h();
        this.f7290c.h();
    }

    public boolean c() throws IllegalAccessException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (g()) {
            a(0);
            return false;
        }
        int i5 = this.f7288a;
        if (i5 == 0) {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f7289b.f7305h;
            int i6 = this.f7289b.f7306i;
            if (jCurrentAnimationTimeMillis < i6) {
                float interpolation = this.f7291d.getInterpolation(jCurrentAnimationTimeMillis / i6);
                this.f7289b.v(interpolation);
                this.f7290c.v(interpolation);
            } else {
                b();
            }
        } else if (i5 == 1) {
            if (!this.f7289b.f7309l && !this.f7289b.u() && !this.f7289b.g()) {
                this.f7289b.h();
            }
            if (!this.f7290c.f7309l && !this.f7290c.u() && !this.f7290c.g()) {
                this.f7290c.h();
            }
        }
        if (g()) {
            a(0);
        }
        return true;
    }

    public void d(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) throws IllegalAccessException, SecurityException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.f7292e && !g()) {
            float f5 = this.f7289b.f7303f;
            float f6 = this.f7290c.f7303f;
            float f7 = i7;
            if (Math.signum(f7) == Math.signum(f5)) {
                float f8 = i8;
                if (Math.signum(f8) == Math.signum(f6)) {
                    i7 = (int) (f7 + f5);
                    i8 = (int) (f8 + f6);
                }
            }
        }
        a(1);
        this.f7288a = 1;
        this.f7289b.j(i5, i7, i9, i10, i13);
        this.f7290c.j(i6, i8, i11, i12, i14);
    }

    public final int e() {
        return this.f7289b.f7300c;
    }

    public final int f() {
        return this.f7290c.f7300c;
    }

    public final boolean g() {
        return this.f7289b.f7309l && this.f7290c.f7309l;
    }

    public boolean h(int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f7288a = 1;
        return this.f7289b.q(i5, i7, i8) || this.f7290c.q(i6, i9, i10);
    }

    public d(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public d(Context context, Interpolator interpolator, boolean z5) {
        if (interpolator == null) {
            this.f7291d = new InterpolatorC0100d();
        } else {
            this.f7291d = interpolator;
        }
        this.f7292e = z5;
        this.f7289b = new b(context, false);
        this.f7290c = new b(context, true);
    }
}
