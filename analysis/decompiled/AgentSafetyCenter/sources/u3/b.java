package u3;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.OverScroller;
import androidx.fragment.app.r;
import g5.f;
import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.WeakHashMap;
import n3.k0;
import t.i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: v, reason: collision with root package name */
    public static final a f14025v = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f14026a;

    /* renamed from: b, reason: collision with root package name */
    public int f14027b;

    /* renamed from: c, reason: collision with root package name */
    public int f14028c;

    /* renamed from: d, reason: collision with root package name */
    public float[] f14029d;

    /* renamed from: e, reason: collision with root package name */
    public float[] f14030e;

    /* renamed from: f, reason: collision with root package name */
    public float[] f14031f;

    /* renamed from: g, reason: collision with root package name */
    public float[] f14032g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f14033h;
    public int[] i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f14034j;

    /* renamed from: k, reason: collision with root package name */
    public int f14035k;

    /* renamed from: l, reason: collision with root package name */
    public VelocityTracker f14036l;

    /* renamed from: m, reason: collision with root package name */
    public float f14037m;

    /* renamed from: n, reason: collision with root package name */
    public float f14038n;

    /* renamed from: o, reason: collision with root package name */
    public int f14039o;

    /* renamed from: p, reason: collision with root package name */
    public OverScroller f14040p;

    /* renamed from: q, reason: collision with root package name */
    public i1 f14041q;

    /* renamed from: r, reason: collision with root package name */
    public View f14042r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f14043s;

    /* renamed from: t, reason: collision with root package name */
    public ViewGroup f14044t;

    /* renamed from: u, reason: collision with root package name */
    public r f14045u;

    public static b g(androidx.coordinatorlayout.widget.a aVar, i1 i1Var) {
        Context context = aVar.getContext();
        b bVar = new b();
        bVar.f14028c = -1;
        r rVar = new r(15);
        rVar.f1301f = bVar;
        VarHandle.storeStoreFence();
        bVar.f14045u = rVar;
        if (i1Var == null) {
            f.s("Callback may not be null");
            return null;
        }
        bVar.f14044t = aVar;
        bVar.f14041q = i1Var;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        bVar.f14039o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        bVar.f14027b = viewConfiguration.getScaledTouchSlop();
        bVar.f14037m = viewConfiguration.getScaledMaximumFlingVelocity();
        bVar.f14038n = viewConfiguration.getScaledMinimumFlingVelocity();
        bVar.f14040p = new OverScroller(context, f14025v);
        VarHandle.storeStoreFence();
        return bVar;
    }

    public final void a() {
        this.f14028c = -1;
        float[] fArr = this.f14029d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f14030e, 0.0f);
            Arrays.fill(this.f14031f, 0.0f);
            Arrays.fill(this.f14032g, 0.0f);
            Arrays.fill(this.f14033h, 0);
            Arrays.fill(this.i, 0);
            Arrays.fill(this.f14034j, 0);
            this.f14035k = 0;
        }
        VelocityTracker velocityTracker = this.f14036l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f14036l = null;
        }
    }

    public final void b(int i, View view) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = this.f14044t;
        if (parent != viewGroup) {
            od.f.p("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (", viewGroup, ")");
            return;
        }
        this.f14042r = view;
        this.f14028c = i;
        this.f14041q.j(i, view);
        o(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0044 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(android.view.View r4, float r5, float r6) {
        /*
            r3 = this;
            t.i1 r0 = r3.f14041q
            r1 = 0
            if (r4 != 0) goto L6
            goto L45
        L6:
            int r4 = r0.f(r4)
            r2 = 1
            if (r4 <= 0) goto Lf
            r4 = r2
            goto L10
        Lf:
            r4 = r1
        L10:
            int r0 = r0.g()
            if (r0 <= 0) goto L18
            r0 = r2
            goto L19
        L18:
            r0 = r1
        L19:
            if (r4 == 0) goto L29
            if (r0 == 0) goto L29
            float r5 = r5 * r5
            float r6 = r6 * r6
            float r6 = r6 + r5
            int r3 = r3.f14027b
            int r3 = r3 * r3
            float r3 = (float) r3
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 <= 0) goto L45
            goto L44
        L29:
            if (r4 == 0) goto L37
            float r4 = java.lang.Math.abs(r5)
            int r3 = r3.f14027b
            float r3 = (float) r3
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 <= 0) goto L45
            goto L44
        L37:
            if (r0 == 0) goto L45
            float r4 = java.lang.Math.abs(r6)
            int r3 = r3.f14027b
            float r3 = (float) r3
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 <= 0) goto L45
        L44:
            return r2
        L45:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.b.c(android.view.View, float, float):boolean");
    }

    public final void d(int i) {
        float[] fArr = this.f14029d;
        if (fArr != null) {
            int i3 = this.f14035k;
            int i10 = 1 << i;
            if ((i3 & i10) != 0) {
                fArr[i] = 0.0f;
                this.f14030e[i] = 0.0f;
                this.f14031f[i] = 0.0f;
                this.f14032g[i] = 0.0f;
                this.f14033h[i] = 0;
                this.i[i] = 0;
                this.f14034j[i] = 0;
                this.f14035k = (~i10) & i3;
            }
        }
    }

    public final int e(int i, int i3, int i10) {
        if (i == 0) {
            return 0;
        }
        float width = this.f14044t.getWidth() / 2;
        float fSin = (((float) Math.sin((Math.min(1.0f, Math.abs(i) / r3) - 0.5f) * 0.47123894f)) * width) + width;
        int iAbs = Math.abs(i3);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fSin / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i) / i10) + 1.0f) * 256.0f), 600);
    }

    public final boolean f() {
        OverScroller overScroller = this.f14040p;
        if (this.f14026a == 2) {
            boolean zComputeScrollOffset = overScroller.computeScrollOffset();
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int left = currX - this.f14042r.getLeft();
            int top = currY - this.f14042r.getTop();
            if (left != 0) {
                View view = this.f14042r;
                WeakHashMap weakHashMap = k0.f8724a;
                view.offsetLeftAndRight(left);
            }
            if (top != 0) {
                View view2 = this.f14042r;
                WeakHashMap weakHashMap2 = k0.f8724a;
                view2.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.f14041q.l(this.f14042r, currX, currY);
            }
            if (zComputeScrollOffset && currX == overScroller.getFinalX() && currY == overScroller.getFinalY()) {
                overScroller.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                this.f14044t.post(this.f14045u);
            }
        }
        return this.f14026a == 2;
    }

    public final View h(int i, int i3) {
        ViewGroup viewGroup = this.f14044t;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            this.f14041q.getClass();
            View childAt = viewGroup.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean i(int i, int i3, int i10, int i11) {
        float f5;
        float f10;
        float f11;
        float f12;
        OverScroller overScroller = this.f14040p;
        int left = this.f14042r.getLeft();
        int top = this.f14042r.getTop();
        int i12 = i - left;
        int i13 = i3 - top;
        if (i12 == 0 && i13 == 0) {
            overScroller.abortAnimation();
            o(0);
            return false;
        }
        View view = this.f14042r;
        i1 i1Var = this.f14041q;
        int i14 = (int) this.f14038n;
        int i15 = (int) this.f14037m;
        int iAbs = Math.abs(i10);
        if (iAbs < i14) {
            i10 = 0;
        } else if (iAbs > i15) {
            i10 = i10 > 0 ? i15 : -i15;
        }
        int iAbs2 = Math.abs(i11);
        if (iAbs2 < i14) {
            i11 = 0;
        } else if (iAbs2 > i15) {
            i11 = i11 > 0 ? i15 : -i15;
        }
        int iAbs3 = Math.abs(i12);
        int iAbs4 = Math.abs(i13);
        int iAbs5 = Math.abs(i10);
        int iAbs6 = Math.abs(i11);
        int i16 = iAbs5 + iAbs6;
        int i17 = iAbs3 + iAbs4;
        if (i10 != 0) {
            f5 = iAbs5;
            f10 = i16;
        } else {
            f5 = iAbs3;
            f10 = i17;
        }
        float f13 = f5 / f10;
        if (i11 != 0) {
            f11 = iAbs6;
            f12 = i16;
        } else {
            f11 = iAbs4;
            f12 = i17;
        }
        overScroller.startScroll(left, top, i12, i13, (int) ((e(i13, i11, i1Var.g()) * (f11 / f12)) + (e(i12, i10, i1Var.f(view)) * f13)));
        o(2);
        return true;
    }

    public final boolean j(int i) {
        if ((this.f14035k & (1 << i)) != 0) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public final void k(MotionEvent motionEvent) {
        int i;
        i1 i1Var = this.f14041q;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f14036l == null) {
            this.f14036l = VelocityTracker.obtain();
        }
        this.f14036l.addMovement(motionEvent);
        int i3 = 0;
        if (actionMasked == 0) {
            float x6 = motionEvent.getX();
            float y10 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewH = h((int) x6, (int) y10);
            m(x6, y10, pointerId);
            r(pointerId, viewH);
            int i10 = this.f14033h[pointerId];
            return;
        }
        if (actionMasked == 1) {
            if (this.f14026a == 1) {
                l();
            }
            a();
            return;
        }
        if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.f14026a == 1) {
                    this.f14043s = true;
                    i1Var.m(this.f14042r, 0.0f, 0.0f);
                    this.f14043s = false;
                    if (this.f14026a == 1) {
                        o(0);
                    }
                }
                a();
                return;
            }
            if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x10 = motionEvent.getX(actionIndex);
                float y11 = motionEvent.getY(actionIndex);
                m(x10, y11, pointerId2);
                if (this.f14026a == 0) {
                    r(pointerId2, h((int) x10, (int) y11));
                    int i11 = this.f14033h[pointerId2];
                    return;
                }
                int i12 = (int) x10;
                int i13 = (int) y11;
                View view = this.f14042r;
                if (view != null && i12 >= view.getLeft() && i12 < view.getRight() && i13 >= view.getTop() && i13 < view.getBottom()) {
                    i3 = 1;
                }
                if (i3 != 0) {
                    r(pointerId2, this.f14042r);
                    return;
                }
                return;
            }
            if (actionMasked != 6) {
                return;
            }
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            if (this.f14026a == 1 && pointerId3 == this.f14028c) {
                int pointerCount = motionEvent.getPointerCount();
                while (true) {
                    if (i3 >= pointerCount) {
                        i = -1;
                        break;
                    }
                    int pointerId4 = motionEvent.getPointerId(i3);
                    if (pointerId4 != this.f14028c) {
                        View viewH2 = h((int) motionEvent.getX(i3), (int) motionEvent.getY(i3));
                        View view2 = this.f14042r;
                        if (viewH2 == view2 && r(pointerId4, view2)) {
                            i = this.f14028c;
                            break;
                        }
                    }
                    i3++;
                }
                if (i == -1) {
                    l();
                }
            }
            d(pointerId3);
            return;
        }
        if (this.f14026a == 1) {
            if (j(this.f14028c)) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f14028c);
                float x11 = motionEvent.getX(iFindPointerIndex);
                float y12 = motionEvent.getY(iFindPointerIndex);
                float[] fArr = this.f14031f;
                int i14 = this.f14028c;
                int i15 = (int) (x11 - fArr[i14]);
                int i16 = (int) (y12 - this.f14032g[i14]);
                int left = this.f14042r.getLeft() + i15;
                int top = this.f14042r.getTop() + i16;
                int left2 = this.f14042r.getLeft();
                int top2 = this.f14042r.getTop();
                if (i15 != 0) {
                    left = i1Var.b(left, this.f14042r);
                    WeakHashMap weakHashMap = k0.f8724a;
                    this.f14042r.offsetLeftAndRight(left - left2);
                }
                if (i16 != 0) {
                    top = i1Var.c(top, this.f14042r);
                    WeakHashMap weakHashMap2 = k0.f8724a;
                    this.f14042r.offsetTopAndBottom(top - top2);
                }
                if (i15 != 0 || i16 != 0) {
                    i1Var.l(this.f14042r, left, top);
                }
                n(motionEvent);
                return;
            }
            return;
        }
        int pointerCount2 = motionEvent.getPointerCount();
        while (i3 < pointerCount2) {
            int pointerId5 = motionEvent.getPointerId(i3);
            if (j(pointerId5)) {
                float x12 = motionEvent.getX(i3);
                float y13 = motionEvent.getY(i3);
                float f5 = x12 - this.f14029d[pointerId5];
                float f10 = y13 - this.f14030e[pointerId5];
                Math.abs(f5);
                Math.abs(f10);
                int i17 = this.f14033h[pointerId5];
                Math.abs(f10);
                Math.abs(f5);
                int i18 = this.f14033h[pointerId5];
                Math.abs(f5);
                Math.abs(f10);
                int i19 = this.f14033h[pointerId5];
                Math.abs(f10);
                Math.abs(f5);
                int i20 = this.f14033h[pointerId5];
                if (this.f14026a != 1) {
                    View viewH3 = h((int) x12, (int) y13);
                    if (c(viewH3, f5, f10) && r(pointerId5, viewH3)) {
                        break;
                    }
                } else {
                    break;
                }
            }
            i3++;
        }
        n(motionEvent);
    }

    public final void l() {
        VelocityTracker velocityTracker = this.f14036l;
        float f5 = this.f14037m;
        velocityTracker.computeCurrentVelocity(1000, f5);
        float xVelocity = this.f14036l.getXVelocity(this.f14028c);
        float f10 = this.f14038n;
        float fAbs = Math.abs(xVelocity);
        if (fAbs < f10) {
            xVelocity = 0.0f;
        } else if (fAbs > f5) {
            xVelocity = xVelocity > 0.0f ? f5 : -f5;
        }
        float yVelocity = this.f14036l.getYVelocity(this.f14028c);
        float fAbs2 = Math.abs(yVelocity);
        if (fAbs2 < f10) {
            f5 = 0.0f;
        } else if (fAbs2 <= f5) {
            f5 = yVelocity;
        } else if (yVelocity <= 0.0f) {
            f5 = -f5;
        }
        this.f14043s = true;
        this.f14041q.m(this.f14042r, xVelocity, f5);
        this.f14043s = false;
        if (this.f14026a == 1) {
            o(0);
        }
    }

    public final void m(float f5, float f10, int i) {
        float[] fArr = this.f14029d;
        if (fArr == null || fArr.length <= i) {
            int i3 = i + 1;
            float[] fArr2 = new float[i3];
            float[] fArr3 = new float[i3];
            float[] fArr4 = new float[i3];
            float[] fArr5 = new float[i3];
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f14030e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f14031f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f14032g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f14033h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f14034j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f14029d = fArr2;
            this.f14030e = fArr3;
            this.f14031f = fArr4;
            this.f14032g = fArr5;
            this.f14033h = iArr;
            this.i = iArr2;
            this.f14034j = iArr3;
        }
        float[] fArr9 = this.f14029d;
        this.f14031f[i] = f5;
        fArr9[i] = f5;
        float[] fArr10 = this.f14030e;
        this.f14032g[i] = f10;
        fArr10[i] = f10;
        int[] iArr7 = this.f14033h;
        int i10 = (int) f5;
        int i11 = (int) f10;
        ViewGroup viewGroup = this.f14044t;
        int left = viewGroup.getLeft();
        int i12 = this.f14039o;
        int i13 = i10 < left + i12 ? 1 : 0;
        if (i11 < viewGroup.getTop() + i12) {
            i13 |= 4;
        }
        if (i10 > viewGroup.getRight() - i12) {
            i13 |= 2;
        }
        if (i11 > viewGroup.getBottom() - i12) {
            i13 |= 8;
        }
        iArr7[i] = i13;
        this.f14035k |= 1 << i;
    }

    public final void n(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (j(pointerId)) {
                float x6 = motionEvent.getX(i);
                float y10 = motionEvent.getY(i);
                this.f14031f[pointerId] = x6;
                this.f14032g[pointerId] = y10;
            }
        }
    }

    public final void o(int i) {
        this.f14044t.removeCallbacks(this.f14045u);
        if (this.f14026a != i) {
            this.f14026a = i;
            this.f14041q.k(i);
            if (this.f14026a == 0) {
                this.f14042r = null;
            }
        }
    }

    public final boolean p(int i, int i3) {
        if (this.f14043s) {
            return i(i, i3, (int) this.f14036l.getXVelocity(this.f14028c), (int) this.f14036l.getYVelocity(this.f14028c));
        }
        od.f.e("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(android.view.MotionEvent r19) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u3.b.q(android.view.MotionEvent):boolean");
    }

    public final boolean r(int i, View view) {
        if (view == this.f14042r && this.f14028c == i) {
            return true;
        }
        if (view == null || !this.f14041q.t(i, view)) {
            return false;
        }
        this.f14028c = i;
        b(i, view);
        return true;
    }
}
