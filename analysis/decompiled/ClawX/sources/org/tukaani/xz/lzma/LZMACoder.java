package org.tukaani.xz.lzma;

import java.lang.reflect.Array;
import org.tukaani.xz.rangecoder.RangeCoder;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
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
    final int[] reps = new int[4];
    final State state = new State();

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    public abstract class LengthCoder {
        static final int HIGH_SYMBOLS = 256;
        static final int LOW_SYMBOLS = 8;
        static final int MID_SYMBOLS = 8;
        final short[] choice = new short[2];
        final short[] high;
        final short[][] low;
        final short[][] mid;

        public LengthCoder() {
            Class cls = Short.TYPE;
            this.low = (short[][]) Array.newInstance((Class<?>) cls, 16, 8);
            this.mid = (short[][]) Array.newInstance((Class<?>) cls, 16, 8);
            this.high = new short[256];
        }

        public void reset() {
            RangeCoder.initProbs(this.choice);
            int i8 = 0;
            while (true) {
                short[][] sArr = this.low;
                if (i8 >= sArr.length) {
                    break;
                }
                RangeCoder.initProbs(sArr[i8]);
                i8++;
            }
            for (int i9 = 0; i9 < this.low.length; i9++) {
                RangeCoder.initProbs(this.mid[i9]);
            }
            RangeCoder.initProbs(this.high);
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    public abstract class LiteralCoder {
        private final int lc;
        private final int literalPosMask;

        /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
        public abstract class LiteralSubcoder {
            final short[] probs = new short[768];

            public LiteralSubcoder() {
            }

            public void reset() {
                RangeCoder.initProbs(this.probs);
            }
        }

        public LiteralCoder(int i8, int i9) {
            this.lc = i8;
            this.literalPosMask = (1 << i9) - 1;
        }

        public final int getSubcoderIndex(int i8, int i9) {
            int i10 = this.lc;
            return (i8 >> (8 - i10)) + ((this.literalPosMask & i9) << i10);
        }
    }

    public LZMACoder(int i8) {
        Class cls = Short.TYPE;
        this.isMatch = (short[][]) Array.newInstance((Class<?>) cls, 12, 16);
        this.isRep = new short[12];
        this.isRep0 = new short[12];
        this.isRep1 = new short[12];
        this.isRep2 = new short[12];
        this.isRep0Long = (short[][]) Array.newInstance((Class<?>) cls, 12, 16);
        this.distSlots = (short[][]) Array.newInstance((Class<?>) cls, 4, 64);
        this.distSpecial = new short[][]{new short[2], new short[2], new short[4], new short[4], new short[8], new short[8], new short[16], new short[16], new short[32], new short[32]};
        this.distAlign = new short[16];
        this.posMask = (1 << i8) - 1;
    }

    public static final int getDistState(int i8) {
        if (i8 < 6) {
            return i8 - 2;
        }
        return 3;
    }

    public void reset() {
        int[] iArr = this.reps;
        int i8 = 0;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        this.state.reset();
        int i9 = 0;
        while (true) {
            short[][] sArr = this.isMatch;
            if (i9 >= sArr.length) {
                break;
            }
            RangeCoder.initProbs(sArr[i9]);
            i9++;
        }
        RangeCoder.initProbs(this.isRep);
        RangeCoder.initProbs(this.isRep0);
        RangeCoder.initProbs(this.isRep1);
        RangeCoder.initProbs(this.isRep2);
        int i10 = 0;
        while (true) {
            short[][] sArr2 = this.isRep0Long;
            if (i10 >= sArr2.length) {
                break;
            }
            RangeCoder.initProbs(sArr2[i10]);
            i10++;
        }
        int i11 = 0;
        while (true) {
            short[][] sArr3 = this.distSlots;
            if (i11 >= sArr3.length) {
                break;
            }
            RangeCoder.initProbs(sArr3[i11]);
            i11++;
        }
        while (true) {
            short[][] sArr4 = this.distSpecial;
            if (i8 >= sArr4.length) {
                RangeCoder.initProbs(this.distAlign);
                return;
            } else {
                RangeCoder.initProbs(sArr4[i8]);
                i8++;
            }
        }
    }
}
