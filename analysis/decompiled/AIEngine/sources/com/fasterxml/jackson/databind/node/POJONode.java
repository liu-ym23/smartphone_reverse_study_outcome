package com.fasterxml.jackson.databind.node;

import b3.e;
import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class POJONode extends ValueNode {

    /* renamed from: a, reason: collision with root package name */
    public final Object f4284a;

    public POJONode(Object obj) {
        this.f4284a = obj;
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, b3.e
    public final void a(JsonGenerator jsonGenerator, h hVar) {
        Object obj = this.f4284a;
        if (obj == null) {
            hVar.p(jsonGenerator);
        } else if (obj instanceof e) {
            ((e) obj).a(jsonGenerator, hVar);
        } else {
            hVar.getClass();
            hVar.w(obj.getClass()).f(obj, jsonGenerator, hVar);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof POJONode)) {
            return false;
        }
        Object obj2 = ((POJONode) obj).f4284a;
        Object obj3 = this.f4284a;
        return obj3 == null ? obj2 == null : obj3.equals(obj2);
    }

    @Override // b3.d
    public final JsonNodeType g() {
        return JsonNodeType.f4276k;
    }

    @Override // com.fasterxml.jackson.databind.node.ValueNode
    public final JsonToken h() {
        return JsonToken.VALUE_EMBEDDED_OBJECT;
    }

    public final int hashCode() {
        return this.f4284a.hashCode();
    }
}
