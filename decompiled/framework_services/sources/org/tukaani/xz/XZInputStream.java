package org.tukaani.xz;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class XZInputStream extends InputStream {
    private final ArrayCache arrayCache;
    private boolean endReached;
    private IOException exception;
    private InputStream in;
    private final int memoryLimit;
    private final byte[] tempBuf;
    private final boolean verifyCheck;
    private SingleXZInputStream xzIn;

    public XZInputStream(InputStream in) throws IOException {
        this(in, -1);
    }

    public XZInputStream(InputStream in, ArrayCache arrayCache) throws IOException {
        this(in, -1, arrayCache);
    }

    public XZInputStream(InputStream in, int memoryLimit) throws IOException {
        this(in, memoryLimit, true);
    }

    public XZInputStream(InputStream in, int memoryLimit, ArrayCache arrayCache) throws IOException {
        this(in, memoryLimit, true, arrayCache);
    }

    public XZInputStream(InputStream in, int memoryLimit, boolean verifyCheck) throws IOException {
        this(in, memoryLimit, verifyCheck, ArrayCache.getDefaultCache());
    }

    public XZInputStream(InputStream in, int memoryLimit, boolean verifyCheck, ArrayCache arrayCache) throws IOException {
        this.endReached = false;
        this.exception = null;
        this.tempBuf = new byte[1];
        this.arrayCache = arrayCache;
        this.in = in;
        this.memoryLimit = memoryLimit;
        this.verifyCheck = verifyCheck;
        this.xzIn = new SingleXZInputStream(in, memoryLimit, verifyCheck, arrayCache);
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
        if (off < 0) goto L47;
        if (len < 0) goto L47;
        if ((off + len) < 0) goto L47;
        if ((off + len) > buf.length) goto L47;
        if (len != 0) goto L12;
        return 0;
    L12:
        if (this.in == null) goto L45;
        if (this.exception != null) goto L43;
        if (this.endReached == false) goto L18;
        return -1;
    L18:
        int size = 0;
    L19:
        if (len <= 0) goto L41;
        if (this.xzIn != null) goto L30;
        prepareNextStream();     // Catch: IOException -> L28
        if (this.endReached == false) goto L30;
        if (size != 0) goto L27;
        return -1;
    L27:
        return size;
    L30:
        int ret = this.xzIn.read(buf, off, len);     // Catch: IOException -> L28
        if (ret > 0) goto L32;
        if (ret != (-1)) goto L19;
        this.xzIn = null;     // Catch: IOException -> L28
        goto L19
    L32:
        size = size + ret;     // Catch: IOException -> L28
        off = off + ret;     // Catch: IOException -> L28
        len = len - ret;     // Catch: IOException -> L28
    L28:
        e = move-exception;
        this.exception = e;
        if (size != 0) goto L41;
        throw e;
    L41:
        return size;
    L43:
        throw this.exception;
    L45:
        throw new XZIOException("Stream closed");
    L47:
        throw new IndexOutOfBoundsException();
    }

    private void prepareNextStream() throws IOException {
        DataInputStream inData = new DataInputStream(this.in);
        byte[] buf = new byte[12];
    L3:
        int ret = inData.read(buf, 0, 1);
        if (ret == (-1)) goto L5;
        inData.readFully(buf, 1, 3);
        if (buf[0] != 0) goto L15;
        if (buf[1] != 0) goto L15;
        if (buf[2] != 0) goto L15;
        if (buf[3] == 0) goto L3;
    L15:
        inData.readFully(buf, 4, 8);
        this.xzIn = new SingleXZInputStream(this.in, this.memoryLimit, this.verifyCheck, buf, this.arrayCache);     // Catch: XZFormatException -> L18
        return;
    L20:
        throw new CorruptedInputException("Garbage after a valid XZ Stream");
    L5:
        this.endReached = true;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.in == null) goto L14;
        if (this.exception != null) goto L12;
        if (this.xzIn != null) goto L10;
        return 0;
    L10:
        return this.xzIn.available();
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
        if (this.xzIn == null) goto L7;
        this.xzIn.close(false);
        this.xzIn = null;
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
