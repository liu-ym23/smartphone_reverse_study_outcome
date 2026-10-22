package com.fasterxml.jackson.databind.deser.impl;

import b3.c;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import e3.i;
import i3.e;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import k3.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SetterlessProperty extends SettableBeanProperty {

    /* renamed from: p, reason: collision with root package name */
    public final AnnotatedMethod f3942p;

    /* renamed from: q, reason: collision with root package name */
    public final Method f3943q;

    public SetterlessProperty(e eVar, JavaType javaType, b bVar, q3.a aVar, AnnotatedMethod annotatedMethod) {
        super(eVar, javaType, bVar, aVar);
        this.f3942p = annotatedMethod;
        this.f3943q = annotatedMethod.f4124d;
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final Object A(Object obj, Object obj2) {
        z(obj, obj2);
        throw null;
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final SettableBeanProperty B(PropertyName propertyName) {
        return new SetterlessProperty(this, propertyName);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final SettableBeanProperty C(i iVar) {
        return new SetterlessProperty(this, this.f3893e, iVar);
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
        return new SetterlessProperty(this, cVar, iVar);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty, com.fasterxml.jackson.databind.BeanProperty
    public final AnnotatedMember d() {
        return this.f3942p;
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final void i(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IllegalAccessException, JsonMappingException, IllegalArgumentException, InvocationTargetException {
        if (jsonParser.i1(JsonToken.VALUE_NULL)) {
            return;
        }
        b bVar = this.h;
        PropertyName propertyName = this.f3891c;
        if (bVar != null) {
            deserializationContext.j("Problem deserializing 'setterless' property (\"" + propertyName.f3755a + "\"): no way to handle typed deser with setterless yet");
            throw null;
        }
        try {
            Object objInvoke = this.f3943q.invoke(obj, null);
            if (objInvoke != null) {
                this.f3893e.e(jsonParser, deserializationContext, objInvoke);
                return;
            }
            deserializationContext.j("Problem deserializing 'setterless' property '" + propertyName.f3755a + "': get method returned null");
            throw null;
        } catch (Exception e10) {
            com.fasterxml.jackson.databind.util.a.C(e10);
            com.fasterxml.jackson.databind.util.a.D(e10);
            Throwable thQ = com.fasterxml.jackson.databind.util.a.q(e10);
            throw new JsonMappingException(jsonParser, com.fasterxml.jackson.databind.util.a.i(thQ), thQ);
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final Object j(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IllegalAccessException, JsonMappingException, IllegalArgumentException, InvocationTargetException {
        i(jsonParser, deserializationContext, obj);
        return obj;
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final void l(DeserializationConfig deserializationConfig) {
        this.f3942p.g(deserializationConfig.k(MapperFeature.OVERRIDE_PUBLIC_ACCESS_MODIFIERS));
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final void z(Object obj, Object obj2) {
        throw new UnsupportedOperationException(ai.onnxruntime.a.o(new StringBuilder("Should never call `set()` on setterless property ('"), this.f3891c.f3755a, "')"));
    }

    public SetterlessProperty(SetterlessProperty setterlessProperty, c<?> cVar, i iVar) {
        super(setterlessProperty, cVar, iVar);
        this.f3942p = setterlessProperty.f3942p;
        this.f3943q = setterlessProperty.f3943q;
    }

    public SetterlessProperty(SetterlessProperty setterlessProperty, PropertyName propertyName) {
        super(setterlessProperty, propertyName);
        this.f3942p = setterlessProperty.f3942p;
        this.f3943q = setterlessProperty.f3943q;
    }
}
