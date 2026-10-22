package l8;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class a0 extends w {

    /* renamed from: a, reason: collision with root package name */
    public final Object f5848a;

    public a0(Object obj) {
        q7.k.e(obj, "recordComponent");
        this.f5848a = obj;
    }

    @Override // l8.w
    public final Member b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object obj = this.f5848a;
        q7.k.e(obj, "recordComponent");
        a aVar = s7.a.f9510a;
        Method method = null;
        if (aVar == null) {
            Class<?> cls = obj.getClass();
            try {
                aVar = new a(cls.getMethod("getType", null), cls.getMethod("getAccessor", null));
            } catch (NoSuchMethodException unused) {
                aVar = new a(null, null);
            }
            s7.a.f9510a = aVar;
        }
        Method method2 = aVar.f5847b;
        if (method2 != null) {
            Object objInvoke = method2.invoke(obj, null);
            q7.k.c(objInvoke, "null cannot be cast to non-null type java.lang.reflect.Method");
            method = (Method) objInvoke;
        }
        if (method != null) {
            return method;
        }
        throw new NoSuchMethodError("Can't find `getAccessor` method");
    }

    public final v8.d f() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object obj = this.f5848a;
        q7.k.e(obj, "recordComponent");
        a aVar = s7.a.f9510a;
        Class cls = null;
        if (aVar == null) {
            Class<?> cls2 = obj.getClass();
            try {
                aVar = new a(cls2.getMethod("getType", null), cls2.getMethod("getAccessor", null));
            } catch (NoSuchMethodException unused) {
                aVar = new a(null, null);
            }
            s7.a.f9510a = aVar;
        }
        Method method = aVar.f5846a;
        if (method != null) {
            Object objInvoke = method.invoke(obj, null);
            q7.k.c(objInvoke, "null cannot be cast to non-null type java.lang.Class<*>");
            cls = (Class) objInvoke;
        }
        if (cls != null) {
            return new q(cls);
        }
        throw new NoSuchMethodError("Can't find `getType` method");
    }
}
