package androidx.core.widget;

import E.c;
import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.view.C0456a;
import androidx.core.view.C0460e;
import androidx.core.view.C0473s;
import androidx.core.view.C0475u;
import androidx.core.view.C0478x;
import androidx.core.view.H;
import androidx.core.view.InterfaceC0461f;
import androidx.core.view.InterfaceC0474t;
import androidx.core.view.InterfaceC0477w;
import androidx.recyclerview.widget.ItemTouchHelper;
import z.C1329a;

/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements InterfaceC0477w, InterfaceC0474t {

    /* renamed from: D, reason: collision with root package name */
    private static final float f9832D = (float) (Math.log(0.78d) / Math.log(0.9d));

    /* renamed from: E, reason: collision with root package name */
    private static final a f9833E = new a();

    /* renamed from: F, reason: collision with root package name */
    private static final int[] f9834F = {R.attr.fillViewport};

    /* renamed from: A, reason: collision with root package name */
    private d f9835A;

    /* renamed from: B, reason: collision with root package name */
    final c f9836B;

    /* renamed from: C, reason: collision with root package name */
    C0460e f9837C;

    /* renamed from: a, reason: collision with root package name */
    private final float f9838a;

    /* renamed from: b, reason: collision with root package name */
    private long f9839b;

    /* renamed from: c, reason: collision with root package name */
    private final Rect f9840c;

    /* renamed from: d, reason: collision with root package name */
    private OverScroller f9841d;

    /* renamed from: e, reason: collision with root package name */
    public EdgeEffect f9842e;

    /* renamed from: f, reason: collision with root package name */
    public EdgeEffect f9843f;

    /* renamed from: g, reason: collision with root package name */
    private int f9844g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f9845h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f9846i;

    /* renamed from: j, reason: collision with root package name */
    private View f9847j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f9848k;

    /* renamed from: l, reason: collision with root package name */
    private VelocityTracker f9849l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f9850m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f9851n;

    /* renamed from: o, reason: collision with root package name */
    private int f9852o;

    /* renamed from: p, reason: collision with root package name */
    private int f9853p;

    /* renamed from: q, reason: collision with root package name */
    private int f9854q;

    /* renamed from: r, reason: collision with root package name */
    private int f9855r;

    /* renamed from: s, reason: collision with root package name */
    private final int[] f9856s;

    /* renamed from: t, reason: collision with root package name */
    private final int[] f9857t;

    /* renamed from: u, reason: collision with root package name */
    private int f9858u;

    /* renamed from: v, reason: collision with root package name */
    private int f9859v;

    /* renamed from: w, reason: collision with root package name */
    private e f9860w;

    /* renamed from: x, reason: collision with root package name */
    private final C0478x f9861x;

    /* renamed from: y, reason: collision with root package name */
    private final C0475u f9862y;

    /* renamed from: z, reason: collision with root package name */
    private float f9863z;

    static class a extends C0456a {
        a() {
        }

        @Override // androidx.core.view.C0456a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            E.e.d(accessibilityEvent, nestedScrollView.getScrollX());
            E.e.e(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // androidx.core.view.C0456a
        public void onInitializeAccessibilityNodeInfo(View view, E.c cVar) {
            int scrollRange;
            super.onInitializeAccessibilityNodeInfo(view, cVar);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            cVar.d0(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            cVar.w0(true);
            if (nestedScrollView.getScrollY() > 0) {
                cVar.b(c.a.f1259r);
                cVar.b(c.a.f1226C);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                cVar.b(c.a.f1258q);
                cVar.b(c.a.f1228E);
            }
        }

        @Override // androidx.core.view.C0456a
        public boolean performAccessibilityAction(View view, int i5, Bundle bundle) {
            if (super.performAccessibilityAction(view, i5, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i5 != 4096) {
                if (i5 == 8192 || i5 == 16908344) {
                    int iMax = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (iMax == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.W(0, iMax, true);
                    return true;
                }
                if (i5 != 16908346) {
                    return false;
                }
            }
            int iMin = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (iMin == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.W(0, iMin, true);
            return true;
        }
    }

    static class b {
        static boolean a(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    class c implements InterfaceC0461f {
        c() {
        }

        @Override // androidx.core.view.InterfaceC0461f
        public boolean a(float f5) {
            if (f5 == 0.0f) {
                return false;
            }
            c();
            NestedScrollView.this.v((int) f5);
            return true;
        }

        @Override // androidx.core.view.InterfaceC0461f
        public float b() {
            return -NestedScrollView.this.getVerticalScrollFactorCompat();
        }

        @Override // androidx.core.view.InterfaceC0461f
        public void c() {
            NestedScrollView.this.f9841d.abortAnimation();
        }
    }

    public interface d {
        void a(NestedScrollView nestedScrollView, int i5, int i6, int i7, int i8);
    }

    static class e extends View.BaseSavedState {
        public static final Parcelable.Creator<e> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public int f9865a;

        class a implements Parcelable.Creator<e> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public e[] newArray(int i5) {
                return new e[i5];
            }
        }

        e(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f9865a + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.f9865a);
        }

        e(Parcel parcel) {
            super(parcel);
            this.f9865a = parcel.readInt();
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1329a.f23937c);
    }

    private void A() {
        VelocityTracker velocityTracker = this.f9849l;
        if (velocityTracker == null) {
            this.f9849l = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void B() {
        this.f9841d = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f9852o = viewConfiguration.getScaledTouchSlop();
        this.f9853p = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f9854q = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void C() {
        if (this.f9849l == null) {
            this.f9849l = VelocityTracker.obtain();
        }
    }

    private void D(int i5, int i6) {
        this.f9844g = i5;
        this.f9855r = i6;
        X(2, 0);
    }

    private boolean E(View view) {
        return !G(view, 0, getHeight());
    }

    private static boolean F(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && F((View) parent, view2);
    }

    private boolean G(View view, int i5, int i6) {
        view.getDrawingRect(this.f9840c);
        offsetDescendantRectToMyCoords(view, this.f9840c);
        return this.f9840c.bottom + i5 >= getScrollY() && this.f9840c.top - i5 <= getScrollY() + i6;
    }

    private void H(int i5, int i6, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i5);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.f9862y.e(0, scrollY2, 0, i5 - scrollY2, null, i6, iArr);
    }

    private void I(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f9855r) {
            int i5 = actionIndex == 0 ? 1 : 0;
            this.f9844g = (int) motionEvent.getY(i5);
            this.f9855r = motionEvent.getPointerId(i5);
            VelocityTracker velocityTracker = this.f9849l;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void L() {
        VelocityTracker velocityTracker = this.f9849l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f9849l = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int M(int r4, float r5) {
        /*
            r3 = this;
            int r0 = r3.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r4 = (float) r4
            int r0 = r3.getHeight()
            float r0 = (float) r0
            float r4 = r4 / r0
            android.widget.EdgeEffect r0 = r3.f9842e
            float r0 = androidx.core.widget.d.b(r0)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L31
            android.widget.EdgeEffect r0 = r3.f9842e
            float r4 = -r4
            float r4 = androidx.core.widget.d.d(r0, r4, r5)
            float r4 = -r4
            android.widget.EdgeEffect r5 = r3.f9842e
            float r5 = androidx.core.widget.d.b(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L2f
            android.widget.EdgeEffect r5 = r3.f9842e
            r5.onRelease()
        L2f:
            r1 = r4
            goto L54
        L31:
            android.widget.EdgeEffect r0 = r3.f9843f
            float r0 = androidx.core.widget.d.b(r0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L54
            android.widget.EdgeEffect r0 = r3.f9843f
            r2 = 1065353216(0x3f800000, float:1.0)
            float r2 = r2 - r5
            float r4 = androidx.core.widget.d.d(r0, r4, r2)
            android.widget.EdgeEffect r5 = r3.f9843f
            float r5 = androidx.core.widget.d.b(r5)
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 != 0) goto L2f
            android.widget.EdgeEffect r5 = r3.f9843f
            r5.onRelease()
            goto L2f
        L54:
            int r4 = r3.getHeight()
            float r4 = (float) r4
            float r1 = r1 * r4
            int r4 = java.lang.Math.round(r1)
            if (r4 == 0) goto L63
            r3.invalidate()
        L63:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.M(int, float):int");
    }

    private void N(boolean z5) {
        if (z5) {
            X(2, 1);
        } else {
            Z(1);
        }
        this.f9859v = getScrollY();
        postInvalidateOnAnimation();
    }

    private boolean O(int i5, int i6, int i7) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i8 = height + scrollY;
        boolean z5 = false;
        boolean z6 = i5 == 33;
        View viewU = u(z6, i6, i7);
        if (viewU == null) {
            viewU = this;
        }
        if (i6 < scrollY || i7 > i8) {
            P(z6 ? i6 - scrollY : i7 - i8, 0, 1, true);
            z5 = true;
        }
        if (viewU != findFocus()) {
            viewU.requestFocus(i5);
        }
        return z5;
    }

    private int P(int i5, int i6, int i7, boolean z5) {
        int i8;
        int i9;
        VelocityTracker velocityTracker;
        if (i7 == 1) {
            X(2, i7);
        }
        boolean z6 = false;
        if (i(0, i5, this.f9857t, this.f9856s, i7)) {
            int i10 = i5 - this.f9857t[1];
            i9 = this.f9856s[1];
            i8 = i10;
        } else {
            i8 = i5;
            i9 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        boolean z7 = d() && !z5;
        int i11 = i8;
        boolean z8 = J(0, i8, 0, scrollY, 0, scrollRange, 0, 0, true) && !y(i7);
        int scrollY2 = getScrollY() - scrollY;
        int[] iArr = this.f9857t;
        iArr[1] = 0;
        p(0, scrollY2, 0, i11 - scrollY2, this.f9856s, i7, iArr);
        int i12 = i9 + this.f9856s[1];
        int i13 = i11 - this.f9857t[1];
        int i14 = scrollY + i13;
        if (i14 < 0) {
            if (z7) {
                androidx.core.widget.d.d(this.f9842e, (-i13) / getHeight(), i6 / getWidth());
                if (!this.f9843f.isFinished()) {
                    this.f9843f.onRelease();
                }
            }
        } else if (i14 > scrollRange && z7) {
            androidx.core.widget.d.d(this.f9843f, i13 / getHeight(), 1.0f - (i6 / getWidth()));
            if (!this.f9842e.isFinished()) {
                this.f9842e.onRelease();
            }
        }
        if (this.f9842e.isFinished() && this.f9843f.isFinished()) {
            z6 = z8;
        } else {
            postInvalidateOnAnimation();
        }
        if (z6 && i7 == 0 && (velocityTracker = this.f9849l) != null) {
            velocityTracker.clear();
        }
        if (i7 == 1) {
            Z(i7);
            this.f9842e.onRelease();
            this.f9843f.onRelease();
        }
        return i12;
    }

    private void Q(View view) {
        view.getDrawingRect(this.f9840c);
        offsetDescendantRectToMyCoords(view, this.f9840c);
        int iG = g(this.f9840c);
        if (iG != 0) {
            scrollBy(0, iG);
        }
    }

    private boolean R(Rect rect, boolean z5) {
        int iG = g(rect);
        boolean z6 = iG != 0;
        if (z6) {
            if (z5) {
                scrollBy(0, iG);
                return z6;
            }
            T(0, iG);
        }
        return z6;
    }

    private boolean S(EdgeEffect edgeEffect, int i5) {
        if (i5 > 0) {
            return true;
        }
        return x(-i5) < androidx.core.widget.d.b(edgeEffect) * ((float) getHeight());
    }

    private void U(int i5, int i6, int i7, boolean z5) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.f9839b > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.f9841d.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i6 + scrollY, Math.max(0, height - height2))) - scrollY, i7);
            N(z5);
        } else {
            if (!this.f9841d.isFinished()) {
                a();
            }
            scrollBy(i5, i6);
        }
        this.f9839b = AnimationUtils.currentAnimationTimeMillis();
    }

    private boolean Y(MotionEvent motionEvent) {
        boolean z5;
        if (androidx.core.widget.d.b(this.f9842e) != 0.0f) {
            androidx.core.widget.d.d(this.f9842e, 0.0f, motionEvent.getX() / getWidth());
            z5 = true;
        } else {
            z5 = false;
        }
        if (androidx.core.widget.d.b(this.f9843f) == 0.0f) {
            return z5;
        }
        androidx.core.widget.d.d(this.f9843f, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    private void a() {
        this.f9841d.abortAnimation();
        Z(1);
    }

    private boolean d() {
        int overScrollMode = getOverScrollMode();
        return overScrollMode == 0 || (overScrollMode == 1 && getScrollRange() > 0);
    }

    private boolean e() {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            if (childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom()) {
                return true;
            }
        }
        return false;
    }

    private static int f(int i5, int i6, int i7) {
        if (i6 >= i7 || i5 < 0) {
            return 0;
        }
        return i6 + i5 > i7 ? i7 - i6 : i5;
    }

    private void q(int i5) {
        if (i5 != 0) {
            if (this.f9851n) {
                T(0, i5);
            } else {
                scrollBy(0, i5);
            }
        }
    }

    private boolean r(int i5) {
        if (androidx.core.widget.d.b(this.f9842e) != 0.0f) {
            if (S(this.f9842e, i5)) {
                this.f9842e.onAbsorb(i5);
                return true;
            }
            v(-i5);
            return true;
        }
        if (androidx.core.widget.d.b(this.f9843f) == 0.0f) {
            return false;
        }
        int i6 = -i5;
        if (S(this.f9843f, i6)) {
            this.f9843f.onAbsorb(i6);
            return true;
        }
        v(i6);
        return true;
    }

    private void s() {
        this.f9855r = -1;
        this.f9848k = false;
        L();
        Z(0);
        this.f9842e.onRelease();
        this.f9843f.onRelease();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private android.view.View u(boolean r12, int r13, int r14) {
        /*
            r11 = this;
            r0 = 2
            java.util.ArrayList r11 = r11.getFocusables(r0)
            int r0 = r11.size()
            r1 = 0
            r2 = 0
            r3 = r2
            r4 = r3
        Ld:
            if (r3 >= r0) goto L53
            java.lang.Object r5 = r11.get(r3)
            android.view.View r5 = (android.view.View) r5
            int r6 = r5.getTop()
            int r7 = r5.getBottom()
            if (r13 >= r7) goto L50
            if (r6 >= r14) goto L50
            r8 = 1
            if (r13 >= r6) goto L28
            if (r7 >= r14) goto L28
            r9 = r8
            goto L29
        L28:
            r9 = r2
        L29:
            if (r1 != 0) goto L2e
            r1 = r5
            r4 = r9
            goto L50
        L2e:
            if (r12 == 0) goto L36
            int r10 = r1.getTop()
            if (r6 < r10) goto L3e
        L36:
            if (r12 != 0) goto L40
            int r6 = r1.getBottom()
            if (r7 <= r6) goto L40
        L3e:
            r6 = r8
            goto L41
        L40:
            r6 = r2
        L41:
            if (r4 == 0) goto L48
            if (r9 == 0) goto L50
            if (r6 == 0) goto L50
            goto L4f
        L48:
            if (r9 == 0) goto L4d
            r1 = r5
            r4 = r8
            goto L50
        L4d:
            if (r6 == 0) goto L50
        L4f:
            r1 = r5
        L50:
            int r3 = r3 + 1
            goto Ld
        L53:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.u(boolean, int, int):android.view.View");
    }

    private float x(int i5) {
        double dLog = Math.log((Math.abs(i5) * 0.35f) / (this.f9838a * 0.015f));
        float f5 = f9832D;
        return (float) (this.f9838a * 0.015f * Math.exp((f5 / (f5 - 1.0d)) * dLog));
    }

    private boolean z(int i5, int i6) {
        if (getChildCount() > 0) {
            int scrollY = getScrollY();
            View childAt = getChildAt(0);
            if (i6 >= childAt.getTop() - scrollY && i6 < childAt.getBottom() - scrollY && i5 >= childAt.getLeft() && i5 < childAt.getRight()) {
                return true;
            }
        }
        return false;
    }

    boolean J(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, boolean z5) {
        boolean z6;
        boolean z7;
        int i13;
        int overScrollMode = getOverScrollMode();
        boolean z8 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z9 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z10 = overScrollMode == 0 || (overScrollMode == 1 && z8);
        boolean z11 = overScrollMode == 0 || (overScrollMode == 1 && z9);
        int i14 = i7 + i5;
        int i15 = !z10 ? 0 : i11;
        int i16 = i8 + i6;
        int i17 = !z11 ? 0 : i12;
        int i18 = -i15;
        int i19 = i15 + i9;
        int i20 = -i17;
        int i21 = i17 + i10;
        if (i14 > i19) {
            i14 = i19;
            z6 = true;
        } else if (i14 < i18) {
            z6 = true;
            i14 = i18;
        } else {
            z6 = false;
        }
        if (i16 > i21) {
            i16 = i21;
            z7 = true;
        } else if (i16 < i20) {
            z7 = true;
            i16 = i20;
        } else {
            z7 = false;
        }
        if (!z7 || y(1)) {
            i13 = i14;
        } else {
            int i22 = i14;
            this.f9841d.springBack(i22, i16, 0, 0, 0, getScrollRange());
            i13 = i22;
        }
        onOverScrolled(i13, i16, z6, z7);
        return z6 || z7;
    }

    public boolean K(int i5) {
        boolean z5 = i5 == 130;
        int height = getHeight();
        if (z5) {
            this.f9840c.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.f9840c;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.f9840c.top = getScrollY() - height;
            Rect rect2 = this.f9840c;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.f9840c;
        int i6 = rect3.top;
        int i7 = height + i6;
        rect3.bottom = i7;
        return O(i5, i6, i7);
    }

    public final void T(int i5, int i6) {
        U(i5, i6, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, false);
    }

    void V(int i5, int i6, int i7, boolean z5) {
        U(i5 - getScrollX(), i6 - getScrollY(), i7, z5);
    }

    void W(int i5, int i6, boolean z5) {
        V(i5, i6, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, z5);
    }

    public boolean X(int i5, int i6) {
        return this.f9862y.q(i5, i6);
    }

    public void Z(int i5) {
        this.f9862y.s(i5);
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public boolean c(int i5) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i5);
        int maxScrollAmount = getMaxScrollAmount();
        if (viewFindNextFocus == null || !G(viewFindNextFocus, maxScrollAmount, getHeight())) {
            if (i5 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i5 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i5 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            P(maxScrollAmount, 0, 1, true);
        } else {
            viewFindNextFocus.getDrawingRect(this.f9840c);
            offsetDescendantRectToMyCoords(viewFindNextFocus, this.f9840c);
            P(g(this.f9840c), 0, 1, true);
            viewFindNextFocus.requestFocus(i5);
        }
        if (viewFindFocus != null && viewFindFocus.isFocused() && E(viewFindFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        int i5;
        if (this.f9841d.isFinished()) {
            return;
        }
        this.f9841d.computeScrollOffset();
        int currY = this.f9841d.getCurrY();
        int iH = h(currY - this.f9859v);
        this.f9859v = currY;
        int[] iArr = this.f9857t;
        iArr[1] = 0;
        i(0, iH, iArr, null, 1);
        int i6 = iH - this.f9857t[1];
        int scrollRange = getScrollRange();
        if (i6 != 0) {
            int scrollY = getScrollY();
            J(0, i6, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            i5 = scrollRange;
            int scrollY2 = getScrollY() - scrollY;
            int i7 = i6 - scrollY2;
            int[] iArr2 = this.f9857t;
            iArr2[1] = 0;
            p(0, scrollY2, 0, i7, this.f9856s, 1, iArr2);
            i6 = i7 - this.f9857t[1];
        } else {
            i5 = scrollRange;
        }
        if (i6 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && i5 > 0)) {
                if (i6 < 0) {
                    if (this.f9842e.isFinished()) {
                        this.f9842e.onAbsorb((int) this.f9841d.getCurrVelocity());
                    }
                } else if (this.f9843f.isFinished()) {
                    this.f9843f.onAbsorb((int) this.f9841d.getCurrVelocity());
                }
            }
            a();
        }
        if (this.f9841d.isFinished()) {
            Z(1);
        } else {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int iMax = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > iMax ? bottom + (scrollY - iMax) : bottom;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || t(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f5, float f6, boolean z5) {
        return this.f9862y.a(f5, f6, z5);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f5, float f6) {
        return this.f9862y.b(f5, f6);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i5, int i6, int[] iArr, int[] iArr2) {
        return i(i5, i6, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i5, int i6, int i7, int i8, int[] iArr) {
        return this.f9862y.f(i5, i6, i7, i8, iArr);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int paddingLeft;
        super.draw(canvas);
        int scrollY = getScrollY();
        int paddingLeft2 = 0;
        if (!this.f9842e.isFinished()) {
            int iSave = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int iMin = Math.min(0, scrollY);
            if (b.a(this)) {
                width -= getPaddingLeft() + getPaddingRight();
                paddingLeft = getPaddingLeft();
            } else {
                paddingLeft = 0;
            }
            if (b.a(this)) {
                height -= getPaddingTop() + getPaddingBottom();
                iMin += getPaddingTop();
            }
            canvas.translate(paddingLeft, iMin);
            this.f9842e.setSize(width, height);
            if (this.f9842e.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(iSave);
        }
        if (this.f9843f.isFinished()) {
            return;
        }
        int iSave2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int iMax = Math.max(getScrollRange(), scrollY) + height2;
        if (b.a(this)) {
            width2 -= getPaddingLeft() + getPaddingRight();
            paddingLeft2 = getPaddingLeft();
        }
        if (b.a(this)) {
            height2 -= getPaddingTop() + getPaddingBottom();
            iMax -= getPaddingBottom();
        }
        canvas.translate(paddingLeft2 - width2, iMax);
        canvas.rotate(180.0f, width2, 0.0f);
        this.f9843f.setSize(width2, height2);
        if (this.f9843f.draw(canvas)) {
            postInvalidateOnAnimation();
        }
        canvas.restoreToCount(iSave2);
    }

    protected int g(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i5 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i6 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i5 - verticalFadingEdgeLength : i5;
        int i7 = rect.bottom;
        if (i7 > i6 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i6, (childAt.getBottom() + layoutParams.bottomMargin) - i5);
        }
        if (rect.top >= scrollY || i7 >= i6) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i6 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f9861x.a();
    }

    int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    float getVerticalScrollFactorCompat() {
        if (this.f9863z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.f9863z = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.f9863z;
    }

    int h(int i5) {
        int height = getHeight();
        if (i5 > 0 && androidx.core.widget.d.b(this.f9842e) != 0.0f) {
            int iRound = Math.round(((-height) / 4.0f) * androidx.core.widget.d.d(this.f9842e, ((-i5) * 4.0f) / height, 0.5f));
            if (iRound != i5) {
                this.f9842e.finish();
            }
            return i5 - iRound;
        }
        if (i5 >= 0 || androidx.core.widget.d.b(this.f9843f) == 0.0f) {
            return i5;
        }
        float f5 = height;
        int iRound2 = Math.round((f5 / 4.0f) * androidx.core.widget.d.d(this.f9843f, (i5 * 4.0f) / f5, 0.5f));
        if (iRound2 != i5) {
            this.f9843f.finish();
        }
        return i5 - iRound2;
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return y(0);
    }

    public boolean i(int i5, int i6, int[] iArr, int[] iArr2, int i7) {
        return this.f9862y.d(i5, i6, iArr, iArr2, i7);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.f9862y.m();
    }

    @Override // androidx.core.view.InterfaceC0477w
    public void j(View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
        H(i8, i9, iArr);
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void k(View view, int i5, int i6, int i7, int i8, int i9) {
        H(i8, i9, null);
    }

    @Override // androidx.core.view.InterfaceC0476v
    public boolean l(View view, View view2, int i5, int i6) {
        return (i5 & 2) != 0;
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void m(View view, View view2, int i5, int i6) {
        this.f9861x.c(view, view2, i5, i6);
        X(2, i6);
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i5, int i6) {
        view.measure(ViewGroup.getChildMeasureSpec(i5, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i5, int i6, int i7, int i8) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i5, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i6, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void n(View view, int i5) {
        this.f9861x.e(view, i5);
        Z(i5);
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void o(View view, int i5, int i6, int[] iArr, int i7) {
        i(i5, i6, iArr, null, i7);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f9846i = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        int i5;
        int width;
        float axisValue;
        if (motionEvent.getAction() == 8 && !this.f9848k) {
            if (C0473s.h(motionEvent, 2)) {
                i5 = 9;
                axisValue = motionEvent.getAxisValue(9);
                width = (int) motionEvent.getX();
            } else if (C0473s.h(motionEvent, 4194304)) {
                float axisValue2 = motionEvent.getAxisValue(26);
                width = getWidth() / 2;
                i5 = 26;
                axisValue = axisValue2;
            } else {
                i5 = 0;
                width = 0;
                axisValue = 0.0f;
            }
            if (axisValue != 0.0f) {
                P(-((int) (axisValue * getVerticalScrollFactorCompat())), width, 1, C0473s.h(motionEvent, 8194));
                if (i5 != 0) {
                    this.f9837C.g(motionEvent, i5);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007e  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r12) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.NestedScrollView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
        int measuredHeight = 0;
        this.f9845h = false;
        View view = this.f9847j;
        if (view != null && F(view, this)) {
            Q(this.f9847j);
        }
        this.f9847j = null;
        if (!this.f9846i) {
            if (this.f9860w != null) {
                scrollTo(getScrollX(), this.f9860w.f9865a);
                this.f9860w = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                measuredHeight = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i8 - i6) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int iF = f(scrollY, paddingTop, measuredHeight);
            if (iF != scrollY) {
                scrollTo(getScrollX(), iF);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f9846i = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        if (this.f9850m && View.MeasureSpec.getMode(i6) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i5, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f5, float f6, boolean z5) {
        if (z5) {
            return false;
        }
        dispatchNestedFling(0.0f, f6, true);
        v((int) f6);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f5, float f6) {
        return dispatchNestedPreFling(f5, f6);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i5, int i6, int[] iArr) {
        o(view, i5, i6, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i5, int i6, int i7, int i8) {
        H(i8, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i5) {
        m(view, view2, i5, 0);
    }

    @Override // android.view.View
    protected void onOverScrolled(int i5, int i6, boolean z5, boolean z6) {
        super.scrollTo(i5, i6);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i5, Rect rect) {
        if (i5 == 2) {
            i5 = 130;
        } else if (i5 == 1) {
            i5 = 33;
        }
        View viewFindNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i5) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i5);
        if (viewFindNextFocus == null || E(viewFindNextFocus)) {
            return false;
        }
        return viewFindNextFocus.requestFocus(i5, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        this.f9860w = eVar;
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        eVar.f9865a = getScrollY();
        return eVar;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i5, int i6, int i7, int i8) {
        super.onScrollChanged(i5, i6, i7, i8);
        d dVar = this.f9835A;
        if (dVar != null) {
            dVar.a(this, i5, i6, i7, i8);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        View viewFindFocus = findFocus();
        if (viewFindFocus == null || this == viewFindFocus || !G(viewFindFocus, 0, i8)) {
            return;
        }
        viewFindFocus.getDrawingRect(this.f9840c);
        offsetDescendantRectToMyCoords(viewFindFocus, this.f9840c);
        q(g(this.f9840c));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i5) {
        return l(view, view2, i5, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        n(view, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        C();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f9858u = 0;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.offsetLocation(0.0f, this.f9858u);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.f9849l;
                velocityTracker.computeCurrentVelocity(1000, this.f9854q);
                int yVelocity = (int) velocityTracker.getYVelocity(this.f9855r);
                if (Math.abs(yVelocity) >= this.f9853p) {
                    if (!r(yVelocity)) {
                        int i5 = -yVelocity;
                        float f5 = i5;
                        if (!dispatchNestedPreFling(0.0f, f5)) {
                            dispatchNestedFling(0.0f, f5, true);
                            v(i5);
                        }
                    }
                } else if (this.f9841d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                s();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f9855r);
                if (iFindPointerIndex == -1) {
                    Log.e("NestedScrollView", "Invalid pointerId=" + this.f9855r + " in onTouchEvent");
                } else {
                    int y5 = (int) motionEvent.getY(iFindPointerIndex);
                    int i6 = this.f9844g - y5;
                    int iM = i6 - M(i6, motionEvent.getX(iFindPointerIndex));
                    if (!this.f9848k && Math.abs(iM) > this.f9852o) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f9848k = true;
                        iM = iM > 0 ? iM - this.f9852o : iM + this.f9852o;
                    }
                    if (this.f9848k) {
                        int iP = P(iM, (int) motionEvent.getX(iFindPointerIndex), 0, false);
                        this.f9844g = y5 - iP;
                        this.f9858u += iP;
                    }
                }
            } else if (actionMasked == 3) {
                if (this.f9848k && getChildCount() > 0 && this.f9841d.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                s();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.f9844g = (int) motionEvent.getY(actionIndex);
                this.f9855r = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                I(motionEvent);
                this.f9844g = (int) motionEvent.getY(motionEvent.findPointerIndex(this.f9855r));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            if (this.f9848k && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.f9841d.isFinished()) {
                a();
            }
            D((int) motionEvent.getY(), motionEvent.getPointerId(0));
        }
        VelocityTracker velocityTracker2 = this.f9849l;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEventObtain);
        }
        motionEventObtain.recycle();
        return true;
    }

    public void p(int i5, int i6, int i7, int i8, int[] iArr, int i9, int[] iArr2) {
        this.f9862y.e(i5, i6, i7, i8, iArr, i9, iArr2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.f9845h) {
            this.f9847j = view2;
        } else {
            Q(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z5) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return R(rect, z5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z5) {
        if (z5) {
            L();
        }
        super.requestDisallowInterceptTouchEvent(z5);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f9845h = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public void scrollTo(int i5, int i6) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int iF = f(i5, width, width2);
            int iF2 = f(i6, height, height2);
            if (iF == getScrollX() && iF2 == getScrollY()) {
                return;
            }
            super.scrollTo(iF, iF2);
        }
    }

    public void setFillViewport(boolean z5) {
        if (z5 != this.f9850m) {
            this.f9850m = z5;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z5) {
        this.f9862y.n(z5);
    }

    public void setOnScrollChangeListener(d dVar) {
        this.f9835A = dVar;
    }

    public void setSmoothScrollingEnabled(boolean z5) {
        this.f9851n = z5;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i5) {
        return X(i5, 0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        Z(0);
    }

    public boolean t(KeyEvent keyEvent) {
        this.f9840c.setEmpty();
        if (!e()) {
            if (isFocused() && keyEvent.getKeyCode() != 4) {
                View viewFindFocus = findFocus();
                if (viewFindFocus == this) {
                    viewFindFocus = null;
                }
                View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, 130);
                if (viewFindNextFocus != null && viewFindNextFocus != this && viewFindNextFocus.requestFocus(130)) {
                    return true;
                }
            }
            return false;
        }
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 19) {
                return keyEvent.isAltPressed() ? w(33) : c(33);
            }
            if (keyCode == 20) {
                return keyEvent.isAltPressed() ? w(130) : c(130);
            }
            if (keyCode == 62) {
                K(keyEvent.isShiftPressed() ? 33 : 130);
                return false;
            }
            if (keyCode == 92) {
                return w(33);
            }
            if (keyCode == 93) {
                return w(130);
            }
            if (keyCode == 122) {
                K(33);
                return false;
            }
            if (keyCode == 123) {
                K(130);
                return false;
            }
        }
        return false;
    }

    public void v(int i5) {
        if (getChildCount() > 0) {
            this.f9841d.fling(getScrollX(), getScrollY(), 0, i5, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            N(true);
        }
    }

    public boolean w(int i5) {
        int childCount;
        boolean z5 = i5 == 130;
        int height = getHeight();
        Rect rect = this.f9840c;
        rect.top = 0;
        rect.bottom = height;
        if (z5 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.f9840c.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.f9840c;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.f9840c;
        return O(i5, rect3.top, rect3.bottom);
    }

    public boolean y(int i5) {
        return this.f9862y.l(i5);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f9840c = new Rect();
        this.f9845h = true;
        this.f9846i = false;
        this.f9847j = null;
        this.f9848k = false;
        this.f9851n = true;
        this.f9855r = -1;
        this.f9856s = new int[2];
        this.f9857t = new int[2];
        c cVar = new c();
        this.f9836B = cVar;
        this.f9837C = new C0460e(getContext(), cVar);
        this.f9842e = androidx.core.widget.d.a(context, attributeSet);
        this.f9843f = androidx.core.widget.d.a(context, attributeSet);
        this.f9838a = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        B();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f9834F, i5, 0);
        setFillViewport(typedArrayObtainStyledAttributes.getBoolean(0, false));
        typedArrayObtainStyledAttributes.recycle();
        this.f9861x = new C0478x(this);
        this.f9862y = new C0475u(this);
        setNestedScrollingEnabled(true);
        H.k0(this, f9833E);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i5) {
        if (getChildCount() <= 0) {
            super.addView(view, i5);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i5, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
