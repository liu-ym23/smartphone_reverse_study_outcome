package org.tukaani.xz;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.lz.LZDecoder;
import org.tukaani.xz.lzma.LZMADecoder;
import org.tukaani.xz.rangecoder.RangeDecoderFromBuffer;

/* JADX INFO: loaded from: classes3.dex */
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

    public static int getMemoryUsage(int dictSize) {
        return (getDictSize(dictSize) / 1024) + 104;
    }

    private static int getDictSize(int dictSize) {
        if (dictSize < 4096) goto L9;
        if (dictSize > 2147483632) goto L9;
        return (dictSize + 15) & (-16);
    L9:
        throw new IllegalArgumentException("Unsupported dictionary size " + dictSize);
    }

    public LZMA2InputStream(InputStream in, int dictSize) {
        this(in, dictSize, null);
    }

    public LZMA2InputStream(InputStream in, int dictSize, byte[] presetDict) {
        this(in, dictSize, presetDict, ArrayCache.getDefaultCache());
    }

    LZMA2InputStream(InputStream in, int dictSize, byte[] presetDict, ArrayCache arrayCache) {
        this.uncompressedSize = 0;
        this.isLZMAChunk = false;
        this.needDictReset = true;
        this.needProps = true;
        this.endReached = false;
        this.exception = null;
        this.tempBuf = new byte[1];
        if (in == null) goto L11;
        this.arrayCache = arrayCache;
        this.in = new DataInputStream(in);
        this.rc = new RangeDecoderFromBuffer(65536, arrayCache);
        this.lz = new LZDecoder(getDictSize(dictSize), presetDict, arrayCache);
        if (presetDict != null) goto L7;
        return;
    L7:
        if (presetDict.length <= 0) goto L13;
        this.needDictReset = false;
        return;
    L13:
        return;
    L11:
        throw new NullPointerException();
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
        if (off < 0) goto L52;
        if (len < 0) goto L52;
        if ((off + len) < 0) goto L52;
        if ((off + len) > buf.length) goto L52;
        if (len != 0) goto L12;
        return 0;
    L12:
        if (this.in == null) goto L50;
        if (this.exception != null) goto L48;
        if (this.endReached == false) goto L18;
        return -1;
    L18:
        int size = 0;
    L19:
        if (len <= 0) goto L46;
    L28:
        e = move-exception;
        this.exception = e;
        throw e;
    L21:
        if (this.uncompressedSize != 0) goto L30;
        decodeChunkHeader();     // Catch: IOException -> L28
        if (this.endReached == false) goto L30;
        if (size != 0) goto L27;
        return -1;
    L27:
        return size;
    L30:
        int copySizeMax = Math.min(this.uncompressedSize, len);     // Catch: IOException -> L28
        if (this.isLZMAChunk == true) goto L33;
        this.lz.copyUncompressed(this.in, copySizeMax);     // Catch: IOException -> L28
    L34:
        int copiedSize = this.lz.flush(buf, off);     // Catch: IOException -> L28
        off = off + copiedSize;     // Catch: IOException -> L28
        len = len - copiedSize;     // Catch: IOException -> L28
        size = size + copiedSize;     // Catch: IOException -> L28
        this.uncompressedSize -= copiedSize;     // Catch: IOException -> L28
        if (this.uncompressedSize != 0) goto L19;
        if (this.rc.isFinished() == false) goto L42;
        if (this.lz.hasPending() == false) goto L19;
    L42:
        throw new CorruptedInputException();     // Catch: IOException -> L28
    L33:
        this.lz.setLimit(copySizeMax);     // Catch: IOException -> L28
        this.lzma.decode();     // Catch: IOException -> L28
        goto L34
    L46:
        return size;
    L48:
        throw this.exception;
    L50:
        throw new XZIOException("Stream closed");
    L52:
        throw new IndexOutOfBoundsException();
    }

    private void decodeChunkHeader() throws IOException {
        int control = this.in.readUnsignedByte();
        if (control != 0) goto L7;
        this.endReached = true;
        putArraysToCache();
        return;
    L7:
        if (control >= 224) goto L15;
        if (control == 1) goto L15;
        if (this.needDictReset == false) goto L17;
        throw new CorruptedInputException();
    L17:
        if (control < 128) goto L30;
        this.isLZMAChunk = true;
        this.uncompressedSize = (control & 31) << 16;
        this.uncompressedSize += this.in.readUnsignedShort() + 1;
        int compressedSize = this.in.readUnsignedShort() + 1;
        if (control < 192) goto L22;
        this.needProps = false;
        decodeProps();
    L26:
        this.rc.prepareInputBuffer(this.in, compressedSize);
        return;
    L22:
        if (this.needProps == true) goto L28;
        if (control < 160) goto L26;
        this.lzma.reset();
        goto L26
    L28:
        throw new CorruptedInputException();
    L30:
        if (control > 2) goto L34;
        this.isLZMAChunk = false;
        this.uncompressedSize = this.in.readUnsignedShort() + 1;
        return;
    L34:
        throw new CorruptedInputException();
    L15:
        this.needProps = true;
        this.needDictReset = false;
        this.lz.reset();
        goto L17
    }

    private void decodeProps() throws IOException {
        int props = this.in.readUnsignedByte();
        if (props > 224) goto L11;
        int pb = props / 45;
        int props2 = props - ((pb * 9) * 5);
        int lp = props2 / 9;
        int lc = props2 - (lp * 9);
        if ((lc + lp) > 4) goto L9;
        this.lzma = new LZMADecoder(this.lz, this.rc, lc, lp, pb);
        return;
    L9:
        throw new CorruptedInputException();
    L11:
        throw new CorruptedInputException();
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.in == null) goto L14;
        if (this.exception != null) goto L12;
        if (this.isLZMAChunk == false) goto L10;
        return this.uncompressedSize;
    L10:
        return Math.min(this.uncompressedSize, this.in.available());
    L12:
        throw this.exception;
    L14:
        throw new XZIOException("Stream closed");
    }

    private void putArraysToCache() {
        if (this.lz == null) goto L6;
        this.lz.putArraysToCache(this.arrayCache);
        this.lz = null;
        this.rc.putArraysToCache(this.arrayCache);
        this.rc = null;
        return;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.in == null) goto L10;
        putArraysToCache();
        this.in.close();     // Catch: Throwable -> L7
        this.in = null;
        return;
    L7:
        th = move-exception;
        this.in = null;
        throw th;
    }
}
