package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
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
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R$attr;
import androidx.recyclerview.R$dimen;
import androidx.recyclerview.R$styleable;
import androidx.recyclerview.base.EdgeEffectAdapter;
import androidx.recyclerview.base.OverScrollerAdapter;
import androidx.recyclerview.base.VelocityTracker;
import com.bytedance.librarian.LibrarianImpl;
import com.google.common.primitives.Ints;
import com.obric.capabilitykit.common.UiType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild2, NestedScrollingChild3 {
    static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC = false;
    static final boolean ALLOW_THREAD_GAP_WORK = false;
    private static final float DECELERATION_RATE = 0.0f;
    static final int DEFAULT_ORIENTATION = 1;
    static final boolean DISPATCH_TEMP_DETACH = false;
    private static final float FLING_DESTRETCH_FACTOR = 4.0f;
    private static final boolean FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
    static final boolean FORCE_INVALIDATE_DISPLAY_LIST = false;
    static final long FOREVER_NS = Long.MAX_VALUE;
    public static final int HORIZONTAL = 0;
    private static final boolean IGNORE_DETACHED_FOCUSED_CHILD = false;
    private static final float INFLEXION = 0.35f;
    private static final int INVALID_POINTER = -1;
    public static final int INVALID_TYPE = -1;
    private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = null;
    static final int MAX_SCROLL_DURATION = 2000;
    private static final int[] NESTED_SCROLLING_ATTRS = null;
    public static final long NO_ID = -1;
    public static final int NO_POSITION = -1;
    static final boolean POST_UPDATES_ON_ANIMATION = false;
    private static final float SCROLL_FRICTION = 0.015f;
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
    static boolean sDebugAssertionsEnabled = false;
    static final Interpolator sQuinticInterpolator = null;
    static boolean sVerboseLoggingEnabled = false;
    RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    Adapter mAdapter;
    AdapterHelper mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private boolean mAvoidStateChangeInAnim;
    private ChildDrawingOrderCallback mChildDrawingOrderCallback;
    ChildHelper mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    boolean mEnableFastScroller;
    private boolean mEnableOverFling;

    @VisibleForTesting
    boolean mFirstLayoutComplete;
    GapWorker mGapWorker;
    boolean mHasFixedSize;
    protected EdgeEffectAdapter mHorizontalEdgeEffect;
    private boolean mIgnoreMotionEventTillDown;
    private int mInitialTouchX;
    private int mInitialTouchY;
    private int mInterceptRequestLayoutDepth;
    private OnItemTouchListener mInterceptingOnItemTouchListener;
    boolean mIsAttached;
    ItemAnimator mItemAnimator;
    private ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
    private Runnable mItemAnimatorRunner;
    final ArrayList<ItemDecoration> mItemDecorations;
    boolean mItemsAddedOrRemoved;
    boolean mItemsChanged;
    private int mLastAutoMeasureNonExactMeasuredHeight;
    private int mLastAutoMeasureNonExactMeasuredWidth;
    private boolean mLastAutoMeasureSkippedDueToExact;
    private int mLastTouchX;
    private int mLastTouchY;

    @VisibleForTesting
    LayoutManager mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private final int mMaxFlingVelocity;
    private int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final RecyclerViewDataObserver mObserver;
    private List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
    private OnFlingListener mOnFlingListener;
    private final ArrayList<OnItemTouchListener> mOnItemTouchListeners;

    @VisibleForTesting
    final List<ViewHolder> mPendingAccessibilityImportanceChange;
    SavedState mPendingSavedState;
    private final float mPhysicalCoef;
    boolean mPostedAnimatorRunner;
    GapWorker.LayoutPrefetchRegistryImpl mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final Recycler mRecycler;
    RecyclerListener mRecyclerListener;
    final List<RecyclerListener> mRecyclerListeners;
    private final RecyclerViewExt mRecyclerViewExt;
    final int[] mReusableIntPair;
    private float mScaledHorizontalScrollFactor;
    private float mScaledVerticalScrollFactor;
    private OnScrollListener mScrollListener;
    private List<OnScrollListener> mScrollListeners;
    private final int[] mScrollOffset;
    private int mScrollPointerId;
    private int mScrollState;
    private NestedScrollingChildHelper mScrollingChildHelper;
    final State mState;
    final Rect mTempRect;
    private final Rect mTempRect2;
    final RectF mTempRectF;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    protected EdgeEffectAdapter mVerticalEdgeEffect;
    final ViewFlinger mViewFlinger;
    private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
    final ViewInfoStore mViewInfoStore;

    public static abstract class Adapter {
        private boolean mHasStableIds;
        private final AdapterDataObservable mObservable;
        private StateRestorationPolicy mStateRestorationPolicy;

        public static final enum StateRestorationPolicy extends Enum<StateRestorationPolicy> {
            private static final /* synthetic */ StateRestorationPolicy[] $VALUES = null;
            public static final StateRestorationPolicy ALLOW = null;
            public static final StateRestorationPolicy PREVENT = null;
            public static final StateRestorationPolicy PREVENT_WHEN_EMPTY = null;

            static {
                StateRestorationPolicy r10 = new StateRestorationPolicy("ALLOW", 0);
                ALLOW = r10;
                StateRestorationPolicy r11 = new StateRestorationPolicy("PREVENT_WHEN_EMPTY", 1);
                PREVENT_WHEN_EMPTY = r11;
                StateRestorationPolicy r12 = new StateRestorationPolicy("PREVENT", 2);
                PREVENT = r12;
                $VALUES = new StateRestorationPolicy[]{r10, r11, r12};
            }

            private StateRestorationPolicy(String r10, int r11) {
                super(r10, r11);
            }

            public static StateRestorationPolicy valueOf(String r10) {
                return (StateRestorationPolicy) Enum.valueOf(StateRestorationPolicy.class, r10);
            }

            public static StateRestorationPolicy[] values() {
                return (StateRestorationPolicy[]) $VALUES.clone();
            }
        }

        public Adapter() {
            this.mObservable = new AdapterDataObservable();
            this.mHasStableIds = false;
            this.mStateRestorationPolicy = StateRestorationPolicy.ALLOW;
        }

        public final void bindViewHolder(@NonNull ViewHolder r10, int r11) {
            if (r10.mBindingAdapter != null) goto L5;
            boolean r12 = true;
        L6:
            if (r12 == false) goto L11;
            r10.mPosition = r11;
            if (hasStableIds() == false) goto L10;
            r10.mItemId = getItemId(r11);
        L10:
            r10.setFlags(1, 519);
            androidx.core.os.g.a(RecyclerView.TRACE_BIND_VIEW_TAG);
        L11:
            r10.mBindingAdapter = this;
            if (RecyclerView.sDebugAssertionsEnabled == true) goto L14;
        L27:
            onBindViewHolder(r10, r11, r10.getUnmodifiedPayloads());
            if (r12 == false) goto L34;
            r10.clearPayload();
            ViewGroup.LayoutParams r13 = r10.itemView.getLayoutParams();
            if ((r13 instanceof LayoutParams) == false) goto L32;
            ((LayoutParams) r13).mInsetsDirty = true;
        L32:
            androidx.core.os.g.b();
            return;
        L34:
            return;
        L14:
            if (r10.itemView.getParent() != null) goto L21;
            if (ViewCompat.S(r10.itemView) == r10.isTmpDetached()) goto L21;
            throw new IllegalStateException("Temp-detached state out of sync with reality. holder.isTmpDetached(): " + r10.isTmpDetached() + ", attached to window: " + ViewCompat.S(r10.itemView) + ", holder: " + r10);
        L21:
            if (r10.itemView.getParent() != null) goto L27;
            if (ViewCompat.S(r10.itemView) == false) goto L27;
            throw new IllegalStateException("Attempting to bind attached holder with no parent (AKA temp detached): " + r10);
        L5:
            r12 = false;
            goto L6
        }

        public boolean canRestoreState() {
            int r10 = g.f4253a[this.mStateRestorationPolicy.ordinal()];
            if (r10 != 1) goto L5;
            return false;
        L5:
            if (r10 == 2) goto L8;
            return true;
        L8:
            if (getItemCount() > 0) goto L10;
            return false;
        L10:
            return true;
        }

        @NonNull
        public final ViewHolder createViewHolder(@NonNull ViewGroup r10, int r11) {
            androidx.core.os.g.a(RecyclerView.TRACE_CREATE_VIEW_TAG);     // Catch: Throwable -> L7
            ViewHolder r12 = onCreateViewHolder(r10, r11);     // Catch: Throwable -> L7
            if (r12.itemView.getParent() != null) goto L10;
            r12.mItemViewType = r11;     // Catch: Throwable -> L7
            androidx.core.os.g.b();
            return r12;
        L10:
            throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");     // Catch: Throwable -> L7
        L7:
            th = move-exception;
            androidx.core.os.g.b();
            throw th;
        }

        public int findRelativeAdapterPositionIn(@NonNull Adapter r10, @NonNull ViewHolder r11, int r12) {
            if (r10 != this) goto L4;
            return r12;
        L4:
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int r10) {
            return -1;
        }

        public int getItemViewType(int r10) {
            return 0;
        }

        @NonNull
        public final StateRestorationPolicy getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
        }

        public final boolean hasObservers() {
            return this.mObservable.a();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.b();
        }

        public final void notifyItemChanged(int r10) {
            this.mObservable.d(r10, 1);
        }

        public final void notifyItemInserted(int r10) {
            this.mObservable.f(r10, 1);
        }

        public final void notifyItemMoved(int r10, int r11) {
            this.mObservable.c(r10, r11);
        }

        public final void notifyItemRangeChanged(int r10, int r11) {
            this.mObservable.d(r10, r11);
        }

        public final void notifyItemRangeInserted(int r10, int r11) {
            this.mObservable.f(r10, r11);
        }

        public final void notifyItemRangeRemoved(int r10, int r11) {
            this.mObservable.g(r10, r11);
        }

        public final void notifyItemRemoved(int r10) {
            this.mObservable.g(r10, 1);
        }

        public void onAttachedToRecyclerView(@NonNull RecyclerView r10) {
        }

        public abstract void onBindViewHolder(@NonNull ViewHolder r10, int r11);

        public void onBindViewHolder(@NonNull ViewHolder r10, int r11, @NonNull List<Object> r12) {
            onBindViewHolder(r10, r11);
        }

        @NonNull
        public abstract ViewHolder onCreateViewHolder(@NonNull ViewGroup r10, int r11);

        public void onDetachedFromRecyclerView(@NonNull RecyclerView r10) {
        }

        public boolean onFailedToRecycleView(@NonNull ViewHolder r10) {
            return false;
        }

        public void onViewAttachedToWindow(@NonNull ViewHolder r10) {
        }

        public void onViewDetachedFromWindow(@NonNull ViewHolder r10) {
        }

        public void onViewRecycled(@NonNull ViewHolder r10) {
        }

        public void registerAdapterDataObserver(@NonNull AdapterDataObserver r10) {
            this.mObservable.registerObserver(r10);
        }

        public void setHasStableIds(boolean r10) {
            if (hasObservers() == true) goto L7;
            this.mHasStableIds = r10;
            return;
        L7:
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void setStateRestorationPolicy(@NonNull StateRestorationPolicy r10) {
            this.mStateRestorationPolicy = r10;
            this.mObservable.h();
        }

        public void unregisterAdapterDataObserver(@NonNull AdapterDataObserver r10) {
            this.mObservable.unregisterObserver(r10);
        }

        public final void notifyItemChanged(int r10, @Nullable Object r11) {
            this.mObservable.e(r10, 1, r11);
        }

        public final void notifyItemRangeChanged(int r10, int r11, @Nullable Object r12) {
            this.mObservable.e(r10, r11, r12);
        }
    }

    public static class AdapterDataObservable extends Observable {
        public AdapterDataObservable() {
        }

        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            int r10 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r10 < 0) goto L5;
            ((AdapterDataObserver) ((Observable) this).mObservers.get(r10)).onChanged();
            r10 = r10 - 1;
            goto L3
        }

        public void c(int r10, int r11) {
            int r12 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r12 < 0) goto L5;
            ((AdapterDataObserver) ((Observable) this).mObservers.get(r12)).onItemRangeMoved(r10, r11, 1);
            r12 = r12 - 1;
            goto L3
        }

        public void d(int r10, int r11) {
            e(r10, r11, null);
        }

        public void e(int r10, int r11, Object r12) {
            int r13 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r13 < 0) goto L5;
            ((AdapterDataObserver) ((Observable) this).mObservers.get(r13)).onItemRangeChanged(r10, r11, r12);
            r13 = r13 - 1;
            goto L3
        }

        public void f(int r10, int r11) {
            int r12 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r12 < 0) goto L5;
            ((AdapterDataObserver) ((Observable) this).mObservers.get(r12)).onItemRangeInserted(r10, r11);
            r12 = r12 - 1;
            goto L3
        }

        public void g(int r10, int r11) {
            int r12 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r12 < 0) goto L5;
            ((AdapterDataObserver) ((Observable) this).mObservers.get(r12)).onItemRangeRemoved(r10, r11);
            r12 = r12 - 1;
            goto L3
        }

        public void h() {
            int r10 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r10 < 0) goto L5;
            ((AdapterDataObserver) ((Observable) this).mObservers.get(r10)).onStateRestorationPolicyChanged();
            r10 = r10 - 1;
            goto L3
        }
    }

    public static abstract class AdapterDataObserver {
        public AdapterDataObserver() {
        }

        public void onChanged() {
        }

        public void onItemRangeChanged(int r10, int r11) {
        }

        public void onItemRangeInserted(int r10, int r11) {
        }

        public void onItemRangeMoved(int r10, int r11, int r12) {
        }

        public void onItemRangeRemoved(int r10, int r11) {
        }

        public void onStateRestorationPolicyChanged() {
        }

        public void onItemRangeChanged(int r10, int r11, Object r12) {
            onItemRangeChanged(r10, r11);
        }
    }

    public interface ChildDrawingOrderCallback {
        int onGetChildDrawingOrder(int r10, int r11);
    }

    public static class EdgeEffectFactory {

        @Retention(RetentionPolicy.SOURCE)
        public @interface EdgeDirection {
        }
    }

    public static abstract class ItemAnimator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ItemAnimatorListener f4187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f4188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f4189c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f4190d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f4191e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f4192f;

        @Retention(RetentionPolicy.SOURCE)
        public @interface AdapterChanges {
        }

        public interface ItemAnimatorFinishedListener {
            void onAnimationsFinished();
        }

        public interface ItemAnimatorListener {
            void onAnimationFinished(@NonNull ViewHolder r10);
        }

        public static class ItemHolderInfo {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f4193a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f4194b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f4195c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f4196d;

            public ItemHolderInfo() {
            }

            public ItemHolderInfo a(ViewHolder r10) {
                return b(r10, 0);
            }

            public ItemHolderInfo b(ViewHolder r10, int r11) {
                View r12 = r10.itemView;
                this.f4193a = r12.getLeft();
                this.f4194b = r12.getTop();
                this.f4195c = r12.getRight();
                this.f4196d = r12.getBottom();
                return this;
            }
        }

        public ItemAnimator() {
            this.f4187a = null;
            this.f4188b = new ArrayList();
            this.f4189c = 100;
            this.f4190d = 100;
            this.f4191e = 500;
            this.f4192f = 250;
        }

        public static int e(ViewHolder r10) {
            int r11 = r10.mFlags;
            int r12 = r11 & 14;
            if (r10.isInvalid() == false) goto L6;
            return 4;
        L6:
            if ((r11 & 4) != 0) goto L13;
            int r13 = r10.getOldPosition();
            int r14 = r10.getAbsoluteAdapterPosition();
            if (r13 == (-1)) goto L14;
            if (r14 == (-1)) goto L15;
            if (r13 != r14) goto L12;
            return r12;
        L12:
            return r12 | 2048;
        L15:
            return r12;
        L14:
            return r12;
        L13:
            return r12;
        }

        public void A(long r10) {
            this.f4190d = r10;
        }

        public abstract boolean a(ViewHolder r10, ItemHolderInfo r11, ItemHolderInfo r12);

        public abstract boolean b(ViewHolder r10, ViewHolder r11, ItemHolderInfo r12, ItemHolderInfo r13);

        public abstract boolean c(ViewHolder r10, ItemHolderInfo r11, ItemHolderInfo r12);

        public abstract boolean d(ViewHolder r10, ItemHolderInfo r11, ItemHolderInfo r12);

        public boolean f(ViewHolder r10) {
            return true;
        }

        public boolean g(ViewHolder r10, List r11) {
            return f(r10);
        }

        public final void h(ViewHolder r10) {
            s(r10);
            ItemAnimatorListener r11 = this.f4187a;
            if (r11 == null) goto L6;
            r11.onAnimationFinished(r10);
            return;
        }

        public final void i() {
            int r10 = this.f4188b.size();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L5;
            ((ItemAnimatorFinishedListener) this.f4188b.get(r11)).onAnimationsFinished();
            r11 = r11 + 1;
            goto L3
        L5:
            this.f4188b.clear();
        }

        public abstract void j(ViewHolder r10);

        public abstract void k();

        public long l() {
            return this.f4189c;
        }

        public long m() {
            return this.f4192f;
        }

        public long n() {
            return this.f4191e;
        }

        public long o() {
            return this.f4190d;
        }

        public abstract boolean p();

        public final boolean q(ItemAnimatorFinishedListener r10) {
            boolean r11 = p();
            if (r10 == null) goto L7;
            if (r11 == true) goto L6;
            r10.onAnimationsFinished();
            goto L7
        L6:
            this.f4188b.add(r10);
        L7:
            return r11;
        }

        public ItemHolderInfo r() {
            return new ItemHolderInfo();
        }

        public void s(ViewHolder r10) {
        }

        public ItemHolderInfo t(State r10, ViewHolder r11) {
            return r().a(r11);
        }

        public ItemHolderInfo u(State r10, ViewHolder r11, int r12, List r13) {
            return r().a(r11);
        }

        public abstract void v();

        public void w(long r10) {
            this.f4189c = r10;
        }

        public void x(long r10) {
            this.f4192f = r10;
        }

        public void y(ItemAnimatorListener r10) {
            this.f4187a = r10;
        }

        public void z(long r10) {
            this.f4191e = r10;
        }
    }

    public static abstract class ItemDecoration {
        public ItemDecoration() {
        }

        @Deprecated
        public void getItemOffsets(@NonNull Rect r10, int r11, @NonNull RecyclerView r12) {
            r10.set(0, 0, 0, 0);
        }

        @Deprecated
        public void onDraw(@NonNull Canvas r10, @NonNull RecyclerView r11) {
        }

        @Deprecated
        public void onDrawOver(@NonNull Canvas r10, @NonNull RecyclerView r11) {
        }

        public void getItemOffsets(@NonNull Rect r10, @NonNull View r11, @NonNull RecyclerView r12, @NonNull State r13) {
            getItemOffsets(r10, ((LayoutParams) r11.getLayoutParams()).getViewLayoutPosition(), r12);
        }

        public void onDraw(@NonNull Canvas r10, @NonNull RecyclerView r11, @NonNull State r12) {
            onDraw(r10, r11);
        }

        public void onDrawOver(@NonNull Canvas r10, @NonNull RecyclerView r11, @NonNull State r12) {
            onDrawOver(r10, r11);
        }
    }

    public static abstract class LayoutManager {
        boolean mAutoMeasure;
        ChildHelper mChildHelper;
        private int mHeight;
        private int mHeightMode;
        ViewBoundsCheck mHorizontalBoundCheck;
        private final ViewBoundsCheck.Callback mHorizontalBoundCheckCallback;
        boolean mIsAttachedToWindow;
        private boolean mItemPrefetchEnabled;
        private boolean mMeasurementCacheEnabled;
        int mPrefetchMaxCountObserved;
        boolean mPrefetchMaxObservedInInitialPrefetch;
        RecyclerView mRecyclerView;
        boolean mRequestedSimpleAnimations;

        @Nullable
        SmoothScroller mSmoothScroller;
        ViewBoundsCheck mVerticalBoundCheck;
        private final ViewBoundsCheck.Callback mVerticalBoundCheckCallback;
        private int mWidth;
        private int mWidthMode;

        public interface LayoutPrefetchRegistry {
            void addPosition(int r10, int r11);
        }

        public static class Properties {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f4197a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f4198b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f4199c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public boolean f4200d;

            public Properties() {
            }
        }

        public class a implements ViewBoundsCheck.Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LayoutManager f4201a;

            public a(LayoutManager r10) {
                this.f4201a = r10;
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public View getChildAt(int r10) {
                return this.f4201a.getChildAt(r10);
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public int getChildEnd(View r10) {
                LayoutParams r11 = (LayoutParams) r10.getLayoutParams();
                return this.f4201a.getDecoratedRight(r10) + ((ViewGroup.MarginLayoutParams) r11).rightMargin;
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public int getChildStart(View r10) {
                LayoutParams r11 = (LayoutParams) r10.getLayoutParams();
                return this.f4201a.getDecoratedLeft(r10) - ((ViewGroup.MarginLayoutParams) r11).leftMargin;
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public int getParentEnd() {
                return this.f4201a.getWidth() - this.f4201a.getPaddingRight();
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public int getParentStart() {
                return this.f4201a.getPaddingLeft();
            }
        }

        public class b implements ViewBoundsCheck.Callback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LayoutManager f4202a;

            public b(LayoutManager r10) {
                this.f4202a = r10;
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public View getChildAt(int r10) {
                return this.f4202a.getChildAt(r10);
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public int getChildEnd(View r10) {
                LayoutParams r11 = (LayoutParams) r10.getLayoutParams();
                return this.f4202a.getDecoratedBottom(r10) + ((ViewGroup.MarginLayoutParams) r11).bottomMargin;
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public int getChildStart(View r10) {
                LayoutParams r11 = (LayoutParams) r10.getLayoutParams();
                return this.f4202a.getDecoratedTop(r10) - ((ViewGroup.MarginLayoutParams) r11).topMargin;
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public int getParentEnd() {
                return this.f4202a.getHeight() - this.f4202a.getPaddingBottom();
            }

            @Override // androidx.recyclerview.widget.ViewBoundsCheck.Callback
            public int getParentStart() {
                return this.f4202a.getPaddingTop();
            }
        }

        public LayoutManager() {
            a r10 = new a(this);
            this.mHorizontalBoundCheckCallback = r10;
            b r11 = new b(this);
            this.mVerticalBoundCheckCallback = r11;
            this.mHorizontalBoundCheck = new ViewBoundsCheck(r10);
            this.mVerticalBoundCheck = new ViewBoundsCheck(r11);
            this.mRequestedSimpleAnimations = false;
            this.mIsAttachedToWindow = false;
            this.mAutoMeasure = false;
            this.mMeasurementCacheEnabled = true;
            this.mItemPrefetchEnabled = true;
        }

        private void addViewInt(View r10, int r11, boolean r12) {
            ViewHolder r13 = RecyclerView.getChildViewHolderInt(r10);
            if (r12 == false) goto L5;
        L8:
            this.mRecyclerView.mViewInfoStore.b(r13);
        L9:
            LayoutParams r14 = (LayoutParams) r10.getLayoutParams();
            if (r13.wasReturnedFromScrap() == true) goto L30;
            if (r13.isScrap() == true) goto L30;
            if (r10.getParent() != this.mRecyclerView) goto L24;
            int r15 = this.mChildHelper.indexOfChild(r10);
            if (r11 != (-1)) goto L19;
            r11 = this.mChildHelper.getChildCount();
        L19:
            if (r15 == (-1)) goto L23;
            if (r15 == r11) goto L35;
            this.mRecyclerView.mLayout.moveView(r15, r11);
        L35:
            if (r14.mPendingInvalidate == true) goto L37;
            return;
        L37:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L39;
            Log.d(RecyclerView.TAG, "consuming pending invalidate on child " + r14.mViewHolder);
        L39:
            r13.itemView.invalidate();
            r14.mPendingInvalidate = false;
            return;
        L23:
            throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(r10) + this.mRecyclerView.exceptionLabel());
        L24:
            this.mChildHelper.addView(r10, r11, false);
            r14.mInsetsDirty = true;
            SmoothScroller r16 = this.mSmoothScroller;
            if (r16 == null) goto L35;
            if (r16.isRunning() == false) goto L35;
            this.mSmoothScroller.onChildAttachedToWindow(r10);
        L30:
            if (r13.isScrap() == false) goto L32;
            r13.unScrap();
        L33:
            this.mChildHelper.attachViewToParent(r10, r11, r10.getLayoutParams(), false);
            goto L35
        L32:
            r13.clearReturnedFromScrapFlag();
            goto L33
        L5:
            if (r13.isRemoved() == true) goto L8;
            this.mRecyclerView.mViewInfoStore.p(r13);
            goto L9
        }

        public static int chooseSize(int r10, int r11, int r12) {
            int r13 = View.MeasureSpec.getMode(r10);
            int r14 = View.MeasureSpec.getSize(r10);
            if (r13 == Integer.MIN_VALUE) goto L9;
            if (r13 != 1073741824) goto L7;
            return r14;
        L7:
            return Math.max(r11, r12);
        L9:
            return Math.min(r14, Math.max(r11, r12));
        }

        private void detachViewInternal(int r10, @NonNull View r11) {
            this.mChildHelper.detachViewFromParent(r10);
        }

        @Deprecated
        public static int getChildMeasureSpec(int r10, int r11, int r12, boolean r13) {
            int r14 = r10 - r11;
            int r15 = 0;
            int r16 = Math.max(0, r14);
            if (r13 == false) goto L7;
            if (r12 < 0) goto L6;
        L5:
            r15 = 1073741824;
        L16:
            return View.MeasureSpec.makeMeasureSpec(r12, r15);
        L6:
            r12 = 0;
            goto L16
        L7:
            if (r12 >= 0) goto L5;
            if (r12 != (-1)) goto L13;
            r12 = r16;
            goto L5
        L13:
            if (r12 != (-2)) goto L6;
            r15 = Integer.MIN_VALUE;
            r12 = r16;
            goto L16
        }

        private int[] getChildRectangleOnScreenScrollAmount(View r10, Rect r11) {
            int r12 = getPaddingLeft();
            int r13 = getPaddingTop();
            int r14 = getWidth() - getPaddingRight();
            int r15 = getHeight() - getPaddingBottom();
            int r16 = (r10.getLeft() + r11.left) - r10.getScrollX();
            int r17 = (r10.getTop() + r11.top) - r10.getScrollY();
            int r18 = r11.width() + r16;
            int r19 = r11.height() + r17;
            int r20 = r16 - r12;
            int r21 = Math.min(0, r20);
            int r22 = r17 - r13;
            int r23 = Math.min(0, r22);
            int r24 = r18 - r14;
            int r25 = Math.max(0, r24);
            int r26 = Math.max(0, r19 - r15);
            if (getLayoutDirection() != 1) goto L7;
            if (r25 != 0) goto L11;
            r25 = Math.max(r21, r24);
        L11:
            if (r23 != 0) goto L15;
            r23 = Math.min(r22, r26);
        L15:
            return new int[]{r25, r23};
        L7:
            if (r21 != 0) goto L10;
            r21 = Math.min(r20, r25);
        L10:
            r25 = r21;
            goto L11
        }

        public static Properties getProperties(@NonNull Context r10, @Nullable AttributeSet r11, int r12, int r13) {
            Properties r14 = new Properties();
            TypedArray r15 = r10.obtainStyledAttributes(r11, R$styleable.RecyclerView, r12, r13);
            r14.f4197a = r15.getInt(R$styleable.RecyclerView_android_orientation, 1);
            r14.f4198b = r15.getInt(R$styleable.RecyclerView_spanCount, 1);
            r14.f4199c = r15.getBoolean(R$styleable.RecyclerView_reverseLayout, false);
            r14.f4200d = r15.getBoolean(R$styleable.RecyclerView_stackFromEnd, false);
            r15.recycle();
            return r14;
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView r10, int r11, int r12) {
            View r13 = r10.getFocusedChild();
            if (r13 != null) goto L5;
            return false;
        L5:
            int r14 = getPaddingLeft();
            int r15 = getPaddingTop();
            int r16 = getWidth() - getPaddingRight();
            int r17 = getHeight() - getPaddingBottom();
            Rect r18 = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(r13, r18);
            if ((r18.left - r11) < r16) goto L8;
        L16:
            return false;
        L8:
            if ((r18.right - r11) <= r14) goto L16;
            if ((r18.top - r12) >= r17) goto L16;
            if ((r18.bottom - r12) <= r15) goto L16;
            return true;
        }

        private static boolean isMeasurementUpToDate(int r10, int r11, int r12) {
            int r13 = View.MeasureSpec.getMode(r11);
            int r14 = View.MeasureSpec.getSize(r11);
            if (r12 <= 0) goto L7;
            if (r10 == r12) goto L7;
            return false;
        L7:
            if (r13 == Integer.MIN_VALUE) goto L16;
            if (r13 != 0) goto L10;
            return true;
        L10:
            if (r13 == 1073741824) goto L12;
            return false;
        L12:
            if (r14 == r10) goto L14;
            return false;
        L14:
            return true;
        L16:
            if (r14 >= r10) goto L18;
            return false;
        L18:
            return true;
        }

        private void scrapOrRecycleView(Recycler r10, int r11, View r12) {
            ViewHolder r13 = RecyclerView.getChildViewHolderInt(r12);
            if (r13.shouldIgnore() == false) goto L9;
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L17;
            Log.d(RecyclerView.TAG, "ignoring view " + r13);
            return;
        L17:
            return;
        L9:
            if (r13.isInvalid() == true) goto L11;
        L15:
            detachViewAt(r11);
            r10.I(r12);
            this.mRecyclerView.mViewInfoStore.k(r13);
            return;
        L11:
            if (r13.isRemoved() == true) goto L15;
            if (this.mRecyclerView.mAdapter.hasStableIds() == true) goto L15;
            removeViewAt(r11);
            r10.H(r13);
        }

        @SuppressLint({"UnknownNullness"})
        public void addDisappearingView(View r10) {
            addDisappearingView(r10, -1);
        }

        @SuppressLint({"UnknownNullness"})
        public void addView(View r10) {
            addView(r10, -1);
        }

        public void assertInLayoutOrScroll(String r10) {
            RecyclerView r11 = this.mRecyclerView;
            if (r11 == null) goto L6;
            r11.assertInLayoutOrScroll(r10);
            return;
        }

        @SuppressLint({"UnknownNullness"})
        public void assertNotInLayoutOrScroll(String r10) {
            RecyclerView r11 = this.mRecyclerView;
            if (r11 == null) goto L6;
            r11.assertNotInLayoutOrScroll(r10);
            return;
        }

        public void attachView(@NonNull View r10, int r11, LayoutParams r12) {
            ViewHolder r13 = RecyclerView.getChildViewHolderInt(r10);
            if (r13.isRemoved() == false) goto L5;
            this.mRecyclerView.mViewInfoStore.b(r13);
        L6:
            this.mChildHelper.attachViewToParent(r10, r11, r12, r13.isRemoved());
            return;
        L5:
            this.mRecyclerView.mViewInfoStore.p(r13);
            goto L6
        }

        public void calculateItemDecorationsForChild(@NonNull View r10, @NonNull Rect r11) {
            RecyclerView r12 = this.mRecyclerView;
            if (r12 != null) goto L6;
            r11.set(0, 0, 0, 0);
            return;
        L6:
            r11.set(r12.getItemDecorInsetsForChild(r10));
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams r10) {
            if (r10 == null) goto L4;
            return true;
        L4:
            return false;
        }

        @SuppressLint({"UnknownNullness"})
        public void collectAdjacentPrefetchPositions(int r10, int r11, State r12, LayoutPrefetchRegistry r13) {
        }

        @SuppressLint({"UnknownNullness"})
        public void collectInitialPrefetchPositions(int r10, LayoutPrefetchRegistry r11) {
        }

        public int computeHorizontalScrollExtent(@NonNull State r10) {
            return 0;
        }

        public int computeHorizontalScrollOffset(@NonNull State r10) {
            return 0;
        }

        public int computeHorizontalScrollRange(@NonNull State r10) {
            return 0;
        }

        public int computeVerticalScrollExtent(@NonNull State r10) {
            return 0;
        }

        public int computeVerticalScrollOffset(@NonNull State r10) {
            return 0;
        }

        public int computeVerticalScrollRange(@NonNull State r10) {
            return 0;
        }

        public void detachAndScrapAttachedViews(@NonNull Recycler r10) {
            int r11 = getChildCount() - 1;
        L3:
            if (r11 < 0) goto L5;
            scrapOrRecycleView(r10, r11, getChildAt(r11));
            r11 = r11 - 1;
            goto L3
        }

        public void detachAndScrapView(@NonNull View r10, @NonNull Recycler r11) {
            scrapOrRecycleView(r11, this.mChildHelper.indexOfChild(r10), r10);
        }

        public void detachAndScrapViewAt(int r10, @NonNull Recycler r11) {
            scrapOrRecycleView(r11, r10, getChildAt(r10));
        }

        public void detachView(@NonNull View r10) {
            int r11 = this.mChildHelper.indexOfChild(r10);
            if (r11 < 0) goto L6;
            detachViewInternal(r11, r10);
            return;
        }

        public void detachViewAt(int r10) {
            detachViewInternal(r10, getChildAt(r10));
        }

        public void dispatchAttachedToWindow(RecyclerView r10) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(r10);
        }

        public void dispatchDetachedFromWindow(RecyclerView r10, Recycler r11) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(r10, r11);
        }

        @SuppressLint({"UnknownNullness"})
        public void endAnimation(View r10) {
            ItemAnimator r11 = this.mRecyclerView.mItemAnimator;
            if (r11 == null) goto L6;
            r11.j(RecyclerView.getChildViewHolderInt(r10));
            return;
        }

        @Nullable
        public View findContainingItemView(@NonNull View r10) {
            RecyclerView r11 = this.mRecyclerView;
            if (r11 != null) goto L5;
            return null;
        L5:
            View r12 = r11.findContainingItemView(r10);
            if (r12 != null) goto L9;
            return null;
        L9:
            if (this.mChildHelper.isHidden(r12) == false) goto L11;
            return null;
        L11:
            return r12;
        }

        @Nullable
        public View findViewByPosition(int r10) {
            int r11 = getChildCount();
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L17;
            View r13 = getChildAt(r12);
            ViewHolder r14 = RecyclerView.getChildViewHolderInt(r13);
            if (r14 == null) goto L16;
            if (r14.getLayoutPosition() != r10) goto L16;
            if (r14.shouldIgnore() == true) goto L16;
            if (this.mRecyclerView.mState.f() == true) goto L15;
            if (r14.isRemoved() == true) goto L16;
        L15:
            return r13;
        L16:
            r12 = r12 + 1;
            goto L3
        L17:
            return null;
        }

        @SuppressLint({"UnknownNullness"})
        public abstract LayoutParams generateDefaultLayoutParams();

        @SuppressLint({"UnknownNullness"})
        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
            if ((r10 instanceof LayoutParams) == false) goto L7;
            return new LayoutParams((LayoutParams) r10);
        L7:
            if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
            return new LayoutParams((ViewGroup.MarginLayoutParams) r10);
        L11:
            return new LayoutParams(r10);
        }

        public int getBaseline() {
            return -1;
        }

        public int getBottomDecorationHeight(@NonNull View r10) {
            return ((LayoutParams) r10.getLayoutParams()).mDecorInsets.bottom;
        }

        @Nullable
        public View getChildAt(int r10) {
            ChildHelper r11 = this.mChildHelper;
            if (r11 != null) goto L7;
            return null;
        L7:
            return r11.getChildAt(r10);
        }

        public int getChildCount() {
            ChildHelper r10 = this.mChildHelper;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return r10.getChildCount();
        }

        public boolean getClipToPadding() {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 != null) goto L5;
        L7:
            return false;
        L5:
            if (r10.mClipToPadding == false) goto L7;
            return true;
        }

        public int getColumnCountForAccessibility(@NonNull Recycler r10, @NonNull State r11) {
            return -1;
        }

        public int getDecoratedBottom(@NonNull View r10) {
            return r10.getBottom() + getBottomDecorationHeight(r10);
        }

        public void getDecoratedBoundsWithMargins(@NonNull View r10, @NonNull Rect r11) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(r10, r11);
        }

        public int getDecoratedLeft(@NonNull View r10) {
            return r10.getLeft() - getLeftDecorationWidth(r10);
        }

        public int getDecoratedMeasuredHeight(@NonNull View r10) {
            Rect r11 = ((LayoutParams) r10.getLayoutParams()).mDecorInsets;
            return (r10.getMeasuredHeight() + r11.top) + r11.bottom;
        }

        public int getDecoratedMeasuredWidth(@NonNull View r10) {
            Rect r11 = ((LayoutParams) r10.getLayoutParams()).mDecorInsets;
            return (r10.getMeasuredWidth() + r11.left) + r11.right;
        }

        public int getDecoratedRight(@NonNull View r10) {
            return r10.getRight() + getRightDecorationWidth(r10);
        }

        public int getDecoratedTop(@NonNull View r10) {
            return r10.getTop() - getTopDecorationHeight(r10);
        }

        @Nullable
        public View getFocusedChild() {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 != null) goto L5;
            return null;
        L5:
            View r11 = r10.getFocusedChild();
            if (r11 != null) goto L8;
        L11:
            return null;
        L8:
            if (this.mChildHelper.isHidden(r11) == true) goto L11;
            return r11;
        }

        @Px
        public int getHeight() {
            return this.mHeight;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getItemCount() {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 == null) goto L5;
            Adapter r11 = r10.getAdapter();
        L6:
            if (r11 != null) goto L10;
            return 0;
        L10:
            return r11.getItemCount();
        L5:
            r11 = null;
            goto L6
        }

        public int getItemViewType(@NonNull View r10) {
            return RecyclerView.getChildViewHolderInt(r10).getItemViewType();
        }

        public int getLayoutDirection() {
            return ViewCompat.A(this.mRecyclerView);
        }

        public int getLeftDecorationWidth(@NonNull View r10) {
            return ((LayoutParams) r10.getLayoutParams()).mDecorInsets.left;
        }

        @Px
        public int getMinimumHeight() {
            return ViewCompat.B(this.mRecyclerView);
        }

        @Px
        public int getMinimumWidth() {
            return ViewCompat.C(this.mRecyclerView);
        }

        @Px
        public int getPaddingBottom() {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return r10.getPaddingBottom();
        }

        @Px
        public int getPaddingEnd() {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return ViewCompat.E(r10);
        }

        @Px
        public int getPaddingLeft() {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return r10.getPaddingLeft();
        }

        @Px
        public int getPaddingRight() {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return r10.getPaddingRight();
        }

        @Px
        public int getPaddingStart() {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return ViewCompat.F(r10);
        }

        @Px
        public int getPaddingTop() {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 != null) goto L7;
            return 0;
        L7:
            return r10.getPaddingTop();
        }

        public int getPosition(@NonNull View r10) {
            return ((LayoutParams) r10.getLayoutParams()).getViewLayoutPosition();
        }

        public int getRightDecorationWidth(@NonNull View r10) {
            return ((LayoutParams) r10.getLayoutParams()).mDecorInsets.right;
        }

        public int getRowCountForAccessibility(@NonNull Recycler r10, @NonNull State r11) {
            return -1;
        }

        public int getSelectionModeForAccessibility(@NonNull Recycler r10, @NonNull State r11) {
            return 0;
        }

        public int getTopDecorationHeight(@NonNull View r10) {
            return ((LayoutParams) r10.getLayoutParams()).mDecorInsets.top;
        }

        public void getTransformedBoundingBox(@NonNull View r10, boolean r11, @NonNull Rect r12) {
            if (r11 == false) goto L4;
            Rect r13 = ((LayoutParams) r10.getLayoutParams()).mDecorInsets;
            r12.set(-r13.left, -r13.top, r10.getWidth() + r13.right, r10.getHeight() + r13.bottom);
        L6:
            if (this.mRecyclerView == null) goto L12;
            Matrix r14 = r10.getMatrix();
            if (r14 == null) goto L12;
            if (r14.isIdentity() == true) goto L12;
            RectF r15 = this.mRecyclerView.mTempRectF;
            r15.set(r12);
            r14.mapRect(r15);
            r12.set((int) Math.floor(r15.left), (int) Math.floor(r15.top), (int) Math.ceil(r15.right), (int) Math.ceil(r15.bottom));
        L12:
            r12.offset(r10.getLeft(), r10.getTop());
            return;
        L4:
            r12.set(0, 0, r10.getWidth(), r10.getHeight());
            goto L6
        }

        @Px
        public int getWidth() {
            return this.mWidth;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public boolean hasFlexibleChildInBothOrientations() {
            int r10 = getChildCount();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L11;
            ViewGroup.LayoutParams r12 = getChildAt(r11).getLayoutParams();
            if (r12.width >= 0) goto L10;
            if (r12.height >= 0) goto L10;
            return true;
        L10:
            r11 = r11 + 1;
            goto L3
        L11:
            return false;
        }

        public boolean hasFocus() {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 != null) goto L5;
        L7:
            return false;
        L5:
            if (r10.hasFocus() == false) goto L7;
            return true;
        }

        public void ignoreView(@NonNull View r10) {
            ViewParent r11 = r10.getParent();
            RecyclerView r12 = this.mRecyclerView;
            if (r11 != r12) goto L9;
            if (r12.indexOfChild(r10) == (-1)) goto L9;
            ViewHolder r13 = RecyclerView.getChildViewHolderInt(r10);
            r13.addFlags(128);
            this.mRecyclerView.mViewInfoStore.q(r13);
            return;
        L9:
            throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.exceptionLabel());
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public boolean isFocused() {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 != null) goto L5;
        L7:
            return false;
        L5:
            if (r10.isFocused() == false) goto L7;
            return true;
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public boolean isLayoutHierarchical(@NonNull Recycler r10, @NonNull State r11) {
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public boolean isSmoothScrolling() {
            SmoothScroller r10 = this.mSmoothScroller;
            if (r10 != null) goto L5;
        L7:
            return false;
        L5:
            if (r10.isRunning() == false) goto L7;
            return true;
        }

        public boolean isViewPartiallyVisible(@NonNull View r10, boolean r11, boolean r12) {
            if (this.mHorizontalBoundCheck.b(r10, 24579) == true) goto L5;
        L7:
            boolean r13 = false;
        L8:
            if (r11 == false) goto L11;
            return r13;
        L11:
            return !r13;
        L5:
            if (this.mVerticalBoundCheck.b(r10, 24579) == false) goto L7;
            r13 = true;
            goto L8
        }

        public void layoutDecorated(@NonNull View r10, int r11, int r12, int r13, int r14) {
            Rect r15 = ((LayoutParams) r10.getLayoutParams()).mDecorInsets;
            r10.layout(r11 + r15.left, r12 + r15.top, r13 - r15.right, r14 - r15.bottom);
        }

        public void layoutDecoratedWithMargins(@NonNull View r10, int r11, int r12, int r13, int r14) {
            LayoutParams r15 = (LayoutParams) r10.getLayoutParams();
            Rect r16 = r15.mDecorInsets;
            r10.layout((r11 + r16.left) + ((ViewGroup.MarginLayoutParams) r15).leftMargin, (r12 + r16.top) + ((ViewGroup.MarginLayoutParams) r15).topMargin, (r13 - r16.right) - ((ViewGroup.MarginLayoutParams) r15).rightMargin, (r14 - r16.bottom) - ((ViewGroup.MarginLayoutParams) r15).bottomMargin);
        }

        public void measureChild(@NonNull View r10, int r11, int r12) {
            LayoutParams r13 = (LayoutParams) r10.getLayoutParams();
            Rect r14 = this.mRecyclerView.getItemDecorInsetsForChild(r10);
            int r15 = r11 + (r14.left + r14.right);
            int r16 = r12 + (r14.top + r14.bottom);
            int r17 = getChildMeasureSpec(getWidth(), getWidthMode(), (getPaddingLeft() + getPaddingRight()) + r15, ((ViewGroup.MarginLayoutParams) r13).width, canScrollHorizontally());
            int r18 = getChildMeasureSpec(getHeight(), getHeightMode(), (getPaddingTop() + getPaddingBottom()) + r16, ((ViewGroup.MarginLayoutParams) r13).height, canScrollVertically());
            if (shouldMeasureChild(r10, r17, r18, r13) == false) goto L6;
            r10.measure(r17, r18);
            return;
        }

        public void measureChildWithMargins(@NonNull View r10, int r11, int r12) {
            LayoutParams r13 = (LayoutParams) r10.getLayoutParams();
            Rect r14 = this.mRecyclerView.getItemDecorInsetsForChild(r10);
            int r15 = r11 + (r14.left + r14.right);
            int r16 = r12 + (r14.top + r14.bottom);
            int r17 = getChildMeasureSpec(getWidth(), getWidthMode(), (((getPaddingLeft() + getPaddingRight()) + ((ViewGroup.MarginLayoutParams) r13).leftMargin) + ((ViewGroup.MarginLayoutParams) r13).rightMargin) + r15, ((ViewGroup.MarginLayoutParams) r13).width, canScrollHorizontally());
            int r18 = getChildMeasureSpec(getHeight(), getHeightMode(), (((getPaddingTop() + getPaddingBottom()) + ((ViewGroup.MarginLayoutParams) r13).topMargin) + ((ViewGroup.MarginLayoutParams) r13).bottomMargin) + r16, ((ViewGroup.MarginLayoutParams) r13).height, canScrollVertically());
            if (shouldMeasureChild(r10, r17, r18, r13) == false) goto L6;
            r10.measure(r17, r18);
            return;
        }

        public void moveView(int r10, int r11) {
            View r12 = getChildAt(r10);
            if (r12 == null) goto L7;
            detachViewAt(r10);
            attachView(r12, r11);
            return;
        L7:
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + r10 + this.mRecyclerView.toString());
        }

        public void offsetChildrenHorizontal(@Px int r10) {
            RecyclerView r11 = this.mRecyclerView;
            if (r11 == null) goto L6;
            r11.offsetChildrenHorizontal(r10);
            return;
        }

        public void offsetChildrenVertical(@Px int r10) {
            RecyclerView r11 = this.mRecyclerView;
            if (r11 == null) goto L6;
            r11.offsetChildrenVertical(r10);
            return;
        }

        public void onAdapterChanged(@Nullable Adapter r10, @Nullable Adapter r11) {
        }

        public boolean onAddFocusables(@NonNull RecyclerView r10, @NonNull ArrayList<View> r11, int r12, int r13) {
            return false;
        }

        @CallSuper
        public void onAttachedToWindow(RecyclerView r10) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView r10) {
        }

        @Nullable
        public View onFocusSearchFailed(@NonNull View r10, int r11, @NonNull Recycler r12, @NonNull State r13) {
            return null;
        }

        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent r10) {
            RecyclerView r11 = this.mRecyclerView;
            onInitializeAccessibilityEvent(r11.mRecycler, r11.mState, r10);
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat r10) {
            RecyclerView r11 = this.mRecyclerView;
            onInitializeAccessibilityNodeInfo(r11.mRecycler, r11.mState, r10);
        }

        public void onInitializeAccessibilityNodeInfoForItem(@NonNull Recycler r10, @NonNull State r11, @NonNull View r12, @NonNull AccessibilityNodeInfoCompat r13) {
        }

        @Nullable
        public View onInterceptFocusSearch(@NonNull View r10, int r11) {
            return null;
        }

        public void onItemsAdded(@NonNull RecyclerView r10, int r11, int r12) {
        }

        public void onItemsChanged(@NonNull RecyclerView r10) {
        }

        public void onItemsMoved(@NonNull RecyclerView r10, int r11, int r12, int r13) {
        }

        public void onItemsRemoved(@NonNull RecyclerView r10, int r11, int r12) {
        }

        public void onItemsUpdated(@NonNull RecyclerView r10, int r11, int r12) {
        }

        @SuppressLint({"UnknownNullness"})
        public void onLayoutChildren(Recycler r10, State r11) {
            Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        @SuppressLint({"UnknownNullness"})
        public void onLayoutCompleted(State r10) {
        }

        public void onMeasure(@NonNull Recycler r10, @NonNull State r11, int r12, int r13) {
            this.mRecyclerView.defaultOnMeasure(r12, r13);
        }

        @Deprecated
        public boolean onRequestChildFocus(@NonNull RecyclerView r10, @NonNull View r11, @Nullable View r12) {
            if (isSmoothScrolling() == false) goto L5;
        L8:
            return true;
        L5:
            if (r10.isComputingLayout() == true) goto L8;
            return false;
        }

        @SuppressLint({"UnknownNullness"})
        public void onRestoreInstanceState(Parcelable r10) {
        }

        @Nullable
        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int r10) {
        }

        public void onSmoothScrollerStopped(SmoothScroller r10) {
            if (this.mSmoothScroller != r10) goto L6;
            this.mSmoothScroller = null;
            return;
        }

        public boolean performAccessibilityAction(int r10, @Nullable Bundle r11) {
            RecyclerView r12 = this.mRecyclerView;
            return performAccessibilityAction(r12.mRecycler, r12.mState, r10, r11);
        }

        public boolean performAccessibilityActionForItem(@NonNull Recycler r10, @NonNull State r11, @NonNull View r12, int r13, @Nullable Bundle r14) {
            return false;
        }

        public void postOnAnimation(Runnable r10) {
            RecyclerView r11 = this.mRecyclerView;
            if (r11 == null) goto L6;
            ViewCompat.h0(r11, r10);
            return;
        }

        public void removeAllViews() {
            int r10 = getChildCount() - 1;
        L3:
            if (r10 < 0) goto L5;
            this.mChildHelper.removeViewAt(r10);
            r10 = r10 - 1;
            goto L3
        }

        public void removeAndRecycleAllViews(@NonNull Recycler r10) {
            int r11 = getChildCount() - 1;
        L3:
            if (r11 < 0) goto L8;
            if (RecyclerView.getChildViewHolderInt(getChildAt(r11)).shouldIgnore() == true) goto L7;
            removeAndRecycleViewAt(r11, r10);
        L7:
            r11 = r11 - 1;
            goto L3
        }

        public void removeAndRecycleScrapInt(Recycler r10) {
            int r11 = r10.j();
            int r12 = r11 - 1;
        L3:
            if (r12 < 0) goto L15;
            View r13 = r10.n(r12);
            ViewHolder r14 = RecyclerView.getChildViewHolderInt(r13);
            if (r14.shouldIgnore() == true) goto L14;
            r14.setIsRecyclable(false);
            if (r14.isTmpDetached() == false) goto L10;
            this.mRecyclerView.removeDetachedView(r13, false);
        L10:
            ItemAnimator r15 = this.mRecyclerView.mItemAnimator;
            if (r15 == null) goto L13;
            r15.j(r14);
        L13:
            r14.setIsRecyclable(true);
            r10.D(r13);
        L14:
            r12 = r12 - 1;
            goto L3
        L15:
            r10.e();
            if (r11 <= 0) goto L22;
            this.mRecyclerView.invalidate();
            return;
        }

        public void removeAndRecycleView(@NonNull View r10, @NonNull Recycler r11) {
            removeView(r10);
            r11.G(r10);
        }

        public void removeAndRecycleViewAt(int r10, @NonNull Recycler r11) {
            View r12 = getChildAt(r10);
            removeViewAt(r10);
            r11.G(r12);
        }

        public boolean removeCallbacks(Runnable r10) {
            RecyclerView r11 = this.mRecyclerView;
            if (r11 != null) goto L5;
            return false;
        L5:
            return r11.removeCallbacks(r10);
        }

        public void removeDetachedView(@NonNull View r10) {
            this.mRecyclerView.removeDetachedView(r10, false);
        }

        @SuppressLint({"UnknownNullness"})
        public void removeView(View r10) {
            this.mChildHelper.removeView(r10);
        }

        public void removeViewAt(int r10) {
            if (getChildAt(r10) == null) goto L6;
            this.mChildHelper.removeViewAt(r10);
            return;
        }

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView r10, @NonNull View r11, @NonNull Rect r12, boolean r13) {
            return requestChildRectangleOnScreen(r10, r11, r12, r13, false);
        }

        public void requestLayout() {
            RecyclerView r10 = this.mRecyclerView;
            if (r10 == null) goto L6;
            r10.requestLayout();
            return;
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        @SuppressLint({"UnknownNullness"})
        public int scrollHorizontallyBy(int r10, Recycler r11, State r12) {
            return 0;
        }

        public void scrollToPosition(int r10) {
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L6;
            Log.e(RecyclerView.TAG, "You MUST implement scrollToPosition. It will soon become abstract");
            return;
        }

        @SuppressLint({"UnknownNullness"})
        public int scrollVerticallyBy(int r10, Recycler r11, State r12) {
            return 0;
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean r10) {
            this.mAutoMeasure = r10;
        }

        public void setExactMeasureSpecsFrom(RecyclerView r10) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(r10.getWidth(), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(r10.getHeight(), Ints.MAX_POWER_OF_TWO));
        }

        public final void setItemPrefetchEnabled(boolean r10) {
            if (r10 == this.mItemPrefetchEnabled) goto L8;
            this.mItemPrefetchEnabled = r10;
            this.mPrefetchMaxCountObserved = 0;
            RecyclerView r11 = this.mRecyclerView;
            if (r11 == null) goto L9;
            r11.mRecycler.P();
            return;
        L9:
            return;
        }

        public void setMeasureSpecs(int r10, int r11) {
            this.mWidth = View.MeasureSpec.getSize(r10);
            int r12 = View.MeasureSpec.getMode(r10);
            this.mWidthMode = r12;
            if (r12 == 0) goto L5;
        L7:
            this.mHeight = View.MeasureSpec.getSize(r11);
            int r13 = View.MeasureSpec.getMode(r11);
            this.mHeightMode = r13;
            if (r13 == 0) goto L10;
            return;
        L10:
            if (RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC == true) goto L14;
            this.mHeight = 0;
            return;
        L14:
            return;
        L5:
            if (RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC == true) goto L7;
            this.mWidth = 0;
            goto L7
        }

        public void setMeasuredDimension(Rect r10, int r11, int r12) {
            int r13 = (r10.width() + getPaddingLeft()) + getPaddingRight();
            int r14 = (r10.height() + getPaddingTop()) + getPaddingBottom();
            setMeasuredDimension(chooseSize(r11, r13, getMinimumWidth()), chooseSize(r12, r14, getMinimumHeight()));
        }

        public void setMeasuredDimensionFromChildren(int r10, int r11) {
            int r12 = getChildCount();
            if (r12 != 0) goto L6;
            this.mRecyclerView.defaultOnMeasure(r10, r11);
            return;
        L6:
            int r13 = Integer.MIN_VALUE;
            int r14 = Integer.MAX_VALUE;
            int r15 = 0;
            int r16 = Integer.MIN_VALUE;
            int r17 = Integer.MAX_VALUE;
        L7:
            if (r15 >= r12) goto L21;
            View r18 = getChildAt(r15);
            Rect r19 = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(r18, r19);
            int r20 = r19.left;
            if (r20 >= r17) goto L11;
            r17 = r20;
        L11:
            int r21 = r19.right;
            if (r21 <= r13) goto L14;
            r13 = r21;
        L14:
            int r22 = r19.top;
            if (r22 >= r14) goto L17;
            r14 = r22;
        L17:
            int r23 = r19.bottom;
            if (r23 <= r16) goto L20;
            r16 = r23;
        L20:
            r15 = r15 + 1;
            goto L7
        L21:
            this.mRecyclerView.mTempRect.set(r17, r14, r13, r16);
            setMeasuredDimension(this.mRecyclerView.mTempRect, r10, r11);
        }

        public void setMeasurementCacheEnabled(boolean r10) {
            this.mMeasurementCacheEnabled = r10;
        }

        public void setRecyclerView(RecyclerView r10) {
            if (r10 != null) goto L4;
            this.mRecyclerView = null;
            this.mChildHelper = null;
            this.mWidth = 0;
            this.mHeight = 0;
        L5:
            this.mWidthMode = Ints.MAX_POWER_OF_TWO;
            this.mHeightMode = Ints.MAX_POWER_OF_TWO;
            return;
        L4:
            this.mRecyclerView = r10;
            this.mChildHelper = r10.mChildHelper;
            this.mWidth = r10.getWidth();
            this.mHeight = r10.getHeight();
            goto L5
        }

        public boolean shouldMeasureChild(View r10, int r11, int r12, LayoutParams r13) {
            if (r10.isLayoutRequested() == false) goto L5;
        L12:
            return true;
        L5:
            if (this.mMeasurementCacheEnabled == false) goto L12;
            if (isMeasurementUpToDate(r10.getWidth(), r11, ((ViewGroup.MarginLayoutParams) r13).width) == false) goto L12;
            if (isMeasurementUpToDate(r10.getHeight(), r12, ((ViewGroup.MarginLayoutParams) r13).height) == false) goto L12;
            return false;
        }

        public boolean shouldMeasureTwice() {
            return false;
        }

        public boolean shouldReMeasureChild(View r10, int r11, int r12, LayoutParams r13) {
            if (this.mMeasurementCacheEnabled == true) goto L5;
        L10:
            return true;
        L5:
            if (isMeasurementUpToDate(r10.getMeasuredWidth(), r11, ((ViewGroup.MarginLayoutParams) r13).width) == false) goto L10;
            if (isMeasurementUpToDate(r10.getMeasuredHeight(), r12, ((ViewGroup.MarginLayoutParams) r13).height) == false) goto L10;
            return false;
        }

        @SuppressLint({"UnknownNullness"})
        public void smoothScrollToPosition(RecyclerView r10, State r11, int r12) {
            Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        @SuppressLint({"UnknownNullness"})
        public void startSmoothScroll(SmoothScroller r10) {
            SmoothScroller r11 = this.mSmoothScroller;
            if (r11 == null) goto L8;
            if (r10 == r11) goto L8;
            if (r11.isRunning() == false) goto L8;
            this.mSmoothScroller.stop();
        L8:
            this.mSmoothScroller = r10;
            r10.start(this.mRecyclerView, this);
        }

        public void stopIgnoringView(@NonNull View r10) {
            ViewHolder r11 = RecyclerView.getChildViewHolderInt(r10);
            r11.stopIgnoring();
            r11.resetInternal();
            r11.addFlags(4);
        }

        public void stopSmoothScroller() {
            SmoothScroller r10 = this.mSmoothScroller;
            if (r10 == null) goto L6;
            r10.stop();
            return;
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        @SuppressLint({"UnknownNullness"})
        public void addDisappearingView(View r10, int r11) {
            addViewInt(r10, r11, true);
        }

        @SuppressLint({"UnknownNullness"})
        public void addView(View r10, int r11) {
            addViewInt(r10, r11, false);
        }

        @SuppressLint({"UnknownNullness"})
        @CallSuper
        public void onDetachedFromWindow(RecyclerView r10, Recycler r11) {
            onDetachedFromWindow(r10);
        }

        public void onInitializeAccessibilityEvent(@NonNull Recycler r10, @NonNull State r11, @NonNull AccessibilityEvent r12) {
            RecyclerView r13 = this.mRecyclerView;
            if (r13 == null) goto L20;
            if (r12 == null) goto L22;
            boolean r14 = true;
            if (r13.canScrollVertically(1) == false) goto L9;
        L16:
            r12.setScrollable(r14);
            Adapter r15 = this.mRecyclerView.mAdapter;
            if (r15 == null) goto L21;
            r12.setItemCount(r15.getItemCount());
            return;
        L21:
            return;
        L9:
            if (this.mRecyclerView.canScrollVertically(-1) == true) goto L16;
            if (this.mRecyclerView.canScrollHorizontally(-1) == true) goto L16;
            if (this.mRecyclerView.canScrollHorizontally(1) == true) goto L16;
            r14 = false;
            goto L16
        L22:
            return;
        }

        public void onInitializeAccessibilityNodeInfo(@NonNull Recycler r10, @NonNull State r11, @NonNull AccessibilityNodeInfoCompat r12) {
            if (this.mRecyclerView.canScrollVertically(-1) == false) goto L5;
        L6:
            r12.a(8192);
            r12.r0(true);
        L8:
            if (this.mRecyclerView.canScrollVertically(1) == false) goto L10;
        L11:
            r12.a(4096);
            r12.r0(true);
        L12:
            r12.X(AccessibilityNodeInfoCompat.b.b(getRowCountForAccessibility(r10, r11), getColumnCountForAccessibility(r10, r11), isLayoutHierarchical(r10, r11), getSelectionModeForAccessibility(r10, r11)));
            return;
        L10:
            if (this.mRecyclerView.canScrollHorizontally(1) == false) goto L12;
        L5:
            if (this.mRecyclerView.canScrollHorizontally(-1) == false) goto L8;
            goto L6
        }

        public void onInitializeAccessibilityNodeInfoForItem(View r10, AccessibilityNodeInfoCompat r11) {
            ViewHolder r12 = RecyclerView.getChildViewHolderInt(r10);
            if (r12 != null) goto L5;
            return;
        L5:
            if (r12.isRemoved() == false) goto L7;
            return;
        L7:
            if (this.mChildHelper.isHidden(r12.itemView) == true) goto L12;
            RecyclerView r13 = this.mRecyclerView;
            onInitializeAccessibilityNodeInfoForItem(r13.mRecycler, r13.mState, r10, r11);
            return;
        }

        public void onItemsUpdated(@NonNull RecyclerView r10, int r11, int r12, @Nullable Object r13) {
            onItemsUpdated(r10, r11, r12);
        }

        public boolean onRequestChildFocus(@NonNull RecyclerView r10, @NonNull State r11, @NonNull View r12, @Nullable View r13) {
            return onRequestChildFocus(r10, r12, r13);
        }

        public boolean performAccessibilityAction(@NonNull Recycler r10, @NonNull State r11, int r12, @Nullable Bundle r13) {
            if (this.mRecyclerView != null) goto L5;
            return false;
        L5:
            int r14 = getHeight();
            int r15 = getWidth();
            Rect r16 = new Rect();
            if (this.mRecyclerView.getMatrix().isIdentity() == false) goto L11;
            if (this.mRecyclerView.getGlobalVisibleRect(r16) == false) goto L11;
            r14 = r16.height();
            r15 = r16.width();
        L11:
            if (r12 == 4096) goto L25;
            if (r12 == 8192) goto L16;
            int r17 = 0;
            int r18 = 0;
        L31:
            if (r18 != 0) goto L34;
            if (r17 != 0) goto L34;
            return false;
        L34:
            this.mRecyclerView.smoothScrollBy(r17, r18, null, Integer.MIN_VALUE, true);
            return true;
        L16:
            if (this.mRecyclerView.canScrollVertically(-1) == false) goto L18;
            int r19 = -((r14 - getPaddingTop()) - getPaddingBottom());
        L20:
            if (this.mRecyclerView.canScrollHorizontally(-1) == false) goto L23;
            int r110 = -((r15 - getPaddingLeft()) - getPaddingRight());
        L22:
            r18 = r19;
            r17 = r110;
        L23:
            r18 = r19;
            r17 = 0;
            goto L31
        L18:
            r19 = 0;
            goto L20
        L25:
            if (this.mRecyclerView.canScrollVertically(1) == false) goto L27;
            r19 = (r14 - getPaddingTop()) - getPaddingBottom();
        L29:
            if (this.mRecyclerView.canScrollHorizontally(1) == false) goto L23;
            r110 = (r15 - getPaddingLeft()) - getPaddingRight();
            goto L22
        L27:
            r19 = 0;
            goto L29
        }

        public boolean performAccessibilityActionForItem(@NonNull View r10, int r11, @Nullable Bundle r12) {
            RecyclerView r13 = this.mRecyclerView;
            return performAccessibilityActionForItem(r13.mRecycler, r13.mState, r10, r11, r12);
        }

        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView r10, @NonNull View r11, @NonNull Rect r12, boolean r13, boolean r14) {
            int[] r15 = getChildRectangleOnScreenScrollAmount(r11, r12);
            int r16 = r15[0];
            int r17 = r15[1];
            if (r14 == true) goto L5;
        L6:
            if (r16 != 0) goto L10;
            if (r17 != 0) goto L10;
        L9:
            return false;
        L10:
            if (r13 == false) goto L12;
            r10.scrollBy(r16, r17);
        L13:
            return true;
        L12:
            r10.smoothScrollBy(r16, r17);
            goto L13
        L5:
            if (isFocusedChildVisibleAfterScrolling(r10, r16, r17) == false) goto L9;
            goto L6
        }

        public static int getChildMeasureSpec(int r10, int r11, int r12, int r13, boolean r14) {
            int r15 = Math.max(0, r10 - r12);
            if (r14 == false) goto L11;
            if (r13 < 0) goto L6;
        L5:
            r11 = 1073741824;
        L22:
            return View.MeasureSpec.makeMeasureSpec(r13, r11);
        L6:
            if (r13 != (-1)) goto L10;
            if (r11 == Integer.MIN_VALUE) goto L14;
            if (r11 == 0) goto L10;
            if (r11 != 1073741824) goto L10;
        L14:
            r13 = r15;
        L10:
            r11 = 0;
            r13 = 0;
            goto L22
        L11:
            if (r13 >= 0) goto L5;
            if (r13 == (-1)) goto L14;
            if (r13 != (-2)) goto L10;
            if (r11 == Integer.MIN_VALUE) goto L20;
            if (r11 == 1073741824) goto L20;
            r13 = r15;
            r11 = 0;
        L20:
            r13 = r15;
            r11 = Integer.MIN_VALUE;
            goto L22
        }

        public void attachView(@NonNull View r10, int r11) {
            attachView(r10, r11, (LayoutParams) r10.getLayoutParams());
        }

        @SuppressLint({"UnknownNullness"})
        public LayoutParams generateLayoutParams(Context r10, AttributeSet r11) {
            return new LayoutParams(r10, r11);
        }

        public void setMeasuredDimension(int r10, int r11) {
            RecyclerView.access$500(this.mRecyclerView, r10, r11);
        }

        public void attachView(@NonNull View r10) {
            attachView(r10, -1);
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        final Rect mDecorInsets;
        boolean mInsetsDirty;
        boolean mPendingInvalidate;
        ViewHolder mViewHolder;

        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public int getAbsoluteAdapterPosition() {
            return this.mViewHolder.getAbsoluteAdapterPosition();
        }

        public int getBindingAdapterPosition() {
            return this.mViewHolder.getBindingAdapterPosition();
        }

        @Deprecated
        public int getViewAdapterPosition() {
            return this.mViewHolder.getBindingAdapterPosition();
        }

        public int getViewLayoutPosition() {
            return this.mViewHolder.getLayoutPosition();
        }

        @Deprecated
        public int getViewPosition() {
            return this.mViewHolder.getPosition();
        }

        public boolean isItemChanged() {
            return this.mViewHolder.isUpdated();
        }

        public boolean isItemRemoved() {
            return this.mViewHolder.isRemoved();
        }

        public boolean isViewInvalid() {
            return this.mViewHolder.isInvalid();
        }

        public boolean viewNeedsUpdate() {
            return this.mViewHolder.needsUpdate();
        }

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r10) {
            super(r10);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(LayoutParams r10) {
            super(r10);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }
    }

    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow(@NonNull View r10);

        void onChildViewDetachedFromWindow(@NonNull View r10);
    }

    public static abstract class OnFlingListener {
        public OnFlingListener() {
        }

        public abstract boolean a(int r10, int r11);
    }

    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(@NonNull RecyclerView r10, @NonNull MotionEvent r11);

        void onRequestDisallowInterceptTouchEvent(boolean r10);

        void onTouchEvent(@NonNull RecyclerView r10, @NonNull MotionEvent r11);
    }

    public static abstract class OnScrollListener {
        public OnScrollListener() {
        }

        public void onScrollStateChanged(@NonNull RecyclerView r10, int r11) {
        }

        public void onScrolled(@NonNull RecyclerView r10, int r11, int r12) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface Orientation {
    }

    public static class RecycledViewPool {
        private static final int DEFAULT_MAX_SCRAP = 5;
        int mAttachCountForClearing;
        Set<Adapter> mAttachedAdaptersForPoolingContainer;
        SparseArray<a> mScrap;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ArrayList f4203a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f4204b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public long f4205c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public long f4206d;

            public a() {
                this.f4203a = new ArrayList();
                this.f4204b = 5;
                this.f4205c = 0;
                this.f4206d = 0;
            }
        }

        public RecycledViewPool() {
            this.mScrap = new SparseArray();
            this.mAttachCountForClearing = 0;
            this.mAttachedAdaptersForPoolingContainer = Collections.newSetFromMap(new IdentityHashMap());
        }

        public final a a(int r10) {
            a r11 = this.mScrap.get(r10);
            if (r11 != null) goto L6;
            a r12 = new a();
            this.mScrap.put(r10, r12);
            return r12;
        L6:
            return r11;
        }

        public void attach() {
            this.mAttachCountForClearing++;
        }

        public void attachForPoolingContainer(@NonNull Adapter r10) {
            this.mAttachedAdaptersForPoolingContainer.add(r10);
        }

        public void clear() {
            int r10 = 0;
        L4:
            if (r10 >= this.mScrap.size()) goto L10;
            a r11 = this.mScrap.valueAt(r10);
            Iterator r12 = r11.f4203a.iterator();
        L7:
            if (r12.hasNext() == false) goto L9;
            t.a.a(((ViewHolder) r12.next()).itemView);
            goto L7
        L9:
            r11.f4203a.clear();
            r10 = r10 + 1;
            goto L4
        }

        public void detach() {
            this.mAttachCountForClearing--;
        }

        public void detachForPoolingContainer(@NonNull Adapter r10, boolean r11) {
            this.mAttachedAdaptersForPoolingContainer.remove(r10);
            if (this.mAttachedAdaptersForPoolingContainer.size() != 0) goto L13;
            if (r11 == true) goto L16;
            int r12 = 0;
        L7:
            if (r12 >= this.mScrap.size()) goto L17;
            SparseArray<a> r13 = this.mScrap;
            ArrayList r14 = r13.get(r13.keyAt(r12)).f4203a;
            int r15 = 0;
        L10:
            if (r15 >= r14.size()) goto L12;
            t.a.a(((ViewHolder) r14.get(r15)).itemView);
            r15 = r15 + 1;
            goto L10
        L12:
            r12 = r12 + 1;
            goto L7
        L17:
            return;
        L16:
            return;
        }

        public void factorInBindTime(int r10, long r11) {
            a r12 = a(r10);
            r12.f4206d = runningAverage(r12.f4206d, r11);
        }

        public void factorInCreateTime(int r10, long r11) {
            a r12 = a(r10);
            r12.f4205c = runningAverage(r12.f4205c, r11);
        }

        public ViewHolder getRecycledView(int r10) {
            a r11 = this.mScrap.get(r10);
            if (r11 != null) goto L5;
            return null;
        L5:
            if (r11.f4203a.isEmpty() == true) goto L17;
            ArrayList r12 = r11.f4203a;
            int r13 = r12.size() - 1;
        L7:
            if (r13 < 0) goto L18;
            if (((ViewHolder) r12.get(r13)).isAttachedToTransitionOverlay() == false) goto L11;
            r13 = r13 - 1;
            goto L7
        L11:
            return (ViewHolder) r12.remove(r13);
        L18:
            return null;
        L17:
            return null;
        }

        public int getRecycledViewCount(int r10) {
            return a(r10).f4203a.size();
        }

        public void onAdapterChanged(Adapter r10, Adapter r11, boolean r12) {
            if (r10 == null) goto L4;
            detach();
        L4:
            if (r12 == false) goto L6;
        L8:
            if (r11 == null) goto L11;
            attach();
            return;
        L11:
            return;
        L6:
            if (this.mAttachCountForClearing != 0) goto L8;
            clear();
            goto L8
        }

        public void putRecycledView(ViewHolder r10) {
            int r11 = r10.getItemViewType();
            ArrayList r12 = a(r11).f4203a;
            if (this.mScrap.get(r11).f4204b > r12.size()) goto L7;
            t.a.a(r10.itemView);
            return;
        L7:
            if (RecyclerView.sDebugAssertionsEnabled == true) goto L9;
        L13:
            r10.resetInternal();
            r12.add(r10);
            return;
        L9:
            if (r12.contains(r10) == false) goto L13;
            throw new IllegalArgumentException("this scrap item already exists");
        }

        public long runningAverage(long r10, long r11) {
            if (r10 != 0) goto L6;
            return r11;
        L6:
            return ((r10 / 4) * 3) + (r11 / 4);
        }

        public void setMaxRecycledViews(int r10, int r11) {
            a r12 = a(r10);
            r12.f4204b = r11;
            ArrayList r13 = r12.f4203a;
        L4:
            if (r13.size() <= r11) goto L6;
            r13.remove(r13.size() - 1);
            goto L4
        }

        public boolean willBindInTime(int r10, long r11, long r12) {
            long r13 = a(r10).f4206d;
            if (r13 != 0) goto L5;
        L8:
            return true;
        L5:
            if ((r11 + r13) < r12) goto L8;
            return false;
        }

        public boolean willCreateInTime(int r10, long r11, long r12) {
            long r13 = a(r10).f4205c;
            if (r13 != 0) goto L5;
        L8:
            return true;
        L5:
            if ((r11 + r13) < r12) goto L8;
            return false;
        }
    }

    public final class Recycler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList f4207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f4208b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ArrayList f4209c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f4210d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4211e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f4212f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public RecycledViewPool f4213g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ViewCacheExtension f4214h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f4215i;

        public Recycler(RecyclerView r10) {
            this.f4215i = r10;
            ArrayList r11 = new ArrayList();
            this.f4207a = r11;
            this.f4208b = null;
            this.f4209c = new ArrayList();
            this.f4210d = Collections.unmodifiableList(r11);
            this.f4211e = 2;
            this.f4212f = 2;
        }

        public void A() {
            int r10 = 0;
        L4:
            if (r10 >= this.f4209c.size()) goto L6;
            t.a.a(((ViewHolder) this.f4209c.get(r10)).itemView);
            r10 = r10 + 1;
            goto L4
        L6:
            B(this.f4215i.mAdapter);
        }

        public final void B(Adapter r10) {
            C(r10, false);
        }

        public final void C(Adapter r10, boolean r11) {
            RecycledViewPool r12 = this.f4213g;
            if (r12 == null) goto L6;
            r12.detachForPoolingContainer(r10, r11);
            return;
        }

        public void D(View r10) {
            ViewHolder r11 = RecyclerView.getChildViewHolderInt(r10);
            r11.mScrapContainer = null;
            r11.mInChangeScrap = false;
            r11.clearReturnedFromScrapFlag();
            H(r11);
        }

        public void E() {
            int r10 = this.f4209c.size() - 1;
        L3:
            if (r10 < 0) goto L5;
            F(r10);
            r10 = r10 - 1;
            goto L3
        L5:
            this.f4209c.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L10;
            this.f4215i.mPrefetchRegistry.a();
            return;
        }

        public void F(int r10) {
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L5;
            Log.d(RecyclerView.TAG, "Recycling cached view at index " + r10);
        L5:
            ViewHolder r11 = (ViewHolder) this.f4209c.get(r10);
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L8;
            Log.d(RecyclerView.TAG, "CachedViewHolder to be recycled: " + r11);
        L8:
            a(r11, true);
            this.f4209c.remove(r10);
        }

        public void G(View r10) {
            ViewHolder r11 = RecyclerView.getChildViewHolderInt(r10);
            if (r11.isTmpDetached() == false) goto L6;
            this.f4215i.removeDetachedView(r10, false);
        L6:
            if (r11.isScrap() == false) goto L9;
            r11.unScrap();
        L11:
            H(r11);
            if (this.f4215i.mItemAnimator != null) goto L14;
            return;
        L14:
            if (r11.isRecyclable() == true) goto L18;
            this.f4215i.mItemAnimator.j(r11);
            return;
        L18:
            return;
        L9:
            if (r11.wasReturnedFromScrap() == false) goto L11;
            r11.clearReturnedFromScrapFlag();
            goto L11
        }

        public void H(ViewHolder r10) {
            boolean r11 = false;
            boolean r12 = true;
            if (r10.isScrap() == false) goto L5;
        L69:
            StringBuilder r13 = new StringBuilder();
            r13.append("Scrapped or attached views may not be recycled. isScrap:");
            r13.append(r10.isScrap());
            r13.append(" isAttached:");
            if (r10.itemView.getParent() == null) goto L72;
            r11 = true;
        L72:
            r13.append(r11);
            r13.append(this.f4215i.exceptionLabel());
            throw new IllegalArgumentException(r13.toString());
        L5:
            if (r10.itemView.getParent() != null) goto L69;
            if (r10.isTmpDetached() == true) goto L68;
            if (r10.shouldIgnore() == true) goto L66;
            boolean r14 = r10.doesTransientStatePreventRecycling();
            Adapter r15 = this.f4215i.mAdapter;
            if (r15 == null) goto L17;
            if (r14 == false) goto L17;
            if (r15.onFailedToRecycleView(r10) == false) goto L17;
            boolean r16 = true;
        L19:
            if (RecyclerView.sDebugAssertionsEnabled == true) goto L21;
        L25:
            if (r16 == true) goto L34;
            if (r10.isRecyclable() == true) goto L34;
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L32;
            Log.d(RecyclerView.TAG, "trying to recycle a non-recycleable holder. Hopefully, it will re-visit here. We are still removing it from animation lists" + this.f4215i.exceptionLabel());
        L32:
            r12 = false;
        L59:
            this.f4215i.mViewInfoStore.q(r10);
            if (r11 == true) goto L76;
            if (r12 == true) goto L77;
            if (r14 == false) goto L78;
            t.a.a(r10.itemView);
            r10.mBindingAdapter = null;
            r10.mOwnerRecyclerView = null;
            return;
        L78:
            return;
        L77:
            return;
        L76:
            return;
        L34:
            if (this.f4212f > 0) goto L36;
        L54:
            boolean r17 = false;
        L55:
            if (r17 == true) goto L58;
            a(r10, true);
        L57:
            r11 = r17;
            goto L59
        L58:
            r12 = false;
            goto L57
        L36:
            if (r10.hasAnyOfTheFlags(526) == true) goto L54;
            int r18 = this.f4209c.size();
            if (r18 < this.f4212f) goto L42;
            if (r18 <= 0) goto L42;
            F(0);
            r18 = r18 - 1;
        L42:
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L53;
            if (r18 <= 0) goto L53;
            if (this.f4215i.mPrefetchRegistry.c(r10.mPosition) == true) goto L53;
            int r19 = r18 - 1;
        L47:
            if (r19 < 0) goto L52;
            if (this.f4215i.mPrefetchRegistry.c(((ViewHolder) this.f4209c.get(r19)).mPosition) == false) goto L52;
            r19 = r19 - 1;
        L52:
            r18 = r19 + 1;
        L53:
            this.f4209c.add(r18, r10);
            r17 = true;
            goto L55
        L21:
            if (this.f4209c.contains(r10) == false) goto L25;
            throw new IllegalArgumentException("cached view received recycle internal? " + r10 + this.f4215i.exceptionLabel());
        L17:
            r16 = false;
            goto L19
        L66:
            throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + this.f4215i.exceptionLabel());
        L68:
            throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + r10 + this.f4215i.exceptionLabel());
        }

        public void I(View r10) {
            ViewHolder r11 = RecyclerView.getChildViewHolderInt(r10);
            if (r11.hasAnyOfTheFlags(12) == true) goto L14;
            if (r11.isUpdated() == false) goto L14;
            if (this.f4215i.canReuseUpdatedViewHolder(r11) == true) goto L14;
            if (this.f4208b != null) goto L12;
            this.f4208b = new ArrayList();
        L12:
            r11.setScrapContainer(this, true);
            this.f4208b.add(r11);
            return;
        L14:
            if (r11.isInvalid() == true) goto L16;
        L22:
            r11.setScrapContainer(this, false);
            this.f4207a.add(r11);
            return;
        L16:
            if (r11.isRemoved() == true) goto L22;
            if (this.f4215i.mAdapter.hasStableIds() == true) goto L22;
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + this.f4215i.exceptionLabel());
        }

        public void J(RecycledViewPool r10) {
            B(this.f4215i.mAdapter);
            RecycledViewPool r11 = this.f4213g;
            if (r11 == null) goto L5;
            r11.detach();
        L5:
            this.f4213g = r10;
            if (r10 != null) goto L8;
        L10:
            u();
            return;
        L8:
            if (this.f4215i.getAdapter() == null) goto L10;
            this.f4213g.attach();
            goto L10
        }

        public void K(ViewCacheExtension r10) {
            this.f4214h = r10;
        }

        public void L(int r10) {
            this.f4211e = r10;
            P();
        }

        public final boolean M(ViewHolder r11, int r12, int r13, long r14) {
            r11.mBindingAdapter = null;
            r11.mOwnerRecyclerView = this.f4215i;
            int r10 = r11.getItemViewType();
            long r15 = this.f4215i.getNanoTime();
            boolean r16 = false;
            if (r14 == RecyclerView.FOREVER_NS) goto L8;
            if (this.f4213g.willBindInTime(r10, r15, r14) == true) goto L8;
            return false;
        L8:
            if (r11.isTmpDetached() == false) goto L10;
            RecyclerView r17 = this.f4215i;
            RecyclerView.access$300(r17, r11.itemView, r17.getChildCount(), r11.itemView.getLayoutParams());
            r16 = true;
        L10:
            this.f4215i.mAdapter.bindViewHolder(r11, r12);
            if (r16 == false) goto L13;
            RecyclerView.access$400(this.f4215i, r11.itemView);
        L13:
            this.f4213g.factorInBindTime(r11.getItemViewType(), this.f4215i.getNanoTime() - r15);
            b(r11);
            if (this.f4215i.mState.f() == false) goto L16;
            r11.mPreLayoutPosition = r13;
        L16:
            return true;
        }

        public ViewHolder N(int r19, boolean r20, long r21) {
            if (r19 < 0) goto L123;
            if (r19 >= this.f4215i.mState.c()) goto L123;
            boolean r10 = true;
            if (this.f4215i.mState.f() == false) goto L11;
            ViewHolder r11 = h(r19);
            if (r11 == null) goto L12;
            boolean r12 = true;
        L13:
            if (r11 != null) goto L28;
            r11 = m(r19, r20);
            if (r11 == null) goto L28;
            if (Q(r11) == true) goto L27;
            if (r20 == true) goto L26;
            r11.addFlags(4);
            if (r11.isScrap() == false) goto L23;
            this.f4215i.removeDetachedView(r11.itemView, false);
            r11.unScrap();
        L25:
            H(r11);
            goto L26
        L23:
            if (r11.wasReturnedFromScrap() == false) goto L25;
            r11.clearReturnedFromScrapFlag();
        L26:
            r11 = null;
            goto L28
        L27:
            r12 = true;
        L28:
            if (r11 != null) goto L76;
            int r13 = this.f4215i.mAdapterHelper.k(r19);
            if (r13 < 0) goto L78;
            if (r13 >= this.f4215i.mAdapter.getItemCount()) goto L78;
            int r14 = this.f4215i.mAdapter.getItemViewType(r13);
            if (this.f4215i.mAdapter.hasStableIds() == false) goto L38;
            r11 = l(this.f4215i.mAdapter.getItemId(r13), r14, r20);
            if (r11 == null) goto L38;
            r11.mPosition = r13;
            r12 = true;
        L38:
            if (r11 != null) goto L53;
            ViewCacheExtension r15 = this.f4214h;
            if (r15 == null) goto L53;
            View r16 = r15.a(this, r19, r14);
            if (r16 == null) goto L53;
            r11 = this.f4215i.getChildViewHolder(r16);
            if (r11 == null) goto L51;
            if (r11.shouldIgnore() == false) goto L53;
            throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + this.f4215i.exceptionLabel());
        L51:
            throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + this.f4215i.exceptionLabel());
        L53:
            if (r11 == null) goto L55;
        L62:
            if (r11 != null) goto L76;
            long r17 = this.f4215i.getNanoTime();
            if (r21 != RecyclerView.FOREVER_NS) goto L66;
        L68:
            RecyclerView r18 = this.f4215i;
            r11 = r18.mAdapter.createViewHolder(r18, r14);
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L73;
            RecyclerView r22 = RecyclerView.findNestedRecyclerView(r11.itemView);
            if (r22 == null) goto L73;
            r11.mNestedRecyclerView = new WeakReference(r22);
        L73:
            this.f4213g.factorInCreateTime(r14, this.f4215i.getNanoTime() - r17);
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L76;
            Log.d(RecyclerView.TAG, "tryGetViewHolderForPositionByDeadline created new ViewHolder");
            goto L76
        L66:
            if (this.f4213g.willCreateInTime(r14, r17, r21) == true) goto L68;
            return null;
        L55:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L57;
            Log.d(RecyclerView.TAG, "tryGetViewHolderForPositionByDeadline(" + r19 + ") fetching from shared pool");
        L57:
            r11 = i().getRecycledView(r14);
            if (r11 == null) goto L62;
            r11.resetInternal();
            if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST == false) goto L62;
            r(r11);
        L78:
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + r19 + "(offset:" + r13 + ").state:" + this.f4215i.mState.c() + this.f4215i.exceptionLabel());
        L76:
            ViewHolder r23 = r11;
            boolean r110 = r12;
            if (r110 == false) goto L88;
            if (this.f4215i.mState.f() == true) goto L88;
            if (r23.hasAnyOfTheFlags(8192) == false) goto L88;
            r23.setFlags(0, 8192);
            if (this.f4215i.mState.f4234k == false) goto L88;
            int r24 = ItemAnimator.e(r23) | 4096;
            RecyclerView r25 = this.f4215i;
            this.f4215i.recordAnimationInfoIfBouncedHiddenView(r23, r25.mItemAnimator.u(r25.mState, r23, r24, r23.getUnmodifiedPayloads()));
        L88:
            if (this.f4215i.mState.f() == false) goto L93;
            if (r23.isBound() == false) goto L93;
            r23.mPreLayoutPosition = r19;
        L99:
            boolean r26 = false;
        L108:
            ViewGroup.LayoutParams r27 = r23.itemView.getLayoutParams();
            if (r27 != null) goto L112;
            LayoutParams r28 = (LayoutParams) this.f4215i.generateDefaultLayoutParams();
            r23.itemView.setLayoutParams(r28);
        L115:
            r28.mViewHolder = r23;
            if (r110 == false) goto L119;
            if (r26 == false) goto L119;
        L120:
            r28.mPendingInvalidate = r10;
            return r23;
        L119:
            r10 = false;
            goto L120
        L112:
            if (this.f4215i.checkLayoutParams(r27) == true) goto L114;
            r28 = (LayoutParams) this.f4215i.generateLayoutParams(r27);
            r23.itemView.setLayoutParams(r28);
            goto L115
        L114:
            r28 = (LayoutParams) r27;
        L93:
            if (r23.isBound() == false) goto L101;
            if (r23.needsUpdate() == true) goto L101;
            if (r23.isInvalid() == false) goto L99;
        L101:
            if (RecyclerView.sDebugAssertionsEnabled == true) goto L103;
        L107:
            r26 = M(r23, this.f4215i.mAdapterHelper.k(r19), r19, r21);
            goto L108
        L103:
            if (r23.isRemoved() == false) goto L107;
            throw new IllegalStateException("Removed holder should be bound and it should come here only in pre-layout. Holder: " + r23 + this.f4215i.exceptionLabel());
        L12:
            r12 = false;
            goto L13
        L11:
            r11 = null;
        L123:
            throw new IndexOutOfBoundsException("Invalid item position " + r19 + "(" + r19 + "). Item count:" + this.f4215i.mState.c() + this.f4215i.exceptionLabel());
        }

        public void O(ViewHolder r10) {
            if (r10.mInChangeScrap == false) goto L5;
            this.f4208b.remove(r10);
        L6:
            r10.mScrapContainer = null;
            r10.mInChangeScrap = false;
            r10.clearReturnedFromScrapFlag();
            return;
        L5:
            this.f4207a.remove(r10);
            goto L6
        }

        public void P() {
            LayoutManager r10 = this.f4215i.mLayout;
            if (r10 == null) goto L5;
            int r11 = r10.mPrefetchMaxCountObserved;
        L6:
            this.f4212f = this.f4211e + r11;
            int r12 = this.f4209c.size() - 1;
        L7:
            if (r12 < 0) goto L11;
            if (this.f4209c.size() <= this.f4212f) goto L14;
            F(r12);
            r12 = r12 - 1;
            goto L7
        L14:
            return;
        L11:
            return;
        L5:
            r11 = 0;
            goto L6
        }

        public boolean Q(ViewHolder r10) {
            if (r10.isRemoved() == true) goto L5;
            int r11 = r10.mPosition;
            if (r11 < 0) goto L30;
            if (r11 >= this.f4215i.mAdapter.getItemCount()) goto L30;
            if (this.f4215i.mState.f() == true) goto L23;
            if (this.f4215i.mAdapter.getItemViewType(r10.mPosition) == r10.getItemViewType()) goto L23;
            return false;
        L23:
            if (this.f4215i.mAdapter.hasStableIds() == true) goto L25;
            return true;
        L25:
            if (r10.getItemId() == this.f4215i.mAdapter.getItemId(r10.mPosition)) goto L27;
            return false;
        L27:
            return true;
        L30:
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + r10 + this.f4215i.exceptionLabel());
        L5:
            if (RecyclerView.sDebugAssertionsEnabled == false) goto L12;
            if (this.f4215i.mState.f() == true) goto L12;
            throw new IllegalStateException("should not receive a removed view unless it is pre layout" + this.f4215i.exceptionLabel());
        L12:
            return this.f4215i.mState.f();
        }

        public void R(int r10, int r11) {
            int r12 = r11 + r10;
            int r13 = this.f4209c.size() - 1;
        L3:
            if (r13 < 0) goto L12;
            ViewHolder r14 = (ViewHolder) this.f4209c.get(r13);
            if (r14 == null) goto L11;
            int r15 = r14.mPosition;
            if (r15 < r10) goto L11;
            if (r15 >= r12) goto L11;
            r14.addFlags(2);
            F(r13);
        L11:
            r13 = r13 - 1;
            goto L3
        }

        public void a(ViewHolder r10, boolean r11) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(r10);
            View r12 = r10.itemView;
            RecyclerViewAccessibilityDelegate r13 = this.f4215i.mAccessibilityDelegate;
            if (r13 == null) goto L9;
            androidx.core.view.a r14 = r13.getItemDelegate();
            if ((r14 instanceof RecyclerViewAccessibilityDelegate.a) == false) goto L7;
            androidx.core.view.a r15 = ((RecyclerViewAccessibilityDelegate.a) r14).c(r12);
        L8:
            ViewCompat.p0(r12, r15);
            goto L9
        L7:
            r15 = null;
        L9:
            if (r11 == false) goto L11;
            g(r10);
        L11:
            r10.mBindingAdapter = null;
            r10.mOwnerRecyclerView = null;
            i().putRecycledView(r10);
        }

        public final void b(ViewHolder r10) {
            if (this.f4215i.isAccessibilityEnabled() == false) goto L15;
            View r11 = r10.itemView;
            if (ViewCompat.y(r11) != 0) goto L7;
            ViewCompat.A0(r11, 1);
        L7:
            RecyclerViewAccessibilityDelegate r12 = this.f4215i.mAccessibilityDelegate;
            if (r12 != null) goto L10;
            return;
        L10:
            androidx.core.view.a r13 = r12.getItemDelegate();
            if ((r13 instanceof RecyclerViewAccessibilityDelegate.a) == false) goto L13;
            ((RecyclerViewAccessibilityDelegate.a) r13).d(r11);
        L13:
            ViewCompat.p0(r11, r13);
            return;
        }

        public void c() {
            this.f4207a.clear();
            E();
        }

        public void d() {
            int r10 = this.f4209c.size();
            int r11 = 0;
            int r12 = 0;
        L3:
            if (r12 >= r10) goto L5;
            ((ViewHolder) this.f4209c.get(r12)).clearOldPosition();
            r12 = r12 + 1;
            goto L3
        L5:
            int r13 = this.f4207a.size();
            int r14 = 0;
        L6:
            if (r14 >= r13) goto L8;
            ((ViewHolder) this.f4207a.get(r14)).clearOldPosition();
            r14 = r14 + 1;
            goto L6
        L8:
            ArrayList r15 = this.f4208b;
            if (r15 == null) goto L13;
            int r16 = r15.size();
        L11:
            if (r11 >= r16) goto L17;
            ((ViewHolder) this.f4208b.get(r11)).clearOldPosition();
            r11 = r11 + 1;
            goto L11
        L17:
            return;
        }

        public void e() {
            this.f4207a.clear();
            ArrayList r10 = this.f4208b;
            if (r10 == null) goto L6;
            r10.clear();
            return;
        }

        public int f(int r10) {
            if (r10 < 0) goto L11;
            if (r10 >= this.f4215i.mState.c()) goto L11;
            if (this.f4215i.mState.f() == true) goto L9;
            return r10;
        L9:
            return this.f4215i.mAdapterHelper.k(r10);
        L11:
            throw new IndexOutOfBoundsException("invalid position " + r10 + ". State item count is " + this.f4215i.mState.c() + this.f4215i.exceptionLabel());
        }

        public void g(ViewHolder r10) {
            RecyclerListener r11 = this.f4215i.mRecyclerListener;
            if (r11 == null) goto L5;
            r11.onViewRecycled(r10);
        L5:
            int r12 = this.f4215i.mRecyclerListeners.size();
            int r13 = 0;
        L6:
            if (r13 >= r12) goto L8;
            this.f4215i.mRecyclerListeners.get(r13).onViewRecycled(r10);
            r13 = r13 + 1;
            goto L6
        L8:
            Adapter r14 = this.f4215i.mAdapter;
            if (r14 == null) goto L11;
            r14.onViewRecycled(r10);
        L11:
            RecyclerView r15 = this.f4215i;
            if (r15.mState == null) goto L15;
            r15.mViewInfoStore.q(r10);
        L15:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L19;
            Log.d(RecyclerView.TAG, "dispatchViewRecycled: " + r10);
            return;
        }

        public ViewHolder h(int r10) {
            ArrayList r11 = this.f4208b;
            if (r11 == null) goto L32;
            int r12 = r11.size();
            if (r12 == 0) goto L32;
            int r13 = 0;
            int r14 = 0;
        L9:
            if (r14 >= r12) goto L18;
            ViewHolder r15 = (ViewHolder) this.f4208b.get(r14);
            if (r15.wasReturnedFromScrap() == true) goto L16;
            if (r15.getLayoutPosition() != r10) goto L16;
            r15.addFlags(32);
            return r15;
        L16:
            r14 = r14 + 1;
            goto L9
        L18:
            if (this.f4215i.mAdapter.hasStableIds() == false) goto L32;
            int r16 = this.f4215i.mAdapterHelper.k(r10);
            if (r16 <= 0) goto L32;
            if (r16 >= this.f4215i.mAdapter.getItemCount()) goto L32;
            long r17 = this.f4215i.mAdapter.getItemId(r16);
        L24:
            if (r13 >= r12) goto L32;
            ViewHolder r18 = (ViewHolder) this.f4208b.get(r13);
            if (r18.wasReturnedFromScrap() == true) goto L31;
            if (r18.getItemId() != r17) goto L31;
            r18.addFlags(32);
            return r18;
        L31:
            r13 = r13 + 1;
        L32:
            return null;
        }

        public RecycledViewPool i() {
            if (this.f4213g != null) goto L6;
            this.f4213g = new RecycledViewPool();
            u();
        L6:
            return this.f4213g;
        }

        public int j() {
            return this.f4207a.size();
        }

        public List k() {
            return this.f4210d;
        }

        public ViewHolder l(long r10, int r11, boolean r12) {
            int r13 = this.f4207a.size() - 1;
        L3:
            if (r13 < 0) goto L19;
            ViewHolder r14 = (ViewHolder) this.f4207a.get(r13);
            if (r14.getItemId() != r10) goto L18;
            if (r14.wasReturnedFromScrap() == true) goto L18;
            if (r11 == r14.getItemViewType()) goto L10;
            if (r12 == true) goto L18;
            this.f4207a.remove(r13);
            this.f4215i.removeDetachedView(r14.itemView, false);
            D(r14.itemView);
            goto L18
        L10:
            r14.addFlags(32);
            if (r14.isRemoved() == true) goto L13;
        L15:
            return r14;
        L13:
            if (this.f4215i.mState.f() == true) goto L15;
            r14.setFlags(2, 14);
        L18:
            r13 = r13 - 1;
            goto L3
        L19:
            int r15 = this.f4209c.size();
        L20:
            r15 = r15 - 1;
            if (r15 < 0) goto L35;
            ViewHolder r16 = (ViewHolder) this.f4209c.get(r15);
            if (r16.getItemId() != r10) goto L20;
            if (r16.isAttachedToTransitionOverlay() == true) goto L20;
            if (r11 == r16.getItemViewType()) goto L28;
            if (r12 == true) goto L20;
            F(r15);
            return null;
        L28:
            if (r12 == true) goto L30;
            this.f4209c.remove(r15);
        L30:
            return r16;
        L35:
            return null;
        }

        public ViewHolder m(int r10, boolean r11) {
            int r12 = this.f4207a.size();
            int r13 = 0;
            int r14 = 0;
        L3:
            if (r14 >= r12) goto L17;
            ViewHolder r15 = (ViewHolder) this.f4207a.get(r14);
            if (r15.wasReturnedFromScrap() == true) goto L16;
            if (r15.getLayoutPosition() != r10) goto L16;
            if (r15.isInvalid() == true) goto L16;
            if (this.f4215i.mState.f4231h == true) goto L14;
            if (r15.isRemoved() == true) goto L16;
        L14:
            r15.addFlags(32);
            return r15;
        L16:
            r14 = r14 + 1;
            goto L3
        L17:
            if (r11 == true) goto L26;
            View r16 = this.f4215i.mChildHelper.findHiddenNonRemovedView(r10);
            if (r16 == null) goto L26;
            ViewHolder r17 = RecyclerView.getChildViewHolderInt(r16);
            this.f4215i.mChildHelper.unhide(r16);
            int r18 = this.f4215i.mChildHelper.indexOfChild(r16);
            if (r18 == (-1)) goto L25;
            this.f4215i.mChildHelper.detachViewFromParent(r18);
            I(r16);
            r17.addFlags(8224);
            return r17;
        L25:
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + r17 + this.f4215i.exceptionLabel());
        L26:
            int r19 = this.f4209c.size();
        L27:
            if (r13 >= r19) goto L41;
            ViewHolder r20 = (ViewHolder) this.f4209c.get(r13);
            if (r20.isInvalid() == true) goto L40;
            if (r20.getLayoutPosition() != r10) goto L40;
            if (r20.isAttachedToTransitionOverlay() == true) goto L40;
            if (r11 == true) goto L37;
            this.f4209c.remove(r13);
        L37:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L39;
            Log.d(RecyclerView.TAG, "getScrapOrHiddenOrCachedHolderForPosition(" + r10 + ") found match in cache: " + r20);
        L39:
            return r20;
        L40:
            r13 = r13 + 1;
            goto L27
        L41:
            return null;
        }

        public View n(int r10) {
            return ((ViewHolder) this.f4207a.get(r10)).itemView;
        }

        public View o(int r10) {
            return p(r10, false);
        }

        public View p(int r10, boolean r11) {
            return N(r10, r11, RecyclerView.FOREVER_NS).itemView;
        }

        public final void q(ViewGroup r10, boolean r11) {
            int r12 = r10.getChildCount() - 1;
        L3:
            if (r12 < 0) goto L8;
            View r13 = r10.getChildAt(r12);
            if ((r13 instanceof ViewGroup) == false) goto L7;
            q((ViewGroup) r13, true);
        L7:
            r12 = r12 - 1;
            goto L3
        L8:
            if (r11 == true) goto L11;
            return;
        L11:
            if (r10.getVisibility() != 4) goto L13;
            r10.setVisibility(0);
            r10.setVisibility(4);
            return;
        L13:
            int r14 = r10.getVisibility();
            r10.setVisibility(4);
            r10.setVisibility(r14);
        }

        public final void r(ViewHolder r10) {
            View r11 = r10.itemView;
            if ((r11 instanceof ViewGroup) == false) goto L6;
            q((ViewGroup) r11, false);
            return;
        }

        public void s() {
            int r10 = this.f4209c.size();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L8;
            LayoutParams r12 = (LayoutParams) ((ViewHolder) this.f4209c.get(r11)).itemView.getLayoutParams();
            if (r12 == null) goto L7;
            r12.mInsetsDirty = true;
        L7:
            r11 = r11 + 1;
            goto L3
        }

        public void t() {
            int r10 = this.f4209c.size();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L8;
            ViewHolder r12 = (ViewHolder) this.f4209c.get(r11);
            if (r12 == null) goto L7;
            r12.addFlags(6);
            r12.addChangePayload(null);
        L7:
            r11 = r11 + 1;
            goto L3
        L8:
            Adapter r13 = this.f4215i.mAdapter;
            if (r13 != null) goto L11;
        L12:
            E();
            return;
        L11:
            if (r13.hasStableIds() == false) goto L12;
        }

        public final void u() {
            if (this.f4213g == null) goto L10;
            RecyclerView r10 = this.f4215i;
            if (r10.mAdapter != null) goto L7;
            return;
        L7:
            if (r10.isAttachedToWindow() == false) goto L12;
            this.f4213g.attachForPoolingContainer(this.f4215i.mAdapter);
            return;
        L12:
            return;
        }

        public void v(int r10, int r11) {
            int r12 = this.f4209c.size();
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L13;
            ViewHolder r14 = (ViewHolder) this.f4209c.get(r13);
            if (r14 == null) goto L12;
            if (r14.mPosition < r10) goto L12;
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L11;
            Log.d(RecyclerView.TAG, "offsetPositionRecordsForInsert cached " + r13 + " holder " + r14 + " now at position " + (r14.mPosition + r11));
        L11:
            r14.offsetPosition(r11, false);
        L12:
            r13 = r13 + 1;
            goto L3
        }

        public void w(int r10, int r11) {
            if (r10 >= r11) goto L4;
            int r12 = -1;
            int r13 = r10;
            int r14 = r11;
        L5:
            int r15 = this.f4209c.size();
            int r16 = 0;
        L6:
            if (r16 >= r15) goto L20;
            ViewHolder r17 = (ViewHolder) this.f4209c.get(r16);
            if (r17 == null) goto L19;
            int r18 = r17.mPosition;
            if (r18 < r13) goto L19;
            if (r18 > r14) goto L19;
            if (r18 != r10) goto L15;
            r17.offsetPosition(r11 - r10, false);
        L17:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L19;
            Log.d(RecyclerView.TAG, "offsetPositionRecordsForMove cached child " + r16 + " holder " + r17);
            goto L19
        L15:
            r17.offsetPosition(r12, false);
        L19:
            r16 = r16 + 1;
            goto L6
        L20:
            return;
        L4:
            r12 = 1;
            r14 = r10;
            r13 = r11;
            goto L5
        }

        public void x(int r10, int r11, boolean r12) {
            int r13 = r10 + r11;
            int r14 = this.f4209c.size() - 1;
        L3:
            if (r14 < 0) goto L15;
            ViewHolder r15 = (ViewHolder) this.f4209c.get(r14);
            if (r15 == null) goto L14;
            int r16 = r15.mPosition;
            if (r16 >= r13) goto L9;
            if (r16 < r10) goto L14;
            r15.addFlags(8);
            F(r14);
            goto L14
        L9:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L11;
            Log.d(RecyclerView.TAG, "offsetPositionRecordsForRemove cached " + r14 + " holder " + r15 + " now at position " + (r15.mPosition - r11));
        L11:
            r15.offsetPosition(-r11, r12);
        L14:
            r14 = r14 - 1;
            goto L3
        }

        public void y(Adapter r10, Adapter r11, boolean r12) {
            c();
            C(r10, true);
            i().onAdapterChanged(r10, r11, r12);
            u();
        }

        public void z() {
            u();
        }
    }

    public interface RecyclerListener {
        void onViewRecycled(@NonNull ViewHolder r10);
    }

    public class RecyclerViewDataObserver extends AdapterDataObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f4216a;

        public RecyclerViewDataObserver(RecyclerView r10) {
            this.f4216a = r10;
        }

        public void a() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION == false) goto L9;
            RecyclerView r10 = this.f4216a;
            if (r10.mHasFixedSize == false) goto L9;
            if (r10.mIsAttached == false) goto L9;
            ViewCompat.h0(r10, r10.mUpdateChildViewsRunnable);
            return;
        L9:
            RecyclerView r11 = this.f4216a;
            r11.mAdapterUpdateDuringMeasure = true;
            r11.requestLayout();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            this.f4216a.assertNotInLayoutOrScroll(null);
            RecyclerView r10 = this.f4216a;
            r10.mState.f4230g = true;
            r10.processDataSetCompletelyChanged(true);
            if (this.f4216a.mAdapterHelper.n() == true) goto L6;
            this.f4216a.requestLayout();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int r10, int r11, Object r12) {
            this.f4216a.assertNotInLayoutOrScroll(null);
            if (this.f4216a.mAdapterHelper.p(r10, r11, r12) == false) goto L6;
            a();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int r10, int r11) {
            this.f4216a.assertNotInLayoutOrScroll(null);
            if (this.f4216a.mAdapterHelper.q(r10, r11) == false) goto L6;
            a();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int r10, int r11, int r12) {
            this.f4216a.assertNotInLayoutOrScroll(null);
            if (this.f4216a.mAdapterHelper.r(r10, r11, r12) == false) goto L6;
            a();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int r10, int r11) {
            this.f4216a.assertNotInLayoutOrScroll(null);
            if (this.f4216a.mAdapterHelper.s(r10, r11) == false) goto L6;
            a();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onStateRestorationPolicyChanged() {
            RecyclerView r10 = this.f4216a;
            if (r10.mPendingSavedState != null) goto L5;
            return;
        L5:
            Adapter r11 = r10.mAdapter;
            if (r11 != null) goto L8;
            return;
        L8:
            if (r11.canRestoreState() == false) goto L12;
            this.f4216a.requestLayout();
            return;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Parcelable mLayoutState;

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
            if (r11 != null) goto L6;
            r11 = LayoutManager.class.getClassLoader();
        L6:
            this.mLayoutState = r10.readParcelable(r11);
        }

        public void copyFrom(SavedState r10) {
            this.mLayoutState = r10.mLayoutState;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r10, int r11) {
            super.writeToParcel(r10, r11);
            r10.writeParcelable(this.mLayoutState, 0);
        }

        public SavedState(Parcelable r10) {
            super(r10);
        }
    }

    public static abstract class SmoothScroller {
        private LayoutManager mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private final a mRecyclingAction;
        private boolean mRunning;
        private boolean mStarted;
        private int mTargetPosition;
        private View mTargetView;

        public interface ScrollVectorProvider {
            @Nullable
            PointF computeScrollVectorForPosition(int r10);
        }

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f4217a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f4218b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f4219c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f4220d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Interpolator f4221e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public boolean f4222f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int f4223g;

            public a(int r10, int r11) {
                this(r10, r11, Integer.MIN_VALUE, null);
            }

            public boolean a() {
                if (this.f4220d < 0) goto L5;
                return true;
            L5:
                return false;
            }

            public void b(int r10) {
                this.f4220d = r10;
            }

            public void c(RecyclerView r10) {
                int r11 = this.f4220d;
                if (r11 < 0) goto L7;
                this.f4220d = -1;
                r10.jumpToPositionForSmoothScroller(r11);
                this.f4222f = false;
                return;
            L7:
                if (this.f4222f == false) goto L12;
                e();
                r10.mViewFlinger.e(this.f4217a, this.f4218b, this.f4219c, this.f4221e);
                int r12 = this.f4223g + 1;
                this.f4223g = r12;
                if (r12 <= 10) goto L11;
                Log.e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
            L11:
                this.f4222f = false;
                return;
            L12:
                this.f4223g = 0;
            }

            public void d(int r10, int r11, int r12, Interpolator r13) {
                this.f4217a = r10;
                this.f4218b = r11;
                this.f4219c = r12;
                this.f4221e = r13;
                this.f4222f = true;
            }

            public final void e() {
                if (this.f4221e == null) goto L10;
                if (this.f4219c >= 1) goto L10;
                throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
            L10:
                if (this.f4219c < 1) goto L13;
                return;
            L13:
                throw new IllegalStateException("Scroll duration must be a positive number");
            }

            public a(int r10, int r11, int r12, Interpolator r13) {
                this.f4220d = -1;
                this.f4222f = false;
                this.f4223g = 0;
                this.f4217a = r10;
                this.f4218b = r11;
                this.f4219c = r12;
                this.f4221e = r13;
            }
        }

        public SmoothScroller() {
            this.mTargetPosition = -1;
            this.mRecyclingAction = new a(0, 0);
        }

        @Nullable
        public PointF computeScrollVectorForPosition(int r10) {
            Object r11 = getLayoutManager();
            if ((r11 instanceof ScrollVectorProvider) == true) goto L5;
            Log.w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + ScrollVectorProvider.class.getCanonicalName());
            return null;
        L5:
            return ((ScrollVectorProvider) r11).computeScrollVectorForPosition(r10);
        }

        public View findViewByPosition(int r10) {
            return this.mRecyclerView.mLayout.findViewByPosition(r10);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public int getChildPosition(View r10) {
            return this.mRecyclerView.getChildLayoutPosition(r10);
        }

        @Nullable
        public LayoutManager getLayoutManager() {
            return this.mLayoutManager;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        @Deprecated
        public void instantScrollToPosition(int r10) {
            this.mRecyclerView.scrollToPosition(r10);
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public void normalize(@NonNull PointF r10) {
            float r11 = r10.x;
            float r12 = r10.y;
            float r13 = (float) Math.sqrt((r11 * r11) + (r12 * r12));
            r10.x /= r13;
            r10.y /= r13;
        }

        public void onAnimation(int r10, int r11) {
            RecyclerView r12 = this.mRecyclerView;
            if (this.mTargetPosition == (-1)) goto L5;
            if (r12 == null) goto L5;
        L7:
            if (this.mPendingInitialRun == true) goto L9;
        L19:
            this.mPendingInitialRun = false;
            View r13 = this.mTargetView;
            if (r13 == null) goto L26;
            if (getChildPosition(r13) != this.mTargetPosition) goto L24;
            onTargetFound(this.mTargetView, r12.mState, this.mRecyclingAction);
            this.mRecyclingAction.c(r12);
            stop();
            goto L26
        L24:
            Log.e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
            this.mTargetView = null;
        L26:
            if (this.mRunning == false) goto L33;
            onSeekTargetStep(r10, r11, r12.mState, this.mRecyclingAction);
            boolean r14 = this.mRecyclingAction.a();
            this.mRecyclingAction.c(r12);
            if (r14 == true) goto L30;
            return;
        L30:
            if (this.mRunning == false) goto L35;
            this.mPendingInitialRun = true;
            r12.mViewFlinger.d();
            return;
        L35:
            return;
        L33:
            return;
        L9:
            if (this.mTargetView != null) goto L19;
            if (this.mLayoutManager == null) goto L19;
            PointF r15 = computeScrollVectorForPosition(this.mTargetPosition);
            if (r15 == null) goto L19;
            float r16 = r15.x;
            if (r16 == 0.0f) goto L17;
        L18:
            r12.scrollStep((int) Math.signum(r16), (int) Math.signum(r15.y), null);
            goto L19
        L17:
            if (r15.y == 0.0f) goto L19;
        L5:
            stop();
            goto L7
        }

        public void onChildAttachedToWindow(View r10) {
            if (getChildPosition(r10) != getTargetPosition()) goto L8;
            this.mTargetView = r10;
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L9;
            Log.d(RecyclerView.TAG, "smooth scroll target view has been attached");
            return;
        L9:
            return;
        }

        public abstract void onSeekTargetStep(int r10, int r11, State r12, a r13);

        public abstract void onStart();

        public abstract void onStop();

        public abstract void onTargetFound(View r10, State r11, a r12);

        public void setTargetPosition(int r10) {
            this.mTargetPosition = r10;
        }

        public void start(RecyclerView r10, LayoutManager r11) {
            r10.mViewFlinger.f();
            if (this.mStarted == false) goto L5;
            Log.w(RecyclerView.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
        L5:
            this.mRecyclerView = r10;
            this.mLayoutManager = r11;
            int r12 = this.mTargetPosition;
            if (r12 == (-1)) goto L10;
            r10.mState.f4224a = r12;
            this.mRunning = true;
            this.mPendingInitialRun = true;
            this.mTargetView = findViewByPosition(getTargetPosition());
            onStart();
            this.mRecyclerView.mViewFlinger.d();
            this.mStarted = true;
            return;
        L10:
            throw new IllegalArgumentException("Invalid target position");
        }

        public final void stop() {
            if (this.mRunning == true) goto L5;
            return;
        L5:
            this.mRunning = false;
            onStop();
            this.mRecyclerView.mState.f4224a = -1;
            this.mTargetView = null;
            this.mTargetPosition = -1;
            this.mPendingInitialRun = false;
            this.mLayoutManager.onSmoothScrollerStopped(this);
            this.mLayoutManager = null;
            this.mRecyclerView = null;
        }
    }

    public static class State {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public SparseArray f4225b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4226c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4227d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4228e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f4229f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f4230g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f4231h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f4232i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f4233j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f4234k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f4235l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f4236m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f4237n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f4238o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f4239p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f4240q;

        public State() {
            this.f4224a = -1;
            this.f4226c = 0;
            this.f4227d = 0;
            this.f4228e = 1;
            this.f4229f = 0;
            this.f4230g = false;
            this.f4231h = false;
            this.f4232i = false;
            this.f4233j = false;
            this.f4234k = false;
            this.f4235l = false;
        }

        public void a(int r10) {
            if ((this.f4228e & r10) == 0) goto L6;
            return;
        L6:
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(r10) + " but it is " + Integer.toBinaryString(this.f4228e));
        }

        public boolean b() {
            return this.f4230g;
        }

        public int c() {
            if (this.f4231h == false) goto L6;
            return this.f4226c - this.f4227d;
        L6:
            return this.f4229f;
        }

        public int d() {
            return this.f4224a;
        }

        public boolean e() {
            if (this.f4224a == (-1)) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean f() {
            return this.f4231h;
        }

        public void g(Adapter r10) {
            this.f4228e = 1;
            this.f4229f = r10.getItemCount();
            this.f4231h = false;
            this.f4232i = false;
            this.f4233j = false;
        }

        public boolean h() {
            return this.f4235l;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f4224a + ", mData=" + this.f4225b + ", mItemCount=" + this.f4229f + ", mIsMeasuring=" + this.f4233j + ", mPreviousLayoutItemCount=" + this.f4226c + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f4227d + ", mStructureChanged=" + this.f4230g + ", mInPreLayout=" + this.f4231h + ", mRunSimpleAnimations=" + this.f4234k + ", mRunPredictiveAnimations=" + this.f4235l + '}';
        }
    }

    public static abstract class ViewCacheExtension {
        public abstract View a(Recycler r10, int r11, int r12);
    }

    public class ViewFlinger implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4241a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4242b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public OverScrollerAdapter f4243c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Interpolator f4244d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f4245e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f4246f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f4247g;

        public ViewFlinger(RecyclerView r10) {
            this.f4247g = r10;
            Interpolator r11 = RecyclerView.sQuinticInterpolator;
            this.f4244d = r11;
            this.f4245e = false;
            this.f4246f = false;
            this.f4243c = new OverScrollerAdapter(r10.getContext(), r11);
        }

        public final int a(int r10, int r11) {
            int r12 = Math.abs(r10);
            int r13 = Math.abs(r11);
            if (r12 <= r13) goto L5;
            boolean r14 = true;
        L6:
            RecyclerView r15 = this.f4247g;
            if (r14 == false) goto L9;
            int r16 = r15.getWidth();
        L10:
            if (r14 == true) goto L14;
            r12 = r13;
        L14:
            return Math.min((int) (((r12 / r16) + 1.0f) * 300.0f), 2000);
        L9:
            r16 = r15.getHeight();
            goto L10
        L5:
            r14 = false;
            goto L6
        }

        public void b(int r13, int r14) {
            this.f4247g.setScrollState(2);
            this.f4242b = 0;
            this.f4241a = 0;
            Interpolator r10 = this.f4244d;
            Interpolator r11 = RecyclerView.sQuinticInterpolator;
            if (r10 == r11) goto L5;
            this.f4244d = r11;
            this.f4243c = new OverScrollerAdapter(this.f4247g.getContext(), r11);
        L5:
            this.f4243c.e(0, 0, r13, r14, Integer.MIN_VALUE, Channel.UNLIMITED, Integer.MIN_VALUE, Channel.UNLIMITED);
            d();
        }

        public final void c() {
            this.f4247g.removeCallbacks(this);
            ViewCompat.h0(this.f4247g, this);
        }

        public void d() {
            if (this.f4245e == false) goto L5;
            this.f4246f = true;
            return;
        L5:
            c();
        }

        public void e(int r10, int r11, int r12, Interpolator r13) {
            if (r12 != Integer.MIN_VALUE) goto L5;
            r12 = a(r10, r11);
        L5:
            int r14 = r12;
            if (r13 != null) goto L9;
            r13 = RecyclerView.sQuinticInterpolator;
        L9:
            if (this.f4244d == r13) goto L11;
            this.f4244d = r13;
            this.f4243c = new OverScrollerAdapter(this.f4247g.getContext(), r13);
        L11:
            this.f4242b = 0;
            this.f4241a = 0;
            this.f4247g.setScrollState(2);
            this.f4243c.o(0, 0, r10, r11, r14);
            d();
        }

        public void f() {
            this.f4247g.removeCallbacks(this);
            this.f4243c.a();
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView r10 = this.f4247g;
            if (r10.mLayout != null) goto L6;
            f();
            return;
        L6:
            this.f4246f = false;
            this.f4245e = true;
            r10.consumePendingUpdateOperations();
            OverScrollerAdapter r11 = this.f4243c;
            if (r11.d() == false) goto L80;
            int r12 = r11.g();
            int r13 = r11.h();
            int r14 = r12 - this.f4241a;
            int r15 = r13 - this.f4242b;
            this.f4241a = r12;
            this.f4242b = r13;
            int r16 = this.f4247g.consumeFlingInHorizontalStretch(r14);
            int r17 = this.f4247g.consumeFlingInVerticalStretch(r15);
            RecyclerView r18 = this.f4247g;
            int[] r19 = r18.mReusableIntPair;
            r19[0] = 0;
            r19[1] = 0;
            if (r18.dispatchNestedPreScroll(r16, r17, r19, null, 1) == false) goto L11;
            int[] r20 = this.f4247g.mReusableIntPair;
            r16 = r16 - r20[0];
            r17 = r17 - r20[1];
        L11:
            RecyclerView r21 = this.f4247g;
            if (r21.mAdapter == null) goto L26;
            int[] r22 = r21.mReusableIntPair;
            r22[0] = 0;
            r22[1] = 0;
            r21.scrollStep(r16, r17, r22);
            RecyclerView r23 = this.f4247g;
            int[] r24 = r23.mReusableIntPair;
            int r25 = r24[0];
            int r26 = r24[1];
            r16 = r16 - r25;
            r17 = r17 - r26;
            SmoothScroller r27 = r23.mLayout.mSmoothScroller;
            if (r27 == null) goto L28;
            if (r27.isPendingInitialRun() == true) goto L28;
            if (r27.isRunning() == false) goto L28;
            int r28 = this.f4247g.mState.c();
            if (r28 != 0) goto L23;
            r27.stop();
            goto L28
        L23:
            if (r27.getTargetPosition() < r28) goto L25;
            r27.setTargetPosition(r28 - 1);
            r27.onAnimation(r25, r26);
            goto L28
        L25:
            r27.onAnimation(r25, r26);
        L28:
            if (this.f4247g.mItemDecorations.isEmpty() == true) goto L30;
            this.f4247g.invalidate();
        L30:
            RecyclerView r110 = this.f4247g;
            int[] r29 = r110.mReusableIntPair;
            r29[0] = 0;
            r29[1] = 0;
            r110.dispatchNestedScroll(r25, r26, r16, r17, null, 1, r29);
            RecyclerView r30 = this.f4247g;
            int[] r31 = r30.mReusableIntPair;
            int r32 = r16 - r31[0];
            int r33 = r17 - r31[1];
            if (r25 != 0) goto L33;
            if (r26 != 0) goto L33;
        L35:
            if (RecyclerView.access$200(this.f4247g) == true) goto L38;
            this.f4247g.invalidate();
        L38:
            if (r11.g() != r11.i()) goto L40;
            boolean r34 = true;
        L42:
            if (r11.h() != r11.j()) goto L44;
            boolean r35 = true;
        L46:
            if (r11.n() == true) goto L53;
            if (r34 == true) goto L49;
            if (r32 != 0) goto L49;
        L52:
            boolean r36 = false;
        L54:
            SmoothScroller r37 = this.f4247g.mLayout.mSmoothScroller;
            if (r37 != null) goto L57;
        L59:
            if (r36 == true) goto L61;
        L77:
            d();
            RecyclerView r38 = this.f4247g;
            GapWorker r39 = r38.mGapWorker;
            if (r39 == null) goto L80;
            r39.f(r38, r25, r26);
            goto L80
        L61:
            if (this.f4247g.getOverScrollMode() == 2) goto L75;
            int r40 = (int) r11.f();
            if (r32 >= 0) goto L65;
            int r41 = r40;
        L68:
            if (r33 < 0) goto L73;
            if (r33 <= 0) goto L72;
            r40 = -r40;
            goto L73
        L72:
            r40 = 0;
        L73:
            this.f4247g.absorbGlows(r41, r40);
            goto L75
        L65:
            if (r32 <= 0) goto L67;
            r41 = -r40;
            goto L68
        L67:
            r41 = 0;
        L75:
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L80;
            this.f4247g.mPrefetchRegistry.a();
            goto L80
        L57:
            if (r37.isPendingInitialRun() == false) goto L59;
        L49:
            if (r35 == true) goto L53;
            if (r33 == 0) goto L52;
        L53:
            r36 = true;
            goto L54
        L44:
            r35 = false;
            goto L46
        L40:
            r34 = false;
        L33:
            r30.dispatchOnScrolled(r25, r26);
            goto L35
        L26:
            r26 = 0;
            r25 = 0;
        L80:
            SmoothScroller r42 = this.f4247g.mLayout.mSmoothScroller;
            if (r42 != null) goto L83;
        L85:
            this.f4245e = false;
            if (this.f4246f == false) goto L88;
            c();
            return;
        L88:
            this.f4247g.setScrollState(0);
            this.f4247g.stopNestedScroll(1);
            return;
        L83:
            if (r42.isPendingInitialRun() == false) goto L85;
            r42.onAnimation(0, 0);
            goto L85
        }
    }

    public static abstract class ViewHolder {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = null;
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;

        @NonNull
        public final View itemView;
        Adapter mBindingAdapter;
        int mFlags;
        boolean mInChangeScrap;
        private int mIsRecyclableCount;
        long mItemId;
        int mItemViewType;
        WeakReference<RecyclerView> mNestedRecyclerView;
        int mOldPosition;
        RecyclerView mOwnerRecyclerView;
        List<Object> mPayloads;

        @VisibleForTesting
        int mPendingAccessibilityState;
        int mPosition;
        int mPreLayoutPosition;
        Recycler mScrapContainer;
        ViewHolder mShadowedHolder;
        ViewHolder mShadowingHolder;
        List<Object> mUnmodifiedPayloads;
        private int mWasImportantForAccessibilityBeforeHidden;

        static {
            FULLUPDATE_PAYLOADS = Collections.emptyList();
        }

        public ViewHolder(@NonNull View r10) {
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1;
            this.mItemViewType = -1;
            this.mPreLayoutPosition = -1;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            this.mPayloads = null;
            this.mUnmodifiedPayloads = null;
            this.mIsRecyclableCount = 0;
            this.mScrapContainer = null;
            this.mInChangeScrap = false;
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            if (r10 == null) goto L7;
            this.itemView = r10;
            return;
        L7:
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads != null) goto L6;
            ArrayList r10 = new ArrayList();
            this.mPayloads = r10;
            this.mUnmodifiedPayloads = Collections.unmodifiableList(r10);
            return;
        }

        public void addChangePayload(Object r10) {
            if (r10 != null) goto L6;
            addFlags(1024);
            return;
        L6:
            if ((1024 & this.mFlags) != 0) goto L10;
            createPayloadsIfNeeded();
            this.mPayloads.add(r10);
            return;
        }

        public void addFlags(int r10) {
            this.mFlags = r10 | this.mFlags;
        }

        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        public void clearPayload() {
            List<Object> r10 = this.mPayloads;
            if (r10 == null) goto L5;
            r10.clear();
        L5:
            this.mFlags &= -1025;
        }

        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        public boolean doesTransientStatePreventRecycling() {
            if ((this.mFlags & 16) == 0) goto L5;
        L7:
            return false;
        L5:
            if (ViewCompat.Q(this.itemView) == false) goto L7;
            return true;
        }

        public void flagRemovedAndOffsetPosition(int r10, int r11, boolean r12) {
            addFlags(8);
            offsetPosition(r11, r12);
            this.mPosition = r10;
        }

        public final int getAbsoluteAdapterPosition() {
            RecyclerView r10 = this.mOwnerRecyclerView;
            if (r10 != null) goto L7;
            return -1;
        L7:
            return r10.getAdapterPositionInRecyclerView(this);
        }

        @Deprecated
        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        @Nullable
        public final Adapter getBindingAdapter() {
            return this.mBindingAdapter;
        }

        public final int getBindingAdapterPosition() {
            if (this.mBindingAdapter != null) goto L5;
            return -1;
        L5:
            RecyclerView r10 = this.mOwnerRecyclerView;
            if (r10 != null) goto L8;
            return -1;
        L8:
            Adapter r11 = r10.getAdapter();
            if (r11 != null) goto L11;
            return -1;
        L11:
            int r12 = this.mOwnerRecyclerView.getAdapterPositionInRecyclerView(this);
            if (r12 != (-1)) goto L15;
            return -1;
        L15:
            return r11.findRelativeAdapterPositionIn(this.mBindingAdapter, this, r12);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int r10 = this.mPreLayoutPosition;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            return this.mPosition;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int r10 = this.mPreLayoutPosition;
            if (r10 == (-1)) goto L5;
            return r10;
        L5:
            return this.mPosition;
        }

        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) goto L14;
            List<Object> r10 = this.mPayloads;
            if (r10 == null) goto L12;
            if (r10.size() == 0) goto L12;
            return this.mUnmodifiedPayloads;
        L12:
            return FULLUPDATE_PAYLOADS;
        L14:
            return FULLUPDATE_PAYLOADS;
        }

        public boolean hasAnyOfTheFlags(int r10) {
            if ((this.mFlags & r10) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isAdapterPositionUnknown() {
            if ((this.mFlags & 512) == 0) goto L5;
        L8:
            return true;
        L5:
            if (isInvalid() == true) goto L8;
            return false;
        }

        public boolean isAttachedToTransitionOverlay() {
            if (this.itemView.getParent() != null) goto L5;
        L7:
            return false;
        L5:
            if (this.itemView.getParent() == this.mOwnerRecyclerView) goto L7;
            return true;
        }

        public boolean isBound() {
            if ((this.mFlags & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean isInvalid() {
            if ((this.mFlags & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean isRecyclable() {
            if ((this.mFlags & 16) == 0) goto L5;
        L7:
            return false;
        L5:
            if (ViewCompat.Q(this.itemView) == true) goto L7;
            return true;
        }

        public boolean isRemoved() {
            if ((this.mFlags & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isScrap() {
            if (this.mScrapContainer == null) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isTmpDetached() {
            if ((this.mFlags & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isUpdated() {
            if ((this.mFlags & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean needsUpdate() {
            if ((this.mFlags & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void offsetPosition(int r10, boolean r11) {
            if (this.mOldPosition != (-1)) goto L6;
            this.mOldPosition = this.mPosition;
        L6:
            if (this.mPreLayoutPosition != (-1)) goto L8;
            this.mPreLayoutPosition = this.mPosition;
        L8:
            if (r11 == false) goto L10;
            this.mPreLayoutPosition += r10;
        L10:
            this.mPosition += r10;
            if (this.itemView.getLayoutParams() == null) goto L14;
            ((LayoutParams) this.itemView.getLayoutParams()).mInsetsDirty = true;
            return;
        }

        public void onEnteredHiddenState(RecyclerView r10) {
            int r11 = this.mPendingAccessibilityState;
            if (r11 == (-1)) goto L5;
            this.mWasImportantForAccessibilityBeforeHidden = r11;
        L6:
            r10.setChildImportantForAccessibilityInternal(this, 4);
            return;
        L5:
            this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.y(this.itemView);
            goto L6
        }

        public void onLeftHiddenState(RecyclerView r10) {
            r10.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public void resetInternal() {
            if (RecyclerView.sDebugAssertionsEnabled == true) goto L5;
        L9:
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.clearNestedRecyclerViewIfNotNested(this);
            return;
        L5:
            if (isTmpDetached() == false) goto L9;
            throw new IllegalStateException("Attempting to reset temp-detached ViewHolder: " + this + ". ViewHolders should be fully detached before resetting.");
        }

        public void saveOldPosition() {
            if (this.mOldPosition != (-1)) goto L6;
            this.mOldPosition = this.mPosition;
            return;
        }

        public void setFlags(int r10, int r11) {
            int r12 = r10 & r11;
            this.mFlags = r12 | (this.mFlags & (~r11));
        }

        public final void setIsRecyclable(boolean r10) {
            int r11 = this.mIsRecyclableCount;
            if (r10 == false) goto L5;
            int r12 = r11 - 1;
        L6:
            this.mIsRecyclableCount = r12;
            if (r12 >= 0) goto L13;
            this.mIsRecyclableCount = 0;
            if (RecyclerView.sDebugAssertionsEnabled == true) goto L12;
            Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        L20:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L23;
            Log.d(RecyclerView.TAG, "setIsRecyclable val:" + r10 + ":" + this);
            return;
        L23:
            return;
        L12:
            throw new RuntimeException("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        L13:
            if (r10 == true) goto L16;
            if (r12 != 1) goto L16;
            this.mFlags |= 16;
        L16:
            if (r10 == false) goto L20;
            if (r12 != 0) goto L20;
            this.mFlags &= -17;
            goto L20
        L5:
            r12 = r11 + 1;
            goto L6
        }

        public void setScrapContainer(Recycler r10, boolean r11) {
            this.mScrapContainer = r10;
            this.mInChangeScrap = r11;
        }

        public boolean shouldBeKeptAsChild() {
            if ((this.mFlags & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean shouldIgnore() {
            if ((this.mFlags & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            if (getClass().isAnonymousClass() == false) goto L5;
            String r10 = "ViewHolder";
        L6:
            StringBuilder r11 = new StringBuilder(r10 + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap() == false) goto L14;
            r11.append(" scrap ");
            if (this.mInChangeScrap == false) goto L11;
            String r12 = "[changeScrap]";
        L12:
            r11.append(r12);
            goto L14
        L11:
            r12 = "[attachedScrap]";
        L14:
            if (isInvalid() == false) goto L17;
            r11.append(" invalid");
        L17:
            if (isBound() == true) goto L20;
            r11.append(" unbound");
        L20:
            if (needsUpdate() == false) goto L23;
            r11.append(" update");
        L23:
            if (isRemoved() == false) goto L26;
            r11.append(" removed");
        L26:
            if (shouldIgnore() == false) goto L29;
            r11.append(" ignored");
        L29:
            if (isTmpDetached() == false) goto L32;
            r11.append(" tmpDetached");
        L32:
            if (isRecyclable() == true) goto L35;
            r11.append(" not recyclable(" + this.mIsRecyclableCount + ")");
        L35:
            if (isAdapterPositionUnknown() == false) goto L38;
            r11.append(" undefined adapter position");
        L38:
            if (this.itemView.getParent() != null) goto L40;
            r11.append(" no parent");
        L40:
            r11.append("}");
            return r11.toString();
        L5:
            r10 = getClass().getSimpleName();
            goto L6
        }

        public void unScrap() {
            this.mScrapContainer.O(this);
        }

        public boolean wasReturnedFromScrap() {
            if ((this.mFlags & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f4248a;

        public a(RecyclerView r10) {
            this.f4248a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView r10 = this.f4248a;
            if (r10.mFirstLayoutComplete == true) goto L5;
            return;
        L5:
            if (r10.isLayoutRequested() == true) goto L18;
            RecyclerView r11 = this.f4248a;
            if (r11.mIsAttached == true) goto L12;
            r11.requestLayout();
            return;
        L12:
            if (r11.mLayoutSuppressed == false) goto L15;
            r11.mLayoutWasDefered = true;
            return;
        L15:
            r11.consumePendingUpdateOperations();
            return;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f4249a;

        public b(RecyclerView r10) {
            this.f4249a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ItemAnimator r10 = this.f4249a.mItemAnimator;
            if (r10 == null) goto L5;
            r10.v();
        L5:
            this.f4249a.mPostedAnimatorRunner = false;
        }
    }

    public class c implements Interpolator {
        public c() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float r10) {
            float r11 = r10 - 1.0f;
            return ((((r11 * r11) * r11) * r11) * r11) + 1.0f;
        }
    }

    public class d implements ViewInfoStore.ProcessCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f4250a;

        public d(RecyclerView r10) {
            this.f4250a = r10;
        }

        @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
        public void processAppeared(ViewHolder r10, ItemAnimator.ItemHolderInfo r11, ItemAnimator.ItemHolderInfo r12) {
            this.f4250a.animateAppearance(r10, r11, r12);
        }

        @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
        public void processDisappeared(ViewHolder r10, ItemAnimator.ItemHolderInfo r11, ItemAnimator.ItemHolderInfo r12) {
            this.f4250a.mRecycler.O(r10);
            this.f4250a.animateDisappearance(r10, r11, r12);
        }

        @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
        public void processPersistent(ViewHolder r10, ItemAnimator.ItemHolderInfo r11, ItemAnimator.ItemHolderInfo r12) {
            r10.setIsRecyclable(false);
            RecyclerView r13 = this.f4250a;
            if (r13.mDataSetHasChangedAfterLayout == false) goto L8;
            if (r13.mItemAnimator.b(r10, r10, r11, r12) == false) goto L11;
            this.f4250a.postAnimationRunner();
            return;
        L11:
            return;
        L8:
            if (r13.mItemAnimator.d(r10, r11, r12) == false) goto L13;
            this.f4250a.postAnimationRunner();
            return;
        }

        @Override // androidx.recyclerview.widget.ViewInfoStore.ProcessCallback
        public void unused(ViewHolder r10) {
            RecyclerView r11 = this.f4250a;
            r11.mLayout.removeAndRecycleView(r10.itemView, r11.mRecycler);
        }
    }

    public class e implements ChildHelper.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f4251a;

        public e(RecyclerView r10) {
            this.f4251a = r10;
        }

        @Override // androidx.recyclerview.widget.ChildHelper.Callback
        public void addView(View r10, int r11) {
            this.f4251a.addView(r10, r11);
            this.f4251a.dispatchChildAttached(r10);
        }

        @Override // androidx.recyclerview.widget.ChildHelper.Callback
        public void attachViewToParent(View r10, int r11, ViewGroup.LayoutParams r12) {
            ViewHolder r13 = RecyclerView.getChildViewHolderInt(r10);
            if (r13 == null) goto L16;
            if (r13.isTmpDetached() == true) goto L12;
            if (r13.shouldIgnore() == true) goto L12;
            throw new IllegalArgumentException("Called attach on a child which is not detached: " + r13 + this.f4251a.exceptionLabel());
        L12:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L14;
            Log.d(RecyclerView.TAG, "reAttach " + r13);
        L14:
            r13.clearTmpDetachFlag();
        L17:
            RecyclerView.access$000(this.f4251a, r10, r11, r12);
            return;
        L16:
            if (RecyclerView.sDebugAssertionsEnabled == false) goto L17;
            throw new IllegalArgumentException("No ViewHolder found for child: " + r10 + ", index: " + r11 + this.f4251a.exceptionLabel());
        }

        @Override // androidx.recyclerview.widget.ChildHelper.Callback
        public void detachViewFromParent(int r10) {
            View r11 = getChildAt(r10);
            if (r11 == null) goto L18;
            ViewHolder r12 = RecyclerView.getChildViewHolderInt(r11);
            if (r12 != null) goto L7;
        L19:
            RecyclerView.access$100(this.f4251a, r10);
            return;
        L7:
            if (r12.isTmpDetached() == false) goto L14;
            if (r12.shouldIgnore() == true) goto L14;
            throw new IllegalArgumentException("called detach on an already detached child " + r12 + this.f4251a.exceptionLabel());
        L14:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L16;
            Log.d(RecyclerView.TAG, "tmpDetach " + r12);
        L16:
            r12.addFlags(256);
            goto L19
        L18:
            if (RecyclerView.sDebugAssertionsEnabled == false) goto L19;
            throw new IllegalArgumentException("No view at offset " + r10 + this.f4251a.exceptionLabel());
        }

        @Override // androidx.recyclerview.widget.ChildHelper.Callback
        public View getChildAt(int r10) {
            return this.f4251a.getChildAt(r10);
        }

        @Override // androidx.recyclerview.widget.ChildHelper.Callback
        public int getChildCount() {
            return this.f4251a.getChildCount();
        }

        @Override // androidx.recyclerview.widget.ChildHelper.Callback
        public ViewHolder getChildViewHolder(View r10) {
            return RecyclerView.getChildViewHolderInt(r10);
        }

        @Override // androidx.recyclerview.widget.ChildHelper.Callback
        public int indexOfChild(View r10) {
            return this.f4251a.indexOfChild(r10);
        }

        @Override // androidx.recyclerview.widget.ChildHelper.Callback
        public void onEnteredHiddenState(View r10) {
            ViewHolder r11 = RecyclerView.getChildViewHolderInt(r10);
            if (r11 == null) goto L6;
            r11.onEnteredHiddenState(this.f4251a);
            return;
        }

        @Override // androidx.recyclerview.widget.ChildHelper.Callback
        public void onLeftHiddenState(View r10) {
            ViewHolder r11 = RecyclerView.getChildViewHolderInt(r10);
            if (r11 == null) goto L6;
            r11.onLeftHiddenState(this.f4251a);
            return;
        }

        @Override // androidx.recyclerview.widget.ChildHelper.Callback
        public void removeAllViews() {
            int r10 = getChildCount();
            int r11 = 0;
        L3:
            if (r11 >= r10) goto L5;
            View r12 = getChildAt(r11);
            this.f4251a.dispatchChildDetached(r12);
            r12.clearAnimation();
            r11 = r11 + 1;
            goto L3
        L5:
            this.f4251a.removeAllViews();
        }

        @Override // androidx.recyclerview.widget.ChildHelper.Callback
        public void removeViewAt(int r10) {
            View r11 = this.f4251a.getChildAt(r10);
            if (r11 == null) goto L5;
            this.f4251a.dispatchChildDetached(r11);
            r11.clearAnimation();
        L5:
            this.f4251a.removeViewAt(r10);
        }
    }

    public class f implements AdapterHelper.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f4252a;

        public f(RecyclerView r10) {
            this.f4252a = r10;
        }

        public void a(AdapterHelper.a r10) {
            int r11 = r10.f4038a;
            if (r11 != 1) goto L5;
            RecyclerView r12 = this.f4252a;
            r12.mLayout.onItemsAdded(r12, r10.f4039b, r10.f4041d);
            return;
        L5:
            if (r11 != 2) goto L7;
            RecyclerView r13 = this.f4252a;
            r13.mLayout.onItemsRemoved(r13, r10.f4039b, r10.f4041d);
            return;
        L7:
            if (r11 != 4) goto L9;
            RecyclerView r14 = this.f4252a;
            r14.mLayout.onItemsUpdated(r14, r10.f4039b, r10.f4041d, r10.f4040c);
            return;
        L9:
            if (r11 != 8) goto L19;
            RecyclerView r15 = this.f4252a;
            r15.mLayout.onItemsMoved(r15, r10.f4039b, r10.f4041d, 1);
            return;
        }

        @Override // androidx.recyclerview.widget.AdapterHelper.Callback
        public ViewHolder findViewHolder(int r10) {
            ViewHolder r11 = this.f4252a.findViewHolderForPosition(r10, true);
            if (r11 != null) goto L6;
            return null;
        L6:
            if (this.f4252a.mChildHelper.isHidden(r11.itemView) == true) goto L8;
            return r11;
        L8:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L10;
            Log.d(RecyclerView.TAG, "assuming view holder cannot be find because it is hidden");
        L10:
            return null;
        }

        @Override // androidx.recyclerview.widget.AdapterHelper.Callback
        public void markViewHoldersUpdated(int r10, int r11, Object r12) {
            this.f4252a.viewRangeUpdate(r10, r11, r12);
            this.f4252a.mItemsChanged = true;
        }

        @Override // androidx.recyclerview.widget.AdapterHelper.Callback
        public void offsetPositionsForAdd(int r10, int r11) {
            this.f4252a.offsetPositionRecordsForInsert(r10, r11);
            this.f4252a.mItemsAddedOrRemoved = true;
        }

        @Override // androidx.recyclerview.widget.AdapterHelper.Callback
        public void offsetPositionsForMove(int r10, int r11) {
            this.f4252a.offsetPositionRecordsForMove(r10, r11);
            this.f4252a.mItemsAddedOrRemoved = true;
        }

        @Override // androidx.recyclerview.widget.AdapterHelper.Callback
        public void offsetPositionsForRemovingInvisible(int r10, int r11) {
            this.f4252a.offsetPositionRecordsForRemove(r10, r11, true);
            RecyclerView r12 = this.f4252a;
            r12.mItemsAddedOrRemoved = true;
            r12.mState.f4227d += r11;
        }

        @Override // androidx.recyclerview.widget.AdapterHelper.Callback
        public void offsetPositionsForRemovingLaidOutOrNewView(int r10, int r11) {
            this.f4252a.offsetPositionRecordsForRemove(r10, r11, false);
            this.f4252a.mItemsAddedOrRemoved = true;
        }

        @Override // androidx.recyclerview.widget.AdapterHelper.Callback
        public void onDispatchFirstPass(AdapterHelper.a r10) {
            a(r10);
        }

        @Override // androidx.recyclerview.widget.AdapterHelper.Callback
        public void onDispatchSecondPass(AdapterHelper.a r10) {
            a(r10);
        }
    }

    public static /* synthetic */ class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4253a = null;

        static {
            int[] r10 = new int[Adapter.StateRestorationPolicy.values().length];
            f4253a = r10;
            r10[Adapter.StateRestorationPolicy.PREVENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            f4253a[Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public class h implements ItemAnimator.ItemAnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerView f4254a;

        public h(RecyclerView r10) {
            this.f4254a = r10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemAnimatorListener
        public void onAnimationFinished(ViewHolder r10) {
            r10.setIsRecyclable(true);
            if (r10.mShadowedHolder != null) goto L5;
        L7:
            r10.mShadowingHolder = null;
            if (r10.shouldBeKeptAsChild() == false) goto L10;
            return;
        L10:
            if (this.f4254a.removeAnimatingView(r10.itemView) == false) goto L12;
            return;
        L12:
            if (r10.isTmpDetached() == false) goto L17;
            this.f4254a.removeDetachedView(r10.itemView, false);
            return;
        L17:
            return;
        L5:
            if (r10.mShadowingHolder != null) goto L7;
            r10.mShadowedHolder = null;
            goto L7
        }
    }

    static {
        NESTED_SCROLLING_ATTRS = new int[]{R.attr.nestedScrollingEnabled};
        DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
        FORCE_INVALIDATE_DISPLAY_LIST = false;
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = true;
        POST_UPDATES_ON_ANIMATION = true;
        ALLOW_THREAD_GAP_WORK = true;
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
        IGNORE_DETACHED_FOCUSED_CHILD = false;
        Class r10 = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, r10, r10};
        sQuinticInterpolator = new c();
    }

    public RecyclerView(@NonNull Context r10) {
        this(r10, null);
    }

    private int C(int r10, float r11) {
        EdgeEffectAdapter r12 = this.mVerticalEdgeEffect;
        if (r12 != null) goto L5;
    L8:
        return 0;
    L5:
        if (r12.c() == 0.0f) goto L8;
        int r13 = (int) this.mVerticalEdgeEffect.f(r10, true, false);
        invalidate();
        return r13;
    }

    private boolean J(MotionEvent r10) {
        EdgeEffectAdapter r11 = this.mHorizontalEdgeEffect;
        if (r11 != null) goto L5;
    L7:
        boolean r12 = false;
    L8:
        EdgeEffectAdapter r13 = this.mVerticalEdgeEffect;
        if (r13 == null) goto L14;
        if (r13.c() == 0.0f) goto L14;
        this.mVerticalEdgeEffect.f(0.0f, false, false);
        return true;
    L14:
        return r12;
    L5:
        if (r11.c() == 0.0f) goto L7;
        r12 = true;
        goto L8
    }

    public static /* synthetic */ void access$000(RecyclerView r10, View r11, int r12, ViewGroup.LayoutParams r13) {
        r10.attachViewToParent(r11, r12, r13);
    }

    public static /* synthetic */ void access$100(RecyclerView r10, int r11) {
        r10.detachViewFromParent(r11);
    }

    public static /* synthetic */ boolean access$200(RecyclerView r10) {
        return r10.awakenScrollBars();
    }

    public static /* synthetic */ void access$300(RecyclerView r10, View r11, int r12, ViewGroup.LayoutParams r13) {
        r10.attachViewToParent(r11, r12, r13);
    }

    public static /* synthetic */ void access$400(RecyclerView r10, View r11) {
        r10.detachViewFromParent(r11);
    }

    public static /* synthetic */ void access$500(RecyclerView r10, int r11, int r12) {
        r10.setMeasuredDimension(r11, r12);
    }

    public static void clearNestedRecyclerViewIfNotNested(@NonNull ViewHolder r10) {
        WeakReference<RecyclerView> r11 = r10.mNestedRecyclerView;
        if (r11 == null) goto L23;
        RecyclerView r12 = r11.get();
    L6:
        if (r12 == null) goto L14;
        if (r12 == r10.itemView) goto L9;
        Object r13 = r12.getParent();
        if ((r13 instanceof View) == true) goto L12;
        r12 = null;
        goto L6
    L12:
        r12 = (View) r13;
        goto L6
    L9:
        return;
    L14:
        r10.mNestedRecyclerView = null;
        return;
    }

    @Nullable
    public static RecyclerView findNestedRecyclerView(@NonNull View r10) {
        if ((r10 instanceof ViewGroup) == true) goto L6;
        return null;
    L6:
        if ((r10 instanceof RecyclerView) == true) goto L8;
        ViewGroup r11 = (ViewGroup) r10;
        int r12 = r11.getChildCount();
        int r13 = 0;
    L10:
        if (r13 >= r12) goto L15;
        RecyclerView r14 = findNestedRecyclerView(r11.getChildAt(r13));
        if (r14 != null) goto L13;
        r13 = r13 + 1;
        goto L10
    L13:
        return r14;
    L15:
        return null;
    L8:
        return (RecyclerView) r10;
    }

    public static ViewHolder getChildViewHolderInt(View r10) {
        if (r10 != null) goto L6;
        return null;
    L6:
        return ((LayoutParams) r10.getLayoutParams()).mViewHolder;
    }

    public static void getDecoratedBoundsWithMarginsInt(View r10, Rect r11) {
        LayoutParams r12 = (LayoutParams) r10.getLayoutParams();
        Rect r13 = r12.mDecorInsets;
        r11.set((r10.getLeft() - r13.left) - ((ViewGroup.MarginLayoutParams) r12).leftMargin, (r10.getTop() - r13.top) - ((ViewGroup.MarginLayoutParams) r12).topMargin, (r10.getRight() + r13.right) + ((ViewGroup.MarginLayoutParams) r12).rightMargin, (r10.getBottom() + r13.bottom) + ((ViewGroup.MarginLayoutParams) r12).bottomMargin);
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper != null) goto L6;
        this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
    L6:
        return this.mScrollingChildHelper;
    }

    private void onPointerUp(MotionEvent r10) {
        int r11 = r10.getActionIndex();
        if (r10.getPointerId(r11) != this.mScrollPointerId) goto L9;
        if (r11 != 0) goto L6;
        int r12 = 1;
    L7:
        this.mScrollPointerId = r10.getPointerId(r12);
        int r13 = (int) (r10.getX(r12) + 0.5f);
        this.mLastTouchX = r13;
        this.mInitialTouchX = r13;
        int r14 = (int) (r10.getY(r12) + 0.5f);
        this.mLastTouchY = r14;
        this.mInitialTouchY = r14;
        return;
    L6:
        r12 = 0;
        goto L7
    }

    public static void setDebugAssertionsEnabled(boolean r10) {
        sDebugAssertionsEnabled = r10;
    }

    public static void setVerboseLoggingEnabled(boolean r10) {
        sVerboseLoggingEnabled = r10;
    }

    public final void A() {
        EdgeEffectAdapter r10 = this.mHorizontalEdgeEffect;
        if (r10 == null) goto L5;
        r10.g();
        boolean r11 = this.mHorizontalEdgeEffect.d();
    L6:
        EdgeEffectAdapter r12 = this.mVerticalEdgeEffect;
        if (r12 == null) goto L9;
        r12.g();
        r11 = r11 | this.mVerticalEdgeEffect.d();
    L9:
        if (r11 == false) goto L12;
        ViewCompat.g0(this);
        return;
    L12:
        return;
    L5:
        r11 = false;
        goto L6
    }

    public final int B(int r10, float r11) {
        EdgeEffectAdapter r12 = this.mHorizontalEdgeEffect;
        if (r12 != null) goto L5;
    L8:
        return 0;
    L5:
        if (r12.c() == 0.0f) goto L8;
        int r13 = (int) this.mHorizontalEdgeEffect.f(r10, true, false);
        invalidate();
        return r13;
    }

    public final void D(View r12, View r13) {
        if (r13 == null) goto L4;
        View r10 = r13;
    L5:
        this.mTempRect.set(0, 0, r10.getWidth(), r10.getHeight());
        ViewGroup.LayoutParams r11 = r10.getLayoutParams();
        if ((r11 instanceof LayoutParams) == false) goto L10;
        LayoutParams r14 = (LayoutParams) r11;
        if (r14.mInsetsDirty == true) goto L10;
        Rect r15 = r14.mDecorInsets;
        Rect r16 = this.mTempRect;
        r16.left -= r15.left;
        r16.right += r15.right;
        r16.top -= r15.top;
        r16.bottom += r15.bottom;
    L10:
        if (r13 == null) goto L12;
        offsetDescendantRectToMyCoords(r13, this.mTempRect);
        offsetRectIntoDescendantCoords(r12, this.mTempRect);
    L12:
        LayoutManager r17 = this.mLayout;
        Rect r18 = this.mTempRect;
        boolean r19 = !this.mFirstLayoutComplete;
        if (r13 != null) goto L15;
        boolean r110 = true;
    L16:
        r17.requestChildRectangleOnScreen(this, r12, r18, r19, r110);
        return;
    L15:
        r110 = false;
        goto L16
    L4:
        r10 = r12;
        goto L5
    }

    public final void E() {
        State r10 = this.mState;
        r10.f4237n = -1;
        r10.f4236m = -1;
        r10.f4238o = -1;
    }

    public final void F() {
        VelocityTracker r10 = this.mVelocityTracker;
        if (r10 == null) goto L5;
        r10.clear();
    L5:
        stopNestedScroll(0);
        A();
    }

    public final void G() {
        ViewHolder r10 = null;
        if (this.mPreserveFocusAfterLayout == true) goto L5;
    L9:
        View r11 = null;
    L10:
        if (r11 == null) goto L13;
        r10 = findContainingViewHolder(r11);
    L13:
        if (r10 != null) goto L15;
        E();
        return;
    L15:
        State r12 = this.mState;
        if (this.mAdapter.hasStableIds() == false) goto L18;
        long r13 = r10.getItemId();
    L19:
        r12.f4237n = r13;
        State r14 = this.mState;
        if (this.mDataSetHasChangedAfterLayout == false) goto L23;
        int r15 = -1;
    L26:
        r14.f4236m = r15;
        this.mState.f4238o = o(r10.itemView);
        return;
    L23:
        if (r10.isRemoved() == false) goto L25;
        r15 = r10.mOldPosition;
        goto L26
    L25:
        r15 = r10.getAbsoluteAdapterPosition();
        goto L26
    L18:
        r13 = -1;
        goto L19
    L5:
        if (hasFocus() == false) goto L9;
        if (this.mAdapter == null) goto L9;
        r11 = getFocusedChild();
        goto L10
    }

    public final void H(Adapter r10, boolean r11, boolean r12) {
        Adapter r13 = this.mAdapter;
        if (r13 == null) goto L5;
        r13.unregisterAdapterDataObserver(this.mObserver);
        this.mAdapter.onDetachedFromRecyclerView(this);
    L5:
        if (r11 == false) goto L7;
        if (r12 == true) goto L7;
    L8:
        this.mAdapterHelper.w();
        Adapter r14 = this.mAdapter;
        this.mAdapter = r10;
        if (r10 == null) goto L11;
        r10.registerAdapterDataObserver(this.mObserver);
        r10.onAttachedToRecyclerView(this);
    L11:
        LayoutManager r15 = this.mLayout;
        if (r15 == null) goto L14;
        r15.onAdapterChanged(r14, this.mAdapter);
    L14:
        this.mRecycler.y(r14, this.mAdapter, r11);
        this.mState.f4230g = true;
        return;
    L7:
        removeAndRecycleViews();
        goto L8
    }

    public final boolean I(EdgeEffectAdapter r10, int r11) {
        return true;
    }

    public final void K() {
        this.mViewFlinger.f();
        LayoutManager r10 = this.mLayout;
        if (r10 == null) goto L6;
        r10.stopSmoothScroller();
        return;
    }

    public final void a(ViewHolder r10) {
        View r11 = r10.itemView;
        if (r11.getParent() != this) goto L5;
        boolean r12 = true;
    L6:
        this.mRecycler.O(getChildViewHolder(r11));
        if (r10.isTmpDetached() == false) goto L9;
        this.mChildHelper.attachViewToParent(r11, -1, r11.getLayoutParams(), true);
        return;
    L9:
        if (r12 == true) goto L11;
        this.mChildHelper.addView(r11, true);
        return;
    L11:
        this.mChildHelper.hide(r11);
        return;
    L5:
        r12 = false;
        goto L6
    }

    public void absorbGlows(int r10, int r11) {
        if (r10 == 0) goto L8;
        ensureHorizontalGlow();
        if (this.mHorizontalEdgeEffect.d() == false) goto L6;
    L7:
        this.mHorizontalEdgeEffect.e(r10);
        goto L8
    L6:
        if (this.mEnableOverFling == true) goto L7;
    L8:
        if (r11 == 0) goto L14;
        ensureVerticalGlow();
        if (this.mVerticalEdgeEffect.d() == false) goto L12;
    L13:
        this.mVerticalEdgeEffect.e(r11);
        goto L14
    L12:
        if (this.mEnableOverFling == true) goto L13;
    L14:
        if (r10 != 0) goto L16;
        if (r11 != 0) goto L16;
        return;
    L16:
        ViewCompat.g0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> r10, int r11, int r12) {
        LayoutManager r13 = this.mLayout;
        if (r13 != null) goto L5;
    L6:
        super.addFocusables(r10, r11, r12);
        return;
    L5:
        if (r13.onAddFocusables(this, r10, r11, r12) == false) goto L6;
    }

    public void addItemDecoration(@NonNull ItemDecoration r10, int r11) {
        LayoutManager r12 = this.mLayout;
        if (r12 == null) goto L6;
        r12.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
    L6:
        if (this.mItemDecorations.isEmpty() == false) goto L8;
        setWillNotDraw(false);
    L8:
        if (r11 >= 0) goto L10;
        this.mItemDecorations.add(r10);
    L11:
        markItemDecorInsetsDirty();
        requestLayout();
        return;
    L10:
        this.mItemDecorations.add(r11, r10);
        goto L11
    }

    public void addOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener r10) {
        if (this.mOnChildAttachStateListeners != null) goto L5;
        this.mOnChildAttachStateListeners = new ArrayList();
    L5:
        this.mOnChildAttachStateListeners.add(r10);
    }

    public void addOnItemTouchListener(@NonNull OnItemTouchListener r10) {
        this.mOnItemTouchListeners.add(r10);
    }

    public void addOnScrollListener(@NonNull OnScrollListener r10) {
        if (this.mScrollListeners != null) goto L5;
        this.mScrollListeners = new ArrayList();
    L5:
        this.mScrollListeners.add(r10);
    }

    public void addRecyclerListener(@NonNull RecyclerListener r10) {
        if (r10 == null) goto L4;
        boolean r11 = true;
    L5:
        androidx.core.util.e.b(r11, "'listener' arg cannot be null.");
        this.mRecyclerListeners.add(r10);
        return;
    L4:
        r11 = false;
        goto L5
    }

    public void allowClickDuringOverScroll(boolean r10) {
        this.mRecyclerViewExt.a(r10);
    }

    public void animateAppearance(@NonNull ViewHolder r10, @Nullable ItemAnimator.ItemHolderInfo r11, @NonNull ItemAnimator.ItemHolderInfo r12) {
        r10.setIsRecyclable(false);
        if (this.mItemAnimator.a(r10, r11, r12) == false) goto L6;
        postAnimationRunner();
        return;
    }

    public void animateDisappearance(@NonNull ViewHolder r10, @NonNull ItemAnimator.ItemHolderInfo r11, @Nullable ItemAnimator.ItemHolderInfo r12) {
        a(r10);
        r10.setIsRecyclable(false);
        if (this.mItemAnimator.c(r10, r11, r12) == false) goto L6;
        postAnimationRunner();
        return;
    }

    public void assertInLayoutOrScroll(String r10) {
        if (isComputingLayout() == true) goto L9;
        if (r10 != null) goto L8;
        throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
    L8:
        throw new IllegalStateException(r10 + exceptionLabel());
    }

    public void assertNotInLayoutOrScroll(String r10) {
        if (isComputingLayout() == false) goto L10;
        if (r10 != null) goto L8;
        throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
    L8:
        throw new IllegalStateException(r10);
    L10:
        if (this.mDispatchScrollCounter <= 0) goto L13;
        Log.w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
        return;
    }

    public void avoidStateChangeInAnim() {
        this.mAvoidStateChangeInAnim = true;
    }

    public final void b(ViewHolder r10, ViewHolder r11, ItemAnimator.ItemHolderInfo r12, ItemAnimator.ItemHolderInfo r13, boolean r14, boolean r15) {
        r10.setIsRecyclable(false);
        if (r14 == false) goto L5;
        a(r10);
    L5:
        if (r10 == r11) goto L10;
        if (r15 == false) goto L8;
        a(r11);
    L8:
        r10.mShadowedHolder = r11;
        a(r10);
        this.mRecycler.O(r10);
        r11.setIsRecyclable(false);
        r11.mShadowingHolder = r10;
    L10:
        if (this.mItemAnimator.b(r10, r11, r12, r13) == false) goto L13;
        postAnimationRunner();
        return;
    }

    public final void c() {
        F();
        setScrollState(0);
    }

    public boolean canReuseUpdatedViewHolder(ViewHolder r10) {
        ItemAnimator r11 = this.mItemAnimator;
        if (r11 != null) goto L5;
    L8:
        return true;
    L5:
        if (r11.g(r10, r10.getUnmodifiedPayloads()) == true) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r10) {
        if ((r10 instanceof LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mLayout.checkLayoutParams((LayoutParams) r10) == false) goto L7;
        return true;
    }

    public void clearOldPositions() {
        int r10 = this.mChildHelper.getUnfilteredChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L8;
        ViewHolder r12 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r11));
        if (r12.shouldIgnore() == true) goto L7;
        r12.clearOldPosition();
    L7:
        r11 = r11 + 1;
        goto L3
    L8:
        this.mRecycler.d();
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<OnChildAttachStateChangeListener> r10 = this.mOnChildAttachStateListeners;
        if (r10 == null) goto L6;
        r10.clear();
        return;
    }

    public void clearOnScrollListeners() {
        List<OnScrollListener> r10 = this.mScrollListeners;
        if (r10 == null) goto L6;
        r10.clear();
        return;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        LayoutManager r10 = this.mLayout;
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.canScrollHorizontally() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeHorizontalScrollExtent(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        LayoutManager r10 = this.mLayout;
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.canScrollHorizontally() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeHorizontalScrollOffset(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        LayoutManager r10 = this.mLayout;
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.canScrollHorizontally() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeHorizontalScrollRange(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        LayoutManager r10 = this.mLayout;
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.canScrollVertically() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeVerticalScrollExtent(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        LayoutManager r10 = this.mLayout;
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.canScrollVertically() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeVerticalScrollOffset(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        LayoutManager r10 = this.mLayout;
        if (r10 != null) goto L6;
        return 0;
    L6:
        if (r10.canScrollVertically() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeVerticalScrollRange(this.mState);
    }

    public int consumeFlingInHorizontalStretch(int r10) {
        return d(r10, this.mHorizontalEdgeEffect);
    }

    public int consumeFlingInVerticalStretch(int r10) {
        return d(r10, this.mVerticalEdgeEffect);
    }

    public void consumePendingUpdateOperations() {
        if (this.mFirstLayoutComplete == true) goto L5;
    L25:
        androidx.core.os.g.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
        dispatchLayout();
        androidx.core.os.g.b();
        return;
    L5:
        if (this.mDataSetHasChangedAfterLayout == true) goto L25;
        if (this.mAdapterHelper.n() == true) goto L11;
        return;
    L11:
        if (this.mAdapterHelper.m(4) == false) goto L22;
        if (this.mAdapterHelper.m(11) == true) goto L22;
        androidx.core.os.g.a(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mAdapterHelper.u();
        if (this.mLayoutWasDefered == false) goto L17;
    L20:
        stopInterceptRequestLayout(true);
        onExitLayoutOrScroll();
        androidx.core.os.g.b();
        return;
    L17:
        if (r() == false) goto L19;
        dispatchLayout();
        goto L20
    L19:
        this.mAdapterHelper.g();
    L22:
        if (this.mAdapterHelper.n() == false) goto L28;
        androidx.core.os.g.a(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
        dispatchLayout();
        androidx.core.os.g.b();
        return;
    }

    public final int d(int r10, EdgeEffectAdapter r11) {
        if (r10 == 0) goto L11;
        if (r11 != null) goto L5;
        return r10;
    L5:
        if (r11.c() == 0.0f) goto L13;
        int r12 = (int) r11.f(r10, true, this.mAvoidStateChangeInAnim);
        if (r10 <= 0) goto L10;
        return r10 - r12;
    L10:
        return r10 + r12;
    L13:
        return r10;
    L11:
        return r10;
    }

    public void defaultOnMeasure(int r10, int r11) {
        setMeasuredDimension(LayoutManager.chooseSize(r10, getPaddingLeft() + getPaddingRight(), ViewCompat.C(this)), LayoutManager.chooseSize(r11, getPaddingTop() + getPaddingBottom(), ViewCompat.B(this)));
    }

    public void dispatchChildAttached(View r10) {
        ViewHolder r11 = getChildViewHolderInt(r10);
        onChildAttachedToWindow(r10);
        Adapter r12 = this.mAdapter;
        if (r12 == null) goto L6;
        if (r11 == null) goto L6;
        r12.onViewAttachedToWindow(r11);
    L6:
        List<OnChildAttachStateChangeListener> r13 = this.mOnChildAttachStateListeners;
        if (r13 == null) goto L11;
        int r14 = r13.size() - 1;
    L9:
        if (r14 < 0) goto L13;
        this.mOnChildAttachStateListeners.get(r14).onChildViewAttachedToWindow(r10);
        r14 = r14 - 1;
        goto L9
    L13:
        return;
    }

    public void dispatchChildDetached(View r10) {
        ViewHolder r11 = getChildViewHolderInt(r10);
        onChildDetachedFromWindow(r10);
        Adapter r12 = this.mAdapter;
        if (r12 == null) goto L6;
        if (r11 == null) goto L6;
        r12.onViewDetachedFromWindow(r11);
    L6:
        List<OnChildAttachStateChangeListener> r13 = this.mOnChildAttachStateListeners;
        if (r13 == null) goto L11;
        int r14 = r13.size() - 1;
    L9:
        if (r14 < 0) goto L13;
        this.mOnChildAttachStateListeners.get(r14).onChildViewDetachedFromWindow(r10);
        r14 = r14 - 1;
        goto L9
    L13:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r10) {
        r10.save();
        EdgeEffectAdapter r11 = this.mHorizontalEdgeEffect;
        boolean r12 = true;
        if (r11 != null) goto L5;
    L7:
        boolean r13 = false;
    L8:
        EdgeEffectAdapter r14 = this.mVerticalEdgeEffect;
        if (r14 != null) goto L11;
    L13:
        r12 = r13;
    L14:
        super.dispatchDraw(r10);
        r10.restore();
        if (r12 == false) goto L18;
        ViewCompat.g0(this);
        return;
    L18:
        return;
    L11:
        if (r14.d() == true) goto L13;
        this.mVerticalEdgeEffect.a();
        r10.translate(0.0f, this.mVerticalEdgeEffect.c());
        goto L14
    L5:
        if (r11.d() == true) goto L7;
        this.mHorizontalEdgeEffect.a();
        r10.translate(this.mHorizontalEdgeEffect.c(), 0.0f);
        r13 = true;
        goto L8
    }

    public void dispatchLayout() {
        if (this.mAdapter != null) goto L7;
        Log.w(TAG, "No adapter attached; skipping layout");
        return;
    L7:
        if (this.mLayout != null) goto L10;
        Log.e(TAG, "No layout manager attached; skipping layout");
        return;
    L10:
        this.mState.f4233j = false;
        if (this.mLastAutoMeasureSkippedDueToExact == true) goto L13;
    L17:
        boolean r10 = false;
    L18:
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mLastAutoMeasureSkippedDueToExact = false;
        if (this.mState.f4228e != 1) goto L22;
        h();
        this.mLayout.setExactMeasureSpecsFrom(this);
        i();
    L31:
        j();
        return;
    L22:
        if (this.mAdapterHelper.o() == true) goto L30;
        if (r10 == true) goto L30;
        if (this.mLayout.getWidth() != getWidth()) goto L30;
        if (this.mLayout.getHeight() != getHeight()) goto L30;
        this.mLayout.setExactMeasureSpecsFrom(this);
    L30:
        this.mLayout.setExactMeasureSpecsFrom(this);
        i();
        goto L31
    L13:
        if (this.mLastAutoMeasureNonExactMeasuredWidth == getWidth()) goto L15;
    L16:
        r10 = true;
        goto L18
    L15:
        if (this.mLastAutoMeasureNonExactMeasuredHeight == getHeight()) goto L17;
        goto L16
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float r10, float r11, boolean r12) {
        return getScrollingChildHelper().a(r10, r11, r12);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float r10, float r11) {
        return getScrollingChildHelper().b(r10, r11);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int r10, int r11, int[] r12, int[] r13) {
        return getScrollingChildHelper().c(r10, r11, r12, r13);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14) {
        return getScrollingChildHelper().f(r10, r11, r12, r13, r14);
    }

    public void dispatchOnScrollStateChanged(int r10) {
        LayoutManager r11 = this.mLayout;
        if (r11 == null) goto L5;
        r11.onScrollStateChanged(r10);
    L5:
        onScrollStateChanged(r10);
        OnScrollListener r12 = this.mScrollListener;
        if (r12 == null) goto L8;
        r12.onScrollStateChanged(this, r10);
    L8:
        List<OnScrollListener> r13 = this.mScrollListeners;
        if (r13 == null) goto L13;
        int r14 = r13.size() - 1;
    L11:
        if (r14 < 0) goto L15;
        this.mScrollListeners.get(r14).onScrollStateChanged(this, r10);
        r14 = r14 - 1;
        goto L11
    L15:
        return;
    }

    public void dispatchOnScrolled(int r10, int r11) {
        this.mDispatchScrollCounter++;
        int r12 = getScrollX();
        int r13 = getScrollY();
        onScrollChanged(r12, r13, r12 - r10, r13 - r11);
        onScrolled(r10, r11);
        OnScrollListener r14 = this.mScrollListener;
        if (r14 == null) goto L5;
        r14.onScrolled(this, r10, r11);
    L5:
        List<OnScrollListener> r15 = this.mScrollListeners;
        if (r15 == null) goto L10;
        int r16 = r15.size() - 1;
    L8:
        if (r16 < 0) goto L10;
        this.mScrollListeners.get(r16).onScrolled(this, r10, r11);
        r16 = r16 - 1;
    L10:
        this.mDispatchScrollCounter--;
    }

    public void dispatchPendingImportantForAccessibilityChanges() {
        int r10 = this.mPendingAccessibilityImportanceChange.size() - 1;
    L3:
        if (r10 < 0) goto L13;
        ViewHolder r11 = this.mPendingAccessibilityImportanceChange.get(r10);
        if (r11.itemView.getParent() != this) goto L12;
        if (r11.shouldIgnore() == true) goto L12;
        int r12 = r11.mPendingAccessibilityState;
        if (r12 == (-1)) goto L12;
        ViewCompat.A0(r11.itemView, r12);
        r11.mPendingAccessibilityState = -1;
    L12:
        r10 = r10 - 1;
        goto L3
    L13:
        this.mPendingAccessibilityImportanceChange.clear();
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r10) {
        onPopulateAccessibilityEvent(r10);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> r10) {
        dispatchThawSelfOnly(r10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> r10) {
        dispatchFreezeSelfOnly(r10);
    }

    @Override // android.view.View
    public void draw(Canvas r10) {
        super.draw(r10);
        int r11 = this.mItemDecorations.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        this.mItemDecorations.get(r12).onDrawOver(r10, this, this.mState);
        r12 = r12 + 1;
        goto L3
    L6:
        if (this.mItemAnimator != null) goto L8;
        return;
    L8:
        if (this.mItemDecorations.size() > 0) goto L10;
        return;
    L10:
        if (this.mItemAnimator.p() == false) goto L16;
        ViewCompat.g0(this);
        return;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r10, View r11, long r12) {
        return super.drawChild(r10, r11, r12);
    }

    public final void e(Context r10, String r11, AttributeSet r12, int r13, int r14) {
        if (r11 == null) goto L42;
        String r15 = r11.trim();
        if (r15.isEmpty() == true) goto L48;
        String r16 = p(r10, r15);
    L10:
        e = move-exception;
        throw new IllegalStateException(r12.getPositionDescription() + ": Class is not a LayoutManager " + r16, e);
    L18:
        e = move-exception;
        throw new IllegalStateException(r12.getPositionDescription() + ": Unable to find LayoutManager " + r16, e);
    L12:
        e = move-exception;
        throw new IllegalStateException(r12.getPositionDescription() + ": Cannot access non-public constructor " + r16, e);
    L14:
        e = move-exception;
        throw new IllegalStateException(r12.getPositionDescription() + ": Could not instantiate the LayoutManager: " + r16, e);
    L16:
        e = move-exception;
        throw new IllegalStateException(r12.getPositionDescription() + ": Could not instantiate the LayoutManager: " + r16, e);
    L8:
        if (isInEditMode() == false) goto L20;
        ClassLoader r17 = getClass().getClassLoader();     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
    L21:
        Class<? extends U> r18 = Class.forName(r16, false, r17).asSubclass(LayoutManager.class);     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
        Constructor r19 = r18.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18 NoSuchMethodException -> L25
        Object[] r20 = {r10, r12, Integer.valueOf(r13), Integer.valueOf(r14)};     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18 NoSuchMethodException -> L25
    L28:
        r19.setAccessible(true);     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
        setLayoutManager((LayoutManager) r19.newInstance(r20));     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
        return;
    L25:
        e = move-exception;
        r20 = null;
        r19 = r18.getConstructor(null);     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18 NoSuchMethodException -> L29
    L29:
        e = move-exception;
        e.initCause(e);     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
        throw new IllegalStateException(r12.getPositionDescription() + ": Error creating LayoutManager " + r16, e);     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
    L20:
        r17 = r10.getClassLoader();     // Catch: ClassCastException -> L10 IllegalAccessException -> L12 InstantiationException -> L14 InvocationTargetException -> L16 ClassNotFoundException -> L18
        goto L21
    L48:
        return;
    }

    public void ensureHorizontalGlow() {
        if (this.mHorizontalEdgeEffect == null) goto L5;
        return;
    L5:
        EdgeEffectAdapter r10 = new EdgeEffectAdapter(getContext());
        this.mHorizontalEdgeEffect = r10;
        r10.i(getWidth());
    }

    public void ensureVerticalGlow() {
        if (this.mVerticalEdgeEffect == null) goto L5;
        return;
    L5:
        EdgeEffectAdapter r10 = new EdgeEffectAdapter(getContext());
        this.mVerticalEdgeEffect = r10;
        r10.i(getHeight());
    }

    public String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    public final boolean f(int r10, int r11) {
        m(this.mMinMaxLayoutPositions);
        int[] r12 = this.mMinMaxLayoutPositions;
        if (r12[0] != r10) goto L7;
        if (r12[1] != r11) goto L7;
        return false;
    L7:
        return true;
    }

    public final void fillRemainingScrollValues(State r10) {
        if (getScrollState() != 2) goto L5;
        OverScrollerAdapter r11 = this.mViewFlinger.f4243c;
        r10.f4239p = r11.i() - r11.g();
        r10.f4240q = r11.j() - r11.h();
        return;
    L5:
        r10.f4239p = 0;
        r10.f4240q = 0;
    }

    @Nullable
    public View findChildViewUnder(float r10, float r11) {
        int r12 = this.mChildHelper.getChildCount() - 1;
    L3:
        if (r12 < 0) goto L14;
        View r13 = this.mChildHelper.getChildAt(r12);
        float r14 = r13.getTranslationX();
        float r15 = r13.getTranslationY();
        if (r10 < (r13.getLeft() + r14)) goto L13;
        if (r10 > (r13.getRight() + r14)) goto L13;
        if (r11 < (r13.getTop() + r15)) goto L13;
        if (r11 > (r13.getBottom() + r15)) goto L13;
        return r13;
    L13:
        r12 = r12 - 1;
        goto L3
    L14:
        return null;
    }

    @Nullable
    public View findContainingItemView(@NonNull View r10) {
        ViewParent r11 = r10.getParent();
    L3:
        if (r11 == null) goto L8;
        if (r11 == this) goto L8;
        if ((r11 instanceof View) == false) goto L8;
        r10 = r11;
        r11 = r10.getParent();
    L8:
        if (r11 == this) goto L15;
        return null;
    L15:
        return r10;
    }

    @Nullable
    public ViewHolder findContainingViewHolder(@NonNull View r10) {
        View r11 = findContainingItemView(r10);
        if (r11 != null) goto L6;
        return null;
    L6:
        return getChildViewHolder(r11);
    }

    @Nullable
    public ViewHolder findViewHolderForAdapterPosition(int r10) {
        ViewHolder r11 = null;
        if (this.mDataSetHasChangedAfterLayout == false) goto L5;
        return null;
    L5:
        int r12 = this.mChildHelper.getUnfilteredChildCount();
        int r13 = 0;
    L6:
        if (r13 >= r12) goto L18;
        ViewHolder r14 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r13));
        if (r14 == null) goto L17;
        if (r14.isRemoved() == true) goto L17;
        if (getAdapterPositionInRecyclerView(r14) != r10) goto L17;
        if (this.mChildHelper.isHidden(r14.itemView) == false) goto L16;
        r11 = r14;
        goto L17
    L16:
        return r14;
    L17:
        r13 = r13 + 1;
        goto L6
    L18:
        return r11;
    }

    public ViewHolder findViewHolderForItemId(long r10) {
        Adapter r11 = this.mAdapter;
        ViewHolder r12 = null;
        if (r11 != null) goto L5;
    L20:
        return r12;
    L5:
        if (r11.hasStableIds() == false) goto L20;
        int r13 = this.mChildHelper.getUnfilteredChildCount();
        int r14 = 0;
    L8:
        if (r14 >= r13) goto L20;
        ViewHolder r15 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r14));
        if (r15 == null) goto L19;
        if (r15.isRemoved() == true) goto L19;
        if (r15.getItemId() != r10) goto L19;
        if (this.mChildHelper.isHidden(r15.itemView) == false) goto L18;
        r12 = r15;
        goto L19
    L18:
        return r15;
    L19:
        r14 = r14 + 1;
        goto L8
    }

    @Nullable
    public ViewHolder findViewHolderForLayoutPosition(int r10) {
        return findViewHolderForPosition(r10, false);
    }

    @Nullable
    @Deprecated
    public ViewHolder findViewHolderForPosition(int r10) {
        return findViewHolderForPosition(r10, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v5 */
    public boolean fling(int r10, int r11) {
        LayoutManager r12 = this.mLayout;
        if (r12 != null) goto L7;
        Log.e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return false;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return false;
    L9:
        int r13 = r12.canScrollHorizontally();
        boolean r14 = this.mLayout.canScrollVertically();
        if (r13 != 0) goto L12;
    L13:
        r10 = 0;
    L14:
        if (r14 == true) goto L16;
    L17:
        r11 = 0;
    L18:
        if (r10 != 0) goto L22;
        if (r11 != 0) goto L22;
        return false;
    L22:
        if (r10 == 0) goto L38;
        EdgeEffectAdapter r15 = this.mHorizontalEdgeEffect;
        if (r15 == null) goto L38;
        if (r15.c() == 0.0f) goto L38;
        if (I(this.mHorizontalEdgeEffect, r10) == false) goto L30;
        this.mHorizontalEdgeEffect.e(r10);
        int r16 = 0;
    L32:
        if (this.mEnableOverFling == false) goto L37;
        EdgeEffectAdapter r17 = this.mHorizontalEdgeEffect;
        if (r17 != null) goto L36;
    L39:
        if (r11 == 0) goto L55;
        EdgeEffectAdapter r18 = this.mVerticalEdgeEffect;
        if (r18 == null) goto L55;
        if (r18.c() == 0.0f) goto L55;
        if (I(this.mVerticalEdgeEffect, r11) == false) goto L47;
        this.mVerticalEdgeEffect.e(-r11);
        int r19 = 0;
    L49:
        if (this.mEnableOverFling == false) goto L54;
        EdgeEffectAdapter r20 = this.mVerticalEdgeEffect;
        if (r20 != null) goto L53;
    L56:
        if (r16 != 0) goto L58;
        if (r19 != 0) goto L58;
    L60:
        if (r10 != 0) goto L66;
        if (r11 != 0) goto L66;
        if (r16 != 0) goto L65;
        if (r19 != 0) goto L65;
        return false;
    L65:
        return true;
    L66:
        float r21 = r10;
        float r22 = r11;
        if (dispatchNestedPreFling(r21, r22) == true) goto L83;
        if (r13 != 0) goto L72;
        if (r14 == true) goto L72;
        boolean r23 = false;
    L73:
        dispatchNestedFling(r21, r22, r23);
        OnFlingListener r24 = this.mOnFlingListener;
        if (r24 != null) goto L76;
    L78:
        if (r23 == false) goto L83;
        if (r14 == false) goto L81;
        r13 = (r13 == true ? 1 : 0) | 2;
    L81:
        startNestedScroll(r13, 1);
        int r25 = this.mMaxFlingVelocity;
        int r26 = Math.max(-r25, Math.min(r10, r25));
        int r27 = this.mMaxFlingVelocity;
        this.mViewFlinger.b(r26, Math.max(-r27, Math.min(r11, r27)));
        return true;
    L76:
        if (r24.a(r10, r11) == false) goto L78;
        return true;
    L72:
        r23 = true;
    L83:
        return false;
    L58:
        int r28 = this.mMaxFlingVelocity;
        r16 = Math.max(-r28, Math.min(r16, r28));
        int r29 = this.mMaxFlingVelocity;
        r19 = Math.max(-r29, Math.min(r19, r29));
        this.mViewFlinger.b(r16, r19);
        goto L60
    L53:
        if ((r20.c() * r11) >= 0.0f) goto L56;
    L54:
        r11 = 0;
        goto L56
    L47:
        r19 = r11;
    L55:
        r19 = 0;
        goto L56
    L36:
        if ((r17.c() * r10) >= 0.0f) goto L39;
    L37:
        r10 = 0;
        goto L39
    L30:
        r16 = r10;
    L38:
        r16 = 0;
        goto L39
    L16:
        if (Math.abs(r11) >= this.mMinFlingVelocity) goto L18;
    L12:
        if (Math.abs(r10) >= this.mMinFlingVelocity) goto L14;
        goto L13
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View r10, int r11) {
        View r12 = this.mLayout.onInterceptFocusSearch(r10, r11);
        if (r12 == null) goto L5;
        return r12;
    L5:
        boolean r13 = true;
        if (this.mAdapter != null) goto L8;
    L14:
        boolean r14 = false;
    L15:
        FocusFinder r15 = FocusFinder.getInstance();
        if (r14 == true) goto L18;
    L61:
        View r16 = r15.findNextFocus(this, r10, r11);
        if (r16 != null) goto L68;
        if (r14 == false) goto L68;
        consumePendingUpdateOperations();
        if (findContainingItemView(r10) != null) goto L67;
        return null;
    L67:
        startInterceptRequestLayout();
        View r17 = this.mLayout.onFocusSearchFailed(r10, r11, this.mRecycler, this.mState);
        stopInterceptRequestLayout(false);
    L69:
        if (r17 == null) goto L79;
        if (r17.hasFocusable() == true) goto L79;
        if (getFocusedChild() == null) goto L75;
        D(r17, null);
        return r10;
    L75:
        return super.focusSearch(r10, r11);
    L79:
        if (u(r10, r17, r11) == false) goto L82;
        return r17;
    L82:
        return super.focusSearch(r10, r11);
    L68:
        r17 = r16;
        goto L69
    L18:
        if (r11 == 2) goto L21;
        if (r11 != 1) goto L61;
    L21:
        if (this.mLayout.canScrollVertically() == false) goto L32;
        if (r11 != 2) goto L24;
        int r18 = 130;
    L26:
        if (r15.findNextFocus(this, r10, r18) != null) goto L28;
        boolean r19 = true;
    L30:
        if (FORCE_ABS_FOCUS_SEARCH_DIRECTION == false) goto L33;
        r11 = r18;
    L33:
        if (r19 == false) goto L35;
    L55:
        if (r19 == false) goto L60;
        consumePendingUpdateOperations();
        if (findContainingItemView(r10) != null) goto L59;
        return null;
    L59:
        startInterceptRequestLayout();
        this.mLayout.onFocusSearchFailed(r10, r11, this.mRecycler, this.mState);
        stopInterceptRequestLayout(false);
    L60:
        r17 = r15.findNextFocus(this, r10, r11);
        goto L69
    L35:
        if (this.mLayout.canScrollHorizontally() == false) goto L55;
        if (this.mLayout.getLayoutDirection() != 1) goto L39;
        boolean r20 = true;
    L40:
        if (r11 != 2) goto L42;
        boolean r21 = true;
    L44:
        if ((r20 ^ r21) == false) goto L46;
        int r22 = 66;
    L48:
        if (r15.findNextFocus(this, r10, r22) == null) goto L52;
        r13 = false;
    L52:
        if (FORCE_ABS_FOCUS_SEARCH_DIRECTION == false) goto L54;
        r11 = r22;
    L54:
        r19 = r13;
        goto L55
    L46:
        r22 = 17;
        goto L48
    L42:
        r21 = false;
        goto L44
    L39:
        r20 = false;
        goto L40
    L28:
        r19 = false;
        goto L30
    L24:
        r18 = 33;
        goto L26
    L32:
        r19 = false;
        goto L33
    L8:
        if (this.mLayout == null) goto L14;
        if (isComputingLayout() == true) goto L14;
        if (this.mLayoutSuppressed == true) goto L14;
        r14 = true;
        goto L15
    }

    public final void g() {
        int r10 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (r10 != 0) goto L5;
        return;
    L5:
        if (isAccessibilityEnabled() == false) goto L9;
        AccessibilityEvent r11 = AccessibilityEvent.obtain();
        r11.setEventType(2048);
        AccessibilityEventCompat.b(r11, r10);
        sendAccessibilityEventUnchecked(r11);
        return;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager r10 = this.mLayout;
        if (r10 == null) goto L7;
        return r10.generateDefaultLayoutParams();
    L7:
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r10) {
        LayoutManager r11 = this.mLayout;
        if (r11 == null) goto L7;
        return r11.generateLayoutParams(getContext(), r10);
    L7:
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.fluidrecyclerview.widget.RecyclerView";
    }

    @Nullable
    public Adapter getAdapter() {
        return this.mAdapter;
    }

    public int getAdapterPositionInRecyclerView(ViewHolder r10) {
        if (r10.hasAnyOfTheFlags(524) == false) goto L5;
        return -1;
    L5:
        if (r10.isBound() == true) goto L8;
        return -1;
    L8:
        return this.mAdapterHelper.c(r10.mPosition);
    }

    @Override // android.view.View
    public int getBaseline() {
        LayoutManager r10 = this.mLayout;
        if (r10 == null) goto L7;
        return r10.getBaseline();
    L7:
        return super.getBaseline();
    }

    public long getChangedHolderKey(ViewHolder r10) {
        if (this.mAdapter.hasStableIds() == false) goto L6;
        return r10.getItemId();
    L6:
        return r10.mPosition;
    }

    public int getChildAdapterPosition(@NonNull View r10) {
        ViewHolder r11 = getChildViewHolderInt(r10);
        if (r11 != null) goto L7;
        return -1;
    L7:
        return r11.getAbsoluteAdapterPosition();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r10, int r11) {
        ChildDrawingOrderCallback r12 = this.mChildDrawingOrderCallback;
        if (r12 != null) goto L7;
        return super.getChildDrawingOrder(r10, r11);
    L7:
        return r12.onGetChildDrawingOrder(r10, r11);
    }

    public long getChildItemId(@NonNull View r10) {
        Adapter r11 = this.mAdapter;
        if (r11 != null) goto L5;
        return -1;
    L5:
        if (r11.hasStableIds() == false) goto L13;
        ViewHolder r12 = getChildViewHolderInt(r10);
        if (r12 != null) goto L10;
        return -1;
    L10:
        return r12.getItemId();
    L13:
        return -1;
    }

    public int getChildLayoutPosition(@NonNull View r10) {
        ViewHolder r11 = getChildViewHolderInt(r10);
        if (r11 != null) goto L7;
        return -1;
    L7:
        return r11.getLayoutPosition();
    }

    @Deprecated
    public int getChildPosition(@NonNull View r10) {
        return getChildAdapterPosition(r10);
    }

    public ViewHolder getChildViewHolder(@NonNull View r10) {
        ViewParent r11 = r10.getParent();
        if (r11 == null) goto L9;
        if (r11 == this) goto L9;
        throw new IllegalArgumentException("View " + r10 + " is not a direct child of " + this);
    L9:
        return getChildViewHolderInt(r10);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    @Nullable
    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void getDecoratedBoundsWithMargins(@NonNull View r10, @NonNull Rect r11) {
        getDecoratedBoundsWithMarginsInt(r10, r11);
    }

    @NonNull
    public EdgeEffectFactory getEdgeEffectFactory() {
        return null;
    }

    @Nullable
    public ItemAnimator getItemAnimator() {
        return this.mItemAnimator;
    }

    public Rect getItemDecorInsetsForChild(View r10) {
        LayoutParams r11 = (LayoutParams) r10.getLayoutParams();
        if (r11.mInsetsDirty == true) goto L7;
        return r11.mDecorInsets;
    L7:
        if (this.mState.f() == true) goto L9;
    L14:
        Rect r12 = r11.mDecorInsets;
        r12.set(0, 0, 0, 0);
        int r13 = this.mItemDecorations.size();
        int r14 = 0;
    L15:
        if (r14 >= r13) goto L17;
        this.mTempRect.set(0, 0, 0, 0);
        this.mItemDecorations.get(r14).getItemOffsets(this.mTempRect, r10, this, this.mState);
        int r15 = r12.left;
        Rect r16 = this.mTempRect;
        r12.left = r15 + r16.left;
        r12.top += r16.top;
        r12.right += r16.right;
        r12.bottom += r16.bottom;
        r14 = r14 + 1;
        goto L15
    L17:
        r11.mInsetsDirty = false;
        return r12;
    L9:
        if (r11.isItemChanged() == true) goto L13;
        if (r11.isViewInvalid() == false) goto L14;
    L13:
        return r11.mDecorInsets;
    }

    @NonNull
    public ItemDecoration getItemDecorationAt(int r10) {
        int r11 = getItemDecorationCount();
        if (r10 < 0) goto L8;
        if (r10 >= r11) goto L8;
        return this.mItemDecorations.get(r10);
    L8:
        throw new IndexOutOfBoundsException(r10 + " is an invalid index for size " + r11);
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    @Nullable
    public LayoutManager getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK == true) goto L5;
        return 0;
    L5:
        return System.nanoTime();
    }

    @Nullable
    public OnFlingListener getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    @NonNull
    public RecycledViewPool getRecycledViewPool() {
        return this.mRecycler.i();
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public final void h() {
        boolean r10 = true;
        this.mState.a(1);
        fillRemainingScrollValues(this.mState);
        this.mState.f4233j = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.f();
        onEnterLayoutOrScroll();
        x();
        G();
        State r11 = this.mState;
        if (r11.f4234k == true) goto L5;
    L7:
        r10 = false;
    L8:
        r11.f4232i = r10;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        r11.f4231h = r11.f4235l;
        r11.f4229f = this.mAdapter.getItemCount();
        m(this.mMinMaxLayoutPositions);
        if (this.mState.f4234k == false) goto L32;
        int r12 = this.mChildHelper.getChildCount();
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L32;
        ViewHolder r14 = getChildViewHolderInt(this.mChildHelper.getChildAt(r13));
        if (r14.shouldIgnore() == true) goto L30;
        if (r14.isInvalid() == true) goto L17;
    L19:
        this.mViewInfoStore.e(r14, this.mItemAnimator.u(this.mState, r14, ItemAnimator.e(r14), r14.getUnmodifiedPayloads()));
        if (this.mState.f4232i == false) goto L30;
        if (r14.isUpdated() == false) goto L30;
        if (r14.isRemoved() == true) goto L30;
        if (r14.shouldIgnore() == true) goto L30;
        if (r14.isInvalid() == true) goto L30;
        this.mViewInfoStore.c(getChangedHolderKey(r14), r14);
        goto L30
    L17:
        if (this.mAdapter.hasStableIds() == true) goto L19;
    L30:
        r13 = r13 + 1;
    L32:
        if (this.mState.f4235l == false) goto L50;
        saveOldPositions();
        State r15 = this.mState;
        boolean r16 = r15.f4230g;
        r15.f4230g = false;
        this.mLayout.onLayoutChildren(this.mRecycler, r15);
        this.mState.f4230g = r16;
        int r17 = 0;
    L35:
        if (r17 >= this.mChildHelper.getChildCount()) goto L49;
        ViewHolder r18 = getChildViewHolderInt(this.mChildHelper.getChildAt(r17));
        if (r18.shouldIgnore() == true) goto L48;
        if (this.mViewInfoStore.i(r18) == true) goto L48;
        int r19 = ItemAnimator.e(r18);
        boolean r20 = r18.hasAnyOfTheFlags(8192);
        if (r20 == true) goto L44;
        r19 = r19 | 4096;
    L44:
        ItemAnimator.ItemHolderInfo r21 = this.mItemAnimator.u(this.mState, r18, r19, r18.getUnmodifiedPayloads());
        if (r20 == false) goto L47;
        recordAnimationInfoIfBouncedHiddenView(r18, r21);
        goto L48
    L47:
        this.mViewInfoStore.a(r18, r21);
    L48:
        r17 = r17 + 1;
        goto L35
    L49:
        clearOldPositions();
    L51:
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.f4228e = 2;
        return;
    L50:
        clearOldPositions();
        goto L51
    L5:
        if (this.mItemsChanged == false) goto L7;
        goto L7
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().k();
    }

    public boolean hasPendingAdapterUpdates() {
        if (this.mFirstLayoutComplete == true) goto L5;
    L10:
        return true;
    L5:
        if (this.mDataSetHasChangedAfterLayout == true) goto L10;
        if (this.mAdapterHelper.n() == true) goto L10;
        return false;
    }

    public final void i() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.a(6);
        this.mAdapterHelper.h();
        this.mState.f4229f = this.mAdapter.getItemCount();
        this.mState.f4227d = 0;
        if (this.mPendingSavedState != null) goto L5;
    L10:
        State r10 = this.mState;
        r10.f4231h = false;
        this.mLayout.onLayoutChildren(this.mRecycler, r10);
        State r11 = this.mState;
        r11.f4230g = false;
        if (r11.f4234k == true) goto L13;
    L15:
        boolean r12 = false;
    L16:
        r11.f4234k = r12;
        r11.f4228e = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        return;
    L13:
        if (this.mItemAnimator == null) goto L15;
        r12 = true;
        goto L16
    L5:
        if (this.mAdapter.canRestoreState() == false) goto L10;
        Parcelable r13 = this.mPendingSavedState.mLayoutState;
        if (r13 == null) goto L9;
        this.mLayout.onRestoreInstanceState(r13);
    L9:
        this.mPendingSavedState = null;
        goto L10
    }

    public void initAdapterManager() {
        this.mAdapterHelper = new AdapterHelper(new f(this));
    }

    @VisibleForTesting
    public void initFastScroller(StateListDrawable r11, Drawable r12, StateListDrawable r13, Drawable r14) {
        if (r11 == null) goto L9;
        if (r12 == null) goto L9;
        if (r13 == null) goto L9;
        if (r14 == null) goto L9;
        Resources r10 = getContext().getResources();
        new androidx.recyclerview.widget.e(this, r11, r12, r13, r14, r10.getDimensionPixelSize(R$dimen.fastscroll_default_thickness), r10.getDimensionPixelSize(R$dimen.fastscroll_minimum_range), r10.getDimensionPixelOffset(R$dimen.fastscroll_margin));
        return;
    L9:
        throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
    }

    public void invalidateGlows() {
        this.mVerticalEdgeEffect = null;
        this.mHorizontalEdgeEffect = null;
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) goto L5;
        return;
    L5:
        LayoutManager r10 = this.mLayout;
        if (r10 == null) goto L8;
        r10.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
    L8:
        markItemDecorInsetsDirty();
        requestLayout();
    }

    public boolean isAccessibilityEnabled() {
        AccessibilityManager r10 = this.mAccessibilityManager;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.isEnabled() == false) goto L7;
        return true;
    }

    public boolean isAnimating() {
        ItemAnimator r10 = this.mItemAnimator;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.p() == false) goto L7;
        return true;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    public boolean isComputingLayout() {
        if (this.mLayoutOrScrollCounter <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Deprecated
    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().m();
    }

    public boolean isOverScrolling() {
        EdgeEffectAdapter r10 = this.mVerticalEdgeEffect;
        if (r10 != null) goto L5;
    L9:
        boolean r11 = false;
    L10:
        EdgeEffectAdapter r12 = this.mHorizontalEdgeEffect;
        if (r12 != null) goto L13;
    L17:
        boolean r13 = false;
    L18:
        if (r11 == true) goto L21;
        if (r13 == true) goto L21;
        return false;
    L21:
        return true;
    L13:
        if (r12.c() == 0.0f) goto L15;
    L16:
        r13 = true;
        goto L18
    L15:
        if (this.mHorizontalEdgeEffect.d() == true) goto L17;
    L5:
        if (r10.c() == 0.0f) goto L7;
    L8:
        r11 = true;
        goto L10
    L7:
        if (this.mVerticalEdgeEffect.d() == true) goto L9;
        goto L8
    }

    public final void j() {
        this.mState.a(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        State r10 = this.mState;
        r10.f4228e = 1;
        if (r10.f4234k == false) goto L24;
        int r11 = this.mChildHelper.getChildCount() - 1;
    L5:
        if (r11 < 0) goto L23;
        ViewHolder r12 = getChildViewHolderInt(this.mChildHelper.getChildAt(r11));
        if (r12.shouldIgnore() == true) goto L22;
        long r13 = getChangedHolderKey(r12);
        ItemAnimator.ItemHolderInfo r14 = this.mItemAnimator.t(this.mState, r12);
        ViewHolder r15 = this.mViewInfoStore.g(r13);
        if (r15 != null) goto L12;
    L21:
        this.mViewInfoStore.d(r12, r14);
        goto L22
    L12:
        if (r15.shouldIgnore() == true) goto L21;
        boolean r16 = this.mViewInfoStore.h(r15);
        boolean r17 = this.mViewInfoStore.h(r12);
        if (r16 == false) goto L17;
        if (r15 != r12) goto L17;
        this.mViewInfoStore.d(r12, r14);
    L17:
        ItemAnimator.ItemHolderInfo r18 = this.mViewInfoStore.n(r15);
        this.mViewInfoStore.d(r12, r14);
        ItemAnimator.ItemHolderInfo r19 = this.mViewInfoStore.m(r12);
        if (r18 != null) goto L20;
        q(r13, r12, r15);
        goto L22
    L20:
        b(r15, r12, r18, r19, r16, r17);
    L22:
        r11 = r11 - 1;
        goto L5
    L23:
        this.mViewInfoStore.o(this.mViewInfoProcessCallback);
    L24:
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        State r20 = this.mState;
        r20.f4226c = r20.f4229f;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        r20.f4234k = false;
        r20.f4235l = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        ArrayList r21 = this.mRecycler.f4208b;
        if (r21 == null) goto L27;
        r21.clear();
    L27:
        LayoutManager r22 = this.mLayout;
        if (r22.mPrefetchMaxObservedInInitialPrefetch == false) goto L30;
        r22.mPrefetchMaxCountObserved = 0;
        r22.mPrefetchMaxObservedInInitialPrefetch = false;
        this.mRecycler.P();
    L30:
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.f();
        int[] r23 = this.mMinMaxLayoutPositions;
        if (f(r23[0], r23[1]) == false) goto L33;
        dispatchOnScrolled(0, 0);
    L33:
        z();
        E();
    }

    public void jumpToPositionForSmoothScroller(int r10) {
        if (this.mLayout != null) goto L5;
        return;
    L5:
        setScrollState(2);
        this.mLayout.scrollToPosition(r10);
        awakenScrollBars();
    }

    public final boolean k(MotionEvent r10) {
        OnItemTouchListener r11 = this.mInterceptingOnItemTouchListener;
        if (r11 == null) goto L5;
        r11.onTouchEvent(this, r10);
        int r12 = r10.getAction();
        if (r12 == 3) goto L13;
        if (r12 == 1) goto L13;
    L14:
        return true;
    L13:
        this.mInterceptingOnItemTouchListener = null;
        goto L14
    L5:
        if (r10.getAction() != 0) goto L9;
        return false;
    L9:
        return l(r10);
    }

    public final boolean l(MotionEvent r10) {
        int r11 = r10.getAction();
        int r12 = this.mOnItemTouchListeners.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L11;
        OnItemTouchListener r14 = this.mOnItemTouchListeners.get(r13);
        if (r14.onInterceptTouchEvent(this, r10) == false) goto L10;
        if (r11 == 3) goto L10;
        this.mInterceptingOnItemTouchListener = r14;
        return true;
    L10:
        r13 = r13 + 1;
        goto L3
    L11:
        return false;
    }

    public final void m(int[] r10) {
        int r11 = this.mChildHelper.getChildCount();
        if (r11 != 0) goto L6;
        r10[0] = -1;
        r10[1] = -1;
        return;
    L6:
        int r12 = Channel.UNLIMITED;
        int r13 = Integer.MIN_VALUE;
        int r14 = 0;
    L7:
        if (r14 >= r11) goto L17;
        ViewHolder r15 = getChildViewHolderInt(this.mChildHelper.getChildAt(r14));
        if (r15.shouldIgnore() == true) goto L16;
        int r16 = r15.getLayoutPosition();
        if (r16 >= r12) goto L14;
        r12 = r16;
    L14:
        if (r16 <= r13) goto L16;
        r13 = r16;
    L16:
        r14 = r14 + 1;
        goto L7
    L17:
        r10[0] = r12;
        r10[1] = r13;
    }

    public void markItemDecorInsetsDirty() {
        int r10 = this.mChildHelper.getUnfilteredChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        ((LayoutParams) this.mChildHelper.getUnfilteredChildAt(r11).getLayoutParams()).mInsetsDirty = true;
        r11 = r11 + 1;
        goto L3
    L5:
        this.mRecycler.s();
    }

    public void markKnownViewsInvalid() {
        int r10 = this.mChildHelper.getUnfilteredChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L10;
        ViewHolder r12 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r11));
        if (r12 == null) goto L9;
        if (r12.shouldIgnore() == true) goto L9;
        r12.addFlags(6);
    L9:
        r11 = r11 + 1;
        goto L3
    L10:
        markItemDecorInsetsDirty();
        this.mRecycler.t();
    }

    public final View n() {
        State r10 = this.mState;
        int r11 = r10.f4236m;
        if (r11 != (-1)) goto L6;
        r11 = 0;
    L6:
        int r12 = r10.c();
        int r13 = r11;
    L7:
        if (r13 >= r12) goto L16;
        ViewHolder r14 = findViewHolderForAdapterPosition(r13);
        if (r14 == null) goto L16;
        if (r14.itemView.hasFocusable() == true) goto L14;
        r13 = r13 + 1;
        goto L7
    L14:
        return r14.itemView;
    L16:
        int r15 = Math.min(r12, r11);
    L17:
        r15 = r15 - 1;
        if (r15 < 0) goto L27;
        ViewHolder r16 = findViewHolderForAdapterPosition(r15);
        if (r16 == null) goto L21;
        if (r16.itemView.hasFocusable() == false) goto L17;
        return r16.itemView;
    L21:
        return null;
    L27:
        return null;
    }

    public void nestedScrollBy(int r10, int r11) {
        v(r10, r11, null, 1);
    }

    public final int o(View r10) {
        int r11 = r10.getId();
    L4:
        if (r10.isFocused() == true) goto L12;
        if ((r10 instanceof ViewGroup) == false) goto L12;
        if (r10.hasFocus() == false) goto L12;
        r10 = ((ViewGroup) r10).getFocusedChild();
        if (r10.getId() == (-1)) goto L4;
        r11 = r10.getId();
    L12:
        return r11;
    }

    public void offsetChildrenHorizontal(@Px int r10) {
        int r11 = this.mChildHelper.getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.mChildHelper.getChildAt(r12).offsetLeftAndRight(r10);
        r12 = r12 + 1;
        goto L3
    }

    public void offsetChildrenVertical(@Px int r10) {
        int r11 = this.mChildHelper.getChildCount();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.mChildHelper.getChildAt(r12).offsetTopAndBottom(r10);
        r12 = r12 + 1;
        goto L3
    }

    public void offsetPositionRecordsForInsert(int r10, int r11) {
        int r12 = this.mChildHelper.getUnfilteredChildCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L15;
        ViewHolder r14 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r13));
        if (r14 == null) goto L14;
        if (r14.shouldIgnore() == true) goto L14;
        if (r14.mPosition < r10) goto L14;
        if (sVerboseLoggingEnabled == false) goto L13;
        Log.d(TAG, "offsetPositionRecordsForInsert attached child " + r13 + " holder " + r14 + " now at position " + (r14.mPosition + r11));
    L13:
        r14.offsetPosition(r11, false);
        this.mState.f4230g = true;
    L14:
        r13 = r13 + 1;
        goto L3
    L15:
        this.mRecycler.v(r10, r11);
        requestLayout();
    }

    public void offsetPositionRecordsForMove(int r11, int r12) {
        int r10 = this.mChildHelper.getUnfilteredChildCount();
        if (r11 >= r12) goto L5;
        int r13 = -1;
        int r14 = r11;
        int r15 = r12;
    L6:
        int r16 = 0;
    L7:
        if (r16 >= r10) goto L23;
        ViewHolder r17 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r16));
        if (r17 == null) goto L22;
        int r18 = r17.mPosition;
        if (r18 < r14) goto L22;
        if (r18 > r15) goto L22;
        if (sVerboseLoggingEnabled == false) goto L18;
        Log.d(TAG, "offsetPositionRecordsForMove attached child " + r16 + " holder " + r17);
    L18:
        if (r17.mPosition != r11) goto L20;
        r17.offsetPosition(r12 - r11, false);
    L21:
        this.mState.f4230g = true;
        goto L22
    L20:
        r17.offsetPosition(r13, false);
    L22:
        r16 = r16 + 1;
        goto L7
    L23:
        this.mRecycler.w(r11, r12);
        requestLayout();
        return;
    L5:
        r15 = r11;
        r14 = r12;
        r13 = 1;
        goto L6
    }

    public void offsetPositionRecordsForRemove(int r10, int r11, boolean r12) {
        int r13 = r10 + r11;
        int r14 = this.mChildHelper.getUnfilteredChildCount();
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L20;
        ViewHolder r16 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r15));
        if (r16 == null) goto L19;
        if (r16.shouldIgnore() == true) goto L19;
        int r17 = r16.mPosition;
        if (r17 >= r13) goto L11;
        if (r17 < r10) goto L19;
        if (sVerboseLoggingEnabled == false) goto L18;
        Log.d(TAG, "offsetPositionRecordsForRemove attached child " + r15 + " holder " + r16 + " now REMOVED");
    L18:
        r16.flagRemovedAndOffsetPosition(r10 - 1, -r11, r12);
        this.mState.f4230g = true;
        goto L19
    L11:
        if (sVerboseLoggingEnabled == false) goto L13;
        Log.d(TAG, "offsetPositionRecordsForRemove attached child " + r15 + " holder " + r16 + " now at position " + (r16.mPosition - r11));
    L13:
        r16.offsetPosition(-r11, r12);
        this.mState.f4230g = true;
    L19:
        r15 = r15 + 1;
        goto L3
    L20:
        this.mRecycler.x(r10, r11, r12);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        boolean r10 = true;
        this.mIsAttached = true;
        if (this.mFirstLayoutComplete == true) goto L5;
    L7:
        r10 = false;
    L8:
        this.mFirstLayoutComplete = r10;
        this.mRecycler.z();
        LayoutManager r11 = this.mLayout;
        if (r11 == null) goto L11;
        r11.dispatchAttachedToWindow(this);
    L11:
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK == false) goto L25;
        ThreadLocal r12 = GapWorker.f4084e;
        GapWorker r13 = (GapWorker) r12.get();
        this.mGapWorker = r13;
        if (r13 != null) goto L23;
        this.mGapWorker = new GapWorker();
        Display r14 = ViewCompat.u(this);
        if (isInEditMode() == true) goto L21;
        if (r14 == null) goto L21;
        float r15 = r14.getRefreshRate();
        if (r15 < 30.0f) goto L21;
    L22:
        GapWorker r16 = this.mGapWorker;
        r16.f4088c = (long) (1.0E9f / r15);
        r12.set(r16);
    L21:
        r15 = 60.0f;
    L23:
        this.mGapWorker.a(this);
        return;
    L25:
        return;
    L5:
        if (isLayoutRequested() == true) goto L7;
        goto L7
    }

    public void onChildAttachedToWindow(@NonNull View r10) {
    }

    public void onChildDetachedFromWindow(@NonNull View r10) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ItemAnimator r10 = this.mItemAnimator;
        if (r10 == null) goto L5;
        r10.k();
    L5:
        stopScroll();
        this.mIsAttached = false;
        LayoutManager r11 = this.mLayout;
        if (r11 == null) goto L8;
        r11.dispatchDetachedFromWindow(this, this.mRecycler);
    L8:
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.j();
        this.mRecycler.A();
        t.a.b(this);
        if (ALLOW_THREAD_GAP_WORK == false) goto L14;
        GapWorker r12 = this.mGapWorker;
        if (r12 == null) goto L15;
        r12.j(this);
        this.mGapWorker = null;
        return;
    L15:
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r10) {
        super.onDraw(r10);
        int r11 = this.mItemDecorations.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.mItemDecorations.get(r12).onDraw(r10, this, this.mState);
        r12 = r12 + 1;
        goto L3
    }

    public void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    public void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent r10) {
        if (this.mLayout != null) goto L6;
        return false;
    L6:
        if (this.mLayoutSuppressed == false) goto L9;
        return false;
    L9:
        if (r10.getAction() == 8) goto L11;
    L34:
        return false;
    L11:
        if ((r10.getSource() & 2) == 0) goto L21;
        if (this.mLayout.canScrollVertically() == false) goto L15;
        float r11 = -r10.getAxisValue(9);
    L17:
        if (this.mLayout.canScrollHorizontally() == false) goto L19;
        float r12 = r10.getAxisValue(10);
    L30:
        if (r11 == 0.0f) goto L32;
    L33:
        v((int) (r12 * this.mScaledHorizontalScrollFactor), (int) (r11 * this.mScaledVerticalScrollFactor), r10, 1);
        goto L34
    L32:
        if (r12 == 0.0f) goto L34;
    L19:
        r12 = 0.0f;
        goto L30
    L15:
        r11 = 0.0f;
        goto L17
    L21:
        if ((r10.getSource() & UiType.FLAG_NO_FEEDBACK) == 0) goto L28;
        float r13 = r10.getAxisValue(26);
        if (this.mLayout.canScrollVertically() == false) goto L26;
        r11 = -r13;
        goto L19
    L26:
        if (this.mLayout.canScrollHorizontally() == false) goto L28;
        r12 = r13;
        r11 = 0.0f;
    L28:
        r11 = 0.0f;
        r12 = 0.0f;
        goto L30
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r10) {
        if (this.mLayoutSuppressed == false) goto L5;
        return false;
    L5:
        this.mInterceptingOnItemTouchListener = null;
        if (l(r10) == false) goto L9;
        c();
        return true;
    L9:
        LayoutManager r11 = this.mLayout;
        if (r11 != null) goto L12;
        return false;
    L12:
        boolean r12 = r11.canScrollHorizontally();
        boolean r13 = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker != null) goto L15;
        this.mVelocityTracker = androidx.recyclerview.base.g.a(getContext());
    L15:
        this.mVelocityTracker.addMovement(r10);
        int r14 = r10.getActionMasked();
        int r15 = r10.getActionIndex();
        if (r14 == 0) goto L50;
        if (r14 == 1) goto L47;
        if (r14 != 2) goto L20;
        int r16 = r10.findPointerIndex(this.mScrollPointerId);
        if (r16 >= 0) goto L33;
        Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
        return false;
    L33:
        int r17 = (int) (r10.getX(r16) + 0.5f);
        int r18 = (int) (r10.getY(r16) + 0.5f);
        if (this.mScrollState == 1) goto L48;
        int r19 = r17 - this.mInitialTouchX;
        int r20 = r18 - this.mInitialTouchY;
        if (r12 == true) goto L38;
    L40:
        boolean r21 = false;
    L41:
        if (r13 == true) goto L43;
    L45:
        if (r21 == false) goto L48;
        setScrollState(1);
        goto L48
    L43:
        if (Math.abs(r20) <= this.mTouchSlop) goto L45;
        this.mLastTouchY = r18;
        r21 = true;
        goto L45
    L38:
        if (Math.abs(r19) <= this.mTouchSlop) goto L40;
        this.mLastTouchX = r17;
        r21 = true;
    L48:
        boolean r22 = false;
    L63:
        if (r22 == false) goto L65;
        return false;
    L65:
        if (this.mScrollState == 1) goto L67;
        return false;
    L67:
        return true;
    L20:
        if (r14 != 3) goto L22;
        c();
        goto L48
    L22:
        if (r14 != 5) goto L24;
        this.mScrollPointerId = r10.getPointerId(r15);
        int r23 = (int) (r10.getX(r15) + 0.5f);
        this.mLastTouchX = r23;
        this.mInitialTouchX = r23;
        int r24 = (int) (r10.getY(r15) + 0.5f);
        this.mLastTouchY = r24;
        this.mInitialTouchY = r24;
        goto L48
    L24:
        if (r14 != 6) goto L48;
        onPointerUp(r10);
        goto L48
    L47:
        this.mVelocityTracker.clear();
        stopNestedScroll(0);
        goto L48
    L50:
        if (this.mIgnoreMotionEventTillDown == false) goto L52;
        this.mIgnoreMotionEventTillDown = false;
    L52:
        this.mScrollPointerId = r10.getPointerId(0);
        int r25 = (int) (r10.getX() + 0.5f);
        this.mLastTouchX = r25;
        this.mInitialTouchX = r25;
        int r26 = (int) (r10.getY() + 0.5f);
        this.mLastTouchY = r26;
        this.mInitialTouchY = r26;
        r22 = this.mRecyclerViewExt.b(r10, false);
        if (r22 == false) goto L55;
    L59:
        int[] r27 = this.mNestedOffsets;
        r27[1] = 0;
        r27[0] = 0;
        int r28 = r12;
        if (r13 == false) goto L62;
        r28 = (r12 ? 1 : 0) | 2;
    L62:
        startNestedScroll(r28, 0);
        goto L63
    L55:
        if (J(r10) == false) goto L57;
    L58:
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
        stopNestedScroll(1);
        goto L59
    L57:
        if (this.mScrollState != 2) goto L59;
        goto L58
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        androidx.core.os.g.a(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        androidx.core.os.g.b();
        this.mFirstLayoutComplete = true;
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        LayoutManager r12 = this.mLayout;
        if (r12 != null) goto L6;
        defaultOnMeasure(r10, r11);
        return;
    L6:
        boolean r13 = false;
        if (r12.isAutoMeasureEnabled() == false) goto L26;
        int r14 = View.MeasureSpec.getMode(r10);
        int r15 = View.MeasureSpec.getMode(r11);
        this.mLayout.onMeasure(this.mRecycler, this.mState, r10, r11);
        if (r14 != 1073741824) goto L12;
        if (r15 != 1073741824) goto L12;
        r13 = true;
    L12:
        this.mLastAutoMeasureSkippedDueToExact = r13;
        if (r13 == false) goto L15;
        return;
    L15:
        if (this.mAdapter != null) goto L18;
        return;
    L18:
        if (this.mState.f4228e != 1) goto L20;
        h();
    L20:
        this.mLayout.setMeasureSpecs(r10, r11);
        this.mState.f4233j = true;
        i();
        this.mLayout.setMeasuredDimensionFromChildren(r10, r11);
        if (this.mLayout.shouldMeasureTwice() == false) goto L23;
        this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), Ints.MAX_POWER_OF_TWO));
        this.mState.f4233j = true;
        i();
        this.mLayout.setMeasuredDimensionFromChildren(r10, r11);
    L23:
        this.mLastAutoMeasureNonExactMeasuredWidth = getMeasuredWidth();
        this.mLastAutoMeasureNonExactMeasuredHeight = getMeasuredHeight();
        return;
    L26:
        if (this.mHasFixedSize == false) goto L30;
        this.mLayout.onMeasure(this.mRecycler, this.mState, r10, r11);
        return;
    L30:
        if (this.mAdapterUpdateDuringMeasure == false) goto L37;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        x();
        onExitLayoutOrScroll();
        State r16 = this.mState;
        if (r16.f4235l == false) goto L34;
        r16.f4231h = true;
    L35:
        this.mAdapterUpdateDuringMeasure = false;
        stopInterceptRequestLayout(false);
    L40:
        Adapter r17 = this.mAdapter;
        if (r17 == null) goto L43;
        this.mState.f4229f = r17.getItemCount();
    L44:
        startInterceptRequestLayout();
        this.mLayout.onMeasure(this.mRecycler, this.mState, r10, r11);
        stopInterceptRequestLayout(false);
        this.mState.f4231h = false;
        return;
    L43:
        this.mState.f4229f = 0;
        goto L44
    L34:
        this.mAdapterHelper.h();
        this.mState.f4231h = false;
        goto L35
    L37:
        if (this.mState.f4235l == false) goto L40;
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int r10, Rect r11) {
        if (isComputingLayout() == false) goto L7;
        return false;
    L7:
        return super.onRequestFocusInDescendants(r10, r11);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r10) {
        if ((r10 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r10);
        return;
    L6:
        SavedState r11 = (SavedState) r10;
        this.mPendingSavedState = r11;
        super.onRestoreInstanceState(r11.getSuperState());
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r10 = new SavedState(super.onSaveInstanceState());
        SavedState r11 = this.mPendingSavedState;
        if (r11 == null) goto L5;
        r10.copyFrom(r11);
    L9:
        return r10;
    L5:
        LayoutManager r12 = this.mLayout;
        if (r12 == null) goto L8;
        r10.mLayoutState = r12.onSaveInstanceState();
        goto L9
    L8:
        r10.mLayoutState = null;
        goto L9
    }

    public void onScrollStateChanged(int r10) {
    }

    public void onScrolled(@Px int r10, @Px int r11) {
    }

    @Override // android.view.View
    public void onSizeChanged(int r10, int r11, int r12, int r13) {
        super.onSizeChanged(r10, r11, r12, r13);
        if (r10 != r12) goto L5;
        if (r11 != r13) goto L5;
        return;
    L5:
        invalidateGlows();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r18) {
        if (this.mLayoutSuppressed == false) goto L5;
    L106:
        return false;
    L5:
        if (this.mIgnoreMotionEventTillDown == true) goto L106;
        if (k(r18) == false) goto L11;
        c();
        return true;
    L11:
        LayoutManager r10 = this.mLayout;
        if (r10 != null) goto L14;
        return false;
    L14:
        boolean r11 = r10.canScrollHorizontally();
        boolean r12 = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker != null) goto L17;
        this.mVelocityTracker = androidx.recyclerview.base.g.a(getContext());
    L17:
        int r13 = r18.getActionMasked();
        int r14 = r18.getActionIndex();
        if (r13 != 0) goto L20;
        int[] r15 = this.mNestedOffsets;
        r15[1] = 0;
        r15[0] = 0;
    L20:
        MotionEvent r16 = MotionEvent.obtain(r18);
        int[] r17 = this.mNestedOffsets;
        r16.offsetLocation(r17[0], r17[1]);
        if (r13 != 0) goto L23;
        this.mScrollPointerId = r18.getPointerId(0);
        int r19 = (int) (r18.getX() + 0.5f);
        this.mLastTouchX = r19;
        this.mInitialTouchX = r19;
        int r20 = (int) (r18.getY() + 0.5f);
        this.mLastTouchY = r20;
        this.mInitialTouchY = r20;
        int r110 = r11;
        if (r12 == false) goto L102;
        r110 = (r11 ? 1 : 0) | 2;
    L102:
        startNestedScroll(r110, 0);
    L103:
        this.mVelocityTracker.addMovement(r16);
    L104:
        r16.recycle();
        return true;
    L23:
        if (r13 != 1) goto L25;
        this.mVelocityTracker.addMovement(r16);
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
        if (r11 == false) goto L87;
        float r21 = -this.mVelocityTracker.getXVelocity(this.mScrollPointerId);
    L88:
        if (r12 == false) goto L90;
        float r22 = -this.mVelocityTracker.getYVelocity(this.mScrollPointerId);
    L91:
        Log.d(TAG, "TouchUp, Velocity: x: " + r21 + ", y: " + r22);
        if (r21 != 0.0f) goto L96;
        if (r22 != 0.0f) goto L96;
    L97:
        Log.d(TAG, "No fling, setting scroll state to idle");
        setScrollState(0);
    L98:
        F();
    L96:
        if (fling((int) r21, (int) r22) == true) goto L98;
    L90:
        r22 = 0.0f;
        goto L91
    L87:
        r21 = 0.0f;
        goto L88
    L25:
        if (r13 != 2) goto L27;
        int r23 = r18.findPointerIndex(this.mScrollPointerId);
        if (r23 >= 0) goto L40;
        Log.e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
        return false;
    L40:
        int r111 = (int) (r18.getX(r23) + 0.5f);
        int r112 = (int) (r18.getY(r23) + 0.5f);
        int r24 = this.mLastTouchX - r111;
        int r25 = this.mLastTouchY - r112;
        if (this.mScrollState == 1) goto L58;
        if (r11 == false) goto L48;
        if (r24 <= 0) goto L45;
        r24 = Math.max(0, r24 - this.mTouchSlop);
    L46:
        if (r24 == 0) goto L48;
        boolean r26 = true;
    L49:
        if (r12 == false) goto L55;
        if (r25 <= 0) goto L52;
        r25 = Math.max(0, r25 - this.mTouchSlop);
    L53:
        if (r25 == 0) goto L55;
        r26 = true;
        goto L55
    L52:
        r25 = Math.min(0, r25 + this.mTouchSlop);
    L55:
        if (r26 == false) goto L58;
        setScrollState(1);
        goto L58
    L45:
        r24 = Math.min(0, r24 + this.mTouchSlop);
    L48:
        r26 = false;
    L58:
        if (this.mScrollState != 1) goto L103;
        int[] r27 = this.mReusableIntPair;
        r27[0] = 0;
        r27[1] = 0;
        int r113 = r24 - B(r24, r18.getY());
        int r114 = r25 - C(r25, r18.getX());
        if (r11 == false) goto L62;
        int r28 = r113;
    L63:
        if (r12 == false) goto L65;
        int r29 = r114;
    L67:
        if (dispatchNestedPreScroll(r28, r29, this.mReusableIntPair, this.mScrollOffset, 0) == false) goto L69;
        int[] r30 = this.mReusableIntPair;
        r113 = r113 - r30[0];
        r114 = r114 - r30[1];
        int[] r31 = this.mNestedOffsets;
        int r32 = r31[0];
        int[] r33 = this.mScrollOffset;
        r31[0] = r32 + r33[0];
        r31[1] = r31[1] + r33[1];
        getParent().requestDisallowInterceptTouchEvent(true);
    L69:
        int r34 = r114;
        int[] r35 = this.mScrollOffset;
        this.mLastTouchX = r111 - r35[0];
        this.mLastTouchY = r112 - r35[1];
        if (r11 == false) goto L72;
        int r36 = r113;
    L73:
        if (r12 == false) goto L75;
        int r37 = r34;
    L77:
        if (scrollByInternal(r36, r37, r18, 0) == false) goto L79;
        getParent().requestDisallowInterceptTouchEvent(true);
    L79:
        GapWorker r38 = this.mGapWorker;
        if (r38 == null) goto L103;
        if (r113 != 0) goto L83;
        if (r34 == 0) goto L103;
    L83:
        r38.f(this, r113, r34);
        goto L103
    L75:
        r37 = 0;
        goto L77
    L72:
        r36 = 0;
        goto L73
    L65:
        r29 = 0;
        goto L67
    L62:
        r28 = 0;
        goto L63
    L27:
        if (r13 != 3) goto L29;
        c();
        goto L103
    L29:
        if (r13 != 5) goto L31;
        this.mScrollPointerId = r18.getPointerId(r14);
        int r39 = (int) (r18.getX(r14) + 0.5f);
        this.mLastTouchX = r39;
        this.mInitialTouchX = r39;
        int r40 = (int) (r18.getY(r14) + 0.5f);
        this.mLastTouchY = r40;
        this.mInitialTouchY = r40;
        goto L103
    L31:
        if (r13 != 6) goto L103;
        onPointerUp(r18);
        goto L103
    }

    public final String p(Context r10, String r11) {
        if (r11.charAt(0) != '.') goto L7;
        return r10.getPackageName() + r11;
    L7:
        if (r11.contains(LibrarianImpl.Constants.DOT) == false) goto L10;
        return r11;
    L10:
        return RecyclerView.class.getPackage().getName() + '.' + r11;
    }

    public void postAnimationRunner() {
        if (this.mPostedAnimatorRunner == false) goto L5;
        return;
    L5:
        if (this.mIsAttached == false) goto L9;
        ViewCompat.h0(this, this.mItemAnimatorRunner);
        this.mPostedAnimatorRunner = true;
        return;
    }

    public void processDataSetCompletelyChanged(boolean r10) {
        this.mDispatchItemsChangedEvent = r10 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    public final void q(long r10, ViewHolder r11, ViewHolder r12) {
        int r13 = this.mChildHelper.getChildCount();
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L18;
        ViewHolder r15 = getChildViewHolderInt(this.mChildHelper.getChildAt(r14));
        if (r15 == r11) goto L17;
        if (getChangedHolderKey(r15) != r10) goto L17;
        Adapter r16 = this.mAdapter;
        if (r16 == null) goto L16;
        if (r16.hasStableIds() == false) goto L16;
        throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + r15 + " \n View Holder 2:" + r11 + exceptionLabel());
    L16:
        throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + r15 + " \n View Holder 2:" + r11 + exceptionLabel());
    L17:
        r14 = r14 + 1;
        goto L3
    L18:
        Log.e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + r12 + " cannot be found but it is necessary for " + r11 + exceptionLabel());
    }

    public final boolean r() {
        int r10 = this.mChildHelper.getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L14;
        ViewHolder r12 = getChildViewHolderInt(this.mChildHelper.getChildAt(r11));
        if (r12 == null) goto L13;
        if (r12.shouldIgnore() == true) goto L13;
        if (r12.isUpdated() == false) goto L13;
        return true;
    L13:
        r11 = r11 + 1;
        goto L3
    L14:
        return false;
    }

    public void recordAnimationInfoIfBouncedHiddenView(ViewHolder r10, ItemAnimator.ItemHolderInfo r11) {
        r10.setFlags(0, 8192);
        if (this.mState.f4232i == true) goto L5;
    L11:
        this.mViewInfoStore.e(r10, r11);
        return;
    L5:
        if (r10.isUpdated() == false) goto L11;
        if (r10.isRemoved() == true) goto L11;
        if (r10.shouldIgnore() == true) goto L11;
        long r12 = getChangedHolderKey(r10);
        this.mViewInfoStore.c(r12, r10);
        goto L11
    }

    public void removeAndRecycleViews() {
        ItemAnimator r10 = this.mItemAnimator;
        if (r10 == null) goto L5;
        r10.k();
    L5:
        LayoutManager r11 = this.mLayout;
        if (r11 == null) goto L8;
        r11.removeAndRecycleAllViews(this.mRecycler);
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
    L8:
        this.mRecycler.c();
    }

    public boolean removeAnimatingView(View r10) {
        startInterceptRequestLayout();
        boolean r11 = this.mChildHelper.removeViewIfHidden(r10);
        if (r11 == false) goto L7;
        ViewHolder r12 = getChildViewHolderInt(r10);
        this.mRecycler.O(r12);
        this.mRecycler.H(r12);
        if (sVerboseLoggingEnabled == false) goto L7;
        Log.d(TAG, "after removing animated view: " + r10 + ", " + this);
    L7:
        stopInterceptRequestLayout(!r11);
        return r11;
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View r10, boolean r11) {
        ViewHolder r12 = getChildViewHolderInt(r10);
        if (r12 == null) goto L13;
        if (r12.isTmpDetached() == false) goto L8;
        r12.clearTmpDetachFlag();
    L14:
        r10.clearAnimation();
        dispatchChildDetached(r10);
        super.removeDetachedView(r10, r11);
        return;
    L8:
        if (r12.shouldIgnore() == true) goto L14;
        throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + r12 + exceptionLabel());
    L13:
        if (sDebugAssertionsEnabled == false) goto L14;
        throw new IllegalArgumentException("No ViewHolder found for child: " + r10 + exceptionLabel());
    }

    public void removeItemDecoration(@NonNull ItemDecoration r10) {
        LayoutManager r11 = this.mLayout;
        if (r11 == null) goto L5;
        r11.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
    L5:
        this.mItemDecorations.remove(r10);
        if (this.mItemDecorations.isEmpty() == true) goto L8;
    L12:
        markItemDecorInsetsDirty();
        requestLayout();
        return;
    L8:
        if (getOverScrollMode() != 2) goto L10;
        boolean r12 = true;
    L11:
        setWillNotDraw(r12);
        goto L12
    L10:
        r12 = false;
        goto L11
    }

    public void removeItemDecorationAt(int r10) {
        int r11 = getItemDecorationCount();
        if (r10 < 0) goto L8;
        if (r10 >= r11) goto L8;
        removeItemDecoration(getItemDecorationAt(r10));
        return;
    L8:
        throw new IndexOutOfBoundsException(r10 + " is an invalid index for size " + r11);
    }

    public void removeOnChildAttachStateChangeListener(@NonNull OnChildAttachStateChangeListener r10) {
        List<OnChildAttachStateChangeListener> r11 = this.mOnChildAttachStateListeners;
        if (r11 != null) goto L5;
        return;
    L5:
        r11.remove(r10);
    }

    public void removeOnItemTouchListener(@NonNull OnItemTouchListener r10) {
        this.mOnItemTouchListeners.remove(r10);
        if (this.mInterceptingOnItemTouchListener != r10) goto L6;
        this.mInterceptingOnItemTouchListener = null;
        return;
    }

    public void removeOnScrollListener(@NonNull OnScrollListener r10) {
        List<OnScrollListener> r11 = this.mScrollListeners;
        if (r11 == null) goto L6;
        r11.remove(r10);
        return;
    }

    public void removeRecyclerListener(@NonNull RecyclerListener r10) {
        this.mRecyclerListeners.remove(r10);
    }

    public void repositionShadowingViews() {
        int r10 = this.mChildHelper.getChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L14;
        View r12 = this.mChildHelper.getChildAt(r11);
        ViewHolder r13 = getChildViewHolder(r12);
        if (r13 == null) goto L13;
        ViewHolder r14 = r13.mShadowingHolder;
        if (r14 == null) goto L13;
        View r15 = r14.itemView;
        int r16 = r12.getLeft();
        int r17 = r12.getTop();
        if (r16 == r15.getLeft()) goto L11;
    L12:
        r15.layout(r16, r17, r15.getWidth() + r16, r15.getHeight() + r17);
        goto L13
    L11:
        if (r17 != r15.getTop()) goto L12;
    L13:
        r11 = r11 + 1;
        goto L3
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View r10, View r11) {
        if (this.mLayout.onRequestChildFocus(this, this.mState, r10, r11) == true) goto L6;
        if (r11 == null) goto L6;
        D(r10, r11);
    L6:
        super.requestChildFocus(r10, r11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View r10, Rect r11, boolean r12) {
        return this.mLayout.requestChildRectangleOnScreen(this, r10, r11, r12);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r10) {
        int r11 = this.mOnItemTouchListeners.size();
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        this.mOnItemTouchListeners.get(r12).onRequestDisallowInterceptTouchEvent(r10);
        r12 = r12 + 1;
        goto L3
    L5:
        super.requestDisallowInterceptTouchEvent(r10);
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

    public final void s() {
        if (ViewCompat.z(this) != 0) goto L6;
        ViewCompat.B0(this, 8);
        return;
    }

    public void saveOldPositions() {
        int r10 = this.mChildHelper.getUnfilteredChildCount();
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L17;
        ViewHolder r12 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r11));
        if (sDebugAssertionsEnabled == false) goto L14;
        if (r12.mPosition != (-1)) goto L14;
        if (r12.isRemoved() == true) goto L14;
        throw new IllegalStateException("view holder cannot have position -1 unless it is removed" + exceptionLabel());
    L14:
        if (r12.shouldIgnore() == true) goto L16;
        r12.saveOldPosition();
    L16:
        r11 = r11 + 1;
        goto L3
    }

    @Override // android.view.View
    public void scrollBy(int r10, int r11) {
        LayoutManager r12 = this.mLayout;
        if (r12 != null) goto L7;
        Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return;
    L9:
        boolean r13 = r12.canScrollHorizontally();
        boolean r14 = this.mLayout.canScrollVertically();
        if (r13 == true) goto L13;
        if (r14 == true) goto L13;
        return;
    L13:
        if (r13 == true) goto L16;
        r10 = 0;
    L16:
        if (r14 == true) goto L19;
        r11 = 0;
    L19:
        scrollByInternal(r10, r11, null, 0);
    }

    public boolean scrollByInternal(int r17, int r18, MotionEvent r19, int r20) {
        consumePendingUpdateOperations();
        if (this.mAdapter == null) goto L5;
        int[] r10 = this.mReusableIntPair;
        r10[0] = 0;
        r10[1] = 0;
        scrollStep(r17, r18, r10);
        int[] r11 = this.mReusableIntPair;
        int r12 = r11[0];
        int r13 = r11[1];
        int r14 = r17 - r12;
        int r15 = r18 - r13;
        int r16 = r13;
        int r110 = r12;
    L7:
        if (this.mItemDecorations.isEmpty() == true) goto L9;
        invalidate();
    L9:
        int[] r21 = this.mReusableIntPair;
        r21[0] = 0;
        r21[1] = 0;
        dispatchNestedScroll(r110, r16, r14, r15, this.mScrollOffset, r20, r21);
        int[] r22 = this.mReusableIntPair;
        int r23 = r22[0];
        int r111 = r14 - r23;
        int r24 = r22[1];
        int r112 = r15 - r24;
        if (r23 != 0) goto L14;
        if (r24 != 0) goto L14;
        boolean r25 = false;
    L15:
        int r26 = this.mLastTouchX;
        int[] r27 = this.mScrollOffset;
        int r28 = r27[0];
        this.mLastTouchX = r26 - r28;
        int r29 = this.mLastTouchY;
        int r30 = r27[1];
        this.mLastTouchY = r29 - r30;
        int[] r31 = this.mNestedOffsets;
        r31[0] = r31[0] + r28;
        r31[1] = r31[1] + r30;
        if (getOverScrollMode() == 2) goto L21;
        if (r19 == null) goto L21;
        if (androidx.core.view.h.a(r19, 8194) == true) goto L21;
        y(r19.getX(), r111, r19.getY(), r112);
    L21:
        if (r110 != 0) goto L23;
        if (r16 != 0) goto L23;
    L25:
        if (awakenScrollBars() == true) goto L27;
        invalidate();
    L27:
        if (r25 == true) goto L33;
        if (r110 != 0) goto L34;
        if (r16 == 0) goto L32;
        return true;
    L32:
        return false;
    L34:
        return true;
    L33:
        return true;
    L23:
        dispatchOnScrolled(r110, r16);
    L14:
        r25 = true;
        goto L15
    L5:
        r14 = 0;
        r15 = 0;
        r16 = 0;
        r110 = 0;
        goto L7
    }

    public void scrollStep(int r10, int r11, @Nullable int[] r12) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        androidx.core.os.g.a(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        if (r10 == 0) goto L5;
        int r13 = this.mLayout.scrollHorizontallyBy(r10, this.mRecycler, this.mState);
    L6:
        if (r11 == 0) goto L8;
        int r14 = this.mLayout.scrollVerticallyBy(r11, this.mRecycler, this.mState);
    L9:
        androidx.core.os.g.b();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (r12 == null) goto L13;
        r12[0] = r13;
        r12[1] = r14;
        return;
    L13:
        return;
    L8:
        r14 = 0;
        goto L9
    L5:
        r13 = 0;
        goto L6
    }

    @Override // android.view.View
    public void scrollTo(int r10, int r11) {
        Log.w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void scrollToPosition(int r10) {
        if (this.mLayoutSuppressed == false) goto L5;
        return;
    L5:
        stopScroll();
        LayoutManager r11 = this.mLayout;
        if (r11 != null) goto L9;
        Log.e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L9:
        r11.scrollToPosition(r10);
        awakenScrollBars();
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent r10) {
        if (shouldDeferAccessibilityEvent(r10) == false) goto L5;
        return;
    L5:
        super.sendAccessibilityEventUnchecked(r10);
    }

    public void setAccessibilityDelegateCompat(@Nullable RecyclerViewAccessibilityDelegate r10) {
        this.mAccessibilityDelegate = r10;
        ViewCompat.p0(this, r10);
    }

    public void setAdapter(@Nullable Adapter r10) {
        setLayoutFrozen(false);
        H(r10, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(@Nullable ChildDrawingOrderCallback r10) {
        if (r10 != this.mChildDrawingOrderCallback) goto L5;
        return;
    L5:
        this.mChildDrawingOrderCallback = r10;
        if (r10 == null) goto L8;
        boolean r11 = true;
    L9:
        setChildrenDrawingOrderEnabled(r11);
        return;
    L8:
        r11 = false;
        goto L9
    }

    @VisibleForTesting
    public boolean setChildImportantForAccessibilityInternal(ViewHolder r10, int r11) {
        if (isComputingLayout() == false) goto L6;
        r10.mPendingAccessibilityState = r11;
        this.mPendingAccessibilityImportanceChange.add(r10);
        return false;
    L6:
        ViewCompat.A0(r10.itemView, r11);
        return true;
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean r10) {
        if (r10 == this.mClipToPadding) goto L5;
        invalidateGlows();
    L5:
        this.mClipToPadding = r10;
        super.setClipToPadding(r10);
        if (this.mFirstLayoutComplete == false) goto L9;
        requestLayout();
        return;
    }

    public void setEdgeEffectFactory(@NonNull EdgeEffectFactory r10) {
    }

    public void setEnableOverFling(boolean r10) {
        this.mEnableOverFling = r10;
    }

    public void setHasFixedSize(boolean r10) {
        this.mHasFixedSize = r10;
    }

    public void setItemAnimator(@Nullable ItemAnimator r10) {
        ItemAnimator r11 = this.mItemAnimator;
        if (r11 == null) goto L5;
        r11.k();
        this.mItemAnimator.y(null);
    L5:
        this.mItemAnimator = r10;
        if (r10 == null) goto L9;
        r10.y(this.mItemAnimatorListener);
        return;
    }

    public void setItemViewCacheSize(int r10) {
        this.mRecycler.L(r10);
    }

    @Deprecated
    public void setLayoutFrozen(boolean r10) {
        suppressLayout(r10);
    }

    public void setLayoutManager(@Nullable LayoutManager r10) {
        if (r10 != this.mLayout) goto L5;
        return;
    L5:
        stopScroll();
        if (this.mLayout == null) goto L14;
        ItemAnimator r11 = this.mItemAnimator;
        if (r11 == null) goto L10;
        r11.k();
    L10:
        this.mLayout.removeAndRecycleAllViews(this.mRecycler);
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        this.mRecycler.c();
        if (this.mIsAttached == false) goto L13;
        this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
    L13:
        this.mLayout.setRecyclerView(null);
        this.mLayout = null;
    L15:
        this.mChildHelper.removeAllViewsUnfiltered();
        this.mLayout = r10;
        if (r10 != null) goto L18;
    L24:
        this.mRecycler.P();
        requestLayout();
        return;
    L18:
        if (r10.mRecyclerView != null) goto L23;
        r10.setRecyclerView(this);
        if (this.mIsAttached == false) goto L24;
        this.mLayout.dispatchAttachedToWindow(this);
        goto L24
    L23:
        throw new IllegalArgumentException("LayoutManager " + r10 + " is already attached to a RecyclerView:" + r10.mRecyclerView.exceptionLabel());
    L14:
        this.mRecycler.c();
        goto L15
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition r10) {
        if (r10 != null) goto L6;
        super.setLayoutTransition(null);
        return;
    L6:
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void setMinFlingVelocity(int r10) {
        this.mMinFlingVelocity = r10;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r10) {
        getScrollingChildHelper().n(r10);
    }

    public void setOnFlingListener(@Nullable OnFlingListener r10) {
        this.mOnFlingListener = r10;
    }

    @Deprecated
    public void setOnScrollListener(@Nullable OnScrollListener r10) {
        this.mScrollListener = r10;
    }

    public void setPreserveFocusAfterLayout(boolean r10) {
        this.mPreserveFocusAfterLayout = r10;
    }

    public void setRecycledViewPool(@Nullable RecycledViewPool r10) {
        this.mRecycler.J(r10);
    }

    @Deprecated
    public void setRecyclerListener(@Nullable RecyclerListener r10) {
        this.mRecyclerListener = r10;
    }

    public void setScrollState(int r10) {
        if (r10 != this.mScrollState) goto L6;
        return;
    L6:
        if (sVerboseLoggingEnabled == false) goto L8;
        Log.d(TAG, "setting scroll state to " + r10 + " from " + this.mScrollState, new Exception());
    L8:
        this.mScrollState = r10;
        if (r10 == 2) goto L11;
        K();
    L11:
        dispatchOnScrollStateChanged(r10);
    }

    public void setScrollingTouchSlop(int r10) {
        ViewConfiguration r11 = ViewConfiguration.get(getContext());
        if (r10 != 0) goto L5;
    L8:
        this.mTouchSlop = r11.getScaledTouchSlop();
        return;
    L5:
        if (r10 == 1) goto L7;
        Log.w(TAG, "setScrollingTouchSlop(): bad argument constant " + r10 + "; using default value");
        goto L8
    L7:
        this.mTouchSlop = r11.getScaledPagingTouchSlop();
    }

    public void setViewCacheExtension(@Nullable ViewCacheExtension r10) {
        this.mRecycler.K(r10);
    }

    public boolean shouldDeferAccessibilityEvent(AccessibilityEvent r10) {
        int r11 = 0;
        if (isComputingLayout() == false) goto L12;
        if (r10 == null) goto L6;
        int r12 = AccessibilityEventCompat.a(r10);
    L7:
        if (r12 == 0) goto L10;
        r11 = r12;
    L10:
        this.mEatenAccessibilityChangeFlags |= r11;
        return true;
    L6:
        r12 = 0;
        goto L7
    L12:
        return false;
    }

    public void smoothScrollBy(@Px int r10, @Px int r11) {
        smoothScrollBy(r10, r11, null);
    }

    public void smoothScrollToPosition(int r10) {
        if (this.mLayoutSuppressed == false) goto L5;
        return;
    L5:
        LayoutManager r11 = this.mLayout;
        if (r11 != null) goto L9;
        Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L9:
        r11.smoothScrollToPosition(this, this.mState, r10);
    }

    public void startInterceptRequestLayout() {
        int r10 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = r10;
        if (r10 == 1) goto L5;
        return;
    L5:
        if (this.mLayoutSuppressed == true) goto L9;
        this.mLayoutWasDefered = false;
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int r10) {
        return getScrollingChildHelper().p(r10);
    }

    public void stopInterceptRequestLayout(boolean r10) {
        if (this.mInterceptRequestLayoutDepth >= 1) goto L10;
        if (sDebugAssertionsEnabled == true) goto L8;
        this.mInterceptRequestLayoutDepth = 1;
        goto L10
    L8:
        throw new IllegalStateException("stopInterceptRequestLayout was called more times than startInterceptRequestLayout." + exceptionLabel());
    L10:
        if (r10 == true) goto L15;
        if (this.mLayoutSuppressed == true) goto L15;
        this.mLayoutWasDefered = false;
    L15:
        if (this.mInterceptRequestLayoutDepth != 1) goto L29;
        if (r10 == false) goto L27;
        if (this.mLayoutWasDefered == false) goto L27;
        if (this.mLayoutSuppressed == true) goto L27;
        if (this.mLayout == null) goto L27;
        if (this.mAdapter == null) goto L27;
        dispatchLayout();
    L27:
        if (this.mLayoutSuppressed == true) goto L29;
        this.mLayoutWasDefered = false;
    L29:
        this.mInterceptRequestLayoutDepth--;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        getScrollingChildHelper().r();
    }

    public void stopScroll() {
        setScrollState(0);
        K();
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
        long r11 = SystemClock.uptimeMillis();
        onTouchEvent(MotionEvent.obtain(r11, r11, 3, 0.0f, 0.0f, 0));
        this.mLayoutSuppressed = true;
        this.mIgnoreMotionEventTillDown = true;
        stopScroll();
        return;
    }

    public void swapAdapter(@Nullable Adapter r10, boolean r11) {
        setLayoutFrozen(false);
        H(r10, true, r11);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public final void t() {
        this.mChildHelper = new ChildHelper(new e(this));
    }

    public final boolean u(View r10, View r11, int r12) {
        if (r11 == null) goto L89;
        if (r11 == this) goto L90;
        if (r11 != r10) goto L8;
        return false;
    L8:
        if (findContainingItemView(r11) != null) goto L11;
        return false;
    L11:
        if (r10 != null) goto L14;
        return true;
    L14:
        if (findContainingItemView(r10) != null) goto L16;
        return true;
    L16:
        this.mTempRect.set(0, 0, r10.getWidth(), r10.getHeight());
        this.mTempRect2.set(0, 0, r11.getWidth(), r11.getHeight());
        offsetDescendantRectToMyCoords(r10, this.mTempRect);
        offsetDescendantRectToMyCoords(r11, this.mTempRect2);
        byte r13 = -1;
        if (this.mLayout.getLayoutDirection() != 1) goto L19;
        int r14 = -1;
    L20:
        Rect r15 = this.mTempRect;
        int r16 = r15.left;
        Rect r17 = this.mTempRect2;
        int r18 = r17.left;
        if (r16 < r18) goto L25;
        if (r15.right <= r18) goto L25;
    L27:
        int r19 = r15.right;
        int r20 = r17.right;
        if (r19 > r20) goto L30;
        if (r16 >= r20) goto L30;
    L32:
        int r21 = 0;
    L33:
        int r22 = r15.top;
        int r23 = r17.top;
        if (r22 < r23) goto L38;
        if (r15.bottom <= r23) goto L38;
    L40:
        int r24 = r15.bottom;
        int r25 = r17.bottom;
        if (r24 > r25) goto L43;
        if (r22 >= r25) goto L43;
    L45:
        r13 = 0;
    L46:
        if (r12 != 1) goto L48;
        if (r13 < 0) goto L82;
        if (r13 == 0) goto L80;
        return false;
    L80:
        if ((r21 * r14) < 0) goto L82;
        return false;
    L82:
        return true;
    L48:
        if (r12 != 2) goto L50;
        if (r13 > 0) goto L76;
        if (r13 == 0) goto L74;
        return false;
    L74:
        if ((r21 * r14) > 0) goto L76;
        return false;
    L76:
        return true;
    L50:
        if (r12 != 17) goto L52;
        if (r21 < 0) goto L70;
        return false;
    L70:
        return true;
    L52:
        if (r12 != 33) goto L54;
        if (r13 < 0) goto L67;
        return false;
    L67:
        return true;
    L54:
        if (r12 != 66) goto L56;
        if (r21 > 0) goto L64;
        return false;
    L64:
        return true;
    L56:
        if (r12 != 130) goto L61;
        if (r13 > 0) goto L59;
        return false;
    L59:
        return true;
    L61:
        throw new IllegalArgumentException("Invalid direction: " + r12 + exceptionLabel());
    L43:
        if (r22 <= r23) goto L45;
    L38:
        if (r15.bottom >= r17.bottom) goto L40;
        r13 = 1;
    L30:
        if (r16 <= r18) goto L32;
        r21 = -1;
    L25:
        if (r15.right >= r17.right) goto L27;
        r21 = 1;
        goto L33
    L19:
        r14 = 1;
        goto L20
    L90:
        return false;
    L89:
        return false;
    }

    public final void v(int r12, int r13, MotionEvent r14, int r15) {
        LayoutManager r10 = this.mLayout;
        if (r10 != null) goto L7;
        Log.e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return;
    L9:
        int[] r11 = this.mReusableIntPair;
        int r16 = 0;
        r11[0] = 0;
        r11[1] = 0;
        boolean r17 = r10.canScrollHorizontally();
        boolean r18 = this.mLayout.canScrollVertically();
        if (r18 == false) goto L12;
        int r19 = (r17 ? 1 : 0) | 2;
    L14:
        if (r14 != null) goto L16;
        float r20 = getHeight() / 2.0f;
    L17:
        if (r14 != null) goto L19;
        float r21 = getWidth() / 2.0f;
    L20:
        int r110 = r12 - B(r12, r20);
        int r111 = r13 - C(r13, r21);
        startNestedScroll(r19, r15);
        if (r17 == false) goto L23;
        int r22 = r110;
    L24:
        if (r18 == false) goto L26;
        int r23 = r111;
    L28:
        if (dispatchNestedPreScroll(r22, r23, this.mReusableIntPair, this.mScrollOffset, r15) == false) goto L30;
        int[] r24 = this.mReusableIntPair;
        r110 = r110 - r24[0];
        r111 = r111 - r24[1];
    L30:
        if (r17 == false) goto L32;
        int r25 = r110;
    L33:
        if (r18 == false) goto L35;
        r16 = r111;
    L35:
        scrollByInternal(r25, r16, r14, r15);
        GapWorker r112 = this.mGapWorker;
        if (r112 == null) goto L40;
        if (r110 != 0) goto L39;
        if (r111 == 0) goto L40;
    L39:
        r112.f(this, r110, r111);
    L40:
        stopNestedScroll(r15);
        return;
    L32:
        r25 = 0;
        goto L33
    L26:
        r23 = 0;
        goto L28
    L23:
        r22 = 0;
        goto L24
    L19:
        r21 = r14.getX();
        goto L20
    L16:
        r20 = r14.getY();
        goto L17
    L12:
        r19 = r17 ? 1 : 0;
        goto L14
    }

    public void viewRangeUpdate(int r10, int r11, Object r12) {
        int r13 = this.mChildHelper.getUnfilteredChildCount();
        int r14 = r10 + r11;
        int r15 = 0;
    L3:
        if (r15 >= r13) goto L14;
        View r16 = this.mChildHelper.getUnfilteredChildAt(r15);
        ViewHolder r17 = getChildViewHolderInt(r16);
        if (r17 == null) goto L13;
        if (r17.shouldIgnore() == true) goto L13;
        int r18 = r17.mPosition;
        if (r18 < r10) goto L13;
        if (r18 >= r14) goto L13;
        r17.addFlags(2);
        r17.addChangePayload(r12);
        ((LayoutParams) r16.getLayoutParams()).mInsetsDirty = true;
    L13:
        r15 = r15 + 1;
        goto L3
    L14:
        this.mRecycler.R(r10, r11);
    }

    public final boolean w() {
        if (this.mItemAnimator != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mLayout.supportsPredictiveItemAnimations() == false) goto L7;
        return true;
    }

    public final void x() {
        if (this.mDataSetHasChangedAfterLayout == false) goto L8;
        this.mAdapterHelper.w();
        if (this.mDispatchItemsChangedEvent == false) goto L8;
        this.mLayout.onItemsChanged(this);
    L8:
        if (w() == false) goto L10;
        this.mAdapterHelper.u();
    L11:
        boolean r10 = true;
        if (this.mItemsAddedOrRemoved == false) goto L14;
    L17:
        boolean r11 = true;
    L18:
        State r12 = this.mState;
        if (this.mFirstLayoutComplete == true) goto L21;
    L31:
        boolean r13 = false;
    L32:
        r12.f4234k = r13;
        State r14 = this.mState;
        if (r14.f4234k == false) goto L40;
        if (r11 == false) goto L40;
        if (this.mDataSetHasChangedAfterLayout == true) goto L40;
        if (w() == false) goto L40;
    L41:
        r14.f4235l = r10;
        return;
    L40:
        r10 = false;
        goto L41
    L21:
        if (this.mItemAnimator == null) goto L31;
        boolean r15 = this.mDataSetHasChangedAfterLayout;
        if (r15 == true) goto L27;
        if (r11 == true) goto L27;
        if (this.mLayout.mRequestedSimpleAnimations == false) goto L31;
    L27:
        if (r15 == true) goto L29;
    L30:
        r13 = true;
        goto L32
    L29:
        if (this.mAdapter.hasStableIds() == false) goto L31;
    L14:
        if (this.mItemsChanged == true) goto L17;
        r11 = false;
        goto L18
    L10:
        this.mAdapterHelper.h();
        goto L11
    }

    public final void y(float r10, float r11, float r12, float r13) {
        boolean r14 = true;
        if (r11 == 0.0f) goto L5;
        ensureHorizontalGlow();
        this.mHorizontalEdgeEffect.f(r11, false, false);
        boolean r15 = true;
    L7:
        if (r13 == 0.0f) goto L9;
        ensureVerticalGlow();
        this.mVerticalEdgeEffect.f(r13, false, false);
    L10:
        if (r14 == true) goto L13;
        if (r11 != 0.0f) goto L13;
        if (r13 != 0.0f) goto L13;
        return;
    L13:
        ViewCompat.g0(this);
        return;
    L9:
        r14 = r15;
        goto L10
    L5:
        r15 = false;
        goto L7
    }

    public final void z() {
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
        View r10 = getFocusedChild();
        if (IGNORE_DETACHED_FOCUSED_CHILD == false) goto L28;
        if (r10.getParent() == null) goto L24;
        if (r10.hasFocus() == true) goto L28;
    L24:
        if (this.mChildHelper.getChildCount() != 0) goto L30;
        requestFocus();
        return;
    L28:
        if (this.mChildHelper.isHidden(r10) == true) goto L30;
        return;
    L30:
        View r11 = null;
        if (this.mState.f4237n != (-1)) goto L33;
    L35:
        ViewHolder r12 = null;
    L36:
        if (r12 == null) goto L44;
        if (this.mChildHelper.isHidden(r12.itemView) == true) goto L44;
        if (r12.itemView.hasFocusable() == false) goto L44;
        r11 = r12.itemView;
    L46:
        if (r11 == null) goto L60;
        int r13 = this.mState.f4238o;
        if (r13 == (-1)) goto L54;
        View r14 = r11.findViewById(r13);
        if (r14 == null) goto L54;
        if (r14.isFocusable() == false) goto L54;
        r11 = r14;
    L54:
        r11.requestFocus();
        return;
    L60:
        return;
    L44:
        if (this.mChildHelper.getChildCount() <= 0) goto L46;
        r11 = n();
        goto L46
    L33:
        if (this.mAdapter.hasStableIds() == false) goto L35;
        r12 = findViewHolderForItemId(this.mState.f4237n);
        goto L36
    }

    public RecyclerView(@NonNull Context r10, @Nullable AttributeSet r11) {
        this(r10, r11, R$attr.recyclerViewStyle);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int r10, int r11, int[] r12, int[] r13, int r14) {
        return getScrollingChildHelper().d(r10, r11, r12, r13, r14);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14, int r15) {
        return getScrollingChildHelper().g(r10, r11, r12, r13, r14, r15);
    }

    @Nullable
    public ViewHolder findViewHolderForPosition(int r10, boolean r11) {
        int r12 = this.mChildHelper.getUnfilteredChildCount();
        ViewHolder r13 = null;
        int r14 = 0;
    L3:
        if (r14 >= r12) goto L20;
        ViewHolder r15 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r14));
        if (r15 == null) goto L19;
        if (r15.isRemoved() == true) goto L19;
        if (r11 == false) goto L13;
        if (r15.mPosition != r10) goto L19;
    L16:
        if (this.mChildHelper.isHidden(r15.itemView) == false) goto L18;
        r13 = r15;
        goto L19
    L18:
        return r15;
    L13:
        if (r15.getLayoutPosition() == r10) goto L16;
    L19:
        r14 = r14 + 1;
        goto L3
    L20:
        return r13;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int r10) {
        return getScrollingChildHelper().l(r10);
    }

    public void onExitLayoutOrScroll(boolean r10) {
        int r11 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = r11;
        if (r11 < 1) goto L5;
        return;
    L5:
        if (sDebugAssertionsEnabled == false) goto L10;
        if (r11 >= 0) goto L10;
        throw new IllegalStateException("layout or scroll counter cannot go below zero.Some calls are not matching" + exceptionLabel());
    L10:
        this.mLayoutOrScrollCounter = 0;
        if (r10 == false) goto L15;
        g();
        dispatchPendingImportantForAccessibilityChanges();
        return;
    }

    public void smoothScrollBy(@Px int r10, @Px int r11, @Nullable Interpolator r12) {
        smoothScrollBy(r10, r11, r12, Integer.MIN_VALUE);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int r10, int r11) {
        return getScrollingChildHelper().q(r10, r11);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int r10) {
        getScrollingChildHelper().s(r10);
    }

    public RecyclerView(@NonNull Context r16, @Nullable AttributeSet r17, int r18) {
        super(r16, r17, r18);
        this.mObserver = new RecyclerViewDataObserver(this);
        this.mRecycler = new Recycler(this);
        this.mViewInfoStore = new ViewInfoStore();
        this.mUpdateChildViewsRunnable = new a(this);
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
        this.mItemAnimator = new androidx.recyclerview.widget.d();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new ViewFlinger(this);
        if (ALLOW_THREAD_GAP_WORK == false) goto L5;
        GapWorker.LayoutPrefetchRegistryImpl r10 = new GapWorker.LayoutPrefetchRegistryImpl();
    L6:
        this.mPrefetchRegistry = r10;
        this.mState = new State();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new h(this);
        this.mPostedAnimatorRunner = false;
        this.mMinMaxLayoutPositions = new int[2];
        this.mScrollOffset = new int[2];
        this.mNestedOffsets = new int[2];
        this.mReusableIntPair = new int[2];
        this.mPendingAccessibilityImportanceChange = new ArrayList();
        this.mEnableOverFling = true;
        this.mAvoidStateChangeInAnim = true;
        this.mItemAnimatorRunner = new b(this);
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mViewInfoProcessCallback = new d(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration r11 = ViewConfiguration.get(r16);
        this.mTouchSlop = r11.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = androidx.core.view.n.a(r11, r16);
        this.mScaledVerticalScrollFactor = androidx.core.view.n.b(r11, r16);
        this.mMinFlingVelocity = r11.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = r11.getScaledMaximumFlingVelocity();
        this.mPhysicalCoef = ((r16.getResources().getDisplayMetrics().density * 160.0f) * 386.0878f) * 0.84f;
        if (getOverScrollMode() != 2) goto L9;
        boolean r12 = true;
    L10:
        setWillNotDraw(r12);
        this.mItemAnimator.y(this.mItemAnimatorListener);
        initAdapterManager();
        t();
        s();
        if (ViewCompat.y(this) != 0) goto L13;
        ViewCompat.A0(this, 1);
    L13:
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        int[] r13 = R$styleable.RecyclerView;
        TypedArray r14 = r16.obtainStyledAttributes(r17, r13, r18, 0);
        ViewCompat.n0(this, r16, r13, r17, r14, r18, 0);
        String r15 = r14.getString(R$styleable.RecyclerView_layoutManager);
        if (r14.getInt(R$styleable.RecyclerView_android_descendantFocusability, -1) != (-1)) goto L16;
        setDescendantFocusability(UiType.FLAG_TIMER_CARD);
    L16:
        this.mClipToPadding = r14.getBoolean(R$styleable.RecyclerView_android_clipToPadding, true);
        boolean r19 = r14.getBoolean(R$styleable.RecyclerView_fastScrollEnabled, false);
        this.mEnableFastScroller = r19;
        if (r19 == false) goto L19;
        initFastScroller((StateListDrawable) r14.getDrawable(R$styleable.RecyclerView_fastScrollVerticalThumbDrawable), r14.getDrawable(R$styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) r14.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalThumbDrawable), r14.getDrawable(R$styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
    L19:
        r14.recycle();
        e(r16, r15, r17, r18, 0);
        int[] r20 = NESTED_SCROLLING_ATTRS;
        TypedArray r110 = r16.obtainStyledAttributes(r17, r20, r18, 0);
        ViewCompat.n0(this, r16, r20, r17, r110, r18, 0);
        boolean r21 = r110.getBoolean(0, true);
        r110.recycle();
        setNestedScrollingEnabled(r21);
        t.a.d(this, true);
        this.mRecyclerViewExt = new RecyclerViewExt(this);
        return;
    L9:
        r12 = false;
        goto L10
    L5:
        r10 = null;
        goto L6
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public final void dispatchNestedScroll(int r10, int r11, int r12, int r13, int[] r14, int r15, @NonNull int[] r16) {
        getScrollingChildHelper().e(r10, r11, r12, r13, r14, r15, r16);
    }

    public void smoothScrollBy(@Px int r10, @Px int r11, @Nullable Interpolator r12, int r13) {
        smoothScrollBy(r10, r11, r12, r13, false);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        LayoutManager r11 = this.mLayout;
        if (r11 == null) goto L7;
        return r11.generateLayoutParams(r10);
    L7:
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    public void smoothScrollBy(@Px int r10, @Px int r11, @Nullable Interpolator r12, int r13, boolean r14) {
        LayoutManager r15 = this.mLayout;
        if (r15 != null) goto L7;
        Log.e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return;
    L9:
        int r16 = 0;
        if (r15.canScrollHorizontally() == true) goto L13;
        r10 = 0;
    L13:
        if (this.mLayout.canScrollVertically() == true) goto L15;
        r11 = 0;
    L15:
        if (r10 != 0) goto L18;
        if (r11 != 0) goto L18;
        return;
    L18:
        if (r13 == Integer.MIN_VALUE) goto L22;
        if (r13 > 0) goto L22;
        scrollBy(r10, r11);
        return;
    L22:
        if (r14 == true) goto L24;
    L29:
        this.mViewFlinger.e(r10, r11, r13, r12);
        return;
    L24:
        if (r10 == 0) goto L26;
        r16 = 1;
    L26:
        if (r11 == 0) goto L28;
        r16 = r16 | 2;
    L28:
        startNestedScroll(r16, 1);
        goto L29
    }

    public void addItemDecoration(@NonNull ItemDecoration r10) {
        addItemDecoration(r10, -1);
    }
}
