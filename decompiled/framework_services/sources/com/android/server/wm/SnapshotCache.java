package com.android.server.wm;

import android.hardware.HardwareBuffer;
import android.util.ArrayMap;
import android.window.TaskSnapshot;
import com.android.server.wm.WindowContainer;
import java.io.PrintWriter;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
abstract class SnapshotCache<TYPE extends WindowContainer> {
    protected final ArrayMap<ActivityRecord, Integer> mAppIdMap;
    protected final Object mLock;
    protected final String mName;
    protected final ArrayMap<Integer, CacheEntry> mRunningCache;
    protected Consumer<HardwareBuffer> mSafeSnapshotReleaser;

    static final class CacheEntry {
        final TaskSnapshot snapshot;
        final ActivityRecord topApp;

        CacheEntry(TaskSnapshot snapshot, ActivityRecord topApp) {
            this.snapshot = snapshot;
            this.topApp = topApp;
        }
    }

    abstract void putSnapshot(TYPE r1, TaskSnapshot r2);

    SnapshotCache(String name) {
        this.mLock = new Object();
        this.mAppIdMap = new ArrayMap();
        this.mRunningCache = new ArrayMap();
        this.mName = name;
    }

    void setSafeSnapshotReleaser(Consumer<HardwareBuffer> safeSnapshotReleaser) {
        this.mSafeSnapshotReleaser = safeSnapshotReleaser;
    }

    void clearRunningCache() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mRunningCache.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    final TaskSnapshot getSnapshotInner(Integer id) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CacheEntry entry = this.mRunningCache.get(id);     // Catch: Throwable -> L9
        if (entry == null) goto L12;
        TaskSnapshot r2 = entry.snapshot;     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L9:
        th = move-exception;
        throw th;
    }

    void onAppRemoved(ActivityRecord activity) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Integer id = this.mAppIdMap.get(activity);     // Catch: Throwable -> L7
        if (id == null) goto L9;
        removeRunningEntry(id);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    AbsAppSnapshotController.FetchCacheEntry onAppRemovedAndFetch(ActivityRecord activity) {
        Integer taskId = this.mAppIdMap.get(activity);
        if (taskId == null) goto L8;
        CacheEntry entry = fetchAndRemoveRunningEntry(taskId.intValue());
        if (entry == null) goto L9;
        AbsAppSnapshotController.FetchCacheEntry fetchCacheEntry = new AbsAppSnapshotController.FetchCacheEntry(entry.snapshot, taskId.intValue());
        return fetchCacheEntry;
    L9:
        return null;
    L8:
        return null;
    }

    void onAppDied(ActivityRecord activity) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Integer id = this.mAppIdMap.get(activity);     // Catch: Throwable -> L7
        if (id == null) goto L9;
        removeRunningEntry(id);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void onIdRemoved(Integer index) {
        removeRunningEntry(index);
    }

    void removeRunningEntry(Integer id) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        CacheEntry entry = this.mRunningCache.get(id);     // Catch: Throwable -> L7
        if (entry == null) goto L9;
        this.mAppIdMap.remove(entry.topApp);     // Catch: Throwable -> L7
        this.mRunningCache.remove(id);     // Catch: Throwable -> L7
        entry.snapshot.removeReference(2);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    CacheEntry fetchAndRemoveRunningEntry(int taskId) {
        CacheEntry entry = this.mRunningCache.get(Integer.valueOf(taskId));
        if (entry == null) goto L5;
        this.mAppIdMap.remove(entry.topApp);
        this.mRunningCache.remove(Integer.valueOf(taskId));
    L5:
        return entry;
    }

    void dump(PrintWriter pw, String prefix) {
        String doublePrefix = prefix + "  ";
        String triplePrefix = doublePrefix + "  ";
        pw.println(prefix + "SnapshotCache " + this.mName);
        Object r2 = this.mLock;
        monitor-enter(r2);
        int i = this.mRunningCache.size() - 1;     // Catch: Throwable -> L7
    L5:
        if (i < 0) goto L10;
        CacheEntry entry = this.mRunningCache.valueAt(i);     // Catch: Throwable -> L7
        pw.println(doublePrefix + "Entry token=" + this.mRunningCache.keyAt(i));     // Catch: Throwable -> L7
        pw.println(triplePrefix + "topApp=" + entry.topApp);     // Catch: Throwable -> L7
        pw.println(triplePrefix + "snapshot=" + entry.snapshot);     // Catch: Throwable -> L7
        i = i + (-1);     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r2);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
