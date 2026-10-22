package org.tukaani.xz.index;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class BlockInfo {
    IndexDecoder index;
    public int blockNumber = -1;
    public long compressedOffset = -1;
    public long uncompressedOffset = -1;
    public long unpaddedSize = -1;
    public long uncompressedSize = -1;

    public BlockInfo(IndexDecoder indexDecoder) {
        this.index = indexDecoder;
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
