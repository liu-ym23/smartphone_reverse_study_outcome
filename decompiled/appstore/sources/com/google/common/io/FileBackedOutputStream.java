package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes3.dex */
@Beta
@GwtIncompatible
public final class FileBackedOutputStream extends OutputStream {

    @NullableDecl
    private File file;
    private final int fileThreshold;
    private MemoryOutput memory;
    private OutputStream out;
    private final boolean resetOnFinalize;
    private final ByteSource source;

    public static class MemoryOutput extends ByteArrayOutputStream {
        private MemoryOutput() {
        }

        public byte[] getBuffer() {
            return ((ByteArrayOutputStream) this).buf;
        }

        public int getCount() {
            return ((ByteArrayOutputStream) this).count;
        }

        public /* synthetic */ MemoryOutput(AnonymousClass1 r10) {
            this();
        }
    }

    public FileBackedOutputStream(int r10) {
        this(r10, false);
    }

    public static /* synthetic */ InputStream access$100(FileBackedOutputStream r10) throws IOException {
        return r10.openInputStream();
    }

    private synchronized InputStream openInputStream() throws IOException {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.file == null) goto L10;
        FileInputStream r10 = new FileInputStream(this.file);     // Catch: Throwable -> L8
        monitor-exit(this);
        return r10;
    L10:
        ByteArrayInputStream r11 = new ByteArrayInputStream(this.memory.getBuffer(), 0, this.memory.getCount());     // Catch: Throwable -> L8
        monitor-exit(this);
        return r11;
    }

    private void update(int r10) throws IOException {
        if (this.file == null) goto L5;
        return;
    L5:
        if ((this.memory.getCount() + r10) <= this.fileThreshold) goto L12;
        File r11 = File.createTempFile("FileBackedOutputStream", null);
        if (this.resetOnFinalize == false) goto L9;
        r11.deleteOnExit();
    L9:
        FileOutputStream r12 = new FileOutputStream(r11);
        r12.write(this.memory.getBuffer(), 0, this.memory.getCount());
        r12.flush();
        this.out = r12;
        this.file = r11;
        this.memory = null;
        return;
    }

    public ByteSource asByteSource() {
        return this.source;
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

    @VisibleForTesting
    public synchronized File getFile() {
        monitor-enter(this);
        File r10 = this.file;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void reset() throws IOException {
        monitor-enter(this);
        AnonymousClass1 r10 = null;
        close();     // Catch: Throwable -> L20
        MemoryOutput r11 = this.memory;     // Catch: Throwable -> L8
        if (r11 != null) goto L10;
        this.memory = new MemoryOutput(r10);     // Catch: Throwable -> L8
    L11:
        this.out = this.memory;     // Catch: Throwable -> L8
        File r12 = this.file;     // Catch: Throwable -> L8
        if (r12 == null) goto L18;
        this.file = null;     // Catch: Throwable -> L8
        if (r12.delete() == true) goto L18;
        throw new IOException("Could not delete: " + r12);     // Catch: Throwable -> L8
    L18:
        monitor-exit(this);
        return;
    L10:
        r11.reset();     // Catch: Throwable -> L8
        goto L11
    L20:
        th = move-exception;
        if (this.memory != null) goto L24;
        this.memory = new MemoryOutput(r10);     // Catch: Throwable -> L8
    L25:
        this.out = this.memory;     // Catch: Throwable -> L8
        File r13 = this.file;     // Catch: Throwable -> L8
        if (r13 == null) goto L31;
        this.file = null;     // Catch: Throwable -> L8
        if (r13.delete() == true) goto L31;
        throw new IOException("Could not delete: " + r13);     // Catch: Throwable -> L8
    L31:
        throw th;     // Catch: Throwable -> L8
    L24:
        this.memory.reset();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    @Override // java.io.OutputStream
    public synchronized void write(int r10) throws IOException {
        monitor-enter(this);
        update(1);     // Catch: Throwable -> L7
        this.out.write(r10);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public FileBackedOutputStream(int r10, boolean r11) {
        this.fileThreshold = r10;
        this.resetOnFinalize = r11;
        MemoryOutput r12 = new MemoryOutput(null);
        this.memory = r12;
        this.out = r12;
        if (r11 == false) goto L5;
        this.source = new AnonymousClass1(this);
        return;
    L5:
        this.source = new AnonymousClass2(this);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] r10) throws IOException {
        monitor-enter(this);
        write(r10, 0, r10.length);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] r10, int r11, int r12) throws IOException {
        monitor-enter(this);
        update(r12);     // Catch: Throwable -> L6
        this.out.write(r10, r11, r12);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
