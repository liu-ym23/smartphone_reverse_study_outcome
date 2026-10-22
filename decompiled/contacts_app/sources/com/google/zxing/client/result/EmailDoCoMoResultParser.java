package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class EmailDoCoMoResultParser extends AbstractDoCoMoResultParser {
    private static final Pattern ATEXT_ALPHANUMERIC = null;

    public EmailDoCoMoResultParser() {
    }

    @Override // com.google.zxing.client.result.ResultParser
    public /* bridge */ /* synthetic */ ParsedResult parse(Result r1) {
        return parse(r1);
    }

    static {
        ATEXT_ALPHANUMERIC = Pattern.compile("[a-zA-Z0-9@.!#$%&'*+\\-/=?^_`{|}~]+");
    }

    @Override // com.google.zxing.client.result.ResultParser
    public EmailAddressParsedResult parse(Result r9) {
        String r8 = getMassagedText(r9);
        if (r8.startsWith("MATMSG:") == true) goto L5;
        return null;
    L5:
        String[] r3 = matchDoCoMoPrefixedField("TO:", r8, true);
        if (r3 != null) goto L8;
        return null;
    L8:
        int r10 = r3.length;
        int r2 = 0;
    L9:
        if (r2 >= r10) goto L15;
        if (isBasicallyValidEmailAddress(r3[r2]) == false) goto L12;
        r2 = r2 + 1;
        goto L9
    L12:
        return null;
    L15:
        return new EmailAddressParsedResult(r3, null, null, matchSingleDoCoMoPrefixedField("SUB:", r8, false), matchSingleDoCoMoPrefixedField("BODY:", r8, false));
    }

    static boolean isBasicallyValidEmailAddress(String r1) {
        if (r1 != null) goto L4;
        return false;
    L4:
        if (ATEXT_ALPHANUMERIC.matcher(r1).matches() == true) goto L6;
        return false;
    L6:
        if (r1.indexOf(64) < 0) goto L12;
        return true;
    L12:
        return false;
    }
}
