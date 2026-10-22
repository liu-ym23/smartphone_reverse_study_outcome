package com.fasterxml.jackson.databind.node;

import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class NullNode extends ValueNode {

    /* renamed from: a, reason: collision with root package name */
    public static final NullNode f4282a = new NullNode();

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, b3.e
    public final void a(JsonGenerator jsonGenerator, h hVar) {
        hVar.p(jsonGenerator);
    }

    public final boolean equals(Object obj) {
        return obj == this || (obj instanceof NullNode);
    }

    @Override // b3.d
    public final JsonNodeType g() {
        return JsonNodeType.f4274e;
    }

    @Override // com.fasterxml.jackson.databind.node.ValueNode
    public final JsonToken h() {
        return JsonToken.VALUE_NULL;
    }

    public final int hashCode() {
        return 4;
    }

    public Object readResolve() {
        return f4282a;
    }
}
