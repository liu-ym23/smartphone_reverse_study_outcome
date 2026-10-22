package com.google.zxing.client.result;

import com.google.zxing.Result;

/* JADX INFO: loaded from: classes.dex */
public final class SMTPResultParser extends ResultParser {
    public SMTPResultParser() {
    }

    @Override // com.google.zxing.client.result.ResultParser
    public /* bridge */ /* synthetic */ ParsedResult parse(Result r1) {
        return parse(r1);
    }

    @Override // com.google.zxing.client.result.ResultParser
    public EmailAddressParsedResult parse(Result r10) {
        String r9 = getMassagedText(r10);
        if (r9.startsWith("smtp:") == false) goto L5;
    L7:
        String r11 = r9.substring(5);
        int r1 = r11.indexOf(58);
        if (r1 < 0) goto L13;
        String r3 = r11.substring(r1 + 1);
        r11 = r11.substring(0, r1);
        int r12 = r3.indexOf(58);
        if (r12 < 0) goto L12;
        String r0 = r3.substring(r12 + 1);
        String r7 = r3.substring(0, r12);
        String r8 = r0;
    L15:
        return new EmailAddressParsedResult(new String[]{r11}, null, null, r7, r8);
    L12:
        r8 = null;
        r7 = r3;
        goto L15
    L13:
        r7 = null;
        r8 = null;
        goto L15
    L5:
        if (r9.startsWith("SMTP:") == true) goto L7;
        return null;
    }
}
