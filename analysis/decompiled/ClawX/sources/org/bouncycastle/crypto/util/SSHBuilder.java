package org.bouncycastle.crypto.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.util.Strings;

/* loaded from: classes.dex */
class SSHBuilder {
    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    public byte[] getBytes() {
        return this.bos.toByteArray();
    }

    public byte[] getPaddedBytes() {
        return getPaddedBytes(8);
    }

    public void u32(int i8) {
        this.bos.write((i8 >>> 24) & 255);
        this.bos.write((i8 >>> 16) & 255);
        this.bos.write((i8 >>> 8) & 255);
        this.bos.write(i8 & 255);
    }

    public void writeBigNum(BigInteger bigInteger) throws IOException {
        writeBlock(bigInteger.toByteArray());
    }

    public void writeBlock(byte[] bArr) throws IOException {
        u32(bArr.length);
        try {
            this.bos.write(bArr);
        } catch (IOException e9) {
            throw new IllegalStateException(e9.getMessage(), e9);
        }
    }

    public void writeBytes(byte[] bArr) throws IOException {
        try {
            this.bos.write(bArr);
        } catch (IOException e9) {
            throw new IllegalStateException(e9.getMessage(), e9);
        }
    }

    public void writeString(String str) throws IOException {
        writeBlock(Strings.toByteArray(str));
    }

    public byte[] getPaddedBytes(int i8) {
        int size = this.bos.size() % i8;
        if (size != 0) {
            int i9 = i8 - size;
            for (int i10 = 1; i10 <= i9; i10++) {
                this.bos.write(i10);
            }
        }
        return this.bos.toByteArray();
    }
}
