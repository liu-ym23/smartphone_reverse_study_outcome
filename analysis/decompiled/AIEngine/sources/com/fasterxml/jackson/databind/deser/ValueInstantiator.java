package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.deser.std.JsonLocationInstantiator;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import w2.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class ValueInstantiator {
    public AnnotatedWithParams A() {
        return null;
    }

    public JavaType B() {
        return null;
    }

    public SettableBeanProperty[] C(DeserializationConfig deserializationConfig) {
        return null;
    }

    public Class<?> D() {
        return Object.class;
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        return false;
    }

    public boolean g() {
        return this instanceof JsonLocationInstantiator;
    }

    public boolean h() {
        return false;
    }

    public boolean i() {
        return false;
    }

    public boolean j() {
        return z() != null;
    }

    public boolean k() {
        return false;
    }

    public boolean l() {
        return j() || k() || i() || g() || h() || e() || f() || d() || c();
    }

    public Object m(DeserializationContext deserializationContext, BigDecimal bigDecimal) throws MismatchedInputException {
        deserializationContext.x(D(), this, "no BigDecimal/double/Double-argument constructor/factory method to deserialize from Number value (%s)", bigDecimal);
        throw null;
    }

    public Object n(DeserializationContext deserializationContext, BigInteger bigInteger) throws MismatchedInputException {
        deserializationContext.x(D(), this, "no BigInteger-argument constructor/factory method to deserialize from Number value (%s)", bigInteger);
        throw null;
    }

    public Object o(DeserializationContext deserializationContext, boolean z) throws MismatchedInputException {
        deserializationContext.x(D(), this, "no boolean/Boolean-argument constructor/factory method to deserialize from boolean value (%s)", Boolean.valueOf(z));
        throw null;
    }

    public Object p(DeserializationContext deserializationContext, double d8) throws MismatchedInputException {
        deserializationContext.x(D(), this, "no double/Double-argument constructor/factory method to deserialize from Number value (%s)", Double.valueOf(d8));
        throw null;
    }

    public Object q(DeserializationContext deserializationContext, int i10) throws MismatchedInputException {
        deserializationContext.x(D(), this, "no int/Int-argument constructor/factory method to deserialize from Number value (%s)", Integer.valueOf(i10));
        throw null;
    }

    public Object r(DeserializationContext deserializationContext, long j10) throws MismatchedInputException {
        deserializationContext.x(D(), this, "no long/Long-argument constructor/factory method to deserialize from Number value (%s)", Long.valueOf(j10));
        throw null;
    }

    public Object s(DeserializationContext deserializationContext, Object[] objArr) throws MismatchedInputException {
        deserializationContext.x(D(), this, "no creator with arguments specified", new Object[0]);
        throw null;
    }

    public Object t(DeserializationContext deserializationContext, String str) throws MismatchedInputException {
        Class<?> clsD = D();
        b bVar = deserializationContext.h;
        deserializationContext.x(clsD, this, "no String-argument constructor/factory method to deserialize from String value ('%s')", str);
        throw null;
    }

    public Object u(DeserializationContext deserializationContext, Object obj) throws MismatchedInputException {
        deserializationContext.x(D(), this, "no array delegate creator specified", new Object[0]);
        throw null;
    }

    public Object v(DeserializationContext deserializationContext) throws MismatchedInputException {
        deserializationContext.x(D(), this, "no default no-arguments constructor found", new Object[0]);
        throw null;
    }

    public Object w(DeserializationContext deserializationContext, Object obj) throws MismatchedInputException {
        deserializationContext.x(D(), this, "no delegate creator specified", new Object[0]);
        throw null;
    }

    public AnnotatedWithParams x() {
        return null;
    }

    public JavaType y() {
        return null;
    }

    public AnnotatedWithParams z() {
        return null;
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Base extends ValueInstantiator implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Class<?> f3901a;

        public Base(Class<?> cls) {
            this.f3901a = cls;
        }

        @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
        public final Class<?> D() {
            return this.f3901a;
        }

        public Base(JavaType javaType) {
            this.f3901a = javaType.f3690a;
        }
    }
}
