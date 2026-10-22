package com.fasterxml.jackson.dataformat.yaml;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class JacksonYAMLParseException extends JsonParseException {
    private static final long serialVersionUID = 1;

    public JacksonYAMLParseException(JsonParser jsonParser, String str, Exception exc) {
        super(jsonParser, str, exc);
    }
}
