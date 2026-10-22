package yc;

import e9.InterfaceC4014c;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import retrofit2.KotlinExtensions;
import tb.AbstractC5531D;
import tb.C5530C;
import tb.InterfaceC5538e;
import yc.A;

/* loaded from: classes5.dex */
public abstract class m<ResponseT, ReturnT> extends x<ReturnT> {

    /* renamed from: a, reason: collision with root package name */
    public final u f44337a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC5538e.a f44338b;

    /* renamed from: c, reason: collision with root package name */
    public final h<AbstractC5531D, ResponseT> f44339c;

    public static final class a<ResponseT, ReturnT> extends m<ResponseT, ReturnT> {

        /* renamed from: d, reason: collision with root package name */
        public final e<ResponseT, ReturnT> f44340d;

        public a(u uVar, InterfaceC5538e.a aVar, h<AbstractC5531D, ResponseT> hVar, e<ResponseT, ReturnT> eVar) {
            super(uVar, aVar, hVar);
            this.f44340d = eVar;
        }

        @Override // yc.m
        public ReturnT c(d<ResponseT> dVar, Object[] objArr) {
            return this.f44340d.b(dVar);
        }
    }

    public static final class b<ResponseT> extends m<ResponseT, Object> {

        /* renamed from: d, reason: collision with root package name */
        public final e<ResponseT, d<ResponseT>> f44341d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f44342e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f44343f;

        public b(u uVar, InterfaceC5538e.a aVar, h<AbstractC5531D, ResponseT> hVar, e<ResponseT, d<ResponseT>> eVar, boolean z10, boolean z11) {
            super(uVar, aVar, hVar);
            this.f44341d = eVar;
            this.f44342e = z10;
            this.f44343f = z11;
        }

        @Override // yc.m
        public Object c(d<ResponseT> dVar, Object[] objArr) {
            d<ResponseT> dVarB = this.f44341d.b(dVar);
            InterfaceC4014c interfaceC4014c = (InterfaceC4014c) objArr[objArr.length - 1];
            try {
                return this.f44343f ? KotlinExtensions.d(dVarB, interfaceC4014c) : this.f44342e ? KotlinExtensions.b(dVarB, interfaceC4014c) : KotlinExtensions.a(dVarB, interfaceC4014c);
            } catch (LinkageError | ThreadDeath | VirtualMachineError e10) {
                throw e10;
            } catch (Throwable th) {
                return KotlinExtensions.e(th, interfaceC4014c);
            }
        }
    }

    public static final class c<ResponseT> extends m<ResponseT, Object> {

        /* renamed from: d, reason: collision with root package name */
        public final e<ResponseT, d<ResponseT>> f44344d;

        public c(u uVar, InterfaceC5538e.a aVar, h<AbstractC5531D, ResponseT> hVar, e<ResponseT, d<ResponseT>> eVar) {
            super(uVar, aVar, hVar);
            this.f44344d = eVar;
        }

        @Override // yc.m
        public Object c(d<ResponseT> dVar, Object[] objArr) {
            d<ResponseT> dVarB = this.f44344d.b(dVar);
            InterfaceC4014c interfaceC4014c = (InterfaceC4014c) objArr[objArr.length - 1];
            try {
                return KotlinExtensions.c(dVarB, interfaceC4014c);
            } catch (Exception e10) {
                return KotlinExtensions.e(e10, interfaceC4014c);
            }
        }
    }

    public m(u uVar, InterfaceC5538e.a aVar, h<AbstractC5531D, ResponseT> hVar) {
        this.f44337a = uVar;
        this.f44338b = aVar;
        this.f44339c = hVar;
    }

    public static <ResponseT, ReturnT> e<ResponseT, ReturnT> d(w wVar, Method method, Type type, Annotation[] annotationArr) {
        try {
            return (e<ResponseT, ReturnT>) wVar.b(type, annotationArr);
        } catch (RuntimeException e10) {
            throw A.o(method, e10, "Unable to create call adapter for %s", type);
        }
    }

    public static <ResponseT> h<AbstractC5531D, ResponseT> e(w wVar, Method method, Type type) {
        try {
            return wVar.j(type, method.getAnnotations());
        } catch (RuntimeException e10) {
            throw A.o(method, e10, "Unable to create converter for %s", type);
        }
    }

    public static <ResponseT, ReturnT> m<ResponseT, ReturnT> f(w wVar, Method method, u uVar) {
        Type genericReturnType;
        boolean z10;
        boolean z11;
        boolean zM;
        boolean z12 = uVar.f44443l;
        Annotation[] annotations = method.getAnnotations();
        if (z12) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type typeF = A.f(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (A.h(typeF) == v.class && (typeF instanceof ParameterizedType)) {
                typeF = A.g(0, (ParameterizedType) typeF);
                zM = false;
                z10 = true;
            } else {
                if (A.h(typeF) == d.class) {
                    throw A.n(method, "Suspend functions should not return Call, as they already execute asynchronously.\nChange its return type to %s", A.g(0, (ParameterizedType) typeF));
                }
                zM = A.m(typeF);
                z10 = false;
            }
            genericReturnType = new A.b(null, d.class, typeF);
            annotations = z.a(annotations);
            z11 = zM;
        } else {
            genericReturnType = method.getGenericReturnType();
            z10 = false;
            z11 = false;
        }
        e eVarD = d(wVar, method, genericReturnType, annotations);
        Type typeA = eVarD.a();
        if (typeA == C5530C.class) {
            throw A.n(method, "'" + A.h(typeA).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        }
        if (typeA == v.class) {
            throw A.n(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        }
        if (uVar.f44435d.equals("HEAD") && !Void.class.equals(typeA) && !A.m(typeA)) {
            throw A.n(method, "HEAD method must use Void or Unit as response type.", new Object[0]);
        }
        h hVarE = e(wVar, method, typeA);
        InterfaceC5538e.a aVar = wVar.f44474b;
        return !z12 ? new a(uVar, aVar, hVarE, eVarD) : z10 ? new c(uVar, aVar, hVarE, eVarD) : new b(uVar, aVar, hVarE, eVarD, false, z11);
    }

    @Override // yc.x
    public final ReturnT a(Object obj, Object[] objArr) {
        return c(new o(this.f44337a, obj, objArr, this.f44338b, this.f44339c), objArr);
    }

    public abstract ReturnT c(d<ResponseT> dVar, Object[] objArr);
}
