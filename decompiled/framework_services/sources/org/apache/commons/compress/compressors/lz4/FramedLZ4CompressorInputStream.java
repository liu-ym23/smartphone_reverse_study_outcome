package org.apache.commons.compress.compressors.lz4;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import android.hardware.tv.mediaquality.ParameterName;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.BoundedInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.ChecksumCalculatingInputStream;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: classes3.dex */
public class FramedLZ4CompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    static final int BLOCK_CHECKSUM_MASK = 16;
    static final int BLOCK_INDEPENDENCE_MASK = 32;
    static final int BLOCK_MAX_SIZE_MASK = 112;
    static final int CONTENT_CHECKSUM_MASK = 4;
    static final int CONTENT_SIZE_MASK = 8;
    static final byte[] LZ4_SIGNATURE = null;
    private static final byte SKIPPABLE_FRAME_PREFIX_BYTE_MASK = 80;
    private static final byte[] SKIPPABLE_FRAME_TRAILER = null;
    static final int SUPPORTED_VERSION = 64;
    static final int UNCOMPRESSED_FLAG_MASK = Integer.MIN_VALUE;
    static final int VERSION_MASK = 192;
    private byte[] blockDependencyBuffer;
    private final XXHash32 blockHash;
    private final XXHash32 contentHash;
    private InputStream currentBlock;
    private final boolean decompressConcatenated;
    private boolean endReached;
    private boolean expectBlockChecksum;
    private boolean expectBlockDependency;
    private boolean expectContentChecksum;
    private boolean expectContentSize;
    private final CountingInputStream in;
    private boolean inUncompressed;
    private final byte[] oneByte;
    private final ByteUtils.ByteSupplier supplier;

    static /* synthetic */ int access$000(FramedLZ4CompressorInputStream x0) throws IOException {
        return x0.readOneByte();
    }

    static {
        LZ4_SIGNATURE = new byte[]{4, 34, ParameterName.COLOR_TUNER_LUMINANCE_YELLOW, ParameterName.GLOBE_DIMMING};
        SKIPPABLE_FRAME_TRAILER = new byte[]{42, ParameterName.COLOR_TUNER_LUMINANCE_YELLOW, ParameterName.GLOBE_DIMMING};
    }

    public FramedLZ4CompressorInputStream(InputStream in) throws IOException {
        this(in, false);
    }

    public FramedLZ4CompressorInputStream(InputStream in, boolean decompressConcatenated) throws IOException {
        this.oneByte = new byte[1];
        this.supplier = new AnonymousClass1(this);
        this.contentHash = new XXHash32();
        this.blockHash = new XXHash32();
        this.in = new CountingInputStream(in);
        this.decompressConcatenated = decompressConcatenated;
        init(true);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.oneByte, 0, 1) != (-1)) goto L6;
        return -1;
    L6:
        return this.oneByte[0] & CecDeviceType.INACTIVE;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    L6:
        th = move-exception;
        this.in.close();
        throw th;
    L3:
        if (this.currentBlock == null) goto L8;
        this.currentBlock.close();     // Catch: Throwable -> L6
        this.currentBlock = null;     // Catch: Throwable -> L6
    L8:
        this.in.close();
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        if (this.endReached == false) goto L5;
        return -1;
    L5:
        int r = readOnce(b, off, len);
        if (r != (-1)) goto L10;
        nextBlock();
        if (this.endReached == true) goto L10;
        r = readOnce(b, off, len);
    L10:
        if (r != (-1)) goto L12;
    L17:
        return r;
    L12:
        if (this.expectBlockDependency == false) goto L15;
        appendToBlockDependencyBuffer(b, off, r);
    L15:
        if (this.expectContentChecksum == false) goto L17;
        this.contentHash.update(b, off, r);
        goto L17
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.in.getBytesRead();
    }

    private void init(boolean firstFrame) throws IOException {
        if (readSignature(firstFrame) == false) goto L6;
        readFrameDescriptor();
        nextBlock();
        return;
    }

    private boolean readSignature(boolean firstFrame) throws IOException {
        if (firstFrame == false) goto L4;
        String garbageMessage = "Not a LZ4 frame stream";
    L5:
        byte[] b = new byte[4];
        int read = IOUtils.readFully(this.in, b);
        count(read);
        if (read != 0) goto L10;
        if (firstFrame == true) goto L10;
        this.endReached = true;
        return false;
    L10:
        if (4 != read) goto L23;
        int read2 = skipSkippableFrame(b);
        if (read2 != 0) goto L16;
        if (firstFrame == true) goto L16;
        this.endReached = true;
        return false;
    L16:
        if (4 != read2) goto L21;
        if (matches(b, 4) == false) goto L21;
        return true;
    L21:
        throw new IOException(garbageMessage);
    L23:
        throw new IOException(garbageMessage);
    L4:
        garbageMessage = "LZ4 frame stream followed by garbage";
        goto L5
    }

    private void readFrameDescriptor() throws IOException {
        int flags = readOneByte();
        if (flags == (-1)) goto L51;
        this.contentHash.update(flags);
        if ((flags & 192) != 64) goto L49;
        boolean r3 = true;
        if ((flags & 32) != 0) goto L9;
        boolean r2 = true;
    L10:
        this.expectBlockDependency = r2;
        if (this.expectBlockDependency == true) goto L13;
        this.blockDependencyBuffer = null;
    L17:
        if ((flags & 16) == 0) goto L19;
        boolean r4 = true;
    L20:
        this.expectBlockChecksum = r4;
        if ((flags & 8) == 0) goto L23;
        boolean r5 = true;
    L24:
        this.expectContentSize = r5;
        if ((flags & 4) != 0) goto L28;
        r3 = false;
    L28:
        this.expectContentChecksum = r3;
        int bdByte = readOneByte();
        if (bdByte == (-1)) goto L47;
        this.contentHash.update(bdByte);
        if (this.expectContentSize == false) goto L37;
        byte[] contentSize = new byte[8];
        int skipped = IOUtils.readFully(this.in, contentSize);
        count(skipped);
        if (8 != skipped) goto L36;
        this.contentHash.update(contentSize, 0, contentSize.length);
        goto L37
    L36:
        throw new IOException("Premature end of stream while reading content size");
    L37:
        int headerHash = readOneByte();
        if (headerHash == (-1)) goto L45;
        int expectedHash = (int) ((this.contentHash.getValue() >> 8) & 255);
        this.contentHash.reset();
        if (headerHash != expectedHash) goto L43;
        return;
    L43:
        throw new IOException("frame header checksum mismatch.");
    L45:
        throw new IOException("Premature end of stream while reading frame header checksum");
    L47:
        throw new IOException("Premature end of stream while reading frame BD byte");
    L23:
        r5 = false;
        goto L24
    L19:
        r4 = false;
        goto L20
    L13:
        if (this.blockDependencyBuffer != null) goto L17;
        this.blockDependencyBuffer = new byte[65536];
        goto L17
    L9:
        r2 = false;
        goto L10
    L49:
        throw new IOException("Unsupported version " + (flags >> 6));
    L51:
        throw new IOException("Premature end of stream while reading frame flags");
    }

    private void nextBlock() throws IOException {
        maybeFinishCurrentBlock();
        long len = ByteUtils.fromLittleEndian(this.supplier, 4);
        if (((-2147483648L) & len) == 0) goto L5;
        boolean uncompressed = true;
    L6:
        int realLen = (int) (2147483647L & len);
        if (realLen != 0) goto L13;
        verifyContentChecksum();
        if (this.decompressConcatenated == true) goto L11;
        this.endReached = true;
        return;
    L11:
        init(false);
        return;
    L13:
        InputStream capped = new BoundedInputStream(this.in, realLen);
        if (this.expectBlockChecksum == false) goto L16;
        capped = new ChecksumCalculatingInputStream(this.blockHash, capped);
    L16:
        if (uncompressed == false) goto L18;
        this.inUncompressed = true;
        this.currentBlock = capped;
        return;
    L18:
        this.inUncompressed = false;
        BlockLZ4CompressorInputStream s = new BlockLZ4CompressorInputStream(capped);
        if (this.expectBlockDependency == false) goto L21;
        s.prefill(this.blockDependencyBuffer);
    L21:
        this.currentBlock = s;
        return;
    L5:
        uncompressed = false;
        goto L6
    }

    private void maybeFinishCurrentBlock() throws IOException {
        if (this.currentBlock == null) goto L8;
        this.currentBlock.close();
        this.currentBlock = null;
        if (this.expectBlockChecksum == false) goto L9;
        verifyChecksum(this.blockHash, "block");
        this.blockHash.reset();
        return;
    L9:
        return;
    }

    private void verifyContentChecksum() throws IOException {
        if (this.expectContentChecksum == false) goto L5;
        verifyChecksum(this.contentHash, ActivityTaskManagerInternal.ASSIST_KEY_CONTENT);
    L5:
        this.contentHash.reset();
    }

    private void verifyChecksum(XXHash32 hash, String kind) throws IOException {
        byte[] checksum = new byte[4];
        int read = IOUtils.readFully(this.in, checksum);
        count(read);
        if (4 != read) goto L10;
        long expectedHash = hash.getValue();
        if (expectedHash != ByteUtils.fromLittleEndian(checksum)) goto L8;
        return;
    L8:
        throw new IOException(kind + " checksum mismatch.");
    L10:
        throw new IOException("Premature end of stream while reading " + kind + " checksum");
    }

    private int readOneByte() throws IOException {
        int b = this.in.read();
        if (b == (-1)) goto L6;
        count(1);
        return b & 255;
    L6:
        return -1;
    }

    private int readOnce(byte[] b, int off, int len) throws IOException {
        if (this.inUncompressed == false) goto L6;
        int cnt = this.currentBlock.read(b, off, len);
        count(cnt);
        return cnt;
    L6:
        BlockLZ4CompressorInputStream l = (BlockLZ4CompressorInputStream) this.currentBlock;
        long before = l.getBytesRead();
        int cnt2 = this.currentBlock.read(b, off, len);
        count(l.getBytesRead() - before);
        return cnt2;
    }

    private static boolean isSkippableFrameSignature(byte[] b) {
        if ((b[0] & 80) == 80) goto L5;
        return false;
    L5:
        int i = 1;
    L7:
        if (i >= 4) goto L12;
        if (b[i] != SKIPPABLE_FRAME_TRAILER[i - 1]) goto L10;
        i = i + 1;
        goto L7
    L10:
        return false;
    L12:
        return true;
    }

    private int skipSkippableFrame(byte[] b) throws IOException {
        int read = 4;
    L4:
        if (read != 4) goto L12;
        if (isSkippableFrameSignature(b) == false) goto L12;
        long len = ByteUtils.fromLittleEndian(this.supplier, 4);
        long skipped = IOUtils.skip(this.in, len);
        count(skipped);
        if (len != skipped) goto L11;
        read = IOUtils.readFully(this.in, b);
        count(read);
        goto L4
    L11:
        throw new IOException("Premature end of stream while skipping frame");
    L12:
        return read;
    }

    private void appendToBlockDependencyBuffer(byte[] b, int off, int len) {
        int len2 = Math.min(len, this.blockDependencyBuffer.length);
        if (len2 <= 0) goto L9;
        int keep = this.blockDependencyBuffer.length - len2;
        if (keep <= 0) goto L7;
        System.arraycopy(this.blockDependencyBuffer, len2, this.blockDependencyBuffer, 0, keep);
    L7:
        System.arraycopy(b, off, this.blockDependencyBuffer, keep, len2);
        return;
    }

    public static boolean matches(byte[] signature, int length) {
        if (length >= LZ4_SIGNATURE.length) goto L5;
        return false;
    L5:
        byte[] shortenedSig = signature;
        if (signature.length <= LZ4_SIGNATURE.length) goto L9;
        shortenedSig = new byte[LZ4_SIGNATURE.length];
        System.arraycopy(signature, 0, shortenedSig, 0, LZ4_SIGNATURE.length);
    L9:
        return Arrays.equals(shortenedSig, LZ4_SIGNATURE);
    }
}
