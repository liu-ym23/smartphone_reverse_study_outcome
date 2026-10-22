package com.android.server.pm;

import android.os.Environment;
import android.os.SystemClock;
import android.util.AtomicFile;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractStatsBase<T> {
    private static final int WRITE_INTERVAL_MS = 1800000;
    private final String mBackgroundThreadName;
    private final AtomicBoolean mBackgroundWriteRunning;
    private final Object mFileLock;
    private final String mFileName;
    private final AtomicLong mLastTimeWritten;
    private final boolean mLock;

    /* JADX INFO: renamed from: -$$Nest$fgetmBackgroundWriteRunning, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicBoolean m6593$$Nest$fgetmBackgroundWriteRunning(AbstractStatsBase r0) {
        return r0.mBackgroundWriteRunning;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLastTimeWritten, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicLong m6594$$Nest$fgetmLastTimeWritten(AbstractStatsBase r0) {
        return r0.mLastTimeWritten;
    }

    /* JADX INFO: renamed from: -$$Nest$mwriteImpl, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6595$$Nest$mwriteImpl(AbstractStatsBase r0, Object r1) {
        r0.writeImpl(r1);
    }

    protected abstract void readInternal(T r1);

    protected abstract void writeInternal(T r1);

    protected AbstractStatsBase(String fileName, String threadName, boolean lock) {
        this.mFileLock = new Object();
        this.mLastTimeWritten = new AtomicLong(0);
        this.mBackgroundWriteRunning = new AtomicBoolean(false);
        this.mFileName = fileName;
        this.mBackgroundThreadName = threadName;
        this.mLock = lock;
    }

    protected AtomicFile getFile() {
        File dataDir = Environment.getDataDirectory();
        File systemDir = new File(dataDir, "system");
        File fname = new File(systemDir, this.mFileName);
        return new AtomicFile(fname);
    }

    protected void writeNow(T data) {
        writeImpl(data);
        this.mLastTimeWritten.set(SystemClock.elapsedRealtime());
    }

    protected boolean maybeWriteAsync(final T data) {
        if ((SystemClock.elapsedRealtime() - this.mLastTimeWritten.get()) >= 1800000) goto L6;
        return false;
    L6:
        if (this.mBackgroundWriteRunning.compareAndSet(false, true) == false) goto L9;
        final String r1 = this.mBackgroundThreadName;
        new AnonymousClass1(this, r1, data).start();
        return true;
    L9:
        return false;
    }

    private void writeImpl(T data) {
        if (this.mLock == false) goto L18;
        monitor-enter(data);
        Object r0 = this.mFileLock;     // Catch: Throwable -> L11
        monitor-enter(r0);     // Catch: Throwable -> L11
        writeInternal(data);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        monitor-exit(data);     // Catch: Throwable -> L11
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L18:
        Object r1 = this.mFileLock;
        monitor-enter(r1);
        writeInternal(data);     // Catch: Throwable -> L23
        monitor-exit(r1);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        throw th;
    }

    protected void read(T data) {
        if (this.mLock == false) goto L18;
        monitor-enter(data);
        Object r0 = this.mFileLock;     // Catch: Throwable -> L11
        monitor-enter(r0);     // Catch: Throwable -> L11
        readInternal(data);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        monitor-exit(data);     // Catch: Throwable -> L11
    L22:
        this.mLastTimeWritten.set(SystemClock.elapsedRealtime());
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    L18:
        Object r1 = this.mFileLock;
        monitor-enter(r1);
        readInternal(data);     // Catch: Throwable -> L24
        monitor-exit(r1);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }
}
