package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.engines.AEADBaseEngine;
import org.bouncycastle.crypto.engines.AsconPermutationFriend;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class AsconEngine extends AsconBaseEngine {
    private long K2;
    private final AsconParameters asconParameters;

    public enum AsconParameters {
        ascon80pq,
        ascon128a,
        ascon128
    }

    public AsconEngine(AsconParameters asconParameters) {
        String str;
        this.asconParameters = asconParameters;
        this.MAC_SIZE = 16;
        this.IV_SIZE = 16;
        int iOrdinal = asconParameters.ordinal();
        if (iOrdinal == 0) {
            this.KEY_SIZE = 20;
            this.BlockSize = 8;
            this.ASCON_IV = -6899501409222262784L;
            str = "Ascon-80pq AEAD";
        } else if (iOrdinal == 1) {
            this.KEY_SIZE = 16;
            this.BlockSize = 16;
            this.ASCON_IV = -9187330011336540160L;
            str = "Ascon-128a AEAD";
        } else {
            if (iOrdinal != 2) {
                throw new IllegalArgumentException("invalid parameter setting for ASCON AEAD");
            }
            this.KEY_SIZE = 16;
            this.BlockSize = 8;
            this.ASCON_IV = -9205344418435956736L;
            str = "Ascon-128 AEAD";
        }
        this.algorithmName = str;
        int i8 = this.BlockSize;
        this.nr = i8 == 8 ? 6 : 8;
        this.AADBufferSize = i8;
        this.dsep = 1L;
        setInnerMembers(AEADBaseEngine.ProcessingBufferType.Immediate, AEADBaseEngine.AADOperatorType.Default, AEADBaseEngine.DataOperatorType.Default);
    }

    @Override // org.bouncycastle.crypto.engines.AsconBaseEngine
    public void ascon_aeadinit() {
        this.f4447p.set(this.ASCON_IV, this.K1, this.K2, this.N0, this.N1);
        if (this.KEY_SIZE == 20) {
            this.f4447p.f4448x0 ^= this.K0;
        }
        this.f4447p.p(12);
        if (this.KEY_SIZE == 20) {
            this.f4447p.f4450x2 ^= this.K0;
        }
        AsconPermutationFriend.AsconPermutation asconPermutation = this.f4447p;
        asconPermutation.f4451x3 ^= this.K1;
        asconPermutation.f4452x4 ^= this.K2;
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i8) {
        return super.doFinal(bArr, i8);
    }

    public void finishData(AEADBaseEngine.State state) {
        AsconPermutationFriend.AsconPermutation asconPermutation;
        long j4;
        long j8;
        int iOrdinal = this.asconParameters.ordinal();
        if (iOrdinal == 0) {
            asconPermutation = this.f4447p;
            long j9 = asconPermutation.f4449x1;
            long j10 = this.K0 << 32;
            long j11 = this.K1;
            asconPermutation.f4449x1 = j9 ^ (j10 | (j11 >> 32));
            long j12 = asconPermutation.f4450x2;
            long j13 = j11 << 32;
            long j14 = this.K2;
            asconPermutation.f4450x2 = j12 ^ (j13 | (j14 >> 32));
            j4 = asconPermutation.f4451x3;
            j8 = j14 << 32;
        } else {
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    throw new IllegalStateException();
                }
                AsconPermutationFriend.AsconPermutation asconPermutation2 = this.f4447p;
                asconPermutation2.f4449x1 ^= this.K1;
                asconPermutation2.f4450x2 ^= this.K2;
                this.f4447p.p(12);
                AsconPermutationFriend.AsconPermutation asconPermutation3 = this.f4447p;
                asconPermutation3.f4451x3 ^= this.K1;
                asconPermutation3.f4452x4 ^= this.K2;
                this.m_state = state;
            }
            asconPermutation = this.f4447p;
            asconPermutation.f4450x2 ^= this.K1;
            j4 = asconPermutation.f4451x3;
            j8 = this.K2;
        }
        asconPermutation.f4451x3 = j4 ^ j8;
        this.f4447p.p(12);
        AsconPermutationFriend.AsconPermutation asconPermutation32 = this.f4447p;
        asconPermutation32.f4451x3 ^= this.K1;
        asconPermutation32.f4452x4 ^= this.K2;
        this.m_state = state;
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ String getAlgorithmName() {
        return super.getAlgorithmName();
    }

    @Override // org.bouncycastle.crypto.engines.AsconBaseEngine
    public String getAlgorithmVersion() {
        return "v1.2";
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
        return Pack.bigEndianToLong(bArr, i8);
    }

    @Override // org.bouncycastle.crypto.engines.AsconBaseEngine
    public long pad(int i8) {
        return 128 << (56 - (i8 << 3));
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
        byte[] bArr = this.m_aad;
        int i8 = this.m_aadPos;
        bArr[i8] = -128;
        if (i8 < 8) {
            AsconPermutationFriend.AsconPermutation asconPermutation = this.f4447p;
            asconPermutation.f4448x0 = (((-1) << (56 - (this.m_aadPos << 3))) & Pack.bigEndianToLong(bArr, 0)) ^ asconPermutation.f4448x0;
            return;
        }
        this.f4447p.f4448x0 ^= Pack.bigEndianToLong(bArr, 0);
        AsconPermutationFriend.AsconPermutation asconPermutation2 = this.f4447p;
        asconPermutation2.f4449x1 = (((-1) << (56 - ((this.m_aadPos - 8) << 3))) & Pack.bigEndianToLong(this.m_aad, 8)) ^ asconPermutation2.f4449x1;
    }

    @Override // org.bouncycastle.crypto.engines.AsconBaseEngine
    public void processFinalDecrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
        if (i8 >= 8) {
            long jBigEndianToLong = Pack.bigEndianToLong(bArr, 0);
            AsconPermutationFriend.AsconPermutation asconPermutation = this.f4447p;
            long j4 = asconPermutation.f4448x0 ^ jBigEndianToLong;
            asconPermutation.f4448x0 = j4;
            Pack.longToBigEndian(j4, bArr2, i9);
            AsconPermutationFriend.AsconPermutation asconPermutation2 = this.f4447p;
            asconPermutation2.f4448x0 = jBigEndianToLong;
            int i10 = i9 + 8;
            int i11 = i8 - 8;
            asconPermutation2.f4449x1 ^= pad(i11);
            if (i11 != 0) {
                long jLittleEndianToLong_High = Pack.littleEndianToLong_High(bArr, 8, i11);
                AsconPermutationFriend.AsconPermutation asconPermutation3 = this.f4447p;
                long j8 = asconPermutation3.f4449x1 ^ jLittleEndianToLong_High;
                asconPermutation3.f4449x1 = j8;
                Pack.longToLittleEndian_High(j8, bArr2, i10, i11);
                AsconPermutationFriend.AsconPermutation asconPermutation4 = this.f4447p;
                asconPermutation4.f4449x1 = (asconPermutation4.f4449x1 & ((-1) >>> (i11 << 3))) ^ jLittleEndianToLong_High;
            }
        } else {
            this.f4447p.f4448x0 ^= pad(i8);
            if (i8 != 0) {
                long jLittleEndianToLong_High2 = Pack.littleEndianToLong_High(bArr, 0, i8);
                AsconPermutationFriend.AsconPermutation asconPermutation5 = this.f4447p;
                long j9 = asconPermutation5.f4448x0 ^ jLittleEndianToLong_High2;
                asconPermutation5.f4448x0 = j9;
                Pack.longToLittleEndian_High(j9, bArr2, i9, i8);
                AsconPermutationFriend.AsconPermutation asconPermutation6 = this.f4447p;
                asconPermutation6.f4448x0 = (asconPermutation6.f4448x0 & ((-1) >>> (i8 << 3))) ^ jLittleEndianToLong_High2;
            }
        }
        finishData(AEADBaseEngine.State.DecFinal);
    }

    @Override // org.bouncycastle.crypto.engines.AsconBaseEngine
    public void processFinalEncrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
        long j4;
        if (i8 >= 8) {
            this.f4447p.f4448x0 ^= Pack.bigEndianToLong(bArr, 0);
            Pack.longToBigEndian(this.f4447p.f4448x0, bArr2, i9);
            i9 += 8;
            i8 -= 8;
            this.f4447p.f4449x1 ^= pad(i8);
            if (i8 != 0) {
                this.f4447p.f4449x1 ^= Pack.littleEndianToLong_High(bArr, 8, i8);
                j4 = this.f4447p.f4449x1;
                Pack.longToLittleEndian_High(j4, bArr2, i9, i8);
            }
        } else {
            this.f4447p.f4448x0 ^= pad(i8);
            if (i8 != 0) {
                this.f4447p.f4448x0 ^= Pack.littleEndianToLong_High(bArr, 0, i8);
                j4 = this.f4447p.f4448x0;
                Pack.longToLittleEndian_High(j4, bArr2, i9, i8);
            }
        }
        finishData(AEADBaseEngine.State.EncFinal);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    @Override // org.bouncycastle.crypto.engines.AsconBaseEngine
    public void setBytes(long j4, byte[] bArr, int i8) {
        Pack.longToBigEndian(j4, bArr, i8);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void init(byte[] bArr, byte[] bArr2) {
        long jBigEndianToLong;
        this.N0 = Pack.bigEndianToLong(bArr2, 0);
        this.N1 = Pack.bigEndianToLong(bArr2, 8);
        int i8 = this.KEY_SIZE;
        if (i8 == 16) {
            this.K1 = Pack.bigEndianToLong(bArr, 0);
            jBigEndianToLong = Pack.bigEndianToLong(bArr, 8);
        } else {
            if (i8 != 20) {
                throw new IllegalStateException();
            }
            this.K0 = Pack.bigEndianToInt(bArr, 0);
            this.K1 = Pack.bigEndianToLong(bArr, 4);
            jBigEndianToLong = Pack.bigEndianToLong(bArr, 12);
        }
        this.K2 = jBigEndianToLong;
    }
}
