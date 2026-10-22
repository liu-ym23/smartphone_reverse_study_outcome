package org.tukaani.xz;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.check.Check;
import org.tukaani.xz.common.DecoderUtil;
import org.tukaani.xz.common.StreamFlags;
import org.tukaani.xz.index.IndexHash;

/* JADX INFO: loaded from: classes3.dex */
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

    private static byte[] readStreamHeader(InputStream in) throws IOException {
        byte[] streamHeader = new byte[12];
        new DataInputStream(in).readFully(streamHeader);
        return streamHeader;
    }

    public SingleXZInputStream(InputStream in) throws IOException {
        this(in, -1);
    }

    public SingleXZInputStream(InputStream in, ArrayCache arrayCache) throws IOException {
        this(in, -1, arrayCache);
    }

    public SingleXZInputStream(InputStream in, int memoryLimit) throws IOException {
        this(in, memoryLimit, true);
    }

    public SingleXZInputStream(InputStream in, int memoryLimit, ArrayCache arrayCache) throws IOException {
        this(in, memoryLimit, true, arrayCache);
    }

    public SingleXZInputStream(InputStream in, int memoryLimit, boolean verifyCheck) throws IOException {
        this(in, memoryLimit, verifyCheck, ArrayCache.getDefaultCache());
    }

    public SingleXZInputStream(InputStream in, int memoryLimit, boolean verifyCheck, ArrayCache arrayCache) throws IOException {
        this(in, memoryLimit, verifyCheck, readStreamHeader(in), arrayCache);
    }

    SingleXZInputStream(InputStream in, int memoryLimit, boolean verifyCheck, byte[] streamHeader, ArrayCache arrayCache) throws IOException {
        this.blockDecoder = null;
        this.indexHash = new IndexHash();
        this.endReached = false;
        this.exception = null;
        this.tempBuf = new byte[1];
        this.arrayCache = arrayCache;
        this.in = in;
        this.memoryLimit = memoryLimit;
        this.verifyCheck = verifyCheck;
        this.streamHeaderFlags = DecoderUtil.decodeStreamHeader(streamHeader);
        this.check = Check.getInstance(this.streamHeaderFlags.checkType);
    }

    public int getCheckType() {
        return this.streamHeaderFlags.checkType;
    }

    public String getCheckName() {
        return this.check.getName();
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
        if (len != 0) goto L13;
        return 0;
    L13:
        if (this.in == null) goto L47;
        if (this.exception != null) goto L45;
        if (this.endReached == false) goto L19;
        return -1;
    L19:
        int off2 = off;
        int len2 = len;
        int size = 0;
    L20:
        if (len2 <= 0) goto L43;
    L25:
        e = move-exception;
        this.exception = e;
        if (size != 0) goto L43;
        throw e;
    L22:
        if (this.blockDecoder == null) goto L50;
    L32:
        int ret = this.blockDecoder.read(buf, off2, len2);     // Catch: IOException -> L25
        if (ret > 0) goto L34;
        if (ret != (-1)) goto L20;
        this.indexHash.add(this.blockDecoder.getUnpaddedSize(), this.blockDecoder.getUncompressedSize());     // Catch: IOException -> L25
        this.blockDecoder = null;     // Catch: IOException -> L25
        goto L20
    L34:
        size = size + ret;     // Catch: IOException -> L25
        off2 = off2 + ret;     // Catch: IOException -> L25
        len2 = len2 - ret;     // Catch: IOException -> L25
        goto L20
    L50:
        this.blockDecoder = new BlockInputStream(this.in, this.check, this.verifyCheck, this.memoryLimit, -1, -1, this.arrayCache);     // Catch: IOException -> L25 IndexIndicatorException -> L27
    L28:
        this.indexHash.validate(this.in);     // Catch: IOException -> L25
        validateStreamFooter();     // Catch: IOException -> L25
        this.endReached = true;     // Catch: IOException -> L25
        if (size > 0) goto L31;
        return -1;
    L31:
        return size;
    L43:
        return size;
    L45:
        throw this.exception;
    L47:
        throw new XZIOException("Stream closed");
    L49:
        throw new IndexOutOfBoundsException();
    }

    private void validateStreamFooter() throws IOException {
        byte[] buf = new byte[12];
        new DataInputStream(this.in).readFully(buf);
        StreamFlags streamFooterFlags = DecoderUtil.decodeStreamFooter(buf);
        if (DecoderUtil.areStreamFlagsEqual(this.streamHeaderFlags, streamFooterFlags) == false) goto L8;
        if (this.indexHash.getIndexSize() != streamFooterFlags.backwardSize) goto L8;
        return;
    L8:
        throw new CorruptedInputException("XZ Stream Footer does not match Stream Header");
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.in == null) goto L14;
        if (this.exception != null) goto L12;
        if (this.blockDecoder != null) goto L10;
        return 0;
    L10:
        return this.blockDecoder.available();
    L12:
        throw this.exception;
    L14:
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
}
