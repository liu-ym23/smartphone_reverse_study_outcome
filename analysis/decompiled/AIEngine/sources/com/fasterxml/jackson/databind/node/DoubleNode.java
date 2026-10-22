package com.fasterxml.jackson.databind.node;

import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class DoubleNode extends NumericNode {

    /* renamed from: a, reason: collision with root package name */
    public final double f4265a;

    public DoubleNode(double d8) {
        this.f4265a = d8;
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, b3.e
    public final void a(JsonGenerator jsonGenerator, h hVar) {
        jsonGenerator.K0(this.f4265a);
    }

    @Override // b3.d
    public final float e() {
        return (float) this.f4265a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof DoubleNode)) {
            if (Double.compare(this.f4265a, ((DoubleNode) obj).f4265a) == 0) {
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
        long jDoubleToLongBits = Double.doubleToLongBits(this.f4265a);
        return ((int) jDoubleToLongBits) ^ ((int) (jDoubleToLongBits >> 32));
    }
}
