package org.bouncycastle.crypto.macs;

import m0.f;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithSBox;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class GOST28147Mac implements Mac {
    private static final int BLOCK_SIZE = 8;
    private static final int MAC_SIZE = 4;
    private byte[] S;
    private byte[] buf;
    private int bufOff;
    private boolean firstStep;
    private byte[] mac;
    private byte[] macIV;
    private final CryptoServicePurpose purpose;
    private int[] workingKey;

    public GOST28147Mac() {
        this(CryptoServicePurpose.AUTHENTICATION);
    }

    private static void CM5func(byte[] bArr, int i8, byte[] bArr2, byte[] bArr3) {
        for (int i9 = 0; i9 < 8; i9++) {
            bArr3[i9] = (byte) (bArr[i8 + i9] ^ bArr2[i9]);
        }
    }

    private int[] generateWorkingKey(byte[] bArr) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Key length invalid. Key needs to be 32 byte - 256 bit!!!");
        }
        int[] iArr = new int[8];
        for (int i8 = 0; i8 != 8; i8++) {
            iArr[i8] = Pack.littleEndianToInt(bArr, i8 * 4);
        }
        return iArr;
    }

    private void gost28147MacFunc(int[] iArr, byte[] bArr, int i8, byte[] bArr2, int i9) {
        int iLittleEndianToInt = Pack.littleEndianToInt(bArr, i8);
        int iLittleEndianToInt2 = Pack.littleEndianToInt(bArr, i8 + 4);
        for (int i10 = 0; i10 < 2; i10++) {
            int i11 = 0;
            while (i11 < 8) {
                int iGost28147_mainStep = iLittleEndianToInt2 ^ gost28147_mainStep(iLittleEndianToInt, iArr[i11]);
                i11++;
                int i12 = iLittleEndianToInt;
                iLittleEndianToInt = iGost28147_mainStep;
                iLittleEndianToInt2 = i12;
            }
        }
        Pack.intToLittleEndian(iLittleEndianToInt, bArr2, i9);
        Pack.intToLittleEndian(iLittleEndianToInt2, bArr2, i9 + 4);
    }

    private int gost28147_mainStep(int i8, int i9) {
        int i10 = i9 + i8;
        byte[] bArr = this.S;
        int i11 = bArr[i10 & 15] + (bArr[((i10 >> 4) & 15) + 16] << 4) + (bArr[((i10 >> 8) & 15) + 32] << 8) + (bArr[((i10 >> 12) & 15) + 48] << 12) + (bArr[((i10 >> 16) & 15) + 64] << 16) + (bArr[((i10 >> 20) & 15) + 80] << 20) + (bArr[((i10 >> 24) & 15) + 96] << 24) + (bArr[((i10 >> 28) & 15) + 112] << 28);
        return (i11 << 11) | (i11 >>> 21);
    }

    private void recursiveInit(CipherParameters cipherParameters) {
        CipherParameters parameters;
        if (cipherParameters == null) {
            return;
        }
        if (cipherParameters instanceof ParametersWithSBox) {
            ParametersWithSBox parametersWithSBox = (ParametersWithSBox) cipherParameters;
            System.arraycopy(parametersWithSBox.getSBox(), 0, this.S, 0, parametersWithSBox.getSBox().length);
            parameters = parametersWithSBox.getParameters();
        } else if (cipherParameters instanceof KeyParameter) {
            this.workingKey = generateWorkingKey(((KeyParameter) cipherParameters).getKey());
            parameters = null;
        } else {
            if (!(cipherParameters instanceof ParametersWithIV)) {
                throw new IllegalArgumentException(f.h(cipherParameters, "invalid parameter passed to GOST28147 init - "));
            }
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv = parametersWithIV.getIV();
            byte[] bArr = this.mac;
            System.arraycopy(iv, 0, bArr, 0, bArr.length);
            this.macIV = parametersWithIV.getIV();
            parameters = parametersWithIV.getParameters();
        }
        recursiveInit(parameters);
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i8) {
        while (true) {
            int i9 = this.bufOff;
            if (i9 >= 8) {
                break;
            }
            this.buf[i9] = 0;
            this.bufOff = i9 + 1;
        }
        byte[] bArr2 = this.buf;
        byte[] bArr3 = new byte[bArr2.length];
        if (this.firstStep) {
            this.firstStep = false;
            System.arraycopy(bArr2, 0, bArr3, 0, this.mac.length);
        } else {
            CM5func(bArr2, 0, this.mac, bArr3);
        }
        gost28147MacFunc(this.workingKey, bArr3, 0, this.mac, 0);
        byte[] bArr4 = this.mac;
        System.arraycopy(bArr4, (bArr4.length / 2) - 4, bArr, i8, 4);
        reset();
        return 4;
    }

    @Override // org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        return "GOST28147Mac";
    }

    @Override // org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return 4;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) {
        reset();
        this.buf = new byte[8];
        this.macIV = null;
        recursiveInit(cipherParameters);
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 178, cipherParameters, this.purpose));
    }

    @Override // org.bouncycastle.crypto.Mac
    public void reset() {
        int i8 = 0;
        while (true) {
            byte[] bArr = this.buf;
            if (i8 >= bArr.length) {
                this.bufOff = 0;
                this.firstStep = true;
                return;
            } else {
                bArr[i8] = 0;
                i8++;
            }
        }
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte b9) {
        GOST28147Mac gOST28147Mac;
        int i8 = this.bufOff;
        byte[] bArr = this.buf;
        if (i8 == bArr.length) {
            byte[] bArr2 = new byte[bArr.length];
            if (this.firstStep) {
                this.firstStep = false;
                byte[] bArr3 = this.macIV;
                if (bArr3 != null) {
                    CM5func(bArr, 0, bArr3, bArr2);
                } else {
                    System.arraycopy(bArr, 0, bArr2, 0, this.mac.length);
                }
            } else {
                CM5func(bArr, 0, this.mac, bArr2);
            }
            gOST28147Mac = this;
            gOST28147Mac.gost28147MacFunc(this.workingKey, bArr2, 0, this.mac, 0);
            gOST28147Mac.bufOff = 0;
        } else {
            gOST28147Mac = this;
        }
        byte[] bArr4 = gOST28147Mac.buf;
        int i9 = gOST28147Mac.bufOff;
        gOST28147Mac.bufOff = i9 + 1;
        bArr4[i9] = b9;
    }

    public GOST28147Mac(CryptoServicePurpose cryptoServicePurpose) {
        this.firstStep = true;
        this.workingKey = null;
        this.macIV = null;
        this.S = new byte[]{9, 6, 3, 2, 8, 11, 1, 7, 10, 4, 14, 15, 12, 0, 13, 5, 3, 7, 14, 9, 8, 10, 15, 0, 5, 2, 6, 12, 11, 4, 13, 1, 14, 4, 6, 2, 11, 3, 13, 8, 12, 15, 5, 10, 0, 7, 1, 9, 14, 7, 10, 12, 13, 1, 3, 9, 0, 2, 11, 4, 15, 8, 5, 6, 11, 5, 1, 9, 8, 13, 15, 0, 14, 4, 2, 3, 12, 7, 10, 6, 3, 10, 13, 12, 1, 2, 0, 11, 7, 5, 9, 4, 8, 15, 14, 6, 1, 13, 2, 9, 7, 10, 6, 0, 8, 12, 4, 5, 15, 3, 11, 14, 11, 10, 15, 5, 0, 12, 14, 8, 6, 2, 3, 9, 1, 7, 13, 4};
        this.purpose = cryptoServicePurpose;
        this.mac = new byte[8];
        this.buf = new byte[8];
        this.bufOff = 0;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte[] bArr, int i8, int i9) {
        GOST28147Mac gOST28147Mac;
        if (i9 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int i10 = this.bufOff;
        int i11 = 8 - i10;
        if (i9 > i11) {
            System.arraycopy(bArr, i8, this.buf, i10, i11);
            byte[] bArr2 = this.buf;
            byte[] bArr3 = new byte[bArr2.length];
            if (this.firstStep) {
                this.firstStep = false;
                byte[] bArr4 = this.macIV;
                if (bArr4 != null) {
                    CM5func(bArr2, 0, bArr4, bArr3);
                } else {
                    System.arraycopy(bArr2, 0, bArr3, 0, this.mac.length);
                }
            } else {
                CM5func(bArr2, 0, this.mac, bArr3);
            }
            gOST28147Mac = this;
            gOST28147Mac.gost28147MacFunc(this.workingKey, bArr3, 0, this.mac, 0);
            gOST28147Mac.bufOff = 0;
            i9 -= i11;
            i8 += i11;
            while (i9 > 8) {
                CM5func(bArr, i8, gOST28147Mac.mac, bArr3);
                gOST28147Mac.gost28147MacFunc(gOST28147Mac.workingKey, bArr3, 0, gOST28147Mac.mac, 0);
                i9 -= 8;
                i8 += 8;
            }
        } else {
            gOST28147Mac = this;
        }
        System.arraycopy(bArr, i8, gOST28147Mac.buf, gOST28147Mac.bufOff, i9);
        gOST28147Mac.bufOff += i9;
    }
}
