package com.fasterxml.jackson.databind.j.a;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.e.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PropertyBasedObjectIdGenerator.java */
/* JADX INFO: loaded from: classes2.dex */
public class j extends ObjectIdGenerators.PropertyGenerator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.j.d f12818a;

    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerator
    public ObjectIdGenerator<Object> newForSerialization(Object r1) {
        return this;
    }

    public j(ac r1, com.fasterxml.jackson.databind.j.d r2) {
        this(r1.c(), r2);
    }

    public j(Class<?> r1, com.fasterxml.jackson.databind.j.d r2) {
        super(r1);
        this.f12818a = r2;
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator, com.fasterxml.jackson.annotation.ObjectIdGenerators.Base, com.fasterxml.jackson.annotation.ObjectIdGenerator
    public boolean canUseFor(ObjectIdGenerator<?> r4) {
        if (r4.getClass() != getClass()) goto L10;
        j r5 = (j) ZeusTransformUtils.preCheckCast(r4, j.class, "com.obric.aiagent.plugin");
        if (r5.getScope() == this._scope) goto L7;
        return false;
    L7:
        if (r5.f12818a != this.f12818a) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerators.Base, com.fasterxml.jackson.annotation.ObjectIdGenerator
    public Object generateId(Object r4) {
        return this.f12818a.a(r4);
    L7:
        e = move-exception;
        throw e;
    L4:
        e = move-exception;
        throw new IllegalStateException("Problem accessing property '" + this.f12818a.a() + "': " + e.getMessage(), e);
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerator
    public ObjectIdGenerator<Object> forScope(Class<?> r2) {
        if (r2 != this._scope) goto L6;
        return this;
    L6:
        return new j(r2, this.f12818a);
    }

    @Override // com.fasterxml.jackson.annotation.ObjectIdGenerator
    public ObjectIdGenerator.IdKey key(Object r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        return new ObjectIdGenerator.IdKey(getClass(), this._scope, r3);
    }
}
