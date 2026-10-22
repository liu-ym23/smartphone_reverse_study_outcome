package org.bouncycastle.crypto.engines;

import m0.f;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

/* loaded from: classes.dex */
public class HC128Engine implements StreamCipher {
    private boolean initialised;
    private byte[] iv;
    private byte[] key;

    /* renamed from: p, reason: collision with root package name */
    private int[] f4458p = new int[512];

    /* renamed from: q, reason: collision with root package name */
    private int[] f4459q = new int[512];
    private int cnt = 0;
    private byte[] buf = new byte[4];
    private int idx = 0;

    private static int dim(int i8, int i9) {
        return mod512(i8 - i9);
    }

    private static int f1(int i8) {
        return (i8 >>> 3) ^ (rotateRight(i8, 7) ^ rotateRight(i8, 18));
    }

    private static int f2(int i8) {
        return (i8 >>> 10) ^ (rotateRight(i8, 17) ^ rotateRight(i8, 19));
    }

    private int g1(int i8, int i9, int i10) {
        return (rotateRight(i8, 10) ^ rotateRight(i10, 23)) + rotateRight(i9, 8);
    }

    private int g2(int i8, int i9, int i10) {
        return (rotateLeft(i8, 10) ^ rotateLeft(i10, 23)) + rotateLeft(i9, 8);
    }

    private byte getByte() {
        if (this.idx == 0) {
            int iStep = step();
            byte[] bArr = this.buf;
            bArr[0] = (byte) (iStep & 255);
            bArr[1] = (byte) ((iStep >> 8) & 255);
            bArr[2] = (byte) ((iStep >> 16) & 255);
            bArr[3] = (byte) ((iStep >> 24) & 255);
        }
        byte[] bArr2 = this.buf;
        int i8 = this.idx;
        byte b9 = bArr2[i8];
        this.idx = 3 & (i8 + 1);
        return b9;
    }

    private int h1(int i8) {
        int[] iArr = this.f4459q;
        return iArr[i8 & 255] + iArr[((i8 >> 16) & 255) + 256];
    }

    private int h2(int i8) {
        int[] iArr = this.f4458p;
        return iArr[i8 & 255] + iArr[((i8 >> 16) & 255) + 256];
    }

    private void init() {
        if (this.key.length != 16) {
            throw new IllegalArgumentException("The key must be 128 bits long");
        }
        if (this.iv.length != 16) {
            throw new IllegalArgumentException("The IV must be 128 bits long");
        }
        this.idx = 0;
        this.cnt = 0;
        int[] iArr = new int[1280];
        for (int i8 = 0; i8 < 16; i8++) {
            int i9 = i8 >> 2;
            iArr[i9] = ((this.key[i8] & 255) << ((i8 & 3) * 8)) | iArr[i9];
        }
        System.arraycopy(iArr, 0, iArr, 4, 4);
        int i10 = 0;
        while (true) {
            byte[] bArr = this.iv;
            if (i10 >= bArr.length || i10 >= 16) {
                break;
            }
            int i11 = (i10 >> 2) + 8;
            iArr[i11] = ((bArr[i10] & 255) << ((i10 & 3) * 8)) | iArr[i11];
            i10++;
        }
        System.arraycopy(iArr, 8, iArr, 12, 4);
        for (int i12 = 16; i12 < 1280; i12++) {
            iArr[i12] = f2(iArr[i12 - 2]) + iArr[i12 - 7] + f1(iArr[i12 - 15]) + iArr[i12 - 16] + i12;
        }
        System.arraycopy(iArr, 256, this.f4458p, 0, 512);
        System.arraycopy(iArr, 768, this.f4459q, 0, 512);
        for (int i13 = 0; i13 < 512; i13++) {
            this.f4458p[i13] = step();
        }
        for (int i14 = 0; i14 < 512; i14++) {
            this.f4459q[i14] = step();
        }
        this.cnt = 0;
    }

    private static int mod1024(int i8) {
        return i8 & 1023;
    }

    private static int mod512(int i8) {
        return i8 & 511;
    }

    private static int rotateLeft(int i8, int i9) {
        return (i8 >>> (-i9)) | (i8 << i9);
    }

    private static int rotateRight(int i8, int i9) {
        return (i8 << (-i9)) | (i8 >>> i9);
    }

    private int step() {
        int iH2;
        int i8;
        int iMod512 = mod512(this.cnt);
        if (this.cnt < 512) {
            int[] iArr = this.f4458p;
            iArr[iMod512] = iArr[iMod512] + g1(iArr[dim(iMod512, 3)], this.f4458p[dim(iMod512, 10)], this.f4458p[dim(iMod512, 511)]);
            iH2 = h1(this.f4458p[dim(iMod512, 12)]);
            i8 = this.f4458p[iMod512];
        } else {
            int[] iArr2 = this.f4459q;
            iArr2[iMod512] = iArr2[iMod512] + g2(iArr2[dim(iMod512, 3)], this.f4459q[dim(iMod512, 10)], this.f4459q[dim(iMod512, 511)]);
            iH2 = h2(this.f4459q[dim(iMod512, 12)]);
            i8 = this.f4459q[iMod512];
        }
        int i9 = i8 ^ iH2;
        this.cnt = mod1024(this.cnt + 1);
        return i9;
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "HC-128";
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public int processBytes(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        if (!this.initialised) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        }
        if (i8 + i9 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i10 + i9 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        for (int i11 = 0; i11 < i9; i11++) {
            bArr2[i10 + i11] = (byte) (bArr[i8 + i11] ^ getByte());
        }
        return i9;
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void reset() {
        init();
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public byte returnByte(byte b9) {
        return (byte) (getByte() ^ b9);
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof ParametersWithIV)) {
            throw new IllegalArgumentException("no IV passed");
        }
        ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
        this.iv = parametersWithIV.getIV();
        CipherParameters parameters = parametersWithIV.getParameters();
        if (!(parameters instanceof KeyParameter)) {
            throw new IllegalArgumentException(f.h(cipherParameters, "Invalid parameter passed to HC128 init - "));
        }
        this.key = ((KeyParameter) parameters).getKey();
        init();
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 128, cipherParameters, Utils.getPurpose(z)));
        this.initialised = true;
    }
}
