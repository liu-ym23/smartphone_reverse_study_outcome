package org.threeten.bp.format;

import org.threeten.bp.DateTimeException;

/* JADX INFO: loaded from: classes4.dex */
public class DateTimeParseException extends DateTimeException {
    private static final long serialVersionUID = 4304633501674722597L;
    private final int errorIndex;
    private final String parsedString;

    public DateTimeParseException(String r10, CharSequence r11, int r12) {
        super(r10);
        this.parsedString = r11.toString();
        this.errorIndex = r12;
    }

    public int getErrorIndex() {
        return this.errorIndex;
    }

    public String getParsedString() {
        return this.parsedString;
    }

    public DateTimeParseException(String r10, CharSequence r11, int r12, Throwable r13) {
        super(r10, r13);
        this.parsedString = r11.toString();
        this.errorIndex = r12;
    }
}
