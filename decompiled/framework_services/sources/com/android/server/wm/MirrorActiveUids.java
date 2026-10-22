package com.android.server.wm;

import android.util.SparseArray;
import android.util.SparseIntArray;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
class MirrorActiveUids {
    private final SparseIntArray mNumNonAppVisibleWindowMap;
    private final SparseArray<SparseIntArray> mNumNonAppVisibleWindowMapByType;
    private final SparseIntArray mUidStates;

    MirrorActiveUids() {
        this.mUidStates = new SparseIntArray();
        this.mNumNonAppVisibleWindowMap = new SparseIntArray();
        this.mNumNonAppVisibleWindowMapByType = new SparseArray();
    }

    synchronized void onUidActive(int uid, int procState) {
        monitor-enter(this);
        this.mUidStates.put(uid, procState);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void onUidInactive(int uid) {
        monitor-enter(this);
        this.mUidStates.delete(uid);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void onUidProcStateChanged(int uid, int procState) {
        monitor-enter(this);
        int index = this.mUidStates.indexOfKey(uid);     // Catch: Throwable -> L7
        if (index < 0) goto L9;
        this.mUidStates.setValueAt(index, procState);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    synchronized int getUidState(int uid) {
        monitor-enter(this);
        int r0 = this.mUidStates.get(uid, 20);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized void onNonAppSurfaceVisibilityChanged(int uid, int type, boolean visible) {
        monitor-enter(this);
        updateCount(uid, visible, this.mNumNonAppVisibleWindowMap);     // Catch: Throwable -> L6
        updateCount(uid, visible, getNumNonAppVisibleWindowMapByType(type));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private SparseIntArray getNumNonAppVisibleWindowMapByType(int type) {
        SparseIntArray result = this.mNumNonAppVisibleWindowMapByType.get(type);
        if (result != null) goto L6;
        SparseIntArray result2 = new SparseIntArray();
        this.mNumNonAppVisibleWindowMapByType.append(type, result2);
        return result2;
    L6:
        return result;
    }

    private void updateCount(int uid, boolean visible, SparseIntArray numNonAppVisibleWindowMap) {
        int index = numNonAppVisibleWindowMap.indexOfKey(uid);
        int r1 = 1;
        if (index < 0) goto L13;
        int r2 = numNonAppVisibleWindowMap.valueAt(index);
        if (visible == true) goto L8;
        r1 = -1;
    L8:
        int num = r2 + r1;
        if (num <= 0) goto L11;
        numNonAppVisibleWindowMap.setValueAt(index, num);
        return;
    L11:
        numNonAppVisibleWindowMap.removeAt(index);
        return;
    L13:
        if (visible == false) goto L18;
        numNonAppVisibleWindowMap.append(uid, 1);
        return;
    }

    synchronized boolean hasNonAppVisibleWindow(int uid) {
        monitor-enter(this);
        if (this.mNumNonAppVisibleWindowMap.get(uid) <= 0) goto L6;
        boolean r0 = true;
    L7:
        monitor-exit(this);
        return r0;
    L6:
        r0 = false;
    L9:
        th = move-exception;
        throw th;
    }

    synchronized SparseIntArray getNonAppVisibleWindowDetails(int uid) {
        monitor-enter(this);
        SparseIntArray result = new SparseIntArray();     // Catch: Throwable -> L10
        int i = 0;
    L5:
        if (i >= this.mNumNonAppVisibleWindowMapByType.size()) goto L14;
        SparseIntArray numNonAppVisibleWindowMap = this.mNumNonAppVisibleWindowMapByType.valueAt(i);     // Catch: Throwable -> L10
        int count = numNonAppVisibleWindowMap.get(uid);     // Catch: Throwable -> L10
        if (count <= 0) goto L12;
        result.append(this.mNumNonAppVisibleWindowMapByType.keyAt(i), count);     // Catch: Throwable -> L10
    L12:
        i = i + 1;
        goto L5
    L14:
        monitor-exit(this);
        return result;
    L10:
        th = move-exception;
        throw th;
    }

    synchronized void dump(PrintWriter pw, String prefix) {
        monitor-enter(this);
        pw.print(prefix + "NumNonAppVisibleWindowUidMap:[");     // Catch: Throwable -> L6
        int i = this.mNumNonAppVisibleWindowMap.size() + (-1);     // Catch: Throwable -> L6
    L4:
        if (i < 0) goto L8;
        pw.print(" " + this.mNumNonAppVisibleWindowMap.keyAt(i) + ":" + this.mNumNonAppVisibleWindowMap.valueAt(i));     // Catch: Throwable -> L6
        i = i + (-1);     // Catch: Throwable -> L6
        goto L4
    L8:
        pw.println("]");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
