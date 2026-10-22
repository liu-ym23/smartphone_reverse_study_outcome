package com.fasterxml.jackson.databind.ser.std;

import b3.h;
import c3.a;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public class ByteArraySerializer extends StdSerializer<byte[]> {
    public ByteArraySerializer() {
        super(byte[].class);
    }

    @Override // b3.f
    public final boolean d(h hVar, Object obj) {
        return ((byte[]) obj).length == 0;
    }

    @Override // b3.f
    public final void f(Object obj, JsonGenerator jsonGenerator, h hVar) {
        byte[] bArr = (byte[]) obj;
        jsonGenerator.c0(hVar.f3044a.f3828b.f3795k, bArr, 0, bArr.length);
    }

    @Override // b3.f
    public final void g(Object obj, JsonGenerator jsonGenerator, h hVar, e eVar) {
        byte[] bArr = (byte[]) obj;
        WritableTypeId writableTypeIdE = eVar.e(jsonGenerator, eVar.d(JsonToken.VALUE_EMBEDDED_OBJECT, bArr));
        jsonGenerator.c0(hVar.f3044a.f3828b.f3795k, bArr, 0, bArr.length);
        eVar.f(jsonGenerator, writableTypeIdE);
    }
}
