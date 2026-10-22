package androidx.room.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes17.dex */
public class CopyLock {
    private static final Map<String, Lock> sThreadLocks = null;
    private final File mCopyLockFile;
    private final boolean mFileLevelLock;
    private FileChannel mLockChannel;
    private final Lock mThreadLock;

    static {
        sThreadLocks = new HashMap();
    }

    public void lock() {
        this.mThreadLock.lock();
        if (this.mFileLevelLock == true) goto L10;
        return;
    L10:
        FileChannel r100 = new FileOutputStream(this.mCopyLockFile).getChannel();     // Catch: IOException -> L6
        this.mLockChannel = r100;     // Catch: IOException -> L6
        r100.lock();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        throw new IllegalStateException("Unable to grab copy lock.", e);
    }

    public void unlock() {
        FileChannel r100 = this.mLockChannel;
        if (r100 != null) goto L8;
    L5:
        this.mThreadLock.unlock();
        return;
    L8:
        r100.close();     // Catch: IOException -> L7
        goto L5
    }

    private static Lock getThreadLock(String r100) {
        Map<String, Lock> r101 = sThreadLocks;
        monitor-enter(r101);
        Lock r102 = r101.get(r100);     // Catch: Throwable -> L9
        if (r102 != null) goto L7;
        r102 = new ReentrantLock();     // Catch: Throwable -> L9
        r101.put(r100, r102);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r101);     // Catch: Throwable -> L9
        return r102;
    L9:
        th = move-exception;
        throw th;
    }

    public CopyLock(String r100, File r101, boolean r102) {
        File r103 = new File(r101, r100 + ".lck");
        this.mCopyLockFile = r103;
        this.mThreadLock = getThreadLock(r103.getAbsolutePath());
        this.mFileLevelLock = r102;
    }
}
