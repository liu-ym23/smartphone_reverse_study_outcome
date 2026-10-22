package com.obric.oui.orecyclerview.widget;

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
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
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
import android.widget.EdgeEffect;
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
import androidx.customview.poolingcontainer.PoolingContainer;
import androidx.customview.view.AbsSavedState;
import com.GlobalProxyLancet;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.util.HanziToPinyin;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.oui.orecyclerview.R;
import com.obric.oui.orecyclerview.base.EdgeEffectAdapter;
import com.obric.oui.orecyclerview.base.OverScrollerAdapter;
import com.obric.oui.orecyclerview.base.VelocityTracker;
import com.obric.oui.orecyclerview.base.VelocityTrackerFactory;
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

/* JADX INFO: loaded from: classes3.dex */
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
    private float mLastDispatchedBounceTranslation;
    private int mLastTouchX;
    private int mLastTouchY;
    LayoutManager mLayout;
    private int mLayoutOrScrollCounter;
    boolean mLayoutSuppressed;
    boolean mLayoutWasDefered;
    private final int mMaxFlingVelocity;
    private int mMinFlingVelocity;
    private final int[] mMinMaxLayoutPositions;
    private final int[] mNestedOffsets;
    private final RecyclerViewDataObserver mObserver;
    private OnBounceTranslationListener mOnBounceTranslationListener;
    private List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
    private OnFlingListener mOnFlingListener;
    private final ArrayList<OnItemTouchListener> mOnItemTouchListeners;
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

    /* JADX INFO: renamed from: com.obric.oui.orecyclerview.widget.RecyclerView$7, reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$oui$orecyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy = null;

        static {
            int[] r0 = new int[Adapter.StateRestorationPolicy.values().length];
            $SwitchMap$com$obric$oui$orecyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy = r0;
            r0[Adapter.StateRestorationPolicy.PREVENT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$obric$oui$orecyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy[Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
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

            private StateRestorationPolicy(String r1, int r2) {
                super(r1, r2);
            }

            public static StateRestorationPolicy valueOf(String r1) {
                return (StateRestorationPolicy) Enum.valueOf(StateRestorationPolicy.class, r1);
            }

            public static StateRestorationPolicy[] values() {
                return (StateRestorationPolicy[]) $VALUES.clone();
            }

            static {
                StateRestorationPolicy r0 = new StateRestorationPolicy("ALLOW", 0);
                ALLOW = r0;
                StateRestorationPolicy r1 = new StateRestorationPolicy("PREVENT_WHEN_EMPTY", 1);
                PREVENT_WHEN_EMPTY = r1;
                StateRestorationPolicy r3 = new StateRestorationPolicy("PREVENT", 2);
                PREVENT = r3;
                $VALUES = new StateRestorationPolicy[]{r0, r1, r3};
            }
        }

        public int findRelativeAdapterPositionIn(Adapter<? extends ViewHolder> r1, ViewHolder r2, int r3) {
            if (r1 != this) goto L4;
            return r3;
        L4:
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int r1) {
            return -1;
        }

        public int getItemViewType(int r1) {
            return 0;
        }

        public void onAttachedToRecyclerView(RecyclerView r1) {
        }

        public abstract void onBindViewHolder(VH r1, int r2);

        public abstract VH onCreateViewHolder(ViewGroup r1, int r2);

        public void onDetachedFromRecyclerView(RecyclerView r1) {
        }

        public boolean onFailedToRecycleView(VH r1) {
            return false;
        }

        public void onViewAttachedToWindow(VH r1) {
        }

        public void onViewDetachedFromWindow(VH r1) {
        }

        public void onViewRecycled(VH r1) {
        }

        public Adapter() {
            this.mObservable = new AdapterDataObservable();
            this.mHasStableIds = false;
            this.mStateRestorationPolicy = StateRestorationPolicy.ALLOW;
        }

        public void onBindViewHolder(VH r1, int r2, List<Object> r3) {
            onBindViewHolder(r1, r2);
        }

        public final VH createViewHolder(ViewGroup r2, int r3) {
            TraceCompat.beginSection(RecyclerView.TRACE_CREATE_VIEW_TAG);     // Catch: Throwable -> L9
            VH r1 = (VH) onCreateViewHolder(r2, r3);
            if (r1.itemView.getParent() != null) goto L8;
            r1.mItemViewType = r3;     // Catch: Throwable -> L9
            TraceCompat.endSection();
            return r1;
        L8:
            throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            TraceCompat.endSection();
            throw th;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void bindViewHolder(VH r5, int r6) {
            if (r5.mBindingAdapter != null) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L11;
            r5.mPosition = r6;
            if (hasStableIds() == false) goto L10;
            r5.mItemId = getItemId(r6);
        L10:
            r5.setFlags(1, 519);
            TraceCompat.beginSection(RecyclerView.TRACE_BIND_VIEW_TAG);
        L11:
            r5.mBindingAdapter = this;
            if (RecyclerView.sDebugAssertionsEnabled == true) goto L14;
        L27:
            onBindViewHolder(r5, r6, r5.getUnmodifiedPayloads());
            if (r0 == false) goto L34;
            r5.clearPayload();
            ViewGroup.LayoutParams r4 = r5.itemView.getLayoutParams();
            if ((r4 instanceof LayoutParams) == false) goto L32;
            ((LayoutParams) r4).mInsetsDirty = true;
        L32:
            TraceCompat.endSection();
            return;
        L34:
            return;
        L14:
            if (r5.itemView.getParent() != null) goto L21;
            if (ViewCompat.isAttachedToWindow(r5.itemView) == r5.isTmpDetached()) goto L21;
            throw new IllegalStateException("Temp-detached state out of sync with reality. holder.isTmpDetached(): " + r5.isTmpDetached() + ", attached to window: " + ViewCompat.isAttachedToWindow(r5.itemView) + ", holder: " + r5);
        L21:
            if (r5.itemView.getParent() != null) goto L27;
            if (ViewCompat.isAttachedToWindow(r5.itemView) == false) goto L27;
            throw new IllegalStateException("Attempting to bind attached holder with no parent (AKA temp detached): " + r5);
        L5:
            r0 = false;
            goto L6
        }

        public void setHasStableIds(boolean r2) {
            if (hasObservers() == true) goto L7;
            this.mHasStableIds = r2;
            return;
        L7:
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final boolean hasObservers() {
            return this.mObservable.hasObservers();
        }

        public void registerAdapterDataObserver(AdapterDataObserver r1) {
            this.mObservable.registerObserver(r1);
        }

        public void unregisterAdapterDataObserver(AdapterDataObserver r1) {
            this.mObservable.unregisterObserver(r1);
        }

        public final void notifyDataSetChanged() {
            this.mObservable.notifyChanged();
        }

        public final void notifyItemChanged(int r2) {
            this.mObservable.notifyItemRangeChanged(r2, 1);
        }

        public final void notifyItemChanged(int r2, Object r3) {
            this.mObservable.notifyItemRangeChanged(r2, 1, r3);
        }

        public final void notifyItemRangeChanged(int r1, int r2) {
            this.mObservable.notifyItemRangeChanged(r1, r2);
        }

        public final void notifyItemRangeChanged(int r1, int r2, Object r3) {
            this.mObservable.notifyItemRangeChanged(r1, r2, r3);
        }

        public final void notifyItemInserted(int r2) {
            this.mObservable.notifyItemRangeInserted(r2, 1);
        }

        public final void notifyItemMoved(int r1, int r2) {
            this.mObservable.notifyItemMoved(r1, r2);
        }

        public final void notifyItemRangeInserted(int r1, int r2) {
            this.mObservable.notifyItemRangeInserted(r1, r2);
        }

        public final void notifyItemRemoved(int r2) {
            this.mObservable.notifyItemRangeRemoved(r2, 1);
        }

        public final void notifyItemRangeRemoved(int r1, int r2) {
            this.mObservable.notifyItemRangeRemoved(r1, r2);
        }

        public void setStateRestorationPolicy(StateRestorationPolicy r1) {
            this.mStateRestorationPolicy = r1;
            this.mObservable.notifyStateRestorationPolicyChanged();
        }

        public final StateRestorationPolicy getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
        }

        boolean canRestoreState() {
            int r0 = AnonymousClass7.$SwitchMap$com$obric$oui$orecyclerview$widget$RecyclerView$Adapter$StateRestorationPolicy[this.mStateRestorationPolicy.ordinal()];
            if (r0 != 1) goto L5;
            return false;
        L5:
            if (r0 == 2) goto L8;
            return true;
        L8:
            if (getItemCount() > 0) goto L10;
            return false;
        L10:
            return true;
        }
    }

    static class AdapterDataObservable extends Observable<AdapterDataObserver> {
        AdapterDataObservable() {
        }

        public boolean hasObservers() {
            return !this.mObservers.isEmpty();
        }

        public void notifyChanged() {
            int r0 = this.mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            ((AdapterDataObserver) this.mObservers.get(r0)).onChanged();
            r0 = r0 - 1;
            goto L3
        }

        public void notifyStateRestorationPolicyChanged() {
            int r0 = this.mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            ((AdapterDataObserver) this.mObservers.get(r0)).onStateRestorationPolicyChanged();
            r0 = r0 - 1;
            goto L3
        }

        public void notifyItemRangeChanged(int r2, int r3) {
            notifyItemRangeChanged(r2, r3, null);
        }

        public void notifyItemRangeChanged(int r3, int r4, Object r5) {
            int r0 = this.mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            ((AdapterDataObserver) this.mObservers.get(r0)).onItemRangeChanged(r3, r4, r5);
            r0 = r0 - 1;
            goto L3
        }

        public void notifyItemRangeInserted(int r3, int r4) {
            int r0 = this.mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            ((AdapterDataObserver) this.mObservers.get(r0)).onItemRangeInserted(r3, r4);
            r0 = r0 - 1;
            goto L3
        }

        public void notifyItemRangeRemoved(int r3, int r4) {
            int r0 = this.mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            ((AdapterDataObserver) this.mObservers.get(r0)).onItemRangeRemoved(r3, r4);
            r0 = r0 - 1;
            goto L3
        }

        public void notifyItemMoved(int r4, int r5) {
            int r0 = this.mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            ((AdapterDataObserver) this.mObservers.get(r0)).onItemRangeMoved(r4, r5, 1);
            r0 = r0 - 1;
            goto L3
        }
    }

    public static abstract class AdapterDataObserver {
        public void onChanged() {
        }

        public void onItemRangeChanged(int r1, int r2) {
        }

        public void onItemRangeInserted(int r1, int r2) {
        }

        public void onItemRangeMoved(int r1, int r2, int r3) {
        }

        public void onItemRangeRemoved(int r1, int r2) {
        }

        public void onStateRestorationPolicyChanged() {
        }

        public AdapterDataObserver() {
        }

        public void onItemRangeChanged(int r1, int r2, Object r3) {
            onItemRangeChanged(r1, r2);
        }
    }

    public interface ChildDrawingOrderCallback {
        int onGetChildDrawingOrder(int r1, int r2);
    }

    public static class EdgeEffectFactory {
        public static final int DIRECTION_BOTTOM = 3;
        public static final int DIRECTION_LEFT = 0;
        public static final int DIRECTION_RIGHT = 2;
        public static final int DIRECTION_TOP = 1;

        @Retention(RetentionPolicy.SOURCE)
        public @interface EdgeDirection {
        }

        public EdgeEffectFactory() {
        }

        protected EdgeEffect createEdgeEffect(RecyclerView r1, int r2) {
            return new EdgeEffect(r1.getContext());
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

        @Retention(RetentionPolicy.SOURCE)
        public @interface AdapterChanges {
        }

        public interface ItemAnimatorFinishedListener {
            void onAnimationsFinished();
        }

        interface ItemAnimatorListener {
            void onAnimationFinished(ViewHolder r1);
        }

        public static class ItemHolderInfo {
            public int bottom;
            public int changeFlags;
            public int left;
            public int right;
            public int top;

            public ItemHolderInfo() {
            }

            public ItemHolderInfo setFrom(ViewHolder r2) {
                return setFrom(r2, 0);
            }

            public ItemHolderInfo setFrom(ViewHolder r1, int r2) {
                View r3 = r1.itemView;
                this.left = r3.getLeft();
                this.top = r3.getTop();
                this.right = r3.getRight();
                this.bottom = r3.getBottom();
                return this;
            }
        }

        public abstract boolean animateAppearance(ViewHolder r1, ItemHolderInfo r2, ItemHolderInfo r3);

        public abstract boolean animateChange(ViewHolder r1, ViewHolder r2, ItemHolderInfo r3, ItemHolderInfo r4);

        public abstract boolean animateDisappearance(ViewHolder r1, ItemHolderInfo r2, ItemHolderInfo r3);

        public abstract boolean animatePersistence(ViewHolder r1, ItemHolderInfo r2, ItemHolderInfo r3);

        public boolean canReuseUpdatedViewHolder(ViewHolder r1) {
            return true;
        }

        public abstract void endAnimation(ViewHolder r1);

        public abstract void endAnimations();

        public abstract boolean isRunning();

        public void onAnimationFinished(ViewHolder r1) {
        }

        public void onAnimationStarted(ViewHolder r1) {
        }

        public abstract void runPendingAnimations();

        public ItemAnimator() {
            this.mListener = null;
            this.mFinishedListeners = new ArrayList();
            this.mAddDuration = 100;
            this.mRemoveDuration = 100;
            this.mMoveDuration = 500;
            this.mChangeDuration = 250;
        }

        public long getMoveDuration() {
            return this.mMoveDuration;
        }

        public void setMoveDuration(long r1) {
            this.mMoveDuration = r1;
        }

        public long getAddDuration() {
            return this.mAddDuration;
        }

        public void setAddDuration(long r1) {
            this.mAddDuration = r1;
        }

        public long getRemoveDuration() {
            return this.mRemoveDuration;
        }

        public void setRemoveDuration(long r1) {
            this.mRemoveDuration = r1;
        }

        public long getChangeDuration() {
            return this.mChangeDuration;
        }

        public void setChangeDuration(long r1) {
            this.mChangeDuration = r1;
        }

        void setListener(ItemAnimatorListener r1) {
            this.mListener = r1;
        }

        public ItemHolderInfo recordPreLayoutInformation(State r1, ViewHolder r2, int r3, List<Object> r4) {
            return obtainHolderInfo().setFrom(r2);
        }

        public ItemHolderInfo recordPostLayoutInformation(State r1, ViewHolder r2) {
            return obtainHolderInfo().setFrom(r2);
        }

        static int buildAdapterChangeFlagsForAnimations(ViewHolder r3) {
            int r0 = r3.mFlags & 14;
            if (r3.isInvalid() == false) goto L7;
            return 4;
        L7:
            if ((r0 & 4) != 0) goto L14;
            int r1 = r3.getOldPosition();
            int r4 = r3.getAbsoluteAdapterPosition();
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

        public final void dispatchAnimationFinished(ViewHolder r1) {
            onAnimationFinished(r1);
            ItemAnimatorListener r0 = this.mListener;
            if (r0 == null) goto L6;
            r0.onAnimationFinished(r1);
            return;
        }

        public final void dispatchAnimationStarted(ViewHolder r1) {
            onAnimationStarted(r1);
        }

        public final boolean isRunning(ItemAnimatorFinishedListener r2) {
            boolean r0 = isRunning();
            if (r2 == null) goto L7;
            if (r0 == true) goto L6;
            r2.onAnimationsFinished();
            goto L7
        L6:
            this.mFinishedListeners.add(r2);
        L7:
            return r0;
        }

        public boolean canReuseUpdatedViewHolder(ViewHolder r1, List<Object> r2) {
            return canReuseUpdatedViewHolder(r1);
        }

        public final void dispatchAnimationsFinished() {
            int r0 = this.mFinishedListeners.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            this.mFinishedListeners.get(r1).onAnimationsFinished();
            r1 = r1 + 1;
            goto L3
        L5:
            this.mFinishedListeners.clear();
        }

        public ItemHolderInfo obtainHolderInfo() {
            return new ItemHolderInfo();
        }
    }

    private class ItemAnimatorRestoreListener implements ItemAnimator.ItemAnimatorListener {
        final /* synthetic */ RecyclerView this$0;

        ItemAnimatorRestoreListener(RecyclerView r1) {
            this.this$0 = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.ItemAnimator.ItemAnimatorListener
        public void onAnimationFinished(ViewHolder r3) {
            r3.setIsRecyclable(true);
            if (r3.mShadowedHolder != null) goto L5;
        L7:
            r3.mShadowingHolder = null;
            if (r3.shouldBeKeptAsChild() == false) goto L10;
            return;
        L10:
            if (this.this$0.removeAnimatingView(r3.itemView) == false) goto L12;
            return;
        L12:
            if (r3.isTmpDetached() == false) goto L17;
            this.this$0.removeDetachedView(r3.itemView, false);
            return;
        L17:
            return;
        L5:
            if (r3.mShadowingHolder != null) goto L7;
            r3.mShadowedHolder = null;
            goto L7
        }
    }

    public static abstract class ItemDecoration {
        @Deprecated
        public void onDraw(Canvas r1, RecyclerView r2) {
        }

        @Deprecated
        public void onDrawOver(Canvas r1, RecyclerView r2) {
        }

        public ItemDecoration() {
        }

        public void onDraw(Canvas r1, RecyclerView r2, State r3) {
            onDraw(r1, r2);
        }

        public void onDrawOver(Canvas r1, RecyclerView r2, State r3) {
            onDrawOver(r1, r2);
        }

        @Deprecated
        public void getItemOffsets(Rect r1, int r2, RecyclerView r3) {
            r1.set(0, 0, 0, 0);
        }

        public void getItemOffsets(Rect r1, View r2, RecyclerView r3, State r4) {
            getItemOffsets(r1, ((LayoutParams) r2.getLayoutParams()).getViewLayoutPosition(), r3);
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
            void addPosition(int r1, int r2);
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

        public boolean checkLayoutParams(LayoutParams r1) {
            if (r1 == null) goto L4;
            return true;
        L4:
            return false;
        }

        public void collectAdjacentPrefetchPositions(int r1, int r2, State r3, LayoutPrefetchRegistry r4) {
        }

        public void collectInitialPrefetchPositions(int r1, LayoutPrefetchRegistry r2) {
        }

        public int computeHorizontalScrollExtent(State r1) {
            return 0;
        }

        public int computeHorizontalScrollOffset(State r1) {
            return 0;
        }

        public int computeHorizontalScrollRange(State r1) {
            return 0;
        }

        public int computeVerticalScrollExtent(State r1) {
            return 0;
        }

        public int computeVerticalScrollOffset(State r1) {
            return 0;
        }

        public int computeVerticalScrollRange(State r1) {
            return 0;
        }

        public abstract LayoutParams generateDefaultLayoutParams();

        public int getBaseline() {
            return -1;
        }

        public int getColumnCountForAccessibility(Recycler r1, State r2) {
            return -1;
        }

        public int getRowCountForAccessibility(Recycler r1, State r2) {
            return -1;
        }

        public int getSelectionModeForAccessibility(Recycler r1, State r2) {
            return 0;
        }

        public boolean isLayoutHierarchical(Recycler r1, State r2) {
            return false;
        }

        public void onAdapterChanged(Adapter r1, Adapter r2) {
        }

        public boolean onAddFocusables(RecyclerView r1, ArrayList<View> r2, int r3, int r4) {
            return false;
        }

        public void onAttachedToWindow(RecyclerView r1) {
        }

        @Deprecated
        public void onDetachedFromWindow(RecyclerView r1) {
        }

        public View onFocusSearchFailed(View r1, int r2, Recycler r3, State r4) {
            return null;
        }

        public void onInitializeAccessibilityNodeInfoForItem(Recycler r1, State r2, View r3, AccessibilityNodeInfoCompat r4) {
        }

        public View onInterceptFocusSearch(View r1, int r2) {
            return null;
        }

        public void onItemsAdded(RecyclerView r1, int r2, int r3) {
        }

        public void onItemsChanged(RecyclerView r1) {
        }

        public void onItemsMoved(RecyclerView r1, int r2, int r3, int r4) {
        }

        public void onItemsRemoved(RecyclerView r1, int r2, int r3) {
        }

        public void onItemsUpdated(RecyclerView r1, int r2, int r3) {
        }

        public void onLayoutCompleted(State r1) {
        }

        public void onRestoreInstanceState(Parcelable r1) {
        }

        public Parcelable onSaveInstanceState() {
            return null;
        }

        public void onScrollStateChanged(int r1) {
        }

        public boolean performAccessibilityActionForItem(Recycler r1, State r2, View r3, int r4, Bundle r5) {
            return false;
        }

        public int scrollHorizontallyBy(int r1, Recycler r2, State r3) {
            return 0;
        }

        public int scrollVerticallyBy(int r1, Recycler r2, State r3) {
            return 0;
        }

        boolean shouldMeasureTwice() {
            return false;
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }

        public LayoutManager() {
            ViewBoundsCheck.Callback r0 = new AnonymousClass1(this);
            this.mHorizontalBoundCheckCallback = r0;
            ViewBoundsCheck.Callback r1 = new AnonymousClass2(this);
            this.mVerticalBoundCheckCallback = r1;
            this.mHorizontalBoundCheck = new ViewBoundsCheck(r0);
            this.mVerticalBoundCheck = new ViewBoundsCheck(r1);
            this.mRequestedSimpleAnimations = false;
            this.mIsAttachedToWindow = false;
            this.mAutoMeasure = false;
            this.mMeasurementCacheEnabled = true;
            this.mItemPrefetchEnabled = true;
        }

        void setRecyclerView(RecyclerView r2) {
            if (r2 != null) goto L4;
            this.mRecyclerView = null;
            this.mChildHelper = null;
            this.mWidth = 0;
            this.mHeight = 0;
        L5:
            this.mWidthMode = 1073741824;
            this.mHeightMode = 1073741824;
            return;
        L4:
            this.mRecyclerView = r2;
            this.mChildHelper = r2.mChildHelper;
            this.mWidth = r2.getWidth();
            this.mHeight = r2.getHeight();
            goto L5
        }

        void setMeasureSpecs(int r2, int r3) {
            this.mWidth = View.MeasureSpec.getSize(r2);
            int r4 = View.MeasureSpec.getMode(r2);
            this.mWidthMode = r4;
            if (r4 == 0) goto L5;
        L7:
            this.mHeight = View.MeasureSpec.getSize(r3);
            int r5 = View.MeasureSpec.getMode(r3);
            this.mHeightMode = r5;
            if (r5 == 0) goto L10;
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

        void setMeasuredDimensionFromChildren(int r9, int r10) {
            int r0 = getChildCount();
            if (r0 != 0) goto L6;
            this.mRecyclerView.defaultOnMeasure(r9, r10);
            return;
        L6:
            int r1 = Integer.MIN_VALUE;
            int r4 = Integer.MAX_VALUE;
            int r5 = 0;
            int r2 = Integer.MIN_VALUE;
            int r3 = Integer.MAX_VALUE;
        L7:
            if (r5 >= r0) goto L21;
            View r6 = getChildAt(r5);
            Rect r7 = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(r6, r7);
            if (r7.left >= r3) goto L12;
            r3 = r7.left;
        L12:
            if (r7.right <= r1) goto L15;
            r1 = r7.right;
        L15:
            if (r7.top >= r4) goto L18;
            r4 = r7.top;
        L18:
            if (r7.bottom <= r2) goto L20;
            r2 = r7.bottom;
        L20:
            r5 = r5 + 1;
            goto L7
        L21:
            this.mRecyclerView.mTempRect.set(r3, r4, r1, r2);
            setMeasuredDimension(this.mRecyclerView.mTempRect, r9, r10);
        }

        public void setMeasuredDimension(Rect r3, int r4, int r5) {
            int r0 = (r3.width() + getPaddingLeft()) + getPaddingRight();
            int r6 = (r3.height() + getPaddingTop()) + getPaddingBottom();
            setMeasuredDimension(chooseSize(r4, r0, getMinimumWidth()), chooseSize(r5, r6, getMinimumHeight()));
        }

        public void requestLayout() {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 == null) goto L6;
            r0.requestLayout();
            return;
        }

        public void assertInLayoutOrScroll(String r1) {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 == null) goto L6;
            r0.assertInLayoutOrScroll(r1);
            return;
        }

        public static int chooseSize(int r2, int r3, int r4) {
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

        public void assertNotInLayoutOrScroll(String r1) {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 == null) goto L6;
            r0.assertNotInLayoutOrScroll(r1);
            return;
        }

        @Deprecated
        public void setAutoMeasureEnabled(boolean r1) {
            this.mAutoMeasure = r1;
        }

        public boolean isAutoMeasureEnabled() {
            return this.mAutoMeasure;
        }

        public final void setItemPrefetchEnabled(boolean r2) {
            if (r2 == this.mItemPrefetchEnabled) goto L8;
            this.mItemPrefetchEnabled = r2;
            this.mPrefetchMaxCountObserved = 0;
            RecyclerView r1 = this.mRecyclerView;
            if (r1 == null) goto L9;
            r1.mRecycler.updateViewCacheSize();
            return;
        L9:
            return;
        }

        public final boolean isItemPrefetchEnabled() {
            return this.mItemPrefetchEnabled;
        }

        void dispatchAttachedToWindow(RecyclerView r2) {
            this.mIsAttachedToWindow = true;
            onAttachedToWindow(r2);
        }

        void dispatchDetachedFromWindow(RecyclerView r2, Recycler r3) {
            this.mIsAttachedToWindow = false;
            onDetachedFromWindow(r2, r3);
        }

        public boolean isAttachedToWindow() {
            return this.mIsAttachedToWindow;
        }

        public void postOnAnimation(Runnable r1) {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 == null) goto L6;
            ViewCompat.postOnAnimation(r0, r1);
            return;
        }

        public boolean removeCallbacks(Runnable r1) {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L5;
            return false;
        L5:
            return r0.removeCallbacks(r1);
        }

        public void onDetachedFromWindow(RecyclerView r1, Recycler r2) {
            onDetachedFromWindow(r1);
        }

        public boolean getClipToPadding() {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.mClipToPadding == false) goto L7;
            return true;
        }

        public void onLayoutChildren(Recycler r1, State r2) {
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
            if ((r1 instanceof LayoutParams) == false) goto L7;
            return new LayoutParams((LayoutParams) r1);
        L7:
            if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
            return new LayoutParams((ViewGroup.MarginLayoutParams) r1);
        L11:
            return new LayoutParams(r1);
        }

        public LayoutParams generateLayoutParams(Context r1, AttributeSet r2) {
            return new LayoutParams(r1, r2);
        }

        public void scrollToPosition(int r1) {
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L6;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(RecyclerView.TAG, "You MUST implement scrollToPosition. It will soon become abstract");
            return;
        }

        public void smoothScrollToPosition(RecyclerView r1, State r2, int r3) {
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void startSmoothScroll(SmoothScroller r2) {
            SmoothScroller r0 = this.mSmoothScroller;
            if (r0 == null) goto L8;
            if (r2 == r0) goto L8;
            if (r0.isRunning() == false) goto L8;
            this.mSmoothScroller.stop();
        L8:
            this.mSmoothScroller = r2;
            r2.start(this.mRecyclerView, this);
        }

        public boolean isSmoothScrolling() {
            SmoothScroller r0 = this.mSmoothScroller;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.isRunning() == false) goto L7;
            return true;
        }

        public int getLayoutDirection() {
            return ViewCompat.getLayoutDirection(this.mRecyclerView);
        }

        public void endAnimation(View r2) {
            if (this.mRecyclerView.mItemAnimator == null) goto L6;
            this.mRecyclerView.mItemAnimator.endAnimation(RecyclerView.getChildViewHolderInt(r2));
            return;
        }

        public void addDisappearingView(View r2) {
            addDisappearingView(r2, -1);
        }

        public void addDisappearingView(View r2, int r3) {
            addViewInt(r2, r3, true);
        }

        public void addView(View r2) {
            addView(r2, -1);
        }

        public void addView(View r2, int r3) {
            addViewInt(r2, r3, false);
        }

        private void addViewInt(View r5, int r6, boolean r7) {
            ViewHolder r0 = RecyclerView.getChildViewHolderInt(r5);
            if (r7 == false) goto L5;
        L8:
            this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(r0);
        L9:
            LayoutParams r8 = (LayoutParams) r5.getLayoutParams();
            if (r0.wasReturnedFromScrap() == true) goto L30;
            if (r0.isScrap() == true) goto L30;
            if (r5.getParent() != this.mRecyclerView) goto L24;
            int r1 = this.mChildHelper.indexOfChild(r5);
            if (r6 != (-1)) goto L19;
            r6 = this.mChildHelper.getChildCount();
        L19:
            if (r1 == (-1)) goto L23;
            if (r1 == r6) goto L35;
            this.mRecyclerView.mLayout.moveView(r1, r6);
        L35:
            if (r8.mPendingInvalidate == true) goto L37;
            return;
        L37:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L39;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(RecyclerView.TAG, "consuming pending invalidate on child " + r8.mViewHolder);
        L39:
            r0.itemView.invalidate();
            r8.mPendingInvalidate = false;
            return;
        L23:
            throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.mRecyclerView.indexOfChild(r5) + this.mRecyclerView.exceptionLabel());
        L24:
            this.mChildHelper.addView(r5, r6, false);
            r8.mInsetsDirty = true;
            SmoothScroller r9 = this.mSmoothScroller;
            if (r9 == null) goto L35;
            if (r9.isRunning() == false) goto L35;
            this.mSmoothScroller.onChildAttachedToWindow(r5);
        L30:
            if (r0.isScrap() == false) goto L32;
            r0.unScrap();
        L33:
            this.mChildHelper.attachViewToParent(r5, r6, r5.getLayoutParams(), false);
            goto L35
        L32:
            r0.clearReturnedFromScrapFlag();
            goto L33
        L5:
            if (r0.isRemoved() == true) goto L8;
            this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(r0);
            goto L9
        }

        public void removeView(View r1) {
            this.mChildHelper.removeView(r1);
        }

        public void removeViewAt(int r2) {
            if (getChildAt(r2) == null) goto L6;
            this.mChildHelper.removeViewAt(r2);
            return;
        }

        public void removeAllViews() {
            int r0 = getChildCount() - 1;
        L3:
            if (r0 < 0) goto L5;
            this.mChildHelper.removeViewAt(r0);
            r0 = r0 - 1;
            goto L3
        }

        public int getPosition(View r1) {
            return ((LayoutParams) r1.getLayoutParams()).getViewLayoutPosition();
        }

        public int getItemViewType(View r1) {
            return RecyclerView.getChildViewHolderInt(r1).getItemViewType();
        }

        public View findContainingItemView(View r3) {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L5;
            return null;
        L5:
            View r4 = r0.findContainingItemView(r3);
            if (r4 != null) goto L9;
            return null;
        L9:
            if (this.mChildHelper.isHidden(r4) == false) goto L11;
            return null;
        L11:
            return r4;
        }

        public View findViewByPosition(int r6) {
            int r0 = getChildCount();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L17;
            View r2 = getChildAt(r1);
            ViewHolder r3 = RecyclerView.getChildViewHolderInt(r2);
            if (r3 == null) goto L16;
            if (r3.getLayoutPosition() != r6) goto L16;
            if (r3.shouldIgnore() == true) goto L16;
            if (this.mRecyclerView.mState.isPreLayout() == true) goto L15;
            if (r3.isRemoved() == true) goto L16;
        L15:
            return r2;
        L16:
            r1 = r1 + 1;
            goto L3
        L17:
            return null;
        }

        public void detachView(View r2) {
            int r0 = this.mChildHelper.indexOfChild(r2);
            if (r0 < 0) goto L6;
            detachViewInternal(r0, r2);
            return;
        }

        public void detachViewAt(int r2) {
            detachViewInternal(r2, getChildAt(r2));
        }

        private void detachViewInternal(int r1, View r2) {
            this.mChildHelper.detachViewFromParent(r1);
        }

        public void attachView(View r3, int r4, LayoutParams r5) {
            ViewHolder r0 = RecyclerView.getChildViewHolderInt(r3);
            if (r0.isRemoved() == false) goto L5;
            this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(r0);
        L6:
            this.mChildHelper.attachViewToParent(r3, r4, r5, r0.isRemoved());
            return;
        L5:
            this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(r0);
            goto L6
        }

        public void attachView(View r2, int r3) {
            attachView(r2, r3, (LayoutParams) r2.getLayoutParams());
        }

        public void attachView(View r2) {
            attachView(r2, -1);
        }

        public void removeDetachedView(View r2) {
            this.mRecyclerView.removeDetachedView(r2, false);
        }

        public void moveView(int r3, int r4) {
            View r0 = getChildAt(r3);
            if (r0 == null) goto L7;
            detachViewAt(r3);
            attachView(r0, r4);
            return;
        L7:
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + r3 + this.mRecyclerView.toString());
        }

        public void detachAndScrapView(View r2, Recycler r3) {
            scrapOrRecycleView(r3, this.mChildHelper.indexOfChild(r2), r2);
        }

        public void detachAndScrapViewAt(int r2, Recycler r3) {
            scrapOrRecycleView(r3, r2, getChildAt(r2));
        }

        public void removeAndRecycleView(View r1, Recycler r2) {
            removeView(r1);
            r2.recycleView(r1);
        }

        public void removeAndRecycleViewAt(int r2, Recycler r3) {
            View r0 = getChildAt(r2);
            removeViewAt(r2);
            r3.recycleView(r0);
        }

        public int getChildCount() {
            ChildHelper r0 = this.mChildHelper;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getChildCount();
        }

        public View getChildAt(int r1) {
            ChildHelper r0 = this.mChildHelper;
            if (r0 != null) goto L7;
            return null;
        L7:
            return r0.getChildAt(r1);
        }

        public int getWidthMode() {
            return this.mWidthMode;
        }

        public int getHeightMode() {
            return this.mHeightMode;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getPaddingLeft() {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getPaddingLeft();
        }

        public int getPaddingTop() {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getPaddingTop();
        }

        public int getPaddingRight() {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getPaddingRight();
        }

        public int getPaddingBottom() {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.getPaddingBottom();
        }

        public int getPaddingStart() {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return ViewCompat.getPaddingStart(r0);
        }

        public int getPaddingEnd() {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return ViewCompat.getPaddingEnd(r0);
        }

        public boolean isFocused() {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.isFocused() == false) goto L7;
            return true;
        }

        public boolean hasFocus() {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.hasFocus() == false) goto L7;
            return true;
        }

        public View getFocusedChild() {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L5;
            return null;
        L5:
            View r1 = r0.getFocusedChild();
            if (r1 != null) goto L8;
        L11:
            return null;
        L8:
            if (this.mChildHelper.isHidden(r1) == true) goto L11;
            return r1;
        }

        public int getItemCount() {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 == null) goto L5;
            Adapter r1 = r0.getAdapter();
        L6:
            if (r1 != null) goto L10;
            return 0;
        L10:
            return r1.getItemCount();
        L5:
            r1 = null;
            goto L6
        }

        public void offsetChildrenHorizontal(int r1) {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 == null) goto L6;
            r0.offsetChildrenHorizontal(r1);
            return;
        }

        public void offsetChildrenVertical(int r1) {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 == null) goto L6;
            r0.offsetChildrenVertical(r1);
            return;
        }

        public void ignoreView(View r3) {
            ViewParent r0 = r3.getParent();
            RecyclerView r1 = this.mRecyclerView;
            if (r0 != r1) goto L9;
            if (r1.indexOfChild(r3) == (-1)) goto L9;
            ViewHolder r4 = RecyclerView.getChildViewHolderInt(r3);
            r4.addFlags(128);
            this.mRecyclerView.mViewInfoStore.removeViewHolder(r4);
            return;
        L9:
            throw new IllegalArgumentException("View should be fully attached to be ignored" + this.mRecyclerView.exceptionLabel());
        }

        public void stopIgnoringView(View r1) {
            ViewHolder r0 = RecyclerView.getChildViewHolderInt(r1);
            r0.stopIgnoring();
            r0.resetInternal();
            r0.addFlags(4);
        }

        public void detachAndScrapAttachedViews(Recycler r3) {
            int r0 = getChildCount() - 1;
        L3:
            if (r0 < 0) goto L5;
            scrapOrRecycleView(r3, r0, getChildAt(r0));
            r0 = r0 - 1;
            goto L3
        }

        private void scrapOrRecycleView(Recycler r3, int r4, View r5) {
            ViewHolder r0 = RecyclerView.getChildViewHolderInt(r5);
            if (r0.shouldIgnore() == false) goto L9;
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L17;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(RecyclerView.TAG, "ignoring view " + r0);
            return;
        L17:
            return;
        L9:
            if (r0.isInvalid() == true) goto L11;
        L15:
            detachViewAt(r4);
            r3.scrapView(r5);
            this.mRecyclerView.mViewInfoStore.onViewDetached(r0);
            return;
        L11:
            if (r0.isRemoved() == true) goto L15;
            if (this.mRecyclerView.mAdapter.hasStableIds() == true) goto L15;
            removeViewAt(r4);
            r3.recycleViewHolderInternal(r0);
        }

        void removeAndRecycleScrapInt(Recycler r7) {
            int r0 = r7.getScrapCount();
            int r1 = r0 - 1;
        L3:
            if (r1 < 0) goto L15;
            View r2 = r7.getScrapViewAt(r1);
            ViewHolder r3 = RecyclerView.getChildViewHolderInt(r2);
            if (r3.shouldIgnore() == true) goto L14;
            r3.setIsRecyclable(false);
            if (r3.isTmpDetached() == false) goto L11;
            this.mRecyclerView.removeDetachedView(r2, false);
        L11:
            if (this.mRecyclerView.mItemAnimator == null) goto L13;
            this.mRecyclerView.mItemAnimator.endAnimation(r3);
        L13:
            r3.setIsRecyclable(true);
            r7.quickRecycleScrapView(r2);
        L14:
            r1 = r1 - 1;
            goto L3
        L15:
            r7.clearScrap();
            if (r0 <= 0) goto L22;
            this.mRecyclerView.invalidate();
            return;
        }

        public void measureChild(View r6, int r7, int r8) {
            LayoutParams r0 = (LayoutParams) r6.getLayoutParams();
            Rect r1 = this.mRecyclerView.getItemDecorInsetsForChild(r6);
            int r9 = r7 + (r1.left + r1.right);
            int r10 = r8 + (r1.top + r1.bottom);
            int r11 = getChildMeasureSpec(getWidth(), getWidthMode(), (getPaddingLeft() + getPaddingRight()) + r9, r0.width, canScrollHorizontally());
            int r12 = getChildMeasureSpec(getHeight(), getHeightMode(), (getPaddingTop() + getPaddingBottom()) + r10, r0.height, canScrollVertically());
            if (shouldMeasureChild(r6, r11, r12, r0) == false) goto L6;
            r6.measure(r11, r12);
            return;
        }

        boolean shouldReMeasureChild(View r2, int r3, int r4, LayoutParams r5) {
            if (this.mMeasurementCacheEnabled == true) goto L5;
        L10:
            return true;
        L5:
            if (isMeasurementUpToDate(r2.getMeasuredWidth(), r3, r5.width) == false) goto L10;
            if (isMeasurementUpToDate(r2.getMeasuredHeight(), r4, r5.height) == false) goto L10;
            return false;
        }

        boolean shouldMeasureChild(View r2, int r3, int r4, LayoutParams r5) {
            if (r2.isLayoutRequested() == false) goto L5;
        L12:
            return true;
        L5:
            if (this.mMeasurementCacheEnabled == false) goto L12;
            if (isMeasurementUpToDate(r2.getWidth(), r3, r5.width) == false) goto L12;
            if (isMeasurementUpToDate(r2.getHeight(), r4, r5.height) == false) goto L12;
            return false;
        }

        public boolean isMeasurementCacheEnabled() {
            return this.mMeasurementCacheEnabled;
        }

        public void setMeasurementCacheEnabled(boolean r1) {
            this.mMeasurementCacheEnabled = r1;
        }

        private static boolean isMeasurementUpToDate(int r3, int r4, int r5) {
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

        public void measureChildWithMargins(View r6, int r7, int r8) {
            LayoutParams r0 = (LayoutParams) r6.getLayoutParams();
            Rect r1 = this.mRecyclerView.getItemDecorInsetsForChild(r6);
            int r9 = r7 + (r1.left + r1.right);
            int r10 = r8 + (r1.top + r1.bottom);
            int r11 = getChildMeasureSpec(getWidth(), getWidthMode(), (((getPaddingLeft() + getPaddingRight()) + r0.leftMargin) + r0.rightMargin) + r9, r0.width, canScrollHorizontally());
            int r12 = getChildMeasureSpec(getHeight(), getHeightMode(), (((getPaddingTop() + getPaddingBottom()) + r0.topMargin) + r0.bottomMargin) + r10, r0.height, canScrollVertically());
            if (shouldMeasureChild(r6, r11, r12, r0) == false) goto L6;
            r6.measure(r11, r12);
            return;
        }

        @Deprecated
        public static int getChildMeasureSpec(int r1, int r2, int r3, boolean r4) {
            int r5 = r1 - r2;
            int r6 = 0;
            int r7 = Math.max(0, r5);
            if (r4 == false) goto L7;
            if (r3 >= 0) goto L8;
        L6:
            r3 = 0;
        L16:
            return View.MeasureSpec.makeMeasureSpec(r3, r6);
        L8:
            r6 = 1073741824;
            goto L16
        L7:
            if (r3 >= 0) goto L8;
            if (r3 != (-1)) goto L13;
            r3 = r7;
            goto L8
        L13:
            if (r3 != (-2)) goto L6;
            r6 = Integer.MIN_VALUE;
            r3 = r7;
            goto L16
        }

        public static int getChildMeasureSpec(int r4, int r5, int r6, int r7, boolean r8) {
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

        public int getDecoratedMeasuredWidth(View r2) {
            Rect r1 = ((LayoutParams) r2.getLayoutParams()).mDecorInsets;
            return (r2.getMeasuredWidth() + r1.left) + r1.right;
        }

        public int getDecoratedMeasuredHeight(View r2) {
            Rect r1 = ((LayoutParams) r2.getLayoutParams()).mDecorInsets;
            return (r2.getMeasuredHeight() + r1.top) + r1.bottom;
        }

        public void layoutDecorated(View r2, int r3, int r4, int r5, int r6) {
            Rect r1 = ((LayoutParams) r2.getLayoutParams()).mDecorInsets;
            r2.layout(r3 + r1.left, r4 + r1.top, r5 - r1.right, r6 - r1.bottom);
        }

        public void layoutDecoratedWithMargins(View r3, int r4, int r5, int r6, int r7) {
            LayoutParams r2 = (LayoutParams) r3.getLayoutParams();
            Rect r0 = r2.mDecorInsets;
            r3.layout((r4 + r0.left) + r2.leftMargin, (r5 + r0.top) + r2.topMargin, (r6 - r0.right) - r2.rightMargin, (r7 - r0.bottom) - r2.bottomMargin);
        }

        public void getTransformedBoundingBox(View r5, boolean r6, Rect r7) {
            if (r6 == false) goto L4;
            Rect r8 = ((LayoutParams) r5.getLayoutParams()).mDecorInsets;
            r7.set(-r8.left, -r8.top, r5.getWidth() + r8.right, r5.getHeight() + r8.bottom);
        L6:
            if (this.mRecyclerView == null) goto L12;
            Matrix r9 = r5.getMatrix();
            if (r9 == null) goto L12;
            if (r9.isIdentity() == true) goto L12;
            RectF r4 = this.mRecyclerView.mTempRectF;
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

        public void getDecoratedBoundsWithMargins(View r1, Rect r2) {
            RecyclerView.getDecoratedBoundsWithMarginsInt(r1, r2);
        }

        public int getDecoratedLeft(View r2) {
            return r2.getLeft() - getLeftDecorationWidth(r2);
        }

        public int getDecoratedTop(View r2) {
            return r2.getTop() - getTopDecorationHeight(r2);
        }

        public int getDecoratedRight(View r2) {
            return r2.getRight() + getRightDecorationWidth(r2);
        }

        public int getDecoratedBottom(View r2) {
            return r2.getBottom() + getBottomDecorationHeight(r2);
        }

        public void calculateItemDecorationsForChild(View r1, Rect r2) {
            RecyclerView r0 = this.mRecyclerView;
            if (r0 != null) goto L6;
            r2.set(0, 0, 0, 0);
            return;
        L6:
            r2.set(r0.getItemDecorInsetsForChild(r1));
        }

        public int getTopDecorationHeight(View r1) {
            return ((LayoutParams) r1.getLayoutParams()).mDecorInsets.top;
        }

        public int getBottomDecorationHeight(View r1) {
            return ((LayoutParams) r1.getLayoutParams()).mDecorInsets.bottom;
        }

        public int getLeftDecorationWidth(View r1) {
            return ((LayoutParams) r1.getLayoutParams()).mDecorInsets.left;
        }

        public int getRightDecorationWidth(View r1) {
            return ((LayoutParams) r1.getLayoutParams()).mDecorInsets.right;
        }

        private int[] getChildRectangleOnScreenScrollAmount(View r9, Rect r10) {
            int[] r0 = new int[2];
            int r1 = getPaddingLeft();
            int r2 = getPaddingTop();
            int r3 = getWidth() - getPaddingRight();
            int r4 = getHeight() - getPaddingBottom();
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
            if (getLayoutDirection() != 1) goto L7;
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

        public boolean requestChildRectangleOnScreen(RecyclerView r7, View r8, Rect r9, boolean r10) {
            return requestChildRectangleOnScreen(r7, r8, r9, r10, false);
        }

        public boolean requestChildRectangleOnScreen(RecyclerView r3, View r4, Rect r5, boolean r6, boolean r7) {
            int[] r8 = getChildRectangleOnScreenScrollAmount(r4, r5);
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
            if (isFocusedChildVisibleAfterScrolling(r3, r0, r9) == false) goto L9;
            goto L6
        }

        public boolean isViewPartiallyVisible(View r3, boolean r4, boolean r5) {
            if (this.mHorizontalBoundCheck.isViewWithinBoundFlags(r3, 24579) == true) goto L5;
        L7:
            boolean r2 = false;
        L8:
            if (r4 == false) goto L11;
            return r2;
        L11:
            return !r2;
        L5:
            if (this.mVerticalBoundCheck.isViewWithinBoundFlags(r3, 24579) == false) goto L7;
            r2 = true;
            goto L8
        }

        private boolean isFocusedChildVisibleAfterScrolling(RecyclerView r7, int r8, int r9) {
            View r10 = r7.getFocusedChild();
            if (r10 != null) goto L5;
            return false;
        L5:
            int r1 = getPaddingLeft();
            int r2 = getPaddingTop();
            int r3 = getWidth() - getPaddingRight();
            int r4 = getHeight() - getPaddingBottom();
            Rect r5 = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(r10, r5);
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
        public boolean onRequestChildFocus(RecyclerView r1, View r2, View r3) {
            if (isSmoothScrolling() == false) goto L5;
        L8:
            return true;
        L5:
            if (r1.isComputingLayout() == true) goto L8;
            return false;
        }

        public boolean onRequestChildFocus(RecyclerView r1, State r2, View r3, View r4) {
            return onRequestChildFocus(r1, r3, r4);
        }

        public void onItemsUpdated(RecyclerView r1, int r2, int r3, Object r4) {
            onItemsUpdated(r1, r2, r3);
        }

        public void onMeasure(Recycler r1, State r2, int r3, int r4) {
            this.mRecyclerView.defaultOnMeasure(r3, r4);
        }

        public void setMeasuredDimension(int r1, int r2) {
            RecyclerView.access$500(this.mRecyclerView, r1, r2);
        }

        public int getMinimumWidth() {
            return ViewCompat.getMinimumWidth(this.mRecyclerView);
        }

        public int getMinimumHeight() {
            return ViewCompat.getMinimumHeight(this.mRecyclerView);
        }

        void stopSmoothScroller() {
            SmoothScroller r0 = this.mSmoothScroller;
            if (r0 == null) goto L6;
            r0.stop();
            return;
        }

        void onSmoothScrollerStopped(SmoothScroller r2) {
            if (this.mSmoothScroller != r2) goto L6;
            this.mSmoothScroller = null;
            return;
        }

        public void removeAndRecycleAllViews(Recycler r3) {
            int r0 = getChildCount() - 1;
        L3:
            if (r0 < 0) goto L8;
            if (RecyclerView.getChildViewHolderInt(getChildAt(r0)).shouldIgnore() == true) goto L7;
            removeAndRecycleViewAt(r0, r3);
        L7:
            r0 = r0 - 1;
            goto L3
        }

        void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat r3) {
            onInitializeAccessibilityNodeInfo(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, r3);
        }

        public void onInitializeAccessibilityNodeInfo(Recycler r4, State r5, AccessibilityNodeInfoCompat r6) {
            if (this.mRecyclerView.canScrollVertically(-1) == false) goto L5;
        L6:
            r6.addAction(8192);
            r6.setScrollable(true);
        L8:
            if (this.mRecyclerView.canScrollVertically(1) == false) goto L10;
        L11:
            r6.addAction(4096);
            r6.setScrollable(true);
        L12:
            r6.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCountForAccessibility(r4, r5), getColumnCountForAccessibility(r4, r5), isLayoutHierarchical(r4, r5), getSelectionModeForAccessibility(r4, r5)));
            return;
        L10:
            if (this.mRecyclerView.canScrollHorizontally(1) == false) goto L12;
        L5:
            if (this.mRecyclerView.canScrollHorizontally(-1) == false) goto L8;
            goto L6
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent r3) {
            onInitializeAccessibilityEvent(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, r3);
        }

        public void onInitializeAccessibilityEvent(Recycler r2, State r3, AccessibilityEvent r4) {
            RecyclerView r5 = this.mRecyclerView;
            if (r5 == null) goto L20;
            if (r4 == null) goto L22;
            boolean r6 = true;
            if (r5.canScrollVertically(1) == false) goto L9;
        L16:
            r4.setScrollable(r6);
            if (this.mRecyclerView.mAdapter == null) goto L21;
            r4.setItemCount(this.mRecyclerView.mAdapter.getItemCount());
            return;
        L21:
            return;
        L9:
            if (this.mRecyclerView.canScrollVertically(-1) == true) goto L16;
            if (this.mRecyclerView.canScrollHorizontally(-1) == true) goto L16;
            if (this.mRecyclerView.canScrollHorizontally(1) == true) goto L16;
            r6 = false;
            goto L16
        L22:
            return;
        }

        void onInitializeAccessibilityNodeInfoForItem(View r3, AccessibilityNodeInfoCompat r4) {
            ViewHolder r0 = RecyclerView.getChildViewHolderInt(r3);
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.isRemoved() == false) goto L7;
            return;
        L7:
            if (this.mChildHelper.isHidden(r0.itemView) == true) goto L12;
            onInitializeAccessibilityNodeInfoForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, r3, r4);
            return;
        }

        public void requestSimpleAnimationsInNextLayout() {
            this.mRequestedSimpleAnimations = true;
        }

        boolean performAccessibilityAction(int r3, Bundle r4) {
            return performAccessibilityAction(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, r3, r4);
        }

        public boolean performAccessibilityAction(Recycler r9, State r10, int r11, Bundle r12) {
            if (this.mRecyclerView != null) goto L5;
            return false;
        L5:
            int r13 = getHeight();
            int r14 = getWidth();
            Rect r0 = new Rect();
            if (this.mRecyclerView.getMatrix().isIdentity() == false) goto L11;
            if (this.mRecyclerView.getGlobalVisibleRect(r0) == false) goto L11;
            r13 = r0.height();
            r14 = r0.width();
        L11:
            if (r11 == 4096) goto L23;
            if (r11 == 8192) goto L16;
            int r3 = 0;
            int r4 = 0;
        L31:
            if (r4 != 0) goto L34;
            if (r3 != 0) goto L34;
            return false;
        L34:
            this.mRecyclerView.smoothScrollBy(r3, r4, null, Integer.MIN_VALUE, true);
            return true;
        L16:
            if (this.mRecyclerView.canScrollVertically(-1) == false) goto L18;
            int r15 = -((r13 - getPaddingTop()) - getPaddingBottom());
        L20:
            if (this.mRecyclerView.canScrollHorizontally(-1) == false) goto L30;
            int r16 = -((r14 - getPaddingLeft()) - getPaddingRight());
        L29:
            r4 = r15;
            r3 = r16;
        L30:
            r4 = r15;
            r3 = 0;
            goto L31
        L18:
            r15 = 0;
            goto L20
        L23:
            if (this.mRecyclerView.canScrollVertically(1) == false) goto L25;
            r15 = (r13 - getPaddingTop()) - getPaddingBottom();
        L27:
            if (this.mRecyclerView.canScrollHorizontally(1) == false) goto L30;
            r16 = (r14 - getPaddingLeft()) - getPaddingRight();
            goto L29
        L25:
            r15 = 0;
            goto L27
        }

        boolean performAccessibilityActionForItem(View r8, int r9, Bundle r10) {
            return performAccessibilityActionForItem(this.mRecyclerView.mRecycler, this.mRecyclerView.mState, r8, r9, r10);
        }

        public static Properties getProperties(Context r2, AttributeSet r3, int r4, int r5) {
            Properties r0 = new Properties();
            TypedArray r6 = r2.obtainStyledAttributes(r3, R.styleable.RecyclerView, r4, r5);
            r0.orientation = r6.getInt(R.styleable.RecyclerView_android_orientation, 1);
            r0.spanCount = r6.getInt(R.styleable.RecyclerView_spanCount, 1);
            r0.reverseLayout = r6.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
            r0.stackFromEnd = r6.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
            r6.recycle();
            return r0;
        }

        void setExactMeasureSpecsFrom(RecyclerView r3) {
            setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(r3.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(r3.getHeight(), 1073741824));
        }

        boolean hasFlexibleChildInBothOrientations() {
            int r0 = getChildCount();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L11;
            ViewGroup.LayoutParams r3 = getChildAt(r2).getLayoutParams();
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

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        final Rect mDecorInsets;
        boolean mInsetsDirty;
        boolean mPendingInvalidate;
        ViewHolder mViewHolder;

        public LayoutParams(Context r1, AttributeSet r2) {
            super(r1, r2);
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
            return this.mViewHolder.needsUpdate();
        }

        public boolean isViewInvalid() {
            return this.mViewHolder.isInvalid();
        }

        public boolean isItemRemoved() {
            return this.mViewHolder.isRemoved();
        }

        public boolean isItemChanged() {
            return this.mViewHolder.isUpdated();
        }

        @Deprecated
        public int getViewPosition() {
            return this.mViewHolder.getPosition();
        }

        public int getViewLayoutPosition() {
            return this.mViewHolder.getLayoutPosition();
        }

        @Deprecated
        public int getViewAdapterPosition() {
            return this.mViewHolder.getBindingAdapterPosition();
        }

        public int getAbsoluteAdapterPosition() {
            return this.mViewHolder.getAbsoluteAdapterPosition();
        }

        public int getBindingAdapterPosition() {
            return this.mViewHolder.getBindingAdapterPosition();
        }
    }

    public interface OnBounceTranslationListener {
        void onTranslationChanged(float r1);
    }

    public interface OnChildAttachStateChangeListener {
        void onChildViewAttachedToWindow(View r1);

        void onChildViewDetachedFromWindow(View r1);
    }

    public static abstract class OnFlingListener {
        public abstract boolean onFling(int r1, int r2);

        public OnFlingListener() {
        }
    }

    public interface OnItemTouchListener {
        boolean onInterceptTouchEvent(RecyclerView r1, MotionEvent r2);

        void onRequestDisallowInterceptTouchEvent(boolean r1);

        void onTouchEvent(RecyclerView r1, MotionEvent r2);
    }

    public static abstract class OnScrollListener {
        public void onScrollStateChanged(RecyclerView r1, int r2) {
        }

        public void onScrolled(RecyclerView r1, int r2, int r3) {
        }

        public OnScrollListener() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    public static class RecycledViewPool {
        private static final int DEFAULT_MAX_SCRAP = 5;
        int mAttachCountForClearing;
        Set<Adapter<?>> mAttachedAdaptersForPoolingContainer;
        SparseArray<ScrapData> mScrap;

        static class ScrapData {
            long mBindRunningAverageNs;
            long mCreateRunningAverageNs;
            int mMaxScrap;
            final ArrayList<ViewHolder> mScrapHeap;

            ScrapData() {
                this.mScrapHeap = new ArrayList();
                this.mMaxScrap = 5;
                this.mCreateRunningAverageNs = 0;
                this.mBindRunningAverageNs = 0;
            }
        }

        public RecycledViewPool() {
            this.mScrap = new SparseArray();
            this.mAttachCountForClearing = 0;
            this.mAttachedAdaptersForPoolingContainer = Collections.newSetFromMap(new IdentityHashMap());
        }

        public void clear() {
            int r0 = 0;
        L4:
            if (r0 >= this.mScrap.size()) goto L10;
            ScrapData r1 = this.mScrap.valueAt(r0);
            Iterator<ViewHolder> r2 = r1.mScrapHeap.iterator();
        L7:
            if (r2.hasNext() == false) goto L9;
            PoolingContainer.callPoolingContainerOnRelease(r2.next().itemView);
            goto L7
        L9:
            r1.mScrapHeap.clear();
            r0 = r0 + 1;
            goto L4
        }

        public void setMaxRecycledViews(int r1, int r2) {
            ScrapData r0 = getScrapDataForType(r1);
            r0.mMaxScrap = r2;
            ArrayList<ViewHolder> r3 = r0.mScrapHeap;
        L4:
            if (r3.size() <= r2) goto L6;
            r3.remove(r3.size() - 1);
            goto L4
        }

        public int getRecycledViewCount(int r1) {
            return getScrapDataForType(r1).mScrapHeap.size();
        }

        public ViewHolder getRecycledView(int r2) {
            ScrapData r1 = this.mScrap.get(r2);
            if (r1 != null) goto L5;
            return null;
        L5:
            if (r1.mScrapHeap.isEmpty() == true) goto L17;
            ArrayList<ViewHolder> r3 = r1.mScrapHeap;
            int r4 = r3.size() - 1;
        L7:
            if (r4 < 0) goto L18;
            if (r3.get(r4).isAttachedToTransitionOverlay() == false) goto L11;
            r4 = r4 - 1;
            goto L7
        L11:
            return r3.remove(r4);
        L18:
            return null;
        L17:
            return null;
        }

        int size() {
            int r0 = 0;
            int r1 = 0;
        L4:
            if (r0 >= this.mScrap.size()) goto L9;
            ArrayList<ViewHolder> r2 = this.mScrap.valueAt(r0).mScrapHeap;
            if (r2 == null) goto L8;
            r1 = r1 + r2.size();
        L8:
            r0 = r0 + 1;
            goto L4
        L9:
            return r1;
        }

        public void putRecycledView(ViewHolder r3) {
            int r0 = r3.getItemViewType();
            ArrayList<ViewHolder> r1 = getScrapDataForType(r0).mScrapHeap;
            if (this.mScrap.get(r0).mMaxScrap > r1.size()) goto L7;
            PoolingContainer.callPoolingContainerOnRelease(r3.itemView);
            return;
        L7:
            if (RecyclerView.sDebugAssertionsEnabled == true) goto L9;
        L13:
            r3.resetInternal();
            r1.add(r3);
            return;
        L9:
            if (r1.contains(r3) == false) goto L13;
            throw new IllegalArgumentException("this scrap item already exists");
        }

        long runningAverage(long r5, long r7) {
            if (r5 != 0) goto L6;
            return r7;
        L6:
            return ((r5 / 4) * 3) + (r7 / 4);
        }

        void factorInCreateTime(int r3, long r4) {
            ScrapData r5 = getScrapDataForType(r3);
            r5.mCreateRunningAverageNs = runningAverage(r5.mCreateRunningAverageNs, r4);
        }

        void factorInBindTime(int r3, long r4) {
            ScrapData r5 = getScrapDataForType(r3);
            r5.mBindRunningAverageNs = runningAverage(r5.mBindRunningAverageNs, r4);
        }

        boolean willCreateInTime(int r3, long r4, long r6) {
            long r2 = getScrapDataForType(r3).mCreateRunningAverageNs;
            if (r2 != 0) goto L5;
        L8:
            return true;
        L5:
            if ((r4 + r2) < r6) goto L8;
            return false;
        }

        boolean willBindInTime(int r3, long r4, long r6) {
            long r2 = getScrapDataForType(r3).mBindRunningAverageNs;
            if (r2 != 0) goto L5;
        L8:
            return true;
        L5:
            if ((r4 + r2) < r6) goto L8;
            return false;
        }

        void attach() {
            this.mAttachCountForClearing++;
        }

        void detach() {
            this.mAttachCountForClearing--;
        }

        void attachForPoolingContainer(Adapter<?> r1) {
            this.mAttachedAdaptersForPoolingContainer.add(r1);
        }

        void detachForPoolingContainer(Adapter<?> r4, boolean r5) {
            this.mAttachedAdaptersForPoolingContainer.remove(r4);
            if (this.mAttachedAdaptersForPoolingContainer.size() != 0) goto L13;
            if (r5 == true) goto L16;
            int r6 = 0;
        L7:
            if (r6 >= this.mScrap.size()) goto L17;
            SparseArray<ScrapData> r0 = this.mScrap;
            ArrayList<ViewHolder> r1 = r0.get(r0.keyAt(r6)).mScrapHeap;
            int r2 = 0;
        L10:
            if (r2 >= r1.size()) goto L12;
            PoolingContainer.callPoolingContainerOnRelease(r1.get(r2).itemView);
            r2 = r2 + 1;
            goto L10
        L12:
            r6 = r6 + 1;
            goto L7
        L17:
            return;
        L16:
            return;
        }

        void onAdapterChanged(Adapter<?> r1, Adapter<?> r2, boolean r3) {
            if (r1 == null) goto L4;
            detach();
        L4:
            if (r3 == false) goto L6;
        L8:
            if (r2 == null) goto L11;
            attach();
            return;
        L11:
            return;
        L6:
            if (this.mAttachCountForClearing != 0) goto L8;
            clear();
            goto L8
        }

        private ScrapData getScrapDataForType(int r2) {
            ScrapData r0 = this.mScrap.get(r2);
            if (r0 != null) goto L6;
            ScrapData r1 = new ScrapData();
            this.mScrap.put(r2, r1);
            return r1;
        L6:
            return r0;
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

        public Recycler(RecyclerView r2) {
            this.this$0 = r2;
            ArrayList<ViewHolder> r3 = new ArrayList();
            this.mAttachedScrap = r3;
            this.mChangedScrap = null;
            this.mCachedViews = new ArrayList();
            this.mUnmodifiableAttachedScrap = Collections.unmodifiableList(r3);
            this.mRequestedCacheMax = 2;
            this.mViewCacheMax = 2;
        }

        public void clear() {
            this.mAttachedScrap.clear();
            recycleAndClearCachedViews();
        }

        public void setViewCacheSize(int r1) {
            this.mRequestedCacheMax = r1;
            updateViewCacheSize();
        }

        void updateViewCacheSize() {
            if (this.this$0.mLayout == null) goto L5;
            int r0 = this.this$0.mLayout.mPrefetchMaxCountObserved;
        L6:
            this.mViewCacheMax = this.mRequestedCacheMax + r0;
            int r1 = this.mCachedViews.size() - 1;
        L7:
            if (r1 < 0) goto L11;
            if (this.mCachedViews.size() <= this.mViewCacheMax) goto L14;
            recycleCachedViewAt(r1);
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

        public List<ViewHolder> getScrapList() {
            return this.mUnmodifiableAttachedScrap;
        }

        boolean validateViewHolderForOffsetPosition(ViewHolder r6) {
            if (r6.isRemoved() == false) goto L14;
            if (RecyclerView.sDebugAssertionsEnabled == false) goto L12;
            if (this.this$0.mState.isPreLayout() == true) goto L12;
            throw new IllegalStateException("should not receive a removed view unless it is pre layout" + this.this$0.exceptionLabel());
        L12:
            return this.this$0.mState.isPreLayout();
        L14:
            if (r6.mPosition < 0) goto L30;
            if (r6.mPosition >= this.this$0.mAdapter.getItemCount()) goto L30;
            if (this.this$0.mState.isPreLayout() == true) goto L23;
            if (this.this$0.mAdapter.getItemViewType(r6.mPosition) == r6.getItemViewType()) goto L23;
            return false;
        L23:
            if (this.this$0.mAdapter.hasStableIds() == true) goto L25;
            return true;
        L25:
            if (r6.getItemId() == this.this$0.mAdapter.getItemId(r6.mPosition)) goto L27;
            return false;
        L27:
            return true;
        L30:
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + r6 + this.this$0.exceptionLabel());
        }

        private boolean tryBindViewHolderByDeadline(ViewHolder r11, int r12, int r13, long r14) {
            r11.mBindingAdapter = null;
            r11.mOwnerRecyclerView = this.this$0;
            int r2 = r11.getItemViewType();
            long r7 = this.this$0.getNanoTime();
            boolean r9 = false;
            if (r14 == Long.MAX_VALUE) goto L8;
            if (this.mRecyclerPool.willBindInTime(r2, r7, r14) == true) goto L8;
            return false;
        L8:
            if (r11.isTmpDetached() == false) goto L10;
            RecyclerView.access$300(this.this$0, r11.itemView, this.this$0.getChildCount(), r11.itemView.getLayoutParams());
            r9 = true;
        L10:
            this.this$0.mAdapter.bindViewHolder(r11, r12);
            if (r9 == false) goto L13;
            RecyclerView.access$400(this.this$0, r11.itemView);
        L13:
            this.mRecyclerPool.factorInBindTime(r11.getItemViewType(), this.this$0.getNanoTime() - r7);
            attachAccessibilityDelegateOnBind(r11);
            if (this.this$0.mState.isPreLayout() == false) goto L16;
            r11.mPreLayoutPosition = r13;
        L16:
            return true;
        }

        public void bindViewToPosition(View r7, int r8) {
            ViewHolder r9 = RecyclerView.getChildViewHolderInt(r7);
            if (r9 == null) goto L24;
            int r2 = this.this$0.mAdapterHelper.findPositionOffset(r8);
            if (r2 < 0) goto L22;
            if (r2 >= this.this$0.mAdapter.getItemCount()) goto L22;
            tryBindViewHolderByDeadline(r9, r2, r8, Long.MAX_VALUE);
            ViewGroup.LayoutParams r10 = r9.itemView.getLayoutParams();
            if (r10 != null) goto L12;
            LayoutParams r6 = (LayoutParams) this.this$0.generateDefaultLayoutParams();
            r9.itemView.setLayoutParams(r6);
        L15:
            boolean r11 = true;
            r6.mInsetsDirty = true;
            r6.mViewHolder = r9;
            if (r9.itemView.getParent() == null) goto L19;
            r11 = false;
        L19:
            r6.mPendingInvalidate = r11;
            return;
        L12:
            if (this.this$0.checkLayoutParams(r10) == true) goto L14;
            r6 = (LayoutParams) this.this$0.generateLayoutParams(r10);
            r9.itemView.setLayoutParams(r6);
            goto L15
        L14:
            r6 = (LayoutParams) r10;
        L22:
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + r8 + "(offset:" + r2 + ").state:" + this.this$0.mState.getItemCount() + this.this$0.exceptionLabel());
        L24:
            throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter" + this.this$0.exceptionLabel());
        }

        public int convertPreLayoutPositionToPostLayout(int r4) {
            if (r4 < 0) goto L11;
            if (r4 >= this.this$0.mState.getItemCount()) goto L11;
            if (this.this$0.mState.isPreLayout() == true) goto L9;
            return r4;
        L9:
            return this.this$0.mAdapterHelper.findPositionOffset(r4);
        L11:
            throw new IndexOutOfBoundsException("invalid position " + r4 + ". State item count is " + this.this$0.mState.getItemCount() + this.this$0.exceptionLabel());
        }

        public View getViewForPosition(int r2) {
            return getViewForPosition(r2, false);
        }

        View getViewForPosition(int r3, boolean r4) {
            return tryGetViewHolderForPositionByDeadline(r3, r4, Long.MAX_VALUE).itemView;
        }

        ViewHolder tryGetViewHolderForPositionByDeadline(int r19, boolean r20, long r21) {
            if (r19 < 0) goto L123;
            if (r19 >= this.this$0.mState.getItemCount()) goto L123;
            boolean r7 = true;
            if (this.this$0.mState.isPreLayout() == false) goto L11;
            ViewHolder r1 = getChangedScrapViewForPosition(r19);
            if (r1 == null) goto L12;
            boolean r4 = true;
        L13:
            if (r1 != null) goto L28;
            r1 = getScrapOrHiddenOrCachedHolderForPosition(r19, r20);
            if (r1 == null) goto L28;
            if (validateViewHolderForOffsetPosition(r1) == true) goto L27;
            if (r20 == true) goto L26;
            r1.addFlags(4);
            if (r1.isScrap() == false) goto L23;
            this.this$0.removeDetachedView(r1.itemView, false);
            r1.unScrap();
        L25:
            recycleViewHolderInternal(r1);
            goto L26
        L23:
            if (r1.wasReturnedFromScrap() == false) goto L25;
            r1.clearReturnedFromScrapFlag();
        L26:
            r1 = null;
            goto L28
        L27:
            r4 = true;
        L28:
            if (r1 != null) goto L78;
            int r5 = this.this$0.mAdapterHelper.findPositionOffset(r19);
            if (r5 < 0) goto L77;
            if (r5 >= this.this$0.mAdapter.getItemCount()) goto L77;
            int r9 = this.this$0.mAdapter.getItemViewType(r5);
            if (this.this$0.mAdapter.hasStableIds() == false) goto L38;
            r1 = getScrapOrCachedViewForId(this.this$0.mAdapter.getItemId(r5), r9, r20);
            if (r1 == null) goto L38;
            r1.mPosition = r5;
            r4 = true;
        L38:
            if (r1 != null) goto L53;
            ViewCacheExtension r0 = this.mViewCacheExtension;
            if (r0 == null) goto L53;
            View r2 = r0.getViewForPositionAndType(this, r19, r9);
            if (r2 == null) goto L53;
            r1 = this.this$0.getChildViewHolder(r2);
            if (r1 == null) goto L51;
            if (r1.shouldIgnore() == false) goto L53;
            throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + this.this$0.exceptionLabel());
        L51:
            throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + this.this$0.exceptionLabel());
        L53:
            if (r1 == null) goto L55;
        L62:
            if (r1 != null) goto L78;
            long r16 = this.this$0.getNanoTime();
            if (r21 != Long.MAX_VALUE) goto L66;
        L68:
            r1 = this.this$0.mAdapter.createViewHolder(this.this$0, r9);
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L73;
            RecyclerView r3 = RecyclerView.findNestedRecyclerView(r1.itemView);
            if (r3 == null) goto L73;
            r1.mNestedRecyclerView = new WeakReference(r3);
        L73:
            this.mRecyclerPool.factorInCreateTime(r9, this.this$0.getNanoTime() - r16);
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L78;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(RecyclerView.TAG, "tryGetViewHolderForPositionByDeadline created new ViewHolder");
            goto L78
        L66:
            if (this.mRecyclerPool.willCreateInTime(r9, r16, r21) == true) goto L68;
            return null;
        L55:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L57;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(RecyclerView.TAG, "tryGetViewHolderForPositionByDeadline(" + r19 + ") fetching from shared pool");
        L57:
            r1 = getRecycledViewPool().getRecycledView(r9);
            if (r1 == null) goto L62;
            r1.resetInternal();
            if (RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST == false) goto L62;
            invalidateDisplayListInt(r1);
        L77:
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + r19 + "(offset:" + r5 + ").state:" + this.this$0.mState.getItemCount() + this.this$0.exceptionLabel());
        L78:
            ViewHolder r10 = r1;
            boolean r11 = r4;
            if (r11 == false) goto L88;
            if (this.this$0.mState.isPreLayout() == true) goto L88;
            if (r10.hasAnyOfTheFlags(8192) == false) goto L88;
            r10.setFlags(0, 8192);
            if (this.this$0.mState.mRunSimpleAnimations == false) goto L88;
            this.this$0.recordAnimationInfoIfBouncedHiddenView(r10, this.this$0.mItemAnimator.recordPreLayoutInformation(this.this$0.mState, r10, ItemAnimator.buildAdapterChangeFlagsForAnimations(r10) | 4096, r10.getUnmodifiedPayloads()));
        L88:
            if (this.this$0.mState.isPreLayout() == false) goto L93;
            if (r10.isBound() == false) goto L93;
            r10.mPreLayoutPosition = r19;
        L99:
            boolean r6 = false;
        L108:
            ViewGroup.LayoutParams r8 = r10.itemView.getLayoutParams();
            if (r8 != null) goto L112;
            LayoutParams r12 = (LayoutParams) this.this$0.generateDefaultLayoutParams();
            r10.itemView.setLayoutParams(r12);
        L115:
            r12.mViewHolder = r10;
            if (r11 == false) goto L119;
            if (r6 == false) goto L119;
        L120:
            r12.mPendingInvalidate = r7;
            return r10;
        L119:
            r7 = false;
            goto L120
        L112:
            if (this.this$0.checkLayoutParams(r8) == true) goto L114;
            r12 = (LayoutParams) this.this$0.generateLayoutParams(r8);
            r10.itemView.setLayoutParams(r12);
            goto L115
        L114:
            r12 = (LayoutParams) r8;
        L93:
            if (r10.isBound() == false) goto L101;
            if (r10.needsUpdate() == true) goto L101;
            if (r10.isInvalid() == false) goto L99;
        L101:
            if (RecyclerView.sDebugAssertionsEnabled == true) goto L103;
        L107:
            r6 = tryBindViewHolderByDeadline(r10, this.this$0.mAdapterHelper.findPositionOffset(r19), r19, r21);
            goto L108
        L103:
            if (r10.isRemoved() == false) goto L107;
            throw new IllegalStateException("Removed holder should be bound and it should come here only in pre-layout. Holder: " + r10 + this.this$0.exceptionLabel());
        L12:
            r4 = false;
            goto L13
        L11:
            r1 = null;
        L123:
            throw new IndexOutOfBoundsException("Invalid item position " + r19 + "(" + r19 + "). Item count:" + this.this$0.mState.getItemCount() + this.this$0.exceptionLabel());
        }

        private void attachAccessibilityDelegateOnBind(ViewHolder r2) {
            if (this.this$0.isAccessibilityEnabled() == false) goto L15;
            View r3 = r2.itemView;
            if (ViewCompat.getImportantForAccessibility(r3) != 0) goto L8;
            ViewCompat.setImportantForAccessibility(r3, 1);
        L8:
            if (this.this$0.mAccessibilityDelegate != null) goto L10;
            return;
        L10:
            AccessibilityDelegateCompat r1 = this.this$0.mAccessibilityDelegate.getItemDelegate();
            if ((r1 instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) == false) goto L13;
            ((RecyclerViewAccessibilityDelegate.ItemDelegate) r1).saveOriginalDelegate(r3);
        L13:
            ViewCompat.setAccessibilityDelegate(r3, r1);
            return;
        }

        private void invalidateDisplayListInt(ViewHolder r2) {
            if ((r2.itemView instanceof ViewGroup) == false) goto L6;
            invalidateDisplayListInt((ViewGroup) r2.itemView, false);
            return;
        }

        private void invalidateDisplayListInt(ViewGroup r5, boolean r6) {
            int r0 = r5.getChildCount() - 1;
        L3:
            if (r0 < 0) goto L8;
            View r2 = r5.getChildAt(r0);
            if ((r2 instanceof ViewGroup) == false) goto L7;
            invalidateDisplayListInt((ViewGroup) r2, true);
        L7:
            r0 = r0 - 1;
            goto L3
        L8:
            if (r6 == true) goto L11;
            return;
        L11:
            if (r5.getVisibility() != 4) goto L13;
            r5.setVisibility(0);
            r5.setVisibility(4);
            return;
        L13:
            int r4 = r5.getVisibility();
            r5.setVisibility(4);
            r5.setVisibility(r4);
        }

        public void recycleView(View r4) {
            ViewHolder r0 = RecyclerView.getChildViewHolderInt(r4);
            if (r0.isTmpDetached() == false) goto L6;
            this.this$0.removeDetachedView(r4, false);
        L6:
            if (r0.isScrap() == false) goto L9;
            r0.unScrap();
        L11:
            recycleViewHolderInternal(r0);
            if (this.this$0.mItemAnimator != null) goto L14;
            return;
        L14:
            if (r0.isRecyclable() == true) goto L18;
            this.this$0.mItemAnimator.endAnimation(r0);
            return;
        L18:
            return;
        L9:
            if (r0.wasReturnedFromScrap() == false) goto L11;
            r0.clearReturnedFromScrapFlag();
            goto L11
        }

        void recycleAndClearCachedViews() {
            int r0 = this.mCachedViews.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            recycleCachedViewAt(r0);
            r0 = r0 - 1;
            goto L3
        L5:
            this.mCachedViews.clear();
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L10;
            this.this$0.mPrefetchRegistry.clearPrefetchPositions();
            return;
        }

        void recycleCachedViewAt(int r5) {
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L5;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(RecyclerView.TAG, "Recycling cached view at index " + r5);
        L5:
            ViewHolder r0 = this.mCachedViews.get(r5);
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L8;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(RecyclerView.TAG, "CachedViewHolder to be recycled: " + r0);
        L8:
            addViewHolderToRecycledViewPool(r0, true);
            this.mCachedViews.remove(r5);
        }

        void recycleViewHolderInternal(ViewHolder r7) {
            boolean r1 = false;
            boolean r2 = true;
            if (r7.isScrap() == false) goto L5;
        L69:
            StringBuilder r3 = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:").append(r7.isScrap()).append(" isAttached:");
            if (r7.itemView.getParent() == null) goto L73;
            r1 = true;
        L73:
            throw new IllegalArgumentException(r3.append(r1).append(this.this$0.exceptionLabel()).toString());
        L5:
            if (r7.itemView.getParent() != null) goto L69;
            if (r7.isTmpDetached() == true) goto L68;
            if (r7.shouldIgnore() == true) goto L66;
            boolean r0 = r7.doesTransientStatePreventRecycling();
            if (this.this$0.mAdapter == null) goto L17;
            if (r0 == false) goto L17;
            if (this.this$0.mAdapter.onFailedToRecycleView(r7) == false) goto L17;
            boolean r4 = true;
        L19:
            if (RecyclerView.sDebugAssertionsEnabled == true) goto L21;
        L25:
            if (r4 == true) goto L34;
            if (r7.isRecyclable() == true) goto L34;
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L32;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(RecyclerView.TAG, "trying to recycle a non-recycleable holder. Hopefully, it will re-visit here. We are still removing it from animation lists" + this.this$0.exceptionLabel());
        L32:
            r2 = false;
        L59:
            this.this$0.mViewInfoStore.removeViewHolder(r7);
            if (r1 == true) goto L76;
            if (r2 == true) goto L77;
            if (r0 == false) goto L78;
            PoolingContainer.callPoolingContainerOnRelease(r7.itemView);
            r7.mBindingAdapter = null;
            r7.mOwnerRecyclerView = null;
            return;
        L78:
            return;
        L77:
            return;
        L76:
            return;
        L34:
            if (this.mViewCacheMax > 0) goto L36;
        L54:
            boolean r5 = false;
        L55:
            if (r5 == true) goto L57;
            addViewHolderToRecycledViewPool(r7, true);
        L58:
            r1 = r5;
            goto L59
        L57:
            r2 = false;
            goto L58
        L36:
            if (r7.hasAnyOfTheFlags(526) == true) goto L54;
            int r6 = this.mCachedViews.size();
            if (r6 < this.mViewCacheMax) goto L42;
            if (r6 <= 0) goto L42;
            recycleCachedViewAt(0);
            r6 = r6 - 1;
        L42:
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L53;
            if (r6 <= 0) goto L53;
            if (this.this$0.mPrefetchRegistry.lastPrefetchIncludedPosition(r7.mPosition) == true) goto L53;
            int r8 = r6 - 1;
        L47:
            if (r8 < 0) goto L52;
            if (this.this$0.mPrefetchRegistry.lastPrefetchIncludedPosition(this.mCachedViews.get(r8).mPosition) == false) goto L52;
            r8 = r8 - 1;
        L52:
            r6 = r8 + 1;
        L53:
            this.mCachedViews.add(r6, r7);
            r5 = true;
            goto L55
        L21:
            if (this.mCachedViews.contains(r7) == false) goto L25;
            throw new IllegalArgumentException("cached view received recycle internal? " + r7 + this.this$0.exceptionLabel());
        L17:
            r4 = false;
            goto L19
        L66:
            throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + this.this$0.exceptionLabel());
        L68:
            throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + r7 + this.this$0.exceptionLabel());
        }

        void addViewHolderToRecycledViewPool(ViewHolder r5, boolean r6) {
            RecyclerView.clearNestedRecyclerViewIfNotNested(r5);
            View r0 = r5.itemView;
            if (this.this$0.mAccessibilityDelegate == null) goto L9;
            AccessibilityDelegateCompat r1 = this.this$0.mAccessibilityDelegate.getItemDelegate();
            if ((r1 instanceof RecyclerViewAccessibilityDelegate.ItemDelegate) == false) goto L7;
            AccessibilityDelegateCompat r2 = ((RecyclerViewAccessibilityDelegate.ItemDelegate) r1).getAndRemoveOriginalDelegateForItem(r0);
        L8:
            ViewCompat.setAccessibilityDelegate(r0, r2);
            goto L9
        L7:
            r2 = null;
        L9:
            if (r6 == false) goto L11;
            dispatchViewRecycled(r5);
        L11:
            r5.mBindingAdapter = null;
            r5.mOwnerRecyclerView = null;
            getRecycledViewPool().putRecycledView(r5);
        }

        void quickRecycleScrapView(View r2) {
            ViewHolder r3 = RecyclerView.getChildViewHolderInt(r2);
            r3.mScrapContainer = null;
            r3.mInChangeScrap = false;
            r3.clearReturnedFromScrapFlag();
            recycleViewHolderInternal(r3);
        }

        void scrapView(View r3) {
            ViewHolder r4 = RecyclerView.getChildViewHolderInt(r3);
            if (r4.hasAnyOfTheFlags(12) == true) goto L14;
            if (r4.isUpdated() == false) goto L14;
            if (this.this$0.canReuseUpdatedViewHolder(r4) == true) goto L14;
            if (this.mChangedScrap != null) goto L12;
            this.mChangedScrap = new ArrayList();
        L12:
            r4.setScrapContainer(this, true);
            this.mChangedScrap.add(r4);
            return;
        L14:
            if (r4.isInvalid() == true) goto L16;
        L22:
            r4.setScrapContainer(this, false);
            this.mAttachedScrap.add(r4);
            return;
        L16:
            if (r4.isRemoved() == true) goto L22;
            if (this.this$0.mAdapter.hasStableIds() == true) goto L22;
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + this.this$0.exceptionLabel());
        }

        void unscrapView(ViewHolder r2) {
            if (r2.mInChangeScrap == false) goto L5;
            this.mChangedScrap.remove(r2);
        L6:
            r2.mScrapContainer = null;
            r2.mInChangeScrap = false;
            r2.clearReturnedFromScrapFlag();
            return;
        L5:
            this.mAttachedScrap.remove(r2);
            goto L6
        }

        int getScrapCount() {
            return this.mAttachedScrap.size();
        }

        View getScrapViewAt(int r1) {
            return this.mAttachedScrap.get(r1).itemView;
        }

        void clearScrap() {
            this.mAttachedScrap.clear();
            ArrayList<ViewHolder> r1 = this.mChangedScrap;
            if (r1 == null) goto L6;
            r1.clear();
            return;
        }

        ViewHolder getChangedScrapViewForPosition(int r10) {
            ArrayList<ViewHolder> r0 = this.mChangedScrap;
            if (r0 == null) goto L32;
            int r1 = r0.size();
            if (r1 == 0) goto L32;
            int r2 = 0;
            int r3 = 0;
        L9:
            if (r3 >= r1) goto L18;
            ViewHolder r5 = this.mChangedScrap.get(r3);
            if (r5.wasReturnedFromScrap() == true) goto L16;
            if (r5.getLayoutPosition() != r10) goto L16;
            r5.addFlags(32);
            return r5;
        L16:
            r3 = r3 + 1;
            goto L9
        L18:
            if (this.this$0.mAdapter.hasStableIds() == false) goto L32;
            int r11 = this.this$0.mAdapterHelper.findPositionOffset(r10);
            if (r11 <= 0) goto L32;
            if (r11 >= this.this$0.mAdapter.getItemCount()) goto L32;
            long r6 = this.this$0.mAdapter.getItemId(r11);
        L24:
            if (r2 >= r1) goto L32;
            ViewHolder r12 = this.mChangedScrap.get(r2);
            if (r12.wasReturnedFromScrap() == true) goto L31;
            if (r12.getItemId() != r6) goto L31;
            r12.addFlags(32);
            return r12;
        L31:
            r2 = r2 + 1;
        L32:
            return null;
        }

        ViewHolder getScrapOrHiddenOrCachedHolderForPosition(int r6, boolean r7) {
            int r0 = this.mAttachedScrap.size();
            int r1 = 0;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L17;
            ViewHolder r3 = this.mAttachedScrap.get(r2);
            if (r3.wasReturnedFromScrap() == true) goto L16;
            if (r3.getLayoutPosition() != r6) goto L16;
            if (r3.isInvalid() == true) goto L16;
            if (this.this$0.mState.mInPreLayout == true) goto L14;
            if (r3.isRemoved() == true) goto L16;
        L14:
            r3.addFlags(32);
            return r3;
        L16:
            r2 = r2 + 1;
            goto L3
        L17:
            if (r7 == true) goto L26;
            View r4 = this.this$0.mChildHelper.findHiddenNonRemovedView(r6);
            if (r4 == null) goto L26;
            ViewHolder r8 = RecyclerView.getChildViewHolderInt(r4);
            this.this$0.mChildHelper.unhide(r4);
            int r9 = this.this$0.mChildHelper.indexOfChild(r4);
            if (r9 == (-1)) goto L25;
            this.this$0.mChildHelper.detachViewFromParent(r9);
            scrapView(r4);
            r8.addFlags(8224);
            return r8;
        L25:
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + r8 + this.this$0.exceptionLabel());
        L26:
            int r5 = this.mCachedViews.size();
        L27:
            if (r1 >= r5) goto L41;
            ViewHolder r10 = this.mCachedViews.get(r1);
            if (r10.isInvalid() == true) goto L40;
            if (r10.getLayoutPosition() != r6) goto L40;
            if (r10.isAttachedToTransitionOverlay() == true) goto L40;
            if (r7 == true) goto L37;
            this.mCachedViews.remove(r1);
        L37:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L39;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(RecyclerView.TAG, "getScrapOrHiddenOrCachedHolderForPosition(" + r6 + ") found match in cache: " + r10);
        L39:
            return r10;
        L40:
            r1 = r1 + 1;
            goto L27
        L41:
            return null;
        }

        ViewHolder getScrapOrCachedViewForId(long r6, int r8, boolean r9) {
            int r0 = this.mAttachedScrap.size() - 1;
        L3:
            if (r0 < 0) goto L19;
            ViewHolder r1 = this.mAttachedScrap.get(r0);
            if (r1.getItemId() != r6) goto L18;
            if (r1.wasReturnedFromScrap() == true) goto L18;
            if (r8 == r1.getItemViewType()) goto L10;
            if (r9 == true) goto L18;
            this.mAttachedScrap.remove(r0);
            this.this$0.removeDetachedView(r1.itemView, false);
            quickRecycleScrapView(r1.itemView);
            goto L18
        L10:
            r1.addFlags(32);
            if (r1.isRemoved() == true) goto L13;
        L15:
            return r1;
        L13:
            if (this.this$0.mState.isPreLayout() == true) goto L15;
            r1.setFlags(2, 14);
        L18:
            r0 = r0 - 1;
            goto L3
        L19:
            int r2 = this.mCachedViews.size();
        L20:
            r2 = r2 - 1;
            if (r2 < 0) goto L35;
            ViewHolder r3 = this.mCachedViews.get(r2);
            if (r3.getItemId() != r6) goto L20;
            if (r3.isAttachedToTransitionOverlay() == true) goto L20;
            if (r8 == r3.getItemViewType()) goto L28;
            if (r9 == true) goto L20;
            recycleCachedViewAt(r2);
            return null;
        L28:
            if (r9 == true) goto L30;
            this.mCachedViews.remove(r2);
        L30:
            return r3;
        L35:
            return null;
        }

        void dispatchViewRecycled(ViewHolder r4) {
            if (this.this$0.mRecyclerListener == null) goto L5;
            this.this$0.mRecyclerListener.onViewRecycled(r4);
        L5:
            int r0 = this.this$0.mRecyclerListeners.size();
            int r1 = 0;
        L6:
            if (r1 >= r0) goto L9;
            this.this$0.mRecyclerListeners.get(r1).onViewRecycled(r4);
            r1 = r1 + 1;
            goto L6
        L9:
            if (this.this$0.mAdapter == null) goto L12;
            this.this$0.mAdapter.onViewRecycled(r4);
        L12:
            if (this.this$0.mState == null) goto L15;
            this.this$0.mViewInfoStore.removeViewHolder(r4);
        L15:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L19;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(RecyclerView.TAG, "dispatchViewRecycled: " + r4);
            return;
        }

        void onAdapterChanged(Adapter<?> r2, Adapter<?> r3, boolean r4) {
            clear();
            poolingContainerDetach(r2, true);
            getRecycledViewPool().onAdapterChanged(r2, r3, r4);
            maybeSendPoolingContainerAttach();
        }

        void offsetPositionRecordsForMove(int r10, int r11) {
            if (r10 >= r11) goto L4;
            int r0 = -1;
            int r1 = r10;
            int r2 = r11;
        L5:
            int r3 = this.mCachedViews.size();
            int r5 = 0;
        L6:
            if (r5 >= r3) goto L22;
            ViewHolder r6 = this.mCachedViews.get(r5);
            if (r6 == null) goto L21;
            if (r6.mPosition < r1) goto L21;
            if (r6.mPosition > r2) goto L21;
            if (r6.mPosition != r10) goto L17;
            r6.offsetPosition(r11 - r10, false);
        L19:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L21;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(RecyclerView.TAG, "offsetPositionRecordsForMove cached child " + r5 + " holder " + r6);
            goto L21
        L17:
            r6.offsetPosition(r0, false);
        L21:
            r5 = r5 + 1;
            goto L6
        L22:
            return;
        L4:
            r0 = 1;
            r2 = r10;
            r1 = r11;
            goto L5
        }

        void offsetPositionRecordsForInsert(int r7, int r8) {
            int r0 = this.mCachedViews.size();
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L13;
            ViewHolder r3 = this.mCachedViews.get(r2);
            if (r3 == null) goto L12;
            if (r3.mPosition < r7) goto L12;
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L11;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(RecyclerView.TAG, "offsetPositionRecordsForInsert cached " + r2 + " holder " + r3 + " now at position " + (r3.mPosition + r8));
        L11:
            r3.offsetPosition(r8, false);
        L12:
            r2 = r2 + 1;
            goto L3
        }

        void offsetPositionRecordsForRemove(int r6, int r7, boolean r8) {
            int r0 = r6 + r7;
            int r1 = this.mCachedViews.size() - 1;
        L3:
            if (r1 < 0) goto L16;
            ViewHolder r2 = this.mCachedViews.get(r1);
            if (r2 == null) goto L15;
            if (r2.mPosition < r0) goto L13;
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L11;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(RecyclerView.TAG, "offsetPositionRecordsForRemove cached " + r1 + " holder " + r2 + " now at position " + (r2.mPosition - r7));
        L11:
            r2.offsetPosition(-r7, r8);
            goto L15
        L13:
            if (r2.mPosition < r6) goto L15;
            r2.addFlags(8);
            recycleCachedViewAt(r1);
        L15:
            r1 = r1 - 1;
            goto L3
        }

        void setViewCacheExtension(ViewCacheExtension r1) {
            this.mViewCacheExtension = r1;
        }

        void setRecycledViewPool(RecycledViewPool r2) {
            poolingContainerDetach(this.this$0.mAdapter);
            RecycledViewPool r0 = this.mRecyclerPool;
            if (r0 == null) goto L5;
            r0.detach();
        L5:
            this.mRecyclerPool = r2;
            if (r2 != null) goto L8;
        L10:
            maybeSendPoolingContainerAttach();
            return;
        L8:
            if (this.this$0.getAdapter() == null) goto L10;
            this.mRecyclerPool.attach();
            goto L10
        }

        private void maybeSendPoolingContainerAttach() {
            if (this.mRecyclerPool != null) goto L5;
            return;
        L5:
            if (this.this$0.mAdapter != null) goto L7;
            return;
        L7:
            if (this.this$0.isAttachedToWindow() == false) goto L12;
            this.mRecyclerPool.attachForPoolingContainer(this.this$0.mAdapter);
            return;
        }

        private void poolingContainerDetach(Adapter<?> r2) {
            poolingContainerDetach(r2, false);
        }

        private void poolingContainerDetach(Adapter<?> r1, boolean r2) {
            RecycledViewPool r0 = this.mRecyclerPool;
            if (r0 == null) goto L6;
            r0.detachForPoolingContainer(r1, r2);
            return;
        }

        void onAttachedToWindow() {
            maybeSendPoolingContainerAttach();
        }

        void onDetachedFromWindow() {
            int r0 = 0;
        L4:
            if (r0 >= this.mCachedViews.size()) goto L6;
            PoolingContainer.callPoolingContainerOnRelease(this.mCachedViews.get(r0).itemView);
            r0 = r0 + 1;
            goto L4
        L6:
            poolingContainerDetach(this.this$0.mAdapter);
        }

        RecycledViewPool getRecycledViewPool() {
            if (this.mRecyclerPool != null) goto L6;
            this.mRecyclerPool = new RecycledViewPool();
            maybeSendPoolingContainerAttach();
        L6:
            return this.mRecyclerPool;
        }

        void viewRangeUpdate(int r4, int r5) {
            int r6 = r5 + r4;
            int r0 = this.mCachedViews.size() - 1;
        L3:
            if (r0 < 0) goto L12;
            ViewHolder r1 = this.mCachedViews.get(r0);
            if (r1 == null) goto L11;
            int r2 = r1.mPosition;
            if (r2 < r4) goto L11;
            if (r2 >= r6) goto L11;
            r1.addFlags(2);
            recycleCachedViewAt(r0);
        L11:
            r0 = r0 - 1;
            goto L3
        }

        void markKnownViewsInvalid() {
            int r0 = this.mCachedViews.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L9;
            ViewHolder r2 = this.mCachedViews.get(r1);
            if (r2 == null) goto L7;
            r2.addFlags(6);
            r2.addChangePayload(null);
        L7:
            r1 = r1 + 1;
            goto L3
        L9:
            if (this.this$0.mAdapter != null) goto L11;
        L12:
            recycleAndClearCachedViews();
            return;
        L11:
            if (this.this$0.mAdapter.hasStableIds() == false) goto L12;
        }

        void clearOldPositions() {
            int r0 = this.mCachedViews.size();
            int r1 = 0;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L5;
            this.mCachedViews.get(r2).clearOldPosition();
            r2 = r2 + 1;
            goto L3
        L5:
            int r3 = this.mAttachedScrap.size();
            int r4 = 0;
        L6:
            if (r4 >= r3) goto L8;
            this.mAttachedScrap.get(r4).clearOldPosition();
            r4 = r4 + 1;
            goto L6
        L8:
            ArrayList<ViewHolder> r5 = this.mChangedScrap;
            if (r5 == null) goto L13;
            int r6 = r5.size();
        L11:
            if (r1 >= r6) goto L17;
            this.mChangedScrap.get(r1).clearOldPosition();
            r1 = r1 + 1;
            goto L11
        L17:
            return;
        }

        void markItemDecorInsetsDirty() {
            int r0 = this.mCachedViews.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L8;
            LayoutParams r2 = (LayoutParams) this.mCachedViews.get(r1).itemView.getLayoutParams();
            if (r2 == null) goto L7;
            r2.mInsetsDirty = true;
        L7:
            r1 = r1 + 1;
            goto L3
        }
    }

    public interface RecyclerListener {
        void onViewRecycled(ViewHolder r1);
    }

    private class RecyclerViewDataObserver extends AdapterDataObserver {
        final /* synthetic */ RecyclerView this$0;

        RecyclerViewDataObserver(RecyclerView r1) {
            this.this$0 = r1;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            this.this$0.assertNotInLayoutOrScroll(null);
            this.this$0.mState.mStructureChanged = true;
            this.this$0.processDataSetCompletelyChanged(true);
            if (this.this$0.mAdapterHelper.hasPendingUpdates() == true) goto L6;
            this.this$0.requestLayout();
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int r3, int r4, Object r5) {
            this.this$0.assertNotInLayoutOrScroll(null);
            if (this.this$0.mAdapterHelper.onItemRangeChanged(r3, r4, r5) == false) goto L6;
            triggerUpdateProcessor();
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int r3, int r4) {
            this.this$0.assertNotInLayoutOrScroll(null);
            if (this.this$0.mAdapterHelper.onItemRangeInserted(r3, r4) == false) goto L6;
            triggerUpdateProcessor();
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int r3, int r4) {
            this.this$0.assertNotInLayoutOrScroll(null);
            if (this.this$0.mAdapterHelper.onItemRangeRemoved(r3, r4) == false) goto L6;
            triggerUpdateProcessor();
            return;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int r3, int r4, int r5) {
            this.this$0.assertNotInLayoutOrScroll(null);
            if (this.this$0.mAdapterHelper.onItemRangeMoved(r3, r4, r5) == false) goto L6;
            triggerUpdateProcessor();
            return;
        }

        void triggerUpdateProcessor() {
            if (RecyclerView.POST_UPDATES_ON_ANIMATION == true) goto L5;
        L9:
            this.this$0.mAdapterUpdateDuringMeasure = true;
            this.this$0.requestLayout();
            return;
        L5:
            if (this.this$0.mHasFixedSize == false) goto L9;
            if (this.this$0.mIsAttached == false) goto L9;
            RecyclerView r2 = this.this$0;
            ViewCompat.postOnAnimation(r2, r2.mUpdateChildViewsRunnable);
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.AdapterDataObserver
        public void onStateRestorationPolicyChanged() {
            if (this.this$0.mPendingSavedState != null) goto L5;
            return;
        L5:
            Adapter r0 = this.this$0.mAdapter;
            if (r0 != null) goto L8;
            return;
        L8:
            if (r0.canRestoreState() == false) goto L12;
            this.this$0.requestLayout();
            return;
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        Parcelable mLayoutState;

        SavedState(Parcel r1, ClassLoader r2) {
            super(r1, r2);
            if (r2 != null) goto L6;
            r2 = LayoutManager.class.getClassLoader();
        L6:
            this.mLayoutState = r1.readParcelable(r2);
        }

        SavedState(Parcelable r1) {
            super(r1);
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

    public static class SimpleOnItemTouchListener implements OnItemTouchListener {
        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(RecyclerView r1, MotionEvent r2) {
            return false;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean r1) {
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(RecyclerView r1, MotionEvent r2) {
        }

        public SimpleOnItemTouchListener() {
        }
    }

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

            public Action(int r3, int r4) {
                this(r3, r4, Integer.MIN_VALUE, null);
            }

            public Action(int r2, int r3, int r4) {
                this(r2, r3, r4, null);
            }

            public Action(int r2, int r3, int r4, Interpolator r5) {
                this.mJumpToPosition = -1;
                this.mChanged = false;
                this.mConsecutiveUpdates = 0;
                this.mDx = r2;
                this.mDy = r3;
                this.mDuration = r4;
                this.mInterpolator = r5;
            }

            public void jumpTo(int r1) {
                this.mJumpToPosition = r1;
            }

            boolean hasJumpTarget() {
                if (this.mJumpToPosition < 0) goto L5;
                return true;
            L5:
                return false;
            }

            void runIfNecessary(RecyclerView r6) {
                int r0 = this.mJumpToPosition;
                if (r0 < 0) goto L7;
                this.mJumpToPosition = -1;
                r6.jumpToPositionForSmoothScroller(r0);
                this.mChanged = false;
                return;
            L7:
                if (this.mChanged == false) goto L12;
                validate();
                r6.mViewFlinger.smoothScrollBy(this.mDx, this.mDy, this.mDuration, this.mInterpolator);
                int r7 = this.mConsecutiveUpdates + 1;
                this.mConsecutiveUpdates = r7;
                if (r7 <= 10) goto L11;
                GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(RecyclerView.TAG, "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
            L11:
                this.mChanged = false;
                return;
            L12:
                this.mConsecutiveUpdates = 0;
            }

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

            public int getDx() {
                return this.mDx;
            }

            public void setDx(int r2) {
                this.mChanged = true;
                this.mDx = r2;
            }

            public int getDy() {
                return this.mDy;
            }

            public void setDy(int r2) {
                this.mChanged = true;
                this.mDy = r2;
            }

            public int getDuration() {
                return this.mDuration;
            }

            public void setDuration(int r2) {
                this.mChanged = true;
                this.mDuration = r2;
            }

            public Interpolator getInterpolator() {
                return this.mInterpolator;
            }

            public void setInterpolator(Interpolator r2) {
                this.mChanged = true;
                this.mInterpolator = r2;
            }

            public void update(int r1, int r2, int r3, Interpolator r4) {
                this.mDx = r1;
                this.mDy = r2;
                this.mDuration = r3;
                this.mInterpolator = r4;
                this.mChanged = true;
            }
        }

        public interface ScrollVectorProvider {
            PointF computeScrollVectorForPosition(int r1);
        }

        protected abstract void onSeekTargetStep(int r1, int r2, State r3, Action r4);

        protected abstract void onStart();

        protected abstract void onStop();

        protected abstract void onTargetFound(View r1, State r2, Action r3);

        public SmoothScroller() {
            this.mTargetPosition = -1;
            this.mRecyclingAction = new Action(0, 0);
        }

        void start(RecyclerView r3, LayoutManager r4) {
            r3.mViewFlinger.stop();
            if (this.mStarted == false) goto L5;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(RecyclerView.TAG, "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
        L5:
            this.mRecyclerView = r3;
            this.mLayoutManager = r4;
            if (this.mTargetPosition == (-1)) goto L10;
            r3.mState.mTargetPosition = this.mTargetPosition;
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

        public void setTargetPosition(int r1) {
            this.mTargetPosition = r1;
        }

        public PointF computeScrollVectorForPosition(int r2) {
            Object r1 = getLayoutManager();
            if ((r1 instanceof ScrollVectorProvider) == true) goto L5;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(RecyclerView.TAG, "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + ScrollVectorProvider.class.getCanonicalName());
            return null;
        L5:
            return ((ScrollVectorProvider) r1).computeScrollVectorForPosition(r2);
        }

        public LayoutManager getLayoutManager() {
            return this.mLayoutManager;
        }

        protected final void stop() {
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

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        void onAnimation(int r6, int r7) {
            RecyclerView r0 = this.mRecyclerView;
            if (this.mTargetPosition == (-1)) goto L5;
            if (r0 == null) goto L5;
        L7:
            if (this.mPendingInitialRun == true) goto L9;
        L19:
            this.mPendingInitialRun = false;
            View r1 = this.mTargetView;
            if (r1 == null) goto L26;
            if (getChildPosition(r1) != this.mTargetPosition) goto L24;
            onTargetFound(this.mTargetView, r0.mState, this.mRecyclingAction);
            this.mRecyclingAction.runIfNecessary(r0);
            stop();
            goto L26
        L24:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(RecyclerView.TAG, "Passed over target position while smooth scrolling.");
            this.mTargetView = null;
        L26:
            if (this.mRunning == false) goto L33;
            onSeekTargetStep(r6, r7, r0.mState, this.mRecyclingAction);
            boolean r8 = this.mRecyclingAction.hasJumpTarget();
            this.mRecyclingAction.runIfNecessary(r0);
            if (r8 == true) goto L30;
            return;
        L30:
            if (this.mRunning == false) goto L35;
            this.mPendingInitialRun = true;
            r0.mViewFlinger.postOnAnimation();
            return;
        L35:
            return;
        L33:
            return;
        L9:
            if (this.mTargetView != null) goto L19;
            if (this.mLayoutManager == null) goto L19;
            PointF r2 = computeScrollVectorForPosition(this.mTargetPosition);
            if (r2 == null) goto L19;
            if (r2.x == 0.0f) goto L17;
        L18:
            r0.scrollStep((int) Math.signum(r2.x), (int) Math.signum(r2.y), null);
            goto L19
        L17:
            if (r2.y == 0.0f) goto L19;
        L5:
            stop();
            goto L7
        }

        public int getChildPosition(View r1) {
            return this.mRecyclerView.getChildLayoutPosition(r1);
        }

        public int getChildCount() {
            return this.mRecyclerView.mLayout.getChildCount();
        }

        public View findViewByPosition(int r1) {
            return this.mRecyclerView.mLayout.findViewByPosition(r1);
        }

        @Deprecated
        public void instantScrollToPosition(int r1) {
            this.mRecyclerView.scrollToPosition(r1);
        }

        protected void onChildAttachedToWindow(View r3) {
            if (getChildPosition(r3) != getTargetPosition()) goto L8;
            this.mTargetView = r3;
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L9;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(RecyclerView.TAG, "smooth scroll target view has been attached");
            return;
        L9:
            return;
        }

        protected void normalize(PointF r3) {
            float r2 = (float) Math.sqrt((r3.x * r3.x) + (r3.y * r3.y));
            r3.x /= r2;
            r3.y /= r2;
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

        void assertLayoutStep(int r4) {
            if ((this.mLayoutStep & r4) == 0) goto L6;
            return;
        L6:
            throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(r4) + " but it is " + Integer.toBinaryString(this.mLayoutStep));
        }

        void prepareForNestedPrefetch(Adapter r2) {
            this.mLayoutStep = 1;
            this.mItemCount = r2.getItemCount();
            this.mInPreLayout = false;
            this.mTrackOldChangeHolders = false;
            this.mIsMeasuring = false;
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

        public void remove(int r1) {
            SparseArray<Object> r0 = this.mData;
            if (r0 != null) goto L5;
            return;
        L5:
            r0.remove(r1);
        }

        public <T> T get(int r1) {
            SparseArray<Object> r0 = this.mData;
            if (r0 != null) goto L7;
            return null;
        L7:
            return (T) r0.get(r1);
        }

        public void put(int r2, Object r3) {
            if (this.mData != null) goto L5;
            this.mData = new SparseArray();
        L5:
            this.mData.put(r2, r3);
        }

        public int getTargetScrollPosition() {
            return this.mTargetPosition;
        }

        public boolean hasTargetScrollPosition() {
            if (this.mTargetPosition == (-1)) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean didStructureChange() {
            return this.mStructureChanged;
        }

        public int getItemCount() {
            if (this.mInPreLayout == false) goto L6;
            return this.mPreviousLayoutItemCount - this.mDeletedInvisibleItemCountSincePreviousLayout;
        L6:
            return this.mItemCount;
        }

        public int getRemainingScrollHorizontal() {
            return this.mRemainingScrollHorizontal;
        }

        public int getRemainingScrollVertical() {
            return this.mRemainingScrollVertical;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.mTargetPosition + ", mData=" + this.mData + ", mItemCount=" + this.mItemCount + ", mIsMeasuring=" + this.mIsMeasuring + ", mPreviousLayoutItemCount=" + this.mPreviousLayoutItemCount + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.mDeletedInvisibleItemCountSincePreviousLayout + ", mStructureChanged=" + this.mStructureChanged + ", mInPreLayout=" + this.mInPreLayout + ", mRunSimpleAnimations=" + this.mRunSimpleAnimations + ", mRunPredictiveAnimations=" + this.mRunPredictiveAnimations + '}';
        }
    }

    public static abstract class ViewCacheExtension {
        public abstract View getViewForPositionAndType(Recycler r1, int r2, int r3);

        public ViewCacheExtension() {
        }
    }

    class ViewFlinger implements Runnable {
        private boolean mEatRunOnAnimationRequest;
        Interpolator mInterpolator;
        private int mLastFlingX;
        private int mLastFlingY;
        OverScrollerAdapter mOverScroller;
        private boolean mReSchedulePostAnimationCallback;
        final /* synthetic */ RecyclerView this$0;

        ViewFlinger(RecyclerView r3) {
            this.this$0 = r3;
            this.mInterpolator = RecyclerView.sQuinticInterpolator;
            this.mEatRunOnAnimationRequest = false;
            this.mReSchedulePostAnimationCallback = false;
            this.mOverScroller = new OverScrollerAdapter(r3.getContext(), RecyclerView.sQuinticInterpolator);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.mLayout != null) goto L6;
            stop();
            return;
        L6:
            this.mReSchedulePostAnimationCallback = false;
            this.mEatRunOnAnimationRequest = true;
            this.this$0.consumePendingUpdateOperations();
            OverScrollerAdapter r3 = this.mOverScroller;
            if (r3.computeScrollOffset() == false) goto L82;
            int r4 = r3.getCurrX();
            int r5 = r3.getCurrY();
            int r6 = r4 - this.mLastFlingX;
            int r7 = r5 - this.mLastFlingY;
            this.mLastFlingX = r4;
            this.mLastFlingY = r5;
            int r8 = this.this$0.consumeFlingInHorizontalStretch(r6);
            int r9 = this.this$0.consumeFlingInVerticalStretch(r7);
            this.this$0.mReusableIntPair[0] = 0;
            this.this$0.mReusableIntPair[1] = 0;
            RecyclerView r10 = this.this$0;
            if (r10.dispatchNestedPreScroll(r8, r9, r10.mReusableIntPair, null, 1) == false) goto L12;
            r8 = r8 - this.this$0.mReusableIntPair[0];
            r9 = r9 - this.this$0.mReusableIntPair[1];
        L12:
            if (this.this$0.mAdapter == null) goto L26;
            this.this$0.mReusableIntPair[0] = 0;
            this.this$0.mReusableIntPair[1] = 0;
            RecyclerView r11 = this.this$0;
            r11.scrollStep(r8, r9, r11.mReusableIntPair);
            int r12 = this.this$0.mReusableIntPair[0];
            int r13 = this.this$0.mReusableIntPair[1];
            r8 = r8 - r12;
            r9 = r9 - r13;
            SmoothScroller r14 = this.this$0.mLayout.mSmoothScroller;
            if (r14 == null) goto L28;
            if (r14.isPendingInitialRun() == true) goto L28;
            if (r14.isRunning() == false) goto L28;
            int r15 = this.this$0.mState.getItemCount();
            if (r15 != 0) goto L23;
            r14.stop();
            goto L28
        L23:
            if (r14.getTargetPosition() < r15) goto L25;
            r14.setTargetPosition(r15 - 1);
            r14.onAnimation(r12, r13);
            goto L28
        L25:
            r14.onAnimation(r12, r13);
        L28:
            if (this.this$0.mItemDecorations.isEmpty() == true) goto L30;
            this.this$0.invalidate();
        L30:
            this.this$0.mReusableIntPair[0] = 0;
            this.this$0.mReusableIntPair[1] = 0;
            RecyclerView r16 = this.this$0;
            r16.dispatchNestedScroll(r12, r13, r8, r9, null, 1, r16.mReusableIntPair);
            int r17 = r8 - this.this$0.mReusableIntPair[0];
            int r18 = r9 - this.this$0.mReusableIntPair[1];
            if (r12 != 0) goto L33;
            if (r13 != 0) goto L33;
        L35:
            if (RecyclerView.access$200(this.this$0) == true) goto L38;
            this.this$0.invalidate();
        L38:
            if (r3.getCurrX() != r3.getFinalX()) goto L40;
            boolean r19 = true;
        L42:
            if (r3.getCurrY() != r3.getFinalY()) goto L44;
            boolean r20 = true;
        L46:
            if (r3.isFinished() == true) goto L53;
            if (r19 == true) goto L49;
            if (r17 != 0) goto L49;
        L52:
            boolean r21 = false;
        L54:
            SmoothScroller r22 = this.this$0.mLayout.mSmoothScroller;
            if (r22 != null) goto L57;
        L59:
            boolean r23 = false;
        L60:
            if (r23 == true) goto L79;
            if (r21 == false) goto L79;
            if (this.this$0.getOverScrollMode() == 2) goto L77;
            int r24 = (int) r3.getCurrVelocity();
            if (r17 >= 0) goto L67;
            int r25 = r24;
        L70:
            if (r18 < 0) goto L75;
            if (r18 <= 0) goto L74;
            r24 = -r24;
            goto L75
        L74:
            r24 = 0;
        L75:
            this.this$0.absorbGlows(r25, r24);
            goto L77
        L67:
            if (r17 <= 0) goto L69;
            r25 = -r24;
            goto L70
        L69:
            r25 = 0;
        L77:
            if (RecyclerView.ALLOW_THREAD_GAP_WORK == false) goto L82;
            this.this$0.mPrefetchRegistry.clearPrefetchPositions();
        L79:
            postOnAnimation();
            if (this.this$0.mGapWorker == null) goto L82;
            this.this$0.mGapWorker.postFromTraversal(this.this$0, r12, r13);
            goto L82
        L57:
            if (r22.isPendingInitialRun() == false) goto L59;
            r23 = true;
        L49:
            if (r20 == true) goto L53;
            if (r18 == 0) goto L52;
        L53:
            r21 = true;
            goto L54
        L44:
            r20 = false;
            goto L46
        L40:
            r19 = false;
        L33:
            this.this$0.dispatchOnScrolled(r12, r13);
            goto L35
        L26:
            r12 = 0;
            r13 = 0;
        L82:
            SmoothScroller r26 = this.this$0.mLayout.mSmoothScroller;
            if (r26 != null) goto L85;
        L87:
            this.mEatRunOnAnimationRequest = false;
            if (this.mReSchedulePostAnimationCallback == false) goto L90;
            internalPostOnAnimation();
            return;
        L90:
            this.this$0.setScrollState(0);
            this.this$0.stopNestedScroll(1);
            return;
        L85:
            if (r26.isPendingInitialRun() == false) goto L87;
            r26.onAnimation(0, 0);
            goto L87
        }

        void postOnAnimation() {
            if (this.mEatRunOnAnimationRequest == false) goto L5;
            this.mReSchedulePostAnimationCallback = true;
            return;
        L5:
            internalPostOnAnimation();
        }

        private void internalPostOnAnimation() {
            this.this$0.removeCallbacks(this);
            ViewCompat.postOnAnimation(this.this$0, this);
        }

        public void fling(int r13, int r14) {
            this.this$0.setScrollState(2);
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            if (this.mInterpolator == RecyclerView.sQuinticInterpolator) goto L5;
            this.mInterpolator = RecyclerView.sQuinticInterpolator;
            this.mOverScroller = new OverScrollerAdapter(this.this$0.getContext(), RecyclerView.sQuinticInterpolator);
        L5:
            this.mOverScroller.fling(0, 0, r13, r14, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            postOnAnimation();
        }

        public void smoothScrollBy(int r7, int r8, int r9, Interpolator r10) {
            if (r9 != Integer.MIN_VALUE) goto L5;
            r9 = computeScrollDuration(r7, r8);
        L5:
            int r5 = r9;
            if (r10 != null) goto L9;
            r10 = RecyclerView.sQuinticInterpolator;
        L9:
            if (this.mInterpolator == r10) goto L11;
            this.mInterpolator = r10;
            this.mOverScroller = new OverScrollerAdapter(this.this$0.getContext(), r10);
        L11:
            this.mLastFlingY = 0;
            this.mLastFlingX = 0;
            this.this$0.setScrollState(2);
            this.mOverScroller.startScroll(0, 0, r7, r8, r5);
            postOnAnimation();
        }

        private int computeScrollDuration(int r2, int r3) {
            int r4 = Math.abs(r2);
            int r5 = Math.abs(r3);
            if (r4 <= r5) goto L5;
            boolean r0 = true;
        L6:
            RecyclerView r1 = this.this$0;
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

        public void stop() {
            this.this$0.removeCallbacks(this);
            this.mOverScroller.abortAnimation();
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

        static {
            FULLUPDATE_PAYLOADS = Collections.emptyList();
        }

        public ViewHolder(View r4) {
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
            if (r4 == null) goto L7;
            this.itemView = r4;
            return;
        L7:
            throw new IllegalArgumentException("itemView may not be null");
        }

        void flagRemovedAndOffsetPosition(int r2, int r3, boolean r4) {
            addFlags(8);
            offsetPosition(r3, r4);
            this.mPosition = r2;
        }

        void offsetPosition(int r3, boolean r4) {
            if (this.mOldPosition != (-1)) goto L6;
            this.mOldPosition = this.mPosition;
        L6:
            if (this.mPreLayoutPosition != (-1)) goto L8;
            this.mPreLayoutPosition = this.mPosition;
        L8:
            if (r4 == false) goto L10;
            this.mPreLayoutPosition += r3;
        L10:
            this.mPosition += r3;
            if (this.itemView.getLayoutParams() == null) goto L14;
            ((LayoutParams) this.itemView.getLayoutParams()).mInsetsDirty = true;
            return;
        }

        void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        void saveOldPosition() {
            if (this.mOldPosition != (-1)) goto L6;
            this.mOldPosition = this.mPosition;
            return;
        }

        boolean shouldIgnore() {
            if ((this.mFlags & 128) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        @Deprecated
        public final int getPosition() {
            int r0 = this.mPreLayoutPosition;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            return this.mPosition;
        }

        public final int getLayoutPosition() {
            int r0 = this.mPreLayoutPosition;
            if (r0 == (-1)) goto L5;
            return r0;
        L5:
            return this.mPosition;
        }

        @Deprecated
        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        public final int getBindingAdapterPosition() {
            if (this.mBindingAdapter != null) goto L5;
            return -1;
        L5:
            RecyclerView r0 = this.mOwnerRecyclerView;
            if (r0 != null) goto L8;
            return -1;
        L8:
            Adapter r1 = r0.getAdapter();
            if (r1 != null) goto L11;
            return -1;
        L11:
            int r2 = this.mOwnerRecyclerView.getAdapterPositionInRecyclerView(this);
            if (r2 != (-1)) goto L15;
            return -1;
        L15:
            return r1.findRelativeAdapterPositionIn(this.mBindingAdapter, this, r2);
        }

        public final int getAbsoluteAdapterPosition() {
            RecyclerView r0 = this.mOwnerRecyclerView;
            if (r0 != null) goto L7;
            return -1;
        L7:
            return r0.getAdapterPositionInRecyclerView(this);
        }

        public final Adapter<? extends ViewHolder> getBindingAdapter() {
            return this.mBindingAdapter;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        boolean isScrap() {
            if (this.mScrapContainer == null) goto L5;
            return true;
        L5:
            return false;
        }

        void unScrap() {
            this.mScrapContainer.unscrapView(this);
        }

        boolean wasReturnedFromScrap() {
            if ((this.mFlags & 32) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        void stopIgnoring() {
            this.mFlags &= -129;
        }

        void setScrapContainer(Recycler r1, boolean r2) {
            this.mScrapContainer = r1;
            this.mInChangeScrap = r2;
        }

        boolean isInvalid() {
            if ((this.mFlags & 4) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean needsUpdate() {
            if ((this.mFlags & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean isBound() {
            if ((this.mFlags & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        boolean isRemoved() {
            if ((this.mFlags & 8) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean hasAnyOfTheFlags(int r1) {
            if ((this.mFlags & r1) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean isTmpDetached() {
            if ((this.mFlags & 256) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean isAttachedToTransitionOverlay() {
            if (this.itemView.getParent() != null) goto L5;
        L7:
            return false;
        L5:
            if (this.itemView.getParent() == this.mOwnerRecyclerView) goto L7;
            return true;
        }

        boolean isAdapterPositionUnknown() {
            if ((this.mFlags & 512) == 0) goto L5;
        L8:
            return true;
        L5:
            if (isInvalid() == true) goto L8;
            return false;
        }

        void setFlags(int r3, int r4) {
            int r5 = r3 & r4;
            this.mFlags = r5 | (this.mFlags & (~r4));
        }

        void addFlags(int r2) {
            this.mFlags = r2 | this.mFlags;
        }

        void addChangePayload(Object r3) {
            if (r3 != null) goto L6;
            addFlags(1024);
            return;
        L6:
            if ((1024 & this.mFlags) != 0) goto L10;
            createPayloadsIfNeeded();
            this.mPayloads.add(r3);
            return;
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads != null) goto L6;
            ArrayList r0 = new ArrayList();
            this.mPayloads = r0;
            this.mUnmodifiedPayloads = Collections.unmodifiableList(r0);
            return;
        }

        void clearPayload() {
            List<Object> r0 = this.mPayloads;
            if (r0 == null) goto L5;
            r0.clear();
        L5:
            this.mFlags &= -1025;
        }

        List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) goto L14;
            List<Object> r0 = this.mPayloads;
            if (r0 == null) goto L12;
            if (r0.size() == 0) goto L12;
            return this.mUnmodifiedPayloads;
        L12:
            return FULLUPDATE_PAYLOADS;
        L14:
            return FULLUPDATE_PAYLOADS;
        }

        void resetInternal() {
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

        void onEnteredHiddenState(RecyclerView r3) {
            int r0 = this.mPendingAccessibilityState;
            if (r0 == (-1)) goto L5;
            this.mWasImportantForAccessibilityBeforeHidden = r0;
        L6:
            r3.setChildImportantForAccessibilityInternal(this, 4);
            return;
        L5:
            this.mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(this.itemView);
            goto L6
        }

        void onLeftHiddenState(RecyclerView r2) {
            r2.setChildImportantForAccessibilityInternal(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public String toString() {
            if (getClass().isAnonymousClass() == false) goto L5;
            String r0 = "ViewHolder";
        L6:
            StringBuilder r1 = new StringBuilder(r0 + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap() == false) goto L14;
            StringBuilder r2 = r1.append(" scrap ");
            if (this.mInChangeScrap == false) goto L11;
            String r3 = "[changeScrap]";
        L12:
            r2.append(r3);
            goto L14
        L11:
            r3 = "[attachedScrap]";
        L14:
            if (isInvalid() == false) goto L17;
            r1.append(" invalid");
        L17:
            if (isBound() == true) goto L20;
            r1.append(" unbound");
        L20:
            if (needsUpdate() == false) goto L23;
            r1.append(" update");
        L23:
            if (isRemoved() == false) goto L26;
            r1.append(" removed");
        L26:
            if (shouldIgnore() == false) goto L29;
            r1.append(" ignored");
        L29:
            if (isTmpDetached() == false) goto L32;
            r1.append(" tmpDetached");
        L32:
            if (isRecyclable() == true) goto L35;
            r1.append(" not recyclable(" + this.mIsRecyclableCount + ")");
        L35:
            if (isAdapterPositionUnknown() == false) goto L38;
            r1.append(" undefined adapter position");
        L38:
            if (this.itemView.getParent() != null) goto L40;
            r1.append(" no parent");
        L40:
            r1.append("}");
            return r1.toString();
        L5:
            r0 = getClass().getSimpleName();
            goto L6
        }

        public final void setIsRecyclable(boolean r3) {
            int r1 = this.mIsRecyclableCount;
            if (r3 == false) goto L5;
            int r2 = r1 - 1;
        L6:
            this.mIsRecyclableCount = r2;
            if (r2 >= 0) goto L13;
            this.mIsRecyclableCount = 0;
            if (RecyclerView.sDebugAssertionsEnabled == true) goto L12;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        L20:
            if (RecyclerView.sVerboseLoggingEnabled == false) goto L23;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(RecyclerView.TAG, "setIsRecyclable val:" + r3 + SimContactsConstants.ANR_SEP + this);
            return;
        L23:
            return;
        L12:
            throw new RuntimeException("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
        L13:
            if (r3 == true) goto L16;
            if (r2 != 1) goto L16;
            this.mFlags |= 16;
        L16:
            if (r3 == false) goto L20;
            if (r2 != 0) goto L20;
            this.mFlags &= -17;
            goto L20
        L5:
            r2 = r1 + 1;
            goto L6
        }

        public final boolean isRecyclable() {
            if ((this.mFlags & 16) == 0) goto L5;
        L7:
            return false;
        L5:
            if (ViewCompat.hasTransientState(this.itemView) == true) goto L7;
            return true;
        }

        boolean shouldBeKeptAsChild() {
            if ((this.mFlags & 16) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        boolean doesTransientStatePreventRecycling() {
            if ((this.mFlags & 16) == 0) goto L5;
        L7:
            return false;
        L5:
            if (ViewCompat.hasTransientState(this.itemView) == false) goto L7;
            return true;
        }

        boolean isUpdated() {
            if ((this.mFlags & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    private boolean shouldAbsorb(EdgeEffectAdapter r1, int r2) {
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.fluidrecyclerview.widget.RecyclerView";
    }

    public EdgeEffectFactory getEdgeEffectFactory() {
        return null;
    }

    public void onChildAttachedToWindow(View r1) {
    }

    public void onChildDetachedFromWindow(View r1) {
    }

    public void onScrollStateChanged(int r1) {
    }

    public void onScrolled(int r1, int r2) {
    }

    public void setEdgeEffectFactory(EdgeEffectFactory r1) {
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

    static /* synthetic */ void access$300(RecyclerView r0, View r1, int r2, ViewGroup.LayoutParams r3) {
        r0.attachViewToParent(r1, r2, r3);
    }

    static /* synthetic */ void access$400(RecyclerView r0, View r1) {
        r0.detachViewFromParent(r1);
    }

    static /* synthetic */ void access$500(RecyclerView r0, int r1, int r2) {
        r0.setMeasuredDimension(r1, r2);
    }

    static {
        NESTED_SCROLLING_ATTRS = new int[]{android.R.attr.nestedScrollingEnabled};
        DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
        FORCE_INVALIDATE_DISPLAY_LIST = false;
        ALLOW_SIZE_IN_UNSPECIFIED_SPEC = true;
        POST_UPDATES_ON_ANIMATION = true;
        ALLOW_THREAD_GAP_WORK = true;
        FORCE_ABS_FOCUS_SEARCH_DIRECTION = false;
        IGNORE_DETACHED_FOCUSED_CHILD = false;
        LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
        sQuinticInterpolator = new AnonymousClass3();
    }

    public static void setDebugAssertionsEnabled(boolean r0) {
        sDebugAssertionsEnabled = r0;
    }

    public static void setVerboseLoggingEnabled(boolean r0) {
        sVerboseLoggingEnabled = r0;
    }

    public RecyclerView(Context r2) {
        this(r2, null);
    }

    public RecyclerView(Context r2, AttributeSet r3) {
        this(r2, r3, R.attr.recyclerViewStyle);
    }

    public RecyclerView(Context r16, AttributeSet r17, int r18) {
        super(r16, r17, r18);
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
        this.mLastDispatchedBounceTranslation = 0.0f;
        this.mItemAnimator = new DefaultItemAnimator();
        this.mScrollState = 0;
        this.mScrollPointerId = -1;
        this.mScaledHorizontalScrollFactor = Float.MIN_VALUE;
        this.mScaledVerticalScrollFactor = Float.MIN_VALUE;
        this.mPreserveFocusAfterLayout = true;
        this.mViewFlinger = new ViewFlinger(this);
        if (ALLOW_THREAD_GAP_WORK == false) goto L5;
        GapWorker.LayoutPrefetchRegistryImpl r0 = new GapWorker.LayoutPrefetchRegistryImpl();
    L6:
        this.mPrefetchRegistry = r0;
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
        this.mEnableOverFling = true;
        this.mAvoidStateChangeInAnim = true;
        this.mItemAnimatorRunner = new AnonymousClass2(this);
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mViewInfoProcessCallback = new AnonymousClass4(this);
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration r1 = ViewConfiguration.get(r16);
        this.mTouchSlop = r1.getScaledTouchSlop();
        this.mScaledHorizontalScrollFactor = ViewConfigurationCompat.getScaledHorizontalScrollFactor(r1, r16);
        this.mScaledVerticalScrollFactor = ViewConfigurationCompat.getScaledVerticalScrollFactor(r1, r16);
        this.mMinFlingVelocity = r1.getScaledMinimumFlingVelocity();
        this.mMaxFlingVelocity = r1.getScaledMaximumFlingVelocity();
        this.mPhysicalCoef = ((r16.getResources().getDisplayMetrics().density * 160.0f) * 386.0878f) * 0.84f;
        if (getOverScrollMode() != 2) goto L9;
        boolean r2 = true;
    L10:
        setWillNotDraw(r2);
        this.mItemAnimator.setListener(this.mItemAnimatorListener);
        initAdapterManager();
        initChildrenHelper();
        initAutofill();
        if (ViewCompat.getImportantForAccessibility(this) != 0) goto L13;
        ViewCompat.setImportantForAccessibility(this, 1);
    L13:
        this.mAccessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new RecyclerViewAccessibilityDelegate(this));
        TypedArray r14 = r16.obtainStyledAttributes(r17, R.styleable.RecyclerView, r18, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r16, R.styleable.RecyclerView, r17, r14, r18, 0);
        String r3 = r14.getString(R.styleable.RecyclerView_layoutManager);
        if (r14.getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) != (-1)) goto L16;
        setDescendantFocusability(262144);
    L16:
        this.mClipToPadding = r14.getBoolean(R.styleable.RecyclerView_android_clipToPadding, true);
        boolean r4 = r14.getBoolean(R.styleable.RecyclerView_fastScrollEnabled, false);
        this.mEnableFastScroller = r4;
        if (r4 == false) goto L19;
        initFastScroller((StateListDrawable) r14.getDrawable(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), r14.getDrawable(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) r14.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), r14.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
    L19:
        r14.recycle();
        createLayoutManager(r16, r3, r17, r18, 0);
        int[] r5 = NESTED_SCROLLING_ATTRS;
        TypedArray r12 = r16.obtainStyledAttributes(r17, r5, r18, 0);
        ViewCompat.saveAttributeDataForStyleable(this, r16, r5, r17, r12, r18, 0);
        boolean r6 = r12.getBoolean(0, true);
        r12.recycle();
        setNestedScrollingEnabled(r6);
        PoolingContainer.setPoolingContainer(this, true);
        this.mRecyclerViewExt = new RecyclerViewExt(this);
        return;
    L9:
        r2 = false;
        goto L10
    L5:
        r0 = null;
        goto L6
    }

    String exceptionLabel() {
        return HanziToPinyin.Token.SEPARATOR + super.toString() + ", adapter:" + this.mAdapter + ", layout:" + this.mLayout + ", context:" + getContext();
    }

    private void initAutofill() {
        if (ViewCompat.getImportantForAutofill(this) != 0) goto L6;
        ViewCompat.setImportantForAutofill(this, 8);
        return;
    }

    public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate() {
        return this.mAccessibilityDelegate;
    }

    public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate r1) {
        this.mAccessibilityDelegate = r1;
        ViewCompat.setAccessibilityDelegate(this, r1);
    }

    private void createLayoutManager(Context r7, String r8, AttributeSet r9, int r10, int r11) {
        if (r8 == null) goto L37;
        String r12 = r8.trim();
        if (r12.isEmpty() == true) goto L43;
        String r13 = getFullClassName(r7, r12);
    L22:
        e = move-exception;
        throw new IllegalStateException(r9.getPositionDescription() + ": Class is not a LayoutManager " + r13, e);
    L34:
        e = move-exception;
        throw new IllegalStateException(r9.getPositionDescription() + ": Unable to find LayoutManager " + r13, e);
    L25:
        e = move-exception;
        throw new IllegalStateException(r9.getPositionDescription() + ": Cannot access non-public constructor " + r13, e);
    L28:
        e = move-exception;
        throw new IllegalStateException(r9.getPositionDescription() + ": Could not instantiate the LayoutManager: " + r13, e);
    L31:
        e = move-exception;
        throw new IllegalStateException(r9.getPositionDescription() + ": Could not instantiate the LayoutManager: " + r13, e);
    L8:
        if (isInEditMode() == false) goto L10;
        ClassLoader r1 = getClass().getClassLoader();     // Catch: ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
    L11:
        Class<? extends U> r2 = Class.forName(r13, false, r1).asSubclass(LayoutManager.class);     // Catch: ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
        Constructor r4 = r2.getConstructor(LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE);     // Catch: NoSuchMethodException -> L15 ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
        Object[] r5 = {r7, r9, Integer.valueOf(r10), Integer.valueOf(r11)};     // Catch: NoSuchMethodException -> L15 ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
    L18:
        r4.setAccessible(true);     // Catch: ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
        setLayoutManager((LayoutManager) r4.newInstance(r5));     // Catch: ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
        return;
    L15:
        e = move-exception;
        r4 = r2.getConstructor(new Class[0]);     // Catch: NoSuchMethodException -> L19 ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
        r5 = null;
    L19:
        e = move-exception;
        e.initCause(e);     // Catch: ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
        throw new IllegalStateException(r9.getPositionDescription() + ": Error creating LayoutManager " + r13, e);     // Catch: ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
    L10:
        r1 = r7.getClassLoader();     // Catch: ClassCastException -> L22 IllegalAccessException -> L25 InstantiationException -> L28 InvocationTargetException -> L31 ClassNotFoundException -> L34
        goto L11
    L43:
        return;
    }

    private String getFullClassName(Context r2, String r3) {
        if (r3.charAt(0) != '.') goto L7;
        return r2.getPackageName() + r3;
    L7:
        if (r3.contains(LibrarianImpl.Constants.DOT) == false) goto L10;
        return r3;
    L10:
        return RecyclerView.class.getPackage().getName() + '.' + r3;
    }

    private void initChildrenHelper() {
        this.mChildHelper = new ChildHelper(new AnonymousClass5(this));
    }

    void initAdapterManager() {
        this.mAdapterHelper = new AdapterHelper(new AnonymousClass6(this));
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
        ViewConfiguration r0 = ViewConfiguration.get(getContext());
        if (r4 != 0) goto L5;
    L8:
        this.mTouchSlop = r0.getScaledTouchSlop();
        return;
    L5:
        if (r4 == 1) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "setScrollingTouchSlop(): bad argument constant " + r4 + "; using default value");
        goto L8
    L7:
        this.mTouchSlop = r0.getScaledPagingTouchSlop();
    }

    public void swapAdapter(Adapter r2, boolean r3) {
        setLayoutFrozen(false);
        setAdapterInternal(r2, true, r3);
        processDataSetCompletelyChanged(true);
        requestLayout();
    }

    public void setAdapter(Adapter r3) {
        setLayoutFrozen(false);
        setAdapterInternal(r3, false, true);
        processDataSetCompletelyChanged(false);
        requestLayout();
    }

    void removeAndRecycleViews() {
        ItemAnimator r0 = this.mItemAnimator;
        if (r0 == null) goto L5;
        r0.endAnimations();
    L5:
        LayoutManager r1 = this.mLayout;
        if (r1 == null) goto L8;
        r1.removeAndRecycleAllViews(this.mRecycler);
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
    L8:
        this.mRecycler.clear();
    }

    private void setAdapterInternal(Adapter<?> r3, boolean r4, boolean r5) {
        Adapter r0 = this.mAdapter;
        if (r0 == null) goto L5;
        r0.unregisterAdapterDataObserver(this.mObserver);
        this.mAdapter.onDetachedFromRecyclerView(this);
    L5:
        if (r4 == false) goto L7;
        if (r5 == true) goto L7;
    L8:
        this.mAdapterHelper.reset();
        Adapter<?> r6 = this.mAdapter;
        this.mAdapter = r3;
        if (r3 == null) goto L11;
        r3.registerAdapterDataObserver(this.mObserver);
        r3.onAttachedToRecyclerView(this);
    L11:
        LayoutManager r7 = this.mLayout;
        if (r7 == null) goto L14;
        r7.onAdapterChanged(r6, this.mAdapter);
    L14:
        this.mRecycler.onAdapterChanged(r6, this.mAdapter, r4);
        this.mState.mStructureChanged = true;
        return;
    L7:
        removeAndRecycleViews();
        goto L8
    }

    public Adapter getAdapter() {
        return this.mAdapter;
    }

    @Deprecated
    public void setRecyclerListener(RecyclerListener r1) {
        this.mRecyclerListener = r1;
    }

    public void addRecyclerListener(RecyclerListener r3) {
        if (r3 == null) goto L4;
        boolean r0 = true;
    L5:
        Preconditions.checkArgument(r0, "'listener' arg cannot be null.");
        this.mRecyclerListeners.add(r3);
        return;
    L4:
        r0 = false;
        goto L5
    }

    public void removeRecyclerListener(RecyclerListener r1) {
        this.mRecyclerListeners.remove(r1);
    }

    @Override // android.view.View
    public int getBaseline() {
        LayoutManager r0 = this.mLayout;
        if (r0 == null) goto L7;
        return r0.getBaseline();
    L7:
        return super.getBaseline();
    }

    public void addOnChildAttachStateChangeListener(OnChildAttachStateChangeListener r2) {
        if (this.mOnChildAttachStateListeners != null) goto L5;
        this.mOnChildAttachStateListeners = new ArrayList();
    L5:
        this.mOnChildAttachStateListeners.add(r2);
    }

    public void removeOnChildAttachStateChangeListener(OnChildAttachStateChangeListener r1) {
        List<OnChildAttachStateChangeListener> r0 = this.mOnChildAttachStateListeners;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.remove(r1);
    }

    public void clearOnChildAttachStateChangeListeners() {
        List<OnChildAttachStateChangeListener> r0 = this.mOnChildAttachStateListeners;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public void setLayoutManager(LayoutManager r3) {
        if (r3 != this.mLayout) goto L5;
        return;
    L5:
        stopScroll();
        if (this.mLayout == null) goto L14;
        ItemAnimator r0 = this.mItemAnimator;
        if (r0 == null) goto L10;
        r0.endAnimations();
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
        this.mLayout = r3;
        if (r3 != null) goto L18;
    L24:
        this.mRecycler.updateViewCacheSize();
        requestLayout();
        return;
    L18:
        if (r3.mRecyclerView != null) goto L23;
        this.mLayout.setRecyclerView(this);
        if (this.mIsAttached == false) goto L24;
        this.mLayout.dispatchAttachedToWindow(this);
        goto L24
    L23:
        throw new IllegalArgumentException("LayoutManager " + r3 + " is already attached to a RecyclerView:" + r3.mRecyclerView.exceptionLabel());
    L14:
        this.mRecycler.clear();
        goto L15
    }

    public void setOnFlingListener(OnFlingListener r1) {
        this.mOnFlingListener = r1;
    }

    public OnFlingListener getOnFlingListener() {
        return this.mOnFlingListener;
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState(super.onSaveInstanceState());
        SavedState r1 = this.mPendingSavedState;
        if (r1 == null) goto L5;
        r0.copyFrom(r1);
    L9:
        return r0;
    L5:
        LayoutManager r2 = this.mLayout;
        if (r2 == null) goto L8;
        r0.mLayoutState = r2.onSaveInstanceState();
        goto L9
    L8:
        r0.mLayoutState = null;
        goto L9
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable r2) {
        if ((r2 instanceof SavedState) == true) goto L6;
        super.onRestoreInstanceState(r2);
        return;
    L6:
        SavedState r3 = (SavedState) r2;
        this.mPendingSavedState = r3;
        super.onRestoreInstanceState(r3.getSuperState());
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSaveInstanceState(SparseArray<Parcelable> r1) {
        dispatchFreezeSelfOnly(r1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> r1) {
        dispatchThawSelfOnly(r1);
    }

    private void addAnimatingView(ViewHolder r6) {
        View r0 = r6.itemView;
        if (r0.getParent() != this) goto L5;
        boolean r1 = true;
    L6:
        this.mRecycler.unscrapView(getChildViewHolder(r0));
        if (r6.isTmpDetached() == false) goto L9;
        this.mChildHelper.attachViewToParent(r0, -1, r0.getLayoutParams(), true);
        return;
    L9:
        if (r1 == true) goto L11;
        this.mChildHelper.addView(r0, true);
        return;
    L11:
        this.mChildHelper.hide(r0);
        return;
    L5:
        r1 = false;
        goto L6
    }

    boolean removeAnimatingView(View r4) {
        startInterceptRequestLayout();
        boolean r0 = this.mChildHelper.removeViewIfHidden(r4);
        if (r0 == false) goto L7;
        ViewHolder r1 = getChildViewHolderInt(r4);
        this.mRecycler.unscrapView(r1);
        this.mRecycler.recycleViewHolderInternal(r1);
        if (sVerboseLoggingEnabled == false) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "after removing animated view: " + r4 + ", " + this);
    L7:
        stopInterceptRequestLayout(!r0);
        return r0;
    }

    public LayoutManager getLayoutManager() {
        return this.mLayout;
    }

    public RecycledViewPool getRecycledViewPool() {
        return this.mRecycler.getRecycledViewPool();
    }

    public void setRecycledViewPool(RecycledViewPool r1) {
        this.mRecycler.setRecycledViewPool(r1);
    }

    public void setViewCacheExtension(ViewCacheExtension r1) {
        this.mRecycler.setViewCacheExtension(r1);
    }

    public void setItemViewCacheSize(int r1) {
        this.mRecycler.setViewCacheSize(r1);
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    void setScrollState(int r4) {
        if (r4 != this.mScrollState) goto L6;
        return;
    L6:
        if (sVerboseLoggingEnabled == false) goto L8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "setting scroll state to " + r4 + " from " + this.mScrollState, new Exception());
    L8:
        this.mScrollState = r4;
        if (r4 == 2) goto L11;
        stopScrollersInternal();
    L11:
        dispatchOnScrollStateChanged(r4);
    }

    public void addItemDecoration(ItemDecoration r3, int r4) {
        LayoutManager r0 = this.mLayout;
        if (r0 == null) goto L6;
        r0.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
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

    public void addItemDecoration(ItemDecoration r2) {
        addItemDecoration(r2, -1);
    }

    public ItemDecoration getItemDecorationAt(int r3) {
        int r0 = getItemDecorationCount();
        if (r3 < 0) goto L8;
        if (r3 >= r0) goto L8;
        return this.mItemDecorations.get(r3);
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

    public void removeItemDecoration(ItemDecoration r3) {
        LayoutManager r0 = this.mLayout;
        if (r0 == null) goto L5;
        r0.assertNotInLayoutOrScroll("Cannot remove item decoration during a scroll  or layout");
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

    public void setChildDrawingOrderCallback(ChildDrawingOrderCallback r2) {
        if (r2 != this.mChildDrawingOrderCallback) goto L5;
        return;
    L5:
        this.mChildDrawingOrderCallback = r2;
        if (r2 == null) goto L8;
        boolean r3 = true;
    L9:
        setChildrenDrawingOrderEnabled(r3);
        return;
    L8:
        r3 = false;
        goto L9
    }

    @Deprecated
    public void setOnScrollListener(OnScrollListener r1) {
        this.mScrollListener = r1;
    }

    public void addOnScrollListener(OnScrollListener r2) {
        if (this.mScrollListeners != null) goto L5;
        this.mScrollListeners = new ArrayList();
    L5:
        this.mScrollListeners.add(r2);
    }

    public void removeOnScrollListener(OnScrollListener r1) {
        List<OnScrollListener> r0 = this.mScrollListeners;
        if (r0 == null) goto L6;
        r0.remove(r1);
        return;
    }

    public void clearOnScrollListeners() {
        List<OnScrollListener> r0 = this.mScrollListeners;
        if (r0 == null) goto L6;
        r0.clear();
        return;
    }

    public void scrollToPosition(int r2) {
        if (this.mLayoutSuppressed == false) goto L5;
        return;
    L5:
        stopScroll();
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L9:
        r0.scrollToPosition(r2);
        awakenScrollBars();
    }

    void jumpToPositionForSmoothScroller(int r2) {
        if (this.mLayout != null) goto L5;
        return;
    L5:
        setScrollState(2);
        this.mLayout.scrollToPosition(r2);
        awakenScrollBars();
    }

    public void smoothScrollToPosition(int r3) {
        if (this.mLayoutSuppressed == false) goto L5;
        return;
    L5:
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L9;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L9:
        r0.smoothScrollToPosition(this, this.mState, r3);
    }

    @Override // android.view.View
    public void scrollTo(int r1, int r2) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View
    public void scrollBy(int r4, int r5) {
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return;
    L9:
        boolean r1 = r0.canScrollHorizontally();
        boolean r2 = this.mLayout.canScrollVertically();
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
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return;
    L9:
        int[] r1 = this.mReusableIntPair;
        int r2 = 0;
        r1[0] = 0;
        r1[1] = 0;
        boolean r3 = r0.canScrollHorizontally();
        boolean r4 = this.mLayout.canScrollVertically();
        if (r4 == false) goto L12;
        int r5 = (r3 ? 1 : 0) | 2;
    L14:
        if (r14 != null) goto L16;
        float r6 = getHeight() / 2.0f;
    L17:
        if (r14 != null) goto L19;
        float r7 = getWidth() / 2.0f;
    L20:
        int r16 = r12 - releaseHorizontalGlow(r12, r6);
        int r17 = r13 - releaseVerticalGlow(r13, r7);
        startNestedScroll(r5, r15);
        if (r3 == false) goto L23;
        int r8 = r16;
    L24:
        if (r4 == false) goto L26;
        int r9 = r17;
    L28:
        if (dispatchNestedPreScroll(r8, r9, this.mReusableIntPair, this.mScrollOffset, r15) == false) goto L30;
        int[] r10 = this.mReusableIntPair;
        r16 = r16 - r10[0];
        r17 = r17 - r10[1];
    L30:
        if (r3 == false) goto L32;
        int r11 = r16;
    L33:
        if (r4 == false) goto L35;
        r2 = r17;
    L35:
        scrollByInternal(r11, r2, r14, r15);
        GapWorker r18 = this.mGapWorker;
        if (r18 == null) goto L40;
        if (r16 != 0) goto L39;
        if (r17 == 0) goto L40;
    L39:
        r18.postFromTraversal(this, r16, r17);
    L40:
        stopNestedScroll(r15);
        return;
    L32:
        r11 = 0;
        goto L33
    L26:
        r9 = 0;
        goto L28
    L23:
        r8 = 0;
        goto L24
    L19:
        r7 = r14.getX();
        goto L20
    L16:
        r6 = r14.getY();
        goto L17
    L12:
        r5 = r3 ? 1 : 0;
        goto L14
    }

    void scrollStep(int r5, int r6, int[] r7) {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        TraceCompat.beginSection(TRACE_SCROLL_TAG);
        fillRemainingScrollValues(this.mState);
        if (r5 == 0) goto L5;
        int r8 = this.mLayout.scrollHorizontallyBy(r5, this.mRecycler, this.mState);
    L6:
        if (r6 == 0) goto L8;
        int r9 = this.mLayout.scrollVerticallyBy(r6, this.mRecycler, this.mState);
    L9:
        TraceCompat.endSection();
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

    private boolean hasUpdatedView() {
        int r0 = this.mChildHelper.getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L14;
        ViewHolder r3 = getChildViewHolderInt(this.mChildHelper.getChildAt(r2));
        if (r3 == null) goto L13;
        if (r3.shouldIgnore() == true) goto L13;
        if (r3.isUpdated() == false) goto L13;
        return true;
    L13:
        r2 = r2 + 1;
        goto L3
    L14:
        return false;
    }

    boolean scrollByInternal(int r17, int r18, MotionEvent r19, int r20) {
        consumePendingUpdateOperations();
        if (this.mAdapter == null) goto L5;
        int[] r2 = this.mReusableIntPair;
        r2[0] = 0;
        r2[1] = 0;
        scrollStep(r17, r18, r2);
        int[] r3 = this.mReusableIntPair;
        int r4 = r3[0];
        int r5 = r3[1];
        int r12 = r17 - r4;
        int r13 = r18 - r5;
        int r14 = r5;
        int r15 = r4;
    L7:
        if (this.mItemDecorations.isEmpty() == true) goto L9;
        invalidate();
    L9:
        int[] r7 = this.mReusableIntPair;
        r7[0] = 0;
        r7[1] = 0;
        dispatchNestedScroll(r15, r14, r12, r13, this.mScrollOffset, r20, r7);
        int[] r0 = this.mReusableIntPair;
        int r1 = r0[0];
        int r16 = r12 - r1;
        int r6 = r0[1];
        int r110 = r13 - r6;
        if (r1 != 0) goto L14;
        if (r6 != 0) goto L14;
        boolean r8 = false;
    L15:
        int r9 = this.mLastTouchX;
        int[] r10 = this.mScrollOffset;
        int r11 = r10[0];
        this.mLastTouchX = r9 - r11;
        int r21 = this.mLastTouchY;
        int r22 = r10[1];
        this.mLastTouchY = r21 - r22;
        int[] r23 = this.mNestedOffsets;
        r23[0] = r23[0] + r11;
        r23[1] = r23[1] + r22;
        if (getOverScrollMode() == 2) goto L21;
        if (r19 == null) goto L21;
        if (MotionEventCompat.isFromSource(r19, 8194) == true) goto L21;
        pullGlows(r19.getX(), r16, r19.getY(), r110);
    L21:
        if (r15 != 0) goto L23;
        if (r14 != 0) goto L23;
    L25:
        if (awakenScrollBars() == true) goto L27;
        invalidate();
    L27:
        if (r8 == true) goto L33;
        if (r15 != 0) goto L34;
        if (r14 == 0) goto L32;
        return true;
    L32:
        return false;
    L34:
        return true;
    L33:
        return true;
    L23:
        dispatchOnScrolled(r15, r14);
    L14:
        r8 = true;
        goto L15
    L5:
        r12 = 0;
        r13 = 0;
        r14 = 0;
        r15 = 0;
        goto L7
    }

    private int releaseHorizontalGlow(int r3, float r4) {
        EdgeEffectAdapter r5 = this.mHorizontalEdgeEffect;
        if (r5 != null) goto L5;
    L8:
        return 0;
    L5:
        if (r5.getDistance() == 0.0f) goto L8;
        int r6 = (int) this.mHorizontalEdgeEffect.onPullDistance(r3, true, false);
        invalidate();
        return r6;
    }

    private int releaseVerticalGlow(int r3, float r4) {
        EdgeEffectAdapter r5 = this.mVerticalEdgeEffect;
        if (r5 != null) goto L5;
    L8:
        return 0;
    L5:
        if (r5.getDistance() == 0.0f) goto L8;
        int r6 = (int) this.mVerticalEdgeEffect.onPullDistance(r3, true, false);
        invalidate();
        return r6;
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollOffset() {
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.canScrollHorizontally() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeHorizontalScrollOffset(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollExtent() {
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.canScrollHorizontally() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeHorizontalScrollExtent(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeHorizontalScrollRange() {
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.canScrollHorizontally() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeHorizontalScrollRange(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollOffset() {
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.canScrollVertically() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeVerticalScrollOffset(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollExtent() {
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.canScrollVertically() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeVerticalScrollExtent(this.mState);
    }

    @Override // android.view.View, androidx.core.view.ScrollingView
    public int computeVerticalScrollRange() {
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L6;
        return 0;
    L6:
        if (r0.canScrollVertically() == true) goto L8;
        return 0;
    L8:
        return this.mLayout.computeVerticalScrollRange(this.mState);
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
        if (this.mInterceptRequestLayoutDepth >= 1) goto L10;
        if (sDebugAssertionsEnabled == true) goto L8;
        this.mInterceptRequestLayoutDepth = 1;
        goto L10
    L8:
        throw new IllegalStateException("stopInterceptRequestLayout was called more times than startInterceptRequestLayout." + exceptionLabel());
    L10:
        if (r4 == true) goto L15;
        if (this.mLayoutSuppressed == true) goto L15;
        this.mLayoutWasDefered = false;
    L15:
        if (this.mInterceptRequestLayoutDepth != 1) goto L29;
        if (r4 == false) goto L27;
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
    public void setLayoutTransition(LayoutTransition r1) {
        if (r1 != null) goto L6;
        super.setLayoutTransition(null);
        return;
    L6:
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void smoothScrollBy(int r2, int r3) {
        smoothScrollBy(r2, r3, null);
    }

    public void smoothScrollBy(int r2, int r3, Interpolator r4) {
        smoothScrollBy(r2, r3, r4, Integer.MIN_VALUE);
    }

    public void smoothScrollBy(int r7, int r8, Interpolator r9, int r10) {
        smoothScrollBy(r7, r8, r9, r10, false);
    }

    void smoothScrollBy(int r4, int r5, Interpolator r6, int r7, boolean r8) {
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return;
    L9:
        int r1 = 0;
        if (r0.canScrollHorizontally() == true) goto L13;
        r4 = 0;
    L13:
        if (this.mLayout.canScrollVertically() == true) goto L15;
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
        this.mViewFlinger.smoothScrollBy(r4, r5, r7, r6);
        return;
    L31:
        scrollBy(r4, r5);
        return;
    L22:
        r2 = true;
        goto L23
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v5 */
    public boolean fling(int r9, int r10) {
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        return false;
    L7:
        if (this.mLayoutSuppressed == false) goto L9;
        return false;
    L9:
        int r1 = r0.canScrollHorizontally();
        boolean r2 = this.mLayout.canScrollVertically();
        if (r1 != 0) goto L12;
    L13:
        r9 = 0;
    L14:
        if (r2 == true) goto L16;
    L17:
        r10 = 0;
    L18:
        if (r9 != 0) goto L22;
        if (r10 != 0) goto L22;
        return false;
    L22:
        if (r9 == 0) goto L38;
        EdgeEffectAdapter r4 = this.mHorizontalEdgeEffect;
        if (r4 == null) goto L38;
        if (r4.getDistance() == 0.0f) goto L38;
        if (shouldAbsorb(this.mHorizontalEdgeEffect, r9) == false) goto L30;
        this.mHorizontalEdgeEffect.onAbsorb(r9);
        int r5 = 0;
    L32:
        if (this.mEnableOverFling == false) goto L37;
        EdgeEffectAdapter r6 = this.mHorizontalEdgeEffect;
        if (r6 != null) goto L36;
    L39:
        if (r10 == 0) goto L55;
        EdgeEffectAdapter r7 = this.mVerticalEdgeEffect;
        if (r7 == null) goto L55;
        if (r7.getDistance() == 0.0f) goto L55;
        if (shouldAbsorb(this.mVerticalEdgeEffect, r10) == false) goto L47;
        this.mVerticalEdgeEffect.onAbsorb(-r10);
        int r8 = 0;
    L49:
        if (this.mEnableOverFling == false) goto L54;
        EdgeEffectAdapter r11 = this.mVerticalEdgeEffect;
        if (r11 != null) goto L53;
    L56:
        if (r5 != 0) goto L58;
        if (r8 != 0) goto L58;
    L60:
        if (r9 != 0) goto L66;
        if (r10 != 0) goto L66;
        if (r5 != 0) goto L65;
        if (r8 != 0) goto L65;
        return false;
    L65:
        return true;
    L66:
        float r12 = r9;
        float r13 = r10;
        if (dispatchNestedPreFling(r12, r13) == true) goto L83;
        if (r1 != 0) goto L72;
        if (r2 == true) goto L72;
        boolean r14 = false;
    L73:
        dispatchNestedFling(r12, r13, r14);
        OnFlingListener r15 = this.mOnFlingListener;
        if (r15 != null) goto L76;
    L78:
        if (r14 == false) goto L83;
        if (r2 == false) goto L81;
        r1 = (r1 == true ? 1 : 0) | 2;
    L81:
        startNestedScroll(r1, 1);
        int r3 = this.mMaxFlingVelocity;
        int r16 = Math.max(-r3, Math.min(r9, r3));
        int r17 = this.mMaxFlingVelocity;
        this.mViewFlinger.fling(r16, Math.max(-r17, Math.min(r10, r17)));
        return true;
    L76:
        if (r15.onFling(r9, r10) == false) goto L78;
        return true;
    L72:
        r14 = true;
    L83:
        return false;
    L58:
        int r18 = this.mMaxFlingVelocity;
        r5 = Math.max(-r18, Math.min(r5, r18));
        int r19 = this.mMaxFlingVelocity;
        r8 = Math.max(-r19, Math.min(r8, r19));
        this.mViewFlinger.fling(r5, r8);
        goto L60
    L53:
        if ((r11.getDistance() * r10) >= 0.0f) goto L56;
    L54:
        r10 = 0;
        goto L56
    L47:
        r8 = r10;
    L55:
        r8 = 0;
        goto L56
    L36:
        if ((r6.getDistance() * r9) >= 0.0f) goto L39;
    L37:
        r9 = 0;
        goto L39
    L30:
        r5 = r9;
    L38:
        r5 = 0;
        goto L39
    L16:
        if (Math.abs(r10) >= this.mMinFlingVelocity) goto L18;
    L12:
        if (Math.abs(r9) >= this.mMinFlingVelocity) goto L14;
        goto L13
    }

    int consumeFlingInHorizontalStretch(int r2) {
        return consumeFlingInStretch(r2, this.mHorizontalEdgeEffect);
    }

    int consumeFlingInVerticalStretch(int r2) {
        return consumeFlingInStretch(r2, this.mVerticalEdgeEffect);
    }

    private int consumeFlingInStretch(int r3, EdgeEffectAdapter r4) {
        if (r3 == 0) goto L11;
        if (r4 != null) goto L5;
        return r3;
    L5:
        if (r4.getDistance() == 0.0f) goto L13;
        int r2 = (int) r4.onPullDistance(r3, true, this.mAvoidStateChangeInAnim);
        if (r3 <= 0) goto L10;
        return r3 - r2;
    L10:
        return r3 + r2;
    L13:
        return r3;
    L11:
        return r3;
    }

    public void stopScroll() {
        setScrollState(0);
        stopScrollersInternal();
    }

    private void stopScrollersInternal() {
        this.mViewFlinger.stop();
        LayoutManager r1 = this.mLayout;
        if (r1 == null) goto L6;
        r1.stopSmoothScroller();
        return;
    }

    public int getMinFlingVelocity() {
        return this.mMinFlingVelocity;
    }

    public void setMinFlingVelocity(int r1) {
        this.mMinFlingVelocity = r1;
    }

    public int getMaxFlingVelocity() {
        return this.mMaxFlingVelocity;
    }

    private void pullGlows(float r4, float r5, float r6, float r7) {
        boolean r0 = true;
        if (r5 == 0.0f) goto L5;
        ensureHorizontalGlow();
        this.mHorizontalEdgeEffect.onPullDistance(r5, false, false);
        boolean r8 = true;
    L7:
        if (r7 == 0.0f) goto L9;
        ensureVerticalGlow();
        this.mVerticalEdgeEffect.onPullDistance(r7, false, false);
    L10:
        if (r0 == true) goto L13;
        if (r5 != 0.0f) goto L13;
        if (r7 != 0.0f) goto L13;
        return;
    L13:
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L9:
        r0 = r8;
        goto L10
    L5:
        r8 = false;
        goto L7
    }

    private void releaseGlows() {
        EdgeEffectAdapter r0 = this.mHorizontalEdgeEffect;
        if (r0 == null) goto L5;
        r0.onRelease();
        boolean r1 = this.mHorizontalEdgeEffect.isFinished();
    L6:
        EdgeEffectAdapter r2 = this.mVerticalEdgeEffect;
        if (r2 == null) goto L9;
        r2.onRelease();
        r1 = r1 | this.mVerticalEdgeEffect.isFinished();
    L9:
        if (r1 == false) goto L12;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L12:
        return;
    L5:
        r1 = false;
        goto L6
    }

    void absorbGlows(int r2, int r3) {
        if (r2 == 0) goto L8;
        ensureHorizontalGlow();
        if (this.mHorizontalEdgeEffect.isFinished() == false) goto L6;
    L7:
        this.mHorizontalEdgeEffect.onAbsorb(r2);
        goto L8
    L6:
        if (this.mEnableOverFling == true) goto L7;
    L8:
        if (r3 == 0) goto L14;
        ensureVerticalGlow();
        if (this.mVerticalEdgeEffect.isFinished() == false) goto L12;
    L13:
        this.mVerticalEdgeEffect.onAbsorb(r3);
        goto L14
    L12:
        if (this.mEnableOverFling == true) goto L13;
    L14:
        if (r2 != 0) goto L16;
        if (r3 != 0) goto L16;
        return;
    L16:
        ViewCompat.postInvalidateOnAnimation(this);
    }

    void ensureHorizontalGlow() {
        if (this.mHorizontalEdgeEffect == null) goto L5;
        return;
    L5:
        EdgeEffectAdapter r0 = new EdgeEffectAdapter(getContext());
        this.mHorizontalEdgeEffect = r0;
        r0.updateViewportRange(getWidth());
    }

    void ensureVerticalGlow() {
        if (this.mVerticalEdgeEffect == null) goto L5;
        return;
    L5:
        EdgeEffectAdapter r0 = new EdgeEffectAdapter(getContext());
        this.mVerticalEdgeEffect = r0;
        r0.updateViewportRange(getHeight());
    }

    void invalidateGlows() {
        this.mVerticalEdgeEffect = null;
        this.mHorizontalEdgeEffect = null;
    }

    public boolean isOverScrolling() {
        EdgeEffectAdapter r0 = this.mVerticalEdgeEffect;
        if (r0 != null) goto L5;
    L9:
        boolean r1 = false;
    L10:
        EdgeEffectAdapter r4 = this.mHorizontalEdgeEffect;
        if (r4 != null) goto L13;
    L17:
        boolean r5 = false;
    L18:
        if (r1 == true) goto L23;
        if (r5 == false) goto L22;
        return true;
    L22:
        return false;
    L23:
        return true;
    L13:
        if (r4.getDistance() == 0.0f) goto L15;
    L16:
        r5 = true;
        goto L18
    L15:
        if (this.mHorizontalEdgeEffect.isFinished() == true) goto L17;
    L5:
        if (r0.getDistance() == 0.0f) goto L7;
    L8:
        r1 = true;
        goto L10
    L7:
        if (this.mVerticalEdgeEffect.isFinished() == true) goto L9;
        goto L8
    }

    public void setOnBounceTranslationListener(OnBounceTranslationListener r1) {
        this.mOnBounceTranslationListener = r1;
        dispatchBounceTranslationChanged();
    }

    public float getBounceTranslation() {
        EdgeEffectAdapter r0 = this.mVerticalEdgeEffect;
        if (r0 != null) goto L6;
        return 0.0f;
    L6:
        return r0.getDistance();
    }

    private void dispatchBounceTranslationChanged() {
        float r0 = getBounceTranslation();
        OnBounceTranslationListener r1 = this.mOnBounceTranslationListener;
        if (r1 != null) goto L5;
    L7:
        this.mLastDispatchedBounceTranslation = r0;
        return;
    L5:
        if (r0 == this.mLastDispatchedBounceTranslation) goto L7;
        r1.onTranslationChanged(r0);
        goto L7
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View r9, int r10) {
        View r0 = this.mLayout.onInterceptFocusSearch(r9, r10);
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
        View r5 = this.mLayout.onFocusSearchFailed(r9, r10, this.mRecycler, this.mState);
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
        if (this.mLayout.canScrollVertically() == false) goto L32;
        if (r10 != 2) goto L24;
        int r6 = 130;
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
        this.mLayout.onFocusSearchFailed(r9, r10, this.mRecycler, this.mState);
        stopInterceptRequestLayout(false);
    L60:
        r5 = r3.findNextFocus(this, r9, r10);
        goto L69
    L35:
        if (this.mLayout.canScrollHorizontally() == false) goto L55;
        if (this.mLayout.getLayoutDirection() != 1) goto L39;
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
        if (this.mLayout.getLayoutDirection() != 1) goto L19;
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
        if (this.mLayout.onRequestChildFocus(this, this.mState, r3, r4) == true) goto L6;
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
        if ((r1 instanceof LayoutParams) == false) goto L10;
        LayoutParams r2 = (LayoutParams) r1;
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
        LayoutManager r5 = this.mLayout;
        Rect r8 = this.mTempRect;
        boolean r9 = !this.mFirstLayoutComplete;
        if (r13 != null) goto L15;
        boolean r10 = true;
    L16:
        r5.requestChildRectangleOnScreen(this, r12, r8, r9, r10);
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
        return this.mLayout.requestChildRectangleOnScreen(this, r2, r3, r4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> r2, int r3, int r4) {
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L5;
    L6:
        super.addFocusables(r2, r3, r4);
        return;
    L5:
        if (r0.onAddFocusables(this, r2, r3, r4) == false) goto L6;
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int r2, Rect r3) {
        if (isComputingLayout() == false) goto L7;
        return false;
    L7:
        return super.onRequestFocusInDescendants(r2, r3);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mLayoutOrScrollCounter = 0;
        boolean r1 = true;
        this.mIsAttached = true;
        if (this.mFirstLayoutComplete == true) goto L5;
    L7:
        r1 = false;
    L8:
        this.mFirstLayoutComplete = r1;
        this.mRecycler.onAttachedToWindow();
        LayoutManager r2 = this.mLayout;
        if (r2 == null) goto L11;
        r2.dispatchAttachedToWindow(this);
    L11:
        this.mPostedAnimatorRunner = false;
        if (ALLOW_THREAD_GAP_WORK == false) goto L25;
        GapWorker r0 = GapWorker.sGapWorker.get();
        this.mGapWorker = r0;
        if (r0 != null) goto L23;
        this.mGapWorker = new GapWorker();
        Display r3 = ViewCompat.getDisplay(this);
        if (isInEditMode() == true) goto L21;
        if (r3 == null) goto L21;
        float r4 = r3.getRefreshRate();
        if (r4 < 30.0f) goto L21;
    L22:
        this.mGapWorker.mFrameIntervalNs = (long) (1.0E9f / r4);
        GapWorker.sGapWorker.set(this.mGapWorker);
    L21:
        r4 = 60.0f;
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
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ItemAnimator r0 = this.mItemAnimator;
        if (r0 == null) goto L5;
        r0.endAnimations();
    L5:
        stopScroll();
        this.mIsAttached = false;
        LayoutManager r1 = this.mLayout;
        if (r1 == null) goto L8;
        r1.dispatchDetachedFromWindow(this, this.mRecycler);
    L8:
        this.mPendingAccessibilityImportanceChange.clear();
        removeCallbacks(this.mItemAnimatorRunner);
        this.mViewInfoStore.onDetach();
        this.mRecycler.onDetachedFromWindow();
        PoolingContainer.callPoolingContainerOnReleaseForChildren(this);
        if (ALLOW_THREAD_GAP_WORK == false) goto L14;
        GapWorker r2 = this.mGapWorker;
        if (r2 == null) goto L15;
        r2.remove(this);
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
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + exceptionLabel()));
        return;
    }

    public void addOnItemTouchListener(OnItemTouchListener r1) {
        this.mOnItemTouchListeners.add(r1);
    }

    public void removeOnItemTouchListener(OnItemTouchListener r2) {
        this.mOnItemTouchListeners.remove(r2);
        if (this.mInterceptingOnItemTouchListener != r2) goto L6;
        this.mInterceptingOnItemTouchListener = null;
        return;
    }

    private boolean dispatchToOnItemTouchListeners(MotionEvent r3) {
        OnItemTouchListener r0 = this.mInterceptingOnItemTouchListener;
        if (r0 == null) goto L5;
        r0.onTouchEvent(this, r3);
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

    private boolean findInterceptingOnItemTouchListener(MotionEvent r7) {
        int r0 = r7.getAction();
        int r1 = this.mOnItemTouchListeners.size();
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L11;
        OnItemTouchListener r4 = this.mOnItemTouchListeners.get(r3);
        if (r4.onInterceptTouchEvent(this, r7) == false) goto L10;
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
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L12;
        return false;
    L12:
        boolean r1 = r0.canScrollHorizontally();
        boolean r3 = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker != null) goto L15;
        this.mVelocityTracker = VelocityTrackerFactory.create(getContext());
    L15:
        this.mVelocityTracker.addMovement(r9);
        int r4 = r9.getActionMasked();
        int r5 = r9.getActionIndex();
        if (r4 == 0) goto L50;
        if (r4 == 1) goto L47;
        if (r4 != 2) goto L20;
        int r6 = r9.findPointerIndex(this.mScrollPointerId);
        if (r6 >= 0) goto L33;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
        return false;
    L33:
        int r7 = (int) (r9.getX(r6) + 0.5f);
        int r10 = (int) (r9.getY(r6) + 0.5f);
        if (this.mScrollState == 1) goto L48;
        int r8 = r7 - this.mInitialTouchX;
        int r11 = r10 - this.mInitialTouchY;
        if (r1 == true) goto L38;
    L40:
        boolean r2 = false;
    L41:
        if (r3 == true) goto L43;
    L45:
        if (r2 == false) goto L48;
        setScrollState(1);
        goto L48
    L43:
        if (Math.abs(r11) <= this.mTouchSlop) goto L45;
        this.mLastTouchY = r10;
        r2 = true;
        goto L45
    L38:
        if (Math.abs(r8) <= this.mTouchSlop) goto L40;
        this.mLastTouchX = r7;
        r2 = true;
    L48:
        boolean r12 = false;
    L63:
        if (r12 == false) goto L65;
        return false;
    L65:
        if (this.mScrollState == 1) goto L67;
        return false;
    L67:
        return true;
    L20:
        if (r4 != 3) goto L22;
        cancelScroll();
        goto L48
    L22:
        if (r4 != 5) goto L24;
        this.mScrollPointerId = r9.getPointerId(r5);
        int r13 = (int) (r9.getX(r5) + 0.5f);
        this.mLastTouchX = r13;
        this.mInitialTouchX = r13;
        int r14 = (int) (r9.getY(r5) + 0.5f);
        this.mLastTouchY = r14;
        this.mInitialTouchY = r14;
        goto L48
    L24:
        if (r4 != 6) goto L48;
        onPointerUp(r9);
        goto L48
    L47:
        this.mVelocityTracker.clear();
        stopNestedScroll(0);
        goto L48
    L50:
        if (this.mIgnoreMotionEventTillDown == false) goto L52;
        this.mIgnoreMotionEventTillDown = false;
    L52:
        this.mScrollPointerId = r9.getPointerId(0);
        int r15 = (int) (r9.getX() + 0.5f);
        this.mLastTouchX = r15;
        this.mInitialTouchX = r15;
        int r16 = (int) (r9.getY() + 0.5f);
        this.mLastTouchY = r16;
        this.mInitialTouchY = r16;
        r12 = this.mRecyclerViewExt.isDisallowInterceptTouchEvent(r9, false);
        if (r12 == false) goto L55;
    L59:
        int[] r17 = this.mNestedOffsets;
        r17[1] = 0;
        r17[0] = 0;
        int r18 = r1;
        if (r3 == false) goto L62;
        r18 = (r1 ? 1 : 0) | 2;
    L62:
        startNestedScroll(r18, 0);
        goto L63
    L55:
        if (stopGlowAnimations(r9) == false) goto L57;
    L58:
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
        stopNestedScroll(1);
        goto L59
    L57:
        if (this.mScrollState != 2) goto L59;
        goto L58
    }

    private boolean stopGlowAnimations(MotionEvent r5) {
        EdgeEffectAdapter r6 = this.mHorizontalEdgeEffect;
        if (r6 != null) goto L5;
    L7:
        boolean r7 = false;
    L8:
        EdgeEffectAdapter r3 = this.mVerticalEdgeEffect;
        if (r3 == null) goto L14;
        if (r3.getDistance() == 0.0f) goto L14;
        this.mVerticalEdgeEffect.onPullDistance(0.0f, false, false);
        return true;
    L14:
        return r7;
    L5:
        if (r6.getDistance() == 0.0f) goto L7;
        r7 = true;
        goto L8
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean r4) {
        int r0 = this.mOnItemTouchListeners.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mOnItemTouchListeners.get(r1).onRequestDisallowInterceptTouchEvent(r4);
        r1 = r1 + 1;
        goto L3
    L5:
        super.requestDisallowInterceptTouchEvent(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r18) {
        boolean r8 = false;
        if (this.mLayoutSuppressed == false) goto L5;
    L107:
        return false;
    L5:
        if (this.mIgnoreMotionEventTillDown == true) goto L107;
        if (dispatchToOnItemTouchListeners(r18) == false) goto L11;
        cancelScroll();
        return true;
    L11:
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L14;
        return false;
    L14:
        boolean r10 = r0.canScrollHorizontally();
        boolean r11 = this.mLayout.canScrollVertically();
        if (this.mVelocityTracker != null) goto L17;
        this.mVelocityTracker = VelocityTrackerFactory.create(getContext());
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
        if (r1 != 0) goto L23;
        this.mScrollPointerId = r18.getPointerId(0);
        int r5 = (int) (r18.getX() + 0.5f);
        this.mLastTouchX = r5;
        this.mInitialTouchX = r5;
        int r6 = (int) (r18.getY() + 0.5f);
        this.mLastTouchY = r6;
        this.mInitialTouchY = r6;
        int r13 = r10;
        if (r11 == false) goto L102;
        r13 = (r10 ? 1 : 0) | 2;
    L102:
        startNestedScroll(r13, 0);
    L103:
        if (r8 == true) goto L105;
        this.mVelocityTracker.addMovement(r12);
    L105:
        r12.recycle();
        return true;
    L23:
        if (r1 != 1) goto L25;
        this.mVelocityTracker.addMovement(r12);
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxFlingVelocity);
        if (r10 == false) goto L87;
        float r7 = -this.mVelocityTracker.getXVelocity(this.mScrollPointerId);
    L88:
        if (r11 == false) goto L90;
        float r9 = -this.mVelocityTracker.getYVelocity(this.mScrollPointerId);
    L91:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "TouchUp, Velocity: x: " + r7 + ", y: " + r9);
        if (r7 != 0.0f) goto L96;
        if (r9 != 0.0f) goto L96;
    L97:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "No fling, setting scroll state to idle");
        setScrollState(0);
    L98:
        resetScroll();
        r8 = true;
    L96:
        if (fling((int) r7, (int) r9) == true) goto L98;
    L90:
        r9 = 0.0f;
        goto L91
    L87:
        r7 = 0.0f;
        goto L88
    L25:
        if (r1 != 2) goto L27;
        int r14 = r18.findPointerIndex(this.mScrollPointerId);
        if (r14 >= 0) goto L40;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Error processing scroll; pointer index for id " + this.mScrollPointerId + " not found. Did any MotionEvents get skipped?");
        return false;
    L40:
        int r15 = (int) (r18.getX(r14) + 0.5f);
        int r16 = (int) (r18.getY(r14) + 0.5f);
        int r17 = this.mLastTouchX - r15;
        int r19 = this.mLastTouchY - r16;
        if (this.mScrollState == 1) goto L58;
        if (r10 == false) goto L48;
        if (r17 <= 0) goto L45;
        r17 = Math.max(0, r17 - this.mTouchSlop);
    L46:
        if (r17 == 0) goto L48;
        boolean r20 = true;
    L49:
        if (r11 == false) goto L55;
        if (r19 <= 0) goto L52;
        r19 = Math.max(0, r19 - this.mTouchSlop);
    L53:
        if (r19 == 0) goto L55;
        r20 = true;
        goto L55
    L52:
        r19 = Math.min(0, r19 + this.mTouchSlop);
    L55:
        if (r20 == false) goto L58;
        setScrollState(1);
        goto L58
    L45:
        r17 = Math.min(0, r17 + this.mTouchSlop);
    L48:
        r20 = false;
    L58:
        if (this.mScrollState != 1) goto L103;
        int[] r21 = this.mReusableIntPair;
        r21[0] = 0;
        r21[1] = 0;
        int r110 = r17 - releaseHorizontalGlow(r17, r18.getY());
        int r111 = r19 - releaseVerticalGlow(r19, r18.getX());
        if (r10 == false) goto L62;
        int r22 = r110;
    L63:
        if (r11 == false) goto L65;
        int r23 = r111;
    L67:
        if (dispatchNestedPreScroll(r22, r23, this.mReusableIntPair, this.mScrollOffset, 0) == false) goto L69;
        int[] r24 = this.mReusableIntPair;
        r110 = r110 - r24[0];
        r111 = r111 - r24[1];
        int[] r25 = this.mNestedOffsets;
        int r26 = r25[0];
        int[] r27 = this.mScrollOffset;
        r25[0] = r26 + r27[0];
        r25[1] = r25[1] + r27[1];
        getParent().requestDisallowInterceptTouchEvent(true);
    L69:
        int r28 = r111;
        int[] r29 = this.mScrollOffset;
        this.mLastTouchX = r15 - r29[0];
        this.mLastTouchY = r16 - r29[1];
        if (r10 == false) goto L72;
        int r30 = r110;
    L73:
        if (r11 == false) goto L75;
        int r31 = r28;
    L77:
        if (scrollByInternal(r30, r31, r18, 0) == false) goto L79;
        getParent().requestDisallowInterceptTouchEvent(true);
    L79:
        GapWorker r32 = this.mGapWorker;
        if (r32 == null) goto L103;
        if (r110 != 0) goto L83;
        if (r28 == 0) goto L103;
    L83:
        r32.postFromTraversal(this, r110, r28);
        goto L103
    L75:
        r31 = 0;
        goto L77
    L72:
        r30 = 0;
        goto L73
    L65:
        r23 = 0;
        goto L67
    L62:
        r22 = 0;
        goto L63
    L27:
        if (r1 != 3) goto L29;
        cancelScroll();
        goto L103
    L29:
        if (r1 != 5) goto L31;
        this.mScrollPointerId = r18.getPointerId(r2);
        int r33 = (int) (r18.getX(r2) + 0.5f);
        this.mLastTouchX = r33;
        this.mInitialTouchX = r33;
        int r34 = (int) (r18.getY(r2) + 0.5f);
        this.mLastTouchY = r34;
        this.mInitialTouchY = r34;
        goto L103
    L31:
        if (r1 != 6) goto L103;
        onPointerUp(r18);
        goto L103
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
        if (this.mLayout.canScrollVertically() == false) goto L15;
        float r0 = -r6.getAxisValue(9);
    L17:
        if (this.mLayout.canScrollHorizontally() == false) goto L19;
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
        if ((r6.getSource() & 4194304) == 0) goto L28;
        float r1 = r6.getAxisValue(26);
        if (this.mLayout.canScrollVertically() == false) goto L26;
        r0 = -r1;
        goto L19
    L26:
        if (this.mLayout.canScrollHorizontally() == false) goto L28;
        r3 = r1;
        r0 = 0.0f;
    L28:
        r0 = 0.0f;
        r3 = 0.0f;
        goto L30
    }

    @Override // android.view.View
    protected void onMeasure(int r8, int r9) {
        LayoutManager r0 = this.mLayout;
        if (r0 != null) goto L6;
        defaultOnMeasure(r8, r9);
        return;
    L6:
        boolean r2 = false;
        if (r0.isAutoMeasureEnabled() == false) goto L26;
        int r1 = View.MeasureSpec.getMode(r8);
        int r3 = View.MeasureSpec.getMode(r9);
        this.mLayout.onMeasure(this.mRecycler, this.mState, r8, r9);
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
        if (this.mState.mLayoutStep != 1) goto L20;
        dispatchLayoutStep1();
    L20:
        this.mLayout.setMeasureSpecs(r8, r9);
        this.mState.mIsMeasuring = true;
        dispatchLayoutStep2();
        this.mLayout.setMeasuredDimensionFromChildren(r8, r9);
        if (this.mLayout.shouldMeasureTwice() == false) goto L23;
        this.mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        this.mState.mIsMeasuring = true;
        dispatchLayoutStep2();
        this.mLayout.setMeasuredDimensionFromChildren(r8, r9);
    L23:
        this.mLastAutoMeasureNonExactMeasuredWidth = getMeasuredWidth();
        this.mLastAutoMeasureNonExactMeasuredHeight = getMeasuredHeight();
        return;
    L26:
        if (this.mHasFixedSize == false) goto L30;
        this.mLayout.onMeasure(this.mRecycler, this.mState, r8, r9);
        return;
    L30:
        if (this.mAdapterUpdateDuringMeasure == false) goto L37;
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        onExitLayoutOrScroll();
        if (this.mState.mRunPredictiveAnimations == false) goto L34;
        this.mState.mInPreLayout = true;
    L35:
        this.mAdapterUpdateDuringMeasure = false;
        stopInterceptRequestLayout(false);
    L40:
        Adapter r4 = this.mAdapter;
        if (r4 == null) goto L43;
        this.mState.mItemCount = r4.getItemCount();
    L44:
        startInterceptRequestLayout();
        this.mLayout.onMeasure(this.mRecycler, this.mState, r8, r9);
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

    void defaultOnMeasure(int r3, int r4) {
        setMeasuredDimension(LayoutManager.chooseSize(r3, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), LayoutManager.chooseSize(r4, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
    }

    @Override // android.view.View
    protected void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (r1 != r3) goto L5;
        if (r2 != r4) goto L5;
        return;
    L5:
        invalidateGlows();
    }

    public void setItemAnimator(ItemAnimator r3) {
        ItemAnimator r0 = this.mItemAnimator;
        if (r0 == null) goto L5;
        r0.endAnimations();
        this.mItemAnimator.setListener(null);
    L5:
        this.mItemAnimator = r3;
        if (r3 == null) goto L9;
        r3.setListener(this.mItemAnimatorListener);
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
        if (r0 < 1) goto L5;
        return;
    L5:
        if (sDebugAssertionsEnabled == false) goto L10;
        if (r0 >= 0) goto L10;
        throw new IllegalStateException("layout or scroll counter cannot go below zero.Some calls are not matching" + exceptionLabel());
    L10:
        this.mLayoutOrScrollCounter = 0;
        if (r3 == false) goto L15;
        dispatchContentChangedIfNecessary();
        dispatchPendingImportantForAccessibilityChanges();
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
        AccessibilityEventCompat.setContentChangeTypes(r1, r0);
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
        int r4 = AccessibilityEventCompat.getContentChangeTypes(r3);
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

    public ItemAnimator getItemAnimator() {
        return this.mItemAnimator;
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
        boolean r1 = false;
        if (this.mItemsAddedOrRemoved == false) goto L14;
    L17:
        boolean r0 = true;
    L18:
        State r3 = this.mState;
        if (this.mFirstLayoutComplete == true) goto L21;
    L32:
        boolean r4 = false;
    L33:
        r3.mRunSimpleAnimations = r4;
        State r5 = this.mState;
        if (r5.mRunSimpleAnimations == false) goto L41;
        if (r0 == false) goto L41;
        if (this.mDataSetHasChangedAfterLayout == true) goto L41;
        if (predictiveItemAnimationsEnabled() == false) goto L41;
        r1 = true;
    L41:
        r5.mRunPredictiveAnimations = r1;
        return;
    L21:
        if (this.mItemAnimator == null) goto L32;
        if (this.mDataSetHasChangedAfterLayout == true) goto L28;
        if (r0 == true) goto L28;
        if (this.mLayout.mRequestedSimpleAnimations == false) goto L32;
    L28:
        if (this.mDataSetHasChangedAfterLayout == true) goto L30;
    L31:
        r4 = true;
        goto L33
    L30:
        if (this.mAdapter.hasStableIds() == false) goto L32;
    L14:
        if (this.mItemsChanged == true) goto L17;
        r0 = false;
        goto L18
    L10:
        this.mAdapterHelper.consumeUpdatesInOnePass();
        goto L11
    }

    void dispatchLayout() {
        if (this.mAdapter != null) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "No adapter attached; skipping layout");
        return;
    L7:
        if (this.mLayout != null) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "No layout manager attached; skipping layout");
        return;
    L10:
        this.mState.mIsMeasuring = false;
        if (this.mLastAutoMeasureSkippedDueToExact == true) goto L13;
    L17:
        boolean r0 = false;
    L18:
        this.mLastAutoMeasureNonExactMeasuredWidth = 0;
        this.mLastAutoMeasureNonExactMeasuredHeight = 0;
        this.mLastAutoMeasureSkippedDueToExact = false;
        if (this.mState.mLayoutStep != 1) goto L22;
        dispatchLayoutStep1();
        this.mLayout.setExactMeasureSpecsFrom(this);
        dispatchLayoutStep2();
    L31:
        dispatchLayoutStep3();
        return;
    L22:
        if (this.mAdapterHelper.hasUpdates() == true) goto L30;
        if (r0 == true) goto L30;
        if (this.mLayout.getWidth() != getWidth()) goto L30;
        if (this.mLayout.getHeight() != getHeight()) goto L30;
        this.mLayout.setExactMeasureSpecsFrom(this);
    L30:
        this.mLayout.setExactMeasureSpecsFrom(this);
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
        ViewHolder r1 = null;
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
        State r2 = this.mState;
        if (this.mAdapter.hasStableIds() == false) goto L18;
        long r3 = r1.getItemId();
    L19:
        r2.mFocusedItemId = r3;
        State r4 = this.mState;
        if (this.mDataSetHasChangedAfterLayout == false) goto L23;
        int r5 = -1;
    L26:
        r4.mFocusedItemPosition = r5;
        this.mState.mFocusedSubChildId = getDeepestFocusedViewWithId(r1.itemView);
        return;
    L23:
        if (r1.isRemoved() == false) goto L25;
        r5 = r1.mOldPosition;
        goto L26
    L25:
        r5 = r1.getAbsoluteAdapterPosition();
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
        this.mState.mFocusedItemId = -1;
        this.mState.mFocusedItemPosition = -1;
        this.mState.mFocusedSubChildId = -1;
    }

    private View findNextViewToFocus() {
        if (this.mState.mFocusedItemPosition == (-1)) goto L5;
        int r0 = this.mState.mFocusedItemPosition;
    L6:
        int r1 = this.mState.getItemCount();
        int r2 = r0;
    L7:
        if (r2 >= r1) goto L16;
        ViewHolder r3 = findViewHolderForAdapterPosition(r2);
        if (r3 == null) goto L16;
        if (r3.itemView.hasFocusable() == true) goto L14;
        r2 = r2 + 1;
        goto L7
    L14:
        return r3.itemView;
    L16:
        int r4 = Math.min(r1, r0);
    L17:
        r4 = r4 - 1;
        if (r4 < 0) goto L27;
        ViewHolder r5 = findViewHolderForAdapterPosition(r4);
        if (r5 == null) goto L21;
        if (r5.itemView.hasFocusable() == false) goto L17;
        return r5.itemView;
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
        if (this.mChildHelper.getChildCount() != 0) goto L30;
        requestFocus();
        return;
    L28:
        if (this.mChildHelper.isHidden(r0) == true) goto L30;
        return;
    L30:
        View r1 = null;
        if (this.mState.mFocusedItemId != (-1)) goto L33;
    L35:
        ViewHolder r2 = null;
    L36:
        if (r2 == null) goto L44;
        if (this.mChildHelper.isHidden(r2.itemView) == true) goto L44;
        if (r2.itemView.hasFocusable() == false) goto L44;
        r1 = r2.itemView;
    L46:
        if (r1 != null) goto L48;
        return;
    L48:
        if (this.mState.mFocusedSubChildId == (-1)) goto L54;
        View r6 = r1.findViewById(this.mState.mFocusedSubChildId);
        if (r6 == null) goto L54;
        if (r6.isFocusable() == false) goto L54;
        r1 = r6;
    L54:
        r1.requestFocus();
        return;
    L44:
        if (this.mChildHelper.getChildCount() <= 0) goto L46;
        r1 = findNextViewToFocus();
        goto L46
    L33:
        if (this.mAdapter.hasStableIds() == false) goto L35;
        r2 = findViewHolderForItemId(this.mState.mFocusedItemId);
        goto L36
    }

    private int getDeepestFocusedViewWithId(View r3) {
        int r2 = r3.getId();
    L4:
        if (r3.isFocused() == true) goto L12;
        if ((r3 instanceof ViewGroup) == false) goto L12;
        if (r3.hasFocus() == false) goto L12;
        r3 = ((ViewGroup) r3).getFocusedChild();
        if (r3.getId() == (-1)) goto L4;
        r2 = r3.getId();
    L12:
        return r2;
    }

    final void fillRemainingScrollValues(State r3) {
        if (getScrollState() != 2) goto L5;
        OverScrollerAdapter r2 = this.mViewFlinger.mOverScroller;
        r3.mRemainingScrollHorizontal = r2.getFinalX() - r2.getCurrX();
        r3.mRemainingScrollVertical = r2.getFinalY() - r2.getCurrY();
        return;
    L5:
        r3.mRemainingScrollHorizontal = 0;
        r3.mRemainingScrollVertical = 0;
    }

    private void dispatchLayoutStep1() {
        boolean r1 = true;
        this.mState.assertLayoutStep(1);
        fillRemainingScrollValues(this.mState);
        this.mState.mIsMeasuring = false;
        startInterceptRequestLayout();
        this.mViewInfoStore.clear();
        onEnterLayoutOrScroll();
        processAdapterUpdatesAndSetAnimationFlags();
        saveFocusInfo();
        State r0 = this.mState;
        if (r0.mRunSimpleAnimations == true) goto L5;
    L7:
        r1 = false;
    L8:
        r0.mTrackOldChangeHolders = r1;
        this.mItemsChanged = false;
        this.mItemsAddedOrRemoved = false;
        State r2 = this.mState;
        r2.mInPreLayout = r2.mRunPredictiveAnimations;
        this.mState.mItemCount = this.mAdapter.getItemCount();
        findMinMaxChildLayoutPositions(this.mMinMaxLayoutPositions);
        if (this.mState.mRunSimpleAnimations == false) goto L32;
        int r3 = this.mChildHelper.getChildCount();
        int r4 = 0;
    L11:
        if (r4 >= r3) goto L32;
        ViewHolder r5 = getChildViewHolderInt(this.mChildHelper.getChildAt(r4));
        if (r5.shouldIgnore() == true) goto L30;
        if (r5.isInvalid() == true) goto L17;
    L19:
        this.mViewInfoStore.addToPreLayout(r5, this.mItemAnimator.recordPreLayoutInformation(this.mState, r5, ItemAnimator.buildAdapterChangeFlagsForAnimations(r5), r5.getUnmodifiedPayloads()));
        if (this.mState.mTrackOldChangeHolders == false) goto L30;
        if (r5.isUpdated() == false) goto L30;
        if (r5.isRemoved() == true) goto L30;
        if (r5.shouldIgnore() == true) goto L30;
        if (r5.isInvalid() == true) goto L30;
        this.mViewInfoStore.addToOldChangeHolders(getChangedHolderKey(r5), r5);
        goto L30
    L17:
        if (this.mAdapter.hasStableIds() == true) goto L19;
    L30:
        r4 = r4 + 1;
    L32:
        if (this.mState.mRunPredictiveAnimations == false) goto L50;
        saveOldPositions();
        boolean r6 = this.mState.mStructureChanged;
        this.mState.mStructureChanged = false;
        this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
        this.mState.mStructureChanged = r6;
        int r7 = 0;
    L35:
        if (r7 >= this.mChildHelper.getChildCount()) goto L49;
        ViewHolder r8 = getChildViewHolderInt(this.mChildHelper.getChildAt(r7));
        if (r8.shouldIgnore() == true) goto L48;
        if (this.mViewInfoStore.isInPreLayout(r8) == true) goto L48;
        int r9 = ItemAnimator.buildAdapterChangeFlagsForAnimations(r8);
        boolean r10 = r8.hasAnyOfTheFlags(8192);
        if (r10 == true) goto L44;
        r9 = r9 | 4096;
    L44:
        ItemAnimator.ItemHolderInfo r11 = this.mItemAnimator.recordPreLayoutInformation(this.mState, r8, r9, r8.getUnmodifiedPayloads());
        if (r10 == false) goto L47;
        recordAnimationInfoIfBouncedHiddenView(r8, r11);
        goto L48
    L47:
        this.mViewInfoStore.addToAppearedInPreLayoutHolders(r8, r11);
    L48:
        r7 = r7 + 1;
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

    private void dispatchLayoutStep2() {
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.assertLayoutStep(6);
        this.mAdapterHelper.consumeUpdatesInOnePass();
        this.mState.mItemCount = this.mAdapter.getItemCount();
        this.mState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
        if (this.mPendingSavedState != null) goto L5;
    L10:
        this.mState.mInPreLayout = false;
        this.mLayout.onLayoutChildren(this.mRecycler, this.mState);
        this.mState.mStructureChanged = false;
        State r0 = this.mState;
        if (r0.mRunSimpleAnimations == true) goto L13;
    L15:
        boolean r2 = false;
    L16:
        r0.mRunSimpleAnimations = r2;
        this.mState.mLayoutStep = 4;
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        return;
    L13:
        if (this.mItemAnimator == null) goto L15;
        r2 = true;
        goto L16
    L5:
        if (this.mAdapter.canRestoreState() == false) goto L10;
        if (this.mPendingSavedState.mLayoutState == null) goto L9;
        this.mLayout.onRestoreInstanceState(this.mPendingSavedState.mLayoutState);
    L9:
        this.mPendingSavedState = null;
        goto L10
    }

    private void dispatchLayoutStep3() {
        this.mState.assertLayoutStep(4);
        startInterceptRequestLayout();
        onEnterLayoutOrScroll();
        this.mState.mLayoutStep = 1;
        if (this.mState.mRunSimpleAnimations == false) goto L24;
        int r0 = this.mChildHelper.getChildCount() - 1;
    L5:
        if (r0 < 0) goto L23;
        ViewHolder r5 = getChildViewHolderInt(this.mChildHelper.getChildAt(r0));
        if (r5.shouldIgnore() == true) goto L22;
        long r2 = getChangedHolderKey(r5);
        ItemAnimator.ItemHolderInfo r4 = this.mItemAnimator.recordPostLayoutInformation(this.mState, r5);
        ViewHolder r6 = this.mViewInfoStore.getFromOldChangeHolders(r2);
        if (r6 != null) goto L12;
    L21:
        this.mViewInfoStore.addToPostLayout(r5, r4);
        goto L22
    L12:
        if (r6.shouldIgnore() == true) goto L21;
        boolean r8 = this.mViewInfoStore.isDisappearing(r6);
        boolean r9 = this.mViewInfoStore.isDisappearing(r5);
        if (r8 == false) goto L17;
        if (r6 != r5) goto L17;
        this.mViewInfoStore.addToPostLayout(r5, r4);
    L17:
        ItemAnimator.ItemHolderInfo r7 = this.mViewInfoStore.popFromPreLayout(r6);
        this.mViewInfoStore.addToPostLayout(r5, r4);
        ItemAnimator.ItemHolderInfo r10 = this.mViewInfoStore.popFromPostLayout(r5);
        if (r7 != null) goto L20;
        handleMissingPreInfoForChangeError(r2, r5, r6);
        goto L22
    L20:
        animateChange(r6, r5, r7, r10, r8, r9);
    L22:
        r0 = r0 - 1;
        goto L5
    L23:
        this.mViewInfoStore.process(this.mViewInfoProcessCallback);
    L24:
        this.mLayout.removeAndRecycleScrapInt(this.mRecycler);
        State r1 = this.mState;
        r1.mPreviousLayoutItemCount = r1.mItemCount;
        this.mDataSetHasChangedAfterLayout = false;
        this.mDispatchItemsChangedEvent = false;
        this.mState.mRunSimpleAnimations = false;
        this.mState.mRunPredictiveAnimations = false;
        this.mLayout.mRequestedSimpleAnimations = false;
        if (this.mRecycler.mChangedScrap == null) goto L28;
        this.mRecycler.mChangedScrap.clear();
    L28:
        if (this.mLayout.mPrefetchMaxObservedInInitialPrefetch == false) goto L30;
        this.mLayout.mPrefetchMaxCountObserved = 0;
        this.mLayout.mPrefetchMaxObservedInInitialPrefetch = false;
        this.mRecycler.updateViewCacheSize();
    L30:
        this.mLayout.onLayoutCompleted(this.mState);
        onExitLayoutOrScroll();
        stopInterceptRequestLayout(false);
        this.mViewInfoStore.clear();
        int[] r3 = this.mMinMaxLayoutPositions;
        if (didChildRangeChange(r3[0], r3[1]) == false) goto L33;
        dispatchOnScrolled(0, 0);
    L33:
        recoverFocusFromState();
        resetFocusInfo();
    }

    private void handleMissingPreInfoForChangeError(long r6, ViewHolder r8, ViewHolder r9) {
        int r0 = this.mChildHelper.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L18;
        ViewHolder r2 = getChildViewHolderInt(this.mChildHelper.getChildAt(r1));
        if (r2 == r8) goto L17;
        if (getChangedHolderKey(r2) != r6) goto L17;
        Adapter r7 = this.mAdapter;
        if (r7 == null) goto L16;
        if (r7.hasStableIds() == false) goto L16;
        throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + r2 + " \n View Holder 2:" + r8 + exceptionLabel());
    L16:
        throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + r2 + " \n View Holder 2:" + r8 + exceptionLabel());
    L17:
        r1 = r1 + 1;
        goto L3
    L18:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + r9 + " cannot be found but it is necessary for " + r8 + exceptionLabel());
    }

    void recordAnimationInfoIfBouncedHiddenView(ViewHolder r4, ItemAnimator.ItemHolderInfo r5) {
        r4.setFlags(0, 8192);
        if (this.mState.mTrackOldChangeHolders == true) goto L5;
    L11:
        this.mViewInfoStore.addToPreLayout(r4, r5);
        return;
    L5:
        if (r4.isUpdated() == false) goto L11;
        if (r4.isRemoved() == true) goto L11;
        if (r4.shouldIgnore() == true) goto L11;
        long r0 = getChangedHolderKey(r4);
        this.mViewInfoStore.addToOldChangeHolders(r0, r4);
        goto L11
    }

    private void findMinMaxChildLayoutPositions(int[] r9) {
        int r0 = this.mChildHelper.getChildCount();
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
        ViewHolder r6 = getChildViewHolderInt(this.mChildHelper.getChildAt(r5));
        if (r6.shouldIgnore() == true) goto L16;
        int r7 = r6.getLayoutPosition();
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
    protected void removeDetachedView(View r3, boolean r4) {
        ViewHolder r0 = getChildViewHolderInt(r3);
        if (r0 == null) goto L13;
        if (r0.isTmpDetached() == false) goto L8;
        r0.clearTmpDetachFlag();
    L14:
        r3.clearAnimation();
        dispatchChildDetached(r3);
        super.removeDetachedView(r3, r4);
        return;
    L8:
        if (r0.shouldIgnore() == true) goto L14;
        throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + r0 + exceptionLabel());
    L13:
        if (sDebugAssertionsEnabled == false) goto L14;
        throw new IllegalArgumentException("No ViewHolder found for child: " + r3 + exceptionLabel());
    }

    long getChangedHolderKey(ViewHolder r1) {
        if (this.mAdapter.hasStableIds() == false) goto L6;
        return r1.getItemId();
    L6:
        return r1.mPosition;
    }

    void animateAppearance(ViewHolder r2, ItemAnimator.ItemHolderInfo r3, ItemAnimator.ItemHolderInfo r4) {
        r2.setIsRecyclable(false);
        if (this.mItemAnimator.animateAppearance(r2, r3, r4) == false) goto L6;
        postAnimationRunner();
        return;
    }

    void animateDisappearance(ViewHolder r2, ItemAnimator.ItemHolderInfo r3, ItemAnimator.ItemHolderInfo r4) {
        addAnimatingView(r2);
        r2.setIsRecyclable(false);
        if (this.mItemAnimator.animateDisappearance(r2, r3, r4) == false) goto L6;
        postAnimationRunner();
        return;
    }

    private void animateChange(ViewHolder r2, ViewHolder r3, ItemAnimator.ItemHolderInfo r4, ItemAnimator.ItemHolderInfo r5, boolean r6, boolean r7) {
        r2.setIsRecyclable(false);
        if (r6 == false) goto L5;
        addAnimatingView(r2);
    L5:
        if (r2 == r3) goto L10;
        if (r7 == false) goto L8;
        addAnimatingView(r3);
    L8:
        r2.mShadowedHolder = r3;
        addAnimatingView(r2);
        this.mRecycler.unscrapView(r2);
        r3.setIsRecyclable(false);
        r3.mShadowingHolder = r2;
    L10:
        if (this.mItemAnimator.animateChange(r2, r3, r4, r5) == false) goto L13;
        postAnimationRunner();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        TraceCompat.beginSection(TRACE_ON_LAYOUT_TAG);
        dispatchLayout();
        TraceCompat.endSection();
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
        int r0 = this.mChildHelper.getUnfilteredChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        ((LayoutParams) this.mChildHelper.getUnfilteredChildAt(r1).getLayoutParams()).mInsetsDirty = true;
        r1 = r1 + 1;
        goto L3
    L5:
        this.mRecycler.markItemDecorInsetsDirty();
    }

    @Override // android.view.View
    public void draw(Canvas r6) {
        super.draw(r6);
        int r0 = this.mItemDecorations.size();
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L6;
        this.mItemDecorations.get(r2).onDrawOver(r6, this, this.mState);
        r2 = r2 + 1;
        goto L3
    L6:
        if (this.mItemAnimator != null) goto L8;
    L12:
        if (r1 == false) goto L16;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L16:
        return;
    L8:
        if (this.mItemDecorations.size() <= 0) goto L12;
        if (this.mItemAnimator.isRunning() == false) goto L12;
        r1 = true;
        goto L12
    }

    @Override // android.view.View
    public void onDraw(Canvas r5) {
        super.onDraw(r5);
        int r0 = this.mItemDecorations.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mItemDecorations.get(r1).onDraw(r5, this, this.mState);
        r1 = r1 + 1;
        goto L3
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas r5) {
        r5.save();
        EdgeEffectAdapter r0 = this.mHorizontalEdgeEffect;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        EdgeEffectAdapter r3 = this.mVerticalEdgeEffect;
        if (r3 != null) goto L11;
    L13:
        r1 = r2;
    L14:
        dispatchBounceTranslationChanged();
        super.dispatchDraw(r5);
        r5.restore();
        if (r1 == false) goto L18;
        ViewCompat.postInvalidateOnAnimation(this);
        return;
    L18:
        return;
    L11:
        if (r3.isFinished() == true) goto L13;
        this.mVerticalEdgeEffect.computeScrollOffset();
        r5.translate(0.0f, this.mVerticalEdgeEffect.getDistance());
        goto L14
    L5:
        if (r0.isFinished() == true) goto L7;
        this.mHorizontalEdgeEffect.computeScrollOffset();
        r5.translate(this.mHorizontalEdgeEffect.getDistance(), 0.0f);
        r2 = true;
        goto L8
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams r2) {
        if ((r2 instanceof LayoutParams) == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mLayout.checkLayoutParams((LayoutParams) r2) == false) goto L7;
        return true;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        LayoutManager r0 = this.mLayout;
        if (r0 == null) goto L7;
        return r0.generateDefaultLayoutParams();
    L7:
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        LayoutManager r0 = this.mLayout;
        if (r0 == null) goto L7;
        return r0.generateLayoutParams(getContext(), r3);
    L7:
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r3) {
        LayoutManager r0 = this.mLayout;
        if (r0 == null) goto L7;
        return r0.generateLayoutParams(r3);
    L7:
        throw new IllegalStateException("RecyclerView has no LayoutManager" + exceptionLabel());
    }

    public boolean isAnimating() {
        ItemAnimator r0 = this.mItemAnimator;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isRunning() == false) goto L7;
        return true;
    }

    void saveOldPositions() {
        int r0 = this.mChildHelper.getUnfilteredChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L17;
        ViewHolder r2 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r1));
        if (sDebugAssertionsEnabled == false) goto L14;
        if (r2.mPosition != (-1)) goto L14;
        if (r2.isRemoved() == true) goto L14;
        throw new IllegalStateException("view holder cannot have position -1 unless it is removed" + exceptionLabel());
    L14:
        if (r2.shouldIgnore() == true) goto L16;
        r2.saveOldPosition();
    L16:
        r1 = r1 + 1;
        goto L3
    }

    void clearOldPositions() {
        int r0 = this.mChildHelper.getUnfilteredChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        ViewHolder r2 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r1));
        if (r2.shouldIgnore() == true) goto L7;
        r2.clearOldPosition();
    L7:
        r1 = r1 + 1;
        goto L3
    L8:
        this.mRecycler.clearOldPositions();
    }

    void offsetPositionRecordsForMove(int r11, int r12) {
        int r0 = this.mChildHelper.getUnfilteredChildCount();
        if (r11 >= r12) goto L5;
        int r2 = -1;
        int r3 = r11;
        int r4 = r12;
    L6:
        int r6 = 0;
    L7:
        if (r6 >= r0) goto L24;
        ViewHolder r7 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r6));
        if (r7 == null) goto L23;
        if (r7.mPosition < r3) goto L23;
        if (r7.mPosition > r4) goto L23;
        if (sVerboseLoggingEnabled == false) goto L19;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "offsetPositionRecordsForMove attached child " + r6 + " holder " + r7);
    L19:
        if (r7.mPosition != r11) goto L21;
        r7.offsetPosition(r12 - r11, false);
    L22:
        this.mState.mStructureChanged = true;
        goto L23
    L21:
        r7.offsetPosition(r2, false);
    L23:
        r6 = r6 + 1;
        goto L7
    L24:
        this.mRecycler.offsetPositionRecordsForMove(r11, r12);
        requestLayout();
        return;
    L5:
        r4 = r11;
        r3 = r12;
        r2 = 1;
        goto L6
    }

    void offsetPositionRecordsForInsert(int r7, int r8) {
        int r0 = this.mChildHelper.getUnfilteredChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L15;
        ViewHolder r3 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r2));
        if (r3 == null) goto L14;
        if (r3.shouldIgnore() == true) goto L14;
        if (r3.mPosition < r7) goto L14;
        if (sVerboseLoggingEnabled == false) goto L13;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "offsetPositionRecordsForInsert attached child " + r2 + " holder " + r3 + " now at position " + (r3.mPosition + r8));
    L13:
        r3.offsetPosition(r8, false);
        this.mState.mStructureChanged = true;
    L14:
        r2 = r2 + 1;
        goto L3
    L15:
        this.mRecycler.offsetPositionRecordsForInsert(r7, r8);
        requestLayout();
    }

    void offsetPositionRecordsForRemove(int r10, int r11, boolean r12) {
        int r0 = r10 + r11;
        int r1 = this.mChildHelper.getUnfilteredChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L21;
        ViewHolder r3 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r2));
        if (r3 == null) goto L20;
        if (r3.shouldIgnore() == true) goto L20;
        if (r3.mPosition < r0) goto L15;
        if (sVerboseLoggingEnabled == false) goto L13;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "offsetPositionRecordsForRemove attached child " + r2 + " holder " + r3 + " now at position " + (r3.mPosition - r11));
    L13:
        r3.offsetPosition(-r11, r12);
        this.mState.mStructureChanged = true;
        goto L20
    L15:
        if (r3.mPosition < r10) goto L20;
        if (sVerboseLoggingEnabled == false) goto L19;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "offsetPositionRecordsForRemove attached child " + r2 + " holder " + r3 + " now REMOVED");
    L19:
        r3.flagRemovedAndOffsetPosition(r10 - 1, -r11, r12);
        this.mState.mStructureChanged = true;
    L20:
        r2 = r2 + 1;
        goto L3
    L21:
        this.mRecycler.offsetPositionRecordsForRemove(r10, r11, r12);
        requestLayout();
    }

    void viewRangeUpdate(int r7, int r8, Object r9) {
        int r0 = this.mChildHelper.getUnfilteredChildCount();
        int r1 = r7 + r8;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L15;
        View r3 = this.mChildHelper.getUnfilteredChildAt(r2);
        ViewHolder r4 = getChildViewHolderInt(r3);
        if (r4 == null) goto L14;
        if (r4.shouldIgnore() == true) goto L14;
        if (r4.mPosition < r7) goto L14;
        if (r4.mPosition >= r1) goto L14;
        r4.addFlags(2);
        r4.addChangePayload(r9);
        ((LayoutParams) r3.getLayoutParams()).mInsetsDirty = true;
    L14:
        r2 = r2 + 1;
        goto L3
    L15:
        this.mRecycler.viewRangeUpdate(r7, r8);
    }

    boolean canReuseUpdatedViewHolder(ViewHolder r2) {
        ItemAnimator r1 = this.mItemAnimator;
        if (r1 != null) goto L5;
    L8:
        return true;
    L5:
        if (r1.canReuseUpdatedViewHolder(r2, r2.getUnmodifiedPayloads()) == true) goto L8;
        return false;
    }

    void processDataSetCompletelyChanged(boolean r2) {
        this.mDispatchItemsChangedEvent = r2 | this.mDispatchItemsChangedEvent;
        this.mDataSetHasChangedAfterLayout = true;
        markKnownViewsInvalid();
    }

    void markKnownViewsInvalid() {
        int r0 = this.mChildHelper.getUnfilteredChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        ViewHolder r2 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r1));
        if (r2 == null) goto L9;
        if (r2.shouldIgnore() == true) goto L9;
        r2.addFlags(6);
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        markItemDecorInsetsDirty();
        this.mRecycler.markKnownViewsInvalid();
    }

    public void invalidateItemDecorations() {
        if (this.mItemDecorations.size() != 0) goto L5;
        return;
    L5:
        LayoutManager r0 = this.mLayout;
        if (r0 == null) goto L8;
        r0.assertNotInLayoutOrScroll("Cannot invalidate item decorations during a scroll or layout");
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

    public ViewHolder getChildViewHolder(View r4) {
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
        if ((r0 instanceof View) == false) goto L8;
        r3 = r0;
        r0 = r3.getParent();
    L8:
        if (r0 == this) goto L15;
        return null;
    L15:
        return r3;
    }

    public ViewHolder findContainingViewHolder(View r1) {
        View r2 = findContainingItemView(r1);
        if (r2 != null) goto L6;
        return null;
    L6:
        return getChildViewHolder(r2);
    }

    static ViewHolder getChildViewHolderInt(View r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return ((LayoutParams) r0.getLayoutParams()).mViewHolder;
    }

    @Deprecated
    public int getChildPosition(View r1) {
        return getChildAdapterPosition(r1);
    }

    public int getChildAdapterPosition(View r1) {
        ViewHolder r0 = getChildViewHolderInt(r1);
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getAbsoluteAdapterPosition();
    }

    public int getChildLayoutPosition(View r1) {
        ViewHolder r0 = getChildViewHolderInt(r1);
        if (r0 != null) goto L7;
        return -1;
    L7:
        return r0.getLayoutPosition();
    }

    public long getChildItemId(View r3) {
        Adapter r2 = this.mAdapter;
        if (r2 != null) goto L5;
        return -1;
    L5:
        if (r2.hasStableIds() == false) goto L13;
        ViewHolder r4 = getChildViewHolderInt(r3);
        if (r4 != null) goto L10;
        return -1;
    L10:
        return r4.getItemId();
    L13:
        return -1;
    }

    @Deprecated
    public ViewHolder findViewHolderForPosition(int r2) {
        return findViewHolderForPosition(r2, false);
    }

    public ViewHolder findViewHolderForLayoutPosition(int r2) {
        return findViewHolderForPosition(r2, false);
    }

    public ViewHolder findViewHolderForAdapterPosition(int r6) {
        ViewHolder r1 = null;
        if (this.mDataSetHasChangedAfterLayout == false) goto L5;
        return null;
    L5:
        int r0 = this.mChildHelper.getUnfilteredChildCount();
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L18;
        ViewHolder r3 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r2));
        if (r3 == null) goto L17;
        if (r3.isRemoved() == true) goto L17;
        if (getAdapterPositionInRecyclerView(r3) != r6) goto L17;
        if (this.mChildHelper.isHidden(r3.itemView) == false) goto L16;
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

    ViewHolder findViewHolderForPosition(int r6, boolean r7) {
        int r0 = this.mChildHelper.getUnfilteredChildCount();
        ViewHolder r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L20;
        ViewHolder r3 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r2));
        if (r3 == null) goto L19;
        if (r3.isRemoved() == true) goto L19;
        if (r7 == false) goto L13;
        if (r3.mPosition != r6) goto L19;
    L16:
        if (this.mChildHelper.isHidden(r3.itemView) == false) goto L18;
        r1 = r3;
        goto L19
    L18:
        return r3;
    L13:
        if (r3.getLayoutPosition() == r6) goto L16;
    L19:
        r2 = r2 + 1;
        goto L3
    L20:
        return r1;
    }

    public ViewHolder findViewHolderForItemId(long r7) {
        Adapter r0 = this.mAdapter;
        ViewHolder r1 = null;
        if (r0 != null) goto L5;
    L20:
        return r1;
    L5:
        if (r0.hasStableIds() == false) goto L20;
        int r2 = this.mChildHelper.getUnfilteredChildCount();
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L20;
        ViewHolder r4 = getChildViewHolderInt(this.mChildHelper.getUnfilteredChildAt(r3));
        if (r4 == null) goto L19;
        if (r4.isRemoved() == true) goto L19;
        if (r4.getItemId() != r7) goto L19;
        if (this.mChildHelper.isHidden(r4.itemView) == false) goto L18;
        r1 = r4;
        goto L19
    L18:
        return r4;
    L19:
        r3 = r3 + 1;
        goto L8
    }

    public View findChildViewUnder(float r6, float r7) {
        int r0 = this.mChildHelper.getChildCount() - 1;
    L3:
        if (r0 < 0) goto L14;
        View r1 = this.mChildHelper.getChildAt(r0);
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
        int r0 = this.mChildHelper.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mChildHelper.getChildAt(r1).offsetTopAndBottom(r4);
        r1 = r1 + 1;
        goto L3
    }

    public void offsetChildrenHorizontal(int r4) {
        int r0 = this.mChildHelper.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mChildHelper.getChildAt(r1).offsetLeftAndRight(r4);
        r1 = r1 + 1;
        goto L3
    }

    public void getDecoratedBoundsWithMargins(View r1, Rect r2) {
        getDecoratedBoundsWithMarginsInt(r1, r2);
    }

    static void getDecoratedBoundsWithMarginsInt(View r6, Rect r7) {
        LayoutParams r0 = (LayoutParams) r6.getLayoutParams();
        Rect r1 = r0.mDecorInsets;
        r7.set((r6.getLeft() - r1.left) - r0.leftMargin, (r6.getTop() - r1.top) - r0.topMargin, (r6.getRight() + r1.right) + r0.rightMargin, (r6.getBottom() + r1.bottom) + r0.bottomMargin);
    }

    Rect getItemDecorInsetsForChild(View r9) {
        LayoutParams r0 = (LayoutParams) r9.getLayoutParams();
        if (r0.mInsetsDirty == true) goto L7;
        return r0.mDecorInsets;
    L7:
        if (this.mState.isPreLayout() == true) goto L9;
    L14:
        Rect r1 = r0.mDecorInsets;
        r1.set(0, 0, 0, 0);
        int r3 = this.mItemDecorations.size();
        int r4 = 0;
    L15:
        if (r4 >= r3) goto L17;
        this.mTempRect.set(0, 0, 0, 0);
        this.mItemDecorations.get(r4).getItemOffsets(this.mTempRect, r9, this, this.mState);
        r1.left += this.mTempRect.left;
        r1.top += this.mTempRect.top;
        r1.right += this.mTempRect.right;
        r1.bottom += this.mTempRect.bottom;
        r4 = r4 + 1;
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
        OnScrollListener r2 = this.mScrollListener;
        if (r2 == null) goto L5;
        r2.onScrolled(this, r5, r6);
    L5:
        List<OnScrollListener> r3 = this.mScrollListeners;
        if (r3 == null) goto L10;
        int r4 = r3.size() - 1;
    L8:
        if (r4 < 0) goto L10;
        this.mScrollListeners.get(r4).onScrolled(this, r5, r6);
        r4 = r4 - 1;
    L10:
        this.mDispatchScrollCounter--;
    }

    private float getSplineFlingDistance(int r9) {
        double r2 = Math.log((Math.abs(r9) * INFLEXION) / (this.mPhysicalCoef * SCROLL_FRICTION));
        float r10 = DECELERATION_RATE;
        return (float) ((this.mPhysicalCoef * SCROLL_FRICTION) * Math.exp((r10 / (((double) r10) - 1.0d)) * r2));
    }

    void dispatchOnScrollStateChanged(int r3) {
        LayoutManager r0 = this.mLayout;
        if (r0 == null) goto L5;
        r0.onScrollStateChanged(r3);
    L5:
        onScrollStateChanged(r3);
        OnScrollListener r1 = this.mScrollListener;
        if (r1 == null) goto L8;
        r1.onScrollStateChanged(this, r3);
    L8:
        List<OnScrollListener> r2 = this.mScrollListeners;
        if (r2 == null) goto L13;
        int r4 = r2.size() - 1;
    L11:
        if (r4 < 0) goto L15;
        this.mScrollListeners.get(r4).onScrollStateChanged(this, r3);
        r4 = r4 - 1;
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
        if (this.mAdapterHelper.hasPendingUpdates() == true) goto L10;
        return false;
    }

    void repositionShadowingViews() {
        int r0 = this.mChildHelper.getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L14;
        View r2 = this.mChildHelper.getChildAt(r1);
        ViewHolder r3 = getChildViewHolder(r2);
        if (r3 == null) goto L13;
        if (r3.mShadowingHolder == null) goto L13;
        View r4 = r3.mShadowingHolder.itemView;
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
        if ((r4 instanceof ViewGroup) == true) goto L6;
        return null;
    L6:
        if ((r4 instanceof RecyclerView) == true) goto L8;
        ViewGroup r5 = (ViewGroup) r4;
        int r0 = r5.getChildCount();
        int r2 = 0;
    L10:
        if (r2 >= r0) goto L15;
        RecyclerView r3 = findNestedRecyclerView(r5.getChildAt(r2));
        if (r3 != null) goto L13;
        r2 = r2 + 1;
        goto L10
    L13:
        return r3;
    L15:
        return null;
    L8:
        return (RecyclerView) r4;
    }

    static void clearNestedRecyclerViewIfNotNested(ViewHolder r3) {
        if (r3.mNestedRecyclerView == null) goto L23;
        RecyclerView r0 = r3.mNestedRecyclerView.get();
    L6:
        if (r0 == null) goto L14;
        if (r0 == r3.itemView) goto L9;
        Object r1 = r0.getParent();
        if ((r1 instanceof View) == true) goto L12;
        r0 = null;
        goto L6
    L12:
        r0 = (View) r1;
        goto L6
    L9:
        return;
    L14:
        r3.mNestedRecyclerView = null;
        return;
    }

    long getNanoTime() {
        if (ALLOW_THREAD_GAP_WORK == true) goto L5;
        return 0;
    L5:
        return System.nanoTime();
    }

    public void setEnableOverFling(boolean r1) {
        this.mEnableOverFling = r1;
    }

    public void avoidStateChangeInAnim() {
        this.mAvoidStateChangeInAnim = true;
    }

    void dispatchChildDetached(View r3) {
        ViewHolder r0 = getChildViewHolderInt(r3);
        onChildDetachedFromWindow(r3);
        Adapter r1 = this.mAdapter;
        if (r1 == null) goto L6;
        if (r0 == null) goto L6;
        r1.onViewDetachedFromWindow(r0);
    L6:
        List<OnChildAttachStateChangeListener> r2 = this.mOnChildAttachStateListeners;
        if (r2 == null) goto L11;
        int r4 = r2.size() - 1;
    L9:
        if (r4 < 0) goto L13;
        this.mOnChildAttachStateListeners.get(r4).onChildViewDetachedFromWindow(r3);
        r4 = r4 - 1;
        goto L9
    L13:
        return;
    }

    void dispatchChildAttached(View r3) {
        ViewHolder r0 = getChildViewHolderInt(r3);
        onChildAttachedToWindow(r3);
        Adapter r1 = this.mAdapter;
        if (r1 == null) goto L6;
        if (r0 == null) goto L6;
        r1.onViewAttachedToWindow(r0);
    L6:
        List<OnChildAttachStateChangeListener> r2 = this.mOnChildAttachStateListeners;
        if (r2 == null) goto L11;
        int r4 = r2.size() - 1;
    L9:
        if (r4 < 0) goto L13;
        this.mOnChildAttachStateListeners.get(r4).onChildViewAttachedToWindow(r3);
        r4 = r4 - 1;
        goto L9
    L13:
        return;
    }

    boolean setChildImportantForAccessibilityInternal(ViewHolder r2, int r3) {
        if (isComputingLayout() == false) goto L6;
        r2.mPendingAccessibilityState = r3;
        this.mPendingAccessibilityImportanceChange.add(r2);
        return false;
    L6:
        ViewCompat.setImportantForAccessibility(r2.itemView, r3);
        return true;
    }

    void dispatchPendingImportantForAccessibilityChanges() {
        int r0 = this.mPendingAccessibilityImportanceChange.size() - 1;
    L3:
        if (r0 < 0) goto L13;
        ViewHolder r1 = this.mPendingAccessibilityImportanceChange.get(r0);
        if (r1.itemView.getParent() != this) goto L12;
        if (r1.shouldIgnore() == true) goto L12;
        int r2 = r1.mPendingAccessibilityState;
        if (r2 == (-1)) goto L12;
        ViewCompat.setImportantForAccessibility(r1.itemView, r2);
        r1.mPendingAccessibilityState = -1;
    L12:
        r0 = r0 - 1;
        goto L3
    L13:
        this.mPendingAccessibilityImportanceChange.clear();
    }

    int getAdapterPositionInRecyclerView(ViewHolder r2) {
        if (r2.hasAnyOfTheFlags(524) == false) goto L5;
        return -1;
    L5:
        if (r2.isBound() == true) goto L8;
        return -1;
    L8:
        return this.mAdapterHelper.applyPendingUpdatesToPosition(r2.mPosition);
    }

    void initFastScroller(StateListDrawable r11, Drawable r12, StateListDrawable r13, Drawable r14) {
        if (r11 == null) goto L9;
        if (r12 == null) goto L9;
        if (r13 == null) goto L9;
        if (r14 == null) goto L9;
        Resources r0 = getContext().getResources();
        new FastScroller(this, r11, r12, r13, r14, r0.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), r0.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), r0.getDimensionPixelOffset(R.dimen.fastscroll_margin));
        return;
    L9:
        throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + exceptionLabel());
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean r1) {
        getScrollingChildHelper().setNestedScrollingEnabled(r1);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().isNestedScrollingEnabled();
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int r1) {
        return getScrollingChildHelper().startNestedScroll(r1);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean startNestedScroll(int r1, int r2) {
        return getScrollingChildHelper().startNestedScroll(r1, r2);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        getScrollingChildHelper().stopNestedScroll();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public void stopNestedScroll(int r1) {
        getScrollingChildHelper().stopNestedScroll(r1);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().hasNestedScrollingParent();
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean hasNestedScrollingParent(int r1) {
        return getScrollingChildHelper().hasNestedScrollingParent(r1);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int r7, int r8, int r9, int r10, int[] r11) {
        return getScrollingChildHelper().dispatchNestedScroll(r7, r8, r9, r10, r11);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int r8, int r9, int r10, int r11, int[] r12, int r13) {
        return getScrollingChildHelper().dispatchNestedScroll(r8, r9, r10, r11, r12, r13);
    }

    @Override // androidx.core.view.NestedScrollingChild3
    public final void dispatchNestedScroll(int r9, int r10, int r11, int r12, int[] r13, int r14, int[] r15) {
        getScrollingChildHelper().dispatchNestedScroll(r9, r10, r11, r12, r13, r14, r15);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int r1, int r2, int[] r3, int[] r4) {
        return getScrollingChildHelper().dispatchNestedPreScroll(r1, r2, r3, r4);
    }

    @Override // androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int r7, int r8, int[] r9, int[] r10, int r11) {
        return getScrollingChildHelper().dispatchNestedPreScroll(r7, r8, r9, r10, r11);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float r1, float r2, boolean r3) {
        return getScrollingChildHelper().dispatchNestedFling(r1, r2, r3);
    }

    @Override // android.view.View, androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float r1, float r2) {
        return getScrollingChildHelper().dispatchNestedPreFling(r1, r2);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int r2, int r3) {
        ChildDrawingOrderCallback r0 = this.mChildDrawingOrderCallback;
        if (r0 != null) goto L7;
        return super.getChildDrawingOrder(r2, r3);
    L7:
        return r0.onGetChildDrawingOrder(r2, r3);
    }

    private NestedScrollingChildHelper getScrollingChildHelper() {
        if (this.mScrollingChildHelper != null) goto L6;
        this.mScrollingChildHelper = new NestedScrollingChildHelper(this);
    L6:
        return this.mScrollingChildHelper;
    }

    public void allowClickDuringOverScroll(boolean r1) {
        this.mRecyclerViewExt.allowClickDuringOverScroll(r1);
    }
}
