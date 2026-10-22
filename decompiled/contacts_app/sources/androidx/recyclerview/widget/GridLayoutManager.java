package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
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
        public int getSpanSize(int r1) {
            return 1;
        }

        public DefaultSpanSizeLookup() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanIndex(int r1, int r2) {
            return r1 % r2;
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        int mSpanIndex;
        int mSpanSize;

        public LayoutParams(Context r1, AttributeSet r2) {
            super(r1, r2);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r1) {
            super(r1);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public LayoutParams(RecyclerView.LayoutParams r1) {
            super(r1);
            this.mSpanIndex = -1;
            this.mSpanSize = 0;
        }

        public int getSpanIndex() {
            return this.mSpanIndex;
        }

        public int getSpanSize() {
            return this.mSpanSize;
        }
    }

    public static abstract class SpanSizeLookup {
        private boolean mCacheSpanGroupIndices;
        private boolean mCacheSpanIndices;
        final SparseIntArray mSpanGroupIndexCache;
        final SparseIntArray mSpanIndexCache;

        public abstract int getSpanSize(int r1);

        public SpanSizeLookup() {
            this.mSpanIndexCache = new SparseIntArray();
            this.mSpanGroupIndexCache = new SparseIntArray();
            this.mCacheSpanIndices = false;
            this.mCacheSpanGroupIndices = false;
        }

        public void setSpanIndexCacheEnabled(boolean r2) {
            if (r2 == true) goto L4;
            this.mSpanGroupIndexCache.clear();
        L4:
            this.mCacheSpanIndices = r2;
        }

        public void setSpanGroupIndexCacheEnabled(boolean r2) {
            if (r2 == true) goto L4;
            this.mSpanGroupIndexCache.clear();
        L4:
            this.mCacheSpanGroupIndices = r2;
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        int getCachedSpanIndex(int r3, int r4) {
            if (this.mCacheSpanIndices == false) goto L5;
            int r0 = this.mSpanIndexCache.get(r3, -1);
            if (r0 == (-1)) goto L9;
            return r0;
        L9:
            int r5 = getSpanIndex(r3, r4);
            this.mSpanIndexCache.put(r3, r5);
            return r5;
        L5:
            return getSpanIndex(r3, r4);
        }

        int getCachedSpanGroupIndex(int r3, int r4) {
            if (this.mCacheSpanGroupIndices == false) goto L5;
            int r0 = this.mSpanGroupIndexCache.get(r3, -1);
            if (r0 == (-1)) goto L9;
            return r0;
        L9:
            int r5 = getSpanGroupIndex(r3, r4);
            this.mSpanGroupIndexCache.put(r3, r5);
            return r5;
        L5:
            return getSpanGroupIndex(r3, r4);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:17:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:17:0x0030). Please report as a decompilation issue!!! */
        public int getSpanIndex(int r6, int r7) {
            int r0 = getSpanSize(r6);
            if (r0 != r7) goto L6;
            return 0;
        L6:
            if (this.mCacheSpanIndices == false) goto L10;
            int r2 = findFirstKeyLessThan(this.mSpanIndexCache, r6);
            if (r2 < 0) goto L10;
            int r3 = this.mSpanIndexCache.get(r2) + getSpanSize(r2);
        L17:
            r2 = r2 + 1;
        L11:
            if (r2 >= r6) goto L19;
            int r4 = getSpanSize(r2);
            r3 = r3 + r4;
            if (r3 != r7) goto L15;
            r3 = 0;
            goto L17
        L15:
            if (r3 <= r7) goto L17;
            r3 = r4;
            goto L17
        L19:
            if ((r0 + r3) > r7) goto L21;
            return r3;
        L21:
            return 0;
        L10:
            r2 = 0;
            r3 = 0;
            goto L11
        }

        static int findFirstKeyLessThan(SparseIntArray r4, int r5) {
            int r0 = r4.size() - 1;
            int r1 = 0;
        L3:
            if (r1 > r0) goto L8;
            int r2 = (r1 + r0) >>> 1;
            if (r4.keyAt(r2) < r5) goto L6;
            r0 = r2 - 1;
            goto L3
        L6:
            r1 = r2 + 1;
            goto L3
        L8:
            int r3 = r1 - 1;
            if (r3 >= 0) goto L11;
            return -1;
        L11:
            if (r3 < r4.size()) goto L13;
            return -1;
        L13:
            return r4.keyAt(r3);
        }

        public int getSpanGroupIndex(int r7, int r8) {
            if (this.mCacheSpanGroupIndices == false) goto L9;
            int r0 = findFirstKeyLessThan(this.mSpanGroupIndexCache, r7);
            if (r0 == (-1)) goto L9;
            int r2 = this.mSpanGroupIndexCache.get(r0);
            int r3 = r0 + 1;
            int r4 = getCachedSpanIndex(r0, r8) + getSpanSize(r0);
            if (r4 != r8) goto L10;
            r2 = r2 + 1;
            r4 = 0;
        L10:
            int r1 = getSpanSize(r7);
        L11:
            if (r3 >= r7) goto L19;
            int r5 = getSpanSize(r3);
            r4 = r4 + r5;
            if (r4 != r8) goto L15;
            r2 = r2 + 1;
            r4 = 0;
        L17:
            r3 = r3 + 1;
            goto L11
        L15:
            if (r4 <= r8) goto L17;
            r2 = r2 + 1;
            r4 = r5;
            goto L17
        L19:
            if ((r4 + r1) > r8) goto L21;
            return r2;
        L21:
            return r2 + 1;
        L9:
            r2 = 0;
            r3 = 0;
            r4 = 0;
            goto L10
        }
    }

    public GridLayoutManager(Context r2, AttributeSet r3, int r4, int r5) {
        super(r2, r3, r4, r5);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(getProperties(r2, r3, r4, r5).spanCount);
    }

    public GridLayoutManager(Context r1, int r2) {
        super(r1);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(r2);
    }

    public GridLayoutManager(Context r1, int r2, int r3, boolean r4) {
        super(r1, r3, r4);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(r2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean r1) {
        if (r1 == true) goto L6;
        super.setStackFromEnd(false);
        return;
    L6:
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler r3, RecyclerView.State r4) {
        if (this.mOrientation != 0) goto L7;
        return this.mSpanCount;
    L7:
        if (r4.getItemCount() >= 1) goto L11;
        return 0;
    L11:
        return getSpanGroupIndex(r3, r4, r4.getItemCount() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler r3, RecyclerView.State r4) {
        if (this.mOrientation != 1) goto L7;
        return this.mSpanCount;
    L7:
        if (r4.getItemCount() >= 1) goto L11;
        return 0;
    L11:
        return getSpanGroupIndex(r3, r4, r4.getItemCount() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler r8, RecyclerView.State r9, View r10, AccessibilityNodeInfoCompat r11) {
        ViewGroup.LayoutParams r0 = r10.getLayoutParams();
        if ((r0 instanceof LayoutParams) == true) goto L6;
        super.onInitializeAccessibilityNodeInfoForItem(r10, r11);
        return;
    L6:
        LayoutParams r1 = (LayoutParams) r0;
        int r12 = getSpanGroupIndex(r8, r9, r1.getViewLayoutPosition());
        if (this.mOrientation != 0) goto L9;
        r11.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(r1.getSpanIndex(), r1.getSpanSize(), r12, 1, false, false));
        return;
    L9:
        r11.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(r12, 1, r1.getSpanIndex(), r1.getSpanSize(), false, false));
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler r2, RecyclerView.State r3) {
        if (r3.isPreLayout() == false) goto L5;
        cachePreLayoutSpanMapping();
    L5:
        super.onLayoutChildren(r2, r3);
        clearPreLayoutSpanMappingCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State r1) {
        super.onLayoutCompleted(r1);
        this.mPendingSpanCountChange = false;
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    private void cachePreLayoutSpanMapping() {
        int r0 = getChildCount();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        LayoutParams r2 = (LayoutParams) getChildAt(r1).getLayoutParams();
        int r3 = r2.getViewLayoutPosition();
        this.mPreLayoutSpanSizeCache.put(r3, r2.getSpanSize());
        this.mPreLayoutSpanIndexCache.put(r3, r2.getSpanIndex());
        r1 = r1 + 1;
        goto L3
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView r1, int r2, int r3) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView r1) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView r1, int r2, int r3) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView r1, int r2, int r3, Object r4) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView r1, int r2, int r3, int r4) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation != 0) goto L7;
        return new LayoutParams(-2, -1);
    L7:
        return new LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context r1, AttributeSet r2) {
        return new LayoutParams(r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r1);
    L7:
        return new LayoutParams(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams r1) {
        return r1 instanceof LayoutParams;
    }

    public void setSpanSizeLookup(SpanSizeLookup r1) {
        this.mSpanSizeLookup = r1;
    }

    public SpanSizeLookup getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    private void updateMeasurements() {
        if (getOrientation() != 1) goto L5;
        int r0 = getWidth() - getPaddingRight();
        int r1 = getPaddingLeft();
    L6:
        calculateItemBorders(r0 - r1);
        return;
    L5:
        r0 = getHeight() - getPaddingBottom();
        r1 = getPaddingTop();
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect r5, int r6, int r7) {
        if (this.mCachedBorders != null) goto L5;
        super.setMeasuredDimension(r5, r6, r7);
    L5:
        int r0 = getPaddingLeft() + getPaddingRight();
        int r1 = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation != 1) goto L8;
        int r8 = chooseSize(r7, r5.height() + r1, getMinimumHeight());
        int[] r9 = this.mCachedBorders;
        int r10 = chooseSize(r6, r9[r9.length - 1] + r0, getMinimumWidth());
    L9:
        setMeasuredDimension(r10, r8);
        return;
    L8:
        r10 = chooseSize(r6, r5.width() + r0, getMinimumWidth());
        int[] r11 = this.mCachedBorders;
        r8 = chooseSize(r7, r11[r11.length - 1] + r1, getMinimumHeight());
        goto L9
    }

    private void calculateItemBorders(int r3) {
        this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, r3);
    }

    static int[] calculateItemBorders(int[] r5, int r6, int r7) {
        int r0 = 1;
        if (r5 != null) goto L5;
    L8:
        r5 = new int[r6 + 1];
    L9:
        int r1 = 0;
        r5[0] = 0;
        int r2 = r7 / r6;
        int r8 = r7 % r6;
        int r3 = 0;
    L10:
        if (r0 > r6) goto L18;
        r1 = r1 + r8;
        if (r1 > 0) goto L14;
    L16:
        int r4 = r2;
    L17:
        r3 = r3 + r4;
        r5[r0] = r3;
        r0 = r0 + 1;
        goto L10
    L14:
        if ((r6 - r1) >= r8) goto L16;
        r4 = r2 + 1;
        r1 = r1 - r6;
        goto L17
    L18:
        return r5;
    L5:
        if (r5.length != (r6 + 1)) goto L8;
        if (r5[r5.length - 1] == r7) goto L9;
        goto L8
    }

    int getSpaceForSpanRange(int r3, int r4) {
        if (this.mOrientation == 1) goto L5;
    L8:
        int[] r2 = this.mCachedBorders;
        return r2[r4 + r3] - r2[r3];
    L5:
        if (isLayoutRTL() == false) goto L8;
        int[] r0 = this.mCachedBorders;
        int r5 = this.mSpanCount;
        return r0[r5 - r3] - r0[(r5 - r3) - r4];
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void onAnchorReady(RecyclerView.Recycler r2, RecyclerView.State r3, LinearLayoutManager.AnchorInfo r4, int r5) {
        super.onAnchorReady(r2, r3, r4, r5);
        updateMeasurements();
        if (r3.getItemCount() > 0) goto L5;
    L7:
        ensureViewSet();
        return;
    L5:
        if (r3.isPreLayout() == true) goto L7;
        ensureAnchorIsInCorrectSpan(r2, r3, r4, r5);
        goto L7
    }

    private void ensureViewSet() {
        View[] r0 = this.mSet;
        if (r0 != null) goto L5;
    L6:
        this.mSet = new View[this.mSpanCount];
        return;
    L5:
        if (r0.length != this.mSpanCount) goto L6;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int r1, RecyclerView.Recycler r2, RecyclerView.State r3) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(r1, r2, r3);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int r1, RecyclerView.Recycler r2, RecyclerView.State r3) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(r1, r2, r3);
    }

    private void ensureAnchorIsInCorrectSpan(RecyclerView.Recycler r5, RecyclerView.State r6, LinearLayoutManager.AnchorInfo r7, int r8) {
        if (r8 != 1) goto L5;
        boolean r9 = true;
    L6:
        int r1 = getSpanIndex(r5, r6, r7.mPosition);
        if (r9 == false) goto L12;
    L8:
        if (r1 <= 0) goto L23;
        if (r7.mPosition <= 0) goto L24;
        r7.mPosition--;
        r1 = getSpanIndex(r5, r6, r7.mPosition);
        goto L8
    L24:
        return;
    L23:
        return;
    L12:
        int r10 = r6.getItemCount() - 1;
        int r0 = r7.mPosition;
    L13:
        if (r0 >= r10) goto L17;
        int r2 = r0 + 1;
        int r3 = getSpanIndex(r5, r6, r2);
        if (r3 <= r1) goto L17;
        r0 = r2;
        r1 = r3;
    L17:
        r7.mPosition = r0;
        return;
    L5:
        r9 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    View findReferenceChild(RecyclerView.Recycler r8, RecyclerView.State r9, int r10, int r11, int r12) {
        ensureLayoutState();
        int r0 = this.mOrientationHelper.getStartAfterPadding();
        int r1 = this.mOrientationHelper.getEndAfterPadding();
        if (r11 <= r10) goto L5;
        int r2 = 1;
    L6:
        View r3 = null;
        View r4 = null;
    L7:
        if (r10 == r11) goto L27;
        View r5 = getChildAt(r10);
        int r6 = getPosition(r5);
        if (r6 < 0) goto L26;
        if (r6 >= r12) goto L26;
        if (getSpanIndex(r8, r9, r6) != 0) goto L26;
        if (((RecyclerView.LayoutParams) r5.getLayoutParams()).isItemRemoved() == false) goto L19;
        if (r4 != null) goto L26;
        r4 = r5;
        goto L26
    L19:
        if (this.mOrientationHelper.getDecoratedStart(r5) < r1) goto L21;
    L24:
        if (r3 != null) goto L26;
        r3 = r5;
        goto L26
    L21:
        if (this.mOrientationHelper.getDecoratedEnd(r5) < r0) goto L24;
        return r5;
    L26:
        r10 = r10 + r2;
        goto L7
    L27:
        if (r3 == null) goto L30;
        return r3;
    L30:
        return r4;
    L5:
        r2 = -1;
        goto L6
    }

    private int getSpanGroupIndex(RecyclerView.Recycler r1, RecyclerView.State r2, int r3) {
        if (r2.isPreLayout() == false) goto L5;
        int r4 = r1.convertPreLayoutPositionToPostLayout(r3);
        if (r4 != (-1)) goto L11;
        Log.w(TAG, "Cannot find span size for pre layout position. " + r3);
        return 0;
    L11:
        return this.mSpanSizeLookup.getCachedSpanGroupIndex(r4, this.mSpanCount);
    L5:
        return this.mSpanSizeLookup.getCachedSpanGroupIndex(r3, this.mSpanCount);
    }

    private int getSpanIndex(RecyclerView.Recycler r2, RecyclerView.State r3, int r4) {
        if (r3.isPreLayout() == false) goto L5;
        int r5 = this.mPreLayoutSpanIndexCache.get(r4, -1);
        if (r5 == (-1)) goto L9;
        return r5;
    L9:
        int r6 = r2.convertPreLayoutPositionToPostLayout(r4);
        if (r6 != (-1)) goto L14;
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + r4);
        return 0;
    L14:
        return this.mSpanSizeLookup.getCachedSpanIndex(r6, this.mSpanCount);
    L5:
        return this.mSpanSizeLookup.getCachedSpanIndex(r4, this.mSpanCount);
    }

    private int getSpanSize(RecyclerView.Recycler r2, RecyclerView.State r3, int r4) {
        if (r3.isPreLayout() == false) goto L5;
        int r5 = this.mPreLayoutSpanSizeCache.get(r4, -1);
        if (r5 == (-1)) goto L9;
        return r5;
    L9:
        int r6 = r2.convertPreLayoutPositionToPostLayout(r4);
        if (r6 != (-1)) goto L14;
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + r4);
        return 1;
    L14:
        return this.mSpanSizeLookup.getSpanSize(r6);
    L5:
        return this.mSpanSizeLookup.getSpanSize(r4);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void collectPrefetchPositionsForLayoutState(RecyclerView.State r6, LinearLayoutManager.LayoutState r7, RecyclerView.LayoutManager.LayoutPrefetchRegistry r8) {
        int r0 = this.mSpanCount;
        int r2 = 0;
    L4:
        if (r2 >= this.mSpanCount) goto L9;
        if (r7.hasMore(r6) == false) goto L13;
        if (r0 <= 0) goto L14;
        int r3 = r7.mCurrentPosition;
        r8.addPosition(r3, Math.max(0, r7.mScrollingOffset));
        r0 = r0 - this.mSpanSizeLookup.getSpanSize(r3);
        r7.mCurrentPosition += r7.mItemDirection;
        r2 = r2 + 1;
        goto L4
    L14:
        return;
    L13:
        return;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void layoutChunk(RecyclerView.Recycler r18, RecyclerView.State r19, LinearLayoutManager.LayoutState r20, LinearLayoutManager.LayoutChunkResult r21) {
        int r3 = this.mOrientationHelper.getModeInOther();
        if (r3 == 1073741824) goto L5;
        boolean r9 = true;
    L7:
        if (getChildCount() <= 0) goto L9;
        int r10 = this.mCachedBorders[this.mSpanCount];
    L10:
        if (r9 == false) goto L13;
        updateMeasurements();
    L13:
        if (r20.mItemDirection != 1) goto L15;
        boolean r11 = true;
    L16:
        int r12 = this.mSpanCount;
        if (r11 == true) goto L19;
        r12 = getSpanIndex(r18, r19, r20.mCurrentPosition) + getSpanSize(r18, r19, r20.mCurrentPosition);
    L19:
        int r13 = 0;
    L21:
        if (r13 >= this.mSpanCount) goto L36;
        if (r20.hasMore(r19) == false) goto L36;
        if (r12 <= 0) goto L36;
        int r14 = r20.mCurrentPosition;
        int r15 = getSpanSize(r18, r19, r14);
        if (r15 > this.mSpanCount) goto L35;
        r12 = r12 - r15;
        if (r12 < 0) goto L36;
        View r5 = r20.next(r18);
        if (r5 == null) goto L36;
        this.mSet[r13] = r5;
        r13 = r13 + 1;
        goto L21
    L35:
        throw new IllegalArgumentException("Item at position " + r14 + " requires " + r15 + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
    L36:
        if (r13 != 0) goto L39;
        r21.mFinished = true;
        return;
    L39:
        assignSpans(r18, r19, r13, r11);
        float r0 = 0.0f;
        int r1 = 0;
        int r6 = 0;
    L40:
        if (r1 >= r13) goto L56;
        View r16 = this.mSet[r1];
        if (r20.mScrapList != null) goto L46;
        if (r11 == false) goto L45;
        addView(r16);
    L49:
        calculateItemDecorationsForChild(r16, this.mDecorInsets);
        measureChild(r16, r3, false);
        int r17 = this.mOrientationHelper.getDecoratedMeasurement(r16);
        if (r17 <= r6) goto L52;
        r6 = r17;
    L52:
        float r110 = (this.mOrientationHelper.getDecoratedMeasurementInOther(r16) * 1.0f) / ((LayoutParams) r16.getLayoutParams()).mSpanSize;
        if (r110 <= r0) goto L55;
        r0 = r110;
    L55:
        r1 = r1 + 1;
        goto L40
    L45:
        addView(r16, 0);
        goto L49
    L46:
        if (r11 == false) goto L48;
        addDisappearingView(r16);
        goto L49
    L48:
        addDisappearingView(r16, 0);
        goto L49
    L56:
        if (r9 == false) goto L63;
        guessMeasurement(r0, r10);
        int r2 = 0;
        r6 = 0;
    L58:
        if (r2 >= r13) goto L63;
        View r4 = this.mSet[r2];
        measureChild(r4, 1073741824, true);
        int r7 = this.mOrientationHelper.getDecoratedMeasurement(r4);
        if (r7 <= r6) goto L62;
        r6 = r7;
    L62:
        r2 = r2 + 1;
    L63:
        int r8 = 0;
    L64:
        if (r8 >= r13) goto L74;
        View r22 = this.mSet[r8];
        if (this.mOrientationHelper.getDecoratedMeasurement(r22) == r6) goto L73;
        LayoutParams r23 = (LayoutParams) r22.getLayoutParams();
        Rect r24 = r23.mDecorInsets;
        int r111 = ((r24.top + r24.bottom) + r23.topMargin) + r23.bottomMargin;
        int r112 = ((r24.left + r24.right) + r23.leftMargin) + r23.rightMargin;
        int r25 = getSpaceForSpanRange(r23.mSpanIndex, r23.mSpanSize);
        if (this.mOrientation != 1) goto L70;
        int r26 = getChildMeasureSpec(r25, 1073741824, r112, r23.width, false);
        int r27 = View.MeasureSpec.makeMeasureSpec(r6 - r111, 1073741824);
    L71:
        measureChildWithDecorationsAndMargin(r22, r26, r27, true);
        goto L73
    L70:
        int r113 = View.MeasureSpec.makeMeasureSpec(r6 - r112, 1073741824);
        r27 = getChildMeasureSpec(r25, 1073741824, r111, r23.height, false);
        r26 = r113;
    L73:
        r8 = r8 + 1;
        goto L64
    L74:
        r21.mConsumed = r6;
        if (this.mOrientation != 1) goto L82;
        if (r20.mLayoutDirection != (-1)) goto L79;
        int r28 = r20.mOffset;
        int r29 = r28 - r6;
    L80:
        int r30 = r29;
        int r31 = 0;
        int r32 = 0;
    L86:
        int r33 = 0;
    L87:
        if (r33 >= r13) goto L102;
        View r114 = this.mSet[r33];
        LayoutParams r115 = (LayoutParams) r114.getLayoutParams();
        if (this.mOrientation == 1) goto L91;
        int r34 = getPaddingTop() + this.mCachedBorders[r115.mSpanIndex];
        int r116 = r34;
        int r117 = r31;
        int r118 = this.mOrientationHelper.getDecoratedMeasurementInOther(r114) + r34;
    L95:
        int r119 = r32;
    L96:
        layoutDecoratedWithMargins(r114, r119, r116, r117, r118);
        if (r115.isItemRemoved() == false) goto L99;
    L100:
        r21.mIgnoreConsumed = true;
    L101:
        r21.mFocusable |= r114.hasFocusable();
        r33 = r33 + 1;
        r28 = r118;
        r31 = r117;
        r30 = r116;
        r32 = r119;
        goto L87
    L99:
        if (r115.isItemChanged() == false) goto L101;
    L91:
        if (isLayoutRTL() == false) goto L93;
        int r35 = getPaddingLeft() + this.mCachedBorders[this.mSpanCount - r115.mSpanIndex];
        r32 = r35 - this.mOrientationHelper.getDecoratedMeasurementInOther(r114);
        r118 = r28;
        r117 = r35;
        r116 = r30;
        goto L95
    L93:
        int r36 = getPaddingLeft() + this.mCachedBorders[r115.mSpanIndex];
        r118 = r28;
        r119 = r36;
        r116 = r30;
        r117 = this.mOrientationHelper.getDecoratedMeasurementInOther(r114) + r36;
        goto L96
    L102:
        Arrays.fill(this.mSet, null);
        return;
    L79:
        r29 = r20.mOffset;
        r28 = r29 + r6;
        goto L80
    L82:
        if (r20.mLayoutDirection != (-1)) goto L84;
        int r37 = r20.mOffset;
        int r38 = r37 - r6;
    L85:
        r32 = r38;
        r30 = 0;
        r31 = r37;
        r28 = 0;
        goto L86
    L84:
        r38 = r20.mOffset;
        r37 = r38 + r6;
        goto L85
    L15:
        r11 = false;
        goto L16
    L9:
        r10 = 0;
        goto L10
    L5:
        r9 = false;
        goto L7
    }

    private void measureChild(View r9, int r10, boolean r11) {
        LayoutParams r0 = (LayoutParams) r9.getLayoutParams();
        Rect r1 = r0.mDecorInsets;
        int r2 = ((r1.top + r1.bottom) + r0.topMargin) + r0.bottomMargin;
        int r3 = ((r1.left + r1.right) + r0.leftMargin) + r0.rightMargin;
        int r4 = getSpaceForSpanRange(r0.mSpanIndex, r0.mSpanSize);
        if (this.mOrientation != 1) goto L5;
        int r12 = getChildMeasureSpec(r4, r10, r3, r0.width, false);
        int r5 = getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getHeightMode(), r2, r0.height, true);
    L6:
        measureChildWithDecorationsAndMargin(r9, r12, r5, r11);
        return;
    L5:
        int r13 = getChildMeasureSpec(r4, r10, r2, r0.height, false);
        int r6 = getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getWidthMode(), r3, r0.width, true);
        r5 = r13;
        r12 = r6;
        goto L6
    }

    private void guessMeasurement(float r2, int r3) {
        calculateItemBorders(Math.max(Math.round(r2 * this.mSpanCount), r3));
    }

    private void measureChildWithDecorationsAndMargin(View r2, int r3, int r4, boolean r5) {
        RecyclerView.LayoutParams r0 = (RecyclerView.LayoutParams) r2.getLayoutParams();
        if (r5 == false) goto L5;
        boolean r1 = shouldReMeasureChild(r2, r3, r4, r0);
    L6:
        if (r1 == false) goto L9;
        r2.measure(r3, r4);
        return;
    L9:
        return;
    L5:
        r1 = shouldMeasureChild(r2, r3, r4, r0);
        goto L6
    }

    private void assignSpans(RecyclerView.Recycler r5, RecyclerView.State r6, int r7, boolean r8) {
        int r0 = 0;
        if (r8 == false) goto L5;
        int r1 = 1;
        int r9 = r7;
        int r10 = 0;
    L6:
        if (r10 == r9) goto L8;
        View r2 = this.mSet[r10];
        LayoutParams r3 = (LayoutParams) r2.getLayoutParams();
        r3.mSpanSize = getSpanSize(r5, r6, getPosition(r2));
        r3.mSpanIndex = r0;
        r0 = r0 + r3.mSpanSize;
        r10 = r10 + r1;
        goto L6
    L8:
        return;
    L5:
        r10 = r7 - 1;
        r9 = -1;
        r1 = -1;
        goto L6
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public void setSpanCount(int r3) {
        if (r3 != this.mSpanCount) goto L5;
        return;
    L5:
        this.mPendingSpanCountChange = true;
        if (r3 < 1) goto L10;
        this.mSpanCount = r3;
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        requestLayout();
        return;
    L10:
        throw new IllegalArgumentException("Span count should be at least 1. Provided " + r3);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View r23, int r24, RecyclerView.Recycler r25, RecyclerView.State r26) {
        RecyclerView.Recycler r1 = r25;
        RecyclerView.State r2 = r26;
        View r3 = findContainingItemView(r23);
        View r4 = null;
        if (r3 != null) goto L5;
        return null;
    L5:
        LayoutParams r5 = (LayoutParams) r3.getLayoutParams();
        int r6 = r5.mSpanIndex;
        int r7 = r5.mSpanIndex + r5.mSpanSize;
        if (super.onFocusSearchFailed(r23, r24, r25, r26) != null) goto L9;
        return null;
    L9:
        if (convertFocusDirectionToLayoutDirection(r24) != 1) goto L11;
        boolean r8 = true;
    L13:
        if (r8 == this.mShouldReverseLayout) goto L15;
        boolean r9 = true;
    L17:
        if (r9 == false) goto L19;
        int r10 = getChildCount() - 1;
        int r11 = -1;
        int r12 = -1;
    L21:
        if (this.mOrientation == 1) goto L23;
    L25:
        boolean r13 = false;
    L26:
        int r14 = getSpanGroupIndex(r1, r2, r10);
        int r15 = -1;
        int r16 = -1;
        int r17 = 0;
        int r18 = 0;
        int r19 = r10;
        View r20 = null;
    L27:
        if (r19 == r11) goto L84;
        int r21 = getSpanGroupIndex(r1, r2, r19);
        View r22 = getChildAt(r19);
        if (r22 == r3) goto L84;
        if (r22.hasFocusable() == false) goto L37;
        if (r21 == r14) goto L37;
        if (r4 != null) goto L84;
        View r110 = r3;
        View r27 = r20;
        int r28 = r17;
        int r111 = r11;
        int r112 = r16;
        int r29 = r18;
    L82:
        r17 = r28;
        r18 = r29;
        r16 = r112;
        r20 = r27;
    L83:
        r19 = r19 + r12;
        r1 = r25;
        r2 = r26;
        r3 = r110;
        r11 = r111;
    L37:
        LayoutParams r30 = (LayoutParams) r22.getLayoutParams();
        int r31 = r30.mSpanIndex;
        r110 = r3;
        r111 = r11;
        int r32 = r30.mSpanIndex + r30.mSpanSize;
        if (r22.hasFocusable() == false) goto L43;
        if (r31 != r6) goto L43;
        if (r32 != r7) goto L43;
        return r22;
    L43:
        if (r22.hasFocusable() == false) goto L46;
        if (r4 != null) goto L46;
    L48:
        r27 = r20;
        r28 = r17;
        r112 = r16;
        r29 = r18;
    L49:
        boolean r33 = true;
    L77:
        if (r33 == false) goto L82;
        if (r22.hasFocusable() == false) goto L81;
        int r34 = r30.mSpanIndex;
        r17 = Math.min(r32, r7) - Math.max(r31, r6);
        r15 = r34;
        r18 = r29;
        r16 = r112;
        r20 = r27;
        r4 = r22;
        goto L83
    L81:
        int r35 = r30.mSpanIndex;
        r18 = Math.min(r32, r7) - Math.max(r31, r6);
        r17 = r28;
        r16 = r35;
        r20 = r22;
    L46:
        if (r22.hasFocusable() == true) goto L50;
        if (r20 == null) goto L48;
    L50:
        int r113 = Math.min(r32, r7) - Math.max(r31, r6);
        if (r22.hasFocusable() == false) goto L60;
        if (r113 > r17) goto L48;
        if (r113 != r17) goto L74;
        if (r31 <= r15) goto L57;
        boolean r114 = true;
    L58:
        if (r13 != r114) goto L74;
    L57:
        r114 = false;
    L74:
        r27 = r20;
        r28 = r17;
    L75:
        r112 = r16;
        r29 = r18;
    L76:
        r33 = false;
        goto L77
    L60:
        if (r4 != null) goto L74;
        r27 = r20;
        r28 = r17;
        r33 = true;
        if (isViewPartiallyVisible(r22, false, true) == false) goto L75;
        r29 = r18;
        if (r113 <= r29) goto L66;
        r112 = r16;
        goto L77
    L66:
        if (r113 != r29) goto L73;
        r112 = r16;
        if (r31 > r112) goto L71;
        r33 = false;
    L71:
        if (r13 != r33) goto L76;
    L73:
        r112 = r16;
    L84:
        View r210 = r20;
        if (r4 == null) goto L88;
        return r4;
    L88:
        return r210;
    L23:
        if (isLayoutRTL() == false) goto L25;
        r13 = true;
        goto L26
    L19:
        r11 = getChildCount();
        r12 = 1;
        r10 = 0;
        goto L21
    L15:
        r9 = false;
        goto L17
    L11:
        r8 = false;
        goto L13
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

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State r2) {
        if (this.mUsingSpansToEstimateScrollBarDimensions == false) goto L7;
        return computeScrollRangeWithSpanInfo(r2);
    L7:
        return super.computeHorizontalScrollRange(r2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State r2) {
        if (this.mUsingSpansToEstimateScrollBarDimensions == false) goto L7;
        return computeScrollRangeWithSpanInfo(r2);
    L7:
        return super.computeVerticalScrollRange(r2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State r2) {
        if (this.mUsingSpansToEstimateScrollBarDimensions == false) goto L7;
        return computeScrollOffsetWithSpanInfo(r2);
    L7:
        return super.computeHorizontalScrollOffset(r2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State r2) {
        if (this.mUsingSpansToEstimateScrollBarDimensions == false) goto L7;
        return computeScrollOffsetWithSpanInfo(r2);
    L7:
        return super.computeVerticalScrollOffset(r2);
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean r1) {
        this.mUsingSpansToEstimateScrollBarDimensions = r1;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.mUsingSpansToEstimateScrollBarDimensions;
    }

    private int computeScrollRangeWithSpanInfo(RecyclerView.State r7) {
        if (getChildCount() != 0) goto L5;
    L17:
        return 0;
    L5:
        if (r7.getItemCount() == 0) goto L17;
        ensureLayoutState();
        View r0 = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
        View r3 = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
        if (r0 == null) goto L17;
        if (r3 == null) goto L17;
        if (isSmoothScrollbarEnabled() == false) goto L14;
        int r1 = this.mOrientationHelper.getDecoratedEnd(r3) - this.mOrientationHelper.getDecoratedStart(r0);
        int r2 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r0), this.mSpanCount);
        int r4 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r3), this.mSpanCount);
        return (int) ((r1 / ((r4 - r2) + 1)) * (this.mSpanSizeLookup.getCachedSpanGroupIndex(r7.getItemCount() - 1, this.mSpanCount) + 1));
    L14:
        return this.mSpanSizeLookup.getCachedSpanGroupIndex(r7.getItemCount() - 1, this.mSpanCount) + 1;
    }

    private int computeScrollOffsetWithSpanInfo(RecyclerView.State r10) {
        if (getChildCount() != 0) goto L5;
    L19:
        return 0;
    L5:
        if (r10.getItemCount() == 0) goto L19;
        ensureLayoutState();
        boolean r0 = isSmoothScrollbarEnabled();
        View r2 = findFirstVisibleChildClosestToStart(!r0, true);
        View r4 = findFirstVisibleChildClosestToEnd(!r0, true);
        if (r2 == null) goto L19;
        if (r4 == null) goto L19;
        int r5 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r2), this.mSpanCount);
        int r6 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r4), this.mSpanCount);
        int r7 = Math.min(r5, r6);
        int r8 = Math.max(r5, r6);
        int r11 = this.mSpanSizeLookup.getCachedSpanGroupIndex(r10.getItemCount() - 1, this.mSpanCount) + 1;
        if (this.mShouldReverseLayout == false) goto L14;
        int r12 = Math.max(0, (r11 - r8) - 1);
    L15:
        if (r0 == true) goto L18;
        return r12;
    L18:
        return Math.round((r12 * (Math.abs(this.mOrientationHelper.getDecoratedEnd(r4) - this.mOrientationHelper.getDecoratedStart(r2)) / ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r4), this.mSpanCount) - this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(r2), this.mSpanCount)) + 1))) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(r2)));
    L14:
        r12 = Math.max(0, r7);
        goto L15
    }
}
