package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

/* JADX INFO: loaded from: classes3.dex */
abstract class AI01weightDecoder extends AI01decoder {
    protected abstract void addWeightCode(StringBuilder r1, int r2);

    protected abstract int checkWeight(int r1);

    AI01weightDecoder(BitArray r1) {
        super(r1);
    }

    final void encodeCompressedWeight(StringBuilder r2, int r3, int r4) {
        int r5 = getGeneralDecoder().extractNumericValueFromBitArray(r3, r4);
        addWeightCode(r2, r5);
        int r1 = checkWeight(r5);
        int r6 = 100000;
        int r7 = 0;
    L4:
        if (r7 >= 5) goto L9;
        if ((r1 / r6) != 0) goto L8;
        r2.append('0');
    L8:
        r6 = r6 / 10;
        r7 = r7 + 1;
        goto L4
    L9:
        r2.append(r1);
    }
}
