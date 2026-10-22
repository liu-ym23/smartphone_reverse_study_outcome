package com.android.server.wm;

import android.window.TaskSnapshot;

/* JADX INFO: loaded from: classes3.dex */
class ActivitySnapshotCache extends SnapshotCache<ActivityRecord> {
    @Override // com.android.server.wm.SnapshotCache
    /* bridge */ /* synthetic */ void putSnapshot(WindowContainer r1, TaskSnapshot r2) {
        putSnapshot((ActivityRecord) r1, r2);
    }

    ActivitySnapshotCache() {
        super("Activity");
    }

    void putSnapshot(ActivityRecord ar, TaskSnapshot snapshot) {
        int hasCode = System.identityHashCode(ar);
        snapshot.addReference(2);
        snapshot.setSafeRelease(this.mSafeSnapshotReleaser);
        Object r2 = this.mLock;
        monitor-enter(r2);
        SnapshotCache.CacheEntry entry = this.mRunningCache.get(Integer.valueOf(hasCode));     // Catch: Throwable -> L7
        if (entry == null) goto L9;
        this.mAppIdMap.remove(entry.topApp);     // Catch: Throwable -> L7
        entry.snapshot.removeReference(2);     // Catch: Throwable -> L7
    L9:
        this.mAppIdMap.put(ar, Integer.valueOf(hasCode));     // Catch: Throwable -> L7
        this.mRunningCache.put(Integer.valueOf(hasCode), new SnapshotCache.CacheEntry(snapshot, ar));     // Catch: Throwable -> L7
        monitor-exit(r2);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
