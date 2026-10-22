package org.bouncycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
class IndefiniteLengthInputStream extends LimitedInputStream {
    private int _b1;
    private int _b2;
    private boolean _eofOn00;
    private boolean _eofReached;

    public IndefiniteLengthInputStream(InputStream inputStream, int i8) throws IOException {
        super(inputStream, i8);
        this._eofReached = false;
        this._eofOn00 = true;
        this._b1 = inputStream.read();
        int i9 = inputStream.read();
        this._b2 = i9;
        if (i9 < 0) {
            throw new EOFException();
        }
        checkForEof();
    }

    private boolean checkForEof() {
        if (!this._eofReached && this._eofOn00 && this._b1 == 0 && this._b2 == 0) {
            this._eofReached = true;
            setParentEofDetect(true);
        }
        return this._eofReached;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (checkForEof()) {
            return -1;
        }
        int i8 = this._in.read();
        if (i8 < 0) {
            throw new EOFException();
        }
        int i9 = this._b1;
        this._b1 = this._b2;
        this._b2 = i8;
        return i9;
    }

    public void setEofOn00(boolean z) {
        this._eofOn00 = z;
        checkForEof();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i8, int i9) throws IOException {
        if (this._eofOn00 || i9 < 3) {
            return super.read(bArr, i8, i9);
        }
        if (this._eofReached) {
            return -1;
        }
        int i10 = this._in.read(bArr, i8 + 2, i9 - 2);
        if (i10 < 0) {
            throw new EOFException();
        }
        bArr[i8] = (byte) this._b1;
        bArr[i8 + 1] = (byte) this._b2;
        this._b1 = this._in.read();
        int i11 = this._in.read();
        this._b2 = i11;
        if (i11 >= 0) {
            return i10 + 2;
        }
        throw new EOFException();
    }
}
