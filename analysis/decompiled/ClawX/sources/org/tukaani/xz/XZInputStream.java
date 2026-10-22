package org.tukaani.xz;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class XZInputStream extends InputStream {
    private final ArrayCache arrayCache;
    private boolean endReached;
    private IOException exception;
    private InputStream in;
    private final int memoryLimit;
    private final byte[] tempBuf;
    private final boolean verifyCheck;
    private SingleXZInputStream xzIn;

    public XZInputStream(InputStream inputStream) {
        this(inputStream, -1);
    }

    private void prepareNextStream() throws IOException {
        DataInputStream dataInputStream = new DataInputStream(this.in);
        byte[] bArr = new byte[12];
        while (dataInputStream.read(bArr, 0, 1) != -1) {
            dataInputStream.readFully(bArr, 1, 3);
            if (bArr[0] != 0 || bArr[1] != 0 || bArr[2] != 0 || bArr[3] != 0) {
                dataInputStream.readFully(bArr, 4, 8);
                try {
                    this.xzIn = new SingleXZInputStream(this.in, this.memoryLimit, this.verifyCheck, bArr, this.arrayCache);
                    return;
                } catch (XZFormatException unused) {
                    throw new CorruptedInputException("Garbage after a valid XZ Stream");
                }
            }
        }
        this.endReached = true;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.in == null) {
            throw new XZIOException("Stream closed");
        }
        IOException iOException = this.exception;
        if (iOException != null) {
            throw iOException;
        }
        SingleXZInputStream singleXZInputStream = this.xzIn;
        if (singleXZInputStream == null) {
            return 0;
        }
        return singleXZInputStream.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        close(true);
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.tempBuf, 0, 1) == -1) {
            return -1;
        }
        return this.tempBuf[0] & 255;
    }

    public XZInputStream(InputStream inputStream, ArrayCache arrayCache) {
        this(inputStream, -1, arrayCache);
    }

    public void close(boolean z) throws IOException {
        if (this.in != null) {
            SingleXZInputStream singleXZInputStream = this.xzIn;
            if (singleXZInputStream != null) {
                singleXZInputStream.close(false);
                this.xzIn = null;
            }
            if (z) {
                try {
                    this.in.close();
                } finally {
                    this.in = null;
                }
            }
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i8, int i9) throws IOException {
        int i10;
        if (i8 < 0 || i9 < 0 || (i10 = i8 + i9) < 0 || i10 > bArr.length) {
            throw new IndexOutOfBoundsException();
        }
        int i11 = 0;
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
        if (this.endReached) {
            return -1;
        }
        while (true) {
            if (i9 <= 0) {
                break;
            }
            try {
                if (this.xzIn == null) {
                    prepareNextStream();
                    if (this.endReached) {
                        if (i11 == 0) {
                            return -1;
                        }
                    }
                }
                int i12 = this.xzIn.read(bArr, i8, i9);
                if (i12 > 0) {
                    i11 += i12;
                    i8 += i12;
                    i9 -= i12;
                } else if (i12 == -1) {
                    this.xzIn = null;
                }
            } catch (IOException e9) {
                this.exception = e9;
                if (i11 == 0) {
                    throw e9;
                }
            }
        }
        return i11;
    }

    public XZInputStream(InputStream inputStream, int i8) {
        this(inputStream, i8, true);
    }

    public XZInputStream(InputStream inputStream, int i8, ArrayCache arrayCache) {
        this(inputStream, i8, true, arrayCache);
    }

    public XZInputStream(InputStream inputStream, int i8, boolean z) {
        this(inputStream, i8, z, ArrayCache.getDefaultCache());
    }

    public XZInputStream(InputStream inputStream, int i8, boolean z, ArrayCache arrayCache) {
        this.endReached = false;
        this.exception = null;
        this.tempBuf = new byte[1];
        this.arrayCache = arrayCache;
        this.in = inputStream;
        this.memoryLimit = i8;
        this.verifyCheck = z;
        this.xzIn = new SingleXZInputStream(inputStream, i8, z, arrayCache);
    }
}
