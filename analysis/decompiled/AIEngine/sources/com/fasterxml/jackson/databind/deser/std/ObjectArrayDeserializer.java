package com.fasterxml.jackson.databind.deser.std;

import c3.a;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.type.ArrayType;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.AccessPattern;
import e3.c;
import e3.i;
import java.lang.reflect.Array;
import java.util.Objects;
import k3.b;
import q3.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public class ObjectArrayDeserializer extends ContainerDeserializerBase<Object[]> implements c {

    /* renamed from: k, reason: collision with root package name */
    public final boolean f4039k;

    /* renamed from: l, reason: collision with root package name */
    public final Class<?> f4040l;

    /* renamed from: m, reason: collision with root package name */
    public final b3.c<Object> f4041m;

    /* renamed from: n, reason: collision with root package name */
    public final b f4042n;

    /* renamed from: o, reason: collision with root package name */
    public final Object[] f4043o;

    public ObjectArrayDeserializer(ArrayType arrayType, b3.c cVar, b bVar) {
        super(arrayType, (i) null, (Boolean) null);
        Class<?> cls = arrayType.f4422m.f3690a;
        this.f4040l = cls;
        this.f4039k = cls == Object.class;
        this.f4041m = cVar;
        this.f4042n = bVar;
        this.f4043o = (Object[]) arrayType.f4423n;
    }

    @Override // e3.c
    public final b3.c<?> c(DeserializationContext deserializationContext, BeanProperty beanProperty) throws InvalidDefinitionException {
        JavaType javaType = this.f3964d;
        JsonFormat.Value valueD0 = StdDeserializer.d0(deserializationContext, beanProperty, javaType.f3690a);
        Boolean boolB = valueD0 != null ? valueD0.b(JsonFormat.Feature.f3434a) : null;
        b3.c<?> cVar = this.f4041m;
        b3.c<?> cVarC0 = StdDeserializer.c0(deserializationContext, beanProperty, cVar);
        JavaType javaTypeK = javaType.k();
        b3.c<?> cVarO = cVarC0 == null ? deserializationContext.o(javaTypeK, beanProperty) : deserializationContext.z(cVarC0, beanProperty, javaTypeK);
        b bVar = this.f4042n;
        b bVarF = bVar != null ? bVar.f(beanProperty) : bVar;
        i iVarB0 = StdDeserializer.b0(deserializationContext, beanProperty, cVarO);
        return (Objects.equals(boolB, this.f3966j) && iVarB0 == this.f3965e && cVarO == cVar && bVarF == bVar) ? this : new ObjectArrayDeserializer(this, cVarO, bVarF, iVarB0, boolB);
    }

    @Override // b3.c
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws JsonMappingException {
        Object objD;
        int i10;
        if (!jsonParser.l1()) {
            return l0(jsonParser, deserializationContext);
        }
        l lVarL = deserializationContext.L();
        Object[] objArrG = lVarL.g();
        int i11 = 0;
        while (true) {
            try {
                JsonToken jsonTokenQ1 = jsonParser.q1();
                if (jsonTokenQ1 == JsonToken.END_ARRAY) {
                    break;
                }
                try {
                    if (jsonTokenQ1 != JsonToken.VALUE_NULL) {
                        b3.c<Object> cVar = this.f4041m;
                        b bVar = this.f4042n;
                        objD = bVar == null ? cVar.d(jsonParser, deserializationContext) : cVar.f(jsonParser, deserializationContext, bVar);
                    } else if (!this.h) {
                        objD = this.f3965e.a(deserializationContext);
                    }
                    objArrG[i11] = objD;
                    i11 = i10;
                } catch (Exception e10) {
                    e = e10;
                    i11 = i10;
                    throw JsonMappingException.h(e, objArrG, lVarL.f11564c + i11);
                }
                if (i11 >= objArrG.length) {
                    objArrG = lVarL.c(objArrG);
                    i11 = 0;
                }
                i10 = i11 + 1;
            } catch (Exception e11) {
                e = e11;
            }
        }
        Object[] objArrE = this.f4039k ? lVarL.e(objArrG, i11) : lVarL.f(objArrG, i11, this.f4040l);
        deserializationContext.V(lVarL);
        return objArrE;
    }

    @Override // b3.c
    public final Object e(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws JsonMappingException {
        Object objD;
        int i10;
        Object[] objArr = (Object[]) obj;
        if (!jsonParser.l1()) {
            Object[] objArrL0 = l0(jsonParser, deserializationContext);
            if (objArrL0 == null) {
                return objArr;
            }
            int length = objArr.length;
            Object[] objArr2 = new Object[objArrL0.length + length];
            System.arraycopy(objArr, 0, objArr2, 0, length);
            System.arraycopy(objArrL0, 0, objArr2, length, objArrL0.length);
            return objArr2;
        }
        l lVarL = deserializationContext.L();
        int length2 = objArr.length;
        Object[] objArrH = lVarL.h(objArr, length2);
        while (true) {
            try {
                JsonToken jsonTokenQ1 = jsonParser.q1();
                if (jsonTokenQ1 == JsonToken.END_ARRAY) {
                    break;
                }
                try {
                    if (jsonTokenQ1 != JsonToken.VALUE_NULL) {
                        b3.c<Object> cVar = this.f4041m;
                        b bVar = this.f4042n;
                        objD = bVar == null ? cVar.d(jsonParser, deserializationContext) : cVar.f(jsonParser, deserializationContext, bVar);
                    } else if (!this.h) {
                        objD = this.f3965e.a(deserializationContext);
                    }
                    objArrH[length2] = objD;
                    length2 = i10;
                } catch (Exception e10) {
                    e = e10;
                    length2 = i10;
                    throw JsonMappingException.h(e, objArrH, lVarL.f11564c + length2);
                }
                if (length2 >= objArrH.length) {
                    objArrH = lVarL.c(objArrH);
                    length2 = 0;
                }
                i10 = length2 + 1;
            } catch (Exception e11) {
                e = e11;
            }
        }
        Object[] objArrE = this.f4039k ? lVarL.e(objArrH, length2) : lVarL.f(objArrH, length2, this.f4040l);
        deserializationContext.V(lVarL);
        return objArrE;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
    public final Object f(JsonParser jsonParser, DeserializationContext deserializationContext, b bVar) {
        return (Object[]) bVar.c(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase, b3.c
    public final AccessPattern i() {
        return AccessPattern.f4492b;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase, b3.c
    public final Object j(DeserializationContext deserializationContext) {
        return this.f4043o;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public final b3.c<Object> j0() {
        return this.f4041m;
    }

    public final Object[] l0(JsonParser jsonParser, DeserializationContext deserializationContext) throws MismatchedInputException {
        Object objD;
        Boolean bool = Boolean.TRUE;
        Class<?> cls = this.f4040l;
        Boolean bool2 = this.f3966j;
        if (bool2 == bool || (bool2 == null && deserializationContext.J(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            if (!jsonParser.i1(JsonToken.VALUE_NULL)) {
                b3.c<Object> cVar = this.f4041m;
                b bVar = this.f4042n;
                objD = bVar == null ? cVar.d(jsonParser, deserializationContext) : cVar.f(jsonParser, deserializationContext, bVar);
            } else {
                if (this.h) {
                    return this.f4043o;
                }
                objD = this.f3965e.a(deserializationContext);
            }
            Object[] objArr = this.f4039k ? new Object[1] : (Object[]) Array.newInstance(cls, 1);
            objArr[0] = objD;
            return objArr;
        }
        if (!jsonParser.i1(JsonToken.VALUE_STRING)) {
            deserializationContext.A(jsonParser, this.f3964d);
            throw null;
        }
        if (cls != Byte.class) {
            return D(jsonParser, deserializationContext);
        }
        byte[] bArrS = jsonParser.S(deserializationContext.f3663c.f3828b.f3795k);
        Byte[] bArr = new Byte[bArrS.length];
        int length = bArrS.length;
        for (int i10 = 0; i10 < length; i10++) {
            bArr[i10] = Byte.valueOf(bArrS[i10]);
        }
        return bArr;
    }

    @Override // b3.c
    public final boolean n() {
        return this.f4041m == null && this.f4042n == null;
    }

    @Override // b3.c
    public final LogicalType o() {
        return LogicalType.f4428a;
    }

    public ObjectArrayDeserializer(ObjectArrayDeserializer objectArrayDeserializer, b3.c<Object> cVar, b bVar, i iVar, Boolean bool) {
        super(objectArrayDeserializer, iVar, bool);
        this.f4040l = objectArrayDeserializer.f4040l;
        this.f4039k = objectArrayDeserializer.f4039k;
        this.f4043o = objectArrayDeserializer.f4043o;
        this.f4041m = cVar;
        this.f4042n = bVar;
    }
}
