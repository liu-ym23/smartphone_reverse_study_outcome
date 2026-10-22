package org.tukaani.xz.index;

/* JADX INFO: loaded from: classes3.dex */
public class BlockInfo {
    public int blockNumber;
    public long compressedOffset;
    IndexDecoder index;
    public long uncompressedOffset;
    public long uncompressedSize;
    public long unpaddedSize;

    public BlockInfo(IndexDecoder indexOfFirstStream) {
        this.blockNumber = -1;
        this.compressedOffset = -1;
        this.uncompressedOffset = -1;
        this.unpaddedSize = -1;
        this.uncompressedSize = -1;
        this.index = indexOfFirstStream;
    }

    public int getCheckType() {
        return this.index.getStreamFlags().checkType;
    }

    public boolean hasNext() {
        return this.index.hasRecord(this.blockNumber + 1);
    }

    public void setNext() {
        this.index.setBlockInfo(this, this.blockNumber + 1);
    }
}
