package com.android.server.wm;

import android.os.Trace;
import android.util.ArraySet;
import android.window.TaskSnapshot;
import com.android.server.pm.UserManagerInternal;
import java.io.File;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
class TaskSnapshotPersister extends BaseAppSnapshotPersister {
    private final boolean mDisableSnapshots;
    private final ArraySet<Integer> mPersistedTaskIdsSinceLastRemoveObsolete;

    class RemoveObsoleteFilesQueueItem extends SnapshotPersistQueue.WriteQueueItem {
        private final ArraySet<Integer> mPersistentTaskIds;
        private final int[] mRunningUserIds;
        final /* synthetic */ TaskSnapshotPersister this$0;

        RemoveObsoleteFilesQueueItem(TaskSnapshotPersister this$0, ArraySet<Integer> persistentTaskIds, int[] runningUserIds, BaseAppSnapshotPersister.PersistInfoProvider provider) {
            this.this$0 = this$0;
            int r1 = 0;
            if (runningUserIds.length <= 0) goto L5;
            r1 = runningUserIds[0];
        L5:
            super(provider, r1);
            this.mPersistentTaskIds = new ArraySet(persistentTaskIds);
            this.mRunningUserIds = Arrays.copyOf(runningUserIds, runningUserIds.length);
        }

        @Override // com.android.server.wm.SnapshotPersistQueue.WriteQueueItem
        boolean isReady(UserManagerInternal userManagerInternal) {
            int i = this.mRunningUserIds.length - 1;
        L3:
            if (i < 0) goto L10;
            if (userManagerInternal.isUserUnlocked(this.mRunningUserIds[i]) == false) goto L6;
            i = i - 1;
            goto L3
        L6:
            return false;
        L10:
            return true;
        }

        @Override // com.android.server.wm.SnapshotPersistQueue.WriteQueueItem
        void write() {
            long r2 = 32;
            Trace.traceBegin(32, "RemoveObsoleteFilesQueueItem");
            Object r4 = this.this$0.mLock;
            monitor-enter(r4);
            ArraySet<Integer> newPersistedTaskIds = new ArraySet(TaskSnapshotPersister.m10322$$Nest$fgetmPersistedTaskIdsSinceLastRemoveObsolete(this.this$0));     // Catch: Throwable -> L23
            monitor-exit(r4);     // Catch: Throwable -> L23
            int[] r5 = this.mRunningUserIds;
            int r6 = r5.length;
            int r7 = 0;
        L7:
            if (r7 >= r6) goto L21;
            int userId = r5[r7];
            File dir = this.mPersistInfoProvider.getDirectory(userId);
            String[] files = dir.list();
            if (files == null) goto L20;
            int r11 = files.length;
            int r12 = 0;
        L12:
            if (r12 >= r11) goto L20;
            String file = files[r12];
            int taskId = getTaskId(file);
            long r16 = r2;
            if (this.mPersistentTaskIds.contains(Integer.valueOf(taskId)) == true) goto L18;
            if (newPersistedTaskIds.contains(Integer.valueOf(taskId)) == true) goto L18;
            new File(dir, file).delete();
        L18:
            r12 = r12 + 1;
            r2 = r16;
        L20:
            r7 = r7 + 1;
            r2 = r2;
            goto L7
        L21:
            Trace.traceEnd(r2);
            return;
        L23:
            th = move-exception;
            throw th;
        }

        int getTaskId(String fileName) {
            if (fileName.endsWith(".proto") == false) goto L5;
        L7:
            int end = fileName.lastIndexOf(46);
            if (end != (-1)) goto L10;
            return -1;
        L10:
            String name = fileName.substring(0, end);
            if (name.endsWith("_reduced") == false) goto L17;
            name = name.substring(0, name.length() - "_reduced".length());
        L17:
            return Integer.parseInt(name);
        L16:
            return -1;
        L5:
            if (fileName.endsWith(".jpg") == true) goto L7;
            return -1;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPersistedTaskIdsSinceLastRemoveObsolete, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArraySet m10322$$Nest$fgetmPersistedTaskIdsSinceLastRemoveObsolete(TaskSnapshotPersister r0) {
        return r0.mPersistedTaskIdsSinceLastRemoveObsolete;
    }

    TaskSnapshotPersister(SnapshotPersistQueue persistQueue, BaseAppSnapshotPersister.PersistInfoProvider persistInfoProvider, boolean disableSnapshots) {
        super(persistQueue, persistInfoProvider);
        this.mPersistedTaskIdsSinceLastRemoveObsolete = new ArraySet();
        if (disableSnapshots == false) goto L5;
        boolean r0 = true;
    L6:
        this.mDisableSnapshots = r0;
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.android.server.wm.BaseAppSnapshotPersister
    void persistSnapshot(int taskId, int userId, TaskSnapshot snapshot) {
        if (this.mDisableSnapshots == false) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPersistedTaskIdsSinceLastRemoveObsolete.add(Integer.valueOf(taskId));     // Catch: Throwable -> L10
        super.persistSnapshot(taskId, userId, snapshot);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.wm.BaseAppSnapshotPersister
    void removeSnapshot(int taskId, int userId) {
        if (this.mDisableSnapshots == false) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPersistedTaskIdsSinceLastRemoveObsolete.remove(Integer.valueOf(taskId));     // Catch: Throwable -> L10
        super.removeSnapshot(taskId, userId);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    void removeObsoleteFiles(ArraySet<Integer> persistentTaskIds, int[] runningUserIds) {
        if (runningUserIds.length != 0) goto L5;
        return;
    L5:
        if (this.mDisableSnapshots == true) goto L18;
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mPersistedTaskIdsSinceLastRemoveObsolete.clear();     // Catch: Throwable -> L12
        this.mSnapshotPersistQueue.sendToQueueLocked(new RemoveObsoleteFilesQueueItem(this, persistentTaskIds, runningUserIds, this.mPersistInfoProvider));     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
