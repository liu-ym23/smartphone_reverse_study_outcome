package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes2.dex */
public class MapEntryAsPOJOSerializer extends StdSerializer<Map.Entry<?, ?>> {
    private static final long serialVersionUID = 1;

    public MapEntryAsPOJOSerializer(JavaType javaType) {
        super(javaType);
    }

    public static MapEntryAsPOJOSerializer create(SerializerProvider serializerProvider, JavaType javaType) {
        return new MapEntryAsPOJOSerializer(javaType);
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdSerializer, com.fasterxml.jackson.databind.JsonSerializer
    public void serialize(Map.Entry<?, ?> entry, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject(entry);
        serializerProvider.defaultSerializeField("key", entry.getKey(), jsonGenerator);
        serializerProvider.defaultSerializeField(UxipConstants.f30680s, entry.getValue(), jsonGenerator);
        jsonGenerator.writeEndObject();
    }
}
