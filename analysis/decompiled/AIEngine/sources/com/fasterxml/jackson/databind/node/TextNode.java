package com.fasterxml.jackson.databind.node;

import b3.h;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class TextNode extends ValueNode {

    /* renamed from: b, reason: collision with root package name */
    public static final TextNode f4285b = new TextNode("");

    /* renamed from: a, reason: collision with root package name */
    public final String f4286a;

    public TextNode(String str) {
        this.f4286a = str;
    }

    @Override // com.fasterxml.jackson.databind.node.BaseJsonNode, b3.e
    public final void a(JsonGenerator jsonGenerator, h hVar) {
        String str = this.f4286a;
        if (str == null) {
            jsonGenerator.J0();
        } else {
            jsonGenerator.f1(str);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && (obj instanceof TextNode)) {
            return ((TextNode) obj).f4286a.equals(this.f4286a);
        }
        return false;
    }

    @Override // b3.d
    public final JsonNodeType g() {
        return JsonNodeType.f4277l;
    }

    @Override // com.fasterxml.jackson.databind.node.ValueNode
    public final JsonToken h() {
        return JsonToken.VALUE_STRING;
    }

    public final int hashCode() {
        return this.f4286a.hashCode();
    }
}
