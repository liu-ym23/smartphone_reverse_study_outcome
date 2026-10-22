package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes17.dex */
public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    private static final String TAG = "GridLayoutManager";
    int[] mCachedBorders;
    final Rect mDecorInsets;
    boolean mPendingSpanCountChange;
    final SparseIntArray mPreLayoutSpanIndexCache;
    final SparseIntArray mPreLayoutSpanSizeCache;
    View[] mSet;
    int mSpanCount;
    SpanSizeLookup mSpanSizeLookup;
    private boolean mUsingSpansToEstimateScrollBarDimensions;

    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int r100) {
            return 1;
        }

        public DefaultSpanSizeLookup() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanIndex(int r100, int r101) {
            return r100 % r101;
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        int mSpanIndex;
        int mSpanSize;

        public int getSpanIndex() {
            return this.mSpanIndex;
        }

        public int getSpanSize() {
            return this.mSpanSize;
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r100) {
            super(r100);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(RecyclerView.LayoutParams r100) {
            super(r100);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(int r100, int r101) {
            super(r100, r101);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }
    }

    public static abstract class SpanSizeLookup {
        private boolean mCacheSpanGroupIndices;
        private boolean mCacheSpanIndices;
        final SparseIntArray mSpanGroupIndexCache;
        final SparseIntArray mSpanIndexCache;

        public abstract int getSpanSize(int r100);

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public SpanSizeLookup() {
            this.mSpanIndexCache = new SparseIntArray();
            this.mSpanGroupIndexCache = new SparseIntArray();
            this.mCacheSpanIndices = false;
            this.mCacheSpanGroupIndices = false;
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanGroupIndexCacheEnabled(boolean r100) {
            if (r100 == true) goto L4;
            this.mSpanGroupIndexCache.clear();
        L4:
            this.mCacheSpanGroupIndices = r100;
        }

        public void setSpanIndexCacheEnabled(boolean r100) {
            if (r100 == true) goto L4;
            this.mSpanGroupIndexCache.clear();
        L4:
            this.mCacheSpanIndices = r100;
        }

        public static int findFirstKeyLessThan(SparseIntArray r100, int r101) {
            int r102 = r100.size() - 1;
            int r103 = 0;
        L3:
            if (r103 > r102) goto L8;
            int r104 = (r103 + r102) >>> 1;
            if (r100.keyAt(r104) < r101) goto L6;
            r102 = r104 - 1;
            goto L3
        L6:
            r103 = r104 + 1;
            goto L3
        L8:
            int r105 = r103 - 1;
            if (r105 >= 0) goto L11;
            return -1;
        L11:
            if (r105 < r100.size()) goto L13;
            return -1;
        L13:
            return r100.keyAt(r105);
        }

        public int getCachedSpanGroupIndex(int r100, int r101) {
            if (this.mCacheSpanGroupIndices == false) goto L5;
            int r102 = this.mSpanGroupIndexCache.get(r100, -1);
            if (r102 == (-1)) goto L9;
            return r102;
        L9:
            int r103 = getSpanGroupIndex(r100, r101);
            this.mSpanGroupIndexCache.put(r100, r103);
            return r103;
        L5:
            return getSpanGroupIndex(r100, r101);
        }

        public int getCachedSpanIndex(int r100, int r101) {
            if (this.mCacheSpanIndices == false) goto L5;
            int r102 = this.mSpanIndexCache.get(r100, -1);
            if (r102 == (-1)) goto L9;
            return r102;
        L9:
            int r103 = getSpanIndex(r100, r101);
            this.mSpanIndexCache.put(r100, r103);
            return r103;
        L5:
            return getSpanIndex(r100, r101);
        }

        public int getSpanGroupIndex(int r100, int r101) {
            if (this.mCacheSpanGroupIndices == false) goto L9;
            int r102 = findFirstKeyLessThan(this.mSpanGroupIndexCache, r100);
            if (r102 == (-1)) goto L9;
            int r103 = this.mSpanGroupIndexCache.get(r102);
            int r104 = r102 + 1;
            int r105 = getCachedSpanIndex(r102, r101) + getSpanSize(r102);
            if (r105 != r101) goto L11;
            r103 = r103 + 1;
        L10:
            r105 = 0;
        L11:
            int r106 = getSpanSize(r100);
        L12:
            if (r104 >= r100) goto L20;
            int r107 = getSpanSize(r104);
            r105 = r105 + r107;
            if (r105 != r101) goto L16;
            r103 = r103 + 1;
            r105 = 0;
        L18:
            r104 = r104 + 1;
            goto L12
        L16:
            if (r105 <= r101) goto L18;
            r103 = r103 + 1;
            r105 = r107;
            goto L18
        L20:
            if ((r105 + r106) > r101) goto L22;
            return r103;
        L22:
            return r103 + 1;
        L9:
            r103 = 0;
            r104 = 0;
            goto L10
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:17:0x0030). Please report as a decompilation issue!!! */
        public int getSpanIndex(int r100, int r101) {
            int r102 = getSpanSize(r100);
            if (r102 != r101) goto L6;
            return 0;
        L6:
            if (this.mCacheSpanIndices == false) goto L10;
            int r103 = findFirstKeyLessThan(this.mSpanIndexCache, r100);
            if (r103 < 0) goto L10;
            int r104 = this.mSpanIndexCache.get(r103) + getSpanSize(r103);
        L17:
            r103 = r103 + 1;
        L11:
            if (r103 >= r100) goto L19;
            int r105 = getSpanSize(r103);
            r104 = r104 + r105;
            if (r104 != r101) goto L15;
            r104 = 0;
            goto L17
        L15:
            if (r104 <= r101) goto L17;
            r104 = r105;
            goto L17
        L19:
            if ((r102 + r104) > r101) goto L21;
            return r104;
        L21:
            return 0;
        L10:
            r103 = 0;
            r104 = 0;
            goto L11
        }
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    private void ensureViewSet() {
        View[] r100 = this.mSet;
        if (r100 != null) goto L5;
    L6:
        this.mSet = new View[this.mSpanCount];
        return;
    L5:
        if (r100.length != this.mSpanCount) goto L6;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation != 0) goto L7;
        return new LayoutParams(-2, -1);
    L7:
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState == null) goto L5;
    L7:
        return false;
    L5:
        if (this.mPendingSpanCountChange == true) goto L7;
        return true;
    }

    private void cachePreLayoutSpanMapping() {
        int r100 = getChildCount();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        LayoutParams r102 = (LayoutParams) getChildAt(r101).getLayoutParams();
        int r103 = r102.getViewLayoutPosition();
        this.mPreLayoutSpanSizeCache.put(r103, r102.getSpanSize());
        this.mPreLayoutSpanIndexCache.put(r103, r102.getSpanIndex());
        r101 = r101 + 1;
        goto L3
    }

    private void updateMeasurements() {
        if (getOrientation() != 1) goto L5;
        int r100 = getWidth() - getPaddingRight();
        int r101 = getPaddingLeft();
    L6:
        calculateItemBorders(r100 - r101);
        return;
    L5:
        r100 = getHeight() - getPaddingBottom();
        r101 = getPaddingTop();
        goto L6
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public SpanSizeLookup getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.mUsingSpansToEstimateScrollBarDimensions;
    }

    private void calculateItemBorders(int r100) {
        this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, r100);
    }

    private int computeScrollOffsetWithSpanInfo(RecyclerView.State r110) {
        if (getChildCount() != 0) goto L5;
    L19:
        return 0;
    L5:
        if (r110.getItemCount() == 0) goto L19;
        ensureLayoutState();
        boolean r100 = isSmoothScrollbarEnabled();
        View r101 = findFirstVisibleChildClosestToStart(!r100, true);
        View r102 = findFirstVisibleChildClosestToEnd(!r100, true);
        if (r101 == null) goto L19;
        if (r102 == null) goto L19;
        int r103 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r101), this.mSpanCount);
        int r104 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r102), this.mSpanCount);
        int r105 = Math.min(r103, r104);
        int r106 = Math.max(r103, r104);
        int r111 = this.mSpanSizeLookup.getCachedSpanGroupIndex(r110.getItemCount() - 1, this.mSpanCount) + 1;
        if (this.mShouldReverseLayout == false) goto L14;
        int r112 = Math.max(0, (r111 - r106) - 1);
    L15:
        if (r100 == true) goto L18;
        return r112;
    L18:
        return Math.round((r112 * (Math.abs(this.mOrientationHelper.getDecoratedEnd(r102) - this.mOrientationHelper.getDecoratedStart(r101)) / ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r102), this.mSpanCount) - this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r101), this.mSpanCount)) + 1))) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(r101)));
    L14:
        r112 = Math.max(0, r105);
        goto L15
    }

    private int computeScrollRangeWithSpanInfo(RecyclerView.State r100) {
        if (getChildCount() != 0) goto L5;
    L17:
        return 0;
    L5:
        if (r100.getItemCount() == 0) goto L17;
        ensureLayoutState();
        View r101 = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
        View r102 = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
        if (r101 == null) goto L17;
        if (r102 == null) goto L17;
        if (isSmoothScrollbarEnabled() == false) goto L14;
        int r103 = this.mOrientationHelper.getDecoratedEnd(r102) - this.mOrientationHelper.getDecoratedStart(r101);
        int r104 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r101), this.mSpanCount);
        return (int) ((r103 / ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r102), this.mSpanCount) - r104) + 1)) * (this.mSpanSizeLookup.getCachedSpanGroupIndex(r100.getItemCount() - 1, this.mSpanCount) + 1));
    L14:
        return this.mSpanSizeLookup.getCachedSpanGroupIndex(r100.getItemCount() - 1, this.mSpanCount) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams r100) {
        return r100 instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State r100) {
        if (this.mUsingSpansToEstimateScrollBarDimensions == false) goto L7;
        return computeScrollOffsetWithSpanInfo(r100);
    L7:
        return super.computeHorizontalScrollOffset(r100);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State r100) {
        if (this.mUsingSpansToEstimateScrollBarDimensions == false) goto L7;
        return computeScrollRangeWithSpanInfo(r100);
    L7:
        return super.computeHorizontalScrollRange(r100);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State r100) {
        if (this.mUsingSpansToEstimateScrollBarDimensions == false) goto L7;
        return computeScrollOffsetWithSpanInfo(r100);
    L7:
        return super.computeVerticalScrollOffset(r100);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State r100) {
        if (this.mUsingSpansToEstimateScrollBarDimensions == false) goto L7;
        return computeScrollRangeWithSpanInfo(r100);
    L7:
        return super.computeVerticalScrollRange(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r100);
    L7:
        return new LayoutParams(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView r100) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State r100) {
        super.onLayoutCompleted(r100);
        this.mPendingSpanCountChange = false;
    }

    public void setSpanCount(int r100) {
        if (r100 != this.mSpanCount) goto L5;
        return;
    L5:
        this.mPendingSpanCountChange = true;
        if (r100 < 1) goto L10;
        this.mSpanCount = r100;
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        requestLayout();
        return;
    L10:
        throw new IllegalArgumentException("Span count should be at least 1. Provided " + r100);
    }

    public void setSpanSizeLookup(SpanSizeLookup r100) {
        this.mSpanSizeLookup = r100;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean r100) {
        if (r100 == true) goto L6;
        super.setStackFromEnd(false);
        return;
    L6:
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean r100) {
        this.mUsingSpansToEstimateScrollBarDimensions = r100;
    }

    public GridLayoutManager(Context r100, int r101) {
        super(r100);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(r101);
    }

    private void guessMeasurement(float r100, int r101) {
        calculateItemBorders(Math.max(Math.round(r100 * this.mSpanCount), r101));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context r100, AttributeSet r101) {
        return new LayoutParams(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler r100, RecyclerView.State r101) {
        if (this.mOrientation != 1) goto L7;
        return this.mSpanCount;
    L7:
        if (r101.getItemCount() >= 1) goto L11;
        return 0;
    L11:
        return getSpanGroupIndex(r100, r101, r101.getItemCount() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler r100, RecyclerView.State r101) {
        if (this.mOrientation != 0) goto L7;
        return this.mSpanCount;
    L7:
        if (r101.getItemCount() >= 1) goto L11;
        return 0;
    L11:
        return getSpanGroupIndex(r100, r101, r101.getItemCount() - 1) + 1;
    }

    public int getSpaceForSpanRange(int r100, int r101) {
        if (this.mOrientation == 1) goto L5;
    L8:
        int[] r102 = this.mCachedBorders;
        return r102[r101 + r100] - r102[r100];
    L5:
        if (isLayoutRTL() == false) goto L8;
        int[] r103 = this.mCachedBorders;
        int r104 = this.mSpanCount;
        return r103[r104 - r100] - r103[(r104 - r100) - r101];
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        if (r101.isPreLayout() == false) goto L5;
        cachePreLayoutSpanMapping();
    L5:
        super.onLayoutChildren(r100, r101);
        clearPreLayoutSpanMappingCache();
    }

    public static int[] calculateItemBorders(int[] r100, int r101, int r102) {
        int r103 = 1;
        if (r100 != null) goto L5;
    L8:
        r100 = new int[r101 + 1];
    L9:
        int r104 = 0;
        r100[0] = 0;
        int r105 = r102 / r101;
        int r106 = r102 % r101;
        int r107 = 0;
    L10:
        if (r103 > r101) goto L18;
        r104 = r104 + r106;
        if (r104 > 0) goto L14;
    L16:
        int r108 = r105;
    L17:
        r107 = r107 + r108;
        r100[r103] = r107;
        r103 = r103 + 1;
        goto L10
    L14:
        if ((r101 - r104) >= r106) goto L16;
        r108 = r105 + 1;
        r104 = r104 - r101;
        goto L17
    L18:
        return r100;
    L5:
        if (r100.length != (r101 + 1)) goto L8;
        if (r100[r100.length - 1] == r102) goto L9;
        goto L8
    }

    private int getSpanGroupIndex(RecyclerView.Recycler r100, RecyclerView.State r101, int r102) {
        if (r101.isPreLayout() == false) goto L5;
        int r103 = r100.convertPreLayoutPositionToPostLayout(r102);
        if (r103 != (-1)) goto L11;
        return 0;
    L11:
        return this.mSpanSizeLookup.getCachedSpanGroupIndex(r103, this.mSpanCount);
    L5:
        return this.mSpanSizeLookup.getCachedSpanGroupIndex(r102, this.mSpanCount);
    }

    private int getSpanIndex(RecyclerView.Recycler r100, RecyclerView.State r101, int r102) {
        if (r101.isPreLayout() == false) goto L5;
        int r103 = this.mPreLayoutSpanIndexCache.get(r102, -1);
        if (r103 == (-1)) goto L9;
        return r103;
    L9:
        int r104 = r100.convertPreLayoutPositionToPostLayout(r102);
        if (r104 != (-1)) goto L14;
        return 0;
    L14:
        return this.mSpanSizeLookup.getCachedSpanIndex(r104, this.mSpanCount);
    L5:
        return this.mSpanSizeLookup.getCachedSpanIndex(r102, this.mSpanCount);
    }

    private int getSpanSize(RecyclerView.Recycler r100, RecyclerView.State r101, int r102) {
        if (r101.isPreLayout() == false) goto L5;
        int r103 = this.mPreLayoutSpanSizeCache.get(r102, -1);
        if (r103 == (-1)) goto L9;
        return r103;
    L9:
        int r104 = r100.convertPreLayoutPositionToPostLayout(r102);
        if (r104 != (-1)) goto L14;
        return 1;
    L14:
        return this.mSpanSizeLookup.getSpanSize(r104);
    L5:
        return this.mSpanSizeLookup.getSpanSize(r102);
    }

    private void measureChild(View r100, int r110, boolean r111) {
        LayoutParams r101 = (LayoutParams) r100.getLayoutParams();
        Rect r102 = r101.mDecorInsets;
        int r103 = ((r102.top + r102.bottom) + ((ViewGroup.MarginLayoutParams) r101).topMargin) + ((ViewGroup.MarginLayoutParams) r101).bottomMargin;
        int r104 = ((r102.left + r102.right) + ((ViewGroup.MarginLayoutParams) r101).leftMargin) + ((ViewGroup.MarginLayoutParams) r101).rightMargin;
        int r105 = getSpaceForSpanRange(r101.mSpanIndex, r101.mSpanSize);
        if (this.mOrientation != 1) goto L5;
        int r112 = RecyclerView.LayoutManager.getChildMeasureSpec(r105, r110, r104, ((ViewGroup.MarginLayoutParams) r101).width, false);
        int r106 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getHeightMode(), r103, ((ViewGroup.MarginLayoutParams) r101).height, true);
    L6:
        measureChildWithDecorationsAndMargin(r100, r112, r106, r111);
        return;
    L5:
        int r113 = RecyclerView.LayoutManager.getChildMeasureSpec(r105, r110, r103, ((ViewGroup.MarginLayoutParams) r101).height, false);
        int r107 = RecyclerView.LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getWidthMode(), r104, ((ViewGroup.MarginLayoutParams) r101).width, true);
        r106 = r113;
        r112 = r107;
        goto L6
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void collectPrefetchPositionsForLayoutState(RecyclerView.State r100, LinearLayoutManager.LayoutState r101, RecyclerView.LayoutManager.LayoutPrefetchRegistry r102) {
        int r103 = this.mSpanCount;
        int r104 = 0;
    L4:
        if (r104 >= this.mSpanCount) goto L9;
        if (r101.hasMore(r100) == false) goto L13;
        if (r103 <= 0) goto L14;
        int r105 = r101.mCurrentPosition;
        r102.addPosition(r105, Math.max(0, r101.mScrollingOffset));
        r103 = r103 - this.mSpanSizeLookup.getSpanSize(r105);
        r101.mCurrentPosition += r101.mItemDirection;
        r104 = r104 + 1;
        goto L4
    L14:
        return;
    L13:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView r100, int r101, int r102) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView r100, int r101, int r102) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(r100, r101, r102);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(r100, r101, r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect r100, int r101, int r102) {
        if (this.mCachedBorders != null) goto L5;
        super.setMeasuredDimension(r100, r101, r102);
    L5:
        int r103 = getPaddingLeft() + getPaddingRight();
        int r104 = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation != 1) goto L8;
        int r105 = RecyclerView.LayoutManager.chooseSize(r102, r100.height() + r104, getMinimumHeight());
        int[] r106 = this.mCachedBorders;
        int r107 = RecyclerView.LayoutManager.chooseSize(r101, r106[r106.length - 1] + r103, getMinimumWidth());
    L9:
        setMeasuredDimension(r107, r105);
        return;
    L8:
        r107 = RecyclerView.LayoutManager.chooseSize(r101, r100.width() + r103, getMinimumWidth());
        int[] r108 = this.mCachedBorders;
        r105 = RecyclerView.LayoutManager.chooseSize(r102, r108[r108.length - 1] + r104, getMinimumHeight());
        goto L9
    }

    public GridLayoutManager(Context r100, AttributeSet r101, int r102, int r103) {
        super(r100, r101, r102, r103);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(RecyclerView.LayoutManager.getProperties(r100, r101, r102, r103).spanCount);
    }

    private void assignSpans(RecyclerView.Recycler r100, RecyclerView.State r101, int r102, boolean r103) {
        int r104 = 0;
        if (r103 == false) goto L5;
        int r105 = r102;
        int r106 = 0;
        int r107 = 1;
    L6:
        if (r106 == r105) goto L8;
        View r108 = this.mSet[r106];
        LayoutParams r109 = (LayoutParams) r108.getLayoutParams();
        int r110 = getSpanSize(r100, r101, getPosition(r108));
        r109.mSpanSize = r110;
        r109.mSpanIndex = r104;
        r104 = r104 + r110;
        r106 = r106 + r107;
        goto L6
    L8:
        return;
    L5:
        r106 = r102 - 1;
        r105 = -1;
        r107 = -1;
        goto L6
    }

    private void ensureAnchorIsInCorrectSpan(RecyclerView.Recycler r100, RecyclerView.State r101, LinearLayoutManager.AnchorInfo r102, int r103) {
        if (r103 != 1) goto L5;
        boolean r104 = true;
    L6:
        int r105 = getSpanIndex(r100, r101, r102.mPosition);
        if (r104 == false) goto L12;
    L8:
        if (r105 <= 0) goto L23;
        int r106 = r102.mPosition;
        if (r106 <= 0) goto L24;
        int r107 = r106 - 1;
        r102.mPosition = r107;
        r105 = getSpanIndex(r100, r101, r107);
        goto L8
    L24:
        return;
    L23:
        return;
    L12:
        int r108 = r101.getItemCount() - 1;
        int r109 = r102.mPosition;
    L13:
        if (r109 >= r108) goto L17;
        int r110 = r109 + 1;
        int r111 = getSpanIndex(r100, r101, r110);
        if (r111 <= r105) goto L17;
        r109 = r110;
        r105 = r111;
    L17:
        r102.mPosition = r109;
        return;
    L5:
        r104 = false;
        goto L6
    }

    private void measureChildWithDecorationsAndMargin(View r100, int r101, int r102, boolean r103) {
        RecyclerView.LayoutParams r104 = (RecyclerView.LayoutParams) r100.getLayoutParams();
        if (r103 == false) goto L5;
        boolean r105 = shouldReMeasureChild(r100, r101, r102, r104);
    L6:
        if (r105 == false) goto L9;
        r100.measure(r101, r102);
        return;
    L9:
        return;
    L5:
        r105 = shouldMeasureChild(r100, r101, r102, r104);
        goto L6
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public View findReferenceChild(RecyclerView.Recycler r100, RecyclerView.State r110, boolean r111, boolean r112) {
        int r113 = getChildCount();
        int r101 = 1;
        if (r112 == false) goto L5;
        int r114 = getChildCount() - 1;
        int r115 = -1;
        r101 = -1;
    L6:
        int r102 = r110.getItemCount();
        ensureLayoutState();
        int r103 = this.mOrientationHelper.getStartAfterPadding();
        int r104 = this.mOrientationHelper.getEndAfterPadding();
        View r105 = null;
        View r106 = null;
    L7:
        if (r114 == r115) goto L27;
        View r107 = getChildAt(r114);
        int r108 = getPosition(r107);
        if (r108 < 0) goto L26;
        if (r108 >= r102) goto L26;
        if (getSpanIndex(r100, r110, r108) != 0) goto L26;
        if (((RecyclerView.LayoutParams) r107.getLayoutParams()).isItemRemoved() == false) goto L19;
        if (r106 != null) goto L26;
        r106 = r107;
        goto L26
    L19:
        if (this.mOrientationHelper.getDecoratedStart(r107) < r104) goto L21;
    L24:
        if (r105 != null) goto L26;
        r105 = r107;
        goto L26
    L21:
        if (this.mOrientationHelper.getDecoratedEnd(r107) < r103) goto L24;
        return r107;
    L26:
        r114 = r114 + r101;
        goto L7
    L27:
        if (r105 == null) goto L30;
        return r105;
    L30:
        return r106;
    L5:
        r115 = r113;
        r114 = 0;
        goto L6
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void layoutChunk(RecyclerView.Recycler r110, RecyclerView.State r111, LinearLayoutManager.LayoutState r210, LinearLayoutManager.LayoutChunkResult r211) {
        int r100 = this.mOrientationHelper.getModeInOther();
        if (r100 == 1073741824) goto L5;
        boolean r101 = true;
    L7:
        if (getChildCount() <= 0) goto L9;
        int r112 = this.mCachedBorders[this.mSpanCount];
    L10:
        if (r101 == false) goto L13;
        updateMeasurements();
    L13:
        if (r210.mItemDirection != 1) goto L15;
        boolean r113 = true;
    L16:
        int r114 = this.mSpanCount;
        if (r113 == true) goto L19;
        r114 = getSpanIndex(r110, r111, r210.mCurrentPosition) + getSpanSize(r110, r111, r210.mCurrentPosition);
    L19:
        int r115 = 0;
    L21:
        if (r115 >= this.mSpanCount) goto L36;
        if (r210.hasMore(r111) == false) goto L36;
        if (r114 <= 0) goto L36;
        int r116 = r210.mCurrentPosition;
        int r117 = getSpanSize(r110, r111, r116);
        if (r117 > this.mSpanCount) goto L35;
        r114 = r114 - r117;
        if (r114 < 0) goto L36;
        View r102 = r210.next(r110);
        if (r102 == null) goto L36;
        this.mSet[r115] = r102;
        r115 = r115 + 1;
        goto L21
    L35:
        throw new IllegalArgumentException("Item at position " + r116 + " requires " + r117 + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
    L36:
        if (r115 != 0) goto L39;
        r211.mFinished = true;
        return;
    L39:
        assignSpans(r110, r111, r115, r113);
        float r103 = 0.0f;
        int r104 = 0;
        int r105 = 0;
    L40:
        if (r104 >= r115) goto L56;
        View r118 = this.mSet[r104];
        if (r210.mScrapList != null) goto L46;
        if (r113 == false) goto L45;
        addView(r118);
    L49:
        calculateItemDecorationsForChild(r118, this.mDecorInsets);
        measureChild(r118, r100, false);
        int r119 = this.mOrientationHelper.getDecoratedMeasurement(r118);
        if (r119 <= r105) goto L52;
        r105 = r119;
    L52:
        float r120 = (this.mOrientationHelper.getDecoratedMeasurementInOther(r118) * 1.0f) / ((LayoutParams) r118.getLayoutParams()).mSpanSize;
        if (r120 <= r103) goto L55;
        r103 = r120;
    L55:
        r104 = r104 + 1;
        goto L40
    L45:
        addView(r118, 0);
        goto L49
    L46:
        if (r113 == false) goto L48;
        addDisappearingView(r118);
        goto L49
    L48:
        addDisappearingView(r118, 0);
        goto L49
    L56:
        if (r101 == false) goto L63;
        guessMeasurement(r103, r112);
        int r106 = 0;
        r105 = 0;
    L58:
        if (r106 >= r115) goto L63;
        View r107 = this.mSet[r106];
        measureChild(r107, 1073741824, true);
        int r108 = this.mOrientationHelper.getDecoratedMeasurement(r107);
        if (r108 <= r105) goto L62;
        r105 = r108;
    L62:
        r106 = r106 + 1;
    L63:
        int r109 = 0;
    L64:
        if (r109 >= r115) goto L74;
        View r121 = this.mSet[r109];
        if (this.mOrientationHelper.getDecoratedMeasurement(r121) == r105) goto L73;
        LayoutParams r122 = (LayoutParams) r121.getLayoutParams();
        Rect r123 = r122.mDecorInsets;
        int r124 = ((r123.top + r123.bottom) + ((ViewGroup.MarginLayoutParams) r122).topMargin) + ((ViewGroup.MarginLayoutParams) r122).bottomMargin;
        int r125 = ((r123.left + r123.right) + ((ViewGroup.MarginLayoutParams) r122).leftMargin) + ((ViewGroup.MarginLayoutParams) r122).rightMargin;
        int r126 = getSpaceForSpanRange(r122.mSpanIndex, r122.mSpanSize);
        if (this.mOrientation != 1) goto L70;
        int r127 = RecyclerView.LayoutManager.getChildMeasureSpec(r126, 1073741824, r125, ((ViewGroup.MarginLayoutParams) r122).width, false);
        int r128 = View.MeasureSpec.makeMeasureSpec(r105 - r124, 1073741824);
    L71:
        measureChildWithDecorationsAndMargin(r121, r127, r128, true);
        goto L73
    L70:
        int r129 = View.MeasureSpec.makeMeasureSpec(r105 - r125, 1073741824);
        r128 = RecyclerView.LayoutManager.getChildMeasureSpec(r126, 1073741824, r124, ((ViewGroup.MarginLayoutParams) r122).height, false);
        r127 = r129;
    L73:
        r109 = r109 + 1;
        goto L64
    L74:
        r211.mConsumed = r105;
        if (this.mOrientation != 1) goto L82;
        if (r210.mLayoutDirection != (-1)) goto L79;
        int r130 = r210.mOffset;
        int r131 = r130 - r105;
    L80:
        int r132 = r131;
        int r133 = 0;
        int r134 = 0;
    L86:
        int r135 = 0;
    L87:
        if (r135 >= r115) goto L102;
        View r136 = this.mSet[r135];
        LayoutParams r137 = (LayoutParams) r136.getLayoutParams();
        if (this.mOrientation == 1) goto L91;
        int r138 = getPaddingTop() + this.mCachedBorders[r137.mSpanIndex];
        int r139 = r138;
        int r140 = r133;
        int r141 = r134;
        r130 = this.mOrientationHelper.getDecoratedMeasurementInOther(r136) + r138;
    L96:
        layoutDecoratedWithMargins(r136, r141, r139, r140, r130);
        if (r137.isItemRemoved() == false) goto L99;
    L100:
        r211.mIgnoreConsumed = true;
    L101:
        r211.mFocusable |= r136.hasFocusable();
        r135 = r135 + 1;
        r130 = r130;
        r133 = r140;
        r134 = r141;
        r132 = r139;
        goto L87
    L99:
        if (r137.isItemChanged() == false) goto L101;
    L91:
        if (isLayoutRTL() == false) goto L93;
        int r142 = getPaddingLeft() + this.mCachedBorders[this.mSpanCount - r137.mSpanIndex];
        r140 = r142;
        r141 = r142 - this.mOrientationHelper.getDecoratedMeasurementInOther(r136);
    L94:
        r139 = r132;
        goto L96
    L93:
        int r143 = getPaddingLeft() + this.mCachedBorders[r137.mSpanIndex];
        r141 = r143;
        r140 = this.mOrientationHelper.getDecoratedMeasurementInOther(r136) + r143;
        goto L94
    L102:
        Arrays.fill(this.mSet, null);
        return;
    L79:
        r131 = r210.mOffset;
        r130 = r131 + r105;
        goto L80
    L82:
        if (r210.mLayoutDirection != (-1)) goto L84;
        int r144 = r210.mOffset;
        int r145 = r144 - r105;
    L85:
        r134 = r145;
        r132 = 0;
        r133 = r144;
        r130 = 0;
        goto L86
    L84:
        r145 = r210.mOffset;
        r144 = r145 + r105;
        goto L85
    L15:
        r113 = false;
        goto L16
    L9:
        r112 = 0;
        goto L10
    L5:
        r101 = false;
        goto L7
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void onAnchorReady(RecyclerView.Recycler r100, RecyclerView.State r101, LinearLayoutManager.AnchorInfo r102, int r103) {
        super.onAnchorReady(r100, r101, r102, r103);
        updateMeasurements();
        if (r101.getItemCount() > 0) goto L5;
    L7:
        ensureViewSet();
        return;
    L5:
        if (r101.isPreLayout() == true) goto L7;
        ensureAnchorIsInCorrectSpan(r100, r101, r102, r103);
        goto L7
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View r210, int r211, RecyclerView.Recycler r212, RecyclerView.State r213) {
        RecyclerView.Recycler r100 = r212;
        RecyclerView.State r101 = r213;
        View r102 = findContainingItemView(r210);
        View r103 = null;
        if (r102 != null) goto L5;
        return null;
    L5:
        LayoutParams r104 = (LayoutParams) r102.getLayoutParams();
        int r105 = r104.mSpanIndex;
        int r106 = r104.mSpanSize + r105;
        if (super.onFocusSearchFailed(r210, r211, r212, r213) != null) goto L9;
        return null;
    L9:
        if (convertFocusDirectionToLayoutDirection(r211) != 1) goto L11;
        boolean r107 = true;
    L13:
        if (r107 == this.mShouldReverseLayout) goto L15;
        boolean r108 = true;
    L17:
        if (r108 == false) goto L19;
        int r109 = getChildCount() - 1;
        int r110 = -1;
        int r111 = -1;
    L21:
        if (this.mOrientation == 1) goto L23;
    L25:
        boolean r112 = false;
    L26:
        int r113 = getSpanGroupIndex(r100, r101, r109);
        int r114 = r109;
        int r115 = 0;
        int r116 = -1;
        int r117 = -1;
        int r118 = 0;
        View r119 = null;
    L27:
        if (r114 == r110) goto L85;
        int r120 = getSpanGroupIndex(r100, r101, r114);
        View r121 = getChildAt(r114);
        if (r121 == r102) goto L85;
        if (r121.hasFocusable() == false) goto L37;
        if (r120 == r113) goto L37;
        if (r103 != null) goto L85;
        View r122 = r102;
        View r214 = r119;
        int r123 = r115;
        int r215 = r110;
        int r124 = r117;
        int r125 = r118;
    L83:
        r117 = r124;
        r118 = r125;
        r115 = r123;
        r119 = r214;
    L84:
        r114 = r114 + r111;
        r100 = r212;
        r101 = r213;
        r102 = r122;
        r110 = r215;
    L37:
        LayoutParams r126 = (LayoutParams) r121.getLayoutParams();
        int r127 = r126.mSpanIndex;
        r122 = r102;
        int r128 = r126.mSpanSize + r127;
        if (r121.hasFocusable() == false) goto L43;
        if (r127 != r105) goto L43;
        if (r128 != r106) goto L43;
        return r121;
    L43:
        if (r121.hasFocusable() == false) goto L46;
        if (r103 != null) goto L46;
    L48:
        r214 = r119;
    L49:
        r123 = r115;
        r215 = r110;
        r124 = r117;
        r125 = r118;
    L50:
        boolean r129 = true;
    L78:
        if (r129 == false) goto L83;
        if (r121.hasFocusable() == false) goto L82;
        r116 = r126.mSpanIndex;
        r117 = r124;
        r118 = r125;
        r119 = r214;
        r103 = r121;
        r115 = Math.min(r128, r106) - Math.max(r127, r105);
        goto L84
    L82:
        int r130 = r126.mSpanIndex;
        r118 = Math.min(r128, r106) - Math.max(r127, r105);
        r117 = r130;
        r115 = r123;
        r119 = r121;
    L46:
        if (r121.hasFocusable() == true) goto L51;
        if (r119 == null) goto L48;
    L51:
        r214 = r119;
        int r131 = Math.min(r128, r106) - Math.max(r127, r105);
        if (r121.hasFocusable() == false) goto L61;
        if (r131 > r115) goto L49;
        if (r131 != r115) goto L75;
        if (r127 <= r116) goto L58;
        boolean r132 = true;
    L59:
        if (r112 != r132) goto L75;
    L58:
        r132 = false;
    L75:
        r123 = r115;
        r215 = r110;
    L76:
        r124 = r117;
        r125 = r118;
    L77:
        r129 = false;
        goto L78
    L61:
        if (r103 != null) goto L75;
        r123 = r115;
        r215 = r110;
        r129 = true;
        if (isViewPartiallyVisible(r121, false, true) == false) goto L76;
        r125 = r118;
        if (r131 <= r125) goto L67;
        r124 = r117;
        goto L78
    L67:
        if (r131 != r125) goto L74;
        r124 = r117;
        if (r127 > r124) goto L72;
        r129 = false;
    L72:
        if (r112 != r129) goto L77;
    L74:
        r124 = r117;
    L85:
        View r216 = r119;
        if (r103 == null) goto L89;
        return r103;
    L89:
        return r216;
    L23:
        if (isLayoutRTL() == false) goto L25;
        r112 = true;
        goto L26
    L19:
        r110 = getChildCount();
        r109 = 0;
        r111 = 1;
        goto L21
    L15:
        r108 = false;
        goto L17
    L11:
        r107 = false;
        goto L13
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler r100, RecyclerView.State r101, View r110, AccessibilityNodeInfoCompat r111) {
        ViewGroup.LayoutParams r102 = r110.getLayoutParams();
        if ((r102 instanceof LayoutParams) == true) goto L6;
        super.onInitializeAccessibilityNodeInfoForItem(r110, r111);
        return;
    L6:
        LayoutParams r103 = (LayoutParams) r102;
        int r104 = getSpanGroupIndex(r100, r101, r103.getViewLayoutPosition());
        if (this.mOrientation != 0) goto L9;
        r111.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(r103.getSpanIndex(), r103.getSpanSize(), r104, 1, false, false));
        return;
    L9:
        r111.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(r104, 1, r103.getSpanIndex(), r103.getSpanSize(), false, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView r100, int r101, int r102, int r103) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView r100, int r101, int r102, Object r103) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public GridLayoutManager(Context r100, int r101, int r102, boolean r103) {
        super(r100, r102, r103);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(r101);
    }
}
