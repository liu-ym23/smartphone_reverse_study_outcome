package org.tukaani.xz;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import android.hardware.tv.mediaquality.ParameterName;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.tukaani.xz.check.Check;
import org.tukaani.xz.common.DecoderUtil;

/* JADX INFO: loaded from: classes3.dex */
class BlockInputStream extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Check check;
    private long compressedSizeInHeader;
    private long compressedSizeLimit;
    private boolean endReached;
    private InputStream filterChain;
    private final int headerSize;
    private final CountingInputStream inCounted;
    private final DataInputStream inData;
    private final byte[] tempBuf;
    private long uncompressedSize;
    private long uncompressedSizeInHeader;
    private final boolean verifyCheck;

    static {
    }

    public BlockInputStream(InputStream in, Check check, boolean verifyCheck, int memoryLimit, long unpaddedSizeInIndex, long uncompressedSizeInIndex, ArrayCache arrayCache) throws IOException, IndexIndicatorException {
        this.uncompressedSizeInHeader = -1;
        this.compressedSizeInHeader = -1;
        this.uncompressedSize = 0;
        this.endReached = false;
        this.tempBuf = new byte[1];
        this.check = check;
        this.verifyCheck = verifyCheck;
        this.inData = new DataInputStream(in);
        int b = this.inData.readUnsignedByte();
        if (b == 0) goto L108;
        this.headerSize = (b + 1) * 4;
        byte[] buf = new byte[this.headerSize];
        buf[0] = (byte) b;
        this.inData.readFully(buf, 1, this.headerSize - 1);
        if (DecoderUtil.isCRC32Valid(buf, 0, this.headerSize - 4, this.headerSize - 4) == false) goto L106;
        if ((buf[1] & ParameterName.COLOR_TUNER_HUE_BLUE) != 0) goto L104;
        int filterCount = (buf[1] & 3) + 1;
        long[] filterIDs = new long[filterCount];
        byte[][] filterProps = new byte[filterCount][];
        ByteArrayInputStream bufStream = new ByteArrayInputStream(buf, 2, this.headerSize - 6);
        this.compressedSizeLimit = (9223372036854775804L - ((long) this.headerSize)) - ((long) check.getSize());     // Catch: IOException -> L99
        if ((buf[1] & ParameterName.COLOR_TUNER_HUE_FLESH) != 0) goto L113;
    L21:
        if ((buf[1] & 128) == 0) goto L25;
        this.uncompressedSizeInHeader = DecoderUtil.decodeVLI(bufStream);     // Catch: IOException -> L17
    L25:
        int i = 0;
    L26:
        if (i >= filterCount) goto L39;
        filterIDs[i] = DecoderUtil.decodeVLI(bufStream);     // Catch: IOException -> L36
        long filterPropsSize = DecoderUtil.decodeVLI(bufStream);     // Catch: IOException -> L36
        int i2 = i;
        int i3 = bufStream.available();     // Catch: IOException -> L36
        int b2 = b;
        if (filterPropsSize > i3) goto L35;
        filterProps[i2] = new byte[(int) filterPropsSize];     // Catch: IOException -> L32
        bufStream.read(filterProps[i2]);     // Catch: IOException -> L32
        i = i2 + 1;     // Catch: IOException -> L32
        b = b2;
        goto L26
    L35:
        throw new CorruptedInputException();     // Catch: IOException -> L32
    L39:
        int i4 = bufStream.available();
    L40:
        if (i4 <= 0) goto L47;
        if (bufStream.read() != 0) goto L45;
        i4 = i4 - 1;
        goto L40
    L45:
        throw new UnsupportedOptionsException("Unsupported options in XZ Block Header");
    L47:
        if (unpaddedSizeInIndex == (-1)) goto L68;
        int headerAndCheckSize = this.headerSize + check.getSize();
        if (headerAndCheckSize >= unpaddedSizeInIndex) goto L67;
        long compressedSizeFromIndex = unpaddedSizeInIndex - ((long) headerAndCheckSize);
        if (compressedSizeFromIndex > this.compressedSizeLimit) goto L65;
        if (this.compressedSizeInHeader == (-1)) goto L57;
        if (this.compressedSizeInHeader != compressedSizeFromIndex) goto L65;
    L57:
        if (this.uncompressedSizeInHeader != (-1)) goto L59;
    L63:
        this.compressedSizeLimit = compressedSizeFromIndex;
        this.compressedSizeInHeader = compressedSizeFromIndex;
        this.uncompressedSizeInHeader = uncompressedSizeInIndex;
        goto L68
    L59:
        if (this.uncompressedSizeInHeader == uncompressedSizeInIndex) goto L63;
        throw new CorruptedInputException("XZ Index does not match a Block Header");
    L65:
        throw new CorruptedInputException("XZ Index does not match a Block Header");
    L67:
        throw new CorruptedInputException("XZ Index does not match a Block Header");
    L68:
        FilterDecoder[] filters = new FilterDecoder[filterIDs.length];
        int i5 = 0;
    L70:
        if (i5 >= filters.length) goto L83;
        if (filterIDs[i5] != 33) goto L75;
        filters[i5] = new LZMA2Decoder(filterProps[i5]);
    L80:
        i5 = i5 + 1;
        goto L70
    L75:
        if (filterIDs[i5] != 3) goto L78;
        filters[i5] = new DeltaDecoder(filterProps[i5]);
        goto L80
    L78:
        if (BCJCoder.isBCJFilterID(filterIDs[i5]) == false) goto L82;
        filters[i5] = new BCJDecoder(filterIDs[i5], filterProps[i5]);
        goto L80
    L82:
        throw new UnsupportedOptionsException("Unknown Filter ID " + filterIDs[i5]);
    L83:
        RawCoder.validate(filters);
        if (memoryLimit < 0) goto L94;
        int memoryNeeded = 0;
        int i6 = 0;
    L87:
        if (i6 >= filters.length) goto L90;
        memoryNeeded = memoryNeeded + filters[i6].getMemoryUsage();
        i6 = i6 + 1;
        goto L87
    L90:
        if (memoryNeeded <= memoryLimit) goto L94;
        throw new MemoryLimitException(memoryNeeded, memoryLimit);
    L94:
        this.inCounted = new CountingInputStream(in);
        this.filterChain = this.inCounted;
        int i7 = filters.length - 1;
    L95:
        if (i7 < 0) goto L98;
        this.filterChain = filters[i7].getInputStream(this.filterChain, arrayCache);
        i7 = i7 - 1;
        goto L95
    L98:
        return;
    L113:
        this.compressedSizeInHeader = DecoderUtil.decodeVLI(bufStream);     // Catch: IOException -> L17
        if (this.compressedSizeInHeader == 0) goto L20;
        if (this.compressedSizeInHeader > this.compressedSizeLimit) goto L20;
        this.compressedSizeLimit = this.compressedSizeInHeader;     // Catch: IOException -> L17
    L20:
        throw new CorruptedInputException();     // Catch: IOException -> L17
    L102:
        throw new CorruptedInputException("XZ Block Header is corrupt");
    L104:
        throw new UnsupportedOptionsException("Unsupported options in XZ Block Header");
    L106:
        throw new CorruptedInputException("XZ Block Header is corrupt");
    L108:
        throw new IndexIndicatorException();
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
        if (this.endReached == false) goto L5;
        return -1;
    L5:
        int ret = this.filterChain.read(buf, off, len);
        if (ret > 0) goto L8;
        if (ret != (-1)) goto L33;
        validate();
        this.endReached = true;
    L33:
        return ret;
    L8:
        if (this.verifyCheck == false) goto L10;
        this.check.update(buf, off, ret);
    L10:
        this.uncompressedSize += (long) ret;
        long compressedSize = this.inCounted.getSize();
        if (compressedSize < 0) goto L30;
        if (compressedSize > this.compressedSizeLimit) goto L30;
        if (this.uncompressedSize < 0) goto L30;
        if (this.uncompressedSizeInHeader != (-1)) goto L19;
    L20:
        if (ret < len) goto L24;
        if (this.uncompressedSize != this.uncompressedSizeInHeader) goto L33;
    L24:
        if (this.filterChain.read() != (-1)) goto L28;
        validate();
        this.endReached = true;
        goto L33
    L28:
        throw new CorruptedInputException();
    L19:
        if (this.uncompressedSize <= this.uncompressedSizeInHeader) goto L20;
    L30:
        throw new CorruptedInputException();
    }

    private void validate() throws IOException {
        long compressedSize = this.inCounted.getSize();
        if (this.compressedSizeInHeader == (-1)) goto L7;
        if (this.compressedSizeInHeader == compressedSize) goto L7;
    L12:
        throw new CorruptedInputException();
    L7:
        if (this.uncompressedSizeInHeader == (-1)) goto L13;
        if (this.uncompressedSizeInHeader != this.uncompressedSize) goto L12;
    L13:
        long compressedSize2 = 1 + compressedSize;
        if ((compressedSize & 3) == 0) goto L20;
        if (this.inData.readUnsignedByte() != 0) goto L19;
        compressedSize = compressedSize2;
        goto L13
    L19:
        throw new CorruptedInputException();
    L20:
        byte[] storedCheck = new byte[this.check.getSize()];
        this.inData.readFully(storedCheck);
        if (this.verifyCheck == true) goto L23;
        return;
    L23:
        if (Arrays.equals(this.check.finish(), storedCheck) == false) goto L26;
        return;
    L26:
        throw new CorruptedInputException("Integrity check (" + this.check.getName() + ") does not match");
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.filterChain.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.filterChain.close();     // Catch: IOException -> L4
    L5:
        this.filterChain = null;
    }

    public long getUnpaddedSize() {
        return (((long) this.headerSize) + this.inCounted.getSize()) + ((long) this.check.getSize());
    }

    public long getUncompressedSize() {
        return this.uncompressedSize;
    }
}
