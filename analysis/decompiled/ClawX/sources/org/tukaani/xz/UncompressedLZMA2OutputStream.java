package org.tukaani.xz;

import java.io.DataOutputStream;
import java.io.IOException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
class UncompressedLZMA2OutputStream extends FinishableOutputStream {
    private final ArrayCache arrayCache;
    private FinishableOutputStream out;
    private final DataOutputStream outData;
    private final byte[] uncompBuf;
    private int uncompPos = 0;
    private boolean dictResetNeeded = true;
    private boolean finished = false;
    private IOException exception = null;
    private final byte[] tempBuf = new byte[1];

    public UncompressedLZMA2OutputStream(FinishableOutputStream finishableOutputStream, ArrayCache arrayCache) {
        finishableOutputStream.getClass();
        this.out = finishableOutputStream;
        this.outData = new DataOutputStream(finishableOutputStream);
        this.arrayCache = arrayCache;
        this.uncompBuf = arrayCache.getByteArray(65536, false);
    }

    public static int getMemoryUsage() {
        return 70;
    }

    private void writeChunk() throws IOException {
        this.outData.writeByte(this.dictResetNeeded ? 1 : 2);
        this.outData.writeShort(this.uncompPos - 1);
        this.outData.write(this.uncompBuf, 0, this.uncompPos);
        this.uncompPos = 0;
        this.dictResetNeeded = false;
    }

    private void writeEndMarker() throws IOException {
        IOException iOException = this.exception;
        if (iOException != null) {
            throw iOException;
        }
        if (this.finished) {
            throw new XZIOException("Stream finished or closed");
        }
        try {
            if (this.uncompPos > 0) {
                writeChunk();
            }
            this.out.write(0);
            this.finished = true;
            this.arrayCache.putArray(this.uncompBuf);
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
                    writeEndMarker();
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
        writeEndMarker();
        try {
            this.out.finish();
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
            if (this.uncompPos > 0) {
                writeChunk();
            }
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
                if (this.finished) {
                    throw new XZIOException("Stream finished or closed");
                }
                while (i9 > 0) {
                    try {
                        int iMin = Math.min(65536 - this.uncompPos, i9);
                        System.arraycopy(bArr, i8, this.uncompBuf, this.uncompPos, iMin);
                        i9 -= iMin;
                        int i11 = this.uncompPos + iMin;
                        this.uncompPos = i11;
                        if (i11 == 65536) {
                            writeChunk();
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
