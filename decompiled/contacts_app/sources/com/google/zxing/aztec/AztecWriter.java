package com.google.zxing.aztec;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.aztec.encoder.AztecCode;
import com.google.zxing.aztec.encoder.Encoder;
import com.google.zxing.common.BitMatrix;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class AztecWriter implements Writer {
    private static final Charset DEFAULT_CHARSET = null;

    public AztecWriter() {
    }

    static {
        DEFAULT_CHARSET = Charset.forName("ISO-8859-1");
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String r7, BarcodeFormat r8, int r9, int r10) {
        return encode(r7, r8, r9, r10, null);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String r10, BarcodeFormat r11, int r12, int r13, Map<EncodeHintType, ?> r14) {
        Charset r9 = DEFAULT_CHARSET;
        int r0 = 33;
        int r1 = 0;
        if (r14 == null) goto L14;
        if (r14.containsKey(EncodeHintType.CHARACTER_SET) == false) goto L8;
        r9 = Charset.forName(r14.get(EncodeHintType.CHARACTER_SET).toString());
    L8:
        if (r14.containsKey(EncodeHintType.ERROR_CORRECTION) == false) goto L11;
        r0 = Integer.parseInt(r14.get(EncodeHintType.ERROR_CORRECTION).toString());
    L11:
        if (r14.containsKey(EncodeHintType.AZTEC_LAYERS) == false) goto L14;
        r1 = Integer.parseInt(r14.get(EncodeHintType.AZTEC_LAYERS).toString());
    L14:
        return encode(r10, r11, r12, r13, r9, r0, r1);
    }

    private static BitMatrix encode(String r1, BarcodeFormat r2, int r3, int r4, Charset r5, int r6, int r7) {
        if (r2 != BarcodeFormat.AZTEC) goto L7;
        return renderResult(Encoder.encode(r1.getBytes(r5), r6, r7), r3, r4);
    L7:
        throw new IllegalArgumentException("Can only encode AZTEC, but got " + r2);
    }

    private static BitMatrix renderResult(AztecCode r9, int r10, int r11) {
        BitMatrix r12 = r9.getMatrix();
        if (r12 == null) goto L15;
        int r0 = r12.getWidth();
        int r1 = r12.getHeight();
        int r13 = Math.max(r10, r0);
        int r14 = Math.max(r11, r1);
        int r2 = Math.min(r13 / r0, r14 / r1);
        int r3 = (r13 - (r0 * r2)) / 2;
        int r4 = (r14 - (r1 * r2)) / 2;
        BitMatrix r5 = new BitMatrix(r13, r14);
        int r15 = 0;
    L5:
        if (r15 >= r1) goto L13;
        int r6 = 0;
        int r7 = r3;
    L7:
        if (r6 >= r0) goto L12;
        if (r12.get(r6, r15) == false) goto L11;
        r5.setRegion(r7, r4, r2, r2);
    L11:
        r6 = r6 + 1;
        r7 = r7 + r2;
        goto L7
    L12:
        r15 = r15 + 1;
        r4 = r4 + r2;
        goto L5
    L13:
        return r5;
    L15:
        throw new IllegalStateException();
    }
}
