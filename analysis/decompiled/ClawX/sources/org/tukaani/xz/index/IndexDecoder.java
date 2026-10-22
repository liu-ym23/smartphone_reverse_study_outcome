package org.tukaani.xz.index;

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

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class IndexDecoder extends IndexBase {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IndexDecoder(SeekableInputStream seekableInputStream, StreamFlags streamFlags, long j4, int i8) throws IOException {
        super(new CorruptedInputException("XZ Index is corrupt"));
        String str = "XZ Index is corrupt";
        this.largestBlockSize = 0L;
        this.recordOffset = 0;
        this.compressedOffset = 0L;
        this.uncompressedOffset = 0L;
        this.streamFlags = streamFlags;
        this.streamPadding = j4;
        long jPosition = (seekableInputStream.position() + streamFlags.backwardSize) - 4;
        CRC32 crc32 = new CRC32();
        CheckedInputStream checkedInputStream = new CheckedInputStream(seekableInputStream, crc32);
        if (checkedInputStream.read() != 0) {
            throw new CorruptedInputException("XZ Index is corrupt");
        }
        try {
            long jDecodeVLI = DecoderUtil.decodeVLI(checkedInputStream);
            try {
                if (jDecodeVLI >= streamFlags.backwardSize / 2) {
                    throw new CorruptedInputException("XZ Index is corrupt");
                }
                if (jDecodeVLI > 2147483647L) {
                    throw new UnsupportedOptionsException("XZ Index has over 2147483647 Records");
                }
                int i9 = ((int) (((16 * jDecodeVLI) + 1023) / 1024)) + 1;
                this.memoryUsage = i9;
                if (i8 >= 0 && i9 > i8) {
                    throw new MemoryLimitException(i9, i8);
                }
                int i10 = (int) jDecodeVLI;
                this.unpadded = new long[i10];
                this.uncompressed = new long[i10];
                int i11 = 0;
                while (i10 > 0) {
                    long jDecodeVLI2 = DecoderUtil.decodeVLI(checkedInputStream);
                    long jDecodeVLI3 = DecoderUtil.decodeVLI(checkedInputStream);
                    if (seekableInputStream.position() > jPosition) {
                        throw new CorruptedInputException(str);
                    }
                    String str2 = str;
                    this.unpadded[i11] = this.blocksSum + jDecodeVLI2;
                    int i12 = i10;
                    int i13 = i11;
                    this.uncompressed[i13] = this.uncompressedSum + jDecodeVLI3;
                    i11 = i13 + 1;
                    super.add(jDecodeVLI2, jDecodeVLI3);
                    if (this.largestBlockSize < jDecodeVLI3) {
                        this.largestBlockSize = jDecodeVLI3;
                    }
                    i10 = i12 - 1;
                    str = str2;
                }
                String str3 = str;
                int indexPaddingSize = getIndexPaddingSize();
                if (seekableInputStream.position() + indexPaddingSize != jPosition) {
                    throw new CorruptedInputException(str3);
                }
                while (true) {
                    int i14 = indexPaddingSize - 1;
                    if (indexPaddingSize <= 0) {
                        long value = crc32.getValue();
                        for (int i15 = 0; i15 < 4; i15++) {
                            if (((value >>> (i15 * 8)) & 255) != seekableInputStream.read()) {
                                throw new CorruptedInputException(str3);
                            }
                        }
                        return;
                    }
                    if (checkedInputStream.read() != 0) {
                        throw new CorruptedInputException(str3);
                    }
                    indexPaddingSize = i14;
                }
            } catch (EOFException unused) {
                throw new CorruptedInputException("XZ Index is corrupt");
            }
        } catch (EOFException unused2) {
        }
    }

    @Override // org.tukaani.xz.index.IndexBase
    public /* bridge */ /* synthetic */ long getIndexSize() {
        return super.getIndexSize();
    }

    public long getLargestBlockSize() {
        return this.largestBlockSize;
    }

    public int getMemoryUsage() {
        return this.memoryUsage;
    }

    public int getRecordCount() {
        return (int) this.recordCount;
    }

    public StreamFlags getStreamFlags() {
        return this.streamFlags;
    }

    @Override // org.tukaani.xz.index.IndexBase
    public /* bridge */ /* synthetic */ long getStreamSize() {
        return super.getStreamSize();
    }

    public long getUncompressedSize() {
        return this.uncompressedSum;
    }

    public boolean hasRecord(int i8) {
        int i9 = this.recordOffset;
        return i8 >= i9 && ((long) i8) < ((long) i9) + this.recordCount;
    }

    public boolean hasUncompressedOffset(long j4) {
        long j8 = this.uncompressedOffset;
        return j4 >= j8 && j4 < j8 + this.uncompressedSum;
    }

    public void locateBlock(BlockInfo blockInfo, long j4) {
        long j8 = j4 - this.uncompressedOffset;
        int length = this.unpadded.length - 1;
        int i8 = 0;
        while (i8 < length) {
            int i9 = ((length - i8) / 2) + i8;
            if (this.uncompressed[i9] <= j8) {
                i8 = i9 + 1;
            } else {
                length = i9;
            }
        }
        setBlockInfo(blockInfo, this.recordOffset + i8);
    }

    public void setBlockInfo(BlockInfo blockInfo, int i8) {
        blockInfo.index = this;
        blockInfo.blockNumber = i8;
        int i9 = i8 - this.recordOffset;
        if (i9 == 0) {
            blockInfo.compressedOffset = 0L;
            blockInfo.uncompressedOffset = 0L;
        } else {
            int i10 = i9 - 1;
            blockInfo.compressedOffset = (this.unpadded[i10] + 3) & (-4);
            blockInfo.uncompressedOffset = this.uncompressed[i10];
        }
        long j4 = this.unpadded[i9];
        long j8 = blockInfo.compressedOffset;
        blockInfo.unpaddedSize = j4 - j8;
        long j9 = this.uncompressed[i9];
        long j10 = blockInfo.uncompressedOffset;
        blockInfo.uncompressedSize = j9 - j10;
        blockInfo.compressedOffset = this.compressedOffset + 12 + j8;
        blockInfo.uncompressedOffset = j10 + this.uncompressedOffset;
    }

    public void setOffsets(IndexDecoder indexDecoder) {
        this.recordOffset = indexDecoder.recordOffset + ((int) indexDecoder.recordCount);
        this.compressedOffset = indexDecoder.getStreamSize() + indexDecoder.compressedOffset + indexDecoder.streamPadding;
        this.uncompressedOffset = indexDecoder.uncompressedOffset + indexDecoder.uncompressedSum;
    }
}
