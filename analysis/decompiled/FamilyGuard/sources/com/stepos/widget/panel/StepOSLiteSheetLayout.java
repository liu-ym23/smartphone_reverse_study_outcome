package com.stepos.widget.panel;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.C0478x;
import androidx.core.view.InterfaceC0477w;
import j4.k;
import kotlin.ranges.l;
import l3.C0847e;
import l3.g;
import l4.C0848a;
import u3.c;
import u3.e;

/* loaded from: classes.dex */
public final class StepOSLiteSheetLayout extends FrameLayout implements InterfaceC0477w {

    /* renamed from: a, reason: collision with root package name */
    private final c f16303a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f16304b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f16305c;

    /* renamed from: d, reason: collision with root package name */
    private float f16306d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f16307e;

    /* renamed from: f, reason: collision with root package name */
    private int f16308f;

    /* renamed from: g, reason: collision with root package name */
    private int f16309g;

    /* renamed from: h, reason: collision with root package name */
    private int f16310h;

    /* renamed from: i, reason: collision with root package name */
    private int f16311i;

    /* renamed from: j, reason: collision with root package name */
    private int f16312j;

    /* renamed from: k, reason: collision with root package name */
    private int f16313k;

    /* renamed from: l, reason: collision with root package name */
    private final float f16314l;

    /* renamed from: m, reason: collision with root package name */
    private final float f16315m;

    /* renamed from: n, reason: collision with root package name */
    private final float f16316n;

    /* renamed from: o, reason: collision with root package name */
    private final ViewConfiguration f16317o;

    /* renamed from: p, reason: collision with root package name */
    private final C0478x f16318p;

    /* renamed from: q, reason: collision with root package name */
    private e f16319q;

    /* renamed from: r, reason: collision with root package name */
    private VelocityTracker f16320r;

    /* renamed from: s, reason: collision with root package name */
    private int f16321s;

    /* renamed from: t, reason: collision with root package name */
    private float f16322t;

    /* renamed from: u, reason: collision with root package name */
    private float f16323u;

    /* renamed from: v, reason: collision with root package name */
    private float f16324v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f16325w;

    /* renamed from: x, reason: collision with root package name */
    private View f16326x;

    /* renamed from: y, reason: collision with root package name */
    private View f16327y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f16328z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSLiteSheetLayout(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        k.g(context, "context");
        this.f16303a = new c();
        this.f16304b = true;
        this.f16305c = true;
        this.f16306d = getResources().getDimension(C0847e.f18349b0);
        this.f16307e = true;
        float dimension = getResources().getDimension(C0847e.f18351c0);
        this.f16314l = dimension;
        float fraction = getResources().getFraction(g.f18408d, 1, 1);
        this.f16315m = fraction;
        float fraction2 = getResources().getFraction(g.f18406b, 1, 1);
        this.f16316n = fraction2;
        this.f16317o = ViewConfiguration.get(context);
        this.f16318p = new C0478x(this);
        this.f16319q = new e(0.0f, 0.0f, 0.0f, dimension, fraction, fraction2, false, 64, null);
        this.f16321s = -1;
    }

    private final int a(int i5) {
        if (this.f16312j > 0) {
            return 0;
        }
        return l.b(this.f16313k - i5, 0);
    }

    private final boolean b(View view) {
        while (view != null && view != this) {
            if (view.canScrollVertically(-1)) {
                return true;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return false;
    }

    private final e c(int i5) {
        return new e(i5, this.f16309g, this.f16312j, this.f16314l, this.f16315m, this.f16316n, this.f16303a.h() == 2);
    }

    private final View d(View view, float f5, float f6) {
        View viewD;
        if (view.getVisibility() != 0 || f5 < 0.0f || f6 < 0.0f || f5 >= view.getWidth() || f6 >= view.getHeight()) {
            return null;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            do {
                childCount--;
                if (-1 < childCount) {
                    View childAt = viewGroup.getChildAt(childCount);
                    k.d(childAt);
                    viewD = d(childAt, (viewGroup.getScrollX() + f5) - childAt.getX(), (viewGroup.getScrollY() + f6) - childAt.getY());
                }
            } while (viewD == null);
            return viewD;
        }
        return view;
    }

    private final void e() {
        VelocityTracker velocityTracker = this.f16320r;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.f16320r = null;
        this.f16321s = -1;
    }

    private final boolean getAcceptsDrag() {
        return this.f16304b && this.f16303a.k() != 2;
    }

    private final StepOSLiteSheetSurface getSurface() {
        View childAt = getChildAt(1);
        k.e(childAt, "null cannot be cast to non-null type com.stepos.widget.panel.StepOSLiteSheetSurface");
        return (StepOSLiteSheetSurface) childAt;
    }

    public final boolean getCanDismiss() {
        return this.f16305c;
    }

    public final c getController() {
        return this.f16303a;
    }

    public final float getCornerRadius() {
        return this.f16306d;
    }

    public final boolean getDraggable() {
        return this.f16304b;
    }

    public final int getGlassAppearance() {
        return this.f16308f;
    }

    public final boolean getGlassEnabled() {
        return this.f16307e;
    }

    public final int getImeBottom() {
        return this.f16312j;
    }

    public final int getNavigationBottom() {
        return this.f16313k;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f16318p.a();
    }

    public final int getSafeEnd() {
        return this.f16311i;
    }

    public final int getSafeStart() {
        return this.f16310h;
    }

    public final int getSafeTop() {
        return this.f16309g;
    }

    @Override // androidx.core.view.InterfaceC0477w
    public void j(View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
        k.g(view, "target");
        k.g(iArr, "consumed");
        if (getAcceptsDrag() && view == this.f16327y && i9 == 0 && i8 < 0) {
            iArr[1] = iArr[1] + C0848a.a(-this.f16303a.f(-i8, this.f16319q, this.f16305c));
        }
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void k(View view, int i5, int i6, int i7, int i8, int i9) {
        k.g(view, "target");
        j(view, i5, i6, i7, i8, i9, new int[2]);
    }

    @Override // androidx.core.view.InterfaceC0476v
    public boolean l(View view, View view2, int i5, int i6) {
        k.g(view, "child");
        k.g(view2, "target");
        return getAcceptsDrag() && i6 == 0 && (i5 & 2) != 0;
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void m(View view, View view2, int i5, int i6) {
        k.g(view, "child");
        k.g(view2, "target");
        this.f16318p.c(view, view2, i5, i6);
        this.f16327y = view2;
        this.f16328z = false;
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void n(View view, int i5) {
        k.g(view, "target");
        this.f16318p.e(view, i5);
        if (view == this.f16327y && i5 == 0) {
            this.f16327y = null;
            if (!getAcceptsDrag() || this.f16328z) {
                return;
            }
            this.f16303a.m(0.0f, this.f16317o.getScaledMinimumFlingVelocity(), this.f16305c);
        }
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void o(View view, int i5, int i6, int[] iArr, int i7) {
        k.g(view, "target");
        k.g(iArr, "consumed");
        if (getAcceptsDrag() && view == this.f16327y && i7 == 0) {
            if ((i6 <= 0 || this.f16303a.j() <= this.f16303a.g()) && (i6 >= 0 || view.canScrollVertically(-1))) {
                return;
            }
            iArr[1] = iArr[1] + C0848a.a(-this.f16303a.f(-i6, this.f16319q, this.f16305c));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        e();
        this.f16327y = null;
        this.f16326x = null;
        this.f16303a.e();
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0099  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            java.lang.String r0 = "event"
            j4.k.g(r7, r0)
            boolean r0 = r6.getAcceptsDrag()
            r1 = 0
            if (r0 != 0) goto Ld
            return r1
        Ld:
            int r0 = r7.getActionMasked()
            if (r0 == 0) goto La1
            r2 = 1
            if (r0 == r2) goto L99
            r3 = 2
            if (r0 == r3) goto L1e
            r7 = 3
            if (r0 == r7) goto L99
            goto Le7
        L1e:
            int r0 = r6.f16321s
            int r0 = r7.findPointerIndex(r0)
            if (r0 < 0) goto L98
            android.view.View r3 = r6.f16326x
            if (r3 != 0) goto L2b
            goto L98
        L2b:
            float r1 = r7.getY(r0)
            float r3 = r6.f16323u
            float r1 = r1 - r3
            float r3 = r7.getX(r0)
            float r4 = r6.f16322t
            float r3 = r3 - r4
            android.view.View r4 = r6.f16327y
            if (r4 != 0) goto L90
            float r4 = java.lang.Math.abs(r1)
            android.view.ViewConfiguration r5 = r6.f16317o
            int r5 = r5.getScaledTouchSlop()
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L90
            float r4 = java.lang.Math.abs(r1)
            float r3 = java.lang.Math.abs(r3)
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 <= 0) goto L90
            r3 = 0
            int r4 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r4 >= 0) goto L6d
            u3.c r4 = r6.f16303a
            float r4 = r4.j()
            u3.c r5 = r6.f16303a
            float r5 = r5.g()
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L79
        L6d:
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L90
            android.view.View r1 = r6.f16326x
            boolean r1 = r6.b(r1)
            if (r1 != 0) goto L90
        L79:
            r6.f16325w = r2
            float r7 = r7.getY(r0)
            r6.f16324v = r7
            u3.c r7 = r6.f16303a
            r7.c()
            android.view.ViewParent r6 = r6.getParent()
            if (r6 == 0) goto L8f
            r6.requestDisallowInterceptTouchEvent(r2)
        L8f:
            return r2
        L90:
            android.view.VelocityTracker r0 = r6.f16320r
            if (r0 == 0) goto Le7
            r0.addMovement(r7)
            goto Le7
        L98:
            return r1
        L99:
            boolean r7 = r6.f16325w
            if (r7 != 0) goto Le7
            r6.e()
            goto Le7
        La1:
            r6.e()
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r0.addMovement(r7)
            r6.f16320r = r0
            int r0 = r7.getPointerId(r1)
            r6.f16321s = r0
            float r0 = r7.getX()
            r6.f16322t = r0
            float r0 = r7.getY()
            r6.f16323u = r0
            r6.f16324v = r0
            com.stepos.widget.panel.StepOSLiteSheetSurface r0 = r6.getSurface()
            float r2 = r7.getX()
            com.stepos.widget.panel.StepOSLiteSheetSurface r3 = r6.getSurface()
            float r3 = r3.getX()
            float r2 = r2 - r3
            float r7 = r7.getY()
            com.stepos.widget.panel.StepOSLiteSheetSurface r3 = r6.getSurface()
            float r3 = r3.getY()
            float r7 = r7 - r3
            android.view.View r7 = r6.d(r0, r2, r7)
            r6.f16326x = r7
            r6.f16325w = r1
        Le7:
            boolean r6 = r6.f16325w
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.panel.StepOSLiteSheetLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        if (getChildCount() < 2) {
            return;
        }
        getChildAt(0).layout(0, 0, getWidth(), getHeight());
        int iA = this.f16310h + C0848a.a(this.f16319q.b(this.f16303a.j()));
        int iA2 = C0848a.a(this.f16319q.d(this.f16303a.j()));
        getSurface().layout(iA, iA2, getSurface().getMeasuredWidth() + iA, getSurface().getMeasuredHeight() + iA2);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        int size = View.MeasureSpec.getSize(i5);
        int size2 = View.MeasureSpec.getSize(i6);
        setMeasuredDimension(size, size2);
        if (getChildCount() < 2) {
            return;
        }
        this.f16319q = c(size2);
        getChildAt(0).measure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
        int iA = C0848a.a(this.f16319q.b(this.f16303a.j()));
        int iB = l.b(((size - this.f16310h) - this.f16311i) - (iA * 2), 0);
        int iB2 = l.b(C0848a.a(this.f16319q.a(this.f16303a.j())), 0);
        int iA2 = a(iA);
        if (getSurface().getPaddingBottom() != iA2) {
            getSurface().setPaddingRelative(0, 0, 0, iA2);
        }
        getSurface().measure(View.MeasureSpec.makeMeasureSpec(iB, 1073741824), View.MeasureSpec.makeMeasureSpec(iB2, 1073741824));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f5, float f6, boolean z5) {
        k.g(view, "target");
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f5, float f6) {
        k.g(view, "target");
        boolean z5 = false;
        if (getAcceptsDrag() && view == this.f16327y && this.f16303a.i() == 1) {
            if (this.f16303a.j() > this.f16303a.g() || (f6 < 0.0f && !view.canScrollVertically(-1))) {
                z5 = true;
            }
            this.f16303a.m(-f6, this.f16317o.getScaledMinimumFlingVelocity(), this.f16305c);
            this.f16328z = true;
        }
        return z5;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i5, int i6, int[] iArr) {
        k.g(view, "target");
        k.g(iArr, "consumed");
        o(view, i5, i6, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i5, int i6, int i7, int i8) {
        k.g(view, "target");
        k(view, i5, i6, i7, i8, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i5) {
        k.g(view, "child");
        k.g(view2, "target");
        m(view, view2, i5, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i5) {
        k.g(view, "child");
        k.g(view2, "target");
        return l(view, view2, i5, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        k.g(view, "target");
        n(view, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        k.g(motionEvent, "event");
        if (!getAcceptsDrag() || this.f16326x == null) {
            this.f16325w = false;
            e();
            return super.onTouchEvent(motionEvent);
        }
        VelocityTracker velocityTracker = this.f16320r;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            VelocityTracker velocityTracker2 = this.f16320r;
            if (velocityTracker2 != null) {
                velocityTracker2.computeCurrentVelocity(1000, this.f16317o.getScaledMaximumFlingVelocity());
            }
            if (this.f16325w) {
                c cVar = this.f16303a;
                VelocityTracker velocityTracker3 = this.f16320r;
                cVar.m(velocityTracker3 != null ? velocityTracker3.getYVelocity(this.f16321s) : 0.0f, this.f16317o.getScaledMinimumFlingVelocity(), this.f16305c);
            }
            this.f16325w = false;
            e();
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f16321s);
            if (iFindPointerIndex < 0) {
                return false;
            }
            float y5 = motionEvent.getY(iFindPointerIndex);
            if (!this.f16325w && Math.abs(y5 - this.f16323u) > this.f16317o.getScaledTouchSlop()) {
                this.f16325w = true;
                this.f16303a.c();
            }
            if (this.f16325w) {
                this.f16303a.f(y5 - this.f16324v, this.f16319q, this.f16305c);
            }
            this.f16324v = y5;
        } else if (actionMasked == 3) {
            if (this.f16325w) {
                this.f16303a.d();
            }
            this.f16325w = false;
            e();
        } else if (actionMasked == 6 && motionEvent.getPointerId(motionEvent.getActionIndex()) == this.f16321s) {
            int i5 = motionEvent.getActionIndex() == 0 ? 1 : 0;
            this.f16321s = motionEvent.getPointerId(i5);
            float y6 = motionEvent.getY(i5);
            this.f16324v = y6;
            this.f16323u = y6;
            this.f16322t = motionEvent.getX(i5);
            VelocityTracker velocityTracker4 = this.f16320r;
            if (velocityTracker4 != null) {
                velocityTracker4.clear();
            }
        }
        return true;
    }

    public final void setCanDismiss(boolean z5) {
        this.f16305c = z5;
    }

    public final void setCornerRadius(float f5) {
        this.f16306d = f5;
    }

    public final void setDraggable(boolean z5) {
        this.f16304b = z5;
    }

    public final void setGlassAppearance(int i5) {
        this.f16308f = i5;
    }

    public final void setGlassEnabled(boolean z5) {
        this.f16307e = z5;
    }

    public final void setImeBottom(int i5) {
        this.f16312j = i5;
    }

    public final void setNavigationBottom(int i5) {
        this.f16313k = i5;
    }

    public final void setSafeEnd(int i5) {
        this.f16311i = i5;
    }

    public final void setSafeStart(int i5) {
        this.f16310h = i5;
    }

    public final void setSafeTop(int i5) {
        this.f16309g = i5;
    }
}
