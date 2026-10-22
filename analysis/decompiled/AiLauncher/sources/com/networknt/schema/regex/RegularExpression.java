package com.networknt.schema.regex;

import com.networknt.schema.SchemaContext;

@FunctionalInterface
/* loaded from: classes2.dex */
public interface RegularExpression {
    static /* synthetic */ boolean a(String str) {
        return true;
    }

    static RegularExpression compile(String str, SchemaContext schemaContext) {
        return str == null ? new RegularExpression() { // from class: com.networknt.schema.regex.a
            @Override // com.networknt.schema.regex.RegularExpression
            public final boolean matches(String str2) {
                return RegularExpression.a(str2);
            }
        } : schemaContext.getSchemaRegistryConfig().getRegularExpressionFactory().getRegularExpression(str);
    }

    boolean matches(String str);
}
