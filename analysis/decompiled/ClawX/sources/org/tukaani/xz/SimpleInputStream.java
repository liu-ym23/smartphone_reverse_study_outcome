package org.tukaani.xz;

import java.io.IOException;
import java.io.InputStream;
import org.tukaani.xz.simple.SimpleFilter;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
class SimpleInputStream extends InputStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int FILTER_BUF_SIZE = 4096;
    private InputStream in;
    private final SimpleFilter simpleFilter;
    private final byte[] filterBuf = new byte[4096];
    private int pos = 0;
    private int filtered = 0;
    private int unfiltered = 0;
    private boolean endReached = false;
    private IOException exception = null;
    private final byte[] tempBuf = new byte[1];

    public SimpleInputStream(InputStream inputStream, SimpleFilter simpleFilter) {
        inputStream.getClass();
        this.in = inputStream;
        this.simpleFilter = simpleFilter;
    }

    public static int getMemoryUsage() {
        return 5;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.in == null) {
            throw new XZIOException("Stream closed");
        }
        IOException iOException = this.exception;
        if (iOException == null) {
            return this.filtered;
        }
        throw iOException;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        InputStream inputStream = this.in;
        if (inputStream != null) {
            try {
                inputStream.close();
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
        int i11 = 0;
        while (true) {
            try {
                int iMin = Math.min(this.filtered, i9);
                System.arraycopy(this.filterBuf, this.pos, bArr, i8, iMin);
                int i12 = this.pos + iMin;
                this.pos = i12;
                int i13 = this.filtered - iMin;
                this.filtered = i13;
                i8 += iMin;
                i9 -= iMin;
                i11 += iMin;
                int i14 = this.unfiltered;
                if (i12 + i13 + i14 == 4096) {
                    byte[] bArr2 = this.filterBuf;
                    System.arraycopy(bArr2, i12, bArr2, 0, i13 + i14);
                    this.pos = 0;
                }
                if (i9 == 0 || this.endReached) {
                    break;
                }
                int i15 = this.pos;
                int i16 = this.filtered;
                int i17 = this.unfiltered;
                int i18 = this.in.read(this.filterBuf, i15 + i16 + i17, 4096 - ((i15 + i16) + i17));
                if (i18 == -1) {
                    this.endReached = true;
                    this.filtered = this.unfiltered;
                    this.unfiltered = 0;
                } else {
                    int i19 = this.unfiltered + i18;
                    this.unfiltered = i19;
                    int iCode = this.simpleFilter.code(this.filterBuf, this.pos, i19);
                    this.filtered = iCode;
                    this.unfiltered -= iCode;
                }
            } catch (IOException e9) {
                this.exception = e9;
                throw e9;
            }
        }
        if (i11 > 0) {
            return i11;
        }
        return -1;
    }
}
