package org.apache.commons.compress.utils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SeekableByteChannel;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class SeekableInMemoryByteChannel implements SeekableByteChannel {
    private static final int NAIVE_RESIZE_LIMIT = 1073741823;
    private final AtomicBoolean closed;
    private byte[] data;
    private int position;
    private int size;

    public SeekableInMemoryByteChannel(byte[] data) {
        this.closed = new AtomicBoolean();
        this.data = data;
        this.size = data.length;
    }

    public SeekableInMemoryByteChannel() {
        this(new byte[0]);
    }

    public SeekableInMemoryByteChannel(int size) {
        this(new byte[size]);
    }

    @Override // java.nio.channels.SeekableByteChannel
    public long position() {
        return this.position;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public SeekableByteChannel position(long newPosition) throws IOException {
        ensureOpen();
        if (newPosition < 0) goto L9;
        if (newPosition > 2147483647L) goto L9;
        this.position = (int) newPosition;
        return this;
    L9:
        throw new IllegalArgumentException("Position has to be in range 0.. 2147483647");
    }

    @Override // java.nio.channels.SeekableByteChannel
    public long size() {
        return this.size;
    }

    @Override // java.nio.channels.SeekableByteChannel
    public SeekableByteChannel truncate(long newSize) {
        if (this.size <= newSize) goto L5;
        this.size = (int) newSize;
    L5:
        repositionIfNecessary();
        return this;
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer buf) throws IOException {
        ensureOpen();
        repositionIfNecessary();
        int wanted = buf.remaining();
        int possible = this.size - this.position;
        if (possible > 0) goto L6;
        return -1;
    L6:
        if (wanted <= possible) goto L8;
        wanted = possible;
    L8:
        buf.put(this.data, this.position, wanted);
        this.position += wanted;
        return wanted;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed.set(true);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed.get();
    }

    @Override // java.nio.channels.SeekableByteChannel, java.nio.channels.WritableByteChannel
    public int write(ByteBuffer b) throws IOException {
        ensureOpen();
        int wanted = b.remaining();
        int possibleWithoutResize = this.size - this.position;
        if (wanted <= possibleWithoutResize) goto L8;
        int newSize = this.position + wanted;
        if (newSize >= 0) goto L7;
        resize(Integer.MAX_VALUE);
        wanted = Integer.MAX_VALUE - this.position;
        goto L8
    L7:
        resize(newSize);
    L8:
        b.get(this.data, this.position, wanted);
        this.position += wanted;
        if (this.size >= this.position) goto L11;
        this.size = this.position;
    L11:
        return wanted;
    }

    public byte[] array() {
        return this.data;
    }

    private void resize(int newLength) {
        int len = this.data.length;
        if (len > 0) goto L6;
        len = 1;
    L6:
        if (newLength >= NAIVE_RESIZE_LIMIT) goto L9;
    L7:
        if (len >= newLength) goto L10;
        len = len << 1;
    L10:
        this.data = Arrays.copyOf(this.data, len);
        return;
    L9:
        len = newLength;
        goto L10
    }

    private void ensureOpen() throws ClosedChannelException {
        if (isOpen() == false) goto L6;
        return;
    L6:
        throw new ClosedChannelException();
    }

    private void repositionIfNecessary() {
        if (this.position <= this.size) goto L6;
        this.position = this.size;
        return;
    }
}
