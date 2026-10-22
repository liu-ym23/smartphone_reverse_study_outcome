package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.engines.DSTU7624Engine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;

/* loaded from: classes.dex */
public class DSTU7624Mac implements Mac {
    private static final int BITS_IN_BYTE = 8;
    private int blockSize;
    private byte[] buf;
    private int bufOff;

    /* renamed from: c, reason: collision with root package name */
    private byte[] f4494c;
    private byte[] cTemp;
    private DSTU7624Engine engine;
    private boolean initCalled = false;
    private byte[] kDelta;
    private int macSize;

    public DSTU7624Mac(int i8, int i9) {
        this.engine = new DSTU7624Engine(i8);
        int i10 = i8 / 8;
        this.blockSize = i10;
        this.macSize = i9 / 8;
        this.f4494c = new byte[i10];
        this.kDelta = new byte[i10];
        this.cTemp = new byte[i10];
        this.buf = new byte[i10];
    }

    private void processBlock(byte[] bArr, int i8) {
        xor(this.f4494c, 0, bArr, i8, this.cTemp);
        this.engine.processBlock(this.cTemp, 0, this.f4494c, 0);
    }

    private void xor(byte[] bArr, int i8, byte[] bArr2, int i9, byte[] bArr3) {
        int length = bArr.length - i8;
        int i10 = this.blockSize;
        if (length < i10 || bArr2.length - i9 < i10 || bArr3.length < i10) {
            throw new IllegalArgumentException("some of input buffers too short");
        }
        for (int i11 = 0; i11 < this.blockSize; i11++) {
            bArr3[i11] = (byte) (bArr[i11 + i8] ^ bArr2[i11 + i9]);
        }
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i8) {
        int i9 = this.bufOff;
        byte[] bArr2 = this.buf;
        if (i9 % bArr2.length != 0) {
            throw new DataLengthException("input must be a multiple of blocksize");
        }
        xor(this.f4494c, 0, bArr2, 0, this.cTemp);
        xor(this.cTemp, 0, this.kDelta, 0, this.f4494c);
        DSTU7624Engine dSTU7624Engine = this.engine;
        byte[] bArr3 = this.f4494c;
        dSTU7624Engine.processBlock(bArr3, 0, bArr3, 0);
        int i10 = this.macSize;
        if (i10 + i8 > bArr.length) {
            throw new OutputLengthException("output buffer too short");
        }
        System.arraycopy(this.f4494c, 0, bArr, i8, i10);
        reset();
        return this.macSize;
    }

    @Override // org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        return "DSTU7624Mac";
    }

    @Override // org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return this.macSize;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("Invalid parameter passed to DSTU7624Mac");
        }
        this.engine.init(true, cipherParameters);
        this.initCalled = true;
        reset();
    }

    @Override // org.bouncycastle.crypto.Mac
    public void reset() {
        Arrays.fill(this.f4494c, (byte) 0);
        Arrays.fill(this.cTemp, (byte) 0);
        Arrays.fill(this.kDelta, (byte) 0);
        Arrays.fill(this.buf, (byte) 0);
        this.engine.reset();
        if (this.initCalled) {
            DSTU7624Engine dSTU7624Engine = this.engine;
            byte[] bArr = this.kDelta;
            dSTU7624Engine.processBlock(bArr, 0, bArr, 0);
        }
        this.bufOff = 0;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte b9) {
        int i8 = this.bufOff;
        byte[] bArr = this.buf;
        if (i8 == bArr.length) {
            processBlock(bArr, 0);
            this.bufOff = 0;
        }
        byte[] bArr2 = this.buf;
        int i9 = this.bufOff;
        this.bufOff = i9 + 1;
        bArr2[i9] = b9;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte[] bArr, int i8, int i9) {
        if (i9 < 0) {
            throw new IllegalArgumentException("can't have a negative input length!");
        }
        int blockSize = this.engine.getBlockSize();
        int i10 = this.bufOff;
        int i11 = blockSize - i10;
        if (i9 > i11) {
            System.arraycopy(bArr, i8, this.buf, i10, i11);
            processBlock(this.buf, 0);
            this.bufOff = 0;
            i9 -= i11;
            i8 += i11;
            while (i9 > blockSize) {
                processBlock(bArr, i8);
                i9 -= blockSize;
                i8 += blockSize;
            }
        }
        System.arraycopy(bArr, i8, this.buf, this.bufOff, i9);
        this.bufOff += i9;
    }
}
