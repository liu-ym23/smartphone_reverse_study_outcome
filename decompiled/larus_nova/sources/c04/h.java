package c04;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes14.dex */
public final class h {

    public static class a<T> implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<T> f21926a;

        public a(T r100) {
            this.f21926a = new WeakReference(r100);
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r100, Method r101, Object[] r102) throws Throwable {
            T r103 = this.f21926a.get();
            if (r103 != null) goto L7;
            return null;
        L7:
            return r101.invoke(r103, r102);
        }
    }

    public static <T> T a(T r100) {
        if (r100 != null) goto L12;
        return null;
    L12:
        Class<?> r101 = r100.getClass();     // Catch: Throwable -> L11
        Class<?>[] r102 = r101.getInterfaces();     // Catch: Throwable -> L11
        if (r102 != null) goto L8;
        return r100;
    L8:
        if (r102.length <= 0) goto L15;
        return (T) Proxy.newProxyInstance(r101.getClassLoader(), r102, new a(r100));
    L15:
        return r100;
    L16:
        return r100;
    }
}
