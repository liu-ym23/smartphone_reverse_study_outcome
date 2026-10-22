package com.fasterxml.jackson.databind.jsontype;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import java.io.Closeable;
import java.io.Serializable;
import java.util.HashSet;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class DefaultBaseTypeLimitingValidator extends PolymorphicTypeValidator implements Serializable {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: b, reason: collision with root package name */
        public static final a f4233b = new a();

        /* renamed from: a, reason: collision with root package name */
        public final HashSet f4234a;

        public a() {
            HashSet hashSet = new HashSet();
            this.f4234a = hashSet;
            hashSet.add(Object.class.getName());
            hashSet.add(Closeable.class.getName());
            hashSet.add(Serializable.class.getName());
            hashSet.add(AutoCloseable.class.getName());
            hashSet.add(Cloneable.class.getName());
            hashSet.add("java.util.logging.Handler");
            hashSet.add("javax.naming.Referenceable");
            hashSet.add("javax.sql.DataSource");
        }
    }

    @Override // com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator
    public final PolymorphicTypeValidator.Validity a(JavaType javaType) {
        return a.f4233b.f4234a.contains(javaType.f3690a.getName()) ? PolymorphicTypeValidator.Validity.f4239b : PolymorphicTypeValidator.Validity.f4240c;
    }

    @Override // com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator
    public final PolymorphicTypeValidator.Validity b() {
        return PolymorphicTypeValidator.Validity.f4240c;
    }
}
