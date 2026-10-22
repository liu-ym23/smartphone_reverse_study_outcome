package com.google.zxing.client.result;

import kotlin.text.Typography;

/* JADX INFO: loaded from: classes.dex */
public final class SMSParsedResult extends ParsedResult {
    private final String body;
    private final String[] numbers;
    private final String subject;
    private final String[] vias;

    public SMSParsedResult(String r4, String r5, String r6, String r7) {
        super(ParsedResultType.SMS);
        this.numbers = new String[]{r4};
        this.vias = new String[]{r5};
        this.subject = r6;
        this.body = r7;
    }

    public SMSParsedResult(String[] r2, String[] r3, String r4, String r5) {
        super(ParsedResultType.SMS);
        this.numbers = r2;
        this.vias = r3;
        this.subject = r4;
        this.body = r5;
    }

    public String getSMSURI() {
        StringBuilder r0 = new StringBuilder("sms:");
        boolean r1 = true;
        boolean r4 = true;
        int r3 = 0;
    L4:
        if (r3 >= this.numbers.length) goto L15;
        if (r4 == false) goto L7;
        r4 = false;
    L8:
        r0.append(this.numbers[r3]);
        String[] r5 = this.vias;
        if (r5 == null) goto L13;
        if (r5[r3] == null) goto L13;
        r0.append(";via=");
        r0.append(this.vias[r3]);
    L13:
        r3 = r3 + 1;
        goto L4
    L7:
        r0.append(',');
        goto L8
    L15:
        if (this.body == null) goto L17;
        boolean r6 = true;
    L19:
        if (this.subject != null) goto L22;
        r1 = false;
    L22:
        if (r6 == true) goto L24;
        if (r1 == true) goto L24;
    L32:
        return r0.toString();
    L24:
        r0.append('?');
        if (r6 == false) goto L27;
        r0.append("body=");
        r0.append(this.body);
    L27:
        if (r1 == false) goto L32;
        if (r6 == false) goto L30;
        r0.append(Typography.amp);
    L30:
        r0.append("subject=");
        r0.append(this.subject);
        goto L32
    L17:
        r6 = false;
        goto L19
    }

    public String[] getNumbers() {
        return this.numbers;
    }

    public String[] getVias() {
        return this.vias;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getBody() {
        return this.body;
    }

    @Override // com.google.zxing.client.result.ParsedResult
    public String getDisplayResult() {
        StringBuilder r0 = new StringBuilder(100);
        maybeAppend(this.numbers, r0);
        maybeAppend(this.subject, r0);
        maybeAppend(this.body, r0);
        return r0.toString();
    }
}
