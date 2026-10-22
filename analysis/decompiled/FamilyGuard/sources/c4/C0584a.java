package c4;

import W3.C0396g;
import j4.k;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import n4.AbstractC0886c;
import n4.C0885b;

/* renamed from: c4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0584a {

    /* renamed from: c4.a$a, reason: collision with other inner class name */
    private static final class C0158a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0158a f11976a = new C0158a();

        /* renamed from: b, reason: collision with root package name */
        public static final Method f11977b;

        /* renamed from: c, reason: collision with root package name */
        public static final Method f11978c;

        static {
            Method method;
            Method method2;
            Method[] methods = Throwable.class.getMethods();
            k.d(methods);
            int length = methods.length;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                method = null;
                if (i6 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i6];
                if (k.b(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    k.f(parameterTypes, "getParameterTypes(...)");
                    if (k.b(C0396g.t(parameterTypes), Throwable.class)) {
                        break;
                    }
                }
                i6++;
            }
            f11977b = method2;
            int length2 = methods.length;
            while (true) {
                if (i5 >= length2) {
                    break;
                }
                Method method3 = methods[i5];
                if (k.b(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i5++;
            }
            f11978c = method;
        }

        private C0158a() {
        }
    }

    public void a(Throwable th, Throwable th2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        k.g(th, "cause");
        k.g(th2, "exception");
        Method method = C0158a.f11977b;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    public AbstractC0886c b() {
        return new C0885b();
    }
}
