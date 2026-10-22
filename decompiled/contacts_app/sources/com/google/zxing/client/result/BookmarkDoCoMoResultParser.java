package com.google.zxing.client.result;

import com.google.zxing.Result;

/* JADX INFO: loaded from: classes.dex */
public final class BookmarkDoCoMoResultParser extends AbstractDoCoMoResultParser {
    public BookmarkDoCoMoResultParser() {
    }

    @Override // com.google.zxing.client.result.ResultParser
    public /* bridge */ /* synthetic */ ParsedResult parse(Result r1) {
        return parse(r1);
    }

    @Override // com.google.zxing.client.result.ResultParser
    public URIParsedResult parse(Result r4) {
        String r3 = r4.getText();
        if (r3.startsWith("MEBKM:") == true) goto L5;
        return null;
    L5:
        String r5 = matchSingleDoCoMoPrefixedField("TITLE:", r3, true);
        String[] r6 = matchDoCoMoPrefixedField("URL:", r3, true);
        if (r6 != null) goto L8;
        return null;
    L8:
        String r7 = r6[0];
        if (URIResultParser.isBasicallyValidURI(r7) == true) goto L11;
        return null;
    L11:
        return new URIParsedResult(r7, r5);
    }
}
