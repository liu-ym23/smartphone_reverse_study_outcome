package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
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
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.R$attr;
import androidx.coordinatorlayout.R$style;
import androidx.coordinatorlayout.R$styleable;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SynchronizedPool;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.i;
import androidx.customview.view.AbsSavedState;
import com.bytedance.librarian.LibrarianImpl;
import com.google.android.material.badge.BadgeDrawable;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2, NestedScrollingParent3 {
    static final Class<?>[] CONSTRUCTOR_PARAMS = null;
    static final int EVENT_NESTED_SCROLL = 1;
    static final int EVENT_PRE_DRAW = 0;
    static final int EVENT_VIEW_REMOVED = 2;
    static final String TAG = "CoordinatorLayout";
    static final Comparator<View> TOP_SORTED_CHILDREN_COMPARATOR = null;
    private static final int TYPE_ON_INTERCEPT = 0;
    private static final int TYPE_ON_TOUCH = 1;
    static final String WIDGET_PACKAGE_NAME = null;
    static final ThreadLocal<Map<String, Constructor<Behavior>>> sConstructors = null;
    private static final Pools$Pool<Rect> sRectPool = null;
    private OnApplyWindowInsetsListener mApplyWindowInsetsListener;
    private final int[] mBehaviorConsumed;
    private View mBehaviorTouchView;
    private final androidx.coordinatorlayout.widget.a mChildDag;
    private final List<View> mDependencySortedChildren;
    private boolean mDisallowInterceptReset;
    private boolean mDrawStatusBarBackground;
    private boolean mIsAttachedToWindow;
    private int[] mKeylines;
    private WindowInsetsCompat mLastInsets;
    private boolean mNeedsPreDrawListener;
    private final i mNestedScrollingParentHelper;
    private View mNestedScrollingTarget;
    private final int[] mNestedScrollingV2ConsumedCompat;
    ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;
    private d mOnPreDrawListener;
    private Paint mScrimPaint;
    private Drawable mStatusBarBackground;
    private final List<View> mTempList1;

    public interface AttachedBehavior {
        @NonNull
        Behavior getBehavior();
    }

    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        @Nullable
        public static Object getTag(@NonNull View r10) {
            return ((c) r10.getLayoutParams()).f2424r;
        }

        public static void setTag(@NonNull View r10, @Nullable Object r11) {
            ((c) r10.getLayoutParams()).f2424r = r11;
        }

        public boolean blocksInteractionBelow(@NonNull CoordinatorLayout r10, @NonNull V r11) {
            if (getScrimOpacity(r10, r11) <= 0.0f) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean getInsetDodgeRect(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull Rect r12) {
            return false;
        }

        @ColorInt
        public int getScrimColor(@NonNull CoordinatorLayout r10, @NonNull V r11) {
            return -16777216;
        }

        @FloatRange(from = 0.0d, to = 1.0d)
        public float getScrimOpacity(@NonNull CoordinatorLayout r10, @NonNull V r11) {
            return 0.0f;
        }

        public boolean layoutDependsOn(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12) {
            return false;
        }

        @NonNull
        public WindowInsetsCompat onApplyWindowInsets(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull WindowInsetsCompat r12) {
            return r12;
        }

        public void onAttachedToLayoutParams(@NonNull c r10) {
        }

        public boolean onDependentViewChanged(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12) {
            return false;
        }

        public void onDependentViewRemoved(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12) {
        }

        public void onDetachedFromLayoutParams() {
        }

        public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull MotionEvent r12) {
            return false;
        }

        public boolean onLayoutChild(CoordinatorLayout r10, View r11, int r12) {
            return false;
        }

        public boolean onMeasureChild(@NonNull CoordinatorLayout r10, @NonNull V r11, int r12, int r13, int r14, int r15) {
            return false;
        }

        public boolean onNestedFling(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, float r13, float r14, boolean r15) {
            return false;
        }

        public boolean onNestedPreFling(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, float r13, float r14) {
            return false;
        }

        @Deprecated
        public void onNestedPreScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, int r13, int r14, @NonNull int[] r15) {
        }

        @Deprecated
        public void onNestedScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, int r13, int r14, int r15, int r16) {
        }

        @Deprecated
        public void onNestedScrollAccepted(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, @NonNull View r13, int r14) {
        }

        public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull Rect r12, boolean r13) {
            return false;
        }

        public void onRestoreInstanceState(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull Parcelable r12) {
        }

        @Nullable
        public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout r10, @NonNull V r11) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        @Deprecated
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, @NonNull View r13, int r14) {
            return false;
        }

        @Deprecated
        public void onStopNestedScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12) {
        }

        public boolean onTouchEvent(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull MotionEvent r12) {
            return false;
        }

        public Behavior(Context r10, AttributeSet r11) {
        }

        public void onNestedPreScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, int r13, int r14, @NonNull int[] r15, int r16) {
            if (r16 != 0) goto L5;
            onNestedPreScroll(r10, r11, r12, r13, r14, r15);
            return;
        }

        @Deprecated
        public void onNestedScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, int r13, int r14, int r15, int r16, int r17) {
            if (r17 != 0) goto L5;
            onNestedScroll(r10, r11, r12, r13, r14, r15, r16);
            return;
        }

        public void onNestedScrollAccepted(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, @NonNull View r13, int r14, int r15) {
            if (r15 != 0) goto L5;
            onNestedScrollAccepted(r10, r11, r12, r13, r14);
            return;
        }

        public boolean onStartNestedScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, @NonNull View r13, int r14, int r15) {
            if (r15 == 0) goto L4;
            return false;
        L4:
            return onStartNestedScroll(r10, r11, r12, r13, r14);
        }

        public void onStopNestedScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, int r13) {
            if (r13 != 0) goto L5;
            onStopNestedScroll(r10, r11, r12);
            return;
        }

        public void onNestedScroll(@NonNull CoordinatorLayout r10, @NonNull V r11, @NonNull View r12, int r13, int r14, int r15, int r16, int r17, @NonNull int[] r18) {
            r18[0] = r18[0] + r15;
            r18[1] = r18[1] + r16;
            onNestedScroll(r10, r11, r12, r13, r14, r15, r16, r17);
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface DefaultBehavior {
        Class<? extends Behavior> value();
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface DispatchChangeEvent {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        SparseArray<Parcelable> behaviorStates;

        public class a implements Parcelable.ClassLoaderCreator {
            public a() {
            }

            public SavedState a(Parcel r10) {
                return new SavedState(r10, null);
            }

            public SavedState b(Parcel r10, ClassLoader r11) {
                return new SavedState(r10, r11);
            }

            public SavedState[] c(int r10) {
                return new SavedState[r10];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
                return a(r10);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
                return c(r10);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10, ClassLoader r11) {
                return b(r10, r11);
            }
        }

        static {
            CREATOR = new a();
        }

        public SavedState(Parcel r10, ClassLoader r11) {
            super(r10, r11);
            int r12 = r10.readInt();
            int[] r13 = new int[r12];
            r10.readIntArray(r13);
            Parcelable[] r14 = r10.readParcelableArray(r11);
            this.behaviorStates = new SparseArray(r12);
            int r15 = 0;
        L3:
            if (r15 >= r12) goto L5;
            this.behaviorStates.append(r13[r15], r14[r15]);
            r15 = r15 + 1;
            goto L3
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            SparseArray<Parcelable> r12 = this.behaviorStates;
            int r13 = 0;
            if (r12 == null) goto L5;
            int r14 = r12.size();
        L6:
            r10.writeInt(r14);
            int[] r15 = new int[r14];
            Parcelable[] r16 = new Parcelable[r14];
        L7:
            if (r13 >= r14) goto L9;
            r15[r13] = this.behaviorStates.keyAt(r13);
            r16[r13] = this.behaviorStates.valueAt(r13);
            r13 = r13 + 1;
            goto L7
        L9:
            r10.writeIntArray(r15);
            r10.writeParcelableArray(r16, r11);
            return;
        L5:
            r14 = 0;
            goto L6
        }

        public SavedState(Parcelable r10) {
            super(r10);
        }
    }

    public class a implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CoordinatorLayout f2405a;

        public a(CoordinatorLayout r10) {
            this.f2405a = r10;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View r10, WindowInsetsCompat r11) {
            return this.f2405a.setWindowInsets(r11);
        }
    }

    public class b implements ViewGroup.OnHierarchyChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CoordinatorLayout f2406a;

        public b(CoordinatorLayout r10) {
            this.f2406a = r10;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View r10, View r11) {
            ViewGroup.OnHierarchyChangeListener r12 = this.f2406a.mOnHierarchyChangeListener;
            if (r12 == null) goto L6;
            r12.onChildViewAdded(r10, r11);
            return;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View r10, View r11) {
            this.f2406a.onChildViewsChanged(2);
            ViewGroup.OnHierarchyChangeListener r12 = this.f2406a.mOnHierarchyChangeListener;
            if (r12 == null) goto L6;
            r12.onChildViewRemoved(r10, r11);
            return;
        }
    }

    public static class c extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Behavior f2407a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2408b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2409c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2410d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2411e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f2412f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f2413g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f2414h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f2415i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f2416j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public View f2417k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public View f2418l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f2419m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public boolean f2420n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f2421o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f2422p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final Rect f2423q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public Object f2424r;

        public c(int r10, int r11) {
            super(r10, r11);
            this.f2408b = false;
            this.f2409c = 0;
            this.f2410d = 0;
            this.f2411e = -1;
            this.f2412f = -1;
            this.f2413g = 0;
            this.f2414h = 0;
            this.f2423q = new Rect();
        }

        public boolean a() {
            if (this.f2417k == null) goto L5;
        L7:
            return false;
        L5:
            if (this.f2412f == (-1)) goto L7;
            return true;
        }

        public boolean b(CoordinatorLayout r10, View r11, View r12) {
            if (r12 != this.f2418l) goto L5;
        L12:
            return true;
        L5:
            if (s(r12, ViewCompat.A(r10)) == true) goto L12;
            Behavior r13 = this.f2407a;
            if (r13 != null) goto L9;
        L11:
            return false;
        L9:
            if (r13.layoutDependsOn(r10, r11, r12) == false) goto L11;
            goto L11
        }

        public boolean c() {
            if (this.f2407a != null) goto L6;
            this.f2419m = false;
        L6:
            return this.f2419m;
        }

        public View d(CoordinatorLayout r10, View r11) {
            if (this.f2412f != (-1)) goto L7;
            this.f2418l = null;
            this.f2417k = null;
            return null;
        L7:
            if (this.f2417k != null) goto L9;
        L10:
            n(r11, r10);
        L12:
            return this.f2417k;
        L9:
            if (t(r11, r10) == true) goto L12;
            goto L10
        }

        public int e() {
            return this.f2412f;
        }

        public Behavior f() {
            return this.f2407a;
        }

        public boolean g() {
            return this.f2422p;
        }

        public Rect h() {
            return this.f2423q;
        }

        public boolean i(CoordinatorLayout r10, View r11) {
            boolean r12 = this.f2419m;
            if (r12 == false) goto L6;
            return true;
        L6:
            Behavior r13 = this.f2407a;
            if (r13 == null) goto L9;
            boolean r14 = r13.blocksInteractionBelow(r10, r11);
        L10:
            boolean r15 = r14 | r12;
            this.f2419m = r15;
            return r15;
        L9:
            r14 = false;
            goto L10
        }

        public boolean j(int r10) {
            if (r10 == 0) goto L10;
            if (r10 == 1) goto L8;
            return false;
        L8:
            return this.f2421o;
        L10:
            return this.f2420n;
        }

        public void k() {
            this.f2422p = false;
        }

        public void l(int r10) {
            r(r10, false);
        }

        public void m() {
            this.f2419m = false;
        }

        public final void n(View r10, CoordinatorLayout r11) {
            View r12 = r11.findViewById(this.f2412f);
            this.f2417k = r12;
            if (r12 == null) goto L28;
            if (r12 == r11) goto L6;
            ViewParent r13 = r12.getParent();
        L12:
            if (r13 == r11) goto L25;
            if (r13 == null) goto L25;
            if (r13 == r10) goto L16;
            if ((r13 instanceof View) == false) goto L24;
            r12 = r13;
        L24:
            r13 = r13.getParent();
            goto L12
        L16:
            if (r11.isInEditMode() == false) goto L20;
            this.f2418l = null;
            this.f2417k = null;
            return;
        L20:
            throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
        L25:
            this.f2418l = r12;
            return;
        L6:
            if (r11.isInEditMode() == false) goto L10;
            this.f2418l = null;
            this.f2417k = null;
            return;
        L10:
            throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
        L28:
            if (r11.isInEditMode() == false) goto L32;
            this.f2418l = null;
            this.f2417k = null;
            return;
        L32:
            throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + r11.getResources().getResourceName(this.f2412f) + " to anchor view " + r10);
        }

        public void o(Behavior r10) {
            Behavior r11 = this.f2407a;
            if (r11 == r10) goto L10;
            if (r11 == null) goto L6;
            r11.onDetachedFromLayoutParams();
        L6:
            this.f2407a = r10;
            this.f2424r = null;
            this.f2408b = true;
            if (r10 == null) goto L11;
            r10.onAttachedToLayoutParams(this);
            return;
        L11:
            return;
        }

        public void p(boolean r10) {
            this.f2422p = r10;
        }

        public void q(Rect r10) {
            this.f2423q.set(r10);
        }

        public void r(int r10, boolean r11) {
            if (r10 != 0) goto L4;
            this.f2420n = r11;
            return;
        L4:
            if (r10 != 1) goto L10;
            this.f2421o = r11;
            return;
        }

        public final boolean s(View r10, int r11) {
            int r12 = androidx.core.view.c.b(((c) r10.getLayoutParams()).f2413g, r11);
            if (r12 != 0) goto L5;
        L7:
            return false;
        L5:
            if ((androidx.core.view.c.b(this.f2414h, r11) & r12) != r12) goto L7;
            return true;
        }

        public final boolean t(View r10, CoordinatorLayout r11) {
            if (this.f2417k.getId() == this.f2412f) goto L5;
            return false;
        L5:
            View r12 = this.f2417k;
            ViewParent r13 = r12.getParent();
        L6:
            if (r13 == r11) goto L16;
            if (r13 == null) goto L14;
            if (r13 == r10) goto L14;
            if ((r13 instanceof View) == false) goto L13;
            r12 = r13;
        L13:
            r13 = r13.getParent();
        L14:
            this.f2418l = null;
            this.f2417k = null;
            return false;
        L16:
            this.f2418l = r12;
            return true;
        }

        public c(Context r10, AttributeSet r11) {
            super(r10, r11);
            this.f2408b = false;
            this.f2409c = 0;
            this.f2410d = 0;
            this.f2411e = -1;
            this.f2412f = -1;
            this.f2413g = 0;
            this.f2414h = 0;
            this.f2423q = new Rect();
            TypedArray r12 = r10.obtainStyledAttributes(r11, R$styleable.CoordinatorLayout_Layout);
            this.f2409c = r12.getInteger(R$styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f2412f = r12.getResourceId(R$styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f2410d = r12.getInteger(R$styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f2411e = r12.getInteger(R$styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f2413g = r12.getInt(R$styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f2414h = r12.getInt(R$styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            int r13 = R$styleable.CoordinatorLayout_Layout_layout_behavior;
            boolean r14 = r12.hasValue(r13);
            this.f2408b = r14;
            if (r14 == false) goto L5;
            this.f2407a = CoordinatorLayout.parseBehavior(r10, r11, r12.getString(r13));
        L5:
            r12.recycle();
            Behavior r15 = this.f2407a;
            if (r15 == null) goto L9;
            r15.onAttachedToLayoutParams(this);
            return;
        }

        public c(c r10) {
            super(r10);
            this.f2408b = false;
            this.f2409c = 0;
            this.f2410d = 0;
            this.f2411e = -1;
            this.f2412f = -1;
            this.f2413g = 0;
            this.f2414h = 0;
            this.f2423q = new Rect();
        }

        public c(ViewGroup.MarginLayoutParams r10) {
            super(r10);
            this.f2408b = false;
            this.f2409c = 0;
            this.f2410d = 0;
            this.f2411e = -1;
            this.f2412f = -1;
            this.f2413g = 0;
            this.f2414h = 0;
            this.f2423q = new Rect();
        }

        public c(ViewGroup.LayoutParams r10) {
            super(r10);
            this.f2408b = false;
            this.f2409c = 0;
            this.f2410d = 0;
            this.f2411e = -1;
            this.f2412f = -1;
            this.f2413g = 0;
            this.f2414h = 0;
            this.f2423q = new Rect();
        }
    }

    public class d implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CoordinatorLayout f2425a;

        public d(CoordinatorLayout r10) {
            this.f2425a = r10;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f2425a.onChildViewsChanged(0);
            return true;
        }
    }

    public static class e implements Comparator {
        public e() {
        }

        public int a(View r10, View r11) {
            float r12 = ViewCompat.M(r10);
            float r13 = ViewCompat.M(r11);
            if (r12 <= r13) goto L7;
            return -1;
        L7:
            if (r12 >= r13) goto L10;
            return 1;
        L10:
            return 0;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((View) r10, (View) r11);
        }
    }

    static {
        Package r10 = CoordinatorLayout.class.getPackage();
        if (r10 == null) goto L5;
        String r11 = r10.getName();
    L6:
        WIDGET_PACKAGE_NAME = r11;
        TOP_SORTED_CHILDREN_COMPARATOR = new e();
        CONSTRUCTOR_PARAMS = new Class[]{Context.class, AttributeSet.class};
        sConstructors = new ThreadLocal();
        sRectPool = new Pools$SynchronizedPool(12);
        return;
    L5:
        r11 = null;
        goto L6
    }

    public CoordinatorLayout(@NonNull Context r10) {
        this(r10, null);
    }

    public static Rect a() {
        Rect r10 = sRectPool.acquire();
        if (r10 == null) goto L5;
        return r10;
    L5:
        return new Rect();
    }

    public static int c(int r10, int r11, int r12) {
        if (r10 >= r11) goto L4;
        return r11;
    L4:
        if (r10 <= r12) goto L6;
        return r12;
    L6:
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Behavior parseBehavior(Context r10, AttributeSet r11, String r12) {
        if (TextUtils.isEmpty(r12) == false) goto L7;
        return null;
    L7:
        if (r12.startsWith(LibrarianImpl.Constants.DOT) == false) goto L10;
        r12 = r10.getPackageName() + r12;
    L27:
        ThreadLocal<Map<String, Constructor<Behavior>>> r13 = sConstructors;     // Catch: Exception -> L18
        Map<String, Constructor<Behavior>> r14 = r13.get();     // Catch: Exception -> L18
        if (r14 != null) goto L20;
        r14 = new HashMap();     // Catch: Exception -> L18
        r13.set(r14);     // Catch: Exception -> L18
    L20:
        Constructor<Behavior> r15 = r14.get(r12);     // Catch: Exception -> L18
        if (r15 != null) goto L23;
        r15 = Class.forName(r12, false, r10.getClassLoader()).getConstructor(CONSTRUCTOR_PARAMS);     // Catch: Exception -> L18
        r15.setAccessible(true);     // Catch: Exception -> L18
        r14.put(r12, r15);     // Catch: Exception -> L18
    L23:
        return r15.newInstance(new Object[]{r10, r11});
    L18:
        e = move-exception;
        throw new RuntimeException("Could not inflate Behavior subclass " + r12, e);
    L10:
        if (r12.indexOf(46) >= 0) goto L27;
        String r16 = WIDGET_PACKAGE_NAME;
        if (TextUtils.isEmpty(r16) == true) goto L27;
        r12 = r16 + '.' + r12;
        goto L27
    }

    public static void r(Rect r10) {
        r10.setEmpty();
        sRectPool.release(r10);
    }

    public static int t(int r10) {
        if (r10 != 0) goto L5;
        return 17;
    L5:
        return r10;
    }

    public static int u(int r10) {
        if ((r10 & 7) != 0) goto L6;
        r10 = r10 | 8388611;
    L6:
        if ((r10 & 112) == 0) goto L8;
        return r10;
    L8:
        return r10 | 48;
    }

    public static int v(int r10) {
        if (r10 != 0) goto L5;
        return BadgeDrawable.TOP_END;
    L5:
        return r10;
    }

    public void addPreDrawListener() {
        if (this.mIsAttachedToWindow == true) goto L5;
    L8:
        this.mNeedsPreDrawListener = true;
        return;
    L5:
        if (this.mOnPreDrawListener != null) goto L7;
        this.mOnPreDrawListener = new d(this);
    L7:
        getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
        goto L8
    }

    public final void b() {
        int r10 = getChildCount();
        MotionEvent r11 = null;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L10;
        View r13 = getChildAt(r12);
        Behavior r14 = ((c) r13.getLayoutParams()).f();
        if (r14 == null) goto L9;
        if (r11 != null) goto L8;
        long r15 = SystemClock.uptimeMillis();
        r11 = MotionEvent.obtain(r15, r15, 3, 0.0f, 0.0f, 0);
    L8:
        r14.onInterceptTouchEvent(this, r13, r11);
    L9:
        r12 = r12 + 1;
        goto L3
    L10:
        if (r11 == null) goto L16;
        r11.recycle();
        return;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        if ((r10 instanceof c) == true) goto L5;
    L7:
        return false;
    L5:
        if (super.checkLayoutParams(r10) == false) goto L7;
        return true;
    }

    public final void d(c r10, Rect r11, int r12, int r13) {
        int r14 = getWidth();
        int r15 = getHeight();
        int r16 = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r10).leftMargin, Math.min(r11.left, ((r14 - getPaddingRight()) - r12) - ((ViewGroup.MarginLayoutParams) r10).rightMargin));
        int r17 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) r10).topMargin, Math.min(r11.top, ((r15 - getPaddingBottom()) - r13) - ((ViewGroup.MarginLayoutParams) r10).bottomMargin));
        r11.set(r16, r17, r12 + r16, r13 + r17);
    }

    public void dispatchDependentViewsChanged(@NonNull View r10) {
        ArrayList r11 = this.mChildDag.h(r10);
        if (r11 != null) goto L5;
        return;
    L5:
        if (r11.isEmpty() == true) goto L17;
        int r12 = 0;
    L8:
        if (r12 >= r11.size()) goto L18;
        View r13 = (View) r11.get(r12);
        Behavior r14 = ((c) r13.getLayoutParams()).f();
        if (r14 == null) goto L12;
        r14.onDependentViewChanged(this, r13, r10);
    L12:
        r12 = r12 + 1;
        goto L8
    L18:
        return;
    }

    public boolean doViewsOverlap(@NonNull View r10, @NonNull View r11) {
        boolean r12 = false;
        if (r10.getVisibility() == 0) goto L5;
    L30:
        return false;
    L5:
        if (r11.getVisibility() != 0) goto L30;
        Rect r13 = a();
        if (r10.getParent() == this) goto L9;
        boolean r14 = true;
    L10:
        getChildRect(r10, r14, r13);
        Rect r15 = a();
        if (r11.getParent() == this) goto L13;
        boolean r16 = true;
    L14:
        getChildRect(r11, r16, r15);
    L24:
        th = move-exception;
        r(r13);
        r(r15);
        throw th;
    L16:
        if (r13.left <= r15.right) goto L18;
    L26:
        r(r13);
        r(r15);
        return r12;
    L18:
        if (r13.top > r15.bottom) goto L26;
        if (r13.right < r15.left) goto L26;
        if (r13.bottom < r15.top) goto L26;
        r12 = true;
        goto L26
    L13:
        r16 = false;
        goto L14
    L9:
        r14 = false;
        goto L10
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r10, View r11, long r12) {
        c r13 = (c) r11.getLayoutParams();
        Behavior r14 = r13.f2407a;
        if (r14 == null) goto L14;
        float r15 = r14.getScrimOpacity(this, r11);
        if (r15 <= 0.0f) goto L14;
        if (this.mScrimPaint != null) goto L9;
        this.mScrimPaint = new Paint();
    L9:
        this.mScrimPaint.setColor(r13.f2407a.getScrimColor(this, r11));
        this.mScrimPaint.setAlpha(c(Math.round(r15 * 255.0f), 0, PrivateKeyType.INVALID));
        int r16 = r10.save();
        if (r11.isOpaque() == false) goto L12;
        r10.clipRect(r11.getLeft(), r11.getTop(), r11.getRight(), r11.getBottom(), Region.Op.DIFFERENCE);
    L12:
        r10.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.mScrimPaint);
        r10.restoreToCount(r16);
    L14:
        return super.drawChild(r10, r11, r12);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] r10 = getDrawableState();
        Drawable r11 = this.mStatusBarBackground;
        if (r11 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        if (r12 == false) goto L11;
        invalidate();
        return;
    L11:
        return;
    L5:
        if (r11.isStateful() == false) goto L7;
        r12 = r11.setState(r10);
        goto L8
    }

    public final WindowInsetsCompat e(WindowInsetsCompat r10) {
        if (r10.r() == false) goto L5;
        return r10;
    L5:
        int r11 = getChildCount();
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L15;
        View r13 = getChildAt(r12);
        if (ViewCompat.x(r13) == false) goto L14;
        Behavior r14 = ((c) r13.getLayoutParams()).f();
        if (r14 == null) goto L14;
        r10 = r14.onApplyWindowInsets(this, r13, r10);
        if (r10.r() == true) goto L15;
    L14:
        r12 = r12 + 1;
    L15:
        return r10;
    }

    public void ensurePreDrawListener() {
        int r10 = getChildCount();
        boolean r11 = false;
        int r12 = 0;
    L3:
        if (r12 >= r10) goto L9;
        if (i(getChildAt(r12)) == true) goto L6;
        r12 = r12 + 1;
        goto L3
    L6:
        r11 = true;
    L9:
        if (r11 == this.mNeedsPreDrawListener) goto L16;
        if (r11 == false) goto L12;
        addPreDrawListener();
        return;
    L12:
        removePreDrawListener();
        return;
    }

    public final void f(int r10, Rect r11, Rect r12, c r13, int r14, int r15) {
        int r16 = androidx.core.view.c.b(t(r13.f2409c), r10);
        int r17 = androidx.core.view.c.b(u(r13.f2410d), r10);
        int r18 = r16 & 7;
        int r19 = r16 & 112;
        int r20 = r17 & 7;
        int r21 = r17 & 112;
        if (r20 == 1) goto L7;
        if (r20 == 5) goto L6;
        int r22 = r11.left;
    L9:
        if (r21 == 16) goto L13;
        if (r21 == 80) goto L12;
        int r23 = r11.top;
    L14:
        if (r18 == 1) goto L17;
        if (r18 == 5) goto L18;
        r22 = r22 - r14;
    L18:
        if (r19 == 16) goto L21;
        if (r19 == 80) goto L22;
        r23 = r23 - r15;
    L22:
        r12.set(r22, r23, r14 + r22, r15 + r23);
        return;
    L21:
        r23 = r23 - (r15 / 2);
        goto L22
    L17:
        r22 = r22 - (r14 / 2);
        goto L18
    L12:
        r23 = r11.bottom;
        goto L14
    L13:
        r23 = r11.top + (r11.height() / 2);
        goto L14
    L6:
        r22 = r11.right;
        goto L9
    L7:
        r22 = r11.left + (r11.width() / 2);
        goto L9
    }

    public final int g(int r10) {
        int[] r11 = this.mKeylines;
        if (r11 != null) goto L6;
        Log.e(TAG, "No keylines defined for " + this + " - attempted index lookup " + r10);
        return 0;
    L6:
        if (r10 >= 0) goto L8;
    L12:
        Log.e(TAG, "Keyline index " + r10 + " out of range for " + this);
        return 0;
    L8:
        if (r10 >= r11.length) goto L12;
        return r11[r10];
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        return generateLayoutParams(r10);
    }

    public void getChildRect(View r10, boolean r11, Rect r12) {
        if (r10.isLayoutRequested() == false) goto L5;
    L11:
        r12.setEmpty();
        return;
    L5:
        if (r10.getVisibility() == 8) goto L11;
        if (r11 == false) goto L9;
        getDescendantRect(r10, r12);
        return;
    L9:
        r12.set(r10.getLeft(), r10.getTop(), r10.getRight(), r10.getBottom());
    }

    @NonNull
    public List<View> getDependencies(@NonNull View r10) {
        List<View> r11 = this.mChildDag.i(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return Collections.emptyList();
    }

    @VisibleForTesting
    public final List<View> getDependencySortedChildren() {
        q();
        return Collections.unmodifiableList(this.mDependencySortedChildren);
    }

    @NonNull
    public List<View> getDependents(@NonNull View r10) {
        List<View> r11 = this.mChildDag.g(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        return Collections.emptyList();
    }

    public void getDescendantRect(View r10, Rect r11) {
        androidx.coordinatorlayout.widget.b.a(this, r10, r11);
    }

    public void getDesiredAnchoredChildRect(View r10, int r11, Rect r12, Rect r13) {
        c r14 = (c) r10.getLayoutParams();
        int r15 = r10.getMeasuredWidth();
        int r16 = r10.getMeasuredHeight();
        f(r11, r12, r13, r14, r15, r16);
        d(r14, r13, r15, r16);
    }

    public void getLastChildRect(View r10, Rect r11) {
        r11.set(((c) r10.getLayoutParams()).h());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final WindowInsetsCompat getLastWindowInsets() {
        return this.mLastInsets;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c getResolvedLayoutParams(View r10) {
        c r11 = (c) r10.getLayoutParams();
        if (r11.f2408b == false) goto L5;
    L21:
        return r11;
    L5:
        if ((r10 instanceof AttachedBehavior) == false) goto L10;
        Behavior r12 = ((AttachedBehavior) r10).getBehavior();
        if (r12 != null) goto L9;
        Log.e(TAG, "Attached behavior class is null");
    L9:
        r11.o(r12);
        r11.f2408b = true;
        goto L21
    L10:
        Class<?> r13 = r10.getClass();
        DefaultBehavior r14 = null;
    L11:
        if (r13 == null) goto L15;
        r14 = (DefaultBehavior) r13.getAnnotation(DefaultBehavior.class);
        if (r14 != null) goto L15;
        r13 = r13.getSuperclass();
    L15:
        if (r14 != null) goto L22;
    L20:
        r11.f2408b = true;
        goto L21
    L22:
        r11.o(r14.value().getDeclaredConstructor(null).newInstance(null));     // Catch: Exception -> L18
    L18:
        e = move-exception;
        Log.e(TAG, "Default behavior class " + r14.value().getName() + " could not be instantiated. Did you forget a default constructor?", e);
        goto L20
    }

    @Nullable
    public Drawable getStatusBarBackground() {
        return this.mStatusBarBackground;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    public final void h(List r10) {
        r10.clear();
        boolean r11 = isChildrenDrawingOrderEnabled();
        int r12 = getChildCount();
        int r13 = r12 - 1;
    L3:
        if (r13 < 0) goto L8;
        if (r11 == false) goto L6;
        int r14 = getChildDrawingOrder(r12, r13);
    L7:
        r10.add(getChildAt(r14));
        r13 = r13 - 1;
        goto L3
    L6:
        r14 = r13;
        goto L7
    L8:
        Comparator<View> r15 = TOP_SORTED_CHILDREN_COMPARATOR;
        if (r15 == null) goto L15;
        Collections.sort(r10, r15);
        return;
    }

    public final boolean i(View r10) {
        return this.mChildDag.k(r10);
    }

    public boolean isPointInChildBounds(@NonNull View r10, int r11, int r12) {
        Rect r13 = a();
        getDescendantRect(r10, r13);
        boolean r14 = r13.contains(r11, r12);     // Catch: Throwable -> L6
        r(r13);
        return r14;
    L6:
        th = move-exception;
        r(r13);
        throw th;
    }

    public final void j(View r10, int r11) {
        c r12 = (c) r10.getLayoutParams();
        Rect r13 = a();
        r13.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r12).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) r12).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) r12).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) r12).bottomMargin);
        if (this.mLastInsets != null) goto L5;
    L9:
        Rect r14 = a();
        androidx.core.view.c.a(u(r12.f2409c), r10.getMeasuredWidth(), r10.getMeasuredHeight(), r13, r14, r11);
        r10.layout(r14.left, r14.top, r14.right, r14.bottom);
        r(r13);
        r(r14);
        return;
    L5:
        if (ViewCompat.x(this) == false) goto L9;
        if (ViewCompat.x(r10) == true) goto L9;
        r13.left += this.mLastInsets.k();
        r13.top += this.mLastInsets.m();
        r13.right -= this.mLastInsets.l();
        r13.bottom -= this.mLastInsets.j();
        goto L9
    }

    public final void k(View r10, View r11, int r12) {
        Rect r13 = a();
        Rect r14 = a();
        getDescendantRect(r11, r13);     // Catch: Throwable -> L6
        getDesiredAnchoredChildRect(r10, r12, r13, r14);     // Catch: Throwable -> L6
        r10.layout(r14.left, r14.top, r14.right, r14.bottom);     // Catch: Throwable -> L6
        r(r13);
        r(r14);
        return;
    L6:
        th = move-exception;
        r(r13);
        r(r14);
        throw th;
    }

    public final void l(View r10, int r11, int r12) {
        c r13 = (c) r10.getLayoutParams();
        int r14 = androidx.core.view.c.b(v(r13.f2409c), r12);
        int r15 = r14 & 7;
        int r16 = r14 & 112;
        int r17 = getWidth();
        int r18 = getHeight();
        int r19 = r10.getMeasuredWidth();
        int r20 = r10.getMeasuredHeight();
        if (r12 != 1) goto L5;
        r11 = r17 - r11;
    L5:
        int r110 = g(r11) - r19;
        if (r15 != 1) goto L8;
        r110 = r110 + (r19 / 2);
    L13:
        if (r16 != 16) goto L15;
        int r111 = r20 / 2;
    L19:
        int r112 = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r13).leftMargin, Math.min(r110, ((r17 - getPaddingRight()) - r19) - ((ViewGroup.MarginLayoutParams) r13).rightMargin));
        int r21 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) r13).topMargin, Math.min(r111, ((r18 - getPaddingBottom()) - r20) - ((ViewGroup.MarginLayoutParams) r13).bottomMargin));
        r10.layout(r112, r21, r19 + r112, r20 + r21);
        return;
    L15:
        if (r16 == 80) goto L17;
        r111 = 0;
        goto L19
    L17:
        r111 = r20;
        goto L19
    L8:
        if (r15 != 5) goto L13;
        r110 = r110 + r19;
        goto L13
    }

    public final MotionEvent m(MotionEvent r10) {
        MotionEvent r11 = MotionEvent.obtain(r10);
        r11.setAction(3);
        return r11;
    }

    public final void n(View r10, Rect r11, int r12) {
        if (ViewCompat.T(r10) == true) goto L6;
        return;
    L6:
        if (r10.getWidth() > 0) goto L8;
        return;
    L8:
        if (r10.getHeight() <= 0) goto L54;
        c r13 = (c) r10.getLayoutParams();
        Behavior r14 = r13.f();
        Rect r15 = a();
        Rect r16 = a();
        r16.set(r10.getLeft(), r10.getTop(), r10.getRight(), r10.getBottom());
        if (r14 != null) goto L13;
    L19:
        r15.set(r16);
    L20:
        r(r16);
        if (r15.isEmpty() == false) goto L24;
        r(r15);
        return;
    L24:
        int r17 = androidx.core.view.c.b(r13.f2414h, r12);
        boolean r18 = true;
        if ((r17 & 48) != 48) goto L29;
        int r19 = (r15.top - ((ViewGroup.MarginLayoutParams) r13).topMargin) - r13.f2416j;
        int r20 = r11.top;
        if (r19 >= r20) goto L29;
        x(r10, r20 - r19);
        boolean r21 = true;
    L31:
        if ((r17 & 80) != 80) goto L35;
        int r22 = ((getHeight() - r15.bottom) - ((ViewGroup.MarginLayoutParams) r13).bottomMargin) + r13.f2416j;
        int r23 = r11.bottom;
        if (r22 >= r23) goto L35;
        x(r10, r22 - r23);
        r21 = true;
    L35:
        if (r21 == true) goto L38;
        x(r10, 0);
    L38:
        if ((r17 & 3) != 3) goto L42;
        int r24 = (r15.left - ((ViewGroup.MarginLayoutParams) r13).leftMargin) - r13.f2415i;
        int r25 = r11.left;
        if (r24 >= r25) goto L42;
        w(r10, r25 - r24);
        boolean r26 = true;
    L44:
        if ((r17 & 5) != 5) goto L48;
        int r110 = ((getWidth() - r15.right) - ((ViewGroup.MarginLayoutParams) r13).rightMargin) + r13.f2415i;
        int r111 = r11.right;
        if (r110 >= r111) goto L48;
        w(r10, r110 - r111);
    L49:
        if (r18 == true) goto L51;
        w(r10, 0);
    L51:
        r(r15);
        return;
    L48:
        r18 = r26;
    L42:
        r26 = false;
    L29:
        r21 = false;
        goto L31
    L13:
        if (r14.getInsetDodgeRect(this, r10, r15) == false) goto L19;
        if (r16.contains(r15) == true) goto L20;
        throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + r15.toShortString() + " | Bounds:" + r16.toShortString());
    }

    public final boolean o(Behavior r10, View r11, MotionEvent r12, int r13) {
        if (r13 == 0) goto L10;
        if (r13 != 1) goto L8;
        return r10.onTouchEvent(this, r11, r12);
    L8:
        throw new IllegalArgumentException();
    L10:
        return r10.onInterceptTouchEvent(this, r11, r12);
    }

    public void offsetChildToAnchor(View r17, int r18) {
        c r10 = (c) r17.getLayoutParams();
        if (r10.f2417k == null) goto L20;
        Rect r11 = a();
        Rect r12 = a();
        Rect r13 = a();
        getDescendantRect(r10.f2417k, r11);
        boolean r14 = false;
        getChildRect(r17, false, r12);
        int r15 = r17.getMeasuredWidth();
        int r16 = r17.getMeasuredHeight();
        f(r18, r11, r13, r10, r15, r16);
        if (r13.left == r12.left) goto L7;
    L8:
        r14 = true;
    L9:
        d(r10, r13, r15, r16);
        int r19 = r13.left - r12.left;
        int r20 = r13.top - r12.top;
        if (r19 == 0) goto L12;
        ViewCompat.Z(r17, r19);
    L12:
        if (r20 == 0) goto L14;
        ViewCompat.a0(r17, r20);
    L14:
        if (r14 == false) goto L18;
        Behavior r21 = r10.f();
        if (r21 == null) goto L18;
        r21.onDependentViewChanged(this, r17, r10.f2417k);
    L18:
        r(r11);
        r(r12);
        r(r13);
        return;
    L7:
        if (r13.top == r12.top) goto L9;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        s();
        if (this.mNeedsPreDrawListener == false) goto L9;
        if (this.mOnPreDrawListener != null) goto L7;
        this.mOnPreDrawListener = new d(this);
    L7:
        getViewTreeObserver().addOnPreDrawListener(this.mOnPreDrawListener);
    L9:
        if (this.mLastInsets == null) goto L11;
    L13:
        this.mIsAttachedToWindow = true;
        return;
    L11:
        if (ViewCompat.x(this) == false) goto L13;
        ViewCompat.m0(this);
        goto L13
    }

    public final void onChildViewsChanged(int r18) {
        int r10 = ViewCompat.A(this);
        int r11 = this.mDependencySortedChildren.size();
        Rect r12 = a();
        Rect r13 = a();
        Rect r14 = a();
        int r15 = 0;
    L3:
        if (r15 >= r11) goto L61;
        View r16 = this.mDependencySortedChildren.get(r15);
        c r17 = (c) r16.getLayoutParams();
        if (r18 == 0) goto L7;
    L9:
        int r19 = 0;
    L10:
        if (r19 >= r15) goto L15;
        if (r17.f2418l != this.mDependencySortedChildren.get(r19)) goto L14;
        offsetChildToAnchor(r16, r10);
    L14:
        r19 = r19 + 1;
        goto L10
    L15:
        getChildRect(r16, true, r13);
        if (r17.f2413g == 0) goto L34;
        if (r13.isEmpty() == true) goto L34;
        int r110 = androidx.core.view.c.b(r17.f2413g, r10);
        int r111 = r110 & 112;
        if (r111 != 48) goto L22;
        r12.top = Math.max(r12.top, r13.bottom);
    L26:
        int r112 = r110 & 7;
        if (r112 != 3) goto L29;
        r12.left = Math.max(r12.left, r13.right);
        goto L34
    L29:
        if (r112 != 5) goto L34;
        r12.right = Math.max(r12.right, getWidth() - r13.left);
        goto L34
    L22:
        if (r111 != 80) goto L26;
        r12.bottom = Math.max(r12.bottom, getHeight() - r13.top);
    L34:
        if (r17.f2414h == 0) goto L39;
        if (r16.getVisibility() != 0) goto L39;
        n(r16, r12, r10);
    L39:
        if (r18 == 2) goto L44;
        getLastChildRect(r16, r14);
        if (r14.equals(r13) == true) goto L60;
        recordLastChildRect(r16, r13);
    L60:
        r15 = r15 + 1;
    L44:
        int r113 = r15 + 1;
    L45:
        if (r113 >= r11) goto L60;
        View r114 = this.mDependencySortedChildren.get(r113);
        c r115 = (c) r114.getLayoutParams();
        Behavior r116 = r115.f();
        if (r116 == null) goto L59;
        if (r116.layoutDependsOn(this, r114, r16) == false) goto L59;
        if (r18 == 0) goto L52;
    L54:
        if (r18 == 2) goto L56;
        boolean r117 = r116.onDependentViewChanged(this, r114, r16);
    L57:
        if (r18 != 1) goto L59;
        r115.p(r117);
        goto L59
    L56:
        r116.onDependentViewRemoved(this, r114, r16);
        r117 = true;
        goto L57
    L52:
        if (r115.g() == false) goto L54;
        r115.k();
    L59:
        r113 = r113 + 1;
        goto L45
    L7:
        if (r16.getVisibility() != 8) goto L9;
    L61:
        r(r12);
        r(r13);
        r(r14);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        s();
        if (this.mNeedsPreDrawListener == true) goto L5;
    L7:
        View r10 = this.mNestedScrollingTarget;
        if (r10 == null) goto L10;
        onStopNestedScroll(r10);
    L10:
        this.mIsAttachedToWindow = false;
        return;
    L5:
        if (this.mOnPreDrawListener == null) goto L7;
        getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        goto L7
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
        super.onDraw(r10);
        if (this.mDrawStatusBarBackground == true) goto L5;
        return;
    L5:
        if (this.mStatusBarBackground == null) goto L14;
        WindowInsetsCompat r11 = this.mLastInsets;
        if (r11 == null) goto L9;
        int r12 = r11.m();
    L10:
        if (r12 <= 0) goto L15;
        this.mStatusBarBackground.setBounds(0, 0, getWidth(), r12);
        this.mStatusBarBackground.draw(r10);
        return;
    L15:
        return;
    L9:
        r12 = 0;
        goto L10
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        int r11 = r10.getActionMasked();
        if (r11 != 0) goto L5;
        s();
    L5:
        boolean r12 = p(r10, 0);
        if (r11 != 1) goto L8;
    L9:
        this.mBehaviorTouchView = null;
        s();
    L10:
        return r12;
    L8:
        if (r11 != 3) goto L10;
        goto L9
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        int r15 = ViewCompat.A(this);
        int r16 = this.mDependencySortedChildren.size();
        int r17 = 0;
    L3:
        if (r17 >= r16) goto L13;
        View r18 = this.mDependencySortedChildren.get(r17);
        if (r18.getVisibility() == 8) goto L12;
        Behavior r19 = ((c) r18.getLayoutParams()).f();
        if (r19 != null) goto L10;
    L11:
        onLayoutChild(r18, r15);
        goto L12
    L10:
        if (r19.onLayoutChild(this, r18, r15) == false) goto L11;
    L12:
        r17 = r17 + 1;
        goto L3
    }

    public void onLayoutChild(@NonNull View r10, int r11) {
        c r12 = (c) r10.getLayoutParams();
        if (r12.a() == true) goto L13;
        View r13 = r12.f2417k;
        if (r13 == null) goto L7;
        k(r10, r13, r11);
        return;
    L7:
        int r14 = r12.f2411e;
        if (r14 < 0) goto L10;
        l(r10, r14, r11);
        return;
    L10:
        j(r10, r11);
        return;
    L13:
        throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
    }

    @Override // android.view.View
    public void onMeasure(int r31, int r32) {
        q();
        ensurePreDrawListener();
        int r10 = getPaddingLeft();
        int r11 = getPaddingTop();
        int r12 = getPaddingRight();
        int r13 = getPaddingBottom();
        int r14 = ViewCompat.A(this);
        if (r14 != 1) goto L5;
        boolean r15 = true;
    L6:
        int r16 = View.MeasureSpec.getMode(r31);
        int r17 = View.MeasureSpec.getSize(r31);
        int r18 = View.MeasureSpec.getMode(r32);
        int r19 = View.MeasureSpec.getSize(r32);
        int r110 = r10 + r12;
        int r111 = r11 + r13;
        int r20 = getSuggestedMinimumWidth();
        int r21 = getSuggestedMinimumHeight();
        if (this.mLastInsets != null) goto L9;
    L11:
        boolean r112 = false;
    L12:
        int r22 = this.mDependencySortedChildren.size();
        int r23 = r20;
        int r24 = r21;
        int r25 = 0;
        int r26 = 0;
    L13:
        if (r26 >= r22) goto L50;
        View r27 = this.mDependencySortedChildren.get(r26);
        if (r27.getVisibility() != 8) goto L17;
        int r28 = r26;
        int r29 = r22;
        int r210 = r10;
    L49:
        r26 = r28 + 1;
        r10 = r210;
        r22 = r29;
        goto L13
    L17:
        c r30 = (c) r27.getLayoutParams();
        int r33 = r30.f2411e;
        if (r33 < 0) goto L34;
        if (r16 == 0) goto L34;
        int r34 = g(r33);
        int r113 = androidx.core.view.c.b(v(r30.f2409c), r14) & 7;
        int r211 = r25;
        if (r113 != 3) goto L24;
        if (r15 == true) goto L24;
    L26:
        int r212 = Math.max(0, (r17 - r12) - r34);
    L36:
        if (r112 == true) goto L38;
    L40:
        int r114 = r31;
        int r213 = r32;
    L41:
        Behavior r35 = r30.f();
        if (r35 == null) goto L46;
        c r214 = r30;
        int r215 = r211;
        r28 = r26;
        int r216 = r24;
        r210 = r10;
        int r36 = r23;
        r29 = r22;
        if (r35.onMeasureChild(this, r27, r114, r212, r213, 0) == false) goto L47;
    L48:
        c r37 = r214;
        int r38 = Math.max(r36, ((r110 + r27.getMeasuredWidth()) + ((ViewGroup.MarginLayoutParams) r37).leftMargin) + ((ViewGroup.MarginLayoutParams) r37).rightMargin);
        int r39 = Math.max(r216, ((r111 + r27.getMeasuredHeight()) + ((ViewGroup.MarginLayoutParams) r37).topMargin) + ((ViewGroup.MarginLayoutParams) r37).bottomMargin);
        r25 = View.combineMeasuredStates(r215, r27.getMeasuredState());
        r23 = r38;
        r24 = r39;
    L47:
        onMeasureChild(r27, r114, r212, r213, 0);
        goto L48
    L46:
        r214 = r30;
        r216 = r24;
        r29 = r22;
        r210 = r10;
        r215 = r211;
        r28 = r26;
        r36 = r23;
        goto L47
    L38:
        if (ViewCompat.x(r27) == true) goto L40;
        int r40 = this.mLastInsets.k() + this.mLastInsets.l();
        int r41 = this.mLastInsets.m() + this.mLastInsets.j();
        r114 = View.MeasureSpec.makeMeasureSpec(r17 - r40, r16);
        r213 = View.MeasureSpec.makeMeasureSpec(r19 - r41, r18);
    L24:
        if (r113 != 5) goto L27;
        if (r15 == true) goto L26;
    L27:
        if (r113 != 5) goto L30;
        if (r15 == true) goto L30;
    L32:
        r212 = Math.max(0, r34 - r10);
    L30:
        if (r113 != 3) goto L35;
        if (r15 == true) goto L32;
    L35:
        r212 = 0;
    L34:
        r211 = r25;
        goto L35
    L50:
        int r115 = r25;
        setMeasuredDimension(View.resolveSizeAndState(r23, r31, (-16777216) & r115), View.resolveSizeAndState(r24, r32, r115 << 16));
        return;
    L9:
        if (ViewCompat.x(this) == false) goto L11;
        r112 = true;
        goto L12
    L5:
        r15 = false;
        goto L6
    }

    public void onMeasureChild(View r10, int r11, int r12, int r13, int r14) {
        measureChildWithMargins(r10, r11, r12, r13, r14);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(View r12, float r13, float r14, boolean r15) {
        int r10 = getChildCount();
        int r11 = 0;
        boolean r16 = false;
    L3:
        if (r11 >= r10) goto L14;
        View r17 = getChildAt(r11);
        if (r17.getVisibility() == 8) goto L13;
        c r18 = (c) r17.getLayoutParams();
        if (r18.j(0) == false) goto L13;
        Behavior r19 = r18.f();
        if (r19 == null) goto L13;
        r16 = r16 | r19.onNestedFling(this, r17, r12, r13, r14, r15);
    L13:
        r11 = r11 + 1;
        goto L3
    L14:
        if (r16 == false) goto L16;
        onChildViewsChanged(1);
    L16:
        return r16;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(View r11, float r12, float r13) {
        int r10 = getChildCount();
        int r14 = 0;
        boolean r15 = false;
    L3:
        if (r14 >= r10) goto L14;
        View r16 = getChildAt(r14);
        if (r16.getVisibility() == 8) goto L13;
        c r17 = (c) r16.getLayoutParams();
        if (r17.j(0) == false) goto L13;
        Behavior r18 = r17.f();
        if (r18 == null) goto L13;
        r15 = r15 | r18.onNestedPreFling(this, r16, r11, r12, r13);
    L13:
        r14 = r14 + 1;
        goto L3
    L14:
        return r15;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View r10, int r11, int r12, int[] r13) {
        onNestedPreScroll(r10, r11, r12, r13, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(View r10, int r11, int r12, int r13, int r14) {
        onNestedScroll(r10, r11, r12, r13, r14, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(View r10, View r11, int r12) {
        onNestedScrollAccepted(r10, r11, r12, 0);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        super.onRestoreInstanceState(r11.getSuperState());
        SparseArray<Parcelable> r12 = r11.behaviorStates;
        int r13 = getChildCount();
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L15;
        View r15 = getChildAt(r14);
        int r16 = r15.getId();
        Behavior r17 = getResolvedLayoutParams(r15).f();
        if (r16 == (-1)) goto L14;
        if (r17 == null) goto L14;
        Parcelable r18 = r12.get(r16);
        if (r18 == null) goto L14;
        r17.onRestoreInstanceState(this, r15, r18);
    L14:
        r14 = r14 + 1;
        goto L7
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> r11 = new SparseArray();
        int r12 = getChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L11;
        View r14 = getChildAt(r13);
        int r15 = r14.getId();
        Behavior r16 = ((c) r14.getLayoutParams()).f();
        if (r15 == (-1)) goto L10;
        if (r16 == null) goto L10;
        Parcelable r17 = r16.onSaveInstanceState(this, r14);
        if (r17 == null) goto L10;
        r11.append(r15, r17);
    L10:
        r13 = r13 + 1;
        goto L3
    L11:
        r10.behaviorStates = r11;
        return r10;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(View r10, View r11, int r12) {
        return onStartNestedScroll(r10, r11, r12, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(View r10) {
        onStopNestedScroll(r10, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        int r11 = r10.getActionMasked();
        View r12 = this.mBehaviorTouchView;
        boolean r13 = false;
        if (r12 == null) goto L8;
        Behavior r14 = ((c) r12.getLayoutParams()).f();
        if (r14 == null) goto L7;
        boolean r15 = r14.onTouchEvent(this, this.mBehaviorTouchView, r10);
    L13:
        if (this.mBehaviorTouchView == null) goto L18;
        if (r11 == 3) goto L18;
        if (r13 == false) goto L19;
        MotionEvent r16 = m(r10);
        super.onTouchEvent(r16);
        r16.recycle();
    L19:
        if (r11 == 1) goto L21;
        if (r11 == 3) goto L21;
    L22:
        return r15;
    L21:
        this.mBehaviorTouchView = null;
        s();
    L18:
        r15 = r15 | super.onTouchEvent(r10);
        goto L19
    L7:
        r15 = false;
        goto L13
    L8:
        r15 = p(r10, 1);
        if (r11 == 0) goto L13;
        if (r15 == false) goto L13;
        r13 = true;
        goto L13
    }

    public final boolean p(MotionEvent r14, int r15) {
        int r10 = r14.getActionMasked();
        List<View> r11 = this.mTempList1;
        h(r11);
        int r12 = r11.size();
        MotionEvent r13 = null;
        int r16 = 0;
        boolean r17 = false;
        boolean r18 = false;
    L3:
        if (r16 >= r12) goto L38;
        View r19 = r11.get(r16);
        c r20 = (c) r19.getLayoutParams();
        Behavior r110 = r20.f();
        if (r17 == true) goto L7;
        if (r18 == true) goto L7;
    L13:
        if (r18 == true) goto L29;
        if (r17 == true) goto L29;
        if (r110 == null) goto L29;
        r17 = o(r110, r19, r14, r15);
        if (r17 == false) goto L29;
        this.mBehaviorTouchView = r19;
        if (r10 == 3) goto L29;
        if (r10 == 1) goto L29;
        int r21 = 0;
    L22:
        if (r21 >= r16) goto L29;
        View r111 = r11.get(r21);
        Behavior r112 = ((c) r111.getLayoutParams()).f();
        if (r112 == null) goto L28;
        if (r13 != null) goto L27;
        r13 = m(r14);
    L27:
        o(r112, r111, r13, r15);
    L28:
        r21 = r21 + 1;
    L29:
        boolean r22 = r20.c();
        boolean r23 = r20.i(this, r19);
        if (r23 == false) goto L33;
        if (r22 == true) goto L33;
        r18 = true;
    L34:
        if (r23 == false) goto L37;
        if (r18 == false) goto L38;
    L37:
        r16 = r16 + 1;
    L33:
        r18 = false;
    L7:
        if (r10 == 0) goto L13;
        if (r110 == null) goto L37;
        if (r13 != null) goto L11;
        r13 = m(r14);
    L11:
        o(r110, r19, r13, r15);
    L38:
        r11.clear();
        if (r13 == null) goto L41;
        r13.recycle();
    L41:
        return r17;
    }

    public final void q() {
        this.mDependencySortedChildren.clear();
        this.mChildDag.c();
        int r10 = getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L16;
        View r12 = getChildAt(r11);
        c r13 = getResolvedLayoutParams(r12);
        r13.d(this, r12);
        this.mChildDag.b(r12);
        int r14 = 0;
    L5:
        if (r14 >= r10) goto L15;
        if (r14 == r11) goto L14;
        View r15 = getChildAt(r14);
        if (r13.b(this, r12, r15) == false) goto L14;
        if (this.mChildDag.d(r15) == true) goto L13;
        this.mChildDag.b(r15);
    L13:
        this.mChildDag.a(r15, r12);
    L14:
        r14 = r14 + 1;
        goto L5
    L15:
        r11 = r11 + 1;
        goto L3
    L16:
        this.mDependencySortedChildren.addAll(this.mChildDag.j());
        Collections.reverse(this.mDependencySortedChildren);
    }

    public void recordLastChildRect(View r10, Rect r11) {
        ((c) r10.getLayoutParams()).q(r11);
    }

    public void removePreDrawListener() {
        if (this.mIsAttachedToWindow == true) goto L5;
    L7:
        this.mNeedsPreDrawListener = false;
        return;
    L5:
        if (this.mOnPreDrawListener == null) goto L7;
        getViewTreeObserver().removeOnPreDrawListener(this.mOnPreDrawListener);
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View r10, Rect r11, boolean r12) {
        Behavior r13 = ((c) r10.getLayoutParams()).f();
        if (r13 == null) goto L9;
        if (r13.onRequestChildRectangleOnScreen(this, r10, r11, r12) == false) goto L9;
        return true;
    L9:
        return super.requestChildRectangleOnScreen(r10, r11, r12);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r10) {
        super.requestDisallowInterceptTouchEvent(r10);
        if (r10 == true) goto L5;
        return;
    L5:
        if (this.mDisallowInterceptReset == false) goto L7;
        return;
    L7:
        if (this.mBehaviorTouchView != null) goto L9;
        b();
    L9:
        s();
        this.mDisallowInterceptReset = true;
    }

    public final void s() {
        View r10 = this.mBehaviorTouchView;
        if (r10 == null) goto L8;
        Behavior r11 = ((c) r10.getLayoutParams()).f();
        if (r11 == null) goto L7;
        long r12 = SystemClock.uptimeMillis();
        MotionEvent r13 = MotionEvent.obtain(r12, r12, 3, 0.0f, 0.0f, 0);
        r11.onTouchEvent(this, this.mBehaviorTouchView, r13);
        r13.recycle();
    L7:
        this.mBehaviorTouchView = null;
    L8:
        int r14 = getChildCount();
        int r15 = 0;
    L9:
        if (r15 >= r14) goto L11;
        ((c) getChildAt(r15).getLayoutParams()).m();
        r15 = r15 + 1;
        goto L9
    L11:
        this.mDisallowInterceptReset = false;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean r10) {
        super.setFitsSystemWindows(r10);
        y();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener r10) {
        this.mOnHierarchyChangeListener = r10;
    }

    public void setStatusBarBackground(@Nullable Drawable r10) {
        Drawable r11 = this.mStatusBarBackground;
        if (r11 == r10) goto L21;
        Drawable r12 = null;
        if (r11 == null) goto L7;
        r11.setCallback(null);
    L7:
        if (r10 == null) goto L9;
        r12 = r10.mutate();
    L9:
        this.mStatusBarBackground = r12;
        if (r12 != null) goto L12;
    L19:
        ViewCompat.g0(this);
        return;
    L12:
        if (r12.isStateful() == false) goto L14;
        this.mStatusBarBackground.setState(getDrawableState());
    L14:
        o.a.g(this.mStatusBarBackground, ViewCompat.A(this));
        Drawable r13 = this.mStatusBarBackground;
        if (getVisibility() != 0) goto L17;
        boolean r14 = true;
    L18:
        r13.setVisible(r14, false);
        this.mStatusBarBackground.setCallback(this);
        goto L19
    L17:
        r14 = false;
        goto L18
    }

    public void setStatusBarBackgroundColor(@ColorInt int r10) {
        setStatusBarBackground(new ColorDrawable(r10));
    }

    public void setStatusBarBackgroundResource(@DrawableRes int r10) {
        if (r10 == 0) goto L4;
        Drawable r11 = ContextCompat.d(getContext(), r10);
    L5:
        setStatusBarBackground(r11);
        return;
    L4:
        r11 = null;
        goto L5
    }

    @Override // android.view.View
    public void setVisibility(int r10) {
        super.setVisibility(r10);
        if (r10 != 0) goto L5;
        boolean r11 = true;
    L6:
        Drawable r12 = this.mStatusBarBackground;
        if (r12 != null) goto L9;
        return;
    L9:
        if (r12.isVisible() == r11) goto L13;
        this.mStatusBarBackground.setVisible(r11, false);
        return;
    L13:
        return;
    L5:
        r11 = false;
        goto L6
    }

    public final WindowInsetsCompat setWindowInsets(WindowInsetsCompat r10) {
        if (androidx.core.util.b.a(this.mLastInsets, r10) == true) goto L17;
        this.mLastInsets = r10;
        boolean r11 = false;
        if (r10 != null) goto L7;
    L9:
        boolean r12 = false;
    L10:
        this.mDrawStatusBarBackground = r12;
        if (r12 == false) goto L13;
    L15:
        setWillNotDraw(r11);
        WindowInsetsCompat r13 = e(r10);
        requestLayout();
        return r13;
    L13:
        if (getBackground() != null) goto L15;
        r11 = true;
        goto L15
    L7:
        if (r10.m() <= 0) goto L9;
        r12 = true;
        goto L10
    L17:
        return r10;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable r10) {
        if (super.verifyDrawable(r10) == false) goto L5;
    L8:
        return true;
    L5:
        if (r10 == this.mStatusBarBackground) goto L8;
        return false;
    }

    public final void w(View r10, int r11) {
        c r12 = (c) r10.getLayoutParams();
        int r13 = r12.f2415i;
        if (r13 == r11) goto L6;
        ViewCompat.Z(r10, r11 - r13);
        r12.f2415i = r11;
        return;
    }

    public final void x(View r10, int r11) {
        c r12 = (c) r10.getLayoutParams();
        int r13 = r12.f2416j;
        if (r13 == r11) goto L6;
        ViewCompat.a0(r10, r11 - r13);
        r12.f2416j = r11;
        return;
    }

    public final void y() {
        if (ViewCompat.x(this) == true) goto L5;
        ViewCompat.C0(this, null);
        return;
    L5:
        if (this.mApplyWindowInsetsListener != null) goto L7;
        this.mApplyWindowInsetsListener = new a(this);
    L7:
        ViewCompat.C0(this, this.mApplyWindowInsetsListener);
        setSystemUiVisibility(1280);
    }

    public CoordinatorLayout(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R$attr.coordinatorLayoutStyle);
    }

    @Override // android.view.ViewGroup
    public c generateDefaultLayoutParams() {
        return new c(-2, -2);
    }

    @Override // android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        return generateLayoutParams(r10);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View r17, int r18, int r19, int[] r20, int r21) {
        int r10 = getChildCount();
        boolean r11 = false;
        int r12 = 0;
        int r13 = 0;
        int r14 = 0;
    L4:
        if (r12 >= r10) goto L24;
        View r15 = getChildAt(r12);
        if (r15.getVisibility() == 8) goto L23;
        c r16 = (c) r15.getLayoutParams();
        if (r16.j(r21) == false) goto L23;
        Behavior r22 = r16.f();
        if (r22 == null) goto L23;
        int[] r23 = this.mBehaviorConsumed;
        r23[0] = 0;
        r23[1] = 0;
        r22.onNestedPreScroll(this, r15, r17, r18, r19, r23, r21);
        if (r18 <= 0) goto L17;
        int r24 = Math.max(r13, this.mBehaviorConsumed[0]);
    L16:
        r13 = r24;
        if (r19 <= 0) goto L21;
        int r25 = Math.max(r14, this.mBehaviorConsumed[1]);
    L20:
        r14 = r25;
        r11 = true;
        goto L23
    L21:
        r25 = Math.min(r14, this.mBehaviorConsumed[1]);
        goto L20
    L17:
        r24 = Math.min(r13, this.mBehaviorConsumed[0]);
    L23:
        r12 = r12 + 1;
        goto L4
    L24:
        r20[0] = r13;
        r20[1] = r14;
        if (r11 == false) goto L33;
        onChildViewsChanged(1);
        return;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View r10, int r11, int r12, int r13, int r14, int r15) {
        onNestedScroll(r10, r11, r12, r13, r14, 0, this.mNestedScrollingV2ConsumedCompat);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View r10, View r11, int r12, int r13) {
        this.mNestedScrollingParentHelper.c(r10, r11, r12, r13);
        this.mNestedScrollingTarget = r11;
        int r14 = getChildCount();
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L11;
        View r16 = getChildAt(r15);
        c r17 = (c) r16.getLayoutParams();
        if (r17.j(r13) == false) goto L10;
        Behavior r18 = r17.f();
        if (r18 == null) goto L10;
        r18.onNestedScrollAccepted(this, r16, r10, r11, r12, r13);
    L10:
        r15 = r15 + 1;
        goto L3
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View r15, View r16, int r17, int r18) {
        int r10 = getChildCount();
        int r11 = 0;
        boolean r12 = false;
    L3:
        if (r11 >= r10) goto L12;
        View r13 = getChildAt(r11);
        if (r13.getVisibility() == 8) goto L11;
        c r14 = (c) r13.getLayoutParams();
        Behavior r19 = r14.f();
        if (r19 == null) goto L10;
        boolean r20 = r19.onStartNestedScroll(this, r13, r15, r16, r17, r18);
        r12 = r12 | r20;
        r14.r(r18, r20);
        goto L11
    L10:
        r14.r(r18, false);
    L11:
        r11 = r11 + 1;
        goto L3
    L12:
        return r12;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View r10, int r11) {
        this.mNestedScrollingParentHelper.e(r10, r11);
        int r12 = getChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L12;
        View r14 = getChildAt(r13);
        c r15 = (c) r14.getLayoutParams();
        if (r15.j(r11) == false) goto L11;
        Behavior r16 = r15.f();
        if (r16 == null) goto L10;
        r16.onStopNestedScroll(this, r14, r10, r11);
    L10:
        r15.l(r11);
        r15.k();
    L11:
        r13 = r13 + 1;
        goto L3
    L12:
        this.mNestedScrollingTarget = null;
    }

    public CoordinatorLayout(@NonNull Context r10, @Nullable AttributeSet r11, @AttrRes int r12) {
        super(r10, r11, r12);
        this.mDependencySortedChildren = new ArrayList();
        this.mChildDag = new androidx.coordinatorlayout.widget.a();
        this.mTempList1 = new ArrayList();
        this.mBehaviorConsumed = new int[2];
        this.mNestedScrollingV2ConsumedCompat = new int[2];
        this.mNestedScrollingParentHelper = new i(this);
        int r13 = 0;
        if (r12 != 0) goto L5;
        TypedArray r14 = r10.obtainStyledAttributes(r11, R$styleable.CoordinatorLayout, 0, R$style.Widget_Support_CoordinatorLayout);
    L6:
        if (r12 != 0) goto L8;
        ViewCompat.n0(this, r10, R$styleable.CoordinatorLayout, r11, r14, 0, R$style.Widget_Support_CoordinatorLayout);
    L9:
        int r15 = r14.getResourceId(R$styleable.CoordinatorLayout_keylines, 0);
        if (r15 == 0) goto L14;
        Resources r16 = r10.getResources();
        this.mKeylines = r16.getIntArray(r15);
        float r17 = r16.getDisplayMetrics().density;
        int r18 = this.mKeylines.length;
    L12:
        if (r13 >= r18) goto L14;
        int[] r19 = this.mKeylines;
        r19[r13] = (int) (r19[r13] * r17);
        r13 = r13 + 1;
    L14:
        this.mStatusBarBackground = r14.getDrawable(R$styleable.CoordinatorLayout_statusBarBackground);
        r14.recycle();
        y();
        super.setOnHierarchyChangeListener(new b(this));
        if (ViewCompat.y(this) != 0) goto L19;
        ViewCompat.A0(this, 1);
        return;
    L19:
        return;
    L8:
        ViewCompat.n0(this, r10, R$styleable.CoordinatorLayout, r11, r14, r12, 0);
        goto L9
    L5:
        r14 = r10.obtainStyledAttributes(r11, R$styleable.CoordinatorLayout, r12, 0);
        goto L6
    }

    @Override // android.view.ViewGroup
    public c generateLayoutParams(AttributeSet r10) {
        return new c(getContext(), r10);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View r18, int r19, int r20, int r21, int r22, int r23, @NonNull int[] r24) {
        int r11 = getChildCount();
        boolean r10 = false;
        int r13 = 0;
        int r14 = 0;
        int r15 = 0;
    L4:
        if (r13 >= r11) goto L24;
        View r12 = getChildAt(r13);
        if (r12.getVisibility() == 8) goto L23;
        c r16 = (c) r12.getLayoutParams();
        if (r16.j(r23) == false) goto L23;
        Behavior r17 = r16.f();
        if (r17 == null) goto L23;
        int[] r25 = this.mBehaviorConsumed;
        r25[0] = 0;
        r25[1] = 0;
        r17.onNestedScroll(this, r12, r18, r19, r20, r21, r22, r23, r25);
        if (r21 <= 0) goto L17;
        int r26 = Math.max(r14, this.mBehaviorConsumed[0]);
    L16:
        r14 = r26;
        if (r22 <= 0) goto L21;
        boolean r27 = true;
        int r28 = Math.max(r15, this.mBehaviorConsumed[1]);
    L20:
        r15 = r28;
        r10 = r27;
        goto L23
    L21:
        r27 = true;
        r28 = Math.min(r15, this.mBehaviorConsumed[1]);
        goto L20
    L17:
        r26 = Math.min(r14, this.mBehaviorConsumed[0]);
    L23:
        r13 = r13 + 1;
        goto L4
    L24:
        r24[0] = r24[0] + r14;
        r24[1] = r24[1] + r15;
        if (r10 == false) goto L33;
        onChildViewsChanged(1);
        return;
    }

    @Override // android.view.ViewGroup
    public c generateLayoutParams(ViewGroup.LayoutParams r10) {
        if ((r10 instanceof c) == false) goto L7;
        return new c((c) r10);
    L7:
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        return new c((ViewGroup.MarginLayoutParams) r10);
    L11:
        return new c(r10);
    }
}
