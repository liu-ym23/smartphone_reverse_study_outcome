package org.bouncycastle.crypto.engines;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.engines.AEADBaseEngine;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class Grain128AEADEngine extends AEADBaseEngine {
    private static final int STATE_SIZE = 4;
    private final int[] authAcc;
    private final int[] authSr;
    private final int[] lfsr;
    private final int[] nfsr;
    private byte[] workingIV;
    private byte[] workingKey;

    public Grain128AEADEngine() {
        this.algorithmName = "Grain-128 AEAD";
        this.KEY_SIZE = 16;
        this.IV_SIZE = 12;
        this.MAC_SIZE = 8;
        this.lfsr = new int[4];
        this.nfsr = new int[4];
        this.authAcc = new int[2];
        this.authSr = new int[2];
        setInnerMembers(AEADBaseEngine.ProcessingBufferType.Immediate, AEADBaseEngine.AADOperatorType.Stream, AEADBaseEngine.DataOperatorType.StreamCipher);
    }

    private void absorbAadData(byte[] bArr, int i8, int i9) {
        for (int i10 = 0; i10 < i9; i10++) {
            byte b9 = bArr[i8 + i10];
            for (int i11 = 0; i11 < 8; i11++) {
                shift();
                updateInternalState((b9 >> i11) & 1);
            }
        }
    }

    private int getByteKeyStream() {
        int output = getOutput();
        shift();
        return output;
    }

    private int getOutput() {
        int[] iArr = this.nfsr;
        int i8 = iArr[0];
        int i9 = i8 >>> 12;
        int i10 = iArr[1];
        int i11 = iArr[2];
        int i12 = i11 >>> 31;
        int[] iArr2 = this.lfsr;
        int i13 = iArr2[0];
        int i14 = iArr2[1];
        int i15 = iArr2[2];
        int i16 = (i13 >>> 20) & (i13 >>> 13);
        return (((((((((((i15 >>> 30) & (i9 & i12)) ^ (((i16 ^ ((i13 >>> 8) & i9)) ^ (i12 & (i14 >>> 10))) ^ ((i15 >>> 15) & (i14 >>> 28)))) ^ (i15 >>> 29)) ^ (i8 >>> 2)) ^ (i8 >>> 15)) ^ (i10 >>> 4)) ^ (i10 >>> 13)) ^ i11) ^ (i11 >>> 9)) ^ (i11 >>> 25)) & 1;
    }

    private int getOutputLFSR() {
        int[] iArr = this.lfsr;
        int i8 = iArr[0];
        int i9 = iArr[1] >>> 6;
        int i10 = iArr[2];
        return (iArr[3] ^ ((((i8 ^ (i8 >>> 7)) ^ i9) ^ (i10 >>> 6)) ^ (i10 >>> 17))) & 1;
    }

    private int getOutputNFSR() {
        int[] iArr = this.nfsr;
        int i8 = iArr[0];
        int i9 = i8 >>> 25;
        int i10 = iArr[1];
        int i11 = iArr[2];
        int i12 = ((i8 >>> 26) ^ i8) ^ (i10 >>> 24);
        return (((((((((((iArr[3] ^ (i12 ^ (i11 >>> 27))) ^ ((i8 & i11) >>> 3)) ^ ((i8 >>> 11) & (i8 >>> 13))) ^ ((i8 >>> 17) & (i8 >>> 18))) ^ ((i8 & i10) >>> 27)) ^ ((i10 >>> 8) & (i10 >>> 16))) ^ ((i10 >>> 29) & (i11 >>> 1))) ^ ((i11 >>> 4) & (i11 >>> 20))) ^ (((i8 >>> 22) & (i8 >>> 24)) & i9)) ^ (((i11 >>> 6) & (i11 >>> 14)) & (i11 >>> 18))) ^ ((((i11 >>> 24) & (i11 >>> 28)) & (i11 >>> 29)) & (i11 >>> 31))) & 1;
    }

    private void initGrain(int[] iArr) {
        for (int i8 = 0; i8 < 2; i8++) {
            for (int i9 = 0; i9 < 32; i9++) {
                iArr[i8] = iArr[i8] | (getByteKeyStream() << i9);
            }
        }
    }

    private void shift() {
        shift(this.nfsr, (getOutputNFSR() ^ this.lfsr[0]) & 1);
        shift(this.lfsr, getOutputLFSR() & 1);
    }

    private void updateInternalState(int i8) {
        int i9 = -i8;
        int[] iArr = this.authAcc;
        int i10 = iArr[0];
        int[] iArr2 = this.authSr;
        iArr[0] = i10 ^ (iArr2[0] & i9);
        iArr[1] = (i9 & iArr2[1]) ^ iArr[1];
        int byteKeyStream = getByteKeyStream();
        int[] iArr3 = this.authSr;
        int i11 = iArr3[0] >>> 1;
        int i12 = iArr3[1];
        iArr3[0] = i11 | (i12 << 31);
        iArr3[1] = (byteKeyStream << 31) | (i12 >>> 1);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i8) {
        return super.doFinal(bArr, i8);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void finishAAD(AEADBaseEngine.State state, boolean z) {
        finishAAD1(state);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ String getAlgorithmName() {
        return super.getAlgorithmName();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public /* bridge */ /* synthetic */ int getIVBytesSize() {
        return super.getIVBytesSize();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public /* bridge */ /* synthetic */ int getKeyBytesSize() {
        return super.getKeyBytesSize();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ byte[] getMac() {
        return super.getMac();
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int getOutputSize(int i8) {
        return super.getOutputSize(i8);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public int getUpdateOutputSize(int i8) {
        return getTotalBytesForUpdate(i8);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void init(boolean z, CipherParameters cipherParameters) {
        super.init(z, cipherParameters);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void processAADByte(byte b9) {
        super.processAADByte(b9);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void processAADBytes(byte[] bArr, int i8, int i9) {
        super.processAADBytes(bArr, i8, i9);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processBufferDecrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int len = this.dataOperator.getLen();
        for (int i10 = 0; i10 < len; i10++) {
            byte b9 = bArr[i8 + i10];
            byte byteKeyStream = 0;
            for (int i11 = 0; i11 < 8; i11++) {
                byteKeyStream = (byte) (byteKeyStream | ((((b9 >> i11) & 1) ^ getByteKeyStream()) << i11));
                updateInternalState((byteKeyStream >> i11) & 1);
            }
            bArr2[i9 + i10] = byteKeyStream;
        }
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processBufferEncrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
        int len = this.dataOperator.getLen();
        for (int i10 = 0; i10 < len; i10++) {
            byte b9 = bArr[i8 + i10];
            byte byteKeyStream = 0;
            for (int i11 = 0; i11 < 8; i11++) {
                int i12 = (b9 >> i11) & 1;
                byteKeyStream = (byte) (byteKeyStream | ((getByteKeyStream() ^ i12) << i11));
                updateInternalState(i12);
            }
            bArr2[i9 + i10] = byteKeyStream;
        }
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int processByte(byte b9, byte[] bArr, int i8) {
        return super.processByte(b9, bArr, i8);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int processBytes(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        return super.processBytes(bArr, i8, i9, bArr2, i10);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processFinalAAD() {
        int i8;
        int i9;
        int len = this.aadOperator.getLen();
        byte[] bytes = ((AEADBaseEngine.StreamAADOperator) this.aadOperator).getBytes();
        byte[] bArr = new byte[5];
        if (len < 128) {
            i9 = 4;
            bArr[4] = (byte) len;
        } else {
            int i10 = len;
            int i11 = 5;
            while (true) {
                i8 = i11 - 1;
                bArr[i8] = (byte) i10;
                i10 >>>= 8;
                if (i10 == 0) {
                    break;
                } else {
                    i11 = i8;
                }
            }
            int i12 = i11 - 2;
            bArr[i12] = (byte) ((5 - i8) | 128);
            i9 = i12;
        }
        absorbAadData(bArr, i9, 5 - i9);
        absorbAadData(bytes, 0, len);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processFinalBlock(byte[] bArr, int i8) {
        int[] iArr = this.authAcc;
        int i9 = iArr[0];
        int[] iArr2 = this.authSr;
        iArr[0] = i9 ^ iArr2[0];
        iArr[1] = iArr2[1] ^ iArr[1];
        Pack.intToLittleEndian(iArr, this.mac, 0);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    private void shift(int[] iArr, int i8) {
        int i9 = iArr[0] >>> 1;
        int i10 = iArr[1];
        iArr[0] = i9 | (i10 << 31);
        int i11 = i10 >>> 1;
        int i12 = iArr[2];
        iArr[1] = i11 | (i12 << 31);
        int i13 = iArr[3];
        iArr[2] = (i12 >>> 1) | (i13 << 31);
        iArr[3] = (i13 >>> 1) | (i8 << 31);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void init(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[16];
        this.workingIV = bArr3;
        this.workingKey = bArr;
        System.arraycopy(bArr2, 0, bArr3, 0, this.IV_SIZE);
        byte[] bArr4 = this.workingIV;
        bArr4[12] = -1;
        bArr4[13] = -1;
        bArr4[14] = -1;
        bArr4[15] = AbstractJsonLexerKt.TC_INVALID;
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void reset(boolean z) {
        super.reset(z);
        Pack.littleEndianToInt(this.workingKey, 0, this.nfsr);
        Pack.littleEndianToInt(this.workingIV, 0, this.lfsr);
        Arrays.clear(this.authAcc);
        Arrays.clear(this.authSr);
        for (int i8 = 0; i8 < 320; i8++) {
            int output = getOutput();
            shift(this.nfsr, ((getOutputNFSR() ^ this.lfsr[0]) ^ output) & 1);
            shift(this.lfsr, (output ^ getOutputLFSR()) & 1);
        }
        for (int i9 = 0; i9 < 8; i9++) {
            for (int i10 = 0; i10 < 8; i10++) {
                int output2 = getOutput();
                shift(this.nfsr, (((getOutputNFSR() ^ this.lfsr[0]) ^ output2) ^ (this.workingKey[i9] >> i10)) & 1);
                shift(this.lfsr, ((output2 ^ getOutputLFSR()) ^ (this.workingKey[i9 + 8] >> i10)) & 1);
            }
        }
        initGrain(this.authAcc);
        initGrain(this.authSr);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processBufferAAD(byte[] bArr, int i8) {
    }
}
