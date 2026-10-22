package k7;

import java.lang.reflect.Method;
import q7.k;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f5648a;

    /* renamed from: b, reason: collision with root package name */
    public static final Method f5649b;

    static {
        Method method;
        Method method2;
        Method[] methods = Throwable.class.getMethods();
        k.b(methods);
        int length = methods.length;
        int i2 = 0;
        int i10 = 0;
        while (true) {
            method = null;
            if (i10 >= length) {
                method2 = null;
                break;
            }
            method2 = methods[i10];
            if (k.a(method2.getName(), "addSuppressed")) {
                Class<?>[] parameterTypes = method2.getParameterTypes();
                k.d(parameterTypes, "getParameterTypes(...)");
                if (k.a(parameterTypes.length == 1 ? parameterTypes[0] : null, Throwable.class)) {
                    break;
                }
            }
            i10++;
        }
        f5648a = method2;
        int length2 = methods.length;
        while (true) {
            if (i2 >= length2) {
                break;
            }
            Method method3 = methods[i2];
            if (k.a(method3.getName(), "getSuppressed")) {
                method = method3;
                break;
            }
            i2++;
        }
        f5649b = method;
    }
}
