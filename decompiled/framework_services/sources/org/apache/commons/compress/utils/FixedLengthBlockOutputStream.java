package org.apache.commons.compress.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class FixedLengthBlockOutputStream extends OutputStream implements WritableByteChannel {
    private final int blockSize;
    private final ByteBuffer buffer;
    private final AtomicBoolean closed;
    private final WritableByteChannel out;

    /* JADX INFO: renamed from: org.apache.commons.compress.utils.FixedLengthBlockOutputStream$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class BufferAtATimeOutputChannel implements WritableByteChannel {
        private final AtomicBoolean closed;
        private final OutputStream out;

        /* synthetic */ BufferAtATimeOutputChannel(OutputStream x0, AnonymousClass1 x1) {
            this(x0);
        }

        private BufferAtATimeOutputChannel(OutputStream out) {
            this.closed = new AtomicBoolean(false);
            this.out = out;
        }

        @Override // java.nio.channels.WritableByteChannel
        public int write(ByteBuffer buffer) throws IOException {
            if (isOpen() == false) goto L16;
            if (buffer.hasArray() == false) goto L14;
            int pos = buffer.position();     // Catch: IOException -> L8
            int len = buffer.limit() - pos;     // Catch: IOException -> L8
            this.out.write(buffer.array(), buffer.arrayOffset() + pos, len);     // Catch: IOException -> L8
            buffer.position(buffer.limit());     // Catch: IOException -> L8
            return len;
        L8:
            e = move-exception;
            close();     // Catch: IOException -> L11
        L12:
            throw e;
        L14:
            throw new IllegalArgumentException("direct buffer somehow written to BufferAtATimeOutputChannel");
        L16:
            throw new ClosedChannelException();
        }

        @Override // java.nio.channels.Channel
        public boolean isOpen() {
            return !this.closed.get();
        }

        @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed.compareAndSet(false, true) == false) goto L6;
            this.out.close();
            return;
        }
    }

    public FixedLengthBlockOutputStream(OutputStream os, int blockSize) {
        this.closed = new AtomicBoolean(false);
        if ((os instanceof FileOutputStream) == false) goto L5;
        FileOutputStream fileOutputStream = (FileOutputStream) os;
        this.out = fileOutputStream.getChannel();
        this.buffer = ByteBuffer.allocateDirect(blockSize);
    L6:
        this.blockSize = blockSize;
        return;
    L5:
        this.out = new BufferAtATimeOutputChannel(os, null);
        this.buffer = ByteBuffer.allocate(blockSize);
        goto L6
    }

    public FixedLengthBlockOutputStream(WritableByteChannel out, int blockSize) {
        this.closed = new AtomicBoolean(false);
        this.out = out;
        this.blockSize = blockSize;
        this.buffer = ByteBuffer.allocateDirect(blockSize);
    }

    private void maybeFlush() throws IOException {
        if (this.buffer.hasRemaining() == true) goto L6;
        writeBlock();
        return;
    }

    private void writeBlock() throws IOException {
        this.buffer.flip();
        int i = this.out.write(this.buffer);
        boolean hasRemaining = this.buffer.hasRemaining();
        if (i != this.blockSize) goto L7;
        if (hasRemaining == true) goto L7;
        this.buffer.clear();
        return;
    L7:
        String msg = String.format("Failed to write %,d bytes atomically. Only wrote  %,d", new Object[]{Integer.valueOf(this.blockSize), Integer.valueOf(i)});
        throw new IOException(msg);
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        if (isOpen() == false) goto L7;
        this.buffer.put((byte) b);
        maybeFlush();
        return;
    L7:
        throw new ClosedChannelException();
    }

    @Override // java.io.OutputStream
    public void write(byte[] b, int offset, int length) throws IOException {
        if (isOpen() == false) goto L9;
        int off = offset;
        int len = length;
    L5:
        if (len <= 0) goto L7;
        int n = Math.min(len, this.buffer.remaining());
        this.buffer.put(b, off, n);
        maybeFlush();
        len = len - n;
        off = off + n;
        goto L5
    L7:
        return;
    L9:
        throw new ClosedChannelException();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer src) throws IOException {
        if (isOpen() == false) goto L16;
        int srcRemaining = src.remaining();
        if (srcRemaining >= this.buffer.remaining()) goto L7;
        this.buffer.put(src);
    L14:
        return srcRemaining;
    L7:
        int srcLeft = srcRemaining;
        int savedLimit = src.limit();
        if (this.buffer.position() == 0) goto L11;
        int n = this.buffer.remaining();
        src.limit(src.position() + n);
        this.buffer.put(src);
        writeBlock();
        srcLeft = srcLeft - n;
    L11:
        if (srcLeft < this.blockSize) goto L13;
        src.limit(src.position() + this.blockSize);
        this.out.write(src);
        srcLeft = srcLeft - this.blockSize;
        goto L11
    L13:
        src.limit(savedLimit);
        this.buffer.put(src);
        goto L14
    L16:
        throw new ClosedChannelException();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        if (this.out.isOpen() == true) goto L6;
        this.closed.set(true);
    L6:
        return !this.closed.get();
    }

    public void flushBlock() throws IOException {
        if (this.buffer.position() == 0) goto L6;
        padBlock();
        writeBlock();
        return;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        if (this.closed.compareAndSet(false, true) == true) goto L10;
        return;
    L10:
        flushBlock();     // Catch: Throwable -> L6
        this.out.close();
        return;
    L6:
        th = move-exception;
        this.out.close();
        throw th;
    }

    private void padBlock() {
        this.buffer.order(ByteOrder.nativeOrder());
        int bytesToWrite = this.buffer.remaining();
        if (bytesToWrite <= 8) goto L13;
        int align = this.buffer.position() & 7;
        if (align == 0) goto L10;
        int limit = 8 - align;
        int i = 0;
    L7:
        if (i >= limit) goto L9;
        this.buffer.put((byte) 0);
        i = i + 1;
        goto L7
    L9:
        bytesToWrite = bytesToWrite - limit;
    L10:
        if (bytesToWrite < 8) goto L13;
        this.buffer.putLong(0);
        bytesToWrite = bytesToWrite - 8;
    L13:
        if (this.buffer.hasRemaining() == false) goto L15;
        this.buffer.put((byte) 0);
        goto L13
    }
}
