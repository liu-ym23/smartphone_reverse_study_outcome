package K9;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: K9.b, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0921b {

    /* renamed from: a, reason: collision with root package name */
    public static final C0921b f4159a = new C0921b();

    /* renamed from: b, reason: collision with root package name */
    public static a f4160b;

    /* renamed from: K9.b$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Method f4161a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f4162b;

        /* renamed from: c, reason: collision with root package name */
        public final Method f4163c;

        /* renamed from: d, reason: collision with root package name */
        public final Method f4164d;

        public a(Method method, Method method2, Method method3, Method method4) {
            this.f4161a = method;
            this.f4162b = method2;
            this.f4163c = method3;
            this.f4164d = method4;
        }

        public final Method a() {
            return this.f4162b;
        }

        public final Method b() {
            return this.f4164d;
        }

        public final Method c() {
            return this.f4163c;
        }

        public final Method d() {
            return this.f4161a;
        }
    }

    public final a a() {
        try {
            return new a(Class.class.getMethod("isSealed", null), Class.class.getMethod("getPermittedSubclasses", null), Class.class.getMethod("isRecord", null), Class.class.getMethod("getRecordComponents", null));
        } catch (NoSuchMethodException unused) {
            return new a(null, null, null, null);
        }
    }

    public final a b() {
        a aVar = f4160b;
        if (aVar != null) {
            return aVar;
        }
        a aVarA = a();
        f4160b = aVarA;
        return aVarA;
    }

    public final Class<?>[] c(Class<?> clazz) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        kotlin.jvm.internal.p.i(clazz, "clazz");
        Method methodA = b().a();
        if (methodA == null) {
            return null;
        }
        Object objInvoke = methodA.invoke(clazz, null);
        kotlin.jvm.internal.p.g(objInvoke, "null cannot be cast to non-null type kotlin.Array<java.lang.Class<*>>");
        return (Class[]) objInvoke;
    }

    public final Object[] d(Class<?> clazz) {
        kotlin.jvm.internal.p.i(clazz, "clazz");
        Method methodB = b().b();
        if (methodB == null) {
            return null;
        }
        return (Object[]) methodB.invoke(clazz, null);
    }

    public final Boolean e(Class<?> clazz) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        kotlin.jvm.internal.p.i(clazz, "clazz");
        Method methodC = b().c();
        if (methodC == null) {
            return null;
        }
        Object objInvoke = methodC.invoke(clazz, null);
        kotlin.jvm.internal.p.g(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) objInvoke;
    }

    public final Boolean f(Class<?> clazz) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        kotlin.jvm.internal.p.i(clazz, "clazz");
        Method methodD = b().d();
        if (methodD == null) {
            return null;
        }
        Object objInvoke = methodD.invoke(clazz, null);
        kotlin.jvm.internal.p.g(objInvoke, "null cannot be cast to non-null type kotlin.Boolean");
        return (Boolean) objInvoke;
    }
}
