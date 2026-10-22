package org.tukaani.xz.index;

import com.android.server.storage.DeviceStorageMonitorServiceSmtEx;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import org.tukaani.xz.CorruptedInputException;
import org.tukaani.xz.MemoryLimitException;
import org.tukaani.xz.SeekableInputStream;
import org.tukaani.xz.UnsupportedOptionsException;
import org.tukaani.xz.common.DecoderUtil;
import org.tukaani.xz.common.StreamFlags;

/* JADX INFO: loaded from: classes3.dex */
public class IndexDecoder extends IndexBase {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private long compressedOffset;
    private long largestBlockSize;
    private final int memoryUsage;
    private int recordOffset;
    private final StreamFlags streamFlags;
    private final long streamPadding;
    private final long[] uncompressed;
    private long uncompressedOffset;
    private final long[] unpadded;

    static {
    }

    @Override // org.tukaani.xz.index.IndexBase
    public /* bridge */ /* synthetic */ long getIndexSize() {
        return super.getIndexSize();
    }

    @Override // org.tukaani.xz.index.IndexBase
    public /* bridge */ /* synthetic */ long getStreamSize() {
        return super.getStreamSize();
    }

    public IndexDecoder(SeekableInputStream in, StreamFlags streamFooterFlags, long streamPadding, int memoryLimit) throws IOException {
        super(new CorruptedInputException("XZ Index is corrupt"));
        this.largestBlockSize = 0;
        this.recordOffset = 0;
        this.compressedOffset = 0;
        this.uncompressedOffset = 0;
        this.streamFlags = streamFooterFlags;
        this.streamPadding = streamPadding;
        long endPos = (in.position() + streamFooterFlags.backwardSize) - 4;
        CRC32 crc32 = new CRC32();
        CheckedInputStream inChecked = new CheckedInputStream(in, crc32);
        if (inChecked.read() != 0) goto L55;
        long count = DecoderUtil.decodeVLI(inChecked);     // Catch: EOFException -> L15
        if (count >= (streamFooterFlags.backwardSize / 2)) goto L51;
        if (count > 2147483647L) goto L49;
        this.memoryUsage = ((int) (((16 * count) + 1023) / DeviceStorageMonitorServiceSmtEx.TrafficStats.KB_IN_BYTES)) + 1;     // Catch: EOFException -> L15
        if (memoryLimit < 0) goto L17;
        if (this.memoryUsage <= memoryLimit) goto L17;
        throw new MemoryLimitException(this.memoryUsage, memoryLimit);     // Catch: EOFException -> L15
    L17:
        this.unpadded = new long[(int) count];     // Catch: EOFException -> L15
        this.uncompressed = new long[(int) count];     // Catch: EOFException -> L15
        int record = 0;
        int i = (int) count;     // Catch: EOFException -> L15
    L18:
        if (i <= 0) goto L27;
        long unpaddedSize = DecoderUtil.decodeVLI(inChecked);     // Catch: EOFException -> L15
        long uncompressedSize = DecoderUtil.decodeVLI(inChecked);     // Catch: EOFException -> L15
        if (in.position() > endPos) goto L26;
        this.unpadded[record] = this.blocksSum + unpaddedSize;     // Catch: EOFException -> L15
        this.uncompressed[record] = this.uncompressedSum + uncompressedSize;     // Catch: EOFException -> L15
        record = record + 1;     // Catch: EOFException -> L15
        super.add(unpaddedSize, uncompressedSize);     // Catch: EOFException -> L15
        if (this.largestBlockSize >= uncompressedSize) goto L24;
        this.largestBlockSize = uncompressedSize;     // Catch: EOFException -> L15
    L24:
        i = i - 1;     // Catch: EOFException -> L15
        goto L18
    L26:
        throw new CorruptedInputException("XZ Index is corrupt");     // Catch: EOFException -> L15
    L27:
        int indexPaddingSize = getIndexPaddingSize();
        if ((in.position() + ((long) indexPaddingSize)) != endPos) goto L47;
    L29:
        int indexPaddingSize2 = indexPaddingSize - 1;
        if (indexPaddingSize <= 0) goto L36;
        if (inChecked.read() != 0) goto L35;
        indexPaddingSize = indexPaddingSize2;
        goto L29
    L35:
        throw new CorruptedInputException("XZ Index is corrupt");
    L36:
        long value = crc32.getValue();
        int i2 = 0;
    L38:
        if (i2 >= 4) goto L45;
        if (((value >>> (i2 * 8)) & 255) != in.read()) goto L43;
        i2 = i2 + 1;
        goto L38
    L43:
        throw new CorruptedInputException("XZ Index is corrupt");
    L45:
        return;
    L47:
        throw new CorruptedInputException("XZ Index is corrupt");
    L49:
        throw new UnsupportedOptionsException("XZ Index has over 2147483647 Records");     // Catch: EOFException -> L15
    L51:
        throw new CorruptedInputException("XZ Index is corrupt");     // Catch: EOFException -> L15
    L53:
        throw new CorruptedInputException("XZ Index is corrupt");
    L55:
        throw new CorruptedInputException("XZ Index is corrupt");
    }

    public void setOffsets(IndexDecoder prev) {
        this.recordOffset = prev.recordOffset + ((int) prev.recordCount);
        this.compressedOffset = (prev.compressedOffset + prev.getStreamSize()) + prev.streamPadding;
        this.uncompressedOffset = prev.uncompressedOffset + prev.uncompressedSum;
    }

    public int getMemoryUsage() {
        return this.memoryUsage;
    }

    public StreamFlags getStreamFlags() {
        return this.streamFlags;
    }

    public int getRecordCount() {
        return (int) this.recordCount;
    }

    public long getUncompressedSize() {
        return this.uncompressedSum;
    }

    public long getLargestBlockSize() {
        return this.largestBlockSize;
    }

    public boolean hasUncompressedOffset(long pos) {
        if (pos >= this.uncompressedOffset) goto L5;
    L7:
        return false;
    L5:
        if (pos >= (this.uncompressedOffset + this.uncompressedSum)) goto L7;
        return true;
    }

    public boolean hasRecord(int blockNumber) {
        if (blockNumber >= this.recordOffset) goto L5;
    L7:
        return false;
    L5:
        if (blockNumber >= (((long) this.recordOffset) + this.recordCount)) goto L7;
        return true;
    }

    public void locateBlock(BlockInfo info, long target) {
        long target2 = target - this.uncompressedOffset;
        int left = 0;
        int right = this.unpadded.length - 1;
    L3:
        if (left >= right) goto L9;
        int i = ((right - left) / 2) + left;
        if (this.uncompressed[i] <= target2) goto L6;
        right = i;
        goto L3
    L6:
        left = i + 1;
        goto L3
    L9:
        setBlockInfo(info, this.recordOffset + left);
    }

    public void setBlockInfo(BlockInfo info, int blockNumber) {
        info.index = this;
        info.blockNumber = blockNumber;
        int pos = blockNumber - this.recordOffset;
        if (pos != 0) goto L5;
        info.compressedOffset = 0;
        info.uncompressedOffset = 0;
    L6:
        info.unpaddedSize = this.unpadded[pos] - info.compressedOffset;
        info.uncompressedSize = this.uncompressed[pos] - info.uncompressedOffset;
        info.compressedOffset += this.compressedOffset + 12;
        info.uncompressedOffset += this.uncompressedOffset;
        return;
    L5:
        info.compressedOffset = (this.unpadded[pos - 1] + 3) & (-4);
        info.uncompressedOffset = this.uncompressed[pos - 1];
        goto L6
    }
}
