package com.fasterxml.jackson.databind.node;

import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class BooleanNode extends ValueNode {

    /* renamed from: b, reason: collision with root package name */
    public static final BooleanNode f4259b = new BooleanNode(true);

    /* renamed from: c, reason: collision with root package name */
    public static final BooleanNode f4260c = new BooleanNode(false);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f4261a;

    public BooleanNode(boolean z) {
        this.f4261a = z;
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, b3.e
    public final void a(JsonGenerator jsonGenerator, h hVar) {
        jsonGenerator.g0(this.f4261a);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof BooleanNode)) {
            return this.f4261a == ((BooleanNode) obj).f4261a;
        }
        return false;
    }

    @Override // b3.d
    public final JsonNodeType g() {
        return JsonNodeType.f4272c;
    }

    @Override // com.fasterxml.jackson.databind.node.ValueNode
    public final JsonToken h() {
        return this.f4261a ? JsonToken.VALUE_TRUE : JsonToken.VALUE_FALSE;
    }

    public final int hashCode() {
        return this.f4261a ? 3 : 1;
    }

    public Object readResolve() {
        return this.f4261a ? f4259b : f4260c;
    }
}
