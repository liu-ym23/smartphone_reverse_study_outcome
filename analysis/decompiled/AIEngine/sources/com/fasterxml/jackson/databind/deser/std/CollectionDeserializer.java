package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.cfg.CoercionInputShape;
import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.ObjectIdReader;
import com.fasterxml.jackson.databind.deser.impl.a;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.LogicalType;
import e3.c;
import e3.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c3.a
/* loaded from: classes.dex */
public class CollectionDeserializer extends ContainerDeserializerBase<Collection<Object>> implements c {

    /* renamed from: k, reason: collision with root package name */
    public final b3.c<Object> f3955k;

    /* renamed from: l, reason: collision with root package name */
    public final k3.b f3956l;

    /* renamed from: m, reason: collision with root package name */
    public final ValueInstantiator f3957m;

    /* renamed from: n, reason: collision with root package name */
    public final b3.c<Object> f3958n;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends a.AbstractC0031a {

        /* renamed from: c, reason: collision with root package name */
        public final b f3959c;

        /* renamed from: d, reason: collision with root package name */
        public final ArrayList f3960d;

        public a(b bVar, UnresolvedForwardReference unresolvedForwardReference, Class<?> cls) {
            super(unresolvedForwardReference, cls);
            this.f3960d = new ArrayList();
            this.f3959c = bVar;
        }

        @Override // com.fasterxml.jackson.databind.deser.impl.a.AbstractC0031a
        public final void a(Object obj, Object obj2) {
            b bVar = this.f3959c;
            Iterator it = bVar.f3963c.iterator();
            Collection<Object> collection = bVar.f3962b;
            while (it.hasNext()) {
                a aVar = (a) it.next();
                boolean zEquals = obj.equals(aVar.f3952a.f3900e.f3949b.f3498c);
                ArrayList arrayList = aVar.f3960d;
                if (zEquals) {
                    it.remove();
                    collection.add(obj2);
                    collection.addAll(arrayList);
                    return;
                }
                collection = arrayList;
            }
            throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + obj + "] that wasn't previously seen as unresolved.");
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Class<?> f3961a;

        /* renamed from: b, reason: collision with root package name */
        public final Collection<Object> f3962b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f3963c = new ArrayList();

        public b(Class<?> cls, Collection<Object> collection) {
            this.f3961a = cls;
            this.f3962b = collection;
        }

        public final void a(Object obj) {
            ArrayList arrayList = this.f3963c;
            if (arrayList.isEmpty()) {
                this.f3962b.add(obj);
            } else {
                ((a) arrayList.get(arrayList.size() - 1)).f3960d.add(obj);
            }
        }
    }

    public CollectionDeserializer(CollectionType collectionType, b3.c cVar, k3.b bVar, ValueInstantiator valueInstantiator) {
        this(collectionType, cVar, bVar, valueInstantiator, null, null, null);
    }

    @Override // e3.c
    public final b3.c c(DeserializationContext deserializationContext, BeanProperty beanProperty) throws InvalidDefinitionException {
        b3.c<Object> cVar;
        b3.c<Object> cVarO;
        JavaType javaType = this.f3964d;
        ValueInstantiator valueInstantiator = this.f3957m;
        if (valueInstantiator == null) {
            cVar = null;
        } else {
            if (valueInstantiator.k()) {
                JavaType javaTypeB = valueInstantiator.B();
                if (javaTypeB == null) {
                    deserializationContext.j(String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", javaType, valueInstantiator.getClass().getName()));
                    throw null;
                }
                cVarO = deserializationContext.o(javaTypeB, beanProperty);
            } else {
                if (valueInstantiator.i()) {
                    JavaType javaTypeY = valueInstantiator.y();
                    if (javaTypeY == null) {
                        deserializationContext.j(String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", javaType, valueInstantiator.getClass().getName()));
                        throw null;
                    }
                    cVarO = deserializationContext.o(javaTypeY, beanProperty);
                }
                cVar = null;
            }
            cVar = cVarO;
        }
        JsonFormat.Value valueD0 = StdDeserializer.d0(deserializationContext, beanProperty, Collection.class);
        Boolean boolB = valueD0 != null ? valueD0.b(JsonFormat.Feature.f3434a) : null;
        b3.c<?> cVar2 = this.f3955k;
        b3.c<?> cVarC0 = StdDeserializer.c0(deserializationContext, beanProperty, cVar2);
        JavaType javaTypeK = javaType.k();
        b3.c<?> cVarO2 = cVarC0 == null ? deserializationContext.o(javaTypeK, beanProperty) : deserializationContext.z(cVarC0, beanProperty, javaTypeK);
        k3.b bVar = this.f3956l;
        k3.b bVarF = bVar != null ? bVar.f(beanProperty) : bVar;
        i iVarB0 = StdDeserializer.b0(deserializationContext, beanProperty, cVarO2);
        return (Objects.equals(boolB, this.f3966j) && iVarB0 == this.f3965e && cVar == this.f3958n && cVarO2 == cVar2 && bVarF == bVar) ? this : o0(cVar, cVarO2, bVarF, iVarB0, boolB);
    }

    @Override // b3.c
    public final Object d(JsonParser jsonParser, DeserializationContext deserializationContext) throws InvalidFormatException {
        b3.c<Object> cVar = this.f3958n;
        if (cVar != null) {
            return (Collection) this.f3957m.w(deserializationContext, cVar.d(jsonParser, deserializationContext));
        }
        if (jsonParser.l1()) {
            return l0(jsonParser, deserializationContext, m0(deserializationContext));
        }
        if (!jsonParser.i1(JsonToken.VALUE_STRING)) {
            return n0(jsonParser, deserializationContext, m0(deserializationContext));
        }
        String strV0 = jsonParser.V0();
        boolean zIsEmpty = strV0.isEmpty();
        LogicalType logicalType = LogicalType.f4429b;
        Class<?> cls = this.f4054a;
        if (zIsEmpty) {
            CoercionAction coercionActionM = deserializationContext.m(logicalType, cls, CoercionInputShape.f3809e);
            r(deserializationContext, coercionActionM, strV0, "empty String (\"\")");
            if (coercionActionM != null) {
                return (Collection) C(deserializationContext, coercionActionM);
            }
        } else if (StdDeserializer.F(strV0)) {
            return (Collection) C(deserializationContext, deserializationContext.n(logicalType, cls));
        }
        return n0(jsonParser, deserializationContext, m0(deserializationContext));
    }

    @Override // b3.c
    public final Object e(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        Collection<Object> collection = (Collection) obj;
        return jsonParser.l1() ? l0(jsonParser, deserializationContext, collection) : n0(jsonParser, deserializationContext, collection);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public final ValueInstantiator e0() {
        return this.f3957m;
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer, b3.c
    public Object f(JsonParser jsonParser, DeserializationContext deserializationContext, k3.b bVar) {
        return bVar.c(jsonParser, deserializationContext);
    }

    @Override // com.fasterxml.jackson.databind.deser.std.ContainerDeserializerBase
    public final b3.c<Object> j0() {
        return this.f3955k;
    }

    public Collection<Object> l0(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<Object> collection) throws JsonMappingException {
        Object objD;
        Object objD2;
        jsonParser.u1(collection);
        b3.c<Object> cVar = this.f3955k;
        ObjectIdReader objectIdReaderL = cVar.l();
        i iVar = this.f3965e;
        boolean z = this.h;
        k3.b bVar = this.f3956l;
        if (objectIdReaderL == null) {
            while (true) {
                JsonToken jsonTokenQ1 = jsonParser.q1();
                if (jsonTokenQ1 == JsonToken.END_ARRAY) {
                    break;
                }
                try {
                    if (jsonTokenQ1 != JsonToken.VALUE_NULL) {
                        objD = bVar == null ? cVar.d(jsonParser, deserializationContext) : cVar.f(jsonParser, deserializationContext, bVar);
                    } else if (!z) {
                        objD = iVar.a(deserializationContext);
                    }
                    collection.add(objD);
                } catch (Exception e10) {
                    if (deserializationContext != null && !deserializationContext.J(DeserializationFeature.WRAP_EXCEPTIONS)) {
                        com.fasterxml.jackson.databind.util.a.D(e10);
                    }
                    throw JsonMappingException.h(e10, collection, collection.size());
                }
            }
        } else {
            if (!jsonParser.l1()) {
                return n0(jsonParser, deserializationContext, collection);
            }
            jsonParser.u1(collection);
            b bVar2 = new b(this.f3964d.k().f3690a, collection);
            while (true) {
                JsonToken jsonTokenQ12 = jsonParser.q1();
                if (jsonTokenQ12 == JsonToken.END_ARRAY) {
                    break;
                }
                try {
                } catch (UnresolvedForwardReference e11) {
                    a aVar = new a(bVar2, e11, bVar2.f3961a);
                    bVar2.f3963c.add(aVar);
                    e11.f3900e.a(aVar);
                } catch (Exception e12) {
                    if (deserializationContext != null && !deserializationContext.J(DeserializationFeature.WRAP_EXCEPTIONS)) {
                        com.fasterxml.jackson.databind.util.a.D(e12);
                    }
                    throw JsonMappingException.h(e12, collection, collection.size());
                }
                if (jsonTokenQ12 != JsonToken.VALUE_NULL) {
                    objD2 = bVar == null ? cVar.d(jsonParser, deserializationContext) : cVar.f(jsonParser, deserializationContext, bVar);
                } else if (!z) {
                    objD2 = iVar.a(deserializationContext);
                }
                bVar2.a(objD2);
            }
        }
        return collection;
    }

    public Collection<Object> m0(DeserializationContext deserializationContext) {
        return (Collection) this.f3957m.v(deserializationContext);
    }

    @Override // b3.c
    public final boolean n() {
        return this.f3955k == null && this.f3956l == null && this.f3958n == null;
    }

    public final Collection<Object> n0(JsonParser jsonParser, DeserializationContext deserializationContext, Collection<Object> collection) throws JsonMappingException {
        Object objD;
        Boolean bool = Boolean.TRUE;
        Boolean bool2 = this.f3966j;
        if (bool2 != bool && (bool2 != null || !deserializationContext.J(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))) {
            deserializationContext.A(jsonParser, this.f3964d);
            throw null;
        }
        try {
            if (!jsonParser.i1(JsonToken.VALUE_NULL)) {
                b3.c<Object> cVar = this.f3955k;
                k3.b bVar = this.f3956l;
                objD = bVar == null ? cVar.d(jsonParser, deserializationContext) : cVar.f(jsonParser, deserializationContext, bVar);
            } else {
                if (this.h) {
                    return collection;
                }
                objD = this.f3965e.a(deserializationContext);
            }
            collection.add(objD);
            return collection;
        } catch (Exception e10) {
            if (!deserializationContext.J(DeserializationFeature.WRAP_EXCEPTIONS)) {
                com.fasterxml.jackson.databind.util.a.D(e10);
            }
            throw JsonMappingException.h(e10, Object.class, collection.size());
        }
    }

    @Override // b3.c
    public final LogicalType o() {
        return LogicalType.f4429b;
    }

    public CollectionDeserializer o0(b3.c<?> cVar, b3.c<?> cVar2, k3.b bVar, i iVar, Boolean bool) {
        return new CollectionDeserializer(this.f3964d, cVar2, bVar, this.f3957m, cVar, iVar, bool);
    }

    public CollectionDeserializer(JavaType javaType, b3.c<Object> cVar, k3.b bVar, ValueInstantiator valueInstantiator, b3.c<Object> cVar2, i iVar, Boolean bool) {
        super(javaType, iVar, bool);
        this.f3955k = cVar;
        this.f3956l = bVar;
        this.f3957m = valueInstantiator;
        this.f3958n = cVar2;
    }
}
