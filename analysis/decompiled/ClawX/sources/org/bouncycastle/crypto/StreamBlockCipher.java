package org.bouncycastle.crypto;

/* loaded from: classes.dex */
public abstract class StreamBlockCipher extends DefaultMultiBlockCipher implements StreamCipher {
    private final BlockCipher cipher;

    public StreamBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
    }

    public abstract byte calculateByte(byte b9);

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public int processBytes(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        int i11 = i8 + i9;
        if (i11 > bArr.length) {
            throw new DataLengthException("input buffer too small");
        }
        if (i10 + i9 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        while (i8 < i11) {
            bArr2[i10] = calculateByte(bArr[i8]);
            i10++;
            i8++;
        }
        return i9;
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public final byte returnByte(byte b9) {
        return calculateByte(b9);
    }
}
