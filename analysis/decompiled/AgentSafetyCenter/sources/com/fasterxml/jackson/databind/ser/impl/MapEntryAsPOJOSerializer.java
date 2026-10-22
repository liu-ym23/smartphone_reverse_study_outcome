package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class MapEntryAsPOJOSerializer extends StdSerializer<Map.Entry<?, ?>> {
    private static final long serialVersionUID = 1;

    public MapEntryAsPOJOSerializer(JavaType javaType) {
        super(javaType);
    }

    public static MapEntryAsPOJOSerializer create(SerializerProvider serializerProvider, JavaType javaType) {
        return new MapEntryAsPOJOSerializer(javaType);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.JsonSerializer
    public void serialize(Map.Entry<?, ?> entry, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.writeStartObject(entry);
        serializerProvider.defaultSerializeField("key", entry.getKey(), jsonGenerator);
        serializerProvider.defaultSerializeField("value", entry.getValue(), jsonGenerator);
        jsonGenerator.writeEndObject();
    }
}
