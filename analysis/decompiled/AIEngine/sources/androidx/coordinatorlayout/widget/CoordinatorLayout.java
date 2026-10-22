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
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.customview.view.AbsSavedState;
import com.stepos.aiengine.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import v0.e0;
import v0.h0;
import v0.m0;
import v0.o;
import v0.p;
import v0.q;
import v0.r;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements o, p {
    public static final h A;
    public static final u0.d B;

    /* renamed from: x, reason: collision with root package name */
    public static final String f1434x;

    /* renamed from: y, reason: collision with root package name */
    public static final Class<?>[] f1435y;
    public static final ThreadLocal<Map<String, Constructor<c>>> z;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1436a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.coordinatorlayout.widget.a f1437b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f1438c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f1439d;

    /* renamed from: e, reason: collision with root package name */
    public Paint f1440e;
    public final int[] h;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f1441j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1442k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1443l;

    /* renamed from: m, reason: collision with root package name */
    public final int[] f1444m;

    /* renamed from: n, reason: collision with root package name */
    public View f1445n;

    /* renamed from: o, reason: collision with root package name */
    public View f1446o;

    /* renamed from: p, reason: collision with root package name */
    public g f1447p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1448q;
    public m0 r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f1449s;

    /* renamed from: t, reason: collision with root package name */
    public Drawable f1450t;

    /* renamed from: u, reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f1451u;

    /* renamed from: v, reason: collision with root package name */
    public a f1452v;

    /* renamed from: w, reason: collision with root package name */
    public final q f1453w;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements r {
        public a() {
        }

        @Override // v0.r
        public final m0 g(View view, m0 m0Var) {
            c cVar;
            CoordinatorLayout coordinatorLayout = CoordinatorLayout.this;
            if (!Objects.equals(coordinatorLayout.r, m0Var)) {
                coordinatorLayout.r = m0Var;
                boolean z = m0Var.d() > 0;
                coordinatorLayout.f1449s = z;
                coordinatorLayout.setWillNotDraw(!z && coordinatorLayout.getBackground() == null);
                if (!m0Var.f13309a.n()) {
                    int childCount = coordinatorLayout.getChildCount();
                    for (int i10 = 0; i10 < childCount; i10++) {
                        View childAt = coordinatorLayout.getChildAt(i10);
                        WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                        if (childAt.getFitsSystemWindows() && (cVar = ((f) childAt.getLayoutParams()).f1456a) != null) {
                            m0Var = cVar.onApplyWindowInsets(coordinatorLayout, childAt, m0Var);
                            if (m0Var.f13309a.n()) {
                                break;
                            }
                        }
                    }
                }
                coordinatorLayout.requestLayout();
            }
            return m0Var;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface b {
        c getBehavior();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class c<V extends View> {
        public c() {
        }

        public static Object getTag(View view) {
            return ((f) view.getLayoutParams()).r;
        }

        public static void setTag(View view, Object obj) {
            ((f) view.getLayoutParams()).r = obj;
        }

        public boolean blocksInteractionBelow(CoordinatorLayout coordinatorLayout, V v3) {
            return getScrimOpacity(coordinatorLayout, v3) > 0.0f;
        }

        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, V v3, Rect rect) {
            return false;
        }

        public int getScrimColor(CoordinatorLayout coordinatorLayout, V v3) {
            return -16777216;
        }

        public float getScrimOpacity(CoordinatorLayout coordinatorLayout, V v3) {
            return 0.0f;
        }

        public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, V v3, View view) {
            return false;
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, V v3, View view) {
            return false;
        }

        public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v3, MotionEvent motionEvent) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v3, int i10) {
            return false;
        }

        public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v3, int i10, int i11, int i12, int i13) {
            return false;
        }

        public boolean onNestedFling(CoordinatorLayout coordinatorLayout, V v3, View view, float f8, float f9, boolean z) {
            return false;
        }

        public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v3, View view, float f8, float f9) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v3, View view, int i10, int i11, int[] iArr) {
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v3, View view, int i10, int i11, int i12, int i13) {
        }

        @Deprecated
        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v3, View view, View view2, int i10) {
        }

        public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, V v3, Rect rect, boolean z) {
            return false;
        }

        public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v3) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v3, View view, View view2, int i10) {
            return false;
        }

        @Deprecated
        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v3, View view) {
        }

        public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v3, MotionEvent motionEvent) {
            return false;
        }

        public c(Context context, AttributeSet attributeSet) {
        }

        public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v3, View view, int i10, int i11, int[] iArr, int i12) {
            if (i12 == 0) {
                onNestedPreScroll(coordinatorLayout, v3, view, i10, i11, iArr);
            }
        }

        @Deprecated
        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v3, View view, int i10, int i11, int i12, int i13, int i14) {
            if (i14 == 0) {
                onNestedScroll(coordinatorLayout, v3, view, i10, i11, i12, i13);
            }
        }

        public void onNestedScrollAccepted(CoordinatorLayout coordinatorLayout, V v3, View view, View view2, int i10, int i11) {
            if (i11 == 0) {
                onNestedScrollAccepted(coordinatorLayout, v3, view, view2, i10);
            }
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v3, View view, View view2, int i10, int i11) {
            if (i11 == 0) {
                return onStartNestedScroll(coordinatorLayout, v3, view, view2, i10);
            }
            return false;
        }

        public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v3, View view, int i10) {
            if (i10 == 0) {
                onStopNestedScroll(coordinatorLayout, v3, view);
            }
        }

        public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v3, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
            iArr[0] = iArr[0] + i12;
            iArr[1] = iArr[1] + i13;
            onNestedScroll(coordinatorLayout, v3, view, i10, i11, i12, i13, i14);
        }

        public void onDetachedFromLayoutParams() {
        }

        public void onAttachedToLayoutParams(f fVar) {
        }

        public m0 onApplyWindowInsets(CoordinatorLayout coordinatorLayout, V v3, m0 m0Var) {
            return m0Var;
        }

        public void onDependentViewRemoved(CoordinatorLayout coordinatorLayout, V v3, View view) {
        }

        public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v3, Parcelable parcelable) {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface d {
        Class<? extends c> value();
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class e implements ViewGroup.OnHierarchyChangeListener {
        public e() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewAdded(View view, View view2) {
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = CoordinatorLayout.this.f1451u;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout coordinatorLayout = CoordinatorLayout.this;
            coordinatorLayout.A(2);
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = coordinatorLayout.f1451u;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class g implements ViewTreeObserver.OnPreDrawListener {
        public g() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            CoordinatorLayout.this.A(0);
            return true;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class h implements Comparator<View> {
        @Override // java.util.Comparator
        public final int compare(View view, View view2) {
            WeakHashMap<View, h0> weakHashMap = e0.f13274a;
            float f8 = e0.d.f(view);
            float f9 = e0.d.f(view2);
            if (f8 > f9) {
                return -1;
            }
            return f8 < f9 ? 1 : 0;
        }
    }

    static {
        Package r02 = CoordinatorLayout.class.getPackage();
        f1434x = r02 != null ? r02.getName() : null;
        A = new h();
        f1435y = new Class[]{Context.class, AttributeSet.class};
        z = new ThreadLocal<>();
        B = new u0.d();
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.coordinatorLayoutStyle);
    }

    public static void F(Rect rect) {
        rect.setEmpty();
        B.release(rect);
    }

    public static void H(int i10, View view) {
        f fVar = (f) view.getLayoutParams();
        int i11 = fVar.f1463i;
        if (i11 != i10) {
            WeakHashMap<View, h0> weakHashMap = e0.f13274a;
            view.offsetLeftAndRight(i10 - i11);
            fVar.f1463i = i10;
        }
    }

    public static void I(int i10, View view) {
        f fVar = (f) view.getLayoutParams();
        int i11 = fVar.f1464j;
        if (i11 != i10) {
            WeakHashMap<View, h0> weakHashMap = e0.f13274a;
            view.offsetTopAndBottom(i10 - i11);
            fVar.f1464j = i10;
        }
    }

    public static Rect s() {
        Rect rect = (Rect) B.acquire();
        return rect == null ? new Rect() : rect;
    }

    public static void w(int i10, Rect rect, Rect rect2, f fVar, int i11, int i12) {
        int i13 = fVar.f1458c;
        if (i13 == 0) {
            i13 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i13, i10);
        int i14 = fVar.f1459d;
        if ((i14 & 7) == 0) {
            i14 |= 8388611;
        }
        if ((i14 & 112) == 0) {
            i14 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i14, i10);
        int i15 = absoluteGravity & 7;
        int i16 = absoluteGravity & 112;
        int i17 = absoluteGravity2 & 7;
        int i18 = absoluteGravity2 & 112;
        int iWidth = i17 != 1 ? i17 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int iHeight = i18 != 16 ? i18 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i15 == 1) {
            iWidth -= i11 / 2;
        } else if (i15 != 5) {
            iWidth -= i11;
        }
        if (i16 == 16) {
            iHeight -= i12 / 2;
        } else if (i16 != 80) {
            iHeight -= i12;
        }
        rect2.set(iWidth, iHeight, i11 + iWidth, i12 + iHeight);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static f y(View view) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        f fVar = (f) view.getLayoutParams();
        if (!fVar.f1457b) {
            if (view instanceof b) {
                c behavior = ((b) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                c cVar = fVar.f1456a;
                if (cVar != behavior) {
                    if (cVar != null) {
                        cVar.onDetachedFromLayoutParams();
                    }
                    fVar.f1456a = behavior;
                    fVar.r = null;
                    fVar.f1457b = true;
                    if (behavior != null) {
                        behavior.onAttachedToLayoutParams(fVar);
                    }
                }
                fVar.f1457b = true;
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
                    c cVarNewInstance = dVar.value().getDeclaredConstructor(null).newInstance(null);
                    c cVar2 = fVar.f1456a;
                    if (cVar2 != cVarNewInstance) {
                        if (cVar2 != null) {
                            cVar2.onDetachedFromLayoutParams();
                        }
                        fVar.f1456a = cVarNewInstance;
                        fVar.r = null;
                        fVar.f1457b = true;
                        if (cVarNewInstance != null) {
                            cVarNewInstance.onAttachedToLayoutParams(fVar);
                        }
                    }
                } catch (Exception e10) {
                    Log.e("CoordinatorLayout", "Default behavior class " + dVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e10);
                }
            }
            fVar.f1457b = true;
        }
        return fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A(int r23) {
        /*
            Method dump skipped, instructions count: 755
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.A(int):void");
    }

    public final void B(int i10, View view) {
        Rect rectS;
        Rect rectS2;
        f fVar = (f) view.getLayoutParams();
        View view2 = fVar.f1465k;
        if (view2 == null && fVar.f1461f != -1) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        u0.d dVar = B;
        if (view2 != null) {
            rectS = s();
            rectS2 = s();
            try {
                androidx.coordinatorlayout.widget.b.a(this, view2, rectS);
                f fVar2 = (f) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                w(i10, rectS, rectS2, fVar2, measuredWidth, measuredHeight);
                t(fVar2, rectS2, measuredWidth, measuredHeight);
                view.layout(rectS2.left, rectS2.top, rectS2.right, rectS2.bottom);
                return;
            } finally {
                rectS.setEmpty();
                dVar.release(rectS);
                rectS2.setEmpty();
                dVar.release(rectS2);
            }
        }
        int i11 = fVar.f1460e;
        if (i11 < 0) {
            f fVar3 = (f) view.getLayoutParams();
            rectS = s();
            rectS.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar3).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar3).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) fVar3).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) fVar3).bottomMargin);
            if (this.r != null) {
                WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                if (getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                    rectS.left = this.r.b() + rectS.left;
                    rectS.top = this.r.d() + rectS.top;
                    rectS.right -= this.r.c();
                    rectS.bottom -= this.r.a();
                }
            }
            rectS2 = s();
            int i12 = fVar3.f1458c;
            if ((i12 & 7) == 0) {
                i12 |= 8388611;
            }
            if ((i12 & 112) == 0) {
                i12 |= 48;
            }
            Gravity.apply(i12, view.getMeasuredWidth(), view.getMeasuredHeight(), rectS, rectS2, i10);
            view.layout(rectS2.left, rectS2.top, rectS2.right, rectS2.bottom);
            return;
        }
        f fVar4 = (f) view.getLayoutParams();
        int i13 = fVar4.f1458c;
        if (i13 == 0) {
            i13 = 8388661;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i13, i10);
        int i14 = absoluteGravity & 7;
        int i15 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth2 = view.getMeasuredWidth();
        int measuredHeight2 = view.getMeasuredHeight();
        if (i10 == 1) {
            i11 = width - i11;
        }
        int iX = x(i11) - measuredWidth2;
        if (i14 == 1) {
            iX += measuredWidth2 / 2;
        } else if (i14 == 5) {
            iX += measuredWidth2;
        }
        int i16 = i15 != 16 ? i15 != 80 ? 0 : measuredHeight2 : measuredHeight2 / 2;
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar4).leftMargin, Math.min(iX, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) fVar4).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar4).topMargin, Math.min(i16, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) fVar4).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth2 + iMax, measuredHeight2 + iMax2);
    }

    public final void C(View view, int i10, int i11, int i12, int i13) {
        measureChildWithMargins(view, i10, i11, i12, i13);
    }

    public final boolean D(MotionEvent motionEvent, int i10) {
        boolean zBlocksInteractionBelow;
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.f1438c;
        arrayList.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i11 = childCount - 1; i11 >= 0; i11--) {
            arrayList.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i11) : i11));
        }
        h hVar = A;
        if (hVar != null) {
            Collections.sort(arrayList, hVar);
        }
        int size = arrayList.size();
        MotionEvent motionEventObtain = null;
        boolean zOnInterceptTouchEvent = false;
        boolean z3 = false;
        for (int i12 = 0; i12 < size; i12++) {
            View view = (View) arrayList.get(i12);
            f fVar = (f) view.getLayoutParams();
            c cVar = fVar.f1456a;
            if (!(zOnInterceptTouchEvent || z3) || actionMasked == 0) {
                if (!zOnInterceptTouchEvent && cVar != null) {
                    if (i10 == 0) {
                        zOnInterceptTouchEvent = cVar.onInterceptTouchEvent(this, view, motionEvent);
                    } else if (i10 == 1) {
                        zOnInterceptTouchEvent = cVar.onTouchEvent(this, view, motionEvent);
                    }
                    if (zOnInterceptTouchEvent) {
                        this.f1445n = view;
                    }
                }
                c cVar2 = fVar.f1456a;
                if (cVar2 == null) {
                    fVar.f1467m = false;
                }
                boolean z10 = fVar.f1467m;
                if (z10) {
                    zBlocksInteractionBelow = true;
                } else {
                    zBlocksInteractionBelow = (cVar2 != null ? cVar2.blocksInteractionBelow(this, view) : false) | z10;
                    fVar.f1467m = zBlocksInteractionBelow;
                }
                boolean z11 = zBlocksInteractionBelow && !z10;
                if (zBlocksInteractionBelow && !z11) {
                    break;
                }
                z3 = z11;
            } else if (cVar != null) {
                if (motionEventObtain == null) {
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                }
                if (i10 == 0) {
                    cVar.onInterceptTouchEvent(this, view, motionEventObtain);
                } else if (i10 == 1) {
                    cVar.onTouchEvent(this, view, motionEventObtain);
                }
            }
        }
        arrayList.clear();
        return zOnInterceptTouchEvent;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0106  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E() throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.E():void");
    }

    public final void G(boolean z3) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            c cVar = ((f) childAt.getLayoutParams()).f1456a;
            if (cVar != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z3) {
                    cVar.onInterceptTouchEvent(this, childAt, motionEventObtain);
                } else {
                    cVar.onTouchEvent(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            ((f) getChildAt(i11).getLayoutParams()).f1467m = false;
        }
        this.f1445n = null;
        this.f1442k = false;
    }

    public final void J() {
        WeakHashMap<View, h0> weakHashMap = e0.f13274a;
        if (!getFitsSystemWindows()) {
            e0.d.k(this, null);
            return;
        }
        if (this.f1452v == null) {
            this.f1452v = new a();
        }
        e0.d.k(this, this.f1452v);
        setSystemUiVisibility(1280);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0091  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean drawChild(android.graphics.Canvas r17, android.view.View r18, long r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            android.view.ViewGroup$LayoutParams r2 = r1.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r2 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r2
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r3 = r2.f1456a
            if (r3 == 0) goto L91
            float r3 = r3.getScrimOpacity(r0, r1)
            r4 = 0
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 <= 0) goto L91
            android.graphics.Paint r4 = r0.f1440e
            if (r4 != 0) goto L22
            android.graphics.Paint r4 = new android.graphics.Paint
            r4.<init>()
            r0.f1440e = r4
        L22:
            android.graphics.Paint r4 = r0.f1440e
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r2 = r2.f1456a
            int r2 = r2.getScrimColor(r0, r1)
            r4.setColor(r2)
            android.graphics.Paint r2 = r0.f1440e
            r4 = 1132396544(0x437f0000, float:255.0)
            float r3 = r3 * r4
            int r3 = java.lang.Math.round(r3)
            if (r3 >= 0) goto L3a
            r3 = 0
            goto L3f
        L3a:
            r4 = 255(0xff, float:3.57E-43)
            if (r3 <= r4) goto L3f
            r3 = r4
        L3f:
            r2.setAlpha(r3)
            int r2 = r17.save()
            boolean r3 = r1.isOpaque()
            if (r3 == 0) goto L67
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
        L67:
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
            android.graphics.Paint r15 = r0.f1440e
            r10 = r17
            r10.drawRect(r11, r12, r13, r14, r15)
            r4 = r10
            r4.restoreToCount(r2)
            goto L93
        L91:
            r4 = r17
        L93:
            boolean r0 = super.drawChild(r17, r18, r19)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f1450t;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    public final List<View> getDependencySortedChildren() throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        E();
        return Collections.unmodifiableList(this.f1436a);
    }

    public final m0 getLastWindowInsets() {
        return this.r;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        q qVar = this.f1453w;
        return qVar.f13333b | qVar.f13332a;
    }

    public Drawable getStatusBarBackground() {
        return this.f1450t;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    @Override // v0.o
    public final void h(int i10, View view) {
        q qVar = this.f1453w;
        if (i10 == 1) {
            qVar.f13333b = 0;
        } else {
            qVar.f13332a = 0;
        }
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.a(i10)) {
                c cVar = fVar.f1456a;
                if (cVar != null) {
                    cVar.onStopNestedScroll(this, childAt, view, i10);
                }
                if (i10 == 0) {
                    fVar.f1468n = false;
                } else if (i10 == 1) {
                    fVar.f1469o = false;
                }
                fVar.f1470p = false;
            }
        }
        this.f1446o = null;
    }

    @Override // v0.o
    public final void i(View view, View view2, int i10, int i11) {
        c cVar;
        CoordinatorLayout coordinatorLayout;
        View view3;
        View view4;
        int i12;
        int i13;
        q qVar = this.f1453w;
        if (i11 == 1) {
            qVar.f13333b = i10;
        } else {
            qVar.f13332a = i10;
        }
        this.f1446o = view2;
        int childCount = getChildCount();
        int i14 = 0;
        while (i14 < childCount) {
            View childAt = this.getChildAt(i14);
            f fVar = (f) childAt.getLayoutParams();
            if (fVar.a(i11) && (cVar = fVar.f1456a) != null) {
                coordinatorLayout = this;
                view3 = view;
                view4 = view2;
                i12 = i10;
                i13 = i11;
                cVar.onNestedScrollAccepted(coordinatorLayout, childAt, view3, view4, i12, i13);
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

    @Override // v0.o
    public void j(View view, int i10, int i11, int[] iArr, int i12) {
        c cVar;
        int childCount = getChildCount();
        boolean z3 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(i12) && (cVar = fVar.f1456a) != null) {
                    int[] iArr2 = this.h;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVar.onNestedPreScroll(this, childAt, view, i10, i11, iArr2, i12);
                    iMax = i10 > 0 ? Math.max(iMax, iArr2[0]) : Math.min(iMax, iArr2[0]);
                    iMax2 = i11 > 0 ? Math.max(iMax2, iArr2[1]) : Math.min(iMax2, iArr2[1]);
                    z3 = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z3) {
            A(1);
        }
    }

    @Override // v0.p
    public final void k(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        c cVar;
        int childCount = getChildCount();
        boolean z3 = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (fVar.a(i14) && (cVar = fVar.f1456a) != null) {
                    int[] iArr2 = this.h;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    cVar.onNestedScroll(this, childAt, view, i10, i11, i12, i13, i14, iArr2);
                    int[] iArr3 = this.h;
                    iMax = i12 > 0 ? Math.max(iMax, iArr3[0]) : Math.min(iMax, iArr3[0]);
                    iMax2 = i13 > 0 ? Math.max(iMax2, iArr3[1]) : Math.min(iMax2, iArr3[1]);
                    z3 = true;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + iMax2;
        if (z3) {
            A(1);
        }
    }

    @Override // v0.o
    public final void l(View view, int i10, int i11, int i12, int i13, int i14) {
        k(view, i10, i11, i12, i13, 0, this.f1441j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        G(false);
        if (this.f1448q) {
            if (this.f1447p == null) {
                this.f1447p = new g();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f1447p);
        }
        if (this.r == null) {
            WeakHashMap<View, h0> weakHashMap = e0.f13274a;
            if (getFitsSystemWindows()) {
                e0.c.b(this);
            }
        }
        this.f1443l = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        G(false);
        if (this.f1448q && this.f1447p != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f1447p);
        }
        View view = this.f1446o;
        if (view != null) {
            h(0, view);
        }
        this.f1443l = false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f1449s || this.f1450t == null) {
            return;
        }
        m0 m0Var = this.r;
        int iD = m0Var != null ? m0Var.d() : 0;
        if (iD > 0) {
            this.f1450t.setBounds(0, 0, getWidth(), iD);
            this.f1450t.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            G(true);
        }
        boolean zD = D(motionEvent, 0);
        if (actionMasked != 1 && actionMasked != 3) {
            return zD;
        }
        G(true);
        return zD;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z3, int i10, int i11, int i12, int i13) {
        c cVar;
        WeakHashMap<View, h0> weakHashMap = e0.f13274a;
        int layoutDirection = getLayoutDirection();
        ArrayList arrayList = this.f1436a;
        int size = arrayList.size();
        for (int i14 = 0; i14 < size; i14++) {
            View view = (View) arrayList.get(i14);
            if (view.getVisibility() != 8 && ((cVar = ((f) view.getLayoutParams()).f1456a) == null || !cVar.onLayoutChild(this, view, layoutDirection))) {
                B(layoutDirection, view);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0195  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r28, int r29) throws java.lang.IllegalAccessException, java.lang.InstantiationException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 516
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
    public final boolean onNestedFling(android.view.View r12, float r13, float r14, boolean r15) {
        /*
            r11 = this;
            int r0 = r11.getChildCount()
            r1 = 0
            r2 = r1
            r3 = r2
        L7:
            if (r2 >= r0) goto L3e
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
            goto L36
        L1b:
            android.view.ViewGroup$LayoutParams r4 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r4 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r4
            boolean r5 = r4.a(r1)
            if (r5 != 0) goto L28
            goto L15
        L28:
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r4 = r4.f1456a
            if (r4 == 0) goto L15
            r5 = r11
            r7 = r12
            r8 = r13
            r9 = r14
            r10 = r15
            boolean r11 = r4.onNestedFling(r5, r6, r7, r8, r9, r10)
            r3 = r3 | r11
        L36:
            int r2 = r2 + 1
            r11 = r5
            r12 = r7
            r13 = r8
            r14 = r9
            r15 = r10
            goto L7
        L3e:
            r5 = r11
            if (r3 == 0) goto L45
            r11 = 1
            r5.A(r11)
        L45:
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
    public final boolean onNestedPreFling(android.view.View r11, float r12, float r13) {
        /*
            r10 = this;
            int r0 = r10.getChildCount()
            r1 = 0
            r2 = r1
            r3 = r2
        L7:
            if (r2 >= r0) goto L3b
            android.view.View r6 = r10.getChildAt(r2)
            int r4 = r6.getVisibility()
            r5 = 8
            if (r4 != r5) goto L1a
        L15:
            r5 = r10
            r7 = r11
            r8 = r12
            r9 = r13
            goto L34
        L1a:
            android.view.ViewGroup$LayoutParams r4 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r4 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r4
            boolean r5 = r4.a(r1)
            if (r5 != 0) goto L27
            goto L15
        L27:
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r4 = r4.f1456a
            if (r4 == 0) goto L15
            r5 = r10
            r7 = r11
            r8 = r12
            r9 = r13
            boolean r10 = r4.onNestedPreFling(r5, r6, r7, r8, r9)
            r3 = r3 | r10
        L34:
            int r2 = r2 + 1
            r10 = r5
            r11 = r7
            r12 = r8
            r13 = r9
            goto L7
        L3b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onNestedPreFling(android.view.View, float, float):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
        j(view, i10, i11, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        l(view, i10, i11, i12, i13, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i10) {
        i(view, view2, i10, 0);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
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
            int id2 = childAt.getId();
            c cVar = y(childAt).f1456a;
            if (id2 != -1 && cVar != null && (parcelable2 = sparseArray.get(id2)) != null) {
                cVar.onRestoreInstanceState(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            int id2 = childAt.getId();
            c cVar = ((f) childAt.getLayoutParams()).f1456a;
            if (id2 != -1 && cVar != null && (parcelableOnSaveInstanceState = cVar.onSaveInstanceState(this, childAt)) != null) {
                sparseArray.append(id2, parcelableOnSaveInstanceState);
            }
        }
        savedState.behaviorStates = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i10) {
        return p(view, view2, i10, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        h(0, view);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015 A[PHI: r3
      0x0015: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:10:0x0022, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r1.getActionMasked()
            android.view.View r3 = r0.f1445n
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.D(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = r5
            goto L2a
        L17:
            r3 = r5
        L18:
            android.view.View r6 = r0.f1445n
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            androidx.coordinatorlayout.widget.CoordinatorLayout$f r6 = (androidx.coordinatorlayout.widget.CoordinatorLayout.f) r6
            androidx.coordinatorlayout.widget.CoordinatorLayout$c r6 = r6.f1456a
            if (r6 == 0) goto L15
            android.view.View r7 = r0.f1445n
            boolean r6 = r6.onTouchEvent(r0, r7, r1)
        L2a:
            android.view.View r7 = r0.f1445n
            r8 = 0
            if (r7 != 0) goto L35
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L48
        L35:
            if (r3 == 0) goto L48
            long r9 = android.os.SystemClock.uptimeMillis()
            r15 = 0
            r16 = 0
            r13 = 3
            r14 = 0
            r11 = r9
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L48:
            if (r8 == 0) goto L4d
            r8.recycle()
        L4d:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L53
            goto L54
        L53:
            return r6
        L54:
            r0.G(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // v0.o
    public final boolean p(View view, View view2, int i10, int i11) {
        int childCount = getChildCount();
        boolean z3 = false;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                c cVar = fVar.f1456a;
                if (cVar != null) {
                    boolean zOnStartNestedScroll = cVar.onStartNestedScroll(this, childAt, view, view2, i10, i11);
                    z3 |= zOnStartNestedScroll;
                    if (i11 == 0) {
                        fVar.f1468n = zOnStartNestedScroll;
                    } else if (i11 == 1) {
                        fVar.f1469o = zOnStartNestedScroll;
                    }
                } else if (i11 == 0) {
                    fVar.f1468n = false;
                } else if (i11 == 1) {
                    fVar.f1469o = false;
                }
            }
        }
        return z3;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z3) {
        c cVar = ((f) view.getLayoutParams()).f1456a;
        if (cVar == null || !cVar.onRequestChildRectangleOnScreen(this, view, rect, z3)) {
            return super.requestChildRectangleOnScreen(view, rect, z3);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z3) {
        super.requestDisallowInterceptTouchEvent(z3);
        if (!z3 || this.f1442k) {
            return;
        }
        G(false);
        this.f1442k = true;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z3) {
        super.setFitsSystemWindows(z3);
        J();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f1451u = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f1450t;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f1450t = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f1450t.setState(getDrawableState());
                }
                Drawable drawable3 = this.f1450t;
                WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                drawable3.setLayoutDirection(getLayoutDirection());
                this.f1450t.setVisible(getVisibility() == 0, false);
                this.f1450t.setCallback(this);
            }
            WeakHashMap<View, h0> weakHashMap2 = e0.f13274a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarBackgroundColor(int i10) {
        setStatusBarBackground(new ColorDrawable(i10));
    }

    public void setStatusBarBackgroundResource(int i10) {
        setStatusBarBackground(i10 != 0 ? getContext().getDrawable(i10) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z3 = i10 == 0;
        Drawable drawable = this.f1450t;
        if (drawable == null || drawable.isVisible() == z3) {
            return;
        }
        this.f1450t.setVisible(z3, false);
    }

    public final void t(f fVar, Rect rect, int i10, int i11) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) fVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i10) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) fVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i11) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin));
        rect.set(iMax, iMax2, i10 + iMax, i11 + iMax2);
    }

    public final void u(View view, Rect rect, boolean z3) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z3) {
            androidx.coordinatorlayout.widget.b.a(this, view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public final ArrayList v(View view) {
        p.o oVar = (p.o) this.f1437b.f1475c;
        int i10 = oVar.f11385c;
        ArrayList arrayList = null;
        for (int i11 = 0; i11 < i10; i11++) {
            ArrayList arrayList2 = (ArrayList) oVar.j(i11);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(oVar.g(i11));
            }
        }
        ArrayList arrayList3 = this.f1439d;
        arrayList3.clear();
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        return arrayList3;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1450t;
    }

    public final int x(int i10) {
        int[] iArr = this.f1444m;
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

    public final boolean z(View view, int i10, int i11) {
        Rect rectS = s();
        androidx.coordinatorlayout.widget.b.a(this, view, rectS);
        try {
            return rectS.contains(i10, i11);
        } finally {
            F(rectS);
        }
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        CoordinatorLayout coordinatorLayout;
        Context context2;
        super(context, attributeSet, i10);
        this.f1436a = new ArrayList();
        androidx.coordinatorlayout.widget.a aVar = new androidx.coordinatorlayout.widget.a();
        aVar.f1474b = new l5.a(10);
        aVar.f1475c = new p.o();
        aVar.f1476d = new ArrayList();
        aVar.f1473a = new HashSet();
        this.f1437b = aVar;
        this.f1438c = new ArrayList();
        this.f1439d = new ArrayList();
        this.h = new int[2];
        this.f1441j = new int[2];
        this.f1453w = new q();
        int[] iArr = k0.a.f9832a;
        TypedArray typedArrayObtainStyledAttributes = i10 == 0 ? context.obtainStyledAttributes(attributeSet, iArr, 0, R.style.Widget_Support_CoordinatorLayout) : context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        if (i10 == 0) {
            coordinatorLayout = this;
            context2 = context;
            coordinatorLayout.saveAttributeDataForStyleable(context2, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, R.style.Widget_Support_CoordinatorLayout);
        } else {
            coordinatorLayout = this;
            context2 = context;
            coordinatorLayout.saveAttributeDataForStyleable(context2, iArr, attributeSet, typedArrayObtainStyledAttributes, i10, 0);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context2.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            coordinatorLayout.f1444m = intArray;
            float f8 = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int i11 = 0; i11 < length; i11++) {
                coordinatorLayout.f1444m[i11] = (int) (r10[i11] * f8);
            }
        }
        coordinatorLayout.f1450t = typedArrayObtainStyledAttributes.getDrawable(1);
        typedArrayObtainStyledAttributes.recycle();
        coordinatorLayout.J();
        super.setOnHierarchyChangeListener(coordinatorLayout.new e());
        WeakHashMap<View, h0> weakHashMap = e0.f13274a;
        if (coordinatorLayout.getImportantForAccessibility() == 0) {
            coordinatorLayout.setImportantForAccessibility(1);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f ? new f((f) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new f((ViewGroup.MarginLayoutParams) layoutParams) : new f(layoutParams);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        SparseArray<Parcelable> behaviorStates;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i10) {
                return new SavedState[i10];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
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

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class f extends ViewGroup.MarginLayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public c f1456a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f1457b;

        /* renamed from: c, reason: collision with root package name */
        public final int f1458c;

        /* renamed from: d, reason: collision with root package name */
        public int f1459d;

        /* renamed from: e, reason: collision with root package name */
        public final int f1460e;

        /* renamed from: f, reason: collision with root package name */
        public final int f1461f;

        /* renamed from: g, reason: collision with root package name */
        public final int f1462g;
        public int h;

        /* renamed from: i, reason: collision with root package name */
        public int f1463i;

        /* renamed from: j, reason: collision with root package name */
        public int f1464j;

        /* renamed from: k, reason: collision with root package name */
        public View f1465k;

        /* renamed from: l, reason: collision with root package name */
        public View f1466l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f1467m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f1468n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f1469o;

        /* renamed from: p, reason: collision with root package name */
        public boolean f1470p;

        /* renamed from: q, reason: collision with root package name */
        public final Rect f1471q;
        public Object r;

        public f() {
            super(-2, -2);
            this.f1457b = false;
            this.f1458c = 0;
            this.f1459d = 0;
            this.f1460e = -1;
            this.f1461f = -1;
            this.f1462g = 0;
            this.h = 0;
            this.f1471q = new Rect();
        }

        public final boolean a(int i10) {
            if (i10 == 0) {
                return this.f1468n;
            }
            if (i10 != 1) {
                return false;
            }
            return this.f1469o;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public f(Context context, AttributeSet attributeSet) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
            c cVarNewInstance;
            super(context, attributeSet);
            this.f1457b = false;
            this.f1458c = 0;
            this.f1459d = 0;
            this.f1460e = -1;
            this.f1461f = -1;
            this.f1462g = 0;
            this.h = 0;
            this.f1471q = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k0.a.f9833b);
            this.f1458c = typedArrayObtainStyledAttributes.getInteger(0, 0);
            this.f1461f = typedArrayObtainStyledAttributes.getResourceId(1, -1);
            this.f1459d = typedArrayObtainStyledAttributes.getInteger(2, 0);
            this.f1460e = typedArrayObtainStyledAttributes.getInteger(6, -1);
            this.f1462g = typedArrayObtainStyledAttributes.getInt(5, 0);
            this.h = typedArrayObtainStyledAttributes.getInt(4, 0);
            boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(3);
            this.f1457b = zHasValue;
            if (zHasValue) {
                String string = typedArrayObtainStyledAttributes.getString(3);
                String str = CoordinatorLayout.f1434x;
                if (TextUtils.isEmpty(string)) {
                    cVarNewInstance = null;
                } else {
                    if (string.startsWith(".")) {
                        string = context.getPackageName() + string;
                    } else if (string.indexOf(46) < 0) {
                        String str2 = CoordinatorLayout.f1434x;
                        if (!TextUtils.isEmpty(str2)) {
                            string = str2 + '.' + string;
                        }
                    }
                    try {
                        ThreadLocal<Map<String, Constructor<c>>> threadLocal = CoordinatorLayout.z;
                        Map<String, Constructor<c>> map = threadLocal.get();
                        if (map == null) {
                            map = new HashMap<>();
                            threadLocal.set(map);
                        }
                        Constructor<c> constructor = map.get(string);
                        if (constructor == null) {
                            constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(CoordinatorLayout.f1435y);
                            constructor.setAccessible(true);
                            map.put(string, constructor);
                        }
                        cVarNewInstance = constructor.newInstance(context, attributeSet);
                    } catch (Exception e10) {
                        throw new RuntimeException(ai.onnxruntime.a.k("Could not inflate Behavior subclass ", string), e10);
                    }
                }
                this.f1456a = cVarNewInstance;
            }
            typedArrayObtainStyledAttributes.recycle();
            c cVar = this.f1456a;
            if (cVar != null) {
                cVar.onAttachedToLayoutParams(this);
            }
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.f1457b = false;
            this.f1458c = 0;
            this.f1459d = 0;
            this.f1460e = -1;
            this.f1461f = -1;
            this.f1462g = 0;
            this.h = 0;
            this.f1471q = new Rect();
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1457b = false;
            this.f1458c = 0;
            this.f1459d = 0;
            this.f1460e = -1;
            this.f1461f = -1;
            this.f1462g = 0;
            this.h = 0;
            this.f1471q = new Rect();
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1457b = false;
            this.f1458c = 0;
            this.f1459d = 0;
            this.f1460e = -1;
            this.f1461f = -1;
            this.f1462g = 0;
            this.h = 0;
            this.f1471q = new Rect();
        }
    }
}
