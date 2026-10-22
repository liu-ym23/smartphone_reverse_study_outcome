package com.fasterxml.jackson.databind.deser;

import b3.c;
import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import e3.i;
import k3.b;
import q3.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class CreatorProperty extends SettableBeanProperty {

    /* renamed from: p, reason: collision with root package name */
    public final AnnotatedParameter f3873p;

    /* renamed from: q, reason: collision with root package name */
    public final JacksonInject.Value f3874q;
    public SettableBeanProperty r;

    /* renamed from: s, reason: collision with root package name */
    public final int f3875s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f3876t;

    public CreatorProperty(PropertyName propertyName, JavaType javaType, b bVar, a aVar, AnnotatedParameter annotatedParameter, int i10, JacksonInject.Value value, PropertyMetadata propertyMetadata) {
        super(propertyName, javaType, null, bVar, aVar, propertyMetadata);
        this.f3873p = annotatedParameter;
        this.f3875s = i10;
        this.f3874q = value;
        this.r = null;
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final Object A(Object obj, Object obj2) throws InvalidDefinitionException {
        E();
        return this.r.A(obj, obj2);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final SettableBeanProperty B(PropertyName propertyName) {
        return new CreatorProperty(this, propertyName);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final SettableBeanProperty C(i iVar) {
        return new CreatorProperty(this, this.f3893e, iVar);
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
        return new CreatorProperty(this, cVar, iVar);
    }

    public final void E() throws InvalidDefinitionException {
        if (this.r != null) {
            return;
        }
        throw new InvalidDefinitionException(null, "No fallback setter/field defined for creator property " + com.fasterxml.jackson.databind.util.a.x(this.f3891c.f3755a));
    }

    @Override // com.fasterxml.jackson.databind.introspect.ConcreteBeanPropertyBase, com.fasterxml.jackson.databind.BeanProperty
    public final PropertyMetadata c() {
        SettableBeanProperty settableBeanProperty = this.r;
        PropertyMetadata propertyMetadata = this.f4149a;
        return settableBeanProperty != null ? propertyMetadata.b(settableBeanProperty.c().f3749e) : propertyMetadata;
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty, com.fasterxml.jackson.databind.BeanProperty
    public final AnnotatedMember d() {
        return this.f3873p;
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final void i(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws InvalidDefinitionException {
        E();
        this.r.z(obj, h(jsonParser, deserializationContext));
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final Object j(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws InvalidDefinitionException {
        E();
        return this.r.A(obj, h(jsonParser, deserializationContext));
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final void l(DeserializationConfig deserializationConfig) {
        SettableBeanProperty settableBeanProperty = this.r;
        if (settableBeanProperty != null) {
            settableBeanProperty.l(deserializationConfig);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final int m() {
        return this.f3875s;
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final Object o() {
        JacksonInject.Value value = this.f3874q;
        if (value == null) {
            return null;
        }
        return value.f3422a;
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final String toString() {
        return "[creator property, name " + com.fasterxml.jackson.databind.util.a.x(this.f3891c.f3755a) + "; inject id '" + o() + "']";
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final boolean w() {
        return this.f3876t;
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final boolean x() {
        JacksonInject.Value value = this.f3874q;
        if (value == null) {
            return false;
        }
        Boolean bool = value.f3423b;
        return !(bool == null ? true : bool.booleanValue());
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final void y() {
        this.f3876t = true;
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final void z(Object obj, Object obj2) throws InvalidDefinitionException {
        E();
        this.r.z(obj, obj2);
    }

    public CreatorProperty(CreatorProperty creatorProperty, PropertyName propertyName) {
        super(creatorProperty, propertyName);
        this.f3873p = creatorProperty.f3873p;
        this.f3874q = creatorProperty.f3874q;
        this.r = creatorProperty.r;
        this.f3875s = creatorProperty.f3875s;
        this.f3876t = creatorProperty.f3876t;
    }

    public CreatorProperty(CreatorProperty creatorProperty, c<?> cVar, i iVar) {
        super(creatorProperty, cVar, iVar);
        this.f3873p = creatorProperty.f3873p;
        this.f3874q = creatorProperty.f3874q;
        this.r = creatorProperty.r;
        this.f3875s = creatorProperty.f3875s;
        this.f3876t = creatorProperty.f3876t;
    }
}
