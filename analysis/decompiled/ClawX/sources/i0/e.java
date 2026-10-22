package i0;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b8.h;
import e0.a0;
import java.util.Arrays;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: v, reason: collision with root package name */
    public static final d f3106v = new d(0);

    /* renamed from: a, reason: collision with root package name */
    public int f3107a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3108b;
    public float[] d;

    /* renamed from: e, reason: collision with root package name */
    public float[] f3110e;

    /* renamed from: f, reason: collision with root package name */
    public float[] f3111f;

    /* renamed from: g, reason: collision with root package name */
    public float[] f3112g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f3113h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f3114i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f3115j;

    /* renamed from: k, reason: collision with root package name */
    public int f3116k;

    /* renamed from: l, reason: collision with root package name */
    public VelocityTracker f3117l;

    /* renamed from: m, reason: collision with root package name */
    public final float f3118m;

    /* renamed from: n, reason: collision with root package name */
    public final float f3119n;

    /* renamed from: o, reason: collision with root package name */
    public final int f3120o;

    /* renamed from: p, reason: collision with root package name */
    public final OverScroller f3121p;

    /* renamed from: q, reason: collision with root package name */
    public final h f3122q;

    /* renamed from: r, reason: collision with root package name */
    public View f3123r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f3124s;

    /* renamed from: t, reason: collision with root package name */
    public final CoordinatorLayout f3125t;

    /* renamed from: c, reason: collision with root package name */
    public int f3109c = -1;

    /* renamed from: u, reason: collision with root package name */
    public final androidx.fragment.app.b f3126u = new androidx.fragment.app.b(6, this);

    public e(Context context, CoordinatorLayout coordinatorLayout, h hVar) {
        if (hVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f3125t = coordinatorLayout;
        this.f3122q = hVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f3120o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f3108b = viewConfiguration.getScaledTouchSlop();
        this.f3118m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f3119n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3121p = new OverScroller(context, f3106v);
    }

    public final void a() {
        this.f3109c = -1;
        float[] fArr = this.d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f3110e, 0.0f);
            Arrays.fill(this.f3111f, 0.0f);
            Arrays.fill(this.f3112g, 0.0f);
            Arrays.fill(this.f3113h, 0);
            Arrays.fill(this.f3114i, 0);
            Arrays.fill(this.f3115j, 0);
            this.f3116k = 0;
        }
        VelocityTracker velocityTracker = this.f3117l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f3117l = null;
        }
    }

    public final void b(View view, int i8) {
        ViewParent parent = view.getParent();
        CoordinatorLayout coordinatorLayout = this.f3125t;
        if (parent != coordinatorLayout) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + coordinatorLayout + ")");
        }
        this.f3123r = view;
        this.f3109c = i8;
        this.f3122q.B(view, i8);
        n(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0044 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(android.view.View r4, float r5, float r6) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            goto L45
        L4:
            b8.h r1 = r3.f3122q
            int r4 = r1.r(r4)
            r2 = 1
            if (r4 <= 0) goto Lf
            r4 = r2
            goto L10
        Lf:
            r4 = r0
        L10:
            int r1 = r1.s()
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
            int r3 = r3.f3108b
            int r3 = r3 * r3
            float r3 = (float) r3
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 <= 0) goto L45
            goto L44
        L29:
            if (r4 == 0) goto L37
            float r4 = java.lang.Math.abs(r5)
            int r3 = r3.f3108b
            float r3 = (float) r3
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 <= 0) goto L45
            goto L44
        L37:
            if (r1 == 0) goto L45
            float r4 = java.lang.Math.abs(r6)
            int r3 = r3.f3108b
            float r3 = (float) r3
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 <= 0) goto L45
        L44:
            return r2
        L45:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.e.c(android.view.View, float, float):boolean");
    }

    public final void d(int i8) {
        float[] fArr = this.d;
        if (fArr != null) {
            int i9 = this.f3116k;
            int i10 = 1 << i8;
            if ((i9 & i10) != 0) {
                fArr[i8] = 0.0f;
                this.f3110e[i8] = 0.0f;
                this.f3111f[i8] = 0.0f;
                this.f3112g[i8] = 0.0f;
                this.f3113h[i8] = 0;
                this.f3114i[i8] = 0;
                this.f3115j[i8] = 0;
                this.f3116k = (~i10) & i9;
            }
        }
    }

    public final int e(int i8, int i9, int i10) {
        if (i8 == 0) {
            return 0;
        }
        float width = this.f3125t.getWidth() / 2;
        float fSin = (((float) Math.sin((Math.min(1.0f, Math.abs(i8) / r3) - 0.5f) * 0.47123894f)) * width) + width;
        int iAbs = Math.abs(i9);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fSin / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i8) / i10) + 1.0f) * 256.0f), 600);
    }

    public final boolean f() {
        if (this.f3107a == 2) {
            OverScroller overScroller = this.f3121p;
            boolean zComputeScrollOffset = overScroller.computeScrollOffset();
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int left = currX - this.f3123r.getLeft();
            int top = currY - this.f3123r.getTop();
            if (left != 0) {
                View view = this.f3123r;
                int[] iArr = a0.f2285a;
                view.offsetLeftAndRight(left);
            }
            if (top != 0) {
                View view2 = this.f3123r;
                int[] iArr2 = a0.f2285a;
                view2.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.f3122q.D(this.f3123r, currX, currY);
            }
            if (zComputeScrollOffset && currX == overScroller.getFinalX() && currY == overScroller.getFinalY()) {
                overScroller.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                this.f3125t.post(this.f3126u);
            }
        }
        return this.f3107a == 2;
    }

    public final View g(int i8, int i9) {
        CoordinatorLayout coordinatorLayout = this.f3125t;
        for (int childCount = coordinatorLayout.getChildCount() - 1; childCount >= 0; childCount--) {
            this.f3122q.getClass();
            View childAt = coordinatorLayout.getChildAt(childCount);
            if (i8 >= childAt.getLeft() && i8 < childAt.getRight() && i9 >= childAt.getTop() && i9 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean h(int i8, int i9, int i10, int i11) {
        float f3;
        float f7;
        float f9;
        float f10;
        int left = this.f3123r.getLeft();
        int top = this.f3123r.getTop();
        int i12 = i8 - left;
        int i13 = i9 - top;
        OverScroller overScroller = this.f3121p;
        if (i12 == 0 && i13 == 0) {
            overScroller.abortAnimation();
            n(0);
            return false;
        }
        View view = this.f3123r;
        int i14 = (int) this.f3119n;
        int i15 = (int) this.f3118m;
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
            f3 = iAbs5;
            f7 = i16;
        } else {
            f3 = iAbs3;
            f7 = i17;
        }
        float f11 = f3 / f7;
        if (i11 != 0) {
            f9 = iAbs6;
            f10 = i16;
        } else {
            f9 = iAbs4;
            f10 = i17;
        }
        float f12 = f9 / f10;
        h hVar = this.f3122q;
        overScroller.startScroll(left, top, i12, i13, (int) ((e(i13, i11, hVar.s()) * f12) + (e(i12, i10, hVar.r(view)) * f11)));
        n(2);
        return true;
    }

    public final boolean i(int i8) {
        if ((this.f3116k & (1 << i8)) != 0) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i8 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public final void j(MotionEvent motionEvent) {
        int i8;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f3117l == null) {
            this.f3117l = VelocityTracker.obtain();
        }
        this.f3117l.addMovement(motionEvent);
        int i9 = 0;
        if (actionMasked == 0) {
            float x7 = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewG = g((int) x7, (int) y);
            l(x7, y, pointerId);
            q(viewG, pointerId);
            int i10 = this.f3113h[pointerId];
            return;
        }
        if (actionMasked == 1) {
            if (this.f3107a == 1) {
                k();
            }
            a();
            return;
        }
        h hVar = this.f3122q;
        if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.f3107a == 1) {
                    this.f3124s = true;
                    hVar.E(this.f3123r, 0.0f, 0.0f);
                    this.f3124s = false;
                    if (this.f3107a == 1) {
                        n(0);
                    }
                }
                a();
                return;
            }
            if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x8 = motionEvent.getX(actionIndex);
                float y2 = motionEvent.getY(actionIndex);
                l(x8, y2, pointerId2);
                if (this.f3107a == 0) {
                    q(g((int) x8, (int) y2), pointerId2);
                    int i11 = this.f3113h[pointerId2];
                    return;
                }
                int i12 = (int) x8;
                int i13 = (int) y2;
                View view = this.f3123r;
                if (view != null && i12 >= view.getLeft() && i12 < view.getRight() && i13 >= view.getTop() && i13 < view.getBottom()) {
                    i9 = 1;
                }
                if (i9 != 0) {
                    q(this.f3123r, pointerId2);
                    return;
                }
                return;
            }
            if (actionMasked != 6) {
                return;
            }
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            if (this.f3107a == 1 && pointerId3 == this.f3109c) {
                int pointerCount = motionEvent.getPointerCount();
                while (true) {
                    if (i9 >= pointerCount) {
                        i8 = -1;
                        break;
                    }
                    int pointerId4 = motionEvent.getPointerId(i9);
                    if (pointerId4 != this.f3109c) {
                        View viewG2 = g((int) motionEvent.getX(i9), (int) motionEvent.getY(i9));
                        View view2 = this.f3123r;
                        if (viewG2 == view2 && q(view2, pointerId4)) {
                            i8 = this.f3109c;
                            break;
                        }
                    }
                    i9++;
                }
                if (i8 == -1) {
                    k();
                }
            }
            d(pointerId3);
            return;
        }
        if (this.f3107a == 1) {
            if (i(this.f3109c)) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f3109c);
                float x9 = motionEvent.getX(iFindPointerIndex);
                float y4 = motionEvent.getY(iFindPointerIndex);
                float[] fArr = this.f3111f;
                int i14 = this.f3109c;
                int i15 = (int) (x9 - fArr[i14]);
                int i16 = (int) (y4 - this.f3112g[i14]);
                int left = this.f3123r.getLeft() + i15;
                int top = this.f3123r.getTop() + i16;
                int left2 = this.f3123r.getLeft();
                int top2 = this.f3123r.getTop();
                if (i15 != 0) {
                    left = hVar.g(this.f3123r, left);
                    int[] iArr = a0.f2285a;
                    this.f3123r.offsetLeftAndRight(left - left2);
                }
                if (i16 != 0) {
                    top = hVar.h(this.f3123r, top);
                    int[] iArr2 = a0.f2285a;
                    this.f3123r.offsetTopAndBottom(top - top2);
                }
                if (i15 != 0 || i16 != 0) {
                    hVar.D(this.f3123r, left, top);
                }
                m(motionEvent);
                return;
            }
            return;
        }
        int pointerCount2 = motionEvent.getPointerCount();
        while (i9 < pointerCount2) {
            int pointerId5 = motionEvent.getPointerId(i9);
            if (i(pointerId5)) {
                float x10 = motionEvent.getX(i9);
                float y8 = motionEvent.getY(i9);
                float f3 = x10 - this.d[pointerId5];
                float f7 = y8 - this.f3110e[pointerId5];
                Math.abs(f3);
                Math.abs(f7);
                int i17 = this.f3113h[pointerId5];
                Math.abs(f7);
                Math.abs(f3);
                int i18 = this.f3113h[pointerId5];
                Math.abs(f3);
                Math.abs(f7);
                int i19 = this.f3113h[pointerId5];
                Math.abs(f7);
                Math.abs(f3);
                int i20 = this.f3113h[pointerId5];
                if (this.f3107a != 1) {
                    View viewG3 = g((int) x10, (int) y8);
                    if (c(viewG3, f3, f7) && q(viewG3, pointerId5)) {
                        break;
                    }
                } else {
                    break;
                }
            }
            i9++;
        }
        m(motionEvent);
    }

    public final void k() {
        VelocityTracker velocityTracker = this.f3117l;
        float f3 = this.f3118m;
        velocityTracker.computeCurrentVelocity(1000, f3);
        float xVelocity = this.f3117l.getXVelocity(this.f3109c);
        float fAbs = Math.abs(xVelocity);
        float f7 = this.f3119n;
        if (fAbs < f7) {
            xVelocity = 0.0f;
        } else if (fAbs > f3) {
            xVelocity = xVelocity > 0.0f ? f3 : -f3;
        }
        float yVelocity = this.f3117l.getYVelocity(this.f3109c);
        float fAbs2 = Math.abs(yVelocity);
        if (fAbs2 < f7) {
            f3 = 0.0f;
        } else if (fAbs2 <= f3) {
            f3 = yVelocity;
        } else if (yVelocity <= 0.0f) {
            f3 = -f3;
        }
        this.f3124s = true;
        this.f3122q.E(this.f3123r, xVelocity, f3);
        this.f3124s = false;
        if (this.f3107a == 1) {
            n(0);
        }
    }

    public final void l(float f3, float f7, int i8) {
        float[] fArr = this.d;
        if (fArr == null || fArr.length <= i8) {
            int i9 = i8 + 1;
            float[] fArr2 = new float[i9];
            float[] fArr3 = new float[i9];
            float[] fArr4 = new float[i9];
            float[] fArr5 = new float[i9];
            int[] iArr = new int[i9];
            int[] iArr2 = new int[i9];
            int[] iArr3 = new int[i9];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f3110e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f3111f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f3112g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f3113h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f3114i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f3115j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.d = fArr2;
            this.f3110e = fArr3;
            this.f3111f = fArr4;
            this.f3112g = fArr5;
            this.f3113h = iArr;
            this.f3114i = iArr2;
            this.f3115j = iArr3;
        }
        float[] fArr9 = this.d;
        this.f3111f[i8] = f3;
        fArr9[i8] = f3;
        float[] fArr10 = this.f3110e;
        this.f3112g[i8] = f7;
        fArr10[i8] = f7;
        int[] iArr7 = this.f3113h;
        int i10 = (int) f3;
        int i11 = (int) f7;
        CoordinatorLayout coordinatorLayout = this.f3125t;
        int left = coordinatorLayout.getLeft();
        int i12 = this.f3120o;
        int i13 = i10 < left + i12 ? 1 : 0;
        if (i11 < coordinatorLayout.getTop() + i12) {
            i13 |= 4;
        }
        if (i10 > coordinatorLayout.getRight() - i12) {
            i13 |= 2;
        }
        if (i11 > coordinatorLayout.getBottom() - i12) {
            i13 |= 8;
        }
        iArr7[i8] = i13;
        this.f3116k |= 1 << i8;
    }

    public final void m(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i8 = 0; i8 < pointerCount; i8++) {
            int pointerId = motionEvent.getPointerId(i8);
            if (i(pointerId)) {
                float x7 = motionEvent.getX(i8);
                float y = motionEvent.getY(i8);
                this.f3111f[pointerId] = x7;
                this.f3112g[pointerId] = y;
            }
        }
    }

    public final void n(int i8) {
        this.f3125t.removeCallbacks(this.f3126u);
        if (this.f3107a != i8) {
            this.f3107a = i8;
            this.f3122q.C(i8);
            if (this.f3107a == 0) {
                this.f3123r = null;
            }
        }
    }

    public final boolean o(int i8, int i9) {
        if (this.f3124s) {
            return h(i8, i9, (int) this.f3117l.getXVelocity(this.f3109c), (int) this.f3117l.getYVelocity(this.f3109c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean p(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.e.p(android.view.MotionEvent):boolean");
    }

    public final boolean q(View view, int i8) {
        if (view == this.f3123r && this.f3109c == i8) {
            return true;
        }
        if (view == null || !this.f3122q.Q(view, i8)) {
            return false;
        }
        this.f3109c = i8;
        b(view, i8);
        return true;
    }
}
