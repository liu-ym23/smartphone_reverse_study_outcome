package org.tukaani.xz.lz;

import org.tukaani.xz.ArrayCache;

/* JADX INFO: loaded from: classes3.dex */
final class HC4 extends LZEncoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final int[] chain;
    private int cyclicPos;
    private final int cyclicSize;
    private final int depthLimit;
    private final Hash234 hash;
    private int lzPos;
    private final Matches matches;

    static {
    }

    static int getMemoryUsage(int dictSize) {
        return (Hash234.getMemoryUsage(dictSize) + (dictSize / 256)) + 10;
    }

    HC4(int dictSize, int beforeSizeMin, int readAheadMax, int niceLen, int matchLenMax, int depthLimit, ArrayCache arrayCache) {
        super(dictSize, beforeSizeMin, readAheadMax, niceLen, matchLenMax, arrayCache);
        this.cyclicPos = -1;
        this.hash = new Hash234(dictSize, arrayCache);
        this.cyclicSize = dictSize + 1;
        this.chain = arrayCache.getIntArray(this.cyclicSize, false);
        this.lzPos = this.cyclicSize;
        this.matches = new Matches(niceLen - 1);
        if (depthLimit <= 0) goto L5;
        int r11 = depthLimit;
    L6:
        this.depthLimit = r11;
        return;
    L5:
        r11 = (niceLen / 4) + 4;
        goto L6
    }

    @Override // org.tukaani.xz.lz.LZEncoder
    public void putArraysToCache(ArrayCache arrayCache) {
        arrayCache.putArray(this.chain);
        this.hash.putArraysToCache(arrayCache);
        super.putArraysToCache(arrayCache);
    }

    private int movePos() {
        int avail = movePos(4, 4);
        if (avail == 0) goto L10;
        int r1 = this.lzPos + 1;
        this.lzPos = r1;
        if (r1 != Integer.MAX_VALUE) goto L7;
        int normalizationOffset = Integer.MAX_VALUE - this.cyclicSize;
        this.hash.normalize(normalizationOffset);
        LZEncoder.normalize(this.chain, this.cyclicSize, normalizationOffset);
        this.lzPos -= normalizationOffset;
    L7:
        int r2 = this.cyclicPos + 1;
        this.cyclicPos = r2;
        if (r2 != this.cyclicSize) goto L10;
        this.cyclicPos = 0;
    L10:
        return avail;
    }

    @Override // org.tukaani.xz.lz.LZEncoder
    public Matches getMatches() {
        this.matches.count = 0;
        int matchLenLimit = this.matchLenMax;
        int niceLenLimit = this.niceLen;
        int avail = movePos();
        if (avail >= matchLenLimit) goto L10;
        if (avail == 0) goto L6;
        matchLenLimit = avail;
        if (niceLenLimit <= avail) goto L10;
        niceLenLimit = avail;
        goto L10
    L6:
        return this.matches;
    L10:
        this.hash.calcHashes(this.buf, this.readPos);
        int delta2 = this.lzPos - this.hash.getHash2Pos();
        int delta3 = this.lzPos - this.hash.getHash3Pos();
        int currentMatch = this.hash.getHash4Pos();
        this.hash.updateTables(this.lzPos);
        this.chain[this.cyclicPos] = currentMatch;
        int lenBest = 0;
        if (delta2 < this.cyclicSize) goto L13;
    L15:
        if (delta2 == delta3) goto L22;
        if (delta3 >= this.cyclicSize) goto L22;
        if (this.buf[this.readPos - delta3] != this.buf[this.readPos]) goto L22;
        lenBest = 3;
        int[] r8 = this.matches.dist;
        Matches r10 = this.matches;
        int r11 = r10.count;
        r10.count = r11 + 1;
        r8[r11] = delta3 - 1;
        delta2 = delta3;
    L22:
        if (this.matches.count <= 0) goto L32;
    L23:
        if (lenBest >= matchLenLimit) goto L27;
        if (this.buf[(this.readPos + lenBest) - delta2] != this.buf[this.readPos + lenBest]) goto L27;
        lenBest = lenBest + 1;
    L27:
        this.matches.len[this.matches.count - 1] = lenBest;
        if (lenBest < niceLenLimit) goto L32;
        return this.matches;
    L32:
        if (lenBest >= 3) goto L34;
        lenBest = 3;
    L34:
        int len = this.depthLimit;
    L35:
        int delta = this.lzPos - currentMatch;
        int depth = len - 1;
        if (len == 0) goto L60;
        if (delta >= this.cyclicSize) goto L60;
        int[] r9 = this.chain;
        int r12 = this.cyclicPos - delta;
        if (delta <= this.cyclicPos) goto L43;
        int r13 = this.cyclicSize;
    L44:
        currentMatch = r9[r12 + r13];
        if (this.buf[(this.readPos + lenBest) - delta] != this.buf[this.readPos + lenBest]) goto L58;
        if (this.buf[this.readPos - delta] != this.buf[this.readPos]) goto L58;
        int len2 = 0;
    L49:
        len2 = len2 + 1;
        if (len2 >= matchLenLimit) goto L53;
        if (this.buf[(this.readPos + len2) - delta] == this.buf[this.readPos + len2]) goto L49;
    L53:
        if (len2 <= lenBest) goto L58;
        lenBest = len2;
        this.matches.len[this.matches.count] = len2;
        this.matches.dist[this.matches.count] = delta - 1;
        this.matches.count++;
        if (len2 < niceLenLimit) goto L58;
        return this.matches;
    L58:
        len = depth;
        goto L35
    L43:
        r13 = 0;
    L60:
        return this.matches;
    L13:
        if (this.buf[this.readPos - delta2] != this.buf[this.readPos]) goto L15;
        lenBest = 2;
        this.matches.len[0] = 2;
        this.matches.dist[0] = delta2 - 1;
        this.matches.count = 1;
        goto L15
    }

    @Override // org.tukaani.xz.lz.LZEncoder
    public void skip(int len) {
    L2:
        int len2 = len - 1;
        if (len <= 0) goto L8;
        if (movePos() == 0) goto L7;
        this.hash.calcHashes(this.buf, this.readPos);
        this.chain[this.cyclicPos] = this.hash.getHash4Pos();
        this.hash.updateTables(this.lzPos);
    L7:
        len = len2;
        goto L2
    }
}
