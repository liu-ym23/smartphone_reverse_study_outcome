package org.tukaani.xz;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.tukaani.xz.check.Check;
import org.tukaani.xz.common.DecoderUtil;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
class BlockInputStream extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Check check;
    private long compressedSizeInHeader;
    private long compressedSizeLimit;
    private InputStream filterChain;
    private final int headerSize;
    private final CountingInputStream inCounted;
    private final DataInputStream inData;
    private long uncompressedSizeInHeader;
    private final boolean verifyCheck;
    private long uncompressedSize = 0;
    private boolean endReached = false;
    private final byte[] tempBuf = new byte[1];

    public BlockInputStream(InputStream inputStream, Check check, boolean z, int i8, long j4, long j8, ArrayCache arrayCache) throws IndexIndicatorException, IOException {
        long[] jArr;
        this.uncompressedSizeInHeader = -1L;
        this.compressedSizeInHeader = -1L;
        this.check = check;
        this.verifyCheck = z;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.inData = dataInputStream;
        int unsignedByte = dataInputStream.readUnsignedByte();
        if (unsignedByte == 0) {
            throw new IndexIndicatorException();
        }
        int i9 = (unsignedByte + 1) * 4;
        this.headerSize = i9;
        byte[] bArr = new byte[i9];
        bArr[0] = (byte) unsignedByte;
        dataInputStream.readFully(bArr, 1, i9 - 1);
        int i10 = i9 - 4;
        if (!DecoderUtil.isCRC32Valid(bArr, 0, i10, i10)) {
            throw new CorruptedInputException("XZ Block Header is corrupt");
        }
        int i11 = bArr[1];
        if ((i11 & 60) != 0) {
            throw new UnsupportedOptionsException("Unsupported options in XZ Block Header");
        }
        int i12 = i11 & 3;
        int i13 = i12 + 1;
        long[] jArr2 = new long[i13];
        byte[][] bArr2 = new byte[i13][];
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, 2, i9 - 6);
        try {
            this.compressedSizeLimit = (9223372036854775804L - i9) - check.getSize();
            if ((bArr[1] & 64) != 0) {
                long jDecodeVLI = DecoderUtil.decodeVLI(byteArrayInputStream);
                this.compressedSizeInHeader = jDecodeVLI;
                if (jDecodeVLI != 0) {
                    jArr = jArr2;
                    if (jDecodeVLI <= this.compressedSizeLimit) {
                        this.compressedSizeLimit = jDecodeVLI;
                    }
                }
                throw new CorruptedInputException();
            }
            jArr = jArr2;
            if ((bArr[1] & 128) != 0) {
                this.uncompressedSizeInHeader = DecoderUtil.decodeVLI(byteArrayInputStream);
            }
            int i14 = 0;
            while (i14 < i13) {
                jArr[i14] = DecoderUtil.decodeVLI(byteArrayInputStream);
                long jDecodeVLI2 = DecoderUtil.decodeVLI(byteArrayInputStream);
                int i15 = i14;
                if (jDecodeVLI2 > byteArrayInputStream.available()) {
                    throw new CorruptedInputException();
                }
                byte[] bArr3 = new byte[(int) jDecodeVLI2];
                bArr2[i15] = bArr3;
                byteArrayInputStream.read(bArr3);
                i14 = i15 + 1;
            }
            for (int iAvailable = byteArrayInputStream.available(); iAvailable > 0; iAvailable--) {
                if (byteArrayInputStream.read() != 0) {
                    throw new UnsupportedOptionsException("Unsupported options in XZ Block Header");
                }
            }
            if (j4 != -1) {
                long size = check.getSize() + this.headerSize;
                if (size >= j4) {
                    throw new CorruptedInputException("XZ Index does not match a Block Header");
                }
                long j9 = j4 - size;
                if (j9 <= this.compressedSizeLimit) {
                    long j10 = this.compressedSizeInHeader;
                    if (j10 == -1 || j10 == j9) {
                        long j11 = this.uncompressedSizeInHeader;
                        if (j11 != -1 && j11 != j8) {
                            throw new CorruptedInputException("XZ Index does not match a Block Header");
                        }
                        this.compressedSizeLimit = j9;
                        this.compressedSizeInHeader = j9;
                        this.uncompressedSizeInHeader = j8;
                    }
                }
                throw new CorruptedInputException("XZ Index does not match a Block Header");
            }
            FilterDecoder[] filterDecoderArr = new FilterDecoder[i13];
            for (int i16 = 0; i16 < i13; i16++) {
                long j12 = jArr[i16];
                if (j12 == 33) {
                    filterDecoderArr[i16] = new LZMA2Decoder(bArr2[i16]);
                } else if (j12 == 3) {
                    filterDecoderArr[i16] = new DeltaDecoder(bArr2[i16]);
                } else {
                    if (!BCJCoder.isBCJFilterID(j12)) {
                        throw new UnsupportedOptionsException("Unknown Filter ID " + jArr[i16]);
                    }
                    filterDecoderArr[i16] = new BCJDecoder(jArr[i16], bArr2[i16]);
                }
            }
            RawCoder.validate(filterDecoderArr);
            if (i8 >= 0) {
                int memoryUsage = 0;
                for (int i17 = 0; i17 < i13; i17++) {
                    memoryUsage += filterDecoderArr[i17].getMemoryUsage();
                }
                if (memoryUsage > i8) {
                    throw new MemoryLimitException(memoryUsage, i8);
                }
            }
            CountingInputStream countingInputStream = new CountingInputStream(inputStream);
            this.inCounted = countingInputStream;
            this.filterChain = countingInputStream;
            for (int i18 = i12; i18 >= 0; i18--) {
                this.filterChain = filterDecoderArr[i18].getInputStream(this.filterChain, arrayCache);
            }
        } catch (IOException unused) {
            throw new CorruptedInputException("XZ Block Header is corrupt");
        }
    }

    private void validate() throws IOException {
        long size = this.inCounted.getSize();
        long j4 = this.compressedSizeInHeader;
        if (j4 == -1 || j4 == size) {
            long j8 = this.uncompressedSizeInHeader;
            if (j8 == -1 || j8 == this.uncompressedSize) {
                while (true) {
                    long j9 = 1 + size;
                    if ((size & 3) == 0) {
                        byte[] bArr = new byte[this.check.getSize()];
                        this.inData.readFully(bArr);
                        if (!this.verifyCheck || Arrays.equals(this.check.finish(), bArr)) {
                            return;
                        }
                        throw new CorruptedInputException("Integrity check (" + this.check.getName() + ") does not match");
                    }
                    if (this.inData.readUnsignedByte() != 0) {
                        throw new CorruptedInputException();
                    }
                    size = j9;
                }
            }
        }
        throw new CorruptedInputException();
    }

    @Override // java.io.InputStream
    public int available() {
        return this.filterChain.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            this.filterChain.close();
        } catch (IOException unused) {
        }
        this.filterChain = null;
    }

    public long getUncompressedSize() {
        return this.uncompressedSize;
    }

    public long getUnpaddedSize() {
        return this.headerSize + this.inCounted.getSize() + this.check.getSize();
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.tempBuf, 0, 1) == -1) {
            return -1;
        }
        return this.tempBuf[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i8, int i9) throws IOException {
        if (this.endReached) {
            return -1;
        }
        int i10 = this.filterChain.read(bArr, i8, i9);
        if (i10 > 0) {
            if (this.verifyCheck) {
                this.check.update(bArr, i8, i10);
            }
            this.uncompressedSize += i10;
            long size = this.inCounted.getSize();
            if (size >= 0 && size <= this.compressedSizeLimit) {
                long j4 = this.uncompressedSize;
                if (j4 >= 0) {
                    long j8 = this.uncompressedSizeInHeader;
                    if (j8 == -1 || j4 <= j8) {
                        if (i10 < i9 || j4 == j8) {
                            if (this.filterChain.read() != -1) {
                                throw new CorruptedInputException();
                            }
                            validate();
                            this.endReached = true;
                            return i10;
                        }
                    }
                }
            }
            throw new CorruptedInputException();
        }
        if (i10 == -1) {
            validate();
            this.endReached = true;
        }
        return i10;
    }
}
