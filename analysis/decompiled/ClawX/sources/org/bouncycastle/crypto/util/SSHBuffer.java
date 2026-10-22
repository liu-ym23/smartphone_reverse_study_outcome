package org.bouncycastle.crypto.util;

import java.math.BigInteger;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* loaded from: classes.dex */
class SSHBuffer {
    private final byte[] buffer;
    private int pos = 0;

    public SSHBuffer(byte[] bArr) {
        this.buffer = bArr;
    }

    public byte[] getBuffer() {
        return Arrays.clone(this.buffer);
    }

    public boolean hasRemaining() {
        return this.pos < this.buffer.length;
    }

    public BigInteger readBigNumPositive() {
        int u32 = readU32();
        int i8 = this.pos;
        int i9 = i8 + u32;
        byte[] bArr = this.buffer;
        if (i9 > bArr.length) {
            throw new IllegalArgumentException("not enough data for big num");
        }
        int i10 = u32 + i8;
        this.pos = i10;
        return new BigInteger(1, Arrays.copyOfRange(bArr, i8, i10));
    }

    public byte[] readBlock() {
        int u32 = readU32();
        if (u32 == 0) {
            return new byte[0];
        }
        int i8 = this.pos;
        byte[] bArr = this.buffer;
        if (i8 > bArr.length - u32) {
            throw new IllegalArgumentException("not enough data for block");
        }
        int i9 = u32 + i8;
        this.pos = i9;
        return Arrays.copyOfRange(bArr, i8, i9);
    }

    public byte[] readPaddedBlock() {
        return readPaddedBlock(8);
    }

    public String readString() {
        return Strings.fromByteArray(readBlock());
    }

    public int readU32() {
        int i8 = this.pos;
        byte[] bArr = this.buffer;
        if (i8 > bArr.length - 4) {
            throw new IllegalArgumentException("4 bytes for U32 exceeds buffer.");
        }
        int i9 = i8 + 1;
        this.pos = i9;
        int i10 = (bArr[i8] & 255) << 24;
        int i11 = i8 + 2;
        this.pos = i11;
        int i12 = ((bArr[i9] & 255) << 16) | i10;
        int i13 = i8 + 3;
        this.pos = i13;
        int i14 = i12 | ((bArr[i11] & 255) << 8);
        this.pos = i8 + 4;
        return (bArr[i13] & 255) | i14;
    }

    public void skipBlock() {
        int u32 = readU32();
        int i8 = this.pos;
        if (i8 > this.buffer.length - u32) {
            throw new IllegalArgumentException("not enough data for block");
        }
        this.pos = i8 + u32;
    }

    public SSHBuffer(byte[] bArr, byte[] bArr2) {
        this.buffer = bArr2;
        for (int i8 = 0; i8 != bArr.length; i8++) {
            if (bArr[i8] != bArr2[i8]) {
                throw new IllegalArgumentException("magic-number incorrect");
            }
        }
        this.pos += bArr.length;
    }

    public byte[] readPaddedBlock(int i8) {
        int i9;
        int u32 = readU32();
        if (u32 == 0) {
            return new byte[0];
        }
        int i10 = this.pos;
        byte[] bArr = this.buffer;
        if (i10 > bArr.length - u32) {
            throw new IllegalArgumentException("not enough data for block");
        }
        if (u32 % i8 != 0) {
            throw new IllegalArgumentException("missing padding");
        }
        int i11 = i10 + u32;
        this.pos = i11;
        if (u32 > 0 && (i9 = bArr[i11 - 1] & 255) > 0 && i9 < i8) {
            i11 -= i9;
            int i12 = 1;
            int i13 = i11;
            while (i12 <= i9) {
                if (i12 != (this.buffer[i13] & 255)) {
                    throw new IllegalArgumentException("incorrect padding");
                }
                i12++;
                i13++;
            }
        }
        return Arrays.copyOfRange(this.buffer, i10, i11);
    }
}
