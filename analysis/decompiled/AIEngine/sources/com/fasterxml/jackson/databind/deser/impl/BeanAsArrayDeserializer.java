package com.fasterxml.jackson.databind.deser.impl;

import b3.c;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.BeanDeserializerBase;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.util.NameTransformer;
import f3.g;
import java.io.IOException;
import java.util.Set;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class BeanAsArrayDeserializer extends BeanDeserializerBase {
    public final BeanDeserializerBase B;
    public final SettableBeanProperty[] C;

    public BeanAsArrayDeserializer(BeanDeserializerBase beanDeserializerBase, SettableBeanProperty[] settableBeanPropertyArr) {
        super(beanDeserializerBase);
        this.B = beanDeserializerBase;
        this.C = settableBeanPropertyArr;
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public final BeanDeserializerBase A0(BeanPropertyMap beanPropertyMap) {
        return new BeanAsArrayDeserializer(this.B.A0(beanPropertyMap), this.C);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public final BeanDeserializerBase B0(Set<String> set, Set<String> set2) {
        return new BeanAsArrayDeserializer(this.B.B0(set, set2), this.C);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public final BeanDeserializerBase C0() {
        return new BeanAsArrayDeserializer(this.B.C0(), this.C);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public final BeanDeserializerBase D0(ObjectIdReader objectIdReader) {
        return new BeanAsArrayDeserializer(this.B.D0(objectIdReader), this.C);
    }

    public final void G0(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        deserializationContext.B(g0(deserializationContext), jsonParser.K(), jsonParser, "Cannot deserialize a POJO (of type %s) from non-Array representation (token: %s): type/property designed to be serialized as JSON Array", com.fasterxml.jackson.databind.util.a.r(this.f3854d), jsonParser.K());
        throw null;
    }

    @Override // b3.c
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        if (!jsonParser.l1()) {
            G0(jsonParser, deserializationContext);
            throw null;
        }
        boolean z = this.f3860n;
        boolean z3 = this.f3865t;
        int i10 = 0;
        SettableBeanProperty[] settableBeanPropertyArr = this.C;
        ValueInstantiator valueInstantiator = this.h;
        if (z) {
            Object objV = valueInstantiator.v(deserializationContext);
            jsonParser.u1(objV);
            int length = settableBeanPropertyArr.length;
            while (true) {
                JsonToken jsonTokenQ1 = jsonParser.q1();
                JsonToken jsonToken = JsonToken.END_ARRAY;
                if (jsonTokenQ1 == jsonToken) {
                    break;
                }
                if (i10 != length) {
                    SettableBeanProperty settableBeanProperty = settableBeanPropertyArr[i10];
                    if (settableBeanProperty != null) {
                        try {
                            settableBeanProperty.i(jsonParser, deserializationContext, objV);
                        } catch (Exception e10) {
                            BeanDeserializerBase.E0(deserializationContext, e10, objV, settableBeanProperty.f3891c.f3755a);
                            throw null;
                        }
                    } else {
                        jsonParser.v1();
                    }
                    i10++;
                } else {
                    if (!z3 && deserializationContext.J(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)) {
                        deserializationContext.T(this, jsonToken, "Unexpected JSON values; expected at most %d properties (in JSON Array)", Integer.valueOf(length));
                        throw null;
                    }
                    do {
                        jsonParser.v1();
                    } while (jsonParser.q1() != JsonToken.END_ARRAY);
                }
            }
            return objV;
        }
        if (this.f3859m) {
            return t0(jsonParser, deserializationContext);
        }
        Object objV2 = valueInstantiator.v(deserializationContext);
        jsonParser.u1(objV2);
        if (this.f3862p != null) {
            z0(deserializationContext);
        }
        if (this.f3866u) {
            deserializationContext.getClass();
        }
        int length2 = settableBeanPropertyArr.length;
        while (true) {
            JsonToken jsonTokenQ12 = jsonParser.q1();
            JsonToken jsonToken2 = JsonToken.END_ARRAY;
            if (jsonTokenQ12 == jsonToken2) {
                break;
            }
            if (i10 != length2) {
                SettableBeanProperty settableBeanProperty2 = settableBeanPropertyArr[i10];
                i10++;
                if (settableBeanProperty2 != null) {
                    try {
                        settableBeanProperty2.i(jsonParser, deserializationContext, objV2);
                    } catch (Exception e11) {
                        BeanDeserializerBase.E0(deserializationContext, e11, objV2, settableBeanProperty2.f3891c.f3755a);
                        throw null;
                    }
                } else {
                    jsonParser.v1();
                }
            } else {
                if (!z3) {
                    deserializationContext.T(this, jsonToken2, "Unexpected JSON values; expected at most %d properties (in JSON Array)", Integer.valueOf(length2));
                    throw null;
                }
                do {
                    jsonParser.v1();
                } while (jsonParser.q1() != JsonToken.END_ARRAY);
            }
        }
        return objV2;
    }

    @Override // b3.c
    public final Object e(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IOException {
        jsonParser.u1(obj);
        if (!jsonParser.l1()) {
            G0(jsonParser, deserializationContext);
            throw null;
        }
        if (this.f3862p != null) {
            z0(deserializationContext);
        }
        SettableBeanProperty[] settableBeanPropertyArr = this.C;
        int length = settableBeanPropertyArr.length;
        int i10 = 0;
        while (true) {
            JsonToken jsonTokenQ1 = jsonParser.q1();
            JsonToken jsonToken = JsonToken.END_ARRAY;
            if (jsonTokenQ1 == jsonToken) {
                break;
            }
            if (i10 != length) {
                SettableBeanProperty settableBeanProperty = settableBeanPropertyArr[i10];
                if (settableBeanProperty != null) {
                    try {
                        settableBeanProperty.i(jsonParser, deserializationContext, obj);
                    } catch (Exception e10) {
                        BeanDeserializerBase.E0(deserializationContext, e10, obj, settableBeanProperty.f3891c.f3755a);
                        throw null;
                    }
                } else {
                    jsonParser.v1();
                }
                i10++;
            } else {
                if (!this.f3865t && deserializationContext.J(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)) {
                    deserializationContext.T(this, jsonToken, "Unexpected JSON values; expected at most %d properties (in JSON Array)", Integer.valueOf(length));
                    throw null;
                }
                do {
                    jsonParser.v1();
                } while (jsonParser.q1() != JsonToken.END_ARRAY);
            }
        }
        return obj;
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public final Object k0(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JavaType javaType = this.f3854d;
        PropertyBasedCreator propertyBasedCreator = this.f3858l;
        g gVarD = propertyBasedCreator.d(jsonParser, deserializationContext, this.z);
        SettableBeanProperty[] settableBeanPropertyArr = this.C;
        int length = settableBeanPropertyArr.length;
        if (this.f3866u) {
            deserializationContext.getClass();
        }
        int i10 = 0;
        Object objA = null;
        while (jsonParser.q1() != JsonToken.END_ARRAY) {
            SettableBeanProperty settableBeanProperty = i10 < length ? settableBeanPropertyArr[i10] : null;
            if (settableBeanProperty == null) {
                jsonParser.v1();
            } else {
                PropertyName propertyName = settableBeanProperty.f3891c;
                if (objA != null) {
                    try {
                        settableBeanProperty.i(jsonParser, deserializationContext, objA);
                    } catch (Exception e10) {
                        BeanDeserializerBase.E0(deserializationContext, e10, objA, propertyName.f3755a);
                        throw null;
                    }
                } else {
                    String str = propertyName.f3755a;
                    SettableBeanProperty settableBeanPropertyC = propertyBasedCreator.c(str);
                    if (!gVarD.d(str) || settableBeanPropertyC != null) {
                        if (settableBeanPropertyC == null) {
                            gVarD.c(settableBeanProperty, settableBeanProperty.h(jsonParser, deserializationContext));
                        } else if (gVarD.b(settableBeanPropertyC, settableBeanPropertyC.h(jsonParser, deserializationContext))) {
                            try {
                                objA = propertyBasedCreator.a(deserializationContext, gVarD);
                                jsonParser.u1(objA);
                                if (objA.getClass() != javaType.f3690a) {
                                    deserializationContext.j("Cannot support implicit polymorphic deserialization for POJOs-as-Arrays style: nominal type " + com.fasterxml.jackson.databind.util.a.r(javaType) + ", actual type " + com.fasterxml.jackson.databind.util.a.m(objA));
                                    throw null;
                                }
                            } catch (Exception e11) {
                                BeanDeserializerBase.E0(deserializationContext, e11, javaType.f3690a, str);
                                throw null;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            i10++;
        }
        if (objA != null) {
            return objA;
        }
        try {
            return propertyBasedCreator.a(deserializationContext, gVarD);
        } catch (Exception e12) {
            this.F0(e12, deserializationContext);
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase, b3.c
    public final c<Object> q(NameTransformer nameTransformer) {
        return this.B.q(nameTransformer);
    }

    @Override // com.fasterxml.jackson.databind.deser.BeanDeserializerBase
    public final BeanDeserializerBase o0() {
        return this;
    }
}
