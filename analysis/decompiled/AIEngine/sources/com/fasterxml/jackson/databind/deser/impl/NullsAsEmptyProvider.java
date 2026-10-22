package com.fasterxml.jackson.databind.deser.impl;

import b3.c;
import com.fasterxml.jackson.databind.DeserializationContext;
import e3.i;
import java.io.Serializable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class NullsAsEmptyProvider implements i, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final c<?> f3923a;

    public NullsAsEmptyProvider(c<?> cVar) {
        this.f3923a = cVar;
    }

    @Override // e3.i
    public final Object a(DeserializationContext deserializationContext) {
        return this.f3923a.j(deserializationContext);
    }
}
