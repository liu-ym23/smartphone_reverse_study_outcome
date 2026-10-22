package com.fasterxml.jackson.databind.node;

import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class FloatNode extends NumericNode {

    /* renamed from: a, reason: collision with root package name */
    public final float f4266a;

    public FloatNode(float f8) {
        this.f4266a = f8;
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, b3.e
    public final void a(JsonGenerator jsonGenerator, h hVar) {
        jsonGenerator.L0(this.f4266a);
    }

    @Override // b3.d
    public final float e() {
        return this.f4266a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof FloatNode)) {
            if (Float.compare(this.f4266a, ((FloatNode) obj).f4266a) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.fasterxml.jackson.databind.node.ValueNode
    public final JsonToken h() {
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.f4266a);
    }
}
