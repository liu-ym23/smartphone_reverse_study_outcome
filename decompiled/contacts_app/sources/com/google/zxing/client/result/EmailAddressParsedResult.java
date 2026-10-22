package com.google.zxing.client.result;

import androidx.core.net.MailTo;

/* JADX INFO: loaded from: classes.dex */
public final class EmailAddressParsedResult extends ParsedResult {
    private final String[] bccs;
    private final String body;
    private final String[] ccs;
    private final String subject;
    private final String[] tos;

    @Deprecated
    public String getMailtoURI() {
        return MailTo.MAILTO_SCHEME;
    }

    EmailAddressParsedResult(String r8) {
        this(new String[]{r8}, null, null, null, null);
    }

    EmailAddressParsedResult(String[] r2, String[] r3, String[] r4, String r5, String r6) {
        super(ParsedResultType.EMAIL_ADDRESS);
        this.tos = r2;
        this.ccs = r3;
        this.bccs = r4;
        this.subject = r5;
        this.body = r6;
    }

    @Deprecated
    public String getEmailAddress() {
        String[] r1 = this.tos;
        if (r1 != null) goto L5;
        return null;
    L5:
        if (r1.length != 0) goto L8;
        return null;
    L8:
        return r1[0];
    }

    public String[] getTos() {
        return this.tos;
    }

    public String[] getCCs() {
        return this.ccs;
    }

    public String[] getBCCs() {
        return this.bccs;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getBody() {
        return this.body;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder r0 = new StringBuilder(30);
        maybeAppend(this.tos, r0);
        maybeAppend(this.ccs, r0);
        maybeAppend(this.bccs, r0);
        maybeAppend(this.subject, r0);
        maybeAppend(this.body, r0);
        return r0.toString();
    }
}
