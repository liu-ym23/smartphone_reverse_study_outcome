package com.fasterxml.jackson.databind.b.a;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/* JADX INFO: compiled from: PropertyBasedObjectIdGenerator.java */
/* JADX INFO: loaded from: classes2.dex */
public class w extends ObjectIdGenerators.PropertyGenerator {
    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerator
    public ObjectIdGenerator<Object> newForSerialization(Object r1) {
        return this;
    }

    public w(Class<?> r1) {
        super(r1);
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerators.Base, com.fasterxml.jackson.annotation.ObjectIdGenerator
    public Object generateId(Object r1) {
        throw new UnsupportedOperationException();
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerator
    public ObjectIdGenerator<Object> forScope(Class<?> r2) {
        if (r2 != this._scope) goto L6;
        return this;
    L6:
        return new w(r2);
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerator
    public ObjectIdGenerator.IdKey key(Object r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        return new ObjectIdGenerator.IdKey(getClass(), this._scope, r3);
    }
}
