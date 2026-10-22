package com.alibaba.fastjson.asm;

/* loaded from: classes.dex */
public class ByteVector {
    byte[] data;
    int length;

    public ByteVector() {
        this.data = new byte[64];
    }

    private void enlarge(int i4) {
        byte[] bArr = this.data;
        int length = bArr.length * 2;
        int i5 = this.length;
        int i6 = i4 + i5;
        if (length <= i6) {
            length = i6;
        }
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, i5);
        this.data = bArr2;
    }

    public ByteVector put11(int i4, int i5) {
        int i6 = this.length;
        if (i6 + 2 > this.data.length) {
            enlarge(2);
        }
        byte[] bArr = this.data;
        bArr[i6] = (byte) i4;
        bArr[i6 + 1] = (byte) i5;
        this.length = i6 + 2;
        return this;
    }

    public ByteVector put12(int i4, int i5) {
        int i6 = this.length;
        if (i6 + 3 > this.data.length) {
            enlarge(3);
        }
        byte[] bArr = this.data;
        bArr[i6] = (byte) i4;
        bArr[i6 + 1] = (byte) (i5 >>> 8);
        bArr[i6 + 2] = (byte) i5;
        this.length = i6 + 3;
        return this;
    }

    public ByteVector putByte(int i4) {
        int i5 = this.length;
        int i6 = i5 + 1;
        if (i6 > this.data.length) {
            enlarge(1);
        }
        this.data[i5] = (byte) i4;
        this.length = i6;
        return this;
    }

    public ByteVector putByteArray(byte[] bArr, int i4, int i5) {
        if (this.length + i5 > this.data.length) {
            enlarge(i5);
        }
        if (bArr != null) {
            System.arraycopy(bArr, i4, this.data, this.length, i5);
        }
        this.length += i5;
        return this;
    }

    public ByteVector putInt(int i4) {
        int i5 = this.length;
        if (i5 + 4 > this.data.length) {
            enlarge(4);
        }
        byte[] bArr = this.data;
        bArr[i5] = (byte) (i4 >>> 24);
        bArr[i5 + 1] = (byte) (i4 >>> 16);
        bArr[i5 + 2] = (byte) (i4 >>> 8);
        bArr[i5 + 3] = (byte) i4;
        this.length = i5 + 4;
        return this;
    }

    public ByteVector putShort(int i4) {
        int i5 = this.length;
        if (i5 + 2 > this.data.length) {
            enlarge(2);
        }
        byte[] bArr = this.data;
        bArr[i5] = (byte) (i4 >>> 8);
        bArr[i5 + 1] = (byte) i4;
        this.length = i5 + 2;
        return this;
    }

    public ByteVector putUTF8(String str) {
        int length = str.length();
        int i4 = this.length;
        if (i4 + 2 + length > this.data.length) {
            enlarge(length + 2);
        }
        byte[] bArr = this.data;
        int i5 = i4 + 1;
        bArr[i4] = (byte) (length >>> 8);
        int i6 = i4 + 2;
        bArr[i5] = (byte) length;
        int i7 = 0;
        while (i7 < length) {
            char cCharAt = str.charAt(i7);
            if (cCharAt < 1 || cCharAt > 127) {
                throw new UnsupportedOperationException();
            }
            bArr[i6] = (byte) cCharAt;
            i7++;
            i6++;
        }
        this.length = i6;
        return this;
    }

    public ByteVector(int i4) {
        this.data = new byte[i4];
    }
}
