package com.fasterxml.jackson.databind.node;

import b3.d;
import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class ValueNode extends BaseJsonNode {
    @Override // b3.e
    public void b(JsonGenerator jsonGenerator, h hVar, e eVar) {
        WritableTypeId writableTypeIdE = eVar.e(jsonGenerator, eVar.d(h(), this));
        a(jsonGenerator, hVar);
        eVar.f(jsonGenerator, writableTypeIdE);
    }

    @Override // b3.d
    public final d f(String str) {
        return null;
    }

    public abstract JsonToken h();
}
