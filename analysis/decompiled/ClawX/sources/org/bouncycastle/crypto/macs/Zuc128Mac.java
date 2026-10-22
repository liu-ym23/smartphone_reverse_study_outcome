package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.engines.Zuc128CoreEngine;

/* loaded from: classes.dex */
public final class Zuc128Mac implements Mac {
    private static final int TOPBIT = 128;
    private int theByteIndex;
    private final InternalZuc128Engine theEngine = new InternalZuc128Engine();
    private final int[] theKeyStream = new int[2];
    private int theMac;
    private Zuc128CoreEngine theState;
    private int theWordIndex;

    public static class InternalZuc128Engine extends Zuc128CoreEngine {
        private InternalZuc128Engine() {
        }

        public int createKeyStreamWord() {
            return super.makeKeyStreamWord();
        }
    }

    private int getFinalWord() {
        if (this.theByteIndex != 0) {
            return this.theEngine.createKeyStreamWord();
        }
        int i8 = this.theWordIndex + 1;
        int[] iArr = this.theKeyStream;
        int length = i8 % iArr.length;
        this.theWordIndex = length;
        return iArr[length];
    }

    private int getKeyStreamWord(int i8) {
        int[] iArr = this.theKeyStream;
        int i9 = this.theWordIndex;
        int i10 = iArr[i9];
        if (i8 == 0) {
            return i10;
        }
        int i11 = iArr[(i9 + 1) % iArr.length];
        return (i11 >>> (32 - i8)) | (i10 << i8);
    }

    private void initKeyStream() {
        int i8 = 0;
        this.theMac = 0;
        while (true) {
            int[] iArr = this.theKeyStream;
            if (i8 >= iArr.length - 1) {
                this.theWordIndex = iArr.length - 1;
                this.theByteIndex = 3;
                return;
            } else {
                iArr[i8] = this.theEngine.createKeyStreamWord();
                i8++;
            }
        }
    }

    private void shift4NextByte() {
        int i8 = (this.theByteIndex + 1) % 4;
        this.theByteIndex = i8;
        if (i8 == 0) {
            this.theKeyStream[this.theWordIndex] = this.theEngine.createKeyStreamWord();
            this.theWordIndex = (this.theWordIndex + 1) % this.theKeyStream.length;
        }
    }

    private void updateMac(int i8) {
        this.theMac = getKeyStreamWord(i8) ^ this.theMac;
    }

    @Override // org.bouncycastle.crypto.Mac
    public int doFinal(byte[] bArr, int i8) {
        shift4NextByte();
        int keyStreamWord = this.theMac ^ getKeyStreamWord(this.theByteIndex * 8);
        this.theMac = keyStreamWord;
        int finalWord = keyStreamWord ^ getFinalWord();
        this.theMac = finalWord;
        Zuc128CoreEngine.encode32be(finalWord, bArr, i8);
        reset();
        return getMacSize();
    }

    @Override // org.bouncycastle.crypto.Mac
    public String getAlgorithmName() {
        return "Zuc128Mac";
    }

    @Override // org.bouncycastle.crypto.Mac
    public int getMacSize() {
        return 4;
    }

    @Override // org.bouncycastle.crypto.Mac
    public void init(CipherParameters cipherParameters) {
        this.theEngine.init(true, cipherParameters);
        this.theState = (Zuc128CoreEngine) this.theEngine.copy();
        initKeyStream();
    }

    @Override // org.bouncycastle.crypto.Mac
    public void reset() {
        Zuc128CoreEngine zuc128CoreEngine = this.theState;
        if (zuc128CoreEngine != null) {
            this.theEngine.reset(zuc128CoreEngine);
        }
        initKeyStream();
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte b9) {
        shift4NextByte();
        int i8 = this.theByteIndex * 8;
        int i9 = 128;
        int i10 = 0;
        while (i9 > 0) {
            if ((b9 & i9) != 0) {
                updateMac(i8 + i10);
            }
            i9 >>= 1;
            i10++;
        }
    }

    @Override // org.bouncycastle.crypto.Mac
    public void update(byte[] bArr, int i8, int i9) {
        for (int i10 = 0; i10 < i9; i10++) {
            update(bArr[i8 + i10]);
        }
    }
}
