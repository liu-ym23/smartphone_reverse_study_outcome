package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.type.LogicalType;
import java.io.IOException;
import java.nio.ByteBuffer;
import q3.f;
import v2.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ByteBufferDeserializer extends StdScalarDeserializer<ByteBuffer> {
    public ByteBufferDeserializer() {
        super(ByteBuffer.class);
    }

    @Override // b3.c
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) {
        jsonParser.getClass();
        return ByteBuffer.wrap(jsonParser.S(a.f13372b));
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, b3.c
    public final Object e(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        f fVar = new f(byteBuffer);
        jsonParser.s1(deserializationContext.f3663c.f3828b.f3795k, fVar);
        fVar.close();
        return byteBuffer;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, b3.c
    public final LogicalType o() {
        return LogicalType.f4437n;
    }
}
