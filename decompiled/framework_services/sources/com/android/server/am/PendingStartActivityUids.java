package com.android.server.am;

import android.os.SystemClock;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
final class PendingStartActivityUids {
    public static final long INVALID_TIME = 0;
    static final String TAG = "ActivityManager";
    private final SparseArray<Pair<Integer, Long>> mPendingUids;

    PendingStartActivityUids() {
        this.mPendingUids = new SparseArray();
    }

    synchronized boolean add(int uid, int pid) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mPendingUids.get(uid) != null) goto L11;
        this.mPendingUids.put(uid, new Pair(Integer.valueOf(pid), Long.valueOf(SystemClock.elapsedRealtime())));     // Catch: Throwable -> L9
        monitor-exit(this);
        return true;
    L11:
        monitor-exit(this);
        return false;
    }

    synchronized void delete(int uid, long nowElapsed) {
        monitor-enter(this);
        Pair<Integer, Long> pendingPid = this.mPendingUids.get(uid);     // Catch: Throwable -> L10
        if (pendingPid != null) goto L6;
    L16:
        monitor-exit(this);
        return;
    L6:
        if (nowElapsed >= ((Long) pendingPid.second).longValue()) goto L12;
        Slog.i(TAG, "updateOomAdj start time is before than pendingPid added, don't delete it");     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L12:
        long delay = SystemClock.elapsedRealtime() - ((Long) pendingPid.second).longValue();     // Catch: Throwable -> L10
        if (delay < 1000) goto L15;
        Slog.i(TAG, "PendingStartActivityUids startActivity to updateOomAdj delay:" + delay + "ms, uid:" + uid);     // Catch: Throwable -> L10
    L15:
        this.mPendingUids.delete(uid);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    synchronized long getPendingTopPidTime(int uid, int pid) {
        monitor-enter(this);
        long ret = 0;
        Pair<Integer, Long> pendingPid = this.mPendingUids.get(uid);     // Catch: Throwable -> L10
        if (pendingPid != null) goto L7;
    L12:
        monitor-exit(this);
        return ret;
    L7:
        if (((Integer) pendingPid.first).intValue() != pid) goto L12;
        ret = ((Long) pendingPid.second).longValue();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    synchronized boolean isPendingTopUid(int uid) {
        monitor-enter(this);
        if (this.mPendingUids.get(uid) == null) goto L6;
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

    synchronized void enqueuePendingTopAppIfNecessaryLocked(ActivityManagerService ams) {
        monitor-enter(this);
        int i = 0;
        int size = this.mPendingUids.size();     // Catch: Throwable -> L13
    L5:
        if (i >= size) goto L20;
        Pair<Integer, Long> p = this.mPendingUids.valueAt(i);     // Catch: Throwable -> L13
        ActivityManagerService.PidMap r3 = ams.mPidsSelfLocked;     // Catch: Throwable -> L13
        monitor-enter(r3);     // Catch: Throwable -> L13
        ProcessRecord app = ams.mPidsSelfLocked.get(((Integer) p.first).intValue());     // Catch: Throwable -> L16
        monitor-exit(r3);     // Catch: Throwable -> L16
        if (app == null) goto L15;
        ams.enqueueOomAdjTargetLocked(app);     // Catch: Throwable -> L13
    L15:
        i = i + 1;
        goto L5
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L20:
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    synchronized void clear() {
        monitor-enter(this);
        this.mPendingUids.clear();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
