package org.apache.commons.compress.compressors.lz77support;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.CountingInputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractLZ77CompressorInputStream extends CompressorInputStream implements InputStreamStatistics {
    private int backReferenceOffset;
    private final byte[] buf;
    private long bytesRemaining;
    private final CountingInputStream in;
    private final byte[] oneByte;
    private int readIndex;
    private int size;
    protected final ByteUtils.ByteSupplier supplier;
    private final int windowSize;
    private int writeIndex;

    public AbstractLZ77CompressorInputStream(InputStream is, int windowSize) throws IOException {
        this.size = 0;
        this.oneByte = new byte[1];
        this.supplier = new AnonymousClass1(this);
        this.in = new CountingInputStream(is);
        this.windowSize = windowSize;
        this.buf = new byte[windowSize * 3];
        this.readIndex = 0;
        this.writeIndex = 0;
        this.bytesRemaining = 0;
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
        this.in.close();
    }

    @Override // java.io.InputStream
    public int available() {
        return this.writeIndex - this.readIndex;
    }

    public int getSize() {
        return this.size;
    }

    public void prefill(byte[] data) {
        if (this.writeIndex != 0) goto L7;
        int len = Math.min(this.windowSize, data.length);
        System.arraycopy(data, data.length - len, this.buf, 0, len);
        this.writeIndex += len;
        this.readIndex += len;
        return;
    L7:
        throw new IllegalStateException("the stream has already been read from, can't prefill anymore");
    }

    @Override // org.apache.commons.compress.utils.InputStreamStatistics
    public long getCompressedCount() {
        return this.in.getBytesRead();
    }

    protected final void startLiteral(long length) {
        this.bytesRemaining = length;
    }

    protected final boolean hasMoreDataInBlock() {
        if (this.bytesRemaining <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    protected final int readLiteral(byte[] b, int off, int len) throws IOException {
        int avail = available();
        if (len <= avail) goto L6;
        tryToReadLiteral(len - avail);
    L6:
        return readFromBuffer(b, off, len);
    }

    private void tryToReadLiteral(int bytesToRead) throws IOException {
        int reallyTryToRead = Math.min((int) Math.min(bytesToRead, this.bytesRemaining), this.buf.length - this.writeIndex);
        if (reallyTryToRead <= 0) goto L5;
        int bytesRead = IOUtils.readFully(this.in, this.buf, this.writeIndex, reallyTryToRead);
    L6:
        count(bytesRead);
        if (reallyTryToRead != bytesRead) goto L11;
        this.writeIndex += reallyTryToRead;
        this.bytesRemaining -= (long) reallyTryToRead;
        return;
    L11:
        throw new IOException("Premature end of stream reading literal");
    L5:
        bytesRead = 0;
        goto L6
    }

    private int readFromBuffer(byte[] b, int off, int len) {
        int readable = Math.min(len, available());
        if (readable <= 0) goto L7;
        System.arraycopy(this.buf, this.readIndex, b, off, readable);
        this.readIndex += readable;
        if (this.readIndex <= (this.windowSize * 2)) goto L7;
        slideBuffer();
    L7:
        this.size += readable;
        return readable;
    }

    private void slideBuffer() {
        System.arraycopy(this.buf, this.windowSize, this.buf, 0, this.windowSize * 2);
        this.writeIndex -= this.windowSize;
        this.readIndex -= this.windowSize;
    }

    protected final void startBackReference(int offset, long length) {
        this.backReferenceOffset = offset;
        this.bytesRemaining = length;
    }

    protected final int readBackReference(byte[] b, int off, int len) {
        int avail = available();
        if (len <= avail) goto L6;
        tryToCopy(len - avail);
    L6:
        return readFromBuffer(b, off, len);
    }

    private void tryToCopy(int bytesToCopy) {
        int copy = Math.min((int) Math.min(bytesToCopy, this.bytesRemaining), this.buf.length - this.writeIndex);
        if (copy != 0) goto L6;
    L17:
        this.bytesRemaining -= (long) copy;
        return;
    L6:
        if (this.backReferenceOffset != 1) goto L9;
        byte last = this.buf[this.writeIndex - 1];
        Arrays.fill(this.buf, this.writeIndex, this.writeIndex + copy, last);
        this.writeIndex += copy;
        goto L17
    L9:
        if (copy >= this.backReferenceOffset) goto L11;
        System.arraycopy(this.buf, this.writeIndex - this.backReferenceOffset, this.buf, this.writeIndex, copy);
        this.writeIndex += copy;
        goto L17
    L11:
        int fullRots = copy / this.backReferenceOffset;
        int i = 0;
    L12:
        if (i >= fullRots) goto L14;
        System.arraycopy(this.buf, this.writeIndex - this.backReferenceOffset, this.buf, this.writeIndex, this.backReferenceOffset);
        this.writeIndex += this.backReferenceOffset;
        i = i + 1;
        goto L12
    L14:
        int i2 = this.backReferenceOffset;
        int pad = copy - (i2 * fullRots);
        if (pad <= 0) goto L17;
        System.arraycopy(this.buf, this.writeIndex - this.backReferenceOffset, this.buf, this.writeIndex, pad);
        this.writeIndex += pad;
        goto L17
    }

    protected final int readOneByte() throws IOException {
        int b = this.in.read();
        if (b == (-1)) goto L6;
        count(1);
        return b & 255;
    L6:
        return -1;
    }
}
