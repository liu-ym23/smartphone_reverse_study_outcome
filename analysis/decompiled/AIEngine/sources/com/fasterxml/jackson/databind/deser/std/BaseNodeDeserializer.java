package com.fasterxml.jackson.databind.deser.std;

import b3.d;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.StreamReadCapability;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DecimalNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.FloatNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.POJONode;
import com.fasterxml.jackson.databind.node.ValueNode;
import com.fasterxml.jackson.databind.type.LogicalType;
import java.math.BigDecimal;
import java.math.BigInteger;
import k3.b;
import q3.n;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
abstract class BaseNodeDeserializer<T extends d> extends StdDeserializer<T> {

    /* renamed from: d, reason: collision with root package name */
    public final Boolean f3954d;

    public BaseNodeDeserializer(Class<T> cls, Boolean bool) {
        super((Class<?>) cls);
        this.f3954d = bool;
    }

    public static d j0(JsonParser jsonParser, JsonNodeFactory jsonNodeFactory) {
        Object objK0 = jsonParser.K0();
        if (objK0 == null) {
            jsonNodeFactory.getClass();
            return NullNode.f4282a;
        }
        if (objK0.getClass() == byte[].class) {
            byte[] bArr = (byte[]) objK0;
            jsonNodeFactory.getClass();
            BinaryNode binaryNode = BinaryNode.f4257b;
            return bArr.length == 0 ? BinaryNode.f4257b : new BinaryNode(bArr);
        }
        if (objK0 instanceof n) {
            jsonNodeFactory.getClass();
            return new POJONode((n) objK0);
        }
        if (objK0 instanceof d) {
            return (d) objK0;
        }
        jsonNodeFactory.getClass();
        return new POJONode(objK0);
    }

    public static ValueNode k0(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) {
        int i10 = deserializationContext.f3664d;
        int i11 = StdDeserializer.f4053c & i10;
        JsonParser.NumberType numberType = JsonParser.NumberType.f3575b;
        JsonParser.NumberType numberTypeO0 = i11 != 0 ? (DeserializationFeature.USE_BIG_INTEGER_FOR_INTS.f3689b & i10) != 0 ? JsonParser.NumberType.f3576c : (i10 & DeserializationFeature.USE_LONG_FOR_INTS.f3689b) != 0 ? numberType : jsonParser.O0() : jsonParser.O0();
        if (numberTypeO0 == JsonParser.NumberType.f3574a) {
            int iM0 = jsonParser.M0();
            jsonNodeFactory.getClass();
            IntNode[] intNodeArr = IntNode.f4267b;
            return (iM0 > 10 || iM0 < -1) ? new IntNode(iM0) : IntNode.f4267b[iM0 - (-1)];
        }
        if (numberTypeO0 == numberType) {
            long jN0 = jsonParser.N0();
            jsonNodeFactory.getClass();
            return new LongNode(jN0);
        }
        BigInteger bigIntegerQ = jsonParser.Q();
        jsonNodeFactory.getClass();
        return bigIntegerQ == null ? NullNode.f4282a : new BigIntegerNode(bigIntegerQ);
    }

    public static void l0(DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory, String str, ObjectNode objectNode, d dVar, d dVar2) throws MismatchedInputException {
        if (deserializationContext.J(DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY)) {
            throw new MismatchedInputException(deserializationContext.h, String.format("Duplicate field '%s' for `ObjectNode`: not allowed when `DeserializationFeature.FAIL_ON_READING_DUP_TREE_KEY` enabled", str));
        }
        if (deserializationContext.I(StreamReadCapability.DUPLICATE_PROPERTIES)) {
            if (dVar instanceof ArrayNode) {
                ((ArrayNode) dVar).h(dVar2);
                objectNode.h(str, dVar);
                return;
            }
            jsonNodeFactory.getClass();
            ArrayNode arrayNode = new ArrayNode(jsonNodeFactory);
            arrayNode.h(dVar);
            arrayNode.h(dVar2);
            objectNode.h(str, arrayNode);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
    public Object f(JsonParser jsonParser, DeserializationContext deserializationContext, b bVar) {
        return bVar.b(jsonParser, deserializationContext);
    }

    public final d m0(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws MismatchedInputException {
        int iP = jsonParser.P();
        if (iP == 2) {
            jsonNodeFactory.getClass();
            return new ObjectNode(jsonNodeFactory);
        }
        switch (iP) {
            case 5:
                return p0(jsonParser, deserializationContext, jsonNodeFactory);
            case 6:
                String strV0 = jsonParser.V0();
                jsonNodeFactory.getClass();
                return JsonNodeFactory.a(strV0);
            case 7:
                return k0(jsonParser, deserializationContext, jsonNodeFactory);
            case 8:
                JsonParser.NumberType numberTypeO0 = jsonParser.O0();
                if (numberTypeO0 == JsonParser.NumberType.h) {
                    BigDecimal bigDecimalI0 = jsonParser.I0();
                    jsonNodeFactory.getClass();
                    return bigDecimalI0 == null ? NullNode.f4282a : bigDecimalI0.compareTo(BigDecimal.ZERO) == 0 ? DecimalNode.f4263b : new DecimalNode(bigDecimalI0.stripTrailingZeros());
                }
                if (deserializationContext.J(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS)) {
                    if (jsonParser.n1()) {
                        double dJ0 = jsonParser.J0();
                        jsonNodeFactory.getClass();
                        return new DoubleNode(dJ0);
                    }
                    BigDecimal bigDecimalI02 = jsonParser.I0();
                    jsonNodeFactory.getClass();
                    return bigDecimalI02 == null ? NullNode.f4282a : bigDecimalI02.compareTo(BigDecimal.ZERO) == 0 ? DecimalNode.f4263b : new DecimalNode(bigDecimalI02.stripTrailingZeros());
                }
                if (numberTypeO0 == JsonParser.NumberType.f3577d) {
                    float fL0 = jsonParser.L0();
                    jsonNodeFactory.getClass();
                    return new FloatNode(fL0);
                }
                double dJ02 = jsonParser.J0();
                jsonNodeFactory.getClass();
                return new DoubleNode(dJ02);
            case 9:
                jsonNodeFactory.getClass();
                return BooleanNode.f4259b;
            case 10:
                jsonNodeFactory.getClass();
                return BooleanNode.f4260c;
            case 11:
                jsonNodeFactory.getClass();
                return NullNode.f4282a;
            case 12:
                return j0(jsonParser, jsonNodeFactory);
            default:
                deserializationContext.C(this.f4054a, jsonParser);
                throw null;
        }
    }

    @Override // b3.c
    public boolean n() {
        return true;
    }

    public final ArrayNode n0(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) {
        jsonNodeFactory.getClass();
        ArrayNode arrayNode = new ArrayNode(jsonNodeFactory);
        while (true) {
            JsonToken jsonTokenQ1 = jsonParser.q1();
            if (jsonTokenQ1 != null) {
                switch (jsonTokenQ1.f3597d) {
                    case 1:
                        arrayNode.h(o0(jsonParser, deserializationContext, jsonNodeFactory));
                        break;
                    case 2:
                    case 5:
                    case 8:
                    default:
                        arrayNode.h(m0(jsonParser, deserializationContext, jsonNodeFactory));
                        break;
                    case 3:
                        arrayNode.h(n0(jsonParser, deserializationContext, jsonNodeFactory));
                        break;
                    case 4:
                        break;
                    case 6:
                        arrayNode.h(JsonNodeFactory.a(jsonParser.V0()));
                        break;
                    case 7:
                        arrayNode.h(k0(jsonParser, deserializationContext, jsonNodeFactory));
                        break;
                    case 9:
                        arrayNode.h(BooleanNode.f4259b);
                        break;
                    case 10:
                        arrayNode.h(BooleanNode.f4260c);
                        break;
                    case 11:
                        arrayNode.h(NullNode.f4282a);
                        break;
                    case 12:
                        arrayNode.h(j0(jsonParser, jsonNodeFactory));
                        break;
                }
            }
        }
        return arrayNode;
    }

    @Override // b3.c
    public LogicalType o() {
        return LogicalType.f4432e;
    }

    public final ObjectNode o0(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws MismatchedInputException {
        d dVarO0;
        jsonNodeFactory.getClass();
        ObjectNode objectNode = new ObjectNode(jsonNodeFactory);
        String strO1 = jsonParser.o1();
        while (strO1 != null) {
            JsonToken jsonTokenQ1 = jsonParser.q1();
            if (jsonTokenQ1 == null) {
                jsonTokenQ1 = JsonToken.NOT_AVAILABLE;
            }
            int i10 = jsonTokenQ1.f3597d;
            if (i10 == 1) {
                dVarO0 = o0(jsonParser, deserializationContext, jsonNodeFactory);
            } else if (i10 == 3) {
                dVarO0 = n0(jsonParser, deserializationContext, jsonNodeFactory);
            } else if (i10 == 6) {
                dVarO0 = JsonNodeFactory.a(jsonParser.V0());
            } else if (i10 != 7) {
                switch (i10) {
                    case 9:
                        dVarO0 = BooleanNode.f4259b;
                        break;
                    case 10:
                        dVarO0 = BooleanNode.f4260c;
                        break;
                    case 11:
                        dVarO0 = NullNode.f4282a;
                        break;
                    case 12:
                        dVarO0 = j0(jsonParser, jsonNodeFactory);
                        break;
                    default:
                        dVarO0 = m0(jsonParser, deserializationContext, jsonNodeFactory);
                        break;
                }
            } else {
                dVarO0 = k0(jsonParser, deserializationContext, jsonNodeFactory);
            }
            d dVar = dVarO0;
            d dVarH = objectNode.h(strO1, dVar);
            DeserializationContext deserializationContext2 = deserializationContext;
            JsonNodeFactory jsonNodeFactory2 = jsonNodeFactory;
            if (dVarH != null) {
                l0(deserializationContext2, jsonNodeFactory2, strO1, objectNode, dVarH, dVar);
            }
            strO1 = jsonParser.o1();
            deserializationContext = deserializationContext2;
            jsonNodeFactory = jsonNodeFactory2;
        }
        return objectNode;
    }

    @Override // b3.c
    public Boolean p(DeserializationConfig deserializationConfig) {
        return this.f3954d;
    }

    public final ObjectNode p0(JsonParser jsonParser, DeserializationContext deserializationContext, JsonNodeFactory jsonNodeFactory) throws MismatchedInputException {
        d dVarO0;
        jsonNodeFactory.getClass();
        ObjectNode objectNode = new ObjectNode(jsonNodeFactory);
        String strC = jsonParser.C();
        while (strC != null) {
            JsonToken jsonTokenQ1 = jsonParser.q1();
            if (jsonTokenQ1 == null) {
                jsonTokenQ1 = JsonToken.NOT_AVAILABLE;
            }
            int i10 = jsonTokenQ1.f3597d;
            if (i10 == 1) {
                dVarO0 = o0(jsonParser, deserializationContext, jsonNodeFactory);
            } else if (i10 == 3) {
                dVarO0 = n0(jsonParser, deserializationContext, jsonNodeFactory);
            } else if (i10 == 6) {
                dVarO0 = JsonNodeFactory.a(jsonParser.V0());
            } else if (i10 != 7) {
                switch (i10) {
                    case 9:
                        dVarO0 = BooleanNode.f4259b;
                        break;
                    case 10:
                        dVarO0 = BooleanNode.f4260c;
                        break;
                    case 11:
                        dVarO0 = NullNode.f4282a;
                        break;
                    case 12:
                        dVarO0 = j0(jsonParser, jsonNodeFactory);
                        break;
                    default:
                        dVarO0 = m0(jsonParser, deserializationContext, jsonNodeFactory);
                        break;
                }
            } else {
                dVarO0 = k0(jsonParser, deserializationContext, jsonNodeFactory);
            }
            d dVar = dVarO0;
            d dVarH = objectNode.h(strC, dVar);
            DeserializationContext deserializationContext2 = deserializationContext;
            JsonNodeFactory jsonNodeFactory2 = jsonNodeFactory;
            if (dVarH != null) {
                l0(deserializationContext2, jsonNodeFactory2, strC, objectNode, dVarH, dVar);
            }
            strC = jsonParser.o1();
            deserializationContext = deserializationContext2;
            jsonNodeFactory = jsonNodeFactory2;
        }
        return objectNode;
    }

    public final void q0(JsonParser jsonParser, DeserializationContext deserializationContext, ArrayNode arrayNode) {
        JsonNodeFactory jsonNodeFactory = deserializationContext.f3663c.f3658n;
        while (true) {
            switch (jsonParser.q1().f3597d) {
                case 1:
                    arrayNode.h(o0(jsonParser, deserializationContext, jsonNodeFactory));
                    break;
                case 2:
                case 5:
                case 8:
                default:
                    arrayNode.h(m0(jsonParser, deserializationContext, jsonNodeFactory));
                    break;
                case 3:
                    arrayNode.h(n0(jsonParser, deserializationContext, jsonNodeFactory));
                    break;
                case 4:
                    return;
                case 6:
                    String strV0 = jsonParser.V0();
                    jsonNodeFactory.getClass();
                    arrayNode.h(JsonNodeFactory.a(strV0));
                    break;
                case 7:
                    arrayNode.h(k0(jsonParser, deserializationContext, jsonNodeFactory));
                    break;
                case 9:
                    jsonNodeFactory.getClass();
                    arrayNode.h(BooleanNode.f4259b);
                    break;
                case 10:
                    jsonNodeFactory.getClass();
                    arrayNode.h(BooleanNode.f4260c);
                    break;
                case 11:
                    jsonNodeFactory.getClass();
                    arrayNode.h(NullNode.f4282a);
                    break;
                case 12:
                    arrayNode.h(j0(jsonParser, jsonNodeFactory));
                    break;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final b3.d r0(com.fasterxml.jackson.core.JsonParser r7, com.fasterxml.jackson.databind.DeserializationContext r8, com.fasterxml.jackson.databind.node.ObjectNode r9) throws com.fasterxml.jackson.databind.exc.MismatchedInputException {
        /*
            r6 = this;
            boolean r0 = r7.m1()
            if (r0 == 0) goto Lb
            java.lang.String r0 = r7.o1()
            goto L1e
        Lb:
            com.fasterxml.jackson.core.JsonToken r0 = com.fasterxml.jackson.core.JsonToken.FIELD_NAME
            boolean r0 = r7.i1(r0)
            if (r0 != 0) goto L1a
            java.lang.Object r6 = r6.d(r7, r8)
            b3.d r6 = (b3.d) r6
            return r6
        L1a:
            java.lang.String r0 = r7.C()
        L1e:
            if (r0 == 0) goto Lbe
            com.fasterxml.jackson.core.JsonToken r1 = r7.q1()
            b3.d r2 = r9.f(r0)
            com.fasterxml.jackson.databind.node.JsonNodeFactory r3 = r9.f4262a
            java.util.LinkedHashMap r4 = r9.f4283b
            if (r2 == 0) goto L5f
            boolean r5 = r2 instanceof com.fasterxml.jackson.databind.node.ObjectNode
            if (r5 == 0) goto L4b
            com.fasterxml.jackson.core.JsonToken r5 = com.fasterxml.jackson.core.JsonToken.START_OBJECT
            if (r1 != r5) goto L5f
            r1 = r2
            com.fasterxml.jackson.databind.node.ObjectNode r1 = (com.fasterxml.jackson.databind.node.ObjectNode) r1
            b3.d r1 = r6.r0(r7, r8, r1)
            if (r1 == r2) goto Lb8
            if (r1 != 0) goto L46
            r3.getClass()
            com.fasterxml.jackson.databind.node.NullNode r1 = com.fasterxml.jackson.databind.node.NullNode.f4282a
        L46:
            r4.put(r0, r1)
            goto Lb8
        L4b:
            boolean r5 = r2 instanceof com.fasterxml.jackson.databind.node.ArrayNode
            if (r5 == 0) goto L5f
            com.fasterxml.jackson.core.JsonToken r5 = com.fasterxml.jackson.core.JsonToken.START_ARRAY
            if (r1 != r5) goto L5f
            r1 = r2
            com.fasterxml.jackson.databind.node.ArrayNode r1 = (com.fasterxml.jackson.databind.node.ArrayNode) r1
            r6.q0(r7, r8, r1)
            if (r1 == r2) goto Lb8
            r4.put(r0, r1)
            goto Lb8
        L5f:
            if (r1 != 0) goto L63
            com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.NOT_AVAILABLE
        L63:
            com.fasterxml.jackson.databind.DeserializationConfig r2 = r8.f3663c
            com.fasterxml.jackson.databind.node.JsonNodeFactory r2 = r2.f3658n
            int r1 = r1.f3597d
            r5 = 1
            if (r1 == r5) goto Laa
            r5 = 3
            if (r1 == r5) goto La5
            r5 = 6
            if (r1 == r5) goto L99
            r5 = 7
            if (r1 == r5) goto L94
            switch(r1) {
                case 9: goto L8e;
                case 10: goto L88;
                case 11: goto L82;
                case 12: goto L7d;
                default: goto L78;
            }
        L78:
            b3.d r1 = r6.m0(r7, r8, r2)
            goto Lae
        L7d:
            b3.d r1 = j0(r7, r2)
            goto Lae
        L82:
            r2.getClass()
            com.fasterxml.jackson.databind.node.NullNode r1 = com.fasterxml.jackson.databind.node.NullNode.f4282a
            goto Lae
        L88:
            r2.getClass()
            com.fasterxml.jackson.databind.node.BooleanNode r1 = com.fasterxml.jackson.databind.node.BooleanNode.f4260c
            goto Lae
        L8e:
            r2.getClass()
            com.fasterxml.jackson.databind.node.BooleanNode r1 = com.fasterxml.jackson.databind.node.BooleanNode.f4259b
            goto Lae
        L94:
            com.fasterxml.jackson.databind.node.ValueNode r1 = k0(r7, r8, r2)
            goto Lae
        L99:
            java.lang.String r1 = r7.V0()
            r2.getClass()
            com.fasterxml.jackson.databind.node.TextNode r1 = com.fasterxml.jackson.databind.node.JsonNodeFactory.a(r1)
            goto Lae
        La5:
            com.fasterxml.jackson.databind.node.ArrayNode r1 = r6.n0(r7, r8, r2)
            goto Lae
        Laa:
            com.fasterxml.jackson.databind.node.ObjectNode r1 = r6.o0(r7, r8, r2)
        Lae:
            if (r1 != 0) goto Lb5
            r3.getClass()
            com.fasterxml.jackson.databind.node.NullNode r1 = com.fasterxml.jackson.databind.node.NullNode.f4282a
        Lb5:
            r4.put(r0, r1)
        Lb8:
            java.lang.String r0 = r7.o1()
            goto L1e
        Lbe:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.BaseNodeDeserializer.r0(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext, com.fasterxml.jackson.databind.node.ObjectNode):b3.d");
    }
}
