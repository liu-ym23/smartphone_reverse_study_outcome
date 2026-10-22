package com.fasterxml.jackson.dataformat.yaml;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.lang.ref.SoftReference;

/* loaded from: classes2.dex */
public final class UTF8Writer extends Writer {
    private static final int DEFAULT_BUFFER_SIZE = 8000;
    static final int SURR1_FIRST = 55296;
    static final int SURR1_LAST = 56319;
    static final int SURR2_FIRST = 56320;
    static final int SURR2_LAST = 57343;
    protected static final ThreadLocal<SoftReference<byte[][]>> _bufferRecycler = new ThreadLocal<>();
    protected final byte[][] _bufferHolder;
    private OutputStream _out;
    private byte[] _outBuffer;
    private final int _outBufferEnd;
    private int _outPtr;
    int _surrogate = 0;

    public UTF8Writer(OutputStream outputStream) {
        this._out = outputStream;
        byte[][] bArr_findBufferHolder = _findBufferHolder();
        this._bufferHolder = bArr_findBufferHolder;
        byte[] bArr = bArr_findBufferHolder[0];
        if (bArr == null) {
            bArr = new byte[8000];
        } else {
            bArr_findBufferHolder[0] = null;
        }
        this._outBuffer = bArr;
        this._outBufferEnd = bArr.length - 4;
        this._outPtr = 0;
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

    private int convertSurrogate(int i10) throws IOException {
        int i11 = this._surrogate;
        this._surrogate = 0;
        if (i10 >= 56320 && i10 <= 57343) {
            return ((i11 - 55296) << 10) + 65536 + (i10 - 56320);
        }
        throw new IOException("Broken surrogate pair: first char 0x" + Integer.toHexString(i11) + ", second 0x" + Integer.toHexString(i10) + "; illegal combination");
    }

    private void throwIllegal(int i10) throws IOException {
        if (i10 > 1114111) {
            throw new IOException("Illegal character point (0x" + Integer.toHexString(i10) + ") to output; max is 0x10FFFF as per RFC 4627");
        }
        if (i10 < 55296) {
            throw new IOException("Illegal character point (0x" + Integer.toHexString(i10) + ") to output");
        }
        if (i10 <= 56319) {
            throw new IOException("Unmatched first part of surrogate pair (0x" + Integer.toHexString(i10) + ")");
        }
        throw new IOException("Unmatched second part of surrogate pair (0x" + Integer.toHexString(i10) + ")");
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        byte[] bArr;
        OutputStream outputStream = this._out;
        if (outputStream != null) {
            int i10 = this._outPtr;
            if (i10 > 0) {
                outputStream.write(this._outBuffer, 0, i10);
                this._outPtr = 0;
            }
            OutputStream outputStream2 = this._out;
            this._out = null;
            byte[][] bArr2 = this._bufferHolder;
            if (bArr2 != null && (bArr = this._outBuffer) != null) {
                this._outBuffer = null;
                bArr2[0] = bArr;
            }
            outputStream2.close();
            int i11 = this._surrogate;
            this._surrogate = 0;
            if (i11 > 0) {
                throwIllegal(i11);
            }
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        OutputStream outputStream = this._out;
        if (outputStream != null) {
            int i10 = this._outPtr;
            if (i10 > 0) {
                outputStream.write(this._outBuffer, 0, i10);
                this._outPtr = 0;
            }
            this._out.flush();
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr) throws IOException {
        write(cArr, 0, cArr.length);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c10) throws IOException {
        write(c10);
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0025, code lost:
    
        continue;
     */
    @Override // java.io.Writer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void write(char[] r9, int r10, int r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.dataformat.yaml.UTF8Writer.write(char[], int, int):void");
    }

    @Override // java.io.Writer
    public void write(int i10) throws IOException {
        int i11;
        if (this._surrogate > 0) {
            i10 = convertSurrogate(i10);
        } else if (i10 >= 55296 && i10 <= 57343) {
            if (i10 > 56319) {
                throwIllegal(i10);
            }
            this._surrogate = i10;
            return;
        }
        int i12 = this._outPtr;
        if (i12 >= this._outBufferEnd) {
            this._out.write(this._outBuffer, 0, i12);
            this._outPtr = 0;
        }
        if (i10 < 128) {
            byte[] bArr = this._outBuffer;
            int i13 = this._outPtr;
            this._outPtr = i13 + 1;
            bArr[i13] = (byte) i10;
            return;
        }
        int i14 = this._outPtr;
        if (i10 < 2048) {
            byte[] bArr2 = this._outBuffer;
            int i15 = i14 + 1;
            bArr2[i14] = (byte) ((i10 >> 6) | 192);
            i11 = i14 + 2;
            bArr2[i15] = (byte) ((i10 & 63) | 128);
        } else if (i10 <= 65535) {
            byte[] bArr3 = this._outBuffer;
            bArr3[i14] = (byte) ((i10 >> 12) | 224);
            int i16 = i14 + 2;
            bArr3[i14 + 1] = (byte) (((i10 >> 6) & 63) | 128);
            i11 = i14 + 3;
            bArr3[i16] = (byte) ((i10 & 63) | 128);
        } else {
            if (i10 > 1114111) {
                throwIllegal(i10);
            }
            byte[] bArr4 = this._outBuffer;
            bArr4[i14] = (byte) ((i10 >> 18) | 240);
            bArr4[i14 + 1] = (byte) (((i10 >> 12) & 63) | 128);
            int i17 = i14 + 3;
            bArr4[i14 + 2] = (byte) (((i10 >> 6) & 63) | 128);
            i11 = i14 + 4;
            bArr4[i17] = (byte) ((i10 & 63) | 128);
        }
        this._outPtr = i11;
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        write(str, 0, str.length());
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x0029, code lost:
    
        continue;
     */
    @Override // java.io.Writer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void write(java.lang.String r9, int r10, int r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.dataformat.yaml.UTF8Writer.write(java.lang.String, int, int):void");
    }
}
