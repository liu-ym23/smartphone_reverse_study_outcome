package org.apache.commons.compress.archivers.zip;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: classes3.dex */
class ExplodingInputStream extends InputStream implements InputStreamStatistics {
    private BitStream bits;
    private final CircularBuffer buffer;
    private final int dictionarySize;
    private BinaryTree distanceTree;
    private final InputStream in;
    private BinaryTree lengthTree;
    private BinaryTree literalTree;
    private final int minimumMatchLength;
    private final int numberOfTrees;
    private long treeSizes;
    private long uncompressedCount;

    public ExplodingInputStream(int dictionarySize, int numberOfTrees, InputStream in) {
        this.buffer = new CircularBuffer(32768);
        this.uncompressedCount = 0;
        this.treeSizes = 0;
        if (dictionarySize == 4096) goto L10;
        if (dictionarySize == 8192) goto L10;
        throw new IllegalArgumentException("The dictionary size must be 4096 or 8192");
    L10:
        if (numberOfTrees != 2) goto L12;
    L16:
        this.dictionarySize = dictionarySize;
        this.numberOfTrees = numberOfTrees;
        this.minimumMatchLength = numberOfTrees;
        this.in = in;
        return;
    L12:
        if (numberOfTrees == 3) goto L16;
        throw new IllegalArgumentException("The number of trees must be 2 or 3");
    }

    private void init() throws IOException {
        if (this.bits != null) goto L17;
        final InputStream r1 = this.in;
        CountingInputStream i = new AnonymousClass1(this, r1);
    L8:
        th = move-exception;
        i.close();     // Catch: Throwable -> L14
    L16:
        throw th;
    L14:
        th = move-exception;
        th.addSuppressed(th);
        goto L16
    L6:
        if (this.numberOfTrees != 3) goto L10;
        this.literalTree = BinaryTree.decode(i, 256);     // Catch: Throwable -> L8
    L10:
        this.lengthTree = BinaryTree.decode(i, 64);     // Catch: Throwable -> L8
        this.distanceTree = BinaryTree.decode(i, 64);     // Catch: Throwable -> L8
        this.treeSizes += i.getBytesRead();     // Catch: Throwable -> L8
        i.close();
        this.bits = new BitStream(this.in);
        return;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.buffer.available() == true) goto L5;
        fillBuffer();
    L5:
        int ret = this.buffer.get();
        if (ret <= (-1)) goto L8;
        this.uncompressedCount++;
    L8:
        return ret;
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.bits.getBytesRead() + this.treeSizes;
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getUncompressedCount() {
        return this.uncompressedCount;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.in.close();
    }

    private void fillBuffer() throws IOException {
        init();
        int bit = this.bits.nextBit();
        if (bit == 1) goto L5;
        if (bit == 0) goto L14;
        return;
    L14:
        if (this.dictionarySize != 4096) goto L16;
        int distanceLowSize = 6;
    L17:
        int distanceLow = (int) this.bits.nextBits(distanceLowSize);
        int distanceHigh = this.distanceTree.read(this.bits);
        if (distanceHigh != (-1)) goto L21;
        if (distanceLow > 0) goto L21;
        return;
    L21:
        int distance = (distanceHigh << distanceLowSize) | distanceLow;
        int length = this.lengthTree.read(this.bits);
        if (length != 63) goto L24;
        length = (int) (((long) length) + this.bits.nextBits(8));
    L24:
        int length2 = length + this.minimumMatchLength;
        this.buffer.copy(distance + 1, length2);
        return;
    L16:
        distanceLowSize = 7;
        goto L17
    L5:
        if (this.literalTree == null) goto L7;
        int literal = this.literalTree.read(this.bits);
    L8:
        if (literal != (-1)) goto L10;
        return;
    L10:
        this.buffer.put(literal);
        return;
    L7:
        literal = this.bits.nextByte();
        goto L8
    }
}
