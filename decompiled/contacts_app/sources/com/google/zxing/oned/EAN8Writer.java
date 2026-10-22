package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class EAN8Writer extends UPCEANWriter {
    private static final int CODE_WIDTH = 67;

    public EAN8Writer() {
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String r2, BarcodeFormat r3, int r4, int r5, Map<EncodeHintType, ?> r6) throws WriterException {
        if (r3 != BarcodeFormat.EAN_8) goto L7;
        return super.encode(r2, r3, r4, r5, r6);
    L7:
        throw new IllegalArgumentException("Can only encode EAN_8, but got " + r3);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String r7) {
        if (r7.length() != 8) goto L15;
        boolean[] r6 = new boolean[67];
        int r0 = appendPattern(r6, 0, UPCEANReader.START_END_PATTERN, true) + 0;
        int r3 = 0;
    L6:
        if (r3 > 3) goto L8;
        int r4 = r3 + 1;
        r0 = r0 + appendPattern(r6, r0, UPCEANReader.L_PATTERNS[Integer.parseInt(r7.substring(r3, r4))], false);
        r3 = r4;
        goto L6
    L8:
        int r1 = r0 + appendPattern(r6, r0, UPCEANReader.MIDDLE_PATTERN, false);
        int r2 = 4;
    L10:
        if (r2 > 7) goto L12;
        int r5 = r2 + 1;
        r1 = r1 + appendPattern(r6, r1, UPCEANReader.L_PATTERNS[Integer.parseInt(r7.substring(r2, r5))], true);
        r2 = r5;
        goto L10
    L12:
        appendPattern(r6, r1, UPCEANReader.START_END_PATTERN, true);
        return r6;
    L15:
        throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + r7.length());
    }
}
