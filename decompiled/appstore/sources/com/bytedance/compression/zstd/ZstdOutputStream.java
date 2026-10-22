package com.bytedance.compression.zstd;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class ZstdOutputStream extends FilterOutputStream {
    private ZstdOutputStreamNoFinalizer inner;

    public ZstdOutputStream(OutputStream r10, int r11) throws IOException {
        this(r10, b.f7121a);
        this.inner.setLevel(r11);
    }

    public static long recommendedCOutSize() {
        return ZstdOutputStreamNoFinalizer.recommendedCOutSize();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.inner.close();
    }

    public void finalize() throws Throwable {
        close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        this.inner.flush();
    }

    public ZstdOutputStream setChecksum(boolean r10) throws IOException {
        this.inner.setChecksum(r10);
        return this;
    }

    public ZstdOutputStream setCloseFrameOnFlush(boolean r10) throws IOException {
        this.inner.setCloseFrameOnFlush(r10);
        return this;
    }

    public ZstdOutputStream setDict(byte[] r10) throws IOException {
        this.inner.setDict(r10);
        return this;
    }

    @Deprecated
    public void setFinalize(boolean r10) {
    }

    public ZstdOutputStream setLevel(int r10) throws IOException {
        this.inner.setLevel(r10);
        return this;
    }

    public ZstdOutputStream setLong(int r10) throws IOException {
        this.inner.setLong(r10);
        return this;
    }

    public ZstdOutputStream setWorkers(int r10) throws IOException {
        this.inner.setWorkers(r10);
        return this;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r10, int r11, int r12) throws IOException {
        this.inner.write(r10, r11, r12);
    }

    public ZstdOutputStream setDict(ZstdDictCompress r10) throws IOException {
        this.inner.setDict(r10);
        return this;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r10) throws IOException {
        this.inner.write(r10);
    }

    public ZstdOutputStream(OutputStream r10) throws IOException {
        this(r10, b.f7121a);
    }

    private ZstdOutputStream(OutputStream r10, BufferPool r11) throws IOException {
        super(r10);
        this.inner = new ZstdOutputStreamNoFinalizer(r10, r11);
    }
}
