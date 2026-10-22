package com.fasterxml.jackson.databind.deser.std;

import c3.a;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import com.fasterxml.jackson.databind.introspect.AnnotatedWithParams;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@a
/* loaded from: classes.dex */
public class StdValueInstantiator extends ValueInstantiator implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final String f4068a;

    /* renamed from: b, reason: collision with root package name */
    public final Class<?> f4069b;

    /* renamed from: c, reason: collision with root package name */
    public AnnotatedWithParams f4070c;

    /* renamed from: d, reason: collision with root package name */
    public AnnotatedWithParams f4071d;

    /* renamed from: e, reason: collision with root package name */
    public SettableBeanProperty[] f4072e;
    public JavaType h;

    /* renamed from: j, reason: collision with root package name */
    public AnnotatedWithParams f4073j;

    /* renamed from: k, reason: collision with root package name */
    public SettableBeanProperty[] f4074k;

    /* renamed from: l, reason: collision with root package name */
    public JavaType f4075l;

    /* renamed from: m, reason: collision with root package name */
    public AnnotatedWithParams f4076m;

    /* renamed from: n, reason: collision with root package name */
    public SettableBeanProperty[] f4077n;

    /* renamed from: o, reason: collision with root package name */
    public AnnotatedWithParams f4078o;

    /* renamed from: p, reason: collision with root package name */
    public AnnotatedWithParams f4079p;

    /* renamed from: q, reason: collision with root package name */
    public AnnotatedWithParams f4080q;
    public AnnotatedWithParams r;

    /* renamed from: s, reason: collision with root package name */
    public AnnotatedWithParams f4081s;

    /* renamed from: t, reason: collision with root package name */
    public AnnotatedWithParams f4082t;

    /* renamed from: u, reason: collision with root package name */
    public AnnotatedWithParams f4083u;

    public StdValueInstantiator(JavaType javaType) {
        this.f4068a = javaType == null ? "UNKNOWN TYPE" : javaType.toString();
        this.f4069b = javaType == null ? Object.class : javaType.f3690a;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final AnnotatedWithParams A() {
        return this.f4073j;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final JavaType B() {
        return this.h;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final SettableBeanProperty[] C(DeserializationConfig deserializationConfig) {
        return this.f4072e;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final Class<?> D() {
        return this.f4069b;
    }

    public final Object E(AnnotatedWithParams annotatedWithParams, SettableBeanProperty[] settableBeanPropertyArr, DeserializationContext deserializationContext, Object obj) throws JsonMappingException {
        if (annotatedWithParams == null) {
            throw new IllegalStateException("No delegate constructor for " + this.f4068a);
        }
        try {
            if (settableBeanPropertyArr == null) {
                return annotatedWithParams.q(obj);
            }
            int length = settableBeanPropertyArr.length;
            Object[] objArr = new Object[length];
            for (int i10 = 0; i10 < length; i10++) {
                SettableBeanProperty settableBeanProperty = settableBeanPropertyArr[i10];
                if (settableBeanProperty != null) {
                    deserializationContext.p(settableBeanProperty.o());
                    throw null;
                }
                objArr[i10] = obj;
            }
            return annotatedWithParams.p(objArr);
        } catch (Throwable th) {
            throw F(deserializationContext, th);
        }
    }

    public final JsonMappingException F(DeserializationContext deserializationContext, Throwable th) {
        Throwable cause;
        if (((th instanceof ExceptionInInitializerError) || (th instanceof InvocationTargetException)) && (cause = th.getCause()) != null) {
            th = cause;
        }
        return th instanceof JsonMappingException ? (JsonMappingException) th : deserializationContext.H(this.f4069b, th);
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final boolean a() {
        return this.f4082t != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final boolean b() {
        return this.r != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final boolean c() {
        return this.f4083u != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final boolean d() {
        return this.f4081s != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final boolean e() {
        return this.f4079p != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final boolean f() {
        return this.f4080q != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final boolean g() {
        return this.f4071d != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final boolean h() {
        return this.f4078o != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final boolean i() {
        return this.f4075l != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final boolean j() {
        return this.f4070c != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final boolean k() {
        return this.h != null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final boolean l() {
        return j() || k() || i() || g() || h() || e() || f() || d() || c();
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final Object m(DeserializationContext deserializationContext, BigDecimal bigDecimal) throws ValueInstantiationException, MismatchedInputException {
        AnnotatedWithParams annotatedWithParams = this.f4082t;
        if (annotatedWithParams != null) {
            try {
                return annotatedWithParams.q(bigDecimal);
            } catch (Throwable th) {
                deserializationContext.w(this.f4082t.h(), this.F(deserializationContext, th));
                throw null;
            }
        }
        if (this.f4081s != null) {
            double dDoubleValue = bigDecimal.doubleValue();
            Double dValueOf = Double.isInfinite(dDoubleValue) ? null : Double.valueOf(dDoubleValue);
            if (dValueOf != null) {
                try {
                    return this.f4081s.q(dValueOf);
                } catch (Throwable th2) {
                    deserializationContext.w(this.f4081s.h(), this.F(deserializationContext, th2));
                    throw null;
                }
            }
        }
        super.m(deserializationContext, bigDecimal);
        throw null;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final Object n(DeserializationContext deserializationContext, BigInteger bigInteger) throws ValueInstantiationException, MismatchedInputException {
        AnnotatedWithParams annotatedWithParams = this.r;
        if (annotatedWithParams == null) {
            super.n(deserializationContext, bigInteger);
            throw null;
        }
        try {
            return annotatedWithParams.q(bigInteger);
        } catch (Throwable th) {
            deserializationContext.w(this.r.h(), this.F(deserializationContext, th));
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final Object o(DeserializationContext deserializationContext, boolean z) throws ValueInstantiationException, MismatchedInputException {
        if (this.f4083u == null) {
            super.o(deserializationContext, z);
            throw null;
        }
        try {
            return this.f4083u.q(Boolean.valueOf(z));
        } catch (Throwable th) {
            deserializationContext.w(this.f4083u.h(), this.F(deserializationContext, th));
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final Object p(DeserializationContext deserializationContext, double d8) throws ValueInstantiationException, MismatchedInputException {
        if (this.f4081s != null) {
            try {
                return this.f4081s.q(Double.valueOf(d8));
            } catch (Throwable th) {
                deserializationContext.w(this.f4081s.h(), this.F(deserializationContext, th));
                throw null;
            }
        }
        if (this.f4082t == null) {
            super.p(deserializationContext, d8);
            throw null;
        }
        try {
            return this.f4082t.q(BigDecimal.valueOf(d8));
        } catch (Throwable th2) {
            deserializationContext.w(this.f4082t.h(), this.F(deserializationContext, th2));
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final Object q(DeserializationContext deserializationContext, int i10) throws ValueInstantiationException, MismatchedInputException {
        if (this.f4079p != null) {
            try {
                return this.f4079p.q(Integer.valueOf(i10));
            } catch (Throwable th) {
                deserializationContext.w(this.f4079p.h(), this.F(deserializationContext, th));
                throw null;
            }
        }
        if (this.f4080q != null) {
            try {
                return this.f4080q.q(Long.valueOf(i10));
            } catch (Throwable th2) {
                deserializationContext.w(this.f4080q.h(), this.F(deserializationContext, th2));
                throw null;
            }
        }
        if (this.r == null) {
            super.q(deserializationContext, i10);
            throw null;
        }
        try {
            return this.r.q(BigInteger.valueOf(i10));
        } catch (Throwable th3) {
            deserializationContext.w(this.r.h(), this.F(deserializationContext, th3));
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final Object r(DeserializationContext deserializationContext, long j10) throws ValueInstantiationException, MismatchedInputException {
        if (this.f4080q != null) {
            try {
                return this.f4080q.q(Long.valueOf(j10));
            } catch (Throwable th) {
                deserializationContext.w(this.f4080q.h(), this.F(deserializationContext, th));
                throw null;
            }
        }
        if (this.r == null) {
            super.r(deserializationContext, j10);
            throw null;
        }
        try {
            return this.r.q(BigInteger.valueOf(j10));
        } catch (Throwable th2) {
            deserializationContext.w(this.r.h(), this.F(deserializationContext, th2));
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final Object s(DeserializationContext deserializationContext, Object[] objArr) throws ValueInstantiationException, MismatchedInputException {
        AnnotatedWithParams annotatedWithParams = this.f4071d;
        if (annotatedWithParams == null) {
            super.s(deserializationContext, objArr);
            throw null;
        }
        try {
            return annotatedWithParams.p(objArr);
        } catch (Exception e10) {
            deserializationContext.w(this.f4069b, this.F(deserializationContext, e10));
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final Object t(DeserializationContext deserializationContext, String str) throws ValueInstantiationException, MismatchedInputException {
        AnnotatedWithParams annotatedWithParams = this.f4078o;
        if (annotatedWithParams == null) {
            super.t(deserializationContext, str);
            throw null;
        }
        try {
            return annotatedWithParams.q(str);
        } catch (Throwable th) {
            deserializationContext.w(this.f4078o.h(), this.F(deserializationContext, th));
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final Object u(DeserializationContext deserializationContext, Object obj) {
        AnnotatedWithParams annotatedWithParams = this.f4076m;
        return (annotatedWithParams != null || this.f4073j == null) ? E(annotatedWithParams, this.f4077n, deserializationContext, obj) : w(deserializationContext, obj);
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final Object v(DeserializationContext deserializationContext) throws ValueInstantiationException, MismatchedInputException {
        AnnotatedWithParams annotatedWithParams = this.f4070c;
        if (annotatedWithParams == null) {
            super.v(deserializationContext);
            throw null;
        }
        try {
            return annotatedWithParams.o();
        } catch (Exception e10) {
            deserializationContext.w(this.f4069b, this.F(deserializationContext, e10));
            throw null;
        }
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final Object w(DeserializationContext deserializationContext, Object obj) {
        AnnotatedWithParams annotatedWithParams;
        AnnotatedWithParams annotatedWithParams2 = this.f4073j;
        return (annotatedWithParams2 != null || (annotatedWithParams = this.f4076m) == null) ? E(annotatedWithParams2, this.f4074k, deserializationContext, obj) : E(annotatedWithParams, this.f4077n, deserializationContext, obj);
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final AnnotatedWithParams x() {
        return this.f4076m;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final JavaType y() {
        return this.f4075l;
    }

    @Override // com.fasterxml.jackson.databind.deser.ValueInstantiator
    public final AnnotatedWithParams z() {
        return this.f4070c;
    }
}
