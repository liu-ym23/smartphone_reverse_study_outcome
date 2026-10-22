package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper;
import java.util.List;

/* loaded from: classes.dex */
class OpReorderer {
    final Callback mCallback;

    interface Callback {
        AdapterHelper.UpdateOp obtainUpdateOp(int i5, int i6, int i7, Object obj);

        void recycleUpdateOp(AdapterHelper.UpdateOp updateOp);
    }

    OpReorderer(Callback callback) {
        this.mCallback = callback;
    }

    private int getLastMoveOutOfOrder(List<AdapterHelper.UpdateOp> list) {
        boolean z5 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).cmd != 8) {
                z5 = true;
            } else if (z5) {
                return size;
            }
        }
        return -1;
    }

    private void swapMoveAdd(List<AdapterHelper.UpdateOp> list, int i5, AdapterHelper.UpdateOp updateOp, int i6, AdapterHelper.UpdateOp updateOp2) {
        int i7 = updateOp.itemCount;
        int i8 = updateOp2.positionStart;
        int i9 = i7 < i8 ? -1 : 0;
        int i10 = updateOp.positionStart;
        if (i10 < i8) {
            i9++;
        }
        if (i8 <= i10) {
            updateOp.positionStart = i10 + updateOp2.itemCount;
        }
        int i11 = updateOp2.positionStart;
        if (i11 <= i7) {
            updateOp.itemCount = i7 + updateOp2.itemCount;
        }
        updateOp2.positionStart = i11 + i9;
        list.set(i5, updateOp2);
        list.set(i6, updateOp);
    }

    private void swapMoveOp(List<AdapterHelper.UpdateOp> list, int i5, int i6) {
        AdapterHelper.UpdateOp updateOp = list.get(i5);
        AdapterHelper.UpdateOp updateOp2 = list.get(i6);
        int i7 = updateOp2.cmd;
        if (i7 == 1) {
            swapMoveAdd(list, i5, updateOp, i6, updateOp2);
        } else if (i7 == 2) {
            swapMoveRemove(list, i5, updateOp, i6, updateOp2);
        } else {
            if (i7 != 4) {
                return;
            }
            swapMoveUpdate(list, i5, updateOp, i6, updateOp2);
        }
    }

    void reorderOps(List<AdapterHelper.UpdateOp> list) {
        while (true) {
            int lastMoveOutOfOrder = getLastMoveOutOfOrder(list);
            if (lastMoveOutOfOrder == -1) {
                return;
            } else {
                swapMoveOp(list, lastMoveOutOfOrder, lastMoveOutOfOrder + 1);
            }
        }
    }

    void swapMoveRemove(List<AdapterHelper.UpdateOp> list, int i5, AdapterHelper.UpdateOp updateOp, int i6, AdapterHelper.UpdateOp updateOp2) {
        boolean z5;
        int i7 = updateOp.positionStart;
        int i8 = updateOp.itemCount;
        boolean z6 = false;
        if (i7 < i8) {
            if (updateOp2.positionStart == i7 && updateOp2.itemCount == i8 - i7) {
                z5 = false;
                z6 = true;
            } else {
                z5 = false;
            }
        } else if (updateOp2.positionStart == i8 + 1 && updateOp2.itemCount == i7 - i8) {
            z5 = true;
            z6 = true;
        } else {
            z5 = true;
        }
        int i9 = updateOp2.positionStart;
        if (i8 < i9) {
            updateOp2.positionStart = i9 - 1;
        } else {
            int i10 = updateOp2.itemCount;
            if (i8 < i9 + i10) {
                updateOp2.itemCount = i10 - 1;
                updateOp.cmd = 2;
                updateOp.itemCount = 1;
                if (updateOp2.itemCount == 0) {
                    list.remove(i6);
                    this.mCallback.recycleUpdateOp(updateOp2);
                    return;
                }
                return;
            }
        }
        int i11 = updateOp.positionStart;
        int i12 = updateOp2.positionStart;
        AdapterHelper.UpdateOp updateOpObtainUpdateOp = null;
        if (i11 <= i12) {
            updateOp2.positionStart = i12 + 1;
        } else {
            int i13 = updateOp2.itemCount;
            if (i11 < i12 + i13) {
                updateOpObtainUpdateOp = this.mCallback.obtainUpdateOp(2, i11 + 1, (i12 + i13) - i11, null);
                updateOp2.itemCount = updateOp.positionStart - updateOp2.positionStart;
            }
        }
        if (z6) {
            list.set(i5, updateOp2);
            list.remove(i6);
            this.mCallback.recycleUpdateOp(updateOp);
            return;
        }
        if (z5) {
            if (updateOpObtainUpdateOp != null) {
                int i14 = updateOp.positionStart;
                if (i14 > updateOpObtainUpdateOp.positionStart) {
                    updateOp.positionStart = i14 - updateOpObtainUpdateOp.itemCount;
                }
                int i15 = updateOp.itemCount;
                if (i15 > updateOpObtainUpdateOp.positionStart) {
                    updateOp.itemCount = i15 - updateOpObtainUpdateOp.itemCount;
                }
            }
            int i16 = updateOp.positionStart;
            if (i16 > updateOp2.positionStart) {
                updateOp.positionStart = i16 - updateOp2.itemCount;
            }
            int i17 = updateOp.itemCount;
            if (i17 > updateOp2.positionStart) {
                updateOp.itemCount = i17 - updateOp2.itemCount;
            }
        } else {
            if (updateOpObtainUpdateOp != null) {
                int i18 = updateOp.positionStart;
                if (i18 >= updateOpObtainUpdateOp.positionStart) {
                    updateOp.positionStart = i18 - updateOpObtainUpdateOp.itemCount;
                }
                int i19 = updateOp.itemCount;
                if (i19 >= updateOpObtainUpdateOp.positionStart) {
                    updateOp.itemCount = i19 - updateOpObtainUpdateOp.itemCount;
                }
            }
            int i20 = updateOp.positionStart;
            if (i20 >= updateOp2.positionStart) {
                updateOp.positionStart = i20 - updateOp2.itemCount;
            }
            int i21 = updateOp.itemCount;
            if (i21 >= updateOp2.positionStart) {
                updateOp.itemCount = i21 - updateOp2.itemCount;
            }
        }
        list.set(i5, updateOp2);
        if (updateOp.positionStart != updateOp.itemCount) {
            list.set(i6, updateOp);
        } else {
            list.remove(i6);
        }
        if (updateOpObtainUpdateOp != null) {
            list.add(i5, updateOpObtainUpdateOp);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void swapMoveUpdate(java.util.List<androidx.recyclerview.widget.AdapterHelper.UpdateOp> r9, int r10, androidx.recyclerview.widget.AdapterHelper.UpdateOp r11, int r12, androidx.recyclerview.widget.AdapterHelper.UpdateOp r13) {
        /*
            r8 = this;
            int r0 = r11.itemCount
            int r1 = r13.positionStart
            r2 = 4
            r3 = 1
            r4 = 0
            if (r0 >= r1) goto Ld
            int r1 = r1 - r3
            r13.positionStart = r1
            goto L20
        Ld:
            int r5 = r13.itemCount
            int r1 = r1 + r5
            if (r0 >= r1) goto L20
            int r5 = r5 - r3
            r13.itemCount = r5
            androidx.recyclerview.widget.OpReorderer$Callback r0 = r8.mCallback
            int r1 = r11.positionStart
            java.lang.Object r5 = r13.payload
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r0 = r0.obtainUpdateOp(r2, r1, r3, r5)
            goto L21
        L20:
            r0 = r4
        L21:
            int r1 = r11.positionStart
            int r5 = r13.positionStart
            if (r1 > r5) goto L2b
            int r5 = r5 + r3
            r13.positionStart = r5
            goto L41
        L2b:
            int r6 = r13.itemCount
            int r7 = r5 + r6
            if (r1 >= r7) goto L41
            int r5 = r5 + r6
            int r5 = r5 - r1
            androidx.recyclerview.widget.OpReorderer$Callback r4 = r8.mCallback
            int r1 = r1 + r3
            java.lang.Object r3 = r13.payload
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r4 = r4.obtainUpdateOp(r2, r1, r5, r3)
            int r1 = r13.itemCount
            int r1 = r1 - r5
            r13.itemCount = r1
        L41:
            r9.set(r12, r11)
            int r11 = r13.itemCount
            if (r11 <= 0) goto L4c
            r9.set(r10, r13)
            goto L54
        L4c:
            r9.remove(r10)
            androidx.recyclerview.widget.OpReorderer$Callback r8 = r8.mCallback
            r8.recycleUpdateOp(r13)
        L54:
            if (r0 == 0) goto L59
            r9.add(r10, r0)
        L59:
            if (r4 == 0) goto L5e
            r9.add(r10, r4)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.OpReorderer.swapMoveUpdate(java.util.List, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp):void");
    }
}
