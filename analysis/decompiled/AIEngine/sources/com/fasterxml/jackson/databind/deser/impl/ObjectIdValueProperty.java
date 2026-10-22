package com.fasterxml.jackson.databind.deser.impl;

import b3.c;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import e3.i;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ObjectIdValueProperty extends SettableBeanProperty {

    /* renamed from: p, reason: collision with root package name */
    public final ObjectIdReader f3936p;

    public ObjectIdValueProperty(ObjectIdReader objectIdReader, PropertyMetadata propertyMetadata) {
        super(objectIdReader.f3929b, objectIdReader.f3928a, propertyMetadata, objectIdReader.f3932e);
        this.f3936p = objectIdReader;
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final Object A(Object obj, Object obj2) {
        SettableBeanProperty settableBeanProperty = this.f3936p.h;
        if (settableBeanProperty != null) {
            return settableBeanProperty.A(obj, obj2);
        }
        throw new UnsupportedOperationException("Should not call set() on ObjectIdProperty that has no SettableBeanProperty");
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final SettableBeanProperty B(PropertyName propertyName) {
        return new ObjectIdValueProperty(this, propertyName);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final SettableBeanProperty C(i iVar) {
        return new ObjectIdValueProperty(this, this.f3893e, iVar);
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
        return new ObjectIdValueProperty(this, cVar, iVar);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty, com.fasterxml.jackson.databind.BeanProperty
    public final AnnotatedMember d() {
        return null;
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final void i(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        j(jsonParser, deserializationContext, obj);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final Object j(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        if (jsonParser.i1(JsonToken.VALUE_NULL)) {
            return null;
        }
        Object objD = this.f3893e.d(jsonParser, deserializationContext);
        ObjectIdReader objectIdReader = this.f3936p;
        deserializationContext.s(objD, objectIdReader.f3930c, objectIdReader.f3931d).b(obj);
        SettableBeanProperty settableBeanProperty = objectIdReader.h;
        return settableBeanProperty != null ? settableBeanProperty.A(obj, objD) : obj;
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final void z(Object obj, Object obj2) {
        A(obj, obj2);
    }

    public ObjectIdValueProperty(ObjectIdValueProperty objectIdValueProperty, c<?> cVar, i iVar) {
        super(objectIdValueProperty, cVar, iVar);
        this.f3936p = objectIdValueProperty.f3936p;
    }

    public ObjectIdValueProperty(ObjectIdValueProperty objectIdValueProperty, PropertyName propertyName) {
        super(objectIdValueProperty, propertyName);
        this.f3936p = objectIdValueProperty.f3936p;
    }
}
