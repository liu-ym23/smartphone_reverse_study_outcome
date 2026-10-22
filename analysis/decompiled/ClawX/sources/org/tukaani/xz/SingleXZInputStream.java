package org.tukaani.xz;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.check.Check;
import org.tukaani.xz.common.DecoderUtil;
import org.tukaani.xz.common.StreamFlags;
import org.tukaani.xz.index.IndexHash;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class SingleXZInputStream extends InputStream {
    private final ArrayCache arrayCache;
    private BlockInputStream blockDecoder;
    private final Check check;
    private boolean endReached;
    private IOException exception;
    private InputStream in;
    private final IndexHash indexHash;
    private final int memoryLimit;
    private final StreamFlags streamHeaderFlags;
    private final byte[] tempBuf;
    private final boolean verifyCheck;

    public SingleXZInputStream(InputStream inputStream) {
        this(inputStream, -1);
    }

    private static byte[] readStreamHeader(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[12];
        new DataInputStream(inputStream).readFully(bArr);
        return bArr;
    }

    private void validateStreamFooter() throws IOException {
        byte[] bArr = new byte[12];
        new DataInputStream(this.in).readFully(bArr);
        StreamFlags streamFlagsDecodeStreamFooter = DecoderUtil.decodeStreamFooter(bArr);
        if (!DecoderUtil.areStreamFlagsEqual(this.streamHeaderFlags, streamFlagsDecodeStreamFooter) || this.indexHash.getIndexSize() != streamFlagsDecodeStreamFooter.backwardSize) {
            throw new CorruptedInputException("XZ Stream Footer does not match Stream Header");
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.in == null) {
            throw new XZIOException("Stream closed");
        }
        IOException iOException = this.exception;
        if (iOException != null) {
            throw iOException;
        }
        BlockInputStream blockInputStream = this.blockDecoder;
        if (blockInputStream == null) {
            return 0;
        }
        return blockInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        close(true);
    }

    public String getCheckName() {
        return this.check.getName();
    }

    public int getCheckType() {
        return this.streamHeaderFlags.checkType;
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.tempBuf, 0, 1) == -1) {
            return -1;
        }
        return this.tempBuf[0] & 255;
    }

    public SingleXZInputStream(InputStream inputStream, ArrayCache arrayCache) {
        this(inputStream, -1, arrayCache);
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
        if (this.endReached) {
            return -1;
        }
        int i11 = i9;
        int i12 = 0;
        int i13 = i8;
        while (i11 > 0) {
            try {
                if (this.blockDecoder == null) {
                    try {
                        this.blockDecoder = new BlockInputStream(this.in, this.check, this.verifyCheck, this.memoryLimit, -1L, -1L, this.arrayCache);
                    } catch (IndexIndicatorException unused) {
                        this.indexHash.validate(this.in);
                        validateStreamFooter();
                        this.endReached = true;
                        if (i12 > 0) {
                            return i12;
                        }
                        return -1;
                    }
                }
                int i14 = this.blockDecoder.read(bArr, i13, i11);
                if (i14 > 0) {
                    i12 += i14;
                    i13 += i14;
                    i11 -= i14;
                } else if (i14 == -1) {
                    this.indexHash.add(this.blockDecoder.getUnpaddedSize(), this.blockDecoder.getUncompressedSize());
                    this.blockDecoder = null;
                }
            } catch (IOException e9) {
                this.exception = e9;
                if (i12 == 0) {
                    throw e9;
                }
            }
        }
        return i12;
    }

    public SingleXZInputStream(InputStream inputStream, int i8) {
        this(inputStream, i8, true);
    }

    public SingleXZInputStream(InputStream inputStream, int i8, ArrayCache arrayCache) {
        this(inputStream, i8, true, arrayCache);
    }

    public SingleXZInputStream(InputStream inputStream, int i8, boolean z) {
        this(inputStream, i8, z, ArrayCache.getDefaultCache());
    }

    public SingleXZInputStream(InputStream inputStream, int i8, boolean z, ArrayCache arrayCache) {
        this(inputStream, i8, z, readStreamHeader(inputStream), arrayCache);
    }

    public SingleXZInputStream(InputStream inputStream, int i8, boolean z, byte[] bArr, ArrayCache arrayCache) throws CorruptedInputException, UnsupportedOptionsException, XZFormatException {
        this.blockDecoder = null;
        this.indexHash = new IndexHash();
        this.endReached = false;
        this.exception = null;
        this.tempBuf = new byte[1];
        this.arrayCache = arrayCache;
        this.in = inputStream;
        this.memoryLimit = i8;
        this.verifyCheck = z;
        StreamFlags streamFlagsDecodeStreamHeader = DecoderUtil.decodeStreamHeader(bArr);
        this.streamHeaderFlags = streamFlagsDecodeStreamHeader;
        this.check = Check.getInstance(streamFlagsDecodeStreamHeader.checkType);
    }
}
