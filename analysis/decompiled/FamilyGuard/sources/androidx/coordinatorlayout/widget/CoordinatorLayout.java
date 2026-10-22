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
import androidx.core.view.C0464i;
import androidx.core.view.C0478x;
import androidx.core.view.H;
import androidx.core.view.InterfaceC0476v;
import androidx.core.view.InterfaceC0477w;
import androidx.core.view.InterfaceC0479y;
import androidx.core.view.Y;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import y.C1316a;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements InterfaceC0476v, InterfaceC0477w {

    /* renamed from: t, reason: collision with root package name */
    static final String f9399t;

    /* renamed from: u, reason: collision with root package name */
    static final Class<?>[] f9400u;

    /* renamed from: v, reason: collision with root package name */
    static final ThreadLocal<Map<String, Constructor<c>>> f9401v;

    /* renamed from: w, reason: collision with root package name */
    static final Comparator<View> f9402w;

    /* renamed from: x, reason: collision with root package name */
    private static final D.e<Rect> f9403x;

    /* renamed from: a, reason: collision with root package name */
    private final List<View> f9404a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.coordinatorlayout.widget.a<View> f9405b;

    /* renamed from: c, reason: collision with root package name */
    private final List<View> f9406c;

    /* renamed from: d, reason: collision with root package name */
    private Paint f9407d;

    /* renamed from: e, reason: collision with root package name */
    private final int[] f9408e;

    /* renamed from: f, reason: collision with root package name */
    private final int[] f9409f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f9410g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f9411h;

    /* renamed from: i, reason: collision with root package name */
    private int[] f9412i;

    /* renamed from: j, reason: collision with root package name */
    private View f9413j;

    /* renamed from: k, reason: collision with root package name */
    private View f9414k;

    /* renamed from: l, reason: collision with root package name */
    private g f9415l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f9416m;

    /* renamed from: n, reason: collision with root package name */
    private Y f9417n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f9418o;

    /* renamed from: p, reason: collision with root package name */
    private Drawable f9419p;

    /* renamed from: q, reason: collision with root package name */
    ViewGroup.OnHierarchyChangeListener f9420q;

    /* renamed from: r, reason: collision with root package name */
    private InterfaceC0479y f9421r;

    /* renamed from: s, reason: collision with root package name */
    private final C0478x f9422s;

    class a implements InterfaceC0479y {
        a() {
        }

        @Override // androidx.core.view.InterfaceC0479y
        public Y a(View view, Y y5) {
            return CoordinatorLayout.this.l0(y5);
        }
    }

    public interface b {
        c getBehavior();
    }

    public static abstract class c<V extends View> {
        public c() {
        }

        public static Object getTag(View view) {
            return ((f) view.getLayoutParams()).f9442r;
        }

        public static void setTag(View view, Object obj) {
            ((f) view.getLayoutParams()).f9442r = obj;
        }

        public boolean blocksInteractionBelow(CoordinatorLayout coordinatorLayout, V v5) {
            return getScrimOpacity(coordinatorLayout, v5) > 0.0f;
        }

        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, V v5, Rect rect) {
            return false;
        }

        public int getScrimColor(CoordinatorLayout coordinatorLayout, V v5) {
            return -16777216;
        }

        public float getScrimOpacity(CoordinatorLayout coordinatorLayout, V v5) {
            return 0.0f;
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, V v5, View view) {
            return false;
        }

        public Y onApplyWindowInsets(CoordinatorLayout coordinatorLayout, V v5, Y y5) {
            return y5;
        }

        public void onAttachedToLayoutParams(f fVar) {
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, V v5, View view) {
            return false;
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, V v5, View view) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v5, MotionEvent motionEvent) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v5, int i5) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v5, int i5, int i6, int i7, int i8) {
            return false;
        }

        public boolean onNestedFling(CoordinatorLayout coordinatorLayout, V v5, View view, float f5, float f6, boolean z5) {
            return false;
        }

        public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v5, View view, float f5, float f6) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v5, View view, int i5, int i6, int[] iArr) {
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v5, View view, int i5, int i6, int i7, int i8) {
        }

        @Deprecated
        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v5, View view, View view2, int i5) {
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, V v5, Rect rect, boolean z5) {
            return false;
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v5, Parcelable parcelable) {
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v5) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v5, View view, View view2, int i5) {
            return false;
        }

        @Deprecated
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v5, View view) {
        }

        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v5, MotionEvent motionEvent) {
            return false;
        }

        public c(Context context, AttributeSet attributeSet) {
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v5, View view, int i5, int i6, int[] iArr, int i7) {
            if (i7 == 0) {
                onNestedPreScroll(coordinatorLayout, v5, view, i5, i6, iArr);
            }
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v5, View view, int i5, int i6, int i7, int i8, int i9) {
            if (i9 == 0) {
                onNestedScroll(coordinatorLayout, v5, view, i5, i6, i7, i8);
            }
        }

        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v5, View view, View view2, int i5, int i6) {
            if (i6 == 0) {
                onNestedScrollAccepted(coordinatorLayout, v5, view, view2, i5);
            }
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v5, View view, View view2, int i5, int i6) {
            if (i6 == 0) {
                return onStartNestedScroll(coordinatorLayout, v5, view, view2, i5);
            }
            return false;
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v5, View view, int i5) {
            if (i5 == 0) {
                onStopNestedScroll(coordinatorLayout, v5, view);
            }
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v5, View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
            iArr[0] = iArr[0] + i7;
            iArr[1] = iArr[1] + i8;
            onNestedScroll(coordinatorLayout, v5, view, i5, i6, i7, i8, i9);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface d {
        Class<? extends c> value();
    }

    private class e implements ViewGroup.OnHierarchyChangeListener {
        e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f9420q;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.V(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f9420q;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    class g implements ViewTreeObserver.OnPreDrawListener {
        g() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.V(0);
            return true;
        }
    }

    static class i implements Comparator<View> {
        i() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float fL = H.L(view);
            float fL2 = H.L(view2);
            if (fL > fL2) {
                return -1;
            }
            return fL < fL2 ? 1 : 0;
        }
    }

    static {
        Package r02 = CoordinatorLayout.class.getPackage();
        f9399t = r02 != null ? r02.getName() : null;
        f9402w = new i();
        f9400u = new Class[]{Context.class, AttributeSet.class};
        f9401v = new ThreadLocal<>();
        f9403x = new D.g(12);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C1316a.f23893a);
    }

    private void I(int i5, Rect rect, Rect rect2, f fVar, int i6, int i7) {
        int iB = C0464i.b(g0(fVar.f9427c), i5);
        int iB2 = C0464i.b(h0(fVar.f9428d), i5);
        int i8 = iB & 7;
        int i9 = iB & 112;
        int i10 = iB2 & 7;
        int i11 = iB2 & 112;
        int iWidth = i10 != 1 ? i10 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int iHeight = i11 != 16 ? i11 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i8 == 1) {
            iWidth -= i6 / 2;
        } else if (i8 != 5) {
            iWidth -= i6;
        }
        if (i9 == 16) {
            iHeight -= i7 / 2;
        } else if (i9 != 80) {
            iHeight -= i7;
        }
        rect2.set(iWidth, iHeight, i6 + iWidth, i7 + iHeight);
    }

    private int J(int i5) {
        int[] iArr = this.f9412i;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i5);
            return 0;
        }
        if (i5 >= 0 && i5 < iArr.length) {
            return iArr[i5];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i5 + " out of range for " + this);
        return 0;
    }

    private void M(List<View> list) {
        list.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i5 = childCount - 1; i5 >= 0; i5--) {
            list.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i5) : i5));
        }
        Comparator<View> comparator = f9402w;
        if (comparator != null) {
            Collections.sort(list, comparator);
        }
    }

    private boolean N(View view) {
        return this.f9405b.k(view);
    }

    private void P(View view, int i5) {
        f fVar = (f) view.getLayoutParams();
        Rect rectG = g();
        rectG.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
        if (this.f9417n != null && H.u(this) && !H.u(view)) {
            rectG.left += this.f9417n.i();
            rectG.top += this.f9417n.k();
            rectG.right -= this.f9417n.j();
            rectG.bottom -= this.f9417n.h();
        }
        Rect rectG2 = g();
        C0464i.a(h0(fVar.f9427c), view.getMeasuredWidth(), view.getMeasuredHeight(), rectG, rectG2, i5);
        view.layout(rectG2.left, rectG2.top, rectG2.right, rectG2.bottom);
        d0(rectG);
        d0(rectG2);
    }

    private void Q(View view, View view2, int i5) {
        Rect rectG = g();
        Rect rectG2 = g();
        try {
            G(view2, rectG);
            H(view, i5, rectG, rectG2);
            view.layout(rectG2.left, rectG2.top, rectG2.right, rectG2.bottom);
        } finally {
            d0(rectG);
            d0(rectG2);
        }
    }

    private void R(View view, int i5, int i6) {
        f fVar = (f) view.getLayoutParams();
        int iB = C0464i.b(i0(fVar.f9427c), i6);
        int i7 = iB & 7;
        int i8 = iB & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i6 == 1) {
            i5 = width - i5;
        }
        int iJ = J(i5) - measuredWidth;
        if (i7 == 1) {
            iJ += measuredWidth / 2;
        } else if (i7 == 5) {
            iJ += measuredWidth;
        }
        int i9 = i8 != 16 ? i8 != 80 ? 0 : measuredHeight : measuredHeight / 2;
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(iJ, ((width - getPaddingRight()) - measuredWidth) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(i9, ((height - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth + iMax, measuredHeight + iMax2);
    }

    private MotionEvent S(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        return motionEventObtain;
    }

    private void T(View view, Rect rect, int i5) {
        boolean z5;
        boolean z6;
        int width;
        int i6;
        int i7;
        int i8;
        int height;
        int i9;
        int i10;
        int i11;
        if (H.Q(view) && view.getWidth() > 0 && view.getHeight() > 0) {
            f fVar = (f) view.getLayoutParams();
            c cVarF = fVar.f();
            Rect rectG = g();
            Rect rectG2 = g();
            rectG2.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (cVarF == null || !cVarF.getInsetDodgeRect(this, view, rectG)) {
                rectG.set(rectG2);
            } else if (!rectG2.contains(rectG)) {
                throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + rectG.toShortString() + " | Bounds:" + rectG2.toShortString());
            }
            d0(rectG2);
            if (rectG.isEmpty()) {
                d0(rectG);
                return;
            }
            int iB = C0464i.b(fVar.f9432h, i5);
            boolean z7 = true;
            if ((iB & 48) != 48 || (i10 = (rectG.top - ((ViewGroup.MarginLayoutParams) fVar).topMargin) - fVar.f9434j) >= (i11 = rect.top)) {
                z5 = false;
            } else {
                k0(view, i11 - i10);
                z5 = true;
            }
            if ((iB & 80) == 80 && (height = ((getHeight() - rectG.bottom) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) + fVar.f9434j) < (i9 = rect.bottom)) {
                k0(view, height - i9);
                z5 = true;
            }
            if (!z5) {
                k0(view, 0);
            }
            if ((iB & 3) != 3 || (i7 = (rectG.left - ((ViewGroup.MarginLayoutParams) fVar).leftMargin) - fVar.f9433i) >= (i8 = rect.left)) {
                z6 = false;
            } else {
                j0(view, i8 - i7);
                z6 = true;
            }
            if ((iB & 5) != 5 || (width = ((getWidth() - rectG.right) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin) + fVar.f9433i) >= (i6 = rect.right)) {
                z7 = z6;
            } else {
                j0(view, width - i6);
            }
            if (!z7) {
                j0(view, 0);
            }
            d0(rectG);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static c Y(Context context, AttributeSet attributeSet, String str) throws NoSuchMethodException, SecurityException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(".")) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0) {
            String str2 = f9399t;
            if (!TextUtils.isEmpty(str2)) {
                str = str2 + '.' + str;
            }
        }
        try {
            ThreadLocal<Map<String, Constructor<c>>> threadLocal = f9401v;
            Map<String, Constructor<c>> map = threadLocal.get();
            if (map == null) {
                map = new HashMap<>();
                threadLocal.set(map);
            }
            Constructor<c> constructor = map.get(str);
            if (constructor == null) {
                constructor = Class.forName(str, false, context.getClassLoader()).getConstructor(f9400u);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return constructor.newInstance(context, attributeSet);
        } catch (Exception e6) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e6);
        }
    }

    private boolean Z(c cVar, View view, MotionEvent motionEvent, int i5) {
        if (i5 == 0) {
            return cVar.onInterceptTouchEvent(this, view, motionEvent);
        }
        if (i5 == 1) {
            return cVar.onTouchEvent(this, view, motionEvent);
        }
        throw new IllegalArgumentException();
    }

    private boolean a0(MotionEvent motionEvent, int i5) {
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f9406c;
        M(list);
        int size = list.size();
        MotionEvent motionEventS = null;
        boolean Z5 = false;
        boolean z5 = false;
        for (int i6 = 0; i6 < size; i6++) {
            View view = list.get(i6);
            f fVar = (f) view.getLayoutParams();
            c cVarF = fVar.f();
            if (!(Z5 || z5) || actionMasked == 0) {
                if (!z5 && !Z5 && cVarF != null && (Z5 = Z(cVarF, view, motionEvent, i5))) {
                    this.f9413j = view;
                    if (actionMasked != 3 && actionMasked != 1) {
                        for (int i7 = 0; i7 < i6; i7++) {
                            View view2 = list.get(i7);
                            c cVarF2 = ((f) view2.getLayoutParams()).f();
                            if (cVarF2 != null) {
                                if (motionEventS == null) {
                                    motionEventS = S(motionEvent);
                                }
                                Z(cVarF2, view2, motionEventS, i5);
                            }
                        }
                    }
                }
                boolean zC = fVar.c();
                boolean zI = fVar.i(this, view);
                z5 = zI && !zC;
                if (zI && !z5) {
                    break;
                }
            } else if (cVarF != null) {
                if (motionEventS == null) {
                    motionEventS = S(motionEvent);
                }
                Z(cVarF, view, motionEventS, i5);
            }
        }
        list.clear();
        if (motionEventS != null) {
            motionEventS.recycle();
        }
        return Z5;
    }

    private void b0() {
        this.f9404a.clear();
        this.f9405b.c();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            f fVarL = L(childAt);
            fVarL.d(this, childAt);
            this.f9405b.b(childAt);
            for (int i6 = 0; i6 < childCount; i6++) {
                if (i6 != i5) {
                    View childAt2 = getChildAt(i6);
                    if (fVarL.b(this, childAt, childAt2)) {
                        if (!this.f9405b.d(childAt2)) {
                            this.f9405b.b(childAt2);
                        }
                        this.f9405b.a(childAt2, childAt);
                    }
                }
            }
        }
        this.f9404a.addAll(this.f9405b.j());
        Collections.reverse(this.f9404a);
    }

    private static void d0(Rect rect) {
        rect.setEmpty();
        f9403x.a(rect);
    }

    private void f0() {
        View view = this.f9413j;
        if (view != null) {
            c cVarF = ((f) view.getLayoutParams()).f();
            if (cVarF != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                cVarF.onTouchEvent(this, this.f9413j, motionEventObtain);
                motionEventObtain.recycle();
            }
            this.f9413j = null;
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            ((f) getChildAt(i5).getLayoutParams()).m();
        }
        this.f9410g = false;
    }

    private static Rect g() {
        Rect rectB = f9403x.b();
        return rectB == null ? new Rect() : rectB;
    }

    private static int g0(int i5) {
        if (i5 == 0) {
            return 17;
        }
        return i5;
    }

    private static int h0(int i5) {
        if ((i5 & 7) == 0) {
            i5 |= 8388611;
        }
        return (i5 & 112) == 0 ? i5 | 48 : i5;
    }

    private static int i0(int i5) {
        if (i5 == 0) {
            return 8388661;
        }
        return i5;
    }

    private void j0(View view, int i5) {
        f fVar = (f) view.getLayoutParams();
        int i6 = fVar.f9433i;
        if (i6 != i5) {
            H.U(view, i5 - i6);
            fVar.f9433i = i5;
        }
    }

    private void k0(View view, int i5) {
        f fVar = (f) view.getLayoutParams();
        int i6 = fVar.f9434j;
        if (i6 != i5) {
            H.V(view, i5 - i6);
            fVar.f9434j = i5;
        }
    }

    private void m0() {
        if (!H.u(this)) {
            H.w0(this, null);
            return;
        }
        if (this.f9421r == null) {
            this.f9421r = new a();
        }
        H.w0(this, this.f9421r);
        setSystemUiVisibility(1280);
    }

    private void q() {
        int childCount = getChildCount();
        MotionEvent motionEventObtain = null;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
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

    private static int v(int i5, int i6, int i7) {
        return i5 < i6 ? i6 : i5 > i7 ? i7 : i5;
    }

    private void w(f fVar, Rect rect, int i5, int i6) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i5) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i6) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        rect.set(iMax, iMax2, i5 + iMax, i6 + iMax2);
    }

    private Y x(Y y5) {
        c cVarF;
        if (y5.n()) {
            return y5;
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (H.u(childAt) && (cVarF = ((f) childAt.getLayoutParams()).f()) != null) {
                y5 = cVarF.onApplyWindowInsets(this, childAt, y5);
                if (y5.n()) {
                    return y5;
                }
            }
        }
        return y5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public f generateDefaultLayoutParams() {
        return new f(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f ? new f((f) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    void D(View view, boolean z5, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z5) {
            G(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public List<View> E(View view) {
        List<View> listI = this.f9405b.i(view);
        return listI == null ? Collections.EMPTY_LIST : listI;
    }

    public List<View> F(View view) {
        List<View> listG = this.f9405b.g(view);
        return listG == null ? Collections.EMPTY_LIST : listG;
    }

    void G(View view, Rect rect) {
        androidx.coordinatorlayout.widget.b.a(this, view, rect);
    }

    void H(View view, int i5, Rect rect, Rect rect2) {
        f fVar = (f) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        I(i5, rect, rect2, fVar, measuredWidth, measuredHeight);
        w(fVar, rect2, measuredWidth, measuredHeight);
    }

    void K(View view, Rect rect) {
        rect.set(((f) view.getLayoutParams()).h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    f L(View view) {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.f9426b) {
            if (view instanceof b) {
                c behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                fVar.o(behavior);
                fVar.f9426b = true;
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
                } catch (Exception e6) {
                    Log.e("CoordinatorLayout", "Default behavior class " + dVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e6);
                }
            }
            fVar.f9426b = true;
        }
        return fVar;
    }

    public boolean O(View view, int i5, int i6) {
        Rect rectG = g();
        G(view, rectG);
        try {
            return rectG.contains(i5, i6);
        } finally {
            d0(rectG);
        }
    }

    void U(View view, int i5) {
        c cVarF;
        f fVar = (f) view.getLayoutParams();
        if (fVar.f9435k != null) {
            Rect rectG = g();
            Rect rectG2 = g();
            Rect rectG3 = g();
            G(fVar.f9435k, rectG);
            D(view, false, rectG2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            I(i5, rectG, rectG3, fVar, measuredWidth, measuredHeight);
            boolean z5 = (rectG3.left == rectG2.left && rectG3.top == rectG2.top) ? false : true;
            w(fVar, rectG3, measuredWidth, measuredHeight);
            int i6 = rectG3.left - rectG2.left;
            int i7 = rectG3.top - rectG2.top;
            if (i6 != 0) {
                H.U(view, i6);
            }
            if (i7 != 0) {
                H.V(view, i7);
            }
            if (z5 && (cVarF = fVar.f()) != null) {
                cVarF.onDependentViewChanged(this, view, fVar.f9435k);
            }
            d0(rectG);
            d0(rectG2);
            d0(rectG3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void V(int r18) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.V(int):void");
    }

    public void W(View view, int i5) {
        f fVar = (f) view.getLayoutParams();
        if (fVar.a()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        View view2 = fVar.f9435k;
        if (view2 != null) {
            Q(view, view2, i5);
            return;
        }
        int i6 = fVar.f9429e;
        if (i6 >= 0) {
            R(view, i6, i5);
        } else {
            P(view, i5);
        }
    }

    public void X(View view, int i5, int i6, int i7, int i8) {
        measureChildWithMargins(view, i5, i6, i7, i8);
    }

    void c0(View view, Rect rect) {
        ((f) view.getLayoutParams()).q(rect);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008f  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected boolean drawChild(android.graphics.Canvas r17, android.view.View r18, long r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r2 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r2
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r3 = r2.f9425a
            if (r3 == 0) goto L8f
            float r3 = r3.getScrimOpacity(r0, r1)
            r4 = 0
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 <= 0) goto L8f
            android.graphics.Paint r4 = r0.f9407d
            if (r4 != 0) goto L22
            android.graphics.Paint r4 = new android.graphics.Paint
            r4.<init>()
            r0.f9407d = r4
        L22:
            android.graphics.Paint r4 = r0.f9407d
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r2 = r2.f9425a
            int r2 = r2.getScrimColor(r0, r1)
            r4.setColor(r2)
            android.graphics.Paint r2 = r0.f9407d
            r4 = 1132396544(0x437f0000, float:255.0)
            float r3 = r3 * r4
            int r3 = java.lang.Math.round(r3)
            r4 = 0
            r5 = 255(0xff, float:3.57E-43)
            int r3 = v(r3, r4, r5)
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
            android.graphics.Paint r15 = r0.f9407d
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
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f9419p;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    void e0() {
        if (this.f9411h && this.f9415l != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f9415l);
        }
        this.f9416m = false;
    }

    final List<View> getDependencySortedChildren() {
        b0();
        return Collections.unmodifiableList(this.f9404a);
    }

    public final Y getLastWindowInsets() {
        return this.f9417n;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f9422s.a();
    }

    public Drawable getStatusBarBackground() {
        return this.f9419p;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // androidx.core.view.InterfaceC0477w
    public void j(View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
        c cVarF;
        int childCount = getChildCount();
        boolean z5 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(i9) && (cVarF = fVar.f()) != null) {
                    int[] iArr2 = this.f9408e;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVarF.onNestedScroll(this, childAt, view, i5, i6, i7, i8, i9, iArr2);
                    iMax = i7 > 0 ? Math.max(iMax, this.f9408e[0]) : Math.min(iMax, this.f9408e[0]);
                    iMax2 = i8 > 0 ? Math.max(iMax2, this.f9408e[1]) : Math.min(iMax2, this.f9408e[1]);
                    z5 = true;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + iMax2;
        if (z5) {
            V(1);
        }
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void k(View view, int i5, int i6, int i7, int i8, int i9) {
        j(view, i5, i6, i7, i8, 0, this.f9409f);
    }

    @Override // androidx.core.view.InterfaceC0476v
    public boolean l(View view, View view2, int i5, int i6) {
        int childCount = getChildCount();
        boolean z5 = false;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                c cVarF = fVar.f();
                if (cVarF != null) {
                    boolean zOnStartNestedScroll = cVarF.onStartNestedScroll(this, childAt, view, view2, i5, i6);
                    z5 |= zOnStartNestedScroll;
                    fVar.r(i6, zOnStartNestedScroll);
                } else {
                    fVar.r(i6, false);
                }
            }
        }
        return z5;
    }

    final Y l0(Y y5) {
        if (D.c.a(this.f9417n, y5)) {
            return y5;
        }
        this.f9417n = y5;
        boolean z5 = false;
        boolean z6 = y5 != null && y5.k() > 0;
        this.f9418o = z6;
        if (!z6 && getBackground() == null) {
            z5 = true;
        }
        setWillNotDraw(z5);
        Y yX = x(y5);
        requestLayout();
        return yX;
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void m(View view, View view2, int i5, int i6) {
        c cVarF;
        CoordinatorLayout coordinatorLayout;
        View view3;
        View view4;
        int i7;
        int i8;
        this.f9422s.c(view, view2, i5, i6);
        this.f9414k = view2;
        int childCount = getChildCount();
        int i9 = 0;
        while (i9 < childCount) {
            View childAt = this.getChildAt(i9);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.j(i6) && (cVarF = fVar.f()) != null) {
                coordinatorLayout = this;
                view3 = view;
                view4 = view2;
                i7 = i5;
                i8 = i6;
                cVarF.onNestedScrollAccepted(coordinatorLayout, childAt, view3, view4, i7, i8);
            } else {
                coordinatorLayout = this;
                view3 = view;
                view4 = view2;
                i7 = i5;
                i8 = i6;
            }
            i9++;
            this = coordinatorLayout;
            view = view3;
            view2 = view4;
            i5 = i7;
            i6 = i8;
        }
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void n(View view, int i5) {
        this.f9422s.e(view, i5);
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.j(i5)) {
                c cVarF = fVar.f();
                if (cVarF != null) {
                    cVarF.onStopNestedScroll(this, childAt, view, i5);
                }
                fVar.l(i5);
                fVar.k();
            }
        }
        this.f9414k = null;
    }

    @Override // androidx.core.view.InterfaceC0476v
    public void o(View view, int i5, int i6, int[] iArr, int i7) {
        c cVarF;
        int childCount = getChildCount();
        boolean z5 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.j(i7) && (cVarF = fVar.f()) != null) {
                    int[] iArr2 = this.f9408e;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVarF.onNestedPreScroll(this, childAt, view, i5, i6, iArr2, i7);
                    iMax = i5 > 0 ? Math.max(iMax, this.f9408e[0]) : Math.min(iMax, this.f9408e[0]);
                    iMax2 = i6 > 0 ? Math.max(iMax2, this.f9408e[1]) : Math.min(iMax2, this.f9408e[1]);
                    z5 = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z5) {
            V(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        f0();
        if (this.f9416m) {
            if (this.f9415l == null) {
                this.f9415l = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f9415l);
        }
        if (this.f9417n == null && H.u(this)) {
            H.g0(this);
        }
        this.f9411h = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f0();
        if (this.f9416m && this.f9415l != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f9415l);
        }
        View view = this.f9414k;
        if (view != null) {
            onStopNestedScroll(view);
        }
        this.f9411h = false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f9418o || this.f9419p == null) {
            return;
        }
        Y y5 = this.f9417n;
        int iK = y5 != null ? y5.k() : 0;
        if (iK > 0) {
            this.f9419p.setBounds(0, 0, getWidth(), iK);
            this.f9419p.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            f0();
        }
        boolean zA0 = a0(motionEvent, 0);
        if (actionMasked != 1 && actionMasked != 3) {
            return zA0;
        }
        this.f9413j = null;
        f0();
        return zA0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        c cVarF;
        int iX = H.x(this);
        int size = this.f9404a.size();
        for (int i9 = 0; i9 < size; i9++) {
            View view = this.f9404a.get(i9);
            if (view.getVisibility() != 8 && ((cVarF = ((f) view.getLayoutParams()).f()) == null || !cVarF.onLayoutChild(this, view, iX))) {
                W(view, iX);
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
    protected void onMeasure(int r27, int r28) {
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
            r5.V(r11)
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
    public void onNestedPreScroll(View view, int i5, int i6, int[] iArr) {
        o(view, i5, i6, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i5, int i6, int i7, int i8) {
        k(view, i5, i6, i7, i8, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i5) {
        m(view, view2, i5, 0);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof h)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        h hVar = (h) parcelable;
        super.onRestoreInstanceState(hVar.getSuperState());
        SparseArray<Parcelable> sparseArray = hVar.f9444a;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            int id = childAt.getId();
            c cVarF = L(childAt).f();
            if (id != -1 && cVarF != null && (parcelable2 = sparseArray.get(id)) != null) {
                cVarF.onRestoreInstanceState(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState;
        h hVar = new h(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            int id = childAt.getId();
            c cVarF = ((f) childAt.getLayoutParams()).f();
            if (id != -1 && cVarF != null && (parcelableOnSaveInstanceState = cVarF.onSaveInstanceState(this, childAt)) != null) {
                sparseArray.append(id, parcelableOnSaveInstanceState);
            }
        }
        hVar.f9444a = sparseArray;
        return hVar;
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
        boolean zA0;
        int actionMasked = motionEvent.getActionMasked();
        View view = this.f9413j;
        boolean z5 = false;
        if (view != null) {
            c cVarF = ((f) view.getLayoutParams()).f();
            zA0 = cVarF != null ? cVarF.onTouchEvent(this, this.f9413j, motionEvent) : false;
        } else {
            zA0 = a0(motionEvent, 1);
            if (actionMasked != 0 && zA0) {
                z5 = true;
            }
        }
        if (this.f9413j == null || actionMasked == 3) {
            zA0 |= super.onTouchEvent(motionEvent);
        } else if (z5) {
            MotionEvent motionEventS = S(motionEvent);
            super.onTouchEvent(motionEventS);
            motionEventS.recycle();
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return zA0;
        }
        this.f9413j = null;
        f0();
        return zA0;
    }

    void p() {
        if (this.f9411h) {
            if (this.f9415l == null) {
                this.f9415l = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f9415l);
        }
        this.f9416m = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z5) {
        c cVarF = ((f) view.getLayoutParams()).f();
        if (cVarF == null || !cVarF.onRequestChildRectangleOnScreen(this, view, rect, z5)) {
            return super.requestChildRectangleOnScreen(view, rect, z5);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z5) {
        super.requestDisallowInterceptTouchEvent(z5);
        if (!z5 || this.f9410g) {
            return;
        }
        if (this.f9413j == null) {
            q();
        }
        f0();
        this.f9410g = true;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z5) {
        super.setFitsSystemWindows(z5);
        m0();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f9420q = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f9419p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f9419p = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f9419p.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.m(this.f9419p, H.x(this));
                this.f9419p.setVisible(getVisibility() == 0, false);
                this.f9419p.setCallback(this);
            }
            H.a0(this);
        }
    }

    public void setStatusBarBackgroundColor(int i5) {
        setStatusBarBackground(new ColorDrawable(i5));
    }

    public void setStatusBarBackgroundResource(int i5) {
        setStatusBarBackground(i5 != 0 ? androidx.core.content.a.e(getContext(), i5) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i5) {
        super.setVisibility(i5);
        boolean z5 = i5 == 0;
        Drawable drawable = this.f9419p;
        if (drawable == null || drawable.isVisible() == z5) {
            return;
        }
        this.f9419p.setVisible(z5, false);
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f9419p;
    }

    public void y(View view) {
        ArrayList<View> arrayListH = this.f9405b.h(view);
        if (arrayListH == null || arrayListH.isEmpty()) {
            return;
        }
        for (int i5 = 0; i5 < arrayListH.size(); i5++) {
            View view2 = arrayListH.get(i5);
            c cVarF = ((f) view2.getLayoutParams()).f();
            if (cVarF != null) {
                cVarF.onDependentViewChanged(this, view2, view);
            }
        }
    }

    void z() {
        int childCount = getChildCount();
        boolean z5 = false;
        int i5 = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            }
            if (N(getChildAt(i5))) {
                z5 = true;
                break;
            }
            i5++;
        }
        if (z5 != this.f9416m) {
            if (z5) {
                p();
            } else {
                e0();
            }
        }
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i5) {
        CoordinatorLayout coordinatorLayout;
        Context context2;
        super(context, attributeSet, i5);
        this.f9404a = new ArrayList();
        this.f9405b = new androidx.coordinatorlayout.widget.a<>();
        this.f9406c = new ArrayList();
        this.f9408e = new int[2];
        this.f9409f = new int[2];
        this.f9422s = new C0478x(this);
        TypedArray typedArrayObtainStyledAttributes = i5 == 0 ? context.obtainStyledAttributes(attributeSet, y.c.f23895a, 0, y.b.f23894a) : context.obtainStyledAttributes(attributeSet, y.c.f23895a, i5, 0);
        if (i5 == 0) {
            coordinatorLayout = this;
            context2 = context;
            H.i0(coordinatorLayout, context2, y.c.f23895a, attributeSet, typedArrayObtainStyledAttributes, 0, y.b.f23894a);
        } else {
            coordinatorLayout = this;
            context2 = context;
            H.i0(coordinatorLayout, context2, y.c.f23895a, attributeSet, typedArrayObtainStyledAttributes, i5, 0);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(y.c.f23896b, 0);
        if (resourceId != 0) {
            Resources resources = context2.getResources();
            coordinatorLayout.f9412i = resources.getIntArray(resourceId);
            float f5 = resources.getDisplayMetrics().density;
            int length = coordinatorLayout.f9412i.length;
            for (int i6 = 0; i6 < length; i6++) {
                coordinatorLayout.f9412i[i6] = (int) (r11[i6] * f5);
            }
        }
        coordinatorLayout.f9419p = typedArrayObtainStyledAttributes.getDrawable(y.c.f23897c);
        typedArrayObtainStyledAttributes.recycle();
        coordinatorLayout.m0();
        super.setOnHierarchyChangeListener(coordinatorLayout.new e());
        if (H.v(coordinatorLayout) == 0) {
            H.t0(coordinatorLayout, 1);
        }
    }

    protected static class h extends androidx.customview.view.a {
        public static final Parcelable.Creator<h> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        SparseArray<Parcelable> f9444a;

        class a implements Parcelable.ClassLoaderCreator<h> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel) {
                return new h(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public h createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new h(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public h[] newArray(int i5) {
                return new h[i5];
            }
        }

        public h(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int i5 = parcel.readInt();
            int[] iArr = new int[i5];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.f9444a = new SparseArray<>(i5);
            for (int i6 = 0; i6 < i5; i6++) {
                this.f9444a.append(iArr[i6], parcelableArray[i6]);
            }
        }

        @Override // androidx.customview.view.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            SparseArray<Parcelable> sparseArray = this.f9444a;
            int size = sparseArray != null ? sparseArray.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i6 = 0; i6 < size; i6++) {
                iArr[i6] = this.f9444a.keyAt(i6);
                parcelableArr[i6] = this.f9444a.valueAt(i6);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i5);
        }

        public h(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class f extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        c f9425a;

        /* renamed from: b, reason: collision with root package name */
        boolean f9426b;

        /* renamed from: c, reason: collision with root package name */
        public int f9427c;

        /* renamed from: d, reason: collision with root package name */
        public int f9428d;

        /* renamed from: e, reason: collision with root package name */
        public int f9429e;

        /* renamed from: f, reason: collision with root package name */
        int f9430f;

        /* renamed from: g, reason: collision with root package name */
        public int f9431g;

        /* renamed from: h, reason: collision with root package name */
        public int f9432h;

        /* renamed from: i, reason: collision with root package name */
        int f9433i;

        /* renamed from: j, reason: collision with root package name */
        int f9434j;

        /* renamed from: k, reason: collision with root package name */
        View f9435k;

        /* renamed from: l, reason: collision with root package name */
        View f9436l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f9437m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f9438n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f9439o;

        /* renamed from: p, reason: collision with root package name */
        private boolean f9440p;

        /* renamed from: q, reason: collision with root package name */
        final Rect f9441q;

        /* renamed from: r, reason: collision with root package name */
        Object f9442r;

        public f(int i5, int i6) {
            super(i5, i6);
            this.f9426b = false;
            this.f9427c = 0;
            this.f9428d = 0;
            this.f9429e = -1;
            this.f9430f = -1;
            this.f9431g = 0;
            this.f9432h = 0;
            this.f9441q = new Rect();
        }

        private void n(View view, CoordinatorLayout coordinatorLayout) {
            View viewFindViewById = coordinatorLayout.findViewById(this.f9430f);
            this.f9435k = viewFindViewById;
            if (viewFindViewById == null) {
                if (coordinatorLayout.isInEditMode()) {
                    this.f9436l = null;
                    this.f9435k = null;
                    return;
                }
                throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f9430f) + " to anchor view " + view);
            }
            if (viewFindViewById == coordinatorLayout) {
                if (!coordinatorLayout.isInEditMode()) {
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                this.f9436l = null;
                this.f9435k = null;
                return;
            }
            for (ViewParent parent = viewFindViewById.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                if (parent == view) {
                    if (!coordinatorLayout.isInEditMode()) {
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    this.f9436l = null;
                    this.f9435k = null;
                    return;
                }
                if (parent instanceof View) {
                    viewFindViewById = parent;
                }
            }
            this.f9436l = viewFindViewById;
        }

        private boolean s(View view, int i5) {
            int iB = C0464i.b(((f) view.getLayoutParams()).f9431g, i5);
            return iB != 0 && (C0464i.b(this.f9432h, i5) & iB) == iB;
        }

        private boolean t(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f9435k.getId() != this.f9430f) {
                return false;
            }
            View view2 = this.f9435k;
            for (ViewParent parent = view2.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f9436l = null;
                    this.f9435k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
            this.f9436l = view2;
            return true;
        }

        boolean a() {
            return this.f9435k == null && this.f9430f != -1;
        }

        boolean b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 == this.f9436l || s(view2, H.x(coordinatorLayout))) {
                return true;
            }
            c cVar = this.f9425a;
            return cVar != null && cVar.layoutDependsOn(coordinatorLayout, view, view2);
        }

        boolean c() {
            if (this.f9425a == null) {
                this.f9437m = false;
            }
            return this.f9437m;
        }

        View d(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f9430f == -1) {
                this.f9436l = null;
                this.f9435k = null;
                return null;
            }
            if (this.f9435k == null || !t(view, coordinatorLayout)) {
                n(view, coordinatorLayout);
            }
            return this.f9435k;
        }

        public int e() {
            return this.f9430f;
        }

        public c f() {
            return this.f9425a;
        }

        boolean g() {
            return this.f9440p;
        }

        Rect h() {
            return this.f9441q;
        }

        boolean i(CoordinatorLayout coordinatorLayout, View view) {
            boolean z5 = this.f9437m;
            if (z5) {
                return true;
            }
            c cVar = this.f9425a;
            boolean zBlocksInteractionBelow = (cVar != null ? cVar.blocksInteractionBelow(coordinatorLayout, view) : false) | z5;
            this.f9437m = zBlocksInteractionBelow;
            return zBlocksInteractionBelow;
        }

        boolean j(int i5) {
            if (i5 == 0) {
                return this.f9438n;
            }
            if (i5 != 1) {
                return false;
            }
            return this.f9439o;
        }

        void k() {
            this.f9440p = false;
        }

        void l(int i5) {
            r(i5, false);
        }

        void m() {
            this.f9437m = false;
        }

        public void o(c cVar) {
            c cVar2 = this.f9425a;
            if (cVar2 != cVar) {
                if (cVar2 != null) {
                    cVar2.onDetachedFromLayoutParams();
                }
                this.f9425a = cVar;
                this.f9442r = null;
                this.f9426b = true;
                if (cVar != null) {
                    cVar.onAttachedToLayoutParams(this);
                }
            }
        }

        void p(boolean z5) {
            this.f9440p = z5;
        }

        void q(Rect rect) {
            this.f9441q.set(rect);
        }

        void r(int i5, boolean z5) {
            if (i5 == 0) {
                this.f9438n = z5;
            } else {
                if (i5 != 1) {
                    return;
                }
                this.f9439o = z5;
            }
        }

        f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f9426b = false;
            this.f9427c = 0;
            this.f9428d = 0;
            this.f9429e = -1;
            this.f9430f = -1;
            this.f9431g = 0;
            this.f9432h = 0;
            this.f9441q = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y.c.f23898d);
            this.f9427c = typedArrayObtainStyledAttributes.getInteger(y.c.f23899e, 0);
            this.f9430f = typedArrayObtainStyledAttributes.getResourceId(y.c.f23900f, -1);
            this.f9428d = typedArrayObtainStyledAttributes.getInteger(y.c.f23901g, 0);
            this.f9429e = typedArrayObtainStyledAttributes.getInteger(y.c.f23905k, -1);
            this.f9431g = typedArrayObtainStyledAttributes.getInt(y.c.f23904j, 0);
            this.f9432h = typedArrayObtainStyledAttributes.getInt(y.c.f23903i, 0);
            int i5 = y.c.f23902h;
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i5);
            this.f9426b = zHasValue;
            if (zHasValue) {
                this.f9425a = CoordinatorLayout.Y(context, attributeSet, typedArrayObtainStyledAttributes.getString(i5));
            }
            typedArrayObtainStyledAttributes.recycle();
            c cVar = this.f9425a;
            if (cVar != null) {
                cVar.onAttachedToLayoutParams(this);
            }
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.f9426b = false;
            this.f9427c = 0;
            this.f9428d = 0;
            this.f9429e = -1;
            this.f9430f = -1;
            this.f9431g = 0;
            this.f9432h = 0;
            this.f9441q = new Rect();
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f9426b = false;
            this.f9427c = 0;
            this.f9428d = 0;
            this.f9429e = -1;
            this.f9430f = -1;
            this.f9431g = 0;
            this.f9432h = 0;
            this.f9441q = new Rect();
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f9426b = false;
            this.f9427c = 0;
            this.f9428d = 0;
            this.f9429e = -1;
            this.f9430f = -1;
            this.f9431g = 0;
            this.f9432h = 0;
            this.f9441q = new Rect();
        }
    }
}
