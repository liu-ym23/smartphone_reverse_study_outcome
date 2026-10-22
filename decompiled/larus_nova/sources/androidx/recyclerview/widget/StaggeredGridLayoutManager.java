package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    static final boolean DEBUG = false;
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "StaggeredGridLManager";
    public static final int VERTICAL = 1;
    private final AnchorInfo mAnchorInfo;
    private final Runnable mCheckForGapsRunnable;
    private int mFullSizeSpec;
    private int mGapStrategy;
    private boolean mLaidOutInvalidFullSpan;
    private boolean mLastLayoutFromEnd;
    private boolean mLastLayoutRTL;
    private final LayoutState mLayoutState;
    LazySpanLookup mLazySpanLookup;
    private int mOrientation;
    private SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private int[] mPrefetchDistances;
    OrientationHelper mPrimaryOrientation;
    private BitSet mRemainingSpans;
    boolean mReverseLayout;
    OrientationHelper mSecondaryOrientation;
    boolean mShouldReverseLayout;
    private int mSizePerSpan;
    private boolean mSmoothScrollbarEnabled;
    private int mSpanCount;
    Span[] mSpans;
    private final Rect mTmpRect;

    public class AnchorInfo {
        boolean mInvalidateOffsets;
        boolean mLayoutFromEnd;
        int mOffset;
        int mPosition;
        int[] mSpanReferenceLines;
        boolean mValid;
        final /* synthetic */ StaggeredGridLayoutManager this$0;

        public void reset() {
            this.mPosition = -1;
            this.mOffset = Integer.MIN_VALUE;
            this.mLayoutFromEnd = false;
            this.mInvalidateOffsets = false;
            this.mValid = false;
            int[] r100 = this.mSpanReferenceLines;
            if (r100 == null) goto L6;
            Arrays.fill(r100, -1);
            return;
        }

        public void assignCoordinateFromPadding() {
            if (this.mLayoutFromEnd == false) goto L5;
            int r100 = this.this$0.mPrimaryOrientation.getEndAfterPadding();
        L6:
            this.mOffset = r100;
            return;
        L5:
            r100 = this.this$0.mPrimaryOrientation.getStartAfterPadding();
            goto L6
        }

        public AnchorInfo(StaggeredGridLayoutManager r100) {
            this.this$0 = r100;
            reset();
        }

        public void assignCoordinateFromPadding(int r100) {
            if (this.mLayoutFromEnd == false) goto L5;
            this.mOffset = this.this$0.mPrimaryOrientation.getEndAfterPadding() - r100;
            return;
        L5:
            this.mOffset = this.this$0.mPrimaryOrientation.getStartAfterPadding() + r100;
        }

        public void saveSpanReferenceLines(Span[] r100) {
            int r101 = r100.length;
            int[] r102 = this.mSpanReferenceLines;
            if (r102 != null) goto L5;
        L6:
            this.mSpanReferenceLines = new int[this.this$0.mSpans.length];
        L7:
            int r103 = 0;
        L8:
            if (r103 >= r101) goto L10;
            this.mSpanReferenceLines[r103] = r100[r103].getStartLine(Integer.MIN_VALUE);
            r103 = r103 + 1;
            goto L8
        L10:
            return;
        L5:
            if (r102.length >= r101) goto L7;
            goto L6
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        boolean mFullSpan;
        Span mSpan;

        public final int getSpanIndex() {
            Span r100 = this.mSpan;
            if (r100 != null) goto L7;
            return -1;
        L7:
            return r100.mIndex;
        }

        public boolean isFullSpan() {
            return this.mFullSpan;
        }

        public LayoutParams(ViewGroup.LayoutParams r100) {
            super(r100);
        }

        public void setFullSpan(boolean r100) {
            this.mFullSpan = r100;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams r100) {
            super(r100);
        }

        public LayoutParams(RecyclerView.LayoutParams r100) {
            super(r100);
        }

        public LayoutParams(int r100, int r101) {
            super(r100, r101);
        }

        public LayoutParams(Context r100, AttributeSet r101) {
            super(r100, r101);
        }
    }

    public static class LazySpanLookup {
        private static final int MIN_SIZE = 10;
        int[] mData;
        List<FullSpanItem> mFullSpanItems;

        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = null;
            int mGapDir;
            int[] mGapPerSpan;
            boolean mHasUnwantedGapAfter;
            int mPosition;

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            static {
                CREATOR = new AnonymousClass1();
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.mGapDir + ", mHasUnwantedGapAfter=" + this.mHasUnwantedGapAfter + ", mGapPerSpan=" + Arrays.toString(this.mGapPerSpan) + '}';
            }

            public FullSpanItem() {
            }

            public FullSpanItem(Parcel r100) {
                this.mPosition = r100.readInt();
                this.mGapDir = r100.readInt();
                boolean r101 = true;
                if (r100.readInt() == 1) goto L6;
                r101 = false;
            L6:
                this.mHasUnwantedGapAfter = r101;
                int r102 = r100.readInt();
                if (r102 <= 0) goto L10;
                int[] r103 = new int[r102];
                this.mGapPerSpan = r103;
                r100.readIntArray(r103);
                return;
            }

            public int getGapForSpan(int r100) {
                int[] r101 = this.mGapPerSpan;
                if (r101 != null) goto L6;
                return 0;
            L6:
                return r101[r100];
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel r100, int r101) {
                r100.writeInt(this.mPosition);
                r100.writeInt(this.mGapDir);
                r100.writeInt(this.mHasUnwantedGapAfter ? 1 : 0);
                int[] r102 = this.mGapPerSpan;
                if (r102 != null) goto L5;
            L7:
                r100.writeInt(0);
                return;
            L5:
                if (r102.length <= 0) goto L7;
                r100.writeInt(r102.length);
                r100.writeIntArray(this.mGapPerSpan);
            }
        }

        public LazySpanLookup() {
        }

        public void clear() {
            int[] r100 = this.mData;
            if (r100 == null) goto L5;
            Arrays.fill(r100, -1);
        L5:
            this.mFullSpanItems = null;
        }

        private int invalidateFullSpansAfter(int r100) {
            if (this.mFullSpanItems != null) goto L5;
            return -1;
        L5:
            FullSpanItem r101 = getFullSpanItem(r100);
            if (r101 == null) goto L8;
            this.mFullSpanItems.remove(r101);
        L8:
            int r102 = this.mFullSpanItems.size();
            int r103 = 0;
        L9:
            if (r103 >= r102) goto L14;
            if (((FullSpanItem) ListProtector.get(this.mFullSpanItems, r103)).mPosition >= r100) goto L15;
            r103 = r103 + 1;
        L15:
            if (r103 == (-1)) goto L18;
            FullSpanItem r104 = (FullSpanItem) ListProtector.get(this.mFullSpanItems, r103);
            ListProtector.remove(this.mFullSpanItems, r103);
            return r104.mPosition;
        L18:
            return -1;
        L14:
            r103 = -1;
            goto L15
        }

        public void addFullSpanItem(FullSpanItem r100) {
            if (this.mFullSpanItems != null) goto L5;
            this.mFullSpanItems = new ArrayList();
        L5:
            int r101 = this.mFullSpanItems.size();
            int r102 = 0;
        L6:
            if (r102 >= r101) goto L15;
            FullSpanItem r103 = (FullSpanItem) ListProtector.get(this.mFullSpanItems, r102);
            if (r103.mPosition != r100.mPosition) goto L11;
            ListProtector.remove(this.mFullSpanItems, r102);
        L11:
            if (r103.mPosition >= r100.mPosition) goto L12;
            r102 = r102 + 1;
            goto L6
        L12:
            ListProtector.add(this.mFullSpanItems, r102, r100);
            return;
        L15:
            this.mFullSpanItems.add(r100);
        }

        public void ensureSize(int r100) {
            int[] r101 = this.mData;
            if (r101 != null) goto L6;
            int[] r102 = new int[Math.max(r100, 10) + 1];
            this.mData = r102;
            Arrays.fill(r102, -1);
            return;
        L6:
            if (r100 < r101.length) goto L10;
            int[] r103 = new int[sizeForPosition(r100)];
            this.mData = r103;
            System.arraycopy(r101, 0, r103, 0, r101.length);
            int[] r104 = this.mData;
            Arrays.fill(r104, r101.length, r104.length, -1);
            return;
        }

        public int forceInvalidateAfter(int r100) {
            List<FullSpanItem> r101 = this.mFullSpanItems;
            if (r101 == null) goto L11;
            int r102 = r101.size() - 1;
        L5:
            if (r102 < 0) goto L11;
            if (((FullSpanItem) ListProtector.get(this.mFullSpanItems, r102)).mPosition < r100) goto L9;
            ListProtector.remove(this.mFullSpanItems, r102);
        L9:
            r102 = r102 - 1;
        L11:
            return invalidateAfter(r100);
        }

        public FullSpanItem getFullSpanItem(int r100) {
            List<FullSpanItem> r101 = this.mFullSpanItems;
            if (r101 != null) goto L5;
            return null;
        L5:
            int r102 = r101.size() - 1;
        L6:
            if (r102 < 0) goto L11;
            FullSpanItem r103 = (FullSpanItem) ListProtector.get(this.mFullSpanItems, r102);
            if (r103.mPosition == r100) goto L9;
            r102 = r102 - 1;
            goto L6
        L9:
            return r103;
        L11:
            return null;
        }

        public int getSpan(int r100) {
            int[] r101 = this.mData;
            if (r101 != null) goto L5;
            return -1;
        L5:
            if (r100 < r101.length) goto L8;
            return -1;
        L8:
            return r101[r100];
        }

        public int invalidateAfter(int r100) {
            int[] r101 = this.mData;
            if (r101 != null) goto L6;
            return -1;
        L6:
            if (r100 < r101.length) goto L8;
            return -1;
        L8:
            int r102 = invalidateFullSpansAfter(r100);
            if (r102 != (-1)) goto L12;
            int[] r103 = this.mData;
            Arrays.fill(r103, r100, r103.length, -1);
            return this.mData.length;
        L12:
            int r104 = Math.min(r102 + 1, this.mData.length);
            Arrays.fill(this.mData, r100, r104, -1);
            return r104;
        }

        public int sizeForPosition(int r100) {
            int r101 = this.mData.length;
        L3:
            if (r101 > r100) goto L5;
            r101 = r101 * 2;
            goto L3
        L5:
            return r101;
        }

        private void offsetFullSpansForAddition(int r100, int r101) {
            List<FullSpanItem> r102 = this.mFullSpanItems;
            if (r102 != null) goto L5;
            return;
        L5:
            int r103 = r102.size() - 1;
        L6:
            if (r103 < 0) goto L12;
            FullSpanItem r104 = (FullSpanItem) ListProtector.get(this.mFullSpanItems, r103);
            int r105 = r104.mPosition;
            if (r105 < r100) goto L11;
            r104.mPosition = r105 + r101;
        L11:
            r103 = r103 - 1;
            goto L6
        }

        private void offsetFullSpansForRemoval(int r100, int r101) {
            List<FullSpanItem> r102 = this.mFullSpanItems;
            if (r102 != null) goto L5;
            return;
        L5:
            int r103 = r100 + r101;
            int r104 = r102.size() - 1;
        L6:
            if (r104 < 0) goto L14;
            FullSpanItem r105 = (FullSpanItem) ListProtector.get(this.mFullSpanItems, r104);
            int r106 = r105.mPosition;
            if (r106 < r100) goto L13;
            if (r106 >= r103) goto L12;
            ListProtector.remove(this.mFullSpanItems, r104);
            goto L13
        L12:
            r105.mPosition = r106 - r101;
        L13:
            r104 = r104 - 1;
            goto L6
        }

        public void offsetForAddition(int r100, int r101) {
            int[] r102 = this.mData;
            if (r102 != null) goto L5;
            return;
        L5:
            if (r100 >= r102.length) goto L10;
            int r103 = r100 + r101;
            ensureSize(r103);
            int[] r104 = this.mData;
            System.arraycopy(r104, r100, r104, r103, (r104.length - r100) - r101);
            Arrays.fill(this.mData, r100, r103, -1);
            offsetFullSpansForAddition(r100, r101);
            return;
        }

        public void offsetForRemoval(int r100, int r101) {
            int[] r102 = this.mData;
            if (r102 != null) goto L5;
            return;
        L5:
            if (r100 >= r102.length) goto L10;
            int r103 = r100 + r101;
            ensureSize(r103);
            int[] r104 = this.mData;
            System.arraycopy(r104, r103, r104, r100, (r104.length - r100) - r101);
            int[] r105 = this.mData;
            Arrays.fill(r105, r105.length - r101, r105.length, -1);
            offsetFullSpansForRemoval(r100, r101);
            return;
        }

        public void setSpan(int r100, Span r101) {
            ensureSize(r100);
            this.mData[r100] = r101.mIndex;
        }

        public FullSpanItem getFirstFullSpanItemInRange(int r100, int r101, int r102, boolean r103) {
            List<FullSpanItem> r104 = this.mFullSpanItems;
            if (r104 != null) goto L5;
            return null;
        L5:
            int r105 = r104.size();
            int r106 = 0;
        L6:
            if (r106 >= r105) goto L19;
            FullSpanItem r107 = (FullSpanItem) ListProtector.get(this.mFullSpanItems, r106);
            int r108 = r107.mPosition;
            if (r108 >= r101) goto L9;
            if (r108 < r100) goto L18;
            if (r102 == 0) goto L17;
            if (r107.mGapDir == r102) goto L17;
            if (r103 == false) goto L18;
            if (r107.mHasUnwantedGapAfter == false) goto L18;
        L17:
            return r107;
        L18:
            r106 = r106 + 1;
            goto L6
        L9:
            return null;
        L19:
            return null;
        }
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        boolean mAnchorLayoutFromEnd;
        int mAnchorPosition;
        List<LazySpanLookup.FullSpanItem> mFullSpanItems;
        boolean mLastLayoutRTL;
        boolean mReverseLayout;
        int[] mSpanLookup;
        int mSpanLookupSize;
        int[] mSpanOffsets;
        int mSpanOffsetsSize;
        int mVisibleAnchorPosition;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void invalidateAnchorPositionInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mAnchorPosition = -1;
            this.mVisibleAnchorPosition = -1;
        }

        public void invalidateSpanInfo() {
            this.mSpanOffsets = null;
            this.mSpanOffsetsSize = 0;
            this.mSpanLookupSize = 0;
            this.mSpanLookup = null;
            this.mFullSpanItems = null;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState() {
        }

        public SavedState(Parcel r100) {
            this.mAnchorPosition = r100.readInt();
            this.mVisibleAnchorPosition = r100.readInt();
            int r101 = r100.readInt();
            this.mSpanOffsetsSize = r101;
            if (r101 <= 0) goto L5;
            int[] r102 = new int[r101];
            this.mSpanOffsets = r102;
            r100.readIntArray(r102);
        L5:
            int r103 = r100.readInt();
            this.mSpanLookupSize = r103;
            if (r103 <= 0) goto L8;
            int[] r104 = new int[r103];
            this.mSpanLookup = r104;
            r100.readIntArray(r104);
        L8:
            boolean r105 = false;
            if (r100.readInt() != 1) goto L11;
            boolean r106 = true;
        L12:
            this.mReverseLayout = r106;
            if (r100.readInt() != 1) goto L15;
            boolean r107 = true;
        L16:
            this.mAnchorLayoutFromEnd = r107;
            if (r100.readInt() != 1) goto L19;
            r105 = true;
        L19:
            this.mLastLayoutRTL = r105;
            this.mFullSpanItems = r100.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
            return;
        L15:
            r107 = false;
            goto L16
        L11:
            r106 = false;
            goto L12
        }

        public SavedState(SavedState r100) {
            this.mSpanOffsetsSize = r100.mSpanOffsetsSize;
            this.mAnchorPosition = r100.mAnchorPosition;
            this.mVisibleAnchorPosition = r100.mVisibleAnchorPosition;
            this.mSpanOffsets = r100.mSpanOffsets;
            this.mSpanLookupSize = r100.mSpanLookupSize;
            this.mSpanLookup = r100.mSpanLookup;
            this.mReverseLayout = r100.mReverseLayout;
            this.mAnchorLayoutFromEnd = r100.mAnchorLayoutFromEnd;
            this.mLastLayoutRTL = r100.mLastLayoutRTL;
            this.mFullSpanItems = r100.mFullSpanItems;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r100, int r101) {
            r100.writeInt(this.mAnchorPosition);
            r100.writeInt(this.mVisibleAnchorPosition);
            r100.writeInt(this.mSpanOffsetsSize);
            if (this.mSpanOffsetsSize <= 0) goto L5;
            r100.writeIntArray(this.mSpanOffsets);
        L5:
            r100.writeInt(this.mSpanLookupSize);
            if (this.mSpanLookupSize <= 0) goto L8;
            r100.writeIntArray(this.mSpanLookup);
        L8:
            r100.writeInt(this.mReverseLayout ? 1 : 0);
            r100.writeInt(this.mAnchorLayoutFromEnd ? 1 : 0);
            r100.writeInt(this.mLastLayoutRTL ? 1 : 0);
            r100.writeList(this.mFullSpanItems);
        }
    }

    public class Span {
        static final int INVALID_LINE = Integer.MIN_VALUE;
        int mCachedEnd;
        int mCachedStart;
        int mDeletedSize;
        final int mIndex;
        ArrayList<View> mViews;
        final /* synthetic */ StaggeredGridLayoutManager this$0;

        public void calculateCachedEnd() {
            ArrayList<View> r100 = this.mViews;
            View r101 = (View) ListProtector.get(r100, r100.size() - 1);
            LayoutParams r102 = getLayoutParams(r101);
            this.mCachedEnd = this.this$0.mPrimaryOrientation.getDecoratedEnd(r101);
            if (r102.mFullSpan == false) goto L10;
            LazySpanLookup.FullSpanItem r103 = this.this$0.mLazySpanLookup.getFullSpanItem(r102.getViewLayoutPosition());
            if (r103 != null) goto L7;
            return;
        L7:
            if (r103.mGapDir != 1) goto L12;
            this.mCachedEnd += r103.getGapForSpan(this.mIndex);
            return;
        L12:
            return;
        }

        public void calculateCachedStart() {
            View r100 = (View) ListProtector.get(this.mViews, 0);
            LayoutParams r101 = getLayoutParams(r100);
            this.mCachedStart = this.this$0.mPrimaryOrientation.getDecoratedStart(r100);
            if (r101.mFullSpan == false) goto L10;
            LazySpanLookup.FullSpanItem r102 = this.this$0.mLazySpanLookup.getFullSpanItem(r101.getViewLayoutPosition());
            if (r102 != null) goto L7;
            return;
        L7:
            if (r102.mGapDir != (-1)) goto L12;
            this.mCachedStart -= r102.getGapForSpan(this.mIndex);
            return;
        L12:
            return;
        }

        public void clear() {
            this.mViews.clear();
            invalidateCache();
            this.mDeletedSize = 0;
        }

        public int findFirstCompletelyVisibleItemPosition() {
            if (this.this$0.mReverseLayout == false) goto L6;
            return findOneVisibleChild(this.mViews.size() - 1, -1, true);
        L6:
            return findOneVisibleChild(0, this.mViews.size(), true);
        }

        public int findFirstPartiallyVisibleItemPosition() {
            if (this.this$0.mReverseLayout == false) goto L6;
            return findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true);
        L6:
            return findOnePartiallyVisibleChild(0, this.mViews.size(), true);
        }

        public int findFirstVisibleItemPosition() {
            if (this.this$0.mReverseLayout == false) goto L6;
            return findOneVisibleChild(this.mViews.size() - 1, -1, false);
        L6:
            return findOneVisibleChild(0, this.mViews.size(), false);
        }

        public int findLastCompletelyVisibleItemPosition() {
            if (this.this$0.mReverseLayout == false) goto L6;
            return findOneVisibleChild(0, this.mViews.size(), true);
        L6:
            return findOneVisibleChild(this.mViews.size() - 1, -1, true);
        }

        public int findLastPartiallyVisibleItemPosition() {
            if (this.this$0.mReverseLayout == false) goto L6;
            return findOnePartiallyVisibleChild(0, this.mViews.size(), true);
        L6:
            return findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true);
        }

        public int findLastVisibleItemPosition() {
            if (this.this$0.mReverseLayout == false) goto L6;
            return findOneVisibleChild(0, this.mViews.size(), false);
        L6:
            return findOneVisibleChild(this.mViews.size() - 1, -1, false);
        }

        public int getEndLine() {
            int r100 = this.mCachedEnd;
            if (r100 == Integer.MIN_VALUE) goto L5;
            return r100;
        L5:
            calculateCachedEnd();
            return this.mCachedEnd;
        }

        public int getStartLine() {
            int r100 = this.mCachedStart;
            if (r100 == Integer.MIN_VALUE) goto L5;
            return r100;
        L5:
            calculateCachedStart();
            return this.mCachedStart;
        }

        public void invalidateCache() {
            this.mCachedStart = Integer.MIN_VALUE;
            this.mCachedEnd = Integer.MIN_VALUE;
        }

        public void popEnd() {
            int r100 = this.mViews.size();
            View r101 = (View) ListProtector.remove(this.mViews, r100 - 1);
            LayoutParams r102 = getLayoutParams(r101);
            r102.mSpan = null;
            if (r102.isItemRemoved() == false) goto L5;
        L6:
            this.mDeletedSize -= this.this$0.mPrimaryOrientation.getDecoratedMeasurement(r101);
        L8:
            if (r100 != 1) goto L10;
            this.mCachedStart = Integer.MIN_VALUE;
        L10:
            this.mCachedEnd = Integer.MIN_VALUE;
            return;
        L5:
            if (r102.isItemChanged() == false) goto L8;
            goto L6
        }

        public void popStart() {
            View r100 = (View) ListProtector.remove(this.mViews, 0);
            LayoutParams r101 = getLayoutParams(r100);
            r101.mSpan = null;
            if (this.mViews.size() != 0) goto L6;
            this.mCachedEnd = Integer.MIN_VALUE;
        L6:
            if (r101.isItemRemoved() == false) goto L8;
        L9:
            this.mDeletedSize -= this.this$0.mPrimaryOrientation.getDecoratedMeasurement(r100);
        L10:
            this.mCachedStart = Integer.MIN_VALUE;
            return;
        L8:
            if (r101.isItemChanged() == false) goto L10;
            goto L9
        }

        public int getDeletedSize() {
            return this.mDeletedSize;
        }

        public void appendToSpan(View r100) {
            LayoutParams r101 = getLayoutParams(r100);
            r101.mSpan = this;
            this.mViews.add(r100);
            this.mCachedEnd = Integer.MIN_VALUE;
            if (this.mViews.size() != 1) goto L6;
            this.mCachedStart = Integer.MIN_VALUE;
        L6:
            if (r101.isItemRemoved() == false) goto L8;
        L9:
            this.mDeletedSize += this.this$0.mPrimaryOrientation.getDecoratedMeasurement(r100);
            return;
        L8:
            if (r101.isItemChanged() == true) goto L9;
        }

        public int getEndLine(int r100) {
            int r101 = this.mCachedEnd;
            if (r101 == Integer.MIN_VALUE) goto L6;
            return r101;
        L6:
            if (this.mViews.size() != 0) goto L8;
            return r100;
        L8:
            calculateCachedEnd();
            return this.mCachedEnd;
        }

        public LayoutParams getLayoutParams(View r100) {
            return (LayoutParams) r100.getLayoutParams();
        }

        public int getStartLine(int r100) {
            int r101 = this.mCachedStart;
            if (r101 == Integer.MIN_VALUE) goto L6;
            return r101;
        L6:
            if (this.mViews.size() != 0) goto L8;
            return r100;
        L8:
            calculateCachedStart();
            return this.mCachedStart;
        }

        public void onOffset(int r100) {
            int r101 = this.mCachedStart;
            if (r101 == Integer.MIN_VALUE) goto L5;
            this.mCachedStart = r101 + r100;
        L5:
            int r102 = this.mCachedEnd;
            if (r102 == Integer.MIN_VALUE) goto L9;
            this.mCachedEnd = r102 + r100;
            return;
        }

        public void prependToSpan(View r100) {
            LayoutParams r101 = getLayoutParams(r100);
            r101.mSpan = this;
            ListProtector.add(this.mViews, 0, r100);
            this.mCachedStart = Integer.MIN_VALUE;
            if (this.mViews.size() != 1) goto L6;
            this.mCachedEnd = Integer.MIN_VALUE;
        L6:
            if (r101.isItemRemoved() == false) goto L8;
        L9:
            this.mDeletedSize += this.this$0.mPrimaryOrientation.getDecoratedMeasurement(r100);
            return;
        L8:
            if (r101.isItemChanged() == true) goto L9;
        }

        public void setLine(int r100) {
            this.mCachedStart = r100;
            this.mCachedEnd = r100;
        }

        public Span(StaggeredGridLayoutManager r100, int r101) {
            this.this$0 = r100;
            this.mViews = new ArrayList();
            this.mCachedStart = Integer.MIN_VALUE;
            this.mCachedEnd = Integer.MIN_VALUE;
            this.mDeletedSize = 0;
            this.mIndex = r101;
        }

        public void cacheReferenceLineAndClear(boolean r100, int r101) {
            if (r100 == false) goto L5;
            int r102 = getEndLine(Integer.MIN_VALUE);
        L6:
            clear();
            if (r102 != Integer.MIN_VALUE) goto L9;
            return;
        L9:
            if (r100 == true) goto L11;
        L12:
            if (r100 == false) goto L14;
        L16:
            if (r101 == Integer.MIN_VALUE) goto L18;
            r102 = r102 + r101;
        L18:
            this.mCachedEnd = r102;
            this.mCachedStart = r102;
            return;
        L14:
            if (r102 <= this.this$0.mPrimaryOrientation.getStartAfterPadding()) goto L16;
            return;
        L11:
            if (r102 >= this.this$0.mPrimaryOrientation.getEndAfterPadding()) goto L12;
            return;
        L5:
            r102 = getStartLine(Integer.MIN_VALUE);
            goto L6
        }

        public View getFocusableViewAfter(int r100, int r101) {
            View r102 = null;
            if (r101 != (-1)) goto L18;
            int r103 = this.mViews.size();
            int r104 = 0;
        L5:
            if (r104 >= r103) goto L32;
            View r105 = (View) ListProtector.get(this.mViews, r104);
            StaggeredGridLayoutManager r106 = this.this$0;
            if (r106.mReverseLayout == true) goto L9;
        L10:
            StaggeredGridLayoutManager r107 = this.this$0;
            if (r107.mReverseLayout == true) goto L16;
            if (r107.getPosition(r105) >= r100) goto L32;
        L16:
            if (r105.hasFocusable() == false) goto L32;
            r104 = r104 + 1;
            r102 = r105;
            goto L5
        L9:
            if (r106.getPosition(r105) > r100) goto L10;
        L32:
            return r102;
        L18:
            int r108 = this.mViews.size() - 1;
        L19:
            if (r108 < 0) goto L32;
            View r109 = (View) ListProtector.get(this.mViews, r108);
            StaggeredGridLayoutManager r110 = this.this$0;
            if (r110.mReverseLayout == true) goto L23;
        L24:
            StaggeredGridLayoutManager r111 = this.this$0;
            if (r111.mReverseLayout == true) goto L30;
            if (r111.getPosition(r109) <= r100) goto L32;
        L30:
            if (r109.hasFocusable() == false) goto L32;
            r108 = r108 - 1;
            r102 = r109;
            goto L19
        L23:
            if (r110.getPosition(r109) >= r100) goto L32;
            goto L24
        }

        public int findOnePartiallyVisibleChild(int r100, int r101, boolean r102) {
            return findOnePartiallyOrCompletelyVisibleChild(r100, r101, false, false, r102);
        }

        public int findOneVisibleChild(int r100, int r101, boolean r102) {
            return findOnePartiallyOrCompletelyVisibleChild(r100, r101, r102, true, false);
        }

        public int findOnePartiallyOrCompletelyVisibleChild(int r110, int r111, boolean r112, boolean r113, boolean r114) {
            int r100 = this.this$0.mPrimaryOrientation.getStartAfterPadding();
            int r101 = this.this$0.mPrimaryOrientation.getEndAfterPadding();
            if (r111 <= r110) goto L5;
            int r102 = 1;
        L6:
            if (r110 == r111) goto L35;
            View r103 = (View) ListProtector.get(this.mViews, r110);
            int r104 = this.this$0.mPrimaryOrientation.getDecoratedStart(r103);
            int r105 = this.this$0.mPrimaryOrientation.getDecoratedEnd(r103);
            boolean r106 = false;
            if (r114 == false) goto L11;
            if (r104 <= r101) goto L12;
        L13:
            boolean r107 = false;
        L14:
            if (r114 == false) goto L17;
            if (r105 >= r100) goto L18;
        L19:
            if (r107 == false) goto L34;
            if (r106 == false) goto L34;
            if (r112 == false) goto L27;
            if (r113 == false) goto L27;
            if (r104 < r100) goto L34;
            if (r105 > r101) goto L34;
            return this.this$0.getPosition(r103);
        L27:
            if (r113 == true) goto L29;
            if (r104 < r100) goto L33;
            if (r105 <= r101) goto L34;
        L33:
            return this.this$0.getPosition(r103);
        L29:
            return this.this$0.getPosition(r103);
        L34:
            r110 = r110 + r102;
        L18:
            r106 = true;
            goto L19
        L17:
            if (r105 <= r100) goto L19;
        L12:
            r107 = true;
            goto L14
        L11:
            if (r104 >= r101) goto L13;
        L35:
            return -1;
        L5:
            r102 = -1;
            goto L6
        }
    }

    private void createOrientationHelpers() {
        this.mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, this.mOrientation);
        this.mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
    }

    private void repositionToWrapContentIfNecessary() {
        if (this.mSecondaryOrientation.getMode() != 1073741824) goto L5;
        return;
    L5:
        int r100 = getChildCount();
        int r101 = 0;
        float r102 = 0.0f;
        int r103 = 0;
    L6:
        if (r103 >= r100) goto L15;
        View r104 = getChildAt(r103);
        float r105 = this.mSecondaryOrientation.getDecoratedMeasurement(r104);
        if (r105 < r102) goto L14;
        if (((LayoutParams) r104.getLayoutParams()).isFullSpan() == false) goto L13;
        r105 = (r105 * 1.0f) / this.mSpanCount;
    L13:
        r102 = Math.max(r102, r105);
    L14:
        r103 = r103 + 1;
        goto L6
    L15:
        int r106 = this.mSizePerSpan;
        int r107 = Math.round(r102 * this.mSpanCount);
        if (this.mSecondaryOrientation.getMode() != Integer.MIN_VALUE) goto L18;
        r107 = Math.min(r107, this.mSecondaryOrientation.getTotalSpace());
    L18:
        updateMeasureSpecs(r107);
        if (this.mSizePerSpan != r106) goto L21;
        return;
    L21:
        if (r101 >= r100) goto L35;
        View r108 = getChildAt(r101);
        LayoutParams r109 = (LayoutParams) r108.getLayoutParams();
        if (r109.mFullSpan == true) goto L34;
        if (isLayoutRTL() == true) goto L28;
    L30:
        int r110 = r109.mSpan.mIndex;
        int r111 = this.mSizePerSpan * r110;
        int r112 = r110 * r106;
        if (this.mOrientation != 1) goto L33;
        r108.offsetLeftAndRight(r111 - r112);
        goto L34
    L33:
        r108.offsetTopAndBottom(r111 - r112);
        goto L34
    L28:
        if (this.mOrientation != 1) goto L30;
        int r113 = this.mSpanCount;
        int r114 = r109.mSpan.mIndex;
        r108.offsetLeftAndRight(((-((r113 - 1) - r114)) * this.mSizePerSpan) - ((-((r113 - 1) - r114)) * r106));
    L34:
        r101 = r101 + 1;
        goto L21
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

    public boolean areAllEndsEqual() {
        int r100 = this.mSpans[0].getEndLine(Integer.MIN_VALUE);
        int r101 = 1;
    L4:
        if (r101 >= this.mSpanCount) goto L9;
        if (this.mSpans[r101].getEndLine(Integer.MIN_VALUE) != r100) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
    }

    public boolean areAllStartsEqual() {
        int r100 = this.mSpans[0].getStartLine(Integer.MIN_VALUE);
        int r101 = 1;
    L4:
        if (r101 >= this.mSpanCount) goto L9;
        if (this.mSpans[r101].getStartLine(Integer.MIN_VALUE) != r100) goto L7;
        r101 = r101 + 1;
        goto L4
    L7:
        return false;
    L9:
        return true;
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

    public int findFirstVisibleItemPositionInt() {
        if (this.mShouldReverseLayout == false) goto L5;
        View r100 = findFirstVisibleItemClosestToEnd(true);
    L6:
        if (r100 != null) goto L9;
        return -1;
    L9:
        return getPosition(r100);
    L5:
        r100 = findFirstVisibleItemClosestToStart(true);
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        if (this.mOrientation != 0) goto L7;
        return new LayoutParams(-2, -1);
    L7:
        return new LayoutParams(-1, -2);
    }

    public void invalidateSpanAssignments() {
        this.mLazySpanLookup.clear();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean isAutoMeasureEnabled() {
        if (this.mGapStrategy == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) goto L5;
        SavedState r100 = new SavedState();
        r100.mReverseLayout = this.mReverseLayout;
        r100.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
        r100.mLastLayoutRTL = this.mLastLayoutRTL;
        LazySpanLookup r101 = this.mLazySpanLookup;
        int r102 = 0;
        if (r101 == null) goto L11;
        int[] r103 = r101.mData;
        if (r103 == null) goto L11;
        r100.mSpanLookup = r103;
        r100.mSpanLookupSize = r103.length;
        r100.mFullSpanItems = r101.mFullSpanItems;
    L13:
        if (getChildCount() > 0) goto L15;
        r100.mAnchorPosition = -1;
        r100.mVisibleAnchorPosition = -1;
        r100.mSpanOffsetsSize = 0;
    L32:
        return r100;
    L15:
        if (this.mLastLayoutFromEnd == false) goto L17;
        int r104 = getLastChildPosition();
    L18:
        r100.mAnchorPosition = r104;
        r100.mVisibleAnchorPosition = findFirstVisibleItemPositionInt();
        int r105 = this.mSpanCount;
        r100.mSpanOffsetsSize = r105;
        r100.mSpanOffsets = new int[r105];
    L20:
        if (r102 >= this.mSpanCount) goto L32;
        if (this.mLastLayoutFromEnd == false) goto L26;
        int r106 = this.mSpans[r102].getEndLine(Integer.MIN_VALUE);
        if (r106 == Integer.MIN_VALUE) goto L30;
        int r107 = this.mPrimaryOrientation.getEndAfterPadding();
    L29:
        r106 = r106 - r107;
    L30:
        r100.mSpanOffsets[r102] = r106;
        r102 = r102 + 1;
        goto L20
    L26:
        r106 = this.mSpans[r102].getStartLine(Integer.MIN_VALUE);
        if (r106 == Integer.MIN_VALUE) goto L30;
        r107 = this.mPrimaryOrientation.getStartAfterPadding();
        goto L29
    L17:
        r104 = getFirstChildPosition();
    L11:
        r100.mSpanLookupSize = 0;
        goto L13
    L5:
        return new SavedState(this.mPendingSavedState);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        if (this.mPendingSavedState != null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean checkForGaps() {
        if (getChildCount() != 0) goto L5;
    L36:
        return false;
    L5:
        if (this.mGapStrategy == 0) goto L36;
        if (isAttachedToWindow() == false) goto L36;
        if (this.mShouldReverseLayout == false) goto L12;
        int r100 = getLastChildPosition();
        int r101 = getFirstChildPosition();
    L14:
        if (r100 != 0) goto L20;
        if (hasGapsToFix() == null) goto L20;
        this.mLazySpanLookup.clear();
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    L20:
        if (this.mLaidOutInvalidFullSpan == true) goto L23;
        return false;
    L23:
        if (this.mShouldReverseLayout == false) goto L25;
        int r102 = -1;
    L26:
        int r103 = r101 + 1;
        LazySpanLookup.FullSpanItem r104 = this.mLazySpanLookup.getFirstFullSpanItemInRange(r100, r103, r102, true);
        if (r104 != null) goto L30;
        this.mLaidOutInvalidFullSpan = false;
        this.mLazySpanLookup.forceInvalidateAfter(r103);
        return false;
    L30:
        LazySpanLookup.FullSpanItem r105 = this.mLazySpanLookup.getFirstFullSpanItemInRange(r100, r104.mPosition, r102 * (-1), true);
        if (r105 != null) goto L33;
        this.mLazySpanLookup.forceInvalidateAfter(r104.mPosition);
    L34:
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    L33:
        this.mLazySpanLookup.forceInvalidateAfter(r105.mPosition + 1);
        goto L34
    L25:
        r102 = 1;
        goto L26
    L12:
        r100 = getFirstChildPosition();
        r101 = getLastChildPosition();
        goto L14
    }

    public int getFirstChildPosition() {
        if (getChildCount() != 0) goto L6;
        return 0;
    L6:
        return getPosition(getChildAt(0));
    }

    public int getLastChildPosition() {
        int r100 = getChildCount();
        if (r100 != 0) goto L6;
        return 0;
    L6:
        return getPosition(getChildAt(r100 - 1));
    }

    public View hasGapsToFix() {
        int r100 = getChildCount() - 1;
        BitSet r101 = new BitSet(this.mSpanCount);
        r101.set(0, this.mSpanCount, true);
        int r102 = -1;
        if (this.mOrientation == 1) goto L5;
    L7:
        byte r103 = -1;
    L9:
        if (this.mShouldReverseLayout == false) goto L11;
        int r104 = -1;
    L12:
        if (r100 >= r104) goto L14;
        r102 = 1;
    L14:
        if (r100 == r104) goto L50;
        View r105 = getChildAt(r100);
        LayoutParams r106 = (LayoutParams) r105.getLayoutParams();
        if (r101.get(r106.mSpan.mIndex) == false) goto L22;
        if (checkSpanForGap(r106.mSpan) == true) goto L19;
        r101.clear(r106.mSpan.mIndex);
        goto L22
    L19:
        return r105;
    L22:
        if (r106.mFullSpan == true) goto L49;
        int r107 = r100 + r102;
        if (r107 == r104) goto L49;
        View r108 = getChildAt(r107);
        if (this.mShouldReverseLayout == false) goto L33;
        int r110 = this.mPrimaryOrientation.getDecoratedEnd(r105);
        int r111 = this.mPrimaryOrientation.getDecoratedEnd(r108);
        if (r110 < r111) goto L30;
        if (r110 == r111) goto L37;
    L38:
        boolean r112 = false;
    L39:
        if (r112 == false) goto L49;
        LayoutParams r109 = (LayoutParams) r108.getLayoutParams();
        if ((r106.mSpan.mIndex - r109.mSpan.mIndex) >= 0) goto L43;
        boolean r113 = true;
    L44:
        if (r103 >= 0) goto L46;
        boolean r114 = true;
    L47:
        if (r113 == r114) goto L49;
        return r105;
    L46:
        r114 = false;
        goto L47
    L43:
        r113 = false;
    L37:
        r112 = true;
        goto L39
    L30:
        return r105;
    L33:
        int r115 = this.mPrimaryOrientation.getDecoratedStart(r105);
        int r116 = this.mPrimaryOrientation.getDecoratedStart(r108);
        if (r115 > r116) goto L35;
        if (r115 != r116) goto L38;
    L35:
        return r105;
    L49:
        r100 = r100 + r102;
        goto L14
    L50:
        return null;
    L11:
        r104 = r100 + 1;
        r100 = 0;
        goto L12
    L5:
        if (isLayoutRTL() == false) goto L7;
        r103 = 1;
        goto L9
    }

    public boolean isLayoutRTL() {
        if (getLayoutDirection() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public int getGapStrategy() {
        return this.mGapStrategy;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    private void appendViewToAllSpans(View r100) {
        int r101 = this.mSpanCount - 1;
    L3:
        if (r101 < 0) goto L5;
        this.mSpans[r101].appendToSpan(r100);
        r101 = r101 - 1;
        goto L3
    }

    private void applyPendingSavedState(AnchorInfo r100) {
        SavedState r101 = this.mPendingSavedState;
        int r102 = r101.mSpanOffsetsSize;
        if (r102 > 0) goto L5;
    L18:
        SavedState r103 = this.mPendingSavedState;
        this.mLastLayoutRTL = r103.mLastLayoutRTL;
        setReverseLayout(r103.mReverseLayout);
        resolveShouldLayoutReverse();
        SavedState r104 = this.mPendingSavedState;
        int r105 = r104.mAnchorPosition;
        if (r105 == (-1)) goto L21;
        this.mPendingScrollPosition = r105;
        r100.mLayoutFromEnd = r104.mAnchorLayoutFromEnd;
    L23:
        if (r104.mSpanLookupSize <= 1) goto L29;
        LazySpanLookup r106 = this.mLazySpanLookup;
        r106.mData = r104.mSpanLookup;
        r106.mFullSpanItems = r104.mFullSpanItems;
        return;
    L29:
        return;
    L21:
        r100.mLayoutFromEnd = this.mShouldReverseLayout;
        goto L23
    L5:
        if (r102 != this.mSpanCount) goto L17;
        int r107 = 0;
    L8:
        if (r107 >= this.mSpanCount) goto L18;
        this.mSpans[r107].clear();
        SavedState r108 = this.mPendingSavedState;
        int r109 = r108.mSpanOffsets[r107];
        if (r109 == Integer.MIN_VALUE) goto L16;
        if (r108.mAnchorLayoutFromEnd == false) goto L14;
        int r110 = this.mPrimaryOrientation.getEndAfterPadding();
    L15:
        r109 = r109 + r110;
        goto L16
    L14:
        r110 = this.mPrimaryOrientation.getStartAfterPadding();
    L16:
        this.mSpans[r107].setLine(r109);
        r107 = r107 + 1;
        goto L8
    L17:
        r101.invalidateSpanInfo();
        SavedState r111 = this.mPendingSavedState;
        r111.mAnchorPosition = r111.mVisibleAnchorPosition;
        goto L18
    }

    private int calculateScrollDirectionForPosition(int r100) {
        if (getChildCount() != 0) goto L9;
        if (this.mShouldReverseLayout == false) goto L17;
        return 1;
    L17:
        return -1;
    L9:
        if (r100 >= getFirstChildPosition()) goto L11;
        boolean r101 = true;
    L13:
        if (r101 != this.mShouldReverseLayout) goto L18;
        return 1;
    L18:
        return -1;
    L11:
        r101 = false;
        goto L13
    }

    private boolean checkSpanForGap(Span r100) {
        if (this.mShouldReverseLayout == false) goto L9;
        if (r100.getEndLine() >= this.mPrimaryOrientation.getEndAfterPadding()) goto L12;
        ArrayList<View> r101 = r100.mViews;
        return !r100.getLayoutParams((View) ListProtector.get(r101, r101.size() - 1)).mFullSpan;
    L12:
        return false;
    L9:
        if (r100.getStartLine() <= this.mPrimaryOrientation.getStartAfterPadding()) goto L12;
        return !r100.getLayoutParams((View) ListProtector.get(r100.mViews, 0)).mFullSpan;
    }

    private int computeScrollExtent(RecyclerView.State r100) {
        if (getChildCount() != 0) goto L7;
        return 0;
    L7:
        return ScrollbarHelper.computeScrollExtent(r100, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.State r100) {
        if (getChildCount() != 0) goto L7;
        return 0;
    L7:
        return ScrollbarHelper.computeScrollOffset(r100, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.State r100) {
        if (getChildCount() != 0) goto L7;
        return 0;
    L7:
        return ScrollbarHelper.computeScrollRange(r100, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
    }

    private int convertFocusDirectionToLayoutDirection(int r100) {
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

    private LazySpanLookup.FullSpanItem createFullSpanItemFromEnd(int r100) {
        LazySpanLookup.FullSpanItem r101 = new LazySpanLookup.FullSpanItem();
        r101.mGapPerSpan = new int[this.mSpanCount];
        int r102 = 0;
    L4:
        if (r102 >= this.mSpanCount) goto L6;
        r101.mGapPerSpan[r102] = r100 - this.mSpans[r102].getEndLine(r100);
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    private LazySpanLookup.FullSpanItem createFullSpanItemFromStart(int r100) {
        LazySpanLookup.FullSpanItem r101 = new LazySpanLookup.FullSpanItem();
        r101.mGapPerSpan = new int[this.mSpanCount];
        int r102 = 0;
    L4:
        if (r102 >= this.mSpanCount) goto L6;
        r101.mGapPerSpan[r102] = this.mSpans[r102].getStartLine(r100) - r100;
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    private int findFirstReferenceChildPosition(int r100) {
        int r101 = getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        int r103 = getPosition(getChildAt(r102));
        if (r103 < 0) goto L8;
        if (r103 >= r100) goto L8;
        return r103;
    L8:
        r102 = r102 + 1;
        goto L3
    L9:
        return 0;
    }

    private int findLastReferenceChildPosition(int r100) {
        int r101 = getChildCount() - 1;
    L3:
        if (r101 < 0) goto L9;
        int r102 = getPosition(getChildAt(r101));
        if (r102 < 0) goto L8;
        if (r102 >= r100) goto L8;
        return r102;
    L8:
        r101 = r101 - 1;
        goto L3
    L9:
        return 0;
    }

    private int getMaxEnd(int r100) {
        int r101 = this.mSpans[0].getEndLine(r100);
        int r102 = 1;
    L4:
        if (r102 >= this.mSpanCount) goto L9;
        int r103 = this.mSpans[r102].getEndLine(r100);
        if (r103 <= r101) goto L8;
        r101 = r103;
    L8:
        r102 = r102 + 1;
        goto L4
    L9:
        return r101;
    }

    private int getMaxStart(int r100) {
        int r101 = this.mSpans[0].getStartLine(r100);
        int r102 = 1;
    L4:
        if (r102 >= this.mSpanCount) goto L9;
        int r103 = this.mSpans[r102].getStartLine(r100);
        if (r103 <= r101) goto L8;
        r101 = r103;
    L8:
        r102 = r102 + 1;
        goto L4
    L9:
        return r101;
    }

    private int getMinEnd(int r100) {
        int r101 = this.mSpans[0].getEndLine(r100);
        int r102 = 1;
    L4:
        if (r102 >= this.mSpanCount) goto L9;
        int r103 = this.mSpans[r102].getEndLine(r100);
        if (r103 >= r101) goto L8;
        r101 = r103;
    L8:
        r102 = r102 + 1;
        goto L4
    L9:
        return r101;
    }

    private int getMinStart(int r100) {
        int r101 = this.mSpans[0].getStartLine(r100);
        int r102 = 1;
    L4:
        if (r102 >= this.mSpanCount) goto L9;
        int r103 = this.mSpans[r102].getStartLine(r100);
        if (r103 >= r101) goto L8;
        r101 = r103;
    L8:
        r102 = r102 + 1;
        goto L4
    L9:
        return r101;
    }

    private Span getNextSpan(LayoutState r100) {
        if (preferLastSpan(r100.mLayoutDirection) == false) goto L5;
        int r101 = this.mSpanCount - 1;
        int r102 = -1;
        int r103 = -1;
    L6:
        Span r104 = null;
        if (r100.mLayoutDirection != 1) goto L15;
        int r105 = this.mPrimaryOrientation.getStartAfterPadding();
        int r106 = Integer.MAX_VALUE;
    L9:
        if (r101 == r102) goto L14;
        Span r107 = this.mSpans[r101];
        int r108 = r107.getEndLine(r105);
        if (r108 >= r106) goto L13;
        r104 = r107;
        r106 = r108;
    L13:
        r101 = r101 + r103;
        goto L9
    L14:
        return r104;
    L15:
        int r109 = this.mPrimaryOrientation.getEndAfterPadding();
        int r110 = Integer.MIN_VALUE;
    L16:
        if (r101 == r102) goto L21;
        Span r111 = this.mSpans[r101];
        int r112 = r111.getStartLine(r109);
        if (r112 <= r110) goto L20;
        r104 = r111;
        r110 = r112;
    L20:
        r101 = r101 + r103;
        goto L16
    L21:
        return r104;
    L5:
        r102 = this.mSpanCount;
        r101 = 0;
        r103 = 1;
        goto L6
    }

    private boolean preferLastSpan(int r100) {
        if (this.mOrientation != 0) goto L12;
        if (r100 != (-1)) goto L6;
        boolean r101 = true;
    L8:
        if (r101 != this.mShouldReverseLayout) goto L24;
        return false;
    L24:
        return true;
    L6:
        r101 = false;
        goto L8
    L12:
        if (r100 != (-1)) goto L14;
        boolean r102 = true;
    L16:
        if (r102 != this.mShouldReverseLayout) goto L18;
        boolean r103 = true;
    L20:
        if (r103 == isLayoutRTL()) goto L25;
        return false;
    L25:
        return true;
    L18:
        r103 = false;
        goto L20
    L14:
        r102 = false;
        goto L16
    }

    private void prependViewToAllSpans(View r100) {
        int r101 = this.mSpanCount - 1;
    L3:
        if (r101 < 0) goto L5;
        this.mSpans[r101].prependToSpan(r100);
        r101 = r101 - 1;
        goto L3
    }

    private void setLayoutStateDirection(int r100) {
        LayoutState r101 = this.mLayoutState;
        r101.mLayoutDirection = r100;
        boolean r102 = this.mShouldReverseLayout;
        int r103 = 1;
        if (r100 != (-1)) goto L5;
        boolean r104 = true;
    L6:
        if (r102 == r104) goto L9;
        r103 = -1;
    L9:
        r101.mItemDirection = r103;
        return;
    L5:
        r104 = false;
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String r100) {
        if (this.mPendingSavedState != null) goto L6;
        super.assertNotInLayoutOrScroll(r100);
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams r100) {
        return r100 instanceof LayoutParams;
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
        int r101 = calculateScrollDirectionForPosition(r100);
        PointF r102 = new PointF();
        if (r101 != 0) goto L7;
        return null;
    L7:
        if (this.mOrientation != 0) goto L9;
        r102.x = r101;
        r102.y = 0.0f;
    L10:
        return r102;
    L9:
        r102.x = 0.0f;
        r102.y = r101;
        goto L10
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

    public int[] findFirstCompletelyVisibleItemPositions(int[] r100) {
        if (r100 != null) goto L5;
        r100 = new int[this.mSpanCount];
    L6:
        int r101 = 0;
    L8:
        if (r101 >= this.mSpanCount) goto L10;
        r100[r101] = this.mSpans[r101].findFirstCompletelyVisibleItemPosition();
        r101 = r101 + 1;
        goto L8
    L10:
        return r100;
    L5:
        if (r100.length >= this.mSpanCount) goto L6;
        throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + r100.length);
    }

    public View findFirstVisibleItemClosestToEnd(boolean r100) {
        int r101 = this.mPrimaryOrientation.getStartAfterPadding();
        int r102 = this.mPrimaryOrientation.getEndAfterPadding();
        int r103 = getChildCount() - 1;
        View r104 = null;
    L3:
        if (r103 < 0) goto L15;
        View r105 = getChildAt(r103);
        int r106 = this.mPrimaryOrientation.getDecoratedStart(r105);
        int r107 = this.mPrimaryOrientation.getDecoratedEnd(r105);
        if (r107 <= r101) goto L14;
        if (r106 >= r102) goto L14;
        if (r107 <= r102) goto L13;
        if (r100 == false) goto L13;
        if (r104 != null) goto L14;
        r104 = r105;
    L13:
        return r105;
    L14:
        r103 = r103 - 1;
        goto L3
    L15:
        return r104;
    }

    public View findFirstVisibleItemClosestToStart(boolean r100) {
        int r101 = this.mPrimaryOrientation.getStartAfterPadding();
        int r102 = this.mPrimaryOrientation.getEndAfterPadding();
        int r103 = getChildCount();
        View r104 = null;
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L15;
        View r106 = getChildAt(r105);
        int r107 = this.mPrimaryOrientation.getDecoratedStart(r106);
        if (this.mPrimaryOrientation.getDecoratedEnd(r106) <= r101) goto L14;
        if (r107 >= r102) goto L14;
        if (r107 >= r101) goto L13;
        if (r100 == false) goto L13;
        if (r104 != null) goto L14;
        r104 = r106;
    L13:
        return r106;
    L14:
        r105 = r105 + 1;
        goto L3
    L15:
        return r104;
    }

    public int[] findFirstVisibleItemPositions(int[] r100) {
        if (r100 != null) goto L5;
        r100 = new int[this.mSpanCount];
    L6:
        int r101 = 0;
    L8:
        if (r101 >= this.mSpanCount) goto L10;
        r100[r101] = this.mSpans[r101].findFirstVisibleItemPosition();
        r101 = r101 + 1;
        goto L8
    L10:
        return r100;
    L5:
        if (r100.length >= this.mSpanCount) goto L6;
        throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + r100.length);
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] r100) {
        if (r100 != null) goto L5;
        r100 = new int[this.mSpanCount];
    L6:
        int r101 = 0;
    L8:
        if (r101 >= this.mSpanCount) goto L10;
        r100[r101] = this.mSpans[r101].findLastCompletelyVisibleItemPosition();
        r101 = r101 + 1;
        goto L8
    L10:
        return r100;
    L5:
        if (r100.length >= this.mSpanCount) goto L6;
        throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + r100.length);
    }

    public int[] findLastVisibleItemPositions(int[] r100) {
        if (r100 != null) goto L5;
        r100 = new int[this.mSpanCount];
    L6:
        int r101 = 0;
    L8:
        if (r101 >= this.mSpanCount) goto L10;
        r100[r101] = this.mSpans[r101].findLastVisibleItemPosition();
        r101 = r101 + 1;
        goto L8
    L10:
        return r100;
    L5:
        if (r100.length >= this.mSpanCount) goto L6;
        throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.mSpanCount + ", array size:" + r100.length);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r100) {
        if ((r100 instanceof ViewGroup.MarginLayoutParams) == false) goto L7;
        return new LayoutParams((ViewGroup.MarginLayoutParams) r100);
    L7:
        return new LayoutParams(r100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenHorizontal(int r100) {
        super.offsetChildrenHorizontal(r100);
        int r101 = 0;
    L4:
        if (r101 >= this.mSpanCount) goto L6;
        this.mSpans[r101].onOffset(r100);
        r101 = r101 + 1;
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenVertical(int r100) {
        super.offsetChildrenVertical(r100);
        int r101 = 0;
    L4:
        if (r101 >= this.mSpanCount) goto L6;
        this.mSpans[r101].onOffset(r100);
        r101 = r101 + 1;
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent r100) {
        super.onInitializeAccessibilityEvent(r100);
        if (getChildCount() <= 0) goto L13;
        View r101 = findFirstVisibleItemClosestToStart(false);
        View r102 = findFirstVisibleItemClosestToEnd(false);
        if (r101 == null) goto L14;
        if (r102 == null) goto L16;
        int r103 = getPosition(r101);
        int r104 = getPosition(r102);
        if (r103 >= r104) goto L11;
        r100.setFromIndex(r103);
        r100.setToIndex(r104);
        return;
    L11:
        r100.setFromIndex(r104);
        r100.setToIndex(r103);
        return;
    L16:
        return;
    L14:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView r100) {
        this.mLazySpanLookup.clear();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State r100) {
        super.onLayoutCompleted(r100);
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo.reset();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable r100) {
        if ((r100 instanceof SavedState) == false) goto L9;
        SavedState r101 = (SavedState) r100;
        this.mPendingSavedState = r101;
        if (this.mPendingScrollPosition == (-1)) goto L7;
        r101.invalidateAnchorPositionInfo();
        this.mPendingSavedState.invalidateSpanInfo();
    L7:
        requestLayout();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int r100) {
        if (r100 != 0) goto L5;
        checkForGaps();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int r100) {
        SavedState r101 = this.mPendingSavedState;
        if (r101 != null) goto L5;
    L7:
        this.mPendingScrollPosition = r100;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        requestLayout();
        return;
    L5:
        if (r101.mAnchorPosition == r100) goto L7;
        r101.invalidateAnchorPositionInfo();
        goto L7
    }

    public void setGapStrategy(int r100) {
        assertNotInLayoutOrScroll(null);
        if (r100 != this.mGapStrategy) goto L5;
        return;
    L5:
        if (r100 != 0) goto L7;
    L11:
        this.mGapStrategy = r100;
        requestLayout();
        return;
    L7:
        if (r100 == 2) goto L11;
        throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
    }

    public void setOrientation(int r100) {
        if (r100 != 0) goto L4;
    L8:
        assertNotInLayoutOrScroll(null);
        if (r100 != this.mOrientation) goto L11;
        return;
    L11:
        this.mOrientation = r100;
        OrientationHelper r101 = this.mPrimaryOrientation;
        this.mPrimaryOrientation = this.mSecondaryOrientation;
        this.mSecondaryOrientation = r101;
        requestLayout();
        return;
    L4:
        if (r100 == 1) goto L8;
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void setReverseLayout(boolean r100) {
        assertNotInLayoutOrScroll(null);
        SavedState r101 = this.mPendingSavedState;
        if (r101 != null) goto L5;
    L7:
        this.mReverseLayout = r100;
        requestLayout();
        return;
    L5:
        if (r101.mReverseLayout == r100) goto L7;
        r101.mReverseLayout = r100;
        goto L7
    }

    public void setSpanCount(int r100) {
        assertNotInLayoutOrScroll(null);
        if (r100 == this.mSpanCount) goto L11;
        invalidateSpanAssignments();
        this.mSpanCount = r100;
        this.mRemainingSpans = new BitSet(this.mSpanCount);
        this.mSpans = new Span[this.mSpanCount];
        int r101 = 0;
    L6:
        if (r101 >= this.mSpanCount) goto L8;
        this.mSpans[r101] = new Span(this, r101);
        r101 = r101 + 1;
        goto L6
    L8:
        requestLayout();
        return;
    }

    public void updateMeasureSpecs(int r100) {
        this.mSizePerSpan = r100 / this.mSpanCount;
        this.mFullSizeSpec = View.MeasureSpec.makeMeasureSpec(r100, this.mSecondaryOrientation.getMode());
    }

    public StaggeredGridLayoutManager(int r100, int r101) {
        this.mSpanCount = -1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mLazySpanLookup = new LazySpanLookup();
        this.mGapStrategy = 2;
        this.mTmpRect = new Rect();
        this.mAnchorInfo = new AnchorInfo(this);
        this.mLaidOutInvalidFullSpan = false;
        this.mSmoothScrollbarEnabled = true;
        this.mCheckForGapsRunnable = new AnonymousClass1(this);
        this.mOrientation = r101;
        setSpanCount(r100);
        this.mLayoutState = new LayoutState();
        createOrientationHelpers();
    }

    private void recycle(RecyclerView.Recycler r100, LayoutState r101) {
        if (r101.mRecycle == true) goto L5;
        return;
    L5:
        if (r101.mInfinite == false) goto L8;
        return;
    L8:
        if (r101.mAvailable != 0) goto L14;
        if (r101.mLayoutDirection != (-1)) goto L12;
        recycleFromEnd(r100, r101.mEndLine);
        return;
    L12:
        recycleFromStart(r100, r101.mStartLine);
        return;
    L14:
        if (r101.mLayoutDirection != (-1)) goto L20;
        int r102 = r101.mStartLine;
        int r103 = r102 - getMaxStart(r102);
        if (r103 >= 0) goto L18;
        int r104 = r101.mEndLine;
    L19:
        recycleFromEnd(r100, r104);
        return;
    L18:
        r104 = r101.mEndLine - Math.min(r103, r101.mAvailable);
        goto L19
    L20:
        int r105 = getMinEnd(r101.mEndLine) - r101.mEndLine;
        if (r105 >= 0) goto L23;
        int r106 = r101.mStartLine;
    L24:
        recycleFromStart(r100, r106);
        return;
    L23:
        int r107 = r101.mStartLine;
        r106 = Math.min(r105, r101.mAvailable) + r107;
        goto L24
    }

    private void recycleFromEnd(RecyclerView.Recycler r100, int r101) {
        int r102 = getChildCount() - 1;
    L3:
        if (r102 < 0) goto L25;
        View r103 = getChildAt(r102);
        if (this.mPrimaryOrientation.getDecoratedStart(r103) < r101) goto L34;
        if (this.mPrimaryOrientation.getTransformedStartWithDecoration(r103) < r101) goto L35;
        LayoutParams r104 = (LayoutParams) r103.getLayoutParams();
        if (r104.mFullSpan == false) goto L21;
        int r105 = 0;
        int r106 = 0;
    L12:
        if (r106 >= this.mSpanCount) goto L18;
        if (this.mSpans[r106].mViews.size() == 1) goto L15;
        r106 = r106 + 1;
        goto L12
    L15:
        return;
    L18:
        if (r105 >= this.mSpanCount) goto L24;
        this.mSpans[r105].popEnd();
        r105 = r105 + 1;
    L24:
        removeAndRecycleView(r103, r100);
        r102 = r102 - 1;
        goto L3
    L21:
        if (r104.mSpan.mViews.size() == 1) goto L22;
        r104.mSpan.popEnd();
        goto L24
    L22:
        return;
    L35:
        return;
    L34:
        return;
    }

    private void recycleFromStart(RecyclerView.Recycler r100, int r101) {
    L3:
        if (getChildCount() <= 0) goto L25;
        int r102 = 0;
        View r103 = getChildAt(0);
        if (this.mPrimaryOrientation.getDecoratedEnd(r103) > r101) goto L34;
        if (this.mPrimaryOrientation.getTransformedEndWithDecoration(r103) > r101) goto L35;
        LayoutParams r104 = (LayoutParams) r103.getLayoutParams();
        if (r104.mFullSpan == false) goto L21;
        int r105 = 0;
    L12:
        if (r105 >= this.mSpanCount) goto L18;
        if (this.mSpans[r105].mViews.size() == 1) goto L15;
        r105 = r105 + 1;
        goto L12
    L15:
        return;
    L18:
        if (r102 >= this.mSpanCount) goto L24;
        this.mSpans[r102].popStart();
        r102 = r102 + 1;
    L24:
        removeAndRecycleView(r103, r100);
        goto L3
    L21:
        if (r104.mSpan.mViews.size() == 1) goto L22;
        r104.mSpan.popStart();
        goto L24
    L22:
        return;
    L35:
        return;
    L34:
        return;
    }

    private void updateAllRemainingSpans(int r100, int r101) {
        int r102 = 0;
    L4:
        if (r102 >= this.mSpanCount) goto L10;
        if (this.mSpans[r102].mViews.isEmpty() == true) goto L9;
        updateRemainingSpans(this.mSpans[r102], r100, r101);
    L9:
        r102 = r102 + 1;
        goto L4
    }

    private boolean updateAnchorFromChildren(RecyclerView.State r100, AnchorInfo r101) {
        if (this.mLastLayoutFromEnd == false) goto L5;
        int r102 = findLastReferenceChildPosition(r100.getItemCount());
    L6:
        r101.mPosition = r102;
        r101.mOffset = Integer.MIN_VALUE;
        return true;
    L5:
        r102 = findFirstReferenceChildPosition(r100.getItemCount());
        goto L6
    }

    private void updateLayoutState(int r100, RecyclerView.State r101) {
        LayoutState r102 = this.mLayoutState;
        boolean r103 = false;
        r102.mAvailable = 0;
        r102.mCurrentPosition = r100;
        if (isSmoothScrolling() == false) goto L13;
        int r104 = r101.getTargetScrollPosition();
        if (r104 == (-1)) goto L13;
        boolean r105 = this.mShouldReverseLayout;
        if (r104 >= r100) goto L9;
        boolean r106 = true;
    L10:
        if (r105 != r106) goto L12;
        int r107 = this.mPrimaryOrientation.getTotalSpace();
    L14:
        int r108 = 0;
    L16:
        if (getClipToPadding() == false) goto L18;
        LayoutState r109 = this.mLayoutState;
        r109.mStartLine = this.mPrimaryOrientation.getStartAfterPadding() - r108;
        LayoutState r110 = this.mLayoutState;
        r110.mEndLine = this.mPrimaryOrientation.getEndAfterPadding() + r107;
    L19:
        LayoutState r111 = this.mLayoutState;
        r111.mStopInFocusable = false;
        r111.mRecycle = true;
        if (this.mPrimaryOrientation.getMode() == 0) goto L22;
    L24:
        r111.mInfinite = r103;
        return;
    L22:
        if (this.mPrimaryOrientation.getEnd() != 0) goto L24;
        r103 = true;
        goto L24
    L18:
        LayoutState r112 = this.mLayoutState;
        r112.mEndLine = this.mPrimaryOrientation.getEnd() + r107;
        int r113 = -r108;
        this.mLayoutState.mStartLine = r113;
        goto L19
    L12:
        r108 = this.mPrimaryOrientation.getTotalSpace();
        r107 = 0;
        goto L16
    L9:
        r106 = false;
    L13:
        r107 = 0;
        goto L14
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context r100, AttributeSet r101) {
        return new LayoutParams(r100, r101);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter r100, RecyclerView.Adapter r101) {
        this.mLazySpanLookup.clear();
        int r102 = 0;
    L4:
        if (r102 >= this.mSpanCount) goto L6;
        this.mSpans[r102].clear();
        r102 = r102 + 1;
        goto L4
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView r100, RecyclerView.Recycler r101) {
        super.onDetachedFromWindow(r100, r101);
        removeCallbacks(this.mCheckForGapsRunnable);
        int r102 = 0;
    L4:
        if (r102 >= this.mSpanCount) goto L6;
        this.mSpans[r102].clear();
        r102 = r102 + 1;
        goto L4
    L6:
        r100.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r101) {
        onLayoutChildren(r100, r101, true);
    }

    public void prepareLayoutStateForDelta(int r100, RecyclerView.State r101) {
        if (r100 <= 0) goto L5;
        int r102 = getLastChildPosition();
        int r103 = 1;
    L6:
        this.mLayoutState.mRecycle = true;
        updateLayoutState(r102, r101);
        setLayoutStateDirection(r103);
        LayoutState r104 = this.mLayoutState;
        r104.mCurrentPosition = r102 + r104.mItemDirection;
        r104.mAvailable = Math.abs(r100);
        return;
    L5:
        r102 = getFirstChildPosition();
        r103 = -1;
        goto L6
    }

    public void scrollToPositionWithOffset(int r100, int r101) {
        SavedState r102 = this.mPendingSavedState;
        if (r102 == null) goto L5;
        r102.invalidateAnchorPositionInfo();
    L5:
        this.mPendingScrollPosition = r100;
        this.mPendingScrollPositionOffset = r101;
        requestLayout();
    }

    public boolean updateAnchorFromPendingData(RecyclerView.State r100, AnchorInfo r101) {
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
        SavedState r104 = this.mPendingSavedState;
        if (r104 != null) goto L15;
    L20:
        View r105 = findViewByPosition(this.mPendingScrollPosition);
        if (r105 != null) goto L23;
        int r106 = this.mPendingScrollPosition;
        r101.mPosition = r106;
        int r107 = this.mPendingScrollPositionOffset;
        if (r107 == Integer.MIN_VALUE) goto L53;
        r101.assignCoordinateFromPadding(r107);
    L57:
        r101.mInvalidateOffsets = true;
    L58:
        return true;
    L53:
        if (calculateScrollDirectionForPosition(r106) != 1) goto L55;
        r102 = true;
    L55:
        r101.mLayoutFromEnd = r102;
        r101.assignCoordinateFromPadding();
        goto L57
    L23:
        if (this.mShouldReverseLayout == false) goto L25;
        int r108 = getLastChildPosition();
    L26:
        r101.mPosition = r108;
        if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) goto L34;
        if (r101.mLayoutFromEnd == false) goto L31;
        r101.mOffset = (this.mPrimaryOrientation.getEndAfterPadding() - this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedEnd(r105);
    L32:
        return true;
    L31:
        r101.mOffset = (this.mPrimaryOrientation.getStartAfterPadding() + this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedStart(r105);
        goto L32
    L34:
        if (this.mPrimaryOrientation.getDecoratedMeasurement(r105) > this.mPrimaryOrientation.getTotalSpace()) goto L36;
        int r109 = this.mPrimaryOrientation.getDecoratedStart(r105) - this.mPrimaryOrientation.getStartAfterPadding();
        if (r109 >= 0) goto L45;
        r101.mOffset = -r109;
        return true;
    L45:
        int r110 = this.mPrimaryOrientation.getEndAfterPadding() - this.mPrimaryOrientation.getDecoratedEnd(r105);
        if (r110 >= 0) goto L49;
        r101.mOffset = r110;
        return true;
    L49:
        r101.mOffset = Integer.MIN_VALUE;
        goto L58
    L36:
        if (r101.mLayoutFromEnd == false) goto L38;
        int r111 = this.mPrimaryOrientation.getEndAfterPadding();
    L39:
        r101.mOffset = r111;
        return true;
    L38:
        r111 = this.mPrimaryOrientation.getStartAfterPadding();
        goto L39
    L25:
        r108 = getFirstChildPosition();
        goto L26
    L15:
        if (r104.mAnchorPosition == (-1)) goto L20;
        if (r104.mSpanOffsetsSize < 1) goto L20;
        r101.mOffset = Integer.MIN_VALUE;
        r101.mPosition = this.mPendingScrollPosition;
    L60:
        return false;
    }

    public void updateAnchorInfoForLayout(RecyclerView.State r100, AnchorInfo r101) {
        if (updateAnchorFromPendingData(r100, r101) == false) goto L6;
        return;
    L6:
        if (updateAnchorFromChildren(r100, r101) == false) goto L8;
        return;
    L8:
        r101.assignCoordinateFromPadding();
        r101.mPosition = 0;
    }

    private void attachViewToSpans(View r100, LayoutParams r101, LayoutState r102) {
        if (r102.mLayoutDirection != 1) goto L9;
        if (r101.mFullSpan == false) goto L7;
        appendViewToAllSpans(r100);
        return;
    L7:
        r101.mSpan.appendToSpan(r100);
        return;
    L9:
        if (r101.mFullSpan == false) goto L11;
        prependViewToAllSpans(r100);
        return;
    L11:
        r101.mSpan.prependToSpan(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int fill(RecyclerView.Recycler r110, LayoutState r111, RecyclerView.State r112) {
        ?? r100 = 0;
        this.mRemainingSpans.set(0, this.mSpanCount, true);
        if (this.mLayoutState.mInfinite == false) goto L9;
        if (r111.mLayoutDirection != 1) goto L7;
        int r113 = Integer.MAX_VALUE;
    L13:
        updateAllRemainingSpans(r111.mLayoutDirection, r113);
        if (this.mShouldReverseLayout == false) goto L16;
        int r101 = this.mPrimaryOrientation.getEndAfterPadding();
    L17:
        int r114 = r101;
        boolean r102 = false;
    L19:
        if (r111.hasMore(r112) == false) goto L110;
        if (this.mLayoutState.mInfinite == false) goto L23;
    L24:
        View r115 = r111.next(r110);
        LayoutParams r116 = (LayoutParams) r115.getLayoutParams();
        int r103 = r116.getViewLayoutPosition();
        int r104 = this.mLazySpanLookup.getSpan(r103);
        if (r104 != (-1)) goto L27;
        boolean r105 = true;
    L28:
        if (r105 == true) goto L30;
        Span r106 = this.mSpans[r104];
    L35:
        Span r117 = r106;
        r116.mSpan = r117;
        if (r111.mLayoutDirection != 1) goto L38;
        addView(r115);
    L39:
        measureChildWithDecorationsAndMargin(r115, r116, r100);
        if (r111.mLayoutDirection != 1) goto L52;
        if (r116.mFullSpan == false) goto L44;
        int r107 = getMaxEnd(r114);
    L45:
        int r108 = this.mPrimaryOrientation.getDecoratedMeasurement(r115) + r107;
        if (r105 == true) goto L48;
    L50:
        int r109 = r108;
        int r118 = r107;
    L62:
        if (r116.mFullSpan == true) goto L64;
    L77:
        attachViewToSpans(r115, r116, r111);
        if (isLayoutRTL() == false) goto L87;
        if (this.mOrientation != 1) goto L87;
        if (r116.mFullSpan == false) goto L84;
        int r119 = this.mSecondaryOrientation.getEndAfterPadding();
    L85:
        int r120 = r119;
        int r121 = r119 - this.mSecondaryOrientation.getDecoratedMeasurement(r115);
    L92:
        if (this.mOrientation != 1) goto L94;
        layoutDecoratedWithMargins(r115, r121, r118, r120, r109);
    L96:
        if (r116.mFullSpan == false) goto L98;
        updateAllRemainingSpans(this.mLayoutState.mLayoutDirection, r113);
    L99:
        recycle(r110, this.mLayoutState);
        if (this.mLayoutState.mStopInFocusable == false) goto L108;
        if (r115.hasFocusable() == false) goto L108;
        if (r116.mFullSpan == false) goto L106;
        this.mRemainingSpans.clear();
        goto L108
    L106:
        this.mRemainingSpans.set(r117.mIndex, false);
    L108:
        r102 = true;
        r100 = 0;
        goto L19
    L98:
        updateRemainingSpans(r117, this.mLayoutState.mLayoutDirection, r113);
        goto L99
    L94:
        layoutDecoratedWithMargins(r115, r118, r121, r109, r120);
        goto L96
    L84:
        r119 = this.mSecondaryOrientation.getEndAfterPadding() - (((this.mSpanCount - 1) - r117.mIndex) * this.mSizePerSpan);
    L87:
        if (r116.mFullSpan == false) goto L89;
        int r122 = this.mSecondaryOrientation.getStartAfterPadding();
    L90:
        r121 = r122;
        r120 = this.mSecondaryOrientation.getDecoratedMeasurement(r115) + r122;
        goto L92
    L89:
        r122 = (r117.mIndex * this.mSizePerSpan) + this.mSecondaryOrientation.getStartAfterPadding();
        goto L90
    L64:
        if (r111.mItemDirection != (-1)) goto L77;
        if (r105 == false) goto L68;
        this.mLaidOutInvalidFullSpan = true;
        goto L77
    L68:
        if (r111.mLayoutDirection != 1) goto L70;
        boolean r123 = areAllEndsEqual();
    L72:
        if ((!r123) == false) goto L77;
        LazySpanLookup.FullSpanItem r124 = this.mLazySpanLookup.getFullSpanItem(r103);
        if (r124 == null) goto L76;
        r124.mHasUnwantedGapAfter = true;
    L76:
        this.mLaidOutInvalidFullSpan = true;
        goto L77
    L70:
        r123 = areAllStartsEqual();
        goto L72
    L48:
        if (r116.mFullSpan == false) goto L50;
        LazySpanLookup.FullSpanItem r125 = createFullSpanItemFromEnd(r107);
        r125.mGapDir = -1;
        r125.mPosition = r103;
        this.mLazySpanLookup.addFullSpanItem(r125);
        goto L50
    L44:
        r107 = r117.getEndLine(r114);
        goto L45
    L52:
        if (r116.mFullSpan == false) goto L54;
        int r126 = getMinStart(r114);
    L55:
        r118 = r126 - this.mPrimaryOrientation.getDecoratedMeasurement(r115);
        if (r105 == true) goto L58;
    L60:
        r109 = r126;
        goto L62
    L58:
        if (r116.mFullSpan == false) goto L60;
        LazySpanLookup.FullSpanItem r127 = createFullSpanItemFromStart(r126);
        r127.mGapDir = 1;
        r127.mPosition = r103;
        this.mLazySpanLookup.addFullSpanItem(r127);
        goto L60
    L54:
        r126 = r117.getStartLine(r114);
        goto L55
    L38:
        addView(r115, r100);
        goto L39
    L30:
        if (r116.mFullSpan == false) goto L32;
        r106 = this.mSpans[r100];
    L33:
        this.mLazySpanLookup.setSpan(r103, r106);
        goto L35
    L32:
        r106 = getNextSpan(r111);
        goto L33
    L27:
        r105 = false;
        goto L28
    L23:
        if (this.mRemainingSpans.isEmpty() == false) goto L24;
    L110:
        if (r102 == true) goto L113;
        recycle(r110, this.mLayoutState);
    L113:
        if (this.mLayoutState.mLayoutDirection != (-1)) goto L115;
        int r128 = this.mPrimaryOrientation.getStartAfterPadding() - getMinStart(this.mPrimaryOrientation.getStartAfterPadding());
    L116:
        if (r128 > 0) goto L124;
        return 0;
    L124:
        return Math.min(r111.mAvailable, r128);
    L115:
        r128 = getMaxEnd(this.mPrimaryOrientation.getEndAfterPadding()) - this.mPrimaryOrientation.getEndAfterPadding();
        goto L116
    L16:
        r101 = this.mPrimaryOrientation.getStartAfterPadding();
        goto L17
    L7:
        r113 = Integer.MIN_VALUE;
        goto L13
    L9:
        if (r111.mLayoutDirection != 1) goto L11;
        int r129 = r111.mEndLine + r111.mAvailable;
    L12:
        r113 = r129;
        goto L13
    L11:
        r129 = r111.mStartLine - r111.mAvailable;
        goto L12
    }

    private void fixEndGap(RecyclerView.Recycler r100, RecyclerView.State r101, boolean r102) {
        int r103 = getMaxEnd(Integer.MIN_VALUE);
        if (r103 != Integer.MIN_VALUE) goto L5;
        return;
    L5:
        int r104 = this.mPrimaryOrientation.getEndAfterPadding() - r103;
        if (r104 <= 0) goto L12;
        int r105 = r104 - (-scrollBy(-r104, r100, r101));
        if (r102 == false) goto L13;
        if (r105 <= 0) goto L14;
        this.mPrimaryOrientation.offsetChildren(r105);
        return;
    L14:
        return;
    L13:
        return;
    }

    private void fixStartGap(RecyclerView.Recycler r100, RecyclerView.State r101, boolean r102) {
        int r103 = getMinStart(Integer.MAX_VALUE);
        if (r103 != Integer.MAX_VALUE) goto L5;
        return;
    L5:
        int r104 = r103 - this.mPrimaryOrientation.getStartAfterPadding();
        if (r104 <= 0) goto L12;
        int r105 = r104 - scrollBy(r104, r100, r101);
        if (r102 == false) goto L13;
        if (r105 <= 0) goto L14;
        this.mPrimaryOrientation.offsetChildren(-r105);
        return;
    L14:
        return;
    L13:
        return;
    }

    private void handleUpdate(int r100, int r101, int r102) {
        if (this.mShouldReverseLayout == false) goto L5;
        int r103 = getLastChildPosition();
    L7:
        if (r102 != 8) goto L11;
        if (r100 >= r101) goto L10;
        int r104 = r101 + 1;
    L12:
        int r105 = r100;
    L13:
        this.mLazySpanLookup.invalidateAfter(r105);
        if (r102 != 1) goto L16;
        this.mLazySpanLookup.offsetForAddition(r100, r101);
    L22:
        if (r104 > r103) goto L25;
        return;
    L25:
        if (this.mShouldReverseLayout == false) goto L27;
        int r106 = getFirstChildPosition();
    L28:
        if (r105 > r106) goto L31;
        requestLayout();
        return;
    L31:
        return;
    L27:
        r106 = getLastChildPosition();
        goto L28
    L16:
        if (r102 == 2) goto L20;
        if (r102 != 8) goto L22;
        this.mLazySpanLookup.offsetForRemoval(r100, 1);
        this.mLazySpanLookup.offsetForAddition(r101, 1);
        goto L22
    L20:
        this.mLazySpanLookup.offsetForRemoval(r100, r101);
        goto L22
    L10:
        r104 = r100 + 1;
        r105 = r101;
        goto L13
    L11:
        r104 = r100 + r101;
        goto L12
    L5:
        r103 = getFirstChildPosition();
        goto L7
    }

    private void measureChildWithDecorationsAndMargin(View r100, LayoutParams r101, boolean r102) {
        if (r101.mFullSpan == false) goto L9;
        if (this.mOrientation != 1) goto L7;
        measureChildWithDecorationsAndMargin(r100, this.mFullSizeSpec, RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) r101).height, true), r102);
        return;
    L7:
        measureChildWithDecorationsAndMargin(r100, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) r101).width, true), this.mFullSizeSpec, r102);
        return;
    L9:
        if (this.mOrientation != 1) goto L11;
        measureChildWithDecorationsAndMargin(r100, RecyclerView.LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getWidthMode(), 0, ((ViewGroup.MarginLayoutParams) r101).width, false), RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) r101).height, true), r102);
        return;
    L11:
        measureChildWithDecorationsAndMargin(r100, RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) r101).width, true), RecyclerView.LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getHeightMode(), 0, ((ViewGroup.MarginLayoutParams) r101).height, false), r102);
    }

    private void onLayoutChildren(RecyclerView.Recycler r100, RecyclerView.State r110, boolean r111) {
        AnchorInfo r101 = this.mAnchorInfo;
        if (this.mPendingSavedState != null) goto L7;
        if (this.mPendingScrollPosition != (-1)) goto L7;
    L10:
        boolean r102 = true;
        if (r101.mValid == true) goto L13;
    L18:
        boolean r103 = true;
    L19:
        if (r103 == false) goto L26;
        r101.reset();
        if (this.mPendingSavedState == null) goto L23;
        applyPendingSavedState(r101);
    L24:
        updateAnchorInfoForLayout(r110, r101);
        r101.mValid = true;
        goto L26
    L23:
        resolveShouldLayoutReverse();
        r101.mLayoutFromEnd = this.mShouldReverseLayout;
    L26:
        if (this.mPendingSavedState != null) goto L35;
        if (this.mPendingScrollPosition != (-1)) goto L35;
        if (r101.mLayoutFromEnd == this.mLastLayoutFromEnd) goto L32;
    L33:
        this.mLazySpanLookup.clear();
        r101.mInvalidateOffsets = true;
        goto L35
    L32:
        if (isLayoutRTL() != this.mLastLayoutRTL) goto L33;
    L35:
        if (getChildCount() <= 0) goto L62;
        SavedState r104 = this.mPendingSavedState;
        if (r104 == null) goto L41;
        if (r104.mSpanOffsetsSize >= 1) goto L62;
    L41:
        if (r101.mInvalidateOffsets == false) goto L49;
        int r105 = 0;
    L44:
        if (r105 >= this.mSpanCount) goto L62;
        this.mSpans[r105].clear();
        int r106 = r101.mOffset;
        if (r106 == Integer.MIN_VALUE) goto L48;
        this.mSpans[r105].setLine(r106);
    L48:
        r105 = r105 + 1;
        goto L44
    L49:
        if (r103 == false) goto L51;
    L57:
        int r107 = 0;
    L59:
        if (r107 >= this.mSpanCount) goto L61;
        this.mSpans[r107].cacheReferenceLineAndClear(this.mShouldReverseLayout, r101.mOffset);
        r107 = r107 + 1;
        goto L59
    L61:
        this.mAnchorInfo.saveSpanReferenceLines(this.mSpans);
        goto L62
    L51:
        if (this.mAnchorInfo.mSpanReferenceLines == null) goto L57;
        int r108 = 0;
    L55:
        if (r108 >= this.mSpanCount) goto L62;
        Span r109 = this.mSpans[r108];
        r109.clear();
        r109.setLine(this.mAnchorInfo.mSpanReferenceLines[r108]);
        r108 = r108 + 1;
    L62:
        detachAndScrapAttachedViews(r100);
        this.mLayoutState.mRecycle = false;
        this.mLaidOutInvalidFullSpan = false;
        updateMeasureSpecs(this.mSecondaryOrientation.getTotalSpace());
        updateLayoutState(r101.mPosition, r110);
        if (r101.mLayoutFromEnd == false) goto L65;
        setLayoutStateDirection(-1);
        fill(r100, this.mLayoutState, r110);
        setLayoutStateDirection(1);
        LayoutState r112 = this.mLayoutState;
        r112.mCurrentPosition = r101.mPosition + r112.mItemDirection;
        fill(r100, r112, r110);
    L66:
        repositionToWrapContentIfNecessary();
        if (getChildCount() > 0) goto L69;
    L72:
        if (r111 == true) goto L74;
    L89:
        r102 = false;
    L91:
        if (r110.isPreLayout() == false) goto L93;
        this.mAnchorInfo.reset();
    L93:
        this.mLastLayoutFromEnd = r101.mLayoutFromEnd;
        this.mLastLayoutRTL = isLayoutRTL();
        if (r102 == false) goto L102;
        this.mAnchorInfo.reset();
        onLayoutChildren(r100, r110, false);
        return;
    L102:
        return;
    L74:
        if (r110.isPreLayout() == true) goto L89;
        if (this.mGapStrategy != 0) goto L78;
    L84:
        boolean r113 = false;
    L85:
        if (r113 == false) goto L89;
        removeCallbacks(this.mCheckForGapsRunnable);
        if (checkForGaps() == false) goto L89;
    L78:
        if (getChildCount() <= 0) goto L84;
        if (this.mLaidOutInvalidFullSpan == false) goto L82;
    L83:
        r113 = true;
        goto L85
    L82:
        if (hasGapsToFix() == null) goto L84;
    L69:
        if (this.mShouldReverseLayout == false) goto L71;
        fixEndGap(r100, r110, true);
        fixStartGap(r100, r110, false);
        goto L72
    L71:
        fixStartGap(r100, r110, true);
        fixEndGap(r100, r110, false);
        goto L72
    L65:
        setLayoutStateDirection(1);
        fill(r100, this.mLayoutState, r110);
        setLayoutStateDirection(-1);
        LayoutState r114 = this.mLayoutState;
        r114.mCurrentPosition = r101.mPosition + r114.mItemDirection;
        fill(r100, r114, r110);
        goto L66
    L13:
        if (this.mPendingScrollPosition != (-1)) goto L18;
        if (this.mPendingSavedState != null) goto L18;
        r103 = false;
    L7:
        if (r110.getItemCount() != 0) goto L10;
        removeAndRecycleAllViews(r100);
        r101.reset();
    }

    private void updateRemainingSpans(Span r100, int r101, int r102) {
        int r103 = r100.getDeletedSize();
        if (r101 != (-1)) goto L8;
        if ((r100.getStartLine() + r103) > r102) goto L11;
        this.mRemainingSpans.set(r100.mIndex, false);
        return;
    L11:
        return;
    L8:
        if ((r100.getEndLine() - r103) < r102) goto L13;
        this.mRemainingSpans.set(r100.mIndex, false);
        return;
    }

    private int updateSpecWithExtra(int r100, int r101, int r102) {
        if (r101 != 0) goto L5;
        if (r102 != 0) goto L5;
        return r100;
    L5:
        int r103 = View.MeasureSpec.getMode(r100);
        if (r103 == Integer.MIN_VALUE) goto L12;
        if (r103 == 1073741824) goto L12;
        return r100;
    L12:
        return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(r100) - r101) - r102), r103);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView r100, int r101, int r102) {
        handleUpdate(r101, r102, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView r100, int r101, int r102) {
        handleUpdate(r101, r102, 2);
    }

    public int scrollBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        if (getChildCount() == 0) goto L14;
        if (r100 == 0) goto L14;
        prepareLayoutStateForDelta(r100, r102);
        int r103 = fill(r101, this.mLayoutState, r102);
        if (this.mLayoutState.mAvailable < r103) goto L12;
        if (r100 >= 0) goto L11;
        r100 = -r103;
        goto L12
    L11:
        r100 = r103;
    L12:
        this.mPrimaryOrientation.offsetChildren(-r100);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        LayoutState r104 = this.mLayoutState;
        r104.mAvailable = 0;
        recycle(r101, r104);
        return r100;
    L14:
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        return scrollBy(r100, r101, r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int r100, RecyclerView.Recycler r101, RecyclerView.State r102) {
        return scrollBy(r100, r101, r102);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect r100, int r101, int r102) {
        int r103 = getPaddingLeft() + getPaddingRight();
        int r104 = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation != 1) goto L5;
        int r105 = RecyclerView.LayoutManager.chooseSize(r102, r100.height() + r104, getMinimumHeight());
        int r106 = RecyclerView.LayoutManager.chooseSize(r101, (this.mSizePerSpan * this.mSpanCount) + r103, getMinimumWidth());
    L6:
        setMeasuredDimension(r106, r105);
        return;
    L5:
        r106 = RecyclerView.LayoutManager.chooseSize(r101, r100.width() + r103, getMinimumWidth());
        r105 = RecyclerView.LayoutManager.chooseSize(r102, (this.mSizePerSpan * this.mSpanCount) + r104, getMinimumHeight());
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView r100, RecyclerView.State r101, int r102) {
        LinearSmoothScroller r103 = new LinearSmoothScroller(r100.getContext());
        r103.setTargetPosition(r102);
        startSmoothScroll(r103);
    }

    public StaggeredGridLayoutManager(Context r100, AttributeSet r101, int r102, int r103) {
        this.mSpanCount = -1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mLazySpanLookup = new LazySpanLookup();
        this.mGapStrategy = 2;
        this.mTmpRect = new Rect();
        this.mAnchorInfo = new AnchorInfo(this);
        this.mLaidOutInvalidFullSpan = false;
        this.mSmoothScrollbarEnabled = true;
        this.mCheckForGapsRunnable = new AnonymousClass1(this);
        RecyclerView.LayoutManager.Properties r104 = RecyclerView.LayoutManager.getProperties(r100, r101, r102, r103);
        setOrientation(r104.orientation);
        setSpanCount(r104.spanCount);
        setReverseLayout(r104.reverseLayout);
        this.mLayoutState = new LayoutState();
        createOrientationHelpers();
    }

    private void measureChildWithDecorationsAndMargin(View r100, int r101, int r102, boolean r103) {
        calculateItemDecorationsForChild(r100, this.mTmpRect);
        LayoutParams r104 = (LayoutParams) r100.getLayoutParams();
        int r105 = ((ViewGroup.MarginLayoutParams) r104).leftMargin;
        Rect r106 = this.mTmpRect;
        int r107 = updateSpecWithExtra(r101, r105 + r106.left, ((ViewGroup.MarginLayoutParams) r104).rightMargin + r106.right);
        int r108 = ((ViewGroup.MarginLayoutParams) r104).topMargin;
        Rect r109 = this.mTmpRect;
        int r110 = updateSpecWithExtra(r102, r108 + r109.top, ((ViewGroup.MarginLayoutParams) r104).bottomMargin + r109.bottom);
        if (r103 == false) goto L5;
        boolean r111 = shouldReMeasureChild(r100, r107, r110, r104);
    L6:
        if (r111 == false) goto L9;
        r100.measure(r107, r110);
        return;
    L9:
        return;
    L5:
        r111 = shouldMeasureChild(r100, r107, r110, r104);
        goto L6
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void collectAdjacentPrefetchPositions(int r100, int r101, RecyclerView.State r102, RecyclerView.LayoutManager.LayoutPrefetchRegistry r103) {
        if (this.mOrientation == 0) goto L7;
        r100 = r101;
    L7:
        if (getChildCount() == 0) goto L31;
        if (r100 == 0) goto L37;
        prepareLayoutStateForDelta(r100, r102);
        int[] r104 = this.mPrefetchDistances;
        if (r104 != null) goto L13;
    L14:
        this.mPrefetchDistances = new int[this.mSpanCount];
    L15:
        int r105 = 0;
        int r106 = 0;
        int r107 = 0;
    L17:
        if (r106 >= this.mSpanCount) goto L26;
        LayoutState r108 = this.mLayoutState;
        if (r108.mItemDirection != (-1)) goto L21;
        int r109 = r108.mStartLine;
        int r110 = this.mSpans[r106].getStartLine(r109);
    L22:
        int r111 = r109 - r110;
        if (r111 < 0) goto L25;
        this.mPrefetchDistances[r107] = r111;
        r107 = r107 + 1;
    L25:
        r106 = r106 + 1;
        goto L17
    L21:
        r109 = this.mSpans[r106].getEndLine(r108.mEndLine);
        r110 = this.mLayoutState.mEndLine;
        goto L22
    L26:
        Arrays.sort(this.mPrefetchDistances, 0, r107);
    L27:
        if (r105 >= r107) goto L38;
        if (this.mLayoutState.hasMore(r102) == false) goto L39;
        r103.addPosition(this.mLayoutState.mCurrentPosition, this.mPrefetchDistances[r105]);
        LayoutState r112 = this.mLayoutState;
        r112.mCurrentPosition += r112.mItemDirection;
        r105 = r105 + 1;
        goto L27
    L39:
        return;
    L38:
        return;
    L13:
        if (r104.length >= this.mSpanCount) goto L15;
    L37:
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View r100, int r110, RecyclerView.Recycler r111, RecyclerView.State r112) {
        if (getChildCount() != 0) goto L5;
        return null;
    L5:
        View r101 = findContainingItemView(r100);
        if (r101 != null) goto L8;
        return null;
    L8:
        resolveShouldLayoutReverse();
        int r113 = convertFocusDirectionToLayoutDirection(r110);
        if (r113 != Integer.MIN_VALUE) goto L11;
        return null;
    L11:
        LayoutParams r102 = (LayoutParams) r101.getLayoutParams();
        boolean r103 = r102.mFullSpan;
        Span r104 = r102.mSpan;
        if (r113 != 1) goto L14;
        int r105 = getLastChildPosition();
    L15:
        updateLayoutState(r105, r112);
        setLayoutStateDirection(r113);
        LayoutState r106 = this.mLayoutState;
        r106.mCurrentPosition = r106.mItemDirection + r105;
        r106.mAvailable = (int) (this.mPrimaryOrientation.getTotalSpace() * MAX_SCROLL_FACTOR);
        LayoutState r107 = this.mLayoutState;
        r107.mStopInFocusable = true;
        int r108 = 0;
        r107.mRecycle = false;
        fill(r111, r107, r112);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        if (r103 == true) goto L22;
        View r114 = r104.getFocusableViewAfter(r105, r113);
        if (r114 == null) goto L22;
        if (r114 == r101) goto L22;
        return r114;
    L22:
        if (preferLastSpan(r113) == false) goto L30;
        int r115 = this.mSpanCount - 1;
    L24:
        if (r115 < 0) goto L38;
        View r116 = this.mSpans[r115].getFocusableViewAfter(r105, r113);
        if (r116 == null) goto L29;
        if (r116 == r101) goto L29;
        return r116;
    L29:
        r115 = r115 - 1;
    L38:
        boolean r117 = !this.mReverseLayout;
        if (r113 != (-1)) goto L41;
        boolean r118 = true;
    L42:
        if (r117 != r118) goto L44;
        boolean r119 = true;
    L45:
        if (r103 == true) goto L54;
        if (r119 == false) goto L48;
        int r120 = r104.findFirstPartiallyVisibleItemPosition();
    L49:
        View r121 = findViewByPosition(r120);
        if (r121 == null) goto L54;
        if (r121 == r101) goto L54;
        return r121;
    L48:
        r120 = r104.findLastPartiallyVisibleItemPosition();
    L54:
        if (preferLastSpan(r113) == false) goto L69;
        int r122 = this.mSpanCount - 1;
    L56:
        if (r122 < 0) goto L78;
        if (r122 == r104.mIndex) goto L67;
        if (r119 == false) goto L62;
        int r123 = this.mSpans[r122].findFirstPartiallyVisibleItemPosition();
    L63:
        View r124 = findViewByPosition(r123);
        if (r124 == null) goto L67;
        if (r124 == r101) goto L67;
        return r124;
    L62:
        r123 = this.mSpans[r122].findLastPartiallyVisibleItemPosition();
    L67:
        r122 = r122 - 1;
    L78:
        return null;
    L69:
        if (r108 >= this.mSpanCount) goto L78;
        if (r119 == false) goto L72;
        int r125 = this.mSpans[r108].findFirstPartiallyVisibleItemPosition();
    L73:
        View r126 = findViewByPosition(r125);
        if (r126 == null) goto L77;
        if (r126 == r101) goto L77;
        return r126;
    L77:
        r108 = r108 + 1;
        goto L69
    L72:
        r125 = this.mSpans[r108].findLastPartiallyVisibleItemPosition();
        goto L73
    L44:
        r119 = false;
        goto L45
    L41:
        r118 = false;
        goto L42
    L30:
        int r127 = 0;
    L32:
        if (r127 >= this.mSpanCount) goto L38;
        View r128 = this.mSpans[r127].getFocusableViewAfter(r105, r113);
        if (r128 == null) goto L37;
        if (r128 == r101) goto L37;
        return r128;
    L37:
        r127 = r127 + 1;
        goto L32
    L14:
        r105 = getFirstChildPosition();
        goto L15
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView r100, int r101, int r102, int r103) {
        handleUpdate(r101, r102, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView r100, int r101, int r102, Object r103) {
        handleUpdate(r101, r102, 4);
    }
}
