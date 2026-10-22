package org.tukaani.xz;

import a8.b;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.lz.LZDecoder;
import org.tukaani.xz.lzma.LZMADecoder;
import org.tukaani.xz.rangecoder.RangeDecoderFromBuffer;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class LZMA2InputStream extends InputStream {
    private static final int COMPRESSED_SIZE_MAX = 65536;
    public static final int DICT_SIZE_MAX = 2147483632;
    public static final int DICT_SIZE_MIN = 4096;
    private final ArrayCache arrayCache;
    private boolean endReached;
    private IOException exception;
    private DataInputStream in;
    private boolean isLZMAChunk;
    private LZDecoder lz;
    private LZMADecoder lzma;
    private boolean needDictReset;
    private boolean needProps;
    private RangeDecoderFromBuffer rc;
    private final byte[] tempBuf;
    private int uncompressedSize;

    public LZMA2InputStream(InputStream inputStream, int i8) {
        this(inputStream, i8, null);
    }

    private void decodeChunkHeader() throws IOException {
        int unsignedByte = this.in.readUnsignedByte();
        if (unsignedByte == 0) {
            this.endReached = true;
            putArraysToCache();
            return;
        }
        if (unsignedByte >= 224 || unsignedByte == 1) {
            this.needProps = true;
            this.needDictReset = false;
            this.lz.reset();
        } else if (this.needDictReset) {
            throw new CorruptedInputException();
        }
        if (unsignedByte < 128) {
            if (unsignedByte > 2) {
                throw new CorruptedInputException();
            }
            this.isLZMAChunk = false;
            this.uncompressedSize = this.in.readUnsignedShort() + 1;
            return;
        }
        this.isLZMAChunk = true;
        int i8 = (unsignedByte & 31) << 16;
        this.uncompressedSize = i8;
        this.uncompressedSize = this.in.readUnsignedShort() + 1 + i8;
        int unsignedShort = this.in.readUnsignedShort() + 1;
        if (unsignedByte >= 192) {
            this.needProps = false;
            decodeProps();
        } else {
            if (this.needProps) {
                throw new CorruptedInputException();
            }
            if (unsignedByte >= 160) {
                this.lzma.reset();
            }
        }
        this.rc.prepareInputBuffer(this.in, unsignedShort);
    }

    private void decodeProps() throws IOException {
        int unsignedByte = this.in.readUnsignedByte();
        if (unsignedByte > 224) {
            throw new CorruptedInputException();
        }
        int i8 = unsignedByte / 45;
        int i9 = unsignedByte - (i8 * 45);
        int i10 = i9 / 9;
        int i11 = i9 - (i10 * 9);
        if (i11 + i10 > 4) {
            throw new CorruptedInputException();
        }
        this.lzma = new LZMADecoder(this.lz, this.rc, i11, i10, i8);
    }

    private static int getDictSize(int i8) {
        if (i8 < 4096 || i8 > 2147483632) {
            throw new IllegalArgumentException(b.j(i8, "Unsupported dictionary size "));
        }
        return (i8 + 15) & (-16);
    }

    public static int getMemoryUsage(int i8) {
        return (getDictSize(i8) / 1024) + 104;
    }

    private void putArraysToCache() {
        LZDecoder lZDecoder = this.lz;
        if (lZDecoder != null) {
            lZDecoder.putArraysToCache(this.arrayCache);
            this.lz = null;
            this.rc.putArraysToCache(this.arrayCache);
            this.rc = null;
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        DataInputStream dataInputStream = this.in;
        if (dataInputStream == null) {
            throw new XZIOException("Stream closed");
        }
        IOException iOException = this.exception;
        if (iOException == null) {
            return this.isLZMAChunk ? this.uncompressedSize : Math.min(this.uncompressedSize, dataInputStream.available());
        }
        throw iOException;
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

    @Override // java.io.InputStream
    public int read() {
        if (read(this.tempBuf, 0, 1) == -1) {
            return -1;
        }
        return this.tempBuf[0] & 255;
    }

    public LZMA2InputStream(InputStream inputStream, int i8, byte[] bArr) {
        this(inputStream, i8, bArr, ArrayCache.getDefaultCache());
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0071, code lost:
    
        throw new org.tukaani.xz.CorruptedInputException();
     */
    @Override // java.io.InputStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int read(byte[] r6, int r7, int r8) throws java.io.IOException {
        /*
            r5 = this;
            if (r7 < 0) goto L7f
            if (r8 < 0) goto L7f
            int r0 = r7 + r8
            if (r0 < 0) goto L7f
            int r1 = r6.length
            if (r0 > r1) goto L7f
            r0 = 0
            if (r8 != 0) goto Lf
            return r0
        Lf:
            java.io.DataInputStream r1 = r5.in
            if (r1 == 0) goto L77
            java.io.IOException r1 = r5.exception
            if (r1 != 0) goto L76
            boolean r1 = r5.endReached
            r2 = -1
            if (r1 == 0) goto L1d
            return r2
        L1d:
            if (r8 <= 0) goto L75
            int r1 = r5.uncompressedSize     // Catch: java.io.IOException -> L2d
            if (r1 != 0) goto L2f
            r5.decodeChunkHeader()     // Catch: java.io.IOException -> L2d
            boolean r1 = r5.endReached     // Catch: java.io.IOException -> L2d
            if (r1 == 0) goto L2f
            if (r0 != 0) goto L75
            return r2
        L2d:
            r6 = move-exception
            goto L72
        L2f:
            int r1 = r5.uncompressedSize     // Catch: java.io.IOException -> L2d
            int r1 = java.lang.Math.min(r1, r8)     // Catch: java.io.IOException -> L2d
            boolean r3 = r5.isLZMAChunk     // Catch: java.io.IOException -> L2d
            if (r3 != 0) goto L41
            org.tukaani.xz.lz.LZDecoder r3 = r5.lz     // Catch: java.io.IOException -> L2d
            java.io.DataInputStream r4 = r5.in     // Catch: java.io.IOException -> L2d
            r3.copyUncompressed(r4, r1)     // Catch: java.io.IOException -> L2d
            goto L4b
        L41:
            org.tukaani.xz.lz.LZDecoder r3 = r5.lz     // Catch: java.io.IOException -> L2d
            r3.setLimit(r1)     // Catch: java.io.IOException -> L2d
            org.tukaani.xz.lzma.LZMADecoder r1 = r5.lzma     // Catch: java.io.IOException -> L2d
            r1.decode()     // Catch: java.io.IOException -> L2d
        L4b:
            org.tukaani.xz.lz.LZDecoder r1 = r5.lz     // Catch: java.io.IOException -> L2d
            int r1 = r1.flush(r6, r7)     // Catch: java.io.IOException -> L2d
            int r7 = r7 + r1
            int r8 = r8 - r1
            int r0 = r0 + r1
            int r3 = r5.uncompressedSize     // Catch: java.io.IOException -> L2d
            int r3 = r3 - r1
            r5.uncompressedSize = r3     // Catch: java.io.IOException -> L2d
            if (r3 != 0) goto L1d
            org.tukaani.xz.rangecoder.RangeDecoderFromBuffer r1 = r5.rc     // Catch: java.io.IOException -> L2d
            boolean r1 = r1.isFinished()     // Catch: java.io.IOException -> L2d
            if (r1 == 0) goto L6c
            org.tukaani.xz.lz.LZDecoder r1 = r5.lz     // Catch: java.io.IOException -> L2d
            boolean r1 = r1.hasPending()     // Catch: java.io.IOException -> L2d
            if (r1 != 0) goto L6c
            goto L1d
        L6c:
            org.tukaani.xz.CorruptedInputException r6 = new org.tukaani.xz.CorruptedInputException     // Catch: java.io.IOException -> L2d
            r6.<init>()     // Catch: java.io.IOException -> L2d
            throw r6     // Catch: java.io.IOException -> L2d
        L72:
            r5.exception = r6
            throw r6
        L75:
            return r0
        L76:
            throw r1
        L77:
            org.tukaani.xz.XZIOException r5 = new org.tukaani.xz.XZIOException
            java.lang.String r6 = "Stream closed"
            r5.<init>(r6)
            throw r5
        L7f:
            java.lang.IndexOutOfBoundsException r5 = new java.lang.IndexOutOfBoundsException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.tukaani.xz.LZMA2InputStream.read(byte[], int, int):int");
    }

    public LZMA2InputStream(InputStream inputStream, int i8, byte[] bArr, ArrayCache arrayCache) {
        this.uncompressedSize = 0;
        this.isLZMAChunk = false;
        this.needDictReset = true;
        this.needProps = true;
        this.endReached = false;
        this.exception = null;
        this.tempBuf = new byte[1];
        inputStream.getClass();
        this.arrayCache = arrayCache;
        this.in = new DataInputStream(inputStream);
        this.rc = new RangeDecoderFromBuffer(COMPRESSED_SIZE_MAX, arrayCache);
        this.lz = new LZDecoder(getDictSize(i8), bArr, arrayCache);
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        this.needDictReset = false;
    }
}
