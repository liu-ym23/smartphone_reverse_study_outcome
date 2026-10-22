package com.fasterxml.jackson.databind.ext;

import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import com.fasterxml.jackson.databind.ser.std.StdScalarSerializer;
import java.nio.file.Path;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class NioPathSerializer extends StdScalarSerializer<Path> {
    public NioPathSerializer() {
        super(Path.class);
    }

    @Override // b3.f
    public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
        jsonGenerator.f1(((Path) obj).toUri().toString());
    }

    @Override // com.fasterxml.jackson.databind.ser.std.StdScalarSerializer, b3.f
    public final void g(Object obj, JsonGenerator jsonGenerator, h hVar, e eVar) {
        Path path = (Path) obj;
        WritableTypeId writableTypeIdD = eVar.d(JsonToken.VALUE_STRING, path);
        writableTypeIdD.f3620b = Path.class;
        WritableTypeId writableTypeIdE = eVar.e(jsonGenerator, writableTypeIdD);
        jsonGenerator.f1(path.toUri().toString());
        eVar.f(jsonGenerator, writableTypeIdE);
    }
}
