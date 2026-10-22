package R4;

import C4.F;
import C4.G;
import C4.InterfaceC0275e;
import R4.y;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
abstract class k<ResponseT, ReturnT> extends v<ReturnT> {

    /* renamed from: a, reason: collision with root package name */
    private final s f5025a;

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC0275e.a f5026b;

    /* renamed from: c, reason: collision with root package name */
    private final f<G, ResponseT> f5027c;

    static final class a<ResponseT, ReturnT> extends k<ResponseT, ReturnT> {

        /* renamed from: d, reason: collision with root package name */
        private final R4.c<ResponseT, ReturnT> f5028d;

        a(s sVar, InterfaceC0275e.a aVar, f<G, ResponseT> fVar, R4.c<ResponseT, ReturnT> cVar) {
            super(sVar, aVar, fVar);
            this.f5028d = cVar;
        }

        @Override // R4.k
        protected ReturnT c(R4.b<ResponseT> bVar, Object[] objArr) {
            return this.f5028d.a(bVar);
        }
    }

    static final class b<ResponseT> extends k<ResponseT, Object> {

        /* renamed from: d, reason: collision with root package name */
        private final R4.c<ResponseT, R4.b<ResponseT>> f5029d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f5030e;

        b(s sVar, InterfaceC0275e.a aVar, f<G, ResponseT> fVar, R4.c<ResponseT, R4.b<ResponseT>> cVar, boolean z5) {
            super(sVar, aVar, fVar);
            this.f5029d = cVar;
            this.f5030e = z5;
        }

        @Override // R4.k
        protected Object c(R4.b<ResponseT> bVar, Object[] objArr) {
            R4.b<ResponseT> bVarA = this.f5029d.a(bVar);
            Z3.e eVar = (Z3.e) objArr[objArr.length - 1];
            try {
                return this.f5030e ? m.b(bVarA, eVar) : m.a(bVarA, eVar);
            } catch (Exception e6) {
                return m.d(e6, eVar);
            }
        }
    }

    static final class c<ResponseT> extends k<ResponseT, Object> {

        /* renamed from: d, reason: collision with root package name */
        private final R4.c<ResponseT, R4.b<ResponseT>> f5031d;

        c(s sVar, InterfaceC0275e.a aVar, f<G, ResponseT> fVar, R4.c<ResponseT, R4.b<ResponseT>> cVar) {
            super(sVar, aVar, fVar);
            this.f5031d = cVar;
        }

        @Override // R4.k
        protected Object c(R4.b<ResponseT> bVar, Object[] objArr) {
            R4.b<ResponseT> bVarA = this.f5031d.a(bVar);
            Z3.e eVar = (Z3.e) objArr[objArr.length - 1];
            try {
                return m.c(bVarA, eVar);
            } catch (Exception e6) {
                return m.d(e6, eVar);
            }
        }
    }

    k(s sVar, InterfaceC0275e.a aVar, f<G, ResponseT> fVar) {
        this.f5025a = sVar;
        this.f5026b = aVar;
        this.f5027c = fVar;
    }

    private static <ResponseT, ReturnT> R4.c<ResponseT, ReturnT> d(u uVar, Method method, Type type, Annotation[] annotationArr) {
        try {
            return (R4.c<ResponseT, ReturnT>) uVar.b(type, annotationArr);
        } catch (RuntimeException e6) {
            throw y.n(method, e6, "Unable to create call adapter for %s", type);
        }
    }

    private static <ResponseT> f<G, ResponseT> e(u uVar, Method method, Type type) {
        try {
            return uVar.i(type, method.getAnnotations());
        } catch (RuntimeException e6) {
            throw y.n(method, e6, "Unable to create converter for %s", type);
        }
    }

    static <ResponseT, ReturnT> k<ResponseT, ReturnT> f(u uVar, Method method, s sVar) {
        Type genericReturnType;
        boolean z5;
        boolean z6 = sVar.f5137k;
        Annotation[] annotations = method.getAnnotations();
        if (z6) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type typeF = y.f(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (y.h(typeF) == t.class && (typeF instanceof ParameterizedType)) {
                typeF = y.g(0, (ParameterizedType) typeF);
                z5 = true;
            } else {
                z5 = false;
            }
            genericReturnType = new y.b(null, R4.b.class, typeF);
            annotations = x.a(annotations);
        } else {
            genericReturnType = method.getGenericReturnType();
            z5 = false;
        }
        R4.c cVarD = d(uVar, method, genericReturnType, annotations);
        Type typeB = cVarD.b();
        if (typeB == F.class) {
            throw y.m(method, "'" + y.h(typeB).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        }
        if (typeB == t.class) {
            throw y.m(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        }
        if (sVar.f5129c.equals("HEAD") && !Void.class.equals(typeB)) {
            throw y.m(method, "HEAD method must use Void as response type.", new Object[0]);
        }
        f fVarE = e(uVar, method, typeB);
        InterfaceC0275e.a aVar = uVar.f5167b;
        return !z6 ? new a(sVar, aVar, fVarE, cVarD) : z5 ? new c(sVar, aVar, fVarE, cVarD) : new b(sVar, aVar, fVarE, cVarD, false);
    }

    @Override // R4.v
    @Nullable
    final ReturnT a(Object[] objArr) {
        return c(new n(this.f5025a, objArr, this.f5026b, this.f5027c), objArr);
    }

    @Nullable
    protected abstract ReturnT c(R4.b<ResponseT> bVar, Object[] objArr);
}
