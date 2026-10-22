package J;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.H;
import java.util.Arrays;

/* loaded from: classes.dex */
public class c {

    /* renamed from: x, reason: collision with root package name */
    private static final Interpolator f3171x = new a();

    /* renamed from: a, reason: collision with root package name */
    private int f3172a;

    /* renamed from: b, reason: collision with root package name */
    private int f3173b;

    /* renamed from: d, reason: collision with root package name */
    private float[] f3175d;

    /* renamed from: e, reason: collision with root package name */
    private float[] f3176e;

    /* renamed from: f, reason: collision with root package name */
    private float[] f3177f;

    /* renamed from: g, reason: collision with root package name */
    private float[] f3178g;

    /* renamed from: h, reason: collision with root package name */
    private int[] f3179h;

    /* renamed from: i, reason: collision with root package name */
    private int[] f3180i;

    /* renamed from: j, reason: collision with root package name */
    private int[] f3181j;

    /* renamed from: k, reason: collision with root package name */
    private int f3182k;

    /* renamed from: l, reason: collision with root package name */
    private VelocityTracker f3183l;

    /* renamed from: m, reason: collision with root package name */
    private float f3184m;

    /* renamed from: n, reason: collision with root package name */
    private float f3185n;

    /* renamed from: o, reason: collision with root package name */
    private int f3186o;

    /* renamed from: p, reason: collision with root package name */
    private final int f3187p;

    /* renamed from: q, reason: collision with root package name */
    private int f3188q;

    /* renamed from: r, reason: collision with root package name */
    private OverScroller f3189r;

    /* renamed from: s, reason: collision with root package name */
    private final AbstractC0042c f3190s;

    /* renamed from: t, reason: collision with root package name */
    private View f3191t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f3192u;

    /* renamed from: v, reason: collision with root package name */
    private final ViewGroup f3193v;

    /* renamed from: c, reason: collision with root package name */
    private int f3174c = -1;

    /* renamed from: w, reason: collision with root package name */
    private final Runnable f3194w = new b();

    class a implements Interpolator {
        a() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f5) {
            float f6 = f5 - 1.0f;
            return (f6 * f6 * f6 * f6 * f6) + 1.0f;
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.E(0);
        }
    }

    /* renamed from: J.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0042c {
        public abstract int a(View view, int i5, int i6);

        public abstract int b(View view, int i5, int i6);

        public int c(int i5) {
            return i5;
        }

        public int d(View view) {
            return 0;
        }

        public int e(View view) {
            return 0;
        }

        public void f(int i5, int i6) {
        }

        public boolean g(int i5) {
            return false;
        }

        public void h(int i5, int i6) {
        }

        public void i(View view, int i5) {
        }

        public abstract void j(int i5);

        public abstract void k(View view, int i5, int i6, int i7, int i8);

        public abstract void l(View view, float f5, float f6);

        public abstract boolean m(View view, int i5);
    }

    private c(Context context, ViewGroup viewGroup, AbstractC0042c abstractC0042c) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (abstractC0042c == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f3193v = viewGroup;
        this.f3190s = abstractC0042c;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i5 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f3187p = i5;
        this.f3186o = i5;
        this.f3173b = viewConfiguration.getScaledTouchSlop();
        this.f3184m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f3185n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3189r = new OverScroller(context, f3171x);
    }

    private void A() {
        this.f3183l.computeCurrentVelocity(1000, this.f3184m);
        n(e(this.f3183l.getXVelocity(this.f3174c), this.f3185n, this.f3184m), e(this.f3183l.getYVelocity(this.f3174c), this.f3185n, this.f3184m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v1, types: [J.c$c] */
    private void B(float f5, float f6, int i5) {
        boolean zC = c(f5, f6, i5, 1);
        boolean z5 = zC;
        if (c(f6, f5, i5, 4)) {
            z5 = (zC ? 1 : 0) | 4;
        }
        boolean z6 = z5;
        if (c(f5, f6, i5, 2)) {
            z6 = (z5 ? 1 : 0) | 2;
        }
        ?? r02 = z6;
        if (c(f6, f5, i5, 8)) {
            r02 = (z6 ? 1 : 0) | 8;
        }
        if (r02 != 0) {
            int[] iArr = this.f3180i;
            iArr[i5] = iArr[i5] | r02;
            this.f3190s.f(r02, i5);
        }
    }

    private void C(float f5, float f6, int i5) {
        q(i5);
        float[] fArr = this.f3175d;
        this.f3177f[i5] = f5;
        fArr[i5] = f5;
        float[] fArr2 = this.f3176e;
        this.f3178g[i5] = f6;
        fArr2[i5] = f6;
        this.f3179h[i5] = t((int) f5, (int) f6);
        this.f3182k |= 1 << i5;
    }

    private void D(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i5 = 0; i5 < pointerCount; i5++) {
            int pointerId = motionEvent.getPointerId(i5);
            if (x(pointerId)) {
                float x5 = motionEvent.getX(i5);
                float y5 = motionEvent.getY(i5);
                this.f3177f[pointerId] = x5;
                this.f3178g[pointerId] = y5;
            }
        }
    }

    private boolean c(float f5, float f6, int i5, int i6) {
        float fAbs = Math.abs(f5);
        float fAbs2 = Math.abs(f6);
        if ((this.f3179h[i5] & i6) == i6 && (this.f3188q & i6) != 0 && (this.f3181j[i5] & i6) != i6 && (this.f3180i[i5] & i6) != i6) {
            int i7 = this.f3173b;
            if (fAbs > i7 || fAbs2 > i7) {
                if (fAbs < fAbs2 * 0.5f && this.f3190s.g(i6)) {
                    int[] iArr = this.f3181j;
                    iArr[i5] = iArr[i5] | i6;
                    return false;
                }
                if ((this.f3180i[i5] & i6) == 0 && fAbs > this.f3173b) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean d(View view, float f5, float f6) {
        if (view == null) {
            return false;
        }
        boolean z5 = this.f3190s.d(view) > 0;
        boolean z6 = this.f3190s.e(view) > 0;
        if (!z5 || !z6) {
            return z5 ? Math.abs(f5) > ((float) this.f3173b) : z6 && Math.abs(f6) > ((float) this.f3173b);
        }
        float f7 = (f5 * f5) + (f6 * f6);
        int i5 = this.f3173b;
        return f7 > ((float) (i5 * i5));
    }

    private float e(float f5, float f6, float f7) {
        float fAbs = Math.abs(f5);
        if (fAbs < f6) {
            return 0.0f;
        }
        return fAbs > f7 ? f5 > 0.0f ? f7 : -f7 : f5;
    }

    private int f(int i5, int i6, int i7) {
        int iAbs = Math.abs(i5);
        if (iAbs < i6) {
            return 0;
        }
        return iAbs > i7 ? i5 > 0 ? i7 : -i7 : i5;
    }

    private void g() {
        float[] fArr = this.f3175d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f3176e, 0.0f);
        Arrays.fill(this.f3177f, 0.0f);
        Arrays.fill(this.f3178g, 0.0f);
        Arrays.fill(this.f3179h, 0);
        Arrays.fill(this.f3180i, 0);
        Arrays.fill(this.f3181j, 0);
        this.f3182k = 0;
    }

    private void h(int i5) {
        if (this.f3175d == null || !w(i5)) {
            return;
        }
        this.f3175d[i5] = 0.0f;
        this.f3176e[i5] = 0.0f;
        this.f3177f[i5] = 0.0f;
        this.f3178g[i5] = 0.0f;
        this.f3179h[i5] = 0;
        this.f3180i[i5] = 0;
        this.f3181j[i5] = 0;
        this.f3182k = (~(1 << i5)) & this.f3182k;
    }

    private int i(int i5, int i6, int i7) {
        if (i5 == 0) {
            return 0;
        }
        int width = this.f3193v.getWidth();
        float f5 = width / 2;
        float fO = f5 + (o(Math.min(1.0f, Math.abs(i5) / width)) * f5);
        int iAbs = Math.abs(i6);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fO / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i5) / i7) + 1.0f) * 256.0f), 600);
    }

    private int j(View view, int i5, int i6, int i7, int i8) {
        float f5;
        float f6;
        float f7;
        float f8;
        int iF = f(i7, (int) this.f3185n, (int) this.f3184m);
        int iF2 = f(i8, (int) this.f3185n, (int) this.f3184m);
        int iAbs = Math.abs(i5);
        int iAbs2 = Math.abs(i6);
        int iAbs3 = Math.abs(iF);
        int iAbs4 = Math.abs(iF2);
        int i9 = iAbs3 + iAbs4;
        int i10 = iAbs + iAbs2;
        if (iF != 0) {
            f5 = iAbs3;
            f6 = i9;
        } else {
            f5 = iAbs;
            f6 = i10;
        }
        float f9 = f5 / f6;
        if (iF2 != 0) {
            f7 = iAbs4;
            f8 = i9;
        } else {
            f7 = iAbs2;
            f8 = i10;
        }
        return (int) ((i(i5, iF, this.f3190s.d(view)) * f9) + (i(i6, iF2, this.f3190s.e(view)) * (f7 / f8)));
    }

    public static c l(ViewGroup viewGroup, float f5, AbstractC0042c abstractC0042c) {
        c cVarM = m(viewGroup, abstractC0042c);
        cVarM.f3173b = (int) (cVarM.f3173b * (1.0f / f5));
        return cVarM;
    }

    public static c m(ViewGroup viewGroup, AbstractC0042c abstractC0042c) {
        return new c(viewGroup.getContext(), viewGroup, abstractC0042c);
    }

    private void n(float f5, float f6) {
        this.f3192u = true;
        this.f3190s.l(this.f3191t, f5, f6);
        this.f3192u = false;
        if (this.f3172a == 1) {
            E(0);
        }
    }

    private float o(float f5) {
        return (float) Math.sin((f5 - 0.5f) * 0.47123894f);
    }

    private void p(int i5, int i6, int i7, int i8) {
        int left = this.f3191t.getLeft();
        int top = this.f3191t.getTop();
        if (i7 != 0) {
            i5 = this.f3190s.a(this.f3191t, i5, i7);
            H.U(this.f3191t, i5 - left);
        }
        int i9 = i5;
        if (i8 != 0) {
            i6 = this.f3190s.b(this.f3191t, i6, i8);
            H.V(this.f3191t, i6 - top);
        }
        int i10 = i6;
        if (i7 == 0 && i8 == 0) {
            return;
        }
        this.f3190s.k(this.f3191t, i9, i10, i9 - left, i10 - top);
    }

    private void q(int i5) {
        float[] fArr = this.f3175d;
        if (fArr == null || fArr.length <= i5) {
            int i6 = i5 + 1;
            float[] fArr2 = new float[i6];
            float[] fArr3 = new float[i6];
            float[] fArr4 = new float[i6];
            float[] fArr5 = new float[i6];
            int[] iArr = new int[i6];
            int[] iArr2 = new int[i6];
            int[] iArr3 = new int[i6];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f3176e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f3177f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f3178g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f3179h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f3180i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f3181j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f3175d = fArr2;
            this.f3176e = fArr3;
            this.f3177f = fArr4;
            this.f3178g = fArr5;
            this.f3179h = iArr;
            this.f3180i = iArr2;
            this.f3181j = iArr3;
        }
    }

    private boolean s(int i5, int i6, int i7, int i8) {
        int left = this.f3191t.getLeft();
        int top = this.f3191t.getTop();
        int i9 = i5 - left;
        int i10 = i6 - top;
        if (i9 == 0 && i10 == 0) {
            this.f3189r.abortAnimation();
            E(0);
            return false;
        }
        this.f3189r.startScroll(left, top, i9, i10, j(this.f3191t, i9, i10, i7, i8));
        E(2);
        return true;
    }

    private int t(int i5, int i6) {
        int i7 = i5 < this.f3193v.getLeft() + this.f3186o ? 1 : 0;
        if (i6 < this.f3193v.getTop() + this.f3186o) {
            i7 |= 4;
        }
        if (i5 > this.f3193v.getRight() - this.f3186o) {
            i7 |= 2;
        }
        return i6 > this.f3193v.getBottom() - this.f3186o ? i7 | 8 : i7;
    }

    private boolean x(int i5) {
        if (w(i5)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i5 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    void E(int i5) {
        this.f3193v.removeCallbacks(this.f3194w);
        if (this.f3172a != i5) {
            this.f3172a = i5;
            this.f3190s.j(i5);
            if (this.f3172a == 0) {
                this.f3191t = null;
            }
        }
    }

    public boolean F(int i5, int i6) {
        if (this.f3192u) {
            return s(i5, i6, (int) this.f3183l.getXVelocity(this.f3174c), (int) this.f3183l.getYVelocity(this.f3174c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean G(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J.c.G(android.view.MotionEvent):boolean");
    }

    public boolean H(View view, int i5, int i6) {
        this.f3191t = view;
        this.f3174c = -1;
        boolean zS = s(i5, i6, 0, 0);
        if (!zS && this.f3172a == 0 && this.f3191t != null) {
            this.f3191t = null;
        }
        return zS;
    }

    boolean I(View view, int i5) {
        if (view == this.f3191t && this.f3174c == i5) {
            return true;
        }
        if (view == null || !this.f3190s.m(view, i5)) {
            return false;
        }
        this.f3174c = i5;
        b(view, i5);
        return true;
    }

    public void a() {
        this.f3174c = -1;
        g();
        VelocityTracker velocityTracker = this.f3183l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f3183l = null;
        }
    }

    public void b(View view, int i5) {
        if (view.getParent() == this.f3193v) {
            this.f3191t = view;
            this.f3174c = i5;
            this.f3190s.i(view, i5);
            E(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f3193v + ")");
    }

    public boolean k(boolean z5) {
        if (this.f3172a == 2) {
            boolean zComputeScrollOffset = this.f3189r.computeScrollOffset();
            int currX = this.f3189r.getCurrX();
            int currY = this.f3189r.getCurrY();
            int left = currX - this.f3191t.getLeft();
            int top = currY - this.f3191t.getTop();
            if (left != 0) {
                H.U(this.f3191t, left);
            }
            if (top != 0) {
                H.V(this.f3191t, top);
            }
            if (left != 0 || top != 0) {
                this.f3190s.k(this.f3191t, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.f3189r.getFinalX() && currY == this.f3189r.getFinalY()) {
                this.f3189r.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z5) {
                    this.f3193v.post(this.f3194w);
                } else {
                    E(0);
                }
            }
        }
        return this.f3172a == 2;
    }

    public View r(int i5, int i6) {
        for (int childCount = this.f3193v.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f3193v.getChildAt(this.f3190s.c(childCount));
            if (i5 >= childAt.getLeft() && i5 < childAt.getRight() && i6 >= childAt.getTop() && i6 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public int u() {
        return this.f3173b;
    }

    public boolean v(int i5, int i6) {
        return y(this.f3191t, i5, i6);
    }

    public boolean w(int i5) {
        return (this.f3182k & (1 << i5)) != 0;
    }

    public boolean y(View view, int i5, int i6) {
        return view != null && i5 >= view.getLeft() && i5 < view.getRight() && i6 >= view.getTop() && i6 < view.getBottom();
    }

    public void z(MotionEvent motionEvent) {
        int i5;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f3183l == null) {
            this.f3183l = VelocityTracker.obtain();
        }
        this.f3183l.addMovement(motionEvent);
        int i6 = 0;
        if (actionMasked == 0) {
            float x5 = motionEvent.getX();
            float y5 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewR = r((int) x5, (int) y5);
            C(x5, y5, pointerId);
            I(viewR, pointerId);
            int i7 = this.f3179h[pointerId];
            int i8 = this.f3188q;
            if ((i7 & i8) != 0) {
                this.f3190s.h(i7 & i8, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f3172a == 1) {
                A();
            }
            a();
            return;
        }
        if (actionMasked == 2) {
            if (this.f3172a == 1) {
                if (x(this.f3174c)) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f3174c);
                    float x6 = motionEvent.getX(iFindPointerIndex);
                    float y6 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.f3177f;
                    int i9 = this.f3174c;
                    int i10 = (int) (x6 - fArr[i9]);
                    int i11 = (int) (y6 - this.f3178g[i9]);
                    p(this.f3191t.getLeft() + i10, this.f3191t.getTop() + i11, i10, i11);
                    D(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i6 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i6);
                if (x(pointerId2)) {
                    float x7 = motionEvent.getX(i6);
                    float y7 = motionEvent.getY(i6);
                    float f5 = x7 - this.f3175d[pointerId2];
                    float f6 = y7 - this.f3176e[pointerId2];
                    B(f5, f6, pointerId2);
                    if (this.f3172a != 1) {
                        View viewR2 = r((int) x7, (int) y7);
                        if (d(viewR2, f5, f6) && I(viewR2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i6++;
            }
            D(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f3172a == 1) {
                n(0.0f, 0.0f);
            }
            a();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x8 = motionEvent.getX(actionIndex);
            float y8 = motionEvent.getY(actionIndex);
            C(x8, y8, pointerId3);
            if (this.f3172a != 0) {
                if (v((int) x8, (int) y8)) {
                    I(this.f3191t, pointerId3);
                    return;
                }
                return;
            } else {
                I(r((int) x8, (int) y8), pointerId3);
                int i12 = this.f3179h[pointerId3];
                int i13 = this.f3188q;
                if ((i12 & i13) != 0) {
                    this.f3190s.h(i12 & i13, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f3172a == 1 && pointerId4 == this.f3174c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i6 >= pointerCount2) {
                    i5 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i6);
                if (pointerId5 != this.f3174c) {
                    View viewR3 = r((int) motionEvent.getX(i6), (int) motionEvent.getY(i6));
                    View view = this.f3191t;
                    if (viewR3 == view && I(view, pointerId5)) {
                        i5 = this.f3174c;
                        break;
                    }
                }
                i6++;
            }
            if (i5 == -1) {
                A();
            }
        }
        h(pointerId4);
    }
}
