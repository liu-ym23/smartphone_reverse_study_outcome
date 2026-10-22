package androidx.recyclerview.widget;

import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes17.dex */
public class AsyncListUtil<T> {
    static final boolean DEBUG = false;
    static final String TAG = "AsyncListUtil";
    boolean mAllowScrollHints;
    private final ThreadUtil.BackgroundCallback<T> mBackgroundCallback;
    final ThreadUtil.BackgroundCallback<T> mBackgroundProxy;
    final DataCallback<T> mDataCallback;
    int mDisplayedGeneration;
    int mItemCount;
    private final ThreadUtil.MainThreadCallback<T> mMainThreadCallback;
    final ThreadUtil.MainThreadCallback<T> mMainThreadProxy;
    final SparseIntArray mMissingPositions;
    final int[] mPrevRange;
    int mRequestedGeneration;
    private int mScrollHint;
    final Class<T> mTClass;
    final TileList<T> mTileList;
    final int mTileSize;
    final int[] mTmpRange;
    final int[] mTmpRangeExtended;
    final ViewCallback mViewCallback;

    public static abstract class DataCallback<T> {
        public DataCallback() {
        }

        public abstract void fillData(T[] r100, int r101, int r102);

        public int getMaxCachedTiles() {
            return 10;
        }

        public void recycleData(T[] r100, int r101) {
        }

        public abstract int refreshData();
    }

    public static abstract class ViewCallback {
        public static final int HINT_SCROLL_ASC = 2;
        public static final int HINT_SCROLL_DESC = 1;
        public static final int HINT_SCROLL_NONE = 0;

        public ViewCallback() {
        }

        public abstract void getItemRangeInto(int[] r100);

        public abstract void onDataRefresh();

        public abstract void onItemLoaded(int r100);

        public void extendRangeInto(int[] r100, int[] r101, int r102) {
            int r103 = r100[1];
            int r104 = r100[0];
            int r105 = (r103 - r104) + 1;
            int r106 = r105 / 2;
            if (r102 != 1) goto L5;
            int r107 = r105;
        L6:
            r101[0] = r104 - r107;
            if (r102 == 2) goto L10;
            r105 = r106;
        L10:
            r101[1] = r103 + r105;
            return;
        L5:
            r107 = r106;
            goto L6
        }
    }

    private boolean isRefreshPending() {
        if (this.mRequestedGeneration == this.mDisplayedGeneration) goto L5;
        return true;
    L5:
        return false;
    }

    public void refresh() {
        this.mMissingPositions.clear();
        ThreadUtil.BackgroundCallback<T> r100 = this.mBackgroundProxy;
        int r101 = this.mRequestedGeneration + 1;
        this.mRequestedGeneration = r101;
        r100.refresh(r101);
    }

    public void updateRange() {
        this.mViewCallback.getItemRangeInto(this.mTmpRange);
        int[] r100 = this.mTmpRange;
        int r101 = r100[0];
        int r102 = r100[1];
        if (r101 > r102) goto L24;
        if (r101 >= 0) goto L7;
        return;
    L7:
        if (r102 < this.mItemCount) goto L10;
        return;
    L10:
        if (this.mAllowScrollHints == true) goto L12;
        this.mScrollHint = 0;
    L22:
        int[] r103 = this.mPrevRange;
        r103[0] = r101;
        r103[1] = r102;
        this.mViewCallback.extendRangeInto(r100, this.mTmpRangeExtended, this.mScrollHint);
        int[] r104 = this.mTmpRangeExtended;
        r104[0] = Math.min(this.mTmpRange[0], Math.max(r104[0], 0));
        int[] r105 = this.mTmpRangeExtended;
        r105[1] = Math.max(this.mTmpRange[1], Math.min(r105[1], this.mItemCount - 1));
        ThreadUtil.BackgroundCallback<T> r106 = this.mBackgroundProxy;
        int[] r107 = this.mTmpRange;
        int r108 = r107[0];
        int r109 = r107[1];
        int[] r110 = this.mTmpRangeExtended;
        r106.updateRange(r108, r109, r110[0], r110[1], this.mScrollHint);
        return;
    L12:
        int[] r111 = this.mPrevRange;
        if (r101 > r111[1]) goto L21;
        int r112 = r111[0];
        if (r112 > r102) goto L21;
        if (r101 >= r112) goto L19;
        this.mScrollHint = 1;
        goto L22
    L19:
        if (r101 <= r112) goto L22;
        this.mScrollHint = 2;
    L21:
        this.mScrollHint = 0;
        goto L22
    }

    public void onRangeChanged() {
        if (isRefreshPending() == false) goto L5;
        return;
    L5:
        updateRange();
        this.mAllowScrollHints = true;
    }

    public int getItemCount() {
        return this.mItemCount;
    }

    public T getItem(int r100) {
        if (r100 < 0) goto L12;
        if (r100 >= this.mItemCount) goto L12;
        T r101 = this.mTileList.getItemAt(r100);
        if (r101 == null) goto L8;
    L10:
        return r101;
    L8:
        if (isRefreshPending() == true) goto L10;
        this.mMissingPositions.put(r100, 0);
    L12:
        throw new IndexOutOfBoundsException(r100 + " is not within 0 and " + this.mItemCount);
    }

    public void log(String r100, Object... r101) {
        String.format(r100, r101);
    }

    public AsyncListUtil(Class<T> r100, int r101, DataCallback<T> r102, ViewCallback r103) {
        this.mTmpRange = new int[2];
        this.mPrevRange = new int[2];
        this.mTmpRangeExtended = new int[2];
        this.mScrollHint = 0;
        this.mItemCount = 0;
        this.mDisplayedGeneration = 0;
        this.mRequestedGeneration = 0;
        this.mMissingPositions = new SparseIntArray();
        ThreadUtil.MainThreadCallback<T> r104 = new AnonymousClass1(this);
        this.mMainThreadCallback = r104;
        ThreadUtil.BackgroundCallback<T> r105 = new AnonymousClass2(this);
        this.mBackgroundCallback = r105;
        this.mTClass = r100;
        this.mTileSize = r101;
        this.mDataCallback = r102;
        this.mViewCallback = r103;
        this.mTileList = new TileList(r101);
        MessageThreadUtil r106 = new MessageThreadUtil();
        this.mMainThreadProxy = r106.getMainThreadProxy(r104);
        this.mBackgroundProxy = r106.getBackgroundProxy(r105);
        refresh();
    }
}
