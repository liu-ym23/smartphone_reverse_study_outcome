package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* JADX INFO: loaded from: classes3.dex */
final class AI01392xDecoder extends AI01decoder {
    private static final int HEADER_SIZE = 8;
    private static final int LAST_DIGIT_SIZE = 2;

    AI01392xDecoder(BitArray r1) {
        super(r1);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public String parseInformation() throws NotFoundException, FormatException {
        if (getInformation().getSize() < 48) goto L7;
        StringBuilder r0 = new StringBuilder();
        encodeCompressedGtin(r0, 8);
        int r1 = getGeneralDecoder().extractNumericValueFromBitArray(48, 2);
        r0.append("(392");
        r0.append(r1);
        r0.append(')');
        r0.append(getGeneralDecoder().decodeGeneralPurposeField(50, null).getNewString());
        return r0.toString();
    L7:
        throw NotFoundException.getNotFoundInstance();
    }
}
