package org.apache.commons.compress.archivers.sevenz;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;

/* JADX INFO: loaded from: classes3.dex */
class BoundedSeekableByteChannelInputStream extends InputStream {
    private static final int MAX_BUF_LEN = 8192;
    private final ByteBuffer buffer;
    private long bytesRemaining;
    private final SeekableByteChannel channel;

    public BoundedSeekableByteChannelInputStream(SeekableByteChannel channel, long size) {
        this.channel = channel;
        this.bytesRemaining = size;
        if (size < 8192) goto L5;
    L7:
        this.buffer = ByteBuffer.allocate(8192);
        return;
    L5:
        if (size <= 0) goto L7;
        this.buffer = ByteBuffer.allocate((int) size);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.bytesRemaining <= 0) goto L9;
        this.bytesRemaining--;
        int read = read(1);
        if (read >= 0) goto L8;
        return read;
    L8:
        return this.buffer.get() & CecDeviceType.INACTIVE;
    L9:
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        if (this.bytesRemaining != 0) goto L6;
        return -1;
    L6:
        int bytesToRead = len;
        if (bytesToRead <= this.bytesRemaining) goto L10;
        bytesToRead = (int) this.bytesRemaining;
    L10:
        if (bytesToRead > this.buffer.capacity()) goto L12;
        ByteBuffer buf = this.buffer;
        int bytesRead = read(bytesToRead);
    L13:
        if (bytesRead < 0) goto L15;
        buf.get(b, off, bytesRead);
        this.bytesRemaining -= (long) bytesRead;
    L15:
        return bytesRead;
    L12:
        buf = ByteBuffer.allocate(bytesToRead);
        bytesRead = this.channel.read(buf);
        buf.flip();
        goto L13
    }

    private int read(int len) throws IOException {
        this.buffer.rewind().limit(len);
        int read = this.channel.read(this.buffer);
        this.buffer.flip();
        return read;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }
}
