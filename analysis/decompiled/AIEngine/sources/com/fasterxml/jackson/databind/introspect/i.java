package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeBindings;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.lang.reflect.Type;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface i {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a implements i {

        /* renamed from: a, reason: collision with root package name */
        public final TypeFactory f4231a;

        /* renamed from: b, reason: collision with root package name */
        public final TypeBindings f4232b;

        public a(TypeFactory typeFactory, TypeBindings typeBindings) {
            this.f4231a = typeFactory;
            this.f4232b = typeBindings;
        }

        @Override // com.fasterxml.jackson.databind.introspect.i
        public final JavaType a(Type type) {
            return this.f4231a.b(null, type, this.f4232b);
        }
    }

    JavaType a(Type type);
}
