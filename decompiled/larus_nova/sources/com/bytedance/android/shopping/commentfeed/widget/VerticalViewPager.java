package com.bytedance.android.shopping.commentfeed.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.core.os.ParcelableCompat;
import androidx.core.os.ParcelableCompatCreatorCallbacks;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.alipay.sdk.m.u.i;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class VerticalViewPager extends ViewGroup {
    public static final b H0 = null;
    public static final Field L0 = null;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final int[] f172447k0 = null;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public static final a f172448p0 = null;
    public int A;
    public int B;
    public int C;
    public float D;
    public float E;
    public float F;
    public float G;
    public int H;
    public VelocityTracker I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public int f172449J;
    public int K;
    public int L;
    public int M;
    public EdgeEffectCompat N;
    public EdgeEffectCompat O;
    public boolean P;
    public boolean Q;
    public int R;
    public final List<ViewPager.OnPageChangeListener> S;
    public Method T;
    public final c U;
    public int V;
    public boolean W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f172450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f172451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<e> f172452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f172453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Rect f172454e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PagerAdapter f172455f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f172456g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f172457h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Parcelable f172458i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ClassLoader f172459j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Scroller f172460k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f172461l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public h f172462m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f172463n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Drawable f172464o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f172465p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f172466q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f172467r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f172468s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f172469t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f172470u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f172471v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f172472w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f172473x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f172474y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f172475z;

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f172476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f172477b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f172478c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f172479d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f172480e;

        public LayoutParams() {
            super(-1, -1);
            this.f172478c = 0.0f;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.f172478c = 0.0f;
            TypedArray r102 = r100.obtainStyledAttributes(r101, VerticalViewPager.f172447k0);
            this.f172477b = r102.getInteger(0, 48);
            r102.recycle();
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f172481a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Parcelable f172482b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ClassLoader f172483c;

        public class a implements ParcelableCompatCreatorCallbacks<SavedState> {
            public a() {
            }

            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            public final SavedState[] newArray(int r100) {
                return new SavedState[r100];
            }

            @Override // androidx.core.os.ParcelableCompatCreatorCallbacks
            public final SavedState createFromParcel(Parcel r100, ClassLoader r101) {
                return new SavedState(r100, r101);
            }
        }

        static {
            CREATOR = ParcelableCompat.newCreator(new a());
        }

        public final String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f172481a + i.f25855d;
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        public SavedState(Parcel r100, ClassLoader r101) {
            super(r100);
            if (r101 != null) goto L5;
            r101 = getClass().getClassLoader();
        L5:
            this.f172481a = r100.readInt();
            this.f172482b = r100.readParcelable(r101);
            this.f172483c = r101;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeInt(this.f172481a);
            r100.writeParcelable(this.f172482b, r101);
        }
    }

    public class a implements Comparator<e> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(e r100, e r101) {
            return r100.f172488b - r101.f172488b;
        }
    }

    public class b implements Interpolator {
        public b() {
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float r100) {
            float r101 = r100 - 1.0f;
            return ((((r101 * r101) * r101) * r101) * r101) + 1.0f;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VerticalViewPager f172484a;

        @Override // java.lang.Runnable
        public final void run() {
            VerticalViewPager.a(this.f172484a);     // Catch: Throwable -> L4
            this.f172484a.q();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(VerticalViewPager r100) {
            this.f172484a = r100;
        }
    }

    public class d implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f172485a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VerticalViewPager f172486b;

        public d(VerticalViewPager r100) {
            this.f172486b = r100;
            this.f172485a = new Rect();
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
            WindowInsetsCompat r102 = ViewCompat.onApplyWindowInsets(r100, r101);
            if (r102.isConsumed() == false) goto L5;
            return r102;
        L5:
            Rect r103 = this.f172485a;
            r103.left = r102.getSystemWindowInsetLeft();
            r103.top = r102.getSystemWindowInsetTop();
            r103.right = r102.getSystemWindowInsetRight();
            r103.bottom = r102.getSystemWindowInsetBottom();
            int r104 = this.f172486b.getChildCount();
            int r105 = 0;
        L6:
            if (r105 >= r104) goto L9;
            WindowInsetsCompat r106 = ViewCompat.dispatchApplyWindowInsets(this.f172486b.getChildAt(r105), r102);
            r103.left = Math.min(r106.getSystemWindowInsetLeft(), r103.left);
            r103.top = Math.min(r106.getSystemWindowInsetTop(), r103.top);
            r103.right = Math.min(r106.getSystemWindowInsetRight(), r103.right);
            r103.bottom = Math.min(r106.getSystemWindowInsetBottom(), r103.bottom);
            r105 = r105 + 1;
            goto L6
        L9:
            return r102.replaceSystemWindowInsets(r103.left, r103.top, r103.right, r103.bottom);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f172487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f172488b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f172489c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f172490d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f172491e;

        public e() {
        }
    }

    public class f extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VerticalViewPager f172492a;

        public f(VerticalViewPager r100) {
            this.f172492a = r100;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityEvent(View r100, AccessibilityEvent r101) {
            super.onInitializeAccessibilityEvent(r100, r101);
            r101.setClassName(ViewPager.class.getName());
            AccessibilityRecordCompat r102 = AccessibilityRecordCompat.obtain();
            PagerAdapter r103 = this.f172492a.f172455f;
            if (r103 == null) goto L7;
            boolean r104 = true;
            if (r103.getCount() <= 1) goto L7;
        L8:
            r102.setScrollable(r104);
            if (r101.getEventType() != 4096) goto L14;
            PagerAdapter r105 = this.f172492a.f172455f;
            if (r105 == null) goto L15;
            r102.setItemCount(r105.getCount());
            r102.setFromIndex(this.f172492a.f172456g);
            r102.setToIndex(this.f172492a.f172456g);
            return;
        L15:
            return;
        L14:
            return;
        L7:
            r104 = false;
            goto L8
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101) {
            super.onInitializeAccessibilityNodeInfo(r100, r101);
            r101.setClassName(ViewPager.class.getName());
            PagerAdapter r102 = this.f172492a.f172455f;
            if (r102 != null) goto L5;
        L7:
            boolean r103 = false;
        L8:
            r101.setScrollable(r103);
            if (this.f172492a.canScrollVertically(1) == false) goto L12;
            r101.addAction(4096);
        L12:
            if (this.f172492a.canScrollVertically(-1) == false) goto L15;
            r101.addAction(8192);
            return;
        L15:
            return;
        L5:
            if (r102.getCount() <= 1) goto L7;
            r103 = true;
            goto L8
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public final boolean performAccessibilityAction(View r100, int r101, Bundle r102) {
            if (super.performAccessibilityAction(r100, r101, r102) == false) goto L6;
            return true;
        L6:
            if (r101 == 4096) goto L16;
            if (r101 == 8192) goto L11;
            return false;
        L11:
            if (this.f172492a.canScrollVertically(-1) == false) goto L14;
            VerticalViewPager r103 = this.f172492a;
            r103.setCurrentItem(r103.f172456g - 1);
            return true;
        L14:
            return false;
        L16:
            if (this.f172492a.canScrollVertically(1) == false) goto L19;
            VerticalViewPager r104 = this.f172492a;
            r104.setCurrentItem(r104.f172456g + 1);
            return true;
        L19:
            return false;
        }
    }

    public interface g {
    }

    public class h extends DataSetObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VerticalViewPager f172493a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            this.f172493a.f();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            this.f172493a.f();
        }

        public h(VerticalViewPager r100) {
            this.f172493a = r100;
        }
    }

    static {
        f172447k0 = new int[]{R.attr.layout_gravity};
        f172448p0 = new a();
        H0 = new b();
        Field r100 = PagerAdapter.class.getDeclaredField("mViewPagerObserver");     // Catch: NoSuchFieldException -> L5
        L0 = r100;     // Catch: NoSuchFieldException -> L5
        r100.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        return;
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // android.view.View
    public final void computeScroll() {
        this.f172461l = true;
        if (this.f172460k.isFinished() == false) goto L5;
    L14:
        e(true);
        return;
    L5:
        if (this.f172460k.computeScrollOffset() == false) goto L14;
        int r100 = getScrollX();
        int r101 = getScrollY();
        int r102 = this.f172460k.getCurrX();
        int r103 = this.f172460k.getCurrY();
        if (r100 != r102) goto L9;
        if (r101 != r103) goto L9;
    L12:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L9:
        scrollTo(r102, r103);
        if (o(r103) == true) goto L12;
        this.f172460k.abortAnimation();
        scrollTo(r102, 0);
        goto L12
    }

    public final void l() {
        this.f172450a = true;
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context r100 = getContext();
        this.f172460k = new Scroller(r100, H0);
        ViewConfiguration r101 = ViewConfiguration.get(r100);
        Resources r102 = r100.getResources();
        float r103 = WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density;
        this.C = ViewConfigurationCompat.getScaledPagingTouchSlop(r101);
        this.f172449J = (int) (400.0f * r103);
        this.K = r101.getScaledMaximumFlingVelocity();
        this.N = new EdgeEffectCompat(r100);
        this.O = new EdgeEffectCompat(r100);
        this.L = (int) (25.0f * r103);
        this.M = (int) (2.0f * r103);
        this.A = (int) (r103 * 16.0f);
        ViewCompat.setAccessibilityDelegate(this, new f(this));
        if (ViewCompat.getImportantForAccessibility(this) != 0) goto L5;
        ViewCompat.setImportantForAccessibility(this, 1);
    L5:
        ViewCompat.setOnApplyWindowInsetsListener(this, new d(this));
    }

    public void setOnAdapterChangeListener(g r100) {
    }

    public final boolean t() {
        this.H = -1;
        this.f172474y = false;
        this.f172475z = false;
        VelocityTracker r100 = this.I;
        if (r100 == null) goto L6;
        r100.recycle();
        this.I = null;
    L6:
        return this.N.onRelease() | this.O.onRelease();
    }

    public final void f() {
        int r100 = this.f172455f.getCount();
        this.f172451b = r100;
        if (this.f172452c.size() < ((this.f172473x * 2) + 1)) goto L5;
    L7:
        boolean r101 = false;
    L8:
        int r102 = this.f172456g;
        int r103 = 0;
        boolean r104 = false;
    L10:
        if (r103 >= this.f172452c.size()) goto L30;
        e r105 = (e) ListProtector.get(this.f172452c, r103);
        int r106 = this.f172455f.getItemPosition(r105.f172487a);
        if (r106 == (-1)) goto L29;
        if (r106 != (-2)) goto L22;
        ListProtector.remove(this.f172452c, r103);
        r103 = r103 - 1;
        if (r104 == true) goto L19;
        this.f172455f.startUpdate(this);
        r104 = true;
    L19:
        this.f172455f.destroyItem(this, r105.f172488b, r105.f172487a);
        int r107 = this.f172456g;
        if (r107 != r105.f172488b) goto L28;
        r102 = Math.max(0, Math.min(r107, (-1) + r100));
    L28:
        r101 = true;
        goto L29
    L22:
        int r108 = r105.f172488b;
        if (r108 == r106) goto L29;
        if (r108 != this.f172456g) goto L27;
        r102 = r106;
    L27:
        r105.f172488b = r106;
    L29:
        r103 = r103 + 1;
        goto L10
    L30:
        if (r104 == false) goto L32;
        this.f172455f.finishUpdate(this);
    L32:
        Collections.sort(this.f172452c, f172448p0);
        if (r101 == false) goto L49;
        int r109 = getChildCount();
        int r110 = 0;
    L35:
        if (r110 >= r109) goto L40;
        LayoutParams r111 = (LayoutParams) getChildAt(r110).getLayoutParams();
        if (r111.f172476a == true) goto L39;
        r111.f172478c = 0.0f;
    L39:
        r110 = r110 + 1;
        goto L35
    L40:
        v(r102, false, true, 0);
        requestLayout();
        return;
    L49:
        return;
    L5:
        if (this.f172452c.size() >= r100) goto L7;
        r101 = true;
        goto L8
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.U);
        Scroller r100 = this.f172460k;
        if (r100 != null) goto L5;
    L7:
        super.onDetachedFromWindow();
        return;
    L5:
        if (r100.isFinished() == true) goto L7;
        this.f172460k.abortAnimation();
        goto L7
    }

    public final void q() {
        r(this.f172456g);
    }

    private int getClientHeight() {
        return (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable r100 = this.f172464o;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isStateful() == false) goto L9;
        r100.setState(getDrawableState());
        return;
    }

    public final e j() {
        int r100 = getClientHeight();
        float r101 = 0.0f;
        if (r100 <= 0) goto L5;
        float r102 = getScrollY() / r100;
    L6:
        if (r100 <= 0) goto L8;
        float r103 = this.f172463n / r100;
    L9:
        e r104 = null;
        float r105 = 0.0f;
        int r106 = -1;
        int r107 = 0;
        boolean r108 = true;
    L11:
        if (r107 >= this.f172452c.size()) goto L30;
        e r110 = (e) ListProtector.get(this.f172452c, r107);
        if (r108 == true) goto L17;
        int r109 = r106 + 1;
        if (r110.f172488b == r109) goto L17;
        r110 = this.f172453d;
        r110.f172491e = (r101 + r105) + r103;
        r110.f172488b = r109;
        r110.f172490d = this.f172455f.getPageWidth(r109);
        r107 = r107 - 1;
    L17:
        e r111 = r110;
        r101 = r111.f172491e;
        float r112 = (r111.f172490d + r101) + r103;
        if (r108 == true) goto L24;
        if (r102 >= r101) goto L24;
        return r104;
    L24:
        if (r102 < r112) goto L29;
        if (r107 == (this.f172452c.size() - 1)) goto L29;
        int r113 = r111.f172488b;
        float r114 = r111.f172490d;
        r107 = r107 + 1;
        r108 = false;
        r106 = r113;
        r105 = r114;
        r104 = r111;
    L29:
        return r111;
    L30:
        return r104;
    L8:
        r103 = 0.0f;
        goto L9
    L5:
        r102 = 0.0f;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.P = true;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        r100.f172481a = this.f172456g;
        PagerAdapter r101 = this.f172455f;
        if (r101 == null) goto L5;
        r100.f172482b = r101.saveState();
    L5:
        return r100;
    }

    public PagerAdapter getAdapter() {
        return this.f172455f;
    }

    public int getCurrentItem() {
        return this.f172456g;
    }

    public int getExpectedAdapterCount() {
        return this.f172451b;
    }

    public int getOffscreenPageLimit() {
        return this.f172473x;
    }

    public int getPageMargin() {
        return this.f172463n;
    }

    public VerticalViewPager(Context r100) {
        super(r100);
        this.f172452c = new ArrayList();
        this.f172453d = new e();
        this.f172454e = new Rect();
        this.f172457h = -1;
        this.f172458i = null;
        this.f172459j = null;
        this.f172467r = -3.4028235E38f;
        this.f172468s = Float.MAX_VALUE;
        this.f172473x = 1;
        this.H = -1;
        this.P = true;
        this.S = new ArrayList();
        this.U = new c(this);
        this.V = 0;
        this.W = false;
        l();
    }

    public static /* synthetic */ void a(VerticalViewPager r100) {
        r100.setScrollState(0);
    }

    private void setScrollState(int r100) {
        if (this.V != r100) goto L5;
        return;
    L5:
        this.V = r100;
        List<ViewPager.OnPageChangeListener> r101 = this.S;
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.isEmpty() == true) goto L15;
        Iterator<ViewPager.OnPageChangeListener> r102 = this.S.iterator();
    L11:
        if (r102.hasNext() == false) goto L16;
        r102.next().onPageScrollStateChanged(r100);
        goto L11
    L16:
        return;
    }

    private void setScrollingCacheEnabled(boolean r100) {
        if (this.f172471v == r100) goto L6;
        this.f172471v = r100;
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addTouchables(ArrayList<View> r100) {
        int r101 = 0;
    L4:
        if (r101 >= getChildCount()) goto L13;
        View r102 = getChildAt(r101);
        if (r102.getVisibility() != 0) goto L12;
        e r103 = i(r102);
        if (r103 == null) goto L12;
        if (r103.f172488b != this.f172456g) goto L12;
        r102.addTouchables(r100);
    L12:
        r101 = r101 + 1;
        goto L4
    }

    public final boolean c(int r100) {
        View r101 = findFocus();
        boolean r102 = true;
        boolean r103 = false;
        if (r101 == this) goto L19;
        if (r101 == null) goto L20;
        ViewParent r104 = r101.getParent();
    L8:
        if ((r104 instanceof ViewGroup) == false) goto L12;
        if (r104 == this) goto L10;
        r104 = r104.getParent();
        goto L8
    L10:
        boolean r105 = true;
    L13:
        if (r105 == true) goto L20;
        ViewParent r106 = r101.getParent();
    L16:
        if ((r106 instanceof ViewGroup) == false) goto L19;
        r106.getClass();
        r106 = r106.getParent();
        goto L16
    L12:
        r105 = false;
    L20:
        View r107 = FocusFinder.getInstance().findNextFocus(this, r101, r100);
        if (r107 == null) goto L42;
        if (r107 == r101) goto L42;
        if (r100 != 33) goto L32;
        int r108 = h(this.f172454e, r107).top;
        int r109 = h(this.f172454e, r101).top;
        if (r101 == null) goto L30;
        if (r108 < r109) goto L30;
        int r110 = this.f172456g;
        if (r110 <= 0) goto L56;
        this.f172472w = false;
        v(r110 - 1, true, false, 0);
    L57:
        r103 = r102;
    L58:
        if (r103 == false) goto L60;
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(r100));
    L60:
        return r103;
    L56:
        r102 = false;
    L30:
        boolean r111 = r107.requestFocus();
    L31:
        r103 = r111;
        goto L58
    L32:
        if (r100 != 130) goto L58;
        int r112 = h(this.f172454e, r107).bottom;
        int r113 = h(this.f172454e, r101).bottom;
        if (r101 == null) goto L41;
        if (r112 > r113) goto L41;
        PagerAdapter r114 = this.f172455f;
        if (r114 == null) goto L56;
        if (this.f172456g >= (r114.getCount() - 1)) goto L56;
        int r115 = this.f172456g + 1;
        this.f172472w = false;
        v(r115, true, false, 0);
    L41:
        r111 = r107.requestFocus();
    L42:
        if (r100 == 33) goto L53;
        if (r100 == 1) goto L53;
        if (r100 != 130) goto L47;
    L48:
        PagerAdapter r116 = this.f172455f;
        if (r116 == null) goto L56;
        if (this.f172456g >= (r116.getCount() - 1)) goto L56;
        int r117 = this.f172456g + 1;
        this.f172472w = false;
        v(r117, true, false, 0);
        goto L57
    L47:
        if (r100 != 2) goto L58;
    L53:
        int r118 = this.f172456g;
        if (r118 <= 0) goto L56;
        this.f172472w = false;
        v(r118 - 1, true, false, 0);
    L19:
        r101 = null;
        goto L20
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int r100) {
        if (this.f172455f != null) goto L5;
        return false;
    L5:
        int r101 = getClientHeight();
        int r102 = getScrollY();
        if (r100 < 0) goto L8;
        if (r100 > 0) goto L13;
        return false;
    L13:
        if (r102 >= ((int) (r101 * this.f172468s))) goto L18;
        return true;
    L18:
        return false;
    L8:
        if (r102 <= ((int) (r101 * this.f172467r))) goto L16;
        return true;
    L16:
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        if ((r100 instanceof LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.checkLayoutParams(r100) == false) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        if (super.dispatchKeyEvent(r100) == false) goto L5;
        return true;
    L5:
        if (r100.getAction() != 0) goto L21;
        int r101 = r100.getKeyCode();
        if (r101 != 21) goto L9;
        boolean r102 = c(17);
    L22:
        if (r102 == true) goto L27;
        return false;
    L27:
        return true;
    L9:
        if (r101 != 22) goto L11;
        r102 = c(66);
        goto L22
    L11:
        if (r101 != 61) goto L21;
        if (r100.hasNoModifiers() == false) goto L17;
        r102 = c(2);
        goto L22
    L17:
        if (r100.hasModifiers(1) == false) goto L21;
        r102 = c(1);
    L21:
        r102 = false;
        goto L22
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r100) {
        if (r100.getEventType() == 4096) goto L5;
        int r101 = getChildCount();
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L19;
        View r103 = getChildAt(r102);
        if (r103.getVisibility() != 0) goto L18;
        e r104 = i(r103);
        if (r104 == null) goto L18;
        if (r104.f172488b != this.f172456g) goto L18;
        if (r103.dispatchPopulateAccessibilityEvent(r100) == false) goto L18;
        return true;
    L18:
        r102 = r102 + 1;
        goto L7
    L19:
        return false;
    L5:
        return super.dispatchPopulateAccessibilityEvent(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (this.f172450a == true) goto L5;
    L7:
        return false;
    L5:
        if (super.dispatchTouchEvent(r100) == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        super.draw(r100);     // Catch: Exception -> L4
    L6:
        int r101 = ViewCompat.getOverScrollMode(this);
        boolean r102 = false;
        if (r101 == 0) goto L17;
        if (r101 != 1) goto L15;
        PagerAdapter r103 = this.f172455f;
        if (r103 == null) goto L15;
        if (r103.getCount() > 1) goto L17;
    L15:
        this.N.finish();
        this.O.finish();
    L22:
        if (r102 == false) goto L27;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L27:
        return;
    L17:
        if (this.N.isFinished() == true) goto L20;
        int r104 = r100.save();
        int r105 = getHeight();
        int r106 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        r100.translate(getPaddingLeft(), this.f172467r * r105);
        this.N.setSize(r106, r105);
        r102 = false | this.N.draw(r100);
        r100.restoreToCount(r104);
    L20:
        if (this.O.isFinished() == true) goto L22;
        int r107 = r100.save();
        int r108 = getHeight();
        int r109 = (getWidth() - getPaddingLeft()) - getPaddingRight();
        r100.rotate(180.0f);
        r100.translate((-r109) - getPaddingLeft(), (-(this.f172468s + 1.0f)) * r108);
        this.O.setSize(r109, r108);
        r102 = r102 | this.O.draw(r100);
        r100.restoreToCount(r107);
    L4:
        e = move-exception;
        com.bytedance.article.common.monitor.stack.a.a(e, "VerticalViewPager");
        goto L6
    }

    public final void e(boolean r100) {
        if (this.V != 2) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L15;
        setScrollingCacheEnabled(false);
        if ((!this.f172460k.isFinished()) == false) goto L15;
        this.f172460k.abortAnimation();
        int r102 = getScrollX();
        int r103 = getScrollY();
        int r104 = this.f172460k.getCurrX();
        int r105 = this.f172460k.getCurrY();
        if (r102 != r104) goto L12;
        if (r103 == r105) goto L15;
    L12:
        scrollTo(r104, r105);
        if (r105 == r103) goto L15;
        o(r105);
    L15:
        this.f172472w = false;
        int r106 = 0;
    L17:
        if (r106 >= this.f172452c.size()) goto L22;
        e r107 = (e) ListProtector.get(this.f172452c, r106);
        if (r107.f172489c == false) goto L21;
        r107.f172489c = false;
        r101 = true;
    L21:
        r106 = r106 + 1;
        goto L17
    L22:
        if (r101 == false) goto L30;
        if (r100 == false) goto L25;
        ViewCompat.postOnAnimation(this, this.U);
        return;
    L25:
        this.U.run();
        return;
    L30:
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        return new LayoutParams(getContext(), r100);
    }

    public final e i(View r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.f172452c.size()) goto L9;
        e r102 = (e) ListProtector.get(this.f172452c, r101);
        if (this.f172455f.isViewFromObject(r100, r102.f172487a) == true) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return r102;
    L9:
        return null;
    }

    public final e k(int r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.f172452c.size()) goto L9;
        e r102 = (e) ListProtector.get(this.f172452c, r101);
        if (r102.f172488b == r100) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return r102;
    L9:
        return null;
    }

    public final void n(MotionEvent r100) {
        int r101 = r100.getActionIndex();
        if (r100.getPointerId(r101) != this.H) goto L11;
        if (r101 != 0) goto L6;
        int r102 = 1;
    L7:
        this.E = r100.getY(r102);
        this.H = r100.getPointerId(r102);
        VelocityTracker r103 = this.I;
        if (r103 == null) goto L12;
        r103.clear();
        return;
    L12:
        return;
    L6:
        r102 = 0;
        goto L7
    }

    public final boolean o(int r100) {
        if (this.f172452c.size() == 0) goto L5;
        e r101 = j();
        int r102 = getClientHeight();
        int r103 = this.f172463n;
        int r104 = r102 + r103;
        float r105 = r102;
        float r106 = r103 / r105;
        if (r101 != null) goto L15;
        return false;
    L15:
        int r107 = r101.f172488b;
        float r108 = ((r100 / r105) - r101.f172491e) / (r101.f172490d + r106);
        this.Q = false;
        m(r107, r108, (int) (r104 * r108));
        if (this.Q == false) goto L20;
        return true;
    L20:
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    L5:
        if (this.P == false) goto L7;
        return false;
    L7:
        this.Q = false;
        m(0, 0.0f, 0);
        if (this.Q == false) goto L11;
        return false;
    L11:
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        super.onDraw(r110);
        if (this.f172463n > 0) goto L5;
        return;
    L5:
        if (this.f172464o != null) goto L7;
        return;
    L7:
        if (this.f172452c.size() > 0) goto L9;
        return;
    L9:
        if (this.f172455f == null) goto L34;
        int r100 = getScrollY();
        int r101 = getHeight();
        float r102 = r101;
        float r103 = this.f172463n / r102;
        int r104 = 0;
        e r105 = (e) ListProtector.get(this.f172452c, 0);
        float r106 = r105.f172491e;
        int r107 = this.f172452c.size();
        int r108 = r105.f172488b;
        int r111 = ((e) ListProtector.get(this.f172452c, r107 - 1)).f172488b;
    L11:
        if (r108 >= r111) goto L35;
    L12:
        int r112 = r105.f172488b;
        if (r108 <= r112) goto L16;
        if (r104 >= r107) goto L16;
        r104 = r104 + 1;
        r105 = (e) ListProtector.get(this.f172452c, r104);
    L16:
        if (r108 != r112) goto L18;
        float r109 = r105.f172491e;
        float r113 = r105.f172490d;
        float r114 = (r109 + r113) * r102;
        r106 = (r109 + r113) + r103;
    L19:
        int r115 = this.f172463n;
        if ((r115 + r114) <= r100) goto L24;
        this.f172464o.setBounds(this.f172465p, (int) r114, this.f172466q, (int) ((r115 + r114) + 0.5f));
        this.f172464o.draw(r110);
    L24:
        if (r114 > (r100 + r101)) goto L36;
        r108 = r108 + 1;
        r103 = r103;
        goto L11
    L36:
        return;
    L18:
        float r116 = this.f172455f.getPageWidth(r108);
        r114 = (r106 + r116) * r102;
        r106 = r106 + (r116 + r103);
        goto L19
    L35:
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r110) {
        if (this.W == false) goto L82;
        return false;
    L82:
        int r100 = r110.getAction() & 255;     // Catch: IllegalArgumentException -> L78
        if (r100 != 3) goto L8;
    L76:
        t();     // Catch: IllegalArgumentException -> L78
        return false;
    L8:
        if (r100 == 1) goto L76;
        if (r100 == 0) goto L18;
        if (this.f172474y == false) goto L15;
        return true;
    L15:
        if (this.f172475z == false) goto L18;
        return false;
    L18:
        if (r100 == 0) goto L63;
        if (r100 != 2) goto L21;
        int r101 = this.H;     // Catch: IllegalArgumentException -> L78
        if (r101 == (-1)) goto L73;
        int r102 = r110.findPointerIndex(r101);     // Catch: IllegalArgumentException -> L78
        float r103 = r110.getY(r102);     // Catch: IllegalArgumentException -> L78
        float r104 = r103 - this.E;     // Catch: IllegalArgumentException -> L78
        float r105 = Math.abs(r104);     // Catch: IllegalArgumentException -> L78
        float r106 = r110.getX(r102);     // Catch: IllegalArgumentException -> L78
        float r107 = Math.abs(r106 - this.F);     // Catch: IllegalArgumentException -> L78
        if (r104 == 0.0f) goto L43;
        float r108 = this.E;     // Catch: IllegalArgumentException -> L78
        if (r108 >= this.B) goto L33;
        if (r104 <= 0.0f) goto L33;
    L36:
        boolean r109 = true;
    L38:
        if (r109 == true) goto L43;
        if (d(this, false, (int) r104, (int) r106, (int) r103) == false) goto L43;
        this.D = r106;     // Catch: IllegalArgumentException -> L78
        this.E = r103;     // Catch: IllegalArgumentException -> L78
        this.f172475z = true;     // Catch: IllegalArgumentException -> L78
        return false;
    L33:
        if (r108 > (getHeight() - this.B)) goto L35;
    L37:
        r109 = false;
        goto L38
    L35:
        if (r104 >= 0.0f) goto L37;
    L43:
        float r111 = this.C;     // Catch: IllegalArgumentException -> L78
        if (r105 <= r111) goto L56;
        if ((r105 * 1.0f) <= r107) goto L56;
        this.f172474y = true;     // Catch: IllegalArgumentException -> L78
        ViewParent r112 = getParent();     // Catch: IllegalArgumentException -> L78
        if (r112 == null) goto L50;
        r112.requestDisallowInterceptTouchEvent(true);     // Catch: IllegalArgumentException -> L78
    L50:
        setScrollState(1);     // Catch: IllegalArgumentException -> L78
        if (r104 <= 0.0f) goto L53;
        float r113 = this.G + this.C;     // Catch: IllegalArgumentException -> L78
    L54:
        this.E = r113;     // Catch: IllegalArgumentException -> L78
        this.D = r106;     // Catch: IllegalArgumentException -> L78
        setScrollingCacheEnabled(true);     // Catch: IllegalArgumentException -> L78
    L59:
        if (this.f172474y == false) goto L73;
        if (p(r103) == false) goto L73;
        ViewCompat.postInvalidateOnAnimation(this);     // Catch: IllegalArgumentException -> L78
        goto L73
    L53:
        r113 = this.G - this.C;     // Catch: IllegalArgumentException -> L78
    L56:
        if (r107 <= r111) goto L59;
        this.f172475z = true;     // Catch: IllegalArgumentException -> L78
    L73:
        if (this.I != null) goto L75;
        this.I = VelocityTracker.obtain();     // Catch: IllegalArgumentException -> L78
    L75:
        this.I.addMovement(r110);     // Catch: IllegalArgumentException -> L78
    L81:
        return this.f172474y;
    L21:
        if (r100 != 6) goto L73;
        n(r110);     // Catch: IllegalArgumentException -> L78
        goto L73
    L63:
        this.D = r110.getX();     // Catch: IllegalArgumentException -> L78
        this.F = r110.getX();     // Catch: IllegalArgumentException -> L78
        this.E = r110.getY();     // Catch: IllegalArgumentException -> L78
        this.G = r110.getY();     // Catch: IllegalArgumentException -> L78
        this.H = r110.getPointerId(0);     // Catch: IllegalArgumentException -> L78
        this.f172475z = false;     // Catch: IllegalArgumentException -> L78
        this.f172461l = true;     // Catch: IllegalArgumentException -> L78
        this.f172460k.computeScrollOffset();     // Catch: IllegalArgumentException -> L78
        if (this.V == 2) goto L66;
    L71:
        e(false);     // Catch: IllegalArgumentException -> L78
        this.f172474y = false;     // Catch: IllegalArgumentException -> L78
        goto L73
    L66:
        if (Math.abs(this.f172460k.getFinalY() - this.f172460k.getCurrY()) <= this.M) goto L71;
        this.f172460k.abortAnimation();     // Catch: IllegalArgumentException -> L78
        this.f172472w = false;     // Catch: IllegalArgumentException -> L78
        q();     // Catch: IllegalArgumentException -> L78
        this.f172474y = true;     // Catch: IllegalArgumentException -> L78
        ViewParent r114 = getParent();     // Catch: IllegalArgumentException -> L78
        if (r114 == null) goto L70;
        r114.requestDisallowInterceptTouchEvent(true);     // Catch: IllegalArgumentException -> L78
    L70:
        setScrollState(1);     // Catch: IllegalArgumentException -> L78
    L78:
        e = move-exception;
        e.printStackTrace();
        goto L81
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        SavedState r101 = (SavedState) r100;
        super.onRestoreInstanceState(r101.getSuperState());
        PagerAdapter r102 = this.f172455f;
        if (r102 == null) goto L9;
        r102.restoreState(r101.f172482b, r101.f172483c);
        v(r101.f172481a, false, true, 0);
        return;
    L9:
        this.f172457h = r101.f172481a;
        this.f172458i = r101.f172482b;
        this.f172459j = r101.f172483c;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        boolean r101 = false;
        if (this.W == false) goto L77;
        return false;
    L77:
    L74:
        e = move-exception;
        e.printStackTrace();
    L76:
        return true;
    L69:
        e = move-exception;
        if (this.f172455f.getCount() == this.f172451b) goto L73;
        this.f172455f.notifyDataSetChanged();
    L73:
        e.printStackTrace();
        goto L76
    L7:
        if (r100.getAction() == 0) goto L9;
    L11:
        PagerAdapter r102 = this.f172455f;     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        if (r102 != null) goto L14;
    L68:
        return false;
    L14:
        if (r102.getCount() == 0) goto L68;
        if (this.I != null) goto L19;
        this.I = VelocityTracker.obtain();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
    L19:
        this.I.addMovement(r100);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        int r103 = r100.getAction() & 255;     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        if (r103 == 0) goto L64;
        if (r103 == 1) goto L59;
        if (r103 == 2) goto L37;
        if (r103 == 3) goto L34;
        if (r103 != 5) goto L29;
        int r104 = r100.getActionIndex();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        this.E = r100.getY(r104);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        this.H = r100.getPointerId(r104);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
    L65:
        if (r101 == false) goto L76;
        ViewCompat.postInvalidateOnAnimation(this);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
    L29:
        if (r103 != 6) goto L65;
        n(r100);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        this.E = r100.getY(r100.findPointerIndex(this.H));     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        goto L65
    L34:
        if (this.f172474y == false) goto L65;
        u(this.f172456g, true, 0, false);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        r101 = t();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        goto L65
    L37:
        if (this.f172474y == true) goto L56;
        int r105 = r100.findPointerIndex(this.H);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        if (r105 != (-1)) goto L41;
        r101 = t();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        goto L65
    L41:
        float r106 = r100.getY(r105);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        float r107 = Math.abs(r106 - this.E);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        float r108 = r100.getX(r105);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        float r109 = Math.abs(r108 - this.D);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        if (r107 <= this.C) goto L56;
        if (r107 <= r109) goto L56;
        this.f172474y = true;     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        ViewParent r110 = getParent();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        if (r110 == null) goto L48;
        r110.requestDisallowInterceptTouchEvent(true);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
    L48:
        float r111 = this.G;     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        if ((r106 - r111) <= 0.0f) goto L51;
        float r112 = r111 + this.C;     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
    L52:
        this.E = r112;     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        this.D = r108;     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        setScrollState(1);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        setScrollingCacheEnabled(true);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        ViewParent r113 = getParent();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        if (r113 == null) goto L56;
        r113.requestDisallowInterceptTouchEvent(true);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        goto L56
    L51:
        r112 = r111 - this.C;     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
    L56:
        if (this.f172474y == false) goto L65;
        r101 = false | p(r100.getY(r100.findPointerIndex(this.H)));     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        goto L65
    L59:
        if (this.f172474y == false) goto L65;
        VelocityTracker r114 = this.I;     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        r114.computeCurrentVelocity(1000, this.K);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        int r115 = (int) VelocityTrackerCompat.getYVelocity(r114, this.H);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        this.f172472w = true;     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        int r116 = getClientHeight();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        int r117 = getScrollY();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        e r118 = j();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        if (r118 == null) goto L63;
        float r119 = r116;
        v(g(r118.f172488b, ((r117 / r119) - r118.f172491e) / (r118.f172490d + (this.f172463n / r119)), r115, (int) (r100.getY(r100.findPointerIndex(this.H)) - this.G)), true, true, r115);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
    L63:
        r101 = t();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        goto L65
    L64:
        this.f172460k.abortAnimation();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        this.f172472w = false;     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        q();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        this.D = r100.getX();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        this.F = r100.getX();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        this.E = r100.getY();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        this.G = r100.getY();     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        this.H = r100.getPointerId(0);     // Catch: IllegalStateException -> L69 IllegalArgumentException -> L74
        goto L65
    L9:
        if (r100.getEdgeFlags() == 0) goto L11;
        return false;
    }

    public final boolean p(float r110) {
        float r100 = this.E - r110;
        this.E = r110;
        float r111 = getScrollY() + r100;
        float r101 = getClientHeight();
        float r102 = this.f172467r * r101;
        float r103 = this.f172468s * r101;
        boolean r104 = false;
        if (this.f172452c.size() > 0) goto L5;
        return false;
    L5:
        e r105 = (e) ListProtector.get(this.f172452c, 0);
        ArrayList<e> r106 = this.f172452c;
        boolean r107 = true;
        e r108 = (e) ListProtector.get(r106, r106.size() - 1);
        if (r105.f172488b == 0) goto L8;
        r102 = r105.f172491e * r101;
        boolean r109 = false;
    L10:
        if (r108.f172488b == (this.f172455f.getCount() - 1)) goto L13;
        r103 = r108.f172491e * r101;
        r107 = false;
    L13:
        if (r111 >= r102) goto L18;
        if (r109 == false) goto L16;
        r104 = this.N.onPull(Math.abs(r102 - r111) / r101);
    L16:
        r111 = r102;
    L22:
        int r112 = (int) r111;
        this.D += r111 - r112;
        scrollTo(getScrollX(), r112);
        o(r112);
        return r104;
    L18:
        if (r111 <= r103) goto L22;
        if (r107 == false) goto L21;
        r104 = this.O.onPull(Math.abs(r111 - r103) / r101);
    L21:
        r111 = r103;
        goto L22
    L8:
        r109 = true;
        goto L10
    }

    public final void r(int r110) {
        int r100 = this.f172456g;
        if (r100 == r110) goto L8;
        if (r100 >= r110) goto L6;
        int r101 = 130;
    L7:
        e r102 = k(r100);
        this.f172456g = r110;
    L10:
        if (this.f172455f != null) goto L13;
        return;
    L13:
        if (this.f172472w == false) goto L16;
        return;
    L16:
        if (getWindowToken() != null) goto L18;
        return;
    L18:
        this.f172455f.startUpdate(this);
        int r111 = this.f172473x;
        int r103 = Math.max(0, this.f172456g - r111);
        int r104 = this.f172455f.getCount();
        int r112 = Math.min(r104 - 1, this.f172456g + r111);
        if (r104 != this.f172451b) goto L211;
        int r105 = 0;
    L22:
        if (r105 >= this.f172452c.size()) goto L28;
        e r106 = (e) ListProtector.get(this.f172452c, r105);
        int r107 = r106.f172488b;
        int r108 = this.f172456g;
        if (r107 >= r108) goto L25;
        r105 = r105 + 1;
        goto L22
    L25:
        if (r107 != r108) goto L28;
    L29:
        if (r106 != null) goto L32;
        if (r104 <= 0) goto L32;
        r106 = b(this.f172456g, r105);
    L32:
        if (r106 == null) goto L164;
        int r109 = r105 - 1;
        if (r109 < 0) goto L36;
        e r113 = (e) ListProtector.get(this.f172452c, r109);
    L37:
        int r114 = getClientHeight();
        if (r114 > 0) goto L40;
        float r115 = 0.0f;
    L41:
        int r116 = this.f172456g - 1;
        float r117 = 0.0f;
    L42:
        if (r116 < 0) goto L66;
        if (r117 < r115) goto L55;
        if (r116 >= r103) goto L55;
        if (r113 == null) goto L66;
        if (r116 != r113.f172488b) goto L65;
        if (r113.f172489c == true) goto L65;
        ListProtector.remove(this.f172452c, r109);
        this.f172455f.destroyItem(this, r116, r113.f172487a);
        r109 = r109 - 1;
        r105 = r105 - 1;
        if (r109 < 0) goto L64;
        r113 = (e) ListProtector.get(this.f172452c, r109);
    L64:
        r113 = null;
    L65:
        r116 = r116 - 1;
    L55:
        if (r113 != null) goto L57;
    L61:
        r117 = r117 + b(r116, r109 + 1).f172490d;
        r105 = r105 + 1;
        if (r109 < 0) goto L64;
        r113 = (e) ListProtector.get(this.f172452c, r109);
        goto L65
    L57:
        if (r116 != r113.f172488b) goto L61;
        r117 = r117 + r113.f172490d;
        r109 = r109 - 1;
        if (r109 < 0) goto L64;
        r113 = (e) ListProtector.get(this.f172452c, r109);
    L66:
        float r118 = r106.f172490d;
        int r119 = r105 + 1;
        if (r118 < 2.0f) goto L69;
    L100:
        int r120 = this.f172455f.getCount();
        int r121 = getClientHeight();
        if (r121 <= 0) goto L103;
        float r122 = this.f172463n / r121;
    L104:
        if (r102 == null) goto L136;
        int r123 = r102.f172488b;
        int r124 = r106.f172488b;
        if (r123 >= r124) goto L122;
        float r125 = (r102.f172491e + r102.f172490d) + r122;
        int r126 = r123 + 1;
        int r127 = 0;
    L109:
        if (r126 > r106.f172488b) goto L136;
        if (r127 >= this.f172452c.size()) goto L136;
        Object r128 = ListProtector.get(this.f172452c, r127);
    L113:
        e r129 = (e) r128;
        if (r126 <= r129.f172488b) goto L119;
        if (r127 >= (this.f172452c.size() - 1)) goto L119;
        r127 = r127 + 1;
        r128 = ListProtector.get(this.f172452c, r127);
    L119:
        if (r126 >= r129.f172488b) goto L121;
        r125 = r125 + (this.f172455f.getPageWidth(r126) + r122);
        r126 = r126 + 1;
        goto L119
    L121:
        r129.f172491e = r125;
        r125 = r125 + (r129.f172490d + r122);
        r126 = r126 + 1;
        goto L109
    L122:
        if (r123 <= r124) goto L136;
        int r130 = this.f172452c.size() - 1;
        float r131 = r102.f172491e;
    L124:
        r123 = r123 - 1;
        if (r123 < r106.f172488b) goto L136;
        if (r130 < 0) goto L136;
        Object r132 = ListProtector.get(this.f172452c, r130);
    L128:
        e r133 = (e) r132;
        if (r123 >= r133.f172488b) goto L133;
        if (r130 <= 0) goto L133;
        r130 = r130 - 1;
        r132 = ListProtector.get(this.f172452c, r130);
    L133:
        if (r123 <= r133.f172488b) goto L135;
        r131 = r131 - (this.f172455f.getPageWidth(r123) + r122);
        r123 = r123 - 1;
        goto L133
    L135:
        r131 = r131 - (r133.f172490d + r122);
        r133.f172491e = r131;
    L136:
        int r134 = this.f172452c.size();
        float r135 = r106.f172491e;
        int r136 = r106.f172488b;
        int r137 = r136 - 1;
        if (r136 != 0) goto L139;
        float r138 = r135;
    L140:
        this.f172467r = r138;
        int r139 = r120 - 1;
        if (r136 != r139) goto L143;
        float r140 = (r106.f172490d + r135) - 1.0f;
    L144:
        this.f172468s = r140;
        int r141 = r105 - 1;
    L145:
        if (r141 < 0) goto L154;
        e r142 = (e) ListProtector.get(this.f172452c, r141);
    L147:
        int r143 = r142.f172488b;
        if (r137 <= r143) goto L150;
        r135 = r135 - (this.f172455f.getPageWidth(r137) + r122);
        r137 = r137 - 1;
        goto L147
    L150:
        r135 = r135 - (r142.f172490d + r122);
        r142.f172491e = r135;
        if (r143 != 0) goto L153;
        this.f172467r = r135;
    L153:
        r141 = r141 - 1;
        r137 = r137 - 1;
        goto L145
    L154:
        float r144 = (r106.f172491e + r106.f172490d) + r122;
        int r145 = r106.f172488b;
    L155:
        r145 = r145 + 1;
        if (r119 >= r134) goto L164;
        e r146 = (e) ListProtector.get(this.f172452c, r119);
    L158:
        int r147 = r146.f172488b;
        if (r145 >= r147) goto L161;
        r144 = r144 + (this.f172455f.getPageWidth(r145) + r122);
        r145 = r145 + 1;
        goto L158
    L161:
        if (r147 != r139) goto L163;
        this.f172468s = (r146.f172490d + r144) - 1.0f;
    L163:
        r146.f172491e = r144;
        r144 = r144 + (r146.f172490d + r122);
        r119 = r119 + 1;
        goto L155
    L143:
        r140 = Float.MAX_VALUE;
        goto L144
    L139:
        r138 = -3.4028235E38f;
        goto L140
    L103:
        r122 = 0.0f;
        goto L104
    L69:
        if (r119 >= this.f172452c.size()) goto L71;
        e r148 = (e) ListProtector.get(this.f172452c, r119);
    L72:
        if (r114 > 0) goto L74;
        float r149 = 0.0f;
    L75:
        int r150 = this.f172456g + 1;
        int r151 = r119;
    L76:
        if (r150 >= r104) goto L100;
        if (r118 < r149) goto L89;
        if (r150 <= r112) goto L89;
        if (r148 == null) goto L100;
        if (r150 != r148.f172488b) goto L99;
        if (r148.f172489c == true) goto L99;
        ListProtector.remove(this.f172452c, r151);
        this.f172455f.destroyItem(this, r150, r148.f172487a);
        if (r151 >= this.f172452c.size()) goto L98;
        r148 = (e) ListProtector.get(this.f172452c, r151);
    L98:
        r148 = null;
    L99:
        r150 = r150 + 1;
    L89:
        if (r148 != null) goto L91;
    L95:
        e r152 = b(r150, r151);
        r151 = r151 + 1;
        r118 = r118 + r152.f172490d;
        if (r151 >= this.f172452c.size()) goto L98;
        r148 = (e) ListProtector.get(this.f172452c, r151);
        goto L99
    L91:
        if (r150 != r148.f172488b) goto L95;
        r118 = r118 + r148.f172490d;
        r151 = r151 + 1;
        if (r151 >= this.f172452c.size()) goto L98;
        r148 = (e) ListProtector.get(this.f172452c, r151);
        goto L99
    L74:
        r149 = (getPaddingRight() / r114) + 2.0f;
        goto L75
    L71:
        r148 = null;
        goto L72
    L40:
        r115 = (2.0f - r106.f172490d) + (getPaddingLeft() / r114);
        goto L41
    L36:
        r113 = null;
    L164:
        PagerAdapter r153 = this.f172455f;
        int r154 = this.f172456g;
        if (r106 == null) goto L167;
        Object r155 = r106.f172487a;
    L168:
        r153.setPrimaryItem(this, r154, r155);
        this.f172455f.finishUpdate(this);
        int r156 = getChildCount();
        int r157 = 0;
    L169:
        if (r157 >= r156) goto L179;
        View r158 = getChildAt(r157);
        LayoutParams r159 = (LayoutParams) r158.getLayoutParams();
        r159.f172480e = r157;
        if (r159.f172476a == true) goto L177;
        if (r159.f172478c != 0.0f) goto L177;
        e r160 = i(r158);
        if (r160 == null) goto L177;
        r159.f172478c = r160.f172490d;
        int r161 = r160.f172488b;
        r159.getClass();
    L177:
        r157 = r157 + 1;
        goto L169
    L179:
        if (hasFocus() == false) goto L205;
        View r162 = findFocus();
        if (r162 == null) goto L190;
    L182:
        Object r163 = r162.getParent();
        if (r163 == this) goto L189;
        if (r163 == null) goto L190;
        if ((r163 instanceof View) == false) goto L190;
        r162 = (View) r163;
        goto L182
    L189:
        e r164 = i(r162);
    L191:
        if (r164 != null) goto L193;
    L194:
        int r165 = 0;
    L196:
        if (r165 >= getChildCount()) goto L265;
        View r166 = getChildAt(r165);
        e r167 = i(r166);
        if (r167 == null) goto L204;
        if (r167.f172488b != this.f172456g) goto L204;
        if (r166.requestFocus(r101) == false) goto L204;
        return;
    L204:
        r165 = r165 + 1;
        goto L196
    L265:
        return;
    L193:
        if (r164.f172488b != this.f172456g) goto L194;
        return;
    L190:
        r164 = null;
        goto L191
    L205:
        return;
    L167:
        r155 = null;
    L28:
        r106 = null;
        goto L29
    L211:
        String r168 = getResources().getResourceName(getId());     // Catch: Resources.NotFoundException -> L208
    L210:
        throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f172451b + ", found: " + r104 + " Pager id: " + r168 + " Pager class: " + getClass() + " Problematic adapter: " + this.f172455f.getClass());
    L208:
        r168 = Integer.toHexString(getId());
        goto L210
    L6:
        r101 = 33;
        goto L7
    L8:
        r101 = 2;
        r102 = null;
        goto L10
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View r100) {
        if (this.f172470u == false) goto L5;
        removeViewInLayout(r100);
        return;
    L5:
        super.removeView(r100);
    }

    public void setAdapter(PagerAdapter r100) {
        PagerAdapter r101 = this.f172455f;
        if (r101 != null) goto L43;
    L22:
        this.f172455f = r100;
        this.f172451b = 0;
        if (r100 != null) goto L25;
        return;
    L25:
        if (this.f172462m != null) goto L27;
        this.f172462m = new h(this);
    L27:
        PagerAdapter r102 = this.f172455f;
        h r103 = this.f172462m;
        Field r104 = L0;     // Catch: IllegalAccessException -> L37
        if (r104 == null) goto L31;
        r104.set(r102, r103);     // Catch: IllegalAccessException -> L37
    L31:
        this.f172472w = false;
        boolean r105 = this.P;
        this.P = true;
        this.f172451b = this.f172455f.getCount();
        if (this.f172457h < 0) goto L34;
        this.f172455f.restoreState(this.f172458i, this.f172459j);
        v(this.f172457h, false, true, 0);
        this.f172457h = -1;
        this.f172458i = null;
        this.f172459j = null;
        return;
    L34:
        if (r105 == true) goto L36;
        q();
        return;
    L36:
        requestLayout();
        return;
    L37:
        e = move-exception;
        throw new RuntimeException(e);
    L43:
        Field r106 = L0;     // Catch: IllegalAccessException -> L19
        if (r106 == null) goto L7;
        r106.set(r101, null);     // Catch: IllegalAccessException -> L19
    L7:
        this.f172455f.startUpdate(this);
        int r107 = 0;
    L9:
        if (r107 >= this.f172452c.size()) goto L11;
        e r108 = (e) ListProtector.get(this.f172452c, r107);
        this.f172455f.destroyItem(this, r108.f172488b, r108.f172487a);
        r107 = r107 + 1;
        goto L9
    L11:
        this.f172455f.finishUpdate(this);
        this.f172452c.clear();
        int r109 = 0;
    L13:
        if (r109 >= getChildCount()) goto L18;
        if (((LayoutParams) getChildAt(r109).getLayoutParams()).f172476a == true) goto L17;
        removeViewAt(r109);
        r109 = r109 - 1;
    L17:
        r109 = r109 + 1;
        goto L13
    L18:
        this.f172456g = 0;
        scrollTo(0, 0);
    L19:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void setCanTouch(boolean r100) {
        this.f172450a = r100;
    }

    public void setChildrenDrawingOrderEnabledCompat(boolean r100) {
        if (this.T == null) goto L13;
    L11:
        Method r101 = this.T;     // Catch: Exception -> L10
        if (r101 == null) goto L15;
        r101.invoke(this, new Object[]{Boolean.valueOf(r100)});     // Catch: Exception -> L10
        return;
    L15:
        return;
    L16:
        return;
    L13:
        this.T = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L9
        goto L11
    }

    public void setCurrentItem(int r100) {
        this.f172472w = false;
        v(r100, !this.P, false, 0);
    }

    public void setCurrentItemWithDefaultVelocity(int r100) {
        this.f172472w = false;
        v(r100, true, true, 1);
    }

    public void setDefaultItem(int r100) {
        this.f172456g = r100;
    }

    public void setDisableScroll(boolean r100) {
        this.W = r100;
    }

    public void setOffscreenPageLimit(int r100) {
        if (r100 >= 1) goto L6;
        r100 = 1;
    L6:
        if (r100 == this.f172473x) goto L9;
        this.f172473x = r100;
        q();
        return;
    }

    public void setPageMargin(int r100) {
        int r101 = this.f172463n;
        this.f172463n = r100;
        int r102 = getHeight();
        s(r102, r102, r100, r101);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable r100) {
        this.f172464o = r100;
        if (r100 == null) goto L5;
        refreshDrawableState();
    L5:
        if (r100 != null) goto L7;
        boolean r101 = true;
    L8:
        setWillNotDraw(r101);
        invalidate();
        return;
    L7:
        r101 = false;
        goto L8
    }

    public void setScroller(Scroller r100) {
        this.f172460k = r100;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable r100) {
        if (super.verifyDrawable(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (r100 == this.f172464o) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        return generateDefaultLayoutParams();
    }

    public void setPageMarginDrawable(int r100) {
        setPageMarginDrawable(getContext().getResources().getDrawable(r100));
    }

    public VerticalViewPager(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f172452c = new ArrayList();
        this.f172453d = new e();
        this.f172454e = new Rect();
        this.f172457h = -1;
        this.f172458i = null;
        this.f172459j = null;
        this.f172467r = -3.4028235E38f;
        this.f172468s = Float.MAX_VALUE;
        this.f172473x = 1;
        this.H = -1;
        this.P = true;
        this.S = new ArrayList();
        this.U = new c(this);
        this.V = 0;
        this.W = false;
        l();
    }

    public final e b(int r100, int r101) {
        e r102 = new e();
        r102.f172488b = r100;
        r102.f172487a = this.f172455f.instantiateItem(this, r100);
        r102.f172490d = this.f172455f.getPageWidth(r100);
        if (r101 >= 0) goto L5;
    L8:
        this.f172452c.add(r102);
    L9:
        return r102;
    L5:
        if (r101 >= this.f172452c.size()) goto L8;
        ListProtector.add(this.f172452c, r101, r102);
        goto L9
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int r100, int r101) {
        return ((LayoutParams) ((View) ListProtector.get(null, r101)).getLayoutParams()).f172480e;
    }

    public final Rect h(Rect r100, View r101) {
        if (r100 != null) goto L4;
        r100 = new Rect();
    L4:
        if (r101 != null) goto L7;
        r100.set(0, 0, 0, 0);
        return r100;
    L7:
        r100.left = r101.getLeft();
        r100.right = r101.getRight();
        r100.top = r101.getTop();
        r100.bottom = r101.getBottom();
        ViewParent r102 = r101.getParent();
    L9:
        if ((r102 instanceof ViewGroup) == false) goto L12;
        if (r102 == this) goto L12;
        ViewGroup r103 = (ViewGroup) r102;
        r100.left += r103.getLeft();
        r100.right += r103.getRight();
        r100.top += r103.getTop();
        r100.bottom += r103.getBottom();
        r102 = r103.getParent();
    L12:
        return r100;
    }

    @Override // android.view.View
    public final void onMeasure(int r110, int r111) {
        int r100 = 0;
        setMeasuredDimension(ViewGroup.getDefaultSize(0, r110), ViewGroup.getDefaultSize(0, r111));
        int r112 = getMeasuredHeight();
        this.B = Math.min(r112 / 10, this.A);
        int r113 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int r114 = (r112 - getPaddingTop()) - getPaddingBottom();
        int r101 = getChildCount();
        int r102 = 0;
    L3:
        boolean r103 = true;
        int r104 = 1073741824;
        if (r102 >= r101) goto L49;
        View r105 = getChildAt(r102);
        if (r105.getVisibility() == 8) goto L48;
        LayoutParams r106 = (LayoutParams) r105.getLayoutParams();
        if (r106 == null) goto L48;
        if (r106.f172476a == false) goto L48;
        int r107 = r106.f172477b;
        int r108 = r107 & 7;
        int r109 = r107 & 112;
        if (r109 != 48) goto L14;
    L17:
        boolean r115 = true;
    L19:
        if (r108 != 8388611) goto L21;
    L24:
        int r116 = Integer.MIN_VALUE;
        if (r115 == false) goto L27;
        r116 = 1073741824;
    L29:
        int r117 = Integer.MIN_VALUE;
    L30:
        int r118 = ((ViewGroup.LayoutParams) r106).width;
        if (r118 == (-2)) goto L36;
        if (r118 != (-1)) goto L35;
        r118 = r113;
    L35:
        r116 = 1073741824;
    L37:
        int r119 = ((ViewGroup.LayoutParams) r106).height;
        if (r119 == (-2)) goto L42;
        if (r119 != (-1)) goto L43;
        r119 = r114;
    L43:
        r105.measure(View.MeasureSpec.makeMeasureSpec(r118, r116), View.MeasureSpec.makeMeasureSpec(r119, r104));
        if (r115 == false) goto L46;
        r114 = r114 - r105.getMeasuredHeight();
        goto L48
    L46:
        if (r103 == false) goto L48;
        r113 = r113 - r105.getMeasuredWidth();
        goto L48
    L42:
        r119 = r114;
        r104 = r117;
        goto L43
    L36:
        r118 = r113;
        goto L37
    L27:
        if (r103 == false) goto L29;
        r117 = 1073741824;
        goto L30
    L21:
        if (r108 == 8388613) goto L24;
        r103 = false;
        goto L24
    L14:
        if (r109 == 80) goto L17;
        r115 = false;
    L48:
        r102 = r102 + 1;
        goto L3
    L49:
        this.f172469t = View.MeasureSpec.makeMeasureSpec(r113, 1073741824);
        View.MeasureSpec.makeMeasureSpec(r114, 1073741824);
        this.f172470u = true;
        q();
        this.f172470u = false;
        int r120 = getChildCount();
    L50:
        if (r100 >= r120) goto L59;
        View r121 = getChildAt(r100);
        if (r121.getVisibility() == 8) goto L58;
        LayoutParams r122 = (LayoutParams) r121.getLayoutParams();
        if (r122 != null) goto L56;
    L57:
        r121.measure(this.f172469t, View.MeasureSpec.makeMeasureSpec((int) (r114 * r122.f172478c), 1073741824));
        goto L58
    L56:
        if (r122.f172476a == false) goto L57;
    L58:
        r100 = r100 + 1;
        goto L50
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int r100, Rect r110) {
        int r101 = getChildCount();
        if ((r100 & 2) == 0) goto L5;
        int r102 = r101;
        int r103 = 0;
        int r104 = 1;
    L6:
        if (r103 == r102) goto L17;
        View r105 = getChildAt(r103);
        if (r105.getVisibility() != 0) goto L16;
        e r106 = i(r105);
        if (r106 == null) goto L16;
        if (r106.f172488b != this.f172456g) goto L16;
        if (r105.requestFocus(r100, r110) == false) goto L16;
        return true;
    L16:
        r103 = r103 + r104;
        goto L6
    L17:
        return false;
    L5:
        r103 = r101 - 1;
        r102 = -1;
        r104 = -1;
        goto L6
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList<View> r100, int r101, int r102) {
        int r103 = r100.size();
        int r104 = getDescendantFocusability();
        if (r104 == 393216) goto L16;
        int r105 = 0;
    L6:
        if (r105 >= getChildCount()) goto L16;
        View r106 = getChildAt(r105);
        if (r106.getVisibility() != 0) goto L14;
        e r107 = i(r106);
        if (r107 == null) goto L14;
        if (r107.f172488b != this.f172456g) goto L14;
        r106.addFocusables(r100, r101, r102);
    L14:
        r105 = r105 + 1;
    L16:
        if (r104 != 262144) goto L20;
        if (r103 == r100.size()) goto L20;
        return;
    L20:
        if (isFocusable() == true) goto L23;
        return;
    L23:
        if ((r102 & 1) == 1) goto L25;
    L29:
        r100.add(this);
        return;
    L25:
        if (isInTouchMode() == false) goto L29;
        if (isFocusableInTouchMode() == true) goto L29;
    }

    @Override // android.view.ViewGroup
    public final void addView(View r100, int r101, ViewGroup.LayoutParams r102) {
        if (checkLayoutParams(r102) == true) goto L5;
        r102 = generateLayoutParams(r102);
    L5:
        LayoutParams r103 = (LayoutParams) r102;
        boolean r104 = r103.f172476a | false;
        r103.f172476a = r104;
        if (this.f172470u == false) goto L11;
        if (r104 == true) goto L10;
        r103.f172479d = true;
        addViewInLayout(r100, r101, r102);
        return;
    L10:
        throw new IllegalStateException("Cannot add pager decor view during layout");
    L11:
        super.addView(r100, r101, r102);
    }

    public void m(int r110, float r111, int r112) {
        if (this.R <= 0) goto L25;
        int r100 = getScrollY();
        int r101 = getPaddingTop();
        int r102 = getPaddingBottom();
        int r103 = getHeight();
        int r104 = getChildCount();
        int r105 = 0;
    L5:
        if (r105 >= r104) goto L25;
        View r106 = getChildAt(r105);
        LayoutParams r107 = (LayoutParams) r106.getLayoutParams();
        if (r107.f172476a == false) goto L24;
        int r108 = r107.f172477b & 112;
        if (r108 != 16) goto L12;
        int r109 = Math.max((r103 - r106.getMeasuredHeight()) / 2, r101);
    L19:
        int r113 = r109;
        int r114 = r101;
        r101 = r113;
    L20:
        int r115 = (r101 + r100) - r106.getTop();
        if (r115 == 0) goto L23;
        r106.offsetTopAndBottom(r115);
    L23:
        r101 = r114;
        goto L24
    L12:
        if (r108 != 48) goto L14;
        r114 = r106.getHeight() + r101;
        goto L20
    L14:
        if (r108 == 80) goto L16;
        r114 = r101;
        goto L20
    L16:
        r109 = (r103 - r102) - r106.getMeasuredHeight();
        r102 = r102 + r106.getMeasuredHeight();
    L24:
        r105 = r105 + 1;
    L25:
        List<ViewPager.OnPageChangeListener> r116 = this.S;
        if (r116 != null) goto L28;
    L33:
        this.Q = true;
        return;
    L28:
        if (((ArrayList) r116).isEmpty() == true) goto L33;
        Iterator r117 = ((ArrayList) this.S).iterator();
    L31:
        if (r117.hasNext() == false) goto L33;
        ((ViewPager.OnPageChangeListener) r117.next()).onPageScrolled(r110, r111, r112);
        goto L31
    }

    public final int g(int r100, float r101, int r102, int r103) {
        if (Math.abs(r103) <= this.L) goto L10;
        if (Math.abs(r102) <= this.f172449J) goto L10;
        if (r102 > 0) goto L15;
        r100 = r100 + 1;
    L15:
        if (this.f172452c.size() <= 0) goto L18;
        e r104 = (e) ListProtector.get(this.f172452c, 0);
        ArrayList<e> r105 = this.f172452c;
        return Math.max(r104.f172488b, Math.min(r100, ((e) ListProtector.get(r105, r105.size() - 1)).f172488b));
    L18:
        return r100;
    L10:
        if (r100 < this.f172456g) goto L12;
        float r106 = 0.6f;
    L13:
        r100 = (int) ((r100 + r101) + r106);
        goto L15
    L12:
        r106 = 0.4f;
        goto L13
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r101 == r103) goto L6;
        int r104 = this.f172463n;
        s(r101, r103, r104, r104);
        return;
    }

    public final void s(int r100, int r101, int r102, int r103) {
        if (r101 > 0) goto L4;
    L9:
        e r104 = k(this.f172456g);
        if (r104 == null) goto L12;
        float r105 = Math.min(r104.f172491e, this.f172468s);
    L13:
        int r106 = (int) (r105 * ((r100 - getPaddingTop()) - getPaddingBottom()));
        if (r106 == getScrollY()) goto L19;
        e(false);
        scrollTo(getScrollX(), r106);
        return;
    L19:
        return;
    L12:
        r105 = 0.0f;
        goto L13
    L4:
        if (this.f172452c.isEmpty() == true) goto L9;
        if (this.f172460k.isFinished() == true) goto L8;
        this.f172460k.setFinalY(getCurrentItem() * getClientHeight());
        return;
    L8:
        scrollTo(getScrollX(), (int) ((getScrollY() / (((r101 - getPaddingTop()) - getPaddingBottom()) + r103)) * (((r100 - getPaddingTop()) - getPaddingBottom()) + r102)));
    }

    public final void u(int r110, boolean r111, int r112, boolean r113) {
        e r100 = k(r110);
        if (r100 == null) goto L5;
        int r101 = (int) (getClientHeight() * Math.max(this.f172467r, Math.min(r100.f172491e, this.f172468s)));
    L6:
        if (r111 == true) goto L8;
        if (r113 == false) goto L50;
        List<ViewPager.OnPageChangeListener> r102 = this.S;
        if (r102 == null) goto L50;
        if (((ArrayList) r102).isEmpty() == true) goto L50;
        Iterator r103 = ((ArrayList) this.S).iterator();
    L48:
        if (r103.hasNext() == false) goto L50;
        ((ViewPager.OnPageChangeListener) r103.next()).onPageSelected(r110);
    L50:
        e(false);
        scrollTo(0, r101);
        o(r101);
        return;
    L8:
        if (getChildCount() != 0) goto L10;
        setScrollingCacheEnabled(false);
    L32:
        if (r113 == false) goto L54;
        List<ViewPager.OnPageChangeListener> r104 = this.S;
        if (r104 != null) goto L36;
        return;
    L36:
        if (((ArrayList) r104).isEmpty() == true) goto L56;
        Iterator r105 = ((ArrayList) this.S).iterator();
    L39:
        if (r105.hasNext() == false) goto L57;
        ((ViewPager.OnPageChangeListener) r105.next()).onPageSelected(r110);
        goto L39
    L57:
        return;
    L56:
        return;
    L54:
        return;
    L10:
        Scroller r106 = this.f172460k;
        if (r106 != null) goto L13;
    L15:
        boolean r107 = false;
    L16:
        if (r107 == true) goto L18;
        int r108 = getScrollY();
    L23:
        int r109 = r108;
        int r114 = getScrollX();
        int r115 = 0 - r114;
        int r116 = r101 - r109;
        if (r115 != 0) goto L27;
        if (r116 != 0) goto L27;
        e(false);
        q();
        setScrollState(0);
    L27:
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int r117 = getClientHeight();
        int r118 = r117 / 2;
        float r119 = r117;
        float r120 = r118;
        float r121 = r120 + (((float) Math.sin((float) (((double) (Math.min(1.0f, (Math.abs(r115) * 1.0f) / r119) - 0.5f)) * 0.4712389167638204d))) * r120);
        int r122 = Math.abs(r112);
        if (r122 <= 0) goto L30;
        int r123 = Math.round(Math.abs(r121 / r122) * 1000.0f) * 4;
    L31:
        int r124 = Math.min(r123, 600);
        this.f172461l = false;
        this.f172460k.startScroll(r114, r109, r115, r116, r124);
        ViewCompat.postInvalidateOnAnimation(this);
        goto L32
    L30:
        r123 = (int) (((Math.abs(r115) / ((r119 * this.f172455f.getPageWidth(this.f172456g)) + this.f172463n)) + 1.0f) * 100.0f);
        goto L31
    L18:
        if (this.f172461l == false) goto L20;
        r108 = this.f172460k.getCurrY();
    L21:
        this.f172460k.abortAnimation();
        setScrollingCacheEnabled(false);
        goto L23
    L20:
        r108 = this.f172460k.getStartY();
        goto L21
    L13:
        if (r106.isFinished() == true) goto L15;
        r107 = true;
        goto L16
    L5:
        r101 = 0;
        goto L6
    }

    public final void v(int r100, boolean r101, boolean r102, int r103) {
        PagerAdapter r104 = this.f172455f;
        boolean r105 = false;
        if (r104 != null) goto L5;
    L46:
        setScrollingCacheEnabled(false);
        return;
    L5:
        if (r104.getCount() <= 0) goto L46;
        if (r102 == true) goto L15;
        if (this.f172456g != r100) goto L15;
        if (this.f172452c.size() == 0) goto L15;
        setScrollingCacheEnabled(false);
        return;
    L15:
        if (r100 >= 0) goto L18;
        r100 = 0;
    L20:
        int r106 = this.f172473x;
        int r107 = this.f172456g;
        if (r100 <= (r107 + r106)) goto L23;
    L24:
        int r108 = 0;
    L26:
        if (r108 >= this.f172452c.size()) goto L29;
        ((e) ListProtector.get(this.f172452c, r108)).f172489c = true;
        r108 = r108 + 1;
    L29:
        if (this.f172456g == r100) goto L32;
        r105 = true;
    L32:
        if (this.P == false) goto L44;
        this.f172456g = r100;
        if (r105 == false) goto L43;
        List<ViewPager.OnPageChangeListener> r109 = this.S;
        if (r109 == null) goto L43;
        if (((ArrayList) r109).isEmpty() == true) goto L43;
        Iterator r110 = ((ArrayList) this.S).iterator();
    L41:
        if (r110.hasNext() == false) goto L43;
        ((ViewPager.OnPageChangeListener) r110.next()).onPageSelected(r100);
    L43:
        requestLayout();
        return;
    L44:
        r(r100);
        u(r100, r101, r103, r105);
        return;
    L23:
        if (r100 >= (r107 - r106)) goto L29;
    L18:
        if (r100 < this.f172455f.getCount()) goto L20;
        r100 = this.f172455f.getCount() - 1;
        goto L20
    }

    public static boolean d(View r100, boolean r110, int r111, int r112, int r113) {
        if ((r100 instanceof ViewGroup) == false) goto L18;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r100.getScrollX();
        int r103 = r100.getScrollY();
        int r104 = r101.getChildCount() - 1;
    L5:
        if (r104 < 0) goto L18;
        View r105 = r101.getChildAt(r104);
        int r106 = r113 + r103;
        if (r106 < r105.getTop()) goto L17;
        if (r106 >= r105.getBottom()) goto L17;
        int r107 = r112 + r102;
        if (r107 < r105.getLeft()) goto L17;
        if (r107 >= r105.getRight()) goto L17;
        if (d(r105, true, r111, r107 - r105.getLeft(), r106 - r105.getTop()) == false) goto L17;
        return true;
    L17:
        r104 = r104 - 1;
    L18:
        if (r110 == true) goto L20;
    L22:
        return false;
    L20:
        if (ViewCompat.canScrollVertically(r100, -r111) == false) goto L22;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r110, int r210, int r211, int r212, int r213) {
        int r100 = getChildCount();
        int r101 = r212 - r210;
        int r102 = r213 - r211;
        int r103 = getPaddingLeft();
        int r104 = getPaddingTop();
        int r105 = getPaddingRight();
        int r106 = getPaddingBottom();
        int r107 = getScrollY();
        int r111 = 0;
        int r112 = 0;
    L4:
        if (r111 >= r100) goto L33;
        View r113 = getChildAt(r111);
        if (r113.getVisibility() == 8) goto L32;
        LayoutParams r114 = (LayoutParams) r113.getLayoutParams();
        if (r114.f172476a == false) goto L32;
        int r115 = r114.f172477b;
        int r116 = r115 & 7;
        int r117 = r115 & 112;
        if (r116 != 1) goto L12;
        int r118 = Math.max((r101 - r113.getMeasuredWidth()) / 2, r103);
    L19:
        int r119 = r118;
        int r120 = r103;
        r103 = r119;
    L21:
        if (r117 != 16) goto L23;
        int r121 = Math.max((r102 - r113.getMeasuredHeight()) / 2, r104);
    L30:
        int r122 = r121;
        int r123 = r104;
        r104 = r122;
    L31:
        int r108 = r104 + r107;
        r113.layout(r103, r108, r113.getMeasuredWidth() + r103, r108 + r113.getMeasuredHeight());
        r112 = r112 + 1;
        r104 = r123;
        r103 = r120;
        goto L32
    L23:
        if (r117 != 48) goto L25;
        r123 = r113.getMeasuredHeight() + r104;
        goto L31
    L25:
        if (r117 == 80) goto L27;
        r123 = r104;
        goto L31
    L27:
        r121 = (r102 - r106) - r113.getMeasuredHeight();
        r106 = r106 + r113.getMeasuredHeight();
        goto L30
    L12:
        if (r116 != 8388611) goto L14;
        r120 = r113.getMeasuredWidth() + r103;
        goto L21
    L14:
        if (r116 == 8388613) goto L16;
        r120 = r103;
        goto L21
    L16:
        r118 = (r101 - r105) - r113.getMeasuredWidth();
        r105 = r105 + r113.getMeasuredWidth();
    L32:
        r111 = r111 + 1;
        goto L4
    L33:
        int r109 = (r102 - r104) - r106;
        int r124 = 0;
    L34:
        if (r124 >= r100) goto L45;
        View r125 = getChildAt(r124);
        if (r125.getVisibility() == 8) goto L44;
        LayoutParams r126 = (LayoutParams) r125.getLayoutParams();
        e r127 = i(r125);
        if (r126.f172476a == true) goto L44;
        if (r127 == null) goto L44;
        float r128 = r109;
        int r129 = ((int) (r127.f172491e * r128)) + r104;
        if (r126.f172479d == false) goto L43;
        r126.f172479d = false;
        r125.measure(View.MeasureSpec.makeMeasureSpec((r101 - r103) - r105, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (r128 * r126.f172478c), 1073741824));
    L43:
        r125.layout(r103, r129, r125.getMeasuredWidth() + r103, r125.getMeasuredHeight() + r129);
    L44:
        r124 = r124 + 1;
        goto L34
    L45:
        this.f172465p = r103;
        this.f172466q = r101 - r105;
        this.R = r112;
        if (this.P == false) goto L48;
        boolean r130 = false;
        u(this.f172456g, false, 0, false);
    L49:
        this.P = r130;
        return;
    L48:
        r130 = false;
        goto L49
    }
}
