package org.bouncycastle.crypto.engines;

/* loaded from: classes.dex */
public class VMPCKSA3Engine extends VMPCEngine {
    @Override // org.bouncycastle.crypto.engines.VMPCEngine, org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "VMPC-KSA3";
    }

    @Override // org.bouncycastle.crypto.engines.VMPCEngine
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
        for (int i13 = 0; i13 < 768; i13++) {
            byte[] bArr5 = this.P;
            byte b15 = this.f4479s;
            int i14 = i13 & 255;
            byte b16 = bArr5[i14];
            byte b17 = bArr5[(b15 + b16 + bArr[i13 % bArr.length]) & 255];
            this.f4479s = b17;
            bArr5[i14] = bArr5[b17 & 255];
            bArr5[b17 & 255] = b16;
        }
        this.f4478n = (byte) 0;
    }
}
