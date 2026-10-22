package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class EAN13Writer extends UPCEANWriter {
    private static final int CODE_WIDTH = 95;

    public EAN13Writer() {
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String r2, BarcodeFormat r3, int r4, int r5, Map<EncodeHintType, ?> r6) throws WriterException {
        if (r3 != BarcodeFormat.EAN_13) goto L7;
        return super.encode(r2, r3, r4, r5, r6);
    L7:
        throw new IllegalArgumentException("Can only encode EAN_13, but got " + r3);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String r8) {
        if (r8.length() != 13) goto L24;
        if (UPCEANReader.checkStandardUPCEANChecksum(r8) == false) goto L20;
        int r1 = EAN13Reader.FIRST_DIGIT_ENCODINGS[Integer.parseInt(r8.substring(0, 1))];
        boolean[] r2 = new boolean[95];
        int r3 = appendPattern(r2, 0, UPCEANReader.START_END_PATTERN, true) + 0;
        int r4 = 1;
    L8:
        if (r4 > 6) goto L13;
        int r5 = r4 + 1;
        int r6 = Integer.parseInt(r8.substring(r4, r5));
        if (((r1 >> (6 - r4)) & 1) != 1) goto L12;
        r6 = r6 + 10;
    L12:
        r3 = r3 + appendPattern(r2, r3, UPCEANReader.L_AND_G_PATTERNS[r6], false);
        r4 = r5;
        goto L8
    L13:
        int r7 = r3 + appendPattern(r2, r3, UPCEANReader.MIDDLE_PATTERN, false);
        int r9 = 7;
    L15:
        if (r9 > 12) goto L17;
        int r10 = r9 + 1;
        r7 = r7 + appendPattern(r2, r7, UPCEANReader.L_PATTERNS[Integer.parseInt(r8.substring(r9, r10))], true);
        r9 = r10;
        goto L15
    L17:
        appendPattern(r2, r7, UPCEANReader.START_END_PATTERN, true);
        return r2;
    L20:
        throw new IllegalArgumentException("Contents do not pass checksum");     // Catch: FormatException -> L21
    L22:
        throw new IllegalArgumentException("Illegal contents");
    L24:
        throw new IllegalArgumentException("Requested contents should be 13 digits long, but got " + r8.length());
    }
}
