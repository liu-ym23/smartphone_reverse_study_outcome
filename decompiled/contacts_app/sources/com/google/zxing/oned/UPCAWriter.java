package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class UPCAWriter implements Writer {
    private final EAN13Writer subWriter;

    public UPCAWriter() {
        this.subWriter = new EAN13Writer();
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String r7, BarcodeFormat r8, int r9, int r10) throws WriterException {
        return encode(r7, r8, r9, r10, null);
    }

    @Override // com.google.zxing.Writer
    public BitMatrix encode(String r8, BarcodeFormat r9, int r10, int r11, Map<EncodeHintType, ?> r12) throws WriterException {
        if (r9 != BarcodeFormat.UPC_A) goto L7;
        return this.subWriter.encode(preencode(r8), BarcodeFormat.EAN_13, r10, r11, r12);
    L7:
        throw new IllegalArgumentException("Can only encode UPC-A, but got " + r9);
    }

    private static String preencode(String r5) {
        int r0 = r5.length();
        if (r0 != 11) goto L13;
        int r1 = 0;
        int r2 = 0;
    L5:
        if (r1 >= 11) goto L11;
        int r3 = r5.charAt(r1) - '0';
        if ((r1 % 2) != 0) goto L9;
        int r4 = 3;
    L10:
        r2 = r2 + (r3 * r4);
        r1 = r1 + 1;
        goto L5
    L9:
        r4 = 1;
        goto L10
    L11:
        r5 = r5 + ((1000 - r2) % 10);
    L15:
        return "0" + r5;
    L13:
        if (r0 == 12) goto L15;
        throw new IllegalArgumentException("Requested contents should be 11 or 12 digits long, but got " + r5.length());
    }
}
