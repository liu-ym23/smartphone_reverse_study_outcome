package L7;

import java.lang.reflect.Method;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f937a;
    public static final Method b;

    static {
        Method method;
        Method method2;
        Method[] methods = Throwable.class.getMethods();
        k.c(methods);
        int length = methods.length;
        int i = 0;
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
                k.e(parameterTypes, "getParameterTypes(...)");
                if (k.b(parameterTypes.length == 1 ? parameterTypes[0] : null, Throwable.class)) {
                    break;
                }
            }
            i6++;
        }
        f937a = method2;
        int length2 = methods.length;
        while (true) {
            if (i >= length2) {
                break;
            }
            Method method3 = methods[i];
            if (k.b(method3.getName(), "getSuppressed")) {
                method = method3;
                break;
            }
            i++;
        }
        b = method;
    }
}
