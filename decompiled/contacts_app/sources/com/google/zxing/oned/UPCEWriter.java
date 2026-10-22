package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class UPCEWriter extends UPCEANWriter {
    private static final int CODE_WIDTH = 51;

    public UPCEWriter() {
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String r2, BarcodeFormat r3, int r4, int r5, Map<EncodeHintType, ?> r6) throws WriterException {
        if (r3 != BarcodeFormat.UPC_E) goto L7;
        return super.encode(r2, r3, r4, r5, r6);
    L7:
        throw new IllegalArgumentException("Can only encode UPC_E, but got " + r3);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String r8) {
        if (r8.length() != 8) goto L14;
        int r7 = UPCEReader.CHECK_DIGIT_ENCODINGS[Integer.parseInt(r8.substring(7, 8))];
        boolean[] r0 = new boolean[51];
        int r1 = appendPattern(r0, 0, UPCEANReader.START_END_PATTERN, true) + 0;
        int r4 = 1;
    L6:
        if (r4 > 6) goto L11;
        int r5 = r4 + 1;
        int r6 = Integer.parseInt(r8.substring(r4, r5));
        if (((r7 >> (6 - r4)) & 1) != 1) goto L10;
        r6 = r6 + 10;
    L10:
        r1 = r1 + appendPattern(r0, r1, UPCEANReader.L_AND_G_PATTERNS[r6], false);
        r4 = r5;
        goto L6
    L11:
        appendPattern(r0, r1, UPCEANReader.END_PATTERN, false);
        return r0;
    L14:
        throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + r8.length());
    }
}
