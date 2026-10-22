package androidx.recyclerview.widget;

import android.R;
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
import androidx.core.os.TraceCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ScrollingView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.EdgeEffectCompat;
import androidx.customview.view.AbsSavedState;
import com.alipay.sdk.m.u.i;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public class RecyclerView extends ViewGroup implements ScrollingView, NestedScrollingChild2, NestedScrollingChild3 {
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
    RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
    private final AccessibilityManager mAccessibilityManager;
    Adapter mAdapter;
    AdapterHelper mAdapterHelper;
    boolean mAdapterUpdateDuringMeasure;
    private EdgeEffect mBottomGlow;
    private ChildDrawingOrderCallback mChildDrawingOrderCallback;
    ChildHelper mChildHelper;
    boolean mClipToPadding;
    boolean mDataSetHasChangedAfterLayout;
    boolean mDispatchItemsChangedEvent;
    private int mDispatchScrollCounter;
    private int mEatenAccessibilityChangeFlags;
    private EdgeEffectFactory mEdgeEffectFactory;
    boolean mEnableFastScroller;
    boolean mFirstLayoutComplete;
    GapWorker mGapWorker;
    boolean mHasFixedSize;
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
    LayoutManager mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private EdgeEffect mLeftGlow;
    private final int mMaxFlingVelocity;
    private final int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final RecyclerViewDataObserver mObserver;
    private List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
    private OnFlingListener mOnFlingListener;
    private final ArrayList<OnItemTouchListener> mOnItemTouchListeners;
    final List<ViewHolder> mPendingAccessibilityImportanceChange;
    SavedState mPendingSavedState;
    boolean mPostedAnimatorRunner;
    GapWorker.LayoutPrefetchRegistryImpl mPrefetchRegistry;
    private boolean mPreserveFocusAfterLayout;
    final Recycler mRecycler;
    RecyclerListener mRecyclerListener;
    final List<RecyclerListener> mRecyclerListeners;
    final int[] mReusableIntPair;
    private EdgeEffect mRightGlow;
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
    private EdgeEffect mTopGlow;
    private int mTouchSlop;
    final Runnable mUpdateChildViewsRunnable;
    private VelocityTracker mVelocityTracker;
    final ViewFlinger mViewFlinger;
    private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
    final ViewInfoStore mViewInfoStore;

    /* JADX INFO: renamed from: androidx.recyclerview.widget.RecyclerView$7, reason: invalid class name */
    /* JADX INFO: loaded from: classes17.dex */
    public static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$androidx$recyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy = null;

        static {
            int[] r100 = new int[Adapter.StateRestorationPolicy.values().length];
            $SwitchMap$androidx$recyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy = r100;
            r100[Adapter.StateRestorationPolicy.PREVENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$androidx$recyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy[Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static abstract class Adapter<VH extends ViewHolder> {
        private boolean mHasStableIds;
        private final AdapterDataObservable mObservable;
        private StateRestorationPolicy mStateRestorationPolicy;

        public static final enum StateRestorationPolicy extends Enum<StateRestorationPolicy> {
            private static final /* synthetic */ StateRestorationPolicy[] $VALUES = null;
            public static final StateRestorationPolicy ALLOW = null;
            public static final StateRestorationPolicy PREVENT = null;
            public static final StateRestorationPolicy PREVENT_WHEN_EMPTY = null;

            static {
                StateRestorationPolicy r100 = new StateRestorationPolicy("ALLOW", 0);
                ALLOW = r100;
                StateRestorationPolicy r101 = new StateRestorationPolicy("PREVENT_WHEN_EMPTY", 1);
                PREVENT_WHEN_EMPTY = r101;
                StateRestorationPolicy r102 = new StateRestorationPolicy("PREVENT", 2);
                PREVENT = r102;
                $VALUES = new StateRestorationPolicy[]{r100, r101, r102};
            }

            public static StateRestorationPolicy[] values() {
                return (StateRestorationPolicy[]) $VALUES.clone();
            }

            public static StateRestorationPolicy valueOf(String r100) {
                return (StateRestorationPolicy) a.a(StateRestorationPolicy.class, r100);
            }

            private StateRestorationPolicy(String r100, int r101) {
                super(r100, r101);
            }
        }

        public int findRelativeAdapterPositionIn(Adapter<? extends ViewHolder> r100, ViewHolder r101, int r102) {
            if (r100 != this) goto L4;
            return r102;
        L4:
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int r100) {
            return -1;
        }

        public int getItemViewType(int r100) {
            return 0;
        }

        public void onAttachedToRecyclerView(RecyclerView r100) {
        }

        public abstract void onBindViewHolder(VH r100, int r101);

        public abstract VH onCreateViewHolder(ViewGroup r100, int r101);

        public void onDetachedFromRecyclerView(RecyclerView r100) {
        }

        public boolean onFailedToRecycleView(VH r100) {
            return false;
        }

        public void onViewAttachedToWindow(VH r100) {
        }

        public void onViewDetachedFromWindow(VH r100) {
        }

        public void onViewRecycled(VH r100) {
        }

        public boolean canRestoreState() {
            int r100 = AnonymousClass7.$SwitchMap$androidx$recyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy[this.mStateRestorationPolicy.ordinal()];
            if (r100 != 1) goto L5;
            return false;
        L5:
            if (r100 == 2) goto L8;
            return true;
        L8:
            if (getItemCount() <= 0) goto L12;
            return true;
        L12:
            return false;
        }

        public final boolean hasObservers() {
            return this.mObservable.hasObservers();
        }

        public final void notifyDataSetChanged() {
            this.mObservable.notifyChanged();
        }

        public Adapter() {
            this.mObservable = new AdapterDataObservable();
            this.mHasStableIds = false;
            this.mStateRestorationPolicy = StateRestorationPolicy.ALLOW;
        }

        public final StateRestorationPolicy getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyItemChanged(int r100) {
            this.mObservable.notifyItemRangeChanged(r100, 1);
        }

        public final void notifyItemInserted(int r100) {
            this.mObservable.notifyItemRangeInserted(r100, 1);
        }

        public final void notifyItemRemoved(int r100) {
            this.mObservable.notifyItemRangeRemoved(r100, 1);
        }

        public void registerAdapterDataObserver(AdapterDataObserver r100) {
            this.mObservable.registerObserver(r100);
        }

        public void setHasStableIds(boolean r100) {
            if (hasObservers() == true) goto L7;
            this.mHasStableIds = r100;
            return;
        L7:
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void setStateRestorationPolicy(StateRestorationPolicy r100) {
            this.mStateRestorationPolicy = r100;
            this.mObservable.notifyStateRestorationPolicyChanged();
        }

        public void unregisterAdapterDataObserver(AdapterDataObserver r100) {
            this.mObservable.unregisterObserver(r100);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void bindViewHolder(VH r100, int r101) {
            if (r100.mBindingAdapter != null) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L11;
            r100.mPosition = r101;
            if (hasStableIds() == false) goto L10;
            r100.mItemId = getItemId(r101);
        L10:
            r100.setFlags(1, 519);
            TraceCompat.beginSection(RecyclerView.TRACE_BIND_VIEW_TAG);
        L11:
            r100.mBindingAdapter = this;
            onBindViewHolder(r100, r101, r100.getUnmodifiedPayloads());
            if (r102 == false) goto L18;
            r100.clearPayload();
            ViewGroup.LayoutParams r103 = r100.itemView.getLayoutParams();
            if ((r103 instanceof LayoutParams) == false) goto L16;
            ((LayoutParams) r103).mInsetsDirty = true;
        L16:
            TraceCompat.endSection();
            return;
        L18:
            return;
        L5:
            r102 = false;
            goto L6
        }

        public final VH createViewHolder(ViewGroup r100, int r101) {
            TraceCompat.beginSection(RecyclerView.TRACE_CREATE_VIEW_TAG);     // Catch: Throwable -> L9
            VH r102 = (VH) onCreateViewHolder(r100, r101);
            if (r102.itemView.getParent() != null) goto L8;
            r102.mItemViewType = r101;     // Catch: Throwable -> L9
            TraceCompat.endSection();
            return r102;
        L8:
            throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            TraceCompat.endSection();
            throw th;
        }

        public final void notifyItemChanged(int r100, Object r101) {
            this.mObservable.notifyItemRangeChanged(r100, 1, r101);
        }

        public final void notifyItemMoved(int r100, int r101) {
            this.mObservable.notifyItemMoved(r100, r101);
        }

        public final void notifyItemRangeChanged(int r100, int r101) {
            this.mObservable.notifyItemRangeChanged(r100, r101);
        }

        public final void notifyItemRangeInserted(int r100, int r101) {
            this.mObservable.notifyItemRangeInserted(r100, r101);
        }

        public final void notifyItemRangeRemoved(int r100, int r101) {
            this.mObservable.notifyItemRangeRemoved(r100, r101);
        }

        public final void notifyItemRangeChanged(int r100, int r101, Object r102) {
            this.mObservable.notifyItemRangeChanged(r100, r101, r102);
        }

        public void onBindViewHolder(VH r100, int r101, List<Object> r102) {
            onBindViewHolder(r100, r101);
        }
    }

    public static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        public boolean hasObservers() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void notifyChanged() {
            int r100 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r100 < 0) goto L5;
            ((AdapterDataObserver) ListProtector.get(((Observable) this).mObservers, r100)).onChanged();
            r100 = r100 - 1;
            goto L3
        }

        public void notifyStateRestorationPolicyChanged() {
            int r100 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r100 < 0) goto L5;
            ((AdapterDataObserver) ListProtector.get(((Observable) this).mObservers, r100)).onStateRestorationPolicyChanged();
            r100 = r100 - 1;
            goto L3
        }

        public AdapterDataObservable() {
        }

        public void notifyItemMoved(int r100, int r101) {
            int r102 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r102 < 0) goto L5;
            ((AdapterDataObserver) ListProtector.get(((Observable) this).mObservers, r102)).onItemRangeMoved(r100, r101, 1);
            r102 = r102 - 1;
            goto L3
        }

        public void notifyItemRangeChanged(int r100, int r101) {
            notifyItemRangeChanged(r100, r101, null);
        }

        public void notifyItemRangeInserted(int r100, int r101) {
            int r102 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r102 < 0) goto L5;
            ((AdapterDataObserver) ListProtector.get(((Observable) this).mObservers, r102)).onItemRangeInserted(r100, r101);
            r102 = r102 - 1;
            goto L3
        }

        public void notifyItemRangeRemoved(int r100, int r101) {
            int r102 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r102 < 0) goto L5;
            ((AdapterDataObserver) ListProtector.get(((Observable) this).mObservers, r102)).onItemRangeRemoved(r100, r101);
            r102 = r102 - 1;
            goto L3
        }

        public void notifyItemRangeChanged(int r100, int r101, Object r102) {
            int r103 = ((Observable) this).mObservers.size() - 1;
        L3:
            if (r103 < 0) goto L5;
            ((AdapterDataObserver) ListProtector.get(((Observable) this).mObservers, r103)).onItemRangeChanged(r100, r101, r102);
            r103 = r103 - 1;
            goto L3
        }
    }

    public static abstract class AdapterDataObserver {
        public AdapterDataObserver() {
        }

        public void onChanged() {
        }

        public void onItemRangeChanged(int r100, int r101) {
        }

        public void onItemRangeInserted(int r100, int r101) {
        }

        public void onItemRangeMoved(int r100, int r101, int r102) {
        }

        public void onItemRangeRemoved(int r100, int r101) {
        }

        public void onStateRestorationPolicyChanged() {
        }

        public void onItemRangeChanged(int r100, int r101, Object r102) {
            onItemRangeChanged(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public interface ChildDrawingOrderCallback {
        int onGetChildDrawingOrder(int r100, int r101);
    }

    public static class EdgeEffectFactory {
        public static final int DIRECTION_BOTTOM = 3;
        public static final int DIRECTION_LEFT = 0;
        public static final int DIRECTION_RIGHT = 2;
        public static final int DIRECTION_TOP = 1;

        /* JADX INFO: loaded from: classes17.dex */
        @Retention(RetentionPolicy.SOURCE)
        public @interface EdgeDirection {
        }

        public EdgeEffectFactory() {
        }

        public EdgeEffect createEdgeEffect(RecyclerView r100, int r101) {
            return new EdgeEffect(r100.getContext());
        }
    }

    public static abstract class ItemAnimator {
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_CHANGED = 2;
        public static final int FLAG_INVALIDATED = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_REMOVED = 8;
        private long mAddDuration;
        private long mChangeDuration;
        private ArrayList<ItemAnimatorFinishedListener> mFinishedListeners;
        private ItemAnimatorListener mListener;
        private long mMoveDuration;
        private long mRemoveDuration;

        /* JADX INFO: loaded from: classes17.dex */
        @Retention(RetentionPolicy.SOURCE)
        public @interface AdapterChanges {
        }

        /* JADX INFO: loaded from: classes17.dex */
        public interface ItemAnimatorFinishedListener {
            void onAnimationsFinished();
        }

        public interface ItemAnimatorListener {
            void onAnimationFinished(ViewHolder r100);
        }

        /* JADX INFO: loaded from: classes17.dex */
        public static class ItemHolderInfo {
            public int bottom;
            public int changeFlags;
            public int left;
            public int right;
            public int top;

            public ItemHolderInfo() {
            }

            public ItemHolderInfo setFrom(ViewHolder r100) {
                return setFrom(r100, 0);
            }

            public ItemHolderInfo setFrom(ViewHolder r100, int r101) {
                View r102 = r100.itemView;
                this.left = r102.getLeft();
                this.top = r102.getTop();
                this.right = r102.getRight();
                this.bottom = r102.getBottom();
                return this;
            }
        }

        public abstract boolean animateAppearance(ViewHolder r100, ItemHolderInfo r101, ItemHolderInfo r102);

        public abstract boolean animateChange(ViewHolder r100, ViewHolder r101, ItemHolderInfo r102, ItemHolderInfo r103);

        public abstract boolean animateDisappearance(ViewHolder r100, ItemHolderInfo r101, ItemHolderInfo r102);

        public abstract boolean animatePersistence(ViewHolder r100, ItemHolderInfo r101, ItemHolderInfo r102);

        public boolean canReuseUpdatedViewHolder(ViewHolder r100) {
            return true;
        }

        public abstract void endAnimation(ViewHolder r100);

        public abstract void endAnimations();

        public abstract boolean isRunning();

        public void onAnimationFinished(ViewHolder r100) {
        }

        public void onAnimationStarted(ViewHolder r100) {
        }

        public abstract void runPendingAnimations();

        public final void dispatchAnimationsFinished() {
            int r100 = this.mFinishedListeners.size();
            int r101 = 0;
        L3:
            if (r101 >= r100) goto L5;
            ((ItemAnimatorFinishedListener) ListProtector.get(this.mFinishedListeners, r101)).onAnimationsFinished();
            r101 = r101 + 1;
            goto L3
        L5:
            this.mFinishedListeners.clear();
        }

        public ItemHolderInfo obtainHolderInfo() {
            return new ItemHolderInfo();
        }

        public ItemAnimator() {
            this.mListener = null;
            this.mFinishedListeners = new ArrayList();
            this.mAddDuration = 120;
            this.mRemoveDuration = 120;
            this.mMoveDuration = 250;
            this.mChangeDuration = 250;
        }

        public long getAddDuration() {
            return this.mAddDuration;
        }

        public long getChangeDuration() {
            return this.mChangeDuration;
        }

        public long getMoveDuration() {
            return this.mMoveDuration;
        }

        public long getRemoveDuration() {
            return this.mRemoveDuration;
        }

        public static int buildAdapterChangeFlagsForAnimations(ViewHolder r100) {
            int r101 = r100.mFlags & 14;
            if (r100.isInvalid() == false) goto L7;
            return 4;
        L7:
            if ((r101 & 4) != 0) goto L14;
            int r102 = r100.getOldPosition();
            int r103 = r100.getAbsoluteAdapterPosition();
            if (r102 == (-1)) goto L15;
            if (r103 == (-1)) goto L16;
            if (r102 != r103) goto L13;
            return r101;
        L13:
            return r101 | 2048;
        L16:
            return r101;
        L15:
            return r101;
        L14:
            return r101;
        }

        public final void dispatchAnimationFinished(ViewHolder r100) {
            onAnimationFinished(r100);
            ItemAnimatorListener r101 = this.mListener;
            if (r101 == null) goto L6;
            r101.onAnimationFinished(r100);
            return;
        }

        public final void dispatchAnimationStarted(ViewHolder r100) {
            onAnimationStarted(r100);
        }

        public final boolean isRunning(ItemAnimatorFinishedListener r100) {
            boolean r101 = isRunning();
            if (r100 == null) goto L7;
            if (r101 == true) goto L6;
            r100.onAnimationsFinished();
            goto L7
        L6:
            this.mFinishedListeners.add(r100);
        L7:
            return r101;
        }

        public void setAddDuration(long r100) {
            this.mAddDuration = r100;
        }

        public void setChangeDuration(long r100) {
            this.mChangeDuration = r100;
        }

        public void setListener(ItemAnimatorListener r100) {
            this.mListener = r100;
        }

        public void setMoveDuration(long r100) {
            this.mMoveDuration = r100;
        }

        public void setRemoveDuration(long r100) {
            this.mRemoveDuration = r100;
        }

        public boolean canReuseUpdatedViewHolder(ViewHolder r100, List<Object> r101) {
            return canReuseUpdatedViewHolder(r100);
        }

        public ItemHolderInfo recordPostLayoutInformation(State r100, ViewHolder r101) {
            return obtainHolderInfo().setFrom(r101);
        }

        public ItemHolderInfo recordPreLayoutInformation(State r100, ViewHolder r101, int r102, List<Object> r103) {
            return obtainHolderInfo().setFrom(r101);
        }
    }

    public class ItemAnimatorRestoreListener implements ItemAnimator.ItemAnimatorListener {
        final /* synthetic */ RecyclerView this$0;

        public ItemAnimatorRestoreListener(RecyclerView r100) {
            this.this$0 = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemAnimatorListener
        public void onAnimationFinished(ViewHolder r100) {
            r100.setIsRecyclable(true);
            if (r100.mShadowedHolder != null) goto L5;
        L7:
            r100.mShadowingHolder = null;
            if (r100.shouldBeKeptAsChild() == false) goto L10;
            return;
        L10:
            if (this.this$0.removeAnimatingView(r100.itemView) == false) goto L12;
            return;
        L12:
            if (r100.isTmpDetached() == false) goto L17;
            this.this$0.removeDetachedView(r100.itemView, false);
            return;
        L17:
            return;
        L5:
            if (r100.mShadowingHolder != null) goto L7;
            r100.mShadowedHolder = null;
            goto L7
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static abstract class ItemDecoration {
        public ItemDecoration() {
        }

        public void onDraw(Canvas r100, RecyclerView r101) {
        }

        public void onDrawOver(Canvas r100, RecyclerView r101) {
        }

        public void getItemOffsets(Rect r100, int r101, RecyclerView r102) {
            r100.set(0, 0, 0, 0);
        }

        public void onDraw(Canvas r100, RecyclerView r101, State r102) {
            onDraw(r100, r101);
        }

        public void onDrawOver(Canvas r100, RecyclerView r101, State r102) {
            onDrawOver(r100, r101);
        }

        public void getItemOffsets(Rect r100, View r101, RecyclerView r102, State r103) {
            getItemOffsets(r100, ((LayoutParams) r101.getLayoutParams()).getViewLayoutPosition(), r102);
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
        SmoothScroller mSmoothScroller;
        ViewBoundsCheck mVerticalBoundCheck;
        private final ViewBoundsCheck.Callback mVerticalBoundCheckCallback;
        private int mWidth;
        private int mWidthMode;

        public interface LayoutPrefetchRegistry {
            void addPosition(int r100, int r101);
        }

        public static class Properties {
            public int orientation;
            public boolean reverseLayout;
            public int spanCount;
            public boolean stackFromEnd;

            public Properties() {
            }
        }

        public boolean canScrollHorizontally() {
            return false;
        }

        public boolean canScrollVertically() {
            return false;
        }

        public boolean checkLayoutParams(LayoutParams r100) {
            if (r100 == null) goto L4;
            return true;
        L4:
            return false;
        }

        public void collectAdjacentPrefetchPositions(int r100, int r101, State r102, LayoutPrefetchRegistry r103) {
        }

        public void collectInitialPrefetchPositions(int r100, LayoutPrefetchRegistry r101) {
        }

        public int computeHorizontalScrollExtent(State r100) {
            return 0;
        }

        public int computeHorizontalScrollOffset(State r100) {
            return 0;
        }

        public int computeHorizontalScrollRange(State r100) {
            return 0;
        }

        public int computeVerticalScrollExtent(State r100) {
            return 0;
        }

        public int computeVerticalScrollOffset(State r100) {
            return 0;
        }

        public int computeVerticalScrollRange(State r100) {
            return 0;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public int getBaseline() {
            return -1;
        }

        public int getColumnCountForAccessibility(Recycler r100, State r101) {
            return -1;
        }

        public int getRowCountForAccessibility(Recycler r100, State r101) {
            return -1;
        }

        public int getSelectionModeForAccessibility(Recycler r100, State r101) {
            return 0;
        }

        public boolean isLayoutHierarchical(Recycler r100, State r101) {
            return false;
        }

        public void onAdapterChanged(Adapter r100, Adapter r101) {
        }

        public boolean onAddFocusables(RecyclerView r100, ArrayList<View> r101, int r102, int r103) {
            return false;
        }

        public void onAttachedToWindow(RecyclerView r100) {
        }

        public void onDetachedFromWindow(RecyclerView r100) {
        }

        public View onFocusSearchFailed(View r100, int r101, Recycler r102, State r103) {
            return null;
        }

        public void onInitializeAccessibilityNodeInfoForItem(Recycler r100, State r101, View r102, AccessibilityNodeInfoCompat r103) {
        }

        public View onInterceptFocusSearch(View r100, int r101) {
            return null;
        }

        public void onItemsAdded(RecyclerView r100, int r101, int r102) {
        }

        public void onItemsChanged(RecyclerView r100) {
        }

        public void onItemsMoved(RecyclerView r100, int r101, int r102, int r103) {
        }

        public void onItemsRemoved(RecyclerView r100, int r101, int r102) {
        }

        public void onItemsUpdated(RecyclerView r100, int r101, int r102) {
        }

        public void onLayoutChildren(Recycler r100, State r101) {
        }

        public void onLayoutCompleted(State r100) {
        }

        public void onRestoreInstanceState(Parcelable r100) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int r100) {
        }

        public boolean performAccessibilityActionForItem(Recycler r100, State r101, View r102, int r103, Bundle r104) {
            return false;
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        public int scrollHorizontallyBy(int r100, Recycler r101, State r102) {
            return 0;
        }

        public void scrollToPosition(int r100) {
        }

        public int scrollVerticallyBy(int r100, Recycler r101, State r102) {
            return 0;
        }

        public boolean shouldMeasureTwice() {
            return false;
        }

        public void smoothScrollToPosition(RecyclerView r100, State r101, int r102) {
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        public int getChildCount() {
            ChildHelper r100 = this.mChildHelper;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.getChildCount();
        }

        public boolean getClipToPadding() {
            RecyclerView r100 = this.mRecyclerView;
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.mClipToPadding == false) goto L7;
            return true;
        }

        public View getFocusedChild() {
            RecyclerView r100 = this.mRecyclerView;
            if (r100 != null) goto L5;
            return null;
        L5:
            View r101 = r100.getFocusedChild();
            if (r101 != null) goto L8;
        L11:
            return null;
        L8:
            if (this.mChildHelper.isHidden(r101) == true) goto L11;
            return r101;
        }

        public int getItemCount() {
            RecyclerView r100 = this.mRecyclerView;
            if (r100 == null) goto L5;
            Adapter r101 = r100.getAdapter();
        L6:
            if (r101 != null) goto L10;
            return 0;
        L10:
            return r101.getItemCount();
        L5:
            r101 = null;
            goto L6
        }

        public int getLayoutDirection() {
            return ViewCompat.getLayoutDirection(this.mRecyclerView);
        }

        public int getMinimumHeight() {
            return ViewCompat.getMinimumHeight(this.mRecyclerView);
        }

        public int getMinimumWidth() {
            return ViewCompat.getMinimumWidth(this.mRecyclerView);
        }

        public int getPaddingBottom() {
            RecyclerView r100 = this.mRecyclerView;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.getPaddingBottom();
        }

        public int getPaddingEnd() {
            RecyclerView r100 = this.mRecyclerView;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return ViewCompat.getPaddingEnd(r100);
        }

        public int getPaddingLeft() {
            RecyclerView r100 = this.mRecyclerView;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.getPaddingLeft();
        }

        public int getPaddingRight() {
            RecyclerView r100 = this.mRecyclerView;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.getPaddingRight();
        }

        public int getPaddingStart() {
            RecyclerView r100 = this.mRecyclerView;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return ViewCompat.getPaddingStart(r100);
        }

        public int getPaddingTop() {
            RecyclerView r100 = this.mRecyclerView;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.getPaddingTop();
        }

        public boolean hasFocus() {
            RecyclerView r100 = this.mRecyclerView;
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.hasFocus() == false) goto L7;
            return true;
        }

        public boolean isFocused() {
            RecyclerView r100 = this.mRecyclerView;
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.isFocused() == false) goto L7;
            return true;
        }

        public boolean isSmoothScrolling() {
            SmoothScroller r100 = this.mSmoothScroller;
            if (r100 != null) goto L5;
        L7:
            return false;
        L5:
            if (r100.isRunning() == false) goto L7;
            return true;
        }

        public void requestLayout() {
            RecyclerView r100 = this.mRecyclerView;
            if (r100 == null) goto L6;
            r100.requestLayout();
            return;
        }

        public void stopSmoothScroller() {
            SmoothScroller r100 = this.mSmoothScroller;
            if (r100 == null) goto L6;
            r100.stop();
            return;
        }

        public LayoutManager() {
            ViewBoundsCheck.Callback r100 = new AnonymousClass1(this);
            this.mHorizontalBoundCheckCallback = r100;
            ViewBoundsCheck.Callback r101 = new AnonymousClass2(this);
            this.mVerticalBoundCheckCallback = r101;
            this.mHorizontalBoundCheck = new ViewBoundsCheck(r100);
            this.mVerticalBoundCheck = new ViewBoundsCheck(r101);
            this.mRequestedSimpleAnimations = false;
            this.mIsAttachedToWindow = false;
            this.mAutoMeasure = false;
            this.mMeasurementCacheEnabled = true;
            this.mItemPrefetchEnabled = true;
        }

        public boolean hasFlexibleChildInBothOrientations() {
            int r100 = getChildCount();
            int r101 = 0;
        L3:
            if (r101 >= r100) goto L11;
            ViewGroup.LayoutParams r102 = getChildAt(r101).getLayoutParams();
            if (r102.width >= 0) goto L10;
            if (r102.height >= 0) goto L10;
            return true;
        L10:
            r101 = r101 + 1;
            goto L3
        L11:
            return false;
        }

        public void removeAllViews() {
            int r100 = getChildCount() - 1;
        L3:
            if (r100 < 0) goto L5;
            this.mChildHelper.removeViewAt(r100);
            r100 = r100 - 1;
            goto L3
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public void addDisappearingView(View r100) {
            addDisappearingView(r100, -1);
        }

        public void addView(View r100) {
            addView(r100, -1);
        }

        public void assertInLayoutOrScroll(String r100) {
            RecyclerView r101 = this.mRecyclerView;
            if (r101 == null) goto L6;
            r101.assertInLayoutOrScroll(r100);
            return;
        }

        public void assertNotInLayoutOrScroll(String r100) {
            RecyclerView r101 = this.mRecyclerView;
            if (r101 == null) goto L6;
            r101.assertNotInLayoutOrScroll(r100);
            return;
        }

        public void attachView(View r100) {
            attachView(r100, -1);
        }

        public void detachAndScrapAttachedViews(Recycler r100) {
            int r101 = getChildCount() - 1;
        L3:
            if (r101 < 0) goto L5;
            scrapOrRecycleView(r100, r101, getChildAt(r101));
            r101 = r101 - 1;
            goto L3
        }

        public void detachView(View r100) {
            int r101 = this.mChildHelper.indexOfChild(r100);
            if (r101 < 0) goto L6;
            detachViewInternal(r101, r100);
            return;
        }

        public void detachViewAt(int r100) {
            detachViewInternal(r100, getChildAt(r100));
        }

        public void dispatchAttachedToWindow(RecyclerView r100) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(r100);
        }

        public void endAnimation(View r100) {
            ItemAnimator r101 = this.mRecyclerView.mItemAnimator;
            if (r101 == null) goto L6;
            r101.endAnimation(RecyclerView.getChildViewHolderInt(r100));
            return;
        }

        public View findContainingItemView(View r100) {
            RecyclerView r101 = this.mRecyclerView;
            if (r101 != null) goto L5;
            return null;
        L5:
            View r102 = r101.findContainingItemView(r100);
            if (r102 != null) goto L9;
            return null;
        L9:
            if (this.mChildHelper.isHidden(r102) == false) goto L11;
            return null;
        L11:
            return r102;
        }

        public View findViewByPosition(int r100) {
            int r101 = getChildCount();
            int r102 = 0;
        L3:
            if (r102 >= r101) goto L17;
            View r103 = getChildAt(r102);
            ViewHolder r104 = RecyclerView.getChildViewHolderInt(r103);
            if (r104 == null) goto L16;
            if (r104.getLayoutPosition() != r100) goto L16;
            if (r104.shouldIgnore() == true) goto L16;
            if (this.mRecyclerView.mState.isPreLayout() == true) goto L15;
            if (r104.isRemoved() == true) goto L16;
        L15:
            return r103;
        L16:
            r102 = r102 + 1;
            goto L3
        L17:
            return null;
        }

        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
            if ((r100 instanceof LayoutParams) == false) goto L7;
            return new LayoutParams((LayoutParams) r100);
        L7:
            if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
            return new LayoutParams((ViewGroup.MarginLayoutParams) r100);
        L11:
            return new LayoutParams(r100);
        }

        public int getBottomDecorationHeight(View r100) {
            return ((LayoutParams) r100.getLayoutParams()).mDecorInsets.bottom;
        }

        public View getChildAt(int r100) {
            ChildHelper r101 = this.mChildHelper;
            if (r101 != null) goto L7;
            return null;
        L7:
            return r101.getChildAt(r100);
        }

        public int getDecoratedBottom(View r100) {
            return r100.getBottom() + getBottomDecorationHeight(r100);
        }

        public int getDecoratedLeft(View r100) {
            return r100.getLeft() - getLeftDecorationWidth(r100);
        }

        public int getDecoratedMeasuredHeight(View r100) {
            Rect r101 = ((LayoutParams) r100.getLayoutParams()).mDecorInsets;
            return (r100.getMeasuredHeight() + r101.top) + r101.bottom;
        }

        public int getDecoratedMeasuredWidth(View r100) {
            Rect r101 = ((LayoutParams) r100.getLayoutParams()).mDecorInsets;
            return (r100.getMeasuredWidth() + r101.left) + r101.right;
        }

        public int getDecoratedRight(View r100) {
            return r100.getRight() + getRightDecorationWidth(r100);
        }

        public int getDecoratedTop(View r100) {
            return r100.getTop() - getTopDecorationHeight(r100);
        }

        public int getItemViewType(View r100) {
            return RecyclerView.getChildViewHolderInt(r100).getItemViewType();
        }

        public int getLeftDecorationWidth(View r100) {
            return ((LayoutParams) r100.getLayoutParams()).mDecorInsets.left;
        }

        public int getPosition(View r100) {
            return ((LayoutParams) r100.getLayoutParams()).getViewLayoutPosition();
        }

        public int getRightDecorationWidth(View r100) {
            return ((LayoutParams) r100.getLayoutParams()).mDecorInsets.right;
        }

        public int getTopDecorationHeight(View r100) {
            return ((LayoutParams) r100.getLayoutParams()).mDecorInsets.top;
        }

        public void ignoreView(View r100) {
            ViewParent r101 = r100.getParent();
            RecyclerView r102 = this.mRecyclerView;
            if (r101 != r102) goto L9;
            if (r102.indexOfChild(r100) == (-1)) goto L9;
            ViewHolder r103 = RecyclerView.getChildViewHolderInt(r100);
            r103.addFlags(128);
            this.mRecyclerView.mViewInfoStore.removeViewHolder(r103);
            return;
        L9:
            throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.exceptionLabel());
        }

        public void offsetChildrenHorizontal(int r100) {
            RecyclerView r101 = this.mRecyclerView;
            if (r101 == null) goto L6;
            r101.offsetChildrenHorizontal(r100);
            return;
        }

        public void offsetChildrenVertical(int r100) {
            RecyclerView r101 = this.mRecyclerView;
            if (r101 == null) goto L6;
            r101.offsetChildrenVertical(r100);
            return;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent r100) {
            RecyclerView r101 = this.mRecyclerView;
            onInitializeAccessibilityEvent(r101.mRecycler, r101.mState, r100);
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat r100) {
            RecyclerView r101 = this.mRecyclerView;
            onInitializeAccessibilityNodeInfo(r101.mRecycler, r101.mState, r100);
        }

        public void onSmoothScrollerStopped(SmoothScroller r100) {
            if (this.mSmoothScroller != r100) goto L6;
            this.mSmoothScroller = null;
            return;
        }

        public void postOnAnimation(Runnable r100) {
            RecyclerView r101 = this.mRecyclerView;
            if (r101 == null) goto L6;
            ViewCompat.postOnAnimation(r101, r100);
            return;
        }

        public void removeAndRecycleAllViews(Recycler r100) {
            int r101 = getChildCount() - 1;
        L3:
            if (r101 < 0) goto L8;
            if (RecyclerView.getChildViewHolderInt(getChildAt(r101)).shouldIgnore() == true) goto L7;
            removeAndRecycleViewAt(r101, r100);
        L7:
            r101 = r101 - 1;
            goto L3
        }

        public void removeAndRecycleScrapInt(Recycler r100) {
            int r101 = r100.getScrapCount();
            int r102 = r101 - 1;
        L3:
            if (r102 < 0) goto L15;
            View r103 = r100.getScrapViewAt(r102);
            ViewHolder r104 = RecyclerView.getChildViewHolderInt(r103);
            if (r104.shouldIgnore() == true) goto L14;
            r104.setIsRecyclable(false);
            if (r104.isTmpDetached() == false) goto L10;
            this.mRecyclerView.removeDetachedView(r103, false);
        L10:
            ItemAnimator r105 = this.mRecyclerView.mItemAnimator;
            if (r105 == null) goto L13;
            r105.endAnimation(r104);
        L13:
            r104.setIsRecyclable(true);
            r100.quickRecycleScrapView(r103);
        L14:
            r102 = r102 - 1;
            goto L3
        L15:
            r100.clearScrap();
            if (r101 <= 0) goto L22;
            this.mRecyclerView.invalidate();
            return;
        }

        public boolean removeCallbacks(Runnable r100) {
            RecyclerView r101 = this.mRecyclerView;
            if (r101 != null) goto L5;
            return false;
        L5:
            return r101.removeCallbacks(r100);
        }

        public void removeDetachedView(View r100) {
            this.mRecyclerView.removeDetachedView(r100, false);
        }

        public void removeView(View r100) {
            this.mChildHelper.removeView(r100);
        }

        public void removeViewAt(int r100) {
            if (getChildAt(r100) == null) goto L6;
            this.mChildHelper.removeViewAt(r100);
            return;
        }

        public void setAutoMeasureEnabled(boolean r100) {
            this.mAutoMeasure = r100;
        }

        public void setExactMeasureSpecsFrom(RecyclerView r100) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(r100.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r100.getHeight(), 1073741824));
        }

        public final void setItemPrefetchEnabled(boolean r100) {
            if (r100 == this.mItemPrefetchEnabled) goto L8;
            this.mItemPrefetchEnabled = r100;
            this.mPrefetchMaxCountObserved = 0;
            RecyclerView r101 = this.mRecyclerView;
            if (r101 == null) goto L9;
            r101.mRecycler.updateViewCacheSize();
            return;
        L9:
            return;
        }

        public void setMeasurementCacheEnabled(boolean r100) {
            this.mMeasurementCacheEnabled = r100;
        }

        void setRecyclerView(RecyclerView r100) {
            if (r100 != null) goto L4;
            this.mRecyclerView = null;
            this.mChildHelper = null;
            this.mWidth = 0;
            this.mHeight = 0;
        L5:
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
            return;
        L4:
            this.mRecyclerView = r100;
            this.mChildHelper = r100.mChildHelper;
            this.mWidth = r100.getWidth();
            this.mHeight = r100.getHeight();
            goto L5
        }

        public void startSmoothScroll(SmoothScroller r100) {
            SmoothScroller r101 = this.mSmoothScroller;
            if (r101 == null) goto L8;
            if (r100 == r101) goto L8;
            if (r101.isRunning() == false) goto L8;
            this.mSmoothScroller.stop();
        L8:
            this.mSmoothScroller = r100;
            r100.start(this.mRecyclerView, this);
        }

        public void stopIgnoringView(View r100) {
            ViewHolder r101 = RecyclerView.getChildViewHolderInt(r100);
            r101.stopIgnoring();
            r101.resetInternal();
            r101.addFlags(4);
        }

        private void detachViewInternal(int r100, View r101) {
            this.mChildHelper.detachViewFromParent(r100);
        }

        private int[] getChildRectangleOnScreenScrollAmount(View r110, Rect r111) {
            int[] r100 = new int[2];
            int r101 = getPaddingLeft();
            int r102 = getPaddingTop();
            int r103 = getWidth() - getPaddingRight();
            int r104 = getHeight() - getPaddingBottom();
            int r105 = (r110.getLeft() + r111.left) - r110.getScrollX();
            int r106 = (r110.getTop() + r111.top) - r110.getScrollY();
            int r112 = r111.width() + r105;
            int r113 = r111.height() + r106;
            int r107 = r105 - r101;
            int r108 = Math.min(0, r107);
            int r109 = r106 - r102;
            int r114 = Math.min(0, r109);
            int r115 = r112 - r103;
            int r116 = Math.max(0, r115);
            int r117 = Math.max(0, r113 - r104);
            if (getLayoutDirection() != 1) goto L7;
            if (r116 != 0) goto L11;
            r116 = Math.max(r108, r115);
        L11:
            if (r114 != 0) goto L14;
            r114 = Math.min(r109, r117);
        L14:
            r100[0] = r116;
            r100[1] = r114;
            return r100;
        L7:
            if (r108 != 0) goto L10;
            r108 = Math.min(r107, r116);
        L10:
            r116 = r108;
            goto L11
        }

        public void addDisappearingView(View r100, int r101) {
            addViewInt(r100, r101, true);
        }

        public void addView(View r100, int r101) {
            addViewInt(r100, r101, false);
        }

        public void attachView(View r100, int r101) {
            attachView(r100, r101, (LayoutParams) r100.getLayoutParams());
        }

        public void calculateItemDecorationsForChild(View r100, Rect r101) {
            RecyclerView r102 = this.mRecyclerView;
            if (r102 != null) goto L6;
            r101.set(0, 0, 0, 0);
            return;
        L6:
            r101.set(r102.getItemDecorInsetsForChild(r100));
        }

        public void detachAndScrapView(View r100, Recycler r101) {
            scrapOrRecycleView(r101, this.mChildHelper.indexOfChild(r100), r100);
        }

        public void detachAndScrapViewAt(int r100, Recycler r101) {
            scrapOrRecycleView(r101, r100, getChildAt(r100));
        }

        public void dispatchDetachedFromWindow(RecyclerView r100, Recycler r101) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(r100, r101);
        }

        public LayoutParams generateLayoutParams(Context r100, AttributeSet r101) {
            return new LayoutParams(r100, r101);
        }

        public void getDecoratedBoundsWithMargins(View r100, Rect r101) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(r100, r101);
        }

        public void moveView(int r100, int r101) {
            View r102 = getChildAt(r100);
            if (r102 == null) goto L7;
            detachViewAt(r100);
            attachView(r102, r101);
            return;
        L7:
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + r100 + this.mRecyclerView.toString());
        }

        public void onDetachedFromWindow(RecyclerView r100, Recycler r101) {
            onDetachedFromWindow(r100);
        }

        public void onInitializeAccessibilityNodeInfoForItem(View r100, AccessibilityNodeInfoCompat r101) {
            ViewHolder r102 = RecyclerView.getChildViewHolderInt(r100);
            if (r102 != null) goto L5;
            return;
        L5:
            if (r102.isRemoved() == false) goto L7;
            return;
        L7:
            if (this.mChildHelper.isHidden(r102.itemView) == true) goto L12;
            RecyclerView r103 = this.mRecyclerView;
            onInitializeAccessibilityNodeInfoForItem(r103.mRecycler, r103.mState, r100, r101);
            return;
        }

        boolean performAccessibilityAction(int r100, Bundle r101) {
            RecyclerView r102 = this.mRecyclerView;
            return performAccessibilityAction(r102.mRecycler, r102.mState, r100, r101);
        }

        public void removeAndRecycleView(View r100, Recycler r101) {
            removeView(r100);
            r101.recycleView(r100);
        }

        public void removeAndRecycleViewAt(int r100, Recycler r101) {
            View r102 = getChildAt(r100);
            removeViewAt(r100);
            r101.recycleView(r102);
        }

        public void setMeasureSpecs(int r100, int r101) {
            this.mWidth = View.MeasureSpec.getSize(r100);
            int r102 = View.MeasureSpec.getMode(r100);
            this.mWidthMode = r102;
            if (r102 == 0) goto L5;
        L7:
            this.mHeight = View.MeasureSpec.getSize(r101);
            int r103 = View.MeasureSpec.getMode(r101);
            this.mHeightMode = r103;
            if (r103 == 0) goto L10;
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

        public void setMeasuredDimension(int r100, int r101) {
            RecyclerView.access$300(this.mRecyclerView, r100, r101);
        }

        public void setMeasuredDimensionFromChildren(int r100, int r110) {
            int r101 = getChildCount();
            if (r101 != 0) goto L6;
            this.mRecyclerView.defaultOnMeasure(r100, r110);
            return;
        L6:
            int r102 = Integer.MIN_VALUE;
            int r103 = Integer.MIN_VALUE;
            int r104 = Integer.MAX_VALUE;
            int r105 = Integer.MAX_VALUE;
            int r106 = 0;
        L7:
            if (r106 >= r101) goto L21;
            View r107 = getChildAt(r106);
            Rect r108 = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(r107, r108);
            int r109 = r108.left;
            if (r109 >= r104) goto L11;
            r104 = r109;
        L11:
            int r111 = r108.right;
            if (r111 <= r102) goto L14;
            r102 = r111;
        L14:
            int r112 = r108.top;
            if (r112 >= r105) goto L17;
            r105 = r112;
        L17:
            int r113 = r108.bottom;
            if (r113 <= r103) goto L20;
            r103 = r113;
        L20:
            r106 = r106 + 1;
            goto L7
        L21:
            this.mRecyclerView.mTempRect.set(r104, r105, r102, r103);
            setMeasuredDimension(this.mRecyclerView.mTempRect, r100, r110);
        }

        private void addViewInt(View r100, int r101, boolean r102) {
            ViewHolder r103 = RecyclerView.getChildViewHolderInt(r100);
            if (r102 == false) goto L5;
        L8:
            this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(r103);
        L9:
            LayoutParams r104 = (LayoutParams) r100.getLayoutParams();
            if (r103.wasReturnedFromScrap() == true) goto L30;
            if (r103.isScrap() == true) goto L30;
            if (r100.getParent() != this.mRecyclerView) goto L24;
            int r105 = this.mChildHelper.indexOfChild(r100);
            if (r101 != (-1)) goto L19;
            r101 = this.mChildHelper.getChildCount();
        L19:
            if (r105 == (-1)) goto L23;
            if (r105 == r101) goto L35;
            this.mRecyclerView.mLayout.moveView(r105, r101);
        L35:
            if (r104.mPendingInvalidate == false) goto L38;
            r103.itemView.invalidate();
            r104.mPendingInvalidate = false;
            return;
        L38:
            return;
        L23:
            throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(r100) + this.mRecyclerView.exceptionLabel());
        L24:
            this.mChildHelper.addView(r100, r101, false);
            r104.mInsetsDirty = true;
            SmoothScroller r106 = this.mSmoothScroller;
            if (r106 == null) goto L35;
            if (r106.isRunning() == false) goto L35;
            this.mSmoothScroller.onChildAttachedToWindow(r100);
        L30:
            if (r103.isScrap() == false) goto L32;
            r103.unScrap();
        L33:
            this.mChildHelper.attachViewToParent(r100, r101, r100.getLayoutParams(), false);
            goto L35
        L32:
            r103.clearReturnedFromScrapFlag();
            goto L33
        L5:
            if (r103.isRemoved() == true) goto L8;
            this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(r103);
            goto L9
        }

        public static int chooseSize(int r100, int r101, int r102) {
            int r103 = View.MeasureSpec.getMode(r100);
            int r104 = View.MeasureSpec.getSize(r100);
            if (r103 == Integer.MIN_VALUE) goto L9;
            if (r103 != 1073741824) goto L7;
            return r104;
        L7:
            return Math.max(r101, r102);
        L9:
            return Math.min(r104, Math.max(r101, r102));
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView r100, int r101, int r102) {
            View r103 = r100.getFocusedChild();
            if (r103 != null) goto L5;
            return false;
        L5:
            int r104 = getPaddingLeft();
            int r105 = getPaddingTop();
            int r106 = getWidth() - getPaddingRight();
            int r107 = getHeight() - getPaddingBottom();
            Rect r108 = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(r103, r108);
            if ((r108.left - r101) < r106) goto L8;
        L16:
            return false;
        L8:
            if ((r108.right - r101) <= r104) goto L16;
            if ((r108.top - r102) >= r107) goto L16;
            if ((r108.bottom - r102) <= r105) goto L16;
            return true;
        }

        private static boolean isMeasurementUpToDate(int r100, int r101, int r102) {
            int r103 = View.MeasureSpec.getMode(r101);
            int r104 = View.MeasureSpec.getSize(r101);
            if (r102 <= 0) goto L7;
            if (r100 == r102) goto L7;
            return false;
        L7:
            if (r103 == Integer.MIN_VALUE) goto L16;
            if (r103 != 0) goto L10;
            return true;
        L10:
            if (r103 == 1073741824) goto L12;
            return false;
        L12:
            if (r104 != r100) goto L19;
            return true;
        L19:
            return false;
        L16:
            if (r104 < r100) goto L20;
            return true;
        L20:
            return false;
        }

        private void scrapOrRecycleView(Recycler r100, int r101, View r102) {
            ViewHolder r103 = RecyclerView.getChildViewHolderInt(r102);
            if (r103.shouldIgnore() == false) goto L6;
            return;
        L6:
            if (r103.isInvalid() == true) goto L8;
        L12:
            detachViewAt(r101);
            r100.scrapView(r102);
            this.mRecyclerView.mViewInfoStore.onViewDetached(r103);
            return;
        L8:
            if (r103.isRemoved() == true) goto L12;
            if (this.mRecyclerView.mAdapter.hasStableIds() == true) goto L12;
            removeViewAt(r101);
            r100.recycleViewHolderInternal(r103);
        }

        public void attachView(View r100, int r101, LayoutParams r102) {
            ViewHolder r103 = RecyclerView.getChildViewHolderInt(r100);
            if (r103.isRemoved() == false) goto L5;
            this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(r103);
        L6:
            this.mChildHelper.attachViewToParent(r100, r101, r102, r103.isRemoved());
            return;
        L5:
            this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(r103);
            goto L6
        }

        public void getTransformedBoundingBox(View r100, boolean r101, Rect r102) {
            if (r101 == false) goto L4;
            Rect r103 = ((LayoutParams) r100.getLayoutParams()).mDecorInsets;
            r102.set(-r103.left, -r103.top, r100.getWidth() + r103.right, r100.getHeight() + r103.bottom);
        L6:
            if (this.mRecyclerView == null) goto L12;
            Matrix r104 = r100.getMatrix();
            if (r104 == null) goto L12;
            if (r104.isIdentity() == true) goto L12;
            RectF r105 = this.mRecyclerView.mTempRectF;
            r105.set(r102);
            r104.mapRect(r105);
            r102.set((int) Math.floor(r105.left), (int) Math.floor(r105.top), (int) Math.ceil(r105.right), (int) Math.ceil(r105.bottom));
        L12:
            r102.offset(r100.getLeft(), r100.getTop());
            return;
        L4:
            r102.set(0, 0, r100.getWidth(), r100.getHeight());
            goto L6
        }

        public boolean isViewPartiallyVisible(View r100, boolean r101, boolean r102) {
            if (this.mHorizontalBoundCheck.isViewWithinBoundFlags(r100, 24579) == true) goto L5;
        L7:
            boolean r103 = false;
        L8:
            if (r101 == false) goto L11;
            return r103;
        L11:
            return !r103;
        L5:
            if (this.mVerticalBoundCheck.isViewWithinBoundFlags(r100, 24579) == false) goto L7;
            r103 = true;
            goto L8
        }

        public void measureChild(View r100, int r101, int r102) {
            LayoutParams r103 = (LayoutParams) r100.getLayoutParams();
            Rect r104 = this.mRecyclerView.getItemDecorInsetsForChild(r100);
            int r105 = r101 + (r104.left + r104.right);
            int r106 = r102 + (r104.top + r104.bottom);
            int r107 = getChildMeasureSpec(getWidth(), getWidthMode(), (getPaddingLeft() + getPaddingRight()) + r105, ((ViewGroup.MarginLayoutParams) r103).width, canScrollHorizontally());
            int r108 = getChildMeasureSpec(getHeight(), getHeightMode(), (getPaddingTop() + getPaddingBottom()) + r106, ((ViewGroup.MarginLayoutParams) r103).height, canScrollVertically());
            if (shouldMeasureChild(r100, r107, r108, r103) == false) goto L6;
            r100.measure(r107, r108);
            return;
        }

        public void measureChildWithMargins(View r100, int r101, int r102) {
            LayoutParams r103 = (LayoutParams) r100.getLayoutParams();
            Rect r104 = this.mRecyclerView.getItemDecorInsetsForChild(r100);
            int r105 = r101 + (r104.left + r104.right);
            int r106 = r102 + (r104.top + r104.bottom);
            int r107 = getChildMeasureSpec(getWidth(), getWidthMode(), (((getPaddingLeft() + getPaddingRight()) + ((ViewGroup.MarginLayoutParams) r103).leftMargin) + ((ViewGroup.MarginLayoutParams) r103).rightMargin) + r105, ((ViewGroup.MarginLayoutParams) r103).width, canScrollHorizontally());
            int r108 = getChildMeasureSpec(getHeight(), getHeightMode(), (((getPaddingTop() + getPaddingBottom()) + ((ViewGroup.MarginLayoutParams) r103).topMargin) + ((ViewGroup.MarginLayoutParams) r103).bottomMargin) + r106, ((ViewGroup.MarginLayoutParams) r103).height, canScrollVertically());
            if (shouldMeasureChild(r100, r107, r108, r103) == false) goto L6;
            r100.measure(r107, r108);
            return;
        }

        public void onInitializeAccessibilityEvent(Recycler r100, State r101, AccessibilityEvent r102) {
            RecyclerView r103 = this.mRecyclerView;
            if (r103 == null) goto L20;
            if (r102 == null) goto L22;
            boolean r104 = true;
            if (r103.canScrollVertically(1) == false) goto L9;
        L16:
            r102.setScrollable(r104);
            Adapter r105 = this.mRecyclerView.mAdapter;
            if (r105 == null) goto L21;
            r102.setItemCount(r105.getItemCount());
            return;
        L21:
            return;
        L9:
            if (this.mRecyclerView.canScrollVertically(-1) == true) goto L16;
            if (this.mRecyclerView.canScrollHorizontally(-1) == true) goto L16;
            if (this.mRecyclerView.canScrollHorizontally(1) == true) goto L16;
            r104 = false;
            goto L16
        L22:
            return;
        }

        public void onInitializeAccessibilityNodeInfo(Recycler r100, State r101, AccessibilityNodeInfoCompat r102) {
            if (this.mRecyclerView.canScrollVertically(-1) == false) goto L5;
        L6:
            r102.addAction(8192);
            r102.setScrollable(true);
        L8:
            if (this.mRecyclerView.canScrollVertically(1) == false) goto L10;
        L11:
            r102.addAction(4096);
            r102.setScrollable(true);
        L12:
            r102.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(r100, r101), getColumnCountForAccessibility(r100, r101), isLayoutHierarchical(r100, r101), getSelectionModeForAccessibility(r100, r101)));
            return;
        L10:
            if (this.mRecyclerView.canScrollHorizontally(1) == false) goto L12;
        L5:
            if (this.mRecyclerView.canScrollHorizontally(-1) == false) goto L8;
            goto L6
        }

        public boolean onRequestChildFocus(RecyclerView r100, View r101, View r102) {
            if (isSmoothScrolling() == false) goto L5;
        L8:
            return true;
        L5:
            if (r100.isComputingLayout() == true) goto L8;
            return false;
        }

        public boolean performAccessibilityActionForItem(View r100, int r101, Bundle r110) {
            RecyclerView r102 = this.mRecyclerView;
            return performAccessibilityActionForItem(r102.mRecycler, r102.mState, r100, r101, r110);
        }

        public void setMeasuredDimension(Rect r100, int r101, int r102) {
            int r103 = (r100.width() + getPaddingLeft()) + getPaddingRight();
            int r104 = (r100.height() + getPaddingTop()) + getPaddingBottom();
            setMeasuredDimension(chooseSize(r101, r103, getMinimumWidth()), chooseSize(r102, r104, getMinimumHeight()));
        }

        public static int getChildMeasureSpec(int r100, int r101, int r102, boolean r103) {
            int r104 = r100 - r101;
            int r105 = 0;
            int r106 = Math.max(0, r104);
            if (r103 == false) goto L7;
            if (r102 >= 0) goto L8;
        L6:
            r102 = 0;
        L17:
            return View.MeasureSpec.makeMeasureSpec(r102, r105);
        L8:
            r105 = 1073741824;
            goto L17
        L7:
            if (r102 >= 0) goto L8;
            if (r102 != (-1)) goto L14;
            r105 = 1073741824;
        L12:
            r102 = r106;
            goto L17
        L14:
            if (r102 != (-2)) goto L6;
            r105 = Integer.MIN_VALUE;
            goto L12
        }

        public static Properties getProperties(Context r100, AttributeSet r101, int r102, int r103) {
            Properties r104 = new Properties();
            TypedArray r105 = r100.obtainStyledAttributes(r101, new int[]{R.attr.orientation, R.attr.clipToPadding, R.attr.descendantFocusability, com.larus.nova.R.attr.fastScrollEnabled, com.larus.nova.R.attr.fastScrollHorizontalThumbDrawable, com.larus.nova.R.attr.fastScrollHorizontalTrackDrawable, com.larus.nova.R.attr.fastScrollVerticalThumbDrawable, com.larus.nova.R.attr.fastScrollVerticalTrackDrawable, com.larus.nova.R.attr.layoutManager, com.larus.nova.R.attr.reverseLayout, com.larus.nova.R.attr.spanCount, com.larus.nova.R.attr.stackFromEnd}, r102, r103);
            r104.orientation = r105.getInt(0, 1);
            r104.spanCount = r105.getInt(10, 1);
            r104.reverseLayout = r105.getBoolean(9, false);
            r104.stackFromEnd = r105.getBoolean(11, false);
            r105.recycle();
            return r104;
        }

        public void onItemsUpdated(RecyclerView r100, int r101, int r102, Object r103) {
            onItemsUpdated(r100, r101, r102);
        }

        public void onMeasure(Recycler r100, State r101, int r102, int r103) {
            this.mRecyclerView.defaultOnMeasure(r102, r103);
        }

        public boolean onRequestChildFocus(RecyclerView r100, State r101, View r102, View r103) {
            return onRequestChildFocus(r100, r102, r103);
        }

        public boolean performAccessibilityAction(Recycler r100, State r101, int r110, Bundle r111) {
            RecyclerView r102 = this.mRecyclerView;
            if (r102 != null) goto L6;
            return false;
        L6:
            if (r110 == 4096) goto L18;
            if (r110 == 8192) goto L11;
            int r103 = 0;
            int r104 = 0;
        L26:
            if (r104 != 0) goto L29;
            if (r103 != 0) goto L29;
            return false;
        L29:
            this.mRecyclerView.smoothScrollBy(r103, r104, null, Integer.MIN_VALUE, true);
            return true;
        L11:
            if (r102.canScrollVertically(-1) == false) goto L13;
            int r105 = -((getHeight() - getPaddingTop()) - getPaddingBottom());
        L15:
            if (this.mRecyclerView.canScrollHorizontally(-1) == false) goto L25;
            int r112 = -((getWidth() - getPaddingLeft()) - getPaddingRight());
        L24:
            r104 = r105;
            r103 = r112;
        L25:
            r104 = r105;
            r103 = 0;
            goto L26
        L13:
            r105 = 0;
            goto L15
        L18:
            if (r102.canScrollVertically(1) == false) goto L20;
            r105 = (getHeight() - getPaddingTop()) - getPaddingBottom();
        L22:
            if (this.mRecyclerView.canScrollHorizontally(1) == false) goto L25;
            r112 = (getWidth() - getPaddingLeft()) - getPaddingRight();
            goto L24
        L20:
            r105 = 0;
            goto L22
        }

        public boolean requestChildRectangleOnScreen(RecyclerView r100, View r101, Rect r102, boolean r110) {
            return requestChildRectangleOnScreen(r100, r101, r102, r110, false);
        }

        public boolean shouldMeasureChild(View r100, int r101, int r102, LayoutParams r103) {
            if (r100.isLayoutRequested() == false) goto L5;
        L12:
            return true;
        L5:
            if (this.mMeasurementCacheEnabled == false) goto L12;
            if (isMeasurementUpToDate(r100.getWidth(), r101, ((ViewGroup.MarginLayoutParams) r103).width) == false) goto L12;
            if (isMeasurementUpToDate(r100.getHeight(), r102, ((ViewGroup.MarginLayoutParams) r103).height) == false) goto L12;
            return false;
        }

        public boolean shouldReMeasureChild(View r100, int r101, int r102, LayoutParams r103) {
            if (this.mMeasurementCacheEnabled == true) goto L5;
        L10:
            return true;
        L5:
            if (isMeasurementUpToDate(r100.getMeasuredWidth(), r101, ((ViewGroup.MarginLayoutParams) r103).width) == false) goto L10;
            if (isMeasurementUpToDate(r100.getMeasuredHeight(), r102, ((ViewGroup.MarginLayoutParams) r103).height) == false) goto L10;
            return false;
        }

        public static int getChildMeasureSpec(int r100, int r101, int r102, int r103, boolean r104) {
            int r105 = Math.max(0, r100 - r102);
            if (r104 == false) goto L11;
            if (r103 >= 0) goto L12;
            if (r103 != (-1)) goto L21;
            if (r101 == Integer.MIN_VALUE) goto L14;
            if (r101 == 0) goto L21;
            if (r101 != 1073741824) goto L21;
        L14:
            r103 = r105;
        L23:
            return View.MeasureSpec.makeMeasureSpec(r103, r101);
        L21:
            r101 = 0;
            r103 = 0;
        L12:
            r101 = 1073741824;
            goto L23
        L11:
            if (r103 >= 0) goto L12;
            if (r103 == (-1)) goto L14;
            if (r103 != (-2)) goto L21;
            if (r101 == Integer.MIN_VALUE) goto L20;
            if (r101 == 1073741824) goto L20;
            r101 = 0;
        L20:
            r101 = Integer.MIN_VALUE;
            goto L14
        }

        public void layoutDecorated(View r100, int r101, int r102, int r103, int r104) {
            Rect r105 = ((LayoutParams) r100.getLayoutParams()).mDecorInsets;
            r100.layout(r101 + r105.left, r102 + r105.top, r103 - r105.right, r104 - r105.bottom);
        }

        public void layoutDecoratedWithMargins(View r100, int r101, int r102, int r103, int r104) {
            LayoutParams r105 = (LayoutParams) r100.getLayoutParams();
            Rect r106 = r105.mDecorInsets;
            r100.layout((r101 + r106.left) + ((ViewGroup.MarginLayoutParams) r105).leftMargin, (r102 + r106.top) + ((ViewGroup.MarginLayoutParams) r105).topMargin, (r103 - r106.right) - ((ViewGroup.MarginLayoutParams) r105).rightMargin, (r104 - r106.bottom) - ((ViewGroup.MarginLayoutParams) r105).bottomMargin);
        }

        public boolean requestChildRectangleOnScreen(RecyclerView r100, View r101, Rect r102, boolean r103, boolean r104) {
            int[] r105 = getChildRectangleOnScreenScrollAmount(r101, r102);
            int r106 = r105[0];
            int r107 = r105[1];
            if (r104 == true) goto L5;
        L6:
            if (r106 != 0) goto L10;
            if (r107 != 0) goto L10;
        L9:
            return false;
        L10:
            if (r103 == false) goto L12;
            r100.scrollBy(r106, r107);
        L13:
            return true;
        L12:
            r100.smoothScrollBy(r106, r107);
            goto L13
        L5:
            if (isFocusedChildVisibleAfterScrolling(r100, r106, r107) == false) goto L9;
            goto L6
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        final Rect mDecorInsets;
        boolean mInsetsDirty;
        boolean mPendingInvalidate;
        ViewHolder mViewHolder;

        public int getAbsoluteAdapterPosition() {
            return this.mViewHolder.getAbsoluteAdapterPosition();
        }

        public int getBindingAdapterPosition() {
            return this.mViewHolder.getBindingAdapterPosition();
        }

        public int getViewAdapterPosition() {
            return this.mViewHolder.getBindingAdapterPosition();
        }

        public int getViewLayoutPosition() {
            return this.mViewHolder.getLayoutPosition();
        }

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

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r100) {
            super(r100);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(LayoutParams r100) {
            super(r100);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(int r100, int r101) {
            super(r100, r101);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.mDecorInsets = new Rect();
            this.mInsetsDirty = true;
            this.mPendingInvalidate = false;
        }
    }

    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow(View r100);

        void onChildViewDetachedFromWindow(View r100);
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static abstract class OnFlingListener {
        public OnFlingListener() {
        }

        public abstract boolean onFling(int r100, int r101);
    }

    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(RecyclerView r100, MotionEvent r101);

        void onRequestDisallowInterceptTouchEvent(boolean r100);

        void onTouchEvent(RecyclerView r100, MotionEvent r101);
    }

    public static abstract class OnScrollListener {
        public OnScrollListener() {
        }

        public void onScrollStateChanged(RecyclerView r100, int r101) {
        }

        public void onScrolled(RecyclerView r100, int r101, int r102) {
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    public static class RecycledViewPool {
        private static final int DEFAULT_MAX_SCRAP = 5;
        private int mAttachCount;
        SparseArray<ScrapData> mScrap;

        /* JADX INFO: loaded from: classes17.dex */
        public static class ScrapData {
            long mBindRunningAverageNs;
            long mCreateRunningAverageNs;
            int mMaxScrap;
            final ArrayList<ViewHolder> mScrapHeap;

            public ScrapData() {
                this.mScrapHeap = new ArrayList();
                this.mMaxScrap = 5;
                this.mCreateRunningAverageNs = 0;
                this.mBindRunningAverageNs = 0;
            }
        }

        public void clear() {
            int r100 = 0;
        L4:
            if (r100 >= this.mScrap.size()) goto L6;
            this.mScrap.valueAt(r100).mScrapHeap.clear();
            r100 = r100 + 1;
            goto L4
        }

        public int size() {
            int r100 = 0;
            int r101 = 0;
        L4:
            if (r100 >= this.mScrap.size()) goto L9;
            ArrayList<ViewHolder> r102 = this.mScrap.valueAt(r100).mScrapHeap;
            if (r102 == null) goto L8;
            r101 = r101 + r102.size();
        L8:
            r100 = r100 + 1;
            goto L4
        L9:
            return r101;
        }

        public void attach() {
            this.mAttachCount++;
        }

        public void detach() {
            this.mAttachCount--;
        }

        public RecycledViewPool() {
            this.mScrap = new SparseArray();
            this.mAttachCount = 0;
        }

        private ScrapData getScrapDataForType(int r100) {
            ScrapData r101 = this.mScrap.get(r100);
            if (r101 != null) goto L6;
            ScrapData r102 = new ScrapData();
            this.mScrap.put(r100, r102);
            return r102;
        L6:
            return r101;
        }

        public ViewHolder getRecycledView(int r100) {
            ScrapData r101 = this.mScrap.get(r100);
            if (r101 != null) goto L5;
            return null;
        L5:
            if (r101.mScrapHeap.isEmpty() == true) goto L17;
            ArrayList<ViewHolder> r102 = r101.mScrapHeap;
            int r103 = r102.size() - 1;
        L7:
            if (r103 < 0) goto L18;
            if (((ViewHolder) ListProtector.get(r102, r103)).isAttachedToTransitionOverlay() == false) goto L11;
            r103 = r103 - 1;
            goto L7
        L11:
            return (ViewHolder) ListProtector.remove(r102, r103);
        L18:
            return null;
        L17:
            return null;
        }

        public int getRecycledViewCount(int r100) {
            return getScrapDataForType(r100).mScrapHeap.size();
        }

        public void putRecycledView(ViewHolder r100) {
            int r101 = r100.getItemViewType();
            ArrayList<ViewHolder> r102 = getScrapDataForType(r101).mScrapHeap;
            if (this.mScrap.get(r101).mMaxScrap > r102.size()) goto L5;
            return;
        L5:
            r100.resetInternal();
            r102.add(r100);
        }

        public void factorInBindTime(int r100, long r101) {
            ScrapData r102 = getScrapDataForType(r100);
            r102.mBindRunningAverageNs = runningAverage(r102.mBindRunningAverageNs, r101);
        }

        public void factorInCreateTime(int r100, long r101) {
            ScrapData r102 = getScrapDataForType(r100);
            r102.mCreateRunningAverageNs = runningAverage(r102.mCreateRunningAverageNs, r101);
        }

        public long runningAverage(long r100, long r101) {
            if (r100 != 0) goto L6;
            return r101;
        L6:
            return ((r100 / 4) * 3) + (r101 / 4);
        }

        public void setMaxRecycledViews(int r100, int r101) {
            ScrapData r102 = getScrapDataForType(r100);
            r102.mMaxScrap = r101;
            ArrayList<ViewHolder> r103 = r102.mScrapHeap;
        L4:
            if (r103.size() <= r101) goto L6;
            ListProtector.remove(r103, r103.size() - 1);
            goto L4
        }

        public void onAdapterChanged(Adapter r100, Adapter r101, boolean r102) {
            if (r100 == null) goto L4;
            detach();
        L4:
            if (r102 == false) goto L6;
        L8:
            if (r101 == null) goto L11;
            attach();
            return;
        L11:
            return;
        L6:
            if (this.mAttachCount != 0) goto L8;
            clear();
            goto L8
        }

        public boolean willBindInTime(int r100, long r101, long r102) {
            long r103 = getScrapDataForType(r100).mBindRunningAverageNs;
            if (r103 != 0) goto L5;
        L8:
            return true;
        L5:
            if ((r101 + r103) < r102) goto L8;
            return false;
        }

        public boolean willCreateInTime(int r100, long r101, long r102) {
            long r103 = getScrapDataForType(r100).mCreateRunningAverageNs;
            if (r103 != 0) goto L5;
        L8:
            return true;
        L5:
            if ((r101 + r103) < r102) goto L8;
            return false;
        }
    }

    public final class Recycler {
        static final int DEFAULT_CACHE_SIZE = 2;
        final ArrayList<ViewHolder> mAttachedScrap;
        final ArrayList<ViewHolder> mCachedViews;
        ArrayList<ViewHolder> mChangedScrap;
        RecycledViewPool mRecyclerPool;
        private int mRequestedCacheMax;
        private final List<ViewHolder> mUnmodifiableAttachedScrap;
        private ViewCacheExtension mViewCacheExtension;
        int mViewCacheMax;
        final /* synthetic */ RecyclerView this$0;

        public void clear() {
            this.mAttachedScrap.clear();
            recycleAndClearCachedViews();
        }

        public void clearOldPositions() {
            int r100 = this.mCachedViews.size();
            int r101 = 0;
            int r102 = 0;
        L3:
            if (r102 >= r100) goto L5;
            ((ViewHolder) ListProtector.get(this.mCachedViews, r102)).clearOldPosition();
            r102 = r102 + 1;
            goto L3
        L5:
            int r103 = this.mAttachedScrap.size();
            int r104 = 0;
        L6:
            if (r104 >= r103) goto L8;
            ((ViewHolder) ListProtector.get(this.mAttachedScrap, r104)).clearOldPosition();
            r104 = r104 + 1;
            goto L6
        L8:
            ArrayList<ViewHolder> r105 = this.mChangedScrap;
            if (r105 == null) goto L13;
            int r106 = r105.size();
        L11:
            if (r101 >= r106) goto L17;
            ((ViewHolder) ListProtector.get(this.mChangedScrap, r101)).clearOldPosition();
            r101 = r101 + 1;
            goto L11
        L17:
            return;
        }

        public void clearScrap() {
            this.mAttachedScrap.clear();
            ArrayList<ViewHolder> r100 = this.mChangedScrap;
            if (r100 == null) goto L6;
            r100.clear();
            return;
        }

        public RecycledViewPool getRecycledViewPool() {
            if (this.mRecyclerPool != null) goto L6;
            this.mRecyclerPool = new RecycledViewPool();
        L6:
            return this.mRecyclerPool;
        }

        public int getScrapCount() {
            return this.mAttachedScrap.size();
        }

        public void markItemDecorInsetsDirty() {
            int r100 = this.mCachedViews.size();
            int r101 = 0;
        L3:
            if (r101 >= r100) goto L8;
            LayoutParams r102 = (LayoutParams) ((ViewHolder) ListProtector.get(this.mCachedViews, r101)).itemView.getLayoutParams();
            if (r102 == null) goto L7;
            r102.mInsetsDirty = true;
        L7:
            r101 = r101 + 1;
            goto L3
        }

        public void markKnownViewsInvalid() {
            int r100 = this.mCachedViews.size();
            int r101 = 0;
        L3:
            if (r101 >= r100) goto L8;
            ViewHolder r102 = (ViewHolder) ListProtector.get(this.mCachedViews, r101);
            if (r102 == null) goto L7;
            r102.addFlags(6);
            r102.addChangePayload(null);
        L7:
            r101 = r101 + 1;
            goto L3
        L8:
            Adapter r103 = this.this$0.mAdapter;
            if (r103 != null) goto L11;
        L12:
            recycleAndClearCachedViews();
            return;
        L11:
            if (r103.hasStableIds() == false) goto L12;
        }

        public void recycleAndClearCachedViews() {
            int r100 = this.mCachedViews.size() - 1;
        L3:
            if (r100 < 0) goto L5;
            recycleCachedViewAt(r100);
            r100 = r100 - 1;
            goto L3
        L5:
            this.mCachedViews.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L10;
            this.this$0.mPrefetchRegistry.clearPrefetchPositions();
            return;
        }

        public void updateViewCacheSize() {
            LayoutManager r100 = this.this$0.mLayout;
            if (r100 == null) goto L5;
            int r101 = r100.mPrefetchMaxCountObserved;
        L6:
            this.mViewCacheMax = this.mRequestedCacheMax + r101;
            int r102 = this.mCachedViews.size() - 1;
        L7:
            if (r102 < 0) goto L11;
            if (this.mCachedViews.size() <= this.mViewCacheMax) goto L14;
            recycleCachedViewAt(r102);
            r102 = r102 - 1;
            goto L7
        L14:
            return;
        L11:
            return;
        L5:
            r101 = 0;
            goto L6
        }

        public List<ViewHolder> getScrapList() {
            return this.mUnmodifiableAttachedScrap;
        }

        public Recycler(RecyclerView r100) {
            this.this$0 = r100;
            ArrayList<ViewHolder> r101 = new ArrayList();
            this.mAttachedScrap = r101;
            this.mChangedScrap = null;
            this.mCachedViews = new ArrayList();
            this.mUnmodifiableAttachedScrap = Collections.unmodifiableList(r101);
            this.mRequestedCacheMax = 2;
            this.mViewCacheMax = 2;
        }

        private void attachAccessibilityDelegateOnBind(ViewHolder r100) {
            if (this.this$0.isAccessibilityEnabled() == false) goto L15;
            View r101 = r100.itemView;
            if (ViewCompat.getImportantForAccessibility(r101) != 0) goto L7;
            ViewCompat.setImportantForAccessibility(r101, 1);
        L7:
            RecyclerViewAccessibilityDelegate r102 = this.this$0.mAccessibilityDelegate;
            if (r102 != null) goto L10;
            return;
        L10:
            AccessibilityDelegateCompat r103 = r102.getItemDelegate();
            if ((r103 instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) == false) goto L13;
            ((RecyclerViewAccessibilityDelegate.ItemDelegate) r103).saveOriginalDelegate(r101);
        L13:
            ViewCompat.setAccessibilityDelegate(r101, r103);
            return;
        }

        private void invalidateDisplayListInt(ViewHolder r100) {
            View r101 = r100.itemView;
            if ((r101 instanceof ViewGroup) == false) goto L6;
            invalidateDisplayListInt((ViewGroup) r101, false);
            return;
        }

        public int convertPreLayoutPositionToPostLayout(int r100) {
            if (r100 < 0) goto L11;
            if (r100 >= this.this$0.mState.getItemCount()) goto L11;
            if (this.this$0.mState.isPreLayout() == true) goto L9;
            return r100;
        L9:
            return this.this$0.mAdapterHelper.findPositionOffset(r100);
        L11:
            throw new IndexOutOfBoundsException("invalid position " + r100 + ". State item count is " + this.this$0.mState.getItemCount() + this.this$0.exceptionLabel());
        }

        public void dispatchViewRecycled(ViewHolder r100) {
            RecyclerListener r101 = this.this$0.mRecyclerListener;
            if (r101 == null) goto L5;
            r101.onViewRecycled(r100);
        L5:
            int r102 = this.this$0.mRecyclerListeners.size();
            int r103 = 0;
        L6:
            if (r103 >= r102) goto L8;
            ((RecyclerListener) ListProtector.get(this.this$0.mRecyclerListeners, r103)).onViewRecycled(r100);
            r103 = r103 + 1;
            goto L6
        L8:
            Adapter r104 = this.this$0.mAdapter;
            if (r104 == null) goto L11;
            r104.onViewRecycled(r100);
        L11:
            RecyclerView r105 = this.this$0;
            if (r105.mState == null) goto L16;
            r105.mViewInfoStore.removeViewHolder(r100);
            return;
        }

        public ViewHolder getChangedScrapViewForPosition(int r110) {
            ArrayList<ViewHolder> r100 = this.mChangedScrap;
            if (r100 == null) goto L32;
            int r101 = r100.size();
            if (r101 == 0) goto L32;
            int r102 = 0;
            int r103 = 0;
        L9:
            if (r103 >= r101) goto L18;
            ViewHolder r104 = (ViewHolder) ListProtector.get(this.mChangedScrap, r103);
            if (r104.wasReturnedFromScrap() == true) goto L16;
            if (r104.getLayoutPosition() != r110) goto L16;
            r104.addFlags(32);
            return r104;
        L16:
            r103 = r103 + 1;
            goto L9
        L18:
            if (this.this$0.mAdapter.hasStableIds() == false) goto L32;
            int r111 = this.this$0.mAdapterHelper.findPositionOffset(r110);
            if (r111 <= 0) goto L32;
            if (r111 >= this.this$0.mAdapter.getItemCount()) goto L32;
            long r105 = this.this$0.mAdapter.getItemId(r111);
        L24:
            if (r102 >= r101) goto L32;
            ViewHolder r112 = (ViewHolder) ListProtector.get(this.mChangedScrap, r102);
            if (r112.wasReturnedFromScrap() == true) goto L31;
            if (r112.getItemId() != r105) goto L31;
            r112.addFlags(32);
            return r112;
        L31:
            r102 = r102 + 1;
        L32:
            return null;
        }

        public View getScrapViewAt(int r100) {
            return ((ViewHolder) ListProtector.get(this.mAttachedScrap, r100)).itemView;
        }

        public View getViewForPosition(int r100) {
            return getViewForPosition(r100, false);
        }

        public void quickRecycleScrapView(View r100) {
            ViewHolder r101 = RecyclerView.getChildViewHolderInt(r100);
            r101.mScrapContainer = null;
            r101.mInChangeScrap = false;
            r101.clearReturnedFromScrapFlag();
            recycleViewHolderInternal(r101);
        }

        public void recycleCachedViewAt(int r100) {
            addViewHolderToRecycledViewPool((ViewHolder) ListProtector.get(this.mCachedViews, r100), true);
            ListProtector.remove(this.mCachedViews, r100);
        }

        public void recycleView(View r100) {
            ViewHolder r101 = RecyclerView.getChildViewHolderInt(r100);
            if (r101.isTmpDetached() == false) goto L6;
            this.this$0.removeDetachedView(r100, false);
        L6:
            if (r101.isScrap() == false) goto L9;
            r101.unScrap();
        L11:
            recycleViewHolderInternal(r101);
            if (this.this$0.mItemAnimator != null) goto L14;
            return;
        L14:
            if (r101.isRecyclable() == true) goto L18;
            this.this$0.mItemAnimator.endAnimation(r101);
            return;
        L18:
            return;
        L9:
            if (r101.wasReturnedFromScrap() == false) goto L11;
            r101.clearReturnedFromScrapFlag();
            goto L11
        }

        public void recycleViewHolderInternal(ViewHolder r100) {
            boolean r101 = false;
            boolean r102 = true;
            if (r100.isScrap() == false) goto L5;
        L58:
            StringBuilder r103 = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:");
            r103.append(r100.isScrap());
            r103.append(" isAttached:");
            if (r100.itemView.getParent() == null) goto L61;
            r101 = true;
        L61:
            r103.append(r101);
            r103.append(this.this$0.exceptionLabel());
            throw new IllegalArgumentException(r103.toString());
        L5:
            if (r100.itemView.getParent() != null) goto L58;
            if (r100.isTmpDetached() == true) goto L57;
            if (r100.shouldIgnore() == true) goto L55;
            boolean r104 = r100.doesTransientStatePreventRecycling();
            Adapter r105 = this.this$0.mAdapter;
            if (r105 == null) goto L17;
            if (r104 == false) goto L17;
            if (r105.onFailedToRecycleView(r100) == false) goto L17;
            boolean r106 = true;
        L18:
            if (r106 == true) goto L24;
            if (r100.isRecyclable() == true) goto L24;
        L22:
            r102 = false;
        L48:
            this.this$0.mViewInfoStore.removeViewHolder(r100);
            if (r101 == true) goto L65;
            if (r102 == true) goto L66;
            if (r104 == false) goto L67;
            r100.mBindingAdapter = null;
            r100.mOwnerRecyclerView = null;
            return;
        L67:
            return;
        L66:
            return;
        L65:
            return;
        L24:
            if (this.mViewCacheMax > 0) goto L26;
        L44:
            boolean r107 = false;
        L45:
            if (r107 == true) goto L47;
            addViewHolderToRecycledViewPool(r100, true);
            r101 = r107;
            goto L48
        L47:
            r101 = r107;
            goto L22
        L26:
            if (r100.hasAnyOfTheFlags(526) == true) goto L44;
            int r108 = this.mCachedViews.size();
            if (r108 < this.mViewCacheMax) goto L32;
            if (r108 <= 0) goto L32;
            recycleCachedViewAt(0);
            r108 = r108 - 1;
        L32:
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L43;
            if (r108 <= 0) goto L43;
            if (this.this$0.mPrefetchRegistry.lastPrefetchIncludedPosition(r100.mPosition) == true) goto L43;
            int r109 = r108 - 1;
        L37:
            if (r109 < 0) goto L42;
            if (this.this$0.mPrefetchRegistry.lastPrefetchIncludedPosition(((ViewHolder) ListProtector.get(this.mCachedViews, r109)).mPosition) == false) goto L42;
            r109 = r109 - 1;
        L42:
            r108 = r109 + 1;
        L43:
            ListProtector.add(this.mCachedViews, r108, r100);
            r107 = true;
        L17:
            r106 = false;
            goto L18
        L55:
            throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + this.this$0.exceptionLabel());
        L57:
            throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + r100 + this.this$0.exceptionLabel());
        }

        public void scrapView(View r100) {
            ViewHolder r101 = RecyclerView.getChildViewHolderInt(r100);
            if (r101.hasAnyOfTheFlags(12) == true) goto L14;
            if (r101.isUpdated() == false) goto L14;
            if (this.this$0.canReuseUpdatedViewHolder(r101) == true) goto L14;
            if (this.mChangedScrap != null) goto L12;
            this.mChangedScrap = new ArrayList();
        L12:
            r101.setScrapContainer(this, true);
            this.mChangedScrap.add(r101);
            return;
        L14:
            if (r101.isInvalid() == true) goto L16;
        L22:
            r101.setScrapContainer(this, false);
            this.mAttachedScrap.add(r101);
            return;
        L16:
            if (r101.isRemoved() == true) goto L22;
            if (this.this$0.mAdapter.hasStableIds() == true) goto L22;
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + this.this$0.exceptionLabel());
        }

        public void setRecycledViewPool(RecycledViewPool r100) {
            RecycledViewPool r101 = this.mRecyclerPool;
            if (r101 == null) goto L5;
            r101.detach();
        L5:
            this.mRecyclerPool = r100;
            if (r100 != null) goto L8;
            return;
        L8:
            if (this.this$0.getAdapter() == null) goto L12;
            this.mRecyclerPool.attach();
            return;
        }

        public void setViewCacheExtension(ViewCacheExtension r100) {
            this.mViewCacheExtension = r100;
        }

        public void setViewCacheSize(int r100) {
            this.mRequestedCacheMax = r100;
            updateViewCacheSize();
        }

        public void unscrapView(ViewHolder r100) {
            if (r100.mInChangeScrap == false) goto L5;
            this.mChangedScrap.remove(r100);
        L6:
            r100.mScrapContainer = null;
            r100.mInChangeScrap = false;
            r100.clearReturnedFromScrapFlag();
            return;
        L5:
            this.mAttachedScrap.remove(r100);
            goto L6
        }

        public boolean validateViewHolderForOffsetPosition(ViewHolder r100) {
            if (r100.isRemoved() == true) goto L5;
            int r101 = r100.mPosition;
            if (r101 < 0) goto L23;
            if (r101 >= this.this$0.mAdapter.getItemCount()) goto L23;
            if (this.this$0.mState.isPreLayout() == true) goto L16;
            if (this.this$0.mAdapter.getItemViewType(r100.mPosition) == r100.getItemViewType()) goto L16;
            return false;
        L16:
            if (this.this$0.mAdapter.hasStableIds() == true) goto L18;
            return true;
        L18:
            if (r100.getItemId() != this.this$0.mAdapter.getItemId(r100.mPosition)) goto L24;
            return true;
        L24:
            return false;
        L23:
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + r100 + this.this$0.exceptionLabel());
        L5:
            return this.this$0.mState.isPreLayout();
        }

        private void invalidateDisplayListInt(ViewGroup r100, boolean r101) {
            int r102 = r100.getChildCount() - 1;
        L3:
            if (r102 < 0) goto L8;
            View r103 = r100.getChildAt(r102);
            if ((r103 instanceof ViewGroup) == false) goto L7;
            invalidateDisplayListInt((ViewGroup) r103, true);
        L7:
            r102 = r102 - 1;
            goto L3
        L8:
            if (r101 == true) goto L11;
            return;
        L11:
            if (r100.getVisibility() != 4) goto L13;
            r100.setVisibility(0);
            r100.setVisibility(4);
            return;
        L13:
            int r104 = r100.getVisibility();
            r100.setVisibility(4);
            r100.setVisibility(r104);
        }

        public void addViewHolderToRecycledViewPool(ViewHolder r100, boolean r101) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(r100);
            View r102 = r100.itemView;
            RecyclerViewAccessibilityDelegate r103 = this.this$0.mAccessibilityDelegate;
            if (r103 == null) goto L9;
            AccessibilityDelegateCompat r104 = r103.getItemDelegate();
            if ((r104 instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) == false) goto L7;
            AccessibilityDelegateCompat r105 = ((RecyclerViewAccessibilityDelegate.ItemDelegate) r104).getAndRemoveOriginalDelegateForItem(r102);
        L8:
            ViewCompat.setAccessibilityDelegate(r102, r105);
            goto L9
        L7:
            r105 = null;
        L9:
            if (r101 == false) goto L11;
            dispatchViewRecycled(r100);
        L11:
            r100.mBindingAdapter = null;
            r100.mOwnerRecyclerView = null;
            getRecycledViewPool().putRecycledView(r100);
        }

        public void bindViewToPosition(View r100, int r101) {
            ViewHolder r102 = RecyclerView.getChildViewHolderInt(r100);
            if (r102 == null) goto L24;
            int r103 = this.this$0.mAdapterHelper.findPositionOffset(r101);
            if (r103 < 0) goto L22;
            if (r103 >= this.this$0.mAdapter.getItemCount()) goto L22;
            tryBindViewHolderByDeadline(r102, r103, r101, Long.MAX_VALUE);
            ViewGroup.LayoutParams r104 = r102.itemView.getLayoutParams();
            if (r104 != null) goto L12;
            LayoutParams r105 = (LayoutParams) this.this$0.generateDefaultLayoutParams();
            r102.itemView.setLayoutParams(r105);
        L15:
            boolean r106 = true;
            r105.mInsetsDirty = true;
            r105.mViewHolder = r102;
            if (r102.itemView.getParent() == null) goto L19;
            r106 = false;
        L19:
            r105.mPendingInvalidate = r106;
            return;
        L12:
            if (this.this$0.checkLayoutParams(r104) == true) goto L14;
            r105 = (LayoutParams) this.this$0.generateLayoutParams(r104);
            r102.itemView.setLayoutParams(r105);
            goto L15
        L14:
            r105 = (LayoutParams) r104;
        L22:
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + r101 + "(offset:" + r103 + ").state:" + this.this$0.mState.getItemCount() + this.this$0.exceptionLabel());
        L24:
            throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter" + this.this$0.exceptionLabel());
        }

        public ViewHolder getScrapOrHiddenOrCachedHolderForPosition(int r100, boolean r101) {
            int r102 = this.mAttachedScrap.size();
            int r103 = 0;
            int r104 = 0;
        L3:
            if (r104 >= r102) goto L17;
            ViewHolder r105 = (ViewHolder) ListProtector.get(this.mAttachedScrap, r104);
            if (r105.wasReturnedFromScrap() == true) goto L16;
            if (r105.getLayoutPosition() != r100) goto L16;
            if (r105.isInvalid() == true) goto L16;
            if (this.this$0.mState.mInPreLayout == true) goto L14;
            if (r105.isRemoved() == true) goto L16;
        L14:
            r105.addFlags(32);
            return r105;
        L16:
            r104 = r104 + 1;
            goto L3
        L17:
            if (r101 == true) goto L26;
            View r106 = this.this$0.mChildHelper.findHiddenNonRemovedView(r100);
            if (r106 == null) goto L26;
            ViewHolder r107 = RecyclerView.getChildViewHolderInt(r106);
            this.this$0.mChildHelper.unhide(r106);
            int r108 = this.this$0.mChildHelper.indexOfChild(r106);
            if (r108 == (-1)) goto L25;
            this.this$0.mChildHelper.detachViewFromParent(r108);
            scrapView(r106);
            r107.addFlags(AVMDLDataLoader.KeyIsEnableSpeedEngine);
            return r107;
        L25:
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + r107 + this.this$0.exceptionLabel());
        L26:
            int r109 = this.mCachedViews.size();
        L27:
            if (r103 >= r109) goto L38;
            ViewHolder r110 = (ViewHolder) ListProtector.get(this.mCachedViews, r103);
            if (r110.isInvalid() == true) goto L37;
            if (r110.getLayoutPosition() != r100) goto L37;
            if (r110.isAttachedToTransitionOverlay() == true) goto L37;
            if (r101 == true) goto L36;
            ListProtector.remove(this.mCachedViews, r103);
        L36:
            return r110;
        L37:
            r103 = r103 + 1;
            goto L27
        L38:
            return null;
        }

        public View getViewForPosition(int r100, boolean r101) {
            return tryGetViewHolderForPositionByDeadline(r100, r101, Long.MAX_VALUE).itemView;
        }

        public void offsetPositionRecordsForInsert(int r100, int r101) {
            int r102 = this.mCachedViews.size();
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L10;
            ViewHolder r104 = (ViewHolder) ListProtector.get(this.mCachedViews, r103);
            if (r104 == null) goto L9;
            if (r104.mPosition < r100) goto L9;
            r104.offsetPosition(r101, false);
        L9:
            r103 = r103 + 1;
            goto L3
        }

        public void offsetPositionRecordsForMove(int r100, int r110) {
            if (r100 >= r110) goto L4;
            int r101 = -1;
            int r102 = r100;
            int r103 = r110;
        L5:
            int r104 = this.mCachedViews.size();
            int r105 = 0;
        L6:
            if (r105 >= r104) goto L17;
            ViewHolder r106 = (ViewHolder) ListProtector.get(this.mCachedViews, r105);
            if (r106 == null) goto L16;
            int r107 = r106.mPosition;
            if (r107 < r102) goto L16;
            if (r107 > r103) goto L16;
            if (r107 != r100) goto L15;
            r106.offsetPosition(r110 - r100, false);
            goto L16
        L15:
            r106.offsetPosition(r101, false);
        L16:
            r105 = r105 + 1;
            goto L6
        L17:
            return;
        L4:
            r101 = 1;
            r103 = r100;
            r102 = r110;
            goto L5
        }

        public void viewRangeUpdate(int r100, int r101) {
            int r102 = r101 + r100;
            int r103 = this.mCachedViews.size() - 1;
        L3:
            if (r103 < 0) goto L12;
            ViewHolder r104 = (ViewHolder) ListProtector.get(this.mCachedViews, r103);
            if (r104 == null) goto L11;
            int r105 = r104.mPosition;
            if (r105 < r100) goto L11;
            if (r105 >= r102) goto L11;
            r104.addFlags(2);
            recycleCachedViewAt(r103);
        L11:
            r103 = r103 - 1;
            goto L3
        }

        public ViewHolder getScrapOrCachedViewForId(long r100, int r101, boolean r110) {
            int r102 = this.mAttachedScrap.size() - 1;
        L3:
            if (r102 < 0) goto L19;
            ViewHolder r103 = (ViewHolder) ListProtector.get(this.mAttachedScrap, r102);
            if (r103.getItemId() != r100) goto L18;
            if (r103.wasReturnedFromScrap() == true) goto L18;
            if (r101 == r103.getItemViewType()) goto L10;
            if (r110 == true) goto L18;
            ListProtector.remove(this.mAttachedScrap, r102);
            this.this$0.removeDetachedView(r103.itemView, false);
            quickRecycleScrapView(r103.itemView);
            goto L18
        L10:
            r103.addFlags(32);
            if (r103.isRemoved() == true) goto L13;
        L15:
            return r103;
        L13:
            if (this.this$0.mState.isPreLayout() == true) goto L15;
            r103.setFlags(2, 14);
        L18:
            r102 = r102 - 1;
            goto L3
        L19:
            int r104 = this.mCachedViews.size();
        L20:
            r104 = r104 - 1;
            if (r104 < 0) goto L35;
            ViewHolder r105 = (ViewHolder) ListProtector.get(this.mCachedViews, r104);
            if (r105.getItemId() != r100) goto L20;
            if (r105.isAttachedToTransitionOverlay() == true) goto L20;
            if (r101 == r105.getItemViewType()) goto L28;
            if (r110 == true) goto L20;
            recycleCachedViewAt(r104);
            return null;
        L28:
            if (r110 == true) goto L30;
            ListProtector.remove(this.mCachedViews, r104);
        L30:
            return r105;
        L35:
            return null;
        }

        public void offsetPositionRecordsForRemove(int r100, int r101, boolean r102) {
            int r103 = r100 + r101;
            int r104 = this.mCachedViews.size() - 1;
        L3:
            if (r104 < 0) goto L12;
            ViewHolder r105 = (ViewHolder) ListProtector.get(this.mCachedViews, r104);
            if (r105 == null) goto L11;
            int r106 = r105.mPosition;
            if (r106 < r103) goto L9;
            r105.offsetPosition(-r101, r102);
            goto L11
        L9:
            if (r106 < r100) goto L11;
            r105.addFlags(8);
            recycleCachedViewAt(r104);
        L11:
            r104 = r104 - 1;
            goto L3
        }

        public void onAdapterChanged(Adapter r100, Adapter r101, boolean r102) {
            clear();
            getRecycledViewPool().onAdapterChanged(r100, r101, r102);
        }

        public ViewHolder tryGetViewHolderForPositionByDeadline(int r110, boolean r111, long r112) {
            if (r110 < 0) goto L112;
            if (r110 >= this.this$0.mState.getItemCount()) goto L112;
            boolean r100 = true;
            if (this.this$0.mState.isPreLayout() == false) goto L11;
            ViewHolder r101 = getChangedScrapViewForPosition(r110);
            if (r101 == null) goto L12;
            boolean r102 = true;
        L13:
            if (r101 != null) goto L28;
            r101 = getScrapOrHiddenOrCachedHolderForPosition(r110, r111);
            if (r101 == null) goto L28;
            if (validateViewHolderForOffsetPosition(r101) == true) goto L27;
            if (r111 == true) goto L26;
            r101.addFlags(4);
            if (r101.isScrap() == false) goto L23;
            this.this$0.removeDetachedView(r101.itemView, false);
            r101.unScrap();
        L25:
            recycleViewHolderInternal(r101);
            goto L26
        L23:
            if (r101.wasReturnedFromScrap() == false) goto L25;
            r101.clearReturnedFromScrapFlag();
        L26:
            r101 = null;
            goto L28
        L27:
            r102 = true;
        L28:
            if (r101 != null) goto L73;
            int r103 = this.this$0.mAdapterHelper.findPositionOffset(r110);
            if (r103 < 0) goto L72;
            if (r103 >= this.this$0.mAdapter.getItemCount()) goto L72;
            int r104 = this.this$0.mAdapter.getItemViewType(r103);
            if (this.this$0.mAdapter.hasStableIds() == false) goto L38;
            r101 = getScrapOrCachedViewForId(this.this$0.mAdapter.getItemId(r103), r104, r111);
            if (r101 == null) goto L38;
            r101.mPosition = r103;
            r102 = true;
        L38:
            if (r101 != null) goto L52;
            ViewCacheExtension r105 = this.mViewCacheExtension;
            if (r105 == null) goto L52;
            View r106 = r105.getViewForPositionAndType(this, r110, r104);
            if (r106 == null) goto L52;
            r101 = this.this$0.getChildViewHolder(r106);
            if (r101 == null) goto L51;
            if (r101.shouldIgnore() == false) goto L52;
            throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + this.this$0.exceptionLabel());
        L51:
            throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + this.this$0.exceptionLabel());
        L52:
            if (r101 != null) goto L59;
            ViewHolder r107 = getRecycledViewPool().getRecycledView(r104);
            if (r107 == null) goto L58;
            r107.resetInternal();
            if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST == false) goto L58;
            invalidateDisplayListInt(r107);
        L58:
            r101 = r107;
        L59:
            if (r101 != null) goto L73;
            long r108 = this.this$0.getNanoTime();
            if (r112 != Long.MAX_VALUE) goto L63;
        L65:
            RecyclerView r109 = this.this$0;
            ViewHolder r113 = r109.mAdapter.createViewHolder(r109, r104);
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L70;
            RecyclerView r114 = RecyclerView.findNestedRecyclerView(r113.itemView);
            if (r114 == null) goto L70;
            r113.mNestedRecyclerView = new WeakReference(r114);
        L70:
            this.mRecyclerPool.factorInCreateTime(r104, this.this$0.getNanoTime() - r108);
            ViewHolder r115 = r113;
        L74:
            boolean r116 = r102;
            if (r116 == false) goto L84;
            if (this.this$0.mState.isPreLayout() == true) goto L84;
            if (r115.hasAnyOfTheFlags(8192) == false) goto L84;
            r115.setFlags(0, 8192);
            if (this.this$0.mState.mRunSimpleAnimations == false) goto L84;
            int r117 = ItemAnimator.buildAdapterChangeFlagsForAnimations(r115) | 4096;
            RecyclerView r118 = this.this$0;
            this.this$0.recordAnimationInfoIfBouncedHiddenView(r115, r118.mItemAnimator.recordPreLayoutInformation(r118.mState, r115, r117, r115.getUnmodifiedPayloads()));
        L84:
            if (this.this$0.mState.isPreLayout() == false) goto L89;
            if (r115.isBound() == false) goto L89;
            r115.mPreLayoutPosition = r110;
        L95:
            boolean r119 = false;
        L97:
            ViewGroup.LayoutParams r120 = r115.itemView.getLayoutParams();
            if (r120 != null) goto L101;
            LayoutParams r121 = (LayoutParams) this.this$0.generateDefaultLayoutParams();
            r115.itemView.setLayoutParams(r121);
        L104:
            r121.mViewHolder = r115;
            if (r116 == false) goto L108;
            if (r119 == false) goto L108;
        L109:
            r121.mPendingInvalidate = r100;
            return r115;
        L108:
            r100 = false;
            goto L109
        L101:
            if (this.this$0.checkLayoutParams(r120) == true) goto L103;
            r121 = (LayoutParams) this.this$0.generateLayoutParams(r120);
            r115.itemView.setLayoutParams(r121);
            goto L104
        L103:
            r121 = (LayoutParams) r120;
        L89:
            if (r115.isBound() == true) goto L91;
        L96:
            r119 = tryBindViewHolderByDeadline(r115, this.this$0.mAdapterHelper.findPositionOffset(r110), r110, r112);
            goto L97
        L91:
            if (r115.needsUpdate() == true) goto L96;
            if (r115.isInvalid() == false) goto L95;
        L63:
            if (this.mRecyclerPool.willCreateInTime(r104, r108, r112) == true) goto L65;
            return null;
        L72:
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + r110 + "(offset:" + r103 + ").state:" + this.this$0.mState.getItemCount() + this.this$0.exceptionLabel());
        L73:
            r115 = r101;
        L12:
            r102 = false;
            goto L13
        L11:
            r101 = null;
        L112:
            throw new IndexOutOfBoundsException("Invalid item position " + r110 + "(" + r110 + "). Item count:" + this.this$0.mState.getItemCount() + this.this$0.exceptionLabel());
        }

        private boolean tryBindViewHolderByDeadline(ViewHolder r110, int r111, int r112, long r113) {
            r110.mBindingAdapter = null;
            r110.mOwnerRecyclerView = this.this$0;
            int r100 = r110.getItemViewType();
            long r101 = this.this$0.getNanoTime();
            if (r113 != Long.MAX_VALUE) goto L5;
        L8:
            this.this$0.mAdapter.bindViewHolder(r110, r111);
            long r114 = this.this$0.getNanoTime();
            this.mRecyclerPool.factorInBindTime(r110.getItemViewType(), r114 - r101);
            attachAccessibilityDelegateOnBind(r110);
            if (this.this$0.mState.isPreLayout() == false) goto L13;
            r110.mPreLayoutPosition = r112;
            return true;
        L13:
            return true;
        L5:
            if (this.mRecyclerPool.willBindInTime(r100, r101, r113) == true) goto L8;
            return false;
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public interface RecyclerListener {
        void onViewRecycled(ViewHolder r100);
    }

    public class RecyclerViewDataObserver extends AdapterDataObserver {
        final /* synthetic */ RecyclerView this$0;

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            this.this$0.assertNotInLayoutOrScroll(null);
            RecyclerView r100 = this.this$0;
            r100.mState.mStructureChanged = true;
            r100.processDataSetCompletelyChanged(true);
            if (this.this$0.mAdapterHelper.hasPendingUpdates() == true) goto L6;
            this.this$0.requestLayout();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onStateRestorationPolicyChanged() {
            RecyclerView r100 = this.this$0;
            if (r100.mPendingSavedState != null) goto L5;
            return;
        L5:
            Adapter r101 = r100.mAdapter;
            if (r101 != null) goto L8;
            return;
        L8:
            if (r101.canRestoreState() == false) goto L12;
            this.this$0.requestLayout();
            return;
        }

        public void triggerUpdateProcessor() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION == false) goto L9;
            RecyclerView r100 = this.this$0;
            if (r100.mHasFixedSize == false) goto L9;
            if (r100.mIsAttached == false) goto L9;
            ViewCompat.postOnAnimation(r100, r100.mUpdateChildViewsRunnable);
            return;
        L9:
            RecyclerView r101 = this.this$0;
            r101.mAdapterUpdateDuringMeasure = true;
            r101.requestLayout();
        }

        public RecyclerViewDataObserver(RecyclerView r100) {
            this.this$0 = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int r100, int r101) {
            this.this$0.assertNotInLayoutOrScroll(null);
            if (this.this$0.mAdapterHelper.onItemRangeInserted(r100, r101) == false) goto L6;
            triggerUpdateProcessor();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int r100, int r101) {
            this.this$0.assertNotInLayoutOrScroll(null);
            if (this.this$0.mAdapterHelper.onItemRangeRemoved(r100, r101) == false) goto L6;
            triggerUpdateProcessor();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int r100, int r101, Object r102) {
            this.this$0.assertNotInLayoutOrScroll(null);
            if (this.this$0.mAdapterHelper.onItemRangeChanged(r100, r101, r102) == false) goto L6;
            triggerUpdateProcessor();
            return;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int r100, int r101, int r102) {
            this.this$0.assertNotInLayoutOrScroll(null);
            if (this.this$0.mAdapterHelper.onItemRangeMoved(r100, r101, r102) == false) goto L6;
            triggerUpdateProcessor();
            return;
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Parcelable mLayoutState;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(Parcelable r100) {
            super(r100);
        }

        public void copyFrom(SavedState r100) {
            this.mLayoutState = r100.mLayoutState;
        }

        public SavedState(Parcel r100, ClassLoader r101) {
            super(r100, r101);
            if (r101 != null) goto L6;
            r101 = LayoutManager.class.getClassLoader();
        L6:
            this.mLayoutState = r100.readParcelable(r101);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            super.writeToParcel(r100, r101);
            r100.writeParcelable(this.mLayoutState, 0);
        }
    }

    public static class SimpleOnItemTouchListener implements OnItemTouchListener {
        public SimpleOnItemTouchListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView r100, MotionEvent r101) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean r100) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView r100, MotionEvent r101) {
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static abstract class SmoothScroller {
        private LayoutManager mLayoutManager;
        private boolean mPendingInitialRun;
        private RecyclerView mRecyclerView;
        private final Action mRecyclingAction;
        private boolean mRunning;
        private boolean mStarted;
        private int mTargetPosition;
        private View mTargetView;

        public static class Action {
            public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
            private boolean mChanged;
            private int mConsecutiveUpdates;
            private int mDuration;
            private int mDx;
            private int mDy;
            private Interpolator mInterpolator;
            private int mJumpToPosition;

            private void validate() {
                if (this.mInterpolator == null) goto L10;
                if (this.mDuration >= 1) goto L10;
                throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
            L10:
                if (this.mDuration < 1) goto L13;
                return;
            L13:
                throw new IllegalStateException("Scroll duration must be a positive number");
            }

            public boolean hasJumpTarget() {
                if (this.mJumpToPosition < 0) goto L5;
                return true;
            L5:
                return false;
            }

            public int getDuration() {
                return this.mDuration;
            }

            public int getDx() {
                return this.mDx;
            }

            public int getDy() {
                return this.mDy;
            }

            public Interpolator getInterpolator() {
                return this.mInterpolator;
            }

            public void jumpTo(int r100) {
                this.mJumpToPosition = r100;
            }

            public void runIfNecessary(RecyclerView r100) {
                int r101 = this.mJumpToPosition;
                if (r101 < 0) goto L7;
                this.mJumpToPosition = -1;
                r100.jumpToPositionForSmoothScroller(r101);
                this.mChanged = false;
                return;
            L7:
                if (this.mChanged == false) goto L9;
                validate();
                r100.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator);
                this.mConsecutiveUpdates++;
                this.mChanged = false;
                return;
            L9:
                this.mConsecutiveUpdates = 0;
            }

            public void setDuration(int r100) {
                this.mChanged = true;
                this.mDuration = r100;
            }

            public void setDx(int r100) {
                this.mChanged = true;
                this.mDx = r100;
            }

            public void setDy(int r100) {
                this.mChanged = true;
                this.mDy = r100;
            }

            public void setInterpolator(Interpolator r100) {
                this.mChanged = true;
                this.mInterpolator = r100;
            }

            public Action(int r100, int r101) {
                this(r100, r101, Integer.MIN_VALUE, null);
            }

            public Action(int r100, int r101, int r102) {
                this(r100, r101, r102, null);
            }

            public Action(int r100, int r101, int r102, Interpolator r103) {
                this.mJumpToPosition = -1;
                this.mChanged = false;
                this.mConsecutiveUpdates = 0;
                this.mDx = r100;
                this.mDy = r101;
                this.mDuration = r102;
                this.mInterpolator = r103;
            }

            public void update(int r100, int r101, int r102, Interpolator r103) {
                this.mDx = r100;
                this.mDy = r101;
                this.mDuration = r102;
                this.mInterpolator = r103;
                this.mChanged = true;
            }
        }

        /* JADX INFO: loaded from: classes3.dex */
        public interface ScrollVectorProvider {
            PointF computeScrollVectorForPosition(int r100);
        }

        public abstract void onSeekTargetStep(int r100, int r101, State r102, Action r103);

        public abstract void onStart();

        public abstract void onStop();

        public abstract void onTargetFound(View r100, State r101, Action r102);

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public final void stop() {
            if (this.mRunning == true) goto L5;
            return;
        L5:
            this.mRunning = false;
            onStop();
            this.mRecyclerView.mState.mTargetPosition = -1;
            this.mTargetView = null;
            this.mTargetPosition = -1;
            this.mPendingInitialRun = false;
            this.mLayoutManager.onSmoothScrollerStopped(this);
            this.mLayoutManager = null;
            this.mRecyclerView = null;
        }

        public SmoothScroller() {
            this.mTargetPosition = -1;
            this.mRecyclingAction = new Action(0, 0);
        }

        public LayoutManager getLayoutManager() {
            return this.mLayoutManager;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public PointF computeScrollVectorForPosition(int r100) {
            Object r101 = getLayoutManager();
            if ((r101 instanceof ScrollVectorProvider) == false) goto L7;
            return ((ScrollVectorProvider) r101).computeScrollVectorForPosition(r100);
        L7:
            return null;
        }

        public View findViewByPosition(int r100) {
            return this.mRecyclerView.mLayout.findViewByPosition(r100);
        }

        public int getChildPosition(View r100) {
            return this.mRecyclerView.getChildLayoutPosition(r100);
        }

        public void instantScrollToPosition(int r100) {
            this.mRecyclerView.scrollToPosition(r100);
        }

        public void normalize(PointF r100) {
            float r101 = r100.x;
            float r102 = r100.y;
            float r103 = (float) Math.sqrt((r101 * r101) + (r102 * r102));
            r100.x /= r103;
            r100.y /= r103;
        }

        public void onChildAttachedToWindow(View r100) {
            if (getChildPosition(r100) != getTargetPosition()) goto L6;
            this.mTargetView = r100;
            return;
        }

        public void setTargetPosition(int r100) {
            this.mTargetPosition = r100;
        }

        public void onAnimation(int r100, int r101) {
            RecyclerView r102 = this.mRecyclerView;
            if (this.mTargetPosition == (-1)) goto L5;
            if (r102 == null) goto L5;
        L7:
            if (this.mPendingInitialRun == true) goto L9;
        L19:
            this.mPendingInitialRun = false;
            View r103 = this.mTargetView;
            if (r103 == null) goto L26;
            if (getChildPosition(r103) != this.mTargetPosition) goto L24;
            onTargetFound(this.mTargetView, r102.mState, this.mRecyclingAction);
            this.mRecyclingAction.runIfNecessary(r102);
            stop();
            goto L26
        L24:
            this.mTargetView = null;
        L26:
            if (this.mRunning == false) goto L33;
            onSeekTargetStep(r100, r101, r102.mState, this.mRecyclingAction);
            boolean r104 = this.mRecyclingAction.hasJumpTarget();
            this.mRecyclingAction.runIfNecessary(r102);
            if (r104 == true) goto L30;
            return;
        L30:
            if (this.mRunning == false) goto L35;
            this.mPendingInitialRun = true;
            r102.mViewFlinger.postOnAnimation();
            return;
        L35:
            return;
        L33:
            return;
        L9:
            if (this.mTargetView != null) goto L19;
            if (this.mLayoutManager == null) goto L19;
            PointF r105 = computeScrollVectorForPosition(this.mTargetPosition);
            if (r105 == null) goto L19;
            float r106 = r105.x;
            if (r106 == 0.0f) goto L17;
        L18:
            r102.scrollStep((int) Math.signum(r106), (int) Math.signum(r105.y), null);
            goto L19
        L17:
            if (r105.y == 0.0f) goto L19;
        L5:
            stop();
            goto L7
        }

        public void start(RecyclerView r100, LayoutManager r101) {
            r100.mViewFlinger.stop();
            if (this.mStarted == true) goto L5;
        L5:
            this.mRecyclerView = r100;
            this.mLayoutManager = r101;
            int r102 = this.mTargetPosition;
            if (r102 == (-1)) goto L10;
            r100.mState.mTargetPosition = r102;
            this.mRunning = true;
            this.mPendingInitialRun = true;
            this.mTargetView = findViewByPosition(getTargetPosition());
            onStart();
            this.mRecyclerView.mViewFlinger.postOnAnimation();
            this.mStarted = true;
            return;
        L10:
            throw new IllegalArgumentException("Invalid target position");
        }
    }

    public static class State {
        static final int STEP_ANIMATIONS = 4;
        static final int STEP_LAYOUT = 2;
        static final int STEP_START = 1;
        private SparseArray<Object> mData;
        int mDeletedInvisibleItemCountSincePreviousLayout;
        long mFocusedItemId;
        int mFocusedItemPosition;
        int mFocusedSubChildId;
        boolean mInPreLayout;
        boolean mIsMeasuring;
        int mItemCount;
        int mLayoutStep;
        int mPreviousLayoutItemCount;
        int mRemainingScrollHorizontal;
        int mRemainingScrollVertical;
        boolean mRunPredictiveAnimations;
        boolean mRunSimpleAnimations;
        boolean mStructureChanged;
        int mTargetPosition;
        boolean mTrackOldChangeHolders;

        public int getItemCount() {
            if (this.mInPreLayout == false) goto L6;
            return this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout;
        L6:
            return this.mItemCount;
        }

        public boolean hasTargetScrollPosition() {
            if (this.mTargetPosition == (-1)) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.mTargetPosition + ", mData=" + this.mData + ", mItemCount=" + this.mItemCount + ", mIsMeasuring=" + this.mIsMeasuring + ", mPreviousLayoutItemCount=" + this.mPreviousLayoutItemCount + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.mDeletedInvisibleItemCountSincePreviousLayout + ", mStructureChanged=" + this.mStructureChanged + ", mInPreLayout=" + this.mInPreLayout + ", mRunSimpleAnimations=" + this.mRunSimpleAnimations + ", mRunPredictiveAnimations=" + this.mRunPredictiveAnimations + '}';
        }

        public State() {
            this.mTargetPosition = -1;
            this.mPreviousLayoutItemCount = 0;
            this.mDeletedInvisibleItemCountSincePreviousLayout = 0;
            this.mLayoutStep = 1;
            this.mItemCount = 0;
            this.mStructureChanged = false;
            this.mInPreLayout = false;
            this.mTrackOldChangeHolders = false;
            this.mIsMeasuring = false;
            this.mRunSimpleAnimations = false;
            this.mRunPredictiveAnimations = false;
        }

        public boolean didStructureChange() {
            return this.mStructureChanged;
        }

        public int getRemainingScrollHorizontal() {
            return this.mRemainingScrollHorizontal;
        }

        public int getRemainingScrollVertical() {
            return this.mRemainingScrollVertical;
        }

        public int getTargetScrollPosition() {
            return this.mTargetPosition;
        }

        public boolean isMeasuring() {
            return this.mIsMeasuring;
        }

        public boolean isPreLayout() {
            return this.mInPreLayout;
        }

        public boolean willRunPredictiveAnimations() {
            return this.mRunPredictiveAnimations;
        }

        public boolean willRunSimpleAnimations() {
            return this.mRunSimpleAnimations;
        }

        public void assertLayoutStep(int r100) {
            if ((this.mLayoutStep & r100) == 0) goto L6;
            return;
        L6:
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(r100) + " but it is " + Integer.toBinaryString(this.mLayoutStep));
        }

        public <T> T get(int r100) {
            SparseArray<Object> r101 = this.mData;
            if (r101 != null) goto L7;
            return null;
        L7:
            return (T) r101.get(r100);
        }

        public void prepareForNestedPrefetch(Adapter r100) {
            this.mLayoutStep = 1;
            this.mItemCount = r100.getItemCount();
            this.mInPreLayout = false;
            this.mTrackOldChangeHolders = false;
            this.mIsMeasuring = false;
        }

        public void remove(int r100) {
            SparseArray<Object> r101 = this.mData;
            if (r101 != null) goto L5;
            return;
        L5:
            r101.remove(r100);
        }

        public void put(int r100, Object r101) {
            if (this.mData != null) goto L5;
            this.mData = new SparseArray();
        L5:
            this.mData.put(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static abstract class ViewCacheExtension {
        public ViewCacheExtension() {
        }

        public abstract View getViewForPositionAndType(Recycler r100, int r101, int r102);
    }

    public class ViewFlinger implements Runnable {
        private boolean mEatRunOnAnimationRequest;
        Interpolator mInterpolator;
        private int mLastFlingX;
        private int mLastFlingY;
        OverScroller mOverScroller;
        private boolean mReSchedulePostAnimationCallback;
        final /* synthetic */ RecyclerView this$0;

        @Override // java.lang.Runnable
        public void run() {
            androidx_recyclerview_widget_RecyclerView$ViewFlinger_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        private void internalPostOnAnimation() {
            this.this$0.removeCallbacks(this);
            ViewCompat.postOnAnimation(this.this$0, this);
        }

        public void androidx_recyclerview_widget_RecyclerView$ViewFlinger__run$___twin___() {
            RecyclerView r100 = this.this$0;
            if (r100.mLayout != null) goto L6;
            stop();
            return;
        L6:
            this.mReSchedulePostAnimationCallback = false;
            this.mEatRunOnAnimationRequest = true;
            r100.consumePendingUpdateOperations();
            OverScroller r101 = this.mOverScroller;
            if (r101.computeScrollOffset() == false) goto L85;
            int r102 = r101.getCurrX();
            int r103 = r101.getCurrY();
            int r104 = r102 - this.mLastFlingX;
            int r110 = r103 - this.mLastFlingY;
            this.mLastFlingX = r102;
            this.mLastFlingY = r103;
            RecyclerView r105 = this.this$0;
            int[] r111 = r105.mReusableIntPair;
            r111[0] = 0;
            r111[1] = 0;
            if (r105.dispatchNestedPreScroll(r104, r110, r111, null, 1) == false) goto L12;
            int[] r106 = this.this$0.mReusableIntPair;
            r104 = r104 - r106[0];
            r110 = r110 - r106[1];
        L12:
            if (this.this$0.getOverScrollMode() == 2) goto L14;
            this.this$0.considerReleasingGlowsOnScroll(r104, r110);
        L14:
            RecyclerView r107 = this.this$0;
            if (r107.mAdapter == null) goto L29;
            int[] r108 = r107.mReusableIntPair;
            r108[0] = 0;
            r108[1] = 0;
            r107.scrollStep(r104, r110, r108);
            RecyclerView r109 = this.this$0;
            int[] r112 = r109.mReusableIntPair;
            int r113 = r112[0];
            int r114 = r112[1];
            r104 = r104 - r113;
            r110 = r110 - r114;
            SmoothScroller r115 = r109.mLayout.mSmoothScroller;
            if (r115 == null) goto L31;
            if (r115.isPendingInitialRun() == true) goto L31;
            if (r115.isRunning() == false) goto L31;
            int r116 = this.this$0.mState.getItemCount();
            if (r116 != 0) goto L26;
            r115.stop();
            goto L31
        L26:
            if (r115.getTargetPosition() < r116) goto L28;
            r115.setTargetPosition(r116 - 1);
            r115.onAnimation(r113, r114);
            goto L31
        L28:
            r115.onAnimation(r113, r114);
        L31:
            if (this.this$0.mItemDecorations.isEmpty() == true) goto L33;
            this.this$0.invalidate();
        L33:
            RecyclerView r117 = this.this$0;
            int[] r118 = r117.mReusableIntPair;
            r118[0] = 0;
            r118[1] = 0;
            r117.dispatchNestedScroll(r113, r114, r104, r110, null, 1, r118);
            RecyclerView r119 = this.this$0;
            int[] r120 = r119.mReusableIntPair;
            int r121 = r104 - r120[0];
            int r122 = r110 - r120[1];
            if (r113 != 0) goto L36;
            if (r114 != 0) goto L36;
        L38:
            if (RecyclerView.access$200(this.this$0) == true) goto L41;
            this.this$0.invalidate();
        L41:
            if (r101.getCurrX() != r101.getFinalX()) goto L43;
            boolean r123 = true;
        L45:
            if (r101.getCurrY() != r101.getFinalY()) goto L47;
            boolean r124 = true;
        L49:
            if (r101.isFinished() == true) goto L56;
            if (r123 == true) goto L52;
            if (r121 != 0) goto L52;
        L55:
            boolean r125 = false;
        L57:
            SmoothScroller r126 = this.this$0.mLayout.mSmoothScroller;
            if (r126 != null) goto L60;
        L62:
            boolean r127 = false;
        L63:
            if (r127 == true) goto L82;
            if (r125 == false) goto L82;
            if (this.this$0.getOverScrollMode() == 2) goto L80;
            int r128 = (int) r101.getCurrVelocity();
            if (r121 >= 0) goto L70;
            int r129 = -r128;
        L73:
            if (r122 >= 0) goto L75;
            r128 = -r128;
        L78:
            this.this$0.absorbGlows(r129, r128);
            goto L80
        L75:
            if (r122 > 0) goto L78;
            r128 = 0;
            goto L78
        L70:
            if (r121 <= 0) goto L72;
            r129 = r128;
            goto L73
        L72:
            r129 = 0;
        L80:
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L85;
            this.this$0.mPrefetchRegistry.clearPrefetchPositions();
        L82:
            postOnAnimation();
            RecyclerView r130 = this.this$0;
            GapWorker r131 = r130.mGapWorker;
            if (r131 == null) goto L85;
            r131.postFromTraversal(r130, r113, r114);
            goto L85
        L60:
            if (r126.isPendingInitialRun() == false) goto L62;
            r127 = true;
        L52:
            if (r124 == true) goto L56;
            if (r122 == 0) goto L55;
        L56:
            r125 = true;
            goto L57
        L47:
            r124 = false;
            goto L49
        L43:
            r123 = false;
        L36:
            r119.dispatchOnScrolled(r113, r114);
            goto L38
        L29:
            r114 = 0;
            r113 = 0;
        L85:
            SmoothScroller r132 = this.this$0.mLayout.mSmoothScroller;
            if (r132 != null) goto L88;
        L90:
            this.mEatRunOnAnimationRequest = false;
            if (this.mReSchedulePostAnimationCallback == false) goto L93;
            internalPostOnAnimation();
            return;
        L93:
            this.this$0.setScrollState(0);
            this.this$0.stopNestedScroll(1);
            return;
        L88:
            if (r132.isPendingInitialRun() == false) goto L90;
            r132.onAnimation(0, 0);
            goto L90
        }

        public void postOnAnimation() {
            if (this.mEatRunOnAnimationRequest == false) goto L5;
            this.mReSchedulePostAnimationCallback = true;
            return;
        L5:
            internalPostOnAnimation();
        }

        public void stop() {
            this.this$0.removeCallbacks(this);
            this.mOverScroller.abortAnimation();
        }

        public ViewFlinger(RecyclerView r100) {
            this.this$0 = r100;
            Interpolator r101 = RecyclerView.sQuinticInterpolator;
            this.mInterpolator = r101;
            this.mEatRunOnAnimationRequest = false;
            this.mReSchedulePostAnimationCallback = false;
            this.mOverScroller = new OverScroller(r100.getContext(), r101);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void androidx_recyclerview_widget_RecyclerView$ViewFlinger_com_larus_apm_impl_protector_RunnableLancet_run(ViewFlinger r100) {
            r100.androidx_recyclerview_widget_RecyclerView$ViewFlinger__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        private int computeScrollDuration(int r100, int r101) {
            int r102 = Math.abs(r100);
            int r103 = Math.abs(r101);
            if (r102 <= r103) goto L5;
            boolean r104 = true;
        L6:
            RecyclerView r105 = this.this$0;
            if (r104 == false) goto L9;
            int r106 = r105.getWidth();
        L10:
            if (r104 == true) goto L14;
            r102 = r103;
        L14:
            return Math.min((int) (((r102 / r106) + 1.0f) * 300.0f), 2000);
        L9:
            r106 = r105.getHeight();
            goto L10
        L5:
            r104 = false;
            goto L6
        }

        public void fling(int r110, int r111) {
            this.this$0.setScrollState(2);
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            Interpolator r100 = this.mInterpolator;
            Interpolator r101 = RecyclerView.sQuinticInterpolator;
            if (r100 == r101) goto L5;
            this.mInterpolator = r101;
            this.mOverScroller = new OverScroller(this.this$0.getContext(), r101);
        L5:
            this.mOverScroller.fling(0, 0, r110, r111, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            postOnAnimation();
        }

        public void smoothScrollBy(int r100, int r101, int r102, Interpolator r110) {
            if (r102 != Integer.MIN_VALUE) goto L5;
            r102 = computeScrollDuration(r100, r101);
        L5:
            int r103 = r102;
            if (r110 != null) goto L9;
            r110 = RecyclerView.sQuinticInterpolator;
        L9:
            if (this.mInterpolator == r110) goto L11;
            this.mInterpolator = r110;
            this.mOverScroller = new OverScroller(this.this$0.getContext(), r110);
        L11:
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            this.this$0.setScrollState(2);
            this.mOverScroller.startScroll(0, 0, r100, r101, r103);
            if (Build.VERSION.SDK_INT >= 23) goto L14;
            this.mOverScroller.computeScrollOffset();
        L14:
            postOnAnimation();
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
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
        public final View itemView;
        Adapter<? extends ViewHolder> mBindingAdapter;
        int mFlags;
        boolean mInChangeScrap;
        private int mIsRecyclableCount;
        long mItemId;
        int mItemViewType;
        WeakReference<RecyclerView> mNestedRecyclerView;
        int mOldPosition;
        RecyclerView mOwnerRecyclerView;
        List<Object> mPayloads;
        int mPendingAccessibilityState;
        int mPosition;
        int mPreLayoutPosition;
        Recycler mScrapContainer;
        ViewHolder mShadowedHolder;
        ViewHolder mShadowingHolder;
        List<Object> mUnmodifiedPayloads;
        private int mWasImportantForAccessibilityBeforeHidden;

        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        public void resetInternal() {
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
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads != null) goto L6;
            ArrayList r100 = new ArrayList();
            this.mPayloads = r100;
            this.mUnmodifiedPayloads = Collections.unmodifiableList(r100);
            return;
        }

        public void clearPayload() {
            List<Object> r100 = this.mPayloads;
            if (r100 == null) goto L5;
            r100.clear();
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
            if (ViewCompat.hasTransientState(this.itemView) == false) goto L7;
            return true;
        }

        public final int getAbsoluteAdapterPosition() {
            RecyclerView r100 = this.mOwnerRecyclerView;
            if (r100 != null) goto L7;
            return -1;
        L7:
            return r100.getAdapterPositionInRecyclerView(this);
        }

        public final int getBindingAdapterPosition() {
            if (this.mBindingAdapter != null) goto L5;
            return -1;
        L5:
            RecyclerView r100 = this.mOwnerRecyclerView;
            if (r100 != null) goto L8;
            return -1;
        L8:
            Adapter r101 = r100.getAdapter();
            if (r101 != null) goto L11;
            return -1;
        L11:
            int r102 = this.mOwnerRecyclerView.getAdapterPositionInRecyclerView(this);
            if (r102 != (-1)) goto L15;
            return -1;
        L15:
            return r101.findRelativeAdapterPositionIn(this.mBindingAdapter, this, r102);
        }

        public final int getLayoutPosition() {
            int r100 = this.mPreLayoutPosition;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            return this.mPosition;
        }

        public final int getPosition() {
            int r100 = this.mPreLayoutPosition;
            if (r100 == (-1)) goto L5;
            return r100;
        L5:
            return this.mPosition;
        }

        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) goto L14;
            List<Object> r100 = this.mPayloads;
            if (r100 == null) goto L12;
            if (r100.size() == 0) goto L12;
            return this.mUnmodifiedPayloads;
        L12:
            return FULLUPDATE_PAYLOADS;
        L14:
            return FULLUPDATE_PAYLOADS;
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

        boolean isBound() {
            if ((this.mFlags & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        boolean isInvalid() {
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
            if (ViewCompat.hasTransientState(this.itemView) == true) goto L7;
            return true;
        }

        boolean isRemoved() {
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

        public void saveOldPosition() {
            if (this.mOldPosition != (-1)) goto L6;
            this.mOldPosition = this.mPosition;
            return;
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

        public void unScrap() {
            this.mScrapContainer.unscrapView(this);
        }

        public boolean wasReturnedFromScrap() {
            if ((this.mFlags & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        static {
            FULLUPDATE_PAYLOADS = Collections.emptyList();
        }

        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        public String toString() {
            if (getClass().isAnonymousClass() == false) goto L5;
            String r100 = "ViewHolder";
        L6:
            StringBuilder r101 = new StringBuilder(r100 + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap() == false) goto L14;
            r101.append(" scrap ");
            if (this.mInChangeScrap == false) goto L11;
            String r102 = "[changeScrap]";
        L12:
            r101.append(r102);
            goto L14
        L11:
            r102 = "[attachedScrap]";
        L14:
            if (isInvalid() == false) goto L17;
            r101.append(" invalid");
        L17:
            if (isBound() == true) goto L20;
            r101.append(" unbound");
        L20:
            if (needsUpdate() == false) goto L23;
            r101.append(" update");
        L23:
            if (isRemoved() == false) goto L26;
            r101.append(" removed");
        L26:
            if (shouldIgnore() == false) goto L29;
            r101.append(" ignored");
        L29:
            if (isTmpDetached() == false) goto L32;
            r101.append(" tmpDetached");
        L32:
            if (isRecyclable() == true) goto L35;
            r101.append(" not recyclable(" + this.mIsRecyclableCount + ")");
        L35:
            if (isAdapterPositionUnknown() == false) goto L38;
            r101.append(" undefined adapter position");
        L38:
            if (this.itemView.getParent() != null) goto L40;
            r101.append(" no parent");
        L40:
            r101.append(i.f25855d);
            return r101.toString();
        L5:
            r100 = getClass().getSimpleName();
            goto L6
        }

        public final Adapter<? extends ViewHolder> getBindingAdapter() {
            return this.mBindingAdapter;
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        public ViewHolder(View r100) {
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
            if (r100 == null) goto L7;
            this.itemView = r100;
            return;
        L7:
            throw new IllegalArgumentException("itemView may not be null");
        }

        public void addChangePayload(Object r100) {
            if (r100 != null) goto L6;
            addFlags(1024);
            return;
        L6:
            if ((1024 & this.mFlags) != 0) goto L10;
            createPayloadsIfNeeded();
            this.mPayloads.add(r100);
            return;
        }

        public void addFlags(int r100) {
            this.mFlags = r100 | this.mFlags;
        }

        public boolean hasAnyOfTheFlags(int r100) {
            if ((r100 & this.mFlags) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public void onEnteredHiddenState(RecyclerView r100) {
            int r101 = this.mPendingAccessibilityState;
            if (r101 == (-1)) goto L5;
            this.mWasImportantForAccessibilityBeforeHidden = r101;
        L6:
            r100.setChildImportantForAccessibilityInternal(this, 4);
            return;
        L5:
            this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView);
            goto L6
        }

        public void onLeftHiddenState(RecyclerView r100) {
            r100.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public final void setIsRecyclable(boolean r100) {
            int r101 = this.mIsRecyclableCount;
            if (r100 == false) goto L5;
            int r102 = r101 - 1;
        L6:
            this.mIsRecyclableCount = r102;
            if (r102 >= 0) goto L9;
            this.mIsRecyclableCount = 0;
            toString();
            return;
        L9:
            if (r100 == true) goto L12;
            if (r102 != 1) goto L12;
            this.mFlags |= 16;
            return;
        L12:
            if (r100 == false) goto L18;
            if (r102 != 0) goto L19;
            this.mFlags &= -17;
            return;
        L19:
            return;
        L18:
            return;
        L5:
            r102 = r101 + 1;
            goto L6
        }

        public void offsetPosition(int r100, boolean r101) {
            if (this.mOldPosition != (-1)) goto L6;
            this.mOldPosition = this.mPosition;
        L6:
            if (this.mPreLayoutPosition != (-1)) goto L8;
            this.mPreLayoutPosition = this.mPosition;
        L8:
            if (r101 == false) goto L10;
            this.mPreLayoutPosition += r100;
        L10:
            this.mPosition += r100;
            if (this.itemView.getLayoutParams() == null) goto L14;
            ((LayoutParams) this.itemView.getLayoutParams()).mInsetsDirty = true;
            return;
        }

        public void setFlags(int r100, int r101) {
            int r102 = r100 & r101;
            this.mFlags = r102 | (this.mFlags & (~r101));
        }

        public void setScrapContainer(Recycler r100, boolean r101) {
            this.mScrapContainer = r100;
            this.mInChangeScrap = r101;
        }

        public void flagRemovedAndOffsetPosition(int r100, int r101, boolean r102) {
            addFlags(8);
            offsetPosition(r101, r102);
            this.mPosition = r100;
        }
    }

    static {
        NESTED_SCROLLING_ATTRS = new int[]{R.attr.nestedScrollingEnabled};
        int r100 = Build.VERSION.SDK_INT;
        FORCE_INVALIDATE_DISPLAY_LIST = false;
        if (r100 < 23) goto L5;
        boolean r101 = true;
    L6:
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = r101;
        POST_UPDATES_ON_ANIMATION = true;
        ALLOW_THREAD_GAP_WORK = true;
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
        IGNORE_DETACHED_FOCUSED_CHILD = false;
        Class<?> r102 = Integer.TYPE;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, r102, r102};
        sQuinticInterpolator = new AnonymousClass3();
        return;
    L5:
        r101 = false;
        goto L6
    }

    public static /* synthetic */ Class access$001(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    void invalidateGlows() {
        this.mBottomGlow = null;
        this.mTopGlow = null;
        this.mRightGlow = null;
        this.mLeftGlow = null;
    }

    public void onChildAttachedToWindow(View r100) {
    }

    public void onChildDetachedFromWindow(View r100) {
    }

    void onExitLayoutOrScroll() {
        onExitLayoutOrScroll(true);
    }

    public void onScrollStateChanged(int r100) {
    }

    public void onScrolled(int r100, int r101) {
    }

    @Override // android.view.View
    public void scrollTo(int r100, int r101) {
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    private void dispatchContentChangedIfNecessary() {
        int r100 = this.mEatenAccessibilityChangeFlags;
        this.mEatenAccessibilityChangeFlags = 0;
        if (r100 != 0) goto L5;
        return;
    L5:
        if (isAccessibilityEnabled() == false) goto L9;
        AccessibilityEvent r101 = AccessibilityEvent.obtain();
        r101.setEventType(2048);
        AccessibilityEventCompat.setContentChangeTypes(r101, r100);
        sendAccessibilityEventUnchecked(r101);
        return;
    }

    private void dispatchLayoutStep1() {
        boolean r100 = true;
        this.mState.assertLayoutStep(1);
        fillRemainingScrollValues(this.mState);
        this.mState.mIsMeasuring = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.clear();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        State r101 = this.mState;
        if (r101.mRunSimpleAnimations == true) goto L5;
    L7:
        r100 = false;
    L8:
        r101.mTrackOldChangeHolders = r100;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        r101.mInPreLayout = r101.mRunPredictiveAnimations;
        r101.mItemCount = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.mRunSimpleAnimations == false) goto L32;
        int r102 = this.mChildHelper.getChildCount();
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L32;
        ViewHolder r104 = getChildViewHolderInt(this.mChildHelper.getChildAt(r103));
        if (r104.shouldIgnore() == true) goto L30;
        if (r104.isInvalid() == true) goto L17;
    L19:
        ItemAnimator.ItemHolderInfo r105 = this.mItemAnimator.recordPreLayoutInformation(this.mState, r104, ItemAnimator.buildAdapterChangeFlagsForAnimations(r104), r104.getUnmodifiedPayloads());
        this.mViewInfoStore.addToPreLayout(r104, r105);
        if (this.mState.mTrackOldChangeHolders == false) goto L30;
        if (r104.isUpdated() == false) goto L30;
        if (r104.isRemoved() == true) goto L30;
        if (r104.shouldIgnore() == true) goto L30;
        if (r104.isInvalid() == true) goto L30;
        long r106 = getChangedHolderKey(r104);
        this.mViewInfoStore.addToOldChangeHolders(r106, r104);
        goto L30
    L17:
        if (this.mAdapter.hasStableIds() == true) goto L19;
    L30:
        r103 = r103 + 1;
    L32:
        if (this.mState.mRunPredictiveAnimations == false) goto L50;
        saveOldPositions();
        State r107 = this.mState;
        boolean r108 = r107.mStructureChanged;
        r107.mStructureChanged = false;
        this.mLayout.onLayoutChildren(this.mRecycler, r107);
        this.mState.mStructureChanged = r108;
        int r109 = 0;
    L35:
        if (r109 >= this.mChildHelper.getChildCount()) goto L49;
        ViewHolder r110 = getChildViewHolderInt(this.mChildHelper.getChildAt(r109));
        if (r110.shouldIgnore() == true) goto L48;
        if (this.mViewInfoStore.isInPreLayout(r110) == true) goto L48;
        int r111 = ItemAnimator.buildAdapterChangeFlagsForAnimations(r110);
        boolean r112 = r110.hasAnyOfTheFlags(8192);
        if (r112 == true) goto L44;
        r111 = r111 | 4096;
    L44:
        ItemAnimator.ItemHolderInfo r113 = this.mItemAnimator.recordPreLayoutInformation(this.mState, r110, r111, r110.getUnmodifiedPayloads());
        if (r112 == false) goto L47;
        recordAnimationInfoIfBouncedHiddenView(r110, r113);
        goto L48
    L47:
        this.mViewInfoStore.addToAppearedInPreLayoutHolders(r110, r113);
    L48:
        r109 = r109 + 1;
        goto L35
    L49:
        clearOldPositions();
    L51:
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mState.mLayoutStep = 2;
        return;
    L50:
        clearOldPositions();
        goto L51
    L5:
        if (this.mItemsChanged == false) goto L7;
        goto L7
    }

    private void dispatchLayoutStep3() {
        this.mState.assertLayoutStep(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        State r100 = this.mState;
        r100.mLayoutStep = 1;
        if (r100.mRunSimpleAnimations == false) goto L24;
        int r101 = this.mChildHelper.getChildCount() - 1;
    L5:
        if (r101 < 0) goto L23;
        ViewHolder r102 = getChildViewHolderInt(this.mChildHelper.getChildAt(r101));
        if (r102.shouldIgnore() == true) goto L22;
        long r103 = getChangedHolderKey(r102);
        ItemAnimator.ItemHolderInfo r104 = this.mItemAnimator.recordPostLayoutInformation(this.mState, r102);
        ViewHolder r105 = this.mViewInfoStore.getFromOldChangeHolders(r103);
        if (r105 != null) goto L12;
    L21:
        this.mViewInfoStore.addToPostLayout(r102, r104);
        goto L22
    L12:
        if (r105.shouldIgnore() == true) goto L21;
        boolean r106 = this.mViewInfoStore.isDisappearing(r105);
        boolean r107 = this.mViewInfoStore.isDisappearing(r102);
        if (r106 == false) goto L17;
        if (r105 != r102) goto L17;
        this.mViewInfoStore.addToPostLayout(r102, r104);
    L17:
        ItemAnimator.ItemHolderInfo r108 = this.mViewInfoStore.popFromPreLayout(r105);
        this.mViewInfoStore.addToPostLayout(r102, r104);
        ItemAnimator.ItemHolderInfo r110 = this.mViewInfoStore.popFromPostLayout(r102);
        if (r108 != null) goto L20;
        handleMissingPreInfoForChangeError(r103, r102, r105);
        goto L22
    L20:
        animateChange(r105, r102, r108, r110, r106, r107);
    L22:
        r101 = r101 - 1;
        goto L5
    L23:
        this.mViewInfoStore.process(this.mViewInfoProcessCallback);
    L24:
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        State r109 = this.mState;
        r109.mPreviousLayoutItemCount = r109.mItemCount;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        r109.mRunSimpleAnimations = false;
        r109.mRunPredictiveAnimations = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        ArrayList<ViewHolder> r111 = this.mRecycler.mChangedScrap;
        if (r111 == null) goto L27;
        r111.clear();
    L27:
        LayoutManager r112 = this.mLayout;
        if (r112.mPrefetchMaxObservedInInitialPrefetch == false) goto L30;
        r112.mPrefetchMaxCountObserved = 0;
        r112.mPrefetchMaxObservedInInitialPrefetch = false;
        this.mRecycler.updateViewCacheSize();
    L30:
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.clear();
        int[] r113 = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(r113[0], r113[1]) == false) goto L33;
        dispatchOnScrolled(0, 0);
    L33:
        recoverFocusFromState();
        resetFocusInfo();
    }

    private View findNextViewToFocus() {
        State r100 = this.mState;
        int r101 = r100.mFocusedItemPosition;
        if (r101 != (-1)) goto L6;
        r101 = 0;
    L6:
        int r102 = r100.getItemCount();
        int r103 = r101;
    L7:
        if (r103 >= r102) goto L16;
        ViewHolder r104 = findViewHolderForAdapterPosition(r103);
        if (r104 == null) goto L16;
        if (r104.itemView.hasFocusable() == true) goto L14;
        r103 = r103 + 1;
        goto L7
    L14:
        return r104.itemView;
    L16:
        int r105 = Math.min(r102, r101);
    L17:
        r105 = r105 - 1;
        if (r105 < 0) goto L27;
        ViewHolder r106 = findViewHolderForAdapterPosition(r105);
        if (r106 == null) goto L21;
        if (r106.itemView.hasFocusable() == false) goto L17;
        return r106.itemView;
    L21:
        return null;
    L27:
        return null;
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper != null) goto L6;
        this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
    L6:
        return this.mScrollingChildHelper;
    }

    private boolean hasUpdatedView() {
        int r100 = this.mChildHelper.getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L14;
        ViewHolder r102 = getChildViewHolderInt(this.mChildHelper.getChildAt(r101));
        if (r102 == null) goto L13;
        if (r102.shouldIgnore() == true) goto L13;
        if (r102.isUpdated() == false) goto L13;
        return true;
    L13:
        r101 = r101 + 1;
        goto L3
    L14:
        return false;
    }

    private void initChildrenHelper() {
        this.mChildHelper = new ChildHelper(new AnonymousClass5(this));
    }

    private boolean predictiveItemAnimationsEnabled() {
        if (this.mItemAnimator != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mLayout.supportsPredictiveItemAnimations() == false) goto L7;
        return true;
    }

    private void processAdapterUpdatesAndSetAnimationFlags() {
        if (this.mDataSetHasChangedAfterLayout == false) goto L8;
        this.mAdapterHelper.reset();
        if (this.mDispatchItemsChangedEvent == false) goto L8;
        this.mLayout.onItemsChanged(this);
    L8:
        if (predictiveItemAnimationsEnabled() == false) goto L10;
        this.mAdapterHelper.preProcess();
    L11:
        boolean r100 = false;
        if (this.mItemsAddedOrRemoved == false) goto L14;
    L17:
        boolean r101 = true;
    L18:
        State r102 = this.mState;
        if (this.mFirstLayoutComplete == true) goto L21;
    L31:
        boolean r103 = false;
    L32:
        r102.mRunSimpleAnimations = r103;
        State r104 = this.mState;
        if (r104.mRunSimpleAnimations == false) goto L40;
        if (r101 == false) goto L40;
        if (this.mDataSetHasChangedAfterLayout == true) goto L40;
        if (predictiveItemAnimationsEnabled() == false) goto L40;
        r100 = true;
    L40:
        r104.mRunPredictiveAnimations = r100;
        return;
    L21:
        if (this.mItemAnimator == null) goto L31;
        boolean r105 = this.mDataSetHasChangedAfterLayout;
        if (r105 == true) goto L27;
        if (r101 == true) goto L27;
        if (this.mLayout.mRequestedSimpleAnimations == false) goto L31;
    L27:
        if (r105 == true) goto L29;
    L30:
        r103 = true;
        goto L32
    L29:
        if (this.mAdapter.hasStableIds() == false) goto L31;
    L14:
        if (this.mItemsChanged == true) goto L17;
        r101 = false;
        goto L18
    L10:
        this.mAdapterHelper.consumeUpdatesInOnePass();
        goto L11
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
        View r100 = getFocusedChild();
        if (IGNORE_DETACHED_FOCUSED_CHILD == false) goto L28;
        if (r100.getParent() == null) goto L24;
        if (r100.hasFocus() == true) goto L28;
    L24:
        if (this.mChildHelper.getChildCount() != 0) goto L30;
        requestFocus();
        return;
    L28:
        if (this.mChildHelper.isHidden(r100) == true) goto L30;
        return;
    L30:
        View r101 = null;
        if (this.mState.mFocusedItemId != (-1)) goto L33;
    L35:
        ViewHolder r102 = null;
    L36:
        if (r102 == null) goto L44;
        if (this.mChildHelper.isHidden(r102.itemView) == true) goto L44;
        if (r102.itemView.hasFocusable() == false) goto L44;
        r101 = r102.itemView;
    L46:
        if (r101 == null) goto L60;
        int r103 = this.mState.mFocusedSubChildId;
        if (r103 == (-1)) goto L54;
        View r104 = r101.findViewById(r103);
        if (r104 == null) goto L54;
        if (r104.isFocusable() == false) goto L54;
        r101 = r104;
    L54:
        r101.requestFocus();
        return;
    L60:
        return;
    L44:
        if (this.mChildHelper.getChildCount() <= 0) goto L46;
        r101 = findNextViewToFocus();
        goto L46
    L33:
        if (this.mAdapter.hasStableIds() == false) goto L35;
        r102 = findViewHolderForItemId(this.mState.mFocusedItemId);
        goto L36
    }

    private void releaseGlows() {
        EdgeEffect r100 = this.mLeftGlow;
        if (r100 == null) goto L5;
        r100.onRelease();
        boolean r101 = this.mLeftGlow.isFinished();
    L6:
        EdgeEffect r102 = this.mTopGlow;
        if (r102 == null) goto L9;
        r102.onRelease();
        r101 = r101 | this.mTopGlow.isFinished();
    L9:
        EdgeEffect r103 = this.mRightGlow;
        if (r103 == null) goto L12;
        r103.onRelease();
        r101 = r101 | this.mRightGlow.isFinished();
    L12:
        EdgeEffect r104 = this.mBottomGlow;
        if (r104 == null) goto L15;
        r104.onRelease();
        r101 = r101 | this.mBottomGlow.isFinished();
    L15:
        if (r101 == false) goto L18;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L18:
        return;
    L5:
        r101 = false;
        goto L6
    }

    private void resetFocusInfo() {
        State r100 = this.mState;
        r100.mFocusedItemId = -1;
        r100.mFocusedItemPosition = -1;
        r100.mFocusedSubChildId = -1;
    }

    private void resetScroll() {
        VelocityTracker r100 = this.mVelocityTracker;
        if (r100 == null) goto L5;
        r100.clear();
    L5:
        stopNestedScroll(0);
        releaseGlows();
    }

    private void saveFocusInfo() {
        ViewHolder r100 = null;
        if (this.mPreserveFocusAfterLayout == true) goto L5;
    L9:
        View r101 = null;
    L10:
        if (r101 == null) goto L13;
        r100 = findContainingViewHolder(r101);
    L13:
        if (r100 != null) goto L15;
        resetFocusInfo();
        return;
    L15:
        State r102 = this.mState;
        if (this.mAdapter.hasStableIds() == false) goto L18;
        long r103 = r100.getItemId();
    L19:
        r102.mFocusedItemId = r103;
        State r104 = this.mState;
        if (this.mDataSetHasChangedAfterLayout == false) goto L23;
        int r105 = -1;
    L26:
        r104.mFocusedItemPosition = r105;
        this.mState.mFocusedSubChildId = getDeepestFocusedViewWithId(r100.itemView);
        return;
    L23:
        if (r100.isRemoved() == false) goto L25;
        r105 = r100.mOldPosition;
        goto L26
    L25:
        r105 = r100.getAbsoluteAdapterPosition();
        goto L26
    L18:
        r103 = -1;
        goto L19
    L5:
        if (hasFocus() == false) goto L9;
        if (this.mAdapter == null) goto L9;
        r101 = getFocusedChild();
        goto L10
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.stop();
        LayoutManager r100 = this.mLayout;
        if (r100 == null) goto L6;
        r100.stopSmoothScroller();
        return;
    }

    void clearOldPositions() {
        int r100 = this.mChildHelper.getUnfilteredChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L8;
        ViewHolder r102 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r101));
        if (r102.shouldIgnore() == true) goto L7;
        r102.clearOldPosition();
    L7:
        r101 = r101 + 1;
        goto L3
    L8:
        this.mRecycler.clearOldPositions();
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<OnChildAttachStateChangeListener> r100 = this.mOnChildAttachStateListeners;
        if (r100 == null) goto L6;
        r100.clear();
        return;
    }

    public void clearOnScrollListeners() {
        List<OnScrollListener> r100 = this.mScrollListeners;
        if (r100 == null) goto L6;
        r100.clear();
        return;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        LayoutManager r100 = this.mLayout;
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (r100.canScrollHorizontally() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeHorizontalScrollExtent(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        LayoutManager r100 = this.mLayout;
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (r100.canScrollHorizontally() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeHorizontalScrollOffset(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        LayoutManager r100 = this.mLayout;
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (r100.canScrollHorizontally() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeHorizontalScrollRange(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        LayoutManager r100 = this.mLayout;
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (r100.canScrollVertically() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeVerticalScrollExtent(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        LayoutManager r100 = this.mLayout;
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (r100.canScrollVertically() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeVerticalScrollOffset(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        LayoutManager r100 = this.mLayout;
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (r100.canScrollVertically() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeVerticalScrollRange(this.mState);
    }

    void consumePendingUpdateOperations() {
        if (this.mFirstLayoutComplete == true) goto L5;
    L25:
        TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.endSection();
        return;
    L5:
        if (this.mDataSetHasChangedAfterLayout == true) goto L25;
        if (this.mAdapterHelper.hasPendingUpdates() == true) goto L11;
        return;
    L11:
        if (this.mAdapterHelper.hasAnyUpdateTypes(4) == false) goto L22;
        if (this.mAdapterHelper.hasAnyUpdateTypes(11) == true) goto L22;
        TraceCompat.beginSection(TRACE_HANDLE_ADAPTER_UPDATES_TAG);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mAdapterHelper.preProcess();
        if (this.mLayoutWasDefered == false) goto L17;
    L20:
        stopInterceptRequestLayout(true);
        onExitLayoutOrScroll();
        TraceCompat.endSection();
        return;
    L17:
        if (hasUpdatedView() == false) goto L19;
        dispatchLayout();
        goto L20
    L19:
        this.mAdapterHelper.consumePostponedUpdates();
    L22:
        if (this.mAdapterHelper.hasPendingUpdates() == false) goto L28;
        TraceCompat.beginSection(TRACE_ON_DATA_SET_CHANGE_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.endSection();
        return;
    }

    void dispatchLayout() {
        if (this.mAdapter != null) goto L6;
        return;
    L6:
        if (this.mLayout != null) goto L8;
        return;
    L8:
        this.mState.mIsMeasuring = false;
        if (this.mLastAutoMeasureSkippedDueToExact == true) goto L11;
    L15:
        boolean r100 = false;
    L16:
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mLastAutoMeasureSkippedDueToExact = false;
        if (this.mState.mLayoutStep != 1) goto L20;
        dispatchLayoutStep1();
        this.mLayout.setExactMeasureSpecsFrom(this);
        dispatchLayoutStep2();
    L29:
        dispatchLayoutStep3();
        return;
    L20:
        if (this.mAdapterHelper.hasUpdates() == true) goto L28;
        if (r100 == true) goto L28;
        if (this.mLayout.getWidth() != getWidth()) goto L28;
        if (this.mLayout.getHeight() != getHeight()) goto L28;
        this.mLayout.setExactMeasureSpecsFrom(this);
    L28:
        this.mLayout.setExactMeasureSpecsFrom(this);
        dispatchLayoutStep2();
        goto L29
    L11:
        if (this.mLastAutoMeasureNonExactMeasuredWidth == getWidth()) goto L13;
    L14:
        r100 = true;
        goto L16
    L13:
        if (this.mLastAutoMeasureNonExactMeasuredHeight == getHeight()) goto L15;
        goto L14
    }

    void dispatchPendingImportantForAccessibilityChanges() {
        int r100 = this.mPendingAccessibilityImportanceChange.size() - 1;
    L3:
        if (r100 < 0) goto L13;
        ViewHolder r101 = (ViewHolder) ListProtector.get(this.mPendingAccessibilityImportanceChange, r100);
        if (r101.itemView.getParent() != this) goto L12;
        if (r101.shouldIgnore() == true) goto L12;
        int r102 = r101.mPendingAccessibilityState;
        if (r102 == (-1)) goto L12;
        ViewCompat.setImportantForAccessibility(r101.itemView, r102);
        r101.mPendingAccessibilityState = -1;
    L12:
        r100 = r100 - 1;
        goto L3
    L13:
        this.mPendingAccessibilityImportanceChange.clear();
    }

    public void ensureBottomGlow() {
        if (this.mBottomGlow == null) goto L5;
        return;
    L5:
        EdgeEffect r100 = this.mEdgeEffectFactory.createEdgeEffect(this, 3);
        this.mBottomGlow = r100;
        if (this.mClipToPadding == false) goto L8;
        r100.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        return;
    L8:
        r100.setSize(getMeasuredWidth(), getMeasuredHeight());
    }

    public void ensureLeftGlow() {
        if (this.mLeftGlow == null) goto L5;
        return;
    L5:
        EdgeEffect r100 = this.mEdgeEffectFactory.createEdgeEffect(this, 0);
        this.mLeftGlow = r100;
        if (this.mClipToPadding == false) goto L8;
        r100.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        return;
    L8:
        r100.setSize(getMeasuredHeight(), getMeasuredWidth());
    }

    public void ensureRightGlow() {
        if (this.mRightGlow == null) goto L5;
        return;
    L5:
        EdgeEffect r100 = this.mEdgeEffectFactory.createEdgeEffect(this, 2);
        this.mRightGlow = r100;
        if (this.mClipToPadding == false) goto L8;
        r100.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        return;
    L8:
        r100.setSize(getMeasuredHeight(), getMeasuredWidth());
    }

    public void ensureTopGlow() {
        if (this.mTopGlow == null) goto L5;
        return;
    L5:
        EdgeEffect r100 = this.mEdgeEffectFactory.createEdgeEffect(this, 1);
        this.mTopGlow = r100;
        if (this.mClipToPadding == false) goto L8;
        r100.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        return;
    L8:
        r100.setSize(getMeasuredWidth(), getMeasuredHeight());
    }

    String exceptionLabel() {
        return " " + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager r100 = this.mLayout;
        if (r100 == null) goto L7;
        return r100.generateDefaultLayoutParams();
    L7:
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.View
    public int getBaseline() {
        LayoutManager r100 = this.mLayout;
        if (r100 == null) goto L7;
        return r100.getBaseline();
    L7:
        return super.getBaseline();
    }

    public int getItemDecorationCount() {
        return this.mItemDecorations.size();
    }

    long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK == true) goto L5;
        return 0;
    L5:
        return System.nanoTime();
    }

    public RecycledViewPool getRecycledViewPool() {
        return this.mRecycler.getRecycledViewPool();
    }

    public boolean hasPendingAdapterUpdates() {
        if (this.mFirstLayoutComplete == true) goto L5;
    L10:
        return true;
    L5:
        if (this.mDataSetHasChangedAfterLayout == true) goto L10;
        if (this.mAdapterHelper.hasPendingUpdates() == true) goto L10;
        return false;
    }

    void initAdapterManager() {
        this.mAdapterHelper = new AdapterHelper(new AnonymousClass6(this));
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) goto L5;
        return;
    L5:
        LayoutManager r100 = this.mLayout;
        if (r100 == null) goto L8;
        r100.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
    L8:
        markItemDecorInsetsDirty();
        requestLayout();
    }

    boolean isAccessibilityEnabled() {
        AccessibilityManager r100 = this.mAccessibilityManager;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isEnabled() == false) goto L7;
        return true;
    }

    public boolean isAnimating() {
        ItemAnimator r100 = this.mItemAnimator;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isRunning() == false) goto L7;
        return true;
    }

    public boolean isComputingLayout() {
        if (this.mLayoutOrScrollCounter <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    void markItemDecorInsetsDirty() {
        int r100 = this.mChildHelper.getUnfilteredChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        ((LayoutParams) this.mChildHelper.getUnfilteredChildAt(r101).getLayoutParams()).mInsetsDirty = true;
        r101 = r101 + 1;
        goto L3
    L5:
        this.mRecycler.markItemDecorInsetsDirty();
    }

    void markKnownViewsInvalid() {
        int r100 = this.mChildHelper.getUnfilteredChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L10;
        ViewHolder r102 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r101));
        if (r102 == null) goto L9;
        if (r102.shouldIgnore() == true) goto L9;
        r102.addFlags(6);
    L9:
        r101 = r101 + 1;
        goto L3
    L10:
        markItemDecorInsetsDirty();
        this.mRecycler.markKnownViewsInvalid();
    }

    void onEnterLayoutOrScroll() {
        this.mLayoutOrScrollCounter++;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState r100 = new SavedState(super.onSaveInstanceState());
        SavedState r101 = this.mPendingSavedState;
        if (r101 == null) goto L5;
        r100.copyFrom(r101);
    L9:
        return r100;
    L5:
        LayoutManager r102 = this.mLayout;
        if (r102 == null) goto L8;
        r100.mLayoutState = r102.onSaveInstanceState();
        goto L9
    L8:
        r100.mLayoutState = null;
        goto L9
    }

    void postAnimationRunner() {
        if (this.mPostedAnimatorRunner == false) goto L5;
        return;
    L5:
        if (this.mIsAttached == false) goto L9;
        ViewCompat.postOnAnimation(this, this.mItemAnimatorRunner);
        this.mPostedAnimatorRunner = true;
        return;
    }

    void removeAndRecycleViews() {
        ItemAnimator r100 = this.mItemAnimator;
        if (r100 == null) goto L5;
        r100.endAnimations();
    L5:
        LayoutManager r101 = this.mLayout;
        if (r101 == null) goto L8;
        r101.removeAndRecycleAllViews(this.mRecycler);
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
    L8:
        this.mRecycler.clear();
    }

    void repositionShadowingViews() {
        int r100 = this.mChildHelper.getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L14;
        View r102 = this.mChildHelper.getChildAt(r101);
        ViewHolder r103 = getChildViewHolder(r102);
        if (r103 == null) goto L13;
        ViewHolder r104 = r103.mShadowingHolder;
        if (r104 == null) goto L13;
        View r105 = r104.itemView;
        int r106 = r102.getLeft();
        int r107 = r102.getTop();
        if (r106 == r105.getLeft()) goto L11;
    L12:
        r105.layout(r106, r107, r105.getWidth() + r106, r105.getHeight() + r107);
        goto L13
    L11:
        if (r107 != r105.getTop()) goto L12;
    L13:
        r101 = r101 + 1;
        goto L3
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

    void saveOldPositions() {
        int r100 = this.mChildHelper.getUnfilteredChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L8;
        ViewHolder r102 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r101));
        if (r102.shouldIgnore() == true) goto L7;
        r102.saveOldPosition();
    L7:
        r101 = r101 + 1;
        goto L3
    }

    void startInterceptRequestLayout() {
        int r100 = this.mInterceptRequestLayoutDepth + 1;
        this.mInterceptRequestLayoutDepth = r100;
        if (r100 == 1) goto L5;
        return;
    L5:
        if (this.mLayoutSuppressed == true) goto L9;
        this.mLayoutWasDefered = false;
        return;
    }

    private void cancelScroll() {
        resetScroll();
        setScrollState(0);
    }

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.assertLayoutStep(6);
        this.mAdapterHelper.consumeUpdatesInOnePass();
        State r100 = this.mState;
        r100.mItemCount = this.mAdapter.getItemCount();
        this.mState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        if (this.mPendingSavedState != null) goto L5;
    L10:
        State r101 = this.mState;
        r101.mInPreLayout = false;
        this.mLayout.onLayoutChildren(this.mRecycler, r101);
        State r102 = this.mState;
        r102.mStructureChanged = false;
        if (r102.mRunSimpleAnimations == true) goto L13;
    L15:
        boolean r103 = false;
    L16:
        r102.mRunSimpleAnimations = r103;
        r102.mLayoutStep = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        return;
    L13:
        if (this.mItemAnimator == null) goto L15;
        r103 = true;
        goto L16
    L5:
        if (this.mAdapter.canRestoreState() == false) goto L10;
        Parcelable r104 = this.mPendingSavedState.mLayoutState;
        if (r104 == null) goto L9;
        this.mLayout.onRestoreInstanceState(r104);
    L9:
        this.mPendingSavedState = null;
        goto L10
    }

    private void initAutofill() {
        if (ViewCompat.getImportantForAutofill(this) != 0) goto L6;
        ViewCompat.setImportantForAutofill(this, 8);
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    public boolean isLayoutFrozen() {
        return isLayoutSuppressed();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        boolean r100 = true;
        this.mIsAttached = true;
        if (this.mFirstLayoutComplete == true) goto L5;
    L7:
        r100 = false;
    L8:
        this.mFirstLayoutComplete = r100;
        LayoutManager r101 = this.mLayout;
        if (r101 == null) goto L11;
        r101.dispatchAttachedToWindow(this);
    L11:
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK == false) goto L25;
        ThreadLocal<GapWorker> r102 = GapWorker.sGapWorker;
        GapWorker r103 = r102.get();
        this.mGapWorker = r103;
        if (r103 != null) goto L23;
        this.mGapWorker = new GapWorker();
        Display r104 = ViewCompat.getDisplay(this);
        if (isInEditMode() == true) goto L21;
        if (r104 == null) goto L21;
        float r105 = r104.getRefreshRate();
        if (r105 < 30.0f) goto L21;
    L22:
        GapWorker r106 = this.mGapWorker;
        r106.mFrameIntervalNs = (long) (1.0E9f / r105);
        r102.set(r106);
    L21:
        r105 = 60.0f;
    L23:
        this.mGapWorker.add(this);
        return;
    L25:
        return;
    L5:
        if (isLayoutRequested() == true) goto L7;
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ItemAnimator r100 = this.mItemAnimator;
        if (r100 == null) goto L5;
        r100.endAnimations();
    L5:
        stopScroll();
        this.mIsAttached = false;
        LayoutManager r101 = this.mLayout;
        if (r101 == null) goto L8;
        r101.dispatchDetachedFromWindow(this, this.mRecycler);
    L8:
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.onDetach();
        if (ALLOW_THREAD_GAP_WORK == false) goto L14;
        GapWorker r102 = this.mGapWorker;
        if (r102 == null) goto L15;
        r102.remove(this);
        this.mGapWorker = null;
        return;
    L15:
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    public Adapter getAdapter() {
        return this.mAdapter;
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.mClipToPadding;
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public EdgeEffectFactory getEdgeEffectFactory() {
        return this.mEdgeEffectFactory;
    }

    public ItemAnimator getItemAnimator() {
        return this.mItemAnimator;
    }

    public LayoutManager getLayoutManager() {
        return this.mLayout;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public OnFlingListener getOnFlingListener() {
        return this.mOnFlingListener;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.mPreserveFocusAfterLayout;
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean hasFixedSize() {
        return this.mHasFixedSize;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.mIsAttached;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.mLayoutSuppressed;
    }

    public RecyclerView(Context r100) {
        this(r100, null);
    }

    public static /* synthetic */ boolean access$200(RecyclerView r100) {
        return r100.awakenScrollBars();
    }

    private void addAnimatingView(ViewHolder r100) {
        View r101 = r100.itemView;
        if (r101.getParent() != this) goto L5;
        boolean r102 = true;
    L6:
        this.mRecycler.unscrapView(getChildViewHolder(r101));
        if (r100.isTmpDetached() == false) goto L9;
        this.mChildHelper.attachViewToParent(r101, -1, r101.getLayoutParams(), true);
        return;
    L9:
        if (r102 == true) goto L11;
        this.mChildHelper.addView(r101, true);
        return;
    L11:
        this.mChildHelper.hide(r101);
        return;
    L5:
        r102 = false;
        goto L6
    }

    public static void clearNestedRecyclerViewIfNotNested(ViewHolder r100) {
        WeakReference<RecyclerView> r101 = r100.mNestedRecyclerView;
        if (r101 == null) goto L23;
        RecyclerView r102 = r101.get();
    L6:
        if (r102 == null) goto L14;
        if (r102 == r100.itemView) goto L9;
        Object r103 = r102.getParent();
        if ((r103 instanceof View) == true) goto L12;
        r102 = null;
        goto L6
    L12:
        r102 = (View) r103;
        goto L6
    L9:
        return;
    L14:
        r100.mNestedRecyclerView = null;
        return;
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent r100) {
        OnItemTouchListener r101 = this.mInterceptingOnItemTouchListener;
        if (r101 == null) goto L5;
        r101.onTouchEvent(this, r100);
        int r102 = r100.getAction();
        if (r102 == 3) goto L13;
        if (r102 == 1) goto L13;
    L14:
        return true;
    L13:
        this.mInterceptingOnItemTouchListener = null;
        goto L14
    L5:
        if (r100.getAction() != 0) goto L9;
        return false;
    L9:
        return findInterceptingOnItemTouchListener(r100);
    }

    private boolean findInterceptingOnItemTouchListener(MotionEvent r100) {
        int r101 = r100.getAction();
        int r102 = this.mOnItemTouchListeners.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        OnItemTouchListener r104 = (OnItemTouchListener) ListProtector.get(this.mOnItemTouchListeners, r103);
        if (r104.onInterceptTouchEvent(this, r100) == false) goto L10;
        if (r101 == 3) goto L10;
        this.mInterceptingOnItemTouchListener = r104;
        return true;
    L10:
        r103 = r103 + 1;
        goto L3
    L11:
        return false;
    }

    private void findMinMaxChildLayoutPositions(int[] r100) {
        int r101 = this.mChildHelper.getChildCount();
        if (r101 != 0) goto L6;
        r100[0] = -1;
        r100[1] = -1;
        return;
    L6:
        int r102 = Integer.MAX_VALUE;
        int r103 = Integer.MIN_VALUE;
        int r104 = 0;
    L7:
        if (r104 >= r101) goto L17;
        ViewHolder r105 = getChildViewHolderInt(this.mChildHelper.getChildAt(r104));
        if (r105.shouldIgnore() == true) goto L16;
        int r106 = r105.getLayoutPosition();
        if (r106 >= r102) goto L14;
        r102 = r106;
    L14:
        if (r106 <= r103) goto L16;
        r103 = r106;
    L16:
        r104 = r104 + 1;
        goto L7
    L17:
        r100[0] = r102;
        r100[1] = r103;
    }

    public static RecyclerView findNestedRecyclerView(View r100) {
        if ((r100 instanceof ViewGroup) == true) goto L6;
        return null;
    L6:
        if ((r100 instanceof RecyclerView) == true) goto L8;
        ViewGroup r101 = (ViewGroup) r100;
        int r102 = r101.getChildCount();
        int r103 = 0;
    L10:
        if (r103 >= r102) goto L15;
        RecyclerView r104 = findNestedRecyclerView(r101.getChildAt(r103));
        if (r104 != null) goto L13;
        r103 = r103 + 1;
        goto L10
    L13:
        return r104;
    L15:
        return null;
    L8:
        return (RecyclerView) r100;
    }

    public static ViewHolder getChildViewHolderInt(View r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return ((LayoutParams) r100.getLayoutParams()).mViewHolder;
    }

    private int getDeepestFocusedViewWithId(View r100) {
        int r101 = r100.getId();
    L4:
        if (r100.isFocused() == true) goto L12;
        if ((r100 instanceof ViewGroup) == false) goto L12;
        if (r100.hasFocus() == false) goto L12;
        r100 = ((ViewGroup) r100).getFocusedChild();
        if (r100.getId() == (-1)) goto L4;
        r101 = r100.getId();
    L12:
        return r101;
    }

    private void onPointerUp(MotionEvent r100) {
        int r101 = r100.getActionIndex();
        if (r100.getPointerId(r101) != this.mScrollPointerId) goto L9;
        if (r101 != 0) goto L6;
        int r102 = 1;
    L7:
        this.mScrollPointerId = r100.getPointerId(r102);
        int r103 = (int) (r100.getX(r102) + 0.5f);
        this.mLastTouchX = r103;
        this.mInitialTouchX = r103;
        int r104 = (int) (r100.getY(r102) + 0.5f);
        this.mLastTouchY = r104;
        this.mInitialTouchY = r104;
        return;
    L6:
        r102 = 0;
        goto L7
    }

    public void addItemDecoration(ItemDecoration r100) {
        addItemDecoration(r100, -1);
    }

    public void addOnChildAttachStateChangeListener(OnChildAttachStateChangeListener r100) {
        if (this.mOnChildAttachStateListeners != null) goto L5;
        this.mOnChildAttachStateListeners = new ArrayList();
    L5:
        this.mOnChildAttachStateListeners.add(r100);
    }

    public void addOnItemTouchListener(OnItemTouchListener r100) {
        this.mOnItemTouchListeners.add(r100);
    }

    public void addOnScrollListener(OnScrollListener r100) {
        if (this.mScrollListeners != null) goto L5;
        this.mScrollListeners = new ArrayList();
    L5:
        this.mScrollListeners.add(r100);
    }

    public void addRecyclerListener(RecyclerListener r100) {
        if (r100 == null) goto L4;
        boolean r101 = true;
    L5:
        Preconditions.checkArgument(r101, "'listener' arg cannot be null.");
        this.mRecyclerListeners.add(r100);
        return;
    L4:
        r101 = false;
        goto L5
    }

    public void assertInLayoutOrScroll(String r100) {
        if (isComputingLayout() == true) goto L9;
        if (r100 != null) goto L8;
        throw new IllegalStateException("Cannot call this method unless RecyclerView is computing a layout or scrolling" + exceptionLabel());
    L8:
        throw new IllegalStateException(r100 + exceptionLabel());
    }

    void assertNotInLayoutOrScroll(String r100) {
        if (isComputingLayout() == false) goto L10;
        if (r100 != null) goto L8;
        throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + exceptionLabel());
    L8:
        throw new IllegalStateException(r100);
    L10:
        if (this.mDispatchScrollCounter <= 0) goto L13;
        new IllegalStateException("" + exceptionLabel());
        return;
    }

    public boolean canReuseUpdatedViewHolder(ViewHolder r100) {
        ItemAnimator r101 = this.mItemAnimator;
        if (r101 != null) goto L5;
    L8:
        return true;
    L5:
        if (r101.canReuseUpdatedViewHolder(r100, r100.getUnmodifiedPayloads()) == true) goto L8;
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams r100) {
        if ((r100 instanceof LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mLayout.checkLayoutParams((LayoutParams) r100) == false) goto L7;
        return true;
    }

    void dispatchChildAttached(View r100) {
        ViewHolder r101 = getChildViewHolderInt(r100);
        onChildAttachedToWindow(r100);
        Adapter r102 = this.mAdapter;
        if (r102 == null) goto L6;
        if (r101 == null) goto L6;
        r102.onViewAttachedToWindow(r101);
    L6:
        List<OnChildAttachStateChangeListener> r103 = this.mOnChildAttachStateListeners;
        if (r103 == null) goto L11;
        int r104 = r103.size() - 1;
    L9:
        if (r104 < 0) goto L13;
        ((OnChildAttachStateChangeListener) ListProtector.get(this.mOnChildAttachStateListeners, r104)).onChildViewAttachedToWindow(r100);
        r104 = r104 - 1;
        goto L9
    L13:
        return;
    }

    void dispatchChildDetached(View r100) {
        ViewHolder r101 = getChildViewHolderInt(r100);
        onChildDetachedFromWindow(r100);
        Adapter r102 = this.mAdapter;
        if (r102 == null) goto L6;
        if (r101 == null) goto L6;
        r102.onViewDetachedFromWindow(r101);
    L6:
        List<OnChildAttachStateChangeListener> r103 = this.mOnChildAttachStateListeners;
        if (r103 == null) goto L11;
        int r104 = r103.size() - 1;
    L9:
        if (r104 < 0) goto L13;
        ((OnChildAttachStateChangeListener) ListProtector.get(this.mOnChildAttachStateListeners, r104)).onChildViewDetachedFromWindow(r100);
        r104 = r104 - 1;
        goto L9
    L13:
        return;
    }

    void dispatchOnScrollStateChanged(int r100) {
        LayoutManager r101 = this.mLayout;
        if (r101 == null) goto L5;
        r101.onScrollStateChanged(r100);
    L5:
        onScrollStateChanged(r100);
        OnScrollListener r102 = this.mScrollListener;
        if (r102 == null) goto L8;
        r102.onScrollStateChanged(this, r100);
    L8:
        List<OnScrollListener> r103 = this.mScrollListeners;
        if (r103 == null) goto L13;
        int r104 = r103.size() - 1;
    L11:
        if (r104 < 0) goto L15;
        ((OnScrollListener) ListProtector.get(this.mScrollListeners, r104)).onScrollStateChanged(this, r100);
        r104 = r104 - 1;
        goto L11
    L15:
        return;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r100) {
        onPopulateAccessibilityEvent(r100);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> r100) {
        dispatchThawSelfOnly(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> r100) {
        dispatchFreezeSelfOnly(r100);
    }

    @Override // android.view.View
    public void draw(Canvas r100) {
        super.draw(r100);
        int r101 = this.mItemDecorations.size();
        boolean r102 = false;
        int r103 = 0;
    L3:
        if (r103 >= r101) goto L5;
        ((ItemDecoration) ListProtector.get(this.mItemDecorations, r103)).onDrawOver(r100, this, this.mState);
        r103 = r103 + 1;
        goto L3
    L5:
        EdgeEffect r104 = this.mLeftGlow;
        boolean r105 = true;
        if (r104 != null) goto L8;
    L20:
        boolean r106 = false;
    L21:
        EdgeEffect r107 = this.mTopGlow;
        if (r107 != null) goto L24;
    L35:
        EdgeEffect r108 = this.mRightGlow;
        if (r108 != null) goto L38;
    L50:
        EdgeEffect r109 = this.mBottomGlow;
        if (r109 != null) goto L53;
    L64:
        if (r106 == false) goto L66;
    L72:
        r105 = r106;
    L73:
        if (r105 == false) goto L77;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L77:
        return;
    L66:
        if (this.mItemAnimator == null) goto L72;
        if (this.mItemDecorations.size() <= 0) goto L72;
        if (this.mItemAnimator.isRunning() == false) goto L72;
    L53:
        if (r109.isFinished() == true) goto L64;
        int r110 = r100.save();
        r100.rotate(180.0f);
        if (this.mClipToPadding == false) goto L57;
        r100.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
    L58:
        EdgeEffect r111 = this.mBottomGlow;
        if (r111 != null) goto L61;
    L63:
        r106 = r106 | r102;
        r100.restoreToCount(r110);
        goto L64
    L61:
        if (r111.draw(r100) == false) goto L63;
        r102 = true;
        goto L63
    L57:
        r100.translate(-getWidth(), -getHeight());
        goto L58
    L38:
        if (r108.isFinished() == true) goto L50;
        int r112 = r100.save();
        int r113 = getWidth();
        if (this.mClipToPadding == false) goto L42;
        int r114 = getPaddingTop();
    L43:
        r100.rotate(90.0f);
        r100.translate(r114, -r113);
        EdgeEffect r115 = this.mRightGlow;
        if (r115 != null) goto L46;
    L48:
        boolean r116 = false;
    L49:
        r106 = r106 | r116;
        r100.restoreToCount(r112);
        goto L50
    L46:
        if (r115.draw(r100) == false) goto L48;
        r116 = true;
        goto L49
    L42:
        r114 = 0;
        goto L43
    L24:
        if (r107.isFinished() == true) goto L35;
        int r117 = r100.save();
        if (this.mClipToPadding == false) goto L28;
        r100.translate(getPaddingLeft(), getPaddingTop());
    L28:
        EdgeEffect r118 = this.mTopGlow;
        if (r118 != null) goto L31;
    L33:
        boolean r119 = false;
    L34:
        r106 = r106 | r119;
        r100.restoreToCount(r117);
        goto L35
    L31:
        if (r118.draw(r100) == false) goto L33;
        r119 = true;
        goto L34
    L8:
        if (r104.isFinished() == true) goto L20;
        int r120 = r100.save();
        if (this.mClipToPadding == false) goto L12;
        int r121 = getPaddingBottom();
    L13:
        r100.rotate(270.0f);
        r100.translate((-getHeight()) + r121, 0.0f);
        EdgeEffect r122 = this.mLeftGlow;
        if (r122 != null) goto L16;
    L18:
        r106 = false;
    L19:
        r100.restoreToCount(r120);
        goto L21
    L16:
        if (r122.draw(r100) == false) goto L18;
        r106 = true;
        goto L19
    L12:
        r121 = 0;
        goto L13
    }

    public final void fillRemainingScrollValues(State r100) {
        if (getScrollState() != 2) goto L5;
        OverScroller r101 = this.mViewFlinger.mOverScroller;
        r100.mRemainingScrollHorizontal = r101.getFinalX() - r101.getCurrX();
        r100.mRemainingScrollVertical = r101.getFinalY() - r101.getCurrY();
        return;
    L5:
        r100.mRemainingScrollHorizontal = 0;
        r100.mRemainingScrollVertical = 0;
    }

    public View findContainingItemView(View r100) {
        ViewParent r101 = r100.getParent();
    L3:
        if (r101 == null) goto L8;
        if (r101 == this) goto L8;
        if ((r101 instanceof View) == false) goto L8;
        r100 = r101;
        r101 = r100.getParent();
    L8:
        if (r101 == this) goto L15;
        return null;
    L15:
        return r100;
    }

    public ViewHolder findContainingViewHolder(View r100) {
        View r101 = findContainingItemView(r100);
        if (r101 != null) goto L6;
        return null;
    L6:
        return getChildViewHolder(r101);
    }

    public ViewHolder findViewHolderForAdapterPosition(int r100) {
        ViewHolder r101 = null;
        if (this.mDataSetHasChangedAfterLayout == false) goto L5;
        return null;
    L5:
        int r102 = this.mChildHelper.getUnfilteredChildCount();
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L18;
        ViewHolder r104 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r103));
        if (r104 == null) goto L17;
        if (r104.isRemoved() == true) goto L17;
        if (getAdapterPositionInRecyclerView(r104) != r100) goto L17;
        if (this.mChildHelper.isHidden(r104.itemView) == false) goto L16;
        r101 = r104;
        goto L17
    L16:
        return r104;
    L17:
        r103 = r103 + 1;
        goto L6
    L18:
        return r101;
    }

    public ViewHolder findViewHolderForItemId(long r100) {
        Adapter r101 = this.mAdapter;
        ViewHolder r102 = null;
        if (r101 != null) goto L5;
    L20:
        return r102;
    L5:
        if (r101.hasStableIds() == false) goto L20;
        int r103 = this.mChildHelper.getUnfilteredChildCount();
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L20;
        ViewHolder r105 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r104));
        if (r105 == null) goto L19;
        if (r105.isRemoved() == true) goto L19;
        if (r105.getItemId() != r100) goto L19;
        if (this.mChildHelper.isHidden(r105.itemView) == false) goto L18;
        r102 = r105;
        goto L19
    L18:
        return r105;
    L19:
        r104 = r104 + 1;
        goto L8
    }

    public ViewHolder findViewHolderForLayoutPosition(int r100) {
        return findViewHolderForPosition(r100, false);
    }

    public ViewHolder findViewHolderForPosition(int r100) {
        return findViewHolderForPosition(r100, false);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r100) {
        LayoutManager r101 = this.mLayout;
        if (r101 == null) goto L7;
        return r101.generateLayoutParams(getContext(), r100);
    L7:
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    public int getAdapterPositionInRecyclerView(ViewHolder r100) {
        if (r100.hasAnyOfTheFlags(524) == false) goto L5;
        return -1;
    L5:
        if (r100.isBound() == true) goto L8;
        return -1;
    L8:
        return this.mAdapterHelper.applyPendingUpdatesToPosition(r100.mPosition);
    }

    public long getChangedHolderKey(ViewHolder r100) {
        if (this.mAdapter.hasStableIds() == false) goto L6;
        return r100.getItemId();
    L6:
        return r100.mPosition;
    }

    public int getChildAdapterPosition(View r100) {
        ViewHolder r101 = getChildViewHolderInt(r100);
        if (r101 != null) goto L7;
        return -1;
    L7:
        return r101.getAbsoluteAdapterPosition();
    }

    public long getChildItemId(View r100) {
        Adapter r101 = this.mAdapter;
        if (r101 != null) goto L5;
        return -1;
    L5:
        if (r101.hasStableIds() == false) goto L13;
        ViewHolder r102 = getChildViewHolderInt(r100);
        if (r102 != null) goto L10;
        return -1;
    L10:
        return r102.getItemId();
    L13:
        return -1;
    }

    public int getChildLayoutPosition(View r100) {
        ViewHolder r101 = getChildViewHolderInt(r100);
        if (r101 != null) goto L7;
        return -1;
    L7:
        return r101.getLayoutPosition();
    }

    public int getChildPosition(View r100) {
        return getChildAdapterPosition(r100);
    }

    public ViewHolder getChildViewHolder(View r100) {
        ViewParent r101 = r100.getParent();
        if (r101 == null) goto L9;
        if (r101 == this) goto L9;
        throw new IllegalArgumentException("View " + r100 + " is not a direct child of " + this);
    L9:
        return getChildViewHolderInt(r100);
    }

    Rect getItemDecorInsetsForChild(View r100) {
        LayoutParams r101 = (LayoutParams) r100.getLayoutParams();
        if (r101.mInsetsDirty == true) goto L7;
        return r101.mDecorInsets;
    L7:
        if (this.mState.isPreLayout() == true) goto L9;
    L14:
        Rect r102 = r101.mDecorInsets;
        r102.set(0, 0, 0, 0);
        int r103 = this.mItemDecorations.size();
        int r104 = 0;
    L15:
        if (r104 >= r103) goto L17;
        this.mTempRect.set(0, 0, 0, 0);
        ((ItemDecoration) ListProtector.get(this.mItemDecorations, r104)).getItemOffsets(this.mTempRect, r100, this, this.mState);
        int r105 = r102.left;
        Rect r106 = this.mTempRect;
        r102.left = r105 + r106.left;
        r102.top += r106.top;
        r102.right += r106.right;
        r102.bottom += r106.bottom;
        r104 = r104 + 1;
        goto L15
    L17:
        r101.mInsetsDirty = false;
        return r102;
    L9:
        if (r101.isItemChanged() == true) goto L13;
        if (r101.isViewInvalid() == false) goto L14;
    L13:
        return r101.mDecorInsets;
    }

    public ItemDecoration getItemDecorationAt(int r100) {
        int r101 = getItemDecorationCount();
        if (r100 < 0) goto L8;
        if (r100 >= r101) goto L8;
        return (ItemDecoration) ListProtector.get(this.mItemDecorations, r100);
    L8:
        throw new IndexOutOfBoundsException(r100 + " is an invalid index for size " + r101);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int r100) {
        return getScrollingChildHelper().hasNestedScrollingParent(r100);
    }

    void jumpToPositionForSmoothScroller(int r100) {
        if (this.mLayout != null) goto L5;
        return;
    L5:
        setScrollState(2);
        this.mLayout.scrollToPosition(r100);
        awakenScrollBars();
    }

    public void offsetChildrenHorizontal(int r100) {
        int r101 = this.mChildHelper.getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        this.mChildHelper.getChildAt(r102).offsetLeftAndRight(r100);
        r102 = r102 + 1;
        goto L3
    }

    public void offsetChildrenVertical(int r100) {
        int r101 = this.mChildHelper.getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        this.mChildHelper.getChildAt(r102).offsetTopAndBottom(r100);
        r102 = r102 + 1;
        goto L3
    }

    @Override // android.view.View
    public void onDraw(Canvas r100) {
        super.onDraw(r100);
        int r101 = this.mItemDecorations.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        ((ItemDecoration) ListProtector.get(this.mItemDecorations, r102)).onDraw(r100, this, this.mState);
        r102 = r102 + 1;
        goto L3
    }

    void onExitLayoutOrScroll(boolean r100) {
        int r101 = this.mLayoutOrScrollCounter - 1;
        this.mLayoutOrScrollCounter = r101;
        if (r101 >= 1) goto L8;
        this.mLayoutOrScrollCounter = 0;
        if (r100 == false) goto L9;
        dispatchContentChangedIfNecessary();
        dispatchPendingImportantForAccessibilityChanges();
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent r100) {
        if (this.mLayout != null) goto L6;
        return false;
    L6:
        if (this.mLayoutSuppressed == false) goto L9;
        return false;
    L9:
        if (r100.getAction() == 8) goto L11;
    L34:
        return false;
    L11:
        if ((r100.getSource() & 2) == 0) goto L20;
        if (this.mLayout.canScrollVertically() == false) goto L15;
        float r101 = -r100.getAxisValue(9);
    L17:
        if (this.mLayout.canScrollHorizontally() == false) goto L28;
        float r102 = r100.getAxisValue(10);
    L30:
        if (r101 == 0.0f) goto L32;
    L33:
        nestedScrollByInternal((int) (r102 * this.mScaledHorizontalScrollFactor), (int) (r101 * this.mScaledVerticalScrollFactor), r100, 1);
        goto L34
    L32:
        if (r102 == 0.0f) goto L34;
    L28:
        r102 = 0.0f;
        goto L30
    L15:
        r101 = 0.0f;
        goto L17
    L20:
        if ((r100.getSource() & 4194304) == 0) goto L27;
        float r103 = r100.getAxisValue(26);
        if (this.mLayout.canScrollVertically() == false) goto L25;
        r101 = -r103;
        goto L28
    L25:
        if (this.mLayout.canScrollHorizontally() == false) goto L27;
        r102 = r103;
        r101 = 0.0f;
    L27:
        r101 = 0.0f;
        goto L28
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.mLayoutSuppressed == false) goto L5;
        return false;
    L5:
        this.mInterceptingOnItemTouchListener = null;
        if (findInterceptingOnItemTouchListener(r100) == false) goto L9;
        cancelScroll();
        return true;
    L9:
        LayoutManager r101 = this.mLayout;
        if (r101 != null) goto L12;
        return false;
    L12:
        boolean r102 = r101.canScrollHorizontally();
        boolean r103 = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker != null) goto L15;
        this.mVelocityTracker = VelocityTracker.obtain();
    L15:
        this.mVelocityTracker.addMovement(r100);
        int r104 = r100.getActionMasked();
        int r105 = r100.getActionIndex();
        if (r104 == 0) goto L49;
        if (r104 == 1) goto L47;
        if (r104 != 2) goto L20;
        int r106 = r100.findPointerIndex(this.mScrollPointerId);
        if (r106 < 0) goto L32;
        int r107 = (int) (r100.getX(r106) + 0.5f);
        int r108 = (int) (r100.getY(r106) + 0.5f);
        if (this.mScrollState == 1) goto L59;
        int r109 = r107 - this.mInitialTouchX;
        int r110 = r108 - this.mInitialTouchY;
        if (r102 == true) goto L38;
    L40:
        boolean r111 = false;
    L41:
        if (r103 == true) goto L43;
    L45:
        if (r111 == false) goto L59;
        setScrollState(1);
        goto L59
    L43:
        if (Math.abs(r110) <= this.mTouchSlop) goto L45;
        this.mLastTouchY = r108;
        r111 = true;
        goto L45
    L38:
        if (Math.abs(r109) <= this.mTouchSlop) goto L40;
        this.mLastTouchX = r107;
        r111 = true;
    L59:
        if (this.mScrollState != 1) goto L62;
        return true;
    L62:
        return false;
    L32:
        return false;
    L20:
        if (r104 != 3) goto L22;
        cancelScroll();
        goto L59
    L22:
        if (r104 != 5) goto L24;
        this.mScrollPointerId = r100.getPointerId(r105);
        int r112 = (int) (r100.getX(r105) + 0.5f);
        this.mLastTouchX = r112;
        this.mInitialTouchX = r112;
        int r113 = (int) (r100.getY(r105) + 0.5f);
        this.mLastTouchY = r113;
        this.mInitialTouchY = r113;
        goto L59
    L24:
        if (r104 != 6) goto L59;
        onPointerUp(r100);
        goto L59
    L47:
        this.mVelocityTracker.clear();
        stopNestedScroll(0);
        goto L59
    L49:
        if (this.mIgnoreMotionEventTillDown == false) goto L51;
        this.mIgnoreMotionEventTillDown = false;
    L51:
        this.mScrollPointerId = r100.getPointerId(0);
        int r114 = (int) (r100.getX() + 0.5f);
        this.mLastTouchX = r114;
        this.mInitialTouchX = r114;
        int r115 = (int) (r100.getY() + 0.5f);
        this.mLastTouchY = r115;
        this.mInitialTouchY = r115;
        if (this.mScrollState != 2) goto L54;
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
        stopNestedScroll(1);
    L54:
        int[] r116 = this.mNestedOffsets;
        r116[1] = 0;
        r116[0] = 0;
        int r117 = r102;
        if (r103 == false) goto L57;
        r117 = (r102 ? 1 : 0) | 2;
    L57:
        startNestedScroll(r117, 0);
        goto L59
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r100);
        return;
    L6:
        SavedState r101 = (SavedState) r100;
        this.mPendingSavedState = r101;
        super.onRestoreInstanceState(r101.getSuperState());
        requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r110) {
        boolean r100 = false;
        if (this.mLayoutSuppressed == false) goto L5;
    L106:
        return false;
    L5:
        if (this.mIgnoreMotionEventTillDown == true) goto L106;
        if (dispatchToOnItemTouchListeners(r110) == false) goto L11;
        cancelScroll();
        return true;
    L11:
        LayoutManager r101 = this.mLayout;
        if (r101 != null) goto L14;
        return false;
    L14:
        boolean r111 = r101.canScrollHorizontally();
        boolean r112 = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker != null) goto L17;
        this.mVelocityTracker = VelocityTracker.obtain();
    L17:
        int r102 = r110.getActionMasked();
        int r103 = r110.getActionIndex();
        if (r102 != 0) goto L20;
        int[] r104 = this.mNestedOffsets;
        r104[1] = 0;
        r104[0] = 0;
    L20:
        MotionEvent r113 = MotionEvent.obtain(r110);
        int[] r105 = this.mNestedOffsets;
        r113.offsetLocation(r105[0], r105[1]);
        if (r102 == 0) goto L98;
        if (r102 != 1) goto L24;
        this.mVelocityTracker.addMovement(r113);
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
        if (r111 == false) goto L86;
        float r106 = -this.mVelocityTracker.getXVelocity(this.mScrollPointerId);
    L87:
        if (r112 == false) goto L89;
        float r107 = -this.mVelocityTracker.getYVelocity(this.mScrollPointerId);
    L91:
        if (r106 != 0.0f) goto L95;
        if (r107 != 0.0f) goto L95;
    L96:
        setScrollState(0);
    L97:
        resetScroll();
        r100 = true;
    L102:
        if (r100 == true) goto L104;
        this.mVelocityTracker.addMovement(r113);
    L104:
        r113.recycle();
        return true;
    L95:
        if (fling((int) r106, (int) r107) == true) goto L97;
    L89:
        r107 = 0.0f;
        goto L91
    L86:
        r106 = 0.0f;
        goto L87
    L24:
        if (r102 != 2) goto L26;
        int r108 = r110.findPointerIndex(this.mScrollPointerId);
        if (r108 < 0) goto L38;
        int r114 = (int) (r110.getX(r108) + 0.5f);
        int r115 = (int) (r110.getY(r108) + 0.5f);
        int r109 = this.mLastTouchX - r114;
        int r116 = this.mLastTouchY - r115;
        if (this.mScrollState == 1) goto L56;
        if (r111 == false) goto L47;
        if (r109 <= 0) goto L44;
        r109 = Math.max(0, r109 - this.mTouchSlop);
    L45:
        if (r109 == 0) goto L47;
        boolean r117 = true;
    L48:
        if (r112 == false) goto L54;
        if (r116 <= 0) goto L51;
        r116 = Math.max(0, r116 - this.mTouchSlop);
    L52:
        if (r116 == 0) goto L54;
        r117 = true;
        goto L54
    L51:
        r116 = Math.min(0, r116 + this.mTouchSlop);
    L54:
        if (r117 == false) goto L56;
        setScrollState(1);
        goto L56
    L44:
        r109 = Math.min(0, r109 + this.mTouchSlop);
    L47:
        r117 = false;
    L56:
        int r118 = r109;
        int r119 = r116;
        if (this.mScrollState != 1) goto L102;
        int[] r120 = this.mReusableIntPair;
        r120[0] = 0;
        r120[1] = 0;
        if (r111 == false) goto L61;
        int r121 = r118;
    L62:
        if (r112 == false) goto L64;
        int r122 = r119;
    L66:
        if (dispatchNestedPreScroll(r121, r122, r120, this.mScrollOffset, 0) == false) goto L68;
        int[] r123 = this.mReusableIntPair;
        r118 = r118 - r123[0];
        r119 = r119 - r123[1];
        int[] r124 = this.mNestedOffsets;
        int r125 = r124[0];
        int[] r126 = this.mScrollOffset;
        r124[0] = r125 + r126[0];
        r124[1] = r124[1] + r126[1];
        getParent().requestDisallowInterceptTouchEvent(true);
    L68:
        int r127 = r119;
        int[] r128 = this.mScrollOffset;
        this.mLastTouchX = r114 - r128[0];
        this.mLastTouchY = r115 - r128[1];
        if (r111 == false) goto L71;
        int r129 = r118;
    L72:
        if (r112 == false) goto L74;
        int r130 = r127;
    L76:
        if (scrollByInternal(r129, r130, r110, 0) == false) goto L78;
        getParent().requestDisallowInterceptTouchEvent(true);
    L78:
        GapWorker r131 = this.mGapWorker;
        if (r131 == null) goto L102;
        if (r118 != 0) goto L82;
        if (r127 == 0) goto L102;
    L82:
        r131.postFromTraversal(this, r118, r127);
        goto L102
    L74:
        r130 = 0;
        goto L76
    L71:
        r129 = 0;
        goto L72
    L64:
        r122 = 0;
        goto L66
    L61:
        r121 = 0;
        goto L62
    L38:
        return false;
    L26:
        if (r102 != 3) goto L28;
        cancelScroll();
        goto L102
    L28:
        if (r102 != 5) goto L30;
        this.mScrollPointerId = r110.getPointerId(r103);
        int r132 = (int) (r110.getX(r103) + 0.5f);
        this.mLastTouchX = r132;
        this.mInitialTouchX = r132;
        int r133 = (int) (r110.getY(r103) + 0.5f);
        this.mLastTouchY = r133;
        this.mInitialTouchY = r133;
        goto L102
    L30:
        if (r102 != 6) goto L102;
        onPointerUp(r110);
        goto L102
    L98:
        this.mScrollPointerId = r110.getPointerId(0);
        int r134 = (int) (r110.getX() + 0.5f);
        this.mLastTouchX = r134;
        this.mInitialTouchX = r134;
        int r135 = (int) (r110.getY() + 0.5f);
        this.mLastTouchY = r135;
        this.mInitialTouchY = r135;
        int r136 = r111;
        if (r112 == false) goto L101;
        r136 = (r111 ? 1 : 0) | 2;
    L101:
        startNestedScroll(r136, 0);
        goto L102
    }

    void processDataSetCompletelyChanged(boolean r100) {
        this.mDispatchItemsChangedEvent = r100 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    boolean removeAnimatingView(View r100) {
        startInterceptRequestLayout();
        boolean r101 = this.mChildHelper.removeViewIfHidden(r100);
        if (r101 == false) goto L5;
        ViewHolder r102 = getChildViewHolderInt(r100);
        this.mRecycler.unscrapView(r102);
        this.mRecycler.recycleViewHolderInternal(r102);
    L5:
        stopInterceptRequestLayout(!r101);
        return r101;
    }

    public void removeItemDecoration(ItemDecoration r100) {
        LayoutManager r101 = this.mLayout;
        if (r101 == null) goto L5;
        r101.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
    L5:
        this.mItemDecorations.remove(r100);
        if (this.mItemDecorations.isEmpty() == true) goto L8;
    L12:
        markItemDecorInsetsDirty();
        requestLayout();
        return;
    L8:
        if (getOverScrollMode() != 2) goto L10;
        boolean r102 = true;
    L11:
        setWillNotDraw(r102);
        goto L12
    L10:
        r102 = false;
        goto L11
    }

    public void removeItemDecorationAt(int r100) {
        int r101 = getItemDecorationCount();
        if (r100 < 0) goto L8;
        if (r100 >= r101) goto L8;
        removeItemDecoration(getItemDecorationAt(r100));
        return;
    L8:
        throw new IndexOutOfBoundsException(r100 + " is an invalid index for size " + r101);
    }

    public void removeOnChildAttachStateChangeListener(OnChildAttachStateChangeListener r100) {
        List<OnChildAttachStateChangeListener> r101 = this.mOnChildAttachStateListeners;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.remove(r100);
    }

    public void removeOnItemTouchListener(OnItemTouchListener r100) {
        this.mOnItemTouchListeners.remove(r100);
        if (this.mInterceptingOnItemTouchListener != r100) goto L6;
        this.mInterceptingOnItemTouchListener = null;
        return;
    }

    public void removeOnScrollListener(OnScrollListener r100) {
        List<OnScrollListener> r101 = this.mScrollListeners;
        if (r101 == null) goto L6;
        r101.remove(r100);
        return;
    }

    public void removeRecyclerListener(RecyclerListener r100) {
        this.mRecyclerListeners.remove(r100);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r100) {
        int r101 = this.mOnItemTouchListeners.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        ((OnItemTouchListener) ListProtector.get(this.mOnItemTouchListeners, r102)).onRequestDisallowInterceptTouchEvent(r100);
        r102 = r102 + 1;
        goto L3
    L5:
        super.requestDisallowInterceptTouchEvent(r100);
    }

    public void scrollToPosition(int r100) {
        if (this.mLayoutSuppressed == false) goto L5;
        return;
    L5:
        stopScroll();
        LayoutManager r101 = this.mLayout;
        if (r101 != null) goto L8;
        return;
    L8:
        r101.scrollToPosition(r100);
        awakenScrollBars();
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent r100) {
        if (shouldDeferAccessibilityEvent(r100) == false) goto L5;
        return;
    L5:
        super.sendAccessibilityEventUnchecked(r100);
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate r100) {
        this.mAccessibilityDelegate = r100;
        ViewCompat.setAccessibilityDelegate(this, r100);
    }

    public void setAdapter(Adapter r100) {
        setLayoutFrozen(false);
        setAdapterInternal(r100, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(ChildDrawingOrderCallback r100) {
        if (r100 != this.mChildDrawingOrderCallback) goto L5;
        return;
    L5:
        this.mChildDrawingOrderCallback = r100;
        if (r100 == null) goto L8;
        boolean r101 = true;
    L9:
        setChildrenDrawingOrderEnabled(r101);
        return;
    L8:
        r101 = false;
        goto L9
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean r100) {
        if (r100 == this.mClipToPadding) goto L5;
        invalidateGlows();
    L5:
        this.mClipToPadding = r100;
        super.setClipToPadding(r100);
        if (this.mFirstLayoutComplete == false) goto L9;
        requestLayout();
        return;
    }

    public void setEdgeEffectFactory(EdgeEffectFactory r100) {
        Preconditions.checkNotNull(r100);
        this.mEdgeEffectFactory = r100;
        invalidateGlows();
    }

    public void setHasFixedSize(boolean r100) {
        this.mHasFixedSize = r100;
    }

    public void setItemAnimator(ItemAnimator r100) {
        ItemAnimator r101 = this.mItemAnimator;
        if (r101 == null) goto L5;
        r101.endAnimations();
        this.mItemAnimator.setListener(null);
    L5:
        this.mItemAnimator = r100;
        if (r100 == null) goto L9;
        r100.setListener(this.mItemAnimatorListener);
        return;
    }

    public void setItemViewCacheSize(int r100) {
        this.mRecycler.setViewCacheSize(r100);
    }

    public void setLayoutFrozen(boolean r100) {
        suppressLayout(r100);
    }

    public void setLayoutManager(LayoutManager r100) {
        if (r100 != this.mLayout) goto L5;
        return;
    L5:
        stopScroll();
        if (this.mLayout == null) goto L14;
        ItemAnimator r101 = this.mItemAnimator;
        if (r101 == null) goto L10;
        r101.endAnimations();
    L10:
        this.mLayout.removeAndRecycleAllViews(this.mRecycler);
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        this.mRecycler.clear();
        if (this.mIsAttached == false) goto L13;
        this.mLayout.dispatchDetachedFromWindow(this, this.mRecycler);
    L13:
        this.mLayout.setRecyclerView(null);
        this.mLayout = null;
    L15:
        this.mChildHelper.removeAllViewsUnfiltered();
        this.mLayout = r100;
        if (r100 != null) goto L18;
    L24:
        this.mRecycler.updateViewCacheSize();
        requestLayout();
        return;
    L18:
        if (r100.mRecyclerView != null) goto L23;
        r100.setRecyclerView(this);
        if (this.mIsAttached == false) goto L24;
        this.mLayout.dispatchAttachedToWindow(this);
        goto L24
    L23:
        throw new IllegalArgumentException("LayoutManager " + r100 + " is already attached to a RecyclerView:" + r100.mRecyclerView.exceptionLabel());
    L14:
        this.mRecycler.clear();
        goto L15
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition r100) {
        if (r100 != null) goto L6;
        super.setLayoutTransition(null);
        return;
    L6:
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r100) {
        getScrollingChildHelper().setNestedScrollingEnabled(r100);
    }

    public void setOnFlingListener(OnFlingListener r100) {
        this.mOnFlingListener = r100;
    }

    public void setOnScrollListener(OnScrollListener r100) {
        this.mScrollListener = r100;
    }

    public void setPreserveFocusAfterLayout(boolean r100) {
        this.mPreserveFocusAfterLayout = r100;
    }

    public void setRecycledViewPool(RecycledViewPool r100) {
        this.mRecycler.setRecycledViewPool(r100);
    }

    public void setRecyclerListener(RecyclerListener r100) {
        this.mRecyclerListener = r100;
    }

    void setScrollState(int r100) {
        if (r100 != this.mScrollState) goto L5;
        return;
    L5:
        this.mScrollState = r100;
        if (r100 == 2) goto L8;
        stopScrollersInternal();
    L8:
        dispatchOnScrollStateChanged(r100);
    }

    public void setScrollingTouchSlop(int r100) {
        ViewConfiguration r101 = ViewConfiguration.get(getContext());
        if (r100 != 0) goto L5;
    L8:
        this.mTouchSlop = r101.getScaledTouchSlop();
        return;
    L5:
        if (r100 != 1) goto L8;
        this.mTouchSlop = r101.getScaledPagingTouchSlop();
    }

    public void setViewCacheExtension(ViewCacheExtension r100) {
        this.mRecycler.setViewCacheExtension(r100);
    }

    boolean shouldDeferAccessibilityEvent(AccessibilityEvent r100) {
        int r101 = 0;
        if (isComputingLayout() == false) goto L12;
        if (r100 == null) goto L6;
        int r102 = AccessibilityEventCompat.getContentChangeTypes(r100);
    L7:
        if (r102 == 0) goto L10;
        r101 = r102;
    L10:
        this.mEatenAccessibilityChangeFlags |= r101;
        return true;
    L6:
        r102 = 0;
        goto L7
    L12:
        return false;
    }

    public void smoothScrollToPosition(int r100) {
        if (this.mLayoutSuppressed == false) goto L5;
        return;
    L5:
        LayoutManager r101 = this.mLayout;
        if (r101 != null) goto L8;
        return;
    L8:
        r101.smoothScrollToPosition(this, this.mState, r100);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int r100) {
        return getScrollingChildHelper().startNestedScroll(r100);
    }

    void stopInterceptRequestLayout(boolean r100) {
        if (this.mInterceptRequestLayoutDepth >= 1) goto L6;
        this.mInterceptRequestLayoutDepth = 1;
    L6:
        if (r100 == true) goto L11;
        if (this.mLayoutSuppressed == true) goto L11;
        this.mLayoutWasDefered = false;
    L11:
        if (this.mInterceptRequestLayoutDepth != 1) goto L25;
        if (r100 == false) goto L23;
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

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int r100) {
        getScrollingChildHelper().stopNestedScroll(r100);
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean r110) {
        if (r110 == this.mLayoutSuppressed) goto L16;
        assertNotInLayoutOrScroll("Do not suppressLayout in layout or scroll");
        if (r110 == true) goto L14;
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
        long r100 = SystemClock.uptimeMillis();
        onTouchEvent(MotionEvent.obtain(r100, r100, 3, 0.0f, 0.0f, 0));
        this.mLayoutSuppressed = true;
        this.mIgnoreMotionEventTillDown = true;
        stopScroll();
        return;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        LayoutManager r101 = this.mLayout;
        if (r101 == null) goto L7;
        return r101.generateLayoutParams(r100);
    L7:
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    public RecyclerView(Context r100, AttributeSet r101) {
        this(r100, r101, com.larus.nova.R.attr.recyclerViewStyle);
    }

    public static /* synthetic */ void access$100(RecyclerView r100, int r101) {
        r100.detachViewFromParent(r101);
    }

    private boolean didChildRangeChange(int r100, int r101) {
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        int[] r102 = this.mMinMaxLayoutPositions;
        if (r102[0] == r100) goto L5;
    L6:
        return true;
    L5:
        if (r102[1] != r101) goto L6;
        return false;
    }

    static void getDecoratedBoundsWithMarginsInt(View r100, Rect r101) {
        LayoutParams r102 = (LayoutParams) r100.getLayoutParams();
        Rect r103 = r102.mDecorInsets;
        r101.set((r100.getLeft() - r103.left) - ((ViewGroup.MarginLayoutParams) r102).leftMargin, (r100.getTop() - r103.top) - ((ViewGroup.MarginLayoutParams) r102).topMargin, (r100.getRight() + r103.right) + ((ViewGroup.MarginLayoutParams) r102).rightMargin, (r100.getBottom() + r103.bottom) + ((ViewGroup.MarginLayoutParams) r102).bottomMargin);
    }

    private String getFullClassName(Context r100, String r101) {
        if (r101.charAt(0) != '.') goto L7;
        return r100.getPackageName() + r101;
    L7:
        if (r101.contains(".") == false) goto L10;
        return r101;
    L10:
        return RecyclerView.class.getPackage().getName() + '.' + r101;
    }

    private void requestChildOnScreen(View r110, View r111) {
        if (r111 == null) goto L4;
        View r100 = r111;
    L5:
        this.mTempRect.set(0, 0, r100.getWidth(), r100.getHeight());
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if ((r101 instanceof LayoutParams) == false) goto L10;
        LayoutParams r102 = (LayoutParams) r101;
        if (r102.mInsetsDirty == true) goto L10;
        Rect r103 = r102.mDecorInsets;
        Rect r104 = this.mTempRect;
        r104.left -= r103.left;
        r104.right += r103.right;
        r104.top -= r103.top;
        r104.bottom += r103.bottom;
    L10:
        if (r111 == null) goto L12;
        offsetDescendantRectToMyCoords(r111, this.mTempRect);
        offsetRectIntoDescendantCoords(r110, this.mTempRect);
    L12:
        LayoutManager r105 = this.mLayout;
        Rect r106 = this.mTempRect;
        boolean r107 = !this.mFirstLayoutComplete;
        if (r111 != null) goto L15;
        boolean r112 = true;
    L16:
        r105.requestChildRectangleOnScreen(this, r110, r106, r107, r112);
        return;
    L15:
        r112 = false;
        goto L16
    L4:
        r100 = r110;
        goto L5
    }

    void absorbGlows(int r100, int r101) {
        if (r100 >= 0) goto L6;
        ensureLeftGlow();
        if (this.mLeftGlow.isFinished() == false) goto L10;
        this.mLeftGlow.onAbsorb(-r100);
    L10:
        if (r101 >= 0) goto L14;
        ensureTopGlow();
        if (this.mTopGlow.isFinished() == false) goto L18;
        this.mTopGlow.onAbsorb(-r101);
    L18:
        if (r100 != 0) goto L20;
        if (r101 != 0) goto L20;
        return;
    L20:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L14:
        if (r101 <= 0) goto L18;
        ensureBottomGlow();
        if (this.mBottomGlow.isFinished() == false) goto L18;
        this.mBottomGlow.onAbsorb(r101);
        goto L18
    L6:
        if (r100 <= 0) goto L10;
        ensureRightGlow();
        if (this.mRightGlow.isFinished() == false) goto L10;
        this.mRightGlow.onAbsorb(r100);
        goto L10
    }

    public void addItemDecoration(ItemDecoration r100, int r101) {
        LayoutManager r102 = this.mLayout;
        if (r102 == null) goto L6;
        r102.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
    L6:
        if (this.mItemDecorations.isEmpty() == false) goto L8;
        setWillNotDraw(false);
    L8:
        if (r101 >= 0) goto L10;
        this.mItemDecorations.add(r100);
    L11:
        markItemDecorInsetsDirty();
        requestLayout();
        return;
    L10:
        ListProtector.add(this.mItemDecorations, r101, r100);
        goto L11
    }

    public void considerReleasingGlowsOnScroll(int r100, int r101) {
        EdgeEffect r102 = this.mLeftGlow;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = false;
    L9:
        EdgeEffect r104 = this.mRightGlow;
        if (r104 != null) goto L12;
    L15:
        EdgeEffect r105 = this.mTopGlow;
        if (r105 != null) goto L18;
    L21:
        EdgeEffect r106 = this.mBottomGlow;
        if (r106 != null) goto L24;
    L27:
        if (r103 == false) goto L30;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L30:
        return;
    L24:
        if (r106.isFinished() == true) goto L27;
        if (r101 >= 0) goto L27;
        this.mBottomGlow.onRelease();
        r103 = r103 | this.mBottomGlow.isFinished();
        goto L27
    L18:
        if (r105.isFinished() == true) goto L21;
        if (r101 <= 0) goto L21;
        this.mTopGlow.onRelease();
        r103 = r103 | this.mTopGlow.isFinished();
        goto L21
    L12:
        if (r104.isFinished() == true) goto L15;
        if (r100 >= 0) goto L15;
        this.mRightGlow.onRelease();
        r103 = r103 | this.mRightGlow.isFinished();
        goto L15
    L5:
        if (r102.isFinished() == true) goto L8;
        if (r100 <= 0) goto L8;
        this.mLeftGlow.onRelease();
        r103 = this.mLeftGlow.isFinished();
        goto L9
    }

    void defaultOnMeasure(int r100, int r101) {
        setMeasuredDimension(LayoutManager.chooseSize(r100, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), LayoutManager.chooseSize(r101, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float r100, float r101) {
        return getScrollingChildHelper().dispatchNestedPreFling(r100, r101);
    }

    void dispatchOnScrolled(int r100, int r101) {
        this.mDispatchScrollCounter++;
        int r102 = getScrollX();
        int r103 = getScrollY();
        onScrollChanged(r102, r103, r102 - r100, r103 - r101);
        onScrolled(r100, r101);
        OnScrollListener r104 = this.mScrollListener;
        if (r104 == null) goto L5;
        r104.onScrolled(this, r100, r101);
    L5:
        List<OnScrollListener> r105 = this.mScrollListeners;
        if (r105 == null) goto L10;
        int r106 = r105.size() - 1;
    L8:
        if (r106 < 0) goto L10;
        ((OnScrollListener) ListProtector.get(this.mScrollListeners, r106)).onScrolled(this, r100, r101);
        r106 = r106 - 1;
    L10:
        this.mDispatchScrollCounter--;
    }

    public View findChildViewUnder(float r100, float r101) {
        int r102 = this.mChildHelper.getChildCount() - 1;
    L3:
        if (r102 < 0) goto L14;
        View r103 = this.mChildHelper.getChildAt(r102);
        float r104 = r103.getTranslationX();
        float r105 = r103.getTranslationY();
        if (r100 < (r103.getLeft() + r104)) goto L13;
        if (r100 > (r103.getRight() + r104)) goto L13;
        if (r101 < (r103.getTop() + r105)) goto L13;
        if (r101 > (r103.getBottom() + r105)) goto L13;
        return r103;
    L13:
        r102 = r102 - 1;
        goto L3
    L14:
        return null;
    }

    public ViewHolder findViewHolderForPosition(int r100, boolean r101) {
        int r102 = this.mChildHelper.getUnfilteredChildCount();
        ViewHolder r103 = null;
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L20;
        ViewHolder r105 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r104));
        if (r105 == null) goto L19;
        if (r105.isRemoved() == true) goto L19;
        if (r101 == false) goto L13;
        if (r105.mPosition != r100) goto L19;
    L16:
        if (this.mChildHelper.isHidden(r105.itemView) == false) goto L18;
        r103 = r105;
        goto L19
    L18:
        return r105;
    L13:
        if (r105.getLayoutPosition() == r100) goto L16;
    L19:
        r104 = r104 + 1;
        goto L3
    L20:
        return r103;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean fling(int r100, int r101) {
        LayoutManager r102 = this.mLayout;
        if (r102 != null) goto L6;
        return false;
    L6:
        if (this.mLayoutSuppressed == false) goto L8;
        return false;
    L8:
        int r103 = r102.canScrollHorizontally();
        boolean r104 = this.mLayout.canScrollVertically();
        if (r103 != 0) goto L11;
    L12:
        r100 = 0;
    L13:
        if (r104 == true) goto L15;
    L16:
        r101 = 0;
    L17:
        if (r100 != 0) goto L20;
        if (r101 != 0) goto L20;
        return false;
    L20:
        float r105 = r100;
        float r106 = r101;
        if (dispatchNestedPreFling(r105, r106) == false) goto L23;
    L38:
        return false;
    L23:
        if (r103 != 0) goto L27;
        if (r104 == true) goto L27;
        boolean r107 = false;
    L28:
        dispatchNestedFling(r105, r106, r107);
        OnFlingListener r108 = this.mOnFlingListener;
        if (r108 != null) goto L31;
    L33:
        if (r107 == false) goto L38;
        if (r104 == false) goto L36;
        r103 = (r103 == true ? 1 : 0) | 2;
    L36:
        startNestedScroll(r103, 1);
        int r109 = this.mMaxFlingVelocity;
        int r110 = Math.max(-r109, Math.min(r100, r109));
        int r111 = this.mMaxFlingVelocity;
        this.mViewFlinger.fling(r110, Math.max(-r111, Math.min(r101, r111)));
        return true;
    L31:
        if (r108.onFling(r100, r101) == false) goto L33;
        return true;
    L27:
        r107 = true;
        goto L28
    L15:
        if (Math.abs(r101) >= this.mMinFlingVelocity) goto L17;
    L11:
        if (Math.abs(r100) >= this.mMinFlingVelocity) goto L13;
        goto L12
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View r100, int r110) {
        View r101 = this.mLayout.onInterceptFocusSearch(r100, r110);
        if (r101 == null) goto L5;
        return r101;
    L5:
        boolean r102 = true;
        if (this.mAdapter != null) goto L8;
    L14:
        boolean r103 = false;
    L15:
        FocusFinder r104 = FocusFinder.getInstance();
        if (r103 == true) goto L18;
    L61:
        View r105 = r104.findNextFocus(this, r100, r110);
        if (r105 != null) goto L68;
        if (r103 == false) goto L68;
        consumePendingUpdateOperations();
        if (findContainingItemView(r100) != null) goto L67;
        return null;
    L67:
        startInterceptRequestLayout();
        View r106 = this.mLayout.onFocusSearchFailed(r100, r110, this.mRecycler, this.mState);
        stopInterceptRequestLayout(false);
    L69:
        if (r106 == null) goto L79;
        if (r106.hasFocusable() == true) goto L79;
        if (getFocusedChild() == null) goto L75;
        requestChildOnScreen(r106, null);
        return r100;
    L75:
        return super.focusSearch(r100, r110);
    L79:
        if (isPreferredNextFocus(r100, r106, r110) == false) goto L82;
        return r106;
    L82:
        return super.focusSearch(r100, r110);
    L68:
        r106 = r105;
        goto L69
    L18:
        if (r110 == 2) goto L21;
        if (r110 != 1) goto L61;
    L21:
        if (this.mLayout.canScrollVertically() == false) goto L32;
        if (r110 != 2) goto L24;
        int r107 = 130;
    L26:
        if (r104.findNextFocus(this, r100, r107) != null) goto L28;
        boolean r108 = true;
    L30:
        if (FORCE_ABS_FOCUS_SEARCH_DIRECTION == false) goto L33;
        r110 = r107;
    L33:
        if (r108 == false) goto L35;
    L55:
        if (r108 == false) goto L60;
        consumePendingUpdateOperations();
        if (findContainingItemView(r100) != null) goto L59;
        return null;
    L59:
        startInterceptRequestLayout();
        this.mLayout.onFocusSearchFailed(r100, r110, this.mRecycler, this.mState);
        stopInterceptRequestLayout(false);
    L60:
        r106 = r104.findNextFocus(this, r100, r110);
        goto L69
    L35:
        if (this.mLayout.canScrollHorizontally() == false) goto L55;
        if (this.mLayout.getLayoutDirection() != 1) goto L39;
        boolean r109 = true;
    L40:
        if (r110 != 2) goto L42;
        boolean r111 = true;
    L44:
        if ((r109 ^ r111) == false) goto L46;
        int r112 = 66;
    L48:
        if (r104.findNextFocus(this, r100, r112) == null) goto L52;
        r102 = false;
    L52:
        if (FORCE_ABS_FOCUS_SEARCH_DIRECTION == false) goto L54;
        r110 = r112;
    L54:
        r108 = r102;
        goto L55
    L46:
        r112 = 17;
        goto L48
    L42:
        r111 = false;
        goto L44
    L39:
        r109 = false;
        goto L40
    L28:
        r108 = false;
        goto L30
    L24:
        r107 = 33;
        goto L26
    L32:
        r108 = false;
        goto L33
    L8:
        if (this.mLayout == null) goto L14;
        if (isComputingLayout() == true) goto L14;
        if (this.mLayoutSuppressed == true) goto L14;
        r103 = true;
        goto L15
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int r100, int r101) {
        ChildDrawingOrderCallback r102 = this.mChildDrawingOrderCallback;
        if (r102 != null) goto L7;
        return super.getChildDrawingOrder(r100, r101);
    L7:
        return r102.onGetChildDrawingOrder(r100, r101);
    }

    public void getDecoratedBoundsWithMargins(View r100, Rect r101) {
        getDecoratedBoundsWithMarginsInt(r100, r101);
    }

    public void nestedScrollBy(int r100, int r101) {
        nestedScrollByInternal(r100, r101, null, 1);
    }

    void offsetPositionRecordsForInsert(int r100, int r101) {
        int r102 = this.mChildHelper.getUnfilteredChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L12;
        ViewHolder r104 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r103));
        if (r104 == null) goto L11;
        if (r104.shouldIgnore() == true) goto L11;
        if (r104.mPosition < r100) goto L11;
        r104.offsetPosition(r101, false);
        this.mState.mStructureChanged = true;
    L11:
        r103 = r103 + 1;
        goto L3
    L12:
        this.mRecycler.offsetPositionRecordsForInsert(r100, r101);
        requestLayout();
    }

    void offsetPositionRecordsForMove(int r110, int r111) {
        int r100 = this.mChildHelper.getUnfilteredChildCount();
        if (r110 >= r111) goto L5;
        int r101 = -1;
        int r102 = r110;
        int r103 = r111;
    L6:
        int r104 = 0;
    L7:
        if (r104 >= r100) goto L19;
        ViewHolder r105 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r104));
        if (r105 == null) goto L18;
        int r106 = r105.mPosition;
        if (r106 < r102) goto L18;
        if (r106 > r103) goto L18;
        if (r106 != r110) goto L16;
        r105.offsetPosition(r111 - r110, false);
    L17:
        this.mState.mStructureChanged = true;
        goto L18
    L16:
        r105.offsetPosition(r101, false);
    L18:
        r104 = r104 + 1;
        goto L7
    L19:
        this.mRecycler.offsetPositionRecordsForMove(r110, r111);
        requestLayout();
        return;
    L5:
        r103 = r110;
        r102 = r111;
        r101 = 1;
        goto L6
    }

    @Override // android.view.View
    public void onMeasure(int r100, int r101) {
        LayoutManager r102 = this.mLayout;
        if (r102 != null) goto L6;
        defaultOnMeasure(r100, r101);
        return;
    L6:
        boolean r103 = false;
        if (r102.isAutoMeasureEnabled() == false) goto L26;
        int r104 = View.MeasureSpec.getMode(r100);
        int r105 = View.MeasureSpec.getMode(r101);
        this.mLayout.onMeasure(this.mRecycler, this.mState, r100, r101);
        if (r104 != 1073741824) goto L12;
        if (r105 != 1073741824) goto L12;
        r103 = true;
    L12:
        this.mLastAutoMeasureSkippedDueToExact = r103;
        if (r103 == false) goto L15;
        return;
    L15:
        if (this.mAdapter != null) goto L18;
        return;
    L18:
        if (this.mState.mLayoutStep != 1) goto L20;
        dispatchLayoutStep1();
    L20:
        this.mLayout.setMeasureSpecs(r100, r101);
        this.mState.mIsMeasuring = true;
        dispatchLayoutStep2();
        this.mLayout.setMeasuredDimensionFromChildren(r100, r101);
        if (this.mLayout.shouldMeasureTwice() == false) goto L23;
        this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        this.mState.mIsMeasuring = true;
        dispatchLayoutStep2();
        this.mLayout.setMeasuredDimensionFromChildren(r100, r101);
    L23:
        this.mLastAutoMeasureNonExactMeasuredWidth = getMeasuredWidth();
        this.mLastAutoMeasureNonExactMeasuredHeight = getMeasuredHeight();
        return;
    L26:
        if (this.mHasFixedSize == false) goto L30;
        this.mLayout.onMeasure(this.mRecycler, this.mState, r100, r101);
        return;
    L30:
        if (this.mAdapterUpdateDuringMeasure == false) goto L37;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        onExitLayoutOrScroll();
        State r106 = this.mState;
        if (r106.mRunPredictiveAnimations == false) goto L34;
        r106.mInPreLayout = true;
    L35:
        this.mAdapterUpdateDuringMeasure = false;
        stopInterceptRequestLayout(false);
    L40:
        Adapter r107 = this.mAdapter;
        if (r107 == null) goto L43;
        State r108 = this.mState;
        r108.mItemCount = r107.getItemCount();
    L44:
        startInterceptRequestLayout();
        this.mLayout.onMeasure(this.mRecycler, this.mState, r100, r101);
        stopInterceptRequestLayout(false);
        this.mState.mInPreLayout = false;
        return;
    L43:
        this.mState.mItemCount = 0;
        goto L44
    L34:
        this.mAdapterHelper.consumeUpdatesInOnePass();
        this.mState.mInPreLayout = false;
        goto L35
    L37:
        if (this.mState.mRunPredictiveAnimations == false) goto L40;
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int r100, Rect r101) {
        if (isComputingLayout() == false) goto L7;
        return false;
    L7:
        return super.onRequestFocusInDescendants(r100, r101);
    }

    public void recordAnimationInfoIfBouncedHiddenView(ViewHolder r100, ItemAnimator.ItemHolderInfo r101) {
        r100.setFlags(0, 8192);
        if (this.mState.mTrackOldChangeHolders == true) goto L5;
    L11:
        this.mViewInfoStore.addToPreLayout(r100, r101);
        return;
    L5:
        if (r100.isUpdated() == false) goto L11;
        if (r100.isRemoved() == true) goto L11;
        if (r100.shouldIgnore() == true) goto L11;
        long r102 = getChangedHolderKey(r100);
        this.mViewInfoStore.addToOldChangeHolders(r102, r100);
        goto L11
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View r100, boolean r101) {
        ViewHolder r102 = getChildViewHolderInt(r100);
        if (r102 != null) goto L5;
    L12:
        r100.clearAnimation();
        dispatchChildDetached(r100);
        super.removeDetachedView(r100, r101);
        return;
    L5:
        if (r102.isTmpDetached() == false) goto L8;
        r102.clearTmpDetachFlag();
        goto L12
    L8:
        if (r102.shouldIgnore() == true) goto L12;
        throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + r102 + exceptionLabel());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View r100, View r101) {
        if (this.mLayout.onRequestChildFocus(this, this.mState, r100, r101) == true) goto L6;
        if (r101 == null) goto L6;
        requestChildOnScreen(r100, r101);
    L6:
        super.requestChildFocus(r100, r101);
    }

    @Override // android.view.View
    public void scrollBy(int r100, int r101) {
        LayoutManager r102 = this.mLayout;
        if (r102 != null) goto L6;
        return;
    L6:
        if (this.mLayoutSuppressed == false) goto L8;
        return;
    L8:
        boolean r103 = r102.canScrollHorizontally();
        boolean r104 = this.mLayout.canScrollVertically();
        if (r103 == true) goto L12;
        if (r104 == true) goto L12;
        return;
    L12:
        if (r103 == true) goto L15;
        r100 = 0;
    L15:
        if (r104 == true) goto L18;
        r101 = 0;
    L18:
        scrollByInternal(r100, r101, null, 0);
    }

    public boolean setChildImportantForAccessibilityInternal(ViewHolder r100, int r101) {
        if (isComputingLayout() == false) goto L6;
        r100.mPendingAccessibilityState = r101;
        this.mPendingAccessibilityImportanceChange.add(r100);
        return false;
    L6:
        ViewCompat.setImportantForAccessibility(r100.itemView, r101);
        return true;
    }

    public void smoothScrollBy(int r100, int r101) {
        smoothScrollBy(r100, r101, null);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int r100, int r101) {
        return getScrollingChildHelper().startNestedScroll(r100, r101);
    }

    public void swapAdapter(Adapter r100, boolean r101) {
        setLayoutFrozen(false);
        setAdapterInternal(r100, true, r101);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public RecyclerView(Context r110, AttributeSet r111, int r112) {
        super(r110, r111, r112);
        this.mObserver = new RecyclerViewDataObserver(this);
        this.mRecycler = new Recycler(this);
        this.mViewInfoStore = new ViewInfoStore();
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
        this.mEdgeEffectFactory = new EdgeEffectFactory();
        this.mItemAnimator = new DefaultItemAnimator();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new ViewFlinger(this);
        if (ALLOW_THREAD_GAP_WORK == false) goto L5;
        GapWorker.LayoutPrefetchRegistryImpl r100 = new GapWorker.LayoutPrefetchRegistryImpl();
    L6:
        this.mPrefetchRegistry = r100;
        this.mState = new State();
        this.mItemsAddedOrRemoved = false;
        this.mItemsChanged = false;
        this.mItemAnimatorListener = new ItemAnimatorRestoreListener(this);
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
        ViewConfiguration r101 = ViewConfiguration.get(r110);
        this.mTouchSlop = r101.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.getScaledHorizontalScrollFactor(r101, r110);
        this.mScaledVerticalScrollFactor = ViewConfigurationCompat.getScaledVerticalScrollFactor(r101, r110);
        this.mMinFlingVelocity = r101.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = r101.getScaledMaximumFlingVelocity();
        if (getOverScrollMode() != 2) goto L9;
        boolean r102 = true;
    L10:
        setWillNotDraw(r102);
        this.mItemAnimator.setListener(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (ViewCompat.getImportantForAccessibility(this) != 0) goto L13;
        ViewCompat.setImportantForAccessibility(this, 1);
    L13:
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        TypedArray r113 = r110.obtainStyledAttributes(r111, new int[]{R.attr.orientation, R.attr.clipToPadding, R.attr.descendantFocusability, com.larus.nova.R.attr.fastScrollEnabled, com.larus.nova.R.attr.fastScrollHorizontalThumbDrawable, com.larus.nova.R.attr.fastScrollHorizontalTrackDrawable, com.larus.nova.R.attr.fastScrollVerticalThumbDrawable, com.larus.nova.R.attr.fastScrollVerticalTrackDrawable, com.larus.nova.R.attr.layoutManager, com.larus.nova.R.attr.reverseLayout, com.larus.nova.R.attr.spanCount, com.larus.nova.R.attr.stackFromEnd}, r112, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r110, new int[]{R.attr.orientation, R.attr.clipToPadding, R.attr.descendantFocusability, com.larus.nova.R.attr.fastScrollEnabled, com.larus.nova.R.attr.fastScrollHorizontalThumbDrawable, com.larus.nova.R.attr.fastScrollHorizontalTrackDrawable, com.larus.nova.R.attr.fastScrollVerticalThumbDrawable, com.larus.nova.R.attr.fastScrollVerticalTrackDrawable, com.larus.nova.R.attr.layoutManager, com.larus.nova.R.attr.reverseLayout, com.larus.nova.R.attr.spanCount, com.larus.nova.R.attr.stackFromEnd}, r111, r113, r112, 0);
        String r103 = r113.getString(8);
        if (r113.getInt(2, -1) != (-1)) goto L16;
        setDescendantFocusability(262144);
    L16:
        this.mClipToPadding = r113.getBoolean(1, true);
        boolean r104 = r113.getBoolean(3, false);
        this.mEnableFastScroller = r104;
        if (r104 == false) goto L19;
        initFastScroller((StateListDrawable) r113.getDrawable(6), r113.getDrawable(7), (StateListDrawable) r113.getDrawable(4), r113.getDrawable(5));
    L19:
        r113.recycle();
        createLayoutManager(r110, r103, r111, r112, 0);
        int[] r105 = NESTED_SCROLLING_ATTRS;
        TypedArray r114 = r110.obtainStyledAttributes(r111, r105, r112, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r110, r105, r111, r114, r112, 0);
        boolean r106 = r114.getBoolean(0, true);
        r114.recycle();
        setNestedScrollingEnabled(r106);
        return;
    L9:
        r102 = false;
        goto L10
    L5:
        r100 = null;
        goto L6
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_recyclerview_widget_RecyclerView_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r105 = access$001(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$001(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static /* synthetic */ void access$300(RecyclerView r100, int r101, int r102) {
        r100.setMeasuredDimension(r101, r102);
    }

    private void handleMissingPreInfoForChangeError(long r100, ViewHolder r101, ViewHolder r110) {
        int r102 = this.mChildHelper.getChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L18;
        ViewHolder r104 = getChildViewHolderInt(this.mChildHelper.getChildAt(r103));
        if (r104 == r101) goto L17;
        if (getChangedHolderKey(r104) != r100) goto L17;
        Adapter r105 = this.mAdapter;
        if (r105 == null) goto L16;
        if (r105.hasStableIds() == false) goto L16;
        throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + r104 + " \n View Holder 2:" + r101 + exceptionLabel());
    L16:
        throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + r104 + " \n View Holder 2:" + r101 + exceptionLabel());
    L17:
        r103 = r103 + 1;
        goto L3
    L18:
        Objects.toString(r110);
        Objects.toString(r101);
        exceptionLabel();
    }

    private boolean isPreferredNextFocus(View r110, View r111, int r112) {
        if (r111 == null) goto L89;
        if (r111 == this) goto L90;
        if (r111 != r110) goto L8;
        return false;
    L8:
        if (findContainingItemView(r111) != null) goto L11;
        return false;
    L11:
        if (r110 != null) goto L14;
        return true;
    L14:
        if (findContainingItemView(r110) != null) goto L16;
        return true;
    L16:
        this.mTempRect.set(0, 0, r110.getWidth(), r110.getHeight());
        this.mTempRect2.set(0, 0, r111.getWidth(), r111.getHeight());
        offsetDescendantRectToMyCoords(r110, this.mTempRect);
        offsetDescendantRectToMyCoords(r111, this.mTempRect2);
        byte r113 = -1;
        if (this.mLayout.getLayoutDirection() != 1) goto L19;
        int r114 = -1;
    L20:
        Rect r100 = this.mTempRect;
        int r101 = r100.left;
        Rect r102 = this.mTempRect2;
        int r103 = r102.left;
        if (r101 < r103) goto L25;
        if (r100.right <= r103) goto L25;
    L27:
        int r104 = r100.right;
        int r105 = r102.right;
        if (r104 > r105) goto L30;
        if (r101 >= r105) goto L30;
    L32:
        int r106 = 0;
    L33:
        int r107 = r100.top;
        int r108 = r102.top;
        if (r107 < r108) goto L38;
        if (r100.bottom <= r108) goto L38;
    L40:
        int r109 = r100.bottom;
        int r115 = r102.bottom;
        if (r109 > r115) goto L43;
        if (r107 >= r115) goto L43;
    L45:
        r113 = 0;
    L46:
        if (r112 != 1) goto L48;
        if (r113 < 0) goto L81;
        if (r113 == 0) goto L80;
        return false;
    L80:
        if ((r106 * r114) < 0) goto L81;
        return false;
    L81:
        return true;
    L48:
        if (r112 != 2) goto L50;
        if (r113 > 0) goto L75;
        if (r113 == 0) goto L74;
        return false;
    L74:
        if ((r106 * r114) > 0) goto L75;
        return false;
    L75:
        return true;
    L50:
        if (r112 != 17) goto L52;
        if (r106 >= 0) goto L86;
        return true;
    L86:
        return false;
    L52:
        if (r112 != 33) goto L54;
        if (r113 >= 0) goto L85;
        return true;
    L85:
        return false;
    L54:
        if (r112 != 66) goto L56;
        if (r106 <= 0) goto L84;
        return true;
    L84:
        return false;
    L56:
        if (r112 != 130) goto L61;
        if (r113 <= 0) goto L83;
        return true;
    L83:
        return false;
    L61:
        throw new IllegalArgumentException("Invalid direction: " + r112 + exceptionLabel());
    L43:
        if (r107 <= r108) goto L45;
    L38:
        if (r100.bottom >= r102.bottom) goto L40;
        r113 = 1;
    L30:
        if (r101 <= r103) goto L32;
        r106 = -1;
    L25:
        if (r100.right >= r102.right) goto L27;
        r106 = 1;
        goto L33
    L19:
        r114 = 1;
        goto L20
    L90:
        return false;
    L89:
        return false;
    }

    private void setAdapterInternal(Adapter r100, boolean r101, boolean r102) {
        Adapter r103 = this.mAdapter;
        if (r103 == null) goto L5;
        r103.unregisterAdapterDataObserver(this.mObserver);
        this.mAdapter.onDetachedFromRecyclerView(this);
    L5:
        if (r101 == false) goto L7;
        if (r102 == true) goto L7;
    L8:
        this.mAdapterHelper.reset();
        Adapter r104 = this.mAdapter;
        this.mAdapter = r100;
        if (r100 == null) goto L11;
        r100.registerAdapterDataObserver(this.mObserver);
        r100.onAttachedToRecyclerView(this);
    L11:
        LayoutManager r105 = this.mLayout;
        if (r105 == null) goto L14;
        r105.onAdapterChanged(r104, this.mAdapter);
    L14:
        this.mRecycler.onAdapterChanged(r104, this.mAdapter, r101);
        this.mState.mStructureChanged = true;
        return;
    L7:
        removeAndRecycleViews();
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> r100, int r101, int r102) {
        LayoutManager r103 = this.mLayout;
        if (r103 != null) goto L5;
    L6:
        super.addFocusables(r100, r101, r102);
        return;
    L5:
        if (r103.onAddFocusables(this, r100, r101, r102) == false) goto L6;
    }

    public void animateAppearance(ViewHolder r100, ItemAnimator.ItemHolderInfo r101, ItemAnimator.ItemHolderInfo r102) {
        r100.setIsRecyclable(false);
        if (this.mItemAnimator.animateAppearance(r100, r101, r102) == false) goto L6;
        postAnimationRunner();
        return;
    }

    public void animateDisappearance(ViewHolder r100, ItemAnimator.ItemHolderInfo r101, ItemAnimator.ItemHolderInfo r102) {
        addAnimatingView(r100);
        r100.setIsRecyclable(false);
        if (this.mItemAnimator.animateDisappearance(r100, r101, r102) == false) goto L6;
        postAnimationRunner();
        return;
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float r100, float r101, boolean r102) {
        return getScrollingChildHelper().dispatchNestedFling(r100, r101, r102);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas r100, View r101, long r102) {
        return super.drawChild(r100, r101, r102);
    }

    void offsetPositionRecordsForRemove(int r100, int r101, boolean r110) {
        int r102 = r100 + r101;
        int r103 = this.mChildHelper.getUnfilteredChildCount();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L14;
        ViewHolder r105 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r104));
        if (r105 == null) goto L13;
        if (r105.shouldIgnore() == true) goto L13;
        int r106 = r105.mPosition;
        if (r106 < r102) goto L11;
        r105.offsetPosition(-r101, r110);
        this.mState.mStructureChanged = true;
        goto L13
    L11:
        if (r106 < r100) goto L13;
        r105.flagRemovedAndOffsetPosition(r100 - 1, -r101, r110);
        this.mState.mStructureChanged = true;
    L13:
        r104 = r104 + 1;
        goto L3
    L14:
        this.mRecycler.offsetPositionRecordsForRemove(r100, r101, r110);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View r100, Rect r101, boolean r102) {
        return this.mLayout.requestChildRectangleOnScreen(this, r100, r101, r102);
    }

    void scrollStep(int r100, int r101, int[] r102) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        TraceCompat.beginSection(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        if (r100 == 0) goto L5;
        int r103 = this.mLayout.scrollHorizontallyBy(r100, this.mRecycler, this.mState);
    L6:
        if (r101 == 0) goto L8;
        int r104 = this.mLayout.scrollVerticallyBy(r101, this.mRecycler, this.mState);
    L9:
        TraceCompat.endSection();
        repositionShadowingViews();
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        if (r102 == null) goto L13;
        r102[0] = r103;
        r102[1] = r104;
        return;
    L13:
        return;
    L8:
        r104 = 0;
        goto L9
    L5:
        r103 = 0;
        goto L6
    }

    public void smoothScrollBy(int r100, int r101, Interpolator r102) {
        smoothScrollBy(r100, r101, r102, Integer.MIN_VALUE);
    }

    void viewRangeUpdate(int r100, int r101, Object r102) {
        int r103 = this.mChildHelper.getUnfilteredChildCount();
        int r104 = r100 + r101;
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L14;
        View r106 = this.mChildHelper.getUnfilteredChildAt(r105);
        ViewHolder r107 = getChildViewHolderInt(r106);
        if (r107 == null) goto L13;
        if (r107.shouldIgnore() == true) goto L13;
        int r108 = r107.mPosition;
        if (r108 < r100) goto L13;
        if (r108 >= r104) goto L13;
        r107.addFlags(2);
        r107.addChangePayload(r102);
        ((LayoutParams) r106.getLayoutParams()).mInsetsDirty = true;
    L13:
        r105 = r105 + 1;
        goto L3
    L14:
        this.mRecycler.viewRangeUpdate(r100, r101);
    }

    public static /* synthetic */ void access$000(RecyclerView r100, View r101, int r102, ViewGroup.LayoutParams r103) {
        r100.attachViewToParent(r101, r102, r103);
    }

    private void nestedScrollByInternal(int r110, int r111, MotionEvent r112, int r113) {
        LayoutManager r100 = this.mLayout;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.mLayoutSuppressed == false) goto L8;
        return;
    L8:
        int[] r101 = this.mReusableIntPair;
        int r102 = 0;
        r101[0] = 0;
        r101[1] = 0;
        boolean r103 = r100.canScrollHorizontally();
        boolean r104 = this.mLayout.canScrollVertically();
        if (r104 == false) goto L11;
        int r105 = (r103 ? 1 : 0) | 2;
    L12:
        startNestedScroll(r105, r113);
        if (r103 == false) goto L15;
        int r106 = r110;
    L16:
        if (r104 == false) goto L18;
        int r107 = r111;
    L20:
        if (dispatchNestedPreScroll(r106, r107, this.mReusableIntPair, this.mScrollOffset, r113) == false) goto L22;
        int[] r108 = this.mReusableIntPair;
        r110 = r110 - r108[0];
        r111 = r111 - r108[1];
    L22:
        if (r103 == false) goto L24;
        int r109 = r110;
    L25:
        if (r104 == false) goto L27;
        r102 = r111;
    L27:
        scrollByInternal(r109, r102, r112, r113);
        GapWorker r114 = this.mGapWorker;
        if (r114 == null) goto L32;
        if (r110 != 0) goto L31;
        if (r111 == 0) goto L32;
    L31:
        r114.postFromTraversal(this, r110, r111);
    L32:
        stopNestedScroll(r113);
        return;
    L24:
        r109 = 0;
        goto L25
    L18:
        r107 = 0;
        goto L20
    L15:
        r106 = 0;
        goto L16
    L11:
        r105 = r103 ? 1 : 0;
        goto L12
    }

    private void pullGlows(float r100, float r101, float r102, float r110) {
        boolean r103 = true;
        if (r101 >= 0.0f) goto L7;
        ensureLeftGlow();
        EdgeEffectCompat.onPull(this.mLeftGlow, (-r101) / getWidth(), 1.0f - (r102 / getHeight()));
    L5:
        boolean r104 = true;
    L11:
        if (r110 >= 0.0f) goto L14;
        ensureTopGlow();
        EdgeEffectCompat.onPull(this.mTopGlow, (-r110) / getHeight(), r100 / getWidth());
    L17:
        if (r103 == false) goto L19;
    L22:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L19:
        if (r101 != 0.0f) goto L22;
        if (r110 != 0.0f) goto L22;
        return;
    L14:
        if (r110 <= 0.0f) goto L16;
        ensureBottomGlow();
        EdgeEffectCompat.onPull(this.mBottomGlow, r110 / getHeight(), 1.0f - (r100 / getWidth()));
        goto L17
    L16:
        r103 = r104;
        goto L17
    L7:
        if (r101 <= 0.0f) goto L9;
        ensureRightGlow();
        EdgeEffectCompat.onPull(this.mRightGlow, r101 / getWidth(), r102 / getHeight());
        goto L5
    L9:
        r104 = false;
        goto L11
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r103) {
        return getScrollingChildHelper().dispatchNestedPreScroll(r100, r101, r102, r103);
    }

    void initFastScroller(StateListDrawable r110, Drawable r111, StateListDrawable r112, Drawable r113) {
        if (r110 == null) goto L9;
        if (r111 == null) goto L9;
        if (r112 == null) goto L9;
        if (r113 == null) goto L9;
        Resources r100 = getContext().getResources();
        new FastScroller(this, r110, r111, r112, r113, r100.getDimensionPixelSize(com.larus.nova.R.dimen.fastscroll_default_thickness), r100.getDimensionPixelSize(com.larus.nova.R.dimen.fastscroll_minimum_range), r100.getDimensionPixelOffset(com.larus.nova.R.dimen.fastscroll_margin));
        return;
    L9:
        throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
    }

    @Override // android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        if (r100 != r102) goto L5;
        if (r101 != r103) goto L5;
        return;
    L5:
        invalidateGlows();
    }

    boolean scrollByInternal(int r110, int r210, MotionEvent r211, int r212) {
        consumePendingUpdateOperations();
        if (this.mAdapter == null) goto L5;
        int[] r100 = this.mReusableIntPair;
        r100[0] = 0;
        r100[1] = 0;
        scrollStep(r110, r210, r100);
        int[] r101 = this.mReusableIntPair;
        int r102 = r101[0];
        int r103 = r101[1];
        int r111 = r103;
        int r112 = r102;
        int r113 = r110 - r102;
        int r114 = r210 - r103;
    L7:
        if (this.mItemDecorations.isEmpty() == true) goto L9;
        invalidate();
    L9:
        int[] r104 = this.mReusableIntPair;
        r104[0] = 0;
        r104[1] = 0;
        dispatchNestedScroll(r112, r111, r113, r114, this.mScrollOffset, r212, r104);
        int[] r105 = this.mReusableIntPair;
        int r106 = r105[0];
        int r107 = r113 - r106;
        int r108 = r105[1];
        int r109 = r114 - r108;
        if (r106 != 0) goto L14;
        if (r108 != 0) goto L14;
        boolean r115 = false;
    L15:
        int r116 = this.mLastTouchX;
        int[] r117 = this.mScrollOffset;
        int r118 = r117[0];
        this.mLastTouchX = r116 - r118;
        int r119 = this.mLastTouchY;
        int r120 = r117[1];
        this.mLastTouchY = r119 - r120;
        int[] r121 = this.mNestedOffsets;
        r121[0] = r121[0] + r118;
        r121[1] = r121[1] + r120;
        if (getOverScrollMode() == 2) goto L22;
        if (r211 != null) goto L19;
    L21:
        considerReleasingGlowsOnScroll(r110, r210);
        goto L22
    L19:
        if (MotionEventCompat.isFromSource(r211, 8194) == true) goto L21;
        pullGlows(r211.getX(), r107, r211.getY(), r109);
    L22:
        if (r112 != 0) goto L24;
        if (r111 != 0) goto L24;
    L26:
        if (awakenScrollBars() == true) goto L28;
        invalidate();
    L28:
        if (r115 == true) goto L34;
        if (r112 != 0) goto L35;
        if (r111 != 0) goto L36;
        return false;
    L36:
        return true;
    L35:
        return true;
    L34:
        return true;
    L24:
        dispatchOnScrolled(r112, r111);
    L14:
        r115 = true;
        goto L15
    L5:
        r111 = 0;
        r112 = 0;
        r113 = 0;
        r114 = 0;
        goto L7
    }

    public void smoothScrollBy(int r100, int r101, Interpolator r102, int r110) {
        smoothScrollBy(r100, r101, r102, r110, false);
    }

    private void createLayoutManager(Context r100, String r101, AttributeSet r102, int r110, int r111) {
        if (r101 == null) goto L37;
        String r103 = r101.trim();
        if (r103.isEmpty() == true) goto L43;
        String r104 = getFullClassName(r100, r103);
    L22:
        e = move-exception;
        throw new IllegalStateException(r102.getPositionDescription() + ": Class is not a LayoutManager " + r104, e);
    L34:
        e = move-exception;
        throw new IllegalStateException(r102.getPositionDescription() + ": Unable to find LayoutManager " + r104, e);
    L25:
        e = move-exception;
        throw new IllegalStateException(r102.getPositionDescription() + ": Cannot access non-public constructor " + r104, e);
    L28:
        e = move-exception;
        throw new IllegalStateException(r102.getPositionDescription() + ": Could not instantiate the LayoutManager: " + r104, e);
    L31:
        e = move-exception;
        throw new IllegalStateException(r102.getPositionDescription() + ": Could not instantiate the LayoutManager: " + r104, e);
    L8:
        if (isInEditMode() == false) goto L10;
        ClassLoader r105 = getClass().getClassLoader();     // Catch: ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
    L11:
        Class r106 = INVOKESTATIC_androidx_recyclerview_widget_RecyclerView_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r104, false, r105).asSubclass(LayoutManager.class);     // Catch: ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
        Constructor r107 = r106.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);     // Catch: NoSuchMethodException -> L15 ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
        Object[] r108 = {r100, r102, Integer.valueOf(r110), Integer.valueOf(r111)};     // Catch: NoSuchMethodException -> L15 ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
    L18:
        r107.setAccessible(true);     // Catch: ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
        setLayoutManager((LayoutManager) r107.newInstance(r108));     // Catch: ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
        return;
    L15:
        e = move-exception;
        r107 = r106.getConstructor(new Class[0]);     // Catch: NoSuchMethodException -> L19 ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
        r108 = null;
    L19:
        e = move-exception;
        e.initCause(e);     // Catch: ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
        throw new IllegalStateException(r102.getPositionDescription() + ": Error creating LayoutManager " + r104, e);     // Catch: ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
    L10:
        r105 = r100.getClassLoader();     // Catch: ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
        goto L11
    L43:
        return;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int r100, int r101, int[] r102, int[] r110, int r111) {
        return getScrollingChildHelper().dispatchNestedPreScroll(r100, r101, r102, r110, r111);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int r100, int r101, int r102, int r110, int[] r111) {
        return getScrollingChildHelper().dispatchNestedScroll(r100, r101, r102, r110, r111);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        TraceCompat.beginSection(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.endSection();
        this.mFirstLayoutComplete = true;
    }

    void smoothScrollBy(int r100, int r101, Interpolator r102, int r103, boolean r104) {
        LayoutManager r105 = this.mLayout;
        if (r105 != null) goto L6;
        return;
    L6:
        if (this.mLayoutSuppressed == false) goto L8;
        return;
    L8:
        int r106 = 0;
        if (r105.canScrollHorizontally() == true) goto L12;
        r100 = 0;
    L12:
        if (this.mLayout.canScrollVertically() == true) goto L14;
        r101 = 0;
    L14:
        if (r100 != 0) goto L17;
        if (r101 != 0) goto L17;
        return;
    L17:
        if (r103 == Integer.MIN_VALUE) goto L21;
        if (r103 > 0) goto L21;
        boolean r107 = false;
    L22:
        if (r107 == false) goto L30;
        if (r104 == false) goto L29;
        if (r100 == 0) goto L26;
        r106 = 1;
    L26:
        if (r101 == 0) goto L28;
        r106 = r106 | 2;
    L28:
        startNestedScroll(r106, 1);
    L29:
        this.mViewFlinger.smoothScrollBy(r100, r101, r103, r102);
        return;
    L30:
        scrollBy(r100, r101);
        return;
    L21:
        r107 = true;
        goto L22
    }

    private void animateChange(ViewHolder r100, ViewHolder r101, ItemAnimator.ItemHolderInfo r102, ItemAnimator.ItemHolderInfo r103, boolean r104, boolean r105) {
        r100.setIsRecyclable(false);
        if (r104 == false) goto L5;
        addAnimatingView(r100);
    L5:
        if (r100 == r101) goto L10;
        if (r105 == false) goto L8;
        addAnimatingView(r101);
    L8:
        r100.mShadowedHolder = r101;
        addAnimatingView(r100);
        this.mRecycler.unscrapView(r100);
        r101.setIsRecyclable(false);
        r101.mShadowingHolder = r100;
    L10:
        if (this.mItemAnimator.animateChange(r100, r101, r102, r103) == false) goto L13;
        postAnimationRunner();
        return;
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int r100, int r101, int r110, int r111, int[] r112, int r113) {
        return getScrollingChildHelper().dispatchNestedScroll(r100, r101, r110, r111, r112, r113);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public final void dispatchNestedScroll(int r100, int r110, int r111, int r112, int[] r113, int r114, int[] r115) {
        getScrollingChildHelper().dispatchNestedScroll(r100, r110, r111, r112, r113, r114, r115);
    }
}
