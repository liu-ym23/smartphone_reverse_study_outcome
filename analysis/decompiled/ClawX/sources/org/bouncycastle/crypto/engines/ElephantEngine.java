package org.bouncycastle.crypto.engines;

import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import m0.f;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.engines.AEADBaseEngine;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Bytes;

/* loaded from: classes.dex */
public class ElephantEngine extends AEADBaseEngine {
    private byte[] ad;
    private int adOff;
    private int adlen;
    private final byte[] buffer;
    private byte[] current_mask;
    private byte[] expanded_key;
    private final Permutation instance;
    private int nb_its;
    private byte[] next_mask;
    private byte[] npub;
    private byte[] previous_mask;
    private final byte[] previous_outputMessage;
    private final byte[] tag_buffer;

    public class Delirium implements Permutation {
        private static final int nRounds = 18;
        private final int[] KeccakRhoOffsets;
        private final byte[] KeccakRoundConstants;

        private Delirium() {
            this.KeccakRoundConstants = new byte[]{1, -126, -118, 0, -117, 1, -127, 9, -118, -120, 9, 10, -117, -117, -119, 3, 2, -128};
            this.KeccakRhoOffsets = new int[]{0, 1, 6, 4, 3, 4, 4, 6, 7, 4, 3, 2, 3, 1, 7, 1, 5, 7, 5, 0, 2, 2, 5, 0, 6};
        }

        private void KeccakP200Round(byte[] bArr, int i8) {
            byte[] bArr2 = new byte[25];
            for (int i9 = 0; i9 < 5; i9++) {
                for (int i10 = 0; i10 < 5; i10++) {
                    bArr2[i9] = (byte) (bArr2[i9] ^ bArr[index(i9, i10)]);
                }
            }
            int i11 = 0;
            while (i11 < 5) {
                int i12 = i11 + 1;
                bArr2[i11 + 5] = (byte) (bArr2[(i11 + 4) % 5] ^ ROL8(bArr2[i12 % 5], 1));
                i11 = i12;
            }
            for (int i13 = 0; i13 < 5; i13++) {
                for (int i14 = 0; i14 < 5; i14++) {
                    int iIndex = index(i13, i14);
                    bArr[iIndex] = (byte) (bArr[iIndex] ^ bArr2[i13 + 5]);
                }
            }
            for (int i15 = 0; i15 < 5; i15++) {
                for (int i16 = 0; i16 < 5; i16++) {
                    bArr2[index(i15, i16)] = ROL8(bArr[index(i15, i16)], this.KeccakRhoOffsets[index(i15, i16)]);
                }
            }
            for (int i17 = 0; i17 < 5; i17++) {
                for (int i18 = 0; i18 < 5; i18++) {
                    bArr[index(i18, ((i18 * 3) + (i17 * 2)) % 5)] = bArr2[index(i17, i18)];
                }
            }
            for (int i19 = 0; i19 < 5; i19++) {
                int i20 = 0;
                while (i20 < 5) {
                    int i21 = i20 + 1;
                    bArr2[i20] = (byte) (bArr[index(i20, i19)] ^ ((~bArr[index(i21 % 5, i19)]) & bArr[index((i20 + 2) % 5, i19)]));
                    i20 = i21;
                }
                for (int i22 = 0; i22 < 5; i22++) {
                    bArr[index(i22, i19)] = bArr2[i22];
                }
            }
            bArr[0] = (byte) (this.KeccakRoundConstants[i8] ^ bArr[0]);
        }

        private byte ROL8(byte b9, int i8) {
            return (byte) ((b9 << i8) | ((b9 & 255) >>> (8 - i8)));
        }

        private int index(int i8, int i9) {
            return (i9 * 5) + i8;
        }

        @Override // org.bouncycastle.crypto.engines.ElephantEngine.Permutation
        public void lfsr_step() {
            byte[] bArr = ElephantEngine.this.next_mask;
            ElephantEngine elephantEngine = ElephantEngine.this;
            int i8 = elephantEngine.BlockSize - 1;
            byte bRotl = elephantEngine.rotl(elephantEngine.current_mask[0]);
            ElephantEngine elephantEngine2 = ElephantEngine.this;
            bArr[i8] = (byte) ((ElephantEngine.this.current_mask[13] << 1) ^ (bRotl ^ elephantEngine2.rotl(elephantEngine2.current_mask[2])));
        }

        @Override // org.bouncycastle.crypto.engines.ElephantEngine.Permutation
        public void permutation(byte[] bArr) {
            for (int i8 = 0; i8 < 18; i8++) {
                KeccakP200Round(bArr, i8);
            }
        }
    }

    public class Dumbo extends Spongent {
        public Dumbo() {
            super(160, 20, 80, (byte) 117);
        }

        @Override // org.bouncycastle.crypto.engines.ElephantEngine.Permutation
        public void lfsr_step() {
            ElephantEngine.this.next_mask[r1.BlockSize - 1] = (byte) (((ElephantEngine.this.current_mask[13] & 255) >>> 7) ^ ((((ElephantEngine.this.current_mask[0] & 255) << 3) | ((ElephantEngine.this.current_mask[0] & 255) >>> 5)) ^ ((ElephantEngine.this.current_mask[3] & 255) << 7)));
        }
    }

    public enum ElephantParameters {
        elephant160,
        elephant176,
        elephant200
    }

    public class Jumbo extends Spongent {
        public Jumbo() {
            super(176, 22, 90, (byte) 69);
        }

        @Override // org.bouncycastle.crypto.engines.ElephantEngine.Permutation
        public void lfsr_step() {
            byte[] bArr = ElephantEngine.this.next_mask;
            ElephantEngine elephantEngine = ElephantEngine.this;
            bArr[elephantEngine.BlockSize - 1] = (byte) (((ElephantEngine.this.current_mask[19] & 255) >>> 7) ^ (elephantEngine.rotl(elephantEngine.current_mask[0]) ^ ((ElephantEngine.this.current_mask[3] & 255) << 7)));
        }
    }

    public interface Permutation {
        void lfsr_step();

        void permutation(byte[] bArr);
    }

    public static abstract class Spongent implements Permutation {
        private final byte lfsrIV;
        private final int nBits;
        private final int nRounds;
        private final int nSBox;
        private final byte[] sBoxLayer = {-18, -19, -21, -32, -30, -31, -28, -17, -25, -22, -24, -27, -23, -20, -29, -26, -34, -35, -37, -48, -46, -47, -44, -33, -41, -38, -40, -43, -39, -36, -45, -42, -66, -67, -69, -80, -78, -79, -76, -65, -73, -70, -72, -75, -71, PSSSigner.TRAILER_IMPLICIT, -77, -74, 14, 13, 11, 0, 2, 1, 4, 15, 7, 10, 8, 5, 9, 12, 3, 6, 46, 45, 43, 32, 34, 33, 36, 47, 39, 42, 40, 37, 41, 44, 35, 38, 30, 29, 27, 16, 18, 17, 20, 31, 23, 26, 24, 21, 25, 28, 19, 22, 78, 77, 75, 64, 66, 65, 68, 79, 71, 74, 72, 69, 73, 76, 67, 70, -2, -3, -5, -16, -14, -15, -12, -1, -9, -6, -8, -11, -7, -4, -13, -10, 126, 125, 123, 112, 114, 113, 116, AbstractJsonLexerKt.TC_INVALID, 119, 122, 120, 117, 121, 124, 115, 118, -82, -83, -85, -96, -94, -95, -92, -81, -89, -86, -88, -91, -87, -84, -93, -90, -114, -115, -117, -128, -126, -127, -124, -113, -121, -118, -120, -123, -119, -116, -125, -122, 94, 93, 91, 80, 82, 81, 84, 95, 87, 90, 88, 85, 89, 92, 83, 86, -98, -99, -101, -112, -110, -111, -108, -97, -105, -102, -104, -107, -103, -100, -109, -106, -50, -51, -53, -64, -62, -63, -60, -49, -57, -54, -56, -59, -55, -52, -61, -58, 62, 61, 59, 48, 50, 49, 52, 63, 55, 58, 56, 53, 57, 60, 51, 54, 110, 109, 107, 96, 98, 97, 100, 111, 103, 106, 104, 101, 105, 108, 99, 102};

        public Spongent(int i8, int i9, int i10, byte b9) {
            this.nRounds = i10;
            this.nSBox = i9;
            this.lfsrIV = b9;
            this.nBits = i8;
        }

        @Override // org.bouncycastle.crypto.engines.ElephantEngine.Permutation
        public void permutation(byte[] bArr) {
            int i8;
            byte b9 = this.lfsrIV;
            byte[] bArr2 = new byte[this.nSBox];
            for (int i9 = 0; i9 < this.nRounds; i9++) {
                bArr[0] = (byte) (bArr[0] ^ b9);
                int i10 = this.nSBox - 1;
                int i11 = b9 & 32;
                int i12 = b9 & 64;
                bArr[i10] = (byte) (bArr[i10] ^ ((byte) (((((((((b9 & 1) << 7) | ((b9 & 2) << 5)) | ((b9 & 4) << 3)) | ((b9 & 8) << 1)) | ((b9 & 16) >>> 1)) | (i11 >>> 3)) | (i12 >>> 5)) | ((b9 & 128) >>> 7))));
                b9 = (byte) (((b9 << 1) | ((i12 >>> 6) ^ (i11 >>> 5))) & 127);
                for (int i13 = 0; i13 < this.nSBox; i13++) {
                    bArr[i13] = this.sBoxLayer[bArr[i13] & 255];
                }
                Arrays.fill(bArr2, (byte) 0);
                int i14 = 0;
                while (true) {
                    i8 = this.nSBox;
                    if (i14 < i8) {
                        for (int i15 = 0; i15 < 8; i15++) {
                            int i16 = (i14 << 3) + i15;
                            int i17 = this.nBits;
                            if (i16 != i17 - 1) {
                                i16 = ((i16 * i17) >> 2) % (i17 - 1);
                            }
                            int i18 = i16 >>> 3;
                            bArr2[i18] = (byte) (((((bArr[i14] & 255) >>> i15) & 1) << (i16 & 7)) ^ bArr2[i18]);
                        }
                        i14++;
                    }
                }
                System.arraycopy(bArr2, 0, bArr, 0, i8);
            }
        }
    }

    public ElephantEngine(ElephantParameters elephantParameters) {
        this.KEY_SIZE = 16;
        this.IV_SIZE = 12;
        int iOrdinal = elephantParameters.ordinal();
        if (iOrdinal == 0) {
            this.BlockSize = 20;
            this.instance = new Dumbo();
            this.MAC_SIZE = 8;
            this.algorithmName = "Elephant 160 AEAD";
        } else if (iOrdinal == 1) {
            this.BlockSize = 22;
            this.instance = new Jumbo();
            this.algorithmName = "Elephant 176 AEAD";
            this.MAC_SIZE = 8;
        } else {
            if (iOrdinal != 2) {
                throw new IllegalArgumentException("Invalid parameter settings for Elephant");
            }
            this.BlockSize = 25;
            this.instance = new Delirium();
            this.algorithmName = "Elephant 200 AEAD";
            this.MAC_SIZE = 16;
        }
        int i8 = this.BlockSize;
        this.tag_buffer = new byte[i8];
        this.previous_mask = new byte[i8];
        this.current_mask = new byte[i8];
        this.next_mask = new byte[i8];
        this.buffer = new byte[i8];
        this.previous_outputMessage = new byte[i8];
        setInnerMembers(AEADBaseEngine.ProcessingBufferType.Immediate, AEADBaseEngine.AADOperatorType.Stream, AEADBaseEngine.DataOperatorType.Counter);
    }

    private void absorbAAD() {
        processAADBytes(this.buffer);
        Bytes.xorTo(this.BlockSize, this.next_mask, this.buffer);
        this.instance.permutation(this.buffer);
        Bytes.xorTo(this.BlockSize, this.next_mask, this.buffer);
        Bytes.xorTo(this.BlockSize, this.buffer, this.tag_buffer);
    }

    private void absorbCiphertext() {
        xorTo(this.BlockSize, this.previous_mask, this.next_mask, this.buffer);
        this.instance.permutation(this.buffer);
        xorTo(this.BlockSize, this.previous_mask, this.next_mask, this.buffer);
        Bytes.xorTo(this.BlockSize, this.buffer, this.tag_buffer);
    }

    private void computeCipherBlock(byte[] bArr, int i8, int i9, byte[] bArr2, int i10) {
        System.arraycopy(this.npub, 0, this.buffer, 0, this.IV_SIZE);
        Arrays.fill(this.buffer, this.IV_SIZE, this.BlockSize, (byte) 0);
        xorTo(this.BlockSize, this.current_mask, this.next_mask, this.buffer);
        this.instance.permutation(this.buffer);
        xorTo(this.BlockSize, this.current_mask, this.next_mask, this.buffer);
        Bytes.xorTo(i9, bArr, i8, this.buffer);
        System.arraycopy(this.buffer, 0, bArr2, i10, i9);
    }

    private void lfsr_step() {
        this.instance.lfsr_step();
        System.arraycopy(this.current_mask, 1, this.next_mask, 0, this.BlockSize - 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void processAADBytes(byte[] r10) {
        /*
            r9 = this;
            org.bouncycastle.crypto.engines.AEADBaseEngine$State r0 = r9.m_state
            int r0 = r0.ord
            r1 = 6
            r2 = 2
            r3 = 0
            r4 = 1
            if (r0 == r4) goto L39
            if (r0 == r2) goto L29
            r5 = 5
            if (r0 == r5) goto L12
            if (r0 == r1) goto L29
            goto L37
        L12:
            byte[] r0 = r9.expanded_key
            byte[] r5 = r9.current_mask
            int r6 = r9.BlockSize
            java.lang.System.arraycopy(r0, r3, r5, r3, r6)
            byte[] r0 = r9.npub
            int r5 = r9.IV_SIZE
            java.lang.System.arraycopy(r0, r3, r10, r3, r5)
            int r0 = r9.IV_SIZE
            org.bouncycastle.crypto.engines.AEADBaseEngine$State r5 = org.bouncycastle.crypto.engines.AEADBaseEngine.State.DecAad
        L26:
            r9.m_state = r5
            goto L4e
        L29:
            int r0 = r9.adOff
            int r5 = r9.adlen
            if (r0 != r5) goto L37
            int r9 = r9.BlockSize
            java.util.Arrays.fill(r10, r3, r9, r3)
            r10[r3] = r4
            return
        L37:
            r0 = r3
            goto L4e
        L39:
            byte[] r0 = r9.expanded_key
            byte[] r5 = r9.current_mask
            int r6 = r9.BlockSize
            java.lang.System.arraycopy(r0, r3, r5, r3, r6)
            byte[] r0 = r9.npub
            int r5 = r9.IV_SIZE
            java.lang.System.arraycopy(r0, r3, r10, r3, r5)
            int r0 = r9.IV_SIZE
            org.bouncycastle.crypto.engines.AEADBaseEngine$State r5 = org.bouncycastle.crypto.engines.AEADBaseEngine.State.EncAad
            goto L26
        L4e:
            int r5 = r9.BlockSize
            int r5 = r5 - r0
            int r6 = r9.adlen
            int r7 = r9.adOff
            int r6 = r6 - r7
            if (r5 > r6) goto L63
            byte[] r1 = r9.ad
            java.lang.System.arraycopy(r1, r7, r10, r0, r5)
            int r10 = r9.adOff
            int r10 = r10 + r5
            r9.adOff = r10
            return
        L63:
            if (r6 <= 0) goto L6f
            byte[] r8 = r9.ad
            java.lang.System.arraycopy(r8, r7, r10, r0, r6)
            int r7 = r9.adOff
            int r7 = r7 + r6
            r9.adOff = r7
        L6f:
            int r6 = r6 + r0
            int r0 = r0 + r5
            java.util.Arrays.fill(r10, r6, r0, r3)
            r10[r6] = r4
            org.bouncycastle.crypto.engines.AEADBaseEngine$State r10 = r9.m_state
            int r10 = r10.ord
            if (r10 == r2) goto L84
            if (r10 == r1) goto L7f
            return
        L7f:
            org.bouncycastle.crypto.engines.AEADBaseEngine$State r10 = org.bouncycastle.crypto.engines.AEADBaseEngine.State.DecData
            r9.m_state = r10
            return
        L84:
            org.bouncycastle.crypto.engines.AEADBaseEngine$State r10 = org.bouncycastle.crypto.engines.AEADBaseEngine.State.EncData
            r9.m_state = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.engines.ElephantEngine.processAADBytes(byte[]):void");
    }

    private void processBuffer(byte[] bArr, int i8, byte[] bArr2, int i9, AEADBaseEngine.State state) {
        AEADBaseEngine.State state2 = this.m_state;
        if (state2 == AEADBaseEngine.State.DecInit || state2 == AEADBaseEngine.State.EncInit) {
            processFinalAAD();
        }
        lfsr_step();
        computeCipherBlock(bArr, i8, this.BlockSize, bArr2, i9);
        if (this.nb_its > 0) {
            System.arraycopy(this.previous_outputMessage, 0, this.buffer, 0, this.BlockSize);
            absorbCiphertext();
        }
        if (this.m_state != state) {
            absorbAAD();
        }
        swapMasks();
        this.nb_its++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte rotl(byte b9) {
        return (byte) ((b9 << 1) | ((b9 & 255) >>> 7));
    }

    private void swapMasks() {
        byte[] bArr = this.previous_mask;
        this.previous_mask = this.current_mask;
        this.current_mask = this.next_mask;
        this.next_mask = bArr;
    }

    public static void xorTo(int i8, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        for (int i9 = 0; i9 < i8; i9++) {
            bArr3[i9] = (byte) (bArr3[i9] ^ (bArr[i9] ^ bArr2[i9]));
        }
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void checkAAD() {
        int i8 = this.m_state.ord;
        if (i8 == 3) {
            throw new IllegalArgumentException(f.f(new StringBuilder(), this.algorithmName, " cannot process AAD when the length of the ciphertext to be processed exceeds the a block size"));
        }
        if (i8 == 4) {
            throw new IllegalArgumentException(f.f(new StringBuilder(), this.algorithmName, " cannot be reused for encryption"));
        }
        if (i8 == 7) {
            throw new IllegalArgumentException(f.f(new StringBuilder(), this.algorithmName, " cannot process AAD when the length of the plaintext to be processed exceeds the a block size"));
        }
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public boolean checkData(boolean z) {
        switch (this.m_state.ord) {
            case 1:
            case 2:
            case 3:
                return true;
            case 4:
                throw new IllegalStateException(getAlgorithmName() + " cannot be reused for encryption");
            case 5:
            case 6:
            case 7:
                return false;
            default:
                throw new IllegalStateException(getAlgorithmName() + " needs to be initialized");
        }
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ int doFinal(byte[] bArr, int i8) {
        return super.doFinal(bArr, i8);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void finishAAD(AEADBaseEngine.State state, boolean z) {
        finishAAD2(state);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ String getAlgorithmName() {
        return super.getAlgorithmName();
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
    public int getOutputSize(int i8) {
        int i9 = this.m_state.ord;
        if (i9 == 0) {
            throw new IllegalArgumentException(f.f(new StringBuilder(), this.algorithmName, " needs call init function before getUpdateOutputSize"));
        }
        if (i9 == 1 || i9 == 2 || i9 == 3) {
            return i8 + this.m_bufPos + this.MAC_SIZE;
        }
        if (i9 == 4 || i9 == 8) {
            return 0;
        }
        return Math.max(0, (i8 + this.m_bufPos) - this.MAC_SIZE);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public int getUpdateOutputSize(int i8) {
        switch (this.m_state.ord) {
            case 0:
                throw new IllegalArgumentException(f.f(new StringBuilder(), this.algorithmName, " needs call init function before getUpdateOutputSize"));
            case 1:
            case 2:
            case 3:
                int i9 = this.m_bufPos + i8;
                return i9 - (i9 % this.BlockSize);
            case 4:
            case 8:
                return 0;
            case 5:
            case 6:
            case 7:
                int iMax = Math.max(0, (this.m_bufPos + i8) - this.MAC_SIZE);
                return iMax - (iMax % this.BlockSize);
            default:
                return Math.max(0, (i8 + this.m_bufPos) - this.MAC_SIZE);
        }
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void init(boolean z, CipherParameters cipherParameters) {
        super.init(z, cipherParameters);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void processAADByte(byte b9) {
        super.processAADByte(b9);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processBufferDecrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
        processBuffer(bArr, i8, bArr2, i9, AEADBaseEngine.State.DecData);
        System.arraycopy(bArr, i8, this.previous_outputMessage, 0, this.BlockSize);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processBufferEncrypt(byte[] bArr, int i8, byte[] bArr2, int i9) {
        processBuffer(bArr, i8, bArr2, i9, AEADBaseEngine.State.EncData);
        System.arraycopy(bArr2, i9, this.previous_outputMessage, 0, this.BlockSize);
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
        if (this.adOff == -1) {
            this.ad = ((AEADBaseEngine.StreamAADOperator) this.aadOperator).getBytes();
            this.adOff = 0;
            this.adlen = this.aadOperator.getLen();
            this.aadOperator.reset();
        }
        int i8 = this.m_state.ord;
        if (i8 == 1 || i8 == 5) {
            processAADBytes(this.tag_buffer);
        }
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processFinalBlock(byte[] bArr, int i8) {
        int len = this.dataOperator.getLen() - (this.forEncryption ? 0 : this.MAC_SIZE);
        processFinalAAD();
        int i9 = this.BlockSize;
        int i10 = len / i9;
        int i11 = i10 + 1;
        int i12 = len % i9 != 0 ? i11 : i10;
        int i13 = (this.IV_SIZE + this.adlen) / i9;
        processBytes(this.m_buf, bArr, i8, Math.max(i10 + 2, i13), i12, i11, len, i13 + 1);
        Bytes.xorTo(this.BlockSize, this.expanded_key, this.tag_buffer);
        this.instance.permutation(this.tag_buffer);
        Bytes.xorTo(this.BlockSize, this.expanded_key, this.tag_buffer);
        System.arraycopy(this.tag_buffer, 0, this.mac, 0, this.MAC_SIZE);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void reset() {
        super.reset();
    }

    private void processBytes(byte[] bArr, byte[] bArr2, int i8, int i9, int i10, int i11, int i12, int i13) {
        byte[] bArr3 = new byte[this.BlockSize];
        int i14 = this.nb_its;
        int i15 = i8;
        int i16 = 0;
        while (i14 < i9) {
            int i17 = i14 == i10 + (-1) ? i12 - (this.BlockSize * i14) : this.BlockSize;
            lfsr_step();
            if (i14 < i10) {
                computeCipherBlock(bArr, i16, i17, bArr2, i15);
                if (this.forEncryption) {
                    System.arraycopy(this.buffer, 0, bArr3, 0, i17);
                } else {
                    System.arraycopy(bArr, i16, bArr3, 0, i17);
                }
                i15 += i17;
                i16 += i17;
            }
            if (i14 > 0 && i14 <= i11) {
                int i18 = this.BlockSize;
                int i19 = (i14 - 1) * i18;
                if (i19 == i12) {
                    Arrays.fill(this.buffer, 1, i18, (byte) 0);
                    this.buffer[0] = 1;
                } else {
                    int i20 = i12 - i19;
                    if (i18 <= i20) {
                        System.arraycopy(this.previous_outputMessage, 0, this.buffer, 0, i18);
                    } else if (i20 > 0) {
                        System.arraycopy(this.previous_outputMessage, 0, this.buffer, 0, i20);
                        Arrays.fill(this.buffer, i20, this.BlockSize, (byte) 0);
                        this.buffer[i20] = 1;
                    }
                }
                absorbCiphertext();
            }
            i14++;
            if (i14 < i13) {
                absorbAAD();
            }
            swapMasks();
            System.arraycopy(bArr3, 0, this.previous_outputMessage, 0, this.BlockSize);
        }
        this.nb_its = i14;
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void init(byte[] bArr, byte[] bArr2) {
        this.npub = bArr2;
        byte[] bArr3 = new byte[this.BlockSize];
        this.expanded_key = bArr3;
        System.arraycopy(bArr, 0, bArr3, 0, this.KEY_SIZE);
        this.instance.permutation(this.expanded_key);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine, org.bouncycastle.crypto.modes.AEADCipher
    public /* bridge */ /* synthetic */ void processAADBytes(byte[] bArr, int i8, int i9) {
        super.processAADBytes(bArr, i8, i9);
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void reset(boolean z) {
        super.reset(z);
        Arrays.fill(this.tag_buffer, (byte) 0);
        Arrays.fill(this.previous_outputMessage, (byte) 0);
        this.nb_its = 0;
        this.adOff = -1;
    }

    @Override // org.bouncycastle.crypto.engines.AEADBaseEngine
    public void processBufferAAD(byte[] bArr, int i8) {
    }
}
