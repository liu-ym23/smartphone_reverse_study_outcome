package org.tukaani.xz.lzma;

import a8.b;
import org.tukaani.xz.ArrayCache;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.lz.LZEncoder;
import org.tukaani.xz.lz.Matches;
import org.tukaani.xz.rangecoder.RangeEncoder;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
final class LZMAEncoderNormal extends LZMAEncoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int EXTRA_SIZE_AFTER = 4096;
    private static final int EXTRA_SIZE_BEFORE = 4096;
    private static final int OPTS = 4096;
    private Matches matches;
    private final State nextState;
    private int optCur;
    private int optEnd;
    private final Optimum[] opts;
    private final int[] repLens;

    public LZMAEncoderNormal(RangeEncoder rangeEncoder, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, ArrayCache arrayCache) {
        super(rangeEncoder, LZEncoder.getInstance(i11, Math.max(i12, 4096), 4096, i13, LZMA2Options.NICE_LEN_MAX, i14, i15, arrayCache), i8, i9, i10, i11, i13);
        this.opts = new Optimum[4096];
        this.optCur = 0;
        this.optEnd = 0;
        this.repLens = new int[4];
        this.nextState = new State();
        for (int i16 = 0; i16 < 4096; i16++) {
            this.opts[i16] = new Optimum();
        }
    }

    private void calc1BytePrices(int i8, int i9, int i10, int i11) {
        boolean z;
        int i12 = this.lz.getByte(0);
        int i13 = this.lz.getByte(this.opts[this.optCur].reps[0] + 1);
        int price = this.opts[this.optCur].price + this.literalEncoder.getPrice(i12, i13, this.lz.getByte(1), i8, this.opts[this.optCur].state);
        Optimum[] optimumArr = this.opts;
        int i14 = this.optCur;
        if (price < optimumArr[i14 + 1].price) {
            optimumArr[i14 + 1].set1(price, i14, -1);
            z = true;
        } else {
            z = false;
        }
        if (i13 == i12) {
            Optimum[] optimumArr2 = this.opts;
            int i15 = this.optCur;
            if (optimumArr2[i15 + 1].optPrev == i15 || optimumArr2[i15 + 1].backPrev != 0) {
                int shortRepPrice = getShortRepPrice(i11, optimumArr2[i15].state, i9);
                Optimum[] optimumArr3 = this.opts;
                int i16 = this.optCur;
                if (shortRepPrice <= optimumArr3[i16 + 1].price) {
                    optimumArr3[i16 + 1].set1(shortRepPrice, i16, 0);
                    z = true;
                }
            }
        }
        if (z || i13 == i12 || i10 <= 2) {
            return;
        }
        int matchLen = this.lz.getMatchLen(1, this.opts[this.optCur].reps[0], Math.min(this.niceLen, i10 - 1));
        if (matchLen >= 2) {
            this.nextState.set(this.opts[this.optCur].state);
            this.nextState.updateLiteral();
            int longRepAndLenPrice = getLongRepAndLenPrice(0, matchLen, this.nextState, (i8 + 1) & this.posMask) + price;
            int i17 = this.optCur + 1 + matchLen;
            while (true) {
                int i18 = this.optEnd;
                if (i18 >= i17) {
                    break;
                }
                Optimum[] optimumArr4 = this.opts;
                int i19 = i18 + 1;
                this.optEnd = i19;
                optimumArr4[i19].reset();
            }
            Optimum optimum = this.opts[i17];
            if (longRepAndLenPrice < optimum.price) {
                optimum.set2(longRepAndLenPrice, this.optCur, 0);
            }
        }
    }

    private int calcLongRepPrices(int i8, int i9, int i10, int i11) {
        int i12;
        int iMin = Math.min(i10, this.niceLen);
        int i13 = 2;
        for (int i14 = 0; i14 < 4; i14++) {
            int matchLen = this.lz.getMatchLen(this.opts[this.optCur].reps[i14], iMin);
            if (matchLen >= 2) {
                while (true) {
                    int i15 = this.optEnd;
                    i12 = this.optCur;
                    if (i15 >= i12 + matchLen) {
                        break;
                    }
                    Optimum[] optimumArr = this.opts;
                    int i16 = i15 + 1;
                    this.optEnd = i16;
                    optimumArr[i16].reset();
                }
                int longRepPrice = getLongRepPrice(i11, i14, this.opts[i12].state, i9);
                for (int i17 = matchLen; i17 >= 2; i17--) {
                    int price = this.repLenEncoder.getPrice(i17, i9) + longRepPrice;
                    Optimum[] optimumArr2 = this.opts;
                    int i18 = this.optCur;
                    if (price < optimumArr2[i18 + i17].price) {
                        optimumArr2[i18 + i17].set1(price, i18, i14);
                    }
                }
                if (i14 == 0) {
                    i13 = matchLen + 1;
                }
                int i19 = i13;
                int i20 = (i10 - matchLen) - 1;
                if (i20 >= 2) {
                    int i21 = this.niceLen;
                    if (i20 > i21) {
                        i20 = i21;
                    }
                    int matchLen2 = this.lz.getMatchLen(matchLen + 1, this.opts[this.optCur].reps[i14], i20);
                    if (matchLen2 >= 2) {
                        int price2 = longRepPrice + this.repLenEncoder.getPrice(matchLen, i9);
                        this.nextState.set(this.opts[this.optCur].state);
                        this.nextState.updateLongRep();
                        int i22 = i8 + matchLen;
                        int price3 = price2 + this.literalEncoder.getPrice(this.lz.getByte(matchLen, 0), this.lz.getByte(0), this.lz.getByte(matchLen, 1), i22, this.nextState);
                        this.nextState.updateLiteral();
                        int longRepAndLenPrice = price3 + getLongRepAndLenPrice(0, matchLen2, this.nextState, (i22 + 1) & this.posMask);
                        int iD = b.D(this.optCur, matchLen, 1, matchLen2);
                        while (true) {
                            int i23 = this.optEnd;
                            if (i23 >= iD) {
                                break;
                            }
                            Optimum[] optimumArr3 = this.opts;
                            int i24 = i23 + 1;
                            this.optEnd = i24;
                            optimumArr3[i24].reset();
                        }
                        Optimum optimum = this.opts[iD];
                        if (longRepAndLenPrice < optimum.price) {
                            optimum.set3(longRepAndLenPrice, this.optCur, i14, matchLen, 0);
                        }
                    }
                }
                i13 = i19;
            }
        }
        return i13;
    }

    private void calcNormalMatchPrices(int i8, int i9, int i10, int i11, int i12) {
        int i13;
        Matches matches;
        int[] iArr;
        int i14;
        Matches matches2 = this.matches;
        if (matches2.len[matches2.count - 1] > i10) {
            matches2.count = 0;
            while (true) {
                matches = this.matches;
                iArr = matches.len;
                i14 = matches.count;
                if (iArr[i14] >= i10) {
                    break;
                } else {
                    matches.count = i14 + 1;
                }
            }
            matches.count = i14 + 1;
            iArr[i14] = i10;
        }
        Matches matches3 = this.matches;
        if (matches3.len[matches3.count - 1] < i12) {
            return;
        }
        while (true) {
            int i15 = this.optEnd;
            i13 = this.optCur;
            Matches matches4 = this.matches;
            if (i15 >= matches4.len[matches4.count - 1] + i13) {
                break;
            }
            Optimum[] optimumArr = this.opts;
            int i16 = i15 + 1;
            this.optEnd = i16;
            optimumArr[i16].reset();
        }
        int normalMatchPrice = getNormalMatchPrice(i11, this.opts[i13].state);
        int i17 = 0;
        while (i12 > this.matches.len[i17]) {
            i17++;
        }
        int i18 = i12;
        while (true) {
            int i19 = this.matches.dist[i17];
            int matchAndLenPrice = getMatchAndLenPrice(normalMatchPrice, i19, i18, i9);
            Optimum[] optimumArr2 = this.opts;
            int i20 = this.optCur;
            if (matchAndLenPrice < optimumArr2[i20 + i18].price) {
                optimumArr2[i20 + i18].set1(matchAndLenPrice, i20, i19 + 4);
            }
            if (i18 == this.matches.len[i17]) {
                int i21 = (i10 - i18) - 1;
                if (i21 >= 2) {
                    int i22 = this.niceLen;
                    if (i21 > i22) {
                        i21 = i22;
                    }
                    int matchLen = this.lz.getMatchLen(i18 + 1, i19, i21);
                    if (matchLen >= 2) {
                        this.nextState.set(this.opts[this.optCur].state);
                        this.nextState.updateMatch();
                        int i23 = i8 + i18;
                        int price = matchAndLenPrice + this.literalEncoder.getPrice(this.lz.getByte(i18, 0), this.lz.getByte(0), this.lz.getByte(i18, 1), i23, this.nextState);
                        this.nextState.updateLiteral();
                        int longRepAndLenPrice = getLongRepAndLenPrice(0, matchLen, this.nextState, (i23 + 1) & this.posMask) + price;
                        int iD = b.D(this.optCur, i18, 1, matchLen);
                        while (true) {
                            int i24 = this.optEnd;
                            if (i24 >= iD) {
                                break;
                            }
                            Optimum[] optimumArr3 = this.opts;
                            int i25 = i24 + 1;
                            this.optEnd = i25;
                            optimumArr3[i25].reset();
                        }
                        Optimum optimum = this.opts[iD];
                        if (longRepAndLenPrice < optimum.price) {
                            optimum.set3(longRepAndLenPrice, this.optCur, i19 + 4, i18, 0);
                        }
                    }
                }
                i17++;
                if (i17 == this.matches.count) {
                    return;
                }
            }
            i18++;
        }
    }

    private int convertOpts() {
        int i8 = this.optCur;
        this.optEnd = i8;
        int i9 = this.opts[i8].optPrev;
        while (true) {
            Optimum[] optimumArr = this.opts;
            int i10 = this.optCur;
            Optimum optimum = optimumArr[i10];
            if (optimum.prev1IsLiteral) {
                Optimum optimum2 = optimumArr[i9];
                optimum2.optPrev = i10;
                optimum2.backPrev = -1;
                int i11 = i9 - 1;
                this.optCur = i9;
                if (optimum.hasPrev2) {
                    Optimum optimum3 = optimumArr[i11];
                    optimum3.optPrev = i9;
                    optimum3.backPrev = optimum.backPrev2;
                    this.optCur = i11;
                    i9 = optimum.optPrev2;
                } else {
                    i9 = i11;
                }
            }
            Optimum optimum4 = optimumArr[i9];
            int i12 = optimum4.optPrev;
            optimum4.optPrev = this.optCur;
            this.optCur = i9;
            if (i9 <= 0) {
                int i13 = optimumArr[0].optPrev;
                this.optCur = i13;
                this.back = optimumArr[i13].backPrev;
                return i13;
            }
            i9 = i12;
        }
    }

    public static int getMemoryUsage(int i8, int i9, int i10) {
        return LZEncoder.getMemoryUsage(i8, Math.max(i9, 4096), 4096, LZMA2Options.NICE_LEN_MAX, i10) + 256;
    }

    private void updateOptStateAndReps() {
        int i8;
        Optimum[] optimumArr = this.opts;
        Optimum optimum = optimumArr[this.optCur];
        int i9 = optimum.optPrev;
        if (optimum.prev1IsLiteral) {
            i9--;
            if (optimum.hasPrev2) {
                optimum.state.set(optimumArr[optimum.optPrev2].state);
                Optimum optimum2 = this.opts[this.optCur];
                if (optimum2.backPrev2 < 4) {
                    optimum2.state.updateLongRep();
                } else {
                    optimum2.state.updateMatch();
                }
            } else {
                optimum.state.set(optimumArr[i9].state);
            }
            this.opts[this.optCur].state.updateLiteral();
        } else {
            optimum.state.set(optimumArr[i9].state);
        }
        int i10 = this.optCur;
        if (i9 == i10 - 1) {
            Optimum optimum3 = this.opts[i10];
            if (optimum3.backPrev == 0) {
                optimum3.state.updateShortRep();
            } else {
                optimum3.state.updateLiteral();
            }
            Optimum[] optimumArr2 = this.opts;
            System.arraycopy(optimumArr2[i9].reps, 0, optimumArr2[this.optCur].reps, 0, 4);
            return;
        }
        Optimum optimum4 = this.opts[i10];
        if (optimum4.prev1IsLiteral && optimum4.hasPrev2) {
            i9 = optimum4.optPrev2;
            i8 = optimum4.backPrev2;
            optimum4.state.updateLongRep();
        } else {
            i8 = optimum4.backPrev;
            if (i8 < 4) {
                optimum4.state.updateLongRep();
            } else {
                optimum4.state.updateMatch();
            }
        }
        int i11 = 1;
        if (i8 >= 4) {
            Optimum[] optimumArr3 = this.opts;
            int[] iArr = optimumArr3[this.optCur].reps;
            iArr[0] = i8 - 4;
            System.arraycopy(optimumArr3[i9].reps, 0, iArr, 1, 3);
            return;
        }
        Optimum[] optimumArr4 = this.opts;
        optimumArr4[this.optCur].reps[0] = optimumArr4[i9].reps[i8];
        while (i11 <= i8) {
            Optimum[] optimumArr5 = this.opts;
            optimumArr5[this.optCur].reps[i11] = optimumArr5[i9].reps[i11 - 1];
            i11++;
        }
        while (i11 < 4) {
            Optimum[] optimumArr6 = this.opts;
            optimumArr6[this.optCur].reps[i11] = optimumArr6[i9].reps[i11];
            i11++;
        }
    }

    @Override // org.tukaani.xz.lzma.LZMAEncoder
    public int getNextSymbol() {
        int i8;
        int i9;
        LZMAEncoderNormal lZMAEncoderNormal = this;
        int i10 = lZMAEncoderNormal.optCur;
        if (i10 < lZMAEncoderNormal.optEnd) {
            Optimum[] optimumArr = lZMAEncoderNormal.opts;
            int i11 = optimumArr[i10].optPrev;
            int i12 = i11 - i10;
            lZMAEncoderNormal.optCur = i11;
            lZMAEncoderNormal.back = optimumArr[i11].backPrev;
            return i12;
        }
        lZMAEncoderNormal.optCur = 0;
        lZMAEncoderNormal.optEnd = 0;
        lZMAEncoderNormal.back = -1;
        if (lZMAEncoderNormal.readAhead == -1) {
            lZMAEncoderNormal.matches = lZMAEncoderNormal.getMatches();
        }
        int iMin = Math.min(lZMAEncoderNormal.lz.getAvail(), LZMA2Options.NICE_LEN_MAX);
        if (iMin < 2) {
            return 1;
        }
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (i13 >= 4) {
                break;
            }
            lZMAEncoderNormal.repLens[i13] = lZMAEncoderNormal.lz.getMatchLen(lZMAEncoderNormal.reps[i13], iMin);
            int[] iArr = lZMAEncoderNormal.repLens;
            int i15 = iArr[i13];
            if (i15 < 2) {
                iArr[i13] = 0;
            } else if (i15 > iArr[i14]) {
                i14 = i13;
            }
            i13++;
        }
        int i16 = lZMAEncoderNormal.repLens[i14];
        int i17 = lZMAEncoderNormal.niceLen;
        if (i16 >= i17) {
            lZMAEncoderNormal.back = i14;
            lZMAEncoderNormal.skip(i16 - 1);
            return lZMAEncoderNormal.repLens[i14];
        }
        Matches matches = lZMAEncoderNormal.matches;
        int i18 = matches.count;
        if (i18 > 0) {
            i9 = matches.len[i18 - 1];
            int i19 = matches.dist[i18 - 1];
            if (i9 >= i17) {
                lZMAEncoderNormal.back = i19 + 4;
                lZMAEncoderNormal.skip(i9 - 1);
                return i9;
            }
        } else {
            i9 = 0;
        }
        int i20 = lZMAEncoderNormal.lz.getByte(0);
        int i21 = lZMAEncoderNormal.lz.getByte(lZMAEncoderNormal.reps[0] + 1);
        if (i9 < 2 && i20 != i21 && lZMAEncoderNormal.repLens[i14] < 2) {
            return 1;
        }
        int pos = lZMAEncoderNormal.lz.getPos();
        int i22 = lZMAEncoderNormal.posMask & pos;
        lZMAEncoderNormal.opts[1].set1(lZMAEncoderNormal.literalEncoder.getPrice(i20, i21, lZMAEncoderNormal.lz.getByte(1), pos, lZMAEncoderNormal.state), 0, -1);
        int anyMatchPrice = lZMAEncoderNormal.getAnyMatchPrice(lZMAEncoderNormal.state, i22);
        int anyRepPrice = lZMAEncoderNormal.getAnyRepPrice(anyMatchPrice, lZMAEncoderNormal.state);
        if (i21 == i20) {
            int shortRepPrice = lZMAEncoderNormal.getShortRepPrice(anyRepPrice, lZMAEncoderNormal.state, i22);
            Optimum optimum = lZMAEncoderNormal.opts[1];
            if (shortRepPrice < optimum.price) {
                optimum.set1(shortRepPrice, 0, 0);
            }
        }
        int iMax = Math.max(i9, lZMAEncoderNormal.repLens[i14]);
        lZMAEncoderNormal.optEnd = iMax;
        if (iMax < 2) {
            lZMAEncoderNormal.back = lZMAEncoderNormal.opts[1].backPrev;
            return 1;
        }
        lZMAEncoderNormal.updatePrices();
        lZMAEncoderNormal.opts[0].state.set(lZMAEncoderNormal.state);
        System.arraycopy(lZMAEncoderNormal.reps, 0, lZMAEncoderNormal.opts[0].reps, 0, 4);
        for (int i23 = lZMAEncoderNormal.optEnd; i23 >= 2; i23--) {
            lZMAEncoderNormal.opts[i23].reset();
        }
        int i24 = 0;
        for (i8 = 4; i24 < i8; i8 = 4) {
            int i25 = lZMAEncoderNormal.repLens[i24];
            if (i25 >= 2) {
                int longRepPrice = lZMAEncoderNormal.getLongRepPrice(anyRepPrice, i24, lZMAEncoderNormal.state, i22);
                do {
                    int price = lZMAEncoderNormal.repLenEncoder.getPrice(i25, i22) + longRepPrice;
                    Optimum optimum2 = lZMAEncoderNormal.opts[i25];
                    if (price < optimum2.price) {
                        optimum2.set1(price, 0, i24);
                    }
                    i25--;
                } while (i25 >= 2);
            }
            i24++;
        }
        int iMax2 = Math.max(lZMAEncoderNormal.repLens[0] + 1, 2);
        if (iMax2 <= i9) {
            int normalMatchPrice = lZMAEncoderNormal.getNormalMatchPrice(anyMatchPrice, lZMAEncoderNormal.state);
            int i26 = 0;
            while (iMax2 > lZMAEncoderNormal.matches.len[i26]) {
                i26++;
            }
            while (true) {
                int i27 = lZMAEncoderNormal.matches.dist[i26];
                int matchAndLenPrice = lZMAEncoderNormal.getMatchAndLenPrice(normalMatchPrice, i27, iMax2, i22);
                Optimum optimum3 = lZMAEncoderNormal.opts[iMax2];
                if (matchAndLenPrice < optimum3.price) {
                    optimum3.set1(matchAndLenPrice, 0, i27 + 4);
                }
                Matches matches2 = lZMAEncoderNormal.matches;
                if (iMax2 == matches2.len[i26] && (i26 = i26 + 1) == matches2.count) {
                    break;
                }
                iMax2++;
            }
        }
        int iMin2 = Math.min(lZMAEncoderNormal.lz.getAvail(), 4095);
        while (true) {
            int i28 = lZMAEncoderNormal.optCur + 1;
            lZMAEncoderNormal.optCur = i28;
            if (i28 >= lZMAEncoderNormal.optEnd) {
                break;
            }
            Matches matches3 = lZMAEncoderNormal.getMatches();
            lZMAEncoderNormal.matches = matches3;
            int i29 = matches3.count;
            if (i29 > 0 && matches3.len[i29 - 1] >= lZMAEncoderNormal.niceLen) {
                break;
            }
            int i30 = iMin2 - 1;
            int i31 = pos + 1;
            int i32 = lZMAEncoderNormal.posMask & i31;
            lZMAEncoderNormal.updateOptStateAndReps();
            Optimum optimum4 = lZMAEncoderNormal.opts[lZMAEncoderNormal.optCur];
            int anyMatchPrice2 = lZMAEncoderNormal.getAnyMatchPrice(optimum4.state, i32) + optimum4.price;
            int anyRepPrice2 = lZMAEncoderNormal.getAnyRepPrice(anyMatchPrice2, lZMAEncoderNormal.opts[lZMAEncoderNormal.optCur].state);
            lZMAEncoderNormal.calc1BytePrices(i31, i32, i30, anyRepPrice2);
            if (i30 >= 2) {
                int iCalcLongRepPrices = lZMAEncoderNormal.calcLongRepPrices(i31, i32, i30, anyRepPrice2);
                if (lZMAEncoderNormal.matches.count > 0) {
                    lZMAEncoderNormal.calcNormalMatchPrices(i31, i32, i30, anyMatchPrice2, iCalcLongRepPrices);
                }
            }
            lZMAEncoderNormal = this;
            pos = i31;
            iMin2 = i30;
        }
        return convertOpts();
    }

    @Override // org.tukaani.xz.lzma.LZMAEncoder, org.tukaani.xz.lzma.LZMACoder
    public void reset() {
        this.optCur = 0;
        this.optEnd = 0;
        super.reset();
    }
}
