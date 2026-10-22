package org.threeten.bp.format;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.threeten.bp.DateTimeException;

/* JADX INFO: loaded from: classes5.dex */
public class DateTimeParseException extends DateTimeException {
    private static final long serialVersionUID = 4304633501674722597L;
    private final int errorIndex;
    private final String parsedString;

    public DateTimeParseException(String r3, CharSequence r4, int r5) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        super(r3);
        this.parsedString = r6.toString();
        this.errorIndex = r5;
    }

    public DateTimeParseException(String r3, CharSequence r4, int r5, Throwable r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
        super(r3, r6);
        this.parsedString = r7.toString();
        this.errorIndex = r5;
    }

    public String getParsedString() {
        return this.parsedString;
    }

    public int getErrorIndex() {
        return this.errorIndex;
    }
}
