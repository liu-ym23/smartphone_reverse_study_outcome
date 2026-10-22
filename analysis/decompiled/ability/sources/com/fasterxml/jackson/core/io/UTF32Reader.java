package com.fasterxml.jackson.core.io;

import androidx.appfunctions.metadata.a;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.internal.shaded.fdp.v2_19_2.FastDoubleMath;
import java.io.CharConversionException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/* loaded from: classes2.dex */
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

    public UTF32Reader(IOContext iOContext, InputStream inputStream, byte[] bArr, int i, int i6, boolean z10) {
        this._context = iOContext;
        this._in = inputStream;
        this._buffer = bArr;
        this._ptr = i;
        this._length = i6;
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

    private boolean loadMore(int i) throws IOException {
        byte[] bArr;
        InputStream inputStream = this._in;
        if (inputStream == null || (bArr = this._buffer) == null) {
            return false;
        }
        this._byteCount = (this._length - i) + this._byteCount;
        if (i > 0) {
            int i6 = this._ptr;
            if (i6 > 0) {
                System.arraycopy(bArr, i6, bArr, 0, i);
                this._ptr = 0;
            }
            this._length = i;
        } else {
            this._ptr = 0;
            int i10 = inputStream.read(bArr);
            if (i10 < 1) {
                this._length = 0;
                if (i10 < 0) {
                    if (this._managedBuffers) {
                        freeBuffers();
                    }
                    return false;
                }
                reportStrangeStream();
            }
            this._length = i10;
        }
        while (true) {
            int i11 = this._length;
            if (i11 >= 4) {
                return true;
            }
            InputStream inputStream2 = this._in;
            byte[] bArr2 = this._buffer;
            int i12 = inputStream2.read(bArr2, i11, bArr2.length - i11);
            if (i12 < 1) {
                if (i12 < 0) {
                    if (this._managedBuffers) {
                        freeBuffers();
                    }
                    reportUnexpectedEOF(this._length, 4);
                }
                reportStrangeStream();
            }
            this._length += i12;
        }
    }

    private void reportBounds(char[] cArr, int i, int i6) throws IOException {
        throw new ArrayIndexOutOfBoundsException(String.format("read(buf,%d,%d), cbuf[%d]", Integer.valueOf(i), Integer.valueOf(i6), Integer.valueOf(cArr.length)));
    }

    private void reportInvalid(int i, int i6, String str) throws IOException {
        int i10 = (this._byteCount + this._ptr) - 1;
        throw new CharConversionException("Invalid UTF-32 character 0x" + Integer.toHexString(i) + str + " at char #" + (this._charCount + i6) + ", byte #" + i10 + ")");
    }

    private void reportStrangeStream() throws IOException {
        throw new IOException("Strange I/O stream, returned 0 bytes on read");
    }

    private void reportUnexpectedEOF(int i, int i6) throws IOException {
        int i10 = this._byteCount + i;
        int i11 = this._charCount;
        StringBuilder sbS = a.s(i, "Unexpected EOF in the middle of a 4-byte UTF-32 char: got ", i6, ", needed ", ", at char #");
        sbS.append(i11);
        sbS.append(", byte #");
        sbS.append(i10);
        sbS.append(")");
        throw new CharConversionException(sbS.toString());
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
    public int read(char[] cArr, int i, int i6) throws IOException {
        int i10;
        int i11;
        int i12;
        if (this._buffer == null) {
            return -1;
        }
        if (i6 < 1) {
            return i6;
        }
        if (i < 0 || i + i6 > cArr.length) {
            reportBounds(cArr, i, i6);
        }
        int i13 = i6 + i;
        char c = this._surrogate;
        if (c != 0) {
            i10 = i + 1;
            cArr[i] = c;
            this._surrogate = (char) 0;
        } else {
            int i14 = this._length - this._ptr;
            if (i14 < 4 && !loadMore(i14)) {
                if (i14 == 0) {
                    return -1;
                }
                reportUnexpectedEOF(this._length - this._ptr, 4);
            }
            i10 = i;
        }
        int i15 = this._length - 4;
        while (true) {
            if (i10 >= i13) {
                break;
            }
            int i16 = this._ptr;
            if (i16 > i15) {
                break;
            }
            if (this._bigEndian) {
                byte[] bArr = this._buffer;
                i11 = (bArr[i16] << 8) | (bArr[i16 + 1] & 255);
                i12 = (bArr[i16 + 3] & 255) | ((bArr[i16 + 2] & 255) << 8);
            } else {
                byte[] bArr2 = this._buffer;
                int i17 = (bArr2[i16] & 255) | ((bArr2[i16 + 1] & 255) << 8);
                i11 = (bArr2[i16 + 3] << 8) | (bArr2[i16 + 2] & 255);
                i12 = i17;
            }
            this._ptr = i16 + 4;
            if (i11 != 0) {
                int i18 = 65535 & i11;
                int i19 = i12 | ((i18 - 1) << 16);
                if (i18 > 16) {
                    reportInvalid(i19, i10 - i, String.format(" (above 0x%08x)", Integer.valueOf(LAST_VALID_UNICODE_CHAR)));
                }
                int i20 = i10 + 1;
                cArr[i10] = (char) ((i19 >> 10) + GeneratorBase.SURR1_FIRST);
                int i21 = (i19 & FastDoubleMath.DOUBLE_EXPONENT_BIAS) | GeneratorBase.SURR2_FIRST;
                if (i20 >= i13) {
                    this._surrogate = (char) i19;
                    i10 = i20;
                    break;
                }
                i12 = i21;
                i10 = i20;
            }
            cArr[i10] = (char) i12;
            i10++;
        }
        int i22 = i10 - i;
        this._charCount += i22;
        return i22;
    }
}
