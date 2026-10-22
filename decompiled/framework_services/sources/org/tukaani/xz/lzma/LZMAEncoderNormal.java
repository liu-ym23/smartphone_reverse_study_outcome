package org.tukaani.xz.lzma;

import org.apache.commons.compress.archivers.zip.UnixStat;
import org.tukaani.xz.ArrayCache;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.lz.LZEncoder;
import org.tukaani.xz.lz.Matches;
import org.tukaani.xz.rangecoder.RangeEncoder;

/* JADX INFO: loaded from: classes3.dex */
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

    static {
    }

    static int getMemoryUsage(int dictSize, int extraSizeBefore, int mf) {
        return LZEncoder.getMemoryUsage(dictSize, Math.max(extraSizeBefore, 4096), 4096, LZMA2Options.NICE_LEN_MAX, mf) + 256;
    }

    LZMAEncoderNormal(RangeEncoder rc, int lc, int lp, int pb, int dictSize, int extraSizeBefore, int niceLen, int mf, int depthLimit, ArrayCache arrayCache) {
        super(rc, LZEncoder.getInstance(dictSize, Math.max(extraSizeBefore, 4096), 4096, niceLen, LZMA2Options.NICE_LEN_MAX, mf, depthLimit, arrayCache), lc, lp, pb, dictSize, niceLen);
        this.opts = new Optimum[4096];
        this.optCur = 0;
        this.optEnd = 0;
        this.repLens = new int[4];
        this.nextState = new State();
        int i = 0;
    L3:
        if (i >= 4096) goto L6;
        this.opts[i] = new Optimum();
        i = i + 1;
        goto L3
    }

    @Override // org.tukaani.xz.lzma.LZMAEncoder, org.tukaani.xz.lzma.LZMACoder
    public void reset() {
        this.optCur = 0;
        this.optEnd = 0;
        super.reset();
    }

    private int convertOpts() {
        this.optEnd = this.optCur;
        int optPrev = this.opts[this.optCur].optPrev;
    L3:
        Optimum opt = this.opts[this.optCur];
        if (opt.prev1IsLiteral == false) goto L9;
        this.opts[optPrev].optPrev = this.optCur;
        this.opts[optPrev].backPrev = -1;
        int optPrev2 = optPrev - 1;
        this.optCur = optPrev;
        if (opt.hasPrev2 == false) goto L8;
        this.opts[optPrev2].optPrev = optPrev2 + 1;
        this.opts[optPrev2].backPrev = opt.backPrev2;
        this.optCur = optPrev2;
        optPrev = opt.optPrev2;
        goto L9
    L8:
        optPrev = optPrev2;
    L9:
        int temp = this.opts[optPrev].optPrev;
        this.opts[optPrev].optPrev = this.optCur;
        this.optCur = optPrev;
        optPrev = temp;
        if (this.optCur > 0) goto L3;
        this.optCur = this.opts[0].optPrev;
        this.back = this.opts[this.optCur].backPrev;
        return this.optCur;
    }

    @Override // org.tukaani.xz.lzma.LZMAEncoder
    int getNextSymbol() {
        LZMAEncoderNormal r0 = this;
        if (r0.optCur >= r0.optEnd) goto L6;
        int len = r0.opts[r0.optCur].optPrev - r0.optCur;
        r0.optCur = r0.opts[r0.optCur].optPrev;
        r0.back = r0.opts[r0.optCur].backPrev;
        return len;
    L6:
        r0.optCur = 0;
        r0.optEnd = 0;
        r0.back = -1;
        if (r0.readAhead != (-1)) goto L9;
        r0.matches = r0.getMatches();
    L9:
        int avail = Math.min(r0.lz.getAvail(), LZMA2Options.NICE_LEN_MAX);
        int r6 = 2;
        if (avail >= 2) goto L12;
        return 1;
    L12:
        int rep = 0;
        int repBest = 0;
    L13:
        int repBest2 = 4;
        if (rep >= 4) goto L23;
        r0.repLens[rep] = r0.lz.getMatchLen(r0.reps[rep], avail);
        if (r0.repLens[rep] >= 2) goto L19;
        r0.repLens[rep] = 0;
    L21:
        rep = rep + 1;
        goto L13
    L19:
        if (r0.repLens[rep] <= r0.repLens[repBest]) goto L21;
        repBest = rep;
        goto L21
    L23:
        if (r0.repLens[repBest] < r0.niceLen) goto L27;
        r0.back = repBest;
        r0.skip(r0.repLens[repBest] - 1);
        return r0.repLens[repBest];
    L27:
        if (r0.matches.count <= 0) goto L33;
        int mainLen = r0.matches.len[r0.matches.count - 1];
        int mainDist = r0.matches.dist[r0.matches.count - 1];
        if (mainLen < r0.niceLen) goto L32;
        r0.back = mainDist + 4;
        r0.skip(mainLen - 1);
        return mainLen;
    L32:
        int mainDist2 = mainLen;
    L34:
        int curByte = r0.lz.getByte(0);
        int matchByte = r0.lz.getByte(r0.reps[0] + 1);
        if (mainDist2 >= 2) goto L40;
        if (curByte == matchByte) goto L40;
        if (r0.repLens[repBest] >= 2) goto L40;
        return 1;
    L40:
        int pos = r0.lz.getPos();
        int posState = r0.posMask & pos;
        int prevByte = r0.lz.getByte(1);
        int literalPrice = r0.literalEncoder.getPrice(curByte, matchByte, prevByte, pos, r0.state);
        r0.opts[1].set1(literalPrice, 0, -1);
        int anyMatchPrice = r0.getAnyMatchPrice(r0.state, posState);
        int anyRepPrice = r0.getAnyRepPrice(anyMatchPrice, r0.state);
        if (matchByte != curByte) goto L45;
        int shortRepPrice = r0.getShortRepPrice(anyRepPrice, r0.state, posState);
        if (shortRepPrice >= r0.opts[1].price) goto L45;
        r0.opts[1].set1(shortRepPrice, 0, 0);
    L45:
        r0.optEnd = Math.max(mainDist2, r0.repLens[repBest]);
        if (r0.optEnd >= 2) goto L49;
        r0.back = r0.opts[1].backPrev;
        return 1;
    L49:
        r0.updatePrices();
        r0.opts[0].state.set(r0.state);
        System.arraycopy(r0.reps, 0, r0.opts[0].reps, 0, 4);
        int i = r0.optEnd;
    L50:
        if (i < 2) goto L52;
        r0.opts[i].reset();
        i = i - 1;
        goto L50
    L52:
        int rep2 = 0;
    L53:
        if (rep2 >= repBest2) goto L66;
        int repLen = r0.repLens[rep2];
        if (repLen >= r6) goto L57;
        avail = avail;
    L64:
        rep2 = rep2 + 1;
        avail = avail;
        repBest2 = 4;
        r6 = 2;
        goto L53
    L57:
        int longRepPrice = r0.getLongRepPrice(anyRepPrice, rep2, r0.state, posState);
    L58:
        int price = r0.repLenEncoder.getPrice(repLen, posState) + longRepPrice;
        if (price >= r0.opts[repLen].price) goto L62;
        r0.opts[repLen].set1(price, 0, rep2);
    L62:
        repLen = repLen - 1;
        if (repLen < 2) goto L64;
        avail = avail;
        goto L58
    L66:
        int len2 = Math.max(r0.repLens[0] + 1, 2);
        if (len2 > mainDist2) goto L82;
        int normalMatchPrice = r0.getNormalMatchPrice(anyMatchPrice, r0.state);
        int i2 = 0;
    L70:
        if (len2 <= r0.matches.len[i2]) goto L72;
        i2 = i2 + 1;
    L72:
        int dist = r0.matches.dist[i2];
        int price2 = r0.getMatchAndLenPrice(normalMatchPrice, dist, len2, posState);
        if (price2 >= r0.opts[len2].price) goto L77;
        r0.opts[len2].set1(price2, 0, dist + 4);
    L77:
        if (len2 != r0.matches.len[i2]) goto L81;
        i2 = i2 + 1;
        if (i2 != r0.matches.count) goto L81;
    L83:
        int pos2 = Math.min(r0.lz.getAvail(), UnixStat.PERM_MASK);
    L84:
        int r3 = r0.optCur + 1;
        r0.optCur = r3;
        if (r3 >= r0.optEnd) goto L101;
        r0.matches = r0.getMatches();
        if (r0.matches.count > 0) goto L89;
    L91:
        int avail2 = pos2 - 1;
        int avail3 = pos + 1;
        int posState2 = r0.posMask & avail3;
        r0.updateOptStateAndReps();
        int anyMatchPrice2 = r0.opts[r0.optCur].price + r0.getAnyMatchPrice(r0.opts[r0.optCur].state, posState2);
        int anyRepPrice2 = r0.getAnyRepPrice(anyMatchPrice2, r0.opts[r0.optCur].state);
        r0.calc1BytePrices(avail3, posState2, avail2, anyRepPrice2);
        if (avail2 < 2) goto L99;
        int startLen = r0.calcLongRepPrices(avail3, posState2, avail2, anyRepPrice2);
        if (r0.matches.count <= 0) goto L99;
        r0.calcNormalMatchPrices(avail3, posState2, avail2, anyMatchPrice2, startLen);
    L99:
        r0 = this;
        pos = avail3;
        pos2 = avail2;
        goto L84
    L89:
        if (r0.matches.len[r0.matches.count - 1] < r0.niceLen) goto L91;
    L101:
        return convertOpts();
    L81:
        len2 = len2 + 1;
        anyMatchPrice = anyMatchPrice;
        normalMatchPrice = normalMatchPrice;
        goto L72
    L82:
        anyMatchPrice = anyMatchPrice;
        goto L83
    L33:
        mainDist2 = 0;
        goto L34
    }

    private void updateOptStateAndReps() {
        int optPrev = this.opts[this.optCur].optPrev;
        if (this.opts[this.optCur].prev1IsLiteral == false) goto L12;
        optPrev = optPrev - 1;
        if (this.opts[this.optCur].hasPrev2 == false) goto L10;
        this.opts[this.optCur].state.set(this.opts[this.opts[this.optCur].optPrev2].state);
        if (this.opts[this.optCur].backPrev2 >= 4) goto L9;
        this.opts[this.optCur].state.updateLongRep();
    L11:
        this.opts[this.optCur].state.updateLiteral();
    L14:
        if (optPrev != (this.optCur - 1)) goto L21;
        if (this.opts[this.optCur].backPrev != 0) goto L18;
        this.opts[this.optCur].state.updateShortRep();
    L19:
        System.arraycopy(this.opts[optPrev].reps, 0, this.opts[this.optCur].reps, 0, 4);
        return;
    L18:
        this.opts[this.optCur].state.updateLiteral();
        goto L19
    L21:
        if (this.opts[this.optCur].prev1IsLiteral == true) goto L23;
    L25:
        int back = this.opts[this.optCur].backPrev;
        if (back >= 4) goto L28;
        this.opts[this.optCur].state.updateLongRep();
    L29:
        if (back >= 4) goto L36;
        this.opts[this.optCur].reps[0] = this.opts[optPrev].reps[back];
        int rep = 1;
    L31:
        if (rep > back) goto L33;
        this.opts[this.optCur].reps[rep] = this.opts[optPrev].reps[rep - 1];
        rep = rep + 1;
    L33:
        if (rep >= 4) goto L41;
        this.opts[this.optCur].reps[rep] = this.opts[optPrev].reps[rep];
        rep = rep + 1;
        goto L33
    L41:
        return;
    L36:
        this.opts[this.optCur].reps[0] = back - 4;
        System.arraycopy(this.opts[optPrev].reps, 0, this.opts[this.optCur].reps, 1, 3);
        return;
    L28:
        this.opts[this.optCur].state.updateMatch();
        goto L29
    L23:
        if (this.opts[this.optCur].hasPrev2 == false) goto L25;
        optPrev = this.opts[this.optCur].optPrev2;
        back = this.opts[this.optCur].backPrev2;
        this.opts[this.optCur].state.updateLongRep();
        goto L29
    L9:
        this.opts[this.optCur].state.updateMatch();
        goto L11
    L10:
        this.opts[this.optCur].state.set(this.opts[optPrev].state);
        goto L11
    L12:
        this.opts[this.optCur].state.set(this.opts[optPrev].state);
        goto L14
    }

    private void calc1BytePrices(int pos, int posState, int avail, int anyRepPrice) {
        boolean nextIsByte = false;
        int curByte = this.lz.getByte(0);
        boolean r11 = true;
        int matchByte = this.lz.getByte(this.opts[this.optCur].reps[0] + 1);
        int literalPrice = this.opts[this.optCur].price + this.literalEncoder.getPrice(curByte, matchByte, this.lz.getByte(1), pos, this.opts[this.optCur].state);
        if (literalPrice >= this.opts[this.optCur + 1].price) goto L5;
        this.opts[this.optCur + 1].set1(literalPrice, this.optCur, -1);
        nextIsByte = true;
    L5:
        if (matchByte != curByte) goto L16;
        if (this.opts[this.optCur + 1].optPrev != this.optCur) goto L9;
    L12:
        int shortRepPrice = getShortRepPrice(anyRepPrice, this.opts[this.optCur].state, posState);
        if (shortRepPrice > this.opts[this.optCur + 1].price) goto L16;
        this.opts[this.optCur + 1].set1(shortRepPrice, this.optCur, 0);
        nextIsByte = true;
        goto L16
    L9:
        if (this.opts[this.optCur + 1].backPrev != 0) goto L12;
    L16:
        if (nextIsByte == true) goto L31;
        if (matchByte != curByte) goto L19;
        return;
    L19:
        if (avail <= 2) goto L33;
        int lenLimit = Math.min(this.niceLen, avail - 1);
        int len = this.lz.getMatchLen(1, this.opts[this.optCur].reps[0], lenLimit);
        if (len < 2) goto L34;
        this.nextState.set(this.opts[this.optCur].state);
        this.nextState.updateLiteral();
        int nextPosState = (pos + 1) & this.posMask;
        int price = getLongRepAndLenPrice(0, len, this.nextState, nextPosState) + literalPrice;
        int i = (this.optCur + 1) + len;
    L24:
        if (this.optEnd >= i) goto L27;
        Optimum[] r15 = this.opts;
        boolean r16 = r11;
        int r12 = this.optEnd + 1;
        this.optEnd = r12;
        r15[r12].reset();
        r11 = r16;
        goto L24
    L27:
        if (price >= this.opts[i].price) goto L35;
        this.opts[i].set2(price, this.optCur, 0);
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    }

    private int calcLongRepPrices(int pos, int posState, int avail, int anyRepPrice) {
        int startLen = 2;
        int lenLimit = Math.min(avail, this.niceLen);
        int rep = 0;
    L4:
        if (rep >= 4) goto L32;
        int len = this.lz.getMatchLen(this.opts[this.optCur].reps[rep], lenLimit);
        if (len < 2) goto L30;
    L8:
        boolean r10 = true;
        if (this.optEnd >= (this.optCur + len)) goto L11;
        Optimum[] r6 = this.opts;
        int r7 = this.optEnd + 1;
        this.optEnd = r7;
        r6[r7].reset();
        goto L8
    L11:
        int longRepPrice = getLongRepPrice(anyRepPrice, rep, this.opts[this.optCur].state, posState);
        int i = len;
    L12:
        if (i < 2) goto L18;
        int price = this.repLenEncoder.getPrice(i, posState) + longRepPrice;
        if (price >= this.opts[this.optCur + i].price) goto L16;
        this.opts[this.optCur + i].set1(price, this.optCur, rep);
    L16:
        i = i - 1;
        goto L12
    L18:
        if (rep != 0) goto L20;
        startLen = len + 1;
    L20:
        int len2Limit = Math.min(this.niceLen, (avail - len) - 1);
        int len2 = this.lz.getMatchLen(len + 1, this.opts[this.optCur].reps[rep], len2Limit);
        if (len2 < 2) goto L30;
        int price2 = this.repLenEncoder.getPrice(len, posState) + longRepPrice;
        this.nextState.set(this.opts[this.optCur].state);
        this.nextState.updateLongRep();
        int curByte = this.lz.getByte(len, 0);
        int matchByte = this.lz.getByte(0);
        int prevByte = this.lz.getByte(len, 1);
        int price3 = price2 + this.literalEncoder.getPrice(curByte, matchByte, prevByte, pos + len, this.nextState);
        this.nextState.updateLiteral();
        int nextPosState = this.posMask & ((pos + len) + 1);
        int price4 = getLongRepAndLenPrice(0, len2, this.nextState, nextPosState) + price3;
        int price5 = this.optCur;
        int i2 = ((price5 + len) + 1) + len2;
    L24:
        if (this.optEnd >= i2) goto L27;
        Optimum[] r8 = this.opts;
        boolean r19 = r10;
        int r11 = this.optEnd + 1;
        this.optEnd = r11;
        r8[r11].reset();
        r10 = r19;
        goto L24
    L27:
        if (price4 >= this.opts[i2].price) goto L30;
        this.opts[i2].set3(price4, this.optCur, rep, len, 0);
    L30:
        rep = rep + 1;
        goto L4
    L32:
        return startLen;
    }

    private void calcNormalMatchPrices(int pos, int posState, int avail, int anyMatchPrice, int startLen) {
        int r1 = avail;
        int len2 = 1;
        int r4 = 0;
        if (this.matches.len[this.matches.count - 1] <= r1) goto L10;
        this.matches.count = 0;
    L6:
        if (this.matches.len[this.matches.count] >= r1) goto L8;
        this.matches.count++;
        goto L6
    L8:
        int[] r3 = this.matches.len;
        Matches r6 = this.matches;
        int r7 = r6.count;
        r6.count = r7 + 1;
        r3[r7] = r1;
    L10:
        if (this.matches.len[this.matches.count - 1] >= startLen) goto L13;
        return;
    L13:
        if (this.optEnd >= (this.optCur + this.matches.len[this.matches.count - 1])) goto L15;
        Optimum[] r5 = this.opts;
        int r8 = this.optEnd + 1;
        this.optEnd = r8;
        r5[r8].reset();
        goto L13
    L15:
        int normalMatchPrice = getNormalMatchPrice(anyMatchPrice, this.opts[this.optCur].state);
        int match = 0;
    L17:
        if (startLen <= this.matches.len[match]) goto L19;
        match = match + 1;
        goto L17
    L19:
        int len = startLen;
    L20:
        int dist = this.matches.dist[match];
        int matchAndLenPrice = getMatchAndLenPrice(normalMatchPrice, dist, len, posState);
        if (matchAndLenPrice >= this.opts[this.optCur + len].price) goto L24;
        this.opts[this.optCur + len].set1(matchAndLenPrice, this.optCur, dist + 4);
    L24:
        if (len == this.matches.len[match]) goto L26;
        int r16 = len2;
    L40:
        len = len + 1;
        r1 = avail;
        len2 = r16;
        r4 = 0;
        goto L20
    L26:
        int len2Limit = Math.min(this.niceLen, (r1 - len) - len2);
        int len3 = this.lz.getMatchLen(len + 1, dist, len2Limit);
        if (len3 < 2) goto L36;
        this.nextState.set(this.opts[this.optCur].state);
        this.nextState.updateMatch();
        int curByte = this.lz.getByte(len, r4);
        int matchByte = this.lz.getByte(r4);
        int prevByte = this.lz.getByte(len, 1);
        int price = this.literalEncoder.getPrice(curByte, matchByte, prevByte, pos + len, this.nextState) + matchAndLenPrice;
        this.nextState.updateLiteral();
        r16 = 1;
        int nextPosState = ((pos + len) + 1) & this.posMask;
        int price2 = price + getLongRepAndLenPrice(r4, len3, this.nextState, nextPosState);
        int i = ((this.optCur + len) + 1) + len3;
    L30:
        if (this.optEnd >= i) goto L33;
        Optimum[] r9 = this.opts;
        int r2 = this.optEnd + 1;
        this.optEnd = r2;
        r9[r2].reset();
        goto L30
    L33:
        if (price2 >= this.opts[i].price) goto L37;
        Optimum r10 = this.opts[i];
        int len4 = this.optCur;
        int nextPosState2 = dist + 4;
        r10.set3(price2, len4, nextPosState2, len, 0);
    L37:
        match = match + 1;
        if (match != this.matches.count) goto L40;
        return;
    L36:
        r16 = len2;
        goto L37
    }
}
