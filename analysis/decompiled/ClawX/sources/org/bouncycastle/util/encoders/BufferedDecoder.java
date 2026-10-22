package org.bouncycastle.util.encoders;

/* loaded from: classes.dex */
public class BufferedDecoder {
    protected byte[] buf;
    protected int bufOff;
    protected Translator translator;

    public BufferedDecoder(Translator translator, int i8) {
        this.translator = translator;
        if (i8 % translator.getEncodedBlockSize() != 0) {
            throw new IllegalArgumentException("buffer size not multiple of input block size");
        }
        this.buf = new byte[i8];
        this.bufOff = 0;
    }

    public int processByte(byte b9, byte[] bArr, int i8) {
        byte[] bArr2 = this.buf;
        int i9 = this.bufOff;
        int i10 = i9 + 1;
        this.bufOff = i10;
        bArr2[i9] = b9;
        if (i10 != bArr2.length) {
            return 0;
        }
        int iDecode = this.translator.decode(bArr2, 0, bArr2.length, bArr, i8);
        this.bufOff = 0;
        return iDecode;
    }

    public int processBytes(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        byte[] bArr3;
        if (i9 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        byte[] bArr4 = this.buf;
        int length = bArr4.length;
        int i11 = this.bufOff;
        int i12 = length - i11;
        int iDecode = 0;
        if (i9 > i12) {
            System.arraycopy(bArr, i8, bArr4, i11, i12);
            Translator translator = this.translator;
            byte[] bArr5 = this.buf;
            int iDecode2 = translator.decode(bArr5, 0, bArr5.length, bArr2, i10);
            this.bufOff = 0;
            int i13 = i9 - i12;
            int i14 = i8 + i12;
            int length2 = i13 - (i13 % this.buf.length);
            bArr3 = bArr;
            iDecode = iDecode2 + this.translator.decode(bArr3, i14, length2, bArr2, i10 + iDecode2);
            i9 = i13 - length2;
            i8 = i14 + length2;
        } else {
            bArr3 = bArr;
        }
        if (i9 != 0) {
            System.arraycopy(bArr3, i8, this.buf, this.bufOff, i9);
            this.bufOff += i9;
        }
        return iDecode;
    }
}
