package com.fasterxml.jackson.dataformat.yaml;

import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.lang.ref.SoftReference;
import k0.a;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
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
            bArr = new byte[DEFAULT_BUFFER_SIZE];
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

    private boolean loadMore(int i) throws IOException {
        int i3;
        this._byteCount = (this._inputEnd - i) + this._byteCount;
        if (i <= 0) {
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
                throw new IOException(String.format("End-of-input after first %d byte(s) of a UTF-8 character: needed at least one more", Integer.valueOf(i)));
            }
            for (int i10 = 0; i10 < i; i10++) {
                byte[] bArr = this._inputBuffer;
                bArr[i10] = bArr[this._inputPtr + i10];
            }
            this._inputPtr = 0;
            this._inputEnd = i;
        }
        byte b10 = this._inputBuffer[this._inputPtr];
        if (b10 >= 0) {
            return true;
        }
        if ((b10 & 224) == 192) {
            i3 = 2;
        } else {
            if ((b10 & 240) != 224) {
                if ((b10 & 248) == 240) {
                    i3 = 4;
                }
                return true;
            }
            i3 = 3;
        }
        while (true) {
            int i11 = this._inputPtr + i3;
            int i12 = this._inputEnd;
            if (i11 <= i12) {
                break;
            }
            int bytesAt = readBytesAt(i12);
            if (bytesAt < 1) {
                if (bytesAt < 0) {
                    freeBuffers();
                    reportUnexpectedEOF(this._inputEnd, i3);
                }
                reportStrangeStream();
            }
        }
        return true;
    }

    private void reportInvalidInitial(int i, int i3) throws CharConversionException {
        int i10 = (this._byteCount + this._inputPtr) - 1;
        int i11 = this._charCount + i3 + 1;
        StringBuilder sb2 = new StringBuilder("Invalid UTF-8 start byte 0x");
        sb2.append(Integer.toHexString(i));
        sb2.append(" (at char #");
        sb2.append(i11);
        sb2.append(", byte #");
        throw new CharConversionException(a.r(sb2, i10, ")"));
    }

    private void reportInvalidOther(int i, int i3) throws CharConversionException {
        int i10 = (this._byteCount + this._inputPtr) - 1;
        int i11 = this._charCount + i3;
        StringBuilder sb2 = new StringBuilder("Invalid UTF-8 middle byte 0x");
        sb2.append(Integer.toHexString(i));
        sb2.append(" (at char #");
        sb2.append(i11);
        sb2.append(", byte #");
        throw new CharConversionException(a.r(sb2, i10, ")"));
    }

    private void reportUnexpectedEOF(int i, int i3) throws CharConversionException {
        int i10 = this._byteCount + i;
        int i11 = this._charCount;
        StringBuilder sbU = a.u("Unexpected EOF in the middle of a multi-byte char: got ", i, ", needed ", ", at char #", i3);
        sbU.append(i11);
        sbU.append(", byte #");
        sbU.append(i10);
        sbU.append(")");
        throw new CharConversionException(sbU.toString());
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0093 A[SYNTHETIC] */
    @Override // java.io.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int read(char[] r17, int r18, int r19) throws java.io.CharConversionException {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.dataformat.yaml.UTF8Reader.read(char[], int, int):int");
    }

    public final int readBytes() throws IOException {
        this._inputPtr = 0;
        this._inputEnd = 0;
        InputStream inputStream = this._inputSource;
        if (inputStream == null) {
            return -1;
        }
        byte[] bArr = this._inputBuffer;
        int i = inputStream.read(bArr, 0, bArr.length);
        if (i > 0) {
            this._inputEnd = i;
        }
        return i;
    }

    public final int readBytesAt(int i) throws IOException {
        InputStream inputStream = this._inputSource;
        if (inputStream == null) {
            return -1;
        }
        byte[] bArr = this._inputBuffer;
        int i3 = inputStream.read(bArr, i, bArr.length - i);
        if (i3 > 0) {
            this._inputEnd += i3;
        }
        return i3;
    }

    public void reportBounds(char[] cArr, int i, int i3) {
        throw new ArrayIndexOutOfBoundsException(a.r(a.u("read(buf,", i, ",", "), cbuf[", i3), cArr.length, "]"));
    }

    public void reportStrangeStream() throws IOException {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }

    public UTF8Reader(byte[] bArr, int i, int i3, boolean z10) {
        super(new Object());
        this._surrogate = -1;
        this._charCount = 0;
        this._byteCount = 0;
        this._tmpBuffer = null;
        this._inputSource = null;
        this._inputBuffer = bArr;
        this._inputPtr = i;
        this._inputEnd = i + i3;
        this._autoClose = z10;
        this._bufferHolder = null;
    }

    @Override // java.io.Reader
    public int read(char[] cArr) {
        return read(cArr, 0, cArr.length);
    }

    @Override // java.io.Reader
    public int read() {
        if (this._tmpBuffer == null) {
            this._tmpBuffer = new char[1];
        }
        if (read(this._tmpBuffer, 0, 1) < 1) {
            return -1;
        }
        return this._tmpBuffer[0];
    }
}
