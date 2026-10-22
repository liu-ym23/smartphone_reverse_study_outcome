package com.networknt.schema.format;

import com.networknt.schema.ExecutionContext;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class PatternFormat implements Format {
    private final String messageKey;
    private final String name;
    private final Pattern pattern;

    private PatternFormat(String str, String str2, String str3) {
        this.name = str;
        this.messageKey = str3;
        this.pattern = Pattern.compile(str2);
    }

    public static PatternFormat of(String str, String str2, String str3) {
        if (str3 == null) {
            str3 = "format";
        }
        return new PatternFormat(str, str2, str3);
    }

    @Override // com.networknt.schema.format.Format
    public String getMessageKey() {
        return this.messageKey;
    }

    @Override // com.networknt.schema.format.Format
    public String getName() {
        return this.name;
    }

    @Override // com.networknt.schema.format.Format
    public boolean matches(ExecutionContext executionContext, String str) {
        return this.pattern.matcher(str).matches();
    }
}
