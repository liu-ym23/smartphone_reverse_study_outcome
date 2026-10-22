package com.fasterxml.jackson.databind.node;

import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class LongNode extends NumericNode {

    /* renamed from: a, reason: collision with root package name */
    public final long f4279a;

    public LongNode(long j10) {
        this.f4279a = j10;
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, b3.e
    public final void a(JsonGenerator jsonGenerator, h hVar) {
        jsonGenerator.N0(this.f4279a);
    }

    @Override // b3.d
    public final float e() {
        return this.f4279a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && (obj instanceof LongNode) && ((LongNode) obj).f4279a == this.f4279a;
    }

    @Override // com.fasterxml.jackson.databind.node.ValueNode
    public final JsonToken h() {
        return JsonToken.VALUE_NUMBER_INT;
    }

    public final int hashCode() {
        long j10 = this.f4279a;
        return ((int) j10) ^ ((int) (j10 >> 32));
    }
}
