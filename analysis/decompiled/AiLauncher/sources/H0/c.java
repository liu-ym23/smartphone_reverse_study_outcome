package H0;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.N;
import java.util.Arrays;

/* loaded from: classes.dex */
public class c {

    /* renamed from: w, reason: collision with root package name */
    public static final Interpolator f2938w = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f2939a;

    /* renamed from: b, reason: collision with root package name */
    public int f2940b;

    /* renamed from: d, reason: collision with root package name */
    public float[] f2942d;

    /* renamed from: e, reason: collision with root package name */
    public float[] f2943e;

    /* renamed from: f, reason: collision with root package name */
    public float[] f2944f;

    /* renamed from: g, reason: collision with root package name */
    public float[] f2945g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f2946h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f2947i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f2948j;

    /* renamed from: k, reason: collision with root package name */
    public int f2949k;

    /* renamed from: l, reason: collision with root package name */
    public VelocityTracker f2950l;

    /* renamed from: m, reason: collision with root package name */
    public float f2951m;
    private int mEdgeSize;

    /* renamed from: n, reason: collision with root package name */
    public float f2952n;

    /* renamed from: o, reason: collision with root package name */
    public final int f2953o;

    /* renamed from: p, reason: collision with root package name */
    public int f2954p;

    /* renamed from: q, reason: collision with root package name */
    public OverScroller f2955q;

    /* renamed from: r, reason: collision with root package name */
    public final AbstractC0044c f2956r;

    /* renamed from: s, reason: collision with root package name */
    public View f2957s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f2958t;

    /* renamed from: u, reason: collision with root package name */
    public final ViewGroup f2959u;

    /* renamed from: c, reason: collision with root package name */
    public int f2941c = -1;

    /* renamed from: v, reason: collision with root package name */
    public final Runnable f2960v = new b();

    public class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.K(0);
        }
    }

    /* renamed from: H0.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0044c {
        public abstract int a(View view, int i10, int i11);

        public abstract int b(View view, int i10, int i11);

        public int c(int i10) {
            return i10;
        }

        public int d(View view) {
            return 0;
        }

        public int e(View view) {
            return 0;
        }

        public void f(int i10, int i11) {
        }

        public boolean g(int i10) {
            return false;
        }

        public void h(int i10, int i11) {
        }

        public void i(View view, int i10) {
        }

        public abstract void j(int i10);

        public abstract void k(View view, int i10, int i11, int i12, int i13);

        public abstract void l(View view, float f10, float f11);

        public abstract boolean m(View view, int i10);
    }

    public c(Context context, ViewGroup viewGroup, AbstractC0044c abstractC0044c) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (abstractC0044c == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f2959u = viewGroup;
        this.f2956r = abstractC0044c;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i10 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f2953o = i10;
        this.mEdgeSize = i10;
        this.f2940b = viewConfiguration.getScaledTouchSlop();
        this.f2951m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f2952n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2955q = new OverScroller(context, f2938w);
    }

    public static c n(ViewGroup viewGroup, float f10, AbstractC0044c abstractC0044c) {
        c cVarO = o(viewGroup, abstractC0044c);
        cVarO.f2940b = (int) (cVarO.f2940b * (1.0f / f10));
        return cVarO;
    }

    public static c o(ViewGroup viewGroup, AbstractC0044c abstractC0044c) {
        return new c(viewGroup.getContext(), viewGroup, abstractC0044c);
    }

    public int A() {
        return this.f2939a;
    }

    public boolean B(int i10, int i11) {
        return E(this.f2957s, i10, i11);
    }

    public boolean C(int i10) {
        return (this.f2949k & (1 << i10)) != 0;
    }

    public final boolean D(int i10) {
        if (C(i10)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i10 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public boolean E(View view, int i10, int i11) {
        return view != null && i10 >= view.getLeft() && i10 < view.getRight() && i11 >= view.getTop() && i11 < view.getBottom();
    }

    public void F(MotionEvent motionEvent) {
        int i10;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f2950l == null) {
            this.f2950l = VelocityTracker.obtain();
        }
        this.f2950l.addMovement(motionEvent);
        int i11 = 0;
        if (actionMasked == 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewT = t((int) x10, (int) y10);
            I(x10, y10, pointerId);
            R(viewT, pointerId);
            int i12 = this.f2946h[pointerId];
            int i13 = this.f2954p;
            if ((i12 & i13) != 0) {
                this.f2956r.h(i12 & i13, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f2939a == 1) {
                G();
            }
            a();
            return;
        }
        if (actionMasked == 2) {
            if (this.f2939a == 1) {
                if (D(this.f2941c)) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f2941c);
                    float x11 = motionEvent.getX(iFindPointerIndex);
                    float y11 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.f2944f;
                    int i14 = this.f2941c;
                    int i15 = (int) (x11 - fArr[i14]);
                    int i16 = (int) (y11 - this.f2945g[i14]);
                    r(this.f2957s.getLeft() + i15, this.f2957s.getTop() + i16, i15, i16);
                    J(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i11 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i11);
                if (D(pointerId2)) {
                    float x12 = motionEvent.getX(i11);
                    float y12 = motionEvent.getY(i11);
                    float f10 = x12 - this.f2942d[pointerId2];
                    float f11 = y12 - this.f2943e[pointerId2];
                    H(f10, f11, pointerId2);
                    if (this.f2939a != 1) {
                        View viewT2 = t((int) x12, (int) y12);
                        if (f(viewT2, f10, f11) && R(viewT2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i11++;
            }
            J(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f2939a == 1) {
                p(0.0f, 0.0f);
            }
            a();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x13 = motionEvent.getX(actionIndex);
            float y13 = motionEvent.getY(actionIndex);
            I(x13, y13, pointerId3);
            if (this.f2939a != 0) {
                if (B((int) x13, (int) y13)) {
                    R(this.f2957s, pointerId3);
                    return;
                }
                return;
            } else {
                R(t((int) x13, (int) y13), pointerId3);
                int i17 = this.f2946h[pointerId3];
                int i18 = this.f2954p;
                if ((i17 & i18) != 0) {
                    this.f2956r.h(i17 & i18, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f2939a == 1 && pointerId4 == this.f2941c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i11 >= pointerCount2) {
                    i10 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i11);
                if (pointerId5 != this.f2941c) {
                    View viewT3 = t((int) motionEvent.getX(i11), (int) motionEvent.getY(i11));
                    View view = this.f2957s;
                    if (viewT3 == view && R(view, pointerId5)) {
                        i10 = this.f2941c;
                        break;
                    }
                }
                i11++;
            }
            if (i10 == -1) {
                G();
            }
        }
        j(pointerId4);
    }

    public final void G() {
        this.f2950l.computeCurrentVelocity(1000, this.f2951m);
        p(g(this.f2950l.getXVelocity(this.f2941c), this.f2952n, this.f2951m), g(this.f2950l.getYVelocity(this.f2941c), this.f2952n, this.f2951m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v1, types: [H0.c$c] */
    public final void H(float f10, float f11, int i10) {
        boolean zC = c(f10, f11, i10, 1);
        boolean z10 = zC;
        if (c(f11, f10, i10, 4)) {
            z10 = (zC ? 1 : 0) | 4;
        }
        boolean z11 = z10;
        if (c(f10, f11, i10, 2)) {
            z11 = (z10 ? 1 : 0) | 2;
        }
        ?? r02 = z11;
        if (c(f11, f10, i10, 8)) {
            r02 = (z11 ? 1 : 0) | 8;
        }
        if (r02 != 0) {
            int[] iArr = this.f2947i;
            iArr[i10] = iArr[i10] | r02;
            this.f2956r.f(r02, i10);
        }
    }

    public final void I(float f10, float f11, int i10) {
        s(i10);
        float[] fArr = this.f2942d;
        this.f2944f[i10] = f10;
        fArr[i10] = f10;
        float[] fArr2 = this.f2943e;
        this.f2945g[i10] = f11;
        fArr2[i10] = f11;
        this.f2946h[i10] = y((int) f10, (int) f11);
        this.f2949k |= 1 << i10;
    }

    public final void J(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i10 = 0; i10 < pointerCount; i10++) {
            int pointerId = motionEvent.getPointerId(i10);
            if (D(pointerId)) {
                float x10 = motionEvent.getX(i10);
                float y10 = motionEvent.getY(i10);
                this.f2944f[pointerId] = x10;
                this.f2945g[pointerId] = y10;
            }
        }
    }

    public void K(int i10) {
        this.f2959u.removeCallbacks(this.f2960v);
        if (this.f2939a != i10) {
            this.f2939a = i10;
            this.f2956r.j(i10);
            if (this.f2939a == 0) {
                this.f2957s = null;
            }
        }
    }

    public void L(int i10) {
        this.mEdgeSize = i10;
    }

    public void M(int i10) {
        this.f2954p = i10;
    }

    public void N(float f10) {
        this.f2952n = f10;
    }

    public boolean O(int i10, int i11) {
        if (this.f2958t) {
            return u(i10, i11, (int) this.f2950l.getXVelocity(this.f2941c), (int) this.f2950l.getYVelocity(this.f2941c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean P(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: H0.c.P(android.view.MotionEvent):boolean");
    }

    public boolean Q(View view, int i10, int i11) {
        this.f2957s = view;
        this.f2941c = -1;
        boolean zU = u(i10, i11, 0, 0);
        if (!zU && this.f2939a == 0 && this.f2957s != null) {
            this.f2957s = null;
        }
        return zU;
    }

    public boolean R(View view, int i10) {
        if (view == this.f2957s && this.f2941c == i10) {
            return true;
        }
        if (view == null || !this.f2956r.m(view, i10)) {
            return false;
        }
        this.f2941c = i10;
        b(view, i10);
        return true;
    }

    public void a() {
        this.f2941c = -1;
        i();
        VelocityTracker velocityTracker = this.f2950l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f2950l = null;
        }
    }

    public void b(View view, int i10) {
        if (view.getParent() == this.f2959u) {
            this.f2957s = view;
            this.f2941c = i10;
            this.f2956r.i(view, i10);
            K(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f2959u + ")");
    }

    public final boolean c(float f10, float f11, int i10, int i11) {
        float fAbs = Math.abs(f10);
        float fAbs2 = Math.abs(f11);
        if ((this.f2946h[i10] & i11) == i11 && (this.f2954p & i11) != 0 && (this.f2948j[i10] & i11) != i11 && (this.f2947i[i10] & i11) != i11) {
            int i12 = this.f2940b;
            if (fAbs > i12 || fAbs2 > i12) {
                if (fAbs < fAbs2 * 0.5f && this.f2956r.g(i11)) {
                    int[] iArr = this.f2948j;
                    iArr[i10] = iArr[i10] | i11;
                    return false;
                }
                if ((this.f2947i[i10] & i11) == 0 && fAbs > this.f2940b) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean d(int i10) {
        int length = this.f2942d.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (e(i10, i11)) {
                return true;
            }
        }
        return false;
    }

    public boolean e(int i10, int i11) {
        if (!C(i11)) {
            return false;
        }
        boolean z10 = (i10 & 1) == 1;
        boolean z11 = (i10 & 2) == 2;
        float f10 = this.f2944f[i11] - this.f2942d[i11];
        float f11 = this.f2945g[i11] - this.f2943e[i11];
        if (!z10 || !z11) {
            return z10 ? Math.abs(f10) > ((float) this.f2940b) : z11 && Math.abs(f11) > ((float) this.f2940b);
        }
        float f12 = (f10 * f10) + (f11 * f11);
        int i12 = this.f2940b;
        return f12 > ((float) (i12 * i12));
    }

    public final boolean f(View view, float f10, float f11) {
        if (view == null) {
            return false;
        }
        boolean z10 = this.f2956r.d(view) > 0;
        boolean z11 = this.f2956r.e(view) > 0;
        if (!z10 || !z11) {
            return z10 ? Math.abs(f10) > ((float) this.f2940b) : z11 && Math.abs(f11) > ((float) this.f2940b);
        }
        float f12 = (f10 * f10) + (f11 * f11);
        int i10 = this.f2940b;
        return f12 > ((float) (i10 * i10));
    }

    public final float g(float f10, float f11, float f12) {
        float fAbs = Math.abs(f10);
        if (fAbs < f11) {
            return 0.0f;
        }
        return fAbs > f12 ? f10 > 0.0f ? f12 : -f12 : f10;
    }

    public final int h(int i10, int i11, int i12) {
        int iAbs = Math.abs(i10);
        if (iAbs < i11) {
            return 0;
        }
        return iAbs > i12 ? i10 > 0 ? i12 : -i12 : i10;
    }

    public final void i() {
        float[] fArr = this.f2942d;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f2943e, 0.0f);
        Arrays.fill(this.f2944f, 0.0f);
        Arrays.fill(this.f2945g, 0.0f);
        Arrays.fill(this.f2946h, 0);
        Arrays.fill(this.f2947i, 0);
        Arrays.fill(this.f2948j, 0);
        this.f2949k = 0;
    }

    public final void j(int i10) {
        if (this.f2942d == null || !C(i10)) {
            return;
        }
        this.f2942d[i10] = 0.0f;
        this.f2943e[i10] = 0.0f;
        this.f2944f[i10] = 0.0f;
        this.f2945g[i10] = 0.0f;
        this.f2946h[i10] = 0;
        this.f2947i[i10] = 0;
        this.f2948j[i10] = 0;
        this.f2949k = (~(1 << i10)) & this.f2949k;
    }

    public final int k(int i10, int i11, int i12) {
        if (i10 == 0) {
            return 0;
        }
        int width = this.f2959u.getWidth();
        float f10 = width / 2;
        float fQ = f10 + (q(Math.min(1.0f, Math.abs(i10) / width)) * f10);
        int iAbs = Math.abs(i11);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fQ / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i10) / i12) + 1.0f) * 256.0f), 600);
    }

    public final int l(View view, int i10, int i11, int i12, int i13) {
        float f10;
        float f11;
        float f12;
        float f13;
        int iH = h(i12, (int) this.f2952n, (int) this.f2951m);
        int iH2 = h(i13, (int) this.f2952n, (int) this.f2951m);
        int iAbs = Math.abs(i10);
        int iAbs2 = Math.abs(i11);
        int iAbs3 = Math.abs(iH);
        int iAbs4 = Math.abs(iH2);
        int i14 = iAbs3 + iAbs4;
        int i15 = iAbs + iAbs2;
        if (iH != 0) {
            f10 = iAbs3;
            f11 = i14;
        } else {
            f10 = iAbs;
            f11 = i15;
        }
        float f14 = f10 / f11;
        if (iH2 != 0) {
            f12 = iAbs4;
            f13 = i14;
        } else {
            f12 = iAbs2;
            f13 = i15;
        }
        return (int) ((k(i10, iH, this.f2956r.d(view)) * f14) + (k(i11, iH2, this.f2956r.e(view)) * (f12 / f13)));
    }

    public boolean m(boolean z10) {
        if (this.f2939a == 2) {
            boolean zComputeScrollOffset = this.f2955q.computeScrollOffset();
            int currX = this.f2955q.getCurrX();
            int currY = this.f2955q.getCurrY();
            int left = currX - this.f2957s.getLeft();
            int top = currY - this.f2957s.getTop();
            if (left != 0) {
                N.S(this.f2957s, left);
            }
            if (top != 0) {
                N.T(this.f2957s, top);
            }
            if (left != 0 || top != 0) {
                this.f2956r.k(this.f2957s, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.f2955q.getFinalX() && currY == this.f2955q.getFinalY()) {
                this.f2955q.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z10) {
                    this.f2959u.post(this.f2960v);
                } else {
                    K(0);
                }
            }
        }
        return this.f2939a == 2;
    }

    public final void p(float f10, float f11) {
        this.f2958t = true;
        this.f2956r.l(this.f2957s, f10, f11);
        this.f2958t = false;
        if (this.f2939a == 1) {
            K(0);
        }
    }

    public final float q(float f10) {
        return (float) Math.sin((f10 - 0.5f) * 0.47123894f);
    }

    public final void r(int i10, int i11, int i12, int i13) {
        int left = this.f2957s.getLeft();
        int top = this.f2957s.getTop();
        if (i12 != 0) {
            i10 = this.f2956r.a(this.f2957s, i10, i12);
            N.S(this.f2957s, i10 - left);
        }
        int i14 = i10;
        if (i13 != 0) {
            i11 = this.f2956r.b(this.f2957s, i11, i13);
            N.T(this.f2957s, i11 - top);
        }
        int i15 = i11;
        if (i12 == 0 && i13 == 0) {
            return;
        }
        this.f2956r.k(this.f2957s, i14, i15, i14 - left, i15 - top);
    }

    public final void s(int i10) {
        float[] fArr = this.f2942d;
        if (fArr == null || fArr.length <= i10) {
            int i11 = i10 + 1;
            float[] fArr2 = new float[i11];
            float[] fArr3 = new float[i11];
            float[] fArr4 = new float[i11];
            float[] fArr5 = new float[i11];
            int[] iArr = new int[i11];
            int[] iArr2 = new int[i11];
            int[] iArr3 = new int[i11];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f2943e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f2944f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f2945g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f2946h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f2947i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f2948j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f2942d = fArr2;
            this.f2943e = fArr3;
            this.f2944f = fArr4;
            this.f2945g = fArr5;
            this.f2946h = iArr;
            this.f2947i = iArr2;
            this.f2948j = iArr3;
        }
    }

    public View t(int i10, int i11) {
        for (int childCount = this.f2959u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f2959u.getChildAt(this.f2956r.c(childCount));
            if (i10 >= childAt.getLeft() && i10 < childAt.getRight() && i11 >= childAt.getTop() && i11 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean u(int i10, int i11, int i12, int i13) {
        int left = this.f2957s.getLeft();
        int top = this.f2957s.getTop();
        int i14 = i10 - left;
        int i15 = i11 - top;
        if (i14 == 0 && i15 == 0) {
            this.f2955q.abortAnimation();
            K(0);
            return false;
        }
        this.f2955q.startScroll(left, top, i14, i15, l(this.f2957s, i14, i15, i12, i13));
        K(2);
        return true;
    }

    public View v() {
        return this.f2957s;
    }

    public int w() {
        return this.f2953o;
    }

    public int x() {
        return this.mEdgeSize;
    }

    public final int y(int i10, int i11) {
        int i12 = i10 < this.f2959u.getLeft() + this.mEdgeSize ? 1 : 0;
        if (i11 < this.f2959u.getTop() + this.mEdgeSize) {
            i12 |= 4;
        }
        if (i10 > this.f2959u.getRight() - this.mEdgeSize) {
            i12 |= 2;
        }
        return i11 > this.f2959u.getBottom() - this.mEdgeSize ? i12 | 8 : i12;
    }

    public int z() {
        return this.f2940b;
    }
}
