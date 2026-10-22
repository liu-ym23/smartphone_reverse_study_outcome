package com.fasterxml.jackson.databind.ser;

import b3.f;
import b3.h;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.util.a;
import java.io.IOException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.IdentityHashMap;
import n3.e;
import o3.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class DefaultSerializerProvider extends h implements Serializable {

    /* renamed from: p, reason: collision with root package name */
    public transient AbstractMap f4305p;

    /* renamed from: q, reason: collision with root package name */
    public transient ArrayList<ObjectIdGenerator<?>> f4306q;
    public transient JsonGenerator r;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Impl extends DefaultSerializerProvider {
    }

    public static IOException H(JsonGenerator jsonGenerator, Exception exc) {
        if (exc instanceof IOException) {
            return (IOException) exc;
        }
        String strI = a.i(exc);
        if (strI == null) {
            strI = "[no message for " + exc.getClass().getName() + "]";
        }
        return new JsonMappingException(jsonGenerator, strI, exc);
    }

    @Override // b3.h
    public final Object C(Class cls) {
        if (cls == null) {
            return null;
        }
        SerializationConfig serializationConfig = this.f3044a;
        serializationConfig.h();
        return a.h(cls, serializationConfig.k(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS));
    }

    @Override // b3.h
    public final boolean D(Object obj) throws InvalidDefinitionException {
        try {
            return obj.equals(null);
        } catch (Throwable th) {
            String name = obj.getClass().getName();
            String name2 = th.getClass().getName();
            String strI = a.i(th);
            StringBuilder sbS = ai.onnxruntime.a.s("Problem determining whether filter of type '", name, "' should filter out `null` values: (", name2, ") ");
            sbS.append(strI);
            String string = sbS.toString();
            Class<?> cls = obj.getClass();
            JsonGenerator jsonGenerator = this.r;
            this.e().j(cls);
            InvalidDefinitionException invalidDefinitionException = new InvalidDefinitionException(jsonGenerator, string);
            invalidDefinitionException.initCause(th);
            throw invalidDefinitionException;
        }
    }

    @Override // b3.h
    public final f<Object> G(i3.a aVar, Object obj) throws InvalidDefinitionException {
        f<Object> fVar;
        if (obj instanceof f) {
            fVar = (f) obj;
        } else {
            if (!(obj instanceof Class)) {
                aVar.f();
                j("AnnotationIntrospector returned serializer definition of type " + obj.getClass().getName() + "; expected type JsonSerializer or Class<JsonSerializer> instead");
                throw null;
            }
            Class cls = (Class) obj;
            if (cls == f.a.class || a.t(cls)) {
                return null;
            }
            if (!f.class.isAssignableFrom(cls)) {
                aVar.f();
                j("AnnotationIntrospector returned Class " + cls.getName() + "; expected Class<JsonSerializer>");
                throw null;
            }
            SerializationConfig serializationConfig = this.f3044a;
            serializationConfig.h();
            fVar = (f) a.h(cls, serializationConfig.k(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS));
        }
        if (fVar instanceof e) {
            ((e) fVar).b(this);
        }
        return fVar;
    }

    public final void I(JsonGenerator jsonGenerator, Object obj) {
        this.r = jsonGenerator;
        if (obj == null) {
            try {
                this.h.f(null, jsonGenerator, this);
                return;
            } catch (Exception e10) {
                throw H(jsonGenerator, e10);
            }
        }
        Class<?> cls = obj.getClass();
        f fVarW = w(cls);
        SerializationConfig serializationConfig = this.f3044a;
        serializationConfig.getClass();
        if (!serializationConfig.q(SerializationFeature.WRAP_ROOT_VALUE)) {
            try {
                fVarW.f(obj, jsonGenerator, this);
                return;
            } catch (Exception e11) {
                throw H(jsonGenerator, e11);
            }
        }
        PropertyName propertyNameA = serializationConfig.h.a(cls, serializationConfig);
        try {
            jsonGenerator.c1();
            SerializationConfig serializationConfig2 = this.f3044a;
            String str = propertyNameA.f3755a;
            SerializedString serializedString = propertyNameA.f3757c;
            if (serializedString == null) {
                serializedString = serializationConfig2 == null ? new SerializedString(str) : new SerializedString(str);
                propertyNameA.f3757c = serializedString;
            }
            jsonGenerator.I0(serializedString);
            fVarW.f(obj, jsonGenerator, this);
            jsonGenerator.G0();
        } catch (Exception e12) {
            throw H(jsonGenerator, e12);
        }
    }

    @Override // b3.h
    public final d t(Object obj, ObjectIdGenerator<?> objectIdGenerator) {
        ObjectIdGenerator<?> objectIdGeneratorF;
        AbstractMap abstractMap = this.f4305p;
        if (abstractMap == null) {
            this.f4305p = this.f3044a.q(SerializationFeature.USE_EQUALITY_FOR_OBJECT_ID) ? new HashMap() : new IdentityHashMap();
        } else {
            d dVar = (d) abstractMap.get(obj);
            if (dVar != null) {
                return dVar;
            }
        }
        ArrayList<ObjectIdGenerator<?>> arrayList = this.f4306q;
        if (arrayList == null) {
            this.f4306q = new ArrayList<>(8);
        } else {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                objectIdGeneratorF = this.f4306q.get(i10);
                if (objectIdGeneratorF.a(objectIdGenerator)) {
                    break;
                }
            }
        }
        objectIdGeneratorF = null;
        if (objectIdGeneratorF == null) {
            objectIdGeneratorF = objectIdGenerator.f();
            this.f4306q.add(objectIdGeneratorF);
        }
        d dVar2 = new d(objectIdGeneratorF);
        this.f4305p.put(obj, dVar2);
        return dVar2;
    }
}
