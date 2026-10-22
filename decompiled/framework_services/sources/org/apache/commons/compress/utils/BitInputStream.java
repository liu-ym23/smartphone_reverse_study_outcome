package org.apache.commons.compress.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes3.dex */
public class BitInputStream implements Closeable {
    private static final long[] MASKS = null;
    private static final int MAXIMUM_CACHE_SIZE = 63;
    private long bitsCached;
    private int bitsCachedSize;
    private final ByteOrder byteOrder;
    private final CountingInputStream in;

    static {
        MASKS = new long[64];
        int i = 1;
    L4:
        if (i > 63) goto L7;
        MASKS[i] = (MASKS[i - 1] << 1) + 1;
        i = i + 1;
        goto L4
    }

    public BitInputStream(InputStream in, ByteOrder byteOrder) {
        this.bitsCached = 0;
        this.bitsCachedSize = 0;
        this.in = new CountingInputStream(in);
        this.byteOrder = byteOrder;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
    }

    public void clearBitCache() {
        this.bitsCached = 0;
        this.bitsCachedSize = 0;
    }

    public long readBits(int count) throws IOException {
        if (count < 0) goto L16;
        if (count > 63) goto L16;
        if (ensureCache(count) == false) goto L10;
        return -1;
    L10:
        if (this.bitsCachedSize >= count) goto L14;
        return processBitsGreater57(count);
    L14:
        return readCachedBits(count);
    L16:
        throw new IllegalArgumentException("count must not be negative or greater than 63");
    }

    public int bitsCached() {
        return this.bitsCachedSize;
    }

    public long bitsAvailable() throws IOException {
        return ((long) this.bitsCachedSize) + (((long) this.in.available()) * 8);
    }

    public void alignWithByteBoundary() {
        int toSkip = this.bitsCachedSize % 8;
        if (toSkip <= 0) goto L6;
        readCachedBits(toSkip);
        return;
    }

    public long getBytesRead() {
        return this.in.getBytesRead();
    }

    private long processBitsGreater57(int count) throws IOException {
        int bitsToAddCount = count - this.bitsCachedSize;
        int overflowBits = 8 - bitsToAddCount;
        long nextByte = this.in.read();
        if (nextByte >= 0) goto L6;
        return nextByte;
    L6:
        if (this.byteOrder != ByteOrder.LITTLE_ENDIAN) goto L8;
        long bitsToAdd = MASKS[bitsToAddCount] & nextByte;
        this.bitsCached |= bitsToAdd << this.bitsCachedSize;
        long overflow = (nextByte >>> bitsToAddCount) & MASKS[overflowBits];
    L9:
        long bitsToAdd2 = this.bitsCached;
        long bitsOut = bitsToAdd2 & MASKS[count];
        this.bitsCached = overflow;
        this.bitsCachedSize = overflowBits;
        return bitsOut;
    L8:
        this.bitsCached <<= bitsToAddCount;
        long bitsToAdd3 = (nextByte >>> overflowBits) & MASKS[bitsToAddCount];
        this.bitsCached |= bitsToAdd3;
        overflow = nextByte & MASKS[overflowBits];
        goto L9
    }

    private long readCachedBits(int count) {
        if (this.byteOrder != ByteOrder.LITTLE_ENDIAN) goto L5;
        long bitsOut = this.bitsCached & MASKS[count];
        this.bitsCached >>>= count;
    L6:
        this.bitsCachedSize -= count;
        return bitsOut;
    L5:
        long bitsOut2 = this.bitsCached;
        bitsOut = (bitsOut2 >> (this.bitsCachedSize - count)) & MASKS[count];
        goto L6
    }

    private boolean ensureCache(int count) throws IOException {
    L3:
        if (this.bitsCachedSize >= count) goto L15;
        if (this.bitsCachedSize >= 57) goto L22;
        long nextByte = this.in.read();
        if (nextByte < 0) goto L8;
        if (this.byteOrder != ByteOrder.LITTLE_ENDIAN) goto L13;
        this.bitsCached |= nextByte << this.bitsCachedSize;
    L14:
        this.bitsCachedSize += 8;
        goto L3
    L13:
        this.bitsCached <<= 8;
        this.bitsCached |= nextByte;
        goto L14
    L8:
        return true;
    L22:
        return false;
    L15:
        return false;
    }
}
