package com.fasterxml.jackson.databind.ser.std;

import b3.h;
import c3.a;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.WritableTypeId;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.TreeMap;
import q3.n;
import q3.p;
import v2.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public class TokenBufferSerializer extends StdSerializer<p> {
    public TokenBufferSerializer() {
        super(p.class);
    }

    public static void o(p pVar, JsonGenerator jsonGenerator) throws JsonGenerationException {
        p.b bVar = pVar.f11586l;
        boolean z = pVar.f11584j;
        boolean z3 = z && bVar.f11604d != null;
        int i10 = -1;
        while (true) {
            i10++;
            if (i10 >= 16) {
                bVar = bVar.f11601a;
                if (bVar == null) {
                    return;
                }
                z3 = z && bVar.f11604d != null;
                i10 = 0;
            }
            JsonToken jsonTokenD = bVar.d(i10);
            Object[] objArr = bVar.f11603c;
            if (jsonTokenD == null) {
                return;
            }
            if (z3) {
                Object objC = bVar.c(i10);
                if (objC != null) {
                    jsonGenerator.S0(objC);
                }
                TreeMap<Integer, Object> treeMap = bVar.f11604d;
                Object obj = treeMap == null ? null : treeMap.get(Integer.valueOf(i10 + i10));
                if (obj != null) {
                    jsonGenerator.i1(obj);
                }
            }
            switch (jsonTokenD.ordinal()) {
                case 1:
                    jsonGenerator.c1();
                    break;
                case 2:
                    jsonGenerator.G0();
                    break;
                case 3:
                    jsonGenerator.Z0();
                    break;
                case 4:
                    jsonGenerator.C0();
                    break;
                case 5:
                    Object obj2 = objArr[i10];
                    if (!(obj2 instanceof e)) {
                        jsonGenerator.H0((String) obj2);
                        break;
                    } else {
                        jsonGenerator.I0((e) obj2);
                        break;
                    }
                case 6:
                    Object obj3 = objArr[i10];
                    if (!(obj3 instanceof n)) {
                        if (!(obj3 instanceof b3.e)) {
                            jsonGenerator.x0(obj3);
                            break;
                        } else {
                            jsonGenerator.writeObject(obj3);
                            break;
                        }
                    } else {
                        Object obj4 = ((n) obj3).f11573a;
                        if (!(obj4 instanceof b3.e)) {
                            if (!(obj4 instanceof e)) {
                                jsonGenerator.X0(String.valueOf(obj4));
                                break;
                            } else {
                                jsonGenerator.Y0((e) obj4);
                                break;
                            }
                        } else {
                            jsonGenerator.writeObject(obj4);
                            break;
                        }
                    }
                case 7:
                    Object obj5 = objArr[i10];
                    if (!(obj5 instanceof e)) {
                        jsonGenerator.f1((String) obj5);
                        break;
                    } else {
                        jsonGenerator.g1((e) obj5);
                        break;
                    }
                case 8:
                    Object obj6 = objArr[i10];
                    if (!(obj6 instanceof Integer)) {
                        if (!(obj6 instanceof BigInteger)) {
                            if (!(obj6 instanceof Long)) {
                                if (!(obj6 instanceof Short)) {
                                    jsonGenerator.M0(((Number) obj6).intValue());
                                    break;
                                } else {
                                    jsonGenerator.R0(((Short) obj6).shortValue());
                                    break;
                                }
                            } else {
                                jsonGenerator.N0(((Long) obj6).longValue());
                                break;
                            }
                        } else {
                            jsonGenerator.Q0((BigInteger) obj6);
                            break;
                        }
                    } else {
                        jsonGenerator.M0(((Integer) obj6).intValue());
                        break;
                    }
                case 9:
                    Object obj7 = objArr[i10];
                    if (obj7 instanceof Double) {
                        jsonGenerator.K0(((Double) obj7).doubleValue());
                        break;
                    } else if (obj7 instanceof BigDecimal) {
                        jsonGenerator.P0((BigDecimal) obj7);
                        break;
                    } else if (obj7 instanceof Float) {
                        jsonGenerator.L0(((Float) obj7).floatValue());
                        break;
                    } else if (obj7 == null) {
                        jsonGenerator.J0();
                        break;
                    } else {
                        if (!(obj7 instanceof String)) {
                            throw new JsonGenerationException(a0.a.k("Unrecognized value type for VALUE_NUMBER_FLOAT: ", obj7.getClass().getName(), ", cannot serialize"), jsonGenerator);
                        }
                        jsonGenerator.O0((String) obj7);
                        break;
                    }
                case 10:
                    jsonGenerator.g0(true);
                    break;
                case 11:
                    jsonGenerator.g0(false);
                    break;
                case 12:
                    jsonGenerator.J0();
                    break;
                default:
                    throw new RuntimeException("Internal error: should never end up through this code path");
            }
        }
    }

    @Override // b3.f
    public final /* bridge */ /* synthetic */ void f(Object obj, JsonGenerator jsonGenerator, h hVar) throws JsonGenerationException {
        o((p) obj, jsonGenerator);
    }

    @Override // b3.f
    public final void g(Object obj, JsonGenerator jsonGenerator, h hVar, k3.e eVar) throws JsonGenerationException {
        p pVar = (p) obj;
        WritableTypeId writableTypeIdE = eVar.e(jsonGenerator, eVar.d(JsonToken.VALUE_EMBEDDED_OBJECT, pVar));
        o(pVar, jsonGenerator);
        eVar.f(jsonGenerator, writableTypeIdE);
    }
}
