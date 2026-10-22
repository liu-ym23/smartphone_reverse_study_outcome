package n8;

import g1.AbstractC1451a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import k2.C1621a;
import x8.InterfaceC2121d;

/* loaded from: classes4.dex */
public final class t extends p {

    /* renamed from: a, reason: collision with root package name */
    public final Object f5365a;

    public t(Object recordComponent) {
        kotlin.jvm.internal.k.f(recordComponent, "recordComponent");
        this.f5365a = recordComponent;
    }

    @Override // n8.p
    public final Member b() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object recordComponent = this.f5365a;
        kotlin.jvm.internal.k.f(recordComponent, "recordComponent");
        C1621a c1621a = AbstractC1451a.f4475x;
        Method method = null;
        if (c1621a == null) {
            Class<?> cls = recordComponent.getClass();
            try {
                c1621a = new C1621a(cls.getMethod("getType", null), cls.getMethod("getAccessor", null));
            } catch (NoSuchMethodException unused) {
                c1621a = new C1621a(method, method);
            }
            AbstractC1451a.f4475x = c1621a;
        }
        Method method2 = (Method) c1621a.b;
        if (method2 != null) {
            Object objInvoke = method2.invoke(recordComponent, null);
            kotlin.jvm.internal.k.d(objInvoke, "null cannot be cast to non-null type java.lang.reflect.Method");
            method = (Method) objInvoke;
        }
        if (method != null) {
            return method;
        }
        throw new NoSuchMethodError("Can't find `getAccessor` method");
    }

    public final InterfaceC2121d f() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object recordComponent = this.f5365a;
        kotlin.jvm.internal.k.f(recordComponent, "recordComponent");
        C1621a c1621a = AbstractC1451a.f4475x;
        Class cls = null;
        if (c1621a == null) {
            Class<?> cls2 = recordComponent.getClass();
            try {
                c1621a = new C1621a(cls2.getMethod("getType", null), cls2.getMethod("getAccessor", null));
            } catch (NoSuchMethodException unused) {
                c1621a = new C1621a(cls, cls);
            }
            AbstractC1451a.f4475x = c1621a;
        }
        Method method = (Method) c1621a.f4793a;
        if (method != null) {
            Object objInvoke = method.invoke(recordComponent, null);
            kotlin.jvm.internal.k.d(objInvoke, "null cannot be cast to non-null type java.lang.Class<*>");
            cls = (Class) objInvoke;
        }
        if (cls != null) {
            return new j(cls);
        }
        throw new NoSuchMethodError("Can't find `getType` method");
    }
}
