package com.google.zxing.pdf417.decoder;

/* JADX INFO: loaded from: classes3.dex */
final class BarcodeMetadata {
    private final int columnCount;
    private final int errorCorrectionLevel;
    private final int rowCount;
    private final int rowCountLowerPart;
    private final int rowCountUpperPart;

    BarcodeMetadata(int r1, int r2, int r3, int r4) {
        this.columnCount = r1;
        this.errorCorrectionLevel = r4;
        this.rowCountUpperPart = r2;
        this.rowCountLowerPart = r3;
        this.rowCount = r2 + r3;
    }

    int getColumnCount() {
        return this.columnCount;
    }

    int getErrorCorrectionLevel() {
        return this.errorCorrectionLevel;
    }

    int getRowCount() {
        return this.rowCount;
    }

    int getRowCountUpperPart() {
        return this.rowCountUpperPart;
    }

    int getRowCountLowerPart() {
        return this.rowCountLowerPart;
    }
}
