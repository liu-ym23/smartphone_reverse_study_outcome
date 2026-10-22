package org.tukaani.xz.lzma;

import java.lang.reflect.Array;
import org.tukaani.xz.rangecoder.RangeCoder;

/* JADX INFO: loaded from: classes3.dex */
abstract class LZMACoder {
    static final int ALIGN_BITS = 4;
    static final int ALIGN_MASK = 15;
    static final int ALIGN_SIZE = 16;
    static final int DIST_MODEL_END = 14;
    static final int DIST_MODEL_START = 4;
    static final int DIST_SLOTS = 64;
    static final int DIST_STATES = 4;
    static final int FULL_DISTANCES = 128;
    static final int MATCH_LEN_MAX = 273;
    static final int MATCH_LEN_MIN = 2;
    static final int POS_STATES_MAX = 16;
    static final int REPS = 4;
    final short[] distAlign;
    final short[][] distSlots;
    final short[][] distSpecial;
    final short[][] isMatch;
    final short[] isRep;
    final short[] isRep0;
    final short[][] isRep0Long;
    final short[] isRep1;
    final short[] isRep2;
    final int posMask;
    final int[] reps;
    final State state;

    abstract class LengthCoder {
        static final int HIGH_SYMBOLS = 256;
        static final int LOW_SYMBOLS = 8;
        static final int MID_SYMBOLS = 8;
        final short[] choice;
        final short[] high;
        final short[][] low;
        final short[][] mid;
        final /* synthetic */ LZMACoder this$0;

        LengthCoder(LZMACoder this$0) {
            this.this$0 = this$0;
            this.choice = new short[2];
            this.low = (short[][]) Array.newInstance(Short.TYPE, new int[]{16, 8});
            this.mid = (short[][]) Array.newInstance(Short.TYPE, new int[]{16, 8});
            this.high = new short[256];
        }

        void reset() {
            RangeCoder.initProbs(this.choice);
            int i = 0;
        L4:
            if (i >= this.low.length) goto L6;
            RangeCoder.initProbs(this.low[i]);
            i = i + 1;
            goto L4
        L6:
            int i2 = 0;
        L8:
            if (i2 >= this.low.length) goto L10;
            RangeCoder.initProbs(this.mid[i2]);
            i2 = i2 + 1;
            goto L8
        L10:
            RangeCoder.initProbs(this.high);
        }
    }

    abstract class LiteralCoder {
        private final int lc;
        private final int literalPosMask;
        final /* synthetic */ LZMACoder this$0;

        abstract class LiteralSubcoder {
            final short[] probs;
            final /* synthetic */ LiteralCoder this$1;

            LiteralSubcoder(LiteralCoder this$1) {
                this.this$1 = this$1;
                this.probs = new short[768];
            }

            void reset() {
                RangeCoder.initProbs(this.probs);
            }
        }

        LiteralCoder(LZMACoder this$0, int lc, int lp) {
            this.this$0 = this$0;
            this.lc = lc;
            this.literalPosMask = (1 << lp) - 1;
        }

        final int getSubcoderIndex(int prevByte, int pos) {
            int low = prevByte >> (8 - this.lc);
            int high = (this.literalPosMask & pos) << this.lc;
            return low + high;
        }
    }

    static final int getDistState(int len) {
        if (len < 6) goto L7;
        return 3;
    L7:
        return len - 2;
    }

    LZMACoder(int pb) {
        this.reps = new int[4];
        this.state = new State();
        this.isMatch = (short[][]) Array.newInstance(Short.TYPE, new int[]{12, 16});
        this.isRep = new short[12];
        this.isRep0 = new short[12];
        this.isRep1 = new short[12];
        this.isRep2 = new short[12];
        this.isRep0Long = (short[][]) Array.newInstance(Short.TYPE, new int[]{12, 16});
        this.distSlots = (short[][]) Array.newInstance(Short.TYPE, new int[]{4, 64});
        this.distSpecial = new short[][]{new short[2], new short[2], new short[4], new short[4], new short[8], new short[8], new short[16], new short[16], new short[32], new short[32]};
        this.distAlign = new short[16];
        this.posMask = (1 << pb) - 1;
    }

    void reset() {
        this.reps[0] = 0;
        this.reps[1] = 0;
        this.reps[2] = 0;
        this.reps[3] = 0;
        this.state.reset();
        int i = 0;
    L4:
        if (i >= this.isMatch.length) goto L6;
        RangeCoder.initProbs(this.isMatch[i]);
        i = i + 1;
        goto L4
    L6:
        RangeCoder.initProbs(this.isRep);
        RangeCoder.initProbs(this.isRep0);
        RangeCoder.initProbs(this.isRep1);
        RangeCoder.initProbs(this.isRep2);
        int i2 = 0;
    L8:
        if (i2 >= this.isRep0Long.length) goto L10;
        RangeCoder.initProbs(this.isRep0Long[i2]);
        i2 = i2 + 1;
        goto L8
    L10:
        int i3 = 0;
    L12:
        if (i3 >= this.distSlots.length) goto L14;
        RangeCoder.initProbs(this.distSlots[i3]);
        i3 = i3 + 1;
        goto L12
    L14:
        int i4 = 0;
    L16:
        if (i4 >= this.distSpecial.length) goto L18;
        RangeCoder.initProbs(this.distSpecial[i4]);
        i4 = i4 + 1;
        goto L16
    L18:
        RangeCoder.initProbs(this.distAlign);
    }
}
