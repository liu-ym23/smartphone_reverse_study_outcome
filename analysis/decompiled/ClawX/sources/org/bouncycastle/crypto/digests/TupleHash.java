package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.SavableDigest;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.Strings;

/* loaded from: classes.dex */
public class TupleHash implements Xof, SavableDigest {
    private static final byte[] N_TUPLE_HASH = Strings.toByteArray("TupleHash");
    private int bitLength;
    private final CSHAKEDigest cshake;
    private boolean firstOutput;
    private int outputLength;

    public TupleHash(int i8, byte[] bArr) {
        this(i8, bArr, i8 * 2);
    }

    private void copyIn(TupleHash tupleHash) {
        this.cshake.reset(tupleHash.cshake);
        int i8 = this.cshake.fixedOutputLength;
        this.bitLength = i8;
        this.outputLength = (i8 * 2) / 8;
        this.firstOutput = tupleHash.firstOutput;
    }

    private void wrapUp(int i8) {
        byte[] bArrRightEncode = XofUtils.rightEncode(i8 * 8);
        this.cshake.update(bArrRightEncode, 0, bArrRightEncode.length);
        this.firstOutput = false;
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new TupleHash(this);
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i8) {
        if (this.firstOutput) {
            wrapUp(getDigestSize());
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
        return "TupleHash" + this.cshake.getAlgorithmName().substring(6);
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return this.cshake.getByteLength();
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return this.outputLength;
    }

    @Override // org.bouncycastle.crypto.digests.EncodableDigest, org.bouncycastle.crypto.EncodableService
    public byte[] getEncodedState() {
        byte[] encodedState = this.cshake.getEncodedState();
        byte[] bArr = new byte[9];
        Pack.intToBigEndian(this.bitLength, bArr, 0);
        Pack.intToBigEndian(this.outputLength, bArr, 4);
        bArr[8] = this.firstOutput;
        return Arrays.concatenate(encodedState, bArr);
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this.cshake.reset();
        this.firstOutput = true;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte b9) {
        byte[] bArrEncode = XofUtils.encode(b9);
        this.cshake.update(bArrEncode, 0, bArrEncode.length);
    }

    public TupleHash(int i8, byte[] bArr, int i9) {
        this.cshake = new CSHAKEDigest(i8, N_TUPLE_HASH, bArr);
        this.bitLength = i8;
        this.outputLength = (i9 + 7) / 8;
        reset();
    }

    @Override // org.bouncycastle.crypto.Xof
    public int doFinal(byte[] bArr, int i8, int i9) {
        if (this.firstOutput) {
            wrapUp(getDigestSize());
        }
        int iDoFinal = this.cshake.doFinal(bArr, i8, i9);
        reset();
        return iDoFinal;
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable memoable) {
        copyIn((TupleHash) memoable);
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] bArr, int i8, int i9) {
        byte[] bArrEncode = XofUtils.encode(bArr, i8, i9);
        this.cshake.update(bArrEncode, 0, bArrEncode.length);
    }

    public TupleHash(TupleHash tupleHash) {
        this.cshake = new CSHAKEDigest(tupleHash.cshake);
        this.bitLength = tupleHash.bitLength;
        this.outputLength = tupleHash.outputLength;
        this.firstOutput = tupleHash.firstOutput;
    }

    public TupleHash(byte[] bArr) {
        this.cshake = new CSHAKEDigest(Arrays.copyOfRange(bArr, 0, bArr.length - 9));
        this.bitLength = Pack.bigEndianToInt(bArr, bArr.length - 9);
        this.outputLength = Pack.bigEndianToInt(bArr, bArr.length - 5);
        this.firstOutput = bArr[bArr.length - 1] != 0;
    }
}
