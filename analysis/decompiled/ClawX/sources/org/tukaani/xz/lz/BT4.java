package org.tukaani.xz.lz;

import org.tukaani.xz.ArrayCache;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
final class BT4 extends LZEncoder {
    private int cyclicPos;
    private final int cyclicSize;
    private final int depthLimit;
    private final Hash234 hash;
    private int lzPos;
    private final Matches matches;
    private final int[] tree;

    public BT4(int i8, int i9, int i10, int i11, int i12, int i13, ArrayCache arrayCache) {
        super(i8, i9, i10, i11, i12, arrayCache);
        this.cyclicPos = -1;
        int i14 = i8 + 1;
        this.cyclicSize = i14;
        this.lzPos = i14;
        this.hash = new Hash234(i8, arrayCache);
        this.tree = arrayCache.getIntArray(i14 * 2, false);
        this.matches = new Matches(i11 - 1);
        this.depthLimit = i13 <= 0 ? (i11 / 2) + 16 : i13;
    }

    public static int getMemoryUsage(int i8) {
        return (i8 / 128) + Hash234.getMemoryUsage(i8) + 10;
    }

    private int movePos() {
        int iMovePos = movePos(this.niceLen, 4);
        if (iMovePos != 0) {
            int i8 = this.lzPos + 1;
            this.lzPos = i8;
            if (i8 == Integer.MAX_VALUE) {
                int i9 = Integer.MAX_VALUE - this.cyclicSize;
                this.hash.normalize(i9);
                LZEncoder.normalize(this.tree, this.cyclicSize * 2, i9);
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

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0073, code lost:
    
        r13 = r13.tree;
        r13[r2] = 0;
        r13[r1] = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0079, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void skip(int r14, int r15) {
        /*
            r13 = this;
            int r0 = r13.depthLimit
            int r1 = r13.cyclicPos
            int r2 = r1 << 1
            int r2 = r2 + 1
            int r1 = r1 << 1
            r3 = 0
            r4 = r3
            r5 = r4
        Ld:
            int r6 = r13.lzPos
            int r6 = r6 - r15
            int r7 = r0 + (-1)
            if (r0 == 0) goto L73
            int r0 = r13.cyclicSize
            if (r6 < r0) goto L19
            goto L73
        L19:
            int r8 = r13.cyclicPos
            int r9 = r8 - r6
            if (r6 <= r8) goto L20
            goto L21
        L20:
            r0 = r3
        L21:
            int r9 = r9 + r0
            int r0 = r9 << 1
            int r8 = java.lang.Math.min(r4, r5)
            byte[] r9 = r13.buf
            int r10 = r13.readPos
            int r11 = r10 + r8
            int r11 = r11 - r6
            r11 = r9[r11]
            int r12 = r10 + r8
            r12 = r9[r12]
            if (r11 != r12) goto L4c
            int r8 = r8 + 1
            int r8 = org.tukaani.xz.lz.MatchLength.getLen(r9, r10, r6, r8, r14)
            if (r8 != r14) goto L4c
            int[] r13 = r13.tree
            r14 = r13[r0]
            r13[r1] = r14
            int r0 = r0 + 1
            r14 = r13[r0]
            r13[r2] = r14
            return
        L4c:
            byte[] r9 = r13.buf
            int r10 = r13.readPos
            int r11 = r10 + r8
            int r11 = r11 - r6
            r6 = r9[r11]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r10 = r10 + r8
            r9 = r9[r10]
            r9 = r9 & 255(0xff, float:3.57E-43)
            if (r6 >= r9) goto L69
            int[] r5 = r13.tree
            r5[r1] = r15
            int r0 = r0 + 1
            r15 = r5[r0]
            r1 = r0
            r5 = r8
            goto L71
        L69:
            int[] r4 = r13.tree
            r4[r2] = r15
            r15 = r4[r0]
            r2 = r0
            r4 = r8
        L71:
            r0 = r7
            goto Ld
        L73:
            int[] r13 = r13.tree
            r13[r2] = r3
            r13[r1] = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.tukaani.xz.lz.BT4.skip(int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00bd, code lost:
    
        r16 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x013f, code lost:
    
        r1 = r20.tree;
        r1[r7] = r16;
        r1[r5] = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0147, code lost:
    
        return r20.matches;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0063  */
    @Override // org.tukaani.xz.lz.LZEncoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public org.tukaani.xz.lz.Matches getMatches() {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.tukaani.xz.lz.BT4.getMatches():org.tukaani.xz.lz.Matches");
    }

    @Override // org.tukaani.xz.lz.LZEncoder
    public void putArraysToCache(ArrayCache arrayCache) {
        arrayCache.putArray(this.tree);
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
            int i10 = this.niceLen;
            int iMovePos = movePos();
            if (iMovePos >= i10) {
                this.hash.calcHashes(this.buf, this.readPos);
                int hash4Pos = this.hash.getHash4Pos();
                this.hash.updateTables(this.lzPos);
                skip(i10, hash4Pos);
            } else if (iMovePos != 0) {
                i10 = iMovePos;
                this.hash.calcHashes(this.buf, this.readPos);
                int hash4Pos2 = this.hash.getHash4Pos();
                this.hash.updateTables(this.lzPos);
                skip(i10, hash4Pos2);
            }
            i8 = i9;
        }
    }
}
