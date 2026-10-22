package org.bouncycastle.crypto.macs;

import a8.b;
import org.bouncycastle.asn1.BERTags;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.ISO7816d4Padding;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Pack;

/* loaded from: classes.dex */
public class CMac implements Mac {
    private byte[] Lu;
    private byte[] Lu2;
    private byte[] ZEROES;
    private byte[] buf;
    private int bufOff;
    private BlockCipher cipher;
    private byte[] mac;
    private int macSize;
    private byte[] poly;

    public CMac(BlockCipher blockCipher) {
        this(blockCipher, blockCipher.getBlockSize() * 8);
    }

    private byte[] doubleLu(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i8 = (-shiftLeft(bArr, bArr2)) & 255;
        int length = bArr.length - 3;
        byte b9 = bArr2[length];
        byte[] bArr3 = this.poly;
        bArr2[length] = (byte) (b9 ^ (bArr3[1] & i8));
        int length2 = bArr.length - 2;
        bArr2[length2] = (byte) ((bArr3[2] & i8) ^ bArr2[length2]);
        int length3 = bArr.length - 1;
        bArr2[length3] = (byte) ((bArr3[3] & i8) ^ bArr2[length3]);
        return bArr2;
    }

    private static byte[] lookupPoly(int i8) {
        int i9 = i8 * 8;
        int i10 = 135;
        switch (i9) {
            case 64:
            case 320:
                i10 = 27;
                break;
            case 128:
            case BERTags.PRIVATE /* 192 */:
                break;
            case 160:
                i10 = 45;
                break;
            case BERTags.FLAGS /* 224 */:
                i10 = 777;
                break;
            case 256:
                i10 = 1061;
                break;
            case 384:
                i10 = 4109;
                break;
            case 448:
                i10 = 2129;
                break;
            case 512:
                i10 = 293;
                break;
            case 768:
                i10 = 655377;
                break;
            case 1024:
                i10 = 524355;
                break;
            case 2048:
                i10 = 548865;
                break;
            default:
                throw new IllegalArgumentException(b.j(i9, "Unknown block size for CMAC: "));
        }
        return Pack.intToBigEndian(i10);
    }

    private static int shiftLeft(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        int i8 = 0;
        while (true) {
            length--;
            if (length < 0) {
                return i8;
            }
            int i9 = bArr[length] & 255;
            bArr2[length] = (byte) (i8 | (i9 << 1));
            i8 = (i9 >>> 7) & 1;
        }
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i8) {
        byte[] bArr2;
        if (this.bufOff == this.cipher.getBlockSize()) {
            bArr2 = this.Lu;
        } else {
            new ISO7816d4Padding().addPadding(this.buf, this.bufOff);
            bArr2 = this.Lu2;
        }
        int i9 = 0;
        while (true) {
            byte[] bArr3 = this.mac;
            if (i9 >= bArr3.length) {
                this.cipher.processBlock(this.buf, 0, bArr3, 0);
                System.arraycopy(this.mac, 0, bArr, i8, this.macSize);
                reset();
                return this.macSize;
            }
            byte[] bArr4 = this.buf;
            bArr4[i9] = (byte) (bArr4[i9] ^ bArr2[i9]);
            i9++;
        }
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
        validate(cipherParameters);
        this.cipher.init(true, cipherParameters);
        byte[] bArr = this.ZEROES;
        byte[] bArr2 = new byte[bArr.length];
        this.cipher.processBlock(bArr, 0, bArr2, 0);
        byte[] bArrDoubleLu = doubleLu(bArr2);
        this.Lu = bArrDoubleLu;
        this.Lu2 = doubleLu(bArrDoubleLu);
        reset();
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

    public void validate(CipherParameters cipherParameters) {
        if (cipherParameters != null && !(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("CMac mode only permits key to be set.");
        }
    }

    public CMac(BlockCipher blockCipher, int i8) {
        if (i8 % 8 != 0) {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        }
        if (i8 > blockCipher.getBlockSize() * 8) {
            throw new IllegalArgumentException("MAC size must be less or equal to " + (blockCipher.getBlockSize() * 8));
        }
        this.cipher = CBCBlockCipher.newInstance(blockCipher);
        this.macSize = i8 / 8;
        this.poly = lookupPoly(blockCipher.getBlockSize());
        this.mac = new byte[blockCipher.getBlockSize()];
        this.buf = new byte[blockCipher.getBlockSize()];
        this.ZEROES = new byte[blockCipher.getBlockSize()];
        this.bufOff = 0;
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
}
