package org.tukaani.xz;

import java.io.IOException;
import org.tukaani.xz.simple.SimpleFilter;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
class SimpleOutputStream extends FinishableOutputStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int FILTER_BUF_SIZE = 4096;
    private FinishableOutputStream out;
    private final SimpleFilter simpleFilter;
    private final byte[] filterBuf = new byte[4096];
    private int pos = 0;
    private int unfiltered = 0;
    private IOException exception = null;
    private boolean finished = false;
    private final byte[] tempBuf = new byte[1];

    public SimpleOutputStream(FinishableOutputStream finishableOutputStream, SimpleFilter simpleFilter) {
        finishableOutputStream.getClass();
        this.out = finishableOutputStream;
        this.simpleFilter = simpleFilter;
    }

    public static int getMemoryUsage() {
        return 5;
    }

    private void writePending() throws IOException {
        IOException iOException = this.exception;
        if (iOException != null) {
            throw iOException;
        }
        try {
            this.out.write(this.filterBuf, this.pos, this.unfiltered);
            this.finished = true;
        } catch (IOException e9) {
            this.exception = e9;
            throw e9;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.out != null) {
            if (!this.finished) {
                try {
                    writePending();
                } catch (IOException unused) {
                }
            }
            try {
                this.out.close();
            } catch (IOException e9) {
                if (this.exception == null) {
                    this.exception = e9;
                }
            }
            this.out = null;
        }
        IOException iOException = this.exception;
        if (iOException != null) {
            throw iOException;
        }
    }

    @Override // org.tukaani.xz.FinishableOutputStream
    public void finish() throws IOException {
        if (this.finished) {
            return;
        }
        writePending();
        try {
            this.out.finish();
        } catch (IOException e9) {
            this.exception = e9;
            throw e9;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws UnsupportedOptionsException {
        throw new UnsupportedOptionsException("Flushing is not supported");
    }

    @Override // java.io.OutputStream
    public void write(int i8) throws IOException {
        byte[] bArr = this.tempBuf;
        bArr[0] = (byte) i8;
        write(bArr, 0, 1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i8, int i9) throws IOException {
        int i10;
        if (i8 >= 0 && i9 >= 0 && (i10 = i8 + i9) >= 0 && i10 <= bArr.length) {
            IOException iOException = this.exception;
            if (iOException == null) {
                if (this.finished) {
                    throw new XZIOException("Stream finished or closed");
                }
                while (i9 > 0) {
                    int iMin = Math.min(i9, 4096 - (this.pos + this.unfiltered));
                    System.arraycopy(bArr, i8, this.filterBuf, this.pos + this.unfiltered, iMin);
                    i8 += iMin;
                    i9 -= iMin;
                    int i11 = this.unfiltered + iMin;
                    this.unfiltered = i11;
                    int iCode = this.simpleFilter.code(this.filterBuf, this.pos, i11);
                    this.unfiltered -= iCode;
                    try {
                        this.out.write(this.filterBuf, this.pos, iCode);
                        int i12 = this.pos + iCode;
                        this.pos = i12;
                        int i13 = this.unfiltered;
                        if (i12 + i13 == 4096) {
                            byte[] bArr2 = this.filterBuf;
                            System.arraycopy(bArr2, i12, bArr2, 0, i13);
                            this.pos = 0;
                        }
                    } catch (IOException e9) {
                        this.exception = e9;
                        throw e9;
                    }
                }
                return;
            }
            throw iOException;
        }
        throw new IndexOutOfBoundsException();
    }
}
