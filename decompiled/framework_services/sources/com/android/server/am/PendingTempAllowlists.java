package com.android.server.am;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
final class PendingTempAllowlists {
    private final SparseArray<ActivityManagerService.PendingTempAllowlist> mPendingTempAllowlist;
    private ActivityManagerService mService;

    PendingTempAllowlists(ActivityManagerService service) {
        this.mPendingTempAllowlist = new SparseArray();
        this.mService = service;
    }

    void put(int uid, ActivityManagerService.PendingTempAllowlist value) {
        SparseArray<ActivityManagerService.PendingTempAllowlist> r0 = this.mPendingTempAllowlist;
        monitor-enter(r0);
        this.mPendingTempAllowlist.put(uid, value);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void removeAt(int index) {
        SparseArray<ActivityManagerService.PendingTempAllowlist> r0 = this.mPendingTempAllowlist;
        monitor-enter(r0);
        this.mPendingTempAllowlist.removeAt(index);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    ActivityManagerService.PendingTempAllowlist get(int uid) {
        SparseArray<ActivityManagerService.PendingTempAllowlist> r0 = this.mPendingTempAllowlist;
        monitor-enter(r0);
        ActivityManagerService.PendingTempAllowlist r1 = this.mPendingTempAllowlist.get(uid);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    int size() {
        SparseArray<ActivityManagerService.PendingTempAllowlist> r0 = this.mPendingTempAllowlist;
        monitor-enter(r0);
        int r1 = this.mPendingTempAllowlist.size();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    ActivityManagerService.PendingTempAllowlist valueAt(int index) {
        SparseArray<ActivityManagerService.PendingTempAllowlist> r0 = this.mPendingTempAllowlist;
        monitor-enter(r0);
        ActivityManagerService.PendingTempAllowlist r1 = this.mPendingTempAllowlist.valueAt(index);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    int indexOfKey(int key) {
        SparseArray<ActivityManagerService.PendingTempAllowlist> r0 = this.mPendingTempAllowlist;
        monitor-enter(r0);
        int r1 = this.mPendingTempAllowlist.indexOfKey(key);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
