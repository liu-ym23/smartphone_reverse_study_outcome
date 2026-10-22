package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.FastDoubleMath;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* loaded from: classes.dex */
public class UTF32Reader extends Reader {
    protected static final int LAST_VALID_UNICODE_CHAR = 1114111;
    protected static final char NC = 0;
    protected final boolean _bigEndian;
    protected byte[] _buffer;
    protected int _byteCount;
    protected int _charCount;
    protected final IOContext _context;
    protected InputStream _in;
    protected int _length;
    protected final boolean _managedBuffers;
    protected int _ptr;
    protected char _surrogate = 0;
    protected char[] _tmpBuf;

    public UTF32Reader(IOContext iOContext, InputStream inputStream, byte[] bArr, int i10, int i11, boolean z10) {
        this._context = iOContext;
        this._in = inputStream;
        this._buffer = bArr;
        this._ptr = i10;
        this._length = i11;
        this._bigEndian = z10;
        this._managedBuffers = inputStream != null;
    }

    private void freeBuffers() {
        byte[] bArr = this._buffer;
        if (bArr != null) {
            this._buffer = null;
            IOContext iOContext = this._context;
            if (iOContext != null) {
                iOContext.releaseReadIOBuffer(bArr);
            }
        }
    }

    private boolean loadMore(int i10) throws IOException {
        byte[] bArr;
        InputStream inputStream = this._in;
        if (inputStream == null || (bArr = this._buffer) == null) {
            return false;
        }
        this._byteCount += this._length - i10;
        if (i10 > 0) {
            int i11 = this._ptr;
            if (i11 > 0) {
                System.arraycopy(bArr, i11, bArr, 0, i10);
                this._ptr = 0;
            }
            this._length = i10;
        } else {
            this._ptr = 0;
            int i12 = inputStream.read(bArr);
            if (i12 < 1) {
                this._length = 0;
                if (i12 < 0) {
                    if (this._managedBuffers) {
                        freeBuffers();
                    }
                    return false;
                }
                reportStrangeStream();
            }
            this._length = i12;
        }
        while (true) {
            int i13 = this._length;
            if (i13 >= 4) {
                return true;
            }
            InputStream inputStream2 = this._in;
            byte[] bArr2 = this._buffer;
            int i14 = inputStream2.read(bArr2, i13, bArr2.length - i13);
            if (i14 < 1) {
                if (i14 < 0) {
                    if (this._managedBuffers) {
                        freeBuffers();
                    }
                    reportUnexpectedEOF(this._length, 4);
                }
                reportStrangeStream();
            }
            this._length += i14;
        }
    }

    private void reportBounds(char[] cArr, int i10, int i11) throws IOException {
        throw new ArrayIndexOutOfBoundsException(String.format("read(buf,%d,%d), cbuf[%d]", Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(cArr.length)));
    }

    private void reportInvalid(int i10, int i11, String str) throws IOException {
        int i12 = (this._byteCount + this._ptr) - 1;
        throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(i10) + str + " at char #" + (this._charCount + i11) + ", byte #" + i12 + ")");
    }

    private void reportStrangeStream() throws IOException {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }

    private void reportUnexpectedEOF(int i10, int i11) throws IOException {
        int i12 = this._byteCount + i10;
        throw new CharConversionException("Unexpected EOF in the middle of a 4-byte UTF-32 char: got " + i10 + ", needed " + i11 + ", at char #" + this._charCount + ", byte #" + i12 + ")");
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this._in;
        if (inputStream != null) {
            this._in = null;
            freeBuffers();
            inputStream.close();
        }
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        if (this._tmpBuf == null) {
            this._tmpBuf = new char[1];
        }
        if (read(this._tmpBuf, 0, 1) < 1) {
            return -1;
        }
        return this._tmpBuf[0];
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i10, int i11) throws IOException {
        int i12;
        int i13;
        int i14;
        if (this._buffer == null) {
            return -1;
        }
        if (i11 < 1) {
            return i11;
        }
        if (i10 < 0 || i10 + i11 > cArr.length) {
            reportBounds(cArr, i10, i11);
        }
        int i15 = i11 + i10;
        char c10 = this._surrogate;
        if (c10 != 0) {
            i12 = i10 + 1;
            cArr[i10] = c10;
            this._surrogate = (char) 0;
        } else {
            int i16 = this._length - this._ptr;
            if (i16 < 4 && !loadMore(i16)) {
                if (i16 == 0) {
                    return -1;
                }
                reportUnexpectedEOF(this._length - this._ptr, 4);
            }
            i12 = i10;
        }
        int i17 = this._length - 4;
        while (true) {
            if (i12 >= i15) {
                break;
            }
            int i18 = this._ptr;
            if (i18 > i17) {
                break;
            }
            if (this._bigEndian) {
                byte[] bArr = this._buffer;
                i13 = (bArr[i18] << 8) | (bArr[i18 + 1] & 255);
                i14 = (bArr[i18 + 3] & 255) | ((bArr[i18 + 2] & 255) << 8);
            } else {
                byte[] bArr2 = this._buffer;
                int i19 = (bArr2[i18] & 255) | ((bArr2[i18 + 1] & 255) << 8);
                i13 = (bArr2[i18 + 3] << 8) | (bArr2[i18 + 2] & 255);
                i14 = i19;
            }
            this._ptr = i18 + 4;
            if (i13 != 0) {
                int i20 = 65535 & i13;
                int i21 = i14 | ((i20 - 1) << 16);
                if (i20 > 16) {
                    reportInvalid(i21, i12 - i10, String.format(" (above 0x%08x)", Integer.valueOf(LAST_VALID_UNICODE_CHAR)));
                }
                int i22 = i12 + 1;
                cArr[i12] = (char) ((i21 >> 10) + GeneratorBase.SURR1_FIRST);
                int i23 = (i21 & FastDoubleMath.DOUBLE_EXPONENT_BIAS) | GeneratorBase.SURR2_FIRST;
                if (i22 >= i15) {
                    this._surrogate = (char) i21;
                    i12 = i22;
                    break;
                }
                i14 = i23;
                i12 = i22;
            }
            cArr[i12] = (char) i14;
            i12++;
        }
        int i24 = i12 - i10;
        this._charCount += i24;
        return i24;
    }
}
