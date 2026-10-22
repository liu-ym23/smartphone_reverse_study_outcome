package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class MergingSettableBeanProperty extends SettableBeanProperty.Delegating {

    /* renamed from: q, reason: collision with root package name */
    public final AnnotatedMember f3920q;

    public MergingSettableBeanProperty(SettableBeanProperty settableBeanProperty, AnnotatedMember annotatedMember) {
        super(settableBeanProperty);
        this.f3920q = annotatedMember;
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty.Delegating, com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final Object A(Object obj, Object obj2) {
        return obj2 != null ? this.f3899p.A(obj, obj2) : obj;
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty.Delegating
    public final SettableBeanProperty E(SettableBeanProperty settableBeanProperty) {
        return new MergingSettableBeanProperty(settableBeanProperty, this.f3920q);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final void i(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        Object objK = this.f3920q.k(obj);
        SettableBeanProperty settableBeanProperty = this.f3899p;
        Object objH = objK == null ? settableBeanProperty.h(jsonParser, deserializationContext) : settableBeanProperty.k(jsonParser, deserializationContext, objK);
        if (objH != objK) {
            settableBeanProperty.z(obj, objH);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final Object j(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        Object objK = this.f3920q.k(obj);
        SettableBeanProperty settableBeanProperty = this.f3899p;
        Object objH = objK == null ? settableBeanProperty.h(jsonParser, deserializationContext) : settableBeanProperty.k(jsonParser, deserializationContext, objK);
        return (objH == objK || objH == null) ? obj : settableBeanProperty.A(obj, objH);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty.Delegating, com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final void z(Object obj, Object obj2) {
        if (obj2 != null) {
            this.f3899p.z(obj, obj2);
        }
    }
}
