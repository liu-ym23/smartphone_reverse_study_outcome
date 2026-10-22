package com.networknt.schema.resource;

import com.networknt.schema.AbsoluteIri;

/* loaded from: classes2.dex */
public class MetaSchemaIdResolver implements SchemaIdResolver {
    private static final char ANCHOR = '#';
    private static final String CLASSPATH_PREFIX = "classpath:";
    private static final String HTTPS_JSON_SCHEMA_ORG_PREFIX = "https://json-schema.org/";
    private static final String HTTP_JSON_SCHEMA_ORG_PREFIX = "http://json-schema.org/";

    public static class Holder {
        private static MetaSchemaIdResolver INSTANCE = new MetaSchemaIdResolver();

        private Holder() {
        }
    }

    public static MetaSchemaIdResolver getInstance() {
        return Holder.INSTANCE;
    }

    @Override // com.networknt.schema.resource.SchemaIdResolver
    public AbsoluteIri resolve(AbsoluteIri absoluteIri) {
        String string = absoluteIri != null ? absoluteIri.toString() : null;
        if (string == null) {
            return null;
        }
        if (string.startsWith(HTTPS_JSON_SCHEMA_ORG_PREFIX)) {
            return AbsoluteIri.of(CLASSPATH_PREFIX + string.substring(24));
        }
        if (!string.startsWith(HTTP_JSON_SCHEMA_ORG_PREFIX)) {
            return null;
        }
        int length = string.length();
        int i10 = length - 1;
        if (string.charAt(i10) == '#') {
            length = i10;
        }
        return AbsoluteIri.of(CLASSPATH_PREFIX + string.substring(23, length));
    }
}
