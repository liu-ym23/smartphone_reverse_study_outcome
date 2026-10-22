package com.google.zxing.client.result;

import com.google.zxing.Result;

/* JADX INFO: loaded from: classes.dex */
public final class WifiResultParser extends ResultParser {
    public WifiResultParser() {
    }

    @Override // com.google.zxing.client.result.ResultParser
    public /* bridge */ /* synthetic */ ParsedResult parse(Result r1) {
        return parse(r1);
    }

    @Override // com.google.zxing.client.result.ResultParser
    public WifiParsedResult parse(Result r6) {
        String r5 = getMassagedText(r6);
        if (r5.startsWith("WIFI:") == true) goto L5;
        return null;
    L5:
        String r7 = matchSinglePrefixedField("S:", r5, ';', false);
        if (r7 != null) goto L8;
    L15:
        return null;
    L8:
        if (r7.isEmpty() == true) goto L15;
        String r0 = matchSinglePrefixedField("P:", r5, ';', false);
        String r3 = matchSinglePrefixedField("T:", r5, ';', false);
        if (r3 != null) goto L14;
        r3 = "nopass";
    L14:
        return new WifiParsedResult(r3, r7, r0, Boolean.parseBoolean(matchSinglePrefixedField("H:", r5, ';', false)));
    }
}
