package com.alibaba.android.vlayout;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.layout.BaseLayoutHelper;
import com.alibaba.android.vlayout.layout.DefaultLayoutHelper;
import com.alibaba.android.vlayout.layout.FixAreaAdjuster;
import com.alibaba.android.vlayout.layout.FixAreaLayoutHelper;
import com.alibaba.android.vlayout.layout.LayoutChunkResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public class VirtualLayoutManager extends ExposeLinearLayoutManagerEx implements LayoutManagerHelper {
    private static LayoutHelper DEFAULT_LAYOUT_HELPER = null;
    public static final int HORIZONTAL = 0;
    private static final int MAX_NO_SCROLLING_SIZE = 134217727;
    protected static final String TAG = "VirtualLayoutManager";
    private static final String TRACE_LAYOUT = "VLM onLayoutChildren";
    private static final String TRACE_SCROLL = "VLM scroll";
    public static final int VERTICAL = 1;
    private static boolean sDebuggable = false;
    private Rect mDecorInsets;
    private LayoutHelper mDefaultLayoutHelper;
    private boolean mEnableMarginOverlapping;
    private FixAreaAdjuster mFixAreaAdjustor;
    private LayoutHelperFinder mHelperFinder;
    private BaseLayoutHelper.LayoutViewBindListener mLayoutViewBindListener;
    private LayoutViewFactory mLayoutViewFatory;
    private int mMaxMeasureSize;
    private int mMeasuredFullSpace;
    private int mNested;
    private boolean mNestedScrolling;
    private boolean mNoScrolling;
    protected OrientationHelperEx mOrientationHelper;
    private List<Pair<Range<Integer>, Integer>> mRangeLengths;
    private RecyclerView mRecyclerView;
    protected OrientationHelperEx mSecondaryOrientationHelper;
    private boolean mSpaceMeasured;
    private boolean mSpaceMeasuring;
    private AnchorInfoWrapper mTempAnchorInfoWrapper;
    private LayoutStateWrapper mTempLayoutStateWrapper;
    private HashMap<Integer, LayoutHelper> newHelpersSet;
    private HashMap<Integer, LayoutHelper> oldHelpersSet;

    public static class AnchorInfoWrapper {
        public int coordinate;
        public boolean layoutFromEnd;
        public int position;

        public AnchorInfoWrapper() {
        }
    }

    public interface CacheViewHolder {
        boolean needCached();
    }

    public static class InflateLayoutParams extends LayoutParams {
        public InflateLayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALIDE_SIZE = Integer.MIN_VALUE;
        public float mAspectRatio;
        private int mOriginHeight;
        private int mOriginWidth;
        public int zIndex;

        public LayoutParams(Context r10, AttributeSet r11) {
            super(r10, r11);
            this.zIndex = 0;
            this.mAspectRatio = Float.NaN;
            this.mOriginWidth = Integer.MIN_VALUE;
            this.mOriginHeight = Integer.MIN_VALUE;
        }

        public void restoreOriginHeight() {
            int r10 = this.mOriginHeight;
            if (r10 == Integer.MIN_VALUE) goto L6;
            ((ViewGroup.MarginLayoutParams) this).height = r10;
            return;
        }

        public void restoreOriginWidth() {
            int r10 = this.mOriginWidth;
            if (r10 == Integer.MIN_VALUE) goto L6;
            ((ViewGroup.MarginLayoutParams) this).width = r10;
            return;
        }

        public void storeOriginHeight() {
            if (this.mOriginHeight != Integer.MIN_VALUE) goto L6;
            this.mOriginHeight = ((ViewGroup.MarginLayoutParams) this).height;
            return;
        }

        public void storeOriginWidth() {
            if (this.mOriginWidth != Integer.MIN_VALUE) goto L6;
            this.mOriginWidth = ((ViewGroup.MarginLayoutParams) this).width;
            return;
        }

        public LayoutParams(int r10, int r11) {
            super(r10, r11);
            this.zIndex = 0;
            this.mAspectRatio = Float.NaN;
            this.mOriginWidth = Integer.MIN_VALUE;
            this.mOriginHeight = Integer.MIN_VALUE;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r10) {
            super(r10);
            this.zIndex = 0;
            this.mAspectRatio = Float.NaN;
            this.mOriginWidth = Integer.MIN_VALUE;
            this.mOriginHeight = Integer.MIN_VALUE;
        }

        public LayoutParams(ViewGroup.LayoutParams r10) {
            super(r10);
            this.zIndex = 0;
            this.mAspectRatio = Float.NaN;
            this.mOriginWidth = Integer.MIN_VALUE;
            this.mOriginHeight = Integer.MIN_VALUE;
        }

        public LayoutParams(RecyclerView.LayoutParams r10) {
            super(r10);
            this.zIndex = 0;
            this.mAspectRatio = Float.NaN;
            this.mOriginWidth = Integer.MIN_VALUE;
            this.mOriginHeight = Integer.MIN_VALUE;
        }
    }

    public static class LayoutStateWrapper {
        static final int INVALID_LAYOUT = Integer.MIN_VALUE;
        public static final int ITEM_DIRECTION_HEAD = -1;
        public static final int ITEM_DIRECTION_TAIL = 1;
        public static final int LAYOUT_END = 1;
        public static final int LAYOUT_START = -1;
        static final int SCOLLING_OFFSET_NaN = Integer.MIN_VALUE;
        private ExposeLinearLayoutManagerEx.LayoutState mLayoutState;

        public LayoutStateWrapper() {
        }

        public static /* synthetic */ ExposeLinearLayoutManagerEx.LayoutState access$102(LayoutStateWrapper r10, ExposeLinearLayoutManagerEx.LayoutState r11) {
            r10.mLayoutState = r11;
            return r11;
        }

        public int getAvailable() {
            return this.mLayoutState.mAvailable;
        }

        public int getCurrentPosition() {
            return this.mLayoutState.mCurrentPosition;
        }

        public int getExtra() {
            return this.mLayoutState.mExtra;
        }

        public int getItemDirection() {
            return this.mLayoutState.mItemDirection;
        }

        public int getLayoutDirection() {
            return this.mLayoutState.mLayoutDirection;
        }

        public int getOffset() {
            return this.mLayoutState.mOffset;
        }

        public int getScrollingOffset() {
            return this.mLayoutState.mScrollingOffset;
        }

        public boolean hasMore(RecyclerView.State r10) {
            return this.mLayoutState.hasMore(r10);
        }

        public boolean hasScrapList() {
            if (this.mLayoutState.mScrapList == null) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isPreLayout() {
            return this.mLayoutState.mIsPreLayout;
        }

        public boolean isRecycle() {
            return this.mLayoutState.mRecycle;
        }

        public boolean isRefreshLayout() {
            return this.mLayoutState.mOnRefresLayout;
        }

        public View next(RecyclerView.Recycler r10) {
            return this.mLayoutState.next(r10);
        }

        public View retrieve(RecyclerView.Recycler r10, int r11) {
            ExposeLinearLayoutManagerEx.LayoutState r12 = this.mLayoutState;
            int r13 = r12.mCurrentPosition;
            r12.mCurrentPosition = r11;
            View r14 = next(r10);
            this.mLayoutState.mCurrentPosition = r13;
            return r14;
        }

        public void skipCurrentPosition() {
            ExposeLinearLayoutManagerEx.LayoutState r10 = this.mLayoutState;
            r10.mCurrentPosition += r10.mItemDirection;
        }

        public LayoutStateWrapper(ExposeLinearLayoutManagerEx.LayoutState r10) {
            this.mLayoutState = r10;
        }
    }

    public static class LayoutViewHolder extends RecyclerView.ViewHolder {
        public LayoutViewHolder(View r10) {
            super(r10);
        }
    }

    static {
        DEFAULT_LAYOUT_HELPER = new DefaultLayoutHelper();
    }

    public VirtualLayoutManager(@NonNull Context r10) {
        this(r10, 1);
    }

    public static /* synthetic */ RecyclerView access$000(VirtualLayoutManager r10) {
        return r10.mRecyclerView;
    }

    public static void enableDebugging(boolean r10) {
        sDebuggable = r10;
    }

    @Nullable
    private int findRangeLength(@NonNull Range<Integer> r10) {
        int r11 = this.mRangeLengths.size();
        if (r11 != 0) goto L5;
        return -1;
    L5:
        int r12 = r11 - 1;
        int r13 = 0;
        int r14 = -1;
    L6:
        Pair<Range<Integer>, Integer> r15 = null;
        if (r13 > r12) goto L25;
        r14 = (r13 + r12) / 2;
        Pair<Range<Integer>, Integer> r16 = this.mRangeLengths.get(r14);
        Range<T> r17 = (Range) r16.first;
        if (r17 == 0) goto L25;
        if (r17.contains(r10.getLower()) == true) goto L24;
        if (r17.contains(r10.getUpper()) == true) goto L24;
        if (r10.contains(r17) == true) goto L24;
        if (((Integer) r17.getLower()).intValue() > ((Integer) r10.getUpper()).intValue()) goto L20;
        if (((Integer) r17.getUpper()).intValue() >= ((Integer) r10.getLower()).intValue()) goto L6;
        r13 = r14 + 1;
        goto L6
    L20:
        r12 = r14 - 1;
    L24:
        r15 = r16;
    L25:
        if (r15 != null) goto L28;
        return -1;
    L28:
        return r14;
    }

    private void measureChildWithDecorations(View r10, int r11, int r12) {
        calculateItemDecorationsForChild(r10, this.mDecorInsets);
        Rect r13 = this.mDecorInsets;
        int r14 = updateSpecWithExtra(r11, r13.left, r13.right);
        Rect r15 = this.mDecorInsets;
        r10.measure(r14, updateSpecWithExtra(r12, r15.top, r15.bottom));
    }

    private void measureChildWithDecorationsAndMargin(View r10, int r11, int r12) {
        calculateItemDecorationsForChild(r10, this.mDecorInsets);
        RecyclerView.LayoutParams r13 = (RecyclerView.LayoutParams) r10.getLayoutParams();
        if (getOrientation() != 1) goto L6;
        int r14 = ((ViewGroup.MarginLayoutParams) r13).leftMargin;
        Rect r15 = this.mDecorInsets;
        r11 = updateSpecWithExtra(r11, r14 + r15.left, ((ViewGroup.MarginLayoutParams) r13).rightMargin + r15.right);
    L6:
        if (getOrientation() != 0) goto L8;
        Rect r16 = this.mDecorInsets;
        r12 = updateSpecWithExtra(r12, r16.top, r16.bottom);
    L8:
        r10.measure(r11, r12);
    }

    private void runPostLayout(RecyclerView.Recycler r11, RecyclerView.State r12, int r13) {
        int r10 = this.mNested - 1;
        this.mNested = r10;
        if (r10 > 0) goto L15;
        this.mNested = 0;
        int r14 = findFirstVisibleItemPosition();
        int r15 = findLastVisibleItemPosition();
        Iterator<LayoutHelper> r16 = this.mHelperFinder.iterator();
    L6:
        if (r16.hasNext() == false) goto L23;
        r16.next().afterLayout(r11, r12, r14, r15, r13, this);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        if (sDebuggable == false) goto L6;
        throw e;
    L23:
        return;
    }

    private void runPreLayout(RecyclerView.Recycler r10, RecyclerView.State r11) {
        if (this.mNested != 0) goto L8;
        Iterator<LayoutHelper> r12 = this.mHelperFinder.reverse().iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        r12.next().beforeLayout(r10, r11, this);
    L8:
        this.mNested++;
    }

    private void setDefaultLayoutHelper(@NonNull LayoutHelper r10) {
        if (r10 == null) goto L6;
        this.mDefaultLayoutHelper = r10;
        return;
    L6:
        throw new IllegalArgumentException("layoutHelper should not be null");
    }

    private int updateSpecWithExtra(int r10, int r11, int r12) {
        if (r11 != 0) goto L5;
        if (r12 != 0) goto L5;
        return r10;
    L5:
        int r13 = View.MeasureSpec.getMode(r10);
        if (r13 == Integer.MIN_VALUE) goto L12;
        if (r13 == 1073741824) goto L12;
        return r10;
    L12:
        if (((View.MeasureSpec.getSize(r10) - r11) - r12) >= 0) goto L16;
        return View.MeasureSpec.makeMeasureSpec(0, r13);
    L16:
        return View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(r10) - r11) - r12, r13);
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void addBackgroundView(View r10, boolean r11) {
        showView(r10);
        if (r11 == false) goto L5;
        int r12 = 0;
    L6:
        addView(r10, r12);
        return;
    L5:
        r12 = -1;
        goto L6
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void addChildView(View r10, int r11) {
        super.addView(r10, r11);
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void addFixedView(View r10) {
        addOffFlowView(r10, false);
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void addOffFlowView(View r10, boolean r11) {
        showView(r10);
        addHiddenView(r10, r11);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public /* bridge */ /* synthetic */ void assertNotInLayoutOrScroll(String r10) {
        super.assertNotInLayoutOrScroll(r10);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (super.canScrollHorizontally() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mNoScrolling == true) goto L7;
        return true;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (super.canScrollVertically() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mNoScrolling == true) goto L7;
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams r10) {
        return r10 instanceof LayoutParams;
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx
    public int computeAlignOffset(View r10, boolean r11, boolean r12) {
        return computeAlignOffset(getPosition(r10), r11, r12);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public /* bridge */ /* synthetic */ PointF computeScrollVectorForPosition(int r10) {
        return super.computeScrollVectorForPosition(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void detachAndScrapAttachedViews(RecyclerView.Recycler r10) {
        int r11 = getChildCount() - 1;
    L3:
        if (r11 < 0) goto L10;
        RecyclerView.ViewHolder r12 = getChildViewHolder(getChildAt(r11));
        if ((r12 instanceof CacheViewHolder) == false) goto L9;
        if (((CacheViewHolder) r12).needCached() == false) goto L9;
        ExposeLinearLayoutManagerEx.ViewHolderWrapper.setFlags(r12, 0, 6);
    L9:
        r11 = r11 - 1;
        goto L3
    L10:
        super.detachAndScrapAttachedViews(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void detachAndScrapView(View r10, RecyclerView.Recycler r11) {
        super.detachAndScrapView(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void detachAndScrapViewAt(int r10, RecyclerView.Recycler r11) {
        RecyclerView.ViewHolder r12 = getChildViewHolder(getChildAt(r10));
        if ((r12 instanceof CacheViewHolder) == true) goto L5;
    L7:
        super.detachAndScrapViewAt(r10, r11);
        return;
    L5:
        if (((CacheViewHolder) r12).needCached() == false) goto L7;
        ExposeLinearLayoutManagerEx.ViewHolderWrapper.setFlags(r12, 0, 4);
        goto L7
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager
    public /* bridge */ /* synthetic */ int findFirstVisibleItemPosition() {
        return super.findFirstVisibleItemPosition();
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager
    public /* bridge */ /* synthetic */ int findLastVisibleItemPosition() {
        return super.findLastVisibleItemPosition();
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public LayoutHelper findLayoutHelperByPosition(int r10) {
        return this.mHelperFinder.getLayoutHelper(r10);
    }

    public LayoutHelper findNeighbourNonfixLayoutHelper(LayoutHelper r10, boolean r11) {
        if (r10 != null) goto L5;
        return null;
    L5:
        List<LayoutHelper> r12 = this.mHelperFinder.getLayoutHelpers();
        int r13 = r12.indexOf(r10);
        if (r13 != (-1)) goto L8;
        return null;
    L8:
        if (r11 == false) goto L10;
        int r14 = r13 - 1;
    L11:
        if (r14 >= 0) goto L13;
    L20:
        return null;
    L13:
        if (r14 >= r12.size()) goto L20;
        LayoutHelper r15 = r12.get(r14);
        if (r15 == null) goto L20;
        if (r15.isFixLayout() == false) goto L19;
        return null;
    L19:
        return r15;
    L10:
        r14 = r13 + 1;
        goto L11
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View findViewByPosition(int r10) {
        View r11 = super.findViewByPosition(r10);
        if (r11 != null) goto L5;
    L7:
        int r12 = 0;
    L9:
        if (r12 >= getChildCount()) goto L16;
        View r13 = getChildAt(r12);
        if (r13 == null) goto L15;
        if (getPosition(r13) != r10) goto L15;
        return r13;
    L15:
        r12 = r12 + 1;
        goto L9
    L16:
        return null;
    L5:
        if (getPosition(r11) != r10) goto L7;
        return r11;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r10) {
        if ((r10 instanceof LayoutParams) == false) goto L7;
        return new LayoutParams((LayoutParams) r10);
    L7:
        if ((r10 instanceof RecyclerView.LayoutParams) == false) goto L11;
        return new LayoutParams((RecyclerView.LayoutParams) r10);
    L11:
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L15;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r10);
    L15:
        return new LayoutParams(r10);
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public final View generateLayoutView() {
        RecyclerView r10 = this.mRecyclerView;
        if (r10 != null) goto L6;
        return null;
    L6:
        View r11 = this.mLayoutViewFatory.generateLayoutView(r10.getContext());
        LayoutParams r12 = new LayoutParams(-2, -2);
        ExposeLinearLayoutManagerEx.attachViewHolder(r12, new LayoutViewHolder(r11));
        r11.setLayoutParams(r12);
        return r11;
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public int getChildMeasureSpec(int r10, int r11, boolean r12) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(r10, 0, r11, r12);
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public RecyclerView.ViewHolder getChildViewHolder(View r10) {
        RecyclerView r11 = this.mRecyclerView;
        if (r11 != null) goto L5;
        return null;
    L5:
        return r11.getChildViewHolder(r10);
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public int getContentHeight() {
        return super.getHeight();
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public int getContentWidth() {
        return super.getWidth();
    }

    public List<View> getFixedViews() {
        if (this.mRecyclerView == null) goto L5;
        LinkedList r10 = new LinkedList();
        Iterator<LayoutHelper> r11 = this.mHelperFinder.iterator();
    L8:
        if (r11.hasNext() == false) goto L12;
        View r12 = r11.next().getFixedView();
        if (r12 == null) goto L8;
        r10.add(r12);
        goto L8
    L12:
        return r10;
    L5:
        return Collections.emptyList();
    }

    @NonNull
    public List<LayoutHelper> getLayoutHelpers() {
        return this.mHelperFinder.getLayoutHelpers();
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public OrientationHelperEx getMainOrientationHelper() {
        return this.mOrientationHelper;
    }

    public int getOffsetToStart() {
        int r10 = -1;
        if (getChildCount() != 0) goto L5;
        return -1;
    L5:
        int r11 = 0;
        View r12 = getChildAt(0);
        if (r12 != null) goto L8;
        return -1;
    L8:
        int r13 = getPosition(r12);
        int r14 = findRangeLength(Range.create(Integer.valueOf(r13), Integer.valueOf(r13)));
        if (r14 >= 0) goto L11;
    L19:
        return r10;
    L11:
        if (r14 >= this.mRangeLengths.size()) goto L19;
        r10 = -this.mOrientationHelper.getDecoratedStart(r12);
    L14:
        if (r11 >= r14) goto L19;
        Pair<Range<Integer>, Integer> r15 = this.mRangeLengths.get(r11);
        if (r15 == null) goto L18;
        r10 = r10 + ((Integer) r15.second).intValue();
    L18:
        r11 = r11 + 1;
        goto L14
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, com.alibaba.android.vlayout.LayoutManagerHelper
    public int getOrientation() {
        return super.getOrientation();
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public OrientationHelperEx getSecondaryOrientationHelper() {
        return this.mSecondaryOrientationHelper;
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, com.alibaba.android.vlayout.LayoutManagerHelper
    public void hideView(View r10) {
        super.hideView(r10);
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public boolean isDoLayoutRTL() {
        return isLayoutRTL();
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, com.alibaba.android.vlayout.LayoutManagerHelper
    public boolean isEnableMarginOverLap() {
        return this.mEnableMarginOverlapping;
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public boolean isViewHolderUpdated(View r10) {
        RecyclerView.ViewHolder r11 = getChildViewHolder(r10);
        if (r11 != null) goto L5;
    L8:
        return true;
    L5:
        if (ExposeLinearLayoutManagerEx.isViewHolderUpdated(r11) == true) goto L8;
        return false;
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void layoutChild(View r10, int r11, int r12, int r13, int r14) {
        layoutDecorated(r10, r11, r12, r13, r14);
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void layoutChildWithMargins(View r10, int r11, int r12, int r13, int r14) {
        ViewGroup.MarginLayoutParams r15 = (ViewGroup.MarginLayoutParams) r10.getLayoutParams();
        layoutDecorated(r10, r11 + r15.leftMargin, r12 + r15.topMargin, r13 - r15.rightMargin, r14 - r15.bottomMargin);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx
    public void layoutChunk(RecyclerView.Recycler r10, RecyclerView.State r11, ExposeLinearLayoutManagerEx.LayoutState r12, LayoutChunkResult r13) {
        int r14 = r12.mCurrentPosition;
        LayoutStateWrapper.access$102(this.mTempLayoutStateWrapper, r12);
        LayoutHelperFinder r15 = this.mHelperFinder;
        if (r15 != null) goto L5;
        LayoutHelper r16 = null;
    L6:
        if (r16 != null) goto L8;
        r16 = this.mDefaultLayoutHelper;
    L8:
        r16.doLayout(r10, r11, this.mTempLayoutStateWrapper, r13, this);
        LayoutStateWrapper.access$102(this.mTempLayoutStateWrapper, null);
        int r17 = r12.mCurrentPosition;
        if (r17 != r14) goto L11;
        Log.w(TAG, "layoutHelper[" + r16.getClass().getSimpleName() + "@" + r16.toString() + "] consumes no item!");
        r13.mFinished = true;
        return;
    L11:
        int r18 = r17 - r12.mItemDirection;
        if (r13.mIgnoreConsumed == false) goto L14;
        int r19 = 0;
    L15:
        Range<Integer> r110 = new Range(Integer.valueOf(Math.min(r14, r18)), Integer.valueOf(Math.max(r14, r18)));
        int r111 = findRangeLength(r110);
        if (r111 < 0) goto L25;
        Pair<Range<Integer>, Integer> r112 = this.mRangeLengths.get(r111);
        if (r112 != null) goto L20;
    L24:
        this.mRangeLengths.remove(r111);
        goto L25
    L20:
        if (((Range) r112.first).equals(r110) == false) goto L24;
        if (((Integer) r112.second).intValue() != r19) goto L24;
        return;
    L25:
        this.mRangeLengths.add(Pair.create(r110, Integer.valueOf(r19)));
        Collections.sort(this.mRangeLengths, new AnonymousClass2(this));
        return;
    L14:
        r19 = r13.mConsumed;
        goto L15
    L5:
        r16 = r15.getLayoutHelper(r14);
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, com.alibaba.android.vlayout.LayoutManagerHelper
    public void measureChild(View r10, int r11, int r12) {
        measureChildWithDecorations(r10, r11, r12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, com.alibaba.android.vlayout.LayoutManagerHelper
    public void measureChildWithMargins(View r10, int r11, int r12) {
        measureChildWithDecorationsAndMargin(r10, r11, r12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void moveView(int r10, int r11) {
        super.moveView(r10, r11);
    }

    public int obtainExtraMargin(View r10, boolean r11) {
        return obtainExtraMargin(r10, r11, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenHorizontal(int r10) {
        super.offsetChildrenHorizontal(r10);
        Iterator<LayoutHelper> r11 = this.mHelperFinder.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onOffsetChildrenHorizontal(r10, this);
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenVertical(int r10) {
        super.offsetChildrenVertical(r10);
        Iterator<LayoutHelper> r11 = this.mHelperFinder.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onOffsetChildrenVertical(r10, this);
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter r10, RecyclerView.Adapter r11) {
        super.onAdapterChanged(r10, r11);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx
    public void onAnchorReady(RecyclerView.State r10, ExposeLinearLayoutManagerEx.AnchorInfo r11) {
        super.onAnchorReady(r10, r11);
        boolean r12 = true;
    L3:
        if (r12 == false) goto L12;
        AnchorInfoWrapper r13 = this.mTempAnchorInfoWrapper;
        int r14 = r11.mPosition;
        r13.position = r14;
        r13.coordinate = r11.mCoordinate;
        r13.layoutFromEnd = r11.mLayoutFromEnd;
        LayoutHelper r15 = this.mHelperFinder.getLayoutHelper(r14);
        if (r15 == null) goto L7;
        r15.checkAnchorInfo(r10, this.mTempAnchorInfoWrapper, this);
    L7:
        AnchorInfoWrapper r16 = this.mTempAnchorInfoWrapper;
        int r17 = r16.position;
        if (r17 != r11.mPosition) goto L10;
        r12 = false;
    L11:
        r11.mCoordinate = r16.coordinate;
        r16.position = -1;
        goto L3
    L10:
        r11.mPosition = r17;
        goto L11
    L12:
        AnchorInfoWrapper r18 = this.mTempAnchorInfoWrapper;
        r18.position = r11.mPosition;
        r18.coordinate = r11.mCoordinate;
        Iterator<LayoutHelper> r19 = this.mHelperFinder.iterator();
    L14:
        if (r19.hasNext() == false) goto L16;
        r19.next().onRefreshLayout(r10, this.mTempAnchorInfoWrapper, this);
        goto L14
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView r10) {
        super.onAttachedToWindow(r10);
        this.mRecyclerView = r10;
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView r10, RecyclerView.Recycler r11) {
        super.onDetachedFromWindow(r10, r11);
        Iterator<LayoutHelper> r12 = this.mHelperFinder.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r12.next().clear(this);
        goto L4
    L6:
        this.mRecyclerView = null;
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public /* bridge */ /* synthetic */ View onFocusSearchFailed(View r10, int r11, RecyclerView.Recycler r12, RecyclerView.State r13) {
        return super.onFocusSearchFailed(r10, r11, r12, r13);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView r10, int r11, int r12) {
        onItemsChanged(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView r10) {
        Iterator<LayoutHelper> r11 = this.mHelperFinder.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r11.next().onItemsChanged(this);
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView r10, int r11, int r12, int r13) {
        onItemsChanged(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView r10, int r11, int r12) {
        onItemsChanged(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView r10, int r11, int r12) {
        onItemsChanged(r10);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler r10, RecyclerView.State r11) {
        Trace.beginSection(TRACE_LAYOUT);
        if (this.mNoScrolling == true) goto L5;
    L7:
        runPreLayout(r10, r11);
        super.onLayoutChildren(r10, r11);     // Catch: Throwable -> L32 Exception -> L34
        runPostLayout(r10, r11, Channel.UNLIMITED);
        if (this.mNestedScrolling == true) goto L14;
        if (this.mNoScrolling == true) goto L14;
    L30:
        Trace.endSection();
        return;
    L14:
        if (this.mSpaceMeasuring == false) goto L30;
        this.mSpaceMeasured = true;
        View r12 = getChildAt(getChildCount() - 1);
        if (r12 == null) goto L24;
        RecyclerView.LayoutParams r13 = (RecyclerView.LayoutParams) r12.getLayoutParams();
        this.mMeasuredFullSpace = (getDecoratedBottom(r12) + ((ViewGroup.MarginLayoutParams) r13).bottomMargin) + computeAlignOffset(r12, true, false);
        RecyclerView r14 = this.mRecyclerView;
        if (r14 != null) goto L20;
    L25:
        this.mSpaceMeasuring = false;
        if (this.mRecyclerView == null) goto L30;
        if (getItemCount() <= 0) goto L30;
        this.mRecyclerView.post(new AnonymousClass1(this));
        goto L30
    L20:
        if (this.mNestedScrolling == false) goto L25;
        Object r15 = r14.getParent();
        if ((r15 instanceof View) == false) goto L25;
        this.mMeasuredFullSpace = Math.min(this.mMeasuredFullSpace, ((View) r15).getMeasuredHeight());
        goto L25
    L24:
        this.mSpaceMeasuring = false;
        goto L25
    L34:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L32
        throw e;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        runPostLayout(r10, r11, Channel.UNLIMITED);
        throw th;
    L5:
        if (r11.b() == false) goto L7;
        this.mSpaceMeasured = false;
        this.mSpaceMeasuring = true;
        goto L7
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onMeasure(RecyclerView.Recycler r10, RecyclerView.State r11, int r12, int r13) {
        if (this.mNoScrolling == false) goto L5;
    L8:
        RecyclerView r14 = this.mRecyclerView;
        int r15 = MAX_NO_SCROLLING_SIZE;
        if (r14 != null) goto L11;
    L18:
        int r16 = MAX_NO_SCROLLING_SIZE;
    L19:
        boolean r17 = this.mSpaceMeasured;
        if (r17 == false) goto L23;
        r16 = this.mMeasuredFullSpace;
    L23:
        if (this.mNoScrolling == false) goto L45;
        this.mSpaceMeasuring = !r17;
        if (getChildCount() <= 0) goto L27;
    L32:
        View r18 = getChildAt(getChildCount() - 1);
        int r19 = this.mMeasuredFullSpace;
        if (r18 == null) goto L36;
        r19 = computeAlignOffset(r18, true, false) + (getDecoratedBottom(r18) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) r18.getLayoutParams())).bottomMargin);
    L36:
        if (getChildCount() != getItemCount()) goto L42;
        if (r18 != null) goto L39;
    L41:
        r15 = r16;
    L43:
        r16 = r15;
        goto L45
    L39:
        if (r19 == this.mMeasuredFullSpace) goto L41;
    L42:
        this.mSpaceMeasured = false;
        this.mSpaceMeasuring = true;
        goto L43
    L27:
        if (getChildCount() != getItemCount()) goto L32;
        if (getItemCount() != 0) goto L45;
        this.mSpaceMeasured = true;
        this.mSpaceMeasuring = false;
        r16 = 0;
    L45:
        if (getOrientation() != 1) goto L47;
        super.onMeasure(r10, r11, r12, View.MeasureSpec.makeMeasureSpec(r16, Integer.MIN_VALUE));
        return;
    L47:
        super.onMeasure(r10, r11, View.MeasureSpec.makeMeasureSpec(r16, Integer.MIN_VALUE), r13);
        return;
    L11:
        if (this.mNestedScrolling == false) goto L18;
        r16 = this.mMaxMeasureSize;
        if (r16 > 0) goto L19;
        Object r20 = r14.getParent();
        if ((r20 instanceof View) == false) goto L18;
        r16 = ((View) r20).getMeasuredHeight();
        goto L19
    L5:
        if (this.mNestedScrolling == true) goto L8;
        super.onMeasure(r10, r11, r12, r13);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public /* bridge */ /* synthetic */ void onRestoreInstanceState(Parcelable r10) {
        super.onRestoreInstanceState(r10);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int r10) {
        super.onScrollStateChanged(r10);
        int r11 = findFirstVisibleItemPosition();
        int r12 = findLastVisibleItemPosition();
        Iterator<LayoutHelper> r13 = this.mHelperFinder.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r13.next().onScrollStateChanged(r10, r11, r12, this);
        goto L4
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx
    public void recycleChildren(RecyclerView.Recycler r11, int r12, int r13) {
        if (r12 != r13) goto L5;
        return;
    L5:
        if (sDebuggable == false) goto L8;
        Log.d(TAG, "Recycling " + Math.abs(r12 - r13) + " items");
    L8:
        if (r13 <= r12) goto L22;
        View r10 = getChildAt(r13 - 1);
        int r14 = getPosition(getChildAt(r12));
        int r15 = getPosition(r10);
        int r16 = r12;
    L10:
        if (r12 >= r13) goto L33;
        int r17 = getPosition(getChildAt(r16));
        if (r17 == (-1)) goto L20;
        LayoutHelper r18 = this.mHelperFinder.getLayoutHelper(r17);
        if (r18 != null) goto L16;
    L19:
        removeAndRecycleViewAt(r16, r11);
    L21:
        r12 = r12 + 1;
        goto L10
    L16:
        if (r18.isRecyclable(r17, r14, r15, this, true) == true) goto L19;
        r16 = r16 + 1;
        goto L21
    L20:
        removeAndRecycleViewAt(r16, r11);
        goto L21
    L33:
        return;
    L22:
        View r19 = getChildAt(r12);
        int r20 = getPosition(getChildAt(r13 + 1));
        int r21 = getPosition(r19);
    L23:
        if (r12 <= r13) goto L42;
        int r22 = getPosition(getChildAt(r12));
        if (r22 == (-1)) goto L31;
        LayoutHelper r23 = this.mHelperFinder.getLayoutHelper(r22);
        if (r23 != null) goto L29;
    L30:
        removeAndRecycleViewAt(r12, r11);
    L32:
        r12 = r12 - 1;
        goto L23
    L29:
        if (r23.isRecyclable(r22, r20, r21, this, false) == false) goto L32;
    L31:
        removeAndRecycleViewAt(r12, r11);
        goto L32
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void recycleView(View r10) {
        RecyclerView r11 = this.mRecyclerView;
        if (r11 == null) goto L6;
        RecyclerView.ViewHolder r12 = r11.getChildViewHolder(r10);
        this.mRecyclerView.getRecycledViewPool().putRecycledView(r12);
        return;
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void removeChildView(View r10) {
        removeView(r10);
    }

    public void runAdjustLayout() {
        int r10 = findFirstVisibleItemPosition();
        LayoutHelper r11 = this.mHelperFinder.getLayoutHelper(r10);
        int r12 = findLastVisibleItemPosition();
        LayoutHelper r13 = this.mHelperFinder.getLayoutHelper(r12);
        List<LayoutHelper> r14 = this.mHelperFinder.getLayoutHelpers();
        int r15 = r14.indexOf(r11);
        int r16 = r14.indexOf(r13);
    L3:
        if (r15 > r16) goto L11;
        r14.get(r15).adjustLayout(r10, r12, this);     // Catch: Exception -> L6
    L9:
        r15 = r15 + 1;
    L6:
        e = move-exception;
        if (sDebuggable == false) goto L9;
        throw e;
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public /* bridge */ /* synthetic */ int scrollHorizontallyBy(int r10, RecyclerView.Recycler r11, RecyclerView.State r12) {
        return super.scrollHorizontallyBy(r10, r11, r12);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx
    public int scrollInternalBy(int r10, RecyclerView.Recycler r11, RecyclerView.State r12) {
        Trace.beginSection(TRACE_SCROLL);
        runPreLayout(r11, r12);
        int r13 = 0;
    L7:
        th = move-exception;
        runPostLayout(r11, r12, 0);
        throw th;
    L9:
        e = move-exception;
        Log.w(TAG, Log.getStackTraceString(e), e);     // Catch: Throwable -> L7
        if (sDebuggable == false) goto L26;
        throw e;     // Catch: Throwable -> L7
    L26:
        runPostLayout(r11, r12, r13);
        Trace.endSection();
        return r13;
    L4:
        if (this.mNoScrolling == true) goto L12;
        r10 = super.scrollInternalBy(r10, r11, r12);     // Catch: Throwable -> L7 Exception -> L9
    L6:
        r13 = r10;
        goto L26
    L12:
        if (getChildCount() == 0) goto L27;
        if (r10 == 0) goto L27;
        this.mLayoutState.mRecycle = true;     // Catch: Throwable -> L7 Exception -> L9
        ensureLayoutStateExpose();     // Catch: Throwable -> L7 Exception -> L9
        if (r10 <= 0) goto L18;
        int r14 = 1;
    L19:
        int r15 = Math.abs(r10);     // Catch: Throwable -> L7 Exception -> L9
        updateLayoutStateExpose(r14, r15, true, r12);     // Catch: Throwable -> L7 Exception -> L9
        ExposeLinearLayoutManagerEx.LayoutState r16 = this.mLayoutState;     // Catch: Throwable -> L7 Exception -> L9
        int r17 = r16.mScrollingOffset + fill(r11, r16, r12, false);
        if (r17 >= 0) goto L24;
        runPostLayout(r11, r12, 0);
        return 0;
    L24:
        if (r15 <= r17) goto L6;
        r10 = r14 * r17;
        goto L6
    L18:
        r14 = -1;
    L27:
        runPostLayout(r11, r12, 0);
        return 0;
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int r10) {
        super.scrollToPosition(r10);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager
    public void scrollToPositionWithOffset(int r10, int r11) {
        super.scrollToPositionWithOffset(r10, r11);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public /* bridge */ /* synthetic */ int scrollVerticallyBy(int r10, RecyclerView.Recycler r11, RecyclerView.State r12) {
        return super.scrollVerticallyBy(r10, r11, r12);
    }

    public void setEnableMarginOverlapping(boolean r10) {
        this.mEnableMarginOverlapping = r10;
    }

    public void setFixOffset(int r10, int r11, int r12, int r13) {
        this.mFixAreaAdjustor = new FixAreaAdjuster(r10, r11, r12, r13);
    }

    public void setHelperFinder(@NonNull LayoutHelperFinder r10) {
        if (r10 == null) goto L15;
        LinkedList r11 = new LinkedList();
        LayoutHelperFinder r12 = this.mHelperFinder;
        if (r12 == null) goto L9;
        Iterator<LayoutHelper> r13 = r12.iterator();
    L7:
        if (r13.hasNext() == false) goto L9;
        r11.add(r13.next());
    L9:
        this.mHelperFinder = r10;
        if (r11.size() <= 0) goto L12;
        this.mHelperFinder.setLayouts(r11);
    L12:
        this.mSpaceMeasured = false;
        requestLayout();
        return;
    L15:
        throw new IllegalArgumentException("finder is null");
    }

    public void setLayoutHelpers(@Nullable List<LayoutHelper> r10) {
        Iterator<LayoutHelper> r11 = this.mHelperFinder.iterator();
    L4:
        if (r11.hasNext() == false) goto L7;
        LayoutHelper r12 = r11.next();
        this.oldHelpersSet.put(Integer.valueOf(System.identityHashCode(r12)), r12);
        goto L4
    L7:
        if (r10 == null) goto L24;
        int r13 = 0;
        int r14 = 0;
    L10:
        if (r13 >= r10.size()) goto L24;
        LayoutHelper r15 = r10.get(r13);
        if ((r15 instanceof FixAreaLayoutHelper) == false) goto L15;
        ((FixAreaLayoutHelper) r15).setAdjuster(this.mFixAreaAdjustor);
    L15:
        if ((r15 instanceof BaseLayoutHelper) == false) goto L20;
        BaseLayoutHelper.LayoutViewBindListener r16 = this.mLayoutViewBindListener;
        if (r16 == null) goto L20;
        ((BaseLayoutHelper) r15).setLayoutViewBindListener(r16);
    L20:
        if (r15.getItemCount() <= 0) goto L22;
        r15.setRange(r14, (r15.getItemCount() + r14) - 1);
    L23:
        r14 = r14 + r15.getItemCount();
        r13 = r13 + 1;
        goto L10
    L22:
        r15.setRange(-1, -1);
    L24:
        this.mHelperFinder.setLayouts(r10);
        Iterator<LayoutHelper> r17 = this.mHelperFinder.iterator();
    L26:
        if (r17.hasNext() == false) goto L28;
        LayoutHelper r18 = r17.next();
        this.newHelpersSet.put(Integer.valueOf(System.identityHashCode(r18)), r18);
        goto L26
    L28:
        Iterator<Map.Entry<Integer, LayoutHelper>> r19 = this.oldHelpersSet.entrySet().iterator();
    L30:
        if (r19.hasNext() == false) goto L34;
        Integer r20 = r19.next().getKey();
        if (this.newHelpersSet.containsKey(r20) == false) goto L30;
        this.newHelpersSet.remove(r20);
        r19.remove();
        goto L30
    L34:
        Iterator<LayoutHelper> r21 = this.oldHelpersSet.values().iterator();
    L36:
        if (r21.hasNext() == false) goto L39;
        r21.next().clear(this);
        goto L36
    L39:
        if (this.oldHelpersSet.isEmpty() == true) goto L41;
    L42:
        this.mSpaceMeasured = false;
    L43:
        this.oldHelpersSet.clear();
        this.newHelpersSet.clear();
        requestLayout();
        return;
    L41:
        if (this.newHelpersSet.isEmpty() == true) goto L43;
        goto L42
    }

    public void setLayoutViewFactory(@NonNull LayoutViewFactory r10) {
        if (r10 == null) goto L6;
        this.mLayoutViewFatory = r10;
        return;
    L6:
        throw new IllegalArgumentException("factory should not be null");
    }

    public void setNestedScrolling(boolean r10) {
        setNestedScrolling(r10, -1);
    }

    public void setNoScrolling(boolean r10) {
        this.mNoScrolling = r10;
        this.mSpaceMeasured = false;
        this.mMeasuredFullSpace = 0;
        this.mSpaceMeasuring = false;
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager
    public void setOrientation(int r10) {
        this.mOrientationHelper = OrientationHelperEx.createOrientationHelper(this, r10);
        super.setOrientation(r10);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx
    public /* bridge */ /* synthetic */ void setRecycleOffset(int r10) {
        super.setRecycleOffset(r10);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setReverseLayout(boolean r10) {
        if (r10 == true) goto L6;
        super.setReverseLayout(false);
        return;
    L6:
        throw new UnsupportedOperationException("VirtualLayoutManager does not support reverse layout in current version.");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean r10) {
        if (r10 == true) goto L6;
        super.setStackFromEnd(false);
        return;
    L6:
        throw new UnsupportedOperationException("VirtualLayoutManager does not support stack from end.");
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, com.alibaba.android.vlayout.LayoutManagerHelper
    public void showView(View r10) {
        super.showView(r10);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView r10, RecyclerView.State r11, int r12) {
        super.smoothScrollToPosition(r10, r11, r12);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        if (this.mCurrentPendingSavedState != null) goto L5;
        return true;
    L5:
        return false;
    }

    public VirtualLayoutManager(@NonNull Context r10, int r11) {
        this(r10, r11, false);
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void addChildView(LayoutStateWrapper r10, View r11) {
        if (r10.getItemDirection() != 1) goto L5;
        int r12 = -1;
    L6:
        addChildView(r10, r11, r12);
        return;
    L5:
        r12 = 0;
        goto L6
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx
    public int computeAlignOffset(int r10, boolean r11, boolean r12) {
        if (r10 == (-1)) goto L8;
        LayoutHelper r13 = this.mHelperFinder.getLayoutHelper(r10);
        if (r13 != null) goto L7;
        return 0;
    L7:
        return r13.computeAlignOffset(r10 - ((Integer) r13.getRange().getLower()).intValue(), r11, r12, this);
    L8:
        return 0;
    }

    public int obtainExtraMargin(View r10, boolean r11, boolean r12) {
        if (r10 != null) goto L4;
        return 0;
    L4:
        return computeAlignOffset(r10, r11, r12);
    }

    public void setNestedScrolling(boolean r10, int r11) {
        this.mNestedScrolling = r10;
        this.mSpaceMeasured = false;
        this.mSpaceMeasuring = false;
        this.mMeasuredFullSpace = 0;
    }

    public VirtualLayoutManager(@NonNull Context r10, int r11, boolean r12) {
        super(r10, r11, r12);
        int r13 = 0;
        this.mNoScrolling = false;
        this.mNestedScrolling = false;
        this.mEnableMarginOverlapping = false;
        this.mMaxMeasureSize = -1;
        this.mFixAreaAdjustor = FixAreaAdjuster.mDefaultAdjuster;
        this.newHelpersSet = new HashMap();
        this.oldHelpersSet = new HashMap();
        this.mTempAnchorInfoWrapper = new AnchorInfoWrapper();
        this.mNested = 0;
        this.mTempLayoutStateWrapper = new LayoutStateWrapper();
        this.mRangeLengths = new LinkedList();
        this.mDefaultLayoutHelper = DEFAULT_LAYOUT_HELPER;
        this.mLayoutViewFatory = new AnonymousClass3(this);
        this.mDecorInsets = new Rect();
        this.mSpaceMeasured = false;
        this.mMeasuredFullSpace = 0;
        this.mSpaceMeasuring = false;
        this.mOrientationHelper = OrientationHelperEx.createOrientationHelper(this, r11);
        if (r11 == 1) goto L6;
        r13 = 1;
    L6:
        this.mSecondaryOrientationHelper = OrientationHelperEx.createOrientationHelper(this, r13);
        setHelperFinder(new RangeLayoutHelperFinder());
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void addChildView(LayoutStateWrapper r10, View r11, int r12) {
        showView(r11);
        if (r10.hasScrapList() == true) goto L5;
        addView(r11, r12);
        return;
    L5:
        addDisappearingView(r11, r12);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context r10, AttributeSet r11) {
        return new InflateLayoutParams(r10, r11);
    }
}
