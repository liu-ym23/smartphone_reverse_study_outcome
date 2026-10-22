package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.paddings.BlockCipherPadding;

/* loaded from: classes.dex */
public class CFBBlockCipherMac implements Mac {
    private byte[] buf;
    private int bufOff;
    private MacCFBBlockCipher cipher;
    private byte[] mac;
    private int macSize;
    private BlockCipherPadding padding;

    public CFBBlockCipherMac(BlockCipher blockCipher) {
        this(blockCipher, 8, (blockCipher.getBlockSize() * 8) / 2, null);
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i8) {
        int blockSize = this.cipher.getBlockSize();
        BlockCipherPadding blockCipherPadding = this.padding;
        if (blockCipherPadding == null) {
            while (true) {
                int i9 = this.bufOff;
                if (i9 >= blockSize) {
                    break;
                }
                this.buf[i9] = 0;
                this.bufOff = i9 + 1;
            }
        } else {
            blockCipherPadding.addPadding(this.buf, this.bufOff);
        }
        this.cipher.processBlock(this.buf, 0, this.mac, 0);
        this.cipher.getMacBlock(this.mac);
        System.arraycopy(this.mac, 0, bArr, i8, this.macSize);
        reset();
        return this.macSize;
    }

    @Override // org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName();
    }

    @Override // org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return this.macSize;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) {
        reset();
        this.cipher.init(cipherParameters);
    }

    @Override // org.bouncycastle.crypto.Mac
    public void reset() {
        int i8 = 0;
        while (true) {
            byte[] bArr = this.buf;
            if (i8 >= bArr.length) {
                this.bufOff = 0;
                this.cipher.reset();
                return;
            } else {
                bArr[i8] = 0;
                i8++;
            }
        }
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte b9) {
        int i8 = this.bufOff;
        byte[] bArr = this.buf;
        if (i8 == bArr.length) {
            this.cipher.processBlock(bArr, 0, this.mac, 0);
            this.bufOff = 0;
        }
        byte[] bArr2 = this.buf;
        int i9 = this.bufOff;
        this.bufOff = i9 + 1;
        bArr2[i9] = b9;
    }

    public CFBBlockCipherMac(BlockCipher blockCipher, int i8, int i9) {
        this(blockCipher, i8, i9, null);
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte[] bArr, int i8, int i9) {
        if (i9 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int blockSize = this.cipher.getBlockSize();
        int i10 = this.bufOff;
        int i11 = blockSize - i10;
        if (i9 > i11) {
            System.arraycopy(bArr, i8, this.buf, i10, i11);
            this.cipher.processBlock(this.buf, 0, this.mac, 0);
            this.bufOff = 0;
            i9 -= i11;
            i8 += i11;
            while (i9 > blockSize) {
                this.cipher.processBlock(bArr, i8, this.mac, 0);
                i9 -= blockSize;
                i8 += blockSize;
            }
        }
        System.arraycopy(bArr, i8, this.buf, this.bufOff, i9);
        this.bufOff += i9;
    }

    public CFBBlockCipherMac(BlockCipher blockCipher, int i8, int i9, BlockCipherPadding blockCipherPadding) {
        this.padding = null;
        if (i9 % 8 != 0) {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        }
        this.mac = new byte[blockCipher.getBlockSize()];
        MacCFBBlockCipher macCFBBlockCipher = new MacCFBBlockCipher(blockCipher, i8);
        this.cipher = macCFBBlockCipher;
        this.padding = blockCipherPadding;
        this.macSize = i9 / 8;
        this.buf = new byte[macCFBBlockCipher.getBlockSize()];
        this.bufOff = 0;
    }

    public CFBBlockCipherMac(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
        this(blockCipher, 8, (blockCipher.getBlockSize() * 8) / 2, blockCipherPadding);
    }
}
