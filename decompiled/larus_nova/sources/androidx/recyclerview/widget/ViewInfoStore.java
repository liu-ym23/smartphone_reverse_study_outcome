package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;

/* JADX INFO: loaded from: classes3.dex */
class ViewInfoStore {
    private static final boolean DEBUG = false;
    final SimpleArrayMap<RecyclerView.ViewHolder, InfoRecord> mLayoutHolderMap;
    final LongSparseArray<RecyclerView.ViewHolder> mOldChangedHolders;

    /* JADX INFO: loaded from: classes17.dex */
    public static class InfoRecord {
        static final int FLAG_APPEAR = 2;
        static final int FLAG_APPEAR_AND_DISAPPEAR = 3;
        static final int FLAG_APPEAR_PRE_AND_POST = 14;
        static final int FLAG_DISAPPEARED = 1;
        static final int FLAG_POST = 8;
        static final int FLAG_PRE = 4;
        static final int FLAG_PRE_AND_POST = 12;
        static Pools.Pool<InfoRecord> sPool;
        int flags;
        RecyclerView.ItemAnimator.ItemHolderInfo postInfo;
        RecyclerView.ItemAnimator.ItemHolderInfo preInfo;

        static {
            sPool = new Pools.SimplePool(20);
        }

        public static void drainCache() {
        L3:
            if (sPool.acquire() != null) goto L3;
        }

        public static InfoRecord obtain() {
            InfoRecord r100 = sPool.acquire();
            if (r100 == null) goto L5;
            return r100;
        L5:
            return new InfoRecord();
        }

        private InfoRecord() {
        }

        public static void recycle(InfoRecord r100) {
            r100.flags = 0;
            r100.preInfo = null;
            r100.postInfo = null;
            sPool.release(r100);
        }
    }

    public interface ProcessCallback {
        void processAppeared(RecyclerView.ViewHolder r100, RecyclerView.ItemAnimator.ItemHolderInfo r101, RecyclerView.ItemAnimator.ItemHolderInfo r102);

        void processDisappeared(RecyclerView.ViewHolder r100, RecyclerView.ItemAnimator.ItemHolderInfo r101, RecyclerView.ItemAnimator.ItemHolderInfo r102);

        void processPersistent(RecyclerView.ViewHolder r100, RecyclerView.ItemAnimator.ItemHolderInfo r101, RecyclerView.ItemAnimator.ItemHolderInfo r102);

        void unused(RecyclerView.ViewHolder r100);
    }

    public void clear() {
        this.mLayoutHolderMap.clear();
        this.mOldChangedHolders.clear();
    }

    public ViewInfoStore() {
        this.mLayoutHolderMap = new SimpleArrayMap();
        this.mOldChangedHolders = new LongSparseArray();
    }

    public void onDetach() {
        InfoRecord.drainCache();
    }

    public void addToDisappearedInLayout(RecyclerView.ViewHolder r100) {
        InfoRecord r101 = this.mLayoutHolderMap.get(r100);
        if (r101 != null) goto L5;
        r101 = InfoRecord.obtain();
        this.mLayoutHolderMap.put(r100, r101);
    L5:
        r101.flags |= 1;
    }

    public RecyclerView.ViewHolder getFromOldChangeHolders(long r100) {
        return this.mOldChangedHolders.get(r100);
    }

    public boolean isDisappearing(RecyclerView.ViewHolder r100) {
        InfoRecord r101 = this.mLayoutHolderMap.get(r100);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if ((r101.flags & 1) == 0) goto L7;
        return true;
    }

    public boolean isInPreLayout(RecyclerView.ViewHolder r100) {
        InfoRecord r101 = this.mLayoutHolderMap.get(r100);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if ((r101.flags & 4) == 0) goto L7;
        return true;
    }

    public void onViewDetached(RecyclerView.ViewHolder r100) {
        removeFromDisappearedInLayout(r100);
    }

    public RecyclerView.ItemAnimator.ItemHolderInfo popFromPostLayout(RecyclerView.ViewHolder r100) {
        return popFromLayoutStep(r100, 8);
    }

    public RecyclerView.ItemAnimator.ItemHolderInfo popFromPreLayout(RecyclerView.ViewHolder r100) {
        return popFromLayoutStep(r100, 4);
    }

    public void process(ProcessCallback r100) {
        int r101 = this.mLayoutHolderMap.size() - 1;
    L3:
        if (r101 < 0) goto L26;
        RecyclerView.ViewHolder r102 = this.mLayoutHolderMap.keyAt(r101);
        InfoRecord r103 = this.mLayoutHolderMap.removeAt(r101);
        int r104 = r103.flags;
        if ((r104 & 3) != 3) goto L8;
        r100.unused(r102);
    L25:
        InfoRecord.recycle(r103);
        r101 = r101 - 1;
        goto L3
    L8:
        if ((r104 & 1) == 0) goto L14;
        RecyclerView.ItemAnimator.ItemHolderInfo r105 = r103.preInfo;
        if (r105 != null) goto L12;
        r100.unused(r102);
        goto L25
    L12:
        r100.processDisappeared(r102, r105, r103.postInfo);
        goto L25
    L14:
        if ((r104 & 14) != 14) goto L17;
        r100.processAppeared(r102, r103.preInfo, r103.postInfo);
        goto L25
    L17:
        if ((r104 & 12) != 12) goto L20;
        r100.processPersistent(r102, r103.preInfo, r103.postInfo);
        goto L25
    L20:
        if ((r104 & 4) == 0) goto L23;
        r100.processDisappeared(r102, r103.preInfo, null);
        goto L25
    L23:
        if ((r104 & 8) == 0) goto L25;
        r100.processAppeared(r102, r103.preInfo, r103.postInfo);
        goto L25
    }

    public void removeFromDisappearedInLayout(RecyclerView.ViewHolder r100) {
        InfoRecord r101 = this.mLayoutHolderMap.get(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        r101.flags &= -2;
    }

    public void removeViewHolder(RecyclerView.ViewHolder r100) {
        int r101 = this.mOldChangedHolders.size() - 1;
    L3:
        if (r101 < 0) goto L8;
        if (r100 == this.mOldChangedHolders.valueAt(r101)) goto L6;
        r101 = r101 - 1;
        goto L3
    L6:
        this.mOldChangedHolders.removeAt(r101);
    L8:
        InfoRecord r102 = this.mLayoutHolderMap.remove(r100);
        if (r102 == null) goto L14;
        InfoRecord.recycle(r102);
        return;
    }

    private RecyclerView.ItemAnimator.ItemHolderInfo popFromLayoutStep(RecyclerView.ViewHolder r100, int r101) {
        int r102 = this.mLayoutHolderMap.indexOfKey(r100);
        if (r102 >= 0) goto L5;
        return null;
    L5:
        InfoRecord r103 = this.mLayoutHolderMap.valueAt(r102);
        if (r103 == null) goto L21;
        int r104 = r103.flags;
        if ((r104 & r101) == 0) goto L21;
        int r105 = (~r101) & r104;
        r103.flags = r105;
        if (r101 != 4) goto L13;
        RecyclerView.ItemAnimator.ItemHolderInfo r106 = r103.preInfo;
    L16:
        if ((r105 & 12) != 0) goto L18;
        this.mLayoutHolderMap.removeAt(r102);
        InfoRecord.recycle(r103);
    L18:
        return r106;
    L13:
        if (r101 != 8) goto L20;
        r106 = r103.postInfo;
        goto L16
    L20:
        throw new IllegalArgumentException("Must provide flag PRE or POST");
    L21:
        return null;
    }

    public void addToAppearedInPreLayoutHolders(RecyclerView.ViewHolder r100, RecyclerView.ItemAnimator.ItemHolderInfo r101) {
        InfoRecord r102 = this.mLayoutHolderMap.get(r100);
        if (r102 != null) goto L5;
        r102 = InfoRecord.obtain();
        this.mLayoutHolderMap.put(r100, r102);
    L5:
        r102.flags |= 2;
        r102.preInfo = r101;
    }

    public void addToOldChangeHolders(long r100, RecyclerView.ViewHolder r101) {
        this.mOldChangedHolders.put(r100, r101);
    }

    public void addToPostLayout(RecyclerView.ViewHolder r100, RecyclerView.ItemAnimator.ItemHolderInfo r101) {
        InfoRecord r102 = this.mLayoutHolderMap.get(r100);
        if (r102 != null) goto L5;
        r102 = InfoRecord.obtain();
        this.mLayoutHolderMap.put(r100, r102);
    L5:
        r102.postInfo = r101;
        r102.flags |= 8;
    }

    public void addToPreLayout(RecyclerView.ViewHolder r100, RecyclerView.ItemAnimator.ItemHolderInfo r101) {
        InfoRecord r102 = this.mLayoutHolderMap.get(r100);
        if (r102 != null) goto L5;
        r102 = InfoRecord.obtain();
        this.mLayoutHolderMap.put(r100, r102);
    L5:
        r102.preInfo = r101;
        r102.flags |= 4;
    }
}
