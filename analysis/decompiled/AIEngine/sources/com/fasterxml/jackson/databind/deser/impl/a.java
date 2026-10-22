package com.fasterxml.jackson.databind.deser.impl;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.UnresolvedForwardReference;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public Object f3948a;

    /* renamed from: b, reason: collision with root package name */
    public final ObjectIdGenerator.IdKey f3949b;

    /* renamed from: c, reason: collision with root package name */
    public LinkedList<AbstractC0031a> f3950c;

    /* renamed from: d, reason: collision with root package name */
    public com.fasterxml.jackson.annotation.a f3951d;

    public a(ObjectIdGenerator.IdKey idKey) {
        this.f3949b = idKey;
    }

    public final void a(AbstractC0031a abstractC0031a) {
        if (this.f3950c == null) {
            this.f3950c = new LinkedList<>();
        }
        this.f3950c.add(abstractC0031a);
    }

    public final void b(Object obj) {
        com.fasterxml.jackson.annotation.a aVar = this.f3951d;
        ObjectIdGenerator.IdKey idKey = this.f3949b;
        aVar.a(idKey, obj);
        this.f3948a = obj;
        Object obj2 = idKey.f3498c;
        LinkedList<AbstractC0031a> linkedList = this.f3950c;
        if (linkedList != null) {
            Iterator<AbstractC0031a> it = linkedList.iterator();
            this.f3950c = null;
            while (it.hasNext()) {
                it.next().a(obj2, obj);
            }
        }
    }

    public final String toString() {
        return String.valueOf(this.f3949b);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.fasterxml.jackson.databind.deser.impl.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0031a {

        /* renamed from: a, reason: collision with root package name */
        public final UnresolvedForwardReference f3952a;

        /* renamed from: b, reason: collision with root package name */
        public final Class<?> f3953b;

        public AbstractC0031a(UnresolvedForwardReference unresolvedForwardReference, Class<?> cls) {
            this.f3952a = unresolvedForwardReference;
            this.f3953b = cls;
        }

        public abstract void a(Object obj, Object obj2);

        public AbstractC0031a(UnresolvedForwardReference unresolvedForwardReference, JavaType javaType) {
            this.f3952a = unresolvedForwardReference;
            this.f3953b = javaType.f3690a;
        }
    }
}
