package org.tukaani.xz.lzma;

import org.tukaani.xz.ArrayCache;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.lz.LZEncoder;
import org.tukaani.xz.lz.Matches;
import org.tukaani.xz.rangecoder.RangeEncoder;

/* JADX INFO: loaded from: classes3.dex */
final class LZMAEncoderFast extends LZMAEncoder {
    private static final int EXTRA_SIZE_AFTER = 272;
    private static final int EXTRA_SIZE_BEFORE = 1;
    private Matches matches;

    static int getMemoryUsage(int dictSize, int extraSizeBefore, int mf) {
        return LZEncoder.getMemoryUsage(dictSize, Math.max(extraSizeBefore, 1), 272, LZMA2Options.NICE_LEN_MAX, mf);
    }

    LZMAEncoderFast(RangeEncoder rc, int lc, int lp, int pb, int dictSize, int extraSizeBefore, int niceLen, int mf, int depthLimit, ArrayCache arrayCache) {
        super(rc, LZEncoder.getInstance(dictSize, Math.max(extraSizeBefore, 1), 272, niceLen, LZMA2Options.NICE_LEN_MAX, mf, depthLimit, arrayCache), lc, lp, pb, dictSize, niceLen);
        this.matches = null;
    }

    private boolean changePair(int smallDist, int bigDist) {
        if (smallDist >= (bigDist >>> 7)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // org.tukaani.xz.lzma.LZMAEncoder
    int getNextSymbol() {
        if (this.readAhead != (-1)) goto L5;
        this.matches = getMatches();
    L5:
        this.back = -1;
        int avail = Math.min(this.lz.getAvail(), LZMA2Options.NICE_LEN_MAX);
        if (avail >= 2) goto L8;
        return 1;
    L8:
        int bestRepLen = 0;
        int bestRepIndex = 0;
        int rep = 0;
    L10:
        if (rep >= 4) goto L21;
        int len = this.lz.getMatchLen(this.reps[rep], avail);
        if (len < 2) goto L20;
        if (len >= this.niceLen) goto L16;
        if (len <= bestRepLen) goto L20;
        bestRepIndex = rep;
        bestRepLen = len;
        goto L20
    L16:
        this.back = rep;
        skip(len - 1);
        return len;
    L20:
        rep = rep + 1;
        goto L10
    L21:
        int mainLen = 0;
        int mainDist = 0;
        if (this.matches.count <= 0) goto L39;
        mainLen = this.matches.len[this.matches.count - 1];
        mainDist = this.matches.dist[this.matches.count - 1];
        if (mainLen < this.niceLen) goto L28;
        this.back = mainDist + 4;
        skip(mainLen - 1);
        return mainLen;
    L28:
        if (this.matches.count <= 1) goto L35;
        if (mainLen != (this.matches.len[this.matches.count - 2] + 1)) goto L35;
        if (changePair(this.matches.dist[this.matches.count - 2], mainDist) == false) goto L35;
        this.matches.count--;
        mainLen = this.matches.len[this.matches.count - 1];
        mainDist = this.matches.dist[this.matches.count - 1];
    L35:
        if (mainLen != 2) goto L39;
        if (mainDist < 128) goto L39;
        mainLen = 1;
    L39:
        if (bestRepLen >= 2) goto L41;
    L52:
        if (mainLen < 2) goto L81;
        if (avail <= 2) goto L81;
        this.matches = getMatches();
        if (this.matches.count <= 0) goto L73;
        int newLen = this.matches.len[this.matches.count - 1];
        int newDist = this.matches.dist[this.matches.count - 1];
        if (newLen < mainLen) goto L61;
        if (newDist >= mainDist) goto L61;
    L72:
        return 1;
    L61:
        if (newLen != (mainLen + 1)) goto L65;
        if (changePair(mainDist, newDist) == false) goto L72;
    L65:
        if (newLen > (mainLen + 1)) goto L72;
        if ((newLen + 1) < mainLen) goto L73;
        if (mainLen < 3) goto L73;
        if (changePair(newDist, mainDist) == true) goto L72;
    L73:
        int limit = Math.max(mainLen - 1, 2);
        int rep2 = 0;
    L74:
        if (rep2 >= 4) goto L79;
        if (this.lz.getMatchLen(this.reps[rep2], limit) == limit) goto L77;
        rep2 = rep2 + 1;
        goto L74
    L77:
        return 1;
    L79:
        this.back = mainDist + 4;
        skip(mainLen - 2);
        return mainLen;
    L81:
        return 1;
    L41:
        if ((bestRepLen + 1) < mainLen) goto L43;
    L50:
        this.back = bestRepIndex;
        skip(bestRepLen - 1);
        return bestRepLen;
    L43:
        if ((bestRepLen + 2) < mainLen) goto L47;
        if (mainDist >= 512) goto L50;
    L47:
        if ((bestRepLen + 3) < mainLen) goto L52;
        if (mainDist < 32768) goto L52;
        goto L50
    }
}
