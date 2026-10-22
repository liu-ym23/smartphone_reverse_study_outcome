package com.networknt.schema.format;

import java.net.URI;

/* loaded from: classes2.dex */
public class IriFormat extends AbstractRFC3986Format {
    @Override // com.networknt.schema.format.Format
    public String getMessageKey() {
        return "format.iri";
    }

    @Override // com.networknt.schema.format.Format
    public String getName() {
        return "iri";
    }

    @Override // com.networknt.schema.format.AbstractRFC3986Format
    public boolean validate(URI uri) {
        boolean zIsAbsolute = uri.isAbsolute();
        if (zIsAbsolute) {
            String authority = uri.getAuthority();
            if (authority != null && IPv6Format.PATTERN.matcher(authority).matches()) {
                return false;
            }
            String rawQuery = uri.getRawQuery();
            if (rawQuery != null && (rawQuery.indexOf(91) != -1 || rawQuery.indexOf(93) != -1)) {
                return false;
            }
        }
        return zIsAbsolute;
    }
}
