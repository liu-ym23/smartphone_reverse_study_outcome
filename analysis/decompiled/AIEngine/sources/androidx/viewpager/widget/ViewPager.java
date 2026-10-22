package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import androidx.appcompat.widget.l;
import androidx.customview.view.AbsSavedState;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.WeakHashMap;
import v0.e0;
import v0.h0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ViewPager extends ViewGroup {
    public static final int[] I = {R.attr.layout_gravity};
    public static final b J = new b();
    public final int A;
    public final EdgeEffect B;
    public final EdgeEffect C;
    public boolean D;
    public boolean E;
    public int F;
    public final c G;
    public int H;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<e> f2654a;

    /* renamed from: b, reason: collision with root package name */
    public final e f2655b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f2656c;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f2657d;

    /* renamed from: e, reason: collision with root package name */
    public final Scroller f2658e;
    public int h;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f2659j;

    /* renamed from: k, reason: collision with root package name */
    public final float f2660k;

    /* renamed from: l, reason: collision with root package name */
    public final float f2661l;

    /* renamed from: m, reason: collision with root package name */
    public int f2662m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f2663n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f2664o;

    /* renamed from: p, reason: collision with root package name */
    public int f2665p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2666q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public final int f2667s;

    /* renamed from: t, reason: collision with root package name */
    public int f2668t;

    /* renamed from: u, reason: collision with root package name */
    public final int f2669u;

    /* renamed from: v, reason: collision with root package name */
    public float f2670v;

    /* renamed from: w, reason: collision with root package name */
    public float f2671w;

    /* renamed from: x, reason: collision with root package name */
    public float f2672x;

    /* renamed from: y, reason: collision with root package name */
    public int f2673y;
    public VelocityTracker z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        Parcelable adapterState;
        ClassLoader loader;
        int position;

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

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("FragmentPager.SavedState{");
            sb2.append(Integer.toHexString(System.identityHashCode(this)));
            sb2.append(" position=");
            return ai.onnxruntime.a.j("}", this.position, sb2);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.adapterState, i10);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader);
            this.loader = classLoader;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a implements Comparator<e> {
        @Override // java.util.Comparator
        public final int compare(e eVar, e eVar2) {
            return eVar.f2675a - eVar2.f2675a;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f8) {
            float f9 = f8 - 1.0f;
            return (f9 * f9 * f9 * f9 * f9) + 1.0f;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewPager.this.setScrollState(0);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface d {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public int f2675a;

        /* renamed from: b, reason: collision with root package name */
        public float f2676b;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class f extends ViewGroup.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public boolean f2677a;

        /* renamed from: b, reason: collision with root package name */
        public int f2678b;

        public f() {
            super(-1, -1);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class g extends v0.a {
        public g() {
        }

        @Override // v0.a
        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(false);
            accessibilityEvent.getEventType();
        }

        @Override // v0.a
        public final void onInitializeAccessibilityNodeInfo(View view, w0.b bVar) {
            super.onInitializeAccessibilityNodeInfo(view, bVar);
            bVar.h(ViewPager.class.getName());
            bVar.l(false);
        }

        @Override // v0.a
        public final boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (super.performAccessibilityAction(view, i10, bundle)) {
                return true;
            }
            ViewPager viewPager = ViewPager.this;
            if (i10 == 4096) {
                viewPager.getClass();
                return false;
            }
            if (i10 != 8192) {
                return false;
            }
            viewPager.getClass();
            return false;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface h {
        void a();

        void b();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2654a = new ArrayList<>();
        this.f2655b = new e();
        this.f2656c = new Rect();
        this.f2657d = null;
        this.f2660k = -3.4028235E38f;
        this.f2661l = Float.MAX_VALUE;
        this.f2665p = 1;
        this.f2673y = -1;
        this.D = true;
        this.G = new c();
        this.H = 0;
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context2 = getContext();
        this.f2658e = new Scroller(context2, J);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context2);
        float f8 = context2.getResources().getDisplayMetrics().density;
        this.f2669u = viewConfiguration.getScaledPagingTouchSlop();
        viewConfiguration.getScaledMaximumFlingVelocity();
        this.B = new EdgeEffect(context2);
        this.C = new EdgeEffect(context2);
        this.A = (int) (2.0f * f8);
        this.f2667s = (int) (f8 * 16.0f);
        e0.j(this, new g());
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        e0.d.k(this, new l(this));
    }

    public static boolean b(int i10, int i11, int i12, View view, boolean z) {
        int i13;
        if (!(view instanceof ViewGroup)) {
            return z ? false : false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int scrollX = view.getScrollX();
        int scrollY = view.getScrollY();
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            int i14 = i11 + scrollX;
            if (i14 >= childAt.getLeft() && i14 < childAt.getRight() && (i13 = i12 + scrollY) >= childAt.getTop() && i13 < childAt.getBottom() && b(i10, i14 - childAt.getLeft(), i13 - childAt.getTop(), childAt, true)) {
                break;
            }
        }
        if (z || !view.canScrollHorizontally(-i10)) {
        }
        return true;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f2664o != z) {
            this.f2664o = z;
        }
    }

    public final boolean a(int i10) {
        View viewFindFocus = findFocus();
        if (viewFindFocus == this) {
            viewFindFocus = null;
        } else if (viewFindFocus != null) {
            for (ViewParent parent = viewFindFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                if (parent == this) {
                    break;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(viewFindFocus.getClass().getSimpleName());
            for (ViewParent parent2 = viewFindFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                sb2.append(" => ");
                sb2.append(parent2.getClass().getSimpleName());
            }
            Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + sb2.toString());
            viewFindFocus = null;
        }
        View viewFindNextFocus = FocusFinder.getInstance().findNextFocus(this, viewFindFocus, i10);
        boolean zRequestFocus = false;
        if (viewFindNextFocus != null && viewFindNextFocus != viewFindFocus) {
            Rect rect = this.f2656c;
            if (i10 == 17) {
                int i11 = d(viewFindNextFocus, rect).left;
                int i12 = d(viewFindFocus, rect).left;
                if (viewFindFocus == null || i11 < i12) {
                    zRequestFocus = viewFindNextFocus.requestFocus();
                }
            } else if (i10 == 66) {
                int i13 = d(viewFindNextFocus, rect).left;
                int i14 = d(viewFindFocus, rect).left;
                if (viewFindFocus == null || i13 > i14) {
                    zRequestFocus = viewFindNextFocus.requestFocus();
                }
            }
        } else if (i10 != 17) {
        }
        if (zRequestFocus) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i10));
        }
        return zRequestFocus;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i12 = 0; i12 < getChildCount(); i12++) {
                if (getChildAt(i12).getVisibility() == 0) {
                    e();
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i11 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addTouchables(ArrayList<View> arrayList) {
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            if (getChildAt(i10).getVisibility() == 0) {
                e();
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = new f();
        }
        f fVar = (f) layoutParams;
        boolean z = fVar.f2677a | (view.getClass().getAnnotation(d.class) != null);
        fVar.f2677a = z;
        if (!this.f2663n) {
            super.addView(view, i10, layoutParams);
        } else {
            if (z) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            addViewInLayout(view, i10, layoutParams);
        }
    }

    public final void c(boolean z) {
        int i10 = 0;
        boolean z3 = this.H == 2;
        if (z3) {
            setScrollingCacheEnabled(false);
            Scroller scroller = this.f2658e;
            if (!scroller.isFinished()) {
                scroller.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = scroller.getCurrX();
                int currY = scroller.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        h(currX);
                    }
                }
            }
        }
        while (true) {
            ArrayList<e> arrayList = this.f2654a;
            if (i10 >= arrayList.size()) {
                break;
            }
            arrayList.get(i10).getClass();
            i10++;
        }
        if (z3) {
            c cVar = this.G;
            if (!z) {
                cVar.run();
            } else {
                WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                postOnAnimation(cVar);
            }
        }
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i10) {
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final void computeScroll() {
        Scroller scroller = this.f2658e;
        if (scroller.isFinished() || !scroller.computeScrollOffset()) {
            c(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = scroller.getCurrX();
        int currY = scroller.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!h(currX)) {
                scroller.abortAnimation();
                scrollTo(0, currY);
            }
        }
        WeakHashMap<View, h0> weakHashMap = e0.f13274a;
        postInvalidateOnAnimation();
    }

    public final Rect d(View view, Rect rect) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left = viewGroup.getLeft() + rect.left;
            rect.right = viewGroup.getRight() + rect.right;
            rect.top = viewGroup.getTop() + rect.top;
            rect.bottom = viewGroup.getBottom() + rect.bottom;
            parent = viewGroup.getParent();
        }
        return rect;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0055 A[RETURN] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r6) {
        /*
            r5 = this;
            boolean r0 = super.dispatchKeyEvent(r6)
            r1 = 1
            if (r0 != 0) goto L56
            int r0 = r6.getAction()
            r2 = 0
            if (r0 != 0) goto L3c
            int r0 = r6.getKeyCode()
            r3 = 21
            r4 = 2
            if (r0 == r3) goto L45
            r3 = 22
            if (r0 == r3) goto L36
            r3 = 61
            if (r0 == r3) goto L20
            goto L3c
        L20:
            boolean r0 = r6.hasNoModifiers()
            if (r0 == 0) goto L2b
            boolean r5 = r5.a(r4)
            goto L52
        L2b:
            boolean r6 = r6.hasModifiers(r1)
            if (r6 == 0) goto L3c
            boolean r5 = r5.a(r1)
            goto L52
        L36:
            boolean r6 = r6.hasModifiers(r4)
            if (r6 == 0) goto L3e
        L3c:
            r5 = r2
            goto L52
        L3e:
            r6 = 66
            boolean r5 = r5.a(r6)
            goto L52
        L45:
            boolean r6 = r6.hasModifiers(r4)
            if (r6 == 0) goto L4c
            goto L3c
        L4c:
            r6 = 17
            boolean r5 = r5.a(r6)
        L52:
            if (r5 == 0) goto L55
            goto L56
        L55:
            return r2
        L56:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (getChildAt(i10).getVisibility() == 0) {
                e();
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        int overScrollMode = getOverScrollMode();
        EdgeEffect edgeEffect = this.C;
        EdgeEffect edgeEffect2 = this.B;
        boolean zDraw = false;
        if (overScrollMode != 0) {
            edgeEffect2.finish();
            edgeEffect.finish();
        } else {
            if (!edgeEffect2.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate(getPaddingTop() + (-height), this.f2660k * width);
                edgeEffect2.setSize(height, width);
                zDraw = edgeEffect2.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!edgeEffect.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.f2661l + 1.0f)) * width2);
                edgeEffect.setSize(height2, width2);
                zDraw |= edgeEffect.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        }
        if (zDraw) {
            WeakHashMap<View, h0> weakHashMap = e0.f13274a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f2659j;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public final void e() {
        ArrayList<e> arrayList = this.f2654a;
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        throw null;
    }

    public final e f() {
        int i10 = 0;
        while (true) {
            ArrayList<e> arrayList = this.f2654a;
            if (i10 >= arrayList.size()) {
                return null;
            }
            e eVar = arrayList.get(i10);
            if (eVar.f2675a == 0) {
                return eVar;
            }
            i10++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(float r9, int r10, int r11) {
        /*
            r8 = this;
            int r9 = r8.F
            r10 = 1
            if (r9 <= 0) goto L6b
            int r9 = r8.getScrollX()
            int r11 = r8.getPaddingLeft()
            int r0 = r8.getPaddingRight()
            int r1 = r8.getWidth()
            int r2 = r8.getChildCount()
            r3 = 0
        L1a:
            if (r3 >= r2) goto L6b
            android.view.View r4 = r8.getChildAt(r3)
            android.view.ViewGroup$LayoutParams r5 = r4.getLayoutParams()
            androidx.viewpager.widget.ViewPager$f r5 = (androidx.viewpager.widget.ViewPager.f) r5
            boolean r6 = r5.f2677a
            if (r6 != 0) goto L2b
            goto L68
        L2b:
            int r5 = r5.f2678b
            r5 = r5 & 7
            if (r5 == r10) goto L4f
            r6 = 3
            if (r5 == r6) goto L49
            r6 = 5
            if (r5 == r6) goto L39
            r5 = r11
            goto L5c
        L39:
            int r5 = r1 - r0
            int r6 = r4.getMeasuredWidth()
            int r5 = r5 - r6
            int r6 = r4.getMeasuredWidth()
            int r0 = r0 + r6
        L45:
            r7 = r5
            r5 = r11
            r11 = r7
            goto L5c
        L49:
            int r5 = r4.getWidth()
            int r5 = r5 + r11
            goto L5c
        L4f:
            int r5 = r4.getMeasuredWidth()
            int r5 = r1 - r5
            int r5 = r5 / 2
            int r5 = java.lang.Math.max(r5, r11)
            goto L45
        L5c:
            int r11 = r11 + r9
            int r6 = r4.getLeft()
            int r11 = r11 - r6
            if (r11 == 0) goto L67
            r4.offsetLeftAndRight(r11)
        L67:
            r11 = r5
        L68:
            int r3 = r3 + 1
            goto L1a
        L6b:
            r8.E = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.g(float, int, int):void");
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new f();
    }

    public androidx.viewpager.widget.a getAdapter() {
        return null;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i10, int i11) {
        throw null;
    }

    public int getCurrentItem() {
        return 0;
    }

    public int getOffscreenPageLimit() {
        return this.f2665p;
    }

    public int getPageMargin() {
        return this.h;
    }

    public final boolean h(int i10) {
        int i11;
        ArrayList<e> arrayList = this.f2654a;
        if (arrayList.size() == 0) {
            if (!this.D) {
                this.E = false;
                g(0.0f, 0, 0);
                if (!this.E) {
                    throw new IllegalStateException("onPageScrolled did not call superclass implementation");
                }
            }
            return false;
        }
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f8 = clientWidth > 0 ? this.h / clientWidth : 0.0f;
        int i12 = -1;
        boolean z = true;
        float f9 = 0.0f;
        int i13 = 0;
        e eVar = null;
        while (i13 < arrayList.size()) {
            e eVar2 = arrayList.get(i13);
            if (!z && eVar2.f2675a != (i11 = i12 + 1)) {
                e eVar3 = this.f2655b;
                eVar3.f2676b = f9 + 0.0f + f8;
                eVar3.f2675a = i11;
                throw null;
            }
            f9 = eVar2.f2676b;
            float f10 = f9 + 0.0f + f8;
            if (!z && scrollX < f9) {
                break;
            }
            if (scrollX < f10 || i13 == arrayList.size() - 1) {
                eVar = eVar2;
                break;
            }
            i12 = eVar2.f2675a;
            i13++;
            z = false;
            eVar = eVar2;
        }
        int clientWidth2 = getClientWidth();
        int i14 = this.h;
        int i15 = clientWidth2 + i14;
        float f11 = clientWidth2;
        int i16 = eVar.f2675a;
        float f12 = ((i10 / f11) - eVar.f2676b) / (0.0f + (i14 / f11));
        this.E = false;
        g(f12, i16, (int) (i15 * f12));
        if (this.E) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    public final void i(int i10, int i11, int i12, int i13) {
        if (i11 > 0 && !this.f2654a.isEmpty()) {
            if (!this.f2658e.isFinished()) {
                this.f2658e.setFinalX(getCurrentItem() * getClientWidth());
                return;
            } else {
                scrollTo((int) ((getScrollX() / (((i11 - getPaddingLeft()) - getPaddingRight()) + i13)) * (((i10 - getPaddingLeft()) - getPaddingRight()) + i12)), getScrollY());
                return;
            }
        }
        e eVarF = f();
        int iMin = (int) ((eVarF != null ? Math.min(eVarF.f2676b, this.f2661l) : 0.0f) * ((i10 - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            c(false);
            scrollTo(iMin, getScrollY());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.D = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.G);
        Scroller scroller = this.f2658e;
        if (scroller != null && !scroller.isFinished()) {
            this.f2658e.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.h <= 0 || this.f2659j == null) {
            return;
        }
        this.f2654a.size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001a, code lost:
    
        if (r13.r != false) goto L84;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0094  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager.widget.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public final void onMeasure(int i10, int i11) {
        f fVar;
        f fVar2;
        int i12;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, i10), ViewGroup.getDefaultSize(0, i11));
        int measuredWidth = getMeasuredWidth();
        this.f2668t = Math.min(measuredWidth / 10, this.f2667s);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i13 = 0;
        while (true) {
            int i14 = 1073741824;
            if (i13 >= childCount) {
                break;
            }
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8 && (fVar2 = (f) childAt.getLayoutParams()) != null && fVar2.f2677a) {
                int i15 = fVar2.f2678b;
                int i16 = i15 & 7;
                int i17 = i15 & 112;
                boolean z = true;
                boolean z3 = i17 == 48 || i17 == 80;
                if (i16 != 3 && i16 != 5) {
                    z = false;
                }
                int i18 = Integer.MIN_VALUE;
                if (z3) {
                    i12 = Integer.MIN_VALUE;
                    i18 = 1073741824;
                } else {
                    i12 = z ? 1073741824 : Integer.MIN_VALUE;
                }
                int i19 = ((ViewGroup.LayoutParams) fVar2).width;
                if (i19 != -2) {
                    if (i19 == -1) {
                        i19 = paddingLeft;
                    }
                    i18 = 1073741824;
                } else {
                    i19 = paddingLeft;
                }
                int i20 = ((ViewGroup.LayoutParams) fVar2).height;
                if (i20 == -2) {
                    i20 = measuredHeight;
                    i14 = i12;
                } else if (i20 == -1) {
                    i20 = measuredHeight;
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i19, i18), View.MeasureSpec.makeMeasureSpec(i20, i14));
                if (z3) {
                    measuredHeight -= childAt.getMeasuredHeight();
                } else if (z) {
                    paddingLeft -= childAt.getMeasuredWidth();
                }
            }
            i13++;
        }
        View.MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f2662m = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f2663n = false;
        int childCount2 = getChildCount();
        for (int i21 = 0; i21 < childCount2; i21++) {
            View childAt2 = getChildAt(i21);
            if (childAt2.getVisibility() != 8 && ((fVar = (f) childAt2.getLayoutParams()) == null || !fVar.f2677a)) {
                fVar.getClass();
                childAt2.measure(View.MeasureSpec.makeMeasureSpec((int) (paddingLeft * 0.0f), 1073741824), this.f2662m);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i10, Rect rect) {
        int i11;
        int i12;
        int i13;
        int childCount = getChildCount();
        if ((i10 & 2) != 0) {
            i12 = 1;
            i13 = childCount;
            i11 = 0;
        } else {
            i11 = childCount - 1;
            i12 = -1;
            i13 = -1;
        }
        while (i11 != i13) {
            if (getChildAt(i11).getVisibility() == 0) {
                e();
            }
            i11 += i12;
        }
        return false;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f2657d = savedState.adapterState;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = 0;
        return savedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 != i12) {
            int i14 = this.h;
            i(i10, i12, i14, i14);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            motionEvent.getEdgeFlags();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.f2663n) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setCurrentItem(int i10) {
        setScrollingCacheEnabled(false);
    }

    public void setOffscreenPageLimit(int i10) {
        if (i10 < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i10 + " too small; defaulting to 1");
            i10 = 1;
        }
        if (i10 != this.f2665p) {
            this.f2665p = i10;
        }
    }

    public void setPageMargin(int i10) {
        int i11 = this.h;
        this.h = i10;
        int width = getWidth();
        i(width, width, i10, i11);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f2659j = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setScrollState(int i10) {
        if (this.H == i10) {
            return;
        }
        this.H = i10;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2659j;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        f fVar = new f(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, I);
        fVar.f2678b = typedArrayObtainStyledAttributes.getInteger(0, 48);
        typedArrayObtainStyledAttributes.recycle();
        return fVar;
    }

    public void setPageMarginDrawable(int i10) {
        setPageMarginDrawable(getContext().getDrawable(i10));
    }

    public void setAdapter(androidx.viewpager.widget.a aVar) {
    }

    @Deprecated
    public void setOnPageChangeListener(h hVar) {
    }
}
