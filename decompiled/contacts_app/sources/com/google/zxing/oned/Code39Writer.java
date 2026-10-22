package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class Code39Writer extends OneDimensionalCodeWriter {
    public Code39Writer() {
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String r2, BarcodeFormat r3, int r4, int r5, Map<EncodeHintType, ?> r6) throws WriterException {
        if (r3 != BarcodeFormat.CODE_39) goto L7;
        return super.encode(r2, r3, r4, r5, r6);
    L7:
        throw new IllegalArgumentException("Can only encode CODE_39, but got " + r3);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String r11) {
        int r10 = r11.length();
        if (r10 > 80) goto L21;
        int[] r1 = new int[9];
        int r2 = r10 + 25;
        int r4 = 0;
    L6:
        if (r4 >= r10) goto L15;
        int r5 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(r11.charAt(r4));
        if (r5 < 0) goto L14;
        toIntArray(Code39Reader.CHARACTER_ENCODINGS[r5], r1);
        int r6 = 0;
    L10:
        if (r6 >= 9) goto L12;
        r2 = r2 + r1[r6];
        r6 = r6 + 1;
        goto L10
    L12:
        r4 = r4 + 1;
        goto L6
    L14:
        throw new IllegalArgumentException("Bad contents: " + r11);
    L15:
        boolean[] r0 = new boolean[r2];
        toIntArray(Code39Reader.ASTERISK_ENCODING, r1);
        int r7 = appendPattern(r0, 0, r1, true);
        int[] r8 = {1};
        int r9 = r7 + appendPattern(r0, r7, r8, false);
        int r12 = 0;
    L16:
        if (r12 >= r10) goto L18;
        toIntArray(Code39Reader.CHARACTER_ENCODINGS["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(r11.charAt(r12))], r1);
        int r13 = r9 + appendPattern(r0, r9, r1, true);
        r9 = r13 + appendPattern(r0, r13, r8, false);
        r12 = r12 + 1;
        goto L16
    L18:
        toIntArray(Code39Reader.ASTERISK_ENCODING, r1);
        appendPattern(r0, r9, r1, true);
        return r0;
    L21:
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + r10);
    }

    private static void toIntArray(int r3, int[] r4) {
        int r0 = 0;
    L4:
        if (r0 >= 9) goto L10;
        int r2 = 1;
        if (((1 << (8 - r0)) & r3) == 0) goto L9;
        r2 = 2;
    L9:
        r4[r0] = r2;
        r0 = r0 + 1;
        goto L4
    }
}
