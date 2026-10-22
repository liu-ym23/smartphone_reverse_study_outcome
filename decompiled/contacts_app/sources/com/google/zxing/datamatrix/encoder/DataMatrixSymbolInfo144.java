package com.google.zxing.datamatrix.encoder;

import com.obric.oui.dialog.base.AbstractDialog;

/* JADX INFO: loaded from: classes3.dex */
final class DataMatrixSymbolInfo144 extends SymbolInfo {
    @Override // com.google.zxing.datamatrix.encoder.SymbolInfo
    public int getDataLengthForInterleavedBlock(int r1) {
        if (r1 > 8) goto L6;
        return AbstractDialog.HORIZONTAL_TOP_SYSBAR_HEIGHT;
    L6:
        return 155;
    }

    @Override // com.google.zxing.datamatrix.encoder.SymbolInfo
    public int getInterleavedBlockCount() {
        return 10;
    }

    DataMatrixSymbolInfo144() {
        super(false, 1558, 620, 22, 22, 36, -1, 62);
    }
}
