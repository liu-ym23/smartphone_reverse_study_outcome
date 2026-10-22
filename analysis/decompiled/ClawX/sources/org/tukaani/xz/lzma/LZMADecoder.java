package org.tukaani.xz.lzma;

import org.tukaani.xz.CorruptedInputException;
import org.tukaani.xz.lz.LZDecoder;
import org.tukaani.xz.lzma.LZMACoder;
import org.tukaani.xz.rangecoder.RangeDecoder;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class LZMADecoder extends LZMACoder {
    private final LiteralDecoder literalDecoder;
    private final LZDecoder lz;
    private final LengthDecoder matchLenDecoder;
    private final RangeDecoder rc;
    private final LengthDecoder repLenDecoder;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    public class LengthDecoder extends LZMACoder.LengthCoder {
        private LengthDecoder() {
            super();
        }

        public int decode(int i8) {
            return LZMADecoder.this.rc.decodeBit(this.choice, 0) == 0 ? LZMADecoder.this.rc.decodeBitTree(this.low[i8]) + 2 : LZMADecoder.this.rc.decodeBit(this.choice, 1) == 0 ? LZMADecoder.this.rc.decodeBitTree(this.mid[i8]) + 10 : LZMADecoder.this.rc.decodeBitTree(this.high) + 18;
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    public class LiteralDecoder extends LZMACoder.LiteralCoder {
        private final LiteralSubdecoder[] subdecoders;

        /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
        public class LiteralSubdecoder extends LZMACoder.LiteralCoder.LiteralSubcoder {
            private LiteralSubdecoder() {
                super();
            }

            public void decode() {
                int iDecodeBit = 1;
                if (LZMADecoder.this.state.isLiteral()) {
                    do {
                        iDecodeBit = LZMADecoder.this.rc.decodeBit(this.probs, iDecodeBit) | (iDecodeBit << 1);
                    } while (iDecodeBit < 256);
                } else {
                    int i8 = LZMADecoder.this.lz.getByte(LZMADecoder.this.reps[0]);
                    int i9 = 256;
                    int i10 = 1;
                    do {
                        i8 <<= 1;
                        int i11 = i8 & i9;
                        int iDecodeBit2 = LZMADecoder.this.rc.decodeBit(this.probs, i9 + i11 + i10);
                        i10 = (i10 << 1) | iDecodeBit2;
                        i9 &= (~i11) ^ (0 - iDecodeBit2);
                    } while (i10 < 256);
                    iDecodeBit = i10;
                }
                LZMADecoder.this.lz.putByte((byte) iDecodeBit);
                LZMADecoder.this.state.updateLiteral();
            }
        }

        public LiteralDecoder(int i8, int i9) {
            super(i8, i9);
            this.subdecoders = new LiteralSubdecoder[1 << (i8 + i9)];
            int i10 = 0;
            while (true) {
                LiteralSubdecoder[] literalSubdecoderArr = this.subdecoders;
                if (i10 >= literalSubdecoderArr.length) {
                    return;
                }
                literalSubdecoderArr[i10] = new LiteralSubdecoder();
                i10++;
            }
        }

        public void decode() {
            this.subdecoders[getSubcoderIndex(LZMADecoder.this.lz.getByte(0), LZMADecoder.this.lz.getPos())].decode();
        }

        public void reset() {
            int i8 = 0;
            while (true) {
                LiteralSubdecoder[] literalSubdecoderArr = this.subdecoders;
                if (i8 >= literalSubdecoderArr.length) {
                    return;
                }
                literalSubdecoderArr[i8].reset();
                i8++;
            }
        }
    }

    public LZMADecoder(LZDecoder lZDecoder, RangeDecoder rangeDecoder, int i8, int i9, int i10) {
        super(i10);
        this.matchLenDecoder = new LengthDecoder();
        this.repLenDecoder = new LengthDecoder();
        this.lz = lZDecoder;
        this.rc = rangeDecoder;
        this.literalDecoder = new LiteralDecoder(i8, i9);
        reset();
    }

    private int decodeMatch(int i8) {
        this.state.updateMatch();
        int[] iArr = this.reps;
        iArr[3] = iArr[2];
        iArr[2] = iArr[1];
        iArr[1] = iArr[0];
        int iDecode = this.matchLenDecoder.decode(i8);
        int iDecodeBitTree = this.rc.decodeBitTree(this.distSlots[LZMACoder.getDistState(iDecode)]);
        if (iDecodeBitTree < 4) {
            this.reps[0] = iDecodeBitTree;
            return iDecode;
        }
        int i9 = iDecodeBitTree >> 1;
        int[] iArr2 = this.reps;
        int i10 = (2 | (iDecodeBitTree & 1)) << (i9 - 1);
        iArr2[0] = i10;
        if (iDecodeBitTree < 14) {
            iArr2[0] = this.rc.decodeReverseBitTree(this.distSpecial[iDecodeBitTree - 4]) | i10;
            return iDecode;
        }
        iArr2[0] = (this.rc.decodeDirectBits(i9 - 5) << 4) | i10;
        int[] iArr3 = this.reps;
        iArr3[0] = this.rc.decodeReverseBitTree(this.distAlign) | iArr3[0];
        return iDecode;
    }

    private int decodeRepMatch(int i8) {
        int i9;
        if (this.rc.decodeBit(this.isRep0, this.state.get()) != 0) {
            if (this.rc.decodeBit(this.isRep1, this.state.get()) == 0) {
                i9 = this.reps[1];
            } else {
                if (this.rc.decodeBit(this.isRep2, this.state.get()) == 0) {
                    i9 = this.reps[2];
                } else {
                    int[] iArr = this.reps;
                    int i10 = iArr[3];
                    iArr[3] = iArr[2];
                    i9 = i10;
                }
                int[] iArr2 = this.reps;
                iArr2[2] = iArr2[1];
            }
            int[] iArr3 = this.reps;
            iArr3[1] = iArr3[0];
            iArr3[0] = i9;
        } else if (this.rc.decodeBit(this.isRep0Long[this.state.get()], i8) == 0) {
            this.state.updateShortRep();
            return 1;
        }
        this.state.updateLongRep();
        return this.repLenDecoder.decode(i8);
    }

    public void decode() throws CorruptedInputException {
        this.lz.repeatPending();
        while (this.lz.hasSpace()) {
            int pos = this.lz.getPos() & this.posMask;
            if (this.rc.decodeBit(this.isMatch[this.state.get()], pos) == 0) {
                this.literalDecoder.decode();
            } else {
                this.lz.repeat(this.reps[0], this.rc.decodeBit(this.isRep, this.state.get()) == 0 ? decodeMatch(pos) : decodeRepMatch(pos));
            }
        }
        this.rc.normalize();
    }

    public boolean endMarkerDetected() {
        return this.reps[0] == -1;
    }

    @Override // org.tukaani.xz.lzma.LZMACoder
    public void reset() {
        super.reset();
        this.literalDecoder.reset();
        this.matchLenDecoder.reset();
        this.repLenDecoder.reset();
    }
}
