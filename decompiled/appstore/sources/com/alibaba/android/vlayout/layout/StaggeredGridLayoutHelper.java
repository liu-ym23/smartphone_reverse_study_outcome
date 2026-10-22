package com.alibaba.android.vlayout.layout;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.LayoutManagerHelper;
import com.alibaba.android.vlayout.OrientationHelperEx;
import com.alibaba.android.vlayout.Range;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutHelper extends BaseLayoutHelper {
    static final int INVALID_LINE = Integer.MIN_VALUE;
    private static final int INVALID_SPAN_ID = Integer.MIN_VALUE;
    private static final String LOOKUP_BUNDLE_KEY = "StaggeredGridLayoutHelper_LazySpanLookup";
    private static final String TAG = "Staggered";
    private int anchorPosition;
    private final Runnable checkForGapsRunnable;
    private int mColLength;
    private int mEachGap;
    private int mHGap;
    private int mLastGap;
    private WeakReference<VirtualLayoutManager> mLayoutManager;
    private boolean mLayoutWithAnchor;
    private LazySpanLookup mLazySpanLookup;
    private int mNumLanes;
    private BitSet mRemainingSpans;
    private Span[] mSpans;
    private int mVGap;
    private List<View> prelayoutViewList;

    public static class LazySpanLookup {
        private static final int MIN_SIZE = 10;
        int[] mData;

        public LazySpanLookup() {
        }

        public void clear() {
            int[] r10 = this.mData;
            if (r10 == null) goto L6;
            Arrays.fill(r10, Integer.MIN_VALUE);
            return;
        }

        public void ensureSize(int r10) {
            int[] r11 = this.mData;
            if (r11 != null) goto L6;
            int[] r12 = new int[Math.max(r10, 10) + 1];
            this.mData = r12;
            Arrays.fill(r12, Integer.MIN_VALUE);
            return;
        L6:
            if (r10 < r11.length) goto L10;
            int[] r13 = new int[sizeForPosition(r10)];
            this.mData = r13;
            System.arraycopy(r11, 0, r13, 0, r11.length);
            int[] r14 = this.mData;
            Arrays.fill(r14, r11.length, r14.length, Integer.MIN_VALUE);
            return;
        }

        public int getSpan(int r10) {
            int[] r11 = this.mData;
            if (r11 != null) goto L5;
            return Integer.MIN_VALUE;
        L5:
            if (r10 < r11.length) goto L8;
            return Integer.MIN_VALUE;
        L8:
            return r11[r10];
        }

        public int invalidateAfter(int r10) {
            int[] r11 = this.mData;
            if (r11 != null) goto L6;
            return -1;
        L6:
            if (r10 < r11.length) goto L8;
            return -1;
        L8:
            Arrays.fill(r11, r10, r11.length, Integer.MIN_VALUE);
            return this.mData.length;
        }

        public void offsetForAddition(int r10, int r11) {
            int[] r12 = this.mData;
            if (r12 != null) goto L5;
            return;
        L5:
            if (r10 >= r12.length) goto L10;
            int r13 = r10 + r11;
            ensureSize(r13);
            int[] r14 = this.mData;
            System.arraycopy(r14, r10, r14, r13, (r14.length - r10) - r11);
            Arrays.fill(this.mData, r10, r13, Integer.MIN_VALUE);
            return;
        }

        public void offsetForRemoval(int r10, int r11) {
            int[] r12 = this.mData;
            if (r12 != null) goto L5;
            return;
        L5:
            if (r10 >= r12.length) goto L10;
            int r13 = r10 + r11;
            ensureSize(r13);
            int[] r14 = this.mData;
            System.arraycopy(r14, r13, r14, r10, (r14.length - r10) - r11);
            int[] r15 = this.mData;
            Arrays.fill(r15, r15.length - r11, r15.length, Integer.MIN_VALUE);
            return;
        }

        public void setSpan(int r10, Span r11) {
            ensureSize(r10);
            this.mData[r10] = r11.mIndex;
        }

        public int sizeForPosition(int r10) {
            int r11 = this.mData.length;
        L3:
            if (r11 > r10) goto L5;
            r11 = r11 * 2;
            goto L3
        L5:
            return r11;
        }
    }

    public static class Span {
        static final int INVALID_OFFSET = Integer.MIN_VALUE;
        int mCachedEnd;
        int mCachedStart;
        int mDeletedSize;
        final int mIndex;
        int mLastEdgeEnd;
        int mLastEdgeStart;
        private ArrayList<View> mViews;

        public /* synthetic */ Span(int r10, AnonymousClass1 r11) {
            this(r10);
        }

        public static /* synthetic */ ArrayList access$200(Span r10) {
            return r10.mViews;
        }

        public void appendToSpan(View r10, OrientationHelperEx r11) {
            RecyclerView.LayoutParams r12 = getLayoutParams(r10);
            this.mViews.add(r10);
            this.mCachedEnd = Integer.MIN_VALUE;
            if (this.mViews.size() != 1) goto L6;
            this.mCachedStart = Integer.MIN_VALUE;
        L6:
            if (r12.isItemRemoved() == false) goto L8;
        L9:
            this.mDeletedSize += r11.getDecoratedMeasurement(r10);
            return;
        L8:
            if (r12.isItemChanged() == true) goto L9;
        }

        public void cacheReferenceLineAndClear(boolean r10, int r11, OrientationHelperEx r12) {
            if (r10 == false) goto L4;
            int r13 = getEndLine(r12);
        L5:
            clear();
            if (r13 != Integer.MIN_VALUE) goto L8;
            return;
        L8:
            if (r10 == true) goto L10;
        L11:
            if (r10 == true) goto L13;
            r12.getStartAfterPadding();
        L13:
            if (r11 == Integer.MIN_VALUE) goto L15;
            r13 = r13 + r11;
        L15:
            this.mCachedEnd = r13;
            this.mCachedStart = r13;
            this.mLastEdgeEnd = Integer.MIN_VALUE;
            this.mLastEdgeStart = Integer.MIN_VALUE;
            return;
        L10:
            if (r13 < r12.getEndAfterPadding()) goto L13;
        L4:
            r13 = getStartLine(r12);
            goto L5
        }

        public void calculateCachedEnd(OrientationHelperEx r10) {
            if (this.mViews.size() != 0) goto L5;
            this.mCachedEnd = Integer.MIN_VALUE;
            return;
        L5:
            ArrayList<View> r11 = this.mViews;
            this.mCachedEnd = r10.getDecoratedEnd(r11.get(r11.size() - 1));
        }

        public void calculateCachedStart(@NonNull OrientationHelperEx r10) {
            if (this.mViews.size() != 0) goto L5;
            this.mCachedStart = Integer.MIN_VALUE;
            return;
        L5:
            this.mCachedStart = r10.getDecoratedStart(this.mViews.get(0));
        }

        public void clear() {
            this.mViews.clear();
            invalidateCache();
            this.mDeletedSize = 0;
        }

        public boolean findEnd(View r10) {
            int r11 = this.mViews.size();
            if (r11 > 0) goto L5;
            return false;
        L5:
            if (this.mViews.get(r11 - 1) == r10) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean findStart(View r10) {
            if (this.mViews.size() > 0) goto L5;
            return false;
        L5:
            if (this.mViews.get(0) != r10) goto L9;
            return true;
        L9:
            return false;
        }

        public int getDeletedSize() {
            return this.mDeletedSize;
        }

        public int getEndLine(OrientationHelperEx r10) {
            return getEndLine(Integer.MIN_VALUE, r10);
        }

        public RecyclerView.LayoutParams getLayoutParams(View r10) {
            return (RecyclerView.LayoutParams) r10.getLayoutParams();
        }

        public int getNormalizedOffset(int r10, int r11, int r12, OrientationHelperEx r13) {
            if (this.mViews.size() != 0) goto L5;
            return 0;
        L5:
            if (r10 >= 0) goto L13;
            int r14 = getEndLine(0, r13) - r12;
            if (r14 > 0) goto L10;
            return 0;
        L10:
            if ((-r10) > r14) goto L12;
            return r10;
        L12:
            return -r14;
        L13:
            int r15 = r11 - getStartLine(0, r13);
            if (r15 > 0) goto L16;
            return 0;
        L16:
            if (r15 < r10) goto L18;
            return r10;
        L18:
            return r15;
        }

        public int getStartLine(OrientationHelperEx r10) {
            return getStartLine(Integer.MIN_VALUE, r10);
        }

        public void invalidateCache() {
            this.mCachedStart = Integer.MIN_VALUE;
            this.mCachedEnd = Integer.MIN_VALUE;
            this.mLastEdgeEnd = Integer.MIN_VALUE;
            this.mLastEdgeStart = Integer.MIN_VALUE;
        }

        public boolean isEmpty(int r10, int r11, OrientationHelperEx r12) {
            int r13 = this.mViews.size();
            int r14 = 0;
        L3:
            if (r14 >= r13) goto L10;
            View r15 = this.mViews.get(r14);
            if (r12.getDecoratedStart(r15) >= r11) goto L9;
            if (r12.getDecoratedEnd(r15) <= r10) goto L9;
            return false;
        L9:
            r14 = r14 + 1;
            goto L3
        L10:
            return true;
        }

        public void onOffset(int r10) {
            int r11 = this.mLastEdgeStart;
            if (r11 == Integer.MIN_VALUE) goto L5;
            this.mLastEdgeStart = r11 + r10;
        L5:
            int r12 = this.mCachedStart;
            if (r12 == Integer.MIN_VALUE) goto L8;
            this.mCachedStart = r12 + r10;
        L8:
            int r13 = this.mLastEdgeEnd;
            if (r13 == Integer.MIN_VALUE) goto L11;
            this.mLastEdgeEnd = r13 + r10;
        L11:
            int r14 = this.mCachedEnd;
            if (r14 == Integer.MIN_VALUE) goto L15;
            this.mCachedEnd = r14 + r10;
            return;
        }

        public void popEnd(OrientationHelperEx r10) {
            int r11 = this.mViews.size();
            View r12 = this.mViews.remove(r11 - 1);
            RecyclerView.LayoutParams r13 = getLayoutParams(r12);
            if (r13.isItemRemoved() == false) goto L5;
        L6:
            this.mDeletedSize -= r10.getDecoratedMeasurement(r12);
        L8:
            if (r11 != 1) goto L10;
            this.mCachedStart = Integer.MIN_VALUE;
        L10:
            this.mCachedEnd = Integer.MIN_VALUE;
            return;
        L5:
            if (r13.isItemChanged() == false) goto L8;
            goto L6
        }

        public void popStart(OrientationHelperEx r10) {
            View r11 = this.mViews.remove(0);
            RecyclerView.LayoutParams r12 = getLayoutParams(r11);
            if (this.mViews.size() != 0) goto L6;
            this.mCachedEnd = Integer.MIN_VALUE;
        L6:
            if (r12.isItemRemoved() == false) goto L8;
        L9:
            this.mDeletedSize -= r10.getDecoratedMeasurement(r11);
        L10:
            this.mCachedStart = Integer.MIN_VALUE;
            return;
        L8:
            if (r12.isItemChanged() == false) goto L10;
            goto L9
        }

        public void prependToSpan(View r10, OrientationHelperEx r11) {
            RecyclerView.LayoutParams r12 = getLayoutParams(r10);
            this.mViews.add(0, r10);
            this.mCachedStart = Integer.MIN_VALUE;
            if (this.mViews.size() != 1) goto L6;
            this.mCachedEnd = Integer.MIN_VALUE;
        L6:
            if (r12.isItemRemoved() == false) goto L8;
        L9:
            this.mDeletedSize += r11.getDecoratedMeasurement(r10);
            return;
        L8:
            if (r12.isItemChanged() == true) goto L9;
        }

        public void setLine(int r10) {
            this.mCachedStart = r10;
            this.mCachedEnd = r10;
            this.mLastEdgeEnd = Integer.MIN_VALUE;
            this.mLastEdgeStart = Integer.MIN_VALUE;
        }

        private Span(int r10) {
            this.mViews = new ArrayList();
            this.mCachedStart = Integer.MIN_VALUE;
            this.mCachedEnd = Integer.MIN_VALUE;
            this.mDeletedSize = 0;
            this.mLastEdgeStart = Integer.MIN_VALUE;
            this.mLastEdgeEnd = Integer.MIN_VALUE;
            this.mIndex = r10;
        }

        public int getEndLine(int r10, OrientationHelperEx r11) {
            int r12 = this.mCachedEnd;
            if (r12 == Integer.MIN_VALUE) goto L5;
            return r12;
        L5:
            if (r10 != Integer.MIN_VALUE) goto L7;
        L12:
            calculateCachedEnd(r11);
            return this.mCachedEnd;
        L7:
            if (this.mViews.size() != 0) goto L12;
            int r13 = this.mLastEdgeStart;
            if (r13 == Integer.MIN_VALUE) goto L11;
            return r13;
        L11:
            return r10;
        }

        public int getStartLine(int r10, OrientationHelperEx r11) {
            int r12 = this.mCachedStart;
            if (r12 == Integer.MIN_VALUE) goto L5;
            return r12;
        L5:
            if (r10 != Integer.MIN_VALUE) goto L7;
        L12:
            calculateCachedStart(r11);
            return this.mCachedStart;
        L7:
            if (this.mViews.size() != 0) goto L12;
            int r13 = this.mLastEdgeEnd;
            if (r13 == Integer.MIN_VALUE) goto L11;
            return r13;
        L11:
            return r10;
        }
    }

    public StaggeredGridLayoutHelper() {
        this(1, 0);
    }

    public static /* synthetic */ void access$000(StaggeredGridLayoutHelper r10) {
        r10.checkForGaps();
    }

    private void checkForGaps() {
        WeakReference<VirtualLayoutManager> r10 = this.mLayoutManager;
        if (r10 != null) goto L5;
        return;
    L5:
        VirtualLayoutManager r11 = r10.get();
        if (r11 != null) goto L8;
        return;
    L8:
        if (r11.getChildCount() == 0) goto L65;
        Range<Integer> r12 = getRange();
        if (r11.getReverseLayout() == false) goto L13;
        r11.findLastVisibleItemPosition();
        r11.findFirstVisibleItemPosition();
        int r13 = ((Integer) r12.getUpper()).intValue() - 1;
    L14:
        OrientationHelperEx r14 = r11.getMainOrientationHelper();
        int r15 = r11.getChildCount();
        int r16 = 0;
        if (r11.getReverseLayout() == false) goto L27;
        int r17 = r15 - 1;
        int r18 = r17;
    L17:
        if (r18 < 0) goto L48;
        View r19 = r11.getChildAt(r18);
        int r20 = r11.getPosition(r19);
        if (r20 == r13) goto L20;
        r18 = r18 - 1;
        goto L17
    L20:
        if (r18 != r17) goto L22;
        int r21 = r14.getDecoratedEnd(r19);
    L49:
        if (r20 != Integer.MIN_VALUE) goto L52;
        return;
    L52:
        if (hasGapsToFix(r11, r20, r21) == null) goto L64;
        Span[] r110 = this.mSpans;
        int r22 = r110.length;
    L54:
        if (r16 >= r22) goto L56;
        r110[r16].setLine(r21);
        r16 = r16 + 1;
        goto L54
    L56:
        r11.requestSimpleAnimationsInNextLayout();
        r11.requestLayout();
        return;
    L64:
        return;
    L22:
        View r23 = r11.getChildAt(r18 + 1);
        if (r11.getPosition(r23) != (r20 - 1)) goto L25;
        r21 = (r14.getDecoratedStart(r23) - r11.obtainExtraMargin(r23, false)) + r11.obtainExtraMargin(r19, true);
        goto L49
    L25:
        r21 = r14.getDecoratedEnd(r19);
    L48:
        r21 = Integer.MIN_VALUE;
        r20 = Integer.MIN_VALUE;
        goto L49
    L27:
        int r24 = 0;
    L28:
        if (r24 >= r15) goto L48;
        View r25 = r11.getChildAt(r24);
        r20 = r11.getPosition(r25);
        if (r20 == r13) goto L31;
        r24 = r24 + 1;
        goto L28
    L31:
        if (r24 != 0) goto L33;
        r21 = r14.getDecoratedStart(r25);
        goto L49
    L33:
        View r26 = r11.getChildAt(r24 - 1);
        int r27 = (r14.getDecoratedEnd(r26) + r11.obtainExtraMargin(r26, true, false)) - r11.obtainExtraMargin(r25, false, false);
        if (r27 != r14.getDecoratedStart(r25)) goto L36;
        r21 = r27;
        r20 = Integer.MIN_VALUE;
        goto L49
    L36:
        int r28 = r11.getPosition(r26);
        int r29 = r13 - 1;
        if (r28 == r29) goto L46;
        LayoutHelper r30 = r11.findLayoutHelperByPosition(r29);
        if (r30 != null) goto L41;
    L45:
        r21 = r27;
        goto L49
    L41:
        if ((r30 instanceof StickyLayoutHelper) == false) goto L45;
        if (r30.getFixedView() == null) goto L45;
        r27 = r27 + r30.getFixedView().getMeasuredHeight();
        goto L45
    L46:
        r11.findLayoutHelperByPosition(r28).getRange();
        goto L45
    L13:
        r11.findFirstVisibleItemPosition();
        r11.findLastCompletelyVisibleItemPosition();
        r13 = ((Integer) r12.getLower()).intValue();
        goto L14
    }

    private boolean checkSpanForGap(Span r10, VirtualLayoutManager r11, int r12) {
        OrientationHelperEx r13 = r11.getMainOrientationHelper();
        if (r11.getReverseLayout() == false) goto L8;
        if (r10.getEndLine(r13) >= r12) goto L10;
        return true;
    L10:
        return false;
    L8:
        if (r10.getStartLine(r13) <= r12) goto L12;
        return true;
    L12:
        return false;
    }

    private void ensureLanes() {
        Span[] r10 = this.mSpans;
        if (r10 != null) goto L5;
    L8:
        this.mRemainingSpans = new BitSet(this.mNumLanes);
        this.mSpans = new Span[this.mNumLanes];
        int r11 = 0;
    L10:
        if (r11 >= this.mNumLanes) goto L14;
        this.mSpans[r11] = new Span(r11, null);
        r11 = r11 + 1;
        goto L10
    L14:
        return;
    L5:
        if (r10.length != this.mNumLanes) goto L8;
        if (this.mRemainingSpans == null) goto L8;
    }

    private Span findSpan(int r10, View r11, boolean r12) {
        int r13 = this.mLazySpanLookup.getSpan(r10);
        if (r13 < 0) goto L15;
        Span[] r14 = this.mSpans;
        if (r13 >= r14.length) goto L15;
        Span r15 = r14[r13];
        if (r12 == true) goto L9;
    L11:
        if (r12 == true) goto L15;
        if (r15.findEnd(r11) == false) goto L15;
        return r15;
    L9:
        if (r15.findStart(r11) == false) goto L11;
        return r15;
    L15:
        int r16 = 0;
    L16:
        Span[] r17 = this.mSpans;
        if (r16 >= r17.length) goto L30;
        if (r16 == r13) goto L29;
        Span r18 = r17[r16];
        if (r12 == true) goto L23;
    L25:
        if (r12 == true) goto L29;
        if (r18.findEnd(r11) == false) goto L29;
        return r18;
    L23:
        if (r18.findStart(r11) == false) goto L25;
        return r18;
    L29:
        r16 = r16 + 1;
        goto L16
    L30:
        return null;
    }

    private int getMaxEnd(int r10, OrientationHelperEx r11) {
        int r12 = this.mSpans[0].getEndLine(r10, r11);
        int r13 = 1;
    L4:
        if (r13 >= this.mNumLanes) goto L9;
        int r14 = this.mSpans[r13].getEndLine(r10, r11);
        if (r14 <= r12) goto L8;
        r12 = r14;
    L8:
        r13 = r13 + 1;
        goto L4
    L9:
        return r12;
    }

    private int getMaxStart(int r10, OrientationHelperEx r11) {
        int r12 = this.mSpans[0].getStartLine(r10, r11);
        int r13 = 1;
    L4:
        if (r13 >= this.mNumLanes) goto L9;
        int r14 = this.mSpans[r13].getStartLine(r10, r11);
        if (r14 <= r12) goto L8;
        r12 = r14;
    L8:
        r13 = r13 + 1;
        goto L4
    L9:
        return r12;
    }

    private int getMinEnd(int r10, OrientationHelperEx r11) {
        int r12 = this.mSpans[0].getEndLine(r10, r11);
        int r13 = 1;
    L4:
        if (r13 >= this.mNumLanes) goto L9;
        int r14 = this.mSpans[r13].getEndLine(r10, r11);
        if (r14 >= r12) goto L8;
        r12 = r14;
    L8:
        r13 = r13 + 1;
        goto L4
    L9:
        return r12;
    }

    private int getMinStart(int r10, OrientationHelperEx r11) {
        int r12 = this.mSpans[0].getStartLine(r10, r11);
        int r13 = 1;
    L4:
        if (r13 >= this.mNumLanes) goto L9;
        int r14 = this.mSpans[r13].getStartLine(r10, r11);
        if (r14 >= r12) goto L8;
        r12 = r14;
    L8:
        r13 = r13 + 1;
        goto L4
    L9:
        return r12;
    }

    private Span getNextSpan(int r10, VirtualLayoutManager.LayoutStateWrapper r11, LayoutManagerHelper r12) {
        OrientationHelperEx r13 = r12.getMainOrientationHelper();
        int r14 = 0;
        int r15 = -1;
        if (r12.getOrientation() != 0) goto L12;
        if (r11.getLayoutDirection() != (-1)) goto L7;
        boolean r16 = true;
    L9:
        if (r16 != r12.getReverseLayout()) goto L21;
    L22:
        r15 = this.mNumLanes;
        int r17 = 1;
    L23:
        Span r18 = null;
        if (r11.getLayoutDirection() != 1) goto L32;
        int r19 = Channel.UNLIMITED;
    L26:
        if (r14 == r15) goto L31;
        Span r20 = this.mSpans[r14];
        int r21 = r20.getEndLine(r10, r13);
        if (r21 >= r19) goto L30;
        r18 = r20;
        r19 = r21;
    L30:
        r14 = r14 + r17;
        goto L26
    L31:
        return r18;
    L32:
        int r22 = Integer.MIN_VALUE;
    L33:
        if (r14 == r15) goto L38;
        Span r23 = this.mSpans[r14];
        int r24 = r23.getStartLine(r10, r13);
        if (r24 <= r22) goto L37;
        r18 = r23;
        r22 = r24;
    L37:
        r14 = r14 + r17;
        goto L33
    L38:
        return r18;
    L21:
        r14 = this.mNumLanes - 1;
        r17 = -1;
        goto L23
    L7:
        r16 = false;
        goto L9
    L12:
        if (r11.getLayoutDirection() != (-1)) goto L14;
        boolean r25 = true;
    L16:
        if (r25 != r12.getReverseLayout()) goto L18;
        boolean r26 = true;
    L20:
        if (r26 != r12.isDoLayoutRTL()) goto L22;
    L18:
        r26 = false;
        goto L20
    L14:
        r25 = false;
        goto L16
    }

    private View hasGapsToFix(VirtualLayoutManager r10, int r11, int r12) {
        if (r10.findViewByPosition(r11) != null) goto L5;
        return null;
    L5:
        new BitSet(this.mNumLanes).set(0, this.mNumLanes, true);
        Span[] r13 = this.mSpans;
        int r14 = r13.length;
        int r15 = 0;
    L6:
        if (r15 >= r14) goto L18;
        Span r16 = r13[r15];
        if (Span.access$200(r16).size() == 0) goto L17;
        if (checkSpanForGap(r16, r10, r12) == false) goto L17;
        if (r10.getReverseLayout() == false) goto L15;
        Object r17 = Span.access$200(r16).get(Span.access$200(r16).size() - 1);
    L16:
        return (View) r17;
    L15:
        r17 = Span.access$200(r16).get(0);
    L17:
        r15 = r15 + 1;
        goto L6
    L18:
        return null;
    }

    private void recycle(RecyclerView.Recycler r10, VirtualLayoutManager.LayoutStateWrapper r11, Span r12, int r13, LayoutManagerHelper r14) {
        OrientationHelperEx r15 = r14.getMainOrientationHelper();
        if (r11.getLayoutDirection() != (-1)) goto L5;
        recycleFromEnd(r10, Math.max(r13, getMaxStart(r12.getStartLine(r15), r15)) + (r15.getEnd() - r15.getStartAfterPadding()), r14);
        return;
    L5:
        recycleFromStart(r10, Math.min(r13, getMinEnd(r12.getEndLine(r15), r15)) - (r15.getEnd() - r15.getStartAfterPadding()), r14);
    }

    private void recycleForPreLayout(RecyclerView.Recycler r10, VirtualLayoutManager.LayoutStateWrapper r11, LayoutManagerHelper r12) {
        OrientationHelperEx r13 = r12.getMainOrientationHelper();
        int r14 = this.prelayoutViewList.size() - 1;
    L3:
        if (r14 < 0) goto L22;
        View r15 = this.prelayoutViewList.get(r14);
        if (r15 == null) goto L12;
        if (r13.getDecoratedStart(r15) <= r13.getEndAfterPadding()) goto L12;
        Span r16 = findSpan(((RecyclerView.LayoutParams) r15.getLayoutParams()).getViewPosition(), r15, false);
        if (r16 == null) goto L11;
        r16.popEnd(r13);
        r12.removeChildView(r15);
        r10.G(r15);
    L11:
        r14 = r14 - 1;
    L12:
        Span r17 = findSpan(((RecyclerView.LayoutParams) r15.getLayoutParams()).getViewPosition(), r15, false);
        if (r17 == null) goto L21;
        r17.popEnd(r13);
        r12.removeChildView(r15);
        r10.G(r15);
        return;
    L21:
        return;
    }

    private void recycleFromEnd(RecyclerView.Recycler r10, int r11, LayoutManagerHelper r12) {
        OrientationHelperEx r13 = r12.getMainOrientationHelper();
        int r14 = r12.getChildCount() - 1;
    L3:
        if (r14 < 0) goto L12;
        View r15 = r12.getChildAt(r14);
        if (r15 == null) goto L18;
        if (r13.getDecoratedStart(r15) <= r11) goto L19;
        Span r16 = findSpan(((RecyclerView.LayoutParams) r15.getLayoutParams()).getViewPosition(), r15, false);
        if (r16 == null) goto L11;
        r16.popEnd(r13);
        r12.removeChildView(r15);
        r10.G(r15);
    L11:
        r14 = r14 - 1;
        goto L3
    L19:
        return;
    L18:
        return;
    }

    private void recycleFromStart(RecyclerView.Recycler r10, int r11, LayoutManagerHelper r12) {
        OrientationHelperEx r13 = r12.getMainOrientationHelper();
        boolean r14 = true;
    L4:
        if (r12.getChildCount() <= 0) goto L14;
        if (r14 == false) goto L24;
        View r15 = r12.getChildAt(0);
        if (r15 == null) goto L25;
        if (r13.getDecoratedEnd(r15) >= r11) goto L26;
        Span r16 = findSpan(((RecyclerView.LayoutParams) r15.getLayoutParams()).getViewPosition(), r15, true);
        if (r16 != null) goto L12;
        r14 = false;
        goto L4
    L12:
        r16.popStart(r13);
        r12.removeChildView(r15);
        r10.G(r15);
        goto L4
    L26:
        return;
    L25:
        return;
    L24:
        return;
    }

    private void updateAllRemainingSpans(int r10, int r11, OrientationHelperEx r12) {
        int r13 = 0;
    L4:
        if (r13 >= this.mNumLanes) goto L10;
        if (Span.access$200(this.mSpans[r13]).isEmpty() == true) goto L9;
        updateRemainingSpans(this.mSpans[r13], r10, r11, r12);
    L9:
        r13 = r13 + 1;
        goto L4
    }

    private void updateRemainingSpans(Span r10, int r11, int r12, OrientationHelperEx r13) {
        int r14 = r10.getDeletedSize();
        if (r11 != (-1)) goto L8;
        if ((r10.getStartLine(r13) + r14) >= r12) goto L11;
        this.mRemainingSpans.set(r10.mIndex, false);
        return;
    L11:
        return;
    L8:
        if ((r10.getEndLine(r13) - r14) <= r12) goto L13;
        this.mRemainingSpans.set(r10.mIndex, false);
        return;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public void afterLayout(RecyclerView.Recycler r10, RecyclerView.State r11, int r12, int r13, int r14, LayoutManagerHelper r15) {
        super.afterLayout(r10, r11, r12, r13, r14, r15);
        this.mLayoutWithAnchor = false;
        if (r12 <= ((Integer) getRange().getUpper()).intValue()) goto L5;
        return;
    L5:
        if (r13 >= ((Integer) getRange().getLower()).intValue()) goto L8;
        return;
    L8:
        if (r11.f() == false) goto L10;
        return;
    L10:
        if (r15.getChildCount() <= 0) goto L15;
        ViewCompat.h0(r15.getChildAt(0), this.checkForGapsRunnable);
        return;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public void beforeLayout(RecyclerView.Recycler r10, RecyclerView.State r11, LayoutManagerHelper r12) {
        super.beforeLayout(r10, r11, r12);
        if (r12.getOrientation() != 1) goto L6;
        int r13 = ((r12.getContentWidth() - r12.getPaddingLeft()) - r12.getPaddingRight()) - getHorizontalMargin();
        int r14 = getHorizontalPadding();
    L5:
        int r15 = r13 - r14;
        int r16 = this.mHGap;
        int r17 = this.mNumLanes;
        int r18 = (int) (((double) ((r15 - (r16 * (r17 - 1))) / r17)) + 0.5d);
        this.mColLength = r18;
        int r19 = r15 - (r18 * r17);
        if (r17 > 1) goto L11;
        this.mLastGap = 0;
        this.mEachGap = 0;
    L18:
        WeakReference<VirtualLayoutManager> r20 = this.mLayoutManager;
        if (r20 == null) goto L25;
        if (r20.get() == null) goto L25;
        if (this.mLayoutManager.get() != r12) goto L25;
        return;
    L25:
        if ((r12 instanceof VirtualLayoutManager) == false) goto L29;
        this.mLayoutManager = new WeakReference((VirtualLayoutManager) r12);
        return;
    L29:
        return;
    L11:
        if (r17 != 2) goto L14;
        this.mEachGap = r19;
        this.mLastGap = r19;
        goto L18
    L14:
        if (r12.getOrientation() != 1) goto L16;
        int r21 = this.mHGap;
    L17:
        this.mLastGap = r21;
        this.mEachGap = r21;
        goto L18
    L16:
        r21 = this.mVGap;
        goto L17
    L6:
        r13 = ((r12.getContentHeight() - r12.getPaddingTop()) - r12.getPaddingBottom()) - getVerticalMargin();
        r14 = getVerticalPadding();
        goto L5
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public void checkAnchorInfo(RecyclerView.State r13, VirtualLayoutManager.AnchorInfoWrapper r14, LayoutManagerHelper r15) {
        super.checkAnchorInfo(r13, r14, r15);
        ensureLanes();
        Range<Integer> r16 = getRange();
        boolean r10 = true;
        if (r14.layoutFromEnd == false) goto L8;
        if (r14.position >= ((((Integer) r16.getLower()).intValue() + this.mNumLanes) - 1)) goto L10;
        r14.position = Math.min((((Integer) r16.getLower()).intValue() + this.mNumLanes) - 1, ((Integer) r16.getUpper()).intValue());
    L10:
        View r11 = r15.findViewByPosition(r14.position);
        if (r15.getOrientation() != 1) goto L13;
        int r12 = this.mVGap;
    L14:
        OrientationHelperEx r17 = r15.getMainOrientationHelper();
        int r18 = 0;
        if (r11 != null) goto L19;
        Span[] r19 = this.mSpans;
        int r110 = r19.length;
    L17:
        if (r18 >= r110) goto L64;
        Span r111 = r19[r18];
        r111.clear();
        r111.setLine(r14.coordinate);
        r18 = r18 + 1;
        goto L17
    L64:
        return;
    L19:
        int r20 = Integer.MIN_VALUE;
        if (r14.layoutFromEnd == false) goto L22;
        int r21 = Integer.MIN_VALUE;
    L23:
        Span[] r22 = this.mSpans;
        int r23 = r22.length;
        int r24 = 0;
    L24:
        if (r24 >= r23) goto L33;
        Span r112 = r22[r24];
        if (Span.access$200(r112).isEmpty() == true) goto L31;
        if (r14.layoutFromEnd == false) goto L30;
        r21 = Math.max(r21, r15.getPosition((View) Span.access$200(r112).get(Span.access$200(r112).size() - 1)));
        goto L31
    L30:
        r21 = Math.min(r21, r15.getPosition((View) Span.access$200(r112).get(0)));
    L31:
        r24 = r24 + 1;
        goto L24
    L33:
        if (isOutOfRange(r21) == false) goto L35;
        this.anchorPosition = r14.position;
        this.mLayoutWithAnchor = true;
    L61:
        Span[] r113 = this.mSpans;
        int r114 = r113.length;
    L62:
        if (r18 >= r114) goto L71;
        r113[r18].cacheReferenceLineAndClear(r15.getReverseLayout() ^ r14.layoutFromEnd, r20, r17);
        r18 = r18 + 1;
        goto L62
    L71:
        return;
    L35:
        if (r21 == ((Integer) r16.getLower()).intValue()) goto L38;
        r10 = false;
    L38:
        View r115 = r15.findViewByPosition(r21);
        if (r115 == null) goto L61;
        if (r14.layoutFromEnd == false) goto L51;
        r14.position = r21;
        int r25 = r17.getDecoratedEnd(r11);
        int r26 = r14.coordinate;
        if (r25 >= r26) goto L48;
        int r27 = r26 - r25;
        if (r10 == false) goto L47;
        r12 = 0;
    L47:
        int r28 = r27 + r12;
        r14.coordinate = r17.getDecoratedEnd(r115) + r28;
        r20 = r28;
        goto L61
    L48:
        if (r10 == false) goto L50;
        r12 = 0;
    L50:
        r14.coordinate = r17.getDecoratedEnd(r115) + r12;
        r20 = r12;
        goto L61
    L51:
        r14.position = r21;
        int r29 = r17.getDecoratedStart(r11);
        int r30 = r14.coordinate;
        if (r29 <= r30) goto L57;
        int r31 = r30 - r29;
        if (r10 == false) goto L56;
        r12 = 0;
    L56:
        r20 = r31 - r12;
        r14.coordinate = r17.getDecoratedStart(r115) + r20;
        goto L61
    L57:
        if (r10 == false) goto L59;
        r12 = 0;
    L59:
        r20 = -r12;
        r14.coordinate = r17.getDecoratedStart(r115) + r20;
        goto L61
    L22:
        r21 = Channel.UNLIMITED;
        goto L23
    L13:
        r12 = this.mHGap;
        goto L14
    L8:
        if (r14.position <= (((Integer) r16.getUpper()).intValue() - (this.mNumLanes - 1))) goto L10;
        r14.position = Math.max(((Integer) r16.getLower()).intValue(), ((Integer) r16.getUpper()).intValue() - (this.mNumLanes - 1));
        goto L10
    }

    @Override // com.alibaba.android.vlayout.layout.MarginLayoutHelper, com.alibaba.android.vlayout.LayoutHelper
    public int computeAlignOffset(int r10, boolean r11, boolean r12, LayoutManagerHelper r13) {
        if (r13.getOrientation() != 1) goto L5;
        boolean r14 = true;
    L6:
        OrientationHelperEx r15 = r13.getMainOrientationHelper();
        View r16 = r13.findViewByPosition(((Integer) getRange().getLower()).intValue() + r10);
        if (r16 != null) goto L9;
        return 0;
    L9:
        ensureLanes();
        if (r14 == false) goto L25;
        if (r11 == true) goto L13;
        if (r10 == 0) goto L22;
        if (r12 == true) goto L25;
        int r17 = getMaxStart(r15.getDecoratedEnd(r16), r15);
        int r18 = r15.getDecoratedStart(r16);
    L19:
        return r17 - r18;
    L22:
        return ((-this.mMarginTop) - this.mPaddingTop) - (r15.getDecoratedStart(r16) - getMinStart(r15.getDecoratedStart(r16), r15));
    L13:
        if (r10 == (getItemCount() - 1)) goto L15;
        if (r12 == true) goto L25;
        r17 = getMinEnd(r15.getDecoratedStart(r16), r15);
        r18 = r15.getDecoratedEnd(r16);
        goto L19
    L15:
        return (this.mMarginBottom + this.mPaddingBottom) + (getMaxEnd(r15.getDecoratedEnd(r16), r15) - r15.getDecoratedEnd(r16));
    L25:
        return 0;
    L5:
        r14 = false;
        goto L6
    }

    public int getColLength() {
        return this.mColLength;
    }

    public int getHGap() {
        return this.mHGap;
    }

    public int getLane() {
        return this.mNumLanes;
    }

    public int getVGap() {
        return this.mVGap;
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public boolean isRecyclable(int r10, int r11, int r12, LayoutManagerHelper r13, boolean r14) {
        boolean r15 = super.isRecyclable(r10, r11, r12, r13, r14);
        if (r15 == false) goto L22;
        View r16 = r13.findViewByPosition(r10);
        if (r16 == null) goto L22;
        OrientationHelperEx r17 = r13.getMainOrientationHelper();
        int r18 = ((RecyclerView.LayoutParams) r16.getLayoutParams()).getViewPosition();
        if (r13.getReverseLayout() == false) goto L15;
        if (r14 == false) goto L12;
        Span r19 = findSpan(r18, r16, true);
        if (r19 == null) goto L22;
        r19.popEnd(r17);
        goto L22
    L12:
        Span r20 = findSpan(r18, r16, false);
        if (r20 == null) goto L22;
        r20.popStart(r17);
        goto L22
    L15:
        if (r14 == false) goto L19;
        Span r21 = findSpan(r18, r16, true);
        if (r21 == null) goto L22;
        r21.popStart(r17);
        goto L22
    L19:
        Span r22 = findSpan(r18, r16, false);
        if (r22 == null) goto L22;
        r22.popEnd(r17);
    L22:
        return r15;
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void layoutViews(RecyclerView.Recycler r24, RecyclerView.State r25, VirtualLayoutManager.LayoutStateWrapper r26, LayoutChunkResult r27, LayoutManagerHelper r28) {
        if (isOutOfRange(r26.getCurrentPosition()) == false) goto L5;
        return;
    L5:
        ensureLanes();
        if (r28.getOrientation() != 1) goto L8;
        boolean r15 = true;
    L9:
        OrientationHelperEx r10 = r28.getMainOrientationHelper();
        OrientationHelperEx r16 = r28.getSecondaryOrientationHelper();
        boolean r11 = r28.isEnableMarginOverLap();
        this.mRemainingSpans.set(0, this.mNumLanes, true);
        if (r26.getLayoutDirection() != 1) goto L13;
        int r12 = r26.getOffset() + r26.getAvailable();
        int r13 = (r26.getExtra() + r12) + r10.getEndPadding();
    L12:
        int r17 = r12;
        int r14 = r13;
        updateAllRemainingSpans(r26.getLayoutDirection(), r14, r10);
        int r18 = r26.getOffset();
        this.prelayoutViewList.clear();
    L16:
        if (r26.hasMore(r25) == false) goto L23;
        if (this.mRemainingSpans.isEmpty() == true) goto L23;
        if (isOutOfRange(r26.getCurrentPosition()) == true) goto L23;
        int r19 = r26.getCurrentPosition();
        View r20 = r26.next(r24);
        if (r20 == null) goto L23;
        VirtualLayoutManager.LayoutParams r110 = (VirtualLayoutManager.LayoutParams) r20.getLayoutParams();
        int r111 = r110.getViewPosition();
        int r21 = r14;
        int r22 = this.mLazySpanLookup.getSpan(r111);
        if (r22 != Integer.MIN_VALUE) goto L28;
        Span r23 = getNextSpan(r18, r26, r28);
        this.mLazySpanLookup.setSpan(r111, r23);
    L27:
        Span r29 = r23;
        if ((r111 - ((Integer) getRange().getLower()).intValue()) >= this.mNumLanes) goto L32;
        boolean r30 = true;
    L34:
        if ((((Integer) getRange().getUpper()).intValue() - r111) >= this.mNumLanes) goto L36;
        boolean r31 = true;
    L38:
        if (r26.isPreLayout() == false) goto L40;
        this.prelayoutViewList.add(r20);
    L40:
        r28.addChildView(r26, r20);
        if (r15 == false) goto L48;
        int r32 = r28.getChildMeasureSpec(this.mColLength, ((ViewGroup.MarginLayoutParams) r110).width, false);
        int r112 = r10.getTotalSpace();
        if (Float.isNaN(r110.mAspectRatio) == false) goto L46;
        int r113 = ((ViewGroup.MarginLayoutParams) r110).height;
    L47:
        r28.measureChildWithMargins(r20, r32, r28.getChildMeasureSpec(r112, r113, true));
        boolean r114 = true;
    L55:
        if (r26.getLayoutDirection() != r114) goto L72;
        int r33 = r29.getEndLine(r18, r10);
        if (r30 == false) goto L61;
        int r34 = computeStartSpace(r28, r15, r114, r11);
    L59:
        r33 = r33 + r34;
    L71:
        int r35 = r10.getDecoratedMeasurement(r20) + r33;
    L85:
        if (r26.getLayoutDirection() != 1) goto L87;
        r29.appendToSpan(r20, r10);
    L88:
        int r36 = r29.mIndex;
        if (r36 != (this.mNumLanes - 1)) goto L91;
        int r37 = this.mColLength;
        int r115 = this.mEachGap;
        int r38 = ((r36 * (r37 + r115)) - r115) + this.mLastGap;
    L92:
        int r39 = r38 + r16.getStartAfterPadding();
        if (r15 == false) goto L96;
        int r40 = this.mMarginLeft;
        int r116 = this.mPaddingLeft;
    L95:
        int r41 = r39 + (r40 + r116);
        int r117 = r41 + r10.getDecoratedMeasurementInOther(r20);
        if (r15 == false) goto L100;
        View r118 = r20;
        layoutChildWithMargin(r20, r41, r33, r117, r35, r28);
        int r42 = r21;
        Span r43 = r29;
        OrientationHelperEx r119 = r10;
    L101:
        updateRemainingSpans(r43, r26.getLayoutDirection(), r42, r119);
        recycle(r24, r26, r43, r17, r28);
        handleStateOnResult(r27, r118);
        r14 = r42;
        r10 = r119;
        r11 = r11;
        r18 = r18;
        goto L16
    L100:
        r118 = r20;
        int r44 = r33;
        r43 = r29;
        int r45 = r35;
        r42 = r21;
        r119 = r10;
        layoutChildWithMargin(r118, r44, r41, r45, r117, r28);
        goto L101
    L96:
        r40 = this.mMarginTop;
        r116 = this.mPaddingTop;
        goto L95
    L91:
        r38 = r36 * (this.mColLength + this.mEachGap);
        goto L92
    L87:
        r29.prependToSpan(r20, r10);
        goto L88
    L61:
        if (this.mLayoutWithAnchor == true) goto L63;
        if (r15 == false) goto L70;
        r34 = this.mVGap;
        goto L59
    L70:
        r34 = this.mHGap;
        goto L59
    L63:
        if (Math.abs(r19 - this.anchorPosition) < this.mNumLanes) goto L71;
        if (r15 == false) goto L67;
        r34 = this.mVGap;
        goto L59
    L67:
        r34 = this.mHGap;
        goto L59
    L72:
        if (r31 == false) goto L79;
        int r46 = r29.getStartLine(r18, r10);
        if (r15 == false) goto L77;
        int r47 = this.mMarginBottom;
    L76:
        int r48 = r47 + this.mPaddingRight;
    L78:
        int r49 = r46 - r48;
        r35 = r49;
        r33 = r49 - r10.getDecoratedMeasurement(r20);
        goto L85
    L77:
        r47 = this.mMarginRight;
        goto L76
    L79:
        r46 = r29.getStartLine(r18, r10);
        if (r15 == false) goto L82;
        r48 = this.mVGap;
        goto L78
    L82:
        r48 = this.mHGap;
        goto L78
    L46:
        r113 = (int) ((View.MeasureSpec.getSize(r32) / r110.mAspectRatio) + 0.5f);
        goto L47
    L48:
        int r50 = r28.getChildMeasureSpec(this.mColLength, ((ViewGroup.MarginLayoutParams) r110).height, false);
        int r120 = r10.getTotalSpace();
        if (Float.isNaN(r110.mAspectRatio) == false) goto L52;
        int r121 = ((ViewGroup.MarginLayoutParams) r110).width;
    L51:
        r114 = true;
        r28.measureChildWithMargins(r20, r28.getChildMeasureSpec(r120, r121, true), r50);
        goto L55
    L52:
        r121 = (int) ((View.MeasureSpec.getSize(r50) * r110.mAspectRatio) + 0.5f);
        goto L51
    L36:
        r31 = false;
        goto L38
    L32:
        r30 = false;
        goto L34
    L28:
        r23 = this.mSpans[r22];
    L23:
        OrientationHelperEx r122 = r10;
        if (isOutOfRange(r26.getCurrentPosition()) == false) goto L119;
        if (r26.getLayoutDirection() != (-1)) goto L112;
        Span[] r51 = this.mSpans;
        int r52 = r51.length;
        int r53 = 0;
    L107:
        if (r53 >= r52) goto L119;
        Span r54 = r51[r53];
        int r55 = r54.mCachedStart;
        if (r55 == Integer.MIN_VALUE) goto L111;
        r54.mLastEdgeStart = r55;
    L111:
        r53 = r53 + 1;
        goto L107
    L112:
        Span[] r56 = this.mSpans;
        int r57 = r56.length;
        int r58 = 0;
    L113:
        if (r58 >= r57) goto L119;
        Span r59 = r56[r58];
        int r60 = r59.mCachedEnd;
        if (r60 == Integer.MIN_VALUE) goto L117;
        r59.mLastEdgeEnd = r60;
    L117:
        r58 = r58 + 1;
    L119:
        if (r26.getLayoutDirection() == (-1)) goto L121;
        VirtualLayoutManager.LayoutStateWrapper r61 = r26;
        if (isOutOfRange(r26.getCurrentPosition()) == false) goto L136;
    L138:
        int r62 = getMaxEnd(r122.getEndAfterPadding(), r122) - r26.getOffset();
        if (r15 == false) goto L142;
        int r63 = this.mMarginBottom;
        int r64 = this.mPaddingBottom;
    L143:
        r27.mConsumed = r62 + (r63 + r64);
    L144:
        recycleForPreLayout(r24, r61, r28);
        return;
    L142:
        r63 = this.mMarginRight;
        r64 = this.mPaddingRight;
        goto L143
    L136:
        if (r61.hasMore(r25) == false) goto L138;
        r27.mConsumed = getMinEnd(r122.getEndAfterPadding(), r122) - r26.getOffset();
        goto L144
    L121:
        if (isOutOfRange(r26.getCurrentPosition()) == true) goto L126;
        r61 = r26;
        if (r61.hasMore(r25) == false) goto L127;
        r27.mConsumed = r26.getOffset() - getMaxStart(r122.getStartAfterPadding(), r122);
    L127:
        int r65 = r26.getOffset() - getMinStart(r122.getEndAfterPadding(), r122);
        if (r15 == false) goto L131;
        int r66 = this.mMarginTop;
        int r67 = this.mPaddingTop;
    L132:
        r27.mConsumed = r65 + (r66 + r67);
        goto L144
    L131:
        r66 = this.mMarginLeft;
        r67 = this.mPaddingLeft;
        goto L132
    L126:
        r61 = r26;
        goto L127
    L13:
        r12 = r26.getOffset() - r26.getAvailable();
        r13 = (r12 - r26.getExtra()) - r10.getStartAfterPadding();
        goto L12
    L8:
        r15 = false;
        goto L9
    }

    @Override // com.alibaba.android.vlayout.layout.BaseLayoutHelper
    public void onClear(LayoutManagerHelper r10) {
        super.onClear(r10);
        this.mLazySpanLookup.clear();
        this.mSpans = null;
        this.mLayoutManager = null;
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public void onItemsChanged(LayoutManagerHelper r10) {
        this.mLazySpanLookup.clear();
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public void onOffsetChildrenHorizontal(int r10, LayoutManagerHelper r11) {
        super.onOffsetChildrenHorizontal(r10, r11);
        if (r11.getOrientation() != 0) goto L7;
        Span[] r12 = this.mSpans;
        int r13 = r12.length;
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L9;
        r12[r14].onOffset(r10);
        r14 = r14 + 1;
        goto L5
    L9:
        return;
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public void onOffsetChildrenVertical(int r10, LayoutManagerHelper r11) {
        super.onOffsetChildrenVertical(r10, r11);
        if (r11.getOrientation() != 1) goto L7;
        Span[] r12 = this.mSpans;
        int r13 = r12.length;
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L9;
        r12[r14].onOffset(r10);
        r14 = r14 + 1;
        goto L5
    L9:
        return;
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public void onRefreshLayout(RecyclerView.State r10, VirtualLayoutManager.AnchorInfoWrapper r11, LayoutManagerHelper r12) {
        super.onRefreshLayout(r10, r11, r12);
        ensureLanes();
        if (isOutOfRange(r11.position) == false) goto L7;
        Span[] r13 = this.mSpans;
        int r14 = r13.length;
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L9;
        r13[r15].clear();
        r15 = r15 + 1;
        goto L5
    L9:
        return;
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public void onRestoreInstanceState(Bundle r10) {
        super.onRestoreInstanceState(r10);
        LazySpanLookup r11 = this.mLazySpanLookup;
        r11.mData = r10.getIntArray(LOOKUP_BUNDLE_KEY);
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public void onSaveState(Bundle r10) {
        super.onSaveState(r10);
        r10.putIntArray(LOOKUP_BUNDLE_KEY, this.mLazySpanLookup.mData);
    }

    @Override // com.alibaba.android.vlayout.LayoutHelper
    public void onScrollStateChanged(int r10, int r11, int r12, LayoutManagerHelper r13) {
        if (r11 <= ((Integer) getRange().getUpper()).intValue()) goto L5;
        return;
    L5:
        if (r12 < ((Integer) getRange().getLower()).intValue()) goto L12;
        if (r10 != 0) goto L11;
        checkForGaps();
        return;
    L11:
        return;
    }

    public void setGap(int r10) {
        setHGap(r10);
        setVGap(r10);
    }

    public void setHGap(int r10) {
        this.mHGap = r10;
    }

    public void setLane(int r10) {
        this.mNumLanes = r10;
        ensureLanes();
    }

    public void setVGap(int r10) {
        this.mVGap = r10;
    }

    public StaggeredGridLayoutHelper(int r10) {
        this(r10, 0);
    }

    public StaggeredGridLayoutHelper(int r10, int r11) {
        this.mNumLanes = 0;
        this.mHGap = 0;
        this.mVGap = 0;
        this.mColLength = 0;
        this.mEachGap = 0;
        this.mLastGap = 0;
        this.mRemainingSpans = null;
        this.mLazySpanLookup = new LazySpanLookup();
        this.prelayoutViewList = new ArrayList();
        this.mLayoutManager = null;
        this.checkForGapsRunnable = new AnonymousClass1(this);
        setLane(r10);
        setGap(r11);
    }
}
