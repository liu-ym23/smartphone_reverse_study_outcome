package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.CryptoServicePurpose;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* loaded from: classes.dex */
public class ParallelHash implements Xof, Digest {
    private static final byte[] N_PARALLEL_HASH = Strings.toByteArray("ParallelHash");
    private final int B;
    private final int bitLength;
    private int bufOff;
    private final byte[] buffer;
    private final CSHAKEDigest compressor;
    private final byte[] compressorBuffer;
    private final CSHAKEDigest cshake;
    private boolean firstOutput;
    private int nCount;
    private final int outputLength;
    private final CryptoServicePurpose purpose;

    public ParallelHash(int i8, byte[] bArr, int i9) {
        this(i8, bArr, i9, i8 * 2, CryptoServicePurpose.ANY);
    }

    private void compress() {
        compress(this.buffer, 0, this.bufOff);
        this.bufOff = 0;
    }

    private void wrapUp(int i8) {
        if (this.bufOff != 0) {
            compress();
        }
        byte[] bArrRightEncode = XofUtils.rightEncode(this.nCount);
        byte[] bArrRightEncode2 = XofUtils.rightEncode(i8 * 8);
        this.cshake.update(bArrRightEncode, 0, bArrRightEncode.length);
        this.cshake.update(bArrRightEncode2, 0, bArrRightEncode2.length);
        this.firstOutput = false;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i8) {
        if (this.firstOutput) {
            wrapUp(this.outputLength);
        }
        int iDoFinal = this.cshake.doFinal(bArr, i8, getDigestSize());
        reset();
        return iDoFinal;
    }

    @Override // org.bouncycastle.crypto.Xof
    public int doOutput(byte[] bArr, int i8, int i9) {
        if (this.firstOutput) {
            wrapUp(0);
        }
        return this.cshake.doOutput(bArr, i8, i9);
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "ParallelHash" + this.cshake.getAlgorithmName().substring(6);
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return this.cshake.getByteLength();
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return this.outputLength;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this.cshake.reset();
        Arrays.clear(this.buffer);
        byte[] bArrLeftEncode = XofUtils.leftEncode(this.B);
        this.cshake.update(bArrLeftEncode, 0, bArrLeftEncode.length);
        this.nCount = 0;
        this.bufOff = 0;
        this.firstOutput = true;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte b9) {
        byte[] bArr = this.buffer;
        int i8 = this.bufOff;
        int i9 = i8 + 1;
        this.bufOff = i9;
        bArr[i8] = b9;
        if (i9 == bArr.length) {
            compress();
        }
    }

    public ParallelHash(int i8, byte[] bArr, int i9, int i10) {
        this(i8, bArr, i9, i10, CryptoServicePurpose.ANY);
    }

    private void compress(byte[] bArr, int i8, int i9) {
        this.compressor.update(bArr, i8, i9);
        CSHAKEDigest cSHAKEDigest = this.compressor;
        byte[] bArr2 = this.compressorBuffer;
        cSHAKEDigest.doFinal(bArr2, 0, bArr2.length);
        CSHAKEDigest cSHAKEDigest2 = this.cshake;
        byte[] bArr3 = this.compressorBuffer;
        cSHAKEDigest2.update(bArr3, 0, bArr3.length);
        this.nCount++;
    }

    @Override // org.bouncycastle.crypto.Xof
    public int doFinal(byte[] bArr, int i8, int i9) {
        if (this.firstOutput) {
            wrapUp(this.outputLength);
        }
        int iDoFinal = this.cshake.doFinal(bArr, i8, i9);
        reset();
        return iDoFinal;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] bArr, int i8, int i9) {
        int i10 = 0;
        int iMax = Math.max(0, i9);
        if (this.bufOff != 0) {
            while (i10 < iMax) {
                int i11 = this.bufOff;
                byte[] bArr2 = this.buffer;
                if (i11 == bArr2.length) {
                    break;
                }
                this.bufOff = i11 + 1;
                bArr2[i11] = bArr[i10 + i8];
                i10++;
            }
            if (this.bufOff == this.buffer.length) {
                compress();
            }
        }
        if (i10 < iMax) {
            while (true) {
                int i12 = iMax - i10;
                int i13 = this.B;
                if (i12 < i13) {
                    break;
                }
                compress(bArr, i8 + i10, i13);
                i10 += this.B;
            }
        }
        while (i10 < iMax) {
            update(bArr[i10 + i8]);
            i10++;
        }
    }

    public ParallelHash(int i8, byte[] bArr, int i9, int i10, CryptoServicePurpose cryptoServicePurpose) {
        if (i9 <= 0) {
            throw new IllegalArgumentException("block size should be greater than 0");
        }
        this.cshake = new CSHAKEDigest(i8, N_PARALLEL_HASH, bArr);
        this.compressor = new CSHAKEDigest(i8, new byte[0], new byte[0]);
        this.bitLength = i8;
        this.B = i9;
        this.outputLength = (i10 + 7) / 8;
        this.buffer = new byte[i9];
        this.compressorBuffer = new byte[(i8 * 2) / 8];
        this.purpose = cryptoServicePurpose;
        CryptoServicesRegistrar.checkConstraints(Utils.getDefaultProperties(this, i8, cryptoServicePurpose));
        reset();
    }

    public ParallelHash(ParallelHash parallelHash) {
        this.cshake = new CSHAKEDigest(parallelHash.cshake);
        this.compressor = new CSHAKEDigest(parallelHash.compressor);
        int i8 = parallelHash.bitLength;
        this.bitLength = i8;
        this.B = parallelHash.B;
        this.outputLength = parallelHash.outputLength;
        this.buffer = Arrays.clone(parallelHash.buffer);
        this.compressorBuffer = Arrays.clone(parallelHash.compressorBuffer);
        CryptoServicePurpose cryptoServicePurpose = parallelHash.purpose;
        this.purpose = cryptoServicePurpose;
        this.firstOutput = parallelHash.firstOutput;
        this.nCount = parallelHash.nCount;
        this.bufOff = parallelHash.bufOff;
        CryptoServicesRegistrar.checkConstraints(Utils.getDefaultProperties(this, i8, cryptoServicePurpose));
    }
}
