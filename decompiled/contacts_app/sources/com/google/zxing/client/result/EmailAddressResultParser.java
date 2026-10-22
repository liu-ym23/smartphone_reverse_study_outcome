package com.google.zxing.client.result;

import androidx.core.net.MailTo;
import com.android.contacts.common.SimContactsConstants;
import com.google.zxing.Result;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class EmailAddressResultParser extends ResultParser {
    private static final Pattern COMMA = null;

    public EmailAddressResultParser() {
    }

    @Override // com.google.zxing.client.result.ResultParser
    public /* bridge */ /* synthetic */ ParsedResult parse(Result r1) {
        return parse(r1);
    }

    static {
        COMMA = Pattern.compile(SimContactsConstants.EMAIL_SEP);
    }

    @Override // com.google.zxing.client.result.ResultParser
    public EmailAddressParsedResult parse(Result r10) {
        String r9 = getMassagedText(r10);
        String[] r0 = null;
        if (r9.startsWith(MailTo.MAILTO_SCHEME) == false) goto L5;
    L12:
        String r11 = r9.substring(7);
        int r1 = r11.indexOf(63);
        if (r1 < 0) goto L38;
        r11 = r11.substring(0, r1);
    L38:
        String r12 = urlDecode(r11);     // Catch: IllegalArgumentException -> L37
        if (r12.isEmpty() == true) goto L19;
        String[] r13 = COMMA.split(r12);
    L20:
        Map<String, String> r14 = parseNameValuePairs(r9);
        if (r14 == null) goto L34;
        if (r13 != null) goto L26;
        String r2 = r14.get("to");
        if (r2 == null) goto L26;
        r13 = COMMA.split(r2);
    L26:
        String r3 = r14.get("cc");
        if (r3 == null) goto L29;
        String[] r4 = COMMA.split(r3);
    L30:
        String r5 = r14.get("bcc");
        if (r5 == null) goto L33;
        r0 = COMMA.split(r5);
    L33:
        String r6 = r14.get("subject");
        String r8 = r14.get("body");
        String[] r7 = r13;
        String[] r15 = r0;
        String[] r16 = r4;
        String r17 = r6;
    L36:
        return new EmailAddressParsedResult(r7, r16, r15, r17, r8);
    L29:
        r4 = null;
        goto L30
    L34:
        r7 = r13;
        r16 = null;
        r15 = null;
        r17 = null;
        r8 = null;
        goto L36
    L19:
        r13 = null;
    L37:
        return null;
    L5:
        if (r9.startsWith("MAILTO:") == true) goto L12;
        if (EmailDoCoMoResultParser.isBasicallyValidEmailAddress(r9) == true) goto L11;
        return null;
    L11:
        return new EmailAddressParsedResult(r9);
    }
}
