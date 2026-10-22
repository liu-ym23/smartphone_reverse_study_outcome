package com.networknt.schema.format;

import com.networknt.schema.ExecutionContext;
import com.networknt.schema.SchemaContext;
import com.networknt.schema.regex.RegularExpression;

/* loaded from: classes2.dex */
public class RegexFormat implements Format {
    @Override // com.networknt.schema.format.Format
    public String getMessageKey() {
        return "format.regex";
    }

    @Override // com.networknt.schema.format.Format
    public String getName() {
        return "regex";
    }

    @Override // com.networknt.schema.format.Format
    public boolean matches(ExecutionContext executionContext, SchemaContext schemaContext, String str) {
        if (str == null) {
            return true;
        }
        try {
            RegularExpression.compile(str, schemaContext);
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }
}
