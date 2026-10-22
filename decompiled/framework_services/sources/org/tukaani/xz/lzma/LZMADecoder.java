package org.tukaani.xz.lzma;

import java.io.IOException;
import org.tukaani.xz.lz.LZDecoder;
import org.tukaani.xz.rangecoder.RangeDecoder;

/* JADX INFO: loaded from: classes3.dex */
public final class LZMADecoder extends LZMACoder {
    private final LiteralDecoder literalDecoder;
    private final LZDecoder lz;
    private final LengthDecoder matchLenDecoder;
    private final RangeDecoder rc;
    private final LengthDecoder repLenDecoder;

    private class LengthDecoder extends LZMACoder.LengthCoder {
        final /* synthetic */ LZMADecoder this$0;

        /* synthetic */ LengthDecoder(LZMADecoder r1, LZMADecoderIA r2) {
            this(r1);
        }

        private LengthDecoder(LZMADecoder r1) {
            this.this$0 = r1;
            super(r1);
        }

        int decode(int posState) throws IOException {
            if (LZMADecoder.m10590$$Nest$fgetrc(this.this$0).decodeBit(this.choice, 0) != 0) goto L7;
            return LZMADecoder.m10590$$Nest$fgetrc(this.this$0).decodeBitTree(this.low[posState]) + 2;
        L7:
            if (LZMADecoder.m10590$$Nest$fgetrc(this.this$0).decodeBit(this.choice, 1) != 0) goto L11;
            return (LZMADecoder.m10590$$Nest$fgetrc(this.this$0).decodeBitTree(this.mid[posState]) + 2) + 8;
        L11:
            return ((LZMADecoder.m10590$$Nest$fgetrc(this.this$0).decodeBitTree(this.high) + 2) + 8) + 8;
        }
    }

    private class LiteralDecoder extends LZMACoder.LiteralCoder {
        private final LiteralSubdecoder[] subdecoders;
        final /* synthetic */ LZMADecoder this$0;

        private class LiteralSubdecoder extends LZMACoder.LiteralCoder.LiteralSubcoder {
            final /* synthetic */ LiteralDecoder this$1;

            /* synthetic */ LiteralSubdecoder(LiteralDecoder r1, LZMADecoderIA r2) {
                this(r1);
            }

            private LiteralSubdecoder(LiteralDecoder r1) {
                this.this$1 = r1;
                super(r1);
            }

            void decode() throws IOException {
                int symbol = 1;
                if (this.this$1.this$0.state.isLiteral() == false) goto L7;
            L4:
                symbol = (symbol << 1) | LZMADecoder.m10590$$Nest$fgetrc(this.this$1.this$0).decodeBit(this.probs, symbol);
                if (symbol < 256) goto L4;
            L10:
                LZMADecoder.m10589$$Nest$fgetlz(this.this$1.this$0).putByte((byte) symbol);
                this.this$1.this$0.state.updateLiteral();
                return;
            L7:
                int matchByte = LZMADecoder.m10589$$Nest$fgetlz(this.this$1.this$0).getByte(this.this$1.this$0.reps[0]);
                int offset = 256;
            L8:
                matchByte = matchByte << 1;
                int matchBit = matchByte & offset;
                int bit = LZMADecoder.m10590$$Nest$fgetrc(this.this$1.this$0).decodeBit(this.probs, (offset + matchBit) + symbol);
                symbol = (symbol << 1) | bit;
                offset = offset & ((0 - bit) ^ (~matchBit));
                if (symbol < 256) goto L8;
                goto L10
            }
        }

        LiteralDecoder(LZMADecoder r4, int lc, int lp) {
            this.this$0 = r4;
            super(r4, lc, lp);
            this.subdecoders = new LiteralSubdecoder[1 << (lc + lp)];
            int i = 0;
        L4:
            if (i >= this.subdecoders.length) goto L7;
            this.subdecoders[i] = new LiteralSubdecoder(this, null);
            i = i + 1;
            goto L4
        }

        void reset() {
            int i = 0;
        L4:
            if (i >= this.subdecoders.length) goto L7;
            this.subdecoders[i].reset();
            i = i + 1;
            goto L4
        }

        void decode() throws IOException {
            int i = getSubcoderIndex(LZMADecoder.m10589$$Nest$fgetlz(this.this$0).getByte(0), LZMADecoder.m10589$$Nest$fgetlz(this.this$0).getPos());
            this.subdecoders[i].decode();
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetlz, reason: not valid java name */
    static /* bridge */ /* synthetic */ LZDecoder m10589$$Nest$fgetlz(LZMADecoder r0) {
        return r0.lz;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetrc, reason: not valid java name */
    static /* bridge */ /* synthetic */ RangeDecoder m10590$$Nest$fgetrc(LZMADecoder r0) {
        return r0.rc;
    }

    public LZMADecoder(LZDecoder lz, RangeDecoder rc, int lc, int lp, int pb) {
        super(pb);
        LZMADecoderIA r1 = null;
        this.matchLenDecoder = new LengthDecoder(this, r1);
        this.repLenDecoder = new LengthDecoder(this, r1);
        this.lz = lz;
        this.rc = rc;
        this.literalDecoder = new LiteralDecoder(this, lc, lp);
        reset();
    }

    @Override // org.tukaani.xz.lzma.LZMACoder
    public void reset() {
        super.reset();
        this.literalDecoder.reset();
        this.matchLenDecoder.reset();
        this.repLenDecoder.reset();
    }

    public boolean endMarkerDetected() {
        if (this.reps[0] != (-1)) goto L6;
        return true;
    L6:
        return false;
    }

    public void decode() throws IOException {
        this.lz.repeatPending();
    L4:
        if (this.lz.hasSpace() == false) goto L14;
        int posState = this.lz.getPos() & this.posMask;
        if (this.rc.decodeBit(this.isMatch[this.state.get()], posState) == 0) goto L7;
        if (this.rc.decodeBit(this.isRep, this.state.get()) != 0) goto L11;
        int len = decodeMatch(posState);
    L12:
        this.lz.repeat(this.reps[0], len);
        goto L4
    L11:
        len = decodeRepMatch(posState);
        goto L12
    L7:
        this.literalDecoder.decode();
        goto L4
    L14:
        this.rc.normalize();
    }

    private int decodeMatch(int posState) throws IOException {
        this.state.updateMatch();
        this.reps[3] = this.reps[2];
        this.reps[2] = this.reps[1];
        this.reps[1] = this.reps[0];
        int len = this.matchLenDecoder.decode(posState);
        int distSlot = this.rc.decodeBitTree(this.distSlots[LZMACoder.getDistState(len)]);
        if (distSlot >= 4) goto L5;
        this.reps[0] = distSlot;
    L9:
        return len;
    L5:
        int limit = (distSlot >> 1) - 1;
        this.reps[0] = (2 | (distSlot & 1)) << limit;
        if (distSlot >= 14) goto L8;
        int[] r2 = this.reps;
        r2[0] = r2[0] | this.rc.decodeReverseBitTree(this.distSpecial[distSlot - 4]);
        goto L9
    L8:
        int[] r3 = this.reps;
        r3[0] = r3[0] | (this.rc.decodeDirectBits(limit - 4) << 4);
        int[] r4 = this.reps;
        r4[0] = r4[0] | this.rc.decodeReverseBitTree(this.distAlign);
        goto L9
    }

    private int decodeRepMatch(int posState) throws IOException {
        if (this.rc.decodeBit(this.isRep0, this.state.get()) != 0) goto L9;
        if (this.rc.decodeBit(this.isRep0Long[this.state.get()], posState) != 0) goto L17;
        this.state.updateShortRep();
        return 1;
    L17:
        this.state.updateLongRep();
        return this.repLenDecoder.decode(posState);
    L9:
        if (this.rc.decodeBit(this.isRep1, this.state.get()) != 0) goto L12;
        int tmp = this.reps[1];
    L16:
        this.reps[1] = this.reps[0];
        this.reps[0] = tmp;
        goto L17
    L12:
        if (this.rc.decodeBit(this.isRep2, this.state.get()) != 0) goto L14;
        tmp = this.reps[2];
    L15:
        this.reps[2] = this.reps[1];
        goto L16
    L14:
        tmp = this.reps[3];
        this.reps[3] = this.reps[2];
        goto L15
    }
}
