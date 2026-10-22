package androidx.slidingpanelayout.widget;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import androidx.customview.view.AbsSavedState;
import c1.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import v0.e0;
import v0.h0;
import v0.m0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SlidingPaneLayout extends ViewGroup {
    public androidx.slidingpanelayout.widget.a A;

    /* renamed from: a, reason: collision with root package name */
    public int f2596a;

    /* renamed from: b, reason: collision with root package name */
    public int f2597b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f2598c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f2599d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2600e;
    public View h;

    /* renamed from: j, reason: collision with root package name */
    public float f2601j;

    /* renamed from: k, reason: collision with root package name */
    public float f2602k;

    /* renamed from: l, reason: collision with root package name */
    public int f2603l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2604m;

    /* renamed from: n, reason: collision with root package name */
    public int f2605n;

    /* renamed from: o, reason: collision with root package name */
    public float f2606o;

    /* renamed from: p, reason: collision with root package name */
    public float f2607p;

    /* renamed from: q, reason: collision with root package name */
    public final CopyOnWriteArrayList f2608q;
    public f r;

    /* renamed from: s, reason: collision with root package name */
    public final c1.c f2609s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f2610t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f2611u;

    /* renamed from: v, reason: collision with root package name */
    public final Rect f2612v;

    /* renamed from: w, reason: collision with root package name */
    public final ArrayList<c> f2613w;

    /* renamed from: x, reason: collision with root package name */
    public int f2614x;

    /* renamed from: y, reason: collision with root package name */
    public androidx.window.layout.f f2615y;
    public final a z;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        boolean isOpen;
        int mLockMode;

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, null);
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

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.isOpen ? 1 : 0);
            parcel.writeInt(this.mLockMode);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.isOpen = parcel.readInt() != 0;
            this.mLockMode = parcel.readInt();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a {
        public a() {
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class b extends v0.a {

        /* renamed from: a, reason: collision with root package name */
        public final Rect f2617a = new Rect();

        public b() {
        }

        @Override // v0.a
        public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.slidingpanelayout.widget.SlidingPaneLayout");
        }

        @Override // v0.a
        public final void onInitializeAccessibilityNodeInfo(View view, w0.b bVar) {
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(bVar.f13532a);
            super.onInitializeAccessibilityNodeInfo(view, new w0.b(accessibilityNodeInfoObtain));
            Rect rect = this.f2617a;
            accessibilityNodeInfoObtain.getBoundsInScreen(rect);
            AccessibilityNodeInfo accessibilityNodeInfo = bVar.f13532a;
            accessibilityNodeInfo.setBoundsInScreen(rect);
            accessibilityNodeInfo.setVisibleToUser(accessibilityNodeInfoObtain.isVisibleToUser());
            accessibilityNodeInfo.setPackageName(accessibilityNodeInfoObtain.getPackageName());
            bVar.h(accessibilityNodeInfoObtain.getClassName());
            bVar.k(accessibilityNodeInfoObtain.getContentDescription());
            accessibilityNodeInfo.setEnabled(accessibilityNodeInfoObtain.isEnabled());
            accessibilityNodeInfo.setClickable(accessibilityNodeInfoObtain.isClickable());
            accessibilityNodeInfo.setFocusable(accessibilityNodeInfoObtain.isFocusable());
            accessibilityNodeInfo.setFocused(accessibilityNodeInfoObtain.isFocused());
            accessibilityNodeInfo.setAccessibilityFocused(accessibilityNodeInfoObtain.isAccessibilityFocused());
            accessibilityNodeInfo.setSelected(accessibilityNodeInfoObtain.isSelected());
            accessibilityNodeInfo.setLongClickable(accessibilityNodeInfoObtain.isLongClickable());
            bVar.a(accessibilityNodeInfoObtain.getActions());
            accessibilityNodeInfo.setMovementGranularities(accessibilityNodeInfoObtain.getMovementGranularities());
            bVar.h("androidx.slidingpanelayout.widget.SlidingPaneLayout");
            bVar.f13534c = -1;
            accessibilityNodeInfo.setSource(view);
            WeakHashMap<View, h0> weakHashMap = e0.f13274a;
            Object parentForAccessibility = view.getParentForAccessibility();
            if (parentForAccessibility instanceof View) {
                bVar.f13533b = -1;
                accessibilityNodeInfo.setParent((View) parentForAccessibility);
            }
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            int childCount = slidingPaneLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = slidingPaneLayout.getChildAt(i10);
                if (!slidingPaneLayout.b(childAt) && childAt.getVisibility() == 0) {
                    childAt.setImportantForAccessibility(1);
                    accessibilityNodeInfo.addChild(childAt);
                }
            }
        }

        @Override // v0.a
        public final boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (SlidingPaneLayout.this.b(view)) {
                return false;
            }
            return super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class c implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class d extends c.AbstractC0028c {
        public d() {
        }

        @Override // c1.c.AbstractC0028c
        public final int a(int i10, View view) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            e eVar = (e) slidingPaneLayout.h.getLayoutParams();
            if (!slidingPaneLayout.c()) {
                int paddingLeft = slidingPaneLayout.getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
                return Math.min(Math.max(i10, paddingLeft), slidingPaneLayout.f2603l + paddingLeft);
            }
            int width = slidingPaneLayout.getWidth() - (slidingPaneLayout.h.getWidth() + (slidingPaneLayout.getPaddingRight() + ((ViewGroup.MarginLayoutParams) eVar).rightMargin));
            return Math.max(Math.min(i10, width), width - slidingPaneLayout.f2603l);
        }

        @Override // c1.c.AbstractC0028c
        public final int b(int i10, View view) {
            return view.getTop();
        }

        @Override // c1.c.AbstractC0028c
        public final int c(View view) {
            return SlidingPaneLayout.this.f2603l;
        }

        @Override // c1.c.AbstractC0028c
        public final void e(int i10) {
            if (l()) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                slidingPaneLayout.f2609s.c(i10, slidingPaneLayout.h);
            }
        }

        @Override // c1.c.AbstractC0028c
        public final void f(int i10) {
            if (l()) {
                SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
                slidingPaneLayout.f2609s.c(i10, slidingPaneLayout.h);
            }
        }

        @Override // c1.c.AbstractC0028c
        public final void g(int i10, View view) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            int childCount = slidingPaneLayout.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = slidingPaneLayout.getChildAt(i11);
                if (childAt.getVisibility() == 4) {
                    childAt.setVisibility(0);
                }
            }
        }

        @Override // c1.c.AbstractC0028c
        public final void h(int i10) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            CopyOnWriteArrayList copyOnWriteArrayList = slidingPaneLayout.f2608q;
            if (slidingPaneLayout.f2609s.f3261a == 0) {
                if (slidingPaneLayout.f2601j != 1.0f) {
                    View view = slidingPaneLayout.h;
                    Iterator it = copyOnWriteArrayList.iterator();
                    while (it.hasNext()) {
                        ((f) it.next()).b(view);
                    }
                    slidingPaneLayout.sendAccessibilityEvent(32);
                    slidingPaneLayout.f2610t = true;
                    return;
                }
                slidingPaneLayout.g(slidingPaneLayout.h);
                View view2 = slidingPaneLayout.h;
                Iterator it2 = copyOnWriteArrayList.iterator();
                while (it2.hasNext()) {
                    ((f) it2.next()).c(view2);
                }
                slidingPaneLayout.sendAccessibilityEvent(32);
                slidingPaneLayout.f2610t = false;
            }
        }

        @Override // c1.c.AbstractC0028c
        public final void i(View view, int i10, int i11) {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            if (slidingPaneLayout.h == null) {
                slidingPaneLayout.f2601j = 0.0f;
            } else {
                boolean zC = slidingPaneLayout.c();
                e eVar = (e) slidingPaneLayout.h.getLayoutParams();
                int width = slidingPaneLayout.h.getWidth();
                if (zC) {
                    i10 = (slidingPaneLayout.getWidth() - i10) - width;
                }
                float paddingRight = (i10 - ((zC ? slidingPaneLayout.getPaddingRight() : slidingPaneLayout.getPaddingLeft()) + (zC ? ((ViewGroup.MarginLayoutParams) eVar).rightMargin : ((ViewGroup.MarginLayoutParams) eVar).leftMargin))) / slidingPaneLayout.f2603l;
                slidingPaneLayout.f2601j = paddingRight;
                if (slidingPaneLayout.f2605n != 0) {
                    slidingPaneLayout.e(paddingRight);
                }
                View view2 = slidingPaneLayout.h;
                Iterator it = slidingPaneLayout.f2608q.iterator();
                while (it.hasNext()) {
                    ((f) it.next()).a(view2);
                }
            }
            slidingPaneLayout.invalidate();
        }

        @Override // c1.c.AbstractC0028c
        public final void j(View view, float f8, float f9) {
            int paddingLeft;
            e eVar = (e) view.getLayoutParams();
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            if (slidingPaneLayout.c()) {
                int paddingRight = slidingPaneLayout.getPaddingRight() + ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
                if (f8 < 0.0f || (f8 == 0.0f && slidingPaneLayout.f2601j > 0.5f)) {
                    paddingRight += slidingPaneLayout.f2603l;
                }
                paddingLeft = (slidingPaneLayout.getWidth() - paddingRight) - slidingPaneLayout.h.getWidth();
            } else {
                paddingLeft = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + slidingPaneLayout.getPaddingLeft();
                if (f8 > 0.0f || (f8 == 0.0f && slidingPaneLayout.f2601j > 0.5f)) {
                    paddingLeft += slidingPaneLayout.f2603l;
                }
            }
            slidingPaneLayout.f2609s.s(paddingLeft, view.getTop());
            slidingPaneLayout.invalidate();
        }

        @Override // c1.c.AbstractC0028c
        public final boolean k(int i10, View view) {
            if (l()) {
                return ((e) view.getLayoutParams()).f2622b;
            }
            return false;
        }

        public final boolean l() {
            SlidingPaneLayout slidingPaneLayout = SlidingPaneLayout.this;
            if (slidingPaneLayout.f2604m || slidingPaneLayout.getLockMode() == 3) {
                return false;
            }
            if (slidingPaneLayout.d() && slidingPaneLayout.getLockMode() == 1) {
                return false;
            }
            return slidingPaneLayout.d() || slidingPaneLayout.getLockMode() != 2;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface f {
        void a(View view);

        void b(View view);

        void c(View view);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class g extends FrameLayout {
        @Override // android.view.View
        public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.View
        public final boolean onTouchEvent(MotionEvent motionEvent) {
            return true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:10:0x007e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public SlidingPaneLayout(android.content.Context r8) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.<init>(android.content.Context):void");
    }

    private n0.b getSystemGestureInsets() {
        WeakHashMap<View, h0> weakHashMap = e0.f13274a;
        m0 m0VarA = e0.e.a(this);
        if (m0VarA != null) {
            return m0VarA.f13309a.j();
        }
        return null;
    }

    private void setFoldingFeatureObserver(androidx.slidingpanelayout.widget.a aVar) {
        this.A = aVar;
        aVar.getClass();
        a onFoldingFeatureChangeListener = this.z;
        kotlin.jvm.internal.g.f(onFoldingFeatureChangeListener, "onFoldingFeatureChangeListener");
        aVar.f2627d = onFoldingFeatureChangeListener;
    }

    public final boolean a() {
        if (!this.f2600e) {
            this.f2610t = false;
        }
        if (!this.f2611u && !f(1.0f)) {
            return false;
        }
        this.f2610t = false;
        return true;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() != 1) {
            super.addView(view, i10, layoutParams);
            return;
        }
        g gVar = new g(view.getContext());
        gVar.addView(view);
        super.addView(gVar, i10, layoutParams);
    }

    public final boolean b(View view) {
        if (view == null) {
            return false;
        }
        return this.f2600e && ((e) view.getLayoutParams()).f2623c && this.f2601j > 0.0f;
    }

    public final boolean c() {
        WeakHashMap<View, h0> weakHashMap = e0.f13274a;
        return getLayoutDirection() == 1;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof e) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final void computeScroll() {
        c1.c cVar = this.f2609s;
        if (cVar.h()) {
            if (!this.f2600e) {
                cVar.a();
            } else {
                WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                postInvalidateOnAnimation();
            }
        }
    }

    public final boolean d() {
        return !this.f2600e || this.f2601j == 0.0f;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i10;
        int right;
        super.draw(canvas);
        Drawable drawable = c() ? this.f2599d : this.f2598c;
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt == null || drawable == null) {
            return;
        }
        int top = childAt.getTop();
        int bottom = childAt.getBottom();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (c()) {
            right = childAt.getRight();
            i10 = intrinsicWidth + right;
        } else {
            int left = childAt.getLeft();
            int i11 = left - intrinsicWidth;
            i10 = left;
            right = i11;
        }
        drawable.setBounds(right, top, i10, bottom);
        drawable.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j10) {
        boolean zC = c() ^ d();
        c1.c cVar = this.f2609s;
        if (zC) {
            cVar.f3276q = 1;
            n0.b systemGestureInsets = getSystemGestureInsets();
            if (systemGestureInsets != null) {
                cVar.f3274o = Math.max(cVar.f3275p, systemGestureInsets.f10588a);
            }
        } else {
            cVar.f3276q = 2;
            n0.b systemGestureInsets2 = getSystemGestureInsets();
            if (systemGestureInsets2 != null) {
                cVar.f3274o = Math.max(cVar.f3275p, systemGestureInsets2.f10590c);
            }
        }
        e eVar = (e) view.getLayoutParams();
        int iSave = canvas.save();
        if (this.f2600e && !eVar.f2622b && this.h != null) {
            Rect rect = this.f2612v;
            canvas.getClipBounds(rect);
            if (c()) {
                rect.left = Math.max(rect.left, this.h.getRight());
            } else {
                rect.right = Math.min(rect.right, this.h.getLeft());
            }
            canvas.clipRect(rect);
        }
        boolean zDrawChild = super.drawChild(canvas, view, j10);
        canvas.restoreToCount(iSave);
        return zDrawChild;
    }

    public final void e(float f8) {
        boolean zC = c();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt != this.h) {
                float f9 = 1.0f - this.f2602k;
                int i11 = this.f2605n;
                this.f2602k = f8;
                int i12 = ((int) (f9 * i11)) - ((int) ((1.0f - f8) * i11));
                if (zC) {
                    i12 = -i12;
                }
                childAt.offsetLeftAndRight(i12);
            }
        }
    }

    public final boolean f(float f8) {
        int paddingLeft;
        if (this.f2600e) {
            boolean zC = c();
            e eVar = (e) this.h.getLayoutParams();
            if (zC) {
                int paddingRight = getPaddingRight() + ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
                paddingLeft = (int) (getWidth() - (((f8 * this.f2603l) + paddingRight) + this.h.getWidth()));
            } else {
                paddingLeft = (int) ((f8 * this.f2603l) + getPaddingLeft() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin);
            }
            View view = this.h;
            if (this.f2609s.u(view, paddingLeft, view.getTop())) {
                int childCount = getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = getChildAt(i10);
                    if (childAt.getVisibility() == 4) {
                        childAt.setVisibility(0);
                    }
                }
                WeakHashMap<View, h0> weakHashMap = e0.f13274a;
                postInvalidateOnAnimation();
                return true;
            }
        }
        return false;
    }

    public final void g(View view) {
        int left;
        int right;
        int top;
        int bottom;
        boolean z;
        View view2 = view;
        boolean zC = c();
        int width = zC ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = zC ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view2 == null || !view2.isOpaque()) {
            left = 0;
            right = 0;
            top = 0;
            bottom = 0;
        } else {
            left = view2.getLeft();
            right = view2.getRight();
            top = view2.getTop();
            bottom = view2.getBottom();
        }
        int childCount = getChildCount();
        int i10 = 0;
        while (i10 < childCount) {
            View childAt = getChildAt(i10);
            if (childAt == view2) {
                return;
            }
            if (childAt.getVisibility() == 8) {
                z = zC;
            } else {
                z = zC;
                childAt.setVisibility((Math.max(zC ? paddingLeft : width, childAt.getLeft()) < left || Math.max(paddingTop, childAt.getTop()) < top || Math.min(zC ? width : paddingLeft, childAt.getRight()) > right || Math.min(height, childAt.getBottom()) > bottom) ? 0 : 4);
            }
            i10++;
            view2 = view;
            zC = z;
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            e eVar = new e((ViewGroup.MarginLayoutParams) layoutParams);
            eVar.f2621a = 0.0f;
            return eVar;
        }
        e eVar2 = new e(layoutParams);
        eVar2.f2621a = 0.0f;
        return eVar2;
    }

    @Deprecated
    public int getCoveredFadeColor() {
        return this.f2597b;
    }

    public final int getLockMode() {
        return this.f2614x;
    }

    public int getParallaxDistance() {
        return this.f2605n;
    }

    @Deprecated
    public int getSliderFadeColor() {
        return this.f2596a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        Activity activity;
        super.onAttachedToWindow();
        this.f2611u = true;
        if (this.A != null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                } else {
                    if (context instanceof Activity) {
                        activity = (Activity) context;
                        break;
                    }
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            if (activity != null) {
                androidx.slidingpanelayout.widget.a aVar = this.A;
                aVar.getClass();
                Job job = aVar.f2626c;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, null, 1, null);
                }
                aVar.f2626c = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(ExecutorsKt.from(aVar.f2625b)), null, null, new FoldingFeatureObserver$registerLayoutStateChangeCallback$1(aVar, activity, null), 3, null);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        Job job;
        super.onDetachedFromWindow();
        this.f2611u = true;
        androidx.slidingpanelayout.widget.a aVar = this.A;
        if (aVar != null && (job = aVar.f2626c) != null) {
            Job.DefaultImpls.cancel$default(job, null, 1, null);
        }
        ArrayList<c> arrayList = this.f2613w;
        if (arrayList.size() <= 0) {
            arrayList.clear();
        } else {
            arrayList.get(0).getClass();
            throw null;
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        boolean z3 = this.f2600e;
        c1.c cVar = this.f2609s;
        if (!z3 && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            int x3 = (int) motionEvent.getX();
            int y3 = (int) motionEvent.getY();
            cVar.getClass();
            this.f2610t = c1.c.l(childAt, x3, y3);
        }
        if (!this.f2600e || (this.f2604m && actionMasked != 0)) {
            cVar.b();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked == 3 || actionMasked == 1) {
            cVar.b();
            return false;
        }
        if (actionMasked == 0) {
            this.f2604m = false;
            float x8 = motionEvent.getX();
            float y5 = motionEvent.getY();
            this.f2606o = x8;
            this.f2607p = y5;
            cVar.getClass();
            if (c1.c.l(this.h, (int) x8, (int) y5) && b(this.h)) {
                z = true;
            }
            return !cVar.t(motionEvent) || z;
        }
        if (actionMasked == 2) {
            float x10 = motionEvent.getX();
            float y8 = motionEvent.getY();
            float fAbs = Math.abs(x10 - this.f2606o);
            float fAbs2 = Math.abs(y8 - this.f2607p);
            if (fAbs > cVar.f3262b && fAbs2 > fAbs) {
                cVar.b();
                this.f2604m = true;
                return false;
            }
        }
        z = false;
        if (cVar.t(motionEvent)) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d8  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0089 A[PHI: r17
      0x0089: PHI (r17v3 float) = (r17v1 float), (r17v4 float) binds: [B:19:0x007f, B:21:0x0085] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01b4  */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v30 */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r24, int r25) {
        /*
            Method dump skipped, instructions count: 804
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.SlidingPaneLayout.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.isOpen) {
            if (!this.f2600e) {
                this.f2610t = true;
            }
            if (this.f2611u || f(0.0f)) {
                this.f2610t = true;
            }
        } else {
            a();
        }
        this.f2610t = savedState.isOpen;
        setLockMode(savedState.mLockMode);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.isOpen = this.f2600e ? d() : this.f2610t;
        savedState.mLockMode = this.f2614x;
        return savedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i10 != i12) {
            this.f2611u = true;
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f2600e) {
            return super.onTouchEvent(motionEvent);
        }
        c1.c cVar = this.f2609s;
        cVar.m(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            float x3 = motionEvent.getX();
            float y3 = motionEvent.getY();
            this.f2606o = x3;
            this.f2607p = y3;
            return true;
        }
        if (actionMasked == 1 && b(this.h)) {
            float x8 = motionEvent.getX();
            float y5 = motionEvent.getY();
            float f8 = x8 - this.f2606o;
            float f9 = y5 - this.f2607p;
            int i10 = cVar.f3262b;
            if ((f9 * f9) + (f8 * f8) < i10 * i10 && c1.c.l(this.h, (int) x8, (int) y5)) {
                a();
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (view.getParent() instanceof g) {
            super.removeView((View) view.getParent());
        } else {
            super.removeView(view);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (isInTouchMode() || this.f2600e) {
            return;
        }
        this.f2610t = view == this.h;
    }

    @Deprecated
    public void setCoveredFadeColor(int i10) {
        this.f2597b = i10;
    }

    public final void setLockMode(int i10) {
        this.f2614x = i10;
    }

    @Deprecated
    public void setPanelSlideListener(f fVar) {
        f fVar2 = this.r;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f2608q;
        if (fVar2 != null) {
            copyOnWriteArrayList.remove(fVar2);
        }
        if (fVar != null) {
            copyOnWriteArrayList.add(fVar);
        }
        this.r = fVar;
    }

    public void setParallaxDistance(int i10) {
        this.f2605n = i10;
        requestLayout();
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.f2598c = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.f2599d = drawable;
    }

    @Deprecated
    public void setShadowResource(int i10) {
        setShadowDrawableLeft(getResources().getDrawable(i10));
    }

    public void setShadowResourceLeft(int i10) {
        setShadowDrawableLeft(getContext().getDrawable(i10));
    }

    public void setShadowResourceRight(int i10) {
        setShadowDrawableRight(getContext().getDrawable(i10));
    }

    @Deprecated
    public void setSliderFadeColor(int i10) {
        this.f2596a = i10;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class e extends ViewGroup.MarginLayoutParams {

        /* renamed from: d, reason: collision with root package name */
        public static final int[] f2620d = {R.attr.layout_weight};

        /* renamed from: a, reason: collision with root package name */
        public float f2621a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f2622b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f2623c;

        public e() {
            super(-1, -1);
            this.f2621a = 0.0f;
        }

        public e(int i10) {
            super(i10, -1);
            this.f2621a = 0.0f;
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        e eVar = new e(context, attributeSet);
        eVar.f2621a = 0.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.f2620d);
        eVar.f2621a = typedArrayObtainStyledAttributes.getFloat(0, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        return eVar;
    }
}
