package com.fasterxml.jackson.databind.deser.std;

import b3.c;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.deser.impl.NullsConstantProvider;
import com.fasterxml.jackson.databind.util.AccessPattern;
import com.fasterxml.jackson.databind.util.a;
import e3.i;
import h0.e;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class ContainerDeserializerBase<T> extends StdDeserializer<T> {

    /* renamed from: d, reason: collision with root package name */
    public final JavaType f3964d;

    /* renamed from: e, reason: collision with root package name */
    public final i f3965e;
    public final boolean h;

    /* renamed from: j, reason: collision with root package name */
    public final Boolean f3966j;

    public ContainerDeserializerBase(JavaType javaType, i iVar, Boolean bool) {
        super(javaType);
        this.f3964d = javaType;
        this.f3966j = bool;
        this.f3965e = iVar;
        this.h = NullsConstantProvider.b(iVar);
    }

    public static void k0(DeserializationContext deserializationContext, Exception exc, Object obj, String str) throws IOException {
        Exception cause = exc;
        while ((cause instanceof InvocationTargetException) && cause.getCause() != null) {
            cause = cause.getCause();
        }
        a.B(cause);
        if (deserializationContext != null && !deserializationContext.J(DeserializationFeature.WRAP_EXCEPTIONS)) {
            a.D(cause);
        }
        if ((cause instanceof IOException) && !(cause instanceof JsonMappingException)) {
            throw ((IOException) cause);
        }
        if (str == null) {
            str = "N/A";
        }
        int i10 = JsonMappingException.f3695d;
        throw JsonMappingException.g(cause, new JsonMappingException.Reference(obj, str));
    }

    @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
    public JavaType f0() {
        return this.f3964d;
    }

    @Override // b3.c
    public final SettableBeanProperty h(String str) {
        c<Object> cVarJ0 = j0();
        if (cVarJ0 != null) {
            return cVarJ0.h(str);
        }
        throw new IllegalArgumentException(e.c("Cannot handle managed/back reference '", str, "': type: container deserializer of type ", getClass().getName(), " returned null for 'getContentDeserializer()'"));
    }

    @Override // b3.c
    public AccessPattern i() {
        return AccessPattern.f4493c;
    }

    @Override // b3.c
    public Object j(DeserializationContext deserializationContext) throws JsonMappingException {
        ValueInstantiator valueInstantiatorE0 = e0();
        if (valueInstantiatorE0 == null || !valueInstantiatorE0.j()) {
            deserializationContext.j(String.format("Cannot create empty instance of %s, no default Creator", f0()));
            throw null;
        }
        try {
            return valueInstantiatorE0.v(deserializationContext);
        } catch (IOException e10) {
            a.A(deserializationContext, e10);
            throw null;
        }
    }

    public abstract c<Object> j0();

    @Override // b3.c
    public final Boolean p(DeserializationConfig deserializationConfig) {
        return Boolean.TRUE;
    }

    public ContainerDeserializerBase(ContainerDeserializerBase<?> containerDeserializerBase, i iVar, Boolean bool) {
        super(containerDeserializerBase.f3964d);
        this.f3964d = containerDeserializerBase.f3964d;
        this.f3965e = iVar;
        this.f3966j = bool;
        this.h = NullsConstantProvider.b(iVar);
    }
}
