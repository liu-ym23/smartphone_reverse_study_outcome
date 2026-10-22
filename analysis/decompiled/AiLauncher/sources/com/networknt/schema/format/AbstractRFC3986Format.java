package com.networknt.schema.format;

import com.networknt.schema.ExecutionContext;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public abstract class AbstractRFC3986Format implements Format {
    private static final Pattern VALID = Pattern.compile("([A-Za-z0-9+-\\.]*:)?//|[A-Za-z0-9+-\\.]+:");

    public boolean handleException(URISyntaxException uRISyntaxException) {
        return VALID.matcher(uRISyntaxException.getInput()).matches();
    }

    @Override // com.networknt.schema.format.Format
    public final boolean matches(ExecutionContext executionContext, String str) {
        try {
            return validate(new URI(str));
        } catch (URISyntaxException e10) {
            return this.handleException(e10);
        }
    }

    public abstract boolean validate(URI uri);
}
