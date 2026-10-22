package K9;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: K9.a, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0920a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0920a f4155a = new C0920a();

    /* renamed from: b, reason: collision with root package name */
    public static C0067a f4156b;

    /* renamed from: K9.a$a, reason: collision with other inner class name */
    public static final class C0067a {

        /* renamed from: a, reason: collision with root package name */
        public final Method f4157a;

        /* renamed from: b, reason: collision with root package name */
        public final Method f4158b;

        public C0067a(Method method, Method method2) {
            this.f4157a = method;
            this.f4158b = method2;
        }

        public final Method a() {
            return this.f4158b;
        }

        public final Method b() {
            return this.f4157a;
        }
    }

    public final C0067a a(Object obj) {
        Class<?> cls = obj.getClass();
        try {
            return new C0067a(cls.getMethod("getType", null), cls.getMethod("getAccessor", null));
        } catch (NoSuchMethodException unused) {
            return new C0067a(null, null);
        }
    }

    public final C0067a b(Object obj) {
        C0067a c0067a = f4156b;
        if (c0067a != null) {
            return c0067a;
        }
        C0067a c0067aA = a(obj);
        f4156b = c0067aA;
        return c0067aA;
    }

    public final Method c(Object recordComponent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        kotlin.jvm.internal.p.i(recordComponent, "recordComponent");
        Method methodA = b(recordComponent).a();
        if (methodA == null) {
            return null;
        }
        Object objInvoke = methodA.invoke(recordComponent, null);
        kotlin.jvm.internal.p.g(objInvoke, "null cannot be cast to non-null type java.lang.reflect.Method");
        return (Method) objInvoke;
    }

    public final Class<?> d(Object recordComponent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        kotlin.jvm.internal.p.i(recordComponent, "recordComponent");
        Method methodB = b(recordComponent).b();
        if (methodB == null) {
            return null;
        }
        Object objInvoke = methodB.invoke(recordComponent, null);
        kotlin.jvm.internal.p.g(objInvoke, "null cannot be cast to non-null type java.lang.Class<*>");
        return (Class) objInvoke;
    }
}
