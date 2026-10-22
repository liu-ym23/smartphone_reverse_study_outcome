package com.google.zxing.client.result;

import com.google.zxing.Result;

/* JADX INFO: loaded from: classes.dex */
public final class SMSTOMMSTOResultParser extends ResultParser {
    public SMSTOMMSTOResultParser() {
    }

    @Override // com.google.zxing.client.result.ResultParser
    public /* bridge */ /* synthetic */ ParsedResult parse(Result r1) {
        return parse(r1);
    }

    @Override // com.google.zxing.client.result.ResultParser
    public SMSParsedResult parse(Result r4) {
        String r3 = getMassagedText(r4);
        if (r3.startsWith("smsto:") == false) goto L5;
    L11:
        String r5 = r3.substring(6);
        int r6 = r5.indexOf(58);
        if (r6 < 0) goto L14;
        String r1 = r5.substring(r6 + 1);
        r5 = r5.substring(0, r6);
    L16:
        return new SMSParsedResult(r5, null, null, r1);
    L14:
        r1 = null;
        goto L16
    L5:
        if (r3.startsWith("SMSTO:") == true) goto L11;
        if (r3.startsWith("mmsto:") == true) goto L11;
        if (r3.startsWith("MMSTO:") == true) goto L11;
        return null;
    }
}
