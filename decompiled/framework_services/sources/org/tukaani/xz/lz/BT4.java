package org.tukaani.xz.lz;

import android.hardware.tv.hdmi.cec.CecDeviceType;
import org.tukaani.xz.ArrayCache;

/* JADX INFO: loaded from: classes3.dex */
final class BT4 extends LZEncoder {
    private int cyclicPos;
    private final int cyclicSize;
    private final int depthLimit;
    private final Hash234 hash;
    private int lzPos;
    private final Matches matches;
    private final int[] tree;

    static int getMemoryUsage(int dictSize) {
        return (Hash234.getMemoryUsage(dictSize) + (dictSize / 128)) + 10;
    }

    BT4(int dictSize, int beforeSizeMin, int readAheadMax, int niceLen, int matchLenMax, int depthLimit, ArrayCache arrayCache) {
        super(dictSize, beforeSizeMin, readAheadMax, niceLen, matchLenMax, arrayCache);
        this.cyclicPos = -1;
        this.cyclicSize = dictSize + 1;
        this.lzPos = this.cyclicSize;
        this.hash = new Hash234(dictSize, arrayCache);
        this.tree = arrayCache.getIntArray(this.cyclicSize * 2, false);
        this.matches = new Matches(niceLen - 1);
        if (depthLimit <= 0) goto L5;
        int r11 = depthLimit;
    L6:
        this.depthLimit = r11;
        return;
    L5:
        r11 = (niceLen / 2) + 16;
        goto L6
    }

    @Override // org.tukaani.xz.lz.LZEncoder
    public void putArraysToCache(ArrayCache arrayCache) {
        arrayCache.putArray(this.tree);
        this.hash.putArraysToCache(arrayCache);
        super.putArraysToCache(arrayCache);
    }

    private int movePos() {
        int avail = movePos(this.niceLen, 4);
        if (avail == 0) goto L10;
        int r1 = this.lzPos + 1;
        this.lzPos = r1;
        if (r1 != Integer.MAX_VALUE) goto L7;
        int normalizationOffset = Integer.MAX_VALUE - this.cyclicSize;
        this.hash.normalize(normalizationOffset);
        LZEncoder.normalize(this.tree, this.cyclicSize * 2, normalizationOffset);
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
        int r2 = 0;
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
        int lenBest = 0;
        boolean r10 = true;
        if (delta2 < this.cyclicSize) goto L13;
    L15:
        if (delta2 == delta3) goto L22;
        if (delta3 >= this.cyclicSize) goto L22;
        if (this.buf[this.readPos - delta3] != this.buf[this.readPos]) goto L22;
        lenBest = 3;
        int[] r9 = this.matches.dist;
        Matches r11 = this.matches;
        int r12 = r11.count;
        r11.count = r12 + 1;
        r9[r12] = delta3 - 1;
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
        skip(niceLenLimit, currentMatch);
        return this.matches;
    L32:
        if (lenBest >= 3) goto L34;
        lenBest = 3;
    L34:
        int len = this.depthLimit;
        int ptr0 = (this.cyclicPos << 1) + 1;
        int ptr1 = this.cyclicPos << 1;
        int len0 = 0;
        int len1 = 0;
    L35:
        int delta = this.lzPos - currentMatch;
        int depth = len - 1;
        if (len == 0) goto L62;
        if (delta >= this.cyclicSize) goto L62;
        int r13 = this.cyclicPos - delta;
        int r17 = r2;
        if (delta <= this.cyclicPos) goto L43;
        int r3 = this.cyclicSize;
    L44:
        int pair = (r13 + r3) << 1;
        int len2 = Math.min(len0, len1);
        boolean r18 = r10;
        int avail2 = avail;
        if (this.buf[(this.readPos + len2) - delta] != this.buf[this.readPos + len2]) goto L57;
    L46:
        len2 = len2 + 1;
        if (len2 >= matchLenLimit) goto L50;
        if (this.buf[(this.readPos + len2) - delta] == this.buf[this.readPos + len2]) goto L46;
    L50:
        if (len2 <= lenBest) goto L57;
        this.matches.len[this.matches.count] = len2;
        this.matches.dist[this.matches.count] = delta - 1;
        this.matches.count++;
        if (len2 >= niceLenLimit) goto L53;
        lenBest = len2;
        goto L57
    L53:
        this.tree[ptr1] = this.tree[pair];
        this.tree[ptr0] = this.tree[pair + 1];
        return this.matches;
    L57:
        if ((this.buf[(this.readPos + len2) - delta] & CecDeviceType.INACTIVE) >= (this.buf[this.readPos + len2] & CecDeviceType.INACTIVE)) goto L59;
        this.tree[ptr1] = currentMatch;
        int ptr2 = pair + 1;
        int currentMatch2 = this.tree[ptr2];
        ptr1 = ptr2;
        len1 = len2;
    L60:
        currentMatch = currentMatch2;
        len = depth;
        r2 = r17;
        r10 = r18;
        avail = avail2;
        goto L35
    L59:
        this.tree[ptr0] = currentMatch;
        currentMatch2 = this.tree[pair];
        ptr0 = pair;
        len0 = len2;
        goto L60
    L43:
        r3 = r17;
    L62:
        this.tree[ptr0] = r2;
        this.tree[ptr1] = r2;
        return this.matches;
    L13:
        if (this.buf[this.readPos - delta2] != this.buf[this.readPos]) goto L15;
        lenBest = 2;
        this.matches.len[0] = 2;
        this.matches.dist[0] = delta2 - 1;
        this.matches.count = 1;
        goto L15
    }

    private void skip(int niceLenLimit, int currentMatch) {
        int pair = this.depthLimit;
        int ptr0 = (this.cyclicPos << 1) + 1;
        int ptr1 = this.cyclicPos << 1;
        int len0 = 0;
        int len1 = 0;
    L3:
        int delta = this.lzPos - currentMatch;
        int depth = pair - 1;
        int r7 = 0;
        if (pair == 0) goto L24;
        if (delta >= this.cyclicSize) goto L24;
        int r0 = this.cyclicPos - delta;
        if (delta <= this.cyclicPos) goto L11;
        r7 = this.cyclicSize;
    L11:
        int pair2 = (r0 + r7) << 1;
        int len = Math.min(len0, len1);
        if (this.buf[(this.readPos + len) - delta] != this.buf[this.readPos + len]) goto L20;
    L13:
        len = len + 1;
        if (len == niceLenLimit) goto L15;
        if (this.buf[(this.readPos + len) - delta] == this.buf[this.readPos + len]) goto L13;
    L15:
        this.tree[ptr1] = this.tree[pair2];
        this.tree[ptr0] = this.tree[pair2 + 1];
        return;
    L20:
        if ((this.buf[(this.readPos + len) - delta] & CecDeviceType.INACTIVE) >= (this.buf[this.readPos + len] & CecDeviceType.INACTIVE)) goto L22;
        this.tree[ptr1] = currentMatch;
        ptr1 = pair2 + 1;
        currentMatch = this.tree[ptr1];
        len1 = len;
    L23:
        pair = depth;
        goto L3
    L22:
        this.tree[ptr0] = currentMatch;
        ptr0 = pair2;
        currentMatch = this.tree[ptr0];
        len0 = len;
    L24:
        this.tree[ptr0] = 0;
        this.tree[ptr1] = 0;
    }

    @Override // org.tukaani.xz.lz.LZEncoder
    public void skip(int len) {
    L2:
        int len2 = len - 1;
        if (len <= 0) goto L11;
        int niceLenLimit = this.niceLen;
        int avail = movePos();
        if (avail >= niceLenLimit) goto L9;
        if (avail == 0) goto L10;
        niceLenLimit = avail;
    L10:
        len = len2;
    L9:
        this.hash.calcHashes(this.buf, this.readPos);
        int currentMatch = this.hash.getHash4Pos();
        this.hash.updateTables(this.lzPos);
        skip(niceLenLimit, currentMatch);
        goto L10
    }
}
