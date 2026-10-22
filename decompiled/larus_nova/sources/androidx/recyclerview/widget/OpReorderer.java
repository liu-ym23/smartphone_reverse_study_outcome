package androidx.recyclerview.widget;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class OpReorderer {
    final Callback mCallback;

    public interface Callback {
        AdapterHelper.UpdateOp obtainUpdateOp(int r100, int r101, int r102, Object r103);

        void recycleUpdateOp(AdapterHelper.UpdateOp r100);
    }

    public OpReorderer(Callback r100) {
        this.mCallback = r100;
    }

    private int getLastMoveOutOfOrder(List<AdapterHelper.UpdateOp> r100) {
        int r101 = r100.size() - 1;
        boolean r102 = false;
    L3:
        if (r101 < 0) goto L10;
        if (((AdapterHelper.UpdateOp) ListProtector.get(r100, r101)).cmd != 8) goto L8;
        if (r102 == false) goto L9;
        return r101;
    L9:
        r101 = r101 - 1;
        goto L3
    L8:
        r102 = true;
        goto L9
    L10:
        return -1;
    }

    public void reorderOps(List<AdapterHelper.UpdateOp> r100) {
    L2:
        int r101 = getLastMoveOutOfOrder(r100);
        if (r101 == (-1)) goto L5;
        swapMoveOp(r100, r101, r101 + 1);
        goto L2
    }

    private void swapMoveOp(List<AdapterHelper.UpdateOp> r100, int r101, int r110) {
        AdapterHelper.UpdateOp r102 = (AdapterHelper.UpdateOp) ListProtector.get(r100, r101);
        AdapterHelper.UpdateOp r103 = (AdapterHelper.UpdateOp) ListProtector.get(r100, r110);
        int r104 = r103.cmd;
        if (r104 != 1) goto L5;
        swapMoveAdd(r100, r101, r102, r110, r103);
        return;
    L5:
        if (r104 != 2) goto L7;
        swapMoveRemove(r100, r101, r102, r110, r103);
        return;
    L7:
        if (r104 != 4) goto L15;
        swapMoveUpdate(r100, r101, r102, r110, r103);
        return;
    }

    private void swapMoveAdd(List<AdapterHelper.UpdateOp> r100, int r101, AdapterHelper.UpdateOp r102, int r103, AdapterHelper.UpdateOp r104) {
        int r105 = r102.itemCount;
        int r106 = r104.positionStart;
        if (r105 >= r106) goto L5;
        int r107 = -1;
    L6:
        int r108 = r102.positionStart;
        if (r108 >= r106) goto L9;
        r107 = r107 + 1;
    L9:
        if (r106 > r108) goto L11;
        r102.positionStart = r108 + r104.itemCount;
    L11:
        int r109 = r104.positionStart;
        if (r109 > r105) goto L14;
        r102.itemCount = r105 + r104.itemCount;
    L14:
        r104.positionStart = r109 + r107;
        ListProtector.set(r100, r101, r104);
        ListProtector.set(r100, r103, r102);
        return;
    L5:
        r107 = 0;
        goto L6
    }

    public void swapMoveRemove(List<AdapterHelper.UpdateOp> r110, int r111, AdapterHelper.UpdateOp r112, int r113, AdapterHelper.UpdateOp r114) {
        int r100 = r112.positionStart;
        int r101 = r112.itemCount;
        boolean r102 = false;
        if (r100 >= r101) goto L11;
        if (r114.positionStart == r100) goto L7;
    L9:
        boolean r103 = false;
    L17:
        int r104 = r114.positionStart;
        if (r101 >= r104) goto L20;
        r114.positionStart = r104 - 1;
    L26:
        int r105 = r112.positionStart;
        int r106 = r114.positionStart;
        AdapterHelper.UpdateOp r107 = null;
        if (r105 > r106) goto L29;
        r114.positionStart = r106 + 1;
    L32:
        if (r102 == false) goto L35;
        ListProtector.set(r110, r111, r114);
        ListProtector.remove(r110, r113);
        this.mCallback.recycleUpdateOp(r112);
        return;
    L35:
        if (r103 == false) goto L49;
        if (r107 == null) goto L43;
        int r108 = r112.positionStart;
        if (r108 <= r107.positionStart) goto L40;
        r112.positionStart = r108 - r107.itemCount;
    L40:
        int r109 = r112.itemCount;
        if (r109 <= r107.positionStart) goto L43;
        r112.itemCount = r109 - r107.itemCount;
    L43:
        int r115 = r112.positionStart;
        if (r115 <= r114.positionStart) goto L46;
        r112.positionStart = r115 - r114.itemCount;
    L46:
        int r116 = r112.itemCount;
        if (r116 <= r114.positionStart) goto L62;
        r112.itemCount = r116 - r114.itemCount;
    L62:
        ListProtector.set(r110, r111, r114);
        if (r112.positionStart == r112.itemCount) goto L65;
        ListProtector.set(r110, r113, r112);
    L66:
        if (r107 == null) goto L70;
        ListProtector.add(r110, r111, r107);
        return;
    L70:
        return;
    L65:
        ListProtector.remove(r110, r113);
        goto L66
    L49:
        if (r107 == null) goto L56;
        int r117 = r112.positionStart;
        if (r117 < r107.positionStart) goto L53;
        r112.positionStart = r117 - r107.itemCount;
    L53:
        int r118 = r112.itemCount;
        if (r118 < r107.positionStart) goto L56;
        r112.itemCount = r118 - r107.itemCount;
    L56:
        int r119 = r112.positionStart;
        if (r119 < r114.positionStart) goto L59;
        r112.positionStart = r119 - r114.itemCount;
    L59:
        int r120 = r112.itemCount;
        if (r120 < r114.positionStart) goto L62;
        r112.itemCount = r120 - r114.itemCount;
        goto L62
    L29:
        int r121 = r114.itemCount;
        if (r105 >= (r106 + r121)) goto L32;
        int r122 = (r106 + r121) - r105;
        r107 = this.mCallback.obtainUpdateOp(2, r105 + 1, r122, null);
        r114.itemCount = r112.positionStart - r114.positionStart;
        goto L32
    L20:
        int r123 = r114.itemCount;
        if (r101 >= (r104 + r123)) goto L26;
        r114.itemCount = r123 - 1;
        r112.cmd = 2;
        r112.itemCount = 1;
        if (r114.itemCount != 0) goto L69;
        ListProtector.remove(r110, r113);
        this.mCallback.recycleUpdateOp(r114);
        return;
    L69:
        return;
    L7:
        if (r114.itemCount != (r101 - r100)) goto L9;
        r103 = false;
    L15:
        r102 = true;
        goto L17
    L11:
        if (r114.positionStart == (r101 + 1)) goto L13;
    L16:
        r103 = true;
        goto L17
    L13:
        if (r114.itemCount != (r100 - r101)) goto L16;
        r103 = true;
        goto L15
    }

    public void swapMoveUpdate(List<AdapterHelper.UpdateOp> r100, int r110, AdapterHelper.UpdateOp r111, int r112, AdapterHelper.UpdateOp r113) {
        int r101 = r111.itemCount;
        int r102 = r113.positionStart;
        AdapterHelper.UpdateOp r103 = null;
        if (r101 >= r102) goto L5;
        r113.positionStart = r102 - 1;
    L8:
        AdapterHelper.UpdateOp r104 = null;
    L9:
        int r105 = r111.positionStart;
        int r106 = r113.positionStart;
        if (r105 > r106) goto L12;
        r113.positionStart = r106 + 1;
    L15:
        ListProtector.set(r100, r112, r111);
        if (r113.itemCount <= 0) goto L18;
        ListProtector.set(r100, r110, r113);
    L19:
        if (r104 == null) goto L21;
        ListProtector.add(r100, r110, r104);
    L21:
        if (r103 == null) goto L24;
        ListProtector.add(r100, r110, r103);
        return;
    L24:
        return;
    L18:
        ListProtector.remove(r100, r110);
        this.mCallback.recycleUpdateOp(r113);
        goto L19
    L12:
        int r107 = r113.itemCount;
        if (r105 >= (r106 + r107)) goto L15;
        int r108 = (r106 + r107) - r105;
        r103 = this.mCallback.obtainUpdateOp(4, r105 + 1, r108, r113.payload);
        r113.itemCount -= r108;
        goto L15
    L5:
        int r109 = r113.itemCount;
        if (r101 >= (r102 + r109)) goto L8;
        r113.itemCount = r109 - 1;
        r104 = this.mCallback.obtainUpdateOp(4, r111.positionStart, 1, r113.payload);
        goto L9
    }
}
