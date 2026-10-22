package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.Xof;
import org.bouncycastle.crypto.digests.CSHAKEDigest;
import org.bouncycastle.crypto.digests.EncodableDigest;
import org.bouncycastle.crypto.digests.XofUtils;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.Strings;

/* loaded from: classes.dex */
public class KMAC implements Mac, Xof, Memoable, EncodableDigest {
    private static final byte[] padding = new byte[100];
    private int bitLength;
    private final CSHAKEDigest cshake;
    private boolean firstOutput;
    private boolean initialised;
    private byte[] key;
    private int outputLength;

    public KMAC(int i8, byte[] bArr) {
        this.cshake = new CSHAKEDigest(i8, Strings.toByteArray("KMAC"), bArr);
        this.bitLength = i8;
        this.outputLength = (i8 * 2) / 8;
    }

    private void bytePad(byte[] bArr, int i8) {
        byte[] bArrLeftEncode = XofUtils.leftEncode(i8);
        update(bArrLeftEncode, 0, bArrLeftEncode.length);
        byte[] bArrEncode = encode(bArr);
        update(bArrEncode, 0, bArrEncode.length);
        int length = i8 - ((bArrLeftEncode.length + bArrEncode.length) % i8);
        if (length <= 0 || length == i8) {
            return;
        }
        while (true) {
            byte[] bArr2 = padding;
            if (length <= bArr2.length) {
                update(bArr2, 0, length);
                return;
            } else {
                update(bArr2, 0, bArr2.length);
                length -= bArr2.length;
            }
        }
    }

    private void copyIn(KMAC kmac) {
        this.cshake.reset(kmac.cshake);
        this.bitLength = kmac.bitLength;
        this.outputLength = kmac.outputLength;
        this.initialised = kmac.initialised;
        this.firstOutput = kmac.firstOutput;
    }

    private static byte[] encode(byte[] bArr) {
        return Arrays.concatenate(XofUtils.leftEncode(bArr.length * 8), bArr);
    }

    @Override // org.bouncycastle.util.Memoable
    public Memoable copy() {
        return new KMAC(this);
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i8) {
        if (this.firstOutput) {
            if (!this.initialised) {
                throw new IllegalStateException("KMAC not initialized");
            }
            byte[] bArrRightEncode = XofUtils.rightEncode(getMacSize() * 8);
            this.cshake.update(bArrRightEncode, 0, bArrRightEncode.length);
        }
        int iDoFinal = this.cshake.doFinal(bArr, i8, getMacSize());
        reset();
        return iDoFinal;
    }

    @Override // org.bouncycastle.crypto.Xof
    public int doOutput(byte[] bArr, int i8, int i9) {
        if (this.firstOutput) {
            if (!this.initialised) {
                throw new IllegalStateException("KMAC not initialized");
            }
            byte[] bArrRightEncode = XofUtils.rightEncode(0L);
            this.cshake.update(bArrRightEncode, 0, bArrRightEncode.length);
            this.firstOutput = false;
        }
        return this.cshake.doOutput(bArr, i8, i9);
    }

    @Override // org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        return "KMAC" + this.cshake.getAlgorithmName().substring(6);
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
        if (!this.initialised) {
            throw new IllegalStateException("KMAC not initialised");
        }
        byte[] encodedState = this.cshake.getEncodedState();
        byte[] bArr = new byte[10];
        Pack.intToBigEndian(this.bitLength, bArr, 0);
        Pack.intToBigEndian(this.outputLength, bArr, 4);
        bArr[8] = this.initialised;
        bArr[9] = this.firstOutput;
        byte[] bArr2 = this.key;
        byte[] bArr3 = new byte[bArr2.length + 1 + encodedState.length + 10];
        bArr3[0] = (byte) bArr2.length;
        System.arraycopy(bArr2, 0, bArr3, 1, bArr2.length);
        System.arraycopy(encodedState, 0, bArr3, this.key.length + 1, encodedState.length);
        System.arraycopy(bArr, 0, bArr3, this.key.length + 1 + encodedState.length, 10);
        return bArr3;
    }

    @Override // org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return this.outputLength;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) {
        byte[] bArrClone = Arrays.clone(((KeyParameter) cipherParameters).getKey());
        this.key = bArrClone;
        if (bArrClone.length > 255) {
            throw new IllegalArgumentException("key length must be between 0 and 2040 bits");
        }
        this.initialised = true;
        reset();
    }

    @Override // org.bouncycastle.crypto.Mac
    public void reset() {
        this.cshake.reset();
        byte[] bArr = this.key;
        if (bArr != null) {
            bytePad(bArr, this.bitLength == 128 ? 168 : 136);
        }
        this.firstOutput = true;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte b9) {
        if (!this.initialised) {
            throw new IllegalStateException("KMAC not initialized");
        }
        this.cshake.update(b9);
    }

    public KMAC(KMAC kmac) {
        this.cshake = new CSHAKEDigest(kmac.cshake);
        this.bitLength = kmac.bitLength;
        this.outputLength = kmac.outputLength;
        this.key = kmac.key;
        this.initialised = kmac.initialised;
        this.firstOutput = kmac.firstOutput;
    }

    @Override // org.bouncycastle.crypto.Xof
    public int doFinal(byte[] bArr, int i8, int i9) {
        if (this.firstOutput) {
            if (!this.initialised) {
                throw new IllegalStateException("KMAC not initialized");
            }
            byte[] bArrRightEncode = XofUtils.rightEncode(i9 * 8);
            this.cshake.update(bArrRightEncode, 0, bArrRightEncode.length);
        }
        int iDoFinal = this.cshake.doFinal(bArr, i8, i9);
        reset();
        return iDoFinal;
    }

    @Override // org.bouncycastle.util.Memoable
    public void reset(Memoable memoable) {
        copyIn((KMAC) memoable);
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte[] bArr, int i8, int i9) {
        if (!this.initialised) {
            throw new IllegalStateException("KMAC not initialized");
        }
        this.cshake.update(bArr, i8, i9);
    }

    public KMAC(byte[] bArr) {
        byte[] bArr2 = new byte[bArr[0] & 255];
        this.key = bArr2;
        System.arraycopy(bArr, 1, bArr2, 0, bArr2.length);
        this.cshake = new CSHAKEDigest(Arrays.copyOfRange(bArr, this.key.length + 1, bArr.length - 10));
        this.bitLength = Pack.bigEndianToInt(bArr, bArr.length - 10);
        this.outputLength = Pack.bigEndianToInt(bArr, bArr.length - 6);
        this.initialised = bArr[bArr.length + (-2)] != 0;
        this.firstOutput = bArr[bArr.length - 1] != 0;
    }
}
