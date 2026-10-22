package com.fasterxml.jackson.databind.deser;

import b3.c;
import b3.g;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.deser.impl.a;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.util.RootNameLookup;
import e3.j;
import e3.k;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import w2.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class DefaultDeserializationContext extends DeserializationContext implements Serializable {

    /* renamed from: n, reason: collision with root package name */
    public transient LinkedHashMap<ObjectIdGenerator.IdKey, a> f3877n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f3878o;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Impl extends DefaultDeserializationContext {
    }

    @Override // com.fasterxml.jackson.databind.DeserializationContext
    public final g K(Object obj) {
        g gVar;
        if (obj == null) {
            return null;
        }
        if (obj instanceof g) {
            gVar = (g) obj;
        } else {
            if (!(obj instanceof Class)) {
                throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + obj.getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
            }
            Class cls = (Class) obj;
            if (cls == g.a.class || com.fasterxml.jackson.databind.util.a.t(cls)) {
                return null;
            }
            if (!g.class.isAssignableFrom(cls)) {
                throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<KeyDeserializer>");
            }
            DeserializationConfig deserializationConfig = this.f3663c;
            deserializationConfig.h();
            gVar = (g) com.fasterxml.jackson.databind.util.a.h(cls, deserializationConfig.k(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS));
        }
        if (gVar instanceof j) {
            ((j) gVar).b(this);
        }
        return gVar;
    }

    public final void Y() throws UnresolvedForwardReference {
        if (this.f3877n != null && J(DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS)) {
            Iterator<Map.Entry<ObjectIdGenerator.IdKey, a>> it = this.f3877n.entrySet().iterator();
            UnresolvedForwardReference unresolvedForwardReference = null;
            while (it.hasNext()) {
                a value = it.next().getValue();
                LinkedList<a.AbstractC0031a> linkedList = value.f3950c;
                if (linkedList != null && !linkedList.isEmpty()) {
                    if (unresolvedForwardReference == null) {
                        unresolvedForwardReference = new UnresolvedForwardReference(this.h, "Unresolved forward references for: ");
                        unresolvedForwardReference.h = new ArrayList();
                    }
                    Object obj = value.f3949b.f3498c;
                    LinkedList<a.AbstractC0031a> linkedList2 = value.f3950c;
                    Iterator<a.AbstractC0031a> it2 = linkedList2 == null ? Collections.EMPTY_LIST.iterator() : linkedList2.iterator();
                    while (it2.hasNext()) {
                        a.AbstractC0031a next = it2.next();
                        unresolvedForwardReference.h.add(new k(obj, next.f3953b, next.f3952a.f3580a));
                    }
                }
            }
            if (unresolvedForwardReference != null) {
                throw unresolvedForwardReference;
            }
        }
    }

    public final Object Z(b bVar, JavaType javaType, c cVar) throws MismatchedInputException {
        DeserializationConfig deserializationConfig = this.f3663c;
        deserializationConfig.getClass();
        if (!deserializationConfig.p(DeserializationFeature.UNWRAP_ROOT_VALUE)) {
            return cVar.d(bVar, this);
        }
        RootNameLookup rootNameLookup = deserializationConfig.h;
        rootNameLookup.getClass();
        String str = rootNameLookup.a(javaType.f3690a, deserializationConfig).f3755a;
        JsonToken jsonToken = bVar.f13576c;
        JsonToken jsonToken2 = JsonToken.START_OBJECT;
        if (jsonToken != jsonToken2) {
            U(jsonToken2, "Current token not START_OBJECT (needed to unwrap root name %s), but %s", com.fasterxml.jackson.databind.util.a.x(str), bVar.f13576c);
            throw null;
        }
        JsonToken jsonTokenQ1 = bVar.q1();
        JsonToken jsonToken3 = JsonToken.FIELD_NAME;
        if (jsonTokenQ1 != jsonToken3) {
            U(jsonToken3, "Current token not FIELD_NAME (to contain expected root name %s), but %s", com.fasterxml.jackson.databind.util.a.x(str), bVar.f13576c);
            throw null;
        }
        String strC0 = bVar.C0();
        if (str.equals(strC0)) {
            bVar.q1();
            Object objD = cVar.d(bVar, this);
            JsonToken jsonTokenQ12 = bVar.q1();
            JsonToken jsonToken4 = JsonToken.END_OBJECT;
            if (jsonTokenQ12 == jsonToken4) {
                return objD;
            }
            U(jsonToken4, "Current token not END_OBJECT (to match wrapper object with root name %s), but %s", com.fasterxml.jackson.databind.util.a.c(str), bVar.f13576c);
            throw null;
        }
        Object[] objArr = {com.fasterxml.jackson.databind.util.a.x(strC0), com.fasterxml.jackson.databind.util.a.c(str), com.fasterxml.jackson.databind.util.a.r(javaType)};
        Class<?> cls = javaType.f3690a;
        MismatchedInputException mismatchedInputException = new MismatchedInputException(this.h, String.format("Root name (%s) does not match expected (%s) for type %s", objArr));
        if (strC0 == null) {
            throw mismatchedInputException;
        }
        mismatchedInputException.f(new JsonMappingException.Reference(cls, strC0));
        throw mismatchedInputException;
    }

    @Override // com.fasterxml.jackson.databind.DeserializationContext
    public final c l(Object obj) {
        c cVar;
        if (obj == null) {
            return null;
        }
        if (obj instanceof c) {
            cVar = (c) obj;
        } else {
            if (!(obj instanceof Class)) {
                throw new IllegalStateException("AnnotationIntrospector returned deserializer definition of type " + obj.getClass().getName() + "; expected type JsonDeserializer or Class<JsonDeserializer> instead");
            }
            Class cls = (Class) obj;
            if (cls == c.a.class || com.fasterxml.jackson.databind.util.a.t(cls)) {
                return null;
            }
            if (!c.class.isAssignableFrom(cls)) {
                throw new IllegalStateException("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<JsonDeserializer>");
            }
            DeserializationConfig deserializationConfig = this.f3663c;
            deserializationConfig.h();
            cVar = (c) com.fasterxml.jackson.databind.util.a.h(cls, deserializationConfig.k(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS));
        }
        if (cVar instanceof j) {
            ((j) cVar).b(this);
        }
        return cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fasterxml.jackson.databind.DeserializationContext
    public final a s(Object obj, ObjectIdGenerator<?> objectIdGenerator, com.fasterxml.jackson.annotation.a aVar) {
        com.fasterxml.jackson.annotation.b bVarD = null;
        if (obj == null) {
            return null;
        }
        ObjectIdGenerator.IdKey idKeyE = objectIdGenerator.e(obj);
        LinkedHashMap<ObjectIdGenerator.IdKey, a> linkedHashMap = this.f3877n;
        if (linkedHashMap == null) {
            this.f3877n = new LinkedHashMap<>();
        } else {
            a aVar2 = linkedHashMap.get(idKeyE);
            if (aVar2 != null) {
                return aVar2;
            }
        }
        ArrayList arrayList = this.f3878o;
        if (arrayList != null) {
            int size = arrayList.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    break;
                }
                Object obj2 = arrayList.get(i10);
                i10++;
                com.fasterxml.jackson.annotation.a aVar3 = (com.fasterxml.jackson.annotation.a) obj2;
                if (aVar3.b(aVar)) {
                    bVarD = aVar3;
                    break;
                }
            }
        } else {
            this.f3878o = new ArrayList(8);
        }
        if (bVarD == null) {
            bVarD = aVar.d();
            this.f3878o.add(bVarD);
        }
        a aVar4 = new a(idKeyE);
        aVar4.f3951d = bVarD;
        this.f3877n.put(idKeyE, aVar4);
        return aVar4;
    }
}
