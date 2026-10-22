package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.google.zxing.oned.UPCEReader;

/* JADX INFO: loaded from: classes.dex */
public final class ProductResultParser extends ResultParser {
    public ProductResultParser() {
    }

    @Override // com.google.zxing.client.result.ResultParser
    public /* bridge */ /* synthetic */ ParsedResult parse(Result r1) {
        return parse(r1);
    }

    @Override // com.google.zxing.client.result.ResultParser
    public ProductParsedResult parse(Result r3) {
        BarcodeFormat r2 = r3.getBarcodeFormat();
        if (r2 != BarcodeFormat.UPC_A) goto L5;
    L11:
        String r4 = getMassagedText(r3);
        if (isStringOfDigits(r4, r4.length()) == true) goto L15;
        return null;
    L15:
        if (r2 == BarcodeFormat.UPC_E) goto L17;
    L19:
        String r5 = r4;
    L21:
        return new ProductParsedResult(r4, r5);
    L17:
        if (r4.length() != 8) goto L19;
        r5 = UPCEReader.convertUPCEtoUPCA(r4);
        goto L21
    L5:
        if (r2 == BarcodeFormat.UPC_E) goto L11;
        if (r2 == BarcodeFormat.EAN_8) goto L11;
        if (r2 == BarcodeFormat.EAN_13) goto L11;
        return null;
    }
}
