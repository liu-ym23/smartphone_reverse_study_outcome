package org.bouncycastle.crypto.digests;

import java.lang.reflect.Array;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class Blake2bpDigest implements ExtendedDigest {
    private int depth;
    private int digestLength;
    private int fanout;
    private long innerHashLength;
    private Blake2bDigest root;
    private int bufferPos = 0;
    private int keyLength = 0;
    private int nodeOffset = 0;
    private Blake2bDigest[] S = new Blake2bDigest[4];
    private byte[] salt = null;
    private byte[] key = null;
    private final int BLAKE2B_BLOCKBYTES = 128;
    private final int BLAKE2B_KEYBYTES = 64;
    private final int BLAKE2B_OUTBYTES = 64;
    private final int PARALLELISM_DEGREE = 4;
    private final byte[] singleByte = new byte[1];
    private byte[] param = new byte[64];
    private byte[] buffer = new byte[512];

    public Blake2bpDigest(byte[] bArr) {
        init(bArr);
    }

    private void init(byte[] bArr) {
        int i8;
        if (bArr != null && bArr.length > 0) {
            int length = bArr.length;
            this.keyLength = length;
            if (length > 64) {
                throw new IllegalArgumentException("Keys > 64 bytes are not supported");
            }
            this.key = Arrays.clone(bArr);
        }
        this.bufferPos = 0;
        this.digestLength = 64;
        this.fanout = 4;
        this.depth = 2;
        this.innerHashLength = 64L;
        byte[] bArr2 = this.param;
        bArr2[0] = (byte) 64;
        bArr2[1] = (byte) this.keyLength;
        bArr2[2] = (byte) 4;
        bArr2[3] = (byte) 2;
        bArr2[16] = 1;
        bArr2[17] = (byte) 64;
        this.root = new Blake2bDigest((byte[]) null, bArr2);
        Pack.intToLittleEndian(this.nodeOffset, this.param, 8);
        this.param[16] = 0;
        for (int i9 = 0; i9 < 4; i9++) {
            Pack.intToLittleEndian(i9, this.param, 8);
            this.S[i9] = new Blake2bDigest((byte[]) null, this.param);
        }
        this.root.setAsLastNode();
        this.S[3].setAsLastNode();
        if (bArr == null || (i8 = this.keyLength) <= 0) {
            return;
        }
        byte[] bArr3 = new byte[128];
        System.arraycopy(bArr, 0, bArr3, 0, i8);
        for (int i10 = 0; i10 < 4; i10++) {
            this.S[i10].update(bArr3, 0, 128);
        }
    }

    @Override // org.bouncycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i8) {
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 4, 64);
        for (int i9 = 0; i9 < 4; i9++) {
            int i10 = this.bufferPos;
            int i11 = i9 * 128;
            if (i10 > i11) {
                int i12 = i10 - i11;
                if (i12 > 128) {
                    i12 = 128;
                }
                this.S[i9].update(this.buffer, i11, i12);
            }
            this.S[i9].doFinal(bArr2[i9], 0);
        }
        for (int i13 = 0; i13 < 4; i13++) {
            this.root.update(bArr2[i13], 0, 64);
        }
        int iDoFinal = this.root.doFinal(bArr, i8);
        reset();
        return iDoFinal;
    }

    @Override // org.bouncycastle.crypto.Digest
    public String getAlgorithmName() {
        return "BLAKE2bp";
    }

    @Override // org.bouncycastle.crypto.ExtendedDigest
    public int getByteLength() {
        return 0;
    }

    @Override // org.bouncycastle.crypto.Digest
    public int getDigestSize() {
        return this.digestLength;
    }

    @Override // org.bouncycastle.crypto.Digest
    public void reset() {
        this.bufferPos = 0;
        this.digestLength = 64;
        this.root.reset();
        for (int i8 = 0; i8 < 4; i8++) {
            this.S[i8].reset();
        }
        this.root.setAsLastNode();
        this.S[3].setAsLastNode();
        byte[] bArr = this.key;
        if (bArr != null) {
            byte[] bArr2 = new byte[128];
            System.arraycopy(bArr, 0, bArr2, 0, this.keyLength);
            for (int i9 = 0; i9 < 4; i9++) {
                this.S[i9].update(bArr2, 0, 128);
            }
        }
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte b9) {
        byte[] bArr = this.singleByte;
        bArr[0] = b9;
        update(bArr, 0, 1);
    }

    @Override // org.bouncycastle.crypto.Digest
    public void update(byte[] bArr, int i8, int i9) {
        int i10 = this.bufferPos;
        int i11 = 1024 - i10;
        if (i10 != 0 && i9 >= i11) {
            System.arraycopy(bArr, i8, this.buffer, i10, i11);
            for (int i12 = 0; i12 < 4; i12++) {
                this.S[i12].update(this.buffer, i12 * 128, 128);
            }
            i8 += i11;
            i9 -= i11;
            i10 = 0;
        }
        for (int i13 = 0; i13 < 4; i13++) {
            int i14 = (i13 * 128) + i8;
            for (int i15 = i9; i15 >= 512; i15 -= 512) {
                this.S[i13].update(bArr, i14, 128);
                i14 += 512;
            }
        }
        int i16 = i9 % 512;
        int i17 = (i9 - i16) + i8;
        if (i16 > 0) {
            System.arraycopy(bArr, i17, this.buffer, i10, i16);
        }
        this.bufferPos = i10 + i16;
    }
}
