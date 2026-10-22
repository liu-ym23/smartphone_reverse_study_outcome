package com.google.zxing.oned.rss.expanded.decoders;

import com.bytedance.apm.constant.CommonServiceName;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractExpandedDecoder {
    private final GeneralAppIdDecoder generalDecoder;
    private final BitArray information;

    public abstract String parseInformation() throws NotFoundException, FormatException;

    AbstractExpandedDecoder(BitArray r2) {
        this.information = r2;
        this.generalDecoder = new GeneralAppIdDecoder(r2);
    }

    protected final BitArray getInformation() {
        return this.information;
    }

    protected final GeneralAppIdDecoder getGeneralDecoder() {
        return this.generalDecoder;
    }

    public static AbstractExpandedDecoder createDecoder(BitArray r7) {
        if (r7.get(1) == false) goto L7;
        return new AI01AndOtherAIs(r7);
    L7:
        if (r7.get(2) == false) goto L9;
        int r2 = GeneralAppIdDecoder.extractNumericValueFromBitArray(r7, 1, 4);
        if (r2 == 4) goto L45;
        if (r2 == 5) goto L43;
        int r1 = GeneralAppIdDecoder.extractNumericValueFromBitArray(r7, 1, 5);
        if (r1 == 12) goto L41;
        if (r1 == 13) goto L39;
        switch(GeneralAppIdDecoder.extractNumericValueFromBitArray(r7, 1, 7)) {
            case 56: goto L37;
            case 57: goto L35;
            case 58: goto L33;
            case 59: goto L31;
            case 60: goto L29;
            case 61: goto L27;
            case 62: goto L25;
            case 63: goto L23;
            default: goto L21;
        };
    L21:
        throw new IllegalStateException("unknown decoder: " + r7);
    L23:
        return new AI013x0x1xDecoder(r7, "320", "17");
    L25:
        return new AI013x0x1xDecoder(r7, "310", "17");
    L27:
        return new AI013x0x1xDecoder(r7, "320", "15");
    L29:
        return new AI013x0x1xDecoder(r7, "310", "15");
    L31:
        return new AI013x0x1xDecoder(r7, "320", "13");
    L33:
        return new AI013x0x1xDecoder(r7, "310", "13");
    L35:
        return new AI013x0x1xDecoder(r7, "320", CommonServiceName.CRONET_ERROR_CODE_CANCEL);
    L37:
        return new AI013x0x1xDecoder(r7, "310", CommonServiceName.CRONET_ERROR_CODE_CANCEL);
    L39:
        return new AI01393xDecoder(r7);
    L41:
        return new AI01392xDecoder(r7);
    L43:
        return new AI01320xDecoder(r7);
    L45:
        return new AI013103decoder(r7);
    L9:
        return new AnyAIDecoder(r7);
    }
}
