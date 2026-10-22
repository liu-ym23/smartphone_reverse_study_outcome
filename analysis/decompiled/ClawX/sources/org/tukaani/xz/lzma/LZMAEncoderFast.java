package org.tukaani.xz.lzma;

import org.tukaani.xz.ArrayCache;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.lz.LZEncoder;
import org.tukaani.xz.lz.Matches;
import org.tukaani.xz.rangecoder.RangeEncoder;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
final class LZMAEncoderFast extends LZMAEncoder {
    private static final int EXTRA_SIZE_AFTER = 272;
    private static final int EXTRA_SIZE_BEFORE = 1;
    private Matches matches;

    public LZMAEncoderFast(RangeEncoder rangeEncoder, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, ArrayCache arrayCache) {
        super(rangeEncoder, LZEncoder.getInstance(i11, Math.max(i12, 1), EXTRA_SIZE_AFTER, i13, LZMA2Options.NICE_LEN_MAX, i14, i15, arrayCache), i8, i9, i10, i11, i13);
        this.matches = null;
    }

    private boolean changePair(int i8, int i9) {
        return i8 < (i9 >>> 7);
    }

    public static int getMemoryUsage(int i8, int i9, int i10) {
        return LZEncoder.getMemoryUsage(i8, Math.max(i9, 1), EXTRA_SIZE_AFTER, LZMA2Options.NICE_LEN_MAX, i10);
    }

    @Override // org.tukaani.xz.lzma.LZMAEncoder
    public int getNextSymbol() {
        int i8;
        int i9;
        int i10;
        if (this.readAhead == -1) {
            this.matches = getMatches();
        }
        this.back = -1;
        int iMin = Math.min(this.lz.getAvail(), LZMA2Options.NICE_LEN_MAX);
        if (iMin < 2) {
            return 1;
        }
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < 4; i13++) {
            int matchLen = this.lz.getMatchLen(this.reps[i13], iMin);
            if (matchLen >= 2) {
                if (matchLen >= this.niceLen) {
                    this.back = i13;
                    skip(matchLen - 1);
                    return matchLen;
                }
                if (matchLen > i11) {
                    i12 = i13;
                    i11 = matchLen;
                }
            }
        }
        Matches matches = this.matches;
        int i14 = matches.count;
        if (i14 > 0) {
            i9 = matches.len[i14 - 1];
            i8 = matches.dist[i14 - 1];
            if (i9 >= this.niceLen) {
                this.back = i8 + 4;
                skip(i9 - 1);
                return i9;
            }
            while (true) {
                Matches matches2 = this.matches;
                int i15 = matches2.count;
                if (i15 <= 1 || i9 != matches2.len[i15 - 2] + 1 || !changePair(matches2.dist[i15 - 2], i8)) {
                    break;
                }
                Matches matches3 = this.matches;
                int i16 = matches3.count;
                matches3.count = i16 - 1;
                i9 = matches3.len[i16 - 2];
                i8 = matches3.dist[i16 - 2];
            }
            if (i9 == 2 && i8 >= 128) {
                i9 = 1;
            }
        } else {
            i8 = 0;
            i9 = 0;
        }
        if (i11 >= 2 && (i11 + 1 >= i9 || ((i11 + 2 >= i9 && i8 >= 512) || (i11 + 3 >= i9 && i8 >= 32768)))) {
            this.back = i12;
            skip(i11 - 1);
            return i11;
        }
        if (i9 < 2 || iMin <= 2) {
            return 1;
        }
        Matches matches4 = getMatches();
        this.matches = matches4;
        int i17 = matches4.count;
        if (i17 > 0) {
            int i18 = matches4.len[i17 - 1];
            int i19 = matches4.dist[i17 - 1];
            if ((i18 >= i9 && i19 < i8) || ((i18 == (i10 = i9 + 1) && !changePair(i8, i19)) || i18 > i10 || (i18 + 1 >= i9 && i9 >= 3 && changePair(i19, i8)))) {
                return 1;
            }
        }
        int iMax = Math.max(i9 - 1, 2);
        for (int i20 = 0; i20 < 4; i20++) {
            if (this.lz.getMatchLen(this.reps[i20], iMax) == iMax) {
                return 1;
            }
        }
        this.back = i8 + 4;
        skip(i9 - 2);
        return i9;
    }
}
