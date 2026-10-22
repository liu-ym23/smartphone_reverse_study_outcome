package com.google.zxing.pdf417.decoder;

import com.google.zxing.pdf417.PDF417Common;
import java.util.Formatter;

/* JADX INFO: loaded from: classes3.dex */
final class DetectionResult {
    private static final int ADJUST_ROW_NUMBER_SKIP = 2;
    private final int barcodeColumnCount;
    private final BarcodeMetadata barcodeMetadata;
    private BoundingBox boundingBox;
    private final DetectionResultColumn[] detectionResultColumns;

    DetectionResult(BarcodeMetadata r1, BoundingBox r2) {
        this.barcodeMetadata = r1;
        int r3 = r1.getColumnCount();
        this.barcodeColumnCount = r3;
        this.boundingBox = r2;
        this.detectionResultColumns = new DetectionResultColumn[r3 + 2];
    }

    DetectionResultColumn[] getDetectionResultColumns() {
        adjustIndicatorColumnRowNumbers(this.detectionResultColumns[0]);
        adjustIndicatorColumnRowNumbers(this.detectionResultColumns[this.barcodeColumnCount + 1]);
        int r0 = PDF417Common.MAX_CODEWORDS_IN_BARCODE;
    L3:
        int r1 = adjustRowNumbers();
        if (r1 <= 0) goto L9;
        if (r1 >= r0) goto L9;
        r0 = r1;
    L9:
        return this.detectionResultColumns;
    }

    private void adjustIndicatorColumnRowNumbers(DetectionResultColumn r1) {
        if (r1 == null) goto L5;
        ((DetectionResultRowIndicatorColumn) r1).adjustCompleteIndicatorColumnRowNumbers(this.barcodeMetadata);
        return;
    }

    private int adjustRowNumbers() {
        int r0 = adjustRowNumbersByRow();
        if (r0 != 0) goto L5;
        return 0;
    L5:
        int r3 = 1;
    L7:
        if (r3 >= (this.barcodeColumnCount + 1)) goto L18;
        Codeword[] r4 = this.detectionResultColumns[r3].getCodewords();
        int r5 = 0;
    L10:
        if (r5 >= r4.length) goto L17;
        Codeword r6 = r4[r5];
        if (r6 == null) goto L16;
        if (r6.hasValidRowNumber() == true) goto L16;
        adjustRowNumbers(r3, r5, r4);
    L16:
        r5 = r5 + 1;
        goto L10
    L17:
        r3 = r3 + 1;
        goto L7
    L18:
        return r0;
    }

    private int adjustRowNumbersByRow() {
        adjustRowNumbersFromBothRI();
        return adjustRowNumbersFromLRI() + adjustRowNumbersFromRRI();
    }

    private void adjustRowNumbersFromBothRI() {
        DetectionResultColumn[] r0 = this.detectionResultColumns;
        int r1 = 0;
        DetectionResultColumn r2 = r0[0];
        if (r2 != null) goto L5;
        return;
    L5:
        if (r0[this.barcodeColumnCount + 1] == null) goto L35;
        Codeword[] r3 = r2.getCodewords();
        Codeword[] r4 = this.detectionResultColumns[this.barcodeColumnCount + 1].getCodewords();
    L9:
        if (r1 >= r3.length) goto L36;
        Codeword r5 = r3[r1];
        if (r5 == null) goto L25;
        if (r4[r1] == null) goto L25;
        if (r5.getRowNumber() != r4[r1].getRowNumber()) goto L25;
        int r6 = 1;
    L18:
        if (r6 > this.barcodeColumnCount) goto L25;
        Codeword r7 = this.detectionResultColumns[r6].getCodewords()[r1];
        if (r7 == null) goto L24;
        r7.setRowNumber(r3[r1].getRowNumber());
        if (r7.hasValidRowNumber() == true) goto L24;
        this.detectionResultColumns[r6].getCodewords()[r1] = null;
    L24:
        r6 = r6 + 1;
    L25:
        r1 = r1 + 1;
        goto L9
    L36:
        return;
    }

    private int adjustRowNumbersFromRRI() {
        DetectionResultColumn[] r0 = this.detectionResultColumns;
        int r1 = this.barcodeColumnCount;
        if (r0[r1 + 1] != null) goto L5;
        return 0;
    L5:
        Codeword[] r2 = r0[r1 + 1].getCodewords();
        int r3 = 0;
        int r4 = 0;
    L7:
        if (r3 >= r2.length) goto L21;
        Codeword r5 = r2[r3];
        if (r5 == null) goto L20;
        int r6 = r5.getRowNumber();
        int r7 = this.barcodeColumnCount + 1;
        int r8 = 0;
    L11:
        if (r7 <= 0) goto L20;
        if (r8 >= 2) goto L20;
        Codeword r9 = this.detectionResultColumns[r7].getCodewords()[r3];
        if (r9 == null) goto L19;
        r8 = adjustRowNumberIfValid(r6, r8, r9);
        if (r9.hasValidRowNumber() == true) goto L19;
        r4 = r4 + 1;
    L19:
        r7 = r7 - 1;
    L20:
        r3 = r3 + 1;
        goto L7
    L21:
        return r4;
    }

    private int adjustRowNumbersFromLRI() {
        DetectionResultColumn r0 = this.detectionResultColumns[0];
        if (r0 != null) goto L5;
        return 0;
    L5:
        Codeword[] r1 = r0.getCodewords();
        int r2 = 0;
        int r3 = 0;
    L7:
        if (r2 >= r1.length) goto L22;
        Codeword r4 = r1[r2];
        if (r4 == null) goto L21;
        int r5 = r4.getRowNumber();
        int r7 = 0;
        int r6 = 1;
    L12:
        if (r6 >= (this.barcodeColumnCount + 1)) goto L21;
        if (r7 >= 2) goto L21;
        Codeword r8 = this.detectionResultColumns[r6].getCodewords()[r2];
        if (r8 == null) goto L20;
        r7 = adjustRowNumberIfValid(r5, r7, r8);
        if (r8.hasValidRowNumber() == true) goto L20;
        r3 = r3 + 1;
    L20:
        r6 = r6 + 1;
    L21:
        r2 = r2 + 1;
        goto L7
    L22:
        return r3;
    }

    private static int adjustRowNumberIfValid(int r1, int r2, Codeword r3) {
        if (r3 != null) goto L5;
        return r2;
    L5:
        if (r3.hasValidRowNumber() == false) goto L7;
        return r2;
    L7:
        if (r3.isValidRowNumber(r1) == false) goto L10;
        r3.setRowNumber(r1);
        return 0;
    L10:
        return r2 + 1;
    }

    private void adjustRowNumbers(int r10, int r11, Codeword[] r12) {
        Codeword r0 = r12[r11];
        Codeword[] r1 = this.detectionResultColumns[r10 - 1].getCodewords();
        DetectionResultColumn r9 = this.detectionResultColumns[r10 + 1];
        if (r9 == null) goto L5;
        Codeword[] r13 = r9.getCodewords();
    L6:
        Codeword[] r3 = new Codeword[14];
        r3[2] = r1[r11];
        r3[3] = r13[r11];
        int r4 = 0;
        if (r11 <= 0) goto L9;
        int r6 = r11 - 1;
        r3[0] = r12[r6];
        r3[4] = r1[r6];
        r3[5] = r13[r6];
    L9:
        if (r11 <= 1) goto L12;
        int r7 = r11 - 2;
        r3[8] = r12[r7];
        r3[10] = r1[r7];
        r3[11] = r13[r7];
    L12:
        if (r11 >= (r12.length - 1)) goto L15;
        int r8 = r11 + 1;
        r3[1] = r12[r8];
        r3[6] = r1[r8];
        r3[7] = r13[r8];
    L15:
        if (r11 >= (r12.length - 2)) goto L17;
        int r14 = r11 + 2;
        r3[9] = r12[r14];
        r3[12] = r1[r14];
        r3[13] = r13[r14];
    L17:
        if (r4 >= 14) goto L22;
        if (adjustRowNumber(r0, r3[r4]) == true) goto L20;
        r4 = r4 + 1;
        goto L17
    L20:
        return;
    L22:
        return;
    L5:
        r13 = r1;
        goto L6
    }

    private static boolean adjustRowNumber(Codeword r3, Codeword r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.hasValidRowNumber() == true) goto L8;
    L11:
        return false;
    L8:
        if (r4.getBucket() != r3.getBucket()) goto L11;
        r3.setRowNumber(r4.getRowNumber());
        return true;
    }

    int getBarcodeColumnCount() {
        return this.barcodeColumnCount;
    }

    int getBarcodeRowCount() {
        return this.barcodeMetadata.getRowCount();
    }

    int getBarcodeECLevel() {
        return this.barcodeMetadata.getErrorCorrectionLevel();
    }

    public void setBoundingBox(BoundingBox r1) {
        this.boundingBox = r1;
    }

    BoundingBox getBoundingBox() {
        return this.boundingBox;
    }

    void setDetectionResultColumn(int r1, DetectionResultColumn r2) {
        this.detectionResultColumns[r1] = r2;
    }

    DetectionResultColumn getDetectionResultColumn(int r1) {
        return this.detectionResultColumns[r1];
    }

    public String toString() {
        DetectionResultColumn[] r0 = this.detectionResultColumns;
        DetectionResultColumn r2 = r0[0];
        if (r2 != null) goto L5;
        r2 = r0[this.barcodeColumnCount + 1];
    L5:
        Formatter r1 = new Formatter();
        int r4 = 0;
    L7:
        if (r4 >= r2.getCodewords().length) goto L20;
        r1.format("CW %3d:", new Object[]{Integer.valueOf(r4)});
        int r5 = 0;
    L10:
        if (r5 >= (this.barcodeColumnCount + 2)) goto L19;
        DetectionResultColumn r6 = this.detectionResultColumns[r5];
        if (r6 != null) goto L14;
        r1.format("    |   ", new Object[0]);
    L18:
        r5 = r5 + 1;
        goto L10
    L14:
        Codeword r7 = r6.getCodewords()[r4];
        if (r7 != null) goto L17;
        r1.format("    |   ", new Object[0]);
        goto L18
    L17:
        r1.format(" %3d|%3d", new Object[]{Integer.valueOf(r7.getRowNumber()), Integer.valueOf(r7.getValue())});
        goto L18
    L19:
        r1.format("%n", new Object[0]);
        r4 = r4 + 1;
        goto L7
    L20:
        String r9 = r1.toString();
        r1.close();
        return r9;
    }
}
