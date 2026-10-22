package com.networknt.schema.format;

import java.net.URI;

/* loaded from: classes2.dex */
public class IriReferenceFormat extends AbstractRFC3986Format {
    @Override // com.networknt.schema.format.Format
    public String getMessageKey() {
        return "format.iri-reference";
    }

    @Override // com.networknt.schema.format.Format
    public String getName() {
        return "iri-reference";
    }

    @Override // com.networknt.schema.format.AbstractRFC3986Format
    public boolean validate(URI uri) {
        String authority = uri.getAuthority();
        if (authority != null && IPv6Format.PATTERN.matcher(authority).matches()) {
            return false;
        }
        String rawQuery = uri.getRawQuery();
        if (rawQuery != null) {
            return rawQuery.indexOf(91) == -1 && rawQuery.indexOf(93) == -1;
        }
        return true;
    }
}
