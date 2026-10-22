package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators$PropertyGenerator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class PropertyBasedObjectIdGenerator extends ObjectIdGenerators$PropertyGenerator {
    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerator
    public final ObjectIdGenerator<Object> b(Class<?> cls) {
        return cls == this.f3500a ? this : new PropertyBasedObjectIdGenerator(cls);
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerator
    public final Object c(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerator
    public final ObjectIdGenerator.IdKey e(Object obj) {
        if (obj == null) {
            return null;
        }
        return new ObjectIdGenerator.IdKey(getClass(), this.f3500a, obj);
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerator
    public final ObjectIdGenerator f() {
        return this;
    }
}
