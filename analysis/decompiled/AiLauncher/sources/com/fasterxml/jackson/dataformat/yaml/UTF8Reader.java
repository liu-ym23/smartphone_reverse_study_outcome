package com.fasterxml.jackson.dataformat.yaml;

import com.autonavi.aps.amapapi.config.Const;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.ref.SoftReference;

/* loaded from: classes2.dex */
public final class UTF8Reader extends Reader {
    private static final int DEFAULT_BUFFER_SIZE = 8000;
    protected static final ThreadLocal<SoftReference<byte[][]>> _bufferRecycler = new ThreadLocal<>();
    private final boolean _autoClose;
    protected final byte[][] _bufferHolder;
    int _byteCount;
    int _charCount;
    protected byte[] _inputBuffer;
    protected int _inputEnd;
    protected int _inputPtr;
    private InputStream _inputSource;
    protected int _surrogate;
    private char[] _tmpBuffer;

    public UTF8Reader(InputStream inputStream, boolean z10) {
        super(inputStream == null ? new Object() : inputStream);
        this._surrogate = -1;
        this._charCount = 0;
        this._byteCount = 0;
        this._tmpBuffer = null;
        this._inputSource = inputStream;
        byte[][] bArr_findBufferHolder = _findBufferHolder();
        this._bufferHolder = bArr_findBufferHolder;
        byte[] bArr = bArr_findBufferHolder[0];
        if (bArr == null) {
            bArr = new byte[8000];
        } else {
            bArr_findBufferHolder[0] = null;
        }
        this._inputBuffer = bArr;
        this._inputPtr = 0;
        this._inputEnd = 0;
        this._autoClose = z10;
    }

    private static byte[][] _findBufferHolder() {
        ThreadLocal<SoftReference<byte[][]>> threadLocal = _bufferRecycler;
        SoftReference<byte[][]> softReference = threadLocal.get();
        byte[][] bArr = softReference != null ? softReference.get() : null;
        if (bArr != null) {
            return bArr;
        }
        byte[][] bArr2 = new byte[1][];
        threadLocal.set(new SoftReference<>(bArr2));
        return bArr2;
    }

    private boolean loadMore(int i10) throws IOException {
        int i11;
        this._byteCount += this._inputEnd - i10;
        if (i10 <= 0) {
            int bytes = readBytes();
            if (bytes < 1) {
                freeBuffers();
                if (bytes < 0) {
                    return false;
                }
                reportStrangeStream();
            }
        } else if (this._inputPtr > 0) {
            if (!canModifyBuffer() && this._inputSource == null) {
                throw new IOException(String.format("End-of-input after first %d byte(s) of a UTF-8 character: needed at least one more", Integer.valueOf(i10)));
            }
            for (int i12 = 0; i12 < i10; i12++) {
                byte[] bArr = this._inputBuffer;
                bArr[i12] = bArr[this._inputPtr + i12];
            }
            this._inputPtr = 0;
            this._inputEnd = i10;
        }
        byte b10 = this._inputBuffer[this._inputPtr];
        if (b10 >= 0) {
            return true;
        }
        if ((b10 & 224) == 192) {
            i11 = 2;
        } else {
            if ((b10 & 240) != 224) {
                if ((b10 & 248) == 240) {
                    i11 = 4;
                }
                return true;
            }
            i11 = 3;
        }
        while (true) {
            int i13 = this._inputPtr + i11;
            int i14 = this._inputEnd;
            if (i13 <= i14) {
                break;
            }
            int bytesAt = readBytesAt(i14);
            if (bytesAt < 1) {
                if (bytesAt < 0) {
                    freeBuffers();
                    reportUnexpectedEOF(this._inputEnd, i11);
                }
                reportStrangeStream();
            }
        }
        return true;
    }

    private void reportInvalidInitial(int i10, int i11) throws IOException {
        int i12 = (this._byteCount + this._inputPtr) - 1;
        throw new CharConversionException("Invalid UTF-8 start byte 0x" + Integer.toHexString(i10) + " (at char #" + (this._charCount + i11 + 1) + ", byte #" + i12 + ")");
    }

    private void reportInvalidOther(int i10, int i11) throws IOException {
        int i12 = (this._byteCount + this._inputPtr) - 1;
        throw new CharConversionException("Invalid UTF-8 middle byte 0x" + Integer.toHexString(i10) + " (at char #" + (this._charCount + i11) + ", byte #" + i12 + ")");
    }

    private void reportUnexpectedEOF(int i10, int i11) throws IOException {
        int i12 = this._byteCount + i10;
        throw new CharConversionException("Unexpected EOF in the middle of a multi-byte char: got " + i10 + ", needed " + i11 + ", at char #" + this._charCount + ", byte #" + i12 + ")");
    }

    public final boolean canModifyBuffer() {
        return this._bufferHolder != null;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this._inputSource;
        if (inputStream != null) {
            this._inputSource = null;
            if (this._autoClose) {
                inputStream.close();
            }
        }
        freeBuffers();
    }

    public final void freeBuffers() {
        byte[] bArr;
        byte[][] bArr2 = this._bufferHolder;
        if (bArr2 == null || (bArr = this._inputBuffer) == null) {
            return;
        }
        this._inputBuffer = null;
        bArr2[0] = bArr;
    }

    public final InputStream getStream() {
        return this._inputSource;
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        if (this._tmpBuffer == null) {
            this._tmpBuffer = new char[1];
        }
        if (read(this._tmpBuffer, 0, 1) < 1) {
            return -1;
        }
        return this._tmpBuffer[0];
    }

    public final int readBytes() throws IOException {
        this._inputPtr = 0;
        this._inputEnd = 0;
        InputStream inputStream = this._inputSource;
        if (inputStream == null) {
            return -1;
        }
        byte[] bArr = this._inputBuffer;
        int i10 = inputStream.read(bArr, 0, bArr.length);
        if (i10 > 0) {
            this._inputEnd = i10;
        }
        return i10;
    }

    public final int readBytesAt(int i10) throws IOException {
        InputStream inputStream = this._inputSource;
        if (inputStream == null) {
            return -1;
        }
        byte[] bArr = this._inputBuffer;
        int i11 = inputStream.read(bArr, i10, bArr.length - i10);
        if (i11 > 0) {
            this._inputEnd += i11;
        }
        return i11;
    }

    public void reportBounds(char[] cArr, int i10, int i11) throws IOException {
        throw new ArrayIndexOutOfBoundsException("read(buf," + i10 + Const.STR_MART_COMMA + i11 + "), cbuf[" + cArr.length + "]");
    }

    public void reportStrangeStream() throws IOException {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }

    @Override // java.io.Reader
    public int read(char[] cArr) throws IOException {
        return read(cArr, 0, cArr.length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0093 A[SYNTHETIC] */
    @Override // java.io.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int read(char[] r17, int r18, int r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.dataformat.yaml.UTF8Reader.read(char[], int, int):int");
    }

    public UTF8Reader(byte[] bArr, int i10, int i11, boolean z10) {
        super(new Object());
        this._surrogate = -1;
        this._charCount = 0;
        this._byteCount = 0;
        this._tmpBuffer = null;
        this._inputSource = null;
        this._inputBuffer = bArr;
        this._inputPtr = i10;
        this._inputEnd = i10 + i11;
        this._autoClose = z10;
        this._bufferHolder = null;
    }
}
