package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

/* loaded from: classes.dex */
public class VMPCEngine implements StreamCipher {
    protected byte[] workingIV;
    protected byte[] workingKey;

    /* renamed from: n, reason: collision with root package name */
    protected byte f4478n = 0;
    protected byte[] P = null;

    /* renamed from: s, reason: collision with root package name */
    protected byte f4479s = 0;

    @Override // org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "VMPC";
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof ParametersWithIV)) {
            throw new IllegalArgumentException("VMPC init parameters must include an IV");
        }
        ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
        if (!(parametersWithIV.getParameters() instanceof KeyParameter)) {
            throw new IllegalArgumentException("VMPC init parameters must include a key");
        }
        KeyParameter keyParameter = (KeyParameter) parametersWithIV.getParameters();
        byte[] iv = parametersWithIV.getIV();
        this.workingIV = iv;
        if (iv == null || iv.length < 1 || iv.length > 768) {
            throw new IllegalArgumentException("VMPC requires 1 to 768 bytes of IV");
        }
        byte[] key = keyParameter.getKey();
        this.workingKey = key;
        initKey(key, this.workingIV);
        String algorithmName = getAlgorithmName();
        byte[] bArr = this.workingKey;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(algorithmName, bArr.length >= 32 ? 256 : bArr.length * 8, cipherParameters, Utils.getPurpose(z)));
    }

    public void initKey(byte[] bArr, byte[] bArr2) {
        this.f4479s = (byte) 0;
        this.P = new byte[256];
        for (int i8 = 0; i8 < 256; i8++) {
            this.P[i8] = (byte) i8;
        }
        for (int i9 = 0; i9 < 768; i9++) {
            byte[] bArr3 = this.P;
            byte b9 = this.f4479s;
            int i10 = i9 & 255;
            byte b10 = bArr3[i10];
            byte b11 = bArr3[(b9 + b10 + bArr[i9 % bArr.length]) & 255];
            this.f4479s = b11;
            bArr3[i10] = bArr3[b11 & 255];
            bArr3[b11 & 255] = b10;
        }
        for (int i11 = 0; i11 < 768; i11++) {
            byte[] bArr4 = this.P;
            byte b12 = this.f4479s;
            int i12 = i11 & 255;
            byte b13 = bArr4[i12];
            byte b14 = bArr4[(b12 + b13 + bArr2[i11 % bArr2.length]) & 255];
            this.f4479s = b14;
            bArr4[i12] = bArr4[b14 & 255];
            bArr4[b14 & 255] = b13;
        }
        this.f4478n = (byte) 0;
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
            byte[] bArr3 = this.P;
            byte b9 = this.f4479s;
            byte b10 = this.f4478n;
            byte b11 = bArr3[(b9 + bArr3[b10 & 255]) & 255];
            this.f4479s = b11;
            byte b12 = bArr3[(bArr3[bArr3[b11 & 255] & 255] + 1) & 255];
            byte b13 = bArr3[b10 & 255];
            bArr3[b10 & 255] = bArr3[b11 & 255];
            bArr3[b11 & 255] = b13;
            this.f4478n = (byte) ((b10 + 1) & 255);
            bArr2[i11 + i10] = (byte) (bArr[i11 + i8] ^ b12);
        }
        return i9;
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void reset() {
        initKey(this.workingKey, this.workingIV);
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public byte returnByte(byte b9) {
        byte[] bArr = this.P;
        byte b10 = this.f4479s;
        byte b11 = this.f4478n;
        byte b12 = bArr[(b10 + bArr[b11 & 255]) & 255];
        this.f4479s = b12;
        byte b13 = bArr[(bArr[bArr[b12 & 255] & 255] + 1) & 255];
        byte b14 = bArr[b11 & 255];
        bArr[b11 & 255] = bArr[b12 & 255];
        bArr[b12 & 255] = b14;
        this.f4478n = (byte) ((b11 + 1) & 255);
        return (byte) (b9 ^ b13);
    }
}
