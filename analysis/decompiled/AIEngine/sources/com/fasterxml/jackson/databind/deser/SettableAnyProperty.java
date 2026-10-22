package com.fasterxml.jackson.databind.deser;

import b3.c;
import b3.g;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.impl.a;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import k3.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class SettableAnyProperty implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final BeanProperty.Std f3881a;

    /* renamed from: b, reason: collision with root package name */
    public final AnnotatedMember f3882b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f3883c;

    /* renamed from: d, reason: collision with root package name */
    public final JavaType f3884d;

    /* renamed from: e, reason: collision with root package name */
    public final c<Object> f3885e;
    public final b h;

    /* renamed from: j, reason: collision with root package name */
    public final g f3886j;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends a.AbstractC0031a {

        /* renamed from: c, reason: collision with root package name */
        public final SettableAnyProperty f3887c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f3888d;

        /* renamed from: e, reason: collision with root package name */
        public final String f3889e;

        public a(SettableAnyProperty settableAnyProperty, UnresolvedForwardReference unresolvedForwardReference, Class<?> cls, Object obj, String str) {
            super(unresolvedForwardReference, cls);
            this.f3887c = settableAnyProperty;
            this.f3888d = obj;
            this.f3889e = str;
        }

        @Override // com.fasterxml.jackson.databind.deser.impl.a.AbstractC0031a
        public final void a(Object obj, Object obj2) throws IllegalAccessException, JsonMappingException, IllegalArgumentException, InvocationTargetException {
            if (obj.equals(this.f3952a.f3900e.f3949b.f3498c)) {
                this.f3887c.c(this.f3888d, this.f3889e, obj2);
            } else {
                throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + obj.toString() + "] that wasn't previously registered.");
            }
        }
    }

    public SettableAnyProperty(BeanProperty.Std std, AnnotatedMember annotatedMember, JavaType javaType, g gVar, c cVar, b bVar) {
        this.f3881a = std;
        this.f3882b = annotatedMember;
        this.f3884d = javaType;
        this.f3885e = cVar;
        this.h = bVar;
        this.f3886j = gVar;
        this.f3883c = annotatedMember instanceof AnnotatedField;
    }

    public final Object a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        boolean zI1 = jsonParser.i1(JsonToken.VALUE_NULL);
        c<Object> cVar = this.f3885e;
        if (zI1) {
            return cVar.a(deserializationContext);
        }
        b bVar = this.h;
        return bVar != null ? cVar.f(jsonParser, deserializationContext, bVar) : cVar.d(jsonParser, deserializationContext);
    }

    public final void b(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj, String str) throws IllegalAccessException, JsonMappingException, IllegalArgumentException, InvocationTargetException {
        try {
            g gVar = this.f3886j;
            c(obj, gVar == null ? str : gVar.a(deserializationContext, str), a(jsonParser, deserializationContext));
        } catch (UnresolvedForwardReference e10) {
            if (this.f3885e.l() == null) {
                throw new JsonMappingException(jsonParser, "Unresolved forward reference but no identity info.", e10);
            }
            e10.f3900e.a(new a(this, e10, this.f3884d.f3690a, obj, str));
        }
    }

    public final void c(Object obj, Object obj2, Object obj3) throws IllegalAccessException, JsonMappingException, IllegalArgumentException, InvocationTargetException {
        AnnotatedMember annotatedMember = this.f3882b;
        try {
            if (!this.f3883c) {
                ((AnnotatedMethod) annotatedMember).f4124d.invoke(obj, obj2, obj3);
            } else {
                Map map = (Map) ((AnnotatedField) annotatedMember).k(obj);
                if (map != null) {
                    map.put(obj2, obj3);
                }
            }
        } catch (Exception e10) {
            if (!(e10 instanceof IllegalArgumentException)) {
                com.fasterxml.jackson.databind.util.a.C(e10);
                com.fasterxml.jackson.databind.util.a.D(e10);
                Throwable thQ = com.fasterxml.jackson.databind.util.a.q(e10);
                throw new JsonMappingException((Closeable) null, com.fasterxml.jackson.databind.util.a.i(thQ), thQ);
            }
            String strF = com.fasterxml.jackson.databind.util.a.f(obj3);
            StringBuilder sb2 = new StringBuilder("Problem deserializing \"any\" property '");
            sb2.append(obj2);
            sb2.append("' of class " + annotatedMember.h().getName() + " (expected type: ");
            sb2.append(this.f3884d);
            sb2.append("; actual type: ");
            sb2.append(strF);
            sb2.append(")");
            String strI = com.fasterxml.jackson.databind.util.a.i(e10);
            if (strI != null) {
                sb2.append(", problem: ");
                sb2.append(strI);
            } else {
                sb2.append(" (no error message provided)");
            }
            throw new JsonMappingException((Closeable) null, sb2.toString(), e10);
        }
    }

    public Object readResolve() {
        if (this.f3882b.b() != null) {
            return this;
        }
        throw new IllegalArgumentException("Missing method (broken JDK (de)serialization?)");
    }

    public final String toString() {
        return "[any property on class " + this.f3882b.h().getName() + "]";
    }
}
