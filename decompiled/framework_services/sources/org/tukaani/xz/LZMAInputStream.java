package org.tukaani.xz;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.lz.LZDecoder;
import org.tukaani.xz.lzma.LZMADecoder;
import org.tukaani.xz.rangecoder.RangeDecoderFromStream;

/* JADX INFO: loaded from: classes3.dex */
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

    static {
    }

    public static int getMemoryUsage(int dictSize, byte propsByte) throws UnsupportedOptionsException, CorruptedInputException {
        if (dictSize < 0) goto L12;
        if (dictSize > 2147483632) goto L12;
        int props = propsByte & CecDeviceType.INACTIVE;
        if (props > 224) goto L10;
        int props2 = props % 45;
        int lp = props2 / 9;
        int lc = props2 - (lp * 9);
        return getMemoryUsage(dictSize, lc, lp);
    L10:
        throw new CorruptedInputException("Invalid LZMA properties byte");
    L12:
        throw new UnsupportedOptionsException("LZMA dictionary is too big for this implementation");
    }

    public static int getMemoryUsage(int dictSize, int lc, int lp) {
        if (lc < 0) goto L11;
        if (lc > 8) goto L11;
        if (lp < 0) goto L11;
        if (lp > 4) goto L11;
        return ((getDictSize(dictSize) / 1024) + 10) + ((1536 << (lc + lp)) / 1024);
    L11:
        throw new IllegalArgumentException("Invalid lc or lp");
    }

    private static int getDictSize(int dictSize) {
        if (dictSize < 0) goto L11;
        if (dictSize > 2147483632) goto L11;
        if (dictSize >= 4096) goto L9;
        dictSize = 4096;
    L9:
        return (dictSize + 15) & (-16);
    L11:
        throw new IllegalArgumentException("LZMA dictionary is too big for this implementation");
    }

    public LZMAInputStream(InputStream in) throws IOException {
        this(in, -1);
    }

    public LZMAInputStream(InputStream in, ArrayCache arrayCache) throws IOException {
        this(in, -1, arrayCache);
    }

    public LZMAInputStream(InputStream in, int memoryLimit) throws IOException {
        this(in, memoryLimit, ArrayCache.getDefaultCache());
    }

    public LZMAInputStream(InputStream in, int memoryLimit, ArrayCache arrayCache) throws IOException {
        this.endReached = false;
        this.relaxedEndCondition = false;
        this.tempBuf = new byte[1];
        this.exception = null;
        DataInputStream inData = new DataInputStream(in);
        byte propsByte = inData.readByte();
        int i = 0;
        int dictSize = 0;
    L4:
        if (i >= 4) goto L6;
        dictSize = dictSize | (inData.readUnsignedByte() << (i * 8));
        i = i + 1;
        goto L4
    L6:
        int i2 = 0;
        long uncompSize = 0;
    L8:
        if (i2 >= 8) goto L10;
        uncompSize = uncompSize | (((long) inData.readUnsignedByte()) << (i2 * 8));
        i2 = i2 + 1;
        goto L8
    L10:
        int memoryNeeded = getMemoryUsage(dictSize, propsByte);
        if (memoryLimit == (-1)) goto L16;
        if (memoryNeeded <= memoryLimit) goto L16;
        throw new MemoryLimitException(memoryNeeded, memoryLimit);
    L16:
        initialize(in, uncompSize, propsByte, dictSize, null, arrayCache);
    }

    public LZMAInputStream(InputStream in, long uncompSize, byte propsByte, int dictSize) throws IOException {
        this.endReached = false;
        this.relaxedEndCondition = false;
        this.tempBuf = new byte[1];
        this.exception = null;
        initialize(in, uncompSize, propsByte, dictSize, null, ArrayCache.getDefaultCache());
    }

    public LZMAInputStream(InputStream in, long uncompSize, byte propsByte, int dictSize, byte[] presetDict) throws IOException {
        this.endReached = false;
        this.relaxedEndCondition = false;
        this.tempBuf = new byte[1];
        this.exception = null;
        initialize(in, uncompSize, propsByte, dictSize, presetDict, ArrayCache.getDefaultCache());
    }

    public LZMAInputStream(InputStream in, long uncompSize, byte propsByte, int dictSize, byte[] presetDict, ArrayCache arrayCache) throws IOException {
        this.endReached = false;
        this.relaxedEndCondition = false;
        this.tempBuf = new byte[1];
        this.exception = null;
        initialize(in, uncompSize, propsByte, dictSize, presetDict, arrayCache);
    }

    public LZMAInputStream(InputStream in, long uncompSize, int lc, int lp, int pb, int dictSize, byte[] presetDict) throws IOException {
        this.endReached = false;
        this.relaxedEndCondition = false;
        this.tempBuf = new byte[1];
        this.exception = null;
        initialize(in, uncompSize, lc, lp, pb, dictSize, presetDict, ArrayCache.getDefaultCache());
    }

    public LZMAInputStream(InputStream in, long uncompSize, int lc, int lp, int pb, int dictSize, byte[] presetDict, ArrayCache arrayCache) throws IOException {
        this.endReached = false;
        this.relaxedEndCondition = false;
        this.tempBuf = new byte[1];
        this.exception = null;
        initialize(in, uncompSize, lc, lp, pb, dictSize, presetDict, arrayCache);
    }

    private void initialize(InputStream in, long uncompSize, byte propsByte, int dictSize, byte[] presetDict, ArrayCache arrayCache) throws IOException {
        if (uncompSize < (-1)) goto L17;
        int props = propsByte & CecDeviceType.INACTIVE;
        if (props > 224) goto L15;
        int pb = props / 45;
        int props2 = props - ((pb * 9) * 5);
        int lp = props2 / 9;
        int lc = props2 - (lp * 9);
        if (dictSize < 0) goto L13;
        if (dictSize > 2147483632) goto L13;
        initialize(in, uncompSize, lc, lp, pb, dictSize, presetDict, arrayCache);
        return;
    L13:
        throw new UnsupportedOptionsException("LZMA dictionary is too big for this implementation");
    L15:
        throw new CorruptedInputException("Invalid LZMA properties byte");
    L17:
        throw new UnsupportedOptionsException("Uncompressed size is too big");
    }

    private void initialize(InputStream in, long uncompSize, int lc, int lp, int pb, int dictSize, byte[] presetDict, ArrayCache arrayCache) throws IOException {
        if (uncompSize < (-1)) goto L21;
        if (lc < 0) goto L21;
        if (lc > 8) goto L21;
        if (lp < 0) goto L21;
        if (lp > 4) goto L21;
        if (pb < 0) goto L21;
        if (pb > 4) goto L21;
        this.in = in;
        this.arrayCache = arrayCache;
        int dictSize2 = getDictSize(dictSize);
        if (uncompSize >= 0) goto L15;
    L17:
        int dictSize3 = dictSize2;
    L18:
        this.lz = new LZDecoder(getDictSize(dictSize3), presetDict, arrayCache);
        this.rc = new RangeDecoderFromStream(in);
        this.lzma = new LZMADecoder(this.lz, this.rc, lc, lp, pb);
        this.remainingSize = uncompSize;
        return;
    L15:
        if (dictSize2 <= uncompSize) goto L17;
        int dictSize4 = getDictSize((int) uncompSize);
        dictSize3 = dictSize4;
    L21:
        throw new IllegalArgumentException();
    }

    public void enableRelaxedEndCondition() {
        this.relaxedEndCondition = true;
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
        if (off < 0) goto L69;
        if (len < 0) goto L69;
        if ((off + len) < 0) goto L69;
        if ((off + len) > buf.length) goto L69;
        if (len != 0) goto L12;
        return 0;
    L12:
        if (this.in == null) goto L67;
        if (this.exception != null) goto L65;
        if (this.endReached == false) goto L18;
        return -1;
    L18:
        int size = 0;
    L19:
        if (len <= 0) goto L63;
        int copySizeMax = len;
    L26:
        e = move-exception;
        this.exception = e;
        throw e;
    L22:
        if (this.remainingSize >= 0) goto L24;
    L28:
        this.lz.setLimit(copySizeMax);     // Catch: IOException -> L26
        this.lzma.decode();     // Catch: IOException -> L26 CorruptedInputException -> L32
    L38:
        int copiedSize = this.lz.flush(buf, off);     // Catch: IOException -> L26
        off = off + copiedSize;     // Catch: IOException -> L26
        len = len - copiedSize;     // Catch: IOException -> L26
        size = size + copiedSize;     // Catch: IOException -> L26
        if (this.remainingSize < 0) goto L44;
        this.remainingSize -= (long) copiedSize;     // Catch: IOException -> L26
        if (this.remainingSize != 0) goto L44;
        this.endReached = true;     // Catch: IOException -> L26
    L44:
        if (this.endReached == false) goto L19;
        if (this.lz.hasPending() == true) goto L57;
        if (this.relaxedEndCondition == false) goto L50;
    L51:
        putArraysToCache();     // Catch: IOException -> L26
        if (size != 0) goto L55;
        return -1;
    L55:
        return size;
    L50:
        if (this.rc.isFinished() == true) goto L51;
    L57:
        throw new CorruptedInputException();     // Catch: IOException -> L26
    L32:
        e = move-exception;
        if (this.remainingSize != (-1)) goto L60;
        if (this.lzma.endMarkerDetected() == false) goto L60;
        this.endReached = true;     // Catch: IOException -> L26
        this.rc.normalize();     // Catch: IOException -> L26
    L60:
        throw e;     // Catch: IOException -> L26
    L24:
        if (this.remainingSize >= len) goto L28;
        copySizeMax = (int) this.remainingSize;     // Catch: IOException -> L26
        goto L28
    L63:
        return size;
    L65:
        throw this.exception;
    L67:
        throw new XZIOException("Stream closed");
    L69:
        throw new IndexOutOfBoundsException();
    }

    private void putArraysToCache() {
        if (this.lz == null) goto L6;
        this.lz.putArraysToCache(this.arrayCache);
        this.lz = null;
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
