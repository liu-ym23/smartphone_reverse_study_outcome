package com.fasterxml.jackson.databind.deser;

import b3.c;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.util.InternCache;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.impl.FailingDeserializer;
import com.fasterxml.jackson.databind.deser.impl.NullsConstantProvider;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase;
import com.fasterxml.jackson.databind.util.ViewMatcher;
import e3.i;
import i3.e;
import i3.h;
import java.io.Serializable;
import k3.b;
import q3.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class SettableBeanProperty extends ConcreteBeanPropertyBase implements Serializable {

    /* renamed from: o, reason: collision with root package name */
    public static final FailingDeserializer f3890o = new FailingDeserializer();

    /* renamed from: c, reason: collision with root package name */
    public final PropertyName f3891c;

    /* renamed from: d, reason: collision with root package name */
    public final JavaType f3892d;

    /* renamed from: e, reason: collision with root package name */
    public final c<Object> f3893e;
    public final b h;

    /* renamed from: j, reason: collision with root package name */
    public final i f3894j;

    /* renamed from: k, reason: collision with root package name */
    public String f3895k;

    /* renamed from: l, reason: collision with root package name */
    public h f3896l;

    /* renamed from: m, reason: collision with root package name */
    public ViewMatcher f3897m;

    /* renamed from: n, reason: collision with root package name */
    public int f3898n;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class Delegating extends SettableBeanProperty {

        /* renamed from: p, reason: collision with root package name */
        public final SettableBeanProperty f3899p;

        public Delegating(SettableBeanProperty settableBeanProperty) {
            super(settableBeanProperty);
            this.f3899p = settableBeanProperty;
        }

        @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
        public Object A(Object obj, Object obj2) {
            return this.f3899p.A(obj, obj2);
        }

        @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
        public final SettableBeanProperty B(PropertyName propertyName) {
            SettableBeanProperty settableBeanProperty = this.f3899p;
            SettableBeanProperty settableBeanPropertyB = settableBeanProperty.B(propertyName);
            return settableBeanPropertyB == settableBeanProperty ? this : E(settableBeanPropertyB);
        }

        @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
        public final SettableBeanProperty C(i iVar) {
            SettableBeanProperty settableBeanProperty = this.f3899p;
            SettableBeanProperty settableBeanPropertyC = settableBeanProperty.C(iVar);
            return settableBeanPropertyC == settableBeanProperty ? this : E(settableBeanPropertyC);
        }

        @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
        public final SettableBeanProperty D(c<?> cVar) {
            SettableBeanProperty settableBeanProperty = this.f3899p;
            SettableBeanProperty settableBeanPropertyD = settableBeanProperty.D(cVar);
            return settableBeanPropertyD == settableBeanProperty ? this : E(settableBeanPropertyD);
        }

        public abstract SettableBeanProperty E(SettableBeanProperty settableBeanProperty);

        @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty, com.fasterxml.jackson.databind.BeanProperty
        public final AnnotatedMember d() {
            return this.f3899p.d();
        }

        @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
        public final void g(int i10) {
            this.f3899p.g(i10);
        }

        @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
        public void l(DeserializationConfig deserializationConfig) {
            this.f3899p.l(deserializationConfig);
        }

        @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
        public final int m() {
            return this.f3899p.m();
        }

        @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
        public final Class<?> n() {
            return this.f3899p.n();
        }

        @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
        public final Object o() {
            return this.f3899p.o();
        }

        @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
        public final String p() {
            return this.f3899p.p();
        }

        @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
        public final h q() {
            return this.f3899p.q();
        }

        @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
        public final c<Object> r() {
            return this.f3899p.r();
        }

        @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
        public final b s() {
            return this.f3899p.s();
        }

        @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
        public final boolean t() {
            return this.f3899p.t();
        }

        @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
        public final boolean u() {
            return this.f3899p.u();
        }

        @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
        public final boolean v() {
            return this.f3899p.v();
        }

        @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
        public final boolean x() {
            return this.f3899p.x();
        }

        @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
        public void z(Object obj, Object obj2) {
            this.f3899p.z(obj, obj2);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SettableBeanProperty(e eVar, JavaType javaType, b bVar, a aVar) {
        PropertyName propertyNameB = eVar.b();
        eVar.u();
        this(propertyNameB, javaType, null, bVar, aVar, eVar.c());
    }

    public abstract Object A(Object obj, Object obj2);

    public abstract SettableBeanProperty B(PropertyName propertyName);

    public abstract SettableBeanProperty C(i iVar);

    public abstract SettableBeanProperty D(c<?> cVar);

    @Override // com.fasterxml.jackson.databind.BeanProperty
    public final PropertyName b() {
        return this.f3891c;
    }

    @Override // com.fasterxml.jackson.databind.BeanProperty
    public abstract AnnotatedMember d();

    public final void f(JsonParser jsonParser, Exception exc, Object obj) throws JsonMappingException {
        if (!(exc instanceof IllegalArgumentException)) {
            com.fasterxml.jackson.databind.util.a.C(exc);
            com.fasterxml.jackson.databind.util.a.D(exc);
            Throwable thQ = com.fasterxml.jackson.databind.util.a.q(exc);
            throw new JsonMappingException(jsonParser, com.fasterxml.jackson.databind.util.a.i(thQ), thQ);
        }
        String strF = com.fasterxml.jackson.databind.util.a.f(obj);
        StringBuilder sb2 = new StringBuilder("Problem deserializing property '");
        sb2.append(this.f3891c.f3755a);
        sb2.append("' (expected type: ");
        sb2.append(this.f3892d);
        sb2.append("; actual type: ");
        sb2.append(strF);
        sb2.append(")");
        String strI = com.fasterxml.jackson.databind.util.a.i(exc);
        if (strI != null) {
            sb2.append(", problem: ");
            sb2.append(strI);
        } else {
            sb2.append(" (no error message provided)");
        }
        throw new JsonMappingException(jsonParser, sb2.toString(), exc);
    }

    public void g(int i10) {
        if (this.f3898n == -1) {
            this.f3898n = i10;
            return;
        }
        throw new IllegalStateException("Property '" + this.f3891c.f3755a + "' already had index (" + this.f3898n + "), trying to assign " + i10);
    }

    @Override // q3.k
    public final String getName() {
        return this.f3891c.f3755a;
    }

    @Override // com.fasterxml.jackson.databind.BeanProperty
    public final JavaType getType() {
        return this.f3892d;
    }

    public final Object h(JsonParser jsonParser, DeserializationContext deserializationContext) {
        boolean zI1 = jsonParser.i1(JsonToken.VALUE_NULL);
        i iVar = this.f3894j;
        if (zI1) {
            return iVar.a(deserializationContext);
        }
        c<Object> cVar = this.f3893e;
        b bVar = this.h;
        if (bVar != null) {
            return cVar.f(jsonParser, deserializationContext, bVar);
        }
        Object objD = cVar.d(jsonParser, deserializationContext);
        return objD == null ? iVar.a(deserializationContext) : objD;
    }

    public abstract void i(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj);

    public abstract Object j(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj);

    public final Object k(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws InvalidDefinitionException {
        boolean zI1 = jsonParser.i1(JsonToken.VALUE_NULL);
        i iVar = this.f3894j;
        if (zI1) {
            if (!NullsConstantProvider.b(iVar)) {
                return iVar.a(deserializationContext);
            }
        } else {
            if (this.h != null) {
                deserializationContext.j("Cannot merge polymorphic property '" + this.f3891c.f3755a + "'");
                throw null;
            }
            Object objE = this.f3893e.e(jsonParser, deserializationContext, obj);
            if (objE != null) {
                return objE;
            }
            if (!NullsConstantProvider.b(iVar)) {
                return iVar.a(deserializationContext);
            }
        }
        return obj;
    }

    public int m() {
        throw new IllegalStateException(h0.e.c("Internal error: no creator index for property '", this.f3891c.f3755a, "' (of type ", getClass().getName(), ")"));
    }

    public Class<?> n() {
        return d().h();
    }

    public Object o() {
        return null;
    }

    public String p() {
        return this.f3895k;
    }

    public h q() {
        return this.f3896l;
    }

    public c<Object> r() {
        FailingDeserializer failingDeserializer = f3890o;
        c<Object> cVar = this.f3893e;
        if (cVar == failingDeserializer) {
            return null;
        }
        return cVar;
    }

    public b s() {
        return this.h;
    }

    public boolean t() {
        c<Object> cVar = this.f3893e;
        return (cVar == null || cVar == f3890o) ? false : true;
    }

    public String toString() {
        return ai.onnxruntime.a.o(new StringBuilder("[property '"), this.f3891c.f3755a, "']");
    }

    public boolean u() {
        return this.h != null;
    }

    public boolean v() {
        return this.f3897m != null;
    }

    public boolean w() {
        return false;
    }

    public boolean x() {
        return false;
    }

    public abstract void z(Object obj, Object obj2);

    public SettableBeanProperty(PropertyName propertyName, JavaType javaType, PropertyName propertyName2, b bVar, a aVar, PropertyMetadata propertyMetadata) {
        String strA;
        super(propertyMetadata);
        this.f3898n = -1;
        if (propertyName == null) {
            this.f3891c = PropertyName.f3754e;
        } else {
            String str = propertyName.f3755a;
            if (!str.isEmpty() && (strA = InternCache.f3643b.a(str)) != str) {
                propertyName = new PropertyName(strA, propertyName.f3756b);
            }
            this.f3891c = propertyName;
        }
        this.f3892d = javaType;
        this.f3897m = null;
        this.h = bVar != null ? bVar.f(this) : bVar;
        FailingDeserializer failingDeserializer = f3890o;
        this.f3893e = failingDeserializer;
        this.f3894j = failingDeserializer;
    }

    public SettableBeanProperty(PropertyName propertyName, JavaType javaType, PropertyMetadata propertyMetadata, c<Object> cVar) {
        String strA;
        super(propertyMetadata);
        this.f3898n = -1;
        if (propertyName == null) {
            this.f3891c = PropertyName.f3754e;
        } else {
            String str = propertyName.f3755a;
            if (!str.isEmpty() && (strA = InternCache.f3643b.a(str)) != str) {
                propertyName = new PropertyName(strA, propertyName.f3756b);
            }
            this.f3891c = propertyName;
        }
        this.f3892d = javaType;
        this.f3897m = null;
        this.h = null;
        this.f3893e = cVar;
        this.f3894j = cVar;
    }

    public void y() {
    }

    public void l(DeserializationConfig deserializationConfig) {
    }

    public SettableBeanProperty(SettableBeanProperty settableBeanProperty) {
        super(settableBeanProperty);
        this.f3898n = -1;
        this.f3891c = settableBeanProperty.f3891c;
        this.f3892d = settableBeanProperty.f3892d;
        this.f3893e = settableBeanProperty.f3893e;
        this.h = settableBeanProperty.h;
        this.f3895k = settableBeanProperty.f3895k;
        this.f3898n = settableBeanProperty.f3898n;
        this.f3897m = settableBeanProperty.f3897m;
        this.f3894j = settableBeanProperty.f3894j;
    }

    public SettableBeanProperty(SettableBeanProperty settableBeanProperty, c<?> cVar, i iVar) {
        super(settableBeanProperty);
        this.f3898n = -1;
        this.f3891c = settableBeanProperty.f3891c;
        this.f3892d = settableBeanProperty.f3892d;
        this.h = settableBeanProperty.h;
        this.f3895k = settableBeanProperty.f3895k;
        this.f3898n = settableBeanProperty.f3898n;
        FailingDeserializer failingDeserializer = f3890o;
        if (cVar == null) {
            this.f3893e = failingDeserializer;
        } else {
            this.f3893e = cVar;
        }
        this.f3897m = settableBeanProperty.f3897m;
        this.f3894j = iVar == failingDeserializer ? this.f3893e : iVar;
    }

    public SettableBeanProperty(SettableBeanProperty settableBeanProperty, PropertyName propertyName) {
        super(settableBeanProperty);
        this.f3898n = -1;
        this.f3891c = propertyName;
        this.f3892d = settableBeanProperty.f3892d;
        this.f3893e = settableBeanProperty.f3893e;
        this.h = settableBeanProperty.h;
        this.f3895k = settableBeanProperty.f3895k;
        this.f3898n = settableBeanProperty.f3898n;
        this.f3897m = settableBeanProperty.f3897m;
        this.f3894j = settableBeanProperty.f3894j;
    }
}
