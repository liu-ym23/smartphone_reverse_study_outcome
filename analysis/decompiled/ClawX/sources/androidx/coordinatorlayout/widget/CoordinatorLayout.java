package androidx.coordinatorlayout.widget;

import a1.w;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.stepos.stepclaw.R;
import d0.c;
import e0.a0;
import e0.h;
import e0.i;
import e0.j;
import e0.u;
import e0.x0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import m.d;
import r6.x;
import s.a;
import t.b;
import t.e;
import t.f;
import t.g;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements h, i {

    /* renamed from: u, reason: collision with root package name */
    public static final String f376u;

    /* renamed from: v, reason: collision with root package name */
    public static final Class[] f377v;

    /* renamed from: w, reason: collision with root package name */
    public static final ThreadLocal f378w;

    /* renamed from: x, reason: collision with root package name */
    public static final d f379x;
    public static final c y;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f380a;

    /* renamed from: b, reason: collision with root package name */
    public final w f381b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f382c;
    public final ArrayList d;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f383e;

    /* renamed from: f, reason: collision with root package name */
    public final int[] f384f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f385g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f386h;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f387j;

    /* renamed from: k, reason: collision with root package name */
    public View f388k;

    /* renamed from: l, reason: collision with root package name */
    public View f389l;

    /* renamed from: m, reason: collision with root package name */
    public e f390m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f391n;

    /* renamed from: o, reason: collision with root package name */
    public x0 f392o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f393p;

    /* renamed from: q, reason: collision with root package name */
    public Drawable f394q;

    /* renamed from: r, reason: collision with root package name */
    public ViewGroup.OnHierarchyChangeListener f395r;

    /* renamed from: s, reason: collision with root package name */
    public x f396s;

    /* renamed from: t, reason: collision with root package name */
    public final j f397t;

    static {
        Package r02 = CoordinatorLayout.class.getPackage();
        f376u = r02 != null ? r02.getName() : null;
        f379x = new d(2);
        f377v = new Class[]{Context.class, AttributeSet.class};
        f378w = new ThreadLocal();
        y = new c();
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet, R.attr.coordinatorLayoutStyle);
        this.f380a = new ArrayList();
        this.f381b = new w(9);
        this.f382c = new ArrayList();
        this.d = new ArrayList();
        this.f383e = new int[2];
        this.f384f = new int[2];
        this.f397t = new j(0);
        int[] iArr = a.f5228a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, R.attr.coordinatorLayoutStyle, 0);
        saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, R.attr.coordinatorLayoutStyle, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            this.f387j = intArray;
            float f3 = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int i8 = 0; i8 < length; i8++) {
                this.f387j[i8] = (int) (r10[i8] * f3);
            }
        }
        this.f394q = typedArrayObtainStyledAttributes.getDrawable(1);
        typedArrayObtainStyledAttributes.recycle();
        w();
        super.setOnHierarchyChangeListener(new t.c(this));
        int[] iArr2 = a0.f2285a;
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public static Rect g() {
        Rect rect = (Rect) y.a();
        return rect == null ? new Rect() : rect;
    }

    public static void l(int i8, Rect rect, Rect rect2, t.d dVar, int i9, int i10) {
        int i11 = dVar.f5391c;
        if (i11 == 0) {
            i11 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i11, i8);
        int i12 = dVar.d;
        if ((i12 & 7) == 0) {
            i12 |= 8388611;
        }
        if ((i12 & 112) == 0) {
            i12 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i12, i8);
        int i13 = absoluteGravity & 7;
        int i14 = absoluteGravity & 112;
        int i15 = absoluteGravity2 & 7;
        int i16 = absoluteGravity2 & 112;
        int iWidth = i15 != 1 ? i15 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int iHeight = i16 != 16 ? i16 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i13 == 1) {
            iWidth -= i9 / 2;
        } else if (i13 != 5) {
            iWidth -= i9;
        }
        if (i14 == 16) {
            iHeight -= i10 / 2;
        } else if (i14 != 80) {
            iHeight -= i10;
        }
        rect2.set(iWidth, iHeight, i9 + iWidth, i10 + iHeight);
    }

    public static t.d n(View view) {
        t.d dVar = (t.d) view.getLayoutParams();
        if (!dVar.f5390b) {
            b bVar = null;
            for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                bVar = (b) superclass.getAnnotation(b.class);
                if (bVar != null) {
                    break;
                }
            }
            if (bVar != null) {
                try {
                    t.a aVar = (t.a) bVar.value().getDeclaredConstructor(null).newInstance(null);
                    t.a aVar2 = dVar.f5389a;
                    if (aVar2 != aVar) {
                        if (aVar2 != null) {
                            aVar2.e();
                        }
                        dVar.f5389a = aVar;
                        dVar.f5390b = true;
                        if (aVar != null) {
                            aVar.c(dVar);
                        }
                    }
                } catch (Exception e9) {
                    Log.e("CoordinatorLayout", "Default behavior class " + bVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e9);
                }
            }
            dVar.f5390b = true;
        }
        return dVar;
    }

    public static void u(View view, int i8) {
        t.d dVar = (t.d) view.getLayoutParams();
        int i9 = dVar.f5396i;
        if (i9 != i8) {
            int[] iArr = a0.f2285a;
            view.offsetLeftAndRight(i8 - i9);
            dVar.f5396i = i8;
        }
    }

    public static void v(View view, int i8) {
        t.d dVar = (t.d) view.getLayoutParams();
        int i9 = dVar.f5397j;
        if (i9 != i8) {
            int[] iArr = a0.f2285a;
            view.offsetTopAndBottom(i8 - i9);
            dVar.f5397j = i8;
        }
    }

    @Override // e0.h
    public final void a(View view, View view2, int i8, int i9) {
        j jVar = this.f397t;
        if (i9 == 1) {
            jVar.f2312c = i8;
        } else {
            jVar.f2311b = i8;
        }
        this.f389l = view2;
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            ((t.d) getChildAt(i10).getLayoutParams()).getClass();
        }
    }

    @Override // e0.h
    public final void b(View view, int i8) {
        j jVar = this.f397t;
        if (i8 == 1) {
            jVar.f2312c = 0;
        } else {
            jVar.f2311b = 0;
        }
        int childCount = getChildCount();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            t.d dVar = (t.d) childAt.getLayoutParams();
            if (dVar.a(i8)) {
                t.a aVar = dVar.f5389a;
                if (aVar != null) {
                    aVar.p(childAt, view, i8);
                }
                if (i8 == 0) {
                    dVar.f5400m = false;
                } else if (i8 == 1) {
                    dVar.f5401n = false;
                }
            }
        }
        this.f389l = null;
    }

    @Override // e0.h
    public final void c(View view, int i8, int i9, int[] iArr, int i10) {
        t.a aVar;
        int childCount = getChildCount();
        boolean z = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                t.d dVar = (t.d) childAt.getLayoutParams();
                if (dVar.a(i10) && (aVar = dVar.f5389a) != null) {
                    int[] iArr2 = this.f383e;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    aVar.j(this, childAt, view, i8, i9, iArr2, i10);
                    iMax = i8 > 0 ? Math.max(iMax, iArr2[0]) : Math.min(iMax, iArr2[0]);
                    iMax2 = i9 > 0 ? Math.max(iMax2, iArr2[1]) : Math.min(iMax2, iArr2[1]);
                    z = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z) {
            p(1);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof t.d) && super.checkLayoutParams(layoutParams);
    }

    @Override // e0.i
    public final void d(View view, int i8, int i9, int i10, int i11, int i12, int[] iArr) {
        t.a aVar;
        int childCount = getChildCount();
        int iMax = 0;
        int iMax2 = 0;
        boolean z = false;
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                t.d dVar = (t.d) childAt.getLayoutParams();
                if (dVar.a(i12) && (aVar = dVar.f5389a) != null) {
                    int[] iArr2 = this.f383e;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    aVar.k(this, childAt, i9, i10, i11, iArr2);
                    iMax = i10 > 0 ? Math.max(iMax, iArr2[0]) : Math.min(iMax, iArr2[0]);
                    iMax2 = i11 > 0 ? Math.max(iMax2, iArr2[1]) : Math.min(iMax2, iArr2[1]);
                    z = true;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + iMax2;
        if (z) {
            p(1);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j4) {
        t.a aVar = ((t.d) view.getLayoutParams()).f5389a;
        if (aVar != null) {
            aVar.getClass();
        }
        return super.drawChild(canvas, view, j4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f394q;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    @Override // e0.h
    public final void e(View view, int i8, int i9, int i10, int i11, int i12) {
        d(view, i8, i9, i10, i11, 0, this.f384f);
    }

    @Override // e0.h
    public final boolean f(View view, View view2, int i8, int i9) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                t.d dVar = (t.d) childAt.getLayoutParams();
                t.a aVar = dVar.f5389a;
                if (aVar != null) {
                    boolean zO = aVar.o(childAt, i8, i9);
                    z |= zO;
                    if (i9 == 0) {
                        dVar.f5400m = zO;
                    } else if (i9 == 1) {
                        dVar.f5401n = zO;
                    }
                } else if (i9 == 0) {
                    dVar.f5400m = false;
                } else if (i9 == 1) {
                    dVar.f5401n = false;
                }
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new t.d();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new t.d(getContext(), attributeSet);
    }

    public final List<View> getDependencySortedChildren() {
        s();
        return Collections.unmodifiableList(this.f380a);
    }

    public final x0 getLastWindowInsets() {
        return this.f392o;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        j jVar = this.f397t;
        return jVar.f2312c | jVar.f2311b;
    }

    public Drawable getStatusBarBackground() {
        return this.f394q;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    public final void h(t.d dVar, Rect rect, int i8, int i9) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i8) - ((ViewGroup.MarginLayoutParams) dVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) dVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i9) - ((ViewGroup.MarginLayoutParams) dVar).bottomMargin));
        rect.set(iMax, iMax2, i8 + iMax, i9 + iMax2);
    }

    public final void i(View view, Rect rect, boolean z) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            k(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public final ArrayList j(View view) {
        j.j jVar = (j.j) this.f381b.f76c;
        int i8 = jVar.f3306c;
        ArrayList arrayList = null;
        for (int i9 = 0; i9 < i8; i9++) {
            ArrayList arrayList2 = (ArrayList) jVar.i(i9);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(jVar.f(i9));
            }
        }
        ArrayList arrayList3 = this.d;
        arrayList3.clear();
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        return arrayList3;
    }

    public final void k(View view, Rect rect) {
        ThreadLocal threadLocal = g.f5405a;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal threadLocal2 = g.f5405a;
        Matrix matrix = (Matrix) threadLocal2.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal2.set(matrix);
        } else {
            matrix.reset();
        }
        g.a(this, view, matrix);
        ThreadLocal threadLocal3 = g.f5406b;
        RectF rectF = (RectF) threadLocal3.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal3.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public final int m(int i8) {
        int[] iArr = this.f387j;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i8);
            return 0;
        }
        if (i8 >= 0 && i8 < iArr.length) {
            return iArr[i8];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i8 + " out of range for " + this);
        return 0;
    }

    public final boolean o(View view, int i8, int i9) {
        c cVar = y;
        Rect rectG = g();
        k(view, rectG);
        try {
            return rectG.contains(i8, i9);
        } finally {
            rectG.setEmpty();
            cVar.c(rectG);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        t(false);
        if (this.f391n) {
            if (this.f390m == null) {
                this.f390m = new e(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.f390m);
        }
        if (this.f392o == null) {
            int[] iArr = a0.f2285a;
            if (getFitsSystemWindows()) {
                requestApplyInsets();
            }
        }
        this.f386h = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        t(false);
        if (this.f391n && this.f390m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f390m);
        }
        View view = this.f389l;
        if (view != null) {
            b(view, 0);
        }
        this.f386h = false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f393p || this.f394q == null) {
            return;
        }
        x0 x0Var = this.f392o;
        int iA = x0Var != null ? x0Var.a() : 0;
        if (iA > 0) {
            this.f394q.setBounds(0, 0, getWidth(), iA);
            this.f394q.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            t(true);
        }
        boolean zR = r(motionEvent, 0);
        if (actionMasked != 1 && actionMasked != 3) {
            return zR;
        }
        t(true);
        return zR;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i8, int i9, int i10, int i11) {
        t.a aVar;
        int[] iArr = a0.f2285a;
        int layoutDirection = getLayoutDirection();
        ArrayList arrayList = this.f380a;
        int size = arrayList.size();
        for (int i12 = 0; i12 < size; i12++) {
            View view = (View) arrayList.get(i12);
            if (view.getVisibility() != 8 && ((aVar = ((t.d) view.getLayoutParams()).f5389a) == null || !aVar.g(this, view, layoutDirection))) {
                q(view, layoutDirection);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:73:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0197  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r27, int r28) {
        /*
            Method dump skipped, instructions count: 513
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f3, float f7, boolean z) {
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                t.d dVar = (t.d) childAt.getLayoutParams();
                if (dVar.a(0)) {
                    t.a aVar = dVar.f5389a;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f3, float f7) {
        t.a aVar;
        int childCount = getChildCount();
        boolean zI = false;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                t.d dVar = (t.d) childAt.getLayoutParams();
                if (dVar.a(0) && (aVar = dVar.f5389a) != null) {
                    zI |= aVar.i(view);
                }
            }
        }
        return zI;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i8, int i9, int[] iArr) {
        c(view, i8, i9, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i8, int i9, int i10, int i11) {
        e(view, i8, i9, i10, i11, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i8) {
        a(view, view2, i8, 0);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof f)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.f3000a);
        SparseArray sparseArray = fVar.f5404c;
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            int id = childAt.getId();
            t.a aVar = n(childAt).f5389a;
            if (id != -1 && aVar != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                aVar.m(childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableN;
        f fVar = new f(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            int id = childAt.getId();
            t.a aVar = ((t.d) childAt.getLayoutParams()).f5389a;
            if (id != -1 && aVar != null && (parcelableN = aVar.n(childAt)) != null) {
                sparseArray.append(id, parcelableN);
            }
        }
        fVar.f5404c = sparseArray;
        return fVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i8) {
        return f(view, view2, i8, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        b(view, 0);
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
    public final boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r1.getActionMasked()
            android.view.View r3 = r0.f388k
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.r(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = r5
            goto L2a
        L17:
            r3 = r5
        L18:
            android.view.View r6 = r0.f388k
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            t.d r6 = (t.d) r6
            t.a r6 = r6.f5389a
            if (r6 == 0) goto L15
            android.view.View r7 = r0.f388k
            boolean r6 = r6.q(r7, r1)
        L2a:
            android.view.View r7 = r0.f388k
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
            r0.t(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(int r23) {
        /*
            Method dump skipped, instructions count: 721
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.p(int):void");
    }

    public final void q(View view, int i8) {
        Rect rectG;
        Rect rectG2;
        t.d dVar = (t.d) view.getLayoutParams();
        View view2 = dVar.f5398k;
        if (view2 == null && dVar.f5393f != -1) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        c cVar = y;
        if (view2 != null) {
            rectG = g();
            rectG2 = g();
            try {
                k(view2, rectG);
                t.d dVar2 = (t.d) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                l(i8, rectG, rectG2, dVar2, measuredWidth, measuredHeight);
                h(dVar2, rectG2, measuredWidth, measuredHeight);
                view.layout(rectG2.left, rectG2.top, rectG2.right, rectG2.bottom);
                return;
            } finally {
                rectG.setEmpty();
                cVar.c(rectG);
                rectG2.setEmpty();
                cVar.c(rectG2);
            }
        }
        int i9 = dVar.f5392e;
        if (i9 < 0) {
            t.d dVar3 = (t.d) view.getLayoutParams();
            rectG = g();
            rectG.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar3).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) dVar3).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) dVar3).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) dVar3).bottomMargin);
            if (this.f392o != null) {
                int[] iArr = a0.f2285a;
                if (getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                    rectG.left = this.f392o.f2338a.j().f6232a + rectG.left;
                    rectG.top = this.f392o.a() + rectG.top;
                    rectG.right -= this.f392o.f2338a.j().f6234c;
                    rectG.bottom -= this.f392o.f2338a.j().d;
                }
            }
            rectG2 = g();
            int i10 = dVar3.f5391c;
            if ((i10 & 7) == 0) {
                i10 |= 8388611;
            }
            if ((i10 & 112) == 0) {
                i10 |= 48;
            }
            Gravity.apply(i10, view.getMeasuredWidth(), view.getMeasuredHeight(), rectG, rectG2, i8);
            view.layout(rectG2.left, rectG2.top, rectG2.right, rectG2.bottom);
            return;
        }
        t.d dVar4 = (t.d) view.getLayoutParams();
        int i11 = dVar4.f5391c;
        if (i11 == 0) {
            i11 = 8388661;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i11, i8);
        int i12 = absoluteGravity & 7;
        int i13 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth2 = view.getMeasuredWidth();
        int measuredHeight2 = view.getMeasuredHeight();
        if (i8 == 1) {
            i9 = width - i9;
        }
        int iM = m(i9) - measuredWidth2;
        if (i12 == 1) {
            iM += measuredWidth2 / 2;
        } else if (i12 == 5) {
            iM += measuredWidth2;
        }
        int i14 = i13 != 16 ? i13 != 80 ? 0 : measuredHeight2 : measuredHeight2 / 2;
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) dVar4).leftMargin, Math.min(iM, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) dVar4).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) dVar4).topMargin, Math.min(i14, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) dVar4).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth2 + iMax, measuredHeight2 + iMax2);
    }

    public final boolean r(MotionEvent motionEvent, int i8) {
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.f382c;
        arrayList.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i9 = childCount - 1; i9 >= 0; i9--) {
            arrayList.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i9) : i9));
        }
        d dVar = f379x;
        if (dVar != null) {
            Collections.sort(arrayList, dVar);
        }
        int size = arrayList.size();
        MotionEvent motionEventObtain = null;
        boolean zF = false;
        for (int i10 = 0; i10 < size; i10++) {
            View view = (View) arrayList.get(i10);
            t.a aVar = ((t.d) view.getLayoutParams()).f5389a;
            if (zF && actionMasked != 0) {
                if (aVar != null) {
                    if (motionEventObtain == null) {
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    if (i8 == 0) {
                        aVar.f(this, view, motionEventObtain);
                    } else if (i8 == 1) {
                        aVar.q(view, motionEventObtain);
                    }
                }
            } else if (!zF && aVar != null) {
                if (i8 == 0) {
                    zF = aVar.f(this, view, motionEvent);
                } else if (i8 == 1) {
                    zF = aVar.q(view, motionEvent);
                }
                if (zF) {
                    this.f388k = view;
                }
            }
        }
        arrayList.clear();
        return zF;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        t.a aVar = ((t.d) view.getLayoutParams()).f5389a;
        if (aVar != null) {
            aVar.l(this, view);
        }
        return super.requestChildRectangleOnScreen(view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.f385g) {
            return;
        }
        t(false);
        this.f385g = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0104  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s() {
        /*
            Method dump skipped, instructions count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.s():void");
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        w();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f395r = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.f394q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.f394q = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.f394q.setState(getDrawableState());
                }
                Drawable drawable3 = this.f394q;
                int[] iArr = a0.f2285a;
                drawable3.setLayoutDirection(getLayoutDirection());
                this.f394q.setVisible(getVisibility() == 0, false);
                this.f394q.setCallback(this);
            }
            int[] iArr2 = a0.f2285a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarBackgroundColor(int i8) {
        setStatusBarBackground(new ColorDrawable(i8));
    }

    public void setStatusBarBackgroundResource(int i8) {
        setStatusBarBackground(i8 != 0 ? getContext().getDrawable(i8) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i8) {
        super.setVisibility(i8);
        boolean z = i8 == 0;
        Drawable drawable = this.f394q;
        if (drawable == null || drawable.isVisible() == z) {
            return;
        }
        this.f394q.setVisible(z, false);
    }

    public final void t(boolean z) {
        int childCount = getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            t.a aVar = ((t.d) childAt.getLayoutParams()).f5389a;
            if (aVar != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    aVar.f(this, childAt, motionEventObtain);
                } else {
                    aVar.q(childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            ((t.d) getChildAt(i9).getLayoutParams()).getClass();
        }
        this.f388k = null;
        this.f385g = false;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f394q;
    }

    public final void w() {
        int[] iArr = a0.f2285a;
        if (!getFitsSystemWindows()) {
            u.b(this, null);
            return;
        }
        if (this.f396s == null) {
            this.f396s = new x(this);
        }
        u.b(this, this.f396s);
        setSystemUiVisibility(1280);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof t.d ? new t.d((t.d) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new t.d((ViewGroup.MarginLayoutParams) layoutParams) : new t.d(layoutParams);
    }
}
