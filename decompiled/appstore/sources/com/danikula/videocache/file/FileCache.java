package com.danikula.videocache.file;

import com.danikula.videocache.Cache;
import com.danikula.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes2.dex */
public class FileCache implements Cache {
    private static final String TEMP_POSTFIX = ".download";
    private RandomAccessFile dataFile;
    private final DiskUsage diskUsage;
    public File file;

    public FileCache(File r10) throws ProxyCacheException {
        this(r10, new UnlimitedDiskUsage());
    }

    private boolean isTempFile(File r10) {
        return r10.getName().endsWith(TEMP_POSTFIX);
    }

    @Override // com.danikula.videocache.Cache
    public synchronized void append(byte[] r10, int r11) throws ProxyCacheException {
        monitor-enter(this);
    L10:
        e = move-exception;
        throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", new Object[]{Integer.valueOf(r11), this.dataFile, Integer.valueOf(r10.length)}), e);     // Catch: Throwable -> L8
    L4:
        if (isCompleted() == true) goto L13;
        this.dataFile.seek(available());     // Catch: Throwable -> L8 IOException -> L10
        this.dataFile.write(r10, 0, r11);     // Catch: Throwable -> L8 IOException -> L10
        monitor-exit(this);
        return;
    L13:
        throw new ProxyCacheException("Error append cache: cache file " + this.file + " is completed!");     // Catch: Throwable -> L8 IOException -> L10
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.danikula.videocache.Cache
    public synchronized long available() throws ProxyCacheException {
        monitor-enter(this);
        long r10 = (int) this.dataFile.length();
        monitor-exit(this);
        return r10;
    L7:
        th = move-exception;
        throw th;
    L9:
        e = move-exception;
        throw new ProxyCacheException("Error reading length of file " + this.file, e);     // Catch: Throwable -> L7
    }

    @Override // com.danikula.videocache.Cache
    public synchronized void close() throws ProxyCacheException {
        monitor-enter(this);
        this.dataFile.close();     // Catch: Throwable -> L6 IOException -> L8
        this.diskUsage.touch(this.file);     // Catch: Throwable -> L6 IOException -> L8
        monitor-exit(this);
        return;
    L8:
        e = move-exception;
        throw new ProxyCacheException("Error closing file " + this.file, e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.danikula.videocache.Cache
    public synchronized void complete() throws ProxyCacheException {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (isCompleted() == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        close();     // Catch: Throwable -> L13
        File r10 = new File(this.file.getParentFile(), this.file.getName().substring(0, this.file.getName().length() - 9));     // Catch: Throwable -> L13
        if (this.file.renameTo(r10) == false) goto L19;
        this.file = r10;     // Catch: Throwable -> L13
        this.dataFile = new RandomAccessFile(this.file, "r");     // Catch: Throwable -> L13 IOException -> L15
        this.diskUsage.touch(this.file);     // Catch: Throwable -> L13 IOException -> L15
        monitor-exit(this);
        return;
    L15:
        e = move-exception;
        throw new ProxyCacheException("Error opening " + this.file + " as disc cache", e);     // Catch: Throwable -> L13
    L19:
        throw new ProxyCacheException("Error renaming file " + this.file + " to " + r10 + " for completion!");     // Catch: Throwable -> L13
    }

    public File getFile() {
        return this.file;
    }

    @Override // com.danikula.videocache.Cache
    public synchronized boolean isCompleted() {
        monitor-enter(this);
        boolean r10 = !isTempFile(this.file);
        monitor-exit(this);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.danikula.videocache.Cache
    public synchronized int read(byte[] r10, long r11, int r12) throws ProxyCacheException {
        monitor-enter(this);
        this.dataFile.seek(r11);     // Catch: Throwable -> L6 IOException -> L8
        int r13 = this.dataFile.read(r10, 0, r12);     // Catch: Throwable -> L6 IOException -> L8
        monitor-exit(this);
        return r13;
    L8:
        e = move-exception;
        throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", new Object[]{Integer.valueOf(r12), Long.valueOf(r11), Long.valueOf(available()), Integer.valueOf(r10.length)}), e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }

    public FileCache(File r10, DiskUsage r11) throws ProxyCacheException {
        if (r11 == null) goto L17;
        this.diskUsage = r11;     // Catch: IOException -> L11
        Files.makeDir(r10.getParentFile());     // Catch: IOException -> L11
        boolean r12 = r10.exists();     // Catch: IOException -> L11
        if (r12 == false) goto L7;
        File r13 = r10;
    L8:
        this.file = r13;     // Catch: IOException -> L11
        File r14 = this.file;     // Catch: IOException -> L11
        if (r12 == false) goto L13;
        String r15 = "r";
    L14:
        this.dataFile = new RandomAccessFile(r14, r15);     // Catch: IOException -> L11
        return;
    L13:
        r15 = "rw";
        goto L14
    L7:
        r13 = new File(r10.getParentFile(), r10.getName() + TEMP_POSTFIX);     // Catch: IOException -> L11
        goto L8
    L17:
        throw new NullPointerException();     // Catch: IOException -> L11
    L11:
        e = move-exception;
        throw new ProxyCacheException("Error using file " + r10 + " as disc cache", e);
    }
}
