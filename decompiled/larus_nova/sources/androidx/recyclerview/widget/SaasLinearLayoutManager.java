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

/* JADX INFO: loaded from: classes17.dex */
public class SaasLinearLayoutManager extends RecyclerView.LayoutManager implements ItemTouchHelper.ViewDropHandler, RecyclerView.SmoothScroller.ScrollVectorProvider {
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
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;
    protected int offscreenPageLimit;

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
        int mExtra;
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
            this.mExtra = 0;
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

    public SaasLinearLayoutManager(Context r100) {
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
        RecyclerView r101 = this.mRecyclerView;
        if (getOrientation() != 0) goto L5;
        int r102 = r101.getWidth() - r101.getPaddingLeft();
        int r103 = r101.getPaddingRight();
    L6:
        int r104 = r102 - r103;
        return this.offscreenPageLimit * r104;
    L5:
        r102 = r101.getHeight() - r101.getPaddingTop();
        r103 = r101.getPaddingBottom();
        goto L6
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
        if ((r100 instanceof SavedState) == false) goto L6;
        this.mPendingSavedState = (SavedState) r100;
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

    private View findFirstPartiallyOrCompletelyInvisibleChild(RecyclerView.Recycler r100, RecyclerView.State r101) {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findFirstReferenceChild(RecyclerView.Recycler r100, RecyclerView.State r101) {
        return findReferenceChild(r100, r101, 0, getChildCount(), r101.getItemCount());
    }

    private View findFirstVisibleChildClosestToEnd(boolean r100, boolean r101) {
        if (this.mShouldReverseLayout == false) goto L7;
        return findOneVisibleChild(0, getChildCount(), r100, r101);
    L7:
        return findOneVisibleChild(getChildCount() - 1, -1, r100, r101);
    }

    private View findFirstVisibleChildClosestToStart(boolean r100, boolean r101) {
        if (this.mShouldReverseLayout == false) goto L7;
        return findOneVisibleChild(getChildCount() - 1, -1, r100, r101);
    L7:
        return findOneVisibleChild(0, getChildCount(), r100, r101);
    }

    private View findLastPartiallyOrCompletelyInvisibleChild(RecyclerView.Recycler r100, RecyclerView.State r101) {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    private View findLastReferenceChild(RecyclerView.Recycler r100, RecyclerView.State r101) {
        return findReferenceChild(r100, r101, getChildCount() - 1, -1, r101.getItemCount());
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd(RecyclerView.Recycler r100, RecyclerView.State r101) {
        if (this.mShouldReverseLayout == false) goto L6;
        return findFirstPartiallyOrCompletelyInvisibleChild(r100, r101);
    L6:
        return findLastPartiallyOrCompletelyInvisibleChild(r100, r101);
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart(RecyclerView.Recycler r100, RecyclerView.State r101) {
        if (this.mShouldReverseLayout == false) goto L6;
        return findLastPartiallyOrCompletelyInvisibleChild(r100, r101);
    L6:
        return findFirstPartiallyOrCompletelyInvisibleChild(r100, r101);
    }

    private View findReferenceChildClosestToEnd(RecyclerView.Recycler r100, RecyclerView.State r101) {
        if (this.mShouldReverseLayout == false) goto L6;
        return findFirstReferenceChild(r100, r101);
    L6:
        return findLastReferenceChild(r100, r101);
    }

    private View findReferenceChildClosestToStart(RecyclerView.Recycler r100, RecyclerView.State r101) {
        if (this.mShouldReverseLayout == false) goto L6;
        return findLastReferenceChild(r100, r101);
    L6:
        return findFirstReferenceChild(r100, r101);
    }

    private void recycleByLayoutState(RecyclerView.Recycler r100, LayoutState r101) {
        if (r101.mRecycle == true) goto L5;
        return;
    L5:
        if (r101.mInfinite == false) goto L8;
        return;
    L8:
        if (r101.mLayoutDirection != (-1)) goto L10;
        recycleViewsFromEnd(r100, r101.mScrollingOffset, r101.mNoRecycleSpace);
        return;
    L10:
        recycleViewsFromStart(r100, r101.mScrollingOffset, r101.mNoRecycleSpace);
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
        int r106 = getExtraLayoutSpace(r110);
        int r107 = this.mOrientationHelper.getStartAfterPadding() + r106;
        int r108 = r106 + this.mOrientationHelper.getEndPadding();
        if (r110.isPreLayout() == false) goto L45;
        int r109 = this.mPendingScrollPosition;
        if (r109 == (-1)) goto L45;
        if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) goto L45;
        View r111 = findViewByPosition(r109);
        if (r111 == null) goto L45;
        if (this.mShouldReverseLayout == false) goto L40;
        int r112 = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(r111);
        int r113 = this.mPendingScrollPositionOffset;
    L41:
        int r114 = r112 - r113;
        if (r114 <= 0) goto L44;
        r107 = r107 + r114;
        goto L45
    L44:
        r108 = r108 - r114;
        goto L45
    L40:
        r113 = this.mOrientationHelper.getDecoratedStart(r111) - this.mOrientationHelper.getStartAfterPadding();
        r112 = this.mPendingScrollPositionOffset;
    L45:
        AnchorInfo r115 = this.mAnchorInfo;
        if (r115.mLayoutFromEnd == false) goto L51;
        if (this.mShouldReverseLayout == false) goto L52;
    L49:
        r101 = 1;
    L52:
        onAnchorReady(r100, r110, r115, r101);
        detachAndScrapAttachedViews(r100);
        this.mLayoutState.mInfinite = resolveIsInfinite();
        this.mLayoutState.mIsPreLayout = r110.isPreLayout();
        this.mLayoutState.mNoRecycleSpace = 0;
        AnchorInfo r116 = this.mAnchorInfo;
        if (r116.mLayoutFromEnd == false) goto L60;
        updateLayoutStateToFillStart(r116);
        LayoutState r117 = this.mLayoutState;
        r117.mExtra = r107;
        fill(r100, r117, r110, false);
        LayoutState r118 = this.mLayoutState;
        int r119 = r118.mOffset;
        int r120 = r118.mCurrentPosition;
        int r121 = r118.mAvailable;
        if (r121 <= 0) goto L57;
        r108 = r108 + r121;
    L57:
        updateLayoutStateToFillEnd(this.mAnchorInfo);
        LayoutState r122 = this.mLayoutState;
        r122.mExtra = r108;
        r122.mCurrentPosition += r122.mItemDirection;
        fill(r100, r122, r110, false);
        LayoutState r123 = this.mLayoutState;
        int r124 = r123.mOffset;
        int r125 = r123.mAvailable;
        if (r125 <= 0) goto L67;
        updateLayoutStateToFillStart(r120, r119);
        LayoutState r126 = this.mLayoutState;
        r126.mExtra = r125;
        fill(r100, r126, r110, false);
        r119 = this.mLayoutState.mOffset;
    L67:
        if (getChildCount() > 0) goto L69;
    L73:
        layoutForPredictiveAnimations(r100, r110, r119, r124);
        if (r110.isPreLayout() == true) goto L76;
        this.mOrientationHelper.onLayoutComplete();
    L77:
        this.mLastStackFromEnd = this.mStackFromEnd;
        return;
    L76:
        this.mAnchorInfo.reset();
        goto L77
    L69:
        if ((this.mShouldReverseLayout ^ this.mStackFromEnd) == false) goto L71;
        int r127 = fixLayoutEndGap(r124, r100, r110, true);
        int r128 = r119 + r127;
        int r129 = r124 + r127;
        int r130 = fixLayoutStartGap(r128, r100, r110, false);
    L72:
        r119 = r128 + r130;
        r124 = r129 + r130;
        goto L73
    L71:
        int r131 = fixLayoutStartGap(r119, r100, r110, true);
        r128 = r119 + r131;
        r129 = r124 + r131;
        r130 = fixLayoutEndGap(r129, r100, r110, false);
        goto L72
    L60:
        updateLayoutStateToFillEnd(r116);
        LayoutState r132 = this.mLayoutState;
        r132.mExtra = r108;
        fill(r100, r132, r110, false);
        LayoutState r133 = this.mLayoutState;
        r124 = r133.mOffset;
        int r134 = r133.mCurrentPosition;
        int r135 = r133.mAvailable;
        if (r135 <= 0) goto L63;
        r107 = r107 + r135;
    L63:
        updateLayoutStateToFillStart(this.mAnchorInfo);
        LayoutState r136 = this.mLayoutState;
        r136.mExtra = r107;
        r136.mCurrentPosition += r136.mItemDirection;
        fill(r100, r136, r110, false);
        LayoutState r137 = this.mLayoutState;
        r119 = r137.mOffset;
        int r138 = r137.mAvailable;
        if (r138 <= 0) goto L67;
        updateLayoutStateToFillEnd(r134, r124);
        LayoutState r139 = this.mLayoutState;
        r139.mExtra = r138;
        fill(r100, r139, r110, false);
        r124 = this.mLayoutState.mOffset;
        goto L67
    L51:
        if (this.mShouldReverseLayout == false) goto L49;
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

    public SaasLinearLayoutManager(Context r100, int r101, boolean r102) {
        this.offscreenPageLimit = 1;
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
        if (r104 == null) goto L12;
        if (r102.isViewValidAsAnchor(r104, r101) == false) goto L12;
        r102.assignFromViewAndKeepVisibleRect(r104, getPosition(r104));
        return true;
    L12:
        if (this.mLastStackFromEnd == this.mStackFromEnd) goto L15;
        return false;
    L15:
        if (r102.mLayoutFromEnd == false) goto L17;
        View r105 = findReferenceChildClosestToEnd(r100, r101);
    L18:
        if (r105 == null) goto L35;
        r102.assignFromView(r105, getPosition(r105));
        if (r101.isPreLayout() == false) goto L22;
    L34:
        return true;
    L22:
        if (supportsPredictiveItemAnimations() == false) goto L34;
        if (this.mOrientationHelper.getDecoratedStart(r105) < this.mOrientationHelper.getEndAfterPadding()) goto L26;
    L27:
        r103 = true;
    L28:
        if (r103 == false) goto L34;
        if (r102.mLayoutFromEnd == false) goto L32;
        int r106 = this.mOrientationHelper.getEndAfterPadding();
    L33:
        r102.mCoordinate = r106;
        goto L34
    L32:
        r106 = this.mOrientationHelper.getStartAfterPadding();
        goto L33
    L26:
        if (this.mOrientationHelper.getDecoratedEnd(r105) >= this.mOrientationHelper.getStartAfterPadding()) goto L28;
    L35:
        return false;
    L17:
        r105 = findReferenceChildClosestToStart(r100, r101);
        goto L18
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
        this.mLayoutState.mRecycle = true;
        ensureLayoutState();
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

    public SaasLinearLayoutManager(Context r100, AttributeSet r101, int r102, int r103) {
        this.offscreenPageLimit = 1;
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
        r106.mExtra = r104;
        r106.mAvailable = 0;
        r106.assignPositionFromScrapList();
        fill(r110, this.mLayoutState, r111, false);
    L30:
        if (r105 <= 0) goto L32;
        updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), r113);
        LayoutState r107 = this.mLayoutState;
        r107.mExtra = r105;
        r107.mAvailable = 0;
        r107.assignPositionFromScrapList();
        fill(r110, this.mLayoutState, r111, false);
    L32:
        this.mLayoutState.mScrapList = null;
        return;
    }

    private void updateLayoutState(int r100, int r101, boolean r102, RecyclerView.State r103) {
        this.mLayoutState.mInfinite = resolveIsInfinite();
        this.mLayoutState.mExtra = getExtraLayoutSpace(r103);
        LayoutState r104 = this.mLayoutState;
        r104.mLayoutDirection = r100;
        int r105 = r104.mExtra;
        r104.mNoRecycleSpace = r105;
        int r106 = -1;
        if (r100 != 1) goto L9;
        r104.mExtra = r105 + this.mOrientationHelper.getEndPadding();
        View r107 = getChildClosestToEnd();
        LayoutState r108 = this.mLayoutState;
        if (this.mShouldReverseLayout == true) goto L8;
        r106 = 1;
    L8:
        r108.mItemDirection = r106;
        int r109 = getPosition(r107);
        LayoutState r110 = this.mLayoutState;
        r108.mCurrentPosition = r109 + r110.mItemDirection;
        r110.mOffset = this.mOrientationHelper.getDecoratedEnd(r107);
        int r111 = this.mOrientationHelper.getDecoratedEnd(r107) - this.mOrientationHelper.getEndAfterPadding();
    L13:
        LayoutState r112 = this.mLayoutState;
        r112.mAvailable = r101;
        if (r102 == false) goto L16;
        r112.mAvailable = r101 - r111;
    L16:
        r112.mScrollingOffset = r111;
        return;
    L9:
        View r113 = getChildClosestToStart();
        this.mLayoutState.mExtra += this.mOrientationHelper.getStartAfterPadding();
        LayoutState r114 = this.mLayoutState;
        if (this.mShouldReverseLayout == false) goto L12;
        r106 = 1;
    L12:
        r114.mItemDirection = r106;
        int r115 = getPosition(r113);
        LayoutState r116 = this.mLayoutState;
        r114.mCurrentPosition = r115 + r116.mItemDirection;
        r116.mOffset = this.mOrientationHelper.getDecoratedStart(r113);
        r111 = (-this.mOrientationHelper.getDecoratedStart(r113)) + this.mOrientationHelper.getStartAfterPadding();
        goto L13
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
        int r104 = r101.mAvailable + r101.mExtra;
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
        if (this.mLayoutState.mScrapList != null) goto L22;
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
        ensureLayoutState();
        updateLayoutState(r104, (int) (this.mOrientationHelper.getTotalSpace() * MAX_SCROLL_FACTOR), false, r103);
        LayoutState r105 = this.mLayoutState;
        r105.mScrollingOffset = Integer.MIN_VALUE;
        r105.mRecycle = false;
        fill(r102, r105, r103, true);
        if (r104 != (-1)) goto L11;
        View r106 = findPartiallyOrCompletelyInvisibleChildClosestToStart(r102, r103);
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
        r106 = findPartiallyOrCompletelyInvisibleChildClosestToEnd(r102, r103);
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

    public View findReferenceChild(RecyclerView.Recycler r100, RecyclerView.State r101, int r102, int r103, int r110) {
        ensureLayoutState();
        int r104 = this.mOrientationHelper.getStartAfterPadding();
        int r105 = this.mOrientationHelper.getEndAfterPadding();
        if (r103 <= r102) goto L5;
        int r106 = 1;
    L6:
        View r107 = null;
        View r108 = null;
    L7:
        if (r102 == r103) goto L24;
        View r109 = getChildAt(r102);
        int r111 = getPosition(r109);
        if (r111 < 0) goto L23;
        if (r111 >= r110) goto L23;
        if (((RecyclerView.LayoutParams) r109.getLayoutParams()).isItemRemoved() == false) goto L16;
        if (r108 != null) goto L23;
        r108 = r109;
        goto L23
    L16:
        if (this.mOrientationHelper.getDecoratedStart(r109) < r105) goto L18;
    L21:
        if (r107 != null) goto L23;
        r107 = r109;
        goto L23
    L18:
        if (this.mOrientationHelper.getDecoratedEnd(r109) < r104) goto L21;
        return r109;
    L23:
        r102 = r102 + r106;
        goto L7
    L24:
        if (r107 == null) goto L27;
        return r107;
    L27:
        return r108;
    L5:
        r106 = -1;
        goto L6
    }
}
