package org.bouncycastle.crypto.engines;

import m0.f;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.crypto.params.KeyParameter;

/* loaded from: classes.dex */
public class RC4Engine implements StreamCipher {
    private static final int STATE_LENGTH = 256;
    private boolean forEncryption;
    private byte[] engineState = null;

    /* renamed from: x, reason: collision with root package name */
    private int f4468x = 0;
    private int y = 0;
    private byte[] workingKey = null;

    public RC4Engine() {
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 20));
    }

    private void setKey(byte[] bArr) {
        this.workingKey = bArr;
        this.f4468x = 0;
        this.y = 0;
        if (this.engineState == null) {
            this.engineState = new byte[256];
        }
        for (int i8 = 0; i8 < 256; i8++) {
            this.engineState[i8] = (byte) i8;
        }
        int length = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < 256; i10++) {
            int i11 = bArr[length] & 255;
            byte[] bArr2 = this.engineState;
            byte b9 = bArr2[i10];
            i9 = (i11 + b9 + i9) & 255;
            bArr2[i10] = bArr2[i9];
            bArr2[i9] = b9;
            length = (length + 1) % bArr.length;
        }
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "RC4";
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException(f.h(cipherParameters, "invalid parameter passed to RC4 init - "));
        }
        byte[] key = ((KeyParameter) cipherParameters).getKey();
        this.workingKey = key;
        this.forEncryption = z;
        setKey(key);
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 20, cipherParameters, Utils.getPurpose(z)));
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public int processBytes(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        if (i8 + i9 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i10 + i9 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        for (int i11 = 0; i11 < i9; i11++) {
            int i12 = (this.f4468x + 1) & 255;
            this.f4468x = i12;
            byte[] bArr3 = this.engineState;
            byte b9 = bArr3[i12];
            int i13 = (this.y + b9) & 255;
            this.y = i13;
            bArr3[i12] = bArr3[i13];
            bArr3[i13] = b9;
            bArr2[i11 + i10] = (byte) (bArr3[(bArr3[i12] + b9) & 255] ^ bArr[i11 + i8]);
        }
        return i9;
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void reset() {
        setKey(this.workingKey);
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public byte returnByte(byte b9) {
        int i8 = (this.f4468x + 1) & 255;
        this.f4468x = i8;
        byte[] bArr = this.engineState;
        byte b10 = bArr[i8];
        int i9 = (this.y + b10) & 255;
        this.y = i9;
        bArr[i8] = bArr[i9];
        bArr[i9] = b10;
        return (byte) (bArr[(bArr[i8] + b10) & 255] ^ b9);
    }
}
