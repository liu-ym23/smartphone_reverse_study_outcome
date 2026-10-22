package com.fasterxml.jackson.databind.jsontype.impl;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.a;
import i3.e;
import java.util.BitSet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import k3.b;
import k3.c;
import q3.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class AsDeductionTypeDeserializer extends AsPropertyTypeDeserializer {

    /* renamed from: p, reason: collision with root package name */
    public static final BitSet f4242p = new BitSet(0);

    /* renamed from: n, reason: collision with root package name */
    public final HashMap f4243n;

    /* renamed from: o, reason: collision with root package name */
    public final HashMap f4244o;

    public AsDeductionTypeDeserializer(JavaType javaType, c cVar, JavaType javaType2, DeserializationConfig deserializationConfig, Collection<NamedType> collection) {
        super(javaType, cVar, null, false, javaType2, null);
        HashMap map = new HashMap();
        this.f4243n = map;
        boolean zK = deserializationConfig.k(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        HashMap map2 = new HashMap();
        int i10 = 0;
        for (NamedType namedType : collection) {
            TypeFactory typeFactory = deserializationConfig.f3828b.f3789a;
            Class<?> cls = namedType.f4235a;
            List<e> listD = deserializationConfig.o(typeFactory.j(cls)).d();
            BitSet bitSet = new BitSet(listD.size() + i10);
            Iterator<e> it = listD.iterator();
            while (it.hasNext()) {
                String name = it.next().getName();
                name = zK ? name.toLowerCase() : name;
                Integer numValueOf = (Integer) map.get(name);
                if (numValueOf == null) {
                    numValueOf = Integer.valueOf(i10);
                    map.put(name, Integer.valueOf(i10));
                    i10++;
                }
                bitSet.set(numValueOf.intValue());
            }
            String str = (String) map2.put(bitSet, cls.getName());
            if (str != null) {
                throw new IllegalStateException(h0.e.c("Subtypes ", str, " and ", cls.getName(), " have the same signature and cannot be uniquely deduced."));
            }
        }
        this.f4244o = map2;
    }

    @Override // com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer, com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer, k3.b
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws JsonGenerationException {
        String str;
        JsonToken jsonTokenK = jsonParser.K();
        if (jsonTokenK == JsonToken.START_OBJECT) {
            jsonTokenK = jsonParser.q1();
        } else if (jsonTokenK != JsonToken.FIELD_NAME) {
            return q(jsonParser, deserializationContext, null, "Unexpected input");
        }
        JsonToken jsonToken = JsonToken.END_OBJECT;
        HashMap map = this.f4244o;
        if (jsonTokenK == jsonToken && (str = (String) map.get(f4242p)) != null) {
            return p(jsonParser, deserializationContext, null, str);
        }
        LinkedList linkedList = new LinkedList(map.keySet());
        p pVar = new p(jsonParser, deserializationContext);
        boolean zK = deserializationContext.f3663c.k(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        while (jsonTokenK == JsonToken.FIELD_NAME) {
            String strC = jsonParser.C();
            if (zK) {
                strC = strC.toLowerCase();
            }
            pVar.u1(jsonParser);
            Integer num = (Integer) this.f4243n.get(strC);
            if (num != null) {
                int iIntValue = num.intValue();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    if (!((BitSet) it.next()).get(iIntValue)) {
                        it.remove();
                    }
                }
                if (linkedList.size() == 1) {
                    return p(jsonParser, deserializationContext, pVar, (String) map.get(linkedList.get(0)));
                }
            }
            jsonTokenK = jsonParser.q1();
        }
        return q(jsonParser, deserializationContext, pVar, String.format("Cannot deduce unique subtype of %s (%d candidates match)", a.r(this.f4249b), Integer.valueOf(linkedList.size())));
    }

    @Override // com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer, com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer, k3.b
    public final b f(BeanProperty beanProperty) {
        return beanProperty == this.f4250c ? this : new AsDeductionTypeDeserializer(this, beanProperty);
    }

    public AsDeductionTypeDeserializer(AsDeductionTypeDeserializer asDeductionTypeDeserializer, BeanProperty beanProperty) {
        super(asDeductionTypeDeserializer, beanProperty);
        this.f4243n = asDeductionTypeDeserializer.f4243n;
        this.f4244o = asDeductionTypeDeserializer.f4244o;
    }
}
