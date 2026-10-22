package org.tukaani.xz.index;

import org.tukaani.xz.XZIOException;
import org.tukaani.xz.common.Util;

/* JADX INFO: loaded from: classes3.dex */
abstract class IndexBase {
    long blocksSum;
    long indexListSize;
    private final XZIOException invalidIndexException;
    long recordCount;
    long uncompressedSum;

    IndexBase(XZIOException invalidIndexException) {
        this.blocksSum = 0;
        this.uncompressedSum = 0;
        this.indexListSize = 0;
        this.recordCount = 0;
        this.invalidIndexException = invalidIndexException;
    }

    private long getUnpaddedIndexSize() {
        return (((long) (Util.getVLISize(this.recordCount) + 1)) + this.indexListSize) + 4;
    }

    public long getIndexSize() {
        return (getUnpaddedIndexSize() + 3) & (-4);
    }

    public long getStreamSize() {
        return ((this.blocksSum + 12) + getIndexSize()) + 12;
    }

    int getIndexPaddingSize() {
        return (int) ((4 - getUnpaddedIndexSize()) & 3);
    }

    void add(long unpaddedSize, long uncompressedSize) throws XZIOException {
        this.blocksSum += (3 + unpaddedSize) & (-4);
        this.uncompressedSum += uncompressedSize;
        this.indexListSize += (long) (Util.getVLISize(unpaddedSize) + Util.getVLISize(uncompressedSize));
        this.recordCount++;
        if (this.blocksSum < 0) goto L12;
        if (this.uncompressedSum < 0) goto L12;
        if (getIndexSize() > Util.BACKWARD_SIZE_MAX) goto L12;
        if (getStreamSize() < 0) goto L12;
        return;
    L12:
        throw this.invalidIndexException;
    }
}
