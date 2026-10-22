package com.bytedance.compression.zstd;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
class ZstdOutputStreamNoFinalizer extends FilterOutputStream {
    private static final int dstSize = 0;
    private final BufferPool bufferPool;
    private boolean closeFrameOnFlush;
    private final byte[] dst;
    private final ByteBuffer dstByteBuffer;
    private long dstPos;
    private boolean frameClosed;
    private boolean isClosed;
    private long srcPos;
    private final long stream;

    static {
        k4.a.a();
        dstSize = (int) recommendedCOutSize();
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r10, int r11) throws IOException {
        this(r10, b.f7121a);
        ZstdCompress.setCompressionLevel(this.stream, r11);
    }

    private native int compressStream(long r10, byte[] r11, int r12, byte[] r13, int r14);

    private static native long createCStream();

    private native int endStream(long r10, byte[] r11, int r12);

    private native int flushStream(long r10, byte[] r11, int r12);

    private static native int freeCStream(long r10);

    public static native long recommendedCOutSize();

    private native int resetCStream(long r10);

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        monitor-enter(this);
        close(true);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void closeWithoutClosingParentStream() throws IOException {
        monitor-enter(this);
        close(false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public synchronized void flush() throws IOException {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.isClosed == true) goto L28;
        if (this.frameClosed == false) goto L8;
    L25:
        monitor-exit(this);
        return;
    L8:
        if (this.closeFrameOnFlush == false) goto L18;
    L9:
        int r10 = endStream(this.stream, this.dst, dstSize);     // Catch: Throwable -> L14
        long r11 = r10;
        if (Zstd.isError(r11) == true) goto L17;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) this.dstPos);     // Catch: Throwable -> L14
        if (r10 > 0) goto L9;
        this.frameClosed = true;     // Catch: Throwable -> L14
    L22:
        ((FilterOutputStream) this).out.flush();     // Catch: Throwable -> L14
        goto L25
    L17:
        throw new IOException("Compression error: " + Zstd.getErrorName(r11));     // Catch: Throwable -> L14
    L18:
        int r12 = flushStream(this.stream, this.dst, dstSize);     // Catch: Throwable -> L14
        long r13 = r12;
        if (Zstd.isError(r13) == true) goto L24;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) this.dstPos);     // Catch: Throwable -> L14
        if (r12 > 0) goto L18;
    L24:
        throw new IOException("Compression error: " + Zstd.getErrorName(r13));     // Catch: Throwable -> L14
    L28:
        throw new IOException("Stream closed");     // Catch: Throwable -> L14
    }

    public synchronized ZstdOutputStreamNoFinalizer setChecksum(boolean r10) throws IOException {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.frameClosed == false) goto L14;
        long r11 = ZstdCompress.setCompressionChecksums(this.stream, r10);     // Catch: Throwable -> L11
        if (Zstd.isError(r11) == true) goto L10;
        monitor-exit(this);
        return this;
    L10:
        throw new IOException("Compression param: " + Zstd.getErrorName(r11));     // Catch: Throwable -> L11
    L14:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L11
    }

    public synchronized ZstdOutputStreamNoFinalizer setCloseFrameOnFlush(boolean r10) throws IOException {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.frameClosed == false) goto L11;
        this.closeFrameOnFlush = r10;     // Catch: Throwable -> L8
        monitor-exit(this);
        return this;
    L11:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L8
    }

    public synchronized ZstdOutputStreamNoFinalizer setDict(byte[] r10) throws IOException {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.frameClosed == false) goto L14;
        long r11 = ZstdCompress.loadDictCompress(this.stream, r10, r10.length);     // Catch: Throwable -> L11
        if (Zstd.isError(r11) == true) goto L10;
        monitor-exit(this);
        return this;
    L10:
        throw new IOException("Compression param: " + Zstd.getErrorName(r11));     // Catch: Throwable -> L11
    L14:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L11
    }

    public synchronized ZstdOutputStreamNoFinalizer setLevel(int r10) throws IOException {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.frameClosed == false) goto L14;
        long r11 = ZstdCompress.setCompressionLevel(this.stream, r10);     // Catch: Throwable -> L11
        if (Zstd.isError(r11) == true) goto L10;
        monitor-exit(this);
        return this;
    L10:
        throw new IOException("Compression param: " + Zstd.getErrorName(r11));     // Catch: Throwable -> L11
    L14:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L11
    }

    public synchronized ZstdOutputStreamNoFinalizer setLong(int r10) throws IOException {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.frameClosed == false) goto L14;
        long r11 = ZstdCompress.setCompressionLong(this.stream, r10);     // Catch: Throwable -> L11
        if (Zstd.isError(r11) == true) goto L10;
        monitor-exit(this);
        return this;
    L10:
        throw new IOException("Compression param: " + Zstd.getErrorName(r11));     // Catch: Throwable -> L11
    L14:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L11
    }

    public synchronized ZstdOutputStreamNoFinalizer setWorkers(int r10) throws IOException {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.frameClosed == false) goto L14;
        long r11 = ZstdCompress.setCompressionWorkers(this.stream, r10);     // Catch: Throwable -> L11
        if (Zstd.isError(r11) == true) goto L10;
        monitor-exit(this);
        return this;
    L10:
        throw new IOException("Compression param: " + Zstd.getErrorName(r11));     // Catch: Throwable -> L11
    L14:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L11
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] r10, int r11, int r12) throws IOException {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.isClosed == true) goto L27;
        if (this.frameClosed == false) goto L14;
        long r13 = resetCStream(this.stream);     // Catch: Throwable -> L10
        if (Zstd.isError(r13) == true) goto L13;
        this.frameClosed = false;     // Catch: Throwable -> L10
        goto L14
    L13:
        throw new IOException("Compression error: cannot create header: " + Zstd.getErrorName(r13));     // Catch: Throwable -> L10
    L14:
        int r14 = r12 + r11;     // Catch: Throwable -> L10
        this.srcPos = r11;     // Catch: Throwable -> L10
    L16:
        if (this.srcPos >= r14) goto L24;
        long r15 = compressStream(this.stream, this.dst, dstSize, r10, r14);     // Catch: Throwable -> L10
        if (Zstd.isError(r15) == true) goto L23;
        long r16 = this.dstPos;     // Catch: Throwable -> L10
        if (r16 <= 0) goto L16;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) r16);     // Catch: Throwable -> L10
        goto L16
    L23:
        throw new IOException("Compression error: " + Zstd.getErrorName(r15));     // Catch: Throwable -> L10
    L24:
        monitor-exit(this);
        return;
    L27:
        throw new IOException("Stream closed");     // Catch: Throwable -> L10
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r10) throws IOException {
        this(r10, b.f7121a);
    }

    private void close(boolean r10) throws IOException {
        if (this.isClosed == false) goto L23;
        return;
    L23:
    L13:
        th = move-exception;
        this.isClosed = true;
        this.bufferPool.release(this.dstByteBuffer);
        freeCStream(this.stream);
        throw th;
    L7:
        if (this.frameClosed == true) goto L17;
    L8:
        int r11 = endStream(this.stream, this.dst, dstSize);     // Catch: Throwable -> L13
        long r12 = r11;
        if (Zstd.isError(r12) == true) goto L16;
        ((FilterOutputStream) this).out.write(this.dst, 0, (int) this.dstPos);     // Catch: Throwable -> L13
        if (r11 > 0) goto L8;
    L16:
        throw new IOException("Compression error: " + Zstd.getErrorName(r12));     // Catch: Throwable -> L13
    L17:
        if (r10 == false) goto L19;
        ((FilterOutputStream) this).out.close();     // Catch: Throwable -> L13
    L19:
        this.isClosed = true;
        this.bufferPool.release(this.dstByteBuffer);
        freeCStream(this.stream);
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r10, BufferPool r11, int r12) throws IOException {
        this(r10, r11);
        ZstdCompress.setCompressionLevel(this.stream, r12);
    }

    public ZstdOutputStreamNoFinalizer(OutputStream r10, BufferPool r11) throws IOException {
        super(r10);
        this.srcPos = 0;
        this.dstPos = 0;
        this.isClosed = false;
        this.closeFrameOnFlush = false;
        this.frameClosed = true;
        this.stream = createCStream();
        this.bufferPool = r11;
        int r12 = dstSize;
        ByteBuffer r13 = r11.get(r12);
        this.dstByteBuffer = r13;
        if (r13 == null) goto L7;
        this.dst = Zstd.extractArray(r13);
        return;
    L7:
        throw new IOException("Cannot get ByteBuffer of size " + r12 + " from the BufferPool");
    }

    public synchronized ZstdOutputStreamNoFinalizer setDict(ZstdDictCompress r10) throws IOException {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.frameClosed == false) goto L14;
        long r11 = ZstdCompress.loadFastDictCompress(this.stream, r10);     // Catch: Throwable -> L11
        if (Zstd.isError(r11) == true) goto L10;
        monitor-exit(this);
        return this;
    L10:
        throw new IOException("Compression param: " + Zstd.getErrorName(r11));     // Catch: Throwable -> L11
    L14:
        throw new IOException("Change of parameter on initialized stream");     // Catch: Throwable -> L11
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int r10) throws IOException {
        write(new byte[]{(byte) r10}, 0, 1);
    }
}
