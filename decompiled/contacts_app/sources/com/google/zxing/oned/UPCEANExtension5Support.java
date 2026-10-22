package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class UPCEANExtension5Support {
    private static final int[] CHECK_DIGIT_ENCODINGS = null;
    private final int[] decodeMiddleCounters;
    private final StringBuilder decodeRowStringBuffer;

    UPCEANExtension5Support() {
        this.decodeMiddleCounters = new int[4];
        this.decodeRowStringBuffer = new StringBuilder();
    }

    static {
        CHECK_DIGIT_ENCODINGS = new int[]{24, 20, 18, 17, 12, 6, 3, 10, 9, 5};
    }

    Result decodeRow(int r8, BitArray r9, int[] r10) throws NotFoundException {
        StringBuilder r0 = this.decodeRowStringBuffer;
        r0.setLength(0);
        int r7 = decodeMiddle(r9, r10, r0);
        String r11 = r0.toString();
        Map<ResultMetadataType, Object> r1 = parseExtensionString(r11);
        float r12 = r8;
        Result r2 = new Result(r11, null, new ResultPoint[]{new ResultPoint((r10[0] + r10[1]) / 2.0f, r12), new ResultPoint(r7, r12)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (r1 == null) goto L5;
        r2.putAllMetadata(r1);
    L5:
        return r2;
    }

    private int decodeMiddle(BitArray r10, int[] r11, StringBuilder r12) throws NotFoundException {
        int[] r9 = this.decodeMiddleCounters;
        r9[0] = 0;
        r9[1] = 0;
        r9[2] = 0;
        r9[3] = 0;
        int r2 = r10.getSize();
        int r13 = r11[1];
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r3 >= 5) goto L17;
        if (r13 >= r2) goto L17;
        int r5 = UPCEANReader.decodeDigit(r10, r9, r13, UPCEANReader.L_AND_G_PATTERNS);
        r12.append((char) ((r5 % 10) + 48));
        int r6 = r9.length;
        int r7 = 0;
    L7:
        if (r7 >= r6) goto L10;
        r13 = r13 + r9[r7];
        r7 = r7 + 1;
        goto L7
    L10:
        if (r5 < 10) goto L13;
        r4 = r4 | (1 << (4 - r3));
    L13:
        if (r3 == 4) goto L15;
        r13 = r10.getNextUnset(r10.getNextSet(r13));
    L15:
        r3 = r3 + 1;
    L17:
        if (r12.length() != 5) goto L24;
        if (extensionChecksum(r12.toString()) != determineCheckDigit(r4)) goto L22;
        return r13;
    L22:
        throw NotFoundException.getNotFoundInstance();
    L24:
        throw NotFoundException.getNotFoundInstance();
    }

    private static int extensionChecksum(CharSequence r4) {
        int r0 = r4.length();
        int r1 = r0 - 2;
        int r2 = 0;
    L3:
        if (r1 < 0) goto L5;
        r2 = r2 + (r4.charAt(r1) - '0');
        r1 = r1 - 2;
        goto L3
    L5:
        int r3 = r2 * 3;
        int r5 = r0 - 1;
    L6:
        if (r5 < 0) goto L9;
        r3 = r3 + (r4.charAt(r5) - '0');
        r5 = r5 - 2;
        goto L6
    L9:
        return (r3 * 3) % 10;
    }

    private static int determineCheckDigit(int r2) throws NotFoundException {
        int r0 = 0;
    L4:
        if (r0 >= 10) goto L10;
        if (r2 == CHECK_DIGIT_ENCODINGS[r0]) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        return r0;
    L10:
        throw NotFoundException.getNotFoundInstance();
    }

    private static Map<ResultMetadataType, Object> parseExtensionString(String r3) {
        if (r3.length() == 5) goto L5;
        return null;
    L5:
        String r4 = parseExtension5String(r3);
        if (r4 != null) goto L8;
        return null;
    L8:
        EnumMap r0 = new EnumMap(ResultMetadataType.class);
        r0.put(ResultMetadataType.SUGGESTED_PRICE, r4);
        return r0;
    }

    private static String parseExtension5String(String r4) {
        char r0 = r4.charAt(0);
        if (r0 != '0') goto L5;
        String r2 = "£";
    L23:
        int r5 = Integer.parseInt(r4.substring(1));
        String r1 = String.valueOf(r5 / 100);
        int r6 = r5 % 100;
        if (r6 >= 10) goto L26;
        String r7 = "0" + r6;
    L28:
        return r2 + r1 + '.' + r7;
    L26:
        r7 = String.valueOf(r6);
        goto L28
    L5:
        if (r0 == '5') goto L21;
        r2 = "";
        if (r0 != '9') goto L23;
        if ("90000".equals(r4) == false) goto L14;
        return null;
    L14:
        if ("99991".equals(r4) == false) goto L18;
        return "0.00";
    L18:
        if ("99990".equals(r4) == false) goto L23;
        return "Used";
    L21:
        r2 = "$";
        goto L23
    }
}
