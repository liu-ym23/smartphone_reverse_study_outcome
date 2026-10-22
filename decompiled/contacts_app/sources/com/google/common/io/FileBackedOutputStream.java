package com.google.common.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class FileBackedOutputStream extends OutputStream {
    private File file;
    private final int fileThreshold;
    private MemoryOutput memory;
    private OutputStream out;
    private final boolean resetOnFinalize;
    private final ByteSource source;

    private static class MemoryOutput extends ByteArrayOutputStream {
        private MemoryOutput() {
        }

        /* synthetic */ MemoryOutput(AnonymousClass1 r1) {
            this();
        }

        byte[] getBuffer() {
            return this.buf;
        }

        int getCount() {
            return this.count;
        }
    }

    static /* synthetic */ InputStream access$100(FileBackedOutputStream r0) throws IOException {
        return r0.openInputStream();
    }

    synchronized File getFile() {
        monitor-enter(this);
        File r0 = this.file;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public FileBackedOutputStream(int r2) {
        this(r2, false);
    }

    public FileBackedOutputStream(int r2, boolean r3) {
        this.fileThreshold = r2;
        this.resetOnFinalize = r3;
        MemoryOutput r4 = new MemoryOutput(null);
        this.memory = r4;
        this.out = r4;
        if (r3 == false) goto L5;
        this.source = new AnonymousClass1(this);
        return;
    L5:
        this.source = new AnonymousClass2(this);
    }

    public ByteSource asByteSource() {
        return this.source;
    }

    private synchronized InputStream openInputStream() throws IOException {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.file == null) goto L8;
        FileInputStream r0 = new FileInputStream(this.file);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L8:
        ByteArrayInputStream r1 = new ByteArrayInputStream(this.memory.getBuffer(), 0, this.memory.getCount());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    }

    public synchronized void reset() throws IOException {
        monitor-enter(this);
        AnonymousClass1 r2 = null;
        close();     // Catch: Throwable -> L21
        MemoryOutput r0 = this.memory;     // Catch: Throwable -> L19
        if (r0 != null) goto L9;
        this.memory = new MemoryOutput(r2);     // Catch: Throwable -> L19
    L10:
        this.out = this.memory;     // Catch: Throwable -> L19
        File r1 = this.file;     // Catch: Throwable -> L19
        if (r1 == null) goto L17;
        this.file = null;     // Catch: Throwable -> L19
        if (r1.delete() == true) goto L17;
        throw new IOException("Could not delete: " + r1);     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
        return;
    L9:
        r0.reset();     // Catch: Throwable -> L19
        goto L10
    L21:
        th = move-exception;
        if (this.memory != null) goto L25;
        this.memory = new MemoryOutput(r2);     // Catch: Throwable -> L19
    L26:
        this.out = this.memory;     // Catch: Throwable -> L19
        File r3 = this.file;     // Catch: Throwable -> L19
        if (r3 == null) goto L32;
        this.file = null;     // Catch: Throwable -> L19
        if (r3.delete() == true) goto L32;
        throw new IOException("Could not delete: " + r3);     // Catch: Throwable -> L19
    L32:
        throw th;     // Catch: Throwable -> L19
    L25:
        this.memory.reset();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    @Override // java.io.OutputStream
    public synchronized void write(int r2) throws IOException {
        monitor-enter(this);
        update(1);     // Catch: Throwable -> L7
        this.out.write(r2);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] r3) throws IOException {
        monitor-enter(this);
        write(r3, 0, r3.length);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] r2, int r3, int r4) throws IOException {
        monitor-enter(this);
        update(r4);     // Catch: Throwable -> L6
        this.out.write(r2, r3, r4);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        monitor-enter(this);
        this.out.close();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        monitor-enter(this);
        this.out.flush();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private void update(int r6) throws IOException {
        if (this.file == null) goto L5;
        return;
    L5:
        if ((this.memory.getCount() + r6) <= this.fileThreshold) goto L12;
        File r7 = File.createTempFile("FileBackedOutputStream", null);
        if (this.resetOnFinalize == false) goto L9;
        r7.deleteOnExit();
    L9:
        FileOutputStream r1 = new FileOutputStream(r7);
        r1.write(this.memory.getBuffer(), 0, this.memory.getCount());
        r1.flush();
        this.out = r1;
        this.file = r7;
        this.memory = null;
        return;
    }
}
