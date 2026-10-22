package g0;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import g.t0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class c implements View.OnTouchListener {

    /* renamed from: s, reason: collision with root package name */
    public static final int f2888s = ViewConfiguration.getTapTimeout();

    /* renamed from: a, reason: collision with root package name */
    public final a f2889a;

    /* renamed from: b, reason: collision with root package name */
    public final AccelerateInterpolator f2890b;

    /* renamed from: c, reason: collision with root package name */
    public final t0 f2891c;
    public androidx.fragment.app.b d;

    /* renamed from: e, reason: collision with root package name */
    public final float[] f2892e;

    /* renamed from: f, reason: collision with root package name */
    public final float[] f2893f;

    /* renamed from: g, reason: collision with root package name */
    public final int f2894g;

    /* renamed from: h, reason: collision with root package name */
    public final int f2895h;

    /* renamed from: j, reason: collision with root package name */
    public final float[] f2896j;

    /* renamed from: k, reason: collision with root package name */
    public final float[] f2897k;

    /* renamed from: l, reason: collision with root package name */
    public final float[] f2898l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2899m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f2900n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f2901o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f2902p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2903q;

    /* renamed from: r, reason: collision with root package name */
    public final t0 f2904r;

    public c(t0 t0Var) {
        a aVar = new a();
        aVar.f2883e = Long.MIN_VALUE;
        aVar.f2885g = -1L;
        aVar.f2884f = 0L;
        this.f2889a = aVar;
        this.f2890b = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.f2892e = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f2893f = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.f2896j = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.f2897k = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f2898l = fArr5;
        this.f2891c = t0Var;
        float f3 = Resources.getSystem().getDisplayMetrics().density;
        float f7 = ((int) ((1575.0f * f3) + 0.5f)) / 1000.0f;
        fArr5[0] = f7;
        fArr5[1] = f7;
        float f9 = ((int) ((f3 * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f9;
        fArr4[1] = f9;
        this.f2894g = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.f2895h = f2888s;
        aVar.f2880a = 500;
        aVar.f2881b = 500;
        this.f2904r = t0Var;
    }

    public static float b(float f3, float f7, float f9) {
        return f3 > f9 ? f9 : f3 < f7 ? f7 : f3;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float a(int r4, float r5, float r6, float r7) {
        /*
            r3 = this;
            float[] r0 = r3.f2892e
            r0 = r0[r4]
            float[] r1 = r3.f2893f
            r1 = r1[r4]
            float r0 = r0 * r6
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r5, r0)
            float r6 = r6 - r5
            float r5 = r3.c(r6, r0)
            float r5 = r5 - r1
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            android.view.animation.AccelerateInterpolator r0 = r3.f2890b
            if (r6 >= 0) goto L25
            float r5 = -r5
            float r5 = r0.getInterpolation(r5)
            float r5 = -r5
            goto L2d
        L25:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 <= 0) goto L36
            float r5 = r0.getInterpolation(r5)
        L2d:
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r5 = b(r5, r6, r0)
            goto L37
        L36:
            r5 = r2
        L37:
            int r6 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r6 != 0) goto L3c
            return r2
        L3c:
            float[] r0 = r3.f2896j
            r0 = r0[r4]
            float[] r1 = r3.f2897k
            r1 = r1[r4]
            float[] r3 = r3.f2898l
            r3 = r3[r4]
            float r0 = r0 * r7
            if (r6 <= 0) goto L51
            float r5 = r5 * r0
            float r3 = b(r5, r1, r3)
            return r3
        L51:
            float r4 = -r5
            float r4 = r4 * r0
            float r3 = b(r4, r1, r3)
            float r3 = -r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: g0.c.a(int, float, float, float):float");
    }

    public final float c(float f3, float f7) {
        if (f7 != 0.0f) {
            int i8 = this.f2894g;
            if (i8 == 0 || i8 == 1) {
                if (f3 < f7) {
                    if (f3 >= 0.0f) {
                        return 1.0f - (f3 / f7);
                    }
                    if (this.f2902p && i8 == 1) {
                        return 1.0f;
                    }
                }
            } else if (i8 == 2 && f3 < 0.0f) {
                return f3 / (-f7);
            }
        }
        return 0.0f;
    }

    public final void d() {
        int i8 = 0;
        if (this.f2900n) {
            this.f2902p = false;
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        a aVar = this.f2889a;
        int i9 = (int) (jCurrentAnimationTimeMillis - aVar.f2883e);
        int i10 = aVar.f2881b;
        if (i9 > i10) {
            i8 = i10;
        } else if (i9 >= 0) {
            i8 = i9;
        }
        aVar.f2887i = i8;
        aVar.f2886h = aVar.a(jCurrentAnimationTimeMillis);
        aVar.f2885g = jCurrentAnimationTimeMillis;
    }

    public final boolean e() {
        t0 t0Var;
        int count;
        a aVar = this.f2889a;
        float f3 = aVar.d;
        int iAbs = (int) (f3 / Math.abs(f3));
        Math.abs(aVar.f2882c);
        if (iAbs != 0 && (count = (t0Var = this.f2904r).getCount()) != 0) {
            int childCount = t0Var.getChildCount();
            int firstVisiblePosition = t0Var.getFirstVisiblePosition();
            int i8 = firstVisiblePosition + childCount;
            if (iAbs <= 0 ? !(iAbs >= 0 || (firstVisiblePosition <= 0 && t0Var.getChildAt(0).getTop() >= 0)) : !(i8 >= count && t0Var.getChildAt(childCount - 1).getBottom() <= t0Var.getHeight())) {
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
            boolean r0 = r7.f2903q
            r1 = 0
            if (r0 != 0) goto L7
            goto L7d
        L7:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1b
            if (r0 == r2) goto L17
            r3 = 2
            if (r0 == r3) goto L1f
            r8 = 3
            if (r0 == r8) goto L17
            goto L7d
        L17:
            r7.d()
            return r1
        L1b:
            r7.f2901o = r2
            r7.f2899m = r1
        L1f:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            g.t0 r4 = r7.f2891c
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.a(r1, r0, r3, r5)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.a(r2, r9, r8, r3)
            g0.a r9 = r7.f2889a
            r9.f2882c = r0
            r9.d = r8
            boolean r8 = r7.f2902p
            if (r8 != 0) goto L7d
            boolean r8 = r7.e()
            if (r8 == 0) goto L7d
            androidx.fragment.app.b r8 = r7.d
            if (r8 != 0) goto L61
            androidx.fragment.app.b r8 = new androidx.fragment.app.b
            r9 = 5
            r8.<init>(r9, r7)
            r7.d = r8
        L61:
            r7.f2902p = r2
            r7.f2900n = r2
            boolean r8 = r7.f2899m
            if (r8 != 0) goto L76
            int r8 = r7.f2895h
            if (r8 <= 0) goto L76
            androidx.fragment.app.b r9 = r7.d
            long r5 = (long) r8
            int[] r8 = e0.a0.f2285a
            r4.postOnAnimationDelayed(r9, r5)
            goto L7b
        L76:
            androidx.fragment.app.b r8 = r7.d
            r8.run()
        L7b:
            r7.f2899m = r2
        L7d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: g0.c.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
