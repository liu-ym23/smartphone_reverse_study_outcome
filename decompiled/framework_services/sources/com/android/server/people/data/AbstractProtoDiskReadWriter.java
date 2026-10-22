package com.android.server.people.data;

import android.util.ArrayMap;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.proto.ProtoInputStream;
import android.util.proto.ProtoOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractProtoDiskReadWriter<T> {
    private static final long DEFAULT_DISK_WRITE_DELAY = 120000;
    private static final long SHUTDOWN_DISK_WRITE_TIMEOUT = 5000;
    private static final String TAG = null;
    private final File mRootDir;
    private final ScheduledExecutorService mScheduledExecutorService;
    private Map<String, T> mScheduledFileDataMap;
    private ScheduledFuture<?> mScheduledFuture;

    interface ProtoStreamReader<T> {
        T read(ProtoInputStream r1);
    }

    interface ProtoStreamWriter<T> {
        void write(ProtoOutputStream r1, T r2);
    }

    public static /* synthetic */ boolean $r8$lambda$JsPjVTa6o_e5cjcQUqubZjqIWnQ(String r0, File r1) {
        return lambda$read$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$ca3eOlN5oPb7C86r64X0nuCW2ik(AbstractProtoDiskReadWriter r0) {
        r0.flushScheduledData();
    }

    abstract ProtoStreamReader<T> protoStreamReader();

    abstract ProtoStreamWriter<T> protoStreamWriter();

    static {
        TAG = AbstractProtoDiskReadWriter.class.getSimpleName();
    }

    AbstractProtoDiskReadWriter(File rootDir, ScheduledExecutorService scheduledExecutorService) {
        this.mScheduledFileDataMap = new ArrayMap();
        this.mRootDir = rootDir;
        this.mScheduledExecutorService = scheduledExecutorService;
    }

    void delete(String fileName) {
        monitor-enter(this);
        this.mScheduledFileDataMap.remove(fileName);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        File file = getFile(fileName);
        if (file.exists() == true) goto L9;
        return;
    L9:
        if (file.delete() == true) goto L17;
        Slog.e(TAG, "Failed to delete file: " + file.getPath());
        return;
    L17:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    void writeTo(String fileName, T data) {
        File file = getFile(fileName);
        AtomicFile atomicFile = new AtomicFile(file);
        FileOutputStream fileOutputStream = atomicFile.startWrite();     // Catch: IOException -> L10
        ProtoOutputStream protoOutputStream = new ProtoOutputStream(fileOutputStream);     // Catch: Throwable -> L7
        protoStreamWriter().write(protoOutputStream, data);     // Catch: Throwable -> L7
        protoOutputStream.flush();     // Catch: Throwable -> L7
        atomicFile.finishWrite(fileOutputStream);     // Catch: Throwable -> L7
        atomicFile.failWrite(null);
        return;
    L7:
        th = move-exception;
        atomicFile.failWrite(fileOutputStream);
        throw th;
    L10:
        e = move-exception;
        Slog.e(TAG, "Failed to write to protobuf file.", e);
    }

    T read(final String fileName) {
        File[] files = this.mRootDir.listFiles(new AbstractProtoDiskReadWriter$$ExternalSyntheticLambda1(fileName));
        if (files != null) goto L5;
        return null;
    L5:
        if (files.length != 0) goto L8;
        return null;
    L8:
        if (files.length <= 1) goto L11;
        Slog.w(TAG, "Found multiple files with the same name: " + Arrays.toString(files));
    L11:
        return parseFile(files[0]);
    }

    private static /* synthetic */ boolean lambda$read$0(String fileName, File pathname) {
        if (pathname.isFile() == true) goto L5;
    L7:
        return false;
    L5:
        if (pathname.getName().equals(fileName) == false) goto L7;
        return true;
    }

    synchronized void scheduleSave(String fileName, T data) {
        monitor-enter(this);
        this.mScheduledFileDataMap.put(fileName, data);     // Catch: Throwable -> L8
        if (this.mScheduledExecutorService.isShutdown() == false) goto L11;
        Slog.e(TAG, "Worker is shutdown, failed to schedule data saving.");     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L11:
        if (this.mScheduledFuture == null) goto L14;
        monitor-exit(this);
        return;
    L14:
        this.mScheduledFuture = this.mScheduledExecutorService.schedule(new AbstractProtoDiskReadWriter$$ExternalSyntheticLambda0(this), 120000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    void saveImmediately(String fileName, T data) {
        monitor-enter(this);
        this.mScheduledFileDataMap.put(fileName, data);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        triggerScheduledFlushEarly();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void triggerScheduledFlushEarly() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.mScheduledFileDataMap.isEmpty() == true) goto L20;
        if (this.mScheduledExecutorService.isShutdown() == true) goto L20;
        if (this.mScheduledFuture == null) goto L13;
        this.mScheduledFuture.cancel(true);     // Catch: Throwable -> L11
    L13:
        monitor-exit(this);     // Catch: Throwable -> L11
        Future<?> future = this.mScheduledExecutorService.submit(new AbstractProtoDiskReadWriter$$ExternalSyntheticLambda0(this));
        future.get(SHUTDOWN_DISK_WRITE_TIMEOUT, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L17
        return;
    L17:
        e = move-exception;
        Slog.e(TAG, "Failed to save data immediately.", e);
        return;
    L20:
        monitor-exit(this);     // Catch: Throwable -> L11
    }

    private synchronized void flushScheduledData() {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.mScheduledFileDataMap.isEmpty() == false) goto L10;
        this.mScheduledFuture = null;     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L10:
        Iterator<String> r0 = this.mScheduledFileDataMap.keySet().iterator();     // Catch: Throwable -> L8
    L12:
        if (r0.hasNext() == false) goto L14;
        String fileName = r0.next();     // Catch: Throwable -> L8
        T data = this.mScheduledFileDataMap.get(fileName);     // Catch: Throwable -> L8
        writeTo(fileName, data);     // Catch: Throwable -> L8
        goto L12
    L14:
        this.mScheduledFileDataMap.clear();     // Catch: Throwable -> L8
        this.mScheduledFuture = null;     // Catch: Throwable -> L8
        monitor-exit(this);
    }

    private T parseFile(File file) {
        AtomicFile atomicFile = new AtomicFile(file);
        FileInputStream fileInputStream = atomicFile.openRead();     // Catch: IOException -> L8
        ProtoInputStream protoInputStream = new ProtoInputStream(fileInputStream);     // Catch: Throwable -> L11
        T r3 = protoStreamReader().read(protoInputStream);     // Catch: Throwable -> L11
        if (fileInputStream == null) goto L10;
        fileInputStream.close();     // Catch: IOException -> L8
    L10:
        return r3;
    L11:
        th = move-exception;
        if (fileInputStream != null) goto L21;
    L18:
        throw th;     // Catch: IOException -> L8
    L21:
        fileInputStream.close();     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L8
    L8:
        e = move-exception;
        Slog.e(TAG, "Failed to parse protobuf file.", e);
        return null;
    }

    private File getFile(String fileName) {
        return new File(this.mRootDir, fileName);
    }
}
