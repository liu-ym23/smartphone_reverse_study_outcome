package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.engines.AEADBaseEngine;
import org.bouncycastle.crypto.engines.AsconPermutationFriend;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class AsconAEAD128 extends AsconBaseEngine {
    public AsconAEAD128() {
        this.BlockSize = 16;
        this.AADBufferSize = 16;
        this.MAC_SIZE = 16;
        this.IV_SIZE = 16;
        this.KEY_SIZE = 16;
        this.ASCON_IV = 17594342703105L;
        this.algorithmName = "Ascon-AEAD128";
        this.nr = 8;
        this.dsep = Long.MIN_VALUE;
        this.macSizeLowerBound = 4;
        setInnerMembers(AEADBaseEngine.ProcessingBufferType.Immediate, AEADBaseEngine.AADOperatorType.DataLimit, AEADBaseEngine.DataOperatorType.DataLimit);
        this.dataLimitCounter.init(54);
        this.decryptionFailureCounter = new AEADBaseEngine.DecryptionFailureCounter();
    }

    private void finishData(AEADBaseEngine.State state) {
        AsconPermutationFriend.AsconPermutation asconPermutation = this.f4447p;
        asconPermutation.f4450x2 ^= this.K0;
        asconPermutation.f4451x3 ^= this.K1;
        asconPermutation.p(12);
        AsconPermutationFriend.AsconPermutation asconPermutation2 = this.f4447p;
        asconPermutation2.f4451x3 ^= this.K0;
        asconPermutation2.f4452x4 ^= this.K1;
        this.m_state = state;
    }

    @Override // org.bouncycastle.crypto.engines.AsconBaseEngine
    public void ascon_aeadinit() {
        this.f4447p.set(this.ASCON_IV, this.K0, this.K1, this.N0, this.N1);
        this.f4447p.p(12);
        AsconPermutationFriend.AsconPermutation asconPermutation = this.f4447p;
        asconPermutation.f4451x3 ^= this.K0;
        asconPermutation.f4452x4 ^= this.K1;
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i8) {
        return super.doFinal(bArr, i8);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ String getAlgorithmName() {
        return super.getAlgorithmName();
    }

    @Override // org.bouncycastle.crypto.engines.AsconBaseEngine
    public String getAlgorithmVersion() {
        return "v1.3";
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
    public /* bridge */ /* synthetic */ int getUpdateOutputSize(int i8) {
        return super.getUpdateOutputSize(i8);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void init(boolean z, CipherParameters cipherParameters) {
        super.init(z, cipherParameters);
    }

    @Override // org.bouncycastle.crypto.engines.AsconBaseEngine
    public long loadBytes(byte[] bArr, int i8) {
        return Pack.littleEndianToLong(bArr, i8);
    }

    @Override // org.bouncycastle.crypto.engines.AsconBaseEngine
    public long pad(int i8) {
        return 1 << (i8 << 3);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void processAADByte(byte b9) {
        super.processAADByte(b9);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void processAADBytes(byte[] bArr, int i8, int i9) {
        super.processAADBytes(bArr, i8, i9);
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
        if (this.m_aadPos == this.BlockSize) {
            this.f4447p.f4448x0 ^= loadBytes(this.m_aad, 0);
            this.f4447p.f4449x1 ^= loadBytes(this.m_aad, 8);
            this.m_aadPos -= this.BlockSize;
            this.f4447p.p(this.nr);
        }
        Arrays.fill(this.m_aad, this.m_aadPos, this.AADBufferSize, (byte) 0);
        if (this.m_aadPos < 8) {
            this.f4447p.f4448x0 ^= Pack.littleEndianToLong(this.m_aad, 0) ^ pad(this.m_aadPos);
            return;
        }
        this.f4447p.f4448x0 ^= Pack.littleEndianToLong(this.m_aad, 0);
        AsconPermutationFriend.AsconPermutation asconPermutation = this.f4447p;
        asconPermutation.f4449x1 = (Pack.littleEndianToLong(this.m_aad, 8) ^ pad(this.m_aadPos)) ^ asconPermutation.f4449x1;
    }

    @Override // org.bouncycastle.crypto.engines.AsconBaseEngine
    public void processFinalDecrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
        if (i8 >= 8) {
            long jLittleEndianToLong = Pack.littleEndianToLong(bArr, 0);
            int i10 = i8 - 8;
            long jLittleEndianToLong2 = Pack.littleEndianToLong(bArr, 8, i10);
            Pack.longToLittleEndian(this.f4447p.f4448x0 ^ jLittleEndianToLong, bArr2, i9);
            Pack.longToLittleEndian(this.f4447p.f4449x1 ^ jLittleEndianToLong2, bArr2, i9 + 8, i10);
            AsconPermutationFriend.AsconPermutation asconPermutation = this.f4447p;
            asconPermutation.f4448x0 = jLittleEndianToLong;
            long j4 = (asconPermutation.f4449x1 & (-(1 << (i10 << 3)))) | jLittleEndianToLong2;
            asconPermutation.f4449x1 = j4;
            asconPermutation.f4449x1 = j4 ^ pad(i10);
        } else {
            if (i8 != 0) {
                long jLittleEndianToLong3 = Pack.littleEndianToLong(bArr, 0, i8);
                Pack.longToLittleEndian(this.f4447p.f4448x0 ^ jLittleEndianToLong3, bArr2, i9, i8);
                AsconPermutationFriend.AsconPermutation asconPermutation2 = this.f4447p;
                asconPermutation2.f4448x0 = (asconPermutation2.f4448x0 & (-(1 << (i8 << 3)))) | jLittleEndianToLong3;
            }
            this.f4447p.f4448x0 ^= pad(i8);
        }
        finishData(AEADBaseEngine.State.DecFinal);
    }

    @Override // org.bouncycastle.crypto.engines.AsconBaseEngine
    public void processFinalEncrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
        if (i8 >= 8) {
            this.f4447p.f4448x0 ^= Pack.littleEndianToLong(bArr, 0);
            int i10 = i8 - 8;
            this.f4447p.f4449x1 ^= Pack.littleEndianToLong(bArr, 8, i10);
            Pack.longToLittleEndian(this.f4447p.f4448x0, bArr2, i9);
            Pack.longToLittleEndian(this.f4447p.f4449x1, bArr2, i9 + 8);
            this.f4447p.f4449x1 ^= pad(i10);
        } else {
            if (i8 != 0) {
                this.f4447p.f4448x0 ^= Pack.littleEndianToLong(bArr, 0, i8);
                Pack.longToLittleEndian(this.f4447p.f4448x0, bArr2, i9, i8);
            }
            this.f4447p.f4448x0 ^= pad(i8);
        }
        finishData(AEADBaseEngine.State.EncFinal);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    @Override // org.bouncycastle.crypto.engines.AsconBaseEngine
    public void setBytes(long j4, byte[] bArr, int i8) {
        Pack.longToLittleEndian(j4, bArr, i8);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void init(byte[] bArr, byte[] bArr2) {
        int i8 = (this.MAC_SIZE << 3) - 32;
        long jLittleEndianToLong = Pack.littleEndianToLong(bArr, 0);
        long jLittleEndianToLong2 = Pack.littleEndianToLong(bArr, 8);
        this.decryptionFailureCounter.init(i8);
        if (this.K0 != jLittleEndianToLong || this.K1 != jLittleEndianToLong2) {
            this.dataLimitCounter.reset();
            this.decryptionFailureCounter.reset();
            this.K0 = jLittleEndianToLong;
            this.K1 = jLittleEndianToLong2;
        }
        this.N0 = Pack.littleEndianToLong(bArr2, 0);
        this.N1 = Pack.littleEndianToLong(bArr2, 8);
    }
}
