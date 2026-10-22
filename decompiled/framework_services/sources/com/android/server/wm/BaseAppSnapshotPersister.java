package com.android.server.wm;

import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.window.TaskSnapshot;
import java.io.File;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
class BaseAppSnapshotPersister {
    static final String BITMAP_EXTENSION = ".jpg";
    static final String LOW_RES_FILE_POSTFIX = "_reduced";
    static final String PROTO_EXTENSION = ".proto";
    protected final Object mLock;
    protected final PersistInfoProvider mPersistInfoProvider;
    protected final SnapshotPersistQueue mSnapshotPersistQueue;

    interface DirectoryResolver {
        File getSystemDirectoryForUser(int r1);
    }

    static class PersistInfoProvider {
        private final String mDirName;
        protected final DirectoryResolver mDirectoryResolver;
        private final boolean mEnableLowResSnapshots;
        private final SparseBooleanArray mInitializedUsers;
        private final float mLowResScaleFactor;
        private final SparseArray<File> mScrambleDirectories;
        private final boolean mUse16BitFormat;

        public static /* synthetic */ boolean $r8$lambda$Kq6deJ05IcnYhOTyoqTGIEcgML4(File r0, String r1) {
            return lambda$getScrambleDirectory$0(r0, r1);
        }

        PersistInfoProvider(DirectoryResolver directoryResolver, String dirName, boolean enableLowResSnapshots, float lowResScaleFactor, boolean use16BitFormat) {
            this.mInitializedUsers = new SparseBooleanArray();
            this.mScrambleDirectories = new SparseArray();
            this.mDirectoryResolver = directoryResolver;
            this.mDirName = dirName;
            this.mEnableLowResSnapshots = enableLowResSnapshots;
            this.mLowResScaleFactor = lowResScaleFactor;
            this.mUse16BitFormat = use16BitFormat;
        }

        File getDirectory(int userId) {
            return getBaseDirectory(userId);
        }

        private File getBaseDirectory(int userId) {
            return new File(this.mDirectoryResolver.getSystemDirectoryForUser(userId), this.mDirName);
        }

        private File getOrInitScrambleDirectory(int userId) {
            SparseArray<File> r0 = this.mScrambleDirectories;
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mInitializedUsers.get(userId) == false) goto L11;
            File r1 = this.mScrambleDirectories.get(userId);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r1;
        L11:
            this.mInitializedUsers.put(userId, true);     // Catch: Throwable -> L9
            File scrambledDirectory = getScrambleDirectory(userId);     // Catch: Throwable -> L9
            File baseDir = getBaseDirectory(userId);     // Catch: Throwable -> L9
            String newName = null;
            if (scrambledDirectory.exists() == false) goto L20;
            newName = UUID.randomUUID().toString();     // Catch: Throwable -> L9
            File scrambleTo = new File(baseDir, newName);     // Catch: Throwable -> L9
            if (scrambledDirectory.renameTo(scrambleTo) == true) goto L40;
            Slog.w("WindowManager", "SnapshotPersister rename scramble folder fail.");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return null;
        L40:
            File newFolder = new File(baseDir, newName);     // Catch: Throwable -> L9
            this.mScrambleDirectories.put(userId, newFolder);     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return newFolder;
        L20:
            if (baseDir.exists() == true) goto L27;
            if (baseDir.mkdir() == true) goto L27;
            Slog.w("WindowManager", "SnapshotPersister make base folder fail.");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return null;
        L27:
            if (scrambledDirectory.mkdir() == true) goto L31;
            Slog.e("WindowManager", "SnapshotPersister make scramble folder fail");     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return null;
        L31:
            String[] files = baseDir.list();     // Catch: Throwable -> L9
            if (files == null) goto L40;
            int r5 = files.length;     // Catch: Throwable -> L9
            int r6 = 0;
        L34:
            if (r6 >= r5) goto L40;
            String file = files[r6];     // Catch: Throwable -> L9
            File original = new File(baseDir, file);     // Catch: Throwable -> L9
            if (original.isDirectory() == false) goto L38;
            newName = file;
        L39:
            r6 = r6 + 1;     // Catch: Throwable -> L9
            goto L34
        L38:
            File to = new File(scrambledDirectory, file);     // Catch: Throwable -> L9
            original.renameTo(to);     // Catch: Throwable -> L9
            goto L39
        }

        private File getScrambleDirectory(int userId) {
            File dir = getBaseDirectory(userId);
            String[] directories = dir.list(new BaseAppSnapshotPersister$PersistInfoProvider$$ExternalSyntheticLambda0());
            if (directories == null) goto L9;
            if (directories.length <= 0) goto L9;
            return new File(dir, directories[0]);
        L9:
            return new File(dir, UUID.randomUUID().toString());
        }

        private static /* synthetic */ boolean lambda$getScrambleDirectory$0(File current, String name) {
            return new File(current, name).isDirectory();
        }

        boolean use16BitFormat() {
            return this.mUse16BitFormat;
        }

        boolean createDirectory(int userId) {
            File dir = getDirectory(userId);
            if (dir.exists() == false) goto L5;
        L8:
            return true;
        L5:
            if (dir.mkdir() == true) goto L8;
            return false;
        }

        File getProtoFile(int index, int userId) {
            return new File(getDirectory(userId), index + BaseAppSnapshotPersister.PROTO_EXTENSION);
        }

        File getLowResolutionBitmapFile(int index, int userId) {
            return new File(getDirectory(userId), index + BaseAppSnapshotPersister.LOW_RES_FILE_POSTFIX + BaseAppSnapshotPersister.BITMAP_EXTENSION);
        }

        File getHighResolutionBitmapFile(int index, int userId) {
            return new File(getDirectory(userId), index + BaseAppSnapshotPersister.BITMAP_EXTENSION);
        }

        boolean enableLowResSnapshots() {
            return this.mEnableLowResSnapshots;
        }

        float lowResScaleFactor() {
            return this.mLowResScaleFactor;
        }
    }

    BaseAppSnapshotPersister(SnapshotPersistQueue persistQueue, PersistInfoProvider persistInfoProvider) {
        this.mSnapshotPersistQueue = persistQueue;
        this.mPersistInfoProvider = persistInfoProvider;
        this.mLock = persistQueue.getLock();
    }

    void persistSnapshot(int id, int userId, TaskSnapshot snapshot) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSnapshotPersistQueue.sendToQueueLocked(this.mSnapshotPersistQueue.createStoreWriteQueueItem(id, userId, snapshot, this.mPersistInfoProvider));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void removeSnapshot(int id, int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mSnapshotPersistQueue.sendToQueueLocked(this.mSnapshotPersistQueue.createDeleteWriteQueueItem(id, userId, this.mPersistInfoProvider));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
