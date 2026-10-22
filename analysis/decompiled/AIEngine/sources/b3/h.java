package b3;

import androidx.appcompat.widget.l;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.cfg.ContextAttributes;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.fasterxml.jackson.databind.exc.InvalidTypeIdException;
import com.fasterxml.jackson.databind.ser.BasicSerializerFactory;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;
import com.fasterxml.jackson.databind.ser.impl.FailingSerializer;
import com.fasterxml.jackson.databind.ser.impl.UnknownSerializer;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;
import com.fasterxml.jackson.databind.ser.std.StdDelegatingSerializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import o3.b;
import q3.r;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class h extends b {

    /* renamed from: n, reason: collision with root package name */
    public static final FailingSerializer f3042n = new FailingSerializer();

    /* renamed from: o, reason: collision with root package name */
    public static final UnknownSerializer f3043o = new UnknownSerializer();

    /* renamed from: a, reason: collision with root package name */
    public final SerializationConfig f3044a;

    /* renamed from: b, reason: collision with root package name */
    public final n3.f f3045b;

    /* renamed from: c, reason: collision with root package name */
    public final l f3046c;

    /* renamed from: d, reason: collision with root package name */
    public transient ContextAttributes f3047d;

    /* renamed from: e, reason: collision with root package name */
    public final f<Object> f3048e;
    public final f<Object> h;

    /* renamed from: j, reason: collision with root package name */
    public final f<Object> f3049j;

    /* renamed from: k, reason: collision with root package name */
    public final o3.b f3050k;

    /* renamed from: l, reason: collision with root package name */
    public DateFormat f3051l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f3052m;

    public h() {
        this.f3048e = f3043o;
        this.h = NullSerializer.f4389c;
        this.f3049j = f3042n;
        this.f3044a = null;
        this.f3045b = null;
        this.f3046c = new l(4);
        this.f3050k = null;
        this.f3047d = null;
        this.f3052m = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final f<?> A(f<?> fVar, BeanProperty beanProperty) {
        return (fVar == 0 || !(fVar instanceof n3.c)) ? fVar : ((n3.c) fVar).a(this, beanProperty);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final f<?> B(f<?> fVar, BeanProperty beanProperty) {
        return (fVar == 0 || !(fVar instanceof n3.c)) ? fVar : ((n3.c) fVar).a(this, beanProperty);
    }

    public abstract Object C(Class cls);

    public abstract boolean D(Object obj);

    public final void E(i3.d dVar, i3.e eVar, String str, Object... objArr) throws InvalidDefinitionException {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        StringBuilder sbS = ai.onnxruntime.a.s("Invalid definition for property ", b.b(eVar.getName()), " (of type ", com.fasterxml.jackson.databind.util.a.y(dVar.f3041a.f3690a), "): ");
        sbS.append(str);
        throw new InvalidDefinitionException(((DefaultSerializerProvider) this).r, sbS.toString());
    }

    public final void F(a aVar, String str, Object... objArr) throws InvalidDefinitionException {
        String strY = com.fasterxml.jackson.databind.util.a.y(aVar.f3041a.f3690a);
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        throw new InvalidDefinitionException(((DefaultSerializerProvider) this).r, ai.onnxruntime.a.l("Invalid type definition for type ", strY, ": ", str));
    }

    public abstract f<Object> G(i3.a aVar, Object obj);

    @Override // b3.b
    public final MapperConfig d() {
        return this.f3044a;
    }

    @Override // b3.b
    public final TypeFactory e() {
        return this.f3044a.f3828b.f3789a;
    }

    @Override // b3.b
    public final InvalidTypeIdException f(JavaType javaType, String str, String str2) {
        return new InvalidTypeIdException(null, b.a("Could not resolve type id '" + str + "' as a subtype of " + com.fasterxml.jackson.databind.util.a.r(javaType), str2), 0);
    }

    @Override // b3.b
    public final Object j(String str) throws InvalidDefinitionException {
        throw new InvalidDefinitionException(((DefaultSerializerProvider) this).r, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final f<Object> k(JavaType javaType) throws JsonMappingException {
        try {
            f<Object> fVarM = m(javaType);
            if (fVarM == 0) {
                return fVarM;
            }
            l lVar = this.f3046c;
            synchronized (lVar) {
                try {
                    if (((HashMap) lVar.f887g).put(new r(javaType, false), fVarM) == null) {
                        ((AtomicReference) lVar.h).set(null);
                    }
                    if (fVarM instanceof n3.e) {
                        ((n3.e) fVarM).b(this);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return fVarM;
        } catch (IllegalArgumentException e10) {
            throw new JsonMappingException(((DefaultSerializerProvider) this).r, com.fasterxml.jackson.databind.util.a.i(e10), e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final f<Object> l(Class<?> cls) throws JsonMappingException {
        JavaType javaTypeC = this.f3044a.c(cls);
        try {
            f<Object> fVarM = m(javaTypeC);
            if (fVarM == 0) {
                return fVarM;
            }
            l lVar = this.f3046c;
            synchronized (lVar) {
                try {
                    Object objPut = ((HashMap) lVar.f887g).put(new r(cls, false), fVarM);
                    Object objPut2 = ((HashMap) lVar.f887g).put(new r(javaTypeC, false), fVarM);
                    if (objPut == null || objPut2 == null) {
                        ((AtomicReference) lVar.h).set(null);
                    }
                    if (fVarM instanceof n3.e) {
                        ((n3.e) fVarM).b(this);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return fVarM;
        } catch (IllegalArgumentException e10) {
            throw new JsonMappingException(((DefaultSerializerProvider) this).r, com.fasterxml.jackson.databind.util.a.i(e10), e10);
        }
    }

    public final f<Object> m(JavaType javaType) throws InvalidDefinitionException {
        JavaType javaTypeP0;
        BeanSerializerFactory beanSerializerFactory = (BeanSerializerFactory) this.f3045b;
        beanSerializerFactory.getClass();
        SerializationConfig serializationConfig = this.f3044a;
        i3.d dVarP = serializationConfig.p(javaType);
        com.fasterxml.jackson.databind.introspect.a aVar = dVarP.f9499e;
        f<Object> fVarE = BasicSerializerFactory.e(this, aVar);
        if (fVarE != null) {
            return fVarE;
        }
        AnnotationIntrospector annotationIntrospectorD = serializationConfig.d();
        boolean z = false;
        if (annotationIntrospectorD == null) {
            javaTypeP0 = javaType;
        } else {
            try {
                javaTypeP0 = annotationIntrospectorD.p0(serializationConfig, aVar, javaType);
            } catch (JsonMappingException e10) {
                F(dVarP, e10.getMessage(), new Object[0]);
                throw null;
            }
        }
        if (javaTypeP0 != javaType) {
            if (!javaTypeP0.u(javaType.f3690a)) {
                dVarP = serializationConfig.p(javaTypeP0);
            }
            z = true;
        }
        AnnotationIntrospector annotationIntrospector = dVarP.f9498d;
        q3.g<Object, Object> gVarC = annotationIntrospector != null ? dVarP.c(annotationIntrospector.Q(dVarP.f9499e)) : null;
        if (gVarC == null) {
            return beanSerializerFactory.h(this, javaTypeP0, dVarP, z);
        }
        e();
        JavaType javaTypeB = gVarC.b();
        if (!javaTypeB.u(javaTypeP0.f3690a)) {
            dVarP = serializationConfig.p(javaTypeB);
            fVarE = BasicSerializerFactory.e(this, dVarP.f9499e);
        }
        if (fVarE == null && !javaTypeB.A()) {
            fVarE = beanSerializerFactory.h(this, javaTypeB, dVarP, true);
        }
        return new StdDelegatingSerializer(gVarC, javaTypeB, fVarE);
    }

    public final DateFormat n() {
        DateFormat dateFormat = this.f3051l;
        if (dateFormat != null) {
            return dateFormat;
        }
        DateFormat dateFormat2 = (DateFormat) this.f3044a.f3828b.h.clone();
        this.f3051l = dateFormat2;
        return dateFormat2;
    }

    public final JavaType o(JavaType javaType, Class<?> cls) {
        return javaType.u(cls) ? javaType : this.f3044a.f3828b.f3789a.i(javaType, cls, true);
    }

    public final void p(JsonGenerator jsonGenerator) {
        if (this.f3052m) {
            jsonGenerator.J0();
        } else {
            this.h.f(null, jsonGenerator, this);
        }
    }

    public final f<Object> q(JavaType javaType, BeanProperty beanProperty) {
        f fVarA = this.f3050k.a(javaType);
        return (fVarA == null && (fVarA = this.f3046c.q(javaType)) == null && (fVarA = k(javaType)) == null) ? z(javaType.f3690a) : B(fVarA, beanProperty);
    }

    public final f<Object> r(Class<?> cls, BeanProperty beanProperty) {
        f fVarB = this.f3050k.b(cls);
        if (fVarB == null) {
            l lVar = this.f3046c;
            f fVarR = lVar.r(cls);
            if (fVarR == null) {
                fVarB = lVar.q(this.f3044a.c(cls));
                if (fVarB == null && (fVarB = l(cls)) == null) {
                    return z(cls);
                }
            } else {
                fVarB = fVarR;
            }
        }
        return B(fVarB, beanProperty);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final f<Object> s(JavaType javaType, BeanProperty beanProperty) {
        f fVarA = this.f3045b.a(this, javaType);
        if (fVarA instanceof n3.e) {
            ((n3.e) fVarA).b(this);
        }
        return B(fVarA, beanProperty);
    }

    public abstract o3.d t(Object obj, ObjectIdGenerator<?> objectIdGenerator);

    public final f<Object> u(JavaType javaType, BeanProperty beanProperty) {
        f fVarA = this.f3050k.a(javaType);
        return (fVarA == null && (fVarA = this.f3046c.q(javaType)) == null && (fVarA = k(javaType)) == null) ? z(javaType.f3690a) : A(fVarA, beanProperty);
    }

    public final f<Object> v(Class<?> cls, BeanProperty beanProperty) {
        f fVarB = this.f3050k.b(cls);
        if (fVarB == null) {
            l lVar = this.f3046c;
            f fVarR = lVar.r(cls);
            if (fVarR == null) {
                fVarB = lVar.q(this.f3044a.c(cls));
                if (fVarB == null && (fVarB = l(cls)) == null) {
                    return z(cls);
                }
            } else {
                fVarB = fVarR;
            }
        }
        return A(fVarB, beanProperty);
    }

    public final f w(Class cls) {
        f<Object> fVar;
        f fVar2;
        o3.b bVar = this.f3050k;
        b.a aVar = bVar.f10742a[bVar.f10743b & (cls.getName().hashCode() + 1)];
        if (aVar == null) {
            fVar = null;
        } else if (aVar.f10746c != cls || !aVar.f10748e) {
            while (true) {
                aVar = aVar.f10745b;
                if (aVar == null) {
                    break;
                }
                if (aVar.f10746c == cls && aVar.f10748e) {
                    fVar = aVar.f10744a;
                    break;
                }
            }
        } else {
            fVar = aVar.f10744a;
        }
        if (fVar != null) {
            return fVar;
        }
        l lVar = this.f3046c;
        synchronized (lVar) {
            fVar2 = (f) ((HashMap) lVar.f887g).get(new r((Class<?>) cls, true));
        }
        if (fVar2 != null) {
            return fVar2;
        }
        f<Object> fVarY = y(cls, null);
        n3.f fVar3 = this.f3045b;
        SerializationConfig serializationConfig = this.f3044a;
        k3.e eVarB = fVar3.b(serializationConfig, serializationConfig.c(cls));
        if (eVarB != null) {
            fVarY = new o3.c(eVarB.a(null), fVarY);
        }
        l lVar2 = this.f3046c;
        synchronized (lVar2) {
            try {
                if (((HashMap) lVar2.f887g).put(new r((Class<?>) cls, true), fVarY) == null) {
                    ((AtomicReference) lVar2.h).set(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVarY;
    }

    public final f<Object> x(JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        if (javaType == null) {
            throw new JsonMappingException(((DefaultSerializerProvider) this).r, "Null passed for `valueType` of `findValueSerializer()`", (Throwable) null);
        }
        f fVarA = this.f3050k.a(javaType);
        return (fVarA == null && (fVarA = this.f3046c.q(javaType)) == null && (fVarA = k(javaType)) == null) ? z(javaType.f3690a) : B(fVarA, beanProperty);
    }

    public final f<Object> y(Class<?> cls, BeanProperty beanProperty) {
        f fVarB = this.f3050k.b(cls);
        if (fVarB == null) {
            l lVar = this.f3046c;
            f fVarR = lVar.r(cls);
            if (fVarR == null) {
                fVarB = lVar.q(this.f3044a.c(cls));
                if (fVarB == null && (fVarB = l(cls)) == null) {
                    return z(cls);
                }
            } else {
                fVarB = fVarR;
            }
        }
        return B(fVarB, beanProperty);
    }

    public final f<Object> z(Class<?> cls) {
        return cls == Object.class ? this.f3048e : new UnknownSerializer(cls, 0);
    }

    public h(h hVar, SerializationConfig serializationConfig, n3.f fVar) {
        this.f3048e = f3043o;
        this.h = NullSerializer.f4389c;
        FailingSerializer failingSerializer = f3042n;
        this.f3049j = failingSerializer;
        this.f3045b = fVar;
        this.f3044a = serializationConfig;
        l lVar = hVar.f3046c;
        this.f3046c = lVar;
        this.f3048e = hVar.f3048e;
        f<Object> fVar2 = hVar.h;
        this.h = fVar2;
        this.f3049j = hVar.f3049j;
        this.f3052m = fVar2 == failingSerializer;
        serializationConfig.getClass();
        this.f3047d = serializationConfig.f3834e;
        o3.b bVar = (o3.b) ((AtomicReference) lVar.h).get();
        if (bVar == null) {
            synchronized (lVar) {
                bVar = (o3.b) ((AtomicReference) lVar.h).get();
                if (bVar == null) {
                    o3.b bVar2 = new o3.b((HashMap) lVar.f887g);
                    ((AtomicReference) lVar.h).set(bVar2);
                    bVar = bVar2;
                }
            }
        }
        this.f3050k = bVar;
    }
}
