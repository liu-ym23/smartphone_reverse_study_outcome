package c1;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;
import java.util.WeakHashMap;
import v0.e0;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: x, reason: collision with root package name */
    public static final a f3260x = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f3261a;

    /* renamed from: b, reason: collision with root package name */
    public int f3262b;

    /* renamed from: d, reason: collision with root package name */
    public float[] f3264d;

    /* renamed from: e, reason: collision with root package name */
    public float[] f3265e;

    /* renamed from: f, reason: collision with root package name */
    public float[] f3266f;

    /* renamed from: g, reason: collision with root package name */
    public float[] f3267g;
    public int[] h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f3268i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f3269j;

    /* renamed from: k, reason: collision with root package name */
    public int f3270k;

    /* renamed from: l, reason: collision with root package name */
    public VelocityTracker f3271l;

    /* renamed from: m, reason: collision with root package name */
    public final float f3272m;

    /* renamed from: n, reason: collision with root package name */
    public float f3273n;

    /* renamed from: o, reason: collision with root package name */
    public int f3274o;

    /* renamed from: p, reason: collision with root package name */
    public final int f3275p;

    /* renamed from: q, reason: collision with root package name */
    public int f3276q;
    public final OverScroller r;

    /* renamed from: s, reason: collision with root package name */
    public final AbstractC0028c f3277s;

    /* renamed from: t, reason: collision with root package name */
    public View f3278t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f3279u;

    /* renamed from: v, reason: collision with root package name */
    public final ViewGroup f3280v;

    /* renamed from: c, reason: collision with root package name */
    public int f3263c = -1;

    /* renamed from: w, reason: collision with root package name */
    public final b f3281w = new b();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f8) {
            float f9 = f8 - 1.0f;
            return (f9 * f9 * f9 * f9 * f9) + 1.0f;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            c.this.r(0);
        }
    }

    public c(Context context, ViewGroup viewGroup, AbstractC0028c abstractC0028c) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (abstractC0028c == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f3280v = viewGroup;
        this.f3277s = abstractC0028c;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i10 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f3275p = i10;
        this.f3274o = i10;
        this.f3262b = viewConfiguration.getScaledTouchSlop();
        this.f3272m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f3273n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.r = new OverScroller(context, f3260x);
    }

    public static boolean l(View view, int i10, int i11) {
        return view != null && i10 >= view.getLeft() && i10 < view.getRight() && i11 >= view.getTop() && i11 < view.getBottom();
    }

    public final void a() {
        b();
        if (this.f3261a == 2) {
            OverScroller overScroller = this.r;
            overScroller.getCurrX();
            overScroller.getCurrY();
            overScroller.abortAnimation();
            this.f3277s.i(this.f3278t, overScroller.getCurrX(), overScroller.getCurrY());
        }
        r(0);
    }

    public final void b() {
        this.f3263c = -1;
        float[] fArr = this.f3264d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f3265e, 0.0f);
            Arrays.fill(this.f3266f, 0.0f);
            Arrays.fill(this.f3267g, 0.0f);
            Arrays.fill(this.h, 0);
            Arrays.fill(this.f3268i, 0);
            Arrays.fill(this.f3269j, 0);
            this.f3270k = 0;
        }
        VelocityTracker velocityTracker = this.f3271l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f3271l = null;
        }
    }

    public final void c(int i10, View view) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = this.f3280v;
        if (parent != viewGroup) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + viewGroup + ")");
        }
        this.f3278t = view;
        this.f3263c = i10;
        this.f3277s.g(i10, view);
        r(1);
    }

    public final boolean d(float f8, float f9, int i10, int i11) {
        float fAbs = Math.abs(f8);
        float fAbs2 = Math.abs(f9);
        if ((this.h[i10] & i11) != i11 || (this.f3276q & i11) == 0 || (this.f3269j[i10] & i11) == i11 || (this.f3268i[i10] & i11) == i11) {
            return false;
        }
        float f10 = this.f3262b;
        if (fAbs <= f10 && fAbs2 <= f10) {
            return false;
        }
        if (fAbs < fAbs2 * 0.5f) {
            this.f3277s.getClass();
        }
        return (this.f3268i[i10] & i11) == 0 && fAbs > ((float) this.f3262b);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0044 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(android.view.View r4, float r5, float r6) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            goto L45
        L4:
            c1.c$c r1 = r3.f3277s
            int r4 = r1.c(r4)
            r2 = 1
            if (r4 <= 0) goto Lf
            r4 = r2
            goto L10
        Lf:
            r4 = r0
        L10:
            int r1 = r1.d()
            if (r1 <= 0) goto L18
            r1 = r2
            goto L19
        L18:
            r1 = r0
        L19:
            if (r4 == 0) goto L29
            if (r1 == 0) goto L29
            float r5 = r5 * r5
            float r6 = r6 * r6
            float r6 = r6 + r5
            int r3 = r3.f3262b
            int r3 = r3 * r3
            float r3 = (float) r3
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 <= 0) goto L45
            goto L44
        L29:
            if (r4 == 0) goto L37
            float r4 = java.lang.Math.abs(r5)
            int r3 = r3.f3262b
            float r3 = (float) r3
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 <= 0) goto L45
            goto L44
        L37:
            if (r1 == 0) goto L45
            float r4 = java.lang.Math.abs(r6)
            int r3 = r3.f3262b
            float r3 = (float) r3
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 <= 0) goto L45
        L44:
            return r2
        L45:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.c.e(android.view.View, float, float):boolean");
    }

    public final void f(int i10) {
        float[] fArr = this.f3264d;
        if (fArr != null) {
            int i11 = this.f3270k;
            int i12 = 1 << i10;
            if ((i11 & i12) != 0) {
                fArr[i10] = 0.0f;
                this.f3265e[i10] = 0.0f;
                this.f3266f[i10] = 0.0f;
                this.f3267g[i10] = 0.0f;
                this.h[i10] = 0;
                this.f3268i[i10] = 0;
                this.f3269j[i10] = 0;
                this.f3270k = (~i12) & i11;
            }
        }
    }

    public final int g(int i10, int i11, int i12) {
        if (i10 == 0) {
            return 0;
        }
        float width = this.f3280v.getWidth() / 2;
        float fSin = (((float) Math.sin((Math.min(1.0f, Math.abs(i10) / r3) - 0.5f) * 0.47123894f)) * width) + width;
        int iAbs = Math.abs(i11);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fSin / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i10) / i12) + 1.0f) * 256.0f), 600);
    }

    public final boolean h() {
        if (this.f3261a == 2) {
            OverScroller overScroller = this.r;
            boolean zComputeScrollOffset = overScroller.computeScrollOffset();
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int left = currX - this.f3278t.getLeft();
            int top = currY - this.f3278t.getTop();
            if (left != 0) {
                View view = this.f3278t;
                WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                view.offsetLeftAndRight(left);
            }
            if (top != 0) {
                View view2 = this.f3278t;
                WeakHashMap<View, h0> weakHashMap2 = e0.f13274a;
                view2.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.f3277s.i(this.f3278t, currX, currY);
            }
            if (zComputeScrollOffset && currX == overScroller.getFinalX() && currY == overScroller.getFinalY()) {
                overScroller.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                this.f3280v.post(this.f3281w);
            }
        }
        return this.f3261a == 2;
    }

    public final View i(int i10, int i11) {
        ViewGroup viewGroup = this.f3280v;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            this.f3277s.getClass();
            View childAt = viewGroup.getChildAt(childCount);
            if (i10 >= childAt.getLeft() && i10 < childAt.getRight() && i11 >= childAt.getTop() && i11 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean j(int i10, int i11, int i12, int i13) {
        float f8;
        float f9;
        float f10;
        float f11;
        int left = this.f3278t.getLeft();
        int top = this.f3278t.getTop();
        int i14 = i10 - left;
        int i15 = i11 - top;
        OverScroller overScroller = this.r;
        if (i14 == 0 && i15 == 0) {
            overScroller.abortAnimation();
            r(0);
            return false;
        }
        View view = this.f3278t;
        int i16 = (int) this.f3273n;
        int i17 = (int) this.f3272m;
        int iAbs = Math.abs(i12);
        if (iAbs < i16) {
            i12 = 0;
        } else if (iAbs > i17) {
            i12 = i12 > 0 ? i17 : -i17;
        }
        int i18 = (int) this.f3273n;
        int iAbs2 = Math.abs(i13);
        if (iAbs2 < i18) {
            i13 = 0;
        } else if (iAbs2 > i17) {
            i13 = i13 > 0 ? i17 : -i17;
        }
        int iAbs3 = Math.abs(i14);
        int iAbs4 = Math.abs(i15);
        int iAbs5 = Math.abs(i12);
        int iAbs6 = Math.abs(i13);
        int i19 = iAbs5 + iAbs6;
        int i20 = iAbs3 + iAbs4;
        if (i12 != 0) {
            f8 = iAbs5;
            f9 = i19;
        } else {
            f8 = iAbs3;
            f9 = i20;
        }
        float f12 = f8 / f9;
        if (i13 != 0) {
            f10 = iAbs6;
            f11 = i19;
        } else {
            f10 = iAbs4;
            f11 = i20;
        }
        float f13 = f10 / f11;
        AbstractC0028c abstractC0028c = this.f3277s;
        overScroller.startScroll(left, top, i14, i15, (int) ((g(i15, i13, abstractC0028c.d()) * f13) + (g(i14, i12, abstractC0028c.c(view)) * f12)));
        r(2);
        return true;
    }

    public final boolean k(int i10) {
        if ((this.f3270k & (1 << i10)) != 0) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i10 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public final void m(MotionEvent motionEvent) {
        int i10;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            b();
        }
        if (this.f3271l == null) {
            this.f3271l = VelocityTracker.obtain();
        }
        this.f3271l.addMovement(motionEvent);
        AbstractC0028c abstractC0028c = this.f3277s;
        int i11 = 0;
        if (actionMasked == 0) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewI = i((int) x3, (int) y3);
            p(x3, pointerId, y3);
            v(pointerId, viewI);
            if ((this.f3276q & this.h[pointerId]) != 0) {
                abstractC0028c.f(pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f3261a == 1) {
                n();
            }
            b();
            return;
        }
        if (actionMasked == 2) {
            if (this.f3261a != 1) {
                int pointerCount = motionEvent.getPointerCount();
                while (i11 < pointerCount) {
                    int pointerId2 = motionEvent.getPointerId(i11);
                    if (k(pointerId2)) {
                        float x8 = motionEvent.getX(i11);
                        float y5 = motionEvent.getY(i11);
                        float f8 = x8 - this.f3264d[pointerId2];
                        float f9 = y5 - this.f3265e[pointerId2];
                        o(f8, pointerId2, f9);
                        if (this.f3261a != 1) {
                            View viewI2 = i((int) x8, (int) y5);
                            if (e(viewI2, f8, f9) && v(pointerId2, viewI2)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    i11++;
                }
                q(motionEvent);
                return;
            }
            if (k(this.f3263c)) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f3263c);
                float x10 = motionEvent.getX(iFindPointerIndex);
                float y8 = motionEvent.getY(iFindPointerIndex);
                float[] fArr = this.f3266f;
                int i12 = this.f3263c;
                int i13 = (int) (x10 - fArr[i12]);
                int i14 = (int) (y8 - this.f3267g[i12]);
                int left = this.f3278t.getLeft() + i13;
                int top = this.f3278t.getTop() + i14;
                int left2 = this.f3278t.getLeft();
                int top2 = this.f3278t.getTop();
                if (i13 != 0) {
                    left = abstractC0028c.a(left, this.f3278t);
                    WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                    this.f3278t.offsetLeftAndRight(left - left2);
                }
                if (i14 != 0) {
                    top = abstractC0028c.b(top, this.f3278t);
                    WeakHashMap<View, h0> weakHashMap2 = e0.f13274a;
                    this.f3278t.offsetTopAndBottom(top - top2);
                }
                if (i13 != 0 || i14 != 0) {
                    abstractC0028c.i(this.f3278t, left, top);
                }
                q(motionEvent);
                return;
            }
            return;
        }
        if (actionMasked == 3) {
            if (this.f3261a == 1) {
                this.f3279u = true;
                abstractC0028c.j(this.f3278t, 0.0f, 0.0f);
                this.f3279u = false;
                if (this.f3261a == 1) {
                    r(0);
                }
            }
            b();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x11 = motionEvent.getX(actionIndex);
            float y10 = motionEvent.getY(actionIndex);
            p(x11, pointerId3, y10);
            if (this.f3261a != 0) {
                if (l(this.f3278t, (int) x11, (int) y10)) {
                    v(pointerId3, this.f3278t);
                    return;
                }
                return;
            }
            v(pointerId3, i((int) x11, (int) y10));
            if ((this.f3276q & this.h[pointerId3]) != 0) {
                abstractC0028c.f(pointerId3);
                return;
            }
            return;
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f3261a == 1 && pointerId4 == this.f3263c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i11 >= pointerCount2) {
                    i10 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i11);
                if (pointerId5 != this.f3263c) {
                    View viewI3 = i((int) motionEvent.getX(i11), (int) motionEvent.getY(i11));
                    View view = this.f3278t;
                    if (viewI3 == view && v(pointerId5, view)) {
                        i10 = this.f3263c;
                        break;
                    }
                }
                i11++;
            }
            if (i10 == -1) {
                n();
            }
        }
        f(pointerId4);
    }

    public final void n() {
        VelocityTracker velocityTracker = this.f3271l;
        float f8 = this.f3272m;
        velocityTracker.computeCurrentVelocity(1000, f8);
        float xVelocity = this.f3271l.getXVelocity(this.f3263c);
        float f9 = this.f3273n;
        float fAbs = Math.abs(xVelocity);
        if (fAbs < f9) {
            xVelocity = 0.0f;
        } else if (fAbs > f8) {
            xVelocity = xVelocity > 0.0f ? f8 : -f8;
        }
        float yVelocity = this.f3271l.getYVelocity(this.f3263c);
        float f10 = this.f3273n;
        float fAbs2 = Math.abs(yVelocity);
        if (fAbs2 < f10) {
            f8 = 0.0f;
        } else if (fAbs2 <= f8) {
            f8 = yVelocity;
        } else if (yVelocity <= 0.0f) {
            f8 = -f8;
        }
        this.f3279u = true;
        this.f3277s.j(this.f3278t, xVelocity, f8);
        this.f3279u = false;
        if (this.f3261a == 1) {
            r(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final void o(float f8, int i10, float f9) {
        boolean zD = d(f8, f9, i10, 1);
        boolean z = zD;
        if (d(f9, f8, i10, 4)) {
            z = (zD ? 1 : 0) | 4;
        }
        boolean z3 = z;
        if (d(f8, f9, i10, 2)) {
            z3 = (z ? 1 : 0) | 2;
        }
        ?? r02 = z3;
        if (d(f9, f8, i10, 8)) {
            r02 = (z3 ? 1 : 0) | 8;
        }
        if (r02 != 0) {
            int[] iArr = this.f3268i;
            iArr[i10] = iArr[i10] | r02;
            this.f3277s.e(i10);
        }
    }

    public final void p(float f8, int i10, float f9) {
        float[] fArr = this.f3264d;
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
                float[] fArr6 = this.f3265e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f3266f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f3267g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f3268i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f3269j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f3264d = fArr2;
            this.f3265e = fArr3;
            this.f3266f = fArr4;
            this.f3267g = fArr5;
            this.h = iArr;
            this.f3268i = iArr2;
            this.f3269j = iArr3;
        }
        float[] fArr9 = this.f3264d;
        this.f3266f[i10] = f8;
        fArr9[i10] = f8;
        float[] fArr10 = this.f3265e;
        this.f3267g[i10] = f9;
        fArr10[i10] = f9;
        int[] iArr7 = this.h;
        int i12 = (int) f8;
        int i13 = (int) f9;
        ViewGroup viewGroup = this.f3280v;
        int i14 = i12 < viewGroup.getLeft() + this.f3274o ? 1 : 0;
        if (i13 < viewGroup.getTop() + this.f3274o) {
            i14 |= 4;
        }
        if (i12 > viewGroup.getRight() - this.f3274o) {
            i14 |= 2;
        }
        if (i13 > viewGroup.getBottom() - this.f3274o) {
            i14 |= 8;
        }
        iArr7[i10] = i14;
        this.f3270k |= 1 << i10;
    }

    public final void q(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i10 = 0; i10 < pointerCount; i10++) {
            int pointerId = motionEvent.getPointerId(i10);
            if (k(pointerId)) {
                float x3 = motionEvent.getX(i10);
                float y3 = motionEvent.getY(i10);
                this.f3266f[pointerId] = x3;
                this.f3267g[pointerId] = y3;
            }
        }
    }

    public final void r(int i10) {
        this.f3280v.removeCallbacks(this.f3281w);
        if (this.f3261a != i10) {
            this.f3261a = i10;
            this.f3277s.h(i10);
            if (this.f3261a == 0) {
                this.f3278t = null;
            }
        }
    }

    public final boolean s(int i10, int i11) {
        if (this.f3279u) {
            return j(i10, i11, (int) this.f3271l.getXVelocity(this.f3263c), (int) this.f3271l.getYVelocity(this.f3263c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean t(android.view.MotionEvent r19) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c1.c.t(android.view.MotionEvent):boolean");
    }

    public final boolean u(View view, int i10, int i11) {
        this.f3278t = view;
        this.f3263c = -1;
        boolean zJ = j(i10, i11, 0, 0);
        if (!zJ && this.f3261a == 0 && this.f3278t != null) {
            this.f3278t = null;
        }
        return zJ;
    }

    public final boolean v(int i10, View view) {
        if (view == this.f3278t && this.f3263c == i10) {
            return true;
        }
        if (view == null || !this.f3277s.k(i10, view)) {
            return false;
        }
        this.f3263c = i10;
        c(i10, view);
        return true;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: c1.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0028c {
        public abstract int a(int i10, View view);

        public abstract int b(int i10, View view);

        public int c(View view) {
            return 0;
        }

        public int d() {
            return 0;
        }

        public abstract void h(int i10);

        public abstract void i(View view, int i10, int i11);

        public abstract void j(View view, float f8, float f9);

        public abstract boolean k(int i10, View view);

        public void e(int i10) {
        }

        public void f(int i10) {
        }

        public void g(int i10, View view) {
        }
    }
}
