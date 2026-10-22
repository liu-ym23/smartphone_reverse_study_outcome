package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import java.util.Collection;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ManagedReferenceProperty extends SettableBeanProperty.Delegating {

    /* renamed from: q, reason: collision with root package name */
    public final String f3918q;
    public final boolean r;

    /* renamed from: s, reason: collision with root package name */
    public final SettableBeanProperty f3919s;

    public ManagedReferenceProperty(SettableBeanProperty settableBeanProperty, String str, SettableBeanProperty settableBeanProperty2, boolean z) {
        super(settableBeanProperty);
        this.f3918q = str;
        this.f3919s = settableBeanProperty2;
        this.r = z;
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty.Delegating, com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final Object A(Object obj, Object obj2) {
        if (obj2 != null) {
            boolean z = this.r;
            SettableBeanProperty settableBeanProperty = this.f3919s;
            if (!z) {
                settableBeanProperty.z(obj2, obj);
            } else if (obj2 instanceof Object[]) {
                for (Object obj3 : (Object[]) obj2) {
                    if (obj3 != null) {
                        settableBeanProperty.z(obj3, obj);
                    }
                }
            } else if (obj2 instanceof Collection) {
                for (Object obj4 : (Collection) obj2) {
                    if (obj4 != null) {
                        settableBeanProperty.z(obj4, obj);
                    }
                }
            } else {
                if (!(obj2 instanceof Map)) {
                    StringBuilder sb2 = new StringBuilder("Unsupported container type (");
                    sb2.append(obj2.getClass().getName());
                    sb2.append(") when resolving reference '");
                    throw new IllegalStateException(ai.onnxruntime.a.o(sb2, this.f3918q, "'"));
                }
                for (Object obj5 : ((Map) obj2).values()) {
                    if (obj5 != null) {
                        settableBeanProperty.z(obj5, obj);
                    }
                }
            }
        }
        return this.f3899p.A(obj, obj2);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty.Delegating
    public final SettableBeanProperty E(SettableBeanProperty settableBeanProperty) {
        throw new IllegalStateException("Should never try to reset delegate");
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final void i(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        A(obj, this.f3899p.h(jsonParser, deserializationContext));
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final Object j(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        return A(obj, h(jsonParser, deserializationContext));
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty.Delegating, com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final void l(DeserializationConfig deserializationConfig) {
        this.f3899p.l(deserializationConfig);
        this.f3919s.l(deserializationConfig);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty.Delegating, com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final void z(Object obj, Object obj2) {
        A(obj, obj2);
    }
}
