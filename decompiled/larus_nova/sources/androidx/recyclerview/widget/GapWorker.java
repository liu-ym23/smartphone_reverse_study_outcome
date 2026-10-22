package androidx.recyclerview.widget;

import androidx.core.os.TraceCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes17.dex */
final class GapWorker implements Runnable {
    static final ThreadLocal<GapWorker> sGapWorker = null;
    static Comparator<Task> sTaskComparator;
    long mFrameIntervalNs;
    long mPostTimeNs;
    ArrayList<RecyclerView> mRecyclerViews;
    private ArrayList<Task> mTasks;

    /* JADX INFO: loaded from: classes3.dex */
    public static class LayoutPrefetchRegistryImpl implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {
        int mCount;
        int[] mPrefetchArray;
        int mPrefetchDx;
        int mPrefetchDy;

        public LayoutPrefetchRegistryImpl() {
        }

        public void clearPrefetchPositions() {
            int[] r100 = this.mPrefetchArray;
            if (r100 == null) goto L5;
            Arrays.fill(r100, -1);
        L5:
            this.mCount = 0;
        }

        public boolean lastPrefetchIncludedPosition(int r100) {
            if (this.mPrefetchArray == null) goto L11;
            int r101 = this.mCount * 2;
            int r102 = 0;
        L5:
            if (r102 >= r101) goto L11;
            if (this.mPrefetchArray[r102] == r100) goto L8;
            r102 = r102 + 2;
            goto L5
        L8:
            return true;
        L11:
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry
        public void addPosition(int r100, int r101) {
            if (r100 < 0) goto L15;
            if (r101 < 0) goto L13;
            int r102 = this.mCount * 2;
            int[] r103 = this.mPrefetchArray;
            if (r103 != null) goto L8;
            int[] r104 = new int[4];
            this.mPrefetchArray = r104;
            Arrays.fill(r104, -1);
        L10:
            int[] r105 = this.mPrefetchArray;
            r105[r102] = r100;
            r105[r102 + 1] = r101;
            this.mCount++;
            return;
        L8:
            if (r102 < r103.length) goto L10;
            int[] r106 = new int[r102 * 2];
            this.mPrefetchArray = r106;
            System.arraycopy(r103, 0, r106, 0, r103.length);
            goto L10
        L13:
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        L15:
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }

        public void collectPrefetchPositionsFromView(RecyclerView r100, boolean r101) {
            this.mCount = 0;
            int[] r102 = this.mPrefetchArray;
            if (r102 == null) goto L5;
            Arrays.fill(r102, -1);
        L5:
            RecyclerView.LayoutManager r103 = r100.mLayout;
            if (r100.mAdapter == null) goto L21;
            if (r103 != null) goto L9;
            return;
        L9:
            if (r103.isItemPrefetchEnabled() == false) goto L23;
            if (r101 == false) goto L15;
            if (r100.mAdapterHelper.hasPendingUpdates() == true) goto L17;
            r103.collectInitialPrefetchPositions(r100.mAdapter.getItemCount(), this);
        L17:
            int r104 = this.mCount;
            if (r104 <= r103.mPrefetchMaxCountObserved) goto L24;
            r103.mPrefetchMaxCountObserved = r104;
            r103.mPrefetchMaxObservedInInitialPrefetch = r101;
            r100.mRecycler.updateViewCacheSize();
            return;
        L24:
            return;
        L15:
            if (r100.hasPendingAdapterUpdates() == true) goto L17;
            r103.collectAdjacentPrefetchPositions(this.mPrefetchDx, this.mPrefetchDy, r100.mState, this);
            goto L17
        L23:
            return;
        }

        public void setPrefetchVector(int r100, int r101) {
            this.mPrefetchDx = r100;
            this.mPrefetchDy = r101;
        }
    }

    public static class Task {
        public int distanceToItem;
        public boolean immediate;
        public int position;
        public RecyclerView view;
        public int viewVelocity;

        public Task() {
        }

        public void clear() {
            this.immediate = false;
            this.viewVelocity = 0;
            this.distanceToItem = 0;
            this.view = null;
            this.position = 0;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        androidx_recyclerview_widget_GapWorker_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    static {
        sGapWorker = new ThreadLocal();
        sTaskComparator = new AnonymousClass1();
    }

    private void buildTaskList() {
        int r100 = this.mRecyclerViews.size();
        int r101 = 0;
        int r102 = 0;
    L3:
        if (r101 >= r100) goto L8;
        RecyclerView r103 = (RecyclerView) ListProtector.get(this.mRecyclerViews, r101);
        if (r103.getWindowVisibility() != 0) goto L7;
        r103.mPrefetchRegistry.collectPrefetchPositionsFromView(r103, false);
        r102 = r102 + r103.mPrefetchRegistry.mCount;
    L7:
        r101 = r101 + 1;
        goto L3
    L8:
        this.mTasks.ensureCapacity(r102);
        int r104 = 0;
        int r105 = 0;
    L9:
        if (r104 >= r100) goto L26;
        RecyclerView r106 = (RecyclerView) ListProtector.get(this.mRecyclerViews, r104);
        if (r106.getWindowVisibility() != 0) goto L25;
        LayoutPrefetchRegistryImpl r107 = r106.mPrefetchRegistry;
        int r108 = Math.abs(r107.mPrefetchDx) + Math.abs(r107.mPrefetchDy);
        int r109 = 0;
    L15:
        if (r109 >= (r107.mCount * 2)) goto L25;
        if (r105 < this.mTasks.size()) goto L19;
        Task r110 = new Task();
        this.mTasks.add(r110);
    L20:
        int[] r111 = r107.mPrefetchArray;
        int r112 = r111[r109 + 1];
        if (r112 > r108) goto L23;
        boolean r113 = true;
    L24:
        r110.immediate = r113;
        r110.viewVelocity = r108;
        r110.distanceToItem = r112;
        r110.view = r106;
        r110.position = r111[r109];
        r105 = r105 + 1;
        r109 = r109 + 2;
        goto L15
    L23:
        r113 = false;
        goto L24
    L19:
        r110 = (Task) ListProtector.get(this.mTasks, r105);
    L25:
        r104 = r104 + 1;
        goto L9
    L26:
        Collections.sort(this.mTasks, sTaskComparator);
    }

    public void androidx_recyclerview_widget_GapWorker__run$___twin___() {
        TraceCompat.beginSection("RV Prefetch");     // Catch: Throwable -> L19
        if (this.mRecyclerViews.isEmpty() == false) goto L7;
    L5:
        this.mPostTimeNs = 0;
        TraceCompat.endSection();
        return;
    L7:
        int r100 = this.mRecyclerViews.size();     // Catch: Throwable -> L19
        int r101 = 0;
        long r102 = 0;
    L8:
        if (r101 >= r100) goto L14;
        RecyclerView r103 = this.mRecyclerViews.get(r101);     // Catch: Throwable -> L19
        if (r103.getWindowVisibility() != 0) goto L12;
        r102 = Math.max(r103.getDrawingTime(), r102);     // Catch: Throwable -> L19
    L12:
        r101 = r101 + 1;     // Catch: Throwable -> L19
        goto L8
    L14:
        if (r102 == 0) goto L5;
        prefetch(TimeUnit.MILLISECONDS.toNanos(r102) + this.mFrameIntervalNs);     // Catch: Throwable -> L19
        this.mPostTimeNs = 0;
        TraceCompat.endSection();
        return;
    L19:
        th = move-exception;
        this.mPostTimeNs = 0;
        TraceCompat.endSection();
        throw th;
    }

    public GapWorker() {
        this.mRecyclerViews = new ArrayList();
        this.mTasks = new ArrayList();
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void androidx_recyclerview_widget_GapWorker_com_larus_apm_impl_protector_RunnableLancet_run(GapWorker r100) {
        r100.androidx_recyclerview_widget_GapWorker__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    private void flushTasksWithDeadline(long r100) {
        int r101 = 0;
    L4:
        if (r101 >= this.mTasks.size()) goto L9;
        Task r102 = (Task) ListProtector.get(this.mTasks, r101);
        if (r102.view == null) goto L12;
        flushTaskWithDeadline(r102, r100);
        r102.clear();
        r101 = r101 + 1;
        goto L4
    L12:
        return;
    }

    public void add(RecyclerView r100) {
        this.mRecyclerViews.add(r100);
    }

    public void prefetch(long r100) {
        buildTaskList();
        flushTasksWithDeadline(r100);
    }

    public void remove(RecyclerView r100) {
        this.mRecyclerViews.remove(r100);
    }

    private void flushTaskWithDeadline(Task r100, long r101) {
        if (r100.immediate == false) goto L5;
        long r102 = Long.MAX_VALUE;
    L6:
        RecyclerView.ViewHolder r103 = prefetchPositionWithDeadline(r100.view, r100.position, r102);
        if (r103 != null) goto L9;
        return;
    L9:
        if (r103.mNestedRecyclerView != null) goto L11;
        return;
    L11:
        if (r103.isBound() == true) goto L13;
        return;
    L13:
        if (r103.isInvalid() == true) goto L19;
        prefetchInnerRecyclerViewWithDeadline(r103.mNestedRecyclerView.get(), r101);
        return;
    L19:
        return;
    L5:
        r102 = r101;
        goto L6
    }

    public static boolean isPrefetchPositionAttached(RecyclerView r100, int r101) {
        int r102 = r100.mChildHelper.getUnfilteredChildCount();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        RecyclerView.ViewHolder r104 = RecyclerView.getChildViewHolderInt(r100.mChildHelper.getUnfilteredChildAt(r103));
        if (r104.mPosition != r101) goto L10;
        if (r104.isInvalid() == true) goto L10;
        return true;
    L10:
        r103 = r103 + 1;
        goto L3
    L11:
        return false;
    }

    private void prefetchInnerRecyclerViewWithDeadline(RecyclerView r100, long r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.mDataSetHasChangedAfterLayout == true) goto L7;
    L9:
        LayoutPrefetchRegistryImpl r102 = r100.mPrefetchRegistry;
        r102.collectPrefetchPositionsFromView(r100, true);
        if (r102.mCount != 0) goto L21;
        return;
    L21:
        TraceCompat.beginSection("RV Nested Prefetch");     // Catch: Throwable -> L17
        r100.mState.prepareForNestedPrefetch(r100.mAdapter);     // Catch: Throwable -> L17
        int r103 = 0;
    L13:
        if (r103 >= (r102.mCount * 2)) goto L16;
        prefetchPositionWithDeadline(r100, r102.mPrefetchArray[r103], r101);     // Catch: Throwable -> L17
        r103 = r103 + 2;
        goto L13
    L16:
        TraceCompat.endSection();
        return;
    L17:
        th = move-exception;
        TraceCompat.endSection();
        throw th;
    L7:
        if (r100.mChildHelper.getUnfilteredChildCount() == 0) goto L9;
        r100.removeAndRecycleViews();
        goto L9
    }

    private RecyclerView.ViewHolder prefetchPositionWithDeadline(RecyclerView r100, int r101, long r102) {
        if (isPrefetchPositionAttached(r100, r101) == false) goto L6;
        return null;
    L6:
        RecyclerView.Recycler r103 = r100.mRecycler;
        r100.onEnterLayoutOrScroll();     // Catch: Throwable -> L17
        RecyclerView.ViewHolder r104 = r103.tryGetViewHolderForPositionByDeadline(r101, false, r102);     // Catch: Throwable -> L17
        if (r104 != null) goto L10;
    L15:
        r100.onExitLayoutOrScroll(false);
        return r104;
    L10:
        if (r104.isBound() == true) goto L12;
    L14:
        r103.addViewHolderToRecycledViewPool(r104, false);     // Catch: Throwable -> L17
        goto L15
    L12:
        if (r104.isInvalid() == true) goto L14;
        r103.recycleView(r104.itemView);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        r100.onExitLayoutOrScroll(false);
        throw th;
    }

    public void postFromTraversal(RecyclerView r100, int r101, int r102) {
        if (r100.isAttachedToWindow() == true) goto L5;
    L7:
        r100.mPrefetchRegistry.setPrefetchVector(r101, r102);
        return;
    L5:
        if (this.mPostTimeNs != 0) goto L7;
        this.mPostTimeNs = r100.getNanoTime();
        r100.post(this);
        goto L7
    }
}
