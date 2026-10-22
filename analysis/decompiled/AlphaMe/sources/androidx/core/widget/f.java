package androidx.core.widget;

import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import com.stepos.alphame.utils.Property;
import h.RunnableC0583a;

/* loaded from: classes.dex */
public final class f implements View.OnTouchListener {

    /* renamed from: r, reason: collision with root package name */
    public static final int f3365r = ViewConfiguration.getTapTimeout();

    /* renamed from: a, reason: collision with root package name */
    public final a f3366a;

    /* renamed from: b, reason: collision with root package name */
    public final AccelerateInterpolator f3367b;

    /* renamed from: c, reason: collision with root package name */
    public final View f3368c;

    /* renamed from: d, reason: collision with root package name */
    public RunnableC0583a f3369d;

    /* renamed from: e, reason: collision with root package name */
    public final float[] f3370e;

    /* renamed from: f, reason: collision with root package name */
    public final float[] f3371f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3372g;

    /* renamed from: h, reason: collision with root package name */
    public final int f3373h;

    /* renamed from: i, reason: collision with root package name */
    public final float[] f3374i;

    /* renamed from: j, reason: collision with root package name */
    public final float[] f3375j;

    /* renamed from: k, reason: collision with root package name */
    public final float[] f3376k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3377l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3378m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f3379n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f3380o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f3381p;

    /* renamed from: q, reason: collision with root package name */
    public final ListView f3382q;

    public f(ListView listView) {
        a aVar = new a();
        aVar.f3360e = Long.MIN_VALUE;
        aVar.f3362g = -1L;
        aVar.f3361f = 0L;
        this.f3366a = aVar;
        this.f3367b = new AccelerateInterpolator();
        this.f3370e = new float[]{Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE};
        this.f3371f = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.f3374i = new float[]{Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE};
        this.f3375j = new float[]{Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE};
        this.f3376k = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
        this.f3368c = listView;
        float f4 = Resources.getSystem().getDisplayMetrics().density;
        float[] fArr = this.f3376k;
        float f5 = ((int) ((1575.0f * f4) + 0.5f)) / 1000.0f;
        fArr[0] = f5;
        fArr[1] = f5;
        float[] fArr2 = this.f3375j;
        float f6 = ((int) ((f4 * 315.0f) + 0.5f)) / 1000.0f;
        fArr2[0] = f6;
        fArr2[1] = f6;
        this.f3372g = 1;
        float[] fArr3 = this.f3371f;
        fArr3[0] = Float.MAX_VALUE;
        fArr3[1] = Float.MAX_VALUE;
        float[] fArr4 = this.f3370e;
        fArr4[0] = 0.2f;
        fArr4[1] = 0.2f;
        float[] fArr5 = this.f3374i;
        fArr5[0] = 0.001f;
        fArr5[1] = 0.001f;
        this.f3373h = f3365r;
        aVar.f3356a = 500;
        aVar.f3357b = 500;
        this.f3382q = listView;
    }

    public static float b(float f4, float f5, float f6) {
        return f4 > f6 ? f6 : f4 < f5 ? f5 : f4;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float a(float r4, float r5, float r6, int r7) {
        /*
            r3 = this;
            float[] r0 = r3.f3370e
            r0 = r0[r7]
            float[] r1 = r3.f3371f
            r1 = r1[r7]
            float r0 = r0 * r5
            r2 = 0
            float r0 = b(r0, r2, r1)
            float r1 = r3.c(r4, r0)
            float r5 = r5 - r4
            float r4 = r3.c(r5, r0)
            float r4 = r4 - r1
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            android.view.animation.AccelerateInterpolator r0 = r3.f3367b
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
            goto L58
        L3c:
            float[] r0 = r3.f3374i
            r0 = r0[r7]
            float[] r1 = r3.f3375j
            r1 = r1[r7]
            float[] r3 = r3.f3376k
            r3 = r3[r7]
            float r0 = r0 * r6
            if (r5 <= 0) goto L51
            float r4 = r4 * r0
            float r2 = b(r4, r1, r3)
            goto L58
        L51:
            float r4 = -r4
            float r4 = r4 * r0
            float r3 = b(r4, r1, r3)
            float r2 = -r3
        L58:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.f.a(float, float, float, int):float");
    }

    public final float c(float f4, float f5) {
        if (f5 == Property.DEFAULT_FLOAT_VALUE) {
            return Property.DEFAULT_FLOAT_VALUE;
        }
        int i4 = this.f3372g;
        if (i4 != 0 && i4 != 1) {
            return (i4 == 2 && f4 < Property.DEFAULT_FLOAT_VALUE) ? f4 / (-f5) : Property.DEFAULT_FLOAT_VALUE;
        }
        if (f4 >= f5) {
            return Property.DEFAULT_FLOAT_VALUE;
        }
        if (f4 >= Property.DEFAULT_FLOAT_VALUE) {
            return 1.0f - (f4 / f5);
        }
        if (this.f3380o && i4 == 1) {
            return 1.0f;
        }
        return Property.DEFAULT_FLOAT_VALUE;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(android.view.View r8, android.view.MotionEvent r9) throws java.lang.ClassNotFoundException {
        /*
            r7 = this;
            boolean r0 = r7.f3381p
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r8 = 3
            if (r0 == r8) goto L16
            goto L7c
        L16:
            r7.e()
            goto L7c
        L1a:
            r7.f3379n = r2
            r7.f3377l = r1
        L1e:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r7.f3368c
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.a(r0, r3, r5, r1)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.a(r9, r8, r3, r2)
            androidx.core.widget.a r9 = r7.f3366a
            r9.f3358c = r0
            r9.f3359d = r8
            boolean r8 = r7.f3380o
            if (r8 != 0) goto L7c
            boolean r8 = r7.f()
            if (r8 == 0) goto L7c
            h.a r8 = r7.f3369d
            if (r8 != 0) goto L60
            h.a r8 = new h.a
            r9 = 4
            r8.<init>(r9, r7)
            r7.f3369d = r8
        L60:
            r7.f3380o = r2
            r7.f3378m = r2
            boolean r8 = r7.f3377l
            if (r8 != 0) goto L75
            int r8 = r7.f3373h
            if (r8 <= 0) goto L75
            h.a r9 = r7.f3369d
            long r5 = (long) r8
            java.util.WeakHashMap r8 = K.S.f939a
            r4.postOnAnimationDelayed(r9, r5)
            goto L7a
        L75:
            h.a r8 = r7.f3369d
            r8.run()
        L7a:
            r7.f3377l = r2
        L7c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.f.d(android.view.View, android.view.MotionEvent):boolean");
    }

    public final void e() {
        int i4 = 0;
        if (this.f3378m) {
            this.f3380o = false;
            return;
        }
        a aVar = this.f3366a;
        aVar.getClass();
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i5 = (int) (jCurrentAnimationTimeMillis - aVar.f3360e);
        int i6 = aVar.f3357b;
        if (i5 > i6) {
            i4 = i6;
        } else if (i5 >= 0) {
            i4 = i5;
        }
        aVar.f3364i = i4;
        aVar.f3363h = aVar.a(jCurrentAnimationTimeMillis);
        aVar.f3362g = jCurrentAnimationTimeMillis;
    }

    public final boolean f() {
        ListView listView;
        int count;
        a aVar = this.f3366a;
        float f4 = aVar.f3359d;
        int iAbs = (int) (f4 / Math.abs(f4));
        Math.abs(aVar.f3358c);
        if (iAbs == 0 || (count = (listView = this.f3382q).getCount()) == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i4 = firstVisiblePosition + childCount;
        if (iAbs > 0) {
            if (i4 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else {
            if (iAbs >= 0) {
                return false;
            }
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public final /* bridge */ /* synthetic */ boolean onTouch(View view, MotionEvent motionEvent) throws ClassNotFoundException {
        d(view, motionEvent);
        return false;
    }
}
