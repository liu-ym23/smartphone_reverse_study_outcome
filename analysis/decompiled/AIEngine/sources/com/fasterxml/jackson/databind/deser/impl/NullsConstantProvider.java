package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.databind.DeserializationContext;
import e3.i;
import java.io.Serializable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class NullsConstantProvider implements i, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final NullsConstantProvider f3924b = new NullsConstantProvider(null);

    /* renamed from: c, reason: collision with root package name */
    public static final NullsConstantProvider f3925c = new NullsConstantProvider(null);

    /* renamed from: a, reason: collision with root package name */
    public final Object f3926a;

    public NullsConstantProvider(Object obj) {
        this.f3926a = obj;
    }

    public static boolean b(i iVar) {
        return iVar == f3924b;
    }

    @Override // e3.i
    public final Object a(DeserializationContext deserializationContext) {
        return this.f3926a;
    }
}
