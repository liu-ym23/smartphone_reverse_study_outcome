package Q;

import K.S;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.OverScroller;
import com.baidu.platform.comapi.UIMsg;
import com.stepos.alphame.utils.Property;
import h.RunnableC0583a;
import java.util.Arrays;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: v, reason: collision with root package name */
    public static final d f1604v = new d(0);

    /* renamed from: a, reason: collision with root package name */
    public int f1605a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1606b;

    /* renamed from: d, reason: collision with root package name */
    public float[] f1608d;

    /* renamed from: e, reason: collision with root package name */
    public float[] f1609e;

    /* renamed from: f, reason: collision with root package name */
    public float[] f1610f;

    /* renamed from: g, reason: collision with root package name */
    public float[] f1611g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f1612h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f1613i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f1614j;

    /* renamed from: k, reason: collision with root package name */
    public int f1615k;

    /* renamed from: l, reason: collision with root package name */
    public VelocityTracker f1616l;

    /* renamed from: m, reason: collision with root package name */
    public final float f1617m;

    /* renamed from: n, reason: collision with root package name */
    public final float f1618n;

    /* renamed from: o, reason: collision with root package name */
    public final int f1619o;

    /* renamed from: p, reason: collision with root package name */
    public final OverScroller f1620p;

    /* renamed from: q, reason: collision with root package name */
    public final com.stepos.statsrpk.c f1621q;

    /* renamed from: r, reason: collision with root package name */
    public View f1622r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1623s;

    /* renamed from: t, reason: collision with root package name */
    public final ViewGroup f1624t;

    /* renamed from: c, reason: collision with root package name */
    public int f1607c = -1;

    /* renamed from: u, reason: collision with root package name */
    public final RunnableC0583a f1625u = new RunnableC0583a(5, this);

    public e(Context context, ViewGroup viewGroup, com.stepos.statsrpk.c cVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (cVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f1624t = viewGroup;
        this.f1621q = cVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1619o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f1606b = viewConfiguration.getScaledTouchSlop();
        this.f1617m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f1618n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1620p = new OverScroller(context, f1604v);
    }

    public final void a() {
        this.f1607c = -1;
        float[] fArr = this.f1608d;
        if (fArr != null) {
            Arrays.fill(fArr, Property.DEFAULT_FLOAT_VALUE);
            Arrays.fill(this.f1609e, Property.DEFAULT_FLOAT_VALUE);
            Arrays.fill(this.f1610f, Property.DEFAULT_FLOAT_VALUE);
            Arrays.fill(this.f1611g, Property.DEFAULT_FLOAT_VALUE);
            Arrays.fill(this.f1612h, 0);
            Arrays.fill(this.f1613i, 0);
            Arrays.fill(this.f1614j, 0);
            this.f1615k = 0;
        }
        VelocityTracker velocityTracker = this.f1616l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f1616l = null;
        }
    }

    public final void b(int i4, View view) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = this.f1624t;
        if (parent != viewGroup) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + viewGroup + ")");
        }
        this.f1622r = view;
        this.f1607c = i4;
        this.f1621q.E(i4, view);
        n(1);
    }

    public final boolean c(View view, float f4, float f5) {
        if (view == null) {
            return false;
        }
        com.stepos.statsrpk.c cVar = this.f1621q;
        boolean z4 = cVar.x(view) > 0;
        boolean z5 = cVar.y() > 0;
        if (!z4 || !z5) {
            return z4 ? Math.abs(f4) > ((float) this.f1606b) : z5 && Math.abs(f5) > ((float) this.f1606b);
        }
        float f6 = (f5 * f5) + (f4 * f4);
        int i4 = this.f1606b;
        return f6 > ((float) (i4 * i4));
    }

    public final void d(int i4) {
        float[] fArr = this.f1608d;
        if (fArr != null) {
            int i5 = this.f1615k;
            int i6 = 1 << i4;
            if ((i5 & i6) != 0) {
                fArr[i4] = 0.0f;
                this.f1609e[i4] = 0.0f;
                this.f1610f[i4] = 0.0f;
                this.f1611g[i4] = 0.0f;
                this.f1612h[i4] = 0;
                this.f1613i[i4] = 0;
                this.f1614j[i4] = 0;
                this.f1615k = (~i6) & i5;
            }
        }
    }

    public final int e(int i4, int i5, int i6) {
        if (i4 == 0) {
            return 0;
        }
        float width = this.f1624t.getWidth() / 2;
        float fSin = (((float) Math.sin((Math.min(1.0f, Math.abs(i4) / r3) - 0.5f) * 0.47123894f)) * width) + width;
        int iAbs = Math.abs(i5);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fSin / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i4) / i6) + 1.0f) * 256.0f), UIMsg.MSG_MAP_PANO_DATA);
    }

    public final boolean f() {
        if (this.f1605a == 2) {
            OverScroller overScroller = this.f1620p;
            boolean zComputeScrollOffset = overScroller.computeScrollOffset();
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int left = currX - this.f1622r.getLeft();
            int top = currY - this.f1622r.getTop();
            if (left != 0) {
                View view = this.f1622r;
                WeakHashMap weakHashMap = S.f939a;
                view.offsetLeftAndRight(left);
            }
            if (top != 0) {
                View view2 = this.f1622r;
                WeakHashMap weakHashMap2 = S.f939a;
                view2.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.f1621q.G(this.f1622r, currX, currY);
            }
            if (zComputeScrollOffset && currX == overScroller.getFinalX() && currY == overScroller.getFinalY()) {
                overScroller.abortAnimation();
            } else if (!zComputeScrollOffset) {
            }
            this.f1624t.post(this.f1625u);
        }
        return this.f1605a == 2;
    }

    public final View g(int i4, int i5) {
        ViewGroup viewGroup = this.f1624t;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            this.f1621q.getClass();
            View childAt = viewGroup.getChildAt(childCount);
            if (i4 >= childAt.getLeft() && i4 < childAt.getRight() && i5 >= childAt.getTop() && i5 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean h(int i4, int i5, int i6, int i7) {
        float f4;
        float f5;
        float f6;
        float f7;
        int left = this.f1622r.getLeft();
        int top = this.f1622r.getTop();
        int i8 = i4 - left;
        int i9 = i5 - top;
        OverScroller overScroller = this.f1620p;
        int i10 = 0;
        if (i8 == 0 && i9 == 0) {
            overScroller.abortAnimation();
            n(0);
            return false;
        }
        View view = this.f1622r;
        int i11 = (int) this.f1618n;
        int i12 = (int) this.f1617m;
        int iAbs = Math.abs(i6);
        if (iAbs < i11) {
            i6 = 0;
        } else if (iAbs > i12) {
            i6 = i6 > 0 ? i12 : -i12;
        }
        int iAbs2 = Math.abs(i7);
        if (iAbs2 < i11) {
            i7 = i10;
        } else if (iAbs2 > i12) {
            if (i7 > 0) {
                i7 = i12;
            } else {
                i10 = -i12;
                i7 = i10;
            }
        }
        int iAbs3 = Math.abs(i8);
        int iAbs4 = Math.abs(i9);
        int iAbs5 = Math.abs(i6);
        int iAbs6 = Math.abs(i7);
        int i13 = iAbs5 + iAbs6;
        int i14 = iAbs3 + iAbs4;
        if (i6 != 0) {
            f4 = iAbs5;
            f5 = i13;
        } else {
            f4 = iAbs3;
            f5 = i14;
        }
        float f8 = f4 / f5;
        if (i7 != 0) {
            f6 = iAbs6;
            f7 = i13;
        } else {
            f6 = iAbs4;
            f7 = i14;
        }
        float f9 = f6 / f7;
        com.stepos.statsrpk.c cVar = this.f1621q;
        overScroller.startScroll(left, top, i8, i9, (int) ((e(i9, i7, cVar.y()) * f9) + (e(i8, i6, cVar.x(view)) * f8)));
        n(2);
        return true;
    }

    public final boolean i(int i4) {
        if ((this.f1615k & (1 << i4)) != 0) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i4 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public final void j(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f1616l == null) {
            this.f1616l = VelocityTracker.obtain();
        }
        this.f1616l.addMovement(motionEvent);
        int i4 = 0;
        if (actionMasked == 0) {
            float x4 = motionEvent.getX();
            float y4 = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewG = g((int) x4, (int) y4);
            l(pointerId, x4, y4);
            q(pointerId, viewG);
            int i5 = this.f1612h[pointerId];
            return;
        }
        if (actionMasked == 1) {
            if (this.f1605a == 1) {
                k();
            }
            a();
            return;
        }
        com.stepos.statsrpk.c cVar = this.f1621q;
        if (actionMasked != 2) {
            if (actionMasked == 3) {
                if (this.f1605a == 1) {
                    this.f1623s = true;
                    cVar.H(this.f1622r, Property.DEFAULT_FLOAT_VALUE, Property.DEFAULT_FLOAT_VALUE);
                    this.f1623s = false;
                    if (this.f1605a == 1) {
                        n(0);
                    }
                }
                a();
                return;
            }
            if (actionMasked == 5) {
                int pointerId2 = motionEvent.getPointerId(actionIndex);
                float x5 = motionEvent.getX(actionIndex);
                float y5 = motionEvent.getY(actionIndex);
                l(pointerId2, x5, y5);
                if (this.f1605a == 0) {
                    q(pointerId2, g((int) x5, (int) y5));
                    int i6 = this.f1612h[pointerId2];
                    return;
                }
                int i7 = (int) x5;
                int i8 = (int) y5;
                View view = this.f1622r;
                if (view != null && i7 >= view.getLeft() && i7 < view.getRight() && i8 >= view.getTop() && i8 < view.getBottom()) {
                    q(pointerId2, this.f1622r);
                    return;
                }
                return;
            }
            if (actionMasked != 6) {
                return;
            }
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            if (this.f1605a == 1 && pointerId3 == this.f1607c) {
                int pointerCount = motionEvent.getPointerCount();
                while (true) {
                    if (i4 >= pointerCount) {
                        break;
                    }
                    int pointerId4 = motionEvent.getPointerId(i4);
                    if (pointerId4 != this.f1607c) {
                        View viewG2 = g((int) motionEvent.getX(i4), (int) motionEvent.getY(i4));
                        View view2 = this.f1622r;
                        if (viewG2 == view2 && q(pointerId4, view2)) {
                            if (this.f1607c == -1) {
                                break;
                            }
                        }
                    }
                    i4++;
                }
                k();
            }
            d(pointerId3);
            return;
        }
        if (this.f1605a == 1) {
            if (i(this.f1607c)) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f1607c);
                float x6 = motionEvent.getX(iFindPointerIndex);
                float y6 = motionEvent.getY(iFindPointerIndex);
                float[] fArr = this.f1610f;
                int i9 = this.f1607c;
                int i10 = (int) (x6 - fArr[i9]);
                int i11 = (int) (y6 - this.f1611g[i9]);
                int left = this.f1622r.getLeft() + i10;
                int top = this.f1622r.getTop() + i11;
                int left2 = this.f1622r.getLeft();
                int top2 = this.f1622r.getTop();
                if (i10 != 0) {
                    left = cVar.o(this.f1622r, left);
                    WeakHashMap weakHashMap = S.f939a;
                    this.f1622r.offsetLeftAndRight(left - left2);
                }
                if (i11 != 0) {
                    top = cVar.p(this.f1622r, top);
                    WeakHashMap weakHashMap2 = S.f939a;
                    this.f1622r.offsetTopAndBottom(top - top2);
                }
                if (i10 != 0 || i11 != 0) {
                    cVar.G(this.f1622r, left, top);
                }
                m(motionEvent);
                return;
            }
            return;
        }
        int pointerCount2 = motionEvent.getPointerCount();
        while (i4 < pointerCount2) {
            int pointerId5 = motionEvent.getPointerId(i4);
            if (i(pointerId5)) {
                float x7 = motionEvent.getX(i4);
                float y7 = motionEvent.getY(i4);
                float f4 = x7 - this.f1608d[pointerId5];
                float f5 = y7 - this.f1609e[pointerId5];
                Math.abs(f4);
                Math.abs(f5);
                int i12 = this.f1612h[pointerId5];
                Math.abs(f5);
                Math.abs(f4);
                int i13 = this.f1612h[pointerId5];
                Math.abs(f4);
                Math.abs(f5);
                int i14 = this.f1612h[pointerId5];
                Math.abs(f5);
                Math.abs(f4);
                int i15 = this.f1612h[pointerId5];
                if (this.f1605a != 1) {
                    View viewG3 = g((int) x7, (int) y7);
                    if (c(viewG3, f4, f5) && q(pointerId5, viewG3)) {
                        break;
                    }
                } else {
                    break;
                }
            }
            i4++;
        }
        m(motionEvent);
    }

    public final void k() {
        VelocityTracker velocityTracker = this.f1616l;
        float f4 = this.f1617m;
        velocityTracker.computeCurrentVelocity(1000, f4);
        float xVelocity = this.f1616l.getXVelocity(this.f1607c);
        float f5 = this.f1618n;
        float fAbs = Math.abs(xVelocity);
        float f6 = Property.DEFAULT_FLOAT_VALUE;
        if (fAbs < f5) {
            xVelocity = 0.0f;
        } else if (fAbs > f4) {
            xVelocity = xVelocity > Property.DEFAULT_FLOAT_VALUE ? f4 : -f4;
        }
        float yVelocity = this.f1616l.getYVelocity(this.f1607c);
        float fAbs2 = Math.abs(yVelocity);
        if (fAbs2 >= f5) {
            if (fAbs2 > f4) {
                if (yVelocity <= Property.DEFAULT_FLOAT_VALUE) {
                    f4 = -f4;
                }
                f6 = f4;
            } else {
                f6 = yVelocity;
            }
        }
        this.f1623s = true;
        this.f1621q.H(this.f1622r, xVelocity, f6);
        this.f1623s = false;
        if (this.f1605a == 1) {
            n(0);
        }
    }

    public final void l(int i4, float f4, float f5) {
        float[] fArr = this.f1608d;
        if (fArr == null || fArr.length <= i4) {
            int i5 = i4 + 1;
            float[] fArr2 = new float[i5];
            float[] fArr3 = new float[i5];
            float[] fArr4 = new float[i5];
            float[] fArr5 = new float[i5];
            int[] iArr = new int[i5];
            int[] iArr2 = new int[i5];
            int[] iArr3 = new int[i5];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f1609e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f1610f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f1611g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f1612h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f1613i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f1614j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f1608d = fArr2;
            this.f1609e = fArr3;
            this.f1610f = fArr4;
            this.f1611g = fArr5;
            this.f1612h = iArr;
            this.f1613i = iArr2;
            this.f1614j = iArr3;
        }
        float[] fArr9 = this.f1608d;
        this.f1610f[i4] = f4;
        fArr9[i4] = f4;
        float[] fArr10 = this.f1609e;
        this.f1611g[i4] = f5;
        fArr10[i4] = f5;
        int[] iArr7 = this.f1612h;
        int i6 = (int) f4;
        int i7 = (int) f5;
        ViewGroup viewGroup = this.f1624t;
        int left = viewGroup.getLeft();
        int i8 = this.f1619o;
        int i9 = i6 < left + i8 ? 1 : 0;
        if (i7 < viewGroup.getTop() + i8) {
            i9 |= 4;
        }
        if (i6 > viewGroup.getRight() - i8) {
            i9 |= 2;
        }
        if (i7 > viewGroup.getBottom() - i8) {
            i9 |= 8;
        }
        iArr7[i4] = i9;
        this.f1615k = (1 << i4) | this.f1615k;
    }

    public final void m(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i4 = 0; i4 < pointerCount; i4++) {
            int pointerId = motionEvent.getPointerId(i4);
            if (i(pointerId)) {
                float x4 = motionEvent.getX(i4);
                float y4 = motionEvent.getY(i4);
                this.f1610f[pointerId] = x4;
                this.f1611g[pointerId] = y4;
            }
        }
    }

    public final void n(int i4) {
        this.f1624t.removeCallbacks(this.f1625u);
        if (this.f1605a != i4) {
            this.f1605a = i4;
            this.f1621q.F(i4);
            if (this.f1605a == 0) {
                this.f1622r = null;
            }
        }
    }

    public final boolean o(int i4, int i5) {
        if (this.f1623s) {
            return h(i4, i5, (int) this.f1616l.getXVelocity(this.f1607c), (int) this.f1616l.getYVelocity(this.f1607c));
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
            Method dump skipped, instructions count: 323
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Q.e.p(android.view.MotionEvent):boolean");
    }

    public final boolean q(int i4, View view) {
        if (view == this.f1622r && this.f1607c == i4) {
            return true;
        }
        if (view == null || !this.f1621q.P(i4, view)) {
            return false;
        }
        this.f1607c = i4;
        b(i4, view);
        return true;
    }
}
