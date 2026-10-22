package com.networknt.schema.resource;

import com.networknt.schema.AbsoluteIri;

/* loaded from: classes2.dex */
public class PrefixSchemaIdResolver implements SchemaIdResolver {
    private final String replacement;
    private final String source;

    public PrefixSchemaIdResolver(String str, String str2) {
        this.source = str;
        this.replacement = str2;
    }

    @Override // com.networknt.schema.resource.SchemaIdResolver
    public AbsoluteIri resolve(AbsoluteIri absoluteIri) {
        String string = absoluteIri != null ? absoluteIri.toString() : null;
        if (string == null || !string.startsWith(this.source)) {
            return null;
        }
        return AbsoluteIri.of(this.replacement + string.substring(this.source.length()));
    }
}
