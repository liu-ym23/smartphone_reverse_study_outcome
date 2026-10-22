package org.bouncycastle.asn1;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.util.io.Streams;

/* loaded from: classes.dex */
class DefiniteLengthInputStream extends LimitedInputStream {
    private static final byte[] EMPTY_BYTES = new byte[0];
    private final int _originalLength;
    private int _remaining;

    public DefiniteLengthInputStream(InputStream inputStream, int i8, int i9) {
        super(inputStream, i9);
        if (i8 <= 0) {
            if (i8 < 0) {
                throw new IllegalArgumentException("negative lengths not allowed");
            }
            setParentEofDetect(true);
        }
        this._originalLength = i8;
        this._remaining = i8;
    }

    public int getRemaining() {
        return this._remaining;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this._remaining == 0) {
            return -1;
        }
        int i8 = this._in.read();
        if (i8 >= 0) {
            int i9 = this._remaining - 1;
            this._remaining = i9;
            if (i9 == 0) {
                setParentEofDetect(true);
            }
            return i8;
        }
        throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
    }

    public void readAllIntoByteArray(byte[] bArr) throws IOException {
        int i8 = this._remaining;
        if (i8 != bArr.length) {
            throw new IllegalArgumentException("buffer length not right for data");
        }
        if (i8 == 0) {
            return;
        }
        int limit = getLimit();
        int i9 = this._remaining;
        if (i9 >= limit) {
            throw new IOException("corrupted stream - out of bounds length found: " + this._remaining + " >= " + limit);
        }
        int fully = i9 - Streams.readFully(this._in, bArr, 0, bArr.length);
        this._remaining = fully;
        if (fully == 0) {
            setParentEofDetect(true);
            return;
        }
        throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
    }

    public byte[] toByteArray() throws IOException {
        if (this._remaining == 0) {
            return EMPTY_BYTES;
        }
        int limit = getLimit();
        int i8 = this._remaining;
        if (i8 >= limit) {
            throw new IOException("corrupted stream - out of bounds length found: " + this._remaining + " >= " + limit);
        }
        byte[] bArr = new byte[i8];
        int fully = i8 - Streams.readFully(this._in, bArr, 0, i8);
        this._remaining = fully;
        if (fully == 0) {
            setParentEofDetect(true);
            return bArr;
        }
        throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i8, int i9) throws IOException {
        int i10 = this._remaining;
        if (i10 == 0) {
            return -1;
        }
        int i11 = this._in.read(bArr, i8, Math.min(i9, i10));
        if (i11 >= 0) {
            int i12 = this._remaining - i11;
            this._remaining = i12;
            if (i12 == 0) {
                setParentEofDetect(true);
            }
            return i11;
        }
        throw new EOFException("DEF length " + this._originalLength + " object truncated by " + this._remaining);
    }
}
