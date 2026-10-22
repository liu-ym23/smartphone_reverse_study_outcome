package com.google.zxing.oned.rss.expanded;

import com.google.zxing.common.BitArray;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
final class BitArrayBuilder {
    private BitArrayBuilder() {
    }

    static BitArray buildBitArray(List<ExpandedPair> r9) {
        int r0 = (r9.size() << 1) - 1;
        if (r9.get(r9.size() - 1).getRightChar() != null) goto L5;
        r0 = r0 - 1;
    L5:
        BitArray r2 = new BitArray(r0 * 12);
        int r1 = 0;
        int r3 = r9.get(0).getRightChar().getValue();
        int r5 = 11;
    L6:
        if (r5 < 0) goto L11;
        if (((1 << r5) & r3) == 0) goto L10;
        r2.set(r1);
    L10:
        r1 = r1 + 1;
        r5 = r5 - 1;
        goto L6
    L11:
        int r4 = 1;
    L13:
        if (r4 >= r9.size()) goto L29;
        ExpandedPair r6 = r9.get(r4);
        int r7 = r6.getLeftChar().getValue();
        int r8 = 11;
    L15:
        if (r8 < 0) goto L21;
        if (((1 << r8) & r7) == 0) goto L19;
        r2.set(r1);
    L19:
        r1 = r1 + 1;
        r8 = r8 - 1;
        goto L15
    L21:
        if (r6.getRightChar() == null) goto L28;
        int r10 = r6.getRightChar().getValue();
        int r11 = 11;
    L23:
        if (r11 < 0) goto L28;
        if (((1 << r11) & r10) == 0) goto L27;
        r2.set(r1);
    L27:
        r1 = r1 + 1;
        r11 = r11 - 1;
    L28:
        r4 = r4 + 1;
        goto L13
    L29:
        return r2;
    }
}
