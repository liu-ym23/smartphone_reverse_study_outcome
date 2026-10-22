package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.emoji2.text.p;
import androidx.fragment.app.b;
import com.stepos.stepclaw.SecurePrefs;
import e0.a0;
import e0.g;
import i0.d;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import p1.m;
import t6.a;
import v0.b0;
import v0.c0;
import v0.d0;
import v0.e0;
import v0.f0;
import v0.g0;
import v0.h0;
import v0.i0;
import v0.j;
import v0.j0;
import v0.k0;
import v0.l;
import v0.l0;
import v0.m0;
import v0.n0;
import v0.p0;
import v0.u;
import v0.u0;
import v0.v;
import v0.w;
import v0.x;
import v0.y;
import v0.z;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class RecyclerView extends ViewGroup {

    /* renamed from: l0, reason: collision with root package name */
    public static final int[] f755l0 = {R.attr.nestedScrollingEnabled};

    /* renamed from: m0, reason: collision with root package name */
    public static final Class[] f756m0;

    /* renamed from: n0, reason: collision with root package name */
    public static final d f757n0;
    public final int A;
    public x B;
    public EdgeEffect C;
    public EdgeEffect D;
    public EdgeEffect E;
    public EdgeEffect F;
    public y G;
    public int H;
    public int I;
    public VelocityTracker J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public final int P;
    public final int Q;
    public final float R;
    public final float S;
    public boolean T;
    public final m0 U;
    public l V;
    public final m W;

    /* renamed from: a, reason: collision with root package name */
    public final h0 f758a;

    /* renamed from: a0, reason: collision with root package name */
    public final k0 f759a0;

    /* renamed from: b, reason: collision with root package name */
    public j0 f760b;

    /* renamed from: b0, reason: collision with root package name */
    public e0 f761b0;

    /* renamed from: c, reason: collision with root package name */
    public final a4.d f762c;

    /* renamed from: c0, reason: collision with root package name */
    public ArrayList f763c0;
    public final a4.d d;

    /* renamed from: d0, reason: collision with root package name */
    public final u f764d0;

    /* renamed from: e, reason: collision with root package name */
    public final p f765e;

    /* renamed from: e0, reason: collision with root package name */
    public p0 f766e0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f767f;

    /* renamed from: f0, reason: collision with root package name */
    public g f768f0;

    /* renamed from: g, reason: collision with root package name */
    public final Rect f769g;

    /* renamed from: g0, reason: collision with root package name */
    public final int[] f770g0;

    /* renamed from: h, reason: collision with root package name */
    public final Rect f771h;

    /* renamed from: h0, reason: collision with root package name */
    public final int[] f772h0;

    /* renamed from: i0, reason: collision with root package name */
    public final int[] f773i0;

    /* renamed from: j, reason: collision with root package name */
    public final RectF f774j;

    /* renamed from: j0, reason: collision with root package name */
    public final ArrayList f775j0;

    /* renamed from: k, reason: collision with root package name */
    public b0 f776k;
    public final b k0;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f777l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f778m;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayList f779n;

    /* renamed from: o, reason: collision with root package name */
    public j f780o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f781p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f782q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f783r;

    /* renamed from: s, reason: collision with root package name */
    public int f784s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f785t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f786u;

    /* renamed from: v, reason: collision with root package name */
    public int f787v;

    /* renamed from: w, reason: collision with root package name */
    public final AccessibilityManager f788w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f789x;
    public boolean y;
    public int z;

    static {
        Class cls = Integer.TYPE;
        f756m0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        f757n0 = new d(1);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.stepos.stepclaw.R.attr.recyclerViewStyle);
    }

    public static void e(n0 n0Var) {
        WeakReference weakReference = n0Var.f5893a;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            n0Var.f5893a = null;
        }
    }

    private g getScrollingChildHelper() {
        if (this.f768f0 == null) {
            this.f768f0 = new g(this);
        }
        return this.f768f0;
    }

    public static n0 s(View view) {
        if (view == null) {
            return null;
        }
        ((c0) view.getLayoutParams()).getClass();
        return null;
    }

    public final void A(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        int width = view3.getWidth();
        int height = view3.getHeight();
        Rect rect = this.f769g;
        rect.set(0, 0, width, height);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof c0) {
            c0 c0Var = (c0) layoutParams;
            if (!c0Var.f5805b) {
                Rect rect2 = c0Var.f5804a;
                rect.left -= rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, rect);
            offsetRectIntoDescendantCoords(view, rect);
        }
        this.f776k.V(this, view, this.f769g, !this.f783r, view2 == null);
    }

    public final void B() {
        VelocityTracker velocityTracker = this.J;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean zIsFinished = false;
        H(0);
        EdgeEffect edgeEffect = this.C;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.C.isFinished();
        }
        EdgeEffect edgeEffect2 = this.D;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.D.isFinished();
        }
        EdgeEffect edgeEffect3 = this.E;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.E.isFinished();
        }
        EdgeEffect edgeEffect4 = this.F;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.F.isFinished();
        }
        if (zIsFinished) {
            int[] iArr = a0.f2285a;
            postInvalidateOnAnimation();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean C(int r11, int r12, android.view.MotionEvent r13, int r14) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.C(int, int, android.view.MotionEvent, int):boolean");
    }

    public final void D(int i8, int i9, int[] iArr) {
        F();
        w();
        Trace.beginSection("RV Scroll");
        int scrollState = getScrollState();
        k0 k0Var = this.f759a0;
        if (scrollState == 2) {
            OverScroller overScroller = this.U.f5881c;
            overScroller.getFinalX();
            overScroller.getCurrX();
            k0Var.getClass();
            overScroller.getFinalY();
            overScroller.getCurrY();
        } else {
            k0Var.getClass();
        }
        h0 h0Var = this.f758a;
        int iX = i8 != 0 ? this.f776k.X(i8, h0Var, k0Var) : 0;
        int iY = i9 != 0 ? this.f776k.Y(i9, h0Var, k0Var) : 0;
        Trace.endSection();
        int iR = this.d.r();
        for (int i10 = 0; i10 < iR; i10++) {
            View viewQ = this.d.q(i10);
            ViewParent parent = viewQ.getParent();
            if (parent != null && parent != this) {
                throw new IllegalArgumentException("View " + viewQ + " is not a direct child of " + this);
            }
            s(viewQ);
        }
        x(true);
        G(false);
        if (iArr != null) {
            iArr[0] = iX;
            iArr[1] = iY;
        }
    }

    public final void E(int i8, int i9, boolean z) {
        b0 b0Var = this.f776k;
        if (b0Var == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f785t) {
            return;
        }
        int i10 = !b0Var.c() ? 0 : i8;
        int i11 = !this.f776k.d() ? 0 : i9;
        if (i10 == 0 && i11 == 0) {
            return;
        }
        if (z) {
            int i12 = i10 != 0 ? 1 : 0;
            if (i11 != 0) {
                i12 |= 2;
            }
            getScrollingChildHelper().g(i12, 1);
        }
        m0 m0Var = this.U;
        RecyclerView recyclerView = m0Var.f5884g;
        int iAbs = Math.abs(i10);
        int iAbs2 = Math.abs(i11);
        boolean z2 = iAbs > iAbs2;
        int width = z2 ? recyclerView.getWidth() : recyclerView.getHeight();
        if (!z2) {
            iAbs = iAbs2;
        }
        int iMin = Math.min((int) (((iAbs / width) + 1.0f) * 300.0f), 2000);
        d dVar = f757n0;
        if (m0Var.d != dVar) {
            m0Var.d = dVar;
            m0Var.f5881c = new OverScroller(recyclerView.getContext(), dVar);
        }
        m0Var.f5880b = 0;
        m0Var.f5879a = 0;
        recyclerView.setScrollState(2);
        m0Var.f5881c.startScroll(0, 0, i10, i11, iMin);
        m0Var.a();
    }

    public final void F() {
        this.f784s++;
    }

    public final void G(boolean z) {
        if (this.f784s < 1) {
            this.f784s = 1;
        }
        this.f784s--;
    }

    public final void H(int i8) {
        getScrollingChildHelper().h(i8);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i8, int i9) {
        b0 b0Var = this.f776k;
        if (b0Var != null) {
            b0Var.getClass();
        }
        super.addFocusables(arrayList, i8, i9);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof c0) && this.f776k.e((c0) layoutParams);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        b0 b0Var = this.f776k;
        if (b0Var != null && b0Var.c()) {
            return this.f776k.g(this.f759a0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        b0 b0Var = this.f776k;
        if (b0Var != null && b0Var.c()) {
            return this.f776k.h(this.f759a0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        b0 b0Var = this.f776k;
        if (b0Var != null && b0Var.c()) {
            return this.f776k.i(this.f759a0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        b0 b0Var = this.f776k;
        if (b0Var != null && b0Var.d()) {
            return this.f776k.j(this.f759a0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        b0 b0Var = this.f776k;
        if (b0Var != null && b0Var.d()) {
            return this.f776k.k(this.f759a0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        b0 b0Var = this.f776k;
        if (b0Var != null && b0Var.d()) {
            return this.f776k.l(this.f759a0);
        }
        return 0;
    }

    public final void d(String str) {
        if (this.z > 0) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + p());
        }
        if (this.A > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID + p()));
        }
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f3, float f7, boolean z) {
        return getScrollingChildHelper().a(f3, f7, z);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f3, float f7) {
        return getScrollingChildHelper().b(f3, f7);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i8, int i9, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i8, iArr, i9, iArr2, 0);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i8, int i9, int i10, int i11, int[] iArr) {
        return getScrollingChildHelper().d(i8, i9, i10, i11, iArr, 0, null);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        boolean z;
        super.draw(canvas);
        ArrayList arrayList = this.f778m;
        int size = arrayList.size();
        boolean z2 = false;
        for (int i8 = 0; i8 < size; i8++) {
            ((z) arrayList.get(i8)).b(canvas, this);
        }
        EdgeEffect edgeEffect = this.C;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.f767f ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.C;
            z = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.D;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.f767f) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.D;
            z |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.E;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f767f ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.E;
            z |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.F;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f767f) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.F;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z2 = true;
            }
            z |= z2;
            canvas.restoreToCount(iSave4);
        }
        if ((z || this.G == null || arrayList.size() <= 0 || !this.G.d()) ? z : true) {
            int[] iArr = a0.f2285a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j4) {
        return super.drawChild(canvas, view, j4);
    }

    public final void f(int i8, int i9) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.C;
        if (edgeEffect == null || edgeEffect.isFinished() || i8 <= 0) {
            zIsFinished = false;
        } else {
            this.C.onRelease();
            zIsFinished = this.C.isFinished();
        }
        EdgeEffect edgeEffect2 = this.E;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i8 < 0) {
            this.E.onRelease();
            zIsFinished |= this.E.isFinished();
        }
        EdgeEffect edgeEffect3 = this.D;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i9 > 0) {
            this.D.onRelease();
            zIsFinished |= this.D.isFinished();
        }
        EdgeEffect edgeEffect4 = this.F;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i9 < 0) {
            this.F.onRelease();
            zIsFinished |= this.F.isFinished();
        }
        if (zIsFinished) {
            int[] iArr = a0.f2285a;
            postInvalidateOnAnimation();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x00c4, code lost:
    
        if (r4 > 0) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00e2, code lost:
    
        if (r7 > 0) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00e5, code lost:
    
        if (r4 < 0) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00e8, code lost:
    
        if (r7 < 0) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00f0, code lost:
    
        if ((r7 * r1) <= 0) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00f8, code lost:
    
        if ((r7 * r1) >= 0) goto L84;
     */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View focusSearch(android.view.View r13, int r14) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.focusSearch(android.view.View, int):android.view.View");
    }

    public final void g() {
        if (!this.f783r || this.f789x) {
            Trace.beginSection("RV FullInvalidate");
            i();
            Trace.endSection();
        } else if (this.f762c.B()) {
            this.f762c.getClass();
            if (this.f762c.B()) {
                Trace.beginSection("RV FullInvalidate");
                i();
                Trace.endSection();
            }
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        b0 b0Var = this.f776k;
        if (b0Var != null) {
            return b0Var.m();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + p());
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        b0 b0Var = this.f776k;
        if (b0Var != null) {
            return b0Var.n(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + p());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public v getAdapter() {
        return null;
    }

    @Override // android.view.View
    public int getBaseline() {
        b0 b0Var = this.f776k;
        if (b0Var == null) {
            return super.getBaseline();
        }
        b0Var.getClass();
        return -1;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i8, int i9) {
        return super.getChildDrawingOrder(i8, i9);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.f767f;
    }

    public p0 getCompatAccessibilityDelegate() {
        return this.f766e0;
    }

    public x getEdgeEffectFactory() {
        return this.B;
    }

    public y getItemAnimator() {
        return this.G;
    }

    public int getItemDecorationCount() {
        return this.f778m.size();
    }

    public b0 getLayoutManager() {
        return this.f776k;
    }

    public int getMaxFlingVelocity() {
        return this.Q;
    }

    public int getMinFlingVelocity() {
        return this.P;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public d0 getOnFlingListener() {
        return null;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.T;
    }

    public g0 getRecycledViewPool() {
        return this.f758a.c();
    }

    public int getScrollState() {
        return this.H;
    }

    public final void h(int i8, int i9) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int[] iArr = a0.f2285a;
        setMeasuredDimension(b0.f(i8, paddingRight, getMinimumWidth()), b0.f(i9, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().f(0);
    }

    public final void i() {
        Log.w("RecyclerView", "No adapter attached; skipping layout");
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.f781p;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.f785t;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().d;
    }

    public final boolean j(int i8, int[] iArr, int i9, int[] iArr2, int i10) {
        return getScrollingChildHelper().c(i8, iArr, i9, iArr2, i10);
    }

    public final void k(int i8, int i9, int i10, int i11, int[] iArr, int i12, int[] iArr2) {
        getScrollingChildHelper().d(i8, i9, i10, i11, iArr, i12, iArr2);
    }

    public final void l() {
        if (this.F != null) {
            return;
        }
        this.B.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.F = edgeEffect;
        if (this.f767f) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final void m() {
        if (this.C != null) {
            return;
        }
        this.B.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.C = edgeEffect;
        if (this.f767f) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void n() {
        if (this.E != null) {
            return;
        }
        this.B.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.E = edgeEffect;
        if (this.f767f) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void o() {
        if (this.D != null) {
            return;
        }
        this.B.getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.D = edgeEffect;
        if (this.f767f) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0059  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.z = r0
            r1 = 1
            r5.f781p = r1
            boolean r2 = r5.f783r
            if (r2 == 0) goto L14
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L14
            r0 = r1
        L14:
            r5.f783r = r0
            v0.b0 r0 = r5.f776k
            if (r0 == 0) goto L1f
            r0.f5795e = r1
            r0.K(r5)
        L1f:
            java.lang.ThreadLocal r0 = v0.l.f5873e
            java.lang.Object r1 = r0.get()
            v0.l r1 = (v0.l) r1
            r5.V = r1
            if (r1 != 0) goto L67
            v0.l r1 = new v0.l
            r1.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f5875a = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.d = r2
            r5.V = r1
            int[] r1 = e0.a0.f2285a
            android.view.Display r1 = r5.getDisplay()
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L59
            if (r1 == 0) goto L59
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L59
            goto L5b
        L59:
            r1 = 1114636288(0x42700000, float:60.0)
        L5b:
            v0.l r2 = r5.V
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f5877c = r3
            r0.set(r2)
        L67:
            v0.l r0 = r5.V
            java.util.ArrayList r0 = r0.f5875a
            r0.add(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        y yVar = this.G;
        if (yVar != null) {
            yVar.c();
        }
        setScrollState(0);
        m0 m0Var = this.U;
        m0Var.f5884g.removeCallbacks(m0Var);
        m0Var.f5881c.abortAnimation();
        this.f781p = false;
        b0 b0Var = this.f776k;
        if (b0Var != null) {
            b0Var.f5795e = false;
            b0Var.L(this);
        }
        this.f775j0.clear();
        removeCallbacks(this.k0);
        this.f765e.getClass();
        while (u0.f5941b.a() != null) {
        }
        l lVar = this.V;
        if (lVar != null) {
            lVar.f5875a.remove(this);
            this.V = null;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList arrayList = this.f778m;
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((z) arrayList.get(i8)).getClass();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0082  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onGenericMotionEvent(android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        if (!this.f785t) {
            this.f780o = null;
            if (r(motionEvent)) {
                B();
                setScrollState(0);
                return true;
            }
            b0 b0Var = this.f776k;
            if (b0Var != null) {
                boolean zC = b0Var.c();
                boolean zD = this.f776k.d();
                if (this.J == null) {
                    this.J = VelocityTracker.obtain();
                }
                this.J.addMovement(motionEvent);
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                if (actionMasked == 0) {
                    if (this.f786u) {
                        this.f786u = false;
                    }
                    this.I = motionEvent.getPointerId(0);
                    int x7 = (int) (motionEvent.getX() + 0.5f);
                    this.M = x7;
                    this.K = x7;
                    int y = (int) (motionEvent.getY() + 0.5f);
                    this.N = y;
                    this.L = y;
                    if (this.H == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                        H(1);
                    }
                    int[] iArr = this.f772h0;
                    iArr[1] = 0;
                    iArr[0] = 0;
                    int i8 = zC;
                    if (zD) {
                        i8 = (zC ? 1 : 0) | 2;
                    }
                    getScrollingChildHelper().g(i8, 0);
                } else if (actionMasked == 1) {
                    this.J.clear();
                    H(0);
                } else if (actionMasked == 2) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.I);
                    if (iFindPointerIndex < 0) {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.I + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x8 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                    int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                    if (this.H != 1) {
                        int i9 = x8 - this.K;
                        int i10 = y2 - this.L;
                        if (zC == 0 || Math.abs(i9) <= this.O) {
                            z = false;
                        } else {
                            this.M = x8;
                            z = true;
                        }
                        if (zD && Math.abs(i10) > this.O) {
                            this.N = y2;
                            z = true;
                        }
                        if (z) {
                            setScrollState(1);
                        }
                    }
                } else if (actionMasked == 3) {
                    B();
                    setScrollState(0);
                } else if (actionMasked == 5) {
                    this.I = motionEvent.getPointerId(actionIndex);
                    int x9 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.M = x9;
                    this.K = x9;
                    int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.N = y4;
                    this.L = y4;
                } else if (actionMasked == 6) {
                    y(motionEvent);
                }
                if (this.H == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i8, int i9, int i10, int i11) {
        Trace.beginSection("RV OnLayout");
        i();
        Trace.endSection();
        this.f783r = true;
    }

    @Override // android.view.View
    public final void onMeasure(int i8, int i9) {
        b0 b0Var = this.f776k;
        if (b0Var == null) {
            h(i8, i9);
            return;
        }
        if (b0Var.E()) {
            View.MeasureSpec.getMode(i8);
            View.MeasureSpec.getMode(i9);
            this.f776k.f5793b.h(i8, i9);
        } else {
            if (this.f782q) {
                this.f776k.f5793b.h(i8, i9);
                return;
            }
            k0 k0Var = this.f759a0;
            if (k0Var.f5872i) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            k0Var.f5867c = 0;
            F();
            this.f776k.f5793b.h(i8, i9);
            G(false);
            k0Var.f5868e = false;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i8, Rect rect) {
        if (this.z > 0) {
            return false;
        }
        return super.onRequestFocusInDescendants(i8, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof j0)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        j0 j0Var = (j0) parcelable;
        this.f760b = j0Var;
        super.onRestoreInstanceState(j0Var.f3000a);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        j0 j0Var = new j0(super.onSaveInstanceState());
        j0 j0Var2 = this.f760b;
        if (j0Var2 != null) {
            j0Var.f5860c = j0Var2.f5860c;
            return j0Var;
        }
        b0 b0Var = this.f776k;
        if (b0Var != null) {
            j0Var.f5860c = b0Var.P();
            return j0Var;
        }
        j0Var.f5860c = null;
        return j0Var;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        if (i8 == i10 && i9 == i11) {
            return;
        }
        this.F = null;
        this.D = null;
        this.E = null;
        this.C = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01f5 A[PHI: r1
      0x01f5: PHI (r1v53 int) = (r1v38 int), (r1v57 int) binds: [B:90:0x01de, B:94:0x01f1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01f8  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r23) {
        /*
            Method dump skipped, instructions count: 897
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final String p() {
        return " " + super.toString() + ", adapter:" + ((Object) null) + ", layout:" + this.f776k + ", context:" + getContext();
    }

    public final View q(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0061 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean r(android.view.MotionEvent r12) {
        /*
            r11 = this;
            int r0 = r12.getAction()
            java.util.ArrayList r1 = r11.f779n
            int r2 = r1.size()
            r3 = 0
            r4 = r3
        Lc:
            if (r4 >= r2) goto L64
            java.lang.Object r5 = r1.get(r4)
            v0.j r5 = (v0.j) r5
            int r6 = r5.f5853q
            r7 = 1
            r8 = 2
            if (r6 != r7) goto L59
            float r6 = r12.getX()
            float r9 = r12.getY()
            boolean r6 = r5.d(r6, r9)
            float r9 = r12.getX()
            float r10 = r12.getY()
            boolean r9 = r5.c(r9, r10)
            int r10 = r12.getAction()
            if (r10 != 0) goto L61
            if (r6 != 0) goto L3c
            if (r9 == 0) goto L61
        L3c:
            if (r9 == 0) goto L49
            r5.f5854r = r7
            float r6 = r12.getX()
            int r6 = (int) r6
            float r6 = (float) r6
            r5.f5847k = r6
            goto L55
        L49:
            if (r6 == 0) goto L55
            r5.f5854r = r8
            float r6 = r12.getY()
            int r6 = (int) r6
            float r6 = (float) r6
            r5.f5846j = r6
        L55:
            r5.f(r8)
            goto L5b
        L59:
            if (r6 != r8) goto L61
        L5b:
            r6 = 3
            if (r0 == r6) goto L61
            r11.f780o = r5
            return r7
        L61:
            int r4 = r4 + 1
            goto Lc
        L64:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.r(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z) {
        s(view);
        view.clearAnimation();
        s(view);
        super.removeDetachedView(view, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        this.f776k.getClass();
        if (this.z <= 0 && view2 != null) {
            A(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return this.f776k.V(this, view, rect, z, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        ArrayList arrayList = this.f779n;
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((j) arrayList.get(i8)).getClass();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.f784s != 0 || this.f785t) {
            return;
        }
        super.requestLayout();
    }

    @Override // android.view.View
    public final void scrollBy(int i8, int i9) {
        b0 b0Var = this.f776k;
        if (b0Var == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.f785t) {
            return;
        }
        boolean zC = b0Var.c();
        boolean zD = this.f776k.d();
        if (zC || zD) {
            if (!zC) {
                i8 = 0;
            }
            if (!zD) {
                i9 = 0;
            }
            C(i8, i9, null, 0);
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i8, int i9) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (this.z <= 0) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        } else {
            int contentChangeTypes = accessibilityEvent != null ? accessibilityEvent.getContentChangeTypes() : 0;
            this.f787v |= contentChangeTypes != 0 ? contentChangeTypes : 0;
        }
    }

    public void setAccessibilityDelegateCompat(p0 p0Var) {
        this.f766e0 = p0Var;
        a0.e(this, p0Var);
    }

    public void setAdapter(v vVar) {
        setLayoutFrozen(false);
        y yVar = this.G;
        if (yVar != null) {
            yVar.c();
        }
        b0 b0Var = this.f776k;
        h0 h0Var = this.f758a;
        if (b0Var != null) {
            b0Var.R(h0Var);
            this.f776k.S(h0Var);
        }
        h0Var.f5829a.clear();
        h0Var.e();
        a4.d dVar = this.f762c;
        dVar.I((ArrayList) dVar.f97c);
        dVar.I((ArrayList) dVar.d);
        b0 b0Var2 = this.f776k;
        if (b0Var2 != null) {
            b0Var2.J();
        }
        h0Var.f5829a.clear();
        h0Var.e();
        g0 g0VarC = h0Var.c();
        if (g0VarC.f5828b == 0) {
            SparseArray sparseArray = g0VarC.f5827a;
            for (int i8 = 0; i8 < sparseArray.size(); i8++) {
                ((f0) sparseArray.valueAt(i8)).f5812a.clear();
            }
        }
        this.f759a0.d = true;
        this.y = false | this.y;
        this.f789x = true;
        int iZ = this.d.z();
        for (int i9 = 0; i9 < iZ; i9++) {
            s(this.d.y(i9));
        }
        v();
        h0 h0Var2 = this.f758a;
        ArrayList arrayList = h0Var2.f5831c;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
        }
        h0Var2.e();
        requestLayout();
    }

    public void setChildDrawingOrderCallback(w wVar) {
        if (wVar == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z) {
        if (z != this.f767f) {
            this.F = null;
            this.D = null;
            this.E = null;
            this.C = null;
        }
        this.f767f = z;
        super.setClipToPadding(z);
        if (this.f783r) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(x xVar) {
        xVar.getClass();
        this.B = xVar;
        this.F = null;
        this.D = null;
        this.E = null;
        this.C = null;
    }

    public void setHasFixedSize(boolean z) {
        this.f782q = z;
    }

    public void setItemAnimator(y yVar) {
        y yVar2 = this.G;
        if (yVar2 != null) {
            yVar2.c();
            this.G.f5943a = null;
        }
        this.G = yVar;
        if (yVar != null) {
            yVar.f5943a = this.f764d0;
        }
    }

    public void setItemViewCacheSize(int i8) {
        h0 h0Var = this.f758a;
        h0Var.d = i8;
        h0Var.k();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z) {
        suppressLayout(z);
    }

    public void setLayoutManager(b0 b0Var) {
        if (b0Var == this.f776k) {
            return;
        }
        setScrollState(0);
        m0 m0Var = this.U;
        m0Var.f5884g.removeCallbacks(m0Var);
        m0Var.f5881c.abortAnimation();
        b0 b0Var2 = this.f776k;
        h0 h0Var = this.f758a;
        if (b0Var2 != null) {
            y yVar = this.G;
            if (yVar != null) {
                yVar.c();
            }
            this.f776k.R(h0Var);
            this.f776k.S(h0Var);
            h0Var.f5829a.clear();
            h0Var.e();
            if (this.f781p) {
                b0 b0Var3 = this.f776k;
                b0Var3.f5795e = false;
                b0Var3.L(this);
            }
            this.f776k.Z(null);
            this.f776k = null;
        } else {
            h0Var.f5829a.clear();
            h0Var.e();
        }
        a4.d dVar = this.d;
        RecyclerView recyclerView = ((u) dVar.f96b).f5940a;
        ((a) dVar.f97c).h();
        ArrayList arrayList = (ArrayList) dVar.d;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            s((View) arrayList.get(size));
            arrayList.remove(size);
        }
        int childCount = recyclerView.getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = recyclerView.getChildAt(i8);
            s(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeAllViews();
        this.f776k = b0Var;
        if (b0Var != null) {
            if (b0Var.f5793b != null) {
                throw new IllegalArgumentException("LayoutManager " + b0Var + " is already attached to a RecyclerView:" + b0Var.f5793b.p());
            }
            b0Var.Z(this);
            if (this.f781p) {
                b0 b0Var4 = this.f776k;
                b0Var4.f5795e = true;
                b0Var4.K(this);
            }
        }
        h0Var.k();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        g scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.d) {
            ViewGroup viewGroup = scrollingChildHelper.f2308c;
            int[] iArr = a0.f2285a;
            viewGroup.stopNestedScroll();
        }
        scrollingChildHelper.d = z;
    }

    @Deprecated
    public void setOnScrollListener(e0 e0Var) {
        this.f761b0 = e0Var;
    }

    public void setPreserveFocusAfterLayout(boolean z) {
        this.T = z;
    }

    public void setRecycledViewPool(g0 g0Var) {
        h0 h0Var = this.f758a;
        if (h0Var.f5833f != null) {
            r0.f5828b--;
        }
        h0Var.f5833f = g0Var;
        if (g0Var != null) {
            h0Var.f5834g.getAdapter();
        }
    }

    public void setScrollState(int i8) {
        if (i8 == this.H) {
            return;
        }
        this.H = i8;
        if (i8 != 2) {
            m0 m0Var = this.U;
            m0Var.f5884g.removeCallbacks(m0Var);
            m0Var.f5881c.abortAnimation();
        }
        b0 b0Var = this.f776k;
        if (b0Var != null) {
            b0Var.Q(i8);
        }
        e0 e0Var = this.f761b0;
        if (e0Var != null) {
            e0Var.a(i8);
        }
        ArrayList arrayList = this.f763c0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((e0) this.f763c0.get(size)).a(i8);
            }
        }
    }

    public void setScrollingTouchSlop(int i8) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i8 != 0) {
            if (i8 == 1) {
                this.O = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i8 + "; using default value");
        }
        this.O = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(l0 l0Var) {
        this.f758a.getClass();
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i8) {
        return getScrollingChildHelper().g(i8, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        getScrollingChildHelper().h(0);
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z) {
        if (z != this.f785t) {
            d("Do not suppressLayout in layout or scroll");
            if (!z) {
                this.f785t = false;
                return;
            }
            long jUptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
            this.f785t = true;
            this.f786u = true;
            setScrollState(0);
            m0 m0Var = this.U;
            m0Var.f5884g.removeCallbacks(m0Var);
            m0Var.f5881c.abortAnimation();
        }
    }

    public final Rect t(View view) {
        c0 c0Var = (c0) view.getLayoutParams();
        boolean z = c0Var.f5805b;
        Rect rect = c0Var.f5804a;
        if (!z) {
            return rect;
        }
        if (this.f759a0.f5868e) {
            throw null;
        }
        rect.set(0, 0, 0, 0);
        ArrayList arrayList = this.f778m;
        if (arrayList.size() <= 0) {
            c0Var.f5805b = false;
            return rect;
        }
        this.f769g.set(0, 0, 0, 0);
        ((z) arrayList.get(0)).getClass();
        ((c0) view.getLayoutParams()).getClass();
        throw null;
    }

    public final boolean u() {
        return !this.f783r || this.f789x || this.f762c.B();
    }

    public final void v() {
        int iZ = this.d.z();
        for (int i8 = 0; i8 < iZ; i8++) {
            ((c0) this.d.y(i8).getLayoutParams()).f5805b = true;
        }
        ArrayList arrayList = this.f758a.f5831c;
        if (arrayList.size() <= 0) {
            return;
        }
        ((n0) arrayList.get(0)).getClass();
        throw null;
    }

    public final void w() {
        this.z++;
    }

    public final void x(boolean z) {
        AccessibilityManager accessibilityManager;
        int i8 = this.z - 1;
        this.z = i8;
        if (i8 < 1) {
            this.z = 0;
            if (z) {
                int i9 = this.f787v;
                this.f787v = 0;
                if (i9 != 0 && (accessibilityManager = this.f788w) != null && accessibilityManager.isEnabled()) {
                    AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                    accessibilityEventObtain.setEventType(2048);
                    accessibilityEventObtain.setContentChangeTypes(i9);
                    sendAccessibilityEventUnchecked(accessibilityEventObtain);
                }
                ArrayList arrayList = this.f775j0;
                int size = arrayList.size() - 1;
                if (size < 0) {
                    arrayList.clear();
                } else {
                    ((n0) arrayList.get(size)).getClass();
                    throw null;
                }
            }
        }
    }

    public final void y(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.I) {
            int i8 = actionIndex == 0 ? 1 : 0;
            this.I = motionEvent.getPointerId(i8);
            int x7 = (int) (motionEvent.getX(i8) + 0.5f);
            this.M = x7;
            this.K = x7;
            int y = (int) (motionEvent.getY(i8) + 0.5f);
            this.N = y;
            this.L = y;
        }
    }

    public final void z(n0 n0Var, p0.b bVar) {
        n0Var.f5894b &= -8193;
        if (this.f759a0.f5869f && n0Var.k() && !n0Var.h() && !n0Var.n()) {
            throw null;
        }
        j.j jVar = (j.j) this.f765e.f623b;
        u0 u0VarA = (u0) jVar.get(n0Var);
        if (u0VarA == null) {
            u0VarA = u0.a();
            jVar.put(n0Var, u0VarA);
        }
        u0VarA.getClass();
        u0VarA.f5942a |= 4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r19v2 */
    public RecyclerView(Context context, AttributeSet attributeSet, int i8) throws NoSuchMethodException, SecurityException {
        char c3;
        boolean z;
        char c8;
        TypedArray typedArray;
        int i9;
        Constructor constructor;
        super(context, attributeSet, i8);
        new p0.b(12, this);
        this.f758a = new h0(this);
        this.f765e = new p(22);
        this.f769g = new Rect();
        this.f771h = new Rect();
        this.f774j = new RectF();
        this.f777l = new ArrayList();
        this.f778m = new ArrayList();
        this.f779n = new ArrayList();
        this.f784s = 0;
        this.f789x = false;
        this.y = false;
        this.z = 0;
        this.A = 0;
        this.B = new x();
        v0.g gVar = new v0.g();
        Object[] objArr = null;
        gVar.f5943a = null;
        gVar.f5944b = new ArrayList();
        gVar.f5945c = 120L;
        gVar.d = 120L;
        gVar.f5946e = 250L;
        gVar.f5947f = 250L;
        gVar.f5815g = true;
        gVar.f5816h = new ArrayList();
        gVar.f5817i = new ArrayList();
        gVar.f5818j = new ArrayList();
        gVar.f5819k = new ArrayList();
        gVar.f5820l = new ArrayList();
        gVar.f5821m = new ArrayList();
        gVar.f5822n = new ArrayList();
        gVar.f5823o = new ArrayList();
        gVar.f5824p = new ArrayList();
        gVar.f5825q = new ArrayList();
        gVar.f5826r = new ArrayList();
        this.G = gVar;
        this.H = 0;
        this.I = -1;
        this.R = Float.MIN_VALUE;
        this.S = Float.MIN_VALUE;
        this.T = true;
        this.U = new m0(this);
        this.W = new m();
        k0 k0Var = new k0();
        k0Var.f5865a = 0;
        k0Var.f5866b = 0;
        k0Var.f5867c = 0;
        k0Var.d = false;
        k0Var.f5868e = false;
        k0Var.f5869f = false;
        k0Var.f5870g = false;
        k0Var.f5871h = false;
        k0Var.f5872i = false;
        this.f759a0 = k0Var;
        u uVar = new u(this);
        this.f764d0 = uVar;
        this.f770g0 = new int[2];
        this.f772h0 = new int[2];
        this.f773i0 = new int[2];
        this.f775j0 = new ArrayList();
        int i10 = 10;
        this.k0 = new b(i10, this);
        new p0.b(9, this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.O = viewConfiguration.getScaledTouchSlop();
        this.R = viewConfiguration.getScaledHorizontalScrollFactor();
        this.S = viewConfiguration.getScaledVerticalScrollFactor();
        this.P = viewConfiguration.getScaledMinimumFlingVelocity();
        this.Q = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.G.f5943a = uVar;
        this.f762c = new a4.d(new p0.b(i10, this));
        this.d = new a4.d(new u(this));
        int[] iArr = a0.f2285a;
        if (e0.w.a(this) == 0) {
            e0.w.b(this, 8);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.f788w = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new p0(this));
        int[] iArr2 = u0.a.f5615a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr2, i8, 0);
        e0.y.b(this, context, iArr2, attributeSet, typedArrayObtainStyledAttributes, i8, 0);
        String string = typedArrayObtainStyledAttributes.getString(8);
        if (typedArrayObtainStyledAttributes.getInt(2, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f767f = typedArrayObtainStyledAttributes.getBoolean(1, true);
        if (typedArrayObtainStyledAttributes.getBoolean(3, false)) {
            StateListDrawable stateListDrawable = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(6);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(7);
            StateListDrawable stateListDrawable2 = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(4);
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(5);
            if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
                throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + p());
            }
            Resources resources = getContext().getResources();
            c3 = 3;
            c8 = 2;
            z = 1;
            typedArray = typedArrayObtainStyledAttributes;
            i9 = 4;
            new j(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(com.stepos.stepclaw.R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(com.stepos.stepclaw.R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(com.stepos.stepclaw.R.dimen.fastscroll_margin));
        } else {
            c3 = 3;
            z = 1;
            c8 = 2;
            typedArray = typedArrayObtainStyledAttributes;
            i9 = 4;
        }
        typedArray.recycle();
        if (string != null) {
            String strTrim = string.trim();
            if (!strTrim.isEmpty()) {
                if (strTrim.charAt(0) == '.') {
                    strTrim = context.getPackageName() + strTrim;
                } else if (!strTrim.contains(".")) {
                    strTrim = RecyclerView.class.getPackage().getName() + '.' + strTrim;
                }
                String str = strTrim;
                try {
                    Class clsAsSubclass = Class.forName(str, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(b0.class);
                    try {
                        constructor = clsAsSubclass.getConstructor(f756m0);
                        Object[] objArr2 = new Object[i9];
                        objArr2[0] = context;
                        objArr2[z] = attributeSet;
                        objArr2[c8] = Integer.valueOf(i8);
                        objArr2[c3] = 0;
                        objArr = objArr2;
                    } catch (NoSuchMethodException e9) {
                        try {
                            constructor = clsAsSubclass.getConstructor(null);
                        } catch (NoSuchMethodException e10) {
                            e10.initCause(e9);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, e10);
                        }
                    }
                    constructor.setAccessible(z);
                    setLayoutManager((b0) constructor.newInstance(objArr));
                } catch (ClassCastException e11) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + str, e11);
                } catch (ClassNotFoundException e12) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + str, e12);
                } catch (IllegalAccessException e13) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + str, e13);
                } catch (InstantiationException e14) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e14);
                } catch (InvocationTargetException e15) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e15);
                }
            }
        }
        int[] iArr3 = f755l0;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr3, i8, 0);
        e0.y.b(this, context, iArr3, attributeSet, typedArrayObtainStyledAttributes2, i8, 0);
        boolean z2 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        b0 b0Var = this.f776k;
        if (b0Var != null) {
            return b0Var.o(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + p());
    }

    public void setOnFlingListener(d0 d0Var) {
    }

    @Deprecated
    public void setRecyclerListener(i0 i0Var) {
    }
}
