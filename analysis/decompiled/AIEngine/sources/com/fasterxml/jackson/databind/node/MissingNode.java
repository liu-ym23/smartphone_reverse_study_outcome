package com.fasterxml.jackson.databind.node;

import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import k3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MissingNode extends ValueNode {

    /* renamed from: a, reason: collision with root package name */
    public static final MissingNode f4280a = new MissingNode();

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, b3.e
    public final void a(JsonGenerator jsonGenerator, h hVar) {
        jsonGenerator.J0();
    }

    @Override // com.fasterxml.jackson.databind.node.ValueNode, b3.e
    public final void b(JsonGenerator jsonGenerator, h hVar, e eVar) {
        jsonGenerator.J0();
    }

    public final boolean equals(Object obj) {
        return obj == this;
    }

    @Override // b3.d
    public final JsonNodeType g() {
        return JsonNodeType.f4273d;
    }

    @Override // com.fasterxml.jackson.databind.node.ValueNode
    public final JsonToken h() {
        return JsonToken.NOT_AVAILABLE;
    }

    public final int hashCode() {
        return 3;
    }

    public Object readResolve() {
        return f4280a;
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode
    public final String toString() {
        return "";
    }
}
