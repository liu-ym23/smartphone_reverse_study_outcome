package com.fasterxml.jackson.databind.jsonschema;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.lang.reflect.Type;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
@Deprecated
/* loaded from: classes.dex */
public interface SchemaAware {
    JsonNode getSchema(SerializerProvider serializerProvider, Type type);

    JsonNode getSchema(SerializerProvider serializerProvider, Type type, boolean z10);
}
