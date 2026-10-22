package org.tukaani.xz;

import a8.b;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.tukaani.xz.check.Check;
import org.tukaani.xz.common.DecoderUtil;
import org.tukaani.xz.common.StreamFlags;
import org.tukaani.xz.index.BlockInfo;
import org.tukaani.xz.index.IndexDecoder;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class SeekableXZInputStream extends SeekableInputStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final ArrayCache arrayCache;
    private int blockCount;
    private BlockInputStream blockDecoder;
    private Check check;
    private int checkTypes;
    private final BlockInfo curBlockInfo;
    private long curPos;
    private boolean endReached;
    private IOException exception;
    private SeekableInputStream in;
    private int indexMemoryUsage;
    private long largestBlockSize;
    private final int memoryLimit;
    private final BlockInfo queriedBlockInfo;
    private boolean seekNeeded;
    private long seekPos;
    private final ArrayList<IndexDecoder> streams;
    private final byte[] tempBuf;
    private long uncompressedSize;
    private final boolean verifyCheck;

    public SeekableXZInputStream(SeekableInputStream seekableInputStream) {
        this(seekableInputStream, -1);
    }

    private void initBlockDecoder() throws IOException {
        try {
            BlockInputStream blockInputStream = this.blockDecoder;
            if (blockInputStream != null) {
                blockInputStream.close();
                this.blockDecoder = null;
            }
            SeekableInputStream seekableInputStream = this.in;
            Check check = this.check;
            boolean z = this.verifyCheck;
            int i8 = this.memoryLimit;
            BlockInfo blockInfo = this.curBlockInfo;
            this.blockDecoder = new BlockInputStream(seekableInputStream, check, z, i8, blockInfo.unpaddedSize, blockInfo.uncompressedSize, this.arrayCache);
        } catch (IndexIndicatorException unused) {
            throw new CorruptedInputException();
        } catch (MemoryLimitException e9) {
            int memoryNeeded = e9.getMemoryNeeded();
            int i9 = this.indexMemoryUsage;
            throw new MemoryLimitException(memoryNeeded + i9, this.memoryLimit + i9);
        }
    }

    private void locateBlockByNumber(BlockInfo blockInfo, int i8) {
        if (i8 < 0 || i8 >= this.blockCount) {
            throw new IndexOutOfBoundsException(b.j(i8, "Invalid XZ Block number: "));
        }
        if (blockInfo.blockNumber == i8) {
            return;
        }
        int i9 = 0;
        while (true) {
            IndexDecoder indexDecoder = this.streams.get(i9);
            if (indexDecoder.hasRecord(i8)) {
                indexDecoder.setBlockInfo(blockInfo, i8);
                return;
            }
            i9++;
        }
    }

    private void locateBlockByPos(BlockInfo blockInfo, long j4) {
        if (j4 < 0 || j4 >= this.uncompressedSize) {
            throw new IndexOutOfBoundsException(b.l(j4, "Invalid uncompressed position: "));
        }
        int i8 = 0;
        while (true) {
            IndexDecoder indexDecoder = this.streams.get(i8);
            if (indexDecoder.hasUncompressedOffset(j4)) {
                indexDecoder.locateBlock(blockInfo, j4);
                return;
            }
            i8++;
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        BlockInputStream blockInputStream;
        if (this.in == null) {
            throw new XZIOException("Stream closed");
        }
        IOException iOException = this.exception;
        if (iOException != null) {
            throw iOException;
        }
        if (this.endReached || this.seekNeeded || (blockInputStream = this.blockDecoder) == null) {
            return 0;
        }
        return blockInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        close(true);
    }

    public int getBlockCheckType(int i8) {
        locateBlockByNumber(this.queriedBlockInfo, i8);
        return this.queriedBlockInfo.getCheckType();
    }

    public long getBlockCompPos(int i8) {
        locateBlockByNumber(this.queriedBlockInfo, i8);
        return this.queriedBlockInfo.compressedOffset;
    }

    public long getBlockCompSize(int i8) {
        locateBlockByNumber(this.queriedBlockInfo, i8);
        return (this.queriedBlockInfo.unpaddedSize + 3) & (-4);
    }

    public int getBlockCount() {
        return this.blockCount;
    }

    public int getBlockNumber(long j4) {
        locateBlockByPos(this.queriedBlockInfo, j4);
        return this.queriedBlockInfo.blockNumber;
    }

    public long getBlockPos(int i8) {
        locateBlockByNumber(this.queriedBlockInfo, i8);
        return this.queriedBlockInfo.uncompressedOffset;
    }

    public long getBlockSize(int i8) {
        locateBlockByNumber(this.queriedBlockInfo, i8);
        return this.queriedBlockInfo.uncompressedSize;
    }

    public int getCheckTypes() {
        return this.checkTypes;
    }

    public int getIndexMemoryUsage() {
        return this.indexMemoryUsage;
    }

    public long getLargestBlockSize() {
        return this.largestBlockSize;
    }

    public int getStreamCount() {
        return this.streams.size();
    }

    @Override // org.tukaani.xz.SeekableInputStream
    public long length() {
        return this.uncompressedSize;
    }

    @Override // org.tukaani.xz.SeekableInputStream
    public long position() throws XZIOException {
        if (this.in != null) {
            return this.seekNeeded ? this.seekPos : this.curPos;
        }
        throw new XZIOException("Stream closed");
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.tempBuf, 0, 1) == -1) {
            return -1;
        }
        return this.tempBuf[0] & 255;
    }

    @Override // org.tukaani.xz.SeekableInputStream
    public void seek(long j4) throws XZIOException {
        if (this.in == null) {
            throw new XZIOException("Stream closed");
        }
        if (j4 < 0) {
            throw new XZIOException(b.l(j4, "Negative seek position: "));
        }
        this.seekPos = j4;
        this.seekNeeded = true;
    }

    public void seekToBlock(int i8) throws XZIOException {
        if (this.in == null) {
            throw new XZIOException("Stream closed");
        }
        if (i8 < 0 || i8 >= this.blockCount) {
            throw new XZIOException(b.j(i8, "Invalid XZ Block number: "));
        }
        locateBlockByNumber(this.queriedBlockInfo, i8);
        this.seekPos = this.queriedBlockInfo.uncompressedOffset;
        this.seekNeeded = true;
    }

    public SeekableXZInputStream(SeekableInputStream seekableInputStream, ArrayCache arrayCache) {
        this(seekableInputStream, -1, arrayCache);
    }

    public void close(boolean z) throws IOException {
        if (this.in != null) {
            BlockInputStream blockInputStream = this.blockDecoder;
            if (blockInputStream != null) {
                blockInputStream.close();
                this.blockDecoder = null;
            }
            if (z) {
                try {
                    this.in.close();
                } finally {
                    this.in = null;
                }
            }
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i8, int i9) throws IOException {
        int i10;
        if (i8 < 0 || i9 < 0 || (i10 = i8 + i9) < 0 || i10 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i11 = 0;
        if (i9 == 0) {
            return 0;
        }
        if (this.in == null) {
            throw new XZIOException("Stream closed");
        }
        IOException iOException = this.exception;
        if (iOException != null) {
            throw iOException;
        }
        try {
            if (this.seekNeeded) {
                seek();
            }
            if (this.endReached) {
                return -1;
            }
            while (i9 > 0) {
                if (this.blockDecoder == null) {
                    seek();
                    if (this.endReached) {
                        break;
                    }
                }
                int i12 = this.blockDecoder.read(bArr, i8, i9);
                if (i12 > 0) {
                    this.curPos += i12;
                    i11 += i12;
                    i8 += i12;
                    i9 -= i12;
                } else if (i12 == -1) {
                    this.blockDecoder = null;
                }
            }
            return i11;
        } catch (IOException e9) {
            e = e9;
            if (e instanceof EOFException) {
                e = new CorruptedInputException();
            }
            this.exception = e;
            if (i11 != 0) {
                return i11;
            }
            throw e;
        }
    }

    public SeekableXZInputStream(SeekableInputStream seekableInputStream, int i8) {
        this(seekableInputStream, i8, true);
    }

    public SeekableXZInputStream(SeekableInputStream seekableInputStream, int i8, ArrayCache arrayCache) {
        this(seekableInputStream, i8, true, arrayCache);
    }

    public SeekableXZInputStream(SeekableInputStream seekableInputStream, int i8, boolean z) {
        this(seekableInputStream, i8, z, ArrayCache.getDefaultCache());
    }

    public SeekableXZInputStream(SeekableInputStream seekableInputStream, int i8, boolean z, ArrayCache arrayCache) throws IOException {
        this.indexMemoryUsage = 0;
        this.streams = new ArrayList<>();
        this.checkTypes = 0;
        long j4 = 0;
        this.uncompressedSize = 0L;
        this.largestBlockSize = 0L;
        this.blockCount = 0;
        this.blockDecoder = null;
        this.curPos = 0L;
        this.seekNeeded = false;
        this.endReached = false;
        this.exception = null;
        this.tempBuf = new byte[1];
        this.arrayCache = arrayCache;
        this.verifyCheck = z;
        this.in = seekableInputStream;
        DataInputStream dataInputStream = new DataInputStream(seekableInputStream);
        seekableInputStream.seek(0L);
        byte[] bArr = XZ.HEADER_MAGIC;
        byte[] bArr2 = new byte[bArr.length];
        dataInputStream.readFully(bArr2);
        if (Arrays.equals(bArr2, bArr)) {
            long length = seekableInputStream.length();
            if ((3 & length) == 0) {
                byte[] bArr3 = new byte[12];
                int memoryUsage = i8;
                while (true) {
                    long j8 = j4;
                    while (length > j4) {
                        if (length >= 12) {
                            long j9 = j4;
                            long j10 = length - 12;
                            seekableInputStream.seek(j10);
                            dataInputStream.readFully(bArr3);
                            if (bArr3[8] == 0 && bArr3[9] == 0 && bArr3[10] == 0 && bArr3[11] == 0) {
                                j8 += 4;
                                length -= 4;
                                j4 = j9;
                            } else {
                                StreamFlags streamFlagsDecodeStreamFooter = DecoderUtil.decodeStreamFooter(bArr3);
                                if (streamFlagsDecodeStreamFooter.backwardSize < j10) {
                                    this.check = Check.getInstance(streamFlagsDecodeStreamFooter.checkType);
                                    this.checkTypes |= 1 << streamFlagsDecodeStreamFooter.checkType;
                                    seekableInputStream.seek(j10 - streamFlagsDecodeStreamFooter.backwardSize);
                                    try {
                                        IndexDecoder indexDecoder = new IndexDecoder(seekableInputStream, streamFlagsDecodeStreamFooter, j8, memoryUsage);
                                        this.indexMemoryUsage = indexDecoder.getMemoryUsage() + this.indexMemoryUsage;
                                        memoryUsage = memoryUsage >= 0 ? memoryUsage - indexDecoder.getMemoryUsage() : memoryUsage;
                                        if (this.largestBlockSize < indexDecoder.getLargestBlockSize()) {
                                            this.largestBlockSize = indexDecoder.getLargestBlockSize();
                                        }
                                        long streamSize = indexDecoder.getStreamSize() - 12;
                                        if (j10 >= streamSize) {
                                            long j11 = j10 - streamSize;
                                            seekableInputStream.seek(j11);
                                            dataInputStream.readFully(bArr3);
                                            if (DecoderUtil.areStreamFlagsEqual(DecoderUtil.decodeStreamHeader(bArr3), streamFlagsDecodeStreamFooter)) {
                                                long uncompressedSize = indexDecoder.getUncompressedSize() + this.uncompressedSize;
                                                this.uncompressedSize = uncompressedSize;
                                                if (uncompressedSize >= j9) {
                                                    int recordCount = indexDecoder.getRecordCount() + this.blockCount;
                                                    this.blockCount = recordCount;
                                                    if (recordCount >= 0) {
                                                        this.streams.add(indexDecoder);
                                                        length = j11;
                                                        j4 = j9;
                                                    } else {
                                                        throw new UnsupportedOptionsException("XZ file has over 2147483647 Blocks");
                                                    }
                                                } else {
                                                    throw new UnsupportedOptionsException("XZ file is too big");
                                                }
                                            } else {
                                                throw new CorruptedInputException("XZ Stream Footer does not match Stream Header");
                                            }
                                        } else {
                                            throw new CorruptedInputException("XZ Index indicates too big compressed size for the XZ Stream");
                                        }
                                    } catch (MemoryLimitException e9) {
                                        int memoryNeeded = e9.getMemoryNeeded();
                                        int i9 = this.indexMemoryUsage;
                                        throw new MemoryLimitException(memoryNeeded + i9, memoryUsage + i9);
                                    }
                                } else {
                                    throw new CorruptedInputException("Backward Size in XZ Stream Footer is too big");
                                }
                            }
                        } else {
                            throw new CorruptedInputException();
                        }
                    }
                    this.memoryLimit = memoryUsage;
                    ArrayList<IndexDecoder> arrayList = this.streams;
                    IndexDecoder indexDecoder2 = arrayList.get(arrayList.size() - 1);
                    int size = this.streams.size() - 2;
                    while (size >= 0) {
                        IndexDecoder indexDecoder3 = this.streams.get(size);
                        indexDecoder3.setOffsets(indexDecoder2);
                        size--;
                        indexDecoder2 = indexDecoder3;
                    }
                    ArrayList<IndexDecoder> arrayList2 = this.streams;
                    IndexDecoder indexDecoder4 = arrayList2.get(arrayList2.size() - 1);
                    this.curBlockInfo = new BlockInfo(indexDecoder4);
                    this.queriedBlockInfo = new BlockInfo(indexDecoder4);
                    return;
                }
            }
            throw new CorruptedInputException("XZ file size is not a multiple of 4 bytes");
        }
        throw new XZFormatException();
    }

    private void seek() throws IOException {
        if (!this.seekNeeded) {
            if (this.curBlockInfo.hasNext()) {
                this.curBlockInfo.setNext();
                initBlockDecoder();
                return;
            }
            this.seekPos = this.curPos;
        }
        this.seekNeeded = false;
        long j4 = this.seekPos;
        if (j4 >= this.uncompressedSize) {
            this.curPos = j4;
            BlockInputStream blockInputStream = this.blockDecoder;
            if (blockInputStream != null) {
                blockInputStream.close();
                this.blockDecoder = null;
            }
            this.endReached = true;
            return;
        }
        this.endReached = false;
        locateBlockByPos(this.curBlockInfo, j4);
        long j8 = this.curPos;
        BlockInfo blockInfo = this.curBlockInfo;
        if (j8 <= blockInfo.uncompressedOffset || j8 > this.seekPos) {
            this.in.seek(blockInfo.compressedOffset);
            this.check = Check.getInstance(this.curBlockInfo.getCheckType());
            initBlockDecoder();
            this.curPos = this.curBlockInfo.uncompressedOffset;
        }
        long j9 = this.seekPos;
        long j10 = this.curPos;
        if (j9 > j10) {
            long j11 = j9 - j10;
            if (this.blockDecoder.skip(j11) == j11) {
                this.curPos = this.seekPos;
                return;
            }
            throw new CorruptedInputException();
        }
    }
}
