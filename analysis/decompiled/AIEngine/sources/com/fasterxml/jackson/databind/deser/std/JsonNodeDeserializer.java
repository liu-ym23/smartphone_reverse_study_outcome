package com.fasterxml.jackson.databind.deser.std;

import b3.c;
import b3.d;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.LogicalType;
import k3.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class JsonNodeDeserializer extends BaseNodeDeserializer<d> {

    /* renamed from: e, reason: collision with root package name */
    public static final JsonNodeDeserializer f3993e = new JsonNodeDeserializer();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ArrayDeserializer extends BaseNodeDeserializer<ArrayNode> {

        /* renamed from: e, reason: collision with root package name */
        public static final ArrayDeserializer f3994e = new ArrayDeserializer();

        public ArrayDeserializer() {
            super(ArrayNode.class, Boolean.TRUE);
        }

        @Override // b3.c
        public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
            if (jsonParser.l1()) {
                return n0(jsonParser, deserializationContext, deserializationContext.f3663c.f3658n);
            }
            deserializationContext.C(ArrayNode.class, jsonParser);
            throw null;
        }

        @Override // b3.c
        public final Object e(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws MismatchedInputException {
            ArrayNode arrayNode = (ArrayNode) obj;
            if (jsonParser.l1()) {
                q0(jsonParser, deserializationContext, arrayNode);
                return arrayNode;
            }
            deserializationContext.C(ArrayNode.class, jsonParser);
            throw null;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class ObjectDeserializer extends BaseNodeDeserializer<ObjectNode> {

        /* renamed from: e, reason: collision with root package name */
        public static final ObjectDeserializer f3995e = new ObjectDeserializer();

        public ObjectDeserializer() {
            super(ObjectNode.class, Boolean.TRUE);
        }

        @Override // b3.c
        public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
            if (jsonParser.m1()) {
                return o0(jsonParser, deserializationContext, deserializationContext.f3663c.f3658n);
            }
            if (jsonParser.i1(JsonToken.FIELD_NAME)) {
                return p0(jsonParser, deserializationContext, deserializationContext.f3663c.f3658n);
            }
            if (!jsonParser.i1(JsonToken.END_OBJECT)) {
                deserializationContext.C(ObjectNode.class, jsonParser);
                throw null;
            }
            JsonNodeFactory jsonNodeFactory = deserializationContext.f3663c.f3658n;
            jsonNodeFactory.getClass();
            return new ObjectNode(jsonNodeFactory);
        }

        @Override // b3.c
        public final Object e(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws MismatchedInputException {
            ObjectNode objectNode = (ObjectNode) obj;
            if (jsonParser.m1() || jsonParser.i1(JsonToken.FIELD_NAME)) {
                return (ObjectNode) r0(jsonParser, deserializationContext, objectNode);
            }
            deserializationContext.C(ObjectNode.class, jsonParser);
            throw null;
        }
    }

    public JsonNodeDeserializer() {
        super(d.class, null);
    }

    public static c<? extends d> s0(Class<?> cls) {
        return cls == ObjectNode.class ? ObjectDeserializer.f3995e : cls == ArrayNode.class ? ArrayDeserializer.f3994e : f3993e;
    }

    @Override // b3.c, e3.i
    public final Object a(DeserializationContext deserializationContext) {
        deserializationContext.f3663c.f3658n.getClass();
        return NullNode.f4282a;
    }

    @Override // b3.c
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) {
        int iP = jsonParser.P();
        return iP != 1 ? iP != 3 ? m0(jsonParser, deserializationContext, deserializationContext.f3663c.f3658n) : n0(jsonParser, deserializationContext, deserializationContext.f3663c.f3658n) : o0(jsonParser, deserializationContext, deserializationContext.f3663c.f3658n);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer, com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
    public final Object f(JsonParser jsonParser, DeserializationContext deserializationContext, b bVar) {
        return bVar.b(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer, b3.c
    public final /* bridge */ /* synthetic */ boolean n() {
        return true;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer, b3.c
    public final /* bridge */ /* synthetic */ LogicalType o() {
        return LogicalType.f4432e;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer, b3.c
    public final Boolean p(DeserializationConfig deserializationConfig) {
        return this.f3954d;
    }
}
