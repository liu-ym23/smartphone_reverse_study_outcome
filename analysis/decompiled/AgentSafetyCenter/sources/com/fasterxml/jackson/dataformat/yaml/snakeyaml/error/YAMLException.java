package com.fasterxml.jackson.dataformat.yaml.snakeyaml.error;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.dataformat.yaml.JacksonYAMLParseException;
import yd.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Deprecated
/* loaded from: classes.dex */
public class YAMLException extends JacksonYAMLParseException {
    private static final long serialVersionUID = 1;

    public YAMLException(JsonParser jsonParser, c cVar) {
        super(jsonParser, cVar.getMessage(), cVar);
    }

    public static YAMLException from(JsonParser jsonParser, c cVar) {
        return new YAMLException(jsonParser, cVar);
    }
}
