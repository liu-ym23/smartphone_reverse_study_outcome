package com.fasterxml.jackson.databind.deser.impl;

import b3.c;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import com.fasterxml.jackson.databind.deser.impl.a;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import e3.i;
import i3.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ObjectIdReferenceProperty extends SettableBeanProperty {

    /* renamed from: p, reason: collision with root package name */
    public final SettableBeanProperty f3933p;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a extends a.AbstractC0031a {

        /* renamed from: c, reason: collision with root package name */
        public final ObjectIdReferenceProperty f3934c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f3935d;

        public a(ObjectIdReferenceProperty objectIdReferenceProperty, UnresolvedForwardReference unresolvedForwardReference, Class<?> cls, Object obj) {
            super(unresolvedForwardReference, cls);
            this.f3934c = objectIdReferenceProperty;
            this.f3935d = obj;
        }

        @Override // com.fasterxml.jackson.databind.deser.impl.a.AbstractC0031a
        public final void a(Object obj, Object obj2) {
            if (obj.equals(this.f3952a.f3900e.f3949b.f3498c)) {
                this.f3934c.z(this.f3935d, obj2);
                return;
            }
            throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + obj + "] that wasn't previously seen as unresolved.");
        }
    }

    public ObjectIdReferenceProperty(SettableBeanProperty settableBeanProperty, h hVar) {
        super(settableBeanProperty);
        this.f3933p = settableBeanProperty;
        this.f3896l = hVar;
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final Object A(Object obj, Object obj2) {
        return this.f3933p.A(obj, obj2);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final SettableBeanProperty B(PropertyName propertyName) {
        return new ObjectIdReferenceProperty(this, propertyName);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final SettableBeanProperty C(i iVar) {
        return new ObjectIdReferenceProperty(this, this.f3893e, iVar);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final SettableBeanProperty D(c<?> cVar) {
        c<?> cVar2 = this.f3893e;
        if (cVar2 == cVar) {
            return this;
        }
        i iVar = this.f3894j;
        if (cVar2 == iVar) {
            iVar = cVar;
        }
        return new ObjectIdReferenceProperty(this, cVar, iVar);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty, com.fasterxml.jackson.databind.BeanProperty
    public final AnnotatedMember d() {
        return this.f3933p.d();
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final void i(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws JsonMappingException {
        j(jsonParser, deserializationContext, obj);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final Object j(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws JsonMappingException {
        try {
            return this.f3933p.A(obj, h(jsonParser, deserializationContext));
        } catch (UnresolvedForwardReference e10) {
            if (this.f3896l == null && this.f3893e.l() == null) {
                throw new JsonMappingException(jsonParser, "Unresolved forward reference but no identity info", e10);
            }
            e10.f3900e.a(new a(this, e10, this.f3892d.f3690a, obj));
            return null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final void l(DeserializationConfig deserializationConfig) {
        SettableBeanProperty settableBeanProperty = this.f3933p;
        if (settableBeanProperty != null) {
            settableBeanProperty.l(deserializationConfig);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final int m() {
        return this.f3933p.m();
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final void z(Object obj, Object obj2) {
        this.f3933p.z(obj, obj2);
    }

    public ObjectIdReferenceProperty(ObjectIdReferenceProperty objectIdReferenceProperty, c<?> cVar, i iVar) {
        super(objectIdReferenceProperty, cVar, iVar);
        this.f3933p = objectIdReferenceProperty.f3933p;
        this.f3896l = objectIdReferenceProperty.f3896l;
    }

    public ObjectIdReferenceProperty(ObjectIdReferenceProperty objectIdReferenceProperty, PropertyName propertyName) {
        super(objectIdReferenceProperty, propertyName);
        this.f3933p = objectIdReferenceProperty.f3933p;
        this.f3896l = objectIdReferenceProperty.f3896l;
    }
}
