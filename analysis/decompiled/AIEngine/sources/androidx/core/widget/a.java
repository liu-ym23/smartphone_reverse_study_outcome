package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import androidx.appcompat.widget.g0;
import java.util.WeakHashMap;
import v0.e0;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {

    /* renamed from: t, reason: collision with root package name */
    public static final int f1553t = ViewConfiguration.getTapTimeout();

    /* renamed from: a, reason: collision with root package name */
    public final C0009a f1554a;

    /* renamed from: b, reason: collision with root package name */
    public final AccelerateInterpolator f1555b;

    /* renamed from: c, reason: collision with root package name */
    public final g0 f1556c;

    /* renamed from: d, reason: collision with root package name */
    public b f1557d;

    /* renamed from: e, reason: collision with root package name */
    public final float[] f1558e;
    public final float[] h;

    /* renamed from: j, reason: collision with root package name */
    public final int f1559j;

    /* renamed from: k, reason: collision with root package name */
    public final int f1560k;

    /* renamed from: l, reason: collision with root package name */
    public final float[] f1561l;

    /* renamed from: m, reason: collision with root package name */
    public final float[] f1562m;

    /* renamed from: n, reason: collision with root package name */
    public final float[] f1563n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f1564o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1565p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1566q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1567s;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: androidx.core.widget.a$a, reason: collision with other inner class name */
    public static class C0009a {

        /* renamed from: a, reason: collision with root package name */
        public int f1568a;

        /* renamed from: b, reason: collision with root package name */
        public int f1569b;

        /* renamed from: c, reason: collision with root package name */
        public float f1570c;

        /* renamed from: d, reason: collision with root package name */
        public float f1571d;

        /* renamed from: e, reason: collision with root package name */
        public long f1572e;

        /* renamed from: f, reason: collision with root package name */
        public long f1573f;

        /* renamed from: g, reason: collision with root package name */
        public long f1574g;
        public float h;

        /* renamed from: i, reason: collision with root package name */
        public int f1575i;

        public final float a(long j10) {
            if (j10 < this.f1572e) {
                return 0.0f;
            }
            long j11 = this.f1574g;
            if (j11 < 0 || j10 < j11) {
                return a.b((j10 - r0) / this.f1568a, 0.0f, 1.0f) * 0.5f;
            }
            float f8 = this.h;
            return (a.b((j10 - j11) / this.f1575i, 0.0f, 1.0f) * f8) + (1.0f - f8);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a aVar = a.this;
            g0 g0Var = aVar.f1556c;
            C0009a c0009a = aVar.f1554a;
            if (aVar.r) {
                if (aVar.f1565p) {
                    aVar.f1565p = false;
                    long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                    c0009a.f1572e = jCurrentAnimationTimeMillis;
                    c0009a.f1574g = -1L;
                    c0009a.f1573f = jCurrentAnimationTimeMillis;
                    c0009a.h = 0.5f;
                }
                if ((c0009a.f1574g > 0 && AnimationUtils.currentAnimationTimeMillis() > c0009a.f1574g + c0009a.f1575i) || !aVar.e()) {
                    aVar.r = false;
                    return;
                }
                if (aVar.f1566q) {
                    aVar.f1566q = false;
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    g0Var.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                }
                if (c0009a.f1573f == 0) {
                    throw new RuntimeException("Cannot compute scroll delta before calling start()");
                }
                long jCurrentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                float fA = c0009a.a(jCurrentAnimationTimeMillis2);
                long j10 = jCurrentAnimationTimeMillis2 - c0009a.f1573f;
                c0009a.f1573f = jCurrentAnimationTimeMillis2;
                ((c) aVar).f1577u.scrollListBy((int) (j10 * ((fA * 4.0f) + ((-4.0f) * fA * fA)) * c0009a.f1571d));
                WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                g0Var.postOnAnimation(this);
            }
        }
    }

    public a(g0 g0Var) {
        C0009a c0009a = new C0009a();
        c0009a.f1572e = Long.MIN_VALUE;
        c0009a.f1574g = -1L;
        c0009a.f1573f = 0L;
        this.f1554a = c0009a;
        this.f1555b = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.f1558e = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.h = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.f1561l = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.f1562m = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f1563n = fArr5;
        this.f1556c = g0Var;
        float f8 = Resources.getSystem().getDisplayMetrics().density;
        float f9 = ((int) ((1575.0f * f8) + 0.5f)) / 1000.0f;
        fArr5[0] = f9;
        fArr5[1] = f9;
        float f10 = ((int) ((f8 * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f10;
        fArr4[1] = f10;
        this.f1559j = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.f1560k = f1553t;
        c0009a.f1568a = 500;
        c0009a.f1569b = 500;
    }

    public static float b(float f8, float f9, float f10) {
        return f8 > f10 ? f10 : f8 < f9 ? f9 : f8;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float a(float r4, float r5, float r6, int r7) {
        /*
            r3 = this;
            float[] r0 = r3.f1558e
            r0 = r0[r7]
            float[] r1 = r3.h
            r1 = r1[r7]
            float r0 = r0 * r5
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r4, r0)
            float r5 = r5 - r4
            float r4 = r3.c(r5, r0)
            float r4 = r4 - r1
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            android.view.animation.AccelerateInterpolator r0 = r3.f1555b
            if (r5 >= 0) goto L25
            float r4 = -r4
            float r4 = r0.getInterpolation(r4)
            float r4 = -r4
            goto L2d
        L25:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 <= 0) goto L36
            float r4 = r0.getInterpolation(r4)
        L2d:
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r4 = b(r4, r5, r0)
            goto L37
        L36:
            r4 = r2
        L37:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 != 0) goto L3c
            return r2
        L3c:
            float[] r0 = r3.f1561l
            r0 = r0[r7]
            float[] r1 = r3.f1562m
            r1 = r1[r7]
            float[] r3 = r3.f1563n
            r3 = r3[r7]
            float r0 = r0 * r6
            if (r5 <= 0) goto L51
            float r4 = r4 * r0
            float r3 = b(r4, r1, r3)
            return r3
        L51:
            float r4 = -r4
            float r4 = r4 * r0
            float r3 = b(r4, r1, r3)
            float r3 = -r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.a(float, float, float, int):float");
    }

    public final float c(float f8, float f9) {
        if (f9 != 0.0f) {
            int i10 = this.f1559j;
            if (i10 == 0 || i10 == 1) {
                if (f8 < f9) {
                    if (f8 >= 0.0f) {
                        return 1.0f - (f8 / f9);
                    }
                    if (this.r && i10 == 1) {
                        return 1.0f;
                    }
                }
            } else if (i10 == 2 && f8 < 0.0f) {
                return f8 / (-f9);
            }
        }
        return 0.0f;
    }

    public final void d() {
        int i10 = 0;
        if (this.f1565p) {
            this.r = false;
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        C0009a c0009a = this.f1554a;
        int i11 = (int) (jCurrentAnimationTimeMillis - c0009a.f1572e);
        int i12 = c0009a.f1569b;
        if (i11 > i12) {
            i10 = i12;
        } else if (i11 >= 0) {
            i10 = i11;
        }
        c0009a.f1575i = i10;
        c0009a.h = c0009a.a(jCurrentAnimationTimeMillis);
        c0009a.f1574g = jCurrentAnimationTimeMillis;
    }

    public final boolean e() {
        g0 g0Var;
        int count;
        C0009a c0009a = this.f1554a;
        float f8 = c0009a.f1571d;
        int iAbs = (int) (f8 / Math.abs(f8));
        Math.abs(c0009a.f1570c);
        if (iAbs != 0 && (count = (g0Var = ((c) this).f1577u).getCount()) != 0) {
            int childCount = g0Var.getChildCount();
            int firstVisiblePosition = g0Var.getFirstVisiblePosition();
            int i10 = firstVisiblePosition + childCount;
            if (iAbs <= 0 ? !(iAbs >= 0 || (firstVisiblePosition <= 0 && g0Var.getChildAt(0).getTop() >= 0)) : !(i10 >= count && g0Var.getChildAt(childCount - 1).getBottom() <= g0Var.getHeight())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0014, code lost:
    
        if (r0 != 3) goto L30;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            boolean r0 = r7.f1567s
            r1 = 0
            if (r0 != 0) goto L7
            goto L7c
        L7:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1b
            if (r0 == r2) goto L17
            r3 = 2
            if (r0 == r3) goto L1f
            r8 = 3
            if (r0 == r8) goto L17
            goto L7c
        L17:
            r7.d()
            return r1
        L1b:
            r7.f1566q = r2
            r7.f1564o = r1
        L1f:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            androidx.appcompat.widget.g0 r4 = r7.f1556c
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.a(r0, r3, r5, r1)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.a(r9, r8, r3, r2)
            androidx.core.widget.a$a r9 = r7.f1554a
            r9.f1570c = r0
            r9.f1571d = r8
            boolean r8 = r7.r
            if (r8 != 0) goto L7c
            boolean r8 = r7.e()
            if (r8 == 0) goto L7c
            androidx.core.widget.a$b r8 = r7.f1557d
            if (r8 != 0) goto L60
            androidx.core.widget.a$b r8 = new androidx.core.widget.a$b
            r8.<init>()
            r7.f1557d = r8
        L60:
            r7.r = r2
            r7.f1565p = r2
            boolean r8 = r7.f1564o
            if (r8 != 0) goto L75
            int r8 = r7.f1560k
            if (r8 <= 0) goto L75
            androidx.core.widget.a$b r9 = r7.f1557d
            long r5 = (long) r8
            java.util.WeakHashMap<android.view.View, v0.h0> r8 = v0.e0.f13274a
            r4.postOnAnimationDelayed(r9, r5)
            goto L7a
        L75:
            androidx.core.widget.a$b r8 = r7.f1557d
            r8.run()
        L7a:
            r7.f1564o = r2
        L7c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.a.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
