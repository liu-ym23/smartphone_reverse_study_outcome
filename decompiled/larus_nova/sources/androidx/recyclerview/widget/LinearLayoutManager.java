package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class LinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler, RecyclerView.SmoothScroller.ScrollVectorProvider {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final AnchorInfo mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final LayoutChunkResult mLayoutChunkResult;
    private LayoutState mLayoutState;
    int mOrientation;
    OrientationHelper mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    public static class AnchorInfo {
        int mCoordinate;
        boolean mLayoutFromEnd;
        OrientationHelper mOrientationHelper;
        int mPosition;
        boolean mValid;

        public void reset() {
            this.mPosition = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            this.mLayoutFromEnd = false;
            this.mValid = false;
        }

        public void assignCoordinateFromPadding() {
            if (this.mLayoutFromEnd == false) goto L5;
            int r100 = this.mOrientationHelper.getEndAfterPadding();
        L6:
            this.mCoordinate = r100;
            return;
        L5:
            r100 = this.mOrientationHelper.getStartAfterPadding();
            goto L6
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.mCoordinate + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + '}';
        }

        public AnchorInfo() {
            reset();
        }

        public void assignFromView(View r100, int r101) {
            if (this.mLayoutFromEnd == false) goto L5;
            this.mCoordinate = this.mOrientationHelper.getDecoratedEnd(r100) + this.mOrientationHelper.getTotalSpaceChange();
        L6:
            this.mPosition = r101;
            return;
        L5:
            this.mCoordinate = this.mOrientationHelper.getDecoratedStart(r100);
            goto L6
        }

        public void assignFromViewAndKeepVisibleRect(View r100, int r101) {
            int r102 = this.mOrientationHelper.getTotalSpaceChange();
            if (r102 < 0) goto L6;
            assignFromView(r100, r101);
            return;
        L6:
            this.mPosition = r101;
            if (this.mLayoutFromEnd == false) goto L13;
            int r103 = (this.mOrientationHelper.getEndAfterPadding() - r102) - this.mOrientationHelper.getDecoratedEnd(r100);
            this.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - r103;
            if (r103 <= 0) goto L19;
            int r104 = this.mCoordinate - this.mOrientationHelper.getDecoratedMeasurement(r100);
            int r105 = this.mOrientationHelper.getStartAfterPadding();
            int r106 = r104 - (r105 + Math.min(this.mOrientationHelper.getDecoratedStart(r100) - r105, 0));
            if (r106 >= 0) goto L20;
            this.mCoordinate += Math.min(r103, -r106);
            return;
        L20:
            return;
        L19:
            return;
        L13:
            int r107 = this.mOrientationHelper.getDecoratedStart(r100);
            int r108 = r107 - this.mOrientationHelper.getStartAfterPadding();
            this.mCoordinate = r107;
            if (r108 <= 0) goto L22;
            int r109 = (this.mOrientationHelper.getEndAfterPadding() - Math.min(0, (this.mOrientationHelper.getEndAfterPadding() - r102) - this.mOrientationHelper.getDecoratedEnd(r100))) - (r107 + this.mOrientationHelper.getDecoratedMeasurement(r100));
            if (r109 >= 0) goto L23;
            this.mCoordinate -= Math.min(r108, -r109);
            return;
        L23:
            return;
        }

        public boolean isViewValidAsAnchor(View r100, RecyclerView.State r101) {
            RecyclerView.LayoutParams r102 = (RecyclerView.LayoutParams) r100.getLayoutParams();
            if (r102.isItemRemoved() == false) goto L5;
        L9:
            return false;
        L5:
            if (r102.getViewLayoutPosition() < 0) goto L9;
            if (r102.getViewLayoutPosition() >= r101.getItemCount()) goto L9;
            return true;
        }
    }

    public static class LayoutChunkResult {
        public int mConsumed;
        public boolean mFinished;
        public boolean mFocusable;
        public boolean mIgnoreConsumed;

        public LayoutChunkResult() {
        }

        public void resetInternal() {
            this.mConsumed = 0;
            this.mFinished = false;
            this.mIgnoreConsumed = false;
            this.mFocusable = false;
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class LayoutState {
        static final int INVALID_LAYOUT = Integer.MIN_VALUE;
        static final int ITEM_DIRECTION_HEAD = -1;
        static final int ITEM_DIRECTION_TAIL = 1;
        static final int LAYOUT_END = 1;
        static final int LAYOUT_START = -1;
        static final int SCROLLING_OFFSET_NaN = Integer.MIN_VALUE;
        static final String TAG = "LLM#LayoutState";
        int mAvailable;
        int mCurrentPosition;
        int mExtraFillSpace;
        boolean mInfinite;
        boolean mIsPreLayout;
        int mItemDirection;
        int mLastScrollDelta;
        int mLayoutDirection;
        int mNoRecycleSpace;
        int mOffset;
        boolean mRecycle;
        List<RecyclerView.ViewHolder> mScrapList;
        int mScrollingOffset;

        public void assignPositionFromScrapList() {
            assignPositionFromScrapList(null);
        }

        private View nextViewFromScrapList() {
            int r100 = this.mScrapList.size();
            int r101 = 0;
        L3:
            if (r101 >= r100) goto L12;
            View r102 = ((RecyclerView.ViewHolder) ListProtector.get(this.mScrapList, r101)).itemView;
            RecyclerView.LayoutParams r103 = (RecyclerView.LayoutParams) r102.getLayoutParams();
            if (r103.isItemRemoved() == true) goto L11;
            if (this.mCurrentPosition != r103.getViewLayoutPosition()) goto L11;
            assignPositionFromScrapList(r102);
            return r102;
        L11:
            r101 = r101 + 1;
            goto L3
        L12:
            return null;
        }

        public LayoutState() {
            this.mRecycle = true;
            this.mExtraFillSpace = 0;
            this.mNoRecycleSpace = 0;
            this.mIsPreLayout = false;
            this.mScrapList = null;
        }

        public void log() {
        }

        public void assignPositionFromScrapList(View r100) {
            View r101 = nextViewInLimitedList(r100);
            if (r101 != null) goto L5;
            this.mCurrentPosition = -1;
            return;
        L5:
            this.mCurrentPosition = ((RecyclerView.LayoutParams) r101.getLayoutParams()).getViewLayoutPosition();
        }

        public boolean hasMore(RecyclerView.State r100) {
            int r101 = this.mCurrentPosition;
            if (r101 >= 0) goto L5;
        L7:
            return false;
        L5:
            if (r101 >= r100.getItemCount()) goto L7;
            return true;
        }

        public View next(RecyclerView.Recycler r100) {
            if (this.mScrapList != null) goto L5;
            View r101 = r100.getViewForPosition(this.mCurrentPosition);
            this.mCurrentPosition += this.mItemDirection;
            return r101;
        L5:
            return nextViewFromScrapList();
        }

        public View nextViewInLimitedList(View r100) {
            int r101 = this.mScrapList.size();
            View r102 = null;
            int r103 = Integer.MAX_VALUE;
            int r104 = 0;
        L3:
            if (r104 >= r101) goto L18;
            View r105 = ((RecyclerView.ViewHolder) ListProtector.get(this.mScrapList, r104)).itemView;
            RecyclerView.LayoutParams r106 = (RecyclerView.LayoutParams) r105.getLayoutParams();
            if (r105 == r100) goto L17;
            if (r106.isItemRemoved() == true) goto L17;
            int r107 = (r106.getViewLayoutPosition() - this.mCurrentPosition) * this.mItemDirection;
            if (r107 < 0) goto L17;
            if (r107 >= r103) goto L17;
            r102 = r105;
            if (r107 == 0) goto L18;
            r103 = r107;
        L17:
            r104 = r104 + 1;
        L18:
            return r102;
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean mAnchorLayoutFromEnd;
        int mAnchorOffset;
        int mAnchorPosition;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public boolean hasValidAnchor() {
            if (this.mAnchorPosition < 0) goto L5;
            return true;
        L5:
            return false;
        }

        public SavedState() {
        }

        public SavedState(Parcel r100) {
            this.mAnchorPosition = r100.readInt();
            this.mAnchorOffset = r100.readInt();
            boolean r101 = true;
            if (r100.readInt() == 1) goto L6;
            r101 = false;
        L6:
            this.mAnchorLayoutFromEnd = r101;
        }

        public SavedState(SavedState r100) {
            this.mAnchorPosition = r100.mAnchorPosition;
            this.mAnchorOffset = r100.mAnchorOffset;
            this.mAnchorLayoutFromEnd = r100.mAnchorLayoutFromEnd;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(this.mAnchorPosition);
            r100.writeInt(this.mAnchorOffset);
            r100.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
        }
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private void logChildren() {
        int r100 = 0;
    L4:
        if (r100 >= getChildCount()) goto L6;
        View r101 = getChildAt(r100);
        getPosition(r101);
        this.mOrientationHelper.getDecoratedStart(r101);
        r100 = r100 + 1;
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public void onAnchorReady(RecyclerView.Recycler r100, RecyclerView.State r101, AnchorInfo r102, int r103) {
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        if (this.mShouldReverseLayout == false) goto L6;
        return findFirstPartiallyOrCompletelyInvisibleChild();
    L6:
        return findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        if (this.mShouldReverseLayout == false) goto L6;
        return findLastPartiallyOrCompletelyInvisibleChild();
    L6:
        return findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private View getChildClosestToEnd() {
        if (this.mShouldReverseLayout == false) goto L5;
        int r100 = 0;
    L7:
        return getChildAt(r100);
    L5:
        r100 = getChildCount() - 1;
        goto L7
    }

    private View getChildClosestToStart() {
        if (this.mShouldReverseLayout == false) goto L5;
        int r100 = getChildCount() - 1;
    L7:
        return getChildAt(r100);
    L5:
        r100 = 0;
        goto L7
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation != 1) goto L5;
    L8:
        this.mShouldReverseLayout = this.mReverseLayout;
        return;
    L5:
        if (isLayoutRTL() == false) goto L8;
        this.mShouldReverseLayout = !this.mReverseLayout;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.mOrientation != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.mOrientation == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public LayoutState createLayoutState() {
        return new LayoutState();
    }

    public void ensureLayoutState() {
        if (this.mLayoutState != null) goto L6;
        this.mLayoutState = createLayoutState();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) goto L5;
        SavedState r100 = new SavedState();
        if (getChildCount() <= 0) goto L12;
        ensureLayoutState();
        boolean r101 = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
        r100.mAnchorLayoutFromEnd = r101;
        if (r101 == false) goto L11;
        View r102 = getChildClosestToEnd();
        r100.mAnchorOffset = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(r102);
        r100.mAnchorPosition = getPosition(r102);
    L13:
        return r100;
    L11:
        View r103 = getChildClosestToStart();
        r100.mAnchorPosition = getPosition(r103);
        r100.mAnchorOffset = this.mOrientationHelper.getDecoratedStart(r103) - this.mOrientationHelper.getStartAfterPadding();
        goto L13
    L12:
        r100.invalidateAnchor();
        goto L13
    L5:
        return new SavedState(this.mPendingSavedState);
    }

    public boolean resolveIsInfinite() {
        if (this.mOrientationHelper.getMode() == 0) goto L5;
    L7:
        return false;
    L5:
        if (this.mOrientationHelper.getEnd() != 0) goto L7;
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState == null) goto L5;
    L7:
        return false;
    L5:
        if (this.mLastStackFromEnd != this.mStackFromEnd) goto L7;
        return true;
    }

    public void validateChildOrder() {
        getChildCount();
        boolean r100 = true;
        if (getChildCount() >= 1) goto L5;
        return;
    L5:
        int r101 = getPosition(getChildAt(0));
        int r102 = this.mOrientationHelper.getDecoratedStart(getChildAt(0));
        if (this.mShouldReverseLayout == false) goto L22;
        int r103 = 1;
    L9:
        if (r103 >= getChildCount()) goto L37;
        View r104 = getChildAt(r103);
        int r105 = getPosition(r104);
        int r106 = this.mOrientationHelper.getDecoratedStart(r104);
        if (r105 < r101) goto L12;
        if (r106 > r102) goto L20;
        r103 = r103 + 1;
        goto L9
    L20:
        logChildren();
        throw new RuntimeException("detected invalid location");
    L12:
        logChildren();
        StringBuilder r107 = new StringBuilder("detected invalid position. loc invalid? ");
        if (r106 < r102) goto L16;
        r100 = false;
    L16:
        r107.append(r100);
        throw new RuntimeException(r107.toString());
    L37:
        return;
    L22:
        int r108 = 1;
    L24:
        if (r108 >= getChildCount()) goto L44;
        View r109 = getChildAt(r108);
        int r110 = getPosition(r109);
        int r111 = this.mOrientationHelper.getDecoratedStart(r109);
        if (r110 < r101) goto L27;
        if (r111 < r102) goto L35;
        r108 = r108 + 1;
        goto L24
    L35:
        logChildren();
        throw new RuntimeException("detected invalid location");
    L27:
        logChildren();
        StringBuilder r112 = new StringBuilder("detected invalid position. loc invalid? ");
        if (r111 < r102) goto L31;
        r100 = false;
    L31:
        r112.append(r100);
        throw new RuntimeException(r112.toString());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View r100 = findOneVisibleChild(0, getChildCount(), true, false);
        if (r100 != null) goto L6;
        return -1;
    L6:
        return getPosition(r100);
    }

    public int findFirstVisibleItemPosition() {
        View r100 = findOneVisibleChild(0, getChildCount(), false, true);
        if (r100 != null) goto L6;
        return -1;
    L6:
        return getPosition(r100);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View r100 = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (r100 != null) goto L6;
        return -1;
    L6:
        return getPosition(r100);
    }

    public int findLastVisibleItemPosition() {
        View r100 = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (r100 != null) goto L6;
        return -1;
    L6:
        return getPosition(r100);
    }

    public boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean shouldMeasureTwice() {
        if (getHeightMode() != 1073741824) goto L5;
    L9:
        return false;
    L5:
        if (getWidthMode() == 1073741824) goto L9;
        if (hasFlexibleChildInBothOrientations() == false) goto L9;
        return true;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    public LinearLayoutManager(Context r100) {
        this(r100, 1, false);
    }

    private int computeScrollExtent(RecyclerView.State r100) {
        if (getChildCount() != 0) goto L6;
        return 0;
    L6:
        ensureLayoutState();
        return ScrollbarHelper.computeScrollExtent(r100, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.State r100) {
        if (getChildCount() != 0) goto L6;
        return 0;
    L6:
        ensureLayoutState();
        return ScrollbarHelper.computeScrollOffset(r100, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.State r100) {
        if (getChildCount() != 0) goto L6;
        return 0;
    L6:
        ensureLayoutState();
        return ScrollbarHelper.computeScrollRange(r100, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private void updateLayoutStateToFillEnd(AnchorInfo r100) {
        updateLayoutStateToFillEnd(r100.mPosition, r100.mCoordinate);
    }

    private void updateLayoutStateToFillStart(AnchorInfo r100) {
        updateLayoutStateToFillStart(r100.mPosition, r100.mCoordinate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String r100) {
        if (this.mPendingSavedState != null) goto L6;
        super.assertNotInLayoutOrScroll(r100);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State r100) {
        return computeScrollExtent(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State r100) {
        return computeScrollOffset(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State r100) {
        return computeScrollRange(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int r100) {
        if (getChildCount() != 0) goto L6;
        return null;
    L6:
        boolean r101 = false;
        int r102 = 1;
        if (r100 >= getPosition(getChildAt(0))) goto L10;
        r101 = true;
    L10:
        if (r101 == this.mShouldReverseLayout) goto L13;
        r102 = -1;
    L13:
        if (this.mOrientation != 0) goto L17;
        return new PointF(r102, 0.0f);
    L17:
        return new PointF(0.0f, r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State r100) {
        return computeScrollExtent(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State r100) {
        return computeScrollOffset(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State r100) {
        return computeScrollRange(r100);
    }

    public int convertFocusDirectionToLayoutDirection(int r100) {
        if (r100 == 1) goto L43;
        if (r100 == 2) goto L36;
        if (r100 == 17) goto L31;
        if (r100 == 33) goto L26;
        if (r100 == 66) goto L21;
        if (r100 == 130) goto L16;
        return Integer.MIN_VALUE;
    L16:
        if (this.mOrientation == 1) goto L49;
        return Integer.MIN_VALUE;
    L49:
        return 1;
    L21:
        if (this.mOrientation == 0) goto L50;
        return Integer.MIN_VALUE;
    L50:
        return 1;
    L26:
        if (this.mOrientation == 1) goto L51;
        return Integer.MIN_VALUE;
    L51:
        return -1;
    L31:
        if (this.mOrientation == 0) goto L52;
        return Integer.MIN_VALUE;
    L52:
        return -1;
    L36:
        if (this.mOrientation != 1) goto L39;
        return 1;
    L39:
        if (isLayoutRTL() == false) goto L41;
        return -1;
    L41:
        return 1;
    L43:
        if (this.mOrientation != 1) goto L46;
        return -1;
    L46:
        if (isLayoutRTL() == false) goto L48;
        return 1;
    L48:
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View findViewByPosition(int r100) {
        int r101 = getChildCount();
        if (r101 != 0) goto L6;
        return null;
    L6:
        int r102 = r100 - getPosition(getChildAt(0));
        if (r102 < 0) goto L13;
        if (r102 >= r101) goto L13;
        View r103 = getChildAt(r102);
        if (getPosition(r103) != r100) goto L13;
        return r103;
    L13:
        return super.findViewByPosition(r100);
    }

    public int getExtraLayoutSpace(RecyclerView.State r100) {
        if (r100.hasTargetScrollPosition() == true) goto L5;
        return 0;
    L5:
        return this.mOrientationHelper.getTotalSpace();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent r100) {
        super.onInitializeAccessibilityEvent(r100);
        if (getChildCount() <= 0) goto L6;
        r100.setFromIndex(findFirstVisibleItemPosition());
        r100.setToIndex(findLastVisibleItemPosition());
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State r100) {
        super.onLayoutCompleted(r100);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.reset();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == false) goto L9;
        SavedState r101 = (SavedState) r100;
        this.mPendingSavedState = r101;
        if (this.mPendingScrollPosition == (-1)) goto L7;
        r101.invalidateAnchor();
    L7:
        requestLayout();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int r100) {
        this.mPendingScrollPosition = r100;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState r101 = this.mPendingSavedState;
        if (r101 == null) goto L5;
        r101.invalidateAnchor();
    L5:
        requestLayout();
    }

    public void setInitialPrefetchItemCount(int r100) {
        this.mInitialPrefetchItemCount = r100;
    }

    public void setOrientation(int r100) {
        if (r100 != 0) goto L4;
    L8:
        assertNotInLayoutOrScroll(null);
        if (r100 == this.mOrientation) goto L11;
    L12:
        OrientationHelper r101 = OrientationHelper.createOrientationHelper(this, r100);
        this.mOrientationHelper = r101;
        this.mAnchorInfo.mOrientationHelper = r101;
        this.mOrientation = r100;
        requestLayout();
        return;
    L11:
        if (this.mOrientationHelper == null) goto L12;
        return;
    L4:
        if (r100 == 1) goto L8;
        throw new IllegalArgumentException("invalid orientation:" + r100);
    }

    public void setRecycleChildrenOnDetach(boolean r100) {
        this.mRecycleChildrenOnDetach = r100;
    }

    public void setReverseLayout(boolean r100) {
        assertNotInLayoutOrScroll(null);
        if (r100 != this.mReverseLayout) goto L5;
        return;
    L5:
        this.mReverseLayout = r100;
        requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean r100) {
        this.mSmoothScrollbarEnabled = r100;
    }

    public void setStackFromEnd(boolean r100) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd != r100) goto L5;
        return;
    L5:
        this.mStackFromEnd = r100;
        requestLayout();
    }

    private void recycleByLayoutState(RecyclerView.Recycler r100, LayoutState r101) {
        if (r101.mRecycle == true) goto L5;
        return;
    L5:
        if (r101.mInfinite == true) goto L14;
        int r102 = r101.mScrollingOffset;
        int r103 = r101.mNoRecycleSpace;
        if (r101.mLayoutDirection != (-1)) goto L10;
        recycleViewsFromEnd(r100, r102, r103);
        return;
    L10:
        recycleViewsFromStart(r100, r102, r103);
        return;
    }

    private boolean updateAnchorFromPendingData(RecyclerView.State r100, AnchorInfo r101) {
        boolean r102 = false;
        if (r100.isPreLayout() == true) goto L60;
        int r103 = this.mPendingScrollPosition;
        if (r103 == (-1)) goto L60;
        if (r103 >= 0) goto L10;
    L59:
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        goto L60
    L10:
        if (r103 >= r100.getItemCount()) goto L59;
        r101.mPosition = this.mPendingScrollPosition;
        SavedState r104 = this.mPendingSavedState;
        if (r104 == null) goto L22;
        if (r104.hasValidAnchor() == false) goto L22;
        boolean r105 = this.mPendingSavedState.mAnchorLayoutFromEnd;
        r101.mLayoutFromEnd = r105;
        if (r105 == false) goto L19;
        r101.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset;
    L20:
        return true;
    L19:
        r101.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset;
    L22:
        if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) goto L54;
        View r106 = findViewByPosition(this.mPendingScrollPosition);
        if (r106 == null) goto L43;
        if (this.mOrientationHelper.getDecoratedMeasurement(r106) <= this.mOrientationHelper.getTotalSpace()) goto L30;
        r101.assignCoordinateFromPadding();
        return true;
    L30:
        if ((this.mOrientationHelper.getDecoratedStart(r106) - this.mOrientationHelper.getStartAfterPadding()) >= 0) goto L34;
        r101.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
        r101.mLayoutFromEnd = false;
        return true;
    L34:
        if ((this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(r106)) >= 0) goto L38;
        r101.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
        r101.mLayoutFromEnd = true;
        return true;
    L38:
        if (r101.mLayoutFromEnd == false) goto L40;
        int r107 = this.mOrientationHelper.getDecoratedEnd(r106) + this.mOrientationHelper.getTotalSpaceChange();
    L41:
        r101.mCoordinate = r107;
    L53:
        return true;
    L40:
        r107 = this.mOrientationHelper.getDecoratedStart(r106);
        goto L41
    L43:
        if (getChildCount() <= 0) goto L52;
        int r108 = getPosition(getChildAt(0));
        if (this.mPendingScrollPosition >= r108) goto L47;
        boolean r109 = true;
    L49:
        if (r109 != this.mShouldReverseLayout) goto L51;
        r102 = true;
    L51:
        r101.mLayoutFromEnd = r102;
        goto L52
    L47:
        r109 = false;
    L52:
        r101.assignCoordinateFromPadding();
        goto L53
    L54:
        boolean r110 = this.mShouldReverseLayout;
        r101.mLayoutFromEnd = r110;
        if (r110 == false) goto L57;
        r101.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset;
    L58:
        return true;
    L57:
        r101.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
    L60:
        return false;
    }

    private void updateLayoutStateToFillEnd(int r100, int r101) {
        LayoutState r102 = this.mLayoutState;
        r102.mAvailable = this.mOrientationHelper.getEndAfterPadding() - r101;
        LayoutState r103 = this.mLayoutState;
        if (this.mShouldReverseLayout == false) goto L5;
        int r104 = -1;
    L6:
        r103.mItemDirection = r104;
        r103.mCurrentPosition = r100;
        r103.mLayoutDirection = 1;
        r103.mOffset = r101;
        r103.mScrollingOffset = Integer.MIN_VALUE;
        return;
    L5:
        r104 = 1;
        goto L6
    }

    private void updateLayoutStateToFillStart(int r100, int r101) {
        LayoutState r102 = this.mLayoutState;
        r102.mAvailable = r101 - this.mOrientationHelper.getStartAfterPadding();
        LayoutState r103 = this.mLayoutState;
        r103.mCurrentPosition = r100;
        if (this.mShouldReverseLayout == false) goto L5;
        int r104 = 1;
    L6:
        r103.mItemDirection = r104;
        r103.mLayoutDirection = -1;
        r103.mOffset = r101;
        r103.mScrollingOffset = Integer.MIN_VALUE;
        return;
    L5:
        r104 = -1;
        goto L6
    }

    public void calculateExtraLayoutSpace(RecyclerView.State r100, int[] r101) {
        int r102 = getExtraLayoutSpace(r100);
        if (this.mLayoutState.mLayoutDirection != (-1)) goto L5;
        int r103 = 0;
    L6:
        r101[0] = r102;
        r101[1] = r103;
        return;
    L5:
        r103 = r102;
        r102 = 0;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectInitialPrefetchPositions(int r100, RecyclerView.LayoutManager.LayoutPrefetchRegistry r101) {
        SavedState r102 = this.mPendingSavedState;
        int r103 = -1;
        if (r102 != null) goto L5;
    L7:
        resolveShouldLayoutReverse();
        boolean r104 = this.mShouldReverseLayout;
        int r105 = this.mPendingScrollPosition;
        if (r105 != (-1)) goto L12;
        if (r104 == false) goto L11;
        r105 = r100 - 1;
        goto L12
    L11:
        r105 = 0;
    L12:
        if (r104 == true) goto L15;
        r103 = 1;
    L15:
        int r106 = 0;
    L17:
        if (r106 >= this.mInitialPrefetchItemCount) goto L21;
        if (r105 < 0) goto L25;
        if (r105 >= r100) goto L26;
        r101.addPosition(r105, 0);
        r105 = r105 + r103;
        r106 = r106 + 1;
        goto L17
    L26:
        return;
    L25:
        return;
    L21:
        return;
    L5:
        if (r102.hasValidAnchor() == false) goto L7;
        SavedState r107 = this.mPendingSavedState;
        r104 = r107.mAnchorLayoutFromEnd;
        r105 = r107.mAnchorPosition;
        goto L12
    }

    public View findFirstVisibleChildClosestToEnd(boolean r100, boolean r101) {
        if (this.mShouldReverseLayout == false) goto L7;
        return findOneVisibleChild(0, getChildCount(), r100, r101);
    L7:
        return findOneVisibleChild(getChildCount() - 1, -1, r100, r101);
    }

    public View findFirstVisibleChildClosestToStart(boolean r100, boolean r101) {
        if (this.mShouldReverseLayout == false) goto L7;
        return findOneVisibleChild(getChildCount() - 1, -1, r100, r101);
    L7:
        return findOneVisibleChild(0, getChildCount(), r100, r101);
    }

    public View findOnePartiallyOrCompletelyInvisibleChild(int r100, int r101) {
        ensureLayoutState();
        if (r101 <= r100) goto L5;
        byte r102 = 1;
    L8:
        if (r102 != 0) goto L12;
        return getChildAt(r100);
    L12:
        if (this.mOrientationHelper.getDecoratedStart(getChildAt(r100)) >= this.mOrientationHelper.getStartAfterPadding()) goto L14;
        int r103 = 16644;
        int r104 = 16388;
    L16:
        if (this.mOrientation != 0) goto L19;
        return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(r100, r101, r103, r104);
    L19:
        return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(r100, r101, r103, r104);
    L14:
        r103 = 4161;
        r104 = 4097;
        goto L16
    L5:
        if (r101 >= r100) goto L7;
        r102 = -1;
        goto L8
    L7:
        r102 = 0;
        goto L8
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView r100, RecyclerView.Recycler r101) {
        super.onDetachedFromWindow(r100, r101);
        if (this.mRecycleChildrenOnDetach == false) goto L6;
        removeAndRecycleAllViews(r101);
        r101.clear();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r110) {
        int r101 = -1;
        if (this.mPendingSavedState != null) goto L7;
        if (this.mPendingScrollPosition != (-1)) goto L7;
    L10:
        SavedState r102 = this.mPendingSavedState;
        if (r102 != null) goto L13;
    L15:
        ensureLayoutState();
        this.mLayoutState.mRecycle = false;
        resolveShouldLayoutReverse();
        View r103 = getFocusedChild();
        AnchorInfo r104 = this.mAnchorInfo;
        if (r104.mValid == true) goto L18;
    L28:
        r104.reset();
        AnchorInfo r105 = this.mAnchorInfo;
        r105.mLayoutFromEnd = this.mShouldReverseLayout ^ this.mStackFromEnd;
        updateAnchorInfoForLayout(r100, r110, r105);
        this.mAnchorInfo.mValid = true;
    L29:
        LayoutState r106 = this.mLayoutState;
        if (r106.mLastScrollDelta < 0) goto L32;
        int r107 = 1;
    L33:
        r106.mLayoutDirection = r107;
        int[] r108 = this.mReusableIntPair;
        r108[0] = 0;
        r108[1] = 0;
        calculateExtraLayoutSpace(r110, r108);
        int r109 = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.getStartAfterPadding();
        int r111 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.getEndPadding();
        if (r110.isPreLayout() == false) goto L49;
        int r112 = this.mPendingScrollPosition;
        if (r112 == (-1)) goto L49;
        if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) goto L49;
        View r113 = findViewByPosition(r112);
        if (r113 == null) goto L49;
        if (this.mShouldReverseLayout == false) goto L44;
        int r114 = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(r113);
        int r115 = this.mPendingScrollPositionOffset;
    L45:
        int r116 = r114 - r115;
        if (r116 <= 0) goto L48;
        r109 = r109 + r116;
        goto L49
    L48:
        r111 = r111 - r116;
        goto L49
    L44:
        r115 = this.mOrientationHelper.getDecoratedStart(r113) - this.mOrientationHelper.getStartAfterPadding();
        r114 = this.mPendingScrollPositionOffset;
    L49:
        AnchorInfo r117 = this.mAnchorInfo;
        if (r117.mLayoutFromEnd == false) goto L55;
        if (this.mShouldReverseLayout == false) goto L56;
    L53:
        r101 = 1;
    L56:
        onAnchorReady(r100, r110, r117, r101);
        detachAndScrapAttachedViews(r100);
        this.mLayoutState.mInfinite = resolveIsInfinite();
        this.mLayoutState.mIsPreLayout = r110.isPreLayout();
        this.mLayoutState.mNoRecycleSpace = 0;
        AnchorInfo r118 = this.mAnchorInfo;
        if (r118.mLayoutFromEnd == false) goto L64;
        updateLayoutStateToFillStart(r118);
        LayoutState r119 = this.mLayoutState;
        r119.mExtraFillSpace = r109;
        fill(r100, r119, r110, false);
        LayoutState r120 = this.mLayoutState;
        int r121 = r120.mOffset;
        int r122 = r120.mCurrentPosition;
        int r123 = r120.mAvailable;
        if (r123 <= 0) goto L61;
        r111 = r111 + r123;
    L61:
        updateLayoutStateToFillEnd(this.mAnchorInfo);
        LayoutState r124 = this.mLayoutState;
        r124.mExtraFillSpace = r111;
        r124.mCurrentPosition += r124.mItemDirection;
        fill(r100, r124, r110, false);
        LayoutState r125 = this.mLayoutState;
        int r126 = r125.mOffset;
        int r127 = r125.mAvailable;
        if (r127 <= 0) goto L71;
        updateLayoutStateToFillStart(r122, r121);
        LayoutState r128 = this.mLayoutState;
        r128.mExtraFillSpace = r127;
        fill(r100, r128, r110, false);
        r121 = this.mLayoutState.mOffset;
    L71:
        if (getChildCount() > 0) goto L73;
    L77:
        layoutForPredictiveAnimations(r100, r110, r121, r126);
        if (r110.isPreLayout() == true) goto L80;
        this.mOrientationHelper.onLayoutComplete();
    L81:
        this.mLastStackFromEnd = this.mStackFromEnd;
        return;
    L80:
        this.mAnchorInfo.reset();
        goto L81
    L73:
        if ((this.mShouldReverseLayout ^ this.mStackFromEnd) == false) goto L75;
        int r129 = fixLayoutEndGap(r126, r100, r110, true);
        int r130 = r121 + r129;
        int r131 = r126 + r129;
        int r132 = fixLayoutStartGap(r130, r100, r110, false);
    L76:
        r121 = r130 + r132;
        r126 = r131 + r132;
        goto L77
    L75:
        int r133 = fixLayoutStartGap(r121, r100, r110, true);
        r130 = r121 + r133;
        r131 = r126 + r133;
        r132 = fixLayoutEndGap(r131, r100, r110, false);
        goto L76
    L64:
        updateLayoutStateToFillEnd(r118);
        LayoutState r134 = this.mLayoutState;
        r134.mExtraFillSpace = r111;
        fill(r100, r134, r110, false);
        LayoutState r135 = this.mLayoutState;
        r126 = r135.mOffset;
        int r136 = r135.mCurrentPosition;
        int r137 = r135.mAvailable;
        if (r137 <= 0) goto L67;
        r109 = r109 + r137;
    L67:
        updateLayoutStateToFillStart(this.mAnchorInfo);
        LayoutState r138 = this.mLayoutState;
        r138.mExtraFillSpace = r109;
        r138.mCurrentPosition += r138.mItemDirection;
        fill(r100, r138, r110, false);
        LayoutState r139 = this.mLayoutState;
        r121 = r139.mOffset;
        int r140 = r139.mAvailable;
        if (r140 <= 0) goto L71;
        updateLayoutStateToFillEnd(r136, r126);
        LayoutState r141 = this.mLayoutState;
        r141.mExtraFillSpace = r140;
        fill(r100, r141, r110, false);
        r126 = this.mLayoutState.mOffset;
        goto L71
    L55:
        if (this.mShouldReverseLayout == false) goto L53;
    L32:
        r107 = -1;
        goto L33
    L18:
        if (this.mPendingScrollPosition != (-1)) goto L28;
        if (this.mPendingSavedState != null) goto L28;
        if (r103 == null) goto L29;
        if (this.mOrientationHelper.getDecoratedStart(r103) < this.mOrientationHelper.getEndAfterPadding()) goto L26;
    L27:
        this.mAnchorInfo.assignFromViewAndKeepVisibleRect(r103, getPosition(r103));
        goto L29
    L26:
        if (this.mOrientationHelper.getDecoratedEnd(r103) > this.mOrientationHelper.getStartAfterPadding()) goto L29;
    L13:
        if (r102.hasValidAnchor() == false) goto L15;
        this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
    L7:
        if (r110.getItemCount() != 0) goto L10;
        removeAndRecycleAllViews(r100);
    }

    public void scrollToPositionWithOffset(int r100, int r101) {
        this.mPendingScrollPosition = r100;
        this.mPendingScrollPositionOffset = r101;
        SavedState r102 = this.mPendingSavedState;
        if (r102 == null) goto L5;
        r102.invalidateAnchor();
    L5:
        requestLayout();
    }

    public LinearLayoutManager(Context r100, int r101, boolean r102) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(r101);
        setReverseLayout(r102);
    }

    private void recycleChildren(RecyclerView.Recycler r100, int r101, int r102) {
        if (r101 != r102) goto L4;
        return;
    L4:
        if (r102 <= r101) goto L8;
        int r103 = r102 - 1;
    L6:
        if (r103 < r101) goto L10;
        removeAndRecycleViewAt(r103, r100);
        r103 = r103 - 1;
        goto L6
    L10:
        return;
    L8:
        if (r101 <= r102) goto L13;
        removeAndRecycleViewAt(r101, r100);
        r101 = r101 - 1;
        goto L8
    }

    private void recycleViewsFromEnd(RecyclerView.Recycler r100, int r101, int r102) {
        int r103 = getChildCount();
        if (r101 >= 0) goto L5;
        return;
    L5:
        int r104 = (this.mOrientationHelper.getEnd() - r101) + r102;
        if (this.mShouldReverseLayout == false) goto L17;
        int r105 = 0;
    L8:
        if (r105 >= r103) goto L33;
        View r106 = getChildAt(r105);
        if (this.mOrientationHelper.getDecoratedStart(r106) < r104) goto L15;
        if (this.mOrientationHelper.getTransformedStartWithDecoration(r106) < r104) goto L15;
        r105 = r105 + 1;
    L15:
        recycleChildren(r100, 0, r105);
        return;
    L33:
        return;
    L17:
        int r107 = r103 - 1;
        int r108 = r107;
    L18:
        if (r108 < 0) goto L34;
        View r109 = getChildAt(r108);
        if (this.mOrientationHelper.getDecoratedStart(r109) < r104) goto L25;
        if (this.mOrientationHelper.getTransformedStartWithDecoration(r109) < r104) goto L25;
        r108 = r108 - 1;
    L25:
        recycleChildren(r100, r107, r108);
        return;
    }

    private void recycleViewsFromStart(RecyclerView.Recycler r100, int r101, int r102) {
        if (r101 >= 0) goto L4;
        return;
    L4:
        int r103 = r101 - r102;
        int r104 = getChildCount();
        if (this.mShouldReverseLayout == false) goto L16;
        int r105 = r104 - 1;
        int r106 = r105;
    L7:
        if (r106 < 0) goto L32;
        View r107 = getChildAt(r106);
        if (this.mOrientationHelper.getDecoratedEnd(r107) > r103) goto L14;
        if (this.mOrientationHelper.getTransformedEndWithDecoration(r107) > r103) goto L14;
        r106 = r106 - 1;
    L14:
        recycleChildren(r100, r105, r106);
        return;
    L32:
        return;
    L16:
        int r108 = 0;
    L17:
        if (r108 >= r104) goto L33;
        View r109 = getChildAt(r108);
        if (this.mOrientationHelper.getDecoratedEnd(r109) > r103) goto L24;
        if (this.mOrientationHelper.getTransformedEndWithDecoration(r109) > r103) goto L24;
        r108 = r108 + 1;
    L24:
        recycleChildren(r100, 0, r108);
        return;
    }

    private boolean updateAnchorFromChildren(RecyclerView.Recycler r100, RecyclerView.State r101, AnchorInfo r102) {
        boolean r103 = false;
        if (getChildCount() != 0) goto L5;
        return false;
    L5:
        View r104 = getFocusedChild();
        if (r104 != null) goto L8;
    L11:
        boolean r105 = this.mLastStackFromEnd;
        boolean r106 = this.mStackFromEnd;
        if (r105 == r106) goto L14;
        return false;
    L14:
        View r107 = findReferenceChild(r100, r101, r102.mLayoutFromEnd, r106);
        if (r107 == null) goto L35;
        r102.assignFromView(r107, getPosition(r107));
        if (r101.isPreLayout() == false) goto L19;
    L34:
        return true;
    L19:
        if (supportsPredictiveItemAnimations() == false) goto L34;
        int r108 = this.mOrientationHelper.getDecoratedStart(r107);
        int r109 = this.mOrientationHelper.getDecoratedEnd(r107);
        int r110 = this.mOrientationHelper.getStartAfterPadding();
        int r111 = this.mOrientationHelper.getEndAfterPadding();
        if (r109 > r110) goto L24;
        if (r108 >= r110) goto L24;
        boolean r112 = true;
    L25:
        if (r108 < r111) goto L28;
        if (r109 <= r111) goto L28;
        r103 = true;
    L28:
        if (r112 == true) goto L31;
        if (r103 == false) goto L34;
    L31:
        if (r102.mLayoutFromEnd == false) goto L33;
        r110 = r111;
    L33:
        r102.mCoordinate = r110;
    L24:
        r112 = false;
        goto L25
    L35:
        return false;
    L8:
        if (r102.isViewValidAsAnchor(r104, r101) == false) goto L11;
        r102.assignFromViewAndKeepVisibleRect(r104, getPosition(r104));
        return true;
    }

    private void updateAnchorInfoForLayout(RecyclerView.Recycler r100, RecyclerView.State r101, AnchorInfo r102) {
        if (updateAnchorFromPendingData(r101, r102) == false) goto L6;
        return;
    L6:
        if (updateAnchorFromChildren(r100, r101, r102) == false) goto L8;
        return;
    L8:
        r102.assignCoordinateFromPadding();
        if (this.mStackFromEnd == false) goto L11;
        int r103 = r101.getItemCount() - 1;
    L12:
        r102.mPosition = r103;
        return;
    L11:
        r103 = 0;
        goto L12
    }

    public void collectPrefetchPositionsForLayoutState(RecyclerView.State r100, LayoutState r101, RecyclerView.LayoutManager.LayoutPrefetchRegistry r102) {
        int r103 = r101.mCurrentPosition;
        if (r103 >= 0) goto L5;
        return;
    L5:
        if (r103 >= r100.getItemCount()) goto L9;
        r102.addPosition(r103, Math.max(0, r101.mScrollingOffset));
        return;
    }

    public int scrollBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        if (getChildCount() == 0) goto L17;
        if (r100 == 0) goto L17;
        ensureLayoutState();
        this.mLayoutState.mRecycle = true;
        if (r100 <= 0) goto L9;
        int r103 = 1;
    L10:
        int r104 = Math.abs(r100);
        updateLayoutState(r103, r104, true, r102);
        LayoutState r105 = this.mLayoutState;
        int r106 = r105.mScrollingOffset + fill(r101, r105, r102, false);
        if (r106 >= 0) goto L13;
        return 0;
    L13:
        if (r104 <= r106) goto L15;
        r100 = r103 * r106;
    L15:
        this.mOrientationHelper.offsetChildren(-r100);
        this.mLayoutState.mLastScrollDelta = r100;
        return r100;
    L9:
        r103 = -1;
    L17:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        if (this.mOrientation != 1) goto L7;
        return 0;
    L7:
        return scrollBy(r100, r101, r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        if (this.mOrientation != 0) goto L7;
        return 0;
    L7:
        return scrollBy(r100, r101, r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        LinearSmoothScroller r103 = new LinearSmoothScroller(r100.getContext());
        r103.setTargetPosition(r102);
        startSmoothScroll(r103);
    }

    public LinearLayoutManager(Context r100, AttributeSet r101, int r102, int r103) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new AnchorInfo();
        this.mLayoutChunkResult = new LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.LayoutManager.Properties r104 = RecyclerView.LayoutManager.getProperties(r100, r101, r102, r103);
        setOrientation(r104.orientation);
        setReverseLayout(r104.reverseLayout);
        setStackFromEnd(r104.stackFromEnd);
    }

    private int fixLayoutEndGap(int r100, RecyclerView.Recycler r101, RecyclerView.State r102, boolean r103) {
        int r104 = this.mOrientationHelper.getEndAfterPadding() - r100;
        if (r104 <= 0) goto L11;
        int r105 = -scrollBy(-r104, r101, r102);
        int r106 = r100 + r105;
        if (r103 == false) goto L10;
        int r107 = this.mOrientationHelper.getEndAfterPadding() - r106;
        if (r107 <= 0) goto L10;
        this.mOrientationHelper.offsetChildren(r107);
        return r107 + r105;
    L10:
        return r105;
    L11:
        return 0;
    }

    private int fixLayoutStartGap(int r100, RecyclerView.Recycler r101, RecyclerView.State r102, boolean r103) {
        int r104 = r100 - this.mOrientationHelper.getStartAfterPadding();
        if (r104 <= 0) goto L10;
        int r105 = -scrollBy(r104, r101, r102);
        int r106 = r100 + r105;
        if (r103 == false) goto L12;
        int r107 = r106 - this.mOrientationHelper.getStartAfterPadding();
        if (r107 <= 0) goto L13;
        this.mOrientationHelper.offsetChildren(-r107);
        return r105 - r107;
    L13:
        return r105;
    L12:
        return r105;
    L10:
        return 0;
    }

    private void layoutForPredictiveAnimations(RecyclerView.Recycler r110, RecyclerView.State r111, int r112, int r113) {
        if (r111.willRunPredictiveAnimations() == true) goto L5;
        return;
    L5:
        if (getChildCount() != 0) goto L7;
        return;
    L7:
        if (r111.isPreLayout() == false) goto L9;
        return;
    L9:
        if (supportsPredictiveItemAnimations() == false) goto L41;
        List<RecyclerView.ViewHolder> r100 = r110.getScrapList();
        int r101 = r100.size();
        int r102 = getPosition(getChildAt(0));
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L12:
        if (r103 >= r101) goto L27;
        RecyclerView.ViewHolder r114 = (RecyclerView.ViewHolder) ListProtector.get(r100, r103);
        if (r114.isRemoved() == true) goto L26;
        byte r115 = 1;
        if (r114.getLayoutPosition() >= r102) goto L19;
        boolean r116 = true;
    L21:
        if (r116 == this.mShouldReverseLayout) goto L23;
        r115 = -1;
    L23:
        if (r115 != (-1)) goto L25;
        r104 = r104 + this.mOrientationHelper.getDecoratedMeasurement(r114.itemView);
        goto L26
    L25:
        r105 = r105 + this.mOrientationHelper.getDecoratedMeasurement(r114.itemView);
        goto L26
    L19:
        r116 = false;
    L26:
        r103 = r103 + 1;
        goto L12
    L27:
        this.mLayoutState.mScrapList = r100;
        if (r104 <= 0) goto L30;
        updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), r112);
        LayoutState r106 = this.mLayoutState;
        r106.mExtraFillSpace = r104;
        r106.mAvailable = 0;
        r106.assignPositionFromScrapList();
        fill(r110, this.mLayoutState, r111, false);
    L30:
        if (r105 <= 0) goto L32;
        updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), r113);
        LayoutState r107 = this.mLayoutState;
        r107.mExtraFillSpace = r105;
        r107.mAvailable = 0;
        r107.assignPositionFromScrapList();
        fill(r110, this.mLayoutState, r111, false);
    L32:
        this.mLayoutState.mScrapList = null;
        return;
    }

    private void updateLayoutState(int r100, int r101, boolean r102, RecyclerView.State r103) {
        this.mLayoutState.mInfinite = resolveIsInfinite();
        this.mLayoutState.mLayoutDirection = r100;
        int[] r104 = this.mReusableIntPair;
        boolean r105 = false;
        r104[0] = 0;
        int r106 = 1;
        r104[1] = 0;
        calculateExtraLayoutSpace(r103, r104);
        int r107 = Math.max(0, this.mReusableIntPair[0]);
        int r108 = Math.max(0, this.mReusableIntPair[1]);
        if (r100 != 1) goto L5;
        r105 = true;
    L5:
        LayoutState r109 = this.mLayoutState;
        if (r105 == false) goto L8;
        int r110 = r108;
    L9:
        r109.mExtraFillSpace = r110;
        if (r105 == true) goto L13;
        r107 = r108;
    L13:
        r109.mNoRecycleSpace = r107;
        if (r105 == false) goto L19;
        r109.mExtraFillSpace = r110 + this.mOrientationHelper.getEndPadding();
        View r111 = getChildClosestToEnd();
        LayoutState r112 = this.mLayoutState;
        if (this.mShouldReverseLayout == false) goto L18;
        r106 = -1;
    L18:
        r112.mItemDirection = r106;
        int r113 = getPosition(r111);
        LayoutState r114 = this.mLayoutState;
        r112.mCurrentPosition = r113 + r114.mItemDirection;
        r114.mOffset = this.mOrientationHelper.getDecoratedEnd(r111);
        int r115 = this.mOrientationHelper.getDecoratedEnd(r111) - this.mOrientationHelper.getEndAfterPadding();
    L24:
        LayoutState r116 = this.mLayoutState;
        r116.mAvailable = r101;
        if (r102 == false) goto L27;
        r116.mAvailable = r101 - r115;
    L27:
        r116.mScrollingOffset = r115;
        return;
    L19:
        View r117 = getChildClosestToStart();
        this.mLayoutState.mExtraFillSpace += this.mOrientationHelper.getStartAfterPadding();
        LayoutState r118 = this.mLayoutState;
        if (this.mShouldReverseLayout == true) goto L23;
        r106 = -1;
    L23:
        r118.mItemDirection = r106;
        int r119 = getPosition(r117);
        LayoutState r120 = this.mLayoutState;
        r118.mCurrentPosition = r119 + r120.mItemDirection;
        r120.mOffset = this.mOrientationHelper.getDecoratedStart(r117);
        r115 = (-this.mOrientationHelper.getDecoratedStart(r117)) + this.mOrientationHelper.getStartAfterPadding();
        goto L24
    L8:
        r110 = r107;
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectAdjacentPrefetchPositions(int r100, int r101, RecyclerView.State r102, RecyclerView.LayoutManager.LayoutPrefetchRegistry r103) {
        if (this.mOrientation == 0) goto L7;
        r100 = r101;
    L7:
        if (getChildCount() == 0) goto L16;
        if (r100 == 0) goto L17;
        ensureLayoutState();
        if (r100 <= 0) goto L13;
        int r104 = 1;
    L14:
        updateLayoutState(r104, Math.abs(r100), true, r102);
        collectPrefetchPositionsForLayoutState(r102, this.mLayoutState, r103);
        return;
    L13:
        r104 = -1;
        goto L14
    L17:
        return;
    }

    public int fill(RecyclerView.Recycler r100, LayoutState r101, RecyclerView.State r110, boolean r111) {
        int r102 = r101.mAvailable;
        int r103 = r101.mScrollingOffset;
        if (r103 == Integer.MIN_VALUE) goto L7;
        if (r102 >= 0) goto L6;
        r101.mScrollingOffset = r103 + r102;
    L6:
        recycleByLayoutState(r100, r101);
    L7:
        int r104 = r101.mAvailable + r101.mExtraFillSpace;
        LayoutChunkResult r105 = this.mLayoutChunkResult;
    L9:
        if (r101.mInfinite == true) goto L12;
        if (r104 > 0) goto L12;
    L33:
        return r102 - r101.mAvailable;
    L12:
        if (r101.hasMore(r110) == false) goto L33;
        r105.resetInternal();
        layoutChunk(r100, r110, r101, r105);
        if (r105.mFinished == true) goto L33;
        r101.mOffset += r105.mConsumed * r101.mLayoutDirection;
        if (r105.mIgnoreConsumed == true) goto L19;
    L22:
        int r106 = r101.mAvailable;
        int r107 = r105.mConsumed;
        r101.mAvailable = r106 - r107;
        r104 = r104 - r107;
    L23:
        int r108 = r101.mScrollingOffset;
        if (r108 == Integer.MIN_VALUE) goto L29;
        int r109 = r108 + r105.mConsumed;
        r101.mScrollingOffset = r109;
        int r112 = r101.mAvailable;
        if (r112 >= 0) goto L28;
        r101.mScrollingOffset = r109 + r112;
    L28:
        recycleByLayoutState(r100, r101);
    L29:
        if (r111 == false) goto L9;
        if (r105.mFocusable == false) goto L9;
    L19:
        if (r101.mScrapList != null) goto L22;
        if (r110.isPreLayout() == true) goto L23;
        goto L22
    }

    public View findOneVisibleChild(int r100, int r101, boolean r102, boolean r103) {
        ensureLayoutState();
        int r104 = 320;
        if (r102 == false) goto L5;
        int r105 = 24579;
    L6:
        if (r103 == true) goto L10;
        r104 = 0;
    L10:
        if (this.mOrientation != 0) goto L13;
        return this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(r100, r101, r105, r104);
    L13:
        return this.mVerticalBoundCheck.findOneViewWithinBoundFlags(r100, r101, r105, r104);
    L5:
        r105 = 320;
        goto L6
    }

    public View findReferenceChild(RecyclerView.Recycler r110, RecyclerView.State r111, boolean r112, boolean r210) {
        ensureLayoutState();
        int r100 = getChildCount();
        if (r210 == false) goto L5;
        int r101 = getChildCount() - 1;
        int r102 = -1;
        int r103 = -1;
    L6:
        int r104 = r111.getItemCount();
        int r105 = this.mOrientationHelper.getStartAfterPadding();
        int r106 = this.mOrientationHelper.getEndAfterPadding();
        View r107 = null;
        View r113 = null;
        View r114 = null;
    L7:
        if (r101 == r102) goto L37;
        View r115 = getChildAt(r101);
        int r116 = getPosition(r115);
        int r117 = this.mOrientationHelper.getDecoratedStart(r115);
        int r118 = this.mOrientationHelper.getDecoratedEnd(r115);
        if (r116 < 0) goto L36;
        if (r116 >= r104) goto L36;
        if (((RecyclerView.LayoutParams) r115.getLayoutParams()).isItemRemoved() == false) goto L15;
        if (r114 != null) goto L36;
        r114 = r115;
        goto L36
    L15:
        if (r118 > r105) goto L18;
        if (r117 >= r105) goto L18;
        boolean r119 = true;
    L19:
        if (r117 < r106) goto L22;
        if (r118 <= r106) goto L22;
        boolean r120 = true;
    L23:
        if (r119 == true) goto L27;
        if (r120 == true) goto L27;
        return r115;
    L27:
        if (r112 == false) goto L32;
        if (r120 == true) goto L33;
        if (r107 != null) goto L36;
    L35:
        r107 = r115;
    L33:
        r113 = r115;
        goto L36
    L32:
        if (r119 == true) goto L33;
        if (r107 != null) goto L36;
    L22:
        r120 = false;
    L18:
        r119 = false;
    L36:
        r101 = r101 + r103;
        goto L7
    L37:
        if (r107 != null) goto L54;
        if (r113 == null) goto L42;
        return r113;
    L42:
        return r114;
    L54:
        return r107;
    L5:
        r102 = r100;
        r101 = 0;
        r103 = 1;
        goto L6
    }

    public void layoutChunk(RecyclerView.Recycler r100, RecyclerView.State r101, LayoutState r110, LayoutChunkResult r111) {
        View r102 = r110.next(r100);
        if (r102 != null) goto L6;
        r111.mFinished = true;
        return;
    L6:
        RecyclerView.LayoutParams r103 = (RecyclerView.LayoutParams) r102.getLayoutParams();
        if (r110.mScrapList != null) goto L15;
        boolean r104 = this.mShouldReverseLayout;
        if (r110.mLayoutDirection != (-1)) goto L11;
        boolean r105 = true;
    L12:
        if (r104 != r105) goto L14;
        addView(r102);
    L22:
        measureChildWithMargins(r102, 0, 0);
        r111.mConsumed = this.mOrientationHelper.getDecoratedMeasurement(r102);
        if (this.mOrientation == 1) goto L25;
        int r106 = getPaddingTop();
        int r107 = this.mOrientationHelper.getDecoratedMeasurementInOther(r102) + r106;
        if (r110.mLayoutDirection != (-1)) goto L35;
        int r112 = r110.mOffset;
        int r108 = r112;
        int r109 = r106;
        int r113 = r107;
        int r114 = r112 - r111.mConsumed;
    L36:
        layoutDecoratedWithMargins(r102, r114, r109, r108, r113);
        if (r103.isItemRemoved() == false) goto L39;
    L40:
        r111.mIgnoreConsumed = true;
    L41:
        r111.mFocusable = r102.hasFocusable();
        return;
    L39:
        if (r103.isItemChanged() == false) goto L41;
    L35:
        int r115 = r110.mOffset;
        r109 = r106;
        r108 = r111.mConsumed + r115;
        r113 = r107;
        r114 = r115;
        goto L36
    L25:
        if (isLayoutRTL() == false) goto L27;
        int r116 = getWidth() - getPaddingRight();
        r114 = r116 - this.mOrientationHelper.getDecoratedMeasurementInOther(r102);
    L29:
        if (r110.mLayoutDirection != (-1)) goto L31;
        int r117 = r110.mOffset;
        r113 = r117;
        r108 = r116;
        r109 = r117 - r111.mConsumed;
        goto L36
    L31:
        int r118 = r110.mOffset;
        r109 = r118;
        r108 = r116;
        r113 = r111.mConsumed + r118;
        goto L36
    L27:
        r114 = getPaddingLeft();
        r116 = this.mOrientationHelper.getDecoratedMeasurementInOther(r102) + r114;
        goto L29
    L14:
        addView(r102, 0);
        goto L22
    L11:
        r105 = false;
        goto L12
    L15:
        boolean r119 = this.mShouldReverseLayout;
        if (r110.mLayoutDirection != (-1)) goto L18;
        boolean r120 = true;
    L19:
        if (r119 != r120) goto L21;
        addDisappearingView(r102);
        goto L22
    L21:
        addDisappearingView(r102, 0);
        goto L22
    L18:
        r120 = false;
        goto L19
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View r100, int r101, RecyclerView.Recycler r102, RecyclerView.State r103) {
        resolveShouldLayoutReverse();
        if (getChildCount() != 0) goto L5;
        return null;
    L5:
        int r104 = convertFocusDirectionToLayoutDirection(r101);
        if (r104 != Integer.MIN_VALUE) goto L8;
        return null;
    L8:
        ensureLayoutState();
        updateLayoutState(r104, (int) (this.mOrientationHelper.getTotalSpace() * MAX_SCROLL_FACTOR), false, r103);
        LayoutState r105 = this.mLayoutState;
        r105.mScrollingOffset = Integer.MIN_VALUE;
        r105.mRecycle = false;
        fill(r102, r105, r103, true);
        if (r104 != (-1)) goto L11;
        View r106 = findPartiallyOrCompletelyInvisibleChildClosestToStart();
    L12:
        if (r104 != (-1)) goto L14;
        View r107 = getChildClosestToStart();
    L16:
        if (r107.hasFocusable() == false) goto L20;
        if (r106 != null) goto L19;
        return null;
    L19:
        return r107;
    L20:
        return r106;
    L14:
        r107 = getChildClosestToEnd();
        goto L16
    L11:
        r106 = findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        goto L12
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.ViewDropHandler
    public void prepareForDrop(View r100, View r101, int r102, int r103) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int r104 = getPosition(r100);
        int r105 = getPosition(r101);
        if (r104 >= r105) goto L5;
        byte r106 = 1;
    L7:
        if (this.mShouldReverseLayout == false) goto L11;
        if (r106 != 1) goto L10;
        scrollToPositionWithOffset(r105, this.mOrientationHelper.getEndAfterPadding() - (this.mOrientationHelper.getDecoratedStart(r101) + this.mOrientationHelper.getDecoratedMeasurement(r100)));
        return;
    L10:
        scrollToPositionWithOffset(r105, this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(r101));
        return;
    L11:
        if (r106 != (-1)) goto L13;
        scrollToPositionWithOffset(r105, this.mOrientationHelper.getDecoratedStart(r101));
        return;
    L13:
        scrollToPositionWithOffset(r105, this.mOrientationHelper.getDecoratedEnd(r101) - this.mOrientationHelper.getDecoratedMeasurement(r100));
        return;
    L5:
        r106 = -1;
        goto L7
    }
}
