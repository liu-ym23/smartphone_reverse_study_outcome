package com.bytedance.compression.zstd;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.FilterOutputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
public class ZstdOutputStream extends FilterOutputStream {
    private ZstdOutputStreamNoFinalizer inner;

    @Deprecated
    public void setFinalize(boolean r1) {
    }

    public ZstdOutputStream(OutputStream r2, int r3) {
        this(r2, c.f7096a);
        this.inner.setLevel(r3);
    }

    public ZstdOutputStream(OutputStream r2) {
        this(r2, c.f7096a);
    }

    private ZstdOutputStream(OutputStream r3, b r4) {
        b r5 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        super(r3);
        this.inner = new ZstdOutputStreamNoFinalizer(r3, r5);
    }

    public void finalize() {
        close();
    }

    public static long recommendedCOutSize() {
        return ZstdOutputStreamNoFinalizer.recommendedCOutSize();
    }

    public ZstdOutputStream setChecksum(boolean r2) {
        this.inner.setChecksum(r2);
        return this;
    }

    public ZstdOutputStream setLevel(int r2) {
        this.inner.setLevel(r2);
        return this;
    }

    public ZstdOutputStream setLong(int r2) {
        this.inner.setLong(r2);
        return this;
    }

    public ZstdOutputStream setWorkers(int r2) {
        this.inner.setWorkers(r2);
        return this;
    }

    public ZstdOutputStream setCloseFrameOnFlush(boolean r2) {
        this.inner.setCloseFrameOnFlush(r2);
        return this;
    }

    public ZstdOutputStream setDict(byte[] r2) {
        this.inner.setDict(r2);
        return this;
    }

    public ZstdOutputStream setDict(ZstdDictCompress r2) {
        this.inner.setDict(r2);
        return this;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] r1, int r2, int r3) {
        this.inner.write(r1, r2, r3);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r1) {
        this.inner.write(r1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public void flush() {
        this.inner.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.inner.close();
    }
}
