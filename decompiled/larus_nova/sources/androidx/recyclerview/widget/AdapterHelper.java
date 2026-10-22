package androidx.recyclerview.widget;

import androidx.core.util.Pools;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class AdapterHelper implements OpReorderer.Callback {
    private static final boolean DEBUG = false;
    static final int POSITION_TYPE_INVISIBLE = 0;
    static final int POSITION_TYPE_NEW_OR_LAID_OUT = 1;
    private static final String TAG = "AHT";
    final Callback mCallback;
    final boolean mDisableRecycler;
    private int mExistingUpdateTypes;
    Runnable mOnItemProcessedCallback;
    final OpReorderer mOpReorderer;
    final ArrayList<UpdateOp> mPendingUpdates;
    final ArrayList<UpdateOp> mPostponedList;
    private Pools.Pool<UpdateOp> mUpdateOpPool;

    public interface Callback {
        RecyclerView.ViewHolder findViewHolder(int r100);

        void markViewHoldersUpdated(int r100, int r101, Object r102);

        void offsetPositionsForAdd(int r100, int r101);

        void offsetPositionsForMove(int r100, int r101);

        void offsetPositionsForRemovingInvisible(int r100, int r101);

        void offsetPositionsForRemovingLaidOutOrNewView(int r100, int r101);

        void onDispatchFirstPass(UpdateOp r100);

        void onDispatchSecondPass(UpdateOp r100);
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static final class UpdateOp {
        static final int ADD = 1;
        static final int MOVE = 8;
        static final int POOL_SIZE = 30;
        static final int REMOVE = 2;
        static final int UPDATE = 4;
        int cmd;
        int itemCount;
        Object payload;
        int positionStart;

        public String cmdToString() {
            int r100 = this.cmd;
            if (r100 != 1) goto L5;
            return "add";
        L5:
            if (r100 != 2) goto L7;
            return "rm";
        L7:
            if (r100 != 4) goto L9;
            return "up";
        L9:
            if (r100 == 8) goto L12;
            return "??";
        L12:
            return KtvSubElement.MV;
        }

        public int hashCode() {
            return (((this.cmd * 31) + this.positionStart) * 31) + this.itemCount;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + cmdToString() + ",s:" + this.positionStart + "c:" + this.itemCount + ",p:" + this.payload + "]";
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof UpdateOp) == true) goto L8;
            return false;
        L8:
            UpdateOp r101 = (UpdateOp) r100;
            int r102 = this.cmd;
            if (r102 == r101.cmd) goto L12;
            return false;
        L12:
            if (r102 != 8) goto L21;
            if (Math.abs(this.itemCount - this.positionStart) != 1) goto L21;
            if (this.itemCount != r101.positionStart) goto L21;
            if (this.positionStart != r101.itemCount) goto L21;
            return true;
        L21:
            if (this.itemCount == r101.itemCount) goto L24;
            return false;
        L24:
            if (this.positionStart == r101.positionStart) goto L26;
            return false;
        L26:
            Object r103 = this.payload;
            if (r103 == null) goto L32;
            if (r103.equals(r101.payload) == true) goto L34;
            return false;
        L34:
            return true;
        L32:
            if (r101.payload == null) goto L34;
            return false;
        }

        public UpdateOp(int r100, int r101, int r102, Object r103) {
            this.cmd = r100;
            this.positionStart = r101;
            this.itemCount = r102;
            this.payload = r103;
        }
    }

    public void consumePostponedUpdates() {
        int r100 = this.mPostponedList.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L5;
        this.mCallback.onDispatchSecondPass((UpdateOp) ListProtector.get(this.mPostponedList, r101));
        r101 = r101 + 1;
        goto L3
    L5:
        recycleUpdateOpsAndClearList(this.mPostponedList);
        this.mExistingUpdateTypes = 0;
    }

    public boolean hasPendingUpdates() {
        if (this.mPendingUpdates.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean hasUpdates() {
        if (this.mPostponedList.isEmpty() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.mPendingUpdates.isEmpty() == true) goto L7;
        return true;
    }

    public void preProcess() {
        this.mOpReorderer.reorderOps(this.mPendingUpdates);
        int r100 = this.mPendingUpdates.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L21;
        UpdateOp r102 = (UpdateOp) ListProtector.get(this.mPendingUpdates, r101);
        int r103 = r102.cmd;
        if (r103 != 1) goto L7;
        applyAdd(r102);
    L17:
        Runnable r104 = this.mOnItemProcessedCallback;
        if (r104 == null) goto L20;
        r104.run();
    L20:
        r101 = r101 + 1;
        goto L3
    L7:
        if (r103 != 2) goto L9;
        applyRemove(r102);
        goto L17
    L9:
        if (r103 != 4) goto L11;
        applyUpdate(r102);
        goto L17
    L11:
        if (r103 != 8) goto L17;
        applyMove(r102);
        goto L17
    L21:
        this.mPendingUpdates.clear();
    }

    public void reset() {
        recycleUpdateOpsAndClearList(this.mPendingUpdates);
        recycleUpdateOpsAndClearList(this.mPostponedList);
        this.mExistingUpdateTypes = 0;
    }

    public void consumeUpdatesInOnePass() {
        consumePostponedUpdates();
        int r100 = this.mPendingUpdates.size();
        int r101 = 0;
    L3:
        if (r101 >= r100) goto L21;
        UpdateOp r102 = (UpdateOp) ListProtector.get(this.mPendingUpdates, r101);
        int r103 = r102.cmd;
        if (r103 != 1) goto L7;
        this.mCallback.onDispatchSecondPass(r102);
        this.mCallback.offsetPositionsForAdd(r102.positionStart, r102.itemCount);
    L17:
        Runnable r104 = this.mOnItemProcessedCallback;
        if (r104 == null) goto L20;
        r104.run();
    L20:
        r101 = r101 + 1;
        goto L3
    L7:
        if (r103 != 2) goto L9;
        this.mCallback.onDispatchSecondPass(r102);
        this.mCallback.offsetPositionsForRemovingInvisible(r102.positionStart, r102.itemCount);
        goto L17
    L9:
        if (r103 != 4) goto L11;
        this.mCallback.onDispatchSecondPass(r102);
        this.mCallback.markViewHoldersUpdated(r102.positionStart, r102.itemCount, r102.payload);
        goto L17
    L11:
        if (r103 != 8) goto L17;
        this.mCallback.onDispatchSecondPass(r102);
        this.mCallback.offsetPositionsForMove(r102.positionStart, r102.itemCount);
        goto L17
    L21:
        recycleUpdateOpsAndClearList(this.mPendingUpdates);
        this.mExistingUpdateTypes = 0;
    }

    public AdapterHelper(Callback r100) {
        this(r100, false);
    }

    private void applyAdd(UpdateOp r100) {
        postponeAndUpdateViewHolders(r100);
    }

    private void applyMove(UpdateOp r100) {
        postponeAndUpdateViewHolders(r100);
    }

    private void applyRemove(UpdateOp r110) {
        int r100 = r110.positionStart;
        int r101 = r110.itemCount + r100;
        byte r102 = -1;
        int r103 = r100;
        int r104 = 0;
    L4:
        if (r103 >= r101) goto L23;
        if (this.mCallback.findViewHolder(r103) == null) goto L8;
    L14:
        if (r102 != 0) goto L16;
        dispatchAndUpdateViewHolders(obtainUpdateOp(2, r100, r104, null));
        boolean r105 = true;
    L17:
        byte r106 = 1;
    L18:
        if (r105 == false) goto L20;
        r103 = r103 - r104;
        r101 = r101 - r104;
        r104 = 1;
    L21:
        r103 = r103 + 1;
        r102 = r106;
        goto L4
    L20:
        r104 = r104 + 1;
        goto L21
    L16:
        r105 = false;
        goto L17
    L8:
        if (canFindInPreLayout(r103) == true) goto L14;
        if (r102 != 1) goto L12;
        postponeAndUpdateViewHolders(obtainUpdateOp(2, r100, r104, null));
        r105 = true;
    L13:
        r106 = 0;
        goto L18
    L12:
        r105 = false;
        goto L13
    L23:
        if (r104 == r110.itemCount) goto L25;
        recycleUpdateOp(r110);
        r110 = obtainUpdateOp(2, r100, r104, null);
    L25:
        if (r102 != 0) goto L27;
        dispatchAndUpdateViewHolders(r110);
        return;
    L27:
        postponeAndUpdateViewHolders(r110);
    }

    private void applyUpdate(UpdateOp r110) {
        int r100 = r110.positionStart;
        int r101 = r110.itemCount + r100;
        int r102 = r100;
        byte r103 = -1;
        int r104 = 0;
    L4:
        if (r100 >= r101) goto L18;
        if (this.mCallback.findViewHolder(r100) == null) goto L8;
    L13:
        if (r103 != 0) goto L15;
        dispatchAndUpdateViewHolders(obtainUpdateOp(4, r102, r104, r110.payload));
        r102 = r100;
        r104 = 0;
    L15:
        r103 = 1;
    L16:
        r104 = r104 + 1;
        r100 = r100 + 1;
        goto L4
    L8:
        if (canFindInPreLayout(r100) == true) goto L13;
        if (r103 != 1) goto L12;
        postponeAndUpdateViewHolders(obtainUpdateOp(4, r102, r104, r110.payload));
        r102 = r100;
        r104 = 0;
    L12:
        r103 = 0;
        goto L16
    L18:
        if (r104 == r110.itemCount) goto L20;
        Object r105 = r110.payload;
        recycleUpdateOp(r110);
        r110 = obtainUpdateOp(4, r102, r104, r105);
    L20:
        if (r103 != 0) goto L22;
        dispatchAndUpdateViewHolders(r110);
        return;
    L22:
        postponeAndUpdateViewHolders(r110);
    }

    private boolean canFindInPreLayout(int r100) {
        int r101 = this.mPostponedList.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L17;
        UpdateOp r103 = (UpdateOp) ListProtector.get(this.mPostponedList, r102);
        int r104 = r103.cmd;
        if (r104 == 8) goto L7;
        if (r104 != 1) goto L16;
        int r105 = r103.positionStart;
        int r106 = r103.itemCount + r105;
    L11:
        if (r105 >= r106) goto L16;
        if (findPositionOffset(r105, r102 + 1) == r100) goto L14;
        r105 = r105 + 1;
        goto L11
    L14:
        return true;
    L16:
        r102 = r102 + 1;
        goto L3
    L7:
        if (findPositionOffset(r103.itemCount, r102 + 1) != r100) goto L16;
        return true;
    L17:
        return false;
    }

    private void dispatchAndUpdateViewHolders(UpdateOp r110) {
        int r100 = r110.cmd;
        if (r100 == 1) goto L37;
        if (r100 == 8) goto L37;
        int r101 = updatePositionWithPostponed(r110.positionStart, r100);
        int r102 = r110.positionStart;
        int r103 = r110.cmd;
        if (r103 == 2) goto L12;
        if (r103 != 4) goto L11;
        int r104 = 1;
    L13:
        int r105 = 1;
        int r106 = 1;
    L15:
        if (r105 >= r110.itemCount) goto L32;
        int r107 = updatePositionWithPostponed(r110.positionStart + (r104 * r105), r110.cmd);
        int r111 = r110.cmd;
        if (r111 == 2) goto L23;
        if (r111 == 4) goto L21;
    L19:
        boolean r112 = false;
    L25:
        if (r112 == false) goto L27;
        r106 = r106 + 1;
    L31:
        r105 = r105 + 1;
        goto L15
    L27:
        UpdateOp r108 = obtainUpdateOp(r111, r101, r106, r110.payload);
        dispatchFirstPassAndUpdateViewHolders(r108, r102);
        recycleUpdateOp(r108);
        if (r110.cmd != 4) goto L30;
        r102 = r102 + r106;
    L30:
        r101 = r107;
        r106 = 1;
        goto L31
    L21:
        if (r107 != (r101 + 1)) goto L19;
    L22:
        r112 = true;
        goto L25
    L23:
        if (r107 != r101) goto L19;
    L32:
        Object r109 = r110.payload;
        recycleUpdateOp(r110);
        if (r106 <= 0) goto L41;
        UpdateOp r113 = obtainUpdateOp(r110.cmd, r101, r106, r109);
        dispatchFirstPassAndUpdateViewHolders(r113, r102);
        recycleUpdateOp(r113);
        return;
    L41:
        return;
    L11:
        throw new IllegalArgumentException("op should be remove or update." + r110);
    L12:
        r104 = 0;
    L37:
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    private void postponeAndUpdateViewHolders(UpdateOp r100) {
        this.mPostponedList.add(r100);
        int r101 = r100.cmd;
        if (r101 != 1) goto L5;
        this.mCallback.offsetPositionsForAdd(r100.positionStart, r100.itemCount);
        return;
    L5:
        if (r101 != 2) goto L7;
        this.mCallback.offsetPositionsForRemovingLaidOutOrNewView(r100.positionStart, r100.itemCount);
        return;
    L7:
        if (r101 != 4) goto L9;
        this.mCallback.markViewHoldersUpdated(r100.positionStart, r100.itemCount, r100.payload);
        return;
    L9:
        if (r101 != 8) goto L12;
        this.mCallback.offsetPositionsForMove(r100.positionStart, r100.itemCount);
        return;
    L12:
        throw new IllegalArgumentException("Unknown update op type for " + r100);
    }

    public AdapterHelper addUpdateOp(UpdateOp... r100) {
        Collections.addAll(this.mPendingUpdates, r100);
        return this;
    }

    public int applyPendingUpdatesToPosition(int r100) {
        int r101 = this.mPendingUpdates.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L30;
        UpdateOp r103 = (UpdateOp) ListProtector.get(this.mPendingUpdates, r102);
        int r104 = r103.cmd;
        if (r104 == 1) goto L27;
        if (r104 != 2) goto L9;
        int r105 = r103.positionStart;
        if (r105 > r100) goto L29;
        int r106 = r103.itemCount;
        if ((r105 + r106) > r100) goto L23;
        r100 = r100 - r106;
        goto L29
    L23:
        return -1;
    L29:
        r102 = r102 + 1;
        goto L3
    L9:
        if (r104 != 8) goto L29;
        int r107 = r103.positionStart;
        if (r107 != r100) goto L14;
        r100 = r103.itemCount;
        goto L29
    L14:
        if (r107 >= r100) goto L17;
        r100 = r100 - 1;
    L17:
        if (r103.itemCount > r100) goto L29;
        r100 = r100 + 1;
        goto L29
    L27:
        if (r103.positionStart > r100) goto L29;
        r100 = r100 + r103.itemCount;
        goto L29
    L30:
        return r100;
    }

    public int findPositionOffset(int r100) {
        return findPositionOffset(r100, 0);
    }

    public boolean hasAnyUpdateTypes(int r100) {
        if ((r100 & this.mExistingUpdateTypes) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public void recycleUpdateOp(UpdateOp r100) {
        if (this.mDisableRecycler == true) goto L6;
        r100.payload = null;
        this.mUpdateOpPool.release(r100);
        return;
    }

    public void recycleUpdateOpsAndClearList(List<UpdateOp> r100) {
        int r101 = r100.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        recycleUpdateOp((UpdateOp) ListProtector.get(r100, r102));
        r102 = r102 + 1;
        goto L3
    L5:
        r100.clear();
    }

    public AdapterHelper(Callback r100, boolean r101) {
        this.mUpdateOpPool = new Pools.SimplePool(30);
        this.mPendingUpdates = new ArrayList();
        this.mPostponedList = new ArrayList();
        this.mExistingUpdateTypes = 0;
        this.mCallback = r100;
        this.mDisableRecycler = r101;
        this.mOpReorderer = new OpReorderer(this);
    }

    private int updatePositionWithPostponed(int r100, int r110) {
        int r101 = this.mPostponedList.size() - 1;
    L4:
        if (r101 < 0) goto L40;
        UpdateOp r102 = (UpdateOp) ListProtector.get(this.mPostponedList, r101);
        int r103 = r102.cmd;
        if (r103 != 8) goto L29;
        int r104 = r102.positionStart;
        int r105 = r102.itemCount;
        if (r104 >= r105) goto L10;
        int r106 = r104;
        int r107 = r105;
    L11:
        if (r100 < r106) goto L24;
        if (r100 > r107) goto L24;
        if (r106 != r104) goto L19;
        if (r110 != 1) goto L16;
        r102.itemCount = r105 + 1;
    L18:
        r100 = r100 + 1;
    L39:
        r101 = r101 - 1;
        goto L4
    L16:
        if (r110 != 2) goto L18;
        r102.itemCount = r105 - 1;
        goto L18
    L19:
        if (r110 != 1) goto L21;
        r102.positionStart = r104 + 1;
    L23:
        r100 = r100 - 1;
        goto L39
    L21:
        if (r110 != 2) goto L23;
        r102.positionStart = r104 - 1;
    L24:
        if (r100 >= r104) goto L39;
        if (r110 != 1) goto L27;
        r102.positionStart = r104 + 1;
        r102.itemCount = r105 + 1;
        goto L39
    L27:
        if (r110 != 2) goto L39;
        r102.positionStart = r104 - 1;
        r102.itemCount = r105 - 1;
        goto L39
    L10:
        r107 = r104;
        r106 = r105;
        goto L11
    L29:
        int r108 = r102.positionStart;
        if (r108 > r100) goto L35;
        if (r103 != 1) goto L33;
        r100 = r100 - r102.itemCount;
        goto L39
    L33:
        if (r103 != 2) goto L39;
        r100 = r100 + r102.itemCount;
        goto L39
    L35:
        if (r110 != 1) goto L37;
        r102.positionStart = r108 + 1;
        goto L39
    L37:
        if (r110 != 2) goto L39;
        r102.positionStart = r108 - 1;
        goto L39
    L40:
        int r111 = this.mPostponedList.size() - 1;
    L41:
        if (r111 < 0) goto L52;
        UpdateOp r109 = (UpdateOp) ListProtector.get(this.mPostponedList, r111);
        if (r109.cmd != 8) goto L49;
        int r112 = r109.itemCount;
        if (r112 == r109.positionStart) goto L47;
        if (r112 < 0) goto L47;
    L51:
        r111 = r111 - 1;
    L47:
        ListProtector.remove(this.mPostponedList, r111);
        recycleUpdateOp(r109);
        goto L51
    L49:
        if (r109.itemCount > 0) goto L51;
        ListProtector.remove(this.mPostponedList, r111);
        recycleUpdateOp(r109);
        goto L51
    L52:
        return r100;
    }

    public void dispatchFirstPassAndUpdateViewHolders(UpdateOp r100, int r101) {
        this.mCallback.onDispatchFirstPass(r100);
        int r102 = r100.cmd;
        if (r102 != 2) goto L5;
        this.mCallback.offsetPositionsForRemovingInvisible(r101, r100.itemCount);
        return;
    L5:
        if (r102 != 4) goto L8;
        this.mCallback.markViewHoldersUpdated(r101, r100.itemCount, r100.payload);
        return;
    L8:
        throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
    }

    public int findPositionOffset(int r100, int r101) {
        int r102 = this.mPostponedList.size();
    L3:
        if (r101 >= r102) goto L27;
        UpdateOp r103 = (UpdateOp) ListProtector.get(this.mPostponedList, r101);
        int r104 = r103.cmd;
        if (r104 != 8) goto L14;
        int r105 = r103.positionStart;
        if (r105 != r100) goto L9;
        r100 = r103.itemCount;
    L26:
        r101 = r101 + 1;
        goto L3
    L9:
        if (r105 >= r100) goto L12;
        r100 = r100 - 1;
    L12:
        if (r103.itemCount > r100) goto L26;
        r100 = r100 + 1;
        goto L26
    L14:
        int r106 = r103.positionStart;
        if (r106 > r100) goto L26;
        if (r104 != 2) goto L24;
        int r107 = r103.itemCount;
        if (r100 < (r106 + r107)) goto L20;
        r100 = r100 - r107;
        goto L26
    L20:
        return -1;
    L24:
        if (r104 != 1) goto L26;
        r100 = r100 + r103.itemCount;
        goto L26
    L27:
        return r100;
    }

    public boolean onItemRangeInserted(int r100, int r101) {
        if (r101 >= 1) goto L5;
        return false;
    L5:
        this.mPendingUpdates.add(obtainUpdateOp(1, r100, r101, null));
        this.mExistingUpdateTypes |= 1;
        if (this.mPendingUpdates.size() != 1) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean onItemRangeRemoved(int r100, int r101) {
        if (r101 >= 1) goto L5;
        return false;
    L5:
        this.mPendingUpdates.add(obtainUpdateOp(2, r100, r101, null));
        this.mExistingUpdateTypes |= 2;
        if (this.mPendingUpdates.size() != 1) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean onItemRangeChanged(int r100, int r101, Object r102) {
        if (r101 >= 1) goto L5;
        return false;
    L5:
        this.mPendingUpdates.add(obtainUpdateOp(4, r100, r101, r102));
        this.mExistingUpdateTypes |= 4;
        if (this.mPendingUpdates.size() != 1) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean onItemRangeMoved(int r100, int r101, int r102) {
        if (r100 != r101) goto L6;
        return false;
    L6:
        if (r102 != 1) goto L12;
        this.mPendingUpdates.add(obtainUpdateOp(8, r100, r101, null));
        this.mExistingUpdateTypes |= 8;
        if (this.mPendingUpdates.size() != 1) goto L13;
        return true;
    L13:
        return false;
    L12:
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    @Override // androidx.recyclerview.widget.OpReorderer.Callback
    public UpdateOp obtainUpdateOp(int r100, int r101, int r102, Object r103) {
        UpdateOp r104 = this.mUpdateOpPool.acquire();
        if (r104 == null) goto L7;
        r104.cmd = r100;
        r104.positionStart = r101;
        r104.itemCount = r102;
        r104.payload = r103;
        return r104;
    L7:
        return new UpdateOp(r100, r101, r102, r103);
    }
}
