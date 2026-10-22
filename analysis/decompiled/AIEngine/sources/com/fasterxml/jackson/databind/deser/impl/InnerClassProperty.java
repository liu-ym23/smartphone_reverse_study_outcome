package com.fasterxml.jackson.databind.deser.impl;

import b3.c;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import k3.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class InnerClassProperty extends SettableBeanProperty.Delegating {

    /* renamed from: q, reason: collision with root package name */
    public final transient Constructor<?> f3913q;
    public final AnnotatedConstructor r;

    public InnerClassProperty(SettableBeanProperty settableBeanProperty, Constructor<?> constructor) {
        super(settableBeanProperty);
        this.f3913q = constructor;
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty.Delegating
    public final SettableBeanProperty E(SettableBeanProperty settableBeanProperty) {
        return settableBeanProperty == this.f3899p ? this : new InnerClassProperty(settableBeanProperty, this.f3913q);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final void i(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) throws IllegalAccessException, InvalidDefinitionException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Object objF;
        Constructor<?> constructor = this.f3913q;
        JsonToken jsonTokenK = jsonParser.K();
        JsonToken jsonToken = JsonToken.VALUE_NULL;
        c<Object> cVar = this.f3893e;
        if (jsonTokenK == jsonToken) {
            objF = cVar.a(deserializationContext);
        } else {
            b bVar = this.h;
            if (bVar != null) {
                objF = cVar.f(jsonParser, deserializationContext, bVar);
            } else {
                try {
                    Object objNewInstance = constructor.newInstance(obj);
                    cVar.e(jsonParser, deserializationContext, objNewInstance);
                    objF = objNewInstance;
                } catch (Exception e10) {
                    String strL = ai.onnxruntime.a.l("Failed to instantiate class ", constructor.getDeclaringClass().getName(), ", problem: ", e10.getMessage());
                    Throwable thQ = com.fasterxml.jackson.databind.util.a.q(e10);
                    com.fasterxml.jackson.databind.util.a.D(thQ);
                    com.fasterxml.jackson.databind.util.a.B(thQ);
                    throw new IllegalArgumentException(strL, thQ);
                }
            }
        }
        z(obj, objF);
    }

    @Override // com.fasterxml.jackson.databind.deser.SettableBeanProperty
    public final Object j(JsonParser jsonParser, DeserializationContext deserializationContext, Object obj) {
        return this.f3899p.A(obj, h(jsonParser, deserializationContext));
    }

    public Object readResolve() {
        return new InnerClassProperty(this, this.r);
    }

    public Object writeReplace() {
        return this.r == null ? new InnerClassProperty(this, new AnnotatedConstructor(null, this.f3913q, null, null)) : this;
    }

    public InnerClassProperty(InnerClassProperty innerClassProperty, AnnotatedConstructor annotatedConstructor) {
        super(innerClassProperty);
        this.r = annotatedConstructor;
        Constructor<?> constructor = annotatedConstructor == null ? null : annotatedConstructor.f4114d;
        this.f3913q = constructor;
        if (constructor == null) {
            throw new IllegalArgumentException("Missing constructor (broken JDK (de)serialization?)");
        }
    }
}
