package com.fasterxml.jackson.databind.deser.impl;

import b3.c;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import java.io.Serializable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ObjectIdReader implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final JavaType f3928a;

    /* renamed from: b, reason: collision with root package name */
    public final PropertyName f3929b;

    /* renamed from: c, reason: collision with root package name */
    public final ObjectIdGenerator<?> f3930c;

    /* renamed from: d, reason: collision with root package name */
    public final com.fasterxml.jackson.annotation.a f3931d;

    /* renamed from: e, reason: collision with root package name */
    public final c<Object> f3932e;
    public final SettableBeanProperty h;

    public ObjectIdReader(JavaType javaType, PropertyName propertyName, ObjectIdGenerator<?> objectIdGenerator, c<?> cVar, SettableBeanProperty settableBeanProperty, com.fasterxml.jackson.annotation.a aVar) {
        this.f3928a = javaType;
        this.f3929b = propertyName;
        this.f3930c = objectIdGenerator;
        this.f3931d = aVar;
        this.f3932e = cVar;
        this.h = settableBeanProperty;
    }
}
