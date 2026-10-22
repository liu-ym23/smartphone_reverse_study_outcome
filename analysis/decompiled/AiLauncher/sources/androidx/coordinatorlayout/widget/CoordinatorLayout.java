package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.coordinatorlayout.R$attr;
import androidx.coordinatorlayout.R$style;
import androidx.coordinatorlayout.R$styleable;
import androidx.core.view.A;
import androidx.core.view.C1321i;
import androidx.core.view.C1337z;
import androidx.core.view.InterfaceC1335x;
import androidx.core.view.InterfaceC1336y;
import androidx.core.view.N;
import androidx.core.view.a0;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import u0.C5566a;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements InterfaceC1335x, InterfaceC1336y {

    /* renamed from: t, reason: collision with root package name */
    public static final String f12881t;

    /* renamed from: u, reason: collision with root package name */
    public static final Class<?>[] f12882u;

    /* renamed from: v, reason: collision with root package name */
    public static final ThreadLocal<Map<String, Constructor<c>>> f12883v;

    /* renamed from: w, reason: collision with root package name */
    public static final Comparator<View> f12884w;

    /* renamed from: x, reason: collision with root package name */
    public static final B0.e<Rect> f12885x;

    /* renamed from: a, reason: collision with root package name */
    public final List<View> f12886a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.coordinatorlayout.widget.a<View> f12887b;

    /* renamed from: c, reason: collision with root package name */
    public final List<View> f12888c;

    /* renamed from: d, reason: collision with root package name */
    public Paint f12889d;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f12890e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f12891f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f12892g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f12893h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f12894i;

    /* renamed from: j, reason: collision with root package name */
    public View f12895j;

    /* renamed from: k, reason: collision with root package name */
    public View f12896k;

    /* renamed from: l, reason: collision with root package name */
    public g f12897l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f12898m;

    /* renamed from: n, reason: collision with root package name */
    public a0 f12899n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f12900o;

    /* renamed from: p, reason: collision with root package name */
    public Drawable f12901p;

    /* renamed from: q, reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f12902q;

    /* renamed from: r, reason: collision with root package name */
    public A f12903r;

    /* renamed from: s, reason: collision with root package name */
    public final C1337z f12904s;

    public class a implements A {
        public a() {
        }

        @Override // androidx.core.view.A
        public a0 a(View view, a0 a0Var) {
            return CoordinatorLayout.this.f0(a0Var);
        }
    }

    public interface b {
        c getBehavior();
    }

    public static abstract class c<V extends View> {
        public c() {
        }

        public static Object getTag(View view) {
            return ((f) view.getLayoutParams()).f12924r;
        }

        public static void setTag(View view, Object obj) {
            ((f) view.getLayoutParams()).f12924r = obj;
        }

        public boolean blocksInteractionBelow(CoordinatorLayout coordinatorLayout, V v10) {
            return getScrimOpacity(coordinatorLayout, v10) > 0.0f;
        }

        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, V v10, Rect rect) {
            return false;
        }

        public int getScrimColor(CoordinatorLayout coordinatorLayout, V v10) {
            return -16777216;
        }

        public float getScrimOpacity(CoordinatorLayout coordinatorLayout, V v10) {
            return 0.0f;
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, V v10, View view) {
            return false;
        }

        public a0 onApplyWindowInsets(CoordinatorLayout coordinatorLayout, V v10, a0 a0Var) {
            return a0Var;
        }

        public void onAttachedToLayoutParams(f fVar) {
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, V v10, View view) {
            return false;
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, V v10, View view) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v10, int i10) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12, int i13) {
            return false;
        }

        public boolean onNestedFling(CoordinatorLayout coordinatorLayout, V v10, View view, float f10, float f11, boolean z10) {
            return false;
        }

        public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v10, View view, float f10, float f11) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int[] iArr) {
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13) {
        }

        @Deprecated
        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10) {
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, V v10, Rect rect, boolean z10) {
            return false;
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v10, Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v10) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10) {
            return false;
        }

        @Deprecated
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view) {
        }

        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
            return false;
        }

        public c(Context context, AttributeSet attributeSet) {
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int[] iArr, int i12) {
            if (i12 == 0) {
                onNestedPreScroll(coordinatorLayout, v10, view, i10, i11, iArr);
            }
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13, int i14) {
            if (i14 == 0) {
                onNestedScroll(coordinatorLayout, v10, view, i10, i11, i12, i13);
            }
        }

        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10, int i11) {
            if (i11 == 0) {
                onNestedScrollAccepted(coordinatorLayout, v10, view, view2, i10);
            }
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10, int i11) {
            if (i11 == 0) {
                return onStartNestedScroll(coordinatorLayout, v10, view, view2, i10);
            }
            return false;
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10) {
            if (i10 == 0) {
                onStopNestedScroll(coordinatorLayout, v10, view);
            }
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
            iArr[0] = iArr[0] + i12;
            iArr[1] = iArr[1] + i13;
            onNestedScroll(coordinatorLayout, v10, view, i10, i11, i12, i13, i14);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface d {
        Class<? extends c> value();
    }

    public class e implements ViewGroup.OnHierarchyChangeListener {
        public e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f12902q;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.P(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f12902q;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public class g implements ViewTreeObserver.OnPreDrawListener {
        public g() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.P(0);
            return true;
        }
    }

    public static class h implements Comparator<View> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float fI = N.I(view);
            float fI2 = N.I(view2);
            if (fI > fI2) {
                return -1;
            }
            return fI < fI2 ? 1 : 0;
        }
    }

    static {
        Package r02 = CoordinatorLayout.class.getPackage();
        f12881t = r02 != null ? r02.getName() : null;
        f12884w = new h();
        f12882u = new Class[]{Context.class, AttributeSet.class};
        f12883v = new ThreadLocal<>();
        f12885x = new B0.g(12);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.coordinatorLayoutStyle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static c S(Context context, AttributeSet attributeSet, String str) throws NoSuchMethodException, SecurityException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = f12881t;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal<Map<String, Constructor<c>>> threadLocal = f12883v;
            Map<String, Constructor<c>> map = threadLocal.get();
            if (map == null) {
                map = new HashMap<>();
                threadLocal.set(map);
            }
            Constructor<c> constructor = map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(f12882u);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return constructor.newInstance(context, attributeSet);
        } catch (Exception e10) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e10);
        }
    }

    public static void X(Rect rect) {
        rect.setEmpty();
        f12885x.release(rect);
    }

    public static int a0(int i10) {
        if (i10 == 0) {
            return 17;
        }
        return i10;
    }

    public static int b0(int i10) {
        if ((i10 & 7) == 0) {
            i10 |= 8388611;
        }
        return (i10 & 112) == 0 ? i10 | 48 : i10;
    }

    public static int c0(int i10) {
        if (i10 == 0) {
            return 8388661;
        }
        return i10;
    }

    public static Rect h() {
        Rect rectAcquire = f12885x.acquire();
        return rectAcquire == null ? new Rect() : rectAcquire;
    }

    private static int k(int i10, int i11, int i12) {
        return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
    }

    public void A(View view, Rect rect) {
        androidx.coordinatorlayout.widget.b.a(this, view, rect);
    }

    public void B(View view, int i10, Rect rect, Rect rect2) {
        f fVar = (f) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        C(i10, rect, rect2, fVar, measuredWidth, measuredHeight);
        l(fVar, rect2, measuredWidth, measuredHeight);
    }

    public final void C(int i10, Rect rect, Rect rect2, f fVar, int i11, int i12) {
        int iB = C1321i.b(a0(fVar.f12909c), i10);
        int iB2 = C1321i.b(b0(fVar.f12910d), i10);
        int i13 = iB & 7;
        int i14 = iB & 112;
        int i15 = iB2 & 7;
        int i16 = iB2 & 112;
        int iWidth = i15 != 1 ? i15 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int iHeight = i16 != 16 ? i16 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i13 == 1) {
            iWidth -= i11 / 2;
        } else if (i13 != 5) {
            iWidth -= i11;
        }
        if (i14 == 16) {
            iHeight -= i12 / 2;
        } else if (i14 != 80) {
            iHeight -= i12;
        }
        rect2.set(iWidth, iHeight, i11 + iWidth, i12 + iHeight);
    }

    public final int D(int i10) {
        int[] iArr = this.f12894i;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i10);
            return 0;
        }
        if (i10 >= 0 && i10 < iArr.length) {
            return iArr[i10];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i10 + " out of range for " + this);
        return 0;
    }

    public void E(View view, Rect rect) {
        rect.set(((f) view.getLayoutParams()).h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f F(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.f12908b) {
            if (view instanceof b) {
                c behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                fVar.o(behavior);
                fVar.f12908b = true;
                return fVar;
            }
            d dVar = null;
            for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                dVar = (d) superclass.getAnnotation(d.class);
                if (dVar != null) {
                    break;
                }
            }
            if (dVar != null) {
                try {
                    fVar.o(dVar.value().getDeclaredConstructor(null).newInstance(null));
                } catch (Exception e10) {
                    Log.e("CoordinatorLayout", "Default behavior class " + dVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e10);
                }
            }
            fVar.f12908b = true;
        }
        return fVar;
    }

    public final void G(List<View> list) {
        list.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i10 = childCount - 1; i10 >= 0; i10--) {
            list.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i10) : i10));
        }
        Comparator<View> comparator = f12884w;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    public final boolean H(View view) {
        return this.f12887b.k(view);
    }

    public boolean I(View view, int i10, int i11) {
        Rect rectH = h();
        A(view, rectH);
        try {
            return rectH.contains(i10, i11);
        } finally {
            X(rectH);
        }
    }

    public final void J(View view, int i10) {
        f fVar = (f) view.getLayoutParams();
        Rect rectH = h();
        rectH.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
        if (this.f12899n != null && N.r(this) && !N.r(view)) {
            rectH.left += this.f12899n.k();
            rectH.top += this.f12899n.m();
            rectH.right -= this.f12899n.l();
            rectH.bottom -= this.f12899n.j();
        }
        Rect rectH2 = h();
        C1321i.a(b0(fVar.f12909c), view.getMeasuredWidth(), view.getMeasuredHeight(), rectH, rectH2, i10);
        view.layout(rectH2.left, rectH2.top, rectH2.right, rectH2.bottom);
        X(rectH);
        X(rectH2);
    }

    public final void K(View view, View view2, int i10) {
        Rect rectH = h();
        Rect rectH2 = h();
        try {
            A(view2, rectH);
            B(view, i10, rectH, rectH2);
            view.layout(rectH2.left, rectH2.top, rectH2.right, rectH2.bottom);
        } finally {
            X(rectH);
            X(rectH2);
        }
    }

    public final void L(View view, int i10, int i11) {
        f fVar = (f) view.getLayoutParams();
        int iB = C1321i.b(c0(fVar.f12909c), i11);
        int i12 = iB & 7;
        int i13 = iB & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i11 == 1) {
            i10 = width - i10;
        }
        int iD = D(i10) - measuredWidth;
        if (i12 == 1) {
            iD += measuredWidth / 2;
        } else if (i12 == 5) {
            iD += measuredWidth;
        }
        int i14 = i13 != 16 ? i13 != 80 ? 0 : measuredHeight : measuredHeight / 2;
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(iD, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(i14, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth + iMax, measuredHeight + iMax2);
    }

    public final MotionEvent M(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        return motionEventObtain;
    }

    public final void N(View view, Rect rect, int i10) {
        boolean z10;
        boolean z11;
        int width;
        int i11;
        int i12;
        int i13;
        int height;
        int i14;
        int i15;
        int i16;
        if (N.N(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            f fVar = (f) view.getLayoutParams();
            c cVarF = fVar.f();
            Rect rectH = h();
            Rect rectH2 = h();
            rectH2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (cVarF == null || !cVarF.getInsetDodgeRect(this, view, rectH)) {
                rectH.set(rectH2);
            } else if (!rectH2.contains(rectH)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + rectH.toShortString() + " | Bounds:" + rectH2.toShortString());
            }
            X(rectH2);
            if (rectH.isEmpty()) {
                X(rectH);
                return;
            }
            int iB = C1321i.b(fVar.f12914h, i10);
            boolean z12 = true;
            if ((iB & 48) != 48 || (i15 = (rectH.top - ((ViewGroup.MarginLayoutParams) fVar).topMargin) - fVar.f12916j) >= (i16 = rect.top)) {
                z10 = false;
            } else {
                e0(view, i16 - i15);
                z10 = true;
            }
            if ((iB & 80) == 80 && (height = ((getHeight() - rectH.bottom) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) + fVar.f12916j) < (i14 = rect.bottom)) {
                e0(view, height - i14);
                z10 = true;
            }
            if (!z10) {
                e0(view, 0);
            }
            if ((iB & 3) != 3 || (i12 = (rectH.left - ((ViewGroup.MarginLayoutParams) fVar).leftMargin) - fVar.f12915i) >= (i13 = rect.left)) {
                z11 = false;
            } else {
                d0(view, i13 - i12);
                z11 = true;
            }
            if ((iB & 5) != 5 || (width = ((getWidth() - rectH.right) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin) + fVar.f12915i) >= (i11 = rect.right)) {
                z12 = z11;
            } else {
                d0(view, width - i11);
            }
            if (!z12) {
                d0(view, 0);
            }
            X(rectH);
        }
    }

    public void O(View view, int i10) {
        c cVarF;
        f fVar = (f) view.getLayoutParams();
        if (fVar.f12917k != null) {
            Rect rectH = h();
            Rect rectH2 = h();
            Rect rectH3 = h();
            A(fVar.f12917k, rectH);
            x(view, false, rectH2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            C(i10, rectH, rectH3, fVar, measuredWidth, measuredHeight);
            boolean z10 = (rectH3.left == rectH2.left && rectH3.top == rectH2.top) ? false : true;
            l(fVar, rectH3, measuredWidth, measuredHeight);
            int i11 = rectH3.left - rectH2.left;
            int i12 = rectH3.top - rectH2.top;
            if (i11 != 0) {
                N.S(view, i11);
            }
            if (i12 != 0) {
                N.T(view, i12);
            }
            if (z10 && (cVarF = fVar.f()) != null) {
                cVarF.onDependentViewChanged(this, view, fVar.f12917k);
            }
            X(rectH);
            X(rectH2);
            X(rectH3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void P(int r18) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.P(int):void");
    }

    public void Q(View view, int i10) {
        f fVar = (f) view.getLayoutParams();
        if (fVar.a()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        View view2 = fVar.f12917k;
        if (view2 != null) {
            K(view, view2, i10);
            return;
        }
        int i11 = fVar.f12911e;
        if (i11 >= 0) {
            L(view, i11, i10);
        } else {
            J(view, i10);
        }
    }

    public void R(View view, int i10, int i11, int i12, int i13) {
        measureChildWithMargins(view, i10, i11, i12, i13);
    }

    public final boolean T(c cVar, View view, MotionEvent motionEvent, int i10) {
        if (i10 == 0) {
            return cVar.onInterceptTouchEvent(this, view, motionEvent);
        }
        if (i10 == 1) {
            return cVar.onTouchEvent(this, view, motionEvent);
        }
        throw new IllegalArgumentException();
    }

    public final boolean U(MotionEvent motionEvent, int i10) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f12888c;
        G(list);
        int size = list.size();
        MotionEvent motionEventM = null;
        boolean zT = false;
        boolean z10 = false;
        for (int i11 = 0; i11 < size; i11++) {
            View view = list.get(i11);
            f fVar = (f) view.getLayoutParams();
            c cVarF = fVar.f();
            if (!(zT || z10) || actionMasked == 0) {
                if (!z10 && !zT && cVarF != null && (zT = T(cVarF, view, motionEvent, i10))) {
                    this.f12895j = view;
                    if (actionMasked != 3 && actionMasked != 1) {
                        for (int i12 = 0; i12 < i11; i12++) {
                            View view2 = list.get(i12);
                            c cVarF2 = ((f) view2.getLayoutParams()).f();
                            if (cVarF2 != null) {
                                if (motionEventM == null) {
                                    motionEventM = M(motionEvent);
                                }
                                T(cVarF2, view2, motionEventM, i10);
                            }
                        }
                    }
                }
                boolean zC = fVar.c();
                boolean zI = fVar.i(this, view);
                z10 = zI && !zC;
                if (zI && !z10) {
                    break;
                }
            } else if (cVarF != null) {
                if (motionEventM == null) {
                    motionEventM = M(motionEvent);
                }
                T(cVarF, view, motionEventM, i10);
            }
        }
        list.clear();
        if (motionEventM != null) {
            motionEventM.recycle();
        }
        return zT;
    }

    public final void V() {
        this.f12886a.clear();
        this.f12887b.c();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            f fVarF = F(childAt);
            fVarF.d(this, childAt);
            this.f12887b.b(childAt);
            for (int i11 = 0; i11 < childCount; i11++) {
                if (i11 != i10) {
                    View childAt2 = getChildAt(i11);
                    if (fVarF.b(this, childAt, childAt2)) {
                        if (!this.f12887b.d(childAt2)) {
                            this.f12887b.b(childAt2);
                        }
                        this.f12887b.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f12886a.addAll(this.f12887b.j());
        Collections.reverse(this.f12886a);
    }

    public void W(View view, Rect rect) {
        ((f) view.getLayoutParams()).q(rect);
    }

    public void Y() {
        if (this.f12893h && this.f12897l != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f12897l);
        }
        this.f12898m = false;
    }

    public final void Z() {
        View view = this.f12895j;
        if (view != null) {
            c cVarF = ((f) view.getLayoutParams()).f();
            if (cVarF != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                cVarF.onTouchEvent(this, this.f12895j, motionEventObtain);
                motionEventObtain.recycle();
            }
            this.f12895j = null;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            ((f) getChildAt(i10).getLayoutParams()).m();
        }
        this.f12892g = false;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    public final void d0(View view, int i10) {
        f fVar = (f) view.getLayoutParams();
        int i11 = fVar.f12915i;
        if (i11 != i10) {
            N.S(view, i10 - i11);
            fVar.f12915i = i10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008f  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean drawChild(android.graphics.Canvas r17, android.view.View r18, long r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r2 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r2
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r3 = r2.f12907a
            if (r3 == 0) goto L8f
            float r3 = r3.getScrimOpacity(r0, r1)
            r4 = 0
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 <= 0) goto L8f
            android.graphics.Paint r4 = r0.f12889d
            if (r4 != 0) goto L22
            android.graphics.Paint r4 = new android.graphics.Paint
            r4.<init>()
            r0.f12889d = r4
        L22:
            android.graphics.Paint r4 = r0.f12889d
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r2 = r2.f12907a
            int r2 = r2.getScrimColor(r0, r1)
            r4.setColor(r2)
            android.graphics.Paint r2 = r0.f12889d
            r4 = 1132396544(0x437f0000, float:255.0)
            float r3 = r3 * r4
            int r3 = java.lang.Math.round(r3)
            r4 = 0
            r5 = 255(0xff, float:3.57E-43)
            int r3 = k(r3, r4, r5)
            r2.setAlpha(r3)
            int r2 = r17.save()
            boolean r3 = r1.isOpaque()
            if (r3 == 0) goto L65
            int r3 = r1.getLeft()
            float r5 = (float) r3
            int r3 = r1.getTop()
            float r6 = (float) r3
            int r3 = r1.getRight()
            float r7 = (float) r3
            int r3 = r1.getBottom()
            float r8 = (float) r3
            android.graphics.Region$Op r9 = android.graphics.Region.Op.DIFFERENCE
            r4 = r17
            r4.clipRect(r5, r6, r7, r8, r9)
        L65:
            int r3 = r0.getPaddingLeft()
            float r11 = (float) r3
            int r3 = r0.getPaddingTop()
            float r12 = (float) r3
            int r3 = r0.getWidth()
            int r4 = r0.getPaddingRight()
            int r3 = r3 - r4
            float r13 = (float) r3
            int r3 = r0.getHeight()
            int r4 = r0.getPaddingBottom()
            int r3 = r3 - r4
            float r14 = (float) r3
            android.graphics.Paint r15 = r0.f12889d
            r10 = r17
            r10.drawRect(r11, r12, r13, r14, r15)
            r4 = r10
            r4.restoreToCount(r2)
            goto L91
        L8f:
            r4 = r17
        L91:
            boolean r0 = super.drawChild(r17, r18, r19)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f12901p;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    public final void e0(View view, int i10) {
        f fVar = (f) view.getLayoutParams();
        int i11 = fVar.f12916j;
        if (i11 != i10) {
            N.T(view, i10 - i11);
            fVar.f12916j = i10;
        }
    }

    public final a0 f0(a0 a0Var) {
        if (B0.c.a(this.f12899n, a0Var)) {
            return a0Var;
        }
        this.f12899n = a0Var;
        boolean z10 = false;
        boolean z11 = a0Var != null && a0Var.m() > 0;
        this.f12900o = z11;
        if (!z11 && getBackground() == null) {
            z10 = true;
        }
        setWillNotDraw(z10);
        a0 a0VarM = m(a0Var);
        requestLayout();
        return a0VarM;
    }

    public final void g0() {
        if (!N.r(this)) {
            N.u0(this, null);
            return;
        }
        if (this.f12903r == null) {
            this.f12903r = new a();
        }
        N.u0(this, this.f12903r);
        setSystemUiVisibility(1280);
    }

    public final List<View> getDependencySortedChildren() {
        V();
        return Collections.unmodifiableList(this.f12886a);
    }

    public final a0 getLastWindowInsets() {
        return this.f12899n;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f12904s.a();
    }

    public Drawable getStatusBarBackground() {
        return this.f12901p;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public void i() {
        if (this.f12893h) {
            if (this.f12897l == null) {
                this.f12897l = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f12897l);
        }
        this.f12898m = true;
    }

    public final void j() {
        int childCount = getChildCount();
        MotionEvent motionEventObtain = null;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            c cVarF = ((f) childAt.getLayoutParams()).f();
            if (cVarF != null) {
                if (motionEventObtain == null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                cVarF.onInterceptTouchEvent(this, childAt, motionEventObtain);
            }
        }
        if (motionEventObtain != null) {
            motionEventObtain.recycle();
        }
    }

    public final void l(f fVar, Rect rect, int i10, int i11) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i10) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i11) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        rect.set(iMax, iMax2, i10 + iMax, i11 + iMax2);
    }

    public final a0 m(a0 a0Var) {
        c cVarF;
        if (a0Var.q()) {
            return a0Var;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (N.r(childAt) && (cVarF = ((f) childAt.getLayoutParams()).f()) != null) {
                a0Var = cVarF.onApplyWindowInsets(this, childAt, a0Var);
                if (a0Var.q()) {
                    return a0Var;
                }
            }
        }
        return a0Var;
    }

    public void n(View view) {
        ArrayList<View> arrayListH = this.f12887b.h(view);
        if (arrayListH == null || arrayListH.isEmpty()) {
            return;
        }
        for (int i10 = 0; i10 < arrayListH.size(); i10++) {
            View view2 = arrayListH.get(i10);
            c cVarF = ((f) view2.getLayoutParams()).f();
            if (cVarF != null) {
                cVarF.onDependentViewChanged(this, view2, view);
            }
        }
    }

    public void o() {
        int childCount = getChildCount();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            }
            if (H(getChildAt(i10))) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (z10 != this.f12898m) {
            if (z10) {
                i();
            } else {
                Y();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Z();
        if (this.f12898m) {
            if (this.f12897l == null) {
                this.f12897l = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f12897l);
        }
        if (this.f12899n == null && N.r(this)) {
            N.e0(this);
        }
        this.f12893h = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Z();
        if (this.f12898m && this.f12897l != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f12897l);
        }
        View view = this.f12896k;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f12893h = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f12900o || this.f12901p == null) {
            return;
        }
        a0 a0Var = this.f12899n;
        int iM = a0Var != null ? a0Var.m() : 0;
        if (iM > 0) {
            this.f12901p.setBounds(0, 0, getWidth(), iM);
            this.f12901p.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            Z();
        }
        boolean zU = U(motionEvent, 0);
        if (actionMasked != 1 && actionMasked != 3) {
            return zU;
        }
        this.f12895j = null;
        Z();
        return zU;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        c cVarF;
        int iU = N.u(this);
        int size = this.f12886a.size();
        for (int i14 = 0; i14 < size; i14++) {
            View view = this.f12886a.get(i14);
            if (view.getVisibility() != 8 && ((cVarF = ((f) view.getLayoutParams()).f()) == null || !cVarF.onLayoutChild(this, view, iU))) {
                Q(view, iU);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r27, int r28) {
        /*
            Method dump skipped, instructions count: 411
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0015  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onNestedFling(android.view.View r12, float r13, float r14, boolean r15) {
        /*
            r11 = this;
            int r0 = r11.getChildCount()
            r1 = 0
            r2 = r1
            r3 = r2
        L7:
            if (r2 >= r0) goto L40
            android.view.View r6 = r11.getChildAt(r2)
            int r4 = r6.getVisibility()
            r5 = 8
            if (r4 != r5) goto L1b
        L15:
            r5 = r11
            r7 = r12
            r8 = r13
            r9 = r14
            r10 = r15
            goto L38
        L1b:
            android.view.ViewGroup$LayoutParams r4 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r4 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r4
            boolean r5 = r4.j(r1)
            if (r5 != 0) goto L28
            goto L15
        L28:
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r4 = r4.f()
            if (r4 == 0) goto L15
            r5 = r11
            r7 = r12
            r8 = r13
            r9 = r14
            r10 = r15
            boolean r11 = r4.onNestedFling(r5, r6, r7, r8, r9, r10)
            r3 = r3 | r11
        L38:
            int r2 = r2 + 1
            r11 = r5
            r12 = r7
            r13 = r8
            r14 = r9
            r15 = r10
            goto L7
        L40:
            r5 = r11
            if (r3 == 0) goto L47
            r11 = 1
            r5.P(r11)
        L47:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onNestedFling(android.view.View, float, float, boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0015  */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onNestedPreFling(android.view.View r11, float r12, float r13) {
        /*
            r10 = this;
            int r0 = r10.getChildCount()
            r1 = 0
            r2 = r1
            r3 = r2
        L7:
            if (r2 >= r0) goto L3d
            android.view.View r6 = r10.getChildAt(r2)
            int r4 = r6.getVisibility()
            r5 = 8
            if (r4 != r5) goto L1a
        L15:
            r5 = r10
            r7 = r11
            r8 = r12
            r9 = r13
            goto L36
        L1a:
            android.view.ViewGroup$LayoutParams r4 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r4 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r4
            boolean r5 = r4.j(r1)
            if (r5 != 0) goto L27
            goto L15
        L27:
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r4 = r4.f()
            if (r4 == 0) goto L15
            r5 = r10
            r7 = r11
            r8 = r12
            r9 = r13
            boolean r10 = r4.onNestedPreFling(r5, r6, r7, r8, r9)
            r3 = r3 | r10
        L36:
            int r2 = r2 + 1
            r10 = r5
            r11 = r7
            r12 = r8
            r13 = r9
            goto L7
        L3d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onNestedPreFling(android.view.View, float, float):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        onNestedPreScroll(view, i10, i11, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        onNestedScroll(view, i10, i11, i12, i13, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        onNestedScrollAccepted(view, view2, i10, 0);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        SparseArray<Parcelable> sparseArray = savedState.behaviorStates;
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int id = childAt.getId();
            c cVarF = F(childAt).f();
            if (id != -1 && cVarF != null && (parcelable2 = sparseArray.get(id)) != null) {
                cVarF.onRestoreInstanceState(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int id = childAt.getId();
            c cVarF = ((f) childAt.getLayoutParams()).f();
            if (id != -1 && cVarF != null && (parcelableOnSaveInstanceState = cVarF.onSaveInstanceState(this, childAt)) != null) {
                sparseArray.append(id, parcelableOnSaveInstanceState);
            }
        }
        savedState.behaviorStates = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        return onStartNestedScroll(view, view2, i10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zU;
        int actionMasked = motionEvent.getActionMasked();
        View view = this.f12895j;
        boolean z10 = false;
        if (view != null) {
            c cVarF = ((f) view.getLayoutParams()).f();
            zU = cVarF != null ? cVarF.onTouchEvent(this, this.f12895j, motionEvent) : false;
        } else {
            zU = U(motionEvent, 1);
            if (actionMasked != 0 && zU) {
                z10 = true;
            }
        }
        if (this.f12895j == null || actionMasked == 3) {
            zU |= super.onTouchEvent(motionEvent);
        } else if (z10) {
            MotionEvent motionEventM = M(motionEvent);
            super.onTouchEvent(motionEventM);
            motionEventM.recycle();
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return zU;
        }
        this.f12895j = null;
        Z();
        return zU;
    }

    @Override // android.view.ViewGroup
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public f generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z10) {
        c cVarF = ((f) view.getLayoutParams()).f();
        if (cVarF == null || !cVarF.onRequestChildRectangleOnScreen(this, view, rect, z10)) {
            return super.requestChildRectangleOnScreen(view, rect, z10);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        super.requestDisallowInterceptTouchEvent(z10);
        if (!z10 || this.f12892g) {
            return;
        }
        if (this.f12895j == null) {
            j();
        }
        Z();
        this.f12892g = true;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z10) {
        super.setFitsSystemWindows(z10);
        g0();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f12902q = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f12901p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f12901p = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f12901p.setState(getDrawableState());
                }
                C5566a.m(this.f12901p, N.u(this));
                this.f12901p.setVisible(getVisibility() == 0, false);
                this.f12901p.setCallback(this);
            }
            N.Y(this);
        }
    }

    public void setStatusBarBackgroundColor(int i10) {
        setStatusBarBackground(new ColorDrawable(i10));
    }

    public void setStatusBarBackgroundResource(int i10) {
        setStatusBarBackground(i10 != 0 ? androidx.core.content.a.e(getContext(), i10) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.f12901p;
        if (drawable == null || drawable.isVisible() == z10) {
            return;
        }
        this.f12901p.setVisible(z10, false);
    }

    @Override // android.view.ViewGroup
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f12901p;
    }

    @Override // android.view.ViewGroup
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f ? new f((f) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    public void x(View view, boolean z10, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z10) {
            A(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public List<View> y(View view) {
        List<View> listI = this.f12887b.i(view);
        return listI == null ? Collections.EMPTY_LIST : listI;
    }

    public List<View> z(View view) {
        List<View> listG = this.f12887b.g(view);
        return listG == null ? Collections.EMPTY_LIST : listG;
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i10) {
        CoordinatorLayout coordinatorLayout;
        Context context2;
        super(context, attributeSet, i10);
        this.f12886a = new ArrayList();
        this.f12887b = new androidx.coordinatorlayout.widget.a<>();
        this.f12888c = new ArrayList();
        this.f12890e = new int[2];
        this.f12891f = new int[2];
        this.f12904s = new C1337z(this);
        TypedArray typedArrayObtainStyledAttributes = i10 == 0 ? context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout, 0, R$style.Widget_Support_CoordinatorLayout) : context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout, i10, 0);
        if (i10 == 0) {
            coordinatorLayout = this;
            context2 = context;
            N.g0(coordinatorLayout, context2, R$styleable.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, 0, R$style.Widget_Support_CoordinatorLayout);
        } else {
            coordinatorLayout = this;
            context2 = context;
            N.g0(coordinatorLayout, context2, R$styleable.CoordinatorLayout, attributeSet, typedArrayObtainStyledAttributes, i10, 0);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R$styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context2.getResources();
            coordinatorLayout.f12894i = resources.getIntArray(resourceId);
            float f10 = resources.getDisplayMetrics().density;
            int length = coordinatorLayout.f12894i.length;
            for (int i11 = 0; i11 < length; i11++) {
                coordinatorLayout.f12894i[i11] = (int) (r11[i11] * f10);
            }
        }
        coordinatorLayout.f12901p = typedArrayObtainStyledAttributes.getDrawable(R$styleable.CoordinatorLayout_statusBarBackground);
        typedArrayObtainStyledAttributes.recycle();
        coordinatorLayout.g0();
        super.setOnHierarchyChangeListener(coordinatorLayout.new e());
        if (N.s(coordinatorLayout) == 0) {
            N.r0(coordinatorLayout, 1);
        }
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr, int i12) {
        c cVarF;
        int childCount = getChildCount();
        boolean z10 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(i12) && (cVarF = fVar.f()) != null) {
                    int[] iArr2 = this.f12890e;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVarF.onNestedPreScroll(this, childAt, view, i10, i11, iArr2, i12);
                    iMax = i10 > 0 ? Math.max(iMax, this.f12890e[0]) : Math.min(iMax, this.f12890e[0]);
                    iMax2 = i11 > 0 ? Math.max(iMax2, this.f12890e[1]) : Math.min(iMax2, this.f12890e[1]);
                    z10 = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z10) {
            P(1);
        }
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14) {
        onNestedScroll(view, i10, i11, i12, i13, 0, this.f12891f);
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onNestedScrollAccepted(View view, View view2, int i10, int i11) {
        c cVarF;
        CoordinatorLayout coordinatorLayout;
        View view3;
        View view4;
        int i12;
        int i13;
        this.f12904s.c(view, view2, i10, i11);
        this.f12896k = view2;
        int childCount = getChildCount();
        int i14 = 0;
        while (i14 < childCount) {
            View childAt = this.getChildAt(i14);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.j(i11) && (cVarF = fVar.f()) != null) {
                coordinatorLayout = this;
                view3 = view;
                view4 = view2;
                i12 = i10;
                i13 = i11;
                cVarF.onNestedScrollAccepted(coordinatorLayout, childAt, view3, view4, i12, i13);
            } else {
                coordinatorLayout = this;
                view3 = view;
                view4 = view2;
                i12 = i10;
                i13 = i11;
            }
            i14++;
            this = coordinatorLayout;
            view = view3;
            view2 = view4;
            i10 = i12;
            i11 = i13;
        }
    }

    @Override // androidx.core.view.InterfaceC1335x
    public boolean onStartNestedScroll(View view, View view2, int i10, int i11) {
        int childCount = getChildCount();
        boolean z10 = false;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                c cVarF = fVar.f();
                if (cVarF != null) {
                    boolean zOnStartNestedScroll = cVarF.onStartNestedScroll(this, childAt, view, view2, i10, i11);
                    z10 |= zOnStartNestedScroll;
                    fVar.r(i11, zOnStartNestedScroll);
                } else {
                    fVar.r(i11, false);
                }
            }
        }
        return z10;
    }

    @Override // androidx.core.view.InterfaceC1335x
    public void onStopNestedScroll(View view, int i10) {
        this.f12904s.e(view, i10);
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.j(i10)) {
                c cVarF = fVar.f();
                if (cVarF != null) {
                    cVarF.onStopNestedScroll(this, childAt, view, i10);
                }
                fVar.l(i10);
                fVar.k();
            }
        }
        this.f12896k = null;
    }

    @Override // androidx.core.view.InterfaceC1336y
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        c cVarF;
        int iMin;
        int iMin2;
        int childCount = getChildCount();
        boolean z10 = false;
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(i14) && (cVarF = fVar.f()) != null) {
                    int[] iArr2 = this.f12890e;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVarF.onNestedScroll(this, childAt, view, i10, i11, i12, i13, i14, iArr2);
                    if (i12 > 0) {
                        iMin = Math.max(i15, this.f12890e[0]);
                    } else {
                        iMin = Math.min(i15, this.f12890e[0]);
                    }
                    i15 = iMin;
                    if (i13 > 0) {
                        iMin2 = Math.max(i16, this.f12890e[1]);
                    } else {
                        iMin2 = Math.min(i16, this.f12890e[1]);
                    }
                    i16 = iMin2;
                    z10 = true;
                }
            }
        }
        iArr[0] = iArr[0] + i15;
        iArr[1] = iArr[1] + i16;
        if (z10) {
            P(1);
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        SparseArray<Parcelable> behaviorStates;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int i10 = parcel.readInt();
            int[] iArr = new int[i10];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.behaviorStates = new SparseArray<>(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                this.behaviorStates.append(iArr[i11], parcelableArray[i11]);
            }
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            SparseArray<Parcelable> sparseArray = this.behaviorStates;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i11 = 0; i11 < size; i11++) {
                iArr[i11] = this.behaviorStates.keyAt(i11);
                parcelableArr[i11] = this.behaviorStates.valueAt(i11);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i10);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class f extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public c f12907a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f12908b;

        /* renamed from: c, reason: collision with root package name */
        public int f12909c;

        /* renamed from: d, reason: collision with root package name */
        public int f12910d;

        /* renamed from: e, reason: collision with root package name */
        public int f12911e;

        /* renamed from: f, reason: collision with root package name */
        public int f12912f;

        /* renamed from: g, reason: collision with root package name */
        public int f12913g;

        /* renamed from: h, reason: collision with root package name */
        public int f12914h;

        /* renamed from: i, reason: collision with root package name */
        public int f12915i;

        /* renamed from: j, reason: collision with root package name */
        public int f12916j;

        /* renamed from: k, reason: collision with root package name */
        public View f12917k;

        /* renamed from: l, reason: collision with root package name */
        public View f12918l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f12919m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f12920n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f12921o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f12922p;

        /* renamed from: q, reason: collision with root package name */
        public final Rect f12923q;

        /* renamed from: r, reason: collision with root package name */
        public Object f12924r;

        public f(int i10, int i11) {
            super(i10, i11);
            this.f12908b = false;
            this.f12909c = 0;
            this.f12910d = 0;
            this.f12911e = -1;
            this.f12912f = -1;
            this.f12913g = 0;
            this.f12914h = 0;
            this.f12923q = new Rect();
        }

        public boolean a() {
            return this.f12917k == null && this.f12912f != -1;
        }

        public boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 == this.f12918l || s(view2, N.u(coordinatorLayout))) {
                return true;
            }
            c cVar = this.f12907a;
            return cVar != null && cVar.layoutDependsOn(coordinatorLayout, view, view2);
        }

        public boolean c() {
            if (this.f12907a == null) {
                this.f12919m = false;
            }
            return this.f12919m;
        }

        public View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f12912f == -1) {
                this.f12918l = null;
                this.f12917k = null;
                return null;
            }
            if (this.f12917k == null || !t(view, coordinatorLayout)) {
                n(view, coordinatorLayout);
            }
            return this.f12917k;
        }

        public int e() {
            return this.f12912f;
        }

        public c f() {
            return this.f12907a;
        }

        public boolean g() {
            return this.f12922p;
        }

        public Rect h() {
            return this.f12923q;
        }

        public boolean i(CoordinatorLayout coordinatorLayout, View view) {
            boolean z10 = this.f12919m;
            if (z10) {
                return true;
            }
            c cVar = this.f12907a;
            boolean zBlocksInteractionBelow = (cVar != null ? cVar.blocksInteractionBelow(coordinatorLayout, view) : false) | z10;
            this.f12919m = zBlocksInteractionBelow;
            return zBlocksInteractionBelow;
        }

        public boolean j(int i10) {
            if (i10 == 0) {
                return this.f12920n;
            }
            if (i10 != 1) {
                return false;
            }
            return this.f12921o;
        }

        public void k() {
            this.f12922p = false;
        }

        public void l(int i10) {
            r(i10, false);
        }

        public void m() {
            this.f12919m = false;
        }

        public final void n(View view, CoordinatorLayout coordinatorLayout) {
            View viewFindViewById = coordinatorLayout.findViewById(this.f12912f);
            this.f12917k = viewFindViewById;
            if (viewFindViewById == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.f12918l = null;
                    this.f12917k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f12912f) + " to anchor view " + view);
            }
            if (viewFindViewById == coordinatorLayout) {
                if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                this.f12918l = null;
                this.f12917k = null;
                return;
            }
            for (ViewParent parent = viewFindViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    if (!coordinatorLayout.isInEditMode()) {
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    this.f12918l = null;
                    this.f12917k = null;
                    return;
                }
                if (parent instanceof View) {
                    viewFindViewById = parent;
                }
            }
            this.f12918l = viewFindViewById;
        }

        public void o(c cVar) {
            c cVar2 = this.f12907a;
            if (cVar2 != cVar) {
                if (cVar2 != null) {
                    cVar2.onDetachedFromLayoutParams();
                }
                this.f12907a = cVar;
                this.f12924r = null;
                this.f12908b = true;
                if (cVar != null) {
                    cVar.onAttachedToLayoutParams(this);
                }
            }
        }

        public void p(boolean z10) {
            this.f12922p = z10;
        }

        public void q(Rect rect) {
            this.f12923q.set(rect);
        }

        public void r(int i10, boolean z10) {
            if (i10 == 0) {
                this.f12920n = z10;
            } else {
                if (i10 != 1) {
                    return;
                }
                this.f12921o = z10;
            }
        }

        public final boolean s(View view, int i10) {
            int iB = C1321i.b(((f) view.getLayoutParams()).f12913g, i10);
            return iB != 0 && (C1321i.b(this.f12914h, i10) & iB) == iB;
        }

        public final boolean t(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f12917k.getId() != this.f12912f) {
                return false;
            }
            View view2 = this.f12917k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f12918l = null;
                    this.f12917k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
            this.f12918l = view2;
            return true;
        }

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f12908b = false;
            this.f12909c = 0;
            this.f12910d = 0;
            this.f12911e = -1;
            this.f12912f = -1;
            this.f12913g = 0;
            this.f12914h = 0;
            this.f12923q = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CoordinatorLayout_Layout);
            this.f12909c = typedArrayObtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f12912f = typedArrayObtainStyledAttributes.getResourceId(R$styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f12910d = typedArrayObtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f12911e = typedArrayObtainStyledAttributes.getInteger(R$styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f12913g = typedArrayObtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f12914h = typedArrayObtainStyledAttributes.getInt(R$styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            int i10 = R$styleable.CoordinatorLayout_Layout_layout_behavior;
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i10);
            this.f12908b = zHasValue;
            if (zHasValue) {
                this.f12907a = CoordinatorLayout.S(context, attributeSet, typedArrayObtainStyledAttributes.getString(i10));
            }
            typedArrayObtainStyledAttributes.recycle();
            c cVar = this.f12907a;
            if (cVar != null) {
                cVar.onAttachedToLayoutParams(this);
            }
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.f12908b = false;
            this.f12909c = 0;
            this.f12910d = 0;
            this.f12911e = -1;
            this.f12912f = -1;
            this.f12913g = 0;
            this.f12914h = 0;
            this.f12923q = new Rect();
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f12908b = false;
            this.f12909c = 0;
            this.f12910d = 0;
            this.f12911e = -1;
            this.f12912f = -1;
            this.f12913g = 0;
            this.f12914h = 0;
            this.f12923q = new Rect();
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f12908b = false;
            this.f12909c = 0;
            this.f12910d = 0;
            this.f12911e = -1;
            this.f12912f = -1;
            this.f12913g = 0;
            this.f12914h = 0;
            this.f12923q = new Rect();
        }
    }
}
