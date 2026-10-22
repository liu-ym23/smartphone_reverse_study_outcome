package org.bouncycastle.crypto.prng;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;

/* loaded from: classes.dex */
public class FixedSecureRandom extends SecureRandom {
    private byte[] _data;
    private int _index;
    private int _intPad;

    public FixedSecureRandom(boolean z, byte[] bArr) {
        this(z, new byte[][]{bArr});
    }

    private int nextValue() {
        byte[] bArr = this._data;
        int i8 = this._index;
        this._index = i8 + 1;
        return bArr[i8] & 255;
    }

    @Override // java.security.SecureRandom
    public byte[] generateSeed(int i8) {
        byte[] bArr = new byte[i8];
        nextBytes(bArr);
        return bArr;
    }

    public boolean isExhausted() {
        return this._index == this._data.length;
    }

    @Override // java.security.SecureRandom, java.util.Random
    public void nextBytes(byte[] bArr) {
        System.arraycopy(this._data, this._index, bArr, 0, bArr.length);
        this._index += bArr.length;
    }

    @Override // java.util.Random
    public int nextInt() {
        int iNextValue = (nextValue() << 24) | (nextValue() << 16);
        int i8 = this._intPad;
        if (i8 == 2) {
            this._intPad = i8 - 1;
        } else {
            iNextValue |= nextValue() << 8;
        }
        int i9 = this._intPad;
        if (i9 != 1) {
            return nextValue() | iNextValue;
        }
        this._intPad = i9 - 1;
        return iNextValue;
    }

    @Override // java.util.Random
    public long nextLong() {
        return (nextValue() << 56) | (nextValue() << 48) | (nextValue() << 40) | (nextValue() << 32) | (nextValue() << 24) | (nextValue() << 16) | (nextValue() << 8) | nextValue();
    }

    public FixedSecureRandom(boolean z, byte[][] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i8 = 0; i8 != bArr.length; i8++) {
            try {
                byteArrayOutputStream.write(bArr[i8]);
            } catch (IOException unused) {
                throw new IllegalArgumentException("can't save value array.");
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        this._data = byteArray;
        if (z) {
            this._intPad = byteArray.length % 4;
        }
    }

    public FixedSecureRandom(byte[] bArr) {
        this(false, new byte[][]{bArr});
    }

    public FixedSecureRandom(byte[][] bArr) {
        this(false, bArr);
    }
}
