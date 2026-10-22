package org.tukaani.xz.lz;

import org.tukaani.xz.ArrayCache;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
final class HC4 extends LZEncoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final int[] chain;
    private int cyclicPos;
    private final int cyclicSize;
    private final int depthLimit;
    private final Hash234 hash;
    private int lzPos;
    private final Matches matches;

    public HC4(int i8, int i9, int i10, int i11, int i12, int i13, ArrayCache arrayCache) {
        super(i8, i9, i10, i11, i12, arrayCache);
        this.cyclicPos = -1;
        this.hash = new Hash234(i8, arrayCache);
        int i14 = i8 + 1;
        this.cyclicSize = i14;
        this.chain = arrayCache.getIntArray(i14, false);
        this.lzPos = i14;
        this.matches = new Matches(i11 - 1);
        this.depthLimit = i13 <= 0 ? (i11 / 4) + 4 : i13;
    }

    public static int getMemoryUsage(int i8) {
        return (i8 / 256) + Hash234.getMemoryUsage(i8) + 10;
    }

    private int movePos() {
        int iMovePos = movePos(4, 4);
        if (iMovePos != 0) {
            int i8 = this.lzPos + 1;
            this.lzPos = i8;
            if (i8 == Integer.MAX_VALUE) {
                int i9 = Integer.MAX_VALUE - this.cyclicSize;
                this.hash.normalize(i9);
                LZEncoder.normalize(this.chain, this.cyclicSize, i9);
                this.lzPos -= i9;
            }
            int i10 = this.cyclicPos + 1;
            this.cyclicPos = i10;
            if (i10 == this.cyclicSize) {
                this.cyclicPos = 0;
            }
        }
        return iMovePos;
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00fa, code lost:
    
        return r13.matches;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0067  */
    @Override // org.tukaani.xz.lz.LZEncoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.tukaani.xz.lz.Matches getMatches() {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.tukaani.xz.lz.HC4.getMatches():org.tukaani.xz.lz.Matches");
    }

    @Override // org.tukaani.xz.lz.LZEncoder
    public void putArraysToCache(ArrayCache arrayCache) {
        arrayCache.putArray(this.chain);
        this.hash.putArraysToCache(arrayCache);
        super.putArraysToCache(arrayCache);
    }

    @Override // org.tukaani.xz.lz.LZEncoder
    public void skip(int i8) {
        while (true) {
            int i9 = i8 - 1;
            if (i8 <= 0) {
                return;
            }
            if (movePos() != 0) {
                this.hash.calcHashes(this.buf, this.readPos);
                this.chain[this.cyclicPos] = this.hash.getHash4Pos();
                this.hash.updateTables(this.lzPos);
            }
            i8 = i9;
        }
    }
}
