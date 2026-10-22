package yc;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* loaded from: classes5.dex */
public abstract class x<T> {
    public static <T> x<T> b(w wVar, Class<?> cls, Method method) {
        u uVarB = u.b(wVar, cls, method);
        Type genericReturnType = method.getGenericReturnType();
        if (A.j(genericReturnType)) {
            throw A.n(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
        }
        if (genericReturnType != Void.TYPE) {
            return m.f(wVar, method, uVarB);
        }
        throw A.n(method, "Service methods cannot return void.", new Object[0]);
    }

    public abstract T a(Object obj, Object[] objArr);
}
