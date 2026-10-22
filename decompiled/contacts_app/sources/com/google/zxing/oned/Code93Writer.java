package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class Code93Writer extends OneDimensionalCodeWriter {
    public Code93Writer() {
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter, com.google.zxing.Writer
    public BitMatrix encode(String r2, BarcodeFormat r3, int r4, int r5, Map<EncodeHintType, ?> r6) throws WriterException {
        if (r3 != BarcodeFormat.CODE_93) goto L7;
        return super.encode(r2, r3, r4, r5, r6);
    L7:
        throw new IllegalArgumentException("Can only encode CODE_93, but got " + r3);
    }

    @Override // com.google.zxing.oned.OneDimensionalCodeWriter
    public boolean[] encode(String r9) {
        int r8 = r9.length();
        if (r8 > 80) goto L11;
        int[] r1 = new int[9];
        boolean[] r2 = new boolean[(((r9.length() + 2) + 2) * 9) + 1];
        toIntArray(Code93Reader.CHARACTER_ENCODINGS[47], r1);
        int r3 = 0;
        int r5 = appendPattern(r2, 0, r1, true);
    L6:
        if (r3 >= r8) goto L8;
        toIntArray(Code93Reader.CHARACTER_ENCODINGS["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(r9.charAt(r3))], r1);
        r5 = r5 + appendPattern(r2, r5, r1, true);
        r3 = r3 + 1;
        goto L6
    L8:
        int r10 = computeChecksumIndex(r9, 20);
        toIntArray(Code93Reader.CHARACTER_ENCODINGS[r10], r1);
        int r6 = r5 + appendPattern(r2, r5, r1, true);
        toIntArray(Code93Reader.CHARACTER_ENCODINGS[computeChecksumIndex(r9 + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(r10), 15)], r1);
        int r7 = r6 + appendPattern(r2, r6, r1, true);
        toIntArray(Code93Reader.CHARACTER_ENCODINGS[47], r1);
        r2[r7 + appendPattern(r2, r7, r1, true)] = true;
        return r2;
    L11:
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + r8);
    }

    private static void toIntArray(int r4, int[] r5) {
        int r1 = 0;
    L4:
        if (r1 >= 9) goto L9;
        int r3 = 1;
        if (((1 << (8 - r1)) & r4) != 0) goto L8;
        r3 = 0;
    L8:
        r5[r1] = r3;
        r1 = r1 + 1;
        goto L4
    }

    protected static int appendPattern(boolean[] r4, int r5, int[] r6, boolean r7) {
        int r8 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r8) goto L9;
        int r3 = r5 + 1;
        if (r6[r1] == 0) goto L7;
        boolean r2 = true;
    L8:
        r4[r5] = r2;
        r1 = r1 + 1;
        r5 = r3;
        goto L3
    L7:
        r2 = false;
        goto L8
    L9:
        return 9;
    }

    private static int computeChecksumIndex(String r6, int r7) {
        int r0 = r6.length() - 1;
        int r2 = 0;
        int r3 = 1;
    L3:
        if (r0 < 0) goto L9;
        r2 = r2 + ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(r6.charAt(r0)) * r3);
        r3 = r3 + 1;
        if (r3 <= r7) goto L7;
        r3 = 1;
    L7:
        r0 = r0 - 1;
        goto L3
    L9:
        return r2 % 47;
    }
}
