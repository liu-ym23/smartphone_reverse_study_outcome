package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.exc.InvalidNullException;
import e3.i;
import java.io.Serializable;
import java.lang.annotation.Annotation;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class NullsFailProvider implements i, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final PropertyName f3927a;

    public NullsFailProvider(PropertyName propertyName, JavaType javaType) {
        this.f3927a = propertyName;
    }

    @Override // e3.i
    public final Object a(DeserializationContext deserializationContext) throws InvalidNullException {
        int i10 = InvalidNullException.f4105e;
        Annotation[] annotationArr = com.fasterxml.jackson.databind.util.a.f4529a;
        PropertyName propertyName = this.f3927a;
        throw new InvalidNullException(deserializationContext.h, "Invalid `null` value encountered for property ".concat(propertyName == null ? "<UNKNOWN>" : String.format("\"%s\"", propertyName)), 0);
    }
}
