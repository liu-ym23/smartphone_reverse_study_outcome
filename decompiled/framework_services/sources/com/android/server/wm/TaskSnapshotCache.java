package com.android.server.wm;

import android.window.TaskSnapshot;

/* JADX INFO: loaded from: classes3.dex */
class TaskSnapshotCache extends SnapshotCache<Task> {
    private final AppSnapshotLoader mLoader;

    @Override // com.android.server.wm.SnapshotCache
    /* bridge */ /* synthetic */ void putSnapshot(WindowContainer r1, TaskSnapshot r2) {
        putSnapshot((Task) r1, r2);
    }

    TaskSnapshotCache(AppSnapshotLoader loader) {
        super("Task");
        this.mLoader = loader;
    }

    void putSnapshot(Task task, TaskSnapshot snapshot) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        snapshot.addReference(2);     // Catch: Throwable -> L8
        snapshot.setSafeRelease(this.mSafeSnapshotReleaser);     // Catch: Throwable -> L8
        SnapshotCache.CacheEntry entry = this.mRunningCache.get(Integer.valueOf(task.mTaskId));     // Catch: Throwable -> L8
        if (entry == null) goto L10;
        this.mAppIdMap.remove(entry.topApp);     // Catch: Throwable -> L8
        entry.snapshot.removeReference(2);     // Catch: Throwable -> L8
    L10:
        ActivityRecord top = task.getTopMostActivity();     // Catch: Throwable -> L8
        this.mAppIdMap.put(top, Integer.valueOf(task.mTaskId));     // Catch: Throwable -> L8
        this.mRunningCache.put(Integer.valueOf(task.mTaskId), new SnapshotCache.CacheEntry(snapshot, top));     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    TaskSnapshot getSnapshot(int taskId, boolean isLowResolution) {
        return getSnapshot(taskId, isLowResolution, 0);
    }

    TaskSnapshot getSnapshot(int taskId, boolean isLowResolution, int usage) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        TaskSnapshot snapshot = getSnapshotInner(Integer.valueOf(taskId));     // Catch: Throwable -> L8
        if (snapshot == null) goto L13;
        if (usage == 0) goto L10;
        snapshot.addReference(usage);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return snapshot;
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return null;
    L8:
        th = move-exception;
        throw th;
    }

    TaskSnapshot getSnapshotFromDisk(int taskId, int userId, boolean isLowResolution, int usage) {
        TaskSnapshot snapshot = this.mLoader.loadTask(taskId, userId, isLowResolution);
        if (snapshot == null) goto L6;
        if (usage == 0) goto L6;
        snapshot.addReference(usage);
    L6:
        return snapshot;
    }
}
