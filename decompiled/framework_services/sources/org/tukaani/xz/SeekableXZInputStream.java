package org.tukaani.xz;

import android.hardware.tv.hdmi.cec.CecDeviceType;
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

/* JADX INFO: loaded from: classes3.dex */
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

    static {
    }

    public SeekableXZInputStream(SeekableInputStream in) throws IOException {
        this(in, -1);
    }

    public SeekableXZInputStream(SeekableInputStream in, ArrayCache arrayCache) throws IOException {
        this(in, -1, arrayCache);
    }

    public SeekableXZInputStream(SeekableInputStream in, int memoryLimit) throws IOException {
        this(in, memoryLimit, true);
    }

    public SeekableXZInputStream(SeekableInputStream in, int memoryLimit, ArrayCache arrayCache) throws IOException {
        this(in, memoryLimit, true, arrayCache);
    }

    public SeekableXZInputStream(SeekableInputStream in, int memoryLimit, boolean verifyCheck) throws IOException {
        this(in, memoryLimit, verifyCheck, ArrayCache.getDefaultCache());
    }

    public SeekableXZInputStream(SeekableInputStream in, int memoryLimit, boolean verifyCheck, ArrayCache arrayCache) throws IOException {
        SeekableInputStream r3 = in;
        this.indexMemoryUsage = 0;
        this.streams = new ArrayList();
        this.checkTypes = 0;
        long r8 = 0;
        this.uncompressedSize = 0;
        this.largestBlockSize = 0;
        this.blockCount = 0;
        this.blockDecoder = null;
        this.curPos = 0;
        this.seekNeeded = false;
        this.endReached = false;
        this.exception = null;
        int r0 = 1;
        this.tempBuf = new byte[1];
        this.arrayCache = arrayCache;
        this.verifyCheck = verifyCheck;
        this.in = r3;
        DataInputStream inData = new DataInputStream(r3);
        r3.seek(0);
        byte[] buf = new byte[XZ.HEADER_MAGIC.length];
        inData.readFully(buf);
        if (Arrays.equals(buf, XZ.HEADER_MAGIC) == false) goto L67;
        long pos = r3.length();
        if ((3 & pos) != 0) goto L65;
        byte[] buf2 = new byte[12];
        long streamPadding = 0;
        int memoryLimit2 = memoryLimit;
    L8:
        if (pos <= r8) goto L59;
        if (pos < 12) goto L58;
        r8 = r8;
        r3.seek(pos - 12);
        inData.readFully(buf2);
        if (buf2[8] != 0) goto L20;
        if (buf2[9] != 0) goto L20;
        if (buf2[10] != 0) goto L20;
        if (buf2[11] != 0) goto L20;
        streamPadding = streamPadding + 4;
        pos = pos - 4;
    L20:
        long pos2 = pos - 12;
        StreamFlags streamFooter = DecoderUtil.decodeStreamFooter(buf2);
        if (streamFooter.backwardSize >= pos2) goto L56;
        this.check = Check.getInstance(streamFooter.checkType);
        this.checkTypes |= r0 << streamFooter.checkType;
        r3.seek(pos2 - streamFooter.backwardSize);
        IndexDecoder index = new IndexDecoder(r3, streamFooter, streamPadding, memoryLimit2);     // Catch: MemoryLimitException -> L49
        this.indexMemoryUsage += index.getMemoryUsage();
        if (memoryLimit2 < 0) goto L30;
        memoryLimit2 = memoryLimit2 - index.getMemoryUsage();
    L30:
        if (this.largestBlockSize >= index.getLargestBlockSize()) goto L32;
        this.largestBlockSize = index.getLargestBlockSize();
    L32:
        long off = index.getStreamSize() - 12;
        if (pos2 < off) goto L48;
        long pos3 = pos2 - off;
        r3.seek(pos3);
        inData.readFully(buf2);
        int r16 = r0;
        StreamFlags streamHeader = DecoderUtil.decodeStreamHeader(buf2);
        if (DecoderUtil.areStreamFlagsEqual(streamHeader, streamFooter) == false) goto L46;
        this.uncompressedSize += index.getUncompressedSize();
        if (this.uncompressedSize < r8) goto L44;
        this.blockCount += index.getRecordCount();
        if (this.blockCount < 0) goto L42;
        this.streams.add(index);
        streamPadding = 0;
        r3 = in;
        pos = pos3;
        r0 = r16;
        goto L8
    L42:
        throw new UnsupportedOptionsException("XZ file has over 2147483647 Blocks");
    L44:
        throw new UnsupportedOptionsException("XZ file is too big");
    L46:
        throw new CorruptedInputException("XZ Stream Footer does not match Stream Header");
    L48:
        throw new CorruptedInputException("XZ Index indicates too big compressed size for the XZ Stream");
    L49:
        e = e;
    L54:
        throw new MemoryLimitException(e.getMemoryNeeded() + this.indexMemoryUsage, this.indexMemoryUsage + memoryLimit2);
    L51:
        e = e;
        goto L54
    L56:
        throw new CorruptedInputException("Backward Size in XZ Stream Footer is too big");
    L58:
        throw new CorruptedInputException();
    L59:
        this.memoryLimit = memoryLimit2;
        IndexDecoder prev = this.streams.get(this.streams.size() - 1);
        int i = this.streams.size() - 2;
    L60:
        if (i < 0) goto L62;
        IndexDecoder cur = this.streams.get(i);
        cur.setOffsets(prev);
        prev = cur;
        i = i - 1;
        goto L60
    L62:
        IndexDecoder first = this.streams.get(this.streams.size() - 1);
        this.curBlockInfo = new BlockInfo(first);
        this.queriedBlockInfo = new BlockInfo(first);
        return;
    L65:
        throw new CorruptedInputException("XZ file size is not a multiple of 4 bytes");
    L67:
        throw new XZFormatException();
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

    public int getBlockCount() {
        return this.blockCount;
    }

    public long getBlockPos(int blockNumber) {
        locateBlockByNumber(this.queriedBlockInfo, blockNumber);
        return this.queriedBlockInfo.uncompressedOffset;
    }

    public long getBlockSize(int blockNumber) {
        locateBlockByNumber(this.queriedBlockInfo, blockNumber);
        return this.queriedBlockInfo.uncompressedSize;
    }

    public long getBlockCompPos(int blockNumber) {
        locateBlockByNumber(this.queriedBlockInfo, blockNumber);
        return this.queriedBlockInfo.compressedOffset;
    }

    public long getBlockCompSize(int blockNumber) {
        locateBlockByNumber(this.queriedBlockInfo, blockNumber);
        return (this.queriedBlockInfo.unpaddedSize + 3) & (-4);
    }

    public int getBlockCheckType(int blockNumber) {
        locateBlockByNumber(this.queriedBlockInfo, blockNumber);
        return this.queriedBlockInfo.getCheckType();
    }

    public int getBlockNumber(long pos) {
        locateBlockByPos(this.queriedBlockInfo, pos);
        return this.queriedBlockInfo.blockNumber;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.tempBuf, 0, 1) != (-1)) goto L6;
        return -1;
    L6:
        return this.tempBuf[0] & CecDeviceType.INACTIVE;
    }

    @Override // java.io.InputStream
    public int read(byte[] buf, int off, int len) throws IOException {
        if (off < 0) goto L49;
        if (len < 0) goto L49;
        if ((off + len) < 0) goto L49;
        if ((off + len) > buf.length) goto L49;
        if (len != 0) goto L12;
        return 0;
    L12:
        if (this.in == null) goto L47;
        if (this.exception != null) goto L45;
        int size = 0;
    L19:
        e = e;
        if ((e instanceof EOFException) == false) goto L40;
        e = new CorruptedInputException();
    L40:
        this.exception = e;
        if (size == 0) goto L43;
    L42:
        return size;
    L43:
        throw e;
    L17:
        if (this.seekNeeded == false) goto L22;
        seek();     // Catch: IOException -> L19
    L22:
        if (this.endReached == false) goto L24;
        return -1;
    L24:
        if (len <= 0) goto L42;
        if (this.blockDecoder != null) goto L30;
        seek();     // Catch: IOException -> L19
        if (this.endReached == true) goto L42;
    L30:
        int ret = this.blockDecoder.read(buf, off, len);     // Catch: IOException -> L19
        if (ret > 0) goto L32;
        if (ret != (-1)) goto L24;
        this.blockDecoder = null;     // Catch: IOException -> L19
        goto L24
    L32:
        this.curPos += (long) ret;     // Catch: IOException -> L19
        size = size + ret;     // Catch: IOException -> L19
        off = off + ret;     // Catch: IOException -> L19
        len = len - ret;     // Catch: IOException -> L19
        goto L24
    L45:
        throw this.exception;
    L47:
        throw new XZIOException("Stream closed");
    L49:
        throw new IndexOutOfBoundsException();
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.in == null) goto L20;
        if (this.exception != null) goto L18;
        if (this.endReached == false) goto L9;
        return 0;
    L9:
        if (this.seekNeeded == false) goto L11;
        return 0;
    L11:
        if (this.blockDecoder != null) goto L14;
        return 0;
    L14:
        return this.blockDecoder.available();
    L18:
        throw this.exception;
    L20:
        throw new XZIOException("Stream closed");
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        close(true);
    }

    public void close(boolean closeInput) throws IOException {
        if (this.in != null) goto L5;
        return;
    L5:
        if (this.blockDecoder == null) goto L7;
        this.blockDecoder.close();
        this.blockDecoder = null;
    L7:
        if (closeInput == true) goto L15;
    L13:
        this.in = null;
        return;
    L15:
        this.in.close();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.in = null;
        throw th;
    }

    @Override // org.tukaani.xz.SeekableInputStream
    public long length() {
        return this.uncompressedSize;
    }

    @Override // org.tukaani.xz.SeekableInputStream
    public long position() throws IOException {
        if (this.in == null) goto L10;
        if (this.seekNeeded == false) goto L8;
        return this.seekPos;
    L8:
        return this.curPos;
    L10:
        throw new XZIOException("Stream closed");
    }

    @Override // org.tukaani.xz.SeekableInputStream
    public void seek(long pos) throws IOException {
        if (this.in == null) goto L11;
        if (pos < 0) goto L9;
        this.seekPos = pos;
        this.seekNeeded = true;
        return;
    L9:
        throw new XZIOException("Negative seek position: " + pos);
    L11:
        throw new XZIOException("Stream closed");
    }

    public void seekToBlock(int blockNumber) throws IOException {
        if (this.in == null) goto L12;
        if (blockNumber < 0) goto L10;
        if (blockNumber >= this.blockCount) goto L10;
        this.seekPos = getBlockPos(blockNumber);
        this.seekNeeded = true;
        return;
    L10:
        throw new XZIOException("Invalid XZ Block number: " + blockNumber);
    L12:
        throw new XZIOException("Stream closed");
    }

    private void seek() throws IOException {
        if (this.seekNeeded == false) goto L5;
    L9:
        this.seekNeeded = false;
        if (this.seekPos < this.uncompressedSize) goto L16;
        this.curPos = this.seekPos;
        if (this.blockDecoder == null) goto L14;
        this.blockDecoder.close();
        this.blockDecoder = null;
    L14:
        this.endReached = true;
        return;
    L16:
        this.endReached = false;
        locateBlockByPos(this.curBlockInfo, this.seekPos);
        if (this.curPos > this.curBlockInfo.uncompressedOffset) goto L19;
    L20:
        this.in.seek(this.curBlockInfo.compressedOffset);
        this.check = Check.getInstance(this.curBlockInfo.getCheckType());
        initBlockDecoder();
        this.curPos = this.curBlockInfo.uncompressedOffset;
    L22:
        if (this.seekPos <= this.curPos) goto L28;
        long skipAmount = this.seekPos - this.curPos;
        if (this.blockDecoder.skip(skipAmount) != skipAmount) goto L27;
        this.curPos = this.seekPos;
        return;
    L27:
        throw new CorruptedInputException();
    L28:
        return;
    L19:
        if (this.curPos <= this.seekPos) goto L22;
    L5:
        if (this.curBlockInfo.hasNext() == false) goto L8;
        this.curBlockInfo.setNext();
        initBlockDecoder();
        return;
    L8:
        this.seekPos = this.curPos;
        goto L9
    }

    private void locateBlockByPos(BlockInfo info, long pos) {
        if (pos < 0) goto L13;
        if (pos >= this.uncompressedSize) goto L13;
        int i = 0;
    L7:
        IndexDecoder index = this.streams.get(i);
        if (index.hasUncompressedOffset(pos) == true) goto L9;
        i = i + 1;
        goto L7
    L9:
        index.locateBlock(info, pos);
        return;
    L13:
        throw new IndexOutOfBoundsException("Invalid uncompressed position: " + pos);
    }

    private void locateBlockByNumber(BlockInfo info, int blockNumber) {
        if (blockNumber < 0) goto L15;
        if (blockNumber >= this.blockCount) goto L15;
        if (info.blockNumber != blockNumber) goto L8;
        return;
    L8:
        int i = 0;
    L9:
        IndexDecoder index = this.streams.get(i);
        if (index.hasRecord(blockNumber) == true) goto L11;
        i = i + 1;
        goto L9
    L11:
        index.setBlockInfo(info, blockNumber);
        return;
    L15:
        throw new IndexOutOfBoundsException("Invalid XZ Block number: " + blockNumber);
    }

    private void initBlockDecoder() throws IOException {
    L7:
        e = move-exception;
        throw new MemoryLimitException(e.getMemoryNeeded() + this.indexMemoryUsage, this.memoryLimit + this.indexMemoryUsage);
    L3:
        if (this.blockDecoder == null) goto L9;
        this.blockDecoder.close();     // Catch: IndexIndicatorException -> L5 MemoryLimitException -> L7
        this.blockDecoder = null;     // Catch: IndexIndicatorException -> L5 MemoryLimitException -> L7
    L9:
        this.blockDecoder = new BlockInputStream(this.in, this.check, this.verifyCheck, this.memoryLimit, this.curBlockInfo.unpaddedSize, this.curBlockInfo.uncompressedSize, this.arrayCache);     // Catch: IndexIndicatorException -> L5 MemoryLimitException -> L7
        return;
    L12:
        throw new CorruptedInputException();
    }
}
