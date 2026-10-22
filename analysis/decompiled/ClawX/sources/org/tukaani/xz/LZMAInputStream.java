package org.tukaani.xz;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.lz.LZDecoder;
import org.tukaani.xz.lzma.LZMADecoder;
import org.tukaani.xz.rangecoder.RangeDecoderFromStream;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class LZMAInputStream extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int DICT_SIZE_MAX = 2147483632;
    private ArrayCache arrayCache;
    private boolean endReached;
    private IOException exception;
    private InputStream in;
    private LZDecoder lz;
    private LZMADecoder lzma;
    private RangeDecoderFromStream rc;
    private boolean relaxedEndCondition;
    private long remainingSize;
    private final byte[] tempBuf;

    public LZMAInputStream(InputStream inputStream) {
        this(inputStream, -1);
    }

    private static int getDictSize(int i8) {
        if (i8 < 0 || i8 > 2147483632) {
            throw new IllegalArgumentException("LZMA dictionary is too big for this implementation");
        }
        if (i8 < 4096) {
            i8 = 4096;
        }
        return (i8 + 15) & (-16);
    }

    public static int getMemoryUsage(int i8, byte b9) throws CorruptedInputException, UnsupportedOptionsException {
        if (i8 < 0 || i8 > 2147483632) {
            throw new UnsupportedOptionsException("LZMA dictionary is too big for this implementation");
        }
        int i9 = b9 & 255;
        if (i9 > 224) {
            throw new CorruptedInputException("Invalid LZMA properties byte");
        }
        int i10 = i9 % 45;
        int i11 = i10 / 9;
        return getMemoryUsage(i8, i10 - (i11 * 9), i11);
    }

    private void initialize(InputStream inputStream, long j4, byte b9, int i8, byte[] bArr, ArrayCache arrayCache) throws UnsupportedOptionsException, CorruptedInputException {
        if (j4 < -1) {
            throw new UnsupportedOptionsException("Uncompressed size is too big");
        }
        int i9 = b9 & 255;
        if (i9 > 224) {
            throw new CorruptedInputException("Invalid LZMA properties byte");
        }
        int i10 = i9 / 45;
        int i11 = i9 - (i10 * 45);
        int i12 = i11 / 9;
        int i13 = i11 - (i12 * 9);
        if (i8 < 0 || i8 > 2147483632) {
            throw new UnsupportedOptionsException("LZMA dictionary is too big for this implementation");
        }
        initialize(inputStream, j4, i13, i12, i10, i8, bArr, arrayCache);
    }

    private void putArraysToCache() {
        LZDecoder lZDecoder = this.lz;
        if (lZDecoder != null) {
            lZDecoder.putArraysToCache(this.arrayCache);
            this.lz = null;
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.in != null) {
            putArraysToCache();
            try {
                this.in.close();
            } finally {
                this.in = null;
            }
        }
    }

    public void enableRelaxedEndCondition() {
        this.relaxedEndCondition = true;
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.tempBuf, 0, 1) == -1) {
            return -1;
        }
        return this.tempBuf[0] & 255;
    }

    public LZMAInputStream(InputStream inputStream, ArrayCache arrayCache) {
        this(inputStream, -1, arrayCache);
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
        if (this.endReached) {
            return -1;
        }
        while (i9 > 0) {
            try {
                long j4 = this.remainingSize;
                this.lz.setLimit((j4 < 0 || j4 >= ((long) i9)) ? i9 : (int) j4);
                try {
                    this.lzma.decode();
                } catch (CorruptedInputException e9) {
                    if (this.remainingSize != -1 || !this.lzma.endMarkerDetected()) {
                        throw e9;
                    }
                    this.endReached = true;
                    this.rc.normalize();
                }
                int iFlush = this.lz.flush(bArr, i8);
                i8 += iFlush;
                i9 -= iFlush;
                i11 += iFlush;
                long j8 = this.remainingSize;
                if (j8 >= 0) {
                    long j9 = j8 - iFlush;
                    this.remainingSize = j9;
                    if (j9 == 0) {
                        this.endReached = true;
                    }
                }
                if (this.endReached) {
                    if (this.lz.hasPending()) {
                        throw new CorruptedInputException();
                    }
                    if (!this.rc.isFinished()) {
                        if (this.remainingSize == -1 || !this.relaxedEndCondition) {
                            throw new CorruptedInputException();
                        }
                        this.lz.setLimit(1);
                        try {
                            this.lzma.decode();
                        } catch (CorruptedInputException e10) {
                            if (!this.lzma.endMarkerDetected()) {
                                throw e10;
                            }
                            this.rc.normalize();
                            if (this.rc.isFinished()) {
                            }
                        }
                        throw new CorruptedInputException();
                    }
                    putArraysToCache();
                    if (i11 == 0) {
                        return -1;
                    }
                    return i11;
                }
            } catch (IOException e11) {
                this.exception = e11;
                throw e11;
            }
        }
        return i11;
    }

    public LZMAInputStream(InputStream inputStream, int i8) {
        this(inputStream, i8, ArrayCache.getDefaultCache());
    }

    public LZMAInputStream(InputStream inputStream, int i8, ArrayCache arrayCache) throws IOException {
        this.endReached = false;
        this.relaxedEndCondition = false;
        this.tempBuf = new byte[1];
        this.exception = null;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        byte b9 = dataInputStream.readByte();
        int unsignedByte = 0;
        for (int i9 = 0; i9 < 4; i9++) {
            unsignedByte |= dataInputStream.readUnsignedByte() << (i9 * 8);
        }
        long unsignedByte2 = 0;
        for (int i10 = 0; i10 < 8; i10++) {
            unsignedByte2 |= dataInputStream.readUnsignedByte() << (i10 * 8);
        }
        int memoryUsage = getMemoryUsage(unsignedByte, b9);
        if (i8 != -1 && memoryUsage > i8) {
            throw new MemoryLimitException(memoryUsage, i8);
        }
        this.relaxedEndCondition = true;
        initialize(inputStream, unsignedByte2, b9, unsignedByte, null, arrayCache);
    }

    public static int getMemoryUsage(int i8, int i9, int i10) {
        if (i9 >= 0 && i9 <= 8 && i10 >= 0 && i10 <= 4) {
            return ((1536 << (i9 + i10)) / 1024) + (getDictSize(i8) / 1024) + 10;
        }
        throw new IllegalArgumentException("Invalid lc or lp");
    }

    private void initialize(InputStream inputStream, long j4, int i8, int i9, int i10, int i11, byte[] bArr, ArrayCache arrayCache) {
        if (j4 >= -1 && i8 >= 0 && i8 <= 8 && i9 >= 0 && i9 <= 4 && i10 >= 0 && i10 <= 4) {
            this.in = inputStream;
            this.arrayCache = arrayCache;
            int dictSize = getDictSize(i11);
            if (j4 >= 0 && dictSize > j4) {
                dictSize = getDictSize((int) j4);
            }
            this.lz = new LZDecoder(getDictSize(dictSize), bArr, arrayCache);
            RangeDecoderFromStream rangeDecoderFromStream = new RangeDecoderFromStream(inputStream);
            this.rc = rangeDecoderFromStream;
            this.lzma = new LZMADecoder(this.lz, rangeDecoderFromStream, i8, i9, i10);
            this.remainingSize = j4;
            return;
        }
        throw new IllegalArgumentException();
    }

    public LZMAInputStream(InputStream inputStream, long j4, byte b9, int i8) throws UnsupportedOptionsException, CorruptedInputException {
        this.endReached = false;
        this.relaxedEndCondition = false;
        this.tempBuf = new byte[1];
        this.exception = null;
        initialize(inputStream, j4, b9, i8, null, ArrayCache.getDefaultCache());
    }

    public LZMAInputStream(InputStream inputStream, long j4, byte b9, int i8, byte[] bArr) throws UnsupportedOptionsException, CorruptedInputException {
        this.endReached = false;
        this.relaxedEndCondition = false;
        this.tempBuf = new byte[1];
        this.exception = null;
        initialize(inputStream, j4, b9, i8, bArr, ArrayCache.getDefaultCache());
    }

    public LZMAInputStream(InputStream inputStream, long j4, byte b9, int i8, byte[] bArr, ArrayCache arrayCache) throws UnsupportedOptionsException, CorruptedInputException {
        this.endReached = false;
        this.relaxedEndCondition = false;
        this.tempBuf = new byte[1];
        this.exception = null;
        initialize(inputStream, j4, b9, i8, bArr, arrayCache);
    }

    public LZMAInputStream(InputStream inputStream, long j4, int i8, int i9, int i10, int i11, byte[] bArr) {
        this.endReached = false;
        this.relaxedEndCondition = false;
        this.tempBuf = new byte[1];
        this.exception = null;
        initialize(inputStream, j4, i8, i9, i10, i11, bArr, ArrayCache.getDefaultCache());
    }

    public LZMAInputStream(InputStream inputStream, long j4, int i8, int i9, int i10, int i11, byte[] bArr, ArrayCache arrayCache) {
        this.endReached = false;
        this.relaxedEndCondition = false;
        this.tempBuf = new byte[1];
        this.exception = null;
        initialize(inputStream, j4, i8, i9, i10, i11, bArr, arrayCache);
    }
}
