package r3;

import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import androidx.fragment.app.r;
import m.j1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements View.OnTouchListener {

    /* renamed from: v, reason: collision with root package name */
    public static final int f10443v = ViewConfiguration.getTapTimeout();

    /* renamed from: c, reason: collision with root package name */
    public a f10444c;

    /* renamed from: f, reason: collision with root package name */
    public AccelerateInterpolator f10445f;

    /* renamed from: g, reason: collision with root package name */
    public j1 f10446g;

    /* renamed from: h, reason: collision with root package name */
    public r f10447h;
    public float[] i;

    /* renamed from: j, reason: collision with root package name */
    public float[] f10448j;

    /* renamed from: k, reason: collision with root package name */
    public int f10449k;

    /* renamed from: l, reason: collision with root package name */
    public int f10450l;

    /* renamed from: m, reason: collision with root package name */
    public float[] f10451m;

    /* renamed from: n, reason: collision with root package name */
    public float[] f10452n;

    /* renamed from: o, reason: collision with root package name */
    public float[] f10453o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f10454p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f10455q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f10456r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f10457s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f10458t;

    /* renamed from: u, reason: collision with root package name */
    public j1 f10459u;

    public static float b(float f5, float f10, float f11) {
        return f5 > f11 ? f11 : f5 < f10 ? f10 : f5;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float a(float r5, float r6, float r7, int r8) {
        /*
            r4 = this;
            float[] r0 = r4.i
            r0 = r0[r8]
            float[] r1 = r4.f10448j
            r1 = r1[r8]
            android.view.animation.AccelerateInterpolator r2 = r4.f10445f
            float r0 = r0 * r6
            r3 = 0
            float r0 = b(r0, r3, r1)
            float r1 = r4.c(r5, r0)
            float r6 = r6 - r5
            float r5 = r4.c(r6, r0)
            float r5 = r5 - r1
            int r6 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r6 >= 0) goto L25
            float r5 = -r5
            float r5 = r2.getInterpolation(r5)
            float r5 = -r5
            goto L2d
        L25:
            int r6 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r6 <= 0) goto L36
            float r5 = r2.getInterpolation(r5)
        L2d:
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r5 = b(r5, r6, r0)
            goto L37
        L36:
            r5 = r3
        L37:
            int r6 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r6 != 0) goto L3c
            return r3
        L3c:
            float[] r0 = r4.f10451m
            r0 = r0[r8]
            float[] r1 = r4.f10452n
            r1 = r1[r8]
            float[] r4 = r4.f10453o
            r4 = r4[r8]
            float r0 = r0 * r7
            if (r6 <= 0) goto L51
            float r5 = r5 * r0
            float r4 = b(r5, r1, r4)
            return r4
        L51:
            float r5 = -r5
            float r5 = r5 * r0
            float r4 = b(r5, r1, r4)
            float r4 = -r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.c.a(float, float, float, int):float");
    }

    public final float c(float f5, float f10) {
        if (f10 != 0.0f) {
            int i = this.f10449k;
            if (i == 0 || i == 1) {
                if (f5 < f10) {
                    if (f5 >= 0.0f) {
                        return 1.0f - (f5 / f10);
                    }
                    if (this.f10457s && i == 1) {
                        return 1.0f;
                    }
                }
            } else if (i == 2 && f5 < 0.0f) {
                return f5 / (-f10);
            }
        }
        return 0.0f;
    }

    public final void d() {
        int i = 0;
        if (this.f10455q) {
            this.f10457s = false;
            return;
        }
        a aVar = this.f10444c;
        aVar.getClass();
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i3 = (int) (jCurrentAnimationTimeMillis - aVar.f10439e);
        int i10 = aVar.f10436b;
        if (i3 > i10) {
            i = i10;
        } else if (i3 >= 0) {
            i = i3;
        }
        aVar.i = i;
        aVar.f10442h = aVar.a(jCurrentAnimationTimeMillis);
        aVar.f10441g = jCurrentAnimationTimeMillis;
    }

    public final boolean e() {
        j1 j1Var;
        int count;
        a aVar = this.f10444c;
        float f5 = aVar.f10438d;
        int iAbs = (int) (f5 / Math.abs(f5));
        Math.abs(aVar.f10437c);
        if (iAbs != 0 && (count = (j1Var = this.f10459u).getCount()) != 0) {
            int childCount = j1Var.getChildCount();
            int firstVisiblePosition = j1Var.getFirstVisiblePosition();
            int i = firstVisiblePosition + childCount;
            if (iAbs <= 0 ? !(iAbs >= 0 || (firstVisiblePosition <= 0 && j1Var.getChildAt(0).getTop() >= 0)) : !(i >= count && j1Var.getChildAt(childCount - 1).getBottom() <= j1Var.getHeight())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0016, code lost:
    
        if (r1 != 3) goto L30;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r7, android.view.MotionEvent r8) {
        /*
            r6 = this;
            m.j1 r0 = r6.f10446g
            boolean r1 = r6.f10458t
            r2 = 0
            if (r1 != 0) goto L9
            goto L83
        L9:
            int r1 = r8.getActionMasked()
            r3 = 1
            if (r1 == 0) goto L1d
            if (r1 == r3) goto L19
            r4 = 2
            if (r1 == r4) goto L21
            r7 = 3
            if (r1 == r7) goto L19
            goto L83
        L19:
            r6.d()
            return r2
        L1d:
            r6.f10456r = r3
            r6.f10454p = r2
        L21:
            float r1 = r8.getX()
            int r4 = r7.getWidth()
            float r4 = (float) r4
            int r5 = r0.getWidth()
            float r5 = (float) r5
            float r1 = r6.a(r1, r4, r5, r2)
            float r8 = r8.getY()
            int r7 = r7.getHeight()
            float r7 = (float) r7
            int r4 = r0.getHeight()
            float r4 = (float) r4
            float r7 = r6.a(r8, r7, r4, r3)
            r3.a r8 = r6.f10444c
            r8.f10437c = r1
            r8.f10438d = r7
            boolean r7 = r6.f10457s
            if (r7 != 0) goto L83
            boolean r7 = r6.e()
            if (r7 == 0) goto L83
            androidx.fragment.app.r r7 = r6.f10447h
            if (r7 != 0) goto L67
            androidx.fragment.app.r r7 = new androidx.fragment.app.r
            r8 = 10
            r7.<init>(r8)
            r7.f1301f = r6
            java.lang.invoke.VarHandle.storeStoreFence()
            r6.f10447h = r7
        L67:
            r6.f10457s = r3
            r6.f10455q = r3
            boolean r7 = r6.f10454p
            if (r7 != 0) goto L7c
            int r7 = r6.f10450l
            if (r7 <= 0) goto L7c
            androidx.fragment.app.r r8 = r6.f10447h
            long r4 = (long) r7
            java.util.WeakHashMap r7 = n3.k0.f8724a
            r0.postOnAnimationDelayed(r8, r4)
            goto L81
        L7c:
            androidx.fragment.app.r r7 = r6.f10447h
            r7.run()
        L81:
            r6.f10454p = r3
        L83:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.c.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
