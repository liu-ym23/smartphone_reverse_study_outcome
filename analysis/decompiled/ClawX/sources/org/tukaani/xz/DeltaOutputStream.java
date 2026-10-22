package org.tukaani.xz;

import java.io.IOException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
class DeltaOutputStream extends FinishableOutputStream {
    private static final int FILTER_BUF_SIZE = 4096;
    private final org.tukaani.xz.delta.DeltaEncoder delta;
    private FinishableOutputStream out;
    private final byte[] filterBuf = new byte[4096];
    private boolean finished = false;
    private IOException exception = null;
    private final byte[] tempBuf = new byte[1];

    public DeltaOutputStream(FinishableOutputStream finishableOutputStream, DeltaOptions deltaOptions) {
        this.out = finishableOutputStream;
        this.delta = new org.tukaani.xz.delta.DeltaEncoder(deltaOptions.getDistance());
    }

    public static int getMemoryUsage() {
        return 5;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        FinishableOutputStream finishableOutputStream = this.out;
        if (finishableOutputStream != null) {
            try {
                finishableOutputStream.close();
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
        IOException iOException = this.exception;
        if (iOException != null) {
            throw iOException;
        }
        try {
            this.out.finish();
            this.finished = true;
        } catch (IOException e9) {
            this.exception = e9;
            throw e9;
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        IOException iOException = this.exception;
        if (iOException != null) {
            throw iOException;
        }
        if (this.finished) {
            throw new XZIOException("Stream finished or closed");
        }
        try {
            this.out.flush();
        } catch (IOException e9) {
            this.exception = e9;
            throw e9;
        }
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
                if (!this.finished) {
                    while (i9 > 4096) {
                        try {
                            this.delta.encode(bArr, i8, 4096, this.filterBuf);
                            this.out.write(this.filterBuf);
                            i8 += 4096;
                            i9 -= 4096;
                        } catch (IOException e9) {
                            this.exception = e9;
                            throw e9;
                        }
                    }
                    this.delta.encode(bArr, i8, i9, this.filterBuf);
                    this.out.write(this.filterBuf, 0, i9);
                    return;
                }
                throw new XZIOException("Stream finished");
            }
            throw iOException;
        }
        throw new IndexOutOfBoundsException();
    }
}
