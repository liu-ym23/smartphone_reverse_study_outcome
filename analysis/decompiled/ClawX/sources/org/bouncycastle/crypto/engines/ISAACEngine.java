package org.bouncycastle.crypto.engines;

import m0.f;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class ISAACEngine implements StreamCipher {
    private final int sizeL = 8;
    private final int stateArraySize = 256;
    private int[] engineState = null;
    private int[] results = null;

    /* renamed from: a, reason: collision with root package name */
    private int f4462a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f4463b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f4464c = 0;
    private int index = 0;
    private byte[] keyStream = new byte[1024];
    private byte[] workingKey = null;
    private boolean initialised = false;

    private void isaac() {
        int i8;
        int i9;
        int i10 = this.f4463b;
        int i11 = this.f4464c + 1;
        this.f4464c = i11;
        this.f4463b = i10 + i11;
        for (int i12 = 0; i12 < 256; i12++) {
            int[] iArr = this.engineState;
            int i13 = iArr[i12];
            int i14 = i12 & 3;
            if (i14 == 0) {
                i8 = this.f4462a;
                i9 = i8 << 13;
            } else if (i14 == 1) {
                i8 = this.f4462a;
                i9 = i8 >>> 6;
            } else if (i14 == 2) {
                i8 = this.f4462a;
                i9 = i8 << 2;
            } else if (i14 != 3) {
                int i15 = this.f4462a + iArr[(i12 + 128) & 255];
                this.f4462a = i15;
                int i16 = iArr[(i13 >>> 2) & 255] + i15 + this.f4463b;
                iArr[i12] = i16;
                int[] iArr2 = this.results;
                int i17 = iArr[(i16 >>> 10) & 255] + i13;
                this.f4463b = i17;
                iArr2[i12] = i17;
            } else {
                i8 = this.f4462a;
                i9 = i8 >>> 16;
            }
            this.f4462a = i8 ^ i9;
            int i152 = this.f4462a + iArr[(i12 + 128) & 255];
            this.f4462a = i152;
            int i162 = iArr[(i13 >>> 2) & 255] + i152 + this.f4463b;
            iArr[i12] = i162;
            int[] iArr22 = this.results;
            int i172 = iArr[(i162 >>> 10) & 255] + i13;
            this.f4463b = i172;
            iArr22[i12] = i172;
        }
    }

    private void mix(int[] iArr) {
        int i8 = iArr[0];
        int i9 = iArr[1];
        int i10 = i8 ^ (i9 << 11);
        iArr[0] = i10;
        int i11 = iArr[3] + i10;
        iArr[3] = i11;
        int i12 = iArr[2];
        int i13 = i9 + i12;
        iArr[1] = i13;
        int i14 = i13 ^ (i12 >>> 2);
        iArr[1] = i14;
        int i15 = iArr[4] + i14;
        iArr[4] = i15;
        int i16 = i12 + i11;
        iArr[2] = i16;
        int i17 = i16 ^ (i11 << 8);
        iArr[2] = i17;
        int i18 = iArr[5] + i17;
        iArr[5] = i18;
        int i19 = i11 + i15;
        iArr[3] = i19;
        int i20 = i19 ^ (i15 >>> 16);
        iArr[3] = i20;
        int i21 = iArr[6] + i20;
        iArr[6] = i21;
        int i22 = i15 + i18;
        iArr[4] = i22;
        int i23 = (i18 << 10) ^ i22;
        iArr[4] = i23;
        int i24 = iArr[7] + i23;
        iArr[7] = i24;
        int i25 = i18 + i21;
        iArr[5] = i25;
        int i26 = (i21 >>> 4) ^ i25;
        iArr[5] = i26;
        int i27 = i10 + i26;
        iArr[0] = i27;
        int i28 = i21 + i24;
        iArr[6] = i28;
        int i29 = (i24 << 8) ^ i28;
        iArr[6] = i29;
        int i30 = i14 + i29;
        iArr[1] = i30;
        int i31 = i24 + i27;
        iArr[7] = i31;
        int i32 = (i27 >>> 9) ^ i31;
        iArr[7] = i32;
        iArr[2] = i17 + i32;
        iArr[0] = i27 + i30;
    }

    private void setKey(byte[] bArr) {
        this.workingKey = bArr;
        if (this.engineState == null) {
            this.engineState = new int[256];
        }
        if (this.results == null) {
            this.results = new int[256];
        }
        for (int i8 = 0; i8 < 256; i8++) {
            int[] iArr = this.engineState;
            this.results[i8] = 0;
            iArr[i8] = 0;
        }
        this.f4464c = 0;
        this.f4463b = 0;
        this.f4462a = 0;
        this.index = 0;
        int length = bArr.length + (bArr.length & 3);
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        for (int i9 = 0; i9 < length; i9 += 4) {
            this.results[i9 >>> 2] = Pack.littleEndianToInt(bArr2, i9);
        }
        int[] iArr2 = new int[8];
        for (int i10 = 0; i10 < 8; i10++) {
            iArr2[i10] = -1640531527;
        }
        for (int i11 = 0; i11 < 4; i11++) {
            mix(iArr2);
        }
        int i12 = 0;
        while (i12 < 2) {
            for (int i13 = 0; i13 < 256; i13 += 8) {
                for (int i14 = 0; i14 < 8; i14++) {
                    iArr2[i14] = iArr2[i14] + (i12 < 1 ? this.results[i13 + i14] : this.engineState[i13 + i14]);
                }
                mix(iArr2);
                for (int i15 = 0; i15 < 8; i15++) {
                    this.engineState[i13 + i15] = iArr2[i15];
                }
            }
            i12++;
        }
        isaac();
        this.initialised = true;
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public String getAlgorithmName() {
        return "ISAAC";
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException(f.h(cipherParameters, "invalid parameter passed to ISAAC init - "));
        }
        byte[] key = ((KeyParameter) cipherParameters).getKey();
        setKey(key);
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), key.length < 32 ? key.length * 8 : 256, cipherParameters, Utils.getPurpose(z)));
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
            if (this.index == 0) {
                isaac();
                this.keyStream = Pack.intToBigEndian(this.results);
            }
            byte[] bArr3 = this.keyStream;
            int i12 = this.index;
            bArr2[i11 + i10] = (byte) (bArr3[i12] ^ bArr[i11 + i8]);
            this.index = (i12 + 1) & 1023;
        }
        return i9;
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public void reset() {
        setKey(this.workingKey);
    }

    @Override // org.bouncycastle.crypto.StreamCipher
    public byte returnByte(byte b9) {
        if (this.index == 0) {
            isaac();
            this.keyStream = Pack.intToBigEndian(this.results);
        }
        byte[] bArr = this.keyStream;
        int i8 = this.index;
        byte b10 = (byte) (b9 ^ bArr[i8]);
        this.index = (i8 + 1) & 1023;
        return b10;
    }
}
