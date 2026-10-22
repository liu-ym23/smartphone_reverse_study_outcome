package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.capabilitykit.common.UiType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements androidx.core.view.m, androidx.core.view.n {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = false;
    static final boolean ALLOW_THREAD_GAP_WORK = false;
    static final boolean DEBUG = false;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = false;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = null;
    static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS = null;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION = false;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    static final String TAG = "RecyclerView";
    public static final int TOUCH_SLOP_DEFAULT = 0;
    public static final int TOUCH_SLOP_PAGING = 1;
    static final String TRACE_BIND_VIEW_TAG = "RV OnBindView";
    static final String TRACE_CREATE_VIEW_TAG = "RV CreateView";
    private static final String TRACE_HANDLE_ADAPTER_UPDATES_TAG = "RV PartialInvalidate";
    static final String TRACE_NESTED_PREFETCH_TAG = "RV Nested Prefetch";
    private static final String TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG = "RV FullInvalidate";
    private static final String TRACE_ON_LAYOUT_TAG = "RV OnLayout";
    static final String TRACE_PREFETCH_TAG = "RV Prefetch";
    static final String TRACE_SCROLL_TAG = "RV Scroll";
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    static final boolean VERBOSE_TRACING = false;
    public static final int VERTICAL = 1;
    static final Interpolator sQuinticInterpolator = null;
    w mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    a mAdapter;
    androidx.recyclerview.widget.a mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private c mChildDrawingOrderCallback;
    androidx.recyclerview.widget.f mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private d mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    androidx.recyclerview.widget.l mGapWorker;
    boolean mHasFixedSize;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private k mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    e mItemAnimator;
    private e.b mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<g> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastAutoMeasureNonExactMeasuredHeight;
    private int mLastAutoMeasureNonExactMeasuredWidth;
    private boolean mLastAutoMeasureSkippedDueToExact;
    private int mLastTouchX;
    private int mLastTouchY;
    h mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final p mObserver;
    private List<i> mOnChildAttachStateListeners;
    private j mOnFlingListener;
    private final ArrayList<k> mOnItemTouchListeners;
    final List<u> mPendingAccessibilityImportanceChange;
    SavedState mPendingSavedState;
    boolean mPostedAnimatorRunner;
    androidx.recyclerview.widget.l.a mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final n mRecycler;
    o mRecyclerListener;
    final List<o> mRecyclerListeners;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private l mScrollListener;
    private List<l> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private androidx.core.view.o mScrollingChildHelper;
    final r mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final t mViewFlinger;
    private final ac.b mViewInfoProcessCallback;
    final ac mViewInfoStore;

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$7, reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2329a = null;

        static {
            int[] r0 = new int[a.EnumC0069a.values().length];
            f2329a = r0;
            r0[a.EnumC0069a.f2335c.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f2329a[a.EnumC0069a.f2334b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    static class AdapterDataObservable extends Observable<b> {
        AdapterDataObservable() {
        }

        public boolean hasObservers() {
            return !this.mObservers.isEmpty();
        }

        public void notifyChanged() {
            int r0 = this.mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            ((b) ZeusTransformUtils.preCheckCast(this.mObservers.get(r0), b.class, "com.obric.aiagent.plugin")).a();
            r0 = r0 - 1;
            goto L3
        }

        public void notifyStateRestorationPolicyChanged() {
            int r0 = this.mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            ((b) ZeusTransformUtils.preCheckCast(this.mObservers.get(r0), b.class, "com.obric.aiagent.plugin")).b();
            r0 = r0 - 1;
            goto L3
        }

        public void notifyItemRangeChanged(int r2, int r3) {
            notifyItemRangeChanged(r2, r3, null);
        }

        public void notifyItemRangeChanged(int r5, int r6, Object r7) {
            int r0 = this.mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            ((b) ZeusTransformUtils.preCheckCast(this.mObservers.get(r0), b.class, "com.obric.aiagent.plugin")).a(r5, r6, r7);
            r0 = r0 - 1;
            goto L3
        }

        public void notifyItemRangeInserted(int r5, int r6) {
            int r0 = this.mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            ((b) ZeusTransformUtils.preCheckCast(this.mObservers.get(r0), b.class, "com.obric.aiagent.plugin")).b(r5, r6);
            r0 = r0 - 1;
            goto L3
        }

        public void notifyItemRangeRemoved(int r5, int r6) {
            int r0 = this.mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            ((b) ZeusTransformUtils.preCheckCast(this.mObservers.get(r0), b.class, "com.obric.aiagent.plugin")).c(r5, r6);
            r0 = r0 - 1;
            goto L3
        }

        public void notifyItemMoved(int r6, int r7) {
            int r0 = this.mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            ((b) ZeusTransformUtils.preCheckCast(this.mObservers.get(r0), b.class, "com.obric.aiagent.plugin")).a(r6, r7, 1);
            r0 = r0 - 1;
            goto L3
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        final Rect mDecorInsets;
        boolean mInsetsDirty;
        boolean mPendingInvalidate;
        u mViewHolder;

        public LayoutParams(Context r3, AttributeSet r4) {
            super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"));
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(LayoutParams r1) {
            super(r1);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public boolean viewNeedsUpdate() {
            return this.mViewHolder.r();
        }

        public boolean isViewInvalid() {
            return this.mViewHolder.q();
        }

        public boolean isItemRemoved() {
            return this.mViewHolder.t();
        }

        public boolean isItemChanged() {
            return this.mViewHolder.D();
        }

        @Deprecated
        public int getViewPosition() {
            return this.mViewHolder.d();
        }

        public int getViewLayoutPosition() {
            return this.mViewHolder.e();
        }

        @Deprecated
        public int getViewAdapterPosition() {
            return this.mViewHolder.f();
        }

        public int getAbsoluteAdapterPosition() {
            return this.mViewHolder.g();
        }

        public int getBindingAdapterPosition() {
            return this.mViewHolder.f();
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Parcelable mLayoutState;

        SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            if (r2 != null) goto L6;
            r2 = h.class.getClassLoader();
        L6:
            this.mLayoutState = r1.readParcelable(r2);
        }

        SavedState(Parcelable r3) {
            super((Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin"));
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            super.writeToParcel(r1, r2);
            r1.writeParcelable(this.mLayoutState, 0);
        }

        void copyFrom(SavedState r1) {
            this.mLayoutState = r1.mLayoutState;
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    public static abstract class a<VH extends u> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AdapterDataObservable f2330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f2331b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private EnumC0069a f2332c;

        /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$a$a, reason: collision with other inner class name */
        public static final enum EnumC0069a extends Enum<EnumC0069a> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final EnumC0069a f2333a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final EnumC0069a f2334b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final EnumC0069a f2335c = null;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private static final /* synthetic */ EnumC0069a[] f2336d = null;

            private EnumC0069a(String r1, int r2) {
                super(r1, r2);
            }

            public static EnumC0069a valueOf(String r2) {
                return (EnumC0069a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0069a.class, r2), EnumC0069a.class, "com.obric.aiagent.plugin");
            }

            public static EnumC0069a[] values() {
                return (EnumC0069a[]) ZeusTransformUtils.preCheckCast(f2336d.clone(), EnumC0069a[].class, "com.obric.aiagent.plugin");
            }

            static {
                EnumC0069a r0 = new EnumC0069a("ALLOW", 0);
                f2333a = r0;
                EnumC0069a r1 = new EnumC0069a("PREVENT_WHEN_EMPTY", 1);
                f2334b = r1;
                EnumC0069a r3 = new EnumC0069a("PREVENT", 2);
                f2335c = r3;
                f2336d = new EnumC0069a[]{r0, r1, r3};
            }
        }

        public abstract int a();

        public int a(int r1) {
            return 0;
        }

        public int a(a<? extends u> r1, u r2, int r3) {
            if (r1 != this) goto L4;
            return r3;
        L4:
            return -1;
        }

        public abstract VH a(ViewGroup r1, int r2);

        public abstract void a(VH r1, int r2);

        public void a(RecyclerView r1) {
        }

        public boolean a(VH r1) {
            return false;
        }

        public long b(int r1) {
            return -1;
        }

        public void b(VH r1) {
        }

        public void b(RecyclerView r1) {
        }

        public void c(VH r1) {
        }

        public void d(VH r1) {
        }

        public a() {
            this.f2330a = new AdapterDataObservable();
            this.f2331b = false;
            this.f2332c = EnumC0069a.f2333a;
        }

        public void a(VH r3, int r4, List<Object> r5) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            a(r3, r4);
        }

        public final VH b(ViewGroup r2, int r3) {
            androidx.core.os.n.a(RecyclerView.TRACE_CREATE_VIEW_TAG);     // Catch: Throwable -> L9
            VH r1 = (VH) a(r2, r3);
            if (r1.f2390a.getParent() != null) goto L8;
            r1.f = r3;     // Catch: Throwable -> L9
            androidx.core.os.n.a();
            return r1;
        L8:
            throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            androidx.core.os.n.a();
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void b(VH r5, int r6) {
            if (r5.q != null) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L11;
            r5.f2392c = r6;
            if (b() == false) goto L10;
            r5.f2394e = b(r6);
        L10:
            r5.a(1, 519);
            androidx.core.os.n.a(RecyclerView.TRACE_BIND_VIEW_TAG);
        L11:
            r5.q = this;
            a(r5, r6, r5.y());
            if (r0 == false) goto L18;
            r5.x();
            ViewGroup.LayoutParams r4 = r5.f2390a.getLayoutParams();
            if (ZeusTransformUtils.instanceOf(r4, LayoutParams.class) == false) goto L16;
            ((LayoutParams) ZeusTransformUtils.preCheckCast(r4, LayoutParams.class, "com.obric.aiagent.plugin")).mInsetsDirty = true;
        L16:
            androidx.core.os.n.a();
            return;
        L18:
            return;
        L5:
            r0 = false;
            goto L6
        }

        public void a(boolean r2) {
            if (c() == true) goto L7;
            this.f2331b = r2;
            return;
        L7:
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public final boolean b() {
            return this.f2331b;
        }

        public final boolean c() {
            return this.f2330a.hasObservers();
        }

        public void a(b r1) {
            this.f2330a.registerObserver(r1);
        }

        public void b(b r1) {
            this.f2330a.unregisterObserver(r1);
        }

        public final void d() {
            this.f2330a.notifyChanged();
        }

        public final void d(int r2) {
            this.f2330a.notifyItemRangeChanged(r2, 1);
        }

        public final void a(int r1, int r2) {
            this.f2330a.notifyItemRangeChanged(r1, r2);
        }

        public final void a(int r1, int r2, Object r3) {
            this.f2330a.notifyItemRangeChanged(r1, r2, r3);
        }

        public final void b(int r1, int r2) {
            this.f2330a.notifyItemMoved(r1, r2);
        }

        public final void c(int r1, int r2) {
            this.f2330a.notifyItemRangeInserted(r1, r2);
        }

        public final void e(int r2) {
            this.f2330a.notifyItemRangeRemoved(r2, 1);
        }

        public final void d(int r1, int r2) {
            this.f2330a.notifyItemRangeRemoved(r1, r2);
        }

        public void a(EnumC0069a r1) {
            this.f2332c = r1;
            this.f2330a.notifyStateRestorationPolicyChanged();
        }

        public final EnumC0069a e() {
            return this.f2332c;
        }

        boolean f() {
            int r0 = AnonymousClass7.f2329a[this.f2332c.ordinal()];
            if (r0 != 1) goto L5;
            return false;
        L5:
            if (r0 == 2) goto L8;
            return true;
        L8:
            if (a() > 0) goto L10;
            return false;
        L10:
            return true;
        }
    }

    public static abstract class b {
        public void a() {
        }

        public void a(int r1, int r2) {
        }

        public void a(int r1, int r2, int r3) {
        }

        public void b() {
        }

        public void b(int r1, int r2) {
        }

        public void c(int r1, int r2) {
        }

        public b() {
        }

        public void a(int r1, int r2, Object r3) {
            a(r1, r2);
        }
    }

    public interface c {
        int a(int r1, int r2);
    }

    public static class d {
        public d() {
        }

        public EdgeEffect a(RecyclerView r2, int r3) {
            return new EdgeEffect((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        }
    }

    public static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private b f2337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ArrayList<a> f2338b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f2339c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f2340d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f2341e;
        private long f;

        public interface a {
            void a();
        }

        interface b {
            void a(u r1);
        }

        public static class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2342a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f2343b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f2344c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f2345d;

            public c() {
            }

            public c a(u r2) {
                return a(r2, 0);
            }

            public c a(u r1, int r2) {
                View r3 = r1.f2390a;
                this.f2342a = r3.getLeft();
                this.f2343b = r3.getTop();
                this.f2344c = r3.getRight();
                this.f2345d = r3.getBottom();
                return this;
            }
        }

        public abstract void a();

        public abstract boolean a(u r1, c r2, c r3);

        public abstract boolean a(u r1, u r2, c r3, c r4);

        public abstract boolean b();

        public abstract boolean b(u r1, c r2, c r3);

        public abstract boolean c(u r1, c r2, c r3);

        public abstract void d();

        public abstract void d(u r1);

        public void g(u r1) {
        }

        public boolean h(u r1) {
            return true;
        }

        public e() {
            this.f2337a = null;
            this.f2338b = new ArrayList();
            this.f2339c = 120;
            this.f2340d = 120;
            this.f2341e = 250;
            this.f = 250;
        }

        public long e() {
            return this.f2341e;
        }

        public long f() {
            return this.f2339c;
        }

        public long g() {
            return this.f2340d;
        }

        public long h() {
            return this.f;
        }

        void a(b r3) {
            this.f2337a = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        }

        public c a(r r1, u r2, int r3, List<Object> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            return j().a(r2);
        }

        public c a(r r1, u r2) {
            return j().a(r2);
        }

        static int e(u r3) {
            int r0 = r3.j & 14;
            if (r3.q() == false) goto L7;
            return 4;
        L7:
            if ((r0 & 4) != 0) goto L14;
            int r1 = r3.i();
            int r4 = r3.g();
            if (r1 == (-1)) goto L15;
            if (r4 == (-1)) goto L16;
            if (r1 != r4) goto L13;
            return r0;
        L13:
            return r0 | 2048;
        L16:
            return r0;
        L15:
            return r0;
        L14:
            return r0;
        }

        public final void f(u r1) {
            g(r1);
            b r0 = this.f2337a;
            if (r0 == null) goto L6;
            r0.a(r1);
            return;
        }

        public final boolean a(a r3) {
            a r4 = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
            boolean r0 = b();
            if (r4 == null) goto L7;
            if (r0 == true) goto L6;
            r4.a();
            goto L7
        L6:
            this.f2338b.add(r4);
        L7:
            return r0;
        }

        public boolean a(u r3, List<Object> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            return h(r3);
        }

        public final void i() {
            int r0 = this.f2338b.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            ((a) ZeusTransformUtils.preCheckCast(this.f2338b.get(r1), a.class, "com.obric.aiagent.plugin")).a();
            r1 = r1 + 1;
            goto L3
        L5:
            this.f2338b.clear();
        }

        public c j() {
            return new c();
        }
    }

    private class f implements e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView f2346a;

        f(RecyclerView r1) {
            this.f2346a = r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.e.b
        public void a(u r3) {
            r3.a(true);
            if (r3.h != null) goto L5;
        L7:
            r3.i = null;
            if (r3.B() == false) goto L10;
            return;
        L10:
            if (this.f2346a.removeAnimatingView(r3.f2390a) == false) goto L12;
            return;
        L12:
            if (r3.u() == false) goto L17;
            this.f2346a.removeDetachedView(r3.f2390a, false);
            return;
        L17:
            return;
        L5:
            if (r3.i != null) goto L7;
            r3.h = null;
            goto L7
        }
    }

    public static abstract class g {
        @Deprecated
        public void a(Canvas r1, RecyclerView r2) {
        }

        @Deprecated
        public void b(Canvas r1, RecyclerView r2) {
        }

        public g() {
        }

        public void a(Canvas r1, RecyclerView r2, r r3) {
            a(r1, r2);
        }

        public void b(Canvas r1, RecyclerView r2, r r3) {
            b(r1, r2);
        }

        @Deprecated
        public void a(Rect r1, int r2, RecyclerView r3) {
            r1.set(0, 0, 0, 0);
        }

        public void a(Rect r2, View r3, RecyclerView r4, r r5) {
            a(r2, ((LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).getViewLayoutPosition(), r4);
        }
    }

    public static abstract class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ab.b f2347a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ab.b f2348b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f2349c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f2350d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f2351e;
        private int f;
        private int g;
        private int h;
        androidx.recyclerview.widget.f p;
        RecyclerView q;
        ab r;
        ab s;
        q t;
        boolean u;
        boolean v;
        boolean w;
        int x;
        boolean y;

        public interface a {
            void b(int r1, int r2);
        }

        public static class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f2354a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f2355b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f2356c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f2357d;

            public b() {
            }
        }

        public int a(int r1, n r2, r r3) {
            return 0;
        }

        public int a(n r1, r r2) {
            return -1;
        }

        public View a(View r1, int r2, n r3, r r4) {
            return null;
        }

        public abstract LayoutParams a();

        public void a(int r1, int r2, r r3, a r4) {
            a r0 = (a) ZeusTransformUtils.wrapperContextForParams(r4, a.class, "com.obric.aiagent.plugin");
        }

        public void a(int r1, a r2) {
            a r0 = (a) ZeusTransformUtils.wrapperContextForParams(r2, a.class, "com.obric.aiagent.plugin");
        }

        public void a(Parcelable r2) {
            Parcelable r1 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r2, Parcelable.class, "com.obric.aiagent.plugin");
        }

        public void a(a r1, a r2) {
        }

        public void a(n r1, r r2, View r3, androidx.core.view.accessibility.b r4) {
        }

        public void a(r r1) {
        }

        public void a(RecyclerView r1) {
        }

        public void a(RecyclerView r1, int r2, int r3) {
        }

        public void a(RecyclerView r1, int r2, int r3, int r4) {
        }

        public boolean a(LayoutParams r1) {
            if (r1 == null) goto L4;
            return true;
        L4:
            return false;
        }

        public boolean a(n r1, r r2, View r3, int r4, Bundle r5) {
            return false;
        }

        public boolean a(RecyclerView r1, ArrayList<View> r2, int r3, int r4) {
            return false;
        }

        public int b(int r1, n r2, r r3) {
            return 0;
        }

        public int b(n r1, r r2) {
            return -1;
        }

        public int b(r r1) {
            return 0;
        }

        public void b(RecyclerView r1, int r2, int r3) {
        }

        public int c(r r1) {
            return 0;
        }

        public void c(RecyclerView r1, int r2, int r3) {
        }

        public boolean c() {
            return false;
        }

        public int d(n r1, r r2) {
            return 0;
        }

        public int d(r r1) {
            return 0;
        }

        public View d(View r1, int r2) {
            return null;
        }

        public void d(RecyclerView r1) {
        }

        public int e(r r1) {
            return 0;
        }

        public Parcelable e() {
            return null;
        }

        public void e(int r1) {
        }

        @Deprecated
        public void e(RecyclerView r1) {
        }

        public boolean e(n r1, r r2) {
            return false;
        }

        public boolean f() {
            return false;
        }

        public int g(r r1) {
            return 0;
        }

        public boolean g() {
            return false;
        }

        public int h(r r1) {
            return 0;
        }

        public void l(int r1) {
        }

        boolean n() {
            return false;
        }

        public int w() {
            return -1;
        }

        public h() {
            ab.b r0 = new AnonymousClass1(this);
            this.f2347a = r0;
            ab.b r1 = new AnonymousClass2(this);
            this.f2348b = r1;
            this.r = new ab(r0);
            this.s = new ab(r1);
            this.u = false;
            this.v = false;
            this.w = false;
            this.f2349c = true;
            this.f2350d = true;
        }

        void b(RecyclerView r2) {
            if (r2 != null) goto L4;
            this.q = null;
            this.p = null;
            this.g = 0;
            this.h = 0;
        L5:
            this.f2351e = 1073741824;
            this.f = 1073741824;
            return;
        L4:
            this.q = r2;
            this.p = r2.mChildHelper;
            this.g = r2.getWidth();
            this.h = r2.getHeight();
            goto L5
        }

        void c(int r2, int r3) {
            this.g = View.MeasureSpec.getSize(r2);
            int r4 = View.MeasureSpec.getMode(r2);
            this.f2351e = r4;
            if (r4 == 0) goto L5;
        L7:
            this.h = View.MeasureSpec.getSize(r3);
            int r5 = View.MeasureSpec.getMode(r3);
            this.f = r5;
            if (r5 == 0) goto L10;
            return;
        L10:
            if (RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC == true) goto L14;
            this.h = 0;
            return;
        L14:
            return;
        L5:
            if (RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC == true) goto L7;
            this.g = 0;
            goto L7
        }

        void d(int r9, int r10) {
            int r0 = x();
            if (r0 != 0) goto L6;
            this.q.defaultOnMeasure(r9, r10);
            return;
        L6:
            int r1 = 0;
            int r2 = Integer.MIN_VALUE;
            int r4 = Integer.MAX_VALUE;
            int r5 = Integer.MAX_VALUE;
            int r3 = Integer.MIN_VALUE;
        L7:
            if (r1 >= r0) goto L21;
            View r6 = i(r1);
            Rect r7 = this.q.mTempRect;
            a(r6, r7);
            if (r7.left >= r4) goto L12;
            r4 = r7.left;
        L12:
            if (r7.right <= r2) goto L15;
            r2 = r7.right;
        L15:
            if (r7.top >= r5) goto L18;
            r5 = r7.top;
        L18:
            if (r7.bottom <= r3) goto L20;
            r3 = r7.bottom;
        L20:
            r1 = r1 + 1;
            goto L7
        L21:
            this.q.mTempRect.set(r4, r5, r2, r3);
            a(this.q.mTempRect, r9, r10);
        }

        public void a(Rect r3, int r4, int r5) {
            int r0 = (r3.width() + C()) + E();
            int r6 = (r3.height() + D()) + F();
            f(a(r4, r0, I()), a(r5, r6, J()));
        }

        public void q() {
            RecyclerView r0 = this.q;
            if (r0 == null) goto L6;
            r0.requestLayout();
            return;
        }

        public static int a(int r2, int r3, int r4) {
            int r0 = View.MeasureSpec.getMode(r2);
            int r5 = View.MeasureSpec.getSize(r2);
            if (r0 == Integer.MIN_VALUE) goto L9;
            if (r0 != 1073741824) goto L7;
            return r5;
        L7:
            return Math.max(r3, r4);
        L9:
            return Math.min(r5, Math.max(r3, r4));
        }

        public void a(String r1) {
            RecyclerView r0 = this.q;
            if (r0 == null) goto L6;
            r0.assertNotInLayoutOrScroll(r1);
            return;
        }

        public boolean d() {
            return this.w;
        }

        public final boolean r() {
            return this.f2350d;
        }

        void c(RecyclerView r2) {
            this.v = true;
            d(r2);
        }

        void b(RecyclerView r2, n r3) {
            this.v = false;
            a(r2, r3);
        }

        public boolean s() {
            return this.v;
        }

        public boolean a(Runnable r3) {
            Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
            RecyclerView r2 = this.q;
            if (r2 != null) goto L5;
            return false;
        L5:
            return r2.removeCallbacks(r4);
        }

        public void a(RecyclerView r1, n r2) {
            e(r1);
        }

        public boolean t() {
            RecyclerView r0 = this.q;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.mClipToPadding == false) goto L7;
            return true;
        }

        public void c(n r1, r r2) {
            b(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public LayoutParams a(ViewGroup.LayoutParams r3) {
            if (ZeusTransformUtils.instanceOf(r3, LayoutParams.class) == false) goto L7;
            return new LayoutParams((LayoutParams) ZeusTransformUtils.preCheckCast(r3, LayoutParams.class, "com.obric.aiagent.plugin"));
        L7:
            if (ZeusTransformUtils.instanceOf(r3, ViewGroup.MarginLayoutParams.class) == false) goto L11;
            return new LayoutParams((ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r3, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin"));
        L11:
            return new LayoutParams(r3);
        }

        public LayoutParams a(Context r2, AttributeSet r3) {
            return new LayoutParams((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
        }

        public void a(RecyclerView r1, r r2, int r3) {
            b(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void a(q r2) {
            q r0 = this.t;
            if (r0 == null) goto L8;
            if (r2 == r0) goto L8;
            if (r0.h() == false) goto L8;
            this.t.f();
        L8:
            this.t = r2;
            r2.a(this.q, this);
        }

        public boolean u() {
            q r0 = this.t;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.h() == false) goto L7;
            return true;
        }

        public int v() {
            return ViewCompat.i(this.q);
        }

        public void a(View r2) {
            a(r2, -1);
        }

        public void a(View r2, int r3) {
            a(r2, r3, true);
        }

        public void b(View r2) {
            b(r2, -1);
        }

        public void b(View r2, int r3) {
            a(r2, r3, false);
        }

        private void a(View r5, int r6, boolean r7) {
            u r0 = RecyclerView.getChildViewHolderInt(r5);
            if (r7 == false) goto L5;
        L8:
            this.q.mViewInfoStore.e(r0);
        L9:
            LayoutParams r8 = (LayoutParams) ZeusTransformUtils.preCheckCast(r5.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
            if (r0.n() == true) goto L30;
            if (r0.l() == true) goto L30;
            if (r5.getParent() != this.q) goto L24;
            int r1 = this.p.b(r5);
            if (r6 != (-1)) goto L19;
            r6 = this.p.b();
        L19:
            if (r1 == (-1)) goto L23;
            if (r1 == r6) goto L35;
            this.q.mLayout.e(r1, r6);
        L35:
            if (r8.mPendingInvalidate == false) goto L38;
            r0.f2390a.invalidate();
            r8.mPendingInvalidate = false;
            return;
        L38:
            return;
        L23:
            throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.q.indexOfChild(r5) + this.q.exceptionLabel());
        L24:
            this.p.a(r5, r6, false);
            r8.mInsetsDirty = true;
            q r9 = this.t;
            if (r9 == null) goto L35;
            if (r9.h() == false) goto L35;
            this.t.b(r5);
        L30:
            if (r0.l() == false) goto L32;
            r0.m();
        L33:
            this.p.a(r5, r6, r5.getLayoutParams(), false);
            goto L35
        L32:
            r0.o();
            goto L33
        L5:
            if (r0.t() == true) goto L8;
            this.q.mViewInfoStore.f(r0);
            goto L9
        }

        public void c(View r1) {
            this.p.a(r1);
        }

        public void g(int r2) {
            if (i(r2) == null) goto L6;
            this.p.a(r2);
            return;
        }

        public int d(View r2) {
            return ((LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).getViewLayoutPosition();
        }

        public View e(View r3) {
            RecyclerView r0 = this.q;
            if (r0 != null) goto L5;
            return null;
        L5:
            View r4 = r0.findContainingItemView(r3);
            if (r4 != null) goto L9;
            return null;
        L9:
            if (this.p.c(r4) == false) goto L11;
            return null;
        L11:
            return r4;
        }

        public View c(int r6) {
            int r0 = x();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L17;
            View r2 = i(r1);
            u r3 = RecyclerView.getChildViewHolderInt(r2);
            if (r3 == null) goto L16;
            if (r3.e() != r6) goto L16;
            if (r3.c() == true) goto L16;
            if (this.q.mState.a() == true) goto L15;
            if (r3.t() == true) goto L16;
        L15:
            return r2;
        L16:
            r1 = r1 + 1;
            goto L3
        L17:
            return null;
        }

        public void h(int r2) {
            a(r2, i(r2));
        }

        private void a(int r1, View r2) {
            this.p.e(r1);
        }

        public void a(View r3, int r4, LayoutParams r5) {
            u r0 = RecyclerView.getChildViewHolderInt(r3);
            if (r0.t() == false) goto L5;
            this.q.mViewInfoStore.e(r0);
        L6:
            this.p.a(r3, r4, r5, r0.t());
            return;
        L5:
            this.q.mViewInfoStore.f(r0);
            goto L6
        }

        public void c(View r4, int r5) {
            a(r4, r5, (LayoutParams) ZeusTransformUtils.preCheckCast(r4.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin"));
        }

        public void e(int r3, int r4) {
            View r0 = i(r3);
            if (r0 == null) goto L7;
            h(r3);
            c(r0, r4);
            return;
        L7:
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + r3 + this.q.toString());
        }

        public void a(View r1, n r2) {
            c(r1);
            r2.a(r1);
        }

        public void a(int r2, n r3) {
            View r0 = i(r2);
            g(r2);
            r3.a(r0);
        }

        public int x() {
            androidx.recyclerview.widget.f r0 = this.p;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.b();
        }

        public View i(int r1) {
            androidx.recyclerview.widget.f r0 = this.p;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.b(r1);
        }

        public int y() {
            return this.f2351e;
        }

        public int z() {
            return this.f;
        }

        public int A() {
            return this.g;
        }

        public int B() {
            return this.h;
        }

        public int C() {
            RecyclerView r0 = this.q;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getPaddingLeft();
        }

        public int D() {
            RecyclerView r0 = this.q;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getPaddingTop();
        }

        public int E() {
            RecyclerView r0 = this.q;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getPaddingRight();
        }

        public int F() {
            RecyclerView r0 = this.q;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getPaddingBottom();
        }

        public View G() {
            RecyclerView r0 = this.q;
            if (r0 != null) goto L5;
            return null;
        L5:
            View r1 = r0.getFocusedChild();
            if (r1 != null) goto L8;
        L11:
            return null;
        L8:
            if (this.p.c(r1) == true) goto L11;
            return r1;
        }

        public int H() {
            RecyclerView r0 = this.q;
            if (r0 == null) goto L5;
            a r1 = r0.getAdapter();
        L6:
            if (r1 != null) goto L10;
            return 0;
        L10:
            return r1.a();
        L5:
            r1 = null;
            goto L6
        }

        public void j(int r1) {
            RecyclerView r0 = this.q;
            if (r0 == null) goto L6;
            r0.offsetChildrenHorizontal(r1);
            return;
        }

        public void k(int r1) {
            RecyclerView r0 = this.q;
            if (r0 == null) goto L6;
            r0.offsetChildrenVertical(r1);
            return;
        }

        public void a(n r3) {
            int r0 = x() - 1;
        L3:
            if (r0 < 0) goto L5;
            a(r3, r0, i(r0));
            r0 = r0 - 1;
            goto L3
        }

        private void a(n r3, int r4, View r5) {
            u r0 = RecyclerView.getChildViewHolderInt(r5);
            if (r0.c() == false) goto L6;
            return;
        L6:
            if (r0.q() == true) goto L8;
        L12:
            h(r4);
            r3.c(r5);
            this.q.mViewInfoStore.h(r0);
            return;
        L8:
            if (r0.t() == true) goto L12;
            if (this.q.mAdapter.b() == true) goto L12;
            g(r4);
            r3.b(r0);
        }

        void b(n r7) {
            int r0 = r7.e();
            int r1 = r0 - 1;
        L3:
            if (r1 < 0) goto L15;
            View r2 = r7.e(r1);
            u r3 = RecyclerView.getChildViewHolderInt(r2);
            if (r3.c() == true) goto L14;
            r3.a(false);
            if (r3.u() == false) goto L11;
            this.q.removeDetachedView(r2, false);
        L11:
            if (this.q.mItemAnimator == null) goto L13;
            this.q.mItemAnimator.d(r3);
        L13:
            r3.a(true);
            r7.b(r2);
        L14:
            r1 = r1 - 1;
            goto L3
        L15:
            r7.f();
            if (r0 <= 0) goto L22;
            this.q.invalidate();
            return;
        }

        boolean a(View r2, int r3, int r4, LayoutParams r5) {
            if (this.f2349c == true) goto L5;
        L10:
            return true;
        L5:
            if (b(r2.getMeasuredWidth(), r3, r5.width) == false) goto L10;
            if (b(r2.getMeasuredHeight(), r4, r5.height) == false) goto L10;
            return false;
        }

        boolean b(View r2, int r3, int r4, LayoutParams r5) {
            if (r2.isLayoutRequested() == false) goto L5;
        L12:
            return true;
        L5:
            if (this.f2349c == false) goto L12;
            if (b(r2.getWidth(), r3, r5.width) == false) goto L12;
            if (b(r2.getHeight(), r4, r5.height) == false) goto L12;
            return false;
        }

        private static boolean b(int r3, int r4, int r5) {
            int r0 = View.MeasureSpec.getMode(r4);
            int r6 = View.MeasureSpec.getSize(r4);
            if (r5 <= 0) goto L7;
            if (r3 == r5) goto L7;
            return false;
        L7:
            if (r0 == Integer.MIN_VALUE) goto L16;
            if (r0 != 0) goto L10;
            return true;
        L10:
            if (r0 == 1073741824) goto L12;
            return false;
        L12:
            if (r6 == r3) goto L14;
            return false;
        L14:
            return true;
        L16:
            if (r6 >= r3) goto L18;
            return false;
        L18:
            return true;
        }

        public void a(View r6, int r7, int r8) {
            LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
            Rect r1 = this.q.getItemDecorInsetsForChild(r6);
            int r9 = r7 + (r1.left + r1.right);
            int r10 = r8 + (r1.top + r1.bottom);
            int r11 = a(A(), y(), (((C() + E()) + r0.leftMargin) + r0.rightMargin) + r9, r0.width, f());
            int r12 = a(B(), z(), (((D() + F()) + r0.topMargin) + r0.bottomMargin) + r10, r0.height, g());
            if (b(r6, r11, r12, r0) == false) goto L6;
            r6.measure(r11, r12);
            return;
        }

        public static int a(int r4, int r5, int r6, int r7, boolean r8) {
            int r9 = Math.max(0, r4 - r6);
            if (r8 == false) goto L11;
            if (r7 >= 0) goto L12;
            if (r7 != (-1)) goto L21;
            if (r5 == Integer.MIN_VALUE) goto L14;
            if (r5 == 0) goto L21;
            if (r5 != 1073741824) goto L21;
        L14:
            r7 = r9;
        L23:
            return View.MeasureSpec.makeMeasureSpec(r7, r5);
        L21:
            r5 = 0;
            r7 = 0;
        L12:
            r5 = 1073741824;
            goto L23
        L11:
            if (r7 >= 0) goto L12;
            if (r7 == (-1)) goto L14;
            if (r7 != (-2)) goto L21;
            if (r5 == Integer.MIN_VALUE) goto L20;
            if (r5 == 1073741824) goto L20;
            r7 = r9;
            r5 = 0;
        L20:
            r7 = r9;
            r5 = Integer.MIN_VALUE;
            goto L23
        }

        public int f(View r3) {
            Rect r2 = ((LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).mDecorInsets;
            return (r3.getMeasuredWidth() + r2.left) + r2.right;
        }

        public int g(View r3) {
            Rect r2 = ((LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).mDecorInsets;
            return (r3.getMeasuredHeight() + r2.top) + r2.bottom;
        }

        public void a(View r3, int r4, int r5, int r6, int r7) {
            LayoutParams r2 = (LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
            Rect r0 = r2.mDecorInsets;
            r3.layout((r4 + r0.left) + r2.leftMargin, (r5 + r0.top) + r2.topMargin, (r6 - r0.right) - r2.rightMargin, (r7 - r0.bottom) - r2.bottomMargin);
        }

        public void a(View r5, boolean r6, Rect r7) {
            if (r6 == false) goto L4;
            Rect r8 = ((LayoutParams) ZeusTransformUtils.preCheckCast(r5.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).mDecorInsets;
            r7.set(-r8.left, -r8.top, r5.getWidth() + r8.right, r5.getHeight() + r8.bottom);
        L6:
            if (this.q == null) goto L12;
            Matrix r9 = r5.getMatrix();
            if (r9 == null) goto L12;
            if (r9.isIdentity() == true) goto L12;
            RectF r4 = this.q.mTempRectF;
            r4.set(r7);
            r9.mapRect(r4);
            r7.set((int) Math.floor(r4.left), (int) Math.floor(r4.top), (int) Math.ceil(r4.right), (int) Math.ceil(r4.bottom));
        L12:
            r7.offset(r5.getLeft(), r5.getTop());
            return;
        L4:
            r7.set(0, 0, r5.getWidth(), r5.getHeight());
            goto L6
        }

        public void a(View r1, Rect r2) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(r1, r2);
        }

        public int h(View r2) {
            return r2.getLeft() - n(r2);
        }

        public int i(View r2) {
            return r2.getTop() - l(r2);
        }

        public int j(View r2) {
            return r2.getRight() + o(r2);
        }

        public int k(View r2) {
            return r2.getBottom() + m(r2);
        }

        public void b(View r1, Rect r2) {
            RecyclerView r0 = this.q;
            if (r0 != null) goto L6;
            r2.set(0, 0, 0, 0);
            return;
        L6:
            r2.set(r0.getItemDecorInsetsForChild(r1));
        }

        public int l(View r2) {
            return ((LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).mDecorInsets.top;
        }

        public int m(View r2) {
            return ((LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).mDecorInsets.bottom;
        }

        public int n(View r2) {
            return ((LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).mDecorInsets.left;
        }

        public int o(View r2) {
            return ((LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).mDecorInsets.right;
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int b(String r0, String r1) {
            return Log.e(r0, r1);
        }

        private int[] c(View r9, Rect r10) {
            int[] r0 = new int[2];
            int r1 = C();
            int r2 = D();
            int r3 = A() - E();
            int r4 = B() - F();
            int r5 = (r9.getLeft() + r10.left) - r9.getScrollX();
            int r6 = (r9.getTop() + r10.top) - r9.getScrollY();
            int r11 = r10.width() + r5;
            int r12 = r10.height() + r6;
            int r7 = r5 - r1;
            int r8 = Math.min(0, r7);
            int r13 = r6 - r2;
            int r14 = Math.min(0, r13);
            int r15 = r11 - r3;
            int r16 = Math.max(0, r15);
            int r17 = Math.max(0, r12 - r4);
            if (v() != 1) goto L7;
            if (r16 != 0) goto L11;
            r16 = Math.max(r8, r15);
        L11:
            if (r14 != 0) goto L14;
            r14 = Math.min(r13, r17);
        L14:
            r0[0] = r16;
            r0[1] = r14;
            return r0;
        L7:
            if (r8 != 0) goto L10;
            r8 = Math.min(r7, r16);
        L10:
            r16 = r8;
            goto L11
        }

        public boolean a(RecyclerView r7, View r8, Rect r9, boolean r10) {
            return a(r7, r8, r9, r10, false);
        }

        public boolean a(RecyclerView r3, View r4, Rect r5, boolean r6, boolean r7) {
            int[] r8 = c(r4, r5);
            int r0 = r8[0];
            int r9 = r8[1];
            if (r7 == true) goto L5;
        L6:
            if (r0 != 0) goto L10;
            if (r9 != 0) goto L10;
        L9:
            return false;
        L10:
            if (r6 == false) goto L12;
            r3.scrollBy(r0, r9);
        L13:
            return true;
        L12:
            r3.smoothScrollBy(r0, r9);
            goto L13
        L5:
            if (d(r3, r0, r9) == false) goto L9;
            goto L6
        }

        public boolean a(View r3, boolean r4, boolean r5) {
            if (this.r.a(r3, 24579) == true) goto L5;
        L7:
            boolean r2 = false;
        L8:
            if (r4 == false) goto L11;
            return r2;
        L11:
            return !r2;
        L5:
            if (this.s.a(r3, 24579) == false) goto L7;
            r2 = true;
            goto L8
        }

        private boolean d(RecyclerView r7, int r8, int r9) {
            View r10 = r7.getFocusedChild();
            if (r10 != null) goto L5;
            return false;
        L5:
            int r1 = C();
            int r2 = D();
            int r3 = A() - E();
            int r4 = B() - F();
            Rect r5 = this.q.mTempRect;
            a(r10, r5);
            if ((r5.left - r8) < r3) goto L8;
        L16:
            return false;
        L8:
            if ((r5.right - r8) <= r1) goto L16;
            if ((r5.top - r9) >= r4) goto L16;
            if ((r5.bottom - r9) <= r2) goto L16;
            return true;
        }

        @Deprecated
        public boolean a(RecyclerView r1, View r2, View r3) {
            if (u() == false) goto L5;
        L8:
            return true;
        L5:
            if (r1.isComputingLayout() == true) goto L8;
            return false;
        }

        public boolean a(RecyclerView r1, r r2, View r3, View r4) {
            return a(r1, r3, r4);
        }

        public void a(RecyclerView r1, int r2, int r3, Object r4) {
            c(r1, r2, r3);
        }

        public void a(n r1, r r2, int r3, int r4) {
            this.q.defaultOnMeasure(r3, r4);
        }

        public void f(int r1, int r2) {
            RecyclerView.access$300(this.q, r1, r2);
        }

        public int I() {
            return ViewCompat.n(this.q);
        }

        public int J() {
            return ViewCompat.o(this.q);
        }

        void K() {
            q r0 = this.t;
            if (r0 == null) goto L6;
            r0.f();
            return;
        }

        void b(q r2) {
            if (this.t != r2) goto L6;
            this.t = null;
            return;
        }

        public void c(n r3) {
            int r0 = x() - 1;
        L3:
            if (r0 < 0) goto L8;
            if (RecyclerView.getChildViewHolderInt(i(r0)).c() == true) goto L7;
            a(r0, r3);
        L7:
            r0 = r0 - 1;
            goto L3
        }

        void a(androidx.core.view.accessibility.b r3) {
            a(this.q.mRecycler, this.q.mState, r3);
        }

        public void a(n r4, r r5, androidx.core.view.accessibility.b r6) {
            if (this.q.canScrollVertically(-1) == false) goto L5;
        L6:
            r6.a(8192);
            r6.k(true);
        L8:
            if (this.q.canScrollVertically(1) == false) goto L10;
        L11:
            r6.a(4096);
            r6.k(true);
        L12:
            r6.b(androidx.core.view.accessibility.b.f.a(a(r4, r5), b(r4, r5), e(r4, r5), d(r4, r5)));
            return;
        L10:
            if (this.q.canScrollHorizontally(1) == false) goto L12;
        L5:
            if (this.q.canScrollHorizontally(-1) == false) goto L8;
            goto L6
        }

        public void a(AccessibilityEvent r3) {
            a(this.q.mRecycler, this.q.mState, r3);
        }

        public void a(n r2, r r3, AccessibilityEvent r4) {
            RecyclerView r5 = this.q;
            if (r5 == null) goto L20;
            if (r4 == null) goto L22;
            boolean r6 = true;
            if (r5.canScrollVertically(1) == false) goto L9;
        L16:
            r4.setScrollable(r6);
            if (this.q.mAdapter == null) goto L21;
            r4.setItemCount(this.q.mAdapter.a());
            return;
        L21:
            return;
        L9:
            if (this.q.canScrollVertically(-1) == true) goto L16;
            if (this.q.canScrollHorizontally(-1) == true) goto L16;
            if (this.q.canScrollHorizontally(1) == true) goto L16;
            r6 = false;
            goto L16
        L22:
            return;
        }

        void a(View r3, androidx.core.view.accessibility.b r4) {
            u r0 = RecyclerView.getChildViewHolderInt(r3);
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.t() == false) goto L7;
            return;
        L7:
            if (this.p.c(r0.f2390a) == true) goto L12;
            a(this.q.mRecycler, this.q.mState, r3, r4);
            return;
        }

        public void L() {
            this.u = true;
        }

        boolean a(int r3, Bundle r4) {
            return a(this.q.mRecycler, this.q.mState, r3, r4);
        }

        public boolean a(n r8, r r9, int r10, Bundle r11) {
            RecyclerView r12 = this.q;
            if (r12 != null) goto L6;
            return false;
        L6:
            if (r10 == 4096) goto L18;
            if (r10 == 8192) goto L11;
            int r2 = 0;
            int r3 = 0;
        L26:
            if (r3 != 0) goto L29;
            if (r2 != 0) goto L29;
            return false;
        L29:
            this.q.smoothScrollBy(r2, r3, null, Integer.MIN_VALUE, true);
            return true;
        L11:
            if (r12.canScrollVertically(-1) == false) goto L13;
            int r13 = -((B() - D()) - F());
        L15:
            if (this.q.canScrollHorizontally(-1) == false) goto L25;
            int r14 = -((A() - C()) - E());
        L24:
            r3 = r13;
            r2 = r14;
        L25:
            r3 = r13;
            r2 = 0;
            goto L26
        L13:
            r13 = 0;
            goto L15
        L18:
            if (r12.canScrollVertically(1) == false) goto L20;
            r13 = (B() - D()) - F();
        L22:
            if (this.q.canScrollHorizontally(1) == false) goto L25;
            r14 = (A() - C()) - E();
            goto L24
        L20:
            r13 = 0;
            goto L22
        }

        boolean a(View r8, int r9, Bundle r10) {
            return a(this.q.mRecycler, this.q.mState, r8, r9, r10);
        }

        public static b a(Context r2, AttributeSet r3, int r4, int r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
            b r0 = new b();
            TypedArray r8 = r6.obtainStyledAttributes(r7, R.styleable.RecyclerView, r4, r5);
            r0.f2354a = r8.getInt(ZeusTransformUtils.mapRes(R.styleable.RecyclerView_android_orientation, "styleable", "RecyclerView_android_orientation"), 1);
            r0.f2355b = r8.getInt(ZeusTransformUtils.mapRes(R.styleable.RecyclerView_spanCount, "styleable", "RecyclerView_spanCount"), 1);
            r0.f2356c = r8.getBoolean(ZeusTransformUtils.mapRes(R.styleable.RecyclerView_reverseLayout, "styleable", "RecyclerView_reverseLayout"), false);
            r0.f2357d = r8.getBoolean(ZeusTransformUtils.mapRes(R.styleable.RecyclerView_stackFromEnd, "styleable", "RecyclerView_stackFromEnd"), false);
            r8.recycle();
            return r0;
        }

        void f(RecyclerView r3) {
            c(View.MeasureSpec.makeMeasureSpec(r3.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r3.getHeight(), 1073741824));
        }

        boolean M() {
            int r0 = x();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L11;
            ViewGroup.LayoutParams r3 = i(r2).getLayoutParams();
            if (r3.width >= 0) goto L10;
            if (r3.height >= 0) goto L10;
            return true;
        L10:
            r2 = r2 + 1;
            goto L3
        L11:
            return false;
        }
    }

    public interface i {
        void a(View r1);

        void b(View r1);
    }

    public static abstract class j {
        public abstract boolean a(int r1, int r2);

        public j() {
        }
    }

    public interface k {
        void a(boolean r1);

        boolean a(RecyclerView r1, MotionEvent r2);

        void b(RecyclerView r1, MotionEvent r2);
    }

    public static abstract class l {
        public void a(RecyclerView r1, int r2) {
        }

        public void a(RecyclerView r1, int r2, int r3) {
        }

        public l() {
        }
    }

    public static class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SparseArray<a> f2358a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2359b;

        static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final ArrayList<u> f2360a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f2361b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            long f2362c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            long f2363d;

            a() {
                this.f2360a = new ArrayList();
                this.f2361b = 5;
                this.f2362c = 0;
                this.f2363d = 0;
            }
        }

        public m() {
            this.f2358a = new SparseArray();
            this.f2359b = 0;
        }

        public void a() {
            int r0 = 0;
        L4:
            if (r0 >= this.f2358a.size()) goto L6;
            ((a) ZeusTransformUtils.preCheckCast(this.f2358a.valueAt(r0), a.class, "com.obric.aiagent.plugin")).f2360a.clear();
            r0 = r0 + 1;
            goto L4
        }

        public u a(int r4) {
            a r3 = (a) ZeusTransformUtils.preCheckCast(this.f2358a.get(r4), a.class, "com.obric.aiagent.plugin");
            if (r3 != null) goto L5;
            return null;
        L5:
            if (r3.f2360a.isEmpty() == true) goto L17;
            ArrayList<u> r5 = r3.f2360a;
            int r6 = r5.size() - 1;
        L7:
            if (r6 < 0) goto L18;
            if (((u) ZeusTransformUtils.preCheckCast(r5.get(r6), u.class, "com.obric.aiagent.plugin")).v() == false) goto L11;
            r6 = r6 - 1;
            goto L7
        L11:
            return (u) ZeusTransformUtils.preCheckCast(r5.remove(r6), u.class, "com.obric.aiagent.plugin");
        L18:
            return null;
        L17:
            return null;
        }

        public void a(u r4) {
            int r0 = r4.k();
            ArrayList<u> r1 = b(r0).f2360a;
            if (((a) ZeusTransformUtils.preCheckCast(this.f2358a.get(r0), a.class, "com.obric.aiagent.plugin")).f2361b > r1.size()) goto L5;
            return;
        L5:
            r4.z();
            r1.add(r4);
        }

        long a(long r5, long r7) {
            if (r5 != 0) goto L6;
            return r7;
        L6:
            return ((r5 / 4) * 3) + (r7 / 4);
        }

        void a(int r3, long r4) {
            a r5 = b(r3);
            r5.f2362c = a(r5.f2362c, r4);
        }

        void b(int r3, long r4) {
            a r5 = b(r3);
            r5.f2363d = a(r5.f2363d, r4);
        }

        boolean a(int r3, long r4, long r6) {
            long r2 = b(r3).f2362c;
            if (r2 != 0) goto L5;
        L8:
            return true;
        L5:
            if ((r4 + r2) < r6) goto L8;
            return false;
        }

        boolean b(int r3, long r4, long r6) {
            long r2 = b(r3).f2363d;
            if (r2 != 0) goto L5;
        L8:
            return true;
        L5:
            if ((r4 + r2) < r6) goto L8;
            return false;
        }

        void b() {
            this.f2359b++;
        }

        void c() {
            this.f2359b--;
        }

        void a(a r1, a r2, boolean r3) {
            if (r1 == null) goto L4;
            c();
        L4:
            if (r3 == false) goto L6;
        L8:
            if (r2 == null) goto L11;
            b();
            return;
        L11:
            return;
        L6:
            if (this.f2359b != 0) goto L8;
            a();
            goto L8
        }

        private a b(int r4) {
            a r0 = (a) ZeusTransformUtils.preCheckCast(this.f2358a.get(r4), a.class, "com.obric.aiagent.plugin");
            if (r0 != null) goto L6;
            a r1 = new a();
            this.f2358a.put(r4, r1);
            return r1;
        L6:
            return r0;
        }
    }

    public final class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ArrayList<u> f2364a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ArrayList<u> f2365b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ArrayList<u> f2366c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2367d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        m f2368e;
        final /* synthetic */ RecyclerView f;
        private final List<u> g;
        private int h;
        private s i;

        public n(RecyclerView r2) {
            this.f = r2;
            ArrayList<u> r3 = new ArrayList();
            this.f2364a = r3;
            this.f2365b = null;
            this.f2366c = new ArrayList();
            this.g = Collections.unmodifiableList(r3);
            this.h = 2;
            this.f2367d = 2;
        }

        public void a() {
            this.f2364a.clear();
            d();
        }

        public void a(int r1) {
            this.h = r1;
            b();
        }

        void b() {
            if (this.f.mLayout == null) goto L5;
            int r0 = this.f.mLayout.x;
        L6:
            this.f2367d = this.h + r0;
            int r1 = this.f2366c.size() - 1;
        L7:
            if (r1 < 0) goto L11;
            if (this.f2366c.size() <= this.f2367d) goto L14;
            d(r1);
            r1 = r1 - 1;
            goto L7
        L14:
            return;
        L11:
            return;
        L5:
            r0 = 0;
            goto L6
        }

        public List<u> c() {
            return this.g;
        }

        boolean a(u r6) {
            if (r6.t() == false) goto L7;
            return this.f.mState.a();
        L7:
            if (r6.f2392c < 0) goto L23;
            if (r6.f2392c >= this.f.mAdapter.a()) goto L23;
            if (this.f.mState.a() == true) goto L16;
            if (this.f.mAdapter.a(r6.f2392c) == r6.k()) goto L16;
            return false;
        L16:
            if (this.f.mAdapter.b() == true) goto L18;
            return true;
        L18:
            if (r6.j() == this.f.mAdapter.b(r6.f2392c)) goto L20;
            return false;
        L20:
            return true;
        L23:
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + r6 + this.f.exceptionLabel());
        }

        private boolean a(u r10, int r11, int r12, long r13) {
            r10.q = null;
            r10.p = this.f;
            int r2 = r10.k();
            long r7 = this.f.getNanoTime();
            if (r13 != RecyclerView.FOREVER_NS) goto L5;
        L8:
            this.f.mAdapter.b(r10, r11);
            long r14 = this.f.getNanoTime();
            this.f2368e.b(r10.k(), r14 - r7);
            e(r10);
            if (this.f.mState.a() == false) goto L13;
            r10.g = r12;
            return true;
        L13:
            return true;
        L5:
            if (this.f2368e.b(r2, r7, r13) == true) goto L8;
            return false;
        }

        public int b(int r4) {
            if (r4 < 0) goto L11;
            if (r4 >= this.f.mState.e()) goto L11;
            if (this.f.mState.a() == true) goto L9;
            return r4;
        L9:
            return this.f.mAdapterHelper.b(r4);
        L11:
            throw new IndexOutOfBoundsException("invalid position " + r4 + ". State item count is " + this.f.mState.e() + this.f.exceptionLabel());
        }

        public View c(int r2) {
            return a(r2, false);
        }

        View a(int r3, boolean r4) {
            return a(r3, r4, RecyclerView.FOREVER_NS).f2390a;
        }

        u a(int r17, boolean r18, long r19) {
            if (r17 < 0) goto L112;
            if (r17 >= this.f.mState.e()) goto L112;
            boolean r7 = true;
            if (this.f.mState.a() == false) goto L11;
            u r1 = f(r17);
            if (r1 == null) goto L12;
            boolean r4 = true;
        L13:
            if (r1 != null) goto L28;
            r1 = b(r17, r18);
            if (r1 == null) goto L28;
            if (a(r1) == true) goto L27;
            if (r18 == true) goto L26;
            r1.b(4);
            if (r1.l() == false) goto L23;
            this.f.removeDetachedView(r1.f2390a, false);
            r1.m();
        L25:
            b(r1);
            goto L26
        L23:
            if (r1.n() == false) goto L25;
            r1.o();
        L26:
            r1 = null;
            goto L28
        L27:
            r4 = true;
        L28:
            if (r1 != null) goto L73;
            int r5 = this.f.mAdapterHelper.b(r17);
            if (r5 < 0) goto L72;
            if (r5 >= this.f.mAdapter.a()) goto L72;
            int r9 = this.f.mAdapter.a(r5);
            if (this.f.mAdapter.b() == false) goto L38;
            r1 = a(this.f.mAdapter.b(r5), r9, r18);
            if (r1 == null) goto L38;
            r1.f2392c = r5;
            r4 = true;
        L38:
            if (r1 != null) goto L52;
            s r0 = this.i;
            if (r0 == null) goto L52;
            View r2 = r0.a(this, r17, r9);
            if (r2 == null) goto L52;
            r1 = this.f.getChildViewHolder(r2);
            if (r1 == null) goto L51;
            if (r1.c() == false) goto L52;
            throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + this.f.exceptionLabel());
        L51:
            throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + this.f.exceptionLabel());
        L52:
            if (r1 != null) goto L59;
            u r3 = g().a(r9);
            if (r3 == null) goto L58;
            r3.z();
            if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST == false) goto L58;
            f(r3);
        L58:
            r1 = r3;
        L59:
            if (r1 != null) goto L73;
            long r6 = this.f.getNanoTime();
            if (r19 != RecyclerView.FOREVER_NS) goto L63;
        L65:
            u r8 = this.f.mAdapter.b(this.f, r9);
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L70;
            RecyclerView r10 = RecyclerView.findNestedRecyclerView(r8.f2390a);
            if (r10 == null) goto L70;
            r8.f2391b = new WeakReference(r10);
        L70:
            this.f2368e.a(r9, this.f.getNanoTime() - r6);
            u r11 = r8;
        L74:
            boolean r12 = r4;
            if (r12 == false) goto L84;
            if (this.f.mState.a() == true) goto L84;
            if (r11.a(8192) == false) goto L84;
            r11.a(0, 8192);
            if (this.f.mState.j == false) goto L84;
            this.f.recordAnimationInfoIfBouncedHiddenView(r11, this.f.mItemAnimator.a(this.f.mState, r11, e.e(r11) | 4096, r11.y()));
        L84:
            if (this.f.mState.a() == false) goto L89;
            if (r11.s() == false) goto L89;
            r11.g = r17;
        L95:
            boolean r13 = false;
        L97:
            ViewGroup.LayoutParams r14 = r11.f2390a.getLayoutParams();
            if (r14 != null) goto L101;
            LayoutParams r15 = (LayoutParams) ZeusTransformUtils.preCheckCast(this.f.generateDefaultLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
            r11.f2390a.setLayoutParams(r15);
        L104:
            r15.mViewHolder = r11;
            if (r12 == false) goto L108;
            if (r13 == false) goto L108;
        L109:
            r15.mPendingInvalidate = r7;
            return r11;
        L108:
            r7 = false;
            goto L109
        L101:
            if (this.f.checkLayoutParams(r14) == true) goto L103;
            r15 = (LayoutParams) ZeusTransformUtils.preCheckCast(this.f.generateLayoutParams(r14), LayoutParams.class, "com.obric.aiagent.plugin");
            r11.f2390a.setLayoutParams(r15);
            goto L104
        L103:
            r15 = (LayoutParams) ZeusTransformUtils.preCheckCast(r14, LayoutParams.class, "com.obric.aiagent.plugin");
        L89:
            if (r11.s() == true) goto L91;
        L96:
            r13 = a(r11, this.f.mAdapterHelper.b(r17), r17, r19);
            goto L97
        L91:
            if (r11.r() == true) goto L96;
            if (r11.q() == false) goto L95;
        L63:
            if (this.f2368e.a(r9, r6, r19) == true) goto L65;
            return null;
        L72:
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + r17 + "(offset:" + r5 + ").state:" + this.f.mState.e() + this.f.exceptionLabel());
        L73:
            r11 = r1;
        L12:
            r4 = false;
            goto L13
        L11:
            r1 = null;
        L112:
            throw new IndexOutOfBoundsException("Invalid item position " + r17 + "(" + r17 + "). Item count:" + this.f.mState.e() + this.f.exceptionLabel());
        }

        private void e(u r3) {
            if (this.f.isAccessibilityEnabled() == false) goto L15;
            View r4 = r3.f2390a;
            if (ViewCompat.g(r4) != 0) goto L8;
            ViewCompat.c(r4, 1);
        L8:
            if (this.f.mAccessibilityDelegate != null) goto L10;
            return;
        L10:
            AccessibilityDelegateCompat r2 = this.f.mAccessibilityDelegate.c();
            if (ZeusTransformUtils.instanceOf(r2, w.a.class) == false) goto L13;
            ((w.a) ZeusTransformUtils.preCheckCast(r2, w.a.class, "com.obric.aiagent.plugin")).c(r4);
        L13:
            ViewCompat.a(r4, r2);
            return;
        }

        private void f(u r3) {
            if (ZeusTransformUtils.instanceOf(r3.f2390a, ViewGroup.class) == false) goto L6;
            a((ViewGroup) ZeusTransformUtils.preCheckCast(r3.f2390a, ViewGroup.class, "com.obric.aiagent.plugin"), false);
            return;
        }

        private void a(ViewGroup r6, boolean r7) {
            int r0 = r6.getChildCount() - 1;
        L3:
            if (r0 < 0) goto L8;
            View r2 = r6.getChildAt(r0);
            if (ZeusTransformUtils.instanceOf(r2, ViewGroup.class) == false) goto L7;
            a((ViewGroup) ZeusTransformUtils.preCheckCast(r2, ViewGroup.class, "com.obric.aiagent.plugin"), true);
        L7:
            r0 = r0 - 1;
            goto L3
        L8:
            if (r7 == true) goto L11;
            return;
        L11:
            if (r6.getVisibility() != 4) goto L13;
            r6.setVisibility(0);
            r6.setVisibility(4);
            return;
        L13:
            int r5 = r6.getVisibility();
            r6.setVisibility(4);
            r6.setVisibility(r5);
        }

        public void a(View r4) {
            u r0 = RecyclerView.getChildViewHolderInt(r4);
            if (r0.u() == false) goto L6;
            this.f.removeDetachedView(r4, false);
        L6:
            if (r0.l() == false) goto L9;
            r0.m();
        L11:
            b(r0);
            if (this.f.mItemAnimator != null) goto L14;
            return;
        L14:
            if (r0.A() == true) goto L18;
            this.f.mItemAnimator.d(r0);
            return;
        L18:
            return;
        L9:
            if (r0.n() == false) goto L11;
            r0.o();
            goto L11
        }

        void d() {
            int r0 = this.f2366c.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            d(r0);
            r0 = r0 - 1;
            goto L3
        L5:
            this.f2366c.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L10;
            this.f.mPrefetchRegistry.a();
            return;
        }

        void d(int r4) {
            a((u) ZeusTransformUtils.preCheckCast(this.f2366c.get(r4), u.class, "com.obric.aiagent.plugin"), true);
            this.f2366c.remove(r4);
        }

        void b(u r8) {
            boolean r1 = false;
            boolean r2 = true;
            if (r8.l() == false) goto L5;
        L59:
            StringBuilder r3 = new StringBuilder().append("Scrapped or attached views may not be recycled. isScrap:").append(r8.l()).append(" isAttached:");
            if (r8.f2390a.getParent() == null) goto L63;
            r1 = true;
        L63:
            throw new IllegalArgumentException(r3.append(r1).append(this.f.exceptionLabel()).toString());
        L5:
            if (r8.f2390a.getParent() != null) goto L59;
            if (r8.u() == true) goto L58;
            if (r8.c() == true) goto L56;
            boolean r0 = r8.C();
            if (this.f.mAdapter == null) goto L17;
            if (r0 == false) goto L17;
            if (this.f.mAdapter.a(r8) == false) goto L17;
            boolean r4 = true;
        L18:
            if (r4 == true) goto L24;
            if (r8.A() == true) goto L24;
            r2 = false;
        L49:
            this.f.mViewInfoStore.g(r8);
            if (r1 == true) goto L66;
            if (r2 == true) goto L67;
            if (r0 == false) goto L68;
            r8.q = null;
            r8.p = null;
            return;
        L68:
            return;
        L67:
            return;
        L66:
            return;
        L24:
            if (this.f2367d > 0) goto L26;
        L44:
            boolean r5 = false;
        L45:
            if (r5 == true) goto L47;
            a(r8, true);
        L48:
            r1 = r5;
            goto L49
        L47:
            r2 = false;
            goto L48
        L26:
            if (r8.a(526) == true) goto L44;
            int r6 = this.f2366c.size();
            if (r6 < this.f2367d) goto L32;
            if (r6 <= 0) goto L32;
            d(0);
            r6 = r6 - 1;
        L32:
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L43;
            if (r6 <= 0) goto L43;
            if (this.f.mPrefetchRegistry.a(r8.f2392c) == true) goto L43;
            int r7 = r6 - 1;
        L37:
            if (r7 < 0) goto L42;
            if (this.f.mPrefetchRegistry.a(((u) ZeusTransformUtils.preCheckCast(this.f2366c.get(r7), u.class, "com.obric.aiagent.plugin")).f2392c) == false) goto L42;
            r7 = r7 - 1;
        L42:
            r6 = r7 + 1;
        L43:
            this.f2366c.add(r6, r8);
            r5 = true;
        L17:
            r4 = false;
            goto L18
        L56:
            throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + this.f.exceptionLabel());
        L58:
            throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + r8 + this.f.exceptionLabel());
        }

        void a(u r6, boolean r7) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(r6);
            View r0 = r6.f2390a;
            if (this.f.mAccessibilityDelegate == null) goto L9;
            AccessibilityDelegateCompat r1 = this.f.mAccessibilityDelegate.c();
            if (ZeusTransformUtils.instanceOf(r1, w.a.class) == false) goto L7;
            AccessibilityDelegateCompat r2 = ((w.a) ZeusTransformUtils.preCheckCast(r1, w.a.class, "com.obric.aiagent.plugin")).d(r0);
        L8:
            ViewCompat.a(r0, r2);
            goto L9
        L7:
            r2 = null;
        L9:
            if (r7 == false) goto L11;
            d(r6);
        L11:
            r6.q = null;
            r6.p = null;
            g().a(r6);
        }

        void b(View r2) {
            u r3 = RecyclerView.getChildViewHolderInt(r2);
            r3.m = null;
            r3.n = false;
            r3.o();
            b(r3);
        }

        void c(View r3) {
            u r4 = RecyclerView.getChildViewHolderInt(r3);
            if (r4.a(12) == true) goto L14;
            if (r4.D() == false) goto L14;
            if (this.f.canReuseUpdatedViewHolder(r4) == true) goto L14;
            if (this.f2365b != null) goto L12;
            this.f2365b = new ArrayList();
        L12:
            r4.a(this, true);
            this.f2365b.add(r4);
            return;
        L14:
            if (r4.q() == true) goto L16;
        L22:
            r4.a(this, false);
            this.f2364a.add(r4);
            return;
        L16:
            if (r4.t() == true) goto L22;
            if (this.f.mAdapter.b() == true) goto L22;
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + this.f.exceptionLabel());
        }

        void c(u r2) {
            if (r2.n == false) goto L5;
            this.f2365b.remove(r2);
        L6:
            r2.m = null;
            r2.n = false;
            r2.o();
            return;
        L5:
            this.f2364a.remove(r2);
            goto L6
        }

        int e() {
            return this.f2364a.size();
        }

        View e(int r2) {
            return ((u) ZeusTransformUtils.preCheckCast(this.f2364a.get(r2), u.class, "com.obric.aiagent.plugin")).f2390a;
        }

        void f() {
            this.f2364a.clear();
            ArrayList<u> r1 = this.f2365b;
            if (r1 == null) goto L6;
            r1.clear();
            return;
        }

        u f(int r11) {
            ArrayList<u> r0 = this.f2365b;
            if (r0 == null) goto L32;
            int r1 = r0.size();
            if (r1 == 0) goto L32;
            int r2 = 0;
            int r3 = 0;
        L9:
            if (r3 >= r1) goto L18;
            u r5 = (u) ZeusTransformUtils.preCheckCast(this.f2365b.get(r3), u.class, "com.obric.aiagent.plugin");
            if (r5.n() == true) goto L16;
            if (r5.e() != r11) goto L16;
            r5.b(32);
            return r5;
        L16:
            r3 = r3 + 1;
            goto L9
        L18:
            if (this.f.mAdapter.b() == false) goto L32;
            int r12 = this.f.mAdapterHelper.b(r11);
            if (r12 <= 0) goto L32;
            if (r12 >= this.f.mAdapter.a()) goto L32;
            long r6 = this.f.mAdapter.b(r12);
        L24:
            if (r2 >= r1) goto L32;
            u r13 = (u) ZeusTransformUtils.preCheckCast(this.f2365b.get(r2), u.class, "com.obric.aiagent.plugin");
            if (r13.n() == true) goto L31;
            if (r13.j() != r6) goto L31;
            r13.b(32);
            return r13;
        L31:
            r2 = r2 + 1;
        L32:
            return null;
        }

        u b(int r7, boolean r8) {
            int r0 = this.f2364a.size();
            int r1 = 0;
            int r2 = 0;
        L4:
            if (r2 >= r0) goto L18;
            u r3 = (u) ZeusTransformUtils.preCheckCast(this.f2364a.get(r2), u.class, "com.obric.aiagent.plugin");
            if (r3.n() == true) goto L17;
            if (r3.e() != r7) goto L17;
            if (r3.q() == true) goto L17;
            if (this.f.mState.g == true) goto L15;
            if (r3.t() == true) goto L17;
        L15:
            r3.b(32);
            return r3;
        L17:
            r2 = r2 + 1;
            goto L4
        L18:
            if (r8 == true) goto L27;
            View r4 = this.f.mChildHelper.c(r7);
            if (r4 == null) goto L27;
            u r9 = RecyclerView.getChildViewHolderInt(r4);
            this.f.mChildHelper.e(r4);
            int r10 = this.f.mChildHelper.b(r4);
            if (r10 == (-1)) goto L26;
            this.f.mChildHelper.e(r10);
            c(r4);
            r9.b(8224);
            return r9;
        L26:
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + r9 + this.f.exceptionLabel());
        L27:
            int r5 = this.f2366c.size();
        L28:
            if (r1 >= r5) goto L39;
            u r6 = (u) ZeusTransformUtils.preCheckCast(this.f2366c.get(r1), u.class, "com.obric.aiagent.plugin");
            if (r6.q() == true) goto L38;
            if (r6.e() != r7) goto L38;
            if (r6.v() == true) goto L38;
            if (r8 == true) goto L37;
            this.f2366c.remove(r1);
        L37:
            return r6;
        L38:
            r1 = r1 + 1;
            goto L28
        L39:
            return null;
        }

        u a(long r7, int r9, boolean r10) {
            int r0 = this.f2364a.size();
        L3:
            r0 = r0 - 1;
            if (r0 < 0) goto L20;
            u r1 = (u) ZeusTransformUtils.preCheckCast(this.f2364a.get(r0), u.class, "com.obric.aiagent.plugin");
            if (r1.j() != r7) goto L3;
            if (r1.n() == true) goto L3;
            if (r9 == r1.k()) goto L11;
            if (r10 == true) goto L3;
            this.f2364a.remove(r0);
            this.f.removeDetachedView(r1.f2390a, false);
            b(r1.f2390a);
            goto L3
        L11:
            r1.b(32);
            if (r1.t() == true) goto L14;
        L16:
            return r1;
        L14:
            if (this.f.mState.a() == true) goto L16;
            r1.a(2, 14);
            goto L16
        L20:
            int r2 = this.f2366c.size();
        L21:
            r2 = r2 - 1;
            if (r2 < 0) goto L36;
            u r3 = (u) ZeusTransformUtils.preCheckCast(this.f2366c.get(r2), u.class, "com.obric.aiagent.plugin");
            if (r3.j() != r7) goto L21;
            if (r3.v() == true) goto L21;
            if (r9 == r3.k()) goto L29;
            if (r10 == true) goto L21;
            d(r2);
            return null;
        L29:
            if (r10 == true) goto L31;
            this.f2366c.remove(r2);
        L31:
            return r3;
        L36:
            return null;
        }

        void d(u r6) {
            if (this.f.mRecyclerListener == null) goto L5;
            this.f.mRecyclerListener.a(r6);
        L5:
            int r0 = this.f.mRecyclerListeners.size();
            int r1 = 0;
        L6:
            if (r1 >= r0) goto L9;
            ((o) ZeusTransformUtils.preCheckCast(this.f.mRecyclerListeners.get(r1), o.class, "com.obric.aiagent.plugin")).a(r6);
            r1 = r1 + 1;
            goto L6
        L9:
            if (this.f.mAdapter == null) goto L12;
            this.f.mAdapter.d(r6);
        L12:
            if (this.f.mState == null) goto L16;
            this.f.mViewInfoStore.g(r6);
            return;
        }

        void a(a r1, a r2, boolean r3) {
            a();
            g().a(r1, r2, r3);
        }

        void a(int r10, int r11) {
            if (r10 >= r11) goto L4;
            int r0 = -1;
            int r1 = r10;
            int r2 = r11;
        L5:
            int r3 = this.f2366c.size();
            int r5 = 0;
        L6:
            if (r5 >= r3) goto L19;
            u r6 = (u) ZeusTransformUtils.preCheckCast(this.f2366c.get(r5), u.class, "com.obric.aiagent.plugin");
            if (r6 == null) goto L18;
            if (r6.f2392c < r1) goto L18;
            if (r6.f2392c > r2) goto L18;
            if (r6.f2392c != r10) goto L17;
            r6.a(r11 - r10, false);
            goto L18
        L17:
            r6.a(r0, false);
        L18:
            r5 = r5 + 1;
            goto L6
        L19:
            return;
        L4:
            r0 = 1;
            r2 = r10;
            r1 = r11;
            goto L5
        }

        void b(int r7, int r8) {
            int r0 = this.f2366c.size();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L10;
            u r3 = (u) ZeusTransformUtils.preCheckCast(this.f2366c.get(r2), u.class, "com.obric.aiagent.plugin");
            if (r3 == null) goto L9;
            if (r3.f2392c < r7) goto L9;
            r3.a(r8, false);
        L9:
            r2 = r2 + 1;
            goto L3
        }

        void a(int r6, int r7, boolean r8) {
            int r0 = r6 + r7;
            int r1 = this.f2366c.size() - 1;
        L3:
            if (r1 < 0) goto L13;
            u r2 = (u) ZeusTransformUtils.preCheckCast(this.f2366c.get(r1), u.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L12;
            if (r2.f2392c < r0) goto L10;
            r2.a(-r7, r8);
            goto L12
        L10:
            if (r2.f2392c < r6) goto L12;
            r2.b(8);
            d(r1);
        L12:
            r1 = r1 - 1;
            goto L3
        }

        void a(s r1) {
            this.i = r1;
        }

        void a(m r2) {
            m r0 = this.f2368e;
            if (r0 == null) goto L5;
            r0.c();
        L5:
            this.f2368e = r2;
            if (r2 != null) goto L8;
            return;
        L8:
            if (this.f.getAdapter() == null) goto L12;
            this.f2368e.b();
            return;
        }

        m g() {
            if (this.f2368e != null) goto L6;
            this.f2368e = new m();
        L6:
            return this.f2368e;
        }

        void c(int r5, int r6) {
            int r7 = r6 + r5;
            int r0 = this.f2366c.size() - 1;
        L3:
            if (r0 < 0) goto L12;
            u r1 = (u) ZeusTransformUtils.preCheckCast(this.f2366c.get(r0), u.class, "com.obric.aiagent.plugin");
            if (r1 == null) goto L11;
            int r2 = r1.f2392c;
            if (r2 < r5) goto L11;
            if (r2 >= r7) goto L11;
            r1.b(2);
            d(r0);
        L11:
            r0 = r0 - 1;
            goto L3
        }

        void h() {
            int r0 = this.f2366c.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L9;
            u r2 = (u) ZeusTransformUtils.preCheckCast(this.f2366c.get(r1), u.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L7;
            r2.b(6);
            r2.a(null);
        L7:
            r1 = r1 + 1;
            goto L3
        L9:
            if (this.f.mAdapter != null) goto L11;
        L12:
            d();
            return;
        L11:
            if (this.f.mAdapter.b() == false) goto L12;
        }

        void i() {
            int r0 = this.f2366c.size();
            int r1 = 0;
            int r2 = 0;
        L4:
            if (r2 >= r0) goto L6;
            ((u) ZeusTransformUtils.preCheckCast(this.f2366c.get(r2), u.class, "com.obric.aiagent.plugin")).a();
            r2 = r2 + 1;
            goto L4
        L6:
            int r3 = this.f2364a.size();
            int r4 = 0;
        L7:
            if (r4 >= r3) goto L9;
            ((u) ZeusTransformUtils.preCheckCast(this.f2364a.get(r4), u.class, "com.obric.aiagent.plugin")).a();
            r4 = r4 + 1;
            goto L7
        L9:
            ArrayList<u> r5 = this.f2365b;
            if (r5 == null) goto L14;
            int r6 = r5.size();
        L12:
            if (r1 >= r6) goto L18;
            ((u) ZeusTransformUtils.preCheckCast(this.f2365b.get(r1), u.class, "com.obric.aiagent.plugin")).a();
            r1 = r1 + 1;
            goto L12
        L18:
            return;
        }

        void j() {
            int r0 = this.f2366c.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            LayoutParams r2 = (LayoutParams) ZeusTransformUtils.preCheckCast(((u) ZeusTransformUtils.preCheckCast(this.f2366c.get(r1), u.class, "com.obric.aiagent.plugin")).f2390a.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
            if (r2 == null) goto L7;
            r2.mInsetsDirty = true;
        L7:
            r1 = r1 + 1;
            goto L3
        }
    }

    public interface o {
        void a(u r1);
    }

    private class p extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RecyclerView f2369a;

        p(RecyclerView r1) {
            this.f2369a = r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.b
        public void a() {
            this.f2369a.assertNotInLayoutOrScroll(null);
            this.f2369a.mState.f = true;
            this.f2369a.processDataSetCompletelyChanged(true);
            if (this.f2369a.mAdapterHelper.d() == true) goto L6;
            this.f2369a.requestLayout();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.b
        public void a(int r3, int r4, Object r5) {
            this.f2369a.assertNotInLayoutOrScroll(null);
            if (this.f2369a.mAdapterHelper.a(r3, r4, r5) == false) goto L6;
            c();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.b
        public void b(int r3, int r4) {
            this.f2369a.assertNotInLayoutOrScroll(null);
            if (this.f2369a.mAdapterHelper.b(r3, r4) == false) goto L6;
            c();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.b
        public void c(int r3, int r4) {
            this.f2369a.assertNotInLayoutOrScroll(null);
            if (this.f2369a.mAdapterHelper.c(r3, r4) == false) goto L6;
            c();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.b
        public void a(int r3, int r4, int r5) {
            this.f2369a.assertNotInLayoutOrScroll(null);
            if (this.f2369a.mAdapterHelper.a(r3, r4, r5) == false) goto L6;
            c();
            return;
        }

        void c() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION == true) goto L5;
        L9:
            this.f2369a.mAdapterUpdateDuringMeasure = true;
            this.f2369a.requestLayout();
            return;
        L5:
            if (this.f2369a.mHasFixedSize == false) goto L9;
            if (this.f2369a.mIsAttached == false) goto L9;
            RecyclerView r2 = this.f2369a;
            ViewCompat.a(r2, r2.mUpdateChildViewsRunnable);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.b
        public void b() {
            if (this.f2369a.mPendingSavedState != null) goto L5;
            return;
        L5:
            a r0 = this.f2369a.mAdapter;
            if (r0 != null) goto L8;
            return;
        L8:
            if (r0.f() == false) goto L12;
            this.f2369a.requestLayout();
            return;
        }
    }

    public static abstract class q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f2370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private RecyclerView f2371b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private h f2372c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f2373d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f2374e;
        private View f;
        private final a g;
        private boolean h;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f2375a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f2376b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f2377c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private int f2378d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private Interpolator f2379e;
            private boolean f;
            private int g;

            @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
            public static int a(String r0, String r1) {
                return Log.e(r0, r1);
            }

            public a(int r3, int r4) {
                this(r3, r4, Integer.MIN_VALUE, null);
            }

            public a(int r3, int r4, int r5, Interpolator r6) {
                Interpolator r7 = (Interpolator) ZeusTransformUtils.wrapperContextForParams(r6, Interpolator.class, "com.obric.aiagent.plugin");
                this.f2378d = -1;
                this.f = false;
                this.g = 0;
                this.f2375a = r3;
                this.f2376b = r4;
                this.f2377c = r5;
                this.f2379e = r7;
            }

            public void a(int r1) {
                this.f2378d = r1;
            }

            boolean a() {
                if (this.f2378d < 0) goto L5;
                return true;
            L5:
                return false;
            }

            void a(RecyclerView r6) {
                int r0 = this.f2378d;
                if (r0 < 0) goto L7;
                this.f2378d = -1;
                r6.jumpToPositionForSmoothScroller(r0);
                this.f = false;
                return;
            L7:
                if (this.f == false) goto L12;
                b();
                r6.mViewFlinger.a(this.f2375a, this.f2376b, this.f2377c, this.f2379e);
                int r7 = this.g + 1;
                this.g = r7;
                if (r7 <= 10) goto L11;
                a(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
            L11:
                this.f = false;
                return;
            L12:
                this.g = 0;
            }

            private void b() {
                if (this.f2379e == null) goto L10;
                if (this.f2377c >= 1) goto L10;
                throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
            L10:
                if (this.f2377c < 1) goto L13;
                return;
            L13:
                throw new IllegalStateException("Scroll duration must be a positive number");
            }

            public void update(int r3, int r4, int r5, Interpolator r6) {
                Interpolator r7 = (Interpolator) ZeusTransformUtils.wrapperContextForParams(r6, Interpolator.class, "com.obric.aiagent.plugin");
                this.f2375a = r3;
                this.f2376b = r4;
                this.f2377c = r5;
                this.f2379e = r7;
                this.f = true;
            }
        }

        public interface b {
            PointF d(int r1);
        }

        public abstract void a();

        public abstract void a(int r1, int r2, r r3, a r4);

        public abstract void a(View r1, r r2, a r3);

        public abstract void b();

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r1, String r2) {
            if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
            return 0;
        L5:
            return Log.w(r1, r2);
        }

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int b(String r0, String r1) {
            return Log.e(r0, r1);
        }

        public q() {
            this.f2370a = -1;
            this.g = new a(0, 0);
        }

        void a(RecyclerView r3, h r4) {
            r3.mViewFlinger.b();
            if (this.h == false) goto L5;
            a(RecyclerView.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
        L5:
            this.f2371b = r3;
            this.f2372c = r4;
            if (this.f2370a == (-1)) goto L10;
            r3.mState.f2380a = this.f2370a;
            this.f2374e = true;
            this.f2373d = true;
            this.f = e(i());
            a();
            this.f2371b.mViewFlinger.a();
            this.h = true;
            return;
        L10:
            throw new IllegalArgumentException("Invalid target position");
        }

        public void c(int r1) {
            this.f2370a = r1;
        }

        public PointF d(int r3) {
            h r2 = e();
            if (ZeusTransformUtils.instanceOf(r2, b.class) == true) goto L5;
            a(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        L5:
            return ((b) ZeusTransformUtils.preCheckCast(r2, b.class, "com.obric.aiagent.plugin")).d(r3);
        }

        public h e() {
            return this.f2372c;
        }

        public final void f() {
            if (this.f2374e == true) goto L5;
            return;
        L5:
            this.f2374e = false;
            b();
            this.f2371b.mState.f2380a = -1;
            this.f = null;
            this.f2370a = -1;
            this.f2373d = false;
            this.f2372c.b(this);
            this.f2372c = null;
            this.f2371b = null;
        }

        public boolean g() {
            return this.f2373d;
        }

        public boolean h() {
            return this.f2374e;
        }

        public int i() {
            return this.f2370a;
        }

        void a(int r6, int r7) {
            RecyclerView r0 = this.f2371b;
            if (this.f2370a == (-1)) goto L5;
            if (r0 == null) goto L5;
        L7:
            if (this.f2373d == true) goto L9;
        L19:
            this.f2373d = false;
            View r1 = this.f;
            if (r1 == null) goto L26;
            if (a(r1) != this.f2370a) goto L24;
            a(this.f, r0.mState, this.g);
            this.g.a(r0);
            f();
            goto L26
        L24:
            b(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
            this.f = null;
        L26:
            if (this.f2374e == false) goto L33;
            a(r6, r7, r0.mState, this.g);
            boolean r8 = this.g.a();
            this.g.a(r0);
            if (r8 == true) goto L30;
            return;
        L30:
            if (this.f2374e == false) goto L35;
            this.f2373d = true;
            r0.mViewFlinger.a();
            return;
        L35:
            return;
        L33:
            return;
        L9:
            if (this.f != null) goto L19;
            if (this.f2372c == null) goto L19;
            PointF r2 = d(this.f2370a);
            if (r2 == null) goto L19;
            if (r2.x == 0.0f) goto L17;
        L18:
            r0.scrollStep((int) Math.signum(r2.x), (int) Math.signum(r2.y), null);
            goto L19
        L17:
            if (r2.y == 0.0f) goto L19;
        L5:
            f();
            goto L7
        }

        public int a(View r1) {
            return this.f2371b.getChildLayoutPosition(r1);
        }

        public int j() {
            return this.f2371b.mLayout.x();
        }

        public View e(int r1) {
            return this.f2371b.mLayout.c(r1);
        }

        public void b(View r3) {
            if (a(r3) != i()) goto L6;
            this.f = r3;
            return;
        }

        public void a(PointF r3) {
            float r2 = (float) Math.sqrt((r3.x * r3.x) + (r3.y * r3.y));
            r3.x /= r2;
            r3.y /= r2;
        }
    }

    public static class r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2382c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2383d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f2384e;
        boolean f;
        boolean g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        int l;
        long m;
        int n;
        int o;
        int p;
        private SparseArray<Object> q;

        public r() {
            this.f2380a = -1;
            this.f2381b = 0;
            this.f2382c = 0;
            this.f2383d = 1;
            this.f2384e = 0;
            this.f = false;
            this.g = false;
            this.h = false;
            this.i = false;
            this.j = false;
            this.k = false;
        }

        void a(int r4) {
            if ((this.f2383d & r4) == 0) goto L6;
            return;
        L6:
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(r4) + " but it is " + Integer.toBinaryString(this.f2383d));
        }

        void a(a r2) {
            this.f2383d = 1;
            this.f2384e = r2.a();
            this.g = false;
            this.h = false;
            this.i = false;
        }

        public boolean a() {
            return this.g;
        }

        public boolean b() {
            return this.k;
        }

        public int c() {
            return this.f2380a;
        }

        public boolean d() {
            if (this.f2380a == (-1)) goto L5;
            return true;
        L5:
            return false;
        }

        public int e() {
            if (this.g == false) goto L6;
            return this.f2381b - this.f2382c;
        L6:
            return this.f2384e;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f2380a + ", mData=" + this.q + ", mItemCount=" + this.f2384e + ", mIsMeasuring=" + this.i + ", mPreviousLayoutItemCount=" + this.f2381b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f2382c + ", mStructureChanged=" + this.f + ", mInPreLayout=" + this.g + ", mRunSimpleAnimations=" + this.j + ", mRunPredictiveAnimations=" + this.k + '}';
        }
    }

    public static abstract class s {
        public abstract View a(n r1, int r2, int r3);
    }

    class t implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        OverScroller f2385a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Interpolator f2386b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ RecyclerView f2387c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f2388d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f2389e;
        private boolean f;
        private boolean g;

        t(RecyclerView r4) {
            this.f2387c = r4;
            this.f2386b = RecyclerView.sQuinticInterpolator;
            this.f = false;
            this.g = false;
            this.f2385a = new OverScroller((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), RecyclerView.sQuinticInterpolator);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f2387c.mLayout != null) goto L6;
            b();
            return;
        L6:
            this.g = false;
            this.f = true;
            this.f2387c.consumePendingUpdateOperations();
            OverScroller r3 = this.f2385a;
            if (r3.computeScrollOffset() == false) goto L85;
            int r4 = r3.getCurrX();
            int r5 = r3.getCurrY();
            int r6 = r4 - this.f2388d;
            int r13 = r5 - this.f2389e;
            this.f2388d = r4;
            this.f2389e = r5;
            this.f2387c.mReusableIntPair[0] = 0;
            this.f2387c.mReusableIntPair[1] = 0;
            RecyclerView r7 = this.f2387c;
            if (r7.dispatchNestedPreScroll(r6, r13, r7.mReusableIntPair, null, 1) == false) goto L12;
            r6 = r6 - this.f2387c.mReusableIntPair[0];
            r13 = r13 - this.f2387c.mReusableIntPair[1];
        L12:
            if (this.f2387c.getOverScrollMode() == 2) goto L15;
            this.f2387c.considerReleasingGlowsOnScroll(r6, r13);
        L15:
            if (this.f2387c.mAdapter == null) goto L29;
            this.f2387c.mReusableIntPair[0] = 0;
            this.f2387c.mReusableIntPair[1] = 0;
            RecyclerView r8 = this.f2387c;
            r8.scrollStep(r6, r13, r8.mReusableIntPair);
            int r9 = this.f2387c.mReusableIntPair[0];
            int r10 = this.f2387c.mReusableIntPair[1];
            r6 = r6 - r9;
            r13 = r13 - r10;
            q r11 = this.f2387c.mLayout.t;
            if (r11 == null) goto L31;
            if (r11.g() == true) goto L31;
            if (r11.h() == false) goto L31;
            int r12 = this.f2387c.mState.e();
            if (r12 != 0) goto L26;
            r11.f();
            goto L31
        L26:
            if (r11.i() < r12) goto L28;
            r11.c(r12 - 1);
            r11.a(r9, r10);
            goto L31
        L28:
            r11.a(r9, r10);
        L31:
            if (this.f2387c.mItemDecorations.isEmpty() == true) goto L33;
            this.f2387c.invalidate();
        L33:
            this.f2387c.mReusableIntPair[0] = 0;
            this.f2387c.mReusableIntPair[1] = 0;
            RecyclerView r14 = this.f2387c;
            r14.dispatchNestedScroll(r9, r10, r6, r13, null, 1, r14.mReusableIntPair);
            int r15 = r6 - this.f2387c.mReusableIntPair[0];
            int r16 = r13 - this.f2387c.mReusableIntPair[1];
            if (r9 != 0) goto L36;
            if (r10 != 0) goto L36;
        L38:
            if (RecyclerView.access$200(this.f2387c) == true) goto L41;
            this.f2387c.invalidate();
        L41:
            if (r3.getCurrX() != r3.getFinalX()) goto L43;
            boolean r17 = true;
        L45:
            if (r3.getCurrY() != r3.getFinalY()) goto L47;
            boolean r18 = true;
        L49:
            if (r3.isFinished() == true) goto L56;
            if (r17 == true) goto L52;
            if (r15 != 0) goto L52;
        L55:
            boolean r19 = false;
        L57:
            q r20 = this.f2387c.mLayout.t;
            if (r20 != null) goto L60;
        L62:
            boolean r21 = false;
        L63:
            if (r21 == true) goto L82;
            if (r19 == false) goto L82;
            if (this.f2387c.getOverScrollMode() == 2) goto L80;
            int r22 = (int) r3.getCurrVelocity();
            if (r15 >= 0) goto L70;
            int r23 = -r22;
        L73:
            if (r16 >= 0) goto L75;
            r22 = -r22;
        L78:
            this.f2387c.absorbGlows(r23, r22);
            goto L80
        L75:
            if (r16 > 0) goto L78;
            r22 = 0;
            goto L78
        L70:
            if (r15 <= 0) goto L72;
            r23 = r22;
            goto L73
        L72:
            r23 = 0;
        L80:
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L85;
            this.f2387c.mPrefetchRegistry.a();
        L82:
            a();
            if (this.f2387c.mGapWorker == null) goto L85;
            this.f2387c.mGapWorker.a(this.f2387c, r9, r10);
            goto L85
        L60:
            if (r20.g() == false) goto L62;
            r21 = true;
        L52:
            if (r18 == true) goto L56;
            if (r16 == 0) goto L55;
        L56:
            r19 = true;
            goto L57
        L47:
            r18 = false;
            goto L49
        L43:
            r17 = false;
        L36:
            this.f2387c.dispatchOnScrolled(r9, r10);
            goto L38
        L29:
            r9 = 0;
            r10 = 0;
        L85:
            q r24 = this.f2387c.mLayout.t;
            if (r24 != null) goto L88;
        L90:
            this.f = false;
            if (this.g == false) goto L93;
            c();
            return;
        L93:
            this.f2387c.setScrollState(0);
            this.f2387c.stopNestedScroll(1);
            return;
        L88:
            if (r24.g() == false) goto L90;
            r24.a(0, 0);
            goto L90
        }

        void a() {
            if (this.f == false) goto L5;
            this.g = true;
            return;
        L5:
            c();
        }

        private void c() {
            this.f2387c.removeCallbacks(this);
            ViewCompat.a(this.f2387c, this);
        }

        public void a(int r13, int r14) {
            this.f2387c.setScrollState(2);
            this.f2389e = 0;
            this.f2388d = 0;
            if (this.f2386b == RecyclerView.sQuinticInterpolator) goto L5;
            this.f2386b = RecyclerView.sQuinticInterpolator;
            this.f2385a = new OverScroller((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f2387c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), RecyclerView.sQuinticInterpolator);
        L5:
            this.f2385a.fling(0, 0, r13, r14, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            a();
        }

        public void a(int r9, int r10, int r11, Interpolator r12) {
            Interpolator r13 = (Interpolator) ZeusTransformUtils.wrapperContextForParams(r12, Interpolator.class, "com.obric.aiagent.plugin");
            if (r11 != Integer.MIN_VALUE) goto L5;
            r11 = b(r9, r10);
        L5:
            int r7 = r11;
            if (r13 != null) goto L9;
            r13 = RecyclerView.sQuinticInterpolator;
        L9:
            if (this.f2386b == r13) goto L11;
            this.f2386b = r13;
            this.f2385a = new OverScroller((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f2387c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r13);
        L11:
            this.f2389e = 0;
            this.f2388d = 0;
            this.f2387c.setScrollState(2);
            this.f2385a.startScroll(0, 0, r9, r10, r7);
            if (Build.VERSION.SDK_INT >= 23) goto L14;
            this.f2385a.computeScrollOffset();
        L14:
            a();
        }

        private int b(int r2, int r3) {
            int r4 = Math.abs(r2);
            int r5 = Math.abs(r3);
            if (r4 <= r5) goto L5;
            boolean r0 = true;
        L6:
            RecyclerView r1 = this.f2387c;
            if (r0 == false) goto L9;
            int r6 = r1.getWidth();
        L10:
            if (r0 == true) goto L14;
            r4 = r5;
        L14:
            return Math.min((int) (((r4 / r6) + 1.0f) * 300.0f), 2000);
        L9:
            r6 = r1.getHeight();
            goto L10
        L5:
            r0 = false;
            goto L6
        }

        public void b() {
            this.f2387c.removeCallbacks(this);
            this.f2385a.abortAnimation();
        }
    }

    public static abstract class u {
        private static final List<Object> r = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f2390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        WeakReference<RecyclerView> f2391b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2392c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2393d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f2394e;
        int f;
        int g;
        u h;
        u i;
        int j;
        List<Object> k;
        List<Object> l;
        n m;
        boolean n;
        int o;
        RecyclerView p;
        a<? extends u> q;
        private int s;
        private int t;

        @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
        public static int a(String r0, String r1) {
            return Log.e(r0, r1);
        }

        static {
            r = Collections.emptyList();
        }

        public u(View r4) {
            this.f2392c = -1;
            this.f2393d = -1;
            this.f2394e = -1;
            this.f = -1;
            this.g = -1;
            this.h = null;
            this.i = null;
            this.k = null;
            this.l = null;
            this.s = 0;
            this.m = null;
            this.n = false;
            this.t = 0;
            this.o = -1;
            if (r4 == null) goto L7;
            this.f2390a = r4;
            return;
        L7:
            throw new IllegalArgumentException("itemView may not be null");
        }

        void a(int r2, int r3, boolean r4) {
            b(8);
            a(r3, r4);
            this.f2392c = r2;
        }

        void a(int r3, boolean r4) {
            if (this.f2393d != (-1)) goto L6;
            this.f2393d = this.f2392c;
        L6:
            if (this.g != (-1)) goto L8;
            this.g = this.f2392c;
        L8:
            if (r4 == false) goto L10;
            this.g += r3;
        L10:
            this.f2392c += r3;
            if (this.f2390a.getLayoutParams() == null) goto L14;
            ((LayoutParams) ZeusTransformUtils.preCheckCast(this.f2390a.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).mInsetsDirty = true;
            return;
        }

        void a() {
            this.f2393d = -1;
            this.g = -1;
        }

        void b() {
            if (this.f2393d != (-1)) goto L6;
            this.f2393d = this.f2392c;
            return;
        }

        boolean c() {
            if ((this.j & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Deprecated
        public final int d() {
            int r0 = this.g;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            return this.f2392c;
        }

        public final int e() {
            int r0 = this.g;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            return this.f2392c;
        }

        public final int f() {
            if (this.q != null) goto L5;
            return -1;
        L5:
            RecyclerView r0 = this.p;
            if (r0 != null) goto L8;
            return -1;
        L8:
            a r1 = r0.getAdapter();
            if (r1 != null) goto L11;
            return -1;
        L11:
            int r2 = this.p.getAdapterPositionInRecyclerView(this);
            if (r2 != (-1)) goto L15;
            return -1;
        L15:
            return r1.a(this.q, this, r2);
        }

        public final int g() {
            RecyclerView r0 = this.p;
            if (r0 != null) goto L7;
            return -1;
        L7:
            return r0.getAdapterPositionInRecyclerView(this);
        }

        public final a<? extends u> h() {
            return this.q;
        }

        public final int i() {
            return this.f2393d;
        }

        public final long j() {
            return this.f2394e;
        }

        public final int k() {
            return this.f;
        }

        boolean l() {
            if (this.m == null) goto L5;
            return true;
        L5:
            return false;
        }

        void m() {
            this.m.c(this);
        }

        boolean n() {
            if ((this.j & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        void o() {
            this.j &= -33;
        }

        void p() {
            this.j &= -257;
        }

        void a(n r1, boolean r2) {
            this.m = r1;
            this.n = r2;
        }

        boolean q() {
            if ((this.j & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean r() {
            if ((this.j & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean s() {
            if ((this.j & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        boolean t() {
            if ((this.j & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean a(int r1) {
            if ((this.j & r1) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean u() {
            if ((this.j & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean v() {
            if (this.f2390a.getParent() != null) goto L5;
        L7:
            return false;
        L5:
            if (this.f2390a.getParent() == this.p) goto L7;
            return true;
        }

        boolean w() {
            if ((this.j & 512) == 0) goto L5;
        L8:
            return true;
        L5:
            if (q() == true) goto L8;
            return false;
        }

        void a(int r3, int r4) {
            int r5 = r3 & r4;
            this.j = r5 | (this.j & (~r4));
        }

        void b(int r2) {
            this.j = r2 | this.j;
        }

        void a(Object r3) {
            if (r3 != null) goto L6;
            b(1024);
            return;
        L6:
            if ((1024 & this.j) != 0) goto L10;
            E();
            this.k.add(r3);
            return;
        }

        private void E() {
            if (this.k != null) goto L6;
            ArrayList r0 = new ArrayList();
            this.k = r0;
            this.l = Collections.unmodifiableList(r0);
            return;
        }

        void x() {
            List<Object> r0 = this.k;
            if (r0 == null) goto L5;
            r0.clear();
        L5:
            this.j &= -1025;
        }

        List<Object> y() {
            if ((this.j & 1024) != 0) goto L14;
            List<Object> r0 = this.k;
            if (r0 == null) goto L12;
            if (r0.size() == 0) goto L12;
            return this.l;
        L12:
            return r;
        L14:
            return r;
        }

        void z() {
            this.j = 0;
            this.f2392c = -1;
            this.f2393d = -1;
            this.f2394e = -1;
            this.g = -1;
            this.s = 0;
            this.h = null;
            this.i = null;
            x();
            this.t = 0;
            this.o = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
        }

        void a(RecyclerView r3) {
            int r0 = this.o;
            if (r0 == (-1)) goto L5;
            this.t = r0;
        L6:
            r3.setChildImportantForAccessibilityInternal(this, 4);
            return;
        L5:
            this.t = ViewCompat.g(this.f2390a);
            goto L6
        }

        void b(RecyclerView r2) {
            r2.setChildImportantForAccessibilityInternal(this, this.t);
            this.t = 0;
        }

        public String toString() {
            if (getClass().isAnonymousClass() == false) goto L5;
            String r0 = "ViewHolder";
        L6:
            StringBuilder r1 = new StringBuilder(r0 + "{" + Integer.toHexString(hashCode()) + " position=" + this.f2392c + " id=" + this.f2394e + ", oldPos=" + this.f2393d + ", pLpos:" + this.g);
            if (l() == false) goto L14;
            StringBuilder r2 = r1.append(" scrap ");
            if (this.n == false) goto L11;
            String r3 = "[changeScrap]";
        L12:
            r2.append(r3);
            goto L14
        L11:
            r3 = "[attachedScrap]";
        L14:
            if (q() == false) goto L17;
            r1.append(" invalid");
        L17:
            if (s() == true) goto L20;
            r1.append(" unbound");
        L20:
            if (r() == false) goto L23;
            r1.append(" update");
        L23:
            if (t() == false) goto L26;
            r1.append(" removed");
        L26:
            if (c() == false) goto L29;
            r1.append(" ignored");
        L29:
            if (u() == false) goto L32;
            r1.append(" tmpDetached");
        L32:
            if (A() == true) goto L35;
            r1.append(" not recyclable(" + this.s + ")");
        L35:
            if (w() == false) goto L38;
            r1.append(" undefined adapter position");
        L38:
            if (this.f2390a.getParent() != null) goto L40;
            r1.append(" no parent");
        L40:
            r1.append("}");
            return r1.toString();
        L5:
            r0 = getClass().getSimpleName();
            goto L6
        }

        public final void a(boolean r3) {
            int r1 = this.s;
            if (r3 == false) goto L5;
            int r2 = r1 - 1;
        L6:
            this.s = r2;
            if (r2 >= 0) goto L9;
            this.s = 0;
            a("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            return;
        L9:
            if (r3 == true) goto L12;
            if (r2 != 1) goto L12;
            this.j |= 16;
            return;
        L12:
            if (r3 == false) goto L18;
            if (r2 != 0) goto L19;
            this.j &= -17;
            return;
        L19:
            return;
        L18:
            return;
        L5:
            r2 = r1 + 1;
            goto L6
        }

        public final boolean A() {
            if ((this.j & 16) == 0) goto L5;
        L7:
            return false;
        L5:
            if (ViewCompat.e(this.f2390a) == true) goto L7;
            return true;
        }

        boolean B() {
            if ((this.j & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean C() {
            if ((this.j & 16) == 0) goto L5;
        L7:
            return false;
        L5:
            if (ViewCompat.e(this.f2390a) == false) goto L7;
            return true;
        }

        boolean D() {
            if ((this.j & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public static /* synthetic */ int access$002(String r0, String r1) {
        return Log.e(r0, r1);
    }

    public static /* synthetic */ int access$003(String r0, String r1, Throwable r2) {
        return Log.w(r0, r1, r2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public void onChildAttachedToWindow(View r1) {
    }

    public void onChildDetachedFromWindow(View r1) {
    }

    public void onScrollStateChanged(int r1) {
    }

    public void onScrolled(int r1, int r2) {
    }

    static /* synthetic */ void access$000(RecyclerView r0, View r1, int r2, ViewGroup.LayoutParams r3) {
        r0.attachViewToParent(r1, r2, r3);
    }

    static /* synthetic */ void access$100(RecyclerView r0, int r1) {
        r0.detachViewFromParent(r1);
    }

    static /* synthetic */ boolean access$200(RecyclerView r0) {
        return r0.awakenScrollBars();
    }

    static /* synthetic */ void access$300(RecyclerView r0, int r1, int r2) {
        r0.setMeasuredDimension(r1, r2);
    }

    static {
        NESTED_SCROLLING_ATTRS = new int[]{android.R.attr.nestedScrollingEnabled};
        if (Build.VERSION.SDK_INT != 18) goto L5;
    L10:
        boolean r1 = true;
    L11:
        FORCE_INVALIDATE_DISPLAY_LIST = r1;
        if (Build.VERSION.SDK_INT < 23) goto L14;
        boolean r2 = true;
    L15:
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = r2;
        if (Build.VERSION.SDK_INT < 16) goto L18;
        boolean r3 = true;
    L19:
        POST_UPDATES_ON_ANIMATION = r3;
        if (Build.VERSION.SDK_INT < 21) goto L22;
        boolean r4 = true;
    L23:
        ALLOW_THREAD_GAP_WORK = r4;
        if (Build.VERSION.SDK_INT > 15) goto L26;
        boolean r5 = true;
    L27:
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = r5;
        if (Build.VERSION.SDK_INT > 15) goto L30;
        boolean r6 = true;
    L31:
        IGNORE_DETACHED_FOCUSED_CHILD = r6;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        sQuinticInterpolator = new AnonymousClass3();
        return;
    L30:
        r6 = false;
        goto L31
    L26:
        r5 = false;
        goto L27
    L22:
        r4 = false;
        goto L23
    L18:
        r3 = false;
        goto L19
    L14:
        r2 = false;
        goto L15
    L5:
        if (Build.VERSION.SDK_INT == 19) goto L10;
        if (Build.VERSION.SDK_INT == 20) goto L10;
        r1 = false;
        goto L11
    }

    public RecyclerView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public RecyclerView(Context r4, AttributeSet r5) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.attr.recyclerViewStyle, "attr", "recyclerViewStyle"));
    }

    public RecyclerView(Context r13, AttributeSet r14, int r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r13, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r17 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r14, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r16, r17, r15);
        this.mObserver = new p(this);
        this.mRecycler = new n(this);
        this.mViewInfoStore = new ac();
        this.mUpdateChildViewsRunnable = new AnonymousClass1(this);
        this.mTempRect = new Rect();
        this.mTempRect2 = new Rect();
        this.mTempRectF = new RectF();
        this.mRecyclerListeners = new ArrayList();
        this.mItemDecorations = new ArrayList();
        this.mOnItemTouchListeners = new ArrayList();
        this.mInterceptRequestLayoutDepth = 0;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mLayoutOrScrollCounter = 0;
        this.mDispatchScrollCounter = 0;
        this.mEdgeEffectFactory = new d();
        this.mItemAnimator = new androidx.recyclerview.widget.i();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        boolean r10 = true;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new t(this);
        if (ALLOW_THREAD_GAP_WORK == false) goto L5;
        androidx.recyclerview.widget.l.a r2 = new androidx.recyclerview.widget.l.a();
    L6:
        this.mPrefetchRegistry = r2;
        this.mState = new r();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new f(this);
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mItemAnimatorRunner = new AnonymousClass2(this);
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mViewInfoProcessCallback = new AnonymousClass4(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration r3 = ViewConfiguration.get(r16);
        this.mTouchSlop = r3.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = androidx.core.view.z.a(r3, r16);
        this.mScaledVerticalScrollFactor = androidx.core.view.z.b(r3, r16);
        this.mMinFlingVelocity = r3.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = r3.getScaledMaximumFlingVelocity();
        if (getOverScrollMode() != 2) goto L9;
        boolean r4 = true;
    L10:
        setWillNotDraw(r4);
        this.mItemAnimator.a(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (ViewCompat.g(this) != 0) goto L13;
        ViewCompat.c(this, 1);
    L13:
        this.mAccessibilityManager = (AccessibilityManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("accessibility"), AccessibilityManager.class, "com.obric.aiagent.plugin");
        setAccessibilityDelegateCompat(new w(this));
        TypedArray r11 = r16.obtainStyledAttributes(r17, R.styleable.RecyclerView, r15, 0);
        ViewCompat.a(this, r16, R.styleable.RecyclerView, r17, r11, r15, 0);
        String r5 = r11.getString(ZeusTransformUtils.mapRes(R.styleable.RecyclerView_layoutManager, "styleable", "RecyclerView_layoutManager"));
        if (r11.getInt(ZeusTransformUtils.mapRes(R.styleable.RecyclerView_android_descendantFocusability, "styleable", "RecyclerView_android_descendantFocusability"), -1) != (-1)) goto L16;
        setDescendantFocusability(262144);
    L16:
        this.mClipToPadding = r11.getBoolean(ZeusTransformUtils.mapRes(R.styleable.RecyclerView_android_clipToPadding, "styleable", "RecyclerView_android_clipToPadding"), true);
        boolean r6 = r11.getBoolean(ZeusTransformUtils.mapRes(R.styleable.RecyclerView_fastScrollEnabled, "styleable", "RecyclerView_fastScrollEnabled"), false);
        this.mEnableFastScroller = r6;
        if (r6 == false) goto L19;
        initFastScroller((StateListDrawable) ZeusTransformUtils.preCheckCast(r11.getDrawable(ZeusTransformUtils.mapRes(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable, "styleable", "RecyclerView_fastScrollVerticalThumbDrawable")), StateListDrawable.class, "com.obric.aiagent.plugin"), r11.getDrawable(ZeusTransformUtils.mapRes(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable, "styleable", "RecyclerView_fastScrollVerticalTrackDrawable")), (StateListDrawable) ZeusTransformUtils.preCheckCast(r11.getDrawable(ZeusTransformUtils.mapRes(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable, "styleable", "RecyclerView_fastScrollHorizontalThumbDrawable")), StateListDrawable.class, "com.obric.aiagent.plugin"), r11.getDrawable(ZeusTransformUtils.mapRes(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable, "styleable", "RecyclerView_fastScrollHorizontalTrackDrawable")));
    L19:
        r11.recycle();
        createLayoutManager(r16, r5, r17, r15, 0);
        if (Build.VERSION.SDK_INT < 21) goto L22;
        int[] r7 = NESTED_SCROLLING_ATTRS;
        TypedArray r1 = r16.obtainStyledAttributes(r17, r7, r15, 0);
        ViewCompat.a(this, r16, r7, r17, r1, r15, 0);
        r10 = r1.getBoolean(0, true);
        r1.recycle();
    L22:
        setNestedScrollingEnabled(r10);
        return;
    L9:
        r4 = false;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    private void initAutofill() {
        if (ViewCompat.a(this) != 0) goto L6;
        ViewCompat.b(this, 8);
        return;
    }

    public w getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void setAccessibilityDelegateCompat(w r1) {
        this.mAccessibilityDelegate = r1;
        ViewCompat.a(this, r1);
    }

    private void createLayoutManager(Context r9, String r10, AttributeSet r11, int r12, int r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r15 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L36;
        String r16 = r10.trim();
        if (r16.isEmpty() == true) goto L42;
        String r17 = getFullClassName(r14, r16);
    L21:
        e = move-exception;
        throw new IllegalStateException(r15.getPositionDescription() + ": Class is not a LayoutManager " + r17, e);
    L33:
        e = move-exception;
        throw new IllegalStateException(r15.getPositionDescription() + ": Unable to find LayoutManager " + r17, e);
    L24:
        e = move-exception;
        throw new IllegalStateException(r15.getPositionDescription() + ": Cannot access non-public constructor " + r17, e);
    L27:
        e = move-exception;
        throw new IllegalStateException(r15.getPositionDescription() + ": Could not instantiate the LayoutManager: " + r17, e);
    L30:
        e = move-exception;
        throw new IllegalStateException(r15.getPositionDescription() + ": Could not instantiate the LayoutManager: " + r17, e);
    L8:
        if (isInEditMode() == false) goto L10;
        ClassLoader r1 = getClass().getClassLoader();     // Catch: ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
    L11:
        Class<? extends U> r2 = Class.forName(r17, false, r1).asSubclass(h.class);     // Catch: ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
        Object[] r4 = null;
        Constructor r6 = r2.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);     // Catch: NoSuchMethodException -> L15 ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
        r4 = new Object[]{r14, r15, Integer.valueOf(r12), Integer.valueOf(r13)};     // Catch: NoSuchMethodException -> L15 ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
    L17:
        r6.setAccessible(true);     // Catch: ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
        setLayoutManager((h) ZeusTransformUtils.preCheckCast(r6.newInstance(r4), h.class, "com.obric.aiagent.plugin"));     // Catch: ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
        return;
    L15:
        e = move-exception;
        r6 = r2.getConstructor(new Class[0]);     // Catch: NoSuchMethodException -> L18 ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
    L18:
        e = move-exception;
        e.initCause(e);     // Catch: ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
        throw new IllegalStateException(r15.getPositionDescription() + ": Error creating LayoutManager " + r17, e);     // Catch: ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
    L10:
        r1 = r14.getClassLoader();     // Catch: ClassCastException -> L21 IllegalAccessException -> L24 InstantiationException -> L27 InvocationTargetException -> L30 ClassNotFoundException -> L33
        goto L11
    L42:
        return;
    }

    private String getFullClassName(Context r2, String r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3.charAt(0) != '.') goto L7;
        return r1.getPackageName() + r3;
    L7:
        if (r3.contains(".") == false) goto L10;
        return r3;
    L10:
        return RecyclerView.class.getPackage().getName() + '.' + r3;
    }

    private void initChildrenHelper() {
        this.mChildHelper = new androidx.recyclerview.widget.f(new AnonymousClass5(this));
    }

    void initAdapterManager() {
        this.mAdapterHelper = new androidx.recyclerview.widget.a(new AnonymousClass6(this));
    }

    public void setHasFixedSize(boolean r1) {
        this.mHasFixedSize = r1;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean r2) {
        if (r2 == this.mClipToPadding) goto L5;
        invalidateGlows();
    L5:
        this.mClipToPadding = r2;
        super.setClipToPadding(r2);
        if (this.mFirstLayoutComplete == false) goto L9;
        requestLayout();
        return;
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public void setScrollingTouchSlop(int r4) {
        ViewConfiguration r0 = ViewConfiguration.get((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        if (r4 != 0) goto L5;
    L8:
        this.mTouchSlop = r0.getScaledTouchSlop();
        return;
    L5:
        if (r4 == 1) goto L7;
        INVOKESTATIC_androidx_recyclerview_widget_RecyclerView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "setScrollingTouchSlop(): bad argument constant " + r4 + "; using default value");
        goto L8
    L7:
        this.mTouchSlop = r0.getScaledPagingTouchSlop();
    }

    public void swapAdapter(a r2, boolean r3) {
        setLayoutFrozen(false);
        setAdapterInternal(r2, true, r3);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void setAdapter(a r3) {
        setLayoutFrozen(false);
        setAdapterInternal(r3, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    void removeAndRecycleViews() {
        e r0 = this.mItemAnimator;
        if (r0 == null) goto L5;
        r0.d();
    L5:
        h r1 = this.mLayout;
        if (r1 == null) goto L8;
        r1.c(this.mRecycler);
        this.mLayout.b(this.mRecycler);
    L8:
        this.mRecycler.a();
    }

    private void setAdapterInternal(a r3, boolean r4, boolean r5) {
        a r0 = this.mAdapter;
        if (r0 == null) goto L5;
        r0.b(this.mObserver);
        this.mAdapter.b(this);
    L5:
        if (r4 == false) goto L7;
        if (r5 == true) goto L7;
    L8:
        this.mAdapterHelper.a();
        a r6 = this.mAdapter;
        this.mAdapter = r3;
        if (r3 == null) goto L11;
        r3.a(this.mObserver);
        r3.a(this);
    L11:
        h r7 = this.mLayout;
        if (r7 == null) goto L14;
        r7.a(r6, this.mAdapter);
    L14:
        this.mRecycler.a(r6, this.mAdapter, r4);
        this.mState.f = true;
        return;
    L7:
        removeAndRecycleViews();
        goto L8
    }

    public a getAdapter() {
        return this.mAdapter;
    }

    @Deprecated
    public void setRecyclerListener(o r3) {
        this.mRecyclerListener = (o) ZeusTransformUtils.wrapperContextForParams(r3, o.class, "com.obric.aiagent.plugin");
    }

    public void addRecyclerListener(o r3) {
        o r4 = (o) ZeusTransformUtils.wrapperContextForParams(r3, o.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L5;
        boolean r0 = true;
    L6:
        androidx.core.util.g.a(r0, "'listener' arg cannot be null.");
        this.mRecyclerListeners.add(r4);
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void removeRecyclerListener(o r3) {
        o r4 = (o) ZeusTransformUtils.wrapperContextForParams(r3, o.class, "com.obric.aiagent.plugin");
        this.mRecyclerListeners.remove(r4);
    }

    @Override // android.view.View
    public int getBaseline() {
        h r0 = this.mLayout;
        if (r0 == null) goto L7;
        return r0.w();
    L7:
        return super.getBaseline();
    }

    public void addOnChildAttachStateChangeListener(i r3) {
        i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
        if (this.mOnChildAttachStateListeners != null) goto L5;
        this.mOnChildAttachStateListeners = new ArrayList();
    L5:
        this.mOnChildAttachStateListeners.add(r4);
    }

    public void removeOnChildAttachStateChangeListener(i r3) {
        i r4 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.aiagent.plugin");
        List<i> r2 = this.mOnChildAttachStateListeners;
        if (r2 != null) goto L5;
        return;
    L5:
        r2.remove(r4);
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<i> r0 = this.mOnChildAttachStateListeners;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public void setLayoutManager(h r3) {
        if (r3 != this.mLayout) goto L5;
        return;
    L5:
        stopScroll();
        if (this.mLayout == null) goto L14;
        e r0 = this.mItemAnimator;
        if (r0 == null) goto L10;
        r0.d();
    L10:
        this.mLayout.c(this.mRecycler);
        this.mLayout.b(this.mRecycler);
        this.mRecycler.a();
        if (this.mIsAttached == false) goto L13;
        this.mLayout.b(this, this.mRecycler);
    L13:
        this.mLayout.b(null);
        this.mLayout = null;
    L15:
        this.mChildHelper.a();
        this.mLayout = r3;
        if (r3 != null) goto L18;
    L24:
        this.mRecycler.b();
        requestLayout();
        return;
    L18:
        if (r3.q != null) goto L23;
        this.mLayout.b(this);
        if (this.mIsAttached == false) goto L24;
        this.mLayout.c(this);
        goto L24
    L23:
        throw new IllegalArgumentException("LayoutManager " + r3 + " is already attached to a RecyclerView:" + r3.q.exceptionLabel());
    L14:
        this.mRecycler.a();
        goto L15
    }

    public void setOnFlingListener(j r1) {
        this.mOnFlingListener = r1;
    }

    public j getOnFlingListener() {
        return this.mOnFlingListener;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState(super.onSaveInstanceState());
        SavedState r1 = this.mPendingSavedState;
        if (r1 == null) goto L5;
        r0.copyFrom(r1);
    L9:
        return r0;
    L5:
        h r2 = this.mLayout;
        if (r2 == null) goto L8;
        r0.mLayoutState = r2.e();
        goto L9
    L8:
        r0.mLayoutState = null;
        goto L9
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r3) {
        Parcelable r4 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SavedState.class) == true) goto L6;
        super.onRestoreInstanceState(r4);
        return;
    L6:
        SavedState r5 = (SavedState) ZeusTransformUtils.preCheckCast(r4, SavedState.class, "com.obric.aiagent.plugin");
        this.mPendingSavedState = r5;
        super.onRestoreInstanceState(r5.getSuperState());
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> r1) {
        dispatchFreezeSelfOnly(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> r1) {
        dispatchThawSelfOnly(r1);
    }

    private void addAnimatingView(u r6) {
        View r0 = r6.f2390a;
        if (r0.getParent() != this) goto L5;
        boolean r1 = true;
    L6:
        this.mRecycler.c(getChildViewHolder(r0));
        if (r6.u() == false) goto L9;
        this.mChildHelper.a(r0, -1, r0.getLayoutParams(), true);
        return;
    L9:
        if (r1 == true) goto L11;
        this.mChildHelper.a(r0, true);
        return;
    L11:
        this.mChildHelper.d(r0);
        return;
    L5:
        r1 = false;
        goto L6
    }

    boolean removeAnimatingView(View r3) {
        startInterceptRequestLayout();
        boolean r0 = this.mChildHelper.f(r3);
        if (r0 == false) goto L5;
        u r4 = getChildViewHolderInt(r3);
        this.mRecycler.c(r4);
        this.mRecycler.b(r4);
    L5:
        stopInterceptRequestLayout(!r0);
        return r0;
    }

    public h getLayoutManager() {
        return this.mLayout;
    }

    public m getRecycledViewPool() {
        return this.mRecycler.g();
    }

    public void setRecycledViewPool(m r1) {
        this.mRecycler.a(r1);
    }

    public void setViewCacheExtension(s r1) {
        this.mRecycler.a(r1);
    }

    public void setItemViewCacheSize(int r1) {
        this.mRecycler.a(r1);
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    void setScrollState(int r2) {
        if (r2 != this.mScrollState) goto L5;
        return;
    L5:
        this.mScrollState = r2;
        if (r2 == 2) goto L8;
        stopScrollersInternal();
    L8:
        dispatchOnScrollStateChanged(r2);
    }

    public void addItemDecoration(g r3, int r4) {
        h r0 = this.mLayout;
        if (r0 == null) goto L6;
        r0.a("Cannot add item decoration during a scroll  or layout");
    L6:
        if (this.mItemDecorations.isEmpty() == false) goto L8;
        setWillNotDraw(false);
    L8:
        if (r4 >= 0) goto L10;
        this.mItemDecorations.add(r3);
    L11:
        markItemDecorInsetsDirty();
        requestLayout();
        return;
    L10:
        this.mItemDecorations.add(r4, r3);
        goto L11
    }

    public void addItemDecoration(g r2) {
        addItemDecoration(r2, -1);
    }

    public g getItemDecorationAt(int r3) {
        int r0 = getItemDecorationCount();
        if (r3 < 0) goto L8;
        if (r3 >= r0) goto L8;
        return (g) ZeusTransformUtils.preCheckCast(this.mItemDecorations.get(r3), g.class, "com.obric.aiagent.plugin");
    L8:
        throw new IndexOutOfBoundsException(r3 + " is an invalid index for size " + r0);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    public void removeItemDecorationAt(int r3) {
        int r0 = getItemDecorationCount();
        if (r3 < 0) goto L8;
        if (r3 >= r0) goto L8;
        removeItemDecoration(getItemDecorationAt(r3));
        return;
    L8:
        throw new IndexOutOfBoundsException(r3 + " is an invalid index for size " + r0);
    }

    public void removeItemDecoration(g r3) {
        h r0 = this.mLayout;
        if (r0 == null) goto L5;
        r0.a("Cannot remove item decoration during a scroll  or layout");
    L5:
        this.mItemDecorations.remove(r3);
        if (this.mItemDecorations.isEmpty() == true) goto L8;
    L12:
        markItemDecorInsetsDirty();
        requestLayout();
        return;
    L8:
        if (getOverScrollMode() != 2) goto L10;
        boolean r4 = true;
    L11:
        setWillNotDraw(r4);
        goto L12
    L10:
        r4 = false;
        goto L11
    }

    public void setChildDrawingOrderCallback(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        if (r4 != this.mChildDrawingOrderCallback) goto L5;
        return;
    L5:
        this.mChildDrawingOrderCallback = r4;
        if (r4 == null) goto L8;
        boolean r5 = true;
    L9:
        setChildrenDrawingOrderEnabled(r5);
        return;
    L8:
        r5 = false;
        goto L9
    }

    @Deprecated
    public void setOnScrollListener(l r1) {
        this.mScrollListener = r1;
    }

    public void addOnScrollListener(l r2) {
        if (this.mScrollListeners != null) goto L5;
        this.mScrollListeners = new ArrayList();
    L5:
        this.mScrollListeners.add(r2);
    }

    public void removeOnScrollListener(l r1) {
        List<l> r0 = this.mScrollListeners;
        if (r0 == null) goto L6;
        r0.remove(r1);
        return;
    }

    public void clearOnScrollListeners() {
        List<l> r0 = this.mScrollListeners;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public void scrollToPosition(int r2) {
        if (this.mLayoutSuppressed == false) goto L5;
        return;
    L5:
        stopScroll();
        h r0 = this.mLayout;
        if (r0 != null) goto L9;
        INVOKESTATIC_androidx_recyclerview_widget_RecyclerView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L9:
        r0.e(r2);
        awakenScrollBars();
    }

    void jumpToPositionForSmoothScroller(int r2) {
        if (this.mLayout != null) goto L5;
        return;
    L5:
        setScrollState(2);
        this.mLayout.e(r2);
        awakenScrollBars();
    }

    public void smoothScrollToPosition(int r3) {
        if (this.mLayoutSuppressed == false) goto L5;
        return;
    L5:
        h r0 = this.mLayout;
        if (r0 != null) goto L9;
        INVOKESTATIC_androidx_recyclerview_widget_RecyclerView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L9:
        r0.a(this, this.mState, r3);
    }

    @Override // android.view.View
    public void scrollTo(int r1, int r2) {
        INVOKESTATIC_androidx_recyclerview_widget_RecyclerView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View
    public void scrollBy(int r4, int r5) {
        h r0 = this.mLayout;
        if (r0 != null) goto L7;
        INVOKESTATIC_androidx_recyclerview_widget_RecyclerView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return;
    L9:
        boolean r1 = r0.f();
        boolean r2 = this.mLayout.g();
        if (r1 == true) goto L13;
        if (r2 == true) goto L13;
        return;
    L13:
        if (r1 == true) goto L16;
        r4 = 0;
    L16:
        if (r2 == true) goto L19;
        r5 = 0;
    L19:
        scrollByInternal(r4, r5, null, 0);
    }

    public void nestedScrollBy(int r3, int r4) {
        nestedScrollByInternal(r3, r4, null, 1);
    }

    private void nestedScrollByInternal(int r12, int r13, MotionEvent r14, int r15) {
        h r0 = this.mLayout;
        if (r0 != null) goto L7;
        INVOKESTATIC_androidx_recyclerview_widget_RecyclerView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return;
    L9:
        int[] r1 = this.mReusableIntPair;
        int r2 = 0;
        r1[0] = 0;
        r1[1] = 0;
        boolean r3 = r0.f();
        boolean r4 = this.mLayout.g();
        if (r3 == false) goto L12;
        int r5 = 1;
    L13:
        if (r4 == false) goto L15;
        r5 = r5 | 2;
    L15:
        startNestedScroll(r5, r15);
        if (r3 == false) goto L18;
        int r6 = r12;
    L19:
        if (r4 == false) goto L21;
        int r7 = r13;
    L23:
        if (dispatchNestedPreScroll(r6, r7, this.mReusableIntPair, this.mScrollOffset, r15) == false) goto L25;
        int[] r8 = this.mReusableIntPair;
        r12 = r12 - r8[0];
        r13 = r13 - r8[1];
    L25:
        if (r3 == false) goto L27;
        int r9 = r12;
    L28:
        if (r4 == false) goto L30;
        r2 = r13;
    L30:
        scrollByInternal(r9, r2, r14, r15);
        androidx.recyclerview.widget.l r16 = this.mGapWorker;
        if (r16 == null) goto L35;
        if (r12 != 0) goto L34;
        if (r13 == 0) goto L35;
    L34:
        r16.a(this, r12, r13);
    L35:
        stopNestedScroll(r15);
        return;
    L27:
        r9 = 0;
        goto L28
    L21:
        r7 = 0;
        goto L23
    L18:
        r6 = 0;
        goto L19
    L12:
        r5 = 0;
        goto L13
    }

    void scrollStep(int r5, int r6, int[] r7) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        androidx.core.os.n.a(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        if (r5 == 0) goto L5;
        int r8 = this.mLayout.a(r5, this.mRecycler, this.mState);
    L6:
        if (r6 == 0) goto L8;
        int r9 = this.mLayout.b(r6, this.mRecycler, this.mState);
    L9:
        androidx.core.os.n.a();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (r7 == null) goto L13;
        r7[0] = r8;
        r7[1] = r9;
        return;
    L13:
        return;
    L8:
        r9 = 0;
        goto L9
    L5:
        r8 = 0;
        goto L6
    }

    void consumePendingUpdateOperations() {
        if (this.mFirstLayoutComplete == true) goto L5;
    L25:
        androidx.core.os.n.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
        dispatchLayout();
        androidx.core.os.n.a();
        return;
    L5:
        if (this.mDataSetHasChangedAfterLayout == true) goto L25;
        if (this.mAdapterHelper.d() == true) goto L11;
        return;
    L11:
        if (this.mAdapterHelper.a(4) == false) goto L22;
        if (this.mAdapterHelper.a(11) == true) goto L22;
        androidx.core.os.n.a(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mAdapterHelper.b();
        if (this.mLayoutWasDefered == false) goto L17;
    L20:
        stopInterceptRequestLayout(true);
        onExitLayoutOrScroll();
        androidx.core.os.n.a();
        return;
    L17:
        if (hasUpdatedView() == false) goto L19;
        dispatchLayout();
        goto L20
    L19:
        this.mAdapterHelper.c();
    L22:
        if (this.mAdapterHelper.d() == false) goto L28;
        androidx.core.os.n.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
        dispatchLayout();
        androidx.core.os.n.a();
        return;
    }

    private boolean hasUpdatedView() {
        int r0 = this.mChildHelper.b();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L14;
        u r3 = getChildViewHolderInt(this.mChildHelper.b(r2));
        if (r3 == null) goto L13;
        if (r3.c() == true) goto L13;
        if (r3.D() == false) goto L13;
        return true;
    L13:
        r2 = r2 + 1;
        goto L3
    L14:
        return false;
    }

    boolean scrollByInternal(int r19, int r20, MotionEvent r21, int r22) {
        consumePendingUpdateOperations();
        if (this.mAdapter == null) goto L5;
        int[] r0 = this.mReusableIntPair;
        r0[0] = 0;
        r0[1] = 0;
        scrollStep(r19, r20, r0);
        int[] r1 = this.mReusableIntPair;
        int r2 = r1[0];
        int r3 = r1[1];
        int r14 = r3;
        int r15 = r2;
        int r16 = r19 - r2;
        int r17 = r20 - r3;
    L7:
        if (this.mItemDecorations.isEmpty() == true) goto L9;
        invalidate();
    L9:
        int[] r7 = this.mReusableIntPair;
        r7[0] = 0;
        r7[1] = 0;
        dispatchNestedScroll(r15, r14, r16, r17, this.mScrollOffset, r22, r7);
        int[] r4 = this.mReusableIntPair;
        int r5 = r16 - r4[0];
        int r6 = r17 - r4[1];
        if (r4[0] == 0) goto L12;
    L15:
        boolean r8 = true;
    L16:
        int r9 = this.mLastTouchX;
        int[] r10 = this.mScrollOffset;
        this.mLastTouchX = r9 - r10[0];
        this.mLastTouchY -= r10[1];
        int[] r11 = this.mNestedOffsets;
        r11[0] = r11[0] + r10[0];
        r11[1] = r11[1] + r10[1];
        if (getOverScrollMode() == 2) goto L23;
        if (r21 != null) goto L20;
    L22:
        considerReleasingGlowsOnScroll(r19, r20);
        goto L23
    L20:
        if (androidx.core.view.k.a(r21, 8194) == true) goto L22;
        pullGlows(r21.getX(), r5, r21.getY(), r6);
    L23:
        if (r15 != 0) goto L25;
        if (r14 != 0) goto L25;
    L27:
        if (awakenScrollBars() == true) goto L29;
        invalidate();
    L29:
        if (r8 == true) goto L35;
        if (r15 != 0) goto L36;
        if (r14 == 0) goto L34;
        return true;
    L34:
        return false;
    L36:
        return true;
    L35:
        return true;
    L25:
        dispatchOnScrolled(r15, r14);
        goto L27
    L12:
        if (r4[1] != 0) goto L15;
        r8 = false;
        goto L16
    L5:
        r14 = 0;
        r15 = 0;
        r16 = 0;
        r17 = 0;
        goto L7
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        h r0 = this.mLayout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.f() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.d(this.mState);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        h r0 = this.mLayout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.f() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.g(this.mState);
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        h r0 = this.mLayout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.f() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.b(this.mState);
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        h r0 = this.mLayout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.g() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.e(this.mState);
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        h r0 = this.mLayout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.g() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.h(this.mState);
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        h r0 = this.mLayout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.g() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.c(this.mState);
    }

    void startInterceptRequestLayout() {
        int r0 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = r0;
        if (r0 == 1) goto L5;
        return;
    L5:
        if (this.mLayoutSuppressed == true) goto L9;
        this.mLayoutWasDefered = false;
        return;
    }

    void stopInterceptRequestLayout(boolean r4) {
        if (this.mInterceptRequestLayoutDepth >= 1) goto L6;
        this.mInterceptRequestLayoutDepth = 1;
    L6:
        if (r4 == true) goto L11;
        if (this.mLayoutSuppressed == true) goto L11;
        this.mLayoutWasDefered = false;
    L11:
        if (this.mInterceptRequestLayoutDepth != 1) goto L25;
        if (r4 == false) goto L23;
        if (this.mLayoutWasDefered == false) goto L23;
        if (this.mLayoutSuppressed == true) goto L23;
        if (this.mLayout == null) goto L23;
        if (this.mAdapter == null) goto L23;
        dispatchLayout();
    L23:
        if (this.mLayoutSuppressed == true) goto L25;
        this.mLayoutWasDefered = false;
    L25:
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean r10) {
        if (r10 == this.mLayoutSuppressed) goto L16;
        assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
        if (r10 == true) goto L14;
        this.mLayoutSuppressed = false;
        if (this.mLayoutWasDefered == true) goto L9;
    L13:
        this.mLayoutWasDefered = false;
        return;
    L9:
        if (this.mLayout == null) goto L13;
        if (this.mAdapter == null) goto L13;
        requestLayout();
        goto L13
    L14:
        long r3 = SystemClock.uptimeMillis();
        onTouchEvent(MotionEvent.obtain(r3, r3, 3, 0.0f, 0.0f, 0));
        this.mLayoutSuppressed = true;
        this.mIgnoreMotionEventTillDown = true;
        stopScroll();
        return;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Deprecated
    public void setLayoutFrozen(boolean r1) {
        suppressLayout(r1);
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition r4) {
        if (Build.VERSION.SDK_INT < 18) goto L5;
    L20:
        if (r4 != null) goto L24;
        super.setLayoutTransition(null);
        return;
    L24:
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    L5:
        if (r4 != null) goto L9;
        suppressLayout(false);
        return;
    L9:
        if (r4.getAnimator(0) != null) goto L20;
        if (r4.getAnimator(1) != null) goto L20;
        if (r4.getAnimator(2) != null) goto L20;
        if (r4.getAnimator(3) != null) goto L20;
        if (r4.getAnimator(4) != null) goto L20;
        suppressLayout(true);
    }

    public void smoothScrollBy(int r2, int r3) {
        smoothScrollBy(r2, r3, null);
    }

    public void smoothScrollBy(int r3, int r4, Interpolator r5) {
        smoothScrollBy(r3, r4, (Interpolator) ZeusTransformUtils.wrapperContextForParams(r5, Interpolator.class, "com.obric.aiagent.plugin"), Integer.MIN_VALUE);
    }

    public void smoothScrollBy(int r7, int r8, Interpolator r9, int r10) {
        smoothScrollBy(r7, r8, (Interpolator) ZeusTransformUtils.wrapperContextForParams(r9, Interpolator.class, "com.obric.aiagent.plugin"), r10, false);
    }

    void smoothScrollBy(int r4, int r5, Interpolator r6, int r7, boolean r8) {
        Interpolator r9 = (Interpolator) ZeusTransformUtils.wrapperContextForParams(r6, Interpolator.class, "com.obric.aiagent.plugin");
        h r0 = this.mLayout;
        if (r0 != null) goto L7;
        INVOKESTATIC_androidx_recyclerview_widget_RecyclerView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return;
    L9:
        int r1 = 0;
        if (r0.f() == true) goto L13;
        r4 = 0;
    L13:
        if (this.mLayout.g() == true) goto L15;
        r5 = 0;
    L15:
        if (r4 != 0) goto L18;
        if (r5 != 0) goto L18;
        return;
    L18:
        if (r7 == Integer.MIN_VALUE) goto L22;
        if (r7 > 0) goto L22;
        boolean r2 = false;
    L23:
        if (r2 == false) goto L31;
        if (r8 == false) goto L30;
        if (r4 == 0) goto L27;
        r1 = 1;
    L27:
        if (r5 == 0) goto L29;
        r1 = r1 | 2;
    L29:
        startNestedScroll(r1, 1);
    L30:
        this.mViewFlinger.a(r4, r5, r7, r9);
        return;
    L31:
        scrollBy(r4, r5);
        return;
    L22:
        r2 = true;
        goto L23
    }

    public boolean fling(int r8, int r9) {
        h r0 = this.mLayout;
        int r1 = 0;
        if (r0 != null) goto L7;
        INVOKESTATIC_androidx_recyclerview_widget_RecyclerView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return false;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return false;
    L9:
        boolean r2 = r0.f();
        boolean r3 = this.mLayout.g();
        if (r2 == true) goto L12;
    L13:
        r8 = 0;
    L14:
        if (r3 == true) goto L16;
    L17:
        r9 = 0;
    L18:
        if (r8 != 0) goto L21;
        if (r9 != 0) goto L21;
        return false;
    L21:
        float r4 = r8;
        float r5 = r9;
        if (dispatchNestedPreFling(r4, r5) == false) goto L24;
    L41:
        return false;
    L24:
        if (r2 == true) goto L28;
        if (r3 == true) goto L28;
        boolean r6 = false;
    L29:
        dispatchNestedFling(r4, r5, r6);
        j r7 = this.mOnFlingListener;
        if (r7 != null) goto L32;
    L34:
        if (r6 == false) goto L41;
        if (r2 == false) goto L37;
        r1 = 1;
    L37:
        if (r3 == false) goto L39;
        r1 = r1 | 2;
    L39:
        startNestedScroll(r1, 1);
        int r10 = this.mMaxFlingVelocity;
        int r11 = Math.max(-r10, Math.min(r8, r10));
        int r12 = this.mMaxFlingVelocity;
        this.mViewFlinger.a(r11, Math.max(-r12, Math.min(r9, r12)));
        return true;
    L32:
        if (r7.a(r8, r9) == false) goto L34;
        return true;
    L28:
        r6 = true;
        goto L29
    L16:
        if (Math.abs(r9) >= this.mMinFlingVelocity) goto L18;
    L12:
        if (Math.abs(r8) >= this.mMinFlingVelocity) goto L14;
        goto L13
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.b();
        h r1 = this.mLayout;
        if (r1 == null) goto L6;
        r1.K();
        return;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    private void pullGlows(float r7, float r8, float r9, float r10) {
        boolean r3 = true;
        if (r8 >= 0.0f) goto L7;
        ensureLeftGlow();
        androidx.core.widget.c.a(this.mLeftGlow, (-r8) / getWidth(), 1.0f - (r9 / getHeight()));
    L5:
        boolean r11 = true;
    L11:
        if (r10 >= 0.0f) goto L14;
        ensureTopGlow();
        androidx.core.widget.c.a(this.mTopGlow, (-r10) / getHeight(), r7 / getWidth());
    L17:
        if (r3 == false) goto L19;
    L22:
        ViewCompat.f(this);
        return;
    L19:
        if (r8 != 0.0f) goto L22;
        if (r10 != 0.0f) goto L22;
        return;
    L14:
        if (r10 <= 0.0f) goto L16;
        ensureBottomGlow();
        androidx.core.widget.c.a(this.mBottomGlow, r10 / getHeight(), 1.0f - (r7 / getWidth()));
        goto L17
    L16:
        r3 = r11;
        goto L17
    L7:
        if (r8 <= 0.0f) goto L9;
        ensureRightGlow();
        androidx.core.widget.c.a(this.mRightGlow, r8 / getWidth(), r9 / getHeight());
        goto L5
    L9:
        r11 = false;
        goto L11
    }

    private void releaseGlows() {
        EdgeEffect r0 = this.mLeftGlow;
        if (r0 == null) goto L5;
        r0.onRelease();
        boolean r1 = this.mLeftGlow.isFinished();
    L6:
        EdgeEffect r2 = this.mTopGlow;
        if (r2 == null) goto L9;
        r2.onRelease();
        r1 = r1 | this.mTopGlow.isFinished();
    L9:
        EdgeEffect r3 = this.mRightGlow;
        if (r3 == null) goto L12;
        r3.onRelease();
        r1 = r1 | this.mRightGlow.isFinished();
    L12:
        EdgeEffect r4 = this.mBottomGlow;
        if (r4 == null) goto L15;
        r4.onRelease();
        r1 = r1 | this.mBottomGlow.isFinished();
    L15:
        if (r1 == false) goto L18;
        ViewCompat.f(this);
        return;
    L18:
        return;
    L5:
        r1 = false;
        goto L6
    }

    void considerReleasingGlowsOnScroll(int r3, int r4) {
        EdgeEffect r0 = this.mLeftGlow;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = false;
    L9:
        EdgeEffect r2 = this.mRightGlow;
        if (r2 != null) goto L12;
    L15:
        EdgeEffect r5 = this.mTopGlow;
        if (r5 != null) goto L18;
    L21:
        EdgeEffect r6 = this.mBottomGlow;
        if (r6 != null) goto L24;
    L27:
        if (r1 == false) goto L30;
        ViewCompat.f(this);
        return;
    L30:
        return;
    L24:
        if (r6.isFinished() == true) goto L27;
        if (r4 >= 0) goto L27;
        this.mBottomGlow.onRelease();
        r1 = r1 | this.mBottomGlow.isFinished();
        goto L27
    L18:
        if (r5.isFinished() == true) goto L21;
        if (r4 <= 0) goto L21;
        this.mTopGlow.onRelease();
        r1 = r1 | this.mTopGlow.isFinished();
        goto L21
    L12:
        if (r2.isFinished() == true) goto L15;
        if (r3 >= 0) goto L15;
        this.mRightGlow.onRelease();
        r1 = r1 | this.mRightGlow.isFinished();
        goto L15
    L5:
        if (r0.isFinished() == true) goto L8;
        if (r3 <= 0) goto L8;
        this.mLeftGlow.onRelease();
        r1 = this.mLeftGlow.isFinished();
        goto L9
    }

    void absorbGlows(int r3, int r4) {
        if (r3 >= 0) goto L6;
        ensureLeftGlow();
        if (this.mLeftGlow.isFinished() == false) goto L10;
        this.mLeftGlow.onAbsorb(-r3);
    L10:
        if (r4 >= 0) goto L14;
        ensureTopGlow();
        if (this.mTopGlow.isFinished() == false) goto L18;
        this.mTopGlow.onAbsorb(-r4);
    L18:
        if (r3 != 0) goto L20;
        if (r4 != 0) goto L20;
        return;
    L20:
        ViewCompat.f(this);
        return;
    L14:
        if (r4 <= 0) goto L18;
        ensureBottomGlow();
        if (this.mBottomGlow.isFinished() == false) goto L18;
        this.mBottomGlow.onAbsorb(r4);
        goto L18
    L6:
        if (r3 <= 0) goto L10;
        ensureRightGlow();
        if (this.mRightGlow.isFinished() == false) goto L10;
        this.mRightGlow.onAbsorb(r3);
        goto L10
    }

    void ensureLeftGlow() {
        if (this.mLeftGlow == null) goto L5;
        return;
    L5:
        EdgeEffect r0 = this.mEdgeEffectFactory.a(this, 0);
        this.mLeftGlow = r0;
        if (this.mClipToPadding == false) goto L8;
        r0.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        return;
    L8:
        r0.setSize(getMeasuredHeight(), getMeasuredWidth());
    }

    void ensureRightGlow() {
        if (this.mRightGlow == null) goto L5;
        return;
    L5:
        EdgeEffect r0 = this.mEdgeEffectFactory.a(this, 2);
        this.mRightGlow = r0;
        if (this.mClipToPadding == false) goto L8;
        r0.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        return;
    L8:
        r0.setSize(getMeasuredHeight(), getMeasuredWidth());
    }

    void ensureTopGlow() {
        if (this.mTopGlow == null) goto L5;
        return;
    L5:
        EdgeEffect r0 = this.mEdgeEffectFactory.a(this, 1);
        this.mTopGlow = r0;
        if (this.mClipToPadding == false) goto L8;
        r0.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        return;
    L8:
        r0.setSize(getMeasuredWidth(), getMeasuredHeight());
    }

    void ensureBottomGlow() {
        if (this.mBottomGlow == null) goto L5;
        return;
    L5:
        EdgeEffect r0 = this.mEdgeEffectFactory.a(this, 3);
        this.mBottomGlow = r0;
        if (this.mClipToPadding == false) goto L8;
        r0.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        return;
    L8:
        r0.setSize(getMeasuredWidth(), getMeasuredHeight());
    }

    void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void setEdgeEffectFactory(d r1) {
        androidx.core.util.g.a(r1);
        this.mEdgeEffectFactory = r1;
        invalidateGlows();
    }

    public d getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View r9, int r10) {
        View r0 = this.mLayout.d(r9, r10);
        if (r0 == null) goto L5;
        return r0;
    L5:
        boolean r1 = true;
        if (this.mAdapter != null) goto L8;
    L14:
        boolean r2 = false;
    L15:
        FocusFinder r3 = FocusFinder.getInstance();
        if (r2 == true) goto L18;
    L61:
        View r4 = r3.findNextFocus(this, r9, r10);
        if (r4 != null) goto L68;
        if (r2 == false) goto L68;
        consumePendingUpdateOperations();
        if (findContainingItemView(r9) != null) goto L67;
        return null;
    L67:
        startInterceptRequestLayout();
        View r5 = this.mLayout.a(r9, r10, this.mRecycler, this.mState);
        stopInterceptRequestLayout(false);
    L69:
        if (r5 == null) goto L79;
        if (r5.hasFocusable() == true) goto L79;
        if (getFocusedChild() == null) goto L75;
        requestChildOnScreen(r5, null);
        return r9;
    L75:
        return super.focusSearch(r9, r10);
    L79:
        if (isPreferredNextFocus(r9, r5, r10) == false) goto L82;
        return r5;
    L82:
        return super.focusSearch(r9, r10);
    L68:
        r5 = r4;
        goto L69
    L18:
        if (r10 == 2) goto L21;
        if (r10 != 1) goto L61;
    L21:
        if (this.mLayout.g() == false) goto L32;
        if (r10 != 2) goto L24;
        int r6 = ApWakeEvent.ACCELERATING_START;
    L26:
        if (r3.findNextFocus(this, r9, r6) != null) goto L28;
        boolean r7 = true;
    L30:
        if (FORCE_ABS_FOCUS_SEARCH_DIRECTION == false) goto L33;
        r10 = r6;
    L33:
        if (r7 == false) goto L35;
    L55:
        if (r7 == false) goto L60;
        consumePendingUpdateOperations();
        if (findContainingItemView(r9) != null) goto L59;
        return null;
    L59:
        startInterceptRequestLayout();
        this.mLayout.a(r9, r10, this.mRecycler, this.mState);
        stopInterceptRequestLayout(false);
    L60:
        r5 = r3.findNextFocus(this, r9, r10);
        goto L69
    L35:
        if (this.mLayout.f() == false) goto L55;
        if (this.mLayout.v() != 1) goto L39;
        boolean r8 = true;
    L40:
        if (r10 != 2) goto L42;
        boolean r11 = true;
    L44:
        if ((r8 ^ r11) == false) goto L46;
        int r12 = 66;
    L48:
        if (r3.findNextFocus(this, r9, r12) == null) goto L52;
        r1 = false;
    L52:
        if (FORCE_ABS_FOCUS_SEARCH_DIRECTION == false) goto L54;
        r10 = r12;
    L54:
        r7 = r1;
        goto L55
    L46:
        r12 = 17;
        goto L48
    L42:
        r11 = false;
        goto L44
    L39:
        r8 = false;
        goto L40
    L28:
        r7 = false;
        goto L30
    L24:
        r6 = 33;
        goto L26
    L32:
        r7 = false;
        goto L33
    L8:
        if (this.mLayout == null) goto L14;
        if (isComputingLayout() == true) goto L14;
        if (this.mLayoutSuppressed == true) goto L14;
        r2 = true;
        goto L15
    }

    private boolean isPreferredNextFocus(View r6, View r7, int r8) {
        if (r7 == null) goto L93;
        if (r7 == this) goto L94;
        if (r7 != r6) goto L8;
        return false;
    L8:
        if (findContainingItemView(r7) != null) goto L11;
        return false;
    L11:
        if (r6 != null) goto L14;
        return true;
    L14:
        if (findContainingItemView(r6) != null) goto L16;
        return true;
    L16:
        this.mTempRect.set(0, 0, r6.getWidth(), r6.getHeight());
        this.mTempRect2.set(0, 0, r7.getWidth(), r7.getHeight());
        offsetDescendantRectToMyCoords(r6, this.mTempRect);
        offsetDescendantRectToMyCoords(r7, this.mTempRect2);
        byte r9 = -1;
        if (this.mLayout.v() != 1) goto L19;
        int r10 = -1;
    L21:
        if (this.mTempRect.left < this.mTempRect2.left) goto L25;
        if (this.mTempRect.right <= this.mTempRect2.left) goto L25;
    L28:
        if (this.mTempRect.right > this.mTempRect2.right) goto L32;
        if (this.mTempRect.left >= this.mTempRect2.right) goto L32;
    L34:
        int r2 = 0;
    L36:
        if (this.mTempRect.top < this.mTempRect2.top) goto L40;
        if (this.mTempRect.bottom <= this.mTempRect2.top) goto L40;
    L43:
        if (this.mTempRect.bottom > this.mTempRect2.bottom) goto L47;
        if (this.mTempRect.top >= this.mTempRect2.bottom) goto L47;
    L49:
        r9 = 0;
    L50:
        if (r8 != 1) goto L52;
        if (r9 < 0) goto L86;
        if (r9 == 0) goto L84;
        return false;
    L84:
        if ((r2 * r10) < 0) goto L86;
        return false;
    L86:
        return true;
    L52:
        if (r8 != 2) goto L54;
        if (r9 > 0) goto L80;
        if (r9 == 0) goto L78;
        return false;
    L78:
        if ((r2 * r10) > 0) goto L80;
        return false;
    L80:
        return true;
    L54:
        if (r8 != 17) goto L56;
        if (r2 < 0) goto L74;
        return false;
    L74:
        return true;
    L56:
        if (r8 != 33) goto L58;
        if (r9 < 0) goto L71;
        return false;
    L71:
        return true;
    L58:
        if (r8 != 66) goto L60;
        if (r2 > 0) goto L68;
        return false;
    L68:
        return true;
    L60:
        if (r8 != 130) goto L65;
        if (r9 > 0) goto L63;
        return false;
    L63:
        return true;
    L65:
        throw new IllegalArgumentException("Invalid direction: " + r8 + exceptionLabel());
    L47:
        if (this.mTempRect.top <= this.mTempRect2.top) goto L49;
    L40:
        if (this.mTempRect.bottom >= this.mTempRect2.bottom) goto L43;
        r9 = 1;
    L32:
        if (this.mTempRect.left <= this.mTempRect2.left) goto L34;
        r2 = -1;
    L25:
        if (this.mTempRect.right >= this.mTempRect2.right) goto L28;
        r2 = 1;
        goto L36
    L19:
        r10 = 1;
        goto L21
    L94:
        return false;
    L93:
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View r3, View r4) {
        if (this.mLayout.a(this, this.mState, r3, r4) == true) goto L6;
        if (r4 == null) goto L6;
        requestChildOnScreen(r3, r4);
    L6:
        super.requestChildFocus(r3, r4);
    }

    private void requestChildOnScreen(View r12, View r13) {
        if (r13 == null) goto L4;
        View r0 = r13;
    L5:
        this.mTempRect.set(0, 0, r0.getWidth(), r0.getHeight());
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if (ZeusTransformUtils.instanceOf(r1, LayoutParams.class) == false) goto L10;
        LayoutParams r2 = (LayoutParams) ZeusTransformUtils.preCheckCast(r1, LayoutParams.class, "com.obric.aiagent.plugin");
        if (r2.mInsetsDirty == true) goto L10;
        Rect r3 = r2.mDecorInsets;
        this.mTempRect.left -= r3.left;
        this.mTempRect.right += r3.right;
        this.mTempRect.top -= r3.top;
        this.mTempRect.bottom += r3.bottom;
    L10:
        if (r13 == null) goto L12;
        offsetDescendantRectToMyCoords(r13, this.mTempRect);
        offsetRectIntoDescendantCoords(r12, this.mTempRect);
    L12:
        h r5 = this.mLayout;
        Rect r8 = this.mTempRect;
        boolean r9 = !this.mFirstLayoutComplete;
        if (r13 != null) goto L15;
        boolean r10 = true;
    L16:
        r5.a(this, r12, r8, r9, r10);
        return;
    L15:
        r10 = false;
        goto L16
    L4:
        r0 = r12;
        goto L5
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View r2, Rect r3, boolean r4) {
        return this.mLayout.a(this, r2, r3, r4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> r2, int r3, int r4) {
        h r0 = this.mLayout;
        if (r0 != null) goto L5;
    L6:
        super.addFocusables(r2, r3, r4);
        return;
    L5:
        if (r0.a(this, r2, r3, r4) == false) goto L6;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int r2, Rect r3) {
        if (isComputingLayout() == false) goto L7;
        return false;
    L7:
        return super.onRequestFocusInDescendants(r2, r3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        boolean r1 = true;
        this.mIsAttached = true;
        if (this.mFirstLayoutComplete == true) goto L5;
    L7:
        r1 = false;
    L8:
        this.mFirstLayoutComplete = r1;
        h r2 = this.mLayout;
        if (r2 == null) goto L11;
        r2.c(this);
    L11:
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK == false) goto L24;
        androidx.recyclerview.widget.l r0 = (androidx.recyclerview.widget.l) ZeusTransformUtils.preCheckCast(androidx.recyclerview.widget.l.f2548a.get(), androidx.recyclerview.widget.l.class, "com.obric.aiagent.plugin");
        this.mGapWorker = r0;
        if (r0 != null) goto L22;
        this.mGapWorker = new androidx.recyclerview.widget.l();
        Display r3 = ViewCompat.K(this);
        float r4 = 60.0f;
        if (isInEditMode() == true) goto L21;
        if (r3 == null) goto L21;
        float r5 = r3.getRefreshRate();
        if (r5 < 30.0f) goto L21;
        r4 = r5;
    L21:
        this.mGapWorker.f2552d = (long) (1.0E9f / r4);
        androidx.recyclerview.widget.l.f2548a.set(this.mGapWorker);
    L22:
        this.mGapWorker.a(this);
        return;
    L24:
        return;
    L5:
        if (isLayoutRequested() == true) goto L7;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e r0 = this.mItemAnimator;
        if (r0 == null) goto L5;
        r0.d();
    L5:
        stopScroll();
        this.mIsAttached = false;
        h r1 = this.mLayout;
        if (r1 == null) goto L8;
        r1.b(this, this.mRecycler);
    L8:
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.b();
        if (ALLOW_THREAD_GAP_WORK == false) goto L14;
        androidx.recyclerview.widget.l r2 = this.mGapWorker;
        if (r2 == null) goto L15;
        r2.b(this);
        this.mGapWorker = null;
        return;
    L15:
        return;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    void assertInLayoutOrScroll(String r3) {
        if (isComputingLayout() == true) goto L9;
        if (r3 != null) goto L8;
        throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
    L8:
        throw new IllegalStateException(r3 + exceptionLabel());
    }

    void assertNotInLayoutOrScroll(String r3) {
        if (isComputingLayout() == false) goto L10;
        if (r3 != null) goto L8;
        throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
    L8:
        throw new IllegalStateException(r3);
    L10:
        if (this.mDispatchScrollCounter <= 0) goto L13;
        INVOKESTATIC_androidx_recyclerview_widget_RecyclerView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
        return;
    }

    public void addOnItemTouchListener(k r3) {
        k r4 = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.aiagent.plugin");
        this.mOnItemTouchListeners.add(r4);
    }

    public void removeOnItemTouchListener(k r3) {
        k r4 = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.aiagent.plugin");
        this.mOnItemTouchListeners.remove(r4);
        if (this.mInterceptingOnItemTouchListener != r4) goto L6;
        this.mInterceptingOnItemTouchListener = null;
        return;
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent r3) {
        k r0 = this.mInterceptingOnItemTouchListener;
        if (r0 == null) goto L5;
        r0.b(this, r3);
        int r4 = r3.getAction();
        if (r4 == 3) goto L13;
        if (r4 == 1) goto L13;
    L14:
        return true;
    L13:
        this.mInterceptingOnItemTouchListener = null;
        goto L14
    L5:
        if (r3.getAction() != 0) goto L9;
        return false;
    L9:
        return findInterceptingOnItemTouchListener(r3);
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent r8) {
        int r0 = r8.getAction();
        int r1 = this.mOnItemTouchListeners.size();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        k r4 = (k) ZeusTransformUtils.preCheckCast(this.mOnItemTouchListeners.get(r3), k.class, "com.obric.aiagent.plugin");
        if (r4.a(this, r8) == false) goto L10;
        if (r0 == 3) goto L10;
        this.mInterceptingOnItemTouchListener = r4;
        return true;
    L10:
        r3 = r3 + 1;
        goto L3
    L11:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r9) {
        if (this.mLayoutSuppressed == false) goto L5;
        return false;
    L5:
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(r9) == false) goto L9;
        cancelScroll();
        return true;
    L9:
        h r0 = this.mLayout;
        if (r0 != null) goto L12;
        return false;
    L12:
        boolean r1 = r0.f();
        boolean r3 = this.mLayout.g();
        if (this.mVelocityTracker != null) goto L15;
        this.mVelocityTracker = VelocityTracker.obtain();
    L15:
        this.mVelocityTracker.addMovement(r9);
        int r4 = r9.getActionMasked();
        int r5 = r9.getActionIndex();
        if (r4 == 0) goto L49;
        if (r4 == 1) goto L47;
        if (r4 != 2) goto L20;
        int r6 = r9.findPointerIndex(this.mScrollPointerId);
        if (r6 >= 0) goto L33;
        INVOKESTATIC_androidx_recyclerview_widget_RecyclerView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
        return false;
    L33:
        int r7 = (int) (r9.getX(r6) + 0.5f);
        int r10 = (int) (r9.getY(r6) + 0.5f);
        if (this.mScrollState == 1) goto L59;
        int r8 = r7 - this.mInitialTouchX;
        int r11 = r10 - this.mInitialTouchY;
        if (r1 == true) goto L38;
    L40:
        boolean r2 = false;
    L41:
        if (r3 == true) goto L43;
    L45:
        if (r2 == false) goto L59;
        setScrollState(1);
        goto L59
    L43:
        if (Math.abs(r11) <= this.mTouchSlop) goto L45;
        this.mLastTouchY = r10;
        r2 = true;
        goto L45
    L38:
        if (Math.abs(r8) <= this.mTouchSlop) goto L40;
        this.mLastTouchX = r7;
        r2 = true;
    L59:
        if (this.mScrollState == 1) goto L61;
        return false;
    L61:
        return true;
    L20:
        if (r4 != 3) goto L22;
        cancelScroll();
        goto L59
    L22:
        if (r4 != 5) goto L24;
        this.mScrollPointerId = r9.getPointerId(r5);
        int r12 = (int) (r9.getX(r5) + 0.5f);
        this.mLastTouchX = r12;
        this.mInitialTouchX = r12;
        int r13 = (int) (r9.getY(r5) + 0.5f);
        this.mLastTouchY = r13;
        this.mInitialTouchY = r13;
        goto L59
    L24:
        if (r4 != 6) goto L59;
        onPointerUp(r9);
        goto L59
    L47:
        this.mVelocityTracker.clear();
        stopNestedScroll(0);
        goto L59
    L49:
        if (this.mIgnoreMotionEventTillDown == false) goto L51;
        this.mIgnoreMotionEventTillDown = false;
    L51:
        this.mScrollPointerId = r9.getPointerId(0);
        int r14 = (int) (r9.getX() + 0.5f);
        this.mLastTouchX = r14;
        this.mInitialTouchX = r14;
        int r15 = (int) (r9.getY() + 0.5f);
        this.mLastTouchY = r15;
        this.mInitialTouchY = r15;
        if (this.mScrollState != 2) goto L54;
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
        stopNestedScroll(1);
    L54:
        int[] r16 = this.mNestedOffsets;
        r16[1] = 0;
        r16[0] = 0;
        int r17 = r1;
        if (r3 == false) goto L57;
        r17 = (r1 ? 1 : 0) | 2;
    L57:
        startNestedScroll(r17, 0);
        goto L59
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r6) {
        int r0 = this.mOnItemTouchListeners.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((k) ZeusTransformUtils.preCheckCast(this.mOnItemTouchListeners.get(r1), k.class, "com.obric.aiagent.plugin")).a(r6);
        r1 = r1 + 1;
        goto L3
    L5:
        super.requestDisallowInterceptTouchEvent(r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r18) {
        boolean r8 = false;
        if (this.mLayoutSuppressed == false) goto L5;
    L106:
        return false;
    L5:
        if (this.mIgnoreMotionEventTillDown == true) goto L106;
        if (dispatchToOnItemTouchListeners(r18) == false) goto L11;
        cancelScroll();
        return true;
    L11:
        h r0 = this.mLayout;
        if (r0 != null) goto L14;
        return false;
    L14:
        boolean r10 = r0.f();
        boolean r11 = this.mLayout.g();
        if (this.mVelocityTracker != null) goto L17;
        this.mVelocityTracker = VelocityTracker.obtain();
    L17:
        int r1 = r18.getActionMasked();
        int r2 = r18.getActionIndex();
        if (r1 != 0) goto L20;
        int[] r3 = this.mNestedOffsets;
        r3[1] = 0;
        r3[0] = 0;
    L20:
        MotionEvent r12 = MotionEvent.obtain(r18);
        int[] r4 = this.mNestedOffsets;
        r12.offsetLocation(r4[0], r4[1]);
        if (r1 == 0) goto L98;
        if (r1 != 1) goto L24;
        this.mVelocityTracker.addMovement(r12);
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
        if (r10 == false) goto L86;
        float r5 = -this.mVelocityTracker.getXVelocity(this.mScrollPointerId);
    L87:
        if (r11 == false) goto L89;
        float r6 = -this.mVelocityTracker.getYVelocity(this.mScrollPointerId);
    L91:
        if (r5 != 0.0f) goto L95;
        if (r6 != 0.0f) goto L95;
    L96:
        setScrollState(0);
    L97:
        resetScroll();
        r8 = true;
    L102:
        if (r8 == true) goto L104;
        this.mVelocityTracker.addMovement(r12);
    L104:
        r12.recycle();
        return true;
    L95:
        if (fling((int) r5, (int) r6) == true) goto L97;
    L89:
        r6 = 0.0f;
        goto L91
    L86:
        r5 = 0.0f;
        goto L87
    L24:
        if (r1 != 2) goto L26;
        int r7 = r18.findPointerIndex(this.mScrollPointerId);
        if (r7 >= 0) goto L39;
        INVOKESTATIC_androidx_recyclerview_widget_RecyclerView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
        return false;
    L39:
        int r13 = (int) (r18.getX(r7) + 0.5f);
        int r14 = (int) (r18.getY(r7) + 0.5f);
        int r9 = this.mLastTouchX - r13;
        int r15 = this.mLastTouchY - r14;
        if (this.mScrollState == 1) goto L56;
        if (r10 == false) goto L47;
        if (r9 <= 0) goto L44;
        r9 = Math.max(0, r9 - this.mTouchSlop);
    L45:
        if (r9 == 0) goto L47;
        boolean r16 = true;
    L48:
        if (r11 == false) goto L54;
        if (r15 <= 0) goto L51;
        r15 = Math.max(0, r15 - this.mTouchSlop);
    L52:
        if (r15 == 0) goto L54;
        r16 = true;
        goto L54
    L51:
        r15 = Math.min(0, r15 + this.mTouchSlop);
    L54:
        if (r16 == false) goto L56;
        setScrollState(1);
        goto L56
    L44:
        r9 = Math.min(0, r9 + this.mTouchSlop);
    L47:
        r16 = false;
    L56:
        int r17 = r9;
        int r19 = r15;
        if (this.mScrollState != 1) goto L102;
        int[] r20 = this.mReusableIntPair;
        r20[0] = 0;
        r20[1] = 0;
        if (r10 == false) goto L61;
        int r21 = r17;
    L62:
        if (r11 == false) goto L64;
        int r22 = r19;
    L66:
        if (dispatchNestedPreScroll(r21, r22, r20, this.mScrollOffset, 0) == false) goto L68;
        int[] r23 = this.mReusableIntPair;
        r17 = r17 - r23[0];
        r19 = r19 - r23[1];
        int[] r24 = this.mNestedOffsets;
        int r25 = r24[0];
        int[] r26 = this.mScrollOffset;
        r24[0] = r25 + r26[0];
        r24[1] = r24[1] + r26[1];
        getParent().requestDisallowInterceptTouchEvent(true);
    L68:
        int r27 = r19;
        int[] r28 = this.mScrollOffset;
        this.mLastTouchX = r13 - r28[0];
        this.mLastTouchY = r14 - r28[1];
        if (r10 == false) goto L71;
        int r29 = r17;
    L72:
        if (r11 == false) goto L74;
        int r30 = r27;
    L76:
        if (scrollByInternal(r29, r30, r18, 0) == false) goto L78;
        getParent().requestDisallowInterceptTouchEvent(true);
    L78:
        androidx.recyclerview.widget.l r31 = this.mGapWorker;
        if (r31 == null) goto L102;
        if (r17 != 0) goto L82;
        if (r27 == 0) goto L102;
    L82:
        r31.a(this, r17, r27);
        goto L102
    L74:
        r30 = 0;
        goto L76
    L71:
        r29 = 0;
        goto L72
    L64:
        r22 = 0;
        goto L66
    L61:
        r21 = 0;
        goto L62
    L26:
        if (r1 != 3) goto L28;
        cancelScroll();
        goto L102
    L28:
        if (r1 != 5) goto L30;
        this.mScrollPointerId = r18.getPointerId(r2);
        int r32 = (int) (r18.getX(r2) + 0.5f);
        this.mLastTouchX = r32;
        this.mInitialTouchX = r32;
        int r33 = (int) (r18.getY(r2) + 0.5f);
        this.mLastTouchY = r33;
        this.mInitialTouchY = r33;
        goto L102
    L30:
        if (r1 != 6) goto L102;
        onPointerUp(r18);
        goto L102
    L98:
        this.mScrollPointerId = r18.getPointerId(0);
        int r34 = (int) (r18.getX() + 0.5f);
        this.mLastTouchX = r34;
        this.mInitialTouchX = r34;
        int r35 = (int) (r18.getY() + 0.5f);
        this.mLastTouchY = r35;
        this.mInitialTouchY = r35;
        int r110 = r10;
        if (r11 == false) goto L101;
        r110 = (r10 ? 1 : 0) | 2;
    L101:
        startNestedScroll(r110, 0);
        goto L102
    }

    private void resetScroll() {
        VelocityTracker r0 = this.mVelocityTracker;
        if (r0 == null) goto L5;
        r0.clear();
    L5:
        stopNestedScroll(0);
        releaseGlows();
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    private void onPointerUp(MotionEvent r4) {
        int r0 = r4.getActionIndex();
        if (r4.getPointerId(r0) != this.mScrollPointerId) goto L9;
        if (r0 != 0) goto L6;
        int r1 = 1;
    L7:
        this.mScrollPointerId = r4.getPointerId(r1);
        int r2 = (int) (r4.getX(r1) + 0.5f);
        this.mLastTouchX = r2;
        this.mInitialTouchX = r2;
        int r5 = (int) (r4.getY(r1) + 0.5f);
        this.mLastTouchY = r5;
        this.mInitialTouchY = r5;
        return;
    L6:
        r1 = 0;
        goto L7
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent r6) {
        if (this.mLayout != null) goto L6;
        return false;
    L6:
        if (this.mLayoutSuppressed == false) goto L9;
        return false;
    L9:
        if (r6.getAction() == 8) goto L11;
    L34:
        return false;
    L11:
        if ((r6.getSource() & 2) == 0) goto L21;
        if (this.mLayout.g() == false) goto L15;
        float r0 = -r6.getAxisValue(9);
    L17:
        if (this.mLayout.f() == false) goto L19;
        float r3 = r6.getAxisValue(10);
    L30:
        if (r0 == 0.0f) goto L32;
    L33:
        nestedScrollByInternal((int) (r3 * this.mScaledHorizontalScrollFactor), (int) (r0 * this.mScaledVerticalScrollFactor), r6, 1);
        goto L34
    L32:
        if (r3 == 0.0f) goto L34;
    L19:
        r3 = 0.0f;
        goto L30
    L15:
        r0 = 0.0f;
        goto L17
    L21:
        if ((r6.getSource() & UiType.FLAG_NO_FEEDBACK) == 0) goto L28;
        float r1 = r6.getAxisValue(26);
        if (this.mLayout.g() == false) goto L26;
        r0 = -r1;
        goto L19
    L26:
        if (this.mLayout.f() == false) goto L28;
        r3 = r1;
        r0 = 0.0f;
    L28:
        r0 = 0.0f;
        r3 = 0.0f;
        goto L30
    }

    @Override // android.view.View
    public void onMeasure(int r8, int r9) {
        h r0 = this.mLayout;
        if (r0 != null) goto L6;
        defaultOnMeasure(r8, r9);
        return;
    L6:
        boolean r2 = false;
        if (r0.d() == false) goto L26;
        int r1 = View.MeasureSpec.getMode(r8);
        int r3 = View.MeasureSpec.getMode(r9);
        this.mLayout.a(this.mRecycler, this.mState, r8, r9);
        if (r1 != 1073741824) goto L12;
        if (r3 != 1073741824) goto L12;
        r2 = true;
    L12:
        this.mLastAutoMeasureSkippedDueToExact = r2;
        if (r2 == false) goto L15;
        return;
    L15:
        if (this.mAdapter != null) goto L18;
        return;
    L18:
        if (this.mState.f2383d != 1) goto L20;
        dispatchLayoutStep1();
    L20:
        this.mLayout.c(r8, r9);
        this.mState.i = true;
        dispatchLayoutStep2();
        this.mLayout.d(r8, r9);
        if (this.mLayout.n() == false) goto L23;
        this.mLayout.c(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        this.mState.i = true;
        dispatchLayoutStep2();
        this.mLayout.d(r8, r9);
    L23:
        this.mLastAutoMeasureNonExactMeasuredWidth = getMeasuredWidth();
        this.mLastAutoMeasureNonExactMeasuredHeight = getMeasuredHeight();
        return;
    L26:
        if (this.mHasFixedSize == false) goto L30;
        this.mLayout.a(this.mRecycler, this.mState, r8, r9);
        return;
    L30:
        if (this.mAdapterUpdateDuringMeasure == false) goto L37;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        onExitLayoutOrScroll();
        if (this.mState.k == false) goto L34;
        this.mState.g = true;
    L35:
        this.mAdapterUpdateDuringMeasure = false;
        stopInterceptRequestLayout(false);
    L40:
        a r4 = this.mAdapter;
        if (r4 == null) goto L43;
        this.mState.f2384e = r4.a();
    L44:
        startInterceptRequestLayout();
        this.mLayout.a(this.mRecycler, this.mState, r8, r9);
        stopInterceptRequestLayout(false);
        this.mState.g = false;
        return;
    L43:
        this.mState.f2384e = 0;
        goto L44
    L34:
        this.mAdapterHelper.e();
        this.mState.g = false;
        goto L35
    L37:
        if (this.mState.k == false) goto L40;
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    void defaultOnMeasure(int r3, int r4) {
        setMeasuredDimension(h.a(r3, getPaddingLeft() + getPaddingRight(), ViewCompat.n(this)), h.a(r4, getPaddingTop() + getPaddingBottom(), ViewCompat.o(this)));
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (r1 != r3) goto L5;
        if (r2 != r4) goto L5;
        return;
    L5:
        invalidateGlows();
    }

    public void setItemAnimator(e r3) {
        e r0 = this.mItemAnimator;
        if (r0 == null) goto L5;
        r0.d();
        this.mItemAnimator.a(null);
    L5:
        this.mItemAnimator = r3;
        if (r3 == null) goto L9;
        r3.a(this.mItemAnimatorListener);
        return;
    }

    void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    void onExitLayoutOrScroll(boolean r3) {
        int r0 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = r0;
        if (r0 >= 1) goto L8;
        this.mLayoutOrScrollCounter = 0;
        if (r3 == false) goto L9;
        dispatchContentChangedIfNecessary();
        dispatchPendingImportantForAccessibilityChanges();
        return;
    L9:
        return;
    }

    boolean isAccessibilityEnabled() {
        AccessibilityManager r0 = this.mAccessibilityManager;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isEnabled() == false) goto L7;
        return true;
    }

    private void dispatchContentChangedIfNecessary() {
        int r0 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (r0 != 0) goto L5;
        return;
    L5:
        if (isAccessibilityEnabled() == false) goto L9;
        AccessibilityEvent r1 = AccessibilityEvent.obtain();
        r1.setEventType(2048);
        androidx.core.view.accessibility.a.a(r1, r0);
        sendAccessibilityEventUnchecked(r1);
        return;
    }

    public boolean isComputingLayout() {
        if (this.mLayoutOrScrollCounter <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean shouldDeferAccessibilityEvent(AccessibilityEvent r3) {
        int r1 = 0;
        if (isComputingLayout() == false) goto L12;
        if (r3 == null) goto L6;
        int r4 = androidx.core.view.accessibility.a.a(r3);
    L7:
        if (r4 == 0) goto L10;
        r1 = r4;
    L10:
        this.mEatenAccessibilityChangeFlags |= r1;
        return true;
    L6:
        r4 = 0;
        goto L7
    L12:
        return false;
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent r2) {
        if (shouldDeferAccessibilityEvent(r2) == false) goto L5;
        return;
    L5:
        super.sendAccessibilityEventUnchecked(r2);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r1) {
        onPopulateAccessibilityEvent(r1);
        return true;
    }

    public e getItemAnimator() {
        return this.mItemAnimator;
    }

    void postAnimationRunner() {
        if (this.mPostedAnimatorRunner == false) goto L5;
        return;
    L5:
        if (this.mIsAttached == false) goto L9;
        ViewCompat.a(this, this.mItemAnimatorRunner);
        this.mPostedAnimatorRunner = true;
        return;
    }

    private boolean predictiveItemAnimationsEnabled() {
        if (this.mItemAnimator != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mLayout.c() == false) goto L7;
        return true;
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        if (this.mDataSetHasChangedAfterLayout == false) goto L8;
        this.mAdapterHelper.a();
        if (this.mDispatchItemsChangedEvent == false) goto L8;
        this.mLayout.a(this);
    L8:
        if (predictiveItemAnimationsEnabled() == false) goto L10;
        this.mAdapterHelper.b();
    L11:
        boolean r1 = false;
        if (this.mItemsAddedOrRemoved == false) goto L14;
    L17:
        boolean r0 = true;
    L18:
        r r3 = this.mState;
        if (this.mFirstLayoutComplete == true) goto L21;
    L32:
        boolean r4 = false;
    L33:
        r3.j = r4;
        r r5 = this.mState;
        if (r5.j == false) goto L41;
        if (r0 == false) goto L41;
        if (this.mDataSetHasChangedAfterLayout == true) goto L41;
        if (predictiveItemAnimationsEnabled() == false) goto L41;
        r1 = true;
    L41:
        r5.k = r1;
        return;
    L21:
        if (this.mItemAnimator == null) goto L32;
        if (this.mDataSetHasChangedAfterLayout == true) goto L28;
        if (r0 == true) goto L28;
        if (this.mLayout.u == false) goto L32;
    L28:
        if (this.mDataSetHasChangedAfterLayout == true) goto L30;
    L31:
        r4 = true;
        goto L33
    L30:
        if (this.mAdapter.b() == false) goto L32;
    L14:
        if (this.mItemsChanged == true) goto L17;
        r0 = false;
        goto L18
    L10:
        this.mAdapterHelper.e();
        goto L11
    }

    void dispatchLayout() {
        if (this.mAdapter != null) goto L7;
        INVOKESTATIC_androidx_recyclerview_widget_RecyclerView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(TAG, "No adapter attached; skipping layout");
        return;
    L7:
        if (this.mLayout != null) goto L10;
        INVOKESTATIC_androidx_recyclerview_widget_RecyclerView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "No layout manager attached; skipping layout");
        return;
    L10:
        this.mState.i = false;
        if (this.mLastAutoMeasureSkippedDueToExact == true) goto L13;
    L17:
        boolean r0 = false;
    L18:
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mLastAutoMeasureSkippedDueToExact = false;
        if (this.mState.f2383d != 1) goto L22;
        dispatchLayoutStep1();
        this.mLayout.f(this);
        dispatchLayoutStep2();
    L31:
        dispatchLayoutStep3();
        return;
    L22:
        if (this.mAdapterHelper.f() == true) goto L30;
        if (r0 == true) goto L30;
        if (this.mLayout.A() != getWidth()) goto L30;
        if (this.mLayout.B() != getHeight()) goto L30;
        this.mLayout.f(this);
    L30:
        this.mLayout.f(this);
        dispatchLayoutStep2();
        goto L31
    L13:
        if (this.mLastAutoMeasureNonExactMeasuredWidth == getWidth()) goto L15;
    L16:
        r0 = true;
        goto L18
    L15:
        if (this.mLastAutoMeasureNonExactMeasuredHeight == getHeight()) goto L17;
        goto L16
    }

    private void saveFocusInfo() {
        u r1 = null;
        if (this.mPreserveFocusAfterLayout == true) goto L5;
    L9:
        View r0 = null;
    L10:
        if (r0 == null) goto L13;
        r1 = findContainingViewHolder(r0);
    L13:
        if (r1 != null) goto L15;
        resetFocusInfo();
        return;
    L15:
        r r2 = this.mState;
        if (this.mAdapter.b() == false) goto L18;
        long r3 = r1.j();
    L19:
        r2.m = r3;
        r r4 = this.mState;
        if (this.mDataSetHasChangedAfterLayout == false) goto L23;
        int r5 = -1;
    L26:
        r4.l = r5;
        this.mState.n = getDeepestFocusedViewWithId(r1.f2390a);
        return;
    L23:
        if (r1.t() == false) goto L25;
        r5 = r1.f2393d;
        goto L26
    L25:
        r5 = r1.g();
        goto L26
    L18:
        r3 = -1;
        goto L19
    L5:
        if (hasFocus() == false) goto L9;
        if (this.mAdapter == null) goto L9;
        r0 = getFocusedChild();
        goto L10
    }

    private void resetFocusInfo() {
        this.mState.m = -1;
        this.mState.l = -1;
        this.mState.n = -1;
    }

    private View findNextViewToFocus() {
        if (this.mState.l == (-1)) goto L5;
        int r0 = this.mState.l;
    L6:
        int r1 = this.mState.e();
        int r2 = r0;
    L7:
        if (r2 >= r1) goto L16;
        u r3 = findViewHolderForAdapterPosition(r2);
        if (r3 == null) goto L16;
        if (r3.f2390a.hasFocusable() == true) goto L14;
        r2 = r2 + 1;
        goto L7
    L14:
        return r3.f2390a;
    L16:
        int r4 = Math.min(r1, r0);
    L17:
        r4 = r4 - 1;
        if (r4 < 0) goto L27;
        u r5 = findViewHolderForAdapterPosition(r4);
        if (r5 == null) goto L21;
        if (r5.f2390a.hasFocusable() == false) goto L17;
        return r5.f2390a;
    L21:
        return null;
    L27:
        return null;
    L5:
        r0 = 0;
        goto L6
    }

    private void recoverFocusFromState() {
        if (this.mPreserveFocusAfterLayout == true) goto L5;
        return;
    L5:
        if (this.mAdapter != null) goto L7;
        return;
    L7:
        if (hasFocus() == true) goto L9;
        return;
    L9:
        if (getDescendantFocusability() != 393216) goto L11;
        return;
    L11:
        if (getDescendantFocusability() != 131072) goto L16;
        if (isFocused() == false) goto L16;
        return;
    L16:
        if (isFocused() == true) goto L30;
        View r0 = getFocusedChild();
        if (IGNORE_DETACHED_FOCUSED_CHILD == false) goto L28;
        if (r0.getParent() == null) goto L24;
        if (r0.hasFocus() == true) goto L28;
    L24:
        if (this.mChildHelper.b() != 0) goto L30;
        requestFocus();
        return;
    L28:
        if (this.mChildHelper.c(r0) == true) goto L30;
        return;
    L30:
        View r1 = null;
        if (this.mState.m != (-1)) goto L33;
    L35:
        u r2 = null;
    L36:
        if (r2 == null) goto L44;
        if (this.mChildHelper.c(r2.f2390a) == true) goto L44;
        if (r2.f2390a.hasFocusable() == false) goto L44;
        r1 = r2.f2390a;
    L46:
        if (r1 != null) goto L48;
        return;
    L48:
        if (this.mState.n == (-1)) goto L54;
        View r6 = r1.findViewById(this.mState.n);
        if (r6 == null) goto L54;
        if (r6.isFocusable() == false) goto L54;
        r1 = r6;
    L54:
        r1.requestFocus();
        return;
    L44:
        if (this.mChildHelper.b() <= 0) goto L46;
        r1 = findNextViewToFocus();
        goto L46
    L33:
        if (this.mAdapter.b() == false) goto L35;
        r2 = findViewHolderForItemId(this.mState.m);
        goto L36
    }

    private int getDeepestFocusedViewWithId(View r3) {
        int r2 = r3.getId();
    L4:
        if (r3.isFocused() == true) goto L12;
        if (ZeusTransformUtils.instanceOf(r3, ViewGroup.class) == false) goto L12;
        if (r3.hasFocus() == false) goto L12;
        r3 = ((ViewGroup) ZeusTransformUtils.preCheckCast(r3, ViewGroup.class, "com.obric.aiagent.plugin")).getFocusedChild();
        if (r3.getId() == (-1)) goto L4;
        r2 = r3.getId();
    L12:
        return r2;
    }

    final void fillRemainingScrollValues(r r3) {
        if (getScrollState() != 2) goto L5;
        OverScroller r2 = this.mViewFlinger.f2385a;
        r3.o = r2.getFinalX() - r2.getCurrX();
        r3.p = r2.getFinalY() - r2.getCurrY();
        return;
    L5:
        r3.o = 0;
        r3.p = 0;
    }

    private void dispatchLayoutStep1() {
        boolean r1 = true;
        this.mState.a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.i = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.a();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        r r0 = this.mState;
        if (r0.j == true) goto L5;
    L7:
        r1 = false;
    L8:
        r0.h = r1;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        r r2 = this.mState;
        r2.g = r2.k;
        this.mState.f2384e = this.mAdapter.a();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.j == false) goto L32;
        int r3 = this.mChildHelper.b();
        int r4 = 0;
    L11:
        if (r4 >= r3) goto L32;
        u r5 = getChildViewHolderInt(this.mChildHelper.b(r4));
        if (r5.c() == true) goto L30;
        if (r5.q() == true) goto L17;
    L19:
        this.mViewInfoStore.a(r5, this.mItemAnimator.a(this.mState, r5, e.e(r5), r5.y()));
        if (this.mState.h == false) goto L30;
        if (r5.D() == false) goto L30;
        if (r5.t() == true) goto L30;
        if (r5.c() == true) goto L30;
        if (r5.q() == true) goto L30;
        this.mViewInfoStore.a(getChangedHolderKey(r5), r5);
        goto L30
    L17:
        if (this.mAdapter.b() == true) goto L19;
    L30:
        r4 = r4 + 1;
    L32:
        if (this.mState.k == false) goto L50;
        saveOldPositions();
        boolean r6 = this.mState.f;
        this.mState.f = false;
        this.mLayout.c(this.mRecycler, this.mState);
        this.mState.f = r6;
        int r7 = 0;
    L35:
        if (r7 >= this.mChildHelper.b()) goto L49;
        u r8 = getChildViewHolderInt(this.mChildHelper.b(r7));
        if (r8.c() == true) goto L48;
        if (this.mViewInfoStore.d(r8) == true) goto L48;
        int r9 = e.e(r8);
        boolean r10 = r8.a(8192);
        if (r10 == true) goto L44;
        r9 = r9 | 4096;
    L44:
        e.c r11 = this.mItemAnimator.a(this.mState, r8, r9, r8.y());
        if (r10 == false) goto L47;
        recordAnimationInfoIfBouncedHiddenView(r8, r11);
        goto L48
    L47:
        this.mViewInfoStore.b(r8, r11);
    L48:
        r7 = r7 + 1;
        goto L35
    L49:
        clearOldPositions();
    L51:
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f2383d = 2;
        return;
    L50:
        clearOldPositions();
        goto L51
    L5:
        if (this.mItemsChanged == false) goto L7;
        goto L7
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.a(6);
        this.mAdapterHelper.e();
        this.mState.f2384e = this.mAdapter.a();
        this.mState.f2382c = 0;
        if (this.mPendingSavedState != null) goto L5;
    L10:
        this.mState.g = false;
        this.mLayout.c(this.mRecycler, this.mState);
        this.mState.f = false;
        r r0 = this.mState;
        if (r0.j == true) goto L13;
    L15:
        boolean r2 = false;
    L16:
        r0.j = r2;
        this.mState.f2383d = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        return;
    L13:
        if (this.mItemAnimator == null) goto L15;
        r2 = true;
        goto L16
    L5:
        if (this.mAdapter.f() == false) goto L10;
        if (this.mPendingSavedState.mLayoutState == null) goto L9;
        this.mLayout.a(this.mPendingSavedState.mLayoutState);
    L9:
        this.mPendingSavedState = null;
        goto L10
    }

    private void dispatchLayoutStep3() {
        this.mState.a(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.f2383d = 1;
        if (this.mState.j == false) goto L24;
        int r0 = this.mChildHelper.b() - 1;
    L5:
        if (r0 < 0) goto L23;
        u r5 = getChildViewHolderInt(this.mChildHelper.b(r0));
        if (r5.c() == true) goto L22;
        long r2 = getChangedHolderKey(r5);
        e.c r4 = this.mItemAnimator.a(this.mState, r5);
        u r6 = this.mViewInfoStore.a(r2);
        if (r6 != null) goto L12;
    L21:
        this.mViewInfoStore.c(r5, r4);
        goto L22
    L12:
        if (r6.c() == true) goto L21;
        boolean r8 = this.mViewInfoStore.a(r6);
        boolean r9 = this.mViewInfoStore.a(r5);
        if (r8 == false) goto L17;
        if (r6 != r5) goto L17;
        this.mViewInfoStore.c(r5, r4);
    L17:
        e.c r7 = this.mViewInfoStore.b(r6);
        this.mViewInfoStore.c(r5, r4);
        e.c r10 = this.mViewInfoStore.c(r5);
        if (r7 != null) goto L20;
        handleMissingPreInfoForChangeError(r2, r5, r6);
        goto L22
    L20:
        animateChange(r6, r5, r7, r10, r8, r9);
    L22:
        r0 = r0 - 1;
        goto L5
    L23:
        this.mViewInfoStore.a(this.mViewInfoProcessCallback);
    L24:
        this.mLayout.b(this.mRecycler);
        r r1 = this.mState;
        r1.f2381b = r1.f2384e;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mState.j = false;
        this.mState.k = false;
        this.mLayout.u = false;
        if (this.mRecycler.f2365b == null) goto L28;
        this.mRecycler.f2365b.clear();
    L28:
        if (this.mLayout.y == false) goto L30;
        this.mLayout.x = 0;
        this.mLayout.y = false;
        this.mRecycler.b();
    L30:
        this.mLayout.a(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.a();
        int[] r3 = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(r3[0], r3[1]) == false) goto L33;
        dispatchOnScrolled(0, 0);
    L33:
        recoverFocusFromState();
        resetFocusInfo();
    }

    private void handleMissingPreInfoForChangeError(long r6, u r8, u r9) {
        int r0 = this.mChildHelper.b();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L18;
        u r2 = getChildViewHolderInt(this.mChildHelper.b(r1));
        if (r2 == r8) goto L17;
        if (getChangedHolderKey(r2) != r6) goto L17;
        a r7 = this.mAdapter;
        if (r7 == null) goto L16;
        if (r7.b() == false) goto L16;
        throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + r2 + " \n View Holder 2:" + r8 + exceptionLabel());
    L16:
        throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + r2 + " \n View Holder 2:" + r8 + exceptionLabel());
    L17:
        r1 = r1 + 1;
        goto L3
    L18:
        INVOKESTATIC_androidx_recyclerview_widget_RecyclerView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + r9 + " cannot be found but it is necessary for " + r8 + exceptionLabel());
    }

    void recordAnimationInfoIfBouncedHiddenView(u r4, e.c r5) {
        r4.a(0, 8192);
        if (this.mState.h == true) goto L5;
    L11:
        this.mViewInfoStore.a(r4, r5);
        return;
    L5:
        if (r4.D() == false) goto L11;
        if (r4.t() == true) goto L11;
        if (r4.c() == true) goto L11;
        long r0 = getChangedHolderKey(r4);
        this.mViewInfoStore.a(r0, r4);
        goto L11
    }

    private void findMinMaxChildLayoutPositions(int[] r9) {
        int r0 = this.mChildHelper.b();
        if (r0 != 0) goto L6;
        r9[0] = -1;
        r9[1] = -1;
        return;
    L6:
        int r3 = Integer.MAX_VALUE;
        int r4 = Integer.MIN_VALUE;
        int r5 = 0;
    L7:
        if (r5 >= r0) goto L17;
        u r6 = getChildViewHolderInt(this.mChildHelper.b(r5));
        if (r6.c() == true) goto L16;
        int r7 = r6.e();
        if (r7 >= r3) goto L14;
        r3 = r7;
    L14:
        if (r7 <= r4) goto L16;
        r4 = r7;
    L16:
        r5 = r5 + 1;
        goto L7
    L17:
        r9[0] = r3;
        r9[1] = r4;
    }

    private boolean didChildRangeChange(int r4, int r5) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] r3 = this.mMinMaxLayoutPositions;
        if (r3[0] != r4) goto L7;
        if (r3[1] != r5) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View r3, boolean r4) {
        u r0 = getChildViewHolderInt(r3);
        if (r0 != null) goto L5;
    L12:
        r3.clearAnimation();
        dispatchChildDetached(r3);
        super.removeDetachedView(r3, r4);
        return;
    L5:
        if (r0.u() == false) goto L8;
        r0.p();
        goto L12
    L8:
        if (r0.c() == true) goto L12;
        throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + r0 + exceptionLabel());
    }

    long getChangedHolderKey(u r1) {
        if (this.mAdapter.b() == false) goto L6;
        return r1.j();
    L6:
        return r1.f2392c;
    }

    void animateAppearance(u r2, e.c r3, e.c r4) {
        r2.a(false);
        if (this.mItemAnimator.b(r2, r3, r4) == false) goto L6;
        postAnimationRunner();
        return;
    }

    void animateDisappearance(u r2, e.c r3, e.c r4) {
        addAnimatingView(r2);
        r2.a(false);
        if (this.mItemAnimator.a(r2, r3, r4) == false) goto L6;
        postAnimationRunner();
        return;
    }

    private void animateChange(u r2, u r3, e.c r4, e.c r5, boolean r6, boolean r7) {
        r2.a(false);
        if (r6 == false) goto L5;
        addAnimatingView(r2);
    L5:
        if (r2 == r3) goto L10;
        if (r7 == false) goto L8;
        addAnimatingView(r3);
    L8:
        r2.h = r3;
        addAnimatingView(r2);
        this.mRecycler.c(r2);
        r3.a(false);
        r3.i = r2;
    L10:
        if (this.mItemAnimator.a(r2, r3, r4, r5) == false) goto L13;
        postAnimationRunner();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        androidx.core.os.n.a(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        androidx.core.os.n.a();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.mInterceptRequestLayoutDepth == 0) goto L5;
    L7:
        this.mLayoutWasDefered = true;
        return;
    L5:
        if (this.mLayoutSuppressed == true) goto L7;
        super.requestLayout();
    }

    void markItemDecorInsetsDirty() {
        int r0 = this.mChildHelper.c();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((LayoutParams) ZeusTransformUtils.preCheckCast(this.mChildHelper.d(r1).getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).mInsetsDirty = true;
        r1 = r1 + 1;
        goto L3
    L5:
        this.mRecycler.j();
    }

    @Override // android.view.View
    public void draw(Canvas r8) {
        super.draw(r8);
        int r0 = this.mItemDecorations.size();
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        ((g) ZeusTransformUtils.preCheckCast(this.mItemDecorations.get(r2), g.class, "com.obric.aiagent.plugin")).b(r8, this, this.mState);
        r2 = r2 + 1;
        goto L3
    L5:
        EdgeEffect r3 = this.mLeftGlow;
        boolean r4 = true;
        if (r3 != null) goto L8;
    L20:
        boolean r5 = false;
    L21:
        EdgeEffect r6 = this.mTopGlow;
        if (r6 != null) goto L24;
    L35:
        EdgeEffect r7 = this.mRightGlow;
        if (r7 != null) goto L38;
    L50:
        EdgeEffect r9 = this.mBottomGlow;
        if (r9 != null) goto L53;
    L64:
        if (r5 == false) goto L66;
    L72:
        r4 = r5;
    L73:
        if (r4 == false) goto L77;
        ViewCompat.f(this);
        return;
    L77:
        return;
    L66:
        if (this.mItemAnimator == null) goto L72;
        if (this.mItemDecorations.size() <= 0) goto L72;
        if (this.mItemAnimator.b() == false) goto L72;
    L53:
        if (r9.isFinished() == true) goto L64;
        int r10 = r8.save();
        r8.rotate(180.0f);
        if (this.mClipToPadding == false) goto L57;
        r8.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
    L58:
        EdgeEffect r11 = this.mBottomGlow;
        if (r11 != null) goto L61;
    L63:
        r5 = r5 | r1;
        r8.restoreToCount(r10);
        goto L64
    L61:
        if (r11.draw(r8) == false) goto L63;
        r1 = true;
        goto L63
    L57:
        r8.translate(-getWidth(), -getHeight());
        goto L58
    L38:
        if (r7.isFinished() == true) goto L50;
        int r12 = r8.save();
        int r13 = getWidth();
        if (this.mClipToPadding == false) goto L42;
        int r14 = getPaddingTop();
    L43:
        r8.rotate(90.0f);
        r8.translate(r14, -r13);
        EdgeEffect r15 = this.mRightGlow;
        if (r15 != null) goto L46;
    L48:
        boolean r16 = false;
    L49:
        r5 = r5 | r16;
        r8.restoreToCount(r12);
        goto L50
    L46:
        if (r15.draw(r8) == false) goto L48;
        r16 = true;
        goto L49
    L42:
        r14 = 0;
        goto L43
    L24:
        if (r6.isFinished() == true) goto L35;
        int r17 = r8.save();
        if (this.mClipToPadding == false) goto L28;
        r8.translate(getPaddingLeft(), getPaddingTop());
    L28:
        EdgeEffect r18 = this.mTopGlow;
        if (r18 != null) goto L31;
    L33:
        boolean r19 = false;
    L34:
        r5 = r5 | r19;
        r8.restoreToCount(r17);
        goto L35
    L31:
        if (r18.draw(r8) == false) goto L33;
        r19 = true;
        goto L34
    L8:
        if (r3.isFinished() == true) goto L20;
        int r20 = r8.save();
        if (this.mClipToPadding == false) goto L12;
        int r21 = getPaddingBottom();
    L13:
        r8.rotate(270.0f);
        r8.translate((-getHeight()) + r21, 0.0f);
        EdgeEffect r22 = this.mLeftGlow;
        if (r22 != null) goto L16;
    L18:
        r5 = false;
    L19:
        r8.restoreToCount(r20);
        goto L21
    L16:
        if (r22.draw(r8) == false) goto L18;
        r5 = true;
        goto L19
    L12:
        r21 = 0;
        goto L13
    }

    @Override // android.view.View
    public void onDraw(Canvas r6) {
        super.onDraw(r6);
        int r0 = this.mItemDecorations.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((g) ZeusTransformUtils.preCheckCast(this.mItemDecorations.get(r1), g.class, "com.obric.aiagent.plugin")).a(r6, this, this.mState);
        r1 = r1 + 1;
        goto L3
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r3) {
        if (ZeusTransformUtils.instanceOf(r3, LayoutParams.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mLayout.a((LayoutParams) ZeusTransformUtils.preCheckCast(r3, LayoutParams.class, "com.obric.aiagent.plugin")) == false) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        h r0 = this.mLayout;
        if (r0 == null) goto L7;
        return r0.a();
    L7:
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r4) {
        AttributeSet r5 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        h r0 = this.mLayout;
        if (r0 == null) goto L7;
        return r0.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r5);
    L7:
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r3) {
        h r0 = this.mLayout;
        if (r0 == null) goto L7;
        return r0.a(r3);
    L7:
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    public boolean isAnimating() {
        e r0 = this.mItemAnimator;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.b() == false) goto L7;
        return true;
    }

    void saveOldPositions() {
        int r0 = this.mChildHelper.c();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        u r2 = getChildViewHolderInt(this.mChildHelper.d(r1));
        if (r2.c() == true) goto L7;
        r2.b();
    L7:
        r1 = r1 + 1;
        goto L3
    }

    void clearOldPositions() {
        int r0 = this.mChildHelper.c();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        u r2 = getChildViewHolderInt(this.mChildHelper.d(r1));
        if (r2.c() == true) goto L7;
        r2.a();
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        this.mRecycler.i();
    }

    void offsetPositionRecordsForMove(int r10, int r11) {
        int r0 = this.mChildHelper.c();
        if (r10 >= r11) goto L5;
        int r2 = -1;
        int r3 = r10;
        int r4 = r11;
    L6:
        int r6 = 0;
    L7:
        if (r6 >= r0) goto L21;
        u r7 = getChildViewHolderInt(this.mChildHelper.d(r6));
        if (r7 == null) goto L20;
        if (r7.f2392c < r3) goto L20;
        if (r7.f2392c > r4) goto L20;
        if (r7.f2392c != r10) goto L18;
        r7.a(r11 - r10, false);
    L19:
        this.mState.f = true;
        goto L20
    L18:
        r7.a(r2, false);
    L20:
        r6 = r6 + 1;
        goto L7
    L21:
        this.mRecycler.a(r10, r11);
        requestLayout();
        return;
    L5:
        r4 = r10;
        r3 = r11;
        r2 = 1;
        goto L6
    }

    void offsetPositionRecordsForInsert(int r6, int r7) {
        int r0 = this.mChildHelper.c();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        u r3 = getChildViewHolderInt(this.mChildHelper.d(r2));
        if (r3 == null) goto L11;
        if (r3.c() == true) goto L11;
        if (r3.f2392c < r6) goto L11;
        r3.a(r7, false);
        this.mState.f = true;
    L11:
        r2 = r2 + 1;
        goto L3
    L12:
        this.mRecycler.b(r6, r7);
        requestLayout();
    }

    void offsetPositionRecordsForRemove(int r8, int r9, boolean r10) {
        int r0 = r8 + r9;
        int r1 = this.mChildHelper.c();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L15;
        u r3 = getChildViewHolderInt(this.mChildHelper.d(r2));
        if (r3 == null) goto L14;
        if (r3.c() == true) goto L14;
        if (r3.f2392c < r0) goto L12;
        r3.a(-r9, r10);
        this.mState.f = true;
        goto L14
    L12:
        if (r3.f2392c < r8) goto L14;
        r3.a(r8 - 1, -r9, r10);
        this.mState.f = true;
    L14:
        r2 = r2 + 1;
        goto L3
    L15:
        this.mRecycler.a(r8, r9, r10);
        requestLayout();
    }

    void viewRangeUpdate(int r7, int r8, Object r9) {
        int r0 = this.mChildHelper.c();
        int r1 = r7 + r8;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L15;
        View r3 = this.mChildHelper.d(r2);
        u r4 = getChildViewHolderInt(r3);
        if (r4 == null) goto L14;
        if (r4.c() == true) goto L14;
        if (r4.f2392c < r7) goto L14;
        if (r4.f2392c >= r1) goto L14;
        r4.b(2);
        r4.a(r9);
        ((LayoutParams) ZeusTransformUtils.preCheckCast(r3.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).mInsetsDirty = true;
    L14:
        r2 = r2 + 1;
        goto L3
    L15:
        this.mRecycler.c(r7, r8);
    }

    boolean canReuseUpdatedViewHolder(u r2) {
        e r1 = this.mItemAnimator;
        if (r1 != null) goto L5;
    L8:
        return true;
    L5:
        if (r1.a(r2, r2.y()) == true) goto L8;
        return false;
    }

    void processDataSetCompletelyChanged(boolean r2) {
        this.mDispatchItemsChangedEvent = r2 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    void markKnownViewsInvalid() {
        int r0 = this.mChildHelper.c();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        u r2 = getChildViewHolderInt(this.mChildHelper.d(r1));
        if (r2 == null) goto L9;
        if (r2.c() == true) goto L9;
        r2.b(6);
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        markItemDecorInsetsDirty();
        this.mRecycler.h();
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) goto L5;
        return;
    L5:
        h r0 = this.mLayout;
        if (r0 == null) goto L8;
        r0.a("Cannot invalidate item decorations during a scroll or layout");
    L8:
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public void setPreserveFocusAfterLayout(boolean r1) {
        this.mPreserveFocusAfterLayout = r1;
    }

    public u getChildViewHolder(View r4) {
        ViewParent r0 = r4.getParent();
        if (r0 == null) goto L9;
        if (r0 == this) goto L9;
        throw new IllegalArgumentException("View " + r4 + " is not a direct child of " + this);
    L9:
        return getChildViewHolderInt(r4);
    }

    public View findContainingItemView(View r3) {
        ViewParent r0 = r3.getParent();
    L3:
        if (r0 == null) goto L8;
        if (r0 == this) goto L8;
        if (ZeusTransformUtils.instanceOf(r0, View.class) == false) goto L8;
        r3 = (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin");
        r0 = r3.getParent();
    L8:
        if (r0 == this) goto L15;
        return null;
    L15:
        return r3;
    }

    public u findContainingViewHolder(View r1) {
        View r2 = findContainingItemView(r1);
        if (r2 != null) goto L6;
        return null;
    L6:
        return getChildViewHolder(r2);
    }

    static u getChildViewHolderInt(View r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return ((LayoutParams) ZeusTransformUtils.preCheckCast(r2.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin")).mViewHolder;
    }

    @Deprecated
    public int getChildPosition(View r1) {
        return getChildAdapterPosition(r1);
    }

    public int getChildAdapterPosition(View r1) {
        u r0 = getChildViewHolderInt(r1);
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.g();
    }

    public int getChildLayoutPosition(View r1) {
        u r0 = getChildViewHolderInt(r1);
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.e();
    }

    public long getChildItemId(View r3) {
        a r2 = this.mAdapter;
        if (r2 != null) goto L5;
        return -1;
    L5:
        if (r2.b() == false) goto L13;
        u r4 = getChildViewHolderInt(r3);
        if (r4 != null) goto L10;
        return -1;
    L10:
        return r4.j();
    L13:
        return -1;
    }

    @Deprecated
    public u findViewHolderForPosition(int r2) {
        return findViewHolderForPosition(r2, false);
    }

    public u findViewHolderForLayoutPosition(int r2) {
        return findViewHolderForPosition(r2, false);
    }

    public u findViewHolderForAdapterPosition(int r6) {
        u r1 = null;
        if (this.mDataSetHasChangedAfterLayout == false) goto L5;
        return null;
    L5:
        int r0 = this.mChildHelper.c();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L18;
        u r3 = getChildViewHolderInt(this.mChildHelper.d(r2));
        if (r3 == null) goto L17;
        if (r3.t() == true) goto L17;
        if (getAdapterPositionInRecyclerView(r3) != r6) goto L17;
        if (this.mChildHelper.c(r3.f2390a) == false) goto L16;
        r1 = r3;
        goto L17
    L16:
        return r3;
    L17:
        r2 = r2 + 1;
        goto L6
    L18:
        return r1;
    }

    u findViewHolderForPosition(int r6, boolean r7) {
        int r0 = this.mChildHelper.c();
        u r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L20;
        u r3 = getChildViewHolderInt(this.mChildHelper.d(r2));
        if (r3 == null) goto L19;
        if (r3.t() == true) goto L19;
        if (r7 == false) goto L13;
        if (r3.f2392c != r6) goto L19;
    L16:
        if (this.mChildHelper.c(r3.f2390a) == false) goto L18;
        r1 = r3;
        goto L19
    L18:
        return r3;
    L13:
        if (r3.e() == r6) goto L16;
    L19:
        r2 = r2 + 1;
        goto L3
    L20:
        return r1;
    }

    public u findViewHolderForItemId(long r7) {
        a r0 = this.mAdapter;
        u r1 = null;
        if (r0 != null) goto L5;
    L20:
        return r1;
    L5:
        if (r0.b() == false) goto L20;
        int r2 = this.mChildHelper.c();
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L20;
        u r4 = getChildViewHolderInt(this.mChildHelper.d(r3));
        if (r4 == null) goto L19;
        if (r4.t() == true) goto L19;
        if (r4.j() != r7) goto L19;
        if (this.mChildHelper.c(r4.f2390a) == false) goto L18;
        r1 = r4;
        goto L19
    L18:
        return r4;
    L19:
        r3 = r3 + 1;
        goto L8
    }

    public View findChildViewUnder(float r6, float r7) {
        int r0 = this.mChildHelper.b() - 1;
    L3:
        if (r0 < 0) goto L14;
        View r1 = this.mChildHelper.b(r0);
        float r2 = r1.getTranslationX();
        float r3 = r1.getTranslationY();
        if (r6 < (r1.getLeft() + r2)) goto L13;
        if (r6 > (r1.getRight() + r2)) goto L13;
        if (r7 < (r1.getTop() + r3)) goto L13;
        if (r7 > (r1.getBottom() + r3)) goto L13;
        return r1;
    L13:
        r0 = r0 - 1;
        goto L3
    L14:
        return null;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r1, View r2, long r3) {
        return super.drawChild(r1, r2, r3);
    }

    public void offsetChildrenVertical(int r4) {
        int r0 = this.mChildHelper.b();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mChildHelper.b(r1).offsetTopAndBottom(r4);
        r1 = r1 + 1;
        goto L3
    }

    public void offsetChildrenHorizontal(int r4) {
        int r0 = this.mChildHelper.b();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mChildHelper.b(r1).offsetLeftAndRight(r4);
        r1 = r1 + 1;
        goto L3
    }

    public void getDecoratedBoundsWithMargins(View r1, Rect r2) {
        getDecoratedBoundsWithMarginsInt(r1, r2);
    }

    static void getDecoratedBoundsWithMarginsInt(View r6, Rect r7) {
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r6.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        Rect r1 = r0.mDecorInsets;
        r7.set((r6.getLeft() - r1.left) - r0.leftMargin, (r6.getTop() - r1.top) - r0.topMargin, (r6.getRight() + r1.right) + r0.rightMargin, (r6.getBottom() + r1.bottom) + r0.bottomMargin);
    }

    Rect getItemDecorInsetsForChild(View r10) {
        LayoutParams r0 = (LayoutParams) ZeusTransformUtils.preCheckCast(r10.getLayoutParams(), LayoutParams.class, "com.obric.aiagent.plugin");
        if (r0.mInsetsDirty == true) goto L7;
        return r0.mDecorInsets;
    L7:
        if (this.mState.a() == true) goto L9;
    L14:
        Rect r1 = r0.mDecorInsets;
        r1.set(0, 0, 0, 0);
        int r4 = this.mItemDecorations.size();
        int r5 = 0;
    L15:
        if (r5 >= r4) goto L17;
        this.mTempRect.set(0, 0, 0, 0);
        ((g) ZeusTransformUtils.preCheckCast(this.mItemDecorations.get(r5), g.class, "com.obric.aiagent.plugin")).a(this.mTempRect, r10, this, this.mState);
        r1.left += this.mTempRect.left;
        r1.top += this.mTempRect.top;
        r1.right += this.mTempRect.right;
        r1.bottom += this.mTempRect.bottom;
        r5 = r5 + 1;
        goto L15
    L17:
        r0.mInsetsDirty = false;
        return r1;
    L9:
        if (r0.isItemChanged() == true) goto L13;
        if (r0.isViewInvalid() == false) goto L14;
    L13:
        return r0.mDecorInsets;
    }

    void dispatchOnScrolled(int r5, int r6) {
        this.mDispatchScrollCounter++;
        int r0 = getScrollX();
        int r1 = getScrollY();
        onScrollChanged(r0, r1, r0 - r5, r1 - r6);
        onScrolled(r5, r6);
        l r2 = this.mScrollListener;
        if (r2 == null) goto L5;
        r2.a(this, r5, r6);
    L5:
        List<l> r3 = this.mScrollListeners;
        if (r3 == null) goto L10;
        int r4 = r3.size() - 1;
    L8:
        if (r4 < 0) goto L10;
        ((l) ZeusTransformUtils.preCheckCast(this.mScrollListeners.get(r4), l.class, "com.obric.aiagent.plugin")).a(this, r5, r6);
        r4 = r4 - 1;
    L10:
        this.mDispatchScrollCounter--;
    }

    void dispatchOnScrollStateChanged(int r5) {
        h r0 = this.mLayout;
        if (r0 == null) goto L5;
        r0.l(r5);
    L5:
        onScrollStateChanged(r5);
        l r1 = this.mScrollListener;
        if (r1 == null) goto L8;
        r1.a(this, r5);
    L8:
        List<l> r2 = this.mScrollListeners;
        if (r2 == null) goto L13;
        int r3 = r2.size() - 1;
    L11:
        if (r3 < 0) goto L15;
        ((l) ZeusTransformUtils.preCheckCast(this.mScrollListeners.get(r3), l.class, "com.obric.aiagent.plugin")).a(this, r5);
        r3 = r3 - 1;
        goto L11
    L15:
        return;
    }

    public boolean hasPendingAdapterUpdates() {
        if (this.mFirstLayoutComplete == true) goto L5;
    L10:
        return true;
    L5:
        if (this.mDataSetHasChangedAfterLayout == true) goto L10;
        if (this.mAdapterHelper.d() == true) goto L10;
        return false;
    }

    void repositionShadowingViews() {
        int r0 = this.mChildHelper.b();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L14;
        View r2 = this.mChildHelper.b(r1);
        u r3 = getChildViewHolder(r2);
        if (r3 == null) goto L13;
        if (r3.i == null) goto L13;
        View r4 = r3.i.f2390a;
        int r5 = r2.getLeft();
        int r6 = r2.getTop();
        if (r5 == r4.getLeft()) goto L11;
    L12:
        r4.layout(r5, r6, r4.getWidth() + r5, r4.getHeight() + r6);
        goto L13
    L11:
        if (r6 != r4.getTop()) goto L12;
    L13:
        r1 = r1 + 1;
        goto L3
    }

    static RecyclerView findNestedRecyclerView(View r4) {
        if (ZeusTransformUtils.instanceOf(r4, ViewGroup.class) == true) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r4, RecyclerView.class) == true) goto L8;
        ViewGroup r5 = (ViewGroup) ZeusTransformUtils.preCheckCast(r4, ViewGroup.class, "com.obric.aiagent.plugin");
        int r0 = r5.getChildCount();
        int r1 = 0;
    L10:
        if (r1 >= r0) goto L15;
        RecyclerView r3 = findNestedRecyclerView(r5.getChildAt(r1));
        if (r3 != null) goto L13;
        r1 = r1 + 1;
        goto L10
    L13:
        return r3;
    L15:
        return null;
    L8:
        return (RecyclerView) ZeusTransformUtils.preCheckCast(r4, RecyclerView.class, "com.obric.aiagent.plugin");
    }

    static void clearNestedRecyclerViewIfNotNested(u r4) {
        if (r4.f2391b == null) goto L23;
        View r0 = (View) ZeusTransformUtils.preCheckCast(r4.f2391b.get(), View.class, "com.obric.aiagent.plugin");
    L6:
        if (r0 == null) goto L14;
        if (r0 == r4.f2390a) goto L9;
        ViewParent r1 = r0.getParent();
        if (ZeusTransformUtils.instanceOf(r1, View.class) == true) goto L12;
        r0 = null;
        goto L6
    L12:
        r0 = (View) ZeusTransformUtils.preCheckCast(r1, View.class, "com.obric.aiagent.plugin");
        goto L6
    L9:
        return;
    L14:
        r4.f2391b = null;
        return;
    }

    long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK == true) goto L5;
        return 0;
    L5:
        return System.nanoTime();
    }

    void dispatchChildDetached(View r5) {
        u r0 = getChildViewHolderInt(r5);
        onChildDetachedFromWindow(r5);
        a r1 = this.mAdapter;
        if (r1 == null) goto L6;
        if (r0 == null) goto L6;
        r1.c(r0);
    L6:
        List<i> r2 = this.mOnChildAttachStateListeners;
        if (r2 == null) goto L11;
        int r3 = r2.size() - 1;
    L9:
        if (r3 < 0) goto L13;
        ((i) ZeusTransformUtils.preCheckCast(this.mOnChildAttachStateListeners.get(r3), i.class, "com.obric.aiagent.plugin")).b(r5);
        r3 = r3 - 1;
        goto L9
    L13:
        return;
    }

    void dispatchChildAttached(View r5) {
        u r0 = getChildViewHolderInt(r5);
        onChildAttachedToWindow(r5);
        a r1 = this.mAdapter;
        if (r1 == null) goto L6;
        if (r0 == null) goto L6;
        r1.b(r0);
    L6:
        List<i> r2 = this.mOnChildAttachStateListeners;
        if (r2 == null) goto L11;
        int r3 = r2.size() - 1;
    L9:
        if (r3 < 0) goto L13;
        ((i) ZeusTransformUtils.preCheckCast(this.mOnChildAttachStateListeners.get(r3), i.class, "com.obric.aiagent.plugin")).a(r5);
        r3 = r3 - 1;
        goto L9
    L13:
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_recyclerview_widget_RecyclerView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_recyclerview_widget_RecyclerView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_androidx_recyclerview_widget_RecyclerView_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1) {
        return Log.e(r0, r1);
    }

    boolean setChildImportantForAccessibilityInternal(u r2, int r3) {
        if (isComputingLayout() == false) goto L6;
        r2.o = r3;
        this.mPendingAccessibilityImportanceChange.add(r2);
        return false;
    L6:
        ViewCompat.c(r2.f2390a, r3);
        return true;
    }

    void dispatchPendingImportantForAccessibilityChanges() {
        int r0 = this.mPendingAccessibilityImportanceChange.size() - 1;
    L3:
        if (r0 < 0) goto L13;
        u r1 = (u) ZeusTransformUtils.preCheckCast(this.mPendingAccessibilityImportanceChange.get(r0), u.class, "com.obric.aiagent.plugin");
        if (r1.f2390a.getParent() != this) goto L12;
        if (r1.c() == true) goto L12;
        int r2 = r1.o;
        if (r2 == (-1)) goto L12;
        ViewCompat.c(r1.f2390a, r2);
        r1.o = -1;
    L12:
        r0 = r0 - 1;
        goto L3
    L13:
        this.mPendingAccessibilityImportanceChange.clear();
    }

    int getAdapterPositionInRecyclerView(u r2) {
        if (r2.a(524) == false) goto L5;
        return -1;
    L5:
        if (r2.s() == true) goto L8;
        return -1;
    L8:
        return this.mAdapterHelper.c(r2.f2392c);
    }

    void initFastScroller(StateListDrawable r11, Drawable r12, StateListDrawable r13, Drawable r14) {
        if (r11 == null) goto L9;
        if (r12 == null) goto L9;
        if (r13 == null) goto L9;
        if (r14 == null) goto L9;
        Resources r0 = ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin");
        new FastScroller(this, r11, r12, r13, r14, r0.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.fastscroll_default_thickness, "dimen", "fastscroll_default_thickness")), r0.getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.fastscroll_minimum_range, "dimen", "fastscroll_minimum_range")), r0.getDimensionPixelOffset(ZeusTransformUtils.mapRes(R.dimen.fastscroll_margin, "dimen", "fastscroll_margin")));
        return;
    L9:
        throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean r1) {
        getScrollingChildHelper().a(r1);
    }

    @Override // android.view.View, androidx.core.view.l
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().a();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int r1) {
        return getScrollingChildHelper().b(r1);
    }

    public boolean startNestedScroll(int r1, int r2) {
        return getScrollingChildHelper().a(r1, r2);
    }

    @Override // android.view.View, androidx.core.view.l
    public void stopNestedScroll() {
        getScrollingChildHelper().c();
    }

    public void stopNestedScroll(int r1) {
        getScrollingChildHelper().c(r1);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().b();
    }

    public boolean hasNestedScrollingParent(int r1) {
        return getScrollingChildHelper().a(r1);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int r7, int r8, int r9, int r10, int[] r11) {
        return getScrollingChildHelper().a(r7, r8, r9, r10, r11);
    }

    public boolean dispatchNestedScroll(int r8, int r9, int r10, int r11, int[] r12, int r13) {
        return getScrollingChildHelper().a(r8, r9, r10, r11, r12, r13);
    }

    public final void dispatchNestedScroll(int r9, int r10, int r11, int r12, int[] r13, int r14, int[] r15) {
        getScrollingChildHelper().a(r9, r10, r11, r12, r13, r14, r15);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int r1, int r2, int[] r3, int[] r4) {
        return getScrollingChildHelper().a(r1, r2, r3, r4);
    }

    public boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10, int r11) {
        return getScrollingChildHelper().a(r7, r8, r9, r10, r11);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float r1, float r2, boolean r3) {
        return getScrollingChildHelper().a(r1, r2, r3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float r1, float r2) {
        return getScrollingChildHelper().a(r1, r2);
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r2, int r3) {
        c r0 = this.mChildDrawingOrderCallback;
        if (r0 != null) goto L7;
        return super.getChildDrawingOrder(r2, r3);
    L7:
        return r0.a(r2, r3);
    }

    private androidx.core.view.o getScrollingChildHelper() {
        if (this.mScrollingChildHelper != null) goto L6;
        this.mScrollingChildHelper = new androidx.core.view.o(this);
    L6:
        return this.mScrollingChildHelper;
    }
}
